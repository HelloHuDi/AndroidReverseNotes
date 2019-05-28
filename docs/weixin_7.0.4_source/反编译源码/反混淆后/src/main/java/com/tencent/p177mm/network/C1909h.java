package com.tencent.p177mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.network.h */
public interface C1909h extends IInterface {

    /* renamed from: com.tencent.mm.network.h$a */
    public static abstract class C1910a extends Binder implements C1909h {

        /* renamed from: com.tencent.mm.network.h$a$a */
        static class C1911a implements C1909h {
            private IBinder mRemote;

            C1911a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
                int i3 = 1;
                AppMethodBeat.m2504i(58518);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!z) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58518);
                }
            }
        }

        public C1910a() {
            attachInterface(this, "com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
                    networkAnalysisCallBack(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void networkAnalysisCallBack(int i, int i2, boolean z, String str);
}
