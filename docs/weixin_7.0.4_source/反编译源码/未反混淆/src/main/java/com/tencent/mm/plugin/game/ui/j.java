package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class j extends BitmapDrawable implements com.tencent.mm.platformtools.x.a {
    private static Bitmap cdX;
    private static ak feP = new ak(Looper.getMainLooper());
    private Runnable feR;
    private String mUrl;
    private Bitmap nib;

    public static class a {

        /* renamed from: com.tencent.mm.plugin.game.ui.j$a$1 */
        static class AnonymousClass1 implements com.tencent.mm.sdk.e.k.a {
            final /* synthetic */ float hsC;
            final /* synthetic */ ImageView lvs;
            final /* synthetic */ String val$appId;

            AnonymousClass1(String str, float f, ImageView imageView) {
                this.val$appId = str;
                this.hsC = f;
                this.lvs = imageView;
            }

            public final void a(String str, m mVar) {
                AppMethodBeat.i(111906);
                if (this.val$appId.equals(str)) {
                    Bitmap b = g.b(this.val$appId, 1, this.hsC);
                    if (b != null) {
                        this.lvs.setImageBitmap(b);
                        com.tencent.mm.plugin.s.a.bYJ().d(this);
                    }
                }
                AppMethodBeat.o(111906);
            }
        }
    }

    static {
        AppMethodBeat.i(111912);
        AppMethodBeat.o(111912);
    }

    private j(String str) {
        Bitmap createBitmap;
        if (cdX == null || cdX.isRecycled()) {
            createBitmap = Bitmap.createBitmap(8, 8, Config.ARGB_8888);
            cdX = createBitmap;
        } else {
            createBitmap = cdX;
        }
        this(str, createBitmap);
        AppMethodBeat.i(111907);
        AppMethodBeat.o(111907);
    }

    private j(String str, Bitmap bitmap) {
        super(bitmap);
        AppMethodBeat.i(111908);
        this.feR = new Runnable() {
            public final void run() {
                AppMethodBeat.i(111905);
                j.this.invalidateSelf();
                AppMethodBeat.o(111905);
            }
        };
        Paint paint = getPaint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        x.a((com.tencent.mm.platformtools.x.a) this);
        setUrl(str);
        AppMethodBeat.o(111908);
    }

    public final void m(String str, Bitmap bitmap) {
        AppMethodBeat.i(111909);
        if (!(this.mUrl == null || !(this.mUrl.hashCode()).equals(str) || bitmap == null || bitmap.isRecycled())) {
            ab.i("MicroMsg.GameDrawable", "onGerPictureFinish() function has been invoke.");
            this.nib = bitmap;
            feP.post(this.feR);
        }
        AppMethodBeat.o(111909);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(111910);
        if (this.nib == null || this.nib.isRecycled()) {
            super.draw(canvas);
            AppMethodBeat.o(111910);
            return;
        }
        Rect bounds = getBounds();
        canvas.drawBitmap(this.nib, new Rect(0, 0, this.nib.getWidth(), this.nib.getHeight()), bounds, getPaint());
        AppMethodBeat.o(111910);
    }

    public final void setUrl(String str) {
        AppMethodBeat.i(111911);
        if (!(str == null || str.equals(this.mUrl))) {
            ab.i("MicroMsg.GameDrawable", "set a new url for the drawable,url:[%s]", str);
            this.mUrl = str;
            Bitmap a = x.a(new ai(this.mUrl));
            if (!(a == null || a.isRecycled())) {
                this.nib = a;
            }
            feP.post(this.feR);
        }
        AppMethodBeat.o(111911);
    }
}
