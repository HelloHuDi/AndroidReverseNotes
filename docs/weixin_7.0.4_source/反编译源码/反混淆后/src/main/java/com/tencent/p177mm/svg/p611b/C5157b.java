package com.tencent.p177mm.svg.p611b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.svg.b.b */
public final class C5157b {
    private static boolean eMP = false;
    private static String mPackageName = "";
    private static boolean ydt = false;
    private static boolean ydu = false;

    /* renamed from: cY */
    public static void m7860cY(String str) {
        mPackageName = str;
    }

    public static final boolean dvJ() {
        return ydu;
    }

    /* renamed from: pu */
    public static final void m7862pu(boolean z) {
        ydu = z;
    }

    private static final Object aqy(String str) {
        AppMethodBeat.m2504i(70123);
        try {
            Class cls = Class.forName(mPackageName + ".svg.SVGBuildConfig");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            AppMethodBeat.m2505o(70123);
            return obj;
        } catch (NoSuchFieldException e) {
            C5159c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e, "NoSuchFieldException", new Object[0]);
            AppMethodBeat.m2505o(70123);
            return null;
        } catch (IllegalArgumentException e2) {
            C5159c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e2, "IllegalArgumentException", new Object[0]);
            AppMethodBeat.m2505o(70123);
            return null;
        } catch (ClassNotFoundException e3) {
            C5159c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e3, "ClassNotFoundException", new Object[0]);
            AppMethodBeat.m2505o(70123);
            return null;
        } catch (IllegalAccessException e4) {
            C5159c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e4, "IllegalAccessException", new Object[0]);
            AppMethodBeat.m2505o(70123);
            return null;
        }
    }

    public static final Class<?> dvL() {
        AppMethodBeat.m2504i(70125);
        Object aqy = C5157b.aqy("WxSVGRawClass");
        if (aqy != null) {
            Class cls = (Class) aqy;
            AppMethodBeat.m2505o(70125);
            return cls;
        }
        AppMethodBeat.m2505o(70125);
        return null;
    }

    public static long dvM() {
        AppMethodBeat.m2504i(70126);
        long nanoTime = System.nanoTime();
        AppMethodBeat.m2505o(70126);
        return nanoTime;
    }

    /* renamed from: mW */
    public static long m7861mW(long j) {
        AppMethodBeat.m2504i(70127);
        long nanoTime = (System.nanoTime() - j) / 1000;
        AppMethodBeat.m2505o(70127);
        return nanoTime;
    }

    public static final boolean dvK() {
        AppMethodBeat.m2504i(70124);
        if (!eMP) {
            Object aqy = C5157b.aqy("WxSVGCode");
            if (aqy == null) {
                ydt = false;
            } else {
                ydt = ((Boolean) aqy).booleanValue();
            }
            C5159c.m7869i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", Boolean.valueOf(ydt));
            eMP = true;
        }
        if (ydt) {
            AppMethodBeat.m2505o(70124);
            return false;
        }
        AppMethodBeat.m2505o(70124);
        return true;
    }
}
