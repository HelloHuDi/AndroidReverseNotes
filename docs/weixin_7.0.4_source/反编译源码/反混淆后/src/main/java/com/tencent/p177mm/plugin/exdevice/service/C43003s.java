package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.exdevice.service.s */
public interface C43003s extends IInterface {

    /* renamed from: com.tencent.mm.plugin.exdevice.service.s$a */
    public static abstract class C43004a extends Binder implements C43003s {

        /* renamed from: com.tencent.mm.plugin.exdevice.service.s$a$a */
        static class C34051a implements C43003s {
            private IBinder mRemote;

            C34051a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: c */
            public final void mo54587c(long j, byte[] bArr) {
                AppMethodBeat.m2504i(19624);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                    obtain.writeLong(j);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19624);
                }
            }
        }

        public C43004a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                    mo54587c(parcel.readLong(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: c */
    void mo54587c(long j, byte[] bArr);
}
