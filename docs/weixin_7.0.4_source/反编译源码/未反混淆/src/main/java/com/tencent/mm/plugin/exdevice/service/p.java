package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface p extends IInterface {

    public static abstract class a extends Binder implements p {

        static class a implements p {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final o bpu() {
                AppMethodBeat.i(19621);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    o z = com.tencent.mm.plugin.exdevice.service.o.a.z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19621);
                }
            }

            public final l bpv() {
                AppMethodBeat.i(19622);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    l y = com.tencent.mm.plugin.exdevice.service.l.a.y(obtain2.readStrongBinder());
                    return y;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19622);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
        }

        public static p A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof p)) {
                return new a(iBinder);
            }
            return (p) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    o bpu = bpu();
                    parcel2.writeNoException();
                    if (bpu != null) {
                        iBinder = bpu.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    l bpv = bpv();
                    parcel2.writeNoException();
                    if (bpv != null) {
                        iBinder = bpv.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    o bpu();

    l bpv();
}
