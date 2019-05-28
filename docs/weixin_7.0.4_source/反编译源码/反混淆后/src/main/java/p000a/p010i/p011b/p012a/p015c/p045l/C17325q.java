package p000a.p010i.p011b.p012a.p015c.p045l;

import java.util.List;
import p000a.p005f.p007b.C25052j;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p036h.C0125i;
import p000a.p010i.p011b.p012a.p015c.p036h.C31724c;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;

/* renamed from: a.i.b.a.c.l.q */
public abstract class C17325q extends C41447az implements C41445ak {
    public final C8235ad BJx;
    public final C8235ad BJy;

    /* renamed from: a */
    public abstract String mo31390a(C31724c c31724c, C0125i c0125i);

    public abstract C8235ad eby();

    public C17325q(C8235ad c8235ad, C8235ad c8235ad2) {
        C25052j.m39376p(c8235ad, "lowerBound");
        C25052j.m39376p(c8235ad2, "upperBound");
        super();
        this.BJx = c8235ad;
        this.BJy = c8235ad2;
    }

    public final C46867w eju() {
        return this.BJx;
    }

    public final C46867w ejv() {
        return this.BJy;
    }

    /* renamed from: ad */
    public final boolean mo31391ad(C46867w c46867w) {
        C25052j.m39376p(c46867w, "type");
        return false;
    }

    public C0026g dYn() {
        return eby().dYn();
    }

    public final C17313an ejw() {
        return eby().ejw();
    }

    public final List<C41446ap> ejt() {
        return eby().ejt();
    }

    public boolean eci() {
        return eby().eci();
    }

    public C31746h dXR() {
        return eby().dXR();
    }

    public String toString() {
        return C31724c.BBN.mo13665b(this);
    }
}
