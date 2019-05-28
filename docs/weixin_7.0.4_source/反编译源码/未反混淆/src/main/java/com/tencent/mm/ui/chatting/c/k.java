package com.tencent.mm.ui.chatting.c;

import android.database.Cursor;
import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.booter.x;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.b.a.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.c.b.s;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.HashSet;

@a(dFp = j.class)
public class k extends a implements j {
    private static String yPc = "100134";
    private long jEg = 0;
    private HashSet<Long> yOW = new HashSet();
    private int yOX;
    private HashSet<Long> yOY = new HashSet();
    private HashSet<Long> yOZ = new HashSet();
    private boolean yOx = false;
    private int yPa = 0;
    private boolean yPb = false;
    private c yPd = new c() {
        public final void bOi() {
            AppMethodBeat.i(31348);
            v vVar = new v();
            vVar.eQ(k.this.cgL.yTA);
            vVar.eR(k.this.cgL.getTalkerUserName());
            vVar.cXW = 1;
            vVar.cXX = 1;
            vVar.cYb = 1;
            vVar.ajK();
            AppMethodBeat.o(31348);
        }
    };
    private long yPe = 0;
    private boolean yPf = false;
    private String yPg = null;
    private long yPh = 0;
    private int yPi = 0;

    public k() {
        AppMethodBeat.i(31351);
        AppMethodBeat.o(31351);
    }

