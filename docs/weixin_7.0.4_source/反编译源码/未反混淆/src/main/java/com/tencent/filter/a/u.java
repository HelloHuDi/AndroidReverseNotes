package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.m.f;
import com.tencent.filter.m.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.view.g;
import java.util.Map;

public final class u extends BaseFilter {
    private int bNT = 1;
    private int quality = 2;

    public class b extends BaseFilter {
        int bNT = 0;
        private final String[] bNV = new String[]{"error.file", "yijian_ziran", "yijian_hongrun", "yijian_baixi", "yijian_tianmei", "yijian_menghuan", "yijian_yangguang", "yijian_rounen"};
        private final float[] bNW = new float[]{1.0f, 1.0f, 0.95f, 0.9f};
        int quality = 2;

        public b(int i, int i2) {
            super(GLSLRender.bLu);
            AppMethodBeat.i(86467);
            this.bNT = i;
            this.quality = i2;
            new StringBuilder("value = ").append(this.bNT);
            AppMethodBeat.o(86467);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86468);
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
            addParam(new o("inputImageTexture2", str, 33986));
            addParam(new f("quality", f3));
            addParam(new f("add_red", 0.0f));
            addParam(new f("red_m", 0.0f));
            addParam(new f("green_m", 0.0f));
            addParam(new f("blue_m", 0.0f));
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86468);
        }
    }

    public class a extends BaseFilter {
        float bMG = 1.0f;
        private float bNa = 0.0f;
        private int paramTEXTRUEID = 0;

        public a(int i, float f) {
            super(GLSLRender.bJE);
            AppMethodBeat.i(86462);
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
            AppMethodBeat.o(86462);
        }

        public final void ApplyGLSLFilter(boolean z, float f, float f2) {
            AppMethodBeat.i(86463);
            this.paramTEXTRUEID = g.dSO();
            super.ApplyGLSLFilter(z, f, f2);
            AppMethodBeat.o(86463);
        }

        public final void beforeRender(int i, int i2, int i3) {
            AppMethodBeat.i(86464);
            QImage aL = g.aL(i, i2, i3);
            FilterAlgorithm.nativeFastBlur(aL, this.bNa * this.bMG);
            GLSLRender.nativeTextImage(aL, this.paramTEXTRUEID);
            aL.Dispose();
            AppMethodBeat.o(86464);
        }

        public final boolean renderTexture(int i, int i2, int i3) {
            AppMethodBeat.i(86465);
            boolean renderTexture = super.renderTexture(this.paramTEXTRUEID, i2, i3);
            AppMethodBeat.o(86465);
            return renderTexture;
        }

        public final void ClearGLSL() {
            AppMethodBeat.i(86466);
            g.Sk(this.paramTEXTRUEID);
            super.ClearGLSL();
            AppMethodBeat.o(86466);
        }
    }

    public u() {
        super(GLSLRender.bJB);
    }

    public final void setParameterDic(Map<String, Object> map) {
        AppMethodBeat.i(86469);
        if (map.containsKey("effectIndex")) {
            this.bNT = ((Integer) map.get("effectIndex")).intValue();
        }
        if (map.containsKey("filter_type")) {
            this.bNT = ((Integer) map.get("filter_type")).intValue();
        }
        if (map.containsKey("filter_quality")) {
            this.quality = ((Integer) map.get("filter_quality")).intValue();
        }
        AppMethodBeat.o(86469);
    }

    public final void setEffectIndex(int i) {
        this.bNT = i;
    }

    public final void ApplyGLSLFilter(boolean z, float f, float f2) {
        AppMethodBeat.i(86470);
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
        baseFilter.addParam(new f("percent1", (float) d));
        baseFilter.addParam(new f("percent2", (float) d2));
        baseFilter.addParam(new f("percent3", (float) d3));
        baseFilter.addParam(new f("percent4", (float) d4));
        baseFilter.addParam(new f("percent5", (float) d5));
        baseFilter.addParam(new f("percent6", (float) d6));
        baseFilter.addParam(new f("percent7", (float) d7));
        b bVar = new b(this.bNT, this.quality);
        baseFilter.setNextFilter(bVar, null);
        if (this.bNT == 5) {
            float min = Math.min(f2, f);
            BaseFilter baseFilter2 = new BaseFilter(GLSLRender.bJB);
            baseFilter2.scaleFact = Math.min(400.0f / min, 1.0f);
            bVar.setNextFilter(baseFilter2, null);
            a aVar = new a(this.quality, baseFilter2.scaleFact);
            baseFilter2.setNextFilter(aVar, null);
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
            aVar.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex + 3});
            aVar.addParam(new f("filterAdjustParam", 1.0f - f3));
        }
        super.ApplyGLSLFilter(z, f, f2);
        AppMethodBeat.o(86470);
    }
}
