package a.h;

import a.d.c;
import a.l;
import android.support.v4.widget.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, dWq = {"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class b implements a.f.b.a.a, Iterable<Integer> {
    public static final a AVL = new a();
    public final int AVJ;
    public final int AVK;
    public final int hzv;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, dWq = {"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static b aP(int i, int i2, int i3) {
            AppMethodBeat.i(55983);
            b bVar = new b(i, i2, i3);
            AppMethodBeat.o(55983);
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(56000);
        AppMethodBeat.o(56000);
    }

    public b(int i, int i2, int i3) {
        AppMethodBeat.i(55999);
        Throwable illegalArgumentException;
        if (i3 == 0) {
            illegalArgumentException = new IllegalArgumentException("Step must be non-zero.");
            AppMethodBeat.o(55999);
            throw illegalArgumentException;
        } else if (i3 == j.INVALID_ID) {
            illegalArgumentException = new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            AppMethodBeat.o(55999);
            throw illegalArgumentException;
        } else {
            this.AVJ = i;
            if (i3 > 0) {
                if (i < i2) {
                    i2 -= c.aO(i2, i, i3);
                }
            } else if (i3 >= 0) {
                illegalArgumentException = new IllegalArgumentException("Step is zero.");
                AppMethodBeat.o(55999);
                throw illegalArgumentException;
            } else if (i > i2) {
                i2 += c.aO(i, i2, -i3);
            }
            this.AVK = i2;
            this.hzv = i3;
            AppMethodBeat.o(55999);
        }
    }

    public boolean isEmpty() {
        return this.hzv > 0 ? this.AVJ > this.AVK : this.AVJ < this.AVK;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(55996);
        if ((obj instanceof b) && ((isEmpty() && ((b) obj).isEmpty()) || (this.AVJ == ((b) obj).AVJ && this.AVK == ((b) obj).AVK && this.hzv == ((b) obj).hzv))) {
            AppMethodBeat.o(55996);
            return true;
        }
        AppMethodBeat.o(55996);
        return false;
    }

    public int hashCode() {
        AppMethodBeat.i(55997);
        if (isEmpty()) {
            AppMethodBeat.o(55997);
            return -1;
        }
        int i = (((this.AVJ * 31) + this.AVK) * 31) + this.hzv;
        AppMethodBeat.o(55997);
        return i;
    }

    public String toString() {
        AppMethodBeat.i(55998);
        String str;
        if (this.hzv > 0) {
            str = this.AVJ + ".." + this.AVK + " step " + this.hzv;
            AppMethodBeat.o(55998);
            return str;
        }
        str = this.AVJ + " downTo " + this.AVK + " step " + (-this.hzv);
        AppMethodBeat.o(55998);
        return str;
    }

    public /* synthetic */ Iterator iterator() {
        AppMethodBeat.i(55995);
        Iterator cVar = new c(this.AVJ, this.AVK, this.hzv);
        AppMethodBeat.o(55995);
        return cVar;
    }
}
