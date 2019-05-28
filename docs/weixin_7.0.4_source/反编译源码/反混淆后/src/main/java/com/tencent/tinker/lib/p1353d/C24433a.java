package com.tencent.tinker.lib.p1353d;

import android.content.Context;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C44553d;
import com.tencent.tinker.lib.p679e.C46818c;
import com.tencent.tinker.lib.util.C41089c;
import com.tencent.tinker.lib.util.C41089c.C5954a;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* renamed from: com.tencent.tinker.lib.d.a */
public class C24433a implements C36551c {
    public final Context context;

    public C24433a(Context context) {
        this.context = context;
    }

    /* renamed from: d */
    public void mo40774d(File file, int i) {
        C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchListenerReceiveFail: patch receive fail: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo40769a(String str, String str2, File file, String str3) {
        int i = 0;
        C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchVersionChanged: patch version change from " + str + " to " + str2, new Object[0]);
        if (str != null && str2 != null && !str.equals(str2) && C31097a.m50180iX(this.context).rNw) {
            C41089c jc = C41089c.m71517jc(this.context);
            if (!jc.ACn) {
                C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
            } else if (!jc.ACo.exists()) {
                C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
            } else if (str2 == null) {
                C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
            } else {
                C5954a am = C5954a.m9290am(jc.ACo);
                if (str2.equals(am.cvZ)) {
                    C5952a.m9284i("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
                    am.ACr = "1";
                    C5954a.m9289a(jc.ACo, am);
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    String name = file2.getName();
                    if (file2.isDirectory() && !name.equals(str3)) {
                        SharePatchFileUtil.m9388t(file2);
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: b */
    public void mo40771b(int i, Throwable th) {
        C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", Integer.valueOf(i), th);
        switch (i) {
            case 0:
                C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                C5952a.m9283e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                C5952a.m9283e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        dSg();
    }

    /* renamed from: a */
    public void mo40767a(File file, int i, boolean z) {
        C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType: %d, isDirectory: %b", file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z));
        if (i == 4) {
            dSg();
        } else {
            dSf();
        }
    }

    /* renamed from: b */
    public void mo40772b(File file, int i) {
        C5952a.m9284i("Tinker.DefaultLoadReporter", "patch load Reporter onLoadFileMd5Mismatch: patch file md5 mismatch file: %s, fileType: %d", file.getAbsolutePath(), Integer.valueOf(i));
        dSf();
    }

    /* renamed from: a */
    public void mo40768a(String str, String str2, File file) {
        C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchInfoCorrupted: patch info file damage: %s, from version: %s to version: %s", file.getAbsolutePath(), str, str2);
        dSf();
    }

    /* renamed from: a */
    public void mo40766a(File file, int i, long j) {
        C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadResult: patch load result, path:%s, code: %d, cost: %dms", file.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(j));
    }

    /* renamed from: a */
    public void mo40770a(Throwable th, int i) {
        switch (i) {
            case -4:
                C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unCatch exception: %s", th);
                ShareTinkerInternals.m9421jm(this.context);
                C5952a.m9284i("Tinker.DefaultLoadReporter", "unCaught exception disable tinker forever with sp", new Object[0]);
                String jk = SharePatchFileUtil.m9386jk(this.context);
                if (!ShareTinkerInternals.isNullOrNil(jk)) {
                    SharePatchFileUtil.m9373as(SharePatchFileUtil.m9385jj(this.context));
                    C5952a.m9283e("Tinker.DefaultLoadReporter", "tinker uncaught real exception:".concat(String.valueOf(jk)), new Object[0]);
                    break;
                }
                break;
            case -3:
                if (th.getMessage().contains("checkResInstall failed")) {
                    C5952a.m9283e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker res check fail:" + th.getMessage(), new Object[0]);
                } else {
                    C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load resource exception: %s", th);
                }
                ShareTinkerInternals.m9421jm(this.context);
                C5952a.m9284i("Tinker.DefaultLoadReporter", "res exception disable tinker forever with sp", new Object[0]);
                break;
            case -2:
                if (th.getMessage().contains("checkDexInstall failed")) {
                    C5952a.m9283e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker dex check fail:" + th.getMessage(), new Object[0]);
                } else {
                    C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load dex exception: %s", th);
                }
                ShareTinkerInternals.m9421jm(this.context);
                C5952a.m9284i("Tinker.DefaultLoadReporter", "dex exception disable tinker forever with sp", new Object[0]);
                break;
            case -1:
                C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unknown exception: %s", th);
                break;
        }
        C5952a.m9283e("Tinker.DefaultLoadReporter", "tinker load exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        C5952a.printErrStackTrace("Tinker.DefaultLoadReporter", th, "tinker load exception", new Object[0]);
        C31097a.m50180iX(this.context).tinkerFlags = 0;
        dSf();
    }

    /* renamed from: c */
    public void mo40773c(File file, int i) {
        C5952a.m9284i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPackageCheckFail: load patch package check fail file path: %s, errorCode: %d", file.getAbsolutePath(), Integer.valueOf(i));
        dSf();
    }

    public final void dSf() {
        C31097a iX = C31097a.m50180iX(this.context);
        if (iX.rNw) {
            C44553d c44553d = iX.ABJ;
            if (c44553d.ABQ) {
                SharePatchInfo sharePatchInfo = c44553d.patchInfo;
                if (!(sharePatchInfo == null || ShareTinkerInternals.isNullOrNil(sharePatchInfo.uWO))) {
                    C5952a.m9285w("Tinker.DefaultLoadReporter", "checkAndCleanPatch, oldVersion %s is not null, try kill all other process", sharePatchInfo.uWO);
                    ShareTinkerInternals.m9426jr(this.context);
                }
            }
        }
        iX.bGr();
    }

    public final boolean dSg() {
        C31097a iX = C31097a.m50180iX(this.context);
        if (!iX.rNw) {
            return false;
        }
        File file = iX.ABJ.ABU;
        if (file == null || !C41089c.m71517jc(this.context).auk(SharePatchFileUtil.m9374at(file))) {
            return false;
        }
        C5952a.m9284i("Tinker.DefaultLoadReporter", "try to repair oat file on patch process", new Object[0]);
        C46818c.m89042cf(this.context, file.getAbsolutePath());
        return true;
    }
}
