package com.tencent.p177mm.plugin.search.p741b.p742a.p743a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3157b;
import com.tencent.p177mm.plugin.fts.p424ui.FTSConvMessageUI;
import com.tencent.p177mm.plugin.fts.p424ui.FTSConvTalkerMessageUI;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C20874p;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45974m;
import com.tencent.p177mm.plugin.search.C28926a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.search.b.a.a.b */
public final class C7073b implements C3157b {
    /* renamed from: a */
    public final boolean mo7423a(Context context, C3154a c3154a) {
        String str = null;
        AppMethodBeat.m2504i(24406);
        C45974m c45974m = (C45974m) c3154a;
        Intent intent;
        C16527d qX;
        Intent intent2;
        if (c45974m.mKY < 2) {
            if (C17903f.m28109rc(c45974m.username)) {
                C28926a.gkE.mo38912c(new Intent().putExtra("Contact_User", c45974m.username), context);
            } else if (C17903f.m28103kq(c45974m.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", c45974m.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                C25985d.m41473f(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (C17903f.m28110rd(c45974m.username)) {
                qX = C17903f.m28104qX(c45974m.username);
                if (qX != null) {
                    str = qX.adT();
                }
                if (str == null) {
                    str = "";
                }
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", c45974m.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                C28926a.gkE.mo38915d(new Intent().putExtra("Chat_User", c45974m.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", c45974m.hpS.mEB).putExtra("highlight_keyword_list", C5046bo.m7508P(c45974m.mDz.mEa)), context);
            }
        } else if (C17903f.m28103kq(c45974m.username)) {
            intent = new Intent();
            intent.putExtra("Contact_User", c45974m.username);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 5);
            C25985d.m41473f(context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (C17903f.m28110rd(c45974m.username)) {
            qX = C17903f.m28104qX(c45974m.username);
            if (qX != null) {
                str = qX.adT();
            }
            if (str == null) {
                str = "";
            }
            intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", c45974m.username);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (c45974m instanceof C20874p) {
            C20874p c20874p = (C20874p) c45974m;
            context.startActivity(new Intent(context, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", c20874p.mFa).putExtra("key_talker_query", c20874p.mKp.mDz.mDY).putExtra("key_talker", c20874p.mKp.mDx).putExtra("key_conv", c20874p.username).putExtra("key_query", c20874p.mDz.mDY).putExtra("detail_type", c20874p.showType));
        } else {
            context.startActivity(new Intent(context, FTSConvMessageUI.class).putExtra("Search_Scene", c45974m.mFa).putExtra("key_conv", c45974m.username).putExtra("key_query", c45974m.mDz.mDY).putExtra("key_count", c45974m.mKY));
        }
        AppMethodBeat.m2505o(24406);
        return true;
    }
}
