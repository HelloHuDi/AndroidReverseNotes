package com.tencent.mm.plugin.collect.model.voice;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.g.a.bx;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a implements com.tencent.mm.sdk.e.n.b {
    public static final String hSQ = (e.eSi + "files/wxofflinevoice/");
    public static boolean kCR = false;
    public static float kCS = 0.9f;
    public static float kCT = 10.0f;
    public static final String kCU = (hSQ + "libreadMoney.so");
    public static final String kCV = (hSQ + "woman_putonghua.pos");
    private static a kDa;
    public d kCW;
    public c kCX;
    public b kCY;
    private String kCZ;
    public com.tencent.mm.sdk.b.c<bf> kDb = new com.tencent.mm.sdk.b.c<bf>() {
        {
            AppMethodBeat.i(41003);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(41003);
        }

        private boolean a(bf bfVar) {
            AppMethodBeat.i(41004);
            if (bfVar.cus.cut == 60) {
                synchronized (a.this.lock) {
                    try {
                        if (a.kCR) {
                            ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true");
                        } else {
                            ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s", Integer.valueOf(bfVar.cus.cut), Integer.valueOf(bfVar.cus.cuu));
                            if (bfVar.cus.cuu == 1) {
                                com.tencent.mm.vfs.e.y(bfVar.cus.filePath, a.kCU);
                            } else if (bfVar.cus.cuu == 2) {
                                com.tencent.mm.vfs.e.y(bfVar.cus.filePath, a.kCV);
                            }
                            a.b(a.this);
                        }
                    } finally {
                        AppMethodBeat.o(41004);
                    }
                }
                return false;
            }
            AppMethodBeat.o(41004);
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c<ne> kDc = new com.tencent.mm.sdk.b.c<ne>() {
        {
            AppMethodBeat.i(41006);
            this.xxI = ne.class.getName().hashCode();
            AppMethodBeat.o(41006);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(41008);
            boolean bgP = bgP();
            AppMethodBeat.o(41008);
            return bgP;
        }

        private boolean bgP() {
            AppMethodBeat.i(41007);
            ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
            synchronized (a.this.lock) {
                try {
                    com.tencent.mm.plugin.collect.a.a.bgv();
                    if (com.tencent.mm.plugin.collect.a.a.bgx()) {
                        a.b(a.this);
                    } else {
                        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent isF2fRingToneOpen() == false");
                    }
                } finally {
                    AppMethodBeat.o(41007);
                }
            }
            return false;
        }
    };
    private boolean kDd = false;
    private Object lock = new Object();

    public interface c {
        void a(int i, String str, String str2, String str3, int i2, String str4, byte[] bArr);
    }

    public class b implements c {
        private c kDf;
        private ConcurrentLinkedQueue<a> kDg = new ConcurrentLinkedQueue();

        public b(c cVar) {
            AppMethodBeat.i(41009);
            this.kDf = cVar;
            AppMethodBeat.o(41009);
        }

        public final void a(a aVar) {
            AppMethodBeat.i(41010);
            this.kDg.add(aVar);
            AppMethodBeat.o(41010);
        }

        public final void l(int i, byte[] bArr) {
            boolean z = false;
            AppMethodBeat.i(41011);
            String str = "MicroMsg.F2fRcvVoiceOffLineLogic.Listener";
            String str2 = "onGetResult() errorCode:%s (voiceLlistener == null):%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            if (this.kDf == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.i(str, str2, objArr);
            if (this.kDf != null) {
                a aVar = (a) this.kDg.poll();
                this.kDf.a(i, aVar.cva, aVar.cvb, aVar.cve, aVar.cuY, a.bgJ().bgO(), bArr);
            }
            AppMethodBeat.o(41011);
        }
    }

    public class a {
        public int cuY;
        public String cuZ;
        public String cva;
        public String cvb;
        public long cvc;
        public int cvd;
        public String cve;

        public a(bx bxVar) {
            this.cuY = bxVar.cuX.cuY;
            this.cuZ = bxVar.cuX.cuZ;
            this.cva = bxVar.cuX.cva;
            this.cvb = bxVar.cuX.cvb;
            this.cvc = bxVar.cuX.cvc;
            this.cvd = bxVar.cuX.cvd;
            this.cve = bxVar.cuX.cve;
        }
    }

    public a() {
        AppMethodBeat.i(41012);
        AppMethodBeat.o(41012);
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(41023);
        aVar.bgL();
        AppMethodBeat.o(41023);
    }

    static {
        AppMethodBeat.i(41024);
        AppMethodBeat.o(41024);
    }

    public static a bgJ() {
        AppMethodBeat.i(41013);
        synchronized (a.class) {
            try {
                if (kDa == null) {
                    kDa = new a();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(41013);
            }
        }
        a aVar = kDa;
        return aVar;
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(41014);
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
        if (this.kDd) {
            AppMethodBeat.o(41014);
            return;
        }
        if (bgK()) {
            ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange() remove self");
            this.kDd = true;
            g.RP().Ry().b(this);
        }
        AppMethodBeat.o(41014);
    }

    /* JADX WARNING: Missing block: B:14:0x003e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(41015);
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean bgK() {
        AppMethodBeat.i(41015);
        synchronized (this.lock) {
            try {
                if (kCR) {
                    ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
                } else {
                    com.tencent.mm.plugin.collect.a.a.bgv();
                    if (com.tencent.mm.plugin.collect.a.a.bgx()) {
                        this.kDc.dnU();
                        if (bgM()) {
                            ab.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
                            kCR = true;
                        } else {
                            ab.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
                            kCR = false;
                        }
                    } else {
                        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "isF2fRingToneOpen() == false");
                        AppMethodBeat.o(41015);
                        return false;
                    }
                }
            } finally {
                AppMethodBeat.o(41015);
            }
        }
        return true;
    }

    private void bgL() {
        AppMethodBeat.i(41016);
        if (bgM()) {
            kCR = true;
            ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
            AppMethodBeat.o(41016);
            return;
        }
        kCR = false;
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
        AppMethodBeat.o(41016);
    }

    private boolean bgM() {
        int i;
        String gM;
        AppMethodBeat.i(41017);
        com.tencent.mm.vfs.e.tf(hSQ);
        if (com.tencent.mm.vfs.e.ct(kCU)) {
            i = 1;
        } else {
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
            gM = com.tencent.mm.pluginsdk.g.a.a.b.gM(60, 1);
            boolean ct = com.tencent.mm.vfs.e.ct(gM);
            ab.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", gM);
            ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkSoEnviroment() %s no exist, cacheExist: %s", kCU, Boolean.valueOf(ct));
            if (ct) {
                ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_SYNTHESIZER_PATH result == %s", Long.valueOf(com.tencent.mm.vfs.e.y(gM, kCU)));
                if (!bo.af(com.tencent.mm.vfs.e.y(gM, kCU), -1)) {
                    i = 1;
                }
            }
            this.kDb.dnU();
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
            com.tencent.mm.pluginsdk.g.a.a.b.Ky(60);
            i = 0;
        }
        if (i == 0) {
            AppMethodBeat.o(41017);
            return false;
        }
        gM = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (!bo.isEqual(gM, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            String string = as.amF("voice_offline_res").getString(gM, "");
            if (bo.isNullOrNil(string) || !com.tencent.mm.vfs.e.ct(string)) {
                ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "resPath:%s %s", bo.bc(string, BuildConfig.COMMAND), Boolean.valueOf(com.tencent.mm.vfs.e.ct(string)));
                if (bgN()) {
                    this.kCZ = "woman_putonghua";
                    i = 1;
                } else {
                    this.kCZ = "";
                    i = 0;
                }
            } else {
                this.kCZ = gM;
                i = 1;
            }
        } else if (bgN()) {
            this.kCZ = "woman_putonghua";
            i = 1;
        } else {
            this.kCZ = "";
            i = 0;
        }
        if (i == 0) {
            AppMethodBeat.o(41017);
            return false;
        }
        if (this.kCW != null) {
            try {
                this.kCW.kDp.destroy();
            } catch (Exception e) {
                ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "synthesizer.destroy() Exception:%s %s", e.getClass().getSimpleName(), e.getMessage());
                AppMethodBeat.o(41017);
                return false;
            }
        }
        this.kCW = a.kDq;
        this.kCW.kDp.kDh = this.kCY;
        d dVar = this.kCW;
        i = dVar.kDp.I(hSQ, this.kCZ, kCU);
        if (i < 0) {
            ab.e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret = ".concat(String.valueOf(i)));
            if (bo.gW(i, -201)) {
                if (!bo.isEqual(this.kCZ, "woman_putonghua")) {
                    ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", this.kCZ);
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    com.tencent.mm.sdk.b.a.xxA.m(new ne());
                    bgL();
                }
            } else if (bo.gW(i, -207)) {
                boolean deleteFile = com.tencent.mm.vfs.e.deleteFile(kCU);
                ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s : %s", kCU, Boolean.valueOf(deleteFile));
            }
            AppMethodBeat.o(41017);
            return false;
        }
        this.kCW.setVolume(kCT);
        this.kCW.aA(kCS);
        AppMethodBeat.o(41017);
        return true;
    }

    private boolean bgN() {
        AppMethodBeat.i(41018);
        if (com.tencent.mm.vfs.e.ct(kCV)) {
            AppMethodBeat.o(41018);
            return true;
        }
        com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
        String gM = com.tencent.mm.pluginsdk.g.a.a.b.gM(60, 2);
        boolean ct = com.tencent.mm.vfs.e.ct(gM);
        ab.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", gM);
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() %s no exist, cacheExist: %s", kCV, Boolean.valueOf(ct));
        if (ct) {
            ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", Long.valueOf(com.tencent.mm.vfs.e.y(gM, kCV)));
            if (!bo.af(com.tencent.mm.vfs.e.y(gM, kCV), -1)) {
                AppMethodBeat.o(41018);
                return true;
            }
        }
        this.kDb.dnU();
        com.tencent.mm.pluginsdk.g.a.a.b.c.veg;
        com.tencent.mm.pluginsdk.g.a.a.b.Ky(60);
        AppMethodBeat.o(41018);
        return false;
    }

    public final void a(bx bxVar) {
        AppMethodBeat.i(41019);
        a aVar = new a(bxVar);
        this.kCY.a(aVar);
        this.kCW.start(aVar.cve);
        ab.d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", aVar.cve);
        AppMethodBeat.o(41019);
    }

    public final void setVolume(float f) {
        AppMethodBeat.i(41020);
        if (this.kCW != null) {
            this.kCW.setVolume(f);
        }
        AppMethodBeat.o(41020);
    }

    public final void setSpeed(float f) {
        AppMethodBeat.i(41021);
        if (this.kCW != null) {
            this.kCW.aA(f);
        }
        AppMethodBeat.o(41021);
    }

    public final String bgO() {
        String str;
        AppMethodBeat.i(41022);
        if (bo.isEqual(this.kCZ, "woman_putonghua")) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str = this.kCZ;
        }
        AppMethodBeat.o(41022);
        return str;
    }
}
