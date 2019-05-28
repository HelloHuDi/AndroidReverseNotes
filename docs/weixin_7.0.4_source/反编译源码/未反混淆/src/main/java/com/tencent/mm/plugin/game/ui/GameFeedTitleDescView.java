package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.x;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public class GameFeedTitleDescView extends LinearLayout {
    private TextView iDT;
    private TextView kEq;
    private LinearLayout niV;

    public GameFeedTitleDescView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111954);
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a40, this, true);
        this.niV = (LinearLayout) inflate.findViewById(R.id.c61);
        this.iDT = (TextView) inflate.findViewById(R.id.cx);
        this.kEq = (TextView) inflate.findViewById(R.id.o7);
        AppMethodBeat.o(111954);
    }

    public final void b(String str, String str2, LinkedList<x> linkedList) {
        AppMethodBeat.i(111955);
        if (bo.isNullOrNil(str) && bo.isNullOrNil(str2)) {
            setVisibility(8);
            AppMethodBeat.o(111955);
            return;
        }
        setVisibility(0);
        if (bo.ek(linkedList)) {
            this.niV.setVisibility(8);
            if (bo.isNullOrNil(str)) {
                this.iDT.setVisibility(8);
            } else {
                this.iDT.setText(str);
                this.iDT.setVisibility(0);
            }
        } else {
            this.niV.setVisibility(0);
            while (this.niV.getChildCount() < linkedList.size() + 1) {
                ImageView imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LayoutParams(getResources().getDimensionPixelSize(R.dimen.k6), getResources().getDimensionPixelSize(R.dimen.k6));
                layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.k1), 0);
                layoutParams.gravity = 16;
                imageView.setScaleType(ScaleType.FIT_XY);
                this.niV.addView(imageView, 0, layoutParams);
            }
            int i = 0;
            while (i < linkedList.size()) {
                ImageView imageView2 = (ImageView) this.niV.getChildAt(i);
                e.bFH().i(imageView2, ((x) linkedList.get(i)).mZW);
                imageView2.setVisibility(0);
                i++;
            }
            while (i < this.niV.getChildCount() - 1) {
                int i2 = i + 1;
                this.niV.getChildAt(i).setVisibility(8);
                i = i2;
            }
            if (!bo.isNullOrNil(str)) {
                ((TextView) this.niV.getChildAt(i)).setText(str);
            }
            this.iDT.setVisibility(8);
        }
        if (bo.isNullOrNil(str2)) {
            this.kEq.setVisibility(8);
        } else {
            this.kEq.setText(str2);
            this.kEq.setVisibility(0);
        }
        if (a(this.iDT, str, (c.getScreenWidth(getContext()) - ((ViewGroup) getParent()).getPaddingLeft()) - ((ViewGroup) getParent()).getPaddingRight()) > 1) {
            this.kEq.setMaxLines(1);
            AppMethodBeat.o(111955);
            return;
        }
        this.kEq.setMaxLines(2);
        AppMethodBeat.o(111955);
    }

    private static int a(TextView textView, String str, int i) {
        AppMethodBeat.i(111956);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111956);
            return 0;
        } else if (textView.getPaint().measureText(str) > ((float) i)) {
            AppMethodBeat.o(111956);
            return 2;
        } else {
            AppMethodBeat.o(111956);
            return 1;
        }
    }
}
