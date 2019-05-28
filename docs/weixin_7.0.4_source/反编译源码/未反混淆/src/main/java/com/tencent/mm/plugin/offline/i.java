package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.h;
import com.tencent.mm.plugin.offline.a.l;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import java.util.ArrayList;

public final class i implements f {
    public ak mHandler = new ak();
    ap oXA = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(43337);
            if (g.RK()) {
                long j;
                i.this.eO(5, 5);
                ap apVar = i.this.oXA;
                i iVar = i.this;
                long bYy = (long) com.tencent.mm.plugin.offline.c.a.bYy();
                if (bYy <= 0) {
                    j = (long) iVar.oXz;
                } else {
                    ab.i("MicroMsg.OfflineTokensMgr", "OfflineTokensMgr updateInterval:".concat(String.valueOf(bYy)));
                    j = 1000 * bYy;
                }
                apVar.ae(j, j);
                AppMethodBeat.o(43337);
            } else {
                long j2 = (long) i.this.oXz;
                i.this.oXA.ae(j2, j2);
                AppMethodBeat.o(43337);
            }
            return false;
        }
    }, false);
    private boolean oXr = false;
    private boolean oXs = false;
    private int oXt = 10;
    private int oXu = 0;
    private String oXv = "";
    a oXw;
    private m oXx;
    public b oXy = new b(this, (byte) 0);
    int oXz = 14400000;

    public interface a {
        void bXa();
    }

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(i iVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(43339);
            ab.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
            if (g.RN().QY()) {
                i.this.eP(6, 6);
                AppMethodBeat.o(43339);
                return;
            }
            ab.w("MicroMsg.OfflineTokensMgr", "account not init.");
            AppMethodBeat.o(43339);
        }
    }

    public i() {
        long j = 1;
        AppMethodBeat.i(43340);
        try {
            com.tencent.mm.wallet_core.c.b.dNJ();
            com.tencent.mm.wallet_core.c.b.init(ah.getContext());
        } catch (Exception e) {
            ab.e("MicroMsg.OfflineTokensMgr", "NO MPERMISSION for READ_PHONE_STATE:%s.", e);
        }
        g.RQ();
        g.RO().eJo.a(385, (f) this);
        k.bXg();
        String Ax = k.Ax(196649);
        if (TextUtils.isEmpty(Ax) || !com.tencent.mm.plugin.offline.c.a.isNumeric(Ax)) {
            ab.i("MicroMsg.OfflineTokensMgr", "genInitInterval: update_interval is empty or is not number,update token");
        } else {
            String bYm = com.tencent.mm.plugin.offline.c.a.bYm();
            ab.i("MicroMsg.OfflineTokensMgr", "genInitInterval: token is not over update interval,lastUpdate is ".concat(String.valueOf(bYm)));
            long longValue = Long.valueOf(Ax).longValue();
            if (TextUtils.isEmpty(bYm)) {
                ab.i("MicroMsg.OfflineTokensMgr", "genInitInterval lastUpdate is empty, update token");
            } else {
                j = Long.valueOf(bYm).longValue();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                ab.i("MicroMsg.OfflineTokensMgr", "genInitInterval token is not over update interval,curTime = " + currentTimeMillis + ";");
                j = longValue - (currentTimeMillis - j);
            }
        }
        ab.i("MicroMsg.OfflineTokensMgr", "autoPusher startTimer interval=".concat(String.valueOf(j)));
        j *= 1000;
        this.oXA.ae(j, j);
        AppMethodBeat.o(43340);
    }

    public static int bXf() {
        AppMethodBeat.i(43341);
        k.bXg();
        String Ax = k.Ax(196617);
        com.tencent.mm.wallet_core.c.b.dNJ();
        int atn = com.tencent.mm.wallet_core.c.b.atn(Ax);
        ab.i("MicroMsg.OfflineTokensMgr", "offline tokens count:".concat(String.valueOf(atn)));
        AppMethodBeat.o(43341);
        return atn;
    }

    public final void eO(int i, int i2) {
        AppMethodBeat.i(43342);
        if (at.isNetworkConnected(ah.getContext()) && com.tencent.mm.plugin.offline.c.a.bYd()) {
            ab.i("MicroMsg.OfflineTokensMgr", "onNotify return false, token is invalid, do doNetSceneToken");
            eP(i, i2);
            AppMethodBeat.o(43342);
            return;
        }
        AppMethodBeat.o(43342);
    }

    public final boolean jF(boolean z) {
        AppMethodBeat.i(43343);
        if (!com.tencent.mm.plugin.offline.c.a.bYd()) {
            ab.e("MicroMsg.OfflineTokensMgr", "offline is not create!");
            AppMethodBeat.o(43343);
            return false;
        } else if (bXf() < k.oXL) {
            ab.i("MicroMsg.OfflineTokensMgr", "getTokenCount < %s, do doNetSceneToken", Integer.valueOf(k.oXL));
            com.tencent.mm.wallet_core.c.b.dNJ();
            int lastError = com.tencent.mm.wallet_core.c.b.getLastError();
            if (lastError != 0) {
                ab.e("MicroMsg.OfflineTokensMgr", "getTokenCount occurs error, the error is " + lastError + ", don't  doNetSceneToken");
                AppMethodBeat.o(43343);
                return false;
            }
            ab.i("MicroMsg.OfflineTokensMgr", "getTokenCount is success! do doNetSceneToken");
            if (z) {
                Av(9);
            } else {
                Av(2);
            }
            AppMethodBeat.o(43343);
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.bYz()) {
            ab.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isTokenOverUpdateInterval() return false, token is over update_interval, do doNetSceneToken");
            if (z) {
                eP(5, 9);
            } else {
                eP(5, 5);
            }
            AppMethodBeat.o(43343);
            return true;
        } else if (com.tencent.mm.plugin.offline.c.a.bYw()) {
            AppMethodBeat.o(43343);
            return false;
        } else {
            ab.i("MicroMsg.OfflineTokensMgr", "WalletOfflineUtil.isSameMD5ForBindSerial() return false, bindserial is change, do doNetSceneToken");
            if (z) {
                eP(3, 9);
            } else {
                eP(3, 3);
            }
            AppMethodBeat.o(43343);
            return true;
        }
    }

    public final void Av(final int i) {
        AppMethodBeat.i(43344);
        if (bXf() > 2) {
            this.mHandler.postDelayed(new Runnable() {
                final /* synthetic */ int oXC = 2;

                public final void run() {
                    AppMethodBeat.i(43338);
                    i.this.eP(this.oXC, i);
                    AppMethodBeat.o(43338);
                }
            }, 3000);
            AppMethodBeat.o(43344);
            return;
        }
        eP(2, i);
        AppMethodBeat.o(43344);
    }

    public final void eP(int i, int i2) {
        AppMethodBeat.i(43345);
        if (this.oXr) {
            AppMethodBeat.o(43345);
            return;
        }
        this.oXr = true;
        com.tencent.mm.ai.m mVar = new m((System.currentTimeMillis() / 1000), i, i2);
        g.RQ();
        g.RO().eJo.a(mVar, 0);
        Aw(i);
        AppMethodBeat.o(43345);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        int i3 = 6;
        AppMethodBeat.i(43346);
        if ((mVar instanceof h) || (mVar instanceof com.tencent.mm.plugin.offline.a.f)) {
            ArrayList arrayList = new ArrayList();
            if (mVar instanceof m) {
                IDKey iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(2);
                arrayList.add(iDKey);
                if (!(i == 0 && i2 == 0)) {
                    iDKey = new IDKey();
                    iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
                    iDKey.SetValue(1);
                    iDKey.SetKey(3);
                    arrayList.add(iDKey);
                }
                com.tencent.mm.plugin.report.service.h.pYm.b(arrayList, true);
            }
            if ((mVar instanceof com.tencent.mm.plugin.offline.a.f) && ((i == 0 && i2 == 0) || i != 0)) {
                ab.i("MicroMsg.OfflineTokensMgr", "onSceneEnd NetSceneOfflineVerifyToken errType %d errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                if (this.oXx != null) {
                    boolean bXn = this.oXx.bXn();
                    this.oXx = null;
                    if (bXn && this.oXw != null) {
                        this.oXw.bXa();
                    }
                }
            }
            if (i == 0 && i2 == 0) {
                if (mVar instanceof m) {
                    this.oXu = 0;
                    this.oXr = false;
                    this.mHandler.removeCallbacks(this.oXy);
                    this.oXx = (m) mVar;
                    String str2 = this.oXx.oYz;
                    k.bXg();
                    com.tencent.mm.ai.m fVar = new com.tencent.mm.plugin.offline.a.f(str2, k.Ax(196617));
                    g.RQ();
                    g.RO().eJo.a(fVar, 0);
                    AppMethodBeat.o(43346);
                    return;
                } else if (mVar instanceof l) {
                    this.oXs = false;
                    this.oXv = ((l) mVar).oXv;
                    if (this.oXw != null) {
                        this.oXw.bXa();
                    }
                    AppMethodBeat.o(43346);
                    return;
                } else if (mVar instanceof com.tencent.mm.plugin.offline.a.f) {
                    AppMethodBeat.o(43346);
                    return;
                }
            } else if (mVar instanceof m) {
                ab.e("MicroMsg.OfflineTokensMgr", "gettoken is failed!");
                this.oXu++;
                this.oXr = false;
                if (i2 == 411) {
                    ab.i("MicroMsg.OfflineTokensMgr", "errcode is  411, do clearAllOfflineData");
                    com.tencent.mm.plugin.offline.c.a.bYo();
                    AppMethodBeat.o(43346);
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
                AppMethodBeat.o(43346);
                return;
            } else if (mVar instanceof l) {
                this.oXs = false;
                AppMethodBeat.o(43346);
                return;
            } else if (mVar instanceof com.tencent.mm.plugin.offline.a.f) {
                this.oXx = null;
            }
            AppMethodBeat.o(43346);
            return;
        }
        AppMethodBeat.o(43346);
    }

    private static void Aw(int i) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(43347);
        boolean eA = com.tencent.mm.plugin.offline.c.a.eA(ah.getContext());
        boolean isNetworkConnected = at.isNetworkConnected(ah.getContext());
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
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
        if (k.oXK) {
            i3 = 1;
        }
        objArr[5] = Integer.valueOf(i3);
        hVar.e(14163, objArr);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(isNetworkConnected ? 36 : 37);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(eA ? 38 : 39);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(k.oXK ? 40 : 41);
        arrayList.add(iDKey);
        IDKey iDKey2;
        if (i == 2) {
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(k.oXK ? 42 : 43);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(eA ? 44 : 45);
            arrayList.add(iDKey);
            iDKey2 = new IDKey();
            iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
            iDKey2.SetValue(1);
            iDKey2.SetKey(isNetworkConnected ? 46 : 47);
            arrayList.add(iDKey2);
        } else if (i == 6) {
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(k.oXK ? 48 : 49);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(eA ? 50 : 51);
            arrayList.add(iDKey);
            iDKey2 = new IDKey();
            iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
            iDKey2.SetValue(1);
            iDKey2.SetKey(isNetworkConnected ? 52 : 53);
            arrayList.add(iDKey2);
        } else if (i == 6) {
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
            iDKey3.SetValue(1);
            iDKey3.SetKey(eA ? 54 : 55);
            arrayList.add(iDKey3);
        }
        com.tencent.mm.plugin.report.service.h.pYm.b(arrayList, true);
        AppMethodBeat.o(43347);
    }
}
