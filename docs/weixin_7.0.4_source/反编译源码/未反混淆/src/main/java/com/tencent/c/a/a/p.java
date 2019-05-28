package com.tencent.c.a.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public class p {
    private static volatile p cbH = null;
    private boolean cbI = false;
    private Context context = null;

    public final boolean u(String str, String str2) {
        AppMethodBeat.i(125721);
        if (this.cbI) {
            try {
                boolean putString = System.putString(this.context.getContentResolver(), str, str2);
                AppMethodBeat.o(125721);
                return putString;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(125721);
        return false;
    }

    private p(Context context) {
        AppMethodBeat.i(125722);
        this.context = context.getApplicationContext();
        this.cbI = s.q(this.context, "android.permission.WRITE_SETTINGS");
        if (VERSION.SDK_INT >= 23) {
            try {
                Method declaredMethod = System.class.getDeclaredMethod("canWrite", new Class[]{Context.class});
                declaredMethod.setAccessible(true);
                this.cbI = ((Boolean) declaredMethod.invoke(null, new Object[]{this.context})).booleanValue();
                AppMethodBeat.o(125722);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(125722);
    }

    public static p aH(Context context) {
        AppMethodBeat.i(125723);
        if (cbH == null) {
            synchronized (p.class) {
                try {
                    if (cbH == null) {
                        cbH = new p(context);
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(125723);
                    }
                }
            }
        }
        p pVar = cbH;
        AppMethodBeat.o(125723);
        return pVar;
    }
}
