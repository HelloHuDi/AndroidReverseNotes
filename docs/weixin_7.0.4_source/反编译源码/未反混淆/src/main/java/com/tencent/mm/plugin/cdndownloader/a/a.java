package com.tencent.mm.plugin.cdndownloader.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;

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

            public final int a(CDNTaskInfo cDNTaskInfo) {
                AppMethodBeat.i(861);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (cDNTaskInfo != null) {
                        obtain.writeInt(1);
                        cDNTaskInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(861);
                }
            }

            public final int b(CDNTaskInfo cDNTaskInfo) {
                AppMethodBeat.i(862);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (cDNTaskInfo != null) {
                        obtain.writeInt(1);
                        cDNTaskInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(862);
                }
            }

            public final boolean HA(String str) {
                boolean z = false;
                AppMethodBeat.i(863);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(863);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(863);
                }
            }

            public final boolean HB(String str) {
                boolean z = false;
                AppMethodBeat.i(864);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(864);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(864);
                }
            }

            public final CDNTaskState HC(String str) {
                AppMethodBeat.i(865);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    CDNTaskState cDNTaskState;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        cDNTaskState = (CDNTaskState) CDNTaskState.CREATOR.createFromParcel(obtain2);
                    } else {
                        cDNTaskState = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(865);
                    return cDNTaskState;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(865);
                }
            }

            public final void a(b bVar) {
                AppMethodBeat.i(866);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(866);
                }
            }

            public final void b(b bVar) {
                AppMethodBeat.i(867);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(867);
                }
            }

            public final void tr(int i) {
                AppMethodBeat.i(868);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(868);
                }
            }

            public final void beR() {
                AppMethodBeat.i(869);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(869);
                }
            }

            public final void beS() {
                AppMethodBeat.i(870);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(870);
                }
            }

            public final void beT() {
                AppMethodBeat.i(871);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(871);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        }

        public static a s(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            CDNTaskInfo cDNTaskInfo = null;
            int i3 = 0;
            int a;
            boolean HA;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (parcel.readInt() != 0) {
                        cDNTaskInfo = (CDNTaskInfo) CDNTaskInfo.CREATOR.createFromParcel(parcel);
                    }
                    a = a(cDNTaskInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (parcel.readInt() != 0) {
                        cDNTaskInfo = (CDNTaskInfo) CDNTaskInfo.CREATOR.createFromParcel(parcel);
                    }
                    a = b(cDNTaskInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    HA = HA(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(HA ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    HA = HB(parcel.readString());
                    parcel2.writeNoException();
                    if (HA) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    CDNTaskState HC = HC(parcel.readString());
                    parcel2.writeNoException();
                    if (HC != null) {
                        parcel2.writeInt(1);
                        HC.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    a(com.tencent.mm.plugin.cdndownloader.a.b.a.t(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    b(com.tencent.mm.plugin.cdndownloader.a.b.a.t(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    tr(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    beR();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    beS();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    beT();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean HA(String str);

    boolean HB(String str);

    CDNTaskState HC(String str);

    int a(CDNTaskInfo cDNTaskInfo);

    void a(b bVar);

    int b(CDNTaskInfo cDNTaskInfo);

    void b(b bVar);

    void beR();

    void beS();

    void beT();

    void tr(int i);
}
