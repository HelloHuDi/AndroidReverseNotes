package com.tencent.p177mm.p612ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.af */
public final class C36036af {
    public static List<String> dzi() {
        AppMethodBeat.m2504i(29925);
        int YD = C1853r.m3822YD();
        ArrayList arrayList = new ArrayList();
        if ((YD & 32768) == 0) {
            arrayList.add("floatbottle");
            C4990ab.m7410d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
        }
        C9638aw.m17190ZK();
        if (!C18628c.m29072Ry().getBoolean(C5127a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("notifymessage");
            C4990ab.m7410d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
        }
        C9638aw.m17190ZK();
        if (!C18628c.m29072Ry().getBoolean(C5127a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("appbrandcustomerservicemsg");
            C4990ab.m7410d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
        }
        C4990ab.m7411d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", Integer.valueOf(arrayList.size()));
        AppMethodBeat.m2505o(29925);
        return arrayList;
    }
}
