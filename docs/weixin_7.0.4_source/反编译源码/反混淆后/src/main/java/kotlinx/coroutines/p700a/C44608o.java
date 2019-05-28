package kotlinx.coroutines.p700a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.C16462bq;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p002c.C41366e;
import p000a.p002c.C41366e.C41367b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000\" \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, dWq = {"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.a.o */
public final class C44608o {
    private static final C46845m BRI = new C46845m("ZERO");
    private static final C31591m<Object, C41367b, Object> BRJ = C36908a.BRN;
    private static final C31591m<C16462bq<?>, C41367b, C16462bq<?>> BRK = C36909b.BRO;
    private static final C31591m<C24582s, C41367b, C24582s> BRL = C31538d.BRQ;
    private static final C31591m<C24582s, C41367b, C24582s> BRM = C41152c.BRP;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    /* renamed from: kotlinx.coroutines.a.o$d */
    static final class C31538d extends C25053k implements C31591m<C24582s, C41367b, C24582s> {
        public static final C31538d BRQ = new C31538d();

        static {
            AppMethodBeat.m2504i(118430);
            AppMethodBeat.m2505o(118430);
        }

        C31538d() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(118429);
            C24582s c24582s = (C24582s) obj;
            C41367b c41367b = (C41367b) obj2;
            C25052j.m39376p(c24582s, "state");
            C25052j.m39376p(c41367b, "element");
            if (c41367b instanceof C16462bq) {
                Object c = ((C16462bq) c41367b).mo13487c(c24582s.BPx);
                Object[] objArr = c24582s.f4900a;
                int i = c24582s.f4901i;
                c24582s.f4901i = i + 1;
                objArr[i] = c;
            }
            AppMethodBeat.m2505o(118429);
            return c24582s;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "", "countOrElement", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    /* renamed from: kotlinx.coroutines.a.o$a */
    static final class C36908a extends C25053k implements C31591m<Object, C41367b, Object> {
        public static final C36908a BRN = new C36908a();

        static {
            AppMethodBeat.m2504i(118432);
            AppMethodBeat.m2505o(118432);
        }

        C36908a() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(118431);
            C41367b c41367b = (C41367b) obj2;
            C25052j.m39376p(c41367b, "element");
            if (c41367b instanceof C16462bq) {
                Object obj3;
                if (obj instanceof Integer) {
                    obj3 = obj;
                } else {
                    obj3 = null;
                }
                Integer num = (Integer) obj3;
                int intValue = num != null ? num.intValue() : 1;
                if (intValue == 0) {
                    AppMethodBeat.m2505o(118431);
                    return c41367b;
                }
                obj2 = Integer.valueOf(intValue + 1);
                AppMethodBeat.m2505o(118431);
                return obj2;
            }
            AppMethodBeat.m2505o(118431);
            return obj;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "Lkotlinx/coroutines/ThreadContextElement;", "found", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    /* renamed from: kotlinx.coroutines.a.o$b */
    static final class C36909b extends C25053k implements C31591m<C16462bq<?>, C41367b, C16462bq<?>> {
        public static final C36909b BRO = new C36909b();

        static {
            AppMethodBeat.m2504i(118426);
            AppMethodBeat.m2505o(118426);
        }

        C36909b() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(118425);
            C16462bq c16462bq = (C16462bq) obj;
            C41367b c41367b = (C41367b) obj2;
            C25052j.m39376p(c41367b, "element");
            if (c16462bq != null) {
                AppMethodBeat.m2505o(118425);
                return c16462bq;
            }
            C16462bq c16462bq2 = (C16462bq) (!(c41367b instanceof C16462bq) ? null : c41367b);
            AppMethodBeat.m2505o(118425);
            return c16462bq2;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<no name provided>", "Lkotlinx/coroutines/internal/ThreadState;", "state", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    /* renamed from: kotlinx.coroutines.a.o$c */
    static final class C41152c extends C25053k implements C31591m<C24582s, C41367b, C24582s> {
        public static final C41152c BRP = new C41152c();

        static {
            AppMethodBeat.m2504i(118399);
            AppMethodBeat.m2505o(118399);
        }

        C41152c() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(118398);
            C24582s c24582s = (C24582s) obj;
            C41367b c41367b = (C41367b) obj2;
            C25052j.m39376p(c24582s, "state");
            C25052j.m39376p(c41367b, "element");
            if (c41367b instanceof C16462bq) {
                C16462bq c16462bq = (C16462bq) c41367b;
                C41366e c41366e = c24582s.BPx;
                Object[] objArr = c24582s.f4900a;
                int i = c24582s.f4901i;
                c24582s.f4901i = i + 1;
                c16462bq.mo13486a(c41366e, objArr[i]);
            }
            AppMethodBeat.m2505o(118398);
            return c24582s;
        }
    }

    static {
        AppMethodBeat.m2504i(118395);
        AppMethodBeat.m2505o(118395);
    }

    /* renamed from: d */
    public static final Object m81029d(C41366e c41366e) {
        AppMethodBeat.m2504i(118392);
        C25052j.m39376p(c41366e, "context");
        Object fold = c41366e.fold(Integer.valueOf(0), BRJ);
        if (fold == null) {
            C25052j.dWJ();
        }
        AppMethodBeat.m2505o(118392);
        return fold;
    }

    /* renamed from: b */
    public static final Object m81028b(C41366e c41366e, Object obj) {
        Integer d;
        AppMethodBeat.m2504i(118393);
        C25052j.m39376p(c41366e, "context");
        if (obj == null) {
            d = C44608o.m81029d(c41366e);
        } else {
            d = obj;
        }
        Object fold;
        if (d == Integer.valueOf(0)) {
            C46845m c46845m = BRI;
            AppMethodBeat.m2505o(118393);
            return c46845m;
        } else if (d instanceof Integer) {
            fold = c41366e.fold(new C24582s(c41366e, d.intValue()), BRL);
            AppMethodBeat.m2505o(118393);
            return fold;
        } else if (d == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            AppMethodBeat.m2505o(118393);
            throw c44941v;
        } else {
            fold = ((C16462bq) d).mo13487c(c41366e);
            AppMethodBeat.m2505o(118393);
            return fold;
        }
    }

    /* renamed from: a */
    public static final void m81027a(C41366e c41366e, Object obj) {
        AppMethodBeat.m2504i(118394);
        C25052j.m39376p(c41366e, "context");
        if (obj == BRI) {
            AppMethodBeat.m2505o(118394);
        } else if (obj instanceof C24582s) {
            ((C24582s) obj).f4901i = 0;
            c41366e.fold(obj, BRM);
            AppMethodBeat.m2505o(118394);
        } else {
            Object fold = c41366e.fold(null, BRK);
            if (fold == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                AppMethodBeat.m2505o(118394);
                throw c44941v;
            }
            ((C16462bq) fold).mo13486a(c41366e, obj);
            AppMethodBeat.m2505o(118394);
        }
    }
}
