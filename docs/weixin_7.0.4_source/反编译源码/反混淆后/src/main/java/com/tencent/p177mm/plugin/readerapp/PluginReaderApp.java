package com.tencent.p177mm.plugin.readerapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.readerapp.p1015c.C39565g;
import com.tencent.p177mm.plugin.readerapp.p1653a.C46154a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: com.tencent.mm.plugin.readerapp.PluginReaderApp */
public class PluginReaderApp extends C7597f implements C1671c, C46154a {
    private C1202f pEH = new C215652();

    /* renamed from: com.tencent.mm.plugin.readerapp.PluginReaderApp$2 */
    class C215652 implements C1202f {
        C215652() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(76740);
            C1720g.m3537RQ();
            if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(15, null)) != 0) {
                PluginReaderApp.access$000(PluginReaderApp.this);
                C1720g.m3540Rg().mo14546b(138, (C1202f) this);
            }
            AppMethodBeat.m2505o(76740);
        }
    }

    /* renamed from: com.tencent.mm.plugin.readerapp.PluginReaderApp$1 */
    class C287941 implements Runnable {
        C287941() {
        }

        public final void run() {
            AppMethodBeat.m2504i(76739);
            if (System.currentTimeMillis() - ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_READERAPP_REPORT_TIMESTAMP_LONG, Long.valueOf(0))).longValue() >= 604800000) {
                C1720g.m3537RQ();
                if ((C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(15, null)) != 0 ? 1 : null) != null) {
                    PluginReaderApp.access$000(PluginReaderApp.this);
                    AppMethodBeat.m2505o(76739);
                    return;
                }
                C1720g.m3540Rg().mo14539a(138, PluginReaderApp.this.pEH);
            }
            AppMethodBeat.m2505o(76739);
        }
    }

    public PluginReaderApp() {
        AppMethodBeat.m2504i(76741);
        AppMethodBeat.m2505o(76741);
    }

    static /* synthetic */ void access$000(PluginReaderApp pluginReaderApp) {
        AppMethodBeat.m2504i(76751);
        pluginReaderApp.reportPluginStatus();
        AppMethodBeat.m2505o(76751);
    }

    public void installed() {
        AppMethodBeat.m2504i(76742);
        alias(C46154a.class);
        AppMethodBeat.m2505o(76742);
    }

    public void dependency() {
        AppMethodBeat.m2504i(76743);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(76743);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(76744);
        if (c1681g.mo5181SG()) {
            pin(new C7485q(C39565g.class));
        }
        AppMethodBeat.m2505o(76744);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(76745);
        if (c1681g.mo5181SG()) {
            C9204c.aks("readerapp");
        }
        AppMethodBeat.m2505o(76745);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(76746);
        C7305d.post(new C287941(), "ReaderAppReport");
        AppMethodBeat.m2505o(76746);
    }

    private void reportPluginStatus() {
        int i;
        AppMethodBeat.m2504i(76747);
        int i2 = checkInstall() ? 1 : 0;
        if (checkRecvNews()) {
            i = 1;
        } else {
            i = 0;
        }
        C7060h.pYm.mo8381e(15416, "newsapp", Integer.valueOf(i2), Integer.valueOf(i));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_READERAPP_REPORT_TIMESTAMP_LONG, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(76747);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(76748);
        C1720g.m3540Rg().mo14546b(138, this.pEH);
        AppMethodBeat.m2505o(76748);
    }

    private boolean checkInstall() {
        AppMethodBeat.m2504i(76749);
        if ((C1853r.m3829YK() & SQLiteGlobal.journalSizeLimit) == 0) {
            AppMethodBeat.m2505o(76749);
            return true;
        }
        AppMethodBeat.m2505o(76749);
        return false;
    }

    private boolean checkRecvNews() {
        AppMethodBeat.m2504i(76750);
        if ((C1853r.m3824YF() & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
            AppMethodBeat.m2505o(76750);
            return true;
        }
        AppMethodBeat.m2505o(76750);
        return false;
    }
}
