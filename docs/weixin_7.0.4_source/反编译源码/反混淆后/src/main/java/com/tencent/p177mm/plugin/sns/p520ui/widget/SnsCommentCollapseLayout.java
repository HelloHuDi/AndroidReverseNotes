package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout */
public class SnsCommentCollapseLayout extends RelativeLayout {
    private SnsComment2LinePreloadTextView rMS = null;
    private SnsCommentPreloadTextView rMT = null;
    private TextView rMU = null;
    private CharSequence rMV = null;
    private int rMW = 0;

    /* renamed from: com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout$1 */
    class C221491 implements OnTouchListener {
        C221491() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(40479);
            if (motionEvent.getAction() == 0) {
                view.setTag(2131820679, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
            }
            AppMethodBeat.m2505o(40479);
            return false;
        }
    }

    public SnsCommentCollapseLayout(Context context) {
        super(context);
        AppMethodBeat.m2504i(40481);
        init();
        AppMethodBeat.m2505o(40481);
    }

    public SnsCommentCollapseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(40482);
        init();
        AppMethodBeat.m2505o(40482);
    }

    public SnsCommentCollapseLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(40483);
        init();
        AppMethodBeat.m2505o(40483);
    }

    private void init() {
        AppMethodBeat.m2504i(40484);
        LayoutInflater.from(getContext()).inflate(2130970751, this, true);
        this.rMS = (SnsComment2LinePreloadTextView) findViewById(2131827700);
        this.rMT = (SnsCommentPreloadTextView) findViewById(2131827701);
        this.rMU = (TextView) findViewById(2131827702);
        this.rMW = C1338a.fromDPToPix(getContext(), 22);
        setOnTouchListener(new C221491());
        AppMethodBeat.m2505o(40484);
    }

    public void setOpClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(40485);
        this.rMU.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(40485);
    }

    public void setPressTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(40486);
        this.rMS.setOnTouchListener(onTouchListener);
        this.rMT.setOnTouchListener(onTouchListener);
        AppMethodBeat.m2505o(40486);
    }

    public void setTextSize(float f) {
        AppMethodBeat.m2504i(40487);
        this.rMS.setTextSize(f);
        this.rMT.setTextSize(f);
        AppMethodBeat.m2505o(40487);
    }

    public final void setTextSize$255e752(float f) {
        AppMethodBeat.m2504i(40488);
        this.rMS.setTextSize$255e752(f);
        this.rMT.setTextSize$255e752(f);
        this.rMU.setTextSize(1, f);
        AppMethodBeat.m2505o(40488);
    }

    public void setTextColor(int i) {
        AppMethodBeat.m2504i(40489);
        this.rMS.setTextColor(i);
        this.rMT.setTextColor(i);
        AppMethodBeat.m2505o(40489);
    }

    public void setGravity(int i) {
        AppMethodBeat.m2504i(40490);
        this.rMS.setGravity(i);
        this.rMT.setGravity(i);
        AppMethodBeat.m2505o(40490);
    }

    /* renamed from: k */
    public final void mo37715k(final CharSequence charSequence, final int i) {
        AppMethodBeat.m2504i(40491);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(40480);
                C4990ab.m7411d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", charSequence, Integer.valueOf(i));
                SnsCommentCollapseLayout.this.rMV = charSequence == null ? "" : charSequence;
                if (C39851d.m68264fF(i, 16)) {
                    SnsCommentCollapseLayout.m33769b(SnsCommentCollapseLayout.this);
                    AppMethodBeat.m2505o(40480);
                    return;
                }
                SnsCommentCollapseLayout.m33770c(SnsCommentCollapseLayout.this);
                AppMethodBeat.m2505o(40480);
            }
        });
        AppMethodBeat.m2505o(40491);
    }

    /* renamed from: b */
    static /* synthetic */ void m33769b(SnsCommentCollapseLayout snsCommentCollapseLayout) {
        AppMethodBeat.m2504i(40492);
        snsCommentCollapseLayout.rMU.setVisibility(0);
        snsCommentCollapseLayout.rMS.setLines(2);
        snsCommentCollapseLayout.rMS.getConfig().eOf = (snsCommentCollapseLayout.getMeasuredWidth() - snsCommentCollapseLayout.rMU.getMeasuredWidth()) - snsCommentCollapseLayout.rMW;
        snsCommentCollapseLayout.rMS.setText(snsCommentCollapseLayout.rMV);
        snsCommentCollapseLayout.rMS.setVisibility(0);
        snsCommentCollapseLayout.rMT.setVisibility(8);
        snsCommentCollapseLayout.invalidate();
        AppMethodBeat.m2505o(40492);
    }

    /* renamed from: c */
    static /* synthetic */ void m33770c(SnsCommentCollapseLayout snsCommentCollapseLayout) {
        AppMethodBeat.m2504i(40493);
        snsCommentCollapseLayout.rMU.setVisibility(4);
        snsCommentCollapseLayout.rMT.setText(snsCommentCollapseLayout.rMV);
        snsCommentCollapseLayout.rMT.setVisibility(0);
        snsCommentCollapseLayout.rMS.setVisibility(8);
        snsCommentCollapseLayout.invalidate();
        AppMethodBeat.m2505o(40493);
    }
}
