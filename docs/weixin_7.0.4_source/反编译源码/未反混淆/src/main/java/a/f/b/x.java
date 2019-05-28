package a.f.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class x {
    public final ArrayList<Object> ckx;

    public x(int i) {
        AppMethodBeat.i(55893);
        this.ckx = new ArrayList(i);
        AppMethodBeat.o(55893);
    }

    /* renamed from: do */
    public final void m15do(Object obj) {
        AppMethodBeat.i(55894);
        if (obj == null) {
            AppMethodBeat.o(55894);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                this.ckx.ensureCapacity(this.ckx.size() + objArr.length);
                for (Object add : objArr) {
                    this.ckx.add(add);
                }
            }
            AppMethodBeat.o(55894);
        } else {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            AppMethodBeat.o(55894);
            throw unsupportedOperationException;
        }
    }

    public final void add(Object obj) {
        AppMethodBeat.i(55895);
        this.ckx.add(obj);
        AppMethodBeat.o(55895);
    }

    public final Object[] toArray(Object[] objArr) {
        AppMethodBeat.i(55896);
        Object[] toArray = this.ckx.toArray(objArr);
        AppMethodBeat.o(55896);
        return toArray;
    }
}
