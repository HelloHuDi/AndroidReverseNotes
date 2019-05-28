package com.tencent.p177mm.p612ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.MMAutoSwitchEditText.C15507b;
import com.tencent.p177mm.p612ui.base.MMAutoSwitchEditText.C23583d;
import com.tencent.p177mm.p612ui.base.MMAutoSwitchEditText.C30365c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.base.MMAutoSwitchEditTextView */
public class MMAutoSwitchEditTextView extends LinearLayout {
    private int iYI = 100;
    private Context mContext;
    private int mScreenWidth;
    private int nJg;
    private int pNN;
    private int ytO;
    private String ytP;
    private ArrayList<MMAutoSwitchEditText> ytQ = new ArrayList();
    private C5245c ytR = new C5245c(this, (byte) 0);
    private C5243a ytS;
    private C5244b ytT;

    /* renamed from: com.tencent.mm.ui.base.MMAutoSwitchEditTextView$a */
    public interface C5243a {
        /* renamed from: wr */
        void mo10754wr(String str);
    }

    /* renamed from: com.tencent.mm.ui.base.MMAutoSwitchEditTextView$b */
    public interface C5244b {
        void aqK();
    }

    /* renamed from: com.tencent.mm.ui.base.MMAutoSwitchEditTextView$c */
    class C5245c implements C15507b, C30365c, C23583d {
        private C5245c() {
        }

        /* synthetic */ C5245c(MMAutoSwitchEditTextView mMAutoSwitchEditTextView, byte b) {
            this();
        }

        /* renamed from: NE */
        public final void mo10757NE(int i) {
            MMAutoSwitchEditText mMAutoSwitchEditText;
            AppMethodBeat.m2504i(106498);
            String str = "";
            Iterator it = MMAutoSwitchEditTextView.this.ytQ.iterator();
            while (it.hasNext()) {
                String str2;
                mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (C5046bo.isNullOrNil(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (C5046bo.isNullOrNil(str) || str.length() != MMAutoSwitchEditTextView.this.ytO * MMAutoSwitchEditTextView.this.nJg) {
                if (MMAutoSwitchEditTextView.this.ytT != null) {
                    MMAutoSwitchEditTextView.this.ytT.aqK();
                }
                if (MMAutoSwitchEditTextView.this.ytQ != null && i < MMAutoSwitchEditTextView.this.ytQ.size() - 1) {
                    mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.this.ytQ.get(i + 1);
                    if (mMAutoSwitchEditText != null) {
                        mMAutoSwitchEditText.requestFocus();
                    }
                }
                AppMethodBeat.m2505o(106498);
                return;
            }
            if (MMAutoSwitchEditTextView.this.ytS != null) {
                MMAutoSwitchEditTextView.this.ytS.mo10754wr(str);
            }
            AppMethodBeat.m2505o(106498);
        }

        /* renamed from: ND */
        public final void mo10756ND(int i) {
            AppMethodBeat.m2504i(106499);
            if (MMAutoSwitchEditTextView.this.ytQ != null && i < MMAutoSwitchEditTextView.this.ytQ.size()) {
                if (i == 0) {
                    AppMethodBeat.m2505o(106499);
                    return;
                }
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) MMAutoSwitchEditTextView.this.ytQ.get(i - 1);
                if (mMAutoSwitchEditText != null) {
                    mMAutoSwitchEditText.requestFocus();
                }
            }
            AppMethodBeat.m2505o(106499);
        }

        public final void dzE() {
            AppMethodBeat.m2504i(106500);
            String str = "";
            Iterator it = MMAutoSwitchEditTextView.this.ytQ.iterator();
            while (it.hasNext()) {
                String str2;
                MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
                if (C5046bo.isNullOrNil(mMAutoSwitchEditText.getText().toString().trim())) {
                    str2 = str;
                } else {
                    str2 = str + mMAutoSwitchEditText.getText().toString().trim();
                }
                str = str2;
            }
            if (MMAutoSwitchEditTextView.this.ytT != null) {
                MMAutoSwitchEditTextView.this.ytT.aqK();
            }
            AppMethodBeat.m2505o(106500);
        }
    }

    public void setOnInputFinished(C5243a c5243a) {
        this.ytS = c5243a;
    }

    public void setOnTextChanged(C5244b c5244b) {
        this.ytT = c5244b;
    }

    public String getText() {
        AppMethodBeat.m2504i(106501);
        String str = "";
        Iterator it = this.ytQ.iterator();
        while (it.hasNext()) {
            String str2;
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) it.next();
            if (C5046bo.isNullOrNil(mMAutoSwitchEditText.getText().toString().trim())) {
                str2 = str;
            } else {
                str2 = str + mMAutoSwitchEditText.getText().toString().trim();
            }
            str = str2;
        }
        AppMethodBeat.m2505o(106501);
        return str;
    }

    public MMAutoSwitchEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106502);
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.AutoSwitchLayout);
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
        setPadding(C1338a.fromDPToPix(context, 20), 0, C1338a.fromDPToPix(context, 20), 0);
        bKZ();
        AppMethodBeat.m2505o(106502);
    }

    private void bKZ() {
        AppMethodBeat.m2504i(106503);
        for (int i = 0; i < this.ytO; i++) {
            MMAutoSwitchEditText mMAutoSwitchEditText = (MMAutoSwitchEditText) View.inflate(this.mContext, 2130968790, null);
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
        AppMethodBeat.m2505o(106503);
    }
}
