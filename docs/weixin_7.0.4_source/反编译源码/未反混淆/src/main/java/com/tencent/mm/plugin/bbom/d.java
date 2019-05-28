package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.af.o;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.brandservice.a.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.ay;
import com.tencent.mm.ui.chatting.viewitems.d.f;
import com.tencent.mm.ui.e.m;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class d implements a {
    public final void a(View view, long j, String str, String str2, int i) {
        AppMethodBeat.i(18245);
        f fVar = new f();
        fVar.cvx = j;
        fVar.zcZ = i;
        fVar.cHz = str2;
        fVar.imgPath = str;
        view.setTag(fVar);
        AppMethodBeat.o(18245);
    }

    public final long cY(View view) {
        AppMethodBeat.i(18246);
        r.eK(view);
        if (view.getTag() instanceof f) {
            long j = ((f) view.getTag()).cvx;
            AppMethodBeat.o(18246);
            return j;
        }
        AppMethodBeat.o(18246);
        return 0;
    }

    /* JADX WARNING: Missing block: B:15:0x006f, code skipped:
            if (r14.contains(r4.aen()) != false) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(p pVar, q qVar, int i, o oVar, View view, boolean z, int i2, i iVar) {
        CharSequence substring;
        ay ayVar;
        AppMethodBeat.i(18247);
        String mJ = s.mJ(qVar.field_talker);
        String str = pVar.url;
        String str2 = qVar.field_talker;
        if (!TextUtils.isEmpty(str) && str.contains("http://weixin.qq.com/emoticonstore/")) {
            substring = str.substring(str.lastIndexOf("/") + 1);
            ad aoO = ((j) g.K(j.class)).XM().aoO(str2);
            if (com.tencent.mm.n.a.jh(aoO.field_type) && aoO.dsf()) {
                com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(str2);
                if (qX != null) {
                    b cJ = qX.cJ(false);
                    if (cJ != null) {
                        if (!TextUtils.isEmpty(cJ.aen())) {
                        }
                    }
                }
            }
        }
        substring = null;
        if (!TextUtils.isEmpty(substring)) {
            ayVar = new ay(null, false, i, pVar.url, z, mJ, oVar.cMg, oVar.cMh, pVar.title, substring, null, false, false);
            final q qVar2 = qVar;
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(18243);
                    r.a(view, view.getContext(), qVar2.field_talker);
                    AppMethodBeat.o(18243);
                }
            });
        } else if (bo.isNullOrNil(pVar.url)) {
            ayVar = null;
        } else {
            ayVar = new ay(null, false, i, pVar.url, z, mJ, oVar.cMg, oVar.cMh, pVar.title);
            ayVar.cSQ = 56;
            ayVar.ziA = pVar.type;
            String str3 = qVar.field_talker;
            Bundle bundle = new Bundle();
            bundle.putString("share_report_pre_msg_url", pVar.url);
            bundle.putString("share_report_pre_msg_title", pVar.title);
            bundle.putString("share_report_pre_msg_desc", pVar.fjz);
            bundle.putString("share_report_pre_msg_icon_url", l.a(pVar));
            bundle.putString("share_report_pre_msg_appid", "");
            bundle.putInt("share_report_from_scene", 5);
            bundle.putString("share_report_biz_username", str3);
            ayVar.ziy = bundle;
            final i iVar2 = iVar;
            final q qVar3 = qVar;
            final int i3 = i2;
            view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(18244);
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    Context context = view.getContext();
                    ay ayVar = (ay) view.getTag();
                    q qVar = ayVar.ziz;
                    if (qVar == null) {
                        ab.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
                    } else {
                        int i = Downloads.MIN_WAIT_FOR_NETWORK;
                        if (context instanceof Activity) {
                            i = ((Activity) context).getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
                        }
                        ab.i("MicroMsg.ChattingItemHelper", "onWebViewClick = %d", Integer.valueOf(currentTimeMillis));
                        if (!e.a(ayVar.cRS, context, null, qVar.field_talker)) {
                            String str = ayVar.userName;
                            String str2 = ayVar.zit;
                            if (!(str == null || str.equals(""))) {
                                int i2;
                                str = l.c(str, 90, i, currentTimeMillis);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", str);
                                intent.putExtra("shortUrl", str);
                                intent.putExtra("webpageTitle", str2);
                                Bundle bundle = new Bundle();
                                aw.ZK();
                                ad aoO = c.XM().aoO(qVar.field_talker);
                                if (aoO == null || !aoO.dsf()) {
                                    i2 = 0;
                                } else {
                                    i2 = 4;
                                    ab.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", aoO.field_username);
                                }
                                intent.putExtra("msg_id", qVar.field_msgId);
                                intent.putExtra("KPublisherId", "msg_" + Long.toString(qVar.field_msgSvrId));
                                intent.putExtra("pre_username", qVar.field_talker);
                                intent.putExtra("prePublishId", "msg_" + Long.toString(qVar.field_msgSvrId));
                                intent.putExtra("preUsername", qVar.field_talker);
                                intent.putExtra("preChatName", qVar.field_talker);
                                intent.putExtra("preChatTYPE", 7);
                                intent.putExtra("preMsgIndex", ayVar.uno);
                                Bundle bundle2 = ayVar.ziy;
                                if (bundle2 != null) {
                                    intent.putExtras(bundle2);
                                }
                                bundle.putInt("snsWebSource", i2);
                                intent.putExtra("jsapiargs", bundle);
                                intent.putExtra("geta8key_username", qVar.field_talker);
                                if (!ah.isNullOrNil(ayVar.cMg)) {
                                    intent.putExtra("srcUsername", ayVar.cMg);
                                    intent.putExtra("srcDisplayname", ayVar.cMh);
                                    intent.putExtra("mode", 1);
                                }
                                intent.putExtra("message_id", ayVar.unn);
                                intent.putExtra("message_index", ayVar.uno);
                                intent.putExtra("from_scence", 1);
                                intent.putExtra("geta8key_scene", ayVar.cSQ);
                                intent.addFlags(536870912);
                                intent.putExtra("start_activity_time", System.currentTimeMillis());
                                intent.putExtra(m.ygo, ayVar.ziA);
                                if (((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(1) && ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(context, ayVar.userName, ayVar.ziA, 90, i, intent)) {
                                    ab.i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                                } else {
                                    com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                                }
                            }
                        }
                    }
                    if (iVar2 != null) {
                        iVar2.a(qVar3, i3, currentTimeMillis);
                    }
                    AppMethodBeat.o(18244);
                }
            });
        }
        if (ayVar != null) {
            ayVar.unn = qVar.field_msgSvrId;
            ayVar.uno = i2;
            ayVar.ziz = qVar;
            view.setTag(ayVar);
        }
        if (l.mg(pVar.fjC)) {
            r.a(pVar, view, qVar.field_talker);
        }
        if ((i2 < 2 || qVar.field_isExpand) && ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(1)) {
            ab.d("MicroMsg.BizTimeLineServices", "terry trace: preload %s:%s", mJ, pVar.title);
            ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).a(pVar.url, pVar.type, 90, new Object[0]);
        }
        AppMethodBeat.o(18247);
    }

    public final void b(com.tencent.mm.aj.d dVar, Activity activity, ad adVar) {
        AppMethodBeat.i(18248);
        com.tencent.mm.ui.tools.b.a(dVar, activity, adVar, 3);
        AppMethodBeat.o(18248);
    }

    public final void a(int i, Context context, String str, String str2, long j, long j2) {
        AppMethodBeat.i(18249);
        r.a(i, context, str, str2, j, j2);
        AppMethodBeat.o(18249);
    }

    public final void a(long j, int i, Context context, Activity activity, bi biVar) {
        AppMethodBeat.i(18250);
        r.a(j, i, context, null, activity, biVar);
        AppMethodBeat.o(18250);
    }

    public final void a(bi biVar, Context context) {
        AppMethodBeat.i(18252);
        r.a(biVar, context, null);
        AppMethodBeat.o(18252);
    }

    public final void a(bi biVar, Activity activity) {
        AppMethodBeat.i(18251);
        if (!biVar.bAA()) {
            cl clVar = new cl();
            com.tencent.mm.pluginsdk.model.e.d(clVar, biVar);
            clVar.cvA.activity = activity;
            clVar.cvA.cvH = 43;
            com.tencent.mm.sdk.b.a.xxA.m(clVar);
            if (clVar.cvB.ret == 0) {
                com.tencent.mm.modelstat.b.fRa.D(biVar);
            }
        }
        AppMethodBeat.o(18251);
    }
}
