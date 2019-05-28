package com.tencent.soter.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.biometric.BiometricManagerCompat;
import com.tencent.soter.core.p1351c.C24322h;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.core.p1351c.C30973j;
import com.tencent.soter.core.p1351c.C44474b;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.core.p1351c.C44478f;
import com.tencent.soter.core.p1425d.C40998a;
import com.tencent.soter.core.p1425d.C40999b;
import com.tencent.soter.core.p1425d.C41353d;
import com.tencent.soter.core.p1425d.C46746c;
import com.tencent.soter.core.p665a.C30970c;
import com.tencent.soter.core.p665a.C44473a;
import com.tencent.soter.soterserver.SoterSessionResult;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;

/* renamed from: com.tencent.soter.core.a */
public final class C40997a implements C44474b {
    private static boolean AuF = false;
    private static C40999b AuG = C40997a.dQM();

    static {
        boolean z = true;
        AppMethodBeat.m2504i(72894);
        C44476d.m80484i("Soter.SoterCore", "soter: SoterCore is call static block to init SoterCore IMPL", new Object[0]);
        String str = "Soter.SoterCore";
        String str2 = "soter: SoterCore is call static block to init SoterCore IMPL, IMPL is null[%b]";
        Object[] objArr = new Object[1];
        if (AuG != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C44476d.m80484i(str, str2, objArr);
        AppMethodBeat.m2505o(72894);
    }

    public static void bLV() {
        AppMethodBeat.m2504i(72867);
        C46746c.bLV();
        AppMethodBeat.m2505o(72867);
    }

    /* renamed from: iO */
    public static void m71096iO(Context context) {
        AppMethodBeat.m2504i(72868);
        if (AuG == null) {
            C44476d.m80484i("Soter.SoterCore", "soter: SoterCore IMPL is null then call tryToInitSoterTreble to init", new Object[0]);
            C41353d c41353d = new C41353d();
            AuG = c41353d;
            if (!c41353d.mo64960iV(context)) {
                AuG = null;
                C44476d.m80484i("Soter.SoterCore", "soter: SoterCore IMPL is null after call tryToInitSoterTreble to init", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(72868);
    }

    public static void dQK() {
        boolean z = true;
        AppMethodBeat.m2504i(72869);
        if (AuG == null) {
            C44476d.m80484i("Soter.SoterCore", "soter: SoterCore IMPL is null then call getProviderSoterCore to init", new Object[0]);
            AuG = C40997a.dQM();
            String str = "Soter.SoterCore";
            String str2 = "soter: SoterCore IMPL is null[%b], after call getProviderSoterCore to init";
            Object[] objArr = new Object[1];
            if (AuG != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C44476d.m80484i(str, str2, objArr);
        }
        AppMethodBeat.m2505o(72869);
    }

    public static int dQL() {
        AppMethodBeat.m2504i(72870);
        if (AuG == null) {
            AppMethodBeat.m2505o(72870);
            return 0;
        } else if (AuG instanceof C41353d) {
            C44476d.m80482d("Soter.SoterCore", "getSoterCoreType is TREBLE", new Object[0]);
            AppMethodBeat.m2505o(72870);
            return 1;
        } else {
            C44476d.m80482d("Soter.SoterCore", "getSoterCoreType is not TREBLE", new Object[0]);
            AppMethodBeat.m2505o(72870);
            return 0;
        }
    }

    private static C40999b dQM() {
        AppMethodBeat.m2504i(72871);
        C46746c.bLV();
        if (C24322h.dQY()) {
            AppMethodBeat.m2505o(72871);
            return null;
        }
        Provider[] providers = Security.getProviders();
        if (providers == null) {
            AppMethodBeat.m2505o(72871);
            return null;
        }
        int length = providers.length;
        int i = 0;
        while (i < length) {
            String name = providers[i].getName();
            C40999b c40998a;
            if (name == null || !name.startsWith("SoterKeyStore")) {
                i++;
            } else if (name.split("\\.").length > 1) {
                c40998a = new C40998a(name);
                AppMethodBeat.m2505o(72871);
                return c40998a;
            } else {
                c40998a = new C46746c(name);
                AppMethodBeat.m2505o(72871);
                return c40998a;
            }
        }
        AppMethodBeat.m2505o(72871);
        return null;
    }

    public static boolean dQN() {
        AppMethodBeat.m2504i(72872);
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: isNativeSupportSoter IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.m2505o(72872);
            return false;
        }
        boolean dQN = AuG.dQN();
        C44476d.m80483e("Soter.SoterCore", "soter: isNativeSupportSoter return[" + dQN + "]", new Object[0]);
        AppMethodBeat.m2505o(72872);
        return dQN;
    }

    public static C44478f dQO() {
        AppMethodBeat.m2504i(72873);
        C44478f c44478f;
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: generateAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            c44478f = new C44478f(2);
            AppMethodBeat.m2505o(72873);
            return c44478f;
        }
        c44478f = AuG.dQO();
        AppMethodBeat.m2505o(72873);
        return c44478f;
    }

    public static C44478f dQP() {
        AppMethodBeat.m2504i(72874);
        C44478f c44478f;
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: removeAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            c44478f = new C44478f(2);
            AppMethodBeat.m2505o(72874);
            return c44478f;
        }
        c44478f = AuG.dQP();
        AppMethodBeat.m2505o(72874);
        return c44478f;
    }

    public static boolean dQQ() {
        AppMethodBeat.m2504i(72875);
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: hasAppGlobalSecureKey IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.m2505o(72875);
            return false;
        }
        boolean dQQ = AuG.dQQ();
        AppMethodBeat.m2505o(72875);
        return dQQ;
    }

    public static boolean dQR() {
        AppMethodBeat.m2504i(72876);
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: isAppGlobalSecureKeyValid IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.m2505o(72876);
            return false;
        }
        boolean dQR = AuG.dQR();
        AppMethodBeat.m2505o(72876);
        return dQR;
    }

