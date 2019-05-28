package com.tencent.p177mm.plugin.voip.p546ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.voip.C46318a.C14033a;

/* renamed from: com.tencent.mm.plugin.voip.ui.VoipBigIconButton */
public class VoipBigIconButton extends FrameLayout {
    private ImageView ikh;
    private OnTouchListener jZu = new C140651();
    /* renamed from: sW */
    private TextView f2948sW;
    private Drawable sWG = null;
    private Drawable sWH = null;
    private Drawable sWI = null;
    private Drawable sWJ = null;

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipBigIconButton$1 */
    class C140651 implements OnTouchListener {
        C140651() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(4852);
            switch (motionEvent.getAction()) {
                case 0:
                    VoipBigIconButton.this.ikh.setBackgroundDrawable(VoipBigIconButton.this.sWH);
                    VoipBigIconButton.this.ikh.setImageDrawable(VoipBigIconButton.this.sWJ);
                    VoipBigIconButton.this.f2948sW.setTextColor(-855638017);
                    break;
                case 1:
                    VoipBigIconButton.this.ikh.setBackgroundDrawable(VoipBigIconButton.this.sWG);
                    VoipBigIconButton.this.ikh.setImageDrawable(VoipBigIconButton.this.sWI);
                    VoipBigIconButton.this.f2948sW.setTextColor(-1);
                    break;
            }
            AppMethodBeat.m2505o(4852);
            return false;
        }
    }

    public VoipBigIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(4853);
        LayoutInflater.from(context).inflate(2130969928, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C14033a.VoipButton, 0, 0);
        try {
            CharSequence string;
            this.sWG = obtainStyledAttributes.getDrawable(0);
            this.sWH = obtainStyledAttributes.getDrawable(1);
            this.sWI = obtainStyledAttributes.getDrawable(2);
            this.sWJ = obtainStyledAttributes.getDrawable(3);
            int resourceId = obtainStyledAttributes.getResourceId(4, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
            if (resourceId2 != 0) {
                string = getContext().getString(resourceId2);
            } else {
                string = null;
            }
            obtainStyledAttributes.recycle();
            this.sWH = this.sWH == null ? this.sWG : this.sWH;
            this.sWJ = this.sWJ == null ? this.sWI : this.sWJ;
            this.ikh = (ImageView) findViewById(2131825246);
            this.ikh.setBackgroundDrawable(this.sWG);
            this.ikh.setImageDrawable(this.sWI);
            this.ikh.setOnTouchListener(this.jZu);
            this.ikh.setContentDescription(string);
            this.f2948sW = (TextView) findViewById(2131825247);
            if (resourceId != -1) {
                this.f2948sW.setText(getContext().getString(resourceId));
            }
            AppMethodBeat.m2505o(4853);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(4853);
        }
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.m2504i(4854);
        this.ikh.setEnabled(z);
        this.f2948sW.setEnabled(z);
        AppMethodBeat.m2505o(4854);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(4855);
        this.ikh.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(4855);
    }
}
