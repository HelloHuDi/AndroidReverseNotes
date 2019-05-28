package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C1241c;
import com.tencent.p177mm.api.C25784s;
import com.tencent.p177mm.api.C25784s.C25785a.C17916a;
import com.tencent.p177mm.api.C25784s.C8957c;
import com.tencent.p177mm.api.C32247e;
import com.tencent.p177mm.api.C32249g;
import com.tencent.p177mm.api.C37464n;
import com.tencent.p177mm.api.C8956r;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI */
public class TestVideoEditUI extends MMActivity implements C32249g {
    private C25784s oDy;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI$1 */
    class C125931 implements C8956r {
        C125931() {
        }

        /* renamed from: a */
        public final void mo4525a(C32247e c32247e) {
            AppMethodBeat.m2504i(55292);
            C4990ab.m7417i("MicroMsg.TestVideoEditUI", "[onSelectedFeature] features:%s", c32247e.name());
            AppMethodBeat.m2505o(55292);
        }

        /* renamed from: a */
        public final void mo4526a(C32247e c32247e, int i) {
            AppMethodBeat.m2504i(55293);
            C4990ab.m7417i("MicroMsg.TestVideoEditUI", "[onSelectedDetailFeature] features:%s index:%s", c32247e.name(), Integer.valueOf(i));
            AppMethodBeat.m2505o(55293);
        }

        /* renamed from: bd */
        public final void mo4527bd(boolean z) {
            AppMethodBeat.m2504i(55294);
            if (z) {
                TestVideoEditUI.this.showVKB();
                AppMethodBeat.m2505o(55294);
                return;
            }
            TestVideoEditUI.this.hideVKB(TestVideoEditUI.this.mController.contentView);
            AppMethodBeat.m2505o(55294);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI$2 */
    class C125942 implements C37464n {
        C125942() {
        }

        public final void onError(Exception exception) {
        }

        /* renamed from: b */
        public final void mo7985b(Bitmap bitmap, boolean z) {
            AppMethodBeat.m2504i(55295);
            C4990ab.m7417i("MicroMsg.TestVideoEditUI", "[onSuccess] w:%s h:%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
            try {
                C5056d.m7625a(bitmap, 100, CompressFormat.PNG, C6457e.evi + String.format("%s%d.%s", new Object[]{"wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), "png"}), true);
                AppMethodBeat.m2505o(55295);
            } catch (IOException e) {
                AppMethodBeat.m2505o(55295);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(55296);
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131821019);
        this.oDy = C25784s.ccQ.mo33296Ae();
        C25784s c25784s = this.oDy;
        C17916a c17916a = new C17916a();
        c17916a.ccS = false;
        c17916a.ccU = true;
        c17916a.ccV = new Rect(0, 0, FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN, FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN);
        c17916a.ccR = C8957c.VIDEO;
        c25784s.mo33293a(c17916a.mo33430AB());
        C1241c aQ = this.oDy.mo33294aQ(this.mController.ylL);
        aQ.setActionBarCallback(this);
        frameLayout.addView(aQ, new LayoutParams(-1, -1));
        aQ.setSelectedFeatureListener(new C125931());
        AppMethodBeat.m2505o(55296);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(55297);
        super.onDestroy();
        this.oDy.onDestroy();
        AppMethodBeat.m2505o(55297);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(55298);
        if (!this.oDy.mo33289Ab()) {
            finish();
        }
        AppMethodBeat.m2505o(55298);
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(55299);
        super.onSwipeBack();
        AppMethodBeat.m2505o(55299);
    }

    public final int getLayoutId() {
        return 2130970923;
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(55300);
        this.oDy.mo33292a(new C125942());
        AppMethodBeat.m2505o(55300);
    }

    public final void onExit() {
        AppMethodBeat.m2504i(55301);
        finish();
        AppMethodBeat.m2505o(55301);
    }
}
