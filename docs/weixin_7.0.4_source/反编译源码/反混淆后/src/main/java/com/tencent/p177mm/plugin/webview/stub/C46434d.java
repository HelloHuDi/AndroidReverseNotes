package com.tencent.p177mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2206au;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42477i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C27077c;
import com.tencent.p177mm.plugin.webview.stub.C29853b.C29854a;
import com.tencent.p177mm.plugin.webview.stub.C40281e.C40282a;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.ttpic.wav.WavFileHeader;
import com.tencent.view.C31128d;
import com.tencent.wcdb.FileUtils;
import java.util.List;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.webview.stub.d */
public interface C46434d extends IInterface {

    /* renamed from: com.tencent.mm.plugin.webview.stub.d$a */
    public static abstract class C35624a extends Binder implements C46434d {

        /* renamed from: com.tencent.mm.plugin.webview.stub.d$a$a */
        static class C14551a implements C46434d {
            private IBinder mRemote;

            C14551a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean afj(String str) {
                boolean z = true;
                AppMethodBeat.m2504i(7235);
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
                    AppMethodBeat.m2505o(7235);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7235);
                }
            }

            /* renamed from: mJ */
            public final String mo15584mJ(String str) {
                AppMethodBeat.m2504i(7236);
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
                    AppMethodBeat.m2505o(7236);
                }
            }

            /* renamed from: mY */
            public final boolean mo15585mY(String str) {
                boolean z = false;
                AppMethodBeat.m2504i(7237);
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
                    AppMethodBeat.m2505o(7237);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7237);
                }
            }

            /* renamed from: nI */
            public final boolean mo15587nI(String str) {
                boolean z = false;
                AppMethodBeat.m2504i(7238);
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
                    AppMethodBeat.m2505o(7238);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7238);
                }
            }

            /* renamed from: mZ */
            public final boolean mo15586mZ(String str) {
                boolean z = false;
                AppMethodBeat.m2504i(7239);
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
                    AppMethodBeat.m2505o(7239);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7239);
                }
            }

            public final String aff(String str) {
                AppMethodBeat.m2504i(7240);
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
                    AppMethodBeat.m2505o(7240);
                }
            }

            /* renamed from: Mn */
            public final boolean mo15523Mn() {
                boolean z = false;
                AppMethodBeat.m2504i(7241);
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
                    AppMethodBeat.m2505o(7241);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7241);
                }
            }

            public final boolean isSDCardAvailable() {
                boolean z = false;
                AppMethodBeat.m2504i(7242);
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
                    AppMethodBeat.m2505o(7242);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7242);
                }
            }

            public final boolean cZd() {
                boolean z = false;
                AppMethodBeat.m2504i(7243);
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
                    AppMethodBeat.m2505o(7243);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7243);
                }
            }

            /* renamed from: Ze */
            public final boolean mo15525Ze() {
                boolean z = false;
                AppMethodBeat.m2504i(7244);
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
                    AppMethodBeat.m2505o(7244);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7244);
                }
            }

            /* renamed from: gw */
            public final int mo15577gw(int i, int i2) {
                AppMethodBeat.m2504i(7245);
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
                    AppMethodBeat.m2505o(7245);
                }
            }

            /* renamed from: gx */
            public final void mo15578gx(int i, int i2) {
                AppMethodBeat.m2504i(7246);
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
                    AppMethodBeat.m2505o(7246);
                }
            }

            /* renamed from: bF */
            public final String mo15551bF(int i, String str) {
                AppMethodBeat.m2504i(7247);
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
                    AppMethodBeat.m2505o(7247);
                }
            }

            /* renamed from: a */
            public final void mo15526a(int i, Bundle bundle, int i2) {
                AppMethodBeat.m2504i(7248);
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
                    AppMethodBeat.m2505o(7248);
                }
            }

            /* renamed from: Z */
            public final C29853b mo15524Z(Bundle bundle) {
                AppMethodBeat.m2504i(7249);
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
                    C29853b F = C29854a.m47322F(obtain2.readStrongBinder());
                    return F;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7249);
                }
            }

            /* renamed from: aa */
            public final boolean mo15535aa(Bundle bundle) {
                boolean z = true;
                AppMethodBeat.m2504i(7250);
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
                    AppMethodBeat.m2505o(7250);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7250);
                }
            }

            public final int afm(String str) {
                AppMethodBeat.m2504i(7251);
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
                    AppMethodBeat.m2505o(7251);
                }
            }

            public final void favEditTag() {
                AppMethodBeat.m2504i(7252);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7252);
                }
            }

            /* renamed from: s */
            public final boolean mo15590s(int i, Bundle bundle) {
                boolean z = true;
                AppMethodBeat.m2504i(7253);
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
                    AppMethodBeat.m2505o(7253);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7253);
                }
            }

            /* renamed from: x */
            public final boolean mo15591x(long j, String str) {
                boolean z = false;
                AppMethodBeat.m2504i(7254);
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
                    AppMethodBeat.m2505o(7254);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7254);
                }
            }

            public final void afn(String str) {
                AppMethodBeat.m2504i(7255);
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
                    AppMethodBeat.m2505o(7255);
                }
            }

            public final boolean aeD() {
                boolean z = false;
                AppMethodBeat.m2504i(7256);
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
                    AppMethodBeat.m2505o(7256);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7256);
                }
            }

            public final List<String> aeC() {
                AppMethodBeat.m2504i(7257);
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
                    AppMethodBeat.m2505o(7257);
                }
            }

            /* renamed from: k */
            public final void mo15583k(int i, List<String> list) {
                AppMethodBeat.m2504i(7258);
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
                    AppMethodBeat.m2505o(7258);
                }
            }

            /* renamed from: a */
            public final boolean mo15533a(String str, boolean z, Bundle bundle) {
                boolean z2 = true;
                AppMethodBeat.m2504i(7259);
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
                    AppMethodBeat.m2505o(7259);
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7259);
                }
            }

            public final String afg(String str) {
                AppMethodBeat.m2504i(7260);
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
                    AppMethodBeat.m2505o(7260);
                }
            }

            /* renamed from: dB */
            public final void mo15570dB(String str, int i) {
                AppMethodBeat.m2504i(7261);
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
                    AppMethodBeat.m2505o(7261);
                }
            }

            /* renamed from: bG */
            public final void mo15552bG(String str, boolean z) {
                int i = 0;
                AppMethodBeat.m2504i(7262);
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
                    AppMethodBeat.m2505o(7262);
                }
            }

            /* renamed from: dq */
            public final boolean mo15573dq(String str) {
                boolean z = false;
                AppMethodBeat.m2504i(7263);
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
                    AppMethodBeat.m2505o(7263);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7263);
                }
            }

            /* renamed from: j */
            public final void mo15582j(int i, Bundle bundle) {
                AppMethodBeat.m2504i(7264);
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
                    AppMethodBeat.m2505o(7264);
                }
            }

            /* renamed from: p */
            public final Bundle mo15588p(int i, Bundle bundle) {
                AppMethodBeat.m2504i(7265);
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
                    AppMethodBeat.m2505o(7265);
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7265);
                }
            }

            /* renamed from: i */
            public final void mo15580i(String str, boolean z, int i) {
                int i2 = 0;
                AppMethodBeat.m2504i(7266);
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
                    AppMethodBeat.m2505o(7266);
                }
            }

            /* renamed from: Ja */
            public final Bundle mo15517Ja(int i) {
                AppMethodBeat.m2504i(7267);
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
                    AppMethodBeat.m2505o(7267);
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7267);
                }
            }

            /* renamed from: Jb */
            public final boolean mo15518Jb(int i) {
                boolean z = false;
                AppMethodBeat.m2504i(7268);
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
                    AppMethodBeat.m2505o(7268);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7268);
                }
            }

            /* renamed from: a */
            public final boolean mo15532a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
                boolean z = true;
                AppMethodBeat.m2504i(7269);
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
                    AppMethodBeat.m2505o(7269);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7269);
                }
            }

            /* renamed from: L */
            public final void mo15522L(String str, String str2, int i) {
                AppMethodBeat.m2504i(7270);
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
                    AppMethodBeat.m2505o(7270);
                }
            }

            /* renamed from: a */
            public final void mo15529a(String str, Bundle bundle, int i) {
                AppMethodBeat.m2504i(7271);
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
                    AppMethodBeat.m2505o(7271);
                }
            }

            public final void afh(String str) {
                AppMethodBeat.m2504i(7272);
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
                    AppMethodBeat.m2505o(7272);
                }
            }

            public final String afi(String str) {
                AppMethodBeat.m2504i(7273);
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
                    AppMethodBeat.m2505o(7273);
                }
            }

            /* renamed from: ao */
            public final void mo15550ao(int i, int i2, int i3) {
                AppMethodBeat.m2504i(7274);
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
                    AppMethodBeat.m2505o(7274);
                }
            }

            /* renamed from: a */
            public final void mo15528a(C40281e c40281e, int i) {
                AppMethodBeat.m2504i(7275);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeStrongBinder(c40281e != null ? c40281e.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7275);
                }
            }

            /* renamed from: Jc */
            public final void mo15519Jc(int i) {
                AppMethodBeat.m2504i(7276);
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
                    AppMethodBeat.m2505o(7276);
                }
            }

            public final String[] cZe() {
                AppMethodBeat.m2504i(7277);
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
                    AppMethodBeat.m2505o(7277);
                }
            }

            public final String cZf() {
                AppMethodBeat.m2504i(7278);
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
                    AppMethodBeat.m2505o(7278);
                }
            }

            public final String aek(String str) {
                AppMethodBeat.m2504i(7279);
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
                    AppMethodBeat.m2505o(7279);
                }
            }

            public final String cZg() {
                AppMethodBeat.m2504i(7280);
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
                    AppMethodBeat.m2505o(7280);
                }
            }

            public final String afk(String str) {
                AppMethodBeat.m2504i(7281);
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
                    AppMethodBeat.m2505o(7281);
                }
            }

            public final Map cZi() {
                AppMethodBeat.m2504i(7282);
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
                    AppMethodBeat.m2505o(7282);
                }
            }

            /* renamed from: hf */
            public final String mo15579hf(String str, String str2) {
                AppMethodBeat.m2504i(7283);
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
                    AppMethodBeat.m2505o(7283);
                }
            }

            public final void afl(String str) {
                AppMethodBeat.m2504i(7284);
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
                    AppMethodBeat.m2505o(7284);
                }
            }

            /* renamed from: dC */
            public final String mo15571dC(String str, int i) {
                AppMethodBeat.m2504i(7285);
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
                    AppMethodBeat.m2505o(7285);
                }
            }

            public final String getLanguage() {
                AppMethodBeat.m2504i(7286);
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
                    AppMethodBeat.m2505o(7286);
                }
            }

            public final String cZh() {
                AppMethodBeat.m2504i(7287);
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
                    AppMethodBeat.m2505o(7287);
                }
            }

            public final int cZj() {
                AppMethodBeat.m2504i(7288);
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
                    AppMethodBeat.m2505o(7288);
                }
            }

            public final int cZk() {
                AppMethodBeat.m2504i(7289);
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
                    AppMethodBeat.m2505o(7289);
                }
            }

            public final void cZl() {
                AppMethodBeat.m2504i(7290);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7290);
                }
            }

            public final void cZm() {
                AppMethodBeat.m2504i(7291);
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7291);
                }
            }

            /* renamed from: Jd */
            public final void mo15520Jd(int i) {
                AppMethodBeat.m2504i(7292);
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
                    AppMethodBeat.m2505o(7292);
                }
            }

            /* renamed from: Je */
            public final void mo15521Je(int i) {
                AppMethodBeat.m2504i(7293);
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
                    AppMethodBeat.m2505o(7293);
                }
            }

            /* renamed from: IP */
            public final void mo15515IP(int i) {
                AppMethodBeat.m2504i(7294);
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
                    AppMethodBeat.m2505o(7294);
                }
            }

            /* renamed from: dD */
            public final void mo15572dD(String str, int i) {
                AppMethodBeat.m2504i(7295);
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
                    AppMethodBeat.m2505o(7295);
                }
            }

            public final boolean cZn() {
                boolean z = false;
                AppMethodBeat.m2504i(7296);
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
                    AppMethodBeat.m2505o(7296);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7296);
                }
            }

            public final String afp(String str) {
                AppMethodBeat.m2504i(7297);
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
                    AppMethodBeat.m2505o(7297);
                }
            }

            public final boolean cZp() {
                boolean z = false;
                AppMethodBeat.m2504i(7298);
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
                    AppMethodBeat.m2505o(7298);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7298);
                }
            }

            public final boolean cZo() {
                boolean z = false;
                AppMethodBeat.m2504i(7299);
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
                    AppMethodBeat.m2505o(7299);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7299);
                }
            }

            public final boolean cZs() {
                boolean z = false;
                AppMethodBeat.m2504i(7300);
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
                    AppMethodBeat.m2505o(7300);
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7300);
                }
            }

            /* renamed from: a */
            public final void mo15531a(String str, int[] iArr, int i, int i2) {
                AppMethodBeat.m2504i(7301);
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
                    AppMethodBeat.m2505o(7301);
                }
            }

            public final void afo(String str) {
                AppMethodBeat.m2504i(7302);
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
                    AppMethodBeat.m2505o(7302);
                }
            }

            /* renamed from: a */
            public final void mo15530a(String str, String str2, String str3, int i, int i2, Bundle bundle) {
                AppMethodBeat.m2504i(7303);
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
                    AppMethodBeat.m2505o(7303);
                }
            }

            /* renamed from: g */
            public final Bundle mo15575g(int i, Bundle bundle) {
                AppMethodBeat.m2504i(7304);
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
                    AppMethodBeat.m2505o(7304);
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    AppMethodBeat.m2505o(7304);
                }
            }

            /* renamed from: aB */
            public final void mo15534aB(Intent intent) {
                AppMethodBeat.m2504i(7305);
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
                    AppMethodBeat.m2505o(7305);
                }
            }

            /* renamed from: J */
            public final void mo15516J(int i, String str, String str2) {
                AppMethodBeat.m2504i(7306);
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
                    AppMethodBeat.m2505o(7306);
                }
            }

            public final List<String> cZq() {
                AppMethodBeat.m2504i(7307);
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
                    AppMethodBeat.m2505o(7307);
                }
            }

            /* renamed from: a */
            public final void mo15527a(Bundle bundle, int i) {
                AppMethodBeat.m2504i(7308);
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
                    AppMethodBeat.m2505o(7308);
                }
            }

            public final int cZr() {
                AppMethodBeat.m2504i(7309);
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
                    AppMethodBeat.m2505o(7309);
                }
            }

            public final String[] cZt() {
                AppMethodBeat.m2504i(7310);
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
                    AppMethodBeat.m2505o(7310);
                }
            }

            /* renamed from: r */
            public final void mo15589r(int i, Bundle bundle) {
                AppMethodBeat.m2504i(7311);
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
                    AppMethodBeat.m2505o(7311);
                }
            }
        }

        public C35624a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        }

        /* renamed from: G */
        public static C46434d m58467G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C46434d)) {
                return new C14551a(iBinder);
            }
            return (C46434d) queryLocalInterface;
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
                    mJ = mo15584mJ(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(mJ);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = mo15585mY(parcel.readString());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = mo15587nI(parcel.readString());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = mo15586mZ(parcel.readString());
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
                    afj = mo15523Mn();
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
                    afj = mo15525Ze();
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    gw = mo15577gw(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(gw);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mo15578gx(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = mo15551bF(parcel.readInt(), parcel.readString());
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
                    mo15526a(readInt, bundle2, parcel.readInt());
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
                    C29853b Z = mo15524Z(bundle2);
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
                    afj = mo15535aa(bundle2);
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
                    afj = mo15590s(readInt, bundle2);
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = mo15591x(parcel.readLong(), parcel.readString());
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
                    mo15583k(parcel.readInt(), parcel.createStringArrayList());
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
                    afj = mo15533a(readString, z2, bundle2);
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
                    mo15570dB(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mJ = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    mo15552bG(mJ, z);
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    afj = mo15573dq(parcel.readString());
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
                    mo15582j(readInt, bundle2);
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
                    bundle2 = mo15588p(readInt, bundle2);
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
                    mo15580i(mJ, z, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    bundle2 = mo15517Ja(parcel.readInt());
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
                    afj = mo15518Jb(parcel.readInt());
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
                    afj = mo15532a(readString2, readString, readString3, bundle3, bundle4, parcel.readInt());
                    parcel2.writeNoException();
                    if (afj) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 36:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mo15522L(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C2275g.CTRL_INDEX /*37*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    mo15529a(readString2, bundle2, parcel.readInt());
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
                    mo15550ao(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mo15528a(C40282a.m69080H(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mo15519Jc(parcel.readInt());
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
                    mJ = mo15579hf(parcel.readString(), parcel.readString());
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
                    mJ = mo15571dC(parcel.readString(), parcel.readInt());
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
                case C19410e.CTRL_INDEX /*57*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    cZm();
                    parcel2.writeNoException();
                    return true;
                case C42464aa.CTRL_INDEX /*58*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mo15520Jd(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C2206au.CTRL_INDEX /*59*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mo15521Je(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 60:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mo15515IP(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mo15572dD(parcel.readString(), parcel.readInt());
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
                    mo15531a(parcel.readString(), parcel.createIntArray(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case C42477i.CTRL_INDEX /*68*/:
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
                    mo15530a(readString2, readString, readString3, readInt2, readInt3, bundle);
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
                    bundle2 = mo15575g(readInt, bundle2);
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
                    mo15534aB(intent);
                    parcel2.writeNoException();
                    return true;
                case C33279c.CTRL_INDEX /*72*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    mo15516J(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case C27077c.CTRL_INDEX /*73*/:
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
                    mo15527a(bundle2, parcel.readInt());
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
                    mo15589r(readInt, bundle2);
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

    /* renamed from: IP */
    void mo15515IP(int i);

    /* renamed from: J */
    void mo15516J(int i, String str, String str2);

    /* renamed from: Ja */
    Bundle mo15517Ja(int i);

    /* renamed from: Jb */
    boolean mo15518Jb(int i);

    /* renamed from: Jc */
    void mo15519Jc(int i);

    /* renamed from: Jd */
    void mo15520Jd(int i);

    /* renamed from: Je */
    void mo15521Je(int i);

    /* renamed from: L */
    void mo15522L(String str, String str2, int i);

    /* renamed from: Mn */
    boolean mo15523Mn();

    /* renamed from: Z */
    C29853b mo15524Z(Bundle bundle);

    /* renamed from: Ze */
    boolean mo15525Ze();

    /* renamed from: a */
    void mo15526a(int i, Bundle bundle, int i2);

    /* renamed from: a */
    void mo15527a(Bundle bundle, int i);

    /* renamed from: a */
    void mo15528a(C40281e c40281e, int i);

    /* renamed from: a */
    void mo15529a(String str, Bundle bundle, int i);

    /* renamed from: a */
    void mo15530a(String str, String str2, String str3, int i, int i2, Bundle bundle);

    /* renamed from: a */
    void mo15531a(String str, int[] iArr, int i, int i2);

    /* renamed from: a */
    boolean mo15532a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i);

    /* renamed from: a */
    boolean mo15533a(String str, boolean z, Bundle bundle);

    /* renamed from: aB */
    void mo15534aB(Intent intent);

    /* renamed from: aa */
    boolean mo15535aa(Bundle bundle);

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

    /* renamed from: ao */
    void mo15550ao(int i, int i2, int i3);

    /* renamed from: bF */
    String mo15551bF(int i, String str);

    /* renamed from: bG */
    void mo15552bG(String str, boolean z);

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

    /* renamed from: dB */
    void mo15570dB(String str, int i);

    /* renamed from: dC */
    String mo15571dC(String str, int i);

    /* renamed from: dD */
    void mo15572dD(String str, int i);

    /* renamed from: dq */
    boolean mo15573dq(String str);

    void favEditTag();

    /* renamed from: g */
    Bundle mo15575g(int i, Bundle bundle);

    String getLanguage();

    /* renamed from: gw */
    int mo15577gw(int i, int i2);

    /* renamed from: gx */
    void mo15578gx(int i, int i2);

    /* renamed from: hf */
    String mo15579hf(String str, String str2);

    /* renamed from: i */
    void mo15580i(String str, boolean z, int i);

    boolean isSDCardAvailable();

    /* renamed from: j */
    void mo15582j(int i, Bundle bundle);

    /* renamed from: k */
    void mo15583k(int i, List<String> list);

    /* renamed from: mJ */
    String mo15584mJ(String str);

    /* renamed from: mY */
    boolean mo15585mY(String str);

    /* renamed from: mZ */
    boolean mo15586mZ(String str);

    /* renamed from: nI */
    boolean mo15587nI(String str);

    /* renamed from: p */
    Bundle mo15588p(int i, Bundle bundle);

    /* renamed from: r */
    void mo15589r(int i, Bundle bundle);

    /* renamed from: s */
    boolean mo15590s(int i, Bundle bundle);

    /* renamed from: x */
    boolean mo15591x(long j, String str);
}
