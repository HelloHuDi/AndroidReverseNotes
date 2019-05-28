package com.tencent.p177mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.base.C5274b.C5272a;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout.C5629b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43945g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43945g.C43944b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.bag.C43945g.C43946a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout;
import p1358me.imid.swipebacklayout.lib.SwipeBackLayout.C24597a;

/* renamed from: com.tencent.mm.plugin.webview.luggage.l */
public final class C22864l implements C43945g {
    private Intent intent = new Intent();
    private C24905d uiI;

    public C22864l(C24905d c24905d) {
        AppMethodBeat.m2504i(6206);
        this.uiI = c24905d;
        this.intent.putExtras(this.uiI.bPP);
        AppMethodBeat.m2505o(6206);
    }

    public final Activity getActivity() {
        return (Activity) this.uiI.mContext;
    }

    public final Intent getIntent() {
        AppMethodBeat.m2504i(6207);
        if (!C5046bo.isNullOrNil(this.uiI.getTitle())) {
            this.intent.putExtra("title", this.uiI.getTitle());
        }
        Intent intent = this.intent;
        AppMethodBeat.m2505o(6207);
        return intent;
    }

    public final String getUrl() {
        AppMethodBeat.m2504i(6208);
        String url = this.uiI.getUrl();
        AppMethodBeat.m2505o(6208);
        return url;
    }

    public final ViewGroup bSl() {
        AppMethodBeat.m2504i(6209);
        ViewGroup viewGroup;
        if (cXf()) {
            viewGroup = (ViewGroup) getActivity().getWindow().getDecorView();
            AppMethodBeat.m2505o(6209);
            return viewGroup;
        }
        viewGroup = (ViewGroup) this.uiI.f4285WL.getParent();
        AppMethodBeat.m2505o(6209);
        return viewGroup;
    }

    public final View getContentView() {
        AppMethodBeat.m2504i(6210);
        View targetView;
        if (!cXf()) {
            targetView = ((SwipeBackLayout) this.uiI.f4285WL).getTargetView();
            AppMethodBeat.m2505o(6210);
            return targetView;
        } else if (((MMActivity) getActivity()).getSwipeBackLayout() != null) {
            targetView = ((MMActivity) getActivity()).getSwipeBackLayout().getTargetContentView();
            AppMethodBeat.m2505o(6210);
            return targetView;
        } else {
            AppMethodBeat.m2505o(6210);
            return null;
        }
    }

    public final boolean cXe() {
        return this.uiI.f4285WL != null;
    }

    /* renamed from: a */
    public final void mo38458a(final C43946a c43946a) {
        AppMethodBeat.m2504i(6211);
        if (c43946a == null) {
            AppMethodBeat.m2505o(6211);
        } else if (this.uiI.f4285WL == null || !(this.uiI.f4285WL instanceof SwipeBackLayout)) {
            AppMethodBeat.m2505o(6211);
        } else {
            if (!cXf()) {
                ((SwipeBackLayout) this.uiI.f4285WL).mo65734a(new C24597a() {
                    /* renamed from: h */
                    public final void mo3956h(int i, float f) {
                        AppMethodBeat.m2504i(6199);
                        if (c43946a != null) {
                            c43946a.mo26833bg(f);
                        }
                        AppMethodBeat.m2505o(6199);
                    }

                    /* renamed from: xv */
                    public final void mo3958xv() {
                    }

                    /* renamed from: l */
                    public final void mo3957l(MotionEvent motionEvent) {
                        AppMethodBeat.m2504i(6200);
                        if (c43946a != null) {
                            c43946a.mo26834l(motionEvent);
                        }
                        AppMethodBeat.m2505o(6200);
                    }

                    /* renamed from: ba */
                    public final boolean mo3955ba(boolean z) {
                        AppMethodBeat.m2504i(6201);
                        if (c43946a != null) {
                            boolean ba = c43946a.mo26832ba(z);
                            AppMethodBeat.m2505o(6201);
                            return ba;
                        }
                        AppMethodBeat.m2505o(6201);
                        return false;
                    }
                });
            }
            if (cXf() && ((MMActivity) getActivity()).getSwipeBackLayout() != null) {
                ((MMActivity) getActivity()).getSwipeBackLayout().setSwipeBackListener(new C5629b() {
                    /* renamed from: bf */
                    public final void mo11404bf(float f) {
                        AppMethodBeat.m2504i(6202);
                        if (c43946a != null) {
                            c43946a.mo26833bg(f);
                        }
                        AppMethodBeat.m2505o(6202);
                    }

                    /* renamed from: l */
                    public final void mo11405l(MotionEvent motionEvent) {
                        AppMethodBeat.m2504i(6203);
                        if (c43946a != null) {
                            c43946a.mo26834l(motionEvent);
                        }
                        AppMethodBeat.m2505o(6203);
                    }

                    /* renamed from: ba */
                    public final boolean mo11403ba(boolean z) {
                        AppMethodBeat.m2504i(6204);
                        if (c43946a != null) {
                            boolean ba = c43946a.mo26832ba(z);
                            AppMethodBeat.m2505o(6204);
                            return ba;
                        }
                        AppMethodBeat.m2505o(6204);
                        return false;
                    }
                });
            }
            AppMethodBeat.m2505o(6211);
        }
    }

    /* renamed from: mu */
    public final void mo38466mu(boolean z) {
        AppMethodBeat.m2504i(6212);
        if (!this.uiI.bPe.mo43477xi().mo60233aZ(false)) {
            ((Activity) this.uiI.mContext).finish();
        }
        AppMethodBeat.m2505o(6212);
    }

    /* renamed from: a */
    public final void mo38459a(final C43944b c43944b) {
        AppMethodBeat.m2504i(6213);
        if (cXf()) {
            C5274b.m8045a(getActivity(), new C5272a() {
                /* renamed from: iH */
                public final void mo10877iH(boolean z) {
                    AppMethodBeat.m2504i(6205);
                    c43944b.mo56357iH(z);
                    AppMethodBeat.m2505o(6205);
                }
            });
            AppMethodBeat.m2505o(6213);
            return;
        }
        c43944b.mo56357iH(true);
        AppMethodBeat.m2505o(6213);
    }

    private boolean cXf() {
        AppMethodBeat.m2504i(6214);
        C4990ab.m7416i("MicroMsg.LuggageWebBagAdapter", "useActivityEnv: " + this.uiI.bPe.mo43476xh().size());
        if (this.uiI.bPe.mo43476xh().size() <= 1) {
            AppMethodBeat.m2505o(6214);
            return true;
        }
        AppMethodBeat.m2505o(6214);
        return false;
    }
}
