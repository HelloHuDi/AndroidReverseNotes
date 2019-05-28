package com.tencent.p177mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1930r.C1931a;

/* renamed from: com.tencent.mm.network.j */
public interface C1915j extends IInterface {

    /* renamed from: com.tencent.mm.network.j$a */
    public static abstract class C1916a extends Binder implements C1915j {

        /* renamed from: com.tencent.mm.network.j$a$a */
        static class C1917a implements C1915j {
            private IBinder mRemote;

            C1917a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo5602a(C1930r c1930r, int i, int i2, String str) {
                AppMethodBeat.m2504i(58524);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IOnAutoAuth_AIDL");
                    obtain.writeStrongBinder(c1930r != null ? c1930r.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58524);
                }
            }
        }

        public C1916a() {
            attachInterface(this, "com.tencent.mm.network.IOnAutoAuth_AIDL");
        }

        /* renamed from: o */
        public static C1915j m4116o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IOnAutoAuth_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C1915j)) {
                return new C1917a(iBinder);
            }
            return (C1915j) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IOnAutoAuth_AIDL");
                    mo5602a(C1931a.m4130q(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IOnAutoAuth_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo5602a(C1930r c1930r, int i, int i2, String str);
}
