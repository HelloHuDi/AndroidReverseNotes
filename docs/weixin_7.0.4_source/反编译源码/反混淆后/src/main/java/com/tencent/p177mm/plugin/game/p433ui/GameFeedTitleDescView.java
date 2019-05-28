package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p731d.C43176x;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.GameFeedTitleDescView */
public class GameFeedTitleDescView extends LinearLayout {
    private TextView iDT;
    private TextView kEq;
    private LinearLayout niV;

    public GameFeedTitleDescView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111954);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(2130969716, this, true);
        this.niV = (LinearLayout) inflate.findViewById(2131824504);
        this.iDT = (TextView) inflate.findViewById(2131820678);
        this.kEq = (TextView) inflate.findViewById(2131821095);
        AppMethodBeat.m2505o(111954);
    }

    /* renamed from: b */
    public final void mo73904b(String str, String str2, LinkedList<C43176x> linkedList) {
        AppMethodBeat.m2504i(111955);
        if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str2)) {
            setVisibility(8);
            AppMethodBeat.m2505o(111955);
            return;
        }
        setVisibility(0);
        if (C5046bo.m7548ek(linkedList)) {
            this.niV.setVisibility(8);
            if (C5046bo.isNullOrNil(str)) {
                this.iDT.setVisibility(8);
            } else {
                this.iDT.setText(str);
                this.iDT.setVisibility(0);
            }
        } else {
            this.niV.setVisibility(0);
            while (this.niV.getChildCount() < linkedList.size() + 1) {
                ImageView imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LayoutParams(getResources().getDimensionPixelSize(C25738R.dimen.f9919k6), getResources().getDimensionPixelSize(C25738R.dimen.f9919k6));
                layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(C25738R.dimen.f9915k1), 0);
                layoutParams.gravity = 16;
                imageView.setScaleType(ScaleType.FIT_XY);
                this.niV.addView(imageView, 0, layoutParams);
            }
            int i = 0;
            while (i < linkedList.size()) {
                ImageView imageView2 = (ImageView) this.niV.getChildAt(i);
                C28203e.bFH().mo46101i(imageView2, ((C43176x) linkedList.get(i)).mZW);
                imageView2.setVisibility(0);
                i++;
            }
            while (i < this.niV.getChildCount() - 1) {
                int i2 = i + 1;
                this.niV.getChildAt(i).setVisibility(8);
                i = i2;
            }
            if (!C5046bo.isNullOrNil(str)) {
                ((TextView) this.niV.getChildAt(i)).setText(str);
            }
            this.iDT.setVisibility(8);
        }
        if (C5046bo.isNullOrNil(str2)) {
            this.kEq.setVisibility(8);
        } else {
            this.kEq.setText(str2);
            this.kEq.setVisibility(0);
        }
        if (GameFeedTitleDescView.m85520a(this.iDT, str, (C46001c.getScreenWidth(getContext()) - ((ViewGroup) getParent()).getPaddingLeft()) - ((ViewGroup) getParent()).getPaddingRight()) > 1) {
            this.kEq.setMaxLines(1);
            AppMethodBeat.m2505o(111955);
            return;
        }
        this.kEq.setMaxLines(2);
        AppMethodBeat.m2505o(111955);
    }

    /* renamed from: a */
    private static int m85520a(TextView textView, String str, int i) {
        AppMethodBeat.m2504i(111956);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111956);
            return 0;
        } else if (textView.getPaint().measureText(str) > ((float) i)) {
            AppMethodBeat.m2505o(111956);
            return 2;
        } else {
            AppMethodBeat.m2505o(111956);
            return 1;
        }
    }
}
