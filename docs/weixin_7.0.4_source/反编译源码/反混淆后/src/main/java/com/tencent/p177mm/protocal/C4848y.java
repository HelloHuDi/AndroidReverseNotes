package com.tencent.p177mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.protocal.y */
public interface C4848y extends IInterface {

    /* renamed from: com.tencent.mm.protocal.y$a */
    public static abstract class C4849a extends Binder implements C4848y {

        /* renamed from: com.tencent.mm.protocal.y$a$a */
        public static class C4850a implements C4848y {
            private IBinder mRemote;

            public C4850a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: Ri */
            public final byte[] mo5195Ri() {
                AppMethodBeat.m2504i(58870);
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
                    AppMethodBeat.m2505o(58870);
                }
            }

            /* renamed from: Rj */
            public final byte[] mo5196Rj() {
                AppMethodBeat.m2504i(58871);
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
                    AppMethodBeat.m2505o(58871);
                }
            }

            /* renamed from: K */
            public final int mo5194K(byte[] bArr) {
                AppMethodBeat.m2504i(58872);
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
                    AppMethodBeat.m2505o(58872);
                }
            }
        }

        public C4849a() {
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
                    Ri = mo5195Ri();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Ri);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    Ri = mo5196Rj();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Ri);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                    int K = mo5194K(parcel.createByteArray());
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

    /* renamed from: K */
    int mo5194K(byte[] bArr);

    /* renamed from: Ri */
    byte[] mo5195Ri();

    /* renamed from: Rj */
    byte[] mo5196Rj();
}
