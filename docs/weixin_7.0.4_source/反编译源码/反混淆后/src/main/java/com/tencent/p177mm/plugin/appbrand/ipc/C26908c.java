package com.tencent.p177mm.plugin.appbrand.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.c */
public interface C26908c extends IInterface {

    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.c$a */
    public static abstract class C10274a extends Binder implements C26908c {

        /* renamed from: com.tencent.mm.plugin.appbrand.ipc.c$a$a */
        static class C10275a implements C26908c {
            private IBinder mRemote;

            C10275a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: w */
            public final void mo21721w(Bundle bundle) {
                AppMethodBeat.m2504i(91007);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.m2505o(91007);
                }
            }

            /* renamed from: x */
            public final void mo21722x(Bundle bundle) {
                AppMethodBeat.m2504i(91008);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(91008);
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(91008);
                }
            }

            /* renamed from: a */
            public final void mo21719a(IBinder iBinder, String str) {
                AppMethodBeat.m2504i(91009);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(91009);
                }
            }
        }

        public C10274a() {
            attachInterface(this, "com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
        }

        /* renamed from: r */
        public static C26908c m17927r(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C26908c)) {
                return new C10275a(iBinder);
            }
            return (C26908c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo21721w(bundle);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo21722x(bundle);
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    mo21719a(parcel.readStrongBinder(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo21719a(IBinder iBinder, String str);

    /* renamed from: w */
    void mo21721w(Bundle bundle);

    /* renamed from: x */
    void mo21722x(Bundle bundle);
}
