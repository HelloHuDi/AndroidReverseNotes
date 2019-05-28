package com.tencent.p177mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1930r.C1931a;

/* renamed from: com.tencent.mm.network.l */
public interface C1919l extends IInterface {

    /* renamed from: com.tencent.mm.network.l$a */
    public static abstract class C1920a extends Binder implements C1919l {

        /* renamed from: com.tencent.mm.network.l$a$a */
        static class C1921a implements C1919l {
            private IBinder mRemote;

            C1921a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo5606a(int i, int i2, int i3, String str, C1930r c1930r, byte[] bArr) {
                AppMethodBeat.m2504i(58525);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c1930r != null ? c1930r.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58525);
                }
            }
        }

        public C1920a() {
            attachInterface(this, "com.tencent.mm.network.IOnGYNetEnd_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                    mo5606a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), C1931a.m4130q(parcel.readStrongBinder()), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo5606a(int i, int i2, int i3, String str, C1930r c1930r, byte[] bArr);
}
