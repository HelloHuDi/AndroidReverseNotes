package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class k extends IOException {
    public q BzY = null;

    public k(String str) {
        super(str);
    }

    static k eiq() {
        AppMethodBeat.i(121531);
        k kVar = new k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        AppMethodBeat.o(121531);
        return kVar;
    }

    static k eir() {
        AppMethodBeat.i(121532);
        k kVar = new k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        AppMethodBeat.o(121532);
        return kVar;
    }

    static k eis() {
        AppMethodBeat.i(121533);
        k kVar = new k("CodedInputStream encountered a malformed varint.");
        AppMethodBeat.o(121533);
        return kVar;
    }

    static k eit() {
        AppMethodBeat.i(121534);
        k kVar = new k("Protocol message contained an invalid tag (zero).");
        AppMethodBeat.o(121534);
        return kVar;
    }

    static k eiu() {
        AppMethodBeat.i(121535);
        k kVar = new k("Protocol message end-group tag did not match expected tag.");
        AppMethodBeat.o(121535);
        return kVar;
    }

    static k eiv() {
        AppMethodBeat.i(121536);
        k kVar = new k("Protocol message tag had invalid wire type.");
        AppMethodBeat.o(121536);
        return kVar;
    }

    static k eiw() {
        AppMethodBeat.i(121537);
        k kVar = new k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        AppMethodBeat.o(121537);
        return kVar;
    }

    static k eix() {
        AppMethodBeat.i(121538);
        k kVar = new k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        AppMethodBeat.o(121538);
        return kVar;
    }
}
