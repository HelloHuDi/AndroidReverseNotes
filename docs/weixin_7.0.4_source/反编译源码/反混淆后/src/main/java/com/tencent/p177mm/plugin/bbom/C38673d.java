package com.tencent.p177mm.plugin.bbom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p612ui.chatting.C15636e;
import com.tencent.p177mm.p612ui.chatting.C44315r;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40814ay;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5394d.C5404f;
import com.tencent.p177mm.p612ui.tools.C40889b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20022a;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C11244i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.plugin.bbom.d */
public final class C38673d implements C20022a {
    /* renamed from: a */
    public final void mo35261a(View view, long j, String str, String str2, int i) {
        AppMethodBeat.m2504i(18245);
        C5404f c5404f = new C5404f();
        c5404f.cvx = j;
        c5404f.zcZ = i;
        c5404f.cHz = str2;
        c5404f.imgPath = str;
        view.setTag(c5404f);
        AppMethodBeat.m2505o(18245);
    }

    /* renamed from: cY */
    public final long mo35266cY(View view) {
        AppMethodBeat.m2504i(18246);
        C44315r.m80106eK(view);
        if (view.getTag() instanceof C5404f) {
            long j = ((C5404f) view.getTag()).cvx;
            AppMethodBeat.m2505o(18246);
            return j;
        }
        AppMethodBeat.m2505o(18246);
        return 0;
    }

    /* JADX WARNING: Missing block: B:15:0x006f, code skipped:
            if (r14.contains(r4.aen()) != false) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo35262a(C32224p c32224p, C46627q c46627q, int i, C32223o c32223o, View view, boolean z, int i2, C11244i c11244i) {
        CharSequence substring;
        C40814ay c40814ay;
        AppMethodBeat.m2504i(18247);
        String mJ = C1854s.m3866mJ(c46627q.field_talker);
        String str = c32224p.url;
        String str2 = c46627q.field_talker;
        if (!TextUtils.isEmpty(str) && str.contains("http://weixin.qq.com/emoticonstore/")) {
            substring = str.substring(str.lastIndexOf("/") + 1);
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2);
            if (C7486a.m12942jh(aoO.field_type) && aoO.dsf()) {
                C16527d qX = C17903f.m28104qX(str2);
                if (qX != null) {
                    C16529b cJ = qX.mo30481cJ(false);
                    if (cJ != null) {
                        if (!TextUtils.isEmpty(cJ.aen())) {
                        }
                    }
                }
            }
        }
        substring = null;
        if (!TextUtils.isEmpty(substring)) {
            c40814ay = new C40814ay(null, false, i, c32224p.url, z, mJ, c32223o.cMg, c32223o.cMh, c32224p.title, substring, null, false, false);
            final C46627q c46627q2 = c46627q;
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(18243);
                    C44315r.m80102a(view, view.getContext(), c46627q2.field_talker);
                    AppMethodBeat.m2505o(18243);
                }
            });
        } else if (C5046bo.isNullOrNil(c32224p.url)) {
            c40814ay = null;
        } else {
            c40814ay = new C40814ay(null, false, i, c32224p.url, z, mJ, c32223o.cMg, c32223o.cMh, c32224p.title);
            c40814ay.cSQ = 56;
            c40814ay.ziA = c32224p.type;
            String str3 = c46627q.field_talker;
            Bundle bundle = new Bundle();
            bundle.putString("share_report_pre_msg_url", c32224p.url);
            bundle.putString("share_report_pre_msg_title", c32224p.title);
            bundle.putString("share_report_pre_msg_desc", c32224p.fjz);
            bundle.putString("share_report_pre_msg_icon_url", C1192l.m2619a(c32224p));
            bundle.putString("share_report_pre_msg_appid", "");
            bundle.putInt("share_report_from_scene", 5);
            bundle.putString("share_report_biz_username", str3);
            c40814ay.ziy = bundle;
            final C11244i c11244i2 = c11244i;
            final C46627q c46627q3 = c46627q;
            final int i3 = i2;
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(18244);
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    Context context = view.getContext();
                    C40814ay c40814ay = (C40814ay) view.getTag();
                    C46627q c46627q = c40814ay.ziz;
                    if (c46627q == null) {
                        C4990ab.m7412e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
                    } else {
                        int i = Downloads.MIN_WAIT_FOR_NETWORK;
                        if (context instanceof Activity) {
                            i = ((Activity) context).getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
                        }
                        C4990ab.m7417i("MicroMsg.ChattingItemHelper", "onWebViewClick = %d", Integer.valueOf(currentTimeMillis));
                        if (!C15636e.m23923a(c40814ay.cRS, context, null, c46627q.field_talker)) {
                            String str = c40814ay.userName;
                            String str2 = c40814ay.zit;
                            if (!(str == null || str.equals(""))) {
                                int i2;
                                str = C1192l.m2621c(str, 90, i, currentTimeMillis);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str);
                                intent.putExtra("shortUrl", str);
                                intent.putExtra("webpageTitle", str2);
                                Bundle bundle = new Bundle();
                                C9638aw.m17190ZK();
                                C7616ad aoO = C18628c.m29078XM().aoO(c46627q.field_talker);
                                if (aoO == null || !aoO.dsf()) {
                                    i2 = 0;
                                } else {
                                    i2 = 4;
                                    C4990ab.m7411d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", aoO.field_username);
                                }
                                intent.putExtra("msg_id", c46627q.field_msgId);
                                intent.putExtra("KPublisherId", "msg_" + Long.toString(c46627q.field_msgSvrId));
                                intent.putExtra("pre_username", c46627q.field_talker);
                                intent.putExtra("prePublishId", "msg_" + Long.toString(c46627q.field_msgSvrId));
                                intent.putExtra("preUsername", c46627q.field_talker);
                                intent.putExtra("preChatName", c46627q.field_talker);
                                intent.putExtra("preChatTYPE", 7);
                                intent.putExtra("preMsgIndex", c40814ay.uno);
                                Bundle bundle2 = c40814ay.ziy;
                                if (bundle2 != null) {
                                    intent.putExtras(bundle2);
                                }
                                bundle.putInt("snsWebSource", i2);
                                intent.putExtra("jsapiargs", bundle);
                                intent.putExtra("geta8key_username", c46627q.field_talker);
                                if (!C42252ah.isNullOrNil(c40814ay.cMg)) {
                                    intent.putExtra("srcUsername", c40814ay.cMg);
                                    intent.putExtra("srcDisplayname", c40814ay.cMh);
                                    intent.putExtra("mode", 1);
                                }
                                intent.putExtra("message_id", c40814ay.unn);
                                intent.putExtra("message_index", c40814ay.uno);
                                intent.putExtra("from_scence", 1);
                                intent.putExtra("geta8key_scene", c40814ay.cSQ);
                                intent.addFlags(536870912);
                                intent.putExtra("start_activity_time", System.currentTimeMillis());
                                intent.putExtra(C5506m.ygo, c40814ay.ziA);
                                if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(1) && ((C20023b) C1720g.m3528K(C20023b.class)).mo6750a(context, c40814ay.userName, c40814ay.ziA, 90, i, intent)) {
                                    C4990ab.m7416i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                                } else {
                                    C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
                                }
                            }
                        }
                    }
                    if (c11244i2 != null) {
                        c11244i2.mo22942a(c46627q3, i3, currentTimeMillis);
                    }
                    AppMethodBeat.m2505o(18244);
                }
            });
        }
        if (c40814ay != null) {
            c40814ay.unn = c46627q.field_msgSvrId;
            c40814ay.uno = i2;
            c40814ay.ziz = c46627q;
            view.setTag(c40814ay);
        }
        if (C1192l.m2624mg(c32224p.fjC)) {
            C44315r.m80103a(c32224p, view, c46627q.field_talker);
        }
        if ((i2 < 2 || c46627q.field_isExpand) && ((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(1)) {
            C4990ab.m7411d("MicroMsg.BizTimeLineServices", "terry trace: preload %s:%s", mJ, c32224p.title);
            ((C20023b) C1720g.m3528K(C20023b.class)).mo6749a(c32224p.url, c32224p.type, 90, new Object[0]);
        }
        AppMethodBeat.m2505o(18247);
    }

    /* renamed from: b */
    public final void mo35265b(C16527d c16527d, Activity activity, C7616ad c7616ad) {
        AppMethodBeat.m2504i(18248);
        C40889b.m70857a(c16527d, activity, c7616ad, 3);
        AppMethodBeat.m2505o(18248);
    }

