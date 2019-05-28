package com.tencent.p177mm.plugin.downloader.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.downloader.model.i */
final class C38852i extends C45831h {
    public C38852i(C2886b c2886b) {
        super(c2886b);
    }

    /* renamed from: a */
    public final long mo23223a(C42911a c42911a) {
        return 0;
    }

    /* renamed from: hl */
    public final int mo23225hl(long j) {
        return 1;
    }

    /* renamed from: hm */
    public final FileDownloadTaskInfo mo23226hm(long j) {
        AppMethodBeat.m2504i(2464);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.f16167id = j;
        fileDownloadTaskInfo.status = -1;
        AppMethodBeat.m2505o(2464);
        return fileDownloadTaskInfo;
    }

    /* renamed from: hn */
    public final boolean mo23227hn(long j) {
        return false;
    }

    /* renamed from: ho */
    public final boolean mo23228ho(long j) {
        return false;
    }

    /* renamed from: a */
    public final long mo23224a(C2900e c2900e) {
        AppMethodBeat.m2504i(2463);
        if (C5046bo.isNullOrNil(c2900e.gUx)) {
            AppMethodBeat.m2505o(2463);
            return -1;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(c2900e.gUx));
        intent.addFlags(268435456);
        try {
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(2463);
            return 0;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + e.toString());
            AppMethodBeat.m2505o(2463);
            return -1;
        }
    }
}
