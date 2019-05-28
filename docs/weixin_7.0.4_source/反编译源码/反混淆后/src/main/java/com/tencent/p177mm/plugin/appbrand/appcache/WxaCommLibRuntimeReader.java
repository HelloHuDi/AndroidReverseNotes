package com.tencent.p177mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as.C19036a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C31282o;
import com.tencent.p177mm.plugin.appbrand.p1468a.C45508b;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C31147o;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader */
public final class WxaCommLibRuntimeReader {
    private static C31282o gTE;
    private static Future<Object> gTF;
    private static final ThreadPoolExecutor gTG = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader$a */
    static final class C19031a implements C45413i<IPCVoid, Object> {

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader$a$1 */
        class C190321 implements Runnable {
            C190321() {
            }

            public final void run() {
                AppMethodBeat.m2504i(59457);
                if (C1720g.m3534RN().eJb) {
                    try {
                        ((C45508b) C1720g.m3528K(C45508b.class)).mo67866dy(false);
                        AppMethodBeat.m2505o(59457);
                        return;
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", e, "[NOT CRASH]", new Object[0]);
                        AppMethodBeat.m2505o(59457);
                        return;
                    }
                }
                AppMethodBeat.m2505o(59457);
            }
        }

        private C19031a() {
        }

        /* renamed from: dB */
        private WxaPkgWrappingInfo m29608dB(boolean z) {
            AppMethodBeat.m2504i(59458);
            Pair dE = C19035as.m29613dE(z);
            if (dE.first == C19036a.gUM && dE.second == null && !z) {
                C7305d.xDG.mo10151b(new C190321(), "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
            }
            if (dE.second != null && ((WxaPkgWrappingInfo) dE.second).gVt == 999) {
                ((WxaPkgWrappingInfo) dE.second).gVu = 0;
            }
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) dE.second;
            AppMethodBeat.m2505o(59458);
            return wxaPkgWrappingInfo;
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo4785am(Object obj) {
            AppMethodBeat.m2504i(59459);
            if (C1720g.m3534RN().eJb) {
                WxaPkgWrappingInfo dB;
                int i;
                if (C1720g.m3534RN().eJb) {
                    dB = m29608dB(false);
                    if (dB == null) {
                        dB = m29608dB(true);
                    }
                } else {
                    dB = null;
                }
                if (dB == null) {
                    i = C38104an.VERSION;
                } else {
                    i = dB.gVu;
                }
                C19034ai.m29611ns(i);
                AppMethodBeat.m2505o(59459);
                return dB;
            }
            AccountNotReadyError accountNotReadyError = new AccountNotReadyError();
            AppMethodBeat.m2505o(59459);
            return accountNotReadyError;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader$AccountNotReadyError */
    static final class AccountNotReadyError extends Error implements Parcelable {
        public static final Creator<AccountNotReadyError> CREATOR = new C267311();

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader$AccountNotReadyError$1 */
        static class C267311 implements Creator<AccountNotReadyError> {
            C267311() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AccountNotReadyError[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(59455);
                AccountNotReadyError accountNotReadyError = new AccountNotReadyError((byte) 0);
                AppMethodBeat.m2505o(59455);
                return accountNotReadyError;
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
        }

        AccountNotReadyError() {
        }

        AccountNotReadyError(byte b) {
        }

        static {
            AppMethodBeat.m2504i(59456);
            AppMethodBeat.m2505o(59456);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader$1 */
    static class C267321 implements Callable<Object> {
        C267321() {
        }

        public final Object call() {
            Object e;
            AppMethodBeat.m2504i(59454);
            try {
                e = XIPCInvoker.m83628a("com.tencent.mm", IPCVoid.eGH, C19031a.class);
                AppMethodBeat.m2505o(59454);
            } catch (Exception e2) {
                e = e2;
                C4990ab.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", e, "load() ipc read lib", new Object[0]);
                AppMethodBeat.m2505o(59454);
            }
            return e;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader$b */
    static final class C26733b extends C45510a {
        private final WxaPkgWrappingInfo gSf;
        private final C45512ao gTI;

        /* synthetic */ C26733b(WxaPkgWrappingInfo wxaPkgWrappingInfo, byte b) {
            this(wxaPkgWrappingInfo);
        }

        private C26733b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            AppMethodBeat.m2504i(59460);
            this.gSf = wxaPkgWrappingInfo;
            this.gTI = new C45512ao(wxaPkgWrappingInfo.gSP);
            AppMethodBeat.m2505o(59460);
        }

        public final void init() {
            AppMethodBeat.m2504i(59461);
            this.gTI.avW();
            AppMethodBeat.m2505o(59461);
        }

        public final InputStream openRead(String str) {
            AppMethodBeat.m2504i(59462);
            this.gTI.avW();
            InputStream xy = this.gTI.mo73324xy(str);
            AppMethodBeat.m2505o(59462);
            return xy;
        }

        public final WxaPkgWrappingInfo avm() {
            return this.gSf;
        }

        public final String toString() {
            AppMethodBeat.m2504i(59463);
            String format = String.format(Locale.US, "PkgReader[%d] [%s]", new Object[]{Integer.valueOf(this.gSf.gVu), avk()});
            AppMethodBeat.m2505o(59463);
            return format;
        }
    }

    static {
        AppMethodBeat.m2504i(59474);
        AppMethodBeat.m2505o(59474);
    }

    public static synchronized void avN() {
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.m2504i(59464);
            try {
                WxaCommLibRuntimeReader.m42567sg();
                if (gTE == null) {
                    gTE = C33093c.gSg;
                    AppMethodBeat.m2505o(59464);
                }
            } catch (Throwable th) {
                if (gTE == null) {
                    gTE = C33093c.gSg;
                }
                AppMethodBeat.m2505o(59464);
            }
            AppMethodBeat.m2505o(59464);
        }
    }

    /* renamed from: sg */
    public static synchronized void m42567sg() {
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.m2504i(59465);
            AccountNotReadyError accountNotReadyError;
            if (gTE != null) {
                C4990ab.m7417i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", gTE);
                AppMethodBeat.m2505o(59465);
            } else if (C38104an.avU()) {
                gTE = C33093c.gSg;
                C4990ab.m7416i("MicroMsg.WxaCommLibRuntimeReader", "load(), forceLocal, use AssetReader");
                AppMethodBeat.m2505o(59465);
            } else if (C4996ah.doI()) {
                try {
                    if (gTF != null) {
                        C4990ab.m7416i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
                    } else {
                        C4990ab.m7416i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
                        gTF = gTG.submit(new C267321());
                    }
                    String str = gTF.get(5, TimeUnit.SECONDS);
                    if (str instanceof WxaPkgWrappingInfo) {
                        C31282o c31282o;
                        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) str;
                        if (wxaPkgWrappingInfo.gVw) {
                            c31282o = C33093c.gSg;
                        } else {
                            Object c31282o2 = new C26733b(wxaPkgWrappingInfo, (byte) 0);
                        }
                        gTE = c31282o2;
                        AppMethodBeat.m2505o(59465);
                    } else if (str instanceof AccountNotReadyError) {
                        accountNotReadyError = (AccountNotReadyError) str;
                        AppMethodBeat.m2505o(59465);
                        throw accountNotReadyError;
                    } else if (str instanceof Exception) {
                        Exception exception = (Exception) str;
                        AppMethodBeat.m2505o(59465);
                        throw exception;
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder("Unknown result ").append(null).toString() == str ? BuildConfig.COMMAND : str.getClass().getName());
                        AppMethodBeat.m2505o(59465);
                        throw illegalArgumentException;
                    }
                } catch (Throwable th) {
                    gTF.cancel(false);
                    gTF = null;
                    AppMethodBeat.m2505o(59465);
                }
            } else {
                C4990ab.m7412e("MicroMsg.WxaCommLibRuntimeReader", "load(), mm process not exists");
                accountNotReadyError = new AccountNotReadyError();
                AppMethodBeat.m2505o(59465);
                throw accountNotReadyError;
            }
        }
    }

    public static synchronized boolean avO() {
        boolean z = true;
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.m2504i(59466);
            C4990ab.m7417i("MicroMsg.WxaCommLibRuntimeReader", "loaded(), reader %s", gTE);
            if (gTE != null) {
                AppMethodBeat.m2505o(59466);
            } else {
                AppMethodBeat.m2505o(59466);
                z = false;
            }
        }
        return z;
    }

    public static synchronized C31282o avP() {
        C31282o c31282o;
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.m2504i(59467);
            if (gTE == null) {
                WxaCommLibRuntimeReader.avN();
            }
            c31282o = gTE;
            AppMethodBeat.m2505o(59467);
        }
        return c31282o;
    }

