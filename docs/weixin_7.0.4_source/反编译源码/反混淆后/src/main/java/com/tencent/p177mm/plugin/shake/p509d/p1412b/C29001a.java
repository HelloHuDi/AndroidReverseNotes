package com.tencent.p177mm.plugin.shake.p509d.p1412b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.plugin.shake.p1296e.C29004b;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3826k;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C39695i;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.shake.d.b.a */
public final class C29001a extends BitmapDrawable implements C18765a {
    private static final Paint feO;
    private static Bitmap quf;
    private ImageView mok;
    private int nnS;
    private String qud;
    private C9791v que;
    private int type;
    private String username;

    /* renamed from: com.tencent.mm.plugin.shake.d.b.a$a */
    static class C29003a implements C9791v {
        private String qud;

        public C29003a(String str) {
            this.qud = str;
        }

        public final String anJ() {
            AppMethodBeat.m2504i(24681);
            String UK = C29001a.m46039UK(this.qud);
            AppMethodBeat.m2505o(24681);
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
            AppMethodBeat.m2504i(24682);
            Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.ak_);
            AppMethodBeat.m2505o(24682);
            return decodeResource;
        }

        /* renamed from: a */
        public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
            AppMethodBeat.m2504i(24683);
            if (C9793a.NET == c9793a) {
                try {
                    C5056d.m7625a(bitmap, 100, CompressFormat.PNG, C29001a.m46039UK(this.qud), false);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                    C4990ab.m7420w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
                }
            }
            C4990ab.m7411d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", c9793a.toString());
            AppMethodBeat.m2505o(24683);
            return bitmap;
        }

        public final void anP() {
        }

        /* renamed from: V */
        public final void mo9516V(String str, boolean z) {
        }

        /* renamed from: a */
        public final void mo9518a(C9793a c9793a, String str) {
        }

        public final C9792b anI() {
            return null;
        }
    }

    static {
        AppMethodBeat.m2504i(24688);
        Paint paint = new Paint();
        feO = paint;
        paint.setAntiAlias(true);
        feO.setFilterBitmap(true);
        AppMethodBeat.m2505o(24688);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(24684);
        C4990ab.m7417i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", this.username, this.qud, Integer.valueOf(this.type), toString());
        if (4 == this.type || (C3826k.m6119Cz(this.type) && 6 != this.type)) {
            Bitmap bitmap = null;
            if (4 == this.type) {
                this.que = new C29003a(this.qud);
                bitmap = C18764x.m29325a(this.que);
            } else if (C3826k.m6119Cz(this.type) && 6 != this.type) {
                this.que = new C29004b(this.qud);
                bitmap = C18764x.m29325a(this.que);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                C4990ab.m7417i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", this.qud);
                bitmap = C29001a.m46041ab(this.mok, this.nnS);
            }
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, null, getBounds(), feO);
            }
            AppMethodBeat.m2505o(24684);
            return;
        }
        AppMethodBeat.m2505o(24684);
    }

    /* renamed from: ab */
    private static Bitmap m46041ab(View view, int i) {
        AppMethodBeat.m2504i(24685);
        Bitmap bitmap;
        if (view == null) {
            bitmap = quf;
            AppMethodBeat.m2505o(24685);
            return bitmap;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (quf == null || quf.getWidth() != measuredWidth) {
            if (i > 0) {
                try {
                    quf = C5056d.m7668v(view.getResources().getDrawable(i));
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                }
            } else {
                quf = C4977b.m7372b(C4996ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), C1338a.getDensity(null));
            }
            if (quf.getWidth() != measuredWidth && measuredWidth > 0 && measuredHeight > 0) {
                quf = Bitmap.createScaledBitmap(quf, measuredWidth, measuredHeight, true);
            }
        }
        bitmap = quf;
        AppMethodBeat.m2505o(24685);
        return bitmap;
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(24686);
        C4990ab.m7417i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", Integer.valueOf(this.type), str, this.qud);
        if (this.que != null && str.equals(this.que.anL()) && (4 == this.type || (C3826k.m6119Cz(this.type) && 6 != this.type))) {
            this.mok.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24680);
                    C29001a.this.mok.setImageBitmap(bitmap);
                    AppMethodBeat.m2505o(24680);
                }
            });
        }
        AppMethodBeat.m2505o(24686);
    }

    /* renamed from: UK */
    public static String m46039UK(String str) {
        AppMethodBeat.m2504i(24687);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
            AppMethodBeat.m2505o(24687);
            return null;
        }
        if (C5046bo.isNullOrNil(C39695i.ckx())) {
            C4990ab.m7420w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
            AppMethodBeat.m2505o(24687);
            return null;
        }
        String format = String.format("%s/%s", new Object[]{C39695i.ckx(), C1178g.m2591x(str.getBytes())});
        AppMethodBeat.m2505o(24687);
        return format;
    }
}
