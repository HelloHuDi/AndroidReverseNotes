package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import java.util.HashMap;
import java.util.Map;

public final class WWAPIImpl implements IWWAPI {
    private BroadcastReceiver ALA = new C163811();
    private String ALz;
    private Map<String, Object> callbacks = new HashMap();
    private Context context;

    /* renamed from: com.tencent.wework.api.WWAPIImpl$1 */
    class C163811 extends BroadcastReceiver {
        C163811() {
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(80492);
            try {
                if (WWAPIImpl.this.ALz.equals(intent.getScheme())) {
                    final BaseMessage x = BaseMessage.m25209x(intent.getData());
                    if (x instanceof WWBaseRespMessage) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                AppMethodBeat.m2504i(80491);
                                try {
                                    WWAPIImpl.this.callbacks.get(((WWBaseRespMessage) x).transaction);
                                    WWAPIImpl.this.callbacks.remove(((WWBaseRespMessage) x).transaction);
                                    AppMethodBeat.m2505o(80491);
                                } catch (Throwable th) {
                                    AppMethodBeat.m2505o(80491);
                                }
                            }
                        });
                    }
                    AppMethodBeat.m2505o(80492);
                    return;
                }
                AppMethodBeat.m2505o(80492);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(80492);
            }
        }
    }

    public WWAPIImpl(Context context) {
        AppMethodBeat.m2504i(80493);
        this.context = context;
        AppMethodBeat.m2505o(80493);
    }

    public final boolean dTK() {
        AppMethodBeat.m2504i(80494);
        if (dTL() >= 100) {
            AppMethodBeat.m2505o(80494);
            return true;
        }
        AppMethodBeat.m2505o(80494);
        return false;
    }

    private int dTL() {
        int i = 0;
        AppMethodBeat.m2504i(80495);
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.wework", 128);
            if (packageInfo == null) {
                AppMethodBeat.m2505o(80495);
            } else {
                i = packageInfo.versionCode;
                AppMethodBeat.m2505o(80495);
            }
        } catch (Throwable th) {
            AppMethodBeat.m2505o(80495);
        }
        return i;
    }

    /* renamed from: a */
    public final boolean mo13198a(BaseMessage baseMessage) {
        AppMethodBeat.m2504i(80496);
        Intent intent = new Intent("com.tencent.wework.apihost");
        intent.setClassName("com.tencent.wework", "com.tencent.wework.apihost.WWAPIActivity");
        intent.addFlags(411041792);
        try {
            baseMessage.setContext(this.context);
            intent.putExtras(BaseMessage.m25208b(baseMessage));
            intent.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.ALA.getClass()), 134217728));
            this.context.startActivity(intent);
            AppMethodBeat.m2505o(80496);
            return true;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(80496);
            return false;
        }
    }
}
