package com.tencent.p1137a;

import com.microrapid.lensFlare.C8749a;
import com.microrapid.opencv.C44653a;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.art.BokehFilter;
import com.tencent.filter.art.C44672c;
import com.tencent.filter.p138a.C17740bk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p1137a.p1449a.C32104a;
import com.tencent.view.C16374e;

/* renamed from: com.tencent.a.a */
public final class C16516a extends C16374e {
    public static BaseFilter createFilter(int i) {
        BaseFilter bokehFilter;
        AppMethodBeat.m2504i(86273);
        switch (i) {
            case 82:
                bokehFilter = new BokehFilter();
                break;
            case 109:
                bokehFilter = new C44672c();
                break;
            case 126:
                bokehFilter = new C44653a();
                break;
            case 203:
                bokehFilter = new C8749a();
                break;
            case 218:
                bokehFilter = new C17740bk();
                break;
            case 231:
                bokehFilter = new C32104a();
                break;
            default:
                bokehFilter = C16374e.createFilter(i);
                break;
        }
        AppMethodBeat.m2505o(86273);
        return bokehFilter;
    }
}
