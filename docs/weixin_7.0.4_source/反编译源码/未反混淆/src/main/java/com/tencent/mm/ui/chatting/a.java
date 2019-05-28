package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class a {

    public enum d {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        static {
            AppMethodBeat.o(30259);
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
            AppMethodBeat.o(30250);
        }

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum c {
        Fav(1),
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        private int value;

        static {
            AppMethodBeat.o(30256);
        }

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        static {
            AppMethodBeat.o(30253);
        }

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(a aVar, bi biVar) {
        AppMethodBeat.i(30260);
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(biVar, pString, pString2)) {
            a(aVar, biVar, pString.value, pString2.value);
        }
        AppMethodBeat.o(30260);
    }

    public static void a(c cVar, d dVar, bi biVar, int i) {
        AppMethodBeat.i(30262);
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(biVar, pString, pString2)) {
            int mA;
            String str = pString.value;
            String str2 = pString2.value;
            String str3 = biVar.field_talker;
            boolean mN = t.mN(str3);
            String Yz = biVar.field_isSend == 1 ? r.Yz() : mN ? bf.oy(biVar.field_content) : str3;
            com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
            dVar2.l("20source_publishid", str + ",");
            dVar2.l("21uxinfo", str2 + ",");
            dVar2.l("22clienttime", bo.anU() + ",");
            dVar2.l("23video_statu", dVar.value + ",");
            dVar2.l("24source_type", (biVar.getType() == 62 ? 1 : 2) + ",");
            dVar2.l("25scene", (mN ? 4 : 3) + ",");
            dVar2.l("26action_type", cVar.value + ",");
            dVar2.l("27scene_chatname", str3 + ",");
            dVar2.l("28scene_username", Yz + ",");
            dVar2.l("29curr_publishid", ",");
            dVar2.l("30curr_msgid", biVar.field_msgSvrId + ",");
            dVar2.l("31curr_favid", "0,");
            str = "32chatroom_membercount";
            StringBuilder stringBuilder = new StringBuilder();
            if (mN) {
                mA = n.mA(str3);
            } else {
                mA = 0;
            }
            dVar2.l(str, stringBuilder.append(mA).append(",").toString());
            dVar2.l("33chatroom_toMemberCount", i + ",");
            ab.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + dVar2.Fk());
            h.pYm.e(12991, dVar2);
        }
        AppMethodBeat.o(30262);
    }

    public static boolean a(bi biVar, PString pString, PString pString2) {
        AppMethodBeat.i(30263);
        if (biVar.getType() == 62) {
            s ut = u.ut(biVar.field_imgPath);
            if (ut == null) {
                AppMethodBeat.o(30263);
                return false;
            }
            cfh cfh = ut.fXm;
            if (cfh == null || bo.isNullOrNil(cfh.fiM)) {
                AppMethodBeat.o(30263);
                return false;
            }
            pString.value = cfh.fiN;
            pString2.value = cfh.fiM;
            AppMethodBeat.o(30263);
            return true;
        } else if (biVar.getType() == 49) {
            boolean kH = t.kH(biVar.field_talker);
            String str = biVar.field_content;
            if (kH && biVar.field_content != null && biVar.field_isSend == 0) {
                str = bf.oz(biVar.field_content);
            }
            com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(str);
            if (me == null || me.type != 4 || bo.isNullOrNil(me.fiG)) {
                AppMethodBeat.o(30263);
                return false;
            }
            pString.value = me.fiN;
            pString2.value = me.fiM;
            AppMethodBeat.o(30263);
            return true;
        } else {
            AppMethodBeat.o(30263);
            return false;
        }
    }

    public static void a(a aVar, bi biVar, String str, String str2) {
        AppMethodBeat.i(30261);
        String str3 = biVar.field_talker;
        boolean mN = t.mN(str3);
        String Yz = biVar.field_isSend == 1 ? r.Yz() : mN ? bf.oy(biVar.field_content) : str3;
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.l("20source_publishid", str + ",");
        dVar.l("21uxinfo", str2 + ",");
        dVar.l("22clienttime", bo.anU() + ",");
        dVar.l("23video_statu", ",");
        dVar.l("24source_type", (biVar.getType() == 62 ? 1 : 2) + ",");
        dVar.l("25scene", (mN ? 4 : 3) + ",");
        dVar.l("26action_type", aVar.value + ",");
        dVar.l("27scene_chatname", str3 + ",");
        dVar.l("28scene_username", Yz + ",");
        dVar.l("29curr_publishid", ",");
        dVar.l("30curr_msgid", biVar.field_msgSvrId + ",");
        dVar.l("31curr_favid", "0,");
        dVar.l("32elapsed_time", "0,");
        dVar.l("33load_time", "0,");
        dVar.l("34is_load_complete", "0,");
        dVar.l("35destination", "0,");
        dVar.l("36chatroom_membercount", (mN ? n.mA(str3) : 0) + ",");
        ab.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + dVar.Fk());
        ((com.tencent.mm.plugin.sns.b.c) g.K(com.tencent.mm.plugin.sns.b.c.class)).e(12990, dVar);
        AppMethodBeat.o(30261);
    }
}
