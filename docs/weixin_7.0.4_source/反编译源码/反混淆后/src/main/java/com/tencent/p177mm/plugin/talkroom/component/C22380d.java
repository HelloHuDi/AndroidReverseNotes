package com.tencent.p177mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.talkroom.component.d */
public interface C22380d extends IInterface {

    /* renamed from: com.tencent.mm.plugin.talkroom.component.d$a */
    public static abstract class C4199a extends Binder implements C22380d {

        /* renamed from: com.tencent.mm.plugin.talkroom.component.d$a$a */
        static class C4200a implements C22380d {
            private IBinder mRemote;

            C4200a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final void cEd() {
                AppMethodBeat.m2504i(25703);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25703);
                }
            }

            public final void akw() {
                AppMethodBeat.m2504i(25704);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25704);
                }
            }

            public final void release() {
                AppMethodBeat.m2504i(25705);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25705);
                }
            }

            public final int cEe() {
                AppMethodBeat.m2504i(25706);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25706);
                }
            }

            public final void start() {
                AppMethodBeat.m2504i(25707);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25707);
                }
            }
        }

        public C4199a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
        }

        /* renamed from: D */
        public static C22380d m6544D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C22380d)) {
                return new C4200a(iBinder);
            }
            return (C22380d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    cEd();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    akw();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    release();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    int cEe = cEe();
                    parcel2.writeNoException();
                    parcel2.writeInt(cEe);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    start();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.talkroom.component.IMicRecoder_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void akw();

    void cEd();

    int cEe();

    void release();

    void start();
}
