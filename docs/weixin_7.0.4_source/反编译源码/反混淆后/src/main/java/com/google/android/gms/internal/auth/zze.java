package com.google.android.gms.internal.auth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zze extends Binder implements IInterface {
    private static zzg zzf = null;

    protected zze(String str) {
        AppMethodBeat.m2504i(77117);
        attachInterface(this, str);
        AppMethodBeat.m2505o(77117);
    }

    public IBinder asBinder() {
        return this;
    }

    /* Access modifiers changed, original: protected */
    public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        return false;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean onTransact;
        AppMethodBeat.m2504i(77118);
        if (i > 16777215) {
            onTransact = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            onTransact = false;
        }
        if (onTransact) {
            AppMethodBeat.m2505o(77118);
            return true;
        }
        onTransact = dispatchTransaction(i, parcel, parcel2, i2);
        AppMethodBeat.m2505o(77118);
        return onTransact;
    }
}
