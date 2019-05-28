package com.tencent.mm.plugin.downloader;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends FileObserver {
    private String kJG;

    public a(String str) {
        super(str, bb.CTRL_INDEX);
        this.kJG = str;
    }

    public final void onEvent(int i, String str) {
        AppMethodBeat.i(2270);
        if (str == null) {
            ab.e("DownloadsObserver", "path should be null");
            AppMethodBeat.o(2270);
            return;
        }
        String str2 = this.kJG + str;
        switch (i) {
            case 8:
                ab.i("DownloadsObserver", "close write file: %s", str2);
                AppMethodBeat.o(2270);
                return;
            case 32:
                ab.i("DownloadsObserver", "open file: %s", str2);
                AppMethodBeat.o(2270);
                return;
            case 64:
                ab.i("DownloadsObserver", "move from file: %s", str2);
                break;
            case 512:
                ab.i("DownloadsObserver", "delete file: %s", str2);
                AppMethodBeat.o(2270);
                return;
        }
        AppMethodBeat.o(2270);
    }
}
