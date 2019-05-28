package com.tencent.p177mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.network.g */
public interface C1906g extends IInterface {

    /* renamed from: com.tencent.mm.network.g$a */
    public static abstract class C1907a extends Binder implements C1906g {

        /* renamed from: com.tencent.mm.network.g$a$a */
        static class C1908a implements C1906g {
            private IBinder mRemote;

            C1908a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: gi */
            public final void mo4533gi(int i) {
                AppMethodBeat.m2504i(58517);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IIpxxCallback_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58517);
                }
            }
        }

        public C1907a() {
            attachInterface(this, "com.tencent.mm.network.IIpxxCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IIpxxCallback_AIDL");
                    mo4533gi(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IIpxxCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: gi */
    void mo4533gi(int i);
}
