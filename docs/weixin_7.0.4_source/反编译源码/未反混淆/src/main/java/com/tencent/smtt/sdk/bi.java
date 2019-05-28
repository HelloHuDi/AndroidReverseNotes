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
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.t;
import java.util.Map;

class bi {
    private Context a = null;
    private Context b = null;
    private String c = null;
    private String[] d = null;
    private DexLoader e = null;
    private String f = "TbsDexOpt";
    private String g = null;

    public bi(Context context, Context context2, String str, String str2, String[] strArr, String str3, am amVar) {
        AppMethodBeat.i(64641);
        TbsLog.i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && TbsShareManager.getHostCorePathAppDefined() == null) || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            Exception exception = new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
            AppMethodBeat.o(64641);
            throw exception;
        }
        int i;
        this.a = context.getApplicationContext();
        if (context2.getApplicationContext() != null) {
            this.b = context2.getApplicationContext();
        } else {
            this.b = context2;
        }
        this.c = str;
        this.d = strArr;
        this.f = str2;
        if (amVar != null) {
            amVar.a("load_tbs_dex", (byte) 1);
        }
        for (i = 0; i < this.d.length; i++) {
            TbsLog.i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.d[i]);
        }
        TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + str3 + " mCallerAppContext is " + this.a + " dexOutPutDir is " + str2);
        this.e = new DexLoader(str3, this.a, this.d, str2, QbSdk.n);
        System.currentTimeMillis();
        a(context);
        if (amVar != null) {
            amVar.a("load_tbs_dex", (byte) 2);
        }
        libwebp.loadWepLibraryIfNeed(context2, this.c);
        if ("com.nd.android.pandahome2".equals(this.a.getApplicationInfo().packageName)) {
            this.e.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.a);
        }
        if (QbSdk.n != null) {
            this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.n);
        }
        if (amVar != null) {
            amVar.a("init_tbs", (byte) 1);
        }
        i = b(context);
        if (amVar != null) {
            amVar.a("init_tbs", (byte) 2);
        }
        if (i < 0) {
            Exception exception2 = new Exception("TbsWizard init error: " + i + "; msg: " + this.g);
            AppMethodBeat.o(64641);
            throw exception2;
        }
        TbsLog.i("TbsWizard", "construction end...");
        AppMethodBeat.o(64641);
    }

    private int b(Context context) {
        Object invokeStaticMethod;
        int i;
        AppMethodBeat.i(64644);
        this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "putInfo", new Class[]{Context.class, String.class, String.class, String.class, String.class}, context, b.a, b.b, b.c, b.d);
        if (this.b != null || TbsShareManager.getHostCorePathAppDefined() == null) {
            TbsLog.i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + context + " mHostContext is " + this.b + " mDexLoader is " + this.e + " mtbsInstallLocation is " + this.c + " mDexOptPath is " + this.f);
            invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.b, this.e, this.c, this.f, TbsConfig.TBS_SDK_VERSIONNAME, Integer.valueOf(43644), QbSdk.a());
        } else {
            invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, context, this.b, this.e, this.c, this.f, TbsConfig.TBS_SDK_VERSIONNAME, Integer.valueOf(43644), QbSdk.a(), TbsShareManager.getHostCorePathAppDefined());
        }
        if (invokeStaticMethod == null) {
            c();
            d();
            invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.b, this.e, this.c, this.f);
        }
        if (invokeStaticMethod == null) {
            i = -3;
        } else if (invokeStaticMethod instanceof Integer) {
            i = ((Integer) invokeStaticMethod).intValue();
        } else if (invokeStaticMethod instanceof Throwable) {
            TbsCoreLoadStat.getInstance().a(this.a, ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (Throwable) invokeStaticMethod);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                Throwable th = (Throwable) invokeStaticMethod2;
                this.g = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            if (invokeStaticMethod2 instanceof String) {
                this.g = (String) invokeStaticMethod2;
            }
        } else {
            this.g = null;
        }
        AppMethodBeat.o(64644);
        return i;
    }

    private void c() {
        AppMethodBeat.i(64645);
        this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
        AppMethodBeat.o(64645);
    }

    private void d() {
        AppMethodBeat.i(64646);
        this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43644));
        AppMethodBeat.o(64646);
    }

    public String a() {
        String str = null;
        AppMethodBeat.i(64647);
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, Boolean.TRUE, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        if (invokeStaticMethod == null) {
            invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (invokeStaticMethod != null) {
            str = String.valueOf(invokeStaticMethod) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        if (str == null) {
            str = "X5 core get nothing...";
            AppMethodBeat.o(64647);
            return str;
        }
        AppMethodBeat.o(64647);
        return str;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(Context context) {
        AppMethodBeat.i(64642);
        if (VERSION.SDK_INT != 21) {
            AppMethodBeat.o(64642);
            return;
        }
        boolean booleanValue;
        Map map = QbSdk.n;
        if (map != null) {
            Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_CHECK_TBS_VALIDITY);
            if (obj instanceof Boolean) {
                booleanValue = ((Boolean) obj).booleanValue();
                if (booleanValue) {
                    t.a(context);
                }
                AppMethodBeat.o(64642);
            }
        }
        booleanValue = false;
        if (booleanValue) {
        }
        AppMethodBeat.o(64642);
    }

    public void a(Context context, Context context2, String str, String str2, String[] strArr, String str3, am amVar) {
        AppMethodBeat.i(64643);
        this.a = context.getApplicationContext();
        if (this.b.getApplicationContext() != null) {
            this.b = this.b.getApplicationContext();
        }
        this.c = str;
        this.d = strArr;
        this.f = str2;
        libwebp.loadWepLibraryIfNeed(context2, this.c);
        if (QbSdk.n != null) {
            this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.n);
        }
        int b = b(context);
        if (b < 0) {
            Exception exception = new Exception("continueInit init error: " + b + "; msg: " + this.g);
            AppMethodBeat.o(64643);
            throw exception;
        }
        AppMethodBeat.o(64643);
    }

    public boolean a(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(64648);
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(64648);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(64648);
        return booleanValue;
    }

    public DexLoader b() {
        return this.e;
    }
}
