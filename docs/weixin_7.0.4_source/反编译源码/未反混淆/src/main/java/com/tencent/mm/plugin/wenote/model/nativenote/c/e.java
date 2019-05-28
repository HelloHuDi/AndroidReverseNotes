package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.c.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;

public final class e implements a {
    public static boolean mHasInit = false;
    public static volatile e uRg = null;
    public ak mHandler = null;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;
    public com.tencent.mm.plugin.wenote.model.nativenote.b.a uRA = null;
    public d uRB = null;
    public b uRC = null;
    public ap uRD = null;
    public ap uRE = null;
    public TextView uRF = null;
    public TextView uRG = null;
    public TextView uRH = null;
    public TextView uRI = null;
    public TextView uRJ = null;
    public TextView uRK = null;
    public TextView uRL = null;
    public TextView uRM = null;
    public boolean uRh = true;
    public int uRi = 0;
    public int uRj = 0;
    public int uRk = 14;
    public int uRl = 0;
    public int uRm = 0;
    public int uRn = 0;
    public int uRo = 0;
    public int uRp = 0;
    public int uRq = 0;
    public int uRr = 0;
    public int[] uRs = null;
    public int[] uRt = null;
    public int[] uRu = null;
    public int[] uRv = null;
    public PopupWindow uRw = null;
    public PopupWindow uRx = null;
    public PopupWindow uRy = null;
    public PopupWindow uRz = null;

    static /* synthetic */ RecyclerView a(e eVar) {
        AppMethodBeat.i(26916);
        RecyclerView recyclerView = eVar.getRecyclerView();
        AppMethodBeat.o(26916);
        return recyclerView;
    }

    static /* synthetic */ ArrayList b(e eVar, boolean z, ArrayList arrayList, String str) {
        AppMethodBeat.i(26926);
        ArrayList b = eVar.b(z, arrayList, str);
        AppMethodBeat.o(26926);
        return b;
    }

    static /* synthetic */ boolean b(e eVar) {
        AppMethodBeat.i(26917);
        boolean Ki = eVar.Ki(2);
        AppMethodBeat.o(26917);
        return Ki;
    }

    static /* synthetic */ int d(e eVar) {
        AppMethodBeat.i(26919);
        int dfn = eVar.dfn();
        AppMethodBeat.o(26919);
        return dfn;
    }

    static /* synthetic */ void e(e eVar) {
        AppMethodBeat.i(26920);
        eVar.dfe();
        AppMethodBeat.o(26920);
    }

    static /* synthetic */ void f(e eVar) {
        AppMethodBeat.i(26921);
        eVar.or(false);
        AppMethodBeat.o(26921);
    }

    static /* synthetic */ void h(e eVar) {
        AppMethodBeat.i(26922);
        eVar.dfo();
        AppMethodBeat.o(26922);
    }

    private e() {
        mHasInit = false;
    }

    public static e dfb() {
        AppMethodBeat.i(26871);
        if (uRg == null) {
            synchronized (c.class) {
                try {
                    if (uRg == null) {
                        uRg = new e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(26871);
                    }
                }
            }
        }
        e eVar = uRg;
        AppMethodBeat.o(26871);
        return eVar;
    }

    public static boolean isEnabled() {
        return mHasInit;
    }

    public final boolean isEditable() {
        return mHasInit && this.uRh;
    }

    private RecyclerView getRecyclerView() {
        AppMethodBeat.i(26872);
        if (this.uRA != null) {
            RecyclerView def = this.uRA.def();
            AppMethodBeat.o(26872);
            return def;
        }
        AppMethodBeat.o(26872);
        return null;
    }

    private int dfc() {
        AppMethodBeat.i(26873);
        if (this.uRA != null) {
            int dec = this.uRA.dec() + this.uRA.ded();
            AppMethodBeat.o(26873);
            return dec;
        }
        AppMethodBeat.o(26873);
        return 0;
    }

    public final int dfa() {
        AppMethodBeat.i(26874);
        if (mHasInit) {
            if (this.uRB == null) {
                this.uRB = new d();
            }
            int dfa = this.uRB.dfa();
            AppMethodBeat.o(26874);
            return dfa;
        }
        AppMethodBeat.o(26874);
        return 0;
    }

    public final d dfd() {
        AppMethodBeat.i(26875);
        d dVar;
        if (mHasInit) {
            if (this.uRB == null) {
                this.uRB = new d();
            }
            dVar = new d(this.uRB.coc, this.uRB.startOffset, this.uRB.endPos, this.uRB.uRf);
            AppMethodBeat.o(26875);
            return dVar;
        }
        dVar = new d();
        AppMethodBeat.o(26875);
        return dVar;
    }

    public final boolean H(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(26876);
        if (mHasInit) {
            boolean z;
            if (this.uRB == null) {
                this.uRB = new d(i, i2, i3, i4);
                z = true;
            } else if (this.uRB.coc == i && this.uRB.startOffset == i2 && this.uRB.endPos == i3 && this.uRB.uRf == i4) {
                z = false;
            } else {
                this.uRB.set(i, i2, i3, i4);
                z = true;
            }
            if (z) {
                ab.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", Integer.valueOf(this.uRB.coc), Integer.valueOf(this.uRB.startOffset), Integer.valueOf(this.uRB.endPos), Integer.valueOf(this.uRB.uRf));
            }
            AppMethodBeat.o(26876);
            return z;
        }
        AppMethodBeat.o(26876);
        return false;
    }

