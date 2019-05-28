package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.location.model.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o implements f, com.tencent.mm.bh.b {
    public boolean cFy = false;
    public boolean chh = false;
    public com.tencent.mm.modelgeo.b.a ecy = new com.tencent.mm.modelgeo.b.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.i(113384);
            if (z) {
                ab.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d));
                if (o.this.nKR) {
                    o.this.nKR = false;
                    o.this.nKT = System.currentTimeMillis();
                    long j = o.this.nKT - o.this.nKS;
                    ab.d("MicorMsg.TrackRefreshManager", "locate time:%d", Long.valueOf(j));
                    h.pYm.e(10997, PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "", Integer.valueOf(0), Long.valueOf(j));
                }
                if (!(o.this.nKI == null || o.this.nKI.xkm == null)) {
                    o.this.nKI.xkm.vNI = (double) f2;
                    o.this.nKI.xkm.vNH = (double) f;
                }
                AppMethodBeat.o(113384);
                return true;
            }
            AppMethodBeat.o(113384);
            return false;
        }
    };
    public d fwu;
    ak mHandler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(113383);
            super.handleMessage(message);
            if (message == null) {
                AppMethodBeat.o(113383);
                return;
            }
            o oVar = o.this;
            switch (message.what) {
                case 1:
                    oVar.bJH();
                    break;
            }
            AppMethodBeat.o(113383);
        }
    };
    private String nJs;
    public double nJu = -1000.0d;
    public double nJv = -1000.0d;
    public int nJw = -1;
    private int nKD = 0;
    private int nKE = 1000;
    public i nKF;
    public HashSet<WeakReference<b>> nKG = new HashSet();
    public int nKH = 1;
    public cmj nKI;
    public LocationInfo nKJ = new LocationInfo((byte) 0);
    public boolean nKK = false;
    public boolean nKL = false;
    public int nKM = this.nKH;
    public String nKN = "";
    boolean nKO = false;
    public a nKP = null;
    public int nKQ = -1;
    public boolean nKR = true;
    public long nKS = 0;
    long nKT = 0;
    public com.tencent.mm.plugin.location.model.i.a nKU = new com.tencent.mm.plugin.location.model.i.a() {
        public final void y(double d) {
            if (o.this.nKI != null) {
                o.this.nKI.xkm.wNP = d;
            }
        }
    };
    private int timestamp;

    public interface a {
        void ayR();
    }

    public interface b {
        void a(bqu bqu);

        void bJJ();

        void bJK();

        void onError(int i, String str);
    }

    public o() {
        AppMethodBeat.i(113385);
        AppMethodBeat.o(113385);
    }

    public final void stop() {
        AppMethodBeat.i(113386);
        ab.i("MicorMsg.TrackRefreshManager", "stop location");
        if (this.fwu != null) {
            this.fwu.c(this.ecy);
        }
        if (this.nKF != null) {
            this.nKF.b(this.nKU);
        }
        g.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX, (f) this);
        g.Rg().b(490, (f) this);
        g.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.p.d.CTRL_INDEX, (f) this);
        this.nKH = 1;
        this.cFy = false;
        this.nKQ = -1;
        AppMethodBeat.o(113386);
    }

    public final boolean bJC() {
        AppMethodBeat.i(113387);
        if (bJI() && this.nKK) {
            AppMethodBeat.o(113387);
            return true;
        }
        AppMethodBeat.o(113387);
        return false;
    }

    private void cr(String str, int i) {
        AppMethodBeat.i(113388);
        ab.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", Integer.valueOf(i));
        m aVar = new com.tencent.mm.plugin.location.model.a.a(str);
        ((yy) aVar.ehh.fsG.fsP).Scene = i;
        g.Rg().a(aVar, 0);
        this.nJs = "";
        AppMethodBeat.o(113388);
    }

    public final void xC(int i) {
        AppMethodBeat.i(113389);
        ab.i("MicorMsg.TrackRefreshManager", "track endTrack");
        if (bJI()) {
            cr(this.nJs, i);
        }
        if (!bo.isNullOrNil(this.nKN)) {
            com.tencent.mm.plugin.location.a.a PQ = l.bJz().PQ(this.nKN);
            if (PQ != null) {
                PQ.cGh.remove(r.Yz());
                l.bJz().a(this.nKN, PQ.cGh, PQ.latitude, PQ.longitude, PQ.nJq, null, null);
            }
        }
        l.bJz().PR("");
        this.nJs = "";
        this.nKN = "";
        this.nKK = false;
        this.nKL = false;
        this.nJu = -1000.0d;
        this.nJv = -1000.0d;
        this.nJw = -1;
        this.nKQ = -1;
        AppMethodBeat.o(113389);
    }

    private void bJD() {
        AppMethodBeat.i(113390);
        ab.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
        if (bJI()) {
            ab.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
            this.fwu = d.agz();
            this.fwu.b(this.ecy, true);
            if (this.nKF == null) {
                this.nKF = l.bJA();
            }
            this.nKF.a(this.nKU);
            bJH();
        }
        AppMethodBeat.o(113390);
    }

    public final void bJE() {
        AppMethodBeat.i(113391);
        ab.d("MicorMsg.TrackRefreshManager", "resume refresh");
        this.nKO = false;
        bJD();
        AppMethodBeat.o(113391);
    }

    public final String akN() {
        return this.nKN;
    }

    public final List<String> bJF() {
        AppMethodBeat.i(113392);
        LinkedList tP = l.bJz().tP(this.nKN);
        AppMethodBeat.o(113392);
        return tP;
    }

    public final void bJG() {
        if (this.nKH == 1) {
            this.nKH = 3;
        } else if (this.nKH == 3) {
            this.nKH = 2;
        }
    }

    public final void bJH() {
        boolean z = true;
        AppMethodBeat.i(113393);
        String str;
        if (!this.cFy || !this.nKK || this.nKJ == null) {
            str = "MicorMsg.TrackRefreshManager";
            StringBuilder append = new StringBuilder("error to exit refresh isStart: ").append(this.cFy).append(" isShared: ").append(this.nKK).append(" ");
            if (this.nKJ != null) {
                z = false;
            }
            ab.e(str, append.append(z).toString());
            AppMethodBeat.o(113393);
        } else if (this.nKI == null || this.nKI.xkm.vNI == -1000.0d || this.nKI.xkm.vNH == -1000.0d) {
            ab.e("MicorMsg.TrackRefreshManager", "error to get my location ");
            this.mHandler.sendEmptyMessageDelayed(1, (long) this.nKE);
            AppMethodBeat.o(113393);
        } else {
            String Yz = r.Yz();
            cie cie = new cie();
            cie.wKW = this.nKJ.nJx;
            cie.vNI = this.nKJ.nJu;
            cie.vNH = this.nKJ.nJv;
            cie.Name = Yz;
            this.nKI.vHl = Yz;
            this.nKI.xkm.wNP = l.bJA().bJr();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("refreshLoopImpl, [trackRoomId:" + this.nJs + "]");
            switch (this.nKH) {
                case 0:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUpload ");
                    break;
                case 1:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomDownload ");
                    break;
                case 2:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
                    break;
                case 3:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomFirstUpload ");
                    stringBuffer.append("[ trackItem " + cie.vNI + " " + cie.vNH + " ]");
                    break;
            }
            stringBuffer.append("[ mMyPosiItem " + this.nKI.xkm.vNI + " " + this.nKI.xkm.vNH + " " + this.nKI.xkm.wNP + " ]");
            ab.d("MicorMsg.TrackRefreshManager", stringBuffer.toString());
            str = this.nJs;
            int i = this.nKH;
            cmj cmj = this.nKI;
            int i2 = this.timestamp + 1;
            this.timestamp = i2;
            g.Rg().a(new c(str, i, cmj, i2, cie), 0);
            AppMethodBeat.o(113393);
        }
    }

    public final boolean bJI() {
        AppMethodBeat.i(113394);
        if (bo.isNullOrNil(this.nJs)) {
            AppMethodBeat.o(113394);
            return false;
        }
        AppMethodBeat.o(113394);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(113395);
        ab.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        WeakReference weakReference;
        Iterator it;
        bqu bqu;
        if (mVar.getType() == 490) {
            Iterator it2;
            if (i2 == 0 || i2 >= 1000) {
                this.nJs = ((com.tencent.mm.plugin.location.model.a.b) mVar).nJs;
                l.bJz().PR(this.nJs);
                if (bJI()) {
                    ab.i("MicorMsg.TrackRefreshManager", "join sucess %s", this.nJs);
                    LinkedList tP = com.tencent.mm.bh.d.fUu.tP(this.nKN);
                    tP.add(r.Yz());
                    if (this.nKJ != null) {
                        com.tencent.mm.bh.d.fUu.a(this.nKN, tP, this.nKJ.nJu, this.nKJ.nJv, this.nKJ.nJx, "", "");
                    } else {
                        com.tencent.mm.bh.d.fUu.a(this.nKN, tP, -1000.0d, -1000.0d, "", "", "");
                    }
                    if (this.nKG != null) {
                        it2 = this.nKG.iterator();
                        while (it2.hasNext()) {
                            weakReference = (WeakReference) it2.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((b) weakReference.get()).bJJ();
                            }
                        }
                    }
                    bJH();
                    AppMethodBeat.o(113395);
                    return;
                }
            }
            if (i2 == 17 && this.nKG != null) {
                it2 = this.nKG.iterator();
                while (it2.hasNext()) {
                    weakReference = (WeakReference) it2.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).bJK();
                    }
                }
            }
            if (this.nKG != null) {
                it = this.nKG.iterator();
                while (it.hasNext()) {
                    weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b) mVar).hwA);
                    }
                }
                AppMethodBeat.o(113395);
                return;
            }
        } else if (i == 0 && i2 == 0) {
            if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX) {
                Object obj;
                bqu = ((c) mVar).nLe;
                if (!(bqu == null || bqu.BaseResponse == null)) {
                    if (bqu.BaseResponse.Ret == 12) {
                        this.chh = true;
                        if (this.nKP != null) {
                            this.nKP.ayR();
                        }
                    } else {
                        this.chh = false;
                    }
                    ab.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", Boolean.valueOf(this.chh), Integer.valueOf(bqu.BaseResponse.Ret));
                }
                if (this.nKD > 0) {
                    h.pYm.e(10997, "9", "", Integer.valueOf(this.nKD), Integer.valueOf(0));
                }
                this.nKD = 0;
                this.nKE = ((c) mVar).nLb;
                int i3 = ((c) mVar).nLf;
                if (this.nKG != null && (i3 == 2 || i3 == 1 || i3 == 3)) {
                    it = this.nKG.iterator();
                    while (it.hasNext()) {
                        weakReference = (WeakReference) it.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).a(((c) mVar).nLe);
                        }
                    }
                }
                if (this.nKH == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    bJG();
                }
                this.mHandler.removeMessages(1);
                if (!(!bJI() || this.nKO || this.chh)) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.nKE);
                }
                AppMethodBeat.o(113395);
                return;
            } else if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.p.d.CTRL_INDEX) {
                l.bJz().PR("");
            }
        } else if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.g.f.CTRL_INDEX) {
            this.nKD++;
            this.mHandler.removeMessages(1);
            if (this.nKD >= 10) {
                this.mHandler.removeMessages(1);
                if (this.nKG != null) {
                    it = this.nKG.iterator();
                    while (it.hasNext()) {
                        weakReference = (WeakReference) it.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).onError(1, ((c) mVar).hwA);
                        }
                    }
                    AppMethodBeat.o(113395);
                    return;
                }
            } else if (bJI() && !this.nKO) {
                bqu = ((c) mVar).nLe;
                if (!(bqu == null || bqu.BaseResponse == null)) {
                    if (bqu.BaseResponse.Ret == 12) {
                        this.chh = true;
                        if (this.nKP != null) {
                            this.nKP.ayR();
                        }
                    } else {
                        this.chh = false;
                    }
                    ab.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", Boolean.valueOf(this.chh), Integer.valueOf(bqu.BaseResponse.Ret));
                }
                if (!this.chh) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.nKE);
                }
                AppMethodBeat.o(113395);
                return;
            }
        }
        AppMethodBeat.o(113395);
    }
}
