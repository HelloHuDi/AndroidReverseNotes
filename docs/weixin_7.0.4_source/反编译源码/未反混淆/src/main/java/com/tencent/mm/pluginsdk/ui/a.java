package com.tencent.mm.pluginsdk.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public class a extends i implements com.tencent.mm.ah.d.a {
    private static float vgN = 0.1f;

    public interface a {
        void doInvalidate();

        Drawable getDrawable();

        void setImageDrawable(Drawable drawable);
    }

    public static class b {
        public static com.tencent.mm.pluginsdk.ui.i.a pqK;

        public static com.tencent.mm.pluginsdk.ui.i.a diS() {
            AppMethodBeat.i(79656);
            Assert.assertTrue(pqK != null);
            com.tencent.mm.pluginsdk.ui.i.a aVar = pqK;
            AppMethodBeat.o(79656);
            return aVar;
        }

        public static void b(ImageView imageView, String str) {
            AppMethodBeat.i(79657);
            if (imageView == null) {
                ab.e("MicroMsg.AvatarDrawable", "imageView is null");
                AppMethodBeat.o(79657);
                return;
            }
            a(imageView, str, a.vgN, false);
            AppMethodBeat.o(79657);
        }

        public static void r(ImageView imageView, String str) {
            AppMethodBeat.i(79658);
            a(imageView, str, 0.5f, false);
            AppMethodBeat.o(79658);
        }

        public static void b(ImageView imageView, String str, float f) {
            AppMethodBeat.i(139137);
            a(imageView, str, f, false);
            AppMethodBeat.o(139137);
        }

        public static void s(ImageView imageView, String str) {
            AppMethodBeat.i(79660);
            a(imageView, str, 0.5f, true);
            AppMethodBeat.o(79660);
        }

        public static void a(ImageView imageView, String str, float f, boolean z) {
            AppMethodBeat.i(79661);
            if (imageView == null) {
                ab.e("MicroMsg.AvatarDrawable", "imageView is null");
                AppMethodBeat.o(79661);
                return;
            }
            b bVar;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof b)) {
                bVar = new b(str, f);
                bVar.ox(z);
            } else {
                bVar = (b) drawable;
            }
            bVar.setTag(str);
            imageView.setImageDrawable(bVar);
            imageView.invalidate();
            AppMethodBeat.o(79661);
        }

        public static void t(ImageView imageView, String str) {
            AppMethodBeat.i(79662);
            if (imageView == null) {
                ab.e("MicroMsg.AvatarDrawable", "imageView is null");
                AppMethodBeat.o(79662);
                return;
            }
            a(imageView, str, a.vgN, false);
            AppMethodBeat.o(79662);
        }

        public static void f(ImageView imageView, String str, int i) {
            AppMethodBeat.i(79663);
            if (imageView == null) {
                AppMethodBeat.o(79663);
                return;
            }
            c cVar;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof c)) {
                cVar = new c(str);
            } else {
                cVar = (c) drawable;
            }
            cVar.KL(i);
            cVar.setTag(str);
            imageView.setImageDrawable(cVar);
            imageView.invalidate();
            AppMethodBeat.o(79663);
        }
    }

    public a(com.tencent.mm.pluginsdk.ui.i.a aVar, String str) {
        super(aVar, str);
    }

    public void qj(String str) {
        AppMethodBeat.i(79664);
        super.qj(str);
        AppMethodBeat.o(79664);
    }
}
