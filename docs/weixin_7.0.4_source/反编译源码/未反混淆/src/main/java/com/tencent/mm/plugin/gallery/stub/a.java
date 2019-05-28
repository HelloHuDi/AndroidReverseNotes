package com.tencent.mm.plugin.gallery.stub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a extends IInterface {

    public static abstract class a extends Binder implements a {

        static class a implements a {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final void aK(int i, String str) {
                AppMethodBeat.i(21351);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(21351);
                }
            }

            public final void bCv() {
                AppMethodBeat.i(21352);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(21352);
                }
            }

            public final int Nd() {
                AppMethodBeat.i(21353);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(21353);
                }
            }

            public final void a(String str, String str2, boolean z, int i, boolean z2) {
                int i2 = 1;
                AppMethodBeat.i(21354);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(21354);
                }
            }

            public final int Nb() {
                AppMethodBeat.i(21355);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(21355);
                }
            }

            public final int Na() {
                AppMethodBeat.i(21356);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(21356);
                }
            }

            public final boolean hC(boolean z) {
                boolean z2 = true;
                AppMethodBeat.i(21357);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(21357);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(21357);
                }
            }

            public final int ND(String str) {
                AppMethodBeat.i(21358);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(21358);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
        }

        public static a B(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    aK(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    bCv();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = Nd();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    boolean z;
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    boolean z2 = parcel.readInt() != 0;
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a(readString, readString2, z2, readInt, z);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = Nb();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = Na();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 7:
                    boolean z3;
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    if (parcel.readInt() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z3 = hC(z3);
                    parcel2.writeNoException();
                    if (z3) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = ND(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int ND(String str);

    int Na();

    int Nb();

    int Nd();

    void a(String str, String str2, boolean z, int i, boolean z2);

    void aK(int i, String str);

    void bCv();

    boolean hC(boolean z);
}
