package com.google.p1368a.p1369a;

import java.io.IOException;

/* renamed from: com.google.a.a.d */
public final class C25509d extends IOException {
    private C25509d(String str) {
        super(str);
    }

    /* renamed from: vi */
    static C25509d m40285vi() {
        return new C25509d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: vj */
    static C25509d m40286vj() {
        return new C25509d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: vk */
    static C25509d m40287vk() {
        return new C25509d("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: vl */
    static C25509d m40288vl() {
        return new C25509d("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: vm */
    static C25509d m40289vm() {
        return new C25509d("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: vn */
    static C25509d m40290vn() {
        return new C25509d("Protocol message tag had invalid wire type.");
    }

    /* renamed from: vo */
    static C25509d m40291vo() {
        return new C25509d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
