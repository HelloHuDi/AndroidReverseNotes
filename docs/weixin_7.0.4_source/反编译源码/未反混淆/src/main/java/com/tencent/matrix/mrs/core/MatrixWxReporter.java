package com.tencent.matrix.mrs.core;

import com.tencent.matrix.a;
import com.tencent.matrix.b.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import org.json.JSONObject;

public class MatrixWxReporter {
    private static final int MATRIX_TRACE_ID_KEY = 1033;
    private static final String TAG = "MatrixWxReporter";
    private int MATRIX_TAG_REPORT_LOG_ID = 17108;

    public void report(String str, JSONObject jSONObject) {
        try {
            ab.i(TAG, "[report] tag:%s", str);
            if (a.isInstalled()) {
                String str2 = "";
                b bVar = null;
                if (str != null && str.startsWith("Trace")) {
                    bVar = a.yK().F(com.tencent.matrix.trace.a.class);
                }
                if (bVar != null) {
                    if (bVar instanceof com.tencent.matrix.trace.a) {
                        if (jSONObject.getString("tag").equalsIgnoreCase("Trace_EvilMethod")) {
                            str2 = jSONObject.getString("detail");
                            ab.i(TAG, "[report] _detail:%s", str2);
                            if (str2.equalsIgnoreCase(com.tencent.matrix.trace.b.a.a.ANR.toString())) {
                                e.pXa.a(1033, 0, 1, true);
                            } else if (str2.equalsIgnoreCase(com.tencent.matrix.trace.b.a.a.NORMAL.toString())) {
                                e.pXa.a(1033, 21, 1, true);
                            } else if (str2.equalsIgnoreCase(com.tencent.matrix.trace.b.a.a.STARTUP.toString())) {
                                e.pXa.a(1033, 11, 1, true);
                            }
                        }
                    } else if (bVar instanceof com.tencent.matrix.iocanary.a) {
                        e.pXa.a(1033, 30, 1, false);
                    } else if (bVar instanceof SQLiteLintPlugin) {
                        e.pXa.a(1033, 31, 1, false);
                    } else if (bVar instanceof com.tencent.matrix.a.a) {
                        e.pXa.a(1033, 32, 1, false);
                    } else if (bVar instanceof com.tencent.matrix.resource.b) {
                        e.pXa.a(1033, 33, 1, false);
                    }
                }
                h.pYm.e(this.MATRIX_TAG_REPORT_LOG_ID, str, Integer.valueOf(d.vxo), str2);
                return;
            }
            ab.i(TAG, "matrix not installed");
        } catch (Exception e) {
            ab.printErrStackTrace(TAG, e, "data:%s", jSONObject.toString());
        }
    }
}
