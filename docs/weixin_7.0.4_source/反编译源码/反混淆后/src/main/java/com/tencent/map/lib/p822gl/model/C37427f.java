package com.tencent.map.lib.p822gl.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.map.lib.gl.model.f */
public class C37427f {
    /* renamed from: a */
    private ArrayList<C45136e> f16111a = new ArrayList();

    public C37427f() {
        AppMethodBeat.m2504i(98158);
        AppMethodBeat.m2505o(98158);
    }

    /* renamed from: a */
    public C45136e mo60290a(int i) {
        AppMethodBeat.m2504i(98159);
        C45136e c45136e = (C45136e) this.f16111a.get(i);
        AppMethodBeat.m2505o(98159);
        return c45136e;
    }

    /* renamed from: a */
    public void mo60291a(C45136e c45136e) {
        AppMethodBeat.m2504i(98160);
        this.f16111a.add(c45136e);
        AppMethodBeat.m2505o(98160);
    }

    /* renamed from: a */
    public float[] mo60292a() {
        AppMethodBeat.m2504i(98161);
        float[] fArr = new float[(this.f16111a.size() * 3)];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f16111a.size()) {
                int i3 = i2 * 3;
                fArr[i3 + 0] = ((C45136e) this.f16111a.get(i2)).f17864a;
                fArr[i3 + 1] = ((C45136e) this.f16111a.get(i2)).f17865b;
                fArr[i3 + 2] = ((C45136e) this.f16111a.get(i2)).f17866c;
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(98161);
                return fArr;
            }
        }
    }
}
