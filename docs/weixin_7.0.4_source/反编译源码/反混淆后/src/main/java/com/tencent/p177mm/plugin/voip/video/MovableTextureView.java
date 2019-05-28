package com.tencent.p177mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip.video.MovableTextureView */
public class MovableTextureView extends MMTextureView {
    private float cjG;
    private float cjH;
    private OnClickListener mOnClickListener;
    public int mScreenHeight;
    public int mScreenWidth;
    public int mWidth;
    public int sZX;
    public int taq;
    public int tar;
    private long tas;

    public MovableTextureView(Context context) {
        this(context, null);
    }

    public MovableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWidth = 320;
        this.sZX = 240;
        this.taq = 800;
        this.tar = 480;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.m2504i(5064);
        C4990ab.m7410d("MicroMsg.MovableTextureView", "event: " + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 0:
                this.cjG = motionEvent.getRawX();
                this.cjH = motionEvent.getRawY();
                this.tas = System.currentTimeMillis();
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (this.tas != 0 && currentTimeMillis - this.tas < 300 && currentTimeMillis - this.tas >= 0 && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                C7060h.pYm.mo8381e(11079, Integer.valueOf(2));
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.cjG;
                float rawY = motionEvent.getRawY() - this.cjH;
                if (Math.abs(rawX) > 1.0f || Math.abs(rawY) > 1.0f) {
                    LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                    int i2 = (int) (rawX + ((float) layoutParams.leftMargin));
                    int i3 = (int) (rawY + ((float) layoutParams.topMargin));
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 > this.tar) {
                        i2 = this.tar;
                    }
                    layoutParams.leftMargin = i2;
                    if (i3 >= 0) {
                        i = i3 > this.taq ? this.taq : i3;
                    }
                    layoutParams.topMargin = i;
                    setLayoutParams(layoutParams);
                    this.cjG = motionEvent.getRawX();
                    this.cjH = motionEvent.getRawY();
                    break;
                }
        }
        AppMethodBeat.m2505o(5064);
        return true;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
