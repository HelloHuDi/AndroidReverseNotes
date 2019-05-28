package a.i.b.a.c.n;

import a.a.ag;
import a.f.b.a.d;
import a.f.b.j;
import a.f.b.z;
import a.v;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public final class i<T> extends AbstractSet<T> {
    private static final int BNu = 5;
    public static final b BNv = new b();
    private Object data;
    private int size;

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        public static <T> i<T> ekD() {
            AppMethodBeat.i(122966);
            i iVar = new i();
            AppMethodBeat.o(122966);
            return iVar;
        }
    }

    static final class a<T> implements d, Iterator<T> {
        private final Iterator<T> BNw;

        public a(T[] tArr) {
            j.p(tArr, "array");
            AppMethodBeat.i(122965);
            this.BNw = a.f.b.b.V(tArr);
            AppMethodBeat.o(122965);
        }

        public final boolean hasNext() {
            AppMethodBeat.i(122962);
            boolean hasNext = this.BNw.hasNext();
            AppMethodBeat.o(122962);
            return hasNext;
        }

        public final T next() {
            AppMethodBeat.i(122963);
            Object next = this.BNw.next();
            AppMethodBeat.o(122963);
            return next;
        }

        public final /* synthetic */ void remove() {
            AppMethodBeat.i(122964);
            Throwable unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(122964);
            throw unsupportedOperationException;
        }
    }

    static final class c<T> implements d, Iterator<T> {
        private final T AVE;
        private boolean AVN = true;

        public c(T t) {
            this.AVE = t;
        }

        public final T next() {
            AppMethodBeat.i(122967);
            if (this.AVN) {
                this.AVN = false;
                Object obj = this.AVE;
                AppMethodBeat.o(122967);
                return obj;
            }
            Throwable noSuchElementException = new NoSuchElementException();
            AppMethodBeat.o(122967);
            throw noSuchElementException;
        }

        public final boolean hasNext() {
            return this.AVN;
        }

        public final /* synthetic */ void remove() {
            AppMethodBeat.i(122968);
            Throwable unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(122968);
            throw unsupportedOperationException;
        }
    }

    public static final <T> i<T> ekD() {
        AppMethodBeat.i(122973);
        i ekD = b.ekD();
        AppMethodBeat.o(122973);
        return ekD;
    }

    private i() {
    }

    public /* synthetic */ i(byte b) {
        this();
    }

    static {
        AppMethodBeat.i(122972);
        AppMethodBeat.o(122972);
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.i(122969);
        Iterator<T> cVar;
        Object obj;
        v vVar;
        if (size() == 0) {
            Iterator it = Collections.emptySet().iterator();
            AppMethodBeat.o(122969);
            return it;
        } else if (size() == 1) {
            cVar = new c(this.data);
            AppMethodBeat.o(122969);
            return cVar;
        } else if (size() < BNu) {
            obj = this.data;
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(122969);
                throw vVar;
            }
            cVar = new a((Object[]) obj);
            AppMethodBeat.o(122969);
            return cVar;
        } else {
            obj = this.data;
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
                AppMethodBeat.o(122969);
                throw vVar;
            }
            cVar = z.dr(obj).iterator();
            AppMethodBeat.o(122969);
            return cVar;
        }
    }

    public final boolean add(T t) {
        AppMethodBeat.i(122970);
        Object obj;
        v vVar;
        if (size() == 0) {
            this.data = t;
        } else if (size() == 1) {
            if (j.j(this.data, t)) {
                AppMethodBeat.o(122970);
                return false;
            }
            this.data = new Object[]{this.data, t};
        } else if (size() < BNu) {
            obj = this.data;
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(122970);
                throw vVar;
            }
            Object[] objArr = (Object[]) obj;
            if (a.a.i.contains(objArr, (Object) t)) {
                AppMethodBeat.o(122970);
                return false;
            }
            i iVar;
            if (size() == BNu - 1) {
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                j.p(copyOf, MessengerShareContentUtility.ELEMENTS);
                obj = (LinkedHashSet) a.a.i.a(copyOf, (Collection) new LinkedHashSet(ag.SI(copyOf.length)));
                obj.add(t);
                iVar = this;
            } else {
                obj = Arrays.copyOf(objArr, size() + 1);
                obj[obj.length - 1] = t;
                iVar = this;
            }
            iVar.data = obj;
        } else {
            obj = this.data;
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
                AppMethodBeat.o(122970);
                throw vVar;
            } else if (!z.dr(obj).add(t)) {
                AppMethodBeat.o(122970);
                return false;
            }
        }
        this.size = size() + 1;
        AppMethodBeat.o(122970);
        return true;
    }

    public final void clear() {
        this.data = null;
        this.size = 0;
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(122971);
        boolean j;
        Object obj2;
        v vVar;
        if (size() == 0) {
            AppMethodBeat.o(122971);
            return false;
        } else if (size() == 1) {
            j = j.j(this.data, obj);
            AppMethodBeat.o(122971);
            return j;
        } else if (size() < BNu) {
            obj2 = this.data;
            if (obj2 == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(122971);
                throw vVar;
            }
            j = a.a.i.contains((Object[]) obj2, obj);
            AppMethodBeat.o(122971);
            return j;
        } else {
            obj2 = this.data;
            if (obj2 == null) {
                vVar = new v("null cannot be cast to non-null type kotlin.collections.Set<T>");
                AppMethodBeat.o(122971);
                throw vVar;
            }
            j = ((Set) obj2).contains(obj);
            AppMethodBeat.o(122971);
            return j;
        }
    }

    public final /* bridge */ int size() {
        return this.size;
    }
}
