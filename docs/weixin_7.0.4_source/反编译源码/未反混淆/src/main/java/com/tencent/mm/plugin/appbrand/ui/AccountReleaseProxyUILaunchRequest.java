package com.tencent.mm.plugin.appbrand.ui;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0014¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "CREATOR", "plugin-appbrand-integration_release"})
final class AccountReleaseProxyUILaunchRequest extends ProcessRequest {
    public static final a CREATOR = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchRequest;", "plugin-appbrand-integration_release"})
    public static final class a implements Creator<AccountReleaseProxyUILaunchRequest> {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134981);
            j.p(parcel, "parcel");
            AccountReleaseProxyUILaunchRequest accountReleaseProxyUILaunchRequest = new AccountReleaseProxyUILaunchRequest(parcel);
            AppMethodBeat.o(134981);
            return accountReleaseProxyUILaunchRequest;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AccountReleaseProxyUILaunchRequest[i];
        }
    }

    static {
        AppMethodBeat.i(134983);
        AppMethodBeat.o(134983);
    }

    public AccountReleaseProxyUILaunchRequest(Parcel parcel) {
        j.p(parcel, "parcel");
        this();
        AppMethodBeat.i(134982);
        AppMethodBeat.o(134982);
    }

    public final Class<? extends AppBrandProxyUIProcessTask> aCa() {
        return a.class;
    }

    public final int describeContents() {
        return 0;
    }
}
