package com.tencent.p177mm.plugin.wallet;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet.a */
public final class C40052a {
    public int index = 0;
    public String teR = "";
    public StringBuffer teS = new StringBuffer();

    public C40052a() {
        AppMethodBeat.m2504i(135764);
        AppMethodBeat.m2505o(135764);
    }

    /* renamed from: dq */
    public static C40052a m68625dq(String str, int i) {
        AppMethodBeat.m2504i(135765);
        C40052a c40052a = new C40052a();
        c40052a.teR = str + "," + i;
        AppMethodBeat.m2505o(135765);
        return c40052a;
    }

    /* renamed from: i */
    public final void mo63380i(int i, Object... objArr) {
        AppMethodBeat.m2504i(135766);
        mo63379bs(i, C40052a.m68626s(objArr));
        AppMethodBeat.m2505o(135766);
    }

    /* renamed from: s */
    private static String m68626s(Object... objArr) {
        String str;
        AppMethodBeat.m2504i(135767);
        if (objArr == null || objArr.length <= 0) {
            C4990ab.m7420w("MicroMsg.PayLogReport", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i = 0; i < length; i++) {
                stringBuilder.append(String.valueOf(objArr[i])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            str = stringBuilder.toString();
        }
        AppMethodBeat.m2505o(135767);
        return str;
    }

    /* renamed from: bs */
    public final void mo63379bs(int i, String str) {
        AppMethodBeat.m2504i(135768);
        String format = String.format("{%d, %s, %d, %s},", new Object[]{Integer.valueOf(this.index), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), str});
        this.index++;
        C4990ab.m7416i("MicroMsg.PayLogReport", "test for log ".concat(String.valueOf(format)));
        this.teS.append(format);
        AppMethodBeat.m2505o(135768);
    }

    /* renamed from: a */
    public static boolean m68623a(C40052a c40052a, Intent intent) {
        AppMethodBeat.m2504i(135769);
        if (c40052a == null) {
            AppMethodBeat.m2505o(135769);
            return false;
        }
        intent.putExtra("WECHAT_PAY_LOG_REPORT_INDEX", c40052a.index);
        intent.putExtra("WECHAT_PAY_LOG_REPORT_DATA", c40052a.teS.toString());
        intent.putExtra("WECHAT_PAY_LOG_REPORT_BASEIFO", c40052a.teR);
        AppMethodBeat.m2505o(135769);
        return true;
    }

    /* renamed from: at */
    public static C40052a m68624at(Intent intent) {
        AppMethodBeat.m2504i(135770);
        int intExtra = intent.getIntExtra("WECHAT_PAY_LOG_REPORT_INDEX", -1);
        if (intExtra == -1) {
            AppMethodBeat.m2505o(135770);
            return null;
        }
        C40052a c40052a = new C40052a();
        c40052a.index = intExtra;
        c40052a.teS = new StringBuffer(C5046bo.m7532bc(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_DATA"), ""));
        c40052a.teR = C5046bo.m7532bc(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_BASEIFO"), "");
        AppMethodBeat.m2505o(135770);
        return c40052a;
    }
}
