package com.tencent.p659pb.common.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.p139g.C0938f;
import com.tencent.p139g.p809a.C37343a;
import com.tencent.p659pb.common.p1102c.C44443c;
import com.tencent.p659pb.common.p660b.C44440g;
import com.tencent.p659pb.common.p660b.C44441h;

/* renamed from: com.tencent.pb.common.system.ConnectReceiver */
public class ConnectReceiver extends BroadcastReceiver {
    private static C44440g ApS = null;

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction() != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (ApS == null) {
                        ApS = new C44440g();
                    }
                    boolean isNetworkConnected = C44441h.isNetworkConnected();
                    C37343a c37343a = (C37343a) C0938f.aux("EventCenter");
                    if (ApS.mo70374Il() && c37343a != null) {
                        if (isNetworkConnected) {
                            c37343a.mo60056c("GLOBAL_TOPIC_NETWORK_CHANGE", 21, null);
                        } else {
                            c37343a.mo60056c("GLOBAL_TOPIC_NETWORK_CHANGE", 33, null);
                        }
                    }
                }
            } catch (Throwable th) {
                C44443c.m80392w("ConnectReceiver", "onReceive", th);
            }
        }
    }
}
