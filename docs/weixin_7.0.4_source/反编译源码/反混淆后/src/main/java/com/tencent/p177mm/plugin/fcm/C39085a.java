package com.tencent.p177mm.plugin.fcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fcm.a */
public class C39085a implements C1202f {
    private static C39085a mqA;
    final Context context;
    private int mqB;

    private C39085a(Context context) {
        this.context = context;
    }

    public static C39085a bwG() {
        AppMethodBeat.m2504i(56427);
        C39085a c39085a;
        if (mqA != null) {
            c39085a = mqA;
            AppMethodBeat.m2505o(56427);
            return c39085a;
        }
        Context context = C4996ah.getContext();
        if (context == null) {
            C4990ab.m7412e("MicroMsg.FCM.FcmRegister", "FCM appcontext null");
            AppMethodBeat.m2505o(56427);
            return null;
        }
        c39085a = new C39085a(context);
        mqA = c39085a;
        AppMethodBeat.m2505o(56427);
        return c39085a;
    }

    /* Access modifiers changed, original: final */
    public final boolean bwH() {
        AppMethodBeat.m2504i(56428);
        try {
            if (VERSION.SDK_INT < 14) {
                C4990ab.m7420w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = version < 14");
                AppMethodBeat.m2505o(56428);
                return false;
            }
            int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.context);
            if (isGooglePlayServicesAvailable != 0) {
                C4990ab.m7420w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = ".concat(String.valueOf(isGooglePlayServicesAvailable)));
                AppMethodBeat.m2505o(56428);
                return false;
            }
            AppMethodBeat.m2505o(56428);
            return true;
        } catch (Throwable th) {
            C4990ab.m7412e("MicroMsg.FCM.FcmRegister", th.toString());
            AppMethodBeat.m2505o(56428);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void bwI() {
        AppMethodBeat.m2504i(56429);
        C7053e.pXa.mo8378a(901, 18, 1, false);
        String token = FirebaseInstanceId.m40567uD().getToken();
        if (C5046bo.isNullOrNil(token)) {
            C7053e.pXa.mo8378a(901, 19, 1, false);
            C4990ab.m7420w("MicroMsg.FCM.FcmRegister", "unreg fail, token is null");
            AppMethodBeat.m2505o(56429);
            return;
        }
        m66506hp(false);
        C1207m c34178c = new C34178c(token);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(c34178c.getType(), (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c34178c, 0);
        C7053e.pXa.mo8378a(901, 21, 1, false);
        AppMethodBeat.m2505o(56429);
    }

    /* renamed from: Mk */
    public final void mo61994Mk(String str) {
        AppMethodBeat.m2504i(56430);
        C4990ab.m7417i("MicroMsg.FCM.FcmRegister", "register token to svr: %s", str);
        C7053e.pXa.mo8378a(901, 11, 1, false);
        if (C5046bo.isNullOrNil(str)) {
            C7053e.pXa.mo8378a(901, 13, 1, false);
            C4990ab.m7412e("MicroMsg.FCM.FcmRegister", "token is null, fail reg");
            AppMethodBeat.m2505o(56430);
        } else if (this.mqB == C1668a.m3396Ra()) {
            C7053e.pXa.mo8378a(901, 12, 1, false);
            C4990ab.m7420w("MicroMsg.FCM.FcmRegister", "have registered yet.");
            AppMethodBeat.m2505o(56430);
        } else {
            C1207m c34177b = new C34177b(str);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(c34177b.getType(), (C1202f) this);
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c34177b, 0);
            C7053e.pXa.mo8378a(901, 14, 1, false);
            AppMethodBeat.m2505o(56430);
        }
    }

    public final boolean bwJ() {
        AppMethodBeat.m2504i(56431);
        boolean z = bwK().getBoolean("isRegToSvr", false);
        AppMethodBeat.m2505o(56431);
        return z;
    }

    /* renamed from: hp */
    private void m66506hp(boolean z) {
        AppMethodBeat.m2504i(56432);
        SharedPreferences bwK = bwK();
        C4990ab.m7416i("MicroMsg.FCM.FcmRegister", "Saving regSvrResult: ".concat(String.valueOf(z)));
        Editor edit = bwK.edit();
        edit.putBoolean("isRegToSvr", z);
        edit.commit();
        if (z) {
            this.mqB = C1668a.m3396Ra();
            AppMethodBeat.m2505o(56432);
            return;
        }
        this.mqB = 0;
        AppMethodBeat.m2505o(56432);
    }

    private SharedPreferences bwK() {
        AppMethodBeat.m2504i(56433);
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(C39085a.class.getSimpleName(), 0);
        AppMethodBeat.m2505o(56433);
        return sharedPreferences;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(56434);
        if (c1207m == null) {
            AppMethodBeat.m2505o(56434);
        } else if (c1207m instanceof C34177b) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14539a(((C34177b) c1207m).getType(), (C1202f) this);
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg success.");
                C7053e.pXa.mo8378a(901, 16, 1, false);
                z = true;
            } else {
                C4990ab.m7416i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg faild.");
                C7053e.pXa.mo8378a(901, 17, 1, false);
            }
            m66506hp(z);
            AppMethodBeat.m2505o(56434);
        } else {
            if (c1207m instanceof C34178c) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14539a(((C34178c) c1207m).getType(), (C1202f) this);
                if (i == 0 && i2 == 0) {
                    C4990ab.m7416i("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg success.");
                    C7053e.pXa.mo8378a(901, 23, 1, false);
                } else {
                    C4990ab.m7412e("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg faild.");
                    C7053e.pXa.mo8378a(901, 24, 1, false);
                }
                m66506hp(false);
            }
            AppMethodBeat.m2505o(56434);
        }
    }
}
