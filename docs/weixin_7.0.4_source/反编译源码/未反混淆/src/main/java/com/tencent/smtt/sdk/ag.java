package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.y;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

class ag {
    private static int d = 5;
    private static int e = 1;
    private static final String[] f = new String[]{"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private Set<String> A;
    private int B = d;
    private boolean C;
    String a;
    String[] b = null;
    int c = 0;
    private Context g;
    private String h;
    private String i;
    private String j;
    private File k;
    private long l;
    private int m = 30000;
    private int n = i.sHCENCODEVIDEOTIMEOUT;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private HttpURLConnection t;
    private String u;
    private TbsLogInfo v;
    private String w;
    private int x;
    private boolean y;
    private Handler z;

    public ag(Context context) {
        AppMethodBeat.i(64256);
        this.g = context.getApplicationContext();
        this.v = TbsLogReport.getInstance(this.g).tbsLogInfo();
        this.A = new HashSet();
        this.u = "tbs_downloading_" + this.g.getPackageName();
        an.a();
        this.k = an.t(this.g);
        if (this.k == null) {
            NullPointerException nullPointerException = new NullPointerException("TbsCorePrivateDir is null!");
            AppMethodBeat.o(64256);
            throw nullPointerException;
        }
        f();
        this.w = null;
        this.x = -1;
        AppMethodBeat.o(64256);
    }

    private long a(long j, long j2) {
        AppMethodBeat.i(64264);
        long currentTimeMillis = System.currentTimeMillis();
        this.v.setDownConsumeTime(currentTimeMillis - j);
        this.v.setDownloadSize(j2);
        AppMethodBeat.o(64264);
        return currentTimeMillis;
    }

    @TargetApi(8)
    static File a(Context context) {
        AppMethodBeat.i(64278);
        try {
            File file = VERSION.SDK_INT >= 8 ? new File(k.a(context, 4)) : null;
            if (!(file == null || file.exists() || file.isDirectory())) {
                file.mkdirs();
            }
            AppMethodBeat.o(64278);
            return file;
        } catch (Exception e) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            AppMethodBeat.o(64278);
            return null;
        }
    }

    private static File a(Context context, int i) {
        AppMethodBeat.i(64280);
        File file = new File(k.a(context, i));
        if (file.exists() && file.isDirectory()) {
            if (new File(file, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org").exists()) {
                AppMethodBeat.o(64280);
                return file;
            }
            AppMethodBeat.o(64280);
            return null;
        }
        AppMethodBeat.o(64280);
        return null;
    }

    private String a(Throwable th) {
        AppMethodBeat.i(64266);
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            stackTraceString = stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.o(64266);
            return stackTraceString;
        }
        AppMethodBeat.o(64266);
        return stackTraceString;
    }

    private String a(URL url) {
        AppMethodBeat.i(64277);
        String str = "";
        try {
            str = InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Error | Exception e) {
        }
        AppMethodBeat.o(64277);
        return str;
    }

    private void a(int i, String str, boolean z) {
        AppMethodBeat.i(64265);
        if (z || this.p > this.B) {
            this.v.setErrorCode(i);
            this.v.setFailDetail(str);
        }
        AppMethodBeat.o(64265);
    }

    private void a(long j) {
        AppMethodBeat.i(64269);
        this.p++;
        if (j <= 0) {
            try {
                j = m();
            } catch (Exception e) {
                AppMethodBeat.o(64269);
                return;
            }
        }
        Thread.sleep(j);
        AppMethodBeat.o(64269);
    }

    private void a(Closeable closeable) {
        AppMethodBeat.i(64268);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(64268);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(64268);
    }

