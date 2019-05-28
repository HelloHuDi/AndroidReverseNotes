package a.i.b.a.c.b.c;

import a.i.b.a.c.b.ak;
import a.i.b.a.c.b.e;
import a.i.b.a.c.b.l;
import a.i.b.a.c.b.n;
import a.i.b.a.c.f.f;
import a.i.b.a.c.i.e.h;
import a.i.b.a.c.k.i;
import a.i.b.a.c.l.ad;
import a.i.b.a.c.l.as;
import a.i.b.a.c.l.au;
import a.i.b.a.c.l.av;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a implements e {
    static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
    public final f BgZ;
    protected final a.i.b.a.c.k.f<ad> Bha;
    private final a.i.b.a.c.k.f<h> Bhb;
    private final a.i.b.a.c.k.f<ak> Bhc;

    public final /* bridge */ /* synthetic */ l dZd() {
        return this;
    }

    public final /* bridge */ /* synthetic */ a.i.b.a.c.b.h dZe() {
        return this;
    }

    public a(i iVar, f fVar) {
        this.BgZ = fVar;
        this.Bha = iVar.i(new a.f.a.a<ad>() {
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119380);
                ad a = av.a(a.this, a.this.dXZ());
                AppMethodBeat.o(119380);
                return a;
            }
        });
        this.Bhb = iVar.i(new a.f.a.a<h>() {
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119381);
                a.i.b.a.c.i.e.f fVar = new a.i.b.a.c.i.e.f(a.this.dXZ());
                AppMethodBeat.o(119381);
                return fVar;
            }
        });
        this.Bhc = iVar.i(new a.f.a.a<ak>() {
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(119382);
                q qVar = new q(a.this);
                AppMethodBeat.o(119382);
                return qVar;
            }
        });
    }

    public final f dZg() {
        return this.BgZ;
    }

    public final e dZm() {
        return this;
    }

    public h dZk() {
        return (h) this.Bhb.invoke();
    }

    public final ak dZl() {
        return (ak) this.Bhc.invoke();
    }

    public h a(as asVar) {
        if (asVar.isEmpty()) {
            return dXZ();
        }
        return new a.i.b.a.c.i.e.l(dXZ(), au.d(asVar));
    }

    public final ad dZf() {
        return (ad) this.Bha.invoke();
    }

    public final <R, D> R a(n<R, D> nVar, D d) {
        return nVar.a((e) this, (Object) d);
    }

    /* renamed from: g */
    public e f(au auVar) {
        return auVar.Bik.isEmpty() ? this : new s(this, auVar);
    }
}
