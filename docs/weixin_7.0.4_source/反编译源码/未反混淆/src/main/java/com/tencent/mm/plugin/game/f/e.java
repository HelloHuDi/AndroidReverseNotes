package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.lang.ref.WeakReference;

public class e {
    private static final String nnA = (com.tencent.mm.loader.j.b.eSn + "Game/Image/");
    private static e nnB;
    private f<String, Bitmap> neb = new com.tencent.mm.memory.a.b(6, getClass());
    private f<String, Bitmap> nkP = new com.tencent.mm.memory.a.b(15, getClass());
    private ColorDrawable nnC = new ColorDrawable(android.support.v4.content.b.i(ah.getContext(), R.color.pp));
    private Bitmap nnD;
    private Bitmap nnE;

    public static abstract class b {
        public abstract void a(View view, Bitmap bitmap);
    }

    public static class a {
        final boolean ePF;
        final boolean ePH;
        final boolean eQf;
        final int iPY;
        final boolean nnP;
        final boolean nnQ;
        final boolean nnR;
        final int nnS;

        public static class a {
            public boolean ePF = true;
            public boolean ePH = true;
            public boolean eQf = false;
            int iPY = 0;
            public boolean nnP = false;
            boolean nnQ = true;
            boolean nnR = false;
            public int nnS = 0;

            public final a bFI() {
                AppMethodBeat.i(112334);
                a aVar = new a(this, (byte) 0);
                AppMethodBeat.o(112334);
                return aVar;
            }
        }

        /* synthetic */ a(a aVar, byte b) {
            this(aVar);
        }

        private a(a aVar) {
            this.ePF = aVar.ePF;
            this.ePH = aVar.ePH;
            this.eQf = aVar.eQf;
            this.nnP = aVar.nnP;
            this.nnQ = aVar.nnQ;
            this.nnR = aVar.nnR;
            this.nnS = aVar.nnS;
            this.iPY = aVar.iPY;
        }
    }

    static /* synthetic */ Bitmap c(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.i(112352);
        Bitmap b = b(bitmap, i, i2);
        AppMethodBeat.o(112352);
        return b;
    }

    static {
        AppMethodBeat.i(112353);
        AppMethodBeat.o(112353);
    }

