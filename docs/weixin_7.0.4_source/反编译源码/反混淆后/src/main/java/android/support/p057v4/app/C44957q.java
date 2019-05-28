package android.support.p057v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: android.support.v4.app.q */
public interface C44957q extends IInterface {

    /* renamed from: android.support.v4.app.q$a */
    public static abstract class C25333a extends Binder implements C44957q {

        /* renamed from: android.support.v4.app.q$a$a */
        static class C25332a implements C44957q {
            private IBinder mRemote;

            C25332a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final void mo42299a(String str, int i, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public final void mo42301b(String str, int i, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: J */
            public final void mo42298J(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        /* renamed from: b */
        public static C44957q m39979b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C44957q)) {
                return new C25332a(iBinder);
            }
            return (C44957q) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    Notification notification;
                    parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
                    } else {
                        notification = null;
                    }
                    mo42299a(readString, readInt, readString2, notification);
                    return true;
                case 2:
                    parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    mo42301b(parcel.readString(), parcel.readInt(), parcel.readString());
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    mo42298J(parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.v4.app.INotificationSideChannel");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: J */
    void mo42298J(String str);

    /* renamed from: a */
    void mo42299a(String str, int i, String str2, Notification notification);

    /* renamed from: b */
    void mo42301b(String str, int i, String str2);
}
