package com.tencent.p177mm.console.p845a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C45310bp;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.console.a.n */
public final class C37663n implements C44041a {
    static {
        AppMethodBeat.m2504i(16151);
        C44042b.m79163a(new C37663n(), "//cleanwx", "//showfile", "//hidefile");
        AppMethodBeat.m2505o(16151);
    }

    public static void init() {
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(16150);
        String str2 = strArr[0];
        int i = -1;
        switch (str2.hashCode()) {
            case -1470593122:
                if (str2.equals("//hidefile")) {
                    i = 2;
                    break;
                }
                break;
            case -35508263:
                if (str2.equals("//showfile")) {
                    boolean i2 = true;
                    break;
                }
                break;
            case 2113467658:
                if (str2.equals("//cleanwx")) {
                    i2 = 0;
                    break;
                }
                break;
        }
        switch (i2) {
            case 0:
                C4879a.xxA.mo10055m(new C45310bp());
                C23639t.makeText(context, "clean wx file index now.", 0).show();
                AppMethodBeat.m2505o(16150);
                return true;
            case 1:
                try {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, Integer.valueOf(1));
                    C23639t.makeText(context, "show file now.", 0).show();
                } catch (Exception e) {
                }
                AppMethodBeat.m2505o(16150);
                return true;
            case 2:
                try {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CALC_WX_SCAN_SHOW_FILE_INT, Integer.valueOf(0));
                    C23639t.makeText(context, "hide file now.", 0).show();
                } catch (Exception e2) {
                }
                AppMethodBeat.m2505o(16150);
                return true;
            default:
                AppMethodBeat.m2505o(16150);
                return false;
        }
    }
}
