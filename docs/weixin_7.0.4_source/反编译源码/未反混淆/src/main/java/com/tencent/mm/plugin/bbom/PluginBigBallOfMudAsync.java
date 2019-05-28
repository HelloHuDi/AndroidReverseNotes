package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.y;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.bbom.a.a;
import com.tencent.mm.plugin.e.e;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MailMMWebView;
import com.tencent.mm.plugin.webview.ui.tools.widget.d;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.xweb.s;
import java.util.ArrayList;
import java.util.List;

public class PluginBigBallOfMudAsync extends f implements a {
    public String toString() {
        return "plugin-big-ball-of-mud-async";
    }

    public void installed() {
        AppMethodBeat.i(18316);
        alias(a.class);
        AppMethodBeat.o(18316);
    }

    public void dependency() {
        AppMethodBeat.i(18317);
        dependsOn(PluginBigBallOfMud.class);
        dependsOn(com.tencent.mm.plugin.notification.b.a.class);
        AppMethodBeat.o(18317);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(18318);
        if (gVar.SG() && ((h) gVar).mProfileCompat != null) {
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile) ((h) gVar).mProfileCompat).getNotification());
        }
        t.a.vlq = new t() {
            public final c a(q qVar, String str, String str2, String str3, boolean z, String str4, com.tencent.mm.pluginsdk.ui.applet.q.a aVar) {
                AppMethodBeat.i(18306);
                c a = com.tencent.mm.pluginsdk.ui.applet.g.a(qVar, str, str2, str3, z, str4, aVar);
                AppMethodBeat.o(18306);
                return a;
            }
        };
        com.tencent.mm.af.q.a.a(new com.tencent.mm.af.q() {
            public final int a(b bVar, String str, String str2, String str3, String str4, byte[] bArr) {
                AppMethodBeat.i(18307);
                int a = l.a(bVar, str, str2, str3, str4, bArr);
                AppMethodBeat.o(18307);
                return a;
            }
        });
        com.tencent.mm.pluginsdk.ui.e.c.a.vrD = new com.tencent.mm.pluginsdk.ui.e.c() {
            public final void a(Context context, String str, OnDismissListener onDismissListener, Bundle bundle) {
                AppMethodBeat.i(18309);
                com.tencent.mm.pluginsdk.ui.e.l.a(context, str, onDismissListener, bundle);
                AppMethodBeat.o(18309);
            }

            public final void a(Context context, List<String> list, OnDismissListener onDismissListener) {
                AppMethodBeat.i(18308);
                if (list.isEmpty() || context == null) {
                    AppMethodBeat.o(18308);
                    return;
                }
                new j(context).a(null, new com.tencent.mm.pluginsdk.ui.e.l.AnonymousClass3(list), new com.tencent.mm.pluginsdk.ui.e.l.AnonymousClass4(context), onDismissListener);
                AppMethodBeat.o(18308);
            }
        };
        com.tencent.mm.plugin.webview.ui.tools.widget.f.a.uJi = new com.tencent.mm.plugin.webview.ui.tools.widget.f() {
            public final MMWebView du(Context context) {
                AppMethodBeat.i(18310);
                MMWebViewWithJsApi fw = MMWebViewWithJsApi.a.fw(context);
                AppMethodBeat.o(18310);
                return fw;
            }
        };
        com.tencent.mm.plugin.webview.ui.tools.widget.g.a.uJj = new com.tencent.mm.plugin.webview.ui.tools.widget.g() {
            public final MMWebView du(Context context) {
                AppMethodBeat.i(18311);
                MailMMWebView.fu(context);
                MailMMWebView mailMMWebView = new MailMMWebView(context);
                mailMMWebView.inited = true;
                AppMethodBeat.o(18311);
                return mailMMWebView;
            }
        };
        com.tencent.mm.plugin.webview.ui.tools.widget.c.a.uJh = new com.tencent.mm.plugin.webview.ui.tools.widget.c() {
            public final s a(MMWebView mMWebView, boolean z, d dVar) {
                AppMethodBeat.i(18312);
                com.tencent.mm.plugin.webview.ui.tools.widget.l lVar = new com.tencent.mm.plugin.webview.ui.tools.widget.l(mMWebView, z, dVar);
                AppMethodBeat.o(18312);
                return lVar;
            }

            public final s a(MMWebView mMWebView, d dVar, Bundle bundle) {
                AppMethodBeat.i(18313);
                com.tencent.mm.plugin.webview.ui.tools.widget.l lVar = new com.tencent.mm.plugin.webview.ui.tools.widget.l(mMWebView, false, dVar, bundle);
                AppMethodBeat.o(18313);
                return lVar;
            }
        };
        com.tencent.mm.plugin.webview.ui.tools.widget.a.a.uJg = new com.tencent.mm.plugin.webview.ui.tools.widget.a() {
            public final com.tencent.xweb.l a(MMWebView mMWebView, com.tencent.mm.plugin.webview.ui.tools.widget.b bVar) {
                AppMethodBeat.i(18314);
                com.tencent.mm.plugin.webview.ui.tools.widget.j jVar = new com.tencent.mm.plugin.webview.ui.tools.widget.j(mMWebView, bVar);
                AppMethodBeat.o(18314);
                return jVar;
            }
        };
        com.tencent.mm.kernel.g.a(ad.class, new com.tencent.mm.pluginsdk.model.f());
        com.tencent.mm.kernel.g.a(v.class, new com.tencent.mm.pluginsdk.model.c());
        if (((h) gVar).mProfileCompat != null && gVar.SG()) {
            WorkerProfile workerProfile = (WorkerProfile) ((h) gVar).mProfileCompat;
            y yVar = workerProfile.cfV;
            x xVar = workerProfile.cfW;
            com.tencent.mm.bp.c.vwA = yVar;
            com.tencent.mm.bp.c.vwB = xVar;
            new e(workerProfile).before(this).after(com.tencent.mm.kernel.g.M(p.class));
        }
        if (gVar.SG()) {
            ((p) com.tencent.mm.kernel.g.M(p.class)).setIDataTransferFactoryDelegate(new aj() {
                public final List<ai> getDataTransferList() {
                    AppMethodBeat.i(18315);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new com.tencent.mm.am.e());
                    arrayList.add(new com.tencent.mm.am.g());
                    arrayList.add(new com.tencent.mm.am.f());
                    arrayList.add(new com.tencent.mm.am.a());
                    arrayList.add(new com.tencent.mm.am.c());
                    arrayList.add(new com.tencent.mm.am.d());
                    arrayList.add(new com.tencent.mm.am.h());
                    arrayList.add(new com.tencent.mm.am.b());
                    AppMethodBeat.o(18315);
                    return arrayList;
                }
            });
        }
        AppMethodBeat.o(18318);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(18319);
        if (((h) gVar).mProfileCompat != null && gVar.SG()) {
            ab.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
            ((h) gVar).mProfileCompat.onCreate();
        }
        if (gVar.SG()) {
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs1de6f3", new com.tencent.mm.plugin.welab.c.b());
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.welab.a.a.d.class)).a(new com.tencent.mm.plugin.welab.e.a());
            ((com.tencent.mm.plugin.welab.a.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.welab.a.a.d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.c.a());
        }
        AppMethodBeat.o(18319);
    }
}
