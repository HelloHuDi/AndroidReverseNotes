package com.tencent.p177mm.p612ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32223o;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p198aw.C25848g;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p198aw.C9059f;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.C40729i;
import com.tencent.p177mm.p612ui.chatting.viewitems.C40814ay;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5394d.C5404f;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.chatting.r */
public final class C44315r {

    /* renamed from: com.tencent.mm.ui.chatting.r$2 */
    static class C443142 implements OnClickListener {
        C443142() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: eK */
    public static void m80106eK(View view) {
        AppMethodBeat.m2504i(30709);
        if (view.getTag() instanceof C5404f) {
            C5404f c5404f = (C5404f) view.getTag();
            long j = c5404f.cvx;
            String valueOf;
            String str;
            if (c5404f.zcZ == -1) {
                C45457b c45457b;
                boolean z;
                int k;
                C9638aw.m17190ZK();
                C7620bi jf = C18628c.m29080XO().mo15340jf(c5404f.cvx);
                if (C44315r.m80099Wi(String.valueOf(j))) {
                    C7060h.pYm.mo8374X(10231, "1");
                    C37494a.aic();
                    if (jf.field_msgId == j) {
                        c45457b = C45457b.fRa;
                        z = false;
                        k = C1191k.m2615k(jf);
                    }
                    AppMethodBeat.m2505o(30709);
                    return;
                }
                C8910b me = C8910b.m16064me(c5404f.cHz);
                if (me != null) {
                    C7060h.pYm.mo8374X(10090, "0,1");
                    valueOf = String.valueOf(c5404f.cvx);
                    str = c5404f.imgPath;
                    C9638aw.m17190ZK();
                    C37494a.m63280b(C25848g.m41158a(me, valueOf, str, C18628c.getAccPath(), c5404f.imgPath));
                }
                if (jf.field_msgId == j) {
                    c45457b = C45457b.fRa;
                    z = true;
                    k = me != null ? me.type : 0;
                }
                AppMethodBeat.m2505o(30709);
                return;
                c45457b.mo73259a(jf, z, k);
                AppMethodBeat.m2505o(30709);
                return;
            }
            String str2 = c5404f.cvx + "_" + c5404f.zcZ;
            C9638aw.m17190ZK();
            C7620bi jf2 = C18628c.m29080XO().mo15340jf(c5404f.cvx);
            C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(c5404f.cvx, c5404f.cHz);
            C7060h c7060h;
            Object[] objArr;
            if (C44315r.m80099Wi(str2)) {
                C7060h.pYm.mo8374X(10231, "1");
                C37494a.aic();
                if (jf2.field_msgId == j) {
                    C45457b.fRa.mo73259a(jf2, false, C1191k.m2615k(jf2));
                }
                if (!(b == null || b.fjr == null || b.fjr.size() <= c5404f.zcZ)) {
                    C32224p c32224p = (C32224p) b.fjr.get(c5404f.zcZ);
                    c7060h = C7060h.pYm;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(c32224p.type == 6 ? 1 : 0);
                    objArr[1] = Integer.valueOf(1);
                    c7060h.mo8381e(14972, objArr);
                    AppMethodBeat.m2505o(30709);
                    return;
                }
            }
            if (!(b == null || b.fjr == null || b.fjr.size() <= c5404f.zcZ)) {
                C7060h.pYm.mo8374X(10090, "0,1");
                C32224p c32224p2 = (C32224p) b.fjr.get(c5404f.zcZ);
                valueOf = c5404f.imgPath;
                String str3 = c32224p2.title;
                str = c32224p2.fjL;
                String str4 = c32224p2.url;
                String str5 = c32224p2.url;
                String str6 = c32224p2.fjK;
                C9638aw.m17190ZK();
                C37494a.m63280b(C9059f.m16431a(0, valueOf, str3, str, str4, str5, str6, str2, C18628c.getAccPath(), c5404f.imgPath, "", ""));
                c7060h = C7060h.pYm;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(c32224p2.type == 6 ? 1 : 0);
                objArr[1] = Integer.valueOf(0);
                c7060h.mo8381e(14972, objArr);
            }
            if (jf2.field_msgId == j) {
                C45457b.fRa.mo73259a(jf2, true, C1191k.m2615k(jf2));
            }
        }
        AppMethodBeat.m2505o(30709);
    }

