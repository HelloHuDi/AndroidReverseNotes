package com.tencent.mm.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    public static int MW() {
        AppMethodBeat.i(77655);
        int i = bo.getInt(g.Nu().getValue("InputLimitSNSObjectText"), 2000) * 2;
        AppMethodBeat.o(77655);
        return i;
    }

    public static int MX() {
        AppMethodBeat.i(77656);
        int i = bo.getInt(g.Nu().getValue("SnsCommentMaxSize"), 1000) * 2;
        AppMethodBeat.o(77656);
        return i;
    }

    public static int MY() {
        AppMethodBeat.i(77657);
        int i = bo.getInt(g.Nu().getValue("InputLimitFavText"), 100000) * 2;
        AppMethodBeat.o(77657);
        return i;
    }

    public static int MZ() {
        AppMethodBeat.i(77658);
        int i = bo.getInt(g.Nu().getValue("InputLimitSendEmotionBufSize"), 5242880);
        AppMethodBeat.o(77658);
        return i;
    }

    public static int Na() {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        AppMethodBeat.i(77659);
        try {
            i = bo.getInt(g.Nu().getValue("InputLimitSendEmotionWidth"), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            AppMethodBeat.o(77659);
        } catch (Exception e) {
            ab.b("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", e);
            AppMethodBeat.o(77659);
        }
        return i;
    }

    public static int Nb() {
        int i = 5242880;
        AppMethodBeat.i(77660);
        try {
            i = bo.getInt(g.Nu().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
            AppMethodBeat.o(77660);
        } catch (Exception e) {
            ab.b("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", e);
            AppMethodBeat.o(77660);
        }
        return i;
    }

    public static int Nc() {
        AppMethodBeat.i(77661);
        if (g.RN().QY()) {
            int i = bo.getInt(g.Nu().getValue("InputLimitFavImageSize"), 26214400);
            AppMethodBeat.o(77661);
            return i;
        }
        AppMethodBeat.o(77661);
        return 26214400;
    }

    public static int Nd() {
        AppMethodBeat.i(77662);
        int i = bo.getInt(g.Nu().getValue("InputLimitVideoSize"), 26214400);
        AppMethodBeat.o(77662);
        return i;
    }

    public static String Ne() {
        AppMethodBeat.i(77663);
        String value = g.Nu().getValue("InputLimitForbiddenChar");
        AppMethodBeat.o(77663);
        return value;
    }
}
