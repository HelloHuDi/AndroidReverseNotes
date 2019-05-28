package p000a.p002c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\u0011\u0012J5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH¦\u0002¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u00002\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH&J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0002¨\u0006\u0013"}, dWq = {"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"})
/* renamed from: a.c.e */
public interface C41366e {

    @C0220l(dWo = {1, 1, 13})
    /* renamed from: a.c.e$a */
    public static final class C17122a {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
        /* renamed from: a.c.e$a$a */
        static final class C17123a extends C25053k implements C31591m<C41366e, C41367b, C41366e> {
            public static final C17123a AVf = new C17123a();

            static {
                AppMethodBeat.m2504i(56379);
                AppMethodBeat.m2505o(56379);
            }

            C17123a() {
                super(2);
            }

            /* renamed from: m */
            public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
                C17117b c17117b;
                AppMethodBeat.m2504i(56378);
                C41366e c41366e = (C41366e) obj;
                C41367b c41367b = (C41367b) obj2;
                C25052j.m39376p(c41366e, "acc");
                C25052j.m39376p(c41367b, "element");
                C41366e minusKey = c41366e.minusKey(c41367b.getKey());
                if (minusKey == C44850f.AVg) {
                    c17117b = c41367b;
                } else {
                    C46863d c46863d = (C46863d) minusKey.get(C46863d.AVd);
                    if (c46863d == null) {
                        c17117b = new C17117b(minusKey, c41367b);
                    } else {
                        C41366e minusKey2 = minusKey.minusKey(C46863d.AVd);
                        if (minusKey2 == C44850f.AVg) {
                            c17117b = new C17117b(c41367b, c46863d);
                        } else {
                            c17117b = new C17117b(new C17117b(minusKey2, c41367b), c46863d);
                        }
                    }
                }
                C41366e c41366e2 = c17117b;
                AppMethodBeat.m2505o(56378);
                return c41366e2;
            }
        }

        /* renamed from: a */
        public static C41366e m26493a(C41366e c41366e, C41366e c41366e2) {
            AppMethodBeat.m2504i(56377);
            C25052j.m39376p(c41366e2, "context");
            if (c41366e2 == C44850f.AVg) {
                AppMethodBeat.m2505o(56377);
                return c41366e;
            }
            C41366e c41366e3 = (C41366e) c41366e2.fold(c41366e, C17123a.AVf);
            AppMethodBeat.m2505o(56377);
            return c41366e3;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, dWq = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"})
    /* renamed from: a.c.e$c */
    public interface C36928c<E extends C41367b> {
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J5\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00072\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0002¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016R\u0016\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, dWq = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"})
    /* renamed from: a.c.e$b */
    public interface C41367b extends C41366e {

        @C0220l(dWo = {1, 1, 13})
        /* renamed from: a.c.e$b$a */
        public static final class C17124a {
            /* renamed from: a */
            public static C41366e m26496a(C41367b c41367b, C41366e c41366e) {
                AppMethodBeat.m2504i(56376);
                C25052j.m39376p(c41366e, "context");
                C41366e a = C17122a.m26493a(c41367b, c41366e);
                AppMethodBeat.m2505o(56376);
                return a;
            }

            /* renamed from: a */
            public static <E extends C41367b> E m26495a(C41367b c41367b, C36928c<E> c36928c) {
                AppMethodBeat.m2504i(56373);
                C25052j.m39376p(c36928c, "key");
                if (C25052j.m39373j(c41367b.getKey(), c36928c)) {
                    AppMethodBeat.m2505o(56373);
                    return c41367b;
                }
                AppMethodBeat.m2505o(56373);
                return null;
            }

            /* renamed from: a */
            public static <R> R m26497a(C41367b c41367b, R r, C31591m<? super R, ? super C41367b, ? extends R> c31591m) {
                AppMethodBeat.m2504i(56374);
                C25052j.m39376p(c31591m, "operation");
                Object m = c31591m.mo212m(r, c41367b);
                AppMethodBeat.m2505o(56374);
                return m;
            }

            /* renamed from: b */
            public static C41366e m26498b(C41367b c41367b, C36928c<?> c36928c) {
                AppMethodBeat.m2504i(56375);
                C25052j.m39376p(c36928c, "key");
                if (C25052j.m39373j(c41367b.getKey(), c36928c)) {
                    C41366e c41366e = C44850f.AVg;
                    AppMethodBeat.m2505o(56375);
                    return c41366e;
                }
                C41366e c41366e2 = c41367b;
                AppMethodBeat.m2505o(56375);
                return c41366e2;
            }
        }

        <E extends C41367b> E get(C36928c<E> c36928c);

        C36928c<?> getKey();
    }

    <R> R fold(R r, C31591m<? super R, ? super C41367b, ? extends R> c31591m);

    <E extends C41367b> E get(C36928c<E> c36928c);

    C41366e minusKey(C36928c<?> c36928c);

    C41366e plus(C41366e c41366e);
}
