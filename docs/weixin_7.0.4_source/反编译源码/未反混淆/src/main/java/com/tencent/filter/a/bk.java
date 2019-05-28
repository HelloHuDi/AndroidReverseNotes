package com.tencent.filter.a;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.c;
import com.tencent.filter.l;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class bk extends BaseFilter {
    public bk() {
        super(GLSLRender.bJB);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86518);
        if (z) {
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86518);
            return;
        }
        Object obj;
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        float min = Math.min(f, f2) / 4.0f;
        float f5 = 60.0f + min;
        c cVar = new c();
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
        cVar.setParameterDic(hashMap);
        hashMap.clear();
        cVar.ApplyGLSLFilter(z, f, f2);
        setNextFilter(cVar, null);
        BaseFilter lastFilter = cVar.getLastFilter();
        int theFilterIndex = getTheFilterIndex(lastFilter);
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bJB);
        baseFilter.scaleFact = Math.min(100.0f / Math.min(f2, f), 1.0f);
        lastFilter.setNextFilter(baseFilter, null);
        l lVar = new l();
        baseFilter.setNextFilter(lVar, new int[]{theFilterIndex + (this.srcTextureIndex + 1)});
        BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bLI);
        baseFilter2.addParam(new f("shadows", 0.45f));
        baseFilter2.addParam(new f("highlights", 0.0f));
        lVar.setNextFilter(baseFilter2, null);
        lastFilter = new BaseFilter(GLSLRender.bMy, GLSLRender.bLJ);
        lastFilter.addParam(new f("sharpness", 0.2f));
        lastFilter.addParam(new f("inputH", 1.0f));
        lastFilter.addParam(new f("inputS", 1.36f));
        lastFilter.addParam(new f("inputV", 1.1f));
        lastFilter.addParam(new f("imageWidthFactor", 1.0f / f));
        lastFilter.addParam(new f("imageHeightFactor", 1.0f / f2));
        baseFilter2.setNextFilter(lastFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bJO);
        baseFilter2.addParam(new f("contrast", 1.32f));
        baseFilter2.addParam(new f("saturation", 0.758f));
        baseFilter2.addParam(new f("brightness", 1.0f));
        lastFilter.setNextFilter(baseFilter2, null);
        lastFilter = new BaseFilter(GLSLRender.bKG);
        float[] fArr = new float[]{0.0627451f, 0.0f, -0.0627451f};
        float[] fArr2 = new float[]{0.0f, 0.0f, 0.0f};
        lastFilter.addParam(new g("shadowsShift", new float[]{0.0627451f, 0.0f, -0.0627451f}));
        lastFilter.addParam(new g("midtonesShift", fArr));
        lastFilter.addParam(new g("highlightsShift", fArr2));
        lastFilter.addParam(new i("preserveLuminosity", 1));
        baseFilter2.setNextFilter(lastFilter, null);
        baseFilter2 = new BaseFilter(GLSLRender.bKE);
        baseFilter2.addParam(new f("scaleC", -0.2715f));
        baseFilter2.addParam(new f("scaleT", 0.0f));
        lastFilter.setNextFilter(baseFilter2, null);
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86518);
    }
}
