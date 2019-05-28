package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.v;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.d;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.ttpic.VError;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class f implements ServiceConnection, a {
    public boolean eif;
    private b gar;
    private boolean nvf;
    public i nwe;
    c oGA = new c<kc>() {
        {
            AppMethodBeat.i(53945);
            this.xxI = kc.class.getName().hashCode();
            AppMethodBeat.o(53945);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(53946);
            kc kcVar = (kc) bVar;
            if (kcVar instanceof kc) {
                kc.b bVar2;
                boolean bRd;
                switch (kcVar.cFw.action) {
                    case 1:
                        bVar2 = kcVar.cFx;
                        bRd = f.this.bRd();
                        break;
                    case 2:
                        bVar2 = kcVar.cFx;
                        f fVar = f.this;
                        if (fVar.oGq == null) {
                            bRd = false;
                            break;
                        }
                        bRd = fVar.oGq.bRh();
                        break;
                }
                bVar2.cFy = bRd;
            }
            AppMethodBeat.o(53946);
            return false;
        }
    };
    private boolean oGa;
    public boolean oGb;
    boolean oGc;
    private int oGd;
    public boolean oGe = true;
    public HashSet<String> oGf = new HashSet();
    public e oGg = e.Init;
    public MultiTalkGroup oGh = null;
    private l oGi;
    private long oGj = 0;
    public int oGk = 0;
    private int oGl = 0;
    private int oGm = 2;
    private boolean oGn = false;
    private long oGo = 0;
    private long oGp = 30000;
    public b oGq;
    private Timer oGr;
    private j.a oGs;
    public boolean oGt;
    MultiTalkGroup oGu = null;
    long oGv = 0;
    private boolean oGw = false;
    ap oGx = new ap(Looper.getMainLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(53949);
            ab.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
            if (f.this.oGu == null) {
                f.this.oGv = 0;
                f.this.oGx.stopTimer();
                AppMethodBeat.o(53949);
                return false;
            } else if (f.eB(ah.getContext())) {
                f.this.b(f.this.oGu);
                f.this.oGu = null;
                f.this.oGv = 0;
                f.this.oGx.stopTimer();
                h.pYm.a(500, 7, 1, false);
                AppMethodBeat.o(53949);
                return false;
            } else if (System.currentTimeMillis() - f.this.oGv < 60000) {
                AppMethodBeat.o(53949);
                return true;
            } else {
                f.this.oGu = null;
                f.this.oGv = 0;
                f.this.oGx.stopTimer();
                AppMethodBeat.o(53949);
                return false;
            }
        }
    }, true);
    private ak oGy = new ak(Looper.getMainLooper());
    BroadcastReceiver oGz = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(53941);
            if (!f.this.bRd()) {
                AppMethodBeat.o(53941);
            } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                f.this.oGy.removeCallbacksAndMessages(null);
                f.this.oGy.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(53938);
                        j.a bRX = j.bRX();
                        if (bRX != f.this.oGs) {
                            j.a i = f.this.oGs;
                            f.this.oGs = bRX;
                            ab.i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", i.name(), f.this.oGs.name());
                            f.this.zf(f.this.oGd);
                            if (f.this.oGq != null) {
                                f.this.oGq.a(f.this.oGs);
                            }
                            AppMethodBeat.o(53938);
                            return;
                        }
                        f.this.zf(f.this.oGd);
                        ab.i("MicroMsg.MT.MultiTalkManager", "network not change: %s", f.this.oGs.name());
                        AppMethodBeat.o(53938);
                    }
                }, 8000);
                AppMethodBeat.o(53941);
            } else {
                ab.i("MicroMsg.MT.MultiTalkManager", "phone state %d", Integer.valueOf(j.z(context, intent)));
                if (j.z(context, intent) == 0) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(53939);
                            p.bSe().oFP.rn(false);
                            if (g.KK() == null || !g.KK().KP()) {
                                f.this.jo(p.bSf().oGb);
                                AppMethodBeat.o(53939);
                                return;
                            }
                            ab.i("MicroMsg.MT.MultiTalkManager", "is bluetooth can use and start bluetooth");
                            g.KK().KM();
                            AppMethodBeat.o(53939);
                        }
                    });
                    AppMethodBeat.o(53941);
                    return;
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(53940);
                        p.bSe().oFP.rn(true);
                        AppMethodBeat.o(53940);
                    }
                });
                AppMethodBeat.o(53941);
            }
        }
    };

    static /* synthetic */ boolean eB(Context context) {
        AppMethodBeat.i(54003);
        boolean eA = eA(context);
        AppMethodBeat.o(54003);
        return eA;
    }

    public f() {
        AppMethodBeat.i(53955);
        com.tencent.mm.sdk.b.a.xxA.c(this.oGA);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.intent.action.PHONE_STATE_2");
        intentFilter.addAction("android.intent.action.PHONE_STATE2");
        intentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
        intentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ah.getContext().registerReceiver(this.oGz, intentFilter);
        this.nwe = new i(ah.getContext());
        this.gar = new b(ah.getContext());
        this.oGt = false;
        AppMethodBeat.o(53955);
    }

    public final boolean bRF() {
        AppMethodBeat.i(53956);
        j.bRW();
        boolean zg = j.zg(this.oGd);
        AppMethodBeat.o(53956);
        return zg;
    }

    public final boolean bRG() {
        AppMethodBeat.i(53957);
        j.bRW();
        boolean zh = j.zh(this.oGd);
        AppMethodBeat.o(53957);
        return zh;
    }

    public final boolean bRd() {
        boolean z;
        AppMethodBeat.i(53958);
        if (this.oGg == e.Init || this.oGh == null) {
            z = false;
        } else {
            z = true;
        }
        ab.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", Boolean.valueOf(z));
        AppMethodBeat.o(53958);
        return z;
    }

    public final boolean bRH() {
        boolean z;
        AppMethodBeat.i(53959);
        if (this.oGg == e.Starting || this.oGg == e.Talking) {
            z = true;
        } else {
            z = false;
        }
        ab.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", Boolean.valueOf(z));
        AppMethodBeat.o(53959);
        return z;
    }

    public final boolean bRc() {
        boolean z;
        AppMethodBeat.i(53960);
        if (this.oGg == e.Talking) {
            z = true;
        } else {
            z = false;
        }
        ab.d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", Boolean.valueOf(z));
        AppMethodBeat.o(53960);
        return z;
    }

    public final long getTotalTime() {
        AppMethodBeat.i(53961);
        long currentTimeMillis = System.currentTimeMillis() - this.oGj;
        AppMethodBeat.o(53961);
        return currentTimeMillis;
    }

    private boolean a(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(53962);
        if (!bRd()) {
            ab.i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", j.h(multiTalkGroup));
            this.oGh = multiTalkGroup;
            this.oGk = 0;
            this.oGd = 1;
            this.oGf.clear();
            bRI();
            sort();
            AppMethodBeat.o(53962);
            return true;
        } else if (j.a(multiTalkGroup, this.oGh)) {
            ab.i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", j.h(multiTalkGroup));
            MultiTalkGroup multiTalkGroup2 = this.oGh;
            HashMap hashMap = new HashMap();
            for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.Aqg) {
                hashMap.put(multiTalkGroupMember.Aqh, multiTalkGroupMember);
            }
            for (MultiTalkGroupMember multiTalkGroupMember2 : multiTalkGroup2.Aqg) {
                if (!r.Yz().equals(multiTalkGroupMember2.Aqh) && r.Yz().equals(multiTalkGroupMember2.Aqi) && multiTalkGroupMember2.status == 1) {
                    if (!hashMap.containsKey(multiTalkGroupMember2.Aqh) || ((MultiTalkGroupMember) hashMap.get(multiTalkGroupMember2.Aqh)).status == 20) {
                        String str = multiTalkGroupMember2.Aqh;
                        Toast.makeText(ah.getContext(), j.b(ah.getContext(), ah.getContext().getString(R.string.d3_, new Object[]{s.mJ(str)})), 0).show();
                    }
                }
            }
            this.oGh = multiTalkGroup;
            bRI();
            sort();
            AppMethodBeat.o(53962);
            return true;
        } else {
            ab.e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", j.h(this.oGh), j.h(multiTalkGroup));
            AppMethodBeat.o(53962);
            return false;
        }
    }

    private void sort() {
        AppMethodBeat.i(53963);
        ab.v("MicroMsg.MT.MultiTalkManager", "before sort: %s", this.oGh.Aqg);
        LinkedList linkedList = new LinkedList();
        Object obj = null;
        for (MultiTalkGroupMember multiTalkGroupMember : this.oGh.Aqg) {
            if (multiTalkGroupMember.Aqh.equals(r.Yz())) {
                obj = multiTalkGroupMember;
            } else {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.i(53937);
                int i = -((MultiTalkGroupMember) obj).Aqh.compareTo(((MultiTalkGroupMember) obj2).Aqh);
                AppMethodBeat.o(53937);
                return i;
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
                MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
                if (multiTalkGroupMember.Api > multiTalkGroupMember2.Api) {
                    return -1;
                }
                if (multiTalkGroupMember.Api < multiTalkGroupMember2.Api) {
                    return 1;
                }
                return 0;
            }
        });
        Collections.sort(linkedList, new Comparator<MultiTalkGroupMember>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) obj;
                MultiTalkGroupMember multiTalkGroupMember2 = (MultiTalkGroupMember) obj2;
                if (!(multiTalkGroupMember.status == 10 && multiTalkGroupMember2.status == 10)) {
                    if (multiTalkGroupMember.status == 10) {
                        return -1;
                    }
                    if (multiTalkGroupMember.status == 10) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        if (obj != null) {
            linkedList.add(obj);
        }
        this.oGh.Aqg = linkedList;
        ab.v("MicroMsg.MT.MultiTalkManager", "after sort: %s", this.oGh.Aqg);
        AppMethodBeat.o(53963);
    }

    private void bRI() {
        AppMethodBeat.i(53964);
        for (MultiTalkGroupMember multiTalkGroupMember : this.oGh.Aqg) {
            if (multiTalkGroupMember.status != 10 && this.oGf.remove(multiTalkGroupMember.Aqh)) {
                ab.i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", multiTalkGroupMember.Aqh);
            }
        }
        AppMethodBeat.o(53964);
    }

    public final void b(Activity activity, String str, String str2) {
        AppMethodBeat.i(53965);
        String str3 = "MicroMsg.MT.MultiTalkManager";
        String str4 = "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.eif);
        objArr[1] = Boolean.valueOf(this.oGb);
        objArr[2] = Boolean.valueOf(this.oGe);
        objArr[3] = this.oGg.toString();
        objArr[4] = Boolean.valueOf(this.oGh == null);
        ab.i(str3, str4, objArr);
        e.bRt();
        if (bRR()) {
            com.tencent.mm.ui.base.h.g(activity, R.string.cdn, R.string.tz);
            AppMethodBeat.o(53965);
        } else if (d.cLw()) {
            com.tencent.mm.ui.base.h.g(activity, R.string.cdr, R.string.tz);
            AppMethodBeat.o(53965);
        } else if (d.cLx()) {
            com.tencent.mm.ui.base.h.g(activity, R.string.cdq, R.string.tz);
            AppMethodBeat.o(53965);
        } else if (com.tencent.mm.bg.e.akK()) {
            com.tencent.mm.ui.base.h.g(activity, R.string.cdm, R.string.tz);
            AppMethodBeat.o(53965);
        } else if (d.cLy()) {
            com.tencent.mm.ui.base.h.g(activity, R.string.cdp, R.string.tz);
            AppMethodBeat.o(53965);
        } else if (bRd()) {
            com.tencent.mm.bg.e.a(activity, R.string.d2l, null);
            AppMethodBeat.o(53965);
        } else if (!this.oGn || System.currentTimeMillis() - this.oGo >= this.oGp) {
            this.oGn = false;
            ArrayList<String> P = bo.P(str.split(","));
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.Aqd = p.bSe().oFP.dPQ();
            multiTalkGroup.Aqe = str2;
            for (String str5 : P) {
                MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                multiTalkGroupMember.Aqh = str5;
                if (str5.equals(r.Yz())) {
                    multiTalkGroupMember.status = 10;
                } else {
                    multiTalkGroupMember.status = 1;
                }
                multiTalkGroup.Aqg.add(multiTalkGroupMember);
            }
            p.bSe().oFP.bR(bo.h((Integer) com.tencent.mm.kernel.g.RP().eJH.get(1)), r.Yz());
            if (p.bSe().oFP.f(multiTalkGroup.Aqd, str2, P)) {
                e.bRr();
            } else {
                e.bRs();
            }
            b(e.Creating);
            c(multiTalkGroup);
            AppMethodBeat.o(53965);
        } else {
            com.tencent.mm.bg.e.a(activity, R.string.d32, null);
            AppMethodBeat.o(53965);
        }
    }

    public final void h(boolean z, boolean z2, boolean z3) {
        int i = 4;
        AppMethodBeat.i(53966);
        ab.i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.FALSE, Boolean.valueOf(z3));
        p.bSf().stopRing();
        if (bRd()) {
            nw nwVar = new nw();
            nwVar.cKn.type = 2;
            com.tencent.mm.sdk.b.a.xxA.m(nwVar);
            String l = j.l(this.oGh);
            e.Sh(l);
            if (this.oGg != e.Talking) {
                boolean k = j.k(this.oGh);
                long totalTime = getTotalTime();
                if (!k) {
                    i = z2 ? totalTime >= 45 ? 6 : 8 : z ? 7 : z3 ? 10 : 0;
                } else if (!z2) {
                    i = z ? 1 : z3 ? 5 : 2;
                }
                e.a(k, totalTime, l, i);
            } else {
                e.zd(this.oGk);
                e.q((long) this.oGk, l);
            }
            e eVar = this.oGg;
            if (this.oGq != null) {
                this.oGq.bRe();
            }
            this.oGg = e.Init;
            bRQ();
            bGT();
            aKY();
            p.bSd().reset();
            p.bSg().bRZ();
            if (this.oGh != null) {
                a(this.oGh, eVar, z2);
                String str = this.oGh.Aqc;
                if (bo.isNullOrNil(str)) {
                    str = this.oGh.Aqd;
                }
                p.bSe().oFP.Sa(str);
                this.oGh = null;
            }
            this.oGd = 0;
            this.oGb = true;
            this.eif = false;
            this.oGe = true;
            this.oGj = 0;
            this.oGk = 0;
            this.oGf.clear();
            this.oGl = 0;
            com.tencent.mm.sdk.b.a.xxA.m(new ey());
        } else {
            bRQ();
            bGT();
            aKY();
            this.oGh = null;
            this.oGd = 0;
            this.oGj = 0;
            this.oGk = 0;
            this.oGf.clear();
            this.oGg = e.Init;
            this.oGl = 0;
        }
        bRO();
        AppMethodBeat.o(53966);
    }

    public final void c(String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.i(53967);
        if (!n.mr(str)) {
            ab.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", str);
            ao.a.flu.a(str, "", new ao.b.a() {
                public final void o(String str, boolean z) {
                }
            });
        }
        bi biVar = new bi();
        biVar.setType(64);
        biVar.eJ(System.currentTimeMillis());
        biVar.setStatus(6);
        biVar.hO(2);
        String mJ = s.mJ(str2);
        if (!(mJ == null || mJ.equals(""))) {
            str2 = mJ;
        }
        String str3 = str2 + ah.getContext().getString(R.string.d3d);
        biVar.setContent(str3);
        if (n.ms(str)) {
            biVar.ju(str);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar);
            com.tencent.mm.storage.ak aoZ = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().aoZ(str);
            if (aoZ != null) {
                if (z) {
                    aoZ.hM(aoZ.field_unReadCount + 1);
                }
                aoZ.setContent(str3);
                if (((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().a(aoZ, str) == -1) {
                    ab.e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(str)));
                }
                if (z2) {
                    ((aq) ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(biVar);
                    AppMethodBeat.o(53967);
                    return;
                }
            }
            aoZ = new com.tencent.mm.storage.ak();
            aoZ.setUsername(str);
            if (z) {
                aoZ.hM(1);
            }
            aoZ.setContent(str3);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XR().d(aoZ);
            if (z2) {
                ((aq) ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification()).a(biVar);
            }
        }
        AppMethodBeat.o(53967);
    }

    public static void Si(String str) {
        AppMethodBeat.i(53968);
        ab.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        bi biVar = new bi();
        biVar.setType(64);
        biVar.eJ(System.currentTimeMillis());
        biVar.setStatus(6);
        biVar.setContent(ah.getContext().getString(R.string.d3f));
        if (n.ms(str)) {
            biVar.ju(str);
            biVar.setContent(biVar.field_content);
            ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar);
        }
        AppMethodBeat.o(53968);
    }

    private static void a(MultiTalkGroup multiTalkGroup, e eVar, boolean z) {
        AppMethodBeat.i(53969);
        ab.i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        if (eVar == e.Inviting && z) {
            bi biVar = new bi();
            biVar.setType(64);
            biVar.eJ(System.currentTimeMillis());
            biVar.setStatus(6);
            biVar.setContent(ah.getContext().getString(R.string.d3f));
            if (n.ms(multiTalkGroup.Aqe)) {
                biVar.ju(multiTalkGroup.Aqe);
                biVar.setContent(biVar.field_content);
                ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bOr().Z(biVar);
            }
        }
        AppMethodBeat.o(53969);
    }

    public final void k(int i, Object obj) {
        int i2 = R.string.d2h;
        AppMethodBeat.i(53970);
        ab.i("MicroMsg.MT.MultiTalkManager", "onErr: %d", Integer.valueOf(i));
        com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(-1));
        com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(-1));
        switch (i) {
            case -14256:
                ab.i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
                i2 = R.string.d2c;
                if (!(obj == null || ((aa) obj) == null)) {
                    com.tencent.wecall.talkroom.model.a.dSR().ru(false);
                    break;
                }
            case -14255:
                String str;
                String str2 = "MicroMsg.MT.MultiTalkManager";
                String str3 = "onErr:MULTITALK_E_Talk_Enter_BannerClear  %d, currentMultiTalkGroup=%s,wxGroupId=%s";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = this.oGh;
                if (this.oGh != null) {
                    str = this.oGh.Aqe;
                } else {
                    str = "";
                }
                objArr[2] = str;
                ab.i(str2, str3, objArr);
                if (obj != null) {
                    aa aaVar = (aa) obj;
                    if (aaVar != null) {
                        ab.i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + aaVar.groupId);
                        if (aaVar.Amz != null) {
                            p.bSh().Sc(aaVar.Amz.AoT);
                            ab.i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + aaVar.Amz.AoT);
                        }
                        if (!p.bSe().oFP.Sa(aaVar.groupId)) {
                            ab.i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + aaVar.groupId);
                        }
                    }
                }
                i2 = R.string.d3b;
                break;
            case -1700:
                ab.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", obj);
                Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d24), 0).show();
                if (obj != null) {
                    i2 = ((Integer) obj).intValue();
                    if (i2 > 0) {
                        com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(i2));
                        com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(bo.yz()));
                    }
                }
                i2 = R.string.d24;
                break;
            case -1400:
                i2 = R.string.d2b;
                break;
            case VError.ERROR_BEAUTY_FACE_ATTR_NULL /*-1300*/:
                i2 = R.string.d2a;
                this.oGn = true;
                this.oGo = System.currentTimeMillis();
                if (obj != null) {
                    z zVar = (z) obj;
                    if (zVar != null) {
                        ab.i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + zVar.AnW);
                        if (zVar.AnW != 0) {
                            this.oGp = (long) (zVar.AnW * 1000);
                            break;
                        }
                    }
                }
                break;
            case VError.ERROR_STICKER_CREATE_FAIL /*-1200*/:
                i2 = R.string.d2_;
                break;
            case VError.ERROR_FILTER_CREATE_FAIL /*-1100*/:
                i2 = R.string.d29;
                break;
            case -1000:
                i2 = R.string.d28;
                break;
            case -900:
                i2 = R.string.d2k;
                break;
            case -800:
                i2 = R.string.d2j;
                break;
            case -700:
                i2 = R.string.d2i;
                break;
            case -500:
                i2 = R.string.d2g;
                break;
            case -401:
                ab.i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                i2 = R.string.d30;
                break;
            case -400:
                i2 = R.string.d2f;
                break;
            case -300:
                i2 = R.string.d2e;
                break;
            case -200:
                e.jm(false);
                i2 = R.string.d2d;
                break;
            case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                e.jl(false);
                i2 = R.string.d27;
                break;
        }
        if (this.oGq != null) {
            this.oGq.onError(i);
        }
        if (!(i == -800 || i == -500 || i == -1700)) {
            Toast.makeText(ah.getContext(), ah.getContext().getString(i2), 0).show();
            h(false, false, true);
        }
        AppMethodBeat.o(53970);
    }

    public final void b(final MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(53971);
        String str = "MicroMsg.MT.MultiTalkManager";
        String str2 = "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.eif);
        objArr[1] = Boolean.valueOf(this.oGb);
        objArr[2] = Boolean.valueOf(this.oGe);
        objArr[3] = this.oGg.toString();
        objArr[4] = Boolean.valueOf(this.oGh == null);
        ab.i(str, str2, objArr);
        e.bRu();
        if (com.tencent.mm.m.a.ME() || eA(ah.getContext())) {
            int i;
            ad aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(j.m(multiTalkGroup));
            if (com.tencent.mm.m.g.Nu().getInt("MultitalkBlockReceiver", 0) == 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0 || aoO == null || aoO.Oa()) {
                ab.i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(53950);
                        String str = multiTalkGroup.Aqc;
                        if (bo.isNullOrNil(str)) {
                            str = multiTalkGroup.Aqd;
                        }
                        p.bSe().oFP.Sa(str);
                        AppMethodBeat.o(53950);
                    }
                }, 1000);
                e.aR(3, j.l(multiTalkGroup));
                AppMethodBeat.o(53971);
                return;
            }
            if (!(bRd() || d.cLx() || d.cLw() || com.tencent.mm.bg.e.akK())) {
                if (((TelephonyManager) ah.getContext().getSystemService("phone")).getCallState() != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0 && !d.cLy() && com.tencent.mm.n.a.jh(aoO.field_type)) {
                    if (!n.mr(multiTalkGroup.Aqe)) {
                        ab.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", multiTalkGroup.Aqe);
                        ao.a.flu.a(multiTalkGroup.Aqe, "", null);
                    }
                    ab.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", j.h(multiTalkGroup));
                    b(e.Inviting);
                    e.aR(1, j.l(multiTalkGroup));
                    if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                        ab.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", str, r.Yz());
                        c(multiTalkGroup);
                    } else {
                        ab.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", str, r.Yz());
                        if (a(multiTalkGroup)) {
                            this.oGa = false;
                            bRJ();
                            arh();
                            AppMethodBeat.o(53971);
                            return;
                        }
                    }
                    AppMethodBeat.o(53971);
                    return;
                }
            }
            ab.i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", j.h(multiTalkGroup));
            if (!n.mr(multiTalkGroup.Aqe)) {
                ab.i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", multiTalkGroup.Aqe);
                ao.a.flu.a(multiTalkGroup.Aqe, "", new ao.b.a() {
                    public final void o(String str, boolean z) {
                    }
                });
            }
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(53951);
                    String str = multiTalkGroup.Aqc;
                    if (bo.isNullOrNil(str)) {
                        str = multiTalkGroup.Aqd;
                    }
                    p.bSe().oFP.Sa(str);
                    AppMethodBeat.o(53951);
                }
            }, 1000);
            e.aR(3, j.l(multiTalkGroup));
            AppMethodBeat.o(53971);
            return;
        }
        ab.i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.oGu == null && this.oGx.doT()) {
            this.oGu = multiTalkGroup;
            this.oGx.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            this.oGv = System.currentTimeMillis();
            h.pYm.a(500, 6, 1, false);
        }
        AppMethodBeat.o(53971);
    }

    private void c(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(53972);
        ab.c("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
        if (a(multiTalkGroup)) {
            this.oGa = false;
            bRJ();
            arh();
            com.tencent.mm.bp.d.b(ah.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
        }
        AppMethodBeat.o(53972);
    }

    public final void d(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(53974);
        e.aR(2, j.l(multiTalkGroup));
        a(multiTalkGroup, e.Inviting, true);
        AppMethodBeat.o(53974);
    }

    public final void e(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(53975);
        ab.i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", j.h(multiTalkGroup));
        e.jl(true);
        if (a(multiTalkGroup)) {
            bRK();
        }
        AppMethodBeat.o(53975);
    }

    public final void f(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(53976);
        ab.i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", j.h(multiTalkGroup));
        nw nwVar = new nw();
        nwVar.cKn.type = 1;
        com.tencent.mm.sdk.b.a.xxA.m(nwVar);
        e.jm(true);
        if (this.oGg != e.Inviting) {
            b(e.Starting);
            c(multiTalkGroup);
        }
        if (bRd() && a(multiTalkGroup)) {
            bRK();
        }
        AppMethodBeat.o(53976);
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.i(53978);
        ab.i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", j.h(multiTalkGroup));
        if (bRd() && a(multiTalkGroup)) {
            if (j.j(this.oGh)) {
                if (this.oGg != e.Talking && j.i(multiTalkGroup)) {
                    b(e.Talking);
                }
                if (this.oGq != null && j.c(this.oGg)) {
                    this.oGq.bRf();
                }
            } else if (this.oGg == e.Inviting) {
                h(false, true, false);
                AppMethodBeat.o(53978);
                return;
            } else {
                h(false, false, false);
                AppMethodBeat.o(53978);
                return;
            }
        }
        AppMethodBeat.o(53978);
    }

    public final void bRL() {
        AppMethodBeat.i(53979);
        ab.i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
        AppMethodBeat.o(53979);
    }

    public final void jg(boolean z) {
        AppMethodBeat.i(53980);
        this.eif = z;
        if (this.oGq != null) {
            this.oGq.jg(this.eif);
        }
        AppMethodBeat.o(53980);
    }

    private void jh(boolean z) {
        AppMethodBeat.i(53981);
        ab.i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", Boolean.valueOf(z));
        this.oGb = z;
        if (this.oGq != null) {
            this.oGq.jh(this.oGb);
        }
        AppMethodBeat.o(53981);
    }

    public final void bRM() {
        AppMethodBeat.i(53982);
        ab.i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", Integer.valueOf(this.oGd));
        AppMethodBeat.o(53982);
    }

    public final void bRN() {
        AppMethodBeat.i(53983);
        ab.i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
        AppMethodBeat.o(53983);
    }

    public final void ze(int i) {
        AppMethodBeat.i(53984);
        ab.i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(i)));
        if (i > 0) {
            this.oGt = true;
            AppMethodBeat.o(53984);
            return;
        }
        this.oGt = false;
        AppMethodBeat.o(53984);
    }

    public final void cr(List<am> list) {
        AppMethodBeat.i(53985);
        if (bRd()) {
            this.oGf.clear();
            ab.d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", list);
            for (am amVar : list) {
                if (amVar.Aoq == 2 || amVar.Aoq == 3) {
                    this.oGf.add(amVar.Aop);
                }
            }
            this.oGf.remove(r.Yz());
            ab.i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", this.oGf);
            if (this.oGi != null) {
                this.oGi.zi(this.oGf.size());
            }
            if (this.oGq != null) {
                this.oGq.bRg();
            }
        }
        AppMethodBeat.o(53985);
    }

    public final void jn(boolean z) {
        AppMethodBeat.i(53986);
        if (bRd()) {
            if (this.nvf) {
                AppMethodBeat.o(53986);
                return;
            }
            this.nvf = true;
            e.f(j.bRU(), p.bSf().bRF(), z);
            Toast.makeText(ah.getContext(), R.string.d2y, 0).show();
            String string = ah.getContext().getString(R.string.d21);
            String string2 = ah.getContext().getString(R.string.d33);
            Intent intent = new Intent();
            intent.setClass(ah.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(ah.getContext(), 43, intent, 134217728);
            int i = R.drawable.bdo;
            if (com.tencent.mm.compatible.util.d.fP(19)) {
                i = R.drawable.bdn;
            }
            v.c e = com.tencent.mm.bo.a.bt(ah.getContext(), "reminder_channel_id").g(string2).j(System.currentTimeMillis()).d(string).e(string2);
            e.EI = activity;
            final Notification c = d.c(e);
            c.icon = i;
            c.flags |= 32;
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(43, c, false);
            if (this.oGq != null) {
                this.oGq.bGZ();
            }
            al.d(new Runnable() {
                public final void run() {
                    String str;
                    AppMethodBeat.i(53954);
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    String str2 = "enterMainUiWxGroupId";
                    if (f.this.oGh != null) {
                        str = f.this.oGh.Aqe;
                    } else {
                        str = "";
                    }
                    intent.putExtra(str2, str);
                    intent.setClass(ah.getContext(), MultiTalkMainUI.class);
                    intent.putExtra("notification", c);
                    intent.putExtra("enterMainUiSource", 1);
                    com.tencent.mm.plugin.voip.b.cIk().a(intent, new com.tencent.mm.plugin.voip.ui.a() {
                        public final boolean bGV() {
                            AppMethodBeat.i(53952);
                            if (f.this.bRH() || f.this.bRc()) {
                                AppMethodBeat.o(53952);
                                return true;
                            }
                            AppMethodBeat.o(53952);
                            return false;
                        }

                        public final void a(Intent intent, com.tencent.mm.plugin.voip.ui.e eVar) {
                            AppMethodBeat.i(53953);
                            if (f.this.bRc()) {
                                int i = f.this.oGk;
                                eVar.abZ(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
                                AppMethodBeat.o(53953);
                                return;
                            }
                            eVar.abZ(ah.getContext().getString(R.string.d3o));
                            AppMethodBeat.o(53953);
                        }
                    });
                    f.g(f.this);
                    AppMethodBeat.o(53954);
                }
            });
        }
        AppMethodBeat.o(53986);
    }

    public final void bGT() {
        AppMethodBeat.i(53987);
        this.nvf = false;
        com.tencent.mm.plugin.voip.b.cIk().dismiss();
        ((NotificationManager) ah.getContext().getSystemService("notification")).cancel(43);
        bRO();
        AppMethodBeat.o(53987);
    }

    private void bRO() {
        AppMethodBeat.i(53988);
        try {
            ab.i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
            if (com.tencent.mm.compatible.util.d.iW(26) && this.oGw) {
                ah.getContext().unbindService(this);
                this.oGw = false;
            }
            AppMethodBeat.o(53988);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MT.MultiTalkManager", e, "unBind VoipSmallService error: %s", e.getMessage());
            AppMethodBeat.o(53988);
        }
    }

    public final void bRP() {
        AppMethodBeat.i(53989);
        ab.i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
        if (this.oGq == null) {
            ab.e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
            AppMethodBeat.o(53989);
        } else if (this.oGf.size() == 0) {
            ab.i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
            AppMethodBeat.o(53989);
        } else {
            if (this.oGi == null) {
                ab.i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", Integer.valueOf(this.oGf.size()));
                this.oGi = new l(this.oGq);
                this.oGi.zi(this.oGf.size());
            }
            if (!this.oGi.running) {
                this.oGi.start();
            }
            AppMethodBeat.o(53989);
        }
    }

    public final void bRQ() {
        AppMethodBeat.i(53990);
        ab.i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
        if (this.oGi != null) {
            this.oGi.stop();
            this.oGi = null;
        }
        AppMethodBeat.o(53990);
    }

    public final void jo(boolean z) {
        AppMethodBeat.i(53991);
        p.bSe().oFP.jo(z);
        jh(z);
        AppMethodBeat.o(53991);
    }

    public final boolean zf(int i) {
        AppMethodBeat.i(53992);
        if (bRH()) {
            ab.i("MicroMsg.MT.MultiTalkManager", "try switch to action : ".concat(String.valueOf(i)));
            ab.i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", Boolean.valueOf(p.bSe().oFP.zf(i)));
            int i2 = this.oGd;
            this.oGd = i;
            if (bRG()) {
                bRP();
            } else {
                bRQ();
            }
            if (!(this.oGq == null || i2 == this.oGd)) {
                this.oGq.eB(i2, this.oGd);
            }
            AppMethodBeat.o(53992);
            return r0;
        }
        AppMethodBeat.o(53992);
        return false;
    }

    public final boolean Sj(String str) {
        AppMethodBeat.i(53993);
        if (bRH()) {
            ab.i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(str)));
            boolean Sj = p.bSe().oFP.Sj(str);
            ab.i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: ".concat(String.valueOf(Sj)));
            AppMethodBeat.o(53993);
            return Sj;
        }
        AppMethodBeat.o(53993);
        return false;
    }

    private void b(e eVar) {
        boolean z = true;
        AppMethodBeat.i(53994);
        e eVar2 = this.oGg;
        this.oGg = eVar;
        if (eVar2 != eVar) {
            if (eVar == e.Talking) {
                nw nwVar = new nw();
                nwVar.cKn.type = 1;
                com.tencent.mm.sdk.b.a.xxA.m(nwVar);
                e.a(j.k(this.oGh), getTotalTime(), j.l(this.oGh));
                p.bSf().stopRing();
                if (g.KK().KV() || g.KK().KP()) {
                    z = false;
                }
                jo(z);
            }
            if (this.oGq != null) {
                this.oGq.a(eVar);
            }
        }
        AppMethodBeat.o(53994);
    }

    private void arh() {
        AppMethodBeat.i(53995);
        ab.i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
        if (this.oGr != null) {
            this.oGr.cancel();
            AppMethodBeat.o(53995);
            return;
        }
        this.oGj = System.currentTimeMillis();
        this.oGk = 0;
        this.oGr = new Timer();
        this.oGr.schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(53944);
                if (f.this.getTotalTime() >= 45000 && f.this.oGg != e.Talking) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(53942);
                            f.this.h(false, true, false);
                            AppMethodBeat.o(53942);
                        }
                    });
                }
                if (f.this.oGg == e.Talking) {
                    f.this.oGk = f.this.oGk + 1;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(53943);
                            if (f.this.oGg == e.Talking) {
                                com.tencent.mm.plugin.voip.b.cIk().Dq(f.this.oGk);
                                if (f.this.oGq != null) {
                                    f.this.oGq.bHa();
                                }
                            }
                            AppMethodBeat.o(53943);
                        }
                    });
                }
                AppMethodBeat.o(53944);
            }
        }, 1000, 1000);
        AppMethodBeat.o(53995);
    }

    private void aKY() {
        AppMethodBeat.i(53996);
        if (this.oGr != null) {
            this.oGr.cancel();
            this.oGr = null;
        }
        AppMethodBeat.o(53996);
    }

    public final void jp(boolean z) {
        AppMethodBeat.i(53997);
        if (this.oGa) {
            AppMethodBeat.o(53997);
            return;
        }
        this.nwe.ao(1, z);
        this.gar.requestFocus();
        this.oGa = true;
        AppMethodBeat.o(53997);
    }

    public final void stopRing() {
        AppMethodBeat.i(53998);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(53947);
                f.this.nwe.stop();
                f.this.oGa = false;
                f.this.gar.Mm();
                g.KK().setSpeakerphoneOn(f.this.oGb);
                AppMethodBeat.o(53947);
            }
        }, "MultiTalkManager_stop_ring");
        AppMethodBeat.o(53998);
    }

    private static boolean bRR() {
        boolean z;
        Exception e;
        AppMethodBeat.i(53999);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ah.getContext().getSystemService("phone");
            if (telephonyManager != null) {
                switch (telephonyManager.getCallState()) {
                    case 0:
                        z = false;
                        break;
                    case 1:
                    case 2:
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                try {
                    ab.i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", Integer.valueOf(r2));
                } catch (Exception e2) {
                    e = e2;
                    ab.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", e.getLocalizedMessage());
                    AppMethodBeat.o(53999);
                    return z;
                }
            }
            z = false;
        } catch (Exception e3) {
            e = e3;
            z = false;
            ab.e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", e.getLocalizedMessage());
            AppMethodBeat.o(53999);
            return z;
        }
        AppMethodBeat.o(53999);
        return z;
    }

    private static boolean eA(Context context) {
        AppMethodBeat.i(54000);
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            ab.d("MicroMsg.MT.MultiTalkManager", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                ab.i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
                AppMethodBeat.o(54000);
                return false;
            }
        }
        if (((KeyguardManager) ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            AppMethodBeat.o(54000);
            return false;
        }
        ab.i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
        AppMethodBeat.o(54000);
        return true;
    }

    public final void ji(boolean z) {
        AppMethodBeat.i(54001);
        if (p.bSf().bRH() && this.oGq != null) {
            ab.i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", Boolean.valueOf(z));
            this.oGq.ji(z);
        }
        AppMethodBeat.o(54001);
    }

    public final void jq(boolean z) {
        AppMethodBeat.i(54002);
        ab.c("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", Boolean.valueOf(z));
        this.oGc = z;
        AppMethodBeat.o(54002);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }

    private void bRJ() {
        f fVar;
        boolean z;
        f fVar2;
        AppMethodBeat.i(53973);
        if (this.oGg == e.Creating) {
            fVar = this;
        } else if (g.KK().KV() || g.KK().KP()) {
            fVar = this;
        } else {
            z = true;
            fVar2 = this;
            fVar2.oGb = z;
            this.eif = false;
            this.oGs = j.bRX();
            AppMethodBeat.o(53973);
        }
        z = false;
        fVar2 = fVar;
        fVar2.oGb = z;
        this.eif = false;
        this.oGs = j.bRX();
        AppMethodBeat.o(53973);
    }

    private void bRK() {
        AppMethodBeat.i(53977);
        if (j.i(this.oGh)) {
            b(e.Talking);
        } else {
            b(e.Starting);
        }
        if (this.oGq != null) {
            this.oGq.bNY();
            j.a bRX = j.bRX();
            if (bRX != this.oGs) {
                this.oGs = bRX;
            }
            AppMethodBeat.o(53977);
            return;
        }
        com.tencent.mm.bp.d.b(ah.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
        AppMethodBeat.o(53977);
    }
}
