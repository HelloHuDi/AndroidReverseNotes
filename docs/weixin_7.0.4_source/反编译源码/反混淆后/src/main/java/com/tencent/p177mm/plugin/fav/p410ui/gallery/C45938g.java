package com.tencent.p177mm.plugin.fav.p410ui.gallery;

import android.content.Context;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C41523a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.ui.gallery.g */
public final class C45938g {

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.g$c */
    public enum C20746c {
        ;

        private C20746c(String str) {
        }

        static {
            AppMethodBeat.m2505o(74589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.g$b */
    public interface C43080b extends C20741b<C45937a> {
        /* renamed from: bS */
        void mo45948bS(List<C20742d> list);

        void bwr();

        /* renamed from: fO */
        void mo45951fO(boolean z);

        /* renamed from: p */
        void mo45952p(boolean z, int i);

        /* renamed from: vF */
        void mo45954vF(int i);
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.gallery.g$a */
    public interface C45937a extends C43079a<C43080b> {
        C41523a bfB();

        <T extends C17480i> T bfC();

        void bwq();

        void bwr();

        <T extends C41523a> T bwx();

        boolean bwy();

        /* renamed from: dN */
        C25373h mo65941dN(Context context);

        void onResume();

        /* renamed from: s */
        void mo65944s(boolean z, int i);

        /* renamed from: vH */
        void mo65945vH(int i);
    }
}
