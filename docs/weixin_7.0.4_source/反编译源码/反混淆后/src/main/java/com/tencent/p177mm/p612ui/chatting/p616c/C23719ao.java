package com.tencent.p177mm.p612ui.chatting.p616c;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.widget.AbsListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p230g.p231a.C26138fq;
import com.tencent.p177mm.p230g.p231a.C37717fu;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p1091a.C15590a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46640ag;
import com.tencent.p177mm.p612ui.chatting.viewitems.ChattingItemTranslate.C5371b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C23514cc;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

@C15590a(dFp = C46640ag.class)
/* renamed from: com.tencent.mm.ui.chatting.c.ao */
public class C23719ao extends C44291a implements C46640ag {
    private static HashMap<Long, String> ySH = new HashMap();
    private static HashMap<Long, C5371b> ySI = new HashMap();
    private static LinkedHashMap<Long, Pair<C7620bi, Integer>> ySJ = new LinkedHashMap();
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

    /* renamed from: com.tencent.mm.ui.chatting.c.ao$3 */
    class C237223 implements Runnable {
        C237223() {
        }

        public final void run() {
            AppMethodBeat.m2504i(31785);
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (C23719ao.this) {
                try {
                    C23719ao.ySK.clear();
                    C23719ao.ySJ.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(31785);
                }
            }
            C4990ab.m7417i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public C23719ao() {
        AppMethodBeat.m2504i(31786);
        AppMethodBeat.m2505o(31786);
    }

    /* renamed from: a */
    static /* synthetic */ Context m36563a(C23719ao c23719ao) {
        AppMethodBeat.m2504i(31814);
        Context context = c23719ao.getContext();
        AppMethodBeat.m2505o(31814);
        return context;
    }

    /* renamed from: b */
    static /* synthetic */ void m36569b(C23719ao c23719ao) {
        AppMethodBeat.m2504i(31818);
        c23719ao.notifyDataSetChanged();
        AppMethodBeat.m2505o(31818);
    }

    static {
        AppMethodBeat.m2504i(31823);
        AppMethodBeat.m2505o(31823);
    }

    /* renamed from: a */
    public final synchronized void mo39552a(long j, String str, C5371b c5371b) {
        AppMethodBeat.m2504i(31787);
        ySH.put(Long.valueOf(j), str);
        ySI.put(Long.valueOf(j), c5371b);
        if (c5371b == C5371b.Transformed) {
            ySK.put(Long.valueOf(j), Boolean.TRUE);
        }
        AppMethodBeat.m2505o(31787);
    }

    /* renamed from: nh */
    private synchronized void m36580nh(long j) {
        AppMethodBeat.m2504i(31788);
        ySH.remove(Long.valueOf(j));
        ySI.remove(Long.valueOf(j));
        AppMethodBeat.m2505o(31788);
    }

    /* renamed from: C */
    public final synchronized String mo39550C(long j, String str) {
        String str2;
        AppMethodBeat.m2504i(31789);
        str2 = (String) ySH.get(Long.valueOf(j));
        if (C5046bo.isNullOrNil(str2)) {
            C23514cc aqb = C26500m.amb().aqb(str);
            if (!(aqb == null || C5046bo.isNullOrNil(aqb.field_content))) {
                str2 = aqb.field_content;
            }
        }
        AppMethodBeat.m2505o(31789);
        return str2;
    }

    /* renamed from: ni */
    public final synchronized C5371b mo39557ni(long j) {
        C5371b c5371b;
        AppMethodBeat.m2504i(31790);
        c5371b = (C5371b) ySI.get(Long.valueOf(j));
        if (c5371b == null) {
            c5371b = C5371b.NoTransform;
        }
        AppMethodBeat.m2505o(31790);
        return c5371b;
    }

    /* renamed from: a */
    private synchronized void m36564a(long j, C7620bi c7620bi, int i) {
        AppMethodBeat.m2504i(31791);
        ySJ.put(Long.valueOf(j), new Pair(c7620bi, Integer.valueOf(i)));
        AppMethodBeat.m2505o(31791);
    }

    /* renamed from: nj */
    public final synchronized boolean mo39558nj(long j) {
        boolean z;
        AppMethodBeat.m2504i(31792);
        if (ySJ.containsKey(Long.valueOf(j))) {
            z = true;
            AppMethodBeat.m2505o(31792);
        } else {
            z = false;
            AppMethodBeat.m2505o(31792);
        }
        return z;
    }

    /* renamed from: nk */
    private synchronized C7620bi m36581nk(long j) {
        C7620bi c7620bi;
        AppMethodBeat.m2504i(31793);
        Pair pair = (Pair) ySJ.get(Long.valueOf(j));
        if (pair == null) {
            c7620bi = null;
            AppMethodBeat.m2505o(31793);
        } else {
            c7620bi = (C7620bi) pair.first;
            AppMethodBeat.m2505o(31793);
        }
        return c7620bi;
    }

    public final synchronized Pair<C7620bi, Integer> dFg() {
        Pair<C7620bi, Integer> pair;
        AppMethodBeat.m2504i(31794);
        Iterator it = ySJ.entrySet().iterator();
        if (it.hasNext()) {
            pair = (Pair) ((Entry) it.next()).getValue();
            AppMethodBeat.m2505o(31794);
        } else {
            pair = null;
            AppMethodBeat.m2505o(31794);
        }
        return pair;
    }

    /* renamed from: nl */
    private synchronized void m36582nl(long j) {
        AppMethodBeat.m2504i(31795);
        if (ySJ.containsKey(Long.valueOf(j))) {
            ySJ.remove(Long.valueOf(j));
        }
        AppMethodBeat.m2505o(31795);
    }

    private synchronized void dFh() {
        AppMethodBeat.m2504i(31796);
        ySJ.clear();
        AppMethodBeat.m2505o(31796);
    }

    public final boolean dFi() {
        AppMethodBeat.m2504i(31797);
        C9638aw.m17190ZK();
        if (((Boolean) C18628c.m29072Ry().get(75, Boolean.FALSE)).booleanValue()) {
            AppMethodBeat.m2505o(31797);
            return false;
        }
        AppMethodBeat.m2505o(31797);
        return true;
    }

    public final void dFj() {
        AppMethodBeat.m2504i(31798);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(75, Boolean.TRUE);
        AppMethodBeat.m2505o(31798);
    }

    /* renamed from: OF */
    public final void mo39551OF(int i) {
        AppMethodBeat.m2504i(31799);
        if (i == 2) {
            this.ySM = true;
            AppMethodBeat.m2505o(31799);
            return;
        }
        if (this.ySO) {
            mo39553a(m36581nk(this.ySP), true, -1, i);
        }
        AppMethodBeat.m2505o(31799);
    }

    /* renamed from: a */
    public final void mo39553a(final C7620bi c7620bi, boolean z, final int i, int i2) {
        AppMethodBeat.m2504i(31800);
        if (c7620bi == null) {
            C4990ab.m7410d("MicroMsg.TransformComponent", "go VoiceTransTextAct need MsgInfo but null");
            AppMethodBeat.m2505o(31800);
        } else if (mo39559nm(c7620bi.field_msgId)) {
            C4990ab.m7417i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", Long.valueOf(c7620bi.field_msgId), Boolean.valueOf(this.ySO));
            c7620bi.dtT();
            m36583nn(c7620bi.field_msgId);
            notifyDataSetChanged();
            AppMethodBeat.m2505o(31800);
        } else {
            C26138fq c26138fq;
            if (mo39558nj(c7620bi.field_msgId) && z) {
                if (mo39557ni(c7620bi.field_msgId) == C5371b.PreTransform) {
                    C4990ab.m7416i("MicroMsg.TransformComponent", "go VoiceTransTextAct unsetflag removeCache");
                    m36582nl(c7620bi.field_msgId);
                    m36580nh(c7620bi.field_msgId);
                    C23719ao.m36573c(5, c7620bi);
                } else if (this.ySO) {
                    c26138fq = new C26138fq();
                    c26138fq.czB.czE = 3;
                    C4879a.xxA.mo10055m(c26138fq);
                    m36582nl(c7620bi.field_msgId);
                    m36580nh(c7620bi.field_msgId);
                    c7620bi.dtT();
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                    this.ySO = false;
                    m36578g(c7620bi, -1);
                }
                notifyDataSetChanged();
                if (z) {
                    m36562OH(i2);
                    AppMethodBeat.m2505o(31800);
                    return;
                }
            }
            C23514cc aqb = C26500m.amb().aqb(c7620bi.field_imgPath);
            if (aqb == null || C5046bo.isNullOrNil(aqb.field_content)) {
                int acS = C9638aw.m17182Rg().acS();
                if (acS == 4 || acS == 6) {
                    if (this.ySO) {
                        C4990ab.m7416i("MicroMsg.TransformComponent", "go VoiceTransformText insert transformQueue");
                        m36564a(c7620bi.field_msgId, c7620bi, i);
                        mo39552a(c7620bi.field_msgId, "", C5371b.PreTransform);
                        notifyDataSetChanged();
                    } else {
                        c26138fq = new C26138fq();
                        c26138fq.czB.czE = 1;
                        C4879a.xxA.mo10055m(c26138fq);
                        c26138fq = new C26138fq();
                        c26138fq.czB.czD = String.valueOf(c7620bi.field_msgId);
                        c26138fq.czB.fileName = c7620bi.field_imgPath;
                        c26138fq.czB.from = 1;
                        c26138fq.czB.czE = 0;
                        c26138fq.czB.scene = dFk();
                        c26138fq.czB.czF = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(31783);
                                if (!C23719ao.this.mo39558nj(Long.valueOf(c26138fq.czB.czD).longValue())) {
                                    AppMethodBeat.m2505o(31783);
                                } else if (c26138fq.czC.bcU) {
                                    if (C5046bo.isNullOrNil(c26138fq.czC.content)) {
                                        if (c26138fq.czC.state == 2) {
                                            C4990ab.m7417i("MicroMsg.TransformComponent", "go VoiceTransTextAct translateVoice fail msgId:%s", c26138fq.czB.czD);
                                            C23719ao.m36568a(C23719ao.this, C23719ao.m36563a(C23719ao.this).getString(C25738R.string.aos));
                                        }
                                        C23719ao.m36566a(C23719ao.this, Long.valueOf(c26138fq.czB.czD).longValue());
                                        C23719ao.m36571b(C23719ao.this, Long.valueOf(c26138fq.czB.czD).longValue());
                                        C23719ao.this.ySO = false;
                                        C23719ao.m36569b(C23719ao.this);
                                    } else {
                                        C4990ab.m7417i("MicroMsg.TransformComponent", "go VoiceTransTextAct isCompleted msgId:%s", c26138fq.czB.czD);
                                        C7620bi c = C23719ao.m36572c(C23719ao.this, Long.valueOf(c26138fq.czB.czD).longValue());
                                        if (c != null) {
                                            C23719ao.this.mo39552a(Long.valueOf(c26138fq.czB.czD).longValue(), c26138fq.czC.content, C5371b.Transformed);
                                            c.dtU();
                                            C9638aw.m17190ZK();
                                            C18628c.m29080XO().mo15284a(c.field_msgId, c);
                                            C23719ao.m36571b(C23719ao.this, Long.valueOf(c26138fq.czB.czD).longValue());
                                            C23719ao.m36569b(C23719ao.this);
                                            C23719ao.m36565a(C23719ao.this, i);
                                        }
                                        C23719ao.this.ySO = false;
                                    }
                                    C23719ao.m36567a(C23719ao.this, c7620bi, i);
                                    AppMethodBeat.m2505o(31783);
                                } else {
                                    if (!C5046bo.isNullOrNil(c26138fq.czC.content)) {
                                        C23719ao.this.mo39552a(Long.valueOf(c26138fq.czB.czD).longValue(), c26138fq.czC.content, C5371b.Transforming);
                                        C4990ab.m7417i("MicroMsg.TransformComponent", "go VoiceTransTextAct refresh msgId:%s", c26138fq.czB.czD);
                                    }
                                    C23719ao.m36569b(C23719ao.this);
                                    C23719ao.m36565a(C23719ao.this, i);
                                    AppMethodBeat.m2505o(31783);
                                }
                            }
                        };
                        mo39552a(Long.valueOf(c26138fq.czB.czD).longValue(), "", C5371b.Transforming);
                        m36564a(c7620bi.field_msgId, c7620bi, i);
                        this.ySO = true;
                        this.ySP = c7620bi.field_msgId;
                        notifyDataSetChanged();
                        m36561OG(i);
                        if (C4879a.xxA.mo10055m(c26138fq)) {
                            C4990ab.m7416i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
                        } else {
                            C4990ab.m7416i("MicroMsg.TransformComponent", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
                            art(getContext().getString(C25738R.string.aos));
                            m36580nh(Long.valueOf(c26138fq.czB.czD).longValue());
                            m36582nl(Long.valueOf(c26138fq.czB.czD).longValue());
                            this.ySO = false;
                            m36578g(c7620bi, i);
                        }
                    }
                    if (z) {
                        this.iXQ = true;
                    }
                } else {
                    C30379h.m48467g(getContext(), C25738R.string.aot, C25738R.string.f9238tz);
                    C23719ao.m36573c(2, c7620bi);
                    this.ySL = false;
                    AppMethodBeat.m2505o(31800);
                    return;
                }
            }
            C4990ab.m7417i("MicroMsg.TransformComponent", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", Long.valueOf(c7620bi.field_msgId), c7620bi.field_imgPath);
            c7620bi.dtU();
            mo39552a(c7620bi.field_msgId, aqb.field_content, C5371b.Transformed);
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            this.ySL = false;
            m36561OG(i);
            AppMethodBeat.m2505o(31800);
            return;
            AppMethodBeat.m2505o(31800);
        }
    }

    /* renamed from: OG */
    private void m36561OG(int i) {
        AppMethodBeat.m2504i(31801);
        if (this.iXQ && i != -1) {
            this.cgL.mo74861bY(i);
        }
        AppMethodBeat.m2505o(31801);
    }

    /* renamed from: OH */
    private void m36562OH(int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(31802);
        if (this.ySL && this.ySN.size() > 0) {
            String l = ((Long) this.ySN.get(0)).toString();
            for (int i3 = 1; i3 < this.ySN.size(); i3++) {
                l = l + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + this.ySN.get(i3);
            }
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(this.ySN.size());
            if (this.iXQ) {
                i2 = 0;
            }
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = l;
            c7060h.mo8381e(16128, objArr);
            this.ySL = false;
            this.ySN.clear();
        }
        AppMethodBeat.m2505o(31802);
    }

    /* renamed from: c */
    private static void m36573c(int i, C7620bi c7620bi) {
        AppMethodBeat.m2504i(31803);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(31803);
            return;
        }
        C37717fu c37717fu = new C37717fu();
        c37717fu.czM.czO = 0;
        c37717fu.czM.czP = 0;
        c37717fu.czM.czQ = 0;
        c37717fu.czM.czN = 0;
        c37717fu.czM.fileName = c7620bi.field_imgPath;
        c37717fu.czM.result = i;
        C4879a.xxA.mo10055m(c37717fu);
        AppMethodBeat.m2505o(31803);
    }

