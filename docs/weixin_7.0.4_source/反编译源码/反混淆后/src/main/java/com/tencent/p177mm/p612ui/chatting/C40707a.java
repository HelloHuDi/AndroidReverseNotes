package com.tencent.p177mm.p612ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.pointers.PString;
import com.tencent.p177mm.protocal.protobuf.cfh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.chatting.a */
public final class C40707a {

    /* renamed from: com.tencent.mm.ui.chatting.a$d */
    public enum C23688d {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        static {
            AppMethodBeat.m2505o(30259);
        }

        private C23688d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a$a */
    public enum C40705a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7);
        
        private int value;

        static {
            AppMethodBeat.m2505o(30250);
        }

        private C40705a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a$c */
    public enum C40706c {
        Fav(1),
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value;

        static {
            AppMethodBeat.m2505o(30256);
        }

        private C40706c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.a$b */
    public enum C40708b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        static {
            AppMethodBeat.m2505o(30253);
        }

        private C40708b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: a */
    public static void m70378a(C40705a c40705a, C7620bi c7620bi) {
        AppMethodBeat.m2504i(30260);
        PString pString = new PString();
        PString pString2 = new PString();
        if (C40707a.m70381a(c7620bi, pString, pString2)) {
            C40707a.m70379a(c40705a, c7620bi, pString.value, pString2.value);
        }
        AppMethodBeat.m2505o(30260);
    }

    /* renamed from: a */
    public static void m70380a(C40706c c40706c, C23688d c23688d, C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(30262);
        PString pString = new PString();
        PString pString2 = new PString();
        if (C40707a.m70381a(c7620bi, pString, pString2)) {
            int mA;
            String str = pString.value;
            String str2 = pString2.value;
            String str3 = c7620bi.field_talker;
            boolean mN = C1855t.m3901mN(str3);
            String Yz = c7620bi.field_isSend == 1 ? C1853r.m3846Yz() : mN ? C1829bf.m3762oy(c7620bi.field_content) : str3;
            C32831d c32831d = new C32831d();
            c32831d.mo53400l("20source_publishid", str + ",");
            c32831d.mo53400l("21uxinfo", str2 + ",");
            c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
            c32831d.mo53400l("23video_statu", c23688d.value + ",");
            c32831d.mo53400l("24source_type", (c7620bi.getType() == 62 ? 1 : 2) + ",");
            c32831d.mo53400l("25scene", (mN ? 4 : 3) + ",");
            c32831d.mo53400l("26action_type", c40706c.value + ",");
            c32831d.mo53400l("27scene_chatname", str3 + ",");
            c32831d.mo53400l("28scene_username", Yz + ",");
            c32831d.mo53400l("29curr_publishid", ",");
            c32831d.mo53400l("30curr_msgid", c7620bi.field_msgSvrId + ",");
            c32831d.mo53400l("31curr_favid", "0,");
            str = "32chatroom_membercount";
            StringBuilder stringBuilder = new StringBuilder();
            if (mN) {
                mA = C37921n.m64060mA(str3);
            } else {
                mA = 0;
            }
            c32831d.mo53400l(str, stringBuilder.append(mA).append(",").toString());
            c32831d.mo53400l("33chatroom_toMemberCount", i + ",");
            C4990ab.m7416i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + c32831d.mo53398Fk());
            C7060h.pYm.mo8381e(12991, c32831d);
        }
        AppMethodBeat.m2505o(30262);
    }

    /* renamed from: a */
    public static boolean m70381a(C7620bi c7620bi, PString pString, PString pString2) {
        AppMethodBeat.m2504i(30263);
        if (c7620bi.getType() == 62) {
            C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
            if (ut == null) {
                AppMethodBeat.m2505o(30263);
                return false;
            }
            cfh cfh = ut.fXm;
            if (cfh == null || C5046bo.isNullOrNil(cfh.fiM)) {
                AppMethodBeat.m2505o(30263);
                return false;
            }
            pString.value = cfh.fiN;
            pString2.value = cfh.fiM;
            AppMethodBeat.m2505o(30263);
            return true;
        } else if (c7620bi.getType() == 49) {
            boolean kH = C1855t.m3896kH(c7620bi.field_talker);
            String str = c7620bi.field_content;
            if (kH && c7620bi.field_content != null && c7620bi.field_isSend == 0) {
                str = C1829bf.m3763oz(c7620bi.field_content);
            }
            C8910b me = C8910b.m16064me(str);
            if (me == null || me.type != 4 || C5046bo.isNullOrNil(me.fiG)) {
                AppMethodBeat.m2505o(30263);
                return false;
            }
            pString.value = me.fiN;
            pString2.value = me.fiM;
            AppMethodBeat.m2505o(30263);
            return true;
        } else {
            AppMethodBeat.m2505o(30263);
            return false;
        }
    }

    /* renamed from: a */
    public static void m70379a(C40705a c40705a, C7620bi c7620bi, String str, String str2) {
        AppMethodBeat.m2504i(30261);
        String str3 = c7620bi.field_talker;
        boolean mN = C1855t.m3901mN(str3);
        String Yz = c7620bi.field_isSend == 1 ? C1853r.m3846Yz() : mN ? C1829bf.m3762oy(c7620bi.field_content) : str3;
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("20source_publishid", str + ",");
        c32831d.mo53400l("21uxinfo", str2 + ",");
        c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
        c32831d.mo53400l("23video_statu", ",");
        c32831d.mo53400l("24source_type", (c7620bi.getType() == 62 ? 1 : 2) + ",");
        c32831d.mo53400l("25scene", (mN ? 4 : 3) + ",");
        c32831d.mo53400l("26action_type", c40705a.value + ",");
        c32831d.mo53400l("27scene_chatname", str3 + ",");
        c32831d.mo53400l("28scene_username", Yz + ",");
        c32831d.mo53400l("29curr_publishid", ",");
        c32831d.mo53400l("30curr_msgid", c7620bi.field_msgSvrId + ",");
        c32831d.mo53400l("31curr_favid", "0,");
        c32831d.mo53400l("32elapsed_time", "0,");
        c32831d.mo53400l("33load_time", "0,");
        c32831d.mo53400l("34is_load_complete", "0,");
        c32831d.mo53400l("35destination", "0,");
        c32831d.mo53400l("36chatroom_membercount", (mN ? C37921n.m64060mA(str3) : 0) + ",");
        C4990ab.m7416i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + c32831d.mo53398Fk());
        ((C13356c) C1720g.m3528K(C13356c.class)).mo25462e(12990, c32831d);
        AppMethodBeat.m2505o(30261);
    }
}
