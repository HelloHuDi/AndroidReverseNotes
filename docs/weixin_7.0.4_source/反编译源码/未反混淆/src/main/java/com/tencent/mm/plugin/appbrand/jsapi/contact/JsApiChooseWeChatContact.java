package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.view.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiChooseWeChatContact extends a<q> {
    public static final int CTRL_INDEX = 195;
    public static final String NAME = "chooseWeChatContact";

    static class GetUserDataTask extends MainProcessTask {
        public static final Creator<GetUserDataTask> CREATOR = new Creator<GetUserDataTask>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetUserDataTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(130992);
                GetUserDataTask getUserDataTask = new GetUserDataTask(parcel);
                AppMethodBeat.o(130992);
                return getUserDataTask;
            }
        };
        String bCu;
        String bCv;
        String gEl = "";
        public String hIl;
        public String userName;

        public GetUserDataTask(String str) {
            this.userName = str;
        }

        public GetUserDataTask(Parcel parcel) {
            AppMethodBeat.i(130993);
            g(parcel);
            AppMethodBeat.o(130993);
        }

        public final void asP() {
            AppMethodBeat.i(130994);
            this.hIl = r.Yz();
            if (!TextUtils.isEmpty(this.userName)) {
                this.bCu = s.mI(this.userName);
                this.bCv = s.mK(this.userName);
                h qo = o.act().qo(this.userName);
                if (qo != null) {
                    this.gEl = qo.ack();
                    if (bo.isNullOrNil(this.gEl)) {
                        this.gEl = qo.acl();
                    }
                }
            }
            AppMethodBeat.o(130994);
        }

        public final void g(Parcel parcel) {
            AppMethodBeat.i(130995);
            this.hIl = parcel.readString();
            this.userName = parcel.readString();
            this.bCu = parcel.readString();
            this.bCv = parcel.readString();
            this.gEl = parcel.readString();
            AppMethodBeat.o(130995);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(130996);
            parcel.writeString(this.hIl);
            parcel.writeString(this.userName);
            parcel.writeString(this.bCu);
            parcel.writeString(this.bCv);
            parcel.writeString(this.gEl);
            AppMethodBeat.o(130996);
        }

        static {
            AppMethodBeat.i(130997);
            AppMethodBeat.o(130997);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(130998);
        final q qVar = (q) cVar;
        MMActivity mMActivity = (MMActivity) qVar.ad(MMActivity.class);
        if (mMActivity == null) {
            ab.e("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact context is null, appId is %s", qVar.getAppId());
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(130998);
            return;
        }
        ab.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact appId:%s", qVar.getAppId());
        Intent intent = new Intent();
        String string = mMActivity.getString(R.string.wg);
        int i2 = d.MIC_PTU_ZIPAI_MEDSEA;
        int[] iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        ab.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact data %s:", jSONObject);
        if (!(jSONObject == null || jSONObject.optJSONArray("contactMode") == null || jSONObject.optJSONArray("contactMode").length() <= 0)) {
            String jSONArray = jSONObject.optJSONArray("contactMode").toString();
            if (jSONArray.contains("singleContact") && !jSONArray.contains("chatroom")) {
                i2 = d.MIC_PTU_ZIPAI_GRADIENT_FASHION;
                string = mMActivity.getString(R.string.wf);
                iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            } else if (jSONArray.contains("chatroom") && !jSONArray.contains("singleContact")) {
                i2 = d.MIC_GPU_AUTOLEVEL;
                iArr = new int[]{131075};
            }
        }
        intent.putExtra("Select_Conv_Type", i2);
        intent.putExtra("jsapi_select_mode", 1);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 9);
        intent.putExtra("Select_Conv_ui_title", string);
        intent.putExtra("search_range", iArr);
        MainProcessTask getUserDataTask = new GetUserDataTask("");
        AppBrandMainProcessService.b(getUserDataTask);
        intent.putExtra("Select_block_List", getUserDataTask.hIl);
        com.tencent.mm.bp.d.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, 100, new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(130991);
                if (100 != i) {
                    ab.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact requestCode not equal, requestCode = %d", Integer.valueOf(i));
                    qVar.M(i, JsApiChooseWeChatContact.this.j("fail", null));
                    AppMethodBeat.o(130991);
                } else if (i2 == 0 || i2 == 1) {
                    ab.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact user cancel, resultCode = %d", Integer.valueOf(i));
                    qVar.M(i, JsApiChooseWeChatContact.this.j("cancel", null));
                    AppMethodBeat.o(130991);
                } else {
                    if (i2 == -1) {
                        String str;
                        if (intent == null) {
                            str = null;
                        } else {
                            str = intent.getStringExtra("Select_Conv_User");
                        }
                        if (str == null || str.length() == 0) {
                            ab.e("MicroMsg.JsApiChooseWeChatContact", "mmOnActivityResult, selectSingleContact fail, user is null");
                            qVar.M(i, JsApiChooseWeChatContact.this.j("fail", null));
                            AppMethodBeat.o(130991);
                            return;
                        }
                        MainProcessTask getUserDataTask = new GetUserDataTask(str);
                        AppBrandMainProcessService.b(getUserDataTask);
                        String str2 = getUserDataTask.bCu;
                        String str3 = getUserDataTask.bCv;
                        String str4 = getUserDataTask.gEl;
                        HashMap hashMap = new HashMap();
                        hashMap.put("avatarUrl", str4);
                        hashMap.put("userName", str);
                        hashMap.put("nickName", str2);
                        hashMap.put("remarkName", str3);
                        ab.i("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact: nickName:%s, remarkName:%s", str2, str3);
                        qVar.M(i, JsApiChooseWeChatContact.this.j("ok", hashMap));
                    }
                    AppMethodBeat.o(130991);
                }
            }
        });
        AppMethodBeat.o(130998);
    }
}
