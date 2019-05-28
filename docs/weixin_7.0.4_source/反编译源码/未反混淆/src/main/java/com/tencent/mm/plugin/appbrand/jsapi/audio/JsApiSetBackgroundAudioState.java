package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.f;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiSetBackgroundAudioState extends a {
    public static final int CTRL_INDEX = 160;
    public static final String NAME = "setBackgroundAudioState";
    protected SetBackgroundAudioListenerTask hAp;

    public static class SetBackgroundAudioStateTask extends MainProcessTask {
        public static final Creator<SetBackgroundAudioStateTask> CREATOR = new Creator<SetBackgroundAudioStateTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetBackgroundAudioStateTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(137782);
                SetBackgroundAudioStateTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(parcel);
                AppMethodBeat.o(137782);
                return setBackgroundAudioStateTask;
            }
        };
        public String appId;
        public String cHg;
        public boolean error = false;
        public String hAa = "";
        public String hAs;
        public int hwi;
        private m hwz;
        public c hxS;

        public SetBackgroundAudioStateTask(a aVar, c cVar, int i) {
            this.hwz = aVar;
            this.hxS = cVar;
            this.hwi = i;
        }

        public SetBackgroundAudioStateTask(Parcel parcel) {
            AppMethodBeat.i(137783);
            g(parcel);
            AppMethodBeat.o(137783);
        }

        public String AP(String str) {
            AppMethodBeat.i(137784);
            String str2 = b.eSn + "/image/" + str.hashCode();
            AppMethodBeat.o(137784);
            return str2;
        }

        public final void asP() {
            AppMethodBeat.i(137785);
            ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
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
                    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
                    optString5 = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS;
                    if (bo.isNullOrNil(optString5) || optString5.equals(this.appId)) {
                        this.error = false;
                        if (optString8.equalsIgnoreCase("pause")) {
                            if (com.tencent.mm.aw.b.aik()) {
                                ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
                                AppMethodBeat.o(137785);
                                return;
                            }
                            this.error = true;
                            this.hAa = "pause music fail";
                        } else if (optString8.equalsIgnoreCase("stop")) {
                            if (com.tencent.mm.aw.b.ail()) {
                                ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
                                AppMethodBeat.o(137785);
                                return;
                            }
                            this.error = true;
                            this.hAa = "stop music fail";
                        }
                        aCb();
                        AppMethodBeat.o(137785);
                        return;
                    }
                    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", optString5, this.appId);
                    AppMethodBeat.o(137785);
                } else if (TextUtils.isEmpty(optString)) {
                    ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
                    this.error = true;
                    this.hAa = "src is null";
                    aCb();
                    AppMethodBeat.o(137785);
                } else {
                    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%d, localPath", optString, optString2, optString3, optString4, optString5, optString7, optString6, Integer.valueOf(optInt), this.cHg);
                    if (optString5 == null) {
                        optString5 = "";
                    }
                    e a = f.a(11, optString5, optString2, optString4, optString6, optString, optString, (this.appId + optString + optString5).hashCode(), com.tencent.mm.compatible.util.e.eSn, AP(optString5), optString3, "");
                    a.startTime = optInt * 1000;
                    a.protocol = optString7;
                    if (this.cHg.startsWith("file://")) {
                        a.fKg = this.cHg;
                    }
                    com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikT = a.fJU;
                    com.tencent.mm.aw.a.b(a);
                    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
                    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                    this.error = false;
                    aCb();
                    AppMethodBeat.o(137785);
                }
            } catch (JSONException e) {
                ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
                this.error = true;
                this.hAa = "parser data fail, data is invalid";
                ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + e.getMessage());
                aCb();
                AppMethodBeat.o(137785);
            }
        }

        public final void asQ() {
            AppMethodBeat.i(137786);
            if (this.hxS == null) {
                ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
                AppMethodBeat.o(137786);
            } else if (this.error) {
                ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", this.hAa);
                this.hxS.M(this.hwi, this.hwz.j("fail:" + this.hAa, null));
                AppMethodBeat.o(137786);
            } else {
                ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                this.hxS.M(this.hwi, this.hwz.j("ok", null));
                AppMethodBeat.o(137786);
            }
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(137787);
            this.appId = parcel.readString();
            this.hAs = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.error = z;
            this.hAa = parcel.readString();
            this.cHg = parcel.readString();
            AppMethodBeat.o(137787);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(137788);
            parcel.writeString(this.appId);
            parcel.writeString(this.hAs);
            parcel.writeInt(this.error ? 1 : 0);
            parcel.writeString(this.hAa);
            parcel.writeString(this.cHg);
            AppMethodBeat.o(137788);
        }

        static {
            AppMethodBeat.i(137789);
            AppMethodBeat.o(137789);
        }
    }

    public static class SetBackgroundAudioListenerTask extends MainProcessTask {
        public static final Creator<SetBackgroundAudioListenerTask> CREATOR = new Creator<SetBackgroundAudioListenerTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetBackgroundAudioListenerTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(137770);
                SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = new SetBackgroundAudioListenerTask(parcel);
                AppMethodBeat.o(137770);
                return setBackgroundAudioListenerTask;
            }
        };
        public int action;
        public String appId;
        public String cBb;
        public int cBc;
        public String cwz;
        private final com.tencent.mm.sdk.b.c hAA = new com.tencent.mm.sdk.b.c<ke>() {
            {
                AppMethodBeat.i(137771);
                this.xxI = ke.class.getName().hashCode();
                AppMethodBeat.o(137771);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(137772);
                ke keVar = (ke) bVar;
                ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "musicPlayerListener callback action : %d", Integer.valueOf(keVar.cFH.action));
                HashMap hashMap = new HashMap();
                String str = keVar.cFH.state;
                if (keVar.cFH.action == 10) {
                    if (keVar.cFH.appId.equals(SetBackgroundAudioListenerTask.this.appId)) {
                        ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is same, don't send ON_PREEMPTED event");
                        AppMethodBeat.o(137772);
                        return false;
                    }
                    ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", keVar.cFH.appId, SetBackgroundAudioListenerTask.this.appId);
                    hashMap.put("state", str);
                    SetBackgroundAudioListenerTask.this.hAz = new JSONObject(hashMap).toString();
                    SetBackgroundAudioListenerTask.this.action = keVar.cFH.action;
                    SetBackgroundAudioListenerTask.b(SetBackgroundAudioListenerTask.this);
                    AppMethodBeat.o(137772);
                    return true;
                }
                e eVar = keVar.cFH.cFB;
                if (eVar == null) {
                    ab.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "wrapper is null");
                    AppMethodBeat.o(137772);
                    return false;
                } else if (keVar.cFH.cFJ) {
                    int i;
                    if (keVar.cFH.action == 2 && keVar.cFH.cFK) {
                        i = 1;
                    } else {
                        boolean i2 = false;
                    }
                    if (i2 != 0) {
                        ab.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "isSwitchMusicIng, don't callback!");
                        AppMethodBeat.o(137772);
                        return false;
                    }
                    if (SetBackgroundAudioListenerTask.this.appId.equals(com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS)) {
                        hashMap.put("src", eVar.fKa);
                        hashMap.put("state", str);
                        hashMap.put("errCode", Integer.valueOf(keVar.cFH.errCode));
                        Object obj = "";
                        if (!TextUtils.isEmpty(keVar.cFH.aIm)) {
                            obj = keVar.cFH.aIm;
                        }
                        hashMap.put("errMsg", obj);
                        SetBackgroundAudioListenerTask.this.hAz = new JSONObject(hashMap).toString();
                        SetBackgroundAudioListenerTask.this.action = keVar.cFH.action;
                        SetBackgroundAudioListenerTask.c(SetBackgroundAudioListenerTask.this);
                        AppMethodBeat.o(137772);
                        return true;
                    }
                    ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", SetBackgroundAudioListenerTask.this.appId, com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS);
                    AppMethodBeat.o(137772);
                    return false;
                } else {
                    ab.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "is not from QQMusicPlayer, don't callback!");
                    AppMethodBeat.o(137772);
                    return false;
                }
            }
        };
        public String hAz;
        private boolean hBa = false;
        g.c huj;
        public int hwi;
        private m hwz;
        public c hxS;

        static /* synthetic */ boolean b(SetBackgroundAudioListenerTask setBackgroundAudioListenerTask) {
            AppMethodBeat.i(137779);
            boolean aCb = setBackgroundAudioListenerTask.aCb();
            AppMethodBeat.o(137779);
            return aCb;
        }

        static /* synthetic */ boolean c(SetBackgroundAudioListenerTask setBackgroundAudioListenerTask) {
            AppMethodBeat.i(137780);
            boolean aCb = setBackgroundAudioListenerTask.aCb();
            AppMethodBeat.o(137780);
            return aCb;
        }

        public SetBackgroundAudioListenerTask(a aVar, c cVar, int i) {
            AppMethodBeat.i(137773);
            this.hwz = aVar;
            this.hxS = cVar;
            this.hwi = i;
            AppMethodBeat.o(137773);
        }

        public SetBackgroundAudioListenerTask(Parcel parcel) {
            AppMethodBeat.i(137774);
            g(parcel);
            AppMethodBeat.o(137774);
        }

        public final void asP() {
            AppMethodBeat.i(137775);
            ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
            if (this.hBa) {
                ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
                this.hBa = false;
                ke keVar = new ke();
                keVar.cFH.action = 10;
                keVar.cFH.state = "preempted";
                keVar.cFH.appId = this.appId;
                keVar.cFH.cFJ = true;
                com.tencent.mm.sdk.b.a.xxA.m(keVar);
            }
            String str = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS;
            if (!bo.isNullOrNil(str)) {
                ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", str, this.appId);
                com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.Cv(str);
            }
            com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.a(this.hAA, this.appId);
            com.tencent.mm.plugin.appbrand.media.music.a aId = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU;
            String str2 = this.appId;
            int i = this.cBc;
            String str3 = this.cwz;
            String str4 = this.cBb;
            aId.ikS = str2;
            aId.cBc = i;
            aId.cwz = str3;
            aId.cBb = str4;
            AppMethodBeat.o(137775);
        }

        public final void asQ() {
            AppMethodBeat.i(137776);
            if (this.hxS == null) {
                ab.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
                AppMethodBeat.o(137776);
                return;
            }
            oa(this.action);
            switch (this.action) {
                case 0:
                case 1:
                    g.a(this.appId, this.huj);
                    AppBrandMusicClientService.ikP.ikQ = this.appId;
                    break;
                case 2:
                case 3:
                case 4:
                case 7:
                    g.b(this.appId, this.huj);
                    break;
                case 13:
                    JsApiOperateBackgroundAudio.b.k(this.hxS);
                    AppMethodBeat.o(137776);
                    return;
                case 14:
                    JsApiOperateBackgroundAudio.a.k(this.hxS);
                    AppMethodBeat.o(137776);
                    return;
            }
            ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", Integer.valueOf(this.action), this.hAz);
            new JsApiOperateBackgroundAudio.c().j(this.hxS).AM(this.hAz).aCj();
            AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ikP;
            int i = this.action;
            ab.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", Integer.valueOf(i));
            for (Entry entry : appBrandMusicClientService.ikO.entrySet()) {
                if (entry != null) {
                    String str = (String) entry.getKey();
                    AppBrandMusicClientService.a aVar = (AppBrandMusicClientService.a) entry.getValue();
                    if (!TextUtils.isEmpty(appBrandMusicClientService.ikQ) && appBrandMusicClientService.ikQ.equalsIgnoreCase(str)) {
                        ab.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", appBrandMusicClientService.ikQ);
                        if (aVar != null) {
                            if (i == 10) {
                                aVar.awG();
                            } else if (i == 2) {
                                aVar.onStop();
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(137776);
        }

        /* Access modifiers changed, original: protected */
        public void oa(int i) {
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(137777);
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
            AppMethodBeat.o(137777);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(137778);
            parcel.writeString(this.appId);
            parcel.writeString(this.hAz);
            parcel.writeInt(this.action);
            parcel.writeInt(this.cBc);
            parcel.writeString(this.cwz);
            parcel.writeString(this.cBb);
            parcel.writeInt(this.hBa ? 1 : 0);
            AppMethodBeat.o(137778);
        }

        static {
            AppMethodBeat.i(137781);
            AppMethodBeat.o(137781);
        }
    }

    public final void a(final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(137790);
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
            AppMethodBeat.o(137790);
            return;
        }
        String appId = cVar.getAppId();
        ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", appId, jSONObject.toString());
        if (this.hAp == null) {
            this.hAp = a((a) this, cVar, i);
        }
        this.hAp.hwi = i;
        this.hAp.appId = appId;
        this.hAp.hBa = true;
        String nW = v.nW("AppBrandService#" + cVar.hashCode());
        a(nW, cVar);
        final v.b y = v.Zp().y(nW, true);
        synchronized (y) {
            try {
                if (((g.c) y.get("AppBrandLifeCycle.Listener", null)) == null) {
                    AnonymousClass1 anonymousClass1 = new g.c() {
                        public final void onDestroy() {
                            AppMethodBeat.i(137769);
                            ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", y.getString("appId", ""));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("operationType", "stop");
                            } catch (JSONException e) {
                            }
                            MainProcessTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, cVar, i);
                            setBackgroundAudioStateTask.hAs = jSONObject.toString();
                            setBackgroundAudioStateTask.appId = r0;
                            AppBrandMainProcessService.b(setBackgroundAudioStateTask);
                            AppMethodBeat.o(137769);
                        }
                    };
                    y.j("AppBrandLifeCycle.Listener", anonymousClass1);
                    this.hAp.huj = anonymousClass1;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(137790);
            }
        }
        AppBrandMainProcessService.a(this.hAp);
        MainProcessTask b = b(this, cVar, i);
        b.hwi = i;
        b.appId = appId;
        b.hAs = jSONObject.toString();
        b.cHg = a(jSONObject, cVar);
        AppBrandMainProcessService.a(b);
    }

    /* Access modifiers changed, original: protected */
    public String a(JSONObject jSONObject, c cVar) {
        AppMethodBeat.i(137791);
        String optString = jSONObject.optString("src");
        AppMethodBeat.o(137791);
        return optString;
    }

    /* Access modifiers changed, original: protected */
    public SetBackgroundAudioStateTask b(a aVar, c cVar, int i) {
        AppMethodBeat.i(137792);
        SetBackgroundAudioStateTask setBackgroundAudioStateTask = new SetBackgroundAudioStateTask(this, cVar, i);
        AppMethodBeat.o(137792);
        return setBackgroundAudioStateTask;
    }

    /* Access modifiers changed, original: protected */
    public SetBackgroundAudioListenerTask a(a aVar, c cVar, int i) {
        AppMethodBeat.i(137793);
        SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = new SetBackgroundAudioListenerTask(this, cVar, i);
        AppMethodBeat.o(137793);
        return setBackgroundAudioListenerTask;
    }

    /* Access modifiers changed, original: protected */
    public void a(String str, c cVar) {
    }
}
