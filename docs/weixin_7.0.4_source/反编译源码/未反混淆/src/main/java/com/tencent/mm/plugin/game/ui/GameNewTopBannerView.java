package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

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
        AppMethodBeat.i(112121);
        super.onFinishInflate();
        this.nfJ = (ImageView) findViewById(R.id.c5j);
        this.nfK = (ImageView) findViewById(R.id.c6v);
        ab.i("MicroMsg.GameTopBannerView", "initView finished");
        AppMethodBeat.o(112121);
    }

    /* Access modifiers changed, original: final */
    public final int b(ImageView imageView, int i, int i2) {
        AppMethodBeat.i(112122);
        int screenWidth = c.getScreenWidth(this.mContext);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            ab.e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
            AppMethodBeat.o(112122);
            return 0;
        }
        layoutParams.height = (int) (((float) screenWidth) * (((float) i) / ((float) i2)));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ScaleType.FIT_XY);
        screenWidth = layoutParams.height;
        AppMethodBeat.o(112122);
        return screenWidth;
    }

    public void onClick(View view) {
        AppMethodBeat.i(112123);
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!bo.isNullOrNil(str)) {
                b.a(this.mContext, 10, 1017, 1, c.t(this.mContext, str, "game_center_top_banner"), 0, null, this.mXC, 0, null, null, this.hxK);
            }
        }
        AppMethodBeat.o(112123);
    }

    static void bFw() {
        AppMethodBeat.i(112124);
        GameIndexListView.setDefaultPadding(0);
        GameIndexListView.setInitPadding(0);
        GameIndexListView.setCanPulldown(false);
        AppMethodBeat.o(112124);
    }
}
