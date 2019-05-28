package a;

import a.f.a.a;
import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(dWo = {1, 1, 13}, dWp = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, dWq = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"})
public final class z<T> implements f<T>, Serializable {
    private a<? extends T> AUr;
    private Object AUs = w.AUx;

    public z(a<? extends T> aVar) {
        j.p(aVar, "initializer");
        AppMethodBeat.i(56411);
        this.AUr = aVar;
        AppMethodBeat.o(56411);
    }

    public final T getValue() {
        AppMethodBeat.i(56408);
        if (this.AUs == w.AUx) {
            a aVar = this.AUr;
            if (aVar == null) {
                j.dWJ();
            }
            this.AUs = aVar.invoke();
            this.AUr = null;
        }
        Object obj = this.AUs;
        AppMethodBeat.o(56408);
        return obj;
    }

    private final Object writeReplace() {
        AppMethodBeat.i(56410);
        d dVar = new d(getValue());
        AppMethodBeat.o(56410);
        return dVar;
    }

    public final String toString() {
        Object obj;
        AppMethodBeat.i(56409);
        if (this.AUs != w.AUx) {
            obj = 1;
        } else {
            obj = null;
        }
        String valueOf;
        if (obj != null) {
            valueOf = String.valueOf(getValue());
            AppMethodBeat.o(56409);
            return valueOf;
        }
        valueOf = "Lazy value not initialized yet.";
        AppMethodBeat.o(56409);
        return valueOf;
    }
}
