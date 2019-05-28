package com.tencent.mm.ui.chatting.c;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

@a(dFp = ag.class)
public class ao extends a implements ag {
    private static HashMap<Long, String> ySH = new HashMap();
    private static HashMap<Long, b> ySI = new HashMap();
    private static LinkedHashMap<Long, Pair<bi, Integer>> ySJ = new LinkedHashMap();
    private static HashMap<Long, Boolean> ySK = new HashMap();
    private boolean iXQ = false;
    private boolean ySL = false;
    private boolean ySM = false;
    private List<Long> ySN = new ArrayList();
    boolean ySO = false;
    long ySP;
    long ySQ = 0;
    boolean ySR = false;
    private int ySS = -1;

    public ao() {
        AppMethodBeat.i(31786);
        AppMethodBeat.o(31786);
    }

    static /* synthetic */ Context a(ao aoVar) {
        AppMethodBeat.i(31814);
        Context context = aoVar.getContext();
        AppMethodBeat.o(31814);
        return context;
    }

    static /* synthetic */ void b(ao aoVar) {
        AppMethodBeat.i(31818);
        aoVar.notifyDataSetChanged();
        AppMethodBeat.o(31818);
    }

    static {
        AppMethodBeat.i(31823);
        AppMethodBeat.o(31823);
    }

    public final synchronized void a(long j, String str, b bVar) {
        AppMethodBeat.i(31787);
        ySH.put(Long.valueOf(j), str);
        ySI.put(Long.valueOf(j), bVar);
        if (bVar == b.Transformed) {
            ySK.put(Long.valueOf(j), Boolean.TRUE);
        }
        AppMethodBeat.o(31787);
    }

    private synchronized void nh(long j) {
        AppMethodBeat.i(31788);
        ySH.remove(Long.valueOf(j));
        ySI.remove(Long.valueOf(j));
        AppMethodBeat.o(31788);
    }

    public final synchronized String C(long j, String str) {
        String str2;
        AppMethodBeat.i(31789);
        str2 = (String) ySH.get(Long.valueOf(j));
        if (bo.isNullOrNil(str2)) {
            cc aqb = m.amb().aqb(str);
            if (!(aqb == null || bo.isNullOrNil(aqb.field_content))) {
                str2 = aqb.field_content;
            }
        }
        AppMethodBeat.o(31789);
        return str2;
    }

    public final synchronized b ni(long j) {
        b bVar;
        AppMethodBeat.i(31790);
        bVar = (b) ySI.get(Long.valueOf(j));
        if (bVar == null) {
            bVar = b.NoTransform;
        }
        AppMethodBeat.o(31790);
        return bVar;
    }

    private synchronized void a(long j, bi biVar, int i) {
        AppMethodBeat.i(31791);
        ySJ.put(Long.valueOf(j), new Pair(biVar, Integer.valueOf(i)));
        AppMethodBeat.o(31791);
    }

    public final synchronized boolean nj(long j) {
        boolean z;
        AppMethodBeat.i(31792);
        if (ySJ.containsKey(Long.valueOf(j))) {
            z = true;
            AppMethodBeat.o(31792);
        } else {
            z = false;
            AppMethodBeat.o(31792);
        }
        return z;
    }

    private synchronized bi nk(long j) {
        bi biVar;
        AppMethodBeat.i(31793);
        Pair pair = (Pair) ySJ.get(Long.valueOf(j));
        if (pair == null) {
            biVar = null;
            AppMethodBeat.o(31793);
        } else {
            biVar = (bi) pair.first;
            AppMethodBeat.o(31793);
        }
        return biVar;
    }

    public final synchronized Pair<bi, Integer> dFg() {
        Pair<bi, Integer> pair;
        AppMethodBeat.i(31794);
        Iterator it = ySJ.entrySet().iterator();
        if (it.hasNext()) {
            pair = (Pair) ((Entry) it.next()).getValue();
            AppMethodBeat.o(31794);
        } else {
            pair = null;
            AppMethodBeat.o(31794);
        }
        return pair;
    }

    private synchronized void nl(long j) {
        AppMethodBeat.i(31795);
        if (ySJ.containsKey(Long.valueOf(j))) {
            ySJ.remove(Long.valueOf(j));
        }
        AppMethodBeat.o(31795);
    }

