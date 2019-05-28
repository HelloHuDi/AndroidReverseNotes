package com.tencent.p177mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h.C3459b;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.storage.h */
public final class C36004h extends C5142e {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS appbrandmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  appbrandmessageSvrIdIndex ON appbrandmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerIndex ON appbrandmessage ( talker )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalerStatusIndex ON appbrandmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTimeIndex ON appbrandmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTaklerTimeIndex ON appbrandmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageSendCreateTimeIndex ON appbrandmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerTypeIndex ON appbrandmessage ( talker,type )"};

    public C36004h(C6977h c6977h) {
        super(c6977h);
        AppMethodBeat.m2504i(29000);
        mo10565a(bOy(), "appbrandmessage");
        mo10566a(new C3459b(256, "appbrandmessage", C3459b.m5743a(3000001, 3500000, 102000001, 105000000)));
        AppMethodBeat.m2505o(29000);
    }

    public final String aog(String str) {
        AppMethodBeat.m2504i(29001);
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        if (C7616ad.m13549mg(str)) {
            String str2 = "appbrandmessage";
            AppMethodBeat.m2505o(29001);
            return str2;
        }
        AppMethodBeat.m2505o(29001);
        return null;
    }
}
