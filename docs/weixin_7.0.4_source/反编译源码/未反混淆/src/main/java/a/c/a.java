package a.c;

import a.c.e.b;
import a.c.e.c;
import a.f.a.m;
import a.f.b.j;
import a.l;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"})
public abstract class a implements b {
    private final c<?> key;

    public a(c<?> cVar) {
        j.p(cVar, "key");
        this.key = cVar;
    }

    public <R> R fold(R r, m<? super R, ? super b, ? extends R> mVar) {
        j.p(mVar, "operation");
        return a.c.e.b.a.a(this, r, mVar);
    }

    public <E extends b> E get(c<E> cVar) {
        j.p(cVar, "key");
        return a.c.e.b.a.a((b) this, (c) cVar);
    }

    public c<?> getKey() {
        return this.key;
    }

    public e minusKey(c<?> cVar) {
        j.p(cVar, "key");
        return a.c.e.b.a.b(this, cVar);
    }

    public e plus(e eVar) {
        j.p(eVar, "context");
        return a.c.e.b.a.a((b) this, eVar);
    }
}
