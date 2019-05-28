package com.tencent.mm.plugin.facedetect.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.l;
import android.support.v4.view.ViewPager;
import android.support.v4.view.p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.appbrand.jsapi.g.i;
import com.tencent.mm.plugin.appbrand.jsapi.g.t;
import com.tencent.mm.plugin.appbrand.jsapi.j.e;
import com.tencent.mm.plugin.appbrand.jsapi.j.f;
import com.tencent.mm.plugin.appbrand.jsapi.j.g;
import com.tencent.mm.plugin.appbrand.jsapi.storage.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;

public final class FaceTutorial {
    ViewPager MI;
    View kRR = null;
    Button lWE;
    Animation lWI = null;
    a lYq;
    p sr;

    @SuppressLint({"ValidFragment"})
    public static class TutorialOne extends Fragment {
        private View kRR = null;
        private Button lYt = null;
        private WeakReference<FaceTutorial> lYu;

        public TutorialOne(FaceTutorial faceTutorial) {
            AppMethodBeat.i(c.CTRL_INDEX);
            ab.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo constructed");
            this.lYu = new WeakReference(faceTutorial);
            AppMethodBeat.o(c.CTRL_INDEX);
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            AppMethodBeat.i(523);
            ab.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreateView()");
            this.kRR = layoutInflater.inflate(R.layout.xp, viewGroup, false);
            this.lYt = (Button) this.kRR.findViewById(R.id.bo2);
            this.lYt.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX);
                    if (TutorialOne.this.lYu.get() != null) {
                        FaceTutorial faceTutorial = (FaceTutorial) TutorialOne.this.lYu.get();
                        if (faceTutorial.lYq != null) {
                            faceTutorial.lYq.btp();
                        }
                        faceTutorial.dismiss();
                        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX);
                        return;
                    }
                    ab.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
                    AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX);
                }
            });
            View view = this.kRR;
            AppMethodBeat.o(523);
            return view;
        }

        public void onCreate(Bundle bundle) {
            AppMethodBeat.i(524);
            ab.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreate");
            super.onCreate(bundle);
            AppMethodBeat.o(524);
        }

        public void onDestroy() {
            AppMethodBeat.i(i.CTRL_INDEX);
            super.onDestroy();
            ab.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
            AppMethodBeat.o(i.CTRL_INDEX);
        }
    }

    interface a {
        void btp();

        void onCancel();
    }

    class b extends l {
        public b(android.support.v4.app.i iVar) {
            super(iVar);
        }

        public final Fragment getItem(int i) {
            AppMethodBeat.i(e.CTRL_INDEX);
            switch (i) {
                case 0:
                    TutorialOne tutorialOne = new TutorialOne(FaceTutorial.this);
                    AppMethodBeat.o(e.CTRL_INDEX);
                    return tutorialOne;
                default:
                    InvalidParameterException invalidParameterException = new InvalidParameterException("hy: invalid page status");
                    AppMethodBeat.o(e.CTRL_INDEX);
                    throw invalidParameterException;
            }
        }

        public final int getCount() {
            return 1;
        }
    }

    public FaceTutorial() {
        AppMethodBeat.i(t.CTRL_INDEX);
        ab.i("MicroMsg.FaceTutorial", "initFaceTutorial");
        this.lWI = AnimationUtils.loadAnimation(ah.getContext(), R.anim.o);
        this.lWI.setDuration(500);
        AppMethodBeat.o(t.CTRL_INDEX);
    }

    public final void dismiss() {
        AppMethodBeat.i(JsApiGetABTestConfig.CTRL_INDEX);
        ab.i("MicroMsg.FaceTutorial", "dismiss()");
        if (this.kRR.getVisibility() == 0) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(g.CTRL_INDEX);
                    FaceTutorial.this.lWI.setAnimationListener(new AnimationListener() {
                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            AppMethodBeat.i(f.CTRL_INDEX);
                            FaceTutorial.this.kRR.setVisibility(8);
                            AppMethodBeat.o(f.CTRL_INDEX);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    FaceTutorial.this.kRR.startAnimation(FaceTutorial.this.lWI);
                    AppMethodBeat.o(g.CTRL_INDEX);
                }
            });
        }
        AppMethodBeat.o(JsApiGetABTestConfig.CTRL_INDEX);
    }
}
