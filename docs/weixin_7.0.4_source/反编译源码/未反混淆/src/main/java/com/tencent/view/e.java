package com.tencent.view;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.FilterWraper;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.a;
import com.tencent.filter.a.by;
import com.tencent.filter.a.cj;
import com.tencent.filter.art.DofCpuFilter;
import com.tencent.filter.art.OilPaintFilter;
import com.tencent.filter.art.d;
import com.tencent.filter.art.f;
import com.tencent.filter.b;
import com.tencent.filter.g;
import com.tencent.filter.i;
import com.tencent.filter.j;
import com.tencent.filter.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e {
    public static BaseFilter createFilter(int i) {
        BaseFilter baseFilter;
        AppMethodBeat.i(86636);
        switch (i) {
            case 0:
                baseFilter = new BaseFilter(GLSLRender.bJB);
                break;
            case 1:
                baseFilter = new a(GLSLRender.bJE);
                break;
            case 2:
                baseFilter = new b(GLSLRender.bJB, 1);
                break;
            case 3:
                baseFilter = new com.tencent.filter.e("rise.png");
                break;
            case 4:
                baseFilter = new b(GLSLRender.bJB, 0);
                break;
            case 5:
                baseFilter = new by();
                break;
            case 6:
                baseFilter = new com.tencent.filter.e("hudson.png");
                break;
            case 7:
                baseFilter = new com.tencent.filter.art.a(GLSLRender.bJB);
                break;
            case 8:
                baseFilter = new g();
                break;
            case 9:
                baseFilter = new com.tencent.filter.e("xpro2.png");
                break;
            case 10:
                baseFilter = new com.tencent.filter.e("qiurisiyu.png");
                break;
            case 11:
                baseFilter = new com.tencent.filter.e("jingdianheibai.png");
                ((com.tencent.filter.e) baseFilter).setMatrix(new float[]{0.299f, 0.299f, 0.299f, 0.0f, 0.587f, 0.587f, 0.587f, 0.0f, 0.114f, 0.114f, 0.114f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
                break;
            case 12:
                baseFilter = new com.tencent.filter.e("danya.png");
                ((com.tencent.filter.e) baseFilter).setMatrix(new float[]{0.825f, 0.075f, 0.075f, 0.0f, 0.147f, 0.897f, 0.147f, 0.0f, 0.029f, 0.029f, 0.779f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
                break;
            case 80:
                baseFilter = new j();
                break;
            case 81:
                baseFilter = new com.tencent.filter.art.e();
                break;
            case d.MIC_COLORPENCIL /*87*/:
                baseFilter = new BaseFilter(GLSLRender.bJL, "colorPencil.png");
                break;
            case 94:
                baseFilter = new com.tencent.filter.art.b(0);
                break;
            case 95:
                baseFilter = new com.tencent.filter.art.b(1);
                break;
            case 96:
                baseFilter = new com.tencent.filter.art.b(2);
                break;
            case 99:
                baseFilter = new OilPaintFilter(0);
                break;
            case 100:
                baseFilter = new OilPaintFilter(1);
                break;
            case 110:
                baseFilter = new DofCpuFilter(0);
                break;
            case d.MIC_ALPHA_ADJUST_REAL /*117*/:
                baseFilter = new a(GLSLRender.bJF);
                break;
            case d.MIC_AVROUND_BLUR /*119*/:
                baseFilter = new DofCpuFilter(1);
                break;
            case 120:
                baseFilter = new f();
                break;
            case 121:
                baseFilter = new d();
                break;
            case 122:
                baseFilter = new i();
                break;
            case 125:
                baseFilter = new com.tencent.filter.f();
                break;
            case d.MIC_SketchMark /*127*/:
                baseFilter = new BaseFilter(GLSLRender.bKP);
                break;
            case 128:
                baseFilter = new BaseFilter(GLSLRender.bKQ, "sketch.png");
                break;
            case 150:
                baseFilter = new FilterWraper("Curve2D/amaro");
                break;
            case 202:
                baseFilter = new com.tencent.filter.d();
                break;
            case 214:
                baseFilter = new n();
                break;
            default:
                baseFilter = cj.creatFilterById(i);
                break;
        }
        AppMethodBeat.o(86636);
        return baseFilter;
    }
}
