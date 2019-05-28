package com.tencent.filter.a;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.a;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;
import java.util.HashMap;

public final class cq extends BaseFilter {
    public cq() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86549);
        a aVar = new a(GLSLRender.bJB);
        HashMap hashMap = new HashMap();
        hashMap.put("intensity", Float.valueOf(0.65f));
        aVar.setParameterDic(hashMap);
        setNextFilter(aVar, null);
        ab abVar = new ab();
        boolean z2 = b.AIE;
        b.AIE = true;
        Bitmap vt = b.vt("filter/egWeizhidao/eftMeiwei/meiwei_lf.png");
        b.AIE = z2;
        abVar.addParam(new k("inputImageTexture2", vt, 33986, true));
        aVar.setNextFilter(abVar, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86549);
    }
}
