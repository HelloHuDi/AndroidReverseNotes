package e.a.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class b extends IOException {
    private b(String str) {
        super(str);
    }

    static b emv() {
        AppMethodBeat.i(51871);
        b bVar = new b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        AppMethodBeat.o(51871);
        return bVar;
    }

    static b emw() {
        AppMethodBeat.i(51872);
        b bVar = new b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        AppMethodBeat.o(51872);
        return bVar;
    }

    static b emx() {
        AppMethodBeat.i(51873);
        b bVar = new b("CodedInputStream encountered a malformed varint.");
        AppMethodBeat.o(51873);
        return bVar;
    }

    public static b emy() {
        AppMethodBeat.i(51874);
        b bVar = new b("Protocol message contained an invalid tag (zero).");
        AppMethodBeat.o(51874);
        return bVar;
    }

    static b emz() {
        AppMethodBeat.i(51875);
        b bVar = new b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        AppMethodBeat.o(51875);
        return bVar;
    }
}
