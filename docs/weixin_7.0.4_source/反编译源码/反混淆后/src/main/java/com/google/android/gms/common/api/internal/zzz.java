package com.google.android.gms.common.api.internal;

import android.support.p057v4.p065f.C6197a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Map;

final class zzz implements OnCompleteListener<Map<zzh<?>, String>> {
    private final /* synthetic */ zzw zzgu;
    private SignInConnectionListener zzgv;

    zzz(zzw zzw, SignInConnectionListener signInConnectionListener) {
        this.zzgu = zzw;
        this.zzgv = signInConnectionListener;
    }

    /* Access modifiers changed, original: final */
    public final void cancel() {
        AppMethodBeat.m2504i(61007);
        this.zzgv.onComplete();
        AppMethodBeat.m2505o(61007);
    }

    public final void onComplete(Task<Map<zzh<?>, String>> task) {
        AppMethodBeat.m2504i(61008);
        this.zzgu.zzga.lock();
        try {
            if (this.zzgu.zzgp) {
                if (task.isSuccessful()) {
                    this.zzgu.zzgr = new C6197a(this.zzgu.zzgh.size());
                    for (zzv zzm : this.zzgu.zzgh.values()) {
                        this.zzgu.zzgr.put(zzm.zzm(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    if (this.zzgu.zzgn) {
                        this.zzgu.zzgr = new C6197a(this.zzgu.zzgh.size());
                        for (zzv zzv : this.zzgu.zzgh.values()) {
                            zzh zzm2 = zzv.zzm();
                            ConnectionResult connectionResult = availabilityException.getConnectionResult(zzv);
                            if (zzw.zza(this.zzgu, zzv, connectionResult)) {
                                this.zzgu.zzgr.put(zzm2, new ConnectionResult(16));
                            } else {
                                this.zzgu.zzgr.put(zzm2, connectionResult);
                            }
                        }
                    } else {
                        this.zzgu.zzgr = availabilityException.zzl();
                    }
                } else {
                    task.getException();
                    this.zzgu.zzgr = Collections.emptyMap();
                }
                if (this.zzgu.isConnected()) {
                    this.zzgu.zzgq.putAll(this.zzgu.zzgr);
                    if (zzw.zzf(this.zzgu) == null) {
                        zzw.zzi(this.zzgu);
                        zzw.zzj(this.zzgu);
                        this.zzgu.zzgl.signalAll();
                    }
                }
                this.zzgv.onComplete();
                this.zzgu.zzga.unlock();
                AppMethodBeat.m2505o(61008);
                return;
            }
            this.zzgv.onComplete();
        } finally {
            this.zzgu.zzga.unlock();
            AppMethodBeat.m2505o(61008);
        }
    }
}
