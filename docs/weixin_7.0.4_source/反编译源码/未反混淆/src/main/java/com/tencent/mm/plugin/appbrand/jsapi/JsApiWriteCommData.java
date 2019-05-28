package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONObject;

public final class JsApiWriteCommData extends a {
    public static final int CTRL_INDEX = 445;
    public static final String NAME = "writeCommData";

    static class WriteCommDataTask extends MainProcessTask {
        public static final Creator<WriteCommDataTask> CREATOR = new Creator<WriteCommDataTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WriteCommDataTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(114332);
                WriteCommDataTask writeCommDataTask = new WriteCommDataTask(parcel);
                AppMethodBeat.o(114332);
                return writeCommDataTask;
            }
        };
        private int bOs;
        private m hxE;
        private boolean hxM;
        private String hxN;
        private c hzz;
        private String mData;
        private String mPackageName;

        public WriteCommDataTask(m mVar, c cVar, int i, JSONObject jSONObject) {
            AppMethodBeat.i(114333);
            this.hxE = mVar;
            this.hzz = cVar;
            this.bOs = i;
            this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
            this.mData = jSONObject.optString("data");
            this.hxM = true;
            AppMethodBeat.o(114333);
        }

        public WriteCommDataTask(Parcel parcel) {
            AppMethodBeat.i(114334);
            g(parcel);
            AppMethodBeat.o(114334);
        }

        public final void asQ() {
            AppMethodBeat.i(114336);
            if (this.hxM) {
                String str;
                if (bo.isNullOrNil(this.hxN)) {
                    str = "fail";
                } else {
                    str = String.format("fail:%s", new Object[]{this.hxN});
                }
                this.hzz.M(this.bOs, this.hxE.j(str, null));
                AppMethodBeat.o(114336);
                return;
            }
            this.hzz.M(this.bOs, this.hxE.j("ok", null));
            AppMethodBeat.o(114336);
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(114337);
            this.mPackageName = parcel.readString();
            this.mData = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.hxM = z;
            this.hxN = parcel.readString();
            AppMethodBeat.o(114337);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(114338);
            parcel.writeString(this.mPackageName);
            parcel.writeString(this.mData);
            parcel.writeInt(this.hxM ? 1 : 0);
            parcel.writeString(this.hxN);
            AppMethodBeat.o(114338);
        }

        static {
            AppMethodBeat.i(114339);
            AppMethodBeat.o(114339);
        }

        public final void asP() {
            boolean z = false;
            AppMethodBeat.i(114335);
            if (bo.isNullOrNil(this.mPackageName)) {
                ab.e("MicroMsg.JsApiWriteCommData", "packageName nil");
            } else {
                if (!ah.getContext().getSharedPreferences(ah.getPackageName() + "_comm_preferences", 0).edit().putString(this.mPackageName, this.mData).commit()) {
                    z = true;
                }
                this.hxM = z;
            }
            aCb();
            AppMethodBeat.o(114335);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(114340);
        AppBrandMainProcessService.a(new WriteCommDataTask(this, cVar, i, jSONObject));
        AppMethodBeat.o(114340);
    }
}
