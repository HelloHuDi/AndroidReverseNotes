package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.base.MMCollapsibleTextView */
public class MMCollapsibleTextView extends LinearLayout {
    private int cNE;
    private Context context;
    private TextView gKl;
    private boolean hasCheck = true;
    private Runnable mhD = new C155082();
    private TextView rhT;
    private String rhU;
    private String rhV;
    private SparseIntArray ytX = new SparseIntArray();

    /* renamed from: com.tencent.mm.ui.base.MMCollapsibleTextView$1 */
    class C52491 implements OnClickListener {
        C52491() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(106518);
            switch (MMCollapsibleTextView.this.ytX.get(MMCollapsibleTextView.this.cNE, -1)) {
                case 1:
                    MMCollapsibleTextView.this.ytX.put(MMCollapsibleTextView.this.cNE, 2);
                    break;
                case 2:
                    MMCollapsibleTextView.this.ytX.put(MMCollapsibleTextView.this.cNE, 1);
                    break;
                default:
                    AppMethodBeat.m2505o(106518);
                    return;
            }
            MMCollapsibleTextView.m79921c(MMCollapsibleTextView.this);
            AppMethodBeat.m2505o(106518);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMCollapsibleTextView$2 */
    class C155082 implements Runnable {
        C155082() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106519);
            MMCollapsibleTextView.this.gKl.setMaxLines(10);
            MMCollapsibleTextView.this.rhT.setVisibility(0);
            MMCollapsibleTextView.this.rhT.setText(MMCollapsibleTextView.this.rhU);
            AppMethodBeat.m2505o(106519);
        }
    }

    public MMCollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106520);
        this.context = context;
        this.rhU = this.context.getString(C25738R.string.erv);
        this.rhV = this.context.getString(C25738R.string.ei0);
        View inflate = MMCollapsibleTextView.inflate(this.context, 2130970107, this);
        inflate.setPadding(0, -3, 0, 0);
        this.gKl = (TextView) inflate.findViewById(2131820991);
        this.rhT = (TextView) inflate.findViewById(2131822813);
        this.rhT.setOnClickListener(new C52491());
        AppMethodBeat.m2505o(106520);
    }

    public int getSpreadHeight() {
        AppMethodBeat.m2504i(106521);
        C4990ab.m7412e("MicroMsg.CollapsibleTextView", "count:" + this.gKl.getLineCount() + "  height:" + this.gKl.getLineHeight());
        int lineCount = (this.gKl.getLineCount() - 10) * this.gKl.getLineHeight();
        AppMethodBeat.m2505o(106521);
        return lineCount;
    }

    public void setOpClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(106522);
        this.rhT.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(106522);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106523);
        super.onLayout(z, i, i2, i3, i4);
        if (this.hasCheck) {
            AppMethodBeat.m2505o(106523);
            return;
        }
        this.hasCheck = true;
        if (this.gKl.getLineCount() <= 10) {
            this.ytX.put(this.cNE, 0);
            AppMethodBeat.m2505o(106523);
            return;
        }
        this.ytX.put(this.cNE, 1);
        post(this.mhD);
        AppMethodBeat.m2505o(106523);
    }

    /* renamed from: c */
    static /* synthetic */ void m79921c(MMCollapsibleTextView mMCollapsibleTextView) {
        AppMethodBeat.m2504i(106524);
        mMCollapsibleTextView.hasCheck = true;
        switch (mMCollapsibleTextView.ytX.get(mMCollapsibleTextView.cNE, -1)) {
            case 0:
                mMCollapsibleTextView.rhT.setVisibility(8);
                AppMethodBeat.m2505o(106524);
                return;
            case 1:
                mMCollapsibleTextView.gKl.setMaxLines(10);
                mMCollapsibleTextView.rhT.setVisibility(0);
                mMCollapsibleTextView.rhT.setText(mMCollapsibleTextView.rhU);
                AppMethodBeat.m2505o(106524);
                return;
            case 2:
                mMCollapsibleTextView.gKl.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                mMCollapsibleTextView.rhT.setVisibility(0);
                mMCollapsibleTextView.rhT.setText(mMCollapsibleTextView.rhV);
                AppMethodBeat.m2505o(106524);
                return;
            default:
                mMCollapsibleTextView.hasCheck = false;
                mMCollapsibleTextView.rhT.setVisibility(8);
                mMCollapsibleTextView.gKl.setMaxLines(11);
                AppMethodBeat.m2505o(106524);
                return;
        }
    }
}
