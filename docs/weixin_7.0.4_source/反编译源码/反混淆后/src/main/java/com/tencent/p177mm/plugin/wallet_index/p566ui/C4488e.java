package com.tencent.p177mm.plugin.wallet_index.p566ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.p177mm.opensdk.modelpay.PayReq.Options;
import com.tencent.p177mm.opensdk.modelpay.PayResp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_index.ui.e */
public final class C4488e {
    /* renamed from: a */
    public static boolean m6863a(Context context, String str, PayResp payResp, Options options) {
        AppMethodBeat.m2504i(135771);
        C4990ab.m7410d("MicroMsg.PayCallbackHelper", "callback, packageName = ".concat(String.valueOf(str)));
        String str2 = (options == null || C5046bo.isNullOrNil(options.callbackClassName)) ? str + ".wxapi.WXPayEntryActivity" : options.callbackClassName;
        int i = (options == null || options.callbackFlags == -1) ? 268435456 : options.callbackFlags;
        C4990ab.m7410d("MicroMsg.PayCallbackHelper", "callback, cbPkg = " + str + ", cbCls = " + str2 + ", cbFlags(hex) = " + Integer.toHexString(i));
        Bundle bundle = new Bundle();
        bundle.putString(Token.WX_TOKEN_KEY, Token.WX_TOKEN_VALUE_MSG);
        if (payResp != null) {
            payResp.toBundle(bundle);
        }
        Args args = new Args();
        args.targetPkgName = str;
        args.targetClassName = str2;
        args.bundle = bundle;
        args.flags = i;
        boolean send = MMessageActV2.send(context, args);
        AppMethodBeat.m2505o(135771);
        return send;
    }
}
