package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.service.C11658n.C11659a.C11660a;
import com.tencent.p177mm.plugin.exdevice.service.C11661p.C11662a;
import com.tencent.p177mm.plugin.exdevice.service.C38958i.C20546a;
import com.tencent.p177mm.plugin.exdevice.service.C38959k.C38960a;
import com.tencent.p177mm.plugin.exdevice.service.C43000j.C43001a;
import com.tencent.p177mm.plugin.exdevice.service.C43003s.C43004a.C34051a;
import com.tencent.p177mm.plugin.exdevice.service.C43005t.C43006a.C38962a;
import com.tencent.p177mm.plugin.exdevice.service.C45894q.C27868a.C27869a;

/* renamed from: com.tencent.mm.plugin.exdevice.service.h */
public interface C45893h extends IInterface {

    /* renamed from: com.tencent.mm.plugin.exdevice.service.h$a */
    public static abstract class C27861a extends Binder implements C45893h {

        /* renamed from: com.tencent.mm.plugin.exdevice.service.h$a$a */
        static class C27862a implements C45893h {
            private IBinder mRemote;

            C27862a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: b */
            public final boolean mo45736b(int i, C43000j c43000j) {
                boolean z = true;
                AppMethodBeat.m2504i(19592);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c43000j != null ? c43000j.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19592);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19592);
                }
            }

            /* renamed from: c */
            public final boolean mo45741c(int i, C43000j c43000j) {
                boolean z = false;
                AppMethodBeat.m2504i(19593);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c43000j != null ? c43000j.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19593);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19593);
                }
            }

            public final long[] bpl() {
                AppMethodBeat.m2504i(19594);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    long[] createLongArray = obtain2.createLongArray();
                    return createLongArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19594);
                }
            }

            /* renamed from: a */
            public final boolean mo45731a(long j, int i, C38959k c38959k) {
                boolean z = false;
                AppMethodBeat.m2504i(19595);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c38959k != null ? c38959k.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19595);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19595);
                }
            }

            /* renamed from: hZ */
            public final boolean mo45744hZ(long j) {
                boolean z = false;
                AppMethodBeat.m2504i(19596);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19596);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19596);
                }
            }

            /* renamed from: ia */
            public final boolean mo45745ia(long j) {
                boolean z = false;
                AppMethodBeat.m2504i(19597);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19597);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19597);
                }
            }

            /* renamed from: a */
            public final long mo45729a(C11661p c11661p) {
                AppMethodBeat.m2504i(19598);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(c11661p != null ? c11661p.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19598);
                }
            }

            /* renamed from: ib */
            public final boolean mo45746ib(long j) {
                boolean z = false;
                AppMethodBeat.m2504i(19599);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19599);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19599);
                }
            }

            /* renamed from: a */
            public final boolean mo45732a(C38958i c38958i) {
                boolean z = false;
                AppMethodBeat.m2504i(19600);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(c38958i != null ? c38958i.asBinder() : null);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19600);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19600);
                }
            }

            /* renamed from: b */
            public final boolean mo45739b(C38958i c38958i) {
                boolean z = false;
                AppMethodBeat.m2504i(19601);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(c38958i != null ? c38958i.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19601);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19601);
                }
            }

            /* renamed from: a */
            public final void mo45730a(C11658n c11658n) {
                AppMethodBeat.m2504i(19602);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(c11658n != null ? c11658n.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19602);
                }
            }

            public final void setChannelSessionKey(long j, byte[] bArr) {
                AppMethodBeat.m2504i(19603);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19603);
                }
            }

            /* renamed from: a */
            public final boolean mo45734a(String str, boolean z, C45894q c45894q) {
                boolean z2 = true;
                AppMethodBeat.m2504i(19604);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(c45894q != null ? c45894q.asBinder() : null);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19604);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19604);
                }
            }

            /* renamed from: d */
            public final boolean mo45742d(int i, C43000j c43000j) {
                boolean z = false;
                AppMethodBeat.m2504i(19605);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c43000j != null ? c43000j.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19605);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19605);
                }
            }

            /* renamed from: e */
            public final boolean mo45743e(int i, C43000j c43000j) {
                boolean z = false;
                AppMethodBeat.m2504i(19606);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c43000j != null ? c43000j.asBinder() : null);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19606);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19606);
                }
            }

            /* renamed from: b */
            public final boolean mo45737b(long j, int i, C38959k c38959k) {
                boolean z = false;
                AppMethodBeat.m2504i(19607);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(c38959k != null ? c38959k.asBinder() : null);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19607);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19607);
                }
            }

            /* renamed from: ic */
            public final boolean mo45747ic(long j) {
                boolean z = false;
                AppMethodBeat.m2504i(19608);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19608);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19608);
                }
            }

            /* renamed from: a */
            public final boolean mo45733a(C43003s c43003s) {
                boolean z = false;
                AppMethodBeat.m2504i(19609);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(c43003s != null ? c43003s.asBinder() : null);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19609);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19609);
                }
            }

            /* renamed from: b */
            public final boolean mo45738b(long j, byte[] bArr, C43005t c43005t) {
                boolean z = false;
                AppMethodBeat.m2504i(19610);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    obtain.writeByteArray(bArr);
                    obtain.writeStrongBinder(c43005t != null ? c43005t.asBinder() : null);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19610);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19610);
                }
            }
        }

        public C27861a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        }

        /* renamed from: u */
        public static C45893h m44294u(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C45893h)) {
                return new C27862a(iBinder);
            }
            return (C45893h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            C43005t c43005t = null;
            int i3 = 0;
            boolean b;
            IInterface queryLocalInterface;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45736b(parcel.readInt(), C43001a.m76374w(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45741c(parcel.readInt(), C43001a.m76374w(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    long[] bpl = bpl();
                    parcel2.writeNoException();
                    parcel2.writeLongArray(bpl);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45731a(parcel.readLong(), parcel.readInt(), C38960a.m66136x(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45744hZ(parcel.readLong());
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45745ia(parcel.readLong());
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    long a = mo45729a(C11662a.m19474A(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeLong(a);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45746ib(parcel.readLong());
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45732a(C20546a.m31749v(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45739b(C20546a.m31749v(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    C11658n c11660a;
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C11658n)) {
                            c11660a = new C11660a(readStrongBinder);
                        } else {
                            c11660a = (C11658n) queryLocalInterface;
                        }
                    }
                    mo45730a(c11660a);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    setChannelSessionKey(parcel.readLong(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    C45894q c27869a;
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    String readString = parcel.readString();
                    boolean z = parcel.readInt() != 0;
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        queryLocalInterface = readStrongBinder2.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C45894q)) {
                            c27869a = new C27869a(readStrongBinder2);
                        } else {
                            c27869a = (C45894q) queryLocalInterface;
                        }
                    }
                    b = mo45734a(readString, z, c27869a);
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45742d(parcel.readInt(), C43001a.m76374w(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45743e(parcel.readInt(), C43001a.m76374w(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45737b(parcel.readLong(), parcel.readInt(), C38960a.m66136x(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = mo45747ic(parcel.readLong());
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 18:
                    C43003s c34051a;
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        queryLocalInterface = readStrongBinder3.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C43003s)) {
                            c34051a = new C34051a(readStrongBinder3);
                        } else {
                            c34051a = (C43003s) queryLocalInterface;
                        }
                    }
                    b = mo45733a(c34051a);
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    long readLong = parcel.readLong();
                    byte[] createByteArray = parcel.createByteArray();
                    IBinder readStrongBinder4 = parcel.readStrongBinder();
                    if (readStrongBinder4 != null) {
                        queryLocalInterface = readStrongBinder4.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
                        c43005t = (queryLocalInterface == null || !(queryLocalInterface instanceof C43005t)) ? new C38962a(readStrongBinder4) : (C43005t) queryLocalInterface;
                    }
                    b = mo45738b(readLong, createByteArray, c43005t);
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    long mo45729a(C11661p c11661p);

    /* renamed from: a */
    void mo45730a(C11658n c11658n);

    /* renamed from: a */
    boolean mo45731a(long j, int i, C38959k c38959k);

    /* renamed from: a */
    boolean mo45732a(C38958i c38958i);

    /* renamed from: a */
    boolean mo45733a(C43003s c43003s);

    /* renamed from: a */
    boolean mo45734a(String str, boolean z, C45894q c45894q);

    /* renamed from: b */
    boolean mo45736b(int i, C43000j c43000j);

    /* renamed from: b */
    boolean mo45737b(long j, int i, C38959k c38959k);

    /* renamed from: b */
    boolean mo45738b(long j, byte[] bArr, C43005t c43005t);

    /* renamed from: b */
    boolean mo45739b(C38958i c38958i);

    long[] bpl();

    /* renamed from: c */
    boolean mo45741c(int i, C43000j c43000j);

    /* renamed from: d */
    boolean mo45742d(int i, C43000j c43000j);

    /* renamed from: e */
    boolean mo45743e(int i, C43000j c43000j);

    /* renamed from: hZ */
    boolean mo45744hZ(long j);

    /* renamed from: ia */
    boolean mo45745ia(long j);

    /* renamed from: ib */
    boolean mo45746ib(long j);

    /* renamed from: ic */
    boolean mo45747ic(long j);

    void setChannelSessionKey(long j, byte[] bArr);
}
