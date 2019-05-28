package com.tencent.p659pb.common.p660b.p661a;

import com.google.p1368a.p1369a.C25507b;
import com.google.p1368a.p1369a.C25508c;
import com.google.p1368a.p1369a.C25510e;
import com.google.p1368a.p1369a.C45015g;
import java.util.Arrays;

/* renamed from: com.tencent.pb.common.b.a.a */
public interface C24202a {

    /* renamed from: com.tencent.pb.common.b.a.a$ac */
    public static final class C5792ac extends C25510e {
        public C24191at Amz;
        public int Aoe;
        public String groupId;

        public C5792ac() {
            this.groupId = "";
            this.Amz = null;
            this.Aoe = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.Amz != null) {
                c25507b.mo42760a(2, this.Amz);
            }
            if (this.Aoe != 0) {
                c25507b.mo42762bq(3, this.Aoe);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.Amz != null) {
                vr += C25507b.m40263b(2, this.Amz);
            }
            if (this.Aoe != 0) {
                return vr + C25507b.m40265bs(3, this.Aoe);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ao */
    public static final class C16118ao extends C25510e {
        private static volatile C16118ao[] Aos;
        public int Aof;
        public int Aot;
        public int fps;
        public int kyZ;

        public static C16118ao[] dPE() {
            if (Aos == null) {
                synchronized (C25508c.bxs) {
                    if (Aos == null) {
                        Aos = new C16118ao[0];
                    }
                }
            }
            return Aos;
        }

        public C16118ao() {
            this.kyZ = 0;
            this.Aot = 0;
            this.fps = 0;
            this.Aof = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.kyZ != 0) {
                c25507b.mo42762bq(1, this.kyZ);
            }
            if (this.Aot != 0) {
                c25507b.mo42762bq(2, this.Aot);
            }
            if (this.fps != 0) {
                c25507b.mo42762bq(3, this.fps);
            }
            if (this.Aof != 0) {
                c25507b.mo42762bq(4, this.Aof);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.kyZ != 0) {
                vr += C25507b.m40265bs(1, this.kyZ);
            }
            if (this.Aot != 0) {
                vr += C25507b.m40265bs(2, this.Aot);
            }
            if (this.fps != 0) {
                vr += C25507b.m40265bs(3, this.fps);
            }
            if (this.Aof != 0) {
                return vr + C25507b.m40265bs(4, this.Aof);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$h */
    public static final class C16119h extends C25510e {
        public String emc;
        public String groupId;
        public int nwu;
        public long nwv;
        public long timestamp;

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            c25507b.mo42762bq(1, this.nwu);
            c25507b.mo42766m(2, this.nwv);
            c25507b.mo42764e(3, this.emc);
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(4, this.groupId);
            }
            if (this.timestamp != 0) {
                c25507b.mo42765l(5, this.timestamp);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = ((super.mo11879vr() + C25507b.m40265bs(1, this.nwu)) + C25507b.m40276o(2, this.nwv)) + C25507b.m40269f(3, this.emc);
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(4, this.groupId);
            }
            return this.timestamp != 0 ? vr + C25507b.m40275n(5, this.timestamp) : vr;
        }

        public C16119h() {
            this.nwu = 0;
            this.nwv = 0;
            this.emc = "";
            this.groupId = "";
            this.timestamp = 0;
            this.bxt = -1;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$o */
    public static final class C16120o extends C25510e {
        private static volatile C16120o[] AmZ;
        public int Ana;
        public int port;

        public static C16120o[] dPB() {
            if (AmZ == null) {
                synchronized (C25508c.bxs) {
                    if (AmZ == null) {
                        AmZ = new C16120o[0];
                    }
                }
            }
            return AmZ;
        }

        public C16120o() {
            this.Ana = 0;
            this.port = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.Ana != 0) {
                c25507b.mo42763br(1, this.Ana);
            }
            if (this.port != 0) {
                c25507b.mo42762bq(2, this.port);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.Ana != 0) {
                vr += C25507b.m40266bt(1, this.Ana);
            }
            if (this.port != 0) {
                return vr + C25507b.m40265bs(2, this.port);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ad */
    public static final class C24188ad extends C25510e {
        public String Amx;
        public String groupId;
        public int sQS;
        public long sQT;

        public C24188ad() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.Amx = "";
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (!this.Amx.equals("")) {
                c25507b.mo42764e(4, this.Amx);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.Amx.equals("")) {
                return vr;
            }
            return vr + C25507b.m40269f(4, this.Amx);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$af */
    public static final class C24189af extends C25510e {
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

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.Aof != 0) {
                c25507b.mo42763br(1, this.Aof);
            }
            if (this.nwu != 0) {
                c25507b.mo42762bq(2, this.nwu);
            }
            if (this.nwv != 0) {
                c25507b.mo42766m(3, this.nwv);
            }
            if (this.Aog != 0) {
                c25507b.mo42763br(4, this.Aog);
            }
            if (this.Aoh != 0) {
                c25507b.mo42763br(5, this.Aoh);
            }
            if (this.Aoi != 0) {
                c25507b.mo42763br(6, this.Aoi);
            }
            if (this.Aoj != 0) {
                c25507b.mo42763br(7, this.Aoj);
            }
            if (this.Aok != 0) {
                c25507b.mo42763br(8, this.Aok);
            }
            if (this.Aol != -1) {
                c25507b.mo42762bq(9, this.Aol);
            }
            if (this.Aom != 0) {
                c25507b.mo42762bq(10, this.Aom);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.Aof != 0) {
                vr += C25507b.m40266bt(1, this.Aof);
            }
            if (this.nwu != 0) {
                vr += C25507b.m40265bs(2, this.nwu);
            }
            if (this.nwv != 0) {
                vr += C25507b.m40276o(3, this.nwv);
            }
            if (this.Aog != 0) {
                vr += C25507b.m40266bt(4, this.Aog);
            }
            if (this.Aoh != 0) {
                vr += C25507b.m40266bt(5, this.Aoh);
            }
            if (this.Aoi != 0) {
                vr += C25507b.m40266bt(6, this.Aoi);
            }
            if (this.Aoj != 0) {
                vr += C25507b.m40266bt(7, this.Aoj);
            }
            if (this.Aok != 0) {
                vr += C25507b.m40266bt(8, this.Aok);
            }
            if (this.Aol != -1) {
                vr += C25507b.m40265bs(9, this.Aol);
            }
            return this.Aom != 0 ? vr + C25507b.m40265bs(10, this.Aom) : vr;
        }

        public C24189af() {
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

    /* renamed from: com.tencent.pb.common.b.a.a$am */
    public static final class C24190am extends C25510e {
        private static volatile C24190am[] Aoo;
        public String Aop;
        public int Aoq;
        public int kyZ;
        public int vzt;

        public static C24190am[] dPD() {
            if (Aoo == null) {
                synchronized (C25508c.bxs) {
                    if (Aoo == null) {
                        Aoo = new C24190am[0];
                    }
                }
            }
            return Aoo;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.kyZ != 0) {
                c25507b.mo42763br(1, this.kyZ);
            }
            if (!this.Aop.equals("")) {
                c25507b.mo42764e(2, this.Aop);
            }
            if (this.vzt != 0) {
                c25507b.mo42763br(3, this.vzt);
            }
            if (this.Aoq != 0) {
                c25507b.mo42763br(4, this.Aoq);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.kyZ != 0) {
                vr += C25507b.m40266bt(1, this.kyZ);
            }
            if (!this.Aop.equals("")) {
                vr += C25507b.m40269f(2, this.Aop);
            }
            if (this.vzt != 0) {
                vr += C25507b.m40266bt(3, this.vzt);
            }
            return this.Aoq != 0 ? vr + C25507b.m40266bt(4, this.Aoq) : vr;
        }

        public C24190am() {
            this.kyZ = 0;
            this.Aop = "";
            this.vzt = 0;
            this.Aoq = 0;
            this.bxt = -1;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$at */
    public static final class C24191at extends C25510e {
        public byte[] AoK;
        public long AoL;
        public byte[] AoM;
        public byte[] AoN;
        public byte[] AoO;
        public C24195ax AoP;
        public byte[] AoQ;
        public C24224ap AoR;
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
        public C24208n[] Apd;
        public byte[] bFS;
        public int cAO;
        public String name;

        public C24191at() {
            this.name = "";
            this.AoK = C45015g.bxA;
            this.cAO = 0;
            this.AoL = 0;
            this.AoM = C45015g.bxA;
            this.AoN = C45015g.bxA;
            this.AoO = C45015g.bxA;
            this.AoP = null;
            this.AoQ = C45015g.bxA;
            this.AoR = null;
            this.AoS = "";
            this.AoT = "";
            this.AoU = 0;
            this.AoV = C45015g.bxA;
            this.AoW = C45015g.bxA;
            this.AoX = C45015g.bxA;
            this.AoY = C45015g.bxA;
            this.AoZ = 0;
            this.Apa = C45015g.bxA;
            this.Apb = C45015g.bxA;
            this.bFS = C45015g.bxA;
            this.Apc = 0;
            this.Apd = C24208n.dPA();
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.name.equals("")) {
                c25507b.mo42764e(1, this.name);
            }
            if (!Arrays.equals(this.AoK, C45015g.bxA)) {
                c25507b.mo42761b(2, this.AoK);
            }
            if (this.cAO != 0) {
                c25507b.mo42762bq(3, this.cAO);
            }
            if (this.AoL != 0) {
                c25507b.mo42765l(4, this.AoL);
            }
            if (!Arrays.equals(this.AoM, C45015g.bxA)) {
                c25507b.mo42761b(5, this.AoM);
            }
            if (!Arrays.equals(this.AoN, C45015g.bxA)) {
                c25507b.mo42761b(6, this.AoN);
            }
            if (!Arrays.equals(this.AoO, C45015g.bxA)) {
                c25507b.mo42761b(7, this.AoO);
            }
            if (this.AoP != null) {
                c25507b.mo42760a(8, this.AoP);
            }
            if (!Arrays.equals(this.AoQ, C45015g.bxA)) {
                c25507b.mo42761b(9, this.AoQ);
            }
            if (this.AoR != null) {
                c25507b.mo42760a(10, this.AoR);
            }
            if (!this.AoS.equals("")) {
                c25507b.mo42764e(100, this.AoS);
            }
            if (!this.AoT.equals("")) {
                c25507b.mo42764e(101, this.AoT);
            }
            if (this.AoU != 0) {
                c25507b.mo42765l(200, this.AoU);
            }
            if (!Arrays.equals(this.AoV, C45015g.bxA)) {
                c25507b.mo42761b(201, this.AoV);
            }
            if (!Arrays.equals(this.AoW, C45015g.bxA)) {
                c25507b.mo42761b(202, this.AoW);
            }
            if (!Arrays.equals(this.AoX, C45015g.bxA)) {
                c25507b.mo42761b(203, this.AoX);
            }
            if (!Arrays.equals(this.AoY, C45015g.bxA)) {
                c25507b.mo42761b(204, this.AoY);
            }
            if (this.AoZ != 0) {
                c25507b.mo42762bq(220, this.AoZ);
            }
            if (!Arrays.equals(this.Apa, C45015g.bxA)) {
                c25507b.mo42761b(221, this.Apa);
            }
            if (!Arrays.equals(this.Apb, C45015g.bxA)) {
                c25507b.mo42761b(222, this.Apb);
            }
            if (!Arrays.equals(this.bFS, C45015g.bxA)) {
                c25507b.mo42761b(223, this.bFS);
            }
            if (this.Apc != 0) {
                c25507b.mo42763br(224, this.Apc);
            }
            if (this.Apd != null && this.Apd.length > 0) {
                for (C25510e c25510e : this.Apd) {
                    if (c25510e != null) {
                        c25507b.mo42760a(225, c25510e);
                    }
                }
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.name.equals("")) {
                vr += C25507b.m40269f(1, this.name);
            }
            if (!Arrays.equals(this.AoK, C45015g.bxA)) {
                vr += C25507b.m40268c(2, this.AoK);
            }
            if (this.cAO != 0) {
                vr += C25507b.m40265bs(3, this.cAO);
            }
            if (this.AoL != 0) {
                vr += C25507b.m40275n(4, this.AoL);
            }
            if (!Arrays.equals(this.AoM, C45015g.bxA)) {
                vr += C25507b.m40268c(5, this.AoM);
            }
            if (!Arrays.equals(this.AoN, C45015g.bxA)) {
                vr += C25507b.m40268c(6, this.AoN);
            }
            if (!Arrays.equals(this.AoO, C45015g.bxA)) {
                vr += C25507b.m40268c(7, this.AoO);
            }
            if (this.AoP != null) {
                vr += C25507b.m40263b(8, this.AoP);
            }
            if (!Arrays.equals(this.AoQ, C45015g.bxA)) {
                vr += C25507b.m40268c(9, this.AoQ);
            }
            if (this.AoR != null) {
                vr += C25507b.m40263b(10, this.AoR);
            }
            if (!this.AoS.equals("")) {
                vr += C25507b.m40269f(100, this.AoS);
            }
            if (!this.AoT.equals("")) {
                vr += C25507b.m40269f(101, this.AoT);
            }
            if (this.AoU != 0) {
                vr += C25507b.m40275n(200, this.AoU);
            }
            if (!Arrays.equals(this.AoV, C45015g.bxA)) {
                vr += C25507b.m40268c(201, this.AoV);
            }
            if (!Arrays.equals(this.AoW, C45015g.bxA)) {
                vr += C25507b.m40268c(202, this.AoW);
            }
            if (!Arrays.equals(this.AoX, C45015g.bxA)) {
                vr += C25507b.m40268c(203, this.AoX);
            }
            if (!Arrays.equals(this.AoY, C45015g.bxA)) {
                vr += C25507b.m40268c(204, this.AoY);
            }
            if (this.AoZ != 0) {
                vr += C25507b.m40265bs(220, this.AoZ);
            }
            if (!Arrays.equals(this.Apa, C45015g.bxA)) {
                vr += C25507b.m40268c(221, this.Apa);
            }
            if (!Arrays.equals(this.Apb, C45015g.bxA)) {
                vr += C25507b.m40268c(222, this.Apb);
            }
            if (!Arrays.equals(this.bFS, C45015g.bxA)) {
                vr += C25507b.m40268c(223, this.bFS);
            }
            if (this.Apc != 0) {
                vr += C25507b.m40266bt(224, this.Apc);
            }
            if (this.Apd == null || this.Apd.length <= 0) {
                return vr;
            }
            int i = vr;
            for (C25510e c25510e : this.Apd) {
                if (c25510e != null) {
                    i += C25507b.m40263b(225, c25510e);
                }
            }
            return i;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$au */
    public static final class C24192au extends C25510e {
        private static volatile C24192au[] Ape;
        public int AmC;
        public C24193av[] AnQ;
        public String Apf;
        public String groupId;
        public int sQS;
        public long sQT;

        public static C24192au[] dPG() {
            if (Ape == null) {
                synchronized (C25508c.bxs) {
                    if (Ape == null) {
                        Ape = new C24192au[0];
                    }
                }
            }
            return Ape;
        }

        public C24192au() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnQ = C24193av.dPH();
            this.AmC = 0;
            this.Apf = "";
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (C25510e c25510e : this.AnQ) {
                    if (c25510e != null) {
                        c25507b.mo42760a(4, c25510e);
                    }
                }
            }
            if (this.AmC != 0) {
                c25507b.mo42763br(5, this.AmC);
            }
            if (!this.Apf.equals("")) {
                c25507b.mo42764e(6, this.Apf);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                int i = vr;
                for (C25510e c25510e : this.AnQ) {
                    if (c25510e != null) {
                        i += C25507b.m40263b(4, c25510e);
                    }
                }
                vr = i;
            }
            if (this.AmC != 0) {
                vr += C25507b.m40266bt(5, this.AmC);
            }
            if (this.Apf.equals("")) {
                return vr;
            }
            return vr + C25507b.m40269f(6, this.Apf);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$av */
    public static final class C24193av extends C25510e {
        private static volatile C24193av[] Apg;
        public int AmI;
        public byte[] AmN;
        public String Aop;
        public int ApA;
        public int ApB;
        public int Aph;
        public int Api;
        public C24225aq Apj;
        public int Apk;
        public String Apl;
        public C24226ar[] Apm;
        public int Apn;
        public int[] Apo;
        public int App;
        public int Apq;
        public int Apr;
        public int Aps;
        public C24204an Apt;
        public String Apu;
        public int Apv;
        public C24233s Apw;
        public int Apx;
        public String Apy;
        public int Apz;
        public int boZ;
        public int kyZ;
        public int platform;
        public int status;
        public int tdt;
        public int vzt;

        public static C24193av[] dPH() {
            if (Apg == null) {
                synchronized (C25508c.bxs) {
                    if (Apg == null) {
                        Apg = new C24193av[0];
                    }
                }
            }
            return Apg;
        }

        public C24193av() {
            this.vzt = 0;
            this.Aph = 0;
            this.status = 0;
            this.boZ = 0;
            this.kyZ = -1;
            this.Api = 0;
            this.Apj = null;
            this.Apk = 0;
            this.Apl = "";
            this.Apm = C24226ar.dPF();
            this.Apn = 0;
            this.Apo = C45015g.bxu;
            this.App = 0;
            this.Apq = 0;
            this.Apr = 0;
            this.Aps = 0;
            this.Apt = null;
            this.Aop = "";
            this.Apu = "";
            this.Apv = 0;
            this.AmN = C45015g.bxA;
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

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (this.vzt != 0) {
                c25507b.mo42763br(1, this.vzt);
            }
            if (this.Aph != 0) {
                c25507b.mo42763br(2, this.Aph);
            }
            if (this.status != 0) {
                c25507b.mo42763br(3, this.status);
            }
            if (this.boZ != 0) {
                c25507b.mo42763br(4, this.boZ);
            }
            if (this.kyZ != -1) {
                c25507b.mo42762bq(5, this.kyZ);
            }
            if (this.Api != 0) {
                c25507b.mo42763br(6, this.Api);
            }
            if (this.Apj != null) {
                c25507b.mo42760a(7, this.Apj);
            }
            if (this.Apk != 0) {
                c25507b.mo42763br(8, this.Apk);
            }
            if (!this.Apl.equals("")) {
                c25507b.mo42764e(9, this.Apl);
            }
            if (this.Apm != null && this.Apm.length > 0) {
                for (C25510e c25510e : this.Apm) {
                    if (c25510e != null) {
                        c25507b.mo42760a(10, c25510e);
                    }
                }
            }
            if (this.Apn != 0) {
                c25507b.mo42763br(11, this.Apn);
            }
            if (this.Apo != null && this.Apo.length > 0) {
                while (i < this.Apo.length) {
                    c25507b.mo42763br(12, this.Apo[i]);
                    i++;
                }
            }
            if (this.App != 0) {
                c25507b.mo42763br(13, this.App);
            }
            if (this.Apq != 0) {
                c25507b.mo42763br(14, this.Apq);
            }
            if (this.Apr != 0) {
                c25507b.mo42763br(15, this.Apr);
            }
            if (this.Aps != 0) {
                c25507b.mo42763br(16, this.Aps);
            }
            if (this.Apt != null) {
                c25507b.mo42760a(17, this.Apt);
            }
            if (!this.Aop.equals("")) {
                c25507b.mo42764e(100, this.Aop);
            }
            if (!this.Apu.equals("")) {
                c25507b.mo42764e(101, this.Apu);
            }
            if (this.Apv != 0) {
                c25507b.mo42763br(102, this.Apv);
            }
            if (!Arrays.equals(this.AmN, C45015g.bxA)) {
                c25507b.mo42761b(200, this.AmN);
            }
            if (this.Apw != null) {
                c25507b.mo42760a(201, this.Apw);
            }
            if (this.Apx != -1) {
                c25507b.mo42762bq(202, this.Apx);
            }
            if (!this.Apy.equals("")) {
                c25507b.mo42764e(203, this.Apy);
            }
            if (this.platform != 0) {
                c25507b.mo42762bq(204, this.platform);
            }
            if (this.Apz != 0) {
                c25507b.mo42763br(205, this.Apz);
            }
            if (this.tdt != 0) {
                c25507b.mo42763br(206, this.tdt);
            }
            if (this.ApA != 0) {
                c25507b.mo42763br(207, this.ApA);
            }
            if (this.ApB != 0) {
                c25507b.mo42763br(208, this.ApB);
            }
            if (this.AmI != 0) {
                c25507b.mo42763br(240, this.AmI);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i;
            int vr = super.mo11879vr();
            if (this.vzt != 0) {
                vr += C25507b.m40266bt(1, this.vzt);
            }
            if (this.Aph != 0) {
                vr += C25507b.m40266bt(2, this.Aph);
            }
            if (this.status != 0) {
                vr += C25507b.m40266bt(3, this.status);
            }
            if (this.boZ != 0) {
                vr += C25507b.m40266bt(4, this.boZ);
            }
            if (this.kyZ != -1) {
                vr += C25507b.m40265bs(5, this.kyZ);
            }
            if (this.Api != 0) {
                vr += C25507b.m40266bt(6, this.Api);
            }
            if (this.Apj != null) {
                vr += C25507b.m40263b(7, this.Apj);
            }
            if (this.Apk != 0) {
                vr += C25507b.m40266bt(8, this.Apk);
            }
            if (!this.Apl.equals("")) {
                vr += C25507b.m40269f(9, this.Apl);
            }
            if (this.Apm != null && this.Apm.length > 0) {
                i = vr;
                for (C25510e c25510e : this.Apm) {
                    if (c25510e != null) {
                        i += C25507b.m40263b(10, c25510e);
                    }
                }
                vr = i;
            }
            if (this.Apn != 0) {
                vr += C25507b.m40266bt(11, this.Apn);
            }
            if (this.Apo != null && this.Apo.length > 0) {
                i = 0;
                for (int fx : this.Apo) {
                    i += C25507b.m40274fx(fx);
                }
                vr = (vr + i) + (this.Apo.length * 1);
            }
            if (this.App != 0) {
                vr += C25507b.m40266bt(13, this.App);
            }
            if (this.Apq != 0) {
                vr += C25507b.m40266bt(14, this.Apq);
            }
            if (this.Apr != 0) {
                vr += C25507b.m40266bt(15, this.Apr);
            }
            if (this.Aps != 0) {
                vr += C25507b.m40266bt(16, this.Aps);
            }
            if (this.Apt != null) {
                vr += C25507b.m40263b(17, this.Apt);
            }
            if (!this.Aop.equals("")) {
                vr += C25507b.m40269f(100, this.Aop);
            }
            if (!this.Apu.equals("")) {
                vr += C25507b.m40269f(101, this.Apu);
            }
            if (this.Apv != 0) {
                vr += C25507b.m40266bt(102, this.Apv);
            }
            if (!Arrays.equals(this.AmN, C45015g.bxA)) {
                vr += C25507b.m40268c(200, this.AmN);
            }
            if (this.Apw != null) {
                vr += C25507b.m40263b(201, this.Apw);
            }
            if (this.Apx != -1) {
                vr += C25507b.m40265bs(202, this.Apx);
            }
            if (!this.Apy.equals("")) {
                vr += C25507b.m40269f(203, this.Apy);
            }
            if (this.platform != 0) {
                vr += C25507b.m40265bs(204, this.platform);
            }
            if (this.Apz != 0) {
                vr += C25507b.m40266bt(205, this.Apz);
            }
            if (this.tdt != 0) {
                vr += C25507b.m40266bt(206, this.tdt);
            }
            if (this.ApA != 0) {
                vr += C25507b.m40266bt(207, this.ApA);
            }
            if (this.ApB != 0) {
                vr += C25507b.m40266bt(208, this.ApB);
            }
            if (this.AmI != 0) {
                return vr + C25507b.m40266bt(240, this.AmI);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$aw */
    public static final class C24194aw extends C25510e {
        private static volatile C24194aw[] ApC;
        public long ApD;
        public String ApE;
        public String ApF;
        public String pHn;
        public String username;
        public int vzt;

        public static C24194aw[] dPI() {
            if (ApC == null) {
                synchronized (C25508c.bxs) {
                    if (ApC == null) {
                        ApC = new C24194aw[0];
                    }
                }
            }
            return ApC;
        }

        public C24194aw() {
            this.vzt = 0;
            this.username = "";
            this.pHn = "";
            this.ApD = 0;
            this.ApE = "";
            this.ApF = "";
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.vzt != 0) {
                c25507b.mo42763br(1, this.vzt);
            }
            if (!this.username.equals("")) {
                c25507b.mo42764e(2, this.username);
            }
            if (!this.pHn.equals("")) {
                c25507b.mo42764e(3, this.pHn);
            }
            if (this.ApD != 0) {
                c25507b.mo42765l(4, this.ApD);
            }
            if (!this.ApE.equals("")) {
                c25507b.mo42764e(5, this.ApE);
            }
            if (!this.ApF.equals("")) {
                c25507b.mo42764e(6, this.ApF);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.vzt != 0) {
                vr += C25507b.m40266bt(1, this.vzt);
            }
            if (!this.username.equals("")) {
                vr += C25507b.m40269f(2, this.username);
            }
            if (!this.pHn.equals("")) {
                vr += C25507b.m40269f(3, this.pHn);
            }
            if (this.ApD != 0) {
                vr += C25507b.m40275n(4, this.ApD);
            }
            if (!this.ApE.equals("")) {
                vr += C25507b.m40269f(5, this.ApE);
            }
            if (this.ApF.equals("")) {
                return vr;
            }
            return vr + C25507b.m40269f(6, this.ApF);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ax */
    public static final class C24195ax extends C25510e {
        public int ApG;

        public C24195ax() {
            this.ApG = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.ApG != 0) {
                c25507b.mo42763br(1, this.ApG);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.ApG != 0) {
                return vr + C25507b.m40266bt(1, this.ApG);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$f */
    public static final class C24196f extends C25510e {
        public int AmM;
        public int boZ;
        public String groupId;
        public int sQS;
        public long sQT;

        public C24196f() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.boZ = 0;
            this.AmM = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.boZ != 0) {
                c25507b.mo42762bq(4, this.boZ);
            }
            if (this.AmM != 0) {
                c25507b.mo42762bq(5, this.AmM);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.boZ != 0) {
                vr += C25507b.m40265bs(4, this.boZ);
            }
            if (this.AmM != 0) {
                return vr + C25507b.m40265bs(5, this.AmM);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$p */
    public static final class C24197p extends C25510e {
        public int AmC;
        public C24228ay AmE;
        public C24191at Amz;
        public int Anb;
        public C24194aw[] Anc;
        public C24193av[] And;
        public C24227as Ane;
        public int Anf;
        public int Ang;
        public int Anh;
        public byte[] Ani;
        public byte[] Anj;
        public C24193av[] Ank;
        public long cvx;
        public String groupId;
        public int sQS;
        public long sQT;

        public C24197p() {
            this.Anb = 0;
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmC = 0;
            this.Amz = null;
            this.Anc = C24194aw.dPI();
            this.And = C24193av.dPH();
            this.Ane = null;
            this.AmE = null;
            this.Anf = 0;
            this.Ang = 0;
            this.cvx = 0;
            this.Anh = 0;
            this.Ani = C45015g.bxA;
            this.Anj = C45015g.bxA;
            this.Ank = C24193av.dPH();
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (this.Anb != 0) {
                c25507b.mo42762bq(1, this.Anb);
            }
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(2, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(3, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(4, this.sQT);
            }
            if (this.AmC != 0) {
                c25507b.mo42763br(5, this.AmC);
            }
            if (this.Amz != null) {
                c25507b.mo42760a(6, this.Amz);
            }
            if (this.Anc != null && this.Anc.length > 0) {
                for (C25510e c25510e : this.Anc) {
                    if (c25510e != null) {
                        c25507b.mo42760a(7, c25510e);
                    }
                }
            }
            if (this.And != null && this.And.length > 0) {
                for (C25510e c25510e2 : this.And) {
                    if (c25510e2 != null) {
                        c25507b.mo42760a(8, c25510e2);
                    }
                }
            }
            if (this.Ane != null) {
                c25507b.mo42760a(9, this.Ane);
            }
            if (this.AmE != null) {
                c25507b.mo42760a(10, this.AmE);
            }
            if (this.Anf != 0) {
                c25507b.mo42763br(11, this.Anf);
            }
            if (this.Ang != 0) {
                c25507b.mo42763br(12, this.Ang);
            }
            if (this.cvx != 0) {
                c25507b.mo42765l(101, this.cvx);
            }
            if (this.Anh != 0) {
                c25507b.mo42763br(102, this.Anh);
            }
            if (!Arrays.equals(this.Ani, C45015g.bxA)) {
                c25507b.mo42761b(103, this.Ani);
            }
            if (!Arrays.equals(this.Anj, C45015g.bxA)) {
                c25507b.mo42761b(200, this.Anj);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i < this.Ank.length) {
                    C25510e c25510e3 = this.Ank[i];
                    if (c25510e3 != null) {
                        c25507b.mo42760a(201, c25510e3);
                    }
                    i++;
                }
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i;
            int i2 = 0;
            int vr = super.mo11879vr();
            if (this.Anb != 0) {
                vr += C25507b.m40265bs(1, this.Anb);
            }
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(2, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(3, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(4, this.sQT);
            }
            if (this.AmC != 0) {
                vr += C25507b.m40266bt(5, this.AmC);
            }
            if (this.Amz != null) {
                vr += C25507b.m40263b(6, this.Amz);
            }
            if (this.Anc != null && this.Anc.length > 0) {
                i = vr;
                for (C25510e c25510e : this.Anc) {
                    if (c25510e != null) {
                        i += C25507b.m40263b(7, c25510e);
                    }
                }
                vr = i;
            }
            if (this.And != null && this.And.length > 0) {
                i = vr;
                for (C25510e c25510e2 : this.And) {
                    if (c25510e2 != null) {
                        i += C25507b.m40263b(8, c25510e2);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += C25507b.m40263b(9, this.Ane);
            }
            if (this.AmE != null) {
                vr += C25507b.m40263b(10, this.AmE);
            }
            if (this.Anf != 0) {
                vr += C25507b.m40266bt(11, this.Anf);
            }
            if (this.Ang != 0) {
                vr += C25507b.m40266bt(12, this.Ang);
            }
            if (this.cvx != 0) {
                vr += C25507b.m40275n(101, this.cvx);
            }
            if (this.Anh != 0) {
                vr += C25507b.m40266bt(102, this.Anh);
            }
            if (!Arrays.equals(this.Ani, C45015g.bxA)) {
                vr += C25507b.m40268c(103, this.Ani);
            }
            if (!Arrays.equals(this.Anj, C45015g.bxA)) {
                vr += C25507b.m40268c(200, this.Anj);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i2 < this.Ank.length) {
                    C25510e c25510e3 = this.Ank[i2];
                    if (c25510e3 != null) {
                        vr += C25507b.m40263b(201, c25510e3);
                    }
                    i2++;
                }
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$q */
    public static final class C24198q extends C25510e {
        public int Anl;

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            c25507b.mo42763br(1, this.Anl);
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            return super.mo11879vr() + C25507b.m40266bt(1, this.Anl);
        }

        public C24198q() {
            this.Anl = 0;
            this.bxt = -1;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$v */
    public static final class C24199v extends C25510e {
        public C24235u AnM;
        public byte[] body;

        public C24199v() {
            this.AnM = null;
            this.body = C45015g.bxA;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.AnM != null) {
                c25507b.mo42760a(1, this.AnM);
            }
            if (!Arrays.equals(this.body, C45015g.bxA)) {
                c25507b.mo42761b(2, this.body);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.AnM != null) {
                vr += C25507b.m40263b(1, this.AnM);
            }
            if (Arrays.equals(this.body, C45015g.bxA)) {
                return vr;
            }
            return vr + C25507b.m40268c(2, this.body);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$x */
    public static final class C24200x extends C25510e {
        public C24191at Amz;
        public C24193av[] AnQ;
        public String groupId;
        public int sQS;
        public long sQT;

        public C24200x() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnQ = C24193av.dPH();
            this.Amz = null;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (C25510e c25510e : this.AnQ) {
                    if (c25510e != null) {
                        c25507b.mo42760a(4, c25510e);
                    }
                }
            }
            if (this.Amz != null) {
                c25507b.mo42760a(5, this.Amz);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                int i = vr;
                for (C25510e c25510e : this.AnQ) {
                    if (c25510e != null) {
                        i += C25507b.m40263b(4, c25510e);
                    }
                }
                vr = i;
            }
            if (this.Amz != null) {
                return vr + C25507b.m40263b(5, this.Amz);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$y */
    public static final class C24201y extends C25510e {
        public String Amx;

        public C24201y() {
            this.Amx = "";
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.Amx.equals("")) {
                c25507b.mo42764e(1, this.Amx);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.Amx.equals("")) {
                return vr;
            }
            return vr + C25507b.m40269f(1, this.Amx);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$al */
    public static final class C24203al extends C25510e {
        public byte[] buffer;
        public int iLen;

        public C24203al() {
            this.iLen = 0;
            this.buffer = C45015g.bxA;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            c25507b.mo42763br(1, this.iLen);
            if (!Arrays.equals(this.buffer, C45015g.bxA)) {
                c25507b.mo42761b(2, this.buffer);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr() + C25507b.m40266bt(1, this.iLen);
            if (Arrays.equals(this.buffer, C45015g.bxA)) {
                return vr;
            }
            return vr + C25507b.m40268c(2, this.buffer);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$an */
    public static final class C24204an extends C25510e {
        public int Aor;
        public long fNf;
        public int fQi;

        public C24204an() {
            this.fNf = 0;
            this.fQi = 0;
            this.Aor = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.fNf != 0) {
                c25507b.mo42765l(1, this.fNf);
            }
            if (this.fQi != 0) {
                c25507b.mo42763br(2, this.fQi);
            }
            if (this.Aor != 0) {
                c25507b.mo42763br(3, this.Aor);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.fNf != 0) {
                vr += C25507b.m40275n(1, this.fNf);
            }
            if (this.fQi != 0) {
                vr += C25507b.m40266bt(2, this.fQi);
            }
            if (this.Aor != 0) {
                return vr + C25507b.m40266bt(3, this.Aor);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ba */
    public static final class C24205ba extends C25510e {
        public C24203al ApN;
        public int type;

        public C24205ba() {
            this.type = 0;
            this.ApN = null;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.type != 0) {
                c25507b.mo42762bq(1, this.type);
            }
            if (this.ApN != null) {
                c25507b.mo42760a(2, this.ApN);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.type != 0) {
                vr += C25507b.m40265bs(1, this.type);
            }
            if (this.ApN != null) {
                return vr + C25507b.m40263b(2, this.ApN);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$e */
    public static final class C24206e extends C25510e {
        public C24205ba AmB;
        public int AmD;
        public String[] AmG;
        public C24223m[] AmH;
        public int AmI;
        public int AmJ;
        public C24233s AmK;
        public int AmL;
        public int Amv;
        public C24191at Amz;
        public String groupId;
        public int netType;
        public int sQS;
        public long sQT;

        public C24206e() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmB = null;
            this.AmJ = 0;
            this.AmD = 0;
            this.Amv = 0;
            this.netType = 0;
            this.Amz = null;
            this.AmG = C45015g.EMPTY_STRING_ARRAY;
            this.AmH = C24223m.dPz();
            this.AmK = null;
            this.AmL = 0;
            this.AmI = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.AmB != null) {
                c25507b.mo42760a(4, this.AmB);
            }
            if (this.AmJ != 0) {
                c25507b.mo42762bq(5, this.AmJ);
            }
            if (this.AmD != 0) {
                c25507b.mo42763br(6, this.AmD);
            }
            if (this.Amv != 0) {
                c25507b.mo42762bq(7, this.Amv);
            }
            if (this.netType != 0) {
                c25507b.mo42763br(8, this.netType);
            }
            if (this.Amz != null) {
                c25507b.mo42760a(200, this.Amz);
            }
            if (this.AmG != null && this.AmG.length > 0) {
                for (String str : this.AmG) {
                    if (str != null) {
                        c25507b.mo42764e(201, str);
                    }
                }
            }
            if (this.AmH != null && this.AmH.length > 0) {
                while (i < this.AmH.length) {
                    C25510e c25510e = this.AmH[i];
                    if (c25510e != null) {
                        c25507b.mo42760a(202, c25510e);
                    }
                    i++;
                }
            }
            if (this.AmK != null) {
                c25507b.mo42760a(203, this.AmK);
            }
            if (this.AmL != 0) {
                c25507b.mo42763br(204, this.AmL);
            }
            if (this.AmI != 0) {
                c25507b.mo42763br(240, this.AmI);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i = 0;
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.AmB != null) {
                vr += C25507b.m40263b(4, this.AmB);
            }
            if (this.AmJ != 0) {
                vr += C25507b.m40265bs(5, this.AmJ);
            }
            if (this.AmD != 0) {
                vr += C25507b.m40266bt(6, this.AmD);
            }
            if (this.Amv != 0) {
                vr += C25507b.m40265bs(7, this.Amv);
            }
            if (this.netType != 0) {
                vr += C25507b.m40266bt(8, this.netType);
            }
            if (this.Amz != null) {
                vr += C25507b.m40263b(200, this.Amz);
            }
            if (this.AmG != null && this.AmG.length > 0) {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.AmG) {
                    if (str != null) {
                        i3++;
                        i2 += C25507b.m40264bf(str);
                    }
                }
                vr = (vr + i2) + (i3 * 2);
            }
            if (this.AmH != null && this.AmH.length > 0) {
                while (i < this.AmH.length) {
                    C25510e c25510e = this.AmH[i];
                    if (c25510e != null) {
                        vr += C25507b.m40263b(202, c25510e);
                    }
                    i++;
                }
            }
            if (this.AmK != null) {
                vr += C25507b.m40263b(203, this.AmK);
            }
            if (this.AmL != 0) {
                vr += C25507b.m40266bt(204, this.AmL);
            }
            if (this.AmI != 0) {
                return vr + C25507b.m40266bt(240, this.AmI);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$g */
    public static final class C24207g extends C25510e {
        public String Amx;
        public int boZ;
        public String groupId;
        public int sQS;
        public long sQT;

        public C24207g() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.boZ = 0;
            this.Amx = "";
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.boZ != 0) {
                c25507b.mo42762bq(4, this.boZ);
            }
            if (!this.Amx.equals("")) {
                c25507b.mo42764e(5, this.Amx);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.boZ != 0) {
                vr += C25507b.m40265bs(4, this.boZ);
            }
            if (this.Amx.equals("")) {
                return vr;
            }
            return vr + C25507b.m40269f(5, this.Amx);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$n */
    public static final class C24208n extends C25510e {
        private static volatile C24208n[] AmW;
        public int AmX;
        public int AmY;
        public byte[] cDT;

        public static C24208n[] dPA() {
            if (AmW == null) {
                synchronized (C25508c.bxs) {
                    if (AmW == null) {
                        AmW = new C24208n[0];
                    }
                }
            }
            return AmW;
        }

        public C24208n() {
            this.AmX = 0;
            this.cDT = C45015g.bxA;
            this.AmY = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.AmX != 0) {
                c25507b.mo42762bq(1, this.AmX);
            }
            if (!Arrays.equals(this.cDT, C45015g.bxA)) {
                c25507b.mo42761b(2, this.cDT);
            }
            if (this.AmY != 0) {
                c25507b.mo42763br(3, this.AmY);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.AmX != 0) {
                vr += C25507b.m40265bs(1, this.AmX);
            }
            if (!Arrays.equals(this.cDT, C45015g.bxA)) {
                vr += C25507b.m40268c(2, this.cDT);
            }
            if (this.AmY != 0) {
                return vr + C25507b.m40266bt(3, this.AmY);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$z */
    public static final class C24209z extends C25510e {
        public int AmC;
        public int AmX;
        public String Amx;
        public C24191at Amz;
        public C16120o[] AnR;
        public C24194aw[] AnS;
        public int AnT;
        public int[] AnU;
        public C16120o[] AnV;
        public int AnW;
        public int AnX;
        public C16120o[] AnY;
        public int AnZ;
        public C24193av[] And;
        public C24227as Ane;
        public int Ang;
        public C24193av[] Ank;
        public int Aoa;
        public int Aob;
        public byte[] Aoc;
        public int[] Aod;
        public String groupId;
        public int sQS;
        public long sQT;
        public int wbi;

        public C24209z() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmC = 0;
            this.AnR = C16120o.dPB();
            this.AnS = C24194aw.dPI();
            this.Ane = null;
            this.Amx = "";
            this.And = C24193av.dPH();
            this.AnT = 0;
            this.AnU = C45015g.bxu;
            this.Amz = null;
            this.AmX = 0;
            this.AnV = C16120o.dPB();
            this.AnW = 0;
            this.AnX = 0;
            this.Ank = C24193av.dPH();
            this.AnY = C16120o.dPB();
            this.AnZ = 0;
            this.Aoa = 0;
            this.Aob = 0;
            this.Aoc = C45015g.bxA;
            this.wbi = -1;
            this.Aod = C45015g.bxu;
            this.Ang = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.AmC != 0) {
                c25507b.mo42763br(4, this.AmC);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                for (C25510e c25510e : this.AnR) {
                    if (c25510e != null) {
                        c25507b.mo42760a(5, c25510e);
                    }
                }
            }
            if (this.AnS != null && this.AnS.length > 0) {
                for (C25510e c25510e2 : this.AnS) {
                    if (c25510e2 != null) {
                        c25507b.mo42760a(6, c25510e2);
                    }
                }
            }
            if (this.Ane != null) {
                c25507b.mo42760a(7, this.Ane);
            }
            if (!this.Amx.equals("")) {
                c25507b.mo42764e(8, this.Amx);
            }
            if (this.And != null && this.And.length > 0) {
                for (C25510e c25510e22 : this.And) {
                    if (c25510e22 != null) {
                        c25507b.mo42760a(9, c25510e22);
                    }
                }
            }
            if (this.AnT != 0) {
                c25507b.mo42762bq(10, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                for (int bq : this.AnU) {
                    c25507b.mo42762bq(11, bq);
                }
            }
            if (this.Amz != null) {
                c25507b.mo42760a(12, this.Amz);
            }
            if (this.AmX != 0) {
                c25507b.mo42763br(13, this.AmX);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                for (C25510e c25510e222 : this.AnV) {
                    if (c25510e222 != null) {
                        c25507b.mo42760a(14, c25510e222);
                    }
                }
            }
            if (this.AnW != 0) {
                c25507b.mo42763br(15, this.AnW);
            }
            if (this.AnX != 0) {
                c25507b.mo42763br(16, this.AnX);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                for (C25510e c25510e2222 : this.Ank) {
                    if (c25510e2222 != null) {
                        c25507b.mo42760a(17, c25510e2222);
                    }
                }
            }
            if (this.AnY != null && this.AnY.length > 0) {
                for (C25510e c25510e22222 : this.AnY) {
                    if (c25510e22222 != null) {
                        c25507b.mo42760a(18, c25510e22222);
                    }
                }
            }
            if (this.AnZ != 0) {
                c25507b.mo42762bq(19, this.AnZ);
            }
            if (this.Aoa != 0) {
                c25507b.mo42762bq(20, this.Aoa);
            }
            if (this.Aob != 0) {
                c25507b.mo42762bq(21, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, C45015g.bxA)) {
                c25507b.mo42761b(22, this.Aoc);
            }
            if (this.wbi != -1) {
                c25507b.mo42762bq(23, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                while (i < this.Aod.length) {
                    c25507b.mo42763br(24, this.Aod[i]);
                    i++;
                }
            }
            if (this.Ang != 0) {
                c25507b.mo42763br(25, this.Ang);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i;
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.AmC != 0) {
                vr += C25507b.m40266bt(4, this.AmC);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                i = vr;
                for (C25510e c25510e : this.AnR) {
                    if (c25510e != null) {
                        i += C25507b.m40263b(5, c25510e);
                    }
                }
                vr = i;
            }
            if (this.AnS != null && this.AnS.length > 0) {
                i = vr;
                for (C25510e c25510e2 : this.AnS) {
                    if (c25510e2 != null) {
                        i += C25507b.m40263b(6, c25510e2);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += C25507b.m40263b(7, this.Ane);
            }
            if (!this.Amx.equals("")) {
                vr += C25507b.m40269f(8, this.Amx);
            }
            if (this.And != null && this.And.length > 0) {
                i = vr;
                for (C25510e c25510e22 : this.And) {
                    if (c25510e22 != null) {
                        i += C25507b.m40263b(9, c25510e22);
                    }
                }
                vr = i;
            }
            if (this.AnT != 0) {
                vr += C25507b.m40265bs(10, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                i = 0;
                for (int ft : this.AnU) {
                    i += C25507b.m40270ft(ft);
                }
                vr = (vr + i) + (this.AnU.length * 1);
            }
            if (this.Amz != null) {
                vr += C25507b.m40263b(12, this.Amz);
            }
            if (this.AmX != 0) {
                vr += C25507b.m40266bt(13, this.AmX);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                i = vr;
                for (C25510e c25510e222 : this.AnV) {
                    if (c25510e222 != null) {
                        i += C25507b.m40263b(14, c25510e222);
                    }
                }
                vr = i;
            }
            if (this.AnW != 0) {
                vr += C25507b.m40266bt(15, this.AnW);
            }
            if (this.AnX != 0) {
                vr += C25507b.m40266bt(16, this.AnX);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                i = vr;
                for (C25510e c25510e2222 : this.Ank) {
                    if (c25510e2222 != null) {
                        i += C25507b.m40263b(17, c25510e2222);
                    }
                }
                vr = i;
            }
            if (this.AnY != null && this.AnY.length > 0) {
                i = vr;
                for (C25510e c25510e22222 : this.AnY) {
                    if (c25510e22222 != null) {
                        i += C25507b.m40263b(18, c25510e22222);
                    }
                }
                vr = i;
            }
            if (this.AnZ != 0) {
                vr += C25507b.m40265bs(19, this.AnZ);
            }
            if (this.Aoa != 0) {
                vr += C25507b.m40265bs(20, this.Aoa);
            }
            if (this.Aob != 0) {
                vr += C25507b.m40265bs(21, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, C45015g.bxA)) {
                vr += C25507b.m40268c(22, this.Aoc);
            }
            if (this.wbi != -1) {
                vr += C25507b.m40265bs(23, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                i = 0;
                for (int fx : this.Aod) {
                    i += C25507b.m40274fx(fx);
                }
                vr = (vr + i) + (this.Aod.length * 2);
            }
            if (this.Ang != 0) {
                return vr + C25507b.m40266bt(25, this.Ang);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$a */
    public static final class C24210a extends C25510e {
        public int[] Amu;
        public int Amv;
        public String[] Amw;
        public String groupId;
        public int sQS;
        public long sQT;

        public C24210a() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.Amu = C45015g.bxu;
            this.Amv = 0;
            this.Amw = C45015g.EMPTY_STRING_ARRAY;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.Amu != null && this.Amu.length > 0) {
                for (int br : this.Amu) {
                    c25507b.mo42763br(4, br);
                }
            }
            if (this.Amv != 0) {
                c25507b.mo42762bq(5, this.Amv);
            }
            if (this.Amw != null && this.Amw.length > 0) {
                while (i < this.Amw.length) {
                    String str = this.Amw[i];
                    if (str != null) {
                        c25507b.mo42764e(100, str);
                    }
                    i++;
                }
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i;
            int i2;
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.Amu != null && this.Amu.length > 0) {
                i = 0;
                for (int i22 : this.Amu) {
                    i += C25507b.m40274fx(i22);
                }
                vr = (vr + i) + (this.Amu.length * 1);
            }
            if (this.Amv != 0) {
                vr += C25507b.m40265bs(5, this.Amv);
            }
            if (this.Amw == null || this.Amw.length <= 0) {
                return vr;
            }
            i = 0;
            i22 = 0;
            for (String str : this.Amw) {
                if (str != null) {
                    i22++;
                    i += C25507b.m40264bf(str);
                }
            }
            return (vr + i) + (i22 * 2);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ab */
    public static final class C24211ab extends C25510e {
        public String groupId;
        public int sQS;
        public long sQT;

        public C24211ab() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                return vr + C25507b.m40276o(3, this.sQT);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ae */
    public static final class C24212ae extends C25510e {
        public int nwu;
        public long nwv;

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.nwu != 0) {
                c25507b.mo42762bq(1, this.nwu);
            }
            if (this.nwv != 0) {
                c25507b.mo42766m(2, this.nwv);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.nwu != 0) {
                vr += C25507b.m40265bs(1, this.nwu);
            }
            return this.nwv != 0 ? vr + C25507b.m40276o(2, this.nwv) : vr;
        }

        public C24212ae() {
            this.nwu = 0;
            this.nwv = 0;
            this.bxt = -1;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ah */
    public static final class C24213ah extends C25510e {
        public C24192au[] Aon;

        public C24213ah() {
            this.Aon = C24192au.dPG();
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.Aon != null && this.Aon.length > 0) {
                for (C25510e c25510e : this.Aon) {
                    if (c25510e != null) {
                        c25507b.mo42760a(1, c25510e);
                    }
                }
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.Aon != null && this.Aon.length > 0) {
                for (C25510e c25510e : this.Aon) {
                    if (c25510e != null) {
                        vr += C25507b.m40263b(1, c25510e);
                    }
                }
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$b */
    public static final class C24214b extends C25510e {
        public String Amx;
        public int boZ;

        public C24214b() {
            this.Amx = "";
            this.boZ = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.Amx.equals("")) {
                c25507b.mo42764e(1, this.Amx);
            }
            if (this.boZ != 0) {
                c25507b.mo42762bq(2, this.boZ);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.Amx.equals("")) {
                vr += C25507b.m40269f(1, this.Amx);
            }
            if (this.boZ != 0) {
                return vr + C25507b.m40265bs(2, this.boZ);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$bb */
    public static final class C24215bb extends C25510e {
        public int AmC;
        public C24193av[] AnQ;
        public int ApO;
        public String ApP;
        public String[] ApQ;
        public long ApR;
        public String Apf;
        public String groupId;
        public int sQS;
        public long sQT;

        public C24215bb() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmC = 0;
            this.ApO = 0;
            this.Apf = "";
            this.AnQ = C24193av.dPH();
            this.ApP = "";
            this.ApQ = C45015g.EMPTY_STRING_ARRAY;
            this.ApR = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.AmC != 0) {
                c25507b.mo42763br(4, this.AmC);
            }
            if (this.ApO != 0) {
                c25507b.mo42762bq(5, this.ApO);
            }
            if (!this.Apf.equals("")) {
                c25507b.mo42764e(6, this.Apf);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (C25510e c25510e : this.AnQ) {
                    if (c25510e != null) {
                        c25507b.mo42760a(7, c25510e);
                    }
                }
            }
            if (!this.ApP.equals("")) {
                c25507b.mo42764e(8, this.ApP);
            }
            if (this.ApQ != null && this.ApQ.length > 0) {
                while (i < this.ApQ.length) {
                    String str = this.ApQ[i];
                    if (str != null) {
                        c25507b.mo42764e(9, str);
                    }
                    i++;
                }
            }
            if (this.ApR != 0) {
                c25507b.mo42765l(10, this.ApR);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i;
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.AmC != 0) {
                vr += C25507b.m40266bt(4, this.AmC);
            }
            if (this.ApO != 0) {
                vr += C25507b.m40265bs(5, this.ApO);
            }
            if (!this.Apf.equals("")) {
                vr += C25507b.m40269f(6, this.Apf);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                i = vr;
                for (C25510e c25510e : this.AnQ) {
                    if (c25510e != null) {
                        i += C25507b.m40263b(7, c25510e);
                    }
                }
                vr = i;
            }
            if (!this.ApP.equals("")) {
                vr += C25507b.m40269f(8, this.ApP);
            }
            if (this.ApQ != null && this.ApQ.length > 0) {
                i = 0;
                int i2 = 0;
                for (String str : this.ApQ) {
                    if (str != null) {
                        i2++;
                        i += C25507b.m40264bf(str);
                    }
                }
                vr = (vr + i) + (i2 * 1);
            }
            if (this.ApR != 0) {
                return vr + C25507b.m40275n(10, this.ApR);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$c */
    public static final class C24216c extends C25510e {
        public C24218w[] Amy;

        public C24216c() {
            this.Amy = C24218w.dPC();
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.Amy != null && this.Amy.length > 0) {
                for (C25510e c25510e : this.Amy) {
                    if (c25510e != null) {
                        c25507b.mo42760a(1, c25510e);
                    }
                }
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.Amy != null && this.Amy.length > 0) {
                for (C25510e c25510e : this.Amy) {
                    if (c25510e != null) {
                        vr += C25507b.m40263b(1, c25510e);
                    }
                }
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$d */
    public static final class C24217d extends C25510e {
        public int[] AmA;
        public C24205ba AmB;
        public int AmC;
        public int AmD;
        public C24228ay AmE;
        public String AmF;
        public String[] AmG;
        public C24223m[] AmH;
        public int AmI;
        public String Amx;
        public C24191at Amz;
        public int netType;

        public C24217d() {
            this.Amz = null;
            this.AmA = C45015g.bxu;
            this.AmB = null;
            this.AmC = 0;
            this.AmD = 0;
            this.AmE = null;
            this.Amx = "";
            this.AmF = "";
            this.netType = 0;
            this.AmG = C45015g.EMPTY_STRING_ARRAY;
            this.AmH = C24223m.dPz();
            this.AmI = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (this.Amz != null) {
                c25507b.mo42760a(1, this.Amz);
            }
            if (this.AmA != null && this.AmA.length > 0) {
                for (int br : this.AmA) {
                    c25507b.mo42763br(2, br);
                }
            }
            if (this.AmB != null) {
                c25507b.mo42760a(3, this.AmB);
            }
            if (this.AmC != 0) {
                c25507b.mo42763br(4, this.AmC);
            }
            if (this.AmD != 0) {
                c25507b.mo42763br(5, this.AmD);
            }
            if (this.AmE != null) {
                c25507b.mo42760a(6, this.AmE);
            }
            if (!this.Amx.equals("")) {
                c25507b.mo42764e(7, this.Amx);
            }
            if (!this.AmF.equals("")) {
                c25507b.mo42764e(8, this.AmF);
            }
            if (this.netType != 0) {
                c25507b.mo42763br(9, this.netType);
            }
            if (this.AmG != null && this.AmG.length > 0) {
                for (String str : this.AmG) {
                    if (str != null) {
                        c25507b.mo42764e(100, str);
                    }
                }
            }
            if (this.AmH != null && this.AmH.length > 0) {
                while (i < this.AmH.length) {
                    C25510e c25510e = this.AmH[i];
                    if (c25510e != null) {
                        c25507b.mo42760a(202, c25510e);
                    }
                    i++;
                }
            }
            if (this.AmI != 0) {
                c25507b.mo42763br(240, this.AmI);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i;
            int i2;
            int i3 = 0;
            int vr = super.mo11879vr();
            if (this.Amz != null) {
                vr += C25507b.m40263b(1, this.Amz);
            }
            if (this.AmA != null && this.AmA.length > 0) {
                i = 0;
                for (int i22 : this.AmA) {
                    i += C25507b.m40274fx(i22);
                }
                vr = (vr + i) + (this.AmA.length * 1);
            }
            if (this.AmB != null) {
                vr += C25507b.m40263b(3, this.AmB);
            }
            if (this.AmC != 0) {
                vr += C25507b.m40266bt(4, this.AmC);
            }
            if (this.AmD != 0) {
                vr += C25507b.m40266bt(5, this.AmD);
            }
            if (this.AmE != null) {
                vr += C25507b.m40263b(6, this.AmE);
            }
            if (!this.Amx.equals("")) {
                vr += C25507b.m40269f(7, this.Amx);
            }
            if (!this.AmF.equals("")) {
                vr += C25507b.m40269f(8, this.AmF);
            }
            if (this.netType != 0) {
                vr += C25507b.m40266bt(9, this.netType);
            }
            if (this.AmG != null && this.AmG.length > 0) {
                i = 0;
                i22 = 0;
                for (String str : this.AmG) {
                    if (str != null) {
                        i22++;
                        i += C25507b.m40264bf(str);
                    }
                }
                vr = (vr + i) + (i22 * 2);
            }
            if (this.AmH != null && this.AmH.length > 0) {
                while (i3 < this.AmH.length) {
                    C25510e c25510e = this.AmH[i3];
                    if (c25510e != null) {
                        vr += C25507b.m40263b(202, c25510e);
                    }
                    i3++;
                }
            }
            if (this.AmI != 0) {
                return vr + C25507b.m40266bt(240, this.AmI);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$w */
    public static final class C24218w extends C25510e {
        private static volatile C24218w[] AnN;
        public String AnO;
        public String AnP;

        public static C24218w[] dPC() {
            if (AnN == null) {
                synchronized (C25508c.bxs) {
                    if (AnN == null) {
                        AnN = new C24218w[0];
                    }
                }
            }
            return AnN;
        }

        public C24218w() {
            this.AnO = "";
            this.AnP = "";
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.AnO.equals("")) {
                c25507b.mo42764e(1, this.AnO);
            }
            if (!this.AnP.equals("")) {
                c25507b.mo42764e(2, this.AnP);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.AnO.equals("")) {
                vr += C25507b.m40269f(1, this.AnO);
            }
            if (this.AnP.equals("")) {
                return vr;
            }
            return vr + C25507b.m40269f(2, this.AnP);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$aa */
    public static final class C24219aa extends C25510e {
        public int AmJ;
        public int AmX;
        public C24191at Amz;
        public C24193av[] AnQ;
        public C16120o[] AnR;
        public C24194aw[] AnS;
        public int AnT;
        public int[] AnU;
        public C16120o[] AnV;
        public int AnW;
        public int AnX;
        public C16120o[] AnY;
        public int AnZ;
        public C24227as Ane;
        public int Ang;
        public C24193av[] Ank;
        public int Aoa;
        public int Aob;
        public byte[] Aoc;
        public int[] Aod;
        public String groupId;
        public int sQS;
        public long sQT;
        public int wbi;

        public C24219aa() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnR = C16120o.dPB();
            this.AnQ = C24193av.dPH();
            this.Ane = null;
            this.AnT = 0;
            this.AnU = C45015g.bxu;
            this.AmJ = 0;
            this.AnS = C24194aw.dPI();
            this.Amz = null;
            this.AmX = 0;
            this.AnV = C16120o.dPB();
            this.AnY = C16120o.dPB();
            this.AnZ = 0;
            this.Aoa = 0;
            this.Aob = 0;
            this.Aoc = C45015g.bxA;
            this.wbi = -1;
            this.Aod = C45015g.bxu;
            this.Ang = 0;
            this.AnW = 0;
            this.AnX = 0;
            this.Ank = C24193av.dPH();
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                for (C25510e c25510e : this.AnR) {
                    if (c25510e != null) {
                        c25507b.mo42760a(4, c25510e);
                    }
                }
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (C25510e c25510e2 : this.AnQ) {
                    if (c25510e2 != null) {
                        c25507b.mo42760a(5, c25510e2);
                    }
                }
            }
            if (this.Ane != null) {
                c25507b.mo42760a(6, this.Ane);
            }
            if (this.AnT != 0) {
                c25507b.mo42762bq(7, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                for (int bq : this.AnU) {
                    c25507b.mo42762bq(8, bq);
                }
            }
            if (this.AmJ != 0) {
                c25507b.mo42762bq(9, this.AmJ);
            }
            if (this.AnS != null && this.AnS.length > 0) {
                for (C25510e c25510e22 : this.AnS) {
                    if (c25510e22 != null) {
                        c25507b.mo42760a(10, c25510e22);
                    }
                }
            }
            if (this.Amz != null) {
                c25507b.mo42760a(11, this.Amz);
            }
            if (this.AmX != 0) {
                c25507b.mo42763br(12, this.AmX);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                for (C25510e c25510e222 : this.AnV) {
                    if (c25510e222 != null) {
                        c25507b.mo42760a(13, c25510e222);
                    }
                }
            }
            if (this.AnY != null && this.AnY.length > 0) {
                for (C25510e c25510e2222 : this.AnY) {
                    if (c25510e2222 != null) {
                        c25507b.mo42760a(14, c25510e2222);
                    }
                }
            }
            if (this.AnZ != 0) {
                c25507b.mo42762bq(15, this.AnZ);
            }
            if (this.Aoa != 0) {
                c25507b.mo42762bq(16, this.Aoa);
            }
            if (this.Aob != 0) {
                c25507b.mo42762bq(17, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, C45015g.bxA)) {
                c25507b.mo42761b(18, this.Aoc);
            }
            if (this.wbi != -1) {
                c25507b.mo42762bq(19, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                for (int bq2 : this.Aod) {
                    c25507b.mo42763br(20, bq2);
                }
            }
            if (this.Ang != 0) {
                c25507b.mo42763br(21, this.Ang);
            }
            if (this.AnW != 0) {
                c25507b.mo42763br(100, this.AnW);
            }
            if (this.AnX != 0) {
                c25507b.mo42763br(101, this.AnX);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i < this.Ank.length) {
                    C25510e c25510e3 = this.Ank[i];
                    if (c25510e3 != null) {
                        c25507b.mo42760a(102, c25510e3);
                    }
                    i++;
                }
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i;
            int i2 = 0;
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                i = vr;
                for (C25510e c25510e : this.AnR) {
                    if (c25510e != null) {
                        i += C25507b.m40263b(4, c25510e);
                    }
                }
                vr = i;
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                i = vr;
                for (C25510e c25510e2 : this.AnQ) {
                    if (c25510e2 != null) {
                        i += C25507b.m40263b(5, c25510e2);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += C25507b.m40263b(6, this.Ane);
            }
            if (this.AnT != 0) {
                vr += C25507b.m40265bs(7, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                i = 0;
                for (int ft : this.AnU) {
                    i += C25507b.m40270ft(ft);
                }
                vr = (vr + i) + (this.AnU.length * 1);
            }
            if (this.AmJ != 0) {
                vr += C25507b.m40265bs(9, this.AmJ);
            }
            if (this.AnS != null && this.AnS.length > 0) {
                i = vr;
                for (C25510e c25510e22 : this.AnS) {
                    if (c25510e22 != null) {
                        i += C25507b.m40263b(10, c25510e22);
                    }
                }
                vr = i;
            }
            if (this.Amz != null) {
                vr += C25507b.m40263b(11, this.Amz);
            }
            if (this.AmX != 0) {
                vr += C25507b.m40266bt(12, this.AmX);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                i = vr;
                for (C25510e c25510e222 : this.AnV) {
                    if (c25510e222 != null) {
                        i += C25507b.m40263b(13, c25510e222);
                    }
                }
                vr = i;
            }
            if (this.AnY != null && this.AnY.length > 0) {
                i = vr;
                for (C25510e c25510e2222 : this.AnY) {
                    if (c25510e2222 != null) {
                        i += C25507b.m40263b(14, c25510e2222);
                    }
                }
                vr = i;
            }
            if (this.AnZ != 0) {
                vr += C25507b.m40265bs(15, this.AnZ);
            }
            if (this.Aoa != 0) {
                vr += C25507b.m40265bs(16, this.Aoa);
            }
            if (this.Aob != 0) {
                vr += C25507b.m40265bs(17, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, C45015g.bxA)) {
                vr += C25507b.m40268c(18, this.Aoc);
            }
            if (this.wbi != -1) {
                vr += C25507b.m40265bs(19, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                i = 0;
                for (int ft2 : this.Aod) {
                    i += C25507b.m40274fx(ft2);
                }
                vr = (vr + i) + (this.Aod.length * 2);
            }
            if (this.Ang != 0) {
                vr += C25507b.m40266bt(21, this.Ang);
            }
            if (this.AnW != 0) {
                vr += C25507b.m40266bt(100, this.AnW);
            }
            if (this.AnX != 0) {
                vr += C25507b.m40266bt(101, this.AnX);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i2 < this.Ank.length) {
                    C25510e c25510e3 = this.Ank[i2];
                    if (c25510e3 != null) {
                        vr += C25507b.m40263b(102, c25510e3);
                    }
                    i2++;
                }
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ai */
    public static final class C24220ai extends C25510e {
        public int ret;

        public C24220ai() {
            this.ret = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.ret != 0) {
                c25507b.mo42762bq(1, this.ret);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.ret != 0) {
                return vr + C25507b.m40265bs(1, this.ret);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ak */
    public static final class C24221ak extends C25510e {
        public String groupId;
        public int sQS;
        public long sQT;

        public C24221ak() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                return vr + C25507b.m40276o(3, this.sQT);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$j */
    public static final class C24222j extends C25510e {
        public C24205ba AmB;
        public int AmD;
        public byte[] AmN;
        public String groupId;
        public int sQS;
        public long sQT;

        public C24222j() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AmB = null;
            this.AmD = 0;
            this.AmN = C45015g.bxA;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.AmB != null) {
                c25507b.mo42760a(4, this.AmB);
            }
            if (this.AmD != 0) {
                c25507b.mo42763br(5, this.AmD);
            }
            if (!Arrays.equals(this.AmN, C45015g.bxA)) {
                c25507b.mo42761b(200, this.AmN);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.AmB != null) {
                vr += C25507b.m40263b(4, this.AmB);
            }
            if (this.AmD != 0) {
                vr += C25507b.m40266bt(5, this.AmD);
            }
            if (Arrays.equals(this.AmN, C45015g.bxA)) {
                return vr;
            }
            return vr + C25507b.m40268c(200, this.AmN);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$m */
    public static final class C24223m extends C25510e {
        private static volatile C24223m[] AmU;
        public String AmV;
        public String nickname;
        public int vzt;

        public static C24223m[] dPz() {
            if (AmU == null) {
                synchronized (C25508c.bxs) {
                    if (AmU == null) {
                        AmU = new C24223m[0];
                    }
                }
            }
            return AmU;
        }

        public C24223m() {
            this.vzt = 0;
            this.nickname = "";
            this.AmV = "";
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.vzt != 0) {
                c25507b.mo42763br(1, this.vzt);
            }
            if (!this.nickname.equals("")) {
                c25507b.mo42764e(2, this.nickname);
            }
            if (!this.AmV.equals("")) {
                c25507b.mo42764e(3, this.AmV);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.vzt != 0) {
                vr += C25507b.m40266bt(1, this.vzt);
            }
            if (!this.nickname.equals("")) {
                vr += C25507b.m40269f(2, this.nickname);
            }
            if (this.AmV.equals("")) {
                return vr;
            }
            return vr + C25507b.m40269f(3, this.AmV);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ap */
    public static final class C24224ap extends C25510e {
        public int Aou;
        public int Aov;

        public C24224ap() {
            this.Aou = 0;
            this.Aov = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.Aou != 0) {
                c25507b.mo42762bq(1, this.Aou);
            }
            if (this.Aov != 0) {
                c25507b.mo42762bq(2, this.Aov);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.Aou != 0) {
                vr += C25507b.m40265bs(1, this.Aou);
            }
            if (this.Aov != 0) {
                return vr + C25507b.m40265bs(2, this.Aov);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$aq */
    public static final class C24225aq extends C25510e {
        public int sceneType;

        public C24225aq() {
            this.sceneType = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.sceneType != 0) {
                c25507b.mo42762bq(1, this.sceneType);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.sceneType != 0) {
                return vr + C25507b.m40265bs(1, this.sceneType);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ar */
    public static final class C24226ar extends C25510e {
        private static volatile C24226ar[] Aow;
        public int Aox;
        public int Aoy;
        public byte[] Aoz;

        public static C24226ar[] dPF() {
            if (Aow == null) {
                synchronized (C25508c.bxs) {
                    if (Aow == null) {
                        Aow = new C24226ar[0];
                    }
                }
            }
            return Aow;
        }

        public C24226ar() {
            this.Aox = 0;
            this.Aoy = 0;
            this.Aoz = C45015g.bxA;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.Aox != 0) {
                c25507b.mo42762bq(1, this.Aox);
            }
            if (this.Aoy != 0) {
                c25507b.mo42762bq(2, this.Aoy);
            }
            if (!Arrays.equals(this.Aoz, C45015g.bxA)) {
                c25507b.mo42761b(3, this.Aoz);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.Aox != 0) {
                vr += C25507b.m40265bs(1, this.Aox);
            }
            if (this.Aoy != 0) {
                vr += C25507b.m40265bs(2, this.Aoy);
            }
            if (Arrays.equals(this.Aoz, C45015g.bxA)) {
                return vr;
            }
            return vr + C25507b.m40268c(3, this.Aoz);
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$as */
    public static final class C24227as extends C25510e {
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

        public C24227as() {
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

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.AoA != 0) {
                c25507b.mo42762bq(1, this.AoA);
            }
            if (this.fAa != 0) {
                c25507b.mo42762bq(2, this.fAa);
            }
            if (this.fAb != 0) {
                c25507b.mo42762bq(3, this.fAb);
            }
            if (this.AoB != 0) {
                c25507b.mo42762bq(4, this.AoB);
            }
            if (this.AoC != 0) {
                c25507b.mo42762bq(5, this.AoC);
            }
            if (this.AoD != 0) {
                c25507b.mo42762bq(6, this.AoD);
            }
            if (this.AoE != 0) {
                c25507b.mo42762bq(7, this.AoE);
            }
            if (this.AoF != 0) {
                c25507b.mo42762bq(8, this.AoF);
            }
            if (this.AoG != 0) {
                c25507b.mo42762bq(9, this.AoG);
            }
            if (this.AoH != 0) {
                c25507b.mo42762bq(10, this.AoH);
            }
            if (this.AoI != 0) {
                c25507b.mo42762bq(11, this.AoI);
            }
            if (this.AoJ != 0) {
                c25507b.mo42762bq(12, this.AoJ);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.AoA != 0) {
                vr += C25507b.m40265bs(1, this.AoA);
            }
            if (this.fAa != 0) {
                vr += C25507b.m40265bs(2, this.fAa);
            }
            if (this.fAb != 0) {
                vr += C25507b.m40265bs(3, this.fAb);
            }
            if (this.AoB != 0) {
                vr += C25507b.m40265bs(4, this.AoB);
            }
            if (this.AoC != 0) {
                vr += C25507b.m40265bs(5, this.AoC);
            }
            if (this.AoD != 0) {
                vr += C25507b.m40265bs(6, this.AoD);
            }
            if (this.AoE != 0) {
                vr += C25507b.m40265bs(7, this.AoE);
            }
            if (this.AoF != 0) {
                vr += C25507b.m40265bs(8, this.AoF);
            }
            if (this.AoG != 0) {
                vr += C25507b.m40265bs(9, this.AoG);
            }
            if (this.AoH != 0) {
                vr += C25507b.m40265bs(10, this.AoH);
            }
            if (this.AoI != 0) {
                vr += C25507b.m40265bs(11, this.AoI);
            }
            if (this.AoJ != 0) {
                return vr + C25507b.m40265bs(12, this.AoJ);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ay */
    public static final class C24228ay extends C25510e {
        public int ApH;
        public int sQS;
        public long sQT;

        public C24228ay() {
            this.sQS = 0;
            this.sQT = 0;
            this.ApH = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.sQS != 0) {
                c25507b.mo42762bq(1, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(2, this.sQT);
            }
            if (this.ApH != 0) {
                c25507b.mo42763br(3, this.ApH);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(1, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(2, this.sQT);
            }
            if (this.ApH != 0) {
                return vr + C25507b.m40266bt(3, this.ApH);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$az */
    public static final class C24229az extends C25510e {
        private static volatile C24229az[] ApI;
        public int ApJ;
        public int ApK;
        public int ApL;
        public int ApM;
        public int timestamp;

        public static C24229az[] dPJ() {
            if (ApI == null) {
                synchronized (C25508c.bxs) {
                    if (ApI == null) {
                        ApI = new C24229az[0];
                    }
                }
            }
            return ApI;
        }

        public C24229az() {
            this.timestamp = 0;
            this.ApJ = 0;
            this.ApK = 0;
            this.ApL = 0;
            this.ApM = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.timestamp != 0) {
                c25507b.mo42762bq(1, this.timestamp);
            }
            if (this.ApJ != 0) {
                c25507b.mo42762bq(2, this.ApJ);
            }
            if (this.ApK != 0) {
                c25507b.mo42762bq(3, this.ApK);
            }
            if (this.ApL != 0) {
                c25507b.mo42762bq(4, this.ApL);
            }
            if (this.ApM != 0) {
                c25507b.mo42762bq(5, this.ApM);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.timestamp != 0) {
                vr += C25507b.m40265bs(1, this.timestamp);
            }
            if (this.ApJ != 0) {
                vr += C25507b.m40265bs(2, this.ApJ);
            }
            if (this.ApK != 0) {
                vr += C25507b.m40265bs(3, this.ApK);
            }
            if (this.ApL != 0) {
                vr += C25507b.m40265bs(4, this.ApL);
            }
            if (this.ApM != 0) {
                return vr + C25507b.m40265bs(5, this.ApM);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$i */
    public static final class C24230i extends C25510e {
        public int action;
        public String groupId;
        public int nwu;
        public long nwv;
        public long timestamp;

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            c25507b.mo42763br(1, this.action);
            c25507b.mo42762bq(2, this.nwu);
            c25507b.mo42766m(3, this.nwv);
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(4, this.groupId);
            }
            if (this.timestamp != 0) {
                c25507b.mo42765l(5, this.timestamp);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = ((super.mo11879vr() + C25507b.m40266bt(1, this.action)) + C25507b.m40265bs(2, this.nwu)) + C25507b.m40276o(3, this.nwv);
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(4, this.groupId);
            }
            return this.timestamp != 0 ? vr + C25507b.m40275n(5, this.timestamp) : vr;
        }

        public C24230i() {
            this.action = 0;
            this.nwu = 0;
            this.nwv = 0;
            this.groupId = "";
            this.timestamp = 0;
            this.bxt = -1;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$k */
    public static final class C24231k extends C25510e {
        public int AmD;
        public String groupId;
        public int kyZ;
        public int netType;
        public int sQS;
        public long sQT;

        public C24231k() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.kyZ = -1;
            this.AmD = 0;
            this.netType = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.kyZ != -1) {
                c25507b.mo42762bq(4, this.kyZ);
            }
            if (this.AmD != 0) {
                c25507b.mo42763br(5, this.AmD);
            }
            if (this.netType != 0) {
                c25507b.mo42763br(6, this.netType);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.kyZ != -1) {
                vr += C25507b.m40265bs(4, this.kyZ);
            }
            if (this.AmD != 0) {
                vr += C25507b.m40266bt(5, this.AmD);
            }
            if (this.netType != 0) {
                return vr + C25507b.m40266bt(6, this.netType);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$r */
    public static final class C24232r extends C25510e {
        public C24190am[] Anm;

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.Anm != null && this.Anm.length > 0) {
                for (C25510e c25510e : this.Anm) {
                    if (c25510e != null) {
                        c25507b.mo42760a(1, c25510e);
                    }
                }
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.Anm != null && this.Anm.length > 0) {
                for (C25510e c25510e : this.Anm) {
                    if (c25510e != null) {
                        vr += C25507b.m40263b(1, c25510e);
                    }
                }
            }
            return vr;
        }

        public C24232r() {
            this.Anm = C24190am.dPD();
            this.bxt = -1;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$s */
    public static final class C24233s extends C25510e {
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

        public C24233s() {
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

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.vNx != 0) {
                c25507b.mo42765l(1, this.vNx);
            }
            if (!this.Ann.equals("")) {
                c25507b.mo42764e(2, this.Ann);
            }
            if (!this.Ano.equals("")) {
                c25507b.mo42764e(3, this.Ano);
            }
            if (this.Anp != 1) {
                c25507b.mo42762bq(4, this.Anp);
            }
            if (!this.username.equals("")) {
                c25507b.mo42764e(5, this.username);
            }
            if (!this.ffQ.equals("")) {
                c25507b.mo42764e(6, this.ffQ);
            }
            if (!this.AmV.equals("")) {
                c25507b.mo42764e(7, this.AmV);
            }
            if (this.Anq != 0) {
                c25507b.mo42765l(8, this.Anq);
            }
            if (this.Anr != 0) {
                c25507b.mo42763br(9, this.Anr);
            }
            if (!this.xAF.equals("")) {
                c25507b.mo42764e(10, this.xAF);
            }
            if (this.Ans != 0) {
                c25507b.mo42765l(11, this.Ans);
            }
            if (this.Ant != 0) {
                c25507b.mo42763br(12, this.Ant);
            }
            if (this.vNy != 0) {
                c25507b.mo42765l(13, this.vNy);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.vNx != 0) {
                vr += C25507b.m40275n(1, this.vNx);
            }
            if (!this.Ann.equals("")) {
                vr += C25507b.m40269f(2, this.Ann);
            }
            if (!this.Ano.equals("")) {
                vr += C25507b.m40269f(3, this.Ano);
            }
            if (this.Anp != 1) {
                vr += C25507b.m40265bs(4, this.Anp);
            }
            if (!this.username.equals("")) {
                vr += C25507b.m40269f(5, this.username);
            }
            if (!this.ffQ.equals("")) {
                vr += C25507b.m40269f(6, this.ffQ);
            }
            if (!this.AmV.equals("")) {
                vr += C25507b.m40269f(7, this.AmV);
            }
            if (this.Anq != 0) {
                vr += C25507b.m40275n(8, this.Anq);
            }
            if (this.Anr != 0) {
                vr += C25507b.m40266bt(9, this.Anr);
            }
            if (!this.xAF.equals("")) {
                vr += C25507b.m40269f(10, this.xAF);
            }
            if (this.Ans != 0) {
                vr += C25507b.m40275n(11, this.Ans);
            }
            if (this.Ant != 0) {
                vr += C25507b.m40266bt(12, this.Ant);
            }
            if (this.vNy != 0) {
                return vr + C25507b.m40275n(13, this.vNy);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$t */
    public static final class C24234t extends C25510e {
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

        public C24234t() {
            this.Anu = 0;
            this.Anv = C45015g.bxA;
            this.iconUrl = "";
            this.Anw = C45015g.bxA;
            this.Anx = C45015g.bxA;
            this.Any = 0;
            this.data = C45015g.bxA;
            this.Anz = 0;
            this.AnA = C45015g.bxA;
            this.lvz = "";
            this.AnB = C45015g.bxA;
            this.AnC = C45015g.bxA;
            this.AnD = C45015g.bxA;
            this.AnE = C45015g.bxA;
            this.AnF = C45015g.bxA;
            this.AnG = C45015g.bxA;
            this.AnH = C45015g.bxA;
            this.AnI = C45015g.bxA;
            this.AnJ = C45015g.bxA;
            this.status = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (this.Anu != 0) {
                c25507b.mo42763br(1, this.Anu);
            }
            if (!Arrays.equals(this.Anv, C45015g.bxA)) {
                c25507b.mo42761b(2, this.Anv);
            }
            if (!this.iconUrl.equals("")) {
                c25507b.mo42764e(3, this.iconUrl);
            }
            if (!Arrays.equals(this.Anw, C45015g.bxA)) {
                c25507b.mo42761b(4, this.Anw);
            }
            if (!Arrays.equals(this.Anx, C45015g.bxA)) {
                c25507b.mo42761b(5, this.Anx);
            }
            if (this.Any != 0) {
                c25507b.mo42763br(6, this.Any);
            }
            if (!Arrays.equals(this.data, C45015g.bxA)) {
                c25507b.mo42761b(7, this.data);
            }
            if (this.Anz != 0) {
                c25507b.mo42763br(8, this.Anz);
            }
            if (!Arrays.equals(this.AnA, C45015g.bxA)) {
                c25507b.mo42761b(9, this.AnA);
            }
            if (!this.lvz.equals("")) {
                c25507b.mo42764e(10, this.lvz);
            }
            if (!Arrays.equals(this.AnB, C45015g.bxA)) {
                c25507b.mo42761b(11, this.AnB);
            }
            if (!Arrays.equals(this.AnC, C45015g.bxA)) {
                c25507b.mo42761b(12, this.AnC);
            }
            if (!Arrays.equals(this.AnD, C45015g.bxA)) {
                c25507b.mo42761b(13, this.AnD);
            }
            if (!Arrays.equals(this.AnE, C45015g.bxA)) {
                c25507b.mo42761b(14, this.AnE);
            }
            if (!Arrays.equals(this.AnF, C45015g.bxA)) {
                c25507b.mo42761b(15, this.AnF);
            }
            if (!Arrays.equals(this.AnG, C45015g.bxA)) {
                c25507b.mo42761b(16, this.AnG);
            }
            if (!Arrays.equals(this.AnH, C45015g.bxA)) {
                c25507b.mo42761b(17, this.AnH);
            }
            if (!Arrays.equals(this.AnI, C45015g.bxA)) {
                c25507b.mo42761b(18, this.AnI);
            }
            if (!Arrays.equals(this.AnJ, C45015g.bxA)) {
                c25507b.mo42761b(19, this.AnJ);
            }
            if (this.status != 0) {
                c25507b.mo42763br(20, this.status);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (this.Anu != 0) {
                vr += C25507b.m40266bt(1, this.Anu);
            }
            if (!Arrays.equals(this.Anv, C45015g.bxA)) {
                vr += C25507b.m40268c(2, this.Anv);
            }
            if (!this.iconUrl.equals("")) {
                vr += C25507b.m40269f(3, this.iconUrl);
            }
            if (!Arrays.equals(this.Anw, C45015g.bxA)) {
                vr += C25507b.m40268c(4, this.Anw);
            }
            if (!Arrays.equals(this.Anx, C45015g.bxA)) {
                vr += C25507b.m40268c(5, this.Anx);
            }
            if (this.Any != 0) {
                vr += C25507b.m40266bt(6, this.Any);
            }
            if (!Arrays.equals(this.data, C45015g.bxA)) {
                vr += C25507b.m40268c(7, this.data);
            }
            if (this.Anz != 0) {
                vr += C25507b.m40266bt(8, this.Anz);
            }
            if (!Arrays.equals(this.AnA, C45015g.bxA)) {
                vr += C25507b.m40268c(9, this.AnA);
            }
            if (!this.lvz.equals("")) {
                vr += C25507b.m40269f(10, this.lvz);
            }
            if (!Arrays.equals(this.AnB, C45015g.bxA)) {
                vr += C25507b.m40268c(11, this.AnB);
            }
            if (!Arrays.equals(this.AnC, C45015g.bxA)) {
                vr += C25507b.m40268c(12, this.AnC);
            }
            if (!Arrays.equals(this.AnD, C45015g.bxA)) {
                vr += C25507b.m40268c(13, this.AnD);
            }
            if (!Arrays.equals(this.AnE, C45015g.bxA)) {
                vr += C25507b.m40268c(14, this.AnE);
            }
            if (!Arrays.equals(this.AnF, C45015g.bxA)) {
                vr += C25507b.m40268c(15, this.AnF);
            }
            if (!Arrays.equals(this.AnG, C45015g.bxA)) {
                vr += C25507b.m40268c(16, this.AnG);
            }
            if (!Arrays.equals(this.AnH, C45015g.bxA)) {
                vr += C25507b.m40268c(17, this.AnH);
            }
            if (!Arrays.equals(this.AnI, C45015g.bxA)) {
                vr += C25507b.m40268c(18, this.AnI);
            }
            if (!Arrays.equals(this.AnJ, C45015g.bxA)) {
                vr += C25507b.m40268c(19, this.AnJ);
            }
            if (this.status != 0) {
                return vr + C25507b.m40266bt(20, this.status);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$u */
    public static final class C24235u extends C25510e {
        public int AmC;
        public int AnK;
        public int AnL;
        /* renamed from: Cn */
        public int f4452Cn;
        public int ret;
        public String userName;
        public int vzt;

        public C24235u() {
            this.userName = "";
            this.f4452Cn = 0;
            this.AnK = 0;
            this.ret = 0;
            this.AnL = 0;
            this.AmC = 0;
            this.vzt = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            if (!this.userName.equals("")) {
                c25507b.mo42764e(2, this.userName);
            }
            if (this.f4452Cn != 0) {
                c25507b.mo42762bq(3, this.f4452Cn);
            }
            if (this.AnK != 0) {
                c25507b.mo42763br(4, this.AnK);
            }
            if (this.ret != 0) {
                c25507b.mo42762bq(5, this.ret);
            }
            if (this.AnL != 0) {
                c25507b.mo42762bq(6, this.AnL);
            }
            if (this.AmC != 0) {
                c25507b.mo42763br(7, this.AmC);
            }
            if (this.vzt != 0) {
                c25507b.mo42763br(8, this.vzt);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int vr = super.mo11879vr();
            if (!this.userName.equals("")) {
                vr += C25507b.m40269f(2, this.userName);
            }
            if (this.f4452Cn != 0) {
                vr += C25507b.m40265bs(3, this.f4452Cn);
            }
            if (this.AnK != 0) {
                vr += C25507b.m40266bt(4, this.AnK);
            }
            if (this.ret != 0) {
                vr += C25507b.m40265bs(5, this.ret);
            }
            if (this.AnL != 0) {
                vr += C25507b.m40265bs(6, this.AnL);
            }
            if (this.AmC != 0) {
                vr += C25507b.m40266bt(7, this.AmC);
            }
            if (this.vzt != 0) {
                return vr + C25507b.m40266bt(8, this.vzt);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$ag */
    public static final class C24236ag extends C25510e {
        public C24191at Amz;
        public C24193av[] AnQ;
        public C16120o[] AnR;
        public C24194aw[] AnS;
        public int AnT;
        public int[] AnU;
        public C24227as Ane;
        public C24193av[] Ank;
        public String groupId;
        public int sQS;
        public long sQT;

        public C24236ag() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnR = C16120o.dPB();
            this.Ane = null;
            this.AnT = 0;
            this.AnU = C45015g.bxu;
            this.AnQ = C24193av.dPH();
            this.AnS = C24194aw.dPI();
            this.Amz = null;
            this.Ank = C24193av.dPH();
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                for (C25510e c25510e : this.AnR) {
                    if (c25510e != null) {
                        c25507b.mo42760a(4, c25510e);
                    }
                }
            }
            if (this.Ane != null) {
                c25507b.mo42760a(5, this.Ane);
            }
            if (this.AnT != 0) {
                c25507b.mo42762bq(6, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                for (int bq : this.AnU) {
                    c25507b.mo42762bq(7, bq);
                }
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (C25510e c25510e2 : this.AnQ) {
                    if (c25510e2 != null) {
                        c25507b.mo42760a(200, c25510e2);
                    }
                }
            }
            if (this.AnS != null && this.AnS.length > 0) {
                for (C25510e c25510e22 : this.AnS) {
                    if (c25510e22 != null) {
                        c25507b.mo42760a(201, c25510e22);
                    }
                }
            }
            if (this.Amz != null) {
                c25507b.mo42760a(202, this.Amz);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i < this.Ank.length) {
                    C25510e c25510e3 = this.Ank[i];
                    if (c25510e3 != null) {
                        c25507b.mo42760a(203, c25510e3);
                    }
                    i++;
                }
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i;
            int i2 = 0;
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                i = vr;
                for (C25510e c25510e : this.AnR) {
                    if (c25510e != null) {
                        i += C25507b.m40263b(4, c25510e);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += C25507b.m40263b(5, this.Ane);
            }
            if (this.AnT != 0) {
                vr += C25507b.m40265bs(6, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                i = 0;
                for (int ft : this.AnU) {
                    i += C25507b.m40270ft(ft);
                }
                vr = (vr + i) + (this.AnU.length * 1);
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                i = vr;
                for (C25510e c25510e2 : this.AnQ) {
                    if (c25510e2 != null) {
                        i += C25507b.m40263b(200, c25510e2);
                    }
                }
                vr = i;
            }
            if (this.AnS != null && this.AnS.length > 0) {
                i = vr;
                for (C25510e c25510e22 : this.AnS) {
                    if (c25510e22 != null) {
                        i += C25507b.m40263b(201, c25510e22);
                    }
                }
                vr = i;
            }
            if (this.Amz != null) {
                vr += C25507b.m40263b(202, this.Amz);
            }
            if (this.Ank != null && this.Ank.length > 0) {
                while (i2 < this.Ank.length) {
                    C25510e c25510e3 = this.Ank[i2];
                    if (c25510e3 != null) {
                        vr += C25507b.m40263b(203, c25510e3);
                    }
                    i2++;
                }
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$aj */
    public static final class C24237aj extends C25510e {
        public C24191at Amz;
        public C24193av[] AnQ;
        public C16120o[] AnR;
        public C24194aw[] AnS;
        public int AnT;
        public int[] AnU;
        public C16120o[] AnV;
        public C16120o[] AnY;
        public int AnZ;
        public C24227as Ane;
        public int Ang;
        public C24193av[] Ank;
        public int Aoa;
        public int Aob;
        public byte[] Aoc;
        public int[] Aod;
        public String groupId;
        public int sQS;
        public long sQT;
        public int wbi;

        public C24237aj() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.AnR = C16120o.dPB();
            this.AnQ = C24193av.dPH();
            this.Ane = null;
            this.AnT = 0;
            this.AnU = C45015g.bxu;
            this.AnS = C24194aw.dPI();
            this.Amz = null;
            this.AnV = C16120o.dPB();
            this.Ank = C24193av.dPH();
            this.AnY = C16120o.dPB();
            this.AnZ = 0;
            this.Aoa = 0;
            this.Aob = 0;
            this.Aoc = C45015g.bxA;
            this.wbi = -1;
            this.Aod = C45015g.bxu;
            this.Ang = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                for (C25510e c25510e : this.AnR) {
                    if (c25510e != null) {
                        c25507b.mo42760a(4, c25510e);
                    }
                }
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                for (C25510e c25510e2 : this.AnQ) {
                    if (c25510e2 != null) {
                        c25507b.mo42760a(5, c25510e2);
                    }
                }
            }
            if (this.Ane != null) {
                c25507b.mo42760a(6, this.Ane);
            }
            if (this.AnT != 0) {
                c25507b.mo42762bq(7, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                for (int bq : this.AnU) {
                    c25507b.mo42762bq(8, bq);
                }
            }
            if (this.AnS != null && this.AnS.length > 0) {
                for (C25510e c25510e22 : this.AnS) {
                    if (c25510e22 != null) {
                        c25507b.mo42760a(9, c25510e22);
                    }
                }
            }
            if (this.Amz != null) {
                c25507b.mo42760a(10, this.Amz);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                for (C25510e c25510e222 : this.AnV) {
                    if (c25510e222 != null) {
                        c25507b.mo42760a(11, c25510e222);
                    }
                }
            }
            if (this.Ank != null && this.Ank.length > 0) {
                for (C25510e c25510e2222 : this.Ank) {
                    if (c25510e2222 != null) {
                        c25507b.mo42760a(12, c25510e2222);
                    }
                }
            }
            if (this.AnY != null && this.AnY.length > 0) {
                for (C25510e c25510e22222 : this.AnY) {
                    if (c25510e22222 != null) {
                        c25507b.mo42760a(13, c25510e22222);
                    }
                }
            }
            if (this.AnZ != 0) {
                c25507b.mo42762bq(14, this.AnZ);
            }
            if (this.Aoa != 0) {
                c25507b.mo42762bq(15, this.Aoa);
            }
            if (this.Aob != 0) {
                c25507b.mo42762bq(16, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, C45015g.bxA)) {
                c25507b.mo42761b(17, this.Aoc);
            }
            if (this.wbi != -1) {
                c25507b.mo42762bq(18, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                while (i < this.Aod.length) {
                    c25507b.mo42763br(19, this.Aod[i]);
                    i++;
                }
            }
            if (this.Ang != 0) {
                c25507b.mo42763br(20, this.Ang);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i;
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.AnR != null && this.AnR.length > 0) {
                i = vr;
                for (C25510e c25510e : this.AnR) {
                    if (c25510e != null) {
                        i += C25507b.m40263b(4, c25510e);
                    }
                }
                vr = i;
            }
            if (this.AnQ != null && this.AnQ.length > 0) {
                i = vr;
                for (C25510e c25510e2 : this.AnQ) {
                    if (c25510e2 != null) {
                        i += C25507b.m40263b(5, c25510e2);
                    }
                }
                vr = i;
            }
            if (this.Ane != null) {
                vr += C25507b.m40263b(6, this.Ane);
            }
            if (this.AnT != 0) {
                vr += C25507b.m40265bs(7, this.AnT);
            }
            if (this.AnU != null && this.AnU.length > 0) {
                i = 0;
                for (int ft : this.AnU) {
                    i += C25507b.m40270ft(ft);
                }
                vr = (vr + i) + (this.AnU.length * 1);
            }
            if (this.AnS != null && this.AnS.length > 0) {
                i = vr;
                for (C25510e c25510e22 : this.AnS) {
                    if (c25510e22 != null) {
                        i += C25507b.m40263b(9, c25510e22);
                    }
                }
                vr = i;
            }
            if (this.Amz != null) {
                vr += C25507b.m40263b(10, this.Amz);
            }
            if (this.AnV != null && this.AnV.length > 0) {
                i = vr;
                for (C25510e c25510e222 : this.AnV) {
                    if (c25510e222 != null) {
                        i += C25507b.m40263b(11, c25510e222);
                    }
                }
                vr = i;
            }
            if (this.Ank != null && this.Ank.length > 0) {
                i = vr;
                for (C25510e c25510e2222 : this.Ank) {
                    if (c25510e2222 != null) {
                        i += C25507b.m40263b(12, c25510e2222);
                    }
                }
                vr = i;
            }
            if (this.AnY != null && this.AnY.length > 0) {
                i = vr;
                for (C25510e c25510e22222 : this.AnY) {
                    if (c25510e22222 != null) {
                        i += C25507b.m40263b(13, c25510e22222);
                    }
                }
                vr = i;
            }
            if (this.AnZ != 0) {
                vr += C25507b.m40265bs(14, this.AnZ);
            }
            if (this.Aoa != 0) {
                vr += C25507b.m40265bs(15, this.Aoa);
            }
            if (this.Aob != 0) {
                vr += C25507b.m40265bs(16, this.Aob);
            }
            if (!Arrays.equals(this.Aoc, C45015g.bxA)) {
                vr += C25507b.m40268c(17, this.Aoc);
            }
            if (this.wbi != -1) {
                vr += C25507b.m40265bs(18, this.wbi);
            }
            if (this.Aod != null && this.Aod.length > 0) {
                i = 0;
                for (int fx : this.Aod) {
                    i += C25507b.m40274fx(fx);
                }
                vr = (vr + i) + (this.Aod.length * 2);
            }
            if (this.Ang != 0) {
                return vr + C25507b.m40266bt(20, this.Ang);
            }
            return vr;
        }
    }

    /* renamed from: com.tencent.pb.common.b.a.a$l */
    public static final class C24238l extends C25510e {
        public int AmO;
        public byte[] AmP;
        public C24229az[] AmQ;
        public C16118ao[] AmR;
        public int AmS;
        public int AmT;
        public int fVl;
        public String groupId;
        public int kyZ;
        public int sQS;
        public long sQT;

        public C24238l() {
            this.groupId = "";
            this.sQS = 0;
            this.sQT = 0;
            this.kyZ = -1;
            this.AmO = 0;
            this.AmP = C45015g.bxA;
            this.AmQ = C24229az.dPJ();
            this.AmR = C16118ao.dPE();
            this.AmS = 0;
            this.AmT = 0;
            this.fVl = 0;
            this.bxt = -1;
        }

        /* renamed from: a */
        public final void mo11878a(C25507b c25507b) {
            int i = 0;
            if (!this.groupId.equals("")) {
                c25507b.mo42764e(1, this.groupId);
            }
            if (this.sQS != 0) {
                c25507b.mo42762bq(2, this.sQS);
            }
            if (this.sQT != 0) {
                c25507b.mo42766m(3, this.sQT);
            }
            if (this.kyZ != -1) {
                c25507b.mo42762bq(4, this.kyZ);
            }
            if (this.AmO != 0) {
                c25507b.mo42762bq(5, this.AmO);
            }
            if (!Arrays.equals(this.AmP, C45015g.bxA)) {
                c25507b.mo42761b(6, this.AmP);
            }
            if (this.AmQ != null && this.AmQ.length > 0) {
                for (C25510e c25510e : this.AmQ) {
                    if (c25510e != null) {
                        c25507b.mo42760a(7, c25510e);
                    }
                }
            }
            if (this.AmR != null && this.AmR.length > 0) {
                while (i < this.AmR.length) {
                    C25510e c25510e2 = this.AmR[i];
                    if (c25510e2 != null) {
                        c25507b.mo42760a(8, c25510e2);
                    }
                    i++;
                }
            }
            if (this.AmS != 0) {
                c25507b.mo42762bq(9, this.AmS);
            }
            if (this.AmT != 0) {
                c25507b.mo42762bq(10, this.AmT);
            }
            if (this.fVl != 0) {
                c25507b.mo42762bq(11, this.fVl);
            }
            super.mo11878a(c25507b);
        }

        /* renamed from: vr */
        public final int mo11879vr() {
            int i = 0;
            int vr = super.mo11879vr();
            if (!this.groupId.equals("")) {
                vr += C25507b.m40269f(1, this.groupId);
            }
            if (this.sQS != 0) {
                vr += C25507b.m40265bs(2, this.sQS);
            }
            if (this.sQT != 0) {
                vr += C25507b.m40276o(3, this.sQT);
            }
            if (this.kyZ != -1) {
                vr += C25507b.m40265bs(4, this.kyZ);
            }
            if (this.AmO != 0) {
                vr += C25507b.m40265bs(5, this.AmO);
            }
            if (!Arrays.equals(this.AmP, C45015g.bxA)) {
                vr += C25507b.m40268c(6, this.AmP);
            }
            if (this.AmQ != null && this.AmQ.length > 0) {
                int i2 = vr;
                for (C25510e c25510e : this.AmQ) {
                    if (c25510e != null) {
                        i2 += C25507b.m40263b(7, c25510e);
                    }
                }
                vr = i2;
            }
            if (this.AmR != null && this.AmR.length > 0) {
                while (i < this.AmR.length) {
                    C25510e c25510e2 = this.AmR[i];
                    if (c25510e2 != null) {
                        vr += C25507b.m40263b(8, c25510e2);
                    }
                    i++;
                }
            }
            if (this.AmS != 0) {
                vr += C25507b.m40265bs(9, this.AmS);
            }
            if (this.AmT != 0) {
                vr += C25507b.m40265bs(10, this.AmT);
            }
            if (this.fVl != 0) {
                return vr + C25507b.m40265bs(11, this.fVl);
            }
            return vr;
        }
    }
}
