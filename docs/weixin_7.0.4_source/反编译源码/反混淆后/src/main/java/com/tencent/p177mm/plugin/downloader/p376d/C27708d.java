package com.tencent.p177mm.plugin.downloader.p376d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.downloader.d.d */
public final class C27708d {

    /* renamed from: com.tencent.mm.plugin.downloader.d.d$1 */
    static class C277091 extends HashMap<String, String> {
        final /* synthetic */ String kMd;

        C277091(String str) {
            this.kMd = str;
            AppMethodBeat.m2504i(2313);
            put(DownloadInfoColumns.CHANNELID, this.kMd);
            AppMethodBeat.m2505o(2313);
        }
    }
}
