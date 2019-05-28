package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p230g.p231a.C32607ok;
import com.tencent.p177mm.p230g.p231a.C9365gt;
import com.tencent.p177mm.p230g.p231a.C9468sj;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sport.p1302a.C22162d;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.l */
public final class C44083l implements OnClickListener {
    private Context context;

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.l$a */
    public static class C4753a {
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

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.l$b */
    public static class C4754b {
        public String appId;
        public String cKf;
    }

    public C44083l(Context context) {
        this.context = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(View view) {
        boolean z = true;
        AppMethodBeat.m2504i(27964);
        Object tag = view.getTag();
        if (tag instanceof C4754b) {
            C4754b c4754b = (C4754b) tag;
            if (c4754b == null || view == null) {
                C4990ab.m7420w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
            } else {
                Intent intent;
                if ("wx7fa037cc7dfabad5".equals(c4754b.appId)) {
                    C22162d.m33785kT(33);
                    C9638aw.m17190ZK();
                    if (C7486a.m12942jh(C18628c.m29078XM().aoO("gh_43f2581f6fd6").field_type)) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        C25985d.m41473f(this.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        intent = new Intent();
                        intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                        C25985d.m41467b(this.context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    }
                } else if ("wx485a97c844086dc9".equals(c4754b.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_music", true);
                    C25985d.m41467b(this.context, "shake", ".ui.ShakeReportUI", intent);
                } else if ("wxfbc915ff7c30e335".equals(c4754b.appId)) {
                    if (!C17950b.ahO()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 1);
                        if (!(C35973a.m59178bI(this.context) || C17981e.akI())) {
                            C25985d.m41467b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx482a4001c37e2b74".equals(c4754b.appId)) {
                    if (!C17950b.ahO()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 2);
                        if (!(C35973a.m59178bI(this.context) || C17981e.akI())) {
                            C25985d.m41467b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wx751a1acca5688ba3".equals(c4754b.appId)) {
                    if (!C17950b.ahO()) {
                        intent = new Intent();
                        intent.putExtra("BaseScanUI_select_scan_mode", 5);
                        if (!(C35973a.m59178bI(this.context) || C17981e.akI())) {
                            C25985d.m41467b(this.context, "scanner", ".ui.BaseScanUI", intent);
                        }
                    }
                } else if ("wxaf060266bfa9a35c".equals(c4754b.appId)) {
                    intent = new Intent();
                    intent.putExtra("shake_tv", true);
                    C25985d.m41467b(this.context, "shake", ".ui.ShakeReportUI", intent);
                }
                if (!z) {
                    String f = C35799p.m58693f(this.context, c4754b.appId, c4754b.cKf);
                    C9468sj c9468sj = new C9468sj();
                    c9468sj.cOF.cOG = f;
                    c9468sj.cOF.context = this.context;
                    C4879a.xxA.mo10055m(c9468sj);
                }
                AppMethodBeat.m2505o(27964);
                return;
            }
            z = false;
            if (z) {
            }
            AppMethodBeat.m2505o(27964);
            return;
        }
        if (tag instanceof C4753a) {
            C4753a c4753a = (C4753a) tag;
            C9365gt c9365gt = new C9365gt();
            c9365gt.cBv.actionCode = 2;
            c9365gt.cBv.scene = c4753a.scene;
            c9365gt.cBv.extMsg = "chatting_src=" + c4753a.scene;
            c9365gt.cBv.appId = c4753a.appId;
            c9365gt.cBv.context = this.context;
            C4879a.xxA.mo10055m(c9365gt);
            C32607ok c32607ok = new C32607ok();
            c32607ok.cKI.context = this.context;
            c32607ok.cKI.scene = c4753a.scene;
            c32607ok.cKI.csB = c4753a.appId;
            c32607ok.cKI.packageName = c4753a.ceO;
            c32607ok.cKI.msgType = c4753a.voz;
            c32607ok.cKI.cEV = c4753a.cKE;
            c32607ok.cKI.cKJ = 5;
            c32607ok.cKI.mediaTagName = c4753a.voA;
            c32607ok.cKI.cKK = c4753a.cKK;
            c32607ok.cKI.cKL = "";
            c32607ok.cKI.cst = c4753a.voB;
            C4879a.xxA.mo10055m(c32607ok);
        }
        AppMethodBeat.m2505o(27964);
    }
}
