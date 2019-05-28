package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C45176b;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p198aw.C9059f;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.C33235a;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.C33236b;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.C33237c;
import com.tencent.p177mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.p177mm.plugin.appbrand.media.music.AppBrandMusicClientService.C10622a;
import com.tencent.p177mm.plugin.appbrand.media.music.C19602a;
import com.tencent.p177mm.plugin.appbrand.media.music.C19602a.C19601a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState */
public class JsApiSetBackgroundAudioState extends C10296a {
    public static final int CTRL_INDEX = 160;
    public static final String NAME = "setBackgroundAudioState";
    protected SetBackgroundAudioListenerTask hAp;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask */
    public static class SetBackgroundAudioStateTask extends MainProcessTask {
        public static final Creator<SetBackgroundAudioStateTask> CREATOR = new C192941();
        public String appId;
        public String cHg;
        public boolean error = false;
        public String hAa = "";
        public String hAs;
        public int hwi;
        private C45608m hwz;
        public C2241c hxS;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState$SetBackgroundAudioStateTask$1 */
        static class C192941 implements Creator<SetBackgroundAudioStateTask> {
            C192941() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetBackgroundAudioStateTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(137782);
                SetBackgroundAudioStateTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(parcel);
                AppMethodBeat.m2505o(137782);
                return setBackgroundAudioStateTask;
            }
        }

        public SetBackgroundAudioStateTask(C10296a c10296a, C2241c c2241c, int i) {
            this.hwz = c10296a;
            this.hxS = c2241c;
            this.hwi = i;
        }

        public SetBackgroundAudioStateTask(Parcel parcel) {
            AppMethodBeat.m2504i(137783);
            mo6032g(parcel);
            AppMethodBeat.m2505o(137783);
        }

        /* renamed from: AP */
        public String mo21753AP(String str) {
            AppMethodBeat.m2504i(137784);
            String str2 = C1761b.eSn + "/image/" + str.hashCode();
            AppMethodBeat.m2505o(137784);
            return str2;
        }

        public final void asP() {
            AppMethodBeat.m2504i(137785);
            C4990ab.m7416i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
            try {
                JSONObject jSONObject = new JSONObject(this.hAs);
                String optString = jSONObject.optString("src");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("epname");
                String optString4 = jSONObject.optString("singer");
                String optString5 = jSONObject.optString("coverImgUrl");
                String optString6 = jSONObject.optString("webUrl");
                String optString7 = jSONObject.optString("protocol");
                int optInt = jSONObject.optInt("startTime", 0);
                String optString8 = jSONObject.optString("operationType");
                if (!TextUtils.isEmpty(optString8)) {
                    C4990ab.m7416i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
                    optString5 = C19601a.ikU.ikS;
                    if (C5046bo.isNullOrNil(optString5) || optString5.equals(this.appId)) {
                        this.error = false;
                        if (optString8.equalsIgnoreCase("pause")) {
                            if (C45176b.aik()) {
                                C4990ab.m7416i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
                                AppMethodBeat.m2505o(137785);
                                return;
                            }
                            this.error = true;
                            this.hAa = "pause music fail";
                        } else if (optString8.equalsIgnoreCase("stop")) {
                            if (C45176b.ail()) {
                                C4990ab.m7416i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
                                AppMethodBeat.m2505o(137785);
                                return;
                            }
                            this.error = true;
                            this.hAa = "stop music fail";
                        }
                        aCb();
                        AppMethodBeat.m2505o(137785);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", optString5, this.appId);
                    AppMethodBeat.m2505o(137785);
                } else if (TextUtils.isEmpty(optString)) {
                    C4990ab.m7412e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
                    this.error = true;
                    this.hAa = "src is null";
                    aCb();
                    AppMethodBeat.m2505o(137785);
                } else {
                    C4990ab.m7417i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%d, localPath", optString, optString2, optString3, optString4, optString5, optString7, optString6, Integer.valueOf(optInt), this.cHg);
                    if (optString5 == null) {
                        optString5 = "";
                    }
                    C9058e a = C9059f.m16431a(11, optString5, optString2, optString4, optString6, optString, optString, (this.appId + optString + optString5).hashCode(), C6457e.eSn, mo21753AP(optString5), optString3, "");
                    a.startTime = optInt * 1000;
                    a.protocol = optString7;
                    if (this.cHg.startsWith("file://")) {
                        a.fKg = this.cHg;
                    }
                    C19601a.ikU.ikT = a.fJU;
                    C37494a.m63280b(a);
                    C4990ab.m7416i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
                    C4990ab.m7416i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                    this.error = false;
                    aCb();
                    AppMethodBeat.m2505o(137785);
                }
            } catch (JSONException e) {
                C4990ab.m7412e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
                this.error = true;
                this.hAa = "parser data fail, data is invalid";
                C4990ab.m7412e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + e.getMessage());
                aCb();
                AppMethodBeat.m2505o(137785);
            }
        }

