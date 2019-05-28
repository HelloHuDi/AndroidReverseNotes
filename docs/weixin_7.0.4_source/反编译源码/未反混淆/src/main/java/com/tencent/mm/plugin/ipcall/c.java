package com.tencent.mm.plugin.ipcall;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.c.a.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class c implements a, g.a, p.a {
    private static ak fbD = new ak(Looper.getMainLooper());
    private ap che;
    public Object meM = new Object();
    public e nuX;
    private k nuY;
    private boolean nuZ = false;
    private TelephonyManager nva;
    private PhoneStateListener nvb = new PhoneStateListener() {
        public final void onCallStateChanged(int i, String str) {
            AppMethodBeat.i(21665);
            super.onCallStateChanged(i, str);
            ab.d("MicroMsg.IPCallManager", "onCallStateChanged ".concat(String.valueOf(i)));
            if (i == 2) {
                ab.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
                c.this.eo(0, 0);
            }
            AppMethodBeat.o(21665);
        }
    };
    private com.tencent.mm.sdk.b.c nvc = new com.tencent.mm.sdk.b.c<uh>() {
        {
            AppMethodBeat.i(21666);
            this.xxI = uh.class.getName().hashCode();
            AppMethodBeat.o(21666);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            uh uhVar = (uh) bVar;
            if (uhVar instanceof uh) {
                uhVar.cQt.cQu = false;
                uhVar.cQt.cQv = false;
                uhVar.cQt.cQw = true;
                uhVar.cQt.talker = "";
            }
            return false;
        }
    };
    private Runnable nvd = new Runnable() {
        public final void run() {
            AppMethodBeat.i(21667);
            if (!i.bHu().bHn()) {
                ab.i("MicroMsg.IPCallManager", "timeout! still not accept!");
                if (c.this.eo(9, 12)) {
                    c.this.d(9, null, ah.getContext().getString(R.string.abv), 2);
                }
            }
            AppMethodBeat.o(21667);
        }
    };
    private Runnable nve = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0096 A:{Catch:{ Exception -> 0x00cc }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Exception e;
            int i = 0;
            boolean z = true;
            AppMethodBeat.i(21668);
            com.tencent.mm.plugin.voip.video.i bHA = i.bHA();
            bHA.tbh = 0;
            if (3500 != -1) {
                boolean booleanValue;
                boolean MG;
                try {
                    booleanValue = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(73218, Boolean.TRUE)).booleanValue();
                    try {
                        MG = com.tencent.mm.m.a.MG();
                        ab.i("MicroMsg.RingPlayer", "startPlayCustomRingWithCustomInterval, voipSound: %s, msgSound: %s, isCallingParty: %s", Boolean.valueOf(booleanValue), Boolean.valueOf(MG), Boolean.TRUE);
                    } catch (Exception e2) {
                        e = e2;
                        ab.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                        z = booleanValue;
                        try {
                            bHA.tbi = System.currentTimeMillis();
                            bHA.tbg = new com.tencent.mm.compatible.b.k();
                            MG = com.tencent.mm.compatible.b.g.KK().KP();
                            booleanValue = com.tencent.mm.compatible.b.g.KK().KV();
                            ab.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", Boolean.valueOf(MG), Boolean.valueOf(booleanValue));
                            if (q.etd.eqm >= 0) {
                            }
                            bHA.mE(false);
                            bHA.a(R.raw.ipcall_phonering, 3500, true, i);
                            bHA.aFV = true;
                            AppMethodBeat.o(21668);
                            return;
                        } catch (Exception e3) {
                            ab.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e3.toString());
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    booleanValue = true;
                }
                if (z && !bHA.aFV) {
                    bHA.tbi = System.currentTimeMillis();
                    bHA.tbg = new com.tencent.mm.compatible.b.k();
                    MG = com.tencent.mm.compatible.b.g.KK().KP();
                    booleanValue = com.tencent.mm.compatible.b.g.KK().KV();
                    ab.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", Boolean.valueOf(MG), Boolean.valueOf(booleanValue));
                    if (q.etd.eqm >= 0) {
                        i = q.etd.eqm;
                    }
                    bHA.mE(false);
                    bHA.a(R.raw.ipcall_phonering, 3500, true, i);
                    bHA.aFV = true;
                    AppMethodBeat.o(21668);
                    return;
                }
                AppMethodBeat.o(21668);
                return;
            }
            bHA.q(R.raw.ipcall_phonering, 2, true);
            AppMethodBeat.o(21668);
        }
    };
    public boolean nvf;
    public com.tencent.mm.plugin.voip.ui.a nvg = new com.tencent.mm.plugin.voip.ui.a() {
        public final boolean bGV() {
            AppMethodBeat.i(21669);
            if (i.bHu().bHk()) {
                AppMethodBeat.o(21669);
                return true;
            }
            AppMethodBeat.o(21669);
            return false;
        }

        public final void a(Intent intent, e eVar) {
            AppMethodBeat.i(21670);
            if (i.bHu().bHn()) {
                int bGU = c.this.bGU();
                eVar.aca(String.format("%02d:%02d", new Object[]{Integer.valueOf(bGU / 60), Integer.valueOf(bGU % 60)}));
                AppMethodBeat.o(21670);
                return;
            }
            eVar.abZ(ah.getContext().getString(R.string.d3o));
            AppMethodBeat.o(21670);
        }
    };
    private long nvh = 0;

    public c() {
        AppMethodBeat.i(21672);
        AppMethodBeat.o(21672);
    }

    private void removeListener() {
        AppMethodBeat.i(21673);
        if (this.nva != null) {
            this.nva.listen(this.nvb, 0);
            this.nva = null;
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.nvc);
        AppMethodBeat.o(21673);
    }

    static {
        AppMethodBeat.i(21701);
        AppMethodBeat.o(21701);
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3) {
        AppMethodBeat.i(21674);
        if (i.bHu().bHk()) {
            ab.i("MicroMsg.IPCallManager", "startIPCall, already start!");
            AppMethodBeat.o(21674);
            return false;
        }
        ab.i("MicroMsg.IPCallManager", "startIPCall");
        i.bHq().nvE = this;
        i.bHr().nxC = this;
        i.bHu().mCurrentState = -1;
        removeListener();
        this.nva = (TelephonyManager) ah.getContext().getSystemService("phone");
        this.nva.listen(this.nvb, 32);
        com.tencent.mm.sdk.b.a.xxA.c(this.nvc);
        ab.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", str4, str5);
        k kVar = new k();
        kVar.field_phonenumber = str4;
        if (bo.isNullOrNil(str5)) {
            kVar.field_addressId = -1;
        } else {
            com.tencent.mm.plugin.ipcall.a.g.c OQ = i.bHw().OQ(str5);
            if (OQ == null || OQ.xDa == -1) {
                kVar.field_addressId = -1;
            } else {
                kVar.field_addressId = OQ.xDa;
            }
        }
        if (i != -1) {
            kVar.field_phoneType = i;
        } else {
            kVar.field_phoneType = -1;
        }
        kVar.field_calltime = bo.anU();
        kVar.field_status = 1;
        if (!i.bHx().b((com.tencent.mm.sdk.e.c) kVar)) {
            kVar = null;
        }
        this.nuY = kVar;
        fbD.postDelayed(this.nve, 1754);
        this.nuZ = false;
        com.tencent.mm.plugin.ipcall.a.c.b bHs = i.bHs();
        ab.d("MicroMsg.IPCallReportHelper", "reset");
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
        i.bHu().mCurrentState = -1;
        ab.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", str3, str4);
        g bHq = i.bHq();
        ab.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", str3, str4);
        bHq.cJn = false;
        bHq.nvO = false;
        bHq.nvz = 0;
        bHq.nvA = 0;
        bHq.nvB = 0;
        bHq.nvC = false;
        bHq.nvD = false;
        bHq.nvP = false;
        bHq.nvN = new com.tencent.mm.plugin.ipcall.a.a.c();
        bHq.nvN.nickname = str;
        bHq.nvN.nwV = str2;
        bHq.nvN.cOz = str5;
        bHq.nvN.nwW = str4;
        bHq.nvN.cMr = str3;
        bHq.nvN.nwx = (int) System.currentTimeMillis();
        bHq.nvN.nwy = i2;
        bHq.nvN.nwz = i3;
        bHq.nvN.nwY = i;
        bHq.nvF.a(bHq.nvN);
        bHq.nvK.a(bHq.nvN);
        ab.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", Integer.valueOf(bHq.nvN.nwx));
        i.bHu().xg(1);
        com.tencent.mm.plugin.ipcall.a.c.a bHr = i.bHr();
        if (bHr.nxB) {
            ab.d("MicroMsg.IPCallEngineManager", "already start engine");
        } else {
            bHr.bHM();
            ab.i("MicroMsg.IPCallEngineManager", "start engine");
            if (bHr.nxx.cKK()) {
                bHr.nxx.mx(false);
                bHr.nxx.reset();
            }
            bHr.nxx.sTY = 1;
            long currentTimeMillis = System.currentTimeMillis();
            int cKM = bHr.nxx.cKM();
            long currentTimeMillis2 = System.currentTimeMillis();
            ab.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", Integer.valueOf(cKM), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            if (bHr.nxx.field_capInfo != null && bHr.nxx.exchangeCabInfo(bHr.nxx.field_capInfo, bHr.nxx.field_capInfo.length) < 0) {
                ab.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
                i.bHs().nxN = 24;
            }
            if (cKM < 0) {
                ab.e("MicroMsg.IPCallEngineManager", "engine init failed!");
            }
            bHr.nxx.sTY = 1;
            bHr.nxB = true;
        }
        fbD.removeCallbacks(this.nvd);
        fbD.postDelayed(this.nvd, 60000);
        AppMethodBeat.o(21674);
        return true;
    }

    private boolean Y(int i, int i2, int i3) {
        AppMethodBeat.i(21675);
        com.tencent.mm.plugin.ipcall.a.a.c cVar = i.bHq().nvN;
        if (i.bHu().xg(i)) {
            int i4;
            com.tencent.mm.plugin.ipcall.a.b.a aVar;
            if (cVar != null) {
                ab.i("MicroMsg.IPCallManager", "finishIPCall inviteId:%d, roomId:%d, state:%d, errStatus:%d, pstnErrCode:%d", Integer.valueOf(cVar.nwx), Integer.valueOf(cVar.nwu), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
            ab.i("MicroMsg.IPCallManager", "closeDeviceEngine");
            p.cJR().cJT();
            p.cJR().a(null);
            com.tencent.mm.plugin.ipcall.a.c.b bHs = i.bHs();
            com.tencent.mm.plugin.ipcall.a.b.b bHt = i.bHt();
            if (bHt.nxg != null) {
                com.tencent.mm.plugin.ipcall.a.b.c cVar2 = bHt.nxg;
                if (cVar2.nxm != null) {
                    i4 = cVar2.nxm.cpq;
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 0;
            }
            if (bHs.nyb == 0) {
                bHs.nyb = i4;
            }
            bHs = i.bHs();
            bHt = i.bHt();
            if (bHt.nxf != null) {
                aVar = bHt.nxf;
                if (aVar.kzq != null) {
                    ab.d("MicroMsg.IPCallAudioPlayer", "AudioPlayer  mAudioPlayErrState:" + aVar.kzq.cIs());
                    i4 = aVar.kzq.cIs();
                } else {
                    i4 = 0;
                }
            } else {
                i4 = 0;
            }
            if (bHs.nyc == 0) {
                bHs.nyc = i4;
            }
            com.tencent.mm.compatible.b.g.a bHt2 = i.bHt();
            com.tencent.mm.plugin.ipcall.a.c.a bHr = i.bHr();
            i4 = 0;
            if (bHt2.nxf != null) {
                aVar = bHt2.nxf;
                if (aVar.kzq == null || !aVar.cFy) {
                    i4 = -1;
                } else {
                    i4 = aVar.kzq.cIt();
                }
            }
            if (i4 == -1) {
                i4 = 0;
            } else {
                i4 = (int) ((((float) aw.ZL().getStreamVolume(i4)) / ((float) aw.ZL().getStreamMaxVolume(i4))) * 100.0f);
            }
            bHr.nxx.sUz = i4;
            bHt2.gar.Mm();
            aVar = bHt2.nxf;
            if (aVar.cFy) {
                ab.i("MicroMsg.IPCallAudioPlayer", "stopPlay");
                synchronized (aVar.nxa) {
                    try {
                        d.post(new com.tencent.mm.plugin.ipcall.a.b.a.a(aVar.kzq), "IPCallAudioPlayer_stop");
                        aVar.cFy = false;
                        aVar.kzq = null;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(21675);
                        }
                    }
                }
            }
            bHt2.crP = null;
            bHt2.kzs.fa(ah.getContext());
            aw.ZL().KN();
            aw.ZL().b(bHt2);
            bHt2.nxk = null;
            bHt2.nxi = null;
            bHt = i.bHt();
            com.tencent.mm.plugin.ipcall.a.b.c cVar3 = bHt.nxg;
            if (cVar3.cFy) {
                ab.i("MicroMsg.IPCallRecorder", "stop record");
                synchronized (cVar3.nxn) {
                    try {
                        if (cVar3.nxm != null) {
                            d.post(new com.tencent.mm.plugin.ipcall.a.b.c.a(cVar3.nxm), "IPCallRecorder_stopRecord");
                            cVar3.nxm = null;
                            cVar3.cFy = false;
                            cVar3.eif = false;
                        }
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(21675);
                        }
                    }
                }
            }
            bHt.crP = null;
            com.tencent.mm.plugin.ipcall.a.c.a bHr2 = i.bHr();
            ab.i("MicroMsg.IPCallEngineManager", "close engine");
            bHr2.nxx.mx(true);
            com.tencent.mm.plugin.ipcall.a.c.b bHs2 = i.bHs();
            if (bo.isNullOrNil(bHs2.nxW) && bo.isNullOrNil(bHs2.nxV)) {
                Object obj;
                com.tencent.mm.plugin.ipcall.a.a.c cVar4 = i.bHq().nvN;
                v2protocal v2protocal = i.bHr().nxx;
                if (bHs2.nxL == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                v2protocal.getPstnChannelInfo(v2protocal.sVD, v2protocal.sVD.length, obj != null ? 1 : 0, cVar4.nwQ);
                ab.d("MicroMsg.Voip", "field_pstnChannelInfoLength: %d", Integer.valueOf(v2protocal.field_pstnChannelInfoLength));
                bHs2.nxW = new String(v2protocal.sVD, 0, v2protocal.field_pstnChannelInfoLength);
                v2protocal v2protocal2 = i.bHr().nxx;
                v2protocal2.getPstnEngineInfo(v2protocal2.sVE, v2protocal2.sVE.length);
                ab.d("MicroMsg.Voip", "field_pstnEngineInfoLength: %d", Integer.valueOf(v2protocal2.field_pstnEngineInfoLength));
                bHs2.nxV = new String(v2protocal2.sVE, 0, v2protocal2.field_pstnEngineInfoLength);
                bHs2.nxX = i.bHr().nxx.cKJ();
                ab.d("MicroMsg.IPCallReportHelper", "nativeChannelReportString: %s", bHs2.nxW);
                ab.d("MicroMsg.IPCallReportHelper", "nativeEngineReportString: %s", bHs2.nxV);
                ab.d("MicroMsg.IPCallReportHelper", "clientReportExString: %s", bHs2.nxX);
            }
            bHr2.nxx.reset();
            bHr2.bHM();
            i.bHA().stop();
            com.tencent.mm.plugin.voip.video.i bHA = i.bHA();
            i.bHt();
            boolean isSpeakerphoneOn = aw.ZL().eoY.isSpeakerphoneOn();
            bHA.mContext.getSharedPreferences(ah.doA(), 0).getBoolean("settings_shake", true);
            com.tencent.mm.compatible.b.g.KK().setSpeakerphoneOn(isSpeakerphoneOn);
            if (isSpeakerphoneOn) {
                com.tencent.mm.compatible.b.g.KK().setMode(0);
            } else {
                com.tencent.mm.compatible.b.g.KK().setMode(2);
            }
            ab.i("MicroMsg.RingPlayer", "playSound, shake: %s, isSpeakerOn: %s, type: %s", Boolean.FALSE, Boolean.valueOf(isSpeakerphoneOn), Integer.valueOf(2));
            bHA.tbj = System.currentTimeMillis();
            com.tencent.mm.compatible.b.k kVar = new com.tencent.mm.compatible.b.k();
            try {
                kVar.setDataSource(bHA.mContext, Uri.parse("android.resource://" + bHA.mContext.getPackageName() + "/2131231812"));
                kVar.setOnCompletionListener(new OnCompletionListener() {
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        AppMethodBeat.i(5098);
                        mediaPlayer.release();
                        if (System.currentTimeMillis() - i.this.tbj > 5000) {
                            i.this.tbh = 8;
                            com.tencent.mm.compatible.b.g.KK().setMode(0);
                        }
                        AppMethodBeat.o(5098);
                    }
                });
                kVar.setOnErrorListener(new OnErrorListener() {
                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        AppMethodBeat.i(5099);
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                            i.this.tbh = 5;
                            ab.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2));
                        }
                        AppMethodBeat.o(5099);
                        return false;
                    }
                });
                i4 = (com.tencent.mm.compatible.b.g.KK().KP() || !isSpeakerphoneOn) ? 0 : 2;
                kVar.setAudioStreamType(i4);
                kVar.prepare();
                kVar.setLooping(false);
                kVar.start();
                if (System.currentTimeMillis() - bHA.tbj > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    bHA.tbh = 7;
                }
            } catch (Throwable th3) {
                ab.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", th3);
                bHA.tbh = 6;
                kVar.stop();
                kVar.release();
            }
            fbD.removeCallbacks(this.nve);
            fbD.removeCallbacks(this.nvd);
            if (this.che != null) {
                this.che.stopTimer();
                this.che = null;
            }
            i.bHs().nxN = i3;
            com.tencent.mm.plugin.ipcall.a.c.b bHs3 = i.bHs();
            ab.d("MicroMsg.IPCallReportHelper", "markEndTalk");
            if (bHs3.nxU == 0 && bHs3.nxT != 0) {
                bHs3.nxU = System.currentTimeMillis();
                bHs3.nxM = (bHs3.nxU - bHs3.nxT) / 1000;
                ab.d("MicroMsg.IPCallReportHelper", "callTime: %d", Long.valueOf(bHs3.nxM));
            }
            k kVar2;
            if (i == 8) {
                i.bHq().bHo();
                i.bHs().bHO();
                kVar2 = this.nuY;
                if (kVar2 != null) {
                    ab.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", Long.valueOf(kVar2.xDa));
                    if (kVar2.xDa != -1) {
                        kVar2.field_status = 2;
                        i.bHx().a(kVar2);
                    }
                }
            } else if (i == 12) {
                i.bHq().bHo();
                i.bHs().bHO();
                if (i2 == 11) {
                    m.b(this.nuY);
                } else {
                    kVar2 = this.nuY;
                    if (kVar2 != null) {
                        ab.d("MicroMsg.IPCallRecordStorageLogic", "recordCallFailed, localId: %d", Long.valueOf(kVar2.xDa));
                        if (kVar2.xDa != -1) {
                            kVar2.field_status = 6;
                            i.bHx().a(kVar2);
                        }
                    }
                }
            } else if (i == 9) {
                i.bHq().xi(1);
                i.bHs().bHN();
                m.a(this.nuY, i.bHs().nxM);
            } else if (i == 10) {
                i.bHq().xi(1);
                bHs3 = i.bHs();
                ab.i("MicroMsg.IPCallReportHelper", "otherSideUserShutdown");
                bHs3.nxG = 1;
                kVar2 = this.nuY;
                long j = i.bHs().nxM;
                if (kVar2 != null) {
                    ab.d("MicroMsg.IPCallRecordStorageLogic", "recordOthersideShutdownCall, localId: %d, talkTime: %d", Long.valueOf(kVar2.xDa), Long.valueOf(j));
                    if (kVar2.xDa != -1) {
                        kVar2.field_status = 5;
                        kVar2.field_duration = j;
                        i.bHx().a(kVar2);
                    }
                }
            } else if (i == 11) {
                if (i2 == 5) {
                    i.bHq().xi(3);
                } else if (i2 == 11) {
                    i.bHq().xi(1);
                } else {
                    i.bHq().xi(2);
                }
                i.bHs().bHN();
                if (i2 == 11) {
                    m.b(this.nuY);
                } else {
                    m.a(this.nuY, i.bHs().nxM);
                }
            }
            if (i.bHq().cJn) {
                if (this.nvf || i.bHq().nvN.nwu == 0 || i.bHq().nvN.nww == 0) {
                    ab.e("MicroMsg.IPCallManager", "roomId = 0,ignore feedback");
                } else {
                    Context context = ah.getContext();
                    int i5 = i.bHq().nvN.nwu;
                    long j2 = i.bHq().nvN.nww;
                    ab.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog");
                    if (d.bGW()) {
                        int i6 = com.tencent.mm.m.g.Nu().getInt("WCOMaxTimesForShowFeedback", 0);
                        aw.ZK();
                        int intValue = ((Integer) com.tencent.mm.model.c.Ry().get(ac.a.USERFINO_IPCALL_SHOW_FEEDBACK_TIME_COUNT_INT, Integer.valueOf(0))).intValue();
                        aw.ZK();
                        long longValue = ((Long) com.tencent.mm.model.c.Ry().get(ac.a.USERFINO_IPCALL_SHOW_FEEDBACK_LAST_TIME_LONG, Long.valueOf(0))).longValue();
                        long anT = bo.anT();
                        if (anT - longValue > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                            i4 = 0;
                            ab.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reset time");
                        } else {
                            i4 = intValue;
                        }
                        if (i4 >= i6) {
                            ab.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reach max time".concat(String.valueOf(i6)));
                        } else if (anT - longValue < 1800) {
                            ab.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog not reach INTERVAL_TIMES_TRY_SHOW_WCO_FEEDBACK_MAIN");
                        } else {
                            i4++;
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_SHOW_FEEDBACK_TIME_COUNT_INT, Integer.valueOf(i4));
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(ac.a.USERFINO_IPCALL_SHOW_FEEDBACK_LAST_TIME_LONG, Long.valueOf(anT));
                            Intent intent = new Intent();
                            intent.putExtra("IPCallFeedbackDialogUI_KRoomId", i5);
                            intent.putExtra("IPCallFeedbackDialogUI_KCallseq", j2);
                            com.tencent.mm.bp.d.b(context, "ipcall", ".ui.IPCallFeedbackDialogUI", intent);
                        }
                    }
                }
            }
            i.bHq().nvE = null;
            i.bHr().nxC = null;
            i.bHu().mCurrentState = -1;
            bGT();
            removeListener();
            AppMethodBeat.o(21675);
            return true;
        }
        ab.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (cVar != null) {
            ab.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now inviteId:%d, roomId:%d, state:%d,errStatus:%d, pstnErrCode:%d", Integer.valueOf(cVar.nwx), Integer.valueOf(cVar.nwu), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
        AppMethodBeat.o(21675);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean OL(String str) {
        AppMethodBeat.i(21676);
        ab.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", str);
        if (i.bHu().bHn()) {
            if (!bo.isNullOrNil(str) && str.length() == 1) {
                int i;
                if (!bo.isNullOrNil(str) && str.length() == 1) {
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
                            com.tencent.mm.plugin.ipcall.a.c.a bHr = i.bHr();
                            ab.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", Integer.valueOf(i));
                            com.tencent.mm.plugin.ipcall.a.c.b bHs = i.bHs();
                            bHs.nye++;
                            ab.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", Integer.valueOf(bHs.nye));
                            if (bHr.nxx.SendDTMF(i) < 0) {
                                ab.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", Integer.valueOf(bHr.nxx.SendDTMF(i)));
                            }
                            AppMethodBeat.o(21676);
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
            AppMethodBeat.o(21676);
            return false;
        }
        ab.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
        AppMethodBeat.o(21676);
        return false;
    }

    public final void bGJ() {
        AppMethodBeat.i(21677);
        ab.i("MicroMsg.IPCallManager", "onInviteSuccess");
        if (i.bHu().xg(3)) {
            com.tencent.mm.plugin.ipcall.a.c.b bHs = i.bHs();
            ab.d("MicroMsg.IPCallReportHelper", "markStartInvite");
            if (bHs.nxR == 0) {
                bHs.nxR = System.currentTimeMillis();
            }
            com.tencent.mm.plugin.ipcall.a.a.c cVar = i.bHq().nvN;
            com.tencent.mm.plugin.ipcall.a.c.b bHs2 = i.bHs();
            int i = cVar.nwx;
            String str = cVar.cMr;
            String str2 = cVar.nwW;
            int i2 = cVar.nwu;
            long j = cVar.nwv;
            long j2 = cVar.nww;
            bHs2.nwx = i;
            bHs2.nxQ = str;
            bHs2.gyD = str2;
            bHs2.nwu = i2;
            bHs2.nwv = j;
            bHs2.nxO = j2;
            if (this.nuX != null) {
                this.nuX.bGJ();
            }
            AppMethodBeat.o(21677);
            return;
        }
        AppMethodBeat.o(21677);
    }

    public final void A(String str, String str2, int i) {
        AppMethodBeat.i(21678);
        ab.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (eo(2, 0)) {
            d(2, str, str2, i);
        }
        AppMethodBeat.o(21678);
    }

    public final void bGK() {
        AppMethodBeat.i(21679);
        ab.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (i.bHu().xg(4)) {
            com.tencent.mm.plugin.ipcall.a.c.b bHs = i.bHs();
            ab.d("MicroMsg.IPCallReportHelper", "markStartRing");
            if (bHs.nxS == 0) {
                bHs.nxS = System.currentTimeMillis();
                bHs.nxJ = bHs.nxS - bHs.nxR;
                ab.d("MicroMsg.IPCallReportHelper", "ringTime: %d", Long.valueOf(bHs.nxJ));
            }
            i.bHr().bHL();
            bHs = i.bHs();
            ab.i("MicroMsg.IPCallReportHelper", "startRing");
            bHs.nxE = 1;
            if (this.nuX != null) {
                this.nuX.bGK();
            }
            AppMethodBeat.o(21679);
            return;
        }
        AppMethodBeat.o(21679);
    }

    public final void bGL() {
        AppMethodBeat.i(21680);
        ab.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (i.bHu().xg(5)) {
            com.tencent.mm.plugin.ipcall.a.c.b bHs = i.bHs();
            ab.d("MicroMsg.IPCallReportHelper", "markUserAccept");
            if (bHs.nvh == 0) {
                bHs.nvh = System.currentTimeMillis();
                bHs.nxK = bHs.nvh - bHs.nxR;
                ab.d("MicroMsg.IPCallReportHelper", "answerTime: %d", Long.valueOf(bHs.nxK));
            }
            i.bHr().bHL();
            bHs = i.bHs();
            ab.i("MicroMsg.IPCallReportHelper", "userAccept");
            bHs.nxF = 1;
            fbD.removeCallbacks(this.nvd);
            i.bHA().stop();
            fbD.removeCallbacks(this.nve);
            i.bHt().nxg.aDm();
            if (i.bHr().nxA && !this.nuZ) {
                i.bHs().bHP();
                i.bHs().bHS();
                this.nuZ = true;
                this.nvh = bo.anT();
                arh();
                i.bHr().bHK();
                if (this.nuX != null) {
                    this.nuX.bGX();
                }
                i.bHs().bHR();
                p.cJR().cJS();
                p.cJR().a(this);
            }
            AppMethodBeat.o(21680);
            return;
        }
        AppMethodBeat.o(21680);
    }

    public final void d(int i, String str, String str2, int i2) {
        AppMethodBeat.i(21681);
        if (this.nuX != null) {
            this.nuX.d(i, str, str2, i2);
            AppMethodBeat.o(21681);
            return;
        }
        Toast.makeText(ah.getContext(), str2, 1).show();
        AppMethodBeat.o(21681);
    }

    public final void cn(String str, int i) {
        AppMethodBeat.i(21682);
        ab.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (eo(3, 5)) {
            d(3, null, str, i);
        }
        AppMethodBeat.o(21682);
    }

    public final void co(String str, int i) {
        AppMethodBeat.i(21683);
        ab.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (eo(1, 4)) {
            d(1, null, str, i);
        }
        AppMethodBeat.o(21683);
    }

    public final void bGM() {
        AppMethodBeat.i(21684);
        ab.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (Y(10, 0, 32)) {
            if (this.nuX != null) {
                this.nuX.bGY();
                AppMethodBeat.o(21684);
                return;
            }
            Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.ci6), 1).show();
        }
        AppMethodBeat.o(21684);
    }

    public final void cp(String str, int i) {
        AppMethodBeat.i(21685);
        ab.i("MicroMsg.IPCallManager", "onSyncFailed");
        if (eo(7, 35)) {
            d(7, null, str, i);
        }
        AppMethodBeat.o(21685);
    }

    public final void bGN() {
        AppMethodBeat.i(21686);
        ab.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
        if (eo(7, 29)) {
            d(7, null, ah.getContext().getString(R.string.abp), 1);
        }
        AppMethodBeat.o(21686);
    }

    public final void B(String str, String str2, int i) {
        AppMethodBeat.i(21687);
        ab.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (eo(8, 9)) {
            d(8, str, str2, i);
        }
        AppMethodBeat.o(21687);
    }

    public final void C(String str, String str2, int i) {
        AppMethodBeat.i(21688);
        ab.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (eo(10, 0)) {
            d(10, str, str2, i);
        }
        AppMethodBeat.o(21688);
    }

    public final void D(String str, String str2, int i) {
        AppMethodBeat.i(21689);
        ab.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (eo(11, 0)) {
            d(11, str, str2, i);
        }
        AppMethodBeat.o(21689);
    }

    public final void bGO() {
        AppMethodBeat.i(21690);
        do {
            ab.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        } while (eo(12, 0));
        AppMethodBeat.o(21690);
    }

    public final void bGP() {
        AppMethodBeat.i(21691);
        ab.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (eo(6, 0)) {
            d(6, null, ah.getContext().getString(R.string.abv), 1);
        }
        AppMethodBeat.o(21691);
    }

    public final void bGQ() {
        AppMethodBeat.i(21692);
        ab.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        i.bHA().stop();
        fbD.removeCallbacks(this.nve);
        if (i.bHu().bHl()) {
            com.tencent.mm.compatible.b.g.a bHt = i.bHt();
            bHt.kzs.a(ah.getContext(), bHt);
            aw.ZL().a(bHt);
            aw.ZL().KM();
            bHt.kzt = aw.ZL().KV();
            bHt.kzu = aw.ZL().KP();
            ab.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", Boolean.valueOf(bHt.kzt), Boolean.valueOf(bHt.kzu));
            bHt.gar.requestFocus();
            com.tencent.mm.plugin.ipcall.a.b.a aVar = bHt.nxf;
            if (aVar.cFy) {
                ab.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
            } else {
                ab.i("MicroMsg.IPCallAudioPlayer", "startPlay");
                if (aVar.kzq == null) {
                    aVar.kzq = new com.tencent.mm.plugin.voip.model.c();
                    aVar.kzq.G(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
                }
                aVar.nxb = aVar.kzq.x(ah.getContext(), false);
                aVar.kzq.sNt = new com.tencent.mm.plugin.voip.model.b() {
                    public final int N(byte[] bArr, int i) {
                        AppMethodBeat.i(21798);
                        if (a.this.cFy) {
                            if (i.bHr().nxx.playCallback(bArr, i) < 0) {
                                ab.e("MicroMsg.IPCallAudioPlayer", "playCallback, error: %d", Integer.valueOf(i.bHr().nxx.playCallback(bArr, i)));
                                AppMethodBeat.o(21798);
                                return -1;
                            }
                            AppMethodBeat.o(21798);
                            return 0;
                        }
                        AppMethodBeat.o(21798);
                        return -1;
                    }
                };
                if (aVar.kzq.cIp() <= 0) {
                    i.bHs().bHQ();
                }
                aVar.io(aVar.nxc);
                aVar.cFy = true;
            }
            if (!(!bHt.kzt || bHt.kzu || bHt.nxk == null)) {
                bHt.nxk.ir(true);
            }
            if (!(!bHt.kzu || bHt.kzt || bHt.nxk == null)) {
                bHt.nxk.is(true);
            }
        }
        i.bHs().bHP();
        i.bHt().nxg.aDm();
        if (i.bHu().bHn() && !this.nuZ) {
            i.bHs().bHS();
            i.bHr().bHK();
            this.nuZ = true;
            this.nvh = bo.anT();
            arh();
            if (this.nuX != null) {
                this.nuX.bGX();
            }
            k kVar = this.nuY;
            if (kVar != null) {
                ab.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", Long.valueOf(kVar.xDa));
                if (kVar.xDa != -1) {
                    kVar.field_status = 3;
                    i.bHx().a(kVar);
                }
            }
            i.bHs().bHR();
            p.cJR().cJS();
            p.cJR().a(this);
        }
        AppMethodBeat.o(21692);
    }

    public final void xe(int i) {
        AppMethodBeat.i(21693);
        ab.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", f.stateToString(i.bHu().mCurrentState));
        if (i.bHr().nxA) {
            ab.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
            if (eo(5, i)) {
                d(5, null, ah.getContext().getString(R.string.abp), 1);
                AppMethodBeat.o(21693);
                return;
            }
        }
        ab.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
        if (eo(4, i)) {
            d(4, null, ah.getContext().getString(R.string.abp), 1);
        }
        AppMethodBeat.o(21693);
    }

    public final boolean eo(int i, int i2) {
        AppMethodBeat.i(21694);
        boolean Y;
        if (i.bHu().bHn()) {
            if (i == 0) {
                Y = Y(9, i, i2);
                AppMethodBeat.o(21694);
                return Y;
            }
            Y = Y(11, i, i2);
            AppMethodBeat.o(21694);
            return Y;
        } else if (i == 0) {
            Y = Y(8, i, i2);
            AppMethodBeat.o(21694);
            return Y;
        } else {
            Y = Y(12, i, i2);
            AppMethodBeat.o(21694);
            return Y;
        }
    }

    public final void ig(boolean z) {
        AppMethodBeat.i(21695);
        if (i.bHu().mCurrentState != 5) {
            ab.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", Integer.valueOf(i.bHu().mCurrentState));
            AppMethodBeat.o(21695);
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b bHt = i.bHt();
        ab.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
        if (bHt.nxi != null) {
            j jVar = bHt.nxi;
            if (jVar.nGB != null) {
                jVar.nGB.setVisibility(0);
            }
            if (jVar.nGC != null) {
                jVar.nGC.setVisibility(0);
            }
        }
        if (!aw.ZL().eoY.isSpeakerphoneOn()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - bHt.nxl > 30000) {
                bHt.nxl = currentTimeMillis;
                com.tencent.mm.plugin.voip.b.cIj().sSP.cKp();
            }
        }
        AppMethodBeat.o(21695);
    }

    public final void bGR() {
        AppMethodBeat.i(21696);
        if (i.bHu().mCurrentState != 5) {
            ab.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", Integer.valueOf(i.bHu().mCurrentState));
            AppMethodBeat.o(21696);
            return;
        }
        com.tencent.mm.plugin.ipcall.a.b.b bHt = i.bHt();
        ab.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
        if (bHt.nxi != null) {
            bHt.nxi.bIK();
        }
        AppMethodBeat.o(21696);
    }

    public final void bGS() {
        CharSequence string;
        AppMethodBeat.i(21697);
        if (i.bHu().bHn()) {
            Context context = ah.getContext();
            Object[] objArr = new Object[1];
            objArr[0] = String.format("%02d:%02d", new Object[]{Long.valueOf(bo.fp(this.nvh) / 60), Long.valueOf(bo.fp(this.nvh) % 60)});
            string = context.getString(R.string.ch2, objArr);
        } else {
            string = ah.getContext().getString(R.string.ch1);
        }
        Intent intent = new Intent(ah.getContext(), IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 42, intent, 134217728);
        int i = R.drawable.bdo;
        if (com.tencent.mm.compatible.util.d.fP(19)) {
            i = R.drawable.bdn;
        }
        android.support.v4.app.v.c e = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id").g(ah.getContext().getString(R.string.ch1)).j(System.currentTimeMillis()).d(ah.getContext().getString(R.string.cgr)).e(string);
        e.EI = activity;
        Notification build = e.build();
        build.icon = i;
        build.flags |= 32;
        aw.getNotification().a(42, build, false);
        if (i.bHu().bHn()) {
            com.tencent.mm.plugin.voip.b.cIk().Dq(bGU());
            AppMethodBeat.o(21697);
            return;
        }
        com.tencent.mm.plugin.voip.b.cIk().abZ(ah.getContext().getString(R.string.d3o));
        AppMethodBeat.o(21697);
    }

    public final void bGT() {
        AppMethodBeat.i(21698);
        synchronized (this.meM) {
            try {
                this.nvf = false;
                com.tencent.mm.plugin.voip.b.cIk().dismiss();
                ((NotificationManager) ah.getContext().getSystemService("notification")).cancel(42);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(21698);
            }
        }
    }

    public final int bGU() {
        AppMethodBeat.i(21699);
        int fp = (int) bo.fp(this.nvh);
        if (fp > 0) {
            AppMethodBeat.o(21699);
            return fp;
        }
        AppMethodBeat.o(21699);
        return 0;
    }

    private void arh() {
        AppMethodBeat.i(21700);
        ab.i("MicroMsg.IPCallManager", "startTimeCount");
        if (this.che != null) {
            this.che.stopTimer();
            AppMethodBeat.o(21700);
            return;
        }
        if (this.che == null) {
            this.che = new ap(Looper.getMainLooper(), new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(21671);
                    c.this.bGS();
                    if (i.bHu().bHn() && c.this.nuX != null) {
                        c.this.nuX.bHa();
                    }
                    AppMethodBeat.o(21671);
                    return true;
                }
            }, true);
        }
        this.che.ae(1000, 1000);
        AppMethodBeat.o(21700);
    }
}
