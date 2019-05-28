package com.tencent.p177mm.plugin.multitalk.model;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p203bg.C1310f;
import com.tencent.p177mm.p230g.p231a.C42033nw;
import com.tencent.p177mm.plugin.multitalk.model.C39419a.C39420a;
import com.tencent.p177mm.plugin.multitalk.p1492a.C46087b;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C46090e;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p546ui.C40039d;
import com.tencent.p177mm.plugin.voip.p546ui.C46928e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p659pb.common.p1102c.C40956g;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24193av;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24215bb;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.wecall.talkroom.model.C41112a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.multitalk.model.h */
public final class C34566h implements C39419a {
    private List<C39420a> bkF = new ArrayList();
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private LinkedList<String> oGI = null;
    private LinkedList<String> oGJ = new LinkedList();
    private LinkedList<String> oGK = new LinkedList();

    public final LinkedList<String> bRS() {
        AppMethodBeat.m2504i(54009);
        if (this.oGK == null) {
            this.oGK = new LinkedList();
        }
        LinkedList linkedList = this.oGK;
        AppMethodBeat.m2505o(54009);
        return linkedList;
    }

    public C34566h() {
        AppMethodBeat.m2504i(54010);
        AppMethodBeat.m2505o(54010);
    }

    /* renamed from: a */
    public final synchronized void mo55123a(C39420a c39420a) {
        AppMethodBeat.m2504i(54011);
        this.bkF.add(c39420a);
        AppMethodBeat.m2505o(54011);
    }

    /* renamed from: b */
    public final synchronized void mo55125b(C39420a c39420a) {
        AppMethodBeat.m2504i(54012);
        this.bkF.remove(c39420a);
        AppMethodBeat.m2505o(54012);
    }

    /* renamed from: RU */
    public final void mo55109RU(final String str) {
        AppMethodBeat.m2504i(54013);
        if (C1855t.m3896kH(str) && mo55112RX(str)) {
            C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
            C1720g.m3536RP().mo5239Ry().get(2, null);
            if (C34572p.bSf().oGh != null && C34572p.bSf().oGh.Aqe.equals(str)) {
                C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
                C34572p.bSf().mo24587h(false, false, false);
            }
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(54007);
                    C34566h.this.mo55117Sc(str);
                    C42033nw c42033nw = new C42033nw();
                    c42033nw.cKn.type = 2;
                    C4879a.xxA.mo10055m(c42033nw);
                    AppMethodBeat.m2505o(54007);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(54013);
    }

    /* renamed from: RV */
    public final boolean mo55110RV(String str) {
        AppMethodBeat.m2504i(54014);
        C1310f RW = C34572p.bSb().mo68858RW(str);
        if (RW == null || RW.field_wxGroupId == null || !RW.field_wxGroupId.equals(str)) {
            AppMethodBeat.m2505o(54014);
            return false;
        } else if (System.currentTimeMillis() - RW.field_createTime > 21600000) {
            C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + str + ",is out of time 6 hours..");
            mo55117Sc(str);
            AppMethodBeat.m2505o(54014);
            return false;
        } else {
            AppMethodBeat.m2505o(54014);
            return true;
        }
    }

    /* renamed from: RX */
    public final boolean mo55112RX(String str) {
        AppMethodBeat.m2504i(54015);
        if (this.oGI == null) {
            bRT();
        }
        if (this.oGI == null || !this.oGI.contains(str)) {
            AppMethodBeat.m2505o(54015);
            return false;
        }
        AppMethodBeat.m2505o(54015);
        return true;
    }

    /* renamed from: RY */
    public final List<String> mo55113RY(String str) {
        AppMethodBeat.m2504i(54016);
        LinkedList<C46087b> So = C34572p.bSc().mo62357So(str);
        LinkedList linkedList = new LinkedList();
        for (C46087b c46087b : So) {
            linkedList.add(c46087b.field_userName);
        }
        AppMethodBeat.m2505o(54016);
        return linkedList;
    }

