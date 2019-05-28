package com.tencent.p177mm.plugin.sns.p514a.p515b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelstat.C26485p;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.a.b.j */
public final class C34927j {

    /* renamed from: com.tencent.mm.plugin.sns.a.b.j$a */
    public enum C13354a {
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
            AppMethodBeat.m2505o(35767);
        }

        private C13354a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.a.b.j$c */
    public enum C34928c {
        Fav(1),
        Chat(2),
        Chatroom(3),
        Sns(4);
        
        public int value;

        static {
            AppMethodBeat.m2505o(35773);
        }

        private C34928c(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.a.b.j$d */
    public enum C34929d {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        static {
            AppMethodBeat.m2505o(35776);
        }

        private C34929d(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.a.b.j$b */
    public enum C34930b {
        Sight(1),
        AdUrl(2),
        Chat(3),
        TalkChat(4),
        Fav(5);
        
        public int value;

        static {
            AppMethodBeat.m2505o(35770);
        }

        private C34930b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.a.b.j$e */
    public enum C34931e {
        Samll(1),
        Full(2),
        Complete(3);
        
        private int value;

        static {
            AppMethodBeat.m2505o(35779);
        }

        private C34931e(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    /* renamed from: a */
    public static void m57344a(C46236n c46236n, boolean z, boolean z2, int i) {
        int i2 = 2;
        AppMethodBeat.m2504i(35780);
        TimeLineObject cqu = c46236n.cqu();
        LinkedList linkedList = cqu.xfI.wbK;
        if (!(linkedList == null || linkedList.isEmpty() || ((cqu.xfI.wbJ != 15 || !c46236n.mo74253DI(32)) && cqu.xfI.wbJ != 18))) {
            int i3;
            linkedList.get(0);
            if (c46236n.mo74253DI(32) && cqu.xfI.wbJ == 15) {
                C21980a cqr;
                if (i == 2) {
                    cqr = c46236n.cqr();
                } else {
                    cqr = c46236n.cqq();
                }
                cqu.xfN.fiM = cqr.qPj;
                cqu.xfN.fiN = cqu.f15074Id;
            }
            C32831d c32831d = new C32831d();
            c32831d.mo53400l("20source_publishid", cqu.xfN.fiN + ",");
            c32831d.mo53400l("21uxinfo", cqu.xfN.fiM + ",");
            c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
            String str = "23souce_type";
            StringBuilder stringBuilder = new StringBuilder();
            if (cqu.xfI.wbJ == 15) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            c32831d.mo53400l(str, stringBuilder.append(i3).append(",").toString());
            String str2 = "24scene";
            StringBuilder stringBuilder2 = new StringBuilder();
            if (z) {
                i2 = 6;
            } else if (cqu.xfI.wbJ == 15) {
                i2 = 1;
            }
            c32831d.mo53400l(str2, stringBuilder2.append(i2).append(",").toString());
            c32831d.mo53400l("25scene_chatname", ",");
            c32831d.mo53400l("26scene_username", cqu.jBB + ",");
            c32831d.mo53400l("27curr_publishid", cqu.f15074Id + ",");
            c32831d.mo53400l("28curr_msgid", ",");
            c32831d.mo53400l("29curr_favid", "0,");
            String str3 = "30isdownload";
            stringBuilder2 = new StringBuilder();
            if (z2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            c32831d.mo53400l(str3, stringBuilder2.append(i3).append(",").toString());
            c32831d.mo53400l("31chatroom_membercount", "0,");
            C26485p.m42202a(cqu.rjC, c32831d);
            C4990ab.m7416i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + c32831d.mo53398Fk());
            C7060h.pYm.mo8381e(12989, c32831d);
        }
        AppMethodBeat.m2505o(35780);
    }

    /* renamed from: a */
    public static void m57341a(C34930b c34930b, C13354a c13354a, C46236n c46236n, int i) {
        int i2 = 2;
        AppMethodBeat.m2504i(35781);
        TimeLineObject cqu = c46236n.cqu();
        LinkedList linkedList = cqu.xfI.wbK;
        if (!(linkedList == null || linkedList.isEmpty() || ((cqu.xfI.wbJ != 15 || !c46236n.mo74253DI(32)) && cqu.xfI.wbJ != 18))) {
            linkedList.get(0);
            if (c46236n.mo74253DI(32) && cqu.xfI.wbJ == 15) {
                C21980a cqr;
                if (i == 2) {
                    cqr = c46236n.cqr();
                } else {
                    cqr = c46236n.cqq();
                }
                if (cqr != null) {
                    cqu.xfN.fiM = cqr.qPj;
                }
                cqu.xfN.fiN = cqu.f15074Id;
            }
            C32831d c32831d = new C32831d();
            c32831d.mo53400l("20source_publishid", cqu.xfN.fiN + ",");
            c32831d.mo53400l("21uxinfo", cqu.xfN.fiM + ",");
            c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
            c32831d.mo53400l("23video_statu", ",");
            String str = "24source_type";
            StringBuilder stringBuilder = new StringBuilder();
            if (cqu.xfI.wbJ == 15) {
                i2 = 1;
            }
            c32831d.mo53400l(str, stringBuilder.append(i2).append(",").toString());
            c32831d.mo53400l("25scene", c34930b.value + ",");
            c32831d.mo53400l("26action_type", c13354a.value + ",");
            c32831d.mo53400l("27scene_chatname", ",");
            c32831d.mo53400l("28scene_username", cqu.jBB + ",");
            c32831d.mo53400l("29curr_publishid", cqu.f15074Id + ",");
            c32831d.mo53400l("30curr_msgid", "0,");
            c32831d.mo53400l("31curr_favid", "0,");
            c32831d.mo53400l("32elapsed_time", "0,");
            c32831d.mo53400l("33load_time", "0,");
            c32831d.mo53400l("34is_load_complete", "0,");
            c32831d.mo53400l("35destination", "0,");
            c32831d.mo53400l("36chatroom_membercount", "0,");
            C26485p.m42202a(cqu.rjC, c32831d);
            C4990ab.m7416i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + c32831d.mo53398Fk());
            ((C13356c) C1720g.m3528K(C13356c.class)).mo25462e(12990, c32831d);
        }
        AppMethodBeat.m2505o(35781);
    }

    /* renamed from: a */
    public static void m57340a(C13354a c13354a, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4) {
        AppMethodBeat.m2504i(35782);
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("20source_publishid", str + ",");
        c32831d.mo53400l("21uxinfo", str2 + ",");
        c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
        c32831d.mo53400l("23video_statu", ",");
        c32831d.mo53400l("24source_type", i + ",");
        c32831d.mo53400l("25scene", i2 + ",");
        c32831d.mo53400l("26action_type", c13354a.value + ",");
        c32831d.mo53400l("27scene_chatname", str4 + ",");
        c32831d.mo53400l("28scene_username", str3 + ",");
        c32831d.mo53400l("29curr_publishid", str5 + ",");
        c32831d.mo53400l("30curr_msgid", j + ",");
        c32831d.mo53400l("31curr_favid", i3 + ",");
        c32831d.mo53400l("32elapsed_time", "0,");
        c32831d.mo53400l("33load_time", "0,");
        c32831d.mo53400l("34is_load_complete", "0,");
        c32831d.mo53400l("35destination", "0,");
        c32831d.mo53400l("36chatroom_membercount", i4 + ",");
        C13341f.m21441a(str5, c32831d);
        C4990ab.m7416i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + c32831d.mo53398Fk());
        C7060h.pYm.mo8381e(12990, c32831d);
        AppMethodBeat.m2505o(35782);
    }

    /* renamed from: a */
    public static void m57343a(C34929d c34929d, C34928c c34928c, C34931e c34931e, int i, C46236n c46236n, int i2) {
        int i3 = 2;
        AppMethodBeat.m2504i(35783);
        TimeLineObject cqu = c46236n.cqu();
        LinkedList linkedList = cqu.xfI.wbK;
        if (!(linkedList == null || linkedList.isEmpty() || ((cqu.xfI.wbJ != 15 || !c46236n.mo74253DI(32)) && cqu.xfI.wbJ != 18))) {
            linkedList.get(0);
            if (c46236n.mo74253DI(32) && cqu.xfI.wbJ == 15) {
                C21980a cqr;
                if (i2 == 2) {
                    cqr = c46236n.cqr();
                } else {
                    cqr = c46236n.cqq();
                }
                if (cqr != null) {
                    cqu.xfN.fiM = c46236n.cqq().qPj;
                }
                cqu.xfN.fiN = cqu.f15074Id;
            }
            C32831d c32831d = new C32831d();
            c32831d.mo53400l("20source_publishid", cqu.xfN.fiN + ",");
            c32831d.mo53400l("21uxinfo", cqu.xfN.fiM + ",");
            c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
            c32831d.mo53400l("23video_statu", c34931e.value + ",");
            String str = "24source_type";
            StringBuilder stringBuilder = new StringBuilder();
            if (cqu.xfI.wbJ == 15) {
                i3 = 1;
            }
            c32831d.mo53400l(str, stringBuilder.append(i3).append(",").toString());
            c32831d.mo53400l("25scene", c34929d.value + ",");
            c32831d.mo53400l("26action_type", c34928c.value + ",");
            c32831d.mo53400l("27scene_chatname", ",");
            c32831d.mo53400l("28scene_username", cqu.jBB + ",");
            c32831d.mo53400l("29curr_publishid", cqu.f15074Id + ",");
            c32831d.mo53400l("30curr_msgid", "0,");
            c32831d.mo53400l("31curr_favid", "0,");
            c32831d.mo53400l("32chatroom_membercount", "0,");
            c32831d.mo53400l("33chatroom_toMemberCount", i + ",");
            C26485p.m42202a(cqu.rjC, c32831d);
            C4990ab.m7416i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + c32831d.mo53398Fk());
            C7060h.pYm.mo8381e(12991, c32831d);
        }
        AppMethodBeat.m2505o(35783);
    }

    /* renamed from: a */
    public static void m57342a(C34928c c34928c, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(35784);
        C32831d c32831d = new C32831d();
        c32831d.mo53400l("20source_publishid", str + ",");
        c32831d.mo53400l("21uxinfo", str2 + ",");
        c32831d.mo53400l("22clienttime", C5046bo.anU() + ",");
        c32831d.mo53400l("23video_statu", "3,");
        c32831d.mo53400l("24source_type", i + ",");
        c32831d.mo53400l("25scene", i2 + ",");
        c32831d.mo53400l("26action_type", c34928c.value + ",");
        c32831d.mo53400l("27scene_chatname", str4 + ",");
        c32831d.mo53400l("28scene_username", str3 + ",");
        c32831d.mo53400l("29curr_publishid", str5 + ",");
        c32831d.mo53400l("30curr_msgid", j + ",");
        c32831d.mo53400l("31curr_favid", i3 + ",");
        c32831d.mo53400l("32chatroom_membercount", i4 + ",");
        c32831d.mo53400l("33chatroom_toMemberCount", i5 + ",");
        C4990ab.m7416i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + c32831d.mo53398Fk());
        C13341f.m21441a(str5, c32831d);
        C7060h.pYm.mo8381e(12991, c32831d);
        AppMethodBeat.m2505o(35784);
    }
}
