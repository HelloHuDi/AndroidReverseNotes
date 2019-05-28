package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.util.a;
import com.tencent.tinker.lib.util.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class DefaultTinkerResultService extends AbstractResultService {
    public void a(a aVar) {
        if (aVar == null) {
            a.e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        a.i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", aVar.toString());
        b.iY(getApplicationContext());
        if (aVar.cxT) {
            aj(new File(aVar.ABv));
            if (b(aVar)) {
                Process.killProcess(Process.myPid());
            } else {
                a.i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }

    public static void aj(File file) {
        if (SharePatchFileUtil.ap(file)) {
            a.w("Tinker.DefaultTinkerResultService", "deleteRawPatchFile rawFile path: %s", file.getPath());
            String name = file.getName();
            if (name.startsWith("patch-") && name.endsWith(".apk")) {
                File parentFile = file.getParentFile();
                if (!parentFile.getName().startsWith("patch-")) {
                    SharePatchFileUtil.as(file);
                    return;
                } else if (!parentFile.getParentFile().getName().equals("tinker")) {
                    SharePatchFileUtil.as(file);
                    return;
                } else {
                    return;
                }
            }
            SharePatchFileUtil.as(file);
        }
    }

    public final boolean b(a aVar) {
        com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(getApplicationContext());
        if (iX.ABK) {
            d dVar = iX.ABJ;
            if (dVar != null) {
                String str = dVar.ABO;
                if (aVar.ABw != null && aVar.ABw.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
