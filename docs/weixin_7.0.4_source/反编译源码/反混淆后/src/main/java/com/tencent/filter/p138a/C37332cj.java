package com.tencent.filter.p138a;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.p138a.C41671cu.C0932e;
import com.tencent.filter.p138a.C41671cu.C17745d;
import com.tencent.filter.p138a.C41671cu.C32126a;
import com.tencent.filter.p138a.C41671cu.C32127c;
import com.tencent.filter.p138a.C41671cu.C37334b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.filter.a.cj */
public final class C37332cj {
    public static BaseFilter creatFilterById(int i) {
        BaseFilter c25612cg;
        AppMethodBeat.m2504i(86553);
        switch (i) {
            case 200:
                c25612cg = new C25612cg();
                break;
            case 201:
                c25612cg = new C25612cg((byte) 0);
                break;
            case 204:
                c25612cg = new C44670w();
                break;
            case 205:
                c25612cg = new C17735aa();
                break;
            case 206:
                c25612cg = new C44655ac();
                break;
            case 207:
                c25612cg = new C17747h();
                break;
            case 208:
                c25612cg = new C45086an();
                break;
            case 209:
                c25612cg = new C32118ap();
                break;
            case 210:
                c25612cg = new C32119as();
                break;
            case 211:
                c25612cg = new C32120at();
                break;
            case 212:
                c25612cg = new C44659bg();
                break;
            case 213:
                c25612cg = new C17741bl();
                break;
            case 215:
                c25612cg = new C44840v();
                break;
            case 216:
                c25612cg = new C32128e();
                break;
            case 217:
                c25612cg = new C17749r();
                break;
            case 219:
                c25612cg = new C17752z();
                break;
            case 220:
                c25612cg = new C32129f();
                break;
            case 222:
                c25612cg = new C45092ci();
                break;
            case 223:
                c25612cg = new C44656ad();
                break;
            case 224:
                c25612cg = new C37336d();
                break;
            case 225:
                c25612cg = new C8783j();
                break;
            case 226:
                c25612cg = new C25619g();
                break;
            case 227:
                c25612cg = new C25608bc();
                break;
            case 228:
                c25612cg = new C44660bi();
                break;
            case 229:
                c25612cg = new C8779cf();
                break;
            case 230:
                c25612cg = new C44669u();
                break;
            case 232:
                c25612cg = new C0930ar();
                break;
            case C31128d.MIC_PTU_MEISHI /*233*/:
                c25612cg = new C8774bb();
                break;
            case C31128d.MIC_PTU_FENGJING /*234*/:
                c25612cg = new C25622y();
                break;
            case C31128d.MIC_PTU_AUTOLEVEL /*235*/:
                c25612cg = new C0928a();
                break;
            case 236:
                c25612cg = new C45088bq();
                break;
            case C31128d.MIC_PTU_LENGMEIREN /*237*/:
                c25612cg = new C37328bp();
                break;
            case C31128d.MIC_PTU_SHIGUANG /*238*/:
                c25612cg = new C25610bs();
                break;
            case C31128d.MIC_PTU_SHISHANG2 /*239*/:
                c25612cg = new C8776bt();
                break;
            case 240:
                c25612cg = new C8777bu();
                break;
            case C31128d.MIC_PTU_QINGCONG /*241*/:
                c25612cg = new C8775br();
                break;
            case 242:
                c25612cg = new C37330ca();
                break;
            case 243:
                c25612cg = new C17742cm();
                break;
            case 244:
                c25612cg = new C37331cc();
                break;
            case C31128d.MIC_PTU_ZIPAI_LIGHTWHITE /*245*/:
                c25612cg = new C32123aw();
                break;
            case C31128d.MIC_PTU_ZIPAI_FAIRYTALE /*246*/:
                c25612cg = new C25607ba();
                break;
            case 247:
                c25612cg = new C17739bj();
                break;
            case C31128d.MIC_PTU_ZIPAI_THURSDAY /*248*/:
                c25612cg = new C25613cn();
                break;
            case 249:
                c25612cg = new C45091cb();
                break;
            case 250:
                c25612cg = new C25611cd();
                break;
            case 251:
                c25612cg = new C44658bf();
                break;
            case 252:
                c25612cg = new C32121au();
                break;
            case C31128d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
                c25612cg = new C44839bn();
                break;
            case C31128d.MIC_PTU_ZIPAI_LIGHTRED /*254*/:
                c25612cg = new C32122av();
                break;
            case 255:
                c25612cg = new C44666l();
                break;
            case 256:
                c25612cg = new C8782db();
                break;
            case C31128d.MIC_PTU_ZIPAI_TOKYO /*257*/:
                c25612cg = new C17748q();
                break;
            case C31128d.MIC_PTU_ZIPAI_SAPPORO /*258*/:
                c25612cg = new C8778ce();
                break;
            case C31128d.MIC_PTU_ZIPAI_MEDSEA /*259*/:
                c25612cg = new C8773az();
                break;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW /*260*/:
                c25612cg = new C25605ai();
                break;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW /*261*/:
                c25612cg = new C17736af();
                break;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_GLAREFONDDREAM /*262*/:
                c25612cg = new C17737ah();
                break;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION /*263*/:
                c25612cg = new C32117ag();
                break;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE /*264*/:
                c25612cg = new C44657be();
                break;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE /*265*/:
                c25612cg = new C17738bd();
                break;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY /*266*/:
                c25612cg = new C8772ax();
                break;
            case C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW /*267*/:
                c25612cg = new C37335cz();
                break;
            case C31128d.MIC_PTU_ZIPAI_BLACKWHITEZIPAI /*268*/:
                c25612cg = new C25620i();
                break;
            case 269:
                c25612cg = new C45095n();
                break;
            case 270:
                c25612cg = new C37333cl();
                break;
            case 271:
                c25612cg = new C0931b();
                break;
            case 272:
                c25612cg = new C17743co();
                break;
            case 273:
                c25612cg = new C25606ay();
                break;
            case 274:
                c25612cg = new C32130p();
                break;
            case C31128d.MIC_GPU_AUTOLEVEL /*275*/:
                c25612cg = new C8771ao();
                break;
            case 276:
                c25612cg = new C44654ab();
                break;
            case 277:
                c25612cg = new C44662cq();
                break;
            case C31128d.MIC_PTU_TRANS_XINGYE /*278*/:
                c25612cg = new C44665ct();
                break;
            case C31128d.MIC_PTU_TRANS_ROUHE /*279*/:
                c25612cg = new C44663cr();
                break;
            case C31128d.MIC_PTU_TRANS_XINXIAN /*280*/:
                c25612cg = new C44664cs();
                break;
            case C31128d.MIC_PTU_TRANS_KONGCHENG /*281*/:
                c25612cg = new C17744cp();
                break;
            case C31128d.MIC_PTU_BAIXI /*282*/:
                c25612cg = new C32125c();
                break;
            case 283:
                c25612cg = new C32124bv();
                break;
            case 284:
                c25612cg = new C37329bw();
                break;
            case 285:
                c25612cg = new C8781cx();
                break;
            case 286:
                c25612cg = new C45093ck();
                break;
            case C31128d.MIC_PTU_SHUILIAN /*287*/:
                c25612cg = new C8780ch();
                break;
            case C31128d.MIC_PTU_YOUJIALI /*288*/:
                c25612cg = new C25617da();
                break;
            case C31128d.MIC_PTU_ZIRAN /*289*/:
                c25612cg = new C37337dd();
                break;
            case 290:
                c25612cg = new C44840v();
                break;
            case 291:
                c25612cg = new C17743co();
                break;
            case 292:
                c25612cg = new C25609bm();
                break;
            case 293:
                c25612cg = new C44669u();
                c25612cg.setEffectIndex(4);
                break;
            case C31128d.MIC_PTU_WU /*294*/:
                c25612cg = new C25614cv();
                break;
            case 295:
                c25612cg = new C17751x();
                break;
            case C31128d.MIC_PTU_YINGTAOBUDING /*296*/:
                c25612cg = new C37335cz();
                break;
            case 297:
                c25612cg = new C17746cw();
                break;
            case 298:
                c25612cg = new C45089bx();
                break;
            case 299:
                c25612cg = new C37334b();
                break;
            case 300:
                c25612cg = new C17745d();
                break;
            case 301:
                c25612cg = new C0932e();
                break;
            case 302:
                c25612cg = new C32127c();
                break;
            case 303:
                c25612cg = new C32126a();
                break;
            case 304:
                c25612cg = new C45087bo();
                break;
            case C31128d.MIC_PTU_QINGCHENG /*305*/:
                c25612cg = new C45090bz();
                break;
            case 306:
                c25612cg = new C25615cy();
                break;
            case 307:
                c25612cg = new C44837ae();
                break;
            case 308:
                c25612cg = new C37338m();
                break;
            case C31128d.MIC_PTU_MUSE /*309*/:
                c25612cg = new C44838bh();
                break;
            case C31128d.MIC_PTU_DANNAI /*310*/:
                c25612cg = new C37339o();
                break;
            case C31128d.MIC_PTU_HONGKONG /*311*/:
                c25612cg = new C37327am();
                break;
            case 312:
                c25612cg = new C0929aq();
                break;
            case 313:
                c25612cg = new C37325ak();
                break;
            case 314:
                c25612cg = new C25618dc();
                break;
            default:
                c25612cg = new BaseFilter(GLSLRender.bJB);
                break;
        }
        AppMethodBeat.m2505o(86553);
        return c25612cg;
    }
}