    private synchronized void dFh() {
        AppMethodBeat.i(31796);
        ySJ.clear();
        AppMethodBeat.o(31796);
    }

    public final boolean dFi() {
        AppMethodBeat.i(31797);
        aw.ZK();
        if (((Boolean) c.Ry().get(75, Boolean.FALSE)).booleanValue()) {
            AppMethodBeat.o(31797);
            return false;
        }
        AppMethodBeat.o(31797);
        return true;
    }

    public final void dFj() {
        AppMethodBeat.i(31798);
        aw.ZK();
        c.Ry().set(75, Boolean.TRUE);
        AppMethodBeat.o(31798);
    }

    public final void OF(int i) {
        AppMethodBeat.i(31799);
        if (i == 2) {
            this.ySM = true;
            AppMethodBeat.o(31799);
            return;
        }
        if (this.ySO) {
            a(nk(this.ySP), true, -1, i);
        }
        AppMethodBeat.o(31799);
    }

    public final void a(final bi biVar, boolean z, final int i, int i2) {
        AppMethodBeat.i(31800);
        if (biVar == null) {
            ab.d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
            AppMethodBeat.o(31800);
        } else if (nm(biVar.field_msgId)) {
            ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", Long.valueOf(biVar.field_msgId), Boolean.valueOf(this.ySO));
            biVar.dtT();
            nn(biVar.field_msgId);
            notifyDataSetChanged();
            AppMethodBeat.o(31800);
        } else {
            fq fqVar;
            if (nj(biVar.field_msgId) && z) {
                if (ni(biVar.field_msgId) == b.PreTransform) {
                    ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
                    nl(biVar.field_msgId);
                    nh(biVar.field_msgId);
                    c(5, biVar);
                } else if (this.ySO) {
                    fqVar = new fq();
                    fqVar.czB.czE = 3;
                    com.tencent.mm.sdk.b.a.xxA.m(fqVar);
                    nl(biVar.field_msgId);
                    nh(biVar.field_msgId);
                    biVar.dtT();
                    aw.ZK();
                    c.XO().a(biVar.field_msgId, biVar);
                    this.ySO = false;
                    g(biVar, -1);
                }
                notifyDataSetChanged();
                if (z) {
                    OH(i2);
                    AppMethodBeat.o(31800);
                    return;
                }
            }
            cc aqb = m.amb().aqb(biVar.field_imgPath);
            if (aqb == null || bo.isNullOrNil(aqb.field_content)) {
                int acS = aw.Rg().acS();
                if (acS == 4 || acS == 6) {
                    if (this.ySO) {
                        ab.i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
                        a(biVar.field_msgId, biVar, i);
                        a(biVar.field_msgId, "", b.PreTransform);
                        notifyDataSetChanged();
                    } else {
                        fqVar = new fq();
                        fqVar.czB.czE = 1;
                        com.tencent.mm.sdk.b.a.xxA.m(fqVar);
                        fqVar = new fq();
                        fqVar.czB.czD = String.valueOf(biVar.field_msgId);
                        fqVar.czB.fileName = biVar.field_imgPath;
                        fqVar.czB.from = 1;
                        fqVar.czB.czE = 0;
                        fqVar.czB.scene = dFk();
                        fqVar.czB.czF = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(31783);
                                if (!ao.this.nj(Long.valueOf(fqVar.czB.czD).longValue())) {
                                    AppMethodBeat.o(31783);
                                } else if (fqVar.czC.bcU) {
                                    if (bo.isNullOrNil(fqVar.czC.content)) {
                                        if (fqVar.czC.state == 2) {
                                            ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", fqVar.czB.czD);
                                            ao.a(ao.this, ao.a(ao.this).getString(R.string.aos));
                                        }
                                        ao.a(ao.this, Long.valueOf(fqVar.czB.czD).longValue());
                                        ao.b(ao.this, Long.valueOf(fqVar.czB.czD).longValue());
                                        ao.this.ySO = false;
                                        ao.b(ao.this);
                                    } else {
                                        ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", fqVar.czB.czD);
                                        bi c = ao.c(ao.this, Long.valueOf(fqVar.czB.czD).longValue());
                                        if (c != null) {
                                            ao.this.a(Long.valueOf(fqVar.czB.czD).longValue(), fqVar.czC.content, b.Transformed);
                                            c.dtU();
                                            aw.ZK();
                                            c.XO().a(c.field_msgId, c);
                                            ao.b(ao.this, Long.valueOf(fqVar.czB.czD).longValue());
                                            ao.b(ao.this);
                                            ao.a(ao.this, i);
                                        }
                                        ao.this.ySO = false;
                                    }
                                    ao.a(ao.this, biVar, i);
                                    AppMethodBeat.o(31783);
                                } else {
                                    if (!bo.isNullOrNil(fqVar.czC.content)) {
                                        ao.this.a(Long.valueOf(fqVar.czB.czD).longValue(), fqVar.czC.content, b.Transforming);
                                        ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", fqVar.czB.czD);
                                    }
                                    ao.b(ao.this);
                                    ao.a(ao.this, i);
                                    AppMethodBeat.o(31783);
                                }
                            }
                        };
                        a(Long.valueOf(fqVar.czB.czD).longValue(), "", b.Transforming);
                        a(biVar.field_msgId, biVar, i);
                        this.ySO = true;
                        this.ySP = biVar.field_msgId;
                        notifyDataSetChanged();
                        OG(i);
                        if (com.tencent.mm.sdk.b.a.xxA.m(fqVar)) {
                            ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
                        } else {
                            ab.i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
                            art(getContext().getString(R.string.aos));
                            nh(Long.valueOf(fqVar.czB.czD).longValue());
                            nl(Long.valueOf(fqVar.czB.czD).longValue());
                            this.ySO = false;
                            g(biVar, i);
                        }
                    }
                    if (z) {
                        this.iXQ = true;
                    }
                } else {
                    h.g(getContext(), R.string.aot, R.string.tz);
                    c(2, biVar);
                    this.ySL = false;
                    AppMethodBeat.o(31800);
                    return;
                }
            }
            ab.i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", Long.valueOf(biVar.field_msgId), biVar.field_imgPath);
            biVar.dtU();
            a(biVar.field_msgId, aqb.field_content, b.Transformed);
            aw.ZK();
            c.XO().a(biVar.field_msgId, biVar);
            this.ySL = false;
            OG(i);
            AppMethodBeat.o(31800);
            return;
            AppMethodBeat.o(31800);
        }
    }

    private void OG(int i) {
        AppMethodBeat.i(31801);
        if (this.iXQ && i != -1) {
            this.cgL.bY(i);
        }
        AppMethodBeat.o(31801);
    }

    private void OH(int i) {
        int i2 = 1;
        AppMethodBeat.i(31802);
        if (this.ySL && this.ySN.size() > 0) {
            String l = ((Long) this.ySN.get(0)).toString();
            for (int i3 = 1; i3 < this.ySN.size(); i3++) {
                l = l + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.ySN.get(i3);
            }
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(this.ySN.size());
            if (this.iXQ) {
                i2 = 0;
            }
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = l;
            hVar.e(16128, objArr);
            this.ySL = false;
            this.ySN.clear();
        }
        AppMethodBeat.o(31802);
    }

    private static void c(int i, bi biVar) {
        AppMethodBeat.i(31803);
        if (biVar == null) {
            AppMethodBeat.o(31803);
            return;
        }
        fu fuVar = new fu();
        fuVar.czM.czO = 0;
        fuVar.czM.czP = 0;
        fuVar.czM.czQ = 0;
        fuVar.czM.czN = 0;
        fuVar.czM.fileName = biVar.field_imgPath;
        fuVar.czM.result = i;
        com.tencent.mm.sdk.b.a.xxA.m(fuVar);
        AppMethodBeat.o(31803);
    }

    private void notifyDataSetChanged() {
        AppMethodBeat.i(31805);
        if (this.cgL != null) {
            this.cgL.aWv();
        }
        AppMethodBeat.o(31805);
    }

    private Context getContext() {
        AppMethodBeat.i(31806);
        if (this.cgL != null) {
            Activity context = this.cgL.yTx.getContext();
            AppMethodBeat.o(31806);
            return context;
        }
        Context context2 = ah.getContext();
        AppMethodBeat.o(31806);
        return context2;
    }

    private void art(String str) {
        AppMethodBeat.i(31807);
        if (!(this.cgL == null || this.cgL.yTx.getContext() == null)) {
            Toast makeText = Toast.makeText(this.cgL.yTx.getContext(), str, 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
        AppMethodBeat.o(31807);
    }

    public final synchronized boolean nm(long j) {
        boolean booleanValue;
        AppMethodBeat.i(31808);
        Boolean bool = (Boolean) ySK.get(Long.valueOf(j));
        if (bool != null) {
            booleanValue = bool.booleanValue();
            AppMethodBeat.o(31808);
        } else {
            booleanValue = false;
            AppMethodBeat.o(31808);
        }
        return booleanValue;
    }

    private synchronized void nn(long j) {
        AppMethodBeat.i(31809);
        ySK.put(Long.valueOf(j), Boolean.FALSE);
        AppMethodBeat.o(31809);
    }

    private int dFk() {
        int i;
        AppMethodBeat.i(31810);
        if (t.mZ(this.cgL.getTalkerUserName())) {
            boolean dDn = ((d) this.cgL.aF(d.class)).dDn();
            if (((d) this.cgL.aF(d.class)).dDm()) {
                if (dDn) {
                    i = 5;
                } else {
                    i = 4;
                }
            } else if (f.rb(this.cgL.getTalkerUserName())) {
                i = 3;
            } else if (f.rc(this.cgL.getTalkerUserName())) {
                i = 0;
            } else if (f.qY(this.cgL.getTalkerUserName())) {
                i = 6;
            } else {
                i = 7;
            }
        } else if (this.cgL.dFw()) {
            i = 2;
        } else {
            i = 1;
        }
        AppMethodBeat.o(31810);
        return i;
    }

    public final void dxB() {
        AppMethodBeat.i(31811);
        ab.i("MicroMsg.TransformComponent", "[onChattingPause]");
        OF(3);
        AppMethodBeat.o(31811);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(31813);
        super.onScroll(absListView, i, i2, i3);
        if (i < this.ySS) {
            this.iXQ = false;
        }
        this.ySS = i;
        AppMethodBeat.o(31813);
    }

    private synchronized void g(final bi biVar, final int i) {
        ak dFz;
        AppMethodBeat.i(31804);
        if (this.cgL != null) {
            dFz = com.tencent.mm.ui.chatting.d.a.dFz();
        } else {
            dFz = null;
        }
        if (dFz != null) {
            dFz.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31784);
                    Pair dFg = ao.this.dFg();
                    if (dFg != null) {
                        if (ao.this.ySL) {
                            ao.b(ao.this, 4);
                        }
                        ao.this.a((bi) dFg.first, false, ((Integer) dFg.second).intValue(), 0);
                        AppMethodBeat.o(31784);
                        return;
                    }
                    if (i != -1) {
                        bi Ou = ((com.tencent.mm.ui.chatting.c.b.h) ao.this.cgL.aF(com.tencent.mm.ui.chatting.c.b.h.class)).Ou(i + 1);
                        if (Ou != null && Ou.drD() && Ou.field_isSend == 0 && ao.this.ySM) {
                            ao.this.ySM = false;
                            ao.b(ao.this, 2);
                            AppMethodBeat.o(31784);
                            return;
                        } else if (Ou == null || !Ou.drD() || Ou.field_isSend != 0 || q.K(Ou)) {
                            ao.b(ao.this, 0);
                        } else {
                            if (!ao.this.ySL) {
                                ao.this.ySN.add(Long.valueOf(biVar.field_msgId));
                            }
                            ao.this.ySL = true;
                            ao.this.ySN.add(Long.valueOf(Ou.field_msgId));
                            q.M(Ou);
                            ao.this.a(Ou, false, i + 1, 0);
                            AppMethodBeat.o(31784);
                            return;
                        }
                    }
                    AppMethodBeat.o(31784);
                }
            });
        }
        AppMethodBeat.o(31804);
    }

    public final void dxD() {
        AppMethodBeat.i(31812);
        ab.i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
        dFh();
        ySI.clear();
        ySJ.clear();
        ySK.clear();
        if (this.ySO) {
            fq fqVar = new fq();
            fqVar.czB.czE = 3;
            com.tencent.mm.sdk.b.a.xxA.m(fqVar);
            this.ySO = false;
        }
        ab.i("MicroMsg.TransformComponent", "alvinluo hide transformText");
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(31785);
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (ao.this) {
                    try {
                        ao.ySK.clear();
                        ao.ySJ.clear();
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(31785);
                    }
                }
                ab.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }, "UnsetTransformFlag");
        AppMethodBeat.o(31812);
    }
}
