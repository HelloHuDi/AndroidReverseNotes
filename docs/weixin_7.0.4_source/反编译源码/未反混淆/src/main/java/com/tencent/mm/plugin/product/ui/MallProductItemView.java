package com.tencent.mm.plugin.product.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxpay.a.a;

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
        AppMethodBeat.i(44079);
        this.piW = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.MallProductItemView, i, 0);
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.al7, this, true);
        this.iDT = (TextView) inflate.findViewById(R.id.qm);
        this.pip = (TextView) inflate.findViewById(R.id.don);
        this.piq = (ImageView) inflate.findViewById(R.id.doo);
        this.iDT.setText(this.mTitle);
        this.pip.setText(this.peG);
        this.pip.setLines(this.piW);
        AppMethodBeat.o(44079);
    }

    public MallProductItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(44080);
        this.mTitle = str;
        this.iDT.setText(this.mTitle);
        AppMethodBeat.o(44080);
    }

    public void setSummary(String str) {
        AppMethodBeat.i(44081);
        this.peG = str;
        this.pip.setText(this.peG);
        AppMethodBeat.o(44081);
    }

    public void setSummary(Spanned spanned) {
        AppMethodBeat.i(44082);
        this.peG = spanned.toString();
        this.pip.setText(this.peG);
        AppMethodBeat.o(44082);
    }

    public int getType() {
        return this.mType;
    }

    public Object getData() {
        return this.mData;
    }
}
