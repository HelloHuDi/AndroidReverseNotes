package com.tencent.mrs.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.d.c;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.sdk.platformtools.w;

public class MatrixStrategyNotifyBroadcast extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            c.e("Matrix.StrategyNotifyBroadcast", "MatrixStrategyNotifyBroadcast intent == null", new Object[0]);
            return;
        }
        String n = w.n(intent, "strategy");
        c.i("Matrix.StrategyNotifyBroadcast", "receive MatrixStrategyNotifyBroadcast, process: %s, strategy:%s", MatrixReport.with().getProcessName(), n);
        if (!TextUtils.isEmpty(n)) {
            MatrixReport.getMrsCallback().onStrategyNotify(n, false);
        }
    }
}
