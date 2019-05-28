package com.tencent.tinker.lib.p1112c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.service.C46819a;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.tinker.lib.c.f */
public final class C36550f extends C46817a {
    /* renamed from: a */
    public final boolean mo57836a(Context context, String str, C46819a c46819a) {
        C31097a iX = C31097a.m50180iX(context);
        File file = new File(str);
        if (!ShareTinkerInternals.m9413Se(iX.tinkerFlags) || !ShareTinkerInternals.m9422jn(context)) {
            C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
            return false;
        } else if (SharePatchFileUtil.m9370ap(file)) {
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
            int a = ShareTinkerInternals.m9414a(context, iX.tinkerFlags, file, shareSecurityCheck);
            if (a != 0) {
                C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
                iX.ABF.mo40784e(file, a);
                return false;
            }
            String at = SharePatchFileUtil.m9374at(file);
            if (at == null) {
                C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
                return false;
            }
            c46819a.ABw = at;
            C5952a.m9284i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", at);
            String absolutePath = iX.ABC.getAbsolutePath();
            File aup = SharePatchFileUtil.aup(absolutePath);
            File auo = SharePatchFileUtil.auo(absolutePath);
            SharePatchInfo l = SharePatchInfo.m9392l(auo, aup);
            if (l == null) {
                l = new SharePatchInfo("", at, false, Build.FINGERPRINT, "odex");
            } else if (l.uWO == null || l.AES == null || l.ABP == null) {
                C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
                iX.ABF.mo40779a(file, l.uWO, l.AES);
                return false;
            } else if (SharePatchFileUtil.aus(at)) {
                l = new SharePatchInfo(l.uWO, at, false, Build.FINGERPRINT, l.ABP.equals("interpet") ? "changing" : l.ABP);
            } else {
                C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", at);
                iX.ABF.mo40777a(file, l, at);
                return false;
            }
            String str2 = absolutePath + "/" + SharePatchFileUtil.auq(at);
            C5952a.m9284i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", str2);
            File file2 = new File(str2 + "/" + SharePatchFileUtil.aur(at));
            try {
                if (!at.equals(SharePatchFileUtil.m9374at(file2))) {
                    SharePatchFileUtil.m9382j(file, file2);
                    C5952a.m9285w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", file.getAbsolutePath(), Long.valueOf(file.length()), file2.getAbsolutePath(), Long.valueOf(file2.length()));
                }
                if (C16323d.m25172a(iX, shareSecurityCheck, context, str2, file2)) {
                    String str3;
                    boolean z;
                    if (ShareTinkerInternals.m9410Sb(iX.tinkerFlags)) {
                        str3 = (String) shareSecurityCheck.AFg.get("assets/so_meta.txt");
                        if (str3 == null) {
                            C5952a.m9285w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
                            z = true;
                        } else {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            z = C31094c.m50176a(context, str2 + "/lib/", str3, file2);
                            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                            C5952a.m9284i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", Boolean.valueOf(z), Long.valueOf(elapsedRealtime));
                        }
                    } else {
                        C5952a.m9285w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
                        z = true;
                    }
                    if (z) {
                        if (ShareTinkerInternals.m9411Sc(iX.tinkerFlags)) {
                            str3 = (String) shareSecurityCheck.AFg.get("assets/res_meta.txt");
                            if (str3 == null || str3.length() == 0) {
                                C5952a.m9285w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
                                z = true;
                            } else {
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (C31095e.m50178c(context, str2 + "/res/", str3, file2)) {
                                    z = true;
                                } else {
                                    C5952a.m9285w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                                    z = false;
                                }
                                long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                C5952a.m9284i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", Boolean.valueOf(z), Long.valueOf(elapsedRealtime3));
                            }
                        } else {
                            C5952a.m9285w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
                            z = true;
                        }
                        if (!z) {
                            C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
                            return false;
                        } else if (!C16323d.m25173a(file, iX)) {
                            C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
                            return false;
                        } else if (SharePatchInfo.m9390a(auo, l, aup)) {
                            C5952a.m9285w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
                            return true;
                        } else {
                            C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
                            iX.ABF.mo40779a(file, l.uWO, l.AES);
                            return false;
                        }
                    }
                    C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
                    return false;
                }
                C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
                return false;
            } catch (IOException e) {
                C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", file.getPath(), file2.getPath());
                iX.ABF.mo40778a(file, file2, file.getName(), 1);
                return false;
            }
        } else {
            C5952a.m9283e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
            return false;
        }
    }
}
