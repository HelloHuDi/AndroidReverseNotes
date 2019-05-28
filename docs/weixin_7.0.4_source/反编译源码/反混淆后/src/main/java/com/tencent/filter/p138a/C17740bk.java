package com.tencent.filter.p138a;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.C17757l;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0934g;
import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.C44672c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

/* renamed from: com.tencent.filter.a.bk */
public final class C17740bk extends BaseFilter {
    public C17740bk() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86518);
        if (z) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86518);
            return;
        }
        Object obj;
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        float min = Math.min(f, f2) / 4.0f;
        float f5 = 60.0f + min;
        C44672c c44672c = new C44672c();
        HashMap hashMap = new HashMap();
        hashMap.put("bokehType", Integer.valueOf(1));
        hashMap.put("blurRiness", Float.valueOf(0.4f));
        hashMap.put("innerRadius", Float.valueOf(min));
        hashMap.put("outerRadius", Float.valueOf(f5));
        hashMap.put("tx", Float.valueOf(f3));
        hashMap.put("ty", Float.valueOf(f4));
        hashMap.put("theta", Float.valueOf(0.0f));
        hashMap.put("eclipseA", Float.valueOf(1.5f));
        hashMap.put("MethodType", Integer.valueOf(1));
        hashMap.put("lumi_threshold", Float.valueOf(0.0f));
        hashMap.put("lumi_weight", Float.valueOf(0.0f));
        hashMap.put("defaultWidth", Float.valueOf(400.0f));
        String glGetString = GLES20.glGetString(7937);
        if (glGetString == null) {
            obj = null;
        } else if (glGetString.indexOf("NVIDIA Tegra") != -1) {
            obj = null;
        } else if (glGetString.indexOf("VideoCore IV HW") != -1) {
            obj = null;
        } else if (glGetString.indexOf("PowerVR SGX 544MP") != -1) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            hashMap.put("bokehmode", Integer.valueOf(1));
        } else {
            hashMap.put("bokehmode", Integer.valueOf(2));
        }
        c44672c.setParameterDic(hashMap);
        hashMap.clear();
        c44672c.ApplyGLSLFilter(z, f, f2);
        setNextFilter(c44672c, null);
        BaseFilter lastFilter = c44672c.getLastFilter();
        int theFilterIndex = getTheFilterIndex(lastFilter);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJB);
        baseFilter.scaleFact = Math.min(100.0f / Math.min(f2, f), 1.0f);
        lastFilter.setNextFilter(baseFilter, null);
        C17757l c17757l = new C17757l();
        baseFilter.setNextFilter(c17757l, new int[]{theFilterIndex + (this.srcTextureIndex + 1)});
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLI);
        baseFilter2.addParam(new C0933f("shadows", 0.45f));
        baseFilter2.addParam(new C0933f("highlights", 0.0f));
        c17757l.setNextFilter(baseFilter2, null);
        lastFilter = new BaseFilter(GLSLRender.bMy, GLSLRender.bLJ);
        lastFilter.addParam(new C0933f("sharpness", 0.2f));
        lastFilter.addParam(new C0933f("inputH", 1.0f));
        lastFilter.addParam(new C0933f("inputS", 1.36f));
        lastFilter.addParam(new C0933f("inputV", 1.1f));
        lastFilter.addParam(new C0933f("imageWidthFactor", 1.0f / f));
        lastFilter.addParam(new C0933f("imageHeightFactor", 1.0f / f2));
        baseFilter2.setNextFilter(lastFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bJO);
        baseFilter2.addParam(new C0933f("contrast", 1.32f));
        baseFilter2.addParam(new C0933f("saturation", 0.758f));
        baseFilter2.addParam(new C0933f("brightness", 1.0f));
        lastFilter.setNextFilter(baseFilter2, null);
        lastFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0627451f, 0.0f, -0.0627451f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        lastFilter.addParam(new C0934g("shadowsShift", new float[]{0.0627451f, 0.0f, -0.0627451f}));
        lastFilter.addParam(new C0934g("midtonesShift", fArr));
        lastFilter.addParam(new C0934g("highlightsShift", fArr2));
        lastFilter.addParam(new C0935i("preserveLuminosity", 1));
        baseFilter2.setNextFilter(lastFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKE);
        baseFilter2.addParam(new C0933f("scaleC", -0.2715f));
        baseFilter2.addParam(new C0933f("scaleT", 0.0f));
        lastFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86518);
    }
}
