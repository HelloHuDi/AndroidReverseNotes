package com.tencent.mm.wallet_core.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.ndk.CertUtil;
import com.tenpay.ndk.MessageDigestUtil;

public final class b {
    private static b Afj = null;
    static boolean bZi = false;
    private boolean Afk = false;

    public static b dNJ() {
        AppMethodBeat.i(49022);
        if (Afj == null) {
            Afj = new b();
        }
        b bVar = Afj;
        AppMethodBeat.o(49022);
        return bVar;
    }

    public static void init(Context context) {
        AppMethodBeat.i(49023);
        if (bZi) {
            AppMethodBeat.o(49023);
            return;
        }
        ab.d("MicroMsg.CertUtilWx", "init  %s", bo.dpG().toString());
        CertUtil.getInstance().init(context);
        bZi = true;
        AppMethodBeat.o(49023);
    }

    public final String eJ(String str, int i) {
        String str2;
        AppMethodBeat.i(49024);
        ab.i("MicroMsg.CertUtilWx", "getCertApplyCSR lock %s %s", bo.dpG().toString(), Integer.valueOf(i));
        synchronized (this) {
            try {
                if (this.Afk) {
                    ab.i("MicroMsg.CertUtilWx", "isCert_Wating");
                    str2 = "";
                } else {
                    this.Afk = true;
                    str2 = CertUtil.getInstance().getCertApplyCSR(str, i);
                    AppMethodBeat.o(49024);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(49024);
            }
        }
        return str2;
    }

    public final boolean importCert(String str, String str2) {
        boolean importCert;
        AppMethodBeat.i(49025);
        ab.i("MicroMsg.CertUtilWx", "importCert  cid %s cert %s stack %s", str, str2, bo.dpG().toString());
        synchronized (this) {
            try {
                this.Afk = false;
                importCert = CertUtil.getInstance().importCert(str, str2);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(49025);
            }
        }
        ab.i("MicroMsg.CertUtilWx", "importCert %s", Boolean.valueOf(importCert));
        return importCert;
    }

    public final boolean dNK() {
        AppMethodBeat.i(49026);
        ab.d("MicroMsg.CertUtilWx", "importCertNone");
        synchronized (this) {
            try {
                this.Afk = false;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(49026);
            }
        }
        return false;
    }

    public static boolean isCertExist(String str) {
        AppMethodBeat.i(49027);
        ab.d("MicroMsg.CertUtilWx", "isCertExist stack %s", bo.dpG().toString());
        h.pYm.a(414, 5, 1, true);
        boolean isCertExist = CertUtil.getInstance().isCertExist(str);
        h.pYm.a(414, 6, 1, true);
        AppMethodBeat.o(49027);
        return isCertExist;
    }

    public static String genUserSig(String str, String str2) {
        AppMethodBeat.i(49028);
        ab.d("MicroMsg.CertUtilWx", "genUserSig stack %s", bo.dpG().toString());
        String genUserSig = CertUtil.getInstance().genUserSig(str, str2);
        AppMethodBeat.o(49028);
        return genUserSig;
    }

    public static boolean F(String str, String str2, boolean z) {
        AppMethodBeat.i(49029);
        String str3 = "";
        if (z) {
            MessageDigestUtil messageDigestUtil = new MessageDigestUtil();
            g.RQ();
            g.RN();
            byte[] bArr = new byte[16];
            byte[] bytes = messageDigestUtil.getSHA256Hex((p.getString(a.QF()) + "_pUI6cNqzLt2Z3mQSrYuF09XSGsBtTIcUgp9jcWZ7F7BBs8/DFVFMKiwbtaRPOiLE").getBytes()).getBytes();
            int i = 0;
            while (i < 16 && i < bytes.length) {
                bArr[i] = bytes[i];
                i++;
            }
            str3 = new String(bArr);
        }
        ab.d("MicroMsg.CertUtilWx", "setTokens stack v2 useSm4 %s sm4Key %s %s", Boolean.valueOf(z), str3, bo.dpG().toString());
        ab.d("MicroMsg.CertUtilWx", "setTokens result ret:%s", Boolean.valueOf(CertUtil.getInstance().setTokens(str, str2, z, str3)));
        AppMethodBeat.o(49029);
        return CertUtil.getInstance().setTokens(str, str2, z, str3);
    }

    public static String getToken(String str) {
        AppMethodBeat.i(49030);
        ab.d("MicroMsg.CertUtilWx", "getToken stack %s", bo.dpG().toString());
        String token = CertUtil.getInstance().getToken(str);
        AppMethodBeat.o(49030);
        return token;
    }

    public static void clearToken(String str) {
        AppMethodBeat.i(49031);
        ab.d("MicroMsg.CertUtilWx", "clearToken stack %s", bo.dpG().toString());
        CertUtil.getInstance().clearToken(str);
        AppMethodBeat.o(49031);
    }

    public static int atn(String str) {
        AppMethodBeat.i(49032);
        ab.d("MicroMsg.CertUtilWx", "getTokenCount ret: %d stack %s", Integer.valueOf(CertUtil.getInstance().getTokenCount(str)), bo.dpG().toString());
        AppMethodBeat.o(49032);
        return CertUtil.getInstance().getTokenCount(str);
    }

    public static int getLastError() {
        AppMethodBeat.i(49033);
        ab.d("MicroMsg.CertUtilWx", "getLastError stack %s", bo.dpG().toString());
        int lastError = CertUtil.getInstance().getLastError();
        AppMethodBeat.o(49033);
        return lastError;
    }

    public static void clearCert(String str) {
        AppMethodBeat.i(49034);
        ab.d("MicroMsg.CertUtilWx", "clearCert stack %s", bo.dpG().toString());
        CertUtil.getInstance().clearCert(str);
        AppMethodBeat.o(49034);
    }

    public static void clean() {
        AppMethodBeat.i(49035);
        ab.d("MicroMsg.CertUtilWx", "clean allcrt stack %s", bo.dpG().toString());
        CertUtil.getInstance().clearAllCert();
        AppMethodBeat.o(49035);
    }
}
