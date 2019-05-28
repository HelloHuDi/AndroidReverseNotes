package com.tencent.mm.plugin.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cj.c;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public class PluginWebView extends f {
    public String name() {
        return "plugin-webview";
    }

    public void execute(g gVar) {
        AppMethodBeat.i(5614);
        if (!(gVar.SG() || gVar.lQ(":tools"))) {
            gVar.lQ(":toolsmp");
        }
        if (gVar.lQ(":toolsmp")) {
            c.a(MMWebView.zNq, new WebView.c() {
                public final void onCoreInitFinished() {
                    AppMethodBeat.i(5612);
                    ab.i("MPToolsMinifiedBootStep", "onCoreInitFinished");
                    vz vzVar = new vz();
                    vzVar.cTk.success = true;
                    a.xxA.m(vzVar);
                    if (((b) com.tencent.mm.kernel.g.K(b.class)).rW(20)) {
                        ((b) com.tencent.mm.kernel.g.K(b.class)).aVR();
                    }
                    AppMethodBeat.o(5612);
                }

                public final void BH() {
                    AppMethodBeat.i(5613);
                    ab.i("MPToolsMinifiedBootStep", "onCoreInitFailed");
                    vz vzVar = new vz();
                    vzVar.cTk.success = false;
                    a.xxA.m(vzVar);
                    AppMethodBeat.o(5613);
                }
            });
        }
        AppMethodBeat.o(5614);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(5615);
        if (gVar.SG() || gVar.lQ(":tools") || gVar.lQ(":toolsmp")) {
            pin(new q(com.tencent.mm.plugin.webview.modeltools.g.class));
        }
        AppMethodBeat.o(5615);
    }
}
