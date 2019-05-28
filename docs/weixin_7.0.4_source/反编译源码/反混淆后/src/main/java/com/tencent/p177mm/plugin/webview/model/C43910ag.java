package com.tencent.p177mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.p147g.C41711b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.bew;
import com.tencent.p177mm.protocal.protobuf.buo;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.webview.model.ag */
public final class C43910ag {
    private String hzR;
    public String mAppId;
    private Context mContext;
    private String mUH;
    String nep;
    private boolean ump;
    boolean umq = false;

    public C43910ag(Context context, String str, String str2) {
        this.mContext = context;
        this.umq = true;
        this.mAppId = str;
        this.mUH = str2;
    }

    public C43910ag(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mAppId = str;
        this.nep = str2;
        this.hzR = str3;
        this.ump = false;
    }

    /* renamed from: aB */
    public final void mo69597aB(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(6679);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append((String) linkedList.get(i)).append(",");
        }
        C4990ab.m7417i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
        C1720g.m3540Rg().mo14541a(new C29812ab(1, this.mAppId, this.hzR, C43910ag.aer(this.mAppId), (LinkedList) linkedList), 0);
        AppMethodBeat.m2505o(6679);
    }

    /* renamed from: h */
    public final void mo69599h(LinkedList<String> linkedList, int i) {
        AppMethodBeat.m2504i(6680);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            stringBuilder.append((String) linkedList.get(i2)).append(",");
        }
        C4990ab.m7417i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
        C1720g.m3540Rg().mo14541a(new C29812ab(this.mAppId, this.hzR, C43910ag.aer(this.mAppId), (LinkedList) linkedList, i), 0);
        AppMethodBeat.m2505o(6680);
    }

    /* renamed from: j */
    public final void mo69600j(int i, int i2, String str, C1207m c1207m) {
        String str2 = null;
        AppMethodBeat.m2504i(6681);
        C4990ab.m7417i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            String str3 = ((C29812ab) c1207m).cXC().vGi;
            C4990ab.m7417i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", str3);
            String aer = C43910ag.aer(this.mAppId);
            if (C5046bo.isNullOrNil(aer)) {
                C4990ab.m7412e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
                AppMethodBeat.m2505o(6681);
                return;
            }
            Uri uri;
            Resp resp = new Resp();
            resp.transaction = this.nep;
            resp.lang = cXI();
            resp.country = C43910ag.getCountry();
            if (C5046bo.isNullOrNil(str3)) {
                uri = null;
            } else {
                uri = Uri.parse(str3);
            }
            if (uri != null) {
                str2 = uri.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                resp.state = uri.getQueryParameter("state");
                resp.errStr = uri.getQueryParameter("reason");
            }
            if (C5046bo.isNullOrNil(str2)) {
                resp.errCode = -1;
            } else if (str2.toLowerCase().equals("authdeny")) {
                resp.errCode = -4;
            } else {
                resp.errCode = 0;
                resp.code = str2;
            }
            resp.url = str3;
            C4990ab.m7417i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", aer, resp.code, Integer.valueOf(resp.errCode), resp.state);
            mo69596a(aer, resp);
            ((MMActivity) this.mContext).finish();
            AppMethodBeat.m2505o(6681);
        } else if (m78754II(i)) {
            m78755Ml(str);
            AppMethodBeat.m2505o(6681);
        } else {
            m78755Ml(this.mContext.getString(C25738R.string.g0b));
            AppMethodBeat.m2505o(6681);
        }
    }

    /* renamed from: a */
    public static void m78757a(LinkedList<String> linkedList, int i, String str) {
        AppMethodBeat.m2504i(6682);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            stringBuilder.append((String) linkedList.get(i2)).append(",");
        }
        C4990ab.m7417i("MicroMsg.SDKOauthUtil", "doQRCodeOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
        C1720g.m3540Rg().mo14541a(new C35615z(1, str, linkedList, i), 0);
        AppMethodBeat.m2505o(6682);
    }

    /* renamed from: z */
    public final void mo69601z(int i, int i2, String str) {
        AppMethodBeat.m2504i(6683);
        C4990ab.m7417i("MicroMsg.SDKOauthUtil", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            ((MMActivity) this.mContext).finish();
            AppMethodBeat.m2505o(6683);
        } else if (m78754II(i)) {
            m78755Ml(str);
            AppMethodBeat.m2505o(6683);
        } else {
            m78755Ml(this.mContext.getString(C25738R.string.g0b));
            AppMethodBeat.m2505o(6683);
        }
    }

    /* renamed from: d */
    public static bew m78760d(String str, LinkedList<bew> linkedList) {
        AppMethodBeat.m2504i(6684);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bew bew = (bew) it.next();
            if (str.equals(bew.scope)) {
                AppMethodBeat.m2505o(6684);
                return bew;
            }
        }
        AppMethodBeat.m2505o(6684);
        return null;
    }

    /* renamed from: IH */
    public final void mo69595IH(int i) {
        AppMethodBeat.m2504i(6685);
        C4990ab.m7416i("MicroMsg.SDKOauthUtil", "dealWithCancel");
        if (this.umq) {
            C1720g.m3540Rg().mo14541a(new C35615z(2, this.mUH, null, 0), 0);
            ((MMActivity) this.mContext).finish();
            AppMethodBeat.m2505o(6685);
            return;
        }
        String aer = C43910ag.aer(this.mAppId);
        C1720g.m3540Rg().mo14541a(new C29812ab(2, this.mAppId, this.hzR, aer, null), 0);
        Resp resp = new Resp();
        resp.transaction = this.nep;
        resp.errCode = i;
        resp.lang = cXI();
        resp.country = C43910ag.getCountry();
        mo69596a(aer, resp);
        ((MMActivity) this.mContext).finish();
        AppMethodBeat.m2505o(6685);
    }

    /* renamed from: Ml */
    private void m78755Ml(final String str) {
        AppMethodBeat.m2504i(6686);
        C30379h.m48438a(this.mContext, str, this.mContext.getString(C25738R.string.g0a), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(6677);
                if (!C43910ag.this.umq) {
                    C43910ag c43910ag = C43910ag.this;
                    String str = str;
                    String aer = C43910ag.aer(c43910ag.mAppId);
                    if (C5046bo.isNullOrNil(aer)) {
                        C4990ab.m7412e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
                        AppMethodBeat.m2505o(6677);
                        return;
                    }
                    Resp resp = new Resp();
                    resp.transaction = c43910ag.nep;
                    resp.errCode = -1;
                    resp.errStr = str;
                    resp.lang = c43910ag.cXI();
                    resp.country = C43910ag.getCountry();
                    c43910ag.mo69596a(aer, resp);
                }
                AppMethodBeat.m2505o(6677);
            }
        });
        AppMethodBeat.m2505o(6686);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo69596a(String str, Resp resp) {
        AppMethodBeat.m2504i(6687);
        if (this.ump) {
            C4990ab.m7416i("MicroMsg.SDKOauthUtil", "doCallback has callback");
            AppMethodBeat.m2505o(6687);
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6687);
        } else {
            this.ump = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            C35799p.m58687at(bundle);
            Args args = new Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this.mContext, args);
            AppMethodBeat.m2505o(6687);
        }
    }

    static String aer(String str) {
        AppMethodBeat.m2504i(6688);
        String str2 = null;
        C40439f bT = C46494g.m87739bT(str, false);
        if (bT != null) {
            str2 = bT.field_packageName;
        } else {
            C4990ab.m7421w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", str);
        }
        AppMethodBeat.m2505o(6688);
        return str2;
    }

    static String getCountry() {
        AppMethodBeat.m2504i(6689);
        String bc = C5046bo.m7532bc((String) C1720g.m3536RP().mo5239Ry().get(274436, null), null);
        AppMethodBeat.m2505o(6689);
        return bc;
    }

    /* Access modifiers changed, original: final */
    public final String cXI() {
        AppMethodBeat.m2504i(6690);
        String g = C4988aa.m7402g(this.mContext.getSharedPreferences(C4996ah.doA(), 0));
        AppMethodBeat.m2505o(6690);
        return g;
    }

    /* renamed from: II */
    private boolean m78754II(int i) {
        AppMethodBeat.m2504i(6691);
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            C4990ab.m7412e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, errType = ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(6691);
            return false;
        } else if (C5023at.isConnected(this.mContext)) {
            AppMethodBeat.m2505o(6691);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, not connected");
            AppMethodBeat.m2505o(6691);
            return false;
        }
    }

    /* renamed from: ag */
    public static void m78759ag(final Activity activity) {
        AppMethodBeat.m2504i(6692);
        activity.overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
        if (C41711b.m73394iW(28)) {
            activity.finish();
            AppMethodBeat.m2505o(6692);
            return;
        }
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(6678);
                activity.finish();
                AppMethodBeat.m2505o(6678);
            }
        }, 500);
        AppMethodBeat.m2505o(6692);
    }

    /* renamed from: a */
    public static boolean m78758a(buo buo) {
        AppMethodBeat.m2504i(6693);
        if (C43910ag.m78760d("snsapi_userinfo", buo.wIK) == null && C43910ag.m78760d("snsapi_login", buo.wIK) == null && C43910ag.m78760d("group_sns_login", buo.wIK) == null) {
            AppMethodBeat.m2505o(6693);
            return false;
        }
        AppMethodBeat.m2505o(6693);
        return true;
    }

    /* renamed from: a */
    public static void m78756a(buo buo, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(6694);
        if (C43910ag.m78760d("snsapi_userinfo", buo.wIK) != null) {
            linkedList.add("snsapi_userinfo");
            AppMethodBeat.m2505o(6694);
        } else if (C43910ag.m78760d("snsapi_login", buo.wIK) != null) {
            linkedList.add("snsapi_login");
            AppMethodBeat.m2505o(6694);
        } else {
            linkedList.add("group_sns_login");
            AppMethodBeat.m2505o(6694);
        }
    }
}
