package com.p782a.p783a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.a.a.b */
public interface C31906b extends IInterface {

    /* renamed from: com.a.a.b$a */
    public static abstract class C31907a extends Binder implements C31906b {

        /* renamed from: com.a.a.b$a$a */
        static class C31908a implements C31906b {
            private IBinder mRemote;

            C31908a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: b */
            public final void mo52020b(int i, int i2, int i3, byte[] bArr) {
                AppMethodBeat.m2504i(118242);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.securitymgr.IAuthenticationClient");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(118242);
                }
            }
        }

        public C31907a() {
            attachInterface(this, "com.huawei.securitymgr.IAuthenticationClient");
        }

        /* renamed from: h */
        public static C31906b m51771h(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.securitymgr.IAuthenticationClient");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C31906b)) {
                return new C31908a(iBinder);
            }
            return (C31906b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.huawei.securitymgr.IAuthenticationClient");
                    mo52020b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.huawei.securitymgr.IAuthenticationClient");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: b */
    void mo52020b(int i, int i2, int i3, byte[] bArr);
}
