package com.tencent.d.e.a.a;

import com.tencent.d.e.a.b.f;
import com.tencent.d.e.a.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class i {
    final int Adk;
    private final int AtU;
    Object[] Ll;
    final int mCapacity;
    int mbt = 0;

    public i(int i, int i2, int i3) {
        AppMethodBeat.i(114569);
        this.AtU = i;
        this.Ll = new Object[((int) Math.ceil((double) ((1.0f * ((float) i3)) / ((float) i2))))];
        this.mCapacity = i3;
        this.Adk = i2;
        AppMethodBeat.o(114569);
    }

    private ArrayList<f> Rd(int i) {
        AppMethodBeat.i(114570);
        ArrayList<f> arrayList = new ArrayList();
        List list = (List) this.Ll[i];
        if (list == null) {
            AppMethodBeat.o(114570);
            return arrayList;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            j jVar = (j) list.get(i2);
            f fVar = new f();
            fVar.x = jVar.values[0];
            fVar.y = jVar.values[1];
            fVar.z = jVar.values[2];
            fVar.Auo = jVar.timestamp;
            arrayList.add(fVar);
        }
        AppMethodBeat.o(114570);
        return arrayList;
    }

    public final ArrayList<g> fB(List<k> list) {
        AppMethodBeat.i(114571);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.Ll.length; i++) {
            List list2 = (List) this.Ll[i];
            if (!(list2 == null || list2.size() == 0)) {
                int i2;
                g gVar = new g();
                ArrayList Rd = Rd(i);
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
                gVar.Auq = hashMap;
                j jVar = (j) list2.get(0);
                if (jVar != null) {
                    gVar.Aup = jVar.timestamp;
                    if (list.size() > i) {
                        k kVar = (k) list.get(i);
                        if (kVar != null) {
                            gVar.AtW = kVar.AtW;
                            gVar.AtX = kVar.AtX;
                            gVar.AtY = kVar.AtY;
                            gVar.AtZ = kVar.AtZ;
                        }
                    }
                    arrayList.add(gVar);
                }
            }
        }
        AppMethodBeat.o(114571);
        return arrayList;
    }

    public final Object[] dQB() {
        AppMethodBeat.i(114572);
        Object[] objArr = (Object[]) this.Ll.clone();
        AppMethodBeat.o(114572);
        return objArr;
    }
}
