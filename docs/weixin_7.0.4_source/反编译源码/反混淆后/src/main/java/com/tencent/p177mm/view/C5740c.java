package com.tencent.p177mm.view;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.SmileyPanel;
import com.tencent.p177mm.emoji.p1381c.C26073a;
import com.tencent.p177mm.emoji.p847b.C9270a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p207by.C45274a;
import com.tencent.p177mm.p207by.C45274a.C1336b;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C23297j;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44082f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.view.p1097f.C16067a;
import com.tencent.p177mm.view.p1097f.C16067a.C160681;
import com.tencent.p177mm.view.p1627c.C44418a;
import com.tencent.p177mm.view.p645a.C16049j;
import com.tencent.p177mm.view.p646e.C17070a;
import com.tencent.p177mm.view.p646e.C17070a.C170735;
import com.tencent.p177mm.view.p646e.C17070a.C17077a;
import com.tencent.p177mm.view.p646e.C17070a.C57413;
import java.util.Iterator;

/* renamed from: com.tencent.mm.view.c */
public final class C5740c extends SmileyPanel implements C17077a {
    private C17070a Aai;
    private C16067a Aaj;
    private final String TAG;
    private boolean jgc;

    public C5740c(Context context, boolean z) {
        this(context, z, (byte) 0);
    }

    private C5740c(Context context, boolean z, byte b) {
        int i;
        if (z) {
            i = C25738R.style.f10878hd;
        } else {
            i = C25738R.style.f10877hc;
        }
        super(new C9270a(context, i), null);
        AppMethodBeat.m2504i(62923);
        this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanel";
        this.jgc = false;
        this.Aaj = new C16067a();
        this.Aai = new C17070a(getContext(), this.Aaj, this);
        AppMethodBeat.m2505o(62923);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(62924);
        C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
        C16067a c16067a = this.Aaj;
        c16067a.zRn = true;
        c16067a.dNv();
        c16067a.dNm();
        C17070a c17070a = this.Aai;
        if (!(c17070a.Adu == null || c17070a.Adt == null)) {
            c17070a.Adu.mo28410aJ(c17070a.Adt.getCurrentItem(), true);
        }
        c17070a.dNb();
        AppMethodBeat.m2505o(62924);
    }

