package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.io.IOException;

/* renamed from: com.eclipsesource.a.a */
public final class C25470a {
    public static final C0803h aLi = new C45008c(BuildConfig.COMMAND);
    public static final C0803h aLj = new C45008c("true");
    public static final C0803h aLk = new C45008c("false");

    static {
        AppMethodBeat.m2504i(70496);
        AppMethodBeat.m2505o(70496);
    }

    /* renamed from: dr */
    public static C0803h m40252dr(int i) {
        AppMethodBeat.m2504i(70489);
        C37207d c37207d = new C37207d(Integer.toString(i, 10));
        AppMethodBeat.m2505o(70489);
        return c37207d;
    }

    /* renamed from: t */
    public static C0803h m40254t(long j) {
        AppMethodBeat.m2504i(70490);
        C37207d c37207d = new C37207d(Long.toString(j, 10));
        AppMethodBeat.m2505o(70490);
        return c37207d;
    }

    /* renamed from: T */
    public static C0803h m40247T(float f) {
        AppMethodBeat.m2504i(70491);
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
            AppMethodBeat.m2505o(70491);
            throw illegalArgumentException;
        }
        C37207d c37207d = new C37207d(C25470a.m40251ai(Float.toString(f)));
        AppMethodBeat.m2505o(70491);
        return c37207d;
    }

    /* renamed from: m */
    public static C0803h m40253m(double d) {
        AppMethodBeat.m2504i(70492);
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
            AppMethodBeat.m2505o(70492);
            throw illegalArgumentException;
        }
        C37207d c37207d = new C37207d(C25470a.m40251ai(Double.toString(d)));
        AppMethodBeat.m2505o(70492);
        return c37207d;
    }

    /* renamed from: ag */
    public static C0803h m40249ag(String str) {
        AppMethodBeat.m2504i(70493);
        C0803h c0803h;
        if (str == null) {
            c0803h = aLi;
            AppMethodBeat.m2505o(70493);
            return c0803h;
        }
        c0803h = new C8570g(str);
        AppMethodBeat.m2505o(70493);
        return c0803h;
    }

    /* renamed from: aB */
    public static C0803h m40248aB(boolean z) {
        return z ? aLj : aLk;
    }

    /* renamed from: ah */
    public static C0803h m40250ah(String str) {
        AppMethodBeat.m2504i(70494);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("string is null");
            AppMethodBeat.m2505o(70494);
            throw nullPointerException;
        }
        try {
            C8569f c8569f = new C8569f(str);
            c8569f.mo18688pi();
            c8569f.mo18687ph();
            C0803h oT = c8569f.mo18686oT();
            c8569f.mo18687ph();
            if (c8569f.mo18689pp()) {
                AppMethodBeat.m2505o(70494);
                return oT;
            }
            C31988j am = c8569f.mo18685am("Unexpected character");
            AppMethodBeat.m2505o(70494);
            throw am;
        } catch (IOException e) {
            RuntimeException runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(70494);
            throw runtimeException;
        }
    }

    /* renamed from: ai */
    private static String m40251ai(String str) {
        AppMethodBeat.m2504i(70495);
        if (str.endsWith(".0")) {
            str = str.substring(0, str.length() - 2);
            AppMethodBeat.m2505o(70495);
            return str;
        }
        AppMethodBeat.m2505o(70495);
        return str;
    }
}
