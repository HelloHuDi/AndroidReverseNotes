package com.tencent.mm.plugin.appbrand.jsapi.a;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.protocal.protobuf.fw;
import com.tencent.mm.protocal.protobuf.fx;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends a<u> {
    public static final int CTRL_INDEX = 208;
    public static final String NAME = "requestAuthUserAutoFillData";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$2 */
    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ u hCx;

        AnonymousClass2(u uVar) {
            this.hCx = uVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(101966);
            ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
            String str = this.hCx.mContext.getString(R.string.g57) + aa.dor();
            ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:".concat(String.valueOf(str)));
            ((w) this.hCx.B(w.class)).a(this.hCx.mContext, str, null);
            AppMethodBeat.o(101966);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$4 */
    class AnonymousClass4 implements DialogInterface.OnClickListener {
        final /* synthetic */ int eIl;
        final /* synthetic */ fw hCE;
        final /* synthetic */ u hCx;

        AnonymousClass4(fw fwVar, u uVar, int i) {
            this.hCE = fwVar;
            this.hCx = uVar;
            this.eIl = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(101968);
            ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
            this.hCE.vIb = true;
            this.hCx.M(this.eIl, f.this.j("ok", null));
            f.a(this.hCx, this.hCE);
            AppMethodBeat.o(101968);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.a.f$3 */
    class AnonymousClass3 implements DialogInterface.OnClickListener {
        final /* synthetic */ int eIl;
        final /* synthetic */ fw hCE;
        final /* synthetic */ u hCx;

        AnonymousClass3(fw fwVar, u uVar, int i) {
            this.hCE = fwVar;
            this.hCx = uVar;
            this.eIl = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(101967);
            ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do not accept the auto fill data protocol");
            this.hCE.vIb = false;
            this.hCx.M(this.eIl, f.this.j("cancel", null));
            f.a(this.hCx, this.hCE);
            AppMethodBeat.o(101967);
        }
    }

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(101970);
        final u uVar = (u) cVar;
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData data is invalid");
            uVar.M(i, j("fail:data is invalid", null));
            AppMethodBeat.o(101970);
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
            ab.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData fields is empty");
            uVar.M(i, j("fail:fields is empty", null));
            AppMethodBeat.o(101970);
        } else if (TextUtils.isEmpty(optString)) {
            ab.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording is empty");
            uVar.M(i, j("fail:wording is empty", null));
            AppMethodBeat.o(101970);
        } else {
            ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData appId:%s", uVar.getAppId());
            ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "wording:%s, authType:%d, fieldIds:%s", optString, Integer.valueOf(optInt), jSONObject.optJSONArray(GraphRequest.FIELDS_PARAM).toString());
            if (jSONObject.optJSONArray("authGroupList") != null) {
                ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "authGroupList:%s", jSONObject.optJSONArray("authGroupList").toString());
            }
            final fw fwVar = new fw();
            fwVar.vIa = linkedList;
            fwVar.csB = r0;
            fwVar.vIc = optInt;
            final int i3 = i;
            al.d(new Runnable() {
                public final void run() {
                    String string;
                    AppMethodBeat.i(101965);
                    f fVar = f.this;
                    u uVar = uVar;
                    int i = i3;
                    fw fwVar = fwVar;
                    int i2 = optInt;
                    String str = optString;
                    LinkedList linkedList = linkedList2;
                    if (i2 == 2) {
                        string = uVar.mContext.getString(R.string.gy);
                    } else {
                        string = uVar.mContext.getString(R.string.gz);
                    }
                    String string2 = uVar.mContext.getString(R.string.h0);
                    String string3 = uVar.mContext.getString(R.string.gx);
                    String string4 = uVar.mContext.getString(R.string.gw);
                    LayoutInflater layoutInflater = (LayoutInflater) uVar.mContext.getSystemService("layout_inflater");
                    View inflate = layoutInflater.inflate(R.layout.bo, null);
                    TextView textView = (TextView) inflate.findViewById(R.id.pk);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.pj);
                    ((TextView) inflate.findViewById(R.id.pi)).setText(str);
                    textView.setText(string4);
                    textView.setOnClickListener(new AnonymousClass2(uVar));
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
                            textView = (TextView) layoutInflater.inflate(R.layout.bk, null);
                            textView.setText((String) it.next());
                            LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                            layoutParams2.bottomMargin = uVar.getContentView().getResources().getDimensionPixelOffset(R.dimen.qs);
                            textView.setLayoutParams(layoutParams2);
                            linearLayout.addView(textView);
                        }
                    }
                    ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
                    new com.tencent.mm.ui.widget.a.c.a(uVar.mContext).asD(string).fn(inflate).asJ(string2).a(new AnonymousClass4(fwVar, uVar, i)).asK(string3).b(new AnonymousClass3(fwVar, uVar, i)).aMb().show();
                    AppMethodBeat.o(101965);
                }
            });
            AppMethodBeat.o(101970);
        }
    }

    static /* synthetic */ void a(u uVar, fw fwVar) {
        AppMethodBeat.i(101971);
        ((com.tencent.mm.plugin.appbrand.networking.a) uVar.B(com.tencent.mm.plugin.appbrand.networking.a.class)).a("/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo", fwVar, fx.class).c(new com.tencent.mm.vending.c.a<Object, fx>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(101969);
                fx fxVar = (fx) obj;
                if (fxVar == null) {
                    ab.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, null response");
                    AppMethodBeat.o(101969);
                } else if (fxVar.BaseResponse.Ret != 0) {
                    ab.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(fxVar.BaseResponse.Ret), fxVar.BaseResponse.ErrMsg);
                    AppMethodBeat.o(101969);
                } else {
                    ab.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
                    AppMethodBeat.o(101969);
                }
                return null;
            }
        });
        AppMethodBeat.o(101971);
    }
}
