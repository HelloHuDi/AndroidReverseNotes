package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza implements StatusListener {
    private final /* synthetic */ Batch zzch;

    zza(Batch batch) {
        this.zzch = batch;
    }

    /* JADX WARNING: Missing block: B:16:0x0041, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(61009);
     */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onComplete(Status status) {
        AppMethodBeat.m2504i(61009);
        synchronized (this.zzch.mLock) {
            try {
                if (this.zzch.isCanceled()) {
                } else {
                    if (status.isCanceled()) {
                        this.zzch.zzcf = true;
                    } else if (!status.isSuccess()) {
                        this.zzch.zzce = true;
                    }
                    this.zzch.zzcd = this.zzch.zzcd - 1;
                    if (this.zzch.zzcd == 0) {
                        if (this.zzch.zzcf) {
                            Batch.zze(this.zzch);
                        } else {
                            this.zzch.setResult(new BatchResult(this.zzch.zzce ? new Status(13) : Status.RESULT_SUCCESS, this.zzch.zzcg));
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(61009);
            }
        }
    }
}
