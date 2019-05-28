package com.tencent.p177mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.protocal.h */
public interface C4816h extends IInterface {

    /* renamed from: com.tencent.mm.protocal.h$a */
    public static abstract class C4817a extends Binder implements C4816h {

        /* renamed from: com.tencent.mm.protocal.h$a$a */
        static class C4818a implements C4816h {
            private IBinder mRemote;

            C4818a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final boolean mo9942a(int i, byte[] bArr, int i2, byte[] bArr2, byte[] bArr3, int i3, boolean z) {
                boolean z2 = true;
                AppMethodBeat.m2504i(58795);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    obtain.writeByteArray(bArr2);
                    obtain.writeByteArray(bArr3);
                    obtain.writeInt(i3);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58795);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58795);
                }
            }

            public final byte[] adk() {
                AppMethodBeat.m2504i(58796);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58796);
                }
            }

            /* renamed from: T */
            public final void mo9940T(byte[] bArr) {
                AppMethodBeat.m2504i(58797);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58797);
                }
            }

            public final byte[] adl() {
                AppMethodBeat.m2504i(58798);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58798);
                }
            }

            /* renamed from: hB */
            public final void mo9956hB(int i) {
                AppMethodBeat.m2504i(58799);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58799);
                }
            }

            /* renamed from: QF */
            public final int mo9939QF() {
                AppMethodBeat.m2504i(58800);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58800);
                }
            }

            /* renamed from: kY */
            public final void mo9957kY(int i) {
                AppMethodBeat.m2504i(58801);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58801);
                }
            }

            public final int getClientVersion() {
                AppMethodBeat.m2504i(58802);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58802);
                }
            }

            /* renamed from: qu */
            public final void mo9959qu(String str) {
                AppMethodBeat.m2504i(58803);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58803);
                }
            }

            public final String adm() {
                AppMethodBeat.m2504i(58804);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58804);
                }
            }

            public final String adn() {
                AppMethodBeat.m2504i(58805);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58805);
                }
            }

            /* renamed from: qv */
            public final void mo9960qv(String str) {
                AppMethodBeat.m2504i(58806);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58806);
                }
            }

            /* renamed from: kZ */
            public final void mo9958kZ(int i) {
                AppMethodBeat.m2504i(58807);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58807);
                }
            }

            public final int ado() {
                AppMethodBeat.m2504i(58808);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58808);
                }
            }

            public final byte[] adp() {
                AppMethodBeat.m2504i(58809);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58809);
                }
            }

            /* renamed from: U */
            public final void mo9941U(byte[] bArr) {
                AppMethodBeat.m2504i(58810);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58810);
                }
            }

            public final String getUserName() {
                AppMethodBeat.m2504i(58811);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58811);
                }
            }

            public final String getPassword() {
                AppMethodBeat.m2504i(58812);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58812);
                }
            }

            public final String adq() {
                AppMethodBeat.m2504i(58813);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58813);
                }
            }

            public final int getCmdId() {
                AppMethodBeat.m2504i(58814);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58814);
                }
            }

            public final boolean adr() {
                boolean z = false;
                AppMethodBeat.m2504i(58815);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58815);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58815);
                }
            }

            public final long ads() {
                AppMethodBeat.m2504i(58816);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58816);
                }
            }
        }

        public C4817a() {
            attachInterface(this, "com.tencent.mm.protocal.IMMBaseReq_AIDL");
        }

        /* renamed from: J */
        public static C4816h m7155J(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C4816h)) {
                return new C4818a(iBinder);
            }
            return (C4816h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean a;
            byte[] adk;
            int QF;
            String adm;
            switch (i) {
                case 1:
                    boolean z;
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    int readInt = parcel.readInt();
                    byte[] createByteArray = parcel.createByteArray();
                    int readInt2 = parcel.readInt();
                    byte[] createByteArray2 = parcel.createByteArray();
                    byte[] createByteArray3 = parcel.createByteArray();
                    int readInt3 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a = mo9942a(readInt, createByteArray, readInt2, createByteArray2, createByteArray3, readInt3, z);
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    adk = adk();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(adk);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    mo9940T(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    adk = adl();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(adk);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    mo9956hB(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    QF = mo9939QF();
                    parcel2.writeNoException();
                    parcel2.writeInt(QF);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    mo9957kY(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    QF = getClientVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(QF);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    mo9959qu(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    adm = adm();
                    parcel2.writeNoException();
                    parcel2.writeString(adm);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    adm = adn();
                    parcel2.writeNoException();
                    parcel2.writeString(adm);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    mo9960qv(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    mo9958kZ(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    QF = ado();
                    parcel2.writeNoException();
                    parcel2.writeInt(QF);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    adk = adp();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(adk);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    mo9941U(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    adm = getUserName();
                    parcel2.writeNoException();
                    parcel2.writeString(adm);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    adm = getPassword();
                    parcel2.writeNoException();
                    parcel2.writeString(adm);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    adm = adq();
                    parcel2.writeNoException();
                    parcel2.writeString(adm);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    QF = getCmdId();
                    parcel2.writeNoException();
                    parcel2.writeInt(QF);
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    a = adr();
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    long ads = ads();
                    parcel2.writeNoException();
                    parcel2.writeLong(ads);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: QF */
    int mo9939QF();

    /* renamed from: T */
    void mo9940T(byte[] bArr);

    /* renamed from: U */
    void mo9941U(byte[] bArr);

    /* renamed from: a */
    boolean mo9942a(int i, byte[] bArr, int i2, byte[] bArr2, byte[] bArr3, int i3, boolean z);

    byte[] adk();

    byte[] adl();

    String adm();

    String adn();

    int ado();

    byte[] adp();

    String adq();

    boolean adr();

    long ads();

    int getClientVersion();

    int getCmdId();

    String getPassword();

    String getUserName();

    /* renamed from: hB */
    void mo9956hB(int i);

    /* renamed from: kY */
    void mo9957kY(int i);

    /* renamed from: kZ */
    void mo9958kZ(int i);

    /* renamed from: qu */
    void mo9959qu(String str);

    /* renamed from: qv */
    void mo9960qv(String str);
}
