package com.tencent.p177mm.wallet_core.p649c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tenpay.ndk.CertUtil;
import com.tenpay.ndk.MessageDigestUtil;

/* renamed from: com.tencent.mm.wallet_core.c.b */
public final class C40928b {
    private static C40928b Afj = null;
    static boolean bZi = false;
    private boolean Afk = false;

    public static C40928b dNJ() {
        AppMethodBeat.m2504i(49022);
        if (Afj == null) {
            Afj = new C40928b();
        }
        C40928b c40928b = Afj;
        AppMethodBeat.m2505o(49022);
        return c40928b;
    }

    public static void init(Context context) {
        AppMethodBeat.m2504i(49023);
        if (bZi) {
            AppMethodBeat.m2505o(49023);
            return;
        }
        C4990ab.m7411d("MicroMsg.CertUtilWx", "init  %s", C5046bo.dpG().toString());
        CertUtil.getInstance().init(context);
        bZi = true;
        AppMethodBeat.m2505o(49023);
    }

    /* renamed from: eJ */
    public final String mo64554eJ(String str, int i) {
        String str2;
        AppMethodBeat.m2504i(49024);
        C4990ab.m7417i("MicroMsg.CertUtilWx", "getCertApplyCSR lock %s %s", C5046bo.dpG().toString(), Integer.valueOf(i));
        synchronized (this) {
            try {
                if (this.Afk) {
                    C4990ab.m7416i("MicroMsg.CertUtilWx", "isCert_Wating");
                    str2 = "";
                } else {
                    this.Afk = true;
                    str2 = CertUtil.getInstance().getCertApplyCSR(str, i);
                    AppMethodBeat.m2505o(49024);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(49024);
            }
        }
        return str2;
    }

    public final boolean importCert(String str, String str2) {
        boolean importCert;
        AppMethodBeat.m2504i(49025);
        C4990ab.m7417i("MicroMsg.CertUtilWx", "importCert  cid %s cert %s stack %s", str, str2, C5046bo.dpG().toString());
        synchronized (this) {
            try {
                this.Afk = false;
                importCert = CertUtil.getInstance().importCert(str, str2);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(49025);
            }
        }
        C4990ab.m7417i("MicroMsg.CertUtilWx", "importCert %s", Boolean.valueOf(importCert));
        return importCert;
    }

    public final boolean dNK() {
        AppMethodBeat.m2504i(49026);
        C4990ab.m7410d("MicroMsg.CertUtilWx", "importCertNone");
        synchronized (this) {
            try {
                this.Afk = false;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(49026);
            }
        }
        return false;
    }

    public static boolean isCertExist(String str) {
        AppMethodBeat.m2504i(49027);
        C4990ab.m7411d("MicroMsg.CertUtilWx", "isCertExist stack %s", C5046bo.dpG().toString());
        C7060h.pYm.mo8378a(414, 5, 1, true);
        boolean isCertExist = CertUtil.getInstance().isCertExist(str);
        C7060h.pYm.mo8378a(414, 6, 1, true);
        AppMethodBeat.m2505o(49027);
        return isCertExist;
    }

    public static String genUserSig(String str, String str2) {
        AppMethodBeat.m2504i(49028);
        C4990ab.m7411d("MicroMsg.CertUtilWx", "genUserSig stack %s", C5046bo.dpG().toString());
        String genUserSig = CertUtil.getInstance().genUserSig(str, str2);
        AppMethodBeat.m2505o(49028);
        return genUserSig;
    }

    /* renamed from: F */
    public static boolean m70952F(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(49029);
        String str3 = "";
        if (z) {
            MessageDigestUtil messageDigestUtil = new MessageDigestUtil();
            C1720g.m3537RQ();
            C1720g.m3534RN();
            byte[] bArr = new byte[16];
            byte[] bytes = messageDigestUtil.getSHA256Hex((C1183p.getString(C1668a.m3383QF()) + "_pUI6cNqzLt2Z3mQSrYuF09XSGsBtTIcUgp9jcWZ7F7BBs8/DFVFMKiwbtaRPOiLE").getBytes()).getBytes();
            int i = 0;
            while (i < 16 && i < bytes.length) {
                bArr[i] = bytes[i];
                i++;
            }
            str3 = new String(bArr);
        }
        C4990ab.m7411d("MicroMsg.CertUtilWx", "setTokens stack v2 useSm4 %s sm4Key %s %s", Boolean.valueOf(z), str3, C5046bo.dpG().toString());
        C4990ab.m7411d("MicroMsg.CertUtilWx", "setTokens result ret:%s", Boolean.valueOf(CertUtil.getInstance().setTokens(str, str2, z, str3)));
        AppMethodBeat.m2505o(49029);
        return CertUtil.getInstance().setTokens(str, str2, z, str3);
    }

    public static String getToken(String str) {
        AppMethodBeat.m2504i(49030);
        C4990ab.m7411d("MicroMsg.CertUtilWx", "getToken stack %s", C5046bo.dpG().toString());
        String token = CertUtil.getInstance().getToken(str);
        AppMethodBeat.m2505o(49030);
        return token;
    }

    public static void clearToken(String str) {
        AppMethodBeat.m2504i(49031);
        C4990ab.m7411d("MicroMsg.CertUtilWx", "clearToken stack %s", C5046bo.dpG().toString());
        CertUtil.getInstance().clearToken(str);
        AppMethodBeat.m2505o(49031);
    }

    public static int atn(String str) {
        AppMethodBeat.m2504i(49032);
        C4990ab.m7411d("MicroMsg.CertUtilWx", "getTokenCount ret: %d stack %s", Integer.valueOf(CertUtil.getInstance().getTokenCount(str)), C5046bo.dpG().toString());
        AppMethodBeat.m2505o(49032);
        return CertUtil.getInstance().getTokenCount(str);
    }

    public static int getLastError() {
        AppMethodBeat.m2504i(49033);
        C4990ab.m7411d("MicroMsg.CertUtilWx", "getLastError stack %s", C5046bo.dpG().toString());
        int lastError = CertUtil.getInstance().getLastError();
        AppMethodBeat.m2505o(49033);
        return lastError;
    }

    public static void clearCert(String str) {
        AppMethodBeat.m2504i(49034);
        C4990ab.m7411d("MicroMsg.CertUtilWx", "clearCert stack %s", C5046bo.dpG().toString());
        CertUtil.getInstance().clearCert(str);
        AppMethodBeat.m2505o(49034);
    }

    public static void clean() {
        AppMethodBeat.m2504i(49035);
        C4990ab.m7411d("MicroMsg.CertUtilWx", "clean allcrt stack %s", C5046bo.dpG().toString());
        CertUtil.getInstance().clearAllCert();
        AppMethodBeat.m2505o(49035);
    }
}
