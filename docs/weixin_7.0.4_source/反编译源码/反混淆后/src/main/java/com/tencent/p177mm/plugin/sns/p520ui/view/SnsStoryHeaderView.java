package com.tencent.p177mm.plugin.sns.p520ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C46879av;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.widget.StoryAvatarDotsView;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.story.api.C29269k.C29270b;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView */
public class SnsStoryHeaderView extends FrameLayout implements C29270b {
    public boolean cAY;
    private boolean cNN;
    private String cvF;
    private List<String> fxt;
    private View jOT;
    private String qSf;
    private int rMi;
    private int rMj;
    public boolean rMk;
    private TextView rMl;
    private StoryAvatarDotsView rMm;
    private TextView rMn;
    private TextView rMo;
    private int rMp;
    private int rMq;
    private String rMr;
    private int rMs;
    private C29246a rMt;

    /* renamed from: com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView$1 */
    class C221471 implements OnClickListener {
        C221471() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40420);
            if (SnsStoryHeaderView.this.rMt != null) {
                SnsStoryHeaderView.this.rMt.cun();
            }
            C7060h.pYm.mo15419k(1015, 5, 1);
            SnsStoryHeaderView.m46432b(SnsStoryHeaderView.this);
            AppMethodBeat.m2505o(40420);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView$2 */
    public class C292442 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(40421);
            SnsStoryHeaderView.m46433c(SnsStoryHeaderView.this);
            AppMethodBeat.m2505o(40421);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView$3 */
    class C292453 implements Runnable {
        C292453() {
        }

