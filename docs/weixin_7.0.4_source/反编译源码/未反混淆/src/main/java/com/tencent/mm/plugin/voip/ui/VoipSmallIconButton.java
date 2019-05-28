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

public class VoipSmallIconButton extends FrameLayout {
    private ImageView ikh;
    private OnTouchListener jZu = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(4866);
            switch (motionEvent.getAction()) {
                case 0:
                    VoipSmallIconButton.this.ikh.setImageDrawable(VoipSmallIconButton.this.sWJ);
                    VoipSmallIconButton.this.sW.setTextColor(-855638017);
                    break;
                case 1:
                    VoipSmallIconButton.this.ikh.setImageDrawable(VoipSmallIconButton.this.sWI);
                    VoipSmallIconButton.this.sW.setTextColor(-1);
                    break;
            }
            AppMethodBeat.o(4866);
            return false;
        }
    };
    private TextView sW;
    private Drawable sWI = null;
    private Drawable sWJ = null;

    public void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(4867);
        this.ikh.setOnClickListener(onClickListener);
        AppMethodBeat.o(4867);
    }

    public VoipSmallIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(4868);
        LayoutInflater.from(context).inflate(R.layout.a9r, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.VoipButton, 0, 0);
        try {
            this.sWI = obtainStyledAttributes.getDrawable(2);
            this.sWJ = obtainStyledAttributes.getDrawable(3);
            String string = obtainStyledAttributes.getString(4);
            int resourceId = obtainStyledAttributes.getResourceId(4, -1);
            obtainStyledAttributes.recycle();
            this.ikh = (ImageView) findViewById(R.id.cp6);
            this.ikh.setImageDrawable(this.sWI);
            this.ikh.setOnTouchListener(this.jZu);
            this.ikh.setContentDescription(string);
            this.sW = (TextView) findViewById(R.id.cp7);
            if (resourceId != -1) {
                this.sW.setText(getContext().getString(resourceId));
            }
            AppMethodBeat.o(4868);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(4868);
        }
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(4869);
        this.ikh.setEnabled(z);
        this.sW.setEnabled(z);
        AppMethodBeat.o(4869);
    }
}
