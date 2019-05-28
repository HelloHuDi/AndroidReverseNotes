package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.v;
import java.util.HashMap;

public class CollapsibleTextView extends LinearLayout {
    private String cFc;
    private Context context;
    private String czD;
    private ak handler = new ak(Looper.getMainLooper());
    private boolean hasCheck = true;
    private boolean qFG = false;
    private int rgX = 0;
    protected SnsPostDescPreloadTextView rhR;
    protected SnsTextView rhS;
    protected TextView rhT;
    private String rhU;
    private String rhV;
    private HashMap<String, Integer> rhW;
    protected av rhX;
    private Runnable rhY = new Runnable() {
        public final void run() {
            AppMethodBeat.i(38199);
            if (CollapsibleTextView.this.rhR != null && (CollapsibleTextView.this.rhR.getTag() instanceof ar) && ((ar) CollapsibleTextView.this.rhR.getTag()).cFc.equals(CollapsibleTextView.this.cFc)) {
                CollapsibleTextView.this.rhR.setMaxLines(6);
                CollapsibleTextView.this.rhT.setVisibility(0);
                CollapsibleTextView.this.rhT.setText(CollapsibleTextView.this.rhU);
            }
            AppMethodBeat.o(38199);
        }
    };
    private CharSequence text;

    public CollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38200);
        this.context = context;
        this.rhU = this.context.getString(R.string.ek8);
        this.rhV = this.context.getString(R.string.ek7);
        View inflate = v.hu(this.context).inflate(R.layout.oq, this);
        inflate.setPadding(0, -3, 0, 0);
        this.rhR = (SnsPostDescPreloadTextView) inflate.findViewById(R.id.ld);
        this.rhT = (TextView) inflate.findViewById(R.id.axb);
        this.rhS = (SnsTextView) inflate.findViewById(R.id.axa);
        AppMethodBeat.o(38200);
    }

    public final void a(int i, CharSequence charSequence, BufferType bufferType, HashMap<String, Integer> hashMap, String str, String str2, au auVar, String str3, boolean z) {
        AppMethodBeat.i(38201);
        this.context = auVar.crP;
        this.rhW = hashMap;
        this.text = charSequence;
        this.qFG = z;
        this.czD = str;
        this.cFc = str2;
        this.rgX = i;
        this.rhU = this.context.getString(R.string.ek8);
        this.rhV = this.context.getString(R.string.ek7);
        this.rhS.setOriginText(str3);
        ar arVar = new ar(this.cFc, this.czD, false, false, 1);
        arVar.userName = this.rhX.igi;
        if (i == 0) {
            this.rhR.setText(str3);
            this.rhS.setVisibility(8);
            this.rhT.setVisibility(0);
            this.rhR.setVisibility(0);
            this.rhR.setOnTouchListener(new m(this.context));
            this.rhR.setTag(arVar);
            if (hashMap.get(str) == null) {
                this.hasCheck = false;
                this.rhT.setVisibility(8);
                this.rhR.setMaxLines(8);
                AppMethodBeat.o(38201);
                return;
            }
            this.hasCheck = true;
            switch (((Integer) hashMap.get(str)).intValue()) {
                case 0:
                    this.rhT.setVisibility(8);
                    AppMethodBeat.o(38201);
                    return;
                case 1:
                    this.rhR.setMaxLines(6);
                    this.rhT.setVisibility(0);
                    this.rhT.setText(this.rhU);
                    AppMethodBeat.o(38201);
                    return;
                case 2:
                    this.rhR.setMaxLines(BaseClientBuilder.API_PRIORITY_OTHER);
                    this.rhT.setVisibility(0);
                    this.rhT.setText(this.rhV);
                    break;
            }
            AppMethodBeat.o(38201);
            return;
        }
        this.rhS.setText(charSequence, bufferType);
        this.rhS.setTag(arVar);
        this.rhS.setVisibility(0);
        this.rhT.setVisibility(8);
        this.rhR.setVisibility(8);
        this.rhS.setOnClickListener(auVar.qOL.rKc);
        AppMethodBeat.o(38201);
    }

    public int getSpreadHeight() {
        AppMethodBeat.i(38202);
        ab.i("MicroMsg.CollapsibleTextView", "count:" + this.rhR.getLineCount() + "  height:" + this.rhR.getLineHeight());
        int lineCount = (this.rhR.getLineCount() - 7) * this.rhR.getLineHeight();
        AppMethodBeat.o(38202);
        return lineCount;
    }

    public void setOpClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(38203);
        if (this.rhT != null) {
            this.rhT.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(38203);
    }

    public void setLongClickable(boolean z) {
        AppMethodBeat.i(38204);
        this.rhT.setLongClickable(z);
        this.rhS.setLongClickable(z);
        this.rhR.setLongClickable(z);
        super.setLongClickable(z);
        AppMethodBeat.o(38204);
    }

    public void setClickable(boolean z) {
        AppMethodBeat.i(38205);
        this.rhT.setClickable(z);
        this.rhS.setClickable(z);
        this.rhR.setClickable(z);
        super.setClickable(z);
        AppMethodBeat.o(38205);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(38206);
        super.onLayout(z, i, i2, i3, i4);
        if (this.rgX == 0 && !this.qFG) {
            if (this.hasCheck) {
                AppMethodBeat.o(38206);
                return;
            }
            this.hasCheck = true;
            if (this.rhR.getLineCount() <= 7) {
                this.rhW.put(this.czD, Integer.valueOf(0));
                AppMethodBeat.o(38206);
                return;
            }
            this.rhW.put(this.czD, Integer.valueOf(1));
            this.handler.post(this.rhY);
        }
        AppMethodBeat.o(38206);
    }
}
