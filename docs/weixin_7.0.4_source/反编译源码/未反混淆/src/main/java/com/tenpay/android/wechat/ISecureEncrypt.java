package com.tenpay.android.wechat;

public interface ISecureEncrypt {
    String desedeEncode(String str, String str2);

    String desedeVerifyCode(String str, String str2);

    String encryptPasswd(boolean z, String str, String str2);

    String encryptPasswdWithRSA2048(boolean z, String str, String str2);
}
