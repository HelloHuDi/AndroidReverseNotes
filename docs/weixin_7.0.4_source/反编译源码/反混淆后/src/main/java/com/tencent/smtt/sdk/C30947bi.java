package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.C30952t;
import com.tencent.smtt.utils.C36443b;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

/* renamed from: com.tencent.smtt.sdk.bi */
class C30947bi {
    /* renamed from: a */
    private Context f13906a = null;
    /* renamed from: b */
    private Context f13907b = null;
    /* renamed from: c */
    private String f13908c = null;
    /* renamed from: d */
    private String[] f13909d = null;
    /* renamed from: e */
    private DexLoader f13910e = null;
    /* renamed from: f */
    private String f13911f = "TbsDexOpt";
    /* renamed from: g */
    private String f13912g = null;

    public C30947bi(Context context, Context context2, String str, String str2, String[] strArr, String str3, C30943am c30943am) {
        AppMethodBeat.m2504i(64641);
        TbsLog.m80434i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && TbsShareManager.getHostCorePathAppDefined() == null) || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            Exception exception = new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
            AppMethodBeat.m2505o(64641);
            throw exception;
        }
        int i;
        this.f13906a = context.getApplicationContext();
        if (context2.getApplicationContext() != null) {
            this.f13907b = context2.getApplicationContext();
        } else {
            this.f13907b = context2;
        }
        this.f13908c = str;
        this.f13909d = strArr;
        this.f13911f = str2;
        if (c30943am != null) {
            c30943am.mo50045a("load_tbs_dex", (byte) 1);
        }
        for (i = 0; i < this.f13909d.length; i++) {
            TbsLog.m80434i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.f13909d[i]);
        }
        TbsLog.m80434i("TbsWizard", "new DexLoader #2 libraryPath is " + str3 + " mCallerAppContext is " + this.f13906a + " dexOutPutDir is " + str2);
        this.f13910e = new DexLoader(str3, this.f13906a, this.f13909d, str2, QbSdk.f16252n);
        System.currentTimeMillis();
        mo50064a(context);
        if (c30943am != null) {
            c30943am.mo50045a("load_tbs_dex", (byte) 2);
        }
        libwebp.loadWepLibraryIfNeed(context2, this.f13908c);
        if ("com.nd.android.pandahome2".equals(this.f13906a.getApplicationInfo().packageName)) {
            this.f13910e.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.f13906a);
        }
        if (QbSdk.f16252n != null) {
            this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.f16252n);
        }
        if (c30943am != null) {
            c30943am.mo50045a("init_tbs", (byte) 1);
        }
        i = m49529b(context);
        if (c30943am != null) {
            c30943am.mo50045a("init_tbs", (byte) 2);
        }
        if (i < 0) {
            Exception exception2 = new Exception("TbsWizard init error: " + i + "; msg: " + this.f13912g);
            AppMethodBeat.m2505o(64641);
            throw exception2;
        }
        TbsLog.m80434i("TbsWizard", "construction end...");
        AppMethodBeat.m2505o(64641);
    }

    /* renamed from: b */
    private int m49529b(Context context) {
        Object invokeStaticMethod;
        int i;
        AppMethodBeat.m2504i(64644);
        this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[]{Context.class, String.class, String.class, String.class, String.class}, context, C36443b.f15180a, C36443b.f15181b, C36443b.f15182c, C36443b.f15183d);
        if (this.f13907b != null || TbsShareManager.getHostCorePathAppDefined() == null) {
            TbsLog.m80434i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + context + " mHostContext is " + this.f13907b + " mDexLoader is " + this.f13910e + " mtbsInstallLocation is " + this.f13908c + " mDexOptPath is " + this.f13911f);
            invokeStaticMethod = this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.f13907b, this.f13910e, this.f13908c, this.f13911f, TbsConfig.TBS_SDK_VERSIONNAME, Integer.valueOf(43644), QbSdk.m71034a());
        } else {
            invokeStaticMethod = this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, context, this.f13907b, this.f13910e, this.f13908c, this.f13911f, TbsConfig.TBS_SDK_VERSIONNAME, Integer.valueOf(43644), QbSdk.m71034a(), TbsShareManager.getHostCorePathAppDefined());
        }
        if (invokeStaticMethod == null) {
            m49530c();
            m49531d();
            invokeStaticMethod = this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.f13907b, this.f13910e, this.f13908c, this.f13911f);
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            TbsCoreLoadStat.getInstance().mo64872a(this.f13906a, ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                this.f13912g = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            if (invokeStaticMethod2 instanceof String) {
                this.f13912g = (String) invokeStaticMethod2;
            }
        } else {
            this.f13912g = null;
        }
        AppMethodBeat.m2505o(64644);
        return i;
    }

    /* renamed from: c */
    private void m49530c() {
        AppMethodBeat.m2504i(64645);
        this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
        AppMethodBeat.m2505o(64645);
    }

    /* renamed from: d */
    private void m49531d() {
        AppMethodBeat.m2504i(64646);
        this.f13910e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43644));
        AppMethodBeat.m2505o(64646);
    }

    /* renamed from: a */
    public String mo50063a() {
        String str = null;
        AppMethodBeat.m2504i(64647);
        Object invokeStaticMethod = this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.TRUE, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.f13910e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (invokeStaticMethod != null) {
            str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        if (str == null) {
            str = "X5 core get nothing...";
            AppMethodBeat.m2505o(64647);
            return str;
        }
        AppMethodBeat.m2505o(64647);
        return str;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo50064a(Context context) {
        AppMethodBeat.m2504i(64642);
        if (VERSION.SDK_INT != 21) {
            AppMethodBeat.m2505o(64642);
            return;
        }
        boolean booleanValue;
        Map map = QbSdk.f16252n;
        if (map != null) {
            Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_CHECK_TBS_VALIDITY);
            if (obj instanceof Boolean) {
                booleanValue = ((Boolean) obj).booleanValue();
                if (booleanValue) {
                    C30952t.m49581a(context);
                }
                AppMethodBeat.m2505o(64642);
            }
        }
        booleanValue = false;
        if (booleanValue) {
        }
        AppMethodBeat.m2505o(64642);
    }

    /* renamed from: a */
    public void mo50065a(Context context, Context context2, String str, String str2, String[] strArr, String str3, C30943am c30943am) {
        AppMethodBeat.m2504i(64643);
        this.f13906a = context.getApplicationContext();
        if (this.f13907b.getApplicationContext() != null) {
            this.f13907b = this.f13907b.getApplicationContext();
        }
        this.f13908c = str;
        this.f13909d = strArr;
        this.f13911f = str2;
        libwebp.loadWepLibraryIfNeed(context2, this.f13908c);
        if (QbSdk.f16252n != null) {
            this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.f16252n);
        }
        int b = m49529b(context);
        if (b < 0) {
            Exception exception = new Exception("continueInit init error: " + b + "; msg: " + this.f13912g);
            AppMethodBeat.m2505o(64643);
            throw exception;
        }
        AppMethodBeat.m2505o(64643);
    }

    /* renamed from: a */
    public boolean mo50066a(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(64648);
        Object invokeStaticMethod = this.f13910e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(64648);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(64648);
        return booleanValue;
    }

    /* renamed from: b */
    public DexLoader mo50067b() {
        return this.f13910e;
    }
}
