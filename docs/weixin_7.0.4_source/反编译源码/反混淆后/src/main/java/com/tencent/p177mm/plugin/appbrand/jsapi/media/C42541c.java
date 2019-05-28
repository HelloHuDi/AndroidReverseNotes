package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.choosemsgfile.compat.C9236a;
import com.tencent.p177mm.choosemsgfile.compat.C9236a.C9237a;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.c */
public final class C42541c extends C10296a {
    public static final int CTRL_INDEX = 532;
    public static final String NAME = "chooseMessageFile";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131216);
        if (jSONObject == null) {
            C45124d.m82927e("MicroMsg.JsApiChooseMessageFile", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131216);
            return;
        }
        Context context = c2241c.getContext();
        if (context == null || !(context instanceof MMActivity)) {
            C45124d.m82927e("MicroMsg.JsApiChooseMessageFile", "context is null");
            c2241c.mo6107M(i, mo73394j("fail:internal error invalid android context", null));
            AppMethodBeat.m2505o(131216);
            return;
        }
        C45124d.m82930i("MicroMsg.JsApiChooseMessageFile", "chooseMsgFile data:%s", jSONObject);
        String optString = jSONObject.optString("type", "all");
        String optString2 = jSONObject.optString(ShareConstants.MEDIA_EXTENSION, "");
        ((C9236a) C1720g.m3528K(C9236a.class)).mo20656a((MMActivity) context, optString, jSONObject.optInt("count", 9), optString2, new C9237a() {
            /* renamed from: a */
            public final void mo20659a(int i, String str, final ArrayList<MsgFile> arrayList) {
                AppMethodBeat.m2504i(131215);
                C45124d.m82930i("MicroMsg.JsApiChooseMessageFile", "resultCode:%d filePaths:%s", Integer.valueOf(i), arrayList);
                switch (i) {
                    case -1:
                        C45673m.aNS().mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(131214);
                                JSONArray jSONArray = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    MsgFile msgFile = (MsgFile) it.next();
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        if (C5046bo.isNullOrNil(msgFile.filePath) || !C5730e.m8628ct(msgFile.filePath)) {
                                            C45124d.m82928e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s is not exist", msgFile.filePath);
                                        } else {
                                            File file = new File(msgFile.filePath);
                                            C19681j c19681j = new C19681j();
                                            if (c2241c.asE().mo5835a(file, msgFile.eov, false, c19681j) == C45518j.OK) {
                                                jSONObject.put("path", c19681j.value);
                                                jSONObject.put("name", msgFile.fileName);
                                                jSONObject.put("size", msgFile.fileSize);
                                                jSONObject.put("type", msgFile.type);
                                                jSONObject.put("time", msgFile.timeStamp);
                                                jSONArray.put(jSONObject);
                                            } else {
                                                C45124d.m82928e("MicroMsg.JsApiChooseMessageFile", "msgFile:%s result:%s", msgFile, c2241c.asE().mo5835a(file, msgFile.eov, false, c19681j));
                                            }
                                        }
                                    } catch (JSONException e) {
                                        C45124d.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", e, "", new Object[0]);
                                    }
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("errMsg", C42541c.this.getName() + ":ok");
                                    jSONObject2.put("tempFiles", jSONArray);
                                } catch (JSONException e2) {
                                    C45124d.printErrStackTrace("MicroMsg.JsApiChooseMessageFile", e2, "", new Object[0]);
                                }
                                C45124d.m82930i("MicroMsg.JsApiChooseMessageFile", "chooseMessageFile:%s", jSONObject2.toString());
                                c2241c.mo6107M(i, jSONObject2.toString());
                                AppMethodBeat.m2505o(131214);
                            }
                        });
                        AppMethodBeat.m2505o(131215);
                        return;
                    case 0:
                        c2241c.mo6107M(i, C42541c.this.mo73394j("fail:cancel", null));
                        break;
                    case 1:
                        if (C5046bo.isNullOrNil(str)) {
                            c2241c.mo6107M(i, C42541c.this.mo73394j("fail", null));
                            AppMethodBeat.m2505o(131215);
                            return;
                        }
                        c2241c.mo6107M(i, C42541c.this.mo73394j("fail:".concat(String.valueOf(str)), null));
                        AppMethodBeat.m2505o(131215);
                        return;
                }
                AppMethodBeat.m2505o(131215);
            }
        });
        AppMethodBeat.m2505o(131216);
    }
}
