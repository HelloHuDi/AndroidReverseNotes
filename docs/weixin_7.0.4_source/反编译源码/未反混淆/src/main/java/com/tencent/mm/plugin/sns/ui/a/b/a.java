package com.tencent.mm.plugin.sns.ui.a.b;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.l;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a extends b {
    private boolean DEBUG = false;
    private bd fnq;
    protected volatile String lQD = "";
    private Context mContext;
    private au rES;
    private int rET = ((int) (System.currentTimeMillis() / 1000));
    private com.tencent.mm.n.a rEU;
    private boolean rEV = false;
    private volatile boolean rEW = false;
    private byte[] rEX = new byte[0];
    protected HashMap<String, String> rEY = new HashMap();
    public HashMap<String, Boolean> rEZ = new HashMap();
    private String rFa = "";
    private String rFb = "";
    protected volatile String rmL = "";
    private String ryC;

    public final /* synthetic */ Object Ep(int i) {
        return Eo(i);
    }

    public /* synthetic */ void applyChangeSynchronized(Object obj) {
        Cursor cursor = (Cursor) obj;
        bIf();
        this.zXb = cursor;
    }

    public a(n nVar) {
        super(nVar);
        dLZ();
    }

    public final void a(Context context, au auVar, String str) {
        this.mContext = context;
        this.rES = auVar;
        this.ryC = str;
        g.RQ();
        this.fnq = ((j) g.K(j.class)).XM();
    }

    public final void ZK(String str) {
        this.rmL = str;
    }

    public final String cuO() {
        return this.lQD;
    }

    public final void ctK() {
        long j;
        looperCheckForVending();
        if (this.c == 0) {
            j = 0;
        } else {
            int i = this.c - 1;
            int i2 = 0;
            while (true) {
                n nVar = (n) getItem(i);
                if (nVar != null && !nVar.DI(32) && nVar.field_snsId != 0) {
                    ab.i("MicroMsg.SnsTimeLineVendingSide", "get list last not ad item %s %s", Long.valueOf(nVar.field_snsId), nVar.field_stringSeq);
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
            this.lQD = w(j, this.lQD);
        }
    }

    public final void PA() {
        looperCheckForVending();
        ab.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", Boolean.valueOf(this.rEW));
        if (!this.rEW) {
            synchronized (this.rEX) {
                this.lQD = w(0, this.lQD);
            }
        }
    }

    public final void ZL(String str) {
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
    private av Eo(int i) {
        if (i < 0) {
            return null;
        }
        ab.i("MicroMsg.SnsTimeLineVendingSide", "resolveAsynchronous %s", Integer.valueOf(i));
        long currentTimeMillis = System.currentTimeMillis();
        av avVar = new av();
        n nVar = (n) super.getItem(i);
        if (nVar == null) {
            ab.printErrStackTrace("MicroMsg.SnsTimeLineVendingSide", new Throwable(), "mSnsInfo is null, index %s, count %s, why?", Integer.valueOf(i), Integer.valueOf(this.mCount));
            return avVar;
        }
        String str;
        boolean z;
        CharSequence a;
        int viewWidth;
        int width;
        f SO;
        String str2;
        com.tencent.mm.n.a aoN;
        String e;
        bav cqM;
        long currentTimeMillis2;
        TimeLineObject cqu = nVar.cqu();
        cbf q = aj.q(nVar);
        int E = au.E(nVar);
        avVar.auo = E;
        avVar.rAt = nVar.field_snsId;
        avVar.rAx = nVar.field_likeFlag;
        avVar.rAy = nVar.cqQ();
        if (nVar.cqq() == null) {
            str = "";
        } else {
            str = nVar.cqq().hnw;
        }
        avVar.rAz = str;
        avVar.qBY = nVar;
        avVar.qCc = cqu;
        avVar.qBX = q;
        String str3 = avVar.qCc.xfF;
        Context context = this.mContext;
        e.cvB();
        float textSize = e.getTextSize();
        if (((com.tencent.mm.plugin.story.api.e) g.M(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().a(com.tencent.mm.plugin.story.api.f.a.TimeLine_Des)) {
            if (avVar.qCc == null) {
                str = "";
            } else {
                str = avVar.qCc.jBB;
            }
            if (com.tencent.mm.plugin.sns.e.a.Xu(str)) {
                z = true;
                a = com.tencent.mm.plugin.sns.ui.widget.f.a(context, str3, textSize, z);
                avVar.rAq = a;
                viewWidth = e.cvB().getViewWidth();
                if (i < this.rES.getCount()) {
                    n nVar2 = (n) super.getItem(i);
                    if (nVar2 != null && nVar2.DI(32)) {
                        b cqo = nVar2.cqo();
                        if (cqo != null && cqo.qUG == 1) {
                            Iterator it;
                            ad aoN2;
                            width = (((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bz.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bz.a.fromDPToPix(this.mContext, 50)) - com.tencent.mm.bz.a.fromDPToPix(this.mContext, 12)) - com.tencent.mm.bz.a.fromDPToPix(this.mContext, 12);
                            if (this.DEBUG) {
                                ab.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsPostDesc position " + i + " viewWidth: " + width + " desc:" + str3);
                            }
                            SO = d.a(a, width, e.cvB().getTextViewConfig()).SO();
                            c.eNj.a(e.cvB().getTextViewConfig(), SO);
                            if (SO.eNO.getLineCount() > 7) {
                                c.eNj.a(e.cvB().cvC(), d.a(a, width, e.cvB().cvC()).SO());
                            }
                            a(i, avVar);
                            if (avVar.qBY.DI(32)) {
                                af.cnC().b(nVar, null);
                            } else {
                                af.cnC().a(nVar, null);
                            }
                            e(avVar.qCc);
                            str2 = nVar.field_userName;
                            aoN = this.fnq.aoN(str2);
                            if (!bo.isNullOrNil(str2)) {
                                com.tencent.mm.n.a aVar;
                                if (!str2.equals(this.ryC)) {
                                    aVar = aoN;
                                } else if (this.rEU == null) {
                                    this.rEU = aoN;
                                    aVar = aoN;
                                } else {
                                    aVar = this.rEU;
                                }
                                if (aVar == null) {
                                    str = str2;
                                } else {
                                    str = aVar.Oj();
                                }
                                if (nVar.DI(32)) {
                                    b cqo2 = nVar.cqo();
                                    if (cqo2 != null) {
                                        if (cqo2.qVa) {
                                            str = cqo2.qVb;
                                        } else if (bo.isNullOrNil(str) && !bo.isNullOrNil(cqo2.nickname)) {
                                            str = cqo2.nickname;
                                        }
                                    }
                                }
                                avVar.igi = str2;
                                avVar.rAH = str;
                                avVar.rgZ = nVar.DI(32);
                                avVar.riA = nVar.cqU();
                                z = aVar == null ? true : ((int) aVar.ewQ) == 0;
                                avVar.rAI = z;
                                avVar.rAr = aVar;
                            }
                            avVar.rAs = nVar.cqA();
                            avVar.rAu = cqu.xfF;
                            avVar.rAv = cqu.xfK;
                            avVar.rAw = nVar.field_createTime;
                            avVar.rAA = aw.h(this.mContext, ((long) avVar.rAw) * 1000);
                            avVar.rAK = false;
                            if (!(E != 10 || r.Yz().equals(cqu.jBB) || q.xaE == null || q.xaE.xbg == 0)) {
                                avVar.rAL = q.xaE.xbg;
                                avVar.rAK = true;
                            }
                            if (avVar.rgZ) {
                                com.tencent.mm.plugin.sns.storage.a cqq = nVar.cqq();
                                if (cqq != null) {
                                    avVar.rAN = cqq.qTD;
                                    if (bo.isNullOrNil(cqq.qTE)) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    avVar.rAO = z;
                                }
                            } else {
                                str = cqu.xfG == null ? null : cqu.xfG.guP;
                                str2 = cqu.xfG == null ? null : cqu.xfG.eUu;
                                if (bo.isNullOrNil(str2)) {
                                    avVar.rAN = str;
                                    avVar.rAO = false;
                                } else {
                                    if (nVar.field_snsId != 0 || bo.isNullOrNil(str)) {
                                        avVar.rAN = str2;
                                    } else {
                                        avVar.rAN = str + "·" + str2;
                                    }
                                    avVar.rAO = true;
                                }
                            }
                            e = e(cqu);
                            if (!com.tencent.mm.plugin.sns.c.a.gkF.dg(e) && f(cqu)) {
                                avVar.rAP = true;
                                if (cqu.xfH == null) {
                                    z = false;
                                } else if (!this.rEZ.containsKey(cqu.xfH.Id)) {
                                    boolean z2;
                                    if (!com.tencent.mm.pluginsdk.model.app.g.dk(cqu.xfH.Id)) {
                                        z = com.tencent.mm.pluginsdk.model.app.g.aiF(cqu.xfH.Id);
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
                                    this.rEZ.put(cqu.xfH.Id, Boolean.valueOf(z));
                                    z = z2;
                                } else if (((Boolean) this.rEZ.get(cqu.xfH.Id)).booleanValue()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                avVar.mAppName = e;
                                avVar.rAR = z;
                            } else if (bo.isNullOrNil(cqu.xfJ) && f(cqu)) {
                                avVar.mAppName = e;
                                avVar.rAQ = true;
                                avVar.rAT = cqu.vjM;
                                avVar.rAS = cqu.xfJ;
                            } else {
                                avVar.rAP = false;
                                avVar.rAQ = false;
                            }
                            if (!(cqu.qNQ == null || bo.isNullOrNil(cqu.qNQ.uaa))) {
                                avVar.mAppName = this.mContext.getString(R.string.exe);
                                avVar.rAP = true;
                            }
                            z = avVar.igi == null && avVar.igi.equals(this.ryC);
                            avVar.rAJ = z;
                            avVar.rAV = nVar.cqW();
                            avVar.rAW = nVar.cqM().wFm;
                            avVar.rAX = false;
                            if (q != null && avVar.rAJ) {
                                width = q.wGz;
                                if (width == 3 || width == 5) {
                                    avVar.rAX = true;
                                }
                            }
                            if (q != null) {
                                Object obj;
                                cat cat;
                                com.tencent.mm.vending.d.b.a aVar2;
                                ad aoN3;
                                if (q.xaw.size() > 0) {
                                    if (!this.ryC.equals(q.vHl)) {
                                        Iterator it2 = q.xaw.iterator();
                                        while (it2.hasNext()) {
                                            if (this.ryC.equals(((cat) it2.next()).vHl)) {
                                                avVar.rAY = true;
                                                avVar.rBa = true;
                                                break;
                                            }
                                        }
                                    }
                                    avVar.rAY = true;
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
                                            stringBuffer.append(aoN2 == null ? cat.vHl : aoN2.Oj());
                                        }
                                    }
                                    avVar.rAZ = stringBuffer.toString();
                                } else {
                                    avVar.rAY = false;
                                }
                                if (q.xaE != null && r.Yz().equals(cqu.jBB) && q.xaE.xbg > 0) {
                                    avVar.rBd = ((double) m.b(nVar, q)) * 1.0d;
                                    avVar.rBc = q.xaE.xbg;
                                    avVar.rBb = true;
                                    aVar2 = new com.tencent.mm.vending.d.b.a();
                                    it = q.xaE.xbh.iterator();
                                    while (it.hasNext()) {
                                        cbb cbb = (cbb) it.next();
                                        aoN3 = this.fnq.aoN(cbb.vHl);
                                        if (aoN3 != null) {
                                            obj = bo.nullAsNil(aoN3.Oj());
                                        } else {
                                            obj = bo.nullAsNil(cbb.vHl);
                                        }
                                        aVar2.A(com.tencent.mm.vending.j.a.F(cbb.vHl, obj));
                                    }
                                    avVar.rBe = aVar2.dMh();
                                }
                                if (q.xaq.size() > 0) {
                                    aVar2 = new com.tencent.mm.vending.d.b.a();
                                    it = q.xaq.iterator();
                                    while (it.hasNext()) {
                                        cat = (cat) it.next();
                                        aoN3 = this.fnq.aoN(cat.vHl);
                                        if (aoN3 != null) {
                                            obj = bo.nullAsNil(aoN3.Oj());
                                        } else {
                                            obj = bo.nullAsNil(cat.vHl);
                                        }
                                        aVar2.A(com.tencent.mm.vending.j.a.F(cat.vHl, obj));
                                    }
                                    avVar.rBf = aVar2.dMh();
                                }
                                if (q.xat.size() > 0) {
                                    com.tencent.mm.vending.d.b.a aVar3 = new com.tencent.mm.vending.d.b.a();
                                    Iterator it3 = q.xat.iterator();
                                    while (it3.hasNext()) {
                                        com.tencent.mm.n.a aoN4;
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
                                        obj = aoN4 != null ? aoN4.Oj() : cat.wCW != null ? cat.wCW : cat.vHl;
                                        String str4 = cat.ncM;
                                        CharSequence charSequence = (CharSequence) avVar.rAp.qFP.get(cat.wZG + "-" + cat.wZJ + "-" + cat.ncM);
                                        aVar3.A(com.tencent.mm.vending.j.a.b(Long.valueOf(j), str3, obj, str4, charSequence));
                                    }
                                    avVar.rBg = aVar3.dMh();
                                }
                            }
                            com.tencent.mm.plugin.sns.ui.af.a(this.mContext, avVar, cqu.qNO);
                            if (avVar.rgZ) {
                                avVar.rAB = nVar.cqq();
                                avVar.rAC = nVar.cqo();
                                cqo = nVar.cqo();
                                if (cqo != null) {
                                    str = cqo.qUf;
                                } else {
                                    str = "";
                                }
                                avVar.rAD = str;
                            }
                            if (avVar.rgZ) {
                                com.tencent.mm.plugin.sns.storage.a aVar4 = avVar.rAB;
                                if (avVar.rAB.qTF == com.tencent.mm.plugin.sns.storage.a.qTr) {
                                    avVar.rAE = aVar4.qTG;
                                } else if (aVar4.qTF == com.tencent.mm.plugin.sns.storage.a.qTs && !bo.isNullOrNil(aVar4.qTG)) {
                                    str2 = "";
                                    it = aVar4.qTI.iterator();
                                    while (it.hasNext()) {
                                        str = (String) it.next();
                                        aoN2 = af.cnt().aoN(str);
                                        if (aoN2 != null) {
                                            String Oj = aoN2.Oj();
                                            if (bo.isNullOrNil(Oj)) {
                                                str2 = str2 + str;
                                            } else {
                                                str2 = str2 + Oj;
                                            }
                                        } else {
                                            str2 = str2 + str;
                                        }
                                        if (aVar4.qTI.getLast() != str) {
                                            str2 = str2 + ",";
                                        }
                                    }
                                    avVar.rAG = str2;
                                    avVar.rAF = String.format(aVar4.qTG, new Object[]{str2});
                                }
                            }
                            cqM = nVar.cqM();
                            avVar.rBj = cqM;
                            if (!(cqM == null || r.Yz().equals(cqu.jBB) || !m.a(nVar, q))) {
                                avVar.rAM = true;
                            }
                            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            ab.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", Integer.valueOf(i), Long.valueOf(currentTimeMillis2));
                            return avVar;
                        }
                    }
                }
                width = viewWidth;
                if (this.DEBUG) {
                }
                SO = d.a(a, width, e.cvB().getTextViewConfig()).SO();
                c.eNj.a(e.cvB().getTextViewConfig(), SO);
                if (SO.eNO.getLineCount() > 7) {
                }
                a(i, avVar);
                if (avVar.qBY.DI(32)) {
                }
                e(avVar.qCc);
                str2 = nVar.field_userName;
                aoN = this.fnq.aoN(str2);
                if (bo.isNullOrNil(str2)) {
                }
                avVar.rAs = nVar.cqA();
                avVar.rAu = cqu.xfF;
                avVar.rAv = cqu.xfK;
                avVar.rAw = nVar.field_createTime;
                avVar.rAA = aw.h(this.mContext, ((long) avVar.rAw) * 1000);
                avVar.rAK = false;
                avVar.rAL = q.xaE.xbg;
                avVar.rAK = true;
                if (avVar.rgZ) {
                }
                e = e(cqu);
                if (!com.tencent.mm.plugin.sns.c.a.gkF.dg(e)) {
                }
                if (bo.isNullOrNil(cqu.xfJ)) {
                }
                avVar.rAP = false;
                avVar.rAQ = false;
                avVar.mAppName = this.mContext.getString(R.string.exe);
                avVar.rAP = true;
                if (avVar.igi == null) {
                }
                avVar.rAJ = z;
                avVar.rAV = nVar.cqW();
                avVar.rAW = nVar.cqM().wFm;
                avVar.rAX = false;
                width = q.wGz;
                avVar.rAX = true;
                if (q != null) {
                }
                com.tencent.mm.plugin.sns.ui.af.a(this.mContext, avVar, cqu.qNO);
                if (avVar.rgZ) {
                }
                if (avVar.rgZ) {
                }
                cqM = nVar.cqM();
                avVar.rBj = cqM;
                avVar.rAM = true;
                currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ab.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", Integer.valueOf(i), Long.valueOf(currentTimeMillis2));
                return avVar;
            }
        }
        z = false;
        a = com.tencent.mm.plugin.sns.ui.widget.f.a(context, str3, textSize, z);
        avVar.rAq = a;
        viewWidth = e.cvB().getViewWidth();
        if (i < this.rES.getCount()) {
        }
        width = viewWidth;
        if (this.DEBUG) {
        }
        SO = d.a(a, width, e.cvB().getTextViewConfig()).SO();
        c.eNj.a(e.cvB().getTextViewConfig(), SO);
        if (SO.eNO.getLineCount() > 7) {
        }
        a(i, avVar);
        if (avVar.qBY.DI(32)) {
        }
        e(avVar.qCc);
        str2 = nVar.field_userName;
        aoN = this.fnq.aoN(str2);
        if (bo.isNullOrNil(str2)) {
        }
        avVar.rAs = nVar.cqA();
        avVar.rAu = cqu.xfF;
        avVar.rAv = cqu.xfK;
        avVar.rAw = nVar.field_createTime;
        avVar.rAA = aw.h(this.mContext, ((long) avVar.rAw) * 1000);
        avVar.rAK = false;
        avVar.rAL = q.xaE.xbg;
        avVar.rAK = true;
        if (avVar.rgZ) {
        }
        e = e(cqu);
        if (!com.tencent.mm.plugin.sns.c.a.gkF.dg(e)) {
        }
        if (bo.isNullOrNil(cqu.xfJ)) {
        }
        avVar.rAP = false;
        avVar.rAQ = false;
        avVar.mAppName = this.mContext.getString(R.string.exe);
        avVar.rAP = true;
        if (avVar.igi == null) {
        }
        avVar.rAJ = z;
        avVar.rAV = nVar.cqW();
        avVar.rAW = nVar.cqM().wFm;
        avVar.rAX = false;
        width = q.wGz;
        avVar.rAX = true;
        if (q != null) {
        }
        com.tencent.mm.plugin.sns.ui.af.a(this.mContext, avVar, cqu.qNO);
        if (avVar.rgZ) {
        }
        if (avVar.rgZ) {
        }
        cqM = nVar.cqM();
        avVar.rBj = cqM;
        avVar.rAM = true;
        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        ab.d("MicroMsg.SnsTimeLineVendingSide", "SnsTimeLineVendingStruct resolve %s %s ms", Integer.valueOf(i), Long.valueOf(currentTimeMillis2));
        return avVar;
    }

    private String e(TimeLineObject timeLineObject) {
        if (timeLineObject.xfI.wbJ == 26) {
            return this.mContext.getString(R.string.bnl);
        }
        if (timeLineObject.xfH == null) {
            return "";
        }
        if (bo.isNullOrNil(timeLineObject.xfH.Id)) {
            return "";
        }
        if (this.rEY.containsKey(timeLineObject.xfH.Id)) {
            return (String) this.rEY.get(timeLineObject.xfH.Id);
        }
        String r = com.tencent.mm.pluginsdk.model.app.g.r(this.mContext, timeLineObject.xfH.Id, bo.getInt(timeLineObject.xfH.jCh, 0));
        if (bo.isNullOrNil(r)) {
            return r;
        }
        this.rEY.put(timeLineObject.xfH.Id, r);
        return r;
    }

    private static boolean f(TimeLineObject timeLineObject) {
        if (!bo.isNullOrNil(timeLineObject.xfJ) && (com.tencent.mm.plugin.sns.model.am.a.coe() & 2) > 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int i, av avVar) {
        LinkedList<cat> linkedList = avVar.qBX.xat;
        avVar.rAp = new com.tencent.mm.plugin.sns.data.d();
        if (this.DEBUG) {
            ab.d("MicroMsg.SnsTimeLineVendingSide", "debug:renderSnsComment position " + i + " commentInfoList: " + linkedList.size() + " commentData:" + avVar.rAp.qFP.size());
        }
        for (cat cat : linkedList) {
            com.tencent.mm.kiss.widget.textview.a.a textViewConfig;
            int i2;
            if (com.tencent.mm.plugin.sns.ui.widget.d.fF(cat.wZL, 16)) {
                textViewConfig = com.tencent.mm.plugin.sns.ui.widget.b.cvx().getTextViewConfig();
            } else {
                textViewConfig = com.tencent.mm.plugin.sns.ui.widget.c.cvy().getTextViewConfig();
            }
            CharSequence a = com.tencent.mm.plugin.sns.ui.widget.d.a(this.mContext, cat, new com.tencent.mm.plugin.sns.ui.j() {
                public final void a(View view, Object obj) {
                    AppMethodBeat.i(39953);
                    a.this.rES.rqd.cvd = 14;
                    a.this.rES.rqd.a(view, obj);
                    AppMethodBeat.o(39953);
                }
            }, avVar.qBY.field_type, avVar.qBY.field_userName, 1);
            c cVar = c.eNj;
            if (textViewConfig != null) {
                com.tencent.mm.kiss.widget.textview.b bVar = (com.tencent.mm.kiss.widget.textview.b) cVar.eNk.get(Integer.valueOf(c.a(textViewConfig)));
                if (bVar != null) {
                    LinkedList linkedList2 = (LinkedList) bVar.eNi.get(a.toString());
                    i2 = (linkedList2 == null || linkedList2.size() == 0) ? 0 : 1;
                    if (i2 == 0) {
                        avVar.rAp.a(cat, a);
                    } else {
                        avVar.rAp.a(cat, a);
                        if (com.tencent.mm.plugin.sns.ui.widget.d.fF(cat.wZL, 16)) {
                            i2 = com.tencent.mm.plugin.sns.ui.widget.b.cvx().getViewWidth();
                        } else {
                            i2 = com.tencent.mm.plugin.sns.ui.widget.c.cvy().getViewWidth();
                        }
                        if (i2 > 0) {
                            c.eNj.a(textViewConfig, d.a(a, i2, textViewConfig).SO());
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
        int Zg = af.cnF().Zg(this.lQD);
        ab.i("MicroMsg.SnsTimeLineVendingSide", "create time sql %s to %s getLimitSeq() %s", Integer.valueOf(this.rET), Integer.valueOf(Zg), this.lQD);
        ArrayList<Long> arrayList = new ArrayList();
        if (this.rET != Zg) {
            Cursor fq = af.cnI().fq(this.rET, Zg);
            if (fq != null && fq.moveToFirst()) {
                LinkedList linkedList = new LinkedList();
                do {
                    int i;
                    com.tencent.mm.plugin.sns.storage.e eVar = new com.tencent.mm.plugin.sns.storage.e();
                    eVar.d(fq);
                    n cqB = eVar.cqB();
                    StringBuilder stringBuilder = new StringBuilder("ad xml ");
                    com.tencent.mm.plugin.sns.storage.e crd = cqB.crd();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(cqB.field_stringSeq);
                    stringBuffer.append(crd.field_adxml);
                    stringBuffer.append(" <createtime " + cqB.field_createTime + ">");
                    stringBuffer.append(" <exposuretime " + crd.field_exposureTime + ">");
                    stringBuffer.append(" <adcreatetime " + crd.field_createAdTime + "> ");
                    stringBuffer.append(crd.cqu().xfF);
                    ab.d("MicroMsg.SnsTimeLineVendingSide", stringBuilder.append(stringBuffer.toString()).toString());
                    long j = 21600;
                    com.tencent.mm.plugin.sns.storage.a cqq = cqB.cqq();
                    int i2 = cqB.field_createTime;
                    boolean z = (eVar.field_localFlag & 128) > 0;
                    if (cqq == null) {
                        i = i2;
                    } else if (z) {
                        j = 60 * cqq.qTv;
                        i = eVar.field_exposureTime;
                    } else {
                        j = 60 * cqq.qTu;
                        i = eVar.field_createAdTime;
                    }
                    long fp = bo.fp((long) i);
                    if (fp >= j) {
                        Object obj;
                        cbf q = aj.q(cqB);
                        if (cqB.field_likeFlag == 0) {
                            Iterator it = q.xat.iterator();
                            while (it.hasNext()) {
                                cat cat = (cat) it.next();
                                if (cat == null || bo.isNullOrNil(cat.vHl) || !cat.vHl.equals(this.ryC)) {
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                arrayList.add(Long.valueOf(cqB.field_snsId));
                                ab.i("MicroMsg.SnsTimeLineVendingSide", "prepare to delete the ad " + cqB.field_snsId + " exposureTime: " + j + " field_createTime: " + cqB.field_createTime + " checktime: " + fp + " gettime: " + i + " isexposure " + z + " exposureTime " + eVar.field_exposureTime + " adCreateTIme:" + eVar.field_createAdTime);
                                if (!z) {
                                    linkedList.add(eVar);
                                }
                            }
                        }
                        obj = 1;
                        if (obj == null) {
                        }
                    }
                    long j2 = cqB.field_snsId;
                    ab.i("MicroMsg.SnsTimeLineVendingSide", "try to update snsid ".concat(String.valueOf(j2)));
                    if (com.tencent.mm.plugin.sns.model.m.kb(j2)) {
                        com.tencent.mm.ai.m mVar = new com.tencent.mm.plugin.sns.model.m(j2, 1, cqB.cqq().qTU);
                        g.RQ();
                        g.RO().eJo.a(mVar, 0);
                    }
                } while (fq.moveToNext());
                if (linkedList.size() > 0) {
                    LinkedList linkedList2 = new LinkedList();
                    Iterator it2 = linkedList.iterator();
                    while (it2.hasNext()) {
                        com.tencent.mm.plugin.sns.storage.e eVar2 = (com.tencent.mm.plugin.sns.storage.e) it2.next();
                        bp bpVar = new bp();
                        bpVar.vDS = 13298;
                        bpVar.vDT = new com.tencent.mm.bt.b(eVar2.cqq().qPj.getBytes());
                        bpVar.vDU = System.currentTimeMillis() / 1000;
                        linkedList2.add(bpVar);
                    }
                    g.RQ();
                    g.RO().eJo.a(new l(linkedList2), 0);
                }
            }
            if (fq != null) {
                ab.d("MicroMsg.SnsTimeLineVendingSide", "test for adcount " + fq.getCount());
                fq.close();
            }
        }
        if (!arrayList.isEmpty()) {
            for (Long longValue : arrayList) {
                com.tencent.mm.plugin.sns.model.a.jX(longValue.longValue());
            }
            arrayList.clear();
        }
        this.rET = Zg;
        Cursor df = af.cnF().df(this.lQD, Zg);
        ab.d("MicroMsg.SnsTimeLineVendingSide", "onCursorResetFinish");
        com.tencent.mm.modelsns.b lY = com.tencent.mm.modelsns.b.lY(500);
        if (lY.ajG()) {
            int i3 = this.c;
            if (i3 == 0) {
                lY.mb(0).mb(0).mb(0);
                lY.ajK();
            } else {
                int i4 = i3 - 1;
                String j3 = i.j((n) getItem(1));
                String j4 = i.j((n) getItem(i4));
                if (!(j3.equals(this.rFa) && j4.equals(this.rFb))) {
                    this.rFa = j3;
                    this.rFb = j4;
                    lY.mb(i3).tx(j3).tx(j4);
                    lY.ajK();
                }
            }
        }
        return df;
    }

    public void destroyAsynchronous() {
        super.destroyAsynchronous();
        c.eNj.SN();
        this.rEZ.clear();
        this.mContext = null;
        this.rES = null;
        this.fnq = null;
        this.zXa = null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void init() {
        if (!this.rEV) {
            Kh();
            this.rEV = true;
        }
    }

    private void Kh() {
        synchronized (this.rEX) {
            this.lQD = w(0, this.lQD);
        }
    }
}
