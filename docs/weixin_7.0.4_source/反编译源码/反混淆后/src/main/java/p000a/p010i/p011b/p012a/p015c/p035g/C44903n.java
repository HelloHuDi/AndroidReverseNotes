package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: a.i.b.a.c.g.n */
public final class C44903n extends AbstractList<String> implements C37026o, RandomAccess {
    public static final C37026o BAf = new C44903n().eiA();
    private final List<Object> list;

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        AppMethodBeat.m2504i(121563);
        this.list.add(i, (String) obj);
        this.modCount++;
        AppMethodBeat.m2505o(121563);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        AppMethodBeat.m2504i(121564);
        String dO = C44903n.m82120dO(this.list.set(i, (String) obj));
        AppMethodBeat.m2505o(121564);
        return dO;
    }

    static {
        AppMethodBeat.m2504i(121566);
        AppMethodBeat.m2505o(121566);
    }

    public C44903n() {
        AppMethodBeat.m2504i(121551);
        this.list = new ArrayList();
        AppMethodBeat.m2505o(121551);
    }

    public C44903n(C37026o c37026o) {
        AppMethodBeat.m2504i(121552);
        this.list = new ArrayList(c37026o.size());
        addAll(c37026o);
        AppMethodBeat.m2505o(121552);
    }

    public final int size() {
        AppMethodBeat.m2504i(121553);
        int size = this.list.size();
        AppMethodBeat.m2505o(121553);
        return size;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        AppMethodBeat.m2504i(121554);
        boolean addAll = addAll(size(), collection);
        AppMethodBeat.m2505o(121554);
        return addAll;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        Collection collection2;
        AppMethodBeat.m2504i(121555);
        if (collection2 instanceof C37026o) {
            collection2 = ((C37026o) collection2).eiz();
        }
        boolean addAll = this.list.addAll(i, collection2);
        this.modCount++;
        AppMethodBeat.m2505o(121555);
        return addAll;
    }

    public final void clear() {
        AppMethodBeat.m2504i(121556);
        this.list.clear();
        this.modCount++;
        AppMethodBeat.m2505o(121556);
    }

    /* renamed from: e */
    public final void mo31353e(C31710d c31710d) {
        AppMethodBeat.m2504i(121557);
        this.list.add(c31710d);
        this.modCount++;
        AppMethodBeat.m2505o(121557);
    }

    /* renamed from: UC */
    public final C31710d mo31352UC(int i) {
        Object obj;
        AppMethodBeat.m2504i(121558);
        Object obj2 = this.list.get(i);
        if (obj2 instanceof C31710d) {
            obj = (C31710d) obj2;
        } else if (obj2 instanceof String) {
            obj = C31710d.awc((String) obj2);
        } else {
            obj = C31710d.m51312cx((byte[]) obj2);
        }
        if (obj != obj2) {
            this.list.set(i, obj);
        }
        AppMethodBeat.m2505o(121558);
        return obj;
    }

    /* renamed from: dO */
    private static String m82120dO(Object obj) {
        AppMethodBeat.m2504i(121559);
        String str;
        if (obj instanceof String) {
            str = (String) obj;
            AppMethodBeat.m2505o(121559);
            return str;
        } else if (obj instanceof C31710d) {
            str = ((C31710d) obj).dlY();
            AppMethodBeat.m2505o(121559);
            return str;
        } else {
            str = C8181j.m14443cB((byte[]) obj);
            AppMethodBeat.m2505o(121559);
            return str;
        }
    }

    public final List<?> eiz() {
        AppMethodBeat.m2504i(121560);
        List unmodifiableList = Collections.unmodifiableList(this.list);
        AppMethodBeat.m2505o(121560);
        return unmodifiableList;
    }

    public final C37026o eiA() {
        AppMethodBeat.m2504i(121561);
        C17271x c17271x = new C17271x(this);
        AppMethodBeat.m2505o(121561);
        return c17271x;
    }

    public final /* synthetic */ Object remove(int i) {
        AppMethodBeat.m2504i(121562);
        Object remove = this.list.remove(i);
        this.modCount++;
        String dO = C44903n.m82120dO(remove);
        AppMethodBeat.m2505o(121562);
        return dO;
    }

    public final /* synthetic */ Object get(int i) {
        AppMethodBeat.m2504i(121565);
        Object obj = this.list.get(i);
        String dlY;
        if (obj instanceof String) {
            String str = (String) obj;
            AppMethodBeat.m2505o(121565);
            return str;
        } else if (obj instanceof C31710d) {
            C31710d c31710d = (C31710d) obj;
            dlY = c31710d.dlY();
            if (c31710d.ehQ()) {
                this.list.set(i, dlY);
            }
            AppMethodBeat.m2505o(121565);
            return dlY;
        } else {
            byte[] bArr = (byte[]) obj;
            dlY = C8181j.m14443cB(bArr);
            if (C8181j.m14442cA(bArr)) {
                this.list.set(i, dlY);
            }
            AppMethodBeat.m2505o(121565);
            return dlY;
        }
    }
}
