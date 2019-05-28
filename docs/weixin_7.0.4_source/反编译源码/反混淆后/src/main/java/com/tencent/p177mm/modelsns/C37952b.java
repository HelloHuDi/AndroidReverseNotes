package com.tencent.p177mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.protobuf.cdd;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.modelsns.b */
public final class C37952b {
    private static boolean fNO = false;
    private static AtomicInteger fQp = new AtomicInteger(0);
    public Object fQg = null;
    public int fQh = 1;
    public int fQi;
    public int fQj;
    public int fQk;
    public StringBuffer fQl = new StringBuffer();
    public StringBuffer fQm = new StringBuffer();
    public StringBuffer fQn = new StringBuffer();
    public StringBuffer fQo = new StringBuffer();
    public int opType = 0;
    public long timeStamp;

    /* renamed from: com.tencent.mm.modelsns.b$1 */
    class C264781 implements Runnable {
        C264781() {
        }

        public final void run() {
            AppMethodBeat.m2504i(94457);
            C37952b.m64168a(C37952b.this);
            AppMethodBeat.m2505o(94457);
        }
    }

    static {
        AppMethodBeat.m2504i(94480);
        AppMethodBeat.m2505o(94480);
    }

    /* renamed from: lY */
    public static C37952b m64170lY(int i) {
        AppMethodBeat.m2504i(94458);
        C37952b c37952b = new C37952b(i, 1);
        AppMethodBeat.m2505o(94458);
        return c37952b;
    }

    /* renamed from: lZ */
    public static C37952b m64171lZ(int i) {
        AppMethodBeat.m2504i(94459);
        C37952b c37952b = new C37952b(i, 4);
        AppMethodBeat.m2505o(94459);
        return c37952b;
    }

