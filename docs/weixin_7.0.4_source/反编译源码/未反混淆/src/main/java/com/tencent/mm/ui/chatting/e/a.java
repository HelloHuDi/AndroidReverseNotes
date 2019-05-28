package com.tencent.mm.ui.chatting.e;

import android.content.Context;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {

    public interface b extends com.tencent.mm.ui.chatting.view.a<a> {
        void OI(int i);

        void bwr();

        void dFC();

        void dFD();

        void dFE();

        boolean dFF();

        void fO(boolean z);

        View getChildAt(int i);

        void p(boolean z, int i);

        void vF(int i);
    }

    public enum c {
        ;

        private c(String str) {
        }

        static {
            AppMethodBeat.o(31950);
        }
    }

    public interface a extends com.tencent.mm.ui.chatting.i.c<b> {
        android.support.v7.widget.RecyclerView.a aT(String str, long j);

        String aoy();

        <T extends i> T bfC();

        void bwq();

        void bwr();

        <T extends android.support.v7.widget.RecyclerView.a> T bwx();

        boolean bwy();

        int dFB();

        void dFC();

        h dN(Context context);

        void onResume();

        void s(boolean z, int i);

        void vH(int i);
    }
}
