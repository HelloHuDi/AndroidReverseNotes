package com.tenpay.android.wechat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public final class TenpaySecureEncrypt implements ISecureEncrypt {
    public final String encryptPasswdWithRSA2048(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(49503);
        if (z) {
            str = TenpayUtil.md5HexDigest(str);
        }
        Encrypt encrypt = new Encrypt();
        if (str2 != null) {
            encrypt.setTimeStamp(str2);
        }
        String encryptPasswdWithRSA2048 = encrypt.encryptPasswdWithRSA2048(str);
        AppMethodBeat.m2505o(49503);
        return encryptPasswdWithRSA2048;
    }

    public final String encryptPasswd(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(49504);
        if (z) {
            str = TenpayUtil.md5HexDigest(str);
        }
        Encrypt encrypt = new Encrypt();
        if (str2 != null) {
            encrypt.setTimeStamp(str2);
        }
        String encryptPasswd = encrypt.encryptPasswd(str);
        AppMethodBeat.m2505o(49504);
        return encryptPasswd;
    }

    public final String desedeEncode(String str, String str2) {
        AppMethodBeat.m2504i(49505);
        String desedeEncode = new Encrypt().desedeEncode(str);
        AppMethodBeat.m2505o(49505);
        return desedeEncode;
    }

    public final String desedeVerifyCode(String str, String str2) {
        AppMethodBeat.m2504i(49506);
        String desedeVerifyCode = new Encrypt().desedeVerifyCode(str);
        AppMethodBeat.m2505o(49506);
        return desedeVerifyCode;
    }
}
