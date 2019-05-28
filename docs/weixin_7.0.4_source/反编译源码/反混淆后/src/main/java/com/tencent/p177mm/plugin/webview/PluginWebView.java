package com.tencent.p177mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C45381vz;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.webview.modeltools.C29833g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.WebView.C46828c;

/* renamed from: com.tencent.mm.plugin.webview.PluginWebView */
public class PluginWebView extends C7597f {

    /* renamed from: com.tencent.mm.plugin.webview.PluginWebView$1 */
    class C76401 implements C46828c {
        C76401() {
        }

        public final void onCoreInitFinished() {
            AppMethodBeat.m2504i(5612);
            C4990ab.m7416i("MPToolsMinifiedBootStep", "onCoreInitFinished");
            C45381vz c45381vz = new C45381vz();
            c45381vz.cTk.success = true;
            C4879a.xxA.mo10055m(c45381vz);
            if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(20)) {
                ((C20023b) C1720g.m3528K(C20023b.class)).aVR();
            }
            AppMethodBeat.m2505o(5612);
        }

        /* renamed from: BH */
        public final void mo4528BH() {
            AppMethodBeat.m2504i(5613);
            C4990ab.m7416i("MPToolsMinifiedBootStep", "onCoreInitFailed");
            C45381vz c45381vz = new C45381vz();
            c45381vz.cTk.success = false;
            C4879a.xxA.mo10055m(c45381vz);
            AppMethodBeat.m2505o(5613);
        }
    }

    public String name() {
        return "plugin-webview";
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(5614);
        if (!(c1681g.mo5181SG() || c1681g.mo5183lQ(":tools"))) {
            c1681g.mo5183lQ(":toolsmp");
        }
        if (c1681g.mo5183lQ(":toolsmp")) {
            C45287c.m83503a(MMWebView.zNq, new C76401());
        }
        AppMethodBeat.m2505o(5614);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(5615);
        if (c1681g.mo5181SG() || c1681g.mo5183lQ(":tools") || c1681g.mo5183lQ(":toolsmp")) {
            pin(new C7485q(C29833g.class));
        }
        AppMethodBeat.m2505o(5615);
    }
}
