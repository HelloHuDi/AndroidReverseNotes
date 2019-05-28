package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.basemap.data.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lp {
    private final String a = "_night";
    private int b;
    private int c;
    private List<lm> d;

    public lp(int i, int i2, List<lm> list) {
        AppMethodBeat.i(100465);
        this.b = i;
        this.c = i2;
        this.d = list;
        Collections.sort(list, new Comparator<lm>() {
            public /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(100464);
                int a = a((lm) obj, (lm) obj2);
                AppMethodBeat.o(100464);
                return a;
            }

            public int a(lm lmVar, lm lmVar2) {
                AppMethodBeat.i(100463);
                int a = lmVar2.a() - lmVar.a();
                AppMethodBeat.o(100463);
                return a;
            }
        });
        AppMethodBeat.o(100465);
    }

    public String[] a(a aVar, int i) {
        AppMethodBeat.i(100466);
        for (lm lmVar : this.d) {
            if (lmVar.a(aVar)) {
                String[] strArr;
                if ((i == 13 || i == 10) && lmVar.d() != null && lmVar.d().length() > 0) {
                    strArr = new String[]{lmVar.b() + "_night", lmVar.d()};
                    AppMethodBeat.o(100466);
                    return strArr;
                }
                strArr = new String[]{lmVar.b(), lmVar.c()};
                AppMethodBeat.o(100466);
                return strArr;
            }
        }
        AppMethodBeat.o(100466);
        return null;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }
}
