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

/* renamed from: com.tencent.mm.plugin.voip.ui.VoipSmallIconButton */
public class VoipSmallIconButton extends FrameLayout {
    private ImageView ikh;
    private OnTouchListener jZu = new C140711();
    /* renamed from: sW */
    private TextView f4401sW;
    private Drawable sWI = null;
    private Drawable sWJ = null;

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipSmallIconButton$1 */
    class C140711 implements OnTouchListener {
        C140711() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(4866);
            switch (motionEvent.getAction()) {
                case 0:
                    VoipSmallIconButton.this.ikh.setImageDrawable(VoipSmallIconButton.this.sWJ);
                    VoipSmallIconButton.this.f4401sW.setTextColor(-855638017);
                    break;
                case 1:
                    VoipSmallIconButton.this.ikh.setImageDrawable(VoipSmallIconButton.this.sWI);
                    VoipSmallIconButton.this.f4401sW.setTextColor(-1);
                    break;
            }
            AppMethodBeat.m2505o(4866);
            return false;
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(4867);
        this.ikh.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(4867);
    }

    public VoipSmallIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(4868);
        LayoutInflater.from(context).inflate(2130969929, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C14033a.VoipButton, 0, 0);
        try {
            this.sWI = obtainStyledAttributes.getDrawable(2);
            this.sWJ = obtainStyledAttributes.getDrawable(3);
            String string = obtainStyledAttributes.getString(4);
            int resourceId = obtainStyledAttributes.getResourceId(4, -1);
            obtainStyledAttributes.recycle();
            this.ikh = (ImageView) findViewById(2131825248);
            this.ikh.setImageDrawable(this.sWI);
            this.ikh.setOnTouchListener(this.jZu);
            this.ikh.setContentDescription(string);
            this.f4401sW = (TextView) findViewById(2131825249);
            if (resourceId != -1) {
                this.f4401sW.setText(getContext().getString(resourceId));
            }
            AppMethodBeat.m2505o(4868);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.m2505o(4868);
        }
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.m2504i(4869);
        this.ikh.setEnabled(z);
        this.f4401sW.setEnabled(z);
        AppMethodBeat.m2505o(4869);
    }
}
