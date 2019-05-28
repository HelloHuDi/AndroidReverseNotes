package p000a.p050j;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import p000a.C0220l;
import p000a.p001a.C36913i;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\b\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000b\u001a=\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\b\u0010\f\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000bH\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0010\"\u0002H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00050\u000bH\u0002¢\u0006\u0002\b\u0016\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u0001H\u0007¢\u0006\u0002\b\u0018\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\b\u001a@\u0010\u001c\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001e0\u001d\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00150\u001d0\u0001¨\u0006\u001f"}, dWq = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, dWr = 1)
/* renamed from: a.j.l */
public class C16496l extends C8303k {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"})
    /* renamed from: a.j.l$a */
    public static final class C0212a extends C25053k implements C17126b<C44937h<? extends T>, Iterator<? extends T>> {
        public static final C0212a BOG = new C0212a();

        static {
            AppMethodBeat.m2504i(55974);
            AppMethodBeat.m2505o(55974);
        }

        C0212a() {
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(55973);
            C44937h c44937h = (C44937h) obj;
            C25052j.m39376p(c44937h, "it");
            Iterator it = c44937h.iterator();
            AppMethodBeat.m2505o(55973);
            return it;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0004\n\u0002\b\u0006\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "T", "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
    /* renamed from: a.j.l$b */
    public static final class C16497b extends C25053k implements C17126b<T, T> {
        public static final C16497b BOH = new C16497b();

        static {
            AppMethodBeat.m2504i(55965);
            AppMethodBeat.m2505o(55965);
        }

        C16497b() {
            super(1);
        }

        /* renamed from: am */
        public final T mo50am(T t) {
            return t;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, dWq = {"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
    /* renamed from: a.j.l$c */
    static final class C16498c extends C25053k implements C17126b<T, T> {
        final /* synthetic */ C31214a BOI;

        C16498c(C31214a c31214a) {
            this.BOI = c31214a;
            super(1);
        }

        /* renamed from: am */
        public final T mo50am(T t) {
            AppMethodBeat.m2504i(55929);
            C25052j.m39376p(t, "it");
            Object invoke = this.BOI.invoke();
            AppMethodBeat.m2505o(55929);
            return invoke;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, dWq = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
    /* renamed from: a.j.l$d */
    static final class C16499d extends C25053k implements C31214a<T> {
        final /* synthetic */ Object BOJ;

        C16499d(Object obj) {
            this.BOJ = obj;
            super(0);
        }

        public final T invoke() {
            return this.BOJ;
        }
    }

    /* renamed from: Z */
    public static final <T> C44937h<T> m25323Z(T... tArr) {
        Object obj;
        AppMethodBeat.m2504i(55979);
        C25052j.m39376p(tArr, MessengerShareContentUtility.ELEMENTS);
        if (tArr.length == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            C44937h c44937h = C31240d.BOt;
            AppMethodBeat.m2505o(55979);
            return c44937h;
        }
        C44937h<T> T = C36913i.m61687T(tArr);
        AppMethodBeat.m2505o(55979);
        return T;
    }

    /* renamed from: a */
    public static final <T> C44937h<T> m25324a(C44937h<? extends T> c44937h) {
        AppMethodBeat.m2504i(55980);
        C25052j.m39376p(c44937h, "receiver$0");
        C44937h c41464a = new C41464a(c44937h);
        AppMethodBeat.m2505o(55980);
        return c41464a;
    }

    /* renamed from: k */
    public static final <T> C44937h<T> m25326k(C31214a<? extends T> c31214a) {
        AppMethodBeat.m2504i(55981);
        C25052j.m39376p(c31214a, "nextFunction");
        C44937h a = C16496l.m25324a(new C37081g(c31214a, new C16498c(c31214a)));
        AppMethodBeat.m2505o(55981);
        return a;
    }

    /* renamed from: a */
    public static final <T> C44937h<T> m25325a(T t, C17126b<? super T, ? extends T> c17126b) {
        AppMethodBeat.m2504i(55982);
        C25052j.m39376p(c17126b, "nextFunction");
        if (t == null) {
            C44937h c44937h = C31240d.BOt;
            AppMethodBeat.m2505o(55982);
            return c44937h;
        }
        C44937h<T> c37081g = new C37081g(new C16499d(t), c17126b);
        AppMethodBeat.m2505o(55982);
        return c37081g;
    }
}
