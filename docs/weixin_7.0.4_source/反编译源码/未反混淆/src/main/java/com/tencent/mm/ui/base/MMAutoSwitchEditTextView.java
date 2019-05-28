package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMAutoSwitchEditText.d;
import java.util.ArrayList;
import java.util.Iterator;

public class MMAutoSwitchEditTextView extends LinearLayout {
    private int iYI = 100;
    private Context mContext;
    private int mScreenWidth;
    private int nJg;
    private int pNN;
    private int ytO;
    private String ytP;
    private ArrayList<MMAutoSwitchEditText> ytQ = new ArrayList();
    private c ytR = new c(this, (byte) 0);
    private a ytS;
    private b ytT;

    public interface a {
        void wr(String str);
    }

    public interface b {
        void aqK();
    }

    class c implements com.tencent.mm.ui.base.MMAutoSwitchEditText.b, com.tencent.mm.ui.base.MMAutoSwitchEditText.c, d {
        private c() {
        }

        /* synthetic */ c(MMAutoSwitchEditTextView mMAutoSwitchEditTextView, byte b) {
            this();
        }

        public final void NE(int i) {
            MMAutoSwitchEditText mMAutoSwitchEditText;
            AppMethodBeat.i(106498);
            String str = "";
            Iterator it = MMAutoSwitchEditTextView.this.ytQ.iterator();
            while (it.hasNext()) {
                String str2;
                mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (bo.isNullOrNil(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (bo.isNullOrNil(str) || str.length() != MMAutoSwitchEditTextView.this.ytO * MMAutoSwitchEditTextView.this.nJg) {
                if (MMAutoSwitchEditTextView.this.ytT != null) {
                    MMAutoSwitchEditTextView.this.ytT.aqK();
                }
                if (MMAutoSwitchEditTextView.this.ytQ != null && i < MMAutoSwitchEditTextView.this.ytQ.size() - 1) {
                    mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.this.ytQ.get(i + 1);
                    if (mMAutoSwitchEditText != null) {
                        mMAutoSwitchEditText.requestFocus();
                    }
                }
                AppMethodBeat.o(106498);
                return;
            }
            if (MMAutoSwitchEditTextView.this.ytS != null) {
                MMAutoSwitchEditTextView.this.ytS.wr(str);
            }
            AppMethodBeat.o(106498);
        }

        public final void ND(int i) {
            AppMethodBeat.i(106499);
            if (MMAutoSwitchEditTextView.this.ytQ != null && i < MMAutoSwitchEditTextView.this.ytQ.size()) {
                if (i == 0) {
                    AppMethodBeat.o(106499);
                    return;
                }
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.this.ytQ.get(i - 1);
                if (mMAutoSwitchEditText != null) {
                    mMAutoSwitchEditText.requestFocus();
                }
            }
            AppMethodBeat.o(106499);
        }

        public final void dzE() {
            AppMethodBeat.i(106500);
            String str = "";
            Iterator it = MMAutoSwitchEditTextView.this.ytQ.iterator();
            while (it.hasNext()) {
                String str2;
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (bo.isNullOrNil(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (MMAutoSwitchEditTextView.this.ytT != null) {
                MMAutoSwitchEditTextView.this.ytT.aqK();
            }
            AppMethodBeat.o(106500);
        }
    }

    public void setOnInputFinished(a aVar) {
        this.ytS = aVar;
    }

    public void setOnTextChanged(b bVar) {
        this.ytT = bVar;
    }

    public String getText() {
        AppMethodBeat.i(106501);
        String str = "";
        Iterator it = this.ytQ.iterator();
        while (it.hasNext()) {
            String str2;
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
            if (bo.isNullOrNil(mMAutoSwitchEditText.getText().toString().trim())) {
                str2 = str;
            } else {
                str2 = str + mMAutoSwitchEditText.getText().toString().trim();
            }
            str = str2;
        }
        AppMethodBeat.o(106501);
        return str;
    }

    public MMAutoSwitchEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106502);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.ad.a.a.AutoSwitchLayout);
        this.ytO = obtainStyledAttributes.getInteger(0, 3);
        this.nJg = obtainStyledAttributes.getInteger(1, 4);
        this.pNN = obtainStyledAttributes.getInteger(2, 2);
        int resourceId = obtainStyledAttributes.getResourceId(3, 0);
        if (resourceId != 0) {
            this.ytP = context.getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (context instanceof Activity) {
            this.mScreenWidth = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
            this.iYI = ((this.mScreenWidth - 80) - ((this.ytO - 1) * 20)) / this.ytO;
        }
        setPadding(com.tencent.mm.bz.a.fromDPToPix(context, 20), 0, com.tencent.mm.bz.a.fromDPToPix(context, 20), 0);
        bKZ();
        AppMethodBeat.o(106502);
    }

    private void bKZ() {
        AppMethodBeat.i(106503);
        for (int i = 0; i < this.ytO; i++) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) View.inflate(this.mContext, R.layout.f3, null);
            mMAutoSwitchEditText.setInputType(this.pNN);
            if (this.ytP != null && this.ytP.length() > 0) {
                mMAutoSwitchEditText.setKeyListener(DigitsKeyListener.getInstance(this.ytP));
            }
            mMAutoSwitchEditText.ytJ.mIndex = i;
            mMAutoSwitchEditText.ytJ.ytN = this.nJg;
            mMAutoSwitchEditText.ytJ.ytK = this.ytR;
            mMAutoSwitchEditText.ytJ.ytL = this.ytR;
            mMAutoSwitchEditText.ytJ.ytM = this.ytR;
            LayoutParams layoutParams = new LayoutParams(this.iYI, -2);
            if (i > 0) {
                layoutParams.leftMargin = 20;
            } else {
                layoutParams.leftMargin = 0;
            }
            layoutParams.weight = 1.0f;
            mMAutoSwitchEditText.setLayoutParams(layoutParams);
            this.ytQ.add(mMAutoSwitchEditText);
            addView(mMAutoSwitchEditText);
        }
        AppMethodBeat.o(106503);
    }
}
