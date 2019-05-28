package com.tencent.p177mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p478a.C21403m;
import com.tencent.p177mm.plugin.offline.p478a.C28628l;
import com.tencent.p177mm.plugin.offline.p478a.C46116f;
import com.tencent.p177mm.plugin.offline.p478a.C46117h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.offline.i */
public final class C39473i implements C1202f {
    public C7306ak mHandler = new C7306ak();
    C7564ap oXA = new C7564ap(new C394721(), false);
    private boolean oXr = false;
    private boolean oXs = false;
    private int oXt = 10;
    private int oXu = 0;
    private String oXv = "";
    C21413a oXw;
    private C21403m oXx;
    public C21414b oXy = new C21414b(this, (byte) 0);
    int oXz = 14400000;

    /* renamed from: com.tencent.mm.plugin.offline.i$a */
    public interface C21413a {
        void bXa();
    }

    /* renamed from: com.tencent.mm.plugin.offline.i$b */
    class C21414b implements Runnable {
        private C21414b() {
        }

        /* synthetic */ C21414b(C39473i c39473i, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(43339);
            C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
            if (C1720g.m3534RN().mo5161QY()) {
                C39473i.this.mo62420eP(6, 6);
                AppMethodBeat.m2505o(43339);
                return;
            }
            C4990ab.m7420w("MicroMsg.OfflineTokensMgr", "account not init.");
            AppMethodBeat.m2505o(43339);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.i$1 */
    class C394721 implements C5015a {
        C394721() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(43337);
            if (C1720g.m3531RK()) {
                long j;
                C39473i.this.mo62419eO(5, 5);
                C7564ap c7564ap = C39473i.this.oXA;
                C39473i c39473i = C39473i.this;
                long bYy = (long) C28630a.bYy();
                if (bYy <= 0) {
                    j = (long) c39473i.oXz;
                } else {
                    C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:".concat(String.valueOf(bYy)));
                    j = 1000 * bYy;
                }
                c7564ap.mo16770ae(j, j);
                AppMethodBeat.m2505o(43337);
            } else {
                long j2 = (long) C39473i.this.oXz;
                C39473i.this.oXA.mo16770ae(j2, j2);
                AppMethodBeat.m2505o(43337);
            }
            return false;
        }
    }