    /* JADX WARNING: Missing block: B:7:0x0014, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(64285);
     */
    /* JADX WARNING: Missing block: B:62:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(File file, Context context) {
        AppMethodBeat.i(64285);
        synchronized (a.class) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        try {
                            File a = a(context);
                            if (a != null) {
                                File file2;
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                    file2 = new File(a, "x5.tbs.decouple");
                                } else {
                                    file2 = new File(a, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                                }
                                file2.delete();
                                k.b(file, file2);
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1 && TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0) == a.a(context, file)) {
                                    file2 = new File(a, "x5.tbs.decouple");
                                    if (a.a(context, file) != a.a(context, file2)) {
                                        file2.delete();
                                        k.b(file, file2);
                                    }
                                }
                                if (file2.getName().contains("tbs.org")) {
                                    File[] listFiles = a.listFiles();
                                    Pattern compile = Pattern.compile("x5.backup(.*)");
                                    for (File file3 : listFiles) {
                                        if (compile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                            file3.delete();
                                        }
                                    }
                                    file2 = new File(a, "x5.backup.".concat(String.valueOf(TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))));
                                    if (file2.exists()) {
                                        TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
                                    } else {
                                        file2.createNewFile();
                                    }
                                }
                            }
                        } catch (Exception e) {
                        }
                        AppMethodBeat.o(64285);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(64285);
                }
            }
        }
    }

    private void a(String str) {
        AppMethodBeat.i(64257);
        URL url = new URL(str);
        if (this.t != null) {
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        this.t = (HttpURLConnection) url.openConnection();
        this.t.setRequestProperty("User-Agent", TbsDownloader.a(this.g));
        this.t.setRequestProperty("Accept-Encoding", "identity");
        this.t.setRequestMethod("GET");
        this.t.setInstanceFollowRedirects(false);
        this.t.setConnectTimeout(this.n);
        this.t.setReadTimeout(this.m);
        AppMethodBeat.o(64257);
    }

    @TargetApi(8)
    static File b(Context context) {
        AppMethodBeat.i(64279);
        try {
            File a;
            if (VERSION.SDK_INT >= 8) {
                a = a(context, 4);
                if (a == null) {
                    a = a(context, 3);
                }
                if (a == null) {
                    a = a(context, 2);
                }
                if (a == null) {
                    a = a(context, 1);
                }
            } else {
                a = null;
            }
            AppMethodBeat.o(64279);
            return a;
        } catch (Exception e) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            AppMethodBeat.o(64279);
            return null;
        }
    }

    private void b(boolean z) {
        AppMethodBeat.i(64267);
        y.a(this.g);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.g);
        instance.a.put(TbsConfigKey.KEY_FULL_PACKAGE, Boolean.FALSE);
        instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-123));
        instance.commit();
        QbSdk.m.onDownloadFinish(z ? 100 : 120);
        int i = instance.mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
        TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
        if (i == 3 || i > Downloads.MIN_WAIT_FOR_NETWORK) {
            File a = a(this.g);
            if (a != null) {
                File file = new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                int a2 = a.a(this.g, file);
                File file2 = new File(this.k, "x5.tbs");
                String absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
                int i2 = instance.mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", i);
                bundle.putInt("old_core_ver", a2);
                bundle.putInt("new_core_ver", i2);
                bundle.putString("old_apk_location", file.getAbsolutePath());
                bundle.putString("new_apk_location", absolutePath);
                bundle.putString("diff_file_location", absolutePath);
                an.a().b(this.g, bundle);
                AppMethodBeat.o(64267);
                return;
            }
            d();
            instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
            instance.commit();
            AppMethodBeat.o(64267);
            return;
        }
        an.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), instance.mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
        a(new File(this.k, "x5.tbs"), this.g);
        AppMethodBeat.o(64267);
    }

    private boolean b(int i) {
        AppMethodBeat.i(64259);
        try {
            File file = new File(this.k, "x5.tbs");
            File a = a(this.g);
            if (a != null) {
                File file2 = new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                file.delete();
                k.b(file2, file);
                if (a.a(this.g, file, 0, i)) {
                    AppMethodBeat.o(64259);
                    return true;
                }
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
                AppMethodBeat.o(64259);
                return false;
            }
            AppMethodBeat.o(64259);
            return false;
        } catch (Exception e) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e.getMessage());
            AppMethodBeat.o(64259);
            return false;
        }
    }

    public static void c(Context context) {
        AppMethodBeat.i(64286);
        try {
            an.a();
            File t = an.t(context);
            new File(t, "x5.tbs").delete();
            new File(t, "x5.tbs.temp").delete();
            t = a(context);
            if (t != null) {
                new File(t, "x5.tbs.org").delete();
                new File(t, "x5.oversea.tbs.org").delete();
                File[] listFiles = t.listFiles();
                Pattern compile = Pattern.compile("x5.backup(.*)");
                for (File file : listFiles) {
                    if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                        file.delete();
                    }
                }
            }
            AppMethodBeat.o(64286);
        } catch (Exception e) {
            AppMethodBeat.o(64286);
        }
    }

    private boolean c(boolean z) {
        AppMethodBeat.i(64272);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=".concat(String.valueOf(z)));
        File file = z ? new File(this.k, "x5.tbs") : new File(this.k, "x5.tbs.temp");
        boolean delete = file.exists() ? file.delete() : true;
        AppMethodBeat.o(64272);
        return delete;
    }

    private boolean c(boolean z, boolean z2) {
        long j = 0;
        AppMethodBeat.i(64271);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=".concat(String.valueOf(z)));
        File file = new File(this.k, !z ? "x5.tbs" : "x5.tbs.temp");
        if (file.exists()) {
            String string = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsConfigKey.KEY_TBSAPK_MD5, null);
            String a = a.a(file);
            if (string == null || !string.equals(a)) {
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " md5 failed");
                if (z) {
                    this.v.setCheckErrorDetail("fileMd5 not match");
                }
                AppMethodBeat.o(64271);
                return false;
            }
            boolean renameTo;
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] md5(" + a + ") successful!");
            if (z) {
                long j2;
                long j3 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
                if (!file.exists()) {
                    j2 = 0;
                } else if (j3 > 0) {
                    j2 = file.length();
                    if (j3 == j2) {
                        j = j2;
                    }
                }
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " filelength failed");
                this.v.setCheckErrorDetail("fileLength:" + j2 + ",contentLength:" + j3);
                AppMethodBeat.o(64271);
                return false;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] length(" + j + ") successful!");
            int i = -1;
            if (z2 && !z) {
                i = a.a(this.g, file);
                int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                if (i2 != i) {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " versionCode failed");
                    if (z) {
                        this.v.setCheckErrorDetail("fileVersion:" + i + ",configVersion:" + i2);
                    }
                    AppMethodBeat.o(64271);
                    return false;
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
            if (z2 && !z) {
                string = b.a(this.g, false, file);
                if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(string)) {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " signature failed");
                    if (z) {
                        this.v.setCheckErrorDetail("signature:" + (string == null ? BuildConfig.COMMAND : Integer.valueOf(string.length())));
                    }
                    AppMethodBeat.o(64271);
                    return false;
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] signature successful!");
            if (z) {
                Throwable th;
                try {
                    renameTo = file.renameTo(new File(this.k, "x5.tbs"));
                    th = null;
                } catch (Exception e) {
                    th = e;
                    renameTo = false;
                }
                if (!renameTo) {
                    a(109, a(th), true);
                    AppMethodBeat.o(64271);
                    return false;
                }
            }
            renameTo = false;
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] rename(" + renameTo + ") successful!");
            AppMethodBeat.o(64271);
            return true;
        }
        AppMethodBeat.o(64271);
        return false;
    }

    private void f() {
        this.p = 0;
        this.q = 0;
        this.l = -1;
        this.j = null;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
    }

    private void g() {
        AppMethodBeat.i(64258);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        if (this.t != null) {
            if (!this.r) {
                this.v.setResolveIp(a(this.t.getURL()));
            }
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.t = null;
        }
        int i = this.v.a;
        if (this.r || !this.y) {
            TbsDownloader.a = false;
            AppMethodBeat.o(64258);
            return;
        }
        this.v.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.g);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = Apn.getApnType(this.g);
        this.v.setApn(apnInfo);
        this.v.setNetworkType(apnType);
        if (!(apnType == this.x && apnInfo.equals(this.w))) {
            this.v.setNetworkChange(0);
        }
        if ((this.v.a == 0 || this.v.a == 107) && this.v.getDownFinalFlag() == 0) {
            if (!Apn.isNetworkAvailable(this.g)) {
                a(101, null, true);
            } else if (!l()) {
                a(101, null, true);
            }
        }
        if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            TbsLogReport.getInstance(this.g).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
        } else {
            TbsLogReport.getInstance(this.g).eventReport(EventType.TYPE_DOWNLOAD, this.v);
        }
        this.v.resetArgs();
        if (i != 100) {
            QbSdk.m.onDownloadFinish(i);
        }
        AppMethodBeat.o(64258);
    }

    private boolean h() {
        AppMethodBeat.i(64270);
        File file = new File(k.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        int i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i == 0) {
            i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        boolean a = a.a(this.g, file, 0, i);
        AppMethodBeat.o(64270);
        return a;
    }

    private void i() {
        AppMethodBeat.i(64273);
        try {
            if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                AppMethodBeat.o(64273);
                return;
            }
            File file = new File(k.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file.exists()) {
                file.delete();
                File[] listFiles = file.getParentFile().listFiles();
                Pattern compile = Pattern.compile("x5.backup(.*)");
                for (File file2 : listFiles) {
                    if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        file2.delete();
                    }
                }
            }
            AppMethodBeat.o(64273);
        } catch (Exception e) {
            AppMethodBeat.o(64273);
        }
    }

    private boolean j() {
        AppMethodBeat.i(64274);
        boolean z = false;
        if (new File(this.k, "x5.tbs.temp").exists()) {
            z = true;
        }
        AppMethodBeat.o(64274);
        return z;
    }

    private long k() {
        AppMethodBeat.i(64275);
        long j = 0;
        File file = new File(this.k, "x5.tbs.temp");
        if (file.exists()) {
            j = file.length();
        }
        AppMethodBeat.o(64275);
        return j;
    }

    private boolean l() {
        Throwable th;
        boolean z = false;
        AppMethodBeat.i(64276);
        Closeable inputStream;
        Closeable inputStreamReader;
        Closeable bufferedReader;
        try {
            inputStream = Runtime.getRuntime().exec("ping ".concat(String.valueOf("www.qq.com"))).getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i = 0;
                    do {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            } else if (readLine.contains("TTL") || readLine.contains("ttl")) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            a(inputStream);
                            a(inputStreamReader);
                            a(bufferedReader);
                            AppMethodBeat.o(64276);
                            throw th;
                        }
                    } while (i < 5);
                    a(inputStream);
                    a(inputStreamReader);
                    a(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    a(inputStream);
                    a(inputStreamReader);
                    a(bufferedReader);
                    AppMethodBeat.o(64276);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
                a(inputStream);
                a(inputStreamReader);
                a(bufferedReader);
                AppMethodBeat.o(64276);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
            a(inputStream);
            a(inputStreamReader);
            a(bufferedReader);
            AppMethodBeat.o(64276);
            throw th;
        }
        AppMethodBeat.o(64276);
        return z;
    }

    private long m() {
        switch (this.p) {
            case 1:
            case 2:
                return 20000 * ((long) this.p);
            case 3:
            case 4:
                return 100000;
            default:
                return 200000;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c8 A:{SYNTHETIC, Splitter:B:36:0x00c8} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4 A:{SYNTHETIC, Splitter:B:44:0x00d4} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean n() {
        CharSequence charSequence;
        Object charSequence2;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(64287);
        boolean z3 = Apn.getApnType(this.g) == 3;
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=".concat(String.valueOf(z3)));
        if (z3) {
            String wifiSSID = Apn.getWifiSSID(this.g);
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=".concat(String.valueOf(wifiSSID)));
            HttpURLConnection httpURLConnection2;
            try {
                httpURLConnection2 = (HttpURLConnection) new URL("http://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                    httpURLConnection2.setReadTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.getInputStream();
                    int responseCode = httpURLConnection2.getResponseCode();
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=".concat(String.valueOf(responseCode)));
                    if (responseCode != 204) {
                        z = false;
                    }
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                            charSequence2 = wifiSSID;
                            z2 = z;
                        } catch (Exception e) {
                            charSequence2 = wifiSSID;
                            z2 = z;
                        }
                    } else {
                        charSequence2 = wifiSSID;
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e2) {
                        }
                    }
                    AppMethodBeat.o(64287);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                }
                AppMethodBeat.o(64287);
                throw th;
            }
        }
        if (!(z2 || TextUtils.isEmpty(charSequence2) || this.A.contains(charSequence2))) {
            this.A.add(charSequence2);
            o();
            this.z.sendMessageDelayed(this.z.obtainMessage(150, charSequence2), 120000);
        }
        if (z2 && this.A.contains(charSequence2)) {
            this.A.remove(charSequence2);
        }
        AppMethodBeat.o(64287);
        return z2;
    }

    private void o() {
        AppMethodBeat.i(64288);
        if (this.z == null) {
            this.z = new ah(this, al.a().getLooper());
        }
        AppMethodBeat.o(64288);
    }

    public void a(int i) {
        AppMethodBeat.i(64284);
        try {
            File file = new File(this.k, "x5.tbs");
            int a = a.a(this.g, file);
            if (-1 == a || (i > 0 && i == a)) {
                file.delete();
            }
            AppMethodBeat.o(64284);
        } catch (Exception e) {
            AppMethodBeat.o(64284);
        }
    }

    public boolean a() {
        AppMethodBeat.i(64261);
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            File file = new File(k.a(this.g, 4), "x5.tbs.decouple");
            if (file.exists()) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                File b = TbsDownloader.b(TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                if (b != null && b.exists()) {
                    k.b(b, file);
                }
            }
            if (a.a(this.g, file, 0, TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, -1))) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
                boolean e = an.a().e(this.g);
                AppMethodBeat.o(64261);
                return e;
            }
            TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup no backup file !!!");
            file = new File(k.a(this.g, 4), "x5.tbs.decouple");
            if (file.exists()) {
                file.delete();
            }
            AppMethodBeat.o(64261);
            return false;
        } catch (Exception e2) {
        }
    }

    public boolean a(boolean z) {
        AppMethodBeat.i(64263);
        if (z && !n() && (!QbSdk.getDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.g))) {
            AppMethodBeat.o(64263);
            return false;
        } else if (this.b == null || this.c < 0 || this.c >= this.b.length) {
            AppMethodBeat.o(64263);
            return false;
        } else {
            String[] strArr = this.b;
            int i = this.c;
            this.c = i + 1;
            this.j = strArr[i];
            this.p = 0;
            this.q = 0;
            this.l = -1;
            this.o = false;
            this.r = false;
            this.s = false;
            this.y = false;
            AppMethodBeat.o(64263);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(boolean z, boolean z2) {
        int i;
        AppMethodBeat.i(64260);
        int i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int j = an.a().j(this.g);
        if (i2 == 0) {
            i2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            this.a = "by default key";
            i = i2;
        } else {
            this.a = "by new key";
            i = i2;
        }
        if (i == 0 || i == j) {
            AppMethodBeat.o(64260);
            return false;
        }
        if (z2) {
            boolean z3;
            File a = TbsDownloader.a(i);
            if (a != null && a.exists()) {
                File file = new File(k.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                try {
                    if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                        k.b(a, file);
                        z3 = true;
                        if (h()) {
                            i();
                            if (!a.a(this.g, a, 0, i)) {
                                k.b(a);
                            }
                        } else if (b(i)) {
                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                            b(false);
                            if (z3) {
                                a(100, "use local backup apk in startDownload" + this.a, true);
                                if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                                    TbsLogReport.getInstance(this.g).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
                                } else {
                                    TbsLogReport.getInstance(this.g).eventReport(EventType.TYPE_DOWNLOAD, this.v);
                                }
                                this.v.resetArgs();
                            }
                            AppMethodBeat.o(64260);
                            return true;
                        }
                    }
                } catch (Exception e) {
                }
            }
            z3 = false;
            if (h()) {
            }
        }
        if (c(false, z2)) {
            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
            b(false);
            AppMethodBeat.o(64260);
            return true;
        }
        if (!(c(true) || c(true))) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader] delete file failed!");
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-301);
        }
        AppMethodBeat.o(64260);
        return false;
    }

    public int b() {
        AppMethodBeat.i(64281);
        File a = a(this.g);
        if (a == null) {
            AppMethodBeat.o(64281);
            return 0;
        }
        int a2 = a.a(this.g, new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
        AppMethodBeat.o(64281);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x01e1 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0883  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0852 A:{Catch:{ all -> 0x0bb4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0883  */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x01e1 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0852 A:{Catch:{ all -> 0x0bb4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x01e1 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0883  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0623  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(boolean z, boolean z2) {
        GZIPInputStream gZIPInputStream;
        Throwable e;
        long j;
        FileOutputStream fileOutputStream;
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3;
        AppMethodBeat.i(64262);
        if (!an.a().c(this.g) || z) {
            int i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
            boolean z3 = i == 1 || i == 2 || i == 4;
            if (z2 || !a(z, z3)) {
                this.C = z;
                this.h = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsConfigKey.KEY_TBSDOWNLOADURL, null);
                String string = TbsDownloadConfig.getInstance(this.g).mPreferences.getString(TbsConfigKey.KEY_DOWNLOADURL_LIST, null);
                TbsLog.i(TbsDownloader.LOGTAG, "backupUrlStrings:".concat(String.valueOf(string)), true);
                this.b = null;
                this.c = 0;
                if (!(z || string == null || "".equals(string.trim()))) {
                    this.b = string.trim().split(";");
                }
                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mDownloadUrl=" + this.h + " backupUrlStrings=" + string + " mLocation=" + this.j + " mCanceled=" + this.r + " mHttpRequest=" + this.t);
                if (this.h == null && this.j == null) {
                    QbSdk.m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-302);
                    AppMethodBeat.o(64262);
                    return;
                } else if (this.t != null && !this.r) {
                    QbSdk.m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-303);
                    AppMethodBeat.o(64262);
                    return;
                } else if (z || !this.A.contains(Apn.getWifiSSID(this.g))) {
                    f();
                    TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...", true);
                    long downloadMaxflow = TbsDownloadConfig.getInstance(this.g).getDownloadMaxflow();
                    boolean z4 = false;
                    long j2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                    if (z) {
                        this.B = e;
                    } else {
                        this.B = d;
                    }
                    while (this.p <= this.B) {
                        if (this.q > 8) {
                            a(123, null, true);
                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-306);
                            break;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!z) {
                            if (currentTimeMillis - TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) > 86400000) {
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD");
                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, Long.valueOf(currentTimeMillis));
                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(0));
                                TbsDownloadConfig.getInstance(this.g).commit();
                                j2 = 0;
                            } else {
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] downloadFlow=".concat(String.valueOf(j2)));
                                if (j2 >= downloadMaxflow) {
                                    TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                    a(112, null, true);
                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-307);
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                }
                            }
                            if (!k.b(this.g)) {
                                TbsLog.i(TbsDownloader.LOGTAG, "DownloadBegin FreeSpace too small", true);
                                a(105, null, true);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            }
                        }
                        this.y = true;
                        String str = this.j != null ? this.j : this.h;
                        TbsLog.i(TbsDownloader.LOGTAG, "try url:" + str + ",mRetryTimes:" + this.p, true);
                        if (!str.equals(this.i)) {
                            this.v.setDownloadUrl(str);
                        }
                        this.i = str;
                        a(str);
                        long j3 = 0;
                        if (!this.o) {
                            j3 = k();
                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] range=".concat(String.valueOf(j3)));
                            if (this.l <= 0) {
                                TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...current".concat(String.valueOf(j3)), true);
                                this.t.setRequestProperty("Range", "bytes=" + j3 + "-");
                            } else {
                                TbsLog.i(TbsDownloader.LOGTAG, "#1 STEP 1/2 begin downloading...current/total=" + j3 + "/" + this.l, true);
                                this.t.setRequestProperty("Range", "bytes=" + j3 + "-" + this.l);
                            }
                        }
                        this.v.setDownloadCancel(j3 == 0 ? 0 : 1);
                        int apnType = Apn.getApnType(this.g);
                        String apnInfo = Apn.getApnInfo(this.g);
                        if (this.w == null && this.x == -1) {
                            this.w = apnInfo;
                            this.x = apnType;
                        } else if (!(apnType == this.x && apnInfo.equals(this.w))) {
                            this.v.setNetworkChange(0);
                            this.w = apnInfo;
                            this.x = apnType;
                        }
                        if (this.p > 0) {
                            this.t.addRequestProperty("Referer", this.h);
                        }
                        apnType = this.t.getResponseCode();
                        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] responseCode=".concat(String.valueOf(apnType)));
                        this.v.setHttpCode(apnType);
                        if (!(z || TbsDownloader.getOverSea(this.g) || ((Apn.getApnType(this.g) == 3 || QbSdk.getDownloadWithoutWifi()) && Apn.getApnType(this.g) != 0))) {
                            c();
                            if (QbSdk.m != null) {
                                QbSdk.m.onDownloadFinish(111);
                            }
                            TbsLog.i(TbsDownloader.LOGTAG, "Download is canceled due to NOT_WIFI error!", false);
                        }
                        if (this.r) {
                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                            if (!z) {
                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                TbsDownloadConfig.getInstance(this.g).commit();
                            }
                        } else if (apnType == 200 || apnType == 206) {
                            try {
                                this.l = ((long) this.t.getContentLength()) + j3;
                                TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mContentLength=" + this.l);
                                this.v.setPkgSize(this.l);
                                long j4 = TbsDownloadConfig.getInstance(this.g).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
                                if (j4 == 0 || this.l == j4) {
                                    Closeable obj32 = null;
                                    Closeable obj22 = null;
                                    Closeable obj4 = null;
                                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] begin readResponse");
                                    InputStream inputStream;
                                    try {
                                        inputStream = this.t.getInputStream();
                                        if (inputStream != null) {
                                            try {
                                                str = this.t.getContentEncoding();
                                                if (str == null || !str.contains("gzip")) {
                                                    if (str != null) {
                                                        if (str.contains("deflate")) {
                                                            InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                                                        }
                                                    }
                                                    InputStream gZIPInputStream2 = inputStream;
                                                } else {
                                                    gZIPInputStream2 = new GZIPInputStream(inputStream);
                                                }
                                            } catch (IOException e2) {
                                                e = e2;
                                                obj22 = inputStream;
                                                try {
                                                    if (!(e instanceof SocketTimeoutException)) {
                                                    }
                                                    this.m = 100000;
                                                    a(0);
                                                    a(103, a(e), false);
                                                    a(obj32);
                                                    a(obj4);
                                                    a(obj22);
                                                    if (z) {
                                                    }
                                                } catch (Throwable th2) {
                                                    e = th2;
                                                    Closeable closeable = obj4;
                                                    Closeable inputStream2 = obj22;
                                                    Closeable fileOutputStream2 = obj32;
                                                    j = j2;
                                                }
                                            } catch (Throwable th3) {
                                                e = th3;
                                                gZIPInputStream2 = null;
                                                fileOutputStream2 = null;
                                                j = j2;
                                                try {
                                                    a((Closeable) fileOutputStream2);
                                                    a((Closeable) gZIPInputStream2);
                                                    a((Closeable) inputStream2);
                                                    AppMethodBeat.o(64262);
                                                    throw e;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    if (z) {
                                                    }
                                                    AppMethodBeat.o(64262);
                                                    throw th;
                                                }
                                            }
                                            try {
                                                byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                                                FileOutputStream fileOutputStream3 = new FileOutputStream(new File(this.k, "x5.tbs.temp"), true);
                                                try {
                                                    long currentTimeMillis2 = System.currentTimeMillis();
                                                    Object obj5 = null;
                                                    j4 = j3;
                                                    long j5 = j3;
                                                    j = j2;
                                                    while (!this.r) {
                                                        try {
                                                            int read = gZIPInputStream2.read(bArr, 0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                                                            if (read > 0) {
                                                                fileOutputStream3.write(bArr, 0, read);
                                                                fileOutputStream3.flush();
                                                                if (!z) {
                                                                    j2 = ((long) read) + j;
                                                                    if (j2 >= downloadMaxflow) {
                                                                        TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                                                        a(112, "downloadFlow=" + j2 + " downloadMaxflow=" + downloadMaxflow, true);
                                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-307);
                                                                        break;
                                                                    } else if (!k.b(this.g)) {
                                                                        TbsLog.i(TbsDownloader.LOGTAG, "DownloadEnd FreeSpace too small ", true);
                                                                        a(105, "freespace=" + y.a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace(), true);
                                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                                        break;
                                                                    } else {
                                                                        j = j2;
                                                                    }
                                                                }
                                                                currentTimeMillis = a(currentTimeMillis, (long) read);
                                                                j3 = System.currentTimeMillis();
                                                                j4 += (long) read;
                                                                if (j3 - currentTimeMillis2 > 1000) {
                                                                    TbsLog.i(TbsDownloader.LOGTAG, "#2 STEP 1/2 begin downloading...current/total=" + j4 + "/" + this.l, true);
                                                                    if (QbSdk.m != null) {
                                                                        QbSdk.m.onDownloadProgress((int) ((((double) j4) / ((double) this.l)) * 100.0d));
                                                                    }
                                                                    if (z || j4 - j5 <= 1048576) {
                                                                        j2 = j5;
                                                                    } else if (TbsDownloader.getOverSea(this.g) || ((Apn.getApnType(this.g) == 3 || QbSdk.getDownloadWithoutWifi()) && Apn.getApnType(this.g) != 0)) {
                                                                        j2 = j4;
                                                                    } else {
                                                                        c();
                                                                        if (QbSdk.m != null) {
                                                                            QbSdk.m.onDownloadFinish(111);
                                                                        }
                                                                        TbsLog.i(TbsDownloader.LOGTAG, "Download is paused due to NOT_WIFI error!", false);
                                                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                                                                        j2 = j;
                                                                    }
                                                                } else {
                                                                    j3 = currentTimeMillis2;
                                                                    j2 = j5;
                                                                }
                                                                currentTimeMillis2 = j3;
                                                                j5 = j2;
                                                            } else if (this.b == null || c(true, z3)) {
                                                                this.s = true;
                                                                if (this.b != null) {
                                                                    z4 = true;
                                                                }
                                                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-311);
                                                                j2 = j;
                                                            } else if (z || !a(false)) {
                                                                this.s = true;
                                                                z4 = false;
                                                                j2 = j;
                                                            } else {
                                                                obj5 = 1;
                                                                j2 = j;
                                                            }
                                                        } catch (IOException e3) {
                                                            e = e3;
                                                            obj4 = gZIPInputStream2;
                                                            obj22 = inputStream2;
                                                            obj32 = fileOutputStream3;
                                                            j2 = j;
                                                            if (e instanceof SocketTimeoutException) {
                                                            }
                                                            this.m = 100000;
                                                            a(0);
                                                            a(103, a(e), false);
                                                            a(obj32);
                                                            a(obj4);
                                                            a(obj22);
                                                            if (z) {
                                                            }
                                                        } catch (Throwable th42) {
                                                            e = th42;
                                                            a((Closeable) fileOutputStream2);
                                                            a((Closeable) gZIPInputStream2);
                                                            a((Closeable) inputStream2);
                                                            AppMethodBeat.o(64262);
                                                            throw e;
                                                        }
                                                    }
                                                    TbsLog.i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...Canceled!", true);
                                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                                    j2 = j;
                                                    if (obj5 != null) {
                                                        a((Closeable) fileOutputStream3);
                                                        a((Closeable) gZIPInputStream2);
                                                        a((Closeable) inputStream2);
                                                        if (!z) {
                                                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                                            TbsDownloadConfig.getInstance(this.g).commit();
                                                        }
                                                    }
                                                } catch (IOException e4) {
                                                    e = e4;
                                                    obj4 = gZIPInputStream2;
                                                    obj22 = inputStream2;
                                                    obj32 = fileOutputStream3;
                                                    if (e instanceof SocketTimeoutException) {
                                                    }
                                                    this.m = 100000;
                                                    a(0);
                                                    a(103, a(e), false);
                                                    a(obj32);
                                                    a(obj4);
                                                    a(obj22);
                                                    if (z) {
                                                    }
                                                } catch (Throwable th5) {
                                                    e = th5;
                                                    j = j2;
                                                    a((Closeable) fileOutputStream2);
                                                    a((Closeable) gZIPInputStream2);
                                                    a((Closeable) inputStream2);
                                                    AppMethodBeat.o(64262);
                                                    throw e;
                                                }
                                            } catch (IOException e5) {
                                                e = e5;
                                                obj4 = gZIPInputStream2;
                                                obj22 = inputStream2;
                                                if ((e instanceof SocketTimeoutException) || (e instanceof SocketException)) {
                                                    this.m = 100000;
                                                    a(0);
                                                    a(103, a(e), false);
                                                    a(obj32);
                                                    a(obj4);
                                                    a(obj22);
                                                    if (z) {
                                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                                        TbsDownloadConfig.getInstance(this.g).commit();
                                                    }
                                                } else {
                                                    if (!z) {
                                                        if (!k.b(this.g)) {
                                                            a(105, "freespace=" + y.a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.g).getDownloadMinFreeSpace(), true);
                                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-308);
                                                            a(obj32);
                                                            a(obj4);
                                                            a(obj22);
                                                            if (!z) {
                                                                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                                                TbsDownloadConfig.getInstance(this.g).commit();
                                                            }
                                                            if (this.r) {
                                                            }
                                                            g();
                                                            AppMethodBeat.o(64262);
                                                            return;
                                                        }
                                                    }
                                                    a(0);
                                                    if (j()) {
                                                        a(104, a(e), false);
                                                    } else {
                                                        a(106, a(e), false);
                                                    }
                                                    a(obj32);
                                                    a(obj4);
                                                    a(obj22);
                                                    if (!z) {
                                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                                        TbsDownloadConfig.getInstance(this.g).commit();
                                                    }
                                                }
                                            } catch (Throwable th6) {
                                                e = th6;
                                                fileOutputStream2 = null;
                                                j = j2;
                                                a((Closeable) fileOutputStream2);
                                                a((Closeable) gZIPInputStream2);
                                                a((Closeable) inputStream2);
                                                AppMethodBeat.o(64262);
                                                throw e;
                                            }
                                        }
                                        gZIPInputStream2 = null;
                                        fileOutputStream2 = null;
                                        a((Closeable) fileOutputStream2);
                                        a((Closeable) gZIPInputStream2);
                                        a((Closeable) inputStream2);
                                        if (!this.s) {
                                            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-319);
                                        }
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                            TbsDownloadConfig.getInstance(this.g).commit();
                                        }
                                    } catch (IOException e6) {
                                        e = e6;
                                    } catch (Throwable th7) {
                                        e = th7;
                                        gZIPInputStream2 = null;
                                        inputStream2 = null;
                                        fileOutputStream2 = null;
                                        j = j2;
                                        a((Closeable) fileOutputStream2);
                                        a((Closeable) gZIPInputStream2);
                                        a((Closeable) inputStream2);
                                        AppMethodBeat.o(64262);
                                        throw e;
                                    }
                                }
                                TbsLog.i(TbsDownloader.LOGTAG, "DownloadBegin tbsApkFileSize=" + j4 + "  but contentLength=" + this.l, true);
                                if (z || !(n() || (QbSdk.getDownloadWithoutWifi() && Apn.isNetworkAvailable(this.g)))) {
                                    a(101, "WifiNetworkUnAvailable", true);
                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                                } else if (this.b == null || !a(false)) {
                                    a(113, "tbsApkFileSize=" + j4 + "  but contentLength=" + this.l, true);
                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-310);
                                } else if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            } catch (Throwable th8) {
                                e = th8;
                            }
                        } else if (apnType < 300 || apnType > 307) {
                            a(102, String.valueOf(apnType), false);
                            if (apnType != 416) {
                                if (apnType == 403 || apnType == 406) {
                                    if (this.l == -1) {
                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-314);
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                            TbsDownloadConfig.getInstance(this.g).commit();
                                        }
                                    }
                                }
                                if (apnType == 202) {
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else if (this.p < this.B && apnType == ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS) {
                                    a(Long.parseLong(this.t.getHeaderField("Retry-After")));
                                    if (this.r) {
                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                            TbsDownloadConfig.getInstance(this.g).commit();
                                        }
                                    } else if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else if (this.p < this.B && (apnType == 408 || apnType == 504 || apnType == ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE || apnType == 408)) {
                                    a(0);
                                    if (this.r) {
                                        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-309);
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                            TbsDownloadConfig.getInstance(this.g).commit();
                                        }
                                    } else if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else if (k() > 0 || this.o || apnType == 410) {
                                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-315);
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                } else {
                                    this.o = true;
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.g).commit();
                                    }
                                }
                            } else if (c(true, z3)) {
                                z4 = true;
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            } else {
                                c(false);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-313);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            }
                        } else {
                            str = this.t.getHeaderField("Location");
                            if (TextUtils.isEmpty(str)) {
                                a(124, null, true);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-312);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            } else {
                                this.j = str;
                                this.q++;
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.g).commit();
                                }
                            }
                        }
                    }
                    if (this.r) {
                        if (this.s) {
                            if (this.b == null && !r6) {
                                z4 = c(true, z3);
                            }
                            this.v.setUnpkgFlag(z4 ? 1 : 0);
                            if (z3) {
                                this.v.setPatchUpdateFlag(0);
                            } else {
                                this.v.setPatchUpdateFlag(z4 ? 1 : 2);
                            }
                            if (z4) {
                                b(true);
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-317);
                                a(100, "success", true);
                            } else {
                                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-318);
                                c(false);
                            }
                        }
                        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.g);
                        if (z4) {
                            instance.a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) + 1));
                        } else {
                            int i2 = instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) + 1;
                            instance.a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(i2));
                            if (i2 == instance.getDownloadFailedMaxRetrytimes()) {
                                this.v.setDownloadCancel(2);
                            }
                        }
                        instance.commit();
                        this.v.setDownFinalFlag(z4 ? 1 : 0);
                    }
                    g();
                    AppMethodBeat.o(64262);
                    return;
                } else {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] WIFI Unavailable");
                    QbSdk.m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-304);
                    AppMethodBeat.o(64262);
                    return;
                }
            }
            TbsDownloader.a = false;
            AppMethodBeat.o(64262);
            return;
        }
        TbsDownloader.a = false;
        TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-322);
        AppMethodBeat.o(64262);
    }

    public void c() {
        AppMethodBeat.i(64282);
        this.r = true;
        if (TbsShareManager.isThirdPartyApp(this.g)) {
            TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.g).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                TbsLogReport.getInstance(this.g).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
                AppMethodBeat.o(64282);
                return;
            }
            TbsLogReport.getInstance(this.g).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
        }
        AppMethodBeat.o(64282);
    }

    public void d() {
        AppMethodBeat.i(64283);
        c();
        c(false);
        c(true);
        AppMethodBeat.o(64283);
    }

    public boolean e() {
        AppMethodBeat.i(64289);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
        boolean z = this.C;
        AppMethodBeat.o(64289);
        return z;
    }
}
