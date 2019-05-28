package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends zzb implements IFragmentWrapper {

        public static class Proxy extends zza implements IFragmentWrapper {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            public IObjectWrapper getActivity() {
                AppMethodBeat.i(90369);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(90369);
                return asInterface;
            }

            public Bundle getArguments() {
                AppMethodBeat.i(90370);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
                Bundle bundle = (Bundle) zzc.zza(transactAndReadException, Bundle.CREATOR);
                transactAndReadException.recycle();
                AppMethodBeat.o(90370);
                return bundle;
            }

            public int getId() {
                AppMethodBeat.i(90371);
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                AppMethodBeat.o(90371);
                return readInt;
            }

            public IFragmentWrapper getParentFragment() {
                AppMethodBeat.i(90372);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
                IFragmentWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(90372);
                return asInterface;
            }

            public IObjectWrapper getResources() {
                AppMethodBeat.i(90373);
                Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(90373);
                return asInterface;
            }

            public boolean getRetainInstance() {
                AppMethodBeat.i(90374);
                Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(90374);
                return zza;
            }

            public String getTag() {
                AppMethodBeat.i(90375);
                Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
                String readString = transactAndReadException.readString();
                transactAndReadException.recycle();
                AppMethodBeat.o(90375);
                return readString;
            }

            public IFragmentWrapper getTargetFragment() {
                AppMethodBeat.i(90376);
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
                IFragmentWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(90376);
                return asInterface;
            }

            public int getTargetRequestCode() {
                AppMethodBeat.i(90377);
                Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                AppMethodBeat.o(90377);
                return readInt;
            }

            public boolean getUserVisibleHint() {
                AppMethodBeat.i(90378);
                Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(90378);
                return zza;
            }

            public IObjectWrapper getView() {
                AppMethodBeat.i(90379);
                Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.o(90379);
                return asInterface;
            }

            public boolean isAdded() {
                AppMethodBeat.i(90380);
                Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(90380);
                return zza;
            }

            public boolean isDetached() {
                AppMethodBeat.i(90381);
                Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(90381);
                return zza;
            }

            public boolean isHidden() {
                AppMethodBeat.i(90382);
                Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(90382);
                return zza;
            }

            public boolean isInLayout() {
                AppMethodBeat.i(90383);
                Parcel transactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(90383);
                return zza;
            }

            public boolean isRemoving() {
                AppMethodBeat.i(90384);
                Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(90384);
                return zza;
            }

            public boolean isResumed() {
                AppMethodBeat.i(90385);
                Parcel transactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(90385);
                return zza;
            }

            public boolean isVisible() {
                AppMethodBeat.i(90386);
                Parcel transactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                AppMethodBeat.o(90386);
                return zza;
            }

            public void registerForContextMenu(IObjectWrapper iObjectWrapper) {
                AppMethodBeat.i(90387);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                transactAndReadExceptionReturnVoid(20, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(90387);
            }

            public void setHasOptionsMenu(boolean z) {
                AppMethodBeat.i(90388);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(21, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(90388);
            }

            public void setMenuVisibility(boolean z) {
                AppMethodBeat.i(90389);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(22, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(90389);
            }

            public void setRetainInstance(boolean z) {
                AppMethodBeat.i(90390);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(23, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(90390);
            }

            public void setUserVisibleHint(boolean z) {
                AppMethodBeat.i(90391);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(24, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(90391);
            }

            public void startActivity(Intent intent) {
                AppMethodBeat.i(90392);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) intent);
                transactAndReadExceptionReturnVoid(25, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(90392);
            }

            public void startActivityForResult(Intent intent, int i) {
                AppMethodBeat.i(90393);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) intent);
                obtainAndWriteInterfaceToken.writeInt(i);
                transactAndReadExceptionReturnVoid(26, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(90393);
            }

            public void unregisterForContextMenu(IObjectWrapper iObjectWrapper) {
                AppMethodBeat.i(90394);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                transactAndReadExceptionReturnVoid(27, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(90394);
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            IInterface activity;
            int id;
            boolean retainInstance;
            switch (i) {
                case 2:
                    activity = getActivity();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, activity);
                    break;
                case 3:
                    Bundle arguments = getArguments();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, arguments);
                    break;
                case 4:
                    id = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    break;
                case 5:
                    activity = getParentFragment();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, activity);
                    break;
                case 6:
                    activity = getResources();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, activity);
                    break;
                case 7:
                    retainInstance = getRetainInstance();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 8:
                    String tag = getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    break;
                case 9:
                    activity = getTargetFragment();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, activity);
                    break;
                case 10:
                    id = getTargetRequestCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    break;
                case 11:
                    retainInstance = getUserVisibleHint();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 12:
                    activity = getView();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, activity);
                    break;
                case 13:
                    retainInstance = isAdded();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 14:
                    retainInstance = isDetached();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 15:
                    retainInstance = isHidden();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 16:
                    retainInstance = isInLayout();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 17:
                    retainInstance = isRemoving();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 18:
                    retainInstance = isResumed();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 19:
                    retainInstance = isVisible();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 20:
                    registerForContextMenu(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 21:
                    setHasOptionsMenu(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 22:
                    setMenuVisibility(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 23:
                    setRetainInstance(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 24:
                    setUserVisibleHint(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 25:
                    startActivity((Intent) zzc.zza(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 26:
                    startActivityForResult((Intent) zzc.zza(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    break;
                case 27:
                    unregisterForContextMenu(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper getActivity();

    Bundle getArguments();

    int getId();

    IFragmentWrapper getParentFragment();

    IObjectWrapper getResources();

    boolean getRetainInstance();

    String getTag();

    IFragmentWrapper getTargetFragment();

    int getTargetRequestCode();

    boolean getUserVisibleHint();

    IObjectWrapper getView();

    boolean isAdded();

    boolean isDetached();

    boolean isHidden();

    boolean isInLayout();

    boolean isRemoving();

    boolean isResumed();

    boolean isVisible();

    void registerForContextMenu(IObjectWrapper iObjectWrapper);

    void setHasOptionsMenu(boolean z);

    void setMenuVisibility(boolean z);

    void setRetainInstance(boolean z);

    void setUserVisibleHint(boolean z);

    void startActivity(Intent intent);

    void startActivityForResult(Intent intent, int i);

    void unregisterForContextMenu(IObjectWrapper iObjectWrapper);
}
