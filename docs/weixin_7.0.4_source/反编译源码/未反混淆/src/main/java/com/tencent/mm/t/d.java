package com.tencent.mm.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d implements b {
    public static a ewX = null;
    public c ewY = null;

    public static void a(a aVar) {
        AppMethodBeat.i(128598);
        ab.i("WXFileDownloaderBridge", "XWalkLib SetFileDownloaderProxy:" + (aVar == null));
        ewX = aVar;
        AppMethodBeat.o(128598);
    }

    public final void f(String str, String str2, boolean z) {
        AppMethodBeat.i(128599);
        ab.i("WXFileDownloaderBridge", "onTaskFinished url=" + str + ", save_path=" + str2);
        this.ewY.onTaskSucc(str, str2, z);
        AppMethodBeat.o(128599);
    }

    public final void d(String str, int i, boolean z) {
        AppMethodBeat.i(128600);
        ab.i("WXFileDownloaderBridge", "onTaskFailed, url=" + str + ", errCode=" + i);
        this.ewY.onTaskFail(str, i, z);
        AppMethodBeat.o(128600);
    }

    public final void e(String str, long j, long j2) {
        AppMethodBeat.i(128601);
        ab.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + str + ", cur_size:" + j + ", total_size:" + j2);
        AppMethodBeat.o(128601);
    }
}
