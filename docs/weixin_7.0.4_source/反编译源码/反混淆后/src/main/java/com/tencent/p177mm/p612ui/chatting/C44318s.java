package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.magicbrush.C37414c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p230g.p231a.C9311cv;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.C36158x;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40725t;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7335f;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40814ay;
import com.tencent.p177mm.p612ui.chatting.viewitems.C44346w.C40828b;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c;
import com.tencent.p177mm.p612ui.contact.C36249e;
import com.tencent.p177mm.p612ui.widget.MMTextView;
import com.tencent.p177mm.p612ui.widget.MMTextView.C15988b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C19410e;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.story.api.C29268i.C29267a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.s */
public final class C44318s {

    /* renamed from: com.tencent.mm.ui.chatting.s$n */
    public interface C5365n {
        /* renamed from: a */
        void mo10991a(C46650a c46650a, C7620bi c7620bi);
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$o */
    public static class C5366o {
        C7620bi cKd;
        String fhu;
        String svN;

        public C5366o(String str, C7620bi c7620bi, String str2) {
            this.fhu = str;
            this.cKd = c7620bi;
            this.svN = str2;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$p */
    public static class C5367p extends C23812e {
        public C5367p(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            long j;
            UnsupportedOperationException e;
            int intExtra;
            int sessionId;
            Exception e2;
            AppMethodBeat.m2504i(30734);
            C40814ay c40814ay = (C40814ay) view.getTag();
            int i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", Integer.valueOf((int) (currentTimeMillis / 1000)));
            if (C15636e.m23923a(c40814ay.cRS, c46650a.yTx.getContext(), null, c46650a.getTalkerUserName())) {
                AppMethodBeat.m2505o(30734);
                return;
            }
            String str = c40814ay.userName;
            String str2 = c40814ay.zit;
            if (str == null || str.equals("")) {
                AppMethodBeat.m2505o(30734);
                return;
            }
            int i2;
            str = C1192l.m2621c(str, 0, c46650a.yTx.getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK), r10);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("shortUrl", str);
            intent.putExtra("webpageTitle", str2);
            Bundle bundle = new Bundle();
            if (c7620bi != null) {
                if (c7620bi.dtu()) {
                    Map z = C5049br.m7595z(c7620bi.field_content, "msg");
                    if (z != null) {
                        C40828b aX = C40828b.m70757aX(z);
                        if (!C5046bo.isNullOrNil(aX.fhu)) {
                            intent.putExtra("KTemplateId", aX.fhu);
                            C4990ab.m7411d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", aX.fhu, c40814ay.cMg);
                            C7060h.pYm.mo8381e(11608, aX.fhu, c40814ay.cMg, Integer.valueOf(0));
                        }
                    }
                }
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(c7620bi.field_talker);
                if (aoO != null && aoO.dsf()) {
                    i = 4;
                    C4990ab.m7411d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", aoO.field_username);
                }
                i2 = i;
                intent.putExtra("msg_id", c7620bi.field_msgId);
                intent.putExtra("KPublisherId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                intent.putExtra("pre_username", c7620bi.field_talker);
                C36135d c36135d = (C36135d) c46650a.mo74857aF(C36135d.class);
                intent.putExtra("prePublishId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                intent.putExtra("preUsername", C5378c.m8122a(c7620bi, c40814ay.yFW, c36135d.dDm()));
                intent.putExtra("preChatName", c46650a.getTalkerUserName());
                intent.putExtra("preMsgIndex", c40814ay.uno);
                Bundle bundle2 = c40814ay.ziy;
                if (bundle2 != null) {
                    intent.putExtras(bundle2);
                }
            } else {
                i2 = 0;
            }
            bundle.putInt("snsWebSource", i2);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("geta8key_username", c46650a.getTalkerUserName());
            if (!C5046bo.isNullOrNil(c40814ay.cMg)) {
                intent.putExtra("srcUsername", c40814ay.cMg);
                intent.putExtra("srcDisplayname", c40814ay.cMh);
                intent.putExtra("mode", 1);
            }
            intent.putExtra("message_id", c40814ay.unn);
            intent.putExtra("message_index", c40814ay.uno);
            intent.putExtra("from_scence", 1);
            intent.putExtra("start_activity_time", currentTimeMillis);
            intent.putExtra(C5506m.ygo, c40814ay.ziA);
            intent.addFlags(536870912);
            int intExtra2 = c46650a.yTx.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
            if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(2) && ((C20023b) C1720g.m3528K(C20023b.class)).mo6750a(c46650a.yTx.getContext(), c40814ay.userName, c40814ay.ziA, 0, intExtra2, intent)) {
                C4990ab.m7416i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
            } else {
                C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            if (!C5046bo.isNullOrNil(c46650a.getTalkerUserName())) {
                C9638aw.m17190ZK();
                if (C18628c.m29078XM().aoO(c46650a.getTalkerUserName()).duk == 1) {
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().ape(c46650a.getTalkerUserName());
                }
            }
            if (c7620bi != null && c7620bi.drC()) {
                C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c7620bi.field_msgId, c7620bi.field_content);
                if (b == null || b.fjr == null || b.fjr.size() <= c40814ay.uno) {
                    AppMethodBeat.m2505o(30734);
                    return;
                }
                int i3 = 0;
                C32224p c32224p = (C32224p) b.fjr.get(c40814ay.uno);
                if (C5046bo.isNullOrNil(c32224p.url)) {
                    j = 0;
                } else {
                    try {
                        Uri parse = Uri.parse(c32224p.url);
                        j = C5046bo.getLong(parse.getQueryParameter("mid"), 0);
                        try {
                            i3 = C5046bo.getInt(parse.getQueryParameter("idx"), 0);
                        } catch (UnsupportedOperationException e3) {
                            e = e3;
                            C4990ab.m7421w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e.getMessage());
                            intExtra = c46650a.yTx.getIntExtra("specific_chat_from_scene", 0);
                            sessionId = C30309s.getSessionId();
                            C7060h.pYm.mo8381e(16243, c7620bi.field_talker, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(intExtra), Integer.valueOf(sessionId), Integer.valueOf(2), Integer.valueOf(r10), Integer.valueOf(C1192l.m2616Me()));
                            AppMethodBeat.m2505o(30734);
                        } catch (Exception e4) {
                            e2 = e4;
                            C4990ab.m7421w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e2.getMessage());
                            intExtra = c46650a.yTx.getIntExtra("specific_chat_from_scene", 0);
                            sessionId = C30309s.getSessionId();
                            C7060h.pYm.mo8381e(16243, c7620bi.field_talker, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(intExtra), Integer.valueOf(sessionId), Integer.valueOf(2), Integer.valueOf(r10), Integer.valueOf(C1192l.m2616Me()));
                            AppMethodBeat.m2505o(30734);
                        }
                    } catch (UnsupportedOperationException e5) {
                        e = e5;
                        j = 0;
                    } catch (Exception e6) {
                        e2 = e6;
                        j = 0;
                        C4990ab.m7421w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", e2.getMessage());
                        intExtra = c46650a.yTx.getIntExtra("specific_chat_from_scene", 0);
                        sessionId = C30309s.getSessionId();
                        C7060h.pYm.mo8381e(16243, c7620bi.field_talker, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(intExtra), Integer.valueOf(sessionId), Integer.valueOf(2), Integer.valueOf(r10), Integer.valueOf(C1192l.m2616Me()));
                        AppMethodBeat.m2505o(30734);
                    }
                }
                intExtra = c46650a.yTx.getIntExtra("specific_chat_from_scene", 0);
                sessionId = C30309s.getSessionId();
                C7060h.pYm.mo8381e(16243, c7620bi.field_talker, Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(intExtra), Integer.valueOf(sessionId), Integer.valueOf(2), Integer.valueOf(r10), Integer.valueOf(C1192l.m2616Me()));
            }
            AppMethodBeat.m2505o(30734);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$g */
    public static class C15711g implements OnTouchListener {
        private int[] yJQ = new int[2];

        public C15711g() {
            AppMethodBeat.m2504i(30724);
            AppMethodBeat.m2505o(30724);
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(30725);
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.yJQ[0] = (int) motionEvent.getRawX();
                    this.yJQ[1] = (int) motionEvent.getRawY();
                    view.setTag(2131820679, this.yJQ);
                    break;
            }
            AppMethodBeat.m2505o(30725);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$h */
    public static class C15712h extends C23812e {
        public C15712h(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(30726);
            C40814ay c40814ay = (C40814ay) view.getTag();
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", c46650a.getTalkerUserName());
            intent.putExtra("rawUrl", c40814ay.dJv);
            C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(30726);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$e */
    public static abstract class C23812e implements OnClickListener {
        public C46650a yJI;

        /* renamed from: a */
        public abstract void mo10992a(View view, C46650a c46650a, C7620bi c7620bi);

        public C23812e(C46650a c46650a) {
            this.yJI = c46650a;
        }

        public final void onClick(View view) {
            C7620bi c7620bi = ((C40814ay) view.getTag()).cKd;
            if (c7620bi != null) {
                mo10992a(view, this.yJI, c7620bi);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$f */
    public static class C31497f implements C15988b {
        private OnTouchListener gAg = null;
        private C46633o gKG = null;
        private ScrollView hJh = null;
        C7306ak handler = new C314981();
        private long pDz = 0;
        boolean swe = false;
        private boolean swf = false;
        int urq = 0;
        private C46650a yJI = null;
        private MMTextView yJK = null;
        private TextView yJL = null;
        private final int yJM = 3;
        private int yJN = 0;
        private int yJO = 0;

        /* renamed from: com.tencent.mm.ui.chatting.s$f$1 */
        class C314981 extends C7306ak {
            C314981() {
            }

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(30721);
                View view = (View) message.obj;
                if (C31497f.this.urq != view.getScrollY()) {
                    C31497f.this.swe = true;
                    C31497f.this.handler.sendMessageDelayed(C31497f.this.handler.obtainMessage(0, view), 5);
                    C31497f.this.urq = view.getScrollY();
                    AppMethodBeat.m2505o(30721);
                    return;
                }
                C31497f.this.swe = false;
                AppMethodBeat.m2505o(30721);
            }
        }

        public C31497f(C46650a c46650a) {
            AppMethodBeat.m2504i(30722);
            this.yJI = c46650a;
            AppMethodBeat.m2505o(30722);
        }

        /* renamed from: eL */
        public final boolean mo28264eL(View view) {
            AppMethodBeat.m2504i(30723);
            if (view.getTag() instanceof C40814ay) {
                C40814ay c40814ay = (C40814ay) view.getTag();
                if (!(!(view instanceof TextView) || c40814ay.cKd == null || this.yJI == null)) {
                    CharSequence charSequence = "";
                    if (view instanceof TextView) {
                        charSequence = ((TextView) view).getText();
                    }
                    Activity context = this.yJI.yTx.getContext();
                    C7620bi c7620bi = c40814ay.cKd;
                    Intent intent = new Intent(context, TextPreviewUI.class);
                    intent.putExtra("key_chat_text", charSequence);
                    intent.putExtra("Chat_Msg_Id", c7620bi.field_msgId);
                    context.startActivity(intent);
                    C5274b.m8053hL(context);
                    AppMethodBeat.m2505o(30723);
                    return true;
                }
            }
            AppMethodBeat.m2505o(30723);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$j */
    public static class C36201j extends C23812e {
        public C36201j(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(30728);
            C40814ay c40814ay = (C40814ay) view.getTag();
            int i = c40814ay.tid;
            String str = c40814ay.fiE;
            String str2 = c40814ay.desc;
            String str3 = c40814ay.iconUrl;
            String str4 = c40814ay.secondUrl;
            int i2 = c40814ay.pageType;
            if (i != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", c46650a.getTalkerUserName());
                intent.putExtra("rawUrl", c40814ay.dJv);
                intent.putExtra("set_id", i);
                intent.putExtra("set_title", str);
                intent.putExtra("set_iconURL", str3);
                intent.putExtra("set_desc", str2);
                intent.putExtra("headurl", str4);
                intent.putExtra("pageType", i2);
                C25985d.m41467b(c46650a.yTx.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
                AppMethodBeat.m2505o(30728);
                return;
            }
            C4990ab.m7416i("MicroMsg.DesignerClickListener", "topic id is zero.");
            AppMethodBeat.m2505o(30728);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$k */
    public static class C36202k extends C23812e {
        public C36202k(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(30729);
            C44315r.m80102a(view, c46650a.yTx.getContext(), c46650a.getTalkerUserName());
            AppMethodBeat.m2505o(30729);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$c */
    public static class C40801c implements C29267a {
        private C46650a yJI;

        public C40801c(C46650a c46650a) {
            this.yJI = c46650a;
        }

        /* renamed from: ed */
        public final boolean mo47442ed(View view) {
            AppMethodBeat.m2504i(30719);
            String str = ((C40814ay) view.getTag()).userName;
            C4990ab.m7417i("MicroMsg.AvatarDoubleClickListener", "onDoubleClick: %s", str);
            if (C37414c.isNullOrNil(str)) {
                AppMethodBeat.m2505o(30719);
                return false;
            }
            boolean arn = ((C36158x) this.yJI.mo74857aF(C36158x.class)).arn(str);
            AppMethodBeat.m2505o(30719);
            return arn;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$i */
    public static class C40802i extends C23812e {
        public C40802i(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(30727);
            C40814ay c40814ay = (C40814ay) view.getTag();
            int i = c40814ay.designerUIN;
            String str = c40814ay.designerName;
            String str2 = c40814ay.designerRediretctUrl;
            if (i != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", c46650a.getTalkerUserName());
                intent.putExtra("rawUrl", c40814ay.dJv);
                intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
                intent.putExtra("name", str);
                intent.putExtra("rediret_url", str2);
                intent.putExtra("extra_scence", 22);
                C25985d.m41467b(c46650a.yTx.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
            }
            AppMethodBeat.m2505o(30727);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$l */
    public static class C40803l extends C23812e {
        public C40803l(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(30730);
            C40814ay c40814ay = (C40814ay) view.getTag();
            int i = c40814ay.tid;
            String str = c40814ay.fiE;
            String str2 = c40814ay.desc;
            String str3 = c40814ay.iconUrl;
            String str4 = c40814ay.secondUrl;
            if (i != 0) {
                Intent intent = new Intent();
                intent.putExtra("geta8key_username", c46650a.getTalkerUserName());
                intent.putExtra("rawUrl", c40814ay.dJv);
                intent.putExtra("topic_id", i);
                intent.putExtra("topic_name", str);
                intent.putExtra("topic_desc", str2);
                intent.putExtra("topic_icon_url", str3);
                intent.putExtra("topic_ad_url", str4);
                intent.putExtra("extra_scence", 22);
                C25985d.m41467b(c46650a.yTx.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
                AppMethodBeat.m2505o(30730);
                return;
            }
            C4990ab.m7416i("MicroMsg.DesignerClickListener", "topic id is zero.");
            AppMethodBeat.m2505o(30730);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$b */
    public static class C44316b implements OnClickListener {
        private C46650a yJI;

        public C44316b(C46650a c46650a) {
            this.yJI = c46650a;
        }

        public void onClick(View view) {
            boolean z = false;
            AppMethodBeat.m2504i(30718);
            C40814ay c40814ay = (C40814ay) view.getTag();
            String str = c40814ay.userName;
            Intent intent;
            if (str == null || str.equals("")) {
                AppMethodBeat.m2505o(30718);
            } else if (((C40725t) this.yJI.mo74857aF(C40725t.class)).dEF()) {
                Context context = this.yJI.yTx.getContext();
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Encryptusername", true);
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Contact_IsLbsChattingProfile", true);
                C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.m2505o(30718);
            } else {
                C36135d c36135d = (C36135d) this.yJI.mo74857aF(C36135d.class);
                if (c36135d.dDm()) {
                    C45143j ro = c36135d.dDk().mo73054ro(str);
                    if (ro != null) {
                        if (ro == null || C5046bo.isNullOrNil(ro.field_profileUrl)) {
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
                            C4990ab.m7421w(str2, str, objArr);
                            AppMethodBeat.m2505o(30718);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", ro.field_profileUrl);
                        C41747z.aeZ().mo43716aG(ro.field_userId, ro.field_brandUserName);
                        intent = new Intent();
                        intent.putExtra("rawUrl", ro.field_profileUrl);
                        intent.putExtra("useJs", true);
                        C25985d.m41467b(this.yJI.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    AppMethodBeat.m2505o(30718);
                    return;
                }
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                mo70188a(intent, c40814ay);
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                if (aoO != null && ((int) aoO.ewQ) > 0 && C7486a.m12942jh(aoO.field_type)) {
                    C36249e.m59677a(intent, str);
                }
                if (C1855t.m3896kH(this.yJI.getTalkerUserName())) {
                    C9638aw.m17190ZK();
                    C7577u ob = C18628c.m29087XV().mo14886ob(this.yJI.getTalkerUserName());
                    intent.putExtra("Contact_RoomNickname", ob.mo16807mJ(str));
                    intent.putExtra("Contact_Scene", 14);
                    intent.putExtra("Contact_ChatRoomId", this.yJI.getTalkerUserName());
                    intent.putExtra("room_name", this.yJI.getTalkerUserName());
                    if (ob.field_roomowner != null) {
                        z = ob.field_roomowner.equals(C1853r.m3846Yz());
                    }
                    intent.putExtra("Is_RoomOwner", z);
                }
                if (c40814ay.cKd != null) {
                    switch (c40814ay.cKd.getType()) {
                        case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                        case C19410e.CTRL_INDEX /*57*/:
                            intent.putExtra("Contact_Scene", 34);
                            intent.putExtra("Contact_IsLBSFriend", true);
                            break;
                    }
                }
                intent.putExtra("CONTACT_INFO_UI_SOURCE", this.yJI.dFx() ? 3 : 2);
                C25985d.m41468b(this.yJI.yTx.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent, 213);
                AppMethodBeat.m2505o(30718);
            }
        }

        /* renamed from: a */
        public void mo70188a(Intent intent, C40814ay c40814ay) {
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$a */
    public static class C44319a extends C44316b {
        public C44319a(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo70188a(Intent intent, C40814ay c40814ay) {
            AppMethodBeat.m2504i(30717);
            if (!C5046bo.isNullOrNil(c40814ay.ziw)) {
                intent.putExtra("Contact_BIZ_KF_WORKER_ID", c40814ay.ziw);
            }
            AppMethodBeat.m2505o(30717);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$d */
    public static class C44320d implements OnLongClickListener {
        private C46650a yJI;

        /* renamed from: com.tencent.mm.ui.chatting.s$d$2 */
        class C443172 implements Runnable {
            C443172() {
            }

            public final void run() {
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.s$d$1 */
        class C443211 implements Runnable {
            C443211() {
            }

            public final void run() {
            }
        }

        public C44320d(C46650a c46650a) {
            this.yJI = c46650a;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(30720);
            if (((C15614o) this.yJI.mo74857aF(C15614o.class)).dDX().dkx()) {
                C4990ab.m7420w("changelcai", "ChattingUI isScrolling!!!");
                AppMethodBeat.m2505o(30720);
            } else {
                C40814ay c40814ay = (C40814ay) view.getTag();
                int selectionStart = ((C15614o) this.yJI.mo74857aF(C15614o.class)).dDX().getSelectionStart();
                if (c40814ay.userName.equals(C1853r.m3846Yz()) || c40814ay.userName.equals("notifymessage")) {
                    AppMethodBeat.m2505o(30720);
                } else if (((C15614o) this.yJI.mo74857aF(C15614o.class)).dDX().getIsVoiceInputPanleShow()) {
                    C4990ab.m7416i("MicroMsg.ChattingListAvatarListener", "ChatFooter VoiceInputPanel Show NOW!!!");
                    AppMethodBeat.m2505o(30720);
                } else {
                    C36135d c36135d = (C36135d) this.yJI.mo74857aF(C36135d.class);
                    if (C1855t.m3896kH(this.yJI.getTalkerUserName()) || c36135d.dDn()) {
                        Object arj;
                        C7060h.pYm.mo8381e(10976, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                        C9638aw.m17190ZK();
                        C7577u oa = C18628c.m29087XV().mo14885oa(c40814ay.chatroomName);
                        if (c36135d.dDn()) {
                            arj = ((C7335f) this.yJI.mo74857aF(C7335f.class)).arj(c40814ay.userName);
                        } else {
                            String a = AtSomeoneUI.m36502a(oa, c40814ay.userName);
                            String arj2;
                            if (C5046bo.m7519ac(a)) {
                                arj2 = C1854s.m3864mH(c40814ay.userName);
                            } else {
                                arj2 = a;
                            }
                        }
                        C15614o c15614o = (C15614o) this.yJI.mo74857aF(C15614o.class);
                        StringBuffer stringBuffer = new StringBuffer(c15614o.dDX().getLastText());
                        stringBuffer.insert(selectionStart, "@" + arj2 + 8197);
                        c15614o.dDX().mo63996u(stringBuffer.toString(), (selectionStart + arj2.length()) + 2, true);
                        c15614o.dDX().mo63906ax(c40814ay.chatroomName, c40814ay.userName, arj2 == null ? null : arj2.toString());
                        c15614o.dDX().setMode(1);
                        view.postDelayed(new C443211(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    } else if (C1855t.m3912mY(this.yJI.getTalkerUserName()) && !this.yJI.getTalkerUserName().contains("@")) {
                        CharSequence arj3;
                        C7060h.pYm.mo8381e(10976, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
                        if (!c36135d.dDm() || c36135d.dDn()) {
                            Object arj32 = C1854s.m3864mH(c40814ay.userName);
                        } else {
                            arj32 = ((C7335f) this.yJI.mo74857aF(C7335f.class)).arj(c40814ay.userName);
                        }
                        C15614o c15614o2 = (C15614o) this.yJI.mo74857aF(C15614o.class);
                        StringBuffer stringBuffer2 = new StringBuffer(c15614o2.dDX().getLastText());
                        stringBuffer2.insert(selectionStart, arj32);
                        c15614o2.dDX().mo63996u(stringBuffer2.toString(), arj32.length() + selectionStart, true);
                        c15614o2.dDX().setMode(1);
                        view.postDelayed(new C443172(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                    }
                    AppMethodBeat.m2505o(30720);
                }
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.s$m */
    public static class C44322m extends C23812e {

        /* renamed from: com.tencent.mm.ui.chatting.s$m$2 */
        class C408042 implements DialogInterface.OnClickListener {
            C408042() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(30732);
                C9311cv c9311cv = new C9311cv();
                c9311cv.cvX.enable = false;
                C4879a.xxA.mo10055m(c9311cv);
                AppMethodBeat.m2505o(30732);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.s$m$1 */
        class C443231 implements DialogInterface.OnClickListener {
            C443231() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(30731);
                C9311cv c9311cv = new C9311cv();
                c9311cv.cvX.enable = true;
                C4879a.xxA.mo10055m(c9311cv);
                AppMethodBeat.m2505o(30731);
            }
        }

        public C44322m(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(30733);
            C30379h.m48466d(c46650a.yTx.getContext(), c46650a.yTx.getMMResources().getString(C25738R.string.b9q), "", c46650a.yTx.getMMResources().getString(C25738R.string.b9s), c46650a.yTx.getMMResources().getString(C25738R.string.b9p), new C443231(), new C408042());
            AppMethodBeat.m2505o(30733);
        }
    }
}
