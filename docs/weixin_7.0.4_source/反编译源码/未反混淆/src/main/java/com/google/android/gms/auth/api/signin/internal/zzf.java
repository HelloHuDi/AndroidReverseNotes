package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zzf extends a<Void> implements SignInConnectionListener {
    private Semaphore zzet = new Semaphore(0);
    private Set<GoogleApiClient> zzeu;

    public zzf(Context context, Set<GoogleApiClient> set) {
        super(context);
        AppMethodBeat.i(50421);
        this.zzeu = set;
        AppMethodBeat.o(50421);
    }

    private final Void zzm() {
        int i;
        AppMethodBeat.i(50422);
        int i2 = 0;
        Iterator it = this.zzeu.iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                i2 = ((GoogleApiClient) it.next()).maybeSignIn(this) ? i + 1 : i;
            } else {
                try {
                    break;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        this.zzet.tryAcquire(i, 5, TimeUnit.SECONDS);
        AppMethodBeat.o(50422);
        return null;
    }

    public final /* synthetic */ Object loadInBackground() {
        AppMethodBeat.i(50425);
        Void zzm = zzm();
        AppMethodBeat.o(50425);
        return zzm;
    }

    public final void onComplete() {
        AppMethodBeat.i(50424);
        this.zzet.release();
        AppMethodBeat.o(50424);
    }

    public final void onStartLoading() {
        AppMethodBeat.i(50423);
        this.zzet.drainPermits();
        forceLoad();
        AppMethodBeat.o(50423);
    }
}
