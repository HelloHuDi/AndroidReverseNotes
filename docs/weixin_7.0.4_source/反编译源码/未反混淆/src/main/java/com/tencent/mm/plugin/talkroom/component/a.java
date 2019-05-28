package com.tencent.mm.plugin.talkroom.component;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
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

            public final int cEb() {
                AppMethodBeat.i(25692);
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
                    AppMethodBeat.o(25692);
                }
            }

            public final int uninitLive() {
                AppMethodBeat.i(25693);
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
                    AppMethodBeat.o(25693);
                }
            }

            public final int a(b bVar, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4) {
                AppMethodBeat.i(25694);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
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
                    AppMethodBeat.o(25694);
                }
            }

            public final int SetCurrentMicId(int i) {
                AppMethodBeat.i(25695);
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
                    AppMethodBeat.o(25695);
                }
            }

            public final int Close() {
                AppMethodBeat.i(25696);
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
                    AppMethodBeat.o(25696);
                }
            }

            public final byte[] e(int[] iArr, String str) {
                AppMethodBeat.i(25697);
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
                    AppMethodBeat.o(25697);
                }
            }

            public final e a(c cVar) {
                AppMethodBeat.i(25698);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    e E = com.tencent.mm.plugin.talkroom.component.e.a.E(obtain2.readStrongBinder());
                    return E;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(25698);
                }
            }

            public final d cEc() {
                AppMethodBeat.i(25699);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    d D = com.tencent.mm.plugin.talkroom.component.d.a.D(obtain2.readStrongBinder());
                    return D;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(25699);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
        }

        public static a C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
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
                    b bVar;
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        bVar = null;
                    } else {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.ILiveConEngineCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                            bVar = new a(readStrongBinder);
                        } else {
                            bVar = (b) queryLocalInterface;
                        }
                    }
                    cEb = a(bVar, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.createIntArray(), parcel.createIntArray(), parcel.readInt());
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
                    byte[] e = e(iArr, parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(e);
                    parcel2.writeIntArray(iArr);
                    return true;
                case 7:
                    c cVar;
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder == null) {
                        cVar = null;
                    } else {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.talkroom.component.IMemberUpdateCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof c)) {
                            cVar = new a(readStrongBinder);
                        } else {
                            cVar = (c) queryLocalInterface;
                        }
                    }
                    e a = a(cVar);
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.talkroom.component.IEngine_AIDL");
                    d cEc = cEc();
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

    int a(b bVar, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4);

    e a(c cVar);

    int cEb();

    d cEc();

    byte[] e(int[] iArr, String str);

    int uninitLive();
}
