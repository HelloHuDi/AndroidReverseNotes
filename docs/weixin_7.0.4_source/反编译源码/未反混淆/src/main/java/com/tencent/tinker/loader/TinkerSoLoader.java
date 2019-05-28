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
    public static boolean a(String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = (String) shareSecurityCheck.AFg.get("assets/so_meta.txt");
        if (str2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        ShareBsDiffPatchInfo.n(str2, arrayList);
        if (arrayList.isEmpty()) {
            return true;
        }
        String str3 = str + "/lib/";
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
            if (ShareBsDiffPatchInfo.a(shareBsDiffPatchInfo)) {
                hashMap.put(shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.cvZ);
            } else {
                intent.putExtra("intent_patch_package_patch_check", -4);
                ShareIntentUtil.b(intent, -8);
                return false;
            }
        }
        File file = new File(str3);
        if (file.exists() && file.isDirectory()) {
            for (String str22 : hashMap.keySet()) {
                File file2 = new File(str3 + str22);
                if (!SharePatchFileUtil.ap(file2)) {
                    ShareIntentUtil.b(intent, -18);
                    intent.putExtra("intent_patch_missing_lib_path", file2.getAbsolutePath());
                    return false;
                }
            }
            intent.putExtra("intent_patch_libs_path", hashMap);
            return true;
        }
        ShareIntentUtil.b(intent, -17);
        return false;
    }
}
