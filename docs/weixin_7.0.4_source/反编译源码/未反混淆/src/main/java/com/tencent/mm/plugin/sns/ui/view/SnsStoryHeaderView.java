package com.tencent.mm.plugin.sns.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.k.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsStoryHeaderView extends FrameLayout implements b {
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
    private a rMt;

    public interface a {
        void cun();
    }

    static /* synthetic */ void c(SnsStoryHeaderView snsStoryHeaderView) {
        AppMethodBeat.i(40433);
        snsStoryHeaderView.cvt();
        AppMethodBeat.o(40433);
    }

    static /* synthetic */ void d(SnsStoryHeaderView snsStoryHeaderView) {
        AppMethodBeat.i(40434);
        snsStoryHeaderView.cvq();
        AppMethodBeat.o(40434);
    }

    public void setStoryAction(a aVar) {
        this.rMt = aVar;
    }

    public SnsStoryHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SnsStoryHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40423);
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
        int i2 = g.RP().Ry().getInt(com.tencent.mm.storage.ac.a.USERINFO_STORY_SNS_HEADER_TYPE_INT, 0);
        if (i2 > 0) {
            this.rMj = i2;
        } else {
            this.rMj = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_story_sns_story_open, (int) Downloads.MIN_WAIT_FOR_NETWORK);
        }
        if (((e) g.M(e.class)).getStoryUserInfo().xeE == 1) {
            this.rMj = 10001;
        }
        ab.i("MicroMsg.SnsStoryHeaderView", "init: headerType %s configType %s", Integer.valueOf(this.rMj), Integer.valueOf(i2));
        inflate(getContext(), R.layout.awc, this);
        this.jOT = findViewById(R.id.eli);
        this.rMl = (TextView) findViewById(R.id.elm);
        this.rMm = (StoryAvatarDotsView) findViewById(R.id.ell);
        this.rMn = (TextView) findViewById(R.id.elk);
        this.rMo = (TextView) findViewById(R.id.eln);
        this.jOT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40420);
                if (SnsStoryHeaderView.this.rMt != null) {
                    SnsStoryHeaderView.this.rMt.cun();
                }
                h.pYm.k(1015, 5, 1);
                SnsStoryHeaderView.b(SnsStoryHeaderView.this);
                AppMethodBeat.o(40420);
            }
        });
        AppMethodBeat.o(40423);
    }

    public void setSnsType(int i) {
        AppMethodBeat.i(40424);
        this.rMi = i;
        cvq();
        if (this.fxt.size() > 0) {
            ((e) g.M(e.class)).preloadForSnsUser((String) this.fxt.get(0), true);
        }
        AppMethodBeat.o(40424);
    }

    public void setSessionId(String str) {
        this.cvF = str;
    }

    public void setEnterObjectId(String str) {
        this.qSf = str;
    }

    private void cvq() {
        AppMethodBeat.i(40425);
        this.fxt.clear();
        if (this.rMi != 1 || this.rMj == Downloads.MIN_WAIT_FOR_NETWORK || this.rMj == 10001) {
            this.jOT.setVisibility(8);
            this.rMk = false;
        } else if (this.rMj == 2) {
            cvs();
            ((e) g.M(e.class)).getContactFetcher().a(this);
        } else {
            h.pYm.k(1006, 0, 1);
            h.pYm.k(1015, 0, 1);
            cvr();
            ((e) g.M(e.class)).getContactFetcher().a(this);
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
        if (((e) g.M(e.class)).getContactFetcher().cxa().isEmpty()) {
            this.rMo.setVisibility(8);
            AppMethodBeat.o(40425);
            return;
        }
        this.rMo.setVisibility(0);
        this.rMo.setText(String.valueOf(((e) g.M(e.class)).getContactFetcher().cxb()));
        AppMethodBeat.o(40425);
    }

    private void cvr() {
        int size;
        AppMethodBeat.i(40426);
        List cwY = ((e) g.M(e.class)).getContactFetcher().cwY();
        List cwZ = ((e) g.M(e.class)).getContactFetcher().cwZ();
        if (cwY.size() > 0) {
            size = cwY.size();
        } else {
            size = 0;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((e) g.M(e.class)).getContactFetcher().cxa().keySet());
        this.rMq = size;
        this.fxt.addAll(cwY);
        this.fxt.addAll(cwZ);
        this.fxt.addAll(arrayList);
        this.rMl.setText(getResources().getString(R.string.eol));
        dA(cwY);
        this.rMn.setTextColor(getContext().getResources().getColor(R.color.l));
        ab.i("MicroMsg.SnsStoryHeaderView", "initTypeNew %s", Integer.valueOf(com.tencent.mm.m.g.Nu().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3)));
        if (cwY.size() > 0) {
            h.pYm.k(1015, 1, 1);
        } else {
            h.pYm.k(1015, 2, 1);
        }
        if (this.fxt.size() == 0) {
            h.pYm.k(1015, 3, 1);
        }
        int b;
        if (size > b) {
            b = BackwardSupportUtil.b.b(getContext(), 4.0f);
            this.rMn.setPadding(b, 0, b, 0);
            this.rMn.setText(String.format("%s", new Object[]{Integer.valueOf(size)}));
            AppMethodBeat.o(40426);
            return;
        }
        this.rMn.setPadding(0, 0, 0, 0);
        this.rMn.setText("");
        AppMethodBeat.o(40426);
    }

    private void cvs() {
        AppMethodBeat.i(40427);
        List cwY = ((e) g.M(e.class)).getContactFetcher().cwY();
        List cxc = ((e) g.M(e.class)).getContactFetcher().cxc();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(((e) g.M(e.class)).getContactFetcher().cxa().keySet());
        this.fxt.addAll(cwY);
        this.fxt.addAll(cxc);
        this.fxt.addAll(arrayList);
        this.rMl.setText(getResources().getString(R.string.eoj));
        dA(cwY);
        AppMethodBeat.o(40427);
    }

    private void dA(List<String> list) {
        AppMethodBeat.i(40428);
        this.rMm.setIconSize(com.tencent.mm.bz.a.fromDPToPix(getContext(), 26));
        this.rMm.setIconGap(com.tencent.mm.bz.a.fromDPToPix(getContext(), 16));
        this.rMp = 0;
        if (list.size() > 0) {
            this.rMm.setVisibility(0);
            this.rMm.setIconLayerCount(Math.min(list.size(), 3));
            this.rMp = this.rMm.getChildCount();
            for (int i = 0; i < this.rMm.getChildCount(); i++) {
                com.tencent.mm.pluginsdk.ui.a.b.a(this.rMm.qf(i), (String) list.get(i), 0.5f, false);
                this.rMm.qf(i).setBackground(getResources().getDrawable(R.drawable.a1j));
                this.rMm.qf(i).setPadding(com.tencent.mm.bz.a.fromDPToPix(getContext(), 1), com.tencent.mm.bz.a.fromDPToPix(getContext(), 1), com.tencent.mm.bz.a.fromDPToPix(getContext(), 1), com.tencent.mm.bz.a.fromDPToPix(getContext(), 1));
            }
            AppMethodBeat.o(40428);
            return;
        }
        this.rMm.setVisibility(8);
        AppMethodBeat.o(40428);
    }

    public final void cvt() {
        AppMethodBeat.i(40429);
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
                ab.i("MicroMsg.SnsStoryHeaderView", "checkExpose: %s", Boolean.valueOf(this.rMk));
            }
            AppMethodBeat.o(40429);
            return;
        }
        this.jOT.setVisibility(8);
        AppMethodBeat.o(40429);
    }

    private void cvu() {
        AppMethodBeat.i(40430);
        ab.i("MicroMsg.SnsStoryHeaderView", "reportExpose: ");
        if (this.fxt.size() <= 0) {
            AppMethodBeat.o(40430);
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
                av avVar = new av();
                avVar.fH(this.qSf);
                this.rMr = "99_".concat(String.valueOf(System.currentTimeMillis()));
                avVar.fI(this.rMr);
                avVar.dam = (long) this.rMp;
                avVar.fJ(stringBuilder.toString());
                avVar.dao = (long) this.rMq;
                avVar.ajK();
                this.rMs++;
                AppMethodBeat.o(40430);
                return;
            }
        }
    }

    public final void cvv() {
        AppMethodBeat.i(40431);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(40422);
                SnsStoryHeaderView.d(SnsStoryHeaderView.this);
                if (SnsStoryHeaderView.this.fxt.size() > 0) {
                    ((e) g.M(e.class)).preloadForSnsUser((String) SnsStoryHeaderView.this.fxt.get(0), false);
                }
                AppMethodBeat.o(40422);
            }
        });
        AppMethodBeat.o(40431);
    }

    static /* synthetic */ void b(SnsStoryHeaderView snsStoryHeaderView) {
        AppMethodBeat.i(40432);
        ab.i("MicroMsg.SnsStoryHeaderView", "goToStoryGallery: %s", Integer.valueOf(snsStoryHeaderView.fxt.size()));
        if (snsStoryHeaderView.fxt.size() > 0) {
            ((e) g.M(e.class)).showStoryEntranceDialog(snsStoryHeaderView.getContext(), snsStoryHeaderView.rMr, snsStoryHeaderView.rMs);
        }
        AppMethodBeat.o(40432);
    }
}
