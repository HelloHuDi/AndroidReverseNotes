package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsPostDescPreloadTextView;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.sns.ui.CollapsibleTextView */
public class CollapsibleTextView extends LinearLayout {
    private String cFc;
    private Context context;
    private String czD;
    private C7306ak handler = new C7306ak(Looper.getMainLooper());
    private boolean hasCheck = true;
    private boolean qFG = false;
    private int rgX = 0;
    protected SnsPostDescPreloadTextView rhR;
    protected SnsTextView rhS;
    protected TextView rhT;
    private String rhU;
    private String rhV;
    private HashMap<String, Integer> rhW;
    protected C13633av rhX;
    private Runnable rhY = new C350041();
    private CharSequence text;

    /* renamed from: com.tencent.mm.plugin.sns.ui.CollapsibleTextView$1 */
    class C350041 implements Runnable {
        C350041() {
        }

        public final void run() {
            AppMethodBeat.m2504i(38199);
            if (CollapsibleTextView.this.rhR != null && (CollapsibleTextView.this.rhR.getTag() instanceof C39828ar) && ((C39828ar) CollapsibleTextView.this.rhR.getTag()).cFc.equals(CollapsibleTextView.this.cFc)) {
                CollapsibleTextView.this.rhR.setMaxLines(6);
                CollapsibleTextView.this.rhT.setVisibility(0);
                CollapsibleTextView.this.rhT.setText(CollapsibleTextView.this.rhU);
            }
            AppMethodBeat.m2505o(38199);
        }
    }

    public CollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38200);
        this.context = context;
        this.rhU = this.context.getString(C25738R.string.ek8);
        this.rhV = this.context.getString(C25738R.string.ek7);
        View inflate = C5616v.m8409hu(this.context).inflate(2130969149, this);
        inflate.setPadding(0, -3, 0, 0);
        this.rhR = (SnsPostDescPreloadTextView) inflate.findViewById(2131820991);
        this.rhT = (TextView) inflate.findViewById(2131822813);
        this.rhS = (SnsTextView) inflate.findViewById(2131822812);
        AppMethodBeat.m2505o(38200);
    }

    /* renamed from: a */
    public final void mo55592a(int i, CharSequence charSequence, BufferType bufferType, HashMap<String, Integer> hashMap, String str, String str2, C46251au c46251au, String str3, boolean z) {
        AppMethodBeat.m2504i(38201);
        this.context = c46251au.crP;
        this.rhW = hashMap;
        this.text = charSequence;
        this.qFG = z;
        this.czD = str;
        this.cFc = str2;
        this.rgX = i;
        this.rhU = this.context.getString(C25738R.string.ek8);
        this.rhV = this.context.getString(C25738R.string.ek7);
        this.rhS.setOriginText(str3);
        C39828ar c39828ar = new C39828ar(this.cFc, this.czD, false, false, 1);
        c39828ar.userName = this.rhX.igi;
        if (i == 0) {
            this.rhR.setText(str3);
            this.rhS.setVisibility(8);
            this.rhT.setVisibility(0);
            this.rhR.setVisibility(0);
            this.rhR.setOnTouchListener(new C30132m(this.context));
            this.rhR.setTag(c39828ar);
            if (hashMap.get(str) == null) {
                this.hasCheck = false;
                this.rhT.setVisibility(8);
                this.rhR.setMaxLines(8);
                AppMethodBeat.m2505o(38201);
                return;
            }
            this.hasCheck = true;
            switch (((Integer) hashMap.get(str)).intValue()) {
                case 0:
                    this.rhT.setVisibility(8);
                    AppMethodBeat.m2505o(38201);
                    return;
                case 1:
                    this.rhR.setMaxLines(6);
                    this.rhT.setVisibility(0);
                    this.rhT.setText(this.rhU);
                    AppMethodBeat.m2505o(38201);
                    return;
                case 2:
                    this.rhR.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                    this.rhT.setVisibility(0);
                    this.rhT.setText(this.rhV);
                    break;
            }
            AppMethodBeat.m2505o(38201);
            return;
        }
        this.rhS.setText(charSequence, bufferType);
        this.rhS.setTag(c39828ar);
        this.rhS.setVisibility(0);
        this.rhT.setVisibility(8);
        this.rhR.setVisibility(8);
        this.rhS.setOnClickListener(c46251au.qOL.rKc);
        AppMethodBeat.m2505o(38201);
    }

    public int getSpreadHeight() {
        AppMethodBeat.m2504i(38202);
        C4990ab.m7416i("MicroMsg.CollapsibleTextView", "count:" + this.rhR.getLineCount() + "  height:" + this.rhR.getLineHeight());
        int lineCount = (this.rhR.getLineCount() - 7) * this.rhR.getLineHeight();
        AppMethodBeat.m2505o(38202);
        return lineCount;
    }

    public void setOpClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(38203);
        if (this.rhT != null) {
            this.rhT.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(38203);
    }

    public void setLongClickable(boolean z) {
        AppMethodBeat.m2504i(38204);
        this.rhT.setLongClickable(z);
        this.rhS.setLongClickable(z);
        this.rhR.setLongClickable(z);
        super.setLongClickable(z);
        AppMethodBeat.m2505o(38204);
    }

    public void setClickable(boolean z) {
        AppMethodBeat.m2504i(38205);
        this.rhT.setClickable(z);
        this.rhS.setClickable(z);
        this.rhR.setClickable(z);
        super.setClickable(z);
        AppMethodBeat.m2505o(38205);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(38206);
        super.onLayout(z, i, i2, i3, i4);
        if (this.rgX == 0 && !this.qFG) {
            if (this.hasCheck) {
                AppMethodBeat.m2505o(38206);
                return;
            }
            this.hasCheck = true;
            if (this.rhR.getLineCount() <= 7) {
                this.rhW.put(this.czD, Integer.valueOf(0));
                AppMethodBeat.m2505o(38206);
                return;
            }
            this.rhW.put(this.czD, Integer.valueOf(1));
            this.handler.post(this.rhY);
        }
        AppMethodBeat.m2505o(38206);
    }
}
