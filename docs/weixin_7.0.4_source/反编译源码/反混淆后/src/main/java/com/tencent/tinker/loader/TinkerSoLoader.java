package com.tencent.tinker.loader;

import android.content.Intent;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TinkerSoLoader {
    /* renamed from: a */
    public static boolean m9322a(String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = (String) shareSecurityCheck.AFg.get("assets/so_meta.txt");
        if (str2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        ShareBsDiffPatchInfo.m9344n(str2, arrayList);
        if (arrayList.isEmpty()) {
            return true;
        }
        String str3 = str + "/lib/";
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
            if (ShareBsDiffPatchInfo.m9343a(shareBsDiffPatchInfo)) {
                hashMap.put(shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.cvZ);
            } else {
                intent.putExtra("intent_patch_package_patch_check", -4);
                ShareIntentUtil.m9354b(intent, -8);
                return false;
            }
        }
        File file = new File(str3);
        if (file.exists() && file.isDirectory()) {
            for (String str22 : hashMap.keySet()) {
                File file2 = new File(str3 + str22);
                if (!SharePatchFileUtil.m9370ap(file2)) {
                    ShareIntentUtil.m9354b(intent, -18);
                    intent.putExtra("intent_patch_missing_lib_path", file2.getAbsolutePath());
                    return false;
                }
            }
            intent.putExtra("intent_patch_libs_path", hashMap);
            return true;
        }
        ShareIntentUtil.m9354b(intent, -17);
        return false;
    }
}
