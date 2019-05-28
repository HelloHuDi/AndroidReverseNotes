package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public interface h extends g {

    public interface a {
        void a(h hVar, c cVar);
    }

    public static class b {
        public long fDH;
        public String name;
        private a[] oqF;
        public int oqG;

        public static class a {
            long oqH;
            long oqI;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public b(int i, String str, a[] aVarArr) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(60017);
            Assert.assertTrue(str.length() > 0);
            this.name = str;
            Assert.assertTrue(aVarArr.length == 2);
            if (aVarArr[0].oqI >= aVarArr[0].oqH) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (aVarArr[1].oqI >= aVarArr[1].oqH) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (aVarArr[1].oqH < aVarArr[0].oqI) {
                z2 = false;
            }
            Assert.assertTrue(z2);
            this.oqF = aVarArr;
            this.oqG = i;
            this.fDH = aVarArr[0].oqH;
            AppMethodBeat.o(60017);
        }

        public final void yx(int i) {
            AppMethodBeat.i(60018);
            ab.i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", Long.valueOf(this.fDH), Integer.valueOf(i), Long.valueOf(this.oqF[0].oqI), Long.valueOf(this.oqF[1].oqH), bo.dpG());
            if (((long) i) <= this.oqF[0].oqI || ((long) i) >= this.oqF[1].oqH) {
                this.fDH = (long) i;
                AppMethodBeat.o(60018);
                return;
            }
            ab.i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", Long.valueOf(this.oqF[1].oqH));
            this.fDH = this.oqF[1].oqH;
            e.pXa.a(111, 169, 1, false);
            AppMethodBeat.o(60018);
        }

        public final synchronized void ac(bi biVar) {
            AppMethodBeat.i(60019);
            if (this.fDH == this.oqF[0].oqI) {
                this.fDH = this.oqF[1].oqH;
                e.pXa.a(111, 251, 1, false);
            } else {
                this.fDH++;
            }
            if (!com.tencent.mm.sdk.a.b.dnQ()) {
                ab.i("MicroMsg.MsgTable", "incMsgLocalId %d  ", Long.valueOf(this.fDH));
            }
            biVar.setMsgId(this.fDH);
            AppMethodBeat.o(60019);
        }

        public final boolean jk(long j) {
            for (a aVar : this.oqF) {
                boolean z;
                if (j < aVar.oqH || j > aVar.oqI) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public static a[] a(long j, long j2, long j3, long j4) {
            AppMethodBeat.i(60020);
            a[] aVarArr = new a[2];
            a aVar = new a();
            aVar.oqH = j;
            aVar.oqI = j2;
            aVarArr[0] = aVar;
            aVar = new a();
            aVar.oqH = j3;
            aVar.oqI = j4;
            aVarArr[1] = aVar;
            AppMethodBeat.o(60020);
            return aVarArr;
        }
    }

    public static class c {
        public long jMj;
        public String oqJ;
        public ArrayList<bi> oqK;
        public int oqL;
        public int oqM;
        public int oqN;
        public long oqO;
        public String talker;

        public c(String str, String str2, bi biVar) {
            this(str, str2, biVar, 0);
        }

        public c(String str, String str2, bi biVar, int i) {
            long j = -1;
            AppMethodBeat.i(60021);
            this.oqK = new ArrayList();
            this.oqM = 0;
            this.oqN = 0;
            this.oqO = 0;
            this.jMj = -1;
            this.talker = str;
            this.oqJ = str2;
            this.oqL = i;
            if (biVar != null) {
                j = biVar.field_bizChatId;
            }
            this.jMj = j;
            if (biVar != null) {
                this.oqK.add(biVar);
            }
            AppMethodBeat.o(60021);
        }

        public c(String str, String str2, bi biVar, int i, byte b) {
            this(str, str2, biVar, 0);
            this.oqN = i;
        }

        public static boolean ad(bi biVar) {
            return biVar != null && biVar.field_isSend == 0 && biVar.field_status == 3;
        }
    }

    Cursor G(String str, String str2, int i);

    void K(ArrayList<Long> arrayList);

    void P(String str, long j);

    bi Q(String str, long j);

    void QW(String str);

    void QX(String str);

    void QY(String str);

    Cursor QZ(String str);

    bi R(String str, long j);

    bi Ra(String str);

    bi Rb(String str);

    bi Rc(String str);

    bi Rd(String str);

    List<bi> Re(String str);

    Cursor Rf(String str);

    void Rg(String str);

    int Rh(String str);

    int Ri(String str);

    Cursor Rj(String str);

    Cursor Rk(String str);

    com.tencent.mm.storage.bi.c Rl(String str);

    d Rm(String str);

    com.tencent.mm.storage.bi.a Rn(String str);

    com.tencent.mm.storage.bi.b Ro(String str);

    int Rp(String str);

    int Rq(String str);

    String Rr(String str);

    long Rs(String str);

    long Rt(String str);

    long Ru(String str);

    bi Rv(String str);

    int Rw(String str);

    List<bi> Rx(String str);

    long Ry(String str);

    Cursor Rz(String str);

    bi S(String str, long j);

    List<bi> T(String str, long j);

    List<bi> U(String str, long j);

    bi V(String str, long j);

    bi W(String str, long j);

    boolean X(String str, long j);

    int Y(bi biVar);

    bi Y(String str, long j);

    long Z(bi biVar);

    long Z(String str, long j);

    Cursor a(String str, long j, long j2, boolean z);

    void a(long j, bi biVar);

    void a(com.tencent.mm.cd.h hVar, String str);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    void a(c cVar);

    void a(com.tencent.mm.storage.e eVar);

    int aa(String str, long j);

    List<bi> aa(String str, int i, int i2);

    void aa(bi biVar);

    int ab(bi biVar);

    int ab(String str, long j);

    Cursor ab(String str, int i, int i2);

    int ac(String str, long j);

    String ad(String str, long j);

    bi ae(String str, long j);

    bi af(String str, long j);

    Cursor b(String str, long j, long j2, int i);

    void b(long j, bi biVar);

    void b(String str, String str2, String[] strArr);

    void bOA();

    void bOB();

    ArrayList<bi> bOC();

    List<bi> bOD();

    Cursor bOE();

    String bOF();

    String bOG();

    List<bi> bOH();

    com.tencent.mm.cd.h bOy();

    void bOz();

    long c(bi biVar, boolean z);

    Cursor c(String str, long j, long j2, int i);

    int cA(String str, int i);

    Cursor cB(String str, int i);

    bi[] cC(String str, int i);

    Cursor cD(String str, int i);

    List<bi> cs(String str, int i);

    List<bi> ct(String str, int i);

    Cursor cu(String str, int i);

    Cursor cv(String str, int i);

    Cursor cw(String str, int i);

    int cx(String str, int i);

    Cursor cy(String str, int i);

    Cursor cz(String str, int i);

    Cursor d(String str, long j, long j2, int i);

    int e(String str, long j, int i);

    long f(String str, long j, int i);

    bi fa(String str, String str2);

    Cursor fb(String str, String str2);

    int fc(String str, String str2);

    LinkedList<bi> fd(String str, String str2);

    long g(String str, long j, int i);

    List<bi> g(String str, long j, boolean z);

    Cursor h(String str, int i, long j);

    Cursor h(String str, long j, int i);

    Cursor i(String str, int i, long j);

    bi jf(long j);

    int jg(long j);

    boolean jh(long j);

    boolean ji(long j);

    void jj(long j);

    int oA(String str);

    boolean oB(String str);

    Cursor p(String str, long j, long j2);

    Cursor q(String str, long j, long j2);

    int r(String str, long j, long j2);

    int s(String str, long j, long j2);

    Cursor t(String str, long j, long j2);

    int u(String str, long j, long j2);

    int v(String str, long j, long j2);

    Cursor w(String str, long j, long j2);

    bi yw(int i);
}
