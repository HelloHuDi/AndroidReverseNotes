package com.tencent.mrs.p655a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MatrixUploadDataSlice;
import com.tencent.matrix.mrs.core.MrsCallback;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mrs.a.a */
public final class C7372a implements MrsCallback {
    private HashMap<String, Boolean> AiZ = new HashMap();

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onRequestGetMrsStrategy(byte[] bArr) {
        try {
            if (C1720g.m3531RK()) {
                synchronized (this) {
                    if (C7373b.isRunning()) {
                        C4990ab.m7416i("Matrix.MrsCallbackImp", "NetSceneGetMrsStrategy is already running, just return");
                        return false;
                    }
                    C4990ab.m7416i("Matrix.MrsCallbackImp", "onRequestGetMrsStrategy, try to request mrs strategy");
                    C1720g.m3535RO().eJo.mo14541a(new C7373b(bArr), 0);
                    return true;
                }
            }
            C4990ab.m7412e("Matrix.MrsCallbackImp", "onRequestGetMrsStrategy, account not ready");
            return false;
        } catch (Exception e) {
            C4990ab.m7412e("Matrix.MrsCallbackImp", "error: " + e.getMessage());
            return false;
        }
    }

    public final void onStrategyNotify(String str, boolean z) {
        C1070c.m2368i("Matrix.MrsCallbackImp", "onStrategyNotify, strategy: %s, isReportProcess; %b", str, Boolean.valueOf(z));
        if (!C1060a.isInstalled() || !MatrixReport.isInstalled()) {
            return;
        }
        if (MatrixReport.with().isDebug()) {
            C1070c.m2368i("Matrix.MrsCallbackImp", "onStrategyNotify, matrix will report all for debug mode", new Object[0]);
            return;
        }
        this.AiZ.clear();
        HashMap hashMap = this.AiZ;
        if (TextUtils.isEmpty(str) || hashMap == null) {
            C1070c.m2367e("Matrix.MatrixUtil", "changeStrategyToMap, input params is illegal", new Object[0]);
        } else {
            for (String split : str.split(";")) {
                String[] split2 = split.split(",", 2);
                if (split2.length != 2) {
                    C1070c.m2367e("Matrix.MatrixUtil", "changeStrategyToMap, strategy format is illegal, value: %s", split);
                } else {
                    hashMap.put(split2[0].trim(), Boolean.valueOf(split2[1].trim().equals("1")));
                }
            }
        }
        Iterator it = C1060a.m2339yK().bUC.iterator();
        while (it.hasNext()) {
            C6283b c6283b = (C6283b) it.next();
            String tag = c6283b.getTag();
            if (this.AiZ.containsKey(tag)) {
                boolean booleanValue = ((Boolean) this.AiZ.get(tag)).booleanValue();
                if (booleanValue && c6283b.isPluginStoped()) {
                    C1070c.m2370w("Matrix.MrsCallbackImp", "matrix strategy change, try to turn on plugin %s", tag);
                    c6283b.start();
                } else if (!booleanValue && c6283b.isPluginStarted()) {
                    C1070c.m2370w("Matrix.MrsCallbackImp", "matrix strategy change, try to turn off plugin %s", tag);
                    c6283b.stop();
                }
            }
        }
    }

    public final String getPublicSharePath() {
        try {
            File filesDir = C4996ah.getContext().getFilesDir();
            if (!filesDir.exists()) {
                filesDir.createNewFile();
            }
            C1070c.m2368i("Matrix.MrsCallbackImp", "[TEST-PATH] getPublicSharePath, path: %s", filesDir.toString());
            return filesDir.toString() + "/mrs/";
        } catch (Exception e) {
            C4990ab.m7412e("Matrix.MrsCallbackImp", e.toString());
            return "";
        }
    }

    public final String getHost(MatrixUploadDataSlice matrixUploadDataSlice) {
        return "support.weixin.qq.com";
    }

    public final String getUrl(MatrixUploadDataSlice matrixUploadDataSlice) {
        StringBuilder append = new StringBuilder(512).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(C7243d.vxo)).append("&devicetype=").append("android-" + VERSION.SDK_INT).append("&filelength=").append(matrixUploadDataSlice.getDataSize()).append("&sum=").append(C1178g.m2591x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(C7243d.vxo), Long.valueOf(matrixUploadDataSlice.getDataSize())}).getBytes()).toLowerCase());
        String Yz = (C4996ah.bqo() && C1720g.m3531RK()) ? C1853r.m3846Yz() : null;
        if (!(Yz == null || Yz.length() == 0)) {
            append.append("&username=").append(Yz);
        }
        if (1 == matrixUploadDataSlice.getUploadIssue().getDataType()) {
            append.append("&reporttype=19860829&reportvalue=").append(new StringBuffer().append(matrixUploadDataSlice.getUploadIssue().getId() < 0 ? -1 * matrixUploadDataSlice.getUploadIssue().getId() : matrixUploadDataSlice.getUploadIssue().getId()).append('.').append(matrixUploadDataSlice.getPackageIndex()).append('.').append(matrixUploadDataSlice.getTotalPackage()).toString()).append("&rtxname=").append(matrixUploadDataSlice.getUploadIssue().getTag());
        } else {
            append.append("&reporttype=1&NewReportType=111");
        }
        return append.toString();
    }

    public final String getCryptKey(MatrixUploadDataSlice matrixUploadDataSlice) {
        return C1178g.m2591x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(C7243d.vxo), Long.valueOf(matrixUploadDataSlice.getDataSize())}).getBytes()).toLowerCase();
    }
}
