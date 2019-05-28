package a.i.b.a.c.b.c;

import a.f.b.j;
import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.au;
import a.i.b.a.c.b.aw;
import a.i.b.a.c.b.ay;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.m;
import a.i.b.a.c.b.n;
import a.i.b.a.c.b.o;
import a.i.b.a.c.i.b.f;
import a.i.b.a.c.l.w;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class ai extends aj implements au {
    public static final a BjA = new a();
    private final au Bjv;
    private final boolean Bjw;
    private final boolean Bjx;
    private final boolean Bjy;
    private final w Bjz;
    private final int index;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119634);
        AppMethodBeat.o(119634);
    }

    public final /* synthetic */ l dXW() {
        AppMethodBeat.i(119621);
        l dZT = dZT();
        AppMethodBeat.o(119621);
        return dZT;
    }

    public final /* synthetic */ a.i.b.a.c.b.a dYU() {
        AppMethodBeat.i(119626);
        a.i.b.a.c.b.a dZW = dZW();
        AppMethodBeat.o(119626);
        return dZW;
    }

    public final /* synthetic */ l dZd() {
        AppMethodBeat.i(119624);
        l dZW = dZW();
        AppMethodBeat.o(119624);
        return dZW;
    }

    public final /* synthetic */ aw eaI() {
        AppMethodBeat.i(119627);
        aw dZW = dZW();
        AppMethodBeat.o(119627);
        return dZW;
    }

    public final /* bridge */ /* synthetic */ f eaa() {
        return null;
    }

    public final boolean eac() {
        return false;
    }

    public final /* synthetic */ o ean() {
        AppMethodBeat.i(119625);
        o dZW = dZW();
        AppMethodBeat.o(119625);
        return dZW;
    }

    public final /* synthetic */ m f(a.i.b.a.c.l.au auVar) {
        AppMethodBeat.i(119628);
        j.p(auVar, "substitutor");
        if (auVar.Bik.isEmpty()) {
            m mVar = this;
            AppMethodBeat.o(119628);
            return mVar;
        }
        Throwable unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(119628);
        throw unsupportedOperationException;
    }

    public final int getIndex() {
        return this.index;
    }

    public final boolean dZX() {
        return this.Bjx;
    }

    public final boolean dZY() {
        return this.Bjy;
    }

    public final w dZV() {
        return this.Bjz;
    }

    public ai(a.i.b.a.c.b.a aVar, au auVar, int i, g gVar, a.i.b.a.c.f.f fVar, w wVar, boolean z, boolean z2, boolean z3, w wVar2, am amVar) {
        j.p(aVar, "containingDeclaration");
        j.p(gVar, "annotations");
        j.p(fVar, "name");
        j.p(wVar, "outType");
        j.p(amVar, "source");
        super(aVar, gVar, fVar, wVar, amVar);
        AppMethodBeat.i(119633);
        this.index = i;
        this.Bjw = z;
        this.Bjx = z2;
        this.Bjy = z3;
        this.Bjz = wVar2;
        this.Bjv = auVar == null ? this : auVar;
        AppMethodBeat.o(119633);
    }

    public final a.i.b.a.c.b.a dZT() {
        AppMethodBeat.i(119620);
        l dXW = super.dXW();
        if (dXW == null) {
            v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
            AppMethodBeat.o(119620);
            throw vVar;
        }
        a.i.b.a.c.b.a aVar = (a.i.b.a.c.b.a) dXW;
        AppMethodBeat.o(119620);
        return aVar;
    }

    public final boolean dZU() {
        AppMethodBeat.i(119622);
        if (this.Bjw) {
            a.i.b.a.c.b.a dZT = dZT();
            if (dZT == null) {
                v vVar = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
                AppMethodBeat.o(119622);
                throw vVar;
            }
            a.i.b.a.c.b.b.a dYZ = ((b) dZT).dYZ();
            j.o(dYZ, "(containingDeclaration a…bleMemberDescriptor).kind");
            if (dYZ.dZa()) {
                AppMethodBeat.o(119622);
                return true;
            }
        }
        AppMethodBeat.o(119622);
        return false;
    }

    public final au dZW() {
        AppMethodBeat.i(119623);
        au auVar;
        if (this.Bjv == this) {
            auVar = this;
            AppMethodBeat.o(119623);
            return auVar;
        }
        auVar = this.Bjv.dZW();
        AppMethodBeat.o(119623);
        return auVar;
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        AppMethodBeat.i(119629);
        j.p(nVar, "visitor");
        Object a = nVar.a((au) this, (Object) d);
        AppMethodBeat.o(119629);
        return a;
    }

    public final boolean dZZ() {
        return false;
    }

    public final au a(a.i.b.a.c.b.a aVar, a.i.b.a.c.f.f fVar, int i) {
        AppMethodBeat.i(119630);
        j.p(aVar, "newOwner");
        j.p(fVar, "newName");
        g dYn = dYn();
        j.o(dYn, "annotations");
        w dZS = dZS();
        j.o(dZS, "type");
        boolean dZU = dZU();
        boolean z = this.Bjx;
        boolean z2 = this.Bjy;
        w wVar = this.Bjz;
        am amVar = am.BeR;
        j.o(amVar, "SourceElement.NO_SOURCE");
        au aiVar = new ai(aVar, null, i, dYn, fVar, dZS, dZU, z, z2, wVar, amVar);
        AppMethodBeat.o(119630);
        return aiVar;
    }

    public final az dYf() {
        AppMethodBeat.i(119631);
        az azVar = ay.Bfb;
        j.o(azVar, "Visibilities.LOCAL");
        AppMethodBeat.o(119631);
        return azVar;
    }

    public final Collection<au> dYX() {
        AppMethodBeat.i(119632);
        Collection dYX = dZT().dYX();
        j.o(dYX, "containingDeclaration.overriddenDescriptors");
        Iterable<a.i.b.a.c.b.a> iterable = dYX;
        Collection arrayList = new ArrayList(a.a.m.d(iterable));
        for (a.i.b.a.c.b.a aVar : iterable) {
            j.o(aVar, "it");
            arrayList.add((au) aVar.dYV().get(this.index));
        }
        arrayList = (List) arrayList;
        AppMethodBeat.o(119632);
        return arrayList;
    }
}
