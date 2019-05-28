package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new Creator<ResultReceiver>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ResultReceiver[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }
    };
    final boolean JZ = false;
    b Ka;
    final Handler mHandler = null;

    class a extends android.support.v4.os.b.a {
        a() {
        }

        public final void send(int i, Bundle bundle) {
            if (ResultReceiver.this.mHandler != null) {
                ResultReceiver.this.mHandler.post(new b(i, bundle));
            } else {
                ResultReceiver.this.onReceiveResult(i, bundle);
            }
        }
    }

    class b implements Runnable {
        final int Kc;
        final Bundle Kd;

        b(int i, Bundle bundle) {
            this.Kc = i;
            this.Kd = bundle;
        }

        public final void run() {
            ResultReceiver.this.onReceiveResult(this.Kc, this.Kd);
        }
    }

    public final void send(int i, Bundle bundle) {
        if (this.JZ) {
            if (this.mHandler != null) {
                this.mHandler.post(new b(i, bundle));
            } else {
                onReceiveResult(i, bundle);
            }
        } else if (this.Ka != null) {
            try {
                this.Ka.send(i, bundle);
            } catch (RemoteException e) {
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onReceiveResult(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.Ka == null) {
                this.Ka = new a();
            }
            parcel.writeStrongBinder(this.Ka.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.Ka = android.support.v4.os.b.a.e(parcel.readStrongBinder());
    }
}
