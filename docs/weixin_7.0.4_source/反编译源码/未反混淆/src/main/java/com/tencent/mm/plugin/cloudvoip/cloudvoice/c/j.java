package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.VError;
import java.util.ArrayList;

public enum j {
    ;
    
    private String hRT;
    private final al kAa;
    d kAb;
    private a kAc;
    private String kAd;
    private a<a> kAe;
    private a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>> kAf;
    private a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>> kAg;
    private a kAh;
    private a kAi;
    private a kAj;
    private a kAk;
    private a kAl;
    private a kAm;
    private a kAn;
    private a kAo;
    private boolean kAp;
    private boolean kAq;
    private a<String> kAr;
    public long kAs;
    private PhoneStateListener kAt;
    private boolean kAu;
    private boolean kAv;
    private boolean kAw;
    private final int kAx;
    public Runnable kAy;
    private final l kzX;
    private final f kzY;
    private final c kzZ;
    private final e kzd;
    private boolean mIsInit;

    public enum a {
        public static final a kBe = null;
        public static final a kBf = null;
        public static final a kBg = null;
        public static final a kBh = null;
        public static final a kBi = null;
        public static final a kBj = null;
        public static final a kBk = null;
        private static final /* synthetic */ a[] kBl = null;
        public final int bTx;

        public static a valueOf(String str) {
            AppMethodBeat.i(135547);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(135547);
            return aVar;
        }

        public static a[] values() {
            AppMethodBeat.i(135546);
            a[] aVarArr = (a[]) kBl.clone();
            AppMethodBeat.o(135546);
            return aVarArr;
        }

        static {
            AppMethodBeat.i(135548);
            kBe = new a("ReasonInterrupted", 0, 0);
            kBf = new a("ReasonManual", 1, 1);
            kBg = new a("ReasonDevice", 2, 2);
            kBh = new a("ReasonInCommingCall", 3, 3);
            kBi = new a("ReasonSessionUpdateFailed", 4, 4);
            kBj = new a("ReasonWeappEnterBackground", 5, 5);
            kBk = new a("ReasonUnknown", 6, 100);
            kBl = new a[]{kBe, kBf, kBg, kBh, kBi, kBj, kBk};
            AppMethodBeat.o(135548);
        }

        private a(String str, int i, int i2) {
            this.bTx = i2;
        }
    }

