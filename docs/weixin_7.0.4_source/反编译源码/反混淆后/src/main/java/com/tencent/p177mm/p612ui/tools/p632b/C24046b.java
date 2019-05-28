package com.tencent.p177mm.p612ui.tools.p632b;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.tools.b.b */
public final class C24046b extends C5580a {
    private int mHeight = 2048;
    public int mSize = 104857600;
    private int mWidth = 2048;
    private String zIs;
    public int zIt = 0;
    public int zIu = 0;
    public int zIv = 0;
    private C24047a zIw;

    /* renamed from: com.tencent.mm.ui.tools.b.b$a */
    public interface C24047a {
        /* renamed from: a */
        void mo15114a(C24046b c24046b);

        void bln();
    }

    private C24046b(String str) {
        this.zIs = str;
    }

    public static C24046b asm(String str) {
        AppMethodBeat.m2504i(107829);
        C24046b c24046b = new C24046b(str);
        AppMethodBeat.m2505o(107829);
        return c24046b;
    }

    /* renamed from: PL */
    public final C24046b mo39850PL(int i) {
        this.mWidth = i;
        this.mHeight = i;
        return this;
    }

    /* renamed from: a */
    public final void mo39851a(C24047a c24047a) {
        AppMethodBeat.m2504i(107830);
        this.zIw = c24047a;
        dkS();
        AppMethodBeat.m2505o(107830);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int aAa() {
        boolean z;
        AppMethodBeat.m2504i(107831);
        if (C5046bo.isNullOrNil(this.zIs)) {
            C4990ab.m7420w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
        }
        this.zIt = C1173e.m2560cs(this.zIs);
        String str = this.zIs;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        this.zIu = options.outWidth;
        this.zIv = options.outHeight;
        if (this.zIt <= this.mSize) {
            if (this.zIt < 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                z = true;
                if (this.zIu > this.mWidth || this.zIv > this.mHeight) {
                    C4990ab.m7411d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", Integer.valueOf(this.zIu), Integer.valueOf(this.zIv));
                    z = false;
                }
                if (z) {
                    AppMethodBeat.m2505o(107831);
                    return 1;
                }
                C4990ab.m7416i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
                AppMethodBeat.m2505o(107831);
                return 0;
            }
        }
        C4990ab.m7411d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", Integer.valueOf(this.zIt));
        z = false;
        C4990ab.m7411d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", Integer.valueOf(this.zIu), Integer.valueOf(this.zIv));
        z = false;
        if (z) {
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void dkS() {
        AppMethodBeat.m2504i(107832);
        if (this.zIw == null) {
            C4990ab.m7420w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
            AppMethodBeat.m2505o(107832);
            return;
        }
        switch (aAa()) {
            case 0:
                this.zIw.mo15114a(this);
                AppMethodBeat.m2505o(107832);
                return;
            case 1:
                this.zIw.bln();
                break;
        }
        AppMethodBeat.m2505o(107832);
    }
}
