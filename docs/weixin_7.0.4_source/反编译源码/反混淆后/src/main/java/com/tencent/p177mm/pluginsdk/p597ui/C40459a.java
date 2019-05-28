package com.tencent.p177mm.pluginsdk.p597ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.pluginsdk.p597ui.C46507i.C14947a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.ui.a */
public class C40459a extends C46507i implements C8915a {
    private static float vgN = 0.1f;

    /* renamed from: com.tencent.mm.pluginsdk.ui.a$a */
    public interface C23266a {
        void doInvalidate();

        Drawable getDrawable();

        void setImageDrawable(Drawable drawable);
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.a$b */
    public static class C40460b {
        public static C14947a pqK;

        public static C14947a diS() {
            AppMethodBeat.m2504i(79656);
            Assert.assertTrue(pqK != null);
            C14947a c14947a = pqK;
            AppMethodBeat.m2505o(79656);
            return c14947a;
        }

        /* renamed from: b */
        public static void m69434b(ImageView imageView, String str) {
            AppMethodBeat.m2504i(79657);
            if (imageView == null) {
                C4990ab.m7412e("MicroMsg.AvatarDrawable", "imageView is null");
                AppMethodBeat.m2505o(79657);
                return;
            }
            C40460b.m69433a(imageView, str, C40459a.vgN, false);
            AppMethodBeat.m2505o(79657);
        }

        /* renamed from: r */
        public static void m69437r(ImageView imageView, String str) {
            AppMethodBeat.m2504i(79658);
            C40460b.m69433a(imageView, str, 0.5f, false);
            AppMethodBeat.m2505o(79658);
        }

        /* renamed from: b */
        public static void m69435b(ImageView imageView, String str, float f) {
            AppMethodBeat.m2504i(139137);
            C40460b.m69433a(imageView, str, f, false);
            AppMethodBeat.m2505o(139137);
        }

        /* renamed from: s */
        public static void m69438s(ImageView imageView, String str) {
            AppMethodBeat.m2504i(79660);
            C40460b.m69433a(imageView, str, 0.5f, true);
            AppMethodBeat.m2505o(79660);
        }

        /* renamed from: a */
        public static void m69433a(ImageView imageView, String str, float f, boolean z) {
            AppMethodBeat.m2504i(79661);
            if (imageView == null) {
                C4990ab.m7412e("MicroMsg.AvatarDrawable", "imageView is null");
                AppMethodBeat.m2505o(79661);
                return;
            }
            C46503b c46503b;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof C46503b)) {
                c46503b = new C46503b(str, f);
                c46503b.mo74729ox(z);
            } else {
                c46503b = (C46503b) drawable;
            }
            c46503b.setTag(str);
            imageView.setImageDrawable(c46503b);
            imageView.invalidate();
            AppMethodBeat.m2505o(79661);
        }

        /* renamed from: t */
        public static void m69439t(ImageView imageView, String str) {
            AppMethodBeat.m2504i(79662);
            if (imageView == null) {
                C4990ab.m7412e("MicroMsg.AvatarDrawable", "imageView is null");
                AppMethodBeat.m2505o(79662);
                return;
            }
            C40460b.m69433a(imageView, str, C40459a.vgN, false);
            AppMethodBeat.m2505o(79662);
        }

        /* renamed from: f */
        public static void m69436f(ImageView imageView, String str, int i) {
            AppMethodBeat.m2504i(79663);
            if (imageView == null) {
                AppMethodBeat.m2505o(79663);
                return;
            }
            C17011c c17011c;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof C17011c)) {
                c17011c = new C17011c(str);
            } else {
                c17011c = (C17011c) drawable;
            }
            c17011c.mo31083KL(i);
            c17011c.setTag(str);
            imageView.setImageDrawable(c17011c);
            imageView.invalidate();
            AppMethodBeat.m2505o(79663);
        }
    }

    public C40459a(C14947a c14947a, String str) {
        super(c14947a, str);
    }

    /* renamed from: qj */
    public void mo20342qj(String str) {
        AppMethodBeat.m2504i(79664);
        super.mo20342qj(str);
        AppMethodBeat.m2505o(79664);
    }
}
