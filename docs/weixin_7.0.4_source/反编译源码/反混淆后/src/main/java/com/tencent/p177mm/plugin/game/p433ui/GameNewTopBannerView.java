package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.GameNewTopBannerView */
public class GameNewTopBannerView extends FrameLayout implements OnClickListener {
    String hxK = null;
    Context mContext;
    int mXC;
    ImageView nfJ;
    ImageView nfK;
    int nlw;
    int nlx;
    String nly = "";
    private String nlz = "";

    public GameNewTopBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112121);
        super.onFinishInflate();
        this.nfJ = (ImageView) findViewById(2131824486);
        this.nfK = (ImageView) findViewById(2131824535);
        C4990ab.m7416i("MicroMsg.GameTopBannerView", "initView finished");
        AppMethodBeat.m2505o(112121);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final int mo68707b(ImageView imageView, int i, int i2) {
        AppMethodBeat.m2504i(112122);
        int screenWidth = C46001c.getScreenWidth(this.mContext);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            C4990ab.m7412e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
            AppMethodBeat.m2505o(112122);
            return 0;
        }
        layoutParams.height = (int) (((float) screenWidth) * (((float) i) / ((float) i2)));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ScaleType.FIT_XY);
        screenWidth = layoutParams.height;
        AppMethodBeat.m2505o(112122);
        return screenWidth;
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(112123);
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!C5046bo.isNullOrNil(str)) {
                C34277b.m56210a(this.mContext, 10, 1017, 1, C46001c.m85464t(this.mContext, str, "game_center_top_banner"), 0, null, this.mXC, 0, null, null, this.hxK);
            }
        }
        AppMethodBeat.m2505o(112123);
    }

    static void bFw() {
        AppMethodBeat.m2504i(112124);
        GameIndexListView.setDefaultPadding(0);
        GameIndexListView.setInitPadding(0);
        GameIndexListView.setCanPulldown(false);
        AppMethodBeat.m2505o(112124);
    }
}
