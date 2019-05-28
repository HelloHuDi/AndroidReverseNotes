package com.tencent.soter.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.c.b;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;
import com.tencent.soter.core.c.h;
import com.tencent.soter.core.c.i;
import com.tencent.soter.core.c.j;
import com.tencent.soter.core.d.c;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;

public final class a implements b {
    private static boolean AuF = false;
    private static com.tencent.soter.core.d.b AuG = dQM();

    static {
        boolean z = true;
        AppMethodBeat.i(72894);
        d.i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL", new Object[0]);
        String str = "Soter.SoterCore";
        String str2 = "soter: SoterCore is call static block to init SoterCore IMPL, IMPL is null[%b]";
        Object[] objArr = new Object[1];
        if (AuG != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        d.i(str, str2, objArr);
        AppMethodBeat.o(72894);
    }

    public static void bLV() {
        AppMethodBeat.i(72867);
        c.bLV();
        AppMethodBeat.o(72867);
    }

    public static void iO(Context context) {
        AppMethodBeat.i(72868);
        if (AuG == null) {
            d.i("Soter.SoterCore", "soter: SoterCore IMPL is null then call tryToInitSoterTreble to init", new Object[0]);
            com.tencent.soter.core.d.d dVar = new com.tencent.soter.core.d.d();
            AuG = dVar;
            if (!dVar.iV(context)) {
                AuG = null;
                d.i("Soter.SoterCore", "soter: SoterCore IMPL is null after call tryToInitSoterTreble to init", new Object[0]);
            }
        }
        AppMethodBeat.o(72868);
    }

    public static void dQK() {
        boolean z = true;
        AppMethodBeat.i(72869);
        if (AuG == null) {
            d.i("Soter.SoterCore", "soter: SoterCore IMPL is null then call getProviderSoterCore to init", new Object[0]);
            AuG = dQM();
            String str = "Soter.SoterCore";
            String str2 = "soter: SoterCore IMPL is null[%b], after call getProviderSoterCore to init";
            Object[] objArr = new Object[1];
            if (AuG != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            d.i(str, str2, objArr);
        }
        AppMethodBeat.o(72869);
    }

    public static int dQL() {
        AppMethodBeat.i(72870);
        if (AuG == null) {
            AppMethodBeat.o(72870);
            return 0;
        } else if (AuG instanceof com.tencent.soter.core.d.d) {
            d.d("Soter.SoterCore", "getSoterCoreType is TREBLE", new Object[0]);
            AppMethodBeat.o(72870);
            return 1;
        } else {
            d.d("Soter.SoterCore", "getSoterCoreType is not TREBLE", new Object[0]);
            AppMethodBeat.o(72870);
            return 0;
        }
    }

    private static com.tencent.soter.core.d.b dQM() {
        AppMethodBeat.i(72871);
        c.bLV();
        if (h.dQY()) {
            AppMethodBeat.o(72871);
            return null;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            AppMethodBeat.o(72871);
            return null;
        }
        int length = providers.length;
        int i = 0;
        while (i < length) {
            String name = providers[i].getName();
            com.tencent.soter.core.d.b aVar;
            if (name == null || !name.startsWith("SoterKeyStore")) {
                i++;
            } else if (name.split("\\.").length > 1) {
                aVar = new com.tencent.soter.core.d.a(name);
                AppMethodBeat.o(72871);
                return aVar;
            } else {
                aVar = new c(name);
                AppMethodBeat.o(72871);
                return aVar;
            }
        }
        AppMethodBeat.o(72871);
        return null;
    }

    public static boolean dQN() {
        AppMethodBeat.i(72872);
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: isNativeSupportSoter IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(72872);
            return false;
        }
        boolean dQN = AuG.dQN();
        d.e("Soter.SoterCore", "soter: isNativeSupportSoter return[" + dQN + "]", new Object[0]);
        AppMethodBeat.o(72872);
        return dQN;
    }

    public static f dQO() {
        AppMethodBeat.i(72873);
        f fVar;
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: generateAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            fVar = new f(2);
            AppMethodBeat.o(72873);
            return fVar;
        }
        fVar = AuG.dQO();
        AppMethodBeat.o(72873);
        return fVar;
    }

