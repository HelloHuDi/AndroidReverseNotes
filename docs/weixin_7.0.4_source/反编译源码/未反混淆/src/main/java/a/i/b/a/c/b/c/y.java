package a.i.b.a.c.b.c;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ag;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.b.a;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.m;
import a.i.b.a.c.b.t;
import a.i.b.a.c.b.w;
import a.i.b.a.c.f.f;
import a.i.b.a.c.l.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class y extends k implements ag {
    static final /* synthetic */ boolean $assertionsDisabled = (!y.class.desiredAssertionStatus());
    public final ah BhL;
    public az BhQ;
    public final boolean BhT;
    public final boolean Bhu;
    public final w Bhv;
    private final a Bif;
    public t Big = null;
    public boolean isDefault;

    /* renamed from: eaG */
    public abstract ag ean();

    public y(w wVar, az azVar, ah ahVar, g gVar, f fVar, boolean z, boolean z2, boolean z3, a aVar, am amVar) {
        super(ahVar.dXW(), gVar, fVar, amVar);
        this.Bhv = wVar;
        this.BhQ = azVar;
        this.BhL = ahVar;
        this.isDefault = z;
        this.Bhu = z2;
        this.BhT = z3;
        this.Bif = aVar;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final a dYZ() {
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

    public final t c(au auVar) {
        throw new UnsupportedOperationException();
    }

    public final List<ar> dYS() {
        return Collections.emptyList();
    }

    public final boolean dYW() {
        return false;
    }

    public final w dYd() {
        return this.Bhv;
    }

    public final az dYf() {
        return this.BhQ;
    }

    public final ah dZH() {
        return this.BhL;
    }

    public final t.a<? extends t> dZw() {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    /* Access modifiers changed, original: protected|final */
    public final Collection<ag> rJ(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (ah ahVar : this.BhL.dYX()) {
            Object dZI = z ? ahVar.dZI() : ahVar.dZJ();
            if (dZI != null) {
                arrayList.add(dZI);
            }
        }
        return arrayList;
    }

    public final void k(Collection<? extends b> collection) {
        if (!$assertionsDisabled && !collection.isEmpty()) {
            throw new AssertionError("Overridden accessors should be empty");
        }
    }

    public final t dZq() {
        return this.Big;
    }

    public final boolean dZr() {
        return false;
    }

    public final boolean dZu() {
        return false;
    }

    public final <V> V a(a.i.b.a.c.b.a.a<V> aVar) {
        return null;
    }

    public final ak dYQ() {
        return this.BhL.dYQ();
    }

    public final ak dYR() {
        return this.BhL.dYR();
    }

    public final /* synthetic */ b a(l lVar, w wVar, az azVar, a aVar) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    public final /* synthetic */ m f(au auVar) {
        throw new UnsupportedOperationException();
    }
}
