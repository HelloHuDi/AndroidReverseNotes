package com.tencent.mm.plugin.emoji;

import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {
    public static void hF(long j) {
        AppMethodBeat.i(62305);
        ab.i("MicroMsg.emoji.EmojiReportHepler", "report id stat key:%d, value:%d", Long.valueOf(j), Long.valueOf(1));
        h.pYm.a(96, j, 1, false);
        AppMethodBeat.o(62305);
    }

    public static void a(String str, int i, int i2, int i3, String str2, int i4, String str3) {
        AppMethodBeat.i(62306);
        ab.i("MicroMsg.emoji.EmojiReportHepler", "report kv stat md5:%s, downType:%d donwloadResult:%d verifyResult:%d productID:%s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2);
        h.pYm.e(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_END, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4), str3);
        AppMethodBeat.o(62306);
    }
}
