package com.tencent.p177mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Switch;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C1241c;
import com.tencent.p177mm.api.C17918t;
import com.tencent.p177mm.api.C17918t.C17917a;
import com.tencent.p177mm.api.C25784s.C25785a;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.api.C32249g;
import com.tencent.p177mm.api.C41757u;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.compatible.util.C18175j;
import com.tencent.p177mm.p204br.C18117b;
import com.tencent.p177mm.p204br.C24659a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.view.footer.C16070a;
import com.tencent.p177mm.view.footer.SelectColorBar;
import com.tencent.p177mm.view.footer.SelectColorBar.C36375a;
import com.tencent.p177mm.view.p1096b.C30844a;

/* renamed from: com.tencent.mm.view.a */
public abstract class C16051a extends C1241c implements OnGlobalLayoutListener {
    private C25785a ccP;
    public boolean ccT = true;
    private C30844a ccv;
    private C18117b cjc;
    private View iJO;
    private Button lXI;
    private Button oDB;
    public ChatFooterPanel odY;
    protected C32247e[] zZM;
    private View zZN;
    private C16070a zZO;
    private View zZP;
    private View zZQ;
    private PhotoEditText zZR;
    private Switch zZS;
    private boolean zZT = true;

    /* renamed from: com.tencent.mm.view.a$2 */
    class C160392 implements AnimationListener {
        C160392() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116372);
            C16051a.this.getFooterBg().setVisibility(8);
            C16051a.this.getActionBar().setVisibility(8);
            AppMethodBeat.m2505o(116372);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.view.a$3 */
    class C160403 implements AnimationListener {
        C160403() {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(116373);
            C16051a.this.odY.setVisibility(0);
            AppMethodBeat.m2505o(116373);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116374);
            C16051a.this.odY.setVisibility(8);
            AppMethodBeat.m2505o(116374);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.view.a$11 */
    class C1605211 implements AnimationListener {
        C1605211() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116383);
            C16051a.this.getActionBar().setVisibility(0);
            C16051a.this.getFooterBg().setVisibility(0);
            AppMethodBeat.m2505o(116383);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.view.a$13 */
    class C1605313 implements AnimationListener {
        C1605313() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116385);
            C16051a.this.getFooterBg().setVisibility(0);
            C16051a.this.getActionBar().setVisibility(0);
            AppMethodBeat.m2505o(116385);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.view.a$9 */
    class C160549 implements C17917a {
        C160549() {
        }

        /* renamed from: a */
        public final void mo7169a(C8955k c8955k) {
            AppMethodBeat.m2504i(116380);
            C4990ab.m7417i("MicroMsg.BaseDrawingView", "[onSelectedEmoji] emojiInfo:%s", c8955k);
            C16051a.this.getPresenter().mo33567d(c8955k);
            onHide();
            AppMethodBeat.m2505o(116380);
        }

        public final void onHide() {
            AppMethodBeat.m2504i(116381);
            C16051a.this.setActionBarVisible(true);
            C16051a.this.mo28431rj(true);
            C16051a.this.setFooterVisible(true);
            AppMethodBeat.m2505o(116381);
        }
    }

    /* renamed from: com.tencent.mm.view.a$12 */
    class C1605512 implements AnimationListener {
        C1605512() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116384);
            C16051a.this.getActionBar().setVisibility(8);
            C16051a.this.getFooterBg().setVisibility(8);
            AppMethodBeat.m2505o(116384);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.view.a$1 */
    class C160561 implements OnClickListener {
        C160561() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(116371);
            if (C16051a.this.getTextEditView().getVisibility() == 0) {
                C16051a.this.getPresenter().mo33562a(C16051a.this.zZR.getText(), C16051a.this.zZR.getCurrentTextColor(), C16051a.this.zZS.isChecked() ? ((Integer) C16051a.this.zZS.getTag()).intValue() : 0);
                AppMethodBeat.m2505o(116371);
                return;
            }
            C16051a.this.getPresenter().onFinish();
            AppMethodBeat.m2505o(116371);
        }
    }

    /* renamed from: com.tencent.mm.view.a$8 */
    class C160578 implements C36375a {
        C160578() {
        }

        /* renamed from: Qy */
        public final void mo28443Qy(int i) {
            AppMethodBeat.m2504i(116379);
            if (C16051a.this.zZS.isChecked()) {
                C16051a.this.zZS.setTag(Integer.valueOf(i));
                C16051a.this.zZR.setTextBackground(i);
                AppMethodBeat.m2505o(116379);
                return;
            }
            C16051a.this.zZR.setTextColor(i);
            AppMethodBeat.m2505o(116379);
        }
    }

