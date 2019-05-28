package com.tencent.p177mm.plugin.collect.model.voice;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C32601ne;
import com.tencent.p177mm.p230g.p231a.C37696bx;
import com.tencent.p177mm.plugin.collect.model.voice.C11431d.C11432a;
import com.tencent.p177mm.plugin.collect.p1481a.C45815a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.collect.model.voice.a */
public class C45818a implements C4937b {
    public static final String hSQ = (C6457e.eSi + "files/wxofflinevoice/");
    public static boolean kCR = false;
    public static float kCS = 0.9f;
    public static float kCT = 10.0f;
    public static final String kCU = (hSQ + "libreadMoney.so");
    public static final String kCV = (hSQ + "woman_putonghua.pos");
    private static C45818a kDa;
    public C11431d kCW;
    public C20267c kCX;
    public C27681b kCY;
    private String kCZ;
    public C4884c<C32519bf> kDb = new C114291();
    public C4884c<C32601ne> kDc = new C458172();
    private boolean kDd = false;
    private Object lock = new Object();

    /* renamed from: com.tencent.mm.plugin.collect.model.voice.a$1 */
    class C114291 extends C4884c<C32519bf> {
        C114291() {
            AppMethodBeat.m2504i(41003);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(41003);
        }

        /* renamed from: a */
        private boolean m19184a(C32519bf c32519bf) {
            AppMethodBeat.m2504i(41004);
            if (c32519bf.cus.cut == 60) {
                synchronized (C45818a.this.lock) {
                    try {
                        if (C45818a.kCR) {
                            C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent OFF_LINE == true");
                        } else {
                            C4990ab.m7417i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s", Integer.valueOf(c32519bf.cus.cut), Integer.valueOf(c32519bf.cus.cuu));
                            if (c32519bf.cus.cuu == 1) {
                                C5730e.m8644y(c32519bf.cus.filePath, C45818a.kCU);
                            } else if (c32519bf.cus.cuu == 2) {
                                C5730e.m8644y(c32519bf.cus.filePath, C45818a.kCV);
                            }
                            C45818a.m84763b(C45818a.this);
                        }
                    } finally {
                        AppMethodBeat.m2505o(41004);
                    }
                }
                return false;
            }
            AppMethodBeat.m2505o(41004);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.model.voice.a$c */
    public interface C20267c {
        /* renamed from: a */
        void mo35507a(int i, String str, String str2, String str3, int i2, String str4, byte[] bArr);
    }

    /* renamed from: com.tencent.mm.plugin.collect.model.voice.a$b */
    public class C27681b implements C45819c {
        private C20267c kDf;
        private ConcurrentLinkedQueue<C38808a> kDg = new ConcurrentLinkedQueue();

        public C27681b(C20267c c20267c) {
            AppMethodBeat.m2504i(41009);
            this.kDf = c20267c;
            AppMethodBeat.m2505o(41009);
        }

        /* renamed from: a */
        public final void mo45528a(C38808a c38808a) {
            AppMethodBeat.m2504i(41010);
            this.kDg.add(c38808a);
            AppMethodBeat.m2505o(41010);
        }

        /* renamed from: l */
        public final void mo45529l(int i, byte[] bArr) {
            boolean z = false;
            AppMethodBeat.m2504i(41011);
            String str = "MicroMsg.F2fRcvVoiceOffLineLogic.Listener";
            String str2 = "onGetResult() errorCode:%s (voiceLlistener == null):%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            if (this.kDf == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            if (this.kDf != null) {
                C38808a c38808a = (C38808a) this.kDg.poll();
                this.kDf.mo35507a(i, c38808a.cva, c38808a.cvb, c38808a.cve, c38808a.cuY, C45818a.bgJ().bgO(), bArr);
            }
            AppMethodBeat.m2505o(41011);
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.model.voice.a$a */
    public class C38808a {
        public int cuY;
        public String cuZ;
        public String cva;
        public String cvb;
        public long cvc;
        public int cvd;
        public String cve;

        public C38808a(C37696bx c37696bx) {
            this.cuY = c37696bx.cuX.cuY;
            this.cuZ = c37696bx.cuX.cuZ;
            this.cva = c37696bx.cuX.cva;
            this.cvb = c37696bx.cuX.cvb;
            this.cvc = c37696bx.cuX.cvc;
            this.cvd = c37696bx.cuX.cvd;
            this.cve = c37696bx.cuX.cve;
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.model.voice.a$2 */
    class C458172 extends C4884c<C32601ne> {
        C458172() {
            AppMethodBeat.m2504i(41006);
            this.xxI = C32601ne.class.getName().hashCode();
            AppMethodBeat.m2505o(41006);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(41008);
            boolean bgP = bgP();
            AppMethodBeat.m2505o(41008);
            return bgP;
        }

        private boolean bgP() {
            AppMethodBeat.m2504i(41007);
            C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent");
            synchronized (C45818a.this.lock) {
                try {
                    C45815a.bgv();
                    if (C45815a.bgx()) {
                        C45818a.m84763b(C45818a.this);
                    } else {
                        C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ReInitVoiceOffLineSynthesizerEvent isF2fRingToneOpen() == false");
                    }
                } finally {
                    AppMethodBeat.m2505o(41007);
                }
            }
            return false;
        }
    }

    public C45818a() {
        AppMethodBeat.m2504i(41012);
        AppMethodBeat.m2505o(41012);
    }

    /* renamed from: b */
    static /* synthetic */ void m84763b(C45818a c45818a) {
        AppMethodBeat.m2504i(41023);
        c45818a.bgL();
        AppMethodBeat.m2505o(41023);
    }

    static {
        AppMethodBeat.m2504i(41024);
        AppMethodBeat.m2505o(41024);
    }

    public static C45818a bgJ() {
        AppMethodBeat.m2504i(41013);
        synchronized (C45818a.class) {
            try {
                if (kDa == null) {
                    kDa = new C45818a();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(41013);
            }
        }
        C45818a c45818a = kDa;
        return c45818a;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(41014);
        C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange()");
        if (this.kDd) {
            AppMethodBeat.m2505o(41014);
            return;
        }
        if (bgK()) {
            C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "onNotifyChange() remove self");
            this.kDd = true;
            C1720g.m3536RP().mo5239Ry().mo10121b(this);
        }
        AppMethodBeat.m2505o(41014);
    }

    /* JADX WARNING: Missing block: B:14:0x003e, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(41015);
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean bgK() {
        AppMethodBeat.m2504i(41015);
        synchronized (this.lock) {
            try {
                if (kCR) {
                    C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() OFF_LINE == true");
                } else {
                    C45815a.bgv();
                    if (C45815a.bgx()) {
                        this.kDc.dnU();
                        if (bgM()) {
                            C4990ab.m7412e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() success!! ");
                            kCR = true;
                        } else {
                            C4990ab.m7412e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "initTTS() fail!! ");
                            kCR = false;
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "isF2fRingToneOpen() == false");
                        AppMethodBeat.m2505o(41015);
                        return false;
                    }
                }
            } finally {
                AppMethodBeat.m2505o(41015);
            }
        }
        return true;
    }

    private void bgL() {
        AppMethodBeat.m2504i(41016);
        if (bgM()) {
            kCR = true;
            C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() success!!");
            AppMethodBeat.m2505o(41016);
            return;
        }
        kCR = false;
        C4990ab.m7416i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "reInitSynthesizer() fail!!");
        AppMethodBeat.m2505o(41016);
    }

    private boolean bgM() {
        int i;
        String gM;
        AppMethodBeat.m2504i(41017);
        C5730e.m8643tf(hSQ);
        if (C5730e.m8628ct(kCU)) {
            i = 1;
        } else {
            C14845c.veg;
            gM = C14839b.m23097gM(60, 1);
            boolean ct = C5730e.m8628ct(gM);
            C4990ab.m7411d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", gM);
            C4990ab.m7417i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkSoEnviroment() %s no exist, cacheExist: %s", kCU, Boolean.valueOf(ct));
            if (ct) {
                C4990ab.m7417i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_SYNTHESIZER_PATH result == %s", Long.valueOf(C5730e.m8644y(gM, kCU)));
                if (!C5046bo.m7521af(C5730e.m8644y(gM, kCU), -1)) {
                    i = 1;
                }
            }
            this.kDb.dnU();
            C14845c.veg;
            C14839b.m23095Ky(60);
            i = 0;
        }
        if (i == 0) {
            AppMethodBeat.m2505o(41017);
            return false;
        }
        gM = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        if (!C5046bo.isEqual(gM, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            String string = C5018as.amF("voice_offline_res").getString(gM, "");
            if (C5046bo.isNullOrNil(string) || !C5730e.m8628ct(string)) {
                C4990ab.m7417i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "resPath:%s %s", C5046bo.m7532bc(string, BuildConfig.COMMAND), Boolean.valueOf(C5730e.m8628ct(string)));
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
            AppMethodBeat.m2505o(41017);
            return false;
        }
        if (this.kCW != null) {
            try {
                this.kCW.kDp.destroy();
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "synthesizer.destroy() Exception:%s %s", e.getClass().getSimpleName(), e.getMessage());
                AppMethodBeat.m2505o(41017);
                return false;
            }
        }
        this.kCW = C11432a.kDq;
        this.kCW.kDp.kDh = this.kCY;
        C11431d c11431d = this.kCW;
        i = c11431d.kDp.mo61680I(hSQ, this.kCZ, kCU);
        if (i < 0) {
            C4990ab.m7412e("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "init failed by ret = ".concat(String.valueOf(i)));
            if (C5046bo.m7563gW(i, -201)) {
                if (!C5046bo.isEqual(this.kCZ, "woman_putonghua")) {
                    C4990ab.m7417i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "voiceResName:%s fail, setVoiceOfflineLanguageResId(VOICE_DEFAULT_RES_ID)", this.kCZ);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VOICE_OFFLINE_RES_ID_STRING_SYNC, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    C4879a.xxA.mo10055m(new C32601ne());
                    bgL();
                }
            } else if (C5046bo.m7563gW(i, -207)) {
                boolean deleteFile = C5730e.deleteFile(kCU);
                C4990ab.m7417i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "ErrorCode.TTS_INIT_SO_ERROR delete %s : %s", kCU, Boolean.valueOf(deleteFile));
            }
            AppMethodBeat.m2505o(41017);
            return false;
        }
        this.kCW.setVolume(kCT);
        this.kCW.mo23172aA(kCS);
        AppMethodBeat.m2505o(41017);
        return true;
    }

    private boolean bgN() {
        AppMethodBeat.m2504i(41018);
        if (C5730e.m8628ct(kCV)) {
            AppMethodBeat.m2505o(41018);
            return true;
        }
        C14845c.veg;
        String gM = C14839b.m23097gM(60, 2);
        boolean ct = C5730e.m8628ct(gM);
        C4990ab.m7411d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "cacheFile:%s", gM);
        C4990ab.m7417i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "checkDefaultResEnviroment() %s no exist, cacheExist: %s", kCV, Boolean.valueOf(ct));
        if (ct) {
            C4990ab.m7417i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "copyFile VOICE_DEFAULT_RES_PATH result == %s", Long.valueOf(C5730e.m8644y(gM, kCV)));
            if (!C5046bo.m7521af(C5730e.m8644y(gM, kCV), -1)) {
                AppMethodBeat.m2505o(41018);
                return true;
            }
        }
        this.kDb.dnU();
        C14845c.veg;
        C14839b.m23095Ky(60);
        AppMethodBeat.m2505o(41018);
        return false;
    }

    /* renamed from: a */
    public final void mo73617a(C37696bx c37696bx) {
        AppMethodBeat.m2504i(41019);
        C38808a c38808a = new C38808a(c37696bx);
        this.kCY.mo45528a(c38808a);
        this.kCW.start(c38808a.cve);
        C4990ab.m7411d("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "produceVoice() %s", c38808a.cve);
        AppMethodBeat.m2505o(41019);
    }

    public final void setVolume(float f) {
        AppMethodBeat.m2504i(41020);
        if (this.kCW != null) {
            this.kCW.setVolume(f);
        }
        AppMethodBeat.m2505o(41020);
    }

    public final void setSpeed(float f) {
        AppMethodBeat.m2504i(41021);
        if (this.kCW != null) {
            this.kCW.mo23172aA(f);
        }
        AppMethodBeat.m2505o(41021);
    }

    public final String bgO() {
        String str;
        AppMethodBeat.m2504i(41022);
        if (C5046bo.isEqual(this.kCZ, "woman_putonghua")) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str = this.kCZ;
        }
        AppMethodBeat.m2505o(41022);
        return str;
    }
}
