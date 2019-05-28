package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bp;
import com.tencent.mm.g.b.a.bp.a;
import com.tencent.mm.g.b.a.bp.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class e {
    private static volatile e htA;
    public int gOW = -1;
    public String htB;
    public int htC;
    public int htD;
    public int htE;
    public String htF;
    public int htG;
    boolean htH = false;
    public int htI;

    private e() {
    }

    public static e aBD() {
        AppMethodBeat.i(130307);
        if (htA == null) {
            synchronized (e.class) {
                try {
                    if (htA == null) {
                        htA = new e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(130307);
                    }
                }
            }
        }
        e eVar = htA;
        AppMethodBeat.o(130307);
        return eVar;
    }

    public final void cY(int i, int i2) {
        int i3 = 1;
        AppMethodBeat.i(130308);
        if (!(bo.isNullOrNil(this.htF) || bo.isNullOrNil(this.htB))) {
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
            ab.v(str, str2, objArr);
            bp bpVar = new bp();
            bpVar.gl(this.htF);
            bpVar.gm(this.htB);
            bpVar.ddd = (long) this.htC;
            bpVar.dde = a.gP(this.htD);
            bpVar.ddf = b.gQ(this.htE);
            bpVar.ddg = (long) this.htG;
            bpVar.ddh = (long) i;
            bpVar.ddi = (long) i2;
            if (this.htH) {
                j = 1;
            } else {
                j = 0;
            }
            bpVar.ddj = j;
            bpVar.cVR = (long) this.gOW;
            bpVar.ddk = (long) this.htI;
            bpVar.ajK();
        }
        AppMethodBeat.o(130308);
    }
}