    public final int Kh(int i) {
        AppMethodBeat.i(26877);
        if (!mHasInit || this.uRB == null) {
            AppMethodBeat.o(26877);
            return 0;
        } else if (dfa() == 0 || i < this.uRB.coc || i > this.uRB.endPos) {
            AppMethodBeat.o(26877);
            return 0;
        } else if (i == this.uRB.coc && i == this.uRB.endPos) {
            AppMethodBeat.o(26877);
            return 1;
        } else if (i > this.uRB.coc && i < this.uRB.endPos) {
            AppMethodBeat.o(26877);
            return 2;
        } else if (i == this.uRB.coc && i < this.uRB.endPos) {
            AppMethodBeat.o(26877);
            return 4;
        } else if (i <= this.uRB.coc || i != this.uRB.endPos) {
            AppMethodBeat.o(26877);
            return 0;
        } else {
            AppMethodBeat.o(26877);
            return 3;
        }
    }

    private void aq(int i, int i2, int i3) {
        if (mHasInit) {
            switch (i) {
                case 2:
                    if (this.uRt != null && this.uRt.length == 2) {
                        this.uRt[0] = i2;
                        this.uRt[1] = i3;
                        return;
                    }
                    return;
                case 3:
                    if (this.uRu != null && this.uRu.length == 2) {
                        this.uRu[0] = i2;
                        this.uRu[1] = i3;
                        return;
                    }
                    return;
                case 4:
                    if (this.uRv != null && this.uRv.length == 2) {
                        this.uRv[0] = i2;
                        this.uRv[1] = i3;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean z(int[] iArr) {
        return (!mHasInit || iArr == null || iArr.length != 2 || iArr[0] == -1 || iArr[1] == -1) ? false : true;
    }

    private void dfe() {
        AppMethodBeat.i(26878);
        if (this.uRA != null) {
            this.uRA.deb();
        }
        AppMethodBeat.o(26878);
    }

    public final void dff() {
        AppMethodBeat.i(26879);
        if (mHasInit) {
            H(-1, -1, -1, -1);
            h(true, 0);
            dfj();
            dfh();
            AppMethodBeat.o(26879);
            return;
        }
        AppMethodBeat.o(26879);
    }

    public final void ab(boolean z, boolean z2) {
        AppMethodBeat.i(26880);
        if (mHasInit) {
            dfj();
            dfh();
            h(true, 50);
            oq(z);
            oo(z2);
            AppMethodBeat.o(26880);
            return;
        }
        AppMethodBeat.o(26880);
    }

    public final void h(final boolean z, long j) {
        AppMethodBeat.i(26881);
        if (!mHasInit || this.mHandler == null) {
            AppMethodBeat.o(26881);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26858);
                RecyclerView a = e.a(e.this);
                if (a == null) {
                    AppMethodBeat.o(26858);
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < a.getChildCount()) {
                        View childAt = a.getChildAt(i2);
                        c er = f.er(childAt);
                        if (er != null) {
                            if (er.uRc != null) {
                                if (z) {
                                    er.uRc.postInvalidate();
                                }
                            } else if (!(er.uRd == null || er.uRe == null)) {
                                e.this.a((LinearLayout) childAt.findViewById(R.id.dji), (LinearLayout) childAt.findViewById(R.id.dio), (LinearLayout) childAt.findViewById(R.id.djj), er.uRd.getPosInDataList());
                            }
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(26858);
                        return;
                    }
                }
            }
        }, j);
        AppMethodBeat.o(26881);
    }

    public final void a(View view, View view2, View view3, int i) {
        AppMethodBeat.i(26882);
        if (!mHasInit || view == null || view2 == null || view3 == null || this.uRB == null) {
            AppMethodBeat.o(26882);
            return;
        }
        switch (Kh(i)) {
            case 0:
                view.setVisibility(8);
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.o(26882);
                return;
            case 1:
                if (this.uRB.startOffset == this.uRB.uRf) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                }
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.o(26882);
                return;
            case 2:
                view.setVisibility(0);
                view2.setVisibility(0);
                view3.setVisibility(0);
                AppMethodBeat.o(26882);
                return;
            case 3:
                if (this.uRB.uRf != 0) {
                    view.setVisibility(0);
                    view2.setVisibility(0);
                    view3.setVisibility(4);
                    AppMethodBeat.o(26882);
                    return;
                }
                break;
            case 4:
                if (this.uRB.startOffset == 0) {
                    view.setVisibility(0);
                    view2.setVisibility(4);
                    view3.setVisibility(0);
                    AppMethodBeat.o(26882);
                    return;
                }
                view.setVisibility(8);
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.o(26882);
                return;
        }
        view.setVisibility(8);
        view2.setVisibility(4);
        view3.setVisibility(4);
        AppMethodBeat.o(26882);
    }

    public final boolean dfg() {
        AppMethodBeat.i(26883);
        if (this.uRz == null || !this.uRz.isShowing()) {
            AppMethodBeat.o(26883);
            return false;
        }
        AppMethodBeat.o(26883);
        return true;
    }

    public final void dfh() {
        AppMethodBeat.i(26884);
        if (this.uRz != null) {
            this.uRz.dismiss();
        }
        AppMethodBeat.o(26884);
    }

