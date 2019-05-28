package com.tencent.mm.plugin.appbrand.jsapi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class bk extends a {
    public static final int CTRL_INDEX = 65;
    public static final String NAME = "systemLog";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(114331);
        ab.i("AppBrandLog." + cVar.getAppId(), jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
        AppMethodBeat.o(114331);
    }
}
