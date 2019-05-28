package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.e;

public final class n extends i {
    public ImageView uVa;
    public MMPinProgressBtn uVb;
    public ImageView uVc;
    private ImageView uVd;

    public n(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27182);
        this.uVa = (ImageView) view.findViewById(R.id.l4);
        this.uVb = (MMPinProgressBtn) view.findViewById(R.id.af0);
        this.uVc = (ImageView) view.findViewById(R.id.aex);
        this.uVa.setImageResource(R.raw.shortvideo_play_btn);
        this.uVd = (ImageView) view.findViewById(R.id.cik);
        this.gCe.setVisibility(8);
        this.uUB.setVisibility(8);
        this.uVd.setVisibility(8);
        this.uUF.setTag(this);
        this.uUF.setOnClickListener(this.nij);
        AppMethodBeat.o(27182);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(c cVar, int i, int i2) {
        Bitmap bitmap;
        AppMethodBeat.i(27183);
        com.tencent.mm.plugin.wenote.model.a.k kVar = (com.tencent.mm.plugin.wenote.model.a.k) cVar;
        Bitmap ahk = com.tencent.mm.plugin.wenote.b.c.ahk(kVar.thumbPath);
        if (ahk == null && e.ct(kVar.cHg)) {
            ahk = com.tencent.mm.plugin.fav.ui.c.LY(kVar.cHg);
            if (ahk != null) {
                try {
                    if (e.ct(kVar.thumbPath)) {
                        e.deleteFile(kVar.thumbPath);
                    }
                    f.a(ahk, CompressFormat.JPEG, kVar.thumbPath, false);
                    bitmap = ahk;
                } catch (Exception e) {
                }
                if (bitmap == null) {
                    LayoutParams layoutParams = this.uVc.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.uVc.setLayoutParams(layoutParams);
                    this.uVc.setImageBitmap(bitmap);
                    this.uVc.setBackground(null);
                } else {
                    DisplayMetrics displayMetrics = this.uVc.getResources().getDisplayMetrics();
                    float f = (displayMetrics.density * 40.0f) + 0.5f;
                    LayoutParams layoutParams2 = this.uVc.getLayoutParams();
                    layoutParams2.width = displayMetrics.widthPixels - ((int) f);
                    layoutParams2.height = (layoutParams2.width * 52) / 68;
                    this.uVc.setLayoutParams(layoutParams2);
                }
                if (cVar.uOa) {
                    this.uVd.setVisibility(8);
                } else {
                    this.uVd.setVisibility(0);
                }
                super.a(cVar, i, i2);
                AppMethodBeat.o(27183);
            }
        }
        bitmap = ahk;
        if (bitmap == null) {
        }
        if (cVar.uOa) {
        }
        super.a(cVar, i, i2);
        AppMethodBeat.o(27183);
    }

    public final int dfW() {
        return 6;
    }
}
