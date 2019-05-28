package p000a.p010i.p011b.p012a.p015c.p048n;

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
import p000a.C44941v;
import p000a.p001a.C31586ag;
import p000a.p001a.C36913i;
import p000a.p005f.p007b.C0014z;
import p000a.p005f.p007b.C17131b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.p1144a.C17129d;

/* renamed from: a.i.b.a.c.n.i */
public final class C44929i<T> extends AbstractSet<T> {
    private static final int BNu = 5;
    public static final C17332b BNv = new C17332b();
    private Object data;
    private int size;

    /* renamed from: a.i.b.a.c.n.i$b */
    public static final class C17332b {
        private C17332b() {
        }

        public /* synthetic */ C17332b(byte b) {
            this();
        }

        public static <T> C44929i<T> ekD() {
            AppMethodBeat.m2504i(122966);
            C44929i c44929i = new C44929i();
            AppMethodBeat.m2505o(122966);
            return c44929i;
        }
    }

    /* renamed from: a.i.b.a.c.n.i$a */
    static final class C24626a<T> implements C17129d, Iterator<T> {
        private final Iterator<T> BNw;

        public C24626a(T[] tArr) {
            C25052j.m39376p(tArr, "array");
            AppMethodBeat.m2504i(122965);
            this.BNw = C17131b.m26501V(tArr);
            AppMethodBeat.m2505o(122965);
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(122962);
            boolean hasNext = this.BNw.hasNext();
            AppMethodBeat.m2505o(122962);
            return hasNext;
        }

        public final T next() {
            AppMethodBeat.m2504i(122963);
            Object next = this.BNw.next();
            AppMethodBeat.m2505o(122963);
            return next;
        }

        public final /* synthetic */ void remove() {
            AppMethodBeat.m2504i(122964);
            Throwable unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(122964);
            throw unsupportedOperationException;
        }
    }

    /* renamed from: a.i.b.a.c.n.i$c */
    static final class C31787c<T> implements C17129d, Iterator<T> {
        private final T AVE;
        private boolean AVN = true;

        public C31787c(T t) {
            this.AVE = t;
        }

        public final T next() {
            AppMethodBeat.m2504i(122967);
            if (this.AVN) {
                this.AVN = false;
                Object obj = this.AVE;
                AppMethodBeat.m2505o(122967);
                return obj;
            }
            Throwable noSuchElementException = new NoSuchElementException();
            AppMethodBeat.m2505o(122967);
            throw noSuchElementException;
        }

        public final boolean hasNext() {
            return this.AVN;
        }

        public final /* synthetic */ void remove() {
            AppMethodBeat.m2504i(122968);
            Throwable unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(122968);
            throw unsupportedOperationException;
        }
    }

    public static final <T> C44929i<T> ekD() {
        AppMethodBeat.m2504i(122973);
        C44929i ekD = C17332b.ekD();
        AppMethodBeat.m2505o(122973);
        return ekD;
    }

    private C44929i() {
    }

    public /* synthetic */ C44929i(byte b) {
        this();
    }

    static {
        AppMethodBeat.m2504i(122972);
        AppMethodBeat.m2505o(122972);
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.m2504i(122969);
        Iterator<T> c31787c;
        Object obj;
        C44941v c44941v;
        if (size() == 0) {
            Iterator it = Collections.emptySet().iterator();
            AppMethodBeat.m2505o(122969);
            return it;
        } else if (size() == 1) {
            c31787c = new C31787c(this.data);
            AppMethodBeat.m2505o(122969);
            return c31787c;
        } else if (size() < BNu) {
            obj = this.data;
            if (obj == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.m2505o(122969);
                throw c44941v;
            }
            c31787c = new C24626a((Object[]) obj);
            AppMethodBeat.m2505o(122969);
            return c31787c;
        } else {
            obj = this.data;
            if (obj == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
                AppMethodBeat.m2505o(122969);
                throw c44941v;
            }
            c31787c = C0014z.m6dr(obj).iterator();
            AppMethodBeat.m2505o(122969);
            return c31787c;
        }
    }

    public final boolean add(T t) {
        AppMethodBeat.m2504i(122970);
        Object obj;
        C44941v c44941v;
        if (size() == 0) {
            this.data = t;
        } else if (size() == 1) {
            if (C25052j.m39373j(this.data, t)) {
                AppMethodBeat.m2505o(122970);
                return false;
            }
            this.data = new Object[]{this.data, t};
        } else if (size() < BNu) {
            obj = this.data;
            if (obj == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.m2505o(122970);
                throw c44941v;
            }
            Object[] objArr = (Object[]) obj;
            if (C36913i.contains(objArr, (Object) t)) {
                AppMethodBeat.m2505o(122970);
                return false;
            }
            C44929i c44929i;
            if (size() == BNu - 1) {
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                C25052j.m39376p(copyOf, MessengerShareContentUtility.ELEMENTS);
                obj = (LinkedHashSet) C36913i.m61691a(copyOf, (Collection) new LinkedHashSet(C31586ag.m51047SI(copyOf.length)));
                obj.add(t);
                c44929i = this;
            } else {
                obj = Arrays.copyOf(objArr, size() + 1);
                obj[obj.length - 1] = t;
                c44929i = this;
            }
            c44929i.data = obj;
        } else {
            obj = this.data;
            if (obj == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.MutableSet<T>");
                AppMethodBeat.m2505o(122970);
                throw c44941v;
            } else if (!C0014z.m6dr(obj).add(t)) {
                AppMethodBeat.m2505o(122970);
                return false;
            }
        }
        this.size = size() + 1;
        AppMethodBeat.m2505o(122970);
        return true;
    }

    public final void clear() {
        this.data = null;
        this.size = 0;
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.m2504i(122971);
        boolean j;
        Object obj2;
        C44941v c44941v;
        if (size() == 0) {
            AppMethodBeat.m2505o(122971);
            return false;
        } else if (size() == 1) {
            j = C25052j.m39373j(this.data, obj);
            AppMethodBeat.m2505o(122971);
            return j;
        } else if (size() < BNu) {
            obj2 = this.data;
            if (obj2 == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.m2505o(122971);
                throw c44941v;
            }
            j = C36913i.contains((Object[]) obj2, obj);
            AppMethodBeat.m2505o(122971);
            return j;
        } else {
            obj2 = this.data;
            if (obj2 == null) {
                c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.Set<T>");
                AppMethodBeat.m2505o(122971);
                throw c44941v;
            }
            j = ((Set) obj2).contains(obj);
            AppMethodBeat.m2505o(122971);
            return j;
        }
    }

    public final /* bridge */ int size() {
        return this.size;
    }
}
