package com.tencent.p177mm.pluginsdk.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.pluginsdk.nfc.NfcAID */
public class NfcAID implements Parcelable {
    public static final Creator<NfcAID> CREATOR = new C148951();
    public String mURL = null;
    public String vdi = null;

    /* renamed from: com.tencent.mm.pluginsdk.nfc.NfcAID$1 */
    static class C148951 implements Creator<NfcAID> {
        C148951() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NfcAID[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(27433);
            NfcAID nfcAID = new NfcAID(parcel);
            AppMethodBeat.m2505o(27433);
            return nfcAID;
        }
    }

    public int describeContents() {
        return 0;
    }

    public NfcAID(Parcel parcel) {
        AppMethodBeat.m2504i(27434);
        this.vdi = parcel.readString();
        this.mURL = parcel.readString();
        AppMethodBeat.m2505o(27434);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(27435);
        parcel.writeString(this.vdi);
        parcel.writeString(this.mURL);
        AppMethodBeat.m2505o(27435);
    }

    static {
        AppMethodBeat.m2504i(27436);
        AppMethodBeat.m2505o(27436);
    }
}