    /* renamed from: com.tencent.mm.view.a$5 */
    class C160585 implements Runnable {
        C160585() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116376);
            Rect rect = new Rect();
            C16051a.this.getWindowVisibleDisplayFrame(rect);
            int i = C16051a.this.getBottom() - rect.bottom >= 300 ? 1 : 0;
            C16051a.this.getResources().getDisplayMetrics();
            if (i == 0) {
                i = C16051a.this.getBottom() - ((int) C16051a.this.getResources().getDimension(C25738R.dimen.f10304xe));
            } else {
                i = (C16051a.this.getBottom() - C18175j.m28618Mw()) - ((int) C16051a.this.getResources().getDimension(C25738R.dimen.f10304xe));
                C4990ab.m7413e("MicroMsg.BaseDrawingView", "[onKeyboardChanged] height:%s", Integer.valueOf(i));
            }
            if (C16051a.this.zZR.getHeight() != i) {
                C16051a.this.zZR.setHeight(i);
            }
            C16051a.this.getViewTreeObserver().removeOnGlobalLayoutListener(C16051a.this);
            C16051a.this.getViewTreeObserver().addOnGlobalLayoutListener(C16051a.this);
            AppMethodBeat.m2505o(116376);
        }
    }

    /* renamed from: com.tencent.mm.view.a$10 */
    class C1606010 implements Runnable {
        C1606010() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116382);
            C16051a.this.getPresenter().onAttachedToWindow();
            AppMethodBeat.m2505o(116382);
        }
    }

    /* renamed from: com.tencent.mm.view.a$4 */
    class C160614 implements AnimationListener {
        C160614() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(116375);
            C16051a.this.odY.setVisibility(0);
            AppMethodBeat.m2505o(116375);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.view.a$6 */
    class C160626 implements OnClickListener {
        C160626() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(116377);
            if (C16051a.this.getTextEditView().getVisibility() == 0) {
                C16051a.this.getPresenter().dlS();
                AppMethodBeat.m2505o(116377);
                return;
            }
            C16051a.this.getPresenter().onExit();
            AppMethodBeat.m2505o(116377);
        }
    }

    public abstract C30844a dMG();

    public abstract C16070a dMH();

    public abstract C32247e[] getFeatures();

    public C16051a(Context context, C25785a c25785a) {
        super(context);
        this.ccP = c25785a;
        getPresenter().mo33564a(getConfig());
        removeAllViews();
        addView(getBaseBoardView(), new LayoutParams(-1, -1));
        LayoutParams layoutParams = new LayoutParams(-1, (int) getResources().getDimension(C25738R.dimen.a24));
        layoutParams.gravity = 80;
        addView(getFooterBg(), layoutParams);
        addView(getBaseFooterView(), layoutParams);
        layoutParams = new LayoutParams(-1, -1);
        getTextEditView().setVisibility(8);
        addView(getTextEditView(), layoutParams);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        getRubbishView().setVisibility(8);
        addView(getRubbishView(), layoutParams);
        layoutParams = new LayoutParams(-1, (int) getResources().getDimension(C25738R.dimen.a0f));
        layoutParams.gravity = 80;
        addView(getChatFooterPanel(), layoutParams);
        new LayoutParams(-1, (int) getResources().getDimension(C25738R.dimen.f9777fc)).gravity = 48;
        if (this.ccP.ccT) {
            addView(getActionBar());
        }
    }

    public C25785a getConfig() {
        return this.ccP;
    }

    public <T extends C16070a> T getBaseFooterView() {
        if (this.zZO == null) {
            this.zZO = dMH();
        }
        return this.zZO;
    }

    public <T extends C30844a> T getBaseBoardView() {
        if (this.ccv == null) {
            this.ccv = dMG();
        }
        return this.ccv;
    }

    public View getFooterBg() {
        if (this.zZN == null) {
            this.zZN = LayoutInflater.from(getContext()).inflate(2130969584, null);
            this.zZN.setVisibility(0);
        }
        return this.zZN;
    }

    public View getActionBar() {
        if (this.iJO == null) {
            int hC;
            this.iJO = LayoutInflater.from(getContext()).inflate(2130970362, null);
            if (C5222ae.m7950hD(getContext())) {
                hC = C5222ae.m7949hC(getContext()) + 0;
            } else {
                hC = 0;
            }
            this.iJO.setPadding(0, hC, 0, 0);
            this.oDB = (Button) this.iJO.findViewById(2131826543);
            this.oDB.setOnClickListener(new C160561());
            this.lXI = (Button) this.iJO.findViewById(2131826542);
            this.lXI.setOnClickListener(new C160626());
        }
        return this.iJO;
    }

    public View getTextEditView() {
        if (this.zZP == null) {
            this.zZP = LayoutInflater.from(getContext()).inflate(2130969319, null);
            this.zZR = (PhotoEditText) this.zZP.findViewById(2131823386);
            int dimension = (int) this.zZR.getResources().getDimension(C25738R.dimen.f10373zi);
            int dimension2 = (int) this.zZR.getResources().getDimension(C25738R.dimen.f10304xe);
            if (C5222ae.m7950hD(getContext())) {
                dimension2 += C5222ae.m7949hC(getContext());
            }
            this.zZR.setPadding(dimension, dimension2, dimension, 0);
            final SelectColorBar selectColorBar = (SelectColorBar) this.zZP.findViewById(2131823388);
            this.zZS = (Switch) this.zZP.findViewById(2131823387);
            this.zZS.setTag(Integer.valueOf(-707825));
            this.zZS.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.m2504i(116378);
                    if (z) {
                        selectColorBar.setSelectColor(((Integer) C16051a.this.zZS.getTag()).intValue());
                        C16051a.this.zZR.setTextBackground(((Integer) C16051a.this.zZS.getTag()).intValue());
                        AppMethodBeat.m2505o(116378);
                        return;
                    }
                    C16051a.this.zZS.setTag(Integer.valueOf(selectColorBar.getCurColor()));
                    C16051a.this.zZR.setTextBackground(0);
                    AppMethodBeat.m2505o(116378);
                }
            });
            this.zZR.setTextColor(-1);
            selectColorBar.setSelectColor(-1);
            selectColorBar.setSelectColorListener(new C160578());
        }
        return this.zZP;
    }

    public View getRubbishView() {
        if (this.zZP == null) {
            this.zZQ = LayoutInflater.from(getContext()).inflate(2130970533, null);
        }
        return this.zZQ;
    }

    public ChatFooterPanel getChatFooterPanel() {
        boolean z = false;
        if (this.odY == null) {
            try {
                this.odY = C41757u.m73612aR(getContext());
                this.odY.setEntranceScene(ChatFooterPanel.vhk);
                this.odY.setBackgroundResource(C25738R.drawable.ay1);
                this.odY.mo11688AE();
                this.odY.mo11691bf(true);
                this.odY.mo11696j(true, true);
                this.odY.setVisibility(8);
                this.odY.onResume();
                C17918t AH = C41757u.m73611AH();
                AH.ccZ = new C160549();
                this.odY.setCallback(AH);
            } catch (Exception e) {
                String str = "MicroMsg.BaseDrawingView";
                String str2 = "exception:%s,getContext() is null?";
                Object[] objArr = new Object[2];
                objArr[0] = e.getMessage();
                if (getContext() == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                C4990ab.m7413e(str, str2, objArr);
                throw e;
            }
        }
        return this.odY;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new C1606010());
    }

    public C18117b getPresenter() {
        if (this.cjc == null) {
            this.cjc = new C24659a();
            this.cjc.mo33565a(this);
        }
        return this.cjc;
    }

    public void setActionBarCallback(C32249g c32249g) {
        getPresenter().setActionBarCallback(c32249g);
    }

    public void setAutoShowFooterAndBar(boolean z) {
        getPresenter().setAutoShowFooterAndBar(z);
    }

    public void setFooterVisible(boolean z) {
        if (this.zZT != z) {
            getBaseFooterView().setFooterVisible(z);
            setFooterBgVisible(z);
            this.zZT = z;
        }
    }

    public void setActionBarVisible(boolean z) {
        if (this.ccT == z) {
            C4990ab.m7420w("MicroMsg.BaseDrawingView", "[setActionBarVisible] isShowActionBar == isShow");
            return;
        }
        this.ccT = z;
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8288n);
            loadAnimation.setAnimationListener(new C1605211());
            getActionBar().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8289o);
        loadAnimation.setAnimationListener(new C1605512());
        getActionBar().startAnimation(loadAnimation);
    }

    public void setFooterBgVisible(boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8288n);
            loadAnimation.setAnimationListener(new C1605313());
            getActionBar().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8289o);
        loadAnimation.setAnimationListener(new C160392());
        getActionBar().startAnimation(loadAnimation);
    }

    /* renamed from: rj */
    public final void mo28431rj(boolean z) {
        C4990ab.m7417i("MicroMsg.BaseDrawingView", "[hideSimleyPanel] isHide:%s", Boolean.valueOf(z));
        Animation loadAnimation;
        if (this.odY.getVisibility() == 0 && z) {
            this.odY.setVisibility(8);
            loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8373ce);
            loadAnimation.setAnimationListener(new C160403());
            this.odY.startAnimation(loadAnimation);
        } else if (this.odY.getVisibility() == 8 && !z) {
            loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8375cg);
            loadAnimation.setAnimationListener(new C160614());
            this.odY.startAnimation(loadAnimation);
        }
    }

    public void onGlobalLayout() {
        if (getTextEditView().getVisibility() == 0) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.zZR.postDelayed(new C160585(), 160);
        }
    }
}
