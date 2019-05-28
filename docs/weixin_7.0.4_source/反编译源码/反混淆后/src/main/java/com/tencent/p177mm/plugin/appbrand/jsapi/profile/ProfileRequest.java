package com.tencent.p177mm.plugin.appbrand.jsapi.profile;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\b\u0010¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "scene", "", "getScene$plugin_appbrand_integration_release", "()I", "setScene$plugin_appbrand_integration_release", "(I)V", "username", "", "getUsername$plugin_appbrand_integration_release", "()Ljava/lang/String;", "setUsername$plugin_appbrand_integration_release", "(Ljava/lang/String;)V", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.profile.ProfileRequest */
public final class ProfileRequest extends ProcessRequest {
    public static final C19469a CREATOR = new C19469a();
    int scene = 122;
    String username;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileRequest;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/profile/ProfileRequest;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.profile.ProfileRequest$a */
    public static final class C19469a implements Creator<ProfileRequest> {
        private C19469a() {
        }

        public /* synthetic */ C19469a(byte b) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(134696);
            C25052j.m39376p(parcel, "source");
            ProfileRequest profileRequest = new ProfileRequest(parcel);
            AppMethodBeat.m2505o(134696);
            return profileRequest;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ProfileRequest[i];
        }
    }

    static {
        AppMethodBeat.m2504i(134700);
        AppMethodBeat.m2505o(134700);
    }

    public ProfileRequest(Parcel parcel) {
        C25052j.m39376p(parcel, "parcel");
        AppMethodBeat.m2504i(134699);
        mo6049k(parcel);
        AppMethodBeat.m2505o(134699);
    }

    public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
        return C42567d.class;
    }

    /* renamed from: k */
    public final void mo6049k(Parcel parcel) {
        AppMethodBeat.m2504i(134697);
        C25052j.m39376p(parcel, "parcel");
        this.username = parcel.readString();
        this.scene = parcel.readInt();
        AppMethodBeat.m2505o(134697);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(134698);
        C25052j.m39376p(parcel, "dest");
        parcel.writeString(this.username);
        parcel.writeInt(this.scene);
        AppMethodBeat.m2505o(134698);
    }
}
