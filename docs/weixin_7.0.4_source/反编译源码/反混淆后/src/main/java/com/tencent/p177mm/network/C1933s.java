package com.tencent.p177mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.network.s */
public interface C1933s extends IInterface {

    /* renamed from: com.tencent.mm.network.s$a */
    public static abstract class C1934a extends Binder implements C1933s {

        /* renamed from: com.tencent.mm.network.s$a$a */
        static class C1935a implements C1933s {
            private IBinder mRemote;

            C1935a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean check() {
                boolean z = true;
                AppMethodBeat.m2504i(58550);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IWorkerCallback_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58550);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58550);
                }
            }
        }

        public C1934a() {
            attachInterface(this, "com.tencent.mm.network.IWorkerCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
                    boolean check = check();
                    parcel2.writeNoException();
                    parcel2.writeInt(check ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IWorkerCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean check();
}
