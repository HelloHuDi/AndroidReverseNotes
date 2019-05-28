package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class e {
    public static boolean a(Context context, String str, PayResp payResp, Options options) {
        AppMethodBeat.i(135771);
        ab.d("MicroMsg.PayCallbackHelper", "callback, packageName = ".concat(String.valueOf(str)));
        String str2 = (options == null || bo.isNullOrNil(options.callbackClassName)) ? str + ".wxapi.WXPayEntryActivity" : options.callbackClassName;
        int i = (options == null || options.callbackFlags == -1) ? 268435456 : options.callbackFlags;
        ab.d("MicroMsg.PayCallbackHelper", "callback, cbPkg = " + str + ", cbCls = " + str2 + ", cbFlags(hex) = " + Integer.toHexString(i));
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
        AppMethodBeat.o(135771);
        return send;
    }
}
