package com.neet.qb.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.util.StringUtils;

import com.neet.qb.annotation.DefaultField;

/**
 * Created by Phaninder
 */

public final class AttributeProvider {

  private AttributeProvider() {
  }

  public static String[] provideFields(Class clazz, final String fields) {
    Set<String> finalFields = new HashSet<>();
    if (!StringUtils.isEmpty(fields)) {
      finalFields.addAll(Arrays.asList(fields.split(",")));
    }
    getDefaultFields(finalFields, clazz, "");
    return finalFields.toArray(new String[finalFields.size()]);
  }

  /**
   * Fetch all the fields marked with @DefaultField annotations using reflection and set into the
   * collection passed to method.
   */
  private static void getDefaultFields(Set<String> finalFields, Class clazz, String parentField) {
    Field[] defaultFields = FieldUtils.getFieldsWithAnnotation(clazz, DefaultField.class);
    if (defaultFields != null) {
      for (Field field : defaultFields) {
        String fieldName = field.getName();

        // take care of fields, marked not to deserialize but requested by user
        if (!field.getAnnotation(DefaultField.class).serialize()) {
          finalFields.remove(fieldName);
          continue;
        }

        if (isCustomObject(field)) {
          getDefaultFields(finalFields, field.getType(), fieldName);
        } else {
          fieldName = (!StringUtils.isEmpty(parentField)) ? parentField + "." + fieldName
              : fieldName;
          finalFields.add(fieldName);
        }
      }
    }
  }

  private static boolean isCustomObject(Field field) {
    return field.getType().getName().startsWith("com.neet.qb");
  }

}
