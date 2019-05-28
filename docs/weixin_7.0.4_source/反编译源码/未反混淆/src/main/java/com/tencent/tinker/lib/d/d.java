package com.tencent.tinker.lib.d;

import android.content.Intent;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public interface d {
    void a(File file, SharePatchInfo sharePatchInfo, String str);

    void a(File file, File file2, String str, int i);

    void a(File file, String str, String str2);

    void a(File file, Throwable th);

    void a(File file, List<File> list, Throwable th);

    void a(File file, boolean z, long j);

    void ad(Intent intent);

    void e(File file, int i);
}
