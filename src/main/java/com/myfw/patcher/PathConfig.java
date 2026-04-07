package com.myfw.patcher;

import java.io.File;

public class PathConfig {
    private String pathOri;
    private static String pathMod;

    public PathConfig() {
        String currentPath = new java.io.File("").getAbsolutePath();
        pathOri = new java.io.File(currentPath + "/tmp/ori").getAbsolutePath();
        pathMod = new java.io.File(currentPath + "/tmp/mod").getAbsolutePath();
    }

    public static PathConfig init() {
        return new PathConfig();
    }

    public String getPathOri(String classPath) {
        return new File(pathOri, classPath).getAbsolutePath();
    }

    public String getPathMod(String classPath) {
        return new File(pathMod, classPath).getAbsolutePath();
    }
}
