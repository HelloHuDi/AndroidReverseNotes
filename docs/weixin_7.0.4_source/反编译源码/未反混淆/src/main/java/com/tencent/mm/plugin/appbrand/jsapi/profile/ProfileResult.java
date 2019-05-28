package com.tencent.mm.plugin.appbrand.jsapi.profile;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\b\u0010¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "okFlag", "", "getOkFlag$plugin_appbrand_integration_release", "()I", "setOkFlag$plugin_appbrand_integration_release", "(I)V", "resultCode", "getResultCode$plugin_appbrand_integration_release", "setResultCode$plugin_appbrand_integration_release", "username", "", "getUsername$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setUsername$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class ProfileResult extends ProcessResult {
    public static final a CREATOR = new a();
    int bFZ;
    int hUO;
    String username;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileResult;", "plugin-appbrand-integration_release"})
    public static final class a implements Creator<ProfileResult> {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134701);
            j.p(parcel, "source");
            ProfileResult profileResult = new ProfileResult(parcel);
            AppMethodBeat.o(134701);
            return profileResult;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ProfileResult[i];
        }
    }

    static {
        AppMethodBeat.i(134705);
        AppMethodBeat.o(134705);
    }

    public ProfileResult(Parcel parcel) {
        j.p(parcel, "parcel");
        AppMethodBeat.i(134704);
        k(parcel);
        AppMethodBeat.o(134704);
    }

    public final void k(Parcel parcel) {
        AppMethodBeat.i(134702);
        j.p(parcel, "parcel");
        this.bFZ = parcel.readInt();
        this.hUO = parcel.readInt();
        this.username = parcel.readString();
        AppMethodBeat.o(134702);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(134703);
        j.p(parcel, "dest");
        parcel.writeInt(this.bFZ);
        parcel.writeInt(this.hUO);
        parcel.writeString(this.username);
        AppMethodBeat.o(134703);
    }
}
