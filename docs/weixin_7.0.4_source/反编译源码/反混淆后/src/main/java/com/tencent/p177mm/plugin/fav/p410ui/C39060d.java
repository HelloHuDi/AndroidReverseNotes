package com.tencent.p177mm.plugin.fav.p410ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5731f;
import java.io.FileNotFoundException;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.fav.ui.d */
public final class C39060d implements C9791v {
    private int height;
    private String mii;
    private String url;
    private int width;

    public C39060d(String str, String str2, int i, int i2) {
        this.mii = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
    }

    public final C9792b anI() {
        return null;
    }

    public final String anJ() {
        AppMethodBeat.m2504i(73997);
        String str = C39037b.bue() + C1178g.m2591x(this.url.getBytes());
        AppMethodBeat.m2505o(73997);
        return str;
    }

    public final String anK() {
        return this.url;
    }

    public final String anL() {
        return this.mii;
    }

    public final String getCacheKey() {
        return this.mii;
    }

    public final boolean anM() {
        return true;
    }

    public final boolean anN() {
        return false;
    }

    public final Bitmap anO() {
        AppMethodBeat.m2504i(73998);
        Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.akb);
        AppMethodBeat.m2505o(73998);
        return decodeResource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A:{SYNTHETIC, Splitter:B:26:0x0072} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087 A:{SYNTHETIC, Splitter:B:33:0x0087} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
        Throwable e;
        AppMethodBeat.m2504i(73999);
        if (C9793a.NET == c9793a) {
            try {
                C4990ab.m7419v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", this.url);
                C5728b c5728b = new C5728b(C39037b.bue());
                if (!c5728b.exists()) {
                    c5728b.mkdirs();
                }
                if (this.width > 0 && this.height > 0) {
                    bitmap = C5056d.m7649b(bitmap, this.width, this.height, true);
                }
                C5728b c5728b2 = new C5728b(anJ());
                c5728b2.createNewFile();
                C5731f c5731f;
                try {
                    c5731f = new C5731f(c5728b2);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, c5731f);
                        c5731f.flush();
                        c5731f.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                            if (c5731f != null) {
                                c5731f.close();
                            }
                            AppMethodBeat.m2505o(73999);
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (c5731f != null) {
                                c5731f.close();
                            }
                            AppMethodBeat.m2505o(73999);
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    c5731f = null;
                    C4990ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                    if (c5731f != null) {
                    }
                    AppMethodBeat.m2505o(73999);
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    c5731f = null;
                    if (c5731f != null) {
                    }
                    AppMethodBeat.m2505o(73999);
                    throw e;
                }
            } catch (IOException e4) {
                C4990ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e4, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(73999);
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
}
