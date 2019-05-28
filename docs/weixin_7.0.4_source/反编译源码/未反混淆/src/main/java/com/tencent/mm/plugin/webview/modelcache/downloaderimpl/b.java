package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.ab;

final class b {

    static final class a {
        static void c(String str, m mVar) {
            AppMethodBeat.i(6904);
            s ajg = com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.ajg(str);
            if (ajg == null) {
                ab.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "networkRequest already completed, but get null record with urlKey = %s", str);
                AppMethodBeat.o(6904);
            } else if ("WebViewCache".equals(ajg.field_groupId1)) {
                ajg.field_contentType = mVar.bqF;
                com.tencent.mm.pluginsdk.g.a.c.q.a.vfA.h(ajg);
                f fVar = new f(ajg.field_url, ajg.field_filePath, ajg.field_fileVersion, ajg.field_appId, ajg.field_groupId2, ajg.field_packageId, ajg.field_wvCacheType, mVar.bqF, mVar.aHW, mVar.vfo);
                WebViewCacheDownloadHelper.cYr();
                WebViewCacheDownloadHelper.a(fVar);
                AppMethodBeat.o(6904);
            } else {
                ab.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "mismatch groupId, urlKey = %s, record.groupId = %s", str, ajg.field_groupId1);
                AppMethodBeat.o(6904);
            }
        }
    }
}
