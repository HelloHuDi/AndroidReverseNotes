package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C45176b;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask;
import com.tencent.p177mm.plugin.appbrand.media.music.C19602a.C19601a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio */
public class JsApiOperateBackgroundAudio<CONTEXT extends C2241c> extends C10296a<CONTEXT> {
    public static final int CTRL_INDEX = 161;
    public static final String NAME = "operateBackgroundAudio";
    protected SetBackgroundAudioListenerTask hAp;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio$OperateBackgroundAudioTask */
    protected static class OperateBackgroundAudioTask extends MainProcessTask {
        public static final Creator<OperateBackgroundAudioTask> CREATOR = new C312971();
        public String appId;
        public boolean error = false;
        public String hAa = "";
        public String hAs;
        public int hwi;
        private C45608m hwz;
        public C2241c hxS;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio$OperateBackgroundAudioTask$1 */
        static class C312971 implements Creator<OperateBackgroundAudioTask> {
            C312971() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateBackgroundAudioTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(137752);
                OperateBackgroundAudioTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(parcel);
                AppMethodBeat.m2505o(137752);
                return operateBackgroundAudioTask;
            }
        }

        public OperateBackgroundAudioTask(C10296a c10296a, C2241c c2241c, int i) {
            this.hwz = c10296a;
            this.hxS = c2241c;
            this.hwi = i;
        }

        public OperateBackgroundAudioTask(Parcel parcel) {
            AppMethodBeat.m2504i(137753);
            mo6032g(parcel);
            AppMethodBeat.m2505o(137753);
        }

        public final void asP() {
            AppMethodBeat.m2504i(137754);
            C4990ab.m7416i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
            String str = C19601a.ikU.ikS;
            if (C5046bo.isNullOrNil(str) || str.equals(this.appId)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.hAs);
                    String optString = jSONObject.optString("operationType");
                    int optInt = jSONObject.optInt("currentTime", -1);
                    if (TextUtils.isEmpty(optString)) {
                        C4990ab.m7412e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
                        this.error = true;
                        this.hAa = "operationType is null";
                        aCb();
                        AppMethodBeat.m2505o(137754);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%d", optString, Integer.valueOf(optInt));
                    this.error = false;
                    if (optString.equalsIgnoreCase("play")) {
                        C9058e aih = C37494a.aih();
                        if (aih != null) {
                            C19601a.ikU.ikT = aih.fJU;
                        }
                        if (C45176b.aij()) {
                            C4990ab.m7416i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
                        } else if (C37494a.aie()) {
                            this.error = true;
                            this.hAa = "music is playing, don't play again";
                        } else {
                            this.error = true;
                            this.hAa = "play music fail";
                        }
                    } else if (optString.equalsIgnoreCase("pause")) {
                        if (C45176b.aik()) {
                            C4990ab.m7416i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
                        } else {
                            this.error = true;
                            this.hAa = "pause music fail";
                        }
                    } else if (optString.equalsIgnoreCase("seek")) {
                        if (optInt < 0) {
                            C4990ab.m7412e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
                            this.error = true;
                            this.hAa = "currentTime is invalid";
                        } else if (C37494a.m63283lP(optInt * 1000)) {
                            C4990ab.m7416i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
                        } else {
                            this.error = true;
                            this.hAa = "seek music fail";
                        }
                    } else if (!optString.equalsIgnoreCase("stop")) {
                        C4990ab.m7412e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
                        this.error = true;
                        this.hAa = "operationType is invalid";
                    } else if (C45176b.ail()) {
                        C4990ab.m7416i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
                    } else {
                        this.error = true;
                        this.hAa = "stop music fail";
                    }
                    if (this.error) {
                        C4990ab.m7412e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.hAa);
                    }
                    aCb();
                    AppMethodBeat.m2505o(137754);
                    return;
                } catch (JSONException e) {
                    C4990ab.m7413e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", this.hAs);
                    this.error = true;
                    this.hAa = "parser data fail, data is invalid";
                    C4990ab.m7412e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + e.getMessage());
                    aCb();
                    AppMethodBeat.m2505o(137754);
                    return;
                }
            }
            C4990ab.m7417i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", str, this.appId);
            this.error = true;
            this.hAa = "appid not match cannot operate";
            aCb();
            AppMethodBeat.m2505o(137754);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(137755);
            if (this.hxS == null) {
                C4990ab.m7412e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
                AppMethodBeat.m2505o(137755);
            } else if (this.error) {
                C4990ab.m7413e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", this.hAa);
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail:" + this.hAa, null));
                AppMethodBeat.m2505o(137755);
            } else {
                C4990ab.m7416i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
                AppMethodBeat.m2505o(137755);
            }
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.m2504i(137756);
            this.appId = parcel.readString();
            this.hAs = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.error = z;
            this.hAa = parcel.readString();
            AppMethodBeat.m2505o(137756);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(137757);
            parcel.writeString(this.appId);
            parcel.writeString(this.hAs);
            parcel.writeInt(this.error ? 1 : 0);
            parcel.writeString(this.hAa);
            AppMethodBeat.m2505o(137757);
        }

        static {
            AppMethodBeat.m2504i(137758);
            AppMethodBeat.m2505o(137758);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio$a */
    public static final class C33235a extends C42467ah {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioNext";
        private static final C33235a hAq = new C33235a();

        static {
            AppMethodBeat.m2504i(137749);
            AppMethodBeat.m2505o(137749);
        }

        /* renamed from: k */
        static synchronized void m54380k(C2241c c2241c) {
            synchronized (C33235a.class) {
                AppMethodBeat.m2504i(137748);
                C4990ab.m7416i("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
                hAq.mo61032j(c2241c).aCj();
                AppMethodBeat.m2505o(137748);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio$b */
    public static final class C33236b extends C42467ah {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioPrev";
        private static final C33236b hAr = new C33236b();

        static {
            AppMethodBeat.m2504i(137751);
            AppMethodBeat.m2505o(137751);
        }

        /* renamed from: k */
        static synchronized void m54381k(C2241c c2241c) {
            synchronized (C33236b.class) {
                AppMethodBeat.m2504i(137750);
                C4990ab.m7416i("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
                hAr.mo61032j(c2241c).aCj();
                AppMethodBeat.m2505o(137750);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio$c */
    public static final class C33237c extends C42467ah {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioStateChange";
    }

    /* renamed from: a */
    public final void mo5994a(CONTEXT context, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(137759);
        if (jSONObject == null) {
            context.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
            AppMethodBeat.m2505o(137759);
            return;
        }
        String appId = context.getAppId();
        C4990ab.m7417i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", appId);
        if (this.hAp == null) {
            this.hAp = mo44668a((C10296a) this, (C2241c) context, i);
        }
        this.hAp.hwi = i;
        this.hAp.appId = appId;
        mo44669l(context);
        MainProcessTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(this, context, i);
        operateBackgroundAudioTask.hwi = i;
        operateBackgroundAudioTask.appId = appId;
        operateBackgroundAudioTask.hAs = jSONObject.toString();
        AppBrandMainProcessService.m54349a(operateBackgroundAudioTask);
        AppMethodBeat.m2505o(137759);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public SetBackgroundAudioListenerTask mo44668a(C10296a c10296a, CONTEXT context, int i) {
        AppMethodBeat.m2504i(137760);
        SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = new SetBackgroundAudioListenerTask(this, context, i);
        AppMethodBeat.m2505o(137760);
        return setBackgroundAudioListenerTask;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: l */
    public void mo44669l(CONTEXT context) {
    }
}
