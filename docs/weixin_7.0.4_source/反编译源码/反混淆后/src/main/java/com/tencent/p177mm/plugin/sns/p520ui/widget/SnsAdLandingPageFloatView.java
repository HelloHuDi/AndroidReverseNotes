package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18381qv;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C13469p;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C13437h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3952g;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView */
public class SnsAdLandingPageFloatView extends FrameLayout {
    public String cHR;
    public String hcx;
    private boolean isResume;
    public ValueAnimator nVR = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f}).setDuration(100);
    public String qPj;
    public String qTM;
    private Map<String, String> qXs = new HashMap();
    public boolean rEC;
    public int rMA;
    public String rMB;
    public String rMC;
    public C13469p rMD;
    public C3952g rME;
    public C13437h rMF;
    public View rMG;
    public AnimatorSet rMH = new AnimatorSet();
    public LinkedList<C3952g> rnM = new LinkedList();
    public String rnT;
    private List<C13437h> rot;

    /* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView$1 */
    public class C40981 implements AnimatorUpdateListener {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40438);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SnsAdLandingPageFloatView.this.rMG.setScaleX(floatValue);
            SnsAdLandingPageFloatView.this.rMG.setScaleY(floatValue);
            AppMethodBeat.m2505o(40438);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView$3 */
    public class C40993 extends AnimatorListenerAdapter {
        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40440);
            SnsAdLandingPageFloatView.this.rEC = true;
            SnsAdLandingPageFloatView.this.onResume();
            C18381qv c18381qv = new C18381qv();
            c18381qv.cNa.cNb = SnsAdLandingPageFloatView.this.cHR;
            c18381qv.cNa.state = 120;
            C4879a.xxA.mo10055m(c18381qv);
            AppMethodBeat.m2505o(40440);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40441);
            SnsAdLandingPageFloatView.this.rEC = false;
            C18381qv c18381qv = new C18381qv();
            c18381qv.cNa.cNb = SnsAdLandingPageFloatView.this.cHR;
            c18381qv.cNa.state = 121;
            C4879a.xxA.mo10055m(c18381qv);
            AppMethodBeat.m2505o(40441);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView$2 */
    public class C137142 implements AnimatorUpdateListener {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40439);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SnsAdLandingPageFloatView.this.rMG.setScaleX(floatValue);
            SnsAdLandingPageFloatView.this.rMG.setScaleY(floatValue);
            AppMethodBeat.m2505o(40439);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView$4 */
    public class C351414 implements AnimatorUpdateListener {
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40442);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            SnsAdLandingPageFloatView.this.rMG.setScaleX(floatValue);
            SnsAdLandingPageFloatView.this.rMG.setScaleY(floatValue);
            AppMethodBeat.m2505o(40442);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView$6 */
    public class C351426 implements OnTouchListener {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(40445);
            C4990ab.m7417i("MicroMsg.SnsAdLandingPageFloatView", "view area %s, (%f,%f)", new Rect(SnsAdLandingPageFloatView.this.rMF.getView().getLeft(), SnsAdLandingPageFloatView.this.rMF.getView().getTop(), SnsAdLandingPageFloatView.this.rMF.getView().getRight(), SnsAdLandingPageFloatView.this.rMF.getView().getBottom()), Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()));
            if (new Rect(SnsAdLandingPageFloatView.this.rMF.getView().getLeft(), SnsAdLandingPageFloatView.this.rMF.getView().getTop(), SnsAdLandingPageFloatView.this.rMF.getView().getRight(), SnsAdLandingPageFloatView.this.rMF.getView().getBottom()).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                AppMethodBeat.m2505o(40445);
                return false;
            }
            if (motionEvent.getActionMasked() == 1) {
                SnsAdLandingPageFloatView snsAdLandingPageFloatView = SnsAdLandingPageFloatView.this;
                if (!snsAdLandingPageFloatView.rEC) {
                    snsAdLandingPageFloatView.nVR.start();
                    snsAdLandingPageFloatView.rEC = true;
                }
            }
            AppMethodBeat.m2505o(40445);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView$7 */
    class C351437 implements Runnable {
        C351437() {
        }

        public final void run() {
            AppMethodBeat.m2504i(40446);
            SnsAdLandingPageFloatView.this.rMF.cpc();
            AppMethodBeat.m2505o(40446);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsAdLandingPageFloatView$5 */
    public class C351445 extends AnimatorListenerAdapter {
        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40443);
            SnsAdLandingPageFloatView.this.rEC = true;
            SnsAdLandingPageFloatView.this.isResume = false;
            SnsAdLandingPageFloatView.this.onPause();
            C18381qv c18381qv = new C18381qv();
            c18381qv.cNa.cNb = SnsAdLandingPageFloatView.this.cHR;
            c18381qv.cNa.state = 122;
            C4879a.xxA.mo10055m(c18381qv);
            AppMethodBeat.m2505o(40443);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40444);
            SnsAdLandingPageFloatView.this.rMG.setVisibility(8);
            SnsAdLandingPageFloatView.this.rEC = false;
            C18381qv c18381qv = new C18381qv();
            c18381qv.cNa.cNb = SnsAdLandingPageFloatView.this.cHR;
            c18381qv.cNa.state = 123;
            C4879a.xxA.mo10055m(c18381qv);
            AppMethodBeat.m2505o(40444);
        }
    }

    public SnsAdLandingPageFloatView(Context context) {
        super(context, null);
        AppMethodBeat.m2504i(40447);
        AppMethodBeat.m2505o(40447);
    }

    public SnsAdLandingPageFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        AppMethodBeat.m2504i(40448);
        AppMethodBeat.m2505o(40448);
    }

    public SnsAdLandingPageFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, -1);
        AppMethodBeat.m2504i(40449);
        AppMethodBeat.m2505o(40449);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(40450);
        this.isResume = true;
        if (this.rME != null) {
            this.rMF.cpa();
            post(new C351437());
        }
        AppMethodBeat.m2505o(40450);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(40451);
        this.isResume = false;
        if (this.rME != null) {
            this.rMF.cpb();
        }
        AppMethodBeat.m2505o(40451);
    }

    public final void cvw() {
        AppMethodBeat.m2504i(40452);
        if (this.rME != null && !C5046bo.isNullOrNil(this.qTM)) {
            String str = ".adCardItemList.cardItem";
            Map z = C5049br.m7595z(this.qTM, "adCardItemList");
            int i = 0;
            while (true) {
                String str2;
                if (i > 0) {
                    str2 = str + i;
                } else {
                    str2 = str;
                }
                if (!z.containsKey(str2 + ".cardTpId")) {
                    break;
                }
                String bc = C5046bo.m7532bc((String) z.get(str2 + ".cardTpId"), "");
                String bc2 = C5046bo.m7532bc((String) z.get(str2 + ".cardExt"), "");
                if (!(C5046bo.isNullOrNil(bc) || C5046bo.isNullOrNil(bc2))) {
                    this.qXs.put(bc, bc2);
                }
                i++;
            }
        }
        AppMethodBeat.m2505o(40452);
    }

    public List<C13437h> getAllComp() {
        AppMethodBeat.m2504i(40453);
        if (this.rot != null) {
            List list = this.rot;
            AppMethodBeat.m2505o(40453);
            return list;
        }
        this.rot = new ArrayList();
        this.rot.add(this.rMF);
        C3953i.m6300dj(this.rot);
        List<C13437h> list2 = this.rot;
        AppMethodBeat.m2505o(40453);
        return list2;
    }
}
