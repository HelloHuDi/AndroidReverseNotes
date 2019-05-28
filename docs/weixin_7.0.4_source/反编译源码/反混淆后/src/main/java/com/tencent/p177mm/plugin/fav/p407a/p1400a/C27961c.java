package com.tencent.p177mm.plugin.fav.p407a.p1400a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.protocal.protobuf.abs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.fav.a.a.c */
public final class C27961c {
    /* renamed from: a */
    public static void m44513a(Map<String, String> map, abs abs) {
        AppMethodBeat.m2504i(102756);
        if (map == null || abs == null) {
            C4990ab.m7420w("MicroMsg.FavTagParser", "maps is null or item is null");
            AppMethodBeat.m2505o(102756);
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
            C4990ab.m7411d("MicroMsg.FavTagParser", "user def tag not empty, res=%s", abs.wiJ);
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
            C4990ab.m7411d("MicroMsg.FavTagParser", "recommended tag not empty, res=%s", abs.wiI);
        }
        AppMethodBeat.m2505o(102756);
    }

    /* renamed from: a */
    public static String m44512a(abs abs) {
        int i = 0;
        AppMethodBeat.m2504i(102757);
        String str;
        if (abs == null || (abs.wiJ.isEmpty() && abs.wiI.isEmpty())) {
            C4990ab.m7418v("MicroMsg.FavTagParser", "tag list toXml data list empty");
            str = "";
            AppMethodBeat.m2505o(102757);
            return str;
        }
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        int size = abs.wiJ.size();
        stringBuffer.append("<taglist count='").append(size).append("'>");
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(C5046bo.ani((String) abs.wiJ.get(i2))).append("</tag>");
        }
        stringBuffer.append("</taglist>");
        i2 = abs.wiI.size();
        stringBuffer.append("<recommendtaglist count='").append(i2).append("'>");
        while (i < i2) {
            stringBuffer.append("<tag>").append(C5046bo.ani((String) abs.wiI.get(i))).append("</tag>");
            i++;
        }
        stringBuffer.append("</recommendtaglist>");
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(102757);
        return str;
    }
}
