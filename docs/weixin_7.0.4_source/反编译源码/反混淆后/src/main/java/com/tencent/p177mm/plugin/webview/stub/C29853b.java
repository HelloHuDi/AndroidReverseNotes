package com.tencent.p177mm.plugin.webview.stub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.webview.stub.b */
public interface C29853b extends IInterface {

    /* renamed from: com.tencent.mm.plugin.webview.stub.b$a */
    public static abstract class C29854a extends Binder implements C29853b {

        /* renamed from: com.tencent.mm.plugin.webview.stub.b$a$a */
        static class C22912a implements C29853b {
            private IBinder mRemote;

            C22912a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean cYV() {
                boolean z = true;
                AppMethodBeat.m2504i(7059);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7059);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7059);
                }
            }

            public final boolean getResult() {
                boolean z = false;
                AppMethodBeat.m2504i(7060);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7060);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7060);
                }
            }

            public final int getRet() {
                AppMethodBeat.m2504i(7061);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7061);
                }
            }

            public final int getType() {
                AppMethodBeat.m2504i(7062);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7062);
                }
            }
        }

        public C29854a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
        }

        /* renamed from: F */
        public static C29853b m47322F(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C29853b)) {
                return new C22912a(iBinder);
            }
            return (C29853b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean cYV;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    cYV = cYV();
                    parcel2.writeNoException();
                    if (cYV) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    cYV = getResult();
                    parcel2.writeNoException();
                    if (cYV) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    i3 = getRet();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    i3 = getType();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean cYV();

    boolean getResult();

    int getRet();

    int getType();
}
