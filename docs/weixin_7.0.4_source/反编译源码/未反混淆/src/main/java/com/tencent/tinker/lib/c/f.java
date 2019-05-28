package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;

public final class f extends a {
    public final boolean a(Context context, String str, a aVar) {
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(context);
        File file = new File(str);
        if (!ShareTinkerInternals.Se(iX.tinkerFlags) || !ShareTinkerInternals.jn(context)) {
            com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
            return false;
        } else if (SharePatchFileUtil.ap(file)) {
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
            int a = ShareTinkerInternals.a(context, iX.tinkerFlags, file, shareSecurityCheck);
            if (a != 0) {
                com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
                iX.ABF.e(file, a);
                return false;
            }
            String at = SharePatchFileUtil.at(file);
            if (at == null) {
                com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
                return false;
            }
            aVar.ABw = at;
            com.tencent.tinker.lib.util.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", at);
            String absolutePath = iX.ABC.getAbsolutePath();
            File aup = SharePatchFileUtil.aup(absolutePath);
            File auo = SharePatchFileUtil.auo(absolutePath);
            SharePatchInfo l = SharePatchInfo.l(auo, aup);
            if (l == null) {
                l = new SharePatchInfo("", at, false, Build.FINGERPRINT, "odex");
            } else if (l.uWO == null || l.AES == null || l.ABP == null) {
                com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
                iX.ABF.a(file, l.uWO, l.AES);
                return false;
            } else if (SharePatchFileUtil.aus(at)) {
                l = new SharePatchInfo(l.uWO, at, false, Build.FINGERPRINT, l.ABP.equals("interpet") ? "changing" : l.ABP);
            } else {
                com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", at);
                iX.ABF.a(file, l, at);
                return false;
            }
            String str2 = absolutePath + "/" + SharePatchFileUtil.auq(at);
            com.tencent.tinker.lib.util.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", str2);
            File file2 = new File(str2 + "/" + SharePatchFileUtil.aur(at));
            try {
                if (!at.equals(SharePatchFileUtil.at(file2))) {
                    SharePatchFileUtil.j(file, file2);
                    com.tencent.tinker.lib.util.a.w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", file.getAbsolutePath(), Long.valueOf(file.length()), file2.getAbsolutePath(), Long.valueOf(file2.length()));
                }
                if (d.a(iX, shareSecurityCheck, context, str2, file2)) {
                    String str3;
                    boolean z;
                    if (ShareTinkerInternals.Sb(iX.tinkerFlags)) {
                        str3 = (String) shareSecurityCheck.AFg.get("assets/so_meta.txt");
                        if (str3 == null) {
                            com.tencent.tinker.lib.util.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
                            z = true;
                        } else {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            z = c.a(context, str2 + "/lib/", str3, file2);
                            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                            com.tencent.tinker.lib.util.a.i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", Boolean.valueOf(z), Long.valueOf(elapsedRealtime));
                        }
                    } else {
                        com.tencent.tinker.lib.util.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
                        z = true;
                    }
                    if (z) {
                        if (ShareTinkerInternals.Sc(iX.tinkerFlags)) {
                            str3 = (String) shareSecurityCheck.AFg.get("assets/res_meta.txt");
                            if (str3 == null || str3.length() == 0) {
                                com.tencent.tinker.lib.util.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
                                z = true;
                            } else {
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (e.c(context, str2 + "/res/", str3, file2)) {
                                    z = true;
                                } else {
                                    com.tencent.tinker.lib.util.a.w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                                    z = false;
                                }
                                long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                com.tencent.tinker.lib.util.a.i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", Boolean.valueOf(z), Long.valueOf(elapsedRealtime3));
                            }
                        } else {
                            com.tencent.tinker.lib.util.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
                            z = true;
                        }
                        if (!z) {
                            com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
                            return false;
                        } else if (!d.a(file, iX)) {
                            com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
                            return false;
                        } else if (SharePatchInfo.a(auo, l, aup)) {
                            com.tencent.tinker.lib.util.a.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
                            return true;
                        } else {
                            com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
                            iX.ABF.a(file, l.uWO, l.AES);
                            return false;
                        }
                    }
                    com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
                    return false;
                }
                com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
                return false;
            } catch (IOException e) {
                com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", file.getPath(), file2.getPath());
                iX.ABF.a(file, file2, file.getName(), 1);
                return false;
            }
        } else {
            com.tencent.tinker.lib.util.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
            return false;
        }
    }
}
