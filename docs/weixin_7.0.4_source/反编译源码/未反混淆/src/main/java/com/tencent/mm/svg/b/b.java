package com.tencent.mm.svg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class b {
    private static boolean eMP = false;
    private static String mPackageName = "";
    private static boolean ydt = false;
    private static boolean ydu = false;

    public static void cY(String str) {
        mPackageName = str;
    }

    public static final boolean dvJ() {
        return ydu;
    }

    public static final void pu(boolean z) {
        ydu = z;
    }

    private static final Object aqy(String str) {
        AppMethodBeat.i(70123);
        try {
            Class cls = Class.forName(mPackageName + ".svg.SVGBuildConfig");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            AppMethodBeat.o(70123);
            return obj;
        } catch (NoSuchFieldException e) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e, "NoSuchFieldException", new Object[0]);
            AppMethodBeat.o(70123);
            return null;
        } catch (IllegalArgumentException e2) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e2, "IllegalArgumentException", new Object[0]);
            AppMethodBeat.o(70123);
            return null;
        } catch (ClassNotFoundException e3) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e3, "ClassNotFoundException", new Object[0]);
            AppMethodBeat.o(70123);
            return null;
        } catch (IllegalAccessException e4) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e4, "IllegalAccessException", new Object[0]);
            AppMethodBeat.o(70123);
            return null;
        }
    }

    public static final Class<?> dvL() {
        AppMethodBeat.i(70125);
        Object aqy = aqy("WxSVGRawClass");
        if (aqy != null) {
            Class cls = (Class) aqy;
            AppMethodBeat.o(70125);
            return cls;
        }
        AppMethodBeat.o(70125);
        return null;
    }

    public static long dvM() {
        AppMethodBeat.i(70126);
        long nanoTime = System.nanoTime();
        AppMethodBeat.o(70126);
        return nanoTime;
    }

    public static long mW(long j) {
        AppMethodBeat.i(70127);
        long nanoTime = (System.nanoTime() - j) / 1000;
        AppMethodBeat.o(70127);
        return nanoTime;
    }

    public static final boolean dvK() {
        AppMethodBeat.i(70124);
        if (!eMP) {
            Object aqy = aqy("WxSVGCode");
            if (aqy == null) {
                ydt = false;
            } else {
                ydt = ((Boolean) aqy).booleanValue();
            }
            c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", Boolean.valueOf(ydt));
            eMP = true;
        }
        if (ydt) {
            AppMethodBeat.o(70124);
            return false;
        }
        AppMethodBeat.o(70124);
        return true;
    }
}
