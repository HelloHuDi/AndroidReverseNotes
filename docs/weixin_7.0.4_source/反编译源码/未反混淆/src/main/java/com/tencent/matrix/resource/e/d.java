package com.tencent.matrix.resource.e;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.d.c;
import java.io.File;
import java.io.FilenameFilter;

public final class d {
    protected final int bYk;
    protected final Context mContext;

    public d(Context context) {
        this(context, (byte) 0);
    }

    private d(Context context, byte b) {
        this.mContext = context;
        this.bYk = 5;
    }

    /* Access modifiers changed, original: final */
    public final File zt() {
        File externalCacheDir;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            externalCacheDir = this.mContext.getExternalCacheDir();
        } else {
            externalCacheDir = this.mContext.getCacheDir();
        }
        File file = new File(externalCacheDir, "matrix_resource");
        c.i("Matrix.DumpStorageManager", "path to store hprof and result: %s", file.getAbsolutePath());
        if (file.exists() || (file.mkdirs() && file.canWrite())) {
            File[] listFiles = file.listFiles(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return str.endsWith(".hprof");
                }
            });
            if (listFiles != null && listFiles.length > this.bYk) {
                for (File file2 : listFiles) {
                    if (file2.exists() && !file2.delete()) {
                        c.w("Matrix.DumpStorageManager", "faile to delete hprof file: " + file2.getAbsolutePath(), new Object[0]);
                    }
                }
            }
            return file;
        }
        c.w("Matrix.DumpStorageManager", "failed to allocate new hprof file since path: %s is not writable.", file.getAbsolutePath());
        return null;
    }
}
