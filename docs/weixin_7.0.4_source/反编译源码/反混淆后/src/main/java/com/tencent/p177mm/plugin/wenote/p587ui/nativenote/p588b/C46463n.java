package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.plugin.fav.p410ui.C45932c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40366k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.pluginsdk.p1082i.C44053f;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.n */
public final class C46463n extends C14790i {
    public ImageView uVa;
    public MMPinProgressBtn uVb;
    public ImageView uVc;
    private ImageView uVd;

    public C46463n(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27182);
        this.uVa = (ImageView) view.findViewById(2131820981);
        this.uVb = (MMPinProgressBtn) view.findViewById(2131822136);
        this.uVc = (ImageView) view.findViewById(2131822133);
        this.uVa.setImageResource(C1318a.shortvideo_play_btn);
        this.uVd = (ImageView) view.findViewById(2131825005);
        this.gCe.setVisibility(8);
        this.uUB.setVisibility(8);
        this.uVd.setVisibility(8);
        this.uUF.setTag(this);
        this.uUF.setOnClickListener(this.nij);
        AppMethodBeat.m2505o(27182);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        Bitmap bitmap;
        AppMethodBeat.m2504i(27183);
        C40366k c40366k = (C40366k) c44001c;
        Bitmap ahk = C29977c.ahk(c40366k.thumbPath);
        if (ahk == null && C5730e.m8628ct(c40366k.cHg)) {
            ahk = C45932c.m85253LY(c40366k.cHg);
            if (ahk != null) {
                try {
                    if (C5730e.m8628ct(c40366k.thumbPath)) {
                        C5730e.deleteFile(c40366k.thumbPath);
                    }
                    C44053f.m79182a(ahk, CompressFormat.JPEG, c40366k.thumbPath, false);
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
                if (c44001c.uOa) {
                    this.uVd.setVisibility(8);
                } else {
                    this.uVd.setVisibility(0);
                }
                super.mo9809a(c44001c, i, i2);
                AppMethodBeat.m2505o(27183);
            }
        }
        bitmap = ahk;
        if (bitmap == null) {
        }
        if (c44001c.uOa) {
        }
        super.mo9809a(c44001c, i, i2);
        AppMethodBeat.m2505o(27183);
    }

    public final int dfW() {
        return 6;
    }
}
