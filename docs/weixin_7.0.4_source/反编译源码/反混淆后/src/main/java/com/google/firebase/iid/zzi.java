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
    public static final Creator<zzi> CREATOR = new C41653z();
    private Messenger bwC;
    private zze bwD;

    /* renamed from: com.google.firebase.iid.zzi$a */
    public static final class C25588a extends ClassLoader {
        /* Access modifiers changed, original: protected|final */
        public final Class<?> loadClass(String str, boolean z) {
            AppMethodBeat.m2504i(108784);
            Class cls;
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                FirebaseInstanceId.m40569uH();
                cls = zzi.class;
                AppMethodBeat.m2505o(108784);
                return cls;
            }
            cls = super.loadClass(str, z);
            AppMethodBeat.m2505o(108784);
            return cls;
        }
    }

    static {
        AppMethodBeat.m2504i(108791);
        AppMethodBeat.m2505o(108791);
    }

    public zzi(IBinder iBinder) {
        AppMethodBeat.m2504i(108785);
        if (VERSION.SDK_INT >= 21) {
            this.bwC = new Messenger(iBinder);
            AppMethodBeat.m2505o(108785);
            return;
        }
        this.bwD = zzf.zza(iBinder);
        AppMethodBeat.m2505o(108785);
    }

    private final IBinder getBinder() {
        AppMethodBeat.m2504i(108787);
        IBinder binder;
        if (this.bwC != null) {
            binder = this.bwC.getBinder();
            AppMethodBeat.m2505o(108787);
            return binder;
        }
        binder = this.bwD.asBinder();
        AppMethodBeat.m2505o(108787);
        return binder;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        AppMethodBeat.m2504i(108788);
        if (obj == null) {
            AppMethodBeat.m2505o(108788);
        } else {
            try {
                z = getBinder().equals(((zzi) obj).getBinder());
                AppMethodBeat.m2505o(108788);
            } catch (ClassCastException e) {
                AppMethodBeat.m2505o(108788);
            }
        }
        return z;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(108789);
        int hashCode = getBinder().hashCode();
        AppMethodBeat.m2505o(108789);
        return hashCode;
    }

    public final void send(Message message) {
        AppMethodBeat.m2504i(108786);
        if (this.bwC != null) {
            this.bwC.send(message);
            AppMethodBeat.m2505o(108786);
            return;
        }
        this.bwD.send(message);
        AppMethodBeat.m2505o(108786);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(108790);
        if (this.bwC != null) {
            parcel.writeStrongBinder(this.bwC.getBinder());
            AppMethodBeat.m2505o(108790);
            return;
        }
        parcel.writeStrongBinder(this.bwD.asBinder());
        AppMethodBeat.m2505o(108790);
    }
}
