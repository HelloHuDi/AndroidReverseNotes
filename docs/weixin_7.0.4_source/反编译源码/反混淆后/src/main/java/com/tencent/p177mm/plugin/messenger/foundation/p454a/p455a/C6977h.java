package com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C4928g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5142e;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.C7620bi.C5135a;
import com.tencent.p177mm.storage.C7620bi.C5136b;
import com.tencent.p177mm.storage.C7620bi.C5137c;
import com.tencent.p177mm.storage.C7620bi.C5138d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.messenger.foundation.a.a.h */
public interface C6977h extends C4928g {

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a.a.h$a */
    public interface C3457a {
        /* renamed from: a */
        void mo7913a(C6977h c6977h, C3460c c3460c);
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a.a.h$b */
    public static class C3459b {
        public long fDH;
        public String name;
        private C3458a[] oqF;
        public int oqG;

        /* renamed from: com.tencent.mm.plugin.messenger.foundation.a.a.h$b$a */
        public static class C3458a {
            long oqH;
            long oqI;

            private C3458a() {
            }

            /* synthetic */ C3458a(byte b) {
                this();
            }
        }

        public C3459b(int i, String str, C3458a[] c3458aArr) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(60017);
            Assert.assertTrue(str.length() > 0);
            this.name = str;
            Assert.assertTrue(c3458aArr.length == 2);
            if (c3458aArr[0].oqI >= c3458aArr[0].oqH) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (c3458aArr[1].oqI >= c3458aArr[1].oqH) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (c3458aArr[1].oqH < c3458aArr[0].oqI) {
                z2 = false;
            }
            Assert.assertTrue(z2);
            this.oqF = c3458aArr;
            this.oqG = i;
            this.fDH = c3458aArr[0].oqH;
            AppMethodBeat.m2505o(60017);
        }

        /* renamed from: yx */
        public final void mo7916yx(int i) {
            AppMethodBeat.m2504i(60018);
            C4990ab.m7417i("MicroMsg.MsgTable", "summermsg setMsgLocalId [%d, %d]  regions[%d, %d] stack[%s]", Long.valueOf(this.fDH), Integer.valueOf(i), Long.valueOf(this.oqF[0].oqI), Long.valueOf(this.oqF[1].oqH), C5046bo.dpG());
            if (((long) i) <= this.oqF[0].oqI || ((long) i) >= this.oqF[1].oqH) {
                this.fDH = (long) i;
                AppMethodBeat.m2505o(60018);
                return;
            }
            C4990ab.m7417i("MicroMsg.MsgTable", "summermsg setMsgLocalId revised msgLocalId to %d", Long.valueOf(this.oqF[1].oqH));
            this.fDH = this.oqF[1].oqH;
            C7053e.pXa.mo8378a(111, 169, 1, false);
            AppMethodBeat.m2505o(60018);
        }

        /* renamed from: ac */
        public final synchronized void mo7914ac(C7620bi c7620bi) {
            AppMethodBeat.m2504i(60019);
            if (this.fDH == this.oqF[0].oqI) {
                this.fDH = this.oqF[1].oqH;
                C7053e.pXa.mo8378a(111, 251, 1, false);
            } else {
                this.fDH++;
            }
            if (!C4872b.dnQ()) {
                C4990ab.m7417i("MicroMsg.MsgTable", "incMsgLocalId %d  ", Long.valueOf(this.fDH));
            }
            c7620bi.setMsgId(this.fDH);
            AppMethodBeat.m2505o(60019);
        }

