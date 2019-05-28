package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.d */
public final class C5493d {
    private static C5491a yfK;
    private static HashMap<Integer, Long> yfL = new HashMap();
    private static int yfM = FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA;
    private static int yfN = 2000;
    private static long yfO = 0;

    /* renamed from: com.tencent.mm.ui.d$a */
    public interface C5491a {
        /* renamed from: a */
        void mo11119a(long j, String str, String str2);
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.tencent.mm.ui.d$b */
    public @interface C5492b {
    }

    static {
        AppMethodBeat.m2504i(105951);
        AppMethodBeat.m2505o(105951);
    }

    /* renamed from: a */
    public static synchronized boolean m8286a(Context context, boolean z, Intent[] intentArr, Object... objArr) {
        boolean z2;
        synchronized (C5493d.class) {
            AppMethodBeat.m2504i(105948);
            for (Intent aO : intentArr) {
                if (C5493d.m8287aO(aO)) {
                    z2 = false;
                    AppMethodBeat.m2505o(105948);
                    break;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString()).append(",");
            for (Object append : intentArr) {
                stringBuilder.append(append);
                stringBuilder.append(",");
            }
            for (Object append2 : objArr) {
                stringBuilder.append(append2);
                stringBuilder.append(",");
            }
            Integer valueOf = Integer.valueOf(stringBuilder.toString().hashCode());
            Long l = (Long) yfL.get(valueOf);
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            if (z && l != null) {
                if (valueOf2.longValue() - l.longValue() <= ((long) yfN)) {
                    yfK.mo11119a(valueOf2.longValue() - l.longValue(), C5493d.aqB(context.getClass().toString()), intentArr[0].getComponent() != null ? C5493d.aqB(intentArr[0].getComponent().getClassName()) : "None");
                }
                if (valueOf2.longValue() - l.longValue() <= ((long) yfM)) {
                    yfL.put(valueOf, valueOf2);
                    C4990ab.m7413e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", Integer.valueOf(yfM), r5, l, valueOf2);
                    z2 = true;
                    AppMethodBeat.m2505o(105948);
                }
            }
            if (yfL.size() > 100 && yfO != 0 && System.currentTimeMillis() - yfO > ((long) yfM)) {
                yfL.clear();
            }
            yfL.put(valueOf, valueOf2);
            yfO = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            C4990ab.m7417i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", Long.valueOf(currentTimeMillis2));
            z2 = false;
            AppMethodBeat.m2505o(105948);
        }
        return z2;
    }

    /* renamed from: a */
    public static void m8285a(C5491a c5491a) {
        yfK = c5491a;
    }

    private static String aqB(String str) {
        AppMethodBeat.m2504i(105949);
        String[] split = str.split("\\.");
        String str2;
        if (split.length > 0) {
            str2 = split[split.length - 1];
            AppMethodBeat.m2505o(105949);
            return str2;
        }
        str2 = "";
        AppMethodBeat.m2505o(105949);
        return str2;
    }

    public static int dwu() {
        return yfM;
    }

    /* renamed from: aO */
    private static boolean m8287aO(Intent intent) {
        AppMethodBeat.m2504i(105950);
        if (intent != null) {
            try {
                if (!(intent.getComponent() == null || C5046bo.isNullOrNil(intent.getComponent().getClassName()))) {
                    if (Class.forName(intent.getComponent().getClassName()).getAnnotation(C5492b.class) != null) {
                        AppMethodBeat.m2505o(105950);
                        return true;
                    }
                    AppMethodBeat.m2505o(105950);
                    return false;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.CheckReduplicatedAcitiv", "skipReduplicateCheck exception %s", e);
                AppMethodBeat.m2505o(105950);
                return false;
            }
        }
        AppMethodBeat.m2505o(105950);
        return false;
    }
}