    static class b implements i<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(135549);
            Bundle bundle = new Bundle();
            bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, g.RP().Rz().dur());
            AppMethodBeat.o(135549);
            return bundle;
        }
    }

    enum d {
        public static final d kBm = null;
        public static final d kBn = null;
        public static final d kBo = null;
        private static final /* synthetic */ d[] kBp = null;

        private d(String str, int i) {
        }

        public static d valueOf(String str) {
            AppMethodBeat.i(135552);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(135552);
            return dVar;
        }

        public static d[] values() {
            AppMethodBeat.i(135551);
            d[] dVarArr = (d[]) kBp.clone();
            AppMethodBeat.o(135551);
            return dVarArr;
        }

        static {
            AppMethodBeat.i(135553);
            kBm = new d("NotInRoom", 0);
            kBn = new d("SdkInRoom", 1);
            kBo = new d("InRoom", 2);
            kBp = new d[]{kBm, kBn, kBo};
            AppMethodBeat.o(135553);
        }
    }

    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String hxh;
        final /* synthetic */ String kAA;
        final /* synthetic */ String kAB;
        final /* synthetic */ String kAC;
        final /* synthetic */ int kAD;
        final /* synthetic */ String kAE;
        final /* synthetic */ a kAF;
        final /* synthetic */ a kAG;
        final /* synthetic */ a kAH;
        final /* synthetic */ a kAI;

        public AnonymousClass1(String str, String str2, String str3, String str4, int i, String str5, a aVar, a aVar2, a aVar3, a aVar4) {
            this.hxh = str;
            this.kAA = str2;
            this.kAB = str3;
            this.kAC = str4;
            this.kAD = i;
            this.kAE = str5;
            this.kAF = aVar;
            this.kAG = aVar2;
            this.kAH = aVar3;
            this.kAI = aVar4;
        }

        public final void run() {
            AppMethodBeat.i(135509);
            j.a(j.this, this.hxh, this.kAA, this.kAB, this.kAC, this.kAD, this.kAE, this.kAF, this.kAG, this.kAH, this.kAI);
            AppMethodBeat.o(135509);
        }
    }

    static class c implements i<Bundle, Bundle> {
        private c() {
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(135550);
            Bundle bundle = new Bundle();
            boolean z = com.tencent.mm.r.a.Oo() || com.tencent.mm.plugin.voip.a.d.cLw() || com.tencent.mm.plugin.voip.a.d.cLx() || com.tencent.mm.plugin.voip.a.d.cLy();
            bundle.putBoolean("is_in_voip", z);
            AppMethodBeat.o(135550);
            return bundle;
        }
    }

    static {
        AppMethodBeat.o(135586);
    }

    private j(String str) {
        AppMethodBeat.i(135556);
        this.kAs = -1;
        this.kAt = new PhoneStateListener() {
            public final void onCallStateChanged(int i, String str) {
                AppMethodBeat.i(135528);
                super.onCallStateChanged(i, str);
                switch (i) {
                    case 1:
                        j.this.R(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(135527);
                                ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                                j.a(j.this, a.kBh);
                                AppMethodBeat.o(135527);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(135528);
            }
        };
        this.kAu = false;
        this.kAv = false;
        this.kAw = false;
        this.kAx = -9999;
        this.kAy = new Runnable() {
            public final void run() {
                AppMethodBeat.i(135523);
                if (j.this.kAb == d.kBm && !j.this.kAp) {
                    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", Long.valueOf(180000));
                    j.r(j.this);
                }
                AppMethodBeat.o(135523);
            }
        };
        this.kzX = new l();
        this.kzY = new f();
        this.kzd = new e();
        this.kzZ = new c(this.kzd);
        this.kAa = new al("openvoice_voip_worker");
        this.kAb = d.kBm;
        this.hRT = null;
        Bundle bundle = (Bundle) f.a("com.tencent.mm", null, b.class);
        if (bundle != null) {
            ab.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", bundle.getString(DeviceRequestsHelper.DEVICE_INFO_PARAM, ""));
            q.ku(r0);
        } else {
            ab.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
        }
        this.kAp = false;
        this.mIsInit = false;
        this.kAq = false;
        this.kAr = null;
        AppMethodBeat.o(135556);
    }

    private void a(a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>> aVar, int i, int i2, String str) {
        AppMethodBeat.i(135557);
        this.kAp = false;
        if (i == 0 && i2 == 0) {
            this.kAb = d.kBo;
        }
        synchronized (this.kzY) {
            try {
                this.kzY.b(1, this.kAl);
                this.kzY.b(2, this.kAm);
                this.kzY.b(4, this.kAn);
                this.kzY.b(5, this.kAo);
                this.kAl = null;
                this.kAm = null;
                this.kAn = null;
                this.kAo = null;
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(135557);
                }
            }
        }
        ArrayList arrayList = this.kzd.kzy;
        if (aVar != null) {
            aVar.a(i, i2, str, arrayList);
        }
        AppMethodBeat.o(135557);
    }

    private int HY(String str) {
        AppMethodBeat.i(135558);
        int a = g.a(this.kAd, this.hRT, str, this.kzY.fT(true));
        this.kAk = new a<String, String>() {
            public final boolean bgp() {
                return true;
            }

            public final /* synthetic */ Object i(int i, Object obj) {
                AppMethodBeat.i(135533);
                ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: session key expired!! reset session key");
                j.this.R(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(135532);
                        if (bo.isNullOrNil(j.this.hRT) || j.this.kAb == d.kBm) {
                            ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room now");
                            AppMethodBeat.o(135532);
                            return;
                        }
                        j.this.kzX.reset(j.this.hRT);
                        j.this.kzX.a(j.this.hRT, new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.l.a() {
                            public final void a(int i, int i2, String str, k kVar, boolean z) {
                                AppMethodBeat.i(135531);
                                if (i == 0 && i2 == 0 && kVar != null && kVar.isValid()) {
                                    g.HX(kVar.kBq);
                                    AppMethodBeat.o(135531);
                                    return;
                                }
                                ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: refresh session key error!");
                                j.a(j.this, a.kBi);
                                AppMethodBeat.o(135531);
                            }
                        });
                        AppMethodBeat.o(135532);
                    }
                });
                String str = "";
                AppMethodBeat.o(135533);
                return str;
            }

            public final /* bridge */ /* synthetic */ byte[] bP(Object obj) {
                return new byte[0];
            }

            public final /* synthetic */ Object az(byte[] bArr) {
                AppMethodBeat.i(135534);
                String str = new String(bArr);
                AppMethodBeat.o(135534);
                return str;
            }
        };
        this.kzY.a(8, this.kAk);
        AppMethodBeat.o(135558);
        return a;
    }

    private void bgs() {
        this.kAu = false;
        this.kAv = false;
        this.kAw = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>> aVar) {
        int i = 1;
        AppMethodBeat.i(135559);
        ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", Boolean.valueOf(this.kAu), Boolean.valueOf(this.kAv), Boolean.valueOf(this.kAw));
        if (this.kAu && this.kAw && this.kAv) {
            int b;
            if (this.kAq) {
                ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
                a(aVar, -10086, -9, "interrupted because already cancelled or entered background");
                b = b(this.kAc);
                if (this.kAr != null) {
                    if (b == 0) {
                        this.kAr.a(0, 0, "ok", "");
                    } else {
                        this.kAr.a(-10086, -17, "exit failed", "");
                    }
                }
                this.kAq = false;
                this.kAr = null;
                AppMethodBeat.o(135559);
                return;
            }
            boolean z;
            TelephonyManager telephonyManager = (TelephonyManager) ah.getContext().getSystemService("phone");
            Bundle bundle = (Bundle) f.a("com.tencent.mm", null, c.class);
            if (bundle != null) {
                z = bundle.getBoolean("is_in_voip");
            } else {
                z = false;
            }
            if (z || telephonyManager.getCallState() == 2 || telephonyManager.getCallState() == 1) {
                b = 1;
            } else {
                b = 0;
            }
            if (b != 0) {
                b((a) aVar);
                AppMethodBeat.o(135559);
                return;
            }
            int cIs;
            c cVar = this.kzZ;
            if (cVar.kzf != 2) {
                ab.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
                b = 0;
            } else if (cVar.kza.a(new com.tencent.mm.plugin.voip.model.b() {
                public final int N(byte[] bArr, int i) {
                    AppMethodBeat.i(135469);
                    if (c.this.kzf != 2) {
                        AppMethodBeat.o(135469);
                        return -1;
                    }
                    j jVar = j.kzW;
                    int P = j.P(bArr, i);
                    if (c.this.kzm) {
                        AppMethodBeat.o(135469);
                        return -10086;
                    } else if (P < 0) {
                        AppMethodBeat.o(135469);
                        return -1;
                    } else {
                        AppMethodBeat.o(135469);
                        return 0;
                    }
                }
            }, cVar.mSampleRate, cVar.mChannels, cVar.kzn) <= 0) {
                cVar.kzj = 1;
                b = 0;
            } else {
                b = 1;
            }
            boolean EL = this.kzZ.EL();
            if (b != 0 && EL) {
                i = 0;
            }
            i.kzN = i;
            if (b == 0) {
                d dVar = this.kzZ.kza;
                if (dVar.kzq != null) {
                    cIs = dVar.kzq.cIs();
                    i.kzP = cIs;
                    if (EL) {
                        cIs = this.kzZ.kzb.cpq;
                    } else {
                        cIs = 0;
                    }
                    i.kzO = cIs;
                    if (b == 0 && EL) {
                        a(aVar, 0, 0, "ok");
                        AppMethodBeat.o(135559);
                        return;
                    }
                    b((a) aVar);
                }
            }
            cIs = 0;
            i.kzP = cIs;
            if (EL) {
            }
            i.kzO = cIs;
            if (b == 0) {
            }
            b((a) aVar);
        }
        AppMethodBeat.o(135559);
    }

    private void b(a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>> aVar) {
        AppMethodBeat.i(135560);
        a(aVar, -10086, -7, "start audio device failed");
        b(a.kBg);
        AppMethodBeat.o(135560);
    }

    private void bgt() {
        AppMethodBeat.i(135561);
        this.kzd.kzy.clear();
        e eVar = this.kzd;
        synchronized (eVar.kzA) {
            try {
                eVar.kzA.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(135561);
            }
        }
        if (eVar.kzB != null) {
            eVar.kzB.cancel();
        }
        c cVar = this.kzZ;
        if (cVar.kza != null) {
            d dVar = cVar.kza;
            synchronized (dVar.kzr) {
                try {
                    ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "stopPlay, isStart: %s %s", Boolean.valueOf(dVar.cFy), Integer.valueOf(dVar.hashCode()));
                    if (dVar.cFy) {
                        com.tencent.mm.plugin.voip.model.c cVar2 = dVar.kzq;
                        if (cVar2 != null) {
                            dVar.kzw.evE = SystemClock.elapsedRealtime();
                            cVar2.cIr();
                            ab.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "stopPlaying cost: " + dVar.kzw.Mr());
                            cVar2.cIo();
                            dVar.cFy = false;
                            dVar.kzq = null;
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(135561);
                    }
                }
            }
        }
        cVar.kzm = false;
        if (cVar.kzb != null) {
            cVar.kzb.EB();
            cVar.kzb = null;
            ab.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "finish pauseRecord");
        }
        cVar.kzf = c.kze;
        com.tencent.mm.compatible.b.g.a aVar = cVar.kza;
        com.tencent.mm.compatible.b.g.KK().La();
        com.tencent.mm.compatible.b.g.KK().setMode(0);
        aVar.kzs.fa(ah.getContext());
        com.tencent.mm.compatible.b.g.KK().KN();
        com.tencent.mm.compatible.b.g.KK().b(aVar);
        aVar.gar.Mm();
        this.kAe = null;
        this.kAf = null;
        this.kAg = null;
        synchronized (this.kzY) {
            try {
                this.kzY.b(6, this.kAh);
                this.kzY.b(7, this.kAi);
                this.kzY.b(3, this.kAj);
                this.kzY.b(8, this.kAk);
                this.kAh = null;
                this.kAi = null;
                this.kAj = null;
                this.kAk = null;
            } catch (Throwable th2) {
                while (true) {
                    AppMethodBeat.o(135561);
                }
            }
        }
    }

    public final void R(Runnable runnable) {
        AppMethodBeat.i(135562);
        if (Thread.currentThread() == this.kAa.oAl.getLooper().getThread()) {
            runnable.run();
            AppMethodBeat.o(135562);
            return;
        }
        this.kAa.aa(runnable);
        AppMethodBeat.o(135562);
    }

    private void S(Runnable runnable) {
        AppMethodBeat.i(135563);
        this.kAa.m(runnable, 180000);
        AppMethodBeat.o(135563);
    }

    public final void a(final a<String> aVar, final a aVar2) {
        AppMethodBeat.i(135564);
        ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
        R(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135522);
                int a = j.a(j.this, aVar2);
                if (a == -9999) {
                    ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: pending exit. waiting for next time");
                    j.this.kAr = aVar;
                    AppMethodBeat.o(135522);
                    return;
                }
                if (aVar != null) {
                    if (a == 0) {
                        aVar.a(0, 0, "", "");
                        AppMethodBeat.o(135522);
                        return;
                    }
                    aVar.a(-10086, -17, "exit failed", "");
                }
                AppMethodBeat.o(135522);
            }
        });
        AppMethodBeat.o(135564);
    }

    private static int a(a aVar) {
        AppMethodBeat.i(135565);
        switch (aVar) {
            case kBi:
            case kBk:
            case kBe:
                AppMethodBeat.o(135565);
                return 0;
            case kBf:
                AppMethodBeat.o(135565);
                return 1;
            case kBh:
                AppMethodBeat.o(135565);
                return 6;
            case kBg:
                AppMethodBeat.o(135565);
                return 8;
            case kBj:
                AppMethodBeat.o(135565);
                return 7;
            default:
                AppMethodBeat.o(135565);
                return 0;
        }
    }

    private int b(a aVar) {
        AppMethodBeat.i(135566);
        ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", aVar);
        this.kAc = aVar;
        if (this.kAp) {
            ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
            this.kAq = true;
            AppMethodBeat.o(135566);
            return -9999;
        } else if (this.kAb == d.kBm) {
            ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
            AppMethodBeat.o(135566);
            return 0;
        } else {
            int tB = g.tB(a(aVar));
            bgu();
            AppMethodBeat.o(135566);
            return tB;
        }
    }

    private void bgu() {
        AppMethodBeat.i(135567);
        S(this.kAy);
        AppMethodBeat.o(135567);
    }

    private int fU(boolean z) {
        AppMethodBeat.i(135568);
        ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", Boolean.valueOf(z));
        this.kzX.reset(this.hRT);
        i.kzN = 0;
        i.kzO = 0;
        i.kzP = 0;
        i.kzQ = 0;
        i.kzR = 0;
        i.kzS = 0;
        i.kzT = 0;
        i.kzU = 0;
        i.kzV = 0;
        this.hRT = null;
        this.kAd = null;
        bgt();
        this.mIsInit = false;
        h hVar = h.kzJ;
        h.bgr();
        if (z) {
            int bgq = g.bgq();
            AppMethodBeat.o(135568);
            return bgq;
        }
        this.kzY.fT(false);
        TelephonyManager telephonyManager = (TelephonyManager) ah.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            telephonyManager.listen(this.kAt, 0);
        }
        AppMethodBeat.o(135568);
        return 0;
    }

    public final void a(final boolean z, final a<String> aVar) {
        AppMethodBeat.i(135569);
        ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", Boolean.valueOf(z));
        R(new Runnable() {
            public final void run() {
                AppMethodBeat.i(135524);
                if (j.this.kAb != d.kBo) {
                    ab.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
                    if (aVar != null) {
                        aVar.a(-10086, VError.ERROR_FACE_TXT_INIT, "not in room", "");
                        AppMethodBeat.o(135524);
                        return;
                    }
                }
                j.this.kzZ.kzm = z;
                if (aVar != null) {
                    aVar.a(0, 0, "ok", "");
                }
                AppMethodBeat.o(135524);
            }
        });
        AppMethodBeat.o(135569);
    }

    public final void b(final boolean z, final a<String> aVar) {
        AppMethodBeat.i(135570);
        ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", Boolean.valueOf(z));
        R(new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.i(135525);
                if (j.this.kAb != d.kBo) {
                    ab.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
                    if (aVar != null) {
                        aVar.a(-10086, VError.ERROR_FACE_TXT_INIT, "not in room", "");
                        AppMethodBeat.o(135525);
                        return;
                    }
                }
                c k = j.this.kzZ;
                boolean z = z;
                if (k.kzb != null) {
                    k.kzb.bs(z);
                    i = 1;
                } else {
                    i = 0;
                }
                if (aVar != null) {
                    if (i != 0) {
                        aVar.a(0, 0, "ok", "");
                        AppMethodBeat.o(135525);
                        return;
                    }
                    aVar.a(-10086, -15, "set mute failed", "");
                }
                AppMethodBeat.o(135525);
            }
        });
        AppMethodBeat.o(135570);
    }

    static boolean a(com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a aVar) {
        AppMethodBeat.i(135571);
        if (g.tA(aVar.kyZ) == 1) {
            AppMethodBeat.o(135571);
            return true;
        }
        AppMethodBeat.o(135571);
        return false;
    }

    static void t(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(135572);
        g.s(bArr, i, i2);
        AppMethodBeat.o(135572);
    }

    static int f(int i, byte[] bArr, int i2) {
        AppMethodBeat.i(135573);
        int e = g.e(i, bArr, i2);
        AppMethodBeat.o(135573);
        return e;
    }

    static int P(byte[] bArr, int i) {
        AppMethodBeat.i(135574);
        int O = g.O(bArr, i);
        AppMethodBeat.o(135574);
        return O;
    }

    static void tF(int i) {
        AppMethodBeat.i(135575);
        g.tC(i);
        AppMethodBeat.o(135575);
    }
}
