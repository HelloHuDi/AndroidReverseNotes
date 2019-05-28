package com.tencent.p177mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1899d.C1900a;
import com.tencent.p177mm.network.C1915j.C1916a;
import com.tencent.p177mm.protocal.C4816h;
import com.tencent.p177mm.protocal.C4816h.C4817a;
import com.tencent.p177mm.protocal.C4819i;
import com.tencent.p177mm.protocal.C4819i.C4820a;

/* renamed from: com.tencent.mm.network.r */
public interface C1930r extends IInterface {

    /* renamed from: com.tencent.mm.network.r$a */
    public static abstract class C1931a extends Binder implements C1930r {

        /* renamed from: com.tencent.mm.network.r$a$a */
        static class C1932a implements C1930r {
            private IBinder mRemote;

            C1932a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int getType() {
                AppMethodBeat.m2504i(58536);
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
                    AppMethodBeat.m2505o(58536);
                }
            }

            public final String getUri() {
                AppMethodBeat.m2504i(58537);
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
                    AppMethodBeat.m2505o(58537);
                }
            }

            public final C4819i adu() {
                AppMethodBeat.m2504i(58538);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    C4819i K = C4820a.m7170K(obtain2.readStrongBinder());
                    return K;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58538);
                }
            }

            public final C4816h adt() {
                AppMethodBeat.m2504i(58539);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    C4816h J = C4817a.m7155J(obtain2.readStrongBinder());
                    return J;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58539);
                }
            }

            /* renamed from: a */
            public final void mo5627a(C1915j c1915j, int i, int i2) {
                AppMethodBeat.m2504i(58540);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(c1915j != null ? c1915j.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58540);
                }
            }

            public final int acO() {
                AppMethodBeat.m2504i(58541);
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
                    AppMethodBeat.m2505o(58541);
                }
            }

            public final boolean acG() {
                boolean z = false;
                AppMethodBeat.m2504i(58542);
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
                    AppMethodBeat.m2505o(58542);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58542);
                }
            }

            public final int acC() {
                AppMethodBeat.m2504i(58543);
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
                    AppMethodBeat.m2505o(58543);
                }
            }

            /* renamed from: qw */
            public final void mo5639qw(String str) {
                AppMethodBeat.m2504i(58544);
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
                    AppMethodBeat.m2505o(58544);
                }
            }

            /* renamed from: a */
            public final void mo5628a(C1915j c1915j, int i, int i2, String str) {
                AppMethodBeat.m2504i(58545);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(c1915j != null ? c1915j.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58545);
                }
            }

            /* renamed from: a */
            public final void mo5626a(C1899d c1899d, C1915j c1915j, int i, int i2) {
                IBinder iBinder = null;
                AppMethodBeat.m2504i(58546);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(c1899d != null ? c1899d.asBinder() : null);
                    if (c1915j != null) {
                        iBinder = c1915j.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58546);
                }
            }

            public final int adv() {
                AppMethodBeat.m2504i(58547);
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
                    AppMethodBeat.m2505o(58547);
                }
            }

            public final int acB() {
                AppMethodBeat.m2504i(58548);
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
                    AppMethodBeat.m2505o(58548);
                }
            }

            public final boolean acH() {
                boolean z = false;
                AppMethodBeat.m2504i(58549);
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
                    AppMethodBeat.m2505o(58549);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58549);
                }
            }
        }

        public C1931a() {
            attachInterface(this, "com.tencent.mm.network.IReqResp_AIDL");
        }

        /* renamed from: q */
        public static C1930r m4130q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IReqResp_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C1930r)) {
                return new C1932a(iBinder);
            }
            return (C1930r) queryLocalInterface;
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
                    C4819i adu = adu();
                    parcel2.writeNoException();
                    if (adu != null) {
                        iBinder = adu.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    C4816h adt = adt();
                    parcel2.writeNoException();
                    if (adt != null) {
                        iBinder = adt.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    mo5627a(C1916a.m4116o(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
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
                    mo5639qw(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    mo5628a(C1916a.m4116o(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    mo5626a(C1900a.m4043l(parcel.readStrongBinder()), C1916a.m4116o(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
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

    /* renamed from: a */
    void mo5626a(C1899d c1899d, C1915j c1915j, int i, int i2);

    /* renamed from: a */
    void mo5627a(C1915j c1915j, int i, int i2);

    /* renamed from: a */
    void mo5628a(C1915j c1915j, int i, int i2, String str);

    int acB();

    int acC();

    boolean acG();

    boolean acH();

    int acO();

    C4816h adt();

    C4819i adu();

    int adv();

    int getType();

    String getUri();

    /* renamed from: qw */
    void mo5639qw(String str);
}
