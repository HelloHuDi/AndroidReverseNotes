package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class f implements OnItemClickListener {
    private Activity activity;
    private ListView zqz;
    private h zrd;

    public f(h hVar, ListView listView, Activity activity) {
        this.zrd = hVar;
        this.zqz = listView;
        this.activity = activity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(34209);
        if (i < this.zqz.getHeaderViewsCount()) {
            AppMethodBeat.o(34209);
            return;
        }
        int headerViewsCount = i - this.zqz.getHeaderViewsCount();
        ak akVar = (ak) this.zrd.getItem(headerViewsCount);
        if (akVar == null) {
            ab.e("MicroMsg.ConversationClickListener", "null user at position = ".concat(String.valueOf(headerViewsCount)));
            AppMethodBeat.o(34209);
            return;
        }
        Object obj;
        if (akVar.jl(16777216)) {
            akVar.jk(16777216);
            aw.ZK();
            c.XR().a(akVar, akVar.field_username);
        }
        if (akVar.jl(33554432)) {
            akVar.jk(33554432);
            aw.ZK();
            c.XR().a(akVar, akVar.field_username);
        }
        if (t.ne(akVar.field_username)) {
            if (r.YR()) {
                d.H(this.activity, "tmessage", ".ui.TConversationUI");
            } else {
                d.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
            }
            this.zrd.a(view, headerViewsCount, akVar.field_username);
            obj = null;
        } else if (t.nf(akVar.field_username)) {
            if (r.YQ()) {
                d.H(this.activity, "bottle", ".ui.BottleConversationUI");
            } else {
                d.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
            }
            this.zrd.a(view, headerViewsCount, akVar.field_username);
            obj = null;
        } else if (t.nk(akVar.field_username)) {
            MMAppMgr.cancelNotification(akVar.field_username);
            d.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
            this.zrd.a(view, headerViewsCount, akVar.field_username);
            obj = null;
        } else {
            Intent intent;
            if (t.nc(akVar.field_username)) {
                g.RQ();
                if (bo.h((Integer) g.RP().Ry().get(17, null)) == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    d.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                    this.zrd.a(view, headerViewsCount, akVar.field_username);
                    obj = null;
                }
            } else if (t.nq(akVar.field_username)) {
                obj = null;
            } else if (t.np(akVar.field_username)) {
                if (r.YV()) {
                    intent = new Intent();
                    intent.addFlags(67108864);
                    intent.putExtra("type", 20);
                    d.b(this.activity, "readerapp", ".ui.ReaderAppUI", intent);
                } else {
                    d.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                }
                this.zrd.a(view, headerViewsCount, akVar.field_username);
                obj = null;
            } else if (t.nx(akVar.field_username)) {
                if (r.YW()) {
                    intent = new Intent();
                    intent.addFlags(67108864);
                    intent.putExtra("type", 11);
                    d.b(this.activity, "readerapp", ".ui.ReaderAppUI", intent);
                } else {
                    d.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                }
                this.zrd.a(view, headerViewsCount, akVar.field_username);
                obj = null;
            } else if (t.nh(akVar.field_username)) {
                d.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                this.zrd.a(view, headerViewsCount, akVar.field_username);
                obj = null;
            } else if (t.ni(akVar.field_username)) {
                if (r.YY()) {
                    d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", new Intent().addFlags(67108864));
                } else {
                    d.b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", akVar.field_username));
                }
                this.zrd.a(view, headerViewsCount, akVar.field_username);
                obj = null;
            } else if (t.nw(akVar.field_username)) {
                if (a.flx != null) {
                    a.flx.ot(akVar.field_username);
                }
                obj = 1;
            } else if (t.ny(akVar.field_username)) {
                int startPerformance = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 901, WXHardCoderJNI.hcBizAction, "MicroMsg.ConversationClickListener");
                ab.i("MicroMsg.ConversationClickListener", "summer hardcoder biz startPerformance [%s][%s]", Integer.valueOf(901), Integer.valueOf(startPerformance));
                if (s.aVO()) {
                    intent = new Intent(this.activity, BizTimeLineUI.class);
                    intent.putExtra("KOpenArticleSceneFromScene", 93);
                    this.activity.startActivity(intent);
                } else {
                    this.activity.startActivity(new Intent(this.activity, BizConversationUI.class));
                }
                this.zrd.a(view, headerViewsCount, akVar.field_username);
                obj = null;
            } else if (t.mZ(akVar.field_username) && com.tencent.mm.aj.f.rc(akVar.field_username)) {
                if (t.mY(akVar.field_username)) {
                    intent = new Intent(this.activity, EnterpriseConversationUI.class);
                    intent.putExtra("enterprise_biz_name", akVar.field_username);
                    intent.putExtra("enterprise_biz_display_name", com.tencent.mm.model.s.mJ(akVar.field_username));
                    intent.putExtra("enterprise_from_scene", 1);
                    this.activity.startActivity(intent);
                    this.zrd.a(view, headerViewsCount, akVar.field_username);
                    obj = null;
                } else {
                    h.bQ(this.activity, this.activity.getString(R.string.bdw));
                    AppMethodBeat.o(34209);
                    return;
                }
            } else if (t.mZ(akVar.field_username) && com.tencent.mm.aj.f.kq(akVar.field_username)) {
                if (t.mY(akVar.field_username)) {
                    intent = new Intent(this.activity, BizChatConversationUI.class);
                    intent.putExtra("Contact_User", akVar.field_username);
                    intent.putExtra("biz_chat_from_scene", 1);
                    intent.addFlags(67108864);
                    this.activity.startActivity(intent);
                    this.zrd.a(view, headerViewsCount, akVar.field_username);
                    obj = null;
                } else {
                    h.bQ(this.activity, this.activity.getString(R.string.bdw));
                    AppMethodBeat.o(34209);
                    return;
                }
            } else if (t.nH(akVar.field_username)) {
                intent = new Intent();
                intent.setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
                intent.putExtra("Contact_User", akVar.field_username);
                intent.putExtra("app_brand_conversation_from_scene", 1);
                intent.addFlags(67108864);
                this.activity.startActivity(intent);
                this.zrd.a(view, headerViewsCount, akVar.field_username);
                obj = null;
            }
            obj = 1;
        }
        if (obj != null) {
            this.zrd.a(view, headerViewsCount, akVar.field_username);
            com.tencent.mm.plugin.report.service.g.BN(9);
            LauncherUI launcherUI = (LauncherUI) this.activity;
            Assert.assertTrue("Launcher should not be empty.", launcherUI != null);
            Bundle bundle = new Bundle();
            bundle.putInt("specific_chat_from_scene", 7);
            bundle.putInt("KOpenArticleSceneFromScene", 93);
            bundle.putInt("Main_IndexInSessionList", headerViewsCount);
            bundle.putInt("Main_UnreadCount", akVar.field_unReadCount);
            launcherUI.startChatting(akVar.field_username, bundle, true);
            if (t.mP(akVar.field_username)) {
                com.tencent.mm.g.b.a.t tVar = new com.tencent.mm.g.b.a.t();
                tVar.eO(akVar.field_username);
                tVar.cXP = 1;
                tVar.ajK();
            }
        }
        AppMethodBeat.o(34209);
    }
}
