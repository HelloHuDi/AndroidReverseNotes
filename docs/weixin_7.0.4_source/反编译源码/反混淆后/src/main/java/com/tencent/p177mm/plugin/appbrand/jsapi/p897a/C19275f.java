package com.tencent.p177mm.plugin.appbrand.jsapi.p897a;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38402w;
import com.tencent.p177mm.plugin.appbrand.networking.C42637a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.protocal.protobuf.C7538fw;
import com.tencent.p177mm.protocal.protobuf.C7539fx;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f */
public final class C19275f extends C10296a<C44709u> {
    public static final int CTRL_INDEX = 208;
    public static final String NAME = "requestAuthUserAutoFillData";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$2 */
    class C102952 implements OnClickListener {
        final /* synthetic */ C44709u hCx;

        C102952(C44709u c44709u) {
            this.hCx = c44709u;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(101966);
            C4990ab.m7416i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
            String str = this.hCx.mContext.getString(C25738R.string.g57) + C4988aa.dor();
            C4990ab.m7416i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:".concat(String.valueOf(str)));
            ((C38402w) this.hCx.mo5936B(C38402w.class)).mo20078a(this.hCx.mContext, str, null);
            AppMethodBeat.m2505o(101966);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$4 */
    class C192744 implements DialogInterface.OnClickListener {
        final /* synthetic */ int eIl;
        final /* synthetic */ C7538fw hCE;
        final /* synthetic */ C44709u hCx;

        C192744(C7538fw c7538fw, C44709u c44709u, int i) {
            this.hCE = c7538fw;
            this.hCx = c44709u;
            this.eIl = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(101968);
            C4990ab.m7416i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
            this.hCE.vIb = true;
            this.hCx.mo6107M(this.eIl, C19275f.this.mo73394j("ok", null));
            C19275f.m29943a(this.hCx, this.hCE);
            AppMethodBeat.m2505o(101968);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$3 */
    class C192763 implements DialogInterface.OnClickListener {
        final /* synthetic */ int eIl;
        final /* synthetic */ C7538fw hCE;
        final /* synthetic */ C44709u hCx;

        C192763(C7538fw c7538fw, C44709u c44709u, int i) {
            this.hCE = c7538fw;
            this.hCx = c44709u;
            this.eIl = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(101967);
            C4990ab.m7416i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do not accept the auto fill data protocol");
            this.hCE.vIb = false;
            this.hCx.mo6107M(this.eIl, C19275f.this.mo73394j("cancel", null));
            C19275f.m29943a(this.hCx, this.hCE);
            AppMethodBeat.m2505o(101967);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$5 */
    static class C192775 implements C5681a<Object, C7539fx> {
        C192775() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(101969);
            C7539fx c7539fx = (C7539fx) obj;
            if (c7539fx == null) {
                C4990ab.m7412e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, null response");
                AppMethodBeat.m2505o(101969);
            } else if (c7539fx.BaseResponse.Ret != 0) {
                C4990ab.m7413e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(c7539fx.BaseResponse.Ret), c7539fx.BaseResponse.ErrMsg);
                AppMethodBeat.m2505o(101969);
            } else {
                C4990ab.m7416i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
                AppMethodBeat.m2505o(101969);
            }
            return null;
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(101970);
        final C44709u c44709u = (C44709u) c2241c;
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData data is invalid");
            c44709u.mo6107M(i, mo73394j("fail:data is invalid", null));
            AppMethodBeat.m2505o(101970);
            return;
        }
        int i2;
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray(GraphRequest.FIELDS_PARAM);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        final String optString = jSONObject.optString("wording");
        final int optInt = jSONObject.optInt("authStatus", 2);
        final LinkedList linkedList2 = new LinkedList();
        optJSONArray = jSONObject.optJSONArray("authGroupList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList2.add("  " + optJSONArray.optString(i2));
            }
        }
        if (linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData fields is empty");
            c44709u.mo6107M(i, mo73394j("fail:fields is empty", null));
            AppMethodBeat.m2505o(101970);
        } else if (TextUtils.isEmpty(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording is empty");
            c44709u.mo6107M(i, mo73394j("fail:wording is empty", null));
            AppMethodBeat.m2505o(101970);
        } else {
            C4990ab.m7417i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData appId:%s", c44709u.getAppId());
            C4990ab.m7417i("MicroMsg.JsApiRequestAuthUserAutoFillData", "wording:%s, authType:%d, fieldIds:%s", optString, Integer.valueOf(optInt), jSONObject.optJSONArray(GraphRequest.FIELDS_PARAM).toString());
            if (jSONObject.optJSONArray("authGroupList") != null) {
                C4990ab.m7417i("MicroMsg.JsApiRequestAuthUserAutoFillData", "authGroupList:%s", jSONObject.optJSONArray("authGroupList").toString());
            }
            final C7538fw c7538fw = new C7538fw();
            c7538fw.vIa = linkedList;
            c7538fw.csB = r0;
            c7538fw.vIc = optInt;
            final int i3 = i;
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    String string;
                    AppMethodBeat.m2504i(101965);
                    C19275f c19275f = C19275f.this;
                    C44709u c44709u = c44709u;
                    int i = i3;
                    C7538fw c7538fw = c7538fw;
                    int i2 = optInt;
                    String str = optString;
                    LinkedList linkedList = linkedList2;
                    if (i2 == 2) {
                        string = c44709u.mContext.getString(C25738R.string.f8847gy);
                    } else {
                        string = c44709u.mContext.getString(C25738R.string.f8848gz);
                    }
                    String string2 = c44709u.mContext.getString(C25738R.string.f8849h0);
                    String string3 = c44709u.mContext.getString(C25738R.string.f8846gx);
                    String string4 = c44709u.mContext.getString(C25738R.string.f8845gw);
                    LayoutInflater layoutInflater = (LayoutInflater) c44709u.mContext.getSystemService("layout_inflater");
                    View inflate = layoutInflater.inflate(2130968664, null);
                    TextView textView = (TextView) inflate.findViewById(2131821146);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131821145);
                    ((TextView) inflate.findViewById(2131821144)).setText(str);
                    textView.setText(string4);
                    textView.setOnClickListener(new C102952(c44709u));
                    linearLayout.removeAllViews();
                    if (linkedList == null || linkedList.size() <= 0) {
                        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
                        layoutParams.leftMargin = 0;
                        textView.setLayoutParams(layoutParams);
                        linearLayout.setVisibility(8);
                    } else {
                        linearLayout.setVisibility(0);
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            textView = (TextView) layoutInflater.inflate(2130968660, null);
                            textView.setText((String) it.next());
                            LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                            layoutParams2.bottomMargin = c44709u.getContentView().getResources().getDimensionPixelOffset(C25738R.dimen.f10124qs);
                            textView.setLayoutParams(layoutParams2);
                            linearLayout.addView(textView);
                        }
                    }
                    C4990ab.m7416i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
                    new C5652a(c44709u.mContext).asD(string).mo11479fn(inflate).asJ(string2).mo11457a(new C192744(c7538fw, c44709u, i)).asK(string3).mo11476b(new C192763(c7538fw, c44709u, i)).aMb().show();
                    AppMethodBeat.m2505o(101965);
                }
            });
            AppMethodBeat.m2505o(101970);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m29943a(C44709u c44709u, C7538fw c7538fw) {
        AppMethodBeat.m2504i(101971);
        ((C42637a) c44709u.mo5936B(C42637a.class)).mo22168a("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", c7538fw, C7539fx.class).mo15892c(new C192775());
        AppMethodBeat.m2505o(101971);
    }
}
