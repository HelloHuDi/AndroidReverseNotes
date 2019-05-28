package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.C1060a;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p157d.C1070c;
import org.json.JSONObject;

public class CanaryResultService extends MatrixJobIntentService {
    /* renamed from: d */
    public static void m10299d(Context context, String str, String str2) {
        Intent intent = new Intent(context, CanaryResultService.class);
        intent.setAction("com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT");
        intent.putExtra("RESULT_PATH", str);
        intent.putExtra("RESULT_ACTIVITY", str2);
        MatrixJobIntentService.m2396a(context, CanaryResultService.class, -84148994, intent);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: l */
    public final void mo4290l(Intent intent) {
        if (intent != null) {
            if ("com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("RESULT_PATH");
                String stringExtra2 = intent.getStringExtra("RESULT_ACTIVITY");
                if (stringExtra == null || stringExtra.isEmpty() || stringExtra2 == null || stringExtra2.isEmpty()) {
                    C1070c.m2367e("Matrix.CanaryResultService", "resultPath or activityName is null or empty, skip reporting.", new Object[0]);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultZipPath", stringExtra);
                    jSONObject.put("activity", stringExtra2);
                    C6283b F = C1060a.m2339yK().mo4192F(C7464b.class);
                    if (F != null) {
                        F.onDetectIssue(new C1062b(jSONObject));
                    }
                } catch (Throwable th) {
                    C1070c.printErrStackTrace("Matrix.CanaryResultService", th, "unexpected exception, skip reporting.", new Object[0]);
                }
            }
        }
    }
}
