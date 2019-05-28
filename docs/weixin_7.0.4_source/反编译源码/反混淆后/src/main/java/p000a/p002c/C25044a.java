package p000a.p002c;

import p000a.C0220l;
import p000a.p002c.C41366e.C36928c;
import p000a.p002c.C41366e.C41367b;
import p000a.p002c.C41366e.C41367b.C17124a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"})
/* renamed from: a.c.a */
public abstract class C25044a implements C41367b {
    private final C36928c<?> key;

    public C25044a(C36928c<?> c36928c) {
        C25052j.m39376p(c36928c, "key");
        this.key = c36928c;
    }

    public <R> R fold(R r, C31591m<? super R, ? super C41367b, ? extends R> c31591m) {
        C25052j.m39376p(c31591m, "operation");
        return C17124a.m26497a(this, r, c31591m);
    }

    public <E extends C41367b> E get(C36928c<E> c36928c) {
        C25052j.m39376p(c36928c, "key");
        return C17124a.m26495a((C41367b) this, (C36928c) c36928c);
    }

    public C36928c<?> getKey() {
        return this.key;
    }

    public C41366e minusKey(C36928c<?> c36928c) {
        C25052j.m39376p(c36928c, "key");
        return C17124a.m26498b(this, c36928c);
    }

    public C41366e plus(C41366e c41366e) {
        C25052j.m39376p(c41366e, "context");
        return C17124a.m26496a((C41367b) this, c41366e);
    }
}
