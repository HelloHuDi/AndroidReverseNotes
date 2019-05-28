package com.tencent.p177mm.plugin.cdndownloader.p933a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.p177mm.plugin.cdndownloader.ipc.CDNTaskState;
import com.tencent.p177mm.plugin.cdndownloader.p933a.C45803b.C42875a;

/* renamed from: com.tencent.mm.plugin.cdndownloader.a.a */
public interface C42873a extends IInterface {

    /* renamed from: com.tencent.mm.plugin.cdndownloader.a.a$a */
    public static abstract class C42874a extends Binder implements C42873a {

        /* renamed from: com.tencent.mm.plugin.cdndownloader.a.a$a$a */
        static class C11363a implements C42873a {
            private IBinder mRemote;

            C11363a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final int mo23082a(CDNTaskInfo cDNTaskInfo) {
                AppMethodBeat.m2504i(861);
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
                    AppMethodBeat.m2505o(861);
                }
            }

            /* renamed from: b */
            public final int mo23085b(CDNTaskInfo cDNTaskInfo) {
                AppMethodBeat.m2504i(862);
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
                    AppMethodBeat.m2505o(862);
                }
            }

            /* renamed from: HA */
            public final boolean mo23079HA(String str) {
                boolean z = false;
                AppMethodBeat.m2504i(863);
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
                    AppMethodBeat.m2505o(863);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(863);
                }
            }

            /* renamed from: HB */
            public final boolean mo23080HB(String str) {
                boolean z = false;
                AppMethodBeat.m2504i(864);
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
                    AppMethodBeat.m2505o(864);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(864);
                }
            }

            /* renamed from: HC */
            public final CDNTaskState mo23081HC(String str) {
                AppMethodBeat.m2504i(865);
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
                    AppMethodBeat.m2505o(865);
                    return cDNTaskState;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(865);
                }
            }

            /* renamed from: a */
            public final void mo23083a(C45803b c45803b) {
                AppMethodBeat.m2504i(866);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeStrongBinder(c45803b != null ? c45803b.asBinder() : null);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(866);
                }
            }

            /* renamed from: b */
            public final void mo23086b(C45803b c45803b) {
                AppMethodBeat.m2504i(867);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    obtain.writeStrongBinder(c45803b != null ? c45803b.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(867);
                }
            }

            /* renamed from: tr */
            public final void mo23090tr(int i) {
                AppMethodBeat.m2504i(868);
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
                    AppMethodBeat.m2505o(868);
                }
            }

            public final void beR() {
                AppMethodBeat.m2504i(869);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(869);
                }
            }

            public final void beS() {
                AppMethodBeat.m2504i(870);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(870);
                }
            }

            public final void beT() {
                AppMethodBeat.m2504i(871);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(871);
                }
            }
        }

        public C42874a() {
            attachInterface(this, "com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
        }

        /* renamed from: s */
        public static C42873a m76126s(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C42873a)) {
                return new C11363a(iBinder);
            }
            return (C42873a) queryLocalInterface;
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
                    a = mo23082a(cDNTaskInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    if (parcel.readInt() != 0) {
                        cDNTaskInfo = (CDNTaskInfo) CDNTaskInfo.CREATOR.createFromParcel(parcel);
                    }
                    a = mo23085b(cDNTaskInfo);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    HA = mo23079HA(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(HA ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    HA = mo23080HB(parcel.readString());
                    parcel2.writeNoException();
                    if (HA) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    CDNTaskState HC = mo23081HC(parcel.readString());
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
                    mo23083a(C42875a.m76127t(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    mo23086b(C42875a.m76127t(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadService");
                    mo23090tr(parcel.readInt());
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

    /* renamed from: HA */
    boolean mo23079HA(String str);

    /* renamed from: HB */
    boolean mo23080HB(String str);

    /* renamed from: HC */
    CDNTaskState mo23081HC(String str);

    /* renamed from: a */
    int mo23082a(CDNTaskInfo cDNTaskInfo);

    /* renamed from: a */
    void mo23083a(C45803b c45803b);

    /* renamed from: b */
    int mo23085b(CDNTaskInfo cDNTaskInfo);

    /* renamed from: b */
    void mo23086b(C45803b c45803b);

    void beR();

    void beS();

    void beT();

    /* renamed from: tr */
    void mo23090tr(int i);
}
