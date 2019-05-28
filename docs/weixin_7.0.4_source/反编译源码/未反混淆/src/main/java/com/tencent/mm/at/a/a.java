package com.tencent.mm.at.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.b;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.b.h;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

public final class a {
    private static a fGJ = null;
    private b fGG;
    private b fGH;
    private final i fGI = new h();

    public static synchronized a ahv() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(116017);
            if (fGJ == null) {
                fGJ = new a(ah.getContext());
            }
            aVar = fGJ;
            AppMethodBeat.o(116017);
        }
        return aVar;
    }

    public a(Context context) {
        AppMethodBeat.i(116018);
        a(b.bZ(context));
        AppMethodBeat.o(116018);
    }

    public a(b bVar) {
        AppMethodBeat.i(116019);
        a(bVar);
        AppMethodBeat.o(116019);
    }

    private synchronized void a(b bVar) {
        AppMethodBeat.i(116020);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[cpan] image loader configuration is null.");
            AppMethodBeat.o(116020);
            throw illegalArgumentException;
        } else if (this.fGH == null) {
            this.fGG = new b(bVar);
            this.fGH = bVar;
            AppMethodBeat.o(116020);
        } else {
            ab.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
            AppMethodBeat.o(116020);
        }
    }

    public final void a(String str, ImageView imageView) {
        AppMethodBeat.i(116021);
        b(str, imageView, null, null, null);
        AppMethodBeat.o(116021);
    }

    public final void a(String str, ImageView imageView, g gVar) {
        AppMethodBeat.i(116022);
        b(str, imageView, null, null, gVar);
        AppMethodBeat.o(116022);
    }

    public final void a(String str, ImageView imageView, c cVar, g gVar) {
        AppMethodBeat.i(116023);
        b(str, imageView, cVar, null, gVar);
        AppMethodBeat.o(116023);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar, g gVar) {
        AppMethodBeat.i(116024);
        b(str, imageView, cVar, iVar, gVar);
        AppMethodBeat.o(116024);
    }

    public final void a(String str, ImageView imageView, c cVar) {
        AppMethodBeat.i(116025);
        b(str, imageView, cVar, null, null);
        AppMethodBeat.o(116025);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar) {
        AppMethodBeat.i(116026);
        b(str, imageView, cVar, iVar, null);
        AppMethodBeat.o(116026);
    }

    private void b(String str, ImageView imageView, c cVar, i iVar, g gVar) {
        c cVar2;
        i iVar2;
        AppMethodBeat.i(116027);
        if (cVar == null) {
            cVar2 = this.fGH.fGS;
        } else {
            cVar2 = cVar;
        }
        if (iVar == null) {
            iVar2 = this.fGI;
        } else {
            iVar2 = iVar;
        }
        c cVar3 = new c(imageView, str);
        a(imageView, cVar2);
        if (bo.isNullOrNil(str)) {
            ab.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
            b(imageView, cVar2);
            this.fGG.a(cVar3);
            iVar2.a(str, imageView, null, cVar2.eQd);
            AppMethodBeat.o(116027);
            return;
        }
        com.tencent.mm.at.a.f.b bVar = new com.tencent.mm.at.a.f.b(str, cVar3, a(cVar2), cVar2, iVar2, this.fGG, gVar);
        Bitmap sB = this.fGG.sB(bVar.sJ(str));
        if (sB == null || sB.isRecycled()) {
            if (imageView != null) {
                b(imageView, cVar2);
            }
            if ((bVar.fGS.ePI || !this.fGG.DA()) && this.fGG.a(cVar3, str)) {
                this.fGG.a(bVar);
                this.fGG.a(bVar, cVar2.ePG);
            }
            AppMethodBeat.o(116027);
            return;
        }
        ab.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", r3);
        if (cVar2.fHf) {
            sB = d.e(sB, cVar2.fHg);
        }
        if (imageView != null) {
            imageView.setImageBitmap(sB);
        }
        bVar.fN(0);
        if (gVar != null) {
            gVar.b(str, imageView, new com.tencent.mm.at.a.d.b(sB));
        }
        this.fGG.a(cVar3);
        AppMethodBeat.o(116027);
    }

    public final void b(String str, ImageView imageView) {
        AppMethodBeat.i(116028);
        this.fGG.a(new c(imageView, str));
        AppMethodBeat.o(116028);
    }

    public final void cm(int i) {
        AppMethodBeat.i(116029);
        ab.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", Integer.valueOf(i));
        if (i == 0 || i == 1) {
            ab.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
            this.fGG.fGL.resume();
            AppMethodBeat.o(116029);
            return;
        }
        ab.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
        this.fGG.fGL.pause();
        AppMethodBeat.o(116029);
    }

    public final void detach() {
        AppMethodBeat.i(116030);
        if (this.fGG != null) {
            this.fGG.ahw();
        }
        AppMethodBeat.o(116030);
    }

    public final Bitmap sB(String str) {
        AppMethodBeat.i(116031);
        if (this.fGG != null) {
            Bitmap sB = this.fGG.sB(str);
            AppMethodBeat.o(116031);
            return sB;
        }
        AppMethodBeat.o(116031);
        return null;
    }

    public final void j(String str, Bitmap bitmap) {
        AppMethodBeat.i(116032);
        if (this.fGG != null) {
            b bVar = this.fGG;
            if (bVar.fGK != null) {
                bVar.fGK.fGT.c(str, bitmap);
            }
        }
        AppMethodBeat.o(116032);
    }

    private void a(ImageView imageView, c cVar) {
        AppMethodBeat.i(116033);
        if (imageView == null || cVar == null) {
            ab.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
            AppMethodBeat.o(116033);
        } else if (!cVar.ahB()) {
            imageView.setBackgroundDrawable(null);
            AppMethodBeat.o(116033);
        } else if (cVar.ePV == 0) {
            imageView.setBackgroundDrawable(cVar.e(this.fGH.aEH));
            AppMethodBeat.o(116033);
        } else {
            imageView.setBackgroundResource(cVar.ePV);
            AppMethodBeat.o(116033);
        }
    }

    private void b(ImageView imageView, c cVar) {
        AppMethodBeat.i(116034);
        if (imageView == null || cVar == null) {
            ab.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
            AppMethodBeat.o(116034);
        } else if (!cVar.ahA()) {
            if (cVar.ePZ) {
                imageView.setImageDrawable(null);
            }
            AppMethodBeat.o(116034);
        } else if (cVar.ePT == 0) {
            imageView.setImageDrawable(cVar.d(this.fGH.aEH));
            AppMethodBeat.o(116034);
        } else {
            imageView.setImageResource(cVar.ePT);
            AppMethodBeat.o(116034);
        }
    }

    public final void a(String str, c cVar, com.tencent.mm.at.a.c.c cVar2) {
        AppMethodBeat.i(116036);
        this.fGG.fGL.execute(new com.tencent.mm.at.a.f.a(str, cVar, this.fGG, cVar2));
        AppMethodBeat.o(116036);
    }

    private static ak a(c cVar) {
        AppMethodBeat.i(116035);
        ak akVar = cVar.handler;
        if (akVar == null || Looper.myLooper() == Looper.getMainLooper()) {
            akVar = new ak();
        }
        AppMethodBeat.o(116035);
        return akVar;
    }
}