    public static e bFH() {
        AppMethodBeat.i(112335);
        if (nnB == null) {
            synchronized (e.class) {
                try {
                    if (nnB == null) {
                        nnB = new e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(112335);
                    }
                }
            }
        }
        e eVar = nnB;
        AppMethodBeat.o(112335);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(112336);
        try {
            this.nnD = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bz.a.getDensity(null));
            if (!(this.nnD == null || this.nnD.isRecycled())) {
                this.nnE = d.a(this.nnD, false, 0.5f * ((float) this.nnD.getWidth()));
            }
        } catch (Exception e) {
            ab.i("MicroMsg.GameImageUtil", e.getMessage());
        }
        com.tencent.mm.plugin.s.a.bYJ().c(new com.tencent.mm.sdk.e.k.a() {
            public final void a(String str, m mVar) {
                AppMethodBeat.i(112326);
                if (e.this.neb.aj(str)) {
                    e.this.neb.k(str, g.b(str, 1, com.tencent.mm.bz.a.getDensity(null)));
                }
                AppMethodBeat.o(112326);
            }
        });
        AppMethodBeat.o(112336);
    }

    public final void h(ImageView imageView, String str) {
        AppMethodBeat.i(112337);
        a(imageView, str, null, null);
        AppMethodBeat.o(112337);
    }

    public final void a(ImageView imageView, String str, a aVar) {
        AppMethodBeat.i(112338);
        a(imageView, str, aVar, null);
        AppMethodBeat.o(112338);
    }

    public final void i(ImageView imageView, String str) {
        AppMethodBeat.i(112339);
        a aVar = new a();
        aVar.eQf = true;
        a(imageView, str, aVar.bFI(), null);
        AppMethodBeat.o(112339);
    }

    public final void a(ImageView imageView, String str, a aVar, b bVar) {
        AppMethodBeat.i(112340);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(112340);
            return;
        }
        if (aVar == null) {
            aVar = new a().bFI();
        }
        if (b(imageView, str, aVar, bVar)) {
            AppMethodBeat.o(112340);
            return;
        }
        c(imageView, str, aVar, bVar);
        AppMethodBeat.o(112340);
    }

    private void c(final ImageView imageView, String str, final a aVar, final b bVar) {
        boolean z;
        AppMethodBeat.i(112342);
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        if (aVar.nnR) {
            z = false;
        } else {
            z = true;
        }
        aVar2.ePF = z;
        Ov(nnA);
        String str2 = nnA + com.tencent.mm.a.g.x(str.getBytes());
        aVar2.ePH = aVar.ePH;
        if (aVar.nnR) {
            aVar2.ePH = false;
            com.tencent.mm.pluginsdk.g.a.d.a.ajj(str2);
        } else {
            aVar2.ePJ = str2;
        }
        aVar2.eQf = aVar.eQf;
        aVar2.ePZ = false;
        a(imageView, aVar);
        o.ahp().a(str, null, aVar2.ahG(), new com.tencent.mm.at.a.c.g() {
            public final void sH(String str) {
                AppMethodBeat.i(112328);
                ab.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: ".concat(String.valueOf(str)));
                AppMethodBeat.o(112328);
            }

            public final Bitmap a(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                return null;
            }

            public final void b(String str, View view, com.tencent.mm.at.a.d.b bVar) {
                AppMethodBeat.i(112329);
                ab.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: ".concat(String.valueOf(str)));
                if (!(bVar == null || bVar.bitmap == null)) {
                    Object obj = bVar.bitmap;
                    if (aVar.nnP) {
                        obj = e.N(obj);
                    }
                    if (aVar.iPY != 0) {
                        obj = d.a((Bitmap) obj, true, (float) aVar.iPY);
                    }
                    if (aVar.ePF) {
                        e.this.nkP.k(str, obj);
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(112327);
                            if (imageView != null) {
                                imageView.setImageBitmap(obj);
                            }
                            AppMethodBeat.o(112327);
                        }
                    });
                    if (bVar != null) {
                        bVar.a(view, obj);
                    }
                }
                AppMethodBeat.o(112329);
            }
        });
        AppMethodBeat.o(112342);
    }

    private void a(ImageView imageView, a aVar) {
        AppMethodBeat.i(112343);
        if (imageView != null && aVar.nnQ) {
            if (aVar.nnS == 0) {
                imageView.setImageDrawable(this.nnC);
                AppMethodBeat.o(112343);
                return;
            }
            imageView.setImageResource(aVar.nnS);
        }
        AppMethodBeat.o(112343);
    }

    public final void a(ImageView imageView, String str, int i, int i2, int i3) {
        AppMethodBeat.i(112344);
        b(imageView, str, i, i2, i3);
        AppMethodBeat.o(112344);
    }

    private void b(ImageView imageView, String str, int i, int i2, int i3) {
        AppMethodBeat.i(112345);
        final ImageView imageView2 = imageView;
        final int i4 = i2;
        final int i5 = i;
        final int i6 = i3;
        a(str, i, i2, new b() {
            public final void a(View view, final Bitmap bitmap) {
                AppMethodBeat.i(112331);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(112330);
                            imageView2.setImageBitmap(bitmap);
                            LayoutParams layoutParams = imageView2.getLayoutParams();
                            float f = ((float) i4) / ((float) i5);
                            layoutParams.width = i6;
                            layoutParams.height = (int) (f * ((float) i6));
                            imageView2.setLayoutParams(layoutParams);
                            imageView2.setScaleType(ScaleType.FIT_XY);
                            AppMethodBeat.o(112330);
                        }
                    });
                }
                AppMethodBeat.o(112331);
            }
        });
        AppMethodBeat.o(112345);
    }

    private void a(String str, int i, int i2, b bVar) {
        AppMethodBeat.i(112346);
        ab.d("MicroMsg.GameImageUtil", "getBitmapWithWH, start");
        Bitmap bitmap = (Bitmap) this.nkP.ai(str);
        if (bitmap == null || bitmap.isRecycled()) {
            final b bVar2 = bVar;
            final int i3 = i;
            final int i4 = i2;
            final String str2 = str;
            c(null, str, new a().bFI(), new b() {
                final /* synthetic */ int nnN = 0;

                public final void a(View view, Bitmap bitmap) {
                    AppMethodBeat.i(112332);
                    ab.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        Object c = e.c(bitmap, i3, i4);
                        ab.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
                        if (this.nnN != 0) {
                            c = d.a((Bitmap) c, true, (float) this.nnN);
                        }
                        e.this.nkP.k(str2, c);
                        if (bVar2 != null) {
                            bVar2.a(view, c);
                        }
                    }
                    AppMethodBeat.o(112332);
                }
            });
            AppMethodBeat.o(112346);
            return;
        }
        bVar.a(null, bitmap);
        AppMethodBeat.o(112346);
    }

    private static Bitmap b(Bitmap bitmap, int i, int i2) {
        AppMethodBeat.i(112347);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i && height == i2) {
            AppMethodBeat.o(112347);
            return bitmap;
        }
        int i3;
        Bitmap createBitmap;
        int i4;
        float f = ((float) height) / ((float) i2);
        float f2 = ((float) width) / ((float) i);
        if (f < f2) {
            i3 = (int) (f * ((float) i));
            try {
                createBitmap = Bitmap.createBitmap(bitmap, (width - i3) / 2, 0, i3, height);
                i4 = height;
            } catch (IllegalArgumentException e) {
                AppMethodBeat.o(112347);
                return bitmap;
            }
        }
        i4 = (int) (((float) i2) * f2);
        createBitmap = Bitmap.createBitmap(bitmap, 0, (height - i4) / 2, width, i4);
        i3 = width;
        ab.i("MicroMsg.GameImageUtil", "resizeBitmap, bitmapW = %d, bitmapH = %d, newWidth = %d, newHeight = %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(112347);
        return createBitmap;
    }

    public final void a(ImageView imageView, final String str, final float f) {
        AppMethodBeat.i(112349);
        if (imageView == null || bo.isNullOrNil(str)) {
            AppMethodBeat.o(112349);
            return;
        }
        Bitmap bitmap;
        if (this.neb.aj(str)) {
            bitmap = (Bitmap) this.neb.ai(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                imageView.setImageBitmap(bitmap);
                AppMethodBeat.o(112349);
                return;
            }
        }
        bitmap = g.b(str, 1, f);
        if (bitmap == null || bitmap.isRecycled()) {
            imageView.setImageResource(R.drawable.af7);
            final WeakReference weakReference = new WeakReference(imageView);
            com.tencent.mm.plugin.s.a.bYJ().c(new com.tencent.mm.sdk.e.k.a() {
                public final void a(String str, m mVar) {
                    AppMethodBeat.i(112333);
                    if (str.equals(str)) {
                        Bitmap b = g.b(str, 1, f);
                        if (b != null) {
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((ImageView) weakReference.get()).setImageBitmap(b);
                            }
                            e.this.neb.put(str, b);
                            com.tencent.mm.plugin.s.a.bYJ().d(this);
                        }
                    }
                    AppMethodBeat.o(112333);
                }
            });
            AppMethodBeat.o(112349);
            return;
        }
        imageView.setImageBitmap(bitmap);
        this.neb.put(str, bitmap);
        AppMethodBeat.o(112349);
    }

    private static boolean Ov(String str) {
        AppMethodBeat.i(112350);
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdir()) {
                    file2.renameTo(parentFile);
                } else {
                    ab.e("MicroMsg.GameImageUtil", "mkdir error, %s", parentFile.getAbsolutePath());
                    AppMethodBeat.o(112350);
                    return false;
                }
            }
            if (!(file.mkdir() && file.isDirectory())) {
                ab.e("MicroMsg.GameImageUtil", "mkdir error. %s", str);
                AppMethodBeat.o(112350);
                return false;
            }
        }
        AppMethodBeat.o(112350);
        return true;
    }

    private boolean b(ImageView imageView, String str, a aVar, b bVar) {
        AppMethodBeat.i(112341);
        if (!aVar.ePF || aVar.nnR) {
            AppMethodBeat.o(112341);
            return false;
        } else if (this.nkP.aj(str)) {
            Bitmap bitmap = (Bitmap) this.nkP.ai(str);
            if (bitmap == null || bitmap.isRecycled()) {
                AppMethodBeat.o(112341);
                return false;
            }
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            if (bVar != null) {
                bVar.a(imageView, bitmap);
            }
            AppMethodBeat.o(112341);
            return true;
        } else {
            AppMethodBeat.o(112341);
            return false;
        }
    }

    public final Bitmap j(ImageView imageView, String str) {
        AppMethodBeat.i(112348);
        Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
        if (a == null || a.isRecycled()) {
            if (this.nnD == null || this.nnD.isRecycled()) {
                try {
                    this.nnD = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bz.a.getDensity(null));
                } catch (Exception e) {
                }
            }
            if (!(this.nnD == null || this.nnD.isRecycled() || imageView == null)) {
                imageView.setImageBitmap(this.nnD);
            }
            a = this.nnD;
            AppMethodBeat.o(112348);
            return a;
        }
        if (imageView != null) {
            imageView.setImageBitmap(a);
        }
        AppMethodBeat.o(112348);
        return a;
    }

    static /* synthetic */ Bitmap N(Bitmap bitmap) {
        AppMethodBeat.i(112351);
        if (bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(112351);
            return bitmap;
        }
        int width = bitmap.getHeight() > bitmap.getWidth() ? bitmap.getWidth() : bitmap.getHeight();
        bitmap = d.b(bitmap, width, width, false);
        AppMethodBeat.o(112351);
        return bitmap;
    }
}
