package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TinkerDexLoader {
    private static boolean ABr = ShareTinkerInternals.dSp();
    private static final ArrayList<ShareDexDiffPatchInfo> ACy = new ArrayList();
    private static HashSet<ShareDexDiffPatchInfo> ACz = new HashSet();

    private TinkerDexLoader() {
    }

    @TargetApi(14)
    /* renamed from: a */
    public static boolean m9304a(TinkerApplication tinkerApplication, String str, String str2, Intent intent, boolean z) {
        if (ACy.isEmpty() && ACz.isEmpty()) {
            return true;
        }
        PathClassLoader pathClassLoader = (PathClassLoader) TinkerDexLoader.class.getClassLoader();
        if (pathClassLoader != null) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo;
            new StringBuilder("classloader: ").append(pathClassLoader.toString());
            String str3 = str + "/dex/";
            ArrayList arrayList = new ArrayList();
            Iterator it = ACy.iterator();
            while (it.hasNext()) {
                shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                if (!m9306b(shareDexDiffPatchInfo)) {
                    File file = new File(str3 + shareDexDiffPatchInfo.eBb);
                    if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (SharePatchFileUtil.m9380h(file, m9303a(shareDexDiffPatchInfo))) {
                            new StringBuilder("verify dex file:").append(file.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis);
                        } else {
                            ShareIntentUtil.m9354b(intent, -13);
                            intent.putExtra("intent_patch_mismatch_dex_path", file.getAbsolutePath());
                            return false;
                        }
                    }
                    arrayList.add(file);
                }
            }
            if (ABr && !ACz.isEmpty()) {
                File file2 = new File(str3 + "tinker_classN.apk");
                long currentTimeMillis2 = System.currentTimeMillis();
                if (tinkerApplication.isTinkerLoadVerifyFlag()) {
                    Iterator it2 = ACz.iterator();
                    while (it2.hasNext()) {
                        shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it2.next();
                        if (!SharePatchFileUtil.m9376b(file2, shareDexDiffPatchInfo.ADN, shareDexDiffPatchInfo.ADP)) {
                            ShareIntentUtil.m9354b(intent, -13);
                            intent.putExtra("intent_patch_mismatch_dex_path", file2.getAbsolutePath());
                            return false;
                        }
                    }
                }
                new StringBuilder("verify dex file:").append(file2.getPath()).append(" md5, use time: ").append(System.currentTimeMillis() - currentTimeMillis2);
                arrayList.add(file2);
            }
            File file3 = new File(str + "/" + str2);
            if (z) {
                final boolean[] zArr = new boolean[]{true};
                final Throwable[] thArr = new Throwable[1];
                try {
                    String dSs = ShareTinkerInternals.dSs();
                    aul(str);
                    file3 = new File(str + "/interpet");
                    TinkerDexOptimizer.m9315a(arrayList, file3, true, dSs, new ResultCallback() {
                        long start;

                        /* renamed from: ai */
                        public final void mo12659ai(File file) {
                            this.start = System.currentTimeMillis();
                            new StringBuilder("start to optimize dex:").append(file.getPath());
                        }

                        /* renamed from: i */
                        public final void mo12661i(File file, File file2) {
                            new StringBuilder("success to optimize dex ").append(file.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
                        }

                        /* renamed from: b */
                        public final void mo12660b(File file, Throwable th) {
                            zArr[0] = false;
                            thArr[0] = th;
                            new StringBuilder("fail to optimize dex ").append(file.getPath()).append(", use time ").append(System.currentTimeMillis() - this.start);
                        }
                    });
                    if (!zArr[0]) {
                        intent.putExtra("intent_patch_interpret_exception", thArr[0]);
                        ShareIntentUtil.m9354b(intent, -16);
                        return false;
                    }
                } catch (Throwable th) {
                    new StringBuilder("getCurrentInstructionSet fail:").append(th);
                    aul(str);
                    intent.putExtra("intent_patch_interpret_exception", th);
                    ShareIntentUtil.m9354b(intent, -15);
                    return false;
                }
            }
            try {
                SystemClassLoaderAdder.m9299a(tinkerApplication, pathClassLoader, file3, arrayList);
                return true;
            } catch (Throwable th2) {
                intent.putExtra("intent_patch_exception", th2);
                ShareIntentUtil.m9354b(intent, -14);
                return false;
            }
        }
        ShareIntentUtil.m9354b(intent, -12);
        return false;
    }

    /* renamed from: a */
    public static boolean m9305a(String str, ShareSecurityCheck shareSecurityCheck, String str2, Intent intent) {
        String str3 = (String) shareSecurityCheck.AFg.get("assets/dex_meta.txt");
        if (str3 == null) {
            return true;
        }
        ACy.clear();
        ACz.clear();
        ArrayList arrayList = new ArrayList();
        ShareDexDiffPatchInfo.m9346o(str3, arrayList);
        if (arrayList.isEmpty()) {
            return true;
        }
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
        while (it.hasNext()) {
            ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = (ShareDexDiffPatchInfo) it.next();
            if (!m9306b(shareDexDiffPatchInfo2)) {
                if (!ShareDexDiffPatchInfo.m9345c(shareDexDiffPatchInfo2)) {
                    intent.putExtra("intent_patch_package_patch_check", -3);
                    ShareIntentUtil.m9354b(intent, -8);
                    return false;
                } else if (ABr && shareDexDiffPatchInfo2.ADN.startsWith("test.dex")) {
                    shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                } else if (ABr && ShareConstants.ADM.matcher(shareDexDiffPatchInfo2.eBb).matches()) {
                    ACz.add(shareDexDiffPatchInfo2);
                } else {
                    hashMap.put(shareDexDiffPatchInfo2.eBb, m9303a(shareDexDiffPatchInfo2));
                    ACy.add(shareDexDiffPatchInfo2);
                }
            }
        }
        if (ABr && !(shareDexDiffPatchInfo == null && ACz.isEmpty())) {
            if (shareDexDiffPatchInfo != null) {
                ACz.add(ShareTinkerInternals.m9415a(shareDexDiffPatchInfo, ACz.size() + 1));
            }
            hashMap.put("tinker_classN.apk", "");
        }
        String str4 = str + "/dex/";
        File file = new File(str4);
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(str + "/" + str2 + "/");
            for (String str32 : hashMap.keySet()) {
                File file3 = new File(str4 + str32);
                if (SharePatchFileUtil.m9370ap(file3)) {
                    file = new File(SharePatchFileUtil.m9387k(file3, file2));
                    if (!SharePatchFileUtil.m9370ap(file) && !SharePatchFileUtil.m9371aq(file)) {
                        intent.putExtra("intent_patch_missing_dex_path", file.getAbsolutePath());
                        ShareIntentUtil.m9354b(intent, -11);
                        return false;
                    }
                } else {
                    intent.putExtra("intent_patch_missing_dex_path", file3.getAbsolutePath());
                    ShareIntentUtil.m9354b(intent, -10);
                    return false;
                }
            }
            intent.putExtra("intent_patch_dexes_path", hashMap);
            return true;
        }
        ShareIntentUtil.m9354b(intent, -9);
        return false;
    }

    /* renamed from: a */
    private static String m9303a(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        return ABr ? shareDexDiffPatchInfo.ADP : shareDexDiffPatchInfo.ADO;
    }

    private static void aul(String str) {
        SharePatchFileUtil.m9378cu(str + "/odex/");
        if (ShareTinkerInternals.dSr()) {
            SharePatchFileUtil.m9378cu(str + "/dex/oat/");
        }
    }

    /* renamed from: b */
    private static boolean m9306b(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (!ABr && shareDexDiffPatchInfo.ADO.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            return true;
        }
        return false;
    }
}
