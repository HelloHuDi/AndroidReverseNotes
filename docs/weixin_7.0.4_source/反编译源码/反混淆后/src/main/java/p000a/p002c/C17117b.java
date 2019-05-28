package p000a.p002c;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p002c.C41366e.C17122a;
import p000a.p002c.C41366e.C36928c;
import p000a.p002c.C41366e.C41367b;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C41381u.C41380b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"})
/* renamed from: a.c.b */
public final class C17117b implements C41366e, Serializable {
    private final C41366e AUX;
    private final C41367b AUY;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"})
    /* renamed from: a.c.b$c */
    static final class C7995c extends C25053k implements C31591m<C37091y, C41367b, C37091y> {
        final /* synthetic */ C41366e[] AVc;
        final /* synthetic */ C41380b eOo;

        C7995c(C41366e[] c41366eArr, C41380b c41380b) {
            this.AVc = c41366eArr;
            this.eOo = c41380b;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(56380);
            C41367b c41367b = (C41367b) obj2;
            C25052j.m39376p((C37091y) obj, "<anonymous parameter 0>");
            C25052j.m39376p(c41367b, "element");
            C41366e[] c41366eArr = this.AVc;
            C41380b c41380b = this.eOo;
            int i = c41380b.AVD;
            c41380b.AVD = i + 1;
            c41366eArr[i] = c41367b;
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(56380);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, dWq = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"})
    /* renamed from: a.c.b$a */
    static final class C17118a implements Serializable {
        public static final C17119a AVa = new C17119a();
        private final C41366e[] AUZ;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
        /* renamed from: a.c.b$a$a */
        public static final class C17119a {
            private C17119a() {
            }

            public /* synthetic */ C17119a(byte b) {
                this();
            }
        }

        static {
            AppMethodBeat.m2504i(56372);
            AppMethodBeat.m2505o(56372);
        }

        public C17118a(C41366e[] c41366eArr) {
            C25052j.m39376p(c41366eArr, MessengerShareContentUtility.ELEMENTS);
            AppMethodBeat.m2504i(56371);
            this.AUZ = c41366eArr;
            AppMethodBeat.m2505o(56371);
        }

        private final Object readResolve() {
            AppMethodBeat.m2504i(56370);
            C41366e[] c41366eArr = this.AUZ;
            Object obj = C44850f.AVg;
            for (C41366e plus : c41366eArr) {
                obj = ((C41366e) obj).plus(plus);
            }
            AppMethodBeat.m2505o(56370);
            return obj;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    /* renamed from: a.c.b$b */
    static final class C17120b extends C25053k implements C31591m<String, C41367b, String> {
        public static final C17120b AVb = new C17120b();

        static {
            AppMethodBeat.m2504i(56369);
            AppMethodBeat.m2505o(56369);
        }

        C17120b() {
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(56368);
            String str = (String) obj;
            C41367b c41367b = (C41367b) obj2;
            C25052j.m39376p(str, "acc");
            C25052j.m39376p(c41367b, "element");
            if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
                String obj3 = c41367b.toString();
                AppMethodBeat.m2505o(56368);
                return obj3;
            }
            Object obj4 = str + ", " + c41367b;
            AppMethodBeat.m2505o(56368);
            return obj4;
        }
    }

    public C17117b(C41366e c41366e, C41367b c41367b) {
        C25052j.m39376p(c41366e, "left");
        C25052j.m39376p(c41367b, "element");
        AppMethodBeat.m2504i(56401);
        this.AUX = c41366e;
        this.AUY = c41367b;
        AppMethodBeat.m2505o(56401);
    }

    public final C41366e plus(C41366e c41366e) {
        AppMethodBeat.m2504i(56402);
        C25052j.m39376p(c41366e, "context");
        C41366e a = C17122a.m26493a(this, c41366e);
        AppMethodBeat.m2505o(56402);
        return a;
    }

    public final <E extends C41367b> E get(C36928c<E> c36928c) {
        AppMethodBeat.m2504i(56393);
        C25052j.m39376p(c36928c, "key");
        this = this;
        while (true) {
            C41367b c41367b = this.AUY.get(c36928c);
            if (c41367b != null) {
                AppMethodBeat.m2505o(56393);
                return c41367b;
            }
            C41366e c41366e = this.AUX;
            if (c41366e instanceof C17117b) {
                this = (C17117b) c41366e;
            } else {
                E e = c41366e.get(c36928c);
                AppMethodBeat.m2505o(56393);
                return e;
            }
        }
    }

    public final <R> R fold(R r, C31591m<? super R, ? super C41367b, ? extends R> c31591m) {
        AppMethodBeat.m2504i(56394);
        C25052j.m39376p(c31591m, "operation");
        Object m = c31591m.mo212m(this.AUX.fold(r, c31591m), this.AUY);
        AppMethodBeat.m2505o(56394);
        return m;
    }

    public final C41366e minusKey(C36928c<?> c36928c) {
        AppMethodBeat.m2504i(56395);
        C25052j.m39376p(c36928c, "key");
        C41366e c41366e;
        if (this.AUY.get(c36928c) != null) {
            c41366e = this.AUX;
            AppMethodBeat.m2505o(56395);
            return c41366e;
        }
        C41366e minusKey = this.AUX.minusKey(c36928c);
        if (minusKey == this.AUX) {
            C41366e c41366e2 = this;
            AppMethodBeat.m2505o(56395);
            return c41366e2;
        } else if (minusKey == C44850f.AVg) {
            c41366e = this.AUY;
            AppMethodBeat.m2505o(56395);
            return c41366e;
        } else {
            c41366e = new C17117b(minusKey, this.AUY);
            AppMethodBeat.m2505o(56395);
            return c41366e;
        }
    }

    private final int size() {
        this = this;
        int i = 2;
        while (true) {
            C41366e c41366e = this.AUX;
            if (!(c41366e instanceof C17117b)) {
                c41366e = null;
            }
            C17117b c17117b = (C17117b) c41366e;
            if (c17117b == null) {
                return i;
            }
            i++;
            this = c17117b;
        }
    }

    /* renamed from: a */
    private final boolean m26491a(C41367b c41367b) {
        AppMethodBeat.m2504i(56396);
        boolean j = C25052j.m39373j(get(c41367b.getKey()), c41367b);
        AppMethodBeat.m2505o(56396);
        return j;
    }

    /* JADX WARNING: Missing block: B:10:0x0028, code skipped:
            if (r0 == false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(56397);
        if (this != obj) {
            if ((obj instanceof C17117b) && ((C17117b) obj).size() == size()) {
                boolean a;
                C17117b c17117b = (C17117b) obj;
                while (c17117b.m26491a(this.AUY)) {
                    C41366e c41366e = this.AUX;
                    if (c41366e instanceof C17117b) {
                        this = (C17117b) c41366e;
                    } else if (c41366e == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        AppMethodBeat.m2505o(56397);
                        throw c44941v;
                    } else {
                        a = c17117b.m26491a((C41367b) c41366e);
                    }
                }
                a = false;
            }
            AppMethodBeat.m2505o(56397);
            return false;
        }
        AppMethodBeat.m2505o(56397);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(56398);
        int hashCode = this.AUX.hashCode() + this.AUY.hashCode();
        AppMethodBeat.m2505o(56398);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(56399);
        String str = "[" + ((String) fold("", C17120b.AVb)) + "]";
        AppMethodBeat.m2505o(56399);
        return str;
    }

    private final Object writeReplace() {
        AppMethodBeat.m2504i(56400);
        int size = size();
        C41366e[] c41366eArr = new C41366e[size];
        C41380b c41380b = new C41380b();
        c41380b.AVD = 0;
        fold(C37091y.AUy, new C7995c(c41366eArr, c41380b));
        if ((c41380b.AVD == size ? 1 : 0) == 0) {
            Throwable illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.m2505o(56400);
            throw illegalStateException;
        }
        C17118a c17118a = new C17118a(c41366eArr);
        AppMethodBeat.m2505o(56400);
        return c17118a;
    }
}
