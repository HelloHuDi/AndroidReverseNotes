package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;

public class ChooseCardFromWXCardPackage {
    private static final String TAG = "MicroMsg.ChooseCardFromWXCardPackage";

    public static class Resp extends BaseResp {
        public String cardItemList;

        public Resp(Bundle bundle) {
            AppMethodBeat.i(128196);
            fromBundle(bundle);
            AppMethodBeat.o(128196);
        }

        public boolean checkArgs() {
            AppMethodBeat.i(128197);
            if (this.cardItemList == null || this.cardItemList.length() == 0) {
                AppMethodBeat.o(128197);
                return false;
            }
            AppMethodBeat.o(128197);
            return true;
        }

        public void fromBundle(Bundle bundle) {
            AppMethodBeat.i(128199);
            super.fromBundle(bundle);
            String string = bundle.getString("_wxapi_choose_card_from_wx_card_list");
            if (string == null || string.length() <= 0) {
                Log.i(ChooseCardFromWXCardPackage.TAG, "cardItemList is empty!");
                AppMethodBeat.o(128199);
                return;
            }
            this.cardItemList = string;
            AppMethodBeat.o(128199);
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128198);
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_list", this.cardItemList);
            AppMethodBeat.o(128198);
        }
    }

    public static class Req extends BaseReq {
        public String appId;
        public String canMultiSelect;
        public String cardId;
        public String cardSign;
        public String cardType;
        public String locationId;
        public String nonceStr;
        public String signType;
        public String timeStamp;

        public boolean checkArgs() {
            AppMethodBeat.i(128176);
            if (this.appId == null || this.appId.length() <= 0) {
                AppMethodBeat.o(128176);
                return false;
            } else if (this.signType == null || this.signType.length() <= 0) {
                AppMethodBeat.o(128176);
                return false;
            } else if (this.cardSign == null || this.cardSign.length() <= 0) {
                AppMethodBeat.o(128176);
                return false;
            } else {
                AppMethodBeat.o(128176);
                return true;
            }
        }

        public int getType() {
            return 16;
        }

        public void toBundle(Bundle bundle) {
            AppMethodBeat.i(128177);
            super.toBundle(bundle);
            bundle.putString("_wxapi_choose_card_from_wx_card_app_id", this.appId);
            bundle.putString("_wxapi_choose_card_from_wx_card_location_id", this.locationId);
            bundle.putString("_wxapi_choose_card_from_wx_card_sign_type", this.signType);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_sign", this.cardSign);
            bundle.putString("_wxapi_choose_card_from_wx_card_time_stamp", this.timeStamp);
            bundle.putString("_wxapi_choose_card_from_wx_card_nonce_str", this.nonceStr);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_id", this.cardId);
            bundle.putString("_wxapi_choose_card_from_wx_card_card_type", this.cardType);
            bundle.putString("_wxapi_choose_card_from_wx_card_can_multi_select", this.canMultiSelect);
            AppMethodBeat.o(128177);
        }
    }
}
