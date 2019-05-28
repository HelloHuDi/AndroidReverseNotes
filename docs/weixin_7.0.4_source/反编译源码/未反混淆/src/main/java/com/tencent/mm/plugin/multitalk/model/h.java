package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.f;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.model.a.a;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h implements a {
    private List<a> bkF = new ArrayList();
    private ak handler = new ak(Looper.getMainLooper());
    private LinkedList<String> oGI = null;
    private LinkedList<String> oGJ = new LinkedList();
    private LinkedList<String> oGK = new LinkedList();

    public final LinkedList<String> bRS() {
        AppMethodBeat.i(54009);
        if (this.oGK == null) {
            this.oGK = new LinkedList();
        }
        LinkedList linkedList = this.oGK;
        AppMethodBeat.o(54009);
        return linkedList;
    }

    public h() {
        AppMethodBeat.i(54010);
        AppMethodBeat.o(54010);
    }

    public final synchronized void a(a aVar) {
        AppMethodBeat.i(54011);
        this.bkF.add(aVar);
        AppMethodBeat.o(54011);
    }

    public final synchronized void b(a aVar) {
        AppMethodBeat.i(54012);
        this.bkF.remove(aVar);
        AppMethodBeat.o(54012);
    }

    public final void RU(final String str) {
        AppMethodBeat.i(54013);
        if (t.kH(str) && RX(str)) {
            ab.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
            g.RP().Ry().get(2, null);
            if (p.bSf().oGh != null && p.bSf().oGh.Aqe.equals(str)) {
                ab.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
                p.bSf().h(false, false, false);
            }
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(54007);
                    h.this.Sc(str);
                    nw nwVar = new nw();
                    nwVar.cKn.type = 2;
                    com.tencent.mm.sdk.b.a.xxA.m(nwVar);
                    AppMethodBeat.o(54007);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(54013);
    }

    public final boolean RV(String str) {
        AppMethodBeat.i(54014);
        f RW = p.bSb().RW(str);
        if (RW == null || RW.field_wxGroupId == null || !RW.field_wxGroupId.equals(str)) {
            AppMethodBeat.o(54014);
            return false;
        } else if (System.currentTimeMillis() - RW.field_createTime > 21600000) {
            ab.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + str + ",is out of time 6 hours..");
            Sc(str);
            AppMethodBeat.o(54014);
            return false;
        } else {
            AppMethodBeat.o(54014);
            return true;
        }
    }

    public final boolean RX(String str) {
        AppMethodBeat.i(54015);
        if (this.oGI == null) {
            bRT();
        }
        if (this.oGI == null || !this.oGI.contains(str)) {
            AppMethodBeat.o(54015);
            return false;
        }
        AppMethodBeat.o(54015);
        return true;
    }

    public final List<String> RY(String str) {
        AppMethodBeat.i(54016);
        LinkedList<b> So = p.bSc().So(str);
        LinkedList linkedList = new LinkedList();
        for (b bVar : So) {
            linkedList.add(bVar.field_userName);
        }
        AppMethodBeat.o(54016);
        return linkedList;
    }

    public final boolean ff(String str, String str2) {
        AppMethodBeat.i(54017);
        if (p.bSc().fi(str, str2) != null) {
            AppMethodBeat.o(54017);
            return true;
        }
        AppMethodBeat.o(54017);
        return false;
    }

    public final boolean bRd() {
        AppMethodBeat.i(54019);
        boolean bRd = p.bSf().bRd();
        AppMethodBeat.o(54019);
        return bRd;
    }

    public final boolean bRc() {
        AppMethodBeat.i(54020);
        boolean bRc = p.bSf().bRc();
        AppMethodBeat.o(54020);
        return bRc;
    }

    public final boolean bRa() {
        AppMethodBeat.i(54021);
        if (p.bSf().bRd() && (p.bSf().oGg == e.Starting || p.bSf().oGg == e.Creating)) {
            AppMethodBeat.o(54021);
            return true;
        }
        AppMethodBeat.o(54021);
        return false;
    }

    public final boolean RZ(String str) {
        AppMethodBeat.i(54022);
        d cIk = com.tencent.mm.plugin.voip.b.cIk();
        if (cIk != null) {
            Intent intent = cIk.intent;
            if (intent != null) {
                String stringExtra = intent.getStringExtra("enterMainUiWxGroupId");
                com.tencent.mm.plugin.voip.ui.e eVar = cIk.sYX;
                if (!com.tencent.pb.common.c.g.isEmpty(stringExtra) && str.equals(stringExtra) && eVar != null && eVar.getVisibility() == 0 && eVar.isShown()) {
                    AppMethodBeat.o(54022);
                    return true;
                }
            }
        }
        AppMethodBeat.o(54022);
        return false;
    }

    public final boolean bRb() {
        AppMethodBeat.i(54023);
        if (com.tencent.mm.plugin.voip.a.d.cLx() || p.bSf().bRc() || p.bSf().bRd() || p.bSf().bRH()) {
            AppMethodBeat.o(54023);
            return true;
        }
        AppMethodBeat.o(54023);
        return false;
    }

    public final String fh(String str, String str2) {
        AppMethodBeat.i(54024);
        b fi = p.bSc().fi(str, str2);
        if (fi != null) {
            String str3 = fi.field_inviteUserName;
            AppMethodBeat.o(54024);
            return str3;
        }
        AppMethodBeat.o(54024);
        return null;
    }

    public final String mJ(String str) {
        AppMethodBeat.i(54025);
        String mJ = s.mJ(str);
        AppMethodBeat.o(54025);
        return mJ;
    }

    public final void Se(String str) {
        AppMethodBeat.i(54028);
        if (this.oGJ == null) {
            this.oGJ = new LinkedList();
            if (!this.oGJ.contains(str)) {
                this.oGJ.add(str);
                AppMethodBeat.o(54028);
                return;
            }
        } else if (!this.oGJ.contains(str)) {
            this.oGJ.add(str);
        }
        AppMethodBeat.o(54028);
    }

    public final int fg(String str, String str2) {
        AppMethodBeat.i(54031);
        b fi = p.bSc().fi(str, str2);
        if (fi != null) {
            int i = fi.field_status;
            AppMethodBeat.o(54031);
            return i;
        }
        AppMethodBeat.o(54031);
        return 30;
    }

    public final void Sc(String str) {
        AppMethodBeat.i(54032);
        if (com.tencent.pb.common.c.g.isNullOrEmpty(str)) {
            ab.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
            AppMethodBeat.o(54032);
            return;
        }
        ab.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", str);
        pI(str);
        p.bSc().pI(str);
        Sm(str);
        AppMethodBeat.o(54032);
    }

    public final void a(String str, bb bbVar) {
        AppMethodBeat.i(54033);
        ab.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", str);
        c(str, bbVar);
        if (b(str, bbVar)) {
            Sn(str);
        }
        Sm(str);
        AppMethodBeat.o(54033);
    }

    public final void Sk(String str) {
        AppMethodBeat.i(54034);
        if (this.oGJ == null) {
            this.oGJ = new LinkedList();
            AppMethodBeat.o(54034);
            return;
        }
        this.oGJ.remove(str);
        AppMethodBeat.o(54034);
    }

    public final boolean Sl(String str) {
        AppMethodBeat.i(54035);
        if (this.oGJ == null) {
            AppMethodBeat.o(54035);
            return false;
        }
        boolean contains = this.oGJ.contains(str);
        AppMethodBeat.o(54035);
        return contains;
    }

    /* Access modifiers changed, original: final */
    public final void Sm(final String str) {
        AppMethodBeat.i(54036);
        for (final a aVar : this.bkF) {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(54008);
                    aVar.Sf(str);
                    AppMethodBeat.o(54008);
                }
            });
        }
        AppMethodBeat.o(54036);
    }

    public final f RW(String str) {
        AppMethodBeat.i(139032);
        f RW = p.bSb().RW(str);
        AppMethodBeat.o(139032);
        return RW;
    }

    public final void bRT() {
        AppMethodBeat.i(54038);
        LinkedList bSj = p.bSb().bSj();
        ab.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
        this.oGI = new LinkedList();
        Iterator it = bSj.iterator();
        while (it.hasNext()) {
            this.oGI.add(((f) it.next()).field_wxGroupId);
        }
        nw nwVar = new nw();
        nwVar.cKn.type = 1;
        com.tencent.mm.sdk.b.a.xxA.m(nwVar);
        AppMethodBeat.o(54038);
    }

    private void Sn(String str) {
        AppMethodBeat.i(54039);
        ab.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(str)));
        if (this.oGI == null) {
            bRT();
            if (this.oGI != null) {
                this.oGI.add(str);
            }
        } else if (!this.oGI.contains(str)) {
            this.oGI.add(str);
            AppMethodBeat.o(54039);
            return;
        }
        AppMethodBeat.o(54039);
    }

    private static boolean b(String str, bb bbVar) {
        int i = 0;
        AppMethodBeat.i(54040);
        if (bbVar == null) {
            AppMethodBeat.o(54040);
            return false;
        }
        f fVar = new f();
        fVar.field_wxGroupId = str;
        fVar.field_groupId = bbVar.groupId;
        fVar.field_roomId = bbVar.sQS;
        fVar.field_roomKey = bbVar.sQT;
        fVar.field_routeId = bbVar.AmC;
        fVar.field_inviteUserName = bbVar.ApP;
        av[] avVarArr = bbVar.AnQ;
        if (avVarArr.length > 0) {
            i = avVarArr.length;
        }
        fVar.field_memberCount = i;
        fVar.field_createTime = System.currentTimeMillis();
        boolean a;
        if (p.bSb().RW(str) == null) {
            a = p.bSb().a(fVar);
            AppMethodBeat.o(54040);
            return a;
        }
        a = p.bSb().b(fVar);
        AppMethodBeat.o(54040);
        return a;
    }

    private static boolean c(String str, bb bbVar) {
        AppMethodBeat.i(54041);
        if (bbVar == null) {
            AppMethodBeat.o(54041);
            return false;
        }
        boolean z = true;
        av[] avVarArr = bbVar.AnQ;
        if (avVarArr == null || avVarArr.length <= 0) {
            AppMethodBeat.o(54041);
            return true;
        }
        p.bSc().pI(str);
        for (av avVar : avVarArr) {
            b bVar = new b();
            bVar.field_wxGroupId = str;
            bVar.field_inviteUserName = avVar.Apu;
            bVar.field_memberUuid = (long) avVar.vzt;
            bVar.field_userName = avVar.Aop;
            bVar.field_status = avVar.status;
            if (!p.bSc().a(bVar)) {
                ab.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar.Aop, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName);
                z = false;
            }
            ab.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar.Aop, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName);
        }
        AppMethodBeat.o(54041);
        return z;
    }

    static boolean d(String str, bb bbVar) {
        AppMethodBeat.i(54042);
        if (bbVar == null) {
            AppMethodBeat.o(54042);
            return false;
        }
        av[] avVarArr = bbVar.AnQ;
        LinkedList linkedList = new LinkedList();
        for (av avVar : avVarArr) {
            linkedList.add(avVar.Aop);
        }
        String str2 = (String) g.RP().Ry().get(2, null);
        if (str2 == null) {
            ab.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
            b(str, bbVar);
            AppMethodBeat.o(54042);
            return true;
        }
        boolean z;
        LinkedList<b> So = p.bSc().So(str);
        LinkedList linkedList2 = new LinkedList();
        b bVar = null;
        for (b bVar2 : So) {
            b bVar22;
            linkedList2.add(bVar22.field_userName);
            if (!bVar22.field_userName.equals(str2)) {
                bVar22 = bVar;
            }
            bVar = bVar22;
        }
        if (bVar == null || !linkedList.contains(str2)) {
            z = true;
        } else {
            z = true;
            for (av avVar2 : avVarArr) {
                if (!(avVar2.Aop == null || !avVar2.Aop.equals(str2) || avVar2.status == bVar.field_status)) {
                    b bVar3 = new b();
                    bVar3.field_wxGroupId = str;
                    bVar3.field_inviteUserName = avVar2.Apu;
                    bVar3.field_memberUuid = (long) avVar2.vzt;
                    bVar3.field_userName = avVar2.Aop;
                    bVar3.field_status = avVar2.status;
                    if (!p.bSc().a(bVar3)) {
                        ab.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar2.Aop, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName);
                        z = false;
                    }
                    ab.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar2.Aop, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName);
                }
            }
        }
        boolean z2 = z;
        for (av avVar3 : avVarArr) {
            if (!linkedList2.contains(avVar3.Aop)) {
                b bVar4 = new b();
                bVar4.field_wxGroupId = str;
                bVar4.field_inviteUserName = avVar3.Apu;
                bVar4.field_memberUuid = (long) avVar3.vzt;
                bVar4.field_userName = avVar3.Aop;
                bVar4.field_status = avVar3.status;
                if (!p.bSc().a(bVar4)) {
                    ab.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar3.Aop, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName);
                    z2 = false;
                }
                ab.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar3.Aop, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName);
            }
        }
        Iterator it = linkedList2.iterator();
        z = z2;
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (!linkedList.contains(str2)) {
                if (p.bSc().dm(str, str2)) {
                    ab.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + str + ", username = " + str2);
                } else {
                    z = false;
                    ab.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + str + ", username = " + str2);
                }
            }
            z = z;
        }
        AppMethodBeat.o(54042);
        return z;
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(54018);
        if (this.oGI != null) {
            ab.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(str)));
            this.oGI.remove(str);
        } else {
            bRT();
        }
        boolean pI = p.bSb().pI(str);
        AppMethodBeat.o(54018);
        return pI;
    }

    public final boolean bJ(Context context) {
        AppMethodBeat.i(54026);
        boolean bJ = com.tencent.mm.r.a.bJ(context);
        AppMethodBeat.o(54026);
        return bJ;
    }

    public final boolean Sd(String str) {
        AppMethodBeat.i(54027);
        f RW = p.bSb().RW(str);
        if (RW != null) {
            boolean a = com.tencent.wecall.talkroom.model.a.dSR().a(RW.field_groupId, RW.field_roomId, RW.field_roomKey, 1);
            AppMethodBeat.o(54027);
            return a;
        }
        AppMethodBeat.o(54027);
        return false;
    }

    public final boolean Sa(String str) {
        AppMethodBeat.i(54029);
        f RW = p.bSb().RW(str);
        if (RW != null) {
            boolean Sa = p.bSe().oFP.Sa(RW.field_groupId);
            AppMethodBeat.o(54029);
            return Sa;
        }
        AppMethodBeat.o(54029);
        return false;
    }

    public final boolean Sb(String str) {
        AppMethodBeat.i(54030);
        f RW = p.bSb().RW(str);
        if (RW != null) {
            ab.d("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + RW.field_roomId + " wxgroupid:" + str);
            boolean a = p.bSe().oFP.a(RW.field_groupId, RW.field_roomId, RW.field_roomKey, RW.field_routeId, str);
            AppMethodBeat.o(54030);
            return a;
        }
        AppMethodBeat.o(54030);
        return false;
    }
}
