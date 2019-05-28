package com.tencent.matrix.resource;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.a;
import com.tencent.matrix.b.b;
import com.tencent.matrix.d.c;
import org.json.JSONObject;

public class CanaryResultService extends MatrixJobIntentService {
    public static void d(Context context, String str, String str2) {
        Intent intent = new Intent(context, CanaryResultService.class);
        intent.setAction("com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT");
        intent.putExtra("RESULT_PATH", str);
        intent.putExtra("RESULT_ACTIVITY", str2);
        MatrixJobIntentService.a(context, CanaryResultService.class, -84148994, intent);
    }

    /* Access modifiers changed, original: protected|final */
    public final void l(Intent intent) {
        if (intent != null) {
            if ("com.tencent.matrix.resource.result.action.REPORT_HPROF_RESULT".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("RESULT_PATH");
                String stringExtra2 = intent.getStringExtra("RESULT_ACTIVITY");
                if (stringExtra == null || stringExtra.isEmpty() || stringExtra2 == null || stringExtra2.isEmpty()) {
                    c.e("Matrix.CanaryResultService", "resultPath or activityName is null or empty, skip reporting.", new Object[0]);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultZipPath", stringExtra);
                    jSONObject.put("activity", stringExtra2);
                    b F = a.yK().F(b.class);
                    if (F != null) {
                        F.onDetectIssue(new com.tencent.matrix.c.b(jSONObject));
                    }
                } catch (Throwable th) {
                    c.printErrStackTrace("Matrix.CanaryResultService", th, "unexpected exception, skip reporting.", new Object[0]);
                }
            }
        }
    }
}
