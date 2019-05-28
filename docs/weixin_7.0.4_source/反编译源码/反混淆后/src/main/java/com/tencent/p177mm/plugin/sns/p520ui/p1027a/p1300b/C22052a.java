package com.tencent.p177mm.plugin.sns.p520ui.p1027a.p1300b;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.widget.textview.C37873c;
import com.tencent.p177mm.kiss.widget.textview.C37874f;
import com.tencent.p177mm.kiss.widget.textview.C45415b;
import com.tencent.p177mm.kiss.widget.textview.C45416d;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.data.C43538d;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C39742m;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13427l;
import com.tencent.p177mm.plugin.sns.model.C13428m;
import com.tencent.p177mm.plugin.sns.model.C34955aj;
import com.tencent.p177mm.plugin.sns.model.C3889am.C3890a;
import com.tencent.p177mm.plugin.sns.model.C43555a;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C13698j;
import com.tencent.p177mm.plugin.sns.p520ui.C22055af;
import com.tencent.p177mm.plugin.sns.p520ui.C29198aw;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C35146c;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C35147e;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C39850b;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C39851d;
import com.tencent.p177mm.plugin.sns.p520ui.widget.C4100f;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C35169f.C35170a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.protobuf.C44105bp;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbb;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7309bd;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.vending.p638d.C5683b.C5682a;
import com.tencent.p177mm.vending.p644j.C5710a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.ui.a.b.a */
public abstract class C22052a extends C43587b {
    private boolean DEBUG = false;
    private C7309bd fnq;
    protected volatile String lQD = "";
    private Context mContext;
    private C46251au rES;
    private int rET = ((int) (System.currentTimeMillis() / 1000));
    private C7486a rEU;
    private boolean rEV = false;
    private volatile boolean rEW = false;
    private byte[] rEX = new byte[0];
    protected HashMap<String, String> rEY = new HashMap();
    public HashMap<String, Boolean> rEZ = new HashMap();
    private String rFa = "";
    private String rFb = "";
    protected volatile String rmL = "";
    private String ryC;

    /* renamed from: com.tencent.mm.plugin.sns.ui.a.b.a$1 */
    class C220531 extends C13698j {
        C220531() {
            super(null, 0, null);
        }

        /* renamed from: a */
        public final void mo25466a(View view, Object obj) {
            AppMethodBeat.m2504i(39953);
            C22052a.this.rES.rqd.cvd = 14;
            C22052a.this.rES.rqd.mo25466a(view, obj);
            AppMethodBeat.m2505o(39953);
        }
    }

    /* renamed from: Ep */
    public final /* synthetic */ Object mo37601Ep(int i) {
        return m33660Eo(i);
    }

    public /* synthetic */ void applyChangeSynchronized(Object obj) {
        Cursor cursor = (Cursor) obj;
        bIf();
        this.zXb = cursor;
    }

    public C22052a(C46236n c46236n) {
        super(c46236n);
        dLZ();
    }

    /* renamed from: a */
    public final void mo37606a(Context context, C46251au c46251au, String str) {
        this.mContext = context;
        this.rES = c46251au;
        this.ryC = str;
        C1720g.m3537RQ();
        this.fnq = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM();
    }

    /* renamed from: ZK */
    public final void mo37603ZK(String str) {
        this.rmL = str;
    }

    public final String cuO() {
        return this.lQD;
    }

    public final void ctK() {
        long j;
        looperCheckForVending();
        if (this.f16225c == 0) {
            j = 0;
        } else {
            int i = this.f16225c - 1;
            int i2 = 0;
            while (true) {
                C46236n c46236n = (C46236n) getItem(i);
                if (c46236n != null && !c46236n.mo74253DI(32) && c46236n.field_snsId != 0) {
                    C4990ab.m7417i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", Long.valueOf(c46236n.field_snsId), c46236n.field_stringSeq);
                    j = r4;
                    break;
                }
                i2++;
                int i3 = i - 1;
                if (i3 < 0 || i2 > 500) {
                    j = 0;
                } else {
                    i = i3;
                }
            }
            j = 0;
        }
        this.rEW = true;
        synchronized (this.rEX) {
            this.lQD = mo63009w(j, this.lQD);
        }
    }

