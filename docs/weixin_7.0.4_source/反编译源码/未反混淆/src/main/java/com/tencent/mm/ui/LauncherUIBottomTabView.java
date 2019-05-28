package com.tencent.mm.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.js;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.tools.r;
import com.tencent.smtt.sdk.WebView;

public class LauncherUIBottomTabView extends RelativeLayout implements c {
    protected int lWS = 0;
    private long nlj = 0;
    private com.tencent.mm.ui.c.a yjX;
    protected a yjY;
    protected a yjZ;
    protected a yka;
    protected a ykb;
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
    protected OnClickListener ykp = new OnClickListener() {
        private final long ryi = 300;

        public final void onClick(View view) {
            AppMethodBeat.i(29486);
            int intValue = ((Integer) view.getTag()).intValue();
            if (LauncherUIBottomTabView.this.ykn == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUIBottomTabView.this.nlj <= 300) {
                ab.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                LauncherUIBottomTabView.this.ykq.removeMessages(0);
                com.tencent.mm.sdk.b.a.xxA.m(new js());
                LauncherUIBottomTabView.this.nlj = System.currentTimeMillis();
                LauncherUIBottomTabView.this.ykn = intValue;
                AppMethodBeat.o(29486);
                return;
            }
            if (LauncherUIBottomTabView.this.yjX != null) {
                if (intValue == 0 && LauncherUIBottomTabView.this.ykn == 0) {
                    ab.v("MicroMsg.LauncherUITabView", "do double click check");
                    LauncherUIBottomTabView.this.ykq.sendEmptyMessageDelayed(0, 300);
                } else {
                    ab.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
                    LauncherUIBottomTabView.this.nlj = System.currentTimeMillis();
                    LauncherUIBottomTabView.this.ykn = intValue;
                    LauncherUIBottomTabView.this.yjX.onTabClick(intValue);
                    AppMethodBeat.o(29486);
                    return;
                }
            }
            LauncherUIBottomTabView.this.nlj = System.currentTimeMillis();
            LauncherUIBottomTabView.this.ykn = intValue;
            ab.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", (Integer) view.getTag());
            AppMethodBeat.o(29486);
        }
    };
    private ak ykq = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(29487);
            ab.v("MicroMsg.LauncherUITabView", "onMainTabClick");
            LauncherUIBottomTabView.this.yjX.onTabClick(0);
            AppMethodBeat.o(29487);
        }
    };
    private int ykr = 0;
    private int yks = 0;
    private int ykt = 0;
    private boolean yku = false;
    private boolean ykv = false;
    private int ykw = 0;
    private boolean ykx = false;

    protected class a {
        TabIconView ykA;
        TextView ykB;
        TextView ykC;
        ImageView ykD;
        View ykz;

        protected a() {
        }
    }

    public LauncherUIBottomTabView(Context context) {
        super(context);
        AppMethodBeat.i(29488);
        init();
        AppMethodBeat.o(29488);
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29489);
        init();
        AppMethodBeat.o(29489);
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(29490);
        init();
        AppMethodBeat.o(29490);
    }

    public void setOnTabClickListener(com.tencent.mm.ui.c.a aVar) {
        this.yjX = aVar;
    }

    private a MW(int i) {
        AppMethodBeat.i(29491);
        a aVar = new a();
        if (com.tencent.mm.bz.a.ga(getContext())) {
            aVar.ykz = b.SM().a((Activity) getContext(), "R.layout.mm_bottom_tabitem_large", (int) R.layout.adg);
        } else {
            aVar.ykz = b.SM().a((Activity) getContext(), "R.layout.mm_bottom_tabitem", (int) R.layout.adf);
        }
        aVar.ykA = (TabIconView) aVar.ykz.findViewById(R.id.rq);
        aVar.ykB = (TextView) aVar.ykz.findViewById(R.id.d9a);
        aVar.ykC = (TextView) aVar.ykz.findViewById(R.id.d9_);
        aVar.ykC.setBackgroundResource(r.ik(getContext()));
        aVar.ykD = (ImageView) aVar.ykz.findViewById(R.id.kk);
        aVar.ykz.setTag(Integer.valueOf(i));
        aVar.ykz.setOnClickListener(this.ykp);
        aVar.ykB.setTextSize(0, ((float) com.tencent.mm.bz.a.am(getContext(), R.dimen.nk)) * com.tencent.mm.bz.a.fY(getContext()));
        AppMethodBeat.o(29491);
        return aVar;
    }

    private a b(LinearLayout linearLayout) {
        AppMethodBeat.i(29492);
        a MW = MW(0);
        MW.ykz.setId(-16777215);
        MW.ykB.setText(R.string.cw_);
        MW.ykB.setTextColor(getResources().getColor(R.color.vq));
        MW.ykA.h(R.raw.icons_filled_chats_hl, R.raw.icons_outlined_chats_middle, R.raw.icons_outlined_chats, com.tencent.mm.bz.a.ga(getContext()));
        MW.ykC.setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(0, this.yko);
        layoutParams.weight = 1.0f;
        linearLayout.addView(MW.ykz, layoutParams);
        AppMethodBeat.o(29492);
        return MW;
    }

    private a c(LinearLayout linearLayout) {
        AppMethodBeat.i(29493);
        a MW = MW(1);
        MW.ykz.setId(-16777214);
        MW.ykB.setText(R.string.cv_);
        MW.ykB.setTextColor(getResources().getColor(R.color.vr));
        MW.ykA.h(R.raw.icons_filled_contacts_hl, R.raw.icons_outlined_contacts_middle, R.raw.icons_outlined_contacts, com.tencent.mm.bz.a.ga(getContext()));
        MW.ykC.setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(0, this.yko);
        layoutParams.weight = 1.0f;
        linearLayout.addView(MW.ykz, layoutParams);
        AppMethodBeat.o(29493);
        return MW;
    }

    private a d(LinearLayout linearLayout) {
        AppMethodBeat.i(29494);
        a MW = MW(2);
        MW.ykz.setId(-16777213);
        MW.ykB.setText(R.string.cv8);
        MW.ykB.setTextColor(getResources().getColor(R.color.vr));
        MW.ykA.h(R.raw.icons_filled_discover_hl, R.raw.icons_outlined_discover_middle, R.raw.icons_outlined_discover, com.tencent.mm.bz.a.ga(getContext()));
        MW.ykC.setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(0, this.yko);
        layoutParams.weight = 1.0f;
        linearLayout.addView(MW.ykz, layoutParams);
        AppMethodBeat.o(29494);
        return MW;
    }

    private a e(LinearLayout linearLayout) {
        AppMethodBeat.i(29495);
        a MW = MW(3);
        MW.ykz.setId(-16777212);
        MW.ykB.setText(R.string.cw4);
        MW.ykB.setTextColor(getResources().getColor(R.color.vr));
        MW.ykA.h(R.raw.icons_filled_me_hl, R.raw.icons_outlined_me, R.raw.icons_outlined_me, com.tencent.mm.bz.a.ga(getContext()));
        MW.ykC.setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(0, this.yko);
        layoutParams.weight = 1.0f;
        linearLayout.addView(MW.ykz, layoutParams);
        AppMethodBeat.o(29495);
        return MW;
    }

    private void init() {
        AppMethodBeat.i(29496);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(getResources().getColor(R.color.a0));
        linearLayout.setOrientation(0);
        addView(linearLayout, new RelativeLayout.LayoutParams(-1, -2));
        this.yko = (int) (((float) com.tencent.mm.bz.a.am(getContext(), R.dimen.fh)) * com.tencent.mm.bz.a.fY(getContext()));
        this.yjY = b(linearLayout);
        this.yka = c(linearLayout);
        this.yjZ = d(linearLayout);
        this.ykb = e(linearLayout);
        this.ykc = getResources().getColor(R.color.vq);
        this.ykd = (this.ykc & 16711680) >> 16;
        this.yke = (this.ykc & 65280) >> 8;
        this.ykf = this.ykc & 255;
        this.ykg = getResources().getColor(R.color.vr);
        this.ykh = (this.ykg & 16711680) >> 16;
        this.yki = (this.ykg & 65280) >> 8;
        this.ykj = this.ykg & 255;
        this.ykk = this.ykd - this.ykh;
        this.ykl = this.yke - this.yki;
        this.ykm = this.ykf - this.ykj;
        AppMethodBeat.o(29496);
    }

    public final void MM(int i) {
        AppMethodBeat.i(29497);
        ab.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", Integer.valueOf(i));
        this.ykr = i;
        if (i <= 0) {
            this.yjY.ykC.setText("");
            this.yjY.ykC.setVisibility(4);
            AppMethodBeat.o(29497);
        } else if (i > 99) {
            this.yjY.ykC.setText("");
            this.yjY.ykC.setBackgroundResource(R.raw.badge_count_more);
            this.yjY.ykC.setTextSize(0, (float) com.tencent.mm.bz.a.am(getContext(), R.dimen.a_v));
            this.yjY.ykC.setVisibility(0);
            this.yjY.ykD.setVisibility(4);
            AppMethodBeat.o(29497);
        } else {
            this.yjY.ykC.setText(String.valueOf(i));
            this.yjY.ykC.setBackgroundResource(r.ik(getContext()));
            this.yjY.ykC.setTextSize(0, ((float) com.tencent.mm.bz.a.am(getContext(), R.dimen.a_v)) * com.tencent.mm.bz.a.fY(getContext()));
            this.yjY.ykC.setVisibility(0);
            this.yjY.ykD.setVisibility(4);
            AppMethodBeat.o(29497);
        }
    }

    public final void dwp() {
        if (this.yjY == null || this.yka == null || this.yjZ == null) {
        }
    }

    public final void MN(int i) {
        AppMethodBeat.i(29498);
        this.yks = i;
        if (i <= 0) {
            this.yka.ykC.setText("");
            this.yka.ykC.setVisibility(4);
            AppMethodBeat.o(29498);
        } else if (i > 99) {
            this.yka.ykC.setText("");
            this.yka.ykC.setBackgroundResource(R.raw.badge_count_more);
            this.yka.ykC.setTextSize(0, (float) com.tencent.mm.bz.a.am(getContext(), R.dimen.a_v));
            this.yka.ykC.setVisibility(0);
            this.yka.ykD.setVisibility(4);
            AppMethodBeat.o(29498);
        } else {
            this.yka.ykC.setText(String.valueOf(i));
            this.yka.ykC.setTextSize(0, ((float) com.tencent.mm.bz.a.am(getContext(), R.dimen.a_v)) * com.tencent.mm.bz.a.fY(getContext()));
            this.yka.ykC.setBackgroundResource(r.ik(getContext()));
            this.yka.ykC.setVisibility(0);
            this.yka.ykD.setVisibility(4);
            AppMethodBeat.o(29498);
        }
    }

    public final void MO(int i) {
        AppMethodBeat.i(29499);
        this.ykt = i;
        if (i <= 0) {
            this.yjZ.ykC.setText("");
            this.yjZ.ykC.setVisibility(4);
            AppMethodBeat.o(29499);
        } else if (i > 99) {
            this.yjZ.ykC.setText("");
            this.yjZ.ykC.setBackgroundResource(R.raw.badge_count_more);
            this.yjZ.ykC.setTextSize(0, (float) com.tencent.mm.bz.a.am(getContext(), R.dimen.a_v));
            this.yjZ.ykC.setVisibility(0);
            this.yjZ.ykD.setVisibility(4);
            AppMethodBeat.o(29499);
        } else {
            this.yjZ.ykC.setText(String.valueOf(i));
            this.yjZ.ykC.setTextSize(0, ((float) com.tencent.mm.bz.a.am(getContext(), R.dimen.a_v)) * com.tencent.mm.bz.a.fY(getContext()));
            this.yjZ.ykC.setVisibility(0);
            this.yjZ.ykC.setBackgroundResource(r.ik(getContext()));
            this.yjZ.ykD.setVisibility(4);
            AppMethodBeat.o(29499);
        }
    }

    public final void px(boolean z) {
        int i = 4;
        AppMethodBeat.i(29500);
        this.yku = z;
        this.yjZ.ykC.setVisibility(4);
        ImageView imageView = this.yjZ.ykD;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
        AppMethodBeat.o(29500);
    }

    public final void pz(boolean z) {
        AppMethodBeat.i(29501);
        this.ykv = z;
        h hVar;
        if (this.ykb == null) {
            AppMethodBeat.o(29501);
        } else if (z) {
            hVar = h.scu;
            h.ln(1);
            this.ykb.ykC.setText(getResources().getString(R.string.ey3));
            this.ykb.ykC.setBackgroundResource(R.drawable.w3);
            this.ykb.ykC.setTextSize(0, (float) com.tencent.mm.bz.a.am(getContext(), R.dimen.fs));
            this.ykb.ykC.setVisibility(0);
            this.ykb.ykD.setVisibility(4);
            AppMethodBeat.o(29501);
        } else {
            if (!this.ykx) {
                hVar = h.scu;
                h.ln(0);
            }
            MP(this.ykw);
            AppMethodBeat.o(29501);
        }
    }

    public final void MP(int i) {
        AppMethodBeat.i(29502);
        if (this.ykv) {
            AppMethodBeat.o(29502);
            return;
        }
        this.ykw = i;
        if (i <= 0) {
            this.ykb.ykC.setText("");
            this.ykb.ykC.setVisibility(4);
            AppMethodBeat.o(29502);
        } else if (i > 99) {
            this.ykb.ykC.setText("");
            this.ykb.ykC.setBackgroundResource(R.raw.badge_count_more);
            this.ykb.ykC.setTextSize(0, (float) com.tencent.mm.bz.a.am(getContext(), R.dimen.a_v));
            this.ykb.ykC.setVisibility(0);
            this.ykb.ykD.setVisibility(4);
            AppMethodBeat.o(29502);
        } else {
            this.ykb.ykC.setText(String.valueOf(i));
            this.ykb.ykC.setTextSize(0, ((float) com.tencent.mm.bz.a.am(getContext(), R.dimen.a_v)) * com.tencent.mm.bz.a.fY(getContext()));
            this.ykb.ykC.setVisibility(0);
            this.ykb.ykC.setBackgroundResource(r.ik(getContext()));
            this.ykb.ykD.setVisibility(4);
            AppMethodBeat.o(29502);
        }
    }

    public final void py(boolean z) {
        AppMethodBeat.i(29503);
        if (this.ykv) {
            AppMethodBeat.o(29503);
            return;
        }
        int i;
        h hVar = h.scu;
        h.ln(z ? 1 : 0);
        this.ykx = z;
        this.ykb.ykC.setVisibility(4);
        ImageView imageView = this.ykb.ykD;
        if (z) {
            i = 0;
        } else {
            i = 4;
        }
        imageView.setVisibility(i);
        AppMethodBeat.o(29503);
    }

    public final void l(int i, float f) {
        AppMethodBeat.i(29504);
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
                AppMethodBeat.o(29504);
                return;
            case 1:
                this.yka.ykA.setFocusAlpha(i3);
                this.yjZ.ykA.setFocusAlpha(i2);
                this.yka.ykB.setTextColor(i5);
                this.yjZ.ykB.setTextColor(i4);
                AppMethodBeat.o(29504);
                return;
            case 2:
                this.yjZ.ykA.setFocusAlpha(i3);
                this.ykb.ykA.setFocusAlpha(i2);
                this.yjZ.ykB.setTextColor(i5);
                this.ykb.ykB.setTextColor(i4);
                break;
        }
        AppMethodBeat.o(29504);
    }

    public int getCurIdx() {
        return this.lWS;
    }

    public void setTo(int i) {
        AppMethodBeat.i(29505);
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
        AppMethodBeat.o(29505);
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
