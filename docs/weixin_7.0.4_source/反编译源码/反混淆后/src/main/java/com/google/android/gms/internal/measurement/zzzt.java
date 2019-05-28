package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class zzzt extends IOException {
    private zzaal zzbst = null;

    public zzzt(String str) {
        super(str);
    }

    static zzzt zztm() {
        AppMethodBeat.m2504i(3588);
        zzzt zzzt = new zzzt("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        AppMethodBeat.m2505o(3588);
        return zzzt;
    }

    static zzzt zztn() {
        AppMethodBeat.m2504i(3589);
        zzzt zzzt = new zzzt("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        AppMethodBeat.m2505o(3589);
        return zzzt;
    }
}
