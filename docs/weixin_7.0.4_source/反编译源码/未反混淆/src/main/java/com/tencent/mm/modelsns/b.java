package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
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

    static {
        AppMethodBeat.i(94480);
        AppMethodBeat.o(94480);
    }

    public static b lY(int i) {
        AppMethodBeat.i(94458);
        b bVar = new b(i, 1);
        AppMethodBeat.o(94458);
        return bVar;
    }

    public static b lZ(int i) {
        AppMethodBeat.i(94459);
        b bVar = new b(i, 4);
        AppMethodBeat.o(94459);
        return bVar;
    }

    public final boolean ajG() {
        int i = c.fQr;
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

    public b(int i, int i2) {
        AppMethodBeat.i(94460);
        this.opType = i;
        this.fQk = i2;
        if (ajG()) {
            this.timeStamp = System.currentTimeMillis();
            if (at.isWifi(ah.getContext())) {
                this.fQj = 4;
            } else if (at.is4G(ah.getContext())) {
                this.fQj = 3;
            } else if (at.is3G(ah.getContext())) {
                this.fQj = 2;
            } else if (at.is2G(ah.getContext())) {
                this.fQj = 1;
            } else {
                this.fQj = 0;
            }
            this.fQi = fQp.incrementAndGet();
            AppMethodBeat.o(94460);
            return;
        }
        AppMethodBeat.o(94460);
    }

    public final boolean ma(int i) {
        AppMethodBeat.i(94461);
        this.fQg = Integer.valueOf(i);
        AppMethodBeat.o(94461);
        return true;
    }

    public final void update() {
        AppMethodBeat.i(94462);
        if (ajG()) {
            this.timeStamp = System.currentTimeMillis();
            this.fQi = fQp.incrementAndGet();
            AppMethodBeat.o(94462);
            return;
        }
        AppMethodBeat.o(94462);
    }

    public final b tx(String str) {
        AppMethodBeat.i(94463);
        if (ajG()) {
            if (this.fQl.length() != 0) {
                this.fQl.append("||".concat(String.valueOf(str)));
            } else if (bo.isNullOrNil(str)) {
                this.fQl.append(" ");
            } else {
                this.fQl.append(str);
            }
            AppMethodBeat.o(94463);
        } else {
            AppMethodBeat.o(94463);
        }
        return this;
    }

    public final b mb(int i) {
        AppMethodBeat.i(94464);
        b tx = tx(String.valueOf(i));
        AppMethodBeat.o(94464);
        return tx;
    }

    public final b ty(String str) {
        AppMethodBeat.i(94465);
        if (ajG()) {
            if (this.fQm.length() == 0) {
                this.fQm.append(str);
            } else {
                this.fQm.append("||".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(94465);
        } else {
            AppMethodBeat.o(94465);
        }
        return this;
    }

    public final b ajH() {
        AppMethodBeat.i(94466);
        this.fQm = new StringBuffer();
        AppMethodBeat.o(94466);
        return this;
    }

    public final b ajI() {
        AppMethodBeat.i(94467);
        this.fQl = new StringBuffer();
        AppMethodBeat.o(94467);
        return this;
    }

    public final b tz(String str) {
        AppMethodBeat.i(94468);
        if (ajG()) {
            if (this.fQn.length() == 0) {
                this.fQn.append(str);
            } else {
                this.fQn.append("||".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(94468);
        } else {
            AppMethodBeat.o(94468);
        }
        return this;
    }

    public final b cS(boolean z) {
        AppMethodBeat.i(94469);
        b tx = tx(z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(94469);
        return tx;
    }

    public final b mc(int i) {
        AppMethodBeat.i(94470);
        if (ajG()) {
            if (this.fQm.length() == 0) {
                this.fQm.append(i);
            } else {
                this.fQm.append("||".concat(String.valueOf(i)));
            }
            AppMethodBeat.o(94470);
        } else {
            AppMethodBeat.o(94470);
        }
        return this;
    }

    public static void ajJ() {
        AppMethodBeat.i(94471);
        ab.i("MicroMsg.StatisticsOplog", "wait op");
        AppMethodBeat.o(94471);
    }

    public final boolean ajK() {
        AppMethodBeat.i(94472);
        if (ajG()) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(94457);
                    b.a(b.this);
                    AppMethodBeat.o(94457);
                }
            }, "StatisticsOplog");
            AppMethodBeat.o(94472);
            return true;
        }
        AppMethodBeat.o(94472);
        return false;
    }

    public final byte[] adk() {
        AppMethodBeat.i(94473);
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
            AppMethodBeat.o(94473);
            return toByteArray;
        } catch (Exception e) {
            ab.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            AppMethodBeat.o(94473);
            return null;
        }
    }

    public final void b(Intent intent, String str) {
        AppMethodBeat.i(94474);
        byte[] adk = adk();
        if (adk == null) {
            AppMethodBeat.o(94474);
            return;
        }
        intent.putExtra(str, adk);
        AppMethodBeat.o(94474);
    }

    public static b n(Bundle bundle) {
        AppMethodBeat.i(94475);
        byte[] byteArray = bundle.getByteArray("intent_key_StatisticsOplog");
        if (byteArray == null) {
            AppMethodBeat.o(94475);
            return null;
        }
        b Y = Y(byteArray);
        AppMethodBeat.o(94475);
        return Y;
    }

    public static b u(Intent intent) {
        AppMethodBeat.i(94476);
        b c = c(intent, "intent_key_StatisticsOplog");
        AppMethodBeat.o(94476);
        return c;
    }

    public static b c(Intent intent, String str) {
        AppMethodBeat.i(94477);
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            AppMethodBeat.o(94477);
            return null;
        }
        b Y = Y(byteArrayExtra);
        AppMethodBeat.o(94477);
        return Y;
    }

    private static b Y(byte[] bArr) {
        AppMethodBeat.i(94478);
        if (bArr == null) {
            AppMethodBeat.o(94478);
            return null;
        }
        cdd cdd = new cdd();
        try {
            cdd.parseFrom(bArr);
            b bVar = new b(cdd.opType, cdd.fQk);
            bVar.fQh = cdd.fQh;
            bVar.timeStamp = cdd.timeStamp;
            bVar.fQi = cdd.fQi;
            bVar.fQj = cdd.fQj;
            bVar.fQl = new StringBuffer(cdd.xcN);
            bVar.fQo = new StringBuffer(cdd.xcO);
            bVar.fQm = new StringBuffer(cdd.xcP);
            bVar.fQn = new StringBuffer(cdd.xcQ);
            AppMethodBeat.o(94478);
            return bVar;
        } catch (Exception e) {
            ab.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            AppMethodBeat.o(94478);
            return null;
        }
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(94479);
        d dVar = new d();
        dVar.l("\n\nmodel", bVar.fQh + ",");
        dVar.l("opType", bVar.opType + ",");
        dVar.l("timeStamp", bVar.timeStamp + ",");
        dVar.l("seq", bVar.fQi + ",");
        dVar.l("netWork", bVar.fQj + ",");
        dVar.l("page", bVar.fQk + ",");
        dVar.l("StatusDesc1", bVar.fQl.toString() + ",");
        dVar.l("DataFlowSourceInfo", bVar.fQm.toString() + ",");
        dVar.l("DataFlowResultInfo", bVar.fQn.toString() + ",");
        dVar.l("StatusDesc2", bVar.fQo.toString() + ", ");
        dVar.fQt.append("bindkey: " + bVar.fQg);
        ab.d("MicroMsg.StatisticsOplog", "report logbuffer: " + dVar.Fk());
        e.pXa.e(12645, dVar);
        AppMethodBeat.o(94479);
    }
}
