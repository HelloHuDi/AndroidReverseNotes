package com.tencent.p177mm.p190at.p191a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p192b.C6325h;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p190at.p191a.p193c.C45158c;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C17926b;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p828f.C25818a;
import com.tencent.p177mm.p190at.p191a.p828f.C9015b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.at.a.a */
public final class C25815a {
    private static C25815a fGJ = null;
    private C9012b fGG;
    private C17926b fGH;
    private final C1282i fGI = new C6325h();

    public static synchronized C25815a ahv() {
        C25815a c25815a;
        synchronized (C25815a.class) {
            AppMethodBeat.m2504i(116017);
            if (fGJ == null) {
                fGJ = new C25815a(C4996ah.getContext());
            }
            c25815a = fGJ;
            AppMethodBeat.m2505o(116017);
        }
        return c25815a;
    }

    public C25815a(Context context) {
        AppMethodBeat.m2504i(116018);
        m41076a(C17926b.m28169bZ(context));
        AppMethodBeat.m2505o(116018);
    }

    public C25815a(C17926b c17926b) {
        AppMethodBeat.m2504i(116019);
        m41076a(c17926b);
        AppMethodBeat.m2505o(116019);
    }

    /* renamed from: a */
    private synchronized void m41076a(C17926b c17926b) {
        AppMethodBeat.m2504i(116020);
        if (c17926b == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("[cpan] image loader configuration is null.");
            AppMethodBeat.m2505o(116020);
            throw illegalArgumentException;
        } else if (this.fGH == null) {
            this.fGG = new C9012b(c17926b);
            this.fGH = c17926b;
            AppMethodBeat.m2505o(116020);
        } else {
            C4990ab.m7420w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
            AppMethodBeat.m2505o(116020);
        }
    }

    /* renamed from: a */
    public final void mo43765a(String str, ImageView imageView) {
        AppMethodBeat.m2504i(116021);
        m41078b(str, imageView, null, null, null);
        AppMethodBeat.m2505o(116021);
    }

    /* renamed from: a */
    public final void mo43770a(String str, ImageView imageView, C9014g c9014g) {
        AppMethodBeat.m2504i(116022);
        m41078b(str, imageView, null, null, c9014g);
        AppMethodBeat.m2505o(116022);
    }

    /* renamed from: a */
    public final void mo43767a(String str, ImageView imageView, C25814c c25814c, C9014g c9014g) {
        AppMethodBeat.m2504i(116023);
        m41078b(str, imageView, c25814c, null, c9014g);
        AppMethodBeat.m2505o(116023);
    }

    /* renamed from: a */
    public final void mo43769a(String str, ImageView imageView, C25814c c25814c, C1282i c1282i, C9014g c9014g) {
        AppMethodBeat.m2504i(116024);
        m41078b(str, imageView, c25814c, c1282i, c9014g);
        AppMethodBeat.m2505o(116024);
    }

    /* renamed from: a */
    public final void mo43766a(String str, ImageView imageView, C25814c c25814c) {
        AppMethodBeat.m2504i(116025);
        m41078b(str, imageView, c25814c, null, null);
        AppMethodBeat.m2505o(116025);
    }

    /* renamed from: a */
    public final void mo43768a(String str, ImageView imageView, C25814c c25814c, C1282i c1282i) {
        AppMethodBeat.m2504i(116026);
        m41078b(str, imageView, c25814c, c1282i, null);
        AppMethodBeat.m2505o(116026);
    }

