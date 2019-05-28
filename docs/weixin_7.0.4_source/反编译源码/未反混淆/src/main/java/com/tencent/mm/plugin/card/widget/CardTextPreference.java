package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference extends Preference {
    private TextView atH;
    private TextView ksc;
    private int ksd = 0;
    boolean kse = true;
    Context mContext;

    public CardTextPreference(Context context) {
        super(context, null);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(88957);
        setLayoutResource(R.layout.ae4);
        this.mContext = context;
        AppMethodBeat.o(88957);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(88958);
        super.onBindView(view);
        this.ksc = (TextView) view.findViewById(16908304);
        this.atH = (TextView) view.findViewById(16908310);
        beG();
        fK(this.kse);
        AppMethodBeat.o(88958);
    }

    public final void tp(int i) {
        AppMethodBeat.i(88959);
        this.ksd = i;
        beG();
        AppMethodBeat.o(88959);
    }

    private void beG() {
        AppMethodBeat.i(88960);
        if (!(this.ksc == null || this.ksd == 0)) {
            this.ksc.setTextColor(this.ksd);
        }
        AppMethodBeat.o(88960);
    }

    public final void beH() {
        AppMethodBeat.i(88961);
        fK(false);
        this.kse = false;
        AppMethodBeat.o(88961);
    }

    private void fK(boolean z) {
        AppMethodBeat.i(88962);
        if (this.atH != null) {
            Rect dd = dd(this.atH);
            this.atH.setSingleLine(z);
            if (!z) {
                dd.top = this.mContext.getResources().getDimensionPixelOffset(R.dimen.l5);
                dd.bottom = this.mContext.getResources().getDimensionPixelOffset(R.dimen.l5);
                j(this.atH, dd);
            }
        }
        AppMethodBeat.o(88962);
    }

    private static Rect dd(View view) {
        AppMethodBeat.i(88963);
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(88963);
        return rect;
    }

    private static void j(View view, Rect rect) {
        AppMethodBeat.i(88964);
        if (view == null || rect == null) {
            AppMethodBeat.o(88964);
            return;
        }
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(88964);
    }
}
