package com.tencent.mars.smc;

import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.p1084a.p1085a.C14993a;
import com.tencent.p177mm.protocal.p1084a.p1085a.C23364d;
import com.tencent.p177mm.protocal.p1084a.p1085a.C23365j;
import com.tencent.p177mm.protocal.p1084a.p1085a.C23366k;
import com.tencent.p177mm.protocal.p1084a.p1085a.C23367l;
import com.tencent.p177mm.protocal.p1084a.p1085a.C30161b;
import com.tencent.p177mm.protocal.p1084a.p1085a.C30162c;
import com.tencent.p177mm.protocal.p1084a.p1085a.C30163i;
import com.tencent.p177mm.protocal.p1084a.p1085a.C40495f;
import com.tencent.p177mm.protocal.p1084a.p1085a.C40496m;
import com.tencent.p177mm.protocal.p1084a.p1085a.C40497o;
import com.tencent.p177mm.protocal.p1084a.p1085a.C44096g;
import com.tencent.p177mm.protocal.p1084a.p1085a.C44097h;
import com.tencent.p177mm.protocal.p1084a.p1085a.C46513e;
import com.tencent.p177mm.protocal.p1084a.p1085a.C46514n;
import com.tencent.p177mm.protocal.protobuf.C23439sj;
import com.tencent.p177mm.protocal.protobuf.C30224sk;
import com.tencent.p177mm.protocal.protobuf.C40569sl;
import com.tencent.p177mm.protocal.protobuf.ahi;
import com.tencent.p177mm.protocal.protobuf.ahj;
import com.tencent.p177mm.protocal.protobuf.auf;
import com.tencent.p177mm.protocal.protobuf.aug;
import com.tencent.p177mm.protocal.protobuf.awy;
import com.tencent.p177mm.protocal.protobuf.bei;
import com.tencent.p177mm.protocal.protobuf.cff;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil {
    public static C30224sk toMMReportKvReq(C30163i c30163i) {
        C30224sk c30224sk = new C30224sk();
        c30224sk.vZG = c30163i.vyT;
        c30224sk.vZH = c30163i.vzj;
        c30224sk.vZI = c30163i.vzh;
        for (int i = 0; i < c30163i.vzk.size(); i++) {
            C46513e c46513e = (C46513e) c30163i.vzk.get(i);
            C23439sj c23439sj = new C23439sj();
            c23439sj.luF = c46513e.uin;
            c23439sj.vKd = c46513e.vyR;
            c23439sj.vZF = c46513e.nettype;
            c23439sj.vOB = c46513e.vzd;
            c23439sj.vOz = c46513e.vzb;
            c23439sj.vOA = c46513e.vzc;
            c23439sj.vOC = c46513e.vze;
            c23439sj.vOD = c46513e.vzf;
            c23439sj.jCy = c46513e.vzg;
            for (int i2 = 0; i2 < c46513e.vyS.size(); i2++) {
                C23364d c23364d = (C23364d) c46513e.vyS.get(i2);
                awy awy = new awy();
                awy.wBd = c23364d.vyQ;
                awy.wBe = c23364d.vyZ;
                awy.wBf = c23364d.vza;
                awy.wdc = c23364d.qsz;
                awy.jBv = c23364d.count;
                c23439sj.naO.add(awy);
            }
            c30224sk.vZJ.add(c23439sj);
        }
        return c30224sk;
    }

    public static C30224sk toMMReportIdkeyReq(C44096g c44096g) {
        C30224sk c30224sk = new C30224sk();
        c30224sk.vZG = c44096g.vyT;
        c30224sk.vZH = c44096g.vzj;
        c30224sk.vZI = 0;
        for (int i = 0; i < c44096g.vzk.size(); i++) {
            C30161b c30161b = (C30161b) c44096g.vzk.get(i);
            C23439sj c23439sj = new C23439sj();
            c23439sj.luF = c30161b.uin;
            c23439sj.vKd = c30161b.vyR;
            c23439sj.vZF = c30161b.nettype;
            for (int i2 = 0; i2 < c30161b.vyS.size(); i2++) {
                C14993a c14993a = (C14993a) c30161b.vyS.get(i2);
                awy awy = new awy();
                awy.wBd = c14993a.vyQ;
                awy.wdc = 0;
                awy.wBf = 0;
                awy.jBv = c14993a.count;
                awy.wBe = C1332b.m2847bI(Integer.toString(c14993a.value).getBytes());
                c23439sj.naO.add(awy);
            }
            c30224sk.vZJ.add(c23439sj);
        }
        return c30224sk;
    }

    private static C40497o fillStrategyTable(LinkedList<cff> linkedList) {
        C40497o c40497o = new C40497o();
        for (int i = 0; i < linkedList.size(); i++) {
            cff cff = (cff) linkedList.get(i);
            C40496m c40496m = new C40496m();
            c40496m.vzw = cff.xeK;
            c40496m.vzx = cff.xeL;
            for (int i2 = 0; i2 < cff.xeM.size(); i2++) {
                bei bei = (bei) cff.xeM.get(i2);
                C46514n c46514n = new C46514n();
                c46514n.vyQ = bei.wBd;
                c46514n.vzz = bei.wIs;
                c46514n.vzA = bei.wIq;
                c46514n.vzB = bei.wIr;
                c46514n.vzC = bei.wIt;
                c46514n.vzD = bei.wIu;
                c46514n.vzE = bei.wIv;
                c46514n.type = bei.jCt;
                c40496m.vzy.add(c46514n);
            }
            c40497o.vzF.add(c40496m);
        }
        return c40497o;
    }

    public static C23365j toSmcReportKvResp(C40569sl c40569sl) {
        C23365j c23365j = new C23365j();
        c23365j.ret = c40569sl.Ret;
        c23365j.vyT = c40569sl.vZM;
        c23365j.vyU = c40569sl.vZN;
        c23365j.vzh = c40569sl.vZO;
        c23365j.vyX = c40569sl.vZS;
        c23365j.vzm = c40569sl.vZT;
        c23365j.vyY = c40569sl.vZU;
        c23365j.vyV = fillStrategyTable(c40569sl.vZP);
        c23365j.vyW = fillStrategyTable(c40569sl.vZQ);
        c23365j.vzi = fillStrategyTable(c40569sl.vZR);
        return c23365j;
    }

    public static C44097h toSmcReportIdkeyResp(C40569sl c40569sl) {
        C44097h c44097h = new C44097h();
        c44097h.ret = c40569sl.Ret;
        c44097h.vyT = c40569sl.vZM;
        c44097h.vyU = c40569sl.vZN;
        c44097h.vyX = c40569sl.vZS;
        c44097h.vzm = c40569sl.vZT;
        c44097h.vyY = c40569sl.vZU;
        c44097h.vyV = fillStrategyTable(c40569sl.vZP);
        c44097h.vyW = fillStrategyTable(c40569sl.vZQ);
        return c44097h;
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

    public static C40495f toSmcKVStrategyResp(ahj ahj) {
        C40495f c40495f = new C40495f();
        c40495f.ret = ahj.Ret;
        c40495f.vyT = ahj.wnO;
        c40495f.vyU = ahj.wnP;
        c40495f.vzh = ahj.wnQ;
        c40495f.vyX = ahj.vZS;
        c40495f.vyY = ahj.vZU;
        c40495f.vyV = fillStrategyTable(ahj.wnR);
        c40495f.vyW = fillStrategyTable(ahj.wnS);
        c40495f.vzi = fillStrategyTable(ahj.wnT);
        return c40495f;
    }

    public static C30162c toSmcIdkeyStrategyResp(ahj ahj) {
        C30162c c30162c = new C30162c();
        c30162c.ret = ahj.Ret;
        c30162c.vyT = ahj.vZM;
        c30162c.vyU = ahj.vZN;
        c30162c.vyX = ahj.vZS;
        c30162c.vyY = ahj.vZU;
        c30162c.vyV = fillStrategyTable(ahj.vZP);
        c30162c.vyW = fillStrategyTable(ahj.vZQ);
        return c30162c;
    }

    public static auf toMMSelfMonitor(C23366k c23366k) {
        auf auf = new auf();
        auf.wye = c23366k.vzn;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c23366k.vzo.size()) {
                return auf;
            }
            aug aug = new aug();
            C23367l c23367l = (C23367l) c23366k.vzo.get(i2);
            aug.wyf = c23367l.vzp;
            aug.cts = c23367l.action;
            aug.wyg = c23367l.vzq;
            aug.wyh = c23367l.vzr;
            aug.wyi = c23367l.vzs;
            aug.wyj = c23367l.vzt;
            aug.wyk = c23367l.vzu;
            aug.wyl = c23367l.vzv;
            auf.naO.add(aug);
            i = i2 + 1;
        }
    }
}
