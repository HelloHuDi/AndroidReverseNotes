package com.tencent.pb.common.b.a;

import java.util.Arrays;

public interface a {

    public static final class ac extends com.google.a.a.e {
        public at Amz;
        public int Aoe;
        public String groupId;

        public ac() {
            this.groupId = "";
            this.Amz = null;
            this.Aoe = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.Amz != null) {
                bVar.a(2, this.Amz);
            }
            if (this.Aoe != 0) {
                bVar.bq(3, this.Aoe);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.Amz != null) {
                vr += com.google.a.a.b.b(2, this.Amz);
            }
            if (this.Aoe != 0) {
                return vr + com.google.a.a.b.bs(3, this.Aoe);
            }
            return vr;
        }
    }

    public static final class ao extends com.google.a.a.e {
        private static volatile ao[] Aos;
        public int Aof;
        public int Aot;
        public int fps;
        public int kyZ;

        public static ao[] dPE() {
            if (Aos == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (Aos == null) {
                        Aos = new ao[0];
                    }
                }
            }
            return Aos;
        }

        public ao() {
            this.kyZ = 0;
            this.Aot = 0;
            this.fps = 0;
            this.Aof = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.kyZ != 0) {
                bVar.bq(1, this.kyZ);
            }
            if (this.Aot != 0) {
                bVar.bq(2, this.Aot);
            }
            if (this.fps != 0) {
                bVar.bq(3, this.fps);
            }
            if (this.Aof != 0) {
                bVar.bq(4, this.Aof);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.kyZ != 0) {
                vr += com.google.a.a.b.bs(1, this.kyZ);
            }
            if (this.Aot != 0) {
                vr += com.google.a.a.b.bs(2, this.Aot);
            }
            if (this.fps != 0) {
                vr += com.google.a.a.b.bs(3, this.fps);
            }
            if (this.Aof != 0) {
                return vr + com.google.a.a.b.bs(4, this.Aof);
            }
            return vr;
        }
    }

    public static final class h extends com.google.a.a.e {
        public String emc;
        public String groupId;
        public int nwu;
        public long nwv;
        public long timestamp;

        public final void a(com.google.a.a.b bVar) {
            bVar.bq(1, this.nwu);
            bVar.m(2, this.nwv);
            bVar.e(3, this.emc);
            if (!this.groupId.equals("")) {
                bVar.e(4, this.groupId);
            }
            if (this.timestamp != 0) {
                bVar.l(5, this.timestamp);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = ((super.vr() + com.google.a.a.b.bs(1, this.nwu)) + com.google.a.a.b.o(2, this.nwv)) + com.google.a.a.b.f(3, this.emc);
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(4, this.groupId);
            }
            return this.timestamp != 0 ? vr + com.google.a.a.b.n(5, this.timestamp) : vr;
        }

        public h() {
            this.nwu = 0;
            this.nwv = 0;
            this.emc = "";
            this.groupId = "";
            this.timestamp = 0;
            this.bxt = -1;
        }
    }

    public static final class o extends com.google.a.a.e {
        private static volatile o[] AmZ;
        public int Ana;
        public int port;

        public static o[] dPB() {
            if (AmZ == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (AmZ == null) {
                        AmZ = new o[0];
                    }
                }
            }
            return AmZ;
        }

        public o() {
            this.Ana = 0;
            this.port = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.Ana != 0) {
                bVar.br(1, this.Ana);
            }
            if (this.port != 0) {
                bVar.bq(2, this.port);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.Ana != 0) {
                vr += com.google.a.a.b.bt(1, this.Ana);
            }
            if (this.port != 0) {
                return vr + com.google.a.a.b.bs(2, this.port);
            }
            return vr;
        }
    }

    public static final class ad extends com.google.a.a.e {
        public String Amx;
        public String groupId;
        public int sQS;
        public long sQT;

        public ad() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.Amx = "";
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (!this.Amx.equals("")) {
                bVar.e(4, this.Amx);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.Amx.equals("")) {
                return vr;
            }
            return vr + com.google.a.a.b.f(4, this.Amx);
        }
    }

    public static final class af extends com.google.a.a.e {
        public int Aof;
        public int Aog;
        public int Aoh;
        public int Aoi;
        public int Aoj;
        public int Aok;
        public int Aol;
        public int Aom;
        public int nwu;
        public long nwv;

        public final void a(com.google.a.a.b bVar) {
            if (this.Aof != 0) {
                bVar.br(1, this.Aof);
            }
            if (this.nwu != 0) {
                bVar.bq(2, this.nwu);
            }
            if (this.nwv != 0) {
                bVar.m(3, this.nwv);
            }
            if (this.Aog != 0) {
                bVar.br(4, this.Aog);
            }
            if (this.Aoh != 0) {
                bVar.br(5, this.Aoh);
            }
            if (this.Aoi != 0) {
                bVar.br(6, this.Aoi);
            }
            if (this.Aoj != 0) {
                bVar.br(7, this.Aoj);
            }
            if (this.Aok != 0) {
                bVar.br(8, this.Aok);
            }
            if (this.Aol != -1) {
                bVar.bq(9, this.Aol);
            }
            if (this.Aom != 0) {
                bVar.bq(10, this.Aom);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.Aof != 0) {
                vr += com.google.a.a.b.bt(1, this.Aof);
            }
            if (this.nwu != 0) {
                vr += com.google.a.a.b.bs(2, this.nwu);
            }
            if (this.nwv != 0) {
                vr += com.google.a.a.b.o(3, this.nwv);
            }
            if (this.Aog != 0) {
                vr += com.google.a.a.b.bt(4, this.Aog);
            }
            if (this.Aoh != 0) {
                vr += com.google.a.a.b.bt(5, this.Aoh);
            }
            if (this.Aoi != 0) {
                vr += com.google.a.a.b.bt(6, this.Aoi);
            }
            if (this.Aoj != 0) {
                vr += com.google.a.a.b.bt(7, this.Aoj);
            }
            if (this.Aok != 0) {
                vr += com.google.a.a.b.bt(8, this.Aok);
            }
            if (this.Aol != -1) {
                vr += com.google.a.a.b.bs(9, this.Aol);
            }
            return this.Aom != 0 ? vr + com.google.a.a.b.bs(10, this.Aom) : vr;
        }

        public af() {
            this.Aof = 0;
            this.nwu = 0;
            this.nwv = 0;
            this.Aog = 0;
            this.Aoh = 0;
            this.Aoi = 0;
            this.Aoj = 0;
            this.Aok = 0;
            this.Aol = -1;
            this.Aom = 0;
            this.bxt = -1;
        }
    }

    public static final class am extends com.google.a.a.e {
        private static volatile am[] Aoo;
        public String Aop;
        public int Aoq;
        public int kyZ;
        public int vzt;

        public static am[] dPD() {
            if (Aoo == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (Aoo == null) {
                        Aoo = new am[0];
                    }
                }
            }
            return Aoo;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.kyZ != 0) {
                bVar.br(1, this.kyZ);
            }
            if (!this.Aop.equals("")) {
                bVar.e(2, this.Aop);
            }
            if (this.vzt != 0) {
                bVar.br(3, this.vzt);
            }
            if (this.Aoq != 0) {
                bVar.br(4, this.Aoq);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.kyZ != 0) {
                vr += com.google.a.a.b.bt(1, this.kyZ);
            }
            if (!this.Aop.equals("")) {
                vr += com.google.a.a.b.f(2, this.Aop);
            }
            if (this.vzt != 0) {
                vr += com.google.a.a.b.bt(3, this.vzt);
            }
            return this.Aoq != 0 ? vr + com.google.a.a.b.bt(4, this.Aoq) : vr;
        }

        public am() {
            this.kyZ = 0;
            this.Aop = "";
            this.vzt = 0;
            this.Aoq = 0;
            this.bxt = -1;
        }
    }

    public static final class at extends com.google.a.a.e {
        public byte[] AoK;
        public long AoL;
        public byte[] AoM;
        public byte[] AoN;
        public byte[] AoO;
        public ax AoP;
        public byte[] AoQ;
        public ap AoR;
        public String AoS;
        public String AoT;
        public long AoU;
        public byte[] AoV;
        public byte[] AoW;
        public byte[] AoX;
        public byte[] AoY;
        public int AoZ;
        public byte[] Apa;
        public byte[] Apb;
        public int Apc;
        public n[] Apd;
        public byte[] bFS;
        public int cAO;
        public String name;

        public at() {
            this.name = "";
            this.AoK = com.google.a.a.g.bxA;
            this.cAO = 0;
            this.AoL = 0;
            this.AoM = com.google.a.a.g.bxA;
            this.AoN = com.google.a.a.g.bxA;
            this.AoO = com.google.a.a.g.bxA;
            this.AoP = null;
            this.AoQ = com.google.a.a.g.bxA;
            this.AoR = null;
            this.AoS = "";
            this.AoT = "";
            this.AoU = 0;
            this.AoV = com.google.a.a.g.bxA;
            this.AoW = com.google.a.a.g.bxA;
            this.AoX = com.google.a.a.g.bxA;
            this.AoY = com.google.a.a.g.bxA;
            this.AoZ = 0;
            this.Apa = com.google.a.a.g.bxA;
            this.Apb = com.google.a.a.g.bxA;
            this.bFS = com.google.a.a.g.bxA;
            this.Apc = 0;
            this.Apd = n.dPA();
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.name.equals("")) {
                bVar.e(1, this.name);
            }
            if (!Arrays.equals(this.AoK, com.google.a.a.g.bxA)) {
                bVar.b(2, this.AoK);
            }
            if (this.cAO != 0) {
                bVar.bq(3, this.cAO);
            }
            if (this.AoL != 0) {
                bVar.l(4, this.AoL);
            }
            if (!Arrays.equals(this.AoM, com.google.a.a.g.bxA)) {
                bVar.b(5, this.AoM);
            }
            if (!Arrays.equals(this.AoN, com.google.a.a.g.bxA)) {
                bVar.b(6, this.AoN);
            }
            if (!Arrays.equals(this.AoO, com.google.a.a.g.bxA)) {
                bVar.b(7, this.AoO);
            }
            if (this.AoP != null) {
                bVar.a(8, this.AoP);
            }
            if (!Arrays.equals(this.AoQ, com.google.a.a.g.bxA)) {
                bVar.b(9, this.AoQ);
            }
            if (this.AoR != null) {
                bVar.a(10, this.AoR);
            }
            if (!this.AoS.equals("")) {
                bVar.e(100, this.AoS);
            }
            if (!this.AoT.equals("")) {
                bVar.e(101, this.AoT);
            }
            if (this.AoU != 0) {
                bVar.l(200, this.AoU);
            }
            if (!Arrays.equals(this.AoV, com.google.a.a.g.bxA)) {
                bVar.b(201, this.AoV);
            }
            if (!Arrays.equals(this.AoW, com.google.a.a.g.bxA)) {
                bVar.b(202, this.AoW);
            }
            if (!Arrays.equals(this.AoX, com.google.a.a.g.bxA)) {
                bVar.b(203, this.AoX);
            }
            if (!Arrays.equals(this.AoY, com.google.a.a.g.bxA)) {
                bVar.b(204, this.AoY);
            }
            if (this.AoZ != 0) {
                bVar.bq(220, this.AoZ);
            }
            if (!Arrays.equals(this.Apa, com.google.a.a.g.bxA)) {
                bVar.b(221, this.Apa);
            }
            if (!Arrays.equals(this.Apb, com.google.a.a.g.bxA)) {
                bVar.b(222, this.Apb);
            }
            if (!Arrays.equals(this.bFS, com.google.a.a.g.bxA)) {
                bVar.b(223, this.bFS);
            }
            if (this.Apc != 0) {
                bVar.br(224, this.Apc);
            }
            if (this.Apd != null && this.Apd.length > 0) {
                for (com.google.a.a.e eVar : this.Apd) {
                    if (eVar != null) {
                        bVar.a(225, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.name.equals("")) {
                vr += com.google.a.a.b.f(1, this.name);
            }
            if (!Arrays.equals(this.AoK, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(2, this.AoK);
            }
            if (this.cAO != 0) {
                vr += com.google.a.a.b.bs(3, this.cAO);
            }
            if (this.AoL != 0) {
                vr += com.google.a.a.b.n(4, this.AoL);
            }
            if (!Arrays.equals(this.AoM, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(5, this.AoM);
            }
            if (!Arrays.equals(this.AoN, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(6, this.AoN);
            }
            if (!Arrays.equals(this.AoO, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(7, this.AoO);
            }
            if (this.AoP != null) {
                vr += com.google.a.a.b.b(8, this.AoP);
            }
            if (!Arrays.equals(this.AoQ, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(9, this.AoQ);
            }
            if (this.AoR != null) {
                vr += com.google.a.a.b.b(10, this.AoR);
            }
            if (!this.AoS.equals("")) {
                vr += com.google.a.a.b.f(100, this.AoS);
            }
            if (!this.AoT.equals("")) {
                vr += com.google.a.a.b.f(101, this.AoT);
            }
            if (this.AoU != 0) {
                vr += com.google.a.a.b.n(200, this.AoU);
            }
            if (!Arrays.equals(this.AoV, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(201, this.AoV);
            }
            if (!Arrays.equals(this.AoW, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(202, this.AoW);
            }
            if (!Arrays.equals(this.AoX, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(203, this.AoX);
            }
            if (!Arrays.equals(this.AoY, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(204, this.AoY);
            }
            if (this.AoZ != 0) {
                vr += com.google.a.a.b.bs(220, this.AoZ);
            }
            if (!Arrays.equals(this.Apa, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(221, this.Apa);
            }
            if (!Arrays.equals(this.Apb, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(222, this.Apb);
            }
            if (!Arrays.equals(this.bFS, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(223, this.bFS);
            }
            if (this.Apc != 0) {
                vr += com.google.a.a.b.bt(224, this.Apc);
            }
            if (this.Apd == null || this.Apd.length <= 0) {
                return vr;
            }
            int i = vr;
            for (com.google.a.a.e eVar : this.Apd) {
                if (eVar != null) {
                    i += com.google.a.a.b.b(225, eVar);
                }
            }
            return i;
        }
    }

    public static final class au extends com.google.a.a.e {
        private static volatile au[] Ape;
        public int AmC;
        public av[] AnQ;
        public String Apf;
        public String groupId;
        public int sQS;
        public long sQT;

        public static au[] dPG() {
            if (Ape == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (Ape == null) {
                        Ape = new au[0];
                    }
                }
            }
            return Ape;
        }

        public au() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnQ = av.dPH();
            this.AmC = 0;
            this.Apf = "";
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (com.google.a.a.e eVar : this.AnQ) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.AmC != 0) {
                bVar.br(5, this.AmC);
            }
            if (!this.Apf.equals("")) {
                bVar.e(6, this.Apf);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                int i = vr;
                for (com.google.a.a.e eVar : this.AnQ) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                vr = i;
            }
            if (this.AmC != 0) {
                vr += com.google.a.a.b.bt(5, this.AmC);
            }
            if (this.Apf.equals("")) {
                return vr;
            }
            return vr + com.google.a.a.b.f(6, this.Apf);
        }
    }

    public static final class av extends com.google.a.a.e {
        private static volatile av[] Apg;
        public int AmI;
        public byte[] AmN;
        public String Aop;
        public int ApA;
        public int ApB;
        public int Aph;
        public int Api;
        public aq Apj;
        public int Apk;
        public String Apl;
        public ar[] Apm;
        public int Apn;
        public int[] Apo;
        public int App;
        public int Apq;
        public int Apr;
        public int Aps;
        public an Apt;
        public String Apu;
        public int Apv;
        public s Apw;
        public int Apx;
        public String Apy;
        public int Apz;
        public int boZ;
        public int kyZ;
        public int platform;
        public int status;
        public int tdt;
        public int vzt;

        public static av[] dPH() {
            if (Apg == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (Apg == null) {
                        Apg = new av[0];
                    }
                }
            }
            return Apg;
        }

        public av() {
            this.vzt = 0;
            this.Aph = 0;
            this.status = 0;
            this.boZ = 0;
            this.kyZ = -1;
            this.Api = 0;
            this.Apj = null;
            this.Apk = 0;
            this.Apl = "";
            this.Apm = ar.dPF();
            this.Apn = 0;
            this.Apo = com.google.a.a.g.bxu;
            this.App = 0;
            this.Apq = 0;
            this.Apr = 0;
            this.Aps = 0;
            this.Apt = null;
            this.Aop = "";
            this.Apu = "";
            this.Apv = 0;
            this.AmN = com.google.a.a.g.bxA;
            this.Apw = null;
            this.Apx = -1;
            this.Apy = "";
            this.platform = 0;
            this.Apz = 0;
            this.tdt = 0;
            this.ApA = 0;
            this.ApB = 0;
            this.AmI = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.vzt != 0) {
                bVar.br(1, this.vzt);
            }
            if (this.Aph != 0) {
                bVar.br(2, this.Aph);
            }
            if (this.status != 0) {
                bVar.br(3, this.status);
            }
            if (this.boZ != 0) {
                bVar.br(4, this.boZ);
            }
            if (this.kyZ != -1) {
                bVar.bq(5, this.kyZ);
            }
            if (this.Api != 0) {
                bVar.br(6, this.Api);
            }
            if (this.Apj != null) {
                bVar.a(7, this.Apj);
            }
            if (this.Apk != 0) {
                bVar.br(8, this.Apk);
            }
            if (!this.Apl.equals("")) {
                bVar.e(9, this.Apl);
            }
            if (this.Apm != null && this.Apm.length > 0) {
                for (com.google.a.a.e eVar : this.Apm) {
                    if (eVar != null) {
                        bVar.a(10, eVar);
                    }
                }
            }
            if (this.Apn != 0) {
                bVar.br(11, this.Apn);
            }
            if (this.Apo != null && this.Apo.length > 0) {
                while (i < this.Apo.length) {
                    bVar.br(12, this.Apo[i]);
                    i++;
                }
            }
            if (this.App != 0) {
                bVar.br(13, this.App);
            }
            if (this.Apq != 0) {
                bVar.br(14, this.Apq);
            }
            if (this.Apr != 0) {
                bVar.br(15, this.Apr);
            }
            if (this.Aps != 0) {
                bVar.br(16, this.Aps);
            }
            if (this.Apt != null) {
                bVar.a(17, this.Apt);
            }
            if (!this.Aop.equals("")) {
                bVar.e(100, this.Aop);
            }
            if (!this.Apu.equals("")) {
                bVar.e(101, this.Apu);
            }
            if (this.Apv != 0) {
                bVar.br(102, this.Apv);
            }
            if (!Arrays.equals(this.AmN, com.google.a.a.g.bxA)) {
                bVar.b(200, this.AmN);
            }
            if (this.Apw != null) {
                bVar.a(201, this.Apw);
            }
            if (this.Apx != -1) {
                bVar.bq(202, this.Apx);
            }
            if (!this.Apy.equals("")) {
                bVar.e(203, this.Apy);
            }
            if (this.platform != 0) {
                bVar.bq(204, this.platform);
            }
            if (this.Apz != 0) {
                bVar.br(205, this.Apz);
            }
            if (this.tdt != 0) {
                bVar.br(206, this.tdt);
            }
            if (this.ApA != 0) {
                bVar.br(207, this.ApA);
            }
            if (this.ApB != 0) {
                bVar.br(208, this.ApB);
            }
            if (this.AmI != 0) {
                bVar.br(240, this.AmI);
            }
            super.a(bVar);
        }

        public final int vr() {
            int i;
            int vr = super.vr();
            if (this.vzt != 0) {
                vr += com.google.a.a.b.bt(1, this.vzt);
            }
            if (this.Aph != 0) {
                vr += com.google.a.a.b.bt(2, this.Aph);
            }
            if (this.status != 0) {
                vr += com.google.a.a.b.bt(3, this.status);
            }
            if (this.boZ != 0) {
                vr += com.google.a.a.b.bt(4, this.boZ);
            }
            if (this.kyZ != -1) {
                vr += com.google.a.a.b.bs(5, this.kyZ);
            }
            if (this.Api != 0) {
                vr += com.google.a.a.b.bt(6, this.Api);
            }
            if (this.Apj != null) {
                vr += com.google.a.a.b.b(7, this.Apj);
            }
            if (this.Apk != 0) {
                vr += com.google.a.a.b.bt(8, this.Apk);
            }
            if (!this.Apl.equals("")) {
                vr += com.google.a.a.b.f(9, this.Apl);
            }
            if (this.Apm != null && this.Apm.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar : this.Apm) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(10, eVar);
                    }
                }
                vr = i;
            }
            if (this.Apn != 0) {
                vr += com.google.a.a.b.bt(11, this.Apn);
            }
            if (this.Apo != null && this.Apo.length > 0) {
                i = 0;
                for (int fx : this.Apo) {
                    i += com.google.a.a.b.fx(fx);
                }
                vr = (vr + i) + (this.Apo.length * 1);
            }
            if (this.App != 0) {
                vr += com.google.a.a.b.bt(13, this.App);
            }
            if (this.Apq != 0) {
                vr += com.google.a.a.b.bt(14, this.Apq);
            }
            if (this.Apr != 0) {
                vr += com.google.a.a.b.bt(15, this.Apr);
            }
            if (this.Aps != 0) {
                vr += com.google.a.a.b.bt(16, this.Aps);
            }
            if (this.Apt != null) {
                vr += com.google.a.a.b.b(17, this.Apt);
            }
            if (!this.Aop.equals("")) {
                vr += com.google.a.a.b.f(100, this.Aop);
            }
            if (!this.Apu.equals("")) {
                vr += com.google.a.a.b.f(101, this.Apu);
            }
            if (this.Apv != 0) {
                vr += com.google.a.a.b.bt(102, this.Apv);
            }
            if (!Arrays.equals(this.AmN, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(200, this.AmN);
            }
            if (this.Apw != null) {
                vr += com.google.a.a.b.b(201, this.Apw);
            }
            if (this.Apx != -1) {
                vr += com.google.a.a.b.bs(202, this.Apx);
            }
            if (!this.Apy.equals("")) {
                vr += com.google.a.a.b.f(203, this.Apy);
            }
            if (this.platform != 0) {
                vr += com.google.a.a.b.bs(204, this.platform);
            }
            if (this.Apz != 0) {
                vr += com.google.a.a.b.bt(205, this.Apz);
            }
            if (this.tdt != 0) {
                vr += com.google.a.a.b.bt(206, this.tdt);
            }
            if (this.ApA != 0) {
                vr += com.google.a.a.b.bt(207, this.ApA);
            }
            if (this.ApB != 0) {
                vr += com.google.a.a.b.bt(208, this.ApB);
            }
            if (this.AmI != 0) {
                return vr + com.google.a.a.b.bt(240, this.AmI);
            }
            return vr;
        }
    }

    public static final class aw extends com.google.a.a.e {
        private static volatile aw[] ApC;
        public long ApD;
        public String ApE;
        public String ApF;
        public String pHn;
        public String username;
        public int vzt;

        public static aw[] dPI() {
            if (ApC == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (ApC == null) {
                        ApC = new aw[0];
                    }
                }
            }
            return ApC;
        }

        public aw() {
            this.vzt = 0;
            this.username = "";
            this.pHn = "";
            this.ApD = 0;
            this.ApE = "";
            this.ApF = "";
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.vzt != 0) {
                bVar.br(1, this.vzt);
            }
            if (!this.username.equals("")) {
                bVar.e(2, this.username);
            }
            if (!this.pHn.equals("")) {
                bVar.e(3, this.pHn);
            }
            if (this.ApD != 0) {
                bVar.l(4, this.ApD);
            }
            if (!this.ApE.equals("")) {
                bVar.e(5, this.ApE);
            }
            if (!this.ApF.equals("")) {
                bVar.e(6, this.ApF);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.vzt != 0) {
                vr += com.google.a.a.b.bt(1, this.vzt);
            }
            if (!this.username.equals("")) {
                vr += com.google.a.a.b.f(2, this.username);
            }
            if (!this.pHn.equals("")) {
                vr += com.google.a.a.b.f(3, this.pHn);
            }
            if (this.ApD != 0) {
                vr += com.google.a.a.b.n(4, this.ApD);
            }
            if (!this.ApE.equals("")) {
                vr += com.google.a.a.b.f(5, this.ApE);
            }
            if (this.ApF.equals("")) {
                return vr;
            }
            return vr + com.google.a.a.b.f(6, this.ApF);
        }
    }

    public static final class ax extends com.google.a.a.e {
        public int ApG;

        public ax() {
            this.ApG = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.ApG != 0) {
                bVar.br(1, this.ApG);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.ApG != 0) {
                return vr + com.google.a.a.b.bt(1, this.ApG);
            }
            return vr;
        }
    }

    public static final class f extends com.google.a.a.e {
        public int AmM;
        public int boZ;
        public String groupId;
        public int sQS;
        public long sQT;

        public f() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.boZ = 0;
            this.AmM = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.boZ != 0) {
                bVar.bq(4, this.boZ);
            }
            if (this.AmM != 0) {
                bVar.bq(5, this.AmM);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.boZ != 0) {
                vr += com.google.a.a.b.bs(4, this.boZ);
            }
            if (this.AmM != 0) {
                return vr + com.google.a.a.b.bs(5, this.AmM);
            }
            return vr;
        }
    }

    public static final class p extends com.google.a.a.e {
        public int AmC;
        public ay AmE;
        public at Amz;
        public int Anb;
        public aw[] Anc;
        public av[] And;
        public as Ane;
        public int Anf;
        public int Ang;
        public int Anh;
        public byte[] Ani;
        public byte[] Anj;
        public av[] Ank;
        public long cvx;
        public String groupId;
        public int sQS;
        public long sQT;

        public p() {
            this.Anb = 0;
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmC = 0;
            this.Amz = null;
            this.Anc = aw.dPI();
            this.And = av.dPH();
            this.Ane = null;
            this.AmE = null;
            this.Anf = 0;
            this.Ang = 0;
            this.cvx = 0;
            this.Anh = 0;
            this.Ani = com.google.a.a.g.bxA;
            this.Anj = com.google.a.a.g.bxA;
            this.Ank = av.dPH();
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.Anb != 0) {
                bVar.bq(1, this.Anb);
            }
            if (!this.groupId.equals("")) {
                bVar.e(2, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(3, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(4, this.sQT);
            }
            if (this.AmC != 0) {
                bVar.br(5, this.AmC);
            }
            if (this.Amz != null) {
                bVar.a(6, this.Amz);
            }
            if (this.Anc != null && this.Anc.length > 0) {
                for (com.google.a.a.e eVar : this.Anc) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (this.And != null && this.And.length > 0) {
                for (com.google.a.a.e eVar2 : this.And) {
                    if (eVar2 != null) {
                        bVar.a(8, eVar2);
                    }
                }
            }
            if (this.Ane != null) {
                bVar.a(9, this.Ane);
            }
            if (this.AmE != null) {
                bVar.a(10, this.AmE);
            }
            if (this.Anf != 0) {
                bVar.br(11, this.Anf);
            }
            if (this.Ang != 0) {
                bVar.br(12, this.Ang);
            }
            if (this.cvx != 0) {
                bVar.l(101, this.cvx);
            }
            if (this.Anh != 0) {
                bVar.br(102, this.Anh);
            }
            if (!Arrays.equals(this.Ani, com.google.a.a.g.bxA)) {
                bVar.b(103, this.Ani);
            }
            if (!Arrays.equals(this.Anj, com.google.a.a.g.bxA)) {
                bVar.b(200, this.Anj);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i < this.Ank.length) {
                    com.google.a.a.e eVar3 = this.Ank[i];
                    if (eVar3 != null) {
                        bVar.a(201, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        public final int vr() {
            int i;
            int i2 = 0;
            int vr = super.vr();
            if (this.Anb != 0) {
                vr += com.google.a.a.b.bs(1, this.Anb);
            }
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(2, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(3, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(4, this.sQT);
            }
            if (this.AmC != 0) {
                vr += com.google.a.a.b.bt(5, this.AmC);
            }
            if (this.Amz != null) {
                vr += com.google.a.a.b.b(6, this.Amz);
            }
            if (this.Anc != null && this.Anc.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar : this.Anc) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(7, eVar);
                    }
                }
                vr = i;
            }
            if (this.And != null && this.And.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar2 : this.And) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(8, eVar2);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += com.google.a.a.b.b(9, this.Ane);
            }
            if (this.AmE != null) {
                vr += com.google.a.a.b.b(10, this.AmE);
            }
            if (this.Anf != 0) {
                vr += com.google.a.a.b.bt(11, this.Anf);
            }
            if (this.Ang != 0) {
                vr += com.google.a.a.b.bt(12, this.Ang);
            }
            if (this.cvx != 0) {
                vr += com.google.a.a.b.n(101, this.cvx);
            }
            if (this.Anh != 0) {
                vr += com.google.a.a.b.bt(102, this.Anh);
            }
            if (!Arrays.equals(this.Ani, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(103, this.Ani);
            }
            if (!Arrays.equals(this.Anj, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(200, this.Anj);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i2 < this.Ank.length) {
                    com.google.a.a.e eVar3 = this.Ank[i2];
                    if (eVar3 != null) {
                        vr += com.google.a.a.b.b(201, eVar3);
                    }
                    i2++;
                }
            }
            return vr;
        }
    }

    public static final class q extends com.google.a.a.e {
        public int Anl;

        public final void a(com.google.a.a.b bVar) {
            bVar.br(1, this.Anl);
            super.a(bVar);
        }

        public final int vr() {
            return super.vr() + com.google.a.a.b.bt(1, this.Anl);
        }

        public q() {
            this.Anl = 0;
            this.bxt = -1;
        }
    }

    public static final class v extends com.google.a.a.e {
        public u AnM;
        public byte[] body;

        public v() {
            this.AnM = null;
            this.body = com.google.a.a.g.bxA;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.AnM != null) {
                bVar.a(1, this.AnM);
            }
            if (!Arrays.equals(this.body, com.google.a.a.g.bxA)) {
                bVar.b(2, this.body);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.AnM != null) {
                vr += com.google.a.a.b.b(1, this.AnM);
            }
            if (Arrays.equals(this.body, com.google.a.a.g.bxA)) {
                return vr;
            }
            return vr + com.google.a.a.b.c(2, this.body);
        }
    }

    public static final class x extends com.google.a.a.e {
        public at Amz;
        public av[] AnQ;
        public String groupId;
        public int sQS;
        public long sQT;

        public x() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnQ = av.dPH();
            this.Amz = null;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (com.google.a.a.e eVar : this.AnQ) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.Amz != null) {
                bVar.a(5, this.Amz);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                int i = vr;
                for (com.google.a.a.e eVar : this.AnQ) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                vr = i;
            }
            if (this.Amz != null) {
                return vr + com.google.a.a.b.b(5, this.Amz);
            }
            return vr;
        }
    }

    public static final class y extends com.google.a.a.e {
        public String Amx;

        public y() {
            this.Amx = "";
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.Amx.equals("")) {
                bVar.e(1, this.Amx);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.Amx.equals("")) {
                return vr;
            }
            return vr + com.google.a.a.b.f(1, this.Amx);
        }
    }

    public static final class al extends com.google.a.a.e {
        public byte[] buffer;
        public int iLen;

        public al() {
            this.iLen = 0;
            this.buffer = com.google.a.a.g.bxA;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            bVar.br(1, this.iLen);
            if (!Arrays.equals(this.buffer, com.google.a.a.g.bxA)) {
                bVar.b(2, this.buffer);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr() + com.google.a.a.b.bt(1, this.iLen);
            if (Arrays.equals(this.buffer, com.google.a.a.g.bxA)) {
                return vr;
            }
            return vr + com.google.a.a.b.c(2, this.buffer);
        }
    }

    public static final class an extends com.google.a.a.e {
        public int Aor;
        public long fNf;
        public int fQi;

        public an() {
            this.fNf = 0;
            this.fQi = 0;
            this.Aor = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.fNf != 0) {
                bVar.l(1, this.fNf);
            }
            if (this.fQi != 0) {
                bVar.br(2, this.fQi);
            }
            if (this.Aor != 0) {
                bVar.br(3, this.Aor);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.fNf != 0) {
                vr += com.google.a.a.b.n(1, this.fNf);
            }
            if (this.fQi != 0) {
                vr += com.google.a.a.b.bt(2, this.fQi);
            }
            if (this.Aor != 0) {
                return vr + com.google.a.a.b.bt(3, this.Aor);
            }
            return vr;
        }
    }

    public static final class ba extends com.google.a.a.e {
        public al ApN;
        public int type;

        public ba() {
            this.type = 0;
            this.ApN = null;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.type != 0) {
                bVar.bq(1, this.type);
            }
            if (this.ApN != null) {
                bVar.a(2, this.ApN);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.type != 0) {
                vr += com.google.a.a.b.bs(1, this.type);
            }
            if (this.ApN != null) {
                return vr + com.google.a.a.b.b(2, this.ApN);
            }
            return vr;
        }
    }

    public static final class e extends com.google.a.a.e {
        public ba AmB;
        public int AmD;
        public String[] AmG;
        public m[] AmH;
        public int AmI;
        public int AmJ;
        public s AmK;
        public int AmL;
        public int Amv;
        public at Amz;
        public String groupId;
        public int netType;
        public int sQS;
        public long sQT;

        public e() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmB = null;
            this.AmJ = 0;
            this.AmD = 0;
            this.Amv = 0;
            this.netType = 0;
            this.Amz = null;
            this.AmG = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.AmH = m.dPz();
            this.AmK = null;
            this.AmL = 0;
            this.AmI = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.AmB != null) {
                bVar.a(4, this.AmB);
            }
            if (this.AmJ != 0) {
                bVar.bq(5, this.AmJ);
            }
            if (this.AmD != 0) {
                bVar.br(6, this.AmD);
            }
            if (this.Amv != 0) {
                bVar.bq(7, this.Amv);
            }
            if (this.netType != 0) {
                bVar.br(8, this.netType);
            }
            if (this.Amz != null) {
                bVar.a(200, this.Amz);
            }
            if (this.AmG != null && this.AmG.length > 0) {
                for (String str : this.AmG) {
                    if (str != null) {
                        bVar.e(201, str);
                    }
                }
            }
            if (this.AmH != null && this.AmH.length > 0) {
                while (i < this.AmH.length) {
                    com.google.a.a.e eVar = this.AmH[i];
                    if (eVar != null) {
                        bVar.a(202, eVar);
                    }
                    i++;
                }
            }
            if (this.AmK != null) {
                bVar.a(203, this.AmK);
            }
            if (this.AmL != 0) {
                bVar.br(204, this.AmL);
            }
            if (this.AmI != 0) {
                bVar.br(240, this.AmI);
            }
            super.a(bVar);
        }

        public final int vr() {
            int i = 0;
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.AmB != null) {
                vr += com.google.a.a.b.b(4, this.AmB);
            }
            if (this.AmJ != 0) {
                vr += com.google.a.a.b.bs(5, this.AmJ);
            }
            if (this.AmD != 0) {
                vr += com.google.a.a.b.bt(6, this.AmD);
            }
            if (this.Amv != 0) {
                vr += com.google.a.a.b.bs(7, this.Amv);
            }
            if (this.netType != 0) {
                vr += com.google.a.a.b.bt(8, this.netType);
            }
            if (this.Amz != null) {
                vr += com.google.a.a.b.b(200, this.Amz);
            }
            if (this.AmG != null && this.AmG.length > 0) {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.AmG) {
                    if (str != null) {
                        i3++;
                        i2 += com.google.a.a.b.bf(str);
                    }
                }
                vr = (vr + i2) + (i3 * 2);
            }
            if (this.AmH != null && this.AmH.length > 0) {
                while (i < this.AmH.length) {
                    com.google.a.a.e eVar = this.AmH[i];
                    if (eVar != null) {
                        vr += com.google.a.a.b.b(202, eVar);
                    }
                    i++;
                }
            }
            if (this.AmK != null) {
                vr += com.google.a.a.b.b(203, this.AmK);
            }
            if (this.AmL != 0) {
                vr += com.google.a.a.b.bt(204, this.AmL);
            }
            if (this.AmI != 0) {
                return vr + com.google.a.a.b.bt(240, this.AmI);
            }
            return vr;
        }
    }

    public static final class g extends com.google.a.a.e {
        public String Amx;
        public int boZ;
        public String groupId;
        public int sQS;
        public long sQT;

        public g() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.boZ = 0;
            this.Amx = "";
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.boZ != 0) {
                bVar.bq(4, this.boZ);
            }
            if (!this.Amx.equals("")) {
                bVar.e(5, this.Amx);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.boZ != 0) {
                vr += com.google.a.a.b.bs(4, this.boZ);
            }
            if (this.Amx.equals("")) {
                return vr;
            }
            return vr + com.google.a.a.b.f(5, this.Amx);
        }
    }

    public static final class n extends com.google.a.a.e {
        private static volatile n[] AmW;
        public int AmX;
        public int AmY;
        public byte[] cDT;

        public static n[] dPA() {
            if (AmW == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (AmW == null) {
                        AmW = new n[0];
                    }
                }
            }
            return AmW;
        }

        public n() {
            this.AmX = 0;
            this.cDT = com.google.a.a.g.bxA;
            this.AmY = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.AmX != 0) {
                bVar.bq(1, this.AmX);
            }
            if (!Arrays.equals(this.cDT, com.google.a.a.g.bxA)) {
                bVar.b(2, this.cDT);
            }
            if (this.AmY != 0) {
                bVar.br(3, this.AmY);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.AmX != 0) {
                vr += com.google.a.a.b.bs(1, this.AmX);
            }
            if (!Arrays.equals(this.cDT, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(2, this.cDT);
            }
            if (this.AmY != 0) {
                return vr + com.google.a.a.b.bt(3, this.AmY);
            }
            return vr;
        }
    }

    public static final class z extends com.google.a.a.e {
        public int AmC;
        public int AmX;
        public String Amx;
        public at Amz;
        public o[] AnR;
        public aw[] AnS;
        public int AnT;
        public int[] AnU;
        public o[] AnV;
        public int AnW;
        public int AnX;
        public o[] AnY;
        public int AnZ;
        public av[] And;
        public as Ane;
        public int Ang;
        public av[] Ank;
        public int Aoa;
        public int Aob;
        public byte[] Aoc;
        public int[] Aod;
        public String groupId;
        public int sQS;
        public long sQT;
        public int wbi;

        public z() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmC = 0;
            this.AnR = o.dPB();
            this.AnS = aw.dPI();
            this.Ane = null;
            this.Amx = "";
            this.And = av.dPH();
            this.AnT = 0;
            this.AnU = com.google.a.a.g.bxu;
            this.Amz = null;
            this.AmX = 0;
            this.AnV = o.dPB();
            this.AnW = 0;
            this.AnX = 0;
            this.Ank = av.dPH();
            this.AnY = o.dPB();
            this.AnZ = 0;
            this.Aoa = 0;
            this.Aob = 0;
            this.Aoc = com.google.a.a.g.bxA;
            this.wbi = -1;
            this.Aod = com.google.a.a.g.bxu;
            this.Ang = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.AmC != 0) {
                bVar.br(4, this.AmC);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                for (com.google.a.a.e eVar : this.AnR) {
                    if (eVar != null) {
                        bVar.a(5, eVar);
                    }
                }
            }
            if (this.AnS != null && this.AnS.length > 0) {
                for (com.google.a.a.e eVar2 : this.AnS) {
                    if (eVar2 != null) {
                        bVar.a(6, eVar2);
                    }
                }
            }
            if (this.Ane != null) {
                bVar.a(7, this.Ane);
            }
            if (!this.Amx.equals("")) {
                bVar.e(8, this.Amx);
            }
            if (this.And != null && this.And.length > 0) {
                for (com.google.a.a.e eVar22 : this.And) {
                    if (eVar22 != null) {
                        bVar.a(9, eVar22);
                    }
                }
            }
            if (this.AnT != 0) {
                bVar.bq(10, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                for (int bq : this.AnU) {
                    bVar.bq(11, bq);
                }
            }
            if (this.Amz != null) {
                bVar.a(12, this.Amz);
            }
            if (this.AmX != 0) {
                bVar.br(13, this.AmX);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                for (com.google.a.a.e eVar222 : this.AnV) {
                    if (eVar222 != null) {
                        bVar.a(14, eVar222);
                    }
                }
            }
            if (this.AnW != 0) {
                bVar.br(15, this.AnW);
            }
            if (this.AnX != 0) {
                bVar.br(16, this.AnX);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                for (com.google.a.a.e eVar2222 : this.Ank) {
                    if (eVar2222 != null) {
                        bVar.a(17, eVar2222);
                    }
                }
            }
            if (this.AnY != null && this.AnY.length > 0) {
                for (com.google.a.a.e eVar22222 : this.AnY) {
                    if (eVar22222 != null) {
                        bVar.a(18, eVar22222);
                    }
                }
            }
            if (this.AnZ != 0) {
                bVar.bq(19, this.AnZ);
            }
            if (this.Aoa != 0) {
                bVar.bq(20, this.Aoa);
            }
            if (this.Aob != 0) {
                bVar.bq(21, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, com.google.a.a.g.bxA)) {
                bVar.b(22, this.Aoc);
            }
            if (this.wbi != -1) {
                bVar.bq(23, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                while (i < this.Aod.length) {
                    bVar.br(24, this.Aod[i]);
                    i++;
                }
            }
            if (this.Ang != 0) {
                bVar.br(25, this.Ang);
            }
            super.a(bVar);
        }

        public final int vr() {
            int i;
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.AmC != 0) {
                vr += com.google.a.a.b.bt(4, this.AmC);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar : this.AnR) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(5, eVar);
                    }
                }
                vr = i;
            }
            if (this.AnS != null && this.AnS.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar2 : this.AnS) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(6, eVar2);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += com.google.a.a.b.b(7, this.Ane);
            }
            if (!this.Amx.equals("")) {
                vr += com.google.a.a.b.f(8, this.Amx);
            }
            if (this.And != null && this.And.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar22 : this.And) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(9, eVar22);
                    }
                }
                vr = i;
            }
            if (this.AnT != 0) {
                vr += com.google.a.a.b.bs(10, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                i = 0;
                for (int ft : this.AnU) {
                    i += com.google.a.a.b.ft(ft);
                }
                vr = (vr + i) + (this.AnU.length * 1);
            }
            if (this.Amz != null) {
                vr += com.google.a.a.b.b(12, this.Amz);
            }
            if (this.AmX != 0) {
                vr += com.google.a.a.b.bt(13, this.AmX);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar222 : this.AnV) {
                    if (eVar222 != null) {
                        i += com.google.a.a.b.b(14, eVar222);
                    }
                }
                vr = i;
            }
            if (this.AnW != 0) {
                vr += com.google.a.a.b.bt(15, this.AnW);
            }
            if (this.AnX != 0) {
                vr += com.google.a.a.b.bt(16, this.AnX);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar2222 : this.Ank) {
                    if (eVar2222 != null) {
                        i += com.google.a.a.b.b(17, eVar2222);
                    }
                }
                vr = i;
            }
            if (this.AnY != null && this.AnY.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar22222 : this.AnY) {
                    if (eVar22222 != null) {
                        i += com.google.a.a.b.b(18, eVar22222);
                    }
                }
                vr = i;
            }
            if (this.AnZ != 0) {
                vr += com.google.a.a.b.bs(19, this.AnZ);
            }
            if (this.Aoa != 0) {
                vr += com.google.a.a.b.bs(20, this.Aoa);
            }
            if (this.Aob != 0) {
                vr += com.google.a.a.b.bs(21, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(22, this.Aoc);
            }
            if (this.wbi != -1) {
                vr += com.google.a.a.b.bs(23, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                i = 0;
                for (int fx : this.Aod) {
                    i += com.google.a.a.b.fx(fx);
                }
                vr = (vr + i) + (this.Aod.length * 2);
            }
            if (this.Ang != 0) {
                return vr + com.google.a.a.b.bt(25, this.Ang);
            }
            return vr;
        }
    }

    public static final class a extends com.google.a.a.e {
        public int[] Amu;
        public int Amv;
        public String[] Amw;
        public String groupId;
        public int sQS;
        public long sQT;

        public a() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.Amu = com.google.a.a.g.bxu;
            this.Amv = 0;
            this.Amw = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.Amu != null && this.Amu.length > 0) {
                for (int br : this.Amu) {
                    bVar.br(4, br);
                }
            }
            if (this.Amv != 0) {
                bVar.bq(5, this.Amv);
            }
            if (this.Amw != null && this.Amw.length > 0) {
                while (i < this.Amw.length) {
                    String str = this.Amw[i];
                    if (str != null) {
                        bVar.e(100, str);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        public final int vr() {
            int i;
            int i2;
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.Amu != null && this.Amu.length > 0) {
                i = 0;
                for (int i22 : this.Amu) {
                    i += com.google.a.a.b.fx(i22);
                }
                vr = (vr + i) + (this.Amu.length * 1);
            }
            if (this.Amv != 0) {
                vr += com.google.a.a.b.bs(5, this.Amv);
            }
            if (this.Amw == null || this.Amw.length <= 0) {
                return vr;
            }
            i = 0;
            i22 = 0;
            for (String str : this.Amw) {
                if (str != null) {
                    i22++;
                    i += com.google.a.a.b.bf(str);
                }
            }
            return (vr + i) + (i22 * 2);
        }
    }

    public static final class ab extends com.google.a.a.e {
        public String groupId;
        public int sQS;
        public long sQT;

        public ab() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                return vr + com.google.a.a.b.o(3, this.sQT);
            }
            return vr;
        }
    }

    public static final class ae extends com.google.a.a.e {
        public int nwu;
        public long nwv;

        public final void a(com.google.a.a.b bVar) {
            if (this.nwu != 0) {
                bVar.bq(1, this.nwu);
            }
            if (this.nwv != 0) {
                bVar.m(2, this.nwv);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.nwu != 0) {
                vr += com.google.a.a.b.bs(1, this.nwu);
            }
            return this.nwv != 0 ? vr + com.google.a.a.b.o(2, this.nwv) : vr;
        }

        public ae() {
            this.nwu = 0;
            this.nwv = 0;
            this.bxt = -1;
        }
    }

    public static final class ah extends com.google.a.a.e {
        public au[] Aon;

        public ah() {
            this.Aon = au.dPG();
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.Aon != null && this.Aon.length > 0) {
                for (com.google.a.a.e eVar : this.Aon) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.Aon != null && this.Aon.length > 0) {
                for (com.google.a.a.e eVar : this.Aon) {
                    if (eVar != null) {
                        vr += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return vr;
        }
    }

    public static final class b extends com.google.a.a.e {
        public String Amx;
        public int boZ;

        public b() {
            this.Amx = "";
            this.boZ = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.Amx.equals("")) {
                bVar.e(1, this.Amx);
            }
            if (this.boZ != 0) {
                bVar.bq(2, this.boZ);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.Amx.equals("")) {
                vr += com.google.a.a.b.f(1, this.Amx);
            }
            if (this.boZ != 0) {
                return vr + com.google.a.a.b.bs(2, this.boZ);
            }
            return vr;
        }
    }

    public static final class bb extends com.google.a.a.e {
        public int AmC;
        public av[] AnQ;
        public int ApO;
        public String ApP;
        public String[] ApQ;
        public long ApR;
        public String Apf;
        public String groupId;
        public int sQS;
        public long sQT;

        public bb() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmC = 0;
            this.ApO = 0;
            this.Apf = "";
            this.AnQ = av.dPH();
            this.ApP = "";
            this.ApQ = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.ApR = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.AmC != 0) {
                bVar.br(4, this.AmC);
            }
            if (this.ApO != 0) {
                bVar.bq(5, this.ApO);
            }
            if (!this.Apf.equals("")) {
                bVar.e(6, this.Apf);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (com.google.a.a.e eVar : this.AnQ) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (!this.ApP.equals("")) {
                bVar.e(8, this.ApP);
            }
            if (this.ApQ != null && this.ApQ.length > 0) {
                while (i < this.ApQ.length) {
                    String str = this.ApQ[i];
                    if (str != null) {
                        bVar.e(9, str);
                    }
                    i++;
                }
            }
            if (this.ApR != 0) {
                bVar.l(10, this.ApR);
            }
            super.a(bVar);
        }

        public final int vr() {
            int i;
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.AmC != 0) {
                vr += com.google.a.a.b.bt(4, this.AmC);
            }
            if (this.ApO != 0) {
                vr += com.google.a.a.b.bs(5, this.ApO);
            }
            if (!this.Apf.equals("")) {
                vr += com.google.a.a.b.f(6, this.Apf);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar : this.AnQ) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(7, eVar);
                    }
                }
                vr = i;
            }
            if (!this.ApP.equals("")) {
                vr += com.google.a.a.b.f(8, this.ApP);
            }
            if (this.ApQ != null && this.ApQ.length > 0) {
                i = 0;
                int i2 = 0;
                for (String str : this.ApQ) {
                    if (str != null) {
                        i2++;
                        i += com.google.a.a.b.bf(str);
                    }
                }
                vr = (vr + i) + (i2 * 1);
            }
            if (this.ApR != 0) {
                return vr + com.google.a.a.b.n(10, this.ApR);
            }
            return vr;
        }
    }

    public static final class c extends com.google.a.a.e {
        public w[] Amy;

        public c() {
            this.Amy = w.dPC();
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.Amy != null && this.Amy.length > 0) {
                for (com.google.a.a.e eVar : this.Amy) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.Amy != null && this.Amy.length > 0) {
                for (com.google.a.a.e eVar : this.Amy) {
                    if (eVar != null) {
                        vr += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return vr;
        }
    }

    public static final class d extends com.google.a.a.e {
        public int[] AmA;
        public ba AmB;
        public int AmC;
        public int AmD;
        public ay AmE;
        public String AmF;
        public String[] AmG;
        public m[] AmH;
        public int AmI;
        public String Amx;
        public at Amz;
        public int netType;

        public d() {
            this.Amz = null;
            this.AmA = com.google.a.a.g.bxu;
            this.AmB = null;
            this.AmC = 0;
            this.AmD = 0;
            this.AmE = null;
            this.Amx = "";
            this.AmF = "";
            this.netType = 0;
            this.AmG = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.AmH = m.dPz();
            this.AmI = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.Amz != null) {
                bVar.a(1, this.Amz);
            }
            if (this.AmA != null && this.AmA.length > 0) {
                for (int br : this.AmA) {
                    bVar.br(2, br);
                }
            }
            if (this.AmB != null) {
                bVar.a(3, this.AmB);
            }
            if (this.AmC != 0) {
                bVar.br(4, this.AmC);
            }
            if (this.AmD != 0) {
                bVar.br(5, this.AmD);
            }
            if (this.AmE != null) {
                bVar.a(6, this.AmE);
            }
            if (!this.Amx.equals("")) {
                bVar.e(7, this.Amx);
            }
            if (!this.AmF.equals("")) {
                bVar.e(8, this.AmF);
            }
            if (this.netType != 0) {
                bVar.br(9, this.netType);
            }
            if (this.AmG != null && this.AmG.length > 0) {
                for (String str : this.AmG) {
                    if (str != null) {
                        bVar.e(100, str);
                    }
                }
            }
            if (this.AmH != null && this.AmH.length > 0) {
                while (i < this.AmH.length) {
                    com.google.a.a.e eVar = this.AmH[i];
                    if (eVar != null) {
                        bVar.a(202, eVar);
                    }
                    i++;
                }
            }
            if (this.AmI != 0) {
                bVar.br(240, this.AmI);
            }
            super.a(bVar);
        }

        public final int vr() {
            int i;
            int i2;
            int i3 = 0;
            int vr = super.vr();
            if (this.Amz != null) {
                vr += com.google.a.a.b.b(1, this.Amz);
            }
            if (this.AmA != null && this.AmA.length > 0) {
                i = 0;
                for (int i22 : this.AmA) {
                    i += com.google.a.a.b.fx(i22);
                }
                vr = (vr + i) + (this.AmA.length * 1);
            }
            if (this.AmB != null) {
                vr += com.google.a.a.b.b(3, this.AmB);
            }
            if (this.AmC != 0) {
                vr += com.google.a.a.b.bt(4, this.AmC);
            }
            if (this.AmD != 0) {
                vr += com.google.a.a.b.bt(5, this.AmD);
            }
            if (this.AmE != null) {
                vr += com.google.a.a.b.b(6, this.AmE);
            }
            if (!this.Amx.equals("")) {
                vr += com.google.a.a.b.f(7, this.Amx);
            }
            if (!this.AmF.equals("")) {
                vr += com.google.a.a.b.f(8, this.AmF);
            }
            if (this.netType != 0) {
                vr += com.google.a.a.b.bt(9, this.netType);
            }
            if (this.AmG != null && this.AmG.length > 0) {
                i = 0;
                i22 = 0;
                for (String str : this.AmG) {
                    if (str != null) {
                        i22++;
                        i += com.google.a.a.b.bf(str);
                    }
                }
                vr = (vr + i) + (i22 * 2);
            }
            if (this.AmH != null && this.AmH.length > 0) {
                while (i3 < this.AmH.length) {
                    com.google.a.a.e eVar = this.AmH[i3];
                    if (eVar != null) {
                        vr += com.google.a.a.b.b(202, eVar);
                    }
                    i3++;
                }
            }
            if (this.AmI != 0) {
                return vr + com.google.a.a.b.bt(240, this.AmI);
            }
            return vr;
        }
    }

    public static final class w extends com.google.a.a.e {
        private static volatile w[] AnN;
        public String AnO;
        public String AnP;

        public static w[] dPC() {
            if (AnN == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (AnN == null) {
                        AnN = new w[0];
                    }
                }
            }
            return AnN;
        }

        public w() {
            this.AnO = "";
            this.AnP = "";
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.AnO.equals("")) {
                bVar.e(1, this.AnO);
            }
            if (!this.AnP.equals("")) {
                bVar.e(2, this.AnP);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.AnO.equals("")) {
                vr += com.google.a.a.b.f(1, this.AnO);
            }
            if (this.AnP.equals("")) {
                return vr;
            }
            return vr + com.google.a.a.b.f(2, this.AnP);
        }
    }

    public static final class aa extends com.google.a.a.e {
        public int AmJ;
        public int AmX;
        public at Amz;
        public av[] AnQ;
        public o[] AnR;
        public aw[] AnS;
        public int AnT;
        public int[] AnU;
        public o[] AnV;
        public int AnW;
        public int AnX;
        public o[] AnY;
        public int AnZ;
        public as Ane;
        public int Ang;
        public av[] Ank;
        public int Aoa;
        public int Aob;
        public byte[] Aoc;
        public int[] Aod;
        public String groupId;
        public int sQS;
        public long sQT;
        public int wbi;

        public aa() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnR = o.dPB();
            this.AnQ = av.dPH();
            this.Ane = null;
            this.AnT = 0;
            this.AnU = com.google.a.a.g.bxu;
            this.AmJ = 0;
            this.AnS = aw.dPI();
            this.Amz = null;
            this.AmX = 0;
            this.AnV = o.dPB();
            this.AnY = o.dPB();
            this.AnZ = 0;
            this.Aoa = 0;
            this.Aob = 0;
            this.Aoc = com.google.a.a.g.bxA;
            this.wbi = -1;
            this.Aod = com.google.a.a.g.bxu;
            this.Ang = 0;
            this.AnW = 0;
            this.AnX = 0;
            this.Ank = av.dPH();
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                for (com.google.a.a.e eVar : this.AnR) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (com.google.a.a.e eVar2 : this.AnQ) {
                    if (eVar2 != null) {
                        bVar.a(5, eVar2);
                    }
                }
            }
            if (this.Ane != null) {
                bVar.a(6, this.Ane);
            }
            if (this.AnT != 0) {
                bVar.bq(7, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                for (int bq : this.AnU) {
                    bVar.bq(8, bq);
                }
            }
            if (this.AmJ != 0) {
                bVar.bq(9, this.AmJ);
            }
            if (this.AnS != null && this.AnS.length > 0) {
                for (com.google.a.a.e eVar22 : this.AnS) {
                    if (eVar22 != null) {
                        bVar.a(10, eVar22);
                    }
                }
            }
            if (this.Amz != null) {
                bVar.a(11, this.Amz);
            }
            if (this.AmX != 0) {
                bVar.br(12, this.AmX);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                for (com.google.a.a.e eVar222 : this.AnV) {
                    if (eVar222 != null) {
                        bVar.a(13, eVar222);
                    }
                }
            }
            if (this.AnY != null && this.AnY.length > 0) {
                for (com.google.a.a.e eVar2222 : this.AnY) {
                    if (eVar2222 != null) {
                        bVar.a(14, eVar2222);
                    }
                }
            }
            if (this.AnZ != 0) {
                bVar.bq(15, this.AnZ);
            }
            if (this.Aoa != 0) {
                bVar.bq(16, this.Aoa);
            }
            if (this.Aob != 0) {
                bVar.bq(17, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, com.google.a.a.g.bxA)) {
                bVar.b(18, this.Aoc);
            }
            if (this.wbi != -1) {
                bVar.bq(19, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                for (int bq2 : this.Aod) {
                    bVar.br(20, bq2);
                }
            }
            if (this.Ang != 0) {
                bVar.br(21, this.Ang);
            }
            if (this.AnW != 0) {
                bVar.br(100, this.AnW);
            }
            if (this.AnX != 0) {
                bVar.br(101, this.AnX);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i < this.Ank.length) {
                    com.google.a.a.e eVar3 = this.Ank[i];
                    if (eVar3 != null) {
                        bVar.a(102, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        public final int vr() {
            int i;
            int i2 = 0;
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar : this.AnR) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                vr = i;
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar2 : this.AnQ) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(5, eVar2);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += com.google.a.a.b.b(6, this.Ane);
            }
            if (this.AnT != 0) {
                vr += com.google.a.a.b.bs(7, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                i = 0;
                for (int ft : this.AnU) {
                    i += com.google.a.a.b.ft(ft);
                }
                vr = (vr + i) + (this.AnU.length * 1);
            }
            if (this.AmJ != 0) {
                vr += com.google.a.a.b.bs(9, this.AmJ);
            }
            if (this.AnS != null && this.AnS.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar22 : this.AnS) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(10, eVar22);
                    }
                }
                vr = i;
            }
            if (this.Amz != null) {
                vr += com.google.a.a.b.b(11, this.Amz);
            }
            if (this.AmX != 0) {
                vr += com.google.a.a.b.bt(12, this.AmX);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar222 : this.AnV) {
                    if (eVar222 != null) {
                        i += com.google.a.a.b.b(13, eVar222);
                    }
                }
                vr = i;
            }
            if (this.AnY != null && this.AnY.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar2222 : this.AnY) {
                    if (eVar2222 != null) {
                        i += com.google.a.a.b.b(14, eVar2222);
                    }
                }
                vr = i;
            }
            if (this.AnZ != 0) {
                vr += com.google.a.a.b.bs(15, this.AnZ);
            }
            if (this.Aoa != 0) {
                vr += com.google.a.a.b.bs(16, this.Aoa);
            }
            if (this.Aob != 0) {
                vr += com.google.a.a.b.bs(17, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(18, this.Aoc);
            }
            if (this.wbi != -1) {
                vr += com.google.a.a.b.bs(19, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                i = 0;
                for (int ft2 : this.Aod) {
                    i += com.google.a.a.b.fx(ft2);
                }
                vr = (vr + i) + (this.Aod.length * 2);
            }
            if (this.Ang != 0) {
                vr += com.google.a.a.b.bt(21, this.Ang);
            }
            if (this.AnW != 0) {
                vr += com.google.a.a.b.bt(100, this.AnW);
            }
            if (this.AnX != 0) {
                vr += com.google.a.a.b.bt(101, this.AnX);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i2 < this.Ank.length) {
                    com.google.a.a.e eVar3 = this.Ank[i2];
                    if (eVar3 != null) {
                        vr += com.google.a.a.b.b(102, eVar3);
                    }
                    i2++;
                }
            }
            return vr;
        }
    }

    public static final class ai extends com.google.a.a.e {
        public int ret;

        public ai() {
            this.ret = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.ret != 0) {
                bVar.bq(1, this.ret);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.ret != 0) {
                return vr + com.google.a.a.b.bs(1, this.ret);
            }
            return vr;
        }
    }

    public static final class ak extends com.google.a.a.e {
        public String groupId;
        public int sQS;
        public long sQT;

        public ak() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                return vr + com.google.a.a.b.o(3, this.sQT);
            }
            return vr;
        }
    }

    public static final class j extends com.google.a.a.e {
        public ba AmB;
        public int AmD;
        public byte[] AmN;
        public String groupId;
        public int sQS;
        public long sQT;

        public j() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmB = null;
            this.AmD = 0;
            this.AmN = com.google.a.a.g.bxA;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.AmB != null) {
                bVar.a(4, this.AmB);
            }
            if (this.AmD != 0) {
                bVar.br(5, this.AmD);
            }
            if (!Arrays.equals(this.AmN, com.google.a.a.g.bxA)) {
                bVar.b(200, this.AmN);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.AmB != null) {
                vr += com.google.a.a.b.b(4, this.AmB);
            }
            if (this.AmD != 0) {
                vr += com.google.a.a.b.bt(5, this.AmD);
            }
            if (Arrays.equals(this.AmN, com.google.a.a.g.bxA)) {
                return vr;
            }
            return vr + com.google.a.a.b.c(200, this.AmN);
        }
    }

    public static final class m extends com.google.a.a.e {
        private static volatile m[] AmU;
        public String AmV;
        public String nickname;
        public int vzt;

        public static m[] dPz() {
            if (AmU == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (AmU == null) {
                        AmU = new m[0];
                    }
                }
            }
            return AmU;
        }

        public m() {
            this.vzt = 0;
            this.nickname = "";
            this.AmV = "";
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.vzt != 0) {
                bVar.br(1, this.vzt);
            }
            if (!this.nickname.equals("")) {
                bVar.e(2, this.nickname);
            }
            if (!this.AmV.equals("")) {
                bVar.e(3, this.AmV);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.vzt != 0) {
                vr += com.google.a.a.b.bt(1, this.vzt);
            }
            if (!this.nickname.equals("")) {
                vr += com.google.a.a.b.f(2, this.nickname);
            }
            if (this.AmV.equals("")) {
                return vr;
            }
            return vr + com.google.a.a.b.f(3, this.AmV);
        }
    }

    public static final class ap extends com.google.a.a.e {
        public int Aou;
        public int Aov;

        public ap() {
            this.Aou = 0;
            this.Aov = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.Aou != 0) {
                bVar.bq(1, this.Aou);
            }
            if (this.Aov != 0) {
                bVar.bq(2, this.Aov);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.Aou != 0) {
                vr += com.google.a.a.b.bs(1, this.Aou);
            }
            if (this.Aov != 0) {
                return vr + com.google.a.a.b.bs(2, this.Aov);
            }
            return vr;
        }
    }

    public static final class aq extends com.google.a.a.e {
        public int sceneType;

        public aq() {
            this.sceneType = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.sceneType != 0) {
                bVar.bq(1, this.sceneType);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.sceneType != 0) {
                return vr + com.google.a.a.b.bs(1, this.sceneType);
            }
            return vr;
        }
    }

    public static final class ar extends com.google.a.a.e {
        private static volatile ar[] Aow;
        public int Aox;
        public int Aoy;
        public byte[] Aoz;

        public static ar[] dPF() {
            if (Aow == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (Aow == null) {
                        Aow = new ar[0];
                    }
                }
            }
            return Aow;
        }

        public ar() {
            this.Aox = 0;
            this.Aoy = 0;
            this.Aoz = com.google.a.a.g.bxA;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.Aox != 0) {
                bVar.bq(1, this.Aox);
            }
            if (this.Aoy != 0) {
                bVar.bq(2, this.Aoy);
            }
            if (!Arrays.equals(this.Aoz, com.google.a.a.g.bxA)) {
                bVar.b(3, this.Aoz);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.Aox != 0) {
                vr += com.google.a.a.b.bs(1, this.Aox);
            }
            if (this.Aoy != 0) {
                vr += com.google.a.a.b.bs(2, this.Aoy);
            }
            if (Arrays.equals(this.Aoz, com.google.a.a.g.bxA)) {
                return vr;
            }
            return vr + com.google.a.a.b.c(3, this.Aoz);
        }
    }

    public static final class as extends com.google.a.a.e {
        public int AoA;
        public int AoB;
        public int AoC;
        public int AoD;
        public int AoE;
        public int AoF;
        public int AoG;
        public int AoH;
        public int AoI;
        public int AoJ;
        public int fAa;
        public int fAb;

        public as() {
            this.AoA = 0;
            this.fAa = 0;
            this.fAb = 0;
            this.AoB = 0;
            this.AoC = 0;
            this.AoD = 0;
            this.AoE = 0;
            this.AoF = 0;
            this.AoG = 0;
            this.AoH = 0;
            this.AoI = 0;
            this.AoJ = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.AoA != 0) {
                bVar.bq(1, this.AoA);
            }
            if (this.fAa != 0) {
                bVar.bq(2, this.fAa);
            }
            if (this.fAb != 0) {
                bVar.bq(3, this.fAb);
            }
            if (this.AoB != 0) {
                bVar.bq(4, this.AoB);
            }
            if (this.AoC != 0) {
                bVar.bq(5, this.AoC);
            }
            if (this.AoD != 0) {
                bVar.bq(6, this.AoD);
            }
            if (this.AoE != 0) {
                bVar.bq(7, this.AoE);
            }
            if (this.AoF != 0) {
                bVar.bq(8, this.AoF);
            }
            if (this.AoG != 0) {
                bVar.bq(9, this.AoG);
            }
            if (this.AoH != 0) {
                bVar.bq(10, this.AoH);
            }
            if (this.AoI != 0) {
                bVar.bq(11, this.AoI);
            }
            if (this.AoJ != 0) {
                bVar.bq(12, this.AoJ);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.AoA != 0) {
                vr += com.google.a.a.b.bs(1, this.AoA);
            }
            if (this.fAa != 0) {
                vr += com.google.a.a.b.bs(2, this.fAa);
            }
            if (this.fAb != 0) {
                vr += com.google.a.a.b.bs(3, this.fAb);
            }
            if (this.AoB != 0) {
                vr += com.google.a.a.b.bs(4, this.AoB);
            }
            if (this.AoC != 0) {
                vr += com.google.a.a.b.bs(5, this.AoC);
            }
            if (this.AoD != 0) {
                vr += com.google.a.a.b.bs(6, this.AoD);
            }
            if (this.AoE != 0) {
                vr += com.google.a.a.b.bs(7, this.AoE);
            }
            if (this.AoF != 0) {
                vr += com.google.a.a.b.bs(8, this.AoF);
            }
            if (this.AoG != 0) {
                vr += com.google.a.a.b.bs(9, this.AoG);
            }
            if (this.AoH != 0) {
                vr += com.google.a.a.b.bs(10, this.AoH);
            }
            if (this.AoI != 0) {
                vr += com.google.a.a.b.bs(11, this.AoI);
            }
            if (this.AoJ != 0) {
                return vr + com.google.a.a.b.bs(12, this.AoJ);
            }
            return vr;
        }
    }

    public static final class ay extends com.google.a.a.e {
        public int ApH;
        public int sQS;
        public long sQT;

        public ay() {
            this.sQS = 0;
            this.sQT = 0;
            this.ApH = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.sQS != 0) {
                bVar.bq(1, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(2, this.sQT);
            }
            if (this.ApH != 0) {
                bVar.br(3, this.ApH);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(1, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(2, this.sQT);
            }
            if (this.ApH != 0) {
                return vr + com.google.a.a.b.bt(3, this.ApH);
            }
            return vr;
        }
    }

    public static final class az extends com.google.a.a.e {
        private static volatile az[] ApI;
        public int ApJ;
        public int ApK;
        public int ApL;
        public int ApM;
        public int timestamp;

        public static az[] dPJ() {
            if (ApI == null) {
                synchronized (com.google.a.a.c.bxs) {
                    if (ApI == null) {
                        ApI = new az[0];
                    }
                }
            }
            return ApI;
        }

        public az() {
            this.timestamp = 0;
            this.ApJ = 0;
            this.ApK = 0;
            this.ApL = 0;
            this.ApM = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.timestamp != 0) {
                bVar.bq(1, this.timestamp);
            }
            if (this.ApJ != 0) {
                bVar.bq(2, this.ApJ);
            }
            if (this.ApK != 0) {
                bVar.bq(3, this.ApK);
            }
            if (this.ApL != 0) {
                bVar.bq(4, this.ApL);
            }
            if (this.ApM != 0) {
                bVar.bq(5, this.ApM);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.timestamp != 0) {
                vr += com.google.a.a.b.bs(1, this.timestamp);
            }
            if (this.ApJ != 0) {
                vr += com.google.a.a.b.bs(2, this.ApJ);
            }
            if (this.ApK != 0) {
                vr += com.google.a.a.b.bs(3, this.ApK);
            }
            if (this.ApL != 0) {
                vr += com.google.a.a.b.bs(4, this.ApL);
            }
            if (this.ApM != 0) {
                return vr + com.google.a.a.b.bs(5, this.ApM);
            }
            return vr;
        }
    }

    public static final class i extends com.google.a.a.e {
        public int action;
        public String groupId;
        public int nwu;
        public long nwv;
        public long timestamp;

        public final void a(com.google.a.a.b bVar) {
            bVar.br(1, this.action);
            bVar.bq(2, this.nwu);
            bVar.m(3, this.nwv);
            if (!this.groupId.equals("")) {
                bVar.e(4, this.groupId);
            }
            if (this.timestamp != 0) {
                bVar.l(5, this.timestamp);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = ((super.vr() + com.google.a.a.b.bt(1, this.action)) + com.google.a.a.b.bs(2, this.nwu)) + com.google.a.a.b.o(3, this.nwv);
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(4, this.groupId);
            }
            return this.timestamp != 0 ? vr + com.google.a.a.b.n(5, this.timestamp) : vr;
        }

        public i() {
            this.action = 0;
            this.nwu = 0;
            this.nwv = 0;
            this.groupId = "";
            this.timestamp = 0;
            this.bxt = -1;
        }
    }

    public static final class k extends com.google.a.a.e {
        public int AmD;
        public String groupId;
        public int kyZ;
        public int netType;
        public int sQS;
        public long sQT;

        public k() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.kyZ = -1;
            this.AmD = 0;
            this.netType = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.kyZ != -1) {
                bVar.bq(4, this.kyZ);
            }
            if (this.AmD != 0) {
                bVar.br(5, this.AmD);
            }
            if (this.netType != 0) {
                bVar.br(6, this.netType);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.kyZ != -1) {
                vr += com.google.a.a.b.bs(4, this.kyZ);
            }
            if (this.AmD != 0) {
                vr += com.google.a.a.b.bt(5, this.AmD);
            }
            if (this.netType != 0) {
                return vr + com.google.a.a.b.bt(6, this.netType);
            }
            return vr;
        }
    }

    public static final class r extends com.google.a.a.e {
        public am[] Anm;

        public final void a(com.google.a.a.b bVar) {
            if (this.Anm != null && this.Anm.length > 0) {
                for (com.google.a.a.e eVar : this.Anm) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.Anm != null && this.Anm.length > 0) {
                for (com.google.a.a.e eVar : this.Anm) {
                    if (eVar != null) {
                        vr += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return vr;
        }

        public r() {
            this.Anm = am.dPD();
            this.bxt = -1;
        }
    }

    public static final class s extends com.google.a.a.e {
        public String AmV;
        public String Ann;
        public String Ano;
        public int Anp;
        public long Anq;
        public int Anr;
        public long Ans;
        public int Ant;
        public String ffQ;
        public String username;
        public long vNx;
        public long vNy;
        public String xAF;

        public s() {
            this.vNx = 0;
            this.Ann = "";
            this.Ano = "";
            this.Anp = 1;
            this.username = "";
            this.ffQ = "";
            this.AmV = "";
            this.Anq = 0;
            this.Anr = 0;
            this.xAF = "";
            this.Ans = 0;
            this.Ant = 0;
            this.vNy = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.vNx != 0) {
                bVar.l(1, this.vNx);
            }
            if (!this.Ann.equals("")) {
                bVar.e(2, this.Ann);
            }
            if (!this.Ano.equals("")) {
                bVar.e(3, this.Ano);
            }
            if (this.Anp != 1) {
                bVar.bq(4, this.Anp);
            }
            if (!this.username.equals("")) {
                bVar.e(5, this.username);
            }
            if (!this.ffQ.equals("")) {
                bVar.e(6, this.ffQ);
            }
            if (!this.AmV.equals("")) {
                bVar.e(7, this.AmV);
            }
            if (this.Anq != 0) {
                bVar.l(8, this.Anq);
            }
            if (this.Anr != 0) {
                bVar.br(9, this.Anr);
            }
            if (!this.xAF.equals("")) {
                bVar.e(10, this.xAF);
            }
            if (this.Ans != 0) {
                bVar.l(11, this.Ans);
            }
            if (this.Ant != 0) {
                bVar.br(12, this.Ant);
            }
            if (this.vNy != 0) {
                bVar.l(13, this.vNy);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.vNx != 0) {
                vr += com.google.a.a.b.n(1, this.vNx);
            }
            if (!this.Ann.equals("")) {
                vr += com.google.a.a.b.f(2, this.Ann);
            }
            if (!this.Ano.equals("")) {
                vr += com.google.a.a.b.f(3, this.Ano);
            }
            if (this.Anp != 1) {
                vr += com.google.a.a.b.bs(4, this.Anp);
            }
            if (!this.username.equals("")) {
                vr += com.google.a.a.b.f(5, this.username);
            }
            if (!this.ffQ.equals("")) {
                vr += com.google.a.a.b.f(6, this.ffQ);
            }
            if (!this.AmV.equals("")) {
                vr += com.google.a.a.b.f(7, this.AmV);
            }
            if (this.Anq != 0) {
                vr += com.google.a.a.b.n(8, this.Anq);
            }
            if (this.Anr != 0) {
                vr += com.google.a.a.b.bt(9, this.Anr);
            }
            if (!this.xAF.equals("")) {
                vr += com.google.a.a.b.f(10, this.xAF);
            }
            if (this.Ans != 0) {
                vr += com.google.a.a.b.n(11, this.Ans);
            }
            if (this.Ant != 0) {
                vr += com.google.a.a.b.bt(12, this.Ant);
            }
            if (this.vNy != 0) {
                return vr + com.google.a.a.b.n(13, this.vNy);
            }
            return vr;
        }
    }

    public static final class t extends com.google.a.a.e {
        public byte[] AnA;
        public byte[] AnB;
        public byte[] AnC;
        public byte[] AnD;
        public byte[] AnE;
        public byte[] AnF;
        public byte[] AnG;
        public byte[] AnH;
        public byte[] AnI;
        public byte[] AnJ;
        public int Anu;
        public byte[] Anv;
        public byte[] Anw;
        public byte[] Anx;
        public int Any;
        public int Anz;
        public byte[] data;
        public String iconUrl;
        public String lvz;
        public int status;

        public t() {
            this.Anu = 0;
            this.Anv = com.google.a.a.g.bxA;
            this.iconUrl = "";
            this.Anw = com.google.a.a.g.bxA;
            this.Anx = com.google.a.a.g.bxA;
            this.Any = 0;
            this.data = com.google.a.a.g.bxA;
            this.Anz = 0;
            this.AnA = com.google.a.a.g.bxA;
            this.lvz = "";
            this.AnB = com.google.a.a.g.bxA;
            this.AnC = com.google.a.a.g.bxA;
            this.AnD = com.google.a.a.g.bxA;
            this.AnE = com.google.a.a.g.bxA;
            this.AnF = com.google.a.a.g.bxA;
            this.AnG = com.google.a.a.g.bxA;
            this.AnH = com.google.a.a.g.bxA;
            this.AnI = com.google.a.a.g.bxA;
            this.AnJ = com.google.a.a.g.bxA;
            this.status = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.Anu != 0) {
                bVar.br(1, this.Anu);
            }
            if (!Arrays.equals(this.Anv, com.google.a.a.g.bxA)) {
                bVar.b(2, this.Anv);
            }
            if (!this.iconUrl.equals("")) {
                bVar.e(3, this.iconUrl);
            }
            if (!Arrays.equals(this.Anw, com.google.a.a.g.bxA)) {
                bVar.b(4, this.Anw);
            }
            if (!Arrays.equals(this.Anx, com.google.a.a.g.bxA)) {
                bVar.b(5, this.Anx);
            }
            if (this.Any != 0) {
                bVar.br(6, this.Any);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.bxA)) {
                bVar.b(7, this.data);
            }
            if (this.Anz != 0) {
                bVar.br(8, this.Anz);
            }
            if (!Arrays.equals(this.AnA, com.google.a.a.g.bxA)) {
                bVar.b(9, this.AnA);
            }
            if (!this.lvz.equals("")) {
                bVar.e(10, this.lvz);
            }
            if (!Arrays.equals(this.AnB, com.google.a.a.g.bxA)) {
                bVar.b(11, this.AnB);
            }
            if (!Arrays.equals(this.AnC, com.google.a.a.g.bxA)) {
                bVar.b(12, this.AnC);
            }
            if (!Arrays.equals(this.AnD, com.google.a.a.g.bxA)) {
                bVar.b(13, this.AnD);
            }
            if (!Arrays.equals(this.AnE, com.google.a.a.g.bxA)) {
                bVar.b(14, this.AnE);
            }
            if (!Arrays.equals(this.AnF, com.google.a.a.g.bxA)) {
                bVar.b(15, this.AnF);
            }
            if (!Arrays.equals(this.AnG, com.google.a.a.g.bxA)) {
                bVar.b(16, this.AnG);
            }
            if (!Arrays.equals(this.AnH, com.google.a.a.g.bxA)) {
                bVar.b(17, this.AnH);
            }
            if (!Arrays.equals(this.AnI, com.google.a.a.g.bxA)) {
                bVar.b(18, this.AnI);
            }
            if (!Arrays.equals(this.AnJ, com.google.a.a.g.bxA)) {
                bVar.b(19, this.AnJ);
            }
            if (this.status != 0) {
                bVar.br(20, this.status);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (this.Anu != 0) {
                vr += com.google.a.a.b.bt(1, this.Anu);
            }
            if (!Arrays.equals(this.Anv, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(2, this.Anv);
            }
            if (!this.iconUrl.equals("")) {
                vr += com.google.a.a.b.f(3, this.iconUrl);
            }
            if (!Arrays.equals(this.Anw, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(4, this.Anw);
            }
            if (!Arrays.equals(this.Anx, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(5, this.Anx);
            }
            if (this.Any != 0) {
                vr += com.google.a.a.b.bt(6, this.Any);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(7, this.data);
            }
            if (this.Anz != 0) {
                vr += com.google.a.a.b.bt(8, this.Anz);
            }
            if (!Arrays.equals(this.AnA, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(9, this.AnA);
            }
            if (!this.lvz.equals("")) {
                vr += com.google.a.a.b.f(10, this.lvz);
            }
            if (!Arrays.equals(this.AnB, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(11, this.AnB);
            }
            if (!Arrays.equals(this.AnC, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(12, this.AnC);
            }
            if (!Arrays.equals(this.AnD, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(13, this.AnD);
            }
            if (!Arrays.equals(this.AnE, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(14, this.AnE);
            }
            if (!Arrays.equals(this.AnF, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(15, this.AnF);
            }
            if (!Arrays.equals(this.AnG, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(16, this.AnG);
            }
            if (!Arrays.equals(this.AnH, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(17, this.AnH);
            }
            if (!Arrays.equals(this.AnI, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(18, this.AnI);
            }
            if (!Arrays.equals(this.AnJ, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(19, this.AnJ);
            }
            if (this.status != 0) {
                return vr + com.google.a.a.b.bt(20, this.status);
            }
            return vr;
        }
    }

    public static final class u extends com.google.a.a.e {
        public int AmC;
        public int AnK;
        public int AnL;
        public int Cn;
        public int ret;
        public String userName;
        public int vzt;

        public u() {
            this.userName = "";
            this.Cn = 0;
            this.AnK = 0;
            this.ret = 0;
            this.AnL = 0;
            this.AmC = 0;
            this.vzt = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.userName.equals("")) {
                bVar.e(2, this.userName);
            }
            if (this.Cn != 0) {
                bVar.bq(3, this.Cn);
            }
            if (this.AnK != 0) {
                bVar.br(4, this.AnK);
            }
            if (this.ret != 0) {
                bVar.bq(5, this.ret);
            }
            if (this.AnL != 0) {
                bVar.bq(6, this.AnL);
            }
            if (this.AmC != 0) {
                bVar.br(7, this.AmC);
            }
            if (this.vzt != 0) {
                bVar.br(8, this.vzt);
            }
            super.a(bVar);
        }

        public final int vr() {
            int vr = super.vr();
            if (!this.userName.equals("")) {
                vr += com.google.a.a.b.f(2, this.userName);
            }
            if (this.Cn != 0) {
                vr += com.google.a.a.b.bs(3, this.Cn);
            }
            if (this.AnK != 0) {
                vr += com.google.a.a.b.bt(4, this.AnK);
            }
            if (this.ret != 0) {
                vr += com.google.a.a.b.bs(5, this.ret);
            }
            if (this.AnL != 0) {
                vr += com.google.a.a.b.bs(6, this.AnL);
            }
            if (this.AmC != 0) {
                vr += com.google.a.a.b.bt(7, this.AmC);
            }
            if (this.vzt != 0) {
                return vr + com.google.a.a.b.bt(8, this.vzt);
            }
            return vr;
        }
    }

    public static final class ag extends com.google.a.a.e {
        public at Amz;
        public av[] AnQ;
        public o[] AnR;
        public aw[] AnS;
        public int AnT;
        public int[] AnU;
        public as Ane;
        public av[] Ank;
        public String groupId;
        public int sQS;
        public long sQT;

        public ag() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnR = o.dPB();
            this.Ane = null;
            this.AnT = 0;
            this.AnU = com.google.a.a.g.bxu;
            this.AnQ = av.dPH();
            this.AnS = aw.dPI();
            this.Amz = null;
            this.Ank = av.dPH();
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                for (com.google.a.a.e eVar : this.AnR) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.Ane != null) {
                bVar.a(5, this.Ane);
            }
            if (this.AnT != 0) {
                bVar.bq(6, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                for (int bq : this.AnU) {
                    bVar.bq(7, bq);
                }
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (com.google.a.a.e eVar2 : this.AnQ) {
                    if (eVar2 != null) {
                        bVar.a(200, eVar2);
                    }
                }
            }
            if (this.AnS != null && this.AnS.length > 0) {
                for (com.google.a.a.e eVar22 : this.AnS) {
                    if (eVar22 != null) {
                        bVar.a(201, eVar22);
                    }
                }
            }
            if (this.Amz != null) {
                bVar.a(202, this.Amz);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i < this.Ank.length) {
                    com.google.a.a.e eVar3 = this.Ank[i];
                    if (eVar3 != null) {
                        bVar.a(203, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        public final int vr() {
            int i;
            int i2 = 0;
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar : this.AnR) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += com.google.a.a.b.b(5, this.Ane);
            }
            if (this.AnT != 0) {
                vr += com.google.a.a.b.bs(6, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                i = 0;
                for (int ft : this.AnU) {
                    i += com.google.a.a.b.ft(ft);
                }
                vr = (vr + i) + (this.AnU.length * 1);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar2 : this.AnQ) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(200, eVar2);
                    }
                }
                vr = i;
            }
            if (this.AnS != null && this.AnS.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar22 : this.AnS) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(201, eVar22);
                    }
                }
                vr = i;
            }
            if (this.Amz != null) {
                vr += com.google.a.a.b.b(202, this.Amz);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i2 < this.Ank.length) {
                    com.google.a.a.e eVar3 = this.Ank[i2];
                    if (eVar3 != null) {
                        vr += com.google.a.a.b.b(203, eVar3);
                    }
                    i2++;
                }
            }
            return vr;
        }
    }

    public static final class aj extends com.google.a.a.e {
        public at Amz;
        public av[] AnQ;
        public o[] AnR;
        public aw[] AnS;
        public int AnT;
        public int[] AnU;
        public o[] AnV;
        public o[] AnY;
        public int AnZ;
        public as Ane;
        public int Ang;
        public av[] Ank;
        public int Aoa;
        public int Aob;
        public byte[] Aoc;
        public int[] Aod;
        public String groupId;
        public int sQS;
        public long sQT;
        public int wbi;

        public aj() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnR = o.dPB();
            this.AnQ = av.dPH();
            this.Ane = null;
            this.AnT = 0;
            this.AnU = com.google.a.a.g.bxu;
            this.AnS = aw.dPI();
            this.Amz = null;
            this.AnV = o.dPB();
            this.Ank = av.dPH();
            this.AnY = o.dPB();
            this.AnZ = 0;
            this.Aoa = 0;
            this.Aob = 0;
            this.Aoc = com.google.a.a.g.bxA;
            this.wbi = -1;
            this.Aod = com.google.a.a.g.bxu;
            this.Ang = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                for (com.google.a.a.e eVar : this.AnR) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (com.google.a.a.e eVar2 : this.AnQ) {
                    if (eVar2 != null) {
                        bVar.a(5, eVar2);
                    }
                }
            }
            if (this.Ane != null) {
                bVar.a(6, this.Ane);
            }
            if (this.AnT != 0) {
                bVar.bq(7, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                for (int bq : this.AnU) {
                    bVar.bq(8, bq);
                }
            }
            if (this.AnS != null && this.AnS.length > 0) {
                for (com.google.a.a.e eVar22 : this.AnS) {
                    if (eVar22 != null) {
                        bVar.a(9, eVar22);
                    }
                }
            }
            if (this.Amz != null) {
                bVar.a(10, this.Amz);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                for (com.google.a.a.e eVar222 : this.AnV) {
                    if (eVar222 != null) {
                        bVar.a(11, eVar222);
                    }
                }
            }
            if (this.Ank != null && this.Ank.length > 0) {
                for (com.google.a.a.e eVar2222 : this.Ank) {
                    if (eVar2222 != null) {
                        bVar.a(12, eVar2222);
                    }
                }
            }
            if (this.AnY != null && this.AnY.length > 0) {
                for (com.google.a.a.e eVar22222 : this.AnY) {
                    if (eVar22222 != null) {
                        bVar.a(13, eVar22222);
                    }
                }
            }
            if (this.AnZ != 0) {
                bVar.bq(14, this.AnZ);
            }
            if (this.Aoa != 0) {
                bVar.bq(15, this.Aoa);
            }
            if (this.Aob != 0) {
                bVar.bq(16, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, com.google.a.a.g.bxA)) {
                bVar.b(17, this.Aoc);
            }
            if (this.wbi != -1) {
                bVar.bq(18, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                while (i < this.Aod.length) {
                    bVar.br(19, this.Aod[i]);
                    i++;
                }
            }
            if (this.Ang != 0) {
                bVar.br(20, this.Ang);
            }
            super.a(bVar);
        }

        public final int vr() {
            int i;
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar : this.AnR) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                vr = i;
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar2 : this.AnQ) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(5, eVar2);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += com.google.a.a.b.b(6, this.Ane);
            }
            if (this.AnT != 0) {
                vr += com.google.a.a.b.bs(7, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                i = 0;
                for (int ft : this.AnU) {
                    i += com.google.a.a.b.ft(ft);
                }
                vr = (vr + i) + (this.AnU.length * 1);
            }
            if (this.AnS != null && this.AnS.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar22 : this.AnS) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(9, eVar22);
                    }
                }
                vr = i;
            }
            if (this.Amz != null) {
                vr += com.google.a.a.b.b(10, this.Amz);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar222 : this.AnV) {
                    if (eVar222 != null) {
                        i += com.google.a.a.b.b(11, eVar222);
                    }
                }
                vr = i;
            }
            if (this.Ank != null && this.Ank.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar2222 : this.Ank) {
                    if (eVar2222 != null) {
                        i += com.google.a.a.b.b(12, eVar2222);
                    }
                }
                vr = i;
            }
            if (this.AnY != null && this.AnY.length > 0) {
                i = vr;
                for (com.google.a.a.e eVar22222 : this.AnY) {
                    if (eVar22222 != null) {
                        i += com.google.a.a.b.b(13, eVar22222);
                    }
                }
                vr = i;
            }
            if (this.AnZ != 0) {
                vr += com.google.a.a.b.bs(14, this.AnZ);
            }
            if (this.Aoa != 0) {
                vr += com.google.a.a.b.bs(15, this.Aoa);
            }
            if (this.Aob != 0) {
                vr += com.google.a.a.b.bs(16, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(17, this.Aoc);
            }
            if (this.wbi != -1) {
                vr += com.google.a.a.b.bs(18, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                i = 0;
                for (int fx : this.Aod) {
                    i += com.google.a.a.b.fx(fx);
                }
                vr = (vr + i) + (this.Aod.length * 2);
            }
            if (this.Ang != 0) {
                return vr + com.google.a.a.b.bt(20, this.Ang);
            }
            return vr;
        }
    }

    public static final class l extends com.google.a.a.e {
        public int AmO;
        public byte[] AmP;
        public az[] AmQ;
        public ao[] AmR;
        public int AmS;
        public int AmT;
        public int fVl;
        public String groupId;
        public int kyZ;
        public int sQS;
        public long sQT;

        public l() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.kyZ = -1;
            this.AmO = 0;
            this.AmP = com.google.a.a.g.bxA;
            this.AmQ = az.dPJ();
            this.AmR = ao.dPE();
            this.AmS = 0;
            this.AmT = 0;
            this.fVl = 0;
            this.bxt = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.sQS != 0) {
                bVar.bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                bVar.m(3, this.sQT);
            }
            if (this.kyZ != -1) {
                bVar.bq(4, this.kyZ);
            }
            if (this.AmO != 0) {
                bVar.bq(5, this.AmO);
            }
            if (!Arrays.equals(this.AmP, com.google.a.a.g.bxA)) {
                bVar.b(6, this.AmP);
            }
            if (this.AmQ != null && this.AmQ.length > 0) {
                for (com.google.a.a.e eVar : this.AmQ) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (this.AmR != null && this.AmR.length > 0) {
                while (i < this.AmR.length) {
                    com.google.a.a.e eVar2 = this.AmR[i];
                    if (eVar2 != null) {
                        bVar.a(8, eVar2);
                    }
                    i++;
                }
            }
            if (this.AmS != 0) {
                bVar.bq(9, this.AmS);
            }
            if (this.AmT != 0) {
                bVar.bq(10, this.AmT);
            }
            if (this.fVl != 0) {
                bVar.bq(11, this.fVl);
            }
            super.a(bVar);
        }

        public final int vr() {
            int i = 0;
            int vr = super.vr();
            if (!this.groupId.equals("")) {
                vr += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += com.google.a.a.b.bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += com.google.a.a.b.o(3, this.sQT);
            }
            if (this.kyZ != -1) {
                vr += com.google.a.a.b.bs(4, this.kyZ);
            }
            if (this.AmO != 0) {
                vr += com.google.a.a.b.bs(5, this.AmO);
            }
            if (!Arrays.equals(this.AmP, com.google.a.a.g.bxA)) {
                vr += com.google.a.a.b.c(6, this.AmP);
            }
            if (this.AmQ != null && this.AmQ.length > 0) {
                int i2 = vr;
                for (com.google.a.a.e eVar : this.AmQ) {
                    if (eVar != null) {
                        i2 += com.google.a.a.b.b(7, eVar);
                    }
                }
                vr = i2;
            }
            if (this.AmR != null && this.AmR.length > 0) {
                while (i < this.AmR.length) {
                    com.google.a.a.e eVar2 = this.AmR[i];
                    if (eVar2 != null) {
                        vr += com.google.a.a.b.b(8, eVar2);
                    }
                    i++;
                }
            }
            if (this.AmS != 0) {
                vr += com.google.a.a.b.bs(9, this.AmS);
            }
            if (this.AmT != 0) {
                vr += com.google.a.a.b.bs(10, this.AmT);
            }
            if (this.fVl != 0) {
                return vr + com.google.a.a.b.bs(11, this.fVl);
            }
            return vr;
        }
    }
}
