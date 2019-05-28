package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzae implements OnCapabilityChangedListener {
    private final String zzbc;
    private final OnCapabilityChangedListener zzby;

    zzae(OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        this.zzby = onCapabilityChangedListener;
        this.zzbc = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70985);
        if (this == obj) {
            AppMethodBeat.o(70985);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(70985);
            return false;
        } else {
            zzae zzae = (zzae) obj;
            if (this.zzby.equals(zzae.zzby)) {
                boolean equals = this.zzbc.equals(zzae.zzbc);
                AppMethodBeat.o(70985);
                return equals;
            }
            AppMethodBeat.o(70985);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(70986);
        int hashCode = (this.zzby.hashCode() * 31) + this.zzbc.hashCode();
        AppMethodBeat.o(70986);
        return hashCode;
    }

    public final void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        AppMethodBeat.i(70984);
        this.zzby.onCapabilityChanged(capabilityInfo);
        AppMethodBeat.o(70984);
    }
}
