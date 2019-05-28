package com.tencent.p177mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.e */
public final class C19082e {
    public static final Runnable gXq = new C190831();
    private static final long gXr = TimeUnit.MINUTES.toMillis(30);
    private static final long gXs = TimeUnit.DAYS.toMillis(1);

    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.e$1 */
    static class C190831 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.e$1$1 */
        class C190841 implements FileFilter {
            C190841() {
            }

            public final boolean accept(File file) {
                AppMethodBeat.m2504i(129519);
                if (file.getName().endsWith(".data") || file.getName().startsWith("store_") || file.getName().endsWith(".nomedia")) {
                    AppMethodBeat.m2505o(129519);
                    return false;
                }
                AppMethodBeat.m2505o(129519);
                return true;
            }
        }

        C190831() {
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(129520);
            File file = new File(AppBrandLocalMediaObjectManager.gXo);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    AppMethodBeat.m2505o(129520);
                    return;
                }
                for (File B : listFiles) {
                    m29660B(B);
                }
                file = new File(AppBrandVideoDownLoadMgr.hYF);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles2 = file.listFiles();
                    if (listFiles2 == null || listFiles2.length <= 0) {
                        AppMethodBeat.m2505o(129520);
                        return;
                    }
                    int length = listFiles2.length;
                    while (i < length) {
                        m29660B(listFiles2[i]);
                        i++;
                    }
                    AppMethodBeat.m2505o(129520);
                    return;
                }
                AppMethodBeat.m2505o(129520);
                return;
            }
            AppMethodBeat.m2505o(129520);
        }

        /* renamed from: B */
        private void m29660B(File file) {
            int i = 0;
            AppMethodBeat.m2504i(129521);
            if (file.exists() && file.isDirectory()) {
                if (C5730e.m8628ct(file.getAbsolutePath() + "/dir.lock")) {
                    if (C5046bo.anU() - new C5728b(file.getAbsolutePath() + "/dir.lock").lastModified() < C19082e.gXs) {
                        C4990ab.m7411d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, locked", file.getName());
                        AppMethodBeat.m2505o(129521);
                        return;
                    }
                    C4990ab.m7413e("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock expired", file.getName());
                }
                C4990ab.m7411d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock free", file.getName());
                File[] listFiles = file.listFiles(new C190841());
                if (listFiles == null || listFiles.length <= 0) {
                    AppMethodBeat.m2505o(129521);
                    return;
                }
                long anU = C5046bo.anU();
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (anU - file2.lastModified() >= C19082e.gXr) {
                        C1173e.deleteFile(file2.getAbsolutePath());
                    }
                    i++;
                }
                AppMethodBeat.m2505o(129521);
                return;
            }
            AppMethodBeat.m2505o(129521);
        }
    }

    static {
        AppMethodBeat.m2504i(129522);
        AppMethodBeat.m2505o(129522);
    }
}
