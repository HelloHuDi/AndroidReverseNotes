package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class n extends AbstractList<String> implements o, RandomAccess {
    public static final o BAf = new n().eiA();
    private final List<Object> list;

    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        AppMethodBeat.i(121563);
        this.list.add(i, (String) obj);
        this.modCount++;
        AppMethodBeat.o(121563);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        AppMethodBeat.i(121564);
        String dO = dO(this.list.set(i, (String) obj));
        AppMethodBeat.o(121564);
        return dO;
    }

    static {
        AppMethodBeat.i(121566);
        AppMethodBeat.o(121566);
    }

    public n() {
        AppMethodBeat.i(121551);
        this.list = new ArrayList();
        AppMethodBeat.o(121551);
    }

    public n(o oVar) {
        AppMethodBeat.i(121552);
        this.list = new ArrayList(oVar.size());
        addAll(oVar);
        AppMethodBeat.o(121552);
    }

    public final int size() {
        AppMethodBeat.i(121553);
        int size = this.list.size();
        AppMethodBeat.o(121553);
        return size;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        AppMethodBeat.i(121554);
        boolean addAll = addAll(size(), collection);
        AppMethodBeat.o(121554);
        return addAll;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        Collection collection2;
        AppMethodBeat.i(121555);
        if (collection2 instanceof o) {
            collection2 = ((o) collection2).eiz();
        }
        boolean addAll = this.list.addAll(i, collection2);
        this.modCount++;
        AppMethodBeat.o(121555);
        return addAll;
    }

    public final void clear() {
        AppMethodBeat.i(121556);
        this.list.clear();
        this.modCount++;
        AppMethodBeat.o(121556);
    }

    public final void e(d dVar) {
        AppMethodBeat.i(121557);
        this.list.add(dVar);
        this.modCount++;
        AppMethodBeat.o(121557);
    }

    public final d UC(int i) {
        Object obj;
        AppMethodBeat.i(121558);
        Object obj2 = this.list.get(i);
        if (obj2 instanceof d) {
            obj = (d) obj2;
        } else if (obj2 instanceof String) {
            obj = d.awc((String) obj2);
        } else {
            obj = d.cx((byte[]) obj2);
        }
        if (obj != obj2) {
            this.list.set(i, obj);
        }
        AppMethodBeat.o(121558);
        return obj;
    }

    private static String dO(Object obj) {
        AppMethodBeat.i(121559);
        String str;
        if (obj instanceof String) {
            str = (String) obj;
            AppMethodBeat.o(121559);
            return str;
        } else if (obj instanceof d) {
            str = ((d) obj).dlY();
            AppMethodBeat.o(121559);
            return str;
        } else {
            str = j.cB((byte[]) obj);
            AppMethodBeat.o(121559);
            return str;
        }
    }

    public final List<?> eiz() {
        AppMethodBeat.i(121560);
        List unmodifiableList = Collections.unmodifiableList(this.list);
        AppMethodBeat.o(121560);
        return unmodifiableList;
    }

    public final o eiA() {
        AppMethodBeat.i(121561);
        x xVar = new x(this);
        AppMethodBeat.o(121561);
        return xVar;
    }

    public final /* synthetic */ Object remove(int i) {
        AppMethodBeat.i(121562);
        Object remove = this.list.remove(i);
        this.modCount++;
        String dO = dO(remove);
        AppMethodBeat.o(121562);
        return dO;
    }

    public final /* synthetic */ Object get(int i) {
        AppMethodBeat.i(121565);
        Object obj = this.list.get(i);
        String dlY;
        if (obj instanceof String) {
            String str = (String) obj;
            AppMethodBeat.o(121565);
            return str;
        } else if (obj instanceof d) {
            d dVar = (d) obj;
            dlY = dVar.dlY();
            if (dVar.ehQ()) {
                this.list.set(i, dlY);
            }
            AppMethodBeat.o(121565);
            return dlY;
        } else {
            byte[] bArr = (byte[]) obj;
            dlY = j.cB(bArr);
            if (j.cA(bArr)) {
                this.list.set(i, dlY);
            }
            AppMethodBeat.o(121565);
            return dlY;
        }
    }
}
