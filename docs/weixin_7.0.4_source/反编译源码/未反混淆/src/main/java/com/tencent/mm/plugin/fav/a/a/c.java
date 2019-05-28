package com.tencent.mm.plugin.fav.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class c {
    public static void a(Map<String, String> map, abs abs) {
        AppMethodBeat.i(102756);
        if (map == null || abs == null) {
            ab.w("MicroMsg.FavTagParser", "maps is null or item is null");
            AppMethodBeat.o(102756);
            return;
        }
        String str;
        abs.wiJ.clear();
        int i = 0;
        while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str = (String) map.get(".favitem.taglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            abs.wiJ.add(str);
            i++;
        }
        if (!abs.wiJ.isEmpty()) {
            ab.d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", abs.wiJ);
        }
        abs.wiI.clear();
        i = 0;
        while (i < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            str = (String) map.get(".favitem.recommendtaglist.tag" + (i > 0 ? Integer.valueOf(i) : ""));
            if (str == null) {
                break;
            }
            abs.wiI.add(str);
            i++;
        }
        if (!abs.wiI.isEmpty()) {
            ab.d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", abs.wiI);
        }
        AppMethodBeat.o(102756);
    }

    public static String a(abs abs) {
        int i = 0;
        AppMethodBeat.i(102757);
        String str;
        if (abs == null || (abs.wiJ.isEmpty() && abs.wiI.isEmpty())) {
            ab.v("MicroMsg.FavTagParser", "tag list toXml data list empty");
            str = "";
            AppMethodBeat.o(102757);
            return str;
        }
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        int size = abs.wiJ.size();
        stringBuffer.append("<taglist count='").append(size).append("'>");
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(bo.ani((String) abs.wiJ.get(i2))).append("</tag>");
        }
        stringBuffer.append("</taglist>");
        i2 = abs.wiI.size();
        stringBuffer.append("<recommendtaglist count='").append(i2).append("'>");
        while (i < i2) {
            stringBuffer.append("<tag>").append(bo.ani((String) abs.wiI.get(i))).append("</tag>");
            i++;
        }
        stringBuffer.append("</recommendtaglist>");
        str = stringBuffer.toString();
        AppMethodBeat.o(102757);
        return str;
    }
}
