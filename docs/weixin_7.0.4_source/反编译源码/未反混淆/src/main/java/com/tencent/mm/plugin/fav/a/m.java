package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m {

    public enum b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        static {
            AppMethodBeat.o(102690);
        }

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum d {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        static {
            AppMethodBeat.o(102696);
        }

        private d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7);
        
        private int value;

        static {
            AppMethodBeat.o(102687);
        }

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum c {
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value;

        static {
            AppMethodBeat.o(102693);
        }

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void w(g gVar) {
        AppMethodBeat.i(102697);
        if (gVar.field_favProto.wiv == null || gVar.field_favProto.wiv.isEmpty()) {
            AppMethodBeat.o(102697);
            return;
        }
        aar aar = (aar) gVar.field_favProto.wiv.getFirst();
        aau aau = aar.wgZ;
        if (aau == null) {
            AppMethodBeat.o(102697);
            return;
        }
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.l("20source_publishid", aau.fiN + ",");
        dVar.l("21uxinfo", aau.fiM + ",");
        dVar.l("22clienttime", bo.anU() + ",");
        dVar.l("23source_type", (gVar.field_type == 16 ? 1 : 2) + ",");
        dVar.l("24scene", "5,");
        dVar.l("25scene_chatname", ",");
        dVar.l("26scene_username", gVar.field_fromUser + ",");
        dVar.l("27curr_publishid", ",");
        dVar.l("28curr_msgid", "0,");
        dVar.l("29curr_favid", gVar.field_id + ",");
        dVar.l("30isdownload", "0,");
        dVar.l("31chatroom_membercount", "0,");
        ((i) g.K(i.class)).b(aar.cMn, dVar);
        ab.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + dVar.Fk());
        h.pYm.e(12989, dVar);
        AppMethodBeat.o(102697);
    }

    public static void a(a aVar, g gVar) {
        AppMethodBeat.i(102698);
        if (gVar.field_favProto.wiv == null || gVar.field_favProto.wiv.isEmpty()) {
            AppMethodBeat.o(102698);
            return;
        }
        aau aau = ((aar) gVar.field_favProto.wiv.getFirst()).wgZ;
        if (aau == null) {
            AppMethodBeat.o(102698);
            return;
        }
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.l("20source_publishid", aau.fiN + ",");
        dVar.l("21uxinfo", aau.fiM + ",");
        dVar.l("22clienttime", bo.anU() + ",");
        dVar.l("23video_statu", ",");
        dVar.l("24source_type", (gVar.field_type == 16 ? 1 : 2) + ",");
        dVar.l("25scene", "5,");
        dVar.l("26action_type", aVar.value + ",");
        dVar.l("27scene_chatname", ",");
        dVar.l("28scene_username", gVar.field_fromUser + ",");
        dVar.l("29curr_publishid", ",");
        dVar.l("30curr_msgid", "0,");
        dVar.l("31curr_favid", gVar.field_id + ",");
        dVar.l("32elapsed_time", "0,");
        dVar.l("33load_time", "0,");
        dVar.l("34is_load_complete", "0,");
        dVar.l("35destination", "0,");
        dVar.l("36chatroom_membercount", "0,");
        ab.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + dVar.Fk());
        ((com.tencent.mm.plugin.sns.b.c) g.K(com.tencent.mm.plugin.sns.b.c.class)).e(12990, dVar);
        AppMethodBeat.o(102698);
    }

    public static void a(c cVar, g gVar, d dVar, int i) {
        AppMethodBeat.i(102699);
        if (gVar.field_favProto.wiv == null || gVar.field_favProto.wiv.isEmpty()) {
            AppMethodBeat.o(102699);
            return;
        }
        aau aau = ((aar) gVar.field_favProto.wiv.getFirst()).wgZ;
        if (aau == null) {
            AppMethodBeat.o(102699);
            return;
        }
        com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
        dVar2.l("20source_publishid", aau.fiN + ",");
        dVar2.l("21uxinfo", aau.fiM + ",");
        dVar2.l("22clienttime", bo.anU() + ",");
        dVar2.l("23video_statu", dVar.value + ",");
        dVar2.l("24source_type", (gVar.field_type == 16 ? 1 : 2) + ",");
        dVar2.l("25scene", "5,");
        dVar2.l("26action_type", cVar.value + ",");
        dVar2.l("27scene_chatname", ",");
        dVar2.l("28scene_username", gVar.field_fromUser + ",");
        dVar2.l("29curr_publishid", ",");
        dVar2.l("30curr_msgid", "0,");
        dVar2.l("31curr_favid", gVar.field_id + ",");
        dVar2.l("32chatroom_membercount", "0,");
        dVar2.l("33chatroom_toMemberCount", i + ",");
        ab.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + dVar2.Fk());
        h.pYm.e(12991, dVar2);
        AppMethodBeat.o(102699);
    }
}
