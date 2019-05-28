package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface i extends IInterface {

    public static abstract class a extends Binder implements i {

        static class a implements i {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int amP() {
                AppMethodBeat.i(58519);
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
                    AppMethodBeat.o(58519);
                }
            }

            public final boolean c(n nVar) {
                boolean z = false;
                AppMethodBeat.i(58520);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58520);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58520);
                }
            }

            public final boolean d(n nVar) {
                boolean z = false;
                AppMethodBeat.i(58521);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58521);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58521);
                }
            }

            public final void amQ() {
                AppMethodBeat.i(58522);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58522);
                }
            }

            public final long amR() {
                AppMethodBeat.i(58523);
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
                    AppMethodBeat.o(58523);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.network.INetworkEvent_AIDL");
        }

        public static i n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.INetworkEvent_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof i)) {
                return new a(iBinder);
            }
            return (i) queryLocalInterface;
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
                    c = c(com.tencent.mm.network.n.a.p(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (c) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
                    c = d(com.tencent.mm.network.n.a.p(parcel.readStrongBinder()));
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

    boolean c(n nVar);

    boolean d(n nVar);
}
