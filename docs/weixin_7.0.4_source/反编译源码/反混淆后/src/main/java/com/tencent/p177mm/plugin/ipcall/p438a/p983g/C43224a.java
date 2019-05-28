package com.tencent.p177mm.plugin.ipcall.p438a.p983g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.ipcall.a.g.a */
public final class C43224a {
    private static String TAG = "MicroMsg.IPCallActivityMsgInfo";
    public String Desc = "";
    public String ImgUrl = "";
    public String Title = "";
    public int jCt = 0;
    public String nzv = "";

    /* renamed from: OO */
    public static C43224a m76873OO(String str) {
        AppMethodBeat.m2504i(21915);
        C4990ab.m7410d(TAG, "getIPCallActivityMsgInfoFromXML:".concat(String.valueOf(str)));
        C43224a c43224a = new C43224a();
        int indexOf = str.indexOf("<ActivityInfo");
        if (indexOf == -1) {
            C4990ab.m7412e(TAG, "msgContent not start with <ActivityInfo");
            AppMethodBeat.m2505o(21915);
            return c43224a;
        }
        Map z = C5049br.m7595z(str.substring(indexOf), "ActivityInfo");
        if (z == null) {
            C4990ab.m7413e(TAG, "XmlParser values is null, xml %s", str);
            AppMethodBeat.m2505o(21915);
            return null;
        }
        if (z.containsKey(".ActivityInfo.Title")) {
            c43224a.Title = (String) z.get(".ActivityInfo.Title");
        }
        if (z.containsKey(".ActivityInfo.Desc")) {
            c43224a.Desc = (String) z.get(".ActivityInfo.Desc");
        }
        if (z.containsKey(".ActivityInfo.ImgUrl")) {
            c43224a.ImgUrl = (String) z.get(".ActivityInfo.ImgUrl");
        }
        if (z.containsKey(".ActivityInfo.StartBtnText")) {
            c43224a.nzv = (String) z.get(".ActivityInfo.StartBtnText");
        }
        if (z.containsKey(".ActivityInfo.ActivityType")) {
            c43224a.jCt = C5046bo.getInt((String) z.get(".ActivityInfo.ActivityType"), 0);
        }
        C4990ab.m7411d(TAG, "msgInfo:", c43224a.toString());
        AppMethodBeat.m2505o(21915);
        return c43224a;
    }
}
