package com.tencent.p177mm.plugin.game.widget;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.widget.AutoScrollTextView */
public class AutoScrollTextView extends LinearLayout {
    private int lfO = 0;
    private C7564ap neF = new C7564ap(new C343221(), true);
    private ArrayList<String> nga = new ArrayList();
    private Animation ngh;
    private Animation ngi;
    private TextView nnU;
    private TextView nnV;

    /* renamed from: com.tencent.mm.plugin.game.widget.AutoScrollTextView$1 */
    class C343221 implements C5015a {
        C343221() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(112365);
            AutoScrollTextView.m56262a(AutoScrollTextView.this);
            AppMethodBeat.m2505o(112365);
            return true;
        }
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112366);
        this.nnU = new TextView(context, attributeSet);
        this.nnU.setVisibility(8);
        this.nnV = new TextView(context, attributeSet);
        this.nnV.setVisibility(8);
        addView(this.nnU);
        addView(this.nnV);
        setOrientation(1);
        setGravity(17);
        setPadding(0, 0, 0, 0);
        this.ngh = AnimationUtils.loadAnimation(context, C25738R.anim.f8400da);
        this.ngi = AnimationUtils.loadAnimation(context, C25738R.anim.f8406di);
        AppMethodBeat.m2505o(112366);
    }

    public void setText(List<String> list) {
        AppMethodBeat.m2504i(112367);
        this.nga.clear();
        this.neF.stopTimer();
        if (list == null || list.size() == 0) {
            this.nnU.setVisibility(8);
            this.nnV.setVisibility(8);
            AppMethodBeat.m2505o(112367);
            return;
        }
        this.nga.addAll(list);
        m56263b(this.nnU, (String) this.nga.get(0));
        this.nnU.setVisibility(0);
        this.lfO = 0;
        if (this.nga.size() == 1) {
            AppMethodBeat.m2505o(112367);
            return;
        }
        this.neF.mo16770ae(5000, 5000);
        AppMethodBeat.m2505o(112367);
    }

    /* renamed from: b */
    private void m56263b(TextView textView, String str) {
        AppMethodBeat.m2504i(112368);
        textView.setText(new SpannableString(C44089j.m79293b(getContext(), (CharSequence) str, textView.getTextSize())));
        AppMethodBeat.m2505o(112368);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(112369);
        super.onDetachedFromWindow();
        this.neF.stopTimer();
        AppMethodBeat.m2505o(112369);
    }

    /* renamed from: a */
    static /* synthetic */ void m56262a(AutoScrollTextView autoScrollTextView) {
        AppMethodBeat.m2504i(112370);
        if (autoScrollTextView.nga.size() >= 2) {
            String str;
            if (autoScrollTextView.lfO < autoScrollTextView.nga.size() - 1) {
                autoScrollTextView.lfO++;
                str = (String) autoScrollTextView.nga.get(autoScrollTextView.lfO);
            } else {
                autoScrollTextView.lfO = 0;
                str = (String) autoScrollTextView.nga.get(autoScrollTextView.lfO);
            }
            autoScrollTextView.m56263b(autoScrollTextView.nnV, str);
            autoScrollTextView.nnU.startAnimation(autoScrollTextView.ngi);
            autoScrollTextView.nnU.setVisibility(8);
            autoScrollTextView.nnV.startAnimation(autoScrollTextView.ngh);
            autoScrollTextView.nnV.setVisibility(0);
            TextView textView = autoScrollTextView.nnU;
            autoScrollTextView.nnU = autoScrollTextView.nnV;
            autoScrollTextView.nnV = textView;
        }
        AppMethodBeat.m2505o(112370);
    }
}
