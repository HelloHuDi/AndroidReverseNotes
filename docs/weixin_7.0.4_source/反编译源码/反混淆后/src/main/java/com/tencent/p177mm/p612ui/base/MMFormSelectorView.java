package com.tencent.p177mm.p612ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.MMFormSelectorView */
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
        AppMethodBeat.m2504i(106584);
        this.mContext = null;
        this.layout = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.FormItemView, i, 0);
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
        MMFormSelectorView.inflate(context, this.layout, this);
        this.mContext = context;
        AppMethodBeat.m2505o(106584);
    }

    public MMFormSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(106586);
        if (this.gnB != null) {
            this.gnB.setText(str);
            AppMethodBeat.m2505o(106586);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormSelectorView", "titleTV is null!");
        AppMethodBeat.m2505o(106586);
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(106587);
        if (this.pwu != null) {
            this.pwu.setHint(str);
            AppMethodBeat.m2505o(106587);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.m2505o(106587);
    }

    public void setTitle(int i) {
        AppMethodBeat.m2504i(106588);
        if (this.gnB != null) {
            this.gnB.setText(i);
            AppMethodBeat.m2505o(106588);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormSelectorView", "titleTV is null!");
        AppMethodBeat.m2505o(106588);
    }

    public void setHint(int i) {
        AppMethodBeat.m2504i(106589);
        if (this.pwu != null) {
            this.pwu.setHint(i);
            AppMethodBeat.m2505o(106589);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.m2505o(106589);
    }

    public void setText(String str) {
        AppMethodBeat.m2504i(106590);
        if (this.pwu != null) {
            this.pwu.setText(str);
            AppMethodBeat.m2505o(106590);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.m2505o(106590);
    }

    public String getText() {
        AppMethodBeat.m2504i(106591);
        if (this.pwu != null) {
            String obj = this.pwu.getText().toString();
            AppMethodBeat.m2505o(106591);
            return obj;
        }
        C4990ab.m7412e("MicroMsg.MMFormSelectorView", "contentET is null!");
        AppMethodBeat.m2505o(106591);
        return null;
    }

    public void onFinishInflate() {
        AppMethodBeat.m2504i(106585);
        this.gnB = (TextView) findViewById(2131820678);
        this.pwu = (EditText) findViewById(2131820980);
        if (this.gnB == null || this.pwu == null) {
            C4990ab.m7421w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", this.gnB, this.pwu);
            AppMethodBeat.m2505o(106585);
            return;
        }
        if (this.title != null) {
            this.gnB.setText(this.title);
        }
        if (this.hint != null) {
            this.pwu.setHint(this.hint);
        }
        AppMethodBeat.m2505o(106585);
    }
}
