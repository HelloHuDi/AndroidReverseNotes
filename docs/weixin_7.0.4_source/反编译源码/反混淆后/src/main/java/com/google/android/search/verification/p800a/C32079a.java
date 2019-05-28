package com.google.android.search.verification.p800a;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.search.verification.a.a */
public interface C32079a extends IInterface {

    /* renamed from: com.google.android.search.verification.a.a$a */
    public static abstract class C8724a extends Binder implements C32079a {

        /* renamed from: com.google.android.search.verification.a.a$a$a */
        static class C8725a implements C32079a {
            private IBinder mRemote;

            C8725a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final boolean mo19731a(Intent intent, Bundle bundle) {
                boolean z = true;
                AppMethodBeat.m2504i(94129);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(94129);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(94129);
                }
            }

            public final int getVersion() {
                AppMethodBeat.m2504i(94130);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(94130);
                }
            }
        }

        /* renamed from: g */
        public static C32079a m15530g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C32079a)) {
                return new C8725a(iBinder);
            }
            return (C32079a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3;
            switch (i) {
                case 1:
                    Intent intent;
                    Bundle bundle;
                    parcel.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent = null;
                    }
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    boolean a = mo19731a(intent, bundle);
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
                    i3 = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.search.verification.api.ISearchActionVerificationService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    boolean mo19731a(Intent intent, Bundle bundle);

    int getVersion();
}
