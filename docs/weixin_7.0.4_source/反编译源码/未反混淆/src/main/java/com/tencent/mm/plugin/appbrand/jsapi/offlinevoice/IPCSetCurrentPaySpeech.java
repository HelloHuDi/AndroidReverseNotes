package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public class IPCSetCurrentPaySpeech implements a<IPCSetCurrentPaySpeechParam, IPCBoolean> {

    public static final class IPCSetCurrentPaySpeechParam implements Parcelable {
        public static final Creator<IPCSetCurrentPaySpeechParam> CREATOR = new Creator<IPCSetCurrentPaySpeechParam>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IPCSetCurrentPaySpeechParam[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(131366);
                IPCSetCurrentPaySpeechParam iPCSetCurrentPaySpeechParam = new IPCSetCurrentPaySpeechParam(parcel);
                AppMethodBeat.o(131366);
                return iPCSetCurrentPaySpeechParam;
            }
        };
        private String hSJ;
        private String hSK;
        private String hSL;
        private boolean hSM;
        private String hSN;

        public IPCSetCurrentPaySpeechParam(String str, String str2, String str3, boolean z, String str4) {
            this.hSJ = str;
            this.hSK = str2;
            this.hSL = str3;
            this.hSM = z;
            this.hSN = str4;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(131367);
            parcel.writeString(this.hSJ);
            parcel.writeString(this.hSK);
            parcel.writeString(this.hSL);
            parcel.writeByte(this.hSM ? (byte) 1 : (byte) 0);
            parcel.writeString(this.hSN);
            AppMethodBeat.o(131367);
        }

        protected IPCSetCurrentPaySpeechParam(Parcel parcel) {
            AppMethodBeat.i(131368);
            this.hSJ = parcel.readString();
            this.hSK = parcel.readString();
            this.hSL = parcel.readString();
            this.hSM = parcel.readByte() != (byte) 0;
            this.hSN = parcel.readString();
            AppMethodBeat.o(131368);
        }

        static {
            AppMethodBeat.i(131369);
            AppMethodBeat.o(131369);
        }
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        AppMethodBeat.i(131370);
        IPCSetCurrentPaySpeechParam iPCSetCurrentPaySpeechParam = (IPCSetCurrentPaySpeechParam) obj;
        if (bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSJ)) {
            ab.e("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "fail:dialectPackId is null");
            if (cVar != null) {
                cVar.ao(new IPCBoolean(false));
            }
            AppMethodBeat.o(131370);
            return;
        }
        String str;
        boolean z;
        if (bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSL)) {
            ab.i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "tempFileAbsolutePath == null");
        } else if (bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSN) || !iPCSetCurrentPaySpeechParam.hSN.equalsIgnoreCase(g.cz(iPCSetCurrentPaySpeechParam.hSL))) {
            ab.e("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "fail:md5Sum:%s", Boolean.valueOf(bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSN)));
            if (cVar != null) {
                cVar.ao(new IPCBoolean(false));
            }
            AppMethodBeat.o(131370);
            return;
        } else {
            e.tf(d.hSQ);
            str = d.hSQ + iPCSetCurrentPaySpeechParam.hSJ + ".pos";
            e.y(iPCSetCurrentPaySpeechParam.hSL, str);
            d.aEF().cn(iPCSetCurrentPaySpeechParam.hSJ, str);
            ab.i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "copyFile to %s", str);
        }
        if (iPCSetCurrentPaySpeechParam.hSM) {
            ab.i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "isOnlyDownload:%s", Boolean.valueOf(iPCSetCurrentPaySpeechParam.hSM));
            z = false;
        } else if (!bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSK)) {
            d.aEF();
            d.BG(iPCSetCurrentPaySpeechParam.hSJ);
            z = false;
        } else if (bo.isEqual(iPCSetCurrentPaySpeechParam.hSJ, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            d.aEF();
            d.BG(iPCSetCurrentPaySpeechParam.hSJ);
            z = false;
        } else {
            d.aEF();
            str = d.BH(iPCSetCurrentPaySpeechParam.hSJ);
            if (bo.isNullOrNil(str) || !e.ct(str)) {
                ab.e("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "resPath:%s %s", bo.bc(str, BuildConfig.COMMAND), Boolean.valueOf(e.ct(str)));
                z = true;
            } else {
                d.aEF();
                d.BG(iPCSetCurrentPaySpeechParam.hSJ);
                z = false;
            }
        }
        if (cVar != null) {
            if (z) {
                cVar.ao(new IPCBoolean(false));
                AppMethodBeat.o(131370);
                return;
            }
            cVar.ao(new IPCBoolean(true));
        }
        AppMethodBeat.o(131370);
    }
}
