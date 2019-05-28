package com.tencent.tinker.loader;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    public Intent tryLoad(TinkerApplication tinkerApplication) {
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, intent);
        ShareIntentUtil.a(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void tryLoadPatchFilesInternal(TinkerApplication tinkerApplication, Intent intent) {
        int tinkerFlags = tinkerApplication.getTinkerFlags();
        if (!ShareTinkerInternals.Se(tinkerFlags)) {
            ShareIntentUtil.b(intent, -1);
        } else if (ShareTinkerInternals.jq(tinkerApplication)) {
            ShareIntentUtil.b(intent, -1);
        } else {
            File jh = SharePatchFileUtil.jh(tinkerApplication);
            if (jh == null) {
                ShareIntentUtil.b(intent, -2);
                return;
            }
            String absolutePath = jh.getAbsolutePath();
            if (jh.exists()) {
                File auo = SharePatchFileUtil.auo(absolutePath);
                if (auo.exists()) {
                    File aup = SharePatchFileUtil.aup(absolutePath);
                    this.patchInfo = SharePatchInfo.l(auo, aup);
                    if (this.patchInfo == null) {
                        ShareIntentUtil.b(intent, -4);
                        return;
                    }
                    String str = this.patchInfo.uWO;
                    String str2 = this.patchInfo.AES;
                    String str3 = this.patchInfo.ABP;
                    if (str == null || str2 == null || str3 == null) {
                        ShareIntentUtil.b(intent, -4);
                        return;
                    }
                    String auq;
                    Object obj;
                    boolean equals;
                    boolean jp = ShareTinkerInternals.jp(tinkerApplication);
                    boolean z = this.patchInfo.AET;
                    if (jp && z) {
                        auq = SharePatchFileUtil.auq(str2);
                        if (auq != null) {
                            SharePatchFileUtil.cu(absolutePath + "/" + auq);
                            if (str.equals(str2)) {
                                str = "";
                            }
                            this.patchInfo.uWO = str;
                            this.patchInfo.AES = str;
                            SharePatchInfo.a(auo, this.patchInfo, aup);
                            ShareTinkerInternals.js(tinkerApplication);
                            str2 = str;
                            auq = str;
                            intent.putExtra("intent_patch_old_version", auq);
                            intent.putExtra("intent_patch_new_version", str2);
                            obj = auq.equals(str2) ? 1 : null;
                            equals = str3.equals("changing");
                            str3 = ShareTinkerInternals.ch(tinkerApplication, str3);
                            intent.putExtra("intent_patch_oat_dir", str3);
                            if (obj != null && jp) {
                                auq = str2;
                            }
                            if (ShareTinkerInternals.isNullOrNil(auq)) {
                                str2 = SharePatchFileUtil.auq(auq);
                                if (str2 == null) {
                                    ShareIntentUtil.b(intent, -6);
                                    return;
                                }
                                absolutePath = absolutePath + "/" + str2;
                                File file = new File(absolutePath);
                                if (file.exists()) {
                                    String aur = SharePatchFileUtil.aur(auq);
                                    File file2 = aur != null ? new File(file.getAbsolutePath(), aur) : null;
                                    if (SharePatchFileUtil.ap(file2)) {
                                        ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(tinkerApplication);
                                        int a = ShareTinkerInternals.a(tinkerApplication, tinkerFlags, file2, shareSecurityCheck);
                                        if (a != 0) {
                                            intent.putExtra("intent_patch_package_patch_check", a);
                                            ShareIntentUtil.b(intent, -8);
                                            return;
                                        }
                                        intent.putExtra("intent_patch_package_config", shareSecurityCheck.dSo());
                                        boolean Sa = ShareTinkerInternals.Sa(tinkerFlags);
                                        if (Sa && !TinkerDexLoader.a(absolutePath, shareSecurityCheck, str3, intent)) {
                                            return;
                                        }
                                        if (!ShareTinkerInternals.Sb(tinkerFlags) || TinkerSoLoader.a(absolutePath, shareSecurityCheck, intent)) {
                                            boolean Sc = ShareTinkerInternals.Sc(tinkerFlags);
                                            if (!Sc || TinkerResourceLoader.a(tinkerApplication, absolutePath, shareSecurityCheck, intent)) {
                                                boolean z2 = ShareTinkerInternals.dSp() && ShareTinkerInternals.auu(this.patchInfo.AEU) && VERSION.SDK_INT >= 21 && !ShareTinkerInternals.dSr();
                                                intent.putExtra("intent_patch_system_ota", z2);
                                                if (jp && (obj != null || equals)) {
                                                    this.patchInfo.uWO = auq;
                                                    this.patchInfo.ABP = str3;
                                                    if (SharePatchInfo.a(auo, this.patchInfo, aup)) {
                                                        ShareTinkerInternals.js(tinkerApplication);
                                                        if (equals) {
                                                            SharePatchFileUtil.cu(absolutePath + "/interpet");
                                                        }
                                                    } else {
                                                        ShareIntentUtil.b(intent, -19);
                                                        return;
                                                    }
                                                }
                                                if (checkSafeModeCount(tinkerApplication)) {
                                                    if (Sa) {
                                                        z = TinkerDexLoader.a(tinkerApplication, absolutePath, str3, intent, z2);
                                                        if (z2) {
                                                            this.patchInfo.AEU = Build.FINGERPRINT;
                                                            this.patchInfo.ABP = z ? "interpet" : "odex";
                                                            if (SharePatchInfo.a(auo, this.patchInfo, aup)) {
                                                                intent.putExtra("intent_patch_oat_dir", this.patchInfo.ABP);
                                                            } else {
                                                                ShareIntentUtil.b(intent, -19);
                                                                return;
                                                            }
                                                        }
                                                        if (!z) {
                                                            return;
                                                        }
                                                    }
                                                    if (!Sc || TinkerResourceLoader.a(tinkerApplication, absolutePath, intent)) {
                                                        if (Sa && Sc) {
                                                            ComponentHotplug.a(tinkerApplication, shareSecurityCheck);
                                                        }
                                                        ShareIntentUtil.b(intent, 0);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                intent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
                                                ShareIntentUtil.b(intent, -25);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    ShareIntentUtil.b(intent, -7);
                                    return;
                                }
                                ShareIntentUtil.b(intent, -6);
                                return;
                            }
                            ShareIntentUtil.b(intent, -5);
                            return;
                        }
                    }
                    auq = str;
                    intent.putExtra("intent_patch_old_version", auq);
                    intent.putExtra("intent_patch_new_version", str2);
                    if (auq.equals(str2)) {
                    }
                    equals = str3.equals("changing");
                    str3 = ShareTinkerInternals.ch(tinkerApplication, str3);
                    intent.putExtra("intent_patch_oat_dir", str3);
                    auq = str2;
                    if (ShareTinkerInternals.isNullOrNil(auq)) {
                    }
                } else {
                    new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(auo.getAbsolutePath());
                    ShareIntentUtil.b(intent, -3);
                    return;
                }
            }
            ShareIntentUtil.b(intent, -2);
        }
    }

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        int jo = ShareTinkerInternals.jo(tinkerApplication);
        if (jo >= 2) {
            ShareTinkerInternals.aD(tinkerApplication, 0);
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        ShareTinkerInternals.aD(tinkerApplication, jo + 1);
        return true;
    }
}
