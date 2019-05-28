package com.tencent.xweb.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class d implements b {
    public static a ANp = null;
    public c ANq = null;

    public static void a(a aVar) {
        AppMethodBeat.i(3963);
        Log.i("WXFileDownloaderBridge", "XWalkLib SetFileDownloaderProxy:" + (aVar == null));
        ANp = aVar;
        AppMethodBeat.o(3963);
    }

    public static boolean isValid() {
        return ANp != null;
    }

    public final void f(String str, String str2, boolean z) {
        AppMethodBeat.i(3964);
        Log.i("WXFileDownloaderBridge", "onTaskFinished url=" + str + ", save_path=" + str2);
        this.ANq.onTaskSucc(str, str2, z);
        AppMethodBeat.o(3964);
    }

    public final void d(String str, int i, boolean z) {
        AppMethodBeat.i(3965);
        Log.i("WXFileDownloaderBridge", "onTaskFailed, url=" + str + ", errCode=" + i);
        this.ANq.onTaskFail(str, i, z);
        AppMethodBeat.o(3965);
    }

    public final void e(String str, long j, long j2) {
        AppMethodBeat.i(3966);
        Log.i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + str + ", cur_size:" + j + ", total_size:" + j2);
        this.ANq.onProgressChange(str, j, j2);
        AppMethodBeat.o(3966);
    }
}
