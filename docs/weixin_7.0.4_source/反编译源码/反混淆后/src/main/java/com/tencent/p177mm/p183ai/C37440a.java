package com.tencent.p177mm.p183ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c.C5689a;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ai.a */
public class C37440a<_Resp extends btd> {
    public C7472b ehh;
    C37442b<_Resp> fsv = new C37442b(this);
    private C37654f<C37441a<_Resp>> fsw;

    /* renamed from: com.tencent.mm.ai.a$1 */
    class C178871 implements C5689a<C37441a<_Resp>> {
        C178871() {
        }

        public final /* synthetic */ Object call() {
            AppMethodBeat.m2504i(58148);
            C5688b dMo = C5698f.dMo();
            C37440a.this.fsv.fsC = dMo;
            C37440a.this.fsv.fsB = C37440a.this.ehh;
            if (!C1226w.fuq.mo4497Rh().mo14541a(C37440a.this.fsv, 0)) {
                C4990ab.m7412e("MicroMsg.Cgi", "RunCgi doScene failed!");
                C5698f.m8555a(dMo);
            }
            AppMethodBeat.m2505o(58148);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.ai.a$a */
    public static class C37441a<T extends btd> {
        public String aIm;
        public C1207m cwn;
        public int errCode;
        public int errType;
        public T fsy;
        public C37440a fsz;

        /* renamed from: a */
        public static <T extends btd> C37441a<T> m63107a(int i, int i2, String str, T t, C1207m c1207m, C37440a c37440a) {
            AppMethodBeat.m2504i(58149);
            C37441a c37441a = new C37441a();
            c37441a.errType = i;
            c37441a.errCode = i2;
            c37441a.aIm = str;
            c37441a.fsy = t;
            c37441a.cwn = c1207m;
            c37441a.fsz = c37440a;
            if (c37440a != null) {
                c37440a.mo21469a(i, i2, str, t, c1207m);
            }
            AppMethodBeat.m2505o(58149);
            return c37441a;
        }
    }

    /* renamed from: com.tencent.mm.ai.a$b */
    static class C37442b<_Resp extends btd> extends C1207m {
        C1202f eIc = null;
        final C1207m fsA = this;
        C7472b fsB;
        C5688b fsC;
        C37440a fsD;
        private C1918k fsE = new C322301();
        final long mStartTime = C5046bo.anU();

        /* renamed from: com.tencent.mm.ai.a$b$1 */
        class C322301 implements C1918k {
            C322301() {
            }

            /* renamed from: a */
            public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
                AppMethodBeat.m2504i(58150);
                C5688b c5688b = C37442b.this.fsC;
                Object[] objArr = new Object[1];
                objArr[0] = C37441a.m63107a(i2, i3, str, (btd) C37442b.this.fsB.fsH.fsP, C37442b.this, C37442b.this.fsD);
                C5698f.m8556a(c5688b, objArr);
                C37442b.this.eIc.onSceneEnd(i2, i3, str, C37442b.this.fsA);
                C4990ab.m7417i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(C37442b.this.fsA.hashCode()), Integer.valueOf(C37442b.this.getType()), Long.valueOf(C5046bo.anU() - C37442b.this.mStartTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                AppMethodBeat.m2505o(58150);
            }
        }

        public C37442b(C37440a c37440a) {
            AppMethodBeat.m2504i(58151);
            this.fsD = c37440a;
            AppMethodBeat.m2505o(58151);
        }

        /* Access modifiers changed, original: protected|final */
        public final int acn() {
            return 1;
        }

        public final int getType() {
            return this.fsB.fsI;
        }

        /* renamed from: a */
        public final int mo4456a(C1902e c1902e, C1202f c1202f) {
            AppMethodBeat.m2504i(58152);
            this.eIc = c1202f;
            int a = mo4457a(c1902e, this.fsB, this.fsE);
            C4990ab.m7417i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.fsA.hashCode()), Integer.valueOf(this.fsB.fsI), Integer.valueOf(a), Long.valueOf(C5046bo.anU() - this.mStartTime));
            if (a < 0) {
                C5688b c5688b = this.fsC;
                Object[] objArr = new Object[1];
                objArr[0] = C37441a.m63107a(3, -1, "", (btd) this.fsB.fsH.fsP, this, this.fsD);
                C5698f.m8556a(c5688b, objArr);
            }
            AppMethodBeat.m2505o(58152);
            return a;
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(58153);
        if (this.fsv != null) {
            C1226w.m2659c(this.fsv);
        }
        if (this.fsw != null) {
            this.fsw.mo16871a(true);
        }
        AppMethodBeat.m2505o(58153);
    }

    public C37440a() {
        AppMethodBeat.m2504i(58154);
        AppMethodBeat.m2505o(58154);
    }

    /* renamed from: a */
    public final void mo60331a(C7472b c7472b) {
        this.ehh = c7472b;
    }

    public synchronized C37654f<C37441a<_Resp>> acy() {
        C37654f c37654f;
        AppMethodBeat.m2504i(58155);
        Assert.assertNotNull("You should set a CommReqResp!", this.ehh);
        Assert.assertTrue("RunCgi NetSceneQueue not ready!", C1226w.adF());
        if (this.fsw == null) {
            this.fsw = C41930g.m74066c(new C178871());
        }
        c37654f = this.fsw;
        AppMethodBeat.m2505o(58155);
        return c37654f;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo21469a(int i, int i2, String str, _Resp _resp, C1207m c1207m) {
    }
}
