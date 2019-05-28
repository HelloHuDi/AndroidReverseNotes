package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C25624m.C0933f;
import com.tencent.filter.C25624m.C0936o;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.view.C41106g;
import java.util.Map;

/* renamed from: com.tencent.filter.a.u */
public final class C44669u extends BaseFilter {
    private int bNT = 1;
    private int quality = 2;

    /* renamed from: com.tencent.filter.a.u$b */
    public class C25621b extends BaseFilter {
        int bNT = 0;
        private final String[] bNV = new String[]{"error.file", "yijian_ziran", "yijian_hongrun", "yijian_baixi", "yijian_tianmei", "yijian_menghuan", "yijian_yangguang", "yijian_rounen"};
        private final float[] bNW = new float[]{1.0f, 1.0f, 0.95f, 0.9f};
        int quality = 2;

        public C25621b(int i, int i2) {
            super(GLSLRender.bLu);
            AppMethodBeat.m2504i(86467);
            this.bNT = i;
            this.quality = i2;
            new StringBuilder("value = ").append(this.bNT);
            AppMethodBeat.m2505o(86467);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.m2504i(86468);
            new StringBuilder("value = ").append(this.bNT);
            String str = "yijian/" + this.bNV[this.bNT] + "_" + this.quality + FileUtils.PIC_POSTFIX_JPEG;
            float f3 = this.bNW[this.quality];
            if (this.bNT == 5) {
                if (this.quality == 1) {
                    f3 = 0.912f;
                } else if (this.quality == 2) {
                    f3 = 0.95f;
                } else if (this.quality == 3) {
                    f3 = 0.88f;
                }
            }
            if (this.bNT == 4) {
                if (this.quality == 3) {
                    f3 = 1.1f;
                } else if (this.quality == 2) {
                    f3 = 1.0f;
                }
            }
            this.glsl_programID = GLSLRender.bLu;
            addParam(new C0936o("inputImageTexture2", str, 33986));
            addParam(new C0933f("quality", f3));
            addParam(new C0933f("add_red", 0.0f));
            addParam(new C0933f("red_m", 0.0f));
            addParam(new C0933f("green_m", 0.0f));
            addParam(new C0933f("blue_m", 0.0f));
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86468);
        }
    }

    /* renamed from: com.tencent.filter.a.u$a */
    public class C44668a extends BaseFilter {
        float bMG = 1.0f;
        private float bNa = 0.0f;
        private int paramTEXTRUEID = 0;

        public C44668a(int i, float f) {
            super(GLSLRender.bJE);
            AppMethodBeat.m2504i(86462);
            this.bMG = f;
            switch (i) {
                case 1:
                    this.bNa = 0.62f;
                    break;
                case 2:
                    this.bNa = 0.67f;
                    break;
                case 3:
                    this.bNa = 1.0f;
                    break;
            }
            this.bNa *= 2.0f;
            AppMethodBeat.m2505o(86462);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.m2504i(86463);
            this.paramTEXTRUEID = C41106g.dSO();
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.m2505o(86463);
        }

        public final void beforeRender(int i, int i2, int i3) {
            AppMethodBeat.m2504i(86464);
            QImage aL = C41106g.m71542aL(i, i2, i3);
            FilterAlgorithm.nativeFastBlur(aL, this.bNa * this.bMG);
            GLSLRender.nativeTextImage(aL, this.paramTEXTRUEID);
            aL.Dispose();
            AppMethodBeat.m2505o(86464);
        }

        public final boolean renderTexture(int i, int i2, int i3) {
            AppMethodBeat.m2504i(86465);
            boolean renderTexture = super.renderTexture(this.paramTEXTRUEID, i2, i3);
            AppMethodBeat.m2505o(86465);
            return renderTexture;
        }

        public final void ClearGLSL() {
            AppMethodBeat.m2504i(86466);
            C41106g.m71538Sk(this.paramTEXTRUEID);
            super.ClearGLSL();
            AppMethodBeat.m2505o(86466);
        }
    }

    public C44669u() {
        super(GLSLRender.bJB);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.m2504i(86469);
        if (map.containsKey("effectIndex")) {
            this.bNT = ((Integer) map.get("effectIndex")).intValue();
        }
        if (map.containsKey("filter_type")) {
            this.bNT = ((Integer) map.get("filter_type")).intValue();
        }
        if (map.containsKey("filter_quality")) {
            this.quality = ((Integer) map.get("filter_quality")).intValue();
        }
        AppMethodBeat.m2505o(86469);
    }

    public final void setEffectIndex(int i) {
        this.bNT = i;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.m2504i(86470);
        new StringBuilder("value = ").append(this.bNT);
        this.glsl_programID = GLSLRender.bJB;
        BaseFilter baseFilter = new BaseFilter(GLSLRender.bLw);
        setNextFilter(baseFilter, null);
        int i = this.bNT;
        int i2 = this.quality;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        if (i == 1) {
            d = 0.09d;
            d2 = 0.09d;
            d7 = 0.15d;
        }
        if (i == 3) {
            d5 = -0.06d;
            d7 = 0.07d;
        }
        if (i == 4) {
            if (i2 == 1) {
                d2 = 0.455d;
                d3 = 0.17d;
                d4 = 0.177d;
                d6 = 0.2d;
            } else if (i2 == 2) {
                d2 = 0.62d;
                d3 = 0.375d;
                d4 = 0.07d;
                d6 = 0.125d;
                d7 = 0.26d;
            } else if (i2 == 3) {
                d2 = 0.824d;
                d3 = 0.461d;
                d4 = 0.152d;
                d6 = 0.2d;
            }
        }
        if (i == 2) {
            if (i2 == 1) {
                d = 0.121d;
                d2 = 0.354d;
            } else if (i2 == 2) {
                d = 0.32d;
                d2 = 0.35d;
                d6 = -0.1d;
            } else if (i2 == 3) {
                d = 0.366d;
                d2 = 0.554d;
            }
        }
        if (i == 5) {
            d5 = -0.08d;
        }
        if (i == 7) {
            d2 = 0.1d;
            d5 = -0.08d;
            d7 = 0.15d;
        }
        if (i == 6) {
            d5 = -0.12d;
            d7 = 0.16d;
        }
        baseFilter.addParam(new C0933f("percent1", (float) d));
        baseFilter.addParam(new C0933f("percent2", (float) d2));
        baseFilter.addParam(new C0933f("percent3", (float) d3));
        baseFilter.addParam(new C0933f("percent4", (float) d4));
        baseFilter.addParam(new C0933f("percent5", (float) d5));
        baseFilter.addParam(new C0933f("percent6", (float) d6));
        baseFilter.addParam(new C0933f("percent7", (float) d7));
        C25621b c25621b = new C25621b(this.bNT, this.quality);
        baseFilter.setNextFilter(c25621b, null);
        if (this.bNT == 5) {
            float min = Math.min(f2, f);
            BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bJB);
            baseFilter2.scaleFact = Math.min(400.0f / min, 1.0f);
            c25621b.setNextFilter(baseFilter2, null);
            C44668a c44668a = new C44668a(this.quality, baseFilter2.scaleFact);
            baseFilter2.setNextFilter(c44668a, null);
            baseFilter2 = new BaseFilter(GLSLRender.bJE);
            float f3 = 0.0f;
            switch (this.quality) {
                case 1:
                    f3 = 0.89f;
                    break;
                case 2:
                    f3 = 0.78f;
                    break;
                case 3:
                    f3 = 0.573f;
                    break;
            }
            c44668a.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex + 3});
            c44668a.addParam(new C0933f("filterAdjustParam", 1.0f - f3));
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.m2505o(86470);
    }
}
