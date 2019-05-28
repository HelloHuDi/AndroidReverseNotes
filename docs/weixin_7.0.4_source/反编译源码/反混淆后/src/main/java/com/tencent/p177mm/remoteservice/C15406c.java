package com.tencent.p177mm.remoteservice;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.remoteservice.C30258b.C30259a;

/* renamed from: com.tencent.mm.remoteservice.c */
public interface C15406c extends IInterface {

    /* renamed from: com.tencent.mm.remoteservice.c$a */
    public static abstract class C15407a extends Binder implements C15406c {

        /* renamed from: com.tencent.mm.remoteservice.c$a$a */
        static class C15408a implements C15406c {
            private IBinder mRemote;

            C15408a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo27448a(String str, String str2, Bundle bundle, C30258b c30258b) {
                AppMethodBeat.m2504i(80223);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.remoteservice.ICommRemoteServer");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(c30258b != null ? c30258b.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle.readFromParcel(obtain2);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(80223);
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(80223);
                }
            }
        }

        public C15407a() {
            attachInterface(this, "com.tencent.mm.remoteservice.ICommRemoteServer");
        }

        /* renamed from: L */
        public static C15406c m23686L(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.remoteservice.ICommRemoteServer");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C15406c)) {
                return new C15408a(iBinder);
            }
            return (C15406c) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    Bundle bundle;
                    parcel.enforceInterface("com.tencent.mm.remoteservice.ICommRemoteServer");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    mo27448a(readString, readString2, bundle, C30259a.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (bundle != null) {
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.remoteservice.ICommRemoteServer");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo27448a(String str, String str2, Bundle bundle, C30258b c30258b);
}
