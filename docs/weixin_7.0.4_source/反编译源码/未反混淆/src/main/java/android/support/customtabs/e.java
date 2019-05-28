package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface e extends IInterface {

    public static abstract class a extends Binder implements e {
        public a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean bi;
            d a;
            switch (i) {
                case 2:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    parcel.readLong();
                    bi = bi();
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    bi = a(android.support.customtabs.d.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    a = android.support.customtabs.d.a.a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        Uri.CREATOR.createFromParcel(parcel);
                    }
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel.createTypedArrayList(Bundle.CREATOR);
                    bi = b(a);
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle bl = bl();
                    parcel2.writeNoException();
                    if (bl != null) {
                        parcel2.writeInt(1);
                        bl.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 6:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    a = android.support.customtabs.d.a.a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    bi = c(a);
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 7:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    a = android.support.customtabs.d.a.a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        Uri.CREATOR.createFromParcel(parcel);
                    }
                    bi = d(a);
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    d a2 = android.support.customtabs.d.a.a(parcel.readStrongBinder());
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    i3 = e(a2);
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    a = android.support.customtabs.d.a.a(parcel.readStrongBinder());
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                        Uri.CREATOR.createFromParcel(parcel);
                    }
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    bi = f(a);
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.customtabs.ICustomTabsService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean a(d dVar);

    boolean b(d dVar);

    boolean bi();

    Bundle bl();

    boolean c(d dVar);

    boolean d(d dVar);

    int e(d dVar);

    boolean f(d dVar);
}
