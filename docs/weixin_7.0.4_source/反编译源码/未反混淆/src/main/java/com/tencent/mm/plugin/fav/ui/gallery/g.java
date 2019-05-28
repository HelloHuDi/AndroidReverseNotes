package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class g {

    public enum c {
        ;

        private c(String str) {
        }

        static {
            AppMethodBeat.o(74589);
        }
    }

    public interface b extends b<a> {
        void bS(List<d> list);

        void bwr();

        void fO(boolean z);

        void p(boolean z, int i);

        void vF(int i);
    }

    public interface a extends a<b> {
        android.support.v7.widget.RecyclerView.a bfB();

        <T extends i> T bfC();

        void bwq();

        void bwr();

        <T extends android.support.v7.widget.RecyclerView.a> T bwx();

        boolean bwy();

        h dN(Context context);

        void onResume();

        void s(boolean z, int i);

        void vH(int i);
    }
}
