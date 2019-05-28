package a.i.b.a;

import a.aa;
import a.f.b.j;
import a.f.b.k;
import a.i.b.a.a.e;
import a.i.b.a.a.e.d;
import a.i.b.a.a.e.f;
import a.i.b.a.a.h;
import a.i.b.a.a.i;
import a.i.b.a.c.b.ah;
import a.i.b.a.c.l.av;
import a.l;
import a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0006H\u0002¨\u0006\u0007"}, dWq = {"computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflect-api"})
public final class t {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"isJvmStaticProperty", "", "invoke"})
    static final class a extends k implements a.f.a.a<Boolean> {
        final /* synthetic */ a.i.b.a.s.a AYe;

        a(a.i.b.a.s.a aVar) {
            this.AYe = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118864);
            Boolean valueOf = Boolean.valueOf(gF());
            AppMethodBeat.o(118864);
            return valueOf;
        }

        public final boolean gF() {
            AppMethodBeat.i(118865);
            boolean j = this.AYe.dXg().dWT().dYn().j(af.dXv());
            AppMethodBeat.o(118865);
            return j;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"isNotNullProperty", "", "invoke"})
    static final class b extends k implements a.f.a.a<Boolean> {
        final /* synthetic */ a.i.b.a.s.a AYe;

        b(a.i.b.a.s.a aVar) {
            this.AYe = aVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118866);
            Boolean valueOf = Boolean.valueOf(gF());
            AppMethodBeat.o(118866);
            return valueOf;
        }

        public final boolean gF() {
            AppMethodBeat.i(118867);
            if (av.aB(this.AYe.dXg().dWT().dZS())) {
                AppMethodBeat.o(118867);
                return false;
            }
            AppMethodBeat.o(118867);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, dWq = {"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"})
    static final class c extends k implements a.f.a.b<Field, e<? extends Field>> {
        final /* synthetic */ a.i.b.a.s.a AYe;
        final /* synthetic */ boolean AYf;
        final /* synthetic */ b AYg;
        final /* synthetic */ a AYh;

        c(a.i.b.a.s.a aVar, boolean z, b bVar, a aVar2) {
            this.AYe = aVar;
            this.AYf = z;
            this.AYg = bVar;
            this.AYh = aVar2;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(118868);
            e c = c((Field) obj);
            AppMethodBeat.o(118868);
            return c;
        }

        public final e<Field> c(Field field) {
            AppMethodBeat.i(118869);
            j.p(field, "field");
            d aVar;
            e.e aVar2;
            e<Field> eVar;
            if (t.a(this.AYe.dXg().dWT()) || !Modifier.isStatic(field.getModifiers())) {
                if (this.AYf) {
                    if (this.AYe.dXg().isBound()) {
                        aVar = new a.i.b.a.a.e.d.a(field, this.AYe.dXg().AXt);
                    } else {
                        aVar = new a.i.b.a.a.e.d.c(field);
                    }
                    e eVar2 = aVar;
                    AppMethodBeat.o(118869);
                    return eVar2;
                }
                if (this.AYe.dXg().isBound()) {
                    aVar2 = new a.i.b.a.a.e.e.a(field, this.AYg.gF(), this.AYe.dXg().AXt);
                } else {
                    aVar2 = new a.i.b.a.a.e.e.c(field, this.AYg.gF());
                }
                eVar = aVar2;
                AppMethodBeat.o(118869);
                return eVar;
            } else if (this.AYh.gF()) {
                if (this.AYf) {
                    if (this.AYe.dXg().isBound()) {
                        aVar = new a.i.b.a.a.e.d.b(field);
                    } else {
                        aVar = new d.d(field);
                    }
                    eVar = aVar;
                    AppMethodBeat.o(118869);
                    return eVar;
                }
                if (this.AYe.dXg().isBound()) {
                    aVar2 = new a.i.b.a.a.e.e.b(field, this.AYg.gF());
                } else {
                    aVar2 = new e.e.d(field, this.AYg.gF());
                }
                eVar = aVar2;
                AppMethodBeat.o(118869);
                return eVar;
            } else if (this.AYf) {
                eVar = new d.e(field);
                AppMethodBeat.o(118869);
                return eVar;
            } else {
                eVar = new e.e.e(field, this.AYg.gF());
                AppMethodBeat.o(118869);
                return eVar;
            }
        }
    }

    static final a.i.b.a.a.d<?> a(a.i.b.a.s.a<?, ?> aVar, boolean z) {
        AppMethodBeat.i(118870);
        a.i.b.a.i.a aVar2 = i.AXg;
        if (i.AXf.aq(aVar.dXg().signature)) {
            a.i.b.a.a.d dVar = i.AZo;
            AppMethodBeat.o(118870);
            return dVar;
        }
        e c;
        a.i.b.a.a.d<?> aVar3;
        a aVar4 = new a(aVar);
        c cVar = new c(aVar, z, new b(aVar), aVar4);
        ad adVar = ad.AYC;
        d c2 = ad.c(aVar.dXg().dWT());
        Method H;
        Throwable xVar;
        f aVar5;
        if (c2 instanceof a.i.b.a.d.c) {
            a.i.b.a.c.e.b.b.c cVar2;
            a.i.b.a.c.e.b.b.e eVar = ((a.i.b.a.d.c) c2).AWp;
            if (z) {
                if (eVar.egY()) {
                    cVar2 = eVar.BxS;
                } else {
                    cVar2 = null;
                }
            } else if (eVar.egZ()) {
                cVar2 = eVar.BxT;
            } else {
                cVar2 = null;
            }
            if (cVar2 != null) {
                H = aVar.dXg().AXs.H(((a.i.b.a.d.c) c2).AWq.getString(cVar2.Buf), ((a.i.b.a.d.c) c2).AWq.getString(cVar2.BxN), af.c(aVar.dXq()));
            } else {
                H = null;
            }
            if (H == null) {
                Field dXn = aVar.dXg().dXn();
                if (dXn == null) {
                    xVar = new x("No accessors or field is found for property " + aVar.dXg());
                    AppMethodBeat.o(118870);
                    throw xVar;
                }
                c = cVar.c(dXn);
            } else if (!Modifier.isStatic(H.getModifiers())) {
                if (aVar.dXg().isBound()) {
                    aVar5 = new a.i.b.a.a.e.f.a(H, aVar.dXg().AXt);
                } else {
                    aVar5 = new f.d(H);
                }
                c = aVar5;
            } else if (aVar4.gF()) {
                if (aVar.dXg().isBound()) {
                    aVar5 = new a.i.b.a.a.e.f.b(H);
                } else {
                    aVar5 = new f.e(H);
                }
                c = aVar5;
            } else {
                if (aVar.dXg().isBound()) {
                    aVar5 = new a.i.b.a.a.e.f.c(H, aVar.dXg().AXt);
                } else {
                    aVar5 = new f.f(H);
                }
                c = aVar5;
            }
        } else if (c2 instanceof a.i.b.a.d.a) {
            c = cVar.c(((a.i.b.a.d.a) c2).eum);
        } else if (c2 instanceof a.i.b.a.d.b) {
            if (z) {
                H = ((a.i.b.a.d.b) c2).AWl;
            } else {
                Method method = ((a.i.b.a.d.b) c2).AWm;
                if (method == null) {
                    xVar = new x("No source found for setter of Java method property: " + ((a.i.b.a.d.b) c2).AWl);
                    AppMethodBeat.o(118870);
                    throw xVar;
                }
                H = method;
            }
            if (aVar.dXg().isBound()) {
                aVar5 = new a.i.b.a.a.e.f.a(H, aVar.dXg().AXt);
            } else {
                aVar5 = new f.d(H);
            }
            c = aVar5;
        } else if (c2 instanceof d.d) {
            c.e eVar2;
            if (z) {
                eVar2 = ((d.d) c2).AWs;
            } else {
                eVar2 = ((d.d) c2).AWt;
                if (eVar2 == null) {
                    xVar = new x("No setter found for property " + aVar.dXg());
                    AppMethodBeat.o(118870);
                    throw xVar;
                }
            }
            H = aVar.dXg().AXs.H(eVar2.AWk.name, eVar2.AWk.desc, af.c(aVar.dXq()));
            if (H == null) {
                xVar = new x("No accessor found for property " + aVar.dXg());
                AppMethodBeat.o(118870);
                throw xVar;
            }
            Object obj = !Modifier.isStatic(H.getModifiers()) ? 1 : null;
            if (aa.AUz && obj == null) {
                xVar = new AssertionError("Mapped property cannot have a static accessor: " + aVar.dXg());
                AppMethodBeat.o(118870);
                throw xVar;
            } else if (aVar.dXg().isBound()) {
                aVar3 = new a.i.b.a.a.e.f.a(H, aVar.dXg().AXt);
                AppMethodBeat.o(118870);
                return aVar3;
            } else {
                aVar3 = new f.d(H);
                AppMethodBeat.o(118870);
                return aVar3;
            }
        } else {
            m mVar = new m();
            AppMethodBeat.o(118870);
            throw mVar;
        }
        aVar3 = h.a(c, aVar.dXq());
        AppMethodBeat.o(118870);
        return aVar3;
    }

    public static final /* synthetic */ boolean a(ah ahVar) {
        AppMethodBeat.i(118871);
        a.i.b.a.c.b.l dXW = ahVar.dXW();
        j.o(dXW, "containingDeclaration");
        if (a.i.b.a.c.i.d.u(dXW)) {
            dXW = dXW.dXW();
            if ((a.i.b.a.c.i.d.A(dXW) || a.i.b.a.c.i.d.z(dXW)) && !((ahVar instanceof a.i.b.a.c.j.a.a.i) && a.i.b.a.c.e.b.a.j.f(((a.i.b.a.c.j.a.a.i) ahVar).AWo))) {
                AppMethodBeat.o(118871);
                return false;
            }
            AppMethodBeat.o(118871);
            return true;
        }
        AppMethodBeat.o(118871);
        return false;
    }
}