    public static String getVersionName() {
        AppMethodBeat.m2504i(59468);
        String avk = WxaCommLibRuntimeReader.avP().avk();
        AppMethodBeat.m2505o(59468);
        return avk;
    }

    /* renamed from: xt */
    private static InputStream m42568xt(String str) {
        AppMethodBeat.m2504i(59469);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(59469);
            return null;
        }
        InputStream openRead = WxaCommLibRuntimeReader.avP().openRead(str);
        String format = String.format(Locale.US, "[v%d | %d | %s | %b]", new Object[]{Integer.valueOf(r1.avm().gVu), Integer.valueOf(r1.avm().gVt), C5046bo.m7579mx(r1.avm().gVv), Boolean.valueOf(r1.avm().gVw)});
        try {
            int i;
            String str2 = "MicroMsg.WxaCommLibRuntimeReader";
            String str3 = "read %s, %s, ret %d";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = format;
            if (openRead == null) {
                i = -1;
            } else {
                i = openRead.available();
            }
            objArr[2] = Integer.valueOf(i);
            C4990ab.m7417i(str2, str3, objArr);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WxaCommLibRuntimeReader", "read %s, %s, e %s", str, format, e);
        }
        AppMethodBeat.m2505o(59469);
        return openRead;
    }

    /* renamed from: xu */
    public static String m42569xu(String str) {
        AppMethodBeat.m2504i(59470);
        InputStream xt = WxaCommLibRuntimeReader.m42568xt(str);
        String str2;
        if (xt == null) {
            str2 = "";
            AppMethodBeat.m2505o(59470);
            return str2;
        }
        str2 = WxaCommLibRuntimeReader.convertStreamToString(xt);
        AppMethodBeat.m2505o(59470);
        return str2;
    }

