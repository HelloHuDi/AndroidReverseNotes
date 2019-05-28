package a.i.b.a;

import a.a.m;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i.b.a.c.b.ar;
import a.i.k;
import a.i.o;
import a.i.p;
import a.l;
import a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, dWq = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflect-api"})
public final class w implements p {
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(w.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    private final a.i.b.a.z.a AYq = z.a(null, new a(this));
    final ar AYr;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, dWq = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "invoke"})
    static final class a extends a.f.b.k implements a.f.a.a<List<? extends u>> {
        final /* synthetic */ w AYs;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "kotlin/reflect/jvm/internal/KTypeParameterImpl$upperBounds$2$1$1"})
        static final class a extends a.f.b.k implements a.f.a.a {
            final /* synthetic */ a AYt;

            a(a aVar) {
                this.AYt = aVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(118886);
                Throwable nVar = new n("An operation is not implemented: ".concat(String.valueOf("Java type is not yet supported for type parameters: " + this.AYt.AYs.AYr)));
                AppMethodBeat.o(118886);
                throw nVar;
            }
        }

        a(w wVar) {
            this.AYs = wVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118887);
            List dWP = this.AYs.AYr.dWP();
            j.o(dWP, "descriptor.upperBounds");
            Iterable<a.i.b.a.c.l.w> iterable = dWP;
            Collection arrayList = new ArrayList(m.d(iterable));
            for (a.i.b.a.c.l.w wVar : iterable) {
                j.o(wVar, "kotlinType");
                arrayList.add(new u(wVar, new a(this)));
            }
            List list = (List) arrayList;
            AppMethodBeat.o(118887);
            return list;
        }
    }

    static {
        AppMethodBeat.i(118888);
        AppMethodBeat.o(118888);
    }

    public w(ar arVar) {
        j.p(arVar, "descriptor");
        AppMethodBeat.i(118893);
        this.AYr = arVar;
        AppMethodBeat.o(118893);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(118890);
        if ((obj instanceof w) && j.j(this.AYr, ((w) obj).AYr)) {
            AppMethodBeat.o(118890);
            return true;
        }
        AppMethodBeat.o(118890);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(118892);
        ab abVar = ab.AYy;
        String a = ab.a(this.AYr);
        AppMethodBeat.o(118892);
        return a;
    }

    public final List<o> dWP() {
        AppMethodBeat.i(118889);
        List list = (List) this.AYq.invoke();
        AppMethodBeat.o(118889);
        return list;
    }

    public final int hashCode() {
        AppMethodBeat.i(118891);
        int hashCode = this.AYr.hashCode();
        AppMethodBeat.o(118891);
        return hashCode;
    }
}