        /* renamed from: jk */
        public final boolean mo7915jk(long j) {
            for (C3458a c3458a : this.oqF) {
                boolean z;
                if (j < c3458a.oqH || j > c3458a.oqI) {
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

        /* renamed from: a */
        public static C3458a[] m5743a(long j, long j2, long j3, long j4) {
            AppMethodBeat.m2504i(60020);
            C3458a[] c3458aArr = new C3458a[2];
            C3458a c3458a = new C3458a();
            c3458a.oqH = j;
            c3458a.oqI = j2;
            c3458aArr[0] = c3458a;
            c3458a = new C3458a();
            c3458a.oqH = j3;
            c3458a.oqI = j4;
            c3458aArr[1] = c3458a;
            AppMethodBeat.m2505o(60020);
            return c3458aArr;
        }
    }

    /* renamed from: com.tencent.mm.plugin.messenger.foundation.a.a.h$c */
    public static class C3460c {
        public long jMj;
        public String oqJ;
        public ArrayList<C7620bi> oqK;
        public int oqL;
        public int oqM;
        public int oqN;
        public long oqO;
        public String talker;

        public C3460c(String str, String str2, C7620bi c7620bi) {
            this(str, str2, c7620bi, 0);
        }

        public C3460c(String str, String str2, C7620bi c7620bi, int i) {
            long j = -1;
            AppMethodBeat.m2504i(60021);
            this.oqK = new ArrayList();
            this.oqM = 0;
            this.oqN = 0;
            this.oqO = 0;
            this.jMj = -1;
            this.talker = str;
            this.oqJ = str2;
            this.oqL = i;
            if (c7620bi != null) {
                j = c7620bi.field_bizChatId;
            }
            this.jMj = j;
            if (c7620bi != null) {
                this.oqK.add(c7620bi);
            }
            AppMethodBeat.m2505o(60021);
        }

        public C3460c(String str, String str2, C7620bi c7620bi, int i, byte b) {
            this(str, str2, c7620bi, 0);
            this.oqN = i;
        }

        /* renamed from: ad */
        public static boolean m5747ad(C7620bi c7620bi) {
            return c7620bi != null && c7620bi.field_isSend == 0 && c7620bi.field_status == 3;
        }
    }

    /* renamed from: G */
    Cursor mo15238G(String str, String str2, int i);

    /* renamed from: K */
    void mo15239K(ArrayList<Long> arrayList);

    /* renamed from: P */
    void mo15240P(String str, long j);

    /* renamed from: Q */
    C7620bi mo15241Q(String str, long j);

    /* renamed from: QW */
    void mo15242QW(String str);

    /* renamed from: QX */
    void mo15243QX(String str);

    /* renamed from: QY */
    void mo15244QY(String str);

    /* renamed from: QZ */
    Cursor mo15245QZ(String str);

    /* renamed from: R */
    C7620bi mo15246R(String str, long j);

    /* renamed from: Ra */
    C7620bi mo15247Ra(String str);

    /* renamed from: Rb */
    C7620bi mo15248Rb(String str);

    /* renamed from: Rc */
    C7620bi mo15249Rc(String str);

    /* renamed from: Rd */
    C7620bi mo15250Rd(String str);

    /* renamed from: Re */
    List<C7620bi> mo15251Re(String str);

    /* renamed from: Rf */
    Cursor mo15252Rf(String str);

    /* renamed from: Rg */
    void mo15253Rg(String str);

    /* renamed from: Rh */
    int mo15254Rh(String str);

    /* renamed from: Ri */
    int mo15255Ri(String str);

    /* renamed from: Rj */
    Cursor mo15256Rj(String str);

    /* renamed from: Rk */
    Cursor mo15257Rk(String str);

    /* renamed from: Rl */
    C5137c mo15258Rl(String str);

    /* renamed from: Rm */
    C5138d mo15259Rm(String str);

    /* renamed from: Rn */
    C5135a mo15260Rn(String str);

    /* renamed from: Ro */
    C5136b mo15261Ro(String str);

    /* renamed from: Rp */
    int mo15262Rp(String str);

    /* renamed from: Rq */
    int mo15263Rq(String str);

    /* renamed from: Rr */
    String mo15264Rr(String str);

    /* renamed from: Rs */
    long mo15265Rs(String str);

    /* renamed from: Rt */
    long mo15266Rt(String str);

    /* renamed from: Ru */
    long mo15267Ru(String str);

    /* renamed from: Rv */
    C7620bi mo15268Rv(String str);

    /* renamed from: Rw */
    int mo15269Rw(String str);

    /* renamed from: Rx */
    List<C7620bi> mo15270Rx(String str);

    /* renamed from: Ry */
    long mo15271Ry(String str);

    /* renamed from: Rz */
    Cursor mo15272Rz(String str);

    /* renamed from: S */
    C7620bi mo15273S(String str, long j);

    /* renamed from: T */
    List<C7620bi> mo15274T(String str, long j);

    /* renamed from: U */
    List<C7620bi> mo15275U(String str, long j);

    /* renamed from: V */
    C7620bi mo15276V(String str, long j);

    /* renamed from: W */
    C7620bi mo15277W(String str, long j);

    /* renamed from: X */
    boolean mo15278X(String str, long j);

    /* renamed from: Y */
    int mo15279Y(C7620bi c7620bi);

    /* renamed from: Y */
    C7620bi mo15280Y(String str, long j);

    /* renamed from: Z */
    long mo15281Z(C7620bi c7620bi);

    /* renamed from: Z */
    long mo15282Z(String str, long j);

    /* renamed from: a */
    Cursor mo15283a(String str, long j, long j2, boolean z);

    /* renamed from: a */
    void mo15284a(long j, C7620bi c7620bi);

    /* renamed from: a */
    void mo15285a(C7480h c7480h, String str);

    /* renamed from: a */
    void mo15286a(C3457a c3457a);

    /* renamed from: a */
    void mo15287a(C3457a c3457a, Looper looper);

    /* renamed from: a */
    void mo15288a(C3459b c3459b);

    /* renamed from: a */
    void mo15289a(C3460c c3460c);

    /* renamed from: a */
    void mo15290a(C5142e c5142e);

    /* renamed from: aa */
    int mo15291aa(String str, long j);

    /* renamed from: aa */
    List<C7620bi> mo15292aa(String str, int i, int i2);

    /* renamed from: aa */
    void mo15293aa(C7620bi c7620bi);

    /* renamed from: ab */
    int mo15294ab(C7620bi c7620bi);

    /* renamed from: ab */
    int mo15295ab(String str, long j);

    /* renamed from: ab */
    Cursor mo15296ab(String str, int i, int i2);

    /* renamed from: ac */
    int mo15297ac(String str, long j);

    /* renamed from: ad */
    String mo15298ad(String str, long j);

    /* renamed from: ae */
    C7620bi mo15299ae(String str, long j);

    /* renamed from: af */
    C7620bi mo15300af(String str, long j);

    /* renamed from: b */
    Cursor mo15301b(String str, long j, long j2, int i);

    /* renamed from: b */
    void mo15302b(long j, C7620bi c7620bi);

    /* renamed from: b */
    void mo15303b(String str, String str2, String[] strArr);

    void bOA();

    void bOB();

    ArrayList<C7620bi> bOC();

    List<C7620bi> bOD();

    Cursor bOE();

    String bOF();

    String bOG();

    List<C7620bi> bOH();

    C7480h bOy();

    void bOz();

    /* renamed from: c */
    long mo15314c(C7620bi c7620bi, boolean z);

    /* renamed from: c */
    Cursor mo15315c(String str, long j, long j2, int i);

    /* renamed from: cA */
    int mo15316cA(String str, int i);

    /* renamed from: cB */
    Cursor mo15317cB(String str, int i);

    /* renamed from: cC */
    C7620bi[] mo15318cC(String str, int i);

    /* renamed from: cD */
    Cursor mo15319cD(String str, int i);

    /* renamed from: cs */
    List<C7620bi> mo15320cs(String str, int i);

    /* renamed from: ct */
    List<C7620bi> mo15321ct(String str, int i);

    /* renamed from: cu */
    Cursor mo15322cu(String str, int i);

    /* renamed from: cv */
    Cursor mo15323cv(String str, int i);

    /* renamed from: cw */
    Cursor mo15324cw(String str, int i);

    /* renamed from: cx */
    int mo15325cx(String str, int i);

    /* renamed from: cy */
    Cursor mo15326cy(String str, int i);

    /* renamed from: cz */
    Cursor mo15327cz(String str, int i);

    /* renamed from: d */
    Cursor mo15328d(String str, long j, long j2, int i);

    /* renamed from: e */
    int mo15329e(String str, long j, int i);

    /* renamed from: f */
    long mo15330f(String str, long j, int i);

    /* renamed from: fa */
    C7620bi mo15331fa(String str, String str2);

    /* renamed from: fb */
    Cursor mo15332fb(String str, String str2);

    /* renamed from: fc */
    int mo15333fc(String str, String str2);

    /* renamed from: fd */
    LinkedList<C7620bi> mo15334fd(String str, String str2);

    /* renamed from: g */
    long mo15335g(String str, long j, int i);

    /* renamed from: g */
    List<C7620bi> mo15336g(String str, long j, boolean z);

    /* renamed from: h */
    Cursor mo15337h(String str, int i, long j);

    /* renamed from: h */
    Cursor mo15338h(String str, long j, int i);

    /* renamed from: i */
    Cursor mo15339i(String str, int i, long j);

    /* renamed from: jf */
    C7620bi mo15340jf(long j);

    /* renamed from: jg */
    int mo15341jg(long j);

    /* renamed from: jh */
    boolean mo15342jh(long j);

    /* renamed from: ji */
    boolean mo15343ji(long j);

    /* renamed from: jj */
    void mo15344jj(long j);

    /* renamed from: oA */
    int mo15345oA(String str);

    /* renamed from: oB */
    boolean mo15346oB(String str);

    /* renamed from: p */
    Cursor mo15347p(String str, long j, long j2);

    /* renamed from: q */
    Cursor mo15348q(String str, long j, long j2);

    /* renamed from: r */
    int mo15349r(String str, long j, long j2);

    /* renamed from: s */
    int mo15350s(String str, long j, long j2);

    /* renamed from: t */
    Cursor mo15351t(String str, long j, long j2);

    /* renamed from: u */
    int mo15352u(String str, long j, long j2);

    /* renamed from: v */
    int mo15353v(String str, long j, long j2);

    /* renamed from: w */
    Cursor mo15354w(String str, long j, long j2);

    /* renamed from: yw */
    C7620bi mo15355yw(int i);
}