        public final void run() {
            AppMethodBeat.m2504i(40422);
            SnsStoryHeaderView.m46434d(SnsStoryHeaderView.this);
            if (SnsStoryHeaderView.this.fxt.size() > 0) {
                ((C35168e) C1720g.m3530M(C35168e.class)).preloadForSnsUser((String) SnsStoryHeaderView.this.fxt.get(0), false);
            }
            AppMethodBeat.m2505o(40422);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView$a */
    public interface C29246a {
        void cun();
    }

    /* renamed from: c */
    static /* synthetic */ void m46433c(SnsStoryHeaderView snsStoryHeaderView) {
        AppMethodBeat.m2504i(40433);
        snsStoryHeaderView.cvt();
        AppMethodBeat.m2505o(40433);
    }

    /* renamed from: d */
    static /* synthetic */ void m46434d(SnsStoryHeaderView snsStoryHeaderView) {
        AppMethodBeat.m2504i(40434);
        snsStoryHeaderView.cvq();
        AppMethodBeat.m2505o(40434);
    }

    public void setStoryAction(C29246a c29246a) {
        this.rMt = c29246a;
    }

    public SnsStoryHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SnsStoryHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(40423);
        this.rMj = Downloads.MIN_WAIT_FOR_NETWORK;
        this.fxt = new LinkedList();
        this.cvF = null;
        this.qSf = null;
        this.cAY = false;
        this.rMk = false;
        this.rMp = 0;
        this.rMq = 0;
        this.rMr = "";
        this.rMs = 0;
        this.cNN = true;
        int i2 = C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_STORY_SNS_HEADER_TYPE_INT, 0);
        if (i2 > 0) {
            this.rMj = i2;
        } else {
            this.rMj = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_story_sns_story_open, (int) Downloads.MIN_WAIT_FOR_NETWORK);
        }
        if (((C35168e) C1720g.m3530M(C35168e.class)).getStoryUserInfo().xeE == 1) {
            this.rMj = 10001;
        }
        C4990ab.m7417i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", Integer.valueOf(this.rMj), Integer.valueOf(i2));
        SnsStoryHeaderView.inflate(getContext(), 2130970802, this);
        this.jOT = findViewById(2131827851);
        this.rMl = (TextView) findViewById(2131827855);
        this.rMm = (StoryAvatarDotsView) findViewById(2131827854);
        this.rMn = (TextView) findViewById(2131827853);
        this.rMo = (TextView) findViewById(2131827856);
        this.jOT.setOnClickListener(new C221471());
        AppMethodBeat.m2505o(40423);
    }

    public void setSnsType(int i) {
        AppMethodBeat.m2504i(40424);
        this.rMi = i;
        cvq();
        if (this.fxt.size() > 0) {
            ((C35168e) C1720g.m3530M(C35168e.class)).preloadForSnsUser((String) this.fxt.get(0), true);
        }
        AppMethodBeat.m2505o(40424);
    }

    public void setSessionId(String str) {
        this.cvF = str;
    }

    public void setEnterObjectId(String str) {
        this.qSf = str;
    }

    private void cvq() {
        AppMethodBeat.m2504i(40425);
        this.fxt.clear();
        if (this.rMi != 1 || this.rMj == Downloads.MIN_WAIT_FOR_NETWORK || this.rMj == 10001) {
            this.jOT.setVisibility(8);
            this.rMk = false;
        } else if (this.rMj == 2) {
            cvs();
            ((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().mo47452a(this);
        } else {
            C7060h.pYm.mo15419k(1006, 0, 1);
            C7060h.pYm.mo15419k(1015, 0, 1);
            cvr();
            ((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().mo47452a(this);
        }
        if (this.fxt.size() == 0) {
            this.jOT.setVisibility(8);
            this.rMk = false;
        } else {
            this.jOT.setVisibility(0);
            if (!this.cAY) {
                cvt();
            }
        }
        if (((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().cxa().isEmpty()) {
            this.rMo.setVisibility(8);
            AppMethodBeat.m2505o(40425);
            return;
        }
        this.rMo.setVisibility(0);
        this.rMo.setText(String.valueOf(((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().cxb()));
        AppMethodBeat.m2505o(40425);
    }

    private void cvr() {
        int size;
        AppMethodBeat.m2504i(40426);
        List cwY = ((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().cwY();
        List cwZ = ((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().cwZ();
        if (cwY.size() > 0) {
            size = cwY.size();
        } else {
            size = 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().cxa().keySet());
        this.rMq = size;
        this.fxt.addAll(cwY);
        this.fxt.addAll(cwZ);
        this.fxt.addAll(arrayList);
        this.rMl.setText(getResources().getString(C25738R.string.eol));
        m46435dA(cwY);
        this.rMn.setTextColor(getContext().getResources().getColor(C25738R.color.f11627l));
        C4990ab.m7417i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", Integer.valueOf(C26373g.m41964Nu().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3)));
        if (cwY.size() > 0) {
            C7060h.pYm.mo15419k(1015, 1, 1);
        } else {
            C7060h.pYm.mo15419k(1015, 2, 1);
        }
        if (this.fxt.size() == 0) {
            C7060h.pYm.mo15419k(1015, 3, 1);
        }
        int b;
        if (size > b) {
            b = C4977b.m7371b(getContext(), 4.0f);
            this.rMn.setPadding(b, 0, b, 0);
            this.rMn.setText(String.format("%s", new Object[]{Integer.valueOf(size)}));
            AppMethodBeat.m2505o(40426);
            return;
        }
        this.rMn.setPadding(0, 0, 0, 0);
        this.rMn.setText("");
        AppMethodBeat.m2505o(40426);
    }

    private void cvs() {
        AppMethodBeat.m2504i(40427);
        List cwY = ((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().cwY();
        List cxc = ((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().cxc();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((C35168e) C1720g.m3530M(C35168e.class)).getContactFetcher().cxa().keySet());
        this.fxt.addAll(cwY);
        this.fxt.addAll(cxc);
        this.fxt.addAll(arrayList);
        this.rMl.setText(getResources().getString(C25738R.string.eoj));
        m46435dA(cwY);
        AppMethodBeat.m2505o(40427);
    }

    /* renamed from: dA */
    private void m46435dA(List<String> list) {
        AppMethodBeat.m2504i(40428);
        this.rMm.setIconSize(C1338a.fromDPToPix(getContext(), 26));
        this.rMm.setIconGap(C1338a.fromDPToPix(getContext(), 16));
        this.rMp = 0;
        if (list.size() > 0) {
            this.rMm.setVisibility(0);
            this.rMm.setIconLayerCount(Math.min(list.size(), 3));
            this.rMp = this.rMm.getChildCount();
            for (int i = 0; i < this.rMm.getChildCount(); i++) {
                C40460b.m69433a(this.rMm.mo28298qf(i), (String) list.get(i), 0.5f, false);
                this.rMm.mo28298qf(i).setBackground(getResources().getDrawable(C25738R.drawable.a1j));
                this.rMm.mo28298qf(i).setPadding(C1338a.fromDPToPix(getContext(), 1), C1338a.fromDPToPix(getContext(), 1), C1338a.fromDPToPix(getContext(), 1), C1338a.fromDPToPix(getContext(), 1));
            }
            AppMethodBeat.m2505o(40428);
            return;
        }
        this.rMm.setVisibility(8);
        AppMethodBeat.m2505o(40428);
    }

    public final void cvt() {
        AppMethodBeat.m2504i(40429);
        if (this.cNN) {
            if (this.jOT.getVisibility() == 0) {
                int[] iArr = new int[2];
                this.jOT.getLocationOnScreen(iArr);
                if (iArr[1] <= 0) {
                    this.rMk = false;
                } else if (!this.rMk) {
                    this.rMk = true;
                    cvu();
                }
                C4990ab.m7417i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", Boolean.valueOf(this.rMk));
            }
            AppMethodBeat.m2505o(40429);
            return;
        }
        this.jOT.setVisibility(8);
        AppMethodBeat.m2505o(40429);
    }

    private void cvu() {
        AppMethodBeat.m2504i(40430);
        C4990ab.m7416i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
        if (this.fxt.size() <= 0) {
            AppMethodBeat.m2505o(40430);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (this.rMp > 0) {
            stringBuilder.append((String) this.fxt.get(0));
        }
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 < this.rMp) {
                stringBuilder.append("|").append((String) this.fxt.get(i2));
                i = i2 + 1;
            } else {
                C46879av c46879av = new C46879av();
                c46879av.mo76057fH(this.qSf);
                this.rMr = "99_".concat(String.valueOf(System.currentTimeMillis()));
                c46879av.mo76058fI(this.rMr);
                c46879av.dam = (long) this.rMp;
                c46879av.mo76059fJ(stringBuilder.toString());
                c46879av.dao = (long) this.rMq;
                c46879av.ajK();
                this.rMs++;
                AppMethodBeat.m2505o(40430);
                return;
            }
        }
    }

    public final void cvv() {
        AppMethodBeat.m2504i(40431);
        C5004al.m7441d(new C292453());
        AppMethodBeat.m2505o(40431);
    }

    /* renamed from: b */
    static /* synthetic */ void m46432b(SnsStoryHeaderView snsStoryHeaderView) {
        AppMethodBeat.m2504i(40432);
        C4990ab.m7417i("MicroMsg.SnsStoryHeaderView", "goToStoryGallery: %s", Integer.valueOf(snsStoryHeaderView.fxt.size()));
        if (snsStoryHeaderView.fxt.size() > 0) {
            ((C35168e) C1720g.m3530M(C35168e.class)).showStoryEntranceDialog(snsStoryHeaderView.getContext(), snsStoryHeaderView.rMr, snsStoryHeaderView.rMs);
        }
        AppMethodBeat.m2505o(40432);
    }
}
