package a.a;

import a.f.b.a.a;
import a.f.b.b;
import a.f.b.f;
import a.f.b.j;
import a.l;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0002J\u0015\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00190\u0004¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, dWq = {"Lkotlin/collections/ArrayAsCollection;", "T", "", "values", "", "isVarargs", "", "([Ljava/lang/Object;Z)V", "()Z", "size", "", "getSize", "()I", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "kotlin-stdlib"})
public final class d<T> implements a, Collection<T> {
    private final boolean AUH;
    private final T[] akP;

    public final boolean add(T t) {
        AppMethodBeat.i(56194);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56194);
        throw unsupportedOperationException;
    }

    public final boolean addAll(Collection<? extends T> collection) {
        AppMethodBeat.i(56195);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56195);
        throw unsupportedOperationException;
    }

    public final void clear() {
        AppMethodBeat.i(56196);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56196);
        throw unsupportedOperationException;
    }

    public final boolean remove(Object obj) {
        AppMethodBeat.i(56197);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56197);
        throw unsupportedOperationException;
    }

    public final boolean removeAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(56198);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56198);
        throw unsupportedOperationException;
    }

    public final boolean retainAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(56199);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56199);
        throw unsupportedOperationException;
    }

    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(56200);
        Object[] a = f.a(this, tArr);
        AppMethodBeat.o(56200);
        return a;
    }

    public d(T[] tArr, boolean z) {
        j.p(tArr, "values");
        AppMethodBeat.i(56193);
        this.akP = tArr;
        this.AUH = z;
        AppMethodBeat.o(56193);
    }

    public final boolean isEmpty() {
        return this.akP.length == 0;
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(56189);
        boolean contains = i.contains(this.akP, obj);
        AppMethodBeat.o(56189);
        return contains;
    }

    public final boolean containsAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(56190);
        j.p(collection, MessengerShareContentUtility.ELEMENTS);
        Iterable<Object> iterable = collection;
        if (!((Collection) iterable).isEmpty()) {
            for (Object contains : iterable) {
                if (!contains(contains)) {
                    AppMethodBeat.o(56190);
                    return false;
                }
            }
        }
        AppMethodBeat.o(56190);
        return true;
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.i(56191);
        Iterator V = b.V(this.akP);
        AppMethodBeat.o(56191);
        return V;
    }

    public final Object[] toArray() {
        AppMethodBeat.i(56192);
        Object[] objArr = this.akP;
        boolean z = this.AUH;
        j.p(objArr, "receiver$0");
        if (z && j.j(objArr.getClass(), Object[].class)) {
            AppMethodBeat.o(56192);
            return objArr;
        }
        objArr = Arrays.copyOf(objArr, objArr.length, Object[].class);
        j.o(objArr, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        AppMethodBeat.o(56192);
        return objArr;
    }

    public final /* bridge */ int size() {
        return this.akP.length;
    }
}
