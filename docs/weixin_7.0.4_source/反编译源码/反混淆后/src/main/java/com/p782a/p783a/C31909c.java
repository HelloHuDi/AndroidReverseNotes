package com.p782a.p783a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.p782a.p783a.C31906b.C31907a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.a.a.c */
public interface C31909c extends IInterface {

    /* renamed from: com.a.a.c$a */
    public static abstract class C25388a extends Binder implements C31909c {

        /* renamed from: com.a.a.c$a$a */
        static class C8479a implements C31909c {
            private IBinder mRemote;

            C8479a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final boolean mo18537a(C31906b c31906b, int i) {
                boolean z = true;
                AppMethodBeat.m2504i(118226);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118226);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118226);
                }
            }

            /* renamed from: a */
            public final int mo18534a(C31906b c31906b, int[] iArr, byte[] bArr) {
                AppMethodBeat.m2504i(118227);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118227);
                }
            }

            /* renamed from: a */
            public final void mo18536a(C31906b c31906b) {
                AppMethodBeat.m2504i(118228);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118228);
                }
            }

            /* renamed from: b */
            public final void mo18541b(C31906b c31906b) {
                AppMethodBeat.m2504i(118229);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118229);
                }
            }

            /* renamed from: c */
            public final int[] mo18543c(C31906b c31906b) {
                AppMethodBeat.m2504i(118230);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int[] createIntArray = obtain2.createIntArray();
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118230);
                }
            }

            /* renamed from: vS */
            public final int[] mo18550vS() {
                AppMethodBeat.m2504i(118231);
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
                    AppMethodBeat.m2505o(118231);
                }
            }

            /* renamed from: fK */
            public final boolean mo18548fK(int i) {
                boolean z = false;
                AppMethodBeat.m2504i(118232);
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
                    AppMethodBeat.m2505o(118232);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118232);
                }
            }

            /* renamed from: fL */
            public final int mo18549fL(int i) {
                AppMethodBeat.m2504i(118233);
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
                    AppMethodBeat.m2505o(118233);
                }
            }

            /* renamed from: bm */
            public final boolean mo18542bm(String str) {
                boolean z = false;
                AppMethodBeat.m2504i(118234);
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
                    AppMethodBeat.m2505o(118234);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118234);
                }
            }

            /* renamed from: b */
            public final String mo18540b(C31906b c31906b, int i) {
                AppMethodBeat.m2504i(118235);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118235);
                }
            }

            /* renamed from: c */
            public final int[] mo18544c(C31906b c31906b, int i) {
                AppMethodBeat.m2504i(118236);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int[] createIntArray = obtain2.createIntArray();
                    return createIntArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118236);
                }
            }

            /* renamed from: d */
            public final int mo18545d(C31906b c31906b, int i) {
                AppMethodBeat.m2504i(118237);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118237);
                }
            }

            /* renamed from: a */
            public final boolean mo18538a(C31906b c31906b, int i, boolean z) {
                boolean z2 = true;
                AppMethodBeat.m2504i(118238);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    int i2;
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
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
                    AppMethodBeat.m2505o(118238);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118238);
                }
            }

            /* renamed from: d */
            public final long mo18546d(C31906b c31906b) {
                AppMethodBeat.m2504i(118239);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118239);
                }
            }

            /* renamed from: a */
            public final int mo18535a(C31906b c31906b, int[] iArr, byte[] bArr, int i) {
                AppMethodBeat.m2504i(118240);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
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
                    AppMethodBeat.m2505o(118240);
                }
            }

            /* renamed from: e */
            public final byte[] mo18547e(C31906b c31906b) {
                AppMethodBeat.m2504i(118241);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationService");
                    obtain.writeStrongBinder(c31906b != null ? c31906b.asBinder() : null);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118241);
                }
            }
        }

        /* renamed from: i */
        public static C31909c m40092i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C31909c)) {
                return new C8479a(iBinder);
            }
            return (C31909c) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean a;
            int[] c;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    a = mo18537a(C31907a.m51771h(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    i3 = mo18534a(C31907a.m51771h(parcel.readStrongBinder()), parcel.createIntArray(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    mo18536a(C31907a.m51771h(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    mo18541b(C31907a.m51771h(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    c = mo18543c(C31907a.m51771h(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeIntArray(c);
                    return true;
                case 6:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    c = mo18550vS();
                    parcel2.writeNoException();
                    parcel2.writeIntArray(c);
                    return true;
                case 7:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    a = mo18548fK(parcel.readInt());
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    i3 = mo18549fL(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    a = mo18542bm(parcel.readString());
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    String b = mo18540b(C31907a.m51771h(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(b);
                    return true;
                case 11:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    c = mo18544c(C31907a.m51771h(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeIntArray(c);
                    return true;
                case 12:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    i3 = mo18545d(C31907a.m51771h(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 13:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    C31906b h = C31907a.m51771h(parcel.readStrongBinder());
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        a = true;
                    } else {
                        a = false;
                    }
                    a = mo18538a(h, readInt, a);
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    long d = mo18546d(C31907a.m51771h(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeLong(d);
                    return true;
                case 15:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    i3 = mo18535a(C31907a.m51771h(parcel.readStrongBinder()), parcel.createIntArray(), parcel.createByteArray(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 16:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationService");
                    byte[] e = mo18547e(C31907a.m51771h(parcel.readStrongBinder()));
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

    /* renamed from: a */
    int mo18534a(C31906b c31906b, int[] iArr, byte[] bArr);

    /* renamed from: a */
    int mo18535a(C31906b c31906b, int[] iArr, byte[] bArr, int i);

    /* renamed from: a */
    void mo18536a(C31906b c31906b);

    /* renamed from: a */
    boolean mo18537a(C31906b c31906b, int i);

    /* renamed from: a */
    boolean mo18538a(C31906b c31906b, int i, boolean z);

    /* renamed from: b */
    String mo18540b(C31906b c31906b, int i);

    /* renamed from: b */
    void mo18541b(C31906b c31906b);

    /* renamed from: bm */
    boolean mo18542bm(String str);

    /* renamed from: c */
    int[] mo18543c(C31906b c31906b);

    /* renamed from: c */
    int[] mo18544c(C31906b c31906b, int i);

    /* renamed from: d */
    int mo18545d(C31906b c31906b, int i);

    /* renamed from: d */
    long mo18546d(C31906b c31906b);

    /* renamed from: e */
    byte[] mo18547e(C31906b c31906b);

    /* renamed from: fK */
    boolean mo18548fK(int i);

    /* renamed from: fL */
    int mo18549fL(int i);

    /* renamed from: vS */
    int[] mo18550vS();
}
