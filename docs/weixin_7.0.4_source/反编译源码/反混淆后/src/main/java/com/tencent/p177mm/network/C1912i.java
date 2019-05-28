package com.tencent.p177mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1923n.C1924a;

/* renamed from: com.tencent.mm.network.i */
public interface C1912i extends IInterface {

    /* renamed from: com.tencent.mm.network.i$a */
    public static abstract class C1913a extends Binder implements C1912i {

        /* renamed from: com.tencent.mm.network.i$a$a */
        static class C1914a implements C1912i {
            private IBinder mRemote;

            C1914a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int amP() {
                AppMethodBeat.m2504i(58519);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58519);
                }
            }

            /* renamed from: c */
            public final boolean mo5597c(C1923n c1923n) {
                boolean z = false;
                AppMethodBeat.m2504i(58520);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    obtain.writeStrongBinder(c1923n != null ? c1923n.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58520);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58520);
                }
            }

            /* renamed from: d */
            public final boolean mo5598d(C1923n c1923n) {
                boolean z = false;
                AppMethodBeat.m2504i(58521);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    obtain.writeStrongBinder(c1923n != null ? c1923n.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58521);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58521);
                }
            }

            public final void amQ() {
                AppMethodBeat.m2504i(58522);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58522);
                }
            }

            public final long amR() {
                AppMethodBeat.m2504i(58523);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58523);
                }
            }
        }

        public C1913a() {
            attachInterface(this, "com.tencent.mm.network.INetworkEvent_AIDL");
        }

        /* renamed from: n */
        public static C1912i m4112n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.INetworkEvent_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C1912i)) {
                return new C1914a(iBinder);
            }
            return (C1912i) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean c;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    i3 = amP();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    c = mo5597c(C1924a.m4123p(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    c = mo5598d(C1924a.m4123p(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    amQ();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    long amR = amR();
                    parcel2.writeNoException();
                    parcel2.writeLong(amR);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.INetworkEvent_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int amP();

    void amQ();

    long amR();

    /* renamed from: c */
    boolean mo5597c(C1923n c1923n);

    /* renamed from: d */
    boolean mo5598d(C1923n c1923n);
}
