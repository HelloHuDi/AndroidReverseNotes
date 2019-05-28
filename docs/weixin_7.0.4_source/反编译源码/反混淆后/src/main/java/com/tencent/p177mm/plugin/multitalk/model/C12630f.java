package com.tencent.p177mm.plugin.multitalk.model;

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
import android.support.p057v4.app.C0363v.C0358c;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C42184aq;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p230g.p231a.C37750kc;
import com.tencent.p177mm.p230g.p231a.C37750kc.C18309b;
import com.tencent.p177mm.p230g.p231a.C41994ey;
import com.tencent.p177mm.p230g.p231a.C42033nw;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.multitalk.model.C34571j.C34570a;
import com.tencent.p177mm.plugin.multitalk.p459ui.MultiTalkMainUI;
import com.tencent.p177mm.plugin.multitalk.p459ui.widget.C46090e;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.p1417a.C29488d;
import com.tencent.p177mm.plugin.voip.p546ui.C14084a;
import com.tencent.p177mm.plugin.voip.p546ui.C46928e;
import com.tencent.p177mm.plugin.voip.video.C22470i;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24190am;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24209z;
import com.tencent.p659pb.common.p660b.p661a.C24202a.C24219aa;
import com.tencent.p659pb.talkroom.sdk.C24243a;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.p659pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.ttpic.VError;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.wecall.talkroom.model.C41112a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.mm.plugin.multitalk.model.f */
public final class C12630f implements ServiceConnection, C24243a {
    public boolean eif;
    private C45293b gar;
    private boolean nvf;
    public C22470i nwe;
    C4884c oGA = new C126354();
    private boolean oGa;
    public boolean oGb;
    boolean oGc;
    private int oGd;
    public boolean oGe = true;
    public HashSet<String> oGf = new HashSet();
    public C46090e oGg = C46090e.Init;
    public MultiTalkGroup oGh = null;
    private C21327l oGi;
    private long oGj = 0;
    public int oGk = 0;
    private int oGl = 0;
    private int oGm = 2;
    private boolean oGn = false;
    private long oGo = 0;
    private long oGp = 30000;
    public C46088b oGq;
    private Timer oGr;
    private C34570a oGs;
    public boolean oGt;
    MultiTalkGroup oGu = null;
    long oGv = 0;
    private boolean oGw = false;
    C7564ap oGx = new C7564ap(Looper.getMainLooper(), new C1262710(), true);
    private C7306ak oGy = new C7306ak(Looper.getMainLooper());
    BroadcastReceiver oGz = new C126322();

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$10 */
    class C1262710 implements C5015a {
        C1262710() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(53949);
            C4990ab.m7418v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
            if (C12630f.this.oGu == null) {
                C12630f.this.oGv = 0;
                C12630f.this.oGx.stopTimer();
                AppMethodBeat.m2505o(53949);
                return false;
            } else if (C12630f.m20613eB(C4996ah.getContext())) {
                C12630f.this.mo24568b(C12630f.this.oGu);
                C12630f.this.oGu = null;
                C12630f.this.oGv = 0;
                C12630f.this.oGx.stopTimer();
                C7060h.pYm.mo8378a(500, 7, 1, false);
                AppMethodBeat.m2505o(53949);
                return false;
            } else if (System.currentTimeMillis() - C12630f.this.oGv < 60000) {
                AppMethodBeat.m2505o(53949);
                return true;
            } else {
                C12630f.this.oGu = null;
                C12630f.this.oGv = 0;
                C12630f.this.oGx.stopTimer();
                AppMethodBeat.m2505o(53949);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$9 */
    class C126299 implements C9636a {
        C126299() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$1 */
    class C126311 implements Comparator<MultiTalkGroupMember> {
        C126311() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(53937);
            int i = -((MultiTalkGroupMember) obj).Aqh.compareTo(((MultiTalkGroupMember) obj2).Aqh);
            AppMethodBeat.m2505o(53937);
            return i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$2 */
    class C126322 extends BroadcastReceiver {

        /* renamed from: com.tencent.mm.plugin.multitalk.model.f$2$1 */
        class C126281 implements Runnable {
            C126281() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53938);
                C34570a bRX = C34571j.bRX();
                if (bRX != C12630f.this.oGs) {
                    C34570a i = C12630f.this.oGs;
                    C12630f.this.oGs = bRX;
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "steve: network change: %s -> %s", i.name(), C12630f.this.oGs.name());
                    C12630f.this.mo24599zf(C12630f.this.oGd);
                    if (C12630f.this.oGq != null) {
                        C12630f.this.oGq.mo36753a(C12630f.this.oGs);
                    }
                    AppMethodBeat.m2505o(53938);
                    return;
                }
                C12630f.this.mo24599zf(C12630f.this.oGd);
                C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "network not change: %s", C12630f.this.oGs.name());
                AppMethodBeat.m2505o(53938);
            }
        }

