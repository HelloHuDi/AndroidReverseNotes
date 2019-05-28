package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.fcm.a.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginFCM extends f implements a {
    private static boolean mqD = true;
    c mqE = new c<gi>() {
        {
            AppMethodBeat.i(56442);
            this.xxI = gi.class.getName().hashCode();
            AppMethodBeat.o(56442);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(56443);
            ab.i("MicroMsg.FCM.PluginFCM", "fcmRegisterEventListener callback loadFCM=" + PluginFCM.mqD);
            if (PluginFCM.mqD) {
                PluginFCM.access$100(PluginFCM.this);
            }
            AppMethodBeat.o(56443);
            return false;
        }
    };
    c mqF = new c<gj>() {
        {
            AppMethodBeat.i(56444);
            this.xxI = gj.class.getName().hashCode();
            AppMethodBeat.o(56444);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(56445);
            ab.i("MicroMsg.FCM.PluginFCM", "fcmUnRegisterEventListener callback loadFCM=" + PluginFCM.mqD);
            if (PluginFCM.mqD) {
                PluginFCM.access$200(PluginFCM.this);
            }
            AppMethodBeat.o(56445);
            return false;
        }
    };

    public PluginFCM() {
        AppMethodBeat.i(56446);
        AppMethodBeat.o(56446);
    }

    static /* synthetic */ boolean access$100(PluginFCM pluginFCM) {
        AppMethodBeat.i(56452);
        boolean handleLogin = pluginFCM.handleLogin();
        AppMethodBeat.o(56452);
        return handleLogin;
    }

    static /* synthetic */ boolean access$200(PluginFCM pluginFCM) {
        AppMethodBeat.i(56453);
        boolean handleLogout = pluginFCM.handleLogout();
        AppMethodBeat.o(56453);
        return handleLogout;
    }

    public void installed() {
        AppMethodBeat.i(56447);
        super.installed();
        alias(a.class);
        AppMethodBeat.o(56447);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(56448);
        super.configure(gVar);
        AppMethodBeat.o(56448);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(56449);
        if (gVar.SG()) {
            ab.i("MicroMsg.FCM.PluginFCM", "register listener at " + gVar.eHT);
            if (d.e(gVar)) {
                mqD = false;
                AppMethodBeat.o(56449);
                return;
            }
            com.tencent.mm.sdk.b.a.xxA.b(this.mqE);
            com.tencent.mm.sdk.b.a.xxA.b(this.mqF);
        }
        AppMethodBeat.o(56449);
    }

    public String name() {
        return "plugin-fcm";
    }

    private boolean handleLogin() {
        AppMethodBeat.i(56450);
        if (com.tencent.mm.kernel.g.RK()) {
            a bwG = a.bwG();
            if (bwG != null) {
                if (bwG.bwH()) {
                    ab.i("MicroMsg.FCM.FcmRegister", "Google Play Services is avaiable," + Long.toString(Thread.currentThread().getId()));
                    com.google.firebase.a.ak(bwG.context);
                    com.google.firebase.messaging.a.va().bwi.uM();
                    String token = FirebaseInstanceId.uD().getToken();
                    if (token == null) {
                        ab.w("MicroMsg.FCM.FcmRegister", "token is null, not ready");
                    } else {
                        bwG.Mk(token);
                    }
                } else {
                    ab.w("MicroMsg.FCM.FcmRegister", "Google Play Services Unavaiable");
                    h.pYm.X(11250, "2,0");
                    e.pXa.a(901, 0, 1, false);
                    if (bwG.bwJ()) {
                        bwG.bwI();
                    }
                }
                AppMethodBeat.o(56450);
                return true;
            }
            AppMethodBeat.o(56450);
            return false;
        }
        ab.w("MicroMsg.FCM.PluginFCM", "accout not ready");
        AppMethodBeat.o(56450);
        return false;
    }

    private boolean handleLogout() {
        AppMethodBeat.i(56451);
        a bwG = a.bwG();
        if (bwG != null) {
            ab.i("MicroMsg.FCM.FcmRegister", "FCM onLogout. isRegToSvr:" + bwG.bwJ());
            WCFirebaseMessagingService.bwL();
            if (bwG.bwJ()) {
                bwG.bwI();
            } else {
                e.pXa.a(901, 20, 1, false);
            }
            AppMethodBeat.o(56451);
            return true;
        }
        AppMethodBeat.o(56451);
        return false;
    }
}
