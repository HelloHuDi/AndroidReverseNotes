package com.tencent.p177mm.pluginsdk.p597ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1376bv.p1377a.C32428a;
import com.tencent.p177mm.p1376bv.p1377a.C32428a.C25995a;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;

/* renamed from: com.tencent.mm.pluginsdk.ui.b */
public final class C46503b extends C40459a implements C8915a {
    Bitmap jMX;
    private float vgO;

    private C46503b(String str) {
        super(C40460b.diS(), str);
        AppMethodBeat.m2504i(79665);
        this.vgO = 0.5f;
        this.jMX = null;
        AppMethodBeat.m2505o(79665);
    }

    public C46503b(String str, float f) {
        this(str);
        this.vgO = f;
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(79666);
        super.mo20342qj(str);
        AppMethodBeat.m2505o(79666);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(79667);
        String str = this.tag + "-" + this.vgO;
        C32428a c32428a = C25995a.xtT;
        if (c32428a != null) {
            bitmap = C25995a.xtT.mo53069PO(str);
        }
        if (bitmap == null || bitmap.isRecycled()) {
            if (this.vhI) {
                bitmap = this.pqK.mo8231b(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
            } else {
                bitmap = this.pqK.mo8232cQ(this.tag);
            }
            if (bitmap != null) {
                bitmap = C5056d.m7616a(bitmap, false, this.vgO * ((float) bitmap.getWidth()));
                if (c32428a != null) {
                    c32428a.mo53070p(str, bitmap);
                }
                if (!(bitmap == null || bitmap.isRecycled())) {
                    m87783a(canvas, bitmap);
                    AppMethodBeat.m2505o(79667);
                    return;
                }
            } else if (bitmap == null || bitmap.isRecycled()) {
                if (this.jMX == null) {
                    try {
                        this.jMX = C4977b.m7372b(C4996ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null));
                        this.jMX = C5056d.m7616a(this.jMX, false, this.vgO * ((float) this.jMX.getWidth()));
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.AvatarRoundDrawable", e, "", new Object[0]);
                    }
                }
                bitmap = this.jMX;
                if (!(bitmap == null || bitmap.isRecycled())) {
                    m87783a(canvas, bitmap);
                }
            }
            AppMethodBeat.m2505o(79667);
            return;
        }
        m87783a(canvas, bitmap);
        AppMethodBeat.m2505o(79667);
    }

    /* renamed from: a */
    private void m87783a(Canvas canvas, Bitmap bitmap) {
        AppMethodBeat.m2504i(79668);
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.vhN > 1.0f || this.oxB) {
            int height = (bitmap.getHeight() / 15) / 2;
            int width = (bitmap.getWidth() / 15) / 2;
            rect = new Rect(width, height, bitmap.getWidth() - width, bitmap.getHeight() - height);
        }
        canvas.drawBitmap(bitmap, rect, bounds, this.feO);
        AppMethodBeat.m2505o(79668);
    }

    /* renamed from: KK */
    public final void mo74720KK(int i) {
        AppMethodBeat.m2504i(138584);
        this.feO.setAlpha(i);
        AppMethodBeat.m2505o(138584);
    }
}
