package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import junit.framework.Assert;

public final class h extends e {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS appbrandmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  appbrandmessageSvrIdIndex ON appbrandmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerIndex ON appbrandmessage ( talker )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalerStatusIndex ON appbrandmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTimeIndex ON appbrandmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTaklerTimeIndex ON appbrandmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageSendCreateTimeIndex ON appbrandmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerTypeIndex ON appbrandmessage ( talker,type )"};

    public h(com.tencent.mm.plugin.messenger.foundation.a.a.h hVar) {
        super(hVar);
        AppMethodBeat.i(29000);
        a(bOy(), "appbrandmessage");
        a(new b(256, "appbrandmessage", b.a(3000001, 3500000, 102000001, 105000000)));
        AppMethodBeat.o(29000);
    }

    public final String aog(String str) {
        AppMethodBeat.i(29001);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (ad.mg(str)) {
            String str2 = "appbrandmessage";
            AppMethodBeat.o(29001);
            return str2;
        }
        AppMethodBeat.o(29001);
        return null;
    }
}
