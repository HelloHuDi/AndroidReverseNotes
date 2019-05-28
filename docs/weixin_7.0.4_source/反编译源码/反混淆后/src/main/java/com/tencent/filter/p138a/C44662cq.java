package com.tencent.filter.p138a;

import android.graphics.Bitmap;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C25628k;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.C25623a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C44569b;
import java.util.HashMap;

/* renamed from: com.tencent.filter.a.cq */
public final class C44662cq extends BaseFilter {
    public C44662cq() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86549);
        C25623a c25623a = new C25623a(GLSLRender.bJB);
        HashMap hashMap = new HashMap();
        hashMap.put("intensity", Float.valueOf(0.65f));
        c25623a.setParameterDic(hashMap);
        setNextFilter(c25623a, null);
        C44654ab c44654ab = new C44654ab();
        boolean z2 = C44569b.AIE;
        C44569b.AIE = true;
        Bitmap vt = C44569b.m80951vt("filter/egWeizhidao/eftMeiwei/meiwei_lf.png");
        C44569b.AIE = z2;
        c44654ab.addParam(new C25628k("inputImageTexture2", vt, 33986, true));
        c25623a.setNextFilter(c44654ab, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86549);
    }
}
