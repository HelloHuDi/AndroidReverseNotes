package com.tencent.p177mm.plugin.emoji;

import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.emoji.c */
public final class C38876c {
    /* renamed from: hF */
    public static void m65942hF(long j) {
        AppMethodBeat.m2504i(62305);
        C4990ab.m7417i("MicroMsg.emoji.EmojiReportHepler", "report id stat key:%d, value:%d", Long.valueOf(j), Long.valueOf(1));
        C7060h.pYm.mo8378a(96, j, 1, false);
        AppMethodBeat.m2505o(62305);
    }

    /* renamed from: a */
    public static void m65941a(String str, int i, int i2, int i3, String str2, int i4, String str3) {
        AppMethodBeat.m2504i(62306);
        C4990ab.m7417i("MicroMsg.emoji.EmojiReportHepler", "report kv stat md5:%s, downType:%d donwloadResult:%d verifyResult:%d productID:%s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2);
        C7060h.pYm.mo8381e(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_END, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4), str3);
        AppMethodBeat.m2505o(62306);
    }
}
