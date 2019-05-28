package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface h extends IInterface {

    public static abstract class a extends Binder implements h {

        static class a implements h {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean b(int i, j jVar) {
                boolean z = true;
                AppMethodBeat.i(19592);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19592);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19592);
                }
            }

            public final boolean c(int i, j jVar) {
                boolean z = false;
                AppMethodBeat.i(19593);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19593);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19593);
                }
            }

            public final long[] bpl() {
                AppMethodBeat.i(19594);
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
                    AppMethodBeat.o(19594);
                }
            }

            public final boolean a(long j, int i, k kVar) {
                boolean z = false;
                AppMethodBeat.i(19595);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19595);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19595);
                }
            }

            public final boolean hZ(long j) {
                boolean z = false;
                AppMethodBeat.i(19596);
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
                    AppMethodBeat.o(19596);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19596);
                }
            }

            public final boolean ia(long j) {
                boolean z = false;
                AppMethodBeat.i(19597);
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
                    AppMethodBeat.o(19597);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19597);
                }
            }

            public final long a(p pVar) {
                AppMethodBeat.i(19598);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(pVar != null ? pVar.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19598);
                }
            }

            public final boolean ib(long j) {
                boolean z = false;
                AppMethodBeat.i(19599);
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
                    AppMethodBeat.o(19599);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19599);
                }
            }

            public final boolean a(i iVar) {
                boolean z = false;
                AppMethodBeat.i(19600);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19600);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19600);
                }
            }

            public final boolean b(i iVar) {
                boolean z = false;
                AppMethodBeat.i(19601);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19601);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19601);
                }
            }

            public final void a(n nVar) {
                AppMethodBeat.i(19602);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19602);
                }
            }

            public final void setChannelSessionKey(long j, byte[] bArr) {
                AppMethodBeat.i(19603);
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
                    AppMethodBeat.o(19603);
                }
            }

            public final boolean a(String str, boolean z, q qVar) {
                boolean z2 = true;
                AppMethodBeat.i(19604);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19604);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19604);
                }
            }

            public final boolean d(int i, j jVar) {
                boolean z = false;
                AppMethodBeat.i(19605);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19605);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19605);
                }
            }

            public final boolean e(int i, j jVar) {
                boolean z = false;
                AppMethodBeat.i(19606);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19606);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19606);
                }
            }

            public final boolean b(long j, int i, k kVar) {
                boolean z = false;
                AppMethodBeat.i(19607);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19607);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19607);
                }
            }

            public final boolean ic(long j) {
                boolean z = false;
                AppMethodBeat.i(19608);
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
                    AppMethodBeat.o(19608);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19608);
                }
            }

            public final boolean a(s sVar) {
                boolean z = false;
                AppMethodBeat.i(19609);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19609);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19609);
                }
            }

            public final boolean b(long j, byte[] bArr, t tVar) {
                boolean z = false;
                AppMethodBeat.i(19610);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    obtain.writeLong(j);
                    obtain.writeByteArray(bArr);
                    obtain.writeStrongBinder(tVar != null ? tVar.asBinder() : null);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19610);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(19610);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
        }

        public static h u(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof h)) {
                return new a(iBinder);
            }
            return (h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            t tVar = null;
            int i3 = 0;
            boolean b;
            IInterface queryLocalInterface;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = b(parcel.readInt(), com.tencent.mm.plugin.exdevice.service.j.a.w(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(b ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = c(parcel.readInt(), com.tencent.mm.plugin.exdevice.service.j.a.w(parcel.readStrongBinder()));
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
                    b = a(parcel.readLong(), parcel.readInt(), com.tencent.mm.plugin.exdevice.service.k.a.x(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = hZ(parcel.readLong());
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = ia(parcel.readLong());
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    long a = a(com.tencent.mm.plugin.exdevice.service.p.a.A(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeLong(a);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = ib(parcel.readLong());
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = a(com.tencent.mm.plugin.exdevice.service.i.a.v(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = b(com.tencent.mm.plugin.exdevice.service.i.a.v(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    n aVar;
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceInvoker_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof n)) {
                            aVar = new a(readStrongBinder);
                        } else {
                            aVar = (n) queryLocalInterface;
                        }
                    }
                    a(aVar);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    setChannelSessionKey(parcel.readLong(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    q aVar2;
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    String readString = parcel.readString();
                    boolean z = parcel.readInt() != 0;
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        queryLocalInterface = readStrongBinder2.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof q)) {
                            aVar2 = new a(readStrongBinder2);
                        } else {
                            aVar2 = (q) queryLocalInterface;
                        }
                    }
                    b = a(readString, z, aVar2);
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = d(parcel.readInt(), com.tencent.mm.plugin.exdevice.service.j.a.w(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = e(parcel.readInt(), com.tencent.mm.plugin.exdevice.service.j.a.w(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = b(parcel.readLong(), parcel.readInt(), com.tencent.mm.plugin.exdevice.service.k.a.x(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    b = ic(parcel.readLong());
                    parcel2.writeNoException();
                    if (b) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 18:
                    s aVar3;
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTDeviceManager_AIDL");
                    IBinder readStrongBinder3 = parcel.readStrongBinder();
                    if (readStrongBinder3 != null) {
                        queryLocalInterface = readStrongBinder3.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof s)) {
                            aVar3 = new a(readStrongBinder3);
                        } else {
                            aVar3 = (s) queryLocalInterface;
                        }
                    }
                    b = a(aVar3);
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
                        tVar = (queryLocalInterface == null || !(queryLocalInterface instanceof t)) ? new a(readStrongBinder4) : (t) queryLocalInterface;
                    }
                    b = b(readLong, createByteArray, tVar);
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

    long a(p pVar);

    void a(n nVar);

    boolean a(long j, int i, k kVar);

    boolean a(i iVar);

    boolean a(s sVar);

    boolean a(String str, boolean z, q qVar);

    boolean b(int i, j jVar);

    boolean b(long j, int i, k kVar);

    boolean b(long j, byte[] bArr, t tVar);

    boolean b(i iVar);

    long[] bpl();

    boolean c(int i, j jVar);

    boolean d(int i, j jVar);

    boolean e(int i, j jVar);

    boolean hZ(long j);

    boolean ia(long j);

    boolean ib(long j);

    boolean ic(long j);

    void setChannelSessionKey(long j, byte[] bArr);
}
