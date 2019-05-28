package com.tencent.p177mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C28159d;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C39158a;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C43142c;
import com.tencent.p177mm.plugin.gallery.model.C43143i.C43144b;
import com.tencent.p177mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.gallery.model.l */
public final class C45980l {
    public int hOZ = 3;
    HashSet<C39158a> mOq = new HashSet();
    public HashSet<C43142c> mOr = new HashSet();
    public HashSet<C43144b> mOs = new HashSet();
    public C43143i mOt;
    public int mOu = 1;

    /* renamed from: com.tencent.mm.plugin.gallery.model.l$1 */
    class C342381 implements Runnable {
        C342381() {
        }

        public final void run() {
            AppMethodBeat.m2504i(21318);
            LinkedList bBS = C45980l.this.mOt.bBS();
            C45980l c45980l = C45980l.this;
            C39158a[] c39158aArr = new C39158a[c45980l.mOq.size()];
            c45980l.mOq.toArray(c39158aArr);
            for (C39158a V : c39158aArr) {
                V.mo62060V(bBS);
            }
            AppMethodBeat.m2505o(21318);
        }

        public final String toString() {
            AppMethodBeat.m2504i(21319);
            String str = super.toString() + "|queryAlbums";
            AppMethodBeat.m2505o(21319);
            return str;
        }
    }

    public C45980l() {
        AppMethodBeat.m2504i(21323);
        AppMethodBeat.m2505o(21323);
    }

    /* renamed from: wq */
    public final void mo73865wq(int i) {
        AppMethodBeat.m2504i(21324);
        this.mOu = i;
        bCt();
        AppMethodBeat.m2505o(21324);
    }

    private void bCt() {
        AppMethodBeat.m2504i(21325);
        C4990ab.m7417i("MicroMsg.MediaQueryService", "initQueryType: %d", Integer.valueOf(this.mOu));
        switch (this.mOu) {
            case 1:
                this.mOt = new C44843j();
                AppMethodBeat.m2505o(21325);
                return;
            case 2:
                this.mOt = new C28160n();
                AppMethodBeat.m2505o(21325);
                return;
            case 3:
                this.mOt = new C44842a();
                AppMethodBeat.m2505o(21325);
                return;
            default:
                this.mOt = new C44842a();
                AppMethodBeat.m2505o(21325);
                return;
        }
    }

    /* renamed from: a */
    public final void mo73861a(C39158a c39158a) {
        AppMethodBeat.m2504i(21326);
        this.mOq.add(c39158a);
        AppMethodBeat.m2505o(21326);
    }

    /* renamed from: b */
    public final void mo73862b(C39158a c39158a) {
        AppMethodBeat.m2504i(21327);
        this.mOq.remove(c39158a);
        AppMethodBeat.m2505o(21327);
    }

    public final void bCu() {
        AppMethodBeat.m2504i(21328);
        if (this.mOt == null) {
            C4990ab.m7414f("MicroMsg.MediaQueryService", "media query not init, init again");
            bCt();
        }
        C34237e.bCa().mo36231W(new C342381());
        AppMethodBeat.m2505o(21328);
    }

    /* renamed from: g */
    public final void mo73864g(String str, int i, long j) {
        AppMethodBeat.m2504i(21329);
        if (this.mOt == null) {
            C4990ab.m7414f("MicroMsg.MediaQueryService", "media query not init, init again");
            bCt();
        }
        C34237e.bCa().bCn().removeCallbacksAndMessages(null);
        this.mOt.bBT();
        C20909g bCa = C34237e.bCa();
        final String str2 = str;
        final int i2 = i;
        final long j2 = j;
        bCa.bCn().post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.gallery.model.l$2$1 */
            class C342401 implements C28159d {
                C342401() {
                }

                /* renamed from: c */
                public final void mo46074c(LinkedList<MediaItem> linkedList, long j) {
                    AppMethodBeat.m2504i(21320);
                    C45980l.m85408a(C45980l.this, linkedList, j);
                    AppMethodBeat.m2505o(21320);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(21321);
                try {
                    C45980l.this.mOt.mo46076a(str2, i2, new C342401(), j2);
                    AppMethodBeat.m2505o(21321);
                } catch (SecurityException e) {
                    C4990ab.printErrStackTrace("MicroMsg.MediaQueryService", e, "", new Object[0]);
                    C45980l.m85408a(C45980l.this, new LinkedList(), j2);
                    AppMethodBeat.m2505o(21321);
                }
            }

            public final String toString() {
                AppMethodBeat.m2504i(21322);
                String str = super.toString() + "|queryMediaInAlbums";
                AppMethodBeat.m2505o(21322);
                return str;
            }
        });
        AppMethodBeat.m2505o(21329);
    }

    /* renamed from: a */
    static /* synthetic */ void m85408a(C45980l c45980l, LinkedList linkedList, long j) {
        int i = 0;
        AppMethodBeat.m2504i(138168);
        C43144b[] c43144bArr = new C43144b[c45980l.mOs.size()];
        c45980l.mOs.toArray(c43144bArr);
        for (C43144b b : c43144bArr) {
            b.mo62070b(linkedList, j);
        }
        C43142c[] c43142cArr = new C43142c[c45980l.mOr.size()];
        c45980l.mOr.toArray(c43142cArr);
        int length = c43142cArr.length;
        while (i < length) {
            c43142cArr[i].mo62069c(linkedList, j);
            i++;
        }
        AppMethodBeat.m2505o(138168);
    }
}
