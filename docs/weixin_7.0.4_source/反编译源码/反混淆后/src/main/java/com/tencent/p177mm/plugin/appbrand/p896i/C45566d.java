package com.tencent.p177mm.plugin.appbrand.p896i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.p328r.C45674o;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19693f;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.appbrand.widget.p916h.C10982b;
import com.tencent.p177mm.plugin.messenger.p993a.C12514e.C12517b;
import com.tencent.p177mm.plugin.messenger.p993a.C34529a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.i.d */
public final class C45566d implements C12517b {
    /* renamed from: a */
    public final CharSequence mo7904a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
        AppMethodBeat.m2504i(132276);
        if (map == null || map.isEmpty()) {
            C4990ab.m7420w("MicroMsg.WxaSysTemplateMsgHandler", "values map is null or nil");
            AppMethodBeat.m2505o(132276);
            return null;
        }
        Context context = (Context) weakReference.get();
        if (context == null) {
            C4990ab.m7420w("MicroMsg.WxaSysTemplateMsgHandler", "context is null");
            AppMethodBeat.m2505o(132276);
            return null;
        }
        final String str2 = (String) map.get(str + ".title");
        final String str3 = (String) map.get(str + ".username");
        final int i = C5046bo.getInt((String) map.get(str + ".type"), 0);
        int i2 = C5046bo.getInt((String) map.get(str + ".wxaapp_type"), 0);
        final String str4 = (String) map.get(str + ".path");
        Object obj = C5046bo.getInt((String) map.get(new StringBuilder().append(str).append(".forbids").toString()), 0) == 1 ? 1 : null;
        final String string = bundle != null ? bundle.getString("conv_talker_username") : "";
        final int i3 = bundle != null ? bundle.getInt("scene") : 0;
        final long j = bundle != null ? bundle.getLong("msg_sever_id") : 0;
        final String string2 = bundle != null ? bundle.getString("send_msg_username") : "";
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.WxaSysTemplateMsgHandler", "link title is null or nil");
            AppMethodBeat.m2505o(132276);
            return null;
        }
        CharSequence spannableString = new SpannableString(str2);
        final WeakReference<Context> weakReference2 = weakReference;
        spannableString.setSpan(new C34529a() {
            public final void onClickImp(View view) {
                AppMethodBeat.m2504i(132275);
                C4990ab.m7417i("MicroMsg.WxaSysTemplateMsgHandler", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", str2, str3, str4, string);
                weakReference2.get();
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", i3);
                bundle.putString("stat_msg_id", "msg_" + Long.toString(j));
                bundle.putString("stat_chat_talker_username", string);
                bundle.putString("stat_send_msg_user", string2);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_CHUXUE;
                appBrandStatObject.cst = "";
                appBrandStatObject.cOq = C19693f.m30514h(appBrandStatObject.scene, bundle);
                appBrandStatObject.cOr = C19693f.m30515i(appBrandStatObject.scene, bundle);
                String str = "";
                if (str4 != null && str4.length() > 0) {
                    byte[] decode = Base64.decode(str4, 2);
                    if (decode != null) {
                        str = new String(decode);
                    }
                }
                ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(view.getContext(), str3, null, i, 0, str, appBrandStatObject);
                AppMethodBeat.m2505o(132275);
            }
        }, 0, str2.length(), 17);
        C4990ab.m7411d("MicroMsg.WxaSysTemplateMsgHandler", "handleTemplate(title : %s, username : %s, path : %s, talker : %s)", str2, str3, str4, string);
        if (obj != null) {
            AppMethodBeat.m2505o(132276);
            return spannableString;
        }
        int i4 = C1318a.spannable_app_brand_link_logo;
        switch (i2) {
            case 1:
                i4 = C1318a.spannable_wxa_game_link_logo;
                break;
        }
        Drawable drawable = context.getResources().getDrawable(i4);
        drawable.setBounds(0, 0, C45674o.aNT(), C45674o.aNT());
        new SpannableString("@ ").setSpan(new C10982b(drawable), 0, 1, 33);
        CharSequence concat = TextUtils.concat(new CharSequence[]{r2, spannableString});
        AppMethodBeat.m2505o(132276);
        return concat;
    }
}
