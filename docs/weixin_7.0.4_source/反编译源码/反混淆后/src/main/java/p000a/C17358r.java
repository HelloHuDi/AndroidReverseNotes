package p000a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, dWq = {"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"})
/* renamed from: a.r */
final class C17358r<T> implements C44856f<T>, Serializable {
    private static final AtomicReferenceFieldUpdater<C17358r<?>, Object> AUu = AtomicReferenceFieldUpdater.newUpdater(C17358r.class, Object.class, "AUs");
    public static final C0221a AUv = new C0221a();
    private volatile C31214a<? extends T> AUr;
    private volatile Object AUs = C37090w.AUx;
    private final Object AUt = C37090w.AUx;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R^\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"})
    /* renamed from: a.r$a */
    public static final class C0221a {
        private C0221a() {
        }

        public /* synthetic */ C0221a(byte b) {
            this();
        }
    }

    public C17358r(C31214a<? extends T> c31214a) {
        C25052j.m39376p(c31214a, "initializer");
        AppMethodBeat.m2504i(55911);
        this.AUr = c31214a;
        AppMethodBeat.m2505o(55911);
    }

    public final T getValue() {
        AppMethodBeat.m2504i(55908);
        C37090w c37090w = this.AUs;
        if (c37090w != C37090w.AUx) {
            AppMethodBeat.m2505o(55908);
            return c37090w;
        }
        T invoke;
        C31214a c31214a = this.AUr;
        if (c31214a != null) {
            invoke = c31214a.invoke();
            if (AUu.compareAndSet(this, C37090w.AUx, invoke)) {
                this.AUr = null;
                AppMethodBeat.m2505o(55908);
                return invoke;
            }
        }
        invoke = this.AUs;
        AppMethodBeat.m2505o(55908);
        return invoke;
    }

    private final Object writeReplace() {
        AppMethodBeat.m2504i(55910);
        C36929d c36929d = new C36929d(getValue());
        AppMethodBeat.m2505o(55910);
        return c36929d;
    }

    static {
        AppMethodBeat.m2504i(55912);
        AppMethodBeat.m2505o(55912);
    }

    public final String toString() {
        Object obj;
        AppMethodBeat.m2504i(55909);
        if (this.AUs != C37090w.AUx) {
            obj = 1;
        } else {
            obj = null;
        }
        String valueOf;
        if (obj != null) {
            valueOf = String.valueOf(getValue());
            AppMethodBeat.m2505o(55909);
            return valueOf;
        }
        valueOf = "Lazy value not initialized yet.";
        AppMethodBeat.m2505o(55909);
        return valueOf;
    }
}
