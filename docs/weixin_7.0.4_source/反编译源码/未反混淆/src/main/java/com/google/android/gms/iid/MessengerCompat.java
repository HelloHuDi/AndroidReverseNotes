package com.google.android.gms.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MessengerCompat implements ReflectedParcelable {
    public static final Creator<MessengerCompat> CREATOR = new zzq();
    private Messenger zzab;
    private zzl zzby;

    static {
        AppMethodBeat.i(57527);
        AppMethodBeat.o(57527);
    }

    public MessengerCompat(IBinder iBinder) {
        AppMethodBeat.i(57521);
        if (VERSION.SDK_INT >= 21) {
            this.zzab = new Messenger(iBinder);
            AppMethodBeat.o(57521);
            return;
        }
        zzl zzl;
        if (iBinder == null) {
            zzl = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            zzl = queryLocalInterface instanceof zzl ? (zzl) queryLocalInterface : new zzm(iBinder);
        }
        this.zzby = zzl;
        AppMethodBeat.o(57521);
    }

    private final IBinder getBinder() {
        AppMethodBeat.i(57523);
        IBinder binder;
        if (this.zzab != null) {
            binder = this.zzab.getBinder();
            AppMethodBeat.o(57523);
            return binder;
        }
        binder = this.zzby.asBinder();
        AppMethodBeat.o(57523);
        return binder;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        AppMethodBeat.i(57524);
        if (obj == null) {
            AppMethodBeat.o(57524);
        } else {
            try {
                z = getBinder().equals(((MessengerCompat) obj).getBinder());
                AppMethodBeat.o(57524);
            } catch (ClassCastException e) {
                AppMethodBeat.o(57524);
            }
        }
        return z;
    }

    public int hashCode() {
        AppMethodBeat.i(57525);
        int hashCode = getBinder().hashCode();
        AppMethodBeat.o(57525);
        return hashCode;
    }

    public final void send(Message message) {
        AppMethodBeat.i(57522);
        if (this.zzab != null) {
            this.zzab.send(message);
            AppMethodBeat.o(57522);
            return;
        }
        this.zzby.send(message);
        AppMethodBeat.o(57522);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(57526);
        if (this.zzab != null) {
            parcel.writeStrongBinder(this.zzab.getBinder());
            AppMethodBeat.o(57526);
            return;
        }
        parcel.writeStrongBinder(this.zzby.asBinder());
        AppMethodBeat.o(57526);
    }
}
