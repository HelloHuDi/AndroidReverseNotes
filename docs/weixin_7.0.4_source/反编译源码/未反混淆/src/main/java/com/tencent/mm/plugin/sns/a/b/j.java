package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class j {

    public enum a {
        PlayIcon(1),
        EnterFullScreen(2),
        EnterCompleteVideo(3),
        DetailInVideo(4),
        LeavelFullScreen(5),
        LeaveCompleteVideo(6),
        SightLoaded(7),
        DetailTimeline(8);
        
        private int value;

        static {
            AppMethodBeat.o(35767);
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
        
        public int value;

        static {
            AppMethodBeat.o(35773);
        }

        private c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum d {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        static {
            AppMethodBeat.o(35776);
        }

        private d(int i) {
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
            AppMethodBeat.o(35770);
        }

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum e {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        static {
            AppMethodBeat.o(35779);
        }

        private e(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(n nVar, boolean z, boolean z2, int i) {
        int i2 = 2;
        AppMethodBeat.i(35780);
        TimeLineObject cqu = nVar.cqu();
        LinkedList linkedList = cqu.xfI.wbK;
        if (!(linkedList == null || linkedList.isEmpty() || ((cqu.xfI.wbJ != 15 || !nVar.DI(32)) && cqu.xfI.wbJ != 18))) {
            int i3;
            linkedList.get(0);
            if (nVar.DI(32) && cqu.xfI.wbJ == 15) {
                com.tencent.mm.plugin.sns.storage.a cqr;
                if (i == 2) {
                    cqr = nVar.cqr();
                } else {
                    cqr = nVar.cqq();
                }
                cqu.xfN.fiM = cqr.qPj;
                cqu.xfN.fiN = cqu.Id;
            }
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            dVar.l("20source_publishid", cqu.xfN.fiN + ",");
            dVar.l("21uxinfo", cqu.xfN.fiM + ",");
            dVar.l("22clienttime", bo.anU() + ",");
            String str = "23souce_type";
            StringBuilder stringBuilder = new StringBuilder();
            if (cqu.xfI.wbJ == 15) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            dVar.l(str, stringBuilder.append(i3).append(",").toString());
            String str2 = "24scene";
            StringBuilder stringBuilder2 = new StringBuilder();
            if (z) {
                i2 = 6;
            } else if (cqu.xfI.wbJ == 15) {
                i2 = 1;
            }
            dVar.l(str2, stringBuilder2.append(i2).append(",").toString());
            dVar.l("25scene_chatname", ",");
            dVar.l("26scene_username", cqu.jBB + ",");
            dVar.l("27curr_publishid", cqu.Id + ",");
            dVar.l("28curr_msgid", ",");
            dVar.l("29curr_favid", "0,");
            String str3 = "30isdownload";
            stringBuilder2 = new StringBuilder();
            if (z2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            dVar.l(str3, stringBuilder2.append(i3).append(",").toString());
            dVar.l("31chatroom_membercount", "0,");
            p.a(cqu.rjC, dVar);
            ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + dVar.Fk());
            h.pYm.e(12989, dVar);
        }
        AppMethodBeat.o(35780);
    }

    public static void a(b bVar, a aVar, n nVar, int i) {
        int i2 = 2;
        AppMethodBeat.i(35781);
        TimeLineObject cqu = nVar.cqu();
        LinkedList linkedList = cqu.xfI.wbK;
        if (!(linkedList == null || linkedList.isEmpty() || ((cqu.xfI.wbJ != 15 || !nVar.DI(32)) && cqu.xfI.wbJ != 18))) {
            linkedList.get(0);
            if (nVar.DI(32) && cqu.xfI.wbJ == 15) {
                com.tencent.mm.plugin.sns.storage.a cqr;
                if (i == 2) {
                    cqr = nVar.cqr();
                } else {
                    cqr = nVar.cqq();
                }
                if (cqr != null) {
                    cqu.xfN.fiM = cqr.qPj;
                }
                cqu.xfN.fiN = cqu.Id;
            }
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            dVar.l("20source_publishid", cqu.xfN.fiN + ",");
            dVar.l("21uxinfo", cqu.xfN.fiM + ",");
            dVar.l("22clienttime", bo.anU() + ",");
            dVar.l("23video_statu", ",");
            String str = "24source_type";
            StringBuilder stringBuilder = new StringBuilder();
            if (cqu.xfI.wbJ == 15) {
                i2 = 1;
            }
            dVar.l(str, stringBuilder.append(i2).append(",").toString());
            dVar.l("25scene", bVar.value + ",");
            dVar.l("26action_type", aVar.value + ",");
            dVar.l("27scene_chatname", ",");
            dVar.l("28scene_username", cqu.jBB + ",");
            dVar.l("29curr_publishid", cqu.Id + ",");
            dVar.l("30curr_msgid", "0,");
            dVar.l("31curr_favid", "0,");
            dVar.l("32elapsed_time", "0,");
            dVar.l("33load_time", "0,");
            dVar.l("34is_load_complete", "0,");
            dVar.l("35destination", "0,");
            dVar.l("36chatroom_membercount", "0,");
            p.a(cqu.rjC, dVar);
            ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.Fk());
            ((com.tencent.mm.plugin.sns.b.c) g.K(com.tencent.mm.plugin.sns.b.c.class)).e(12990, dVar);
        }
        AppMethodBeat.o(35781);
    }

    public static void a(a aVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4) {
        AppMethodBeat.i(35782);
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.l("20source_publishid", str + ",");
        dVar.l("21uxinfo", str2 + ",");
        dVar.l("22clienttime", bo.anU() + ",");
        dVar.l("23video_statu", ",");
        dVar.l("24source_type", i + ",");
        dVar.l("25scene", i2 + ",");
        dVar.l("26action_type", aVar.value + ",");
        dVar.l("27scene_chatname", str4 + ",");
        dVar.l("28scene_username", str3 + ",");
        dVar.l("29curr_publishid", str5 + ",");
        dVar.l("30curr_msgid", j + ",");
        dVar.l("31curr_favid", i3 + ",");
        dVar.l("32elapsed_time", "0,");
        dVar.l("33load_time", "0,");
        dVar.l("34is_load_complete", "0,");
        dVar.l("35destination", "0,");
        dVar.l("36chatroom_membercount", i4 + ",");
        f.a(str5, dVar);
        ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.Fk());
        h.pYm.e(12990, dVar);
        AppMethodBeat.o(35782);
    }

    public static void a(d dVar, c cVar, e eVar, int i, n nVar, int i2) {
        int i3 = 2;
        AppMethodBeat.i(35783);
        TimeLineObject cqu = nVar.cqu();
        LinkedList linkedList = cqu.xfI.wbK;
        if (!(linkedList == null || linkedList.isEmpty() || ((cqu.xfI.wbJ != 15 || !nVar.DI(32)) && cqu.xfI.wbJ != 18))) {
            linkedList.get(0);
            if (nVar.DI(32) && cqu.xfI.wbJ == 15) {
                com.tencent.mm.plugin.sns.storage.a cqr;
                if (i2 == 2) {
                    cqr = nVar.cqr();
                } else {
                    cqr = nVar.cqq();
                }
                if (cqr != null) {
                    cqu.xfN.fiM = nVar.cqq().qPj;
                }
                cqu.xfN.fiN = cqu.Id;
            }
            com.tencent.mm.modelsns.d dVar2 = new com.tencent.mm.modelsns.d();
            dVar2.l("20source_publishid", cqu.xfN.fiN + ",");
            dVar2.l("21uxinfo", cqu.xfN.fiM + ",");
            dVar2.l("22clienttime", bo.anU() + ",");
            dVar2.l("23video_statu", eVar.value + ",");
            String str = "24source_type";
            StringBuilder stringBuilder = new StringBuilder();
            if (cqu.xfI.wbJ == 15) {
                i3 = 1;
            }
            dVar2.l(str, stringBuilder.append(i3).append(",").toString());
            dVar2.l("25scene", dVar.value + ",");
            dVar2.l("26action_type", cVar.value + ",");
            dVar2.l("27scene_chatname", ",");
            dVar2.l("28scene_username", cqu.jBB + ",");
            dVar2.l("29curr_publishid", cqu.Id + ",");
            dVar2.l("30curr_msgid", "0,");
            dVar2.l("31curr_favid", "0,");
            dVar2.l("32chatroom_membercount", "0,");
            dVar2.l("33chatroom_toMemberCount", i + ",");
            p.a(cqu.rjC, dVar2);
            ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar2.Fk());
            h.pYm.e(12991, dVar2);
        }
        AppMethodBeat.o(35783);
    }

    public static void a(c cVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4, int i5) {
        AppMethodBeat.i(35784);
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.l("20source_publishid", str + ",");
        dVar.l("21uxinfo", str2 + ",");
        dVar.l("22clienttime", bo.anU() + ",");
        dVar.l("23video_statu", "3,");
        dVar.l("24source_type", i + ",");
        dVar.l("25scene", i2 + ",");
        dVar.l("26action_type", cVar.value + ",");
        dVar.l("27scene_chatname", str4 + ",");
        dVar.l("28scene_username", str3 + ",");
        dVar.l("29curr_publishid", str5 + ",");
        dVar.l("30curr_msgid", j + ",");
        dVar.l("31curr_favid", i3 + ",");
        dVar.l("32chatroom_membercount", i4 + ",");
        dVar.l("33chatroom_toMemberCount", i5 + ",");
        ab.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar.Fk());
        f.a(str5, dVar);
        h.pYm.e(12991, dVar);
        AppMethodBeat.o(35784);
    }
}
