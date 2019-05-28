package a;

import a.f.a.a;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, dWq = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
final class s<T> implements f<T>, Serializable {
    private a<? extends T> AUr;
    private volatile Object AUs;
    private final Object lock;

    private s(a<? extends T> aVar) {
        j.p(aVar, "initializer");
        AppMethodBeat.i(56256);
        this.AUr = aVar;
        this.AUs = w.AUx;
        this.lock = this;
        AppMethodBeat.o(56256);
    }

    public /* synthetic */ s(a aVar, byte b) {
        this(aVar);
    }

    public final T getValue() {
        AppMethodBeat.i(56253);
        T t = this.AUs;
        if (t != w.AUx) {
            AppMethodBeat.o(56253);
        } else {
            synchronized (this.lock) {
                try {
                    t = this.AUs;
                    if (t == w.AUx) {
                        a aVar = this.AUr;
                        if (aVar == null) {
                            j.dWJ();
                        }
                        t = aVar.invoke();
                        this.AUs = t;
                        this.AUr = null;
                    }
                } finally {
                    AppMethodBeat.o(56253);
                }
            }
        }
        return t;
    }

    private final Object writeReplace() {
        AppMethodBeat.i(56255);
        d dVar = new d(getValue());
        AppMethodBeat.o(56255);
        return dVar;
    }

    public final String toString() {
        Object obj;
        AppMethodBeat.i(56254);
        if (this.AUs != w.AUx) {
            obj = 1;
        } else {
            obj = null;
        }
        String valueOf;
        if (obj != null) {
            valueOf = String.valueOf(getValue());
            AppMethodBeat.o(56254);
            return valueOf;
        }
        valueOf = "Lazy value not initialized yet.";
        AppMethodBeat.o(56254);
        return valueOf;
    }
}
