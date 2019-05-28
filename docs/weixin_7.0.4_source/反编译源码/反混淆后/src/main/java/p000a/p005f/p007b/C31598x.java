package p000a.p005f.p007b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: a.f.b.x */
public final class C31598x {
    public final ArrayList<Object> ckx;

    public C31598x(int i) {
        AppMethodBeat.m2504i(55893);
        this.ckx = new ArrayList(i);
        AppMethodBeat.m2505o(55893);
    }

    /* renamed from: do */
    public final void mo51593do(Object obj) {
        AppMethodBeat.m2504i(55894);
        if (obj == null) {
            AppMethodBeat.m2505o(55894);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                this.ckx.ensureCapacity(this.ckx.size() + objArr.length);
                for (Object add : objArr) {
                    this.ckx.add(add);
                }
            }
            AppMethodBeat.m2505o(55894);
        } else {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            AppMethodBeat.m2505o(55894);
            throw unsupportedOperationException;
        }
    }

    public final void add(Object obj) {
        AppMethodBeat.m2504i(55895);
        this.ckx.add(obj);
        AppMethodBeat.m2505o(55895);
    }

    public final Object[] toArray(Object[] objArr) {
        AppMethodBeat.m2504i(55896);
        Object[] toArray = this.ckx.toArray(objArr);
        AppMethodBeat.m2505o(55896);
        return toArray;
    }
}