        public final void asQ() {
            AppMethodBeat.m2504i(137786);
            if (this.hxS == null) {
                C4990ab.m7412e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
                AppMethodBeat.m2505o(137786);
            } else if (this.error) {
                C4990ab.m7413e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", this.hAa);
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail:" + this.hAa, null));
                AppMethodBeat.m2505o(137786);
            } else {
                C4990ab.m7416i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
                AppMethodBeat.m2505o(137786);
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(137787);
            this.appId = parcel.readString();
            this.hAs = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.error = z;
            this.hAa = parcel.readString();
            this.cHg = parcel.readString();
            AppMethodBeat.m2505o(137787);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(137788);
            parcel.writeString(this.appId);
            parcel.writeString(this.hAs);
            parcel.writeInt(this.error ? 1 : 0);
            parcel.writeString(this.hAa);
            parcel.writeString(this.cHg);
            AppMethodBeat.m2505o(137788);
        }

        static {
            AppMethodBeat.m2504i(137789);
            AppMethodBeat.m2505o(137789);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask */
    public static class SetBackgroundAudioListenerTask extends MainProcessTask {
        public static final Creator<SetBackgroundAudioListenerTask> CREATOR = new C382571();
        public int action;
        public String appId;
        public String cBb;
        public int cBc;
        public String cwz;
        private final C4884c hAA = new C382562();
        public String hAz;
        private boolean hBa = false;
        C33186c huj;
        public int hwi;
        private C45608m hwz;
        public C2241c hxS;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask$2 */
        class C382562 extends C4884c<C37752ke> {
            C382562() {
                AppMethodBeat.m2504i(137771);
                this.xxI = C37752ke.class.getName().hashCode();
                AppMethodBeat.m2505o(137771);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(137772);
                C37752ke c37752ke = (C37752ke) c4883b;
                C4990ab.m7417i("MicroMsg.Music.SetBackgroundAudioListenerTask", "musicPlayerListener callback action : %d", Integer.valueOf(c37752ke.cFH.action));
                HashMap hashMap = new HashMap();
                String str = c37752ke.cFH.state;
                if (c37752ke.cFH.action == 10) {
                    if (c37752ke.cFH.appId.equals(SetBackgroundAudioListenerTask.this.appId)) {
                        C4990ab.m7416i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is same, don't send ON_PREEMPTED event");
                        AppMethodBeat.m2505o(137772);
                        return false;
                    }
                    C4990ab.m7417i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", c37752ke.cFH.appId, SetBackgroundAudioListenerTask.this.appId);
                    hashMap.put("state", str);
                    SetBackgroundAudioListenerTask.this.hAz = new JSONObject(hashMap).toString();
                    SetBackgroundAudioListenerTask.this.action = c37752ke.cFH.action;
                    SetBackgroundAudioListenerTask.m64742b(SetBackgroundAudioListenerTask.this);
                    AppMethodBeat.m2505o(137772);
                    return true;
                }
                C9058e c9058e = c37752ke.cFH.cFB;
                if (c9058e == null) {
                    C4990ab.m7412e("MicroMsg.Music.SetBackgroundAudioListenerTask", "wrapper is null");
                    AppMethodBeat.m2505o(137772);
                    return false;
                } else if (c37752ke.cFH.cFJ) {
                    int i;
                    if (c37752ke.cFH.action == 2 && c37752ke.cFH.cFK) {
                        i = 1;
                    } else {
                        boolean i2 = false;
                    }
                    if (i2 != 0) {
                        C4990ab.m7412e("MicroMsg.Music.SetBackgroundAudioListenerTask", "isSwitchMusicIng, don't callback!");
                        AppMethodBeat.m2505o(137772);
                        return false;
                    }
                    if (SetBackgroundAudioListenerTask.this.appId.equals(C19601a.ikU.ikS)) {
                        hashMap.put("src", c9058e.fKa);
                        hashMap.put("state", str);
                        hashMap.put("errCode", Integer.valueOf(c37752ke.cFH.errCode));
                        Object obj = "";
                        if (!TextUtils.isEmpty(c37752ke.cFH.aIm)) {
                            obj = c37752ke.cFH.aIm;
                        }
                        hashMap.put("errMsg", obj);
                        SetBackgroundAudioListenerTask.this.hAz = new JSONObject(hashMap).toString();
                        SetBackgroundAudioListenerTask.this.action = c37752ke.cFH.action;
                        SetBackgroundAudioListenerTask.m64743c(SetBackgroundAudioListenerTask.this);
                        AppMethodBeat.m2505o(137772);
                        return true;
                    }
                    C4990ab.m7417i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", SetBackgroundAudioListenerTask.this.appId, C19601a.ikU.ikS);
                    AppMethodBeat.m2505o(137772);
                    return false;
                } else {
                    C4990ab.m7412e("MicroMsg.Music.SetBackgroundAudioListenerTask", "is not from QQMusicPlayer, don't callback!");
                    AppMethodBeat.m2505o(137772);
                    return false;
                }
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask$1 */
        static class C382571 implements Creator<SetBackgroundAudioListenerTask> {
            C382571() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetBackgroundAudioListenerTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(137770);
                SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = new SetBackgroundAudioListenerTask(parcel);
                AppMethodBeat.m2505o(137770);
                return setBackgroundAudioListenerTask;
            }
        }

        /* renamed from: b */
        static /* synthetic */ boolean m64742b(SetBackgroundAudioListenerTask setBackgroundAudioListenerTask) {
            AppMethodBeat.m2504i(137779);
            boolean aCb = setBackgroundAudioListenerTask.aCb();
            AppMethodBeat.m2505o(137779);
            return aCb;
        }

        /* renamed from: c */
        static /* synthetic */ boolean m64743c(SetBackgroundAudioListenerTask setBackgroundAudioListenerTask) {
            AppMethodBeat.m2504i(137780);
            boolean aCb = setBackgroundAudioListenerTask.aCb();
            AppMethodBeat.m2505o(137780);
            return aCb;
        }

        public SetBackgroundAudioListenerTask(C10296a c10296a, C2241c c2241c, int i) {
            AppMethodBeat.m2504i(137773);
            this.hwz = c10296a;
            this.hxS = c2241c;
            this.hwi = i;
            AppMethodBeat.m2505o(137773);
        }

        public SetBackgroundAudioListenerTask(Parcel parcel) {
            AppMethodBeat.m2504i(137774);
            mo6032g(parcel);
            AppMethodBeat.m2505o(137774);
        }

        public final void asP() {
            AppMethodBeat.m2504i(137775);
            C4990ab.m7416i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
            if (this.hBa) {
                C4990ab.m7416i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
                this.hBa = false;
                C37752ke c37752ke = new C37752ke();
                c37752ke.cFH.action = 10;
                c37752ke.cFH.state = "preempted";
                c37752ke.cFH.appId = this.appId;
                c37752ke.cFH.cFJ = true;
                C4879a.xxA.mo10055m(c37752ke);
            }
            String str = C19601a.ikU.ikS;
            if (!C5046bo.isNullOrNil(str)) {
                C4990ab.m7417i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", str, this.appId);
                C19601a.ikU.mo34806Cv(str);
            }
            C19601a.ikU.mo34808a(this.hAA, this.appId);
            C19602a aId = C19601a.ikU;
            String str2 = this.appId;
            int i = this.cBc;
            String str3 = this.cwz;
            String str4 = this.cBb;
            aId.ikS = str2;
            aId.cBc = i;
            aId.cwz = str3;
            aId.cBb = str4;
            AppMethodBeat.m2505o(137775);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(137776);
            if (this.hxS == null) {
                C4990ab.m7412e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
                AppMethodBeat.m2505o(137776);
                return;
            }
            mo21754oa(this.action);
            switch (this.action) {
                case 0:
                case 1:
                    C33183g.m54274a(this.appId, this.huj);
                    AppBrandMusicClientService.ikP.ikQ = this.appId;
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    C33183g.m54276b(this.appId, this.huj);
                    break;
                case 13:
                    C33236b.m54381k(this.hxS);
                    AppMethodBeat.m2505o(137776);
                    return;
                case 14:
                    C33235a.m54380k(this.hxS);
                    AppMethodBeat.m2505o(137776);
                    return;
            }
            C4990ab.m7417i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", Integer.valueOf(this.action), this.hAz);
            new C33237c().mo61032j(this.hxS).mo61028AM(this.hAz).aCj();
            AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ikP;
            int i = this.action;
            C4990ab.m7417i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", Integer.valueOf(i));
            for (Entry entry : appBrandMusicClientService.ikO.entrySet()) {
                if (entry != null) {
                    String str = (String) entry.getKey();
                    C10622a c10622a = (C10622a) entry.getValue();
                    if (!TextUtils.isEmpty(appBrandMusicClientService.ikQ) && appBrandMusicClientService.ikQ.equalsIgnoreCase(str)) {
                        C4990ab.m7417i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", appBrandMusicClientService.ikQ);
                        if (c10622a != null) {
                            if (i == 10) {
                                c10622a.awG();
                            } else if (i == 2) {
                                c10622a.onStop();
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(137776);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: oa */
        public void mo21754oa(int i) {
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(137777);
            this.appId = parcel.readString();
            this.hAz = parcel.readString();
            this.action = parcel.readInt();
            this.cBc = parcel.readInt();
            this.cwz = parcel.readString();
            this.cBb = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hBa = z;
            AppMethodBeat.m2505o(137777);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(137778);
            parcel.writeString(this.appId);
            parcel.writeString(this.hAz);
            parcel.writeInt(this.action);
            parcel.writeInt(this.cBc);
            parcel.writeString(this.cwz);
            parcel.writeString(this.cBb);
            parcel.writeInt(this.hBa ? 1 : 0);
            AppMethodBeat.m2505o(137778);
        }

        static {
            AppMethodBeat.m2504i(137781);
            AppMethodBeat.m2505o(137781);
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(137790);
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
            AppMethodBeat.m2505o(137790);
            return;
        }
        String appId = c2241c.getAppId();
        C4990ab.m7417i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", appId, jSONObject.toString());
        if (this.hAp == null) {
            this.hAp = mo21749a((C10296a) this, c2241c, i);
        }
        this.hAp.hwi = i;
        this.hAp.appId = appId;
        this.hAp.hBa = true;
        String nW = C37922v.m64078nW("AppBrandService#" + c2241c.hashCode());
        mo21751a(nW, c2241c);
        final C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
        synchronized (y) {
            try {
                if (((C33186c) y.get("AppBrandLifeCycle.Listener", null)) == null) {
                    C269181 c269181 = new C33186c() {
                        public final void onDestroy() {
                            AppMethodBeat.m2504i(137769);
                            C4990ab.m7417i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", y.getString("appId", ""));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "stop");
                            } catch (JSONException e) {
                            }
                            MainProcessTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, c2241c, i);
                            setBackgroundAudioStateTask.hAs = jSONObject.toString();
                            setBackgroundAudioStateTask.appId = r0;
                            AppBrandMainProcessService.m54355b(setBackgroundAudioStateTask);
                            AppMethodBeat.m2505o(137769);
                        }
                    };
                    y.mo53356j("AppBrandLifeCycle.Listener", c269181);
                    this.hAp.huj = c269181;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137790);
            }
        }
        AppBrandMainProcessService.m54349a(this.hAp);
        MainProcessTask b = mo21752b(this, c2241c, i);
        b.hwi = i;
        b.appId = appId;
        b.hAs = jSONObject.toString();
        b.cHg = mo21750a(jSONObject, c2241c);
        AppBrandMainProcessService.m54349a(b);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public String mo21750a(JSONObject jSONObject, C2241c c2241c) {
        AppMethodBeat.m2504i(137791);
        String optString = jSONObject.optString("src");
        AppMethodBeat.m2505o(137791);
        return optString;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public SetBackgroundAudioStateTask mo21752b(C10296a c10296a, C2241c c2241c, int i) {
        AppMethodBeat.m2504i(137792);
        SetBackgroundAudioStateTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(this, c2241c, i);
        AppMethodBeat.m2505o(137792);
        return setBackgroundAudioStateTask;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public SetBackgroundAudioListenerTask mo21749a(C10296a c10296a, C2241c c2241c, int i) {
        AppMethodBeat.m2504i(137793);
        SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = new SetBackgroundAudioListenerTask(this, c2241c, i);
        AppMethodBeat.m2505o(137793);
        return setBackgroundAudioListenerTask;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo21751a(String str, C2241c c2241c) {
    }
}
