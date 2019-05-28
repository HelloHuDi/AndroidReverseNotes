package kotlinx.coroutines.a;

import a.c.e;
import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.bq;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"})
public final class o {
    private static final m BRI = new m("ZERO");
    private static final m<Object, a.c.e.b, Object> BRJ = a.BRN;
    private static final m<bq<?>, a.c.e.b, bq<?>> BRK = b.BRO;
    private static final m<s, a.c.e.b, s> BRL = d.BRQ;
    private static final m<s, a.c.e.b, s> BRM = c.BRP;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class d extends k implements m<s, a.c.e.b, s> {
        public static final d BRQ = new d();

        static {
            AppMethodBeat.i(118430);
            AppMethodBeat.o(118430);
        }

        d() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(118429);
            s sVar = (s) obj;
            a.c.e.b bVar = (a.c.e.b) obj2;
            j.p(sVar, "state");
            j.p(bVar, "element");
            if (bVar instanceof bq) {
                Object c = ((bq) bVar).c(sVar.BPx);
                Object[] objArr = sVar.a;
                int i = sVar.i;
                sVar.i = i + 1;
                objArr[i] = c;
            }
            AppMethodBeat.o(118429);
            return sVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "", "countOrElement", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class a extends k implements m<Object, a.c.e.b, Object> {
        public static final a BRN = new a();

        static {
            AppMethodBeat.i(118432);
            AppMethodBeat.o(118432);
        }

        a() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(118431);
            a.c.e.b bVar = (a.c.e.b) obj2;
            j.p(bVar, "element");
            if (bVar instanceof bq) {
                Object obj3;
                if (obj instanceof Integer) {
                    obj3 = obj;
                } else {
                    obj3 = null;
                }
                Integer num = (Integer) obj3;
                int intValue = num != null ? num.intValue() : 1;
                if (intValue == 0) {
                    AppMethodBeat.o(118431);
                    return bVar;
                }
                obj2 = Integer.valueOf(intValue + 1);
                AppMethodBeat.o(118431);
                return obj2;
            }
            AppMethodBeat.o(118431);
            return obj;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "Lkotlinx/coroutines/ThreadContextElement;", "found", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class b extends k implements m<bq<?>, a.c.e.b, bq<?>> {
        public static final b BRO = new b();

        static {
            AppMethodBeat.i(118426);
            AppMethodBeat.o(118426);
        }

        b() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(118425);
            bq bqVar = (bq) obj;
            a.c.e.b bVar = (a.c.e.b) obj2;
            j.p(bVar, "element");
            if (bqVar != null) {
                AppMethodBeat.o(118425);
                return bqVar;
            }
            bq bqVar2 = (bq) (!(bVar instanceof bq) ? null : bVar);
            AppMethodBeat.o(118425);
            return bqVar2;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class c extends k implements m<s, a.c.e.b, s> {
        public static final c BRP = new c();

        static {
            AppMethodBeat.i(118399);
            AppMethodBeat.o(118399);
        }

        c() {
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(118398);
            s sVar = (s) obj;
            a.c.e.b bVar = (a.c.e.b) obj2;
            j.p(sVar, "state");
            j.p(bVar, "element");
            if (bVar instanceof bq) {
                bq bqVar = (bq) bVar;
                e eVar = sVar.BPx;
                Object[] objArr = sVar.a;
                int i = sVar.i;
                sVar.i = i + 1;
                bqVar.a(eVar, objArr[i]);
            }
            AppMethodBeat.o(118398);
            return sVar;
        }
    }

    static {
        AppMethodBeat.i(118395);
        AppMethodBeat.o(118395);
    }

    public static final Object d(e eVar) {
        AppMethodBeat.i(118392);
        j.p(eVar, "context");
        Object fold = eVar.fold(Integer.valueOf(0), BRJ);
        if (fold == null) {
            j.dWJ();
        }
        AppMethodBeat.o(118392);
        return fold;
    }

    public static final Object b(e eVar, Object obj) {
        Integer d;
        AppMethodBeat.i(118393);
        j.p(eVar, "context");
        if (obj == null) {
            d = d(eVar);
        } else {
            d = obj;
        }
        Object fold;
        if (d == Integer.valueOf(0)) {
            m mVar = BRI;
            AppMethodBeat.o(118393);
            return mVar;
        } else if (d instanceof Integer) {
            fold = eVar.fold(new s(eVar, d.intValue()), BRL);
            AppMethodBeat.o(118393);
            return fold;
        } else if (d == null) {
            v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            AppMethodBeat.o(118393);
            throw vVar;
        } else {
            fold = ((bq) d).c(eVar);
            AppMethodBeat.o(118393);
            return fold;
        }
    }

    public static final void a(e eVar, Object obj) {
        AppMethodBeat.i(118394);
        j.p(eVar, "context");
        if (obj == BRI) {
            AppMethodBeat.o(118394);
        } else if (obj instanceof s) {
            ((s) obj).i = 0;
            eVar.fold(obj, BRM);
            AppMethodBeat.o(118394);
        } else {
            Object fold = eVar.fold(null, BRK);
            if (fold == null) {
                v vVar = new v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                AppMethodBeat.o(118394);
                throw vVar;
            }
            ((bq) fold).a(eVar, obj);
            AppMethodBeat.o(118394);
        }
    }
}
