package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ad.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMFormSelectorView extends LinearLayout {
    private TextView gnB;
    private String hint;
    private int layout;
    private Context mContext;
    private EditText pwu;
    private String title;

    @TargetApi(11)
    public MMFormSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(106584);
        this.mContext = null;
        this.layout = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.FormItemView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            this.title = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            this.hint = context.getString(resourceId);
        }
        this.layout = obtainStyledAttributes.getResourceId(0, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
        AppMethodBeat.o(106584);
    }

    public MMFormSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(106586);
        if (this.gnB != null) {
            this.gnB.setText(str);
            AppMethodBeat.o(106586);
            return;
        }
        ab.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
        AppMethodBeat.o(106586);
    }

    public void setHint(String str) {
        AppMethodBeat.i(106587);
        if (this.pwu != null) {
            this.pwu.setHint(str);
            AppMethodBeat.o(106587);
            return;
        }
        ab.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.o(106587);
    }

    public void setTitle(int i) {
        AppMethodBeat.i(106588);
        if (this.gnB != null) {
            this.gnB.setText(i);
            AppMethodBeat.o(106588);
            return;
        }
        ab.e("MicroMsg.MMFormSelectorView", "titleTV is null!");
        AppMethodBeat.o(106588);
    }

    public void setHint(int i) {
        AppMethodBeat.i(106589);
        if (this.pwu != null) {
            this.pwu.setHint(i);
            AppMethodBeat.o(106589);
            return;
        }
        ab.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.o(106589);
    }

    public void setText(String str) {
        AppMethodBeat.i(106590);
        if (this.pwu != null) {
            this.pwu.setText(str);
            AppMethodBeat.o(106590);
            return;
        }
        ab.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.o(106590);
    }

    public String getText() {
        AppMethodBeat.i(106591);
        if (this.pwu != null) {
            String obj = this.pwu.getText().toString();
            AppMethodBeat.o(106591);
            return obj;
        }
        ab.e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.o(106591);
        return null;
    }

    public void onFinishInflate() {
        AppMethodBeat.i(106585);
        this.gnB = (TextView) findViewById(R.id.cx);
        this.pwu = (EditText) findViewById(R.id.l3);
        if (this.gnB == null || this.pwu == null) {
            ab.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", this.gnB, this.pwu);
            AppMethodBeat.o(106585);
            return;
        }
        if (this.title != null) {
            this.gnB.setText(this.title);
        }
        if (this.hint != null) {
            this.pwu.setHint(this.hint);
        }
        AppMethodBeat.o(106585);
    }
}