    public static f dQP() {
        AppMethodBeat.i(72874);
        f fVar;
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: removeAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            fVar = new f(2);
            AppMethodBeat.o(72874);
            return fVar;
        }
        fVar = AuG.dQP();
        AppMethodBeat.o(72874);
        return fVar;
    }

    public static boolean dQQ() {
        AppMethodBeat.i(72875);
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: hasAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(72875);
            return false;
        }
        boolean dQQ = AuG.dQQ();
        AppMethodBeat.o(72875);
        return dQQ;
    }

    public static boolean dQR() {
        AppMethodBeat.i(72876);
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: isAppGlobalSecureKeyValid IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(72876);
            return false;
        }
        boolean dQR = AuG.dQR();
        AppMethodBeat.o(72876);
        return dQR;
    }

    public static i dQS() {
        AppMethodBeat.i(72877);
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: getAppGlobalSecureKeyModel IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(72877);
            return null;
        }
        i dQS = AuG.dQS();
        AppMethodBeat.o(72877);
        return dQS;
    }

    public static f atZ(String str) {
        AppMethodBeat.i(72878);
        f fVar;
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: generateAuthKey IMPL is null, not support soter", new Object[0]);
            fVar = new f(2);
            AppMethodBeat.o(72878);
            return fVar;
        }
        fVar = AuG.atZ(str);
        AppMethodBeat.o(72878);
        return fVar;
    }

    public static f cn(String str, boolean z) {
        AppMethodBeat.i(72879);
        f fVar;
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: removeAuthKey IMPL is null, not support soter", new Object[0]);
            fVar = new f(2);
            AppMethodBeat.o(72879);
            return fVar;
        }
        fVar = AuG.cn(str, z);
        AppMethodBeat.o(72879);
        return fVar;
    }

    public static boolean aua(String str) {
        AppMethodBeat.i(72880);
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: hasAuthKey IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(72880);
            return false;
        }
        boolean aua = AuG.aua(str);
        AppMethodBeat.o(72880);
        return aua;
    }

    public static boolean aub(String str) {
        AppMethodBeat.i(72881);
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: isAuthKeyValid IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(72881);
            return false;
        }
        boolean aub = AuG.aub(str);
        AppMethodBeat.o(72881);
        return aub;
    }

    public static i auc(String str) {
        AppMethodBeat.i(72882);
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: getAuthKeyModel IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(72882);
            return null;
        }
        i auc = AuG.auc(str);
        AppMethodBeat.o(72882);
        return auc;
    }

    public static Signature aud(String str) {
        AppMethodBeat.i(72883);
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: getAuthInitAndSign IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(72883);
            return null;
        }
        Signature aud = AuG.aud(str);
        AppMethodBeat.o(72883);
        return aud;
    }

    public static SoterSessionResult iC(String str, String str2) {
        AppMethodBeat.i(72884);
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: initSigh IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.o(72884);
            return null;
        }
        SoterSessionResult iC = AuG.iC(str, str2);
        AppMethodBeat.o(72884);
        return iC;
    }

    public static byte[] nB(long j) {
        AppMethodBeat.i(72885);
        byte[] bArr;
        if (AuG == null) {
            d.e("Soter.SoterCore", "soter: finishSign IMPL is null, not support soter", new Object[0]);
            bArr = new byte[0];
            AppMethodBeat.o(72885);
            return bArr;
        }
        bArr = AuG.nB(j);
        AppMethodBeat.o(72885);
        return bArr;
    }

    public static boolean iP(Context context) {
        AppMethodBeat.i(72887);
        boolean isHardwareDetected = com.tencent.soter.core.a.a.iU(context).isHardwareDetected();
        d.e("Soter.SoterCore", "soter: isSupportFingerprint return[" + isHardwareDetected + "]", new Object[0]);
        AppMethodBeat.o(72887);
        return isHardwareDetected;
    }

    public static boolean iQ(Context context) {
        AppMethodBeat.i(72888);
        boolean isHardwareDetected = BiometricManagerCompat.from(context, Integer.valueOf(2)).isHardwareDetected();
        d.e("Soter.SoterCore", "soter: isSupportBiometric type[2] return[" + isHardwareDetected + "]", new Object[0]);
        AppMethodBeat.o(72888);
        return isHardwareDetected;
    }

    public static boolean iR(Context context) {
        AppMethodBeat.i(72889);
        boolean hasEnrolledFingerprints = com.tencent.soter.core.a.a.iU(context).hasEnrolledFingerprints();
        AppMethodBeat.o(72889);
        return hasEnrolledFingerprints;
    }

    public static boolean iS(Context context) {
        AppMethodBeat.i(72890);
        boolean hasEnrolledBiometric = BiometricManagerCompat.from(context, Integer.valueOf(2)).hasEnrolledBiometric();
        AppMethodBeat.o(72890);
        return hasEnrolledBiometric;
    }

    public static boolean iT(Context context) {
        AppMethodBeat.i(72891);
        if (com.tencent.soter.core.a.c.isCurrentFailTimeAvailable(context) || com.tencent.soter.core.a.c.isCurrentTweenTimeAvailable(context)) {
            AppMethodBeat.o(72891);
            return false;
        }
        AppMethodBeat.o(72891);
        return true;
    }

    public static boolean aC(Context context, int i) {
        AppMethodBeat.i(72892);
        if (BiometricManagerCompat.from(context, Integer.valueOf(i)).isCurrentFailTimeAvailable() || BiometricManagerCompat.from(context, Integer.valueOf(i)).isCurrentTweenTimeAvailable(context)) {
            AppMethodBeat.o(72892);
            return false;
        }
        AppMethodBeat.o(72892);
        return true;
    }

    public static String dQT() {
        AppMethodBeat.i(72893);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<deviceinfo>");
        stringBuilder.append("<MANUFACTURER name=\"");
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append("\">");
        stringBuilder.append("<MODEL name=\"");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("\">");
        stringBuilder.append("<VERSION_RELEASE name=\"");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("\">");
        stringBuilder.append("<VERSION_INCREMENTAL name=\"");
        stringBuilder.append(VERSION.INCREMENTAL);
        stringBuilder.append("\">");
        stringBuilder.append("<DISPLAY name=\"");
        stringBuilder.append(Build.DISPLAY);
        stringBuilder.append("\">");
        stringBuilder.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        d.d("Soter.SoterCore", "soter: getFingerprint  " + stringBuilder.toString(), new Object[0]);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(72893);
        return stringBuilder2;
    }

    public static j co(byte[] bArr) {
        int i;
        j jVar = null;
        AppMethodBeat.i(72886);
        if (bArr == null || bArr.length <= 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            d.e("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
            AppMethodBeat.o(72886);
        } else if (bArr.length < 4) {
            d.e("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
            AppMethodBeat.o(72886);
        } else {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            int i2 = 0;
            for (i = 0; i < 4; i++) {
                i2 += (bArr2[i] & 255) << (i * 8);
            }
            d.d("Soter", "parsed raw length: ".concat(String.valueOf(i2)), new Object[0]);
            if (i2 > 1048576) {
                d.e("Soter.SoterCore", "soter: too large signature result!", new Object[0]);
                AppMethodBeat.o(72886);
            } else {
                byte[] bArr3 = new byte[i2];
                if (bArr.length <= i2 + 4) {
                    d.e("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
                    AppMethodBeat.o(72886);
                } else {
                    System.arraycopy(bArr, 4, bArr3, 0, i2);
                    jVar = j.aue(new String(bArr3));
                    i = bArr.length - (i2 + 4);
                    d.d("Soter.SoterCore", "soter: signature length: ".concat(String.valueOf(i)), new Object[0]);
                    bArr2 = new byte[i];
                    System.arraycopy(bArr, i2 + 4, bArr2, 0, i);
                    if (jVar != null) {
                        jVar.signature = Base64.encodeToString(bArr2, 2);
                    }
                    AppMethodBeat.o(72886);
                }
            }
        }
        return jVar;
    }
}
