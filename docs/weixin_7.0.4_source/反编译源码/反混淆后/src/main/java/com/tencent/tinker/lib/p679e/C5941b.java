package com.tencent.tinker.lib.p679e;

import android.content.Intent;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* renamed from: com.tencent.tinker.lib.e.b */
public final class C5941b {
    /* renamed from: c */
    public static boolean m9259c(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent != null && ShareIntentUtil.m9355be(tinkerResultIntent) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public static String m9260d(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent == null) {
            return null;
        }
        String n = ShareIntentUtil.m9362n(tinkerResultIntent, "intent_patch_old_version");
        String n2 = ShareIntentUtil.m9362n(tinkerResultIntent, "intent_patch_new_version");
        boolean jp = ShareTinkerInternals.m9424jp(applicationLike.getApplication());
        if (n == null || n2 == null) {
            return null;
        }
        if (jp) {
            return n2;
        }
        return n;
    }

    /* renamed from: e */
    public static void m9261e(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        File jh = SharePatchFileUtil.m9383jh(applicationLike.getApplication());
        if (jh.exists()) {
            File auo = SharePatchFileUtil.auo(jh.getAbsolutePath());
            if (auo.exists()) {
                jh = SharePatchFileUtil.aup(jh.getAbsolutePath());
                SharePatchInfo l = SharePatchInfo.m9392l(auo, jh);
                if (l != null) {
                    l.AET = true;
                    SharePatchInfo.m9390a(auo, l, jh);
                    return;
                }
                return;
            }
            C5952a.m9285w("Tinker.TinkerApplicationHelper", "try to clean patch while patch info file does not exist.", new Object[0]);
            return;
        }
        C5952a.m9285w("Tinker.TinkerApplicationHelper", "try to clean patch while there're not any applied patches.", new Object[0]);
    }
}
