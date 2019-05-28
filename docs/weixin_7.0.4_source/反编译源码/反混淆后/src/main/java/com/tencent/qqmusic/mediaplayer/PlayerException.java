package com.tencent.qqmusic.mediaplayer;

public class PlayerException {
    public static final int EXCEPTION_FILE_READ_EMPTY = 100;
    public static final int EXCEPTION_IN_BASEMETHOD = 99;
    public static final int EXCEPTION_IN_CHECK_STATE = 89;
    public static final int EXCEPTION_IN_PAUSE = 93;
    public static final int EXCEPTION_IN_PREPARE = 91;
    public static final int EXCEPTION_IN_RELEASE = 97;
    public static final int EXCEPTION_IN_RESET = 98;
    public static final int EXCEPTION_IN_SEEK = 95;
    public static final int EXCEPTION_IN_SETAUDIOEFFECT = 96;
    public static final int EXCEPTION_IN_SETDATASOURCE = 90;
    public static final int EXCEPTION_IN_START = 92;
    public static final int EXCEPTION_IN_STOP = 94;
    public static final int EXCEPTION_TYPE_CONNECT_FAIL = 80;
    public static final int EXCEPTION_TYPE_CREATAUDIOTRACK = 66;
    public static final int EXCEPTION_TYPE_CREATE_BUFFER_FILE = 103;
    public static final int EXCEPTION_TYPE_DECODE = 67;
    public static final int EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE = 82;
    public static final int EXCEPTION_TYPE_ERROR_CREATE_NATIVE_DATASOURCE = 81;
    public static final int EXCEPTION_TYPE_ERROR_FILE = 70;
    public static final int EXCEPTION_TYPE_ERROR_OPEN_JAVA_DATASOURCE = 83;
    public static final int EXCEPTION_TYPE_FILECANNOTREAD = 54;
    public static final int EXCEPTION_TYPE_FILENOTFOUND = 53;
    public static final int EXCEPTION_TYPE_GETAUDIOINFO = 63;
    public static final int EXCEPTION_TYPE_ILLEGAL_STATE = 104;
    public static final int EXCEPTION_TYPE_INITLIB = 61;
    public static final int EXCEPTION_TYPE_INVALIDAUDIOINFO = 64;
    public static final int EXCEPTION_TYPE_INVALIDSEEK = 74;
    public static final int EXCEPTION_TYPE_IO = 51;
    public static final int EXCEPTION_TYPE_LOADLIB = 60;
    public static final int EXCEPTION_TYPE_MALFORMED = 50;
    public static final int EXCEPTION_TYPE_NATIVEOPEN = 62;
    public static final int EXCEPTION_TYPE_NULLPOINTER = 52;
    public static final int EXCEPTION_TYPE_RECOGNTION_ERROR = 101;
    public static final int EXCEPTION_TYPE_SO_NOT_FOUND = 69;
    public static final int EXCEPTION_TYPE_UNKNOWFORMAT = 55;
    public static final int EXCEPTION_TYPE_UNSUPPORTAUDIOINFO = 65;
    public static final int EXCEPTION_TYPE_WRITE_AUDIOTRACK = 102;

    public static boolean isDecodeError(int i) {
        return i == 67 || i == 62 || i == 63 || i == 64 || i == 101 || i == 74;
    }

    public static boolean isRendererError(int i) {
        return i == 66 || i == 102 || i == 54;
    }

    public static boolean isIOError(int i) {
        return i == 103 || i == 53;
    }

    public static boolean isNetworkError(int i) {
        return i == 80;
    }
}
