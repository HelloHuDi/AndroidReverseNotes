package com.tencent.soter.soterserver;

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

            public final int Re(int i) {
                AppMethodBeat.i(73091);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73091);
                }
            }

            public final SoterExportResult Rf(int i) {
                AppMethodBeat.i(73092);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    SoterExportResult soterExportResult;
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExportResult = (SoterExportResult) SoterExportResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExportResult = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73092);
                    return soterExportResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73092);
                }
            }

            public final boolean Rg(int i) {
                boolean z = false;
                AppMethodBeat.i(73093);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73093);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73093);
                }
            }

            public final int bS(int i, String str) {
                AppMethodBeat.i(73094);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73094);
                }
            }

            public final int bT(int i, String str) {
                AppMethodBeat.i(73095);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73095);
                }
            }

            public final SoterExportResult bU(int i, String str) {
                AppMethodBeat.i(73096);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    SoterExportResult soterExportResult;
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterExportResult = (SoterExportResult) SoterExportResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterExportResult = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73096);
                    return soterExportResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73096);
                }
            }

            public final int Rh(int i) {
                AppMethodBeat.i(73097);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73097);
                }
            }

            public final boolean bV(int i, String str) {
                boolean z = false;
                AppMethodBeat.i(73098);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73098);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73098);
                }
            }

            public final SoterSessionResult O(int i, String str, String str2) {
                AppMethodBeat.i(73099);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    SoterSessionResult soterSessionResult;
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterSessionResult = (SoterSessionResult) SoterSessionResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterSessionResult = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73099);
                    return soterSessionResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73099);
                }
            }

            public final SoterSignResult nD(long j) {
                AppMethodBeat.i(73100);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    SoterSignResult soterSignResult;
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    obtain.writeLong(j);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterSignResult = (SoterSignResult) SoterSignResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterSignResult = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73100);
                    return soterSignResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73100);
                }
            }

            public final SoterDeviceResult dRb() {
                AppMethodBeat.i(73101);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    SoterDeviceResult soterDeviceResult;
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        soterDeviceResult = (SoterDeviceResult) SoterDeviceResult.CREATOR.createFromParcel(obtain2);
                    } else {
                        soterDeviceResult = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73101);
                    return soterDeviceResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73101);
                }
            }

            public final int getVersion() {
                AppMethodBeat.i(73102);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.soter.soterserver.ISoterService");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(73102);
                }
            }
        }

        public static a O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.soter.soterserver.ISoterService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            SoterExportResult Rf;
            boolean Rg;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    i3 = Re(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    Rf = Rf(parcel.readInt());
                    parcel2.writeNoException();
                    if (Rf != null) {
                        parcel2.writeInt(1);
                        Rf.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    Rg = Rg(parcel.readInt());
                    parcel2.writeNoException();
                    if (Rg) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    i3 = bS(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    i3 = bT(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    Rf = bU(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (Rf != null) {
                        parcel2.writeInt(1);
                        Rf.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    i3 = Rh(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    Rg = bV(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (Rg) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    SoterSessionResult O = O(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (O != null) {
                        parcel2.writeInt(1);
                        O.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    SoterSignResult nD = nD(parcel.readLong());
                    parcel2.writeNoException();
                    if (nD != null) {
                        parcel2.writeInt(1);
                        nD.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    SoterDeviceResult dRb = dRb();
                    parcel2.writeNoException();
                    if (dRb != null) {
                        parcel2.writeInt(1);
                        dRb.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    i3 = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.soter.soterserver.ISoterService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    SoterSessionResult O(int i, String str, String str2);

    int Re(int i);

    SoterExportResult Rf(int i);

    boolean Rg(int i);

    int Rh(int i);

    int bS(int i, String str);

    int bT(int i, String str);

    SoterExportResult bU(int i, String str);

    boolean bV(int i, String str);

    SoterDeviceResult dRb();

    int getVersion();

    SoterSignResult nD(long j);
}
