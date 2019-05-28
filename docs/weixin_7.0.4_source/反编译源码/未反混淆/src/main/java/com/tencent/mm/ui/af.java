package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import java.util.ArrayList;
import java.util.List;

public final class af {
    public static List<String> dzi() {
        AppMethodBeat.i(29925);
        int YD = r.YD();
        ArrayList arrayList = new ArrayList();
        if ((YD & 32768) == 0) {
            arrayList.add("floatbottle");
            ab.d("MicroMsg.LauncherUI", "add bottle into show unread count blacklist.");
        }
        aw.ZK();
        if (!c.Ry().getBoolean(a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("notifymessage");
            ab.d("MicroMsg.UnreadCountHelper", "add service notify message into show unread count blacklist.");
        }
        aw.ZK();
        if (!c.Ry().getBoolean(a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
            arrayList.add("appbrandcustomerservicemsg");
            ab.d("MicroMsg.UnreadCountHelper", "add wxa custom session notify message into show unread count blacklist.");
        }
        ab.d("MicroMsg.LauncherUI", "getShowUnreadCountBlacklist unread count blacklist(size : %s).", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(29925);
        return arrayList;
    }
}
