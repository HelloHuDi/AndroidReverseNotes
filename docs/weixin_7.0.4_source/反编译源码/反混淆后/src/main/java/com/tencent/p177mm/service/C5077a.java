package com.tencent.p177mm.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.service.a */
public interface C5077a extends IInterface {

    /* renamed from: com.tencent.mm.service.a$a */
    public static abstract class C5078a extends Binder implements C5077a {

        /* renamed from: com.tencent.mm.service.a$a$a */
        static class C5079a implements C5077a {
            private IBinder mRemote;

            C5079a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: M */
            public final void mo10433M(IBinder iBinder) {
                AppMethodBeat.m2504i(115267);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(115267);
                }
            }
        }

        public C5078a() {
            attachInterface(this, "com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
                    mo10433M(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: M */
    void mo10433M(IBinder iBinder);
}
