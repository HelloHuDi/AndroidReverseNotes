package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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

/* renamed from: com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView */
public class GameDetailAutoScrollView extends LinearLayout {
    private int lfO = 0;
    private C7564ap neF = new C7564ap(new C210121(), true);
    private ArrayList<String> nga = new ArrayList();
    private ViewGroup ngb;
    private TextView ngc;
    private TextView ngd;
    private ViewGroup nge;
    private TextView ngf;
    private TextView ngg;
    private Animation ngh;
    private Animation ngi;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView$1 */
    class C210121 implements C5015a {
        C210121() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(111806);
            GameDetailAutoScrollView.m32314a(GameDetailAutoScrollView.this);
            AppMethodBeat.m2505o(111806);
            return true;
        }
    }

    public GameDetailAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(111807);
        this.ngb = (ViewGroup) LayoutInflater.from(context).inflate(2130969689, this, false);
        this.ngc = (TextView) this.ngb.findViewById(2131824443);
        this.ngd = (TextView) this.ngb.findViewById(2131824444);
        addView(this.ngb);
        this.ngb.setVisibility(8);
        this.nge = (ViewGroup) LayoutInflater.from(context).inflate(2130969689, this, false);
        this.ngf = (TextView) this.nge.findViewById(2131824443);
        this.ngg = (TextView) this.nge.findViewById(2131824444);
        addView(this.nge);
        this.nge.setVisibility(8);
        this.ngh = AnimationUtils.loadAnimation(context, C25738R.anim.f8400da);
        this.ngi = AnimationUtils.loadAnimation(context, C25738R.anim.f8406di);
        AppMethodBeat.m2505o(111807);
    }

    public void setText(List<String> list) {
        AppMethodBeat.m2504i(111808);
        this.nga.clear();
        this.neF.stopTimer();
        if (list == null || list.size() == 0 || list.size() % 2 != 0) {
            this.ngb.setVisibility(8);
            this.nge.setVisibility(8);
            AppMethodBeat.m2505o(111808);
            return;
        }
        this.nga.addAll(list);
        this.lfO = 0;
        this.ngc.setText(C44089j.m79293b(getContext(), (CharSequence) this.nga.get(0), this.ngc.getTextSize()));
        this.ngd.setText((CharSequence) this.nga.get(1));
        this.ngb.setVisibility(0);
        this.nge.setVisibility(8);
        if (this.nga.size() / 2 == 1) {
            AppMethodBeat.m2505o(111808);
            return;
        }
        this.neF.mo16770ae(5000, 5000);
        AppMethodBeat.m2505o(111808);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(111809);
        super.onDetachedFromWindow();
        this.neF.stopTimer();
        AppMethodBeat.m2505o(111809);
    }

    /* renamed from: a */
    static /* synthetic */ void m32314a(GameDetailAutoScrollView gameDetailAutoScrollView) {
        AppMethodBeat.m2504i(111810);
        if (gameDetailAutoScrollView.lfO < (gameDetailAutoScrollView.nga.size() / 2) - 1) {
            gameDetailAutoScrollView.lfO++;
        } else {
            gameDetailAutoScrollView.lfO = 0;
        }
        String str = (String) gameDetailAutoScrollView.nga.get((gameDetailAutoScrollView.lfO * 2) + 1);
        gameDetailAutoScrollView.ngf.setText(C44089j.m79293b(gameDetailAutoScrollView.getContext(), (String) gameDetailAutoScrollView.nga.get(gameDetailAutoScrollView.lfO * 2), gameDetailAutoScrollView.ngf.getTextSize()));
        gameDetailAutoScrollView.ngg.setText(str);
        gameDetailAutoScrollView.ngb.startAnimation(gameDetailAutoScrollView.ngi);
        gameDetailAutoScrollView.ngb.setVisibility(8);
        gameDetailAutoScrollView.nge.startAnimation(gameDetailAutoScrollView.ngh);
        gameDetailAutoScrollView.nge.setVisibility(0);
        ViewGroup viewGroup = gameDetailAutoScrollView.ngb;
        gameDetailAutoScrollView.ngb = gameDetailAutoScrollView.nge;
        gameDetailAutoScrollView.nge = viewGroup;
        TextView textView = gameDetailAutoScrollView.ngc;
        gameDetailAutoScrollView.ngc = gameDetailAutoScrollView.ngf;
        gameDetailAutoScrollView.ngf = textView;
        textView = gameDetailAutoScrollView.ngd;
        gameDetailAutoScrollView.ngd = gameDetailAutoScrollView.ngg;
        gameDetailAutoScrollView.ngg = textView;
        AppMethodBeat.m2505o(111810);
    }
}
