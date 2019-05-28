package com.tencent.p804b.p805a.p806a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p804b.p805a.p806a.C37311b.C17720a;

/* renamed from: com.tencent.b.a.a.a */
public interface C45078a extends IInterface {

    /* renamed from: com.tencent.b.a.a.a$a */
    public static abstract class C17719a extends Binder implements C45078a {

        /* renamed from: com.tencent.b.a.a.a$a$a */
        static class C8753a implements C45078a {
            private IBinder mRemote;

            C8753a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final int mo19809a(String str, String str2, C37311b c37311b) {
                AppMethodBeat.m2504i(75589);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(c37311b != null ? c37311b.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(75589);
                }
            }

            /* renamed from: a */
            public final int mo19808a(C37311b c37311b) {
                AppMethodBeat.m2504i(75590);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
                    obtain.writeStrongBinder(c37311b != null ? c37311b.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(75590);
                }
            }

            /* renamed from: c */
            public final byte[] mo19811c(String str, byte[] bArr) {
                AppMethodBeat.m2504i(75591);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(75591);
                }
            }

            /* renamed from: d */
            public final void mo19812d(String str, byte[] bArr) {
                AppMethodBeat.m2504i(75592);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.assistant.sdk.BaseService");
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(75592);
                }
            }
        }

        /* renamed from: j */
        public static C45078a m27644j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.assistant.sdk.BaseService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C45078a)) {
                return new C8753a(iBinder);
            }
            return (C45078a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int a;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.assistant.sdk.BaseService");
                    a = mo19809a(parcel.readString(), parcel.readString(), C17720a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.assistant.sdk.BaseService");
                    a = mo19808a(C17720a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.assistant.sdk.BaseService");
                    byte[] c = mo19811c(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeByteArray(c);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.assistant.sdk.BaseService");
                    mo19812d(parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.assistant.sdk.BaseService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    int mo19808a(C37311b c37311b);

    /* renamed from: a */
    int mo19809a(String str, String str2, C37311b c37311b);

    /* renamed from: c */
    byte[] mo19811c(String str, byte[] bArr);

    /* renamed from: d */
    void mo19812d(String str, byte[] bArr);
}
