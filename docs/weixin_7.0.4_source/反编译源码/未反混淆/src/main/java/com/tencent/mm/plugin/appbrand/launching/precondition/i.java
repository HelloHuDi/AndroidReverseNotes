package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class i {
    static int ijV = 112;
    private static Object ijW;
    private static Handler ijX;

    public static void cR(Context context) {
        AppMethodBeat.i(132078);
        try {
            Handler bx = bx(cS(context));
            Field declaredField = bx.getClass().getDeclaredField("NEW_INTENT");
            declaredField.setAccessible(true);
            ijV = ((Integer) declaredField.get(bx)).intValue();
            AppMethodBeat.o(132078);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hack constants in ActivityThread$H", new Object[0]);
            AppMethodBeat.o(132078);
        }
    }

    private static Handler bx(Object obj) {
        AppMethodBeat.i(132079);
        Handler handler;
        if (ijX != null) {
            handler = ijX;
            AppMethodBeat.o(132079);
            return handler;
        }
        Field declaredField = obj.getClass().getDeclaredField("mH");
        declaredField.setAccessible(true);
        handler = (Handler) declaredField.get(obj);
        ijX = handler;
        AppMethodBeat.o(132079);
        return handler;
    }

    private static Object cS(Context context) {
        AppMethodBeat.i(132080);
        Object obj;
        if (ijW != null) {
            obj = ijW;
            AppMethodBeat.o(132080);
            return obj;
        }
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        obj = method.invoke(null, new Object[0]);
        if (obj != null) {
            ijW = obj;
            AppMethodBeat.o(132080);
            return obj;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        obj = field.get(context);
        Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        obj = declaredField.get(obj);
        ijW = obj;
        AppMethodBeat.o(132080);
        return obj;
    }

    static boolean pb(int i) {
        Handler bx;
        AppMethodBeat.i(132081);
        try {
            bx = bx(cS(ah.getContext()));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.AppBrand.PreconditionActivityThreadHack", e, "hasPendingMessageInQueue, hack mH", new Object[0]);
            bx = null;
        }
        if (bx == null) {
            AppMethodBeat.o(132081);
            return false;
        }
        boolean hasMessages = bx.hasMessages(i);
        AppMethodBeat.o(132081);
        return hasMessages;
    }
}
