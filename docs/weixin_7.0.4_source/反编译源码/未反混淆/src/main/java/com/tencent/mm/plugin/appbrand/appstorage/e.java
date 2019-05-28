package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

public final class e {
    public static final Runnable gXq = new Runnable() {
        public final void run() {
            int i = 0;
            AppMethodBeat.i(129520);
            File file = new File(AppBrandLocalMediaObjectManager.gXo);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    AppMethodBeat.o(129520);
                    return;
                }
                for (File B : listFiles) {
                    B(B);
                }
                file = new File(AppBrandVideoDownLoadMgr.hYF);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles2 = file.listFiles();
                    if (listFiles2 == null || listFiles2.length <= 0) {
                        AppMethodBeat.o(129520);
                        return;
                    }
                    int length = listFiles2.length;
                    while (i < length) {
                        B(listFiles2[i]);
                        i++;
                    }
                    AppMethodBeat.o(129520);
                    return;
                }
                AppMethodBeat.o(129520);
                return;
            }
            AppMethodBeat.o(129520);
        }

        private void B(File file) {
            int i = 0;
            AppMethodBeat.i(129521);
            if (file.exists() && file.isDirectory()) {
                if (com.tencent.mm.vfs.e.ct(file.getAbsolutePath() + "/dir.lock")) {
                    if (bo.anU() - new b(file.getAbsolutePath() + "/dir.lock").lastModified() < e.gXs) {
                        ab.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, locked", file.getName());
                        AppMethodBeat.o(129521);
                        return;
                    }
                    ab.e("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock expired", file.getName());
                }
                ab.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock free", file.getName());
                File[] listFiles = file.listFiles(new FileFilter() {
                    public final boolean accept(File file) {
                        AppMethodBeat.i(129519);
                        if (file.getName().endsWith(".data") || file.getName().startsWith("store_") || file.getName().endsWith(".nomedia")) {
                            AppMethodBeat.o(129519);
                            return false;
                        }
                        AppMethodBeat.o(129519);
                        return true;
                    }
                });
                if (listFiles == null || listFiles.length <= 0) {
                    AppMethodBeat.o(129521);
                    return;
                }
                long anU = bo.anU();
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (anU - file2.lastModified() >= e.gXr) {
                        com.tencent.mm.a.e.deleteFile(file2.getAbsolutePath());
                    }
                    i++;
                }
                AppMethodBeat.o(129521);
                return;
            }
            AppMethodBeat.o(129521);
        }
    };
    private static final long gXr = TimeUnit.MINUTES.toMillis(30);
    private static final long gXs = TimeUnit.DAYS.toMillis(1);

    static {
        AppMethodBeat.i(129522);
        AppMethodBeat.o(129522);
    }
}
