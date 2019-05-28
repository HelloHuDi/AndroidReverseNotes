package com.tencent.p177mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.exdevice.service.t */
public interface C43005t extends IInterface {

    /* renamed from: com.tencent.mm.plugin.exdevice.service.t$a */
    public static abstract class C43006a extends Binder implements C43005t {

        /* renamed from: com.tencent.mm.plugin.exdevice.service.t$a$a */
        static class C38962a implements C43005t {
            private IBinder mRemote;

            C38962a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: b */
            public final void mo35810b(long j, int i, int i2, String str) {
                AppMethodBeat.m2504i(19625);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(19625);
                }
            }
        }

        public C43006a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
                    mo35810b(parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnSendEnd_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: b */
    void mo35810b(long j, int i, int i2, String str);
}