    /* renamed from: ff */
    public final boolean mo55133ff(String str, String str2) {
        AppMethodBeat.m2504i(54017);
        if (C34572p.bSc().mo62360fi(str, str2) != null) {
            AppMethodBeat.m2505o(54017);
            return true;
        }
        AppMethodBeat.m2505o(54017);
        return false;
    }

    public final boolean bRd() {
        AppMethodBeat.m2504i(54019);
        boolean bRd = C34572p.bSf().bRd();
        AppMethodBeat.m2505o(54019);
        return bRd;
    }

    public final boolean bRc() {
        AppMethodBeat.m2504i(54020);
        boolean bRc = C34572p.bSf().bRc();
        AppMethodBeat.m2505o(54020);
        return bRc;
    }

    public final boolean bRa() {
        AppMethodBeat.m2504i(54021);
        if (C34572p.bSf().bRd() && (C34572p.bSf().oGg == C46090e.Starting || C34572p.bSf().oGg == C46090e.Creating)) {
            AppMethodBeat.m2505o(54021);
            return true;
        }
        AppMethodBeat.m2505o(54021);
        return false;
    }

    /* renamed from: RZ */
    public final boolean mo55114RZ(String str) {
        AppMethodBeat.m2504i(54022);
        C40039d cIk = C43727b.cIk();
        if (cIk != null) {
            Intent intent = cIk.intent;
            if (intent != null) {
                String stringExtra = intent.getStringExtra("enterMainUiWxGroupId");
                C46928e c46928e = cIk.sYX;
                if (!C40956g.isEmpty(stringExtra) && str.equals(stringExtra) && c46928e != null && c46928e.getVisibility() == 0 && c46928e.isShown()) {
                    AppMethodBeat.m2505o(54022);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(54022);
        return false;
    }

    public final boolean bRb() {
        AppMethodBeat.m2504i(54023);
        if (C29488d.cLx() || C34572p.bSf().bRc() || C34572p.bSf().bRd() || C34572p.bSf().bRH()) {
            AppMethodBeat.m2505o(54023);
            return true;
        }
        AppMethodBeat.m2505o(54023);
        return false;
    }

    /* renamed from: fh */
    public final String mo55135fh(String str, String str2) {
        AppMethodBeat.m2504i(54024);
        C46087b fi = C34572p.bSc().mo62360fi(str, str2);
        if (fi != null) {
            String str3 = fi.field_inviteUserName;
            AppMethodBeat.m2505o(54024);
            return str3;
        }
        AppMethodBeat.m2505o(54024);
        return null;
    }

    /* renamed from: mJ */
    public final String mo55136mJ(String str) {
        AppMethodBeat.m2504i(54025);
        String mJ = C1854s.m3866mJ(str);
        AppMethodBeat.m2505o(54025);
        return mJ;
    }

    /* renamed from: Se */
    public final void mo55119Se(String str) {
        AppMethodBeat.m2504i(54028);
        if (this.oGJ == null) {
            this.oGJ = new LinkedList();
            if (!this.oGJ.contains(str)) {
                this.oGJ.add(str);
                AppMethodBeat.m2505o(54028);
                return;
            }
        } else if (!this.oGJ.contains(str)) {
            this.oGJ.add(str);
        }
        AppMethodBeat.m2505o(54028);
    }

    /* renamed from: fg */
    public final int mo55134fg(String str, String str2) {
        AppMethodBeat.m2504i(54031);
        C46087b fi = C34572p.bSc().mo62360fi(str, str2);
        if (fi != null) {
            int i = fi.field_status;
            AppMethodBeat.m2505o(54031);
            return i;
        }
        AppMethodBeat.m2505o(54031);
        return 30;
    }

    /* renamed from: Sc */
    public final void mo55117Sc(String str) {
        AppMethodBeat.m2504i(54032);
        if (C40956g.isNullOrEmpty(str)) {
            C4990ab.m7412e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
            AppMethodBeat.m2505o(54032);
            return;
        }
        C4990ab.m7417i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", str);
        mo55137pI(str);
        C34572p.bSc().mo62361pI(str);
        mo55122Sm(str);
        AppMethodBeat.m2505o(54032);
    }

    /* renamed from: a */
    public final void mo55124a(String str, C24215bb c24215bb) {
        AppMethodBeat.m2504i(54033);
        C4990ab.m7417i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", str);
        C34566h.m56671c(str, c24215bb);
        if (C34566h.m56670b(str, c24215bb)) {
            m56669Sn(str);
        }
        mo55122Sm(str);
        AppMethodBeat.m2505o(54033);
    }

    /* renamed from: Sk */
    public final void mo55120Sk(String str) {
        AppMethodBeat.m2504i(54034);
        if (this.oGJ == null) {
            this.oGJ = new LinkedList();
            AppMethodBeat.m2505o(54034);
            return;
        }
        this.oGJ.remove(str);
        AppMethodBeat.m2505o(54034);
    }

    /* renamed from: Sl */
    public final boolean mo55121Sl(String str) {
        AppMethodBeat.m2504i(54035);
        if (this.oGJ == null) {
            AppMethodBeat.m2505o(54035);
            return false;
        }
        boolean contains = this.oGJ.contains(str);
        AppMethodBeat.m2505o(54035);
        return contains;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Sm */
    public final void mo55122Sm(final String str) {
        AppMethodBeat.m2504i(54036);
        for (final C39420a c39420a : this.bkF) {
            this.handler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(54008);
                    c39420a.mo41849Sf(str);
                    AppMethodBeat.m2505o(54008);
                }
            });
        }
        AppMethodBeat.m2505o(54036);
    }

    /* renamed from: RW */
    public final C1310f mo55111RW(String str) {
        AppMethodBeat.m2504i(139032);
        C1310f RW = C34572p.bSb().mo68858RW(str);
        AppMethodBeat.m2505o(139032);
        return RW;
    }

    public final void bRT() {
        AppMethodBeat.m2504i(54038);
        LinkedList bSj = C34572p.bSb().bSj();
        C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
        this.oGI = new LinkedList();
        Iterator it = bSj.iterator();
        while (it.hasNext()) {
            this.oGI.add(((C1310f) it.next()).field_wxGroupId);
        }
        C42033nw c42033nw = new C42033nw();
        c42033nw.cKn.type = 1;
        C4879a.xxA.mo10055m(c42033nw);
        AppMethodBeat.m2505o(54038);
    }

    /* renamed from: Sn */
    private void m56669Sn(String str) {
        AppMethodBeat.m2504i(54039);
        C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:".concat(String.valueOf(str)));
        if (this.oGI == null) {
            bRT();
            if (this.oGI != null) {
                this.oGI.add(str);
            }
        } else if (!this.oGI.contains(str)) {
            this.oGI.add(str);
            AppMethodBeat.m2505o(54039);
            return;
        }
        AppMethodBeat.m2505o(54039);
    }

    /* renamed from: b */
    private static boolean m56670b(String str, C24215bb c24215bb) {
        int i = 0;
        AppMethodBeat.m2504i(54040);
        if (c24215bb == null) {
            AppMethodBeat.m2505o(54040);
            return false;
        }
        C1310f c1310f = new C1310f();
        c1310f.field_wxGroupId = str;
        c1310f.field_groupId = c24215bb.groupId;
        c1310f.field_roomId = c24215bb.sQS;
        c1310f.field_roomKey = c24215bb.sQT;
        c1310f.field_routeId = c24215bb.AmC;
        c1310f.field_inviteUserName = c24215bb.ApP;
        C24193av[] c24193avArr = c24215bb.AnQ;
        if (c24193avArr.length > 0) {
            i = c24193avArr.length;
        }
        c1310f.field_memberCount = i;
        c1310f.field_createTime = System.currentTimeMillis();
        boolean a;
        if (C34572p.bSb().mo68858RW(str) == null) {
            a = C34572p.bSb().mo68859a(c1310f);
            AppMethodBeat.m2505o(54040);
            return a;
        }
        a = C34572p.bSb().mo68860b(c1310f);
        AppMethodBeat.m2505o(54040);
        return a;
    }

    /* renamed from: c */
    private static boolean m56671c(String str, C24215bb c24215bb) {
        AppMethodBeat.m2504i(54041);
        if (c24215bb == null) {
            AppMethodBeat.m2505o(54041);
            return false;
        }
        boolean z = true;
        C24193av[] c24193avArr = c24215bb.AnQ;
        if (c24193avArr == null || c24193avArr.length <= 0) {
            AppMethodBeat.m2505o(54041);
            return true;
        }
        C34572p.bSc().mo62361pI(str);
        for (C24193av c24193av : c24193avArr) {
            C46087b c46087b = new C46087b();
            c46087b.field_wxGroupId = str;
            c46087b.field_inviteUserName = c24193av.Apu;
            c46087b.field_memberUuid = (long) c24193av.vzt;
            c46087b.field_userName = c24193av.Aop;
            c46087b.field_status = c24193av.status;
            if (!C34572p.bSc().mo62358a(c46087b)) {
                C4990ab.m7413e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, c24193av.Aop, Long.valueOf(c46087b.field_memberUuid), c46087b.field_inviteUserName);
                z = false;
            }
            C4990ab.m7417i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, c24193av.Aop, Long.valueOf(c46087b.field_memberUuid), c46087b.field_inviteUserName);
        }
        AppMethodBeat.m2505o(54041);
        return z;
    }

    /* renamed from: d */
    static boolean m56672d(String str, C24215bb c24215bb) {
        AppMethodBeat.m2504i(54042);
        if (c24215bb == null) {
            AppMethodBeat.m2505o(54042);
            return false;
        }
        C24193av[] c24193avArr = c24215bb.AnQ;
        LinkedList linkedList = new LinkedList();
        for (C24193av c24193av : c24193avArr) {
            linkedList.add(c24193av.Aop);
        }
        String str2 = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
        if (str2 == null) {
            C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
            C34566h.m56670b(str, c24215bb);
            AppMethodBeat.m2505o(54042);
            return true;
        }
        boolean z;
        LinkedList<C46087b> So = C34572p.bSc().mo62357So(str);
        LinkedList linkedList2 = new LinkedList();
        C46087b c46087b = null;
        for (C46087b c46087b2 : So) {
            C46087b c46087b22;
            linkedList2.add(c46087b22.field_userName);
            if (!c46087b22.field_userName.equals(str2)) {
                c46087b22 = c46087b;
            }
            c46087b = c46087b22;
        }
        if (c46087b == null || !linkedList.contains(str2)) {
            z = true;
        } else {
            z = true;
            for (C24193av c24193av2 : c24193avArr) {
                if (!(c24193av2.Aop == null || !c24193av2.Aop.equals(str2) || c24193av2.status == c46087b.field_status)) {
                    C46087b c46087b3 = new C46087b();
                    c46087b3.field_wxGroupId = str;
                    c46087b3.field_inviteUserName = c24193av2.Apu;
                    c46087b3.field_memberUuid = (long) c24193av2.vzt;
                    c46087b3.field_userName = c24193av2.Aop;
                    c46087b3.field_status = c24193av2.status;
                    if (!C34572p.bSc().mo62358a(c46087b3)) {
                        C4990ab.m7413e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, c24193av2.Aop, Long.valueOf(c46087b3.field_memberUuid), c46087b3.field_inviteUserName);
                        z = false;
                    }
                    C4990ab.m7417i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, c24193av2.Aop, Long.valueOf(c46087b3.field_memberUuid), c46087b3.field_inviteUserName);
                }
            }
        }
        boolean z2 = z;
        for (C24193av c24193av3 : c24193avArr) {
            if (!linkedList2.contains(c24193av3.Aop)) {
                C46087b c46087b4 = new C46087b();
                c46087b4.field_wxGroupId = str;
                c46087b4.field_inviteUserName = c24193av3.Apu;
                c46087b4.field_memberUuid = (long) c24193av3.vzt;
                c46087b4.field_userName = c24193av3.Aop;
                c46087b4.field_status = c24193av3.status;
                if (!C34572p.bSc().mo62358a(c46087b4)) {
                    C4990ab.m7413e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, c24193av3.Aop, Long.valueOf(c46087b4.field_memberUuid), c46087b4.field_inviteUserName);
                    z2 = false;
                }
                C4990ab.m7417i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, c24193av3.Aop, Long.valueOf(c46087b4.field_memberUuid), c46087b4.field_inviteUserName);
            }
        }
        Iterator it = linkedList2.iterator();
        z = z2;
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (!linkedList.contains(str2)) {
                if (C34572p.bSc().mo62359dm(str, str2)) {
                    C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + str + ", username = " + str2);
                } else {
                    z = false;
                    C4990ab.m7412e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + str + ", username = " + str2);
                }
            }
            z = z;
        }
        AppMethodBeat.m2505o(54042);
        return z;
    }

    /* renamed from: pI */
    public final boolean mo55137pI(String str) {
        AppMethodBeat.m2504i(54018);
        if (this.oGI != null) {
            C4990ab.m7416i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:".concat(String.valueOf(str)));
            this.oGI.remove(str);
        } else {
            bRT();
        }
        boolean pI = C34572p.bSb().mo68862pI(str);
        AppMethodBeat.m2505o(54018);
        return pI;
    }

    /* renamed from: bJ */
    public final boolean mo55126bJ(Context context) {
        AppMethodBeat.m2504i(54026);
        boolean bJ = C35973a.m59179bJ(context);
        AppMethodBeat.m2505o(54026);
        return bJ;
    }

    /* renamed from: Sd */
    public final boolean mo55118Sd(String str) {
        AppMethodBeat.m2504i(54027);
        C1310f RW = C34572p.bSb().mo68858RW(str);
        if (RW != null) {
            boolean a = C41112a.dSR().mo41154a(RW.field_groupId, RW.field_roomId, RW.field_roomKey, 1);
            AppMethodBeat.m2505o(54027);
            return a;
        }
        AppMethodBeat.m2505o(54027);
        return false;
    }

    /* renamed from: Sa */
    public final boolean mo55115Sa(String str) {
        AppMethodBeat.m2504i(54029);
        C1310f RW = C34572p.bSb().mo68858RW(str);
        if (RW != null) {
            boolean Sa = C34572p.bSe().oFP.mo58357Sa(RW.field_groupId);
            AppMethodBeat.m2505o(54029);
            return Sa;
        }
        AppMethodBeat.m2505o(54029);
        return false;
    }

    /* renamed from: Sb */
    public final boolean mo55116Sb(String str) {
        AppMethodBeat.m2504i(54030);
        C1310f RW = C34572p.bSb().mo68858RW(str);
        if (RW != null) {
            C4990ab.m7410d("MicroMsg.MultiTalkRoomListMsg", "enterMultiTalk, roomid:" + RW.field_roomId + " wxgroupid:" + str);
            boolean a = C34572p.bSe().oFP.mo58362a(RW.field_groupId, RW.field_roomId, RW.field_roomKey, RW.field_routeId, str);
            AppMethodBeat.m2505o(54030);
            return a;
        }
        AppMethodBeat.m2505o(54030);
        return false;
    }
}
