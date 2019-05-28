package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.appbrand.r.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class JsApiAppBrandNFCBase extends com.tencent.mm.plugin.appbrand.jsapi.a {
    a hRY = null;

    static class CheckIsSupportHCETask extends MainProcessTask {
        public static final Creator<CheckIsSupportHCETask> CREATOR = new Creator<CheckIsSupportHCETask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CheckIsSupportHCETask[0];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(137859);
                CheckIsSupportHCETask checkIsSupportHCETask = new CheckIsSupportHCETask(parcel);
                AppMethodBeat.o(137859);
                return checkIsSupportHCETask;
            }
        };
        private String aIm;
        private int errCode;
        private JsApiAppBrandNFCBase hRZ = null;

        public CheckIsSupportHCETask(JsApiAppBrandNFCBase jsApiAppBrandNFCBase) {
            this.hRZ = jsApiAppBrandNFCBase;
        }

        public CheckIsSupportHCETask(Parcel parcel) {
            AppMethodBeat.i(137860);
            g(parcel);
            AppMethodBeat.o(137860);
        }

        public final void asP() {
            AppMethodBeat.i(137861);
            if (!d.aEB()) {
                this.errCode = 13000;
                this.aIm = "not support NFC";
            } else if (d.aEA()) {
                this.errCode = 0;
                this.aIm = "support HCE and system NFC switch is opened";
            } else {
                this.errCode = 13002;
                this.aIm = "not support HCE";
            }
            aCb();
            AppMethodBeat.o(137861);
        }

        public final void asQ() {
            AppMethodBeat.i(137862);
            super.asQ();
            h.at(this);
            if (this.hRZ != null) {
                JsApiAppBrandNFCBase jsApiAppBrandNFCBase = this.hRZ;
                int i = this.errCode;
                String str = this.aIm;
                ab.i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                if (i != 0) {
                    if (bo.isNullOrNil(str)) {
                        str = "unknown error";
                    }
                    if (jsApiAppBrandNFCBase.hRY != null) {
                        jsApiAppBrandNFCBase.hRY.T(i, str);
                    }
                } else if (jsApiAppBrandNFCBase.hRY != null) {
                    jsApiAppBrandNFCBase.hRY.T(i, str);
                    AppMethodBeat.o(137862);
                    return;
                }
            }
            AppMethodBeat.o(137862);
        }

        public int describeContents() {
            AppMethodBeat.i(137863);
            int describeContents = super.describeContents();
            AppMethodBeat.o(137863);
            return describeContents;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(137864);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.aIm);
            AppMethodBeat.o(137864);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(137865);
            super.g(parcel);
            this.errCode = parcel.readInt();
            this.aIm = parcel.readString();
            AppMethodBeat.o(137865);
        }

        static {
            AppMethodBeat.i(137866);
            AppMethodBeat.o(137866);
        }
    }

    public interface a {
        void T(int i, String str);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        this.hRY = aVar;
        MainProcessTask checkIsSupportHCETask = new CheckIsSupportHCETask(this);
        h.bB(checkIsSupportHCETask);
        AppBrandMainProcessService.a(checkIsSupportHCETask);
    }
}
