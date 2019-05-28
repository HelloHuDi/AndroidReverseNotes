package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.aau;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.a.m */
public final class C39038m {

    /* renamed from: com.tencent.mm.plugin.fav.a.m$b */
    public enum C20676b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        static {
            AppMethodBeat.m2505o(102690);
        }

        private C20676b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.a.m$d */
    public enum C20677d {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        static {
            AppMethodBeat.m2505o(102696);
        }

        private C20677d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.a.m$a */
    public enum C27971a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7);
        
        private int value;

        static {
            AppMethodBeat.m2505o(102687);
        }

        private C27971a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.a.m$c */
    public enum C27972c {
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value;

        static {
            AppMethodBeat.m2505o(102693);
        }

        private C27972c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: w */
    public static void m66423w(C27966g c27966g) {
        AppMethodBeat.m2504i(102697);
        if (c27966g.field_favProto.wiv == null || c27966g.field_favProto.wiv.isEmpty()) {
            AppMethodBeat.m2505o(102697);
            return;
        }
        aar aar = (aar) c27966g.field_favProto.wiv.getFirst();
        aau aau = aar.wgZ;
        if (aau == null) {
            AppMethodBeat.m2505o(102697);
            return;
        }
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("20source_publishid", aau.fiN + ",");
        c32831d.mo53400l("21uxinfo", aau.fiM + ",");
        c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
        c32831d.mo53400l("23source_type", (c27966g.field_type == 16 ? 1 : 2) + ",");
        c32831d.mo53400l("24scene", "5,");
        c32831d.mo53400l("25scene_chatname", ",");
        c32831d.mo53400l("26scene_username", c27966g.field_fromUser + ",");
        c32831d.mo53400l("27curr_publishid", ",");
        c32831d.mo53400l("28curr_msgid", "0,");
        c32831d.mo53400l("29curr_favid", c27966g.field_id + ",");
        c32831d.mo53400l("30isdownload", "0,");
        c32831d.mo53400l("31chatroom_membercount", "0,");
        ((C46210i) C1720g.m3528K(C46210i.class)).mo55532b(aar.cMn, c32831d);
        C4990ab.m7416i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + c32831d.mo53398Fk());
        C7060h.pYm.mo8381e(12989, c32831d);
        AppMethodBeat.m2505o(102697);
    }

    /* renamed from: a */
    public static void m66421a(C27971a c27971a, C27966g c27966g) {
        AppMethodBeat.m2504i(102698);
        if (c27966g.field_favProto.wiv == null || c27966g.field_favProto.wiv.isEmpty()) {
            AppMethodBeat.m2505o(102698);
            return;
        }
        aau aau = ((aar) c27966g.field_favProto.wiv.getFirst()).wgZ;
        if (aau == null) {
            AppMethodBeat.m2505o(102698);
            return;
        }
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("20source_publishid", aau.fiN + ",");
        c32831d.mo53400l("21uxinfo", aau.fiM + ",");
        c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
        c32831d.mo53400l("23video_statu", ",");
        c32831d.mo53400l("24source_type", (c27966g.field_type == 16 ? 1 : 2) + ",");
        c32831d.mo53400l("25scene", "5,");
        c32831d.mo53400l("26action_type", c27971a.value + ",");
        c32831d.mo53400l("27scene_chatname", ",");
        c32831d.mo53400l("28scene_username", c27966g.field_fromUser + ",");
        c32831d.mo53400l("29curr_publishid", ",");
        c32831d.mo53400l("30curr_msgid", "0,");
        c32831d.mo53400l("31curr_favid", c27966g.field_id + ",");
        c32831d.mo53400l("32elapsed_time", "0,");
        c32831d.mo53400l("33load_time", "0,");
        c32831d.mo53400l("34is_load_complete", "0,");
        c32831d.mo53400l("35destination", "0,");
        c32831d.mo53400l("36chatroom_membercount", "0,");
        C4990ab.m7416i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + c32831d.mo53398Fk());
        ((C13356c) C1720g.m3528K(C13356c.class)).mo25462e(12990, c32831d);
        AppMethodBeat.m2505o(102698);
    }

    /* renamed from: a */
    public static void m66422a(C27972c c27972c, C27966g c27966g, C20677d c20677d, int i) {
        AppMethodBeat.m2504i(102699);
        if (c27966g.field_favProto.wiv == null || c27966g.field_favProto.wiv.isEmpty()) {
            AppMethodBeat.m2505o(102699);
            return;
        }
        aau aau = ((aar) c27966g.field_favProto.wiv.getFirst()).wgZ;
        if (aau == null) {
            AppMethodBeat.m2505o(102699);
            return;
        }
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("20source_publishid", aau.fiN + ",");
        c32831d.mo53400l("21uxinfo", aau.fiM + ",");
        c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
        c32831d.mo53400l("23video_statu", c20677d.value + ",");
        c32831d.mo53400l("24source_type", (c27966g.field_type == 16 ? 1 : 2) + ",");
        c32831d.mo53400l("25scene", "5,");
        c32831d.mo53400l("26action_type", c27972c.value + ",");
        c32831d.mo53400l("27scene_chatname", ",");
        c32831d.mo53400l("28scene_username", c27966g.field_fromUser + ",");
        c32831d.mo53400l("29curr_publishid", ",");
        c32831d.mo53400l("30curr_msgid", "0,");
        c32831d.mo53400l("31curr_favid", c27966g.field_id + ",");
        c32831d.mo53400l("32chatroom_membercount", "0,");
        c32831d.mo53400l("33chatroom_toMemberCount", i + ",");
        C4990ab.m7416i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + c32831d.mo53398Fk());
        C7060h.pYm.mo8381e(12991, c32831d);
        AppMethodBeat.m2505o(102699);
    }
}
