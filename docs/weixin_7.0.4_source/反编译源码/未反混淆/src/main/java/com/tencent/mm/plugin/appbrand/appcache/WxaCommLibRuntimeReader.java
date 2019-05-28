package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class WxaCommLibRuntimeReader {
    private static o gTE;
    private static Future<Object> gTF;
    private static final ThreadPoolExecutor gTG = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    static final class a implements i<IPCVoid, Object> {
        private a() {
        }

        private WxaPkgWrappingInfo dB(boolean z) {
            AppMethodBeat.i(59458);
            Pair dE = as.dE(z);
            if (dE.first == com.tencent.mm.plugin.appbrand.appcache.as.a.gUM && dE.second == null && !z) {
                d.xDG.b(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(59457);
                        if (g.RN().eJb) {
                            try {
                                ((com.tencent.mm.plugin.appbrand.a.b) g.K(com.tencent.mm.plugin.appbrand.a.b.class)).dy(false);
                                AppMethodBeat.o(59457);
                                return;
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", e, "[NOT CRASH]", new Object[0]);
                                AppMethodBeat.o(59457);
                                return;
                            }
                        }
                        AppMethodBeat.o(59457);
                    }
                }, "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
            }
            if (dE.second != null && ((WxaPkgWrappingInfo) dE.second).gVt == 999) {
                ((WxaPkgWrappingInfo) dE.second).gVu = 0;
            }
            WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) dE.second;
            AppMethodBeat.o(59458);
            return wxaPkgWrappingInfo;
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(59459);
            if (g.RN().eJb) {
                WxaPkgWrappingInfo dB;
                int i;
                if (g.RN().eJb) {
                    dB = dB(false);
                    if (dB == null) {
                        dB = dB(true);
                    }
                } else {
                    dB = null;
                }
                if (dB == null) {
                    i = an.VERSION;
                } else {
                    i = dB.gVu;
                }
                ai.ns(i);
                AppMethodBeat.o(59459);
                return dB;
            }
            AccountNotReadyError accountNotReadyError = new AccountNotReadyError();
            AppMethodBeat.o(59459);
            return accountNotReadyError;
        }
    }

    static final class AccountNotReadyError extends Error implements Parcelable {
        public static final Creator<AccountNotReadyError> CREATOR = new Creator<AccountNotReadyError>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AccountNotReadyError[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(59455);
                AccountNotReadyError accountNotReadyError = new AccountNotReadyError((byte) 0);
                AppMethodBeat.o(59455);
                return accountNotReadyError;
            }
        };

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
            AppMethodBeat.i(59456);
            AppMethodBeat.o(59456);
        }
    }

    static final class b extends a {
        private final WxaPkgWrappingInfo gSf;
        private final ao gTI;

        /* synthetic */ b(WxaPkgWrappingInfo wxaPkgWrappingInfo, byte b) {
            this(wxaPkgWrappingInfo);
        }

        private b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            AppMethodBeat.i(59460);
            this.gSf = wxaPkgWrappingInfo;
            this.gTI = new ao(wxaPkgWrappingInfo.gSP);
            AppMethodBeat.o(59460);
        }

        public final void init() {
            AppMethodBeat.i(59461);
            this.gTI.avW();
            AppMethodBeat.o(59461);
        }

        public final InputStream openRead(String str) {
            AppMethodBeat.i(59462);
            this.gTI.avW();
            InputStream xy = this.gTI.xy(str);
            AppMethodBeat.o(59462);
            return xy;
        }

        public final WxaPkgWrappingInfo avm() {
            return this.gSf;
        }

        public final String toString() {
            AppMethodBeat.i(59463);
            String format = String.format(Locale.US, "PkgReader[%d] [%s]", new Object[]{Integer.valueOf(this.gSf.gVu), avk()});
            AppMethodBeat.o(59463);
            return format;
        }
    }

    static {
        AppMethodBeat.i(59474);
        AppMethodBeat.o(59474);
    }

    public static synchronized void avN() {
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.i(59464);
            try {
                sg();
                if (gTE == null) {
                    gTE = c.gSg;
                    AppMethodBeat.o(59464);
                }
            } catch (Throwable th) {
                if (gTE == null) {
                    gTE = c.gSg;
                }
                AppMethodBeat.o(59464);
            }
            AppMethodBeat.o(59464);
        }
    }

    public static synchronized void sg() {
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.i(59465);
            AccountNotReadyError accountNotReadyError;
            if (gTE != null) {
                ab.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", gTE);
                AppMethodBeat.o(59465);
            } else if (an.avU()) {
                gTE = c.gSg;
                ab.i("MicroMsg.WxaCommLibRuntimeReader", "load(), forceLocal, use AssetReader");
                AppMethodBeat.o(59465);
            } else if (ah.doI()) {
                try {
                    if (gTF != null) {
                        ab.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
                    } else {
                        ab.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
                        gTF = gTG.submit(new Callable<Object>() {
                            public final Object call() {
                                Object e;
                                AppMethodBeat.i(59454);
                                try {
                                    e = XIPCInvoker.a("com.tencent.mm", IPCVoid.eGH, a.class);
                                    AppMethodBeat.o(59454);
                                } catch (Exception e2) {
                                    e = e2;
                                    ab.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", e, "load() ipc read lib", new Object[0]);
                                    AppMethodBeat.o(59454);
                                }
                                return e;
                            }
                        });
                    }
                    String str = gTF.get(5, TimeUnit.SECONDS);
                    if (str instanceof WxaPkgWrappingInfo) {
                        o oVar;
                        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) str;
                        if (wxaPkgWrappingInfo.gVw) {
                            oVar = c.gSg;
                        } else {
                            Object oVar2 = new b(wxaPkgWrappingInfo, (byte) 0);
                        }
                        gTE = oVar2;
                        AppMethodBeat.o(59465);
                    } else if (str instanceof AccountNotReadyError) {
                        accountNotReadyError = (AccountNotReadyError) str;
                        AppMethodBeat.o(59465);
                        throw accountNotReadyError;
                    } else if (str instanceof Exception) {
                        Exception exception = (Exception) str;
                        AppMethodBeat.o(59465);
                        throw exception;
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder("Unknown result ").append(null).toString() == str ? BuildConfig.COMMAND : str.getClass().getName());
                        AppMethodBeat.o(59465);
                        throw illegalArgumentException;
                    }
                } catch (Throwable th) {
                    gTF.cancel(false);
                    gTF = null;
                    AppMethodBeat.o(59465);
                }
            } else {
                ab.e("MicroMsg.WxaCommLibRuntimeReader", "load(), mm process not exists");
                accountNotReadyError = new AccountNotReadyError();
                AppMethodBeat.o(59465);
                throw accountNotReadyError;
            }
        }
    }

    public static synchronized boolean avO() {
        boolean z = true;
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.i(59466);
            ab.i("MicroMsg.WxaCommLibRuntimeReader", "loaded(), reader %s", gTE);
            if (gTE != null) {
                AppMethodBeat.o(59466);
            } else {
                AppMethodBeat.o(59466);
                z = false;
            }
        }
        return z;
    }

    public static synchronized o avP() {
        o oVar;
        synchronized (WxaCommLibRuntimeReader.class) {
            AppMethodBeat.i(59467);
            if (gTE == null) {
                avN();
            }
            oVar = gTE;
            AppMethodBeat.o(59467);
        }
        return oVar;
    }

    public static String getVersionName() {
        AppMethodBeat.i(59468);
        String avk = avP().avk();
        AppMethodBeat.o(59468);
        return avk;
    }

    private static InputStream xt(String str) {
        AppMethodBeat.i(59469);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(59469);
            return null;
        }
        InputStream openRead = avP().openRead(str);
        String format = String.format(Locale.US, "[v%d | %d | %s | %b]", new Object[]{Integer.valueOf(r1.avm().gVu), Integer.valueOf(r1.avm().gVt), bo.mx(r1.avm().gVv), Boolean.valueOf(r1.avm().gVw)});
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
            ab.i(str2, str3, objArr);
        } catch (Exception e) {
            ab.e("MicroMsg.WxaCommLibRuntimeReader", "read %s, %s, e %s", str, format, e);
        }
        AppMethodBeat.o(59469);
        return openRead;
    }

    public static String xu(String str) {
        AppMethodBeat.i(59470);
        InputStream xt = xt(str);
        String str2;
        if (xt == null) {
            str2 = "";
            AppMethodBeat.o(59470);
            return str2;
        }
        str2 = convertStreamToString(xt);
        AppMethodBeat.o(59470);
        return str2;
    }

    private static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.i(59471);
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
                    bo.b(inputStreamReader);
                    bo.b(inputStream);
                    stringWriter2 = stringWriter.toString();
                    AppMethodBeat.o(59471);
                    return stringWriter2;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.WxaCommLibRuntimeReader", "convertStreamToString: read, %s", e.getMessage());
                stringWriter2 = "";
                return stringWriter2;
            } finally {
                bo.b(inputStreamReader);
                bo.b(inputStream);
                AppMethodBeat.o(59471);
            }
        }
    }

    public static com.tencent.xweb.o xv(String str) {
        AppMethodBeat.i(59472);
        InputStream xt = xt(str);
        if (xt == null) {
            AppMethodBeat.o(59472);
            return null;
        }
        com.tencent.xweb.o oVar = new com.tencent.xweb.o(com.tencent.mm.sdk.f.b.ako(str), "UTF-8", xt);
        AppMethodBeat.o(59472);
        return oVar;
    }

    public static WxaPkgWrappingInfo avQ() {
        AppMethodBeat.i(59473);
        WxaPkgWrappingInfo avm = avP().avm();
        AppMethodBeat.o(59473);
        return avm;
    }
}
