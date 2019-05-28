package com.tencent.mm.protocal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class f {
    private static byte[] vxA;
    private static byte[] vxB;
    public static int vxC;
    private static long vxD = 0;
    public static boolean vxx;
    public static boolean vxy;
    private static int vxz;

    static {
        AppMethodBeat.i(58794);
        vxx = false;
        vxy = false;
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("auth_info_key_prefs", h.Mu());
        vxx = sharedPreferences.getBoolean("auth_info_prefs_use_new_ecdh", true);
        vxy = sharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
        ab.i("MicroMsg.EcdhMgr", "summerauths USE_ECDH[%s] USE_ML[%s]", Boolean.valueOf(vxx), Boolean.valueOf(vxy));
        if (vxy) {
            vxC = 10001;
            vxz = 415;
            vxA = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
            vxB = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
        } else {
            vxC = 10002;
            vxz = 415;
            vxA = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
            vxB = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
        }
        AppMethodBeat.o(58794);
    }

    public static long bK(byte[] bArr) {
        AppMethodBeat.i(58791);
        long CreateHybridEcdhCryptoEngine = UtilsJni.CreateHybridEcdhCryptoEngine(vxz, vxA, vxB, bArr);
        String str = "MicroMsg.EcdhMgr";
        String str2 = "summerauths getHybridEcdhCryptoEngine engine[%s] autoauth_key[%s] nid[%s] stack[%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(CreateHybridEcdhCryptoEngine);
        objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[2] = Integer.valueOf(vxz);
        objArr[3] = bo.dpG();
        ab.i(str, str2, objArr);
        AppMethodBeat.o(58791);
        return CreateHybridEcdhCryptoEngine;
    }

    public static void me(long j) {
        AppMethodBeat.i(58792);
        UtilsJni.ReleaseHybridEcdhCryptoEngine(j);
        ab.i("MicroMsg.EcdhMgr", "summerauths releaseHybridEcdhCryptoEngine engine[%s] stack[%s]", Long.valueOf(j), bo.dpG());
        AppMethodBeat.o(58792);
    }

    public static synchronized boolean dmh() {
        boolean z = false;
        synchronized (f.class) {
            AppMethodBeat.i(58793);
            ab.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME[%s] old USE_ML[%s] stack[%s]", Long.valueOf(vxD), Boolean.valueOf(vxy), bo.dpG());
            if (600000 < SystemClock.elapsedRealtime() - vxD || vxD <= 0) {
                vxD = SystemClock.elapsedRealtime();
                if (!vxy) {
                    z = true;
                }
                vxy = z;
                SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("auth_info_key_prefs", h.Mu());
                z = sharedPreferences.edit().putBoolean("auth_info_prefs_use_net_ml_cert", vxy).commit();
                sharedPreferences.getBoolean("auth_info_prefs_use_net_ml_cert", false);
                ab.i("MicroMsg.EcdhMgr", "summerauths switchCert to [%s] save sp[%s]", Boolean.valueOf(vxy), Boolean.valueOf(z));
                if (vxy) {
                    vxC = 10001;
                    vxz = 415;
                    vxA = Base64.decode("BJO0cjvgelbYHm8ZlKVVl63oMbeMYLjIqaWtZWvBBTSm7PzWslBMy8loLcnG9dITvDzD6YpddZdH1PnHxG8Kpvo=", 0);
                    vxB = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFQ0JvQVdmMC84ZVJEL0NKeWIxU3RKckhPeVcyVwo2Z3ZjaUh1TTZOZk82cWhLNDJKTjZSRmxucEtZbVAyTlBYbnd3L05VVFpMM05Qa3FZVEh2Q1AwSmtnPT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
                } else {
                    vxC = 10002;
                    vxz = 415;
                    vxA = Base64.decode("BJW8blwTMa0XLQ81sXksPOY/kVcqvS3W322sLXAZXD9mJ8ymAwcwXYSVqMOLRBbHUCHoI7bJff/nnBTLfDr4pYY=", 0);
                    vxB = Base64.decode("LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUZrd0V3WUhLb1pJemowQ0FRWUlLb1pJemowREFRY0RRZ0FFUkl5eWlLM1M5UDdIVGFLTGVHUDFLemJDQ1E5SQpMU3hFR3hhRlZFNGpuWmU2RnF3dzBKaHc1bUFxYmZXTEs2Tmk4cHV2U1Y2Q3FDK0QyS2VTM3N2cFl3PT0KLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==", 0);
                }
                AppMethodBeat.o(58793);
            } else {
                ab.i("MicroMsg.EcdhMgr", "summerauths switchCert LAST_SWITCH_TIME freq limit [%s]ms ret false", Long.valueOf(r4 - vxD));
                AppMethodBeat.o(58793);
            }
        }
        return z;
    }

    public static byte[] dmi() {
        return vxA;
    }
}
