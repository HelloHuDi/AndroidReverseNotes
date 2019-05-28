package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.tencent.smtt.sdk.o */
class C5818o {
    /* renamed from: a */
    static boolean f1419a = false;
    /* renamed from: d */
    private static C5818o f1420d = null;
    /* renamed from: g */
    private static int f1421g = 0;
    /* renamed from: h */
    private static int f1422h = 0;
    /* renamed from: i */
    private static int f1423i = 3;
    /* renamed from: k */
    private static String f1424k = null;
    /* renamed from: b */
    private C30947bi f1425b = null;
    /* renamed from: c */
    private C30947bi f1426c = null;
    /* renamed from: e */
    private boolean f1427e = false;
    /* renamed from: f */
    private boolean f1428f = false;
    /* renamed from: j */
    private File f1429j = null;

    private C5818o() {
    }

    /* renamed from: a */
    public static C5818o m8863a(boolean z) {
        AppMethodBeat.m2504i(64072);
        if (f1420d == null && z) {
            synchronized (C5818o.class) {
                try {
                    if (f1420d == null) {
                        f1420d = new C5818o();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(64072);
                    }
                }
            }
        }
        C5818o c5818o = f1420d;
        AppMethodBeat.m2505o(64072);
        return c5818o;
    }

    /* renamed from: a */
    static void m8864a(int i) {
        f1421g = i;
    }

