package p000a.p010i.p011b.p012a.p015c.p018b;

import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.p040a.C0131e;

/* renamed from: a.i.b.a.c.b.az */
public abstract class C25082az {
    public final boolean Bfm;
    private final String name;

    /* renamed from: b */
    public abstract boolean mo17859b(C0131e c0131e, C36652p c36652p, C31642l c31642l);

    protected C25082az(String str, boolean z) {
        C25052j.m39376p(str, "name");
        this.name = str;
        this.Bfm = z;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: c */
    public Integer mo31293c(C25082az c25082az) {
        C25052j.m39376p(c25082az, "visibility");
        return C8051ay.m14222a(this, c25082az);
    }

    public String getDisplayName() {
        return this.name;
    }

    public final String toString() {
        return getDisplayName();
    }

    public C25082az eag() {
        return this;
    }
}
