package com.tencent.p177mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p230g.p232b.p233a.C26275be;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandRedirectUI;
import com.tencent.p177mm.plugin.appbrand.phonenumber.C41251k.C41252a;
import com.tencent.p177mm.plugin.appbrand.phonenumber.C42664m.C2434b;
import com.tencent.p177mm.plugin.appbrand.phonenumber.C45671l.C2433b;
import com.tencent.p177mm.plugin.appbrand.phonenumber.PhoneItem.C33496a;
import com.tencent.p177mm.plugin.appbrand.phonenumber.PhoneNumberAddUI.C42657a;
import com.tencent.p177mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI.C10691a;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2514e;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C2514e.C2520a;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C33589k;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C38571j;
import com.tencent.p177mm.protocal.protobuf.awd;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C37091y;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;
import p1439b.p1440a.p1441a.p1442a.p1443a.p1444a.p1445a.p1446a.C31900a;

@C5271a(7)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010A\u001a\u00020BH\u0002J\u0012\u0010C\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010E\u001a\u00020B2\b\u0010F\u001a\u0004\u0018\u00010\u00052\b\u0010G\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010H\u001a\u00020IH\u0014J\u0012\u0010J\u001a\u00020B2\b\b\u0002\u0010K\u001a\u00020\u001dH\u0002J\b\u0010L\u001a\u00020BH\u0016J\u0012\u0010M\u001a\u00020B2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\b\u0010P\u001a\u00020BH\u0014J\b\u0010Q\u001a\u00020BH\u0016J\b\u0010R\u001a\u00020BH\u0014J\b\u0010S\u001a\u00020BH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001a\u0010'\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR*\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 ¨\u0006U"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout$DismissAnimationEndListener;", "()V", "apiName", "", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "appIcon", "getAppIcon", "setAppIcon", "appId", "getAppId", "setAppId", "appName", "getAppName", "setAppName", "authDesc", "getAuthDesc", "setAuthDesc", "desc", "getDesc", "setDesc", "extDesc", "getExtDesc", "setExtDesc", "isFirstOpen", "", "()Z", "setFirstOpen", "(Z)V", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getMDialogContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mDialogContainer$delegate", "Lkotlin/Lazy;", "pagePath", "getPagePath", "setPagePath", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "phoneNumberManageDialog", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "getPhoneNumberManageDialog", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "setPhoneNumberManageDialog", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;)V", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "getReport", "()Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;", "setReport", "(Lcom/tencent/mm/autogen/mmdata/rpt/WAPhoneAuthActionLogStruct;)V", "withCredentials", "getWithCredentials", "setWithCredentials", "doBindPhoneNumber", "", "finishWithFail", "errMsg", "finishWithSuccess", "encryptedData", "iv", "getLayoutId", "", "getPhoneItemsFromServer", "isFirst", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnd", "onResume", "tryToBindWechatPhoneNumber", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI */
public final class PhoneNumberProxyUI extends MMActivity implements C2520a {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(PhoneNumberProxyUI.class), "mDialogContainer", "getMDialogContainer()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;"))};
    public static final C33503a iyP = new C33503a();
    String appId = "";
    private String appName = "";
    String csu = "";
    String desc;
    private String hac = "";
    C26275be ixV;
    ArrayList<PhoneItem> ixy = new ArrayList();
    String iyA;
    private String iyJ = "";
    private boolean iyK;
    C45671l iyL;
    String iyM;
    private final C44856f iyN = C17344i.m26854g(new C31560e(this));
    private boolean iyO = true;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$d */
    static final class C19666d implements OnCancelListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        C19666d(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(134871);
            PhoneNumberProxyUI.m54718a(this.iyQ, "fail:user cancel");
            AppMethodBeat.m2505o(134871);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberProxyUI$onCreate$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog$OnPhoneItemSelect;", "onPhoneItemSelect", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$f */
    public static final class C19667f implements C2433b {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberProxyUI$onCreate$1$onPhoneItemSelect$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$f$a */
        public static final class C19668a implements C2434b {
            final /* synthetic */ PhoneItem ixE;
            final /* synthetic */ C19667f iyS;

            C19668a(C19667f c19667f, PhoneItem phoneItem) {
                this.iyS = c19667f;
                this.ixE = phoneItem;
            }

            /* renamed from: a */
            public final void mo6348a(boolean z, Map<String, String> map) {
                Long l = null;
                AppMethodBeat.m2504i(134873);
                C25052j.m39376p(map, "result");
                if (z) {
                    C26275be c26275be;
                    C26275be c26275be2;
                    if (this.ixE.ixM) {
                        c26275be = this.iyS.iyQ.ixV;
                        if (c26275be != null) {
                            c26275be2 = this.iyS.iyQ.ixV;
                            if (c26275be2 != null) {
                                l = Long.valueOf(c26275be2.mo43970GB());
                            }
                            if (l == null) {
                                C25052j.dWJ();
                            }
                            c26275be.mo43999cR(l.longValue() + 1);
                        }
                    } else {
                        c26275be = this.iyS.iyQ.ixV;
                        if (c26275be != null) {
                            c26275be2 = this.iyS.iyQ.ixV;
                            if (c26275be2 != null) {
                                l = Long.valueOf(c26275be2.mo43971GC());
                            }
                            if (l == null) {
                                C25052j.dWJ();
                            }
                            c26275be.mo44000cS(l.longValue() + 1);
                        }
                    }
                    PhoneNumberProxyUI.m54719a(this.iyS.iyQ, (String) map.get("encryptedData"), (String) map.get("iv"));
                    C45670j.ixQ.mo73462b(this.ixE);
                }
                AppMethodBeat.m2505o(134873);
            }
        }

        C19667f(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        /* renamed from: c */
        public final void mo6347c(PhoneItem phoneItem) {
            C26275be c26275be;
            Long l = null;
            AppMethodBeat.m2504i(134874);
            C25052j.m39376p(phoneItem, "phoneItem");
            C45124d.m82926d("MicroMsg.PhoneNumberProxyUI", "selelct phoneItem:%s", phoneItem);
            C26275be c26275be2 = this.iyQ.ixV;
            if (c26275be2 != null) {
                Long valueOf;
                c26275be = this.iyQ.ixV;
                if (c26275be != null) {
                    valueOf = Long.valueOf(c26275be.mo43991Gy());
                } else {
                    valueOf = null;
                }
                if (valueOf == null) {
                    C25052j.dWJ();
                }
                c26275be2.mo43996cO(valueOf.longValue() + 1);
            }
            if (phoneItem.ixK) {
                Context context = this.iyQ;
                String str = this.iyQ.appId;
                C26275be c26275be3 = this.iyQ.ixV;
                String str2 = this.iyQ.iyM;
                if (str2 == null) {
                    str2 = "";
                }
                new C42664m(context, str, c26275be3, str2, phoneItem, new C19668a(this, phoneItem)).mo68085ez(true);
                AppMethodBeat.m2505o(134874);
                return;
            }
            if (phoneItem.ixM) {
                c26275be = this.iyQ.ixV;
                if (c26275be != null) {
                    c26275be2 = this.iyQ.ixV;
                    if (c26275be2 != null) {
                        l = Long.valueOf(c26275be2.mo43970GB());
                    }
                    if (l == null) {
                        C25052j.dWJ();
                    }
                    c26275be.mo43999cR(l.longValue() + 1);
                }
            } else {
                c26275be = this.iyQ.ixV;
                if (c26275be != null) {
                    c26275be2 = this.iyQ.ixV;
                    if (c26275be2 != null) {
                        l = Long.valueOf(c26275be2.mo43971GC());
                    }
                    if (l == null) {
                        C25052j.dWJ();
                    }
                    c26275be.mo44000cS(l.longValue() + 1);
                }
            }
            PhoneNumberProxyUI.m54719a(this.iyQ, phoneItem.ixJ, phoneItem.biC);
            C45670j.ixQ.mo73462b(phoneItem);
            AppMethodBeat.m2505o(134874);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$l */
    static final class C19669l implements OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        C19669l(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(134880);
            C45124d.m82929i("MicroMsg.PhoneNumberProxyUI", "cancel to bind phone number");
            dialogInterface.dismiss();
            PhoneNumberProxyUI.m54718a(this.iyQ, "fail:user cancel");
            AppMethodBeat.m2505o(134880);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$c */
    static final class C27266c<_Ret, _Var> implements C5681a<_Ret, _Var> {
        final /* synthetic */ PhoneNumberProxyUI iyQ;
        final /* synthetic */ boolean iyR = false;
        final /* synthetic */ C44275p iyc;

        C27266c(PhoneNumberProxyUI phoneNumberProxyUI, C44275p c44275p) {
            this.iyQ = phoneNumberProxyUI;
            this.iyc = c44275p;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(134870);
            C37441a c37441a = (C37441a) obj;
            C45124d.m82930i("MicroMsg.PhoneNumberProxyUI", "getPhoneNumber errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            C44275p c44275p = this.iyc;
            C25052j.m39375o(c44275p, "progressDialog");
            if (c44275p.isShowing()) {
                this.iyc.dismiss();
            }
            if (c37441a.errType != 0 || c37441a.errCode != 0) {
                this.iyQ.setResult(1);
                this.iyQ.finish();
            } else if (((awd) c37441a.fsy).wzH.cyE != 0) {
                C45124d.m82928e("MicroMsg.PhoneNumberProxyUI", "JsApiBaseResponse is err, errCode:%d errMsg:%s", Integer.valueOf(((awd) c37441a.fsy).wzH.cyE), ((awd) c37441a.fsy).wzH.cyF);
                PhoneNumberProxyUI.m54718a(this.iyQ, ((awd) c37441a.fsy).wzH.cyF);
            } else {
                String str;
                C45671l c45671l = this.iyQ.iyL;
                if (c45671l != null) {
                    str = ((awd) c37441a.fsy).ncH;
                    if (str == null) {
                        str = "";
                    }
                    c45671l.mo73465Du(str);
                }
                c45671l = this.iyQ.iyL;
                if (c45671l != null) {
                    str = ((awd) c37441a.fsy).vDm;
                    if (str == null) {
                        str = "";
                    }
                    c45671l.mo73464Dt(str);
                }
                this.iyQ.desc = ((awd) c37441a.fsy).wzS.Desc;
                this.iyQ.iyM = ((awd) c37441a.fsy).wzS.iyZ;
                this.iyQ.iyA = ((awd) c37441a.fsy).wzS.wze;
                JSONObject jSONObject = new JSONObject(((awd) c37441a.fsy).jBi.dlY());
                ArrayList arrayList = new ArrayList();
                C33496a c33496a = PhoneItem.ixO;
                str = jSONObject.optString("wx_phone");
                C25052j.m39375o(str, "phoneItemsJsonObj.optString(\"wx_phone\")");
                PhoneItem Ds = C33496a.m54716Ds(str);
                if (this.iyR) {
                    C26275be c26275be = this.iyQ.ixV;
                    if (c26275be != null) {
                        c26275be.mo43993cL(Ds == null ? 1 : 0);
                    }
                }
                if (Ds == null) {
                    C45124d.m82927e("MicroMsg.PhoneNumberProxyUI", "wxPhoneItem is null, tryToBindWechatPhoneNumber");
                    PhoneNumberProxyUI.m54721c(this.iyQ);
                } else if (this.iyQ.isFinishing()) {
                    C45124d.m82927e("MicroMsg.PhoneNumberProxyUI", "activity is destroy, err");
                } else {
                    PhoneNumberProxyUI.m54720b(this.iyQ).mo6468b((C38571j) this.iyQ.iyL);
                    Ds.ixM = true;
                    arrayList.add(Ds);
                    C45124d.m82926d("MicroMsg.PhoneNumberProxyUI", "wxPhoneItem:%s", Ds);
                    JSONArray optJSONArray = jSONObject.optJSONArray("custom_phone_list");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length() - 1;
                        if (length >= 0) {
                            int i = 0;
                            while (true) {
                                C33496a c33496a2 = PhoneItem.ixO;
                                String string = optJSONArray.getString(i);
                                C25052j.m39375o(string, "customPhoneItemsObjArray.getString(i)");
                                PhoneItem Ds2 = C33496a.m54716Ds(string);
                                if (Ds2 != null) {
                                    C45124d.m82926d("MicroMsg.PhoneNumberProxyUI", "phoneItem:%s", Ds2);
                                    arrayList.add(Ds2);
                                }
                                if (i == length) {
                                    break;
                                }
                                i++;
                            }
                        }
                    }
                    C45670j.ixQ.mo73461aM(arrayList);
                    PhoneNumberProxyUI phoneNumberProxyUI = this.iyQ;
                    List aKN = C45670j.ixQ.aKN();
                    if (aKN == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> /* = java.util.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> */");
                        AppMethodBeat.m2505o(134870);
                        throw c44941v;
                    }
                    ArrayList arrayList2 = (ArrayList) aKN;
                    C25052j.m39376p(arrayList2, "<set-?>");
                    phoneNumberProxyUI.ixy = arrayList2;
                    C45671l c45671l2 = this.iyQ.iyL;
                    if (c45671l2 != null) {
                        c45671l2.mo73469p(this.iyQ.ixy);
                    }
                    c45671l2 = this.iyQ.iyL;
                    if (c45671l2 != null) {
                        c45671l2.aKQ();
                    }
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(134870);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$e */
    static final class C31560e extends C25053k implements C31214a<C2514e> {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        C31560e(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(134872);
            C2514e c2514e = new C2514e(this.iyQ);
            AppMethodBeat.m2505o(134872);
            return c2514e;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$b */
    static final class C33497b implements C5186a {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        C33497b(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        /* renamed from: c */
        public final void mo6069c(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(134869);
            if (i == 100) {
                C26275be c26275be;
                if (i2 == -1) {
                    C45124d.m82929i("MicroMsg.PhoneNumberProxyUI", "mmOnActivityResult RESULT_OK");
                    PhoneNumberProxyUI.m54717a(this.iyQ);
                    c26275be = this.iyQ.ixV;
                    if (c26275be != null) {
                        c26275be.mo43994cM(1);
                    }
                } else {
                    C45124d.m82927e("MicroMsg.PhoneNumberProxyUI", "mmOnActivityResult RESULT_CANCEL OR RESULT_FIRST_USER");
                    c26275be = this.iyQ.ixV;
                    if (c26275be != null) {
                        c26275be.mo43994cM(0);
                    }
                    PhoneNumberProxyUI.m54718a(this.iyQ, "fail:user cancel");
                }
                this.iyQ.dye();
            }
            AppMethodBeat.m2505o(134869);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$g */
    static final class C33498g implements View.OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        C33498g(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134875);
            C26275be c26275be = this.iyQ.ixV;
            if (c26275be != null) {
                C26275be c26275be2 = this.iyQ.ixV;
                Long valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43992Gz()) : null;
                if (valueOf == null) {
                    C25052j.dWJ();
                }
                c26275be.mo43997cP(valueOf.longValue() + 1);
            }
            PhoneNumberProxyUI.m54718a(this.iyQ, "user deny");
            AppMethodBeat.m2505o(134875);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$h */
    static final class C33499h implements OnDismissListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        C33499h(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(134876);
            C26275be c26275be = this.iyQ.ixV;
            if (c26275be != null) {
                C26275be c26275be2 = this.iyQ.ixV;
                Long valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43969GA()) : null;
                if (valueOf == null) {
                    C25052j.dWJ();
                }
                c26275be.mo43998cQ(valueOf.longValue() + 1);
            }
            PhoneNumberProxyUI.m54718a(this.iyQ, "user cancel");
            AppMethodBeat.m2505o(134876);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$i */
    static final class C33500i implements View.OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        C33500i(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(View view) {
            int measuredHeight;
            AppMethodBeat.m2504i(134877);
            C26275be c26275be = this.iyQ.ixV;
            if (c26275be != null) {
                Long valueOf;
                C26275be c26275be2 = this.iyQ.ixV;
                if (c26275be2 != null) {
                    valueOf = Long.valueOf(c26275be2.mo43972GD());
                } else {
                    valueOf = null;
                }
                if (valueOf == null) {
                    C25052j.dWJ();
                }
                c26275be.mo44001cT(valueOf.longValue() + 1);
            }
            String str = this.iyQ.appId;
            String str2 = this.iyQ.csu;
            AppCompatActivity dxU = this.iyQ.dxU();
            C25052j.m39375o(dxU, "context");
            C41251k c41251k = new C41251k(str, str2, dxU);
            String str3 = this.iyQ.iyA;
            if (str3 == null) {
                str3 = c41251k.context.getString(C25738R.string.f9297vw);
            }
            c41251k.gKl.setText(str3);
            C45671l c45671l = this.iyQ.iyL;
            if (c45671l != null) {
                measuredHeight = c45671l.iym.getMeasuredHeight();
            } else {
                measuredHeight = -1;
            }
            c41251k.iyk = PhoneNumberProxyUI.m54720b(this.iyQ);
            c41251k.iyl.setOnClickListener(new C41252a(c41251k));
            C33589k c33589k = c41251k.iyk;
            if (c33589k != null) {
                c33589k.mo6468b(c41251k);
            }
            if (measuredHeight >= 0) {
                View view2 = c41251k.iym;
                LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = measuredHeight;
                } else {
                    layoutParams = null;
                }
                view2.setLayoutParams(layoutParams);
            }
            AppMethodBeat.m2505o(134877);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$j */
    static final class C33501j implements View.OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        C33501j(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(View view) {
            Long l = null;
            AppMethodBeat.m2504i(134878);
            AppCompatActivity dxU;
            C26275be c26275be;
            C26275be c26275be2;
            if (this.iyQ.ixy.size() == 1) {
                C42657a c42657a = PhoneNumberAddUI.ixW;
                dxU = this.iyQ.dxU();
                C25052j.m39375o(dxU, "context");
                C42657a.m75529X(dxU, this.iyQ.appId);
                c26275be = this.iyQ.ixV;
                if (c26275be != null) {
                    c26275be2 = this.iyQ.ixV;
                    if (c26275be2 != null) {
                        l = Long.valueOf(c26275be2.mo43973GE());
                    }
                    if (l == null) {
                        C25052j.dWJ();
                    }
                    c26275be.mo44002cU(l.longValue() + 1);
                    AppMethodBeat.m2505o(134878);
                    return;
                }
                AppMethodBeat.m2505o(134878);
                return;
            }
            C10691a c10691a = PhoneNumberManagerUI.iyG;
            dxU = this.iyQ.dxU();
            C25052j.m39375o(dxU, "context");
            Context context = dxU;
            String str = this.iyQ.appId;
            String str2 = this.iyQ.csu;
            Object obj = this.iyQ.iyA;
            if (obj == null) {
                obj = "";
            }
            C25052j.m39376p(context, "context");
            C25052j.m39376p(str, "appId");
            C25052j.m39376p(str2, "pagePath");
            C25052j.m39376p(obj, "authDesc");
            Intent intent = new Intent(context, PhoneNumberManagerUI.class);
            intent.putExtra("APPID", str);
            intent.putExtra("AUTHDESC", obj);
            intent.putExtra("PAGEPATH", str2);
            intent.putExtra("SHOW_DELETE", false);
            context.startActivity(intent);
            c26275be2 = this.iyQ.ixV;
            if (c26275be2 != null) {
                c26275be = this.iyQ.ixV;
                Long valueOf = c26275be != null ? Long.valueOf(c26275be.mo43974GF()) : null;
                if (valueOf == null) {
                    C25052j.dWJ();
                }
                c26275be2.mo44003cV(valueOf.longValue() + 1);
                AppMethodBeat.m2505o(134878);
                return;
            }
            AppMethodBeat.m2505o(134878);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$k */
    static final class C33502k implements OnClickListener {
        final /* synthetic */ PhoneNumberProxyUI iyQ;

        C33502k(PhoneNumberProxyUI phoneNumberProxyUI) {
            this.iyQ = phoneNumberProxyUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(134879);
            C45124d.m82929i("MicroMsg.PhoneNumberProxyUI", "confirm bind phone number");
            PhoneNumberProxyUI.m54722d(this.iyQ);
            AppMethodBeat.m2505o(134879);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberProxyUI$Companion;", "", "()V", "API_NAME", "", "APP_ICON", "APP_ID", "APP_NAME", "ENCRYPTEDDATA", "ERRMSG", "IV", "PAGE_PATH", "REQUEST_BIND_WECHAT_PHONE_NUMBER", "", "TAG", "WITH_CREDENTIALS", "showDialog", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "appId", "appName", "appIcon", "pagePath", "apiName", "withCredentials", "", "onActResult", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "requsetCode", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberProxyUI$a */
    public static final class C33503a {
        private C33503a() {
        }

        public /* synthetic */ C33503a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.m2504i(134881);
        AppMethodBeat.m2505o(134881);
    }

    private final C2514e aKS() {
        AppMethodBeat.m2504i(134882);
        C2514e c2514e = (C2514e) this.iyN.getValue();
        AppMethodBeat.m2505o(134882);
        return c2514e;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public PhoneNumberProxyUI() {
        AppMethodBeat.m2504i(134890);
        AppMethodBeat.m2505o(134890);
    }

    /* renamed from: b */
    public static final /* synthetic */ C2514e m54720b(PhoneNumberProxyUI phoneNumberProxyUI) {
        AppMethodBeat.m2504i(134893);
        C2514e aKS = phoneNumberProxyUI.aKS();
        AppMethodBeat.m2505o(134893);
        return aKS;
    }

    public final void onCreate(Bundle bundle) {
        View.OnClickListener c33498g;
        AppMethodBeat.m2504i(134883);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        C5222ae.m7935a(getWindow());
        addContentView(aKS(), new LayoutParams(-1, -1));
        String stringExtra = getIntent().getStringExtra("appId");
        C25052j.m39375o(stringExtra, "intent.getStringExtra(APP_ID)");
        this.appId = stringExtra;
        stringExtra = getIntent().getStringExtra("apiName");
        C25052j.m39375o(stringExtra, "intent.getStringExtra(API_NAME)");
        this.iyJ = stringExtra;
        stringExtra = getIntent().getStringExtra("pagePath");
        C25052j.m39375o(stringExtra, "intent.getStringExtra(PAGE_PATH)");
        this.csu = stringExtra;
        this.iyK = getIntent().getBooleanExtra("withCredentials", false);
        stringExtra = getIntent().getStringExtra("appName");
        C25052j.m39375o(stringExtra, "intent.getStringExtra(APP_NAME)");
        this.appName = stringExtra;
        stringExtra = getIntent().getStringExtra("appIcon");
        C25052j.m39375o(stringExtra, "intent.getStringExtra(APP_ICON)");
        this.hac = stringExtra;
        C45124d.m82930i("MicroMsg.PhoneNumberProxyUI", "onCreate() appId:%s apiName:%s withCredentials:%b", this.appId, this.iyJ, Boolean.valueOf(this.iyK));
        C31900a.BTg.mo52012Az(this.appId);
        this.ixV = C31900a.BTg.awB(this.appId);
        this.iyL = new C45671l(this, this.appId);
        C45671l c45671l = this.iyL;
        if (c45671l != null) {
            c45671l.mo73465Du(this.appName);
        }
        c45671l = this.iyL;
        if (c45671l != null) {
            c45671l.mo73464Dt(this.hac);
        }
        C45671l c45671l2 = this.iyL;
        if (c45671l2 != null) {
            c45671l2.iyx = new C19667f(this);
        }
        c45671l2 = this.iyL;
        if (c45671l2 != null) {
            c33498g = new C33498g(this);
            C25052j.m39376p(c33498g, "denyListener");
            TextView textView = c45671l2.iyt;
            if (textView != null) {
                textView.setOnClickListener(c33498g);
            }
        }
        c45671l2 = this.iyL;
        if (c45671l2 != null) {
            c45671l2.cMR = new C33499h(this);
        }
        c45671l2 = this.iyL;
        if (c45671l2 != null) {
            c33498g = new C33500i(this);
            C25052j.m39376p(c33498g, "explainListener");
            c45671l2.iyu.setOnClickListener(c33498g);
            if (c45671l2.iyu.getVisibility() != 0) {
                c45671l2.iyu.setVisibility(0);
            }
        }
        c45671l2 = this.iyL;
        if (c45671l2 != null) {
            c33498g = new C33501j(this);
            C25052j.m39376p(c33498g, "functionListener");
            c45671l2.iyr.setOnClickListener(c33498g);
        }
        aKS().mo6466a((C2520a) this);
        AppMethodBeat.m2505o(134883);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(134884);
        super.onResume();
        if (this.iyO) {
            this.iyO = false;
            aKT();
            AppMethodBeat.m2505o(134884);
            return;
        }
        List aKN = C45670j.ixQ.aKN();
        if (aKN == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> /* = java.util.ArrayList<com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem> */");
            AppMethodBeat.m2505o(134884);
            throw c44941v;
        }
        this.ixy = (ArrayList) aKN;
        C45671l c45671l = this.iyL;
        if (c45671l != null) {
            c45671l.mo73469p(this.ixy);
        }
        c45671l = this.iyL;
        if (c45671l != null) {
            c45671l.aKQ();
            AppMethodBeat.m2505o(134884);
            return;
        }
        AppMethodBeat.m2505o(134884);
    }

    /* renamed from: a */
    static /* synthetic */ void m54717a(PhoneNumberProxyUI phoneNumberProxyUI) {
        AppMethodBeat.m2504i(134886);
        phoneNumberProxyUI.aKT();
        AppMethodBeat.m2505o(134886);
    }

    private final void aKT() {
        AppMethodBeat.m2504i(134885);
        C26275be c26275be = this.ixV;
        if (c26275be != null) {
            C26275be c26275be2 = this.ixV;
            Long valueOf = c26275be2 != null ? Long.valueOf(c26275be2.mo43990Gx()) : null;
            if (valueOf == null) {
                C25052j.dWJ();
            }
            c26275be.mo43995cN(valueOf.longValue() + 1);
        }
        C44275p b = C30379h.m48458b((Context) this, getString(C25738R.string.f9306w5), true, (OnCancelListener) new C19666d(this));
        C45124d.m82929i("MicroMsg.PhoneNumberProxyUI", "getPhoneItemsFromServer()");
        new C45668c(this.appId, this.iyJ, this.iyK).acy().mo60492h(new C27266c(this, b));
        AppMethodBeat.m2505o(134885);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(134887);
        super.onDestroy();
        aKS().mo6467b((C2520a) this);
        C31900a.BTg.awC(this.appId);
        AppMethodBeat.m2505o(134887);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(134888);
        if (!aKS().mo6474wY()) {
            super.onBackPressed();
        }
        AppMethodBeat.m2505o(134888);
    }

    /* renamed from: CV */
    public final void mo6481CV() {
        AppMethodBeat.m2504i(134889);
        if (aKS().size() == 0) {
            finish();
        }
        AppMethodBeat.m2505o(134889);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m54719a(PhoneNumberProxyUI phoneNumberProxyUI, String str, String str2) {
        AppMethodBeat.m2504i(134891);
        String str3 = "MicroMsg.PhoneNumberProxyUI";
        String str4 = "report:%s";
        Object[] objArr = new Object[1];
        C26275be c26275be = phoneNumberProxyUI.ixV;
        objArr[0] = c26275be != null ? c26275be.mo4983Fk() : null;
        C45124d.m82926d(str3, str4, objArr);
        c26275be = phoneNumberProxyUI.ixV;
        if (c26275be != null) {
            c26275be.ajK();
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
        AppMethodBeat.m2505o(134891);
    }

    /* renamed from: a */
    public static final /* synthetic */ void m54718a(PhoneNumberProxyUI phoneNumberProxyUI, String str) {
        AppMethodBeat.m2504i(134892);
        String str2 = "MicroMsg.PhoneNumberProxyUI";
        String str3 = "report:%s";
        Object[] objArr = new Object[1];
        C26275be c26275be = phoneNumberProxyUI.ixV;
        objArr[0] = c26275be != null ? c26275be.mo4983Fk() : null;
        C45124d.m82926d(str2, str3, objArr);
        c26275be = phoneNumberProxyUI.ixV;
        if (c26275be != null) {
            c26275be.ajK();
        }
        Intent intent = new Intent();
        str2 = "errMsg";
        if (str == null) {
            str = "";
        }
        intent.putExtra(str2, str);
        phoneNumberProxyUI.setResult(1, intent);
        phoneNumberProxyUI.finish();
        C45670j.ixQ.mo73462b(null);
        AppMethodBeat.m2505o(134892);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m54721c(PhoneNumberProxyUI phoneNumberProxyUI) {
        AppMethodBeat.m2504i(134894);
        C45124d.m82929i("MicroMsg.PhoneNumberProxyUI", "show the confirm bind phone dialog");
        C30379h.m48454a(phoneNumberProxyUI, false, phoneNumberProxyUI.getString(C25738R.string.f8904j0), phoneNumberProxyUI.getString(C25738R.string.f8905j1), phoneNumberProxyUI.getString(C25738R.string.f8911j7), phoneNumberProxyUI.getString(C25738R.string.f9076or), new C33502k(phoneNumberProxyUI), new C19669l(phoneNumberProxyUI), C25738R.color.f12069r8, C25738R.color.f12069r8);
        AppMethodBeat.m2505o(134894);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m54722d(PhoneNumberProxyUI phoneNumberProxyUI) {
        AppMethodBeat.m2504i(134895);
        C45124d.m82929i("MicroMsg.PhoneNumberProxyUI", "doBindPhoneNumber()");
        Intent intent = new Intent(phoneNumberProxyUI, AppBrandRedirectUI.class);
        intent.putExtra("key_from_scene", 0);
        phoneNumberProxyUI.mo17391b((C5186a) new C33497b(phoneNumberProxyUI), intent, 100);
        AppMethodBeat.m2505o(134895);
    }
}
