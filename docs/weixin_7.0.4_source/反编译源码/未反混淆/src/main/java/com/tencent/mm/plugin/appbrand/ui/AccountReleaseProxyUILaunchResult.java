package com.tencent.mm.plugin.appbrand.ui;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014J\u001a\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "readParcel", "", "in", "writeToParcel", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class AccountReleaseProxyUILaunchResult extends ProcessResult {
    public static final a CREATOR = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "plugin-appbrand-integration_release"})
    public static final class a implements Creator<AccountReleaseProxyUILaunchResult> {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(134984);
            j.p(parcel, "parcel");
            AccountReleaseProxyUILaunchResult accountReleaseProxyUILaunchResult = new AccountReleaseProxyUILaunchResult(parcel);
            AppMethodBeat.o(134984);
            return accountReleaseProxyUILaunchResult;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AccountReleaseProxyUILaunchResult[i];
        }
    }

    static {
        AppMethodBeat.i(134986);
        AppMethodBeat.o(134986);
    }

    public AccountReleaseProxyUILaunchResult(Parcel parcel) {
        j.p(parcel, "parcel");
        this();
        AppMethodBeat.i(134985);
        AppMethodBeat.o(134985);
    }

    public final void writeToParcel(Parcel parcel, int i) {
    }

    public final void k(Parcel parcel) {
    }

    public final int describeContents() {
        return 0;
    }
}
