package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

public final class d {
    private static a yfK;
    private static HashMap<Integer, Long> yfL = new HashMap();
    private static int yfM = FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL_BACKCAMEA;
    private static int yfN = 2000;
    private static long yfO = 0;

    public interface a {
        void a(long j, String str, String str2);
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
    }

    static {
        AppMethodBeat.i(105951);
        AppMethodBeat.o(105951);
    }

    public static synchronized boolean a(Context context, boolean z, Intent[] intentArr, Object... objArr) {
        boolean z2;
        synchronized (d.class) {
            AppMethodBeat.i(105948);
            for (Intent aO : intentArr) {
                if (aO(aO)) {
                    z2 = false;
                    AppMethodBeat.o(105948);
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
                    yfK.a(valueOf2.longValue() - l.longValue(), aqB(context.getClass().toString()), intentArr[0].getComponent() != null ? aqB(intentArr[0].getComponent().getClassName()) : "None");
                }
                if (valueOf2.longValue() - l.longValue() <= ((long) yfM)) {
                    yfL.put(valueOf, valueOf2);
                    ab.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", Integer.valueOf(yfM), r5, l, valueOf2);
                    z2 = true;
                    AppMethodBeat.o(105948);
                }
            }
            if (yfL.size() > 100 && yfO != 0 && System.currentTimeMillis() - yfO > ((long) yfM)) {
                yfL.clear();
            }
            yfL.put(valueOf, valueOf2);
            yfO = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            ab.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", Long.valueOf(currentTimeMillis2));
            z2 = false;
            AppMethodBeat.o(105948);
        }
        return z2;
    }

    public static void a(a aVar) {
        yfK = aVar;
    }

    private static String aqB(String str) {
        AppMethodBeat.i(105949);
        String[] split = str.split("\\.");
        String str2;
        if (split.length > 0) {
            str2 = split[split.length - 1];
            AppMethodBeat.o(105949);
            return str2;
        }
        str2 = "";
        AppMethodBeat.o(105949);
        return str2;
    }

    public static int dwu() {
        return yfM;
    }

    private static boolean aO(Intent intent) {
        AppMethodBeat.i(105950);
        if (intent != null) {
            try {
                if (!(intent.getComponent() == null || bo.isNullOrNil(intent.getComponent().getClassName()))) {
                    if (Class.forName(intent.getComponent().getClassName()).getAnnotation(b.class) != null) {
                        AppMethodBeat.o(105950);
                        return true;
                    }
                    AppMethodBeat.o(105950);
                    return false;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.CheckReduplicatedAcitiv", "skipReduplicateCheck exception %s", e);
                AppMethodBeat.o(105950);
                return false;
            }
        }
        AppMethodBeat.o(105950);
        return false;
    }
}
