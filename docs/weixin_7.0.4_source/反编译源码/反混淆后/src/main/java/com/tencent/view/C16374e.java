package com.tencent.view;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.C17754d;
import com.tencent.filter.C17755e;
import com.tencent.filter.C17756g;
import com.tencent.filter.C17758n;
import com.tencent.filter.C32131f;
import com.tencent.filter.C44671a;
import com.tencent.filter.C44673b;
import com.tencent.filter.C44674i;
import com.tencent.filter.C44675j;
import com.tencent.filter.FilterWraper;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.art.C25623a;
import com.tencent.filter.art.C37340b;
import com.tencent.filter.art.C37341d;
import com.tencent.filter.art.C45096e;
import com.tencent.filter.art.C8785f;
import com.tencent.filter.art.DofCpuFilter;
import com.tencent.filter.art.OilPaintFilter;
import com.tencent.filter.p138a.C37332cj;
import com.tencent.filter.p138a.C44661by;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.view.e */
public class C16374e {
    public static BaseFilter createFilter(int i) {
        BaseFilter baseFilter;
        AppMethodBeat.m2504i(86636);
        switch (i) {
            case 0:
                baseFilter = new BaseFilter(GLSLRender.bJB);
                break;
            case 1:
                baseFilter = new C44671a(GLSLRender.bJE);
                break;
            case 2:
                baseFilter = new C44673b(GLSLRender.bJB, 1);
                break;
            case 3:
                baseFilter = new C17755e("rise.png");
                break;
            case 4:
                baseFilter = new C44673b(GLSLRender.bJB, 0);
                break;
            case 5:
                baseFilter = new C44661by();
                break;
            case 6:
                baseFilter = new C17755e("hudson.png");
                break;
            case 7:
                baseFilter = new C25623a(GLSLRender.bJB);
                break;
            case 8:
                baseFilter = new C17756g();
                break;
            case 9:
                baseFilter = new C17755e("xpro2.png");
                break;
            case 10:
                baseFilter = new C17755e("qiurisiyu.png");
                break;
            case 11:
                baseFilter = new C17755e("jingdianheibai.png");
                ((C17755e) baseFilter).setMatrix(new float[]{0.299f, 0.299f, 0.299f, 0.0f, 0.587f, 0.587f, 0.587f, 0.0f, 0.114f, 0.114f, 0.114f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
                break;
            case 12:
                baseFilter = new C17755e("danya.png");
                ((C17755e) baseFilter).setMatrix(new float[]{0.825f, 0.075f, 0.075f, 0.0f, 0.147f, 0.897f, 0.147f, 0.0f, 0.029f, 0.029f, 0.779f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f});
                break;
            case 80:
                baseFilter = new C44675j();
                break;
            case 81:
                baseFilter = new C45096e();
                break;
            case C31128d.MIC_COLORPENCIL /*87*/:
                baseFilter = new BaseFilter(GLSLRender.bJL, "colorPencil.png");
                break;
            case 94:
                baseFilter = new C37340b(0);
                break;
            case 95:
                baseFilter = new C37340b(1);
                break;
            case 96:
                baseFilter = new C37340b(2);
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
            case C31128d.MIC_ALPHA_ADJUST_REAL /*117*/:
                baseFilter = new C44671a(GLSLRender.bJF);
                break;
            case C31128d.MIC_AVROUND_BLUR /*119*/:
                baseFilter = new DofCpuFilter(1);
                break;
            case 120:
                baseFilter = new C8785f();
                break;
            case 121:
                baseFilter = new C37341d();
                break;
            case 122:
                baseFilter = new C44674i();
                break;
            case 125:
                baseFilter = new C32131f();
                break;
            case C31128d.MIC_SketchMark /*127*/:
                baseFilter = new BaseFilter(GLSLRender.bKP);
                break;
            case 128:
                baseFilter = new BaseFilter(GLSLRender.bKQ, "sketch.png");
                break;
            case 150:
                baseFilter = new FilterWraper("Curve2D/amaro");
                break;
            case 202:
                baseFilter = new C17754d();
                break;
            case 214:
                baseFilter = new C17758n();
                break;
            default:
                baseFilter = C37332cj.creatFilterById(i);
                break;
        }
        AppMethodBeat.m2505o(86636);
        return baseFilter;
    }
}
