package com.tencent.p177mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelbase.BaseReq;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.utils.Log;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* renamed from: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage */
public class AddCardToWXCardPackage {
    private static final String TAG = "MicroMsg.AddCardToWXCardPackage";

    /* renamed from: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage$Req */
    public static class Req extends BaseReq {
        public List<WXCardItem> cardArrary;

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128174);
            if (this.cardArrary == null || this.cardArrary.size() == 0 || this.cardArrary.size() > 40) {
                AppMethodBeat.m2505o(128174);
                return false;
            }
            for (WXCardItem wXCardItem : this.cardArrary) {
                if (wXCardItem == null || wXCardItem.cardId == null || wXCardItem.cardId.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || (wXCardItem.cardExtMsg != null && wXCardItem.cardExtMsg.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
                    AppMethodBeat.m2505o(128174);
                    return false;
                }
            }
            AppMethodBeat.m2505o(128174);
            return true;
        }

        public int getType() {
            return 9;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128175);
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e) {
                Log.m4140e(AddCardToWXCardPackage.TAG, "Req.toBundle exception:" + e.getMessage());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
            AppMethodBeat.m2505o(128175);
        }
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage$WXCardItem */
    public static final class WXCardItem {
        public String cardExtMsg;
        public String cardId;
        public int cardState;
    }

    /* renamed from: com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage$Resp */
    public static class Resp extends BaseResp {
        public List<WXCardItem> cardArrary;

        public Resp(Bundle bundle) {
            AppMethodBeat.m2504i(128185);
            fromBundle(bundle);
            AppMethodBeat.m2505o(128185);
        }

        public boolean checkArgs() {
            AppMethodBeat.m2504i(128186);
            if (this.cardArrary == null || this.cardArrary.size() == 0) {
                AppMethodBeat.m2505o(128186);
                return false;
            }
            AppMethodBeat.m2505o(128186);
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128188);
            super.fromBundle(bundle);
            if (this.cardArrary == null) {
                this.cardArrary = new LinkedList();
            }
            String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
            if (string != null && string.length() > 0) {
                try {
                    JSONArray jSONArray = ((JSONObject) new JSONTokener(string).nextValue()).getJSONArray("card_list");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        WXCardItem wXCardItem = new WXCardItem();
                        wXCardItem.cardId = jSONObject.optString("card_id");
                        wXCardItem.cardExtMsg = jSONObject.optString("card_ext");
                        wXCardItem.cardState = jSONObject.optInt("is_succ");
                        this.cardArrary.add(wXCardItem);
                    }
                    AppMethodBeat.m2505o(128188);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(128188);
        }

        public int getType() {
            return 9;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.m2504i(128187);
            super.toBundle(bundle);
            JSONStringer jSONStringer = new JSONStringer();
            try {
                jSONStringer.object();
                jSONStringer.key("card_list");
                jSONStringer.array();
                for (WXCardItem wXCardItem : this.cardArrary) {
                    jSONStringer.object();
                    jSONStringer.key("card_id");
                    jSONStringer.value(wXCardItem.cardId);
                    jSONStringer.key("card_ext");
                    jSONStringer.value(wXCardItem.cardExtMsg == null ? "" : wXCardItem.cardExtMsg);
                    jSONStringer.key("is_succ");
                    jSONStringer.value((long) wXCardItem.cardState);
                    jSONStringer.endObject();
                }
                jSONStringer.endArray();
                jSONStringer.endObject();
            } catch (Exception e) {
                Log.m4140e(AddCardToWXCardPackage.TAG, "Resp.toBundle exception:" + e.getMessage());
            }
            bundle.putString("_wxapi_add_card_to_wx_card_list", jSONStringer.toString());
            AppMethodBeat.m2505o(128187);
        }
    }
}
