package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.ak;

public class PreViewListGridView extends ListView {
    private WindowManager lca;
    private boolean lgk = true;
    private LayoutParams lgq;
    private int lgr;
    private int lgs;
    private int lgt;
    private boolean lgu;
    private volatile int lgv = -1;
    private String lgw;
    private PopEmojiView lgx;
    private a lgy;
    private ak mHandler = new ak();
    private int mOrientation;

    public PreViewListGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(53848);
        init(context);
        AppMethodBeat.o(53848);
    }

    public PreViewListGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(53849);
        init(context);
        AppMethodBeat.o(53849);
    }

    private void init(Context context) {
        AppMethodBeat.i(53850);
        this.lgx = new PopEmojiView(getContext());
        this.lgr = context.getResources().getDimensionPixelSize(R.dimen.a1c);
        this.lca = (WindowManager) context.getSystemService("window");
        this.lgq = new LayoutParams(-1, -1, 2, 8, 1);
        this.lgq.width = this.lgr;
        this.lgq.height = this.lgr;
        this.lgq.gravity = 17;
        this.mOrientation = getResources().getConfiguration().orientation;
        if (this.mOrientation == 2) {
            this.lgs = this.lca.getDefaultDisplay().getHeight();
            this.lgt = this.lca.getDefaultDisplay().getWidth();
            AppMethodBeat.o(53850);
            return;
        }
        this.lgs = this.lca.getDefaultDisplay().getWidth();
        this.lgt = this.lca.getDefaultDisplay().getHeight();
        AppMethodBeat.o(53850);
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(53851);
        super.setAdapter(listAdapter);
        this.lgy = (a) listAdapter;
        AppMethodBeat.o(53851);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(53852);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.lgu) {
                    bmt();
                    AppMethodBeat.o(53852);
                    return true;
                }
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(53852);
        return onInterceptTouchEvent;
    }

    public final void bmt() {
        AppMethodBeat.i(53853);
        if (this.lgu) {
            this.lca.removeView(this.lgx);
            this.lgu = false;
        }
        this.lgw = "";
        AppMethodBeat.o(53853);
    }

    public void setEnablePreView(boolean z) {
        this.lgk = z;
    }
}
