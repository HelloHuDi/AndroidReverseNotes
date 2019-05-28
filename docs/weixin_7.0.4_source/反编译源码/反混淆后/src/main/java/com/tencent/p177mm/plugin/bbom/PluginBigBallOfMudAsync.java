package com.tencent.p177mm.plugin.bbom;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.C24654x;
import com.tencent.p177mm.app.C41759y;
import com.tencent.p177mm.app.WorkerProfile;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C1813aj;
import com.tencent.p177mm.p181af.C32225q;
import com.tencent.p177mm.p181af.C32225q.C25748a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.C5536q;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p824am.C17911a;
import com.tencent.p177mm.p824am.C25777g;
import com.tencent.p177mm.p824am.C41750b;
import com.tencent.p177mm.p824am.C41751c;
import com.tencent.p177mm.p824am.C41752d;
import com.tencent.p177mm.p824am.C45151e;
import com.tencent.p177mm.p824am.C8950f;
import com.tencent.p177mm.p824am.C8951h;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.bbom.p922a.C11176a;
import com.tencent.p177mm.plugin.fav.p407a.C34131v;
import com.tencent.p177mm.plugin.fav.p407a.C6893ad;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.p945e.C11544e;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C23153g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C23153g.C23154a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29959f;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29959f.C23152a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C35725b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C35726d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C40347c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C40347c.C40348a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C43988j;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C44792l;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C4655a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C4655a.C4656a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi.C14670a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MailMMWebView;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C14715d;
import com.tencent.p177mm.plugin.welab.p1563e.C40362a;
import com.tencent.p177mm.plugin.welab.p583c.C35736b;
import com.tencent.p177mm.plugin.welab.p583c.C4665a;
import com.tencent.p177mm.pluginsdk.model.C14888c;
import com.tencent.p177mm.pluginsdk.model.C46497f;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23282t;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23282t.C23281a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23314l;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23314l.C233083;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C23314l.C233094;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30129c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30129c.C30130a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C6031l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync */
public class PluginBigBallOfMudAsync extends C7597f implements C11176a {

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync$2 */
    class C167152 implements C32225q {
        C167152() {
        }

