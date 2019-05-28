package a.i.b.a.c.b.c;

import a.i.b.a.c.b.a.g;
import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.am;
import a.i.b.a.c.b.ar;
import a.i.b.a.c.b.az;
import a.i.b.a.c.b.b;
import a.i.b.a.c.b.b.a;
import a.i.b.a.c.b.d;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.i;
import a.i.b.a.c.b.k;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.m;
import a.i.b.a.c.b.n;
import a.i.b.a.c.b.o;
import a.i.b.a.c.b.t;
import a.i.b.a.c.b.w;
import a.i.b.a.c.l.au;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class f extends p implements d {
    static final /* synthetic */ boolean $assertionsDisabled = (!f.class.desiredAssertionStatus());
    private static final a.i.b.a.c.f.f Bhs = a.i.b.a.c.f.f.avZ("<init>");
    protected final boolean hEK;

    static {
        AppMethodBeat.i(119421);
        AppMethodBeat.o(119421);
    }

    public final /* bridge */ /* synthetic */ b a(l lVar, w wVar, az azVar, a aVar) {
        AppMethodBeat.i(119413);
        d a = a(lVar, wVar, azVar, aVar, false);
        AppMethodBeat.o(119413);
        return a;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ p a(l lVar, t tVar, a aVar, a.i.b.a.c.f.f fVar, g gVar, am amVar) {
        AppMethodBeat.i(119408);
        f b = b(lVar, tVar, aVar, fVar, gVar, amVar);
        AppMethodBeat.o(119408);
        return b;
    }

    public final /* synthetic */ k b(au auVar) {
        AppMethodBeat.i(119419);
        d a = a(auVar);
        AppMethodBeat.o(119419);
        return a;
    }

    public final /* synthetic */ t b(l lVar, w wVar, az azVar, a aVar, boolean z) {
        AppMethodBeat.i(119409);
        d a = a(lVar, wVar, azVar, aVar, z);
        AppMethodBeat.o(119409);
        return a;
    }

    public final /* synthetic */ t c(au auVar) {
        AppMethodBeat.i(119410);
        d a = a(auVar);
        AppMethodBeat.o(119410);
        return a;
    }

    public final /* synthetic */ m f(au auVar) {
        AppMethodBeat.i(119418);
        d a = a(auVar);
        AppMethodBeat.o(119418);
        return a;
    }

    protected f(e eVar, k kVar, g gVar, boolean z, a aVar, am amVar) {
        super(eVar, kVar, gVar, Bhs, aVar, amVar);
        this.hEK = z;
    }

    public static f a(e eVar, g gVar, am amVar) {
        AppMethodBeat.i(119397);
        f fVar = new f(eVar, null, gVar, true, a.DECLARATION, amVar);
        AppMethodBeat.o(119397);
        return fVar;
    }

    public final e eas() {
        AppMethodBeat.i(139058);
        e eVar = (e) super.dXW();
        AppMethodBeat.o(139058);
        return eVar;
    }

    public final d dZj() {
        AppMethodBeat.i(119401);
        d dVar = (d) super.ean();
        AppMethodBeat.o(119401);
        return dVar;
    }

    public final d a(au auVar) {
        AppMethodBeat.i(119402);
        d dVar = (d) super.f(auVar);
        AppMethodBeat.o(119402);
        return dVar;
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        AppMethodBeat.i(119403);
        Object a = nVar.a((k) this, (Object) d);
        AppMethodBeat.o(119403);
        return a;
    }

    public final Collection<? extends t> dYX() {
        AppMethodBeat.i(119404);
        Set emptySet = Collections.emptySet();
        AppMethodBeat.o(119404);
        return emptySet;
    }

    public final void k(Collection<? extends b> collection) {
        AppMethodBeat.i(119405);
        if ($assertionsDisabled || collection.isEmpty()) {
            AppMethodBeat.o(119405);
            return;
        }
        AssertionError assertionError = new AssertionError("Constructors cannot override anything");
        AppMethodBeat.o(119405);
        throw assertionError;
    }

    /* Access modifiers changed, original: protected */
    public f b(l lVar, t tVar, a aVar, a.i.b.a.c.f.f fVar, g gVar, am amVar) {
        AppMethodBeat.i(119406);
        if (aVar != a.DECLARATION && aVar != a.SYNTHESIZED) {
            IllegalStateException illegalStateException = new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + lVar + "\nkind: " + aVar);
            AppMethodBeat.o(119406);
            throw illegalStateException;
        } else if ($assertionsDisabled || fVar == null) {
            f fVar2 = new f((e) lVar, this, gVar, this.hEK, a.DECLARATION, amVar);
            AppMethodBeat.o(119406);
            return fVar2;
        } else {
            AssertionError assertionError = new AssertionError("Attempt to rename constructor: ".concat(String.valueOf(this)));
            AppMethodBeat.o(119406);
            throw assertionError;
        }
    }

    public final d a(l lVar, w wVar, az azVar, a aVar, boolean z) {
        AppMethodBeat.i(119407);
        d dVar = (d) super.b(lVar, wVar, azVar, aVar, z);
        AppMethodBeat.o(119407);
        return dVar;
    }

    public final f a(List<a.i.b.a.c.b.au> list, az azVar, List<ar> list2) {
        ak dZl;
        AppMethodBeat.i(119398);
        e eVar = (e) super.dXW();
        if (eVar.dYh()) {
            l dXW = eVar.dXW();
            if (dXW instanceof e) {
                dZl = ((e) dXW).dZl();
                super.a(null, dZl, list2, list, null, w.FINAL, azVar);
                AppMethodBeat.o(119398);
                return this;
            }
        }
        dZl = null;
        super.a(null, dZl, list2, list, null, w.FINAL, azVar);
        AppMethodBeat.o(119398);
        return this;
    }

    public final f a(List<a.i.b.a.c.b.au> list, az azVar) {
        AppMethodBeat.i(119399);
        a((List) list, azVar, ((e) super.dXW()).dYq());
        AppMethodBeat.o(119399);
        return this;
    }

    public final /* bridge */ /* synthetic */ t dZp() {
        AppMethodBeat.i(119411);
        d dVar = (d) super.ean();
        AppMethodBeat.o(119411);
        return dVar;
    }

    public final /* bridge */ /* synthetic */ l dXW() {
        AppMethodBeat.i(119412);
        e eVar = (e) super.dXW();
        AppMethodBeat.o(119412);
        return eVar;
    }

    public final /* synthetic */ b dYY() {
        AppMethodBeat.i(119414);
        d dVar = (d) super.ean();
        AppMethodBeat.o(119414);
        return dVar;
    }

    public final /* synthetic */ a.i.b.a.c.b.a dYU() {
        AppMethodBeat.i(119415);
        d dVar = (d) super.ean();
        AppMethodBeat.o(119415);
        return dVar;
    }

    public final /* synthetic */ l dZd() {
        AppMethodBeat.i(119416);
        d dVar = (d) super.ean();
        AppMethodBeat.o(119416);
        return dVar;
    }

    public final /* synthetic */ o ean() {
        AppMethodBeat.i(119417);
        d dVar = (d) super.ean();
        AppMethodBeat.o(119417);
        return dVar;
    }

    public final /* synthetic */ i dZo() {
        AppMethodBeat.i(119420);
        e eVar = (e) super.dXW();
        AppMethodBeat.o(119420);
        return eVar;
    }
}
