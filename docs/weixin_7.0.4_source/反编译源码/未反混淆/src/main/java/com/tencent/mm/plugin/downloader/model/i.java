package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class i extends h {
    public i(b bVar) {
        super(bVar);
    }

    public final long a(a aVar) {
        return 0;
    }

    public final int hl(long j) {
        return 1;
    }

    public final FileDownloadTaskInfo hm(long j) {
        AppMethodBeat.i(2464);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        fileDownloadTaskInfo.status = -1;
        AppMethodBeat.o(2464);
        return fileDownloadTaskInfo;
    }

    public final boolean hn(long j) {
        return false;
    }

    public final boolean ho(long j) {
        return false;
    }

    public final long a(e eVar) {
        AppMethodBeat.i(2463);
        if (bo.isNullOrNil(eVar.gUx)) {
            AppMethodBeat.o(2463);
            return -1;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(eVar.gUx));
        intent.addFlags(268435456);
        try {
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(2463);
            return 0;
        } catch (Exception e) {
            ab.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + e.toString());
            AppMethodBeat.o(2463);
            return -1;
        }
    }
}
