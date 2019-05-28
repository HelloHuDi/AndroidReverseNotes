package com.tencent.mm.plugin.wallet;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public int index = 0;
    public String teR = "";
    public StringBuffer teS = new StringBuffer();

    public a() {
        AppMethodBeat.i(135764);
        AppMethodBeat.o(135764);
    }

    public static a dq(String str, int i) {
        AppMethodBeat.i(135765);
        a aVar = new a();
        aVar.teR = str + "," + i;
        AppMethodBeat.o(135765);
        return aVar;
    }

    public final void i(int i, Object... objArr) {
        AppMethodBeat.i(135766);
        bs(i, s(objArr));
        AppMethodBeat.o(135766);
    }

    private static String s(Object... objArr) {
        String str;
        AppMethodBeat.i(135767);
        if (objArr == null || objArr.length <= 0) {
            ab.w("MicroMsg.PayLogReport", "vals is null, use '' as value");
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
        AppMethodBeat.o(135767);
        return str;
    }

    public final void bs(int i, String str) {
        AppMethodBeat.i(135768);
        String format = String.format("{%d, %s, %d, %s},", new Object[]{Integer.valueOf(this.index), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), str});
        this.index++;
        ab.i("MicroMsg.PayLogReport", "test for log ".concat(String.valueOf(format)));
        this.teS.append(format);
        AppMethodBeat.o(135768);
    }

    public static boolean a(a aVar, Intent intent) {
        AppMethodBeat.i(135769);
        if (aVar == null) {
            AppMethodBeat.o(135769);
            return false;
        }
        intent.putExtra("WECHAT_PAY_LOG_REPORT_INDEX", aVar.index);
        intent.putExtra("WECHAT_PAY_LOG_REPORT_DATA", aVar.teS.toString());
        intent.putExtra("WECHAT_PAY_LOG_REPORT_BASEIFO", aVar.teR);
        AppMethodBeat.o(135769);
        return true;
    }

    public static a at(Intent intent) {
        AppMethodBeat.i(135770);
        int intExtra = intent.getIntExtra("WECHAT_PAY_LOG_REPORT_INDEX", -1);
        if (intExtra == -1) {
            AppMethodBeat.o(135770);
            return null;
        }
        a aVar = new a();
        aVar.index = intExtra;
        aVar.teS = new StringBuffer(bo.bc(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_DATA"), ""));
        aVar.teR = bo.bc(intent.getStringExtra("WECHAT_PAY_LOG_REPORT_BASEIFO"), "");
        AppMethodBeat.o(135770);
        return aVar;
    }
}
