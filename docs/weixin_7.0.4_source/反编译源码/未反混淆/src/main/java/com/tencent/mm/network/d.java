package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        static class a implements d {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final void reset() {
                AppMethodBeat.i(58460);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58460);
                }
            }

            public final void a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
                AppMethodBeat.i(58461);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    obtain.writeByteArray(bArr3);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58461);
                }
            }

            public final void hB(int i) {
                AppMethodBeat.i(58462);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58462);
                }
            }

            public final void setUsername(String str) {
                AppMethodBeat.i(58463);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58463);
                }
            }

            public final void ab(byte[] bArr) {
                AppMethodBeat.i(58464);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58464);
                }
            }

            public final void ac(byte[] bArr) {
                AppMethodBeat.i(58465);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58465);
                }
            }

            public final String getUsername() {
                AppMethodBeat.i(58466);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58466);
                }
            }

            public final byte[] jQ(int i) {
                AppMethodBeat.i(58467);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58467);
                }
            }

            public final byte[] ada() {
                AppMethodBeat.i(58468);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58468);
                }
            }

            public final byte[] adc() {
                AppMethodBeat.i(58469);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58469);
                }
            }

            public final int QF() {
                AppMethodBeat.i(58470);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58470);
                }
            }

            public final boolean adb() {
                boolean z = false;
                AppMethodBeat.i(58471);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58471);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58471);
                }
            }

            public final void o(String str, byte[] bArr) {
                AppMethodBeat.i(58472);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58472);
                }
            }

            public final byte[] qr(String str) {
                AppMethodBeat.i(58473);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58473);
                }
            }

            public final void cE(boolean z) {
                int i = 0;
                AppMethodBeat.i(58474);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58474);
                }
            }

            public final boolean ade() {
                boolean z = false;
                AppMethodBeat.i(58475);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58475);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58475);
                }
            }

            public final String adD() {
                AppMethodBeat.i(58476);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58476);
                }
            }

            public final void va(String str) {
                AppMethodBeat.i(58477);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58477);
                }
            }

            public final int S(byte[] bArr) {
                AppMethodBeat.i(58478);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58478);
                }
            }

            public final byte[] adf() {
                AppMethodBeat.i(58479);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IAccInfo_AIDL");
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58479);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.network.IAccInfo_AIDL");
        }

        public static d l(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IAccInfo_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            String username;
            byte[] jQ;
            boolean adb;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    reset();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    a(parcel.createByteArray(), parcel.createByteArray(), parcel.createByteArray(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    hB(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    setUsername(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    ab(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    ac(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    username = getUsername();
                    parcel2.writeNoException();
                    parcel2.writeString(username);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    jQ = jQ(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(jQ);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    jQ = ada();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(jQ);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    jQ = adc();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(jQ);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    i3 = QF();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    adb = adb();
                    parcel2.writeNoException();
                    if (adb) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    o(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    jQ = qr(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(jQ);
                    return true;
                case 15:
                    boolean z;
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    cE(z);
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    adb = ade();
                    parcel2.writeNoException();
                    if (adb) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    username = adD();
                    parcel2.writeNoException();
                    parcel2.writeString(username);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    va(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    i3 = S(parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.network.IAccInfo_AIDL");
                    jQ = adf();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(jQ);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IAccInfo_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int QF();

    int S(byte[] bArr);

    void a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    void ab(byte[] bArr);

    void ac(byte[] bArr);

    String adD();

    byte[] ada();

    boolean adb();

    byte[] adc();

    boolean ade();

    byte[] adf();

    void cE(boolean z);

    String getUsername();

    void hB(int i);

    byte[] jQ(int i);

    void o(String str, byte[] bArr);

    byte[] qr(String str);

    void reset();

    void setUsername(String str);

    void va(String str);
}
