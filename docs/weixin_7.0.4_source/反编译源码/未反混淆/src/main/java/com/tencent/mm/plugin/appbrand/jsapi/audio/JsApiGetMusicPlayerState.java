package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import org.json.JSONObject;

public class JsApiGetMusicPlayerState extends a<c> {
    public static final int CTRL_INDEX = 46;
    public static final String NAME = "getMusicPlayerState";
    private GetMusicPlayerState hAi;

    static class GetMusicPlayerState extends MainProcessTask {
        public static final Creator<GetMusicPlayerState> CREATOR = new Creator<GetMusicPlayerState>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetMusicPlayerState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(137737);
                GetMusicPlayerState getMusicPlayerState = new GetMusicPlayerState(parcel);
                AppMethodBeat.o(137737);
                return getMusicPlayerState;
            }
        };
        public boolean error = false;
        public String hAa;
        public String hAj;
        public int hAk;
        public String hAl;
        private int hwi;
        private m hwz;
        private c hxS;
        public int mDuration;
        public int mPosition;
        public int mStatus;

        public GetMusicPlayerState(m mVar, c cVar, int i) {
            this.hwz = mVar;
            this.hxS = cVar;
            this.hwi = i;
        }

        public GetMusicPlayerState(Parcel parcel) {
            AppMethodBeat.i(137738);
            g(parcel);
            AppMethodBeat.o(137738);
        }

        public final void asQ() {
            String str;
            AppMethodBeat.i(137740);
            HashMap hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.mDuration));
            hashMap.put("currentPosition", Integer.valueOf(this.mPosition));
            hashMap.put("status", Integer.valueOf(this.mStatus));
            hashMap.put("downloadPercent", Integer.valueOf(this.hAk));
            hashMap.put("dataUrl", this.hAl);
            c cVar = this.hxS;
            int i = this.hwi;
            m mVar = this.hwz;
            if (this.error) {
                str = "fail" + (TextUtils.isEmpty(this.hAa) ? "" : new StringBuilder(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(this.hAa).toString());
            } else {
                str = "ok";
            }
            cVar.M(i, mVar.j(str, hashMap));
            AppMethodBeat.o(137740);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(137741);
            this.hAj = parcel.readString();
            this.error = parcel.readByte() != (byte) 0;
            this.mDuration = parcel.readInt();
            this.mPosition = parcel.readInt();
            this.mStatus = parcel.readInt();
            this.hAk = parcel.readInt();
            this.hAl = parcel.readString();
            this.hAa = parcel.readString();
            AppMethodBeat.o(137741);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(137742);
            parcel.writeString(this.hAj);
            parcel.writeByte(this.error ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.mDuration);
            parcel.writeInt(this.mPosition);
            parcel.writeInt(this.mStatus);
            parcel.writeInt(this.hAk);
            parcel.writeString(this.hAl);
            parcel.writeString(this.hAa);
            AppMethodBeat.o(137742);
        }

        static {
            AppMethodBeat.i(137743);
            AppMethodBeat.o(137743);
        }

        public final void asP() {
            AppMethodBeat.i(137739);
            String str = com.tencent.mm.plugin.appbrand.media.music.a.a.ikU.ikS;
            if (bo.isNullOrNil(str) || str.equals(this.hAj)) {
                e aih = com.tencent.mm.aw.a.aih();
                if (aih != null) {
                    int i;
                    int i2;
                    com.tencent.mm.aw.c aii = com.tencent.mm.aw.a.aii();
                    if (aii != null) {
                        int i3 = aii.mDuration;
                        i = aii.mPosition;
                        this.mStatus = aii.mStatus;
                        this.hAk = aii.fJQ;
                        i2 = i3;
                    } else {
                        i = -1;
                        i2 = -1;
                    }
                    this.mDuration = i2 / 1000;
                    this.mPosition = i / 1000;
                    this.hAl = aih.fKa;
                    this.hAa = "";
                    this.error = false;
                } else {
                    this.mStatus = 2;
                    this.hAa = "";
                    this.error = false;
                }
                ab.i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", Integer.valueOf(this.mDuration), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.hAk), this.hAl);
                aCb();
                AppMethodBeat.o(137739);
                return;
            }
            ab.i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
            this.error = true;
            this.hAa = "appid not match cannot operate";
            aCb();
            AppMethodBeat.o(137739);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(137744);
        this.hAi = new GetMusicPlayerState(this, cVar, i);
        this.hAi.hAj = cVar.getAppId();
        AppBrandMainProcessService.a(this.hAi);
        AppMethodBeat.o(137744);
    }
}
