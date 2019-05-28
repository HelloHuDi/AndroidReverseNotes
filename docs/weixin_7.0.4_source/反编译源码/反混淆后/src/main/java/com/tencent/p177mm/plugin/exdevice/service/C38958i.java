package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.exdevice.service.i */
public interface C38958i extends IInterface {

    /* renamed from: com.tencent.mm.plugin.exdevice.service.i$a */
    public static abstract class C20546a extends Binder implements C38958i {

        /* renamed from: com.tencent.mm.plugin.exdevice.service.i$a$a */
        static class C20545a implements C38958i {
            private IBinder mRemote;

            C20545a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo35821a(int i, long j, int i2, int i3, byte[] bArr) {
                AppMethodBeat.m2504i(19611);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19611);
                }
            }
        }

        public C20546a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
        }

        /* renamed from: v */
        public static C38958i m31749v(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C38958i)) {
                return new C20545a(iBinder);
            }
            return (C38958i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
                    mo35821a(parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTOnDeviceRequest_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo35821a(int i, long j, int i2, int i3, byte[] bArr);
}
