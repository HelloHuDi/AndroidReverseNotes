package com.tencent.mm.plugin.fingerprint;

public class FingerPrintAuth {
    public static native void clearData(String str, String str2, int i);

    public static native String genOpenFPEncrypt(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    public static native String genOpenFPSign(String str, String str2, String str3, String str4);

    public static native String genPayFPEncrypt(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public static native String genPayFPSign(String str, String str2, String str3, String str4);

    public static native String genRsaKey(String str, String str2, String str3);

    public static native String getFingerPrintId(String str, String str2);

    public static native String getRsaKey(String str, String str2, String str3);

    public static native String getX509Csr(String str);

    public static native boolean importCert(String str, String str2);

    public static native int saveX509Csr(String str, String str2);
}
