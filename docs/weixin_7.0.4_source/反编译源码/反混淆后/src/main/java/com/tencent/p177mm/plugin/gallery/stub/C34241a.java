package com.tencent.p177mm.plugin.gallery.stub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.gallery.stub.a */
public interface C34241a extends IInterface {

    /* renamed from: com.tencent.mm.plugin.gallery.stub.a$a */
    public static abstract class C34242a extends Binder implements C34241a {

        /* renamed from: com.tencent.mm.plugin.gallery.stub.a$a$a */
        static class C34243a implements C34241a {
            private IBinder mRemote;

            C34243a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: aK */
            public final void mo36247aK(int i, String str) {
                AppMethodBeat.m2504i(21351);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(21351);
                }
            }

            public final void bCv() {
                AppMethodBeat.m2504i(21352);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(21352);
                }
            }

            /* renamed from: Nd */
            public final int mo36245Nd() {
                AppMethodBeat.m2504i(21353);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(21353);
                }
            }

            /* renamed from: a */
            public final void mo36246a(String str, String str2, boolean z, int i, boolean z2) {
                int i2 = 1;
                AppMethodBeat.m2504i(21354);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(21354);
                }
            }

            /* renamed from: Nb */
            public final int mo36244Nb() {
                AppMethodBeat.m2504i(21355);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(21355);
                }
            }

            /* renamed from: Na */
            public final int mo36243Na() {
                AppMethodBeat.m2504i(21356);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(21356);
                }
            }

            /* renamed from: hC */
            public final boolean mo36249hC(boolean z) {
                boolean z2 = true;
                AppMethodBeat.m2504i(21357);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(21357);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(21357);
                }
            }

            /* renamed from: ND */
            public final int mo36242ND(String str) {
                AppMethodBeat.m2504i(21358);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(21358);
                }
            }
        }

        public C34242a() {
            attachInterface(this, "com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
        }

        /* renamed from: B */
        public static C34241a m56168B(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C34241a)) {
                return new C34243a(iBinder);
            }
            return (C34241a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    mo36247aK(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    bCv();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = mo36245Nd();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    boolean z;
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    boolean z2 = parcel.readInt() != 0;
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    mo36246a(readString, readString2, z2, readInt, z);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = mo36244Nb();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = mo36243Na();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 7:
                    boolean z3;
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    if (parcel.readInt() != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z3 = mo36249hC(z3);
                    parcel2.writeNoException();
                    if (z3) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    i3 = mo36242ND(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.gallery.stub.Gallery_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: ND */
    int mo36242ND(String str);

    /* renamed from: Na */
    int mo36243Na();

    /* renamed from: Nb */
    int mo36244Nb();

    /* renamed from: Nd */
    int mo36245Nd();

    /* renamed from: a */
    void mo36246a(String str, String str2, boolean z, int i, boolean z2);

    /* renamed from: aK */
    void mo36247aK(int i, String str);

    void bCv();

    /* renamed from: hC */
    boolean mo36249hC(boolean z);
}
