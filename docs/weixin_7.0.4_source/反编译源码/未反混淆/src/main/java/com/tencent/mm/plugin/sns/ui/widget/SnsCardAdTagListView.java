package com.tencent.mm.plugin.sns.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public class SnsCardAdTagListView extends LinearLayout {
    private Activity activity;
    private int rMK;
    private List<View> rsl = new ArrayList();

    public SnsCardAdTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40465);
        AppMethodBeat.o(40465);
    }

    public SnsCardAdTagListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(40466);
        AppMethodBeat.o(40466);
    }

    public void setActivityContext(Activity activity) {
        this.activity = activity;
    }

    public final void dB(List<String> list) {
        AppMethodBeat.i(40467);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Object obj;
                if (i == 0) {
                    obj = null;
                } else {
                    int obj2 = 1;
                }
                String str = (String) list.get(i);
                if (!bo.isNullOrNil(str)) {
                    View inflate = this.activity.getLayoutInflater().inflate(R.layout.aq, null);
                    TextView textView = (TextView) inflate.findViewById(R.id.m6);
                    LayoutParams layoutParams = new LayoutParams(-2, -2);
                    if (obj2 != null) {
                        layoutParams.leftMargin = this.rMK;
                    }
                    textView.setText(str);
                    addView(inflate, layoutParams);
                    this.rsl.add(inflate);
                }
            }
        }
        AppMethodBeat.o(40467);
    }

    public void setTagSpace(int i) {
        this.rMK = i;
    }

    public void removeAllViews() {
        AppMethodBeat.i(40468);
        super.removeAllViews();
        this.rsl.clear();
        AppMethodBeat.o(40468);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        AppMethodBeat.i(40469);
        super.onMeasure(i, i2);
        int i5 = 0;
        while (true) {
            i3 = i4;
            if (i3 < this.rsl.size()) {
                if (i3 > 0) {
                    i4 = i5 + this.rMK;
                } else {
                    i4 = i5;
                }
                if (i4 < getMeasuredWidth()) {
                    i5 = ((View) this.rsl.get(i3)).getMeasuredWidth() + i4;
                    if (i5 >= getMeasuredWidth()) {
                        break;
                    }
                    i4 = i3 + 1;
                } else {
                    i3--;
                    break;
                }
            }
            break;
        }
        if (i3 >= 0 && i3 < this.rsl.size()) {
            final View view = (View) this.rsl.get(i3);
            final TextView textView = (TextView) view.findViewById(R.id.m6);
            textView.setEllipsize(TruncateAt.END);
            getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    AppMethodBeat.i(40464);
                    if (!(textView.getLayout() == null || bo.ac(textView.getLayout().getText()) || textView.getLayout().getText().charAt(0) != 8230)) {
                        SnsCardAdTagListView.this.removeView(view);
                        SnsCardAdTagListView.this.rsl.remove(view);
                    }
                    SnsCardAdTagListView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    AppMethodBeat.o(40464);
                    return true;
                }
            });
            i5 = i3 + 1;
            while (true) {
                i4 = i5;
                if (i4 >= this.rsl.size()) {
                    break;
                }
                removeView((View) this.rsl.get(i4));
                this.rsl.remove(i4);
                i5 = i4 + 1;
            }
        }
        AppMethodBeat.o(40469);
    }
}
