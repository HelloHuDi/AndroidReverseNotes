package com.tencent.mm.plugin.search.b.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.FTSConvMessageUI;
import com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.sdk.platformtools.bo;

public final class b implements com.tencent.mm.plugin.fts.a.d.a.b {
    public final boolean a(Context context, a aVar) {
        String str = null;
        AppMethodBeat.i(24406);
        m mVar = (m) aVar;
        Intent intent;
        d qX;
        Intent intent2;
        if (mVar.mKY < 2) {
            if (f.rc(mVar.username)) {
                com.tencent.mm.plugin.search.a.gkE.c(new Intent().putExtra("Contact_User", mVar.username), context);
            } else if (f.kq(mVar.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", mVar.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                com.tencent.mm.bp.d.f(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (f.rd(mVar.username)) {
                qX = f.qX(mVar.username);
                if (qX != null) {
                    str = qX.adT();
                }
                if (str == null) {
                    str = "";
                }
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", mVar.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                com.tencent.mm.plugin.search.a.gkE.d(new Intent().putExtra("Chat_User", mVar.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", mVar.hpS.mEB).putExtra("highlight_keyword_list", bo.P(mVar.mDz.mEa)), context);
            }
        } else if (f.kq(mVar.username)) {
            intent = new Intent();
            intent.putExtra("Contact_User", mVar.username);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 5);
            com.tencent.mm.bp.d.f(context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (f.rd(mVar.username)) {
            qX = f.qX(mVar.username);
            if (qX != null) {
                str = qX.adT();
            }
            if (str == null) {
                str = "";
            }
            intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", mVar.username);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (mVar instanceof p) {
            p pVar = (p) mVar;
            context.startActivity(new Intent(context, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", pVar.mFa).putExtra("key_talker_query", pVar.mKp.mDz.mDY).putExtra("key_talker", pVar.mKp.mDx).putExtra("key_conv", pVar.username).putExtra("key_query", pVar.mDz.mDY).putExtra("detail_type", pVar.showType));
        } else {
            context.startActivity(new Intent(context, FTSConvMessageUI.class).putExtra("Search_Scene", mVar.mFa).putExtra("key_conv", mVar.username).putExtra("key_query", mVar.mDz.mDY).putExtra("key_count", mVar.mKY));
        }
        AppMethodBeat.o(24406);
        return true;
    }
}
