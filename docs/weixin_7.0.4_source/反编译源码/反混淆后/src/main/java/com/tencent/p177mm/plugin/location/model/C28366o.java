package com.tencent.p177mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelgeo.C42207b.C42206a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.p837bh.C9082b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C26982f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27057d;
import com.tencent.p177mm.plugin.location.model.C28360i.C28361a;
import com.tencent.p177mm.plugin.location.model.p1278a.C21168a;
import com.tencent.p177mm.plugin.location.model.p1278a.C21169b;
import com.tencent.p177mm.plugin.location.model.p1278a.C43241c;
import com.tencent.p177mm.plugin.location.p734a.C6958a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40592yy;
import com.tencent.p177mm.protocal.protobuf.bqu;
import com.tencent.p177mm.protocal.protobuf.cie;
import com.tencent.p177mm.protocal.protobuf.cmj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.location.model.o */
public final class C28366o implements C1202f, C9082b {
    public boolean cFy = false;
    public boolean chh = false;
    public C42206a ecy = new C283652();
    public C26443d fwu;
    C7306ak mHandler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(113383);
            super.handleMessage(message);
            if (message == null) {
                AppMethodBeat.m2505o(113383);
                return;
            }
            C28366o c28366o = C28366o.this;
            switch (message.what) {
                case 1:
                    c28366o.bJH();
                    break;
            }
            AppMethodBeat.m2505o(113383);
        }
    };
    private String nJs;
    public double nJu = -1000.0d;
    public double nJv = -1000.0d;
    public int nJw = -1;
    private int nKD = 0;
    private int nKE = 1000;
    public C28360i nKF;
    public HashSet<WeakReference<C28369b>> nKG = new HashSet();
    public int nKH = 1;
    public cmj nKI;
    public LocationInfo nKJ = new LocationInfo((byte) 0);
    public boolean nKK = false;
    public boolean nKL = false;
    public int nKM = this.nKH;
    public String nKN = "";
    boolean nKO = false;
    public C28367a nKP = null;
    public int nKQ = -1;
    public boolean nKR = true;
    public long nKS = 0;
    long nKT = 0;
    public C28361a nKU = new C283683();
    private int timestamp;

    /* renamed from: com.tencent.mm.plugin.location.model.o$2 */
    class C283652 implements C42206a {
        C283652() {
        }

        /* renamed from: a */
        public final boolean mo5861a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            AppMethodBeat.m2504i(113384);
            if (z) {
                C4990ab.m7411d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d));
                if (C28366o.this.nKR) {
                    C28366o.this.nKR = false;
                    C28366o.this.nKT = System.currentTimeMillis();
                    long j = C28366o.this.nKT - C28366o.this.nKS;
                    C4990ab.m7411d("MicorMsg.TrackRefreshManager", "locate time:%d", Long.valueOf(j));
                    C7060h.pYm.mo8381e(10997, PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "", Integer.valueOf(0), Long.valueOf(j));
                }
                if (!(C28366o.this.nKI == null || C28366o.this.nKI.xkm == null)) {
                    C28366o.this.nKI.xkm.vNI = (double) f2;
                    C28366o.this.nKI.xkm.vNH = (double) f;
                }
                AppMethodBeat.m2505o(113384);
                return true;
            }
            AppMethodBeat.m2505o(113384);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.o$a */
    public interface C28367a {
        void ayR();
    }

    /* renamed from: com.tencent.mm.plugin.location.model.o$3 */
    class C283683 implements C28361a {
        C283683() {
        }

        /* renamed from: y */
        public final void mo24250y(double d) {
            if (C28366o.this.nKI != null) {
                C28366o.this.nKI.xkm.wNP = d;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.location.model.o$b */
    public interface C28369b {
        /* renamed from: a */
        void mo46330a(bqu bqu);

        void bJJ();

        void bJK();

        void onError(int i, String str);
    }

    public C28366o() {
        AppMethodBeat.m2504i(113385);
        AppMethodBeat.m2505o(113385);
    }

    public final void stop() {
        AppMethodBeat.m2504i(113386);
        C4990ab.m7416i("MicorMsg.TrackRefreshManager", "stop location");
        if (this.fwu != null) {
            this.fwu.mo44208c(this.ecy);
        }
        if (this.nKF != null) {
            this.nKF.mo46316b(this.nKU);
        }
        C1720g.m3540Rg().mo14546b((int) C26982f.CTRL_INDEX, (C1202f) this);
        C1720g.m3540Rg().mo14546b(490, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C27057d.CTRL_INDEX, (C1202f) this);
        this.nKH = 1;
        this.cFy = false;
        this.nKQ = -1;
        AppMethodBeat.m2505o(113386);
    }

    public final boolean bJC() {
        AppMethodBeat.m2504i(113387);
        if (bJI() && this.nKK) {
            AppMethodBeat.m2505o(113387);
            return true;
        }
        AppMethodBeat.m2505o(113387);
        return false;
    }

    /* renamed from: cr */
    private void m45007cr(String str, int i) {
        AppMethodBeat.m2504i(113388);
        C4990ab.m7411d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", Integer.valueOf(i));
        C1207m c21168a = new C21168a(str);
        ((C40592yy) c21168a.ehh.fsG.fsP).Scene = i;
        C1720g.m3540Rg().mo14541a(c21168a, 0);
        this.nJs = "";
        AppMethodBeat.m2505o(113388);
    }

    /* renamed from: xC */
    public final void mo46328xC(int i) {
        AppMethodBeat.m2504i(113389);
        C4990ab.m7416i("MicorMsg.TrackRefreshManager", "track endTrack");
        if (bJI()) {
            m45007cr(this.nJs, i);
        }
        if (!C5046bo.isNullOrNil(this.nKN)) {
            C6958a PQ = C39287l.bJz().mo36494PQ(this.nKN);
            if (PQ != null) {
                PQ.cGh.remove(C1853r.m3846Yz());
                C39287l.bJz().mo20559a(this.nKN, PQ.cGh, PQ.latitude, PQ.longitude, PQ.nJq, null, null);
            }
        }
        C39287l.bJz().mo36495PR("");
        this.nJs = "";
        this.nKN = "";
        this.nKK = false;
        this.nKL = false;
        this.nJu = -1000.0d;
        this.nJv = -1000.0d;
        this.nJw = -1;
        this.nKQ = -1;
        AppMethodBeat.m2505o(113389);
    }

    private void bJD() {
        AppMethodBeat.m2504i(113390);
        C4990ab.m7410d("MicorMsg.TrackRefreshManager", "trigerRefresh");
        if (bJI()) {
            C4990ab.m7410d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
            this.fwu = C26443d.agz();
            this.fwu.mo44207b(this.ecy, true);
            if (this.nKF == null) {
                this.nKF = C39287l.bJA();
            }
            this.nKF.mo46315a(this.nKU);
            bJH();
        }
        AppMethodBeat.m2505o(113390);
    }

    public final void bJE() {
        AppMethodBeat.m2504i(113391);
        C4990ab.m7410d("MicorMsg.TrackRefreshManager", "resume refresh");
        this.nKO = false;
        bJD();
        AppMethodBeat.m2505o(113391);
    }

    public final String akN() {
        return this.nKN;
    }

    public final List<String> bJF() {
        AppMethodBeat.m2504i(113392);
        LinkedList tP = C39287l.bJz().mo20564tP(this.nKN);
        AppMethodBeat.m2505o(113392);
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
        AppMethodBeat.m2504i(113393);
        String str;
        if (!this.cFy || !this.nKK || this.nKJ == null) {
            str = "MicorMsg.TrackRefreshManager";
            StringBuilder append = new StringBuilder("error to exit refresh isStart: ").append(this.cFy).append(" isShared: ").append(this.nKK).append(" ");
            if (this.nKJ != null) {
                z = false;
            }
            C4990ab.m7412e(str, append.append(z).toString());
            AppMethodBeat.m2505o(113393);
        } else if (this.nKI == null || this.nKI.xkm.vNI == -1000.0d || this.nKI.xkm.vNH == -1000.0d) {
            C4990ab.m7412e("MicorMsg.TrackRefreshManager", "error to get my location ");
            this.mHandler.sendEmptyMessageDelayed(1, (long) this.nKE);
            AppMethodBeat.m2505o(113393);
        } else {
            String Yz = C1853r.m3846Yz();
            cie cie = new cie();
            cie.wKW = this.nKJ.nJx;
            cie.vNI = this.nKJ.nJu;
            cie.vNH = this.nKJ.nJv;
            cie.Name = Yz;
            this.nKI.vHl = Yz;
            this.nKI.xkm.wNP = C39287l.bJA().bJr();
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
            C4990ab.m7410d("MicorMsg.TrackRefreshManager", stringBuffer.toString());
            str = this.nJs;
            int i = this.nKH;
            cmj cmj = this.nKI;
            int i2 = this.timestamp + 1;
            this.timestamp = i2;
            C1720g.m3540Rg().mo14541a(new C43241c(str, i, cmj, i2, cie), 0);
            AppMethodBeat.m2505o(113393);
        }
    }

    public final boolean bJI() {
        AppMethodBeat.m2504i(113394);
        if (C5046bo.isNullOrNil(this.nJs)) {
            AppMethodBeat.m2505o(113394);
            return false;
        }
        AppMethodBeat.m2505o(113394);
        return true;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(113395);
        C4990ab.m7411d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        WeakReference weakReference;
        Iterator it;
        bqu bqu;
        if (c1207m.getType() == 490) {
            Iterator it2;
            if (i2 == 0 || i2 >= 1000) {
                this.nJs = ((C21169b) c1207m).nJs;
                C39287l.bJz().mo36495PR(this.nJs);
                if (bJI()) {
                    C4990ab.m7417i("MicorMsg.TrackRefreshManager", "join sucess %s", this.nJs);
                    LinkedList tP = C25859d.fUu.mo20564tP(this.nKN);
                    tP.add(C1853r.m3846Yz());
                    if (this.nKJ != null) {
                        C25859d.fUu.mo20559a(this.nKN, tP, this.nKJ.nJu, this.nKJ.nJv, this.nKJ.nJx, "", "");
                    } else {
                        C25859d.fUu.mo20559a(this.nKN, tP, -1000.0d, -1000.0d, "", "", "");
                    }
                    if (this.nKG != null) {
                        it2 = this.nKG.iterator();
                        while (it2.hasNext()) {
                            weakReference = (WeakReference) it2.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((C28369b) weakReference.get()).bJJ();
                            }
                        }
                    }
                    bJH();
                    AppMethodBeat.m2505o(113395);
                    return;
                }
            }
            if (i2 == 17 && this.nKG != null) {
                it2 = this.nKG.iterator();
                while (it2.hasNext()) {
                    weakReference = (WeakReference) it2.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((C28369b) weakReference.get()).bJK();
                    }
                }
            }
            if (this.nKG != null) {
                it = this.nKG.iterator();
                while (it.hasNext()) {
                    weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((C28369b) weakReference.get()).onError(0, ((C21169b) c1207m).hwA);
                    }
                }
                AppMethodBeat.m2505o(113395);
                return;
            }
        } else if (i == 0 && i2 == 0) {
            if (c1207m.getType() == C26982f.CTRL_INDEX) {
                Object obj;
                bqu = ((C43241c) c1207m).nLe;
                if (!(bqu == null || bqu.BaseResponse == null)) {
                    if (bqu.BaseResponse.Ret == 12) {
                        this.chh = true;
                        if (this.nKP != null) {
                            this.nKP.ayR();
                        }
                    } else {
                        this.chh = false;
                    }
                    C4990ab.m7411d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", Boolean.valueOf(this.chh), Integer.valueOf(bqu.BaseResponse.Ret));
                }
                if (this.nKD > 0) {
                    C7060h.pYm.mo8381e(10997, "9", "", Integer.valueOf(this.nKD), Integer.valueOf(0));
                }
                this.nKD = 0;
                this.nKE = ((C43241c) c1207m).nLb;
                int i3 = ((C43241c) c1207m).nLf;
                if (this.nKG != null && (i3 == 2 || i3 == 1 || i3 == 3)) {
                    it = this.nKG.iterator();
                    while (it.hasNext()) {
                        weakReference = (WeakReference) it.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((C28369b) weakReference.get()).mo46330a(((C43241c) c1207m).nLe);
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
                AppMethodBeat.m2505o(113395);
                return;
            } else if (c1207m.getType() == C27057d.CTRL_INDEX) {
                C39287l.bJz().mo36495PR("");
            }
        } else if (c1207m.getType() == C26982f.CTRL_INDEX) {
            this.nKD++;
            this.mHandler.removeMessages(1);
            if (this.nKD >= 10) {
                this.mHandler.removeMessages(1);
                if (this.nKG != null) {
                    it = this.nKG.iterator();
                    while (it.hasNext()) {
                        weakReference = (WeakReference) it.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((C28369b) weakReference.get()).onError(1, ((C43241c) c1207m).hwA);
                        }
                    }
                    AppMethodBeat.m2505o(113395);
                    return;
                }
            } else if (bJI() && !this.nKO) {
                bqu = ((C43241c) c1207m).nLe;
                if (!(bqu == null || bqu.BaseResponse == null)) {
                    if (bqu.BaseResponse.Ret == 12) {
                        this.chh = true;
                        if (this.nKP != null) {
                            this.nKP.ayR();
                        }
                    } else {
                        this.chh = false;
                    }
                    C4990ab.m7411d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", Boolean.valueOf(this.chh), Integer.valueOf(bqu.BaseResponse.Ret));
                }
                if (!this.chh) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.nKE);
                }
                AppMethodBeat.m2505o(113395);
                return;
            }
        }
        AppMethodBeat.m2505o(113395);
    }
}
