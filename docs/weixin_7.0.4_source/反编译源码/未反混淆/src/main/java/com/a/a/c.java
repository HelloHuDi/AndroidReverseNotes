package com.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c extends IInterface {

    public static abstract class a extends Binder implements c {

        static class a implements c {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean a(b bVar, int i) {
                boolean z = true;
                AppMethodBeat.i(118226);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118226);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118226);
                }
            }

            public final int a(b bVar, int[] iArr, byte[] bArr) {
                AppMethodBeat.i(118227);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118227);
                }
            }

            public final void a(b bVar) {
                AppMethodBeat.i(118228);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118228);
                }
            }

            public final void b(b bVar) {
                AppMethodBeat.i(118229);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118229);
                }
            }

            public final int[] c(b bVar) {
                AppMethodBeat.i(118230);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int[] createIntArray = obtain2.createIntArray();
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118230);
                }
            }

            public final int[] vS() {
                AppMethodBeat.i(118231);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int[] createIntArray = obtain2.createIntArray();
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118231);
                }
            }

            public final boolean fK(int i) {
                boolean z = false;
                AppMethodBeat.i(118232);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118232);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118232);
                }
            }

            public final int fL(int i) {
                AppMethodBeat.i(118233);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118233);
                }
            }

            public final boolean bm(String str) {
                boolean z = false;
                AppMethodBeat.i(118234);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118234);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118234);
                }
            }

            public final String b(b bVar, int i) {
                AppMethodBeat.i(118235);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118235);
                }
            }

            public final int[] c(b bVar, int i) {
                AppMethodBeat.i(118236);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int[] createIntArray = obtain2.createIntArray();
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118236);
                }
            }

            public final int d(b bVar, int i) {
                AppMethodBeat.i(118237);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118237);
                }
            }

            public final boolean a(b bVar, int i, boolean z) {
                boolean z2 = true;
                AppMethodBeat.i(118238);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    int i2;
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118238);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118238);
                }
            }

            public final long d(b bVar) {
                AppMethodBeat.i(118239);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118239);
                }
            }

            public final int a(b bVar, int[] iArr, byte[] bArr, int i) {
                AppMethodBeat.i(118240);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118240);
                }
            }

            public final byte[] e(b bVar) {
                AppMethodBeat.i(118241);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(118241);
                }
            }
        }

        public static c i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                return new a(iBinder);
            }
            return (c) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean a;
            int[] c;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    a = a(com.a.a.b.a.h(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    i3 = a(com.a.a.b.a.h(parcel.readStrongBinder()), parcel.createIntArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    a(com.a.a.b.a.h(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    b(com.a.a.b.a.h(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    c = c(com.a.a.b.a.h(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeIntArray(c);
                    return true;
                case 6:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    c = vS();
                    parcel2.writeNoException();
                    parcel2.writeIntArray(c);
                    return true;
                case 7:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    a = fK(parcel.readInt());
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    i3 = fL(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    a = bm(parcel.readString());
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    String b = b(com.a.a.b.a.h(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 11:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    c = c(com.a.a.b.a.h(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeIntArray(c);
                    return true;
                case 12:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    i3 = d(com.a.a.b.a.h(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 13:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    b h = com.a.a.b.a.h(parcel.readStrongBinder());
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        a = true;
                    } else {
                        a = false;
                    }
                    a = a(h, readInt, a);
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    long d = d(com.a.a.b.a.h(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeLong(d);
                    return true;
                case 15:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    i3 = a(com.a.a.b.a.h(parcel.readStrongBinder()), parcel.createIntArray(), parcel.createByteArray(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 16:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    byte[] e = e(com.a.a.b.a.h(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeByteArray(e);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.securitymgr.IAuthenticationService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int a(b bVar, int[] iArr, byte[] bArr);

    int a(b bVar, int[] iArr, byte[] bArr, int i);

    void a(b bVar);

    boolean a(b bVar, int i);

    boolean a(b bVar, int i, boolean z);

    String b(b bVar, int i);

    void b(b bVar);

    boolean bm(String str);

    int[] c(b bVar);

    int[] c(b bVar, int i);

    int d(b bVar, int i);

    long d(b bVar);

    byte[] e(b bVar);

    boolean fK(int i);

    int fL(int i);

    int[] vS();
}
