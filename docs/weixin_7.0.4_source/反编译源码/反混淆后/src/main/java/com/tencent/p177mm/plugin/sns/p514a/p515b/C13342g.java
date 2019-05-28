package com.tencent.p177mm.plugin.sns.p514a.p515b;

import android.app.Activity;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C37755kw;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C29028a.C290291;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.C44104bl;
import com.tencent.p177mm.protocal.protobuf.C46529bo;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/* renamed from: com.tencent.mm.plugin.sns.a.b.g */
public final class C13342g implements C39725b {
    public static Map<String, Integer> qDT = new HashMap();
    private Activity activity;
    public int cvd = 0;
    public HashMap<String, Long> qDJ = new HashMap();
    public HashSet<Long> qDK = new HashSet();
    private Map<String, Long> qDL = new HashMap();
    private Map<String, Integer> qDM = new HashMap();
    private Map<String, C29028a> qDN = new HashMap();
    public HashSet<Long> qDO = new HashSet();
    public Map<Long, C3863h> qDP = new HashMap();
    public Map<Long, C3863h> qDQ = new HashMap();
    public Map<String, C13346a> qDR = new HashMap();
    private Map<String, Integer> qDS = new HashMap();
    private int qDU = 0;
    private View qDV = null;
    public Map<Long, Integer> qDW = new HashMap();
    public Map<Long, Integer> qDX = new HashMap();
    private int qDY = -1;
    private int qDc = 0;

    /* renamed from: com.tencent.mm.plugin.sns.a.b.g$a */
    static class C13346a {
        public String cOc;
        public int fPY;
        public int klY;
        public int position;
        public long qDh;
        public long qEe;
        public long qEf;
        public String qEg;
        public long qEh;
        public long qEi;
        public long qEj;

        public C13346a(long j, String str, int i, String str2, int i2, long j2, int i3) {
            this.qEe = j;
            this.qEf = j;
            this.cOc = str;
            this.position = i;
            this.qEg = str2;
            this.qDh = j2;
            this.klY = i2;
            this.fPY = i3;
        }
    }

    static {
        AppMethodBeat.m2504i(35743);
        AppMethodBeat.m2505o(35743);
    }

    /* renamed from: jN */
    public final boolean mo25438jN(long j) {
        AppMethodBeat.m2504i(35720);
        boolean contains = this.qDK.contains(Long.valueOf(j));
        AppMethodBeat.m2505o(35720);
        return contains;
    }

    /* renamed from: a */
    public final void mo25430a(int i, View view, Activity activity) {
        this.qDc = i;
        this.qDV = view;
        this.activity = activity;
    }

    public C13342g(int i) {
        AppMethodBeat.m2504i(35721);
        this.cvd = i;
        AppMethodBeat.m2505o(35721);
    }

    public final void onResume() {
        C13346a c13346a;
        AppMethodBeat.m2504i(35722);
        long yz = C5046bo.m7588yz();
        for (String str : this.qDR.keySet()) {
            c13346a = (C13346a) this.qDR.get(str);
            C4990ab.m7416i("MicroMsg.SnsAdStatistic", "onResume Key ".concat(String.valueOf(str)));
            c13346a.qEf = yz;
            C3863h c3863h = (C3863h) this.qDP.get(Long.valueOf(c13346a.qDh));
            if (c3863h != null) {
                c3863h.onResume();
            }
            c3863h = (C3863h) this.qDQ.get(Long.valueOf(c13346a.qDh));
            if (c3863h != null) {
                c3863h.onResume();
            }
        }
        for (Entry value : this.qDN.entrySet()) {
            C29028a c29028a = (C29028a) value.getValue();
            if (c29028a != null && C13373af.qKD) {
                c29028a.mo47107kG(false);
                if (!(C5046bo.isNullOrNil(c29028a.czD) || this.qDR.get(c29028a.czD) == null)) {
                    c13346a = (C13346a) this.qDR.get(c29028a.czD);
                    if (c29028a.cme()) {
                        c13346a.qEh = C5046bo.m7588yz();
                    }
                }
            }
        }
        AppMethodBeat.m2505o(35722);
    }

