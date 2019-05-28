package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.ShareInfo */
public class ShareInfo implements Parcelable {
    public static final Creator<ShareInfo> CREATOR = new C23411();
    public String bQh;
    public String bQi;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.ShareInfo$1 */
    static class C23411 implements Creator<ShareInfo> {
        C23411() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ShareInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(131479);
            ShareInfo shareInfo = new ShareInfo(parcel, (byte) 0);
            AppMethodBeat.m2505o(131479);
            return shareInfo;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(131480);
        parcel.writeString(this.bQi);
        parcel.writeString(this.bQh);
        AppMethodBeat.m2505o(131480);
    }

    public ShareInfo(String str, String str2) {
        this.bQi = str;
        this.bQh = str2;
    }

    private ShareInfo(Parcel parcel) {
        AppMethodBeat.m2504i(131481);
        this.bQi = parcel.readString();
        this.bQh = parcel.readString();
        AppMethodBeat.m2505o(131481);
    }

    static {
        AppMethodBeat.m2504i(131482);
        AppMethodBeat.m2505o(131482);
    }
}
