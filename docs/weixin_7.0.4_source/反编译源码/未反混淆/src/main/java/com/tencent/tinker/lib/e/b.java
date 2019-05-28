package com.tencent.tinker.lib.e;

import android.content.Intent;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.util.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class b {
    public static boolean c(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent != null && ShareIntentUtil.be(tinkerResultIntent) == 0) {
            return true;
        }
        return false;
    }

    public static String d(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent == null) {
            return null;
        }
        String n = ShareIntentUtil.n(tinkerResultIntent, "intent_patch_old_version");
        String n2 = ShareIntentUtil.n(tinkerResultIntent, "intent_patch_new_version");
        boolean jp = ShareTinkerInternals.jp(applicationLike.getApplication());
        if (n == null || n2 == null) {
            return null;
        }
        if (jp) {
            return n2;
        }
        return n;
    }

    public static void e(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        File jh = SharePatchFileUtil.jh(applicationLike.getApplication());
        if (jh.exists()) {
            File auo = SharePatchFileUtil.auo(jh.getAbsolutePath());
            if (auo.exists()) {
                jh = SharePatchFileUtil.aup(jh.getAbsolutePath());
                SharePatchInfo l = SharePatchInfo.l(auo, jh);
                if (l != null) {
                    l.AET = true;
                    SharePatchInfo.a(auo, l, jh);
                    return;
                }
                return;
            }
            a.w("Tinker.TinkerApplicationHelper", "try to clean patch while patch info file does not exist.", new Object[0]);
            return;
        }
        a.w("Tinker.TinkerApplicationHelper", "try to clean patch while there're not any applied patches.", new Object[0]);
    }
}
