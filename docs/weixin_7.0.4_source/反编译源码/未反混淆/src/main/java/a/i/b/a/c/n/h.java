package a.i.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public final class h<E> extends AbstractList<E> implements RandomAccess {
    private int BNo;
    private Object BNp;

    class b extends c<E> {
        private final int BNr;

        public b() {
            super();
            AppMethodBeat.i(122951);
            this.BNr = h.this.modCount;
            AppMethodBeat.o(122951);
        }

        /* Access modifiers changed, original: protected|final */
        public final E ekB() {
            AppMethodBeat.i(122952);
            Object b = h.this.BNp;
            AppMethodBeat.o(122952);
            return b;
        }

        /* Access modifiers changed, original: protected|final */
        public final void ekC() {
            AppMethodBeat.i(122953);
            if (h.this.modCount != this.BNr) {
                ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException("ModCount: " + h.this.modCount + "; expected: " + this.BNr);
                AppMethodBeat.o(122953);
                throw concurrentModificationException;
            }
            AppMethodBeat.o(122953);
        }

        public final void remove() {
            AppMethodBeat.i(122954);
            ekC();
            h.this.clear();
            AppMethodBeat.o(122954);
        }
    }

    static abstract class c<T> implements Iterator<T> {
        private boolean BNt;

        public abstract T ekB();

        public abstract void ekC();

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final boolean hasNext() {
            return !this.BNt;
        }

        public final T next() {
            if (this.BNt) {
                throw new NoSuchElementException();
            }
            this.BNt = true;
            ekC();
            return ekB();
        }
    }

    static class a<T> implements Iterator<T> {
        private static final a BNq = new a();

        private a() {
        }

        static {
            AppMethodBeat.i(122950);
            AppMethodBeat.o(122950);
        }

        public static <T> a<T> ekA() {
            return BNq;
        }

        public final boolean hasNext() {
            return false;
        }

        public final T next() {
            AppMethodBeat.i(122948);
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            AppMethodBeat.o(122948);
            throw noSuchElementException;
        }

        public final void remove() {
            AppMethodBeat.i(122949);
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(122949);
            throw illegalStateException;
        }
    }

    public final E get(int i) {
        AppMethodBeat.i(122955);
        if (i < 0 || i >= this.BNo) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.BNo);
            AppMethodBeat.o(122955);
            throw indexOutOfBoundsException;
        } else if (this.BNo == 1) {
            Object obj = this.BNp;
            AppMethodBeat.o(122955);
            return obj;
        } else {
            E e = ((Object[]) this.BNp)[i];
            AppMethodBeat.o(122955);
            return e;
        }
    }

    public final boolean add(E e) {
        AppMethodBeat.i(122956);
        if (this.BNo == 0) {
            this.BNp = e;
        } else if (this.BNo == 1) {
            this.BNp = new Object[]{this.BNp, e};
        } else {
            Object[] objArr = (Object[]) this.BNp;
            int length = objArr.length;
            if (this.BNo >= length) {
                int i = ((length * 3) / 2) + 1;
                int i2 = this.BNo + 1;
                if (i >= i2) {
                    i2 = i;
                }
                Object[] objArr2 = new Object[i2];
                this.BNp = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.BNo] = e;
        }
        this.BNo++;
        this.modCount++;
        AppMethodBeat.o(122956);
        return true;
    }

    public final void add(int i, E e) {
        AppMethodBeat.i(122957);
        if (i < 0 || i > this.BNo) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.BNo);
            AppMethodBeat.o(122957);
            throw indexOutOfBoundsException;
        }
        if (this.BNo == 0) {
            this.BNp = e;
        } else if (this.BNo == 1 && i == 0) {
            this.BNp = new Object[]{e, this.BNp};
        } else {
            Object[] objArr = new Object[(this.BNo + 1)];
            if (this.BNo == 1) {
                objArr[0] = this.BNp;
            } else {
                Object[] objArr2 = (Object[]) this.BNp;
                System.arraycopy(objArr2, 0, objArr, 0, i);
                System.arraycopy(objArr2, i, objArr, i + 1, this.BNo - i);
            }
            objArr[i] = e;
            this.BNp = objArr;
        }
        this.BNo++;
        this.modCount++;
        AppMethodBeat.o(122957);
    }

    public final int size() {
        return this.BNo;
    }

    public final void clear() {
        this.BNp = null;
        this.BNo = 0;
        this.modCount++;
    }

    public final E set(int i, E e) {
        AppMethodBeat.i(122958);
        if (i < 0 || i >= this.BNo) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.BNo);
            AppMethodBeat.o(122958);
            throw indexOutOfBoundsException;
        }
        E e2;
        if (this.BNo == 1) {
            e2 = this.BNp;
            this.BNp = e;
        } else {
            Object[] objArr = (Object[]) this.BNp;
            E e3 = objArr[i];
            objArr[i] = e;
            e2 = e3;
        }
        AppMethodBeat.o(122958);
        return e2;
    }

    public final E remove(int i) {
        AppMethodBeat.i(122959);
        if (i < 0 || i >= this.BNo) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("Index: " + i + ", Size: " + this.BNo);
            AppMethodBeat.o(122959);
            throw indexOutOfBoundsException;
        }
        E e;
        if (this.BNo == 1) {
            e = this.BNp;
            this.BNp = null;
        } else {
            Object[] objArr = (Object[]) this.BNp;
            E e2 = objArr[i];
            if (this.BNo == 2) {
                this.BNp = objArr[1 - i];
                e = e2;
            } else {
                int i2 = (this.BNo - i) - 1;
                if (i2 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i2);
                }
                objArr[this.BNo - 1] = null;
                e = e2;
            }
        }
        this.BNo--;
        this.modCount++;
        AppMethodBeat.o(122959);
        return e;
    }

    public final Iterator<E> iterator() {
        AppMethodBeat.i(122960);
        Iterator<E> bVar;
        if (this.BNo == 0) {
            a ekA = a.ekA();
            AppMethodBeat.o(122960);
            return ekA;
        } else if (this.BNo == 1) {
            bVar = new b();
            AppMethodBeat.o(122960);
            return bVar;
        } else {
            bVar = super.iterator();
            AppMethodBeat.o(122960);
            return bVar;
        }
    }

    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(122961);
        int length = tArr.length;
        Object[] objArr;
        if (this.BNo == 1) {
            if (length != 0) {
                tArr[0] = this.BNp;
            } else {
                objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1);
                objArr[0] = this.BNp;
                AppMethodBeat.o(122961);
                return objArr;
            }
        } else if (length < this.BNo) {
            objArr = Arrays.copyOf((Object[]) this.BNp, this.BNo, tArr.getClass());
            AppMethodBeat.o(122961);
            return objArr;
        } else if (this.BNo != 0) {
            System.arraycopy(this.BNp, 0, tArr, 0, this.BNo);
        }
        if (length > this.BNo) {
            tArr[this.BNo] = null;
        }
        AppMethodBeat.o(122961);
        return tArr;
    }
}
