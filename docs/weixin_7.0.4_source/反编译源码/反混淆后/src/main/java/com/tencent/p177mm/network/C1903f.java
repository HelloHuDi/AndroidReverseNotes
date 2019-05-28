package com.tencent.p177mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1899d.C1900a;
import com.tencent.p177mm.network.C1906g.C1907a.C1908a;
import com.tencent.p177mm.network.C1909h.C1910a.C1911a;
import com.tencent.p177mm.network.C1912i.C1913a;
import com.tencent.p177mm.network.C1919l.C1920a.C1921a;
import com.tencent.p177mm.network.C1926o.C1927a.C1928a;
import com.tencent.p177mm.network.C1930r.C1931a;
import com.tencent.p177mm.network.C1933s.C1934a.C1935a;
import com.tencent.p177mm.network.p265a.C1889b;
import com.tencent.p177mm.network.p265a.C1889b.C1890a.C1891a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.protocal.C4848y;
import com.tencent.p177mm.protocal.C4848y.C4849a.C4850a;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.network.f */
public interface C1903f extends IInterface {

    /* renamed from: com.tencent.mm.network.f$a */
    public static abstract class C1904a extends Binder implements C1903f {

        /* renamed from: com.tencent.mm.network.f$a$a */
        static class C1905a implements C1903f {
            private IBinder mRemote;

            C1905a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            /* renamed from: a */
            public final int mo5548a(C1930r c1930r, C1919l c1919l) {
                IBinder iBinder = null;
                AppMethodBeat.m2504i(58480);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(c1930r != null ? c1930r.asBinder() : null);
                    if (c1919l != null) {
                        iBinder = c1919l.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58480);
                }
            }

            public final void cancel(int i) {
                AppMethodBeat.m2504i(58481);
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
                    AppMethodBeat.m2505o(58481);
                }
            }

