package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.support.v4.widget.j;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.ui.base.l;

public final class d implements OnGlobalLayoutListener {
    private ViewTreeObserver aaM;
    private Context mContext;
    private View pP;
    private l rBn;
    private e uEI;
    public b uEJ = new b() {
        public final void a(l lVar) {
            AppMethodBeat.i(135894);
            c cVar = c.this;
            b bVar = cVar.mUn;
            d dVar = cVar.mUm;
            for (bbb bbb : bVar.mUj) {
                if (bbb == null) {
                    lVar.e(-1, "");
                } else {
                    a aVar = (a) bVar.mUk.get(Integer.valueOf(bbb.wkB));
                    if (aVar != null) {
                        aVar.a(dVar, lVar, bbb);
                    }
                }
            }
            AppMethodBeat.o(135894);
        }
    };
    private GameMenuView uEK;
    private f uEL;
    private boolean uEM = false;
    private boolean uEN;
    public boolean uEO;
    public boolean uEP = false;

    public final void onGlobalLayout() {
        AppMethodBeat.i(8819);
        if (isShowing()) {
            View view = this.pP;
            if (view == null || !view.isShown()) {
                cpE();
                AppMethodBeat.o(8819);
                return;
            } else if (isShowing() && this.uEM != isLandscape()) {
                cpE();
            }
        }
        AppMethodBeat.o(8819);
    }

    public d(Context context) {
        AppMethodBeat.i(8820);
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.pP = viewGroup.getChildAt(0);
            } else {
                this.pP = viewGroup;
            }
        }
        Context context2 = this.mContext;
        this.rBn = new l(context2);
        this.uEI = new e(context2);
        this.uEK = new GameMenuView(context2);
        this.uEL = new f(context2);
        this.uEK.setAdapter(this.uEL);
        this.uEM = isLandscape();
        this.uEI.setContentView(this.uEK);
        AppMethodBeat.o(8820);
    }

    @TargetApi(23)
    private void dcd() {
        AppMethodBeat.i(8821);
        if (VERSION.SDK_INT >= 23 && this.uEI != null) {
            this.uEI.getWindow().getDecorView().setSystemUiVisibility(9216);
            this.uEI.getWindow().setStatusBarColor(0);
        }
        AppMethodBeat.o(8821);
    }

    public final void cpD() {
        int i = 0;
        AppMethodBeat.i(8822);
        this.uEM = isLandscape();
        if (this.uEJ != null) {
            this.uEJ.a(this.rBn);
        }
        if (this.uEI != null) {
            if (this.uEL != null) {
                this.uEL.b(this.rBn);
            }
            if (VERSION.SDK_INT >= 21) {
                this.uEI.getWindow().addFlags(j.INVALID_ID);
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
            if (this.pP != null) {
                if (this.aaM == null) {
                    i = 1;
                }
                this.aaM = this.pP.getViewTreeObserver();
                if (i != 0) {
                    this.aaM.addOnGlobalLayoutListener(this);
                }
            }
            this.uEI.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(8817);
                    d.this.cpE();
                    AppMethodBeat.o(8817);
                }
            });
            if (this.uEK != null) {
                this.uEK.setDismissListener(new a() {
                    public final void onDismiss() {
                        AppMethodBeat.i(8818);
                        d.this.cpE();
                        AppMethodBeat.o(8818);
                    }
                });
            }
            this.uEI.show();
        }
        AppMethodBeat.o(8822);
    }

    public final void cpE() {
        AppMethodBeat.i(8823);
        if (this.aaM != null) {
            if (!this.aaM.isAlive()) {
                this.aaM = this.pP.getViewTreeObserver();
            }
            this.aaM.removeGlobalOnLayoutListener(this);
            this.aaM = null;
        }
        if (this.uEI != null) {
            this.uEI.dismiss();
        }
        AppMethodBeat.o(8823);
    }

    private boolean isShowing() {
        AppMethodBeat.i(8824);
        if (this.uEI == null) {
            AppMethodBeat.o(8824);
            return false;
        } else if (this.uEI.isShowing()) {
            AppMethodBeat.o(8824);
            return true;
        } else {
            AppMethodBeat.o(8824);
            return false;
        }
    }

    public final void a(c cVar) {
        AppMethodBeat.i(8825);
        if (this.uEK != null) {
            this.uEK.setGameMenuItemSelectedListener(cVar);
        }
        AppMethodBeat.o(8825);
    }

    private boolean isLandscape() {
        AppMethodBeat.i(8826);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            AppMethodBeat.o(8826);
            return true;
        }
        AppMethodBeat.o(8826);
        return false;
    }
}
