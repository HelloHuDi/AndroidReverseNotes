package p000a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b@\u0018\u0000 \u001e*\u0006\b\u0000\u0010\u0001 \u00012\u00060\u0002j\u0002`\u0003:\u0002\u001e\u001fB\u0016\b\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0004\b\u0017\u0010\u0007J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, dWq = {"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", "other", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"})
/* renamed from: a.p */
public final class C37088p<T> implements Serializable {
    public static final C37087a AUp = new C37087a();
    private final Object value;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\bø\u0001\u0000¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\n\u001a\u0002H\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, dWq = {"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
    /* renamed from: a.p$a */
    public static final class C37087a {
        private C37087a() {
        }

        public /* synthetic */ C37087a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, dWq = {"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
    /* renamed from: a.p$b */
    public static final class C37089b implements Serializable {
        public final Throwable AUq;

        public C37089b(Throwable th) {
            C25052j.m39376p(th, "exception");
            AppMethodBeat.m2504i(56420);
            this.AUq = th;
            AppMethodBeat.m2505o(56420);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(56417);
            if ((obj instanceof C37089b) && C25052j.m39373j(this.AUq, ((C37089b) obj).AUq)) {
                AppMethodBeat.m2505o(56417);
                return true;
            }
            AppMethodBeat.m2505o(56417);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(56418);
            int hashCode = this.AUq.hashCode();
            AppMethodBeat.m2505o(56418);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.m2504i(56419);
            String str = "Failure(" + this.AUq + ')';
            AppMethodBeat.m2505o(56419);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(56250);
        AppMethodBeat.m2505o(56250);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(56252);
        Object obj2 = this.value;
        if ((obj instanceof C37088p) && C25052j.m39373j(obj2, ((C37088p) obj).value)) {
            AppMethodBeat.m2505o(56252);
            return true;
        }
        AppMethodBeat.m2505o(56252);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(56251);
        Object obj = this.value;
        if (obj != null) {
            int hashCode = obj.hashCode();
            AppMethodBeat.m2505o(56251);
            return hashCode;
        }
        AppMethodBeat.m2505o(56251);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.m2504i(56249);
        Object obj = this.value;
        String obj2;
        if (obj instanceof C37089b) {
            obj2 = obj.toString();
            AppMethodBeat.m2505o(56249);
            return obj2;
        }
        obj2 = "Success(" + obj + ')';
        AppMethodBeat.m2505o(56249);
        return obj2;
    }

    /* renamed from: dl */
    public static Object m62044dl(Object obj) {
        return obj;
    }

    /* renamed from: dj */
    public static final boolean m62042dj(Object obj) {
        return !(obj instanceof C37089b);
    }

    /* renamed from: dk */
    public static final Throwable m62043dk(Object obj) {
        if (obj instanceof C37089b) {
            return ((C37089b) obj).AUq;
        }
        return null;
    }
}
