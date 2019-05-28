package com.tencent.mars.smc;

import com.tencent.mm.protocal.a.a.a;
import com.tencent.mm.protocal.a.a.b;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.d;
import com.tencent.mm.protocal.a.a.e;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.a.a.l;
import com.tencent.mm.protocal.a.a.m;
import com.tencent.mm.protocal.a.a.n;
import com.tencent.mm.protocal.a.a.o;
import com.tencent.mm.protocal.protobuf.ahi;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.protocal.protobuf.awy;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cff;
import com.tencent.mm.protocal.protobuf.sj;
import com.tencent.mm.protocal.protobuf.sk;
import com.tencent.mm.protocal.protobuf.sl;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil {
    public static sk toMMReportKvReq(i iVar) {
        sk skVar = new sk();
        skVar.vZG = iVar.vyT;
        skVar.vZH = iVar.vzj;
        skVar.vZI = iVar.vzh;
        for (int i = 0; i < iVar.vzk.size(); i++) {
            e eVar = (e) iVar.vzk.get(i);
            sj sjVar = new sj();
            sjVar.luF = eVar.uin;
            sjVar.vKd = eVar.vyR;
            sjVar.vZF = eVar.nettype;
            sjVar.vOB = eVar.vzd;
            sjVar.vOz = eVar.vzb;
            sjVar.vOA = eVar.vzc;
            sjVar.vOC = eVar.vze;
            sjVar.vOD = eVar.vzf;
            sjVar.jCy = eVar.vzg;
            for (int i2 = 0; i2 < eVar.vyS.size(); i2++) {
                d dVar = (d) eVar.vyS.get(i2);
                awy awy = new awy();
                awy.wBd = dVar.vyQ;
                awy.wBe = dVar.vyZ;
                awy.wBf = dVar.vza;
                awy.wdc = dVar.qsz;
                awy.jBv = dVar.count;
                sjVar.naO.add(awy);
            }
            skVar.vZJ.add(sjVar);
        }
        return skVar;
    }

    public static sk toMMReportIdkeyReq(g gVar) {
        sk skVar = new sk();
        skVar.vZG = gVar.vyT;
        skVar.vZH = gVar.vzj;
        skVar.vZI = 0;
        for (int i = 0; i < gVar.vzk.size(); i++) {
            b bVar = (b) gVar.vzk.get(i);
            sj sjVar = new sj();
            sjVar.luF = bVar.uin;
            sjVar.vKd = bVar.vyR;
            sjVar.vZF = bVar.nettype;
            for (int i2 = 0; i2 < bVar.vyS.size(); i2++) {
                a aVar = (a) bVar.vyS.get(i2);
                awy awy = new awy();
                awy.wBd = aVar.vyQ;
                awy.wdc = 0;
                awy.wBf = 0;
                awy.jBv = aVar.count;
                awy.wBe = com.tencent.mm.bt.b.bI(Integer.toString(aVar.value).getBytes());
                sjVar.naO.add(awy);
            }
            skVar.vZJ.add(sjVar);
        }
        return skVar;
    }

    private static o fillStrategyTable(LinkedList<cff> linkedList) {
        o oVar = new o();
        for (int i = 0; i < linkedList.size(); i++) {
            cff cff = (cff) linkedList.get(i);
            m mVar = new m();
            mVar.vzw = cff.xeK;
            mVar.vzx = cff.xeL;
            for (int i2 = 0; i2 < cff.xeM.size(); i2++) {
                bei bei = (bei) cff.xeM.get(i2);
                n nVar = new n();
                nVar.vyQ = bei.wBd;
                nVar.vzz = bei.wIs;
                nVar.vzA = bei.wIq;
                nVar.vzB = bei.wIr;
                nVar.vzC = bei.wIt;
                nVar.vzD = bei.wIu;
                nVar.vzE = bei.wIv;
                nVar.type = bei.jCt;
                mVar.vzy.add(nVar);
            }
            oVar.vzF.add(mVar);
        }
        return oVar;
    }

    public static j toSmcReportKvResp(sl slVar) {
        j jVar = new j();
        jVar.ret = slVar.Ret;
        jVar.vyT = slVar.vZM;
        jVar.vyU = slVar.vZN;
        jVar.vzh = slVar.vZO;
        jVar.vyX = slVar.vZS;
        jVar.vzm = slVar.vZT;
        jVar.vyY = slVar.vZU;
        jVar.vyV = fillStrategyTable(slVar.vZP);
        jVar.vyW = fillStrategyTable(slVar.vZQ);
        jVar.vzi = fillStrategyTable(slVar.vZR);
        return jVar;
    }

    public static h toSmcReportIdkeyResp(sl slVar) {
        h hVar = new h();
        hVar.ret = slVar.Ret;
        hVar.vyT = slVar.vZM;
        hVar.vyU = slVar.vZN;
        hVar.vyX = slVar.vZS;
        hVar.vzm = slVar.vZT;
        hVar.vyY = slVar.vZU;
        hVar.vyV = fillStrategyTable(slVar.vZP);
        hVar.vyW = fillStrategyTable(slVar.vZQ);
        return hVar;
    }

    public static ahi toMMGetStrategyReq() {
        ahi ahi = new ahi();
        ArrayList strategyVersions = SmcLogic.getStrategyVersions();
        if (strategyVersions.size() != 6) {
            return null;
        }
        ahi.vZG = ((Integer) strategyVersions.get(0)).intValue();
        ahi.vZH = ((Integer) strategyVersions.get(1)).intValue();
        ahi.vZI = ((Integer) strategyVersions.get(2)).intValue();
        ahi.wnO = ((Integer) strategyVersions.get(3)).intValue();
        ahi.wnP = ((Integer) strategyVersions.get(4)).intValue();
        ahi.wnQ = ((Integer) strategyVersions.get(5)).intValue();
        return ahi;
    }

    public static f toSmcKVStrategyResp(ahj ahj) {
        f fVar = new f();
        fVar.ret = ahj.Ret;
        fVar.vyT = ahj.wnO;
        fVar.vyU = ahj.wnP;
        fVar.vzh = ahj.wnQ;
        fVar.vyX = ahj.vZS;
        fVar.vyY = ahj.vZU;
        fVar.vyV = fillStrategyTable(ahj.wnR);
        fVar.vyW = fillStrategyTable(ahj.wnS);
        fVar.vzi = fillStrategyTable(ahj.wnT);
        return fVar;
    }

    public static c toSmcIdkeyStrategyResp(ahj ahj) {
        c cVar = new c();
        cVar.ret = ahj.Ret;
        cVar.vyT = ahj.vZM;
        cVar.vyU = ahj.vZN;
        cVar.vyX = ahj.vZS;
        cVar.vyY = ahj.vZU;
        cVar.vyV = fillStrategyTable(ahj.vZP);
        cVar.vyW = fillStrategyTable(ahj.vZQ);
        return cVar;
    }

    public static auf toMMSelfMonitor(k kVar) {
        auf auf = new auf();
        auf.wye = kVar.vzn;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= kVar.vzo.size()) {
                return auf;
            }
            aug aug = new aug();
            l lVar = (l) kVar.vzo.get(i2);
            aug.wyf = lVar.vzp;
            aug.cts = lVar.action;
            aug.wyg = lVar.vzq;
            aug.wyh = lVar.vzr;
            aug.wyi = lVar.vzs;
            aug.wyj = lVar.vzt;
            aug.wyk = lVar.vzu;
            aug.wyl = lVar.vzv;
            auf.naO.add(aug);
            i = i2 + 1;
        }
    }
}
