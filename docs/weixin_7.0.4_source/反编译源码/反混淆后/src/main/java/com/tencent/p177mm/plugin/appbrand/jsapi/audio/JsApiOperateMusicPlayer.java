package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C45176b;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33185b;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.media.music.C19602a.C19601a;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19773a;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.C10835f;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer */
public final class JsApiOperateMusicPlayer extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 47;
    public static final String NAME = "operateMusicPlayer";
    OperateMusicPlayer hAv;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$b */
    static final class C2210b extends C38369p {
        private static final int CTRL_INDEX = 81;
        private static final String NAME = "onMusicPause";

        private C2210b() {
        }

        /* synthetic */ C2210b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$c */
    static final class C2211c extends C38369p {
        private static final int CTRL_INDEX = 80;
        private static final String NAME = "onMusicPlay";

        private C2211c() {
        }

        /* synthetic */ C2211c(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$a */
    static final class C2214a extends C38369p {
        private static final int CTRL_INDEX = 82;
        private static final String NAME = "onMusicEnd";

        private C2214a() {
        }

        /* synthetic */ C2214a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$3 */
    static /* synthetic */ class C22153 {
        static final /* synthetic */ int[] gWZ = new int[C33184d.values().length];

        static {
            AppMethodBeat.m2504i(130718);
            try {
                gWZ[C33184d.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gWZ[C33184d.CLOSE.ordinal()] = 2;
                AppMethodBeat.m2505o(130718);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.m2505o(130718);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$OperateMusicPlayer */
    static class OperateMusicPlayer extends MainProcessTask {
        public static final Creator<OperateMusicPlayer> CREATOR = new C22177();
        public int action;
        public String csB;
        public boolean error = false;
        public String errorMsg;
        private final C4884c hAA = new C22206();
        C32800b hAx;
        C10835f hAy;
        public String hAz;
        C33186c huj;
        private C38492q hwf;
        private int hwi;
        private C45608m hwz;
        public String jsonString;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$OperateMusicPlayer$2 */
        class C22092 implements Runnable {
            C22092() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130720);
                C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
                OperateMusicPlayer.this.action = -1;
                OperateMusicPlayer.this.errorMsg = "";
                OperateMusicPlayer.this.error = false;
                OperateMusicPlayer.m4430d(OperateMusicPlayer.this);
                AppMethodBeat.m2505o(130720);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$OperateMusicPlayer$7 */
        static class C22177 implements Creator<OperateMusicPlayer> {
            C22177() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateMusicPlayer[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130726);
                OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(parcel);
                AppMethodBeat.m2505o(130726);
                return operateMusicPlayer;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$OperateMusicPlayer$3 */
        class C22183 implements Runnable {
            C22183() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130721);
                C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
                OperateMusicPlayer.this.action = -1;
                OperateMusicPlayer.this.error = false;
                OperateMusicPlayer.this.errorMsg = "";
                OperateMusicPlayer.m4431e(OperateMusicPlayer.this);
                AppMethodBeat.m2505o(130721);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$OperateMusicPlayer$4 */
        class C22194 implements Runnable {
            C22194() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130722);
                C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
                OperateMusicPlayer.this.action = -1;
                OperateMusicPlayer.this.error = false;
                OperateMusicPlayer.this.errorMsg = "";
                OperateMusicPlayer.m4432f(OperateMusicPlayer.this);
                AppMethodBeat.m2505o(130722);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$OperateMusicPlayer$6 */
        class C22206 extends C4884c<C37752ke> {
            C22206() {
                AppMethodBeat.m2504i(130724);
                this.xxI = C37752ke.class.getName().hashCode();
                AppMethodBeat.m2505o(130724);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(130725);
                C37752ke c37752ke = (C37752ke) c4883b;
                C4990ab.m7417i("MicroMsg.JsApiOperateMusicPlayer", "callback in(action : %s)", Integer.valueOf(c37752ke.cFH.action));
                C9058e c9058e = c37752ke.cFH.cFB;
                if (c9058e == null) {
                    AppMethodBeat.m2505o(130725);
                } else {
                    String str = c9058e.fKa;
                    HashMap hashMap = new HashMap();
                    hashMap.put("dataUrl", str);
                    OperateMusicPlayer.this.hAz = new JSONObject(hashMap).toString();
                    OperateMusicPlayer.this.action = c37752ke.cFH.action;
                    OperateMusicPlayer.m4434h(OperateMusicPlayer.this);
                    AppMethodBeat.m2505o(130725);
                }
                return false;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$OperateMusicPlayer$5 */
        class C22215 implements Runnable {
            C22215() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130723);
                C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
                OperateMusicPlayer.this.action = -1;
                OperateMusicPlayer.this.error = false;
                OperateMusicPlayer.this.errorMsg = "";
                OperateMusicPlayer.m4433g(OperateMusicPlayer.this);
                AppMethodBeat.m2505o(130723);
            }
        }

        /* renamed from: c */
        static /* synthetic */ boolean m4429c(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.m2504i(130733);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.m2505o(130733);
            return aCb;
        }

        /* renamed from: d */
        static /* synthetic */ boolean m4430d(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.m2504i(130734);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.m2505o(130734);
            return aCb;
        }

        /* renamed from: e */
        static /* synthetic */ boolean m4431e(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.m2504i(130735);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.m2505o(130735);
            return aCb;
        }

        /* renamed from: f */
        static /* synthetic */ boolean m4432f(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.m2504i(130736);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.m2505o(130736);
            return aCb;
        }

        /* renamed from: h */
        static /* synthetic */ boolean m4434h(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.m2504i(130738);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.m2505o(130738);
            return aCb;
        }

        public OperateMusicPlayer(C45608m c45608m, C38492q c38492q, int i) {
            AppMethodBeat.m2504i(130727);
            this.hwz = c45608m;
            this.hwf = c38492q;
            this.hwi = i;
            AppMethodBeat.m2505o(130727);
        }

        public OperateMusicPlayer(Parcel parcel) {
            AppMethodBeat.m2504i(130728);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130728);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130729);
            try {
                JSONObject jSONObject = new JSONObject(this.jsonString);
                String optString = jSONObject.optString("operationType");
                final String optString2 = jSONObject.optString("dataUrl");
                if (C5046bo.isNullOrNil(optString)) {
                    this.action = -1;
                    this.error = true;
                    this.errorMsg = "operationType is null or nil";
                    aCb();
                    AppMethodBeat.m2505o(130729);
                } else if (C19601a.ikU.mo34809cD(this.csB, optString)) {
                    if (C37494a.aig() && !C37494a.aie() && optString.equalsIgnoreCase("play")) {
                        C9058e aih = C37494a.aih();
                        if (aih == null || !(C5046bo.isNullOrNil(optString2) || optString2.equals(aih.fKa))) {
                            C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
                        } else if (C19601a.ikU.mo34809cD(this.csB, "resume")) {
                            C4990ab.m7417i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", this.csB);
                            optString = "resume";
                        } else {
                            C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                        }
                    }
                    if (optString.equalsIgnoreCase("play")) {
                        final String optString3 = jSONObject.optString("title");
                        final String optString4 = jSONObject.optString("singer");
                        final String optString5 = jSONObject.optString("epname");
                        final String optString6 = jSONObject.optString("coverImgUrl");
                        if (C5046bo.isNullOrNil(optString2)) {
                            this.action = -1;
                            this.error = true;
                            this.errorMsg = "dataUrl is null or nil";
                            aCb();
                            AppMethodBeat.m2505o(130729);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", optString3, optString4, optString5, optString6, optString2, optString2, optString2);
                        C37494a.aic();
                        optString = C19601a.ikU.ikS;
                        if (!C5046bo.isNullOrNil(optString)) {
                            C4990ab.m7417i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", optString, this.csB);
                            C19601a.ikU.mo34806Cv(optString);
                        }
                        final String str = optString2;
                        final String str2 = optString2;
                        C5004al.m7442n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(130719);
                                String str = (OperateMusicPlayer.this.csB + optString2 + optString6).hashCode();
                                String str2 = optString6;
                                String str3 = optString6;
                                String str4 = optString3;
                                String str5 = optString4;
                                String str6 = str;
                                String str7 = str2;
                                String str8 = optString2;
                                String str9 = C6457e.eSn;
                                String str10 = C43217c.m76863XW() + optString6.hashCode();
                                String str11 = optString5;
                                C9058e c9058e = new C9058e();
                                c9058e.fJS = 7;
                                c9058e.fJZ = str2;
                                c9058e.fKl = str3;
                                c9058e.fJW = str4;
                                c9058e.fJX = str5;
                                c9058e.fKc = str6;
                                c9058e.fKb = str7;
                                c9058e.fKa = str8;
                                c9058e.fKf = str9;
                                c9058e.fKh = "";
                                c9058e.fKe = str10;
                                c9058e.fJU = str;
                                c9058e.fJV = 0.0f;
                                c9058e.fJY = str11;
                                c9058e.fJT = 1;
                                c9058e.fKd = null;
                                c9058e.fKk = str;
                                c9058e.fKq = true;
                                C37494a.m63280b(c9058e);
                                C19601a.ikU.mo34808a(OperateMusicPlayer.this.hAA, OperateMusicPlayer.this.csB);
                                C19601a.ikU.ikS = OperateMusicPlayer.this.csB;
                                C19601a.ikU.ikT = c9058e.fJU;
                                C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
                                OperateMusicPlayer.this.action = -1;
                                OperateMusicPlayer.this.errorMsg = "";
                                OperateMusicPlayer.this.error = false;
                                OperateMusicPlayer.m4429c(OperateMusicPlayer.this);
                                AppMethodBeat.m2505o(130719);
                            }
                        }, 500);
                        AppMethodBeat.m2505o(130729);
                    } else if (optString.equalsIgnoreCase("resume")) {
                        optString = C19601a.ikU.ikS;
                        if (!C5046bo.isNullOrNil(optString)) {
                            C4990ab.m7417i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", optString, this.csB);
                            C19601a.ikU.mo34806Cv(optString);
                        }
                        C19601a.ikU.mo34808a(this.hAA, this.csB);
                        C19601a.ikU.ikS = this.csB;
                        C9058e aih2 = C37494a.aih();
                        if (aih2 != null) {
                            C19601a.ikU.ikT = aih2.fJU;
                        }
                        if (C45176b.aij()) {
                            C5004al.m7442n(new C22092(), 500);
                            AppMethodBeat.m2505o(130729);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
                        this.action = -1;
                        this.error = true;
                        this.errorMsg = "resume play fail";
                        aCb();
                        AppMethodBeat.m2505o(130729);
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (C45176b.aik()) {
                            C5004al.m7442n(new C22183(), 500);
                            AppMethodBeat.m2505o(130729);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
                        this.action = -1;
                        this.error = true;
                        this.errorMsg = "pause play fail";
                        aCb();
                        AppMethodBeat.m2505o(130729);
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (C37494a.m63283lP(C5046bo.getInt(C5046bo.m7537cD(jSONObject.optString("position")), -1) * 1000)) {
                            C5004al.m7442n(new C22194(), 500);
                            AppMethodBeat.m2505o(130729);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
                        this.action = -1;
                        this.error = true;
                        this.errorMsg = "seek fail";
                        aCb();
                        AppMethodBeat.m2505o(130729);
                    } else if (!optString.equalsIgnoreCase("stop")) {
                        this.action = -1;
                        this.error = true;
                        aCb();
                        AppMethodBeat.m2505o(130729);
                    } else if (C45176b.ail()) {
                        C5004al.m7442n(new C22215(), 500);
                        AppMethodBeat.m2505o(130729);
                    } else {
                        C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
                        this.action = -1;
                        this.error = false;
                        this.errorMsg = "stop play fail";
                        aCb();
                        AppMethodBeat.m2505o(130729);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
                    this.action = -1;
                    this.error = true;
                    this.errorMsg = "appid not match cannot operate";
                    aCb();
                    AppMethodBeat.m2505o(130729);
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.JsApiOperateMusicPlayer", e.toString());
                this.action = -1;
                this.error = true;
                this.errorMsg = "data is null";
                aCb();
                AppMethodBeat.m2505o(130729);
            }
        }

        /* JADX WARNING: Missing block: B:8:0x004d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(130730);
     */
        /* JADX WARNING: Missing block: B:14:0x00e7, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
            r8.hAx.mo53356j("Music#isPlaying", java.lang.Boolean.FALSE);
            com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19773a.m30606c(r8.hAy);
            com.tencent.p177mm.plugin.appbrand.C33183g.m54276b(r8.hwf.getAppId(), r8.huj);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(130730);
     */
        /* JADX WARNING: Missing block: B:17:?, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:20:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void asQ() {
            String str;
            AppMethodBeat.m2504i(130730);
            C4990ab.m7417i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", Integer.valueOf(this.action));
            C38492q c38492q = this.hwf;
            int i = this.hwi;
            C45608m c45608m = this.hwz;
            if (this.error) {
                StringBuilder stringBuilder = new StringBuilder("fail");
                if (TextUtils.isEmpty(this.errorMsg)) {
                    str = "";
                } else {
                    str = new StringBuilder(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(this.errorMsg).toString();
                }
                str = stringBuilder.append(str).toString();
            } else {
                str = "ok";
            }
            c38492q.mo6107M(i, c45608m.mo73394j(str, null));
            switch (this.action) {
                case 0:
                    C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
                    new C2211c().mo61031i(this.hwf).mo61027AL(this.hAz).aCj();
                    this.hAx.mo53356j("Music#isPlaying", Boolean.TRUE);
                    C19773a.m30608d(this.hAy);
                    C33183g.m54274a(this.hwf.getAppId(), this.huj);
                    AppMethodBeat.m2505o(130730);
                    return;
                case 1:
                    C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
                    this.hAx.mo53356j("Music#isPlaying", Boolean.TRUE);
                    C19773a.m30608d(this.hAy);
                    C33183g.m54274a(this.hwf.getAppId(), this.huj);
                    AppMethodBeat.m2505o(130730);
                    return;
                case 2:
                    C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
                    new C2214a().mo61031i(this.hwf).mo61027AL(this.hAz).aCj();
                    break;
                case 3:
                    C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
                    new C2210b().mo61031i(this.hwf).mo61027AL(this.hAz).aCj();
                    this.hAx.mo53356j("Music#isPlaying", Boolean.FALSE);
                    C19773a.m30606c(this.hAy);
                    C33183g.m54276b(this.hwf.getAppId(), this.huj);
                    AppMethodBeat.m2505o(130730);
                    return;
                case 4:
                    C4990ab.m7416i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
                    this.hwf.mo51255h("onMusicError", this.hAz, 0);
                    this.hAx.mo53356j("Music#isPlaying", Boolean.FALSE);
                    C19773a.m30606c(this.hAy);
                    C33183g.m54276b(this.hwf.getAppId(), this.huj);
                    break;
                case 7:
                    break;
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130731);
            this.jsonString = parcel.readString();
            this.csB = parcel.readString();
            this.error = parcel.readByte() != (byte) 0;
            this.hAz = parcel.readString();
            this.action = parcel.readInt();
            this.errorMsg = parcel.readString();
            AppMethodBeat.m2505o(130731);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130732);
            parcel.writeString(this.jsonString);
            parcel.writeString(this.csB);
            parcel.writeByte(this.error ? (byte) 1 : (byte) 0);
            parcel.writeString(this.hAz);
            parcel.writeInt(this.action);
            parcel.writeString(this.errorMsg);
            AppMethodBeat.m2505o(130732);
        }

        static {
            AppMethodBeat.m2504i(130739);
            AppMethodBeat.m2505o(130739);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130740);
        final C19722s c19722s = (C19722s) c2241c;
        this.hAv = new OperateMusicPlayer(this, c19722s, i);
        final C32800b y = C37922v.m64076Zp().mo60676y(C37922v.m64078nW("AppBrandService#" + c19722s.hashCode()), true);
        synchronized (y) {
            try {
                C10835f c10835f;
                C10835f c10835f2 = (C10835f) y.get("StickyBannerChangeListener", null);
                if (c10835f2 == null) {
                    C22121 c22121 = new C10835f() {
                        /* renamed from: bg */
                        public final void mo6073bg(String str, int i) {
                            AppMethodBeat.m2504i(130715);
                            String string = y.getString("appId", "");
                            int i2 = y.getInt("pkgType", 0);
                            if (!((string.equals(str) && i2 == i) || !y.mo53357nX("Music#isPlaying") || C33183g.m54287wW(string) == C33185b.ON_RESUME)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("operationType", "pause");
                                } catch (JSONException e) {
                                }
                                MainProcessTask operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, c19722s, JsApiOperateMusicPlayer.this.hAv.hwi);
                                operateMusicPlayer.jsonString = jSONObject.toString();
                                operateMusicPlayer.csB = string;
                                operateMusicPlayer.hAx = y;
                                AppBrandMainProcessService.m54349a(operateMusicPlayer);
                            }
                            AppMethodBeat.m2505o(130715);
                        }
                    };
                    AppBrandSysConfigWC atH = c19722s.getRuntime().atH();
                    if (atH != null) {
                        y.mo53356j("pkgType", Integer.valueOf(atH.hhd.gVt));
                    }
                    y.mo53356j("StickyBannerChangeListener", c22121);
                    y.mo53356j("appId", c19722s.getAppId());
                    c10835f = c22121;
                } else {
                    c10835f = c10835f2;
                }
                if (((C33186c) y.get("AppBrandLifeCycle.Listener", null)) == null) {
                    C22132 c22132 = new C33186c() {
                        /* renamed from: a */
                        public final void mo6074a(C33184d c33184d) {
                            AppMethodBeat.m2504i(130716);
                            String string = y.getString("appId", "");
                            y.getInt("pkgType", 0);
                            switch (C22153.gWZ[c33184d.ordinal()]) {
                                case 1:
                                case 2:
                                    int i = c19722s.getRuntime().mo43491ya().bQn.scene;
                                    C19773a.aMP();
                                    if (i != FilterEnum4Shaka.MIC_SHAKA_ADD_4) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("operationType", "pause");
                                        } catch (JSONException e) {
                                        }
                                        MainProcessTask operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, c19722s, JsApiOperateMusicPlayer.this.hAv.hwi);
                                        operateMusicPlayer.jsonString = jSONObject.toString();
                                        operateMusicPlayer.csB = string;
                                        operateMusicPlayer.hAx = y;
                                        AppBrandMainProcessService.m54349a(operateMusicPlayer);
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.m2505o(130716);
                        }

                        public final void onDestroy() {
                            AppMethodBeat.m2504i(130717);
                            C4990ab.m7410d("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
                            String string = y.getString("appId", "");
                            y.getInt("pkgType", 0);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "stop");
                            } catch (JSONException e) {
                            }
                            MainProcessTask operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, c19722s, JsApiOperateMusicPlayer.this.hAv.hwi);
                            operateMusicPlayer.jsonString = jSONObject.toString();
                            operateMusicPlayer.csB = string;
                            operateMusicPlayer.action = -1;
                            operateMusicPlayer.hAx = y;
                            AppBrandMainProcessService.m54355b(operateMusicPlayer);
                            AppMethodBeat.m2505o(130717);
                        }
                    };
                    y.mo53356j("AppBrandLifeCycle.Listener", c22132);
                    this.hAv.huj = c22132;
                }
                this.hAv.hAy = c10835f;
                this.hAv.hAx = y;
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(130740);
            }
        }
        this.hAv.jsonString = jSONObject.toString();
        this.hAv.csB = c19722s.getAppId();
        AppBrandMainProcessService.m54349a(this.hAv);
    }
}
