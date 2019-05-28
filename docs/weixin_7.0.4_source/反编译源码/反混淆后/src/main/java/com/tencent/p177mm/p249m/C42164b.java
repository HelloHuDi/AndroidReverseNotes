package com.tencent.p177mm.p249m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.m.b */
public final class C42164b {
    /* renamed from: MW */
    public static int m74335MW() {
        AppMethodBeat.m2504i(77655);
        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSNSObjectText"), 2000) * 2;
        AppMethodBeat.m2505o(77655);
        return i;
    }

    /* renamed from: MX */
    public static int m74336MX() {
        AppMethodBeat.m2504i(77656);
        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("SnsCommentMaxSize"), 1000) * 2;
        AppMethodBeat.m2505o(77656);
        return i;
    }

    /* renamed from: MY */
    public static int m74337MY() {
        AppMethodBeat.m2504i(77657);
        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitFavText"), 100000) * 2;
        AppMethodBeat.m2505o(77657);
        return i;
    }

    /* renamed from: MZ */
    public static int m74338MZ() {
        AppMethodBeat.m2504i(77658);
        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSendEmotionBufSize"), 5242880);
        AppMethodBeat.m2505o(77658);
        return i;
    }

    /* renamed from: Na */
    public static int m74339Na() {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        AppMethodBeat.m2504i(77659);
        try {
            i = C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSendEmotionWidth"), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.m2505o(77659);
        } catch (Exception e) {
            C4990ab.m7408b("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", e);
            AppMethodBeat.m2505o(77659);
        }
        return i;
    }

    /* renamed from: Nb */
    public static int m74340Nb() {
        int i = 5242880;
        AppMethodBeat.m2504i(77660);
        try {
            i = C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
            AppMethodBeat.m2505o(77660);
        } catch (Exception e) {
            C4990ab.m7408b("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", e);
            AppMethodBeat.m2505o(77660);
        }
        return i;
    }

    /* renamed from: Nc */
    public static int m74341Nc() {
        AppMethodBeat.m2504i(77661);
        if (C1720g.m3534RN().mo5161QY()) {
            int i = C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitFavImageSize"), 26214400);
            AppMethodBeat.m2505o(77661);
            return i;
        }
        AppMethodBeat.m2505o(77661);
        return 26214400;
    }

    /* renamed from: Nd */
    public static int m74342Nd() {
        AppMethodBeat.m2504i(77662);
        int i = C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitVideoSize"), 26214400);
        AppMethodBeat.m2505o(77662);
        return i;
    }

    /* renamed from: Ne */
    public static String m74343Ne() {
        AppMethodBeat.m2504i(77663);
        String value = C26373g.m41964Nu().getValue("InputLimitForbiddenChar");
        AppMethodBeat.m2505o(77663);
        return value;
    }
}
