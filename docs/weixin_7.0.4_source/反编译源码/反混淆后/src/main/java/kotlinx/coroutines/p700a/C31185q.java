package kotlinx.coroutines.p700a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0013J$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H\b¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0011J\u000f\u0010\u001a\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010\u001bJ\r\u0010\u001c\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bH\u0002¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010#J$\u0010$\u001a\u0004\u0018\u00018\u00002\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0&H\b¢\u0006\u0002\u0010'J\r\u0010(\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001bJ\u0011\u0010)\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000eH\u0010J\u0011\u0010+\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000eH\u0010J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000eH\u0002R\u001a\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0018\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0006¨\u0006."}, dWq = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "T", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "", "()Z", "size", "", "size$annotations", "addImpl", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "addLastIf", "cond", "Lkotlin/Function0;", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function0;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "predicate", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "siftDownFrom", "i", "siftUpFrom", "swap", "j", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.a.q */
public final class C31185q<T extends C24581r & Comparable<? super T>> {
    public T[] BRS;
    public volatile int size;

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final synchronized T elR() {
        C24581r elS;
        AppMethodBeat.m2504i(118385);
        elS = elS();
        AppMethodBeat.m2505o(118385);
        return elS;
    }

    /* renamed from: a */
    public final synchronized boolean mo50952a(T t) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(118386);
            C25052j.m39376p(t, "node");
            if (t.elp() == null) {
                AppMethodBeat.m2505o(118386);
            } else {
                int index = t.getIndex();
                if (index >= 0) {
                    z = true;
                }
                if (z) {
                    mo50950Va(index);
                    AppMethodBeat.m2505o(118386);
                    z = true;
                } else {
                    Throwable illegalStateException = new IllegalStateException("Check failed.".toString());
                    AppMethodBeat.m2505o(118386);
                    throw illegalStateException;
                }
            }
        }
        return z;
    }

    public final T elS() {
        C24581r[] c24581rArr = this.BRS;
        return c24581rArr != null ? c24581rArr[0] : null;
    }

    /* renamed from: Va */
    public final T mo50950Va(int i) {
        AppMethodBeat.m2504i(118387);
        Throwable illegalStateException;
        if ((this.size > 0 ? 1 : null) == null) {
            illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.m2505o(118387);
            throw illegalStateException;
        }
        Object obj;
        C24581r[] c24581rArr = this.BRS;
        if (c24581rArr == null) {
            C25052j.dWJ();
        }
        this.size--;
        if (i < this.size) {
            m50275ir(i, this.size);
            int i2 = (i - 1) / 2;
            if (i > 0) {
                C24581r c24581r = c24581rArr[i];
                if (c24581r == null) {
                    C25052j.dWJ();
                }
                Comparable comparable = (Comparable) c24581r;
                Object obj2 = c24581rArr[i2];
                if (obj2 == null) {
                    C25052j.dWJ();
                }
                if (comparable.compareTo(obj2) < 0) {
                    m50275ir(i, i2);
                    mo50951Vb(i2);
                }
            }
            m50274Vc(i);
        }
        C24581r c24581r2 = c24581rArr[this.size];
        if (c24581r2 == null) {
            C25052j.dWJ();
        }
        if (c24581r2.elp() == this) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.m2505o(118387);
            throw illegalStateException;
        }
        c24581r2.mo30321a(null);
        c24581r2.setIndex(-1);
        c24581rArr[this.size] = null;
        AppMethodBeat.m2505o(118387);
        return c24581r2;
    }

    /* renamed from: Vb */
    public final void mo50951Vb(int i) {
        AppMethodBeat.m2504i(118388);
        while (i > 0) {
            C24581r[] c24581rArr = this.BRS;
            if (c24581rArr == null) {
                C25052j.dWJ();
            }
            int i2 = (i - 1) / 2;
            C24581r c24581r = c24581rArr[i2];
            if (c24581r == null) {
                C25052j.dWJ();
            }
            Comparable comparable = (Comparable) c24581r;
            Object obj = c24581rArr[i];
            if (obj == null) {
                C25052j.dWJ();
            }
            if (comparable.compareTo(obj) <= 0) {
                AppMethodBeat.m2505o(118388);
                return;
            } else {
                m50275ir(i, i2);
                i = i2;
            }
        }
        AppMethodBeat.m2505o(118388);
    }

    /* renamed from: Vc */
    private final void m50274Vc(int i) {
        AppMethodBeat.m2504i(118389);
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= this.size) {
                AppMethodBeat.m2505o(118389);
                return;
            }
            C24581r c24581r;
            Comparable comparable;
            C24581r[] c24581rArr = this.BRS;
            if (c24581rArr == null) {
                C25052j.dWJ();
            }
            if (i2 + 1 < this.size) {
                c24581r = c24581rArr[i2 + 1];
                if (c24581r == null) {
                    C25052j.dWJ();
                }
                comparable = (Comparable) c24581r;
                Object obj = c24581rArr[i2];
                if (obj == null) {
                    C25052j.dWJ();
                }
                if (comparable.compareTo(obj) < 0) {
                    i2++;
                }
            }
            c24581r = c24581rArr[i];
            if (c24581r == null) {
                C25052j.dWJ();
            }
            comparable = (Comparable) c24581r;
            Object obj2 = c24581rArr[i2];
            if (obj2 == null) {
                C25052j.dWJ();
            }
            if (comparable.compareTo(obj2) <= 0) {
                AppMethodBeat.m2505o(118389);
                return;
            } else {
                m50275ir(i, i2);
                i = i2;
            }
        }
    }

    /* renamed from: ir */
    private final void m50275ir(int i, int i2) {
        AppMethodBeat.m2504i(118390);
        C24581r[] c24581rArr = this.BRS;
        if (c24581rArr == null) {
            C25052j.dWJ();
        }
        C24581r c24581r = c24581rArr[i2];
        if (c24581r == null) {
            C25052j.dWJ();
        }
        C24581r c24581r2 = c24581rArr[i];
        if (c24581r2 == null) {
            C25052j.dWJ();
        }
        c24581rArr[i] = c24581r;
        c24581rArr[i2] = c24581r2;
        c24581r.setIndex(i);
        c24581r2.setIndex(i2);
        AppMethodBeat.m2505o(118390);
    }
}