    /* renamed from: PA */
    public final void mo37602PA() {
        looperCheckForVending();
        C4990ab.m7417i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", Boolean.valueOf(this.rEW));
        if (!this.rEW) {
            synchronized (this.rEX) {
                this.lQD = mo63009w(0, this.lQD);
            }
        }
    }

    /* renamed from: ZL */
    public final void mo37604ZL(String str) {
        synchronized (this.rEX) {
            this.lQD = str;
        }
    }

    public final String cuP() {
        return this.rmL;
    }

    public final void cuQ() {
        this.rEW = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0635  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x064f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0451  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0635  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x064f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Eo */
    private C13633av m33660Eo(int i) {
        if (i < 0) {
            return null;
        }
        C4990ab.m7417i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", Integer.valueOf(i));
        long currentTimeMillis = System.currentTimeMillis();
        C13633av c13633av = new C13633av();
        C46236n c46236n = (C46236n) super.getItem(i);
        if (c46236n == null) {
            C4990ab.printErrStackTrace("MicroMsg.SnsTimeLineVendingSide", new Throwable(), "mSnsInfo is null, index %s, count %s, why?", Integer.valueOf(i), Integer.valueOf(this.mCount));
            return c13633av;
        }
        String str;
        boolean z;
        CharSequence a;
        int viewWidth;
        int width;
        C37874f SO;
        String str2;
        C7486a aoN;
        String e;
        bav cqM;
        long currentTimeMillis2;
        TimeLineObject cqu = c46236n.cqu();
        cbf q = C34955aj.m57409q(c46236n);
        int E = C46251au.m86602E(c46236n);
        c13633av.auo = E;
        c13633av.rAt = c46236n.field_snsId;
        c13633av.rAx = c46236n.field_likeFlag;
        c13633av.rAy = c46236n.cqQ();
        if (c46236n.cqq() == null) {
            str = "";
        } else {
            str = c46236n.cqq().hnw;
        }
        c13633av.rAz = str;
        c13633av.qBY = c46236n;
        c13633av.qCc = cqu;
        c13633av.qBX = q;
        String str3 = c13633av.qCc.xfF;
        Context context = this.mContext;
        C35147e.cvB();
        float textSize = C35147e.getTextSize();
        if (((C35168e) C1720g.m3530M(C35168e.class)).getStoryBasicConfig().mo47460a(C35170a.TimeLine_Des)) {
            if (c13633av.qCc == null) {
                str = "";
            } else {
                str = c13633av.qCc.jBB;
            }
            if (C39732a.m67944Xu(str)) {
                z = true;
                a = C4100f.m6419a(context, str3, textSize, z);
                c13633av.rAq = a;
                viewWidth = C35147e.cvB().getViewWidth();
                if (i < this.rES.getCount()) {
                    C46236n c46236n2 = (C46236n) super.getItem(i);
                    if (c46236n2 != null && c46236n2.mo74253DI(32)) {
                        C21984b cqo = c46236n2.cqo();
                        if (cqo != null && cqo.qUG == 1) {
                            Iterator it;
                            C7616ad aoN2;
                            width = (((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - C1338a.fromDPToPix(this.mContext, 50)) - C1338a.fromDPToPix(this.mContext, 50)) - C1338a.fromDPToPix(this.mContext, 12)) - C1338a.fromDPToPix(this.mContext, 12);
                            if (this.DEBUG) {
                                C4990ab.m7410d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str3);
                            }
                            SO = C45416d.m83643a(a, width, C35147e.cvB().getTextViewConfig()).mo73210SO();
                            C37873c.eNj.mo60604a(C35147e.cvB().getTextViewConfig(), SO);
                            if (SO.eNO.getLineCount() > 7) {
                                C37873c.eNj.mo60604a(C35147e.cvB().cvC(), C45416d.m83643a(a, width, C35147e.cvB().cvC()).mo73210SO());
                            }
                            m33663a(i, c13633av);
                            if (c13633av.qBY.mo74253DI(32)) {
                                C13373af.cnC().mo37453b(c46236n, null);
                            } else {
                                C13373af.cnC().mo37433a(c46236n, null);
                            }
                            m33664e(c13633av.qCc);
                            str2 = c46236n.field_userName;
                            aoN = this.fnq.aoN(str2);
                            if (!C5046bo.isNullOrNil(str2)) {
                                C7486a c7486a;
                                if (!str2.equals(this.ryC)) {
                                    c7486a = aoN;
                                } else if (this.rEU == null) {
                                    this.rEU = aoN;
                                    c7486a = aoN;
                                } else {
                                    c7486a = this.rEU;
                                }
                                if (c7486a == null) {
                                    str = str2;
                                } else {
                                    str = c7486a.mo16707Oj();
                                }
                                if (c46236n.mo74253DI(32)) {
                                    C21984b cqo2 = c46236n.cqo();
                                    if (cqo2 != null) {
                                        if (cqo2.qVa) {
                                            str = cqo2.qVb;
                                        } else if (C5046bo.isNullOrNil(str) && !C5046bo.isNullOrNil(cqo2.nickname)) {
                                            str = cqo2.nickname;
                                        }
                                    }
                                }
                                c13633av.igi = str2;
                                c13633av.rAH = str;
                                c13633av.rgZ = c46236n.mo74253DI(32);
                                c13633av.riA = c46236n.cqU();
                                z = c7486a == null ? true : ((int) c7486a.ewQ) == 0;
                                c13633av.rAI = z;
                                c13633av.rAr = c7486a;
                            }
                            c13633av.rAs = c46236n.cqA();
                            c13633av.rAu = cqu.xfF;
                            c13633av.rAv = cqu.xfK;
                            c13633av.rAw = c46236n.field_createTime;
                            c13633av.rAA = C29198aw.m46373h(this.mContext, ((long) c13633av.rAw) * 1000);
                            c13633av.rAK = false;
                            if (!(E != 10 || C1853r.m3846Yz().equals(cqu.jBB) || q.xaE == null || q.xaE.xbg == 0)) {
                                c13633av.rAL = q.xaE.xbg;
                                c13633av.rAK = true;
                            }
                            if (c13633av.rgZ) {
                                C21980a cqq = c46236n.cqq();
                                if (cqq != null) {
                                    c13633av.rAN = cqq.qTD;
                                    if (C5046bo.isNullOrNil(cqq.qTE)) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    c13633av.rAO = z;
                                }
                            } else {
                                str = cqu.xfG == null ? null : cqu.xfG.guP;
                                str2 = cqu.xfG == null ? null : cqu.xfG.eUu;
                                if (C5046bo.isNullOrNil(str2)) {
                                    c13633av.rAN = str;
                                    c13633av.rAO = false;
                                } else {
                                    if (c46236n.field_snsId != 0 || C5046bo.isNullOrNil(str)) {
                                        c13633av.rAN = str2;
                                    } else {
                                        c13633av.rAN = str + "·" + str2;
                                    }
                                    c13633av.rAO = true;
                                }
                            }
                            e = m33664e(cqu);
                            if (!C24826a.gkF.mo38865dg(e) && C22052a.m33665f(cqu)) {
                                c13633av.rAP = true;
                                if (cqu.xfH == null) {
                                    z = false;
                                } else if (!this.rEZ.containsKey(cqu.xfH.f17242Id)) {
                                    boolean z2;
                                    if (!C46494g.m87744dk(cqu.xfH.f17242Id)) {
                                        z = C46494g.aiF(cqu.xfH.f17242Id);
                                        if (z) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                    } else if (cqu.xfH.vFy == 0) {
                                        z = false;
                                        z2 = false;
                                    } else {
                                        z = true;
                                        z2 = true;
                                    }
                                    this.rEZ.put(cqu.xfH.f17242Id, Boolean.valueOf(z));
                                    z = z2;
                                } else if (((Boolean) this.rEZ.get(cqu.xfH.f17242Id)).booleanValue()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                c13633av.mAppName = e;
                                c13633av.rAR = z;
                            } else if (C5046bo.isNullOrNil(cqu.xfJ) && C22052a.m33665f(cqu)) {
                                c13633av.mAppName = e;
                                c13633av.rAQ = true;
                                c13633av.rAT = cqu.vjM;
                                c13633av.rAS = cqu.xfJ;
                            } else {
                                c13633av.rAP = false;
                                c13633av.rAQ = false;
                            }
                            if (!(cqu.qNQ == null || C5046bo.isNullOrNil(cqu.qNQ.uaa))) {
                                c13633av.mAppName = this.mContext.getString(C25738R.string.exe);
                                c13633av.rAP = true;
                            }
                            z = c13633av.igi == null && c13633av.igi.equals(this.ryC);
                            c13633av.rAJ = z;
                            c13633av.rAV = c46236n.cqW();
                            c13633av.rAW = c46236n.cqM().wFm;
                            c13633av.rAX = false;
                            if (q != null && c13633av.rAJ) {
                                width = q.wGz;
                                if (width == 3 || width == 5) {
                                    c13633av.rAX = true;
                                }
                            }
                            if (q != null) {
                                Object obj;
                                cat cat;
                                C5682a c5682a;
                                C7616ad aoN3;
                                if (q.xaw.size() > 0) {
                                    if (!this.ryC.equals(q.vHl)) {
                                        Iterator it2 = q.xaw.iterator();
                                        while (it2.hasNext()) {
                                            if (this.ryC.equals(((cat) it2.next()).vHl)) {
                                                c13633av.rAY = true;
                                                c13633av.rBa = true;
                                                break;
                                            }
                                        }
                                    }
                                    c13633av.rAY = true;
                                    StringBuffer stringBuffer = new StringBuffer();
                                    it = q.xaw.iterator();
                                    obj = null;
                                    while (it.hasNext()) {
                                        cat = (cat) it.next();
                                        if (obj == null) {
                                            obj = 1;
                                            stringBuffer.append("  ");
                                        } else {
                                            stringBuffer.append(",  ");
                                        }
                                        if (cat.wCW != null) {
                                            stringBuffer.append(cat.wCW);
                                        } else {
                                            aoN2 = this.fnq.aoN(cat.vHl);
                                            stringBuffer.append(aoN2 == null ? cat.vHl : aoN2.mo16707Oj());
                                        }
                                    }
                                    c13633av.rAZ = stringBuffer.toString();
                                } else {
                                    c13633av.rAY = false;
                                }
                                if (q.xaE != null && C1853r.m3846Yz().equals(cqu.jBB) && q.xaE.xbg > 0) {
                                    c13633av.rBd = ((double) C39742m.m67969b(c46236n, q)) * 1.0d;
                                    c13633av.rBc = q.xaE.xbg;
                                    c13633av.rBb = true;
                                    c5682a = new C5682a();
                                    it = q.xaE.xbh.iterator();
                                    while (it.hasNext()) {
                                        cbb cbb = (cbb) it.next();
                                        aoN3 = this.fnq.aoN(cbb.vHl);
                                        if (aoN3 != null) {
                                            obj = C5046bo.nullAsNil(aoN3.mo16707Oj());
                                        } else {
                                            obj = C5046bo.nullAsNil(cbb.vHl);
                                        }
                                        c5682a.mo11571A(C5710a.m8574F(cbb.vHl, obj));
                                    }
                                    c13633av.rBe = c5682a.dMh();
                                }
                                if (q.xaq.size() > 0) {
                                    c5682a = new C5682a();
                                    it = q.xaq.iterator();
                                    while (it.hasNext()) {
                                        cat = (cat) it.next();
                                        aoN3 = this.fnq.aoN(cat.vHl);
                                        if (aoN3 != null) {
                                            obj = C5046bo.nullAsNil(aoN3.mo16707Oj());
                                        } else {
                                            obj = C5046bo.nullAsNil(cat.vHl);
                                        }
                                        c5682a.mo11571A(C5710a.m8574F(cat.vHl, obj));
                                    }
                                    c13633av.rBf = c5682a.dMh();
                                }
                                if (q.xat.size() > 0) {
                                    C5682a c5682a2 = new C5682a();
                                    Iterator it3 = q.xat.iterator();
                                    while (it3.hasNext()) {
                                        C7486a aoN4;
                                        cat = (cat) it3.next();
                                        long j = cat.wZG != 0 ? (long) cat.wZG : cat.wZJ;
                                        str3 = cat.vHl;
                                        if (!cat.vHl.equals(this.ryC)) {
                                            aoN4 = this.fnq.aoN(cat.vHl);
                                        } else if (this.rEU == null) {
                                            aoN4 = this.fnq.aoN(cat.vHl);
                                            this.rEU = aoN4;
                                        } else {
                                            aoN4 = this.rEU;
                                        }
                                        obj = aoN4 != null ? aoN4.mo16707Oj() : cat.wCW != null ? cat.wCW : cat.vHl;
                                        String str4 = cat.ncM;
                                        CharSequence charSequence = (CharSequence) c13633av.rAp.qFP.get(cat.wZG + "-" + cat.wZJ + "-" + cat.ncM);
                                        c5682a2.mo11571A(C5710a.m8575b(Long.valueOf(j), str3, obj, str4, charSequence));
                                    }
                                    c13633av.rBg = c5682a2.dMh();
                                }
                            }
                            C22055af.m33675a(this.mContext, c13633av, cqu.qNO);
                            if (c13633av.rgZ) {
                                c13633av.rAB = c46236n.cqq();
                                c13633av.rAC = c46236n.cqo();
                                cqo = c46236n.cqo();
                                if (cqo != null) {
                                    str = cqo.qUf;
                                } else {
                                    str = "";
                                }
                                c13633av.rAD = str;
                            }
                            if (c13633av.rgZ) {
                                C21980a c21980a = c13633av.rAB;
                                if (c13633av.rAB.qTF == C21980a.qTr) {
                                    c13633av.rAE = c21980a.qTG;
                                } else if (c21980a.qTF == C21980a.qTs && !C5046bo.isNullOrNil(c21980a.qTG)) {
                                    str2 = "";
                                    it = c21980a.qTI.iterator();
                                    while (it.hasNext()) {
                                        str = (String) it.next();
                                        aoN2 = C13373af.cnt().aoN(str);
                                        if (aoN2 != null) {
                                            String Oj = aoN2.mo16707Oj();
                                            if (C5046bo.isNullOrNil(Oj)) {
                                                str2 = str2 + str;
                                            } else {
                                                str2 = str2 + Oj;
                                            }
                                        } else {
                                            str2 = str2 + str;
                                        }
                                        if (c21980a.qTI.getLast() != str) {
                                            str2 = str2 + ",";
                                        }
                                    }
                                    c13633av.rAG = str2;
                                    c13633av.rAF = String.format(c21980a.qTG, new Object[]{str2});
                                }
                            }
                            cqM = c46236n.cqM();
                            c13633av.rBj = cqM;
                            if (!(cqM == null || C1853r.m3846Yz().equals(cqu.jBB) || !C39742m.m67968a(c46236n, q))) {
                                c13633av.rAM = true;
                            }
                            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            C4990ab.m7411d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", Integer.valueOf(i), Long.valueOf(currentTimeMillis2));
                            return c13633av;
                        }
                    }
                }
                width = viewWidth;
                if (this.DEBUG) {
                }
                SO = C45416d.m83643a(a, width, C35147e.cvB().getTextViewConfig()).mo73210SO();
                C37873c.eNj.mo60604a(C35147e.cvB().getTextViewConfig(), SO);
                if (SO.eNO.getLineCount() > 7) {
                }
                m33663a(i, c13633av);
                if (c13633av.qBY.mo74253DI(32)) {
                }
                m33664e(c13633av.qCc);
                str2 = c46236n.field_userName;
                aoN = this.fnq.aoN(str2);
                if (C5046bo.isNullOrNil(str2)) {
                }
                c13633av.rAs = c46236n.cqA();
                c13633av.rAu = cqu.xfF;
                c13633av.rAv = cqu.xfK;
                c13633av.rAw = c46236n.field_createTime;
                c13633av.rAA = C29198aw.m46373h(this.mContext, ((long) c13633av.rAw) * 1000);
                c13633av.rAK = false;
                c13633av.rAL = q.xaE.xbg;
                c13633av.rAK = true;
                if (c13633av.rgZ) {
                }
                e = m33664e(cqu);
                if (!C24826a.gkF.mo38865dg(e)) {
                }
                if (C5046bo.isNullOrNil(cqu.xfJ)) {
                }
                c13633av.rAP = false;
                c13633av.rAQ = false;
                c13633av.mAppName = this.mContext.getString(C25738R.string.exe);
                c13633av.rAP = true;
                if (c13633av.igi == null) {
                }
                c13633av.rAJ = z;
                c13633av.rAV = c46236n.cqW();
                c13633av.rAW = c46236n.cqM().wFm;
                c13633av.rAX = false;
                width = q.wGz;
                c13633av.rAX = true;
                if (q != null) {
                }
                C22055af.m33675a(this.mContext, c13633av, cqu.qNO);
                if (c13633av.rgZ) {
                }
                if (c13633av.rgZ) {
                }
                cqM = c46236n.cqM();
                c13633av.rBj = cqM;
                c13633av.rAM = true;
                currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                C4990ab.m7411d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", Integer.valueOf(i), Long.valueOf(currentTimeMillis2));
                return c13633av;
            }
        }
        z = false;
        a = C4100f.m6419a(context, str3, textSize, z);
        c13633av.rAq = a;
        viewWidth = C35147e.cvB().getViewWidth();
        if (i < this.rES.getCount()) {
        }
        width = viewWidth;
        if (this.DEBUG) {
        }
        SO = C45416d.m83643a(a, width, C35147e.cvB().getTextViewConfig()).mo73210SO();
        C37873c.eNj.mo60604a(C35147e.cvB().getTextViewConfig(), SO);
        if (SO.eNO.getLineCount() > 7) {
        }
        m33663a(i, c13633av);
        if (c13633av.qBY.mo74253DI(32)) {
        }
        m33664e(c13633av.qCc);
        str2 = c46236n.field_userName;
        aoN = this.fnq.aoN(str2);
        if (C5046bo.isNullOrNil(str2)) {
        }
        c13633av.rAs = c46236n.cqA();
        c13633av.rAu = cqu.xfF;
        c13633av.rAv = cqu.xfK;
        c13633av.rAw = c46236n.field_createTime;
        c13633av.rAA = C29198aw.m46373h(this.mContext, ((long) c13633av.rAw) * 1000);
        c13633av.rAK = false;
        c13633av.rAL = q.xaE.xbg;
        c13633av.rAK = true;
        if (c13633av.rgZ) {
        }
        e = m33664e(cqu);
        if (!C24826a.gkF.mo38865dg(e)) {
        }
        if (C5046bo.isNullOrNil(cqu.xfJ)) {
        }
        c13633av.rAP = false;
        c13633av.rAQ = false;
        c13633av.mAppName = this.mContext.getString(C25738R.string.exe);
        c13633av.rAP = true;
        if (c13633av.igi == null) {
        }
        c13633av.rAJ = z;
        c13633av.rAV = c46236n.cqW();
        c13633av.rAW = c46236n.cqM().wFm;
        c13633av.rAX = false;
        width = q.wGz;
        c13633av.rAX = true;
        if (q != null) {
        }
        C22055af.m33675a(this.mContext, c13633av, cqu.qNO);
        if (c13633av.rgZ) {
        }
        if (c13633av.rgZ) {
        }
        cqM = c46236n.cqM();
        c13633av.rBj = cqM;
        c13633av.rAM = true;
        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        C4990ab.m7411d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", Integer.valueOf(i), Long.valueOf(currentTimeMillis2));
        return c13633av;
    }

    /* renamed from: e */
    private String m33664e(TimeLineObject timeLineObject) {
        if (timeLineObject.xfI.wbJ == 26) {
            return this.mContext.getString(C25738R.string.bnl);
        }
        if (timeLineObject.xfH == null) {
            return "";
        }
        if (C5046bo.isNullOrNil(timeLineObject.xfH.f17242Id)) {
            return "";
        }
        if (this.rEY.containsKey(timeLineObject.xfH.f17242Id)) {
            return (String) this.rEY.get(timeLineObject.xfH.f17242Id);
        }
        String r = C46494g.m87755r(this.mContext, timeLineObject.xfH.f17242Id, C5046bo.getInt(timeLineObject.xfH.jCh, 0));
        if (C5046bo.isNullOrNil(r)) {
            return r;
        }
        this.rEY.put(timeLineObject.xfH.f17242Id, r);
        return r;
    }

    /* renamed from: f */
    private static boolean m33665f(TimeLineObject timeLineObject) {
        if (!C5046bo.isNullOrNil(timeLineObject.xfJ) && (C3890a.coe() & 2) > 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m33663a(int i, C13633av c13633av) {
        LinkedList<cat> linkedList = c13633av.qBX.xat;
        c13633av.rAp = new C43538d();
        if (this.DEBUG) {
            C4990ab.m7410d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsComment position " + i + " commentInfoList: " + linkedList.size() + " commentData:" + c13633av.rAp.qFP.size());
        }
        for (cat cat : linkedList) {
            C42149a textViewConfig;
            int i2;
            if (C39851d.m68264fF(cat.wZL, 16)) {
                textViewConfig = C39850b.cvx().getTextViewConfig();
            } else {
                textViewConfig = C35146c.cvy().getTextViewConfig();
            }
            CharSequence a = C39851d.m68261a(this.mContext, cat, new C220531(), c13633av.qBY.field_type, c13633av.qBY.field_userName, 1);
            C37873c c37873c = C37873c.eNj;
            if (textViewConfig != null) {
                C45415b c45415b = (C45415b) c37873c.eNk.get(Integer.valueOf(C37873c.m63915a(textViewConfig)));
                if (c45415b != null) {
                    LinkedList linkedList2 = (LinkedList) c45415b.eNi.get(a.toString());
                    i2 = (linkedList2 == null || linkedList2.size() == 0) ? 0 : 1;
                    if (i2 == 0) {
                        c13633av.rAp.mo69100a(cat, a);
                    } else {
                        c13633av.rAp.mo69100a(cat, a);
                        if (C39851d.m68264fF(cat.wZL, 16)) {
                            i2 = C39850b.cvx().getViewWidth();
                        } else {
                            i2 = C35146c.cvy().getViewWidth();
                        }
                        if (i2 > 0) {
                            C37873c.eNj.mo60604a(textViewConfig, C45416d.m83643a(a, i2, textViewConfig).mo73210SO());
                        }
                    }
                }
            }
            i2 = 0;
            if (i2 == 0) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Cursor cuR() {
        init();
        int Zg = C13373af.cnF().mo62924Zg(this.lQD);
        C4990ab.m7417i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", Integer.valueOf(this.rET), Integer.valueOf(Zg), this.lQD);
        ArrayList<Long> arrayList = new ArrayList();
        if (this.rET != Zg) {
            Cursor fq = C13373af.cnI().mo69173fq(this.rET, Zg);
            if (fq != null && fq.moveToFirst()) {
                LinkedList linkedList = new LinkedList();
                do {
                    int i;
                    C43570e c43570e = new C43570e();
                    c43570e.mo8995d(fq);
                    C46236n cqB = c43570e.cqB();
                    StringBuilder stringBuilder = new StringBuilder("ad xml ");
                    C43570e crd = cqB.crd();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(cqB.field_stringSeq);
                    stringBuffer.append(crd.field_adxml);
                    stringBuffer.append(" <createtime " + cqB.field_createTime + ">");
                    stringBuffer.append(" <exposuretime " + crd.field_exposureTime + ">");
                    stringBuffer.append(" <adcreatetime " + crd.field_createAdTime + "> ");
                    stringBuffer.append(crd.cqu().xfF);
                    C4990ab.m7410d("MicroMsg.SnsTimeLineVendingSide", stringBuilder.append(stringBuffer.toString()).toString());
                    long j = 21600;
                    C21980a cqq = cqB.cqq();
                    int i2 = cqB.field_createTime;
                    boolean z = (c43570e.field_localFlag & 128) > 0;
                    if (cqq == null) {
                        i = i2;
                    } else if (z) {
                        j = 60 * cqq.qTv;
                        i = c43570e.field_exposureTime;
                    } else {
                        j = 60 * cqq.qTu;
                        i = c43570e.field_createAdTime;
                    }
                    long fp = C5046bo.m7549fp((long) i);
                    if (fp >= j) {
                        Object obj;
                        cbf q = C34955aj.m57409q(cqB);
                        if (cqB.field_likeFlag == 0) {
                            Iterator it = q.xat.iterator();
                            while (it.hasNext()) {
                                cat cat = (cat) it.next();
                                if (cat == null || C5046bo.isNullOrNil(cat.vHl) || !cat.vHl.equals(this.ryC)) {
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                arrayList.add(Long.valueOf(cqB.field_snsId));
                                C4990ab.m7416i("MicroMsg.SnsTimeLineVendingSide", "prepare to delete the ad " + cqB.field_snsId + " exposureTime: " + j + " field_createTime: " + cqB.field_createTime + " checktime: " + fp + " gettime: " + i + " isexposure " + z + " exposureTime " + c43570e.field_exposureTime + " adCreateTIme:" + c43570e.field_createAdTime);
                                if (!z) {
                                    linkedList.add(c43570e);
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                        }
                    }
                    long j2 = cqB.field_snsId;
                    C4990ab.m7416i("MicroMsg.SnsTimeLineVendingSide", "try to update snsid ".concat(String.valueOf(j2)));
                    if (C13428m.m21566kb(j2)) {
                        C1207m c13428m = new C13428m(j2, 1, cqB.cqq().qTU);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14541a(c13428m, 0);
                    }
                } while (fq.moveToNext());
                if (linkedList.size() > 0) {
                    LinkedList linkedList2 = new LinkedList();
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        C43570e c43570e2 = (C43570e) it2.next();
                        C44105bp c44105bp = new C44105bp();
                        c44105bp.vDS = 13298;
                        c44105bp.vDT = new C1332b(c43570e2.cqq().qPj.getBytes());
                        c44105bp.vDU = System.currentTimeMillis() / 1000;
                        linkedList2.add(c44105bp);
                    }
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C13427l(linkedList2), 0);
                }
            }
            if (fq != null) {
                C4990ab.m7410d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + fq.getCount());
                fq.close();
            }
        }
        if (!arrayList.isEmpty()) {
            for (Long longValue : arrayList) {
                C43555a.m77885jX(longValue.longValue());
            }
            arrayList.clear();
        }
        this.rET = Zg;
        Cursor df = C13373af.cnF().mo62936df(this.lQD, Zg);
        C4990ab.m7410d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
        C37952b lY = C37952b.m64170lY(500);
        if (lY.ajG()) {
            int i3 = this.f16225c;
            if (i3 == 0) {
                lY.mo60720mb(0).mo60720mb(0).mo60720mb(0);
                lY.ajK();
            } else {
                int i4 = i3 - 1;
                String j3 = C29036i.m46115j((C46236n) getItem(1));
                String j4 = C29036i.m46115j((C46236n) getItem(i4));
                if (!(j3.equals(this.rFa) && j4.equals(this.rFb))) {
                    this.rFa = j3;
                    this.rFb = j4;
                    lY.mo60720mb(i3).mo60722tx(j3).mo60722tx(j4);
                    lY.ajK();
                }
            }
        }
        return df;
    }

    public void destroyAsynchronous() {
        super.destroyAsynchronous();
        C37873c.eNj.mo60602SN();
        this.rEZ.clear();
        this.mContext = null;
        this.rES = null;
        this.fnq = null;
        this.zXa = null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void init() {
        if (!this.rEV) {
            m33661Kh();
            this.rEV = true;
        }
    }

    /* renamed from: Kh */
    private void m33661Kh() {
        synchronized (this.rEX) {
            this.lQD = mo63009w(0, this.lQD);
        }
    }
}
