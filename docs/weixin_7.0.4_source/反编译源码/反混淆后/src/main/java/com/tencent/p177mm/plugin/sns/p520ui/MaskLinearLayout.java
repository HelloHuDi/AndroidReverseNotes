package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.sns.ui.MaskLinearLayout */
public class MaskLinearLayout extends LinearLayout {
    private boolean enable = false;
    private List<MaskImageView> list = new LinkedList();
    private C7306ak rgT = new C7306ak();
    private Runnable rgU = new C39661();

    /* renamed from: com.tencent.mm.plugin.sns.ui.MaskLinearLayout$1 */
    class C39661 implements Runnable {
        C39661() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38314);
            MaskLinearLayout.this.setPressed(false);
            MaskLinearLayout.m6335a(MaskLinearLayout.this);
            MaskLinearLayout.this.invalidate();
            AppMethodBeat.m2505o(38314);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.MaskLinearLayout$2 */
    class C39672 implements OnTouchListener {
        C39672() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(38315);
            C4990ab.m7412e("test", "touch: " + motionEvent.getAction());
            if (MaskLinearLayout.this.enable) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        MaskLinearLayout.m6335a(MaskLinearLayout.this);
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
                        maskImageView.mo25657d(maskImageView, motionEvent);
                    }
                }
                AppMethodBeat.m2505o(38315);
            } else {
                AppMethodBeat.m2505o(38315);
            }
            return false;
        }
    }

    public MaskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38316);
        super.setOnTouchListener(new C39672());
        AppMethodBeat.m2505o(38316);
    }

    public void settouchEnable(boolean z) {
        this.enable = z;
    }

    /* renamed from: b */
    public final void mo8749b(MaskImageView maskImageView) {
        AppMethodBeat.m2504i(38317);
        this.list.add(maskImageView);
        AppMethodBeat.m2505o(38317);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(38318);
        super.onDraw(canvas);
        AppMethodBeat.m2505o(38318);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        AppMethodBeat.m2504i(38319);
        Assert.assertTrue(false);
        AppMethodBeat.m2505o(38319);
    }

    /* renamed from: a */
    static /* synthetic */ void m6335a(MaskLinearLayout maskLinearLayout) {
        AppMethodBeat.m2504i(38320);
        if (maskLinearLayout.isPressed()) {
            maskLinearLayout.setBackgroundResource(C25738R.drawable.aox);
            AppMethodBeat.m2505o(38320);
            return;
        }
        maskLinearLayout.setBackgroundResource(0);
        AppMethodBeat.m2505o(38320);
    }
}
