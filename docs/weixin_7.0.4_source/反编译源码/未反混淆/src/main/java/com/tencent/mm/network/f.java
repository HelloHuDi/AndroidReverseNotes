package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.protocal.y;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.List;

public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        static class a implements f {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int a(r rVar, l lVar) {
                IBinder iBinder = null;
                AppMethodBeat.i(58480);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                    if (lVar != null) {
                        iBinder = lVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58480);
                }
            }

            public final void cancel(int i) {
                AppMethodBeat.i(58481);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58481);
                }
            }

            public final d amM() {
                AppMethodBeat.i(58482);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    d l = com.tencent.mm.network.d.a.l(obtain2.readStrongBinder());
                    return l;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58482);
                }
            }

            public final void reset() {
                AppMethodBeat.i(58483);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58483);
                }
            }

            public final void a(y yVar) {
                AppMethodBeat.i(58484);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(yVar != null ? yVar.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58484);
                }
            }

            public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
                int i3 = 0;
                AppMethodBeat.i(58485);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeIntArray(iArr);
                    obtain.writeIntArray(iArr2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58485);
                }
            }

            public final String[] getIPsString(boolean z) {
                int i = 0;
                AppMethodBeat.i(58486);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58486);
                }
            }

            public final String getNetworkServerIp() {
                AppMethodBeat.i(58487);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58487);
                }
            }

            public final void cF(boolean z) {
                int i = 0;
                AppMethodBeat.i(58488);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58488);
                }
            }

            public final void d(String str, String str2, String str3, String str4) {
                AppMethodBeat.i(58489);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58489);
                }
            }

            public final void setNewDnsDebugHost(String str, String str2) {
                AppMethodBeat.i(58490);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58490);
                }
            }

            public final void amN() {
                AppMethodBeat.i(58491);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58491);
                }
            }

            public final boolean acT() {
                boolean z = false;
                AppMethodBeat.i(58492);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58492);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58492);
                }
            }

            public final void a(b bVar) {
                AppMethodBeat.i(58493);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58493);
                }
            }

            public final void qs(String str) {
                AppMethodBeat.i(58494);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58494);
                }
            }

            public final i amO() {
                AppMethodBeat.i(58495);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    i n = com.tencent.mm.network.i.a.n(obtain2.readStrongBinder());
                    return n;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58495);
                }
            }

            public final int getHostByName(String str, List<String> list) {
                AppMethodBeat.i(58496);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringList(list);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58496);
                }
            }

            public final int a(boolean z, List<String> list) {
                int i = 0;
                AppMethodBeat.i(58497);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    i = obtain2.readInt();
                    obtain2.readStringList(list);
                    return i;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58497);
                }
            }

            public final int a(String str, boolean z, List<String> list) {
                int i = 0;
                AppMethodBeat.i(58498);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    i = obtain2.readInt();
                    obtain2.readStringList(list);
                    return i;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58498);
                }
            }

            public final void reportFailIp(String str) {
                AppMethodBeat.i(58499);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58499);
                }
            }

            public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
                AppMethodBeat.i(58500);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeIntArray(iArr);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58500);
                }
            }

            public final void a(int i, String str, int i2, boolean z) {
                int i3 = 0;
                AppMethodBeat.i(58501);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58501);
                }
            }

            public final void adi() {
                AppMethodBeat.i(58502);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58502);
                }
            }

            public final String getIspId() {
                AppMethodBeat.i(58503);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58503);
                }
            }

            public final int g(int i, byte[] bArr) {
                AppMethodBeat.i(58504);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58504);
                }
            }

            public final void setSignallingStrategy(long j, long j2) {
                AppMethodBeat.i(58505);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58505);
                }
            }

            public final void keepSignalling() {
                AppMethodBeat.i(58506);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58506);
                }
            }

            public final void stopSignalling() {
                AppMethodBeat.i(58507);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58507);
                }
            }

            public final void a(o oVar) {
                AppMethodBeat.i(58508);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58508);
                }
            }

            public final void a(s sVar) {
                AppMethodBeat.i(58509);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(sVar != null ? sVar.asBinder() : null);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58509);
                }
            }

            public final void a(g gVar) {
                AppMethodBeat.i(58510);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58510);
                }
            }

            public final void qt(String str) {
                AppMethodBeat.i(58511);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58511);
                }
            }

            public final void cG(boolean z) {
                int i = 0;
                AppMethodBeat.i(58512);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58512);
                }
            }

            public final void cH(boolean z) {
                int i = 0;
                AppMethodBeat.i(58513);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58513);
                }
            }

            public final void cI(boolean z) {
                int i = 0;
                AppMethodBeat.i(58514);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58514);
                }
            }

            public final void adj() {
                AppMethodBeat.i(58515);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58515);
                }
            }

            public final void a(h hVar) {
                AppMethodBeat.i(58516);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(58516);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.network.IDispatcher_AIDL");
        }

        public static f m(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IDispatcher_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof f)) {
                return new a(iBinder);
            }
            return (f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            h hVar = null;
            boolean z = false;
            IInterface queryLocalInterface;
            int a;
            IBinder asBinder;
            IBinder readStrongBinder;
            String networkServerIp;
            int i3;
            switch (i) {
                case 1:
                    l aVar;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    r q = com.tencent.mm.network.r.a.q(parcel.readStrongBinder());
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        queryLocalInterface = readStrongBinder2.queryLocalInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof l)) {
                            aVar = new a(readStrongBinder2);
                        } else {
                            aVar = (l) queryLocalInterface;
                        }
                    }
                    a = a(q, aVar);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    cancel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    d amM = amM();
                    parcel2.writeNoException();
                    if (amM != null) {
                        asBinder = amM.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    reset();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    y aVar2;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof y)) {
                            aVar2 = new com.tencent.mm.protocal.y.a.a(readStrongBinder);
                        } else {
                            aVar2 = (y) queryLocalInterface;
                        }
                    }
                    a(aVar2);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    a(z, parcel.readString(), parcel.readString(), parcel.createIntArray(), parcel.createIntArray(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    String[] iPsString = getIPsString(z);
                    parcel2.writeNoException();
                    parcel2.writeStringArray(iPsString);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    networkServerIp = getNetworkServerIp();
                    parcel2.writeNoException();
                    parcel2.writeString(networkServerIp);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    cF(z);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    d(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setNewDnsDebugHost(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    amN();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    boolean acT = acT();
                    parcel2.writeNoException();
                    if (acT) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    b aVar3;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                            aVar3 = new com.tencent.mm.network.a.b.a.a(readStrongBinder);
                        } else {
                            aVar3 = (b) queryLocalInterface;
                        }
                    }
                    a(aVar3);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    qs(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    i amO = amO();
                    parcel2.writeNoException();
                    if (amO != null) {
                        asBinder = amO.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    networkServerIp = parcel.readString();
                    ArrayList arrayList = new ArrayList();
                    a = getHostByName(networkServerIp, arrayList);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    parcel2.writeStringList(arrayList);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    i3 = a(z, (List) arrayList2);
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    parcel2.writeStringList(arrayList2);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    networkServerIp = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    a = a(networkServerIp, z, arrayList3);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    parcel2.writeStringList(arrayList3);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    reportFailIp(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setHostInfo(parcel.createStringArray(), parcel.createStringArray(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    a = parcel.readInt();
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    a(a, readString, readInt, z);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    adi();
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    networkServerIp = getIspId();
                    parcel2.writeNoException();
                    parcel2.writeString(networkServerIp);
                    return true;
                case 25:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    a = g(parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 26:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setSignallingStrategy(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    keepSignalling();
                    parcel2.writeNoException();
                    return true;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    stopSignalling();
                    parcel2.writeNoException();
                    return true;
                case 29:
                    o aVar4;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IOnReportKV_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof o)) {
                            aVar4 = new a(readStrongBinder);
                        } else {
                            aVar4 = (o) queryLocalInterface;
                        }
                    }
                    a(aVar4);
                    parcel2.writeNoException();
                    return true;
                case 30:
                    s aVar5;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof s)) {
                            aVar5 = new a(readStrongBinder);
                        } else {
                            aVar5 = (s) queryLocalInterface;
                        }
                    }
                    a(aVar5);
                    parcel2.writeNoException();
                    return true;
                case 31:
                    g aVar6;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IIpxxCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof g)) {
                            aVar6 = new a(readStrongBinder);
                        } else {
                            aVar6 = (g) queryLocalInterface;
                        }
                    }
                    a(aVar6);
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    qt(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    cG(z);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    cH(z);
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    cI(z);
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    adj();
                    parcel2.writeNoException();
                    return true;
                case g.CTRL_INDEX /*37*/:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
                        hVar = (queryLocalInterface == null || !(queryLocalInterface instanceof h)) ? new a(readStrongBinder) : (h) queryLocalInterface;
                    }
                    a(hVar);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IDispatcher_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int a(r rVar, l lVar);

    int a(String str, boolean z, List<String> list);

    int a(boolean z, List<String> list);

    void a(int i, String str, int i2, boolean z);

    void a(b bVar);

    void a(g gVar);

    void a(h hVar);

    void a(o oVar);

    void a(s sVar);

    void a(y yVar);

    void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4);

    boolean acT();

    void adi();

    void adj();

    d amM();

    void amN();

    i amO();

    void cF(boolean z);

    void cG(boolean z);

    void cH(boolean z);

    void cI(boolean z);

    void cancel(int i);

    void d(String str, String str2, String str3, String str4);

    int g(int i, byte[] bArr);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void keepSignalling();

    void qs(String str);

    void qt(String str);

    void reportFailIp(String str);

    void reset();

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setNewDnsDebugHost(String str, String str2);

    void setSignallingStrategy(long j, long j2);

    void stopSignalling();
}
