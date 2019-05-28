package com.tencent.p177mm.offlineutil;

/* renamed from: com.tencent.mm.offlineutil.OfflineUtilJni */
public class OfflineUtilJni {
    public static native char[] CheckSumWithBase91(String str);

    public static native String DecodeBase91(String str);

    public static native String EncodeBase91(String str);

    public static native String GenOffLineQrcode(String str, byte[] bArr);
}
