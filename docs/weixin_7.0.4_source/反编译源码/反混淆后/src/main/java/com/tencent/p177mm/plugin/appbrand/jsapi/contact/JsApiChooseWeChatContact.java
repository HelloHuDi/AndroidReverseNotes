package com.tencent.p177mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact */
public final class JsApiChooseWeChatContact extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 195;
    public static final String NAME = "chooseWeChatContact";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact$GetUserDataTask */
    static class GetUserDataTask extends MainProcessTask {
        public static final Creator<GetUserDataTask> CREATOR = new C332781();
        String bCu;
        String bCv;
        String gEl = "";
        public String hIl;
        public String userName;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact$GetUserDataTask$1 */
        static class C332781 implements Creator<GetUserDataTask> {
            C332781() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetUserDataTask[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(130992);
                GetUserDataTask getUserDataTask = new GetUserDataTask(parcel);
                AppMethodBeat.m2505o(130992);
                return getUserDataTask;
            }
        }

        public GetUserDataTask(String str) {
            this.userName = str;
        }

        public GetUserDataTask(Parcel parcel) {
            AppMethodBeat.m2504i(130993);
            mo6032g(parcel);
            AppMethodBeat.m2505o(130993);
        }

        public final void asP() {
            AppMethodBeat.m2504i(130994);
            this.hIl = C1853r.m3846Yz();
            if (!TextUtils.isEmpty(this.userName)) {
                this.bCu = C1854s.m3865mI(this.userName);
                this.bCv = C1854s.m3867mK(this.userName);
                C17880h qo = C17884o.act().mo33392qo(this.userName);
                if (qo != null) {
                    this.gEl = qo.ack();
                    if (C5046bo.isNullOrNil(this.gEl)) {
                        this.gEl = qo.acl();
                    }
                }
            }
            AppMethodBeat.m2505o(130994);
        }

        /* renamed from: g */
        public final void mo6032g(Parcel parcel) {
            AppMethodBeat.m2504i(130995);
            this.hIl = parcel.readString();
            this.userName = parcel.readString();
            this.bCu = parcel.readString();
            this.bCv = parcel.readString();
            this.gEl = parcel.readString();
            AppMethodBeat.m2505o(130995);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(130996);
            parcel.writeString(this.hIl);
            parcel.writeString(this.userName);
            parcel.writeString(this.bCu);
            parcel.writeString(this.bCv);
            parcel.writeString(this.gEl);
            AppMethodBeat.m2505o(130996);
        }

        static {
            AppMethodBeat.m2504i(130997);
            AppMethodBeat.m2505o(130997);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(130998);
        final C38492q c38492q = (C38492q) c2241c;
        MMActivity mMActivity = (MMActivity) c38492q.mo61197ad(MMActivity.class);
        if (mMActivity == null) {
            C4990ab.m7413e("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact context is null, appId is %s", c38492q.getAppId());
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130998);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact appId:%s", c38492q.getAppId());
        Intent intent = new Intent();
        String string = mMActivity.getString(C25738R.string.f9317wg);
        int i2 = C31128d.MIC_PTU_ZIPAI_MEDSEA;
        int[] iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        C4990ab.m7417i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact data %s:", jSONObject);
        if (!(jSONObject == null || jSONObject.optJSONArray("contactMode") == null || jSONObject.optJSONArray("contactMode").length() <= 0)) {
            String jSONArray = jSONObject.optJSONArray("contactMode").toString();
            if (jSONArray.contains("singleContact") && !jSONArray.contains("chatroom")) {
                i2 = C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION;
                string = mMActivity.getString(C25738R.string.f9316wf);
                iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            } else if (jSONArray.contains("chatroom") && !jSONArray.contains("singleContact")) {
                i2 = C31128d.MIC_GPU_AUTOLEVEL;
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
        AppBrandMainProcessService.m54355b(getUserDataTask);
        intent.putExtra("Select_block_List", getUserDataTask.hIl);
        C25985d.m41460a(mMActivity, ".ui.transmit.SelectConversationUI", intent, 100, new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130991);
                if (100 != i) {
                    C4990ab.m7413e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact requestCode not equal, requestCode = %d", Integer.valueOf(i));
                    c38492q.mo6107M(i, JsApiChooseWeChatContact.this.mo73394j("fail", null));
                    AppMethodBeat.m2505o(130991);
                } else if (i2 == 0 || i2 == 1) {
                    C4990ab.m7413e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact user cancel, resultCode = %d", Integer.valueOf(i));
                    c38492q.mo6107M(i, JsApiChooseWeChatContact.this.mo73394j("cancel", null));
                    AppMethodBeat.m2505o(130991);
                } else {
                    if (i2 == -1) {
                        String str;
                        if (intent == null) {
                            str = null;
                        } else {
                            str = intent.getStringExtra("Select_Conv_User");
                        }
                        if (str == null || str.length() == 0) {
                            C4990ab.m7412e("MicroMsg.JsApiChooseWeChatContact", "mmOnActivityResult, selectSingleContact fail, user is null");
                            c38492q.mo6107M(i, JsApiChooseWeChatContact.this.mo73394j("fail", null));
                            AppMethodBeat.m2505o(130991);
                            return;
                        }
                        MainProcessTask getUserDataTask = new GetUserDataTask(str);
                        AppBrandMainProcessService.m54355b(getUserDataTask);
                        String str2 = getUserDataTask.bCu;
                        String str3 = getUserDataTask.bCv;
                        String str4 = getUserDataTask.gEl;
                        HashMap hashMap = new HashMap();
                        hashMap.put("avatarUrl", str4);
                        hashMap.put("userName", str);
                        hashMap.put("nickName", str2);
                        hashMap.put("remarkName", str3);
                        C4990ab.m7417i("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact: nickName:%s, remarkName:%s", str2, str3);
                        c38492q.mo6107M(i, JsApiChooseWeChatContact.this.mo73394j("ok", hashMap));
                    }
                    AppMethodBeat.m2505o(130991);
                }
            }
        });
        AppMethodBeat.m2505o(130998);
    }
}