    public final void oo(final boolean z) {
        AppMethodBeat.i(26885);
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26863);
                e.this.op(z);
                AppMethodBeat.o(26863);
            }
        }, 50);
        AppMethodBeat.o(26885);
    }

    public final void op(boolean z) {
        AppMethodBeat.i(26886);
        if (!mHasInit || this.uRz == null) {
            AppMethodBeat.o(26886);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        int dfa = dfa();
        if (recyclerView == null || dfa == 0 || ((dfa == 1 && !z) || (this.uRC != null && this.uRC.getType() == 1))) {
            dfh();
            AppMethodBeat.o(26886);
        } else if (dfq()) {
            int height;
            int i = -1;
            int i2 = -1000;
            int o = o(recyclerView);
            int dfn = dfn();
            int i3 = 0;
            dfa = 0;
            if (!(this.uRz == null || this.uRz.getContentView() == null)) {
                this.uRz.getContentView().measure(0, 0);
                i3 = (this.uRl * 2) + this.uRz.getContentView().getMeasuredHeight();
                dfa = this.uRz.getContentView().getMeasuredWidth() + (this.uRl * 2);
            }
            int i4 = i3 == 0 ? this.uRn : i3;
            if (dfa == 0) {
                i3 = this.uRo;
            } else {
                i3 = dfa;
            }
            int i5;
            if (this.uRw != null && this.uRw.isShowing() && z(this.uRt)) {
                i5 = this.uRt[1] - i4;
                height = (this.uRt[1] + this.uRw.getHeight()) - this.uRp;
                if (i5 < o || i5 > dfn) {
                    if (height >= o && height <= dfn) {
                        dfa = this.uRt[0];
                    }
                    dfa = i2;
                    height = i;
                } else {
                    dfa = this.uRt[0];
                    height = i5;
                }
            } else {
                if (this.uRx != null && this.uRx.isShowing() && z(this.uRu)) {
                    dfa = this.uRu[1] - i4;
                    height = (this.uRu[1] + this.uRx.getHeight()) - this.uRp;
                    if (dfa >= o && dfa <= dfn) {
                        i2 = this.uRu[0];
                        i = dfa;
                    } else if (height >= o && height <= dfn) {
                        i2 = this.uRu[0];
                        i = height;
                    }
                }
                if (this.uRy != null && this.uRy.isShowing() && z(this.uRv)) {
                    height = this.uRv[1] - i4;
                    i5 = (this.uRv[1] + this.uRy.getHeight()) - this.uRp;
                    if (i == -1) {
                        if (height >= o && height <= dfn) {
                            dfa = this.uRv[0];
                        } else if (i5 >= o && i5 <= dfn) {
                            dfa = this.uRv[0];
                            height = i5;
                        }
                    } else if (i + i4 > this.uRv[1] && i5 >= o && i5 <= dfn) {
                        dfa = this.uRv[0];
                        height = i5;
                    }
                }
                dfa = i2;
                height = i;
            }
            if (height == -1) {
                i layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    i = linearLayoutManager.iQ();
                    dfa = linearLayoutManager.iS();
                    if (this.uRB.coc <= i && this.uRB.endPos >= dfa) {
                        height = 300;
                        dfa = -1000;
                    }
                }
                dfa = -1000;
            }
            if (height == -1) {
                dfh();
                AppMethodBeat.o(26886);
                return;
            }
            i2 = this.mScreenWidth / 3;
            i = (this.mScreenWidth * 2) / 3;
            if (dfa == -1000 || (dfa >= i2 && dfa <= i)) {
                i(recyclerView, (this.mScreenWidth - i3) / 2, height);
                AppMethodBeat.o(26886);
            } else if (dfa < i2) {
                i(recyclerView, this.uRm, height);
                AppMethodBeat.o(26886);
            } else {
                i(recyclerView, (this.mScreenWidth - i3) - this.uRm, height);
                AppMethodBeat.o(26886);
            }
        } else {
            dfh();
            AppMethodBeat.o(26886);
        }
    }

    public final boolean dfi() {
        AppMethodBeat.i(26887);
        if (this.uRw == null || !this.uRw.isShowing()) {
            AppMethodBeat.o(26887);
            return false;
        }
        AppMethodBeat.o(26887);
        return true;
    }

    public final void dfj() {
        AppMethodBeat.i(26888);
        if (mHasInit) {
            Ki(2);
            Ki(3);
            Ki(4);
            AppMethodBeat.o(26888);
            return;
        }
        AppMethodBeat.o(26888);
    }

    private boolean Ki(int i) {
        boolean z = true;
        AppMethodBeat.i(26889);
        if (this.uRC != null && this.uRC.klY == i && this.uRC.getType() == 1) {
            AppMethodBeat.o(26889);
            return false;
        }
        if (i == 2 && this.uRw != null) {
            this.uRw.dismiss();
            aq(2, -1, -1);
        } else if (i == 3 && this.uRx != null) {
            this.uRx.dismiss();
            aq(3, -1, -1);
        } else if (i != 4 || this.uRy == null) {
            z = false;
        } else {
            this.uRy.dismiss();
            aq(4, -1, -1);
        }
        AppMethodBeat.o(26889);
        return z;
    }

    public final void oq(boolean z) {
        AppMethodBeat.i(26890);
        if (mHasInit) {
            RecyclerView recyclerView = getRecyclerView();
            int dfa = dfa();
            if (recyclerView == null || dfa == 0 || (dfa == 1 && !z)) {
                dfj();
                AppMethodBeat.o(26890);
                return;
            }
            View f = f.f(recyclerView, this.uRB.coc);
            View f2 = f.f(recyclerView, this.uRB.endPos);
            if (dfa == 1) {
                Ki(3);
                Ki(4);
                a(2, recyclerView, f, this.uRB.startOffset);
                AppMethodBeat.o(26890);
                return;
            }
            Ki(2);
            a(3, recyclerView, f, this.uRB.startOffset);
            a(4, recyclerView, f2, this.uRB.uRf);
            AppMethodBeat.o(26890);
            return;
        }
        AppMethodBeat.o(26890);
    }

    private void a(int i, RecyclerView recyclerView, View view, int i2) {
        AppMethodBeat.i(26891);
        if (!mHasInit || recyclerView == null) {
            AppMethodBeat.o(26891);
            return;
        }
        c er = f.er(view);
        if (er == null) {
            Ki(i);
            AppMethodBeat.o(26891);
            return;
        }
        WXRTEditText wXRTEditText;
        if (er.uRc != null) {
            wXRTEditText = er.uRc;
        } else {
            if (!(er.uRd == null || er.uRe == null)) {
                if (i2 == 0) {
                    i2 = 0;
                    wXRTEditText = er.uRd;
                } else if (i2 == 1) {
                    i2 = 0;
                    wXRTEditText = er.uRe;
                }
            }
            wXRTEditText = null;
        }
        if (wXRTEditText == null) {
            Ki(i);
            AppMethodBeat.o(26891);
            return;
        }
        Editable text = wXRTEditText.getText();
        if (text == null || i2 < 0 || i2 > text.length()) {
            Ki(i);
            AppMethodBeat.o(26891);
            return;
        }
        Layout layout = wXRTEditText.getLayout();
        if (layout == null) {
            Ki(i);
            AppMethodBeat.o(26891);
            return;
        }
        boolean a;
        float primaryHorizontal = layout.getPrimaryHorizontal(i2) + ((float) wXRTEditText.getPaddingLeft());
        float lineTop = (float) (layout.getLineTop(layout.getLineForOffset(i2)) + wXRTEditText.getPaddingTop());
        if (wXRTEditText.getEditTextType() != 0) {
            lineTop = (lineTop + ((float) wXRTEditText.getHeight())) - ((float) this.uRi);
            if (i == 3) {
                primaryHorizontal += (float) this.uRr;
            } else if (i == 4) {
                primaryHorizontal -= (float) this.uRr;
            }
        }
        int[] iArr = new int[2];
        wXRTEditText.getLocationOnScreen(iArr);
        switch (i) {
            case 2:
                a = a(2, recyclerView, this.uRw, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.uRq)), (int) (((float) iArr[1]) + lineTop));
                break;
            case 3:
                a = a(3, recyclerView, this.uRx, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.uRx.getWidth())), (int) (((float) iArr[1]) + lineTop));
                break;
            case 4:
                a = a(4, recyclerView, this.uRy, (int) (primaryHorizontal + ((float) iArr[0])), (int) (((float) iArr[1]) + lineTop));
                break;
            default:
                a = false;
                break;
        }
        if (!a) {
            Ki(i);
        }
        AppMethodBeat.o(26891);
    }

    private boolean a(int i, RecyclerView recyclerView, PopupWindow popupWindow, int i2, int i3) {
        AppMethodBeat.i(26892);
        if (!mHasInit || recyclerView == null || popupWindow == null) {
            AppMethodBeat.o(26892);
            return false;
        } else if (i3 < o(recyclerView) || i3 > this.mScreenHeight - dfc()) {
            AppMethodBeat.o(26892);
            return false;
        } else {
            if (popupWindow.isShowing()) {
                popupWindow.update(i2, i3, -1, -1, false);
                aq(i, i2, i3);
            } else {
                popupWindow.showAtLocation(recyclerView, 0, i2, i3);
                aq(i, i2, i3);
            }
            if (i == 2) {
                dfk();
                this.uRE.ae(3000, 0);
            }
            AppMethodBeat.o(26892);
            return true;
        }
    }

    private void dfk() {
        AppMethodBeat.i(26893);
        if (this.uRE == null) {
            this.uRE = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(26864);
                    if (e.this.dfa() == 1 && e.b(e.this)) {
                        e.this.dfh();
                    }
                    AppMethodBeat.o(26864);
                    return true;
                }
            }, false);
            AppMethodBeat.o(26893);
            return;
        }
        this.uRE.stopTimer();
        AppMethodBeat.o(26893);
    }

    private boolean i(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(26894);
        if (!mHasInit || recyclerView == null || this.uRz == null) {
            AppMethodBeat.o(26894);
            return false;
        } else if (i2 < o(recyclerView) || i2 > this.mScreenHeight - dfc()) {
            AppMethodBeat.o(26894);
            return false;
        } else {
            if (this.uRz.isShowing()) {
                this.uRz.update(i, i2, -1, -1, false);
            } else {
                this.uRz.showAtLocation(recyclerView, 0, i, i2);
            }
            AppMethodBeat.o(26894);
            return true;
        }
    }

    public final void a(int i, MotionEvent motionEvent) {
        AppMethodBeat.i(26895);
        if (!mHasInit || this.mHandler == null) {
            AppMethodBeat.o(26895);
        } else if (this.uRC == null || this.uRC.getType() != 1 || this.uRC.klY == i) {
            switch (motionEvent.getAction()) {
                case 0:
                    dfl();
                    if (!dfg()) {
                        op(true);
                    }
                    this.uRC.a(i, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), 0);
                    AppMethodBeat.o(26895);
                    return;
                case 1:
                case 3:
                    dfl();
                    this.mHandler.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(26865);
                            e.this.oq(true);
                            e.this.op(true);
                            AppMethodBeat.o(26865);
                        }
                    }, 200);
                    break;
                case 2:
                    if (this.uRC != null && this.uRC.getType() == 1) {
                        this.uRC.uQU = motionEvent.getRawX();
                        this.uRC.uQV = motionEvent.getRawY();
                        or(true);
                        AppMethodBeat.o(26895);
                        return;
                    }
            }
            AppMethodBeat.o(26895);
        } else {
            AppMethodBeat.o(26895);
        }
    }

    private void or(boolean z) {
        AppMethodBeat.i(26896);
        if (!mHasInit || this.uRw == null || this.uRx == null || this.uRy == null || this.uRB == null) {
            AppMethodBeat.o(26896);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            AppMethodBeat.o(26896);
        } else if (this.uRC == null || this.uRC.getType() != 1) {
            AppMethodBeat.o(26896);
        } else {
            int i = this.uRC.klY;
            if (i == 2 || i == 3 || i == 4) {
                int i2;
                float f = this.uRC.uQU - this.uRC.hke;
                float f2 = ((float) (this.uRi / 2)) + (this.uRC.uQV - this.uRC.hkf);
                if (i == 2) {
                    f += (float) (this.uRw.getWidth() / 2);
                } else if (i == 3) {
                    f += (float) this.uRx.getWidth();
                }
                recyclerView.getLocationOnScreen(this.uRs);
                View x = recyclerView.x(f - ((float) this.uRs[0]), f2 - ((float) this.uRs[1]));
                c er = f.er(x);
                WXRTEditText wXRTEditText = null;
                if (er == null) {
                    i2 = 2;
                } else if (er.uRc != null) {
                    wXRTEditText = er.uRc;
                    int[] iArr = new int[2];
                    wXRTEditText.getLocationOnScreen(iArr);
                    i2 = ar(i, wXRTEditText.getPosInDataList(), wXRTEditText.getOffsetForPosition(f - ((float) iArr[0]), f2 - ((float) iArr[1])));
                } else if (er.uRd == null || er.uRe == null) {
                    i2 = 0;
                } else {
                    WXRTEditText wXRTEditText2;
                    int ar;
                    if (i == 3) {
                        wXRTEditText2 = er.uRd;
                        ar = ar(i, wXRTEditText2.getPosInDataList(), 0);
                        if (ar == 2 || ar == 3) {
                            a(i, recyclerView, this.uRx, (int) (this.uRC.uQU - this.uRC.hke), (int) (this.uRC.uQV - this.uRC.hkf));
                            i2 = ar;
                            wXRTEditText = wXRTEditText2;
                        }
                    } else if (i == 4) {
                        wXRTEditText2 = er.uRe;
                        ar = ar(i, wXRTEditText2.getPosInDataList(), 1);
                        if (ar == 2 || ar == 3) {
                            a(i, recyclerView, this.uRy, (int) (this.uRC.uQU - this.uRC.hke), (int) (this.uRC.uQV - this.uRC.hkf));
                            i2 = ar;
                            wXRTEditText = wXRTEditText2;
                        }
                    } else {
                        int[] iArr2 = new int[2];
                        x.getLocationOnScreen(iArr2);
                        if (f <= ((float) (iArr2[0] + (x.getWidth() / 2)))) {
                            wXRTEditText2 = er.uRd;
                            ar = ar(i, wXRTEditText2.getPosInDataList(), 0);
                        } else {
                            wXRTEditText2 = er.uRe;
                            ar = ar(i, wXRTEditText2.getPosInDataList(), 1);
                        }
                        if (ar == 2 || ar == 3) {
                            a(i, recyclerView, this.uRw, (int) (this.uRC.uQU - this.uRC.hke), (int) (this.uRC.uQV - this.uRC.hkf));
                        }
                    }
                    i2 = ar;
                    wXRTEditText = wXRTEditText2;
                }
                switch (i2) {
                    case 1:
                        i2 = 0;
                        break;
                    case 2:
                        i2 = 1;
                        break;
                    case 3:
                        Editable text = wXRTEditText.getText();
                        int dfa = dfa();
                        if (this.uRh && text != null && dfa == 1) {
                            if (!wXRTEditText.hasFocus()) {
                                wXRTEditText.requestFocus();
                            }
                            if (wXRTEditText.getEditTextType() == 1 || wXRTEditText.getEditTextType() == 2) {
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText.setSelection(0);
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                            } else if (this.uRB.startOffset <= text.length()) {
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText.setSelection(this.uRB.startOffset);
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                            }
                        } else if (this.uRh && text != null && dfa == 2 && wXRTEditText.hasFocus()) {
                            if (wXRTEditText.getEditTextType() == 1 || wXRTEditText.getEditTextType() == 2) {
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText.setSelection(0);
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                            } else if (this.uRB.startOffset <= text.length() && this.uRB.uRf <= text.length()) {
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText.setSelection(this.uRB.startOffset, this.uRB.uRf);
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                            }
                        }
                        if (dfa == 3 || dfa == 0) {
                            dfe();
                        }
                        dfh();
                        h(true, 0);
                        if (i == 4) {
                            i2 = this.uRB.uRf;
                        } else {
                            i2 = this.uRB.startOffset;
                        }
                        a(i, recyclerView, x, i2);
                        i2 = 1;
                        break;
                    default:
                        AppMethodBeat.o(26896);
                        return;
                }
                if (i2 == 0) {
                    dfm();
                } else if (z && ((this.uRC.uQV < ((float) o(recyclerView)) || this.uRC.uQV > ((float) dfn())) && (this.uRD == null || this.uRD.doT()))) {
                    dfm();
                    this.uRD.ae(100, 100);
                    AppMethodBeat.o(26896);
                    return;
                }
                AppMethodBeat.o(26896);
                return;
            }
            AppMethodBeat.o(26896);
        }
    }

    private int ar(int i, int i2, int i3) {
        AppMethodBeat.i(26897);
        if (mHasInit) {
            boolean H;
            switch (i) {
                case 2:
                    H = H(i2, i3, i2, i3);
                    break;
                case 3:
                    if (this.uRB != null && i2 <= this.uRB.endPos && (i2 != this.uRB.endPos || i3 < this.uRB.uRf)) {
                        H = H(i2, i3, this.uRB.endPos, this.uRB.uRf);
                        break;
                    }
                    AppMethodBeat.o(26897);
                    return 1;
                    break;
                case 4:
                    if (this.uRB != null && i2 >= this.uRB.coc && (i2 != this.uRB.coc || i3 > this.uRB.startOffset)) {
                        H = H(this.uRB.coc, this.uRB.startOffset, i2, i3);
                        break;
                    }
                    AppMethodBeat.o(26897);
                    return 1;
                default:
                    AppMethodBeat.o(26897);
                    return 0;
            }
            if (H) {
                AppMethodBeat.o(26897);
                return 3;
            }
            AppMethodBeat.o(26897);
            return 2;
        }
        AppMethodBeat.o(26897);
        return 0;
    }

    private void dfl() {
        AppMethodBeat.i(26898);
        if (this.uRC == null) {
            this.uRC = new b();
            AppMethodBeat.o(26898);
            return;
        }
        this.uRC.reset();
        AppMethodBeat.o(26898);
    }

    private void dfm() {
        AppMethodBeat.i(26899);
        if (this.uRD == null) {
            this.uRD = new ap(new ap.a() {
                public final boolean BI() {
                    int i;
                    AppMethodBeat.i(26866);
                    ab.d("NoteSelectManager", "onTimerExpired: ");
                    RecyclerView a = e.a(e.this);
                    int i2 = (e.this.uRC == null || e.this.uRC.uQV >= ((float) e.a(e.this, a))) ? 0 : 1;
                    if (e.this.uRC == null || e.this.uRC.uQV <= ((float) e.d(e.this))) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (!e.mHasInit || a == null || e.this.uRC == null || e.this.uRC.getType() != 1 || (i2 == 0 && i == 0)) {
                        if (e.this.uRD != null) {
                            e.this.uRD.stopTimer();
                        }
                    } else if (i2 != 0 && a.canScrollVertically(-1)) {
                        if (e.this.uRC.klY == 3) {
                            e.e(e.this);
                        }
                        e.f(e.this);
                        e.this.dfj();
                        e.this.dfh();
                        a.a(0, -300, null);
                    } else if (i != 0 && a.canScrollVertically(1)) {
                        e.f(e.this);
                        e.this.dfj();
                        e.this.dfh();
                        a.a(0, 300, null);
                    }
                    AppMethodBeat.o(26866);
                    return true;
                }
            }, true);
            AppMethodBeat.o(26899);
            return;
        }
        this.uRD.stopTimer();
        AppMethodBeat.o(26899);
    }

    private int o(RecyclerView recyclerView) {
        AppMethodBeat.i(26900);
        int i = 150;
        if (recyclerView != null) {
            recyclerView.getLocationOnScreen(this.uRs);
            if (z(this.uRs)) {
                i = this.uRs[1];
            }
        }
        AppMethodBeat.o(26900);
        return i;
    }

    private int dfn() {
        AppMethodBeat.i(26901);
        int i = 0;
        if (this.uRA != null) {
            i = this.uRA.dec();
        }
        if (i == 0 && this.uRA != null) {
            i = this.uRA.ded();
        }
        if (i == 0) {
            i = 150;
        }
        i = this.mScreenHeight - i;
        AppMethodBeat.o(26901);
        return i;
    }

    public static void g(TextView textView, int i) {
        AppMethodBeat.i(26902);
        if (textView != null) {
            textView.setTextSize(1, (float) i);
        }
        AppMethodBeat.o(26902);
    }

    private void dfo() {
        AppMethodBeat.i(26903);
        if (this.uRA != null) {
            this.uRA.dea();
        }
        AppMethodBeat.o(26903);
    }

    public final void dfp() {
        AppMethodBeat.i(26904);
        ab.i("NoteSelectManager", "deleteSelectedData");
        if (mHasInit) {
            dfh();
            int dfa = dfa();
            if (dfa == 2) {
                a(true, null, "");
                AppMethodBeat.o(26904);
                return;
            } else if (dfa == 3) {
                b(true, null, "");
                AppMethodBeat.o(26904);
                return;
            } else {
                ab.e("NoteSelectManager", "deleteSelectedData: not in select");
                dfo();
                AppMethodBeat.o(26904);
                return;
            }
        }
        ab.e("NoteSelectManager", "deleteSelectedData: not init");
        AppMethodBeat.o(26904);
    }

    private SpannableStringBuilder a(boolean z, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList, String str) {
        int i = 2;
        AppMethodBeat.i(26905);
        d dfd = dfd();
        dff();
        int dfa = dfd.dfa();
        if (dfa == 1 || dfa == 2) {
            com.tencent.mm.plugin.wenote.model.a.c Ke = c.dem().Ke(dfd.coc);
            if (Ke == null) {
                ab.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
                AppMethodBeat.o(26905);
                return null;
            }
            SpannableStringBuilder spannableStringBuilder;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (Ke.getType() != 1) {
                if (dfa == 1 && z) {
                    ArrayList arrayList2;
                    if (dfd.startOffset == 0) {
                        i = 1;
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList22 = arrayList;
                    } else if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(26905);
                        return spannableStringBuilder2;
                    } else {
                        arrayList22 = new ArrayList();
                        com.tencent.mm.plugin.wenote.model.a.i iVar = new com.tencent.mm.plugin.wenote.model.a.i();
                        iVar.content = str;
                        iVar.uNT = false;
                        iVar.uNV = -1;
                        arrayList22.add(iVar);
                    }
                    c.dem().a(arrayList22, i, dfd.coc, dfd.startOffset, dfd.uRf);
                    c.dem().gG(dfd.coc - 1, (arrayList22.size() + dfd.coc) + 1);
                }
                spannableStringBuilder = spannableStringBuilder2;
            } else if (!z || arrayList == null || arrayList.size() <= 0) {
                spannableStringBuilder = a((com.tencent.mm.plugin.wenote.model.a.i) Ke, dfd.startOffset, dfd.uRf, false, z, str, true);
                if (this.uRA != null) {
                    this.uRA.JX(dfd.coc);
                }
                if (z) {
                    c.dem().dew();
                }
            } else {
                spannableStringBuilder = a((com.tencent.mm.plugin.wenote.model.a.i) Ke, dfd.startOffset, dfd.uRf, false, false, "", true);
                c.dem().a((ArrayList) arrayList, 0, dfd.coc, dfd.startOffset, dfd.uRf);
                c.dem().gG(dfd.coc, (dfd.coc + arrayList.size()) + 1);
            }
            AppMethodBeat.o(26905);
            return spannableStringBuilder;
        }
        ab.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
        AppMethodBeat.o(26905);
        return null;
    }

    private ArrayList<com.tencent.mm.plugin.wenote.model.a.c> b(boolean z, ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList, String str) {
        AppMethodBeat.i(26906);
        d dfd = dfd();
        dff();
        ArrayList<com.tencent.mm.plugin.wenote.model.a.c> arrayList2 = new ArrayList();
        if (dfd.dfa() != 3) {
            ab.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
            AppMethodBeat.o(26906);
            return null;
        }
        int i;
        int i2 = dfd.coc;
        int i3 = dfd.endPos;
        while (true) {
            int i4 = i3;
            i = i2;
            if (i4 < dfd.coc) {
                break;
            }
            com.tencent.mm.plugin.wenote.model.a.c Ke = c.dem().Ke(i4);
            if (Ke != null) {
                com.tencent.mm.plugin.wenote.model.a.i iVar;
                SpannableStringBuilder a;
                com.tencent.mm.plugin.wenote.model.a.i iVar2;
                if (i4 == dfd.endPos && Ke.getType() == 1) {
                    iVar = (com.tencent.mm.plugin.wenote.model.a.i) Ke;
                    a = a(iVar, 0, dfd.uRf, false, z, "", false);
                    if (!bo.ac(a)) {
                        iVar2 = new com.tencent.mm.plugin.wenote.model.a.i();
                        iVar2.content = b.a(a);
                        iVar2.uNV = -1;
                        iVar2.uNT = false;
                        arrayList2.add(iVar2);
                    }
                    if (z && bo.isNullOrNil(iVar.content)) {
                        c.dem().au(i4, true);
                    }
                } else if (i4 == dfd.coc && Ke.getType() == 1) {
                    iVar = (com.tencent.mm.plugin.wenote.model.a.i) Ke;
                    a = a(iVar, dfd.startOffset, 0, true, z, "", false);
                    if (!bo.ac(a)) {
                        iVar2 = new com.tencent.mm.plugin.wenote.model.a.i();
                        iVar2.content = b.a(a);
                        iVar2.uNV = -1;
                        iVar2.uNT = false;
                        arrayList2.add(iVar2);
                    }
                    if (z && bo.isNullOrNil(iVar.content)) {
                        c.dem().au(i4, true);
                    } else {
                        i++;
                    }
                } else {
                    arrayList2.add(com.tencent.mm.plugin.wenote.b.c.c(Ke));
                    if (z) {
                        c.dem().au(i4, true);
                    }
                }
            }
            i2 = i;
            i3 = i4 - 1;
        }
        if (z) {
            i2 = i - 1;
            i3 = i + 1;
            if (arrayList == null || arrayList.size() <= 0) {
                com.tencent.mm.plugin.wenote.model.a.c iVar3 = new com.tencent.mm.plugin.wenote.model.a.i();
                if (str == null) {
                    str = "";
                }
                iVar3.content = str;
                iVar3.uNT = false;
                iVar3.uNV = -1;
                c.dem().a(i, iVar3);
            } else {
                c.dem().d(i, arrayList);
                i3 = arrayList.size() + i;
            }
            c.dem().gG(i2, i3);
        }
        Collections.reverse(arrayList2);
        AppMethodBeat.o(26906);
        return arrayList2;
    }

    private static SpannableStringBuilder a(com.tencent.mm.plugin.wenote.model.a.i iVar, int i, int i2, boolean z, boolean z2, String str, boolean z3) {
        SpannableStringBuilder spannableStringBuilder = null;
        AppMethodBeat.i(26907);
        if (iVar == null) {
            ab.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
            AppMethodBeat.o(26907);
        } else {
            Spanned ahb = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ahb(iVar.content);
            if (ahb == null) {
                ab.e("NoteSelectManager", "processTextDataItem: spannedText is null");
                AppMethodBeat.o(26907);
            } else {
                int length;
                if (z) {
                    length = ahb.length();
                } else {
                    length = i2;
                }
                if (str == null) {
                    str = "";
                }
                if (i < 0 || i > ahb.length() || length < 0 || length > ahb.length() || i > length) {
                    ab.e("NoteSelectManager", "processTextDataItem: incorrect offset");
                    AppMethodBeat.o(26907);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) ahb.subSequence(0, i);
                    spannableStringBuilder = (SpannableStringBuilder) ahb.subSequence(i, length);
                    SpannableStringBuilder spannableStringBuilder3 = (SpannableStringBuilder) ahb.subSequence(length, ahb.length());
                    if (z2) {
                        length = spannableStringBuilder2.length();
                        if (!bo.isNullOrNil(str)) {
                            Spanned ahb2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ahb(str);
                            if (ahb2 != null) {
                                length += ahb2.length();
                            }
                        }
                        iVar.content = b.a(spannableStringBuilder2) + str + b.a(spannableStringBuilder3);
                    }
                    if (z3) {
                        iVar.uNT = true;
                        iVar.uNV = length;
                    } else {
                        iVar.uNT = false;
                        iVar.uNV = -1;
                    }
                    AppMethodBeat.o(26907);
                }
            }
        }
        return spannableStringBuilder;
    }

    private boolean dfq() {
        AppMethodBeat.i(26908);
        boolean t = t(this.uRF, false);
        boolean t2 = t(this.uRG, false);
        boolean t3 = t(this.uRH, dfr());
        boolean t4 = t(this.uRI, dfs());
        boolean t5 = t(this.uRJ, dft());
        boolean t6 = t(this.uRK, dfu());
        boolean t7 = t(this.uRL, dfv());
        boolean t8 = t(this.uRM, dfw());
        if (t || t2 || t3 || t4 || t5 || t6 || t7 || t8) {
            AppMethodBeat.o(26908);
            return true;
        }
        AppMethodBeat.o(26908);
        return false;
    }

    private static boolean t(View view, boolean z) {
        AppMethodBeat.i(26909);
        if (view == null) {
            AppMethodBeat.o(26909);
            return false;
        } else if (z) {
            view.setVisibility(0);
            AppMethodBeat.o(26909);
            return true;
        } else {
            view.setVisibility(8);
            AppMethodBeat.o(26909);
            return false;
        }
    }

    private boolean dfr() {
        AppMethodBeat.i(26910);
        if (dfa() != 1) {
            AppMethodBeat.o(26910);
            return false;
        }
        com.tencent.mm.plugin.wenote.model.a.c Ke = c.dem().Ke(this.uRB.coc);
        if (Ke == null || (c.dem().size() <= 1 && Ke.getType() == 1 && bo.isNullOrNil(((com.tencent.mm.plugin.wenote.model.a.i) Ke).content))) {
            AppMethodBeat.o(26910);
            return false;
        }
        AppMethodBeat.o(26910);
        return true;
    }

    private boolean dfs() {
        AppMethodBeat.i(26911);
        int dex = c.dem().dex();
        int dey = c.dem().dey();
        com.tencent.mm.plugin.wenote.model.a.c Ke = c.dem().Ke(dex);
        com.tencent.mm.plugin.wenote.model.a.c Ke2 = c.dem().Ke(dey);
        if (Ke == null || Ke2 == null) {
            AppMethodBeat.o(26911);
            return false;
        }
        if (this.uRB != null && this.uRB.coc == dex && this.uRB.startOffset == 0 && this.uRB.endPos == dey) {
            if (Ke2.getType() == 1) {
                Spanned ahb = com.tencent.mm.plugin.wenote.model.nativenote.a.a.ahb(((com.tencent.mm.plugin.wenote.model.a.i) Ke2).content);
                if (ahb == null) {
                    AppMethodBeat.o(26911);
                    return false;
                } else if (this.uRB.uRf == ahb.length()) {
                    AppMethodBeat.o(26911);
                    return false;
                }
            } else if (Ke2.getType() != 1 && this.uRB.uRf == 1) {
                AppMethodBeat.o(26911);
                return false;
            }
        }
        AppMethodBeat.o(26911);
        return true;
    }

    private boolean dft() {
        boolean z = true;
        AppMethodBeat.i(26912);
        if (this.uRh) {
            int dfa = dfa();
            if (dfa == 0 || dfa == 1) {
                AppMethodBeat.o(26912);
                return false;
            }
            if (this.uRA != null && this.uRA.dee()) {
                z = false;
            }
            AppMethodBeat.o(26912);
            return z;
        }
        AppMethodBeat.o(26912);
        return false;
    }

    private boolean dfu() {
        AppMethodBeat.i(26913);
        int dfa = dfa();
        if (this.uRh && (dfa == 2 || dfa == 3)) {
            AppMethodBeat.o(26913);
            return true;
        }
        AppMethodBeat.o(26913);
        return false;
    }

    private boolean dfv() {
        AppMethodBeat.i(26914);
        int dfa = dfa();
        if (dfa == 2 || dfa == 3) {
            AppMethodBeat.o(26914);
            return true;
        }
        AppMethodBeat.o(26914);
        return false;
    }

    private boolean dfw() {
        AppMethodBeat.i(26915);
        if (!this.uRh || dfa() == 0) {
            AppMethodBeat.o(26915);
            return false;
        }
        ah.getContext();
        if (f.deC() != 1) {
            AppMethodBeat.o(26915);
            return true;
        }
        AppMethodBeat.o(26915);
        return false;
    }

    static /* synthetic */ void j(e eVar) {
        AppMethodBeat.i(26923);
        eVar.h(true, 300);
        AppMethodBeat.o(26923);
    }

    static /* synthetic */ boolean l(e eVar) {
        AppMethodBeat.i(26924);
        if (eVar.dfa() == 3) {
            int i = eVar.uRB.coc;
            while (true) {
                int i2 = i;
                if (i2 > eVar.uRB.endPos) {
                    break;
                }
                com.tencent.mm.plugin.wenote.model.a.c Ke = c.dem().Ke(i2);
                if (Ke != null && Ke.getType() == 4 && ((l) Ke).uOh.booleanValue()) {
                    AppMethodBeat.o(26924);
                    return true;
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(26924);
        return false;
    }
}
