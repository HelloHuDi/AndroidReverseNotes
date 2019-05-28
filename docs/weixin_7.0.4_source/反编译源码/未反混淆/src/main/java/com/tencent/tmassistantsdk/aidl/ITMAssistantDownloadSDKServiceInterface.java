package com.tencent.tmassistantsdk.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import java.util.Map;

public interface ITMAssistantDownloadSDKServiceInterface extends IInterface {

    public static abstract class Stub extends Binder implements ITMAssistantDownloadSDKServiceInterface {
        private static final String DESCRIPTOR = "com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceInterface";
        static final int TRANSACTION_cancelDownloadTask = 9;
        static final int TRANSACTION_getDownloadTaskInfo = 6;
        static final int TRANSACTION_getServiceVersion = 1;
        static final int TRANSACTION_isAllDownloadFinished = 5;
        static final int TRANSACTION_pauseDownloadTask = 8;
        static final int TRANSACTION_registerDownloadTaskCallback = 10;
        static final int TRANSACTION_setServiceSetingIsDownloadWifiOnly = 3;
        static final int TRANSACTION_setServiceSetingIsTaskAutoResume = 2;
        static final int TRANSACTION_setServiceSetingMaxTaskNum = 4;
        static final int TRANSACTION_startDownloadTask = 7;
        static final int TRANSACTION_unregisterDownloadTaskCallback = 11;

        static class Proxy implements ITMAssistantDownloadSDKServiceInterface {
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

            public int getServiceVersion() {
                AppMethodBeat.i(75596);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75596);
                }
            }

            public void setServiceSetingIsTaskAutoResume(boolean z) {
                int i = 0;
                AppMethodBeat.i(75597);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75597);
                }
            }

            public void setServiceSetingIsDownloadWifiOnly(boolean z) {
                int i = 0;
                AppMethodBeat.i(75598);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75598);
                }
            }

            public void setServiceSetingMaxTaskNum(int i) {
                AppMethodBeat.i(75599);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75599);
                }
            }

            public boolean isAllDownloadFinished() {
                boolean z = false;
                AppMethodBeat.i(75600);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75600);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75600);
                }
            }

            public TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2) {
                AppMethodBeat.i(75601);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo;
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        tMAssistantDownloadTaskInfo = (TMAssistantDownloadTaskInfo) TMAssistantDownloadTaskInfo.CREATOR.createFromParcel(obtain2);
                    } else {
                        tMAssistantDownloadTaskInfo = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75601);
                    return tMAssistantDownloadTaskInfo;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75601);
                }
            }

            public int startDownloadTask(String str, String str2, String str3, long j, int i, String str4, String str5, Map map) {
                AppMethodBeat.i(75602);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    obtain.writeString(str4);
                    obtain.writeString(str5);
                    obtain.writeMap(map);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75602);
                }
            }

            public void pauseDownloadTask(String str, String str2) {
                AppMethodBeat.i(75603);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75603);
                }
            }

            public void cancelDownloadTask(String str, String str2) {
                AppMethodBeat.i(75604);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75604);
                }
            }

            public void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
                AppMethodBeat.i(75605);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTMAssistantDownloadSDKServiceCallback != null ? iTMAssistantDownloadSDKServiceCallback.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75605);
                }
            }

            public void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback) {
                AppMethodBeat.i(75606);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iTMAssistantDownloadSDKServiceCallback != null ? iTMAssistantDownloadSDKServiceCallback.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(75606);
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITMAssistantDownloadSDKServiceInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITMAssistantDownloadSDKServiceInterface)) {
                return new Proxy(iBinder);
            }
            return (ITMAssistantDownloadSDKServiceInterface) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean z;
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    i3 = getServiceVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setServiceSetingIsTaskAutoResume(z);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setServiceSetingIsDownloadWifiOnly(z);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    setServiceSetingMaxTaskNum(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isAllDownloadFinished = isAllDownloadFinished();
                    parcel2.writeNoException();
                    if (isAllDownloadFinished) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    TMAssistantDownloadTaskInfo downloadTaskInfo = getDownloadTaskInfo(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (downloadTaskInfo != null) {
                        parcel2.writeInt(1);
                        downloadTaskInfo.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    i3 = startDownloadTask(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    pauseDownloadTask(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancelDownloadTask(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerDownloadTaskCallback(parcel.readString(), com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterDownloadTaskCallback(parcel.readString(), com.tencent.tmassistantsdk.aidl.ITMAssistantDownloadSDKServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void cancelDownloadTask(String str, String str2);

    TMAssistantDownloadTaskInfo getDownloadTaskInfo(String str, String str2);

    int getServiceVersion();

    boolean isAllDownloadFinished();

    void pauseDownloadTask(String str, String str2);

    void registerDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback);

    void setServiceSetingIsDownloadWifiOnly(boolean z);

    void setServiceSetingIsTaskAutoResume(boolean z);

    void setServiceSetingMaxTaskNum(int i);

    int startDownloadTask(String str, String str2, String str3, long j, int i, String str4, String str5, Map map);

    void unregisterDownloadTaskCallback(String str, ITMAssistantDownloadSDKServiceCallback iTMAssistantDownloadSDKServiceCallback);
}
