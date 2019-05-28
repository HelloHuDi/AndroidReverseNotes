package com.tencent.p177mm.plugin.game.model.p978a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.game.model.a.c */
public final class C20984c implements C11511k {
    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.m2504i(111498);
        C20984c.m32236e("onTaskStarted", j, true);
        AppMethodBeat.m2505o(111498);
    }

    /* renamed from: b */
    public final void mo7665b(long j, String str, boolean z) {
        AppMethodBeat.m2504i(111499);
        C4990ab.m7416i("MicroMsg.GameSilentDownloadCallback", "onTaskFinished");
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null && hv.field_autoDownload) {
            C20989f.m32248X(hv.field_appId, 0, 0);
            C20984c.m32235NZ(hv.field_appId);
        }
        AppMethodBeat.m2505o(111499);
    }

    /* renamed from: b */
    public final void mo7664b(long j, int i, boolean z) {
        AppMethodBeat.m2504i(111500);
        C4990ab.m7417i("MicroMsg.GameSilentDownloadCallback", "onTaskFailed, errCode:%d", Integer.valueOf(i));
        if (i != C11498a.kJP) {
            C42911a hv = C2895c.m5147hv(j);
            if (hv != null && hv.field_autoDownload) {
                C20989f.m32248X(hv.field_appId, 1, i);
                C20984c.m32235NZ(hv.field_appId);
            }
        }
        AppMethodBeat.m2505o(111500);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.m2504i(111501);
        C4990ab.m7416i("MicroMsg.GameSilentDownloadCallback", "onTaskRemoved");
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null && hv.field_autoDownload) {
            C20989f.m32248X(hv.field_appId, 2, 0);
            C20984c.m32235NZ(hv.field_appId);
        }
        AppMethodBeat.m2505o(111501);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.m2504i(111502);
        C20984c.m32236e("onTaskPaused", j, false);
        AppMethodBeat.m2505o(111502);
    }

    /* renamed from: gm */
    public final void mo7667gm(long j) {
        AppMethodBeat.m2504i(111503);
        C4990ab.m7410d("MicroMsg.GameSilentDownloadCallback", "onTaskProgressChanged");
        AppMethodBeat.m2505o(111503);
    }

    /* renamed from: i */
    public final void mo7669i(long j, String str) {
        AppMethodBeat.m2504i(111504);
        C20984c.m32236e("onTaskResumed", j, true);
        AppMethodBeat.m2505o(111504);
    }

    /* renamed from: gn */
    public final void mo7668gn(long j) {
    }

    /* renamed from: NZ */
    private static void m32235NZ(String str) {
        AppMethodBeat.m2504i(111505);
        C20985d c20985d = new C20985d();
        c20985d.field_appId = str;
        boolean a = ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo16760a((C4925c) c20985d, new String[0]);
        C4990ab.m7417i("MicroMsg.GameSilentDownloadCallback", "removeSilentDownloadTask, appid:%s, ret:%b", str, Boolean.valueOf(a));
        AppMethodBeat.m2505o(111505);
    }

    /* renamed from: e */
    private static void m32236e(String str, long j, boolean z) {
        AppMethodBeat.m2504i(111506);
        C4990ab.m7416i("MicroMsg.GameSilentDownloadCallback", str);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null && hv.field_autoDownload) {
            boolean aQ = ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36309aQ(hv.field_appId, z);
            C4990ab.m7417i("MicroMsg.GameSilentDownloadCallback", "%s. appid:%s, ret:%b", str, hv.field_appId, Boolean.valueOf(aQ));
        }
        AppMethodBeat.m2505o(111506);
    }
}
