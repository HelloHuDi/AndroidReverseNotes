package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b extends android.support.v7.widget.RecyclerView.a<a> {
    h<i> kQR = new h();
    private boolean kQS = true;
    private boolean kQT = false;
    private boolean kQU = false;
    private boolean kQV = false;
    boolean kQW = false;
    boolean kQX = true;
    private Context mContext;

    public static class a extends v {
        public View contentView;

        public a(View view) {
            super(view);
            AppMethodBeat.i(136284);
            this.contentView = ((ViewGroup) view).getChildAt(0);
            AppMethodBeat.o(136284);
        }
    }

    public b(Context context) {
        AppMethodBeat.i(136285);
        this.mContext = context;
        AppMethodBeat.o(136285);
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(136286);
        int i2 = ((i) this.kQR.get(i)).type;
        AppMethodBeat.o(136286);
        return i2;
    }

    public final int getItemCount() {
        AppMethodBeat.i(136287);
        int size = this.kQR.size();
        AppMethodBeat.o(136287);
        return size;
    }

    public final void P(LinkedList<i> linkedList) {
        AppMethodBeat.i(136288);
        if (bo.ek(linkedList)) {
            AppMethodBeat.o(136288);
        } else if (linkedList.size() == 1) {
            final int indexOf = this.kQR.indexOf(linkedList.get(0));
            this.kQR.remove(indexOf);
            l.q(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(136282);
                    b.this.ci(indexOf);
                    AppMethodBeat.o(136282);
                }
            });
            AppMethodBeat.o(136288);
        } else {
            this.kQR.removeAll(linkedList);
            l.q(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(136283);
                    b.this.aop.notifyChanged();
                    AppMethodBeat.o(136283);
                }
            });
            AppMethodBeat.o(136288);
        }
    }

    public final boolean biL() {
        AppMethodBeat.i(136289);
        if (this.kQR.size() <= 5) {
            AppMethodBeat.o(136289);
            return true;
        }
        AppMethodBeat.o(136289);
        return false;
    }
}
