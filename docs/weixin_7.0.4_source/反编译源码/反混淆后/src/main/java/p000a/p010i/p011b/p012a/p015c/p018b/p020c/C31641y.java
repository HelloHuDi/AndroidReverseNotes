package p000a.p010i.p011b.p012a.p015c.p018b.p020c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p000a.p010i.p011b.p012a.p015c.p018b.C17153ag;
import p000a.p010i.p011b.p012a.p015c.p018b.C25082az;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b;
import p000a.p010i.p011b.p012a.p015c.p018b.C25085b.C8063a;
import p000a.p010i.p011b.p012a.p015c.p018b.C31220ah;
import p000a.p010i.p011b.p012a.p015c.p018b.C31642l;
import p000a.p010i.p011b.p012a.p015c.p018b.C31643m;
import p000a.p010i.p011b.p012a.p015c.p018b.C36955ar;
import p000a.p010i.p011b.p012a.p015c.p018b.C41396ak;
import p000a.p010i.p011b.p012a.p015c.p018b.C41398am;
import p000a.p010i.p011b.p012a.p015c.p018b.C44879w;
import p000a.p010i.p011b.p012a.p015c.p018b.C8045a.C8037a;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t;
import p000a.p010i.p011b.p012a.p015c.p018b.C8083t.C8084a;
import p000a.p010i.p011b.p012a.p015c.p018b.p019a.C0026g;
import p000a.p010i.p011b.p012a.p015c.p045l.C25227au;
import p000a.p010i.p011b.p012a.p015c.p778f.C37022f;

/* renamed from: a.i.b.a.c.b.c.y */
public abstract class C31641y extends C17168k implements C17153ag {
    static final /* synthetic */ boolean $assertionsDisabled = (!C31641y.class.desiredAssertionStatus());
    public final C31220ah BhL;
    public C25082az BhQ;
    public final boolean BhT;
    public final boolean Bhu;
    public final C44879w Bhv;
    private final C8063a Bif;
    public C8083t Big = null;
    public boolean isDefault;

    /* renamed from: eaG */
    public abstract C17153ag ean();

    public C31641y(C44879w c44879w, C25082az c25082az, C31220ah c31220ah, C0026g c0026g, C37022f c37022f, boolean z, boolean z2, boolean z3, C8063a c8063a, C41398am c41398am) {
        super(c31220ah.dXW(), c0026g, c37022f, c41398am);
        this.Bhv = c44879w;
        this.BhQ = c25082az;
        this.BhL = c31220ah;
        this.isDefault = z;
        this.Bhu = z2;
        this.BhT = z3;
        this.Bif = c8063a;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final C8063a dYZ() {
        return this.Bif;
    }

    public final boolean dZs() {
        return false;
    }

    public final boolean dZt() {
        return false;
    }

    public final boolean dYm() {
        return this.Bhu;
    }

    public final boolean dYj() {
        return this.BhT;
    }

    public final boolean dYx() {
        return false;
    }

    public final boolean dZv() {
        return false;
    }

    public final boolean dYk() {
        return false;
    }

    public final boolean dYl() {
        return false;
    }

    /* renamed from: c */
    public final C8083t mo17865c(C25227au c25227au) {
        throw new UnsupportedOperationException();
    }

    public final List<C36955ar> dYS() {
        return Collections.emptyList();
    }

    public final boolean dYW() {
        return false;
    }

    public final C44879w dYd() {
        return this.Bhv;
    }

    public final C25082az dYf() {
        return this.BhQ;
    }

    public final C31220ah dZH() {
        return this.BhL;
    }

    public final C8084a<? extends C8083t> dZw() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: rJ */
    public final Collection<C17153ag> mo51634rJ(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (C31220ah c31220ah : this.BhL.dYX()) {
            Object dZI = z ? c31220ah.dZI() : c31220ah.dZJ();
            if (dZI != null) {
                arrayList.add(dZI);
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    public final void mo41960k(Collection<? extends C25085b> collection) {
        if (!$assertionsDisabled && !collection.isEmpty()) {
            throw new AssertionError("Overridden accessors should be empty");
        }
    }

    public final C8083t dZq() {
        return this.Big;
    }

    public final boolean dZr() {
        return false;
    }

    public final boolean dZu() {
        return false;
    }

    /* renamed from: a */
    public final <V> V mo17833a(C8037a<V> c8037a) {
        return null;
    }

    public final C41396ak dYQ() {
        return this.BhL.dYQ();
    }

    public final C41396ak dYR() {
        return this.BhL.dYR();
    }

    /* renamed from: a */
    public final /* synthetic */ C25085b mo17863a(C31642l c31642l, C44879w c44879w, C25082az c25082az, C8063a c8063a) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    /* renamed from: f */
    public final /* synthetic */ C31643m mo17870f(C25227au c25227au) {
        throw new UnsupportedOperationException();
    }
}
