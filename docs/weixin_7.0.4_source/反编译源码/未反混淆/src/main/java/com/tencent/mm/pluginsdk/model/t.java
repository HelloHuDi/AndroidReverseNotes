package com.tencent.mm.pluginsdk.model;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class t extends FileObserver {
    private String qlC;
    private a vbH;

    public interface a {
        void csU();
    }

    public t(String str, a aVar) {
        super(str);
        AppMethodBeat.i(79226);
        ab.i("MicroMsg.ScreenshotObserver", "observer  ".concat(String.valueOf(str)));
        this.vbH = aVar;
        AppMethodBeat.o(79226);
    }

    public final void onEvent(int i, String str) {
        AppMethodBeat.i(79227);
        if (str != null && i == 8 && (this.qlC == null || !str.equalsIgnoreCase(this.qlC))) {
            this.qlC = str;
            this.vbH.csU();
            ab.i("MicroMsg.ScreenshotObserver", "Send event to listener. ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(79227);
    }

    public final void start() {
        AppMethodBeat.i(79228);
        super.startWatching();
        AppMethodBeat.o(79228);
    }

    public final void stop() {
        AppMethodBeat.i(79229);
        super.stopWatching();
        AppMethodBeat.o(79229);
    }
}
