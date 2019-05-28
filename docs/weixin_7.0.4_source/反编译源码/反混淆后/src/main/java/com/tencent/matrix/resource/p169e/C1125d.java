package com.tencent.matrix.resource.p169e;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.p157d.C1070c;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.tencent.matrix.resource.e.d */
public final class C1125d {
    protected final int bYk;
    protected final Context mContext;

    /* renamed from: com.tencent.matrix.resource.e.d$1 */
    class C11241 implements FilenameFilter {
        C11241() {
        }

        public final boolean accept(File file, String str) {
            return str.endsWith(".hprof");
        }
    }

    public C1125d(Context context) {
        this(context, (byte) 0);
    }

    private C1125d(Context context, byte b) {
        this.mContext = context;
        this.bYk = 5;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: zt */
    public final File mo4346zt() {
        File externalCacheDir;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            externalCacheDir = this.mContext.getExternalCacheDir();
        } else {
            externalCacheDir = this.mContext.getCacheDir();
        }
        File file = new File(externalCacheDir, "matrix_resource");
        C1070c.m2368i("Matrix.DumpStorageManager", "path to store hprof and result: %s", file.getAbsolutePath());
        if (file.exists() || (file.mkdirs() && file.canWrite())) {
            File[] listFiles = file.listFiles(new C11241());
            if (listFiles != null && listFiles.length > this.bYk) {
                for (File file2 : listFiles) {
                    if (file2.exists() && !file2.delete()) {
                        C1070c.m2370w("Matrix.DumpStorageManager", "faile to delete hprof file: " + file2.getAbsolutePath(), new Object[0]);
                    }
                }
            }
            return file;
        }
        C1070c.m2370w("Matrix.DumpStorageManager", "failed to allocate new hprof file since path: %s is not writable.", file.getAbsolutePath());
        return null;
    }
}
