package com.tencent.p177mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.nfc.hce.p1471a.C33384d;
import com.tencent.p177mm.plugin.appbrand.p328r.C19680h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase */
public abstract class JsApiAppBrandNFCBase extends C10296a {
    C19456a hRY = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase$CheckIsSupportHCETask */
    static class CheckIsSupportHCETask extends MainProcessTask {
        public static final Creator<CheckIsSupportHCETask> CREATOR = new C194551();
        private String aIm;
        private int errCode;
        private JsApiAppBrandNFCBase hRZ = null;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase$CheckIsSupportHCETask$1 */
        static class C194551 implements Creator<CheckIsSupportHCETask> {
            C194551() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CheckIsSupportHCETask[0];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(137859);
                CheckIsSupportHCETask checkIsSupportHCETask = new CheckIsSupportHCETask(parcel);
                AppMethodBeat.m2505o(137859);
                return checkIsSupportHCETask;
            }
        }

        public CheckIsSupportHCETask(JsApiAppBrandNFCBase jsApiAppBrandNFCBase) {
            this.hRZ = jsApiAppBrandNFCBase;
        }

        public CheckIsSupportHCETask(Parcel parcel) {
            AppMethodBeat.m2504i(137860);
            mo6032g(parcel);
            AppMethodBeat.m2505o(137860);
        }

        public final void asP() {
            AppMethodBeat.m2504i(137861);
            if (!C33384d.aEB()) {
                this.errCode = 13000;
                this.aIm = "not support NFC";
            } else if (C33384d.aEA()) {
                this.errCode = 0;
                this.aIm = "support HCE and system NFC switch is opened";
            } else {
                this.errCode = 13002;
                this.aIm = "not support HCE";
            }
            aCb();
            AppMethodBeat.m2505o(137861);
        }

        public final void asQ() {
            AppMethodBeat.m2504i(137862);
            super.asQ();
            C19680h.m30478at(this);
            if (this.hRZ != null) {
                JsApiAppBrandNFCBase jsApiAppBrandNFCBase = this.hRZ;
                int i = this.errCode;
                String str = this.aIm;
                C4990ab.m7417i("MicroMsg.JsApiAppBrandNFCBase", "alvinluo checkIsSupport resultCallback errCode: %d, errMsg: %s", Integer.valueOf(i), str);
                if (i != 0) {
                    if (C5046bo.isNullOrNil(str)) {
                        str = "unknown error";
                    }
                    if (jsApiAppBrandNFCBase.hRY != null) {
                        jsApiAppBrandNFCBase.hRY.mo34591T(i, str);
                    }
                } else if (jsApiAppBrandNFCBase.hRY != null) {
                    jsApiAppBrandNFCBase.hRY.mo34591T(i, str);
                    AppMethodBeat.m2505o(137862);
                    return;
                }
            }
            AppMethodBeat.m2505o(137862);
        }

        public int describeContents() {
            AppMethodBeat.m2504i(137863);
            int describeContents = super.describeContents();
            AppMethodBeat.m2505o(137863);
            return describeContents;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(137864);
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.aIm);
            AppMethodBeat.m2505o(137864);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(137865);
            super.mo6032g(parcel);
            this.errCode = parcel.readInt();
            this.aIm = parcel.readString();
            AppMethodBeat.m2505o(137865);
        }

        static {
            AppMethodBeat.m2504i(137866);
            AppMethodBeat.m2505o(137866);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.JsApiAppBrandNFCBase$a */
    public interface C19456a {
        /* renamed from: T */
        void mo34591T(int i, String str);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo34590a(C19456a c19456a) {
        this.hRY = c19456a;
        MainProcessTask checkIsSupportHCETask = new CheckIsSupportHCETask(this);
        C19680h.m30479bB(checkIsSupportHCETask);
        AppBrandMainProcessService.m54349a(checkIsSupportHCETask);
    }
}
