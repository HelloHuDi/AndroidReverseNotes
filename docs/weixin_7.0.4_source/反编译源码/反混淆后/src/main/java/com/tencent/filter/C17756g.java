package com.tencent.filter;

import com.tencent.filter.C25624m.C0935i;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

/* renamed from: com.tencent.filter.g */
public final class C17756g extends BaseFilter {
    private int type;

    public C17756g() {
        super(GLSLRender.bJB);
        this.type = 0;
        this.type = 0;
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86362);
        if (map.containsKey("effectIndex")) {
            this.type = ((Integer) map.get("effectIndex")).intValue();
        }
        AppMethodBeat.m2505o(86362);
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86363);
        double d = (double) (f / f2);
        this.glsl_programID = GLSLRender.bJP;
        addParam(new C0936o("inputImageTexture3", "flares/flares_curve.png", 33987));
        switch (this.type) {
            case 0:
                addParam(new C0936o("inputImageTexture2", "flares/flares_bokeh_basic_1.jpg", d));
                addParam(new C0935i("flag", 0));
                break;
            case 1:
                addParam(new C0936o("inputImageTexture2", "flares/flares_bokeh_basic_2.jpg", d));
                addParam(new C0935i("flag", 0));
                break;
            case 2:
                addParam(new C0936o("inputImageTexture2", "flares/flares_bokeh_basic_3.jpg", d));
                addParam(new C0935i("flag", 0));
                break;
            case 3:
                addParam(new C0936o("inputImageTexture2", "flares/flares_bokeh_heart_1.jpg", d));
                addParam(new C0935i("flag", 0));
                break;
            case 4:
                addParam(new C0936o("inputImageTexture2", "flares/flares_bokeh_heart_2.jpg", d));
                addParam(new C0935i("flag", 0));
                break;
            case 5:
                addParam(new C0936o("inputImageTexture2", "flares/flares_lens_flares_1.jpg", d));
                addParam(new C0935i("flag", 0));
                break;
            case 6:
                addParam(new C0936o("inputImageTexture2", "flares/flares_lens_flares_2.jpg", d));
                addParam(new C0935i("flag", 0));
                break;
            case 7:
                addParam(new C0936o("inputImageTexture2", "flares/flares_lens_flares_3.jpg", d));
                addParam(new C0935i("flag", 0));
                break;
            case 8:
                addParam(new C0936o("inputImageTexture2", "flares/flares_light_leak_1.jpg", d));
                addParam(new C0935i("flag", 1));
                break;
            case 9:
                addParam(new C0936o("inputImageTexture2", "flares/flares_light_leak_2.jpg", d));
                addParam(new C0935i("flag", 1));
                break;
            default:
                addParam(new C0936o("inputImageTexture2", "flares/flares_light_leak_3.jpg", d));
                addParam(new C0935i("flag", 1));
                break;
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86363);
    }
}
