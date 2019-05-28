package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new zza();
    private IBinder zzry;

    static {
        AppMethodBeat.m2504i(89584);
        AppMethodBeat.m2505o(89584);
    }

    public BinderWrapper() {
        this.zzry = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzry = null;
        this.zzry = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        AppMethodBeat.m2504i(89582);
        this.zzry = null;
        this.zzry = parcel.readStrongBinder();
        AppMethodBeat.m2505o(89582);
    }

    /* synthetic */ BinderWrapper(Parcel parcel, zza zza) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final IBinder getBinder() {
        return this.zzry;
    }

    public final void setBinder(IBinder iBinder) {
        this.zzry = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(89583);
        parcel.writeStrongBinder(this.zzry);
        AppMethodBeat.m2505o(89583);
    }
}
