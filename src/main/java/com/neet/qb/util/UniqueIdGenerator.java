package com.neet.qb.util;

import java.util.UUID;

/**
 * Created by Phaninder
 */
public final class UniqueIdGenerator {

  private UniqueIdGenerator() {
  }

  public static String generate() {
    return UUID.randomUUID().toString();
  }
}
