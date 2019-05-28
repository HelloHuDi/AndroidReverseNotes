package com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton */
public class GameMenuImageButton extends LinearLayout {
    private ImageView cAw;
    public boolean uEu;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton$a */
    public interface C14615a {
        void bDJ();
    }

    public GameMenuImageButton(Context context) {
        super(context);
        AppMethodBeat.m2504i(8806);
        m22843cA(context);
        AppMethodBeat.m2505o(8806);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(8807);
        m22843cA(context);
        AppMethodBeat.m2505o(8807);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(8808);
        m22843cA(context);
        AppMethodBeat.m2505o(8808);
    }

    /* renamed from: cA */
    private void m22843cA(Context context) {
        AppMethodBeat.m2504i(8809);
        this.cAw = new ImageView(context);
        this.cAw.setLayoutParams(new LayoutParams(C1338a.m2857am(context, C25738R.dimen.a2o), C1338a.m2857am(context, C25738R.dimen.a2o)));
        this.cAw.setScaleType(ScaleType.FIT_CENTER);
        this.cAw.setImageResource(C25738R.drawable.b6n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, C1338a.m2857am(context, C25738R.dimen.a2n), C1338a.m2857am(context, C25738R.dimen.a2n), 0);
        addView(this.cAw, layoutParams);
        AppMethodBeat.m2505o(8809);
    }

    /* renamed from: a */
    public final void mo26872a(FrameLayout frameLayout, final C14615a c14615a) {
        AppMethodBeat.m2504i(8810);
        if (getParent() == null && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            frameLayout.addView(this, layoutParams);
        }
        if (this.cAw != null) {
            this.cAw.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(8805);
                    if (c14615a != null) {
                        c14615a.bDJ();
                    }
                    AppMethodBeat.m2505o(8805);
                }
            });
        }
        this.uEu = true;
        AppMethodBeat.m2505o(8810);
    }
}
