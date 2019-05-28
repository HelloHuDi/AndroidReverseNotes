package com.tencent.p177mm.plugin.fav.p410ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.fav.ui.gallery.e */
public final class C20743e {
    ArrayList<C20742d> mnX;
    boolean mnY;
    ArrayList<C20745b> mnZ;

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.e$a */
    static final class C20744a {
        private static final C20743e moa = new C20743e();

        static {
            AppMethodBeat.m2504i(74560);
            AppMethodBeat.m2505o(74560);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.e$b */
    public interface C20745b {
        void bww();
    }

    /* synthetic */ C20743e(byte b) {
        this();
    }

    private C20743e() {
        AppMethodBeat.m2504i(74561);
        this.mnX = new ArrayList();
        this.mnY = false;
        this.mnZ = new ArrayList();
        AppMethodBeat.m2505o(74561);
    }

    /* renamed from: Mg */
    public final C20742d mo36047Mg(String str) {
        AppMethodBeat.m2504i(74562);
        Iterator it = this.mnX.iterator();
        while (it.hasNext()) {
            C20742d c20742d = (C20742d) it.next();
            if (c20742d.cAJ.mnd.equals(str)) {
                AppMethodBeat.m2505o(74562);
                return c20742d;
            }
        }
        AppMethodBeat.m2505o(74562);
        return null;
    }

    public final void clear() {
        AppMethodBeat.m2504i(74563);
        C4990ab.m7416i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.mnX.clear();
        Iterator it = this.mnZ.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(74563);
    }

    public final void bwu() {
        AppMethodBeat.m2504i(74564);
        Iterator it = this.mnZ.iterator();
        while (it.hasNext()) {
            ((C20745b) it.next()).bww();
        }
        AppMethodBeat.m2505o(74564);
    }
}
