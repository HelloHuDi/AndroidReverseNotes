package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: a.i.b.a.c.g.k */
public final class C41425k extends IOException {
    public C8185q BzY = null;

    public C41425k(String str) {
        super(str);
    }

    static C41425k eiq() {
        AppMethodBeat.m2504i(121531);
        C41425k c41425k = new C41425k("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        AppMethodBeat.m2505o(121531);
        return c41425k;
    }

    static C41425k eir() {
        AppMethodBeat.m2504i(121532);
        C41425k c41425k = new C41425k("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        AppMethodBeat.m2505o(121532);
        return c41425k;
    }

    static C41425k eis() {
        AppMethodBeat.m2504i(121533);
        C41425k c41425k = new C41425k("CodedInputStream encountered a malformed varint.");
        AppMethodBeat.m2505o(121533);
        return c41425k;
    }

    static C41425k eit() {
        AppMethodBeat.m2504i(121534);
        C41425k c41425k = new C41425k("Protocol message contained an invalid tag (zero).");
        AppMethodBeat.m2505o(121534);
        return c41425k;
    }

    static C41425k eiu() {
        AppMethodBeat.m2504i(121535);
        C41425k c41425k = new C41425k("Protocol message end-group tag did not match expected tag.");
        AppMethodBeat.m2505o(121535);
        return c41425k;
    }

    static C41425k eiv() {
        AppMethodBeat.m2504i(121536);
        C41425k c41425k = new C41425k("Protocol message tag had invalid wire type.");
        AppMethodBeat.m2505o(121536);
        return c41425k;
    }

    static C41425k eiw() {
        AppMethodBeat.m2504i(121537);
        C41425k c41425k = new C41425k("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        AppMethodBeat.m2505o(121537);
        return c41425k;
    }

    static C41425k eix() {
        AppMethodBeat.m2504i(121538);
        C41425k c41425k = new C41425k("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        AppMethodBeat.m2505o(121538);
        return c41425k;
    }
}
