package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MaskLinearLayout extends LinearLayout {
    private boolean enable = false;
    private List<MaskImageView> list = new LinkedList();
    private ak rgT = new ak();
    private Runnable rgU = new Runnable() {
        public final void run() {
            AppMethodBeat.i(38314);
            MaskLinearLayout.this.setPressed(false);
            MaskLinearLayout.a(MaskLinearLayout.this);
            MaskLinearLayout.this.invalidate();
            AppMethodBeat.o(38314);
        }
    };

    public MaskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38316);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(38315);
                ab.e("test", "touch: " + motionEvent.getAction());
                if (MaskLinearLayout.this.enable) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            view.setPressed(true);
                            MaskLinearLayout.a(MaskLinearLayout.this);
                            view.invalidate();
                            MaskLinearLayout.this.rgT.removeCallbacks(MaskLinearLayout.this.rgU);
                            break;
                        case 1:
                        case 3:
                            MaskLinearLayout.this.rgT.post(MaskLinearLayout.this.rgU);
                            break;
                    }
                    if (MaskLinearLayout.this.list != null) {
                        for (MaskImageView maskImageView : MaskLinearLayout.this.list) {
                            maskImageView.d(maskImageView, motionEvent);
                        }
                    }
                    AppMethodBeat.o(38315);
                } else {
                    AppMethodBeat.o(38315);
                }
                return false;
            }
        });
        AppMethodBeat.o(38316);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    public final void b(MaskImageView maskImageView) {
        AppMethodBeat.i(38317);
        this.list.add(maskImageView);
        AppMethodBeat.o(38317);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(38318);
        super.onDraw(canvas);
        AppMethodBeat.o(38318);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.i(38319);
        Assert.assertTrue(false);
        AppMethodBeat.o(38319);
    }

    static /* synthetic */ void a(MaskLinearLayout maskLinearLayout) {
        AppMethodBeat.i(38320);
        if (maskLinearLayout.isPressed()) {
            maskLinearLayout.setBackgroundResource(R.drawable.aox);
            AppMethodBeat.o(38320);
            return;
        }
        maskLinearLayout.setBackgroundResource(0);
        AppMethodBeat.o(38320);
    }
}