    public static C30972i dQS() {
        AppMethodBeat.m2504i(72877);
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: getAppGlobalSecureKeyModel IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.m2505o(72877);
            return null;
        }
        C30972i dQS = AuG.dQS();
        AppMethodBeat.m2505o(72877);
        return dQS;
    }

    public static C44478f atZ(String str) {
        AppMethodBeat.m2504i(72878);
        C44478f c44478f;
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: generateAuthKey IMPL is null, not support soter", new Object[0]);
            c44478f = new C44478f(2);
            AppMethodBeat.m2505o(72878);
            return c44478f;
        }
        c44478f = AuG.atZ(str);
        AppMethodBeat.m2505o(72878);
        return c44478f;
    }

    /* renamed from: cn */
    public static C44478f m71093cn(String str, boolean z) {
        AppMethodBeat.m2504i(72879);
        C44478f c44478f;
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: removeAuthKey IMPL is null, not support soter", new Object[0]);
            c44478f = new C44478f(2);
            AppMethodBeat.m2505o(72879);
            return c44478f;
        }
        c44478f = AuG.mo64954cn(str, z);
        AppMethodBeat.m2505o(72879);
        return c44478f;
    }

    public static boolean aua(String str) {
        AppMethodBeat.m2504i(72880);
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: hasAuthKey IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.m2505o(72880);
            return false;
        }
        boolean aua = AuG.aua(str);
        AppMethodBeat.m2505o(72880);
        return aua;
    }

    public static boolean aub(String str) {
        AppMethodBeat.m2504i(72881);
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: isAuthKeyValid IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.m2505o(72881);
            return false;
        }
        boolean aub = AuG.aub(str);
        AppMethodBeat.m2505o(72881);
        return aub;
    }

    public static C30972i auc(String str) {
        AppMethodBeat.m2504i(72882);
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: getAuthKeyModel IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.m2505o(72882);
            return null;
        }
        C30972i auc = AuG.auc(str);
        AppMethodBeat.m2505o(72882);
        return auc;
    }

    public static Signature aud(String str) {
        AppMethodBeat.m2504i(72883);
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: getAuthInitAndSign IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.m2505o(72883);
            return null;
        }
        Signature aud = AuG.aud(str);
        AppMethodBeat.m2505o(72883);
        return aud;
    }

    /* renamed from: iC */
    public static SoterSessionResult m71095iC(String str, String str2) {
        AppMethodBeat.m2504i(72884);
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: initSigh IMPL is null, not support soter", new Object[0]);
            AppMethodBeat.m2505o(72884);
            return null;
        }
        SoterSessionResult iC = AuG.mo64959iC(str, str2);
        AppMethodBeat.m2505o(72884);
        return iC;
    }

    /* renamed from: nB */
    public static byte[] m71102nB(long j) {
        AppMethodBeat.m2504i(72885);
        byte[] bArr;
        if (AuG == null) {
            C44476d.m80483e("Soter.SoterCore", "soter: finishSign IMPL is null, not support soter", new Object[0]);
            bArr = new byte[0];
            AppMethodBeat.m2505o(72885);
            return bArr;
        }
        bArr = AuG.mo64961nB(j);
        AppMethodBeat.m2505o(72885);
        return bArr;
    }

    /* renamed from: iP */
    public static boolean m71097iP(Context context) {
        AppMethodBeat.m2504i(72887);
        boolean isHardwareDetected = C44473a.m80472iU(context).isHardwareDetected();
        C44476d.m80483e("Soter.SoterCore", "soter: isSupportFingerprint return[" + isHardwareDetected + "]", new Object[0]);
        AppMethodBeat.m2505o(72887);
        return isHardwareDetected;
    }

    /* renamed from: iQ */
    public static boolean m71098iQ(Context context) {
        AppMethodBeat.m2504i(72888);
        boolean isHardwareDetected = BiometricManagerCompat.from(context, Integer.valueOf(2)).isHardwareDetected();
        C44476d.m80483e("Soter.SoterCore", "soter: isSupportBiometric type[2] return[" + isHardwareDetected + "]", new Object[0]);
        AppMethodBeat.m2505o(72888);
        return isHardwareDetected;
    }

    /* renamed from: iR */
    public static boolean m71099iR(Context context) {
        AppMethodBeat.m2504i(72889);
        boolean hasEnrolledFingerprints = C44473a.m80472iU(context).hasEnrolledFingerprints();
        AppMethodBeat.m2505o(72889);
        return hasEnrolledFingerprints;
    }

    /* renamed from: iS */
    public static boolean m71100iS(Context context) {
        AppMethodBeat.m2504i(72890);
        boolean hasEnrolledBiometric = BiometricManagerCompat.from(context, Integer.valueOf(2)).hasEnrolledBiometric();
        AppMethodBeat.m2505o(72890);
        return hasEnrolledBiometric;
    }

    /* renamed from: iT */
    public static boolean m71101iT(Context context) {
        AppMethodBeat.m2504i(72891);
        if (C30970c.isCurrentFailTimeAvailable(context) || C30970c.isCurrentTweenTimeAvailable(context)) {
            AppMethodBeat.m2505o(72891);
            return false;
        }
        AppMethodBeat.m2505o(72891);
        return true;
    }

    /* renamed from: aC */
    public static boolean m71092aC(Context context, int i) {
        AppMethodBeat.m2504i(72892);
        if (BiometricManagerCompat.from(context, Integer.valueOf(i)).isCurrentFailTimeAvailable() || BiometricManagerCompat.from(context, Integer.valueOf(i)).isCurrentTweenTimeAvailable(context)) {
            AppMethodBeat.m2505o(72892);
            return false;
        }
        AppMethodBeat.m2505o(72892);
        return true;
    }

    public static String dQT() {
        AppMethodBeat.m2504i(72893);
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
        C44476d.m80482d("Soter.SoterCore", "soter: getFingerprint  " + stringBuilder.toString(), new Object[0]);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(72893);
        return stringBuilder2;
    }

    /* renamed from: co */
    public static C30973j m71094co(byte[] bArr) {
        int i;
        C30973j c30973j = null;
        AppMethodBeat.m2504i(72886);
        if (bArr == null || bArr.length <= 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            C44476d.m80483e("Soter.SoterCore", "origin is null or nil. abort", new Object[0]);
            AppMethodBeat.m2505o(72886);
        } else if (bArr.length < 4) {
            C44476d.m80483e("Soter.SoterCore", "soter: length not correct 1", new Object[0]);
            AppMethodBeat.m2505o(72886);
        } else {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            int i2 = 0;
            for (i = 0; i < 4; i++) {
                i2 += (bArr2[i] & 255) << (i * 8);
            }
            C44476d.m80482d("Soter", "parsed raw length: ".concat(String.valueOf(i2)), new Object[0]);
            if (i2 > 1048576) {
                C44476d.m80483e("Soter.SoterCore", "soter: too large signature result!", new Object[0]);
                AppMethodBeat.m2505o(72886);
            } else {
                byte[] bArr3 = new byte[i2];
                if (bArr.length <= i2 + 4) {
                    C44476d.m80483e("Soter.SoterCore", "soter: length not correct 2", new Object[0]);
                    AppMethodBeat.m2505o(72886);
                } else {
                    System.arraycopy(bArr, 4, bArr3, 0, i2);
                    c30973j = C30973j.aue(new String(bArr3));
                    i = bArr.length - (i2 + 4);
                    C44476d.m80482d("Soter.SoterCore", "soter: signature length: ".concat(String.valueOf(i)), new Object[0]);
                    bArr2 = new byte[i];
                    System.arraycopy(bArr, i2 + 4, bArr2, 0, i);
                    if (c30973j != null) {
                        c30973j.signature = Base64.encodeToString(bArr2, 2);
                    }
                    AppMethodBeat.m2505o(72886);
                }
            }
        }
        return c30973j;
    }
}
