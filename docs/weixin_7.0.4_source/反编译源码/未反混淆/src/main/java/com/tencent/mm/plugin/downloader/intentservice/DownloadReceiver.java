package com.tencent.mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.v.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DownloadReceiver extends ResultReceiver {
    private static final String TAG = DownloadReceiver.class.getSimpleName();
    private c Fw;

    static {
        AppMethodBeat.i(2339);
        AppMethodBeat.o(2339);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.i(2338);
        super.onReceiveResult(i, bundle);
        if (i == 4657) {
            int i2 = bundle.getInt("progress");
            if (com.tencent.mm.plugin.notification.c.oVm == null) {
                AppMethodBeat.o(2338);
                return;
            } else if (i2 < 100) {
                this.Fw.b(100, i2, false).e("Download in progress:".concat(String.valueOf(i2)));
                com.tencent.mm.plugin.notification.c.oVm.notify(4657, this.Fw.build());
                AppMethodBeat.o(2338);
                return;
            } else {
                this.Fw.b(0, 0, false).e("Download Complete");
                com.tencent.mm.plugin.notification.c.oVm.notify(4658, this.Fw.build());
            }
        }
        AppMethodBeat.o(2338);
    }
}
