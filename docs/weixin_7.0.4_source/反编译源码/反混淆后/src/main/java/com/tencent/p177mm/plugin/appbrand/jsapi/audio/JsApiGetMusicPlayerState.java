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
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.media.music.C19602a.C19601a;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState */
public class JsApiGetMusicPlayerState extends C10296a<C2241c> {
    public static final int CTRL_INDEX = 46;
    public static final String NAME = "getMusicPlayerState";
    private GetMusicPlayerState hAi;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState$GetMusicPlayerState */
    static class GetMusicPlayerState extends MainProcessTask {
        public static final Creator<GetMusicPlayerState> CREATOR = new C22081();
        public boolean error = false;
        public String hAa;
        public String hAj;
        public int hAk;
        public String hAl;
        private int hwi;
        private C45608m hwz;
        private C2241c hxS;
        public int mDuration;
        public int mPosition;
        public int mStatus;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState$GetMusicPlayerState$1 */
        static class C22081 implements Creator<GetMusicPlayerState> {
            C22081() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetMusicPlayerState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(137737);
                GetMusicPlayerState getMusicPlayerState = new GetMusicPlayerState(parcel);
                AppMethodBeat.m2505o(137737);
                return getMusicPlayerState;
            }
        }

        public GetMusicPlayerState(C45608m c45608m, C2241c c2241c, int i) {
            this.hwz = c45608m;
            this.hxS = c2241c;
            this.hwi = i;
        }

        public GetMusicPlayerState(Parcel parcel) {
            AppMethodBeat.m2504i(137738);
            mo6032g(parcel);
            AppMethodBeat.m2505o(137738);
        }

        public final void asQ() {
            String str;
            AppMethodBeat.m2504i(137740);
            HashMap hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.mDuration));
            hashMap.put("currentPosition", Integer.valueOf(this.mPosition));
            hashMap.put("status", Integer.valueOf(this.mStatus));
            hashMap.put("downloadPercent", Integer.valueOf(this.hAk));
            hashMap.put("dataUrl", this.hAl);
            C2241c c2241c = this.hxS;
            int i = this.hwi;
            C45608m c45608m = this.hwz;
            if (this.error) {
                str = "fail" + (TextUtils.isEmpty(this.hAa) ? "" : new StringBuilder(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(this.hAa).toString());
            } else {
                str = "ok";
            }
            c2241c.mo6107M(i, c45608m.mo73394j(str, hashMap));
            AppMethodBeat.m2505o(137740);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(137741);
            this.hAj = parcel.readString();
            this.error = parcel.readByte() != (byte) 0;
            this.mDuration = parcel.readInt();
            this.mPosition = parcel.readInt();
            this.mStatus = parcel.readInt();
            this.hAk = parcel.readInt();
            this.hAl = parcel.readString();
            this.hAa = parcel.readString();
            AppMethodBeat.m2505o(137741);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(137742);
            parcel.writeString(this.hAj);
            parcel.writeByte(this.error ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.mDuration);
            parcel.writeInt(this.mPosition);
            parcel.writeInt(this.mStatus);
            parcel.writeInt(this.hAk);
            parcel.writeString(this.hAl);
            parcel.writeString(this.hAa);
            AppMethodBeat.m2505o(137742);
        }

        static {
            AppMethodBeat.m2504i(137743);
            AppMethodBeat.m2505o(137743);
        }

        public final void asP() {
            AppMethodBeat.m2504i(137739);
            String str = C19601a.ikU.ikS;
            if (C5046bo.isNullOrNil(str) || str.equals(this.hAj)) {
                C9058e aih = C37494a.aih();
                if (aih != null) {
                    int i;
                    int i2;
                    C37496c aii = C37494a.aii();
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
                C4990ab.m7417i("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", Integer.valueOf(this.mDuration), Integer.valueOf(this.mPosition), Integer.valueOf(this.mStatus), Integer.valueOf(this.hAk), this.hAl);
                aCb();
                AppMethodBeat.m2505o(137739);
                return;
            }
            C4990ab.m7416i("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
            this.error = true;
            this.hAa = "appid not match cannot operate";
            aCb();
            AppMethodBeat.m2505o(137739);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(137744);
        this.hAi = new GetMusicPlayerState(this, c2241c, i);
        this.hAi.hAj = c2241c.getAppId();
        AppBrandMainProcessService.m54349a(this.hAi);
        AppMethodBeat.m2505o(137744);
    }
}
