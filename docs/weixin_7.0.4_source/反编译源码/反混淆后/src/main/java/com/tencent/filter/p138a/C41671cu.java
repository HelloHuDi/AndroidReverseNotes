package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.C25623a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

/* renamed from: com.tencent.filter.a.cu */
public final class C41671cu {

    /* renamed from: com.tencent.filter.a.cu$e */
    public static class C0932e extends BaseFilter {
        public C0932e() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.m2504i(86558);
            C25623a c25623a = new C25623a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            c25623a.setParameterDic(hashMap);
            setNextFilter(c25623a, null);
            C44654ab c44654ab = new C44654ab();
            c44654ab.addParam(new C0936o("inputImageTexture2", "weizhidao/xinxian_lf.png", 33986));
            c25623a.setNextFilter(c44654ab, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86558);
        }
    }

    /* renamed from: com.tencent.filter.a.cu$d */
    public static class C17745d extends BaseFilter {
        public C17745d() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.m2504i(86557);
            C25623a c25623a = new C25623a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            c25623a.setParameterDic(hashMap);
            setNextFilter(c25623a, null);
            C44654ab c44654ab = new C44654ab();
            c44654ab.addParam(new C0936o("inputImageTexture2", "weizhidao/xican_lf.png", 33986));
            c25623a.setNextFilter(c44654ab, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86557);
        }
    }

    /* renamed from: com.tencent.filter.a.cu$a */
    public static class C32126a extends BaseFilter {
        public C32126a() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.m2504i(86554);
            C25623a c25623a = new C25623a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            c25623a.setParameterDic(hashMap);
            setNextFilter(c25623a, null);
            C44654ab c44654ab = new C44654ab();
            c44654ab.addParam(new C0936o("inputImageTexture2", "weizhidao/kafei_lf.png", 33986));
            c25623a.setNextFilter(c44654ab, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86554);
        }
    }

    /* renamed from: com.tencent.filter.a.cu$c */
    public static class C32127c extends BaseFilter {
        public C32127c() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.m2504i(86556);
            C25623a c25623a = new C25623a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            c25623a.setParameterDic(hashMap);
            setNextFilter(c25623a, null);
            C44654ab c44654ab = new C44654ab();
            c44654ab.addParam(new C0936o("inputImageTexture2", "weizhidao/tianpin_lf.png", 33986));
            c25623a.setNextFilter(c44654ab, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86556);
        }
    }

    /* renamed from: com.tencent.filter.a.cu$b */
    public static class C37334b extends BaseFilter {
        public C37334b() {
            super(GLSLRender.bJB);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.m2504i(86555);
            C25623a c25623a = new C25623a(GLSLRender.bJB);
            HashMap hashMap = new HashMap();
            hashMap.put("intensity", Float.valueOf(0.65f));
            c25623a.setParameterDic(hashMap);
            setNextFilter(c25623a, null);
            C44654ab c44654ab = new C44654ab();
            c44654ab.addParam(new C0936o("inputImageTexture2", "weizhidao/meiwei_lf.png", 33986));
            c25623a.setNextFilter(c44654ab, null);
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86555);
        }
    }
}
