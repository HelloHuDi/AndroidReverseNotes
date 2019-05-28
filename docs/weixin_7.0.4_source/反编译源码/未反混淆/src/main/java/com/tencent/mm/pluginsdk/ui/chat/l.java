package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.e;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;

public final class l implements OnClickListener {
    private Context context;

    public static class a {
        public String appId;
        public String cKE;
        public long cKK;
        public String cKf;
        public String ceO;
        public int scene;
        public String voA;
        public String voB;
        public int voz;
    }

    public static class b {
        public String appId;
        public String cKf;
    }

    public l(Context context) {
        this.context = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(View view) {
        boolean z = true;
        AppMethodBeat.i(27964);
        Object tag = view.getTag();
        if (tag instanceof b) {
            b bVar = (b) tag;
            if (bVar == null || view == null) {
                ab.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
            } else {
                Intent intent;
                if ("wx7fa037cc7dfabad5".equals(bVar.appId)) {
                    d.kT(33);
                    aw.ZK();
                    if (com.tencent.mm.n.a.jh(c.XM().aoO("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        com.tencent.mm.bp.d.f(this.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        com.tencent.mm.bp.d.b(this.context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                } else if ("wx485a97c844086dc9".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_music", true);
                    com.tencent.mm.bp.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                } else if ("wxfbc915ff7c30e335".equals(bVar.appId)) {
                    if (!com.tencent.mm.au.b.ahO()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 1);
                        if (!(com.tencent.mm.r.a.bI(this.context) || e.akI())) {
                            com.tencent.mm.bp.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx482a4001c37e2b74".equals(bVar.appId)) {
                    if (!com.tencent.mm.au.b.ahO()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 2);
                        if (!(com.tencent.mm.r.a.bI(this.context) || e.akI())) {
                            com.tencent.mm.bp.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx751a1acca5688ba3".equals(bVar.appId)) {
                    if (!com.tencent.mm.au.b.ahO()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 5);
                        if (!(com.tencent.mm.r.a.bI(this.context) || e.akI())) {
                            com.tencent.mm.bp.d.b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wxaf060266bfa9a35c".equals(bVar.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    com.tencent.mm.bp.d.b(this.context, "shake", ".ui.ShakeReportUI", intent);
                }
                if (!z) {
                    String f = p.f(this.context, bVar.appId, bVar.cKf);
                    sj sjVar = new sj();
                    sjVar.cOF.cOG = f;
                    sjVar.cOF.context = this.context;
                    com.tencent.mm.sdk.b.a.xxA.m(sjVar);
                }
                AppMethodBeat.o(27964);
                return;
            }
            z = false;
            if (z) {
            }
            AppMethodBeat.o(27964);
            return;
        }
        if (tag instanceof a) {
            a aVar = (a) tag;
            gt gtVar = new gt();
            gtVar.cBv.actionCode = 2;
            gtVar.cBv.scene = aVar.scene;
            gtVar.cBv.extMsg = "chatting_src=" + aVar.scene;
            gtVar.cBv.appId = aVar.appId;
            gtVar.cBv.context = this.context;
            com.tencent.mm.sdk.b.a.xxA.m(gtVar);
            ok okVar = new ok();
            okVar.cKI.context = this.context;
            okVar.cKI.scene = aVar.scene;
            okVar.cKI.csB = aVar.appId;
            okVar.cKI.packageName = aVar.ceO;
            okVar.cKI.msgType = aVar.voz;
            okVar.cKI.cEV = aVar.cKE;
            okVar.cKI.cKJ = 5;
            okVar.cKI.mediaTagName = aVar.voA;
            okVar.cKI.cKK = aVar.cKK;
            okVar.cKI.cKL = "";
            okVar.cKI.cst = aVar.voB;
            com.tencent.mm.sdk.b.a.xxA.m(okVar);
        }
        AppMethodBeat.o(27964);
    }
}
