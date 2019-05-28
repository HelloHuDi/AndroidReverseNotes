package com.tencent.p177mm.plugin.downloader_app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C42913e;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C42914f;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C45832c;
import com.tencent.p177mm.plugin.downloader_app.p377b.C42918d;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45837j;

/* renamed from: com.tencent.mm.plugin.downloader_app.PluginDownloaderApp */
public class PluginDownloaderApp extends C7597f implements C9562c, C42914f {
    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(136027);
        if (c1681g.mo5181SG()) {
            C1720g.m3542a(C42913e.class, new C44730c());
            C1720g.m3542a(C38855d.class, new C42921b());
            C1720g.m3542a(C45832c.class, new C42915a());
        }
        AppMethodBeat.m2505o(136027);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(136028);
        C42918d.bie();
        C45837j.biO();
        AppMethodBeat.m2505o(136028);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(136029);
        C42918d.bgr();
        C45837j.stop();
        AppMethodBeat.m2505o(136029);
    }
}
