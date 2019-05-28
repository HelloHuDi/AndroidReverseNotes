package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.e;
import com.tencent.mm.api.g;
import com.tencent.mm.api.n;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s;
import com.tencent.mm.api.s.a.a;
import com.tencent.mm.api.s.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.IOException;

public class TestVideoEditUI extends MMActivity implements g {
    private s oDy;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55296);
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.m5);
        this.oDy = s.ccQ.Ae();
        s sVar = this.oDy;
        a aVar = new a();
        aVar.ccS = false;
        aVar.ccU = true;
        aVar.ccV = new Rect(0, 0, FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN, FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN);
        aVar.ccR = c.VIDEO;
        sVar.a(aVar.AB());
        com.tencent.mm.api.c aQ = this.oDy.aQ(this.mController.ylL);
        aQ.setActionBarCallback(this);
        frameLayout.addView(aQ, new LayoutParams(-1, -1));
        aQ.setSelectedFeatureListener(new r() {
            public final void a(e eVar) {
                AppMethodBeat.i(55292);
                ab.i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", eVar.name());
                AppMethodBeat.o(55292);
            }

            public final void a(e eVar, int i) {
                AppMethodBeat.i(55293);
                ab.i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", eVar.name(), Integer.valueOf(i));
                AppMethodBeat.o(55293);
            }

            public final void bd(boolean z) {
                AppMethodBeat.i(55294);
                if (z) {
                    TestVideoEditUI.this.showVKB();
                    AppMethodBeat.o(55294);
                    return;
                }
                TestVideoEditUI.this.hideVKB(TestVideoEditUI.this.mController.contentView);
                AppMethodBeat.o(55294);
            }
        });
        AppMethodBeat.o(55296);
    }

    public void onDestroy() {
        AppMethodBeat.i(55297);
        super.onDestroy();
        this.oDy.onDestroy();
        AppMethodBeat.o(55297);
    }

    public void onBackPressed() {
        AppMethodBeat.i(55298);
        if (!this.oDy.Ab()) {
            finish();
        }
        AppMethodBeat.o(55298);
    }

    public void onSwipeBack() {
        AppMethodBeat.i(55299);
        super.onSwipeBack();
        AppMethodBeat.o(55299);
    }

    public final int getLayoutId() {
        return R.layout.azk;
    }

    public final void onFinish() {
        AppMethodBeat.i(55300);
        this.oDy.a(new n() {
            public final void onError(Exception exception) {
            }

            public final void b(Bitmap bitmap, boolean z) {
                AppMethodBeat.i(55295);
                ab.i("MicroMsg.TestVideoEditUI", "[onSuccess] w:%s h:%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, com.tencent.mm.compatible.util.e.evi + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), "png"}), true);
                    AppMethodBeat.o(55295);
                } catch (IOException e) {
                    AppMethodBeat.o(55295);
                }
            }
        });
        AppMethodBeat.o(55300);
    }

    public final void onExit() {
        AppMethodBeat.i(55301);
        finish();
        AppMethodBeat.o(55301);
    }
}
