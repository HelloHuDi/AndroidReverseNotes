package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.map.lib.basemap.data.C8885a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lp */
public class C46802lp {
    /* renamed from: a */
    private final String f18259a = "_night";
    /* renamed from: b */
    private int f18260b;
    /* renamed from: c */
    private int f18261c;
    /* renamed from: d */
    private List<C44536lm> f18262d;

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.lp$1 */
    class C59061 implements Comparator<C44536lm> {
        C59061() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(100464);
            int a = mo12536a((C44536lm) obj, (C44536lm) obj2);
            AppMethodBeat.m2505o(100464);
            return a;
        }

        /* renamed from: a */
        public int mo12536a(C44536lm c44536lm, C44536lm c44536lm2) {
            AppMethodBeat.m2504i(100463);
            int a = c44536lm2.mo70926a() - c44536lm.mo70926a();
            AppMethodBeat.m2505o(100463);
            return a;
        }
    }

    public C46802lp(int i, int i2, List<C44536lm> list) {
        AppMethodBeat.m2504i(100465);
        this.f18260b = i;
        this.f18261c = i2;
        this.f18262d = list;
        Collections.sort(list, new C59061());
        AppMethodBeat.m2505o(100465);
    }

    /* renamed from: a */
    public String[] mo75522a(C8885a c8885a, int i) {
        AppMethodBeat.m2504i(100466);
        for (C44536lm c44536lm : this.f18262d) {
            if (c44536lm.mo70927a(c8885a)) {
                String[] strArr;
                if ((i == 13 || i == 10) && c44536lm.mo70930d() != null && c44536lm.mo70930d().length() > 0) {
                    strArr = new String[]{c44536lm.mo70928b() + "_night", c44536lm.mo70930d()};
                    AppMethodBeat.m2505o(100466);
                    return strArr;
                }
                strArr = new String[]{c44536lm.mo70928b(), c44536lm.mo70929c()};
                AppMethodBeat.m2505o(100466);
                return strArr;
            }
        }
        AppMethodBeat.m2505o(100466);
        return null;
    }

    /* renamed from: a */
    public int mo75521a() {
        return this.f18260b;
    }

    /* renamed from: b */
    public int mo75523b() {
        return this.f18261c;
    }
}
