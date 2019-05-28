package com.tencent.p177mm.p612ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.chatting.gallery.h */
public final class C15659h {
    public ArrayList<C7620bi> mnX;
    public boolean mnY;
    ArrayList<C15661b> mnZ;

    /* renamed from: com.tencent.mm.ui.chatting.gallery.h$a */
    public static final class C15660a {
        private static final C15659h yVE = new C15659h();

        static {
            AppMethodBeat.m2504i(32165);
            AppMethodBeat.m2505o(32165);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.gallery.h$b */
    public interface C15661b {
        void clear();

        void dFU();
    }

    /* synthetic */ C15659h(byte b) {
        this();
    }

    private C15659h() {
        AppMethodBeat.m2504i(32166);
        this.mnX = new ArrayList();
        this.mnY = false;
        this.mnZ = new ArrayList();
        AppMethodBeat.m2505o(32166);
    }

    /* renamed from: bC */
    public final void mo27887bC(C7620bi c7620bi) {
        AppMethodBeat.m2504i(32167);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(32167);
            return;
        }
        C4990ab.m7417i("MicroMsg.ImageGallerySelectedHandle", "add : %s", Long.valueOf(c7620bi.field_msgId));
        this.mnX.remove(c7620bi);
        this.mnX.remove(m23942no(c7620bi.field_msgId));
        this.mnX.add(c7620bi);
        dFW();
        AppMethodBeat.m2505o(32167);
    }

    /* renamed from: no */
    private C7620bi m23942no(long j) {
        AppMethodBeat.m2504i(32168);
        Iterator it = this.mnX.iterator();
        while (it.hasNext()) {
            C7620bi c7620bi = (C7620bi) it.next();
            if (c7620bi.field_msgId == j) {
                AppMethodBeat.m2505o(32168);
                return c7620bi;
            }
        }
        AppMethodBeat.m2505o(32168);
        return null;
    }

    /* renamed from: bD */
    public final void mo27888bD(C7620bi c7620bi) {
        AppMethodBeat.m2504i(32169);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(32169);
            return;
        }
        C4990ab.m7417i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", Long.valueOf(c7620bi.field_msgId));
        this.mnX.remove(c7620bi);
        this.mnX.remove(m23942no(c7620bi.field_msgId));
        dFW();
        AppMethodBeat.m2505o(32169);
    }

    public final void clear() {
        AppMethodBeat.m2504i(32170);
        C4990ab.m7416i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.mnX.clear();
        bfa();
        AppMethodBeat.m2505o(32170);
    }

    public final void detach() {
        AppMethodBeat.m2504i(32171);
        this.mnZ.clear();
        clear();
        this.mnY = false;
        AppMethodBeat.m2505o(32171);
    }

    /* renamed from: bE */
    public final boolean mo27889bE(C7620bi c7620bi) {
        AppMethodBeat.m2504i(32172);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(32172);
            return false;
        }
        Iterator it = this.mnX.iterator();
        while (it.hasNext()) {
            if (((C7620bi) it.next()).field_msgId == c7620bi.field_msgId) {
                AppMethodBeat.m2505o(32172);
                return true;
            }
        }
        AppMethodBeat.m2505o(32172);
        return false;
    }

    private void dFW() {
        AppMethodBeat.m2504i(32173);
        Iterator it = this.mnZ.iterator();
        while (it.hasNext()) {
            ((C15661b) it.next()).dFU();
        }
        AppMethodBeat.m2505o(32173);
    }

    private void bfa() {
        AppMethodBeat.m2504i(32174);
        Iterator it = this.mnZ.iterator();
        while (it.hasNext()) {
            ((C15661b) it.next()).clear();
        }
        AppMethodBeat.m2505o(32174);
    }

    /* renamed from: a */
    public final void mo27886a(C15661b c15661b) {
        AppMethodBeat.m2504i(32175);
        this.mnZ.remove(c15661b);
        this.mnZ.add(c15661b);
        AppMethodBeat.m2505o(32175);
    }
}
