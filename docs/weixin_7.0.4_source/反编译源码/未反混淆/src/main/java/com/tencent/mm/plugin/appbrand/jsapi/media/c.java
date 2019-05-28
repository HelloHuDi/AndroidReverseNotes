package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 532;
    public static final String NAME = "chooseMessageFile";

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131216);
        if (jSONObject == null) {
            d.e("MicroMsg.JsApiChooseMessageFile", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131216);
            return;
        }
        Context context = cVar.getContext();
        if (context == null || !(context instanceof MMActivity)) {
            d.e("MicroMsg.JsApiChooseMessageFile", "context is null");
            cVar.M(i, j("fail:internal error invalid android context", null));
            AppMethodBeat.o(131216);
            return;
        }
        d.i("MicroMsg.JsApiChooseMessageFile", "chooseMsgFile data:%s", jSONObject);
        String optString = jSONObject.optString("type", "all");
        String optString2 = jSONObject.optString(ShareConstants.MEDIA_EXTENSION, "");
        ((com.tencent.mm.choosemsgfile.compat.a) g.K(com.tencent.mm.choosemsgfile.compat.a.class)).a((MMActivity) context, optString, jSONObject.optInt("count", 9), optString2, new com.tencent.mm.choosemsgfile.compat.a.a() {
            public final void a(int i, String str, final ArrayList<MsgFile> arrayList) {
                AppMethodBeat.i(131215);
                d.i("MicroMsg.JsApiChooseMessageFile", "resultCode:%d filePaths:%s", Integer.valueOf(i), arrayList);
                switch (i) {
                    case -1:
                        m.aNS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(131214);
                                JSONArray jSONArray = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    MsgFile msgFile = (MsgFile) it.next();
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        if (bo.isNullOrNil(msgFile.filePath) || !e.ct(msgFile.filePath)) {
                                            d.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s is not exist", msgFile.filePath);
                                        } else {
                                            File file = new File(msgFile.filePath);
                                            j jVar = new j();
                                            if (cVar.asE().a(file, msgFile.eov, false, jVar) == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                                                jSONObject.put("path", jVar.value);
                                                jSONObject.put("name", msgFile.fileName);
                                                jSONObject.put("size", msgFile.fileSize);
                                                jSONObject.put("type", msgFile.type);
                                                jSONObject.put("time", msgFile.timeStamp);
                                                jSONArray.put(jSONObject);
                                            } else {
                                                d.e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s result:%s", msgFile, cVar.asE().a(file, msgFile.eov, false, jVar));
                                            }
                                        }
                                    } catch (JSONException e) {
                                        d.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", e, "", new Object[0]);
                                    }
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("errMsg", c.this.getName() + ":ok");
                                    jSONObject2.put("tempFiles", jSONArray);
                                } catch (JSONException e2) {
                                    d.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", e2, "", new Object[0]);
                                }
                                d.i("MicroMsg.JsApiChooseMessageFile", "chooseMessageFile:%s", jSONObject2.toString());
                                cVar.M(i, jSONObject2.toString());
                                AppMethodBeat.o(131214);
                            }
                        });
                        AppMethodBeat.o(131215);
                        return;
                    case 0:
                        cVar.M(i, c.this.j("fail:cancel", null));
                        break;
                    case 1:
                        if (bo.isNullOrNil(str)) {
                            cVar.M(i, c.this.j("fail", null));
                            AppMethodBeat.o(131215);
                            return;
                        }
                        cVar.M(i, c.this.j("fail:".concat(String.valueOf(str)), null));
                        AppMethodBeat.o(131215);
                        return;
                }
                AppMethodBeat.o(131215);
            }
        });
        AppMethodBeat.o(131216);
    }
}
