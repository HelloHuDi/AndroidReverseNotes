package com.tencent.mrs.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.p177mm.sdk.platformtools.C5068w;

public class MatrixStrategyNotifyBroadcast extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C1070c.m2367e("Matrix.StrategyNotifyBroadcast", "MatrixStrategyNotifyBroadcast intent == null", new Object[0]);
            return;
        }
        String n = C5068w.m7689n(intent, "strategy");
        C1070c.m2368i("Matrix.StrategyNotifyBroadcast", "receive MatrixStrategyNotifyBroadcast, process: %s, strategy:%s", MatrixReport.with().getProcessName(), n);
        if (!TextUtils.isEmpty(n)) {
            MatrixReport.getMrsCallback().onStrategyNotify(n, false);
        }
    }
}
