package com.tencent.xweb.xwalk.p687b;

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

/* renamed from: com.tencent.xweb.xwalk.b.g */
public final class C6053g extends AsyncTask<C6055a, C6054b, C6057c> {
    private C31154b ATE = null;
    private C6055a ATF = null;
    private int ATG = 0;
    private long ATH = 0;
    private Timer mTimer = null;

    /* renamed from: com.tencent.xweb.xwalk.b.g$b */
    public static class C6054b {
        public long ATK;
        public long mTotalSize;
        public String mUrl;
    }

    /* renamed from: com.tencent.xweb.xwalk.b.g$a */
    public static class C6055a {
        public boolean ATJ;
        public String mFilePath;
        public String mUrl;
    }

    /* renamed from: com.tencent.xweb.xwalk.b.g$1 */
    class C60561 extends TimerTask {
        C60561() {
        }

        public final void run() {
            AppMethodBeat.m2504i(85491);
            XWalkInitializer.addXWalkInitializeLog("task retry execute ! mRetrytimes = " + C6053g.this.ATG);
            C6053g.m9532a(C6053g.this.ATF, C6053g.this.ATE, C6053g.this.ATG);
            C6053g.m9535d(C6053g.this);
            AppMethodBeat.m2505o(85491);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.b.g$c */
    public static class C6057c {
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

    /* renamed from: com.tencent.xweb.xwalk.b.g$d */
    static class C6058d {
        public static final HostnameVerifier ATO = new C60591();

        /* renamed from: com.tencent.xweb.xwalk.b.g$d$1 */
        static class C60591 implements HostnameVerifier {
            C60591() {
            }

            public final boolean verify(String str, SSLSession sSLSession) {
                AppMethodBeat.m2504i(85492);
                if (str.contains("dldir1.qq.com")) {
                    AppMethodBeat.m2505o(85492);
                    return true;
                }
                AppMethodBeat.m2505o(85492);
                return false;
            }
        }

        static {
            AppMethodBeat.m2504i(85493);
            AppMethodBeat.m2505o(85493);
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.m2504i(85497);
        C6057c a = m9530a((C6055a[]) objArr);
        AppMethodBeat.m2505o(85497);
        return a;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        Object obj2 = null;
        AppMethodBeat.m2504i(85496);
        C6057c c6057c = (C6057c) obj;
        if (c6057c == null) {
            c6057c = new C6057c();
            c6057c.ATL = -10004;
            XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para onPostExecute");
        }
        if (c6057c.ATL == 0) {
            XWalkInitializer.addXWalkInitializeLog("task succeed! ");
            this.ATE.mo13335a(c6057c);
            AppMethodBeat.m2505o(85496);
            return;
        }
        XWalkInitializer.addXWalkInitializeLog("task failed! retcode = " + c6057c.ATL + " mRetrytimes = " + this.ATG);
        if (!(this.ATG >= 2 || c6057c.ATL == -10001 || c6057c.ATL == -10004)) {
            obj2 = 1;
        }
        if (obj2 != null) {
            this.ATG++;
            XWalkInitializer.addXWalkInitializeLog("task retry!  mRetrytimes = " + this.ATG);
            this.mTimer = new Timer();
            this.mTimer.schedule(new C60561(), 3000 * ((long) this.ATG));
            AppMethodBeat.m2505o(85496);
            return;
        }
        this.ATE.mo13336b(c6057c);
        AppMethodBeat.m2505o(85496);
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }

    /* renamed from: a */
    public static void m9531a(C6055a c6055a, C31154b c31154b) {
        AppMethodBeat.m2504i(85494);
        C6053g c6053g = new C6053g();
        c6053g.ATE = c31154b;
        c6053g.ATF = c6055a;
        c6053g.ATG = 0;
        c6053g.ATH = System.currentTimeMillis();
        c6053g.execute(new C6055a[]{c6053g.ATF});
        AppMethodBeat.m2505o(85494);
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
    /* renamed from: a */
    private C6057c m9530a(C6055a... c6055aArr) {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(85495);
        if (c6055aArr == null) {
            AppMethodBeat.m2505o(85495);
            return null;
        } else if (c6055aArr.length != 1) {
            AppMethodBeat.m2505o(85495);
            return null;
        } else {
            C6055a c6055a = c6055aArr[0];
            if (c6055a == null) {
                AppMethodBeat.m2505o(85495);
                return null;
            }
            C6057c c6057c = new C6057c();
            c6057c.mUrl = c6055a.mUrl;
            c6057c.mFilePath = c6055a.mFilePath;
            c6057c.ATL = 0;
            c6057c.hxN = "";
            c6057c.mRetryTimes = this.ATG;
            c6057c.ATM = 0;
            c6057c.mTotalSize = 0;
            c6057c.ATN = 0;
            c6057c.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(XWalkEnvironment.getApplicationContext());
            if (c6055a.mUrl == null || c6055a.mFilePath == null || c6055a.mUrl.length() == 0 || c6055a.mFilePath.length() == 0 || this.ATE == null) {
                XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para");
                c6057c.ATL = -10001;
                AppMethodBeat.m2505o(85495);
                return c6057c;
            }
            OutputStream outputStream = null;
            InputStream inputStream = null;
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(c6055a.mUrl).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("GET");
                    if (c6055a.ATJ && (httpURLConnection2 instanceof HttpsURLConnection)) {
                        ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(C6058d.ATO);
                    }
                    httpURLConnection2.setConnectTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
                    httpURLConnection2.setReadTimeout(TXRecordCommon.AUDIO_SAMPLERATE_8000);
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode == 200) {
                        inputStream = httpURLConnection2.getInputStream();
                        responseCode = httpURLConnection2.getContentLength();
                        String str = c6055a.mFilePath;
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        OutputStream fileOutputStream = new FileOutputStream(str);
                        try {
                            byte[] bArr = new byte[4096];
                            long j = 0;
                            C6054b c6054b = new C6054b();
                            c6054b.mUrl = c6055a.mUrl;
                            c6054b.mTotalSize = (long) responseCode;
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
                                        AppMethodBeat.m2505o(85495);
                                        return null;
                                    } catch (IOException e2) {
                                        XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e2.toString());
                                        c6057c.ATL = -10003;
                                        AppMethodBeat.m2505o(85495);
                                        return c6057c;
                                    }
                                } else {
                                    j += (long) read;
                                    fileOutputStream.write(bArr, 0, read);
                                    c6054b.ATK = j;
                                    if (responseCode > 0) {
                                        publishProgress(new C6054b[]{c6054b});
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            httpURLConnection = httpURLConnection2;
                            outputStream = fileOutputStream;
                            try {
                                XWalkInitializer.addXWalkInitializeLog("task failed excetion =  " + e.toString());
                                c6057c.ATL = -10002;
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                AppMethodBeat.m2505o(85495);
                                return c6057c;
                            } catch (Throwable th2) {
                                th = th2;
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                AppMethodBeat.m2505o(85495);
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
                            AppMethodBeat.m2505o(85495);
                            throw th;
                        }
                    }
                    c6057c.ATL = -10005;
                    c6057c.hxN = "responseCode ".concat(String.valueOf(responseCode));
                    httpURLConnection2.disconnect();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e22) {
                            XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e22.toString());
                            c6057c.ATL = -10003;
                            AppMethodBeat.m2505o(85495);
                            return c6057c;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(85495);
                    return c6057c;
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
                            c6057c.ATL = -10003;
                            AppMethodBeat.m2505o(85495);
                            return c6057c;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(85495);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                XWalkInitializer.addXWalkInitializeLog("task failed excetion =  " + e.toString());
                c6057c.ATL = -10002;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e2222) {
                        XWalkInitializer.addXWalkInitializeLog("task close failed  excetion =  " + e2222.toString());
                        c6057c.ATL = -10003;
                        AppMethodBeat.m2505o(85495);
                        return c6057c;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                AppMethodBeat.m2505o(85495);
                return c6057c;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m9532a(C6055a c6055a, C31154b c31154b, int i) {
        AppMethodBeat.m2504i(85498);
        C6053g c6053g = new C6053g();
        c6053g.ATE = c31154b;
        c6053g.ATF = c6055a;
        c6053g.ATG = i;
        c6053g.ATH = System.currentTimeMillis();
        c6053g.execute(new C6055a[]{c6053g.ATF});
        AppMethodBeat.m2505o(85498);
    }

    /* renamed from: d */
    static /* synthetic */ void m9535d(C6053g c6053g) {
        AppMethodBeat.m2504i(85499);
        if (c6053g.mTimer != null) {
            c6053g.mTimer.cancel();
            c6053g.mTimer = null;
        }
        AppMethodBeat.m2505o(85499);
    }
}
