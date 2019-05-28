package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.PopEmojiView;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView */
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
    private C11603a lgy;
    private C7306ak mHandler = new C7306ak();
    private int mOrientation;

    public PreViewListGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(53848);
        init(context);
        AppMethodBeat.m2505o(53848);
    }

    public PreViewListGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(53849);
        init(context);
        AppMethodBeat.m2505o(53849);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(53850);
        this.lgx = new PopEmojiView(getContext());
        this.lgr = context.getResources().getDimensionPixelSize(C25738R.dimen.a1c);
        this.lca = (WindowManager) context.getSystemService("window");
        this.lgq = new LayoutParams(-1, -1, 2, 8, 1);
        this.lgq.width = this.lgr;
        this.lgq.height = this.lgr;
        this.lgq.gravity = 17;
        this.mOrientation = getResources().getConfiguration().orientation;
        if (this.mOrientation == 2) {
            this.lgs = this.lca.getDefaultDisplay().getHeight();
            this.lgt = this.lca.getDefaultDisplay().getWidth();
            AppMethodBeat.m2505o(53850);
            return;
        }
        this.lgs = this.lca.getDefaultDisplay().getWidth();
        this.lgt = this.lca.getDefaultDisplay().getHeight();
        AppMethodBeat.m2505o(53850);
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(53851);
        super.setAdapter(listAdapter);
        this.lgy = (C11603a) listAdapter;
        AppMethodBeat.m2505o(53851);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(53852);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.lgu) {
                    bmt();
                    AppMethodBeat.m2505o(53852);
                    return true;
                }
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(53852);
        return onInterceptTouchEvent;
    }

    public final void bmt() {
        AppMethodBeat.m2504i(53853);
        if (this.lgu) {
            this.lca.removeView(this.lgx);
            this.lgu = false;
        }
        this.lgw = "";
        AppMethodBeat.m2505o(53853);
    }

    public void setEnablePreView(boolean z) {
        this.lgk = z;
    }
}
