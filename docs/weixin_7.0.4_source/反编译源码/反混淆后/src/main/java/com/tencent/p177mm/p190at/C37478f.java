package com.tencent.p177mm.p190at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Map;

/* renamed from: com.tencent.mm.at.f */
public final class C37478f {
    /* renamed from: a */
    public static C25822e m63225a(C25822e c25822e) {
        AppMethodBeat.m2504i(78196);
        if (c25822e == null) {
            AppMethodBeat.m2505o(78196);
            return null;
        } else if (c25822e.agQ()) {
            C25822e ly = C32291o.ahl().mo73116ly(c25822e.fDJ);
            if (ly == null) {
                AppMethodBeat.m2505o(78196);
                return c25822e;
            }
            AppMethodBeat.m2505o(78196);
            return ly;
        } else {
            AppMethodBeat.m2505o(78196);
            return c25822e;
        }
    }

    /* renamed from: b */
    public static boolean m63226b(C25822e c25822e) {
        AppMethodBeat.m2504i(78197);
        if (c25822e == null) {
            AppMethodBeat.m2505o(78197);
            return false;
        }
        int i = c25822e.offset;
        int i2 = c25822e.frO;
        long j = c25822e.cKK;
        if (c25822e.agQ()) {
            C25822e ly = C32291o.ahl().mo73116ly(c25822e.fDJ);
            i = ly.offset;
            i2 = ly.frO;
            j = ly.cKK;
        }
        if (i2 == 0) {
            AppMethodBeat.m2505o(78197);
            return true;
        } else if ((i != i2 || i2 == 0) && j == 0) {
            AppMethodBeat.m2505o(78197);
            return false;
        } else {
            AppMethodBeat.m2505o(78197);
            return true;
        }
    }

    /* renamed from: c */
    public static String m63227c(C25822e c25822e) {
        AppMethodBeat.m2504i(78198);
        String str;
        if (c25822e == null) {
            str = "";
            AppMethodBeat.m2505o(78198);
            return str;
        } else if (c25822e.agQ()) {
            C25822e ly = C32291o.ahl().mo73116ly(c25822e.fDJ);
            if (ly == null) {
                str = "";
                AppMethodBeat.m2505o(78198);
                return str;
            }
            str = ly.fDz;
            AppMethodBeat.m2505o(78198);
            return str;
        } else {
            str = c25822e.fDz;
            AppMethodBeat.m2505o(78198);
            return str;
        }
    }

    /* renamed from: c */
    public static String m63228c(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(78199);
        String str5 = null;
        if (!C5046bo.isNullOrNil(str)) {
            str5 = String.format("<appinfo><appid>%s</appid><mediatagname>%s</mediatagname><messageext>%s</messageext><messageaction>%s</messageaction></appinfo>", new Object[]{str, C5046bo.nullAsNil(str2), C5046bo.nullAsNil(str3), C5046bo.nullAsNil(str4)});
        }
        AppMethodBeat.m2505o(78199);
        return str5;
    }

    /* renamed from: sg */
    public static final C17931a m63229sg(String str) {
        AppMethodBeat.m2504i(78200);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(78200);
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map z = C5049br.m7595z(str, "msg");
        if (z == null) {
            C4990ab.m7412e("MicroMsg.ImgInfoLogic", "parseImg failed");
            AppMethodBeat.m2505o(78200);
            return null;
        }
        C17931a c17931a = new C17931a();
        c17931a.appId = (String) z.get(".msg.appinfo.appid");
        c17931a.mediaTagName = (String) z.get(".msg.appinfo.mediatagname");
        c17931a.messageExt = (String) z.get(".msg.appinfo.messageext");
        c17931a.messageAction = (String) z.get(".msg.appinfo.messageaction");
        AppMethodBeat.m2505o(78200);
        return c17931a;
    }

    /* renamed from: sh */
    public static String m63230sh(String str) {
        AppMethodBeat.m2504i(78201);
        if (C5730e.m8628ct(str)) {
            String x = C1178g.m2591x((str + "-" + C5730e.asZ(str)).getBytes());
            AppMethodBeat.m2505o(78201);
            return x;
        }
        AppMethodBeat.m2505o(78201);
        return null;
    }
}
