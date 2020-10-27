package com.neet.qb.controller;

import com.monitorjbl.json.JsonResult;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.Match;
import com.neet.qb.model.ResponseMessage;
import com.neet.qb.util.AppConstants;
import com.neet.qb.util.AttributeProvider;
import com.neet.qb.util.FieldConstants;

import java.util.List;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * @author Phaninder
 * 
 */
@ApiIgnore
public class BaseController {

  private JsonResult json = JsonResult.instance();

  private <T> T adjustFields(T data, Class<T> clazz, String[] excludeFields,
      String[] includeFields) {
    return json.use(JsonView.with(data)
        .onClass(clazz, Match.match()
            .exclude(excludeFields)
            .include(includeFields)))
        .returnValue();
  }

  private <T> List<T> adjustFields(List<T> data, Class<T> clazz,
      String[] excludeFields,
      String[] includeFields) {
    return json.use(JsonView.with(data)
        .onClass(clazz, Match.match()
            .exclude(excludeFields)
            .include(includeFields)))
        .returnValue();
  }

  protected <T> List<T> limitDataFields(List<T> data, Class<T> clazz, String fields) {
    return adjustFields(data, clazz, FieldConstants.EXCLUDEALL_FIELDS,
        AttributeProvider.provideFields(clazz, fields));
  }

  protected <T> List<T> limitDataFields(List<T> data, Class<T> clazz) {
    return adjustFields(data, clazz, FieldConstants.EXCLUDEALL_FIELDS,
        AttributeProvider.provideFields(clazz, ""));
  }

  protected <T> T limitDataFields(T data, Class<T> clazz, String fields) {
    return adjustFields(data, clazz, FieldConstants.EXCLUDEALL_FIELDS,
        AttributeProvider.provideFields(clazz, fields));
  }

  protected <T> T limitDataFields(T data, Class<T> clazz) {
    return adjustFields(data, clazz, FieldConstants.EXCLUDEALL_FIELDS,
        AttributeProvider.provideFields(clazz, ""));
  }

  protected ResponseMessage success(String message) {
    return new ResponseMessage(AppConstants.SUCCESS, message);
  }

}
