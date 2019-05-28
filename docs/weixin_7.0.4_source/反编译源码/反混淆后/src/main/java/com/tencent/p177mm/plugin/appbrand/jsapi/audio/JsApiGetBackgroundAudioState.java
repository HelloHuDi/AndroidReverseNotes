package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C37496c;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.media.music.C19602a.C19601a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState */
public class JsApiGetBackgroundAudioState extends C19497u {
    public static final int CTRL_INDEX = 159;
    public static final String NAME = "getBackgroundAudioState";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask */
    static class GetBackgroundAudioStateTask extends MainProcessTask {
        public static final Creator<GetBackgroundAudioStateTask> CREATOR = new C312961();
        public String appId = "";
        public String ckz;
        public boolean error = false;
        public int fSc;
        public String hAa;
        public double hAb = 0.0d;
        public double hAc;
        public double hAd;
        public String hAe;
        public String hAf;
        public String hAg;
        public String hAh;
        public String protocol;
        public int startTime;
        public String title;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState$GetBackgroundAudioStateTask$1 */
        static class C312961 implements Creator<GetBackgroundAudioStateTask> {
            C312961() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetBackgroundAudioStateTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(137730);
                GetBackgroundAudioStateTask getBackgroundAudioStateTask = new GetBackgroundAudioStateTask(parcel);
                AppMethodBeat.m2505o(137730);
                return getBackgroundAudioStateTask;
            }
        }

        public GetBackgroundAudioStateTask(Parcel parcel) {
            AppMethodBeat.m2504i(137731);
            mo6032g(parcel);
            AppMethodBeat.m2505o(137731);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(137733);
            this.appId = parcel.readString();
            this.hAb = parcel.readDouble();
            this.hAc = parcel.readDouble();
            this.fSc = parcel.readInt();
            this.hAd = parcel.readDouble();
            this.ckz = parcel.readString();
            this.title = parcel.readString();
            this.hAe = parcel.readString();
            this.hAf = parcel.readString();
            this.hAg = parcel.readString();
            this.hAh = parcel.readString();
            this.protocol = parcel.readString();
            this.startTime = parcel.readInt();
            AppMethodBeat.m2505o(137733);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(137734);
            parcel.writeString(this.appId);
            parcel.writeDouble(this.hAb);
            parcel.writeDouble(this.hAc);
            parcel.writeInt(this.fSc);
            parcel.writeDouble(this.hAd);
            parcel.writeString(this.ckz);
            parcel.writeString(this.title);
            parcel.writeString(this.hAe);
            parcel.writeString(this.hAf);
            parcel.writeString(this.hAg);
            parcel.writeString(this.hAh);
            parcel.writeString(this.protocol);
            parcel.writeInt(this.startTime);
            AppMethodBeat.m2505o(137734);
        }

        static {
            AppMethodBeat.m2504i(137735);
            AppMethodBeat.m2505o(137735);
        }

        public final void asP() {
            double d = 0.0d;
            AppMethodBeat.m2504i(137732);
            String str = C19601a.ikU.ikS;
            if (C5046bo.isNullOrNil(str) || str.equals(this.appId)) {
                C9058e aih = C37494a.aih();
                if (aih != null) {
                    C37496c aii = C37494a.aii();
                    int i = -1;
                    int i2 = -1;
                    if (aii != null) {
                        i = aii.mDuration;
                        i2 = aii.mPosition;
                    }
                    if (aii == null || i < 0 || i2 < 0) {
                        C4990ab.m7413e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", Integer.valueOf(i), Integer.valueOf(i2));
                        this.error = true;
                        this.hAa = "return parameter is invalid";
                        aCb();
                        AppMethodBeat.m2505o(137732);
                        return;
                    }
                    this.hAb = ((double) i) / 1000.0d;
                    this.hAc = ((double) i2) / 1000.0d;
                    i2 = aii.mStatus;
                    i = aii.fJQ;
                    if (this.hAb > 0.0d) {
                        d = (((double) i) * this.hAb) / 100.0d;
                    }
                    this.hAd = d;
                    this.fSc = i2 == 1 ? 0 : 1;
                    this.ckz = aih.fKa;
                    this.title = aih.fJW;
                    this.hAe = aih.fJY;
                    this.hAf = aih.fJX;
                    this.hAg = aih.fJZ;
                    this.hAh = aih.fKc;
                    this.protocol = aih.protocol;
                    this.startTime = aih.startTime;
                    C4990ab.m7411d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s", Double.valueOf(this.hAb), Double.valueOf(this.hAc), Integer.valueOf(this.fSc), Double.valueOf(this.hAd), this.ckz, Integer.valueOf(this.startTime), this.title, this.hAf, this.hAh, this.hAg, this.protocol);
                } else {
                    C4990ab.m7412e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
                    this.error = true;
                    this.hAa = "currentWrapper is null";
                }
                aCb();
                AppMethodBeat.m2505o(137732);
                return;
            }
            C4990ab.m7417i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", str, this.appId);
            this.error = true;
            this.hAa = "appid not match cannot get background audio state";
            aCb();
            AppMethodBeat.m2505o(137732);
        }
    }

    /* renamed from: b */
    public final String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(137736);
        String appId = c2241c.getAppId();
        MainProcessTask getBackgroundAudioStateTask = new GetBackgroundAudioStateTask();
        getBackgroundAudioStateTask.appId = appId;
        if (AppBrandMainProcessService.m54355b(getBackgroundAudioStateTask)) {
            HashMap hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Double.valueOf(getBackgroundAudioStateTask.hAb));
            hashMap.put("currentTime", Double.valueOf(getBackgroundAudioStateTask.hAc));
            hashMap.put("paused", Boolean.valueOf(getBackgroundAudioStateTask.fSc == 1));
            hashMap.put("buffered", Double.valueOf(getBackgroundAudioStateTask.hAd));
            hashMap.put("src", getBackgroundAudioStateTask.ckz);
            hashMap.put("title", getBackgroundAudioStateTask.title);
            hashMap.put("epname", getBackgroundAudioStateTask.hAe);
            hashMap.put("singer", getBackgroundAudioStateTask.hAf);
            hashMap.put("coverImgUrl", getBackgroundAudioStateTask.hAg);
            hashMap.put("webUrl", getBackgroundAudioStateTask.hAh);
            hashMap.put("protocol", getBackgroundAudioStateTask.protocol == null ? "" : getBackgroundAudioStateTask.protocol);
            hashMap.put("startTime", Integer.valueOf(getBackgroundAudioStateTask.startTime / 1000));
            Object obj = TextUtils.isEmpty(getBackgroundAudioStateTask.hAa) ? "" : getBackgroundAudioStateTask.hAa;
            if (getBackgroundAudioStateTask.error) {
                C4990ab.m7413e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", obj);
                appId = mo73394j("fail:".concat(String.valueOf(obj)), null);
                AppMethodBeat.m2505o(137736);
                return appId;
            }
            C4990ab.m7410d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
            appId = mo73394j("ok", hashMap);
            AppMethodBeat.m2505o(137736);
            return appId;
        }
        C4990ab.m7412e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
        appId = mo73394j("fail", null);
        AppMethodBeat.m2505o(137736);
        return appId;
    }
}
