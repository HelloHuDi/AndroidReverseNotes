package com.tencent.p177mm.network.p265a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.network.a.b */
public interface C1889b extends IInterface {

    /* renamed from: com.tencent.mm.network.a.b$a */
    public static abstract class C1890a extends Binder implements C1889b {

        /* renamed from: com.tencent.mm.network.a.b$a$a */
        public static class C1891a implements C1889b {
            private IBinder mRemote;

            public C1891a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo5474a(int i, int i2, String str, int i3, String str2, boolean z) {
                int i4 = 1;
                AppMethodBeat.m2504i(58713);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    obtain.writeString(str2);
                    if (!z) {
                        i4 = 0;
                    }
                    obtain.writeInt(i4);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58713);
                }
            }

            /* renamed from: u */
            public final void mo5475u(int i, int i2, int i3, int i4) {
                AppMethodBeat.m2504i(58714);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58714);
                }
            }
        }

        public C1890a() {
            attachInterface(this, "com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    mo5474a(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    mo5475u(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo5474a(int i, int i2, String str, int i3, String str2, boolean z);

    /* renamed from: u */
    void mo5475u(int i, int i2, int i3, int i4);
}
