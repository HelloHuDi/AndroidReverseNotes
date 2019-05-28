package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C41764q;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C42808a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.BizTimeLineUI;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e.C35837a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35838f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.c */
public final class C2703c {
    private static HashSet<Long> jQP = new HashSet();
    private static HashSet<String> jQQ = new HashSet();
    private static Boolean jQV = null;
    private static Boolean jQW = null;
    public BizTimeLineUI jNd;
    private int jQM;
    private int jQN;
    public int jQO = 0;
    public List<C46627q> jQR = new LinkedList();
    private List<C46627q> jQS;
    private boolean jQT = false;
    public boolean jQU = false;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.c$2 */
    class C27042 implements Runnable {
        C27042() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14363);
            C2703c.this.jQT = false;
            if (C2703c.this.jNd == null || C2703c.this.jNd.isFinishing()) {
                AppMethodBeat.m2505o(14363);
            } else if (C2703c.aWV() && !C5023at.isWifi(C2703c.this.jNd)) {
                AppMethodBeat.m2505o(14363);
            } else if (C2703c.m4942c(C2703c.this)) {
                C46627q d = C2703c.m4943d(C2703c.this);
                if (d == null) {
                    C4990ab.m7418v("MicroMsg.BizTimeLineImgLoader", "not loading");
                    AppMethodBeat.m2505o(14363);
                    return;
                }
                C2703c.m4936a(C2703c.this, d);
                AppMethodBeat.m2505o(14363);
            } else {
                C4990ab.m7418v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
                AppMethodBeat.m2505o(14363);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.c$1 */
    class C27061 implements IdleHandler {
        C27061() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(14362);
            C2703c.this.mo6779KB();
            AppMethodBeat.m2505o(14362);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.c$5 */
    class C27085 implements Runnable {
        C27085() {
        }

        public final void run() {
            AppMethodBeat.m2504i(14367);
            if (C2703c.this.jNd == null || C2703c.this.jNd.isFinishing()) {
                AppMethodBeat.m2505o(14367);
                return;
            }
            C46627q aWT = C2703c.this.aWT();
            if (aWT == null) {
                AppMethodBeat.m2505o(14367);
                return;
            }
            final List ah = C41747z.aeX().mo64102ah(5, aWT.field_orderFlag);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(14366);
                    C2703c.this.jQR.clear();
                    C2703c.this.jQR.addAll(ah);
                    AppMethodBeat.m2505o(14366);
                }
            });
            AppMethodBeat.m2505o(14367);
        }
    }

    /* renamed from: d */
    static /* synthetic */ C46627q m4943d(C2703c c2703c) {
        AppMethodBeat.m2504i(14386);
        C46627q aWS = c2703c.aWS();
        AppMethodBeat.m2505o(14386);
        return aWS;
    }

    static {
        AppMethodBeat.m2504i(14388);
        AppMethodBeat.m2505o(14388);
    }

    public C2703c(BizTimeLineUI bizTimeLineUI, int i, int i2, List<C46627q> list) {
        AppMethodBeat.m2504i(14368);
        this.jNd = bizTimeLineUI;
        this.jQM = i;
        this.jQN = i2;
        this.jQS = list;
        if (this.jQS.size() <= 10) {
            Looper.myQueue().addIdleHandler(new C27061());
        }
        AppMethodBeat.m2505o(14368);
    }

    /* renamed from: a */
    public final void mo6781a(String str, ImageView imageView, int i, int i2, C35837a c35837a, boolean z) {
        String sy;
        AppMethodBeat.m2504i(14369);
        imageView.setContentDescription(this.jNd.getString(C25738R.string.al_));
        if (C41764q.ahs()) {
            sy = C41764q.m73703sy(str);
        } else {
            sy = str;
        }
        int i3 = z ? C25738R.drawable.axk : 0;
        int i4 = z ? C25738R.drawable.f6449ek : C25738R.drawable.f6453eo;
        int contentWidth = getContentWidth();
        C25815a ahp = C32291o.ahp();
        C17927a c17927a = new C17927a();
        c17927a.ePV = i4;
        c17927a.ePH = true;
        C17927a ct = c17927a.mo33448ct(contentWidth, i2);
        ct.ePX = String.valueOf(i3);
        ct.fGV = new C35838f();
        ct.ePJ = C30080q.m47642v(sy, i, "@T");
        ahp.mo43769a(sy, imageView, ct.ahG(), null, new C35836e(i3, contentWidth, i2, c35837a));
        AppMethodBeat.m2505o(14369);
    }

    /* renamed from: a */
    public final void mo6780a(String str, ImageView imageView, int i, int i2, int i3, String str2, C35837a c35837a) {
        String sy;
        AppMethodBeat.m2504i(14370);
        imageView.setContentDescription(this.jNd.getString(C25738R.string.al_));
        if (C41764q.ahs()) {
            sy = C41764q.m73703sy(str);
        } else {
            sy = str;
        }
        C25815a ahp = C32291o.ahp();
        C17927a c17927a = new C17927a();
        c17927a.ePV = C25738R.color.f11875k8;
        c17927a.ePH = true;
        c17927a = c17927a.mo33448ct(i2, i3);
        c17927a.fGV = new C35838f();
        c17927a.ePJ = C30080q.m47642v(sy, i, str2);
        ahp.mo43769a(sy, imageView, c17927a.ahG(), null, new C35836e(0, 0, 0, c35837a));
        AppMethodBeat.m2505o(14370);
    }

    public final int getContentWidth() {
        AppMethodBeat.m2504i(14371);
        int gd = C1338a.m2868gd(this.jNd) - ((int) (C1338a.getDensity(this.jNd) * 16.0f));
        AppMethodBeat.m2505o(14371);
        return gd;
    }

    public final void aWR() {
        AppMethodBeat.m2504i(14372);
        if (!C2703c.aWU()) {
            AppMethodBeat.m2505o(14372);
        } else if (this.jQT || this.jQU) {
            C4990ab.m7419v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", Boolean.valueOf(this.jQT), Boolean.valueOf(this.jQU));
            AppMethodBeat.m2505o(14372);
        } else {
            this.jQT = true;
            C4990ab.m7418v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
            C33720b.m55105a("BizTimeLineImgLoaderThread", new C27042(), 500);
            AppMethodBeat.m2505o(14372);
        }
    }

    /* renamed from: a */
    private boolean m4940a(String str, int i, String str2, final long j, final int i2, boolean z) {
        AppMethodBeat.m2504i(14373);
        if (C2703c.m4939a(str, i, str2, j, i2)) {
            AppMethodBeat.m2505o(14373);
            return false;
        }
        C4990ab.m7419v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.jNd);
        this.jQO++;
        if (i2 == 0 && z) {
            mo6781a(str, imageView, i, this.jQM, new C35837a() {
                public final void onFinish() {
                    AppMethodBeat.m2504i(14364);
                    C2703c.this.jQO = C2703c.this.jQO - 1;
                    C2703c.this.mo6785m(j, i2);
                    AppMethodBeat.m2505o(14364);
                }
            }, false);
        } else {
            mo6780a(str, imageView, i, this.jQN, this.jQN, str2, new C35837a() {
                public final void onFinish() {
                    AppMethodBeat.m2504i(14365);
                    C2703c.this.jQO = C2703c.this.jQO - 1;
                    C2703c.this.mo6785m(j, i2);
                    AppMethodBeat.m2505o(14365);
                }
            });
        }
        AppMethodBeat.m2505o(14373);
        return true;
    }

    /* renamed from: gL */
    private static void m4946gL(long j) {
        AppMethodBeat.m2504i(14374);
        jQP.add(Long.valueOf(j));
        AppMethodBeat.m2505o(14374);
    }

    /* renamed from: m */
    public final void mo6785m(long j, int i) {
        AppMethodBeat.m2504i(14376);
        C4990ab.m7419v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", Integer.valueOf(this.jQO));
        jQQ.add(j + "_" + i);
        if (this.jQO <= 0) {
            aWR();
        }
        AppMethodBeat.m2505o(14376);
    }

    /* renamed from: a */
    private static boolean m4939a(String str, int i, String str2, long j, int i2) {
        AppMethodBeat.m2504i(14377);
        if (jQQ.contains(j + "_" + i2)) {
            AppMethodBeat.m2505o(14377);
            return true;
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(14377);
            return false;
        } else {
            if (C41764q.ahs()) {
                str = C41764q.m73703sy(str);
            }
            if (C5730e.m8628ct(C30080q.m47642v(str, i, str2))) {
                jQQ.add(j + "_" + i2);
                AppMethodBeat.m2505o(14377);
                return true;
            }
            AppMethodBeat.m2505o(14377);
            return false;
        }
    }

    /* renamed from: KB */
    public final void mo6779KB() {
        AppMethodBeat.m2504i(14378);
        if (C2703c.aWU()) {
            C33720b.m55105a("BizTimeLineImgLoaderThread", new C27085(), 0);
            AppMethodBeat.m2505o(14378);
            return;
        }
        AppMethodBeat.m2505o(14378);
    }

    public final C46627q aWT() {
        AppMethodBeat.m2504i(14379);
        try {
            if (this.jQS.size() > 0) {
                C46627q c46627q = (C46627q) this.jQS.get(this.jQS.size() - 1);
                AppMethodBeat.m2505o(14379);
                return c46627q;
            }
        } catch (Throwable th) {
            C4990ab.m7421w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", th.getMessage());
        }
        AppMethodBeat.m2505o(14379);
        return null;
    }

    /* renamed from: sg */
    private C46627q m4947sg(int i) {
        AppMethodBeat.m2504i(14380);
        try {
            C46627q c46627q;
            if (i < this.jQS.size()) {
                c46627q = (C46627q) this.jQS.get(i);
                AppMethodBeat.m2505o(14380);
                return c46627q;
            }
            if (i < this.jQS.size() + this.jQR.size()) {
                c46627q = (C46627q) this.jQR.get(i - this.jQS.size());
                AppMethodBeat.m2505o(14380);
                return c46627q;
            }
            AppMethodBeat.m2505o(14380);
            return null;
        } catch (Throwable th) {
            C4990ab.m7421w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", th.getMessage());
        }
    }

    /* renamed from: a */
    public static boolean m4938a(C46627q c46627q, C32224p c32224p) {
        AppMethodBeat.m2504i(14381);
        if (c46627q == null || c32224p == null) {
            AppMethodBeat.m2505o(14381);
            return false;
        } else if (c32224p.type == 5 || c32224p.type == 10 || C42808a.m75913e(c46627q)) {
            AppMethodBeat.m2505o(14381);
            return true;
        } else {
            AppMethodBeat.m2505o(14381);
            return false;
        }
    }

    private static boolean aWU() {
        AppMethodBeat.m2504i(14382);
        if (jQV == null) {
            C2703c.aWW();
        }
        boolean booleanValue = jQV.booleanValue();
        AppMethodBeat.m2505o(14382);
        return booleanValue;
    }

    public static boolean aWV() {
        AppMethodBeat.m2504i(14383);
        if (jQW == null) {
            C2703c.aWW();
        }
        boolean booleanValue = jQW.booleanValue();
        AppMethodBeat.m2505o(14383);
        return booleanValue;
    }

    private static void aWW() {
        boolean z;
        AppMethodBeat.m2504i(14384);
        C5141c ll = C18624c.abi().mo17131ll("100461");
        if (ll.isValid() && "1".equals(ll.dru().get("isOpenBizMsgPreDownloadCover"))) {
            z = true;
        } else {
            z = false;
        }
        jQV = Boolean.valueOf(z);
        if (ll.isValid() && "1".equals(ll.dru().get("isOnlyPreloadInWifi"))) {
            z = true;
        } else {
            z = false;
        }
        jQW = Boolean.valueOf(z);
        C4990ab.m7417i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", jQV, jQW);
        AppMethodBeat.m2505o(14384);
    }

    private C46627q aWS() {
        AppMethodBeat.m2504i(14375);
        int i = 0;
        while (i < this.jQS.size() + this.jQR.size()) {
            try {
                C46627q sg = m4947sg(i);
                if (sg == null || !sg.drC() || sg.field_isRead == 1 || jQP.contains(Long.valueOf(sg.field_msgId))) {
                    i++;
                    C2703c.m4946gL(sg.field_msgId);
                } else {
                    C4990ab.m7419v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", Integer.valueOf(i), Long.valueOf(sg.field_msgId));
                    AppMethodBeat.m2505o(14375);
                    return sg;
                }
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(14375);
        return null;
    }

    /* renamed from: c */
    static /* synthetic */ boolean m4942c(C2703c c2703c) {
        int i;
        AppMethodBeat.m2504i(14385);
        int firstVisiblePosition = c2703c.jNd.jOm.getFirstVisiblePosition();
        int lastVisiblePosition = c2703c.jNd.jOm.getLastVisiblePosition();
        int i2 = firstVisiblePosition > 0 ? firstVisiblePosition - 1 : 0;
        if (lastVisiblePosition > 0) {
            i = lastVisiblePosition - 1;
        } else {
            boolean i3 = false;
        }
        for (int i4 = i2; i4 <= i3; i4++) {
            C46627q sg = c2703c.m4947sg(i4);
            if (!(sg == null || !sg.drC() || jQP.contains(Long.valueOf(sg.field_msgId)))) {
                LinkedList linkedList = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(sg.field_msgId, sg.field_content).fjr;
                if (C5046bo.m7548ek(linkedList)) {
                    continue;
                } else {
                    int i5;
                    firstVisiblePosition = linkedList.size();
                    if (sg.field_isExpand || firstVisiblePosition <= 2) {
                        i5 = firstVisiblePosition;
                    } else {
                        i5 = 2;
                    }
                    int i6 = 0;
                    while (i6 < i5) {
                        C32224p c32224p = (C32224p) linkedList.get(i6);
                        if (!C5046bo.isNullOrNil(c32224p.fjx)) {
                            lastVisiblePosition = sg.field_type;
                            String str = i6 == 0 ? "@T" : "@S";
                            if (i6 == 0) {
                                if (!(C2703c.m4939a(c32224p.fjx, lastVisiblePosition, str, sg.field_msgId, i6) || C2703c.m4939a(C1192l.m2619a(c32224p), lastVisiblePosition, "@S", sg.field_msgId, i6))) {
                                    AppMethodBeat.m2505o(14385);
                                    return false;
                                }
                            } else if (!C2703c.m4939a(c32224p.fjx, lastVisiblePosition, str, sg.field_msgId, i6)) {
                                AppMethodBeat.m2505o(14385);
                                return false;
                            }
                        }
                        i6++;
                    }
                    if (sg.field_isExpand || linkedList.size() <= 2) {
                        C2703c.m4946gL(sg.field_msgId);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(14385);
        return true;
    }
}
