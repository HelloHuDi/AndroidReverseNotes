package com.tencent.pb.common.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.g.a.a;
import com.tencent.g.f;
import com.tencent.pb.common.b.g;
import com.tencent.pb.common.b.h;
import com.tencent.pb.common.c.c;

public class ConnectReceiver extends BroadcastReceiver {
    private static g ApS = null;

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction() != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (ApS == null) {
                        ApS = new g();
                    }
                    boolean isNetworkConnected = h.isNetworkConnected();
                    a aVar = (a) f.aux("EventCenter");
                    if (ApS.Il() && aVar != null) {
                        if (isNetworkConnected) {
                            aVar.c("GLOBAL_TOPIC_NETWORK_CHANGE", 21, null);
                        } else {
                            aVar.c("GLOBAL_TOPIC_NETWORK_CHANGE", 33, null);
                        }
                    }
                }
            } catch (Throwable th) {
                c.w("ConnectReceiver", "onReceive", th);
            }
        }
    }
}
