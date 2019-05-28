package com.tencent.mrs.p655a;

import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C7247af;
import com.tencent.p177mm.protocal.protobuf.C7531ads;
import com.tencent.p177mm.protocal.protobuf.adt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mrs.a.b */
public final class C7373b extends C1207m implements C1918k {
    private static boolean isRunning = false;
    private static Object lock = new Object();
    private C7472b ehh;
    private C1202f ehi;
    private C7531ads pXt = null;

    /* renamed from: com.tencent.mrs.a.b$1 */
    class C57681 implements Runnable {
        C57681() {
        }

        public final void run() {
            MatrixReport.with().onStrategyResp(3, -1, null);
        }
    }

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

    public C7373b(byte[] bArr) {
        C7373b.setIsRunning(true);
        C7247af c7247af = new C7247af();
        this.pXt = new C7531ads();
        try {
            c7247af.parseFrom(bArr);
            this.pXt.wlS = c7247af;
        } catch (Exception e) {
            C4990ab.m7412e("Matrix.NetSceneGetMrsStrategy", "parse data error");
            C1720g.m3537RQ();
            C1720g.m3539RS().mo10302aa(new C57681());
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        try {
            if (C1720g.m3535RO().eJo == null || C1720g.m3535RO().eJo.ftA == null) {
                C4990ab.m7414f("Matrix.NetSceneGetMrsStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.ehi.onSceneEnd(i2, i3, str, this);
                C7373b.setIsRunning(false);
            } else if (i2 != 0) {
                C4990ab.m7412e("Matrix.NetSceneGetMrsStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
                MatrixReport.with().onStrategyResp(i2, i3, null);
                this.ehi.onSceneEnd(i2, i3, str, this);
                C7373b.setIsRunning(false);
            } else {
                C4990ab.m7410d("Matrix.NetSceneGetMrsStrategy", "get report strategy ok");
                MatrixReport.with().onStrategyResp(0, 0, ((adt) this.ehh.fsH.fsP).wlT.toByteArray());
                this.ehi.onSceneEnd(i2, i3, str, this);
                C7373b.setIsRunning(false);
            }
        } catch (Exception e) {
            C4990ab.m7413e("Matrix.NetSceneGetMrsStrategy", "failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), C5046bo.m7574l(e));
        } catch (Throwable th) {
            C7373b.setIsRunning(false);
        }
    }

    public final int getType() {
        return 914;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int i;
        int i2 = -1;
        this.ehi = c1202f;
        if (c1902e == null || c1902e.adg() == null || !c1902e.adg().adb()) {
            boolean i3 = false;
        } else {
            i3 = 1;
        }
        if (i3 == 0) {
            C4990ab.m7420w("Matrix.NetSceneGetMrsStrategy", "get mrs strategy must go after login");
        } else {
            C1196a c1196a = new C1196a();
            c1196a.fsN = false;
            c1196a.fsJ = this.pXt;
            c1196a.fsK = new adt();
            c1196a.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            c1196a.fsI = 914;
            this.ehh = c1196a.acD();
            i2 = mo4457a(c1902e, this.ehh, this);
            if (i2 < 0) {
                C4990ab.m7417i("Matrix.NetSceneGetMrsStrategy", "mark all failed. do scene %d", Integer.valueOf(i2));
                try {
                    MatrixReport.with().onStrategyResp(3, -1, null);
                    C7373b.setIsRunning(false);
                } catch (Exception e) {
                    C4990ab.m7413e("Matrix.NetSceneGetMrsStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), C5046bo.m7574l(e));
                }
            }
        }
        return i2;
    }
}
