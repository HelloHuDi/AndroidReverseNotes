package com.tencent.p177mm.plugin.ipcall;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.support.p057v4.app.C0363v.C0358c;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.p219b.C45289k;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p230g.p231a.C18411uh;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.ipcall.p438a.C39263g;
import com.tencent.p177mm.plugin.ipcall.p438a.C39263g.C34377a;
import com.tencent.p177mm.plugin.ipcall.p438a.C46037f;
import com.tencent.p177mm.plugin.ipcall.p438a.p1274a.C43219c;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C28327c;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C28327c.C28328a;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C34367b;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C39254a;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C39254a.C21078a;
import com.tencent.p177mm.plugin.ipcall.p438a.p439b.C39254a.C392551;
import com.tencent.p177mm.plugin.ipcall.p438a.p440c.C12250b;
import com.tencent.p177mm.plugin.ipcall.p438a.p440c.C3304a;
import com.tencent.p177mm.plugin.ipcall.p438a.p440c.C3304a.C3306a;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C12256m;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C21083c;
import com.tencent.p177mm.plugin.ipcall.p438a.p983g.C28332k;
import com.tencent.p177mm.plugin.ipcall.p442ui.C21144j;
import com.tencent.p177mm.plugin.ipcall.p442ui.IPCallTalkUI;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.model.C29496c;
import com.tencent.p177mm.plugin.voip.model.C35355p;
import com.tencent.p177mm.plugin.voip.model.C35355p.C35357a;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.plugin.voip.p546ui.C14084a;
import com.tencent.p177mm.plugin.voip.p546ui.C46928e;
import com.tencent.p177mm.plugin.voip.video.C22470i;
import com.tencent.p177mm.plugin.voip.video.C22470i.C224717;
import com.tencent.p177mm.plugin.voip.video.C22470i.C43038;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.ipcall.c */
public final class C28336c implements C3306a, C34377a, C35357a {
    private static C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private C7564ap che;
    public Object meM = new Object();
    public C34383e nuX;
    private C28332k nuY;
    private boolean nuZ = false;
    private TelephonyManager nva;
    private PhoneStateListener nvb = new C283371();
    private C4884c nvc = new C283392();
    private Runnable nvd = new C283383();
    private Runnable nve = new C283344();
    public boolean nvf;
    public C14084a nvg = new C210975();
    private long nvh = 0;

    /* renamed from: com.tencent.mm.plugin.ipcall.c$5 */
    class C210975 implements C14084a {
        C210975() {
        }

        public final boolean bGV() {
            AppMethodBeat.m2504i(21669);
            if (C21088i.bHu().bHk()) {
                AppMethodBeat.m2505o(21669);
                return true;
            }
            AppMethodBeat.m2505o(21669);
            return false;
        }

