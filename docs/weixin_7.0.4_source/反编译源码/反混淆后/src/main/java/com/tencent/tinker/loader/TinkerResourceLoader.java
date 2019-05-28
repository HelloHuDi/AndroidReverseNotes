package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;

public class TinkerResourceLoader {
    private static ShareResPatchInfo ACI = new ShareResPatchInfo();

    private TinkerResourceLoader() {
    }

    /* renamed from: a */
    public static boolean m9317a(TinkerApplication tinkerApplication, String str, Intent intent) {
        if (ACI == null || ACI.AEW == null) {
            return true;
        }
        String str2 = str + "/res/resources.apk";
        File file = new File(str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (tinkerApplication.isTinkerLoadVerifyFlag()) {
            if (SharePatchFileUtil.m9381i(file, ACI.AEW)) {
                new StringBuilder("verify resource file:").append(file.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis);
            } else {
                new StringBuilder("Failed to load resource file, path: ").append(file.getPath()).append(", expect md5: ").append(ACI.AEW);
                ShareIntentUtil.m9354b(intent, -24);
                return false;
            }
        }
        try {
            TinkerResourcePatcher.m9318cg(tinkerApplication, str2);
            new StringBuilder("monkeyPatchExistingResources resource file:").append(str2).append(", use time: ").append(System.currentTimeMillis() - currentTimeMillis);
            return true;
        } catch (Throwable th) {
        }
        intent.putExtra("intent_patch_exception", th);
        ShareIntentUtil.m9354b(intent, -23);
        return false;
    }

    /* renamed from: a */
    public static boolean m9316a(Context context, String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = (String) shareSecurityCheck.AFg.get("assets/res_meta.txt");
        if (str2 == null) {
            return true;
        }
        ShareResPatchInfo.m9405b(str2, ACI);
        if (ACI.AEW == null) {
            return true;
        }
        if (ShareResPatchInfo.m9403a(ACI)) {
            str2 = str + "/res/";
            File file = new File(str2);
            if (!file.exists() || !file.isDirectory()) {
                ShareIntentUtil.m9354b(intent, -21);
                return false;
            } else if (SharePatchFileUtil.m9370ap(new File(str2 + "resources.apk"))) {
                try {
                    TinkerResourcePatcher.m9320jd(context);
                    return true;
                } catch (Throwable th) {
                    intent.putExtra("intent_patch_exception", th);
                    ShareIntentUtil.m9354b(intent, -23);
                    return false;
                }
            } else {
                ShareIntentUtil.m9354b(intent, -22);
                return false;
            }
        }
        intent.putExtra("intent_patch_package_patch_check", -8);
        ShareIntentUtil.m9354b(intent, -8);
        return false;
    }
}
