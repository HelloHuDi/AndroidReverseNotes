package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.l;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.q;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class c {
    private static HashSet<Long> jQP = new HashSet();
    private static HashSet<String> jQQ = new HashSet();
    private static Boolean jQV = null;
    private static Boolean jQW = null;
    public BizTimeLineUI jNd;
    private int jQM;
    private int jQN;
    public int jQO = 0;
    public List<q> jQR = new LinkedList();
    private List<q> jQS;
    private boolean jQT = false;
    public boolean jQU = false;

    static /* synthetic */ q d(c cVar) {
        AppMethodBeat.i(14386);
        q aWS = cVar.aWS();
        AppMethodBeat.o(14386);
        return aWS;
    }

    static {
        AppMethodBeat.i(14388);
        AppMethodBeat.o(14388);
    }

    public c(BizTimeLineUI bizTimeLineUI, int i, int i2, List<q> list) {
        AppMethodBeat.i(14368);
        this.jNd = bizTimeLineUI;
        this.jQM = i;
        this.jQN = i2;
        this.jQS = list;
        if (this.jQS.size() <= 10) {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(14362);
                    c.this.KB();
                    AppMethodBeat.o(14362);
                    return false;
                }
            });
        }
        AppMethodBeat.o(14368);
    }

    public final void a(String str, ImageView imageView, int i, int i2, a aVar, boolean z) {
        String sy;
        AppMethodBeat.i(14369);
        imageView.setContentDescription(this.jNd.getString(R.string.al_));
        if (com.tencent.mm.at.q.ahs()) {
            sy = com.tencent.mm.at.q.sy(str);
        } else {
            sy = str;
        }
        int i3 = z ? R.drawable.axk : 0;
        int i4 = z ? R.drawable.ek : R.drawable.eo;
        int contentWidth = getContentWidth();
        com.tencent.mm.at.a.a ahp = o.ahp();
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        aVar2.ePV = i4;
        aVar2.ePH = true;
        com.tencent.mm.at.a.a.c.a ct = aVar2.ct(contentWidth, i2);
        ct.ePX = String.valueOf(i3);
        ct.fGV = new f();
        ct.ePJ = com.tencent.mm.pluginsdk.model.q.v(sy, i, "@T");
        ahp.a(sy, imageView, ct.ahG(), null, new e(i3, contentWidth, i2, aVar));
        AppMethodBeat.o(14369);
    }

    public final void a(String str, ImageView imageView, int i, int i2, int i3, String str2, a aVar) {
        String sy;
        AppMethodBeat.i(14370);
        imageView.setContentDescription(this.jNd.getString(R.string.al_));
        if (com.tencent.mm.at.q.ahs()) {
            sy = com.tencent.mm.at.q.sy(str);
        } else {
            sy = str;
        }
        com.tencent.mm.at.a.a ahp = o.ahp();
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        aVar2.ePV = R.color.k8;
        aVar2.ePH = true;
        aVar2 = aVar2.ct(i2, i3);
        aVar2.fGV = new f();
        aVar2.ePJ = com.tencent.mm.pluginsdk.model.q.v(sy, i, str2);
        ahp.a(sy, imageView, aVar2.ahG(), null, new e(0, 0, 0, aVar));
        AppMethodBeat.o(14370);
    }

    public final int getContentWidth() {
        AppMethodBeat.i(14371);
        int gd = com.tencent.mm.bz.a.gd(this.jNd) - ((int) (com.tencent.mm.bz.a.getDensity(this.jNd) * 16.0f));
        AppMethodBeat.o(14371);
        return gd;
    }

    public final void aWR() {
        AppMethodBeat.i(14372);
        if (!aWU()) {
            AppMethodBeat.o(14372);
        } else if (this.jQT || this.jQU) {
            ab.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext loading %b, onPause %b", Boolean.valueOf(this.jQT), Boolean.valueOf(this.jQU));
            AppMethodBeat.o(14372);
        } else {
            this.jQT = true;
            ab.v("MicroMsg.BizTimeLineImgLoader", "preLoadNext");
            b.a("BizTimeLineImgLoaderThread", new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14363);
                    c.this.jQT = false;
                    if (c.this.jNd == null || c.this.jNd.isFinishing()) {
                        AppMethodBeat.o(14363);
                    } else if (c.aWV() && !at.isWifi(c.this.jNd)) {
                        AppMethodBeat.o(14363);
                    } else if (c.c(c.this)) {
                        q d = c.d(c.this);
                        if (d == null) {
                            ab.v("MicroMsg.BizTimeLineImgLoader", "not loading");
                            AppMethodBeat.o(14363);
                            return;
                        }
                        c.a(c.this, d);
                        AppMethodBeat.o(14363);
                    } else {
                        ab.v("MicroMsg.BizTimeLineImgLoader", "not all visibleItem loaded");
                        AppMethodBeat.o(14363);
                    }
                }
            }, 500);
            AppMethodBeat.o(14372);
        }
    }

    private boolean a(String str, int i, String str2, final long j, final int i2, boolean z) {
        AppMethodBeat.i(14373);
        if (a(str, i, str2, j, i2)) {
            AppMethodBeat.o(14373);
            return false;
        }
        ab.v("MicroMsg.BizTimeLineImgLoader", "doPreLoadNext pos %d", Integer.valueOf(i2));
        ImageView imageView = new ImageView(this.jNd);
        this.jQO++;
        if (i2 == 0 && z) {
            a(str, imageView, i, this.jQM, new a() {
                public final void onFinish() {
                    AppMethodBeat.i(14364);
                    c.this.jQO = c.this.jQO - 1;
                    c.this.m(j, i2);
                    AppMethodBeat.o(14364);
                }
            }, false);
        } else {
            a(str, imageView, i, this.jQN, this.jQN, str2, new a() {
                public final void onFinish() {
                    AppMethodBeat.i(14365);
                    c.this.jQO = c.this.jQO - 1;
                    c.this.m(j, i2);
                    AppMethodBeat.o(14365);
                }
            });
        }
        AppMethodBeat.o(14373);
        return true;
    }

    private static void gL(long j) {
        AppMethodBeat.i(14374);
        jQP.add(Long.valueOf(j));
        AppMethodBeat.o(14374);
    }

    public final void m(long j, int i) {
        AppMethodBeat.i(14376);
        ab.v("MicroMsg.BizTimeLineImgLoader", "onLoadFinish mLoadingCount %d", Integer.valueOf(this.jQO));
        jQQ.add(j + "_" + i);
        if (this.jQO <= 0) {
            aWR();
        }
        AppMethodBeat.o(14376);
    }

    private static boolean a(String str, int i, String str2, long j, int i2) {
        AppMethodBeat.i(14377);
        if (jQQ.contains(j + "_" + i2)) {
            AppMethodBeat.o(14377);
            return true;
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(14377);
            return false;
        } else {
            if (com.tencent.mm.at.q.ahs()) {
                str = com.tencent.mm.at.q.sy(str);
            }
            if (com.tencent.mm.vfs.e.ct(com.tencent.mm.pluginsdk.model.q.v(str, i, str2))) {
                jQQ.add(j + "_" + i2);
                AppMethodBeat.o(14377);
                return true;
            }
            AppMethodBeat.o(14377);
            return false;
        }
    }

    public final void KB() {
        AppMethodBeat.i(14378);
        if (aWU()) {
            b.a("BizTimeLineImgLoaderThread", new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14367);
                    if (c.this.jNd == null || c.this.jNd.isFinishing()) {
                        AppMethodBeat.o(14367);
                        return;
                    }
                    q aWT = c.this.aWT();
                    if (aWT == null) {
                        AppMethodBeat.o(14367);
                        return;
                    }
                    final List ah = z.aeX().ah(5, aWT.field_orderFlag);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(14366);
                            c.this.jQR.clear();
                            c.this.jQR.addAll(ah);
                            AppMethodBeat.o(14366);
                        }
                    });
                    AppMethodBeat.o(14367);
                }
            }, 0);
            AppMethodBeat.o(14378);
            return;
        }
        AppMethodBeat.o(14378);
    }

    public final q aWT() {
        AppMethodBeat.i(14379);
        try {
            if (this.jQS.size() > 0) {
                q qVar = (q) this.jQS.get(this.jQS.size() - 1);
                AppMethodBeat.o(14379);
                return qVar;
            }
        } catch (Throwable th) {
            ab.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", th.getMessage());
        }
        AppMethodBeat.o(14379);
        return null;
    }

    private q sg(int i) {
        AppMethodBeat.i(14380);
        try {
            q qVar;
            if (i < this.jQS.size()) {
                qVar = (q) this.jQS.get(i);
                AppMethodBeat.o(14380);
                return qVar;
            }
            if (i < this.jQS.size() + this.jQR.size()) {
                qVar = (q) this.jQR.get(i - this.jQS.size());
                AppMethodBeat.o(14380);
                return qVar;
            }
            AppMethodBeat.o(14380);
            return null;
        } catch (Throwable th) {
            ab.w("MicroMsg.BizTimeLineImgLoader", "getItem error %s", th.getMessage());
        }
    }

    public static boolean a(q qVar, p pVar) {
        AppMethodBeat.i(14381);
        if (qVar == null || pVar == null) {
            AppMethodBeat.o(14381);
            return false;
        } else if (pVar.type == 5 || pVar.type == 10 || com.tencent.mm.plugin.brandservice.ui.b.a.e(qVar)) {
            AppMethodBeat.o(14381);
            return true;
        } else {
            AppMethodBeat.o(14381);
            return false;
        }
    }

    private static boolean aWU() {
        AppMethodBeat.i(14382);
        if (jQV == null) {
            aWW();
        }
        boolean booleanValue = jQV.booleanValue();
        AppMethodBeat.o(14382);
        return booleanValue;
    }

    public static boolean aWV() {
        AppMethodBeat.i(14383);
        if (jQW == null) {
            aWW();
        }
        boolean booleanValue = jQW.booleanValue();
        AppMethodBeat.o(14383);
        return booleanValue;
    }

    private static void aWW() {
        boolean z;
        AppMethodBeat.i(14384);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100461");
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
        ab.i("MicroMsg.BizTimeLineImgLoader", "BizTimeLineImg initABTest %b/%b", jQV, jQW);
        AppMethodBeat.o(14384);
    }

    private q aWS() {
        AppMethodBeat.i(14375);
        int i = 0;
        while (i < this.jQS.size() + this.jQR.size()) {
            try {
                q sg = sg(i);
                if (sg == null || !sg.drC() || sg.field_isRead == 1 || jQP.contains(Long.valueOf(sg.field_msgId))) {
                    i++;
                    gL(sg.field_msgId);
                } else {
                    ab.v("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo pos=%d,msg id=%d", Integer.valueOf(i), Long.valueOf(sg.field_msgId));
                    AppMethodBeat.o(14375);
                    return sg;
                }
            } catch (Exception e) {
                ab.w("MicroMsg.BizTimeLineImgLoader", "getNextPreloadInfo %s", e.getMessage());
            }
        }
        AppMethodBeat.o(14375);
        return null;
    }

    static /* synthetic */ boolean c(c cVar) {
        int i;
        AppMethodBeat.i(14385);
        int firstVisiblePosition = cVar.jNd.jOm.getFirstVisiblePosition();
        int lastVisiblePosition = cVar.jNd.jOm.getLastVisiblePosition();
        int i2 = firstVisiblePosition > 0 ? firstVisiblePosition - 1 : 0;
        if (lastVisiblePosition > 0) {
            i = lastVisiblePosition - 1;
        } else {
            boolean i3 = false;
        }
        for (int i4 = i2; i4 <= i3; i4++) {
            q sg = cVar.sg(i4);
            if (!(sg == null || !sg.drC() || jQP.contains(Long.valueOf(sg.field_msgId)))) {
                LinkedList linkedList = ((com.tencent.mm.plugin.biz.a.a) g.K(com.tencent.mm.plugin.biz.a.a.class)).b(sg.field_msgId, sg.field_content).fjr;
                if (bo.ek(linkedList)) {
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
                        p pVar = (p) linkedList.get(i6);
                        if (!bo.isNullOrNil(pVar.fjx)) {
                            lastVisiblePosition = sg.field_type;
                            String str = i6 == 0 ? "@T" : "@S";
                            if (i6 == 0) {
                                if (!(a(pVar.fjx, lastVisiblePosition, str, sg.field_msgId, i6) || a(l.a(pVar), lastVisiblePosition, "@S", sg.field_msgId, i6))) {
                                    AppMethodBeat.o(14385);
                                    return false;
                                }
                            } else if (!a(pVar.fjx, lastVisiblePosition, str, sg.field_msgId, i6)) {
                                AppMethodBeat.o(14385);
                                return false;
                            }
                        }
                        i6++;
                    }
                    if (sg.field_isExpand || linkedList.size() <= 2) {
                        gL(sg.field_msgId);
                    }
                }
            }
        }
        AppMethodBeat.o(14385);
        return true;
    }
}
