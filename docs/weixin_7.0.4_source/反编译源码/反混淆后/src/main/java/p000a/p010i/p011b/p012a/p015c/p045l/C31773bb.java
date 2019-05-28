package p000a.p010i.p011b.p012a.p015c.p045l;

import java.util.List;
import p000a.C44941v;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p037i.p039e.C31746h;

/* renamed from: a.i.b.a.c.l.bb */
public abstract class C31773bb extends C46867w {
    public abstract C46867w eko();

    public C31773bb() {
        super();
    }

    public boolean ekf() {
        return true;
    }

    public final C0026g dYn() {
        return eko().dYn();
    }

    public final C17313an ejw() {
        return eko().ejw();
    }

    public final List<C41446ap> ejt() {
        return eko().ejt();
    }

    public final boolean eci() {
        return eko().eci();
    }

    public final C31746h dXR() {
        return eko().dXR();
    }

    public final C41447az ekn() {
        C46867w eko = eko();
        while (eko instanceof C31773bb) {
            eko = ((C31773bb) eko).eko();
        }
        if (eko != null) {
            return (C41447az) eko;
        }
        throw new C44941v("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    }

    public String toString() {
        if (ekf()) {
            return eko().toString();
        }
        return "<Not computed yet>";
    }
}
