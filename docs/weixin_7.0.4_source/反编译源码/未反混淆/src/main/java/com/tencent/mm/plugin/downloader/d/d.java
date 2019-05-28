package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;

public final class d {

    /* renamed from: com.tencent.mm.plugin.downloader.d.d$1 */
    static class AnonymousClass1 extends HashMap<String, String> {
        final /* synthetic */ String kMd;

        AnonymousClass1(String str) {
            this.kMd = str;
            AppMethodBeat.i(2313);
            put(DownloadInfoColumns.CHANNELID, this.kMd);
            AppMethodBeat.o(2313);
        }
    }
}
