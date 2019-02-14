package org.tinywind.server.config;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String DEFAULT_TIMEZONE = "Asia/Seoul";
    public static final String BASE_PACKAGE = "org.tinywind.server";
    public static final String BASE_MODEL_PACKAGE = BASE_PACKAGE + ".model";
    public static final String REPOSITORY_PACKAGE = BASE_PACKAGE + ".repository";
    public static final List<String> MYBATIS_MODEL_PACKAGES = Arrays.asList(
            BASE_MODEL_PACKAGE,
            BASE_MODEL_PACKAGE + ".tables.pojos",
            BASE_MODEL_PACKAGE + ".form",
            BASE_MODEL_PACKAGE + ".search",
            BASE_MODEL_PACKAGE + ".resolved"
    );
}
