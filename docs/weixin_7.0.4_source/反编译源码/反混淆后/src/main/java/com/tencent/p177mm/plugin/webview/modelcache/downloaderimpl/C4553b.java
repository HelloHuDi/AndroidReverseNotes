package com.tencent.p177mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.downloaderimpl.b */
final class C4553b {

    /* renamed from: com.tencent.mm.plugin.webview.modelcache.downloaderimpl.b$a */
    static final class C4554a {
        /* renamed from: c */
        static void m6932c(String str, C40432m c40432m) {
            AppMethodBeat.m2504i(6904);
            C44049s ajg = C14857a.vfA.ajg(str);
            if (ajg == null) {
                C4990ab.m7413e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "networkRequest already completed, but get null record with urlKey = %s", str);
                AppMethodBeat.m2505o(6904);
            } else if ("WebViewCache".equals(ajg.field_groupId1)) {
                ajg.field_contentType = c40432m.bqF;
                C14857a.vfA.mo27179h(ajg);
                C35616f c35616f = new C35616f(ajg.field_url, ajg.field_filePath, ajg.field_fileVersion, ajg.field_appId, ajg.field_groupId2, ajg.field_packageId, ajg.field_wvCacheType, c40432m.bqF, c40432m.aHW, c40432m.vfo);
                WebViewCacheDownloadHelper.cYr();
                WebViewCacheDownloadHelper.m6927a(c35616f);
                AppMethodBeat.m2505o(6904);
            } else {
                C4990ab.m7413e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "mismatch groupId, urlKey = %s, record.groupId = %s", str, ajg.field_groupId1);
                AppMethodBeat.m2505o(6904);
            }
        }
    }
}
