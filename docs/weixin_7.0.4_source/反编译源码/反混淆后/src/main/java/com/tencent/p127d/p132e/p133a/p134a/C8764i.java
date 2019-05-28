package com.tencent.p127d.p132e.p133a.p134a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p127d.p132e.p133a.p1165b.C17730g;
import com.tencent.p127d.p132e.p133a.p1165b.C41666f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.d.e.a.a.i */
public final class C8764i {
    final int Adk;
    private final int AtU;
    /* renamed from: Ll */
    Object[] f2442Ll;
    final int mCapacity;
    int mbt = 0;

    public C8764i(int i, int i2, int i3) {
        AppMethodBeat.m2504i(114569);
        this.AtU = i;
        this.f2442Ll = new Object[((int) Math.ceil((double) ((1.0f * ((float) i3)) / ((float) i2))))];
        this.mCapacity = i3;
        this.Adk = i2;
        AppMethodBeat.m2505o(114569);
    }

    /* renamed from: Rd */
    private ArrayList<C41666f> m15593Rd(int i) {
        AppMethodBeat.m2504i(114570);
        ArrayList<C41666f> arrayList = new ArrayList();
        List list = (List) this.f2442Ll[i];
        if (list == null) {
            AppMethodBeat.m2505o(114570);
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            C32112j c32112j = (C32112j) list.get(i2);
            C41666f c41666f = new C41666f();
            c41666f.f16883x = c32112j.values[0];
            c41666f.f16884y = c32112j.values[1];
            c41666f.f16885z = c32112j.values[2];
            c41666f.Auo = c32112j.timestamp;
            arrayList.add(c41666f);
        }
        AppMethodBeat.m2505o(114570);
        return arrayList;
    }

    /* renamed from: fB */
    public final ArrayList<C17730g> mo19826fB(List<C17728k> list) {
        AppMethodBeat.m2504i(114571);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f2442Ll.length; i++) {
            List list2 = (List) this.f2442Ll[i];
            if (!(list2 == null || list2.size() == 0)) {
                int i2;
                C17730g c17730g = new C17730g();
                ArrayList Rd = m15593Rd(i);
                HashMap hashMap = new HashMap();
                if (this.AtU == 1) {
                    i2 = 0;
                } else if (this.AtU == 4) {
                    i2 = 2;
                } else if (this.AtU == 9) {
                    i2 = 4;
                } else {
                    i2 = -1;
                }
                hashMap.put(Integer.valueOf(i2), Rd);
                c17730g.Auq = hashMap;
                C32112j c32112j = (C32112j) list2.get(0);
                if (c32112j != null) {
                    c17730g.Aup = c32112j.timestamp;
                    if (list.size() > i) {
                        C17728k c17728k = (C17728k) list.get(i);
                        if (c17728k != null) {
                            c17730g.AtW = c17728k.AtW;
                            c17730g.AtX = c17728k.AtX;
                            c17730g.AtY = c17728k.AtY;
                            c17730g.AtZ = c17728k.AtZ;
                        }
                    }
                    arrayList.add(c17730g);
                }
            }
        }
        AppMethodBeat.m2505o(114571);
        return arrayList;
    }

    public final Object[] dQB() {
        AppMethodBeat.m2504i(114572);
        Object[] objArr = (Object[]) this.f2442Ll.clone();
        AppMethodBeat.m2505o(114572);
        return objArr;
    }
}
