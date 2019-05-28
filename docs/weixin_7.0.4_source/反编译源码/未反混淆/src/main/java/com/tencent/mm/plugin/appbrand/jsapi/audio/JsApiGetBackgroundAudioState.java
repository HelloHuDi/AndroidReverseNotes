package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.c;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public class JsApiGetBackgroundAudioState extends u {
    public static final int CTRL_INDEX = 159;
    public static final String NAME = "getBackgroundAudioState";

    static class GetBackgroundAudioStateTask extends MainProcessTask {
        public static final Creator<GetBackgroundAudioStateTask> CREATOR = new Creator<GetBackgroundAudioStateTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetBackgroundAudioStateTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(137730);
                GetBackgroundAudioStateTask getBackgroundAudioStateTask = new GetBackgroundAudioStateTask(parcel);
                AppMethodBeat.o(137730);
                return getBackgroundAudioStateTask;
            }
        };
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

        public GetBackgroundAudioStateTask(Parcel parcel) {
            AppMethodBeat.i(137731);
            g(parcel);
            AppMethodBeat.o(137731);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(137733);
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
            AppMethodBeat.o(137733);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(137734);
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
            AppMethodBeat.o(137734);
        }

        static {
            AppMethodBeat.i(137735);
            AppMethodBeat.o(137735);
        }

        public final void asP() {
            double d = 0.0d;
            AppMethodBeat.i(137732);
            String str = a.ikU.ikS;
            if (bo.isNullOrNil(str) || str.equals(this.appId)) {
                e aih = com.tencent.mm.aw.a.aih();
                if (aih != null) {
                    c aii = com.tencent.mm.aw.a.aii();
                    int i = -1;
                    int i2 = -1;
                    if (aii != null) {
                        i = aii.mDuration;
                        i2 = aii.mPosition;
                    }
                    if (aii == null || i < 0 || i2 < 0) {
                        ab.e("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", Integer.valueOf(i), Integer.valueOf(i2));
                        this.error = true;
                        this.hAa = "return parameter is invalid";
                        aCb();
                        AppMethodBeat.o(137732);
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
                    ab.d("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s", Double.valueOf(this.hAb), Double.valueOf(this.hAc), Integer.valueOf(this.fSc), Double.valueOf(this.hAd), this.ckz, Integer.valueOf(this.startTime), this.title, this.hAf, this.hAh, this.hAg, this.protocol);
                } else {
                    ab.e("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
                    this.error = true;
                    this.hAa = "currentWrapper is null";
                }
                aCb();
                AppMethodBeat.o(137732);
                return;
            }
            ab.i("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", str, this.appId);
            this.error = true;
            this.hAa = "appid not match cannot get background audio state";
            aCb();
            AppMethodBeat.o(137732);
        }
    }

    public final String b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(137736);
        String appId = cVar.getAppId();
        MainProcessTask getBackgroundAudioStateTask = new GetBackgroundAudioStateTask();
        getBackgroundAudioStateTask.appId = appId;
        if (AppBrandMainProcessService.b(getBackgroundAudioStateTask)) {
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
                ab.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", obj);
                appId = j("fail:".concat(String.valueOf(obj)), null);
                AppMethodBeat.o(137736);
                return appId;
            }
            ab.d("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
            appId = j("ok", hashMap);
            AppMethodBeat.o(137736);
            return appId;
        }
        ab.e("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
        appId = j("fail", null);
        AppMethodBeat.o(137736);
        return appId;
    }
}