        /* renamed from: com.tencent.mm.plugin.multitalk.model.f$2$2 */
        class C126332 implements Runnable {
            C126332() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53939);
                C34572p.bSe().oFP.mo58372rn(false);
                if (C1407g.m2946KK() == null || !C1407g.m2946KK().mo4819KP()) {
                    C12630f.this.mo24591jo(C34572p.bSf().oGb);
                    AppMethodBeat.m2505o(53939);
                    return;
                }
                C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "is bluetooth can use and start bluetooth");
                C1407g.m2946KK().mo4817KM();
                AppMethodBeat.m2505o(53939);
            }
        }

        /* renamed from: com.tencent.mm.plugin.multitalk.model.f$2$3 */
        class C126343 implements Runnable {
            C126343() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53940);
                C34572p.bSe().oFP.mo58372rn(true);
                AppMethodBeat.m2505o(53940);
            }
        }

        C126322() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(53941);
            if (!C12630f.this.bRd()) {
                AppMethodBeat.m2505o(53941);
            } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                C12630f.this.oGy.removeCallbacksAndMessages(null);
                C12630f.this.oGy.postDelayed(new C126281(), 8000);
                AppMethodBeat.m2505o(53941);
            } else {
                C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "phone state %d", Integer.valueOf(C34571j.m56706z(context, intent)));
                if (C34571j.m56706z(context, intent) == 0) {
                    C5004al.m7441d(new C126332());
                    AppMethodBeat.m2505o(53941);
                    return;
                }
                C5004al.m7441d(new C126343());
                AppMethodBeat.m2505o(53941);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$4 */
    class C126354 extends C4884c<C37750kc> {
        C126354() {
            AppMethodBeat.m2504i(53945);
            this.xxI = C37750kc.class.getName().hashCode();
            AppMethodBeat.m2505o(53945);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53946);
            C37750kc c37750kc = (C37750kc) c4883b;
            if (c37750kc instanceof C37750kc) {
                C18309b c18309b;
                boolean bRd;
                switch (c37750kc.cFw.action) {
                    case 1:
                        c18309b = c37750kc.cFx;
                        bRd = C12630f.this.bRd();
                        break;
                    case 2:
                        c18309b = c37750kc.cFx;
                        C12630f c12630f = C12630f.this;
                        if (c12630f.oGq == null) {
                            bRd = false;
                            break;
                        }
                        bRd = c12630f.oGq.bRh();
                        break;
                }
                c18309b.cFy = bRd;
            }
            AppMethodBeat.m2505o(53946);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$3 */
    class C126363 extends TimerTask {

        /* renamed from: com.tencent.mm.plugin.multitalk.model.f$3$1 */
        class C126371 implements Runnable {
            C126371() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53942);
                C12630f.this.mo24587h(false, true, false);
                AppMethodBeat.m2505o(53942);
            }
        }

        /* renamed from: com.tencent.mm.plugin.multitalk.model.f$3$2 */
        class C126382 implements Runnable {
            C126382() {
            }

            public final void run() {
                AppMethodBeat.m2504i(53943);
                if (C12630f.this.oGg == C46090e.Talking) {
                    C43727b.cIk().mo63353Dq(C12630f.this.oGk);
                    if (C12630f.this.oGq != null) {
                        C12630f.this.oGq.bHa();
                    }
                }
                AppMethodBeat.m2505o(53943);
            }
        }

        C126363() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53944);
            if (C12630f.this.getTotalTime() >= 45000 && C12630f.this.oGg != C46090e.Talking) {
                C5004al.m7441d(new C126371());
            }
            if (C12630f.this.oGg == C46090e.Talking) {
                C12630f.this.oGk = C12630f.this.oGk + 1;
                C5004al.m7441d(new C126382());
            }
            AppMethodBeat.m2505o(53944);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$12 */
    class C1264012 implements C9636a {
        C1264012() {
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$5 */
    class C126435 implements Runnable {
        C126435() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53947);
            C12630f.this.nwe.stop();
            C12630f.this.oGa = false;
            C12630f.this.gar.mo73178Mm();
            C1407g.m2946KK().setSpeakerphoneOn(C12630f.this.oGb);
            AppMethodBeat.m2505o(53947);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$6 */
    public class C126446 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(53948);
            C12630f.this.nwe.stop();
            C12630f.this.nwe.mo38020Gx(1);
            AppMethodBeat.m2505o(53948);
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$7 */
    class C126457 implements Comparator<MultiTalkGroupMember> {
        C126457() {
        }

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
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.model.f$8 */
    class C126478 implements Comparator<MultiTalkGroupMember> {
        C126478() {
        }

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
    }

    /* renamed from: eB */
    static /* synthetic */ boolean m20613eB(Context context) {
        AppMethodBeat.m2504i(54003);
        boolean eA = C12630f.m20612eA(context);
        AppMethodBeat.m2505o(54003);
        return eA;
    }

    public C12630f() {
        AppMethodBeat.m2504i(53955);
        C4879a.xxA.mo10052c(this.oGA);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.intent.action.PHONE_STATE_2");
        intentFilter.addAction("android.intent.action.PHONE_STATE2");
        intentFilter.addAction("android.intent.action.PHONE_STATE_EXT");
        intentFilter.addAction("android.intent.action.DUAL_PHONE_STATE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        C4996ah.getContext().registerReceiver(this.oGz, intentFilter);
        this.nwe = new C22470i(C4996ah.getContext());
        this.gar = new C45293b(C4996ah.getContext());
        this.oGt = false;
        AppMethodBeat.m2505o(53955);
    }

    public final boolean bRF() {
        AppMethodBeat.m2504i(53956);
        C34571j.bRW();
        boolean zg = C34571j.m56707zg(this.oGd);
        AppMethodBeat.m2505o(53956);
        return zg;
    }

    public final boolean bRG() {
        AppMethodBeat.m2504i(53957);
        C34571j.bRW();
        boolean zh = C34571j.m56708zh(this.oGd);
        AppMethodBeat.m2505o(53957);
        return zh;
    }

    public final boolean bRd() {
        boolean z;
        AppMethodBeat.m2504i(53958);
        if (this.oGg == C46090e.Init || this.oGh == null) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7411d("MicroMsg.MT.MultiTalkManager", "isMultiTalkConnecting %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(53958);
        return z;
    }

    public final boolean bRH() {
        boolean z;
        AppMethodBeat.m2504i(53959);
        if (this.oGg == C46090e.Starting || this.oGg == C46090e.Talking) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7411d("MicroMsg.MT.MultiTalkManager", "isMultiTalkStarting %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(53959);
        return z;
    }

    public final boolean bRc() {
        boolean z;
        AppMethodBeat.m2504i(53960);
        if (this.oGg == C46090e.Talking) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7411d("MicroMsg.MT.MultiTalkManager", "isMultiTalkTalking %b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(53960);
        return z;
    }

    public final long getTotalTime() {
        AppMethodBeat.m2504i(53961);
        long currentTimeMillis = System.currentTimeMillis() - this.oGj;
        AppMethodBeat.m2505o(53961);
        return currentTimeMillis;
    }

    /* renamed from: a */
    private boolean m20605a(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(53962);
        if (!bRd()) {
            C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "first time update multitalk group: %s", C34571j.m56700h(multiTalkGroup));
            this.oGh = multiTalkGroup;
            this.oGk = 0;
            this.oGd = 1;
            this.oGf.clear();
            bRI();
            sort();
            AppMethodBeat.m2505o(53962);
            return true;
        } else if (C34571j.m56698a(multiTalkGroup, this.oGh)) {
            C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "update multitalk group: %s", C34571j.m56700h(multiTalkGroup));
            MultiTalkGroup multiTalkGroup2 = this.oGh;
            HashMap hashMap = new HashMap();
            for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.Aqg) {
                hashMap.put(multiTalkGroupMember.Aqh, multiTalkGroupMember);
            }
            for (MultiTalkGroupMember multiTalkGroupMember2 : multiTalkGroup2.Aqg) {
                if (!C1853r.m3846Yz().equals(multiTalkGroupMember2.Aqh) && C1853r.m3846Yz().equals(multiTalkGroupMember2.Aqi) && multiTalkGroupMember2.status == 1) {
                    if (!hashMap.containsKey(multiTalkGroupMember2.Aqh) || ((MultiTalkGroupMember) hashMap.get(multiTalkGroupMember2.Aqh)).status == 20) {
                        String str = multiTalkGroupMember2.Aqh;
                        Toast.makeText(C4996ah.getContext(), C44089j.m79292b(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d3_, new Object[]{C1854s.m3866mJ(str)})), 0).show();
                    }
                }
            }
            this.oGh = multiTalkGroup;
            bRI();
            sort();
            AppMethodBeat.m2505o(53962);
            return true;
        } else {
            C4990ab.m7413e("MicroMsg.MT.MultiTalkManager", "updateCurrentMultiTalkGroup: not same multitalk\ncurrentGroup=%s\nchangeGroup=%s", C34571j.m56700h(this.oGh), C34571j.m56700h(multiTalkGroup));
            AppMethodBeat.m2505o(53962);
            return false;
        }
    }

    private void sort() {
        AppMethodBeat.m2504i(53963);
        C4990ab.m7419v("MicroMsg.MT.MultiTalkManager", "before sort: %s", this.oGh.Aqg);
        LinkedList linkedList = new LinkedList();
        Object obj = null;
        for (MultiTalkGroupMember multiTalkGroupMember : this.oGh.Aqg) {
            if (multiTalkGroupMember.Aqh.equals(C1853r.m3846Yz())) {
                obj = multiTalkGroupMember;
            } else {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Collections.sort(linkedList, new C126311());
        Collections.sort(linkedList, new C126457());
        Collections.sort(linkedList, new C126478());
        if (obj != null) {
            linkedList.add(obj);
        }
        this.oGh.Aqg = linkedList;
        C4990ab.m7419v("MicroMsg.MT.MultiTalkManager", "after sort: %s", this.oGh.Aqg);
        AppMethodBeat.m2505o(53963);
    }

    private void bRI() {
        AppMethodBeat.m2504i(53964);
        for (MultiTalkGroupMember multiTalkGroupMember : this.oGh.Aqg) {
            if (multiTalkGroupMember.status != 10 && this.oGf.remove(multiTalkGroupMember.Aqh)) {
                C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "remove video user according group %s", multiTalkGroupMember.Aqh);
            }
        }
        AppMethodBeat.m2505o(53964);
    }

    /* renamed from: b */
    public final void mo24567b(Activity activity, String str, String str2) {
        AppMethodBeat.m2504i(53965);
        String str3 = "MicroMsg.MT.MultiTalkManager";
        String str4 = "createMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.eif);
        objArr[1] = Boolean.valueOf(this.oGb);
        objArr[2] = Boolean.valueOf(this.oGe);
        objArr[3] = this.oGg.toString();
        objArr[4] = Boolean.valueOf(this.oGh == null);
        C4990ab.m7417i(str3, str4, objArr);
        C12626e.bRt();
        if (C12630f.bRR()) {
            C30379h.m48467g(activity, C25738R.string.cdn, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(53965);
        } else if (C29488d.cLw()) {
            C30379h.m48467g(activity, C25738R.string.cdr, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(53965);
        } else if (C29488d.cLx()) {
            C30379h.m48467g(activity, C25738R.string.cdq, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(53965);
        } else if (C17981e.akK()) {
            C30379h.m48467g(activity, C25738R.string.cdm, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(53965);
        } else if (C29488d.cLy()) {
            C30379h.m48467g(activity, C25738R.string.cdp, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(53965);
        } else if (bRd()) {
            C17981e.m28295a(activity, C25738R.string.d2l, null);
            AppMethodBeat.m2505o(53965);
        } else if (!this.oGn || System.currentTimeMillis() - this.oGo >= this.oGp) {
            this.oGn = false;
            ArrayList<String> P = C5046bo.m7508P(str.split(","));
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.Aqd = C34572p.bSe().oFP.dPQ();
            multiTalkGroup.Aqe = str2;
            for (String str5 : P) {
                MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                multiTalkGroupMember.Aqh = str5;
                if (str5.equals(C1853r.m3846Yz())) {
                    multiTalkGroupMember.status = 10;
                } else {
                    multiTalkGroupMember.status = 1;
                }
                multiTalkGroup.Aqg.add(multiTalkGroupMember);
            }
            C34572p.bSe().oFP.mo58364bR(C5046bo.m7567h((Integer) C1720g.m3536RP().eJH.get(1)), C1853r.m3846Yz());
            if (C34572p.bSe().oFP.mo58369f(multiTalkGroup.Aqd, str2, P)) {
                C12626e.bRr();
            } else {
                C12626e.bRs();
            }
            m20607b(C46090e.Creating);
            m20609c(multiTalkGroup);
            AppMethodBeat.m2505o(53965);
        } else {
            C17981e.m28295a(activity, C25738R.string.d32, null);
            AppMethodBeat.m2505o(53965);
        }
    }

    /* renamed from: h */
    public final void mo24587h(boolean z, boolean z2, boolean z3) {
        int i = 4;
        AppMethodBeat.m2504i(53966);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "exitCurrentMultiTalk: isReject %b isMissCall %b isPhoneCall %b isNetworkError %b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.FALSE, Boolean.valueOf(z3));
        C34572p.bSf().stopRing();
        if (bRd()) {
            C42033nw c42033nw = new C42033nw();
            c42033nw.cKn.type = 2;
            C4879a.xxA.mo10055m(c42033nw);
            String l = C34571j.m56704l(this.oGh);
            C12626e.m20587Sh(l);
            if (this.oGg != C46090e.Talking) {
                boolean k = C34571j.m56703k(this.oGh);
                long totalTime = getTotalTime();
                if (!k) {
                    i = z2 ? totalTime >= 45 ? 6 : 8 : z ? 7 : z3 ? 10 : 0;
                } else if (!z2) {
                    i = z ? 1 : z3 ? 5 : 2;
                }
                C12626e.m20590a(k, totalTime, l, i);
            } else {
                C12626e.m20598zd(this.oGk);
                C12626e.m20596q((long) this.oGk, l);
            }
            C46090e c46090e = this.oGg;
            if (this.oGq != null) {
                this.oGq.bRe();
            }
            this.oGg = C46090e.Init;
            bRQ();
            bGT();
            aKY();
            C34572p.bSd().reset();
            C34572p.bSg().bRZ();
            if (this.oGh != null) {
                C12630f.m20604a(this.oGh, c46090e, z2);
                String str = this.oGh.Aqc;
                if (C5046bo.isNullOrNil(str)) {
                    str = this.oGh.Aqd;
                }
                C34572p.bSe().oFP.mo58357Sa(str);
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
            C4879a.xxA.mo10055m(new C41994ey());
        } else {
            bRQ();
            bGT();
            aKY();
            this.oGh = null;
            this.oGd = 0;
            this.oGj = 0;
            this.oGk = 0;
            this.oGf.clear();
            this.oGg = C46090e.Init;
            this.oGl = 0;
        }
        bRO();
        AppMethodBeat.m2505o(53966);
    }

    /* renamed from: c */
    public final void mo24580c(String str, String str2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(53967);
        if (!C37921n.m64067mr(str)) {
            C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", str);
            C26417a.flu.mo20966a(str, "", new C126299());
        }
        C7620bi c7620bi = new C7620bi();
        c7620bi.setType(64);
        c7620bi.mo14775eJ(System.currentTimeMillis());
        c7620bi.setStatus(6);
        c7620bi.mo14781hO(2);
        String mJ = C1854s.m3866mJ(str2);
        if (!(mJ == null || mJ.equals(""))) {
            str2 = mJ;
        }
        String str3 = str2 + C4996ah.getContext().getString(C25738R.string.d3d);
        c7620bi.setContent(str3);
        if (C37921n.m64068ms(str)) {
            c7620bi.mo14794ju(str);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
            C7617ak aoZ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ(str);
            if (aoZ != null) {
                if (z) {
                    aoZ.mo14748hM(aoZ.field_unReadCount + 1);
                }
                aoZ.setContent(str3);
                if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15767a(aoZ, str) == -1) {
                    C4990ab.m7412e("MicroMsg.MT.MultiTalkManager", "update cvs fail!!! for :".concat(String.valueOf(str)));
                }
                if (z2) {
                    ((C42184aq) ((C46115a) C1720g.m3530M(C46115a.class)).getNotification()).mo27972a(c7620bi);
                    AppMethodBeat.m2505o(53967);
                    return;
                }
            }
            aoZ = new C7617ak();
            aoZ.setUsername(str);
            if (z) {
                aoZ.mo14748hM(1);
            }
            aoZ.setContent(str3);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(aoZ);
            if (z2) {
                ((C42184aq) ((C46115a) C1720g.m3530M(C46115a.class)).getNotification()).mo27972a(c7620bi);
            }
        }
        AppMethodBeat.m2505o(53967);
    }

    /* renamed from: Si */
    public static void m20601Si(String str) {
        AppMethodBeat.m2504i(53968);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        C7620bi c7620bi = new C7620bi();
        c7620bi.setType(64);
        c7620bi.mo14775eJ(System.currentTimeMillis());
        c7620bi.setStatus(6);
        c7620bi.setContent(C4996ah.getContext().getString(C25738R.string.d3f));
        if (C37921n.m64068ms(str)) {
            c7620bi.mo14794ju(str);
            c7620bi.setContent(c7620bi.field_content);
            ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
        }
        AppMethodBeat.m2505o(53968);
    }

    /* renamed from: a */
    private static void m20604a(MultiTalkGroup multiTalkGroup, C46090e c46090e, boolean z) {
        AppMethodBeat.m2504i(53969);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "generateMsgExitMsg");
        if (c46090e == C46090e.Inviting && z) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.setType(64);
            c7620bi.mo14775eJ(System.currentTimeMillis());
            c7620bi.setStatus(6);
            c7620bi.setContent(C4996ah.getContext().getString(C25738R.string.d3f));
            if (C37921n.m64068ms(multiTalkGroup.Aqe)) {
                c7620bi.mo14794ju(multiTalkGroup.Aqe);
                c7620bi.setContent(c7620bi.field_content);
                ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
            }
        }
        AppMethodBeat.m2505o(53969);
    }

    /* renamed from: k */
    public final void mo24594k(int i, Object obj) {
        int i2 = C25738R.string.d2h;
        AppMethodBeat.m2504i(53970);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onErr: %d", Integer.valueOf(i));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(-1));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(-1));
        switch (i) {
            case -14256:
                C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "14256,other device has handle this!");
                i2 = C25738R.string.d2c;
                if (!(obj == null || ((C24219aa) obj) == null)) {
                    C41112a.dSR().mo41166ru(false);
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
                C4990ab.m7417i(str2, str3, objArr);
                if (obj != null) {
                    C24219aa c24219aa = (C24219aa) obj;
                    if (c24219aa != null) {
                        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "ErrorCode :-14255,now exitMultiTalk for groupId : " + c24219aa.groupId);
                        if (c24219aa.Amz != null) {
                            C34572p.bSh().mo55117Sc(c24219aa.Amz.AoT);
                            C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "cleanBanner for wxGroupId :" + c24219aa.Amz.AoT);
                        }
                        if (!C34572p.bSe().oFP.mo58357Sa(c24219aa.groupId)) {
                            C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "exit fail!!,now cleanBanner for groupId :" + c24219aa.groupId);
                        }
                    }
                }
                i2 = C25738R.string.d3b;
                break;
            case -1700:
                C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_SWITCHVIDEO_FAIL_DISABLE, disableTime: %s", obj);
                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d24), 0).show();
                if (obj != null) {
                    i2 = ((Integer) obj).intValue();
                    if (i2 > 0) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MULTITALK_DISABLE_TIME_INT_SYNC, Integer.valueOf(i2));
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_MULTITALK_DISABLE_TIMESTAMP_LONG_SYNC, Long.valueOf(C5046bo.m7588yz()));
                    }
                }
                i2 = C25738R.string.d24;
                break;
            case -1400:
                i2 = C25738R.string.d2b;
                break;
            case VError.ERROR_BEAUTY_FACE_ATTR_NULL /*-1300*/:
                i2 = C25738R.string.d2a;
                this.oGn = true;
                this.oGo = System.currentTimeMillis();
                if (obj != null) {
                    C24209z c24209z = (C24209z) obj;
                    if (c24209z != null) {
                        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "ErrorCode : -1300, now try set retrySeconds:" + c24209z.AnW);
                        if (c24209z.AnW != 0) {
                            this.oGp = (long) (c24209z.AnW * 1000);
                            break;
                        }
                    }
                }
                break;
            case VError.ERROR_STICKER_CREATE_FAIL /*-1200*/:
                i2 = C25738R.string.d2_;
                break;
            case VError.ERROR_FILTER_CREATE_FAIL /*-1100*/:
                i2 = C25738R.string.d29;
                break;
            case -1000:
                i2 = C25738R.string.d28;
                break;
            case -900:
                i2 = C25738R.string.d2k;
                break;
            case -800:
                i2 = C25738R.string.d2j;
                break;
            case -700:
                i2 = C25738R.string.d2i;
                break;
            case -500:
                i2 = C25738R.string.d2g;
                break;
            case -401:
                C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "onErr, MULTITALK_ERRORCODE_ENGINE_NETWORK_FAIL");
                i2 = C25738R.string.d30;
                break;
            case -400:
                i2 = C25738R.string.d2f;
                break;
            case -300:
                i2 = C25738R.string.d2e;
                break;
            case -200:
                C12626e.m20595jm(false);
                i2 = C25738R.string.d2d;
                break;
            case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                C12626e.m20594jl(false);
                i2 = C25738R.string.d27;
                break;
        }
        if (this.oGq != null) {
            this.oGq.onError(i);
        }
        if (!(i == -800 || i == -500 || i == -1700)) {
            Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(i2), 0).show();
            mo24587h(false, false, true);
        }
        AppMethodBeat.m2505o(53970);
    }

    /* renamed from: b */
    public final void mo24568b(final MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(53971);
        String str = "MicroMsg.MT.MultiTalkManager";
        String str2 = "onInviteMultiTalk All Var Value:\n isMute: %b isHandsFree: %b isCameraFace: %b multiTalkStatus: %s groupIsNull: %b";
        Object[] objArr = new Object[5];
        objArr[0] = Boolean.valueOf(this.eif);
        objArr[1] = Boolean.valueOf(this.oGb);
        objArr[2] = Boolean.valueOf(this.oGe);
        objArr[3] = this.oGg.toString();
        objArr[4] = Boolean.valueOf(this.oGh == null);
        C4990ab.m7417i(str, str2, objArr);
        C12626e.bRu();
        if (C37885a.m63952ME() || C12630f.m20612eA(C4996ah.getContext())) {
            int i;
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(C34571j.m56705m(multiTalkGroup));
            if (C26373g.m41964Nu().getInt("MultitalkBlockReceiver", 0) == 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0 || aoO == null || aoO.mo16698Oa()) {
                C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "not open multitalk receiver or black user");
                C5004al.m7442n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(53950);
                        String str = multiTalkGroup.Aqc;
                        if (C5046bo.isNullOrNil(str)) {
                            str = multiTalkGroup.Aqd;
                        }
                        C34572p.bSe().oFP.mo58357Sa(str);
                        AppMethodBeat.m2505o(53950);
                    }
                }, 1000);
                C12626e.m20591aR(3, C34571j.m56704l(multiTalkGroup));
                AppMethodBeat.m2505o(53971);
                return;
            }
            if (!(bRd() || C29488d.cLx() || C29488d.cLw() || C17981e.akK())) {
                if (((TelephonyManager) C4996ah.getContext().getSystemService("phone")).getCallState() != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0 && !C29488d.cLy() && C7486a.m12942jh(aoO.field_type)) {
                    if (!C37921n.m64067mr(multiTalkGroup.Aqe)) {
                        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", multiTalkGroup.Aqe);
                        C26417a.flu.mo20966a(multiTalkGroup.Aqe, "", null);
                    }
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: %s", C34571j.m56700h(multiTalkGroup));
                    m20607b(C46090e.Inviting);
                    C12626e.m20591aR(1, C34571j.m56704l(multiTalkGroup));
                    if (C7486a.m12942jh(aoO.field_type)) {
                        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk friend show invitingUI inviter=%s,currentuser=%s", str, C1853r.m3846Yz());
                        m20609c(multiTalkGroup);
                    } else {
                        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk nofriend do not show invitingUI  inviter=%s,currentuser=%s", str, C1853r.m3846Yz());
                        if (m20605a(multiTalkGroup)) {
                            this.oGa = false;
                            bRJ();
                            arh();
                            AppMethodBeat.m2505o(53971);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(53971);
                    return;
                }
            }
            C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onInviteMultiTalk: exit multitalk: %s", C34571j.m56700h(multiTalkGroup));
            if (!C37921n.m64067mr(multiTalkGroup.Aqe)) {
                C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "Get Chatroom When chatroom not in conversation %s", multiTalkGroup.Aqe);
                C26417a.flu.mo20966a(multiTalkGroup.Aqe, "", new C1264012());
            }
            C5004al.m7442n(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(53951);
                    String str = multiTalkGroup.Aqc;
                    if (C5046bo.isNullOrNil(str)) {
                        str = multiTalkGroup.Aqd;
                    }
                    C34572p.bSe().oFP.mo58357Sa(str);
                    AppMethodBeat.m2505o(53951);
                }
            }, 1000);
            C12626e.m20591aR(3, C34571j.m56704l(multiTalkGroup));
            AppMethodBeat.m2505o(53971);
            return;
        }
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "NotificationConfig.isNewVoipMsgNotification() is false and is not in foreground, now return.");
        if (this.oGu == null && this.oGx.doT()) {
            this.oGu = multiTalkGroup;
            this.oGx.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            this.oGv = System.currentTimeMillis();
            C7060h.pYm.mo8378a(500, 6, 1, false);
        }
        AppMethodBeat.m2505o(53971);
    }

    /* renamed from: c */
    private void m20609c(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(53972);
        C4990ab.m7409c("MicroMsg.MT.MultiTalkManager", "enterNewMultiTalk", new Object[0]);
        if (m20605a(multiTalkGroup)) {
            this.oGa = false;
            bRJ();
            arh();
            C25985d.m41467b(C4996ah.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
        }
        AppMethodBeat.m2505o(53972);
    }

    /* renamed from: d */
    public final void mo24582d(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(53974);
        C12626e.m20591aR(2, C34571j.m56704l(multiTalkGroup));
        C12630f.m20604a(multiTalkGroup, C46090e.Inviting, true);
        AppMethodBeat.m2505o(53974);
    }

    /* renamed from: e */
    public final void mo24583e(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(53975);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onCreateMultiTalk: %s", C34571j.m56700h(multiTalkGroup));
        C12626e.m20594jl(true);
        if (m20605a(multiTalkGroup)) {
            bRK();
        }
        AppMethodBeat.m2505o(53975);
    }

    /* renamed from: f */
    public final void mo24584f(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(53976);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onEnterMultiTalk: %s", C34571j.m56700h(multiTalkGroup));
        C42033nw c42033nw = new C42033nw();
        c42033nw.cKn.type = 1;
        C4879a.xxA.mo10055m(c42033nw);
        C12626e.m20595jm(true);
        if (this.oGg != C46090e.Inviting) {
            m20607b(C46090e.Starting);
            m20609c(multiTalkGroup);
        }
        if (bRd() && m20605a(multiTalkGroup)) {
            bRK();
        }
        AppMethodBeat.m2505o(53976);
    }

    /* renamed from: g */
    public final void mo24585g(MultiTalkGroup multiTalkGroup) {
        AppMethodBeat.m2504i(53978);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onMemberChange: %s", C34571j.m56700h(multiTalkGroup));
        if (bRd() && m20605a(multiTalkGroup)) {
            if (C34571j.m56702j(this.oGh)) {
                if (this.oGg != C46090e.Talking && C34571j.m56701i(multiTalkGroup)) {
                    m20607b(C46090e.Talking);
                }
                if (this.oGq != null && C34571j.m56699c(this.oGg)) {
                    this.oGq.bRf();
                }
            } else if (this.oGg == C46090e.Inviting) {
                mo24587h(false, true, false);
                AppMethodBeat.m2505o(53978);
                return;
            } else {
                mo24587h(false, false, false);
                AppMethodBeat.m2505o(53978);
                return;
            }
        }
        AppMethodBeat.m2505o(53978);
    }

    public final void bRL() {
        AppMethodBeat.m2504i(53979);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "onMultiTalkReady");
        AppMethodBeat.m2505o(53979);
    }

    /* renamed from: jg */
    public final void mo24588jg(boolean z) {
        AppMethodBeat.m2504i(53980);
        this.eif = z;
        if (this.oGq != null) {
            this.oGq.mo36767jg(this.eif);
        }
        AppMethodBeat.m2505o(53980);
    }

    /* renamed from: jh */
    private void m20619jh(boolean z) {
        AppMethodBeat.m2504i(53981);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onSpeakerStateChange %b", Boolean.valueOf(z));
        this.oGb = z;
        if (this.oGq != null) {
            this.oGq.mo36768jh(this.oGb);
        }
        AppMethodBeat.m2505o(53981);
    }

    public final void bRM() {
        AppMethodBeat.m2504i(53982);
        C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onSwitchMultiTalkVideoSuss currentVideoAction %d", Integer.valueOf(this.oGd));
        AppMethodBeat.m2505o(53982);
    }

    public final void bRN() {
        AppMethodBeat.m2504i(53983);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "onSubscribeLargeVideoSuss ");
        AppMethodBeat.m2505o(53983);
    }

    /* renamed from: ze */
    public final void mo24598ze(int i) {
        AppMethodBeat.m2504i(53984);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ".concat(String.valueOf(i)));
        if (i > 0) {
            this.oGt = true;
            AppMethodBeat.m2505o(53984);
            return;
        }
        this.oGt = false;
        AppMethodBeat.m2505o(53984);
    }

    /* renamed from: cr */
    public final void mo24581cr(List<C24190am> list) {
        AppMethodBeat.m2504i(53985);
        if (bRd()) {
            this.oGf.clear();
            C4990ab.m7411d("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange: %s", list);
            for (C24190am c24190am : list) {
                if (c24190am.Aoq == 2 || c24190am.Aoq == 3) {
                    this.oGf.add(c24190am.Aop);
                }
            }
            this.oGf.remove(C1853r.m3846Yz());
            C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "onVideoGroupMemberChange %s", this.oGf);
            if (this.oGi != null) {
                this.oGi.mo36751zi(this.oGf.size());
            }
            if (this.oGq != null) {
                this.oGq.bRg();
            }
        }
        AppMethodBeat.m2505o(53985);
    }

    /* renamed from: jn */
    public final void mo24590jn(boolean z) {
        AppMethodBeat.m2504i(53986);
        if (bRd()) {
            if (this.nvf) {
                AppMethodBeat.m2505o(53986);
                return;
            }
            this.nvf = true;
            C12626e.m20593f(C34571j.bRU(), C34572p.bSf().bRF(), z);
            Toast.makeText(C4996ah.getContext(), C25738R.string.d2y, 0).show();
            String string = C4996ah.getContext().getString(C25738R.string.d21);
            String string2 = C4996ah.getContext().getString(C25738R.string.d33);
            Intent intent = new Intent();
            intent.setClass(C4996ah.getContext(), MultiTalkMainUI.class);
            PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 43, intent, 134217728);
            int i = C25738R.drawable.bdo;
            if (C1443d.m3067fP(19)) {
                i = C25738R.drawable.bdn;
            }
            C0358c e = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(string2).mo626j(System.currentTimeMillis()).mo621d(string).mo623e(string2);
            e.f362EI = activity;
            final Notification c = C29488d.m46800c(e);
            c.icon = i;
            c.flags |= 32;
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41574a(43, c, false);
            if (this.oGq != null) {
                this.oGq.bGZ();
            }
            C5004al.m7441d(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.multitalk.model.f$14$1 */
                class C126421 implements C14084a {
                    C126421() {
                    }

                    public final boolean bGV() {
                        AppMethodBeat.m2504i(53952);
                        if (C12630f.this.bRH() || C12630f.this.bRc()) {
                            AppMethodBeat.m2505o(53952);
                            return true;
                        }
                        AppMethodBeat.m2505o(53952);
                        return false;
                    }

                    /* renamed from: a */
                    public final void mo24609a(Intent intent, C46928e c46928e) {
                        AppMethodBeat.m2504i(53953);
                        if (C12630f.this.bRc()) {
                            int i = C12630f.this.oGk;
                            c46928e.abZ(String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)}));
                            AppMethodBeat.m2505o(53953);
                            return;
                        }
                        c46928e.abZ(C4996ah.getContext().getString(C25738R.string.d3o));
                        AppMethodBeat.m2505o(53953);
                    }
                }

                public final void run() {
                    String str;
                    AppMethodBeat.m2504i(53954);
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    String str2 = "enterMainUiWxGroupId";
                    if (C12630f.this.oGh != null) {
                        str = C12630f.this.oGh.Aqe;
                    } else {
                        str = "";
                    }
                    intent.putExtra(str2, str);
                    intent.setClass(C4996ah.getContext(), MultiTalkMainUI.class);
                    intent.putExtra("notification", c);
                    intent.putExtra("enterMainUiSource", 1);
                    C43727b.cIk().mo63354a(intent, new C126421());
                    C12630f.m20615g(C12630f.this);
                    AppMethodBeat.m2505o(53954);
                }
            });
        }
        AppMethodBeat.m2505o(53986);
    }

    public final void bGT() {
        AppMethodBeat.m2504i(53987);
        this.nvf = false;
        C43727b.cIk().dismiss();
        ((NotificationManager) C4996ah.getContext().getSystemService("notification")).cancel(43);
        bRO();
        AppMethodBeat.m2505o(53987);
    }

    private void bRO() {
        AppMethodBeat.m2504i(53988);
        try {
            C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "unBindSmallServiceIfNeed");
            if (C1443d.m3068iW(26) && this.oGw) {
                C4996ah.getContext().unbindService(this);
                this.oGw = false;
            }
            AppMethodBeat.m2505o(53988);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MT.MultiTalkManager", e, "unBind VoipSmallService error: %s", e.getMessage());
            AppMethodBeat.m2505o(53988);
        }
    }

    public final void bRP() {
        AppMethodBeat.m2504i(53989);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "try to startNetworkReceiver");
        if (this.oGq == null) {
            C4990ab.m7412e("MicroMsg.MT.MultiTalkManager", "ui callback is null");
            AppMethodBeat.m2505o(53989);
        } else if (this.oGf.size() == 0) {
            C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "currentVideoUserSet.size() is 0,just return.");
            AppMethodBeat.m2505o(53989);
        } else {
            if (this.oGi == null) {
                C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "startNetworkReceiver: networkReceiver is null %d", Integer.valueOf(this.oGf.size()));
                this.oGi = new C21327l(this.oGq);
                this.oGi.mo36751zi(this.oGf.size());
            }
            if (!this.oGi.running) {
                this.oGi.start();
            }
            AppMethodBeat.m2505o(53989);
        }
    }

    public final void bRQ() {
        AppMethodBeat.m2504i(53990);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "try to stopNetworkReceiver");
        if (this.oGi != null) {
            this.oGi.stop();
            this.oGi = null;
        }
        AppMethodBeat.m2505o(53990);
    }

    /* renamed from: jo */
    public final void mo24591jo(boolean z) {
        AppMethodBeat.m2504i(53991);
        C34572p.bSe().oFP.mo58370jo(z);
        m20619jh(z);
        AppMethodBeat.m2505o(53991);
    }

    /* renamed from: zf */
    public final boolean mo24599zf(int i) {
        AppMethodBeat.m2504i(53992);
        if (bRH()) {
            C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "try switch to action : ".concat(String.valueOf(i)));
            C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "switchMultiTalkVideo %b", Boolean.valueOf(C34572p.bSe().oFP.mo58374zf(i)));
            int i2 = this.oGd;
            this.oGd = i;
            if (bRG()) {
                bRP();
            } else {
                bRQ();
            }
            if (!(this.oGq == null || i2 == this.oGd)) {
                this.oGq.mo36766eB(i2, this.oGd);
            }
            AppMethodBeat.m2505o(53992);
            return r0;
        }
        AppMethodBeat.m2505o(53992);
        return false;
    }

    /* renamed from: Sj */
    public final boolean mo24566Sj(String str) {
        AppMethodBeat.m2504i(53993);
        if (bRH()) {
            C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "ownerUserName : ".concat(String.valueOf(str)));
            boolean Sj = C34572p.bSe().oFP.mo58358Sj(str);
            C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "result of subscribeLargeVideo: ".concat(String.valueOf(Sj)));
            AppMethodBeat.m2505o(53993);
            return Sj;
        }
        AppMethodBeat.m2505o(53993);
        return false;
    }

    /* renamed from: b */
    private void m20607b(C46090e c46090e) {
        boolean z = true;
        AppMethodBeat.m2504i(53994);
        C46090e c46090e2 = this.oGg;
        this.oGg = c46090e;
        if (c46090e2 != c46090e) {
            if (c46090e == C46090e.Talking) {
                C42033nw c42033nw = new C42033nw();
                c42033nw.cKn.type = 1;
                C4879a.xxA.mo10055m(c42033nw);
                C12626e.m20589a(C34571j.m56703k(this.oGh), getTotalTime(), C34571j.m56704l(this.oGh));
                C34572p.bSf().stopRing();
                if (C1407g.m2946KK().mo4822KV() || C1407g.m2946KK().mo4819KP()) {
                    z = false;
                }
                mo24591jo(z);
            }
            if (this.oGq != null) {
                this.oGq.mo36754a(c46090e);
            }
        }
        AppMethodBeat.m2505o(53994);
    }

    private void arh() {
        AppMethodBeat.m2504i(53995);
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "startTimeCount");
        if (this.oGr != null) {
            this.oGr.cancel();
            AppMethodBeat.m2505o(53995);
            return;
        }
        this.oGj = System.currentTimeMillis();
        this.oGk = 0;
        this.oGr = new Timer();
        this.oGr.schedule(new C126363(), 1000, 1000);
        AppMethodBeat.m2505o(53995);
    }

    private void aKY() {
        AppMethodBeat.m2504i(53996);
        if (this.oGr != null) {
            this.oGr.cancel();
            this.oGr = null;
        }
        AppMethodBeat.m2505o(53996);
    }

    /* renamed from: jp */
    public final void mo24592jp(boolean z) {
        AppMethodBeat.m2504i(53997);
        if (this.oGa) {
            AppMethodBeat.m2505o(53997);
            return;
        }
        this.nwe.mo38022ao(1, z);
        this.gar.requestFocus();
        this.oGa = true;
        AppMethodBeat.m2505o(53997);
    }

    public final void stopRing() {
        AppMethodBeat.m2504i(53998);
        C7305d.post(new C126435(), "MultiTalkManager_stop_ring");
        AppMethodBeat.m2505o(53998);
    }

    private static boolean bRR() {
        boolean z;
        Exception e;
        AppMethodBeat.m2504i(53999);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) C4996ah.getContext().getSystemService("phone");
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
                    C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "TelephoneManager.callState is %d", Integer.valueOf(r2));
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.m7413e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", e.getLocalizedMessage());
                    AppMethodBeat.m2505o(53999);
                    return z;
                }
            }
            z = false;
        } catch (Exception e3) {
            e = e3;
            z = false;
            C4990ab.m7413e("MicroMsg.MT.MultiTalkManager", "get callState error , errMsg is %s", e.getLocalizedMessage());
            AppMethodBeat.m2505o(53999);
            return z;
        }
        AppMethodBeat.m2505o(53999);
        return z;
    }

    /* renamed from: eA */
    private static boolean m20612eA(Context context) {
        AppMethodBeat.m2504i(54000);
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            C4990ab.m7410d("MicroMsg.MT.MultiTalkManager", "topActivity:" + componentName.flattenToString());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "is in backGround.");
                AppMethodBeat.m2505o(54000);
                return false;
            }
        }
        if (((KeyguardManager) C4996ah.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            AppMethodBeat.m2505o(54000);
            return false;
        }
        C4990ab.m7416i("MicroMsg.MT.MultiTalkManager", "is in foreGround.");
        AppMethodBeat.m2505o(54000);
        return true;
    }

    /* renamed from: ji */
    public final void mo24589ji(boolean z) {
        AppMethodBeat.m2504i(54001);
        if (C34572p.bSf().bRH() && this.oGq != null) {
            C4990ab.m7417i("MicroMsg.MT.MultiTalkManager", "setHandFreeEnable: %s", Boolean.valueOf(z));
            this.oGq.mo36769ji(z);
        }
        AppMethodBeat.m2505o(54001);
    }

    /* renamed from: jq */
    public final void mo24593jq(boolean z) {
        AppMethodBeat.m2504i(54002);
        C4990ab.m7409c("MicroMsg.MT.MultiTalkManager", "setHandsFreeUIStatus: %s", Boolean.valueOf(z));
        this.oGc = z;
        AppMethodBeat.m2505o(54002);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }

    private void bRJ() {
        C12630f c12630f;
        boolean z;
        C12630f c12630f2;
        AppMethodBeat.m2504i(53973);
        if (this.oGg == C46090e.Creating) {
            c12630f = this;
        } else if (C1407g.m2946KK().mo4822KV() || C1407g.m2946KK().mo4819KP()) {
            c12630f = this;
        } else {
            z = true;
            c12630f2 = this;
            c12630f2.oGb = z;
            this.eif = false;
            this.oGs = C34571j.bRX();
            AppMethodBeat.m2505o(53973);
        }
        z = false;
        c12630f2 = c12630f;
        c12630f2.oGb = z;
        this.eif = false;
        this.oGs = C34571j.bRX();
        AppMethodBeat.m2505o(53973);
    }

    private void bRK() {
        AppMethodBeat.m2504i(53977);
        if (C34571j.m56701i(this.oGh)) {
            m20607b(C46090e.Talking);
        } else {
            m20607b(C46090e.Starting);
        }
        if (this.oGq != null) {
            this.oGq.bNY();
            C34570a bRX = C34571j.bRX();
            if (bRX != this.oGs) {
                this.oGs = bRX;
            }
            AppMethodBeat.m2505o(53977);
            return;
        }
        C25985d.m41467b(C4996ah.getContext(), "multitalk", ".ui.MultiTalkMainUI", new Intent());
        AppMethodBeat.m2505o(53977);
    }
}
