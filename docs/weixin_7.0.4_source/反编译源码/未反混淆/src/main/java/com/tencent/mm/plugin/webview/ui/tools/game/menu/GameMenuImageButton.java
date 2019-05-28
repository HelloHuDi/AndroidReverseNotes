package com.tencent.mm.plugin.webview.ui.tools.game.menu;

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
import com.tencent.mm.R;

public class GameMenuImageButton extends LinearLayout {
    private ImageView cAw;
    public boolean uEu;

    public interface a {
        void bDJ();
    }

    public GameMenuImageButton(Context context) {
        super(context);
        AppMethodBeat.i(8806);
        cA(context);
        AppMethodBeat.o(8806);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(8807);
        cA(context);
        AppMethodBeat.o(8807);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(8808);
        cA(context);
        AppMethodBeat.o(8808);
    }

    private void cA(Context context) {
        AppMethodBeat.i(8809);
        this.cAw = new ImageView(context);
        this.cAw.setLayoutParams(new LayoutParams(com.tencent.mm.bz.a.am(context, R.dimen.a2o), com.tencent.mm.bz.a.am(context, R.dimen.a2o)));
        this.cAw.setScaleType(ScaleType.FIT_CENTER);
        this.cAw.setImageResource(R.drawable.b6n);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, com.tencent.mm.bz.a.am(context, R.dimen.a2n), com.tencent.mm.bz.a.am(context, R.dimen.a2n), 0);
        addView(this.cAw, layoutParams);
        AppMethodBeat.o(8809);
    }

    public final void a(FrameLayout frameLayout, final a aVar) {
        AppMethodBeat.i(8810);
        if (getParent() == null && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            frameLayout.addView(this, layoutParams);
        }
        if (this.cAw != null) {
            this.cAw.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(8805);
                    if (aVar != null) {
                        aVar.bDJ();
                    }
                    AppMethodBeat.o(8805);
                }
            });
        }
        this.uEu = true;
        AppMethodBeat.o(8810);
    }
}
