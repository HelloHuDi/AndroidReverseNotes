package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzi extends WeakReference<Throwable> {
    private final int zzdh;

    public zzi(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        AppMethodBeat.i(57628);
        if (th == null) {
            NullPointerException nullPointerException = new NullPointerException("The referent cannot be null");
            AppMethodBeat.o(57628);
            throw nullPointerException;
        }
        this.zzdh = System.identityHashCode(th);
        AppMethodBeat.o(57628);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(57629);
        if (obj == null || obj.getClass() != getClass()) {
            AppMethodBeat.o(57629);
            return false;
        } else if (this == obj) {
            AppMethodBeat.o(57629);
            return true;
        } else {
            zzi zzi = (zzi) obj;
            if (this.zzdh == zzi.zzdh && get() == zzi.get()) {
                AppMethodBeat.o(57629);
                return true;
            }
            AppMethodBeat.o(57629);
            return false;
        }
    }

    public final int hashCode() {
        return this.zzdh;
    }
}
