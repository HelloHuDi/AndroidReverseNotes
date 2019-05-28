package com.tencent.p177mm.plugin.downloader;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.downloader.a */
public final class C2880a extends FileObserver {
    private String kJG;

    public C2880a(String str) {
        super(str, C45579bb.CTRL_INDEX);
        this.kJG = str;
    }

    public final void onEvent(int i, String str) {
        AppMethodBeat.m2504i(2270);
        if (str == null) {
            C4990ab.m7412e("DownloadsObserver", "path should be null");
            AppMethodBeat.m2505o(2270);
            return;
        }
        String str2 = this.kJG + str;
        switch (i) {
            case 8:
                C4990ab.m7417i("DownloadsObserver", "close write file: %s", str2);
                AppMethodBeat.m2505o(2270);
                return;
            case 32:
                C4990ab.m7417i("DownloadsObserver", "open file: %s", str2);
                AppMethodBeat.m2505o(2270);
                return;
            case 64:
                C4990ab.m7417i("DownloadsObserver", "move from file: %s", str2);
                break;
            case 512:
                C4990ab.m7417i("DownloadsObserver", "delete file: %s", str2);
                AppMethodBeat.m2505o(2270);
                return;
        }
        AppMethodBeat.m2505o(2270);
    }
}
