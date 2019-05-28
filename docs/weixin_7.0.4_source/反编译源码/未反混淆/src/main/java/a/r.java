package a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, dWq = {"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"})
final class r<T> implements f<T>, Serializable {
    private static final AtomicReferenceFieldUpdater<r<?>, Object> AUu = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "AUs");
    public static final a AUv = new a();
    private volatile a.f.a.a<? extends T> AUr;
    private volatile Object AUs = w.AUx;
    private final Object AUt = w.AUx;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R^\u0010\u0003\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lkotlin/SafePublicationLazyImpl$Companion;", "", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/SafePublicationLazyImpl;", "kotlin.jvm.PlatformType", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public r(a.f.a.a<? extends T> aVar) {
        j.p(aVar, "initializer");
        AppMethodBeat.i(55911);
        this.AUr = aVar;
        AppMethodBeat.o(55911);
    }

    public final T getValue() {
        AppMethodBeat.i(55908);
        w wVar = this.AUs;
        if (wVar != w.AUx) {
            AppMethodBeat.o(55908);
            return wVar;
        }
        T invoke;
        a.f.a.a aVar = this.AUr;
        if (aVar != null) {
            invoke = aVar.invoke();
            if (AUu.compareAndSet(this, w.AUx, invoke)) {
                this.AUr = null;
                AppMethodBeat.o(55908);
                return invoke;
            }
        }
        invoke = this.AUs;
        AppMethodBeat.o(55908);
        return invoke;
    }

    private final Object writeReplace() {
        AppMethodBeat.i(55910);
        d dVar = new d(getValue());
        AppMethodBeat.o(55910);
        return dVar;
    }

    static {
        AppMethodBeat.i(55912);
        AppMethodBeat.o(55912);
    }

    public final String toString() {
        Object obj;
        AppMethodBeat.i(55909);
        if (this.AUs != w.AUx) {
            obj = 1;
        } else {
            obj = null;
        }
        String valueOf;
        if (obj != null) {
            valueOf = String.valueOf(getValue());
            AppMethodBeat.o(55909);
            return valueOf;
        }
        valueOf = "Lazy value not initialized yet.";
        AppMethodBeat.o(55909);
        return valueOf;
    }
}
