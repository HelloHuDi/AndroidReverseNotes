package com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.IPCSetCurrentPaySpeech */
public class IPCSetCurrentPaySpeech implements C37866a<IPCSetCurrentPaySpeechParam, IPCBoolean> {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.IPCSetCurrentPaySpeech$IPCSetCurrentPaySpeechParam */
    public static final class IPCSetCurrentPaySpeechParam implements Parcelable {
        public static final Creator<IPCSetCurrentPaySpeechParam> CREATOR = new C23301();
        private String hSJ;
        private String hSK;
        private String hSL;
        private boolean hSM;
        private String hSN;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.IPCSetCurrentPaySpeech$IPCSetCurrentPaySpeechParam$1 */
        static class C23301 implements Creator<IPCSetCurrentPaySpeechParam> {
            C23301() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new IPCSetCurrentPaySpeechParam[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(131366);
                IPCSetCurrentPaySpeechParam iPCSetCurrentPaySpeechParam = new IPCSetCurrentPaySpeechParam(parcel);
                AppMethodBeat.m2505o(131366);
                return iPCSetCurrentPaySpeechParam;
            }
        }

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
            AppMethodBeat.m2504i(131367);
            parcel.writeString(this.hSJ);
            parcel.writeString(this.hSK);
            parcel.writeString(this.hSL);
            parcel.writeByte(this.hSM ? (byte) 1 : (byte) 0);
            parcel.writeString(this.hSN);
            AppMethodBeat.m2505o(131367);
        }

        protected IPCSetCurrentPaySpeechParam(Parcel parcel) {
            AppMethodBeat.m2504i(131368);
            this.hSJ = parcel.readString();
            this.hSK = parcel.readString();
            this.hSL = parcel.readString();
            this.hSM = parcel.readByte() != (byte) 0;
            this.hSN = parcel.readString();
            AppMethodBeat.m2505o(131368);
        }

        static {
            AppMethodBeat.m2504i(131369);
            AppMethodBeat.m2505o(131369);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
        AppMethodBeat.m2504i(131370);
        IPCSetCurrentPaySpeechParam iPCSetCurrentPaySpeechParam = (IPCSetCurrentPaySpeechParam) obj;
        if (C5046bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSJ)) {
            C4990ab.m7412e("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "fail:dialectPackId is null");
            if (c18507c != null) {
                c18507c.mo5960ao(new IPCBoolean(false));
            }
            AppMethodBeat.m2505o(131370);
            return;
        }
        String str;
        boolean z;
        if (C5046bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSL)) {
            C4990ab.m7416i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "tempFileAbsolutePath == null");
        } else if (C5046bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSN) || !iPCSetCurrentPaySpeechParam.hSN.equalsIgnoreCase(C1178g.m2587cz(iPCSetCurrentPaySpeechParam.hSL))) {
            C4990ab.m7413e("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "fail:md5Sum:%s", Boolean.valueOf(C5046bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSN)));
            if (c18507c != null) {
                c18507c.mo5960ao(new IPCBoolean(false));
            }
            AppMethodBeat.m2505o(131370);
            return;
        } else {
            C5730e.m8643tf(C19463d.hSQ);
            str = C19463d.hSQ + iPCSetCurrentPaySpeechParam.hSJ + ".pos";
            C5730e.m8644y(iPCSetCurrentPaySpeechParam.hSL, str);
            C19463d.aEF().mo34592cn(iPCSetCurrentPaySpeechParam.hSJ, str);
            C4990ab.m7417i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "copyFile to %s", str);
        }
        if (iPCSetCurrentPaySpeechParam.hSM) {
            C4990ab.m7417i("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "isOnlyDownload:%s", Boolean.valueOf(iPCSetCurrentPaySpeechParam.hSM));
            z = false;
        } else if (!C5046bo.isNullOrNil(iPCSetCurrentPaySpeechParam.hSK)) {
            C19463d.aEF();
            C19463d.m30137BG(iPCSetCurrentPaySpeechParam.hSJ);
            z = false;
        } else if (C5046bo.isEqual(iPCSetCurrentPaySpeechParam.hSJ, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            C19463d.aEF();
            C19463d.m30137BG(iPCSetCurrentPaySpeechParam.hSJ);
            z = false;
        } else {
            C19463d.aEF();
            str = C19463d.m30138BH(iPCSetCurrentPaySpeechParam.hSJ);
            if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
                C4990ab.m7413e("MicroMsg.OfflineVoice.IPCSetCurrentPaySpeech", "resPath:%s %s", C5046bo.m7532bc(str, BuildConfig.COMMAND), Boolean.valueOf(C5730e.m8628ct(str)));
                z = true;
            } else {
                C19463d.aEF();
                C19463d.m30137BG(iPCSetCurrentPaySpeechParam.hSJ);
                z = false;
            }
        }
        if (c18507c != null) {
            if (z) {
                c18507c.mo5960ao(new IPCBoolean(false));
                AppMethodBeat.m2505o(131370);
                return;
            }
            c18507c.mo5960ao(new IPCBoolean(true));
        }
        AppMethodBeat.m2505o(131370);
    }
}
