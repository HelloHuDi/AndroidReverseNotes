package com.tencent.p177mm.p612ui.conversation;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p230g.p232b.p233a.C32677t;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.bizchat.BizChatConversationUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.BizTimeLineUI;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C7617ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.conversation.f */
public final class C36285f implements OnItemClickListener {
    private Activity activity;
    private ListView zqz;
    private C23987h zrd;

    public C36285f(C23987h c23987h, ListView listView, Activity activity) {
        this.zrd = c23987h;
        this.zqz = listView;
        this.activity = activity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(34209);
        if (i < this.zqz.getHeaderViewsCount()) {
            AppMethodBeat.m2505o(34209);
            return;
        }
        int headerViewsCount = i - this.zqz.getHeaderViewsCount();
        C7617ak c7617ak = (C7617ak) this.zrd.getItem(headerViewsCount);
        if (c7617ak == null) {
            C4990ab.m7412e("MicroMsg.ConversationClickListener", "null user at position = ".concat(String.valueOf(headerViewsCount)));
            AppMethodBeat.m2505o(34209);
            return;
        }
        Object obj;
        if (c7617ak.mo16714jl(16777216)) {
            c7617ak.mo16713jk(16777216);
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15767a(c7617ak, c7617ak.field_username);
        }
        if (c7617ak.mo16714jl(33554432)) {
            c7617ak.mo16713jk(33554432);
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo15767a(c7617ak, c7617ak.field_username);
        }
        if (C1855t.m3936ne(c7617ak.field_username)) {
            if (C1853r.m3836YR()) {
                C25985d.m41448H(this.activity, "tmessage", ".ui.TConversationUI");
            } else {
                C25985d.m41467b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
            }
            this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
            obj = null;
        } else if (C1855t.m3937nf(c7617ak.field_username)) {
            if (C1853r.m3835YQ()) {
                C25985d.m41448H(this.activity, "bottle", ".ui.BottleConversationUI");
            } else {
                C25985d.m41467b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
            }
            this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
            obj = null;
        } else if (C1855t.m3942nk(c7617ak.field_username)) {
            MMAppMgr.cancelNotification(c7617ak.field_username);
            C25985d.m41467b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
            this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
            obj = null;
        } else {
            Intent intent;
            if (C1855t.m3934nc(c7617ak.field_username)) {
                C1720g.m3537RQ();
                if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(17, null)) == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    C25985d.m41467b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                    this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
                    obj = null;
                }
            } else if (C1855t.m3948nq(c7617ak.field_username)) {
                obj = null;
            } else if (C1855t.m3947np(c7617ak.field_username)) {
                if (C1853r.m3840YV()) {
                    intent = new Intent();
                    intent.addFlags(67108864);
                    intent.putExtra("type", 20);
                    C25985d.m41467b(this.activity, "readerapp", ".ui.ReaderAppUI", intent);
                } else {
                    C25985d.m41467b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                }
                this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
                obj = null;
            } else if (C1855t.m3955nx(c7617ak.field_username)) {
                if (C1853r.m3841YW()) {
                    intent = new Intent();
                    intent.addFlags(67108864);
                    intent.putExtra("type", 11);
                    C25985d.m41467b(this.activity, "readerapp", ".ui.ReaderAppUI", intent);
                } else {
                    C25985d.m41467b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                }
                this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
                obj = null;
            } else if (C1855t.m3939nh(c7617ak.field_username)) {
                C25985d.m41467b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
                obj = null;
            } else if (C1855t.m3940ni(c7617ak.field_username)) {
                if (C1853r.m3843YY()) {
                    C25985d.m41467b(this.activity, "masssend", ".ui.MassSendHistoryUI", new Intent().addFlags(67108864));
                } else {
                    C25985d.m41467b(this.activity, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", c7617ak.field_username));
                }
                this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
                obj = null;
            } else if (C1855t.m3954nw(c7617ak.field_username)) {
                if (C26417a.flx != null) {
                    C26417a.flx.mo44189ot(c7617ak.field_username);
                }
                obj = 1;
            } else if (C1855t.m3956ny(c7617ak.field_username)) {
                int startPerformance = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 901, WXHardCoderJNI.hcBizAction, "MicroMsg.ConversationClickListener");
                C4990ab.m7417i("MicroMsg.ConversationClickListener", "summer hardcoder biz startPerformance [%s][%s]", Integer.valueOf(901), Integer.valueOf(startPerformance));
                if (C30309s.aVO()) {
                    intent = new Intent(this.activity, BizTimeLineUI.class);
                    intent.putExtra("KOpenArticleSceneFromScene", 93);
                    this.activity.startActivity(intent);
                } else {
                    this.activity.startActivity(new Intent(this.activity, BizConversationUI.class));
                }
                this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
                obj = null;
            } else if (C1855t.m3913mZ(c7617ak.field_username) && C17903f.m28109rc(c7617ak.field_username)) {
                if (C1855t.m3912mY(c7617ak.field_username)) {
                    intent = new Intent(this.activity, EnterpriseConversationUI.class);
                    intent.putExtra("enterprise_biz_name", c7617ak.field_username);
                    intent.putExtra("enterprise_biz_display_name", C1854s.m3866mJ(c7617ak.field_username));
                    intent.putExtra("enterprise_from_scene", 1);
                    this.activity.startActivity(intent);
                    this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
                    obj = null;
                } else {
                    C30379h.m48465bQ(this.activity, this.activity.getString(C25738R.string.bdw));
                    AppMethodBeat.m2505o(34209);
                    return;
                }
            } else if (C1855t.m3913mZ(c7617ak.field_username) && C17903f.m28103kq(c7617ak.field_username)) {
                if (C1855t.m3912mY(c7617ak.field_username)) {
                    intent = new Intent(this.activity, BizChatConversationUI.class);
                    intent.putExtra("Contact_User", c7617ak.field_username);
                    intent.putExtra("biz_chat_from_scene", 1);
                    intent.addFlags(67108864);
                    this.activity.startActivity(intent);
                    this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
                    obj = null;
                } else {
                    C30379h.m48465bQ(this.activity, this.activity.getString(C25738R.string.bdw));
                    AppMethodBeat.m2505o(34209);
                    return;
                }
            } else if (C1855t.m3922nH(c7617ak.field_username)) {
                intent = new Intent();
                intent.setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
                intent.putExtra("Contact_User", c7617ak.field_username);
                intent.putExtra("app_brand_conversation_from_scene", 1);
                intent.addFlags(67108864);
                this.activity.startActivity(intent);
                this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
                obj = null;
            }
            obj = 1;
        }
        if (obj != null) {
            this.zrd.mo39787a(view, headerViewsCount, c7617ak.field_username);
            C34830g.m57194BN(9);
            LauncherUI launcherUI = (LauncherUI) this.activity;
            Assert.assertTrue("Launcher should not be empty.", launcherUI != null);
            Bundle bundle = new Bundle();
            bundle.putInt("specific_chat_from_scene", 7);
            bundle.putInt("KOpenArticleSceneFromScene", 93);
            bundle.putInt("Main_IndexInSessionList", headerViewsCount);
            bundle.putInt("Main_UnreadCount", c7617ak.field_unReadCount);
            launcherUI.startChatting(c7617ak.field_username, bundle, true);
            if (C1855t.m3903mP(c7617ak.field_username)) {
                C32677t c32677t = new C32677t();
                c32677t.mo53208eO(c7617ak.field_username);
                c32677t.cXP = 1;
                c32677t.ajK();
            }
        }
        AppMethodBeat.m2505o(34209);
    }
}
