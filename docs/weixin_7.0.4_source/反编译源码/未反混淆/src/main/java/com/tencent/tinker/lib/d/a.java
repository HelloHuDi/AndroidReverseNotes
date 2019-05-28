package com.tencent.tinker.lib.d;

import android.content.Context;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.util.c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a implements c {
    public final Context context;

    public a(Context context) {
        this.context = context;
    }

    public void d(File file, int i) {
        com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchListenerReceiveFail: patch receive fail: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i));
    }

    public void a(String str, String str2, File file, String str3) {
        int i = 0;
        com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchVersionChanged: patch version change from " + str + " to " + str2, new Object[0]);
        if (str != null && str2 != null && !str.equals(str2) && com.tencent.tinker.lib.e.a.iX(this.context).rNw) {
            c jc = c.jc(this.context);
            if (!jc.ACn) {
                com.tencent.tinker.lib.util.a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
            } else if (!jc.ACo.exists()) {
                com.tencent.tinker.lib.util.a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
            } else if (str2 == null) {
                com.tencent.tinker.lib.util.a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
            } else {
                com.tencent.tinker.lib.util.c.a am = com.tencent.tinker.lib.util.c.a.am(jc.ACo);
                if (str2.equals(am.cvZ)) {
                    com.tencent.tinker.lib.util.a.i("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
                    am.ACr = "1";
                    com.tencent.tinker.lib.util.c.a.a(jc.ACo, am);
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    String name = file2.getName();
                    if (file2.isDirectory() && !name.equals(str3)) {
                        SharePatchFileUtil.t(file2);
                    }
                    i++;
                }
            }
        }
    }

    public void b(int i, Throwable th) {
        com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", Integer.valueOf(i), th);
        switch (i) {
            case 0:
                com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                com.tencent.tinker.lib.util.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                com.tencent.tinker.lib.util.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        dSg();
    }

    public void a(File file, int i, boolean z) {
        com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType: %d, isDirectory: %b", file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z));
        if (i == 4) {
            dSg();
        } else {
            dSf();
        }
    }

    public void b(File file, int i) {
        com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch load Reporter onLoadFileMd5Mismatch: patch file md5 mismatch file: %s, fileType: %d", file.getAbsolutePath(), Integer.valueOf(i));
        dSf();
    }

    public void a(String str, String str2, File file) {
        com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchInfoCorrupted: patch info file damage: %s, from version: %s to version: %s", file.getAbsolutePath(), str, str2);
        dSf();
    }

    public void a(File file, int i, long j) {
        com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadResult: patch load result, path:%s, code: %d, cost: %dms", file.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(j));
    }

    public void a(Throwable th, int i) {
        switch (i) {
            case -4:
                com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unCatch exception: %s", th);
                ShareTinkerInternals.jm(this.context);
                com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "unCaught exception disable tinker forever with sp", new Object[0]);
                String jk = SharePatchFileUtil.jk(this.context);
                if (!ShareTinkerInternals.isNullOrNil(jk)) {
                    SharePatchFileUtil.as(SharePatchFileUtil.jj(this.context));
                    com.tencent.tinker.lib.util.a.e("Tinker.DefaultLoadReporter", "tinker uncaught real exception:".concat(String.valueOf(jk)), new Object[0]);
                    break;
                }
                break;
            case -3:
                if (th.getMessage().contains("checkResInstall failed")) {
                    com.tencent.tinker.lib.util.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker res check fail:" + th.getMessage(), new Object[0]);
                } else {
                    com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load resource exception: %s", th);
                }
                ShareTinkerInternals.jm(this.context);
                com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "res exception disable tinker forever with sp", new Object[0]);
                break;
            case -2:
                if (th.getMessage().contains("checkDexInstall failed")) {
                    com.tencent.tinker.lib.util.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker dex check fail:" + th.getMessage(), new Object[0]);
                } else {
                    com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load dex exception: %s", th);
                }
                ShareTinkerInternals.jm(this.context);
                com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "dex exception disable tinker forever with sp", new Object[0]);
                break;
            case -1:
                com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unknown exception: %s", th);
                break;
        }
        com.tencent.tinker.lib.util.a.e("Tinker.DefaultLoadReporter", "tinker load exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        com.tencent.tinker.lib.util.a.printErrStackTrace("Tinker.DefaultLoadReporter", th, "tinker load exception", new Object[0]);
        com.tencent.tinker.lib.e.a.iX(this.context).tinkerFlags = 0;
        dSf();
    }

    public void c(File file, int i) {
        com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPackageCheckFail: load patch package check fail file path: %s, errorCode: %d", file.getAbsolutePath(), Integer.valueOf(i));
        dSf();
    }

    public final void dSf() {
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(this.context);
        if (iX.rNw) {
            d dVar = iX.ABJ;
            if (dVar.ABQ) {
                SharePatchInfo sharePatchInfo = dVar.patchInfo;
                if (!(sharePatchInfo == null || ShareTinkerInternals.isNullOrNil(sharePatchInfo.uWO))) {
                    com.tencent.tinker.lib.util.a.w("Tinker.DefaultLoadReporter", "checkAndCleanPatch, oldVersion %s is not null, try kill all other process", sharePatchInfo.uWO);
                    ShareTinkerInternals.jr(this.context);
                }
            }
        }
        iX.bGr();
    }

    public final boolean dSg() {
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(this.context);
        if (!iX.rNw) {
            return false;
        }
        File file = iX.ABJ.ABU;
        if (file == null || !c.jc(this.context).auk(SharePatchFileUtil.at(file))) {
            return false;
        }
        com.tencent.tinker.lib.util.a.i("Tinker.DefaultLoadReporter", "try to repair oat file on patch process", new Object[0]);
        com.tencent.tinker.lib.e.c.cf(this.context, file.getAbsolutePath());
        return true;
    }
}
