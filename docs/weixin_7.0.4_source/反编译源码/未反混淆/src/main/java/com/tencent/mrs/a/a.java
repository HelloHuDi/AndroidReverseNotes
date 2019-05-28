package com.tencent.mrs.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.b.b;
import com.tencent.matrix.d.c;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MatrixUploadDataSlice;
import com.tencent.matrix.mrs.core.MrsCallback;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class a implements MrsCallback {
    private HashMap<String, Boolean> AiZ = new HashMap();

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onRequestGetMrsStrategy(byte[] bArr) {
        try {
            if (g.RK()) {
                synchronized (this) {
                    if (b.isRunning()) {
                        ab.i("Matrix.MrsCallbackImp", "NetSceneGetMrsStrategy is already running, just return");
                        return false;
                    }
                    ab.i("Matrix.MrsCallbackImp", "onRequestGetMrsStrategy, try to request mrs strategy");
                    g.RO().eJo.a(new b(bArr), 0);
                    return true;
                }
            }
            ab.e("Matrix.MrsCallbackImp", "onRequestGetMrsStrategy, account not ready");
            return false;
        } catch (Exception e) {
            ab.e("Matrix.MrsCallbackImp", "error: " + e.getMessage());
            return false;
        }
    }

    public final void onStrategyNotify(String str, boolean z) {
        c.i("Matrix.MrsCallbackImp", "onStrategyNotify, strategy: %s, isReportProcess; %b", str, Boolean.valueOf(z));
        if (!com.tencent.matrix.a.isInstalled() || !MatrixReport.isInstalled()) {
            return;
        }
        if (MatrixReport.with().isDebug()) {
            c.i("Matrix.MrsCallbackImp", "onStrategyNotify, matrix will report all for debug mode", new Object[0]);
            return;
        }
        this.AiZ.clear();
        HashMap hashMap = this.AiZ;
        if (TextUtils.isEmpty(str) || hashMap == null) {
            c.e("Matrix.MatrixUtil", "changeStrategyToMap, input params is illegal", new Object[0]);
        } else {
            for (String split : str.split(";")) {
                String[] split2 = split.split(",", 2);
                if (split2.length != 2) {
                    c.e("Matrix.MatrixUtil", "changeStrategyToMap, strategy format is illegal, value: %s", split);
                } else {
                    hashMap.put(split2[0].trim(), Boolean.valueOf(split2[1].trim().equals("1")));
                }
            }
        }
        Iterator it = com.tencent.matrix.a.yK().bUC.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            String tag = bVar.getTag();
            if (this.AiZ.containsKey(tag)) {
                boolean booleanValue = ((Boolean) this.AiZ.get(tag)).booleanValue();
                if (booleanValue && bVar.isPluginStoped()) {
                    c.w("Matrix.MrsCallbackImp", "matrix strategy change, try to turn on plugin %s", tag);
                    bVar.start();
                } else if (!booleanValue && bVar.isPluginStarted()) {
                    c.w("Matrix.MrsCallbackImp", "matrix strategy change, try to turn off plugin %s", tag);
                    bVar.stop();
                }
            }
        }
    }

    public final String getPublicSharePath() {
        try {
            File filesDir = ah.getContext().getFilesDir();
            if (!filesDir.exists()) {
                filesDir.createNewFile();
            }
            c.i("Matrix.MrsCallbackImp", "[TEST-PATH] getPublicSharePath, path: %s", filesDir.toString());
            return filesDir.toString() + "/mrs/";
        } catch (Exception e) {
            ab.e("Matrix.MrsCallbackImp", e.toString());
            return "";
        }
    }

    public final String getHost(MatrixUploadDataSlice matrixUploadDataSlice) {
        return "support.weixin.qq.com";
    }

    public final String getUrl(MatrixUploadDataSlice matrixUploadDataSlice) {
        StringBuilder append = new StringBuilder(512).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.vxo)).append("&devicetype=").append("android-" + VERSION.SDK_INT).append("&filelength=").append(matrixUploadDataSlice.getDataSize()).append("&sum=").append(com.tencent.mm.a.g.x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.vxo), Long.valueOf(matrixUploadDataSlice.getDataSize())}).getBytes()).toLowerCase());
        String Yz = (ah.bqo() && g.RK()) ? r.Yz() : null;
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
        return com.tencent.mm.a.g.x(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.vxo), Long.valueOf(matrixUploadDataSlice.getDataSize())}).getBytes()).toLowerCase();
    }
}
