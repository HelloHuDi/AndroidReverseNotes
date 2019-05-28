package a.i.b;

import a.c;
import a.f.a.m;
import a.f.b.i;
import a.f.b.j;
import a.f.b.v;
import a.i.b.a.af;
import a.i.b.a.c.b.al;
import a.i.b.a.c.e.a.ag;
import a.i.b.a.c.e.a.o;
import a.i.b.a.c.e.b.a.g;
import a.i.b.a.c.e.b.a.h;
import a.i.b.a.c.j.a.q;
import a.i.d;
import a.i.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0004"}, dWq = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflect-api"})
public final class b {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, dWq = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;", "R", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function;", "Lkotlin/ParameterName;", "name", "proto", "invoke"})
    static final class a extends i implements m<q, o, al> {
        public static final a AWd = new a();

        static {
            AppMethodBeat.i(118658);
            AppMethodBeat.o(118658);
        }

        a() {
            super(2);
        }

        public final d dWF() {
            AppMethodBeat.i(118657);
            a.i.b aN = v.aN(q.class);
            AppMethodBeat.o(118657);
            return aN;
        }

        public final String due() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        public final String getName() {
            return "loadFunction";
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(118656);
            q qVar = (q) obj;
            o oVar = (o) obj2;
            j.p(qVar, "p1");
            j.p(oVar, "p2");
            al g = qVar.g(oVar);
            AppMethodBeat.o(118656);
            return g;
        }
    }

    public static final <R> e<R> a(c<? extends R> cVar) {
        AppMethodBeat.i(118659);
        j.p(cVar, "receiver$0");
        l lVar = (l) cVar.getClass().getAnnotation(l.class);
        if (lVar == null) {
            AppMethodBeat.o(118659);
            return null;
        }
        String[] dWp = lVar.dWp();
        if ((dWp.length == 0 ? 1 : null) != null) {
            dWp = null;
        }
        if (dWp == null) {
            AppMethodBeat.o(118659);
            return null;
        }
        a.o f = a.i.b.a.c.e.b.a.j.f(dWp, lVar.dWq());
        h hVar = (h) f.first;
        o oVar = (o) f.second;
        g gVar = new g(lVar.dWo(), (lVar.dWr() & 8) != 0);
        Class cls = cVar.getClass();
        a.i.b.a.c.g.q qVar = oVar;
        a.i.b.a.c.e.a.c cVar2 = hVar;
        ag agVar = oVar.BtC;
        j.o(agVar, "proto.typeTable");
        al alVar = (al) af.a(cls, qVar, cVar2, new a.i.b.a.c.e.a.h(agVar), gVar, a.AWd);
        if (alVar == null) {
            AppMethodBeat.o(118659);
            return null;
        }
        e<R> jVar = new a.i.b.a.j(a.i.b.a.a.AWe, alVar);
        AppMethodBeat.o(118659);
        return jVar;
    }
}
