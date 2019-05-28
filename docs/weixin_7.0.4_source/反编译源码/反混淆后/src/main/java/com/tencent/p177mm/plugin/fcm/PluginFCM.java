package com.tencent.p177mm.plugin.fcm;

import com.google.firebase.C41642a;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.C17712a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p230g.p231a.C6483gi;
import com.tencent.p177mm.p230g.p231a.C6484gj;
import com.tencent.p177mm.plugin.fcm.p1647a.C45942a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fcm.PluginFCM */
public class PluginFCM extends C7597f implements C45942a {
    private static boolean mqD = true;
    C4884c mqE = new C119231();
    C4884c mqF = new C119242();

    /* renamed from: com.tencent.mm.plugin.fcm.PluginFCM$1 */
    class C119231 extends C4884c<C6483gi> {
        C119231() {
            AppMethodBeat.m2504i(56442);
            this.xxI = C6483gi.class.getName().hashCode();
            AppMethodBeat.m2505o(56442);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(56443);
            C4990ab.m7416i("MicroMsg.FCM.PluginFCM", "fcmRegisterEventListener callback loadFCM=" + PluginFCM.mqD);
            if (PluginFCM.mqD) {
                PluginFCM.access$100(PluginFCM.this);
            }
            AppMethodBeat.m2505o(56443);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fcm.PluginFCM$2 */
    class C119242 extends C4884c<C6484gj> {
        C119242() {
            AppMethodBeat.m2504i(56444);
            this.xxI = C6484gj.class.getName().hashCode();
            AppMethodBeat.m2505o(56444);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(56445);
            C4990ab.m7416i("MicroMsg.FCM.PluginFCM", "fcmUnRegisterEventListener callback loadFCM=" + PluginFCM.mqD);
            if (PluginFCM.mqD) {
                PluginFCM.access$200(PluginFCM.this);
            }
            AppMethodBeat.m2505o(56445);
            return false;
        }
    }

    public PluginFCM() {
        AppMethodBeat.m2504i(56446);
        AppMethodBeat.m2505o(56446);
    }

    static /* synthetic */ boolean access$100(PluginFCM pluginFCM) {
        AppMethodBeat.m2504i(56452);
        boolean handleLogin = pluginFCM.handleLogin();
        AppMethodBeat.m2505o(56452);
        return handleLogin;
    }

    static /* synthetic */ boolean access$200(PluginFCM pluginFCM) {
        AppMethodBeat.m2504i(56453);
        boolean handleLogout = pluginFCM.handleLogout();
        AppMethodBeat.m2505o(56453);
        return handleLogout;
    }

    public void installed() {
        AppMethodBeat.m2504i(56447);
        super.installed();
        alias(C45942a.class);
        AppMethodBeat.m2505o(56447);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(56448);
        super.configure(c1681g);
        AppMethodBeat.m2505o(56448);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(56449);
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.FCM.PluginFCM", "register listener at " + c1681g.eHT);
            if (C3111d.m5354e(c1681g)) {
                mqD = false;
                AppMethodBeat.m2505o(56449);
                return;
            }
            C4879a.xxA.mo10051b(this.mqE);
            C4879a.xxA.mo10051b(this.mqF);
        }
        AppMethodBeat.m2505o(56449);
    }

    public String name() {
        return "plugin-fcm";
    }

    private boolean handleLogin() {
        AppMethodBeat.m2504i(56450);
        if (C1720g.m3531RK()) {
            C39085a bwG = C39085a.bwG();
            if (bwG != null) {
                if (bwG.bwH()) {
                    C4990ab.m7416i("MicroMsg.FCM.FcmRegister", "Google Play Services is avaiable," + Long.toString(Thread.currentThread().getId()));
                    C41642a.m73005ak(bwG.context);
                    C17712a.m27643va().bwi.mo43240uM();
                    String token = FirebaseInstanceId.m40567uD().getToken();
                    if (token == null) {
                        C4990ab.m7420w("MicroMsg.FCM.FcmRegister", "token is null, not ready");
                    } else {
                        bwG.mo61994Mk(token);
                    }
                } else {
                    C4990ab.m7420w("MicroMsg.FCM.FcmRegister", "Google Play Services Unavaiable");
                    C7060h.pYm.mo8374X(11250, "2,0");
                    C7053e.pXa.mo8378a(901, 0, 1, false);
                    if (bwG.bwJ()) {
                        bwG.bwI();
                    }
                }
                AppMethodBeat.m2505o(56450);
                return true;
            }
            AppMethodBeat.m2505o(56450);
            return false;
        }
        C4990ab.m7420w("MicroMsg.FCM.PluginFCM", "accout not ready");
        AppMethodBeat.m2505o(56450);
        return false;
    }

    private boolean handleLogout() {
        AppMethodBeat.m2504i(56451);
        C39085a bwG = C39085a.bwG();
        if (bwG != null) {
            C4990ab.m7416i("MicroMsg.FCM.FcmRegister", "FCM onLogout. isRegToSvr:" + bwG.bwJ());
            WCFirebaseMessagingService.bwL();
            if (bwG.bwJ()) {
                bwG.bwI();
            } else {
                C7053e.pXa.mo8378a(901, 20, 1, false);
            }
            AppMethodBeat.m2505o(56451);
            return true;
        }
        AppMethodBeat.m2505o(56451);
        return false;
    }
}
