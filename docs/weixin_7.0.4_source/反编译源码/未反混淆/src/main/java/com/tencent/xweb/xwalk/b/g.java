package com.tencent.xweb.xwalk.b;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class g extends AsyncTask<a, b, c> {
    private b ATE = null;
    private a ATF = null;
    private int ATG = 0;
    private long ATH = 0;
    private Timer mTimer = null;

    public static class b {
        public long ATK;
        public long mTotalSize;
        public String mUrl;
    }

    public static class a {
        public boolean ATJ;
        public String mFilePath;
        public String mUrl;
    }

    public static class c {
        public int ATL;
        public long ATM;
        public int ATN;
        public String hxN;
        public String mFilePath;
        public int mNetWorkType;
        public int mRetryTimes;
        public long mTotalSize;
        public String mUrl;
    }

    static class d {
        public static final HostnameVerifier ATO = new HostnameVerifier() {
            public final boolean verify(String str, SSLSession sSLSession) {
                AppMethodBeat.i(85492);
                if (str.contains("dldir1.qq.com")) {
                    AppMethodBeat.o(85492);
                    return true;
                }
                AppMethodBeat.o(85492);
                return false;
            }
        };

        static {
            AppMethodBeat.i(85493);
            AppMethodBeat.o(85493);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.i(85497);
        c a = a((a[]) objArr);
        AppMethodBeat.o(85497);
        return a;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        Object obj2 = null;
        AppMethodBeat.i(85496);
        c cVar = (c) obj;
        if (cVar == null) {
            cVar = new c();
            cVar.ATL = -10004;
            XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para onPostExecute");
        }
        if (cVar.ATL == 0) {
            XWalkInitializer.addXWalkInitializeLog("task succeed! ");
            this.ATE.a(cVar);
            AppMethodBeat.o(85496);
            return;
        }
        XWalkInitializer.addXWalkInitializeLog("task failed! retcode = " + cVar.ATL + " mRetrytimes = " + this.ATG);
        if (!(this.ATG >= 2 || cVar.ATL == -10001 || cVar.ATL == -10004)) {
            obj2 = 1;
        }
        if (obj2 != null) {
            this.ATG++;
            XWalkInitializer.addXWalkInitializeLog("task retry!  mRetrytimes = " + this.ATG);
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() {
                public final void run() {
                    AppMethodBeat.i(85491);
                    XWalkInitializer.addXWalkInitializeLog("task retry execute ! mRetrytimes = " + g.this.ATG);
                    g.a(g.this.ATF, g.this.ATE, g.this.ATG);
                    g.d(g.this);
                    AppMethodBeat.o(85491);
                }
            }, 3000 * ((long) this.ATG));
            AppMethodBeat.o(85496);
            return;
        }
        this.ATE.b(cVar);
        AppMethodBeat.o(85496);
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }

    public static void a(a aVar, b bVar) {
        AppMethodBeat.i(85494);
        g gVar = new g();
        gVar.ATE = bVar;
        gVar.ATF = aVar;
        gVar.ATG = 0;
        gVar.ATH = System.currentTimeMillis();
        gVar.execute(new a[]{gVar.ATF});
        AppMethodBeat.o(85494);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPreExecute() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:95:0x020c A:{SYNTHETIC, Splitter:B:95:0x020c} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0211 A:{Catch:{ IOException -> 0x0220 }} */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016c A:{SYNTHETIC, Splitter:B:63:0x016c} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0171 A:{Catch:{ IOException -> 0x01e3 }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x020c A:{SYNTHETIC, Splitter:B:95:0x020c} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0211 A:{Catch:{ IOException -> 0x0220 }} */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0216  */
    /* JADX WARNING: Missing block: B:71:?, code skipped:
            r4.mTotalSize = r10;
            r4.ATM = java.lang.System.currentTimeMillis() - r14.ATH;
     */
    /* JADX WARNING: Missing block: B:72:0x018d, code skipped:
            r7 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private c a(a... aVarArr) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(85495);
        if (aVarArr == null) {
            AppMethodBeat.o(85495);
            return null;
        } else if (aVarArr.length != 1) {
            AppMethodBeat.o(85495);
            return null;
        } else {
            a aVar = aVarArr[0];
            if (aVar == null) {
                AppMethodBeat.o(85495);
                return null;
            }
            c cVar = new c();
            cVar.mUrl = aVar.mUrl;
            cVar.mFilePath = aVar.mFilePath;
            cVar.ATL = 0;
            cVar.hxN = "";
            cVar.mRetryTimes = this.ATG;
            cVar.ATM = 0;
            cVar.mTotalSize = 0;
            cVar.ATN = 0;
            cVar.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext());
            if (aVar.mUrl == null || aVar.mFilePath == null || aVar.mUrl.length() == 0 || aVar.mFilePath.length() == 0 || this.ATE == null) {
                XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para");
                cVar.ATL = -10001;
                AppMethodBeat.o(85495);
                return cVar;
            }
            OutputStream outputStream = null;
            InputStream inputStream = null;
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(aVar.mUrl).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("GET");
                    if (aVar.ATJ && (httpURLConnection2 instanceof HttpsURLConnection)) {
                        ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(d.ATO);
                    }
                    httpURLConnection2.setConnectTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
                    httpURLConnection2.setReadTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode == 200) {
                        inputStream = httpURLConnection2.getInputStream();
                        responseCode = httpURLConnection2.getContentLength();
                        String str = aVar.mFilePath;
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        OutputStream fileOutputStream = new FileOutputStream(str);
                        try {
                            byte[] bArr = new byte[4096];
                            long j = 0;
                            b bVar = new b();
                            bVar.mUrl = aVar.mUrl;
                            bVar.mTotalSize = (long) responseCode;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else if (isCancelled()) {
                                    inputStream.close();
                                    try {
                                        fileOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        AppMethodBeat.o(85495);
                                        return null;
                                    } catch (IOException e2) {
                                        XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e2.toString());
                                        cVar.ATL = -10003;
                                        AppMethodBeat.o(85495);
                                        return cVar;
                                    }
                                } else {
                                    j += (long) read;
                                    fileOutputStream.write(bArr, 0, read);
                                    bVar.ATK = j;
                                    if (responseCode > 0) {
                                        publishProgress(new b[]{bVar});
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            httpURLConnection = httpURLConnection2;
                            outputStream = fileOutputStream;
                            try {
                                XWalkInitializer.addXWalkInitializeLog("task failed excetion =  " + e.toString());
                                cVar.ATL = -10002;
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                AppMethodBeat.o(85495);
                                return cVar;
                            } catch (Throwable th2) {
                                th = th2;
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                AppMethodBeat.o(85495);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection = httpURLConnection2;
                            outputStream = fileOutputStream;
                            if (outputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            AppMethodBeat.o(85495);
                            throw th;
                        }
                    }
                    cVar.ATL = -10005;
                    cVar.hxN = "responseCode ".concat(String.valueOf(responseCode));
                    httpURLConnection2.disconnect();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e22.toString());
                            cVar.ATL = -10003;
                            AppMethodBeat.o(85495);
                            return cVar;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.o(85495);
                    return cVar;
                } catch (Exception e4) {
                    e = e4;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th4) {
                    th = th4;
                    httpURLConnection = httpURLConnection2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e222) {
                            XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e222.toString());
                            cVar.ATL = -10003;
                            AppMethodBeat.o(85495);
                            return cVar;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.o(85495);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                XWalkInitializer.addXWalkInitializeLog("task failed excetion =  " + e.toString());
                cVar.ATL = -10002;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2222) {
                        XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e2222.toString());
                        cVar.ATL = -10003;
                        AppMethodBeat.o(85495);
                        return cVar;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                AppMethodBeat.o(85495);
                return cVar;
            }
        }
    }

    static /* synthetic */ void a(a aVar, b bVar, int i) {
        AppMethodBeat.i(85498);
        g gVar = new g();
        gVar.ATE = bVar;
        gVar.ATF = aVar;
        gVar.ATG = i;
        gVar.ATH = System.currentTimeMillis();
        gVar.execute(new a[]{gVar.ATF});
        AppMethodBeat.o(85498);
    }

    static /* synthetic */ void d(g gVar) {
        AppMethodBeat.i(85499);
        if (gVar.mTimer != null) {
            gVar.mTimer.cancel();
            gVar.mTimer = null;
        }
        AppMethodBeat.o(85499);
    }
}
