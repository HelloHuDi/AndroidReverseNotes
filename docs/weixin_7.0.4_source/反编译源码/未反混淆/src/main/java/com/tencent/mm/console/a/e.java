package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class e implements a {
    static {
        AppMethodBeat.i(16133);
        b.a(new e(), "//normsg");
        AppMethodBeat.o(16133);
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16132);
        if (!com.tencent.mm.sdk.a.b.dnO()) {
            AppMethodBeat.o(16132);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(16132);
            return false;
        } else {
            try {
                if (strArr.length >= 3) {
                    Integer.valueOf(strArr[2]).intValue();
                }
            } catch (Exception e) {
            }
            String toLowerCase = strArr[1].toLowerCase();
            long nanoTime = System.nanoTime();
            boolean z = true;
            switch (toLowerCase.hashCode()) {
                case -1422437344:
                    if (toLowerCase.equals("testrpp")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    d.qjp.ff(0, 15);
                    Toast.makeText(context, "info is reported.", 0).show();
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    String format = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[]{strArr[1], Long.valueOf(nanoTime2)});
                    ab.i("MicroMsg.NorMsgTest", format);
                    Toast.makeText(context, format, 0).show();
                    AppMethodBeat.o(16132);
                    return true;
                default:
                    AppMethodBeat.o(16132);
                    return false;
            }
        }
    }
}
