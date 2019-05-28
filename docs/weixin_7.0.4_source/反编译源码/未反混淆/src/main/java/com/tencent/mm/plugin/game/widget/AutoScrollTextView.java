package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.ArrayList;
import java.util.List;

public class AutoScrollTextView extends LinearLayout {
    private int lfO = 0;
    private ap neF = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(112365);
            AutoScrollTextView.a(AutoScrollTextView.this);
            AppMethodBeat.o(112365);
            return true;
        }
    }, true);
    private ArrayList<String> nga = new ArrayList();
    private Animation ngh;
    private Animation ngi;
    private TextView nnU;
    private TextView nnV;

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112366);
        this.nnU = new TextView(context, attributeSet);
        this.nnU.setVisibility(8);
        this.nnV = new TextView(context, attributeSet);
        this.nnV.setVisibility(8);
        addView(this.nnU);
        addView(this.nnV);
        setOrientation(1);
        setGravity(17);
        setPadding(0, 0, 0, 0);
        this.ngh = AnimationUtils.loadAnimation(context, R.anim.da);
        this.ngi = AnimationUtils.loadAnimation(context, R.anim.di);
        AppMethodBeat.o(112366);
    }

    public void setText(List<String> list) {
        AppMethodBeat.i(112367);
        this.nga.clear();
        this.neF.stopTimer();
        if (list == null || list.size() == 0) {
            this.nnU.setVisibility(8);
            this.nnV.setVisibility(8);
            AppMethodBeat.o(112367);
            return;
        }
        this.nga.addAll(list);
        b(this.nnU, (String) this.nga.get(0));
        this.nnU.setVisibility(0);
        this.lfO = 0;
        if (this.nga.size() == 1) {
            AppMethodBeat.o(112367);
            return;
        }
        this.neF.ae(5000, 5000);
        AppMethodBeat.o(112367);
    }

    private void b(TextView textView, String str) {
        AppMethodBeat.i(112368);
        textView.setText(new SpannableString(j.b(getContext(), (CharSequence) str, textView.getTextSize())));
        AppMethodBeat.o(112368);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(112369);
        super.onDetachedFromWindow();
        this.neF.stopTimer();
        AppMethodBeat.o(112369);
    }

    static /* synthetic */ void a(AutoScrollTextView autoScrollTextView) {
        AppMethodBeat.i(112370);
        if (autoScrollTextView.nga.size() >= 2) {
            String str;
            if (autoScrollTextView.lfO < autoScrollTextView.nga.size() - 1) {
                autoScrollTextView.lfO++;
                str = (String) autoScrollTextView.nga.get(autoScrollTextView.lfO);
            } else {
                autoScrollTextView.lfO = 0;
                str = (String) autoScrollTextView.nga.get(autoScrollTextView.lfO);
            }
            autoScrollTextView.b(autoScrollTextView.nnV, str);
            autoScrollTextView.nnU.startAnimation(autoScrollTextView.ngi);
            autoScrollTextView.nnU.setVisibility(8);
            autoScrollTextView.nnV.startAnimation(autoScrollTextView.ngh);
            autoScrollTextView.nnV.setVisibility(0);
            TextView textView = autoScrollTextView.nnU;
            autoScrollTextView.nnU = autoScrollTextView.nnV;
            autoScrollTextView.nnV = textView;
        }
        AppMethodBeat.o(112370);
    }
}
