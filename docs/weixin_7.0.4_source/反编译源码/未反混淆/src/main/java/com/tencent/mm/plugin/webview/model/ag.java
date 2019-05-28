package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.protobuf.bew;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Iterator;
import java.util.LinkedList;

public final class ag {
    private String hzR;
    public String mAppId;
    private Context mContext;
    private String mUH;
    String nep;
    private boolean ump;
    boolean umq = false;

    public ag(Context context, String str, String str2) {
        this.mContext = context;
        this.umq = true;
        this.mAppId = str;
        this.mUH = str2;
    }

    public ag(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mAppId = str;
        this.nep = str2;
        this.hzR = str3;
        this.ump = false;
    }

    public final void aB(LinkedList<String> linkedList) {
        AppMethodBeat.i(6679);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append((String) linkedList.get(i)).append(",");
        }
        ab.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
        g.Rg().a(new ab(1, this.mAppId, this.hzR, aer(this.mAppId), (LinkedList) linkedList), 0);
        AppMethodBeat.o(6679);
    }

    public final void h(LinkedList<String> linkedList, int i) {
        AppMethodBeat.i(6680);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            stringBuilder.append((String) linkedList.get(i2)).append(",");
        }
        ab.i("MicroMsg.SDKOauthUtil", "doSDKOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
        g.Rg().a(new ab(this.mAppId, this.hzR, aer(this.mAppId), (LinkedList) linkedList, i), 0);
        AppMethodBeat.o(6680);
    }

    public final void j(int i, int i2, String str, m mVar) {
        String str2 = null;
        AppMethodBeat.i(6681);
        ab.i("MicroMsg.SDKOauthUtil", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            String str3 = ((ab) mVar).cXC().vGi;
            ab.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback url : %s", str3);
            String aer = aer(this.mAppId);
            if (bo.isNullOrNil(aer)) {
                ab.e("MicroMsg.SDKOauthUtil", "dealWithLoginCallback pkg nil");
                AppMethodBeat.o(6681);
                return;
            }
            Uri uri;
            Resp resp = new Resp();
            resp.transaction = this.nep;
            resp.lang = cXI();
            resp.country = getCountry();
            if (bo.isNullOrNil(str3)) {
                uri = null;
            } else {
                uri = Uri.parse(str3);
            }
            if (uri != null) {
                str2 = uri.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                resp.state = uri.getQueryParameter("state");
                resp.errStr = uri.getQueryParameter("reason");
            }
            if (bo.isNullOrNil(str2)) {
                resp.errCode = -1;
            } else if (str2.toLowerCase().equals("authdeny")) {
                resp.errCode = -4;
            } else {
                resp.errCode = 0;
                resp.code = str2;
            }
            resp.url = str3;
            ab.i("MicroMsg.SDKOauthUtil", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", aer, resp.code, Integer.valueOf(resp.errCode), resp.state);
            a(aer, resp);
            ((MMActivity) this.mContext).finish();
            AppMethodBeat.o(6681);
        } else if (II(i)) {
            Ml(str);
            AppMethodBeat.o(6681);
        } else {
            Ml(this.mContext.getString(R.string.g0b));
            AppMethodBeat.o(6681);
        }
    }

    public static void a(LinkedList<String> linkedList, int i, String str) {
        AppMethodBeat.i(6682);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            stringBuilder.append((String) linkedList.get(i2)).append(",");
        }
        ab.i("MicroMsg.SDKOauthUtil", "doQRCodeOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
        g.Rg().a(new z(1, str, linkedList, i), 0);
        AppMethodBeat.o(6682);
    }

    public final void z(int i, int i2, String str) {
        AppMethodBeat.i(6683);
        ab.i("MicroMsg.SDKOauthUtil", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            ((MMActivity) this.mContext).finish();
            AppMethodBeat.o(6683);
        } else if (II(i)) {
            Ml(str);
            AppMethodBeat.o(6683);
        } else {
            Ml(this.mContext.getString(R.string.g0b));
            AppMethodBeat.o(6683);
        }
    }

    public static bew d(String str, LinkedList<bew> linkedList) {
        AppMethodBeat.i(6684);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bew bew = (bew) it.next();
            if (str.equals(bew.scope)) {
                AppMethodBeat.o(6684);
                return bew;
            }
        }
        AppMethodBeat.o(6684);
        return null;
    }

    public final void IH(int i) {
        AppMethodBeat.i(6685);
        ab.i("MicroMsg.SDKOauthUtil", "dealWithCancel");
        if (this.umq) {
            g.Rg().a(new z(2, this.mUH, null, 0), 0);
            ((MMActivity) this.mContext).finish();
            AppMethodBeat.o(6685);
            return;
        }
        String aer = aer(this.mAppId);
        g.Rg().a(new ab(2, this.mAppId, this.hzR, aer, null), 0);
        Resp resp = new Resp();
        resp.transaction = this.nep;
        resp.errCode = i;
        resp.lang = cXI();
        resp.country = getCountry();
        a(aer, resp);
        ((MMActivity) this.mContext).finish();
        AppMethodBeat.o(6685);
    }

    private void Ml(final String str) {
        AppMethodBeat.i(6686);
        h.a(this.mContext, str, this.mContext.getString(R.string.g0a), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(6677);
                if (!ag.this.umq) {
                    ag agVar = ag.this;
                    String str = str;
                    String aer = ag.aer(agVar.mAppId);
                    if (bo.isNullOrNil(aer)) {
                        ab.e("MicroMsg.SDKOauthUtil", "dealWithError pkg nil");
                        AppMethodBeat.o(6677);
                        return;
                    }
                    Resp resp = new Resp();
                    resp.transaction = agVar.nep;
                    resp.errCode = -1;
                    resp.errStr = str;
                    resp.lang = agVar.cXI();
                    resp.country = ag.getCountry();
                    agVar.a(aer, resp);
                }
                AppMethodBeat.o(6677);
            }
        });
        AppMethodBeat.o(6686);
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, Resp resp) {
        AppMethodBeat.i(6687);
        if (this.ump) {
            ab.i("MicroMsg.SDKOauthUtil", "doCallback has callback");
            AppMethodBeat.o(6687);
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(6687);
        } else {
            this.ump = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            p.at(bundle);
            Args args = new Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this.mContext, args);
            AppMethodBeat.o(6687);
        }
    }

    static String aer(String str) {
        AppMethodBeat.i(6688);
        String str2 = null;
        f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, false);
        if (bT != null) {
            str2 = bT.field_packageName;
        } else {
            ab.w("MicroMsg.SDKOauthUtil", "dealWithCancel getAppInfo null; appid: %s", str);
        }
        AppMethodBeat.o(6688);
        return str2;
    }

    static String getCountry() {
        AppMethodBeat.i(6689);
        String bc = bo.bc((String) g.RP().Ry().get(274436, null), null);
        AppMethodBeat.o(6689);
        return bc;
    }

    /* Access modifiers changed, original: final */
    public final String cXI() {
        AppMethodBeat.i(6690);
        String g = aa.g(this.mContext.getSharedPreferences(ah.doA(), 0));
        AppMethodBeat.o(6690);
        return g;
    }

    private boolean II(int i) {
        AppMethodBeat.i(6691);
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            ab.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, errType = ".concat(String.valueOf(i)));
            AppMethodBeat.o(6691);
            return false;
        } else if (at.isConnected(this.mContext)) {
            AppMethodBeat.o(6691);
            return true;
        } else {
            ab.e("MicroMsg.SDKOauthUtil", "isNetworkAvailable false, not connected");
            AppMethodBeat.o(6691);
            return false;
        }
    }

    public static void ag(final Activity activity) {
        AppMethodBeat.i(6692);
        activity.overridePendingTransition(R.anim.s, R.anim.s);
        if (b.iW(28)) {
            activity.finish();
            AppMethodBeat.o(6692);
            return;
        }
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(6678);
                activity.finish();
                AppMethodBeat.o(6678);
            }
        }, 500);
        AppMethodBeat.o(6692);
    }

    public static boolean a(buo buo) {
        AppMethodBeat.i(6693);
        if (d("snsapi_userinfo", buo.wIK) == null && d("snsapi_login", buo.wIK) == null && d("group_sns_login", buo.wIK) == null) {
            AppMethodBeat.o(6693);
            return false;
        }
        AppMethodBeat.o(6693);
        return true;
    }

    public static void a(buo buo, LinkedList<String> linkedList) {
        AppMethodBeat.i(6694);
        if (d("snsapi_userinfo", buo.wIK) != null) {
            linkedList.add("snsapi_userinfo");
            AppMethodBeat.o(6694);
        } else if (d("snsapi_login", buo.wIK) != null) {
            linkedList.add("snsapi_login");
            AppMethodBeat.o(6694);
        } else {
            linkedList.add("group_sns_login");
            AppMethodBeat.o(6694);
        }
    }
}
