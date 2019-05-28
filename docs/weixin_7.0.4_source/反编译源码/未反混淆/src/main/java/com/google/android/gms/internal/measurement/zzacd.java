package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class zzacd extends IOException {
    public zzacd(String str) {
        super(str);
    }

    static zzacd zzvh() {
        AppMethodBeat.i(3512);
        zzacd zzacd = new zzacd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        AppMethodBeat.o(3512);
        return zzacd;
    }

    static zzacd zzvi() {
        AppMethodBeat.i(3513);
        zzacd zzacd = new zzacd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        AppMethodBeat.o(3513);
        return zzacd;
    }

    static zzacd zzvj() {
        AppMethodBeat.i(3514);
        zzacd zzacd = new zzacd("CodedInputStream encountered a malformed varint.");
        AppMethodBeat.o(3514);
        return zzacd;
    }

    static zzacd zzvk() {
        AppMethodBeat.i(3515);
        zzacd zzacd = new zzacd("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        AppMethodBeat.o(3515);
        return zzacd;
    }
}
