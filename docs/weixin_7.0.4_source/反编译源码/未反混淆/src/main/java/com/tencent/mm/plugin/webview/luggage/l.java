package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.bag.g;
import com.tencent.mm.plugin.webview.ui.tools.bag.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public final class l implements g {
    private Intent intent = new Intent();
    private d uiI;

    public l(d dVar) {
        AppMethodBeat.i(6206);
        this.uiI = dVar;
        this.intent.putExtras(this.uiI.bPP);
        AppMethodBeat.o(6206);
    }

    public final Activity getActivity() {
        return (Activity) this.uiI.mContext;
    }

    public final Intent getIntent() {
        AppMethodBeat.i(6207);
        if (!bo.isNullOrNil(this.uiI.getTitle())) {
            this.intent.putExtra("title", this.uiI.getTitle());
        }
        Intent intent = this.intent;
        AppMethodBeat.o(6207);
        return intent;
    }

    public final String getUrl() {
        AppMethodBeat.i(6208);
        String url = this.uiI.getUrl();
        AppMethodBeat.o(6208);
        return url;
    }

    public final ViewGroup bSl() {
        AppMethodBeat.i(6209);
        ViewGroup viewGroup;
        if (cXf()) {
            viewGroup = (ViewGroup) getActivity().getWindow().getDecorView();
            AppMethodBeat.o(6209);
            return viewGroup;
        }
        viewGroup = (ViewGroup) this.uiI.WL.getParent();
        AppMethodBeat.o(6209);
        return viewGroup;
    }

    public final View getContentView() {
        AppMethodBeat.i(6210);
        View targetView;
        if (!cXf()) {
            targetView = ((SwipeBackLayout) this.uiI.WL).getTargetView();
            AppMethodBeat.o(6210);
            return targetView;
        } else if (((MMActivity) getActivity()).getSwipeBackLayout() != null) {
            targetView = ((MMActivity) getActivity()).getSwipeBackLayout().getTargetContentView();
            AppMethodBeat.o(6210);
            return targetView;
        } else {
            AppMethodBeat.o(6210);
            return null;
        }
    }

    public final boolean cXe() {
        return this.uiI.WL != null;
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(6211);
        if (aVar == null) {
            AppMethodBeat.o(6211);
        } else if (this.uiI.WL == null || !(this.uiI.WL instanceof SwipeBackLayout)) {
            AppMethodBeat.o(6211);
        } else {
            if (!cXf()) {
                ((SwipeBackLayout) this.uiI.WL).a(new SwipeBackLayout.a() {
                    public final void h(int i, float f) {
                        AppMethodBeat.i(6199);
                        if (aVar != null) {
                            aVar.bg(f);
                        }
                        AppMethodBeat.o(6199);
                    }

                    public final void xv() {
                    }

                    public final void l(MotionEvent motionEvent) {
                        AppMethodBeat.i(6200);
                        if (aVar != null) {
                            aVar.l(motionEvent);
                        }
                        AppMethodBeat.o(6200);
                    }

                    public final boolean ba(boolean z) {
                        AppMethodBeat.i(6201);
                        if (aVar != null) {
                            boolean ba = aVar.ba(z);
                            AppMethodBeat.o(6201);
                            return ba;
                        }
                        AppMethodBeat.o(6201);
                        return false;
                    }
                });
            }
            if (cXf() && ((MMActivity) getActivity()).getSwipeBackLayout() != null) {
                ((MMActivity) getActivity()).getSwipeBackLayout().setSwipeBackListener(new b() {
                    public final void bf(float f) {
                        AppMethodBeat.i(6202);
                        if (aVar != null) {
                            aVar.bg(f);
                        }
                        AppMethodBeat.o(6202);
                    }

                    public final void l(MotionEvent motionEvent) {
                        AppMethodBeat.i(6203);
                        if (aVar != null) {
                            aVar.l(motionEvent);
                        }
                        AppMethodBeat.o(6203);
                    }

                    public final boolean ba(boolean z) {
                        AppMethodBeat.i(6204);
                        if (aVar != null) {
                            boolean ba = aVar.ba(z);
                            AppMethodBeat.o(6204);
                            return ba;
                        }
                        AppMethodBeat.o(6204);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(6211);
        }
    }

    public final void mu(boolean z) {
        AppMethodBeat.i(6212);
        if (!this.uiI.bPe.xi().aZ(false)) {
            ((Activity) this.uiI.mContext).finish();
        }
        AppMethodBeat.o(6212);
    }

    public final void a(final g.b bVar) {
        AppMethodBeat.i(6213);
        if (cXf()) {
            com.tencent.mm.ui.base.b.a(getActivity(), new com.tencent.mm.ui.base.b.a() {
                public final void iH(boolean z) {
                    AppMethodBeat.i(6205);
                    bVar.iH(z);
                    AppMethodBeat.o(6205);
                }
            });
            AppMethodBeat.o(6213);
            return;
        }
        bVar.iH(true);
        AppMethodBeat.o(6213);
    }

    private boolean cXf() {
        AppMethodBeat.i(6214);
        ab.i("MicroMsg.LuggageWebBagAdapter", "useActivityEnv: " + this.uiI.bPe.xh().size());
        if (this.uiI.bPe.xh().size() <= 1) {
            AppMethodBeat.o(6214);
            return true;
        }
        AppMethodBeat.o(6214);
        return false;
    }
}
