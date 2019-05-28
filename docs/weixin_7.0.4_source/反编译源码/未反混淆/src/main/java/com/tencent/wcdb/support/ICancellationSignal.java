package com.tencent.wcdb.support;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ICancellationSignal extends IInterface {

    public static abstract class Stub extends Binder implements ICancellationSignal {
        private static final String DESCRIPTOR = "com.tencent.wcdb.support.ICancellationSignal";
        static final int TRANSACTION_cancel = 1;

        static class Proxy implements ICancellationSignal {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void cancel() {
                AppMethodBeat.i(12708);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.o(12708);
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICancellationSignal asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ICancellationSignal)) {
                return new Proxy(iBinder);
            }
            return (ICancellationSignal) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = DESCRIPTOR;
            switch (i) {
                case 1:
                    parcel.enforceInterface(str);
                    cancel();
                    return true;
                case 1598968902:
                    parcel2.writeString(str);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void cancel();
}
