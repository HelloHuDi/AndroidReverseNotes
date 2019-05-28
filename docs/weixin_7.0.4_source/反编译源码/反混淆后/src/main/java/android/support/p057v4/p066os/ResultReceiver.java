package android.support.p057v4.p066os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.p057v4.p066os.C41513b.C0430a;

/* renamed from: android.support.v4.os.ResultReceiver */
public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new C174501();
    /* renamed from: JZ */
    final boolean f3928JZ = false;
    /* renamed from: Ka */
    C41513b f3929Ka;
    final Handler mHandler = null;

    /* renamed from: android.support.v4.os.ResultReceiver$a */
    class C17448a extends C0430a {
        C17448a() {
        }

        public final void send(int i, Bundle bundle) {
            if (ResultReceiver.this.mHandler != null) {
                ResultReceiver.this.mHandler.post(new C17449b(i, bundle));
            } else {
                ResultReceiver.this.onReceiveResult(i, bundle);
            }
        }
    }

    /* renamed from: android.support.v4.os.ResultReceiver$b */
    class C17449b implements Runnable {
        /* renamed from: Kc */
        final int f3926Kc;
        /* renamed from: Kd */
        final Bundle f3927Kd;

        C17449b(int i, Bundle bundle) {
            this.f3926Kc = i;
            this.f3927Kd = bundle;
        }

        public final void run() {
            ResultReceiver.this.onReceiveResult(this.f3926Kc, this.f3927Kd);
        }
    }

    /* renamed from: android.support.v4.os.ResultReceiver$1 */
    static class C174501 implements Creator<ResultReceiver> {
        C174501() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ResultReceiver[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }
    }

    public final void send(int i, Bundle bundle) {
        if (this.f3928JZ) {
            if (this.mHandler != null) {
                this.mHandler.post(new C17449b(i, bundle));
            } else {
                onReceiveResult(i, bundle);
            }
        } else if (this.f3929Ka != null) {
            try {
                this.f3929Ka.send(i, bundle);
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
            if (this.f3929Ka == null) {
                this.f3929Ka = new C17448a();
            }
            parcel.writeStrongBinder(this.f3929Ka.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f3929Ka = C0430a.m762e(parcel.readStrongBinder());
    }
}
