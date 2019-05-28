package com.tencent.p177mm.ipcinvoker.p1462b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p1462b.C32707b.C32708a.C32709a;

/* renamed from: com.tencent.mm.ipcinvoker.b.a */
public interface C32704a extends IInterface {

    /* renamed from: com.tencent.mm.ipcinvoker.b.a$a */
    public static abstract class C32705a extends Binder implements C32704a {

        /* renamed from: com.tencent.mm.ipcinvoker.b.a$a$a */
        static class C32706a implements C32704a {
            private IBinder mRemote;

            C32706a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo33746a(Bundle bundle, String str, C32707b c32707b) {
                IBinder iBinder = null;
                AppMethodBeat.m2504i(114070);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (c32707b != null) {
                        iBinder = c32707b.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.m2505o(114070);
                }
            }

            /* renamed from: f */
            public final Bundle mo33747f(Bundle bundle, String str) {
                AppMethodBeat.m2504i(114071);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle2;
                    obtain.writeInterfaceToken("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(114071);
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(114071);
                }
            }
        }

        public C32705a() {
            attachInterface(this, "com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
        }

        /* renamed from: k */
        public static C32704a m53375k(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C32704a)) {
                return new C32706a(iBinder);
            }
            return (C32704a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            C32707b c32707b = null;
            switch (i) {
                case 1:
                    Bundle bundle;
                    parcel.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    String readString = parcel.readString();
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeCallback");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C32707b)) {
                            c32707b = new C32709a(readStrongBinder);
                        } else {
                            c32707b = (C32707b) queryLocalInterface;
                        }
                    }
                    mo33746a(bundle, readString, c32707b);
                    return true;
                case 2:
                    Bundle bundle2;
                    parcel.enforceInterface("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    bundle2 = mo33747f(bundle2, parcel.readString());
                    parcel2.writeNoException();
                    if (bundle2 != null) {
                        parcel2.writeInt(1);
                        bundle2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.ipcinvoker.aidl.AIDL_IPCInvokeBridge");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo33746a(Bundle bundle, String str, C32707b c32707b);

    /* renamed from: f */
    Bundle mo33747f(Bundle bundle, String str);
}
