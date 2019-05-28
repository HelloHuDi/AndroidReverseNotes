package com.tencent.map.lib.gl.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class f {
    private ArrayList<e> a = new ArrayList();

    public f() {
        AppMethodBeat.i(98158);
        AppMethodBeat.o(98158);
    }

    public e a(int i) {
        AppMethodBeat.i(98159);
        e eVar = (e) this.a.get(i);
        AppMethodBeat.o(98159);
        return eVar;
    }

    public void a(e eVar) {
        AppMethodBeat.i(98160);
        this.a.add(eVar);
        AppMethodBeat.o(98160);
    }

    public float[] a() {
        AppMethodBeat.i(98161);
        float[] fArr = new float[(this.a.size() * 3)];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                int i3 = i2 * 3;
                fArr[i3 + 0] = ((e) this.a.get(i2)).a;
                fArr[i3 + 1] = ((e) this.a.get(i2)).b;
                fArr[i3 + 2] = ((e) this.a.get(i2)).c;
                i = i2 + 1;
            } else {
                AppMethodBeat.o(98161);
                return fArr;
            }
        }
    }
}
