package com.tencent.mm.plugin.sns.ui.widget;

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
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.sdk.platformtools.ab;

public class SnsCommentCollapseLayout extends RelativeLayout {
    private SnsComment2LinePreloadTextView rMS = null;
    private SnsCommentPreloadTextView rMT = null;
    private TextView rMU = null;
    private CharSequence rMV = null;
    private int rMW = 0;

    public SnsCommentCollapseLayout(Context context) {
        super(context);
        AppMethodBeat.i(40481);
        init();
        AppMethodBeat.o(40481);
    }

    public SnsCommentCollapseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40482);
        init();
        AppMethodBeat.o(40482);
    }

    public SnsCommentCollapseLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40483);
        init();
        AppMethodBeat.o(40483);
    }

    private void init() {
        AppMethodBeat.i(40484);
        LayoutInflater.from(getContext()).inflate(R.layout.auz, this, true);
        this.rMS = (SnsComment2LinePreloadTextView) findViewById(R.id.ehf);
        this.rMT = (SnsCommentPreloadTextView) findViewById(R.id.ehg);
        this.rMU = (TextView) findViewById(R.id.ehh);
        this.rMW = a.fromDPToPix(getContext(), 22);
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(40479);
                if (motionEvent.getAction() == 0) {
                    view.setTag(R.id.cy, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
                }
                AppMethodBeat.o(40479);
                return false;
            }
        });
        AppMethodBeat.o(40484);
    }

    public void setOpClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(40485);
        this.rMU.setOnClickListener(onClickListener);
        AppMethodBeat.o(40485);
    }

    public void setPressTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.i(40486);
        this.rMS.setOnTouchListener(onTouchListener);
        this.rMT.setOnTouchListener(onTouchListener);
        AppMethodBeat.o(40486);
    }

    public void setTextSize(float f) {
        AppMethodBeat.i(40487);
        this.rMS.setTextSize(f);
        this.rMT.setTextSize(f);
        AppMethodBeat.o(40487);
    }

    public final void setTextSize$255e752(float f) {
        AppMethodBeat.i(40488);
        this.rMS.setTextSize$255e752(f);
        this.rMT.setTextSize$255e752(f);
        this.rMU.setTextSize(1, f);
        AppMethodBeat.o(40488);
    }

    public void setTextColor(int i) {
        AppMethodBeat.i(40489);
        this.rMS.setTextColor(i);
        this.rMT.setTextColor(i);
        AppMethodBeat.o(40489);
    }

    public void setGravity(int i) {
        AppMethodBeat.i(40490);
        this.rMS.setGravity(i);
        this.rMT.setGravity(i);
        AppMethodBeat.o(40490);
    }

    public final void k(final CharSequence charSequence, final int i) {
        AppMethodBeat.i(40491);
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(40480);
                ab.d("MicroMsg.SnsCommentCollapseLayout", "setText text:%s, commentFlag:%s", charSequence, Integer.valueOf(i));
                SnsCommentCollapseLayout.this.rMV = charSequence == null ? "" : charSequence;
                if (d.fF(i, 16)) {
                    SnsCommentCollapseLayout.b(SnsCommentCollapseLayout.this);
                    AppMethodBeat.o(40480);
                    return;
                }
                SnsCommentCollapseLayout.c(SnsCommentCollapseLayout.this);
                AppMethodBeat.o(40480);
            }
        });
        AppMethodBeat.o(40491);
    }

    static /* synthetic */ void b(SnsCommentCollapseLayout snsCommentCollapseLayout) {
        AppMethodBeat.i(40492);
        snsCommentCollapseLayout.rMU.setVisibility(0);
        snsCommentCollapseLayout.rMS.setLines(2);
        snsCommentCollapseLayout.rMS.getConfig().eOf = (snsCommentCollapseLayout.getMeasuredWidth() - snsCommentCollapseLayout.rMU.getMeasuredWidth()) - snsCommentCollapseLayout.rMW;
        snsCommentCollapseLayout.rMS.setText(snsCommentCollapseLayout.rMV);
        snsCommentCollapseLayout.rMS.setVisibility(0);
        snsCommentCollapseLayout.rMT.setVisibility(8);
        snsCommentCollapseLayout.invalidate();
        AppMethodBeat.o(40492);
    }

    static /* synthetic */ void c(SnsCommentCollapseLayout snsCommentCollapseLayout) {
        AppMethodBeat.i(40493);
        snsCommentCollapseLayout.rMU.setVisibility(4);
        snsCommentCollapseLayout.rMT.setText(snsCommentCollapseLayout.rMV);
        snsCommentCollapseLayout.rMT.setVisibility(0);
        snsCommentCollapseLayout.rMS.setVisibility(8);
        snsCommentCollapseLayout.invalidate();
        AppMethodBeat.o(40493);
    }
}
