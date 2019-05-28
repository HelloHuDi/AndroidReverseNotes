package p000a.p010i.p011b.p012a.p015c.p045l;

import java.util.List;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C44868a;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;
import p000a.p010i.p011b.p012a.p015c.p045l.p046a.C44917m;

/* renamed from: a.i.b.a.c.l.w */
public abstract class C46867w implements C44868a {
    public abstract C31746h dXR();

    public abstract boolean eci();

    public abstract List<C41446ap> ejt();

    public abstract C17313an ejw();

    public abstract C41447az ekn();

    private C46867w() {
    }

    public /* synthetic */ C46867w(byte b) {
        this();
    }

    public final int hashCode() {
        if (C25239y.m39807an(this)) {
            return super.hashCode();
        }
        return (eci() ? 1 : 0) + (((ejw().hashCode() * 31) + ejt().hashCode()) * 31);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C46867w) {
            return eci() == ((C46867w) obj).eci() && C44917m.BKC.mo72112a(ekn(), ((C46867w) obj).ekn());
        } else {
            return false;
        }
    }
}
