package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;

public class IPCallFuncButton extends LinearLayout {
    private boolean kcj = false;
    private ImageView nDf;
    private TextView nDg;
    private Drawable nDh;
    private Drawable nDi;
    private Drawable nDj;
    private boolean nDk;
    private boolean nDl = true;
    private a nDm;
    private OnTouchListener nDn = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(22180);
            if (IPCallFuncButton.this.nDl) {
                if (motionEvent.getAction() == 0) {
                    if (IPCallFuncButton.this.nDk) {
                        if (IPCallFuncButton.this.kcj) {
                            IPCallFuncButton.this.nDf.setImageDrawable(IPCallFuncButton.this.nDh);
                            IPCallFuncButton.this.kcj = false;
                        } else {
                            IPCallFuncButton.this.nDf.setImageDrawable(IPCallFuncButton.this.nDi);
                            IPCallFuncButton.this.kcj = true;
                        }
                        if (IPCallFuncButton.this.nDm != null) {
                            IPCallFuncButton.this.nDm.iv(IPCallFuncButton.this.kcj);
                        }
                    } else if (IPCallFuncButton.this.nDi != null) {
                        IPCallFuncButton.this.nDf.setImageDrawable(IPCallFuncButton.this.nDi);
                    }
                } else if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && !IPCallFuncButton.this.nDk) {
                    if (IPCallFuncButton.this.nDh != null) {
                        IPCallFuncButton.this.nDf.setImageDrawable(IPCallFuncButton.this.nDh);
                    }
                    if (IPCallFuncButton.this.nDm != null) {
                        IPCallFuncButton.this.nDm.iv(false);
                    }
                }
                AppMethodBeat.o(22180);
            } else {
                AppMethodBeat.o(22180);
            }
            return false;
        }
    };
    private String text;

    public interface a {
        void iv(boolean z);
    }

    public IPCallFuncButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(22181);
        LayoutInflater.from(getContext()).inflate(R.layout.a8o, this);
        this.nDf = (ImageView) findViewById(R.id.i3);
        this.nDg = (TextView) findViewById(R.id.ct);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.a.IPCallFuncButton, 0, 0);
        this.nDh = obtainStyledAttributes.getDrawable(0);
        this.nDi = obtainStyledAttributes.getDrawable(1);
        this.nDk = obtainStyledAttributes.getBoolean(4, false);
        this.nDj = obtainStyledAttributes.getDrawable(2);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.text = getContext().getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (bo.isNullOrNil(this.text)) {
            this.nDg.setVisibility(8);
        } else {
            this.nDg.setText(this.text);
        }
        if (this.nDh != null) {
            this.nDf.setImageDrawable(this.nDh);
        }
        this.nDf.setClickable(true);
        this.nDf.setOnTouchListener(this.nDn);
        AppMethodBeat.o(22181);
    }

    public void setClickCallback(a aVar) {
        this.nDm = aVar;
    }

    public String getFuncText() {
        return this.text;
    }

    public void setFuncText(String str) {
        AppMethodBeat.i(22182);
        this.text = str;
        this.nDg.setText(this.text);
        AppMethodBeat.o(22182);
    }

    public final boolean isChecked() {
        if (this.nDk) {
            return this.kcj;
        }
        return false;
    }

    public void setCheckBoxMode(boolean z) {
        AppMethodBeat.i(22183);
        if (this.nDk != z) {
            this.nDk = z;
            this.kcj = false;
            if (this.nDh != null) {
                this.nDf.setImageDrawable(this.nDh);
            }
        }
        AppMethodBeat.o(22183);
    }

    public void setEnable(boolean z) {
        AppMethodBeat.i(22184);
        if (z != this.nDl) {
            this.nDl = z;
            if (this.nDl || this.nDj == null) {
                this.nDf.setImageDrawable(this.nDh);
            } else {
                this.nDf.setImageDrawable(this.nDj);
            }
            this.kcj = false;
        }
        AppMethodBeat.o(22184);
    }

    public void setChecked(boolean z) {
        AppMethodBeat.i(22185);
        if (z != this.kcj && this.nDk) {
            this.kcj = z;
            if (this.kcj) {
                this.nDf.setImageDrawable(this.nDi);
                AppMethodBeat.o(22185);
                return;
            }
            this.nDf.setImageDrawable(this.nDh);
        }
        AppMethodBeat.o(22185);
    }
}
