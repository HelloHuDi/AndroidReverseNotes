package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.game.d.dr;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public class GameIndexWxagView extends LinearLayout implements OnClickListener {
    ViewGroup mContainer = this;
    LayoutInflater mInflater = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    int mXC;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexWxagView$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ int nfb;

        AnonymousClass1(int i) {
            this.nfb = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(111988);
            if (view.getTag() == null || !(view.getTag() instanceof dr)) {
                AppMethodBeat.o(111988);
                return;
            }
            dr drVar = (dr) view.getTag();
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA;
            ((e) g.K(e.class)).a(GameIndexWxagView.this.getContext(), drVar.jBB, drVar.fKh, drVar.ndQ, 0, drVar.ndP, appBrandStatObject);
            b.a(GameIndexWxagView.this.getContext(), 10, 1025, 999, 30, drVar.fKh, this.nfb, null);
            AppMethodBeat.o(111988);
        }
    }

    static class a {
        public int mYy;
        public dr njp;

        public a(int i, dr drVar) {
            this.mYy = i;
            this.njp = drVar;
        }
    }

    public GameIndexWxagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111989);
        setOrientation(1);
        AppMethodBeat.o(111989);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111990);
        super.onFinishInflate();
        ab.i("MicroMsg.GameIndexWxagView", "initView finished");
        AppMethodBeat.o(111990);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111991);
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            AppMethodBeat.o(111991);
            return;
        }
        a aVar = (a) view.getTag();
        if (aVar.njp == null) {
            AppMethodBeat.o(111991);
            return;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA;
        ((e) g.K(e.class)).a(getContext(), aVar.njp.jBB, aVar.njp.fKh, aVar.njp.ndQ, 0, aVar.njp.ndP, appBrandStatObject);
        b.a(getContext(), 10, 1025, aVar.mYy, 30, aVar.njp.fKh, this.mXC, null);
        AppMethodBeat.o(111991);
    }
}
