package com.tencent.mm.booter.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.g;

public class a {
    public int a(NotificationItem notificationItem, g gVar) {
        AppMethodBeat.i(15891);
        if (notificationItem == null) {
            AppMethodBeat.o(15891);
            return -1;
        }
        int a = notificationItem.a(gVar);
        AppMethodBeat.o(15891);
        return a;
    }
}
