package com.tencent.p177mm.plugin.product.p482ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wxpay.C23226a.C23227a;

/* renamed from: com.tencent.mm.plugin.product.ui.MallProductItemView */
public class MallProductItemView extends LinearLayout {
    private TextView iDT;
    private Object mData;
    private String mTitle;
    private int mType;
    private String peG;
    private int piW;
    private TextView pip;
    private ImageView piq;

    public MallProductItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(44079);
        this.piW = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C23227a.MallProductItemView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            this.mTitle = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.peG = context.getString(resourceId);
        }
        this.piW = obtainStyledAttributes.getInt(0, 1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(2130970390, this, true);
        this.iDT = (TextView) inflate.findViewById(2131821185);
        this.pip = (TextView) inflate.findViewById(2131826598);
        this.piq = (ImageView) inflate.findViewById(2131826599);
        this.iDT.setText(this.mTitle);
        this.pip.setText(this.peG);
        this.pip.setLines(this.piW);
        AppMethodBeat.m2505o(44079);
    }

    public MallProductItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(44080);
        this.mTitle = str;
        this.iDT.setText(this.mTitle);
        AppMethodBeat.m2505o(44080);
    }

    public void setSummary(String str) {
        AppMethodBeat.m2504i(44081);
        this.peG = str;
        this.pip.setText(this.peG);
        AppMethodBeat.m2505o(44081);
    }

    public void setSummary(Spanned spanned) {
        AppMethodBeat.m2504i(44082);
        this.peG = spanned.toString();
        this.pip.setText(this.peG);
        AppMethodBeat.m2505o(44082);
    }

    public int getType() {
        return this.mType;
    }

    public Object getData() {
        return this.mData;
    }
}
