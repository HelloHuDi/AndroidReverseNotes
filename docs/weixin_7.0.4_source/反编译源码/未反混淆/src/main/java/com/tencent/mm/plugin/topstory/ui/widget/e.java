package com.tencent.mm.plugin.topstory.ui.widget;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class e extends PopupWindow {
    private Activity activity;
    d sIe;
    private int sIf;
    private int sIg;
    private View sIh;
    View sIi;

    public e(Activity activity) {
        super(activity);
        AppMethodBeat.i(2236);
        this.activity = activity;
        this.sIh = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.a9a, null, false);
        setContentView(this.sIh);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.sIi = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.sIh.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(2235);
                if (e.this.sIh != null) {
                    e.b(e.this);
                }
                AppMethodBeat.o(2235);
            }
        });
        AppMethodBeat.o(2236);
    }

    public final void close() {
        AppMethodBeat.i(2237);
        this.sIe = null;
        dismiss();
        AppMethodBeat.o(2237);
    }

    private void fV(int i, int i2) {
        AppMethodBeat.i(2238);
        if (this.sIe != null) {
            this.sIe.fU(i, i2);
        }
        AppMethodBeat.o(2238);
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(2239);
        Point point = new Point();
        eVar.activity.getWindowManager().getDefaultDisplay().getRealSize(point);
        Rect rect = new Rect();
        eVar.sIh.getWindowVisibleDisplayFrame(rect);
        int i = eVar.activity.getResources().getConfiguration().orientation;
        int i2 = point.y - rect.bottom;
        if (i2 == 0) {
            eVar.fV(0, i);
            AppMethodBeat.o(2239);
        } else if (i == 1) {
            eVar.sIg = i2;
            eVar.fV(eVar.sIg, i);
            AppMethodBeat.o(2239);
        } else {
            eVar.sIf = i2;
            eVar.fV(eVar.sIf, i);
            AppMethodBeat.o(2239);
        }
    }
}
