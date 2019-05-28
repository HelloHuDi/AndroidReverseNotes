package com.tencent.p177mm.plugin.record.p492b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.platformtools.C9791v;
import com.tencent.p177mm.platformtools.C9791v.C9792b;
import com.tencent.p177mm.platformtools.C9791v.C9793a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.record.b.p */
final class C28831p implements C9791v {
    private int height;
    private String mii;
    private String url;
    private int width;

    public C28831p(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(24175);
        this.mii = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        File file = new File(stringBuilder.append(C18628c.m29098Yg()).append("web/").toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(24175);
    }

    public final String anJ() {
        AppMethodBeat.m2504i(24176);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.m29098Yg()).append("web/").append(C1178g.m2591x(this.url.getBytes())).toString();
        AppMethodBeat.m2505o(24176);
        return stringBuilder2;
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
        AppMethodBeat.m2504i(24177);
        Bitmap decodeResource = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.akb);
        AppMethodBeat.m2505o(24177);
        return decodeResource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074 A:{SYNTHETIC, Splitter:B:30:0x0074} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A:{SYNTHETIC, Splitter:B:23:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str) {
        Throwable e;
        AppMethodBeat.m2504i(24178);
        if (C9793a.NET == c9793a) {
            try {
                C4990ab.m7419v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", this.url);
                if (this.width > 0 && this.height > 0) {
                    bitmap = C5056d.m7649b(bitmap, this.width, this.height, true);
                }
                File file = new File(anJ());
                file.createNewFile();
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(24178);
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(24178);
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                    C4990ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    AppMethodBeat.m2505o(24178);
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    AppMethodBeat.m2505o(24178);
                    throw e;
                }
            } catch (IOException e4) {
                C4990ab.printErrStackTrace("MicroMsg.FavGetPicStrategy", e4, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(24178);
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
