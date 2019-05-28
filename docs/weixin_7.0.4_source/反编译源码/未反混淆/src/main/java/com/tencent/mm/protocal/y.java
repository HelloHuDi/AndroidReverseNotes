package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface y extends IInterface {

    public static abstract class a extends Binder implements y {

        public static class a implements y {
            private IBinder mRemote;

            public a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final byte[] Ri() {
                AppMethodBeat.i(58870);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58870);
                }
            }

            public final byte[] Rj() {
                AppMethodBeat.i(58871);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58871);
                }
            }

            public final int K(byte[] bArr) {
                AppMethodBeat.i(58872);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58872);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            byte[] Ri;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    Ri = Ri();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Ri);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    Ri = Rj();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Ri);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    int K = K(parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(K);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int K(byte[] bArr);

    byte[] Ri();

    byte[] Rj();
}
