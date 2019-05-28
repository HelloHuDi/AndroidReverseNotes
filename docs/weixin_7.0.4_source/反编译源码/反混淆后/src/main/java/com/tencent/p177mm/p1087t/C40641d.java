package com.tencent.p177mm.p1087t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.t.d */
public final class C40641d implements C30310b {
    public static C15446a ewX = null;
    public C40640c ewY = null;

    /* renamed from: a */
    public static void m70195a(C15446a c15446a) {
        AppMethodBeat.m2504i(128598);
        C4990ab.m7416i("WXFileDownloaderBridge", "XWalkLib SetFileDownloaderProxy:" + (c15446a == null));
        ewX = c15446a;
        AppMethodBeat.m2505o(128598);
    }

    /* renamed from: f */
    public final void mo48603f(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(128599);
        C4990ab.m7416i("WXFileDownloaderBridge", "onTaskFinished url=" + str + ", save_path=" + str2);
        this.ewY.onTaskSucc(str, str2, z);
        AppMethodBeat.m2505o(128599);
    }

    /* renamed from: d */
    public final void mo48601d(String str, int i, boolean z) {
        AppMethodBeat.m2504i(128600);
        C4990ab.m7416i("WXFileDownloaderBridge", "onTaskFailed, url=" + str + ", errCode=" + i);
        this.ewY.onTaskFail(str, i, z);
        AppMethodBeat.m2505o(128600);
    }

    /* renamed from: e */
    public final void mo48602e(String str, long j, long j2) {
        AppMethodBeat.m2504i(128601);
        C4990ab.m7416i("WXFileDownloaderBridge", "onTaskProgressChanged, url=" + str + ", cur_size:" + j + ", total_size:" + j2);
        AppMethodBeat.m2505o(128601);
    }
}
