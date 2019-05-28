package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.customtabs.C25293d.C25294a;

/* renamed from: android.support.customtabs.f */
public interface C25296f extends IInterface {

    /* renamed from: android.support.customtabs.f$a */
    public static abstract class C25297a extends Binder implements C25296f {
        public C25297a() {
            attachInterface(this, "android.support.customtabs.IPostMessageService");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle = null;
            C25293d a;
            switch (i) {
                case 2:
                    parcel.enforceInterface("android.support.customtabs.IPostMessageService");
                    a = C25294a.m39869a(parcel.readStrongBinder());
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo42152a(a, bundle);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.customtabs.IPostMessageService");
                    a = C25294a.m39869a(parcel.readStrongBinder());
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    mo42153a(a, readString, bundle);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.customtabs.IPostMessageService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: a */
    void mo42152a(C25293d c25293d, Bundle bundle);

    /* renamed from: a */
    void mo42153a(C25293d c25293d, String str, Bundle bundle);
}
