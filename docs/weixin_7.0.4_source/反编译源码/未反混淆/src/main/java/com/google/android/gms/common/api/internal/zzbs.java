package com.google.android.gms.common.api.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbs implements Runnable {
    private final /* synthetic */ LifecycleCallback zzle;
    private final /* synthetic */ String zzlf;
    private final /* synthetic */ zzbr zzlg;

    zzbs(zzbr zzbr, LifecycleCallback lifecycleCallback, String str) {
        this.zzlg = zzbr;
        this.zzle = lifecycleCallback;
        this.zzlf = str;
    }

    public final void run() {
        AppMethodBeat.i(89499);
        if (this.zzlg.zzlc > 0) {
            this.zzle.onCreate(this.zzlg.zzld != null ? this.zzlg.zzld.getBundle(this.zzlf) : null);
        }
        if (this.zzlg.zzlc >= 2) {
            this.zzle.onStart();
        }
        if (this.zzlg.zzlc >= 3) {
            this.zzle.onResume();
        }
        if (this.zzlg.zzlc >= 4) {
            this.zzle.onStop();
        }
        if (this.zzlg.zzlc >= 5) {
            this.zzle.onDestroy();
        }
        AppMethodBeat.o(89499);
    }
}
