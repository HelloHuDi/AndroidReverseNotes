package com.tencent.mm.plugin.fcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class a implements f {
    private static a mqA;
    final Context context;
    private int mqB;

    private a(Context context) {
        this.context = context;
    }

    public static a bwG() {
        AppMethodBeat.i(56427);
        a aVar;
        if (mqA != null) {
            aVar = mqA;
            AppMethodBeat.o(56427);
            return aVar;
        }
        Context context = ah.getContext();
        if (context == null) {
            ab.e("MicroMsg.FCM.FcmRegister", "FCM appcontext null");
            AppMethodBeat.o(56427);
            return null;
        }
        aVar = new a(context);
        mqA = aVar;
        AppMethodBeat.o(56427);
        return aVar;
    }

    /* Access modifiers changed, original: final */
    public final boolean bwH() {
        AppMethodBeat.i(56428);
        try {
            if (VERSION.SDK_INT < 14) {
                ab.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = version < 14");
                AppMethodBeat.o(56428);
                return false;
            }
            int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.context);
            if (isGooglePlayServicesAvailable != 0) {
                ab.w("MicroMsg.FCM.FcmRegister", "device not support FCM reason = ".concat(String.valueOf(isGooglePlayServicesAvailable)));
                AppMethodBeat.o(56428);
                return false;
            }
            AppMethodBeat.o(56428);
            return true;
        } catch (Throwable th) {
            ab.e("MicroMsg.FCM.FcmRegister", th.toString());
            AppMethodBeat.o(56428);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void bwI() {
        AppMethodBeat.i(56429);
        e.pXa.a(901, 18, 1, false);
        String token = FirebaseInstanceId.uD().getToken();
        if (bo.isNullOrNil(token)) {
            e.pXa.a(901, 19, 1, false);
            ab.w("MicroMsg.FCM.FcmRegister", "unreg fail, token is null");
            AppMethodBeat.o(56429);
            return;
        }
        hp(false);
        m cVar = new c(token);
        g.RQ();
        g.RO().eJo.a(cVar.getType(), (f) this);
        g.RQ();
        g.RO().eJo.a(cVar, 0);
        e.pXa.a(901, 21, 1, false);
        AppMethodBeat.o(56429);
    }

    public final void Mk(String str) {
        AppMethodBeat.i(56430);
        ab.i("MicroMsg.FCM.FcmRegister", "register token to svr: %s", str);
        e.pXa.a(901, 11, 1, false);
        if (bo.isNullOrNil(str)) {
            e.pXa.a(901, 13, 1, false);
            ab.e("MicroMsg.FCM.FcmRegister", "token is null, fail reg");
            AppMethodBeat.o(56430);
        } else if (this.mqB == com.tencent.mm.kernel.a.Ra()) {
            e.pXa.a(901, 12, 1, false);
            ab.w("MicroMsg.FCM.FcmRegister", "have registered yet.");
            AppMethodBeat.o(56430);
        } else {
            m bVar = new b(str);
            g.RQ();
            g.RO().eJo.a(bVar.getType(), (f) this);
            g.RQ();
            g.RO().eJo.a(bVar, 0);
            e.pXa.a(901, 14, 1, false);
            AppMethodBeat.o(56430);
        }
    }

    public final boolean bwJ() {
        AppMethodBeat.i(56431);
        boolean z = bwK().getBoolean("isRegToSvr", false);
        AppMethodBeat.o(56431);
        return z;
    }

    private void hp(boolean z) {
        AppMethodBeat.i(56432);
        SharedPreferences bwK = bwK();
        ab.i("MicroMsg.FCM.FcmRegister", "Saving regSvrResult: ".concat(String.valueOf(z)));
        Editor edit = bwK.edit();
        edit.putBoolean("isRegToSvr", z);
        edit.commit();
        if (z) {
            this.mqB = com.tencent.mm.kernel.a.Ra();
            AppMethodBeat.o(56432);
            return;
        }
        this.mqB = 0;
        AppMethodBeat.o(56432);
    }

    private SharedPreferences bwK() {
        AppMethodBeat.i(56433);
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(a.class.getSimpleName(), 0);
        AppMethodBeat.o(56433);
        return sharedPreferences;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(56434);
        if (mVar == null) {
            AppMethodBeat.o(56434);
        } else if (mVar instanceof b) {
            g.RQ();
            g.RO().eJo.a(((b) mVar).getType(), (f) this);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg success.");
                e.pXa.a(901, 16, 1, false);
                z = true;
            } else {
                ab.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmReg faild.");
                e.pXa.a(901, 17, 1, false);
            }
            hp(z);
            AppMethodBeat.o(56434);
        } else {
            if (mVar instanceof c) {
                g.RQ();
                g.RO().eJo.a(((c) mVar).getType(), (f) this);
                if (i == 0 && i2 == 0) {
                    ab.i("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg success.");
                    e.pXa.a(901, 23, 1, false);
                } else {
                    ab.e("MicroMsg.FCM.FcmRegister", "NetSceneFcmUnreg faild.");
                    e.pXa.a(901, 24, 1, false);
                }
                hp(false);
            }
            AppMethodBeat.o(56434);
        }
    }
}
