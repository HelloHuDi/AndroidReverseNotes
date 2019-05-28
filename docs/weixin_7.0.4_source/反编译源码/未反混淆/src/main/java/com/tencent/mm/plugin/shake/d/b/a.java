package com.tencent.mm.plugin.shake.d.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.platformtools.v.b;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class a extends BitmapDrawable implements com.tencent.mm.platformtools.x.a {
    private static final Paint feO;
    private static Bitmap quf;
    private ImageView mok;
    private int nnS;
    private String qud;
    private v que;
    private int type;
    private String username;

    static class a implements v {
        private String qud;

        public a(String str) {
            this.qud = str;
        }

        public final String anJ() {
            AppMethodBeat.i(24681);
            String UK = a.UK(this.qud);
            AppMethodBeat.o(24681);
            return UK;
        }

        public final String anK() {
            return this.qud;
        }

        public final String anL() {
            return this.qud;
        }

        public final String getCacheKey() {
            return this.qud;
        }

        public final boolean anM() {
            return true;
        }

        public final boolean anN() {
            return false;
        }

        public final Bitmap anO() {
            AppMethodBeat.i(24682);
            Bitmap decodeResource = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.ak_);
            AppMethodBeat.o(24682);
            return decodeResource;
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.v.a aVar, String str) {
            AppMethodBeat.i(24683);
            if (com.tencent.mm.platformtools.v.a.NET == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, a.UK(this.qud), false);
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                    ab.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
                }
            }
            ab.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", aVar.toString());
            AppMethodBeat.o(24683);
            return bitmap;
        }

        public final void anP() {
        }

        public final void V(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.v.a aVar, String str) {
        }

        public final b anI() {
            return null;
        }
    }

    static {
        AppMethodBeat.i(24688);
        Paint paint = new Paint();
        feO = paint;
        paint.setAntiAlias(true);
        feO.setFilterBitmap(true);
        AppMethodBeat.o(24688);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(24684);
        ab.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", this.username, this.qud, Integer.valueOf(this.type), toString());
        if (4 == this.type || (k.Cz(this.type) && 6 != this.type)) {
            Bitmap bitmap = null;
            if (4 == this.type) {
                this.que = new a(this.qud);
                bitmap = x.a(this.que);
            } else if (k.Cz(this.type) && 6 != this.type) {
                this.que = new com.tencent.mm.plugin.shake.e.b(this.qud);
                bitmap = x.a(this.que);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                ab.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", this.qud);
                bitmap = ab(this.mok, this.nnS);
            }
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, null, getBounds(), feO);
            }
            AppMethodBeat.o(24684);
            return;
        }
        AppMethodBeat.o(24684);
    }

    private static Bitmap ab(View view, int i) {
        AppMethodBeat.i(24685);
        Bitmap bitmap;
        if (view == null) {
            bitmap = quf;
            AppMethodBeat.o(24685);
            return bitmap;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (quf == null || quf.getWidth() != measuredWidth) {
            if (i > 0) {
                try {
                    quf = d.v(view.getResources().getDrawable(i));
                } catch (IOException e) {
                    ab.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                }
            } else {
                quf = BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bz.a.getDensity(null));
            }
            if (quf.getWidth() != measuredWidth && measuredWidth > 0 && measuredHeight > 0) {
                quf = Bitmap.createScaledBitmap(quf, measuredWidth, measuredHeight, true);
            }
        }
        bitmap = quf;
        AppMethodBeat.o(24685);
        return bitmap;
    }

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(24686);
        ab.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", Integer.valueOf(this.type), str, this.qud);
        if (this.que != null && str.equals(this.que.anL()) && (4 == this.type || (k.Cz(this.type) && 6 != this.type))) {
            this.mok.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24680);
                    a.this.mok.setImageBitmap(bitmap);
                    AppMethodBeat.o(24680);
                }
            });
        }
        AppMethodBeat.o(24686);
    }

    public static String UK(String str) {
        AppMethodBeat.i(24687);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
            AppMethodBeat.o(24687);
            return null;
        }
        if (bo.isNullOrNil(i.ckx())) {
            ab.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
            AppMethodBeat.o(24687);
            return null;
        }
        String format = String.format("%s/%s", new Object[]{i.ckx(), g.x(str.getBytes())});
        AppMethodBeat.o(24687);
        return format;
    }
}
