package com.tencent.p177mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.notification.C34633c;

/* renamed from: com.tencent.mm.plugin.downloader.intentservice.DownloadReceiver */
public class DownloadReceiver extends ResultReceiver {
    private static final String TAG = DownloadReceiver.class.getSimpleName();
    /* renamed from: Fw */
    private C0358c f17195Fw;

    static {
        AppMethodBeat.m2504i(2339);
        AppMethodBeat.m2505o(2339);
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        AppMethodBeat.m2504i(2338);
        super.onReceiveResult(i, bundle);
        if (i == 4657) {
            int i2 = bundle.getInt("progress");
            if (C34633c.oVm == null) {
                AppMethodBeat.m2505o(2338);
                return;
            } else if (i2 < 100) {
                this.f17195Fw.mo618b(100, i2, false).mo623e("Download in progress:".concat(String.valueOf(i2)));
                C34633c.oVm.notify(4657, this.f17195Fw.build());
                AppMethodBeat.m2505o(2338);
                return;
            } else {
                this.f17195Fw.mo618b(0, 0, false).mo623e("Download Complete");
                C34633c.oVm.notify(4658, this.f17195Fw.build());
            }
        }
        AppMethodBeat.m2505o(2338);
    }
}
