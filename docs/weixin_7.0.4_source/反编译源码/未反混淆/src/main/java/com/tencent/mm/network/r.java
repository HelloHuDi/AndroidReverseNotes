package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;

public interface r extends IInterface {

    public static abstract class a extends Binder implements r {

        static class a implements r {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int getType() {
                AppMethodBeat.i(58536);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58536);
                }
            }

            public final String getUri() {
                AppMethodBeat.i(58537);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58537);
                }
            }

            public final i adu() {
                AppMethodBeat.i(58538);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    i K = com.tencent.mm.protocal.i.a.K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58538);
                }
            }

            public final h adt() {
                AppMethodBeat.i(58539);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    h J = com.tencent.mm.protocal.h.a.J(obtain2.readStrongBinder());
                    return J;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58539);
                }
            }

            public final void a(j jVar, int i, int i2) {
                AppMethodBeat.i(58540);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58540);
                }
            }

            public final int acO() {
                AppMethodBeat.i(58541);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58541);
                }
            }

            public final boolean acG() {
                boolean z = false;
                AppMethodBeat.i(58542);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58542);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58542);
                }
            }

            public final int acC() {
                AppMethodBeat.i(58543);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58543);
                }
            }

            public final void qw(String str) {
                AppMethodBeat.i(58544);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58544);
                }
            }

            public final void a(j jVar, int i, int i2, String str) {
                AppMethodBeat.i(58545);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58545);
                }
            }

            public final void a(d dVar, j jVar, int i, int i2) {
                IBinder iBinder = null;
                AppMethodBeat.i(58546);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (jVar != null) {
                        iBinder = jVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58546);
                }
            }

            public final int adv() {
                AppMethodBeat.i(58547);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58547);
                }
            }

            public final int acB() {
                AppMethodBeat.i(58548);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58548);
                }
            }

            public final boolean acH() {
                boolean z = false;
                AppMethodBeat.i(58549);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58549);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58549);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.network.IReqResp_AIDL");
        }

        public static r q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IReqResp_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof r)) {
                return new a(iBinder);
            }
            return (r) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            int i3 = 0;
            int type;
            boolean acG;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    type = getType();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    String uri = getUri();
                    parcel2.writeNoException();
                    parcel2.writeString(uri);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    i adu = adu();
                    parcel2.writeNoException();
                    if (adu != null) {
                        iBinder = adu.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    h adt = adt();
                    parcel2.writeNoException();
                    if (adt != null) {
                        iBinder = adt.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    a(com.tencent.mm.network.j.a.o(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    type = acO();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    acG = acG();
                    parcel2.writeNoException();
                    parcel2.writeInt(acG ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    type = acC();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    qw(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    a(com.tencent.mm.network.j.a.o(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    a(com.tencent.mm.network.d.a.l(parcel.readStrongBinder()), com.tencent.mm.network.j.a.o(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    type = adv();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    type = acB();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    acG = acH();
                    parcel2.writeNoException();
                    if (acG) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IReqResp_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(d dVar, j jVar, int i, int i2);

    void a(j jVar, int i, int i2);

    void a(j jVar, int i, int i2, String str);

    int acB();

    int acC();

    boolean acG();

    boolean acH();

    int acO();

    h adt();

    i adu();

    int adv();

    int getType();

    String getUri();

    void qw(String str);
}