    /* renamed from: u */
    public final void mo25445u(final long j, final boolean z) {
        AppMethodBeat.m2504i(35723);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(35716);
                if (C13342g.this.mo25438jN(j)) {
                    C3863h c3863h;
                    C13342g c13342g = C13342g.this;
                    long j = j;
                    boolean z = z;
                    if (z) {
                        if (c13342g.qDQ.containsKey(Long.valueOf(j))) {
                            c3863h = (C3863h) c13342g.qDQ.get(Long.valueOf(j));
                        } else {
                            c3863h = new C3863h("timeline");
                        }
                    } else if (c13342g.qDP.containsKey(Long.valueOf(j))) {
                        c3863h = (C3863h) c13342g.qDP.get(Long.valueOf(j));
                    } else {
                        c3863h = new C3863h("timeline");
                    }
                    c3863h.qEk = 1;
                    c3863h.qEs.qFp++;
                    if (z) {
                        c13342g.qDQ.put(Long.valueOf(j), c3863h);
                        AppMethodBeat.m2505o(35716);
                        return;
                    }
                    c13342g.qDP.put(Long.valueOf(j), c3863h);
                }
                AppMethodBeat.m2505o(35716);
            }
        });
        AppMethodBeat.m2505o(35723);
    }

    /* renamed from: f */
    public final void mo25436f(long j, int i, boolean z) {
        AppMethodBeat.m2504i(35724);
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        C5004al.m7441d(new Runnable() {
            final /* synthetic */ boolean qEc = true;

            public final void run() {
                AppMethodBeat.m2504i(35717);
                C13342g.this.mo25432a(j2, i2, this.qEc, z2);
                AppMethodBeat.m2505o(35717);
            }
        });
        AppMethodBeat.m2505o(35724);
    }

    /* renamed from: v */
    public final void mo25446v(long j, boolean z) {
        AppMethodBeat.m2504i(35725);
        mo25432a(j, 0, z, false);
        AppMethodBeat.m2505o(35725);
    }

    /* renamed from: a */
    public final void mo25432a(long j, int i, boolean z, boolean z2) {
        C3863h c3863h;
        AppMethodBeat.m2504i(35726);
        if (z2) {
            if (this.qDQ.containsKey(Long.valueOf(j))) {
                c3863h = (C3863h) this.qDQ.get(Long.valueOf(j));
            } else {
                c3863h = new C3863h("timeline");
            }
        } else if (this.qDP.containsKey(Long.valueOf(j))) {
            c3863h = (C3863h) this.qDP.get(Long.valueOf(j));
        } else {
            c3863h = new C3863h("timeline");
        }
        if (i > 0) {
            c3863h.setDuration(i);
        }
        c3863h.qEk = z ? 1 : 0;
        if (z2) {
            this.qDQ.put(Long.valueOf(j), c3863h);
            AppMethodBeat.m2505o(35726);
            return;
        }
        this.qDP.put(Long.valueOf(j), c3863h);
        AppMethodBeat.m2505o(35726);
    }

    /* renamed from: w */
    public final void mo25447w(long j, boolean z) {
        AppMethodBeat.m2504i(35727);
        mo25434c(j, z, false);
        AppMethodBeat.m2505o(35727);
    }

    /* renamed from: c */
    public final void mo25434c(long j, boolean z, boolean z2) {
        C3863h c3863h;
        AppMethodBeat.m2504i(35728);
        if (z2) {
            if (this.qDQ.containsKey(Long.valueOf(j))) {
                c3863h = (C3863h) this.qDQ.get(Long.valueOf(j));
            } else {
                c3863h = new C3863h("timeline");
            }
        } else if (this.qDP.containsKey(Long.valueOf(j))) {
            c3863h = (C3863h) this.qDP.get(Long.valueOf(j));
        } else {
            c3863h = new C3863h("timeline");
        }
        if (z) {
            c3863h.qEs.qFs = 2;
        } else {
            c3863h.qEs.qFs = 1;
        }
        c3863h.qEs.qFt = 1;
        if (z2) {
            this.qDQ.put(Long.valueOf(j), c3863h);
            AppMethodBeat.m2505o(35728);
            return;
        }
        this.qDP.put(Long.valueOf(j), c3863h);
        AppMethodBeat.m2505o(35728);
    }

    /* renamed from: T */
    public final void mo25429T(long j, long j2) {
        AppMethodBeat.m2504i(35729);
        final long j3 = j;
        final long j4 = j2;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(35718);
                if (C13342g.this.mo25438jN(j3)) {
                    C13342g c13342g = C13342g.this;
                    long j = j4;
                    if (!c13342g.qDO.contains(Long.valueOf(j))) {
                        c13342g.qDO.add(Long.valueOf(j));
                    }
                }
                AppMethodBeat.m2505o(35718);
            }
        });
        AppMethodBeat.m2505o(35729);
    }

    /* renamed from: jO */
    public final boolean mo25439jO(long j) {
        AppMethodBeat.m2504i(35730);
        if (this.qDO.contains(Long.valueOf(j))) {
            AppMethodBeat.m2505o(35730);
            return true;
        }
        AppMethodBeat.m2505o(35730);
        return false;
    }

    /* renamed from: c */
    public final void mo25433c(long j, long j2, boolean z) {
        AppMethodBeat.m2504i(35731);
        final long j3 = j;
        final long j4 = j2;
        final boolean z2 = z;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(35719);
                if (C13342g.this.mo25438jN(j3)) {
                    C3863h c3863h;
                    C13342g c13342g = C13342g.this;
                    long j = j3;
                    long j2 = j4;
                    boolean z = z2;
                    if (z) {
                        if (c13342g.qDQ.containsKey(Long.valueOf(j))) {
                            c3863h = (C3863h) c13342g.qDQ.get(Long.valueOf(j));
                        } else {
                            c3863h = new C3863h("timeline");
                        }
                    } else if (c13342g.qDP.containsKey(Long.valueOf(j))) {
                        c3863h = (C3863h) c13342g.qDP.get(Long.valueOf(j));
                    } else {
                        c3863h = new C3863h("timeline");
                    }
                    if (c3863h.qEs.qFu == 0) {
                        c3863h.qEs.qFu = j2;
                    }
                    if (z) {
                        c13342g.qDQ.put(Long.valueOf(j), c3863h);
                        AppMethodBeat.m2505o(35719);
                        return;
                    }
                    c13342g.qDP.put(Long.valueOf(j), c3863h);
                }
                AppMethodBeat.m2505o(35719);
            }
        });
        AppMethodBeat.m2505o(35731);
    }

    /* renamed from: x */
    public final void mo25448x(long j, boolean z) {
        AppMethodBeat.m2504i(35732);
        Object obj;
        if (z) {
            if (this.qDQ.containsKey(Long.valueOf(j))) {
                obj = (C3863h) this.qDQ.get(Long.valueOf(j));
                obj.mo8566CI(0);
            } else {
                obj = new C3863h("timeline");
            }
            this.qDQ.put(Long.valueOf(j), obj);
            AppMethodBeat.m2505o(35732);
            return;
        }
        if (this.qDP.containsKey(Long.valueOf(j))) {
            obj = (C3863h) this.qDP.get(Long.valueOf(j));
            obj.mo8566CI(0);
        } else {
            obj = new C3863h("timeline");
        }
        this.qDP.put(Long.valueOf(j), obj);
        AppMethodBeat.m2505o(35732);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(35733);
        for (String str : this.qDR.keySet()) {
            C13346a c13346a = (C13346a) this.qDR.get(str);
            C4990ab.m7416i("MicroMsg.SnsAdStatistic", "onPause Key ".concat(String.valueOf(str)));
            c13346a.qEi += C5046bo.m7525az(c13346a.qEf);
            c13346a.qEf = 0;
            C3863h c3863h = (C3863h) this.qDP.get(Long.valueOf(c13346a.qDh));
            if (c3863h != null) {
                c3863h.fQd = C5046bo.m7588yz();
            }
            c3863h = (C3863h) this.qDQ.get(Long.valueOf(c13346a.qDh));
            if (c3863h != null) {
                c3863h.fQd = C5046bo.m7588yz();
            }
        }
        for (Entry value : this.qDN.entrySet()) {
            C29028a c29028a = (C29028a) value.getValue();
            if (c29028a != null && C13373af.qKD) {
                c29028a.mo47107kG(false);
                if (!(C5046bo.isNullOrNil(c29028a.czD) || this.qDR.get(c29028a.czD) == null)) {
                    C13346a c13346a2 = (C13346a) this.qDR.get(c29028a.czD);
                    if (c13346a2.qEh > 0) {
                        c13346a2.qEj += C5046bo.m7525az(c13346a2.qEh);
                        c13346a2.qEh = 0;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(35733);
    }

    /* renamed from: f */
    private C21980a m21442f(C46236n c46236n) {
        AppMethodBeat.m2504i(35734);
        C21980a cqr;
        if (c46236n == null) {
            AppMethodBeat.m2505o(35734);
            return null;
        } else if (this.cvd == 2) {
            cqr = c46236n.cqr();
            AppMethodBeat.m2505o(35734);
            return cqr;
        } else {
            cqr = c46236n.cqq();
            AppMethodBeat.m2505o(35734);
            return cqr;
        }
    }

    /* renamed from: g */
    private C1332b m21443g(C46236n c46236n) {
        AppMethodBeat.m2504i(35735);
        C1332b cqy;
        if (c46236n == null) {
            AppMethodBeat.m2505o(35735);
            return null;
        } else if (this.cvd == 2) {
            cqy = c46236n.crd().cqy();
            AppMethodBeat.m2505o(35735);
            return cqy;
        } else {
            cqy = c46236n.crd().cqw();
            AppMethodBeat.m2505o(35735);
            return cqy;
        }
    }

    /* renamed from: h */
    private C1332b m21444h(C46236n c46236n) {
        AppMethodBeat.m2504i(35736);
        C1332b cqz;
        if (c46236n == null) {
            AppMethodBeat.m2505o(35736);
            return null;
        } else if (this.cvd == 2) {
            cqz = c46236n.crd().cqz();
            AppMethodBeat.m2505o(35736);
            return cqz;
        } else {
            cqz = c46236n.crd().cqx();
            AppMethodBeat.m2505o(35736);
            return cqz;
        }
    }

    /* renamed from: a */
    public final void mo25431a(int i, String str, boolean z, View view, long j, cbf cbf, int i2, int i3) {
        int i4;
        AppMethodBeat.m2504i(35737);
        this.qDK.add(Long.valueOf(j));
        this.qDJ.put(str, Long.valueOf(j));
        if (this.qDY == -1) {
            if (this.activity == null) {
                i4 = -1;
            } else {
                i4 = C5222ae.m7947hA(this.activity);
            }
            this.qDY = i4;
        }
        C46236n YT = C13373af.cnF().mo62918YT(str);
        if (YT == null) {
            C4990ab.m7420w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!");
            AppMethodBeat.m2505o(35737);
            return;
        }
        String str2;
        C29028a c29028a;
        C3863h c3863h;
        C29028a c29028a2 = (C29028a) this.qDN.get(str);
        C21980a f = m21442f(YT);
        String str3 = "";
        if (f != null) {
            str2 = f.hnw;
        } else {
            str2 = str3;
        }
        if (c29028a2 == null && view != null && C13373af.qKD) {
            C29028a c29028a3 = new C29028a(f, str, j, view, this.qDc, this.qDV, this.qDY, i3, cbf, i, YT.cqo());
            c29028a3.qDo = System.currentTimeMillis();
            C13373af.bCo().post(new C290291());
            this.qDN.put(str, c29028a3);
            if (!this.qDW.containsKey(Long.valueOf(j))) {
                this.qDW.put(Long.valueOf(j), Integer.valueOf(YT.field_likeFlag == 1 ? 1 : 0));
            }
            c29028a = c29028a3;
        } else {
            c29028a = c29028a2;
        }
        if (i2 == 11 && YT.cqu().xfI.wbK.size() > 1) {
            if (this.qDQ.containsKey(Long.valueOf(j))) {
                c3863h = (C3863h) this.qDQ.get(Long.valueOf(j));
            } else {
                c3863h = new C3863h("timeline");
            }
            c3863h.qEm = C5046bo.m7588yz();
            this.qDQ.put(Long.valueOf(j), c3863h);
        }
        if (this.qDL.containsKey(str)) {
            long az = C5046bo.m7525az(((Long) this.qDL.get(str)).longValue());
            if (az < 1200000) {
                i4 = this.qDM.containsKey(str) ? ((Integer) this.qDM.get(str)).intValue() : 0;
                if (i4 >= 2) {
                    C4990ab.m7416i("MicroMsg.SnsAdStatistic", "passed localid " + str + " viewid " + str2 + " passedTime: " + az);
                    AppMethodBeat.m2505o(35737);
                    return;
                }
                this.qDM.put(str, Integer.valueOf(i4 + 1));
            } else {
                this.qDL.put(str, Long.valueOf(C5046bo.m7588yz()));
                this.qDM.put(str, Integer.valueOf(0));
            }
        }
        if (!this.qDR.containsKey(str)) {
            C1207m c39726d;
            this.qDR.put(str, new C13346a(C5046bo.m7588yz(), str, i, str2, i2, j, i3));
            C4990ab.m7416i("MicroMsg.SnsAdStatistic", "onAdAdded " + i + " " + str + "  isExposure: " + z);
            if (i2 == 9) {
                if (this.qDP.containsKey(Long.valueOf(j))) {
                    c3863h = (C3863h) this.qDP.get(Long.valueOf(j));
                } else {
                    c3863h = new C3863h("timeline");
                }
                c3863h.qEm = C5046bo.m7588yz();
                this.qDP.put(Long.valueOf(j), c3863h);
            } else if (i2 == 11 && YT.cqu().xfI.wbK.size() > 0 && ((bau) YT.cqu().xfI.wbK.get(0)).jCt == 6) {
                if (this.qDP.containsKey(Long.valueOf(j))) {
                    c3863h = (C3863h) this.qDP.get(Long.valueOf(j));
                } else {
                    c3863h = new C3863h("timeline");
                }
                c3863h.qEm = C5046bo.m7588yz();
                c3863h.qEr = true;
                this.qDP.put(Long.valueOf(j), c3863h);
            }
            if (!this.qDS.containsKey(str)) {
                C4990ab.m7416i("MicroMsg.SnsAdStatistic", "exposures item ".concat(String.valueOf(str)));
                this.qDS.put(str, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            }
            C21984b cqo = YT.cqo();
            TimeLineObject cqu = YT.cqu();
            C46529bo c46529bo = null;
            if (c29028a != null && C13373af.qKD) {
                c46529bo = c29028a.cmd();
            }
            C43570e crd = YT.crd();
            int i5 = 0;
            if (this.cvd == 0) {
                i5 = crd.field_exposureCount + 1;
                crd.field_exposureCount = i5;
                C13373af.cnI().mo10103c(crd, new String[0]);
            }
            if (cqo.coO()) {
                c39726d = new C39726d(str2, i3, c46529bo, 3, i5, YT.cre(), m21443g(YT), m21444h(YT));
            } else if (YT.crg()) {
                c39726d = new C39726d(str2, i3, 1, 0, null, c46529bo, 6, "", i5, YT.cre(), 0, 0, YT.field_likeFlag == 1 ? 2 : 1, m21443g(YT), m21444h(YT));
            } else if (YT.coP() || YT.coQ()) {
                if (cqu == null || cqu.xfI.wbJ != 15 || cqu.xfP == 1) {
                    c39726d = new C39726d(str2, i3, c46529bo, 4, i5, YT.cre(), m21443g(YT), m21444h(YT));
                } else {
                    c39726d = new C39726d(str2, i3, c46529bo, 5, i5, YT.cre(), m21443g(YT), m21444h(YT));
                }
            } else if (i2 == 9) {
                c39726d = new C39726d(str2, i3, c46529bo, 2, i5, YT.cre(), m21443g(YT), m21444h(YT));
            } else {
                c39726d = new C39726d(str2, i3, c46529bo, 1, i5, YT.cre(), m21443g(YT), m21444h(YT));
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c39726d, 0);
        }
        AppMethodBeat.m2505o(35737);
    }

    /* renamed from: j */
    public final void mo25437j(int i, String str, int i2) {
        int nextInt;
        int i3;
        long j;
        C3863h c3863h;
        String cmf;
        AppMethodBeat.m2504i(35738);
        if (this.qDJ.containsKey(str)) {
            this.qDK.remove(Long.valueOf(((Long) this.qDJ.remove(str)).longValue()));
        }
        C44104bl c44104bl = null;
        C46529bo c46529bo = null;
        C29028a c29028a = (C29028a) this.qDN.get(str);
        if (c29028a != null && C13373af.qKD) {
            c29028a.eTf = true;
            c29028a.qDp = System.currentTimeMillis();
            c29028a.qDH = 0;
            mo25442kH(false);
            if (c29028a.qDk < 0) {
                c29028a.qDF = 2;
            } else {
                c29028a.qDF = 1;
            }
            if (c29028a.qDm < 0) {
                c29028a.qDG = 2;
            } else {
                c29028a.qDG = 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C29036i.m46117jV(c29028a.qDh) + ",");
            stringBuilder.append(c29028a.qDg + ",");
            stringBuilder.append(c29028a.qDF + ",");
            stringBuilder.append(c29028a.qDG + ",");
            stringBuilder.append(c29028a.qDC + ",");
            stringBuilder.append(c29028a.qDD + ",");
            stringBuilder.append(c29028a.qDE + ",");
            stringBuilder.append(c29028a.qDo + ",");
            stringBuilder.append(c29028a.qDp + ",");
            if (c29028a.qDs > 0 && c29028a.qDv == 0) {
                c29028a.qDv = System.currentTimeMillis();
            }
            stringBuilder.append(c29028a.qDs + ",");
            stringBuilder.append(c29028a.qDv + ",");
            if (c29028a.qDy > 0 && c29028a.qDB == 0) {
                c29028a.qDB = System.currentTimeMillis();
            }
            stringBuilder.append(c29028a.qDy + ",");
            stringBuilder.append(c29028a.qDB);
            C13341f.m21440a(c29028a.qDh, stringBuilder);
            C4990ab.m7416i("MicroMsg.AdViewStatic", "report " + stringBuilder.toString());
            c44104bl = new C44104bl();
            c44104bl.vDI = c29028a.qDy;
            c44104bl.vDJ = c29028a.qDB;
            c44104bl.qDF = c29028a.qDF;
            c44104bl.qDG = c29028a.qDG;
            c44104bl.vDD = (float) c29028a.qDC;
            c44104bl.vDE = (float) c29028a.qDD;
            c44104bl.vDF = (float) c29028a.qDE;
            c44104bl.vDG = c29028a.qDs;
            c44104bl.vDH = c29028a.qDv;
            c44104bl.startTime = c29028a.qDo;
            c44104bl.endTime = c29028a.qDp;
            if (c29028a.qDj == null || !c29028a.qDj.coX()) {
                C13373af.cnz().mo25454e(12010, stringBuilder.toString());
            } else {
                C13373af.cnz().mo25454e(14648, stringBuilder.toString());
            }
            C37952b lY = C37952b.m64170lY(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
            lY.mo60722tx(C29036i.m46117jV(c29028a.qDh)).mo60722tx(c29028a.qDg).mo60720mb(c29028a.qDF).mo60720mb(c29028a.qDG).mo60720mb(c29028a.qDC).mo60720mb(c29028a.qDD).mo60720mb(c29028a.qDE).mo60722tx(c29028a.qDo).mo60722tx(c29028a.qDp).mo60722tx(c29028a.qDs).mo60722tx(c29028a.qDv).mo60722tx(c29028a.qDy).mo60722tx(c29028a.qDB);
            lY.ajK();
            C37755kw c37755kw = new C37755kw();
            c37755kw.cGO.position = c29028a.position;
            C4879a.xxA.mo10055m(c37755kw);
            if (C1947ae.gje) {
                nextInt = new Random(System.currentTimeMillis()).nextInt(2000) + 10;
                C4990ab.m7416i("MicroMsg.AdViewStatic", "run on test kv ".concat(String.valueOf(nextInt)));
                for (i3 = 0; i3 < nextInt; i3++) {
                    if (c29028a.qDj == null || !c29028a.qDj.coX()) {
                        C13373af.cnz().mo25454e(12010, stringBuilder.toString());
                    } else {
                        C13373af.cnz().mo25454e(14648, stringBuilder.toString());
                    }
                }
            }
            c46529bo = c29028a.cmd();
            this.qDN.remove(str);
        }
        i3 = 0;
        C46236n YT = C13373af.cnF().mo62918YT(str);
        if (YT != null) {
            if (this.qDQ.containsKey(Long.valueOf(YT.field_snsId)) && YT.cqu().xfI.wbJ == 27) {
                i3 = YT.field_likeFlag == 1 ? 2 : 1;
                int intValue = this.qDX.containsKey(Long.valueOf(YT.field_snsId)) ? ((Integer) this.qDX.get(Long.valueOf(YT.field_snsId))).intValue() : 0;
                if (this.qDW.containsKey(Long.valueOf(YT.field_snsId))) {
                    nextInt = ((Integer) this.qDW.get(Long.valueOf(YT.field_snsId))).intValue();
                } else {
                    nextInt = 0;
                }
                long j2 = 0;
                j = 0;
                long j3 = 0;
                c3863h = (C3863h) this.qDQ.remove(Long.valueOf(YT.field_snsId));
                if (c3863h != null) {
                    c3863h.mo8566CI(0);
                    c3863h.cmg();
                    j2 = (long) c3863h.qEq;
                    j = (long) c3863h.qEp;
                    j3 = c3863h.qEu * 1000;
                }
                String str2 = "%s,%s,%s,%s,%s,%s,%s,%s,%s";
                r9 = new Object[9];
                r9[0] = YT.cqu().f15074Id;
                r9[1] = YT.crc();
                r9[2] = String.valueOf(i2);
                r9[3] = String.valueOf(intValue);
                r9[4] = String.valueOf(nextInt);
                r9[5] = String.valueOf(j2);
                r9[6] = String.valueOf(j);
                r9[7] = String.valueOf(j3);
                r9[8] = YT.field_likeFlag == 1 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                C7060h.pYm.mo8374X(15155, String.format(str2, r9));
                C4990ab.m7417i("MicroMsg.SnsAdStatistic", "15155, %s", cmf);
                this.qDO.remove(Long.valueOf(YT.field_snsId));
                this.qDO.remove(Long.valueOf(YT.field_snsId + 1));
            }
            this.qDX.remove(Long.valueOf(YT.field_snsId));
            this.qDW.remove(Long.valueOf(YT.field_snsId));
        }
        int i4 = i3;
        if (this.qDR.containsKey(str)) {
            String str3 = "";
            if (m21442f(YT) != null) {
                str3 = m21442f(YT).hnw;
            }
            C13346a c13346a = (C13346a) this.qDR.remove(str);
            this.qDL.put(str, Long.valueOf(C5046bo.m7588yz()));
            if (c13346a == null) {
                AppMethodBeat.m2505o(35738);
                return;
            }
            j = C5046bo.m7525az(c13346a.qEe);
            if (c13346a.qEf > 0) {
                c13346a.qEi += C5046bo.m7525az(c13346a.qEf);
            }
            C4990ab.m7416i("MicroMsg.SnsAdStatistic", "onAdRemoved " + i + " " + str + " " + j + " ");
            if (YT == null) {
                AppMethodBeat.m2505o(35738);
                return;
            }
            int i5;
            String str4;
            String str5 = "";
            TimeLineObject cqu = YT.cqu();
            if (YT.cqo().coO()) {
                i5 = 3;
                str4 = str5;
            } else if (YT.crg()) {
                i5 = 6;
                c3863h = (C3863h) this.qDP.remove(Long.valueOf(c13346a.qDh));
                if (c3863h != null) {
                    if (YT.field_likeFlag == 0) {
                        c3863h.mo8566CI(0);
                    }
                    cmf = c3863h.cmf();
                } else {
                    cmf = str5;
                }
                str4 = cmf;
            } else if (YT.coP() || YT.coQ()) {
                if (cqu == null || cqu.xfI.wbJ != 15 || cqu.xfP == 1) {
                    i5 = 4;
                    str4 = str5;
                } else {
                    i5 = 5;
                    c3863h = (C3863h) this.qDP.remove(Long.valueOf(c13346a.qDh));
                    if (c3863h != null) {
                        c3863h.mo8566CI(0);
                        str5 = c3863h.cmf();
                    }
                    this.qDO.remove(Long.valueOf(c13346a.qDh));
                    str4 = str5;
                }
            } else if (c13346a.klY == 9) {
                i5 = 2;
                c3863h = (C3863h) this.qDP.remove(Long.valueOf(c13346a.qDh));
                if (c3863h != null) {
                    c3863h.mo8566CI(0);
                    str5 = c3863h.cmf();
                }
                this.qDO.remove(Long.valueOf(c13346a.qDh));
                str4 = str5;
            } else {
                i5 = 1;
                str4 = str5;
            }
            C1207m c39726d = new C39726d(str3, i2, 2, (int) j, c44104bl, c46529bo, i5, str4, -1, YT.cre(), (int) c13346a.qEi, (int) c13346a.qEj, i4, m21443g(YT), m21444h(YT));
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c39726d, 0);
            AppMethodBeat.m2505o(35738);
            return;
        }
        C4990ab.m7420w("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + i + " " + str);
        AppMethodBeat.m2505o(35738);
    }

    /* renamed from: kH */
    public final void mo25442kH(boolean z) {
        AppMethodBeat.m2504i(35739);
        C4990ab.m7417i("MicroMsg.SnsAdStatistic", "checkAd %s", Boolean.valueOf(z));
        for (Entry value : this.qDN.entrySet()) {
            C29028a c29028a = (C29028a) value.getValue();
            if (c29028a != null && C13373af.qKD) {
                c29028a.mo47107kG(z);
                if (!(C5046bo.isNullOrNil(c29028a.czD) || this.qDR.get(c29028a.czD) == null)) {
                    C13346a c13346a = (C13346a) this.qDR.get(c29028a.czD);
                    boolean cme = c29028a.cme();
                    if (cme && c13346a.qEh == 0) {
                        c13346a.qEh = C5046bo.m7588yz();
                    } else if (!cme && c13346a.qEh > 0) {
                        c13346a.qEj += C5046bo.m7525az(c13346a.qEh);
                        c13346a.qEh = 0;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(35739);
    }

    public final void clear() {
        AppMethodBeat.m2504i(35740);
        C4990ab.m7416i("MicroMsg.SnsAdStatistic", "clean the adRemove");
        for (String str : new HashSet(this.qDR.keySet())) {
            C13346a c13346a = (C13346a) this.qDR.get(str);
            mo25437j(c13346a.position, c13346a.cOc, c13346a.fPY);
        }
        for (String str2 : this.qDS.keySet()) {
            C43570e DG = C13373af.cnI().mo69170DG(C35002v.m57484Zn(str2));
            if (DG != null) {
                int intValue;
                C46236n cqB = DG.cqB();
                DG.field_localFlag |= 128;
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (this.qDS.containsKey(str2)) {
                    intValue = ((Integer) this.qDS.get(str2)).intValue();
                } else {
                    intValue = currentTimeMillis;
                }
                if (DG.field_exposureTime <= 0) {
                    DG.field_exposureTime = intValue;
                }
                cqB.field_localFlag |= 128;
                C13373af.cnF().mo62930b(cqB.field_snsId, cqB);
                C13373af.cnI().mo69172b(DG.field_snsId, DG);
            }
        }
        this.qDR.clear();
        this.qDS.clear();
        AppMethodBeat.m2505o(35740);
    }

    /* renamed from: jP */
    public final void mo25440jP(long j) {
        AppMethodBeat.m2504i(35741);
        int i = 0;
        if (this.qDW.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.qDW.get(Long.valueOf(j))).intValue();
        }
        this.qDW.put(Long.valueOf(j), Integer.valueOf(i + 1));
        AppMethodBeat.m2505o(35741);
    }

    /* renamed from: jQ */
    public final void mo25441jQ(long j) {
        AppMethodBeat.m2504i(35742);
        int i = 0;
        if (this.qDX.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.qDX.get(Long.valueOf(j))).intValue();
        }
        this.qDX.put(Long.valueOf(j), Integer.valueOf(i + 1));
        AppMethodBeat.m2505o(35742);
    }
}
