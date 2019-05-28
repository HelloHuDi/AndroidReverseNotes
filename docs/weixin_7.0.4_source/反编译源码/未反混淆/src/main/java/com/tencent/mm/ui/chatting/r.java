package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.af.k;
import com.tencent.mm.af.l;
import com.tencent.mm.af.o;
import com.tencent.mm.af.p;
import com.tencent.mm.aw.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.g;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.se;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.i;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.ay;
import com.tencent.mm.ui.chatting.viewitems.d.f;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public final class r {
    public static void eK(View view) {
        AppMethodBeat.i(30709);
        if (view.getTag() instanceof f) {
            f fVar = (f) view.getTag();
            long j = fVar.cvx;
            String valueOf;
            String str;
            if (fVar.zcZ == -1) {
                b bVar;
                boolean z;
                int k;
                aw.ZK();
                bi jf = c.XO().jf(fVar.cvx);
                if (Wi(String.valueOf(j))) {
                    h.pYm.X(10231, "1");
                    a.aic();
                    if (jf.field_msgId == j) {
                        bVar = b.fRa;
                        z = false;
                        k = k.k(jf);
                    }
                    AppMethodBeat.o(30709);
                    return;
                }
                j.b me = j.b.me(fVar.cHz);
                if (me != null) {
                    h.pYm.X(10090, "0,1");
                    valueOf = String.valueOf(fVar.cvx);
                    str = fVar.imgPath;
                    aw.ZK();
                    a.b(g.a(me, valueOf, str, c.getAccPath(), fVar.imgPath));
                }
                if (jf.field_msgId == j) {
                    bVar = b.fRa;
                    z = true;
                    k = me != null ? me.type : 0;
                }
                AppMethodBeat.o(30709);
                return;
                bVar.a(jf, z, k);
                AppMethodBeat.o(30709);
                return;
            }
            String str2 = fVar.cvx + "_" + fVar.zcZ;
            aw.ZK();
            bi jf2 = c.XO().jf(fVar.cvx);
            o b = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).b(fVar.cvx, fVar.cHz);
            h hVar;
            Object[] objArr;
            if (Wi(str2)) {
                h.pYm.X(10231, "1");
                a.aic();
                if (jf2.field_msgId == j) {
                    b.fRa.a(jf2, false, k.k(jf2));
                }
                if (!(b == null || b.fjr == null || b.fjr.size() <= fVar.zcZ)) {
                    p pVar = (p) b.fjr.get(fVar.zcZ);
                    hVar = h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(pVar.type == 6 ? 1 : 0);
                    objArr[1] = Integer.valueOf(1);
                    hVar.e(14972, objArr);
                    AppMethodBeat.o(30709);
                    return;
                }
            }
            if (!(b == null || b.fjr == null || b.fjr.size() <= fVar.zcZ)) {
                h.pYm.X(10090, "0,1");
                p pVar2 = (p) b.fjr.get(fVar.zcZ);
                valueOf = fVar.imgPath;
                String str3 = pVar2.title;
                str = pVar2.fjL;
                String str4 = pVar2.url;
                String str5 = pVar2.url;
                String str6 = pVar2.fjK;
                aw.ZK();
                a.b(com.tencent.mm.aw.f.a(0, valueOf, str3, str, str4, str5, str6, str2, c.getAccPath(), fVar.imgPath, "", ""));
                hVar = h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(pVar2.type == 6 ? 1 : 0);
                objArr[1] = Integer.valueOf(0);
                hVar.e(14972, objArr);
            }
            if (jf2.field_msgId == j) {
                b.fRa.a(jf2, true, k.k(jf2));
            }
        }
        AppMethodBeat.o(30709);
    }

    private static boolean Wi(String str) {
        AppMethodBeat.i(30710);
        e aih = a.aih();
        if (aih != null && aih.fJU != null && aih.fJS == 0 && a.aie()) {
            try {
                if (bo.isEqual(aih.fJU, str)) {
                    AppMethodBeat.o(30710);
                    return true;
                }
            } catch (Exception e) {
                AppMethodBeat.o(30710);
                return false;
            }
        }
        AppMethodBeat.o(30710);
        return false;
    }

    public static void a(View view, Context context, String str) {
        AppMethodBeat.i(30711);
        ay ayVar = (ay) view.getTag();
        CharSequence charSequence = ayVar.cwg;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiMgr().Jk(ayVar.dJv);
        }
        if (TextUtils.isEmpty(charSequence)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", str);
            intent.putExtra("rawUrl", ayVar.dJv);
            com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(30711);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", charSequence);
        intent2.putExtra("extra_name", ayVar.title);
        if (ayVar.ziu) {
            intent2.putExtra("download_entrance_scene", 20);
            intent2.putExtra("preceding_scence", 3);
            intent2.putExtra("reward_tip", true);
            h.pYm.e(12953, Integer.valueOf(1), charSequence);
        } else if (ayVar.ziv) {
            intent2.putExtra("download_entrance_scene", 25);
            intent2.putExtra("preceding_scence", 9);
            intent2.putExtra("reward_tip", true);
        } else {
            intent2.putExtra("download_entrance_scene", 22);
            intent2.putExtra("preceding_scence", 122);
            h.pYm.e(10993, Integer.valueOf(2), charSequence);
        }
        com.tencent.mm.bp.d.b(context, "emoji", ".ui.EmojiStoreDetailUI", intent2);
        AppMethodBeat.o(30711);
    }

    public static void a(final p pVar, View view, final String str) {
        AppMethodBeat.i(30712);
        if (view == null || pVar == null) {
            AppMethodBeat.o(30712);
            return;
        }
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(30708);
                ay ayVar = (ay) view.getTag();
                ab.i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", pVar.fjC);
                se seVar = new se();
                seVar.cOf.userName = pVar.fjC;
                seVar.cOf.cOh = pVar.fjD;
                seVar.cOf.cOi = pVar.fjF;
                seVar.cOf.axy = pVar.fjE;
                seVar.cOf.cOl = true;
                seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_HAITANG;
                seVar.cOf.cst = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ayVar.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ayVar.uno;
                com.tencent.mm.sdk.b.a.xxA.m(seVar);
                AppMethodBeat.o(30708);
            }
        });
        AppMethodBeat.o(30712);
    }

    public static void a(int i, Context context, String str, String str2, long j, long j2) {
        AppMethodBeat.i(30713);
        o b = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.biz.a.a.class)).b(j, str);
        if (b == null) {
            ab.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
            AppMethodBeat.o(30713);
            return;
        }
        if (i >= 0 && i < b.fjr.size()) {
            p pVar = (p) b.fjr.get(i);
            String a = j.b.a(l.a(str2, pVar), null, null);
            if (bo.isNullOrNil(a)) {
                AppMethodBeat.o(30713);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("desc", pVar.fjz);
            hashMap.put("type", Integer.valueOf(2));
            hashMap.put("title", pVar.title);
            hashMap.put("app_id", pVar.fjG);
            hashMap.put("pkg_type", Integer.valueOf(pVar.fjF));
            hashMap.put("pkg_version", Integer.valueOf(pVar.fjE));
            hashMap.put("img_url", pVar.fjH);
            hashMap.put("is_dynamic", Boolean.FALSE);
            hashMap.put("cache_key", "");
            hashMap.put("path", pVar.fjD);
            Intent intent = new Intent(context, MsgRetransmitUI.class);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_content", a);
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", i);
            intent.putExtra("Retr_Msg_Id", j);
            intent.putExtra("Retr_MsgFromScene", 3);
            a = v.nW(String.valueOf(j2));
            intent.putExtra("reportSessionId", a);
            v.b y = v.Zp().y(a, true);
            y.j("prePublishId", "msg_".concat(String.valueOf(j2)));
            y.j("preUsername", str2);
            y.j("preChatName", str2);
            y.j("preMsgIndex", Integer.valueOf(i));
            y.j("sendAppMsgScene", Integer.valueOf(1));
            context.startActivity(intent);
        }
        AppMethodBeat.o(30713);
    }

    public static void a(bi biVar, Context context, com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(30715);
        aw.ZK();
        if (c.isSDCardAvailable()) {
            com.tencent.mm.at.e fI;
            com.tencent.mm.at.e eVar = null;
            if (biVar.field_msgId > 0) {
                eVar = com.tencent.mm.at.o.ahl().fJ(biVar.field_msgId);
            }
            if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
                fI = com.tencent.mm.at.o.ahl().fI(biVar.field_msgSvrId);
            } else {
                fI = eVar;
            }
            if (fI == null) {
                AppMethodBeat.o(30715);
                return;
            }
            int i;
            if (biVar.field_isSend == 1) {
                if (fI.agQ()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else if (fI.agQ()) {
                if (com.tencent.mm.vfs.e.ct(com.tencent.mm.at.o.ahl().q(com.tencent.mm.at.f.a(fI).fDz, "", ""))) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (biVar.dtH()) {
                ab.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
                com.tencent.mm.ui.base.h.a(context, context.getString(R.string.cdf), context.getString(R.string.tz), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(30715);
                return;
            } else if (i.e(biVar, com.tencent.mm.at.o.ahl().q(com.tencent.mm.at.f.c(fI), "", ""))) {
                ab.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
                Intent intent = new Intent(context, ImageGalleryUI.class);
                intent.putExtra("img_gallery_msg_id", biVar.field_msgId);
                intent.putExtra("img_gallery_msg_svr_id", biVar.field_msgSvrId);
                intent.putExtra("img_gallery_talker", biVar.field_talker);
                intent.putExtra("img_gallery_chatroom_name", biVar.field_talker);
                intent.putExtra("img_gallery_is_restransmit_after_download", true);
                intent.putExtra("Retr_show_success_tips", true);
                if (aVar != null) {
                    i.a(aVar, biVar, intent);
                } else {
                    a(biVar, intent);
                }
                context.startActivity(intent);
                AppMethodBeat.o(30715);
                return;
            } else if (fI.offset < fI.frO || fI.frO == 0) {
                Intent intent2 = new Intent(context, MsgRetransmitUI.class);
                intent2.putExtra("Retr_File_Name", com.tencent.mm.at.o.ahl().I(biVar.field_imgPath, true));
                intent2.putExtra("Retr_Msg_Id", biVar.field_msgId);
                intent2.putExtra("Retr_Msg_Type", 0);
                intent2.putExtra("Retr_show_success_tips", true);
                intent2.putExtra("Retr_Compress_Type", i);
                context.startActivity(intent2);
                AppMethodBeat.o(30715);
                return;
            } else {
                Intent intent3 = new Intent(context, MsgRetransmitUI.class);
                intent3.putExtra("Retr_File_Name", com.tencent.mm.at.o.ahl().q(com.tencent.mm.at.f.c(fI), "", ""));
                intent3.putExtra("Retr_Msg_Id", biVar.field_msgId);
                intent3.putExtra("Retr_Msg_Type", 0);
                intent3.putExtra("Retr_show_success_tips", true);
                intent3.putExtra("Retr_Compress_Type", i);
                context.startActivity(intent3);
                AppMethodBeat.o(30715);
                return;
            }
        }
        t.hO(context);
        AppMethodBeat.o(30715);
    }

    private static void a(bi biVar, Intent intent) {
        AppMethodBeat.i(30716);
        if (biVar == null) {
            AppMethodBeat.o(30716);
            return;
        }
        String str = biVar.field_talker;
        String str2 = biVar.field_talker;
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", com.tencent.mm.model.t.mZ(str) ? 7 : 1);
        bundle.putString("stat_msg_id", "msg_" + Long.toString(biVar.field_msgSvrId));
        bundle.putString("stat_chat_talker_username", str);
        bundle.putString("stat_send_msg_user", str2);
        intent.putExtra("_stat_obj", bundle);
        AppMethodBeat.o(30716);
    }

    public static void a(long j, int i, Context context, Fragment fragment, Activity activity, bi biVar) {
        AppMethodBeat.i(30714);
        String str = biVar.field_talker;
        String nW = v.nW(biVar.field_msgSvrId);
        v.b y = v.Zp().y(nW, true);
        y.j("prePublishId", "msg_" + biVar.field_msgSvrId);
        y.j("preUsername", str);
        y.j("preChatName", str);
        y.j("preMsgIndex", Integer.valueOf(i));
        y.j("sendAppMsgScene", Integer.valueOf(1));
        cl clVar = new cl();
        clVar.cvA.cvE = i;
        clVar.cvA.cvF = nW;
        clVar.cvA.fragment = fragment;
        clVar.cvA.activity = activity;
        clVar.cvA.cvH = 40;
        com.tencent.mm.pluginsdk.model.e.d(clVar, biVar);
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        if (clVar.cvB.ret == 0) {
            j.b me = j.b.me(l.a(context, i, biVar.field_content, biVar.field_talker, biVar.field_msgId));
            if (biVar.bAA()) {
                b.fRa.b(biVar, me != null ? me.type : 0);
            } else {
                b.fRa.D(biVar);
            }
            if (!(me == null || me.type != 5 || me.url == null)) {
                ab.d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(j), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                str = "";
                try {
                    str = URLEncoder.encode(me.url, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.ChattingItemHelper", e, "", new Object[0]);
                }
                h.pYm.e(13378, str, Long.valueOf(j), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
            }
        }
        AppMethodBeat.o(30714);
    }
}
