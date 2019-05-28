package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;

public class MMCollapsibleTextView extends LinearLayout {
    private int cNE;
    private Context context;
    private TextView gKl;
    private boolean hasCheck = true;
    private Runnable mhD = new Runnable() {
        public final void run() {
            AppMethodBeat.i(106519);
            MMCollapsibleTextView.this.gKl.setMaxLines(10);
            MMCollapsibleTextView.this.rhT.setVisibility(0);
            MMCollapsibleTextView.this.rhT.setText(MMCollapsibleTextView.this.rhU);
            AppMethodBeat.o(106519);
        }
    };
    private TextView rhT;
    private String rhU;
    private String rhV;
    private SparseIntArray ytX = new SparseIntArray();

    public MMCollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106520);
        this.context = context;
        this.rhU = this.context.getString(R.string.erv);
        this.rhV = this.context.getString(R.string.ei0);
        View inflate = inflate(this.context, R.layout.adk, this);
        inflate.setPadding(0, -3, 0, 0);
        this.gKl = (TextView) inflate.findViewById(R.id.ld);
        this.rhT = (TextView) inflate.findViewById(R.id.axb);
        this.rhT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(106518);
                switch (MMCollapsibleTextView.this.ytX.get(MMCollapsibleTextView.this.cNE, -1)) {
                    case 1:
                        MMCollapsibleTextView.this.ytX.put(MMCollapsibleTextView.this.cNE, 2);
                        break;
                    case 2:
                        MMCollapsibleTextView.this.ytX.put(MMCollapsibleTextView.this.cNE, 1);
                        break;
                    default:
                        AppMethodBeat.o(106518);
                        return;
                }
                MMCollapsibleTextView.c(MMCollapsibleTextView.this);
                AppMethodBeat.o(106518);
            }
        });
        AppMethodBeat.o(106520);
    }

    public int getSpreadHeight() {
        AppMethodBeat.i(106521);
        ab.e("MicroMsg.CollapsibleTextView", "count:" + this.gKl.getLineCount() + "  height:" + this.gKl.getLineHeight());
        int lineCount = (this.gKl.getLineCount() - 10) * this.gKl.getLineHeight();
        AppMethodBeat.o(106521);
        return lineCount;
    }

    public void setOpClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(106522);
        this.rhT.setOnClickListener(onClickListener);
        AppMethodBeat.o(106522);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106523);
        super.onLayout(z, i, i2, i3, i4);
        if (this.hasCheck) {
            AppMethodBeat.o(106523);
            return;
        }
        this.hasCheck = true;
        if (this.gKl.getLineCount() <= 10) {
            this.ytX.put(this.cNE, 0);
            AppMethodBeat.o(106523);
            return;
        }
        this.ytX.put(this.cNE, 1);
        post(this.mhD);
        AppMethodBeat.o(106523);
    }

    static /* synthetic */ void c(MMCollapsibleTextView mMCollapsibleTextView) {
        AppMethodBeat.i(106524);
        mMCollapsibleTextView.hasCheck = true;
        switch (mMCollapsibleTextView.ytX.get(mMCollapsibleTextView.cNE, -1)) {
            case 0:
                mMCollapsibleTextView.rhT.setVisibility(8);
                AppMethodBeat.o(106524);
                return;
            case 1:
                mMCollapsibleTextView.gKl.setMaxLines(10);
                mMCollapsibleTextView.rhT.setVisibility(0);
                mMCollapsibleTextView.rhT.setText(mMCollapsibleTextView.rhU);
                AppMethodBeat.o(106524);
                return;
            case 2:
                mMCollapsibleTextView.gKl.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                mMCollapsibleTextView.rhT.setVisibility(0);
                mMCollapsibleTextView.rhT.setText(mMCollapsibleTextView.rhV);
                AppMethodBeat.o(106524);
                return;
            default:
                mMCollapsibleTextView.hasCheck = false;
                mMCollapsibleTextView.rhT.setVisibility(8);
                mMCollapsibleTextView.gKl.setMaxLines(11);
                AppMethodBeat.o(106524);
                return;
        }
    }
}
