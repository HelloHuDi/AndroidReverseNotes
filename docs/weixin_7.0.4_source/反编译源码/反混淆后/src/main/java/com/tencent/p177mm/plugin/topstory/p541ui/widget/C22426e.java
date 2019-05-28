package com.tencent.p177mm.plugin.topstory.p541ui.widget;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.topstory.ui.widget.e */
public final class C22426e extends PopupWindow {
    private Activity activity;
    C46313d sIe;
    private int sIf;
    private int sIg;
    private View sIh;
    View sIi;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.e$1 */
    class C224271 implements OnGlobalLayoutListener {
        C224271() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(2235);
            if (C22426e.this.sIh != null) {
                C22426e.m34117b(C22426e.this);
            }
            AppMethodBeat.m2505o(2235);
        }
    }

    public C22426e(Activity activity) {
        super(activity);
        AppMethodBeat.m2504i(2236);
        this.activity = activity;
        this.sIh = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(2130969912, null, false);
        setContentView(this.sIh);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.sIi = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.sIh.getViewTreeObserver().addOnGlobalLayoutListener(new C224271());
        AppMethodBeat.m2505o(2236);
    }

    public final void close() {
        AppMethodBeat.m2504i(2237);
        this.sIe = null;
        dismiss();
        AppMethodBeat.m2505o(2237);
    }

    /* renamed from: fV */
    private void m34118fV(int i, int i2) {
        AppMethodBeat.m2504i(2238);
        if (this.sIe != null) {
            this.sIe.mo69380fU(i, i2);
        }
        AppMethodBeat.m2505o(2238);
    }

    /* renamed from: b */
    static /* synthetic */ void m34117b(C22426e c22426e) {
        AppMethodBeat.m2504i(2239);
        Point point = new Point();
        c22426e.activity.getWindowManager().getDefaultDisplay().getRealSize(point);
        Rect rect = new Rect();
        c22426e.sIh.getWindowVisibleDisplayFrame(rect);
        int i = c22426e.activity.getResources().getConfiguration().orientation;
        int i2 = point.y - rect.bottom;
        if (i2 == 0) {
            c22426e.m34118fV(0, i);
            AppMethodBeat.m2505o(2239);
        } else if (i == 1) {
            c22426e.sIg = i2;
            c22426e.m34118fV(c22426e.sIg, i);
            AppMethodBeat.m2505o(2239);
        } else {
            c22426e.sIf = i2;
            c22426e.m34118fV(c22426e.sIf, i);
            AppMethodBeat.m2505o(2239);
        }
    }
}
