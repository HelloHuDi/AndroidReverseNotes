package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.customtabs.C25293d.C25294a;

/* renamed from: android.support.customtabs.e */
public interface C8317e extends IInterface {

    /* renamed from: android.support.customtabs.e$a */
    public static abstract class C8318a extends Binder implements C8317e {
        public C8318a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean bi;
            C25293d a;
            switch (i) {
                case 2:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    parcel.readLong();
                    bi = mo362bi();
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    bi = mo360a(C25294a.m39869a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    a = C25294a.m39869a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        Uri.CREATOR.createFromParcel(parcel);
                    }
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    parcel.createTypedArrayList(Bundle.CREATOR);
                    bi = mo361b(a);
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
                    Bundle bl = mo363bl();
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
                    a = C25294a.m39869a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    bi = mo364c(a);
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 7:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    a = C25294a.m39869a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        Uri.CREATOR.createFromParcel(parcel);
                    }
                    bi = mo365d(a);
                    parcel2.writeNoException();
                    if (bi) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    C25293d a2 = C25294a.m39869a(parcel.readStrongBinder());
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    i3 = mo366e(a2);
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsService");
                    a = C25294a.m39869a(parcel.readStrongBinder());
                    parcel.readInt();
                    if (parcel.readInt() != 0) {
                        Uri.CREATOR.createFromParcel(parcel);
                    }
                    if (parcel.readInt() != 0) {
                        Bundle.CREATOR.createFromParcel(parcel);
                    }
                    bi = mo367f(a);
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

    /* renamed from: a */
    boolean mo360a(C25293d c25293d);

    /* renamed from: b */
    boolean mo361b(C25293d c25293d);

    /* renamed from: bi */
    boolean mo362bi();

    /* renamed from: bl */
    Bundle mo363bl();

    /* renamed from: c */
    boolean mo364c(C25293d c25293d);

    /* renamed from: d */
    boolean mo365d(C25293d c25293d);

    /* renamed from: e */
    int mo366e(C25293d c25293d);

    /* renamed from: f */
    boolean mo367f(C25293d c25293d);
}
