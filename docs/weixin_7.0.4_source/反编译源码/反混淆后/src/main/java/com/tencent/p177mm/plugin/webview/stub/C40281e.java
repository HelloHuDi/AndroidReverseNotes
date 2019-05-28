package com.tencent.p177mm.plugin.webview.stub;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.stub.C22913c.C4566a.C4567a;

/* renamed from: com.tencent.mm.plugin.webview.stub.e */
public interface C40281e extends IInterface {

    /* renamed from: com.tencent.mm.plugin.webview.stub.e$a */
    public static abstract class C40282a extends Binder implements C40281e {

        /* renamed from: com.tencent.mm.plugin.webview.stub.e$a$a */
        static class C14552a implements C40281e {
            private IBinder mRemote;

            C14552a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: IZ */
            public final boolean mo26778IZ(int i) {
                boolean z = true;
                AppMethodBeat.m2504i(7312);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7312);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7312);
                }
            }

            /* renamed from: c */
            public final boolean mo26784c(int i, Bundle bundle) {
                boolean z = true;
                AppMethodBeat.m2504i(7313);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7313);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7313);
                }
            }

            /* renamed from: a */
            public final boolean mo26780a(C22913c c22913c) {
                boolean z = false;
                AppMethodBeat.m2504i(7314);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeStrongBinder(c22913c != null ? c22913c.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7314);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7314);
                }
            }

            /* renamed from: a */
            public final boolean mo26781a(String str, String str2, Bundle bundle, boolean z) {
                boolean z2 = true;
                AppMethodBeat.m2504i(7315);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7315);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7315);
                }
            }

            public final String cYY() {
                AppMethodBeat.m2504i(7316);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7316);
                }
            }

            public final String getCurrentUrl() {
                AppMethodBeat.m2504i(7317);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7317);
                }
            }

            public final String cYZ() {
                AppMethodBeat.m2504i(7318);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7318);
                }
            }

            public final int cZa() {
                AppMethodBeat.m2504i(7319);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7319);
                }
            }

            /* renamed from: nJ */
            public final void mo26794nJ(boolean z) {
                int i = 0;
                AppMethodBeat.m2504i(7320);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7320);
                }
            }

            /* renamed from: nK */
            public final void mo26795nK(boolean z) {
                int i = 0;
                AppMethodBeat.m2504i(7321);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7321);
                }
            }

            /* renamed from: q */
            public final void mo26797q(int i, Bundle bundle) {
                AppMethodBeat.m2504i(7322);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7322);
                }
            }

            public final void cZb() {
                AppMethodBeat.m2504i(7323);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7323);
                }
            }

            /* renamed from: W */
            public final void mo9706W(Bundle bundle) {
                AppMethodBeat.m2504i(7324);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7324);
                }
            }

            public final void afd(String str) {
                AppMethodBeat.m2504i(7325);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7325);
                }
            }

            /* renamed from: hd */
            public final void mo26792hd(String str, String str2) {
                AppMethodBeat.m2504i(7326);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7326);
                }
            }

            public final void cZc() {
                AppMethodBeat.m2504i(7327);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7327);
                }
            }

            /* renamed from: e */
            public final void mo6225e(String str, String str2, int i, int i2) {
                AppMethodBeat.m2504i(7328);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7328);
                }
            }

            /* renamed from: g */
            public final Bundle mo6226g(int i, Bundle bundle) {
                AppMethodBeat.m2504i(7329);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle2;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7329);
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7329);
                }
            }

            /* renamed from: X */
            public final void mo26779X(Bundle bundle) {
                AppMethodBeat.m2504i(7330);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7330);
                }
            }

            /* renamed from: nL */
            public final void mo26796nL(boolean z) {
                int i = 0;
                AppMethodBeat.m2504i(7331);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7331);
                }
            }

            /* renamed from: he */
            public final void mo26793he(String str, String str2) {
                AppMethodBeat.m2504i(7332);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7332);
                }
            }

            /* renamed from: dj */
            public final Bundle mo26790dj(String str, String str2) {
                AppMethodBeat.m2504i(7333);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7333);
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7333);
                }
            }
        }

        public C40282a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
        }

        /* renamed from: H */
        public static C40281e m69080H(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C40281e)) {
                return new C14552a(iBinder);
            }
            return (C40281e) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle = null;
            boolean z = false;
            boolean IZ;
            int readInt;
            boolean c;
            int i3;
            String cYY;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    IZ = mo26778IZ(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(IZ ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    c = mo26784c(readInt, bundle);
                    parcel2.writeNoException();
                    if (c) {
                        readInt = 1;
                    } else {
                        readInt = 0;
                    }
                    parcel2.writeInt(readInt);
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 3:
                    C22913c c4567a;
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    IBinder readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.OnSceneEnd_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C22913c)) {
                            c4567a = new C4567a(readStrongBinder);
                        } else {
                            c4567a = (C22913c) queryLocalInterface;
                        }
                    }
                    IZ = mo26780a(c4567a);
                    parcel2.writeNoException();
                    if (IZ) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    if (parcel.readInt() != 0) {
                        c = true;
                    } else {
                        c = false;
                    }
                    IZ = mo26781a(readString, readString2, bundle, c);
                    parcel2.writeNoException();
                    if (IZ) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    cYY = cYY();
                    parcel2.writeNoException();
                    parcel2.writeString(cYY);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    cYY = getCurrentUrl();
                    parcel2.writeNoException();
                    parcel2.writeString(cYY);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    cYY = cYZ();
                    parcel2.writeNoException();
                    parcel2.writeString(cYY);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    int cZa = cZa();
                    parcel2.writeNoException();
                    parcel2.writeInt(cZa);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo26794nJ(z);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo26795nK(z);
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    i3 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo26797q(i3, bundle);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    cZb();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo9706W(bundle);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    afd(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    mo26792hd(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    cZc();
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    mo6225e(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    bundle = mo6226g(readInt, bundle);
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo26779X(bundle);
                    parcel2.writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo26796nL(z);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    mo26793he(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    bundle = mo26790dj(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_Callback_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: IZ */
    boolean mo26778IZ(int i);

    /* renamed from: W */
    void mo9706W(Bundle bundle);

    /* renamed from: X */
    void mo26779X(Bundle bundle);

    /* renamed from: a */
    boolean mo26780a(C22913c c22913c);

    /* renamed from: a */
    boolean mo26781a(String str, String str2, Bundle bundle, boolean z);

    void afd(String str);

    /* renamed from: c */
    boolean mo26784c(int i, Bundle bundle);

    String cYY();

    String cYZ();

    int cZa();

    void cZb();

    void cZc();

    /* renamed from: dj */
    Bundle mo26790dj(String str, String str2);

    /* renamed from: e */
    void mo6225e(String str, String str2, int i, int i2);

    /* renamed from: g */
    Bundle mo6226g(int i, Bundle bundle);

    String getCurrentUrl();

    /* renamed from: hd */
    void mo26792hd(String str, String str2);

    /* renamed from: he */
    void mo26793he(String str, String str2);

    /* renamed from: nJ */
    void mo26794nJ(boolean z);

    /* renamed from: nK */
    void mo26795nK(boolean z);

    /* renamed from: nL */
    void mo26796nL(boolean z);

    /* renamed from: q */
    void mo26797q(int i, Bundle bundle);
}
