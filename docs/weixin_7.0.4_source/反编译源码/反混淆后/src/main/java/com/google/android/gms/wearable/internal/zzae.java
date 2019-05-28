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
        AppMethodBeat.m2504i(70985);
        if (this == obj) {
            AppMethodBeat.m2505o(70985);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(70985);
            return false;
        } else {
            zzae zzae = (zzae) obj;
            if (this.zzby.equals(zzae.zzby)) {
                boolean equals = this.zzbc.equals(zzae.zzbc);
                AppMethodBeat.m2505o(70985);
                return equals;
            }
            AppMethodBeat.m2505o(70985);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(70986);
        int hashCode = (this.zzby.hashCode() * 31) + this.zzbc.hashCode();
        AppMethodBeat.m2505o(70986);
        return hashCode;
    }

    public final void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        AppMethodBeat.m2504i(70984);
        this.zzby.onCapabilityChanged(capabilityInfo);
        AppMethodBeat.m2505o(70984);
    }
}
