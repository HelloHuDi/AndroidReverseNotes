package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.exdevice.service.n */
public interface C11658n extends IInterface {

    /* renamed from: com.tencent.mm.plugin.exdevice.service.n$a */
    public static abstract class C11659a extends Binder implements C11658n {

        /* renamed from: com.tencent.mm.plugin.exdevice.service.n$a$a */
        static class C11660a implements C11658n {
            private IBinder mRemote;

            C11660a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: k */
            public final Bundle mo23409k(int i, Bundle bundle) {
                AppMethodBeat.m2504i(19615);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle2;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19615);
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19615);
                }
            }
        }

        public C11659a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    Bundle bundle;
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    bundle = mo23409k(readInt, bundle);
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: k */
    Bundle mo23409k(int i, Bundle bundle);
}
