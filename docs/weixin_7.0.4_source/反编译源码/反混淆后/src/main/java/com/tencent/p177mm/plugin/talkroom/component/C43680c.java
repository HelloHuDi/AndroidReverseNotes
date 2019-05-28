package com.tencent.p177mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.talkroom.component.c */
public interface C43680c extends IInterface {

    /* renamed from: com.tencent.mm.plugin.talkroom.component.c$a */
    public static abstract class C39950a extends Binder implements C43680c {

        /* renamed from: com.tencent.mm.plugin.talkroom.component.c$a$a */
        static class C39951a implements C43680c {
            private IBinder mRemote;

            C39951a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: p */
            public final void mo26156p(int i, int i2, boolean z) {
                int i3 = 1;
                AppMethodBeat.m2504i(25702);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!z) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25702);
                }
            }
        }

        public C39950a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                    mo26156p(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: p */
    void mo26156p(int i, int i2, boolean z);
}