    public final boolean ajG() {
        int i = C32830c.fQr;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            if (this.opType >= 501 && this.opType <= 700) {
                return true;
            }
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
        }
        if (i == 2 && this.opType >= 701 && this.opType <= 1000) {
            return true;
        }
        if (i == 3 && this.opType >= 501 && this.opType <= 700) {
            return true;
        }
        if (i == 4) {
            if (this.opType >= 701 && this.opType <= 1000) {
                return true;
            }
            if (this.opType >= 501 && this.opType <= 700) {
                return true;
            }
        }
        return false;
    }

    public C37952b(int i, int i2) {
        AppMethodBeat.m2504i(94460);
        this.opType = i;
        this.fQk = i2;
        if (ajG()) {
            this.timeStamp = System.currentTimeMillis();
            if (C5023at.isWifi(C4996ah.getContext())) {
                this.fQj = 4;
            } else if (C5023at.is4G(C4996ah.getContext())) {
                this.fQj = 3;
            } else if (C5023at.is3G(C4996ah.getContext())) {
                this.fQj = 2;
            } else if (C5023at.is2G(C4996ah.getContext())) {
                this.fQj = 1;
            } else {
                this.fQj = 0;
            }
            this.fQi = fQp.incrementAndGet();
            AppMethodBeat.m2505o(94460);
            return;
        }
        AppMethodBeat.m2505o(94460);
    }

    /* renamed from: ma */
    public final boolean mo60719ma(int i) {
        AppMethodBeat.m2504i(94461);
        this.fQg = Integer.valueOf(i);
        AppMethodBeat.m2505o(94461);
        return true;
    }

    public final void update() {
        AppMethodBeat.m2504i(94462);
        if (ajG()) {
            this.timeStamp = System.currentTimeMillis();
            this.fQi = fQp.incrementAndGet();
            AppMethodBeat.m2505o(94462);
            return;
        }
        AppMethodBeat.m2505o(94462);
    }

    /* renamed from: tx */
    public final C37952b mo60722tx(String str) {
        AppMethodBeat.m2504i(94463);
        if (ajG()) {
            if (this.fQl.length() != 0) {
                this.fQl.append("||".concat(String.valueOf(str)));
            } else if (C5046bo.isNullOrNil(str)) {
                this.fQl.append(" ");
            } else {
                this.fQl.append(str);
            }
            AppMethodBeat.m2505o(94463);
        } else {
            AppMethodBeat.m2505o(94463);
        }
        return this;
    }

    /* renamed from: mb */
    public final C37952b mo60720mb(int i) {
        AppMethodBeat.m2504i(94464);
        C37952b tx = mo60722tx(String.valueOf(i));
        AppMethodBeat.m2505o(94464);
        return tx;
    }

    /* renamed from: ty */
    public final C37952b mo60723ty(String str) {
        AppMethodBeat.m2504i(94465);
        if (ajG()) {
            if (this.fQm.length() == 0) {
                this.fQm.append(str);
            } else {
                this.fQm.append("||".concat(String.valueOf(str)));
            }
            AppMethodBeat.m2505o(94465);
        } else {
            AppMethodBeat.m2505o(94465);
        }
        return this;
    }

    public final C37952b ajH() {
        AppMethodBeat.m2504i(94466);
        this.fQm = new StringBuffer();
        AppMethodBeat.m2505o(94466);
        return this;
    }

    public final C37952b ajI() {
        AppMethodBeat.m2504i(94467);
        this.fQl = new StringBuffer();
        AppMethodBeat.m2505o(94467);
        return this;
    }

    /* renamed from: tz */
    public final C37952b mo60724tz(String str) {
        AppMethodBeat.m2504i(94468);
        if (ajG()) {
            if (this.fQn.length() == 0) {
                this.fQn.append(str);
            } else {
                this.fQn.append("||".concat(String.valueOf(str)));
            }
            AppMethodBeat.m2505o(94468);
        } else {
            AppMethodBeat.m2505o(94468);
        }
        return this;
    }

    /* renamed from: cS */
    public final C37952b mo60718cS(boolean z) {
        AppMethodBeat.m2504i(94469);
        C37952b tx = mo60722tx(z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.m2505o(94469);
        return tx;
    }

    /* renamed from: mc */
    public final C37952b mo60721mc(int i) {
        AppMethodBeat.m2504i(94470);
        if (ajG()) {
            if (this.fQm.length() == 0) {
                this.fQm.append(i);
            } else {
                this.fQm.append("||".concat(String.valueOf(i)));
            }
            AppMethodBeat.m2505o(94470);
        } else {
            AppMethodBeat.m2505o(94470);
        }
        return this;
    }

    public static void ajJ() {
        AppMethodBeat.m2504i(94471);
        C4990ab.m7416i("MicroMsg.StatisticsOplog", "wait op");
        AppMethodBeat.m2505o(94471);
    }

    public final boolean ajK() {
        AppMethodBeat.m2504i(94472);
        if (ajG()) {
            C7305d.post(new C264781(), "StatisticsOplog");
            AppMethodBeat.m2505o(94472);
            return true;
        }
        AppMethodBeat.m2505o(94472);
        return false;
    }

    public final byte[] adk() {
        AppMethodBeat.m2504i(94473);
        cdd cdd = new cdd();
        cdd.opType = this.opType;
        cdd.fQk = this.fQk;
        cdd.fQh = this.fQh;
        cdd.timeStamp = this.timeStamp;
        cdd.fQi = this.fQi;
        cdd.fQj = this.fQj;
        cdd.xcN = this.fQl.toString();
        cdd.xcO = this.fQo.toString();
        cdd.xcP = this.fQm.toString();
        cdd.xcQ = this.fQn.toString();
        try {
            byte[] toByteArray = cdd.toByteArray();
            AppMethodBeat.m2505o(94473);
            return toByteArray;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            AppMethodBeat.m2505o(94473);
            return null;
        }
    }

    /* renamed from: b */
    public final void mo60717b(Intent intent, String str) {
        AppMethodBeat.m2504i(94474);
        byte[] adk = adk();
        if (adk == null) {
            AppMethodBeat.m2505o(94474);
            return;
        }
        intent.putExtra(str, adk);
        AppMethodBeat.m2505o(94474);
    }

    /* renamed from: n */
    public static C37952b m64172n(Bundle bundle) {
        AppMethodBeat.m2504i(94475);
        byte[] byteArray = bundle.getByteArray("intent_key_StatisticsOplog");
        if (byteArray == null) {
            AppMethodBeat.m2505o(94475);
            return null;
        }
        C37952b Y = C37952b.m64167Y(byteArray);
        AppMethodBeat.m2505o(94475);
        return Y;
    }

    /* renamed from: u */
    public static C37952b m64173u(Intent intent) {
        AppMethodBeat.m2504i(94476);
        C37952b c = C37952b.m64169c(intent, "intent_key_StatisticsOplog");
        AppMethodBeat.m2505o(94476);
        return c;
    }

    /* renamed from: c */
    public static C37952b m64169c(Intent intent, String str) {
        AppMethodBeat.m2504i(94477);
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            AppMethodBeat.m2505o(94477);
            return null;
        }
        C37952b Y = C37952b.m64167Y(byteArrayExtra);
        AppMethodBeat.m2505o(94477);
        return Y;
    }

    /* renamed from: Y */
    private static C37952b m64167Y(byte[] bArr) {
        AppMethodBeat.m2504i(94478);
        if (bArr == null) {
            AppMethodBeat.m2505o(94478);
            return null;
        }
        cdd cdd = new cdd();
        try {
            cdd.parseFrom(bArr);
            C37952b c37952b = new C37952b(cdd.opType, cdd.fQk);
            c37952b.fQh = cdd.fQh;
            c37952b.timeStamp = cdd.timeStamp;
            c37952b.fQi = cdd.fQi;
            c37952b.fQj = cdd.fQj;
            c37952b.fQl = new StringBuffer(cdd.xcN);
            c37952b.fQo = new StringBuffer(cdd.xcO);
            c37952b.fQm = new StringBuffer(cdd.xcP);
            c37952b.fQn = new StringBuffer(cdd.xcQ);
            AppMethodBeat.m2505o(94478);
            return c37952b;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            AppMethodBeat.m2505o(94478);
            return null;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m64168a(C37952b c37952b) {
        AppMethodBeat.m2504i(94479);
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("\n\nmodel", c37952b.fQh + ",");
        c32831d.mo53400l("opType", c37952b.opType + ",");
        c32831d.mo53400l("timeStamp", c37952b.timeStamp + ",");
        c32831d.mo53400l("seq", c37952b.fQi + ",");
        c32831d.mo53400l("netWork", c37952b.fQj + ",");
        c32831d.mo53400l("page", c37952b.fQk + ",");
        c32831d.mo53400l("StatusDesc1", c37952b.fQl.toString() + ",");
        c32831d.mo53400l("DataFlowSourceInfo", c37952b.fQm.toString() + ",");
        c32831d.mo53400l("DataFlowResultInfo", c37952b.fQn.toString() + ",");
        c32831d.mo53400l("StatusDesc2", c37952b.fQo.toString() + ", ");
        c32831d.fQt.append("bindkey: " + c37952b.fQg);
        C4990ab.m7410d("MicroMsg.StatisticsOplog", "report logbuffer: " + c32831d.mo53398Fk());
        C7053e.pXa.mo8381e(12645, c32831d);
        AppMethodBeat.m2505o(94479);
    }
}
