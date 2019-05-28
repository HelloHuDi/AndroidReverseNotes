package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class a {
    private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
    public String Desc = "";
    public String ImgUrl = "";
    public String Title = "";
    public int jCt = 0;
    public String nzv = "";

    public static a OO(String str) {
        AppMethodBeat.i(21915);
        ab.d(TAG, "getIPCallActivityMsgInfoFromXML:".concat(String.valueOf(str)));
        a aVar = new a();
        int indexOf = str.indexOf("<ActivityInfo");
        if (indexOf == -1) {
            ab.e(TAG, "msgContent not start with <ActivityInfo");
            AppMethodBeat.o(21915);
            return aVar;
        }
        Map z = br.z(str.substring(indexOf), "ActivityInfo");
        if (z == null) {
            ab.e(TAG, "XmlParser values is null, xml %s", str);
            AppMethodBeat.o(21915);
            return null;
        }
        if (z.containsKey(".ActivityInfo.Title")) {
            aVar.Title = (String) z.get(".ActivityInfo.Title");
        }
        if (z.containsKey(".ActivityInfo.Desc")) {
            aVar.Desc = (String) z.get(".ActivityInfo.Desc");
        }
        if (z.containsKey(".ActivityInfo.ImgUrl")) {
            aVar.ImgUrl = (String) z.get(".ActivityInfo.ImgUrl");
        }
        if (z.containsKey(".ActivityInfo.StartBtnText")) {
            aVar.nzv = (String) z.get(".ActivityInfo.StartBtnText");
        }
        if (z.containsKey(".ActivityInfo.ActivityType")) {
            aVar.jCt = bo.getInt((String) z.get(".ActivityInfo.ActivityType"), 0);
        }
        ab.d(TAG, "msgInfo:", aVar.toString());
        AppMethodBeat.o(21915);
        return aVar;
    }
}
