package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.firebase_messaging.zze;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzi implements Parcelable {
    public static final Creator<zzi> CREATOR = new z();
    private Messenger bwC;
    private zze bwD;

    public static final class a extends ClassLoader {
        /* Access modifiers changed, original: protected|final */
        public final Class<?> loadClass(String str, boolean z) {
            AppMethodBeat.i(108784);
            Class cls;
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                FirebaseInstanceId.uH();
                cls = zzi.class;
                AppMethodBeat.o(108784);
                return cls;
            }
            cls = super.loadClass(str, z);
            AppMethodBeat.o(108784);
            return cls;
        }
    }

    static {
        AppMethodBeat.i(108791);
        AppMethodBeat.o(108791);
    }

    public zzi(IBinder iBinder) {
        AppMethodBeat.i(108785);
        if (VERSION.SDK_INT >= 21) {
            this.bwC = new Messenger(iBinder);
            AppMethodBeat.o(108785);
            return;
        }
        this.bwD = zzf.zza(iBinder);
        AppMethodBeat.o(108785);
    }

    private final IBinder getBinder() {
        AppMethodBeat.i(108787);
        IBinder binder;
        if (this.bwC != null) {
            binder = this.bwC.getBinder();
            AppMethodBeat.o(108787);
            return binder;
        }
        binder = this.bwD.asBinder();
        AppMethodBeat.o(108787);
        return binder;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        AppMethodBeat.i(108788);
        if (obj == null) {
            AppMethodBeat.o(108788);
        } else {
            try {
                z = getBinder().equals(((zzi) obj).getBinder());
                AppMethodBeat.o(108788);
            } catch (ClassCastException e) {
                AppMethodBeat.o(108788);
            }
        }
        return z;
    }

    public int hashCode() {
        AppMethodBeat.i(108789);
        int hashCode = getBinder().hashCode();
        AppMethodBeat.o(108789);
        return hashCode;
    }

    public final void send(Message message) {
        AppMethodBeat.i(108786);
        if (this.bwC != null) {
            this.bwC.send(message);
            AppMethodBeat.o(108786);
            return;
        }
        this.bwD.send(message);
        AppMethodBeat.o(108786);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(108790);
        if (this.bwC != null) {
            parcel.writeStrongBinder(this.bwC.getBinder());
            AppMethodBeat.o(108790);
            return;
        }
        parcel.writeStrongBinder(this.bwD.asBinder());
        AppMethodBeat.o(108790);
    }
}