    /* renamed from: b */
    private void m41078b(String str, ImageView imageView, C25814c c25814c, C1282i c1282i, C9014g c9014g) {
        C25814c c25814c2;
        C1282i c1282i2;
        AppMethodBeat.m2504i(116027);
        if (c25814c == null) {
            c25814c2 = this.fGH.fGS;
        } else {
            c25814c2 = c25814c;
        }
        if (c1282i == null) {
            c1282i2 = this.fGI;
        } else {
            c1282i2 = c1282i;
        }
        C25817c c25817c = new C25817c(imageView, str);
        m41075a(imageView, c25814c2);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
            m41077b(imageView, c25814c2);
            this.fGG.mo20439a(c25817c);
            c1282i2.mo4581a(str, imageView, null, c25814c2.eQd);
            AppMethodBeat.m2505o(116027);
            return;
        }
        C9015b c9015b = new C9015b(str, c25817c, C25815a.m41074a(c25814c2), c25814c2, c1282i2, this.fGG, c9014g);
        Bitmap sB = this.fGG.mo20444sB(c9015b.mo20448sJ(str));
        if (sB == null || sB.isRecycled()) {
            if (imageView != null) {
                m41077b(imageView, c25814c2);
            }
            if ((c9015b.fGS.ePI || !this.fGG.mo20438DA()) && this.fGG.mo20442a(c25817c, str)) {
                this.fGG.mo20440a(c9015b);
                this.fGG.mo20441a(c9015b, c25814c2.ePG);
            }
            AppMethodBeat.m2505o(116027);
            return;
        }
        C4990ab.m7411d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", r3);
        if (c25814c2.fHf) {
            sB = C5056d.m7660e(sB, c25814c2.fHg);
        }
        if (imageView != null) {
            imageView.setImageBitmap(sB);
        }
        c9015b.mo20446fN(0);
        if (c9014g != null) {
            c9014g.mo7595b(str, imageView, new C37477b(sB));
        }
        this.fGG.mo20439a(c25817c);
        AppMethodBeat.m2505o(116027);
    }

    /* renamed from: b */
    public final void mo43772b(String str, ImageView imageView) {
        AppMethodBeat.m2504i(116028);
        this.fGG.mo20439a(new C25817c(imageView, str));
        AppMethodBeat.m2505o(116028);
    }

    /* renamed from: cm */
    public final void mo43773cm(int i) {
        AppMethodBeat.m2504i(116029);
        C4990ab.m7411d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", Integer.valueOf(i));
        if (i == 0 || i == 1) {
            C4990ab.m7410d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
            this.fGG.fGL.resume();
            AppMethodBeat.m2505o(116029);
            return;
        }
        C4990ab.m7410d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
        this.fGG.fGL.pause();
        AppMethodBeat.m2505o(116029);
    }

    public final void detach() {
        AppMethodBeat.m2504i(116030);
        if (this.fGG != null) {
            this.fGG.ahw();
        }
        AppMethodBeat.m2505o(116030);
    }

    /* renamed from: sB */
    public final Bitmap mo43776sB(String str) {
        AppMethodBeat.m2504i(116031);
        if (this.fGG != null) {
            Bitmap sB = this.fGG.mo20444sB(str);
            AppMethodBeat.m2505o(116031);
            return sB;
        }
        AppMethodBeat.m2505o(116031);
        return null;
    }

    /* renamed from: j */
    public final void mo43775j(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(116032);
        if (this.fGG != null) {
            C9012b c9012b = this.fGG;
            if (c9012b.fGK != null) {
                c9012b.fGK.fGT.mo52989c(str, bitmap);
            }
        }
        AppMethodBeat.m2505o(116032);
    }

    /* renamed from: a */
    private void m41075a(ImageView imageView, C25814c c25814c) {
        AppMethodBeat.m2504i(116033);
        if (imageView == null || c25814c == null) {
            C4990ab.m7420w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
            AppMethodBeat.m2505o(116033);
        } else if (!c25814c.ahB()) {
            imageView.setBackgroundDrawable(null);
            AppMethodBeat.m2505o(116033);
        } else if (c25814c.ePV == 0) {
            imageView.setBackgroundDrawable(c25814c.mo43764e(this.fGH.aEH));
            AppMethodBeat.m2505o(116033);
        } else {
            imageView.setBackgroundResource(c25814c.ePV);
            AppMethodBeat.m2505o(116033);
        }
    }

    /* renamed from: b */
    private void m41077b(ImageView imageView, C25814c c25814c) {
        AppMethodBeat.m2504i(116034);
        if (imageView == null || c25814c == null) {
            C4990ab.m7420w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
            AppMethodBeat.m2505o(116034);
        } else if (!c25814c.ahA()) {
            if (c25814c.ePZ) {
                imageView.setImageDrawable(null);
            }
            AppMethodBeat.m2505o(116034);
        } else if (c25814c.ePT == 0) {
            imageView.setImageDrawable(c25814c.mo43763d(this.fGH.aEH));
            AppMethodBeat.m2505o(116034);
        } else {
            imageView.setImageResource(c25814c.ePT);
            AppMethodBeat.m2505o(116034);
        }
    }

    /* renamed from: a */
    public final void mo43771a(String str, C25814c c25814c, C45158c c45158c) {
        AppMethodBeat.m2504i(116036);
        this.fGG.fGL.execute(new C25818a(str, c25814c, this.fGG, c45158c));
        AppMethodBeat.m2505o(116036);
    }

    /* renamed from: a */
    private static C7306ak m41074a(C25814c c25814c) {
        AppMethodBeat.m2504i(116035);
        C7306ak c7306ak = c25814c.handler;
        if (c7306ak == null || Looper.myLooper() == Looper.getMainLooper()) {
            c7306ak = new C7306ak();
        }
        AppMethodBeat.m2505o(116035);
        return c7306ak;
    }
}
