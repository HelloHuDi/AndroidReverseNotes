package com.tencent.p177mm.app;

import android.os.Looper;
import android.os.Message;
import android.support.p057v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p263d.C1843a;
import com.tencent.p177mm.model.p263d.C1843a.C18484;
import com.tencent.p177mm.model.p263d.C31273b;
import com.tencent.p177mm.model.p263d.C31273b.C96561;
import com.tencent.p177mm.model.p263d.C9659c;
import com.tencent.p177mm.model.p263d.C9659c.C18501;
import com.tencent.p177mm.model.p263d.C9659c.C9660a;
import com.tencent.p177mm.p612ui.C15912m;
import com.tencent.p177mm.p612ui.HomeUI;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MainTabUI;
import com.tencent.p177mm.p612ui.conversation.MainUI;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.sns.p1024b.C43535f;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.app.n */
public final class C25798n {
    public static C25798n ceT;
    public boolean ceU;
    public C7306ak ceV = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(15385);
            super.handleMessage(message);
            LauncherUI instance;
            if (message.what == -1999) {
                if (!C25798n.this.ceU) {
                    instance = LauncherUI.getInstance();
                    if (instance != null && instance.yjL) {
                        instance.yjJ.getMainTabUI().aqG("tab_main");
                        HomeUI homeUI = instance.getHomeUI();
                        if (homeUI.yiv) {
                            homeUI.yix = true;
                        }
                        C43535f c43535f = C21877n.qFx;
                        if (c43535f != null) {
                            c43535f.cmm();
                        }
                        for (Fragment fragment : instance.yjJ.getMainTabUI().ynQ.values()) {
                            if (!(fragment instanceof MainUI)) {
                                ((C15912m) fragment).dwh();
                            }
                        }
                    }
                    System.gc();
                    AppMethodBeat.m2505o(15385);
                    return;
                }
            } else if (message.what == -2999) {
                if (C25798n.this.ceU) {
                    AppMethodBeat.m2505o(15385);
                    return;
                }
                instance = LauncherUI.getInstance();
                if (instance != null) {
                    MainTabUI mainTabUI = instance.yjJ.getMainTabUI();
                    if (mainTabUI.ynQ.containsKey(Integer.valueOf(0))) {
                        ((C15912m) mainTabUI.ynQ.get(Integer.valueOf(0))).dwh();
                    }
                }
                if (C1720g.m3534RN().mo5161QY()) {
                    C9638aw.m17184ZE();
                    C1816at oJ = C45439bw.m83697oJ("plugin.emoji");
                    if (oJ != null) {
                        oJ.mo5394iy(0);
                    }
                    C9660a abr = C31273b.abr();
                    C9660a abl = C1843a.abl();
                    C9659c abt = C9659c.abt();
                    C9638aw.m17180RS().mo10302aa(new C96561());
                    C7305d.xDH.mo10142ak(new C18484());
                    abt.mo20980a(abr);
                    abt.mo20980a(abl);
                    C9638aw.m17180RS().mo10302aa(new C18501());
                }
                System.gc();
            }
            AppMethodBeat.m2505o(15385);
        }
    };

    public C25798n() {
        AppMethodBeat.m2504i(15386);
        AppMethodBeat.m2505o(15386);
    }

    /* renamed from: Bw */
    public static C25798n m41027Bw() {
        AppMethodBeat.m2504i(15387);
        if (ceT == null) {
            ceT = new C25798n();
        }
        C25798n c25798n = ceT;
        AppMethodBeat.m2505o(15387);
        return c25798n;
    }
}
