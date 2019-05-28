package kotlinx.coroutines.a;

import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, dWq = {"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class b<T> {
    private Object[] BRf = new Object[16];
    private int BRg;
    private int uBV;

    public b() {
        AppMethodBeat.i(118440);
        AppMethodBeat.o(118440);
    }

    public final void addLast(T t) {
        AppMethodBeat.i(118437);
        j.p(t, "element");
        this.BRf[this.uBV] = t;
        this.uBV = (this.uBV + 1) & (this.BRf.length - 1);
        if (this.uBV == this.BRg) {
            elF();
        }
        AppMethodBeat.o(118437);
    }

    public final T elE() {
        AppMethodBeat.i(118438);
        if (this.BRg == this.uBV) {
            AppMethodBeat.o(118438);
            return null;
        }
        T t = this.BRf[this.BRg];
        this.BRf[this.BRg] = null;
        this.BRg = (this.BRg + 1) & (this.BRf.length - 1);
        if (t == null) {
            v vVar = new v("null cannot be cast to non-null type T");
            AppMethodBeat.o(118438);
            throw vVar;
        }
        AppMethodBeat.o(118438);
        return t;
    }

    public final void clear() {
        this.BRg = 0;
        this.uBV = 0;
        this.BRf = new Object[this.BRf.length];
    }

    private final void elF() {
        AppMethodBeat.i(118439);
        int length = this.BRf.length;
        Object[] objArr = new Object[(length << 1)];
        int length2 = this.BRf.length - this.BRg;
        a.a(this.BRf, this.BRg, objArr, 0, length2);
        a.a(this.BRf, 0, objArr, length2, this.BRg);
        this.BRf = objArr;
        this.BRg = 0;
        this.uBV = length;
        AppMethodBeat.o(118439);
    }
}
