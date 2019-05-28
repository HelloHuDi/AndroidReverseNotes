package com.tencent.p177mm.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.service.C5077a.C5078a.C5079a;

/* renamed from: com.tencent.mm.service.b */
public interface C5080b extends IInterface {

    /* renamed from: com.tencent.mm.service.b$a */
    public static abstract class C5081a extends Binder implements C5080b {

        /* renamed from: com.tencent.mm.service.b$a$a */
        static class C5082a implements C5080b {
            private IBinder mRemote;

            C5082a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo10416a(Intent intent, C5077a c5077a) {
                AppMethodBeat.m2504i(115268);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c5077a != null ? c5077a.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(115268);
                }
            }

            /* renamed from: aN */
            public final void mo10419aN(Intent intent) {
                AppMethodBeat.m2504i(115269);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(115269);
                }
            }

            /* renamed from: aH */
            public final void mo10417aH(Intent intent) {
                AppMethodBeat.m2504i(115270);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(115270);
                }
            }

            /* renamed from: aI */
            public final void mo10418aI(Intent intent) {
                AppMethodBeat.m2504i(115271);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(115271);
                }
            }
        }

        public C5081a() {
            attachInterface(this, "com.tencent.mm.service.IMMServiceStub_AIDL");
        }

        /* renamed from: N */
        public static C5080b m7712N(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C5080b)) {
                return new C5082a(iBinder);
            }
            return (C5080b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            C5077a c5077a = null;
            Intent intent;
            switch (i) {
                case 1:
                    Intent intent2;
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent2 = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent2 = null;
                    }
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.service.IMMServiceConnectionStub_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C5077a)) {
                            c5077a = new C5079a(readStrongBinder);
                        } else {
                            c5077a = (C5077a) queryLocalInterface;
                        }
                    }
                    mo10416a(intent2, c5077a);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent = null;
                    }
                    mo10419aN(intent);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent = null;
                    }
                    mo10417aH(intent);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.service.IMMServiceStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent = null;
                    }
                    mo10418aI(intent);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.service.IMMServiceStub_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo10416a(Intent intent, C5077a c5077a);

    /* renamed from: aH */
    void mo10417aH(Intent intent);

    /* renamed from: aI */
    void mo10418aI(Intent intent);

    /* renamed from: aN */
    void mo10419aN(Intent intent);
}
