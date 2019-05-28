package android.content.p052pm;

import android.content.pm.PackageStats;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: android.content.pm.IPackageStatsObserver */
public interface IPackageStatsObserver extends IInterface {

    /* renamed from: android.content.pm.IPackageStatsObserver$Stub */
    public static abstract class Stub extends Binder implements IPackageStatsObserver {
        private static final String DESCRIPTOR = "IPackageStatsObserver";
        static final int TRANSACTION_onGetStatsCompleted = 1;

        /* renamed from: android.content.pm.IPackageStatsObserver$Stub$Proxy */
        static class Proxy implements IPackageStatsObserver {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (packageStats != null) {
                        obtain.writeInt(1);
                        packageStats.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPackageStatsObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IPackageStatsObserver)) {
                return new Proxy(iBinder);
            }
            return (IPackageStatsObserver) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    PackageStats packageStats;
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        packageStats = (PackageStats) PackageStats.CREATOR.createFromParcel(parcel);
                    } else {
                        packageStats = null;
                    }
                    onGetStatsCompleted(packageStats, parcel.readInt() != 0);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onGetStatsCompleted(PackageStats packageStats, boolean z);
}
