package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.c> extends com.tencent.mm.plugin.appbrand.jsapi.a<CONTEXT> {
    public static final int CTRL_INDEX = 161;
    public static final String NAME = "operateBackgroundAudio";
    protected SetBackgroundAudioListenerTask hAp;

    protected static class OperateBackgroundAudioTask extends MainProcessTask {
        public static final Creator<OperateBackgroundAudioTask> CREATOR = new Creator<OperateBackgroundAudioTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateBackgroundAudioTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(137752);
                OperateBackgroundAudioTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(parcel);
                AppMethodBeat.o(137752);
                return operateBackgroundAudioTask;
            }
        };
        public String appId;
        public boolean error = false;
        public String hAa = "";
        public String hAs;
        public int hwi;
        private m hwz;
        public com.tencent.mm.plugin.appbrand.jsapi.c hxS;

        public OperateBackgroundAudioTask(com.tencent.mm.plugin.appbrand.jsapi.a aVar, com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i) {
            this.hwz = aVar;
            this.hxS = cVar;
            this.hwi = i;
        }

        public OperateBackgroundAudioTask(Parcel parcel) {
            AppMethodBeat.i(137753);
            g(parcel);
            AppMethodBeat.o(137753);
        }

        public final void asP() {
            AppMethodBeat.i(137754);
            ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
            String str = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS;
            if (bo.isNullOrNil(str) || str.equals(this.appId)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.hAs);
                    String optString = jSONObject.optString("operationType");
                    int optInt = jSONObject.optInt("currentTime", -1);
                    if (TextUtils.isEmpty(optString)) {
                        ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
                        this.error = true;
                        this.hAa = "operationType is null";
                        aCb();
                        AppMethodBeat.o(137754);
                        return;
                    }
                    ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%d", optString, Integer.valueOf(optInt));
                    this.error = false;
                    if (optString.equalsIgnoreCase("play")) {
                        e aih = com.tencent.mm.aw.a.aih();
                        if (aih != null) {
                            com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikT = aih.fJU;
                        }
                        if (com.tencent.mm.aw.b.aij()) {
                            ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
                        } else if (com.tencent.mm.aw.a.aie()) {
                            this.error = true;
                            this.hAa = "music is playing, don't play again";
                        } else {
                            this.error = true;
                            this.hAa = "play music fail";
                        }
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (com.tencent.mm.aw.b.aik()) {
                            ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
                        } else {
                            this.error = true;
                            this.hAa = "pause music fail";
                        }
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (optInt < 0) {
                            ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
                            this.error = true;
                            this.hAa = "currentTime is invalid";
                        } else if (com.tencent.mm.aw.a.lP(optInt * 1000)) {
                            ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
                        } else {
                            this.error = true;
                            this.hAa = "seek music fail";
                        }
                    } else if (!optString.equalsIgnoreCase("stop")) {
                        ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
                        this.error = true;
                        this.hAa = "operationType is invalid";
                    } else if (com.tencent.mm.aw.b.ail()) {
                        ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
                    } else {
                        this.error = true;
                        this.hAa = "stop music fail";
                    }
                    if (this.error) {
                        ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.hAa);
                    }
                    aCb();
                    AppMethodBeat.o(137754);
                    return;
                } catch (JSONException e) {
                    ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", this.hAs);
                    this.error = true;
                    this.hAa = "parser data fail, data is invalid";
                    ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + e.getMessage());
                    aCb();
                    AppMethodBeat.o(137754);
                    return;
                }
            }
            ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", str, this.appId);
            this.error = true;
            this.hAa = "appid not match cannot operate";
            aCb();
            AppMethodBeat.o(137754);
        }

        public final void asQ() {
            AppMethodBeat.i(137755);
            if (this.hxS == null) {
                ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
                AppMethodBeat.o(137755);
            } else if (this.error) {
                ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", this.hAa);
                this.hxS.M(this.hwi, this.hwz.j("fail:" + this.hAa, null));
                AppMethodBeat.o(137755);
            } else {
                ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
                this.hxS.M(this.hwi, this.hwz.j("ok", null));
                AppMethodBeat.o(137755);
            }
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(137756);
            this.appId = parcel.readString();
            this.hAs = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.error = z;
            this.hAa = parcel.readString();
            AppMethodBeat.o(137756);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(137757);
            parcel.writeString(this.appId);
            parcel.writeString(this.hAs);
            parcel.writeInt(this.error ? 1 : 0);
            parcel.writeString(this.hAa);
            AppMethodBeat.o(137757);
        }

        static {
            AppMethodBeat.i(137758);
            AppMethodBeat.o(137758);
        }
    }

    public static final class a extends ah {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioNext";
        private static final a hAq = new a();

        static {
            AppMethodBeat.i(137749);
            AppMethodBeat.o(137749);
        }

        static synchronized void k(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
            synchronized (a.class) {
                AppMethodBeat.i(137748);
                ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
                hAq.j(cVar).aCj();
                AppMethodBeat.o(137748);
            }
        }
    }

    public static final class b extends ah {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioPrev";
        private static final b hAr = new b();

        static {
            AppMethodBeat.i(137751);
            AppMethodBeat.o(137751);
        }

        static synchronized void k(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
            synchronized (b.class) {
                AppMethodBeat.i(137750);
                ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
                hAr.j(cVar).aCj();
                AppMethodBeat.o(137750);
            }
        }
    }

    public static final class c extends ah {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioStateChange";
    }

    public final void a(CONTEXT context, JSONObject jSONObject, int i) {
        AppMethodBeat.i(137759);
        if (jSONObject == null) {
            context.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
            AppMethodBeat.o(137759);
            return;
        }
        String appId = context.getAppId();
        ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", appId);
        if (this.hAp == null) {
            this.hAp = a((com.tencent.mm.plugin.appbrand.jsapi.a) this, (com.tencent.mm.plugin.appbrand.jsapi.c) context, i);
        }
        this.hAp.hwi = i;
        this.hAp.appId = appId;
        l(context);
        MainProcessTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(this, context, i);
        operateBackgroundAudioTask.hwi = i;
        operateBackgroundAudioTask.appId = appId;
        operateBackgroundAudioTask.hAs = jSONObject.toString();
        AppBrandMainProcessService.a(operateBackgroundAudioTask);
        AppMethodBeat.o(137759);
    }

    /* Access modifiers changed, original: protected */
    public SetBackgroundAudioListenerTask a(com.tencent.mm.plugin.appbrand.jsapi.a aVar, CONTEXT context, int i) {
        AppMethodBeat.i(137760);
        SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = new SetBackgroundAudioListenerTask(this, context, i);
        AppMethodBeat.o(137760);
        return setBackgroundAudioListenerTask;
    }

    /* Access modifiers changed, original: protected */
    public void l(CONTEXT context) {
    }
}
