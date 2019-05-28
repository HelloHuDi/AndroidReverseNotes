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
        AppMethodBeat.m2504i(57527);
        AppMethodBeat.m2505o(57527);
    }

    public MessengerCompat(IBinder iBinder) {
        AppMethodBeat.m2504i(57521);
        if (VERSION.SDK_INT >= 21) {
            this.zzab = new Messenger(iBinder);
            AppMethodBeat.m2505o(57521);
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
        AppMethodBeat.m2505o(57521);
    }

    private final IBinder getBinder() {
        AppMethodBeat.m2504i(57523);
        IBinder binder;
        if (this.zzab != null) {
            binder = this.zzab.getBinder();
            AppMethodBeat.m2505o(57523);
            return binder;
        }
        binder = this.zzby.asBinder();
        AppMethodBeat.m2505o(57523);
        return binder;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        AppMethodBeat.m2504i(57524);
        if (obj == null) {
            AppMethodBeat.m2505o(57524);
        } else {
            try {
                z = getBinder().equals(((MessengerCompat) obj).getBinder());
                AppMethodBeat.m2505o(57524);
            } catch (ClassCastException e) {
                AppMethodBeat.m2505o(57524);
            }
        }
        return z;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(57525);
        int hashCode = getBinder().hashCode();
        AppMethodBeat.m2505o(57525);
        return hashCode;
    }

    public final void send(Message message) {
        AppMethodBeat.m2504i(57522);
        if (this.zzab != null) {
            this.zzab.send(message);
            AppMethodBeat.m2505o(57522);
            return;
        }
        this.zzby.send(message);
        AppMethodBeat.m2505o(57522);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(57526);
        if (this.zzab != null) {
            parcel.writeStrongBinder(this.zzab.getBinder());
            AppMethodBeat.m2505o(57526);
            return;
        }
        parcel.writeStrongBinder(this.zzby.asBinder());
        AppMethodBeat.m2505o(57526);
    }
}
