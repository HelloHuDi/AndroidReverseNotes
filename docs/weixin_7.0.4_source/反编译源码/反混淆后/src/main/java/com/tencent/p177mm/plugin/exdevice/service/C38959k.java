package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.exdevice.service.k */
public interface C38959k extends IInterface {

    /* renamed from: com.tencent.mm.plugin.exdevice.service.k$a */
    public static abstract class C38960a extends Binder implements C38959k {

        /* renamed from: com.tencent.mm.plugin.exdevice.service.k$a$a */
        static class C38961a implements C38959k {
            private IBinder mRemote;

            C38961a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo7187a(long j, int i, int i2, int i3, long j2) {
                AppMethodBeat.m2504i(19613);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19613);
                }
            }
        }

        public C38960a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
        }

        /* renamed from: x */
        public static C38959k m66136x(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C38959k)) {
                return new C38961a(iBinder);
            }
            return (C38959k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
                    mo7187a(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo7187a(long j, int i, int i2, int i3, long j2);
}
