package com.tencent.mm.plugin.wepkg.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface a extends IInterface {

    public static abstract class a extends Binder implements a {

        static class a implements a {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final void r(Message message) {
                AppMethodBeat.i(63478);
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
                    AppMethodBeat.o(63478);
                }
            }

            public final void x(Bundle bundle) {
                AppMethodBeat.i(63479);
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
                    AppMethodBeat.o(63479);
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(63479);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
        }

        public static a I(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
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
                    r(message);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.wepkg.ipc.IWepkgMainProcessService");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    x(bundle);
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

    void r(Message message);

    void x(Bundle bundle);
}
