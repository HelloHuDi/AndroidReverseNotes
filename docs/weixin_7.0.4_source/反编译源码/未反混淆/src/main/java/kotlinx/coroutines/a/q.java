package kotlinx.coroutines.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013J$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H\b¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0011J\u000f\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bH\u0002¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010#J$\u0010$\u001a\u0004\u0018\u00018\u00002\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0&H\b¢\u0006\u0002\u0010'J\r\u0010(\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ\u0011\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000eH\u0010J\u0011\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000eH\u0010J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000eH\u0002R\u001a\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0018\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0006¨\u0006."}, dWq = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "", "()Z", "size", "", "size$annotations", "addImpl", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "addLastIf", "cond", "Lkotlin/Function0;", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function0;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "predicate", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "siftDownFrom", "i", "siftUpFrom", "swap", "j", "kotlinx-coroutines-core"})
public final class q<T extends r & Comparable<? super T>> {
    public T[] BRS;
    public volatile int size;

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final synchronized T elR() {
        r elS;
        AppMethodBeat.i(118385);
        elS = elS();
        AppMethodBeat.o(118385);
        return elS;
    }

    public final synchronized boolean a(T t) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(118386);
            j.p(t, "node");
            if (t.elp() == null) {
                AppMethodBeat.o(118386);
            } else {
                int index = t.getIndex();
                if (index >= 0) {
                    z = true;
                }
                if (z) {
                    Va(index);
                    AppMethodBeat.o(118386);
                    z = true;
                } else {
                    Throwable illegalStateException = new IllegalStateException("Check failed.".toString());
                    AppMethodBeat.o(118386);
                    throw illegalStateException;
                }
            }
        }
        return z;
    }

    public final T elS() {
        r[] rVarArr = this.BRS;
        return rVarArr != null ? rVarArr[0] : null;
    }

    public final T Va(int i) {
        AppMethodBeat.i(118387);
        Throwable illegalStateException;
        if ((this.size > 0 ? 1 : null) == null) {
            illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(118387);
            throw illegalStateException;
        }
        Object obj;
        r[] rVarArr = this.BRS;
        if (rVarArr == null) {
            j.dWJ();
        }
        this.size--;
        if (i < this.size) {
            ir(i, this.size);
            int i2 = (i - 1) / 2;
            if (i > 0) {
                r rVar = rVarArr[i];
                if (rVar == null) {
                    j.dWJ();
                }
                Comparable comparable = (Comparable) rVar;
                Object obj2 = rVarArr[i2];
                if (obj2 == null) {
                    j.dWJ();
                }
                if (comparable.compareTo(obj2) < 0) {
                    ir(i, i2);
                    Vb(i2);
                }
            }
            Vc(i);
        }
        r rVar2 = rVarArr[this.size];
        if (rVar2 == null) {
            j.dWJ();
        }
        if (rVar2.elp() == this) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(118387);
            throw illegalStateException;
        }
        rVar2.a(null);
        rVar2.setIndex(-1);
        rVarArr[this.size] = null;
        AppMethodBeat.o(118387);
        return rVar2;
    }

    public final void Vb(int i) {
        AppMethodBeat.i(118388);
        while (i > 0) {
            r[] rVarArr = this.BRS;
            if (rVarArr == null) {
                j.dWJ();
            }
            int i2 = (i - 1) / 2;
            r rVar = rVarArr[i2];
            if (rVar == null) {
                j.dWJ();
            }
            Comparable comparable = (Comparable) rVar;
            Object obj = rVarArr[i];
            if (obj == null) {
                j.dWJ();
            }
            if (comparable.compareTo(obj) <= 0) {
                AppMethodBeat.o(118388);
                return;
            } else {
                ir(i, i2);
                i = i2;
            }
        }
        AppMethodBeat.o(118388);
    }

    private final void Vc(int i) {
        AppMethodBeat.i(118389);
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= this.size) {
                AppMethodBeat.o(118389);
                return;
            }
            r rVar;
            Comparable comparable;
            r[] rVarArr = this.BRS;
            if (rVarArr == null) {
                j.dWJ();
            }
            if (i2 + 1 < this.size) {
                rVar = rVarArr[i2 + 1];
                if (rVar == null) {
                    j.dWJ();
                }
                comparable = (Comparable) rVar;
                Object obj = rVarArr[i2];
                if (obj == null) {
                    j.dWJ();
                }
                if (comparable.compareTo(obj) < 0) {
                    i2++;
                }
            }
            rVar = rVarArr[i];
            if (rVar == null) {
                j.dWJ();
            }
            comparable = (Comparable) rVar;
            Object obj2 = rVarArr[i2];
            if (obj2 == null) {
                j.dWJ();
            }
            if (comparable.compareTo(obj2) <= 0) {
                AppMethodBeat.o(118389);
                return;
            } else {
                ir(i, i2);
                i = i2;
            }
        }
    }

    private final void ir(int i, int i2) {
        AppMethodBeat.i(118390);
        r[] rVarArr = this.BRS;
        if (rVarArr == null) {
            j.dWJ();
        }
        r rVar = rVarArr[i2];
        if (rVar == null) {
            j.dWJ();
        }
        r rVar2 = rVarArr[i];
        if (rVar2 == null) {
            j.dWJ();
        }
        rVarArr[i] = rVar;
        rVarArr[i2] = rVar2;
        rVar.setIndex(i);
        rVar2.setIndex(i2);
        AppMethodBeat.o(118390);
    }
}