        /* renamed from: a */
        public final void mo24609a(Intent intent, C46928e c46928e) {
            AppMethodBeat.m2504i(21670);
            if (C21088i.bHu().bHn()) {
                int bGU = C28336c.this.bGU();
                c46928e.aca(String.format("%02d:%02d", new Object[]{Integer.valueOf(bGU / 60), Integer.valueOf(bGU % 60)}));
                AppMethodBeat.m2505o(21670);
                return;
            }
            c46928e.abZ(C4996ah.getContext().getString(C25738R.string.d3o));
            AppMethodBeat.m2505o(21670);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.c$4 */
    class C283344 implements Runnable {
        C283344() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0096 A:{Catch:{ Exception -> 0x00cc }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Exception e;
            int i = 0;
            boolean z = true;
            AppMethodBeat.m2504i(21668);
            C22470i bHA = C21088i.bHA();
            bHA.tbh = 0;
            if (3500 != -1) {
                boolean booleanValue;
                boolean MG;
                try {
                    booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(73218, Boolean.TRUE)).booleanValue();
                    try {
                        MG = C37885a.m63954MG();
                        C4990ab.m7417i("MicroMsg.RingPlayer", "startPlayCustomRingWithCustomInterval, voipSound: %s, msgSound: %s, isCallingParty: %s", Boolean.valueOf(booleanValue), Boolean.valueOf(MG), Boolean.TRUE);
                    } catch (Exception e2) {
                        e = e2;
                        C4990ab.m7412e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                        z = booleanValue;
                        try {
                            bHA.tbi = System.currentTimeMillis();
                            bHA.tbg = new C45289k();
                            MG = C1407g.m2946KK().mo4819KP();
                            booleanValue = C1407g.m2946KK().mo4822KV();
                            C4990ab.m7411d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", Boolean.valueOf(MG), Boolean.valueOf(booleanValue));
                            if (C1427q.etd.eqm >= 0) {
                            }
                            bHA.mo38024mE(false);
                            bHA.mo38021a(C1318a.ipcall_phonering, 3500, true, i);
                            bHA.aFV = true;
                            AppMethodBeat.m2505o(21668);
                            return;
                        } catch (Exception e3) {
                            C4990ab.m7412e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e3.toString());
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    booleanValue = true;
                }
                if (z && !bHA.aFV) {
                    bHA.tbi = System.currentTimeMillis();
                    bHA.tbg = new C45289k();
                    MG = C1407g.m2946KK().mo4819KP();
                    booleanValue = C1407g.m2946KK().mo4822KV();
                    C4990ab.m7411d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", Boolean.valueOf(MG), Boolean.valueOf(booleanValue));
                    if (C1427q.etd.eqm >= 0) {
                        i = C1427q.etd.eqm;
                    }
                    bHA.mo38024mE(false);
                    bHA.mo38021a(C1318a.ipcall_phonering, 3500, true, i);
                    bHA.aFV = true;
                    AppMethodBeat.m2505o(21668);
                    return;
                }
                AppMethodBeat.m2505o(21668);
                return;
            }
            bHA.mo38025q(C1318a.ipcall_phonering, 2, true);
            AppMethodBeat.m2505o(21668);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.c$6 */
    class C283356 implements C5015a {
        C283356() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(21671);
            C28336c.this.bGS();
            if (C21088i.bHu().bHn() && C28336c.this.nuX != null) {
                C28336c.this.nuX.bHa();
            }
            AppMethodBeat.m2505o(21671);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.c$1 */
    class C283371 extends PhoneStateListener {
        C283371() {
        }

        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.m2504i(21665);
            super.onCallStateChanged(i, str);
            C4990ab.m7410d("MicroMsg.IPCallManager", "onCallStateChanged ".concat(String.valueOf(i)));
            if (i == 2) {
                C4990ab.m7416i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
                C28336c.this.mo46266eo(0, 0);
            }
            AppMethodBeat.m2505o(21665);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.c$3 */
    class C283383 implements Runnable {
        C283383() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21667);
            if (!C21088i.bHu().bHn()) {
                C4990ab.m7416i("MicroMsg.IPCallManager", "timeout! still not accept!");
                if (C28336c.this.mo46266eo(9, 12)) {
                    C28336c.this.mo46265d(9, null, C4996ah.getContext().getString(C25738R.string.abv), 2);
                }
            }
            AppMethodBeat.m2505o(21667);
        }
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.c$2 */
    class C283392 extends C4884c<C18411uh> {
        C283392() {
            AppMethodBeat.m2504i(21666);
            this.xxI = C18411uh.class.getName().hashCode();
            AppMethodBeat.m2505o(21666);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            C18411uh c18411uh = (C18411uh) c4883b;
            if (c18411uh instanceof C18411uh) {
                c18411uh.cQt.cQu = false;
                c18411uh.cQt.cQv = false;
                c18411uh.cQt.cQw = true;
                c18411uh.cQt.talker = "";
            }
            return false;
        }
    }

    public C28336c() {
        AppMethodBeat.m2504i(21672);
        AppMethodBeat.m2505o(21672);
    }

    private void removeListener() {
        AppMethodBeat.m2504i(21673);
        if (this.nva != null) {
            this.nva.listen(this.nvb, 0);
            this.nva = null;
        }
        C4879a.xxA.mo10053d(this.nvc);
        AppMethodBeat.m2505o(21673);
    }

    static {
        AppMethodBeat.m2504i(21701);
        AppMethodBeat.m2505o(21701);
    }

    /* renamed from: a */
    public final boolean mo46252a(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3) {
        AppMethodBeat.m2504i(21674);
        if (C21088i.bHu().bHk()) {
            C4990ab.m7416i("MicroMsg.IPCallManager", "startIPCall, already start!");
            AppMethodBeat.m2505o(21674);
            return false;
        }
        C4990ab.m7416i("MicroMsg.IPCallManager", "startIPCall");
        C21088i.bHq().nvE = this;
        C21088i.bHr().nxC = this;
        C21088i.bHu().mCurrentState = -1;
        removeListener();
        this.nva = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
        this.nva.listen(this.nvb, 32);
        C4879a.xxA.mo10052c(this.nvc);
        C4990ab.m7411d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", str4, str5);
        C28332k c28332k = new C28332k();
        c28332k.field_phonenumber = str4;
        if (C5046bo.isNullOrNil(str5)) {
            c28332k.field_addressId = -1;
        } else {
            C21083c OQ = C21088i.bHw().mo36404OQ(str5);
            if (OQ == null || OQ.xDa == -1) {
                c28332k.field_addressId = -1;
            } else {
                c28332k.field_addressId = OQ.xDa;
            }
        }
        if (i != -1) {
            c28332k.field_phoneType = i;
        } else {
            c28332k.field_phoneType = -1;
        }
        c28332k.field_calltime = C5046bo.anU();
        c28332k.field_status = 1;
        if (!C21088i.bHx().mo10101b((C4925c) c28332k)) {
            c28332k = null;
        }
        this.nuY = c28332k;
        fbD.postDelayed(this.nve, 1754);
        this.nuZ = false;
        C12250b bHs = C21088i.bHs();
        C4990ab.m7410d("MicroMsg.IPCallReportHelper", "reset");
        bHs.nxE = 0;
        bHs.nxF = 0;
        bHs.nxG = 0;
        bHs.nxH = 0;
        bHs.nxI = 0;
        bHs.nxJ = 0;
        bHs.nxK = 0;
        bHs.nxL = 0;
        bHs.nxM = 0;
        bHs.nxN = 0;
        bHs.nwu = 0;
        bHs.nwv = 0;
        bHs.nxO = 0;
        bHs.gyD = "";
        bHs.nxP = 0;
        bHs.nxQ = "";
        bHs.nxS = 0;
        bHs.nxR = 0;
        bHs.nvh = 0;
        bHs.nxT = 0;
        bHs.nxU = 0;
        bHs.nxZ = 0;
        bHs.nxY = 0;
        bHs.nxV = "";
        bHs.nxW = "";
        bHs.countryCode = "";
        bHs.nya = 0;
        bHs.nyb = 0;
        bHs.nyc = 0;
        bHs.nyd = 0;
        bHs.nye = 0;
        C21088i.bHu().mCurrentState = -1;
        C4990ab.m7411d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", str3, str4);
        C39263g bHq = C21088i.bHq();
        C4990ab.m7411d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", str3, str4);
        bHq.cJn = false;
        bHq.nvO = false;
        bHq.nvz = 0;
        bHq.nvA = 0;
        bHq.nvB = 0;
        bHq.nvC = false;
        bHq.nvD = false;
        bHq.nvP = false;
        bHq.nvN = new C43219c();
        bHq.nvN.nickname = str;
        bHq.nvN.nwV = str2;
        bHq.nvN.cOz = str5;
        bHq.nvN.nwW = str4;
        bHq.nvN.cMr = str3;
        bHq.nvN.nwx = (int) System.currentTimeMillis();
        bHq.nvN.nwy = i2;
        bHq.nvN.nwz = i3;
        bHq.nvN.nwY = i;
        bHq.nvF.mo68722a(bHq.nvN);
        bHq.nvK.mo68722a(bHq.nvN);
        C4990ab.m7417i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", Integer.valueOf(bHq.nvN.nwx));
        C21088i.bHu().mo73930xg(1);
        C3304a bHr = C21088i.bHr();
        if (bHr.nxB) {
            C4990ab.m7410d("MicroMsg.IPCallEngineManager", "already start engine");
        } else {
            bHr.bHM();
            C4990ab.m7416i("MicroMsg.IPCallEngineManager", "start engine");
            if (bHr.nxx.cKK()) {
                bHr.nxx.mo63320mx(false);
                bHr.nxx.reset();
            }
            bHr.nxx.sTY = 1;
            long currentTimeMillis = System.currentTimeMillis();
            int cKM = bHr.nxx.cKM();
            long currentTimeMillis2 = System.currentTimeMillis();
            C4990ab.m7411d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", Integer.valueOf(cKM), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            if (bHr.nxx.field_capInfo != null && bHr.nxx.exchangeCabInfo(bHr.nxx.field_capInfo, bHr.nxx.field_capInfo.length) < 0) {
                C4990ab.m7412e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
                C21088i.bHs().nxN = 24;
            }
            if (cKM < 0) {
                C4990ab.m7412e("MicroMsg.IPCallEngineManager", "engine init failed!");
            }
            bHr.nxx.sTY = 1;
            bHr.nxB = true;
        }
        fbD.removeCallbacks(this.nvd);
        fbD.postDelayed(this.nvd, 60000);
        AppMethodBeat.m2505o(21674);
        return true;
    }

    /* renamed from: Y */
    private boolean m44956Y(int i, int i2, int i3) {
        AppMethodBeat.m2504i(21675);
        C43219c c43219c = C21088i.bHq().nvN;
        if (C21088i.bHu().mo73930xg(i)) {
            int i4;
            C39254a c39254a;
            if (c43219c != null) {
                C4990ab.m7417i("MicroMsg.IPCallManager", "finishIPCall inviteId:%d, roomId:%d, state:%d, errStatus:%d, pstnErrCode:%d", Integer.valueOf(c43219c.nwx), Integer.valueOf(c43219c.nwu), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
            C4990ab.m7416i("MicroMsg.IPCallManager", "closeDeviceEngine");
            C35355p.cJR().cJT();
            C35355p.cJR().mo56094a(null);
            C12250b bHs = C21088i.bHs();
            C34367b bHt = C21088i.bHt();
            if (bHt.nxg != null) {
                C28327c c28327c = bHt.nxg;
                if (c28327c.nxm != null) {
                    i4 = c28327c.nxm.cpq;
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 0;
            }
            if (bHs.nyb == 0) {
                bHs.nyb = i4;
            }
            bHs = C21088i.bHs();
            bHt = C21088i.bHt();
            if (bHt.nxf != null) {
                c39254a = bHt.nxf;
                if (c39254a.kzq != null) {
                    C4990ab.m7410d("MicroMsg.IPCallAudioPlayer", "AudioPlayer  mAudioPlayErrState:" + c39254a.kzq.cIs());
                    i4 = c39254a.kzq.cIs();
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 0;
            }
            if (bHs.nyc == 0) {
                bHs.nyc = i4;
            }
            C1406a bHt2 = C21088i.bHt();
            C3304a bHr = C21088i.bHr();
            i4 = 0;
            if (bHt2.nxf != null) {
                c39254a = bHt2.nxf;
                if (c39254a.kzq == null || !c39254a.cFy) {
                    i4 = -1;
                } else {
                    i4 = c39254a.kzq.cIt();
                }
            }
            if (i4 == -1) {
                i4 = 0;
            } else {
                i4 = (int) ((((float) C9638aw.m17191ZL().getStreamVolume(i4)) / ((float) C9638aw.m17191ZL().getStreamMaxVolume(i4))) * 100.0f);
            }
            bHr.nxx.sUz = i4;
            bHt2.gar.mo73178Mm();
            c39254a = bHt2.nxf;
            if (c39254a.cFy) {
                C4990ab.m7416i("MicroMsg.IPCallAudioPlayer", "stopPlay");
                synchronized (c39254a.nxa) {
                    try {
                        C7305d.post(new C21078a(c39254a.kzq), "IPCallAudioPlayer_stop");
                        c39254a.cFy = false;
                        c39254a.kzq = null;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(21675);
                        }
                    }
                }
            }
            bHt2.crP = null;
            bHt2.kzs.mo26277fa(C4996ah.getContext());
            C9638aw.m17191ZL().mo4818KN();
            C9638aw.m17191ZL().mo4829b(bHt2);
            bHt2.nxk = null;
            bHt2.nxi = null;
            bHt = C21088i.bHt();
            C28327c c28327c2 = bHt.nxg;
            if (c28327c2.cFy) {
                C4990ab.m7416i("MicroMsg.IPCallRecorder", "stop record");
                synchronized (c28327c2.nxn) {
                    try {
                        if (c28327c2.nxm != null) {
                            C7305d.post(new C28328a(c28327c2.nxm), "IPCallRecorder_stopRecord");
                            c28327c2.nxm = null;
                            c28327c2.cFy = false;
                            c28327c2.eif = false;
                        }
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(21675);
                        }
                    }
                }
            }
            bHt.crP = null;
            C3304a bHr2 = C21088i.bHr();
            C4990ab.m7416i("MicroMsg.IPCallEngineManager", "close engine");
            bHr2.nxx.mo63320mx(true);
            C12250b bHs2 = C21088i.bHs();
            if (C5046bo.isNullOrNil(bHs2.nxW) && C5046bo.isNullOrNil(bHs2.nxV)) {
                Object obj;
                C43219c c43219c2 = C21088i.bHq().nvN;
                v2protocal v2protocal = C21088i.bHr().nxx;
                if (bHs2.nxL == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                v2protocal.getPstnChannelInfo(v2protocal.sVD, v2protocal.sVD.length, obj != null ? 1 : 0, c43219c2.nwQ);
                C4990ab.m7411d("MicroMsg.Voip", "field_pstnChannelInfoLength: %d", Integer.valueOf(v2protocal.field_pstnChannelInfoLength));
                bHs2.nxW = new String(v2protocal.sVD, 0, v2protocal.field_pstnChannelInfoLength);
                v2protocal v2protocal2 = C21088i.bHr().nxx;
                v2protocal2.getPstnEngineInfo(v2protocal2.sVE, v2protocal2.sVE.length);
                C4990ab.m7411d("MicroMsg.Voip", "field_pstnEngineInfoLength: %d", Integer.valueOf(v2protocal2.field_pstnEngineInfoLength));
                bHs2.nxV = new String(v2protocal2.sVE, 0, v2protocal2.field_pstnEngineInfoLength);
                bHs2.nxX = C21088i.bHr().nxx.cKJ();
                C4990ab.m7411d("MicroMsg.IPCallReportHelper", "nativeChannelReportString: %s", bHs2.nxW);
                C4990ab.m7411d("MicroMsg.IPCallReportHelper", "nativeEngineReportString: %s", bHs2.nxV);
                C4990ab.m7411d("MicroMsg.IPCallReportHelper", "clientReportExString: %s", bHs2.nxX);
            }
            bHr2.nxx.reset();
            bHr2.bHM();
            C21088i.bHA().stop();
            C22470i bHA = C21088i.bHA();
            C21088i.bHt();
            boolean isSpeakerphoneOn = C9638aw.m17191ZL().eoY.isSpeakerphoneOn();
            bHA.mContext.getSharedPreferences(C4996ah.doA(), 0).getBoolean("settings_shake", true);
            C1407g.m2946KK().setSpeakerphoneOn(isSpeakerphoneOn);
            if (isSpeakerphoneOn) {
                C1407g.m2946KK().setMode(0);
            } else {
                C1407g.m2946KK().setMode(2);
            }
            C4990ab.m7417i("MicroMsg.RingPlayer", "playSound, shake: %s, isSpeakerOn: %s, type: %s", Boolean.FALSE, Boolean.valueOf(isSpeakerphoneOn), Integer.valueOf(2));
            bHA.tbj = System.currentTimeMillis();
            C45289k c45289k = new C45289k();
            try {
                c45289k.setDataSource(bHA.mContext, Uri.parse("android.resource://" + bHA.mContext.getPackageName() + "/2131231812"));
                c45289k.setOnCompletionListener(new C224717());
                c45289k.setOnErrorListener(new C43038());
                i4 = (C1407g.m2946KK().mo4819KP() || !isSpeakerphoneOn) ? 0 : 2;
                c45289k.setAudioStreamType(i4);
                c45289k.prepare();
                c45289k.setLooping(false);
                c45289k.start();
                if (System.currentTimeMillis() - bHA.tbj > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    bHA.tbh = 7;
                }
            } catch (Throwable th3) {
                C4990ab.m7421w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", th3);
                bHA.tbh = 6;
                c45289k.stop();
                c45289k.release();
            }
            fbD.removeCallbacks(this.nve);
            fbD.removeCallbacks(this.nvd);
            if (this.che != null) {
                this.che.stopTimer();
                this.che = null;
            }
            C21088i.bHs().nxN = i3;
            C12250b bHs3 = C21088i.bHs();
            C4990ab.m7410d("MicroMsg.IPCallReportHelper", "markEndTalk");
            if (bHs3.nxU == 0 && bHs3.nxT != 0) {
                bHs3.nxU = System.currentTimeMillis();
                bHs3.nxM = (bHs3.nxU - bHs3.nxT) / 1000;
                C4990ab.m7411d("MicroMsg.IPCallReportHelper", "callTime: %d", Long.valueOf(bHs3.nxM));
            }
            C28332k c28332k;
            if (i == 8) {
                C21088i.bHq().bHo();
                C21088i.bHs().bHO();
                c28332k = this.nuY;
                if (c28332k != null) {
                    C4990ab.m7411d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", Long.valueOf(c28332k.xDa));
                    if (c28332k.xDa != -1) {
                        c28332k.field_status = 2;
                        C21088i.bHx().mo46245a(c28332k);
                    }
                }
            } else if (i == 12) {
                C21088i.bHq().bHo();
                C21088i.bHs().bHO();
                if (i2 == 11) {
                    C12256m.m20186b(this.nuY);
                } else {
                    c28332k = this.nuY;
                    if (c28332k != null) {
                        C4990ab.m7411d("MicroMsg.IPCallRecordStorageLogic", "recordCallFailed, localId: %d", Long.valueOf(c28332k.xDa));
                        if (c28332k.xDa != -1) {
                            c28332k.field_status = 6;
                            C21088i.bHx().mo46245a(c28332k);
                        }
                    }
                }
            } else if (i == 9) {
                C21088i.bHq().mo62160xi(1);
                C21088i.bHs().bHN();
                C12256m.m20185a(this.nuY, C21088i.bHs().nxM);
            } else if (i == 10) {
                C21088i.bHq().mo62160xi(1);
                bHs3 = C21088i.bHs();
                C4990ab.m7416i("MicroMsg.IPCallReportHelper", "otherSideUserShutdown");
                bHs3.nxG = 1;
                c28332k = this.nuY;
                long j = C21088i.bHs().nxM;
                if (c28332k != null) {
                    C4990ab.m7411d("MicroMsg.IPCallRecordStorageLogic", "recordOthersideShutdownCall, localId: %d, talkTime: %d", Long.valueOf(c28332k.xDa), Long.valueOf(j));
                    if (c28332k.xDa != -1) {
                        c28332k.field_status = 5;
                        c28332k.field_duration = j;
                        C21088i.bHx().mo46245a(c28332k);
                    }
                }
            } else if (i == 11) {
                if (i2 == 5) {
                    C21088i.bHq().mo62160xi(3);
                } else if (i2 == 11) {
                    C21088i.bHq().mo62160xi(1);
                } else {
                    C21088i.bHq().mo62160xi(2);
                }
                C21088i.bHs().bHN();
                if (i2 == 11) {
                    C12256m.m20186b(this.nuY);
                } else {
                    C12256m.m20185a(this.nuY, C21088i.bHs().nxM);
                }
            }
            if (C21088i.bHq().cJn) {
                if (this.nvf || C21088i.bHq().nvN.nwu == 0 || C21088i.bHq().nvN.nww == 0) {
                    C4990ab.m7412e("MicroMsg.IPCallManager", "roomId = 0,ignore feedback");
                } else {
                    Context context = C4996ah.getContext();
                    int i5 = C21088i.bHq().nvN.nwu;
                    long j2 = C21088i.bHq().nvN.nww;
                    C4990ab.m7416i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog");
                    if (C21098d.bGW()) {
                        int i6 = C26373g.m41964Nu().getInt("WCOMaxTimesForShowFeedback", 0);
                        C9638aw.m17190ZK();
                        int intValue = ((Integer) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_SHOW_FEEDBACK_TIME_COUNT_INT, Integer.valueOf(0))).intValue();
                        C9638aw.m17190ZK();
                        long longValue = ((Long) C18628c.m29072Ry().get(C5127a.USERFINO_IPCALL_SHOW_FEEDBACK_LAST_TIME_LONG, Long.valueOf(0))).longValue();
                        long anT = C5046bo.anT();
                        if (anT - longValue > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                            i4 = 0;
                            C4990ab.m7416i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reset time");
                        } else {
                            i4 = intValue;
                        }
                        if (i4 >= i6) {
                            C4990ab.m7416i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reach max time".concat(String.valueOf(i6)));
                        } else if (anT - longValue < 1800) {
                            C4990ab.m7416i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog not reach INTERVAL_TIMES_TRY_SHOW_WCO_FEEDBACK_MAIN");
                        } else {
                            i4++;
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_SHOW_FEEDBACK_TIME_COUNT_INT, Integer.valueOf(i4));
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERFINO_IPCALL_SHOW_FEEDBACK_LAST_TIME_LONG, Long.valueOf(anT));
                            Intent intent = new Intent();
                            intent.putExtra("IPCallFeedbackDialogUI_KRoomId", i5);
                            intent.putExtra("IPCallFeedbackDialogUI_KCallseq", j2);
                            C25985d.m41467b(context, "ipcall", ".ui.IPCallFeedbackDialogUI", intent);
                        }
                    }
                }
            }
            C21088i.bHq().nvE = null;
            C21088i.bHr().nxC = null;
            C21088i.bHu().mCurrentState = -1;
            bGT();
            removeListener();
            AppMethodBeat.m2505o(21675);
            return true;
        }
        C4990ab.m7417i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (c43219c != null) {
            C4990ab.m7417i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now inviteId:%d, roomId:%d, state:%d,errStatus:%d, pstnErrCode:%d", Integer.valueOf(c43219c.nwx), Integer.valueOf(c43219c.nwu), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
        AppMethodBeat.m2505o(21675);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: OL */
    public static boolean m44955OL(String str) {
        AppMethodBeat.m2504i(21676);
        C4990ab.m7411d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", str);
        if (C21088i.bHu().bHn()) {
            if (!C5046bo.isNullOrNil(str) && str.length() == 1) {
                int i;
                if (!C5046bo.isNullOrNil(str) && str.length() == 1) {
                    char charAt = str.charAt(0);
                    if (charAt < '0' || charAt > '9') {
                        if (charAt == '*') {
                            i = 10;
                        } else if (charAt == '#') {
                            i = 11;
                        } else if (charAt >= 'A' && charAt <= 'D') {
                            i = (charAt - 65) + 12;
                        }
                        if (i != -1) {
                            C3304a bHr = C21088i.bHr();
                            C4990ab.m7411d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", Integer.valueOf(i));
                            C12250b bHs = C21088i.bHs();
                            bHs.nye++;
                            C4990ab.m7417i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", Integer.valueOf(bHs.nye));
                            if (bHr.nxx.SendDTMF(i) < 0) {
                                C4990ab.m7417i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", Integer.valueOf(bHr.nxx.SendDTMF(i)));
                            }
                            AppMethodBeat.m2505o(21676);
                            return true;
                        }
                    }
                    i = charAt - 48;
                    if (i != -1) {
                    }
                }
                i = -1;
                if (i != -1) {
                }
            }
            AppMethodBeat.m2505o(21676);
            return false;
        }
        C4990ab.m7416i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
        AppMethodBeat.m2505o(21676);
        return false;
    }

    public final void bGJ() {
        AppMethodBeat.m2504i(21677);
        C4990ab.m7416i("MicroMsg.IPCallManager", "onInviteSuccess");
        if (C21088i.bHu().mo73930xg(3)) {
            C12250b bHs = C21088i.bHs();
            C4990ab.m7410d("MicroMsg.IPCallReportHelper", "markStartInvite");
            if (bHs.nxR == 0) {
                bHs.nxR = System.currentTimeMillis();
            }
            C43219c c43219c = C21088i.bHq().nvN;
            C12250b bHs2 = C21088i.bHs();
            int i = c43219c.nwx;
            String str = c43219c.cMr;
            String str2 = c43219c.nwW;
            int i2 = c43219c.nwu;
            long j = c43219c.nwv;
            long j2 = c43219c.nww;
            bHs2.nwx = i;
            bHs2.nxQ = str;
            bHs2.gyD = str2;
            bHs2.nwu = i2;
            bHs2.nwv = j;
            bHs2.nxO = j2;
            if (this.nuX != null) {
                this.nuX.bGJ();
            }
            AppMethodBeat.m2505o(21677);
            return;
        }
        AppMethodBeat.m2505o(21677);
    }

    /* renamed from: A */
    public final void mo46248A(String str, String str2, int i) {
        AppMethodBeat.m2504i(21678);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (mo46266eo(2, 0)) {
            mo46265d(2, str, str2, i);
        }
        AppMethodBeat.m2505o(21678);
    }

    public final void bGK() {
        AppMethodBeat.m2504i(21679);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (C21088i.bHu().mo73930xg(4)) {
            C12250b bHs = C21088i.bHs();
            C4990ab.m7410d("MicroMsg.IPCallReportHelper", "markStartRing");
            if (bHs.nxS == 0) {
                bHs.nxS = System.currentTimeMillis();
                bHs.nxJ = bHs.nxS - bHs.nxR;
                C4990ab.m7411d("MicroMsg.IPCallReportHelper", "ringTime: %d", Long.valueOf(bHs.nxJ));
            }
            C21088i.bHr().bHL();
            bHs = C21088i.bHs();
            C4990ab.m7416i("MicroMsg.IPCallReportHelper", "startRing");
            bHs.nxE = 1;
            if (this.nuX != null) {
                this.nuX.bGK();
            }
            AppMethodBeat.m2505o(21679);
            return;
        }
        AppMethodBeat.m2505o(21679);
    }

    public final void bGL() {
        AppMethodBeat.m2504i(21680);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onAccept, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (C21088i.bHu().mo73930xg(5)) {
            C12250b bHs = C21088i.bHs();
            C4990ab.m7410d("MicroMsg.IPCallReportHelper", "markUserAccept");
            if (bHs.nvh == 0) {
                bHs.nvh = System.currentTimeMillis();
                bHs.nxK = bHs.nvh - bHs.nxR;
                C4990ab.m7411d("MicroMsg.IPCallReportHelper", "answerTime: %d", Long.valueOf(bHs.nxK));
            }
            C21088i.bHr().bHL();
            bHs = C21088i.bHs();
            C4990ab.m7416i("MicroMsg.IPCallReportHelper", "userAccept");
            bHs.nxF = 1;
            fbD.removeCallbacks(this.nvd);
            C21088i.bHA().stop();
            fbD.removeCallbacks(this.nve);
            C21088i.bHt().nxg.aDm();
            if (C21088i.bHr().nxA && !this.nuZ) {
                C21088i.bHs().bHP();
                C21088i.bHs().bHS();
                this.nuZ = true;
                this.nvh = C5046bo.anT();
                arh();
                C21088i.bHr().bHK();
                if (this.nuX != null) {
                    this.nuX.bGX();
                }
                C21088i.bHs().bHR();
                C35355p.cJR().cJS();
                C35355p.cJR().mo56094a(this);
            }
            AppMethodBeat.m2505o(21680);
            return;
        }
        AppMethodBeat.m2505o(21680);
    }

    /* renamed from: d */
    public final void mo46265d(int i, String str, String str2, int i2) {
        AppMethodBeat.m2504i(21681);
        if (this.nuX != null) {
            this.nuX.mo36470d(i, str, str2, i2);
            AppMethodBeat.m2505o(21681);
            return;
        }
        Toast.makeText(C4996ah.getContext(), str2, 1).show();
        AppMethodBeat.m2505o(21681);
    }

    /* renamed from: cn */
    public final void mo46262cn(String str, int i) {
        AppMethodBeat.m2504i(21682);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (mo46266eo(3, 5)) {
            mo46265d(3, null, str, i);
        }
        AppMethodBeat.m2505o(21682);
    }

    /* renamed from: co */
    public final void mo46263co(String str, int i) {
        AppMethodBeat.m2504i(21683);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onBusy, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (mo46266eo(1, 4)) {
            mo46265d(1, null, str, i);
        }
        AppMethodBeat.m2505o(21683);
    }

    public final void bGM() {
        AppMethodBeat.m2504i(21684);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (m44956Y(10, 0, 32)) {
            if (this.nuX != null) {
                this.nuX.bGY();
                AppMethodBeat.m2505o(21684);
                return;
            }
            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.ci6), 1).show();
        }
        AppMethodBeat.m2505o(21684);
    }

    /* renamed from: cp */
    public final void mo46264cp(String str, int i) {
        AppMethodBeat.m2504i(21685);
        C4990ab.m7416i("MicroMsg.IPCallManager", "onSyncFailed");
        if (mo46266eo(7, 35)) {
            mo46265d(7, null, str, i);
        }
        AppMethodBeat.m2505o(21685);
    }

    public final void bGN() {
        AppMethodBeat.m2504i(21686);
        C4990ab.m7416i("MicroMsg.IPCallManager", "onHeartbeatFailed");
        if (mo46266eo(7, 29)) {
            mo46265d(7, null, C4996ah.getContext().getString(C25738R.string.abp), 1);
        }
        AppMethodBeat.m2505o(21686);
    }

    /* renamed from: B */
    public final void mo46249B(String str, String str2, int i) {
        AppMethodBeat.m2504i(21687);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (mo46266eo(8, 9)) {
            mo46265d(8, str, str2, i);
        }
        AppMethodBeat.m2505o(21687);
    }

    /* renamed from: C */
    public final void mo46250C(String str, String str2, int i) {
        AppMethodBeat.m2504i(21688);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (mo46266eo(10, 0)) {
            mo46265d(10, str, str2, i);
        }
        AppMethodBeat.m2505o(21688);
    }

    /* renamed from: D */
    public final void mo46251D(String str, String str2, int i) {
        AppMethodBeat.m2504i(21689);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (mo46266eo(11, 0)) {
            mo46265d(11, str, str2, i);
        }
        AppMethodBeat.m2505o(21689);
    }

    public final void bGO() {
        AppMethodBeat.m2504i(21690);
        do {
            C4990ab.m7417i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        } while (mo46266eo(12, 0));
        AppMethodBeat.m2505o(21690);
    }

    public final void bGP() {
        AppMethodBeat.m2504i(21691);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (mo46266eo(6, 0)) {
            mo46265d(6, null, C4996ah.getContext().getString(C25738R.string.abv), 1);
        }
        AppMethodBeat.m2505o(21691);
    }

    public final void bGQ() {
        AppMethodBeat.m2504i(21692);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        C21088i.bHA().stop();
        fbD.removeCallbacks(this.nve);
        if (C21088i.bHu().bHl()) {
            C1406a bHt = C21088i.bHt();
            bHt.kzs.mo26276a(C4996ah.getContext(), bHt);
            C9638aw.m17191ZL().mo4828a(bHt);
            C9638aw.m17191ZL().mo4817KM();
            bHt.kzt = C9638aw.m17191ZL().mo4822KV();
            bHt.kzu = C9638aw.m17191ZL().mo4819KP();
            C4990ab.m7411d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", Boolean.valueOf(bHt.kzt), Boolean.valueOf(bHt.kzu));
            bHt.gar.requestFocus();
            C39254a c39254a = bHt.nxf;
            if (c39254a.cFy) {
                C4990ab.m7410d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
            } else {
                C4990ab.m7416i("MicroMsg.IPCallAudioPlayer", "startPlay");
                if (c39254a.kzq == null) {
                    c39254a.kzq = new C29496c();
                    c39254a.kzq.mo47750G(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
                }
                c39254a.nxb = c39254a.kzq.mo47759x(C4996ah.getContext(), false);
                c39254a.kzq.sNt = new C392551();
                if (c39254a.kzq.cIp() <= 0) {
                    C21088i.bHs().bHQ();
                }
                c39254a.mo62156io(c39254a.nxc);
                c39254a.cFy = true;
            }
            if (!(!bHt.kzt || bHt.kzu || bHt.nxk == null)) {
                bHt.nxk.mo36472ir(true);
            }
            if (!(!bHt.kzu || bHt.kzt || bHt.nxk == null)) {
                bHt.nxk.mo36473is(true);
            }
        }
        C21088i.bHs().bHP();
        C21088i.bHt().nxg.aDm();
        if (C21088i.bHu().bHn() && !this.nuZ) {
            C21088i.bHs().bHS();
            C21088i.bHr().bHK();
            this.nuZ = true;
            this.nvh = C5046bo.anT();
            arh();
            if (this.nuX != null) {
                this.nuX.bGX();
            }
            C28332k c28332k = this.nuY;
            if (c28332k != null) {
                C4990ab.m7411d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", Long.valueOf(c28332k.xDa));
                if (c28332k.xDa != -1) {
                    c28332k.field_status = 3;
                    C21088i.bHx().mo46245a(c28332k);
                }
            }
            C21088i.bHs().bHR();
            C35355p.cJR().cJS();
            C35355p.cJR().mo56094a(this);
        }
        AppMethodBeat.m2505o(21692);
    }

    /* renamed from: xe */
    public final void mo7686xe(int i) {
        AppMethodBeat.m2504i(21693);
        C4990ab.m7417i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", C46037f.stateToString(C21088i.bHu().mCurrentState));
        if (C21088i.bHr().nxA) {
            C4990ab.m7416i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
            if (mo46266eo(5, i)) {
                mo46265d(5, null, C4996ah.getContext().getString(C25738R.string.abp), 1);
                AppMethodBeat.m2505o(21693);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
        if (mo46266eo(4, i)) {
            mo46265d(4, null, C4996ah.getContext().getString(C25738R.string.abp), 1);
        }
        AppMethodBeat.m2505o(21693);
    }

    /* renamed from: eo */
    public final boolean mo46266eo(int i, int i2) {
        AppMethodBeat.m2504i(21694);
        boolean Y;
        if (C21088i.bHu().bHn()) {
            if (i == 0) {
                Y = m44956Y(9, i, i2);
                AppMethodBeat.m2505o(21694);
                return Y;
            }
            Y = m44956Y(11, i, i2);
            AppMethodBeat.m2505o(21694);
            return Y;
        } else if (i == 0) {
            Y = m44956Y(8, i, i2);
            AppMethodBeat.m2505o(21694);
            return Y;
        } else {
            Y = m44956Y(12, i, i2);
            AppMethodBeat.m2505o(21694);
            return Y;
        }
    }

    /* renamed from: ig */
    public final void mo30909ig(boolean z) {
        AppMethodBeat.m2504i(21695);
        if (C21088i.bHu().mCurrentState != 5) {
            C4990ab.m7417i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", Integer.valueOf(C21088i.bHu().mCurrentState));
            AppMethodBeat.m2505o(21695);
            return;
        }
        C34367b bHt = C21088i.bHt();
        C4990ab.m7416i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
        if (bHt.nxi != null) {
            C21144j c21144j = bHt.nxi;
            if (c21144j.nGB != null) {
                c21144j.nGB.setVisibility(0);
            }
            if (c21144j.nGC != null) {
                c21144j.nGC.setVisibility(0);
            }
        }
        if (!C9638aw.m17191ZL().eoY.isSpeakerphoneOn()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - bHt.nxl > 30000) {
                bHt.nxl = currentTimeMillis;
                C43727b.cIj().sSP.cKp();
            }
        }
        AppMethodBeat.m2505o(21695);
    }

    public final void bGR() {
        AppMethodBeat.m2504i(21696);
        if (C21088i.bHu().mCurrentState != 5) {
            C4990ab.m7417i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", Integer.valueOf(C21088i.bHu().mCurrentState));
            AppMethodBeat.m2505o(21696);
            return;
        }
        C34367b bHt = C21088i.bHt();
        C4990ab.m7416i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
        if (bHt.nxi != null) {
            bHt.nxi.bIK();
        }
        AppMethodBeat.m2505o(21696);
    }

    public final void bGS() {
        CharSequence string;
        AppMethodBeat.m2504i(21697);
        if (C21088i.bHu().bHn()) {
            Context context = C4996ah.getContext();
            Object[] objArr = new Object[1];
            objArr[0] = String.format("%02d:%02d", new Object[]{Long.valueOf(C5046bo.m7549fp(this.nvh) / 60), Long.valueOf(C5046bo.m7549fp(this.nvh) % 60)});
            string = context.getString(C25738R.string.ch2, objArr);
        } else {
            string = C4996ah.getContext().getString(C25738R.string.ch1);
        }
        Intent intent = new Intent(C4996ah.getContext(), IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 42, intent, 134217728);
        int i = C25738R.drawable.bdo;
        if (C1443d.m3067fP(19)) {
            i = C25738R.drawable.bdn;
        }
        C0358c e = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(C4996ah.getContext().getString(C25738R.string.ch1)).mo626j(System.currentTimeMillis()).mo621d(C4996ah.getContext().getString(C25738R.string.cgr)).mo623e(string);
        e.f362EI = activity;
        Notification build = e.build();
        build.icon = i;
        build.flags |= 32;
        C9638aw.getNotification().mo41574a(42, build, false);
        if (C21088i.bHu().bHn()) {
            C43727b.cIk().mo63353Dq(bGU());
            AppMethodBeat.m2505o(21697);
            return;
        }
        C43727b.cIk().abZ(C4996ah.getContext().getString(C25738R.string.d3o));
        AppMethodBeat.m2505o(21697);
    }

    public final void bGT() {
        AppMethodBeat.m2504i(21698);
        synchronized (this.meM) {
            try {
                this.nvf = false;
                C43727b.cIk().dismiss();
                ((NotificationManager) C4996ah.getContext().getSystemService("notification")).cancel(42);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(21698);
            }
        }
    }

    public final int bGU() {
        AppMethodBeat.m2504i(21699);
        int fp = (int) C5046bo.m7549fp(this.nvh);
        if (fp > 0) {
            AppMethodBeat.m2505o(21699);
            return fp;
        }
        AppMethodBeat.m2505o(21699);
        return 0;
    }

    private void arh() {
        AppMethodBeat.m2504i(21700);
        C4990ab.m7416i("MicroMsg.IPCallManager", "startTimeCount");
        if (this.che != null) {
            this.che.stopTimer();
            AppMethodBeat.m2505o(21700);
            return;
        }
        if (this.che == null) {
            this.che = new C7564ap(Looper.getMainLooper(), new C283356(), true);
        }
        this.che.mo16770ae(1000, 1000);
        AppMethodBeat.m2505o(21700);
    }
}
