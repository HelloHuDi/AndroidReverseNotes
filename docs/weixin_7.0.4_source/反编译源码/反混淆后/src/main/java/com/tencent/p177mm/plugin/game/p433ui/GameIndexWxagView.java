package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p731d.C43169dr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.game.ui.GameIndexWxagView */
public class GameIndexWxagView extends LinearLayout implements OnClickListener {
    ViewGroup mContainer = this;
    LayoutInflater mInflater = ((LayoutInflater) getContext().getSystemService("layout_inflater"));
    int mXC;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexWxagView$1 */
    class C121821 implements OnClickListener {
        final /* synthetic */ int nfb;

        C121821(int i) {
            this.nfb = i;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(111988);
            if (view.getTag() == null || !(view.getTag() instanceof C43169dr)) {
                AppMethodBeat.m2505o(111988);
                return;
            }
            C43169dr c43169dr = (C43169dr) view.getTag();
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA;
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(GameIndexWxagView.this.getContext(), c43169dr.jBB, c43169dr.fKh, c43169dr.ndQ, 0, c43169dr.ndP, appBrandStatObject);
            C34277b.m56211a(GameIndexWxagView.this.getContext(), 10, 1025, 999, 30, c43169dr.fKh, this.nfb, null);
            AppMethodBeat.m2505o(111988);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexWxagView$a */
    static class C12183a {
        public int mYy;
        public C43169dr njp;

        public C12183a(int i, C43169dr c43169dr) {
            this.mYy = i;
            this.njp = c43169dr;
        }
    }

    public GameIndexWxagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(111989);
        setOrientation(1);
        AppMethodBeat.m2505o(111989);
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111990);
        super.onFinishInflate();
        C4990ab.m7416i("MicroMsg.GameIndexWxagView", "initView finished");
        AppMethodBeat.m2505o(111990);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111991);
        if (view.getTag() == null || !(view.getTag() instanceof C12183a)) {
            AppMethodBeat.m2505o(111991);
            return;
        }
        C12183a c12183a = (C12183a) view.getTag();
        if (c12183a.njp == null) {
            AppMethodBeat.m2505o(111991);
            return;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN_BACKCAMERA;
        ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(getContext(), c12183a.njp.jBB, c12183a.njp.fKh, c12183a.njp.ndQ, 0, c12183a.njp.ndP, appBrandStatObject);
        C34277b.m56211a(getContext(), 10, 1025, c12183a.mYy, 30, c12183a.njp.fKh, this.mXC, null);
        AppMethodBeat.m2505o(111991);
    }
}
