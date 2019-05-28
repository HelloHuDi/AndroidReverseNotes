package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;

public interface IGmsServiceBroker extends IInterface {

    public static abstract class Stub extends Binder implements IGmsServiceBroker {

        static class zza implements IGmsServiceBroker {
            private final IBinder zza;

            zza(IBinder iBinder) {
                this.zza = iBinder;
            }

            public final IBinder asBinder() {
                return this.zza;
            }

            public final void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) {
                AppMethodBeat.m2504i(89673);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zza.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(89673);
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        public static IGmsServiceBroker asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) ? new zza(iBinder) : (IGmsServiceBroker) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* Access modifiers changed, original: protected */
        public void getLegacyService(int i, IGmsCallbacks iGmsCallbacks, int i2, String str, String str2, String[] strArr, Bundle bundle, IBinder iBinder, String str3, String str4) {
            throw new UnsupportedOperationException();
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i > 16777215) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IGmsCallbacks asInterface = com.google.android.gms.common.internal.IGmsCallbacks.Stub.asInterface(parcel.readStrongBinder());
            if (i == 46) {
                getService(asInterface, parcel.readInt() != 0 ? (GetServiceRequest) GetServiceRequest.CREATOR.createFromParcel(parcel) : null);
            } else if (i == 47) {
                validateAccount(asInterface, parcel.readInt() != 0 ? (ValidateAccountRequest) ValidateAccountRequest.CREATOR.createFromParcel(parcel) : null);
            } else {
                String readString;
                String[] createStringArray;
                String readString2;
                String str;
                IBinder iBinder;
                Bundle bundle;
                int readInt = parcel.readInt();
                String readString3 = i != 4 ? parcel.readString() : null;
                switch (i) {
                    case 1:
                        readString = parcel.readString();
                        createStringArray = parcel.createStringArray();
                        readString2 = parcel.readString();
                        if (parcel.readInt() == 0) {
                            str = null;
                            iBinder = null;
                            bundle = null;
                            break;
                        }
                        str = null;
                        iBinder = null;
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        break;
                    case 2:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 23:
                    case 25:
                    case 27:
                    case C2275g.CTRL_INDEX /*37*/:
                    case 38:
                    case 41:
                    case 43:
                        if (parcel.readInt() != 0) {
                            str = null;
                            readString = null;
                            iBinder = null;
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            createStringArray = null;
                            readString2 = null;
                            break;
                        }
                    case 9:
                        readString2 = parcel.readString();
                        createStringArray = parcel.createStringArray();
                        readString = parcel.readString();
                        iBinder = parcel.readStrongBinder();
                        str = parcel.readString();
                        if (parcel.readInt() == 0) {
                            bundle = null;
                            break;
                        }
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        break;
                    case 10:
                        readString2 = parcel.readString();
                        createStringArray = parcel.createStringArray();
                        str = null;
                        readString = null;
                        iBinder = null;
                        bundle = null;
                        break;
                    case 19:
                        iBinder = parcel.readStrongBinder();
                        if (parcel.readInt() == 0) {
                            str = null;
                            readString = null;
                            bundle = null;
                            createStringArray = null;
                            readString2 = null;
                            break;
                        }
                        str = null;
                        readString = null;
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        createStringArray = null;
                        readString2 = null;
                        break;
                    case 20:
                    case 30:
                        createStringArray = parcel.createStringArray();
                        readString2 = parcel.readString();
                        if (parcel.readInt() == 0) {
                            str = null;
                            readString = null;
                            iBinder = null;
                            bundle = null;
                            break;
                        }
                        str = null;
                        readString = null;
                        iBinder = null;
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        break;
                    case 34:
                        readString2 = parcel.readString();
                        str = null;
                        readString = null;
                        iBinder = null;
                        bundle = null;
                        createStringArray = null;
                        break;
                    default:
                        str = null;
                        readString = null;
                        iBinder = null;
                        bundle = null;
                        createStringArray = null;
                        readString2 = null;
                        break;
                }
                getLegacyService(i, asInterface, readInt, readString3, readString2, createStringArray, bundle, iBinder, readString, str);
            }
            parcel2.writeNoException();
            return true;
        }

        /* Access modifiers changed, original: protected */
        public void validateAccount(IGmsCallbacks iGmsCallbacks, ValidateAccountRequest validateAccountRequest) {
            throw new UnsupportedOperationException();
        }
    }

    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest);
}
