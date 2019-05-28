package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.wcdb.FileUtils;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        static class a implements d {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean afj(String str) {
                boolean z = true;
                AppMethodBeat.i(7235);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7235);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7235);
                }
            }

            public final String mJ(String str) {
                AppMethodBeat.i(7236);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7236);
                }
            }

            public final boolean mY(String str) {
                boolean z = false;
                AppMethodBeat.i(7237);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7237);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7237);
                }
            }

            public final boolean nI(String str) {
                boolean z = false;
                AppMethodBeat.i(7238);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7238);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7238);
                }
            }

            public final boolean mZ(String str) {
                boolean z = false;
                AppMethodBeat.i(7239);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7239);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7239);
                }
            }

            public final String aff(String str) {
                AppMethodBeat.i(7240);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7240);
                }
            }

            public final boolean Mn() {
                boolean z = false;
                AppMethodBeat.i(7241);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7241);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7241);
                }
            }

            public final boolean isSDCardAvailable() {
                boolean z = false;
                AppMethodBeat.i(7242);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7242);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7242);
                }
            }

            public final boolean cZd() {
                boolean z = false;
                AppMethodBeat.i(7243);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7243);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7243);
                }
            }

            public final boolean Ze() {
                boolean z = false;
                AppMethodBeat.i(7244);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7244);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7244);
                }
            }

            public final int gw(int i, int i2) {
                AppMethodBeat.i(7245);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7245);
                }
            }

            public final void gx(int i, int i2) {
                AppMethodBeat.i(7246);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7246);
                }
            }

            public final String bF(int i, String str) {
                AppMethodBeat.i(7247);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7247);
                }
            }

            public final void a(int i, Bundle bundle, int i2) {
                AppMethodBeat.i(7248);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7248);
                }
            }

            public final b Z(Bundle bundle) {
                AppMethodBeat.i(7249);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    b F = com.tencent.mm.plugin.webview.stub.b.a.F(obtain2.readStrongBinder());
                    return F;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7249);
                }
            }

            public final boolean aa(Bundle bundle) {
                boolean z = true;
                AppMethodBeat.i(7250);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7250);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7250);
                }
            }

            public final int afm(String str) {
                AppMethodBeat.i(7251);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7251);
                }
            }

            public final void favEditTag() {
                AppMethodBeat.i(7252);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7252);
                }
            }

            public final boolean s(int i, Bundle bundle) {
                boolean z = true;
                AppMethodBeat.i(7253);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7253);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7253);
                }
            }

            public final boolean x(long j, String str) {
                boolean z = false;
                AppMethodBeat.i(7254);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7254);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7254);
                }
            }

            public final void afn(String str) {
                AppMethodBeat.i(7255);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7255);
                }
            }

            public final boolean aeD() {
                boolean z = false;
                AppMethodBeat.i(7256);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7256);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7256);
                }
            }

            public final List<String> aeC() {
                AppMethodBeat.i(7257);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    List<String> createStringArrayList = obtain2.createStringArrayList();
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7257);
                }
            }

            public final void k(int i, List<String> list) {
                AppMethodBeat.i(7258);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStringList(list);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7258);
                }
            }

            public final boolean a(String str, boolean z, Bundle bundle) {
                boolean z2 = true;
                AppMethodBeat.i(7259);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7259);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7259);
                }
            }

            public final String afg(String str) {
                AppMethodBeat.i(7260);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7260);
                }
            }

            public final void dB(String str, int i) {
                AppMethodBeat.i(7261);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7261);
                }
            }

            public final void bG(String str, boolean z) {
                int i = 0;
                AppMethodBeat.i(7262);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7262);
                }
            }

            public final boolean dq(String str) {
                boolean z = false;
                AppMethodBeat.i(7263);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7263);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7263);
                }
            }

            public final void j(int i, Bundle bundle) {
                AppMethodBeat.i(7264);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7264);
                }
            }

            public final Bundle p(int i, Bundle bundle) {
                AppMethodBeat.i(7265);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle2;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7265);
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7265);
                }
            }

            public final void i(String str, boolean z, int i) {
                int i2 = 0;
                AppMethodBeat.i(7266);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7266);
                }
            }

            public final Bundle Ja(int i) {
                AppMethodBeat.i(7267);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7267);
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7267);
                }
            }

            public final boolean Jb(int i) {
                boolean z = false;
                AppMethodBeat.i(7268);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7268);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7268);
                }
            }

            public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
                boolean z = true;
                AppMethodBeat.i(7269);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7269);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7269);
                }
            }

            public final void L(String str, String str2, int i) {
                AppMethodBeat.i(7270);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7270);
                }
            }

            public final void a(String str, Bundle bundle, int i) {
                AppMethodBeat.i(7271);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7271);
                }
            }

            public final void afh(String str) {
                AppMethodBeat.i(7272);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7272);
                }
            }

            public final String afi(String str) {
                AppMethodBeat.i(7273);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7273);
                }
            }

            public final void ao(int i, int i2, int i3) {
                AppMethodBeat.i(7274);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7274);
                }
            }

            public final void a(e eVar, int i) {
                AppMethodBeat.i(7275);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7275);
                }
            }

            public final void Jc(int i) {
                AppMethodBeat.i(7276);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7276);
                }
            }

            public final String[] cZe() {
                AppMethodBeat.i(7277);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7277);
                }
            }

            public final String cZf() {
                AppMethodBeat.i(7278);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7278);
                }
            }

            public final String aek(String str) {
                AppMethodBeat.i(7279);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7279);
                }
            }

            public final String cZg() {
                AppMethodBeat.i(7280);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7280);
                }
            }

            public final String afk(String str) {
                AppMethodBeat.i(7281);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7281);
                }
            }

            public final Map cZi() {
                AppMethodBeat.i(7282);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                    Map readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7282);
                }
            }

            public final String hf(String str, String str2) {
                AppMethodBeat.i(7283);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7283);
                }
            }

            public final void afl(String str) {
                AppMethodBeat.i(7284);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7284);
                }
            }

            public final String dC(String str, int i) {
                AppMethodBeat.i(7285);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7285);
                }
            }

            public final String getLanguage() {
                AppMethodBeat.i(7286);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7286);
                }
            }

            public final String cZh() {
                AppMethodBeat.i(7287);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7287);
                }
            }

            public final int cZj() {
                AppMethodBeat.i(7288);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7288);
                }
            }

            public final int cZk() {
                AppMethodBeat.i(7289);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7289);
                }
            }

            public final void cZl() {
                AppMethodBeat.i(7290);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7290);
                }
            }

            public final void cZm() {
                AppMethodBeat.i(7291);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7291);
                }
            }

            public final void Jd(int i) {
                AppMethodBeat.i(7292);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7292);
                }
            }

            public final void Je(int i) {
                AppMethodBeat.i(7293);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7293);
                }
            }

            public final void IP(int i) {
                AppMethodBeat.i(7294);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7294);
                }
            }

            public final void dD(String str, int i) {
                AppMethodBeat.i(7295);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7295);
                }
            }

            public final boolean cZn() {
                boolean z = false;
                AppMethodBeat.i(7296);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(62, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7296);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7296);
                }
            }

            public final String afp(String str) {
                AppMethodBeat.i(7297);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7297);
                }
            }

            public final boolean cZp() {
                boolean z = false;
                AppMethodBeat.i(7298);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7298);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7298);
                }
            }

            public final boolean cZo() {
                boolean z = false;
                AppMethodBeat.i(7299);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7299);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7299);
                }
            }

            public final boolean cZs() {
                boolean z = false;
                AppMethodBeat.i(7300);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7300);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7300);
                }
            }

            public final void a(String str, int[] iArr, int i, int i2) {
                AppMethodBeat.i(7301);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7301);
                }
            }

            public final void afo(String str) {
                AppMethodBeat.i(7302);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7302);
                }
            }

            public final void a(String str, String str2, String str3, int i, int i2, Bundle bundle) {
                AppMethodBeat.i(7303);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7303);
                }
            }

            public final Bundle g(int i, Bundle bundle) {
                AppMethodBeat.i(7304);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle2;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(70, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7304);
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7304);
                }
            }

            public final void aB(Intent intent) {
                AppMethodBeat.i(7305);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(71, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7305);
                }
            }

            public final void J(int i, String str, String str2) {
                AppMethodBeat.i(7306);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(72, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7306);
                }
            }

            public final List<String> cZq() {
                AppMethodBeat.i(7307);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(73, obtain, obtain2, 0);
                    obtain2.readException();
                    List<String> createStringArrayList = obtain2.createStringArrayList();
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7307);
                }
            }

            public final void a(Bundle bundle, int i) {
                AppMethodBeat.i(7308);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(74, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7308);
                }
            }

            public final int cZr() {
                AppMethodBeat.i(7309);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(75, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7309);
                }
            }

            public final String[] cZt() {
                AppMethodBeat.i(7310);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(76, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7310);
                }
            }

            public final void r(int i, Bundle bundle) {
                AppMethodBeat.i(7311);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(77, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.o(7311);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        }

        public static d G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle = null;
            int i3 = 0;
            boolean afj;
            String mJ;
            int gw;
            int readInt;
            Bundle bundle2;
            List aeC;
            String readString;
            boolean z;
            String readString2;
            String readString3;
            String[] cZe;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = afj(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(afj ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = mJ(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = mY(parcel.readString());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = nI(parcel.readString());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = mZ(parcel.readString());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = aff(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = Mn();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = isSDCardAvailable();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = cZd();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = Ze();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gw = gw(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(gw);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gx(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = bF(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    a(readInt, bundle2, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    IBinder asBinder;
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    b Z = Z(bundle2);
                    parcel2.writeNoException();
                    if (Z != null) {
                        asBinder = Z.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    afj = aa(bundle2);
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gw = afm(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(gw);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    favEditTag();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    afj = s(readInt, bundle2);
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = x(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afn(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = aeD();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    aeC = aeC();
                    parcel2.writeNoException();
                    parcel2.writeStringList(aeC);
                    return true;
                case 24:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    k(parcel.readInt(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readString = parcel.readString();
                    boolean z2 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    afj = a(readString, z2, bundle2);
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 26:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = afg(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 27:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    dB(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    bG(mJ, z);
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = dq(parcel.readString());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 30:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    j(readInt, bundle2);
                    parcel2.writeNoException();
                    return true;
                case 31:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    bundle2 = p(readInt, bundle2);
                    parcel2.writeNoException();
                    if (bundle2 != null) {
                        parcel2.writeInt(1);
                        bundle2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    i(mJ, z, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    bundle2 = Ja(parcel.readInt());
                    parcel2.writeNoException();
                    if (bundle2 != null) {
                        parcel2.writeInt(1);
                        bundle2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 34:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = Jb(parcel.readInt());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 35:
                    Bundle bundle3;
                    Bundle bundle4;
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readString2 = parcel.readString();
                    readString = parcel.readString();
                    readString3 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle3 = null;
                    }
                    if (parcel.readInt() != 0) {
                        bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle4 = null;
                    }
                    afj = a(readString2, readString, readString3, bundle3, bundle4, parcel.readInt());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 36:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    L(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case g.CTRL_INDEX /*37*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    a(readString2, bundle2, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afh(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = afi(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 40:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    ao(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    a(com.tencent.mm.plugin.webview.stub.e.a.H(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jc(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    cZe = cZe();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(cZe);
                    return true;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = cZf();
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = aek(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 46:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = cZg();
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = afk(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 48:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Map cZi = cZi();
                    parcel2.writeNoException();
                    parcel2.writeMap(cZi);
                    return true;
                case XWalkEnvironment.SDK_SUPPORT_MIN_APKVERSION /*49*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = hf(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 50:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afl(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = dC(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 52:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = getLanguage();
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = cZh();
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gw = cZj();
                    parcel2.writeNoException();
                    parcel2.writeInt(gw);
                    return true;
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gw = cZk();
                    parcel2.writeNoException();
                    parcel2.writeInt(gw);
                    return true;
                case FileUtils.S_IRWXG /*56*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    cZl();
                    parcel2.writeNoException();
                    return true;
                case e.CTRL_INDEX /*57*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    cZm();
                    parcel2.writeNoException();
                    return true;
                case aa.CTRL_INDEX /*58*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jd(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case au.CTRL_INDEX /*59*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Je(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 60:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    IP(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    dD(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 62:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = cZn();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 63:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = afp(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 64:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = cZp();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 65:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = cZo();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 66:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = cZs();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 67:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    a(parcel.readString(), parcel.createIntArray(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case i.CTRL_INDEX /*68*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afo(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 69:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readString2 = parcel.readString();
                    readString = parcel.readString();
                    readString3 = parcel.readString();
                    int readInt2 = parcel.readInt();
                    int readInt3 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    a(readString2, readString, readString3, readInt2, readInt3, bundle);
                    parcel2.writeNoException();
                    return true;
                case 70:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    bundle2 = g(readInt, bundle2);
                    parcel2.writeNoException();
                    if (bundle2 != null) {
                        parcel2.writeInt(1);
                        bundle2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 71:
                    Intent intent;
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent = null;
                    }
                    aB(intent);
                    parcel2.writeNoException();
                    return true;
                case c.CTRL_INDEX /*72*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    J(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case com.tencent.mm.plugin.appbrand.jsapi.share.c.CTRL_INDEX /*73*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    aeC = cZq();
                    parcel2.writeNoException();
                    parcel2.writeStringList(aeC);
                    return true;
                case 74:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    a(bundle2, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 75:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gw = cZr();
                    parcel2.writeNoException();
                    parcel2.writeInt(gw);
                    return true;
                case 76:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    cZe = cZt();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(cZe);
                    return true;
                case 77:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    r(readInt, bundle2);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void IP(int i);

    void J(int i, String str, String str2);

    Bundle Ja(int i);

    boolean Jb(int i);

    void Jc(int i);

    void Jd(int i);

    void Je(int i);

    void L(String str, String str2, int i);

    boolean Mn();

    b Z(Bundle bundle);

    boolean Ze();

    void a(int i, Bundle bundle, int i2);

    void a(Bundle bundle, int i);

    void a(e eVar, int i);

    void a(String str, Bundle bundle, int i);

    void a(String str, String str2, String str3, int i, int i2, Bundle bundle);

    void a(String str, int[] iArr, int i, int i2);

    boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i);

    boolean a(String str, boolean z, Bundle bundle);

    void aB(Intent intent);

    boolean aa(Bundle bundle);

    List<String> aeC();

    boolean aeD();

    String aek(String str);

    String aff(String str);

    String afg(String str);

    void afh(String str);

    String afi(String str);

    boolean afj(String str);

    String afk(String str);

    void afl(String str);

    int afm(String str);

    void afn(String str);

    void afo(String str);

    String afp(String str);

    void ao(int i, int i2, int i3);

    String bF(int i, String str);

    void bG(String str, boolean z);

    boolean cZd();

    String[] cZe();

    String cZf();

    String cZg();

    String cZh();

    Map cZi();

    int cZj();

    int cZk();

    void cZl();

    void cZm();

    boolean cZn();

    boolean cZo();

    boolean cZp();

    List<String> cZq();

    int cZr();

    boolean cZs();

    String[] cZt();

    void dB(String str, int i);

    String dC(String str, int i);

    void dD(String str, int i);

    boolean dq(String str);

    void favEditTag();

    Bundle g(int i, Bundle bundle);

    String getLanguage();

    int gw(int i, int i2);

    void gx(int i, int i2);

    String hf(String str, String str2);

    void i(String str, boolean z, int i);

    boolean isSDCardAvailable();

    void j(int i, Bundle bundle);

    void k(int i, List<String> list);

    String mJ(String str);

    boolean mY(String str);

    boolean mZ(String str);

    boolean nI(String str);

    Bundle p(int i, Bundle bundle);

    void r(int i, Bundle bundle);

    boolean s(int i, Bundle bundle);

    boolean x(long j, String str);
}