    public final void setShowProductId(String str) {
        AppMethodBeat.m2504i(62925);
        this.Aaj.setShowProductId(str);
        AppMethodBeat.m2505o(62925);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(62926);
        C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
        this.Aaj.onPause();
        AppMethodBeat.m2505o(62926);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(62927);
        C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDestroy");
        this.vhf = null;
        if (this.Aai != null) {
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "ui clear");
            C17070a c17070a = this.Aai;
            c17070a.dMZ();
            c17070a.jiq = null;
            if (c17070a.Adt != null) {
                c17070a.Adt.setAdapter(null);
            }
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager destroy remove listener.");
            ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35650i(c17070a.AdM);
            ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35647g(c17070a.xYF);
            ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35653k(c17070a.AdO);
            C4879a.xxA.mo10053d(c17070a.xYG);
            C4879a.xxA.mo10053d(c17070a.AdN);
            this.Aai = null;
        }
        if (this.Aaj != null) {
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "stg clear");
            if (this.Aaj.zRn) {
                this.Aaj.onPause();
            }
            C16067a c16067a = this.Aaj;
            Iterator it = c16067a.AeE.iterator();
            while (it.hasNext()) {
                C44418a c44418a = (C44418a) it.next();
                if (c44418a != null) {
                    c44418a.Aaj = null;
                    c44418a.Adi = null;
                }
            }
            c16067a.dNu();
        }
        ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().onDestroy();
        AppMethodBeat.m2505o(62927);
    }

    public final void setCallback(C44082f c44082f) {
        AppMethodBeat.m2504i(62928);
        super.setCallback(c44082f);
        AppMethodBeat.m2505o(62928);
    }

    public final void setSendButtonEnable(boolean z) {
        AppMethodBeat.m2504i(62929);
        C17070a c17070a = this.Aai;
        if (c17070a.AdC != null) {
            c17070a.AdC.setEnabled(z);
        }
        AppMethodBeat.m2505o(62929);
    }

    /* renamed from: AC */
    public final void mo11686AC() {
        this.vhf = null;
    }

    public final void refresh() {
        AppMethodBeat.m2504i(62930);
        C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "refresh");
        try {
            if (this.Aaj == null || this.Aai == null) {
                AppMethodBeat.m2505o(62930);
                return;
            }
            this.Aai.dNg();
            AppMethodBeat.m2505o(62930);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanel", e, "", new Object[0]);
            AppMethodBeat.m2505o(62930);
        }
    }

    /* renamed from: AD */
    public final void mo11687AD() {
        AppMethodBeat.m2504i(62931);
        C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideCustomBtn, %s", C5046bo.dpG());
        this.Aaj.Aes = true;
        AppMethodBeat.m2505o(62931);
    }

    /* renamed from: AE */
    public final void mo11688AE() {
        AppMethodBeat.m2504i(62932);
        C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "[hideDefaultBtn]");
        this.Aaj.Aet = true;
        AppMethodBeat.m2505o(62932);
    }

    /* renamed from: j */
    public final void mo11696j(boolean z, boolean z2) {
        AppMethodBeat.m2504i(62933);
        C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", Boolean.valueOf(z), Boolean.valueOf(z2));
        this.Aaj.Aev = z;
        this.Aaj.Aew = z2;
        AppMethodBeat.m2505o(62933);
    }

    /* renamed from: bf */
    public final void mo11691bf(boolean z) {
        AppMethodBeat.m2504i(62934);
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSendButton:B", Boolean.valueOf(z));
        this.Aai.mo31142rk(z);
        this.Aaj.Aey = true;
        AppMethodBeat.m2505o(62934);
    }

    public final C44073a getTextOpListener() {
        return this.vhf;
    }

    public final C23297j getSmileyPanelCallback() {
        return (C23297j) this.vhg;
    }

    public final void setPortHeightPx(int i) {
        AppMethodBeat.m2504i(62935);
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", Integer.valueOf(i));
        C16067a c16067a = this.Aaj;
        if (c16067a.Aei != i) {
            c16067a.AeD = false;
            c16067a.AeC = false;
        }
        c16067a.Aei = i;
        this.Aaj.dNl();
        c16067a = this.Aaj;
        c16067a.mo28455QH(i - c16067a.AdY);
        this.Aaj.jiM = 0;
        AppMethodBeat.m2505o(62935);
    }

    public final int getBottomHeightPx() {
        return this.Aaj.Aei;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(62936);
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(62936);
    }

    public final void setVisibility(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(62937);
        super.setVisibility(i);
        if (i == 0) {
            this.jgc = false;
            if (this.Aai != null) {
                C17070a c17070a = this.Aai;
                C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initView begin");
                C26073a OZ = C26073a.m41631OZ();
                OZ.ezk = System.currentTimeMillis();
                OZ.clickCount = 0;
                if (c17070a.mView != null && getChildCount() > 0) {
                    C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "already load view --- pass");
                    if (!(c17070a.Adu == null || c17070a.Adt == null)) {
                        c17070a.Adu.mo28410aJ(c17070a.Adt.getCurrentItem(), true);
                        C44418a atl = c17070a.Aaj.atl("capture");
                        if (atl != null && atl.jis == c17070a.Adt.getCurrentItem() && C16067a.m24369QL(c17070a.Aaj.gOW) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35614OT()) {
                            C7060h.pYm.mo8381e(15982, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                            C45287c.aNX();
                        }
                    }
                    c17070a.aRF();
                    AppMethodBeat.m2505o(62937);
                    return;
                } else if (c17070a.Aaj == null) {
                    C4990ab.m7420w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "mPanelStg is null");
                    AppMethodBeat.m2505o(62937);
                    return;
                } else {
                    int i3;
                    ImageView imageView;
                    c17070a.Aaj.AeI = false;
                    if (c17070a.mView == null) {
                        c17070a.mView = LayoutInflater.from(getContext()).inflate(2130970705, null);
                    } else if (c17070a.mView.getParent() != null) {
                        ((ViewGroup) c17070a.mView.getParent()).removeView(c17070a.mView);
                    }
                    c17070a.Adt = (SmileyPanelViewPager) c17070a.findViewById(2131821506);
                    c17070a.Adt.setPanelStg(c17070a.Aaj);
                    c17070a.Adt.setSmileyPanelViewPagerLayoutListener(c17070a);
                    c17070a.Adt.setOnPageChangeListener(c17070a);
                    c17070a.Adt.setOffscreenPageLimit(3);
                    c17070a.Aaj.jiM = c17070a.Adt.getWidth();
                    c17070a.Adv = (SmileyPanelScrollView) c17070a.findViewById(2131821505);
                    c17070a.Adv.setOnPageSelectListener(c17070a);
                    c17070a.Adv.setSmileyPanelStg(c17070a.Aaj);
                    c17070a.Adw = (ScrollRectRecyclerView) c17070a.findViewById(2131827588);
                    c17070a.Adx = new C16049j(c17070a.jiq, c17070a.Aaj);
                    c17070a.Adx.AbO = c17070a.AdP;
                    c17070a.Adw.setLayoutManager(new LinearLayoutManager(0));
                    c17070a.Adw.setAdapter(c17070a.Adx);
                    c17070a.Adw.setItemAnimator(null);
                    c17070a.AdC = (TextView) c17070a.findViewById(2131826268);
                    c17070a.Adz = (ImageView) c17070a.findViewById(2131827591);
                    c17070a.Adz.setOnClickListener(c17070a);
                    c17070a.Ady = c17070a.findViewById(2131827587);
                    c17070a.AdA = (ImageView) c17070a.findViewById(2131827592);
                    c17070a.AdC.setOnClickListener(c17070a);
                    c17070a.AdC.setVisibility(c17070a.Aaj.dNq() ? 0 : 8);
                    addView(c17070a.mView, new LayoutParams(-1, -1));
                    c17070a.Aaj.AeI = true;
                    View view = c17070a.Ady;
                    if (c17070a.Aaj.Aes || c17070a.Aaj.Aet) {
                        i3 = 8;
                    } else {
                        i3 = 0;
                    }
                    view.setVisibility(i3);
                    c17070a.AdB = (ImageButton) c17070a.findViewById(2131827590);
                    c17070a.AdB.setOnClickListener(c17070a);
                    ImageButton imageButton = c17070a.AdB;
                    if (c17070a.Aaj.Aet) {
                        C16067a c16067a = c17070a.Aaj;
                        if (c16067a.gOW == ChatFooterPanel.vhk || c16067a.gOW == ChatFooterPanel.vhl || c16067a.gOW == ChatFooterPanel.vhn || c16067a.gOW == ChatFooterPanel.vhp || c16067a.gOW == ChatFooterPanel.vho || c16067a.gOW == ChatFooterPanel.vhq || c16067a.gOW == ChatFooterPanel.vhs || c16067a.gOW == ChatFooterPanel.vhr) {
                            i3 = true;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            i3 = 0;
                            imageButton.setVisibility(i3);
                            c17070a.AdD = (ImageView) c17070a.findViewById(2131827589);
                            imageView = c17070a.AdD;
                            if (c17070a.Aaj.gOW != ChatFooterPanel.vhi || c17070a.Aaj.Aet) {
                                i2 = 8;
                            }
                            imageView.setVisibility(i2);
                            c17070a.AdD.setOnClickListener(c17070a);
                            if (C5047bp.dpL() || C5058f.IS_FLAVOR_RED) {
                                c17070a.AdD.setOnLongClickListener(new C57413());
                            }
                            AppMethodBeat.m2505o(62937);
                            return;
                        }
                    }
                    i3 = 8;
                    imageButton.setVisibility(i3);
                    c17070a.AdD = (ImageView) c17070a.findViewById(2131827589);
                    imageView = c17070a.AdD;
                    i2 = 8;
                    imageView.setVisibility(i2);
                    c17070a.AdD.setOnClickListener(c17070a);
                    c17070a.AdD.setOnLongClickListener(new C57413());
                    AppMethodBeat.m2505o(62937);
                    return;
                }
            }
            C4990ab.m7420w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley Panel Manager is null.");
            AppMethodBeat.m2505o(62937);
        } else if (this.Aaj != null) {
            this.Aaj.dNu();
            AppMethodBeat.m2505o(62937);
        } else {
            C4990ab.m7420w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley PanelStg Manager is null.");
            AppMethodBeat.m2505o(62937);
        }
    }

    public final void setTalkerName(String str) {
        this.Aaj.vmL = str;
    }

    public final void setDefaultEmojiByDetail(String str) {
        AppMethodBeat.m2504i(62938);
        C16067a c16067a = this.Aaj;
        c16067a.setShowProductId(str);
        c16067a.dNl();
        if (c16067a.AeH == null) {
            c16067a.AeH = new C160681();
        }
        C4990ab.m7410d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "add succeed send listener");
        C4879a.xxA.mo10052c(c16067a.AeH);
        AppMethodBeat.m2505o(62938);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(62939);
        if (this.jgc) {
            setVisibility(8);
            i = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
            i2 = MeasureSpec.makeMeasureSpec(0, ErrorDialogData.SUPPRESSED);
        }
        super.onMeasure(i, i2);
        AppMethodBeat.m2505o(62939);
    }

    public final void setHide(boolean z) {
        this.jgc = z;
    }

    /* renamed from: AG */
    public final void mo11690AG() {
        this.Aaj.AeA = true;
    }

    /* renamed from: AF */
    public final void mo11689AF() {
        AppMethodBeat.m2504i(62940);
        if (this.Aai != null) {
            C17070a c17070a = this.Aai;
            String str = "TAG_DEFAULT_TAB";
            if (!(c17070a.Adt == null || c17070a.Aaj == null)) {
                if (c17070a.AdH) {
                    c17070a.AdI = null;
                    c17070a.Adt.post(new C170735(str));
                } else {
                    c17070a.AdI = str;
                }
            }
        }
        if (this.Aaj != null) {
            C45274a.dmE();
            C1336b c1336b = C45274a.xum;
            C1336b.alW("TAG_DEFAULT_TAB");
        }
        AppMethodBeat.m2505o(62940);
    }

    public final void setEntranceScene(int i) {
        AppMethodBeat.m2504i(62941);
        C26073a.m41631OZ().scene = i;
        if (this.Aaj != null) {
            this.Aaj.gOW = i;
        }
        AppMethodBeat.m2505o(62941);
    }
}