    private void notifyDataSetChanged() {
        AppMethodBeat.m2504i(31805);
        if (this.cgL != null) {
            this.cgL.aWv();
        }
        AppMethodBeat.m2505o(31805);
    }

    private Context getContext() {
        AppMethodBeat.m2504i(31806);
        if (this.cgL != null) {
            Activity context = this.cgL.yTx.getContext();
            AppMethodBeat.m2505o(31806);
            return context;
        }
        Context context2 = C4996ah.getContext();
        AppMethodBeat.m2505o(31806);
        return context2;
    }

    private void art(String str) {
        AppMethodBeat.m2504i(31807);
        if (!(this.cgL == null || this.cgL.yTx.getContext() == null)) {
            Toast makeText = Toast.makeText(this.cgL.yTx.getContext(), str, 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
        AppMethodBeat.m2505o(31807);
    }

    /* renamed from: nm */
    public final synchronized boolean mo39559nm(long j) {
        boolean booleanValue;
        AppMethodBeat.m2504i(31808);
        Boolean bool = (Boolean) ySK.get(Long.valueOf(j));
        if (bool != null) {
            booleanValue = bool.booleanValue();
            AppMethodBeat.m2505o(31808);
        } else {
            booleanValue = false;
            AppMethodBeat.m2505o(31808);
        }
        return booleanValue;
    }

    /* renamed from: nn */
    private synchronized void m36583nn(long j) {
        AppMethodBeat.m2504i(31809);
        ySK.put(Long.valueOf(j), Boolean.FALSE);
        AppMethodBeat.m2505o(31809);
    }

    private int dFk() {
        int i;
        AppMethodBeat.m2504i(31810);
        if (C1855t.m3913mZ(this.cgL.getTalkerUserName())) {
            boolean dDn = ((C36135d) this.cgL.mo74857aF(C36135d.class)).dDn();
            if (((C36135d) this.cgL.mo74857aF(C36135d.class)).dDm()) {
                if (dDn) {
                    i = 5;
                } else {
                    i = 4;
                }
            } else if (C17903f.m28108rb(this.cgL.getTalkerUserName())) {
                i = 3;
            } else if (C17903f.m28109rc(this.cgL.getTalkerUserName())) {
                i = 0;
            } else if (C17903f.m28105qY(this.cgL.getTalkerUserName())) {
                i = 6;
            } else {
                i = 7;
            }
        } else if (this.cgL.dFw()) {
            i = 2;
        } else {
            i = 1;
        }
        AppMethodBeat.m2505o(31810);
        return i;
    }

    public final void dxB() {
        AppMethodBeat.m2504i(31811);
        C4990ab.m7416i("MicroMsg.TransformComponent", "[onChattingPause]");
        mo39551OF(3);
        AppMethodBeat.m2505o(31811);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(31813);
        super.onScroll(absListView, i, i2, i3);
        if (i < this.ySS) {
            this.iXQ = false;
        }
        this.ySS = i;
        AppMethodBeat.m2505o(31813);
    }

    /* renamed from: g */
    private synchronized void m36578g(final C7620bi c7620bi, final int i) {
        C7306ak dFz;
        AppMethodBeat.m2504i(31804);
        if (this.cgL != null) {
            dFz = C46650a.dFz();
        } else {
            dFz = null;
        }
        if (dFz != null) {
            dFz.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(31784);
                    Pair dFg = C23719ao.this.dFg();
                    if (dFg != null) {
                        if (C23719ao.this.ySL) {
                            C23719ao.m36570b(C23719ao.this, 4);
                        }
                        C23719ao.this.mo39553a((C7620bi) dFg.first, false, ((Integer) dFg.second).intValue(), 0);
                        AppMethodBeat.m2505o(31784);
                        return;
                    }
                    if (i != -1) {
                        C7620bi Ou = ((C15612h) C23719ao.this.cgL.mo74857aF(C15612h.class)).mo27798Ou(i + 1);
                        if (Ou != null && Ou.drD() && Ou.field_isSend == 0 && C23719ao.this.ySM) {
                            C23719ao.this.ySM = false;
                            C23719ao.m36570b(C23719ao.this, 2);
                            AppMethodBeat.m2505o(31784);
                            return;
                        } else if (Ou == null || !Ou.drD() || Ou.field_isSend != 0 || C32850q.m53704K(Ou)) {
                            C23719ao.m36570b(C23719ao.this, 0);
                        } else {
                            if (!C23719ao.this.ySL) {
                                C23719ao.this.ySN.add(Long.valueOf(c7620bi.field_msgId));
                            }
                            C23719ao.this.ySL = true;
                            C23719ao.this.ySN.add(Long.valueOf(Ou.field_msgId));
                            C32850q.m53706M(Ou);
                            C23719ao.this.mo39553a(Ou, false, i + 1, 0);
                            AppMethodBeat.m2505o(31784);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(31784);
                }
            });
        }
        AppMethodBeat.m2505o(31804);
    }

    public final void dxD() {
        AppMethodBeat.m2504i(31812);
        C4990ab.m7416i("MicroMsg.TransformComponent", "clear VoiceTransTextAct");
        dFh();
        ySI.clear();
        ySJ.clear();
        ySK.clear();
        if (this.ySO) {
            C26138fq c26138fq = new C26138fq();
            c26138fq.czB.czE = 3;
            C4879a.xxA.mo10055m(c26138fq);
            this.ySO = false;
        }
        C4990ab.m7416i("MicroMsg.TransformComponent", "alvinluo hide transformText");
        C7305d.post(new C237223(), "UnsetTransformFlag");
        AppMethodBeat.m2505o(31812);
    }
}
