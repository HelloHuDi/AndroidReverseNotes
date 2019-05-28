package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.t;
import a.f.b.v;
import a.y;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.be;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(7)
@a.l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010A\u001a\u00020BH\u0002J\u0012\u0010C\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010E\u001a\u00020B2\b\u0010F\u001a\u0004\u0018\u00010\u00052\b\u0010G\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010H\u001a\u00020IH\u0014J\u0012\u0010J\u001a\u00020B2\b\b\u0002\u0010K\u001a\u00020\u001dH\u0002J\b\u0010L\u001a\u00020BH\u0016J\u0012\u0010M\u001a\u00020B2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020BH\u0014J\b\u0010Q\u001a\u00020BH\u0016J\b\u0010R\u001a\u00020BH\u0014J\b\u0010S\u001a\u00020BH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001a\u0010'\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR*\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 ¨\u0006U"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout$DismissAnimationEndListener;", "()V", "apiName", "", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "appIcon", "getAppIcon", "setAppIcon", "appId", "getAppId", "setAppId", "appName", "getAppName", "setAppName", "authDesc", "getAuthDesc", "setAuthDesc", "desc", "getDesc", "setDesc", "extDesc", "getExtDesc", "setExtDesc", "isFirstOpen", "", "()Z", "setFirstOpen", "(Z)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getMDialogContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mDialogContainer$delegate", "Lkotlin/Lazy;", "pagePath", "getPagePath", "setPagePath", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneNumberManageDialog", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "getPhoneNumberManageDialog", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "setPhoneNumberManageDialog", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;)V", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "getReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "setReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;)V", "withCredentials", "getWithCredentials", "setWithCredentials", "doBindPhoneNumber", "", "finishWithFail", "errMsg", "finishWithSuccess", "encryptedData", "iv", "getLayoutId", "", "getPhoneItemsFromServer", "isFirst", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnd", "onResume", "tryToBindWechatPhoneNumber", "Companion", "plugin-appbrand-integration_release"})
public final class PhoneNumberProxyUI extends MMActivity implements com.tencent.mm.plugin.appbrand.widget.b.e.a {
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(PhoneNumberProxyUI.class), "mDialogContainer", "getMDialogContainer()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;"))};
    public static final a iyP = new a();
    String appId = "";
    private String appName = "";
    String csu = "";
    String desc;
    private String hac = "";
    be ixV;
    ArrayList<PhoneItem> ixy = new ArrayList();
    String iyA;
    private String iyJ = "";
    private boolean iyK;
    l iyL;
    String iyM;
    private final a.f iyN = a.i.g(new e(this));
    private boolean iyO = true;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class d implements OnCancelListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        d(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(134871);
            PhoneNumberProxyUI.a(this.iyQ, "fail:user cancel");
            AppMethodBeat.o(134871);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberProxyUI$onCreate$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;", "onPhoneItemSelect", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "plugin-appbrand-integration_release"})
    public static final class f implements com.tencent.mm.plugin.appbrand.phonenumber.l.b {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberProxyUI$onCreate$1$onPhoneItemSelect$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "plugin-appbrand-integration_release"})
        public static final class a implements com.tencent.mm.plugin.appbrand.phonenumber.m.b {
            final /* synthetic */ PhoneItem ixE;
            final /* synthetic */ f iyS;

            a(f fVar, PhoneItem phoneItem) {
                this.iyS = fVar;
                this.ixE = phoneItem;
            }

            public final void a(boolean z, Map<String, String> map) {
                Long l = null;
                AppMethodBeat.i(134873);
                a.f.b.j.p(map, "result");
                if (z) {
                    be beVar;
                    be beVar2;
                    if (this.ixE.ixM) {
                        beVar = this.iyS.iyQ.ixV;
                        if (beVar != null) {
                            beVar2 = this.iyS.iyQ.ixV;
                            if (beVar2 != null) {
                                l = Long.valueOf(beVar2.GB());
                            }
                            if (l == null) {
                                a.f.b.j.dWJ();
                            }
                            beVar.cR(l.longValue() + 1);
                        }
                    } else {
                        beVar = this.iyS.iyQ.ixV;
                        if (beVar != null) {
                            beVar2 = this.iyS.iyQ.ixV;
                            if (beVar2 != null) {
                                l = Long.valueOf(beVar2.GC());
                            }
                            if (l == null) {
                                a.f.b.j.dWJ();
                            }
                            beVar.cS(l.longValue() + 1);
                        }
                    }
                    PhoneNumberProxyUI.a(this.iyS.iyQ, (String) map.get("encryptedData"), (String) map.get("iv"));
                    j.ixQ.b(this.ixE);
                }
                AppMethodBeat.o(134873);
            }
        }

        f(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void c(PhoneItem phoneItem) {
            be beVar;
            Long l = null;
            AppMethodBeat.i(134874);
            a.f.b.j.p(phoneItem, "phoneItem");
            com.tencent.luggage.g.d.d("MicroMsg.PhoneNumberProxyUI", "selelct phoneItem:%s", phoneItem);
            be beVar2 = this.iyQ.ixV;
            if (beVar2 != null) {
                Long valueOf;
                beVar = this.iyQ.ixV;
                if (beVar != null) {
                    valueOf = Long.valueOf(beVar.Gy());
                } else {
                    valueOf = null;
                }
                if (valueOf == null) {
                    a.f.b.j.dWJ();
                }
                beVar2.cO(valueOf.longValue() + 1);
            }
            if (phoneItem.ixK) {
                Context context = this.iyQ;
                String str = this.iyQ.appId;
                be beVar3 = this.iyQ.ixV;
                String str2 = this.iyQ.iyM;
                if (str2 == null) {
                    str2 = "";
                }
                new m(context, str, beVar3, str2, phoneItem, new a(this, phoneItem)).ez(true);
                AppMethodBeat.o(134874);
                return;
            }
            if (phoneItem.ixM) {
                beVar = this.iyQ.ixV;
                if (beVar != null) {
                    beVar2 = this.iyQ.ixV;
                    if (beVar2 != null) {
                        l = Long.valueOf(beVar2.GB());
                    }
                    if (l == null) {
                        a.f.b.j.dWJ();
                    }
                    beVar.cR(l.longValue() + 1);
                }
            } else {
                beVar = this.iyQ.ixV;
                if (beVar != null) {
                    beVar2 = this.iyQ.ixV;
                    if (beVar2 != null) {
                        l = Long.valueOf(beVar2.GC());
                    }
                    if (l == null) {
                        a.f.b.j.dWJ();
                    }
                    beVar.cS(l.longValue() + 1);
                }
            }
            PhoneNumberProxyUI.a(this.iyQ, phoneItem.ixJ, phoneItem.biC);
            j.ixQ.b(phoneItem);
            AppMethodBeat.o(134874);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class l implements OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        l(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(134880);
            com.tencent.luggage.g.d.i("MicroMsg.PhoneNumberProxyUI", "cancel to bind phone number");
            dialogInterface.dismiss();
            PhoneNumberProxyUI.a(this.iyQ, "fail:user cancel");
            AppMethodBeat.o(134880);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ PhoneNumberProxyUI iyQ;
        final /* synthetic */ boolean iyR = false;
        final /* synthetic */ p iyc;

        c(PhoneNumberProxyUI phoneNumberProxyUI, p pVar) {
            this.iyQ = phoneNumberProxyUI;
            this.iyc = pVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(134870);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            com.tencent.luggage.g.d.i("MicroMsg.PhoneNumberProxyUI", "getPhoneNumber errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.aIm);
            p pVar = this.iyc;
            a.f.b.j.o(pVar, "progressDialog");
            if (pVar.isShowing()) {
                this.iyc.dismiss();
            }
            if (aVar.errType != 0 || aVar.errCode != 0) {
                this.iyQ.setResult(1);
                this.iyQ.finish();
            } else if (((awd) aVar.fsy).wzH.cyE != 0) {
                com.tencent.luggage.g.d.e("MicroMsg.PhoneNumberProxyUI", "JsApiBaseResponse is err, errCode:%d errMsg:%s", Integer.valueOf(((awd) aVar.fsy).wzH.cyE), ((awd) aVar.fsy).wzH.cyF);
                PhoneNumberProxyUI.a(this.iyQ, ((awd) aVar.fsy).wzH.cyF);
            } else {
                String str;
                l lVar = this.iyQ.iyL;
                if (lVar != null) {
                    str = ((awd) aVar.fsy).ncH;
                    if (str == null) {
                        str = "";
                    }
                    lVar.Du(str);
                }
                lVar = this.iyQ.iyL;
                if (lVar != null) {
                    str = ((awd) aVar.fsy).vDm;
                    if (str == null) {
                        str = "";
                    }
                    lVar.Dt(str);
                }
                this.iyQ.desc = ((awd) aVar.fsy).wzS.Desc;
                this.iyQ.iyM = ((awd) aVar.fsy).wzS.iyZ;
                this.iyQ.iyA = ((awd) aVar.fsy).wzS.wze;
                JSONObject jSONObject = new JSONObject(((awd) aVar.fsy).jBi.dlY());
                ArrayList arrayList = new ArrayList();
                com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem.a aVar2 = PhoneItem.ixO;
                str = jSONObject.optString("wx_phone");
                a.f.b.j.o(str, "phoneItemsJsonObj.optString(\"wx_phone\")");
                PhoneItem Ds = com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem.a.Ds(str);
                if (this.iyR) {
                    be beVar = this.iyQ.ixV;
                    if (beVar != null) {
                        beVar.cL(Ds == null ? 1 : 0);
                    }
                }
                if (Ds == null) {
                    com.tencent.luggage.g.d.e("MicroMsg.PhoneNumberProxyUI", "wxPhoneItem is null, tryToBindWechatPhoneNumber");
                    PhoneNumberProxyUI.c(this.iyQ);
                } else if (this.iyQ.isFinishing()) {
                    com.tencent.luggage.g.d.e("MicroMsg.PhoneNumberProxyUI", "activity is destroy, err");
                } else {
                    PhoneNumberProxyUI.b(this.iyQ).b((com.tencent.mm.plugin.appbrand.widget.b.j) this.iyQ.iyL);
                    Ds.ixM = true;
                    arrayList.add(Ds);
                    com.tencent.luggage.g.d.d("MicroMsg.PhoneNumberProxyUI", "wxPhoneItem:%s", Ds);
                    JSONArray optJSONArray = jSONObject.optJSONArray("custom_phone_list");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length() - 1;
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem.a aVar3 = PhoneItem.ixO;
                                String string = optJSONArray.getString(i);
                                a.f.b.j.o(string, "customPhoneItemsObjArray.getString(i)");
                                PhoneItem Ds2 = com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem.a.Ds(string);
                                if (Ds2 != null) {
                                    com.tencent.luggage.g.d.d("MicroMsg.PhoneNumberProxyUI", "phoneItem:%s", Ds2);
                                    arrayList.add(Ds2);
                                }
                                if (i == length) {
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                    j.ixQ.aM(arrayList);
                    PhoneNumberProxyUI phoneNumberProxyUI = this.iyQ;
                    List aKN = j.ixQ.aKN();
                    if (aKN == null) {
                        a.v vVar = new a.v("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> /* = java.util.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> */");
                        AppMethodBeat.o(134870);
                        throw vVar;
                    }
                    ArrayList arrayList2 = (ArrayList) aKN;
                    a.f.b.j.p(arrayList2, "<set-?>");
                    phoneNumberProxyUI.ixy = arrayList2;
                    l lVar2 = this.iyQ.iyL;
                    if (lVar2 != null) {
                        lVar2.p(this.iyQ.ixy);
                    }
                    lVar2 = this.iyQ.iyL;
                    if (lVar2 != null) {
                        lVar2.aKQ();
                    }
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(134870);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<com.tencent.mm.plugin.appbrand.widget.b.e> {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        e(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(134872);
            com.tencent.mm.plugin.appbrand.widget.b.e eVar = new com.tencent.mm.plugin.appbrand.widget.b.e(this.iyQ);
            AppMethodBeat.o(134872);
            return eVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    static final class b implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        b(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void c(int i, int i2, Intent intent) {
            AppMethodBeat.i(134869);
            if (i == 100) {
                be beVar;
                if (i2 == -1) {
                    com.tencent.luggage.g.d.i("MicroMsg.PhoneNumberProxyUI", "mmOnActivityResult RESULT_OK");
                    PhoneNumberProxyUI.a(this.iyQ);
                    beVar = this.iyQ.ixV;
                    if (beVar != null) {
                        beVar.cM(1);
                    }
                } else {
                    com.tencent.luggage.g.d.e("MicroMsg.PhoneNumberProxyUI", "mmOnActivityResult RESULT_CANCEL OR RESULT_FIRST_USER");
                    beVar = this.iyQ.ixV;
                    if (beVar != null) {
                        beVar.cM(0);
                    }
                    PhoneNumberProxyUI.a(this.iyQ, "fail:user cancel");
                }
                this.iyQ.dye();
            }
            AppMethodBeat.o(134869);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        g(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(134875);
            be beVar = this.iyQ.ixV;
            if (beVar != null) {
                be beVar2 = this.iyQ.ixV;
                Long valueOf = beVar2 != null ? Long.valueOf(beVar2.Gz()) : null;
                if (valueOf == null) {
                    a.f.b.j.dWJ();
                }
                beVar.cP(valueOf.longValue() + 1);
            }
            PhoneNumberProxyUI.a(this.iyQ, "user deny");
            AppMethodBeat.o(134875);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class h implements OnDismissListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        h(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(134876);
            be beVar = this.iyQ.ixV;
            if (beVar != null) {
                be beVar2 = this.iyQ.ixV;
                Long valueOf = beVar2 != null ? Long.valueOf(beVar2.GA()) : null;
                if (valueOf == null) {
                    a.f.b.j.dWJ();
                }
                beVar.cQ(valueOf.longValue() + 1);
            }
            PhoneNumberProxyUI.a(this.iyQ, "user cancel");
            AppMethodBeat.o(134876);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        i(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(View view) {
            int measuredHeight;
            AppMethodBeat.i(134877);
            be beVar = this.iyQ.ixV;
            if (beVar != null) {
                Long valueOf;
                be beVar2 = this.iyQ.ixV;
                if (beVar2 != null) {
                    valueOf = Long.valueOf(beVar2.GD());
                } else {
                    valueOf = null;
                }
                if (valueOf == null) {
                    a.f.b.j.dWJ();
                }
                beVar.cT(valueOf.longValue() + 1);
            }
            String str = this.iyQ.appId;
            String str2 = this.iyQ.csu;
            AppCompatActivity dxU = this.iyQ.dxU();
            a.f.b.j.o(dxU, "context");
            k kVar = new k(str, str2, dxU);
            String str3 = this.iyQ.iyA;
            if (str3 == null) {
                str3 = kVar.context.getString(R.string.vw);
            }
            kVar.gKl.setText(str3);
            l lVar = this.iyQ.iyL;
            if (lVar != null) {
                measuredHeight = lVar.iym.getMeasuredHeight();
            } else {
                measuredHeight = -1;
            }
            kVar.iyk = PhoneNumberProxyUI.b(this.iyQ);
            kVar.iyl.setOnClickListener(new a(kVar));
            com.tencent.mm.plugin.appbrand.widget.b.k kVar2 = kVar.iyk;
            if (kVar2 != null) {
                kVar2.b(kVar);
            }
            if (measuredHeight >= 0) {
                View view2 = kVar.iym;
                LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = measuredHeight;
                } else {
                    layoutParams = null;
                }
                view2.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(134877);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        j(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(View view) {
            Long l = null;
            AppMethodBeat.i(134878);
            AppCompatActivity dxU;
            be beVar;
            be beVar2;
            if (this.iyQ.ixy.size() == 1) {
                com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.a aVar = PhoneNumberAddUI.ixW;
                dxU = this.iyQ.dxU();
                a.f.b.j.o(dxU, "context");
                com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.a.X(dxU, this.iyQ.appId);
                beVar = this.iyQ.ixV;
                if (beVar != null) {
                    beVar2 = this.iyQ.ixV;
                    if (beVar2 != null) {
                        l = Long.valueOf(beVar2.GE());
                    }
                    if (l == null) {
                        a.f.b.j.dWJ();
                    }
                    beVar.cU(l.longValue() + 1);
                    AppMethodBeat.o(134878);
                    return;
                }
                AppMethodBeat.o(134878);
                return;
            }
            com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI.a aVar2 = PhoneNumberManagerUI.iyG;
            dxU = this.iyQ.dxU();
            a.f.b.j.o(dxU, "context");
            Context context = dxU;
            String str = this.iyQ.appId;
            String str2 = this.iyQ.csu;
            Object obj = this.iyQ.iyA;
            if (obj == null) {
                obj = "";
            }
            a.f.b.j.p(context, "context");
            a.f.b.j.p(str, "appId");
            a.f.b.j.p(str2, "pagePath");
            a.f.b.j.p(obj, "authDesc");
            Intent intent = new Intent(context, PhoneNumberManagerUI.class);
            intent.putExtra("APPID", str);
            intent.putExtra("AUTHDESC", obj);
            intent.putExtra("PAGEPATH", str2);
            intent.putExtra("SHOW_DELETE", false);
            context.startActivity(intent);
            beVar2 = this.iyQ.ixV;
            if (beVar2 != null) {
                beVar = this.iyQ.ixV;
                Long valueOf = beVar != null ? Long.valueOf(beVar.GF()) : null;
                if (valueOf == null) {
                    a.f.b.j.dWJ();
                }
                beVar2.cV(valueOf.longValue() + 1);
                AppMethodBeat.o(134878);
                return;
            }
            AppMethodBeat.o(134878);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class k implements OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        k(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(134879);
            com.tencent.luggage.g.d.i("MicroMsg.PhoneNumberProxyUI", "confirm bind phone number");
            PhoneNumberProxyUI.d(this.iyQ);
            AppMethodBeat.o(134879);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberProxyUI$Companion;", "", "()V", "API_NAME", "", "APP_ICON", "APP_ID", "APP_NAME", "ENCRYPTEDDATA", "ERRMSG", "IV", "PAGE_PATH", "REQUEST_BIND_WECHAT_PHONE_NUMBER", "", "TAG", "WITH_CREDENTIALS", "showDialog", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "appId", "appName", "appIcon", "pagePath", "apiName", "withCredentials", "", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requsetCode", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(134881);
        AppMethodBeat.o(134881);
    }

    private final com.tencent.mm.plugin.appbrand.widget.b.e aKS() {
        AppMethodBeat.i(134882);
        com.tencent.mm.plugin.appbrand.widget.b.e eVar = (com.tencent.mm.plugin.appbrand.widget.b.e) this.iyN.getValue();
        AppMethodBeat.o(134882);
        return eVar;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PhoneNumberProxyUI() {
        AppMethodBeat.i(134890);
        AppMethodBeat.o(134890);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.appbrand.widget.b.e b(PhoneNumberProxyUI phoneNumberProxyUI) {
        AppMethodBeat.i(134893);
        com.tencent.mm.plugin.appbrand.widget.b.e aKS = phoneNumberProxyUI.aKS();
        AppMethodBeat.o(134893);
        return aKS;
    }

    public final void onCreate(Bundle bundle) {
        View.OnClickListener gVar;
        AppMethodBeat.i(134883);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ae.a(getWindow());
        addContentView(aKS(), new LayoutParams(-1, -1));
        String stringExtra = getIntent().getStringExtra("appId");
        a.f.b.j.o(stringExtra, "intent.getStringExtra(APP_ID)");
        this.appId = stringExtra;
        stringExtra = getIntent().getStringExtra("apiName");
        a.f.b.j.o(stringExtra, "intent.getStringExtra(API_NAME)");
        this.iyJ = stringExtra;
        stringExtra = getIntent().getStringExtra("pagePath");
        a.f.b.j.o(stringExtra, "intent.getStringExtra(PAGE_PATH)");
        this.csu = stringExtra;
        this.iyK = getIntent().getBooleanExtra("withCredentials", false);
        stringExtra = getIntent().getStringExtra("appName");
        a.f.b.j.o(stringExtra, "intent.getStringExtra(APP_NAME)");
        this.appName = stringExtra;
        stringExtra = getIntent().getStringExtra("appIcon");
        a.f.b.j.o(stringExtra, "intent.getStringExtra(APP_ICON)");
        this.hac = stringExtra;
        com.tencent.luggage.g.d.i("MicroMsg.PhoneNumberProxyUI", "onCreate() appId:%s apiName:%s withCredentials:%b", this.appId, this.iyJ, Boolean.valueOf(this.iyK));
        b.a.a.a.a.a.a.a.a.BTg.Az(this.appId);
        this.ixV = b.a.a.a.a.a.a.a.a.BTg.awB(this.appId);
        this.iyL = new l(this, this.appId);
        l lVar = this.iyL;
        if (lVar != null) {
            lVar.Du(this.appName);
        }
        lVar = this.iyL;
        if (lVar != null) {
            lVar.Dt(this.hac);
        }
        l lVar2 = this.iyL;
        if (lVar2 != null) {
            lVar2.iyx = new f(this);
        }
        lVar2 = this.iyL;
        if (lVar2 != null) {
            gVar = new g(this);
            a.f.b.j.p(gVar, "denyListener");
            TextView textView = lVar2.iyt;
            if (textView != null) {
                textView.setOnClickListener(gVar);
            }
        }
        lVar2 = this.iyL;
        if (lVar2 != null) {
            lVar2.cMR = new h(this);
        }
        lVar2 = this.iyL;
        if (lVar2 != null) {
            gVar = new i(this);
            a.f.b.j.p(gVar, "explainListener");
            lVar2.iyu.setOnClickListener(gVar);
            if (lVar2.iyu.getVisibility() != 0) {
                lVar2.iyu.setVisibility(0);
            }
        }
        lVar2 = this.iyL;
        if (lVar2 != null) {
            gVar = new j(this);
            a.f.b.j.p(gVar, "functionListener");
            lVar2.iyr.setOnClickListener(gVar);
        }
        aKS().a((com.tencent.mm.plugin.appbrand.widget.b.e.a) this);
        AppMethodBeat.o(134883);
    }

    public final void onResume() {
        AppMethodBeat.i(134884);
        super.onResume();
        if (this.iyO) {
            this.iyO = false;
            aKT();
            AppMethodBeat.o(134884);
            return;
        }
        List aKN = j.ixQ.aKN();
        if (aKN == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> /* = java.util.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> */");
            AppMethodBeat.o(134884);
            throw vVar;
        }
        this.ixy = (ArrayList) aKN;
        l lVar = this.iyL;
        if (lVar != null) {
            lVar.p(this.ixy);
        }
        lVar = this.iyL;
        if (lVar != null) {
            lVar.aKQ();
            AppMethodBeat.o(134884);
            return;
        }
        AppMethodBeat.o(134884);
    }

    static /* synthetic */ void a(PhoneNumberProxyUI phoneNumberProxyUI) {
        AppMethodBeat.i(134886);
        phoneNumberProxyUI.aKT();
        AppMethodBeat.o(134886);
    }

    private final void aKT() {
        AppMethodBeat.i(134885);
        be beVar = this.ixV;
        if (beVar != null) {
            be beVar2 = this.ixV;
            Long valueOf = beVar2 != null ? Long.valueOf(beVar2.Gx()) : null;
            if (valueOf == null) {
                a.f.b.j.dWJ();
            }
            beVar.cN(valueOf.longValue() + 1);
        }
        p b = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.w5), true, (OnCancelListener) new d(this));
        com.tencent.luggage.g.d.i("MicroMsg.PhoneNumberProxyUI", "getPhoneItemsFromServer()");
        new c(this.appId, this.iyJ, this.iyK).acy().h(new c(this, b));
        AppMethodBeat.o(134885);
    }

    public final void onDestroy() {
        AppMethodBeat.i(134887);
        super.onDestroy();
        aKS().b((com.tencent.mm.plugin.appbrand.widget.b.e.a) this);
        b.a.a.a.a.a.a.a.a.BTg.awC(this.appId);
        AppMethodBeat.o(134887);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onBackPressed() {
        AppMethodBeat.i(134888);
        if (!aKS().wY()) {
            super.onBackPressed();
        }
        AppMethodBeat.o(134888);
    }

    public final void CV() {
        AppMethodBeat.i(134889);
        if (aKS().size() == 0) {
            finish();
        }
        AppMethodBeat.o(134889);
    }

    public static final /* synthetic */ void a(PhoneNumberProxyUI phoneNumberProxyUI, String str, String str2) {
        AppMethodBeat.i(134891);
        String str3 = "MicroMsg.PhoneNumberProxyUI";
        String str4 = "report:%s";
        Object[] objArr = new Object[1];
        be beVar = phoneNumberProxyUI.ixV;
        objArr[0] = beVar != null ? beVar.Fk() : null;
        com.tencent.luggage.g.d.d(str3, str4, objArr);
        beVar = phoneNumberProxyUI.ixV;
        if (beVar != null) {
            beVar.ajK();
        }
        Intent intent = new Intent();
        str3 = "encryptedData";
        if (str == null) {
            str = "";
        }
        intent.putExtra(str3, str);
        str3 = "iv";
        if (str2 == null) {
            str2 = "";
        }
        intent.putExtra(str3, str2);
        phoneNumberProxyUI.setResult(-1, intent);
        phoneNumberProxyUI.finish();
        AppMethodBeat.o(134891);
    }

    public static final /* synthetic */ void a(PhoneNumberProxyUI phoneNumberProxyUI, String str) {
        AppMethodBeat.i(134892);
        String str2 = "MicroMsg.PhoneNumberProxyUI";
        String str3 = "report:%s";
        Object[] objArr = new Object[1];
        be beVar = phoneNumberProxyUI.ixV;
        objArr[0] = beVar != null ? beVar.Fk() : null;
        com.tencent.luggage.g.d.d(str2, str3, objArr);
        beVar = phoneNumberProxyUI.ixV;
        if (beVar != null) {
            beVar.ajK();
        }
        Intent intent = new Intent();
        str2 = "errMsg";
        if (str == null) {
            str = "";
        }
        intent.putExtra(str2, str);
        phoneNumberProxyUI.setResult(1, intent);
        phoneNumberProxyUI.finish();
        j.ixQ.b(null);
        AppMethodBeat.o(134892);
    }

    public static final /* synthetic */ void c(PhoneNumberProxyUI phoneNumberProxyUI) {
        AppMethodBeat.i(134894);
        com.tencent.luggage.g.d.i("MicroMsg.PhoneNumberProxyUI", "show the confirm bind phone dialog");
        com.tencent.mm.ui.base.h.a(phoneNumberProxyUI, false, phoneNumberProxyUI.getString(R.string.j0), phoneNumberProxyUI.getString(R.string.j1), phoneNumberProxyUI.getString(R.string.j7), phoneNumberProxyUI.getString(R.string.or), new k(phoneNumberProxyUI), new l(phoneNumberProxyUI), R.color.r8, R.color.r8);
        AppMethodBeat.o(134894);
    }

    public static final /* synthetic */ void d(PhoneNumberProxyUI phoneNumberProxyUI) {
        AppMethodBeat.i(134895);
        com.tencent.luggage.g.d.i("MicroMsg.PhoneNumberProxyUI", "doBindPhoneNumber()");
        Intent intent = new Intent(phoneNumberProxyUI, AppBrandRedirectUI.class);
        intent.putExtra("key_from_scene", 0);
        phoneNumberProxyUI.b((com.tencent.mm.ui.MMActivity.a) new b(phoneNumberProxyUI), intent, 100);
        AppMethodBeat.o(134895);
    }
}
