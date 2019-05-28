package com.tencent.p177mm.plugin.scanner.p740a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.scanner.util.C43494o;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C13185a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.scanner.a.j */
public final class C43486j {
    /* renamed from: a */
    public static String m77690a(Context context, C13185a c13185a) {
        AppMethodBeat.m2504i(80853);
        C8910b c8910b = new C8910b();
        c8910b.appId = C43486j.m77689BT(c13185a.field_functionType);
        c8910b.title = c13185a.field_title;
        c8910b.description = c13185a.field_source;
        c8910b.type = 10;
        c8910b.url = c13185a.field_shareurl;
        c8910b.action = "";
        c8910b.appName = C43494o.m77709T(context, c13185a.field_type);
        c8910b.thumburl = c13185a.field_thumburl;
        c8910b.fgP = c13185a.field_type;
        c8910b.fgQ = C43494o.m77715c(c13185a);
        String a = C8910b.m16061a(c8910b, null, null);
        AppMethodBeat.m2505o(80853);
        return a;
    }

    /* renamed from: BT */
    public static String m77689BT(int i) {
        if (i == 4) {
            return "wxfbc915ff7c30e335";
        }
        if (i == 3) {
            return "wx482a4001c37e2b74";
        }
        return "wxfbc915ff7c30e335";
    }

    /* renamed from: cV */
    public static C13185a m77691cV(String str, int i) {
        AppMethodBeat.m2504i(80854);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(80854);
            return null;
        }
        int Wn = C43494o.m77710Wn(str);
        C13185a cW;
        if (Wn == 3) {
            cW = C43494o.m77716cW(str, i);
            AppMethodBeat.m2505o(80854);
            return cW;
        } else if (Wn == 4) {
            cW = C43494o.m77713Wq(str);
            AppMethodBeat.m2505o(80854);
            return cW;
        } else {
            AppMethodBeat.m2505o(80854);
            return null;
        }
    }
}
