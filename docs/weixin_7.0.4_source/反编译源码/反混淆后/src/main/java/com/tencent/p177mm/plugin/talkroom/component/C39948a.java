package com.tencent.p177mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.talkroom.component.C22380d.C4199a;
import com.tencent.p177mm.plugin.talkroom.component.C22381e.C22382a;
import com.tencent.p177mm.plugin.talkroom.component.C43680c.C39950a.C39951a;
import com.tencent.p177mm.plugin.talkroom.component.C46295b.C39949a.C13931a;

/* renamed from: com.tencent.mm.plugin.talkroom.component.a */
public interface C39948a extends IInterface {

    /* renamed from: com.tencent.mm.plugin.talkroom.component.a$a */
    public static abstract class C22379a extends Binder implements C39948a {

        /* renamed from: com.tencent.mm.plugin.talkroom.component.a$a$a */
        static class C13930a implements C39948a {
            private IBinder mRemote;

            C13930a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int cEb() {
                AppMethodBeat.m2504i(25692);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25692);
                }
            }

            public final int uninitLive() {
                AppMethodBeat.m2504i(25693);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25693);
                }
            }

            /* renamed from: a */
            public final int mo26145a(C46295b c46295b, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4) {
                AppMethodBeat.m2504i(25694);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    obtain.writeStrongBinder(c46295b != null ? c46295b.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeLong(j);
                    obtain.writeIntArray(iArr);
                    obtain.writeIntArray(iArr2);
                    obtain.writeInt(i4);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25694);
                }
            }

            public final int SetCurrentMicId(int i) {
                AppMethodBeat.m2504i(25695);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25695);
                }
            }

            public final int Close() {
                AppMethodBeat.m2504i(25696);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25696);
                }
            }

            /* renamed from: e */
            public final byte[] mo26150e(int[] iArr, String str) {
                AppMethodBeat.m2504i(25697);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    if (iArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(iArr.length);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    obtain2.readIntArray(iArr);
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25697);
                }
            }

            /* renamed from: a */
            public final C22381e mo26146a(C43680c c43680c) {
                AppMethodBeat.m2504i(25698);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    obtain.writeStrongBinder(c43680c != null ? c43680c.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    C22381e E = C22382a.m34101E(obtain2.readStrongBinder());
                    return E;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25698);
                }
            }

            public final C22380d cEc() {
                AppMethodBeat.m2504i(25699);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    C22380d D = C4199a.m6544D(obtain2.readStrongBinder());
                    return D;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(25699);
                }
            }
        }

        public C22379a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
        }

        /* renamed from: C */
        public static C39948a m34100C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C39948a)) {
                return new C13930a(iBinder);
            }
            return (C39948a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int cEb;
            IBinder readStrongBinder;
            IInterface queryLocalInterface;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    cEb = cEb();
                    parcel2.writeNoException();
                    parcel2.writeInt(cEb);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    cEb = uninitLive();
                    parcel2.writeNoException();
                    parcel2.writeInt(cEb);
                    return true;
                case 3:
                    C46295b c46295b;
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        c46295b = null;
                    } else {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C46295b)) {
                            c46295b = new C13931a(readStrongBinder);
                        } else {
                            c46295b = (C46295b) queryLocalInterface;
                        }
                    }
                    cEb = mo26145a(c46295b, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.createIntArray(), parcel.createIntArray(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(cEb);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    cEb = SetCurrentMicId(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(cEb);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    cEb = Close();
                    parcel2.writeNoException();
                    parcel2.writeInt(cEb);
                    return true;
                case 6:
                    int[] iArr;
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    cEb = parcel.readInt();
                    if (cEb < 0) {
                        iArr = null;
                    } else {
                        iArr = new int[cEb];
                    }
                    byte[] e = mo26150e(iArr, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(e);
                    parcel2.writeIntArray(iArr);
                    return true;
                case 7:
                    C43680c c43680c;
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        c43680c = null;
                    } else {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C43680c)) {
                            c43680c = new C39951a(readStrongBinder);
                        } else {
                            c43680c = (C43680c) queryLocalInterface;
                        }
                    }
                    C22381e a = mo26146a(c43680c);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    C22380d cEc = cEc();
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(cEc != null ? cEc.asBinder() : null);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int Close();

    int SetCurrentMicId(int i);

    /* renamed from: a */
    int mo26145a(C46295b c46295b, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4);

    /* renamed from: a */
    C22381e mo26146a(C43680c c43680c);

    int cEb();

    C22380d cEc();

    /* renamed from: e */
    byte[] mo26150e(int[] iArr, String str);

    int uninitLive();
}
