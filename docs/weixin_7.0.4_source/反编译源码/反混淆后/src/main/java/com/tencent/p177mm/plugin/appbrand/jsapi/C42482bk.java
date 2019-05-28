package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bk */
public final class C42482bk extends C10296a {
    public static final int CTRL_INDEX = 65;
    public static final String NAME = "systemLog";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(114331);
        C4990ab.m7416i("AppBrandLog." + c2241c.getAppId(), jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
        AppMethodBeat.m2505o(114331);
    }
}
