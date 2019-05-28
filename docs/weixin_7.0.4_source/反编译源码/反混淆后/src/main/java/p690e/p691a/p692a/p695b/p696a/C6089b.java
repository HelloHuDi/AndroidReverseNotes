package p690e.p691a.p692a.p695b.p696a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: e.a.a.b.a.b */
public final class C6089b extends IOException {
    private C6089b(String str) {
        super(str);
    }

    static C6089b emv() {
        AppMethodBeat.m2504i(51871);
        C6089b c6089b = new C6089b("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        AppMethodBeat.m2505o(51871);
        return c6089b;
    }

    static C6089b emw() {
        AppMethodBeat.m2504i(51872);
        C6089b c6089b = new C6089b("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        AppMethodBeat.m2505o(51872);
        return c6089b;
    }

    static C6089b emx() {
        AppMethodBeat.m2504i(51873);
        C6089b c6089b = new C6089b("CodedInputStream encountered a malformed varint.");
        AppMethodBeat.m2505o(51873);
        return c6089b;
    }

    public static C6089b emy() {
        AppMethodBeat.m2504i(51874);
        C6089b c6089b = new C6089b("Protocol message contained an invalid tag (zero).");
        AppMethodBeat.m2505o(51874);
        return c6089b;
    }

    static C6089b emz() {
        AppMethodBeat.m2504i(51875);
        C6089b c6089b = new C6089b("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        AppMethodBeat.m2505o(51875);
        return c6089b;
    }
}
