package com.tencent.mm.pluginsdk.model.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;

public class u implements a<Bundle, IPCBoolean> {
    public final /* synthetic */ void a(Object obj, c cVar) {
        AppMethodBeat.i(79363);
        Bundle bundle = (Bundle) obj;
        if (bundle == null || !"com.tencent.mm".equals(e.PN())) {
            AppMethodBeat.o(79363);
            return;
        }
        String string = bundle.getString("appId");
        String string2 = bundle.getString(IssueStorage.COLUMN_EXT_INFO);
        f bS = g.bS(string, true);
        if (bS != null) {
            WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
            wXAppExtendObject.extInfo = string2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
            wXMediaMessage.sdkVer = Build.SDK_INT;
            wXMediaMessage.messageExt = string2;
            boolean a = g.a(ah.getContext(), bS.field_appId, wXMediaMessage, 2, null, null);
            if (cVar != null) {
                cVar.ao(new IPCBoolean(a));
            }
        }
        AppMethodBeat.o(79363);
    }
}
