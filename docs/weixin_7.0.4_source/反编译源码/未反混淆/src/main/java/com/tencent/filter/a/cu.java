package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class cu {

    public static class e extends BaseFilter {
        public e() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86558);
            com.tencent.filter.art.a aVar = new com.tencent.filter.art.a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            aVar.setParameterDic(hashMap);
            setNextFilter(aVar, null);
            ab abVar = new ab();
            abVar.addParam(new o("inputImageTexture2", "weizhidao/xinxian_lf.png", 33986));
            aVar.setNextFilter(abVar, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86558);
        }
    }

    public static class d extends BaseFilter {
        public d() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86557);
            com.tencent.filter.art.a aVar = new com.tencent.filter.art.a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            aVar.setParameterDic(hashMap);
            setNextFilter(aVar, null);
            ab abVar = new ab();
            abVar.addParam(new o("inputImageTexture2", "weizhidao/xican_lf.png", 33986));
            aVar.setNextFilter(abVar, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86557);
        }
    }

    public static class a extends BaseFilter {
        public a() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86554);
            com.tencent.filter.art.a aVar = new com.tencent.filter.art.a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            aVar.setParameterDic(hashMap);
            setNextFilter(aVar, null);
            ab abVar = new ab();
            abVar.addParam(new o("inputImageTexture2", "weizhidao/kafei_lf.png", 33986));
            aVar.setNextFilter(abVar, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86554);
        }
    }

    public static class c extends BaseFilter {
        public c() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86556);
            com.tencent.filter.art.a aVar = new com.tencent.filter.art.a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            aVar.setParameterDic(hashMap);
            setNextFilter(aVar, null);
            ab abVar = new ab();
            abVar.addParam(new o("inputImageTexture2", "weizhidao/tianpin_lf.png", 33986));
            aVar.setNextFilter(abVar, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86556);
        }
    }

    public static class b extends BaseFilter {
        public b() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86555);
            com.tencent.filter.art.a aVar = new com.tencent.filter.art.a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            aVar.setParameterDic(hashMap);
            setNextFilter(aVar, null);
            ab abVar = new ab();
            abVar.addParam(new o("inputImageTexture2", "weizhidao/meiwei_lf.png", 33986));
            aVar.setNextFilter(abVar, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86555);
        }
    }
}