    public final void bf(final bi biVar) {
        AppMethodBeat.i(31353);
        if (this.yOY.contains(Long.valueOf(biVar.field_msgSvrId))) {
            AppMethodBeat.o(31353);
            return;
        }
        this.yOY.add(Long.valueOf(biVar.field_msgSvrId));
        d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31345);
                com.tencent.mm.modelstat.a.a(biVar, com.tencent.mm.modelstat.a.a.Expose);
                AppMethodBeat.o(31345);
            }
        }, "ChattingUI.expExposeReport");
        AppMethodBeat.o(31353);
    }

    public final void Oz(int i) {
        this.yOX = i;
    }

    private void dDQ() {
        AppMethodBeat.i(31355);
        x.ecN.jL(this.cgL.getTalkerUserName());
        b.fRa.IF();
        av avVar = new av();
        avVar.ctX.ctY = false;
        com.tencent.mm.sdk.b.a.xxA.m(avVar);
        ((e) g.K(e.class)).b("tmpl_type_succeed_contact", this.yPd);
        AppMethodBeat.o(31355);
    }

    private void dDR() {
        int i = 0;
        AppMethodBeat.i(31356);
        if (this.yPf) {
            long currentTimeMillis = System.currentTimeMillis() - this.yPe;
            this.yPe = 0;
            this.yPf = false;
            h hVar = h.pYm;
            long[] jArr = new long[]{0, 200, 400, 600, 800, 1000, 1500, FaceGestureDetGLThread.BRIGHTNESS_DURATION};
            while (i < 8) {
                if (currentTimeMillis < jArr[i]) {
                    break;
                } else if (i == 7) {
                    i = 8;
                    break;
                } else {
                    i++;
                }
            }
            i = -1;
            hVar.a(109, (long) i, 1, true);
        }
        AppMethodBeat.o(31356);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(31357);
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            com.tencent.mm.cf.d.dvV().ev(ChattingUI.class.getName() + ".Listview", 4);
        }
        AppMethodBeat.o(31357);
    }

    public final void dxx() {
        AppMethodBeat.i(31358);
        if (bo.isNullOrNil(this.cgL.getTalkerUserName())) {
            h.pYm.a(110, 0, 1, true);
        }
        AppMethodBeat.o(31358);
    }

    public final void dxz() {
    }

    public final void dxA() {
        AppMethodBeat.i(31360);
        if (!this.yOx) {
            IF();
        }
        this.yOx = false;
        AppMethodBeat.o(31360);
    }

    private void IF() {
        AppMethodBeat.i(31361);
        this.yPg = null;
        if (!r.Yz().equals(this.cgL.getTalkerUserName()) && this.cgL.dFw()) {
            this.yPg = this.cgL.getTalkerUserName();
            this.jEg = (bf.aaa() / 1000) * 1000;
            this.yPi = 0;
            final String str = this.yPg;
            aw.RS().aa(new Runnable() {
                public final void run() {
                    boolean z = false;
                    AppMethodBeat.i(31349);
                    if (!bo.isNullOrNil(str)) {
                        k.this.yPi = u.ac(str, t.fkP);
                        ab.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", str, Integer.valueOf(k.this.yPi), bo.mw(k.this.jEg), Long.valueOf(k.this.jEg));
                        if (k.this.cgL.dFw() && k.this.cgL.sRl.dua == 0) {
                            z = true;
                        }
                        ((com.tencent.mm.plugin.expt.roomexpt.d) g.K(com.tencent.mm.plugin.expt.roomexpt.d.class)).aE(str, z);
                    }
                    AppMethodBeat.o(31349);
                }
            });
        }
        dDR();
        AppMethodBeat.o(31361);
    }

    public final void dxB() {
        AppMethodBeat.i(31362);
        if (!TextUtils.isEmpty(this.yPg) && this.cgL.dFw()) {
            this.yPh = bf.aaa();
            final String str = this.yPg;
            this.yPg = "";
            final int dEC = ((s) this.cgL.aF(s.class)).dEC();
            if (dEC == 2) {
                ((s) this.cgL.aF(s.class)).dEB();
            }
            int i = 0;
            if (this.cgL.dFw() && this.cgL.sRl.dua == 0) {
                i = 1;
            }
            aw.RS().aa(new Runnable() {
                public final void run() {
                    boolean z = false;
                    AppMethodBeat.i(31350);
                    if (!bo.isNullOrNil(str)) {
                        int i;
                        int i2;
                        int mA = n.mA(str);
                        aw.ZK();
                        Cursor w = com.tencent.mm.model.c.XO().w(str, k.this.jEg, k.this.yPh);
                        if (w == null || !w.moveToFirst()) {
                            i = 0;
                            i2 = 0;
                        } else {
                            bi biVar = new bi();
                            i = 0;
                            int i3 = 0;
                            do {
                                biVar.d(w);
                                if (biVar.field_isSend == 1) {
                                    i3++;
                                } else {
                                    i++;
                                }
                            } while (w.moveToNext());
                            i2 = i3;
                        }
                        if (w != null) {
                            w.close();
                        }
                        ab.d("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg MuteRoomKvStat, muteRoomName:%s, stayTime:%d, memberNum:%d, newMsg:%d, sendMsgNum:%d, unreadMsgNum:%d, backToHistoryState:%d, isMute:%d  ,session:%s", str, Long.valueOf(k.this.yPh - k.this.jEg), Integer.valueOf(mA), Integer.valueOf(k.this.yPi + i), Integer.valueOf(i2), Integer.valueOf(k.this.yPi), Integer.valueOf(dEC), Integer.valueOf(i), k.this.cgL.dFt());
                        h.pYm.e(12077, str, Long.valueOf(k.this.yPh - k.this.jEg), Integer.valueOf(mA), Integer.valueOf(i + k.this.yPi), Integer.valueOf(i2), Integer.valueOf(k.this.yPi), Integer.valueOf(dEC), Integer.valueOf(i), k.this.cgL.dFt(), Integer.valueOf(k.this.yOX));
                        String mJ = com.tencent.mm.model.s.mJ(str);
                        com.tencent.mm.plugin.expt.roomexpt.d dVar = (com.tencent.mm.plugin.expt.roomexpt.d) g.K(com.tencent.mm.plugin.expt.roomexpt.d.class);
                        String str = str;
                        long c = k.this.yPh - k.this.jEg;
                        mA = k.this.yPi;
                        if (i == 1) {
                            z = true;
                        }
                        dVar.a(str, mJ, c, mA, i2, z);
                    }
                    AppMethodBeat.o(31350);
                }
            });
        }
        AppMethodBeat.o(31362);
    }

    public final void dxC() {
        AppMethodBeat.i(31363);
        dDQ();
        boolean QL = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOm().QL(this.cgL.getTalkerUserName());
        com.tencent.mm.ui.chatting.j.a aVar = com.tencent.mm.ui.chatting.j.a.yZE;
        boolean dFx = this.cgL.dFx();
        ArrayList arrayList = new ArrayList();
        if (dFx && !QL) {
            if (aVar.yZF[0] > 0) {
                arrayList.add(new IDKey(890, 0, aVar.yZF[0]));
            }
            if (aVar.yZF[1] > 0) {
                arrayList.add(new IDKey(890, 1, aVar.yZF[1]));
            }
            if (aVar.yZF[2] > 0) {
                arrayList.add(new IDKey(890, 2, aVar.yZF[2]));
            }
            if (aVar.yZF[3] > 0) {
                arrayList.add(new IDKey(890, 3, aVar.yZF[3]));
            }
            if (aVar.yZF[4] > 0) {
                arrayList.add(new IDKey(890, 4, aVar.yZF[4]));
            }
            arrayList.add(new IDKey(890, 19, 1));
        } else if (dFx && QL) {
            if (aVar.yZF[0] > 0) {
                arrayList.add(new IDKey(890, 40, aVar.yZF[0]));
            }
            if (aVar.yZF[1] > 0) {
                arrayList.add(new IDKey(890, 41, aVar.yZF[1]));
            }
            if (aVar.yZF[2] > 0) {
                arrayList.add(new IDKey(890, 42, aVar.yZF[2]));
            }
            if (aVar.yZF[3] > 0) {
                arrayList.add(new IDKey(890, 43, aVar.yZF[3]));
            }
            if (aVar.yZF[4] > 0) {
                arrayList.add(new IDKey(890, 44, aVar.yZF[4]));
            }
            arrayList.add(new IDKey(890, 59, 1));
        } else {
            if (aVar.yZF[0] > 0) {
                arrayList.add(new IDKey(890, 20, aVar.yZF[0]));
            }
            if (aVar.yZF[1] > 0) {
                arrayList.add(new IDKey(890, 21, aVar.yZF[1]));
            }
            if (aVar.yZF[2] > 0) {
                arrayList.add(new IDKey(890, 22, aVar.yZF[2]));
            }
            if (aVar.yZF[3] > 0) {
                arrayList.add(new IDKey(890, 23, aVar.yZF[3]));
            }
            if (aVar.yZF[4] > 0) {
                arrayList.add(new IDKey(890, 24, aVar.yZF[4]));
            }
            arrayList.add(new IDKey(890, 39, 1));
        }
        com.tencent.mm.plugin.report.e.pXa.b(arrayList, true);
        com.tencent.mm.ui.chatting.j.b bVar = com.tencent.mm.ui.chatting.j.b.yZH;
        ab.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s mCount:%s mDownCount:%s mUpCount:%s mErrCount:%s mSuccessCount:%s mFetchCount:%s", this.cgL.getTalkerUserName(), Integer.valueOf(bVar.mCount), Integer.valueOf(bVar.yZI), Integer.valueOf(bVar.yZJ), Integer.valueOf(bVar.tVN), Integer.valueOf(bVar.mSuccessCount), Integer.valueOf(bVar.yZK));
        com.tencent.mm.plugin.report.e.pXa.a(403, 60, (long) bVar.mCount, true);
        com.tencent.mm.plugin.report.e.pXa.a(403, 61, (long) bVar.yZI, true);
        com.tencent.mm.plugin.report.e.pXa.a(403, 62, (long) bVar.yZJ, true);
        com.tencent.mm.plugin.report.e.pXa.a(403, 63, (long) bVar.tVN, true);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new IDKey(403, 64, bVar.mSuccessCount));
        arrayList2.add(new IDKey(403, 65, bVar.yZK));
        com.tencent.mm.plugin.report.e.pXa.b(arrayList2, true);
        AppMethodBeat.o(31363);
    }

    public final void dDh() {
        AppMethodBeat.i(31364);
        super.dDh();
        dDQ();
        AppMethodBeat.o(31364);
    }

    public final void be(final bi biVar) {
        AppMethodBeat.i(31352);
        if (!this.yOW.contains(Long.valueOf(biVar.field_msgSvrId))) {
            this.yOW.add(Long.valueOf(biVar.field_msgSvrId));
            d.post(new Runnable() {
                final /* synthetic */ boolean yPj = false;

                public final void run() {
                    AppMethodBeat.i(31344);
                    ((i) g.K(i.class)).ai(biVar);
                    bi biVar = biVar;
                    boolean z = this.yPj;
                    PString pString = new PString();
                    PString pString2 = new PString();
                    if (com.tencent.mm.ui.chatting.a.a(biVar, pString, pString2)) {
                        int i;
                        String str = pString.value;
                        String str2 = pString2.value;
                        String str3 = biVar.field_talker;
                        boolean mN = t.mN(str3);
                        String Yz = biVar.field_isSend == 1 ? r.Yz() : mN ? bf.oy(biVar.field_content) : str3;
                        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                        dVar.l("20source_publishid", str + ",");
                        dVar.l("21uxinfo", str2 + ",");
                        dVar.l("22clienttime", bo.anU() + ",");
                        dVar.l("23source_type", (biVar.getType() == 62 ? 1 : 2) + ",");
                        dVar.l("24scene", (mN ? 4 : 3) + ",");
                        dVar.l("25scene_chatname", str3 + ",");
                        dVar.l("26scene_username", Yz + ",");
                        dVar.l("27curr_publishid", ",");
                        dVar.l("28curr_msgid", biVar.field_msgSvrId + ",");
                        dVar.l("29curr_favid", "0,");
                        str = "30isdownload";
                        StringBuilder stringBuilder = new StringBuilder();
                        if (z) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        dVar.l(str, stringBuilder.append(i).append(",").toString());
                        str = "31chatroom_membercount";
                        StringBuilder stringBuilder2 = new StringBuilder();
                        if (mN) {
                            i = n.mA(str3);
                        } else {
                            i = 0;
                        }
                        dVar.l(str, stringBuilder2.append(i).append(",").toString());
                        ((i) g.K(i.class)).b(((i) g.K(i.class)).I(biVar), dVar);
                        ab.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + dVar.Fk());
                        h.pYm.e(12989, dVar);
                    }
                    AppMethodBeat.o(31344);
                }
            }, "ChattingUI.adVideoExposeReport");
        }
        AppMethodBeat.o(31352);
    }

    public final void bg(final bi biVar) {
        AppMethodBeat.i(31354);
        if (!this.yPb) {
            this.yPb = true;
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll(yPc);
            if (ll.isValid()) {
                this.yPa = ah.getInt((String) ll.dru().get("needUploadData"), 0);
            }
        }
        if (this.yPa == 0) {
            AppMethodBeat.o(31354);
        } else if (this.yOZ.contains(Long.valueOf(biVar.field_msgSvrId))) {
            AppMethodBeat.o(31354);
        } else {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31346);
                    k.a(k.this, biVar);
                    AppMethodBeat.o(31346);
                }
            }, "ChattingUI.appExposeReport");
            AppMethodBeat.o(31354);
        }
    }

    public final void dxy() {
        int i = 0;
        AppMethodBeat.i(31359);
        this.yPe = System.currentTimeMillis();
        this.yPf = true;
        if (!(this.cgL.sRl == null || this.cgL.getTalkerUserName() == null)) {
            int i2;
            int i3;
            int i4;
            b.fRa.cM(this.cgL.getTalkerUserName());
            if (!r.Yz().equals(this.cgL.getTalkerUserName())) {
                av avVar = new av();
                avVar.ctX.ctY = true;
                com.tencent.mm.sdk.b.a.xxA.m(avVar);
            }
            boolean DX = ((aj) this.cgL.aF(aj.class)).DX();
            if ("notification_messages".equals(this.cgL.getTalkerUserName())) {
                i2 = 1;
                i3 = 8;
            } else {
                boolean i42;
                if (t.mZ(this.cgL.getTalkerUserName())) {
                    com.tencent.mm.ui.chatting.c.b.d dVar = (com.tencent.mm.ui.chatting.c.b.d) this.cgL.aF(com.tencent.mm.ui.chatting.c.b.d.class);
                    if (dVar.dDm()) {
                        if (DX) {
                            i42 = 0;
                        } else {
                            i42 = true;
                        }
                        if (dVar.dDn()) {
                            dVar.dDk().afg().size();
                            i3 = 5;
                            i2 = i42;
                        } else {
                            i3 = 4;
                            i2 = i42;
                        }
                    } else if (f.rb(this.cgL.getTalkerUserName())) {
                        i2 = DX ? 0 : 1;
                        i3 = 3;
                    } else if (f.rc(this.cgL.getTalkerUserName())) {
                        i2 = 1;
                        i3 = 0;
                    } else if (f.qY(this.cgL.getTalkerUserName())) {
                        i42 = true;
                        i2 = 0;
                    } else {
                        i42 = true;
                        i2 = 0;
                    }
                } else if (this.cgL.dFw()) {
                    i2 = DX ? 0 : 1;
                    i3 = 2;
                } else if (DX) {
                    i2 = 0;
                    i42 = true;
                } else {
                    i2 = 1;
                    i42 = true;
                }
                DX = i42;
            }
            if (!this.cgL.dFv()) {
                i42 = i3;
                for (String equals : t.fkY) {
                    if (equals.equals(this.cgL.getTalkerUserName())) {
                        i42 = 0;
                    }
                }
                i = i42;
            }
            if (i != 0) {
                d.xDG.b(new Runnable() {
                    public final void run() {
                        int mA;
                        int i;
                        AppMethodBeat.i(31347);
                        if (i == 2) {
                            mA = n.mA(k.this.cgL.getTalkerUserName());
                        } else {
                            mA = 0;
                        }
                        aw.ZK();
                        ak aoZ = com.tencent.mm.model.c.XR().aoZ(k.this.cgL.getTalkerUserName());
                        if (aoZ == null) {
                            i = 0;
                        } else {
                            i = aoZ.field_unReadCount;
                        }
                        x xVar = x.ecN;
                        String talkerUserName = k.this.cgL.getTalkerUserName();
                        int i2 = i;
                        int i3 = i2;
                        if (xVar.ecX == null) {
                            xVar.ecX = r.Yz();
                        }
                        if (!xVar.ecX.equals(talkerUserName)) {
                            if (xVar.ecR != null) {
                                ab.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", xVar.ecR.ede);
                                xVar.jL(xVar.ecR.ede);
                            }
                            if (xVar.ecO.Ml(6) == 0) {
                                xVar.ecO.setLong(4, ah.anT());
                            }
                            com.tencent.mm.sdk.b.a.xxA.b(xVar.ecP);
                            com.tencent.mm.sdk.b.a.xxA.b(xVar.ecQ);
                            xVar.ecR = new x.a();
                            xVar.ecR.edj = xVar.ecS;
                            xVar.ecS = 0;
                            xVar.ecR.ede = talkerUserName;
                            xVar.ecV = ah.yz();
                            xVar.ecR.type = i2;
                            xVar.ecR.edf = i3;
                            xVar.ecR.csm = i;
                            xVar.ecR.edg = mA;
                            xVar.ecR.edh = ah.anT();
                            ab.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", talkerUserName, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(mA));
                        }
                        AppMethodBeat.o(31347);
                    }
                }, "MicroMsg.ChattingUI.ChattingReportComponent");
            }
            ((e) g.K(e.class)).a("tmpl_type_succeed_contact", this.yPd);
        }
        this.yOx = true;
        IF();
        AppMethodBeat.o(31359);
    }
}
