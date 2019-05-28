package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiOperateMusicPlayer extends com.tencent.mm.plugin.appbrand.jsapi.a<s> {
    public static final int CTRL_INDEX = 47;
    public static final String NAME = "operateMusicPlayer";
    OperateMusicPlayer hAv;

    static final class b extends p {
        private static final int CTRL_INDEX = 81;
        private static final String NAME = "onMusicPause";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class c extends p {
        private static final int CTRL_INDEX = 80;
        private static final String NAME = "onMusicPlay";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static final class a extends p {
        private static final int CTRL_INDEX = 82;
        private static final String NAME = "onMusicEnd";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] gWZ = new int[d.values().length];

        static {
            AppMethodBeat.i(130718);
            try {
                gWZ[d.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gWZ[d.CLOSE.ordinal()] = 2;
                AppMethodBeat.o(130718);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.o(130718);
            }
        }
    }

    static class OperateMusicPlayer extends MainProcessTask {
        public static final Creator<OperateMusicPlayer> CREATOR = new Creator<OperateMusicPlayer>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateMusicPlayer[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130726);
                OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(parcel);
                AppMethodBeat.o(130726);
                return operateMusicPlayer;
            }
        };
        public int action;
        public String csB;
        public boolean error = false;
        public String errorMsg;
        private final com.tencent.mm.sdk.b.c hAA = new com.tencent.mm.sdk.b.c<ke>() {
            {
                AppMethodBeat.i(130724);
                this.xxI = ke.class.getName().hashCode();
                AppMethodBeat.o(130724);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(130725);
                ke keVar = (ke) bVar;
                ab.i("MicroMsg.JsApiOperateMusicPlayer", "callback in(action : %s)", Integer.valueOf(keVar.cFH.action));
                e eVar = keVar.cFH.cFB;
                if (eVar == null) {
                    AppMethodBeat.o(130725);
                } else {
                    String str = eVar.fKa;
                    HashMap hashMap = new HashMap();
                    hashMap.put("dataUrl", str);
                    OperateMusicPlayer.this.hAz = new JSONObject(hashMap).toString();
                    OperateMusicPlayer.this.action = keVar.cFH.action;
                    OperateMusicPlayer.h(OperateMusicPlayer.this);
                    AppMethodBeat.o(130725);
                }
                return false;
            }
        };
        com.tencent.mm.model.v.b hAx;
        f hAy;
        public String hAz;
        com.tencent.mm.plugin.appbrand.g.c huj;
        private q hwf;
        private int hwi;
        private m hwz;
        public String jsonString;

        static /* synthetic */ boolean c(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(130733);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.o(130733);
            return aCb;
        }

        static /* synthetic */ boolean d(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(130734);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.o(130734);
            return aCb;
        }

        static /* synthetic */ boolean e(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(130735);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.o(130735);
            return aCb;
        }

        static /* synthetic */ boolean f(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(130736);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.o(130736);
            return aCb;
        }

        static /* synthetic */ boolean h(OperateMusicPlayer operateMusicPlayer) {
            AppMethodBeat.i(130738);
            boolean aCb = operateMusicPlayer.aCb();
            AppMethodBeat.o(130738);
            return aCb;
        }

        public OperateMusicPlayer(m mVar, q qVar, int i) {
            AppMethodBeat.i(130727);
            this.hwz = mVar;
            this.hwf = qVar;
            this.hwi = i;
            AppMethodBeat.o(130727);
        }

        public OperateMusicPlayer(Parcel parcel) {
            AppMethodBeat.i(130728);
            g(parcel);
            AppMethodBeat.o(130728);
        }

        public final void asP() {
            AppMethodBeat.i(130729);
            try {
                JSONObject jSONObject = new JSONObject(this.jsonString);
                String optString = jSONObject.optString("operationType");
                final String optString2 = jSONObject.optString("dataUrl");
                if (bo.isNullOrNil(optString)) {
                    this.action = -1;
                    this.error = true;
                    this.errorMsg = "operationType is null or nil";
                    aCb();
                    AppMethodBeat.o(130729);
                } else if (com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.cD(this.csB, optString)) {
                    if (com.tencent.mm.aw.a.aig() && !com.tencent.mm.aw.a.aie() && optString.equalsIgnoreCase("play")) {
                        e aih = com.tencent.mm.aw.a.aih();
                        if (aih == null || !(bo.isNullOrNil(optString2) || optString2.equals(aih.fKa))) {
                            ab.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
                        } else if (com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.cD(this.csB, "resume")) {
                            ab.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", this.csB);
                            optString = "resume";
                        } else {
                            ab.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                        }
                    }
                    if (optString.equalsIgnoreCase("play")) {
                        final String optString3 = jSONObject.optString("title");
                        final String optString4 = jSONObject.optString("singer");
                        final String optString5 = jSONObject.optString("epname");
                        final String optString6 = jSONObject.optString("coverImgUrl");
                        if (bo.isNullOrNil(optString2)) {
                            this.action = -1;
                            this.error = true;
                            this.errorMsg = "dataUrl is null or nil";
                            aCb();
                            AppMethodBeat.o(130729);
                            return;
                        }
                        ab.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", optString3, optString4, optString5, optString6, optString2, optString2, optString2);
                        com.tencent.mm.aw.a.aic();
                        optString = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS;
                        if (!bo.isNullOrNil(optString)) {
                            ab.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", optString, this.csB);
                            com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.Cv(optString);
                        }
                        final String str = optString2;
                        final String str2 = optString2;
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(130719);
                                String str = (OperateMusicPlayer.this.csB + optString2 + optString6).hashCode();
                                String str2 = optString6;
                                String str3 = optString6;
                                String str4 = optString3;
                                String str5 = optString4;
                                String str6 = str;
                                String str7 = str2;
                                String str8 = optString2;
                                String str9 = com.tencent.mm.compatible.util.e.eSn;
                                String str10 = com.tencent.mm.plugin.i.c.XW() + optString6.hashCode();
                                String str11 = optString5;
                                e eVar = new e();
                                eVar.fJS = 7;
                                eVar.fJZ = str2;
                                eVar.fKl = str3;
                                eVar.fJW = str4;
                                eVar.fJX = str5;
                                eVar.fKc = str6;
                                eVar.fKb = str7;
                                eVar.fKa = str8;
                                eVar.fKf = str9;
                                eVar.fKh = "";
                                eVar.fKe = str10;
                                eVar.fJU = str;
                                eVar.fJV = 0.0f;
                                eVar.fJY = str11;
                                eVar.fJT = 1;
                                eVar.fKd = null;
                                eVar.fKk = str;
                                eVar.fKq = true;
                                com.tencent.mm.aw.a.b(eVar);
                                com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.a(OperateMusicPlayer.this.hAA, OperateMusicPlayer.this.csB);
                                com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS = OperateMusicPlayer.this.csB;
                                com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikT = eVar.fJU;
                                ab.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
                                OperateMusicPlayer.this.action = -1;
                                OperateMusicPlayer.this.errorMsg = "";
                                OperateMusicPlayer.this.error = false;
                                OperateMusicPlayer.c(OperateMusicPlayer.this);
                                AppMethodBeat.o(130719);
                            }
                        }, 500);
                        AppMethodBeat.o(130729);
                    } else if (optString.equalsIgnoreCase("resume")) {
                        optString = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS;
                        if (!bo.isNullOrNil(optString)) {
                            ab.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", optString, this.csB);
                            com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.Cv(optString);
                        }
                        com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.a(this.hAA, this.csB);
                        com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS = this.csB;
                        e aih2 = com.tencent.mm.aw.a.aih();
                        if (aih2 != null) {
                            com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikT = aih2.fJU;
                        }
                        if (com.tencent.mm.aw.b.aij()) {
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(130720);
                                    ab.i("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
                                    OperateMusicPlayer.this.action = -1;
                                    OperateMusicPlayer.this.errorMsg = "";
                                    OperateMusicPlayer.this.error = false;
                                    OperateMusicPlayer.d(OperateMusicPlayer.this);
                                    AppMethodBeat.o(130720);
                                }
                            }, 500);
                            AppMethodBeat.o(130729);
                            return;
                        }
                        ab.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
                        this.action = -1;
                        this.error = true;
                        this.errorMsg = "resume play fail";
                        aCb();
                        AppMethodBeat.o(130729);
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (com.tencent.mm.aw.b.aik()) {
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(130721);
                                    ab.i("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
                                    OperateMusicPlayer.this.action = -1;
                                    OperateMusicPlayer.this.error = false;
                                    OperateMusicPlayer.this.errorMsg = "";
                                    OperateMusicPlayer.e(OperateMusicPlayer.this);
                                    AppMethodBeat.o(130721);
                                }
                            }, 500);
                            AppMethodBeat.o(130729);
                            return;
                        }
                        ab.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
                        this.action = -1;
                        this.error = true;
                        this.errorMsg = "pause play fail";
                        aCb();
                        AppMethodBeat.o(130729);
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (com.tencent.mm.aw.a.lP(bo.getInt(bo.cD(jSONObject.optString("position")), -1) * 1000)) {
                            al.n(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(130722);
                                    ab.i("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
                                    OperateMusicPlayer.this.action = -1;
                                    OperateMusicPlayer.this.error = false;
                                    OperateMusicPlayer.this.errorMsg = "";
                                    OperateMusicPlayer.f(OperateMusicPlayer.this);
                                    AppMethodBeat.o(130722);
                                }
                            }, 500);
                            AppMethodBeat.o(130729);
                            return;
                        }
                        ab.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
                        this.action = -1;
                        this.error = true;
                        this.errorMsg = "seek fail";
                        aCb();
                        AppMethodBeat.o(130729);
                    } else if (!optString.equalsIgnoreCase("stop")) {
                        this.action = -1;
                        this.error = true;
                        aCb();
                        AppMethodBeat.o(130729);
                    } else if (com.tencent.mm.aw.b.ail()) {
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(130723);
                                ab.i("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
                                OperateMusicPlayer.this.action = -1;
                                OperateMusicPlayer.this.error = false;
                                OperateMusicPlayer.this.errorMsg = "";
                                OperateMusicPlayer.g(OperateMusicPlayer.this);
                                AppMethodBeat.o(130723);
                            }
                        }, 500);
                        AppMethodBeat.o(130729);
                    } else {
                        ab.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
                        this.action = -1;
                        this.error = false;
                        this.errorMsg = "stop play fail";
                        aCb();
                        AppMethodBeat.o(130729);
                    }
                } else {
                    ab.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
                    this.action = -1;
                    this.error = true;
                    this.errorMsg = "appid not match cannot operate";
                    aCb();
                    AppMethodBeat.o(130729);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiOperateMusicPlayer", e.toString());
                this.action = -1;
                this.error = true;
                this.errorMsg = "data is null";
                aCb();
                AppMethodBeat.o(130729);
            }
        }

        /* JADX WARNING: Missing block: B:8:0x004d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(130730);
     */
        /* JADX WARNING: Missing block: B:14:0x00e7, code skipped:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
            r8.hAx.j("Music#isPlaying", java.lang.Boolean.FALSE);
            com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.c(r8.hAy);
            com.tencent.mm.plugin.appbrand.g.b(r8.hwf.getAppId(), r8.huj);
            com.tencent.matrix.trace.core.AppMethodBeat.o(130730);
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
            AppMethodBeat.i(130730);
            ab.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", Integer.valueOf(this.action));
            q qVar = this.hwf;
            int i = this.hwi;
            m mVar = this.hwz;
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
            qVar.M(i, mVar.j(str, null));
            switch (this.action) {
                case 0:
                    ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
                    new c().i(this.hwf).AL(this.hAz).aCj();
                    this.hAx.j("Music#isPlaying", Boolean.TRUE);
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.d(this.hAy);
                    g.a(this.hwf.getAppId(), this.huj);
                    AppMethodBeat.o(130730);
                    return;
                case 1:
                    ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
                    this.hAx.j("Music#isPlaying", Boolean.TRUE);
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.d(this.hAy);
                    g.a(this.hwf.getAppId(), this.huj);
                    AppMethodBeat.o(130730);
                    return;
                case 2:
                    ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
                    new a().i(this.hwf).AL(this.hAz).aCj();
                    break;
                case 3:
                    ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
                    new b().i(this.hwf).AL(this.hAz).aCj();
                    this.hAx.j("Music#isPlaying", Boolean.FALSE);
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.c(this.hAy);
                    g.b(this.hwf.getAppId(), this.huj);
                    AppMethodBeat.o(130730);
                    return;
                case 4:
                    ab.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
                    this.hwf.h("onMusicError", this.hAz, 0);
                    this.hAx.j("Music#isPlaying", Boolean.FALSE);
                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.c(this.hAy);
                    g.b(this.hwf.getAppId(), this.huj);
                    break;
                case 7:
                    break;
            }
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130731);
            this.jsonString = parcel.readString();
            this.csB = parcel.readString();
            this.error = parcel.readByte() != (byte) 0;
            this.hAz = parcel.readString();
            this.action = parcel.readInt();
            this.errorMsg = parcel.readString();
            AppMethodBeat.o(130731);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130732);
            parcel.writeString(this.jsonString);
            parcel.writeString(this.csB);
            parcel.writeByte(this.error ? (byte) 1 : (byte) 0);
            parcel.writeString(this.hAz);
            parcel.writeInt(this.action);
            parcel.writeString(this.errorMsg);
            AppMethodBeat.o(130732);
        }

        static {
            AppMethodBeat.i(130739);
            AppMethodBeat.o(130739);
        }
    }

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130740);
        final s sVar = (s) cVar;
        this.hAv = new OperateMusicPlayer(this, sVar, i);
        final com.tencent.mm.model.v.b y = v.Zp().y(v.nW("AppBrandService#" + sVar.hashCode()), true);
        synchronized (y) {
            try {
                f fVar;
                f fVar2 = (f) y.get("StickyBannerChangeListener", null);
                if (fVar2 == null) {
                    AnonymousClass1 anonymousClass1 = new f() {
                        public final void bg(String str, int i) {
                            AppMethodBeat.i(130715);
                            String string = y.getString("appId", "");
                            int i2 = y.getInt("pkgType", 0);
                            if (!((string.equals(str) && i2 == i) || !y.nX("Music#isPlaying") || g.wW(string) == com.tencent.mm.plugin.appbrand.g.b.ON_RESUME)) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("operationType", "pause");
                                } catch (JSONException e) {
                                }
                                MainProcessTask operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, sVar, JsApiOperateMusicPlayer.this.hAv.hwi);
                                operateMusicPlayer.jsonString = jSONObject.toString();
                                operateMusicPlayer.csB = string;
                                operateMusicPlayer.hAx = y;
                                AppBrandMainProcessService.a(operateMusicPlayer);
                            }
                            AppMethodBeat.o(130715);
                        }
                    };
                    AppBrandSysConfigWC atH = sVar.getRuntime().atH();
                    if (atH != null) {
                        y.j("pkgType", Integer.valueOf(atH.hhd.gVt));
                    }
                    y.j("StickyBannerChangeListener", anonymousClass1);
                    y.j("appId", sVar.getAppId());
                    fVar = anonymousClass1;
                } else {
                    fVar = fVar2;
                }
                if (((com.tencent.mm.plugin.appbrand.g.c) y.get("AppBrandLifeCycle.Listener", null)) == null) {
                    AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.appbrand.g.c() {
                        public final void a(d dVar) {
                            AppMethodBeat.i(130716);
                            String string = y.getString("appId", "");
                            y.getInt("pkgType", 0);
                            switch (AnonymousClass3.gWZ[dVar.ordinal()]) {
                                case 1:
                                case 2:
                                    int i = sVar.getRuntime().ya().bQn.scene;
                                    com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a.aMP();
                                    if (i != FilterEnum4Shaka.MIC_SHAKA_ADD_4) {
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            jSONObject.put("operationType", "pause");
                                        } catch (JSONException e) {
                                        }
                                        MainProcessTask operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, sVar, JsApiOperateMusicPlayer.this.hAv.hwi);
                                        operateMusicPlayer.jsonString = jSONObject.toString();
                                        operateMusicPlayer.csB = string;
                                        operateMusicPlayer.hAx = y;
                                        AppBrandMainProcessService.a(operateMusicPlayer);
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(130716);
                        }

                        public final void onDestroy() {
                            AppMethodBeat.i(130717);
                            ab.d("MicroMsg.JsApiOperateMusicPlayer", "onDestroy");
                            String string = y.getString("appId", "");
                            y.getInt("pkgType", 0);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "stop");
                            } catch (JSONException e) {
                            }
                            MainProcessTask operateMusicPlayer = new OperateMusicPlayer(JsApiOperateMusicPlayer.this, sVar, JsApiOperateMusicPlayer.this.hAv.hwi);
                            operateMusicPlayer.jsonString = jSONObject.toString();
                            operateMusicPlayer.csB = string;
                            operateMusicPlayer.action = -1;
                            operateMusicPlayer.hAx = y;
                            AppBrandMainProcessService.b(operateMusicPlayer);
                            AppMethodBeat.o(130717);
                        }
                    };
                    y.j("AppBrandLifeCycle.Listener", anonymousClass2);
                    this.hAv.huj = anonymousClass2;
                }
                this.hAv.hAy = fVar;
                this.hAv.hAx = y;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130740);
            }
        }
        this.hAv.jsonString = jSONObject.toString();
        this.hAv.csB = sVar.getAppId();
        AppBrandMainProcessService.a(this.hAv);
    }
}
