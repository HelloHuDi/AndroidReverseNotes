package com.tencent.matrix.mrs.core;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.mrs.core.MrsLogic.PhoneInfo;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.p171b.C1135a.C1134a;
import com.tencent.mrs.util.MatrixReportBroadcast;
import com.tencent.mrs.util.MatrixStrategyNotifyBroadcast;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class MatrixReport {
    private static final String TAG = "Matrix.MatrixReport";
    private static IReportCallback mReportCallback;
    private static MrsCallback mrsCallback;
    private static volatile MatrixReport sInstance;
    private final long clientVersion;
    private final Context context;
    private final boolean isDebug;
    private final boolean isReportProcess;
    private final MatrixWxReporter matrixWxReporter;
    private final String processName;
    private final long publishType;
    private final String revision;
    private long uin;

    /* renamed from: com.tencent.matrix.mrs.core.MatrixReport$1 */
    class C10821 implements Runnable {
        C10821() {
        }

        public void run() {
            MatrixReport.checkStatusChange();
        }
    }

    public static class Builder {
        private Long clientVersion;
        private final Context context;
        private Boolean isDebug;
        private Boolean isReportProcess;
        private String processName;
        private Long publishType;
        private String revision;

        public Builder(Context context) {
            if (context == null) {
                throw new RuntimeException("matrix report init, context is null");
            }
            this.context = context;
        }

        public Builder clientVersion(long j) {
            this.clientVersion = Long.valueOf(j);
            return this;
        }

        public Builder revision(String str) {
            this.revision = str;
            return this;
        }

        public Builder isDebug(boolean z) {
            this.isDebug = Boolean.valueOf(z);
            return this;
        }

        public Builder isReportProcess(boolean z) {
            this.isReportProcess = Boolean.valueOf(z);
            return this;
        }

        public Builder processName(String str) {
            this.processName = str;
            return this;
        }

        public Builder publishType(long j) {
            this.publishType = Long.valueOf(j);
            return this;
        }

        public MatrixReport build() {
            if (this.processName == null) {
                throw new RuntimeException("matrix report init, processName is null");
            } else if (this.clientVersion == null) {
                throw new RuntimeException("matrix report init, clientVersion is null");
            } else if (this.revision == null) {
                throw new RuntimeException("matrix report init, revision is null");
            } else if (this.publishType == null) {
                throw new RuntimeException("matrix report init, publishType is null");
            } else {
                if (this.isDebug == null) {
                    this.isDebug = Boolean.FALSE;
                }
                if (this.isReportProcess == null) {
                    this.isReportProcess = Boolean.FALSE;
                }
                return new MatrixReport(this.context, this.processName, this.clientVersion.longValue(), this.revision, this.isDebug.booleanValue(), this.isReportProcess.booleanValue(), this.publishType.longValue(), null);
            }
        }
    }

    /* synthetic */ MatrixReport(Context context, String str, long j, String str2, boolean z, boolean z2, long j2, C10821 c10821) {
        this(context, str, j, str2, z, z2, j2);
    }

    private MatrixReport(Context context, String str, long j, String str2, boolean z, boolean z2, long j2) {
        this.uin = 0;
        this.clientVersion = j;
        this.revision = str2;
        this.isDebug = z;
        this.context = context;
        this.processName = str;
        this.isReportProcess = z2;
        this.publishType = j2;
        if (z2) {
            try {
                MrsLogic.init(j, str2, z, j2);
            } catch (Throwable th) {
                C1070c.printErrStackTrace(TAG, th, "call oncreate err", new Object[0]);
                MrsLogic.init(j, str2, z, j2);
            }
        } else {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("strategyNotify");
            context.registerReceiver(new MatrixStrategyNotifyBroadcast(), intentFilter, "com.tencent.mm.matrix.strategynotify", null);
        }
        this.matrixWxReporter = new MatrixWxReporter();
    }

    public static void setMrsCallback(MrsCallback mrsCallback) {
        mrsCallback = mrsCallback;
        MrsLogic.setCallBack(mrsCallback);
    }

    public static boolean isInstalled() {
        return sInstance != null;
    }

    public static MatrixReport init(MatrixReport matrixReport, IReportCallback iReportCallback) {
        if (matrixReport == null) {
            throw new RuntimeException("Matrix report init, matrixReport should not be null.");
        }
        synchronized (MatrixReport.class) {
            if (sInstance == null) {
                sInstance = matrixReport;
            } else {
                C1070c.m2367e(TAG, "Matrix report instance is already set. this invoking will be ignored", new Object[0]);
            }
        }
        mReportCallback = iReportCallback;
        return sInstance;
    }

    private static void checkStatusChange() {
        C1070c.m2368i(TAG, "schedule to check", new Object[0]);
        if (!C1060a.isInstalled()) {
            C1070c.m2368i(TAG, "matrix not installed", new Object[0]);
        } else if (mReportCallback != null) {
            HashMap hashMap = new HashMap();
            Iterator it = C1060a.m2339yK().bUC.iterator();
            while (it.hasNext()) {
                C6283b c6283b = (C6283b) it.next();
                if (c6283b instanceof C7466a) {
                    hashMap.put("Trace_FPS", Boolean.valueOf(MrsLogic.isNeed2Report("Trace_FPS")));
                    hashMap.put("Trace_EvilMethod", Boolean.valueOf(MrsLogic.isNeed2Report("Trace_EvilMethod")));
                    hashMap.put("Trace_StartUp", Boolean.valueOf(MrsLogic.isNeed2Report("Trace_StartUp")));
                } else {
                    hashMap.put(c6283b.getTag(), Boolean.valueOf(MrsLogic.isNeed2Report(c6283b.getTag())));
                }
            }
            if (hashMap.size() > 0) {
                C1070c.m2368i(TAG, "onStatusChange, map:%s", hashMap);
                if (mReportCallback != null) {
                    mReportCallback.onStatusChanged(hashMap);
                }
            }
        }
    }

    public boolean isNeedReport(String str) {
        return MrsLogic.isNeed2Report(str);
    }

    public static MatrixReport with() {
        if (sInstance != null) {
            return sInstance;
        }
        throw new RuntimeException("you must init Matrix report sdk first");
    }

    public static MrsCallback getMrsCallback() {
        return mrsCallback;
    }

    public void onDestroy() {
        if (this.isReportProcess) {
            MrsLogic.onDestroy();
        }
    }

    public void onCrash() {
        if (this.isReportProcess) {
            MrsLogic.onCrash();
        }
    }

    public void onForeground(boolean z) {
        if (this.isReportProcess) {
            MrsLogic.onForeground(z);
        }
        if (!z) {
            C7305d.xDG.mo10151b(new C10821(), TAG);
        }
    }

    public void report(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            try {
                C1070c.m2367e(TAG, "Matrix report, tag %s or data %s is null, just return", str, jSONObject);
            } catch (Throwable th) {
                C1070c.m2367e(TAG, "Matrix report occur error:".concat(String.valueOf(th)), new Object[0]);
            }
        } else if (this.isReportProcess) {
            with().reportLocal(str, jSONObject.toString());
        } else {
            Intent intent = new Intent(this.context, MatrixReportBroadcast.class);
            intent.putExtra("tag", str);
            intent.putExtra("value", jSONObject.toString());
            C1070c.m2368i(TAG, "Matrix report with broadcast tag:%s, data:%s", str, jSONObject.toString());
            this.context.sendBroadcast(intent);
        }
    }

    public void report(C1062b c1062b, File file) {
        report(c1062b, file, true);
    }

    public void report(C1062b c1062b, File file, boolean z) {
        if (!(c1062b == null || file == null)) {
            try {
                if (file.exists()) {
                    MatrixUploadIssue matrixUploadIssue = new MatrixUploadIssue();
                    matrixUploadIssue.setTag(c1062b.tag);
                    matrixUploadIssue.setCanSplitSlice(true);
                    matrixUploadIssue.setDataType(1);
                    matrixUploadIssue.setNeedDeleteFileAfterSucc(z);
                    matrixUploadIssue.setType(c1062b.bWu != null ? c1062b.bWu.intValue() : 0);
                    matrixUploadIssue.setDesKey(c1062b.key);
                    matrixUploadIssue.setFilePath(file.getAbsolutePath());
                    MrsLogic.uploadMatrixIssue(matrixUploadIssue);
                    return;
                }
            } catch (Throwable th) {
                C1070c.m2367e(TAG, "Matrix report occur error:".concat(String.valueOf(th)), new Object[0]);
                return;
            }
        }
        C1070c.m2367e(TAG, "Matrix report, tag %s or file %s is null, just return", c1062b, file);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reportLocal(String str, String str2) {
        boolean z;
        Throwable e;
        if (str == null || str2 == null) {
            C1070c.m2367e(TAG, "Matrix reportLocal, tag %s or data %s is null, just return", str, str2);
        } else if (this.isReportProcess) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject(str2);
                try {
                    boolean z2 = (jSONObject.getString("tag").equalsIgnoreCase("Trace_EvilMethod") && jSONObject.getString("detail").equalsIgnoreCase(C1134a.ANR.toString())) ? !C5046bo.isNullOrNil(jSONObject.getString("stackKey")) : true;
                    z = z2;
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = jSONObject;
                    C4990ab.printErrStackTrace(TAG, e, "data:%s", jSONObject2.toString());
                    jSONObject = jSONObject2;
                    z = true;
                    C1070c.m2368i(TAG, "Matrix reportLocal tag:%s, data:%s ClientVersion:%s isRealReportForMatrix:%s", str, str2, Integer.valueOf(C7243d.vxo), Boolean.valueOf(z));
                    if (z) {
                    }
                    this.matrixWxReporter.report(str, jSONObject);
                }
            } catch (JSONException e3) {
                e = e3;
                C4990ab.printErrStackTrace(TAG, e, "data:%s", jSONObject2.toString());
                jSONObject = jSONObject2;
                z = true;
                C1070c.m2368i(TAG, "Matrix reportLocal tag:%s, data:%s ClientVersion:%s isRealReportForMatrix:%s", str, str2, Integer.valueOf(C7243d.vxo), Boolean.valueOf(z));
                if (z) {
                }
                this.matrixWxReporter.report(str, jSONObject);
            }
            C1070c.m2368i(TAG, "Matrix reportLocal tag:%s, data:%s ClientVersion:%s isRealReportForMatrix:%s", str, str2, Integer.valueOf(C7243d.vxo), Boolean.valueOf(z));
            if (z) {
                MrsLogic.collectData(str, str2.getBytes());
            }
            this.matrixWxReporter.report(str, jSONObject);
        } else {
            C1070c.m2367e(TAG, "Matrix reportLocal, only report process can report directly, current:%s", this.processName);
        }
    }

    public void setUin(long j) {
        this.uin = j;
        if (this.isReportProcess) {
            MrsLogic.setUin(j);
        }
    }

    public PhoneInfo getPhoneInfo() {
        return MrsLogic.getPhoneInfo();
    }

    public void onStrategyResp(int i, int i2, byte[] bArr) {
        MrsLogic.onStrategyResp(i, i2, bArr);
    }

    public long getClientVersion() {
        return this.clientVersion;
    }

    public String getRevision() {
        return this.revision;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public long getUin() {
        return this.uin;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean isReportProcess() {
        return this.isReportProcess;
    }

    public String getProcessName() {
        return this.processName;
    }

    public long getPublishType() {
        return this.publishType;
    }
}
