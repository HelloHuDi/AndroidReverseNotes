package com.tencent.p177mm.plugin.ipcall.p442ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton */
public class IPCallFuncButton extends LinearLayout {
    private boolean kcj = false;
    private ImageView nDf;
    private TextView nDg;
    private Drawable nDh;
    private Drawable nDi;
    private Drawable nDj;
    private boolean nDk;
    private boolean nDl = true;
    private C12266a nDm;
    private OnTouchListener nDn = new C122671();
    private String text;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton$a */
    public interface C12266a {
        /* renamed from: iv */
        void mo24103iv(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton$1 */
    class C122671 implements OnTouchListener {
        C122671() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(22180);
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
                            IPCallFuncButton.this.nDm.mo24103iv(IPCallFuncButton.this.kcj);
                        }
                    } else if (IPCallFuncButton.this.nDi != null) {
                        IPCallFuncButton.this.nDf.setImageDrawable(IPCallFuncButton.this.nDi);
                    }
                } else if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 1) && !IPCallFuncButton.this.nDk) {
                    if (IPCallFuncButton.this.nDh != null) {
                        IPCallFuncButton.this.nDf.setImageDrawable(IPCallFuncButton.this.nDh);
                    }
                    if (IPCallFuncButton.this.nDm != null) {
                        IPCallFuncButton.this.nDm.mo24103iv(false);
                    }
                }
                AppMethodBeat.m2505o(22180);
            } else {
                AppMethodBeat.m2505o(22180);
            }
            return false;
        }
    }

    public IPCallFuncButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(22181);
        LayoutInflater.from(getContext()).inflate(2130969889, this);
        this.nDf = (ImageView) findViewById(2131820869);
        this.nDg = (TextView) findViewById(2131820674);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, C25738R.C8899a.IPCallFuncButton, 0, 0);
        this.nDh = obtainStyledAttributes.getDrawable(0);
        this.nDi = obtainStyledAttributes.getDrawable(1);
        this.nDk = obtainStyledAttributes.getBoolean(4, false);
        this.nDj = obtainStyledAttributes.getDrawable(2);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.text = getContext().getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (C5046bo.isNullOrNil(this.text)) {
            this.nDg.setVisibility(8);
        } else {
            this.nDg.setText(this.text);
        }
        if (this.nDh != null) {
            this.nDf.setImageDrawable(this.nDh);
        }
        this.nDf.setClickable(true);
        this.nDf.setOnTouchListener(this.nDn);
        AppMethodBeat.m2505o(22181);
    }

    public void setClickCallback(C12266a c12266a) {
        this.nDm = c12266a;
    }

    public String getFuncText() {
        return this.text;
    }

    public void setFuncText(String str) {
        AppMethodBeat.m2504i(22182);
        this.text = str;
        this.nDg.setText(this.text);
        AppMethodBeat.m2505o(22182);
    }

    public final boolean isChecked() {
        if (this.nDk) {
            return this.kcj;
        }
        return false;
    }

    public void setCheckBoxMode(boolean z) {
        AppMethodBeat.m2504i(22183);
        if (this.nDk != z) {
            this.nDk = z;
            this.kcj = false;
            if (this.nDh != null) {
                this.nDf.setImageDrawable(this.nDh);
            }
        }
        AppMethodBeat.m2505o(22183);
    }

    public void setEnable(boolean z) {
        AppMethodBeat.m2504i(22184);
        if (z != this.nDl) {
            this.nDl = z;
            if (this.nDl || this.nDj == null) {
                this.nDf.setImageDrawable(this.nDh);
            } else {
                this.nDf.setImageDrawable(this.nDj);
            }
            this.kcj = false;
        }
        AppMethodBeat.m2505o(22184);
    }

    public void setChecked(boolean z) {
        AppMethodBeat.m2504i(22185);
        if (z != this.kcj && this.nDk) {
            this.kcj = z;
            if (this.kcj) {
                this.nDf.setImageDrawable(this.nDi);
                AppMethodBeat.m2505o(22185);
                return;
            }
            this.nDf.setImageDrawable(this.nDh);
        }
        AppMethodBeat.m2505o(22185);
    }
}
