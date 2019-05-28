package com.tencent.mm.wallet_core.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

public final class a extends PayuSecureEncrypt {
    public a(int i) {
        this.mEncrptType = i;
    }

    public final String desedeEncode(String str, String str2) {
        AppMethodBeat.i(49009);
        String iv = iv(str, str2);
        AppMethodBeat.o(49009);
        return iv;
    }

    public final String desedeVerifyCode(String str, String str2) {
        AppMethodBeat.i(49010);
        String iv = iv(str, str2);
        AppMethodBeat.o(49010);
        return iv;
    }

    public final String encryptPasswd(boolean z, String str, String str2) {
        AppMethodBeat.i(49011);
        String iv = iv(str, str2);
        AppMethodBeat.o(49011);
        return iv;
    }

    private String iv(String str, String str2) {
        AppMethodBeat.i(49012);
        if (!(this.mEncrptType == 40 || this.mEncrptType == -20)) {
            str = str.replaceAll(" ", "");
        }
        switch (this.mEncrptType) {
            case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
            case -10:
            case 60:
                str = g(true, str, str2);
                AppMethodBeat.o(49012);
                return str;
            case 20:
            case 30:
            case 40:
            case 50:
                str = g(false, str, str2);
                AppMethodBeat.o(49012);
                return str;
            default:
                AppMethodBeat.o(49012);
                return str;
        }
    }

    private String g(boolean z, String str, String str2) {
        AppMethodBeat.i(49013);
        int i = this.mEncrptType;
        String str3 = PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT;
        if (-20 == this.mEncrptType) {
            i = 40;
        } else if (-10 == this.mEncrptType) {
            i = 20;
        }
        if (this.mEncrptType == -10 || this.mEncrptType == -20 || this.mEncrptType == 60) {
            str3 = PayuSecureEncrypt.ENCRYPT_VERSION_HASH;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        stringBuilder.append("|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        if (z) {
            stringBuilder.append(ag.ck(str));
        } else {
            stringBuilder.append(str);
        }
        String str4 = null;
        try {
            byte[] bytes = stringBuilder.toString().getBytes();
            PByteArray pByteArray = new PByteArray();
            if (!MMProtocalJni.rsaPublicEncrypt(bytes, pByteArray, getRsaEKey().getBytes("UTF-8"), getRsaNKey().getBytes("UTF-8"))) {
                ab.e("MicroMsg.WxPayuSecureEncrypt", "MMProtocalJni encrypt failed!");
            }
            str4 = "01" + Base64.encodeToString(pByteArray.value, 2);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WxPayuSecureEncrypt", e, "", new Object[0]);
        }
        AppMethodBeat.o(49013);
        return str4;
    }
}
