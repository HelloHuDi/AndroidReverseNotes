package com.tencent.tinker.lib.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.util.TinkerJobIntentService;
import com.tencent.tinker.lib.util.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;

public abstract class AbstractResultService extends TinkerJobIntentService {
    public abstract void a(a aVar);

    public static void a(Context context, a aVar, String str) {
        if (str == null) {
            throw new TinkerRuntimeException("resultServiceClass is null.");
        }
        try {
            if (TinkerJobIntentService.class.isAssignableFrom(Class.forName(str))) {
                try {
                    Intent intent = new Intent();
                    intent.setClassName(context, str);
                    intent.putExtra("result_extra", aVar);
                    TinkerJobIntentService.a(context, new ComponentName(context, str), -202050058, intent);
                    return;
                } catch (Throwable th) {
                    a.e("Tinker.AbstractResultService", "run result service fail, exception:".concat(String.valueOf(th)), new Object[0]);
                    return;
                }
            }
            throw new TinkerRuntimeException("on tinker version 1.9.10 result service class must inherit from TinkerJobIntentService.");
        } catch (ClassNotFoundException e) {
            throw new TinkerRuntimeException("cannot find result service class: ".concat(String.valueOf(str)), e);
        }
    }

    public final void l(Intent intent) {
        if (intent == null) {
            a.e("Tinker.AbstractResultService", "AbstractResultService received a null intent, ignoring.", new Object[0]);
        } else {
            a((a) ShareIntentUtil.u(intent, "result_extra"));
        }
    }
}
