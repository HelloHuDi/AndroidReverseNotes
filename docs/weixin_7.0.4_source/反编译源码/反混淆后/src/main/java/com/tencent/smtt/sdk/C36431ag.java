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
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C24272a;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.C36443b;
import com.tencent.smtt.utils.C5822y;
import com.tencent.smtt.utils.TbsLog;
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

/* renamed from: com.tencent.smtt.sdk.ag */
class C36431ag {
    /* renamed from: d */
    private static int f15135d = 5;
    /* renamed from: e */
    private static int f15136e = 1;
    /* renamed from: f */
    private static final String[] f15137f = new String[]{"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    /* renamed from: A */
    private Set<String> f15138A;
    /* renamed from: B */
    private int f15139B = f15135d;
    /* renamed from: C */
    private boolean f15140C;
    /* renamed from: a */
    String f15141a;
    /* renamed from: b */
    String[] f15142b = null;
    /* renamed from: c */
    int f15143c = 0;
    /* renamed from: g */
    private Context f15144g;
    /* renamed from: h */
    private String f15145h;
    /* renamed from: i */
    private String f15146i;
    /* renamed from: j */
    private String f15147j;
    /* renamed from: k */
    private File f15148k;
    /* renamed from: l */
    private long f15149l;
    /* renamed from: m */
    private int f15150m = 30000;
    /* renamed from: n */
    private int f15151n = C1625i.sHCENCODEVIDEOTIMEOUT;
    /* renamed from: o */
    private boolean f15152o;
    /* renamed from: p */
    private int f15153p;
    /* renamed from: q */
    private int f15154q;
    /* renamed from: r */
    private boolean f15155r;
    /* renamed from: s */
    private boolean f15156s;
    /* renamed from: t */
    private HttpURLConnection f15157t;
    /* renamed from: u */
    private String f15158u;
    /* renamed from: v */
    private TbsLogInfo f15159v;
    /* renamed from: w */
    private String f15160w;
    /* renamed from: x */
    private int f15161x;
    /* renamed from: y */
    private boolean f15162y;
    /* renamed from: z */
    private Handler f15163z;

    public C36431ag(Context context) {
        AppMethodBeat.m2504i(64256);
        this.f15144g = context.getApplicationContext();
        this.f15159v = TbsLogReport.getInstance(this.f15144g).tbsLogInfo();
        this.f15138A = new HashSet();
        this.f15158u = "tbs_downloading_" + this.f15144g.getPackageName();
        C5813an.m8800a();
        this.f15148k = C5813an.m8819t(this.f15144g);
        if (this.f15148k == null) {
            NullPointerException nullPointerException = new NullPointerException("TbsCorePrivateDir is null!");
            AppMethodBeat.m2505o(64256);
            throw nullPointerException;
        }
        m60069f();
        this.f15160w = null;
        this.f15161x = -1;
        AppMethodBeat.m2505o(64256);
    }

    /* renamed from: a */
    private long m60052a(long j, long j2) {
        AppMethodBeat.m2504i(64264);
        long currentTimeMillis = System.currentTimeMillis();
        this.f15159v.setDownConsumeTime(currentTimeMillis - j);
        this.f15159v.setDownloadSize(j2);
        AppMethodBeat.m2505o(64264);
        return currentTimeMillis;
    }

    @TargetApi(8)
    /* renamed from: a */
    static File m60053a(Context context) {
        AppMethodBeat.m2504i(64278);
        try {
            File file = VERSION.SDK_INT >= 8 ? new File(C30950k.m49545a(context, 4)) : null;
            if (!(file == null || file.exists() || file.isDirectory())) {
                file.mkdirs();
            }
            AppMethodBeat.m2505o(64278);
            return file;
        } catch (Exception e) {
            TbsLog.m80432e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            AppMethodBeat.m2505o(64278);
            return null;
        }
    }

    /* renamed from: a */
    private static File m60054a(Context context, int i) {
        AppMethodBeat.m2504i(64280);
        File file = new File(C30950k.m49545a(context, i));
        if (file.exists() && file.isDirectory()) {
            if (new File(file, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org").exists()) {
                AppMethodBeat.m2505o(64280);
                return file;
            }
            AppMethodBeat.m2505o(64280);
            return null;
        }
        AppMethodBeat.m2505o(64280);
        return null;
    }

    /* renamed from: a */
    private String m60055a(Throwable th) {
        AppMethodBeat.m2504i(64266);
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            stackTraceString = stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(64266);
            return stackTraceString;
        }
        AppMethodBeat.m2505o(64266);
        return stackTraceString;
    }

    /* renamed from: a */
    private String m60056a(URL url) {
        AppMethodBeat.m2504i(64277);
        String str = "";
        try {
            str = InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Error | Exception e) {
        }
        AppMethodBeat.m2505o(64277);
        return str;
    }

    /* renamed from: a */
    private void m60057a(int i, String str, boolean z) {
        AppMethodBeat.m2504i(64265);
        if (z || this.f15153p > this.f15139B) {
            this.f15159v.setErrorCode(i);
            this.f15159v.setFailDetail(str);
        }
        AppMethodBeat.m2505o(64265);
    }

    /* renamed from: a */
    private void m60058a(long j) {
        AppMethodBeat.m2504i(64269);
        this.f15153p++;
        if (j <= 0) {
            try {
                j = m60076m();
            } catch (Exception e) {
                AppMethodBeat.m2505o(64269);
                return;
            }
        }
        Thread.sleep(j);
        AppMethodBeat.m2505o(64269);
    }

    /* renamed from: a */
    private void m60059a(Closeable closeable) {
        AppMethodBeat.m2504i(64268);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.m2505o(64268);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(64268);
    }

    /* JADX WARNING: Missing block: B:7:0x0014, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(64285);
     */
    /* JADX WARNING: Missing block: B:62:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m60060a(File file, Context context) {
        AppMethodBeat.m2504i(64285);
        synchronized (C24272a.class) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        try {
                            File a = C36431ag.m60053a(context);
                            if (a != null) {
                                File file2;
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                    file2 = new File(a, "x5.tbs.decouple");
                                } else {
                                    file2 = new File(a, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                                }
                                file2.delete();
                                C30950k.m49566b(file, file2);
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1 && TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0) == C24272a.m37432a(context, file)) {
                                    file2 = new File(a, "x5.tbs.decouple");
                                    if (C24272a.m37432a(context, file) != C24272a.m37432a(context, file2)) {
                                        file2.delete();
                                        C30950k.m49566b(file, file2);
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
                                        TbsLog.m80432e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
                                    } else {
                                        file2.createNewFile();
                                    }
                                }
                            }
                        } catch (Exception e) {
                        }
                        AppMethodBeat.m2505o(64285);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(64285);
                }
            }
        }
    }

    /* renamed from: a */
    private void m60061a(String str) {
        AppMethodBeat.m2504i(64257);
        URL url = new URL(str);
        if (this.f15157t != null) {
            try {
                this.f15157t.disconnect();
            } catch (Throwable th) {
                TbsLog.m80432e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        this.f15157t = (HttpURLConnection) url.openConnection();
        this.f15157t.setRequestProperty("User-Agent", TbsDownloader.m37393a(this.f15144g));
        this.f15157t.setRequestProperty("Accept-Encoding", "identity");
        this.f15157t.setRequestMethod("GET");
        this.f15157t.setInstanceFollowRedirects(false);
        this.f15157t.setConnectTimeout(this.f15151n);
        this.f15157t.setReadTimeout(this.f15150m);
        AppMethodBeat.m2505o(64257);
    }

    @TargetApi(8)
    /* renamed from: b */
    static File m60063b(Context context) {
        AppMethodBeat.m2504i(64279);
        try {
            File a;
            if (VERSION.SDK_INT >= 8) {
                a = C36431ag.m60054a(context, 4);
                if (a == null) {
                    a = C36431ag.m60054a(context, 3);
                }
                if (a == null) {
                    a = C36431ag.m60054a(context, 2);
                }
                if (a == null) {
                    a = C36431ag.m60054a(context, 1);
                }
            } else {
                a = null;
            }
            AppMethodBeat.m2505o(64279);
            return a;
        } catch (Exception e) {
            TbsLog.m80432e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            AppMethodBeat.m2505o(64279);
            return null;
        }
    }

    /* renamed from: b */
    private void m60064b(boolean z) {
        AppMethodBeat.m2504i(64267);
        C5822y.m8883a(this.f15144g);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.f15144g);
        instance.f1368a.put(TbsConfigKey.KEY_FULL_PACKAGE, Boolean.FALSE);
        instance.f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
        instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-123));
        instance.commit();
        QbSdk.f16251m.onDownloadFinish(z ? 100 : 120);
        int i = instance.mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
        TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
        if (i == 3 || i > Downloads.MIN_WAIT_FOR_NETWORK) {
            File a = C36431ag.m60053a(this.f15144g);
            if (a != null) {
                File file = new File(a, TbsDownloader.getOverSea(this.f15144g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                int a2 = C24272a.m37432a(this.f15144g, file);
                File file2 = new File(this.f15148k, "x5.tbs");
                String absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
                int i2 = instance.mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", i);
                bundle.putInt("old_core_ver", a2);
                bundle.putInt("new_core_ver", i2);
                bundle.putString("old_apk_location", file.getAbsolutePath());
                bundle.putString("new_apk_location", absolutePath);
                bundle.putString("diff_file_location", absolutePath);
                C5813an.m8800a().mo12160b(this.f15144g, bundle);
                AppMethodBeat.m2505o(64267);
                return;
            }
            mo57535d();
            instance.f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
            instance.commit();
            AppMethodBeat.m2505o(64267);
            return;
        }
        C5813an.m8800a().mo12152a(this.f15144g, new File(this.f15148k, "x5.tbs").getAbsolutePath(), instance.mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
        C36431ag.m60060a(new File(this.f15148k, "x5.tbs"), this.f15144g);
        AppMethodBeat.m2505o(64267);
    }

    /* renamed from: b */
    private boolean m60065b(int i) {
        AppMethodBeat.m2504i(64259);
        try {
            File file = new File(this.f15148k, "x5.tbs");
            File a = C36431ag.m60053a(this.f15144g);
            if (a != null) {
                File file2 = new File(a, TbsDownloader.getOverSea(this.f15144g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                file.delete();
                C30950k.m49566b(file2, file);
                if (C24272a.m37435a(this.f15144g, file, 0, i)) {
                    AppMethodBeat.m2505o(64259);
                    return true;
                }
                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
                AppMethodBeat.m2505o(64259);
                return false;
            }
            AppMethodBeat.m2505o(64259);
            return false;
        } catch (Exception e) {
            TbsLog.m80432e(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e.getMessage());
            AppMethodBeat.m2505o(64259);
            return false;
        }
    }

    /* renamed from: c */
    public static void m60066c(Context context) {
        AppMethodBeat.m2504i(64286);
        try {
            C5813an.m8800a();
            File t = C5813an.m8819t(context);
            new File(t, "x5.tbs").delete();
            new File(t, "x5.tbs.temp").delete();
            t = C36431ag.m60053a(context);
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
            AppMethodBeat.m2505o(64286);
        } catch (Exception e) {
            AppMethodBeat.m2505o(64286);
        }
    }

    /* renamed from: c */
    private boolean m60067c(boolean z) {
        AppMethodBeat.m2504i(64272);
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=".concat(String.valueOf(z)));
        File file = z ? new File(this.f15148k, "x5.tbs") : new File(this.f15148k, "x5.tbs.temp");
        boolean delete = file.exists() ? file.delete() : true;
        AppMethodBeat.m2505o(64272);
        return delete;
    }

    /* renamed from: c */
    private boolean m60068c(boolean z, boolean z2) {
        long j = 0;
        AppMethodBeat.m2504i(64271);
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=".concat(String.valueOf(z)));
        File file = new File(this.f15148k, !z ? "x5.tbs" : "x5.tbs.temp");
        if (file.exists()) {
            String string = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getString(TbsConfigKey.KEY_TBSAPK_MD5, null);
            String a = C24272a.m37434a(file);
            if (string == null || !string.equals(a)) {
                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " md5 failed");
                if (z) {
                    this.f15159v.setCheckErrorDetail("fileMd5 not match");
                }
                AppMethodBeat.m2505o(64271);
                return false;
            }
            boolean renameTo;
            TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] md5(" + a + ") successful!");
            if (z) {
                long j2;
                long j3 = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
                if (!file.exists()) {
                    j2 = 0;
                } else if (j3 > 0) {
                    j2 = file.length();
                    if (j3 == j2) {
                        j = j2;
                    }
                }
                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " filelength failed");
                this.f15159v.setCheckErrorDetail("fileLength:" + j2 + ",contentLength:" + j3);
                AppMethodBeat.m2505o(64271);
                return false;
            }
            TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] length(" + j + ") successful!");
            int i = -1;
            if (z2 && !z) {
                i = C24272a.m37432a(this.f15144g, file);
                int i2 = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                if (i2 != i) {
                    TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " versionCode failed");
                    if (z) {
                        this.f15159v.setCheckErrorDetail("fileVersion:" + i + ",configVersion:" + i2);
                    }
                    AppMethodBeat.m2505o(64271);
                    return false;
                }
            }
            TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
            if (z2 && !z) {
                string = C36443b.m60180a(this.f15144g, false, file);
                if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(string)) {
                    TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " signature failed");
                    if (z) {
                        this.f15159v.setCheckErrorDetail("signature:" + (string == null ? BuildConfig.COMMAND : Integer.valueOf(string.length())));
                    }
                    AppMethodBeat.m2505o(64271);
                    return false;
                }
            }
            TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] signature successful!");
            if (z) {
                Throwable th;
                try {
                    renameTo = file.renameTo(new File(this.f15148k, "x5.tbs"));
                    th = null;
                } catch (Exception e) {
                    th = e;
                    renameTo = false;
                }
                if (!renameTo) {
                    m60057a(109, m60055a(th), true);
                    AppMethodBeat.m2505o(64271);
                    return false;
                }
            }
            renameTo = false;
            TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] rename(" + renameTo + ") successful!");
            AppMethodBeat.m2505o(64271);
            return true;
        }
        AppMethodBeat.m2505o(64271);
        return false;
    }

    /* renamed from: f */
    private void m60069f() {
        this.f15153p = 0;
        this.f15154q = 0;
        this.f15149l = -1;
        this.f15147j = null;
        this.f15152o = false;
        this.f15155r = false;
        this.f15156s = false;
        this.f15162y = false;
    }

    /* renamed from: g */
    private void m60070g() {
        AppMethodBeat.m2504i(64258);
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        if (this.f15157t != null) {
            if (!this.f15155r) {
                this.f15159v.setResolveIp(m60056a(this.f15157t.getURL()));
            }
            try {
                this.f15157t.disconnect();
            } catch (Throwable th) {
                TbsLog.m80432e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.f15157t = null;
        }
        int i = this.f15159v.f1370a;
        if (this.f15155r || !this.f15162y) {
            TbsDownloader.f4486a = false;
            AppMethodBeat.m2505o(64258);
            return;
        }
        this.f15159v.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.f15144g);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = Apn.getApnType(this.f15144g);
        this.f15159v.setApn(apnInfo);
        this.f15159v.setNetworkType(apnType);
        if (!(apnType == this.f15161x && apnInfo.equals(this.f15160w))) {
            this.f15159v.setNetworkChange(0);
        }
        if ((this.f15159v.f1370a == 0 || this.f15159v.f1370a == 107) && this.f15159v.getDownFinalFlag() == 0) {
            if (!Apn.isNetworkAvailable(this.f15144g)) {
                m60057a(101, null, true);
            } else if (!m60075l()) {
                m60057a(101, null, true);
            }
        }
        if (TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            TbsLogReport.getInstance(this.f15144g).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, this.f15159v);
        } else {
            TbsLogReport.getInstance(this.f15144g).eventReport(EventType.TYPE_DOWNLOAD, this.f15159v);
        }
        this.f15159v.resetArgs();
        if (i != 100) {
            QbSdk.f16251m.onDownloadFinish(i);
        }
        AppMethodBeat.m2505o(64258);
    }

    /* renamed from: h */
    private boolean m60071h() {
        AppMethodBeat.m2504i(64270);
        File file = new File(C30950k.m49545a(this.f15144g, 4), TbsDownloader.getOverSea(this.f15144g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        int i = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i == 0) {
            i = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        boolean a = C24272a.m37435a(this.f15144g, file, 0, i);
        AppMethodBeat.m2505o(64270);
        return a;
    }

    /* renamed from: i */
    private void m60072i() {
        AppMethodBeat.m2504i(64273);
        try {
            if (TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                AppMethodBeat.m2505o(64273);
                return;
            }
            File file = new File(C30950k.m49545a(this.f15144g, 4), TbsDownloader.getOverSea(this.f15144g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
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
            AppMethodBeat.m2505o(64273);
        } catch (Exception e) {
            AppMethodBeat.m2505o(64273);
        }
    }

    /* renamed from: j */
    private boolean m60073j() {
        AppMethodBeat.m2504i(64274);
        boolean z = false;
        if (new File(this.f15148k, "x5.tbs.temp").exists()) {
            z = true;
        }
        AppMethodBeat.m2505o(64274);
        return z;
    }

    /* renamed from: k */
    private long m60074k() {
        AppMethodBeat.m2504i(64275);
        long j = 0;
        File file = new File(this.f15148k, "x5.tbs.temp");
        if (file.exists()) {
            j = file.length();
        }
        AppMethodBeat.m2505o(64275);
        return j;
    }

    /* renamed from: l */
    private boolean m60075l() {
        Throwable th;
        boolean z = false;
        AppMethodBeat.m2504i(64276);
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
                            m60059a(inputStream);
                            m60059a(inputStreamReader);
                            m60059a(bufferedReader);
                            AppMethodBeat.m2505o(64276);
                            throw th;
                        }
                    } while (i < 5);
                    m60059a(inputStream);
                    m60059a(inputStreamReader);
                    m60059a(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    m60059a(inputStream);
                    m60059a(inputStreamReader);
                    m60059a(bufferedReader);
                    AppMethodBeat.m2505o(64276);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
                m60059a(inputStream);
                m60059a(inputStreamReader);
                m60059a(bufferedReader);
                AppMethodBeat.m2505o(64276);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
            m60059a(inputStream);
            m60059a(inputStreamReader);
            m60059a(bufferedReader);
            AppMethodBeat.m2505o(64276);
            throw th;
        }
        AppMethodBeat.m2505o(64276);
        return z;
    }

    /* renamed from: m */
    private long m60076m() {
        switch (this.f15153p) {
            case 1:
            case 2:
                return 20000 * ((long) this.f15153p);
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
    /* renamed from: n */
    private boolean m60077n() {
        CharSequence charSequence;
        Object charSequence2;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(64287);
        boolean z3 = Apn.getApnType(this.f15144g) == 3;
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=".concat(String.valueOf(z3)));
        if (z3) {
            String wifiSSID = Apn.getWifiSSID(this.f15144g);
            TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=".concat(String.valueOf(wifiSSID)));
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
                    TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=".concat(String.valueOf(responseCode)));
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
                    AppMethodBeat.m2505o(64287);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection != null) {
                }
                AppMethodBeat.m2505o(64287);
                throw th;
            }
        }
        if (!(z2 || TextUtils.isEmpty(charSequence2) || this.f15138A.contains(charSequence2))) {
            this.f15138A.add(charSequence2);
            m60078o();
            this.f15163z.sendMessageDelayed(this.f15163z.obtainMessage(150, charSequence2), 120000);
        }
        if (z2 && this.f15138A.contains(charSequence2)) {
            this.f15138A.remove(charSequence2);
        }
        AppMethodBeat.m2505o(64287);
        return z2;
    }

    /* renamed from: o */
    private void m60078o() {
        AppMethodBeat.m2504i(64288);
        if (this.f15163z == null) {
            this.f15163z = new C40972ah(this, C24267al.m37429a().getLooper());
        }
        AppMethodBeat.m2505o(64288);
    }

    /* renamed from: a */
    public void mo57528a(int i) {
        AppMethodBeat.m2504i(64284);
        try {
            File file = new File(this.f15148k, "x5.tbs");
            int a = C24272a.m37432a(this.f15144g, file);
            if (-1 == a || (i > 0 && i == a)) {
                file.delete();
            }
            AppMethodBeat.m2505o(64284);
        } catch (Exception e) {
            AppMethodBeat.m2505o(64284);
        }
    }

    /* renamed from: a */
    public boolean mo57529a() {
        AppMethodBeat.m2504i(64261);
        TbsLog.m80434i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            File file = new File(C30950k.m49545a(this.f15144g, 4), "x5.tbs.decouple");
            if (file.exists()) {
                TbsLog.m80434i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                File b = TbsDownloader.m37403b(TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                if (b != null && b.exists()) {
                    C30950k.m49566b(b, file);
                }
            }
            if (C24272a.m37435a(this.f15144g, file, 0, TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, -1))) {
                TbsLog.m80434i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
                boolean e = C5813an.m8800a().mo12169e(this.f15144g);
                AppMethodBeat.m2505o(64261);
                return e;
            }
            TbsLog.m80434i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup no backup file !!!");
            file = new File(C30950k.m49545a(this.f15144g, 4), "x5.tbs.decouple");
            if (file.exists()) {
                file.delete();
            }
            AppMethodBeat.m2505o(64261);
            return false;
        } catch (Exception e2) {
        }
    }

    /* renamed from: a */
    public boolean mo57530a(boolean z) {
        AppMethodBeat.m2504i(64263);
        if (z && !m60077n() && (!QbSdk.getDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.f15144g))) {
            AppMethodBeat.m2505o(64263);
            return false;
        } else if (this.f15142b == null || this.f15143c < 0 || this.f15143c >= this.f15142b.length) {
            AppMethodBeat.m2505o(64263);
            return false;
        } else {
            String[] strArr = this.f15142b;
            int i = this.f15143c;
            this.f15143c = i + 1;
            this.f15147j = strArr[i];
            this.f15153p = 0;
            this.f15154q = 0;
            this.f15149l = -1;
            this.f15152o = false;
            this.f15155r = false;
            this.f15156s = false;
            this.f15162y = false;
            AppMethodBeat.m2505o(64263);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean mo57531a(boolean z, boolean z2) {
        int i;
        AppMethodBeat.m2504i(64260);
        int i2 = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int j = C5813an.m8800a().mo12175j(this.f15144g);
        if (i2 == 0) {
            i2 = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            this.f15141a = "by default key";
            i = i2;
        } else {
            this.f15141a = "by new key";
            i = i2;
        }
        if (i == 0 || i == j) {
            AppMethodBeat.m2505o(64260);
            return false;
        }
        if (z2) {
            boolean z3;
            File a = TbsDownloader.m37392a(i);
            if (a != null && a.exists()) {
                File file = new File(C30950k.m49545a(this.f15144g, 4), TbsDownloader.getOverSea(this.f15144g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                try {
                    if (TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                        C30950k.m49566b(a, file);
                        z3 = true;
                        if (m60071h()) {
                            m60072i();
                            if (!C24272a.m37435a(this.f15144g, a, 0, i)) {
                                C30950k.m49564b(a);
                            }
                        } else if (m60065b(i)) {
                            TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
                            TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-214);
                            m60064b(false);
                            if (z3) {
                                m60057a(100, "use local backup apk in startDownload" + this.f15141a, true);
                                if (TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                                    TbsLogReport.getInstance(this.f15144g).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, this.f15159v);
                                } else {
                                    TbsLogReport.getInstance(this.f15144g).eventReport(EventType.TYPE_DOWNLOAD, this.f15159v);
                                }
                                this.f15159v.resetArgs();
                            }
                            AppMethodBeat.m2505o(64260);
                            return true;
                        }
                    }
                } catch (Exception e) {
                }
            }
            z3 = false;
            if (m60071h()) {
            }
        }
        if (m60068c(false, z2)) {
            TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
            TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-214);
            m60064b(false);
            AppMethodBeat.m2505o(64260);
            return true;
        }
        if (!(m60067c(true) || m60067c(true))) {
            TbsLog.m80432e(TbsDownloader.LOGTAG, "[TbsApkDownloader] delete file failed!");
            TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-301);
        }
        AppMethodBeat.m2505o(64260);
        return false;
    }

    /* renamed from: b */
    public int mo57532b() {
        AppMethodBeat.m2504i(64281);
        File a = C36431ag.m60053a(this.f15144g);
        if (a == null) {
            AppMethodBeat.m2505o(64281);
            return 0;
        }
        int a2 = C24272a.m37432a(this.f15144g, new File(a, TbsDownloader.getOverSea(this.f15144g) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
        AppMethodBeat.m2505o(64281);
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
    /* renamed from: b */
    public void mo57533b(boolean z, boolean z2) {
        GZIPInputStream gZIPInputStream;
        Throwable e;
        long j;
        FileOutputStream fileOutputStream;
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3;
        AppMethodBeat.m2504i(64262);
        if (!C5813an.m8800a().mo12165c(this.f15144g) || z) {
            int i = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
            boolean z3 = i == 1 || i == 2 || i == 4;
            if (z2 || !mo57531a(z, z3)) {
                this.f15140C = z;
                this.f15145h = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getString(TbsConfigKey.KEY_TBSDOWNLOADURL, null);
                String string = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getString(TbsConfigKey.KEY_DOWNLOADURL_LIST, null);
                TbsLog.m80435i(TbsDownloader.LOGTAG, "backupUrlStrings:".concat(String.valueOf(string)), true);
                this.f15142b = null;
                this.f15143c = 0;
                if (!(z || string == null || "".equals(string.trim()))) {
                    this.f15142b = string.trim().split(";");
                }
                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mDownloadUrl=" + this.f15145h + " backupUrlStrings=" + string + " mLocation=" + this.f15147j + " mCanceled=" + this.f15155r + " mHttpRequest=" + this.f15157t);
                if (this.f15145h == null && this.f15147j == null) {
                    QbSdk.f16251m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-302);
                    AppMethodBeat.m2505o(64262);
                    return;
                } else if (this.f15157t != null && !this.f15155r) {
                    QbSdk.f16251m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-303);
                    AppMethodBeat.m2505o(64262);
                    return;
                } else if (z || !this.f15138A.contains(Apn.getWifiSSID(this.f15144g))) {
                    m60069f();
                    TbsLog.m80435i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...", true);
                    long downloadMaxflow = TbsDownloadConfig.getInstance(this.f15144g).getDownloadMaxflow();
                    boolean z4 = false;
                    long j2 = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                    if (z) {
                        this.f15139B = f15136e;
                    } else {
                        this.f15139B = f15135d;
                    }
                    while (this.f15153p <= this.f15139B) {
                        if (this.f15154q > 8) {
                            m60057a(123, null, true);
                            TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-306);
                            break;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (!z) {
                            if (currentTimeMillis - TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) > 86400000) {
                                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD");
                                TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, Long.valueOf(currentTimeMillis));
                                TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(0));
                                TbsDownloadConfig.getInstance(this.f15144g).commit();
                                j2 = 0;
                            } else {
                                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] downloadFlow=".concat(String.valueOf(j2)));
                                if (j2 >= downloadMaxflow) {
                                    TbsLog.m80435i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                    m60057a(112, null, true);
                                    TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-307);
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.f15144g).commit();
                                    }
                                }
                            }
                            if (!C30950k.m49565b(this.f15144g)) {
                                TbsLog.m80435i(TbsDownloader.LOGTAG, "DownloadBegin FreeSpace too small", true);
                                m60057a(105, null, true);
                                TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-308);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.f15144g).commit();
                                }
                            }
                        }
                        this.f15162y = true;
                        String str = this.f15147j != null ? this.f15147j : this.f15145h;
                        TbsLog.m80435i(TbsDownloader.LOGTAG, "try url:" + str + ",mRetryTimes:" + this.f15153p, true);
                        if (!str.equals(this.f15146i)) {
                            this.f15159v.setDownloadUrl(str);
                        }
                        this.f15146i = str;
                        m60061a(str);
                        long j3 = 0;
                        if (!this.f15152o) {
                            j3 = m60074k();
                            TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] range=".concat(String.valueOf(j3)));
                            if (this.f15149l <= 0) {
                                TbsLog.m80435i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...current".concat(String.valueOf(j3)), true);
                                this.f15157t.setRequestProperty("Range", "bytes=" + j3 + "-");
                            } else {
                                TbsLog.m80435i(TbsDownloader.LOGTAG, "#1 STEP 1/2 begin downloading...current/total=" + j3 + "/" + this.f15149l, true);
                                this.f15157t.setRequestProperty("Range", "bytes=" + j3 + "-" + this.f15149l);
                            }
                        }
                        this.f15159v.setDownloadCancel(j3 == 0 ? 0 : 1);
                        int apnType = Apn.getApnType(this.f15144g);
                        String apnInfo = Apn.getApnInfo(this.f15144g);
                        if (this.f15160w == null && this.f15161x == -1) {
                            this.f15160w = apnInfo;
                            this.f15161x = apnType;
                        } else if (!(apnType == this.f15161x && apnInfo.equals(this.f15160w))) {
                            this.f15159v.setNetworkChange(0);
                            this.f15160w = apnInfo;
                            this.f15161x = apnType;
                        }
                        if (this.f15153p > 0) {
                            this.f15157t.addRequestProperty("Referer", this.f15145h);
                        }
                        apnType = this.f15157t.getResponseCode();
                        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] responseCode=".concat(String.valueOf(apnType)));
                        this.f15159v.setHttpCode(apnType);
                        if (!(z || TbsDownloader.getOverSea(this.f15144g) || ((Apn.getApnType(this.f15144g) == 3 || QbSdk.getDownloadWithoutWifi()) && Apn.getApnType(this.f15144g) != 0))) {
                            mo57534c();
                            if (QbSdk.f16251m != null) {
                                QbSdk.f16251m.onDownloadFinish(111);
                            }
                            TbsLog.m80435i(TbsDownloader.LOGTAG, "Download is canceled due to NOT_WIFI error!", false);
                        }
                        if (this.f15155r) {
                            TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-309);
                            if (!z) {
                                TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                TbsDownloadConfig.getInstance(this.f15144g).commit();
                            }
                        } else if (apnType == 200 || apnType == 206) {
                            try {
                                this.f15149l = ((long) this.f15157t.getContentLength()) + j3;
                                TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] mContentLength=" + this.f15149l);
                                this.f15159v.setPkgSize(this.f15149l);
                                long j4 = TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
                                if (j4 == 0 || this.f15149l == j4) {
                                    Closeable obj32 = null;
                                    Closeable obj22 = null;
                                    Closeable obj4 = null;
                                    TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] begin readResponse");
                                    InputStream inputStream;
                                    try {
                                        inputStream = this.f15157t.getInputStream();
                                        if (inputStream != null) {
                                            try {
                                                str = this.f15157t.getContentEncoding();
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
                                                    this.f15150m = 100000;
                                                    m60058a(0);
                                                    m60057a(103, m60055a(e), false);
                                                    m60059a(obj32);
                                                    m60059a(obj4);
                                                    m60059a(obj22);
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
                                                    m60059a((Closeable) fileOutputStream2);
                                                    m60059a((Closeable) gZIPInputStream2);
                                                    m60059a((Closeable) inputStream2);
                                                    AppMethodBeat.m2505o(64262);
                                                    throw e;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    if (z) {
                                                    }
                                                    AppMethodBeat.m2505o(64262);
                                                    throw th;
                                                }
                                            }
                                            try {
                                                byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
                                                FileOutputStream fileOutputStream3 = new FileOutputStream(new File(this.f15148k, "x5.tbs.temp"), true);
                                                try {
                                                    long currentTimeMillis2 = System.currentTimeMillis();
                                                    Object obj5 = null;
                                                    j4 = j3;
                                                    long j5 = j3;
                                                    j = j2;
                                                    while (!this.f15155r) {
                                                        try {
                                                            int read = gZIPInputStream2.read(bArr, 0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
                                                            if (read > 0) {
                                                                fileOutputStream3.write(bArr, 0, read);
                                                                fileOutputStream3.flush();
                                                                if (!z) {
                                                                    j2 = ((long) read) + j;
                                                                    if (j2 >= downloadMaxflow) {
                                                                        TbsLog.m80435i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...failed because you exceeded max flow!", true);
                                                                        m60057a(112, "downloadFlow=" + j2 + " downloadMaxflow=" + downloadMaxflow, true);
                                                                        TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-307);
                                                                        break;
                                                                    } else if (!C30950k.m49565b(this.f15144g)) {
                                                                        TbsLog.m80435i(TbsDownloader.LOGTAG, "DownloadEnd FreeSpace too small ", true);
                                                                        m60057a(105, "freespace=" + C5822y.m8882a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.f15144g).getDownloadMinFreeSpace(), true);
                                                                        TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-308);
                                                                        break;
                                                                    } else {
                                                                        j = j2;
                                                                    }
                                                                }
                                                                currentTimeMillis = m60052a(currentTimeMillis, (long) read);
                                                                j3 = System.currentTimeMillis();
                                                                j4 += (long) read;
                                                                if (j3 - currentTimeMillis2 > 1000) {
                                                                    TbsLog.m80435i(TbsDownloader.LOGTAG, "#2 STEP 1/2 begin downloading...current/total=" + j4 + "/" + this.f15149l, true);
                                                                    if (QbSdk.f16251m != null) {
                                                                        QbSdk.f16251m.onDownloadProgress((int) ((((double) j4) / ((double) this.f15149l)) * 100.0d));
                                                                    }
                                                                    if (z || j4 - j5 <= 1048576) {
                                                                        j2 = j5;
                                                                    } else if (TbsDownloader.getOverSea(this.f15144g) || ((Apn.getApnType(this.f15144g) == 3 || QbSdk.getDownloadWithoutWifi()) && Apn.getApnType(this.f15144g) != 0)) {
                                                                        j2 = j4;
                                                                    } else {
                                                                        mo57534c();
                                                                        if (QbSdk.f16251m != null) {
                                                                            QbSdk.f16251m.onDownloadFinish(111);
                                                                        }
                                                                        TbsLog.m80435i(TbsDownloader.LOGTAG, "Download is paused due to NOT_WIFI error!", false);
                                                                        TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-304);
                                                                        j2 = j;
                                                                    }
                                                                } else {
                                                                    j3 = currentTimeMillis2;
                                                                    j2 = j5;
                                                                }
                                                                currentTimeMillis2 = j3;
                                                                j5 = j2;
                                                            } else if (this.f15142b == null || m60068c(true, z3)) {
                                                                this.f15156s = true;
                                                                if (this.f15142b != null) {
                                                                    z4 = true;
                                                                }
                                                                TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-311);
                                                                j2 = j;
                                                            } else if (z || !mo57530a(false)) {
                                                                this.f15156s = true;
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
                                                            this.f15150m = 100000;
                                                            m60058a(0);
                                                            m60057a(103, m60055a(e), false);
                                                            m60059a(obj32);
                                                            m60059a(obj4);
                                                            m60059a(obj22);
                                                            if (z) {
                                                            }
                                                        } catch (Throwable th42) {
                                                            e = th42;
                                                            m60059a((Closeable) fileOutputStream2);
                                                            m60059a((Closeable) gZIPInputStream2);
                                                            m60059a((Closeable) inputStream2);
                                                            AppMethodBeat.m2505o(64262);
                                                            throw e;
                                                        }
                                                    }
                                                    TbsLog.m80435i(TbsDownloader.LOGTAG, "STEP 1/2 begin downloading...Canceled!", true);
                                                    TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-309);
                                                    j2 = j;
                                                    if (obj5 != null) {
                                                        m60059a((Closeable) fileOutputStream3);
                                                        m60059a((Closeable) gZIPInputStream2);
                                                        m60059a((Closeable) inputStream2);
                                                        if (!z) {
                                                            TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                                            TbsDownloadConfig.getInstance(this.f15144g).commit();
                                                        }
                                                    }
                                                } catch (IOException e4) {
                                                    e = e4;
                                                    obj4 = gZIPInputStream2;
                                                    obj22 = inputStream2;
                                                    obj32 = fileOutputStream3;
                                                    if (e instanceof SocketTimeoutException) {
                                                    }
                                                    this.f15150m = 100000;
                                                    m60058a(0);
                                                    m60057a(103, m60055a(e), false);
                                                    m60059a(obj32);
                                                    m60059a(obj4);
                                                    m60059a(obj22);
                                                    if (z) {
                                                    }
                                                } catch (Throwable th5) {
                                                    e = th5;
                                                    j = j2;
                                                    m60059a((Closeable) fileOutputStream2);
                                                    m60059a((Closeable) gZIPInputStream2);
                                                    m60059a((Closeable) inputStream2);
                                                    AppMethodBeat.m2505o(64262);
                                                    throw e;
                                                }
                                            } catch (IOException e5) {
                                                e = e5;
                                                obj4 = gZIPInputStream2;
                                                obj22 = inputStream2;
                                                if ((e instanceof SocketTimeoutException) || (e instanceof SocketException)) {
                                                    this.f15150m = 100000;
                                                    m60058a(0);
                                                    m60057a(103, m60055a(e), false);
                                                    m60059a(obj32);
                                                    m60059a(obj4);
                                                    m60059a(obj22);
                                                    if (z) {
                                                        TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                                        TbsDownloadConfig.getInstance(this.f15144g).commit();
                                                    }
                                                } else {
                                                    if (!z) {
                                                        if (!C30950k.m49565b(this.f15144g)) {
                                                            m60057a(105, "freespace=" + C5822y.m8882a() + ",and minFreeSpace=" + TbsDownloadConfig.getInstance(this.f15144g).getDownloadMinFreeSpace(), true);
                                                            TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-308);
                                                            m60059a(obj32);
                                                            m60059a(obj4);
                                                            m60059a(obj22);
                                                            if (!z) {
                                                                TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                                                TbsDownloadConfig.getInstance(this.f15144g).commit();
                                                            }
                                                            if (this.f15155r) {
                                                            }
                                                            m60070g();
                                                            AppMethodBeat.m2505o(64262);
                                                            return;
                                                        }
                                                    }
                                                    m60058a(0);
                                                    if (m60073j()) {
                                                        m60057a(104, m60055a(e), false);
                                                    } else {
                                                        m60057a(106, m60055a(e), false);
                                                    }
                                                    m60059a(obj32);
                                                    m60059a(obj4);
                                                    m60059a(obj22);
                                                    if (!z) {
                                                        TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                                        TbsDownloadConfig.getInstance(this.f15144g).commit();
                                                    }
                                                }
                                            } catch (Throwable th6) {
                                                e = th6;
                                                fileOutputStream2 = null;
                                                j = j2;
                                                m60059a((Closeable) fileOutputStream2);
                                                m60059a((Closeable) gZIPInputStream2);
                                                m60059a((Closeable) inputStream2);
                                                AppMethodBeat.m2505o(64262);
                                                throw e;
                                            }
                                        }
                                        gZIPInputStream2 = null;
                                        fileOutputStream2 = null;
                                        m60059a((Closeable) fileOutputStream2);
                                        m60059a((Closeable) gZIPInputStream2);
                                        m60059a((Closeable) inputStream2);
                                        if (!this.f15156s) {
                                            TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-319);
                                        }
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                            TbsDownloadConfig.getInstance(this.f15144g).commit();
                                        }
                                    } catch (IOException e6) {
                                        e = e6;
                                    } catch (Throwable th7) {
                                        e = th7;
                                        gZIPInputStream2 = null;
                                        inputStream2 = null;
                                        fileOutputStream2 = null;
                                        j = j2;
                                        m60059a((Closeable) fileOutputStream2);
                                        m60059a((Closeable) gZIPInputStream2);
                                        m60059a((Closeable) inputStream2);
                                        AppMethodBeat.m2505o(64262);
                                        throw e;
                                    }
                                }
                                TbsLog.m80435i(TbsDownloader.LOGTAG, "DownloadBegin tbsApkFileSize=" + j4 + "  but contentLength=" + this.f15149l, true);
                                if (z || !(m60077n() || (QbSdk.getDownloadWithoutWifi() && Apn.isNetworkAvailable(this.f15144g)))) {
                                    m60057a(101, "WifiNetworkUnAvailable", true);
                                    TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-304);
                                } else if (this.f15142b == null || !mo57530a(false)) {
                                    m60057a(113, "tbsApkFileSize=" + j4 + "  but contentLength=" + this.f15149l, true);
                                    TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-310);
                                } else if (!z) {
                                    TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.f15144g).commit();
                                }
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.f15144g).commit();
                                }
                            } catch (Throwable th8) {
                                e = th8;
                            }
                        } else if (apnType < 300 || apnType > 307) {
                            m60057a(102, String.valueOf(apnType), false);
                            if (apnType != 416) {
                                if (apnType == 403 || apnType == 406) {
                                    if (this.f15149l == -1) {
                                        TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-314);
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                            TbsDownloadConfig.getInstance(this.f15144g).commit();
                                        }
                                    }
                                }
                                if (apnType == 202) {
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.f15144g).commit();
                                    }
                                } else if (this.f15153p < this.f15139B && apnType == ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS) {
                                    m60058a(Long.parseLong(this.f15157t.getHeaderField("Retry-After")));
                                    if (this.f15155r) {
                                        TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-309);
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                            TbsDownloadConfig.getInstance(this.f15144g).commit();
                                        }
                                    } else if (!z) {
                                        TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.f15144g).commit();
                                    }
                                } else if (this.f15153p < this.f15139B && (apnType == 408 || apnType == 504 || apnType == ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE || apnType == 408)) {
                                    m60058a(0);
                                    if (this.f15155r) {
                                        TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-309);
                                        if (!z) {
                                            TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                            TbsDownloadConfig.getInstance(this.f15144g).commit();
                                        }
                                    } else if (!z) {
                                        TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.f15144g).commit();
                                    }
                                } else if (m60074k() > 0 || this.f15152o || apnType == 410) {
                                    TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-315);
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.f15144g).commit();
                                    }
                                } else {
                                    this.f15152o = true;
                                    if (!z) {
                                        TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                        TbsDownloadConfig.getInstance(this.f15144g).commit();
                                    }
                                }
                            } else if (m60068c(true, z3)) {
                                z4 = true;
                                TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-214);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.f15144g).commit();
                                }
                            } else {
                                m60067c(false);
                                TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-313);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.f15144g).commit();
                                }
                            }
                        } else {
                            str = this.f15157t.getHeaderField("Location");
                            if (TextUtils.isEmpty(str)) {
                                m60057a(124, null, true);
                                TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-312);
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.f15144g).commit();
                                }
                            } else {
                                this.f15147j = str;
                                this.f15154q++;
                                if (!z) {
                                    TbsDownloadConfig.getInstance(this.f15144g).f1368a.put(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, Long.valueOf(j2));
                                    TbsDownloadConfig.getInstance(this.f15144g).commit();
                                }
                            }
                        }
                    }
                    if (this.f15155r) {
                        if (this.f15156s) {
                            if (this.f15142b == null && !r6) {
                                z4 = m60068c(true, z3);
                            }
                            this.f15159v.setUnpkgFlag(z4 ? 1 : 0);
                            if (z3) {
                                this.f15159v.setPatchUpdateFlag(0);
                            } else {
                                this.f15159v.setPatchUpdateFlag(z4 ? 1 : 2);
                            }
                            if (z4) {
                                m60064b(true);
                                TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-317);
                                m60057a(100, "success", true);
                            } else {
                                TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-318);
                                m60067c(false);
                            }
                        }
                        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.f15144g);
                        if (z4) {
                            instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) + 1));
                        } else {
                            int i2 = instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) + 1;
                            instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(i2));
                            if (i2 == instance.getDownloadFailedMaxRetrytimes()) {
                                this.f15159v.setDownloadCancel(2);
                            }
                        }
                        instance.commit();
                        this.f15159v.setDownFinalFlag(z4 ? 1 : 0);
                    }
                    m60070g();
                    AppMethodBeat.m2505o(64262);
                    return;
                } else {
                    TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.startDownload] WIFI Unavailable");
                    QbSdk.f16251m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-304);
                    AppMethodBeat.m2505o(64262);
                    return;
                }
            }
            TbsDownloader.f4486a = false;
            AppMethodBeat.m2505o(64262);
            return;
        }
        TbsDownloader.f4486a = false;
        TbsDownloadConfig.getInstance(this.f15144g).setDownloadInterruptCode(-322);
        AppMethodBeat.m2505o(64262);
    }

    /* renamed from: c */
    public void mo57534c() {
        AppMethodBeat.m2504i(64282);
        this.f15155r = true;
        if (TbsShareManager.isThirdPartyApp(this.f15144g)) {
            TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.f15144g).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            if (TbsDownloadConfig.getInstance(this.f15144g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                TbsLogReport.getInstance(this.f15144g).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
                AppMethodBeat.m2505o(64282);
                return;
            }
            TbsLogReport.getInstance(this.f15144g).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
        }
        AppMethodBeat.m2505o(64282);
    }

    /* renamed from: d */
    public void mo57535d() {
        AppMethodBeat.m2504i(64283);
        mo57534c();
        m60067c(false);
        m60067c(true);
        AppMethodBeat.m2505o(64283);
    }

    /* renamed from: e */
    public boolean mo57536e() {
        AppMethodBeat.m2504i(64289);
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.f15140C);
        boolean z = this.f15140C;
        AppMethodBeat.m2505o(64289);
        return z;
    }
}
