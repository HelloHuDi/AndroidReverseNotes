package com.tencent.p177mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.talkroom.component.b */
public interface C46295b extends IInterface {

    /* renamed from: com.tencent.mm.plugin.talkroom.component.b$a */
    public static abstract class C39949a extends Binder implements C46295b {

        /* renamed from: com.tencent.mm.plugin.talkroom.component.b$a$a */
        static class C13931a implements C46295b {
            private IBinder mRemote;

            C13931a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final void keep_OnOpenSuccess() {
                AppMethodBeat.m2504i(25700);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25700);
                }
            }

            public final void keep_OnError(int i) {
                AppMethodBeat.m2504i(25701);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25701);
                }
            }
        }

        public C39949a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    keep_OnOpenSuccess();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    keep_OnError(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void keep_OnError(int i);

    void keep_OnOpenSuccess();
}
