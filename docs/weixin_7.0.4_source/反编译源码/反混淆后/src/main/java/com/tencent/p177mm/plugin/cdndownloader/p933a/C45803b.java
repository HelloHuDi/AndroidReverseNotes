package com.tencent.p177mm.plugin.cdndownloader.p933a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.cdndownloader.a.b */
public interface C45803b extends IInterface {

    /* renamed from: com.tencent.mm.plugin.cdndownloader.a.b$a */
    public static abstract class C42875a extends Binder implements C45803b {

        /* renamed from: com.tencent.mm.plugin.cdndownloader.a.b$a$a */
        static class C42876a implements C45803b {
            private IBinder mRemote;

            C42876a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: e */
            public final void mo6910e(String str, int i, int i2, String str2) {
                AppMethodBeat.m2504i(872);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(872);
                }
            }

            /* renamed from: l */
            public final void mo6911l(String str, long j, long j2) {
                AppMethodBeat.m2504i(873);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(873);
                }
            }
        }

        public C42875a() {
            attachInterface(this, "com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
        }

        /* renamed from: t */
        public static C45803b m76127t(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C45803b)) {
                return new C42876a(iBinder);
            }
            return (C45803b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    mo6910e(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    mo6911l(parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.cdndownloader.aidl.ICDNDownloadServiceCallback");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: e */
    void mo6910e(String str, int i, int i2, String str2);

    /* renamed from: l */
    void mo6911l(String str, long j, long j2);
}
