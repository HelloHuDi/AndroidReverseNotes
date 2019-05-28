package com.tencent.p177mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.network.n */
public interface C1923n extends IInterface {

    /* renamed from: com.tencent.mm.network.n$a */
    public static abstract class C1924a extends Binder implements C1923n {

        /* renamed from: com.tencent.mm.network.n$a$a */
        static class C1925a implements C1923n {
            private IBinder mRemote;

            C1925a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: gl */
            public final void mo5192gl(int i) {
                AppMethodBeat.m2504i(58526);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IOnNetworkChange_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58526);
                }
            }
        }

        public C1924a() {
            attachInterface(this, "com.tencent.mm.network.IOnNetworkChange_AIDL");
        }

        /* renamed from: p */
        public static C1923n m4123p(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IOnNetworkChange_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C1923n)) {
                return new C1925a(iBinder);
            }
            return (C1923n) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IOnNetworkChange_AIDL");
                    mo5192gl(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IOnNetworkChange_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: gl */
    void mo5192gl(int i);
}
