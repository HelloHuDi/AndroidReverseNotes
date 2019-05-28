package a.c;

import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0002¨\u0006\u0013"}, dWq = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"})
public interface e {

    @l(dWo = {1, 1, 13})
    public static final class a {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
        static final class a extends k implements m<e, b, e> {
            public static final a AVf = new a();

            static {
                AppMethodBeat.i(56379);
                AppMethodBeat.o(56379);
            }

            a() {
                super(2);
            }

            public final /* synthetic */ Object m(Object obj, Object obj2) {
                b bVar;
                AppMethodBeat.i(56378);
                e eVar = (e) obj;
                b bVar2 = (b) obj2;
                j.p(eVar, "acc");
                j.p(bVar2, "element");
                e minusKey = eVar.minusKey(bVar2.getKey());
                if (minusKey == f.AVg) {
                    bVar = bVar2;
                } else {
                    d dVar = (d) minusKey.get(d.AVd);
                    if (dVar == null) {
                        bVar = new b(minusKey, bVar2);
                    } else {
                        e minusKey2 = minusKey.minusKey(d.AVd);
                        if (minusKey2 == f.AVg) {
                            bVar = new b(bVar2, dVar);
                        } else {
                            bVar = new b(new b(minusKey2, bVar2), dVar);
                        }
                    }
                }
                e eVar2 = bVar;
                AppMethodBeat.o(56378);
                return eVar2;
            }
        }

        public static e a(e eVar, e eVar2) {
            AppMethodBeat.i(56377);
            j.p(eVar2, "context");
            if (eVar2 == f.AVg) {
                AppMethodBeat.o(56377);
                return eVar;
            }
            e eVar3 = (e) eVar2.fold(eVar, a.AVf);
            AppMethodBeat.o(56377);
            return eVar3;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, dWq = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"})
    public interface c<E extends b> {
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, dWq = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"})
    public interface b extends e {

        @l(dWo = {1, 1, 13})
        public static final class a {
            public static e a(b bVar, e eVar) {
                AppMethodBeat.i(56376);
                j.p(eVar, "context");
                e a = a.a(bVar, eVar);
                AppMethodBeat.o(56376);
                return a;
            }

            public static <E extends b> E a(b bVar, c<E> cVar) {
                AppMethodBeat.i(56373);
                j.p(cVar, "key");
                if (j.j(bVar.getKey(), cVar)) {
                    AppMethodBeat.o(56373);
                    return bVar;
                }
                AppMethodBeat.o(56373);
                return null;
            }

            public static <R> R a(b bVar, R r, m<? super R, ? super b, ? extends R> mVar) {
                AppMethodBeat.i(56374);
                j.p(mVar, "operation");
                Object m = mVar.m(r, bVar);
                AppMethodBeat.o(56374);
                return m;
            }

            public static e b(b bVar, c<?> cVar) {
                AppMethodBeat.i(56375);
                j.p(cVar, "key");
                if (j.j(bVar.getKey(), cVar)) {
                    e eVar = f.AVg;
                    AppMethodBeat.o(56375);
                    return eVar;
                }
                e eVar2 = bVar;
                AppMethodBeat.o(56375);
                return eVar2;
            }
        }

        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar);

    <E extends b> E get(c<E> cVar);

    e minusKey(c<?> cVar);

    e plus(e eVar);
}
