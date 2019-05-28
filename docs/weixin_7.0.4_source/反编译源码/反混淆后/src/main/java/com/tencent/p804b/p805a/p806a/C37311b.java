package com.tencent.p804b.p805a.p806a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.b.a.a.b */
public interface C37311b extends IInterface {

    /* renamed from: com.tencent.b.a.a.b$a */
    public static abstract class C17720a extends Binder implements C37311b {
        private static final String DESCRIPTOR = "com.tencent.assistant.sdk.SDKActionCallback";
        static final int TRANSACTION_onActionResult = 1;

        /* renamed from: com.tencent.b.a.a.b$a$a */
        static class C17721a implements C37311b {
            private IBinder mRemote;

            C17721a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final void onActionResult(byte[] bArr) {
                AppMethodBeat.m2504i(75593);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(C17720a.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                    AppMethodBeat.m2505o(75593);
                }
            }
        }

        public C17720a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static C37311b asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C37311b)) {
                return new C17721a(iBinder);
            }
            return (C37311b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onActionResult(parcel.createByteArray());
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onActionResult(byte[] bArr);
}