    private static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.m2504i(59471);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[4096];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            String stringWriter2;
            try {
                int read = inputStreamReader.read(cArr);
                if (-1 != read) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    C5046bo.m7527b(inputStreamReader);
                    C5046bo.m7527b(inputStream);
                    stringWriter2 = stringWriter.toString();
                    AppMethodBeat.m2505o(59471);
                    return stringWriter2;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.WxaCommLibRuntimeReader", "convertStreamToString: read, %s", e.getMessage());
                stringWriter2 = "";
                return stringWriter2;
            } finally {
                C5046bo.m7527b(inputStreamReader);
                C5046bo.m7527b(inputStream);
                AppMethodBeat.m2505o(59471);
            }
        }
    }

    /* renamed from: xv */
    public static C31147o m42570xv(String str) {
        AppMethodBeat.m2504i(59472);
        InputStream xt = WxaCommLibRuntimeReader.m42568xt(str);
        if (xt == null) {
            AppMethodBeat.m2505o(59472);
            return null;
        }
        C31147o c31147o = new C31147o(C44216b.ako(str), "UTF-8", xt);
        AppMethodBeat.m2505o(59472);
        return c31147o;
    }

    public static WxaPkgWrappingInfo avQ() {
        AppMethodBeat.m2504i(59473);
        WxaPkgWrappingInfo avm = WxaCommLibRuntimeReader.avP().avm();
        AppMethodBeat.m2505o(59473);
        return avm;
    }
}
