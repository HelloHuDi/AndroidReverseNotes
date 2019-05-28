package com.tencent.p177mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.Preference;

/* renamed from: com.tencent.mm.plugin.card.widget.CardTextPreference */
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
        AppMethodBeat.m2504i(88957);
        setLayoutResource(2130970127);
        this.mContext = context;
        AppMethodBeat.m2505o(88957);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(88958);
        super.onBindView(view);
        this.ksc = (TextView) view.findViewById(16908304);
        this.atH = (TextView) view.findViewById(16908310);
        beG();
        m65798fK(this.kse);
        AppMethodBeat.m2505o(88958);
    }

    /* renamed from: tp */
    public final void mo61655tp(int i) {
        AppMethodBeat.m2504i(88959);
        this.ksd = i;
        beG();
        AppMethodBeat.m2505o(88959);
    }

    private void beG() {
        AppMethodBeat.m2504i(88960);
        if (!(this.ksc == null || this.ksd == 0)) {
            this.ksc.setTextColor(this.ksd);
        }
        AppMethodBeat.m2505o(88960);
    }

    public final void beH() {
        AppMethodBeat.m2504i(88961);
        m65798fK(false);
        this.kse = false;
        AppMethodBeat.m2505o(88961);
    }

    /* renamed from: fK */
    private void m65798fK(boolean z) {
        AppMethodBeat.m2504i(88962);
        if (this.atH != null) {
            Rect dd = CardTextPreference.m65797dd(this.atH);
            this.atH.setSingleLine(z);
            if (!z) {
                dd.top = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9948l5);
                dd.bottom = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9948l5);
                CardTextPreference.m65799j(this.atH, dd);
            }
        }
        AppMethodBeat.m2505o(88962);
    }

    /* renamed from: dd */
    private static Rect m65797dd(View view) {
        AppMethodBeat.m2504i(88963);
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.m2505o(88963);
        return rect;
    }

    /* renamed from: j */
    private static void m65799j(View view, Rect rect) {
        AppMethodBeat.m2504i(88964);
        if (view == null || rect == null) {
            AppMethodBeat.m2505o(88964);
            return;
        }
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.m2505o(88964);
    }
}