        /* renamed from: a */
        public final int mo30686a(C8910b c8910b, String str, String str2, String str3, String str4, byte[] bArr) {
            AppMethodBeat.m2504i(18307);
            int a = C4733l.m7087a(c8910b, str, str2, str3, str4, bArr);
            AppMethodBeat.m2505o(18307);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync$7 */
    class C167167 implements C4655a {
        C167167() {
        }

        /* renamed from: a */
        public final C6031l mo9750a(MMWebView mMWebView, C35725b c35725b) {
            AppMethodBeat.m2504i(18314);
            C43988j c43988j = new C43988j(mMWebView, c35725b);
            AppMethodBeat.m2505o(18314);
            return c43988j;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync$1 */
    class C167171 implements C23282t {
        C167171() {
        }

        /* renamed from: a */
        public final C5653c mo30687a(C5536q c5536q, String str, String str2, String str3, boolean z, String str4, C30111a c30111a) {
            AppMethodBeat.m2504i(18306);
            C5653c a = C35844g.m58765a(c5536q, str, str2, str3, z, str4, c30111a);
            AppMethodBeat.m2505o(18306);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync$8 */
    class C167188 implements C1813aj {
        C167188() {
        }

        public final List<C1812ai> getDataTransferList() {
            AppMethodBeat.m2504i(18315);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C45151e());
            arrayList.add(new C25777g());
            arrayList.add(new C8950f());
            arrayList.add(new C17911a());
            arrayList.add(new C41751c());
            arrayList.add(new C41752d());
            arrayList.add(new C8951h());
            arrayList.add(new C41750b());
            AppMethodBeat.m2505o(18315);
            return arrayList;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync$5 */
    class C167195 implements C23153g {
        C167195() {
        }

        /* renamed from: du */
        public final MMWebView mo30688du(Context context) {
            AppMethodBeat.m2504i(18311);
            MailMMWebView.m35519fu(context);
            MailMMWebView mailMMWebView = new MailMMWebView(context);
            mailMMWebView.inited = true;
            AppMethodBeat.m2505o(18311);
            return mailMMWebView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync$3 */
    class C167203 implements C30129c {
        C167203() {
        }

        /* renamed from: a */
        public final void mo30689a(Context context, String str, OnDismissListener onDismissListener, Bundle bundle) {
            AppMethodBeat.m2504i(18309);
            C23314l.m35797a(context, str, onDismissListener, bundle);
            AppMethodBeat.m2505o(18309);
        }

        /* renamed from: a */
        public final void mo30690a(Context context, List<String> list, OnDismissListener onDismissListener) {
            AppMethodBeat.m2504i(18308);
            if (list.isEmpty() || context == null) {
                AppMethodBeat.m2505o(18308);
                return;
            }
            new C46696j(context).mo75006a(null, new C233083(list), new C233094(context), onDismissListener);
            AppMethodBeat.m2505o(18308);
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync$4 */
    class C167214 implements C29959f {
        C167214() {
        }

        /* renamed from: du */
        public final MMWebView mo30691du(Context context) {
            AppMethodBeat.m2504i(18310);
            MMWebViewWithJsApi fw = C14670a.m22876fw(context);
            AppMethodBeat.m2505o(18310);
            return fw;
        }
    }

    /* renamed from: com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync$6 */
    class C167226 implements C40347c {
        C167226() {
        }

        /* renamed from: a */
        public final C36592s mo30693a(MMWebView mMWebView, boolean z, C35726d c35726d) {
            AppMethodBeat.m2504i(18312);
            C44792l c44792l = new C44792l(mMWebView, z, c35726d);
            AppMethodBeat.m2505o(18312);
            return c44792l;
        }

        /* renamed from: a */
        public final C36592s mo30692a(MMWebView mMWebView, C35726d c35726d, Bundle bundle) {
            AppMethodBeat.m2504i(18313);
            C44792l c44792l = new C44792l(mMWebView, false, c35726d, bundle);
            AppMethodBeat.m2505o(18313);
            return c44792l;
        }
    }

    public String toString() {
        return "plugin-big-ball-of-mud-async";
    }

    public void installed() {
        AppMethodBeat.m2504i(18316);
        alias(C11176a.class);
        AppMethodBeat.m2505o(18316);
    }

    public void dependency() {
        AppMethodBeat.m2504i(18317);
        dependsOn(PluginBigBallOfMud.class);
        dependsOn(C46115a.class);
        AppMethodBeat.m2505o(18317);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(18318);
        if (c1681g.mo5181SG() && ((C6624h) c1681g).mProfileCompat != null) {
            ((C46115a) C1720g.m3530M(C46115a.class)).setNotification(((WorkerProfile) ((C6624h) c1681g).mProfileCompat).getNotification());
        }
        C23281a.vlq = new C167171();
        C25748a.m40881a(new C167152());
        C30130a.vrD = new C167203();
        C23152a.uJi = new C167214();
        C23154a.uJj = new C167195();
        C40348a.uJh = new C167226();
        C4656a.uJg = new C167167();
        C1720g.m3542a(C6893ad.class, new C46497f());
        C1720g.m3542a(C34131v.class, new C14888c());
        if (((C6624h) c1681g).mProfileCompat != null && c1681g.mo5181SG()) {
            WorkerProfile workerProfile = (WorkerProfile) ((C6624h) c1681g).mProfileCompat;
            C41759y c41759y = workerProfile.cfV;
            C24654x c24654x = workerProfile.cfW;
            C9204c.vwA = c41759y;
            C9204c.vwB = c24654x;
            new C11544e(workerProfile).before(this).after(C1720g.m3530M(C6983p.class));
        }
        if (c1681g.mo5181SG()) {
            ((C6983p) C1720g.m3530M(C6983p.class)).setIDataTransferFactoryDelegate(new C167188());
        }
        AppMethodBeat.m2505o(18318);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(18319);
        if (((C6624h) c1681g).mProfileCompat != null && c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
            ((C6624h) c1681g).mProfileCompat.onCreate();
        }
        if (c1681g.mo5181SG()) {
            ((C14715d) C1720g.m3528K(C14715d.class)).mo26983a("labs1de6f3", new C35736b());
            ((C14715d) C1720g.m3528K(C14715d.class)).mo26982a(new C40362a());
            ((C14715d) C1720g.m3528K(C14715d.class)).mo26983a("labs_browse", new C4665a());
        }
        AppMethodBeat.m2505o(18319);
    }
}
