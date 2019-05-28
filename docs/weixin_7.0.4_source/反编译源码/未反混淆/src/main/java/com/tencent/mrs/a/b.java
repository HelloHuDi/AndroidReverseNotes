package com.tencent.mrs.a;

import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.adt;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends m implements k {
    private static boolean isRunning = false;
    private static Object lock = new Object();
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    private ads pXt = null;

    public static boolean isRunning() {
        boolean z;
        synchronized (lock) {
            z = isRunning;
        }
        return z;
    }

    private static void setIsRunning(boolean z) {
        synchronized (lock) {
            isRunning = z;
        }
    }

    public b(byte[] bArr) {
        setIsRunning(true);
        af afVar = new af();
        this.pXt = new ads();
        try {
            afVar.parseFrom(bArr);
            this.pXt.wlS = afVar;
        } catch (Exception e) {
            ab.e("Matrix.NetSceneGetMrsStrategy", "parse data error");
            g.RQ();
            g.RS().aa(new Runnable() {
                public final void run() {
                    MatrixReport.with().onStrategyResp(3, -1, null);
                }
            });
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        try {
            if (g.RO().eJo == null || g.RO().eJo.ftA == null) {
                ab.f("Matrix.NetSceneGetMrsStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.ehi.onSceneEnd(i2, i3, str, this);
                setIsRunning(false);
            } else if (i2 != 0) {
                ab.e("Matrix.NetSceneGetMrsStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
                MatrixReport.with().onStrategyResp(i2, i3, null);
                this.ehi.onSceneEnd(i2, i3, str, this);
                setIsRunning(false);
            } else {
                ab.d("Matrix.NetSceneGetMrsStrategy", "get report strategy ok");
                MatrixReport.with().onStrategyResp(0, 0, ((adt) this.ehh.fsH.fsP).wlT.toByteArray());
                this.ehi.onSceneEnd(i2, i3, str, this);
                setIsRunning(false);
            }
        } catch (Exception e) {
            ab.e("Matrix.NetSceneGetMrsStrategy", "failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bo.l(e));
        } catch (Throwable th) {
            setIsRunning(false);
        }
    }

    public final int getType() {
        return 914;
    }

    public final int a(e eVar, f fVar) {
        int i;
        int i2 = -1;
        this.ehi = fVar;
        if (eVar == null || eVar.adg() == null || !eVar.adg().adb()) {
            boolean i3 = false;
        } else {
            i3 = 1;
        }
        if (i3 == 0) {
            ab.w("Matrix.NetSceneGetMrsStrategy", "get mrs strategy must go after login");
        } else {
            a aVar = new a();
            aVar.fsN = false;
            aVar.fsJ = this.pXt;
            aVar.fsK = new adt();
            aVar.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            aVar.fsI = 914;
            this.ehh = aVar.acD();
            i2 = a(eVar, this.ehh, this);
            if (i2 < 0) {
                ab.i("Matrix.NetSceneGetMrsStrategy", "mark all failed. do scene %d", Integer.valueOf(i2));
                try {
                    MatrixReport.with().onStrategyResp(3, -1, null);
                    setIsRunning(false);
                } catch (Exception e) {
                    ab.e("Matrix.NetSceneGetMrsStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bo.l(e));
                }
            }
        }
        return i2;
    }
}
