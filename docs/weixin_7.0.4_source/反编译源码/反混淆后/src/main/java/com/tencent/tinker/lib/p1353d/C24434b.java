package com.tencent.tinker.lib.p1353d;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.util.C41089c;
import com.tencent.tinker.lib.util.C41089c.C5954a;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.List;

/* renamed from: com.tencent.tinker.lib.d.b */
public class C24434b implements C41088d {
    private static boolean ABu = false;
    protected final Context context;

    public C24434b(Context context) {
        this.context = context;
    }

    /* renamed from: ad */
    public void mo40783ad(Intent intent) {
        C5952a.m9284i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
        ABu = false;
        C41089c jc = C41089c.m71517jc(this.context);
        if (!jc.ACn) {
            C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            C5952a.m9283e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            String bb = TinkerPatchService.m80933bb(intent);
            if (bb == null) {
                C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(bb);
            String at = SharePatchFileUtil.m9374at(file);
            if (at == null) {
                C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            C5954a am;
            if (jc.ACo.exists()) {
                am = C5954a.m9290am(jc.ACo);
                if (am.cvZ == null || am.ACr == null || !at.equals(am.cvZ)) {
                    jc.mo65179al(file);
                    am.cvZ = at;
                    am.ACr = "1";
                } else {
                    int parseInt = Integer.parseInt(am.ACr);
                    if (parseInt >= jc.ACq) {
                        SharePatchFileUtil.m9373as(jc.ACp);
                        C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                        return;
                    }
                    am.ACr = String.valueOf(parseInt + 1);
                }
            } else {
                jc.mo65179al(file);
                am = new C5954a(at, "1");
            }
            C5954a.m9289a(jc.ACo, am);
        }
    }

    /* renamed from: e */
    public void mo40784e(File file, int i) {
        C5952a.m9284i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i));
        if (i == -3 || i == -4 || i == -8) {
            C31097a.m50180iX(this.context).mo50550ak(file);
        }
    }

    /* renamed from: a */
    public void mo40777a(File file, SharePatchInfo sharePatchInfo, String str) {
        C5952a.m9284i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", file.getAbsolutePath(), str);
    }

    /* renamed from: a */
    public void mo40778a(File file, File file2, String str, int i) {
        C5952a.m9284i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", ShareTinkerInternals.m9412Sd(i), file.getPath(), file2.getPath(), str);
        C31097a.m50180iX(this.context).mo50550ak(file);
    }

    /* renamed from: a */
    public void mo40781a(File file, List<File> list, Throwable th) {
        C5952a.m9284i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", file.getAbsolutePath(), Integer.valueOf(list.size()));
        C5952a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "onPatchDexOptFail:", new Object[0]);
        if (th.getMessage().contains("checkDexOptExist failed") || th.getMessage().contains("checkDexOptFormat failed")) {
            ABu = true;
            for (File as : list) {
                SharePatchFileUtil.m9373as(as);
            }
            return;
        }
        C31097a.m50180iX(this.context).mo50550ak(file);
    }

    /* renamed from: a */
    public void mo40782a(File file, boolean z, long j) {
        C5952a.m9284i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j));
        if (!ABu) {
            C41089c jc = C41089c.m71517jc(this.context);
            if (!jc.ACn) {
                C5952a.m9285w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
            } else if (jc.ACp.exists()) {
                SharePatchFileUtil.m9373as(jc.ACp);
            }
        }
    }

    /* renamed from: a */
    public void mo40779a(File file, String str, String str2) {
        C5952a.m9284i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", str, str2);
        C31097a.m50180iX(this.context).bGr();
    }

    /* renamed from: a */
    public void mo40780a(File file, Throwable th) {
        C5952a.m9284i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", file.getAbsolutePath(), th.getMessage());
        C5952a.m9283e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        C5952a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "tinker patch exception", new Object[0]);
        C31097a.m50180iX(this.context).tinkerFlags = 0;
        C31097a.m50180iX(this.context).mo50550ak(file);
    }
}
