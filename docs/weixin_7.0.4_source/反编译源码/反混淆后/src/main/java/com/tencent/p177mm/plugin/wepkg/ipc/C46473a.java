package com.tencent.p177mm.plugin.wepkg.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wepkg.ipc.a */
public interface C46473a extends IInterface {

    /* renamed from: com.tencent.mm.plugin.wepkg.ipc.a$a */
    public static abstract class C46474a extends Binder implements C46473a {

        /* renamed from: com.tencent.mm.plugin.wepkg.ipc.a$a$a */
        static class C23205a implements C46473a {
            private IBinder mRemote;

            C23205a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: r */
            public final void mo38825r(Message message) {
                AppMethodBeat.m2504i(63478);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.m2505o(63478);
                }
            }

            /* renamed from: x */
            public final void mo38826x(Bundle bundle) {
                AppMethodBeat.m2504i(63479);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
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
                    AppMethodBeat.m2505o(63479);
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(63479);
                }
            }
        }

        public C46474a() {
            attachInterface(this, "com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
        }

        /* renamed from: I */
        public static C46473a m87666I(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C46473a)) {
                return new C23205a(iBinder);
            }
            return (C46473a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle = null;
            switch (i) {
                case 1:
                    Message message;
                    parcel.enforceInterface("com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
                    if (parcel.readInt() != 0) {
                        message = (Message) Message.CREATOR.createFromParcel(parcel);
                    }
                    mo38825r(message);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo38826x(bundle);
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: r */
    void mo38825r(Message message);

    /* renamed from: x */
    void mo38826x(Bundle bundle);
}
