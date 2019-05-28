package com.google.android.gms.internal.stable;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzb extends Binder implements IInterface {
    private static zzd zzc = null;

    protected zzb(String str) {
        AppMethodBeat.m2504i(90461);
        attachInterface(this, str);
        AppMethodBeat.m2505o(90461);
    }

    public IBinder asBinder() {
        return this;
    }

    /* Access modifiers changed, original: protected */
    public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        return false;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        AppMethodBeat.m2504i(90463);
        if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
            AppMethodBeat.m2505o(90463);
            return true;
        }
        boolean dispatchTransaction = dispatchTransaction(i, parcel, parcel2, i2);
        AppMethodBeat.m2505o(90463);
        return dispatchTransaction;
    }

    /* Access modifiers changed, original: protected */
    public boolean routeToSuperOrEnforceInterface(int i, Parcel parcel, Parcel parcel2, int i2) {
        AppMethodBeat.m2504i(90462);
        if (i > 16777215) {
            boolean onTransact = super.onTransact(i, parcel, parcel2, i2);
            AppMethodBeat.m2505o(90462);
            return onTransact;
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        AppMethodBeat.m2505o(90462);
        return false;
    }
}