    /* renamed from: b */
    private void m8865b(int i) {
        AppMethodBeat.m2504i(64077);
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(f1424k, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.f1429j, "count.prop")), null);
            AppMethodBeat.m2505o(64077);
        } catch (FileNotFoundException e) {
            AppMethodBeat.m2505o(64077);
        } catch (IOException e2) {
            AppMethodBeat.m2505o(64077);
        }
    }

    /* renamed from: d */
    public static int m8866d() {
        return f1421g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054 A:{SYNTHETIC, Splitter:B:21:0x0054} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    private int m8867i() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(64076);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(this.f1429j, "count.prop");
            if (file.exists()) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    i = Integer.valueOf(properties.getProperty(f1424k, "1")).intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                    AppMethodBeat.m2505o(64076);
                } catch (Exception e2) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(64076);
                    throw th;
                }
            }
            AppMethodBeat.m2505o(64076);
        } catch (Exception e3) {
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.m2505o(64076);
            throw th;
        }
        return i;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e5) {
            }
        }
        AppMethodBeat.m2505o(64076);
        return i;
        AppMethodBeat.m2505o(64076);
        return i;
    }

    /* renamed from: a */
    public C30947bi mo12195a() {
        return this.f1427e ? this.f1425b : null;
    }

    /* renamed from: a */
    public synchronized void mo12196a(Context context, boolean z, boolean z2, C30943am c30943am) {
        AppMethodBeat.m2504i(64073);
        TbsLog.addLog(999, null, new Object[0]);
        TbsLog.initIfNeed(context);
        TbsLog.m80434i("SDKEngine", "init -- context: " + context + ", isPreIniting: " + z2);
        f1422h++;
        if (c30943am != null) {
            c30943am.f13900b = f1422h == 1;
        }
        TbsCoreLoadStat.getInstance().mo64870a();
        if (c30943am != null) {
            c30943am.mo50045a("tbs_rename_task", (byte) 1);
        }
        C5813an.m8800a().mo12161b(context, f1422h == 1);
        C5813an.m8800a().mo12177l(context);
        if (c30943am != null) {
            c30943am.mo50045a("tbs_rename_task", (byte) 2);
        }
        TbsShareManager.forceToLoadX5ForThirdApp(context, true);
        if (c30943am != null) {
            c30943am.mo50045a("can_load_x5", (byte) 1);
        }
        boolean a = QbSdk.m71040a(context, z, z2);
        if (c30943am != null) {
            c30943am.mo50045a("can_load_x5", (byte) 2);
        }
        boolean z3 = VERSION.SDK_INT >= 7;
        boolean z4 = a && z3;
        if (z4) {
            long currentTimeMillis = System.currentTimeMillis();
            z4 = C5813an.m8800a().mo12170e(context, C5818o.m8866d());
            TbsLog.m80434i("SDKEngine", "isTbsCoreLegal: " + z4 + "; cost: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (!z4) {
            String str = "can_load_x5=" + a + "; is_compatible=" + z3;
            TbsLog.m80432e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: ".concat(String.valueOf(str)));
            if (!(QbSdk.f16239a && this.f1427e)) {
                this.f1427e = false;
                TbsCoreLoadStat.getInstance().mo64872a(context, 405, new Throwable(str));
            }
            this.f1429j = C5813an.m8819t(context);
            this.f1428f = true;
            AppMethodBeat.m2505o(64073);
        } else if (this.f1427e) {
            AppMethodBeat.m2505o(64073);
        } else {
            try {
                File r;
                Context e;
                File file;
                File file2;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, new Object[0]);
                    if (c30943am != null) {
                        c30943am.mo50045a("read_core_info", (byte) 1);
                    }
                    z4 = TbsShareManager.m49476j(context);
                    if (c30943am != null) {
                        c30943am.mo50045a("read_core_info", (byte) 2);
                    }
                    if (z4) {
                        file2 = new File(TbsShareManager.m49467c(context));
                        r = C5813an.m8800a().mo12183r(context);
                        e = TbsShareManager.m49471e(context);
                        if (r == null) {
                            this.f1427e = false;
                            QbSdk.m71035a(context, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
                            AppMethodBeat.m2505o(64073);
                        } else {
                            file = file2;
                        }
                    } else {
                        this.f1427e = false;
                        QbSdk.m71035a(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                        AppMethodBeat.m2505o(64073);
                    }
                } else {
                    TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, new Object[0]);
                    file2 = C5813an.m8800a().mo12183r(context);
                    Object obj = (f1421g == 25436 || f1421g == 25437) ? 1 : null;
                    e = obj != null ? context.getApplicationContext() : context;
                    if (file2 == null) {
                        this.f1427e = false;
                        QbSdk.m71035a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                        AppMethodBeat.m2505o(64073);
                    } else {
                        r = file2;
                        file = file2;
                    }
                }
                String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, e, file.getAbsolutePath());
                Object hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : r.getAbsolutePath();
                TbsLog.m80434i("SDKEngine", "SDKEngine init optDir is ".concat(String.valueOf(hostCorePathAppDefined)));
                if (this.f1426c != null) {
                    this.f1425b = this.f1426c;
                    this.f1425b.mo50065a(context, e, file.getAbsolutePath(), hostCorePathAppDefined, dexLoaderFileList, QbSdk.f16242d, c30943am);
                } else {
                    this.f1425b = new C30947bi(context, e, file.getAbsolutePath(), hostCorePathAppDefined, dexLoaderFileList, QbSdk.f16242d, c30943am);
                }
                this.f1427e = true;
            } catch (Throwable th) {
                TbsLog.m80432e("SDKEngine", "useSystemWebView by exception: ".concat(String.valueOf(th)));
                TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.TEST_THROWABLE_ISNOT_NULL, th);
                this.f1427e = false;
                QbSdk.m71035a(context, "SDKEngine::useSystemWebView by exception: ".concat(String.valueOf(th)));
            }
            this.f1429j = C5813an.m8819t(context);
            this.f1428f = true;
            AppMethodBeat.m2505o(64073);
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo12197a(String str) {
        f1424k = str;
    }

    /* renamed from: b */
    public boolean mo12198b() {
        return this.f1427e;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public boolean mo12199b(boolean z) {
        f1419a = z;
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public C30947bi mo12200c() {
        return this.f1425b;
    }

    /* renamed from: e */
    public String mo12201e() {
        AppMethodBeat.m2504i(64074);
        String str;
        if (this.f1425b == null || QbSdk.f16239a) {
            str = "system webview get nothing...";
            AppMethodBeat.m2505o(64074);
            return str;
        }
        str = this.f1425b.mo50063a();
        AppMethodBeat.m2505o(64074);
        return str;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: f */
    public boolean mo12202f() {
        AppMethodBeat.m2504i(64075);
        if (f1419a) {
            if (f1424k == null) {
                AppMethodBeat.m2505o(64075);
                return false;
            }
            int i = m8867i();
            if (i == 0) {
                m8865b(1);
            } else if (i + 1 <= f1423i) {
                m8865b(i + 1);
            } else {
                AppMethodBeat.m2505o(64075);
                return false;
            }
        }
        boolean z = f1419a;
        AppMethodBeat.m2505o(64075);
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: g */
    public boolean mo12203g() {
        return this.f1428f;
    }

    /* renamed from: h */
    public boolean mo12204h() {
        AppMethodBeat.m2504i(64078);
        boolean useSoftWare = QbSdk.useSoftWare();
        AppMethodBeat.m2505o(64078);
        return useSoftWare;
    }
}
