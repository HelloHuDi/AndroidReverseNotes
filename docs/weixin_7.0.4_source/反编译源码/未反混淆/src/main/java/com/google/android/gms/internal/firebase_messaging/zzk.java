package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzk extends WeakReference<Throwable> {
    private final int zzj;

    public zzk(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        AppMethodBeat.i(108683);
        if (th == null) {
            NullPointerException nullPointerException = new NullPointerException("The referent cannot be null");
            AppMethodBeat.o(108683);
            throw nullPointerException;
        }
        this.zzj = System.identityHashCode(th);
        AppMethodBeat.o(108683);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(108684);
        if (obj == null || obj.getClass() != getClass()) {
            AppMethodBeat.o(108684);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(108684);
            return true;
        } else {
            zzk zzk = (zzk) obj;
            if (this.zzj == zzk.zzj && get() == zzk.get()) {
                AppMethodBeat.o(108684);
                return true;
            }
            AppMethodBeat.o(108684);
            return false;
        }
    }

    public final int hashCode() {
        return this.zzj;
    }
}
