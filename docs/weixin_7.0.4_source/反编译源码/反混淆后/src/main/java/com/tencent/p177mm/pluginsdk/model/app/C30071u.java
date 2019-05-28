package com.tencent.p177mm.pluginsdk.model.app;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9548e;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;

/* renamed from: com.tencent.mm.pluginsdk.model.app.u */
public class C30071u implements C37866a<Bundle, IPCBoolean> {
    /* renamed from: a */
    public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
        AppMethodBeat.m2504i(79363);
        Bundle bundle = (Bundle) obj;
        if (bundle == null || !"com.tencent.mm".equals(C9548e.m17007PN())) {
            AppMethodBeat.m2505o(79363);
            return;
        }
        String string = bundle.getString("appId");
        String string2 = bundle.getString(IssueStorage.COLUMN_EXT_INFO);
        C40439f bS = C46494g.m87738bS(string, true);
        if (bS != null) {
            WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
            wXAppExtendObject.extInfo = string2;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
            wXMediaMessage.sdkVer = Build.SDK_INT;
            wXMediaMessage.messageExt = string2;
            boolean a = C46494g.m87727a(C4996ah.getContext(), bS.field_appId, wXMediaMessage, 2, null, null);
            if (c18507c != null) {
                c18507c.mo5960ao(new IPCBoolean(a));
            }
        }
        AppMethodBeat.m2505o(79363);
    }
}
