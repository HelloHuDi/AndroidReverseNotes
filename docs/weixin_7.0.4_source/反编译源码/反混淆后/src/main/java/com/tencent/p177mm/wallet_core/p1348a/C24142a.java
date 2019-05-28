package com.tencent.p177mm.wallet_core.p1348a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pointers.PByteArray;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

/* renamed from: com.tencent.mm.wallet_core.a.a */
public final class C24142a extends PayuSecureEncrypt {
    public C24142a(int i) {
        this.mEncrptType = i;
    }

    public final String desedeEncode(String str, String str2) {
        AppMethodBeat.m2504i(49009);
        String iv = m37104iv(str, str2);
        AppMethodBeat.m2505o(49009);
        return iv;
    }

    public final String desedeVerifyCode(String str, String str2) {
        AppMethodBeat.m2504i(49010);
        String iv = m37104iv(str, str2);
        AppMethodBeat.m2505o(49010);
        return iv;
    }

    public final String encryptPasswd(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(49011);
        String iv = m37104iv(str, str2);
        AppMethodBeat.m2505o(49011);
        return iv;
    }

    /* renamed from: iv */
    private String m37104iv(String str, String str2) {
        AppMethodBeat.m2504i(49012);
        if (!(this.mEncrptType == 40 || this.mEncrptType == -20)) {
            str = str.replaceAll(" ", "");
        }
        switch (this.mEncrptType) {
            case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
            case -10:
            case 60:
                str = m37103g(true, str, str2);
                AppMethodBeat.m2505o(49012);
                return str;
            case 20:
            case 30:
            case 40:
            case 50:
                str = m37103g(false, str, str2);
                AppMethodBeat.m2505o(49012);
                return str;
            default:
                AppMethodBeat.m2505o(49012);
                return str;
        }
    }

    /* renamed from: g */
    private String m37103g(boolean z, String str, String str2) {
        AppMethodBeat.m2504i(49013);
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
            stringBuilder.append(C4995ag.m7428ck(str));
        } else {
            stringBuilder.append(str);
        }
        String str4 = null;
        try {
            byte[] bytes = stringBuilder.toString().getBytes();
            PByteArray pByteArray = new PByteArray();
            if (!MMProtocalJni.rsaPublicEncrypt(bytes, pByteArray, getRsaEKey().getBytes("UTF-8"), getRsaNKey().getBytes("UTF-8"))) {
                C4990ab.m7412e("MicroMsg.WxPayuSecureEncrypt", "MMProtocalJni encrypt failed!");
            }
            str4 = "01" + Base64.encodeToString(pByteArray.value, 2);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WxPayuSecureEncrypt", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(49013);
        return str4;
    }
}
