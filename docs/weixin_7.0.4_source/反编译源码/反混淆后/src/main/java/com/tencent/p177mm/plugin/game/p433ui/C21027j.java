package com.tencent.p177mm.plugin.game.p433ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.game.model.C16773ai;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.game.ui.j */
public final class C21027j extends BitmapDrawable implements C18765a {
    private static Bitmap cdX;
    private static C7306ak feP = new C7306ak(Looper.getMainLooper());
    private Runnable feR;
    private String mUrl;
    private Bitmap nib;

    /* renamed from: com.tencent.mm.plugin.game.ui.j$1 */
    class C210281 implements Runnable {
        C210281() {
        }

        public final void run() {
            AppMethodBeat.m2504i(111905);
            C21027j.this.invalidateSelf();
            AppMethodBeat.m2505o(111905);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.j$a */
    public static class C21029a {

        /* renamed from: com.tencent.mm.plugin.game.ui.j$a$1 */
        static class C210301 implements C4931a {
            final /* synthetic */ float hsC;
            final /* synthetic */ ImageView lvs;
            final /* synthetic */ String val$appId;

            C210301(String str, float f, ImageView imageView) {
                this.val$appId = str;
                this.hsC = f;
                this.lvs = imageView;
            }

            /* renamed from: a */
            public final void mo5248a(String str, C4935m c4935m) {
                AppMethodBeat.m2504i(111906);
                if (this.val$appId.equals(str)) {
                    Bitmap b = C46494g.m87732b(this.val$appId, 1, this.hsC);
                    if (b != null) {
                        this.lvs.setImageBitmap(b);
                        C34832a.bYJ().mo10117d(this);
                    }
                }
                AppMethodBeat.m2505o(111906);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(111912);
        AppMethodBeat.m2505o(111912);
    }

    private C21027j(String str) {
        Bitmap createBitmap;
        if (cdX == null || cdX.isRecycled()) {
            createBitmap = Bitmap.createBitmap(8, 8, Config.ARGB_8888);
            cdX = createBitmap;
        } else {
            createBitmap = cdX;
        }
        this(str, createBitmap);
        AppMethodBeat.m2504i(111907);
        AppMethodBeat.m2505o(111907);
    }

    private C21027j(String str, Bitmap bitmap) {
        super(bitmap);
        AppMethodBeat.m2504i(111908);
        this.feR = new C210281();
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        C18764x.m29326a((C18765a) this);
        setUrl(str);
        AppMethodBeat.m2505o(111908);
    }

    /* renamed from: m */
    public final void mo8136m(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(111909);
        if (!(this.mUrl == null || !(this.mUrl.hashCode()).equals(str) || bitmap == null || bitmap.isRecycled())) {
            C4990ab.m7416i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
            this.nib = bitmap;
            feP.post(this.feR);
        }
        AppMethodBeat.m2505o(111909);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(111910);
        if (this.nib == null || this.nib.isRecycled()) {
            super.draw(canvas);
            AppMethodBeat.m2505o(111910);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.nib, new Rect(0, 0, this.nib.getWidth(), this.nib.getHeight()), bounds, getPaint());
        AppMethodBeat.m2505o(111910);
    }

    public final void setUrl(String str) {
        AppMethodBeat.m2504i(111911);
        if (!(str == null || str.equals(this.mUrl))) {
            C4990ab.m7417i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", str);
            this.mUrl = str;
            Bitmap a = C18764x.m29325a(new C16773ai(this.mUrl));
            if (!(a == null || a.isRecycled())) {
                this.nib = a;
            }
            feP.post(this.feR);
        }
        AppMethodBeat.m2505o(111911);
    }
}
