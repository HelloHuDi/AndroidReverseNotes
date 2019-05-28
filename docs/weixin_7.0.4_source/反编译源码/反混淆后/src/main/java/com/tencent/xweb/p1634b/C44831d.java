package com.tencent.xweb.p1634b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.b.d */
public final class C44831d implements C44574b {
    public static C44573a ANp = null;
    public C44575c ANq = null;

    /* renamed from: a */
    public static void m82031a(C44573a c44573a) {
        AppMethodBeat.m2504i(3963);
        Log.m81049i("WXFileDownloaderBridge", "XWalkLib SetFileDownloaderProxy:" + (c44573a == null));
        ANp = c44573a;
        AppMethodBeat.m2505o(3963);
    }

    public static boolean isValid() {
        return ANp != null;
    }

    /* renamed from: f */
    public final void mo71376f(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(3964);
        Log.m81049i("WXFileDownloaderBridge", "onTaskFinished url=" + str + ", save_path=" + str2);
        this.ANq.onTaskSucc(str, str2, z);
        AppMethodBeat.m2505o(3964);
    }

    /* renamed from: d */
    public final void mo71374d(String str, int i, boolean z) {
        AppMethodBeat.m2504i(3965);
        Log.m81049i("WXFileDownloaderBridge", "onTaskFailed, url=" + str + ", errCode=" + i);
        this.ANq.onTaskFail(str, i, z);
        AppMethodBeat.m2505o(3965);
    }

    /* renamed from: e */
    public final void mo71375e(String str, long j, long j2) {
        AppMethodBeat.m2504i(3966);
        Log.m81049i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + str + ", cur_size:" + j + ", total_size:" + j2);
        this.ANq.onProgressChange(str, j, j2);
        AppMethodBeat.m2505o(3966);
    }
}
