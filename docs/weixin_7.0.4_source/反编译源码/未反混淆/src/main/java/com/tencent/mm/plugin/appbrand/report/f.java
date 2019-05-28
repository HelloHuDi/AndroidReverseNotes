package com.tencent.mm.plugin.appbrand.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;

public final class f {
    public static int h(int i, Bundle bundle) {
        AppMethodBeat.i(132563);
        if (bundle == null || !pK(i)) {
            AppMethodBeat.o(132563);
            return 0;
        }
        int i2 = bundle.getInt("stat_scene");
        AppMethodBeat.o(132563);
        return i2;
    }

    public static String i(int i, Bundle bundle) {
        AppMethodBeat.i(132564);
        String str;
        if (bundle == null || !pK(i)) {
            str = "";
            AppMethodBeat.o(132564);
            return str;
        }
        switch (bundle.getInt("stat_scene")) {
            case 1:
                str = bundle.getString("stat_send_msg_user");
                AppMethodBeat.o(132564);
                return str;
            case 2:
                str = bundle.getString("stat_chat_talker_username");
                str = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bundle.getString("stat_send_msg_user");
                AppMethodBeat.o(132564);
                return str;
            case 3:
                str = bundle.getString("stat_msg_id");
                str = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bundle.getString("stat_send_msg_user");
                AppMethodBeat.o(132564);
                return str;
            case 4:
                str = q.encode(bundle.getString("stat_url"));
                AppMethodBeat.o(132564);
                return str;
            case 6:
                String string = bundle.getString("stat_app_id");
                str = bundle.getString("stat_url");
                StringBuilder append = new StringBuilder().append(string).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                if (str == null) {
                    str = "";
                }
                str = append.append(q.encode(str)).toString();
                AppMethodBeat.o(132564);
                return str;
            case 7:
                str = bundle.getString("stat_chat_talker_username");
                AppMethodBeat.o(132564);
                return str;
            case 8:
                str = "search:" + bundle.getString("stat_search_id");
                AppMethodBeat.o(132564);
                return str;
            case 9:
                str = bundle.getString("stat_chat_talker_username");
                str = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + bundle.getString("stat_send_msg_user");
                AppMethodBeat.o(132564);
                return str;
            default:
                str = "";
                AppMethodBeat.o(132564);
                return str;
        }
    }

    private static boolean pK(int i) {
        switch (i) {
            case 1007:
            case 1008:
            case 1012:
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
            case 1031:
            case 1036:
            case FilterEnum4Shaka.MIC_SHAKA_ADD2_9 /*1044*/:
            case 1048:
            case FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE /*1088*/:
            case 1124:
            case 1125:
            case 1126:
                return true;
            default:
                return false;
        }
    }
}
