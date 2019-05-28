package com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C8415j;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.game.luggage.p430c.p431a.C34291c.C209751;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46440b.C14617c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46440b.C40317a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46440b.C46439b;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.d */
public final class C46442d implements OnGlobalLayoutListener {
    private ViewTreeObserver aaM;
    private Context mContext;
    /* renamed from: pP */
    private View f17911pP;
    private C44273l rBn;
    private C22981e uEI;
    public C46439b uEJ = new C209751();
    private GameMenuView uEK;
    private C29925f uEL;
    private boolean uEM = false;
    private boolean uEN;
    public boolean uEO;
    public boolean uEP = false;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.d$1 */
    class C403191 implements OnDismissListener {
        C403191() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(8817);
            C46442d.this.cpE();
            AppMethodBeat.m2505o(8817);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.d$2 */
    class C464412 implements C40317a {
        C464412() {
        }

        public final void onDismiss() {
            AppMethodBeat.m2504i(8818);
            C46442d.this.cpE();
            AppMethodBeat.m2505o(8818);
        }
    }

    public final void onGlobalLayout() {
        AppMethodBeat.m2504i(8819);
        if (isShowing()) {
            View view = this.f17911pP;
            if (view == null || !view.isShown()) {
                cpE();
                AppMethodBeat.m2505o(8819);
                return;
            } else if (isShowing() && this.uEM != isLandscape()) {
                cpE();
            }
        }
        AppMethodBeat.m2505o(8819);
    }

    public C46442d(Context context) {
        AppMethodBeat.m2504i(8820);
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.f17911pP = viewGroup.getChildAt(0);
            } else {
                this.f17911pP = viewGroup;
            }
        }
        Context context2 = this.mContext;
        this.rBn = new C44273l(context2);
        this.uEI = new C22981e(context2);
        this.uEK = new GameMenuView(context2);
        this.uEL = new C29925f(context2);
        this.uEK.setAdapter(this.uEL);
        this.uEM = isLandscape();
        this.uEI.setContentView(this.uEK);
        AppMethodBeat.m2505o(8820);
    }

    @TargetApi(23)
    private void dcd() {
        AppMethodBeat.m2504i(8821);
        if (VERSION.SDK_INT >= 23 && this.uEI != null) {
            this.uEI.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.uEI.getWindow().setStatusBarColor(0);
        }
        AppMethodBeat.m2505o(8821);
    }

    public final void cpD() {
        int i = 0;
        AppMethodBeat.m2504i(8822);
        this.uEM = isLandscape();
        if (this.uEJ != null) {
            this.uEJ.mo36295a(this.rBn);
        }
        if (this.uEI != null) {
            if (this.uEL != null) {
                this.uEL.mo48172b(this.rBn);
            }
            if (VERSION.SDK_INT >= 21) {
                this.uEI.getWindow().addFlags(C8415j.INVALID_ID);
            }
            if (this.uEN) {
                dcd();
            }
            if (this.uEO) {
                this.uEI.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            if (this.uEP) {
                this.uEI.getWindow().setFlags(8, 8);
                this.uEI.getWindow().addFlags(131200);
                this.uEI.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.uEI.getWindow().clearFlags(8);
                this.uEI.getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                this.uEI.getWindow().clearFlags(128);
                this.uEI.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.f17911pP != null) {
                if (this.aaM == null) {
                    i = 1;
                }
                this.aaM = this.f17911pP.getViewTreeObserver();
                if (i != 0) {
                    this.aaM.addOnGlobalLayoutListener(this);
                }
            }
            this.uEI.setOnDismissListener(new C403191());
            if (this.uEK != null) {
                this.uEK.setDismissListener(new C464412());
            }
            this.uEI.show();
        }
        AppMethodBeat.m2505o(8822);
    }

    public final void cpE() {
        AppMethodBeat.m2504i(8823);
        if (this.aaM != null) {
            if (!this.aaM.isAlive()) {
                this.aaM = this.f17911pP.getViewTreeObserver();
            }
            this.aaM.removeGlobalOnLayoutListener(this);
            this.aaM = null;
        }
        if (this.uEI != null) {
            this.uEI.dismiss();
        }
        AppMethodBeat.m2505o(8823);
    }

    private boolean isShowing() {
        AppMethodBeat.m2504i(8824);
        if (this.uEI == null) {
            AppMethodBeat.m2505o(8824);
            return false;
        } else if (this.uEI.isShowing()) {
            AppMethodBeat.m2505o(8824);
            return true;
        } else {
            AppMethodBeat.m2505o(8824);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo74657a(C14617c c14617c) {
        AppMethodBeat.m2504i(8825);
        if (this.uEK != null) {
            this.uEK.setGameMenuItemSelectedListener(c14617c);
        }
        AppMethodBeat.m2505o(8825);
    }

    private boolean isLandscape() {
        AppMethodBeat.m2504i(8826);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            AppMethodBeat.m2505o(8826);
            return true;
        }
        AppMethodBeat.m2505o(8826);
        return false;
    }
}
