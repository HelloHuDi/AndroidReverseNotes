package com.tencent.p177mm.console.p845a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C44761d;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.console.a.e */
public final class C37662e implements C44041a {
    static {
        AppMethodBeat.m2504i(16133);
        C44042b.m79163a(new C37662e(), "//normsg");
        AppMethodBeat.m2505o(16133);
    }

    public static void init() {
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(16132);
        if (!C4872b.dnO()) {
            AppMethodBeat.m2505o(16132);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(16132);
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
                    C44761d.qjp.mo8448ff(0, 15);
                    Toast.makeText(context, "info is reported.", 0).show();
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    String format = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[]{strArr[1], Long.valueOf(nanoTime2)});
                    C4990ab.m7416i("MicroMsg.NorMsgTest", format);
                    Toast.makeText(context, format, 0).show();
                    AppMethodBeat.m2505o(16132);
                    return true;
                default:
                    AppMethodBeat.m2505o(16132);
                    return false;
            }
        }
    }
}
