package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

class fa extends fe {
    private boolean g = true;

    public /* synthetic */ fe b() {
        AppMethodBeat.i(98859);
        fa a = a();
        AppMethodBeat.o(98859);
        return a;
    }

    public /* synthetic */ Object clone() {
        AppMethodBeat.i(98860);
        fa a = a();
        AppMethodBeat.o(98860);
        return a;
    }

    public fa(a... aVarArr) {
        super(aVarArr);
    }

    public fa a() {
        AppMethodBeat.i(98858);
        ArrayList arrayList = this.e;
        int size = this.e.size();
        a[] aVarArr = new a[size];
        for (int i = 0; i < size; i++) {
            aVarArr[i] = (a) ((fd) arrayList.get(i)).clone();
        }
        fa faVar = new fa(aVarArr);
        AppMethodBeat.o(98858);
        return faVar;
    }
}
