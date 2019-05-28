package com.tencent.tinker.lib.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.lib.util.TinkerJobIntentService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;

public abstract class AbstractResultService extends TinkerJobIntentService {
    /* renamed from: a */
    public abstract void mo33931a(C46819a c46819a);

    /* renamed from: a */
    public static void m71514a(Context context, C46819a c46819a, String str) {
        if (str == null) {
            throw new TinkerRuntimeException("resultServiceClass is null.");
        }
        try {
            if (TinkerJobIntentService.class.isAssignableFrom(Class.forName(str))) {
                try {
                    Intent intent = new Intent();
                    intent.setClassName(context, str);
                    intent.putExtra("result_extra", c46819a);
                    TinkerJobIntentService.m9262a(context, new ComponentName(context, str), -202050058, intent);
                    return;
                } catch (Throwable th) {
                    C5952a.m9283e("Tinker.AbstractResultService", "run result service fail, exception:".concat(String.valueOf(th)), new Object[0]);
                    return;
                }
            }
            throw new TinkerRuntimeException("on tinker version 1.9.10 result service class must inherit from TinkerJobIntentService.");
        } catch (ClassNotFoundException e) {
            throw new TinkerRuntimeException("cannot find result service class: ".concat(String.valueOf(str)), e);
        }
    }

    /* renamed from: l */
    public final void mo12631l(Intent intent) {
        if (intent == null) {
            C5952a.m9283e("Tinker.AbstractResultService", "AbstractResultService received a null intent, ignoring.", new Object[0]);
        } else {
            mo33931a((C46819a) ShareIntentUtil.m9363u(intent, "result_extra"));
        }
    }
}
