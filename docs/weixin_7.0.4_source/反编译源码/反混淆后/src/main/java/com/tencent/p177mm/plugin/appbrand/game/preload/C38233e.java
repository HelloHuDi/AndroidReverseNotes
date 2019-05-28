package com.tencent.p177mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C1586bp;
import com.tencent.p177mm.p230g.p232b.p233a.C1586bp.C1587a;
import com.tencent.p177mm.p230g.p232b.p233a.C1586bp.C1588b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.game.preload.e */
public class C38233e {
    private static volatile C38233e htA;
    public int gOW = -1;
    public String htB;
    public int htC;
    public int htD;
    public int htE;
    public String htF;
    public int htG;
    boolean htH = false;
    public int htI;

    private C38233e() {
    }

    public static C38233e aBD() {
        AppMethodBeat.m2504i(130307);
        if (htA == null) {
            synchronized (C38233e.class) {
                try {
                    if (htA == null) {
                        htA = new C38233e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(130307);
                    }
                }
            }
        }
        C38233e c38233e = htA;
        AppMethodBeat.m2505o(130307);
        return c38233e;
    }

    /* renamed from: cY */
    public final void mo60956cY(int i, int i2) {
        int i3 = 1;
        AppMethodBeat.m2504i(130308);
        if (!(C5046bo.isNullOrNil(this.htF) || C5046bo.isNullOrNil(this.htB))) {
            long j;
            String str = "MicroMsg.WAGamePreloadStatisManager";
            String str2 = "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d";
            Object[] objArr = new Object[9];
            objArr[0] = this.htF;
            objArr[1] = this.htB;
            objArr[2] = Integer.valueOf(this.htC);
            objArr[3] = Integer.valueOf(this.htD);
            objArr[4] = Integer.valueOf(this.htE);
            objArr[5] = Integer.valueOf(i);
            objArr[6] = Integer.valueOf(i2);
            objArr[7] = Integer.valueOf(this.gOW);
            if (!this.htH) {
                i3 = 0;
            }
            objArr[8] = Integer.valueOf(i3);
            C4990ab.m7419v(str, str2, objArr);
            C1586bp c1586bp = new C1586bp();
            c1586bp.mo5015gl(this.htF);
            c1586bp.mo5016gm(this.htB);
            c1586bp.ddd = (long) this.htC;
            c1586bp.dde = C1587a.m3206gP(this.htD);
            c1586bp.ddf = C1588b.m3207gQ(this.htE);
            c1586bp.ddg = (long) this.htG;
            c1586bp.ddh = (long) i;
            c1586bp.ddi = (long) i2;
            if (this.htH) {
                j = 1;
            } else {
                j = 0;
            }
            c1586bp.ddj = j;
            c1586bp.cVR = (long) this.gOW;
            c1586bp.ddk = (long) this.htI;
            c1586bp.ajK();
        }
        AppMethodBeat.m2505o(130308);
    }
}
