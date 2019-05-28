package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.c.b.t;
import com.tencent.mm.ui.chatting.c.x;
import com.tencent.mm.ui.chatting.viewitems.ay;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Map;

public final class s {

    public interface n {
        void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar);
    }

    public static class o {
        bi cKd;
        String fhu;
        String svN;

        public o(String str, bi biVar, String str2) {
            this.fhu = str;
            this.cKd = biVar;
            this.svN = str2;
        }
    }

    public static class p extends e {
        public p(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            long j;
            UnsupportedOperationException e;
            int intExtra;
            int sessionId;
            Exception e2;
            AppMethodBeat.i(30734);
            ay ayVar = (ay) view.getTag();
            int i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", Integer.valueOf((int) (currentTimeMillis / 1000)));
            if (e.a(ayVar.cRS, aVar.yTx.getContext(), null, aVar.getTalkerUserName())) {
                AppMethodBeat.o(30734);
                return;
            }
            String str = ayVar.userName;
            String str2 = ayVar.zit;
            if (str == null || str.equals("")) {
                AppMethodBeat.o(30734);
                return;
            }
            int i2;
            str = com.tencent.mm.af.l.c(str, 0, aVar.yTx.getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK), r10);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("shortUrl", str);
            intent.putExtra("webpageTitle", str2);
            Bundle bundle = new Bundle();
            if (biVar != null) {
                if (biVar.dtu()) {
                    Map z = br.z(biVar.field_content, "msg");
                    if (z != null) {
                        com.tencent.mm.ui.chatting.viewitems.w.b aX = com.tencent.mm.ui.chatting.viewitems.w.b.aX(z);
                        if (!bo.isNullOrNil(aX.fhu)) {
                            intent.putExtra("KTemplateId", aX.fhu);
                            ab.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", aX.fhu, ayVar.cMg);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11608, aX.fhu, ayVar.cMg, Integer.valueOf(0));
                        }
                    }
                }
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(biVar.field_talker);
                if (aoO != null && aoO.dsf()) {
                    i = 4;
                    ab.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", aoO.field_username);
                }
                i2 = i;
                intent.putExtra("msg_id", biVar.field_msgId);
                intent.putExtra("KPublisherId", "msg_" + Long.toString(biVar.field_msgSvrId));
                intent.putExtra("pre_username", biVar.field_talker);
                com.tencent.mm.ui.chatting.c.b.d dVar = (com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class);
                intent.putExtra("prePublishId", "msg_" + Long.toString(biVar.field_msgSvrId));
                intent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(biVar, ayVar.yFW, dVar.dDm()));
                intent.putExtra("preChatName", aVar.getTalkerUserName());
                intent.putExtra("preMsgIndex", ayVar.uno);
                Bundle bundle2 = ayVar.ziy;
                if (bundle2 != null) {
                    intent.putExtras(bundle2);
                }
            } else {
                i2 = 0;
            }
            bundle.putInt("snsWebSource", i2);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("geta8key_username", aVar.getTalkerUserName());
            if (!bo.isNullOrNil(ayVar.cMg)) {
                intent.putExtra("srcUsername", ayVar.cMg);
                intent.putExtra("srcDisplayname", ayVar.cMh);
                intent.putExtra("mode", 1);
            }
            intent.putExtra("message_id", ayVar.unn);
            intent.putExtra("message_index", ayVar.uno);
            intent.putExtra("from_scence", 1);
            intent.putExtra("start_activity_time", currentTimeMillis);
            intent.putExtra(com.tencent.mm.ui.e.m.ygo, ayVar.ziA);
            intent.addFlags(536870912);
            int intExtra2 = aVar.yTx.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
            if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(2) && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(aVar.yTx.getContext(), ayVar.userName, ayVar.ziA, 0, intExtra2, intent)) {
                ab.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
            } else {
                com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            if (!bo.isNullOrNil(aVar.getTalkerUserName())) {
                aw.ZK();
                if (com.tencent.mm.model.c.XM().aoO(aVar.getTalkerUserName()).duk == 1) {
                    aw.ZK();
                    com.tencent.mm.model.c.XR().ape(aVar.getTalkerUserName());
                }
            }
            if (biVar != null && biVar.drC()) {
                com.tencent.mm.af.o b = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).b(biVar.field_msgId, biVar.field_content);
                if (b == null || b.fjr == null || b.fjr.size() <= ayVar.uno) {
                    AppMethodBeat.o(30734);
                    return;
                }
                int i3 = 0;
                com.tencent.mm.af.p pVar = (com.tencent.mm.af.p) b.fjr.get(ayVar.uno);
                if (bo.isNullOrNil(pVar.url)) {
                    j = 0;
                } else {
                    try {
                        Uri parse = Uri.parse(pVar.url);
                        j = bo.getLong(parse.getQueryParameter("mid"), 0);
                        try {
                            i3 = bo.getInt(parse.getQueryParameter("idx"), 0);
                        } catch (UnsupportedOperationException e3) {
                            e = e3;
                            ab.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e.getMessage());
                            intExtra = aVar.yTx.getIntExtra("specific_chat_from_scene", 0);
                            sessionId = com.tencent.mm.storage.s.getSessionId();
                            com.tencent.mm.plugin.report.service.h.pYm.e(16243, biVar.field_talker, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(intExtra), Integer.valueOf(sessionId), Integer.valueOf(2), Integer.valueOf(r10), Integer.valueOf(com.tencent.mm.af.l.Me()));
                            AppMethodBeat.o(30734);
                        } catch (Exception e4) {
                            e2 = e4;
                            ab.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e2.getMessage());
                            intExtra = aVar.yTx.getIntExtra("specific_chat_from_scene", 0);
                            sessionId = com.tencent.mm.storage.s.getSessionId();
                            com.tencent.mm.plugin.report.service.h.pYm.e(16243, biVar.field_talker, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(intExtra), Integer.valueOf(sessionId), Integer.valueOf(2), Integer.valueOf(r10), Integer.valueOf(com.tencent.mm.af.l.Me()));
                            AppMethodBeat.o(30734);
                        }
                    } catch (UnsupportedOperationException e5) {
                        e = e5;
                        j = 0;
                    } catch (Exception e6) {
                        e2 = e6;
                        j = 0;
                        ab.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e2.getMessage());
                        intExtra = aVar.yTx.getIntExtra("specific_chat_from_scene", 0);
                        sessionId = com.tencent.mm.storage.s.getSessionId();
                        com.tencent.mm.plugin.report.service.h.pYm.e(16243, biVar.field_talker, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(intExtra), Integer.valueOf(sessionId), Integer.valueOf(2), Integer.valueOf(r10), Integer.valueOf(com.tencent.mm.af.l.Me()));
                        AppMethodBeat.o(30734);
                    }
                }
                intExtra = aVar.yTx.getIntExtra("specific_chat_from_scene", 0);
                sessionId = com.tencent.mm.storage.s.getSessionId();
                com.tencent.mm.plugin.report.service.h.pYm.e(16243, biVar.field_talker, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(intExtra), Integer.valueOf(sessionId), Integer.valueOf(2), Integer.valueOf(r10), Integer.valueOf(com.tencent.mm.af.l.Me()));
            }
            AppMethodBeat.o(30734);
        }
    }

    public static class g implements OnTouchListener {
        private int[] yJQ = new int[2];

        public g() {
            AppMethodBeat.i(30724);
            AppMethodBeat.o(30724);
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(30725);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.yJQ[0] = (int) motionEvent.getRawX();
                    this.yJQ[1] = (int) motionEvent.getRawY();
                    view.setTag(R.id.cy, this.yJQ);
                    break;
            }
            AppMethodBeat.o(30725);
            return false;
        }
    }

    public static class h extends e {
        public h(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(30726);
            ay ayVar = (ay) view.getTag();
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.getTalkerUserName());
            intent.putExtra("rawUrl", ayVar.dJv);
            com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(30726);
        }
    }

    public static abstract class e implements OnClickListener {
        public com.tencent.mm.ui.chatting.d.a yJI;

        public abstract void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar);

        public e(com.tencent.mm.ui.chatting.d.a aVar) {
            this.yJI = aVar;
        }

        public final void onClick(View view) {
            bi biVar = ((ay) view.getTag()).cKd;
            if (biVar != null) {
                a(view, this.yJI, biVar);
            }
        }
    }

    public static class f implements com.tencent.mm.ui.widget.MMTextView.b {
        private OnTouchListener gAg = null;
        private com.tencent.mm.ui.base.o gKG = null;
        private ScrollView hJh = null;
        ak handler = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(30721);
                View view = (View) message.obj;
                if (f.this.urq != view.getScrollY()) {
                    f.this.swe = true;
                    f.this.handler.sendMessageDelayed(f.this.handler.obtainMessage(0, view), 5);
                    f.this.urq = view.getScrollY();
                    AppMethodBeat.o(30721);
                    return;
                }
                f.this.swe = false;
                AppMethodBeat.o(30721);
            }
        };
        private long pDz = 0;
        boolean swe = false;
        private boolean swf = false;
        int urq = 0;
        private com.tencent.mm.ui.chatting.d.a yJI = null;
        private MMTextView yJK = null;
        private TextView yJL = null;
        private final int yJM = 3;
        private int yJN = 0;
        private int yJO = 0;

        public f(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(30722);
            this.yJI = aVar;
            AppMethodBeat.o(30722);
        }

        public final boolean eL(View view) {
            AppMethodBeat.i(30723);
            if (view.getTag() instanceof ay) {
                ay ayVar = (ay) view.getTag();
                if (!(!(view instanceof TextView) || ayVar.cKd == null || this.yJI == null)) {
                    CharSequence charSequence = "";
                    if (view instanceof TextView) {
                        charSequence = ((TextView) view).getText();
                    }
                    Activity context = this.yJI.yTx.getContext();
                    bi biVar = ayVar.cKd;
                    Intent intent = new Intent(context, TextPreviewUI.class);
                    intent.putExtra("key_chat_text", charSequence);
                    intent.putExtra("Chat_Msg_Id", biVar.field_msgId);
                    context.startActivity(intent);
                    com.tencent.mm.ui.base.b.hL(context);
                    AppMethodBeat.o(30723);
                    return true;
                }
            }
            AppMethodBeat.o(30723);
            return false;
        }
    }

    public static class j extends e {
        public j(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(30728);
            ay ayVar = (ay) view.getTag();
            int i = ayVar.tid;
            String str = ayVar.fiE;
            String str2 = ayVar.desc;
            String str3 = ayVar.iconUrl;
            String str4 = ayVar.secondUrl;
            int i2 = ayVar.pageType;
            if (i != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.getTalkerUserName());
                intent.putExtra("rawUrl", ayVar.dJv);
                intent.putExtra("set_id", i);
                intent.putExtra("set_title", str);
                intent.putExtra("set_iconURL", str3);
                intent.putExtra("set_desc", str2);
                intent.putExtra("headurl", str4);
                intent.putExtra("pageType", i2);
                com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
                AppMethodBeat.o(30728);
                return;
            }
            ab.i("MicroMsg.DesignerClickListener", "topic id is zero.");
            AppMethodBeat.o(30728);
        }
    }

    public static class k extends e {
        public k(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(30729);
            r.a(view, aVar.yTx.getContext(), aVar.getTalkerUserName());
            AppMethodBeat.o(30729);
        }
    }

    public static class c implements com.tencent.mm.plugin.story.api.i.a {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public c(com.tencent.mm.ui.chatting.d.a aVar) {
            this.yJI = aVar;
        }

        public final boolean ed(View view) {
            AppMethodBeat.i(30719);
            String str = ((ay) view.getTag()).userName;
            ab.i("MicroMsg.AvatarDoubleClickListener", "onDoubleClick: %s", str);
            if (com.tencent.magicbrush.c.isNullOrNil(str)) {
                AppMethodBeat.o(30719);
                return false;
            }
            boolean arn = ((x) this.yJI.aF(x.class)).arn(str);
            AppMethodBeat.o(30719);
            return arn;
        }
    }

    public static class i extends e {
        public i(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(30727);
            ay ayVar = (ay) view.getTag();
            int i = ayVar.designerUIN;
            String str = ayVar.designerName;
            String str2 = ayVar.designerRediretctUrl;
            if (i != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.getTalkerUserName());
                intent.putExtra("rawUrl", ayVar.dJv);
                intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
                intent.putExtra("name", str);
                intent.putExtra("rediret_url", str2);
                intent.putExtra("extra_scence", 22);
                com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
            }
            AppMethodBeat.o(30727);
        }
    }

    public static class l extends e {
        public l(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(30730);
            ay ayVar = (ay) view.getTag();
            int i = ayVar.tid;
            String str = ayVar.fiE;
            String str2 = ayVar.desc;
            String str3 = ayVar.iconUrl;
            String str4 = ayVar.secondUrl;
            if (i != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", aVar.getTalkerUserName());
                intent.putExtra("rawUrl", ayVar.dJv);
                intent.putExtra("topic_id", i);
                intent.putExtra("topic_name", str);
                intent.putExtra("topic_desc", str2);
                intent.putExtra("topic_icon_url", str3);
                intent.putExtra("topic_ad_url", str4);
                intent.putExtra("extra_scence", 22);
                com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
                AppMethodBeat.o(30730);
                return;
            }
            ab.i("MicroMsg.DesignerClickListener", "topic id is zero.");
            AppMethodBeat.o(30730);
        }
    }

    public static class b implements OnClickListener {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public b(com.tencent.mm.ui.chatting.d.a aVar) {
            this.yJI = aVar;
        }

        public void onClick(View view) {
            boolean z = false;
            AppMethodBeat.i(30718);
            ay ayVar = (ay) view.getTag();
            String str = ayVar.userName;
            Intent intent;
            if (str == null || str.equals("")) {
                AppMethodBeat.o(30718);
            } else if (((t) this.yJI.aF(t.class)).dEF()) {
                Context context = this.yJI.yTx.getContext();
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Encryptusername", true);
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Contact_IsLbsChattingProfile", true);
                com.tencent.mm.bp.d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(30718);
            } else {
                com.tencent.mm.ui.chatting.c.b.d dVar = (com.tencent.mm.ui.chatting.c.b.d) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.d.class);
                if (dVar.dDm()) {
                    com.tencent.mm.aj.a.j ro = dVar.dDk().ro(str);
                    if (ro != null) {
                        if (ro == null || bo.isNullOrNil(ro.field_profileUrl)) {
                            boolean z2;
                            String str2 = "MicroMsg.ChattingListAvatarListener";
                            str = "onClick userInfo == null:%s";
                            Object[] objArr = new Object[1];
                            if (ro == null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objArr[0] = Boolean.valueOf(z2);
                            ab.w(str2, str, objArr);
                            AppMethodBeat.o(30718);
                            return;
                        }
                        ab.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", ro.field_profileUrl);
                        z.aeZ().aG(ro.field_userId, ro.field_brandUserName);
                        intent = new Intent();
                        intent.putExtra("rawUrl", ro.field_profileUrl);
                        intent.putExtra("useJs", true);
                        com.tencent.mm.bp.d.b(this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    AppMethodBeat.o(30718);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                a(intent, ayVar);
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(str);
                if (aoO != null && ((int) aoO.ewQ) > 0 && com.tencent.mm.n.a.jh(aoO.field_type)) {
                    com.tencent.mm.ui.contact.e.a(intent, str);
                }
                if (com.tencent.mm.model.t.kH(this.yJI.getTalkerUserName())) {
                    aw.ZK();
                    u ob = com.tencent.mm.model.c.XV().ob(this.yJI.getTalkerUserName());
                    intent.putExtra("Contact_RoomNickname", ob.mJ(str));
                    intent.putExtra("Contact_Scene", 14);
                    intent.putExtra("Contact_ChatRoomId", this.yJI.getTalkerUserName());
                    intent.putExtra("room_name", this.yJI.getTalkerUserName());
                    if (ob.field_roomowner != null) {
                        z = ob.field_roomowner.equals(r.Yz());
                    }
                    intent.putExtra("Is_RoomOwner", z);
                }
                if (ayVar.cKd != null) {
                    switch (ayVar.cKd.getType()) {
                        case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                        case com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX /*57*/:
                            intent.putExtra("Contact_Scene", 34);
                            intent.putExtra("Contact_IsLBSFriend", true);
                            break;
                    }
                }
                intent.putExtra("CONTACT_INFO_UI_SOURCE", this.yJI.dFx() ? 3 : 2);
                com.tencent.mm.bp.d.b(this.yJI.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent, 213);
                AppMethodBeat.o(30718);
            }
        }

        public void a(Intent intent, ay ayVar) {
        }
    }

    public static class a extends b {
        public a(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(Intent intent, ay ayVar) {
            AppMethodBeat.i(30717);
            if (!bo.isNullOrNil(ayVar.ziw)) {
                intent.putExtra("Contact_BIZ_KF_WORKER_ID", ayVar.ziw);
            }
            AppMethodBeat.o(30717);
        }
    }

    public static class d implements OnLongClickListener {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public d(com.tencent.mm.ui.chatting.d.a aVar) {
            this.yJI = aVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(30720);
            if (((com.tencent.mm.ui.chatting.c.b.o) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.o.class)).dDX().dkx()) {
                ab.w("changelcai", "ChattingUI isScrolling!!!");
                AppMethodBeat.o(30720);
            } else {
                ay ayVar = (ay) view.getTag();
                int selectionStart = ((com.tencent.mm.ui.chatting.c.b.o) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.o.class)).dDX().getSelectionStart();
                if (ayVar.userName.equals(r.Yz()) || ayVar.userName.equals("notifymessage")) {
                    AppMethodBeat.o(30720);
                } else if (((com.tencent.mm.ui.chatting.c.b.o) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.o.class)).dDX().getIsVoiceInputPanleShow()) {
                    ab.i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
                    AppMethodBeat.o(30720);
                } else {
                    com.tencent.mm.ui.chatting.c.b.d dVar = (com.tencent.mm.ui.chatting.c.b.d) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.d.class);
                    if (com.tencent.mm.model.t.kH(this.yJI.getTalkerUserName()) || dVar.dDn()) {
                        Object arj;
                        com.tencent.mm.plugin.report.service.h.pYm.e(10976, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                        aw.ZK();
                        u oa = com.tencent.mm.model.c.XV().oa(ayVar.chatroomName);
                        if (dVar.dDn()) {
                            arj = ((com.tencent.mm.ui.chatting.c.b.f) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.f.class)).arj(ayVar.userName);
                        } else {
                            String a = AtSomeoneUI.a(oa, ayVar.userName);
                            String arj2;
                            if (bo.ac(a)) {
                                arj2 = com.tencent.mm.model.s.mH(ayVar.userName);
                            } else {
                                arj2 = a;
                            }
                        }
                        com.tencent.mm.ui.chatting.c.b.o oVar = (com.tencent.mm.ui.chatting.c.b.o) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.o.class);
                        StringBuffer stringBuffer = new StringBuffer(oVar.dDX().getLastText());
                        stringBuffer.insert(selectionStart, "@" + arj2 + 8197);
                        oVar.dDX().u(stringBuffer.toString(), (selectionStart + arj2.length()) + 2, true);
                        oVar.dDX().ax(ayVar.chatroomName, ayVar.userName, arj2 == null ? null : arj2.toString());
                        oVar.dDX().setMode(1);
                        view.postDelayed(new Runnable() {
                            public final void run() {
                            }
                        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    } else if (com.tencent.mm.model.t.mY(this.yJI.getTalkerUserName()) && !this.yJI.getTalkerUserName().contains("@")) {
                        CharSequence arj3;
                        com.tencent.mm.plugin.report.service.h.pYm.e(10976, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
                        if (!dVar.dDm() || dVar.dDn()) {
                            Object arj32 = com.tencent.mm.model.s.mH(ayVar.userName);
                        } else {
                            arj32 = ((com.tencent.mm.ui.chatting.c.b.f) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.f.class)).arj(ayVar.userName);
                        }
                        com.tencent.mm.ui.chatting.c.b.o oVar2 = (com.tencent.mm.ui.chatting.c.b.o) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.o.class);
                        StringBuffer stringBuffer2 = new StringBuffer(oVar2.dDX().getLastText());
                        stringBuffer2.insert(selectionStart, arj32);
                        oVar2.dDX().u(stringBuffer2.toString(), arj32.length() + selectionStart, true);
                        oVar2.dDX().setMode(1);
                        view.postDelayed(new Runnable() {
                            public final void run() {
                            }
                        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    }
                    AppMethodBeat.o(30720);
                }
            }
            return true;
        }
    }

    public static class m extends e {
        public m(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(30733);
            com.tencent.mm.ui.base.h.d(aVar.yTx.getContext(), aVar.yTx.getMMResources().getString(R.string.b9q), "", aVar.yTx.getMMResources().getString(R.string.b9s), aVar.yTx.getMMResources().getString(R.string.b9p), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(30731);
                    cv cvVar = new cv();
                    cvVar.cvX.enable = true;
                    com.tencent.mm.sdk.b.a.xxA.m(cvVar);
                    AppMethodBeat.o(30731);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(30732);
                    cv cvVar = new cv();
                    cvVar.cvX.enable = false;
                    com.tencent.mm.sdk.b.a.xxA.m(cvVar);
                    AppMethodBeat.o(30732);
                }
            });
            AppMethodBeat.o(30733);
        }
    }
}
