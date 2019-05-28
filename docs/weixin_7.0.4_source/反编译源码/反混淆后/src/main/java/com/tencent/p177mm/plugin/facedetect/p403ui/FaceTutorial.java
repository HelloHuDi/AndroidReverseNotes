package com.tencent.p177mm.plugin.facedetect.p403ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.C31857l;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C2288t;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44699i;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C19403g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C2294a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C33332f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C36724c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C38314b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p309j.C41234e;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19482c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;

/* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTutorial */
public final class FaceTutorial {
    /* renamed from: MI */
    ViewPager f17893MI;
    View kRR = null;
    Button lWE;
    Animation lWI = null;
    C20659a lYq;
    /* renamed from: sr */
    C25365p f17894sr;

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTutorial$1 */
    class C206571 implements OnClickListener {
        C206571() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(C38314b.CTRL_INDEX);
            if (FaceTutorial.this.lYq != null) {
                FaceTutorial.this.lYq.onCancel();
            }
            FaceTutorial.this.dismiss();
            AppMethodBeat.m2505o(C38314b.CTRL_INDEX);
        }
    }

    @SuppressLint({"ValidFragment"})
    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTutorial$TutorialOne */
    public static class TutorialOne extends Fragment {
        private View kRR = null;
        private Button lYt = null;
        private WeakReference<FaceTutorial> lYu;

        /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTutorial$TutorialOne$1 */
        class C206581 implements OnClickListener {
            C206581() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(C36724c.CTRL_INDEX);
                if (TutorialOne.this.lYu.get() != null) {
                    FaceTutorial faceTutorial = (FaceTutorial) TutorialOne.this.lYu.get();
                    if (faceTutorial.lYq != null) {
                        faceTutorial.lYq.btp();
                    }
                    faceTutorial.dismiss();
                    AppMethodBeat.m2505o(C36724c.CTRL_INDEX);
                    return;
                }
                C4990ab.m7412e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
                AppMethodBeat.m2505o(C36724c.CTRL_INDEX);
            }
        }

        public TutorialOne(FaceTutorial faceTutorial) {
            AppMethodBeat.m2504i(C19482c.CTRL_INDEX);
            C4990ab.m7416i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo constructed");
            this.lYu = new WeakReference(faceTutorial);
            AppMethodBeat.m2505o(C19482c.CTRL_INDEX);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppMethodBeat.m2504i(523);
            C4990ab.m7416i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreateView()");
            this.kRR = layoutInflater.inflate(2130969481, viewGroup, false);
            this.lYt = (Button) this.kRR.findViewById(2131823839);
            this.lYt.setOnClickListener(new C206581());
            View view = this.kRR;
            AppMethodBeat.m2505o(523);
            return view;
        }

        public void onCreate(Bundle bundle) {
            AppMethodBeat.m2504i(524);
            C4990ab.m7416i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreate");
            super.onCreate(bundle);
            AppMethodBeat.m2505o(524);
        }

        public void onDestroy() {
            AppMethodBeat.m2504i(C44699i.CTRL_INDEX);
            super.onDestroy();
            C4990ab.m7416i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
            AppMethodBeat.m2505o(C44699i.CTRL_INDEX);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTutorial$a */
    interface C20659a {
        void btp();

        void onCancel();
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTutorial$b */
    class C27938b extends C31857l {
        public C27938b(C0336i c0336i) {
            super(c0336i);
        }

        public final Fragment getItem(int i) {
            AppMethodBeat.m2504i(C41234e.CTRL_INDEX);
            switch (i) {
                case 0:
                    TutorialOne tutorialOne = new TutorialOne(FaceTutorial.this);
                    AppMethodBeat.m2505o(C41234e.CTRL_INDEX);
                    return tutorialOne;
                default:
                    InvalidParameterException invalidParameterException = new InvalidParameterException("hy: invalid page status");
                    AppMethodBeat.m2505o(C41234e.CTRL_INDEX);
                    throw invalidParameterException;
            }
        }

        public final int getCount() {
            return 1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTutorial$2 */
    class C430442 implements OnPageChangeListener {
        C430442() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.m2504i(C2294a.CTRL_INDEX);
            if (FaceTutorial.this.f17893MI.getParent() != null) {
                FaceTutorial.this.f17893MI.getParent().requestDisallowInterceptTouchEvent(true);
            }
            AppMethodBeat.m2505o(C2294a.CTRL_INDEX);
        }

        public final void onPageScrollStateChanged(int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTutorial$3 */
    class C430453 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceTutorial$3$1 */
        class C390241 implements AnimationListener {
            C390241() {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(C33332f.CTRL_INDEX);
                FaceTutorial.this.kRR.setVisibility(8);
                AppMethodBeat.m2505o(C33332f.CTRL_INDEX);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        }

        C430453() {
        }

        public final void run() {
            AppMethodBeat.m2504i(C19403g.CTRL_INDEX);
            FaceTutorial.this.lWI.setAnimationListener(new C390241());
            FaceTutorial.this.kRR.startAnimation(FaceTutorial.this.lWI);
            AppMethodBeat.m2505o(C19403g.CTRL_INDEX);
        }
    }

    public FaceTutorial() {
        AppMethodBeat.m2504i(C2288t.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceTutorial", "initFaceTutorial");
        this.lWI = AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8289o);
        this.lWI.setDuration(500);
        AppMethodBeat.m2505o(C2288t.CTRL_INDEX);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(JsApiGetABTestConfig.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceTutorial", "dismiss()");
        if (this.kRR.getVisibility() == 0) {
            C5004al.m7441d(new C430453());
        }
        AppMethodBeat.m2505o(JsApiGetABTestConfig.CTRL_INDEX);
    }
}
