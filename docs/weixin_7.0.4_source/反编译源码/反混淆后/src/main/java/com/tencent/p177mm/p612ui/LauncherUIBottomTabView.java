package com.tencent.p177mm.p612ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C45336js;
import com.tencent.p177mm.p612ui.C5301c.C5302a;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.ui.LauncherUIBottomTabView */
public class LauncherUIBottomTabView extends RelativeLayout implements C5301c {
    protected int lWS = 0;
    private long nlj = 0;
    private C5302a yjX;
    protected C30337a yjY;
    protected C30337a yjZ;
    protected C30337a yka;
    protected C30337a ykb;
    private int ykc = 0;
    private int ykd;
    private int yke;
    private int ykf;
    private int ykg = 0;
    private int ykh;
    private int yki;
    private int ykj;
    private int ykk;
    private int ykl;
    private int ykm;
    private int ykn = -1;
    private int yko = 0;
    protected OnClickListener ykp = new C303361();
    private C7306ak ykq = new C154692();
    private int ykr = 0;
    private int yks = 0;
    private int ykt = 0;
    private boolean yku = false;
    private boolean ykv = false;
    private int ykw = 0;
    private boolean ykx = false;

    /* renamed from: com.tencent.mm.ui.LauncherUIBottomTabView$2 */
    class C154692 extends C7306ak {
        C154692() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(29487);
            C4990ab.m7418v("MicroMsg.LauncherUITabView", "onMainTabClick");
            LauncherUIBottomTabView.this.yjX.onTabClick(0);
            AppMethodBeat.m2505o(29487);
        }
    }

    /* renamed from: com.tencent.mm.ui.LauncherUIBottomTabView$1 */
    class C303361 implements OnClickListener {
        private final long ryi = 300;

        C303361() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29486);
            int intValue = ((Integer) view.getTag()).intValue();
            if (LauncherUIBottomTabView.this.ykn == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUIBottomTabView.this.nlj <= 300) {
                C4990ab.m7418v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                LauncherUIBottomTabView.this.ykq.removeMessages(0);
                C4879a.xxA.mo10055m(new C45336js());
                LauncherUIBottomTabView.this.nlj = System.currentTimeMillis();
                LauncherUIBottomTabView.this.ykn = intValue;
                AppMethodBeat.m2505o(29486);
                return;
            }
            if (LauncherUIBottomTabView.this.yjX != null) {
                if (intValue == 0 && LauncherUIBottomTabView.this.ykn == 0) {
                    C4990ab.m7418v("MicroMsg.LauncherUITabView", "do double click check");
                    LauncherUIBottomTabView.this.ykq.sendEmptyMessageDelayed(0, 300);
                } else {
                    C4990ab.m7418v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
                    LauncherUIBottomTabView.this.nlj = System.currentTimeMillis();
                    LauncherUIBottomTabView.this.ykn = intValue;
                    LauncherUIBottomTabView.this.yjX.onTabClick(intValue);
                    AppMethodBeat.m2505o(29486);
                    return;
                }
            }
            LauncherUIBottomTabView.this.nlj = System.currentTimeMillis();
            LauncherUIBottomTabView.this.ykn = intValue;
            C4990ab.m7421w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", (Integer) view.getTag());
            AppMethodBeat.m2505o(29486);
        }
    }

    /* renamed from: com.tencent.mm.ui.LauncherUIBottomTabView$a */
    protected class C30337a {
        TabIconView ykA;
        TextView ykB;
        TextView ykC;
        ImageView ykD;
        View ykz;

        protected C30337a() {
        }
    }

    public LauncherUIBottomTabView(Context context) {
        super(context);
        AppMethodBeat.m2504i(29488);
        init();
        AppMethodBeat.m2505o(29488);
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(29489);
        init();
        AppMethodBeat.m2505o(29489);
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(29490);
        init();
        AppMethodBeat.m2505o(29490);
    }

    public void setOnTabClickListener(C5302a c5302a) {
        this.yjX = c5302a;
    }

    /* renamed from: MW */
    private C30337a m48294MW(int i) {
        AppMethodBeat.m2504i(29491);
        C30337a c30337a = new C30337a();
        if (C1338a.m2865ga(getContext())) {
            c30337a.ykz = C1742b.m3596SM().mo5274a((Activity) getContext(), "R.layout.mm_bottom_tabitem_large", 2130970103);
        } else {
            c30337a.ykz = C1742b.m3596SM().mo5274a((Activity) getContext(), "R.layout.mm_bottom_tabitem", 2130970102);
        }
        c30337a.ykA = (TabIconView) c30337a.ykz.findViewById(2131821226);
        c30337a.ykB = (TextView) c30337a.ykz.findViewById(2131825993);
        c30337a.ykC = (TextView) c30337a.ykz.findViewById(2131825992);
        c30337a.ykC.setBackgroundResource(C44385r.m80243ik(getContext()));
        c30337a.ykD = (ImageView) c30337a.ykz.findViewById(2131820961);
        c30337a.ykz.setTag(Integer.valueOf(i));
        c30337a.ykz.setOnClickListener(this.ykp);
        c30337a.ykB.setTextSize(0, ((float) C1338a.m2857am(getContext(), C25738R.dimen.f10018nk)) * C1338a.m2862fY(getContext()));
        AppMethodBeat.m2505o(29491);
        return c30337a;
    }

    /* renamed from: b */
    private C30337a m48299b(LinearLayout linearLayout) {
        AppMethodBeat.m2504i(29492);
        C30337a MW = m48294MW(0);
        MW.ykz.setId(-16777215);
        MW.ykB.setText(C25738R.string.cw_);
        MW.ykB.setTextColor(getResources().getColor(C25738R.color.f12198vq));
        MW.ykA.mo10710h(C1318a.icons_filled_chats_hl, C1318a.icons_outlined_chats_middle, C1318a.icons_outlined_chats, C1338a.m2865ga(getContext()));
        MW.ykC.setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(0, this.yko);
        layoutParams.weight = 1.0f;
        linearLayout.addView(MW.ykz, layoutParams);
        AppMethodBeat.m2505o(29492);
        return MW;
    }

    /* renamed from: c */
    private C30337a m48301c(LinearLayout linearLayout) {
        AppMethodBeat.m2504i(29493);
        C30337a MW = m48294MW(1);
        MW.ykz.setId(-16777214);
        MW.ykB.setText(C25738R.string.cv_);
        MW.ykB.setTextColor(getResources().getColor(C25738R.color.f12199vr));
        MW.ykA.mo10710h(C1318a.icons_filled_contacts_hl, C1318a.icons_outlined_contacts_middle, C1318a.icons_outlined_contacts, C1338a.m2865ga(getContext()));
        MW.ykC.setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(0, this.yko);
        layoutParams.weight = 1.0f;
        linearLayout.addView(MW.ykz, layoutParams);
        AppMethodBeat.m2505o(29493);
        return MW;
    }

    /* renamed from: d */
    private C30337a m48302d(LinearLayout linearLayout) {
        AppMethodBeat.m2504i(29494);
        C30337a MW = m48294MW(2);
        MW.ykz.setId(-16777213);
        MW.ykB.setText(C25738R.string.cv8);
        MW.ykB.setTextColor(getResources().getColor(C25738R.color.f12199vr));
        MW.ykA.mo10710h(C1318a.icons_filled_discover_hl, C1318a.icons_outlined_discover_middle, C1318a.icons_outlined_discover, C1338a.m2865ga(getContext()));
        MW.ykC.setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(0, this.yko);
        layoutParams.weight = 1.0f;
        linearLayout.addView(MW.ykz, layoutParams);
        AppMethodBeat.m2505o(29494);
        return MW;
    }

    /* renamed from: e */
    private C30337a m48304e(LinearLayout linearLayout) {
        AppMethodBeat.m2504i(29495);
        C30337a MW = m48294MW(3);
        MW.ykz.setId(-16777212);
        MW.ykB.setText(C25738R.string.cw4);
        MW.ykB.setTextColor(getResources().getColor(C25738R.color.f12199vr));
        MW.ykA.mo10710h(C1318a.icons_filled_me_hl, C1318a.icons_outlined_me, C1318a.icons_outlined_me, C1338a.m2865ga(getContext()));
        MW.ykC.setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(0, this.yko);
        layoutParams.weight = 1.0f;
        linearLayout.addView(MW.ykz, layoutParams);
        AppMethodBeat.m2505o(29495);
        return MW;
    }

    private void init() {
        AppMethodBeat.m2504i(29496);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(getResources().getColor(C25738R.color.f11639a0));
        linearLayout.setOrientation(0);
        addView(linearLayout, new RelativeLayout.LayoutParams(-1, -2));
        this.yko = (int) (((float) C1338a.m2857am(getContext(), C25738R.dimen.f9782fh)) * C1338a.m2862fY(getContext()));
        this.yjY = m48299b(linearLayout);
        this.yka = m48301c(linearLayout);
        this.yjZ = m48302d(linearLayout);
        this.ykb = m48304e(linearLayout);
        this.ykc = getResources().getColor(C25738R.color.f12198vq);
        this.ykd = (this.ykc & 16711680) >> 16;
        this.yke = (this.ykc & 65280) >> 8;
        this.ykf = this.ykc & 255;
        this.ykg = getResources().getColor(C25738R.color.f12199vr);
        this.ykh = (this.ykg & 16711680) >> 16;
        this.yki = (this.ykg & 65280) >> 8;
        this.ykj = this.ykg & 255;
        this.ykk = this.ykd - this.ykh;
        this.ykl = this.yke - this.yki;
        this.ykm = this.ykf - this.ykj;
        AppMethodBeat.m2505o(29496);
    }

    /* renamed from: MM */
    public final void mo10902MM(int i) {
        AppMethodBeat.m2504i(29497);
        C4990ab.m7411d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", Integer.valueOf(i));
        this.ykr = i;
        if (i <= 0) {
            this.yjY.ykC.setText("");
            this.yjY.ykC.setVisibility(4);
            AppMethodBeat.m2505o(29497);
        } else if (i > 99) {
            this.yjY.ykC.setText("");
            this.yjY.ykC.setBackgroundResource(C1318a.badge_count_more);
            this.yjY.ykC.setTextSize(0, (float) C1338a.m2857am(getContext(), C25738R.dimen.a_v));
            this.yjY.ykC.setVisibility(0);
            this.yjY.ykD.setVisibility(4);
            AppMethodBeat.m2505o(29497);
        } else {
            this.yjY.ykC.setText(String.valueOf(i));
            this.yjY.ykC.setBackgroundResource(C44385r.m80243ik(getContext()));
            this.yjY.ykC.setTextSize(0, ((float) C1338a.m2857am(getContext(), C25738R.dimen.a_v)) * C1338a.m2862fY(getContext()));
            this.yjY.ykC.setVisibility(0);
            this.yjY.ykD.setVisibility(4);
            AppMethodBeat.m2505o(29497);
        }
    }

    public final void dwp() {
        if (this.yjY == null || this.yka == null || this.yjZ == null) {
        }
    }

    /* renamed from: MN */
    public final void mo10903MN(int i) {
        AppMethodBeat.m2504i(29498);
        this.yks = i;
        if (i <= 0) {
            this.yka.ykC.setText("");
            this.yka.ykC.setVisibility(4);
            AppMethodBeat.m2505o(29498);
        } else if (i > 99) {
            this.yka.ykC.setText("");
            this.yka.ykC.setBackgroundResource(C1318a.badge_count_more);
            this.yka.ykC.setTextSize(0, (float) C1338a.m2857am(getContext(), C25738R.dimen.a_v));
            this.yka.ykC.setVisibility(0);
            this.yka.ykD.setVisibility(4);
            AppMethodBeat.m2505o(29498);
        } else {
            this.yka.ykC.setText(String.valueOf(i));
            this.yka.ykC.setTextSize(0, ((float) C1338a.m2857am(getContext(), C25738R.dimen.a_v)) * C1338a.m2862fY(getContext()));
            this.yka.ykC.setBackgroundResource(C44385r.m80243ik(getContext()));
            this.yka.ykC.setVisibility(0);
            this.yka.ykD.setVisibility(4);
            AppMethodBeat.m2505o(29498);
        }
    }

    /* renamed from: MO */
    public final void mo10904MO(int i) {
        AppMethodBeat.m2504i(29499);
        this.ykt = i;
        if (i <= 0) {
            this.yjZ.ykC.setText("");
            this.yjZ.ykC.setVisibility(4);
            AppMethodBeat.m2505o(29499);
        } else if (i > 99) {
            this.yjZ.ykC.setText("");
            this.yjZ.ykC.setBackgroundResource(C1318a.badge_count_more);
            this.yjZ.ykC.setTextSize(0, (float) C1338a.m2857am(getContext(), C25738R.dimen.a_v));
            this.yjZ.ykC.setVisibility(0);
            this.yjZ.ykD.setVisibility(4);
            AppMethodBeat.m2505o(29499);
        } else {
            this.yjZ.ykC.setText(String.valueOf(i));
            this.yjZ.ykC.setTextSize(0, ((float) C1338a.m2857am(getContext(), C25738R.dimen.a_v)) * C1338a.m2862fY(getContext()));
            this.yjZ.ykC.setVisibility(0);
            this.yjZ.ykC.setBackgroundResource(C44385r.m80243ik(getContext()));
            this.yjZ.ykD.setVisibility(4);
            AppMethodBeat.m2505o(29499);
        }
    }

    /* renamed from: px */
    public final void mo10915px(boolean z) {
        int i = 4;
        AppMethodBeat.m2504i(29500);
        this.yku = z;
        this.yjZ.ykC.setVisibility(4);
        ImageView imageView = this.yjZ.ykD;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
        AppMethodBeat.m2505o(29500);
    }

    /* renamed from: pz */
    public final void mo10917pz(boolean z) {
        AppMethodBeat.m2504i(29501);
        this.ykv = z;
        C22212h c22212h;
        if (this.ykb == null) {
            AppMethodBeat.m2505o(29501);
        } else if (z) {
            c22212h = C22212h.scu;
            C22212h.m33896ln(1);
            this.ykb.ykC.setText(getResources().getString(C25738R.string.ey3));
            this.ykb.ykC.setBackgroundResource(C25738R.drawable.f6940w3);
            this.ykb.ykC.setTextSize(0, (float) C1338a.m2857am(getContext(), C25738R.dimen.f9793fs));
            this.ykb.ykC.setVisibility(0);
            this.ykb.ykD.setVisibility(4);
            AppMethodBeat.m2505o(29501);
        } else {
            if (!this.ykx) {
                c22212h = C22212h.scu;
                C22212h.m33896ln(0);
            }
            mo10905MP(this.ykw);
            AppMethodBeat.m2505o(29501);
        }
    }

    /* renamed from: MP */
    public final void mo10905MP(int i) {
        AppMethodBeat.m2504i(29502);
        if (this.ykv) {
            AppMethodBeat.m2505o(29502);
            return;
        }
        this.ykw = i;
        if (i <= 0) {
            this.ykb.ykC.setText("");
            this.ykb.ykC.setVisibility(4);
            AppMethodBeat.m2505o(29502);
        } else if (i > 99) {
            this.ykb.ykC.setText("");
            this.ykb.ykC.setBackgroundResource(C1318a.badge_count_more);
            this.ykb.ykC.setTextSize(0, (float) C1338a.m2857am(getContext(), C25738R.dimen.a_v));
            this.ykb.ykC.setVisibility(0);
            this.ykb.ykD.setVisibility(4);
            AppMethodBeat.m2505o(29502);
        } else {
            this.ykb.ykC.setText(String.valueOf(i));
            this.ykb.ykC.setTextSize(0, ((float) C1338a.m2857am(getContext(), C25738R.dimen.a_v)) * C1338a.m2862fY(getContext()));
            this.ykb.ykC.setVisibility(0);
            this.ykb.ykC.setBackgroundResource(C44385r.m80243ik(getContext()));
            this.ykb.ykD.setVisibility(4);
            AppMethodBeat.m2505o(29502);
        }
    }

    /* renamed from: py */
    public final void mo10916py(boolean z) {
        AppMethodBeat.m2504i(29503);
        if (this.ykv) {
            AppMethodBeat.m2505o(29503);
            return;
        }
        int i;
        C22212h c22212h = C22212h.scu;
        C22212h.m33896ln(z ? 1 : 0);
        this.ykx = z;
        this.ykb.ykC.setVisibility(4);
        ImageView imageView = this.ykb.ykD;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        imageView.setVisibility(i);
        AppMethodBeat.m2505o(29503);
    }

    /* renamed from: l */
    public final void mo10914l(int i, float f) {
        AppMethodBeat.m2504i(29504);
        int i2 = (int) (255.0f * f);
        int i3 = 255 - i2;
        int i4 = (((((int) ((((float) this.ykk) * f) + ((float) this.ykh))) << 16) + (((int) ((((float) this.ykl) * f) + ((float) this.yki))) << 8)) + ((int) ((((float) this.ykm) * f) + ((float) this.ykj)))) + WebView.NIGHT_MODE_COLOR;
        int i5 = (((((int) ((((float) this.ykk) * (1.0f - f)) + ((float) this.ykh))) << 16) + (((int) ((((float) this.ykl) * (1.0f - f)) + ((float) this.yki))) << 8)) + ((int) ((((float) this.ykm) * (1.0f - f)) + ((float) this.ykj)))) + WebView.NIGHT_MODE_COLOR;
        switch (i) {
            case 0:
                this.yjY.ykA.setFocusAlpha(i3);
                this.yka.ykA.setFocusAlpha(i2);
                this.yjY.ykB.setTextColor(i5);
                this.yka.ykB.setTextColor(i4);
                AppMethodBeat.m2505o(29504);
                return;
            case 1:
                this.yka.ykA.setFocusAlpha(i3);
                this.yjZ.ykA.setFocusAlpha(i2);
                this.yka.ykB.setTextColor(i5);
                this.yjZ.ykB.setTextColor(i4);
                AppMethodBeat.m2505o(29504);
                return;
            case 2:
                this.yjZ.ykA.setFocusAlpha(i3);
                this.ykb.ykA.setFocusAlpha(i2);
                this.yjZ.ykB.setTextColor(i5);
                this.ykb.ykB.setTextColor(i4);
                break;
        }
        AppMethodBeat.m2505o(29504);
    }

    public int getCurIdx() {
        return this.lWS;
    }

    public void setTo(int i) {
        AppMethodBeat.m2504i(29505);
        this.lWS = i;
        switch (i) {
            case 0:
                this.yjY.ykA.setFocusAlpha(255);
                this.yjZ.ykA.setFocusAlpha(0);
                this.yka.ykA.setFocusAlpha(0);
                this.ykb.ykA.setFocusAlpha(0);
                this.yjY.ykB.setTextColor(this.ykc);
                this.yjZ.ykB.setTextColor(this.ykg);
                this.yka.ykB.setTextColor(this.ykg);
                this.ykb.ykB.setTextColor(this.ykg);
                break;
            case 1:
                this.yjY.ykA.setFocusAlpha(0);
                this.yjZ.ykA.setFocusAlpha(0);
                this.yka.ykA.setFocusAlpha(255);
                this.ykb.ykA.setFocusAlpha(0);
                this.yjY.ykB.setTextColor(this.ykg);
                this.yjZ.ykB.setTextColor(this.ykg);
                this.yka.ykB.setTextColor(this.ykc);
                this.ykb.ykB.setTextColor(this.ykg);
                break;
            case 2:
                this.yjY.ykA.setFocusAlpha(0);
                this.yjZ.ykA.setFocusAlpha(255);
                this.yka.ykA.setFocusAlpha(0);
                this.ykb.ykA.setFocusAlpha(0);
                this.yjY.ykB.setTextColor(this.ykg);
                this.yjZ.ykB.setTextColor(this.ykc);
                this.yka.ykB.setTextColor(this.ykg);
                this.ykb.ykB.setTextColor(this.ykg);
                break;
            case 3:
                this.yjY.ykA.setFocusAlpha(0);
                this.yjZ.ykA.setFocusAlpha(0);
                this.yka.ykA.setFocusAlpha(0);
                this.ykb.ykA.setFocusAlpha(255);
                this.yjY.ykB.setTextColor(this.ykg);
                this.yjZ.ykB.setTextColor(this.ykg);
                this.yka.ykB.setTextColor(this.ykg);
                this.ykb.ykB.setTextColor(this.ykc);
                break;
        }
        this.nlj = System.currentTimeMillis();
        this.ykn = this.lWS;
        AppMethodBeat.m2505o(29505);
    }

    public int getMainTabUnread() {
        return this.ykr;
    }

    public int getContactTabUnread() {
        return this.yks;
    }

    public int getFriendTabUnread() {
        return this.ykt;
    }

    public int getSettingsTabUnread() {
        return this.ykw;
    }

    public boolean getShowFriendPoint() {
        return this.yku;
    }

    public boolean getSettingsPoint() {
        return this.ykx;
    }
}
