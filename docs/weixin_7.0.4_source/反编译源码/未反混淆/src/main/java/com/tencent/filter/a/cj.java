package com.tencent.filter.a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.a.cu.a;
import com.tencent.filter.a.cu.b;
import com.tencent.filter.a.cu.c;
import com.tencent.filter.a.cu.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;

public final class cj {
    public static BaseFilter creatFilterById(int i) {
        BaseFilter cgVar;
        AppMethodBeat.i(86553);
        switch (i) {
            case 200:
                cgVar = new cg();
                break;
            case 201:
                cgVar = new cg((byte) 0);
                break;
            case 204:
                cgVar = new w();
                break;
            case 205:
                cgVar = new aa();
                break;
            case 206:
                cgVar = new ac();
                break;
            case 207:
                cgVar = new h();
                break;
            case 208:
                cgVar = new an();
                break;
            case 209:
                cgVar = new ap();
                break;
            case 210:
                cgVar = new as();
                break;
            case 211:
                cgVar = new at();
                break;
            case 212:
                cgVar = new bg();
                break;
            case 213:
                cgVar = new bl();
                break;
            case 215:
                cgVar = new v();
                break;
            case 216:
                cgVar = new e();
                break;
            case 217:
                cgVar = new r();
                break;
            case 219:
                cgVar = new z();
                break;
            case 220:
                cgVar = new f();
                break;
            case 222:
                cgVar = new ci();
                break;
            case 223:
                cgVar = new ad();
                break;
            case 224:
                cgVar = new d();
                break;
            case 225:
                cgVar = new j();
                break;
            case 226:
                cgVar = new g();
                break;
            case 227:
                cgVar = new bc();
                break;
            case 228:
                cgVar = new bi();
                break;
            case 229:
                cgVar = new cf();
                break;
            case 230:
                cgVar = new u();
                break;
            case 232:
                cgVar = new ar();
                break;
            case d.MIC_PTU_MEISHI /*233*/:
                cgVar = new bb();
                break;
            case d.MIC_PTU_FENGJING /*234*/:
                cgVar = new y();
                break;
            case d.MIC_PTU_AUTOLEVEL /*235*/:
                cgVar = new a();
                break;
            case 236:
                cgVar = new bq();
                break;
            case d.MIC_PTU_LENGMEIREN /*237*/:
                cgVar = new bp();
                break;
            case d.MIC_PTU_SHIGUANG /*238*/:
                cgVar = new bs();
                break;
            case d.MIC_PTU_SHISHANG2 /*239*/:
                cgVar = new bt();
                break;
            case 240:
                cgVar = new bu();
                break;
            case d.MIC_PTU_QINGCONG /*241*/:
                cgVar = new br();
                break;
            case 242:
                cgVar = new ca();
                break;
            case 243:
                cgVar = new cm();
                break;
            case 244:
                cgVar = new cc();
                break;
            case d.MIC_PTU_ZIPAI_LIGHTWHITE /*245*/:
                cgVar = new aw();
                break;
            case d.MIC_PTU_ZIPAI_FAIRYTALE /*246*/:
                cgVar = new ba();
                break;
            case 247:
                cgVar = new bj();
                break;
            case d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                cgVar = new cn();
                break;
            case 249:
                cgVar = new cb();
                break;
            case 250:
                cgVar = new cd();
                break;
            case 251:
                cgVar = new bf();
                break;
            case 252:
                cgVar = new au();
                break;
            case d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
                cgVar = new bn();
                break;
            case d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                cgVar = new av();
                break;
            case 255:
                cgVar = new l();
                break;
            case 256:
                cgVar = new db();
                break;
            case d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                cgVar = new q();
                break;
            case d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                cgVar = new ce();
                break;
            case d.MIC_PTU_ZIPAI_MEDSEA /*259*/:
                cgVar = new az();
                break;
            case d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW /*260*/:
                cgVar = new ai();
                break;
            case d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                cgVar = new af();
                break;
            case d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                cgVar = new ah();
                break;
            case d.MIC_PTU_ZIPAI_GRADIENT_FASHION /*263*/:
                cgVar = new ag();
                break;
            case d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE /*264*/:
                cgVar = new be();
                break;
            case d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE /*265*/:
                cgVar = new bd();
                break;
            case d.MIC_PTU_ZIPAI_GRADIENT_LOLLY /*266*/:
                cgVar = new ax();
                break;
            case d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW /*267*/:
                cgVar = new cz();
                break;
            case d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI /*268*/:
                cgVar = new i();
                break;
            case 269:
                cgVar = new n();
                break;
            case 270:
                cgVar = new cl();
                break;
            case 271:
                cgVar = new b();
                break;
            case 272:
                cgVar = new co();
                break;
            case 273:
                cgVar = new ay();
                break;
            case 274:
                cgVar = new p();
                break;
            case d.MIC_GPU_AUTOLEVEL /*275*/:
                cgVar = new ao();
                break;
            case 276:
                cgVar = new ab();
                break;
            case 277:
                cgVar = new cq();
                break;
            case d.MIC_PTU_TRANS_XINGYE /*278*/:
                cgVar = new ct();
                break;
            case d.MIC_PTU_TRANS_ROUHE /*279*/:
                cgVar = new cr();
                break;
            case d.MIC_PTU_TRANS_XINXIAN /*280*/:
                cgVar = new cs();
                break;
            case d.MIC_PTU_TRANS_KONGCHENG /*281*/:
                cgVar = new cp();
                break;
            case d.MIC_PTU_BAIXI /*282*/:
                cgVar = new c();
                break;
            case 283:
                cgVar = new bv();
                break;
            case 284:
                cgVar = new bw();
                break;
            case 285:
                cgVar = new cx();
                break;
            case 286:
                cgVar = new ck();
                break;
            case d.MIC_PTU_SHUILIAN /*287*/:
                cgVar = new ch();
                break;
            case d.MIC_PTU_YOUJIALI /*288*/:
                cgVar = new da();
                break;
            case d.MIC_PTU_ZIRAN /*289*/:
                cgVar = new dd();
                break;
            case 290:
                cgVar = new v();
                break;
            case 291:
                cgVar = new co();
                break;
            case 292:
                cgVar = new bm();
                break;
            case 293:
                cgVar = new u();
                cgVar.setEffectIndex(4);
                break;
            case d.MIC_PTU_WU /*294*/:
                cgVar = new cv();
                break;
            case 295:
                cgVar = new x();
                break;
            case d.MIC_PTU_YINGTAOBUDING /*296*/:
                cgVar = new cz();
                break;
            case 297:
                cgVar = new cw();
                break;
            case 298:
                cgVar = new bx();
                break;
            case 299:
                cgVar = new b();
                break;
            case 300:
                cgVar = new cu.d();
                break;
            case 301:
                cgVar = new e();
                break;
            case 302:
                cgVar = new c();
                break;
            case 303:
                cgVar = new a();
                break;
            case 304:
                cgVar = new bo();
                break;
            case d.MIC_PTU_QINGCHENG /*305*/:
                cgVar = new bz();
                break;
            case 306:
                cgVar = new cy();
                break;
            case 307:
                cgVar = new ae();
                break;
            case 308:
                cgVar = new m();
                break;
            case d.MIC_PTU_MUSE /*309*/:
                cgVar = new bh();
                break;
            case d.MIC_PTU_DANNAI /*310*/:
                cgVar = new o();
                break;
            case d.MIC_PTU_HONGKONG /*311*/:
                cgVar = new am();
                break;
            case 312:
                cgVar = new aq();
                break;
            case 313:
                cgVar = new ak();
                break;
            case 314:
                cgVar = new dc();
                break;
            default:
                cgVar = new BaseFilter(GLSLRender.bJB);
                break;
        }
        AppMethodBeat.o(86553);
        return cgVar;
    }
}
