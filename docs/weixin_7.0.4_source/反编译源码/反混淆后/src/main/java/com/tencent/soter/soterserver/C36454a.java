package com.tencent.soter.soterserver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.soter.soterserver.a */
public interface C36454a extends IInterface {

    /* renamed from: com.tencent.soter.soterserver.a$a */
    public static abstract class C36455a extends Binder implements C36454a {

        /* renamed from: com.tencent.soter.soterserver.a$a$a */
        static class C16175a implements C36454a {
            private IBinder mRemote;

            C16175a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: Re */
            public final int mo29031Re(int i) {
                AppMethodBeat.m2504i(73091);
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
                    AppMethodBeat.m2505o(73091);
                }
            }

            /* renamed from: Rf */
            public final SoterExportResult mo29032Rf(int i) {
                AppMethodBeat.m2504i(73092);
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
                    AppMethodBeat.m2505o(73092);
                    return soterExportResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(73092);
                }
            }

            /* renamed from: Rg */
            public final boolean mo29033Rg(int i) {
                boolean z = false;
                AppMethodBeat.m2504i(73093);
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
                    AppMethodBeat.m2505o(73093);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(73093);
                }
            }

            /* renamed from: bS */
            public final int mo29036bS(int i, String str) {
                AppMethodBeat.m2504i(73094);
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
                    AppMethodBeat.m2505o(73094);
                }
            }

            /* renamed from: bT */
            public final int mo29037bT(int i, String str) {
                AppMethodBeat.m2504i(73095);
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
                    AppMethodBeat.m2505o(73095);
                }
            }

            /* renamed from: bU */
            public final SoterExportResult mo29038bU(int i, String str) {
                AppMethodBeat.m2504i(73096);
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
                    AppMethodBeat.m2505o(73096);
                    return soterExportResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(73096);
                }
            }

            /* renamed from: Rh */
            public final int mo29034Rh(int i) {
                AppMethodBeat.m2504i(73097);
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
                    AppMethodBeat.m2505o(73097);
                }
            }

            /* renamed from: bV */
            public final boolean mo29039bV(int i, String str) {
                boolean z = false;
                AppMethodBeat.m2504i(73098);
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
                    AppMethodBeat.m2505o(73098);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(73098);
                }
            }

            /* renamed from: O */
            public final SoterSessionResult mo29030O(int i, String str, String str2) {
                AppMethodBeat.m2504i(73099);
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
                    AppMethodBeat.m2505o(73099);
                    return soterSessionResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(73099);
                }
            }

            /* renamed from: nD */
            public final SoterSignResult mo29042nD(long j) {
                AppMethodBeat.m2504i(73100);
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
                    AppMethodBeat.m2505o(73100);
                    return soterSignResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(73100);
                }
            }

            public final SoterDeviceResult dRb() {
                AppMethodBeat.m2504i(73101);
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
                    AppMethodBeat.m2505o(73101);
                    return soterDeviceResult;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(73101);
                }
            }

            public final int getVersion() {
                AppMethodBeat.m2504i(73102);
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
                    AppMethodBeat.m2505o(73102);
                }
            }
        }

        /* renamed from: O */
        public static C36454a m60228O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.soter.soterserver.ISoterService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C36454a)) {
                return new C16175a(iBinder);
            }
            return (C36454a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            SoterExportResult Rf;
            boolean Rg;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    i3 = mo29031Re(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    Rf = mo29032Rf(parcel.readInt());
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
                    Rg = mo29033Rg(parcel.readInt());
                    parcel2.writeNoException();
                    if (Rg) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    i3 = mo29036bS(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    i3 = mo29037bT(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    Rf = mo29038bU(parcel.readInt(), parcel.readString());
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
                    i3 = mo29034Rh(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    Rg = mo29039bV(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    if (Rg) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.soter.soterserver.ISoterService");
                    SoterSessionResult O = mo29030O(parcel.readInt(), parcel.readString(), parcel.readString());
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
                    SoterSignResult nD = mo29042nD(parcel.readLong());
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

    /* renamed from: O */
    SoterSessionResult mo29030O(int i, String str, String str2);

    /* renamed from: Re */
    int mo29031Re(int i);

    /* renamed from: Rf */
    SoterExportResult mo29032Rf(int i);

    /* renamed from: Rg */
    boolean mo29033Rg(int i);

    /* renamed from: Rh */
    int mo29034Rh(int i);

    /* renamed from: bS */
    int mo29036bS(int i, String str);

    /* renamed from: bT */
    int mo29037bT(int i, String str);

    /* renamed from: bU */
    SoterExportResult mo29038bU(int i, String str);

    /* renamed from: bV */
    boolean mo29039bV(int i, String str);

    SoterDeviceResult dRb();

    int getVersion();

    /* renamed from: nD */
    SoterSignResult mo29042nD(long j);
}
