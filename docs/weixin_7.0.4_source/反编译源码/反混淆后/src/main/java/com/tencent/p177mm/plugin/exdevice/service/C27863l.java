package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.service.C11661p.C11662a;

/* renamed from: com.tencent.mm.plugin.exdevice.service.l */
public interface C27863l extends IInterface {

    /* renamed from: com.tencent.mm.plugin.exdevice.service.l$a */
    public static abstract class C27864a extends Binder implements C27863l {

        /* renamed from: com.tencent.mm.plugin.exdevice.service.l$a$a */
        static class C11657a implements C27863l {
            private IBinder mRemote;

            C11657a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo23407a(long j, int i, int i2, String str, C11661p c11661p) {
                AppMethodBeat.m2504i(19614);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(c11661p != null ? c11661p.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19614);
                }
            }
        }

        public C27864a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
        }

        /* renamed from: y */
        public static C27863l m44313y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C27863l)) {
                return new C11657a(iBinder);
            }
            return (C27863l) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
                    mo23407a(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString(), C11662a.m19474A(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTOnTaskEnd_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo23407a(long j, int i, int i2, String str, C11661p c11661p);
}
