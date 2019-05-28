package com.tencent.tinker.lib.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.util.a;
import com.tencent.tinker.lib.util.c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.List;

public class b implements d {
    private static boolean ABu = false;
    protected final Context context;

    public b(Context context) {
        this.context = context;
    }

    public void ad(Intent intent) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
        ABu = false;
        c jc = c.jc(this.context);
        if (!jc.ACn) {
            a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            a.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            String bb = TinkerPatchService.bb(intent);
            if (bb == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(bb);
            String at = SharePatchFileUtil.at(file);
            if (at == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            c.a am;
            if (jc.ACo.exists()) {
                am = c.a.am(jc.ACo);
                if (am.cvZ == null || am.ACr == null || !at.equals(am.cvZ)) {
                    jc.al(file);
                    am.cvZ = at;
                    am.ACr = "1";
                } else {
                    int parseInt = Integer.parseInt(am.ACr);
                    if (parseInt >= jc.ACq) {
                        SharePatchFileUtil.as(jc.ACp);
                        a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                        return;
                    }
                    am.ACr = String.valueOf(parseInt + 1);
                }
            } else {
                jc.al(file);
                am = new c.a(at, "1");
            }
            c.a.a(jc.ACo, am);
        }
    }

    public void e(File file, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i));
        if (i == -3 || i == -4 || i == -8) {
            com.tencent.tinker.lib.e.a.iX(this.context).ak(file);
        }
    }

    public void a(File file, SharePatchInfo sharePatchInfo, String str) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", file.getAbsolutePath(), str);
    }

    public void a(File file, File file2, String str, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", ShareTinkerInternals.Sd(i), file.getPath(), file2.getPath(), str);
        com.tencent.tinker.lib.e.a.iX(this.context).ak(file);
    }

    public void a(File file, List<File> list, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", file.getAbsolutePath(), Integer.valueOf(list.size()));
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "onPatchDexOptFail:", new Object[0]);
        if (th.getMessage().contains("checkDexOptExist failed") || th.getMessage().contains("checkDexOptFormat failed")) {
            ABu = true;
            for (File as : list) {
                SharePatchFileUtil.as(as);
            }
            return;
        }
        com.tencent.tinker.lib.e.a.iX(this.context).ak(file);
    }

    public void a(File file, boolean z, long j) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j));
        if (!ABu) {
            c jc = c.jc(this.context);
            if (!jc.ACn) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
            } else if (jc.ACp.exists()) {
                SharePatchFileUtil.as(jc.ACp);
            }
        }
    }

    public void a(File file, String str, String str2) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", str, str2);
        com.tencent.tinker.lib.e.a.iX(this.context).bGr();
    }

    public void a(File file, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", file.getAbsolutePath(), th.getMessage());
        a.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "tinker patch exception", new Object[0]);
        com.tencent.tinker.lib.e.a.iX(this.context).tinkerFlags = 0;
        com.tencent.tinker.lib.e.a.iX(this.context).ak(file);
    }
}
