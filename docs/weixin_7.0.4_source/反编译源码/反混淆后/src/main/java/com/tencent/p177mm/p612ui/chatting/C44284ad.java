package com.tencent.p177mm.p612ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.ui.chatting.ad */
public final class C44284ad {
    /* renamed from: nb */
    public static String m80020nb(long j) {
        AppMethodBeat.m2504i(30941);
        String h = C44284ad.m80019h(C32291o.ahl().mo73113fJ(j));
        if (h != null) {
            AppMethodBeat.m2505o(30941);
            return h;
        }
        AppMethodBeat.m2505o(30941);
        return null;
    }

    /* renamed from: nc */
    public static String m80021nc(long j) {
        AppMethodBeat.m2504i(30942);
        String h = C44284ad.m80019h(C32291o.ahl().mo73112fI(j));
        if (h != null) {
            AppMethodBeat.m2505o(30942);
            return h;
        }
        AppMethodBeat.m2505o(30942);
        return null;
    }

    /* renamed from: h */
    private static String m80019h(C25822e c25822e) {
        AppMethodBeat.m2504i(30943);
        if (c25822e != null) {
            String str;
            if (c25822e.agQ()) {
                str = c25822e.fDz;
                if (str != null && C5730e.m8628ct(str)) {
                    AppMethodBeat.m2505o(30943);
                    return str;
                }
            }
            str = C32291o.ahl().mo73118q(c25822e.fDz, null, null);
            if (str == null || !C5730e.m8628ct(str)) {
                str = C32291o.ahl().mo73118q(c25822e.fDB, null, null);
                if (str != null && C5730e.m8628ct(str)) {
                    AppMethodBeat.m2505o(30943);
                    return str;
                }
            }
            AppMethodBeat.m2505o(30943);
            return str;
        }
        AppMethodBeat.m2505o(30943);
        return null;
    }

    /* renamed from: a */
    public static String m80018a(C7620bi c7620bi, C8910b c8910b) {
        AppMethodBeat.m2504i(30944);
        String str = "";
        if (!(c8910b == null || C5046bo.isNullOrNil(c8910b.csD))) {
            C30065b aiE = C14877am.aUq().aiE(c8910b.csD);
            if (aiE != null && aiE.bCR() && C5730e.m8628ct(aiE.field_fileFullPath)) {
                str = aiE.field_fileFullPath;
            }
        }
        if (C5046bo.isNullOrNil(str)) {
            if (c7620bi != null) {
                str = C32291o.ahl().mo73074I(c7620bi.field_imgPath, true);
            }
            C4990ab.m7411d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", str);
            AppMethodBeat.m2505o(30944);
        } else {
            C4990ab.m7411d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", str);
            AppMethodBeat.m2505o(30944);
        }
        return str;
    }
}
