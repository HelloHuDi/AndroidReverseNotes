package com.tencent.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.a.bk;
import com.tencent.filter.art.BokehFilter;
import com.tencent.filter.art.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.e;

public final class a extends e {
    public static BaseFilter createFilter(int i) {
        BaseFilter bokehFilter;
        AppMethodBeat.i(86273);
        switch (i) {
            case 82:
                bokehFilter = new BokehFilter();
                break;
            case 109:
                bokehFilter = new c();
                break;
            case 126:
                bokehFilter = new com.microrapid.opencv.a();
                break;
            case 203:
                bokehFilter = new com.microrapid.lensFlare.a();
                break;
            case 218:
                bokehFilter = new bk();
                break;
            case 231:
                bokehFilter = new com.tencent.a.a.a();
                break;
            default:
                bokehFilter = e.createFilter(i);
                break;
        }
        AppMethodBeat.o(86273);
        return bokehFilter;
    }
}
