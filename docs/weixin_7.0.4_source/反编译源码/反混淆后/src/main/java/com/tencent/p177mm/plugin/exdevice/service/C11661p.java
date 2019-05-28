package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.service.C27863l.C27864a;
import com.tencent.p177mm.plugin.exdevice.service.C27866o.C27867a;

/* renamed from: com.tencent.mm.plugin.exdevice.service.p */
public interface C11661p extends IInterface {

    /* renamed from: com.tencent.mm.plugin.exdevice.service.p$a */
    public static abstract class C11662a extends Binder implements C11661p {

        /* renamed from: com.tencent.mm.plugin.exdevice.service.p$a$a */
        static class C11663a implements C11661p {
            private IBinder mRemote;

            C11663a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final C27866o bpu() {
                AppMethodBeat.m2504i(19621);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    C27866o z = C27867a.m44325z(obtain2.readStrongBinder());
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19621);
                }
            }

            public final C27863l bpv() {
                AppMethodBeat.m2504i(19622);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    C27863l y = C27864a.m44313y(obtain2.readStrongBinder());
                    return y;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19622);
                }
            }
        }

        public C11662a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
        }

        /* renamed from: A */
        public static C11661p m19474A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C11661p)) {
                return new C11663a(iBinder);
            }
            return (C11661p) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    C27866o bpu = bpu();
                    parcel2.writeNoException();
                    if (bpu != null) {
                        iBinder = bpu.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    C27863l bpv = bpv();
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

    C27866o bpu();

    C27863l bpv();
}