            public final C1899d amM() {
                AppMethodBeat.m2504i(58482);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    C1899d l = C1900a.m4043l(obtain2.readStrongBinder());
                    return l;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58482);
                }
            }

            public final void reset() {
                AppMethodBeat.m2504i(58483);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58483);
                }
            }

            /* renamed from: a */
            public final void mo5557a(C4848y c4848y) {
                AppMethodBeat.m2504i(58484);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(c4848y != null ? c4848y.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58484);
                }
            }

            /* renamed from: a */
            public final void mo5558a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
                int i3 = 0;
                AppMethodBeat.m2504i(58485);
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
                    AppMethodBeat.m2505o(58485);
                }
            }

            public final String[] getIPsString(boolean z) {
                int i = 0;
                AppMethodBeat.m2504i(58486);
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
                    AppMethodBeat.m2505o(58486);
                }
            }

            public final String getNetworkServerIp() {
                AppMethodBeat.m2504i(58487);
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
                    AppMethodBeat.m2505o(58487);
                }
            }

            /* renamed from: cF */
            public final void mo5565cF(boolean z) {
                int i = 0;
                AppMethodBeat.m2504i(58488);
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
                    AppMethodBeat.m2505o(58488);
                }
            }

            /* renamed from: d */
            public final void mo5570d(String str, String str2, String str3, String str4) {
                AppMethodBeat.m2504i(58489);
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
                    AppMethodBeat.m2505o(58489);
                }
            }

            public final void setNewDnsDebugHost(String str, String str2) {
                AppMethodBeat.m2504i(58490);
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
                    AppMethodBeat.m2505o(58490);
                }
            }

            public final void amN() {
                AppMethodBeat.m2504i(58491);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58491);
                }
            }

            public final boolean acT() {
                boolean z = false;
                AppMethodBeat.m2504i(58492);
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
                    AppMethodBeat.m2505o(58492);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58492);
                }
            }

            /* renamed from: a */
            public final void mo5552a(C1889b c1889b) {
                AppMethodBeat.m2504i(58493);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(c1889b != null ? c1889b.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58493);
                }
            }

            /* renamed from: qs */
            public final void mo5577qs(String str) {
                AppMethodBeat.m2504i(58494);
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
                    AppMethodBeat.m2505o(58494);
                }
            }

            public final C1912i amO() {
                AppMethodBeat.m2504i(58495);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    C1912i n = C1913a.m4112n(obtain2.readStrongBinder());
                    return n;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58495);
                }
            }

            public final int getHostByName(String str, List<String> list) {
                AppMethodBeat.m2504i(58496);
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
                    AppMethodBeat.m2505o(58496);
                }
            }

            /* renamed from: a */
            public final int mo5550a(boolean z, List<String> list) {
                int i = 0;
                AppMethodBeat.m2504i(58497);
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
                    AppMethodBeat.m2505o(58497);
                }
            }

            /* renamed from: a */
            public final int mo5549a(String str, boolean z, List<String> list) {
                int i = 0;
                AppMethodBeat.m2504i(58498);
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
                    AppMethodBeat.m2505o(58498);
                }
            }

            public final void reportFailIp(String str) {
                AppMethodBeat.m2504i(58499);
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
                    AppMethodBeat.m2505o(58499);
                }
            }

            public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
                AppMethodBeat.m2504i(58500);
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
                    AppMethodBeat.m2505o(58500);
                }
            }

            /* renamed from: a */
            public final void mo5551a(int i, String str, int i2, boolean z) {
                int i3 = 0;
                AppMethodBeat.m2504i(58501);
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
                    AppMethodBeat.m2505o(58501);
                }
            }

            public final void adi() {
                AppMethodBeat.m2504i(58502);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58502);
                }
            }

            public final String getIspId() {
                AppMethodBeat.m2504i(58503);
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
                    AppMethodBeat.m2505o(58503);
                }
            }

            /* renamed from: g */
            public final int mo5571g(int i, byte[] bArr) {
                AppMethodBeat.m2504i(58504);
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
                    AppMethodBeat.m2505o(58504);
                }
            }

            public final void setSignallingStrategy(long j, long j2) {
                AppMethodBeat.m2504i(58505);
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
                    AppMethodBeat.m2505o(58505);
                }
            }

            public final void keepSignalling() {
                AppMethodBeat.m2504i(58506);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58506);
                }
            }

            public final void stopSignalling() {
                AppMethodBeat.m2504i(58507);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58507);
                }
            }

            /* renamed from: a */
            public final void mo5555a(C1926o c1926o) {
                AppMethodBeat.m2504i(58508);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(c1926o != null ? c1926o.asBinder() : null);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58508);
                }
            }

            /* renamed from: a */
            public final void mo5556a(C1933s c1933s) {
                AppMethodBeat.m2504i(58509);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(c1933s != null ? c1933s.asBinder() : null);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58509);
                }
            }

            /* renamed from: a */
            public final void mo5553a(C1906g c1906g) {
                AppMethodBeat.m2504i(58510);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(c1906g != null ? c1906g.asBinder() : null);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58510);
                }
            }

            /* renamed from: qt */
            public final void mo5578qt(String str) {
                AppMethodBeat.m2504i(58511);
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
                    AppMethodBeat.m2505o(58511);
                }
            }

            /* renamed from: cG */
            public final void mo5566cG(boolean z) {
                int i = 0;
                AppMethodBeat.m2504i(58512);
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
                    AppMethodBeat.m2505o(58512);
                }
            }

            /* renamed from: cH */
            public final void mo5567cH(boolean z) {
                int i = 0;
                AppMethodBeat.m2504i(58513);
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
                    AppMethodBeat.m2505o(58513);
                }
            }

            /* renamed from: cI */
            public final void mo5568cI(boolean z) {
                int i = 0;
                AppMethodBeat.m2504i(58514);
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
                    AppMethodBeat.m2505o(58514);
                }
            }

            public final void adj() {
                AppMethodBeat.m2504i(58515);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58515);
                }
            }

            /* renamed from: a */
            public final void mo5554a(C1909h c1909h) {
                AppMethodBeat.m2504i(58516);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(c1909h != null ? c1909h.asBinder() : null);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(58516);
                }
            }
        }

        public C1904a() {
            attachInterface(this, "com.tencent.mm.network.IDispatcher_AIDL");
        }

        /* renamed from: m */
        public static C1903f m4088m(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IDispatcher_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C1903f)) {
                return new C1905a(iBinder);
            }
            return (C1903f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            C1909h c1909h = null;
            boolean z = false;
            IInterface queryLocalInterface;
            int a;
            IBinder asBinder;
            IBinder readStrongBinder;
            String networkServerIp;
            int i3;
            switch (i) {
                case 1:
                    C1919l c1921a;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    C1930r q = C1931a.m4130q(parcel.readStrongBinder());
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        queryLocalInterface = readStrongBinder2.queryLocalInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1919l)) {
                            c1921a = new C1921a(readStrongBinder2);
                        } else {
                            c1921a = (C1919l) queryLocalInterface;
                        }
                    }
                    a = mo5548a(q, c1921a);
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
                    C1899d amM = amM();
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
                    C4848y c4850a;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C4848y)) {
                            c4850a = new C4850a(readStrongBinder);
                        } else {
                            c4850a = (C4848y) queryLocalInterface;
                        }
                    }
                    mo5557a(c4850a);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo5558a(z, parcel.readString(), parcel.readString(), parcel.createIntArray(), parcel.createIntArray(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
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
                    mo5565cF(z);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    mo5570d(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
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
                    C1889b c1891a;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1889b)) {
                            c1891a = new C1891a(readStrongBinder);
                        } else {
                            c1891a = (C1889b) queryLocalInterface;
                        }
                    }
                    mo5552a(c1891a);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    mo5577qs(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    C1912i amO = amO();
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
                    i3 = mo5550a(z, (List) arrayList2);
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
                    a = mo5549a(networkServerIp, z, arrayList3);
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
                    mo5551a(a, readString, readInt, z);
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
                    a = mo5571g(parcel.readInt(), parcel.createByteArray());
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
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    stopSignalling();
                    parcel2.writeNoException();
                    return true;
                case 29:
                    C1926o c1928a;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IOnReportKV_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1926o)) {
                            c1928a = new C1928a(readStrongBinder);
                        } else {
                            c1928a = (C1926o) queryLocalInterface;
                        }
                    }
                    mo5555a(c1928a);
                    parcel2.writeNoException();
                    return true;
                case 30:
                    C1933s c1935a;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1933s)) {
                            c1935a = new C1935a(readStrongBinder);
                        } else {
                            c1935a = (C1933s) queryLocalInterface;
                        }
                    }
                    mo5556a(c1935a);
                    parcel2.writeNoException();
                    return true;
                case 31:
                    C1906g c1908a;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IIpxxCallback_AIDL");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof C1906g)) {
                            c1908a = new C1908a(readStrongBinder);
                        } else {
                            c1908a = (C1906g) queryLocalInterface;
                        }
                    }
                    mo5553a(c1908a);
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    mo5578qt(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo5566cG(z);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo5567cH(z);
                    parcel2.writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo5568cI(z);
                    parcel2.writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    adj();
                    parcel2.writeNoException();
                    return true;
                case C2275g.CTRL_INDEX /*37*/:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.INetworkDiagnoseCallback_AIDL");
                        c1909h = (queryLocalInterface == null || !(queryLocalInterface instanceof C1909h)) ? new C1911a(readStrongBinder) : (C1909h) queryLocalInterface;
                    }
                    mo5554a(c1909h);
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

    /* renamed from: a */
    int mo5548a(C1930r c1930r, C1919l c1919l);

    /* renamed from: a */
    int mo5549a(String str, boolean z, List<String> list);

    /* renamed from: a */
    int mo5550a(boolean z, List<String> list);

    /* renamed from: a */
    void mo5551a(int i, String str, int i2, boolean z);

    /* renamed from: a */
    void mo5552a(C1889b c1889b);

    /* renamed from: a */
    void mo5553a(C1906g c1906g);

    /* renamed from: a */
    void mo5554a(C1909h c1909h);

    /* renamed from: a */
    void mo5555a(C1926o c1926o);

    /* renamed from: a */
    void mo5556a(C1933s c1933s);

    /* renamed from: a */
    void mo5557a(C4848y c4848y);

    /* renamed from: a */
    void mo5558a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4);

    boolean acT();

    void adi();

    void adj();

    C1899d amM();

    void amN();

    C1912i amO();

    /* renamed from: cF */
    void mo5565cF(boolean z);

    /* renamed from: cG */
    void mo5566cG(boolean z);

    /* renamed from: cH */
    void mo5567cH(boolean z);

    /* renamed from: cI */
    void mo5568cI(boolean z);

    void cancel(int i);

    /* renamed from: d */
    void mo5570d(String str, String str2, String str3, String str4);

    /* renamed from: g */
    int mo5571g(int i, byte[] bArr);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void keepSignalling();

    /* renamed from: qs */
    void mo5577qs(String str);

    /* renamed from: qt */
    void mo5578qt(String str);

    void reportFailIp(String str);

    void reset();

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setNewDnsDebugHost(String str, String str2);

    void setSignallingStrategy(long j, long j2);

    void stopSignalling();
}
