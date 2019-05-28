package com.tencent.p177mm.p612ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C45336js;
import com.tencent.p177mm.p612ui.C5301c.C5302a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.ui.LauncherUITabView */
public class LauncherUITabView extends RelativeLayout implements C5301c {
    private Matrix aKk = new Matrix();
    protected int lWS = 0;
    private long nlj = 0;
    private C5302a yjX;
    private int ykG;
    private Bitmap ykH;
    private ImageView ykI;
    protected C44247a ykJ;
    protected C44247a ykK;
    protected C44247a ykL;
    protected C44247a ykM;
    private int ykn = -1;
    protected OnClickListener ykp = new C235401();
    private C7306ak ykq = new C235412();
    private int ykr = 0;
    private int yks = 0;
    private int ykt = 0;
    private boolean yku = false;
    private int ykw = 0;
    private boolean ykx = false;

    /* renamed from: com.tencent.mm.ui.LauncherUITabView$1 */
    class C235401 implements OnClickListener {
        private final long ryi = 300;

        C235401() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29515);
            int intValue = ((Integer) view.getTag()).intValue();
            if (LauncherUITabView.this.ykn == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUITabView.this.nlj <= 300) {
                C4990ab.m7418v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                LauncherUITabView.this.ykq.removeMessages(0);
                C4879a.xxA.mo10055m(new C45336js());
                LauncherUITabView.this.nlj = System.currentTimeMillis();
                LauncherUITabView.this.ykn = intValue;
                AppMethodBeat.m2505o(29515);
                return;
            }
            if (LauncherUITabView.this.yjX != null) {
                if (intValue == 0 && LauncherUITabView.this.ykn == 0) {
                    LauncherUITabView.this.ykq.sendEmptyMessageDelayed(0, 300);
                } else {
                    LauncherUITabView.this.nlj = System.currentTimeMillis();
                    LauncherUITabView.this.ykn = intValue;
                    LauncherUITabView.this.yjX.onTabClick(intValue);
                    AppMethodBeat.m2505o(29515);
                    return;
                }
            }
            LauncherUITabView.this.nlj = System.currentTimeMillis();
            LauncherUITabView.this.ykn = intValue;
            C4990ab.m7421w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", (Integer) view.getTag());
            AppMethodBeat.m2505o(29515);
        }
    }

    /* renamed from: com.tencent.mm.ui.LauncherUITabView$2 */
    class C235412 extends C7306ak {
        C235412() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(29516);
            C4990ab.m7418v("MicroMsg.LauncherUITabView", "onMainTabClick");
            LauncherUITabView.this.yjX.onTabClick(0);
            AppMethodBeat.m2505o(29516);
        }
    }

    /* renamed from: com.tencent.mm.ui.LauncherUITabView$a */
    protected class C44247a {
        MMTabView ykO;

        protected C44247a() {
        }
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(29517);
        init();
        AppMethodBeat.m2505o(29517);
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(29518);
        init();
        AppMethodBeat.m2505o(29518);
    }

    public void setOnTabClickListener(C5302a c5302a) {
        this.yjX = c5302a;
    }

    /* renamed from: MX */
    private C44247a m79897MX(int i) {
        AppMethodBeat.m2504i(29519);
        C44247a c44247a = new C44247a();
        c44247a.ykO = new MMTabView(getContext(), i);
        c44247a.ykO.setTag(Integer.valueOf(i));
        c44247a.ykO.setOnClickListener(this.ykp);
        AppMethodBeat.m2505o(29519);
        return c44247a;
    }

    /* renamed from: f */
    private C44247a m79904f(LinearLayout linearLayout) {
        AppMethodBeat.m2504i(29520);
        C44247a MX = m79897MX(0);
        MX.ykO.setText((int) C25738R.string.cv9);
        LayoutParams layoutParams = new LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.a_s));
        layoutParams.weight = 1.0f;
        linearLayout.addView(MX.ykO, layoutParams);
        AppMethodBeat.m2505o(29520);
        return MX;
    }

    /* renamed from: g */
    private C44247a m79905g(LinearLayout linearLayout) {
        AppMethodBeat.m2504i(29521);
        C44247a MX = m79897MX(1);
        MX.ykO.setText((int) C25738R.string.cv_);
        LayoutParams layoutParams = new LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.a_s));
        layoutParams.weight = 1.0f;
        linearLayout.addView(MX.ykO, layoutParams);
        AppMethodBeat.m2505o(29521);
        return MX;
    }

    /* renamed from: h */
    private C44247a m79906h(LinearLayout linearLayout) {
        AppMethodBeat.m2504i(29522);
        C44247a MX = m79897MX(2);
        MX.ykO.setText((int) C25738R.string.cv8);
        LayoutParams layoutParams = new LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.a_s));
        layoutParams.weight = 1.0f;
        linearLayout.addView(MX.ykO, layoutParams);
        AppMethodBeat.m2505o(29522);
        return MX;
    }

    /* renamed from: i */
    private C44247a m79907i(LinearLayout linearLayout) {
        AppMethodBeat.m2504i(29523);
        C44247a MX = m79897MX(3);
        MX.ykO.setText((int) C25738R.string.cw4);
        LayoutParams layoutParams = new LayoutParams(0, getResources().getDimensionPixelSize(C25738R.dimen.a_s));
        layoutParams.weight = 1.0f;
        linearLayout.addView(MX.ykO, layoutParams);
        AppMethodBeat.m2505o(29523);
        return MX;
    }

    private void dxN() {
        AppMethodBeat.m2504i(29524);
        this.ykI = new ImageView(getContext());
        this.ykI.setImageMatrix(this.aKk);
        this.ykI.setScaleType(ScaleType.MATRIX);
        this.ykI.setId(2307142);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C1338a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2307141);
        addView(this.ykI, layoutParams);
        AppMethodBeat.m2505o(29524);
    }

    private void init() {
        AppMethodBeat.m2504i(29525);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(C25738R.color.a69);
        linearLayout.setId(2307141);
        linearLayout.setOrientation(0);
        addView(linearLayout, new RelativeLayout.LayoutParams(-1, -2));
        dxN();
        this.ykJ = m79904f(linearLayout);
        this.ykK = m79905g(linearLayout);
        this.ykL = m79906h(linearLayout);
        this.ykM = m79907i(linearLayout);
        AppMethodBeat.m2505o(29525);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(29526);
        super.onLayout(z, i, i2, i3, i4);
        C4990ab.m7411d("MicroMsg.LauncherUITabView", "on layout, width %d", Integer.valueOf(i3 - i));
        this.ykG = (i3 - i) / 4;
        int i5 = this.ykG;
        if (this.ykH == null || this.ykH.getWidth() != i5) {
            String str = "MicroMsg.LauncherUITabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.ykH == null ? -1 : this.ykH.getWidth());
            objArr[1] = Integer.valueOf(i5);
            C4990ab.m7421w(str, str2, objArr);
            this.ykH = Bitmap.createBitmap(i5, C1338a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.ykH).drawColor(getResources().getColor(C25738R.color.a61));
            mo10914l(this.lWS, 0.0f);
            this.ykI.setImageBitmap(this.ykH);
        }
        setTo(this.lWS);
        AppMethodBeat.m2505o(29526);
    }

    /* renamed from: MM */
    public final void mo10902MM(int i) {
        AppMethodBeat.m2504i(29527);
        C4990ab.m7411d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", Integer.valueOf(i));
        this.ykr = i;
        if (i <= 0) {
            this.ykJ.ykO.setUnread(null);
            AppMethodBeat.m2505o(29527);
        } else if (i > 99) {
            this.ykJ.ykO.setUnread(getContext().getString(C25738R.string.eyo));
            AppMethodBeat.m2505o(29527);
        } else {
            this.ykJ.ykO.setUnread(String.valueOf(i));
            AppMethodBeat.m2505o(29527);
        }
    }

    public final void dwp() {
        AppMethodBeat.m2504i(29528);
        if (this.ykJ == null || this.ykK == null || this.ykL == null || this.ykM == null) {
            AppMethodBeat.m2505o(29528);
            return;
        }
        this.ykJ.ykO.dyw();
        this.ykK.ykO.dyw();
        this.ykL.ykO.dyw();
        this.ykM.ykO.dyw();
        AppMethodBeat.m2505o(29528);
    }

    /* renamed from: MN */
    public final void mo10903MN(int i) {
        AppMethodBeat.m2504i(29529);
        this.yks = i;
        if (i <= 0) {
            this.ykK.ykO.setUnread(null);
            AppMethodBeat.m2505o(29529);
        } else if (i > 99) {
            this.ykK.ykO.setUnread(getContext().getString(C25738R.string.eyo));
            AppMethodBeat.m2505o(29529);
        } else {
            this.ykK.ykO.setUnread(String.valueOf(i));
            AppMethodBeat.m2505o(29529);
        }
    }

    /* renamed from: MO */
    public final void mo10904MO(int i) {
        AppMethodBeat.m2504i(29530);
        this.ykt = i;
        if (i <= 0) {
            this.ykL.ykO.setUnread(null);
            AppMethodBeat.m2505o(29530);
        } else if (i > 99) {
            this.ykL.ykO.setUnread(getContext().getString(C25738R.string.eyo));
            AppMethodBeat.m2505o(29530);
        } else {
            this.ykL.ykO.setUnread(String.valueOf(i));
            AppMethodBeat.m2505o(29530);
        }
    }

    /* renamed from: MP */
    public final void mo10905MP(int i) {
        AppMethodBeat.m2504i(29531);
        this.ykw = i;
        if (i <= 0) {
            this.ykM.ykO.setUnread(null);
            AppMethodBeat.m2505o(29531);
        } else if (i > 99) {
            this.ykM.ykO.setUnread(getContext().getString(C25738R.string.eyo));
            AppMethodBeat.m2505o(29531);
        } else {
            this.ykM.ykO.setUnread(String.valueOf(i));
            AppMethodBeat.m2505o(29531);
        }
    }

    /* renamed from: px */
    public final void mo10915px(boolean z) {
        AppMethodBeat.m2504i(29532);
        this.yku = z;
        this.ykL.ykO.mo10695pR(z);
        AppMethodBeat.m2505o(29532);
    }

    /* renamed from: py */
    public final void mo10916py(boolean z) {
        AppMethodBeat.m2504i(29533);
        this.ykx = z;
        this.ykM.ykO.mo10695pR(z);
        AppMethodBeat.m2505o(29533);
    }

    /* renamed from: pz */
    public final void mo10917pz(boolean z) {
    }

    /* renamed from: l */
    public final void mo10914l(int i, float f) {
        AppMethodBeat.m2504i(29534);
        this.aKk.setTranslate(((float) this.ykG) * (((float) i) + f), 0.0f);
        this.ykI.setImageMatrix(this.aKk);
        AppMethodBeat.m2505o(29534);
    }

    public int getCurIdx() {
        return this.lWS;
    }

    public void setTo(int i) {
        AppMethodBeat.m2504i(29535);
        this.lWS = i;
        this.ykJ.ykO.setTextColor(i == 0 ? getResources().getColorStateList(C25738R.color.a61) : getResources().getColorStateList(C25738R.color.a7k));
        this.ykK.ykO.setTextColor(i == 1 ? getResources().getColorStateList(C25738R.color.a61) : getResources().getColorStateList(C25738R.color.a7k));
        this.ykL.ykO.setTextColor(i == 2 ? getResources().getColorStateList(C25738R.color.a61) : getResources().getColorStateList(C25738R.color.a7k));
        this.ykM.ykO.setTextColor(i == 3 ? getResources().getColorStateList(C25738R.color.a61) : getResources().getColorStateList(C25738R.color.a7k));
        this.nlj = System.currentTimeMillis();
        this.ykn = this.lWS;
        AppMethodBeat.m2505o(29535);
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
