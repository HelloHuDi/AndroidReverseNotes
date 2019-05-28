package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C44553d;
import com.tencent.tinker.lib.util.C31098b;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class DefaultTinkerResultService extends AbstractResultService {
    /* renamed from: a */
    public void mo33931a(C46819a c46819a) {
        if (c46819a == null) {
            C5952a.m9283e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        C5952a.m9284i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", c46819a.toString());
        C31098b.m50186iY(getApplicationContext());
        if (c46819a.cxT) {
            m50182aj(new File(c46819a.ABv));
            if (mo50552b(c46819a)) {
                Process.killProcess(Process.myPid());
            } else {
                C5952a.m9284i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }

    /* renamed from: aj */
    public static void m50182aj(File file) {
        if (SharePatchFileUtil.m9370ap(file)) {
            C5952a.m9285w("Tinker.DefaultTinkerResultService", "deleteRawPatchFile rawFile path: %s", file.getPath());
            String name = file.getName();
            if (name.startsWith("patch-") && name.endsWith(".apk")) {
                File parentFile = file.getParentFile();
                if (!parentFile.getName().startsWith("patch-")) {
                    SharePatchFileUtil.m9373as(file);
                    return;
                } else if (!parentFile.getParentFile().getName().equals("tinker")) {
                    SharePatchFileUtil.m9373as(file);
                    return;
                } else {
                    return;
                }
            }
            SharePatchFileUtil.m9373as(file);
        }
    }

    /* renamed from: b */
    public final boolean mo50552b(C46819a c46819a) {
        C31097a iX = C31097a.m50180iX(getApplicationContext());
        if (iX.ABK) {
            C44553d c44553d = iX.ABJ;
            if (c44553d != null) {
                String str = c44553d.ABO;
                if (c46819a.ABw != null && c46819a.ABw.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
