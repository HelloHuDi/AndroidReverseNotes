package com.tencent.p177mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.i */
public final class C42614i {
    static int ijV = 112;
    private static Object ijW;
    private static Handler ijX;

    /* renamed from: cR */
    public static void m75453cR(Context context) {
        AppMethodBeat.m2504i(132078);
        try {
            Handler bx = C42614i.m75452bx(C42614i.m75454cS(context));
            Field declaredField = bx.getClass().getDeclaredField("NEW_INTENT");
            declaredField.setAccessible(true);
            ijV = ((Integer) declaredField.get(bx)).intValue();
            AppMethodBeat.m2505o(132078);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hack constants in ActivityThread$H", new Object[0]);
            AppMethodBeat.m2505o(132078);
        }
    }

    /* renamed from: bx */
    private static Handler m75452bx(Object obj) {
        AppMethodBeat.m2504i(132079);
        Handler handler;
        if (ijX != null) {
            handler = ijX;
            AppMethodBeat.m2505o(132079);
            return handler;
        }
        Field declaredField = obj.getClass().getDeclaredField("mH");
        declaredField.setAccessible(true);
        handler = (Handler) declaredField.get(obj);
        ijX = handler;
        AppMethodBeat.m2505o(132079);
        return handler;
    }

    /* renamed from: cS */
    private static Object m75454cS(Context context) {
        AppMethodBeat.m2504i(132080);
        Object obj;
        if (ijW != null) {
            obj = ijW;
            AppMethodBeat.m2505o(132080);
            return obj;
        }
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        obj = method.invoke(null, new Object[0]);
        if (obj != null) {
            ijW = obj;
            AppMethodBeat.m2505o(132080);
            return obj;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        obj = field.get(context);
        Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        obj = declaredField.get(obj);
        ijW = obj;
        AppMethodBeat.m2505o(132080);
        return obj;
    }

    /* renamed from: pb */
    static boolean m75455pb(int i) {
        Handler bx;
        AppMethodBeat.m2504i(132081);
        try {
            bx = C42614i.m75452bx(C42614i.m75454cS(C4996ah.getContext()));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hasPendingMessageInQueue, hack mH", new Object[0]);
            bx = null;
        }
        if (bx == null) {
            AppMethodBeat.m2505o(132081);
            return false;
        }
        boolean hasMessages = bx.hasMessages(i);
        AppMethodBeat.m2505o(132081);
        return hasMessages;
    }
}
