package com.tencent.p177mm.plugin.wallet.p559ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wxpay.C23226a.C23227a;

/* renamed from: com.tencent.mm.plugin.wallet.ui.WalletItemView */
public class WalletItemView extends LinearLayout {
    private TextView iDT;
    private Object mData;
    private String mTitle;
    private int mType;
    private String peG;
    private int piW;
    private TextView pip;

    public WalletItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(46452);
        this.piW = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C23227a.WalletItemView, i, 0);
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
        View inflate = LayoutInflater.from(context).inflate(2130971113, this, true);
        this.iDT = (TextView) inflate.findViewById(2131821185);
        this.pip = (TextView) inflate.findViewById(2131826598);
        if (this.iDT != null) {
            this.iDT.setText(this.mTitle);
        }
        if (this.pip != null) {
            this.pip.setText(this.peG);
            this.pip.setLines(this.piW);
        }
        AppMethodBeat.m2505o(46452);
    }

    public WalletItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(46453);
        this.mTitle = str;
        this.iDT.setText(this.mTitle);
        AppMethodBeat.m2505o(46453);
    }

    public void setSummary(String str) {
        AppMethodBeat.m2504i(46454);
        this.peG = str;
        this.pip.setText(this.peG);
        AppMethodBeat.m2505o(46454);
    }

    public void setSummary(Spanned spanned) {
        AppMethodBeat.m2504i(46455);
        this.peG = spanned.toString();
        this.pip.setText(this.peG);
        AppMethodBeat.m2505o(46455);
    }

    public int getType() {
        return this.mType;
    }

    public Object getData() {
        return this.mData;
    }
}
