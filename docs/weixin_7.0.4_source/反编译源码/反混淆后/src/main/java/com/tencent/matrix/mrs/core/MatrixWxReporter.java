package com.tencent.matrix.mrs.core;

import com.tencent.matrix.C1060a;
import com.tencent.matrix.iocanary.C7463a;
import com.tencent.matrix.p151a.C7462a;
import com.tencent.matrix.p155b.C6283b;
import com.tencent.matrix.resource.C7464b;
import com.tencent.matrix.trace.C7466a;
import com.tencent.matrix.trace.p171b.C1135a.C1134a;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import org.json.JSONObject;

public class MatrixWxReporter {
    private static final int MATRIX_TRACE_ID_KEY = 1033;
    private static final String TAG = "MatrixWxReporter";
    private int MATRIX_TAG_REPORT_LOG_ID = 17108;

    public void report(String str, JSONObject jSONObject) {
        try {
            C4990ab.m7417i(TAG, "[report] tag:%s", str);
            if (C1060a.isInstalled()) {
                String str2 = "";
                C6283b c6283b = null;
                if (str != null && str.startsWith("Trace")) {
                    c6283b = C1060a.m2339yK().mo4192F(C7466a.class);
                }
                if (c6283b != null) {
                    if (c6283b instanceof C7466a) {
                        if (jSONObject.getString("tag").equalsIgnoreCase("Trace_EvilMethod")) {
                            str2 = jSONObject.getString("detail");
                            C4990ab.m7417i(TAG, "[report] _detail:%s", str2);
                            if (str2.equalsIgnoreCase(C1134a.ANR.toString())) {
                                C7053e.pXa.mo8378a(1033, 0, 1, true);
                            } else if (str2.equalsIgnoreCase(C1134a.NORMAL.toString())) {
                                C7053e.pXa.mo8378a(1033, 21, 1, true);
                            } else if (str2.equalsIgnoreCase(C1134a.STARTUP.toString())) {
                                C7053e.pXa.mo8378a(1033, 11, 1, true);
                            }
                        }
                    } else if (c6283b instanceof C7463a) {
                        C7053e.pXa.mo8378a(1033, 30, 1, false);
                    } else if (c6283b instanceof SQLiteLintPlugin) {
                        C7053e.pXa.mo8378a(1033, 31, 1, false);
                    } else if (c6283b instanceof C7462a) {
                        C7053e.pXa.mo8378a(1033, 32, 1, false);
                    } else if (c6283b instanceof C7464b) {
                        C7053e.pXa.mo8378a(1033, 33, 1, false);
                    }
                }
                C7060h.pYm.mo8381e(this.MATRIX_TAG_REPORT_LOG_ID, str, Integer.valueOf(C7243d.vxo), str2);
                return;
            }
            C4990ab.m7416i(TAG, "matrix not installed");
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "data:%s", jSONObject.toString());
        }
    }
}
