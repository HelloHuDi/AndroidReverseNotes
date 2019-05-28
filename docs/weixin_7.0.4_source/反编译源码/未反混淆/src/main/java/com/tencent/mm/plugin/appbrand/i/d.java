package com.tencent.mm.plugin.appbrand.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.r.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.f;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class d implements b {
    public final CharSequence a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
        AppMethodBeat.i(132276);
        if (map == null || map.isEmpty()) {
            ab.w("MicroMsg.WxaSysTemplateMsgHandler", "values map is null or nil");
            AppMethodBeat.o(132276);
            return null;
        }
        Context context = (Context) weakReference.get();
        if (context == null) {
            ab.w("MicroMsg.WxaSysTemplateMsgHandler", "context is null");
            AppMethodBeat.o(132276);
            return null;
        }
        final String str2 = (String) map.get(str + ".title");
        final String str3 = (String) map.get(str + ".username");
        final int i = bo.getInt((String) map.get(str + ".type"), 0);
        int i2 = bo.getInt((String) map.get(str + ".wxaapp_type"), 0);
        final String str4 = (String) map.get(str + ".path");
        Object obj = bo.getInt((String) map.get(new StringBuilder().append(str).append(".forbids").toString()), 0) == 1 ? 1 : null;
        final String string = bundle != null ? bundle.getString("conv_talker_username") : "";
        final int i3 = bundle != null ? bundle.getInt("scene") : 0;
        final long j = bundle != null ? bundle.getLong("msg_sever_id") : 0;
        final String string2 = bundle != null ? bundle.getString("send_msg_username") : "";
        if (bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.WxaSysTemplateMsgHandler", "link title is null or nil");
            AppMethodBeat.o(132276);
            return null;
        }
        CharSequence spannableString = new SpannableString(str2);
        final WeakReference<Context> weakReference2 = weakReference;
        spannableString.setSpan(new a() {
            public final void onClickImp(View view) {
                AppMethodBeat.i(132275);
                ab.i("MicroMsg.WxaSysTemplateMsgHandler", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", str2, str3, str4, string);
                weakReference2.get();
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", i3);
                bundle.putString("stat_msg_id", "msg_" + Long.toString(j));
                bundle.putString("stat_chat_talker_username", string);
                bundle.putString("stat_send_msg_user", string2);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE;
                appBrandStatObject.cst = "";
                appBrandStatObject.cOq = f.h(appBrandStatObject.scene, bundle);
                appBrandStatObject.cOr = f.i(appBrandStatObject.scene, bundle);
                String str = "";
                if (str4 != null && str4.length() > 0) {
                    byte[] decode = Base64.decode(str4, 2);
                    if (decode != null) {
                        str = new String(decode);
                    }
                }
                ((e) g.K(e.class)).a(view.getContext(), str3, null, i, 0, str, appBrandStatObject);
                AppMethodBeat.o(132275);
            }
        }, 0, str2.length(), 17);
        ab.d("MicroMsg.WxaSysTemplateMsgHandler", "handleTemplate(title : %s, username : %s, path : %s, talker : %s)", str2, str3, str4, string);
        if (obj != null) {
            AppMethodBeat.o(132276);
            return spannableString;
        }
        int i4 = R.raw.spannable_app_brand_link_logo;
        switch (i2) {
            case 1:
                i4 = R.raw.spannable_wxa_game_link_logo;
                break;
        }
        Drawable drawable = context.getResources().getDrawable(i4);
        drawable.setBounds(0, 0, o.aNT(), o.aNT());
        new SpannableString("@ ").setSpan(new com.tencent.mm.plugin.appbrand.widget.h.b(drawable), 0, 1, 33);
        CharSequence concat = TextUtils.concat(new CharSequence[]{r2, spannableString});
        AppMethodBeat.o(132276);
        return concat;
    }
}
