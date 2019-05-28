package com.tencent.mm.ui.tools.b;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends a {
    private int mHeight = 2048;
    public int mSize = 104857600;
    private int mWidth = 2048;
    private String zIs;
    public int zIt = 0;
    public int zIu = 0;
    public int zIv = 0;
    private a zIw;

    public interface a {
        void a(b bVar);

        void bln();
    }

    private b(String str) {
        this.zIs = str;
    }

    public static b asm(String str) {
        AppMethodBeat.i(107829);
        b bVar = new b(str);
        AppMethodBeat.o(107829);
        return bVar;
    }

    public final b PL(int i) {
        this.mWidth = i;
        this.mHeight = i;
        return this;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(107830);
        this.zIw = aVar;
        dkS();
        AppMethodBeat.o(107830);
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int aAa() {
        boolean z;
        AppMethodBeat.i(107831);
        if (bo.isNullOrNil(this.zIs)) {
            ab.w("MicroMsg.ImageBoundaryCheck", "dz[check image but path is null or nil]");
        }
        this.zIt = e.cs(this.zIs);
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
                    ab.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", Integer.valueOf(this.zIu), Integer.valueOf(this.zIv));
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(107831);
                    return 1;
                }
                ab.i("MicroMsg.ImageBoundaryCheck", "dz[status ok]");
                AppMethodBeat.o(107831);
                return 0;
            }
        }
        ab.d("MicroMsg.ImageBoundaryCheck", "dz[over size] size = %d", Integer.valueOf(this.zIt));
        z = false;
        ab.d("MicroMsg.ImageBoundaryCheck", "dz[over width or height] width = %d, height = %d", Integer.valueOf(this.zIu), Integer.valueOf(this.zIv));
        z = false;
        if (z) {
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void dkS() {
        AppMethodBeat.i(107832);
        if (this.zIw == null) {
            ab.w("MicroMsg.ImageBoundaryCheck", "dz[callback is null]");
            AppMethodBeat.o(107832);
            return;
        }
        switch (aAa()) {
            case 0:
                this.zIw.a(this);
                AppMethodBeat.o(107832);
                return;
            case 1:
                this.zIw.bln();
                break;
        }
        AppMethodBeat.o(107832);
    }
}