    public C39473i() {
        long j = 1;
        AppMethodBeat.m2504i(43340);
        try {
            C40928b.dNJ();
            C40928b.init(C4996ah.getContext());
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", e);
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(385, (C1202f) this);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196649);
        if (TextUtils.isEmpty(Ax) || !C28630a.isNumeric(Ax)) {
            C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        } else {
            String bYm = C28630a.bYm();
            C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is ".concat(String.valueOf(bYm)));
            long longValue = Long.valueOf(Ax).longValue();
            if (TextUtils.isEmpty(bYm)) {
                C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
            } else {
                j = Long.valueOf(bYm).longValue();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + currentTimeMillis + ";");
                j = longValue - (currentTimeMillis - j);
            }
        }
        C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(j)));
        j *= 1000;
        this.oXA.mo16770ae(j, j);
        AppMethodBeat.m2505o(43340);
    }

    public static int bXf() {
        AppMethodBeat.m2504i(43341);
        C7007k.bXg();
        String Ax = C7007k.m11709Ax(196617);
        C40928b.dNJ();
        int atn = C40928b.atn(Ax);
        C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(atn)));
        AppMethodBeat.m2505o(43341);
        return atn;
    }

    /* renamed from: eO */
    public final void mo62419eO(int i, int i2) {
        AppMethodBeat.m2504i(43342);
        if (C5023at.isNetworkConnected(C4996ah.getContext()) && C28630a.bYd()) {
            C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
            mo62420eP(i, i2);
            AppMethodBeat.m2505o(43342);
            return;
        }
        AppMethodBeat.m2505o(43342);
    }

    /* renamed from: jF */
    public final boolean mo62421jF(boolean z) {
        AppMethodBeat.m2504i(43343);
        if (!C28630a.bYd()) {
            C4990ab.m7412e("MicroMsg.OfflineTokensMgr", "offline is not create!");
            AppMethodBeat.m2505o(43343);
            return false;
        } else if (C39473i.bXf() < C7007k.oXL) {
            C4990ab.m7417i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", Integer.valueOf(C7007k.oXL));
            C40928b.dNJ();
            int lastError = C40928b.getLastError();
            if (lastError != 0) {
                C4990ab.m7412e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + lastError + ", don't  doNetSceneToken");
                AppMethodBeat.m2505o(43343);
                return false;
            }
            C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
            if (z) {
                mo62418Av(9);
            } else {
                mo62418Av(2);
            }
            AppMethodBeat.m2505o(43343);
            return true;
        } else if (C28630a.bYz()) {
            C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
            if (z) {
                mo62420eP(5, 9);
            } else {
                mo62420eP(5, 5);
            }
            AppMethodBeat.m2505o(43343);
            return true;
        } else if (C28630a.bYw()) {
            AppMethodBeat.m2505o(43343);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
            if (z) {
                mo62420eP(3, 9);
            } else {
                mo62420eP(3, 3);
            }
            AppMethodBeat.m2505o(43343);
            return true;
        }
    }

    /* renamed from: Av */
    public final void mo62418Av(final int i) {
        AppMethodBeat.m2504i(43344);
        if (C39473i.bXf() > 2) {
            this.mHandler.postDelayed(new Runnable() {
                final /* synthetic */ int oXC = 2;

                public final void run() {
                    AppMethodBeat.m2504i(43338);
                    C39473i.this.mo62420eP(this.oXC, i);
                    AppMethodBeat.m2505o(43338);
                }
            }, 3000);
            AppMethodBeat.m2505o(43344);
            return;
        }
        mo62420eP(2, i);
        AppMethodBeat.m2505o(43344);
    }

    /* renamed from: eP */
    public final void mo62420eP(int i, int i2) {
        AppMethodBeat.m2504i(43345);
        if (this.oXr) {
            AppMethodBeat.m2505o(43345);
            return;
        }
        this.oXr = true;
        C1207m c21403m = new C21403m((System.currentTimeMillis() / 1000), i, i2);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c21403m, 0);
        C39473i.m67451Aw(i);
        AppMethodBeat.m2505o(43345);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 6;
        AppMethodBeat.m2504i(43346);
        if ((c1207m instanceof C46117h) || (c1207m instanceof C46116f)) {
            ArrayList arrayList = new ArrayList();
            if (c1207m instanceof C21403m) {
                IDKey iDKey = new IDKey();
                iDKey.SetID(C44697b.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(2);
                arrayList.add(iDKey);
                if (!(i == 0 && i2 == 0)) {
                    iDKey = new IDKey();
                    iDKey.SetID(C44697b.CTRL_INDEX);
                    iDKey.SetValue(1);
                    iDKey.SetKey(3);
                    arrayList.add(iDKey);
                }
                C7060h.pYm.mo8379b(arrayList, true);
            }
            if ((c1207m instanceof C46116f) && ((i == 0 && i2 == 0) || i != 0)) {
                C4990ab.m7417i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                if (this.oXx != null) {
                    boolean bXn = this.oXx.bXn();
                    this.oXx = null;
                    if (bXn && this.oXw != null) {
                        this.oXw.bXa();
                    }
                }
            }
            if (i == 0 && i2 == 0) {
                if (c1207m instanceof C21403m) {
                    this.oXu = 0;
                    this.oXr = false;
                    this.mHandler.removeCallbacks(this.oXy);
                    this.oXx = (C21403m) c1207m;
                    String str2 = this.oXx.oYz;
                    C7007k.bXg();
                    C1207m c46116f = new C46116f(str2, C7007k.m11709Ax(196617));
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(c46116f, 0);
                    AppMethodBeat.m2505o(43346);
                    return;
                } else if (c1207m instanceof C28628l) {
                    this.oXs = false;
                    this.oXv = ((C28628l) c1207m).oXv;
                    if (this.oXw != null) {
                        this.oXw.bXa();
                    }
                    AppMethodBeat.m2505o(43346);
                    return;
                } else if (c1207m instanceof C46116f) {
                    AppMethodBeat.m2505o(43346);
                    return;
                }
            } else if (c1207m instanceof C21403m) {
                C4990ab.m7412e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
                this.oXu++;
                this.oXr = false;
                if (i2 == 411) {
                    C4990ab.m7416i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
                    C28630a.bYo();
                    AppMethodBeat.m2505o(43346);
                    return;
                }
                if (this.oXu < this.oXt) {
                    this.mHandler.removeCallbacks(this.oXy);
                    int i4 = this.oXu - 1;
                    if (i4 <= 6) {
                        i3 = i4;
                    }
                    this.mHandler.postDelayed(this.oXy, (long) ((((int) Math.pow(2.0d, (double) i3)) * 60) * 1000));
                }
                AppMethodBeat.m2505o(43346);
                return;
            } else if (c1207m instanceof C28628l) {
                this.oXs = false;
                AppMethodBeat.m2505o(43346);
                return;
            } else if (c1207m instanceof C46116f) {
                this.oXx = null;
            }
            AppMethodBeat.m2505o(43346);
            return;
        }
        AppMethodBeat.m2505o(43346);
    }

    /* renamed from: Aw */
    private static void m67451Aw(int i) {
        int i2;
        int i3 = 0;
        AppMethodBeat.m2504i(43347);
        boolean eA = C28630a.m45520eA(C4996ah.getContext());
        boolean isNetworkConnected = C5023at.isNetworkConnected(C4996ah.getContext());
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(4);
        objArr[1] = Integer.valueOf(eA ? 0 : 1);
        if (isNetworkConnected) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(i);
        if (C7007k.oXK) {
            i3 = 1;
        }
        objArr[5] = Integer.valueOf(i3);
        c7060h.mo8381e(14163, objArr);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(C44697b.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(isNetworkConnected ? 36 : 37);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(C44697b.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(eA ? 38 : 39);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(C44697b.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(C7007k.oXK ? 40 : 41);
        arrayList.add(iDKey);
        IDKey iDKey2;
        if (i == 2) {
            iDKey = new IDKey();
            iDKey.SetID(C44697b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(C7007k.oXK ? 42 : 43);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(C44697b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(eA ? 44 : 45);
            arrayList.add(iDKey);
            iDKey2 = new IDKey();
            iDKey2.SetID(C44697b.CTRL_INDEX);
            iDKey2.SetValue(1);
            iDKey2.SetKey(isNetworkConnected ? 46 : 47);
            arrayList.add(iDKey2);
        } else if (i == 6) {
            iDKey = new IDKey();
            iDKey.SetID(C44697b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(C7007k.oXK ? 48 : 49);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(C44697b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(eA ? 50 : 51);
            arrayList.add(iDKey);
            iDKey2 = new IDKey();
            iDKey2.SetID(C44697b.CTRL_INDEX);
            iDKey2.SetValue(1);
            iDKey2.SetKey(isNetworkConnected ? 52 : 53);
            arrayList.add(iDKey2);
        } else if (i == 6) {
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(C44697b.CTRL_INDEX);
            iDKey3.SetValue(1);
            iDKey3.SetKey(eA ? 54 : 55);
            arrayList.add(iDKey3);
        }
        C7060h.pYm.mo8379b(arrayList, true);
        AppMethodBeat.m2505o(43347);
    }
}
