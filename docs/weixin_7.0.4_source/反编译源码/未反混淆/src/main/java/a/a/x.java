package a.a;

import a.f.b.a.a;
import a.f.b.f;
import a.f.b.j;
import a.l;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@l(dWo = {1, 1, 13}, dWp = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, dWq = {"Lkotlin/collections/EmptySet;", "", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "hashCode", "isEmpty", "iterator", "", "readResolve", "toString", "", "kotlin-stdlib"})
public final class x implements a, Serializable, Set {
    public static final x AUR = new x();

    public final /* synthetic */ boolean add(Object obj) {
        AppMethodBeat.i(56175);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56175);
        throw unsupportedOperationException;
    }

    public final boolean addAll(Collection collection) {
        AppMethodBeat.i(56170);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56170);
        throw unsupportedOperationException;
    }

    public final void clear() {
        AppMethodBeat.i(56171);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56171);
        throw unsupportedOperationException;
    }

    public final boolean remove(Object obj) {
        AppMethodBeat.i(56172);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56172);
        throw unsupportedOperationException;
    }

    public final boolean removeAll(Collection collection) {
        AppMethodBeat.i(56173);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56173);
        throw unsupportedOperationException;
    }

    public final boolean retainAll(Collection collection) {
        AppMethodBeat.i(56174);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56174);
        throw unsupportedOperationException;
    }

    public final Object[] toArray() {
        AppMethodBeat.i(56176);
        Object[] j = f.j(this);
        AppMethodBeat.o(56176);
        return j;
    }

    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(56177);
        Object[] a = f.a(this, tArr);
        AppMethodBeat.o(56177);
        return a;
    }

    static {
        AppMethodBeat.i(56169);
        AppMethodBeat.o(56169);
    }

    private x() {
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(56167);
        if (obj instanceof Void) {
            j.p((Void) obj, "element");
            AppMethodBeat.o(56167);
        } else {
            AppMethodBeat.o(56167);
        }
        return false;
    }

    public final /* bridge */ int size() {
        return 0;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(56166);
        if ((obj instanceof Set) && ((Set) obj).isEmpty()) {
            AppMethodBeat.o(56166);
            return true;
        }
        AppMethodBeat.o(56166);
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "[]";
    }

    public final boolean isEmpty() {
        return true;
    }

    public final boolean containsAll(Collection collection) {
        AppMethodBeat.i(56168);
        j.p(collection, MessengerShareContentUtility.ELEMENTS);
        boolean isEmpty = collection.isEmpty();
        AppMethodBeat.o(56168);
        return isEmpty;
    }

    public final Iterator iterator() {
        return u.AUO;
    }

    private final Object readResolve() {
        return AUR;
    }
}