    /* renamed from: a */
    public final void mo35259a(int i, Context context, String str, String str2, long j, long j2) {
        AppMethodBeat.m2504i(18249);
        C44315r.m80100a(i, context, str, str2, j, j2);
        AppMethodBeat.m2505o(18249);
    }

    /* renamed from: a */
    public final void mo35260a(long j, int i, Context context, Activity activity, C7620bi c7620bi) {
        AppMethodBeat.m2504i(18250);
        C44315r.m80101a(j, i, context, null, activity, c7620bi);
        AppMethodBeat.m2505o(18250);
    }

    /* renamed from: a */
    public final void mo35264a(C7620bi c7620bi, Context context) {
        AppMethodBeat.m2504i(18252);
        C44315r.m80104a(c7620bi, context, null);
        AppMethodBeat.m2505o(18252);
    }

    /* renamed from: a */
    public final void mo35263a(C7620bi c7620bi, Activity activity) {
        AppMethodBeat.m2504i(18251);
        if (!c7620bi.bAA()) {
            C45316cl c45316cl = new C45316cl();
            C40443e.m69377d(c45316cl, c7620bi);
            c45316cl.cvA.activity = activity;
            c45316cl.cvA.cvH = 43;
            C4879a.xxA.mo10055m(c45316cl);
            if (c45316cl.cvB.ret == 0) {
                C45457b.fRa.mo73248D(c7620bi);
            }
        }
        AppMethodBeat.m2505o(18251);
    }
}
