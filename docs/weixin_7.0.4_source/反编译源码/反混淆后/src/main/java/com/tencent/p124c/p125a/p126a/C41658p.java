package com.tencent.p124c.p125a.p126a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

/* renamed from: com.tencent.c.a.a.p */
public class C41658p {
    private static volatile C41658p cbH = null;
    private boolean cbI = false;
    private Context context = null;

    /* renamed from: u */
    public final boolean mo67142u(String str, String str2) {
        AppMethodBeat.m2504i(125721);
        if (this.cbI) {
            try {
                boolean putString = System.putString(this.context.getContentResolver(), str, str2);
                AppMethodBeat.m2505o(125721);
                return putString;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(125721);
        return false;
    }

    private C41658p(Context context) {
        AppMethodBeat.m2504i(125722);
        this.context = context.getApplicationContext();
        this.cbI = C0916s.m2087q(this.context, "android.permission.WRITE_SETTINGS");
        if (VERSION.SDK_INT >= 23) {
            try {
                Method declaredMethod = System.class.getDeclaredMethod("canWrite", new Class[]{Context.class});
                declaredMethod.setAccessible(true);
                this.cbI = ((Boolean) declaredMethod.invoke(null, new Object[]{this.context})).booleanValue();
                AppMethodBeat.m2505o(125722);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(125722);
    }

    /* renamed from: aH */
    public static C41658p m73052aH(Context context) {
        AppMethodBeat.m2504i(125723);
        if (cbH == null) {
            synchronized (C41658p.class) {
                try {
                    if (cbH == null) {
                        cbH = new C41658p(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(125723);
                    }
                }
            }
        }
        C41658p c41658p = cbH;
        AppMethodBeat.m2505o(125723);
        return c41658p;
    }
}
