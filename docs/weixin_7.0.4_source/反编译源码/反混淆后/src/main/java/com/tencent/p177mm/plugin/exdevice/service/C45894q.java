package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.exdevice.service.q */
public interface C45894q extends IInterface {

    /* renamed from: com.tencent.mm.plugin.exdevice.service.q$a */
    public static abstract class C27868a extends Binder implements C45894q {

        /* renamed from: com.tencent.mm.plugin.exdevice.service.q$a$a */
        static class C27869a implements C45894q {
            private IBinder mRemote;

            C27869a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo7191a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str) {
                AppMethodBeat.m2504i(19623);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                    obtain.writeDouble(d);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr);
                    obtain.writeDouble(d2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19623);
                }
            }
        }

        public C27868a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                    mo7191a(parcel.readDouble(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readDouble(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo7191a(double d, int i, int i2, byte[] bArr, double d2, int i3, String str);
}
