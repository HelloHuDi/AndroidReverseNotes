package com.tencent.mm.plugin.readerapp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.readerapp.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.wcdb.database.SQLiteGlobal;

public class PluginReaderApp extends f implements c, a {
    private com.tencent.mm.ai.f pEH = new com.tencent.mm.ai.f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(76740);
            g.RQ();
            if (bo.h((Integer) g.RP().Ry().get(15, null)) != 0) {
                PluginReaderApp.access$000(PluginReaderApp.this);
                g.Rg().b(138, (com.tencent.mm.ai.f) this);
            }
            AppMethodBeat.o(76740);
        }
    };

    public PluginReaderApp() {
        AppMethodBeat.i(76741);
        AppMethodBeat.o(76741);
    }

    static /* synthetic */ void access$000(PluginReaderApp pluginReaderApp) {
        AppMethodBeat.i(76751);
        pluginReaderApp.reportPluginStatus();
        AppMethodBeat.o(76751);
    }

    public void installed() {
        AppMethodBeat.i(76742);
        alias(a.class);
        AppMethodBeat.o(76742);
    }

    public void dependency() {
        AppMethodBeat.i(76743);
        dependsOn(p.class);
        AppMethodBeat.o(76743);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(76744);
        if (gVar.SG()) {
            pin(new q(com.tencent.mm.plugin.readerapp.c.g.class));
        }
        AppMethodBeat.o(76744);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(76745);
        if (gVar.SG()) {
            com.tencent.mm.bp.c.aks("readerapp");
        }
        AppMethodBeat.o(76745);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(76746);
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(76739);
                if (System.currentTimeMillis() - ((Long) g.RP().Ry().get(ac.a.USERINFO_READERAPP_REPORT_TIMESTAMP_LONG, Long.valueOf(0))).longValue() >= 604800000) {
                    g.RQ();
                    if ((bo.h((Integer) g.RP().Ry().get(15, null)) != 0 ? 1 : null) != null) {
                        PluginReaderApp.access$000(PluginReaderApp.this);
                        AppMethodBeat.o(76739);
                        return;
                    }
                    g.Rg().a(138, PluginReaderApp.this.pEH);
                }
                AppMethodBeat.o(76739);
            }
        }, "ReaderAppReport");
        AppMethodBeat.o(76746);
    }

    private void reportPluginStatus() {
        int i;
        AppMethodBeat.i(76747);
        int i2 = checkInstall() ? 1 : 0;
        if (checkRecvNews()) {
            i = 1;
        } else {
            i = 0;
        }
        h.pYm.e(15416, "newsapp", Integer.valueOf(i2), Integer.valueOf(i));
        g.RP().Ry().set(ac.a.USERINFO_READERAPP_REPORT_TIMESTAMP_LONG, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(76747);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(76748);
        g.Rg().b(138, this.pEH);
        AppMethodBeat.o(76748);
    }

    private boolean checkInstall() {
        AppMethodBeat.i(76749);
        if ((r.YK() & SQLiteGlobal.journalSizeLimit) == 0) {
            AppMethodBeat.o(76749);
            return true;
        }
        AppMethodBeat.o(76749);
        return false;
    }

    private boolean checkRecvNews() {
        AppMethodBeat.i(76750);
        if ((r.YF() & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0) {
            AppMethodBeat.o(76750);
            return true;
        }
        AppMethodBeat.o(76750);
        return false;
    }
}
