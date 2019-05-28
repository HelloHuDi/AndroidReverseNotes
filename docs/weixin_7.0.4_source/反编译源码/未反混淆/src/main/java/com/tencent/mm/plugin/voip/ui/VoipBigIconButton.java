package com.tencent.mm.plugin.voip.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.a.a;

public class VoipBigIconButton extends FrameLayout {
    private ImageView ikh;
    private OnTouchListener jZu = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(4852);
            switch (motionEvent.getAction()) {
                case 0:
                    VoipBigIconButton.this.ikh.setBackgroundDrawable(VoipBigIconButton.this.sWH);
                    VoipBigIconButton.this.ikh.setImageDrawable(VoipBigIconButton.this.sWJ);
                    VoipBigIconButton.this.sW.setTextColor(-855638017);
                    break;
                case 1:
                    VoipBigIconButton.this.ikh.setBackgroundDrawable(VoipBigIconButton.this.sWG);
                    VoipBigIconButton.this.ikh.setImageDrawable(VoipBigIconButton.this.sWI);
                    VoipBigIconButton.this.sW.setTextColor(-1);
                    break;
            }
            AppMethodBeat.o(4852);
            return false;
        }
    };
    private TextView sW;
    private Drawable sWG = null;
    private Drawable sWH = null;
    private Drawable sWI = null;
    private Drawable sWJ = null;

    public VoipBigIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(4853);
        LayoutInflater.from(context).inflate(R.layout.a9q, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.VoipButton, 0, 0);
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
            this.ikh = (ImageView) findViewById(R.id.cp4);
            this.ikh.setBackgroundDrawable(this.sWG);
            this.ikh.setImageDrawable(this.sWI);
            this.ikh.setOnTouchListener(this.jZu);
            this.ikh.setContentDescription(string);
            this.sW = (TextView) findViewById(R.id.cp5);
            if (resourceId != -1) {
                this.sW.setText(getContext().getString(resourceId));
            }
            AppMethodBeat.o(4853);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(4853);
        }
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(4854);
        this.ikh.setEnabled(z);
        this.sW.setEnabled(z);
        AppMethodBeat.o(4854);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(4855);
        this.ikh.setOnClickListener(onClickListener);
        AppMethodBeat.o(4855);
    }
}