    /* renamed from: Wi */
    private static boolean m80099Wi(String str) {
        AppMethodBeat.m2504i(30710);
        C9058e aih = C37494a.aih();
        if (aih != null && aih.fJU != null && aih.fJS == 0 && C37494a.aie()) {
            try {
                if (C5046bo.isEqual(aih.fJU, str)) {
                    AppMethodBeat.m2505o(30710);
                    return true;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(30710);
                return false;
            }
        }
        AppMethodBeat.m2505o(30710);
        return false;
    }

    /* renamed from: a */
    public static void m80102a(View view, Context context, String str) {
        AppMethodBeat.m2504i(30711);
        C40814ay c40814ay = (C40814ay) view.getTag();
        CharSequence charSequence = c40814ay.cwg;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35603Jk(c40814ay.dJv);
        }
        if (TextUtils.isEmpty(charSequence)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", str);
            intent.putExtra("rawUrl", c40814ay.dJv);
            C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(30711);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", charSequence);
        intent2.putExtra("extra_name", c40814ay.title);
        if (c40814ay.ziu) {
            intent2.putExtra("download_entrance_scene", 20);
            intent2.putExtra("preceding_scence", 3);
            intent2.putExtra("reward_tip", true);
            C7060h.pYm.mo8381e(12953, Integer.valueOf(1), charSequence);
        } else if (c40814ay.ziv) {
            intent2.putExtra("download_entrance_scene", 25);
            intent2.putExtra("preceding_scence", 9);
            intent2.putExtra("reward_tip", true);
        } else {
            intent2.putExtra("download_entrance_scene", 22);
            intent2.putExtra("preceding_scence", 122);
            C7060h.pYm.mo8381e(10993, Integer.valueOf(2), charSequence);
        }
        C25985d.m41467b(context, "emoji", ".ui.EmojiStoreDetailUI", intent2);
        AppMethodBeat.m2505o(30711);
    }

    /* renamed from: a */
    public static void m80103a(final C32224p c32224p, View view, final String str) {
        AppMethodBeat.m2504i(30712);
        if (view == null || c32224p == null) {
            AppMethodBeat.m2505o(30712);
            return;
        }
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(30708);
                C40814ay c40814ay = (C40814ay) view.getTag();
                C4990ab.m7417i("MicroMsg.ChattingItemHelper", "on app brand(%s) button1 click", c32224p.fjC);
                C32628se c32628se = new C32628se();
                c32628se.cOf.userName = c32224p.fjC;
                c32628se.cOf.cOh = c32224p.fjD;
                c32628se.cOf.cOi = c32224p.fjF;
                c32628se.cOf.axy = c32224p.fjE;
                c32628se.cOf.cOl = true;
                c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_HAITANG;
                c32628se.cOf.cst = str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c40814ay.cKd.field_msgSvrId + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + c40814ay.uno;
                C4879a.xxA.mo10055m(c32628se);
                AppMethodBeat.m2505o(30708);
            }
        });
        AppMethodBeat.m2505o(30712);
    }

    /* renamed from: a */
    public static void m80100a(int i, Context context, String str, String str2, long j, long j2) {
        AppMethodBeat.m2504i(30713);
        C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(j, str);
        if (b == null) {
            C4990ab.m7420w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
            AppMethodBeat.m2505o(30713);
            return;
        }
        if (i >= 0 && i < b.fjr.size()) {
            C32224p c32224p = (C32224p) b.fjr.get(i);
            String a = C8910b.m16061a(C44312l.m80095a(str2, c32224p), null, null);
            if (C5046bo.isNullOrNil(a)) {
                AppMethodBeat.m2505o(30713);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("desc", c32224p.fjz);
            hashMap.put("type", Integer.valueOf(2));
            hashMap.put("title", c32224p.title);
            hashMap.put("app_id", c32224p.fjG);
            hashMap.put("pkg_type", Integer.valueOf(c32224p.fjF));
            hashMap.put("pkg_version", Integer.valueOf(c32224p.fjE));
            hashMap.put("img_url", c32224p.fjH);
            hashMap.put("is_dynamic", Boolean.FALSE);
            hashMap.put("cache_key", "");
            hashMap.put("path", c32224p.fjD);
            Intent intent = new Intent(context, MsgRetransmitUI.class);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_content", a);
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", i);
            intent.putExtra("Retr_Msg_Id", j);
            intent.putExtra("Retr_MsgFromScene", 3);
            a = C37922v.m64078nW(String.valueOf(j2));
            intent.putExtra("reportSessionId", a);
            C32800b y = C37922v.m64076Zp().mo60676y(a, true);
            y.mo53356j("prePublishId", "msg_".concat(String.valueOf(j2)));
            y.mo53356j("preUsername", str2);
            y.mo53356j("preChatName", str2);
            y.mo53356j("preMsgIndex", Integer.valueOf(i));
            y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(30713);
    }

    /* renamed from: a */
    public static void m80104a(C7620bi c7620bi, Context context, C46650a c46650a) {
        AppMethodBeat.m2504i(30715);
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            C25822e fI;
            C25822e c25822e = null;
            if (c7620bi.field_msgId > 0) {
                c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
            }
            if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
            } else {
                fI = c25822e;
            }
            if (fI == null) {
                AppMethodBeat.m2505o(30715);
                return;
            }
            int i;
            if (c7620bi.field_isSend == 1) {
                if (fI.agQ()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else if (fI.agQ()) {
                if (C5730e.m8628ct(C32291o.ahl().mo73118q(C37478f.m63225a(fI).fDz, "", ""))) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
                i = 0;
            }
            if (c7620bi.dtH()) {
                C4990ab.m7416i("MicroMsg.ChattingItemHelper", "image is clean!!!");
                C30379h.m48438a(context, context.getString(C25738R.string.cdf), context.getString(C25738R.string.f9238tz), new C443142());
                AppMethodBeat.m2505o(30715);
                return;
            } else if (C40729i.m70428e(c7620bi, C32291o.ahl().mo73118q(C37478f.m63227c(fI), "", ""))) {
                C4990ab.m7416i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
                Intent intent = new Intent(context, ImageGalleryUI.class);
                intent.putExtra("img_gallery_msg_id", c7620bi.field_msgId);
                intent.putExtra("img_gallery_msg_svr_id", c7620bi.field_msgSvrId);
                intent.putExtra("img_gallery_talker", c7620bi.field_talker);
                intent.putExtra("img_gallery_chatroom_name", c7620bi.field_talker);
                intent.putExtra("img_gallery_is_restransmit_after_download", true);
                intent.putExtra("Retr_show_success_tips", true);
                if (c46650a != null) {
                    C40729i.m70425a(c46650a, c7620bi, intent);
                } else {
                    C44315r.m80105a(c7620bi, intent);
                }
                context.startActivity(intent);
                AppMethodBeat.m2505o(30715);
                return;
            } else if (fI.offset < fI.frO || fI.frO == 0) {
                Intent intent2 = new Intent(context, MsgRetransmitUI.class);
                intent2.putExtra("Retr_File_Name", C32291o.ahl().mo73074I(c7620bi.field_imgPath, true));
                intent2.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                intent2.putExtra("Retr_Msg_Type", 0);
                intent2.putExtra("Retr_show_success_tips", true);
                intent2.putExtra("Retr_Compress_Type", i);
                context.startActivity(intent2);
                AppMethodBeat.m2505o(30715);
                return;
            } else {
                Intent intent3 = new Intent(context, MsgRetransmitUI.class);
                intent3.putExtra("Retr_File_Name", C32291o.ahl().mo73118q(C37478f.m63227c(fI), "", ""));
                intent3.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
                intent3.putExtra("Retr_Msg_Type", 0);
                intent3.putExtra("Retr_show_success_tips", true);
                intent3.putExtra("Retr_Compress_Type", i);
                context.startActivity(intent3);
                AppMethodBeat.m2505o(30715);
                return;
            }
        }
        C23639t.m36492hO(context);
        AppMethodBeat.m2505o(30715);
    }

    /* renamed from: a */
    private static void m80105a(C7620bi c7620bi, Intent intent) {
        AppMethodBeat.m2504i(30716);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(30716);
            return;
        }
        String str = c7620bi.field_talker;
        String str2 = c7620bi.field_talker;
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", C1855t.m3913mZ(str) ? 7 : 1);
        bundle.putString("stat_msg_id", "msg_" + Long.toString(c7620bi.field_msgSvrId));
        bundle.putString("stat_chat_talker_username", str);
        bundle.putString("stat_send_msg_user", str2);
        intent.putExtra("_stat_obj", bundle);
        AppMethodBeat.m2505o(30716);
    }

    /* renamed from: a */
    public static void m80101a(long j, int i, Context context, Fragment fragment, Activity activity, C7620bi c7620bi) {
        AppMethodBeat.m2504i(30714);
        String str = c7620bi.field_talker;
        String nW = C37922v.m64078nW(c7620bi.field_msgSvrId);
        C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
        y.mo53356j("prePublishId", "msg_" + c7620bi.field_msgSvrId);
        y.mo53356j("preUsername", str);
        y.mo53356j("preChatName", str);
        y.mo53356j("preMsgIndex", Integer.valueOf(i));
        y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
        C45316cl c45316cl = new C45316cl();
        c45316cl.cvA.cvE = i;
        c45316cl.cvA.cvF = nW;
        c45316cl.cvA.fragment = fragment;
        c45316cl.cvA.activity = activity;
        c45316cl.cvA.cvH = 40;
        C40443e.m69377d(c45316cl, c7620bi);
        C4879a.xxA.mo10055m(c45316cl);
        if (c45316cl.cvB.ret == 0) {
            C8910b me = C8910b.m16064me(C1192l.m2618a(context, i, c7620bi.field_content, c7620bi.field_talker, c7620bi.field_msgId));
            if (c7620bi.bAA()) {
                C45457b.fRa.mo73261b(c7620bi, me != null ? me.type : 0);
            } else {
                C45457b.fRa.mo73248D(c7620bi);
            }
            if (!(me == null || me.type != 5 || me.url == null)) {
                C4990ab.m7411d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), me.url, Long.valueOf(j), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                str = "";
                try {
                    str = URLEncoder.encode(me.url, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ChattingItemHelper", e, "", new Object[0]);
                }
                C7060h.pYm.mo8381e(13378, str, Long.valueOf(j), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
            }
        }
        AppMethodBeat.m2505o(30714);
    }
}
