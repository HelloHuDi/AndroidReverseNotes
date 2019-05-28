package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ui.album.a.d;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import java.util.ArrayList;
import java.util.List;

public final class c extends android.support.v7.widget.RecyclerView.a<b> {
    List<d> rFD = new ArrayList();
    a rFE = null;

    class c {
        public String cHr;
        public int cNE;

        c() {
        }
    }

    class b extends v {
        public ImageView iNr = null;
        public QDisFadeImageView rFF = null;

        public b(View view) {
            super(view);
            AppMethodBeat.i(39981);
            this.rFF = (QDisFadeImageView) view.findViewById(R.id.egk);
            this.iNr = (ImageView) view.findViewById(R.id.egl);
            this.iNr.setImageDrawable(ah.e(this.iNr.getContext().getResources().getDrawable(R.raw.icons_filled_play), -1));
            this.rFF.setScaleType(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
            this.rFF.setOnClickListener(new OnClickListener(c.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(39980);
                    if (!(view.getTag() == null || !(view.getTag() instanceof c) || c.this.rFE == null)) {
                        c.this.rFE.bi(((c) view.getTag()).cNE, ((c) view.getTag()).cHr);
                    }
                    AppMethodBeat.o(39980);
                }
            });
            AppMethodBeat.o(39981);
        }
    }

    public interface a {
        void bi(int i, String str);
    }

    public c() {
        AppMethodBeat.i(39982);
        AppMethodBeat.o(39982);
    }

    public final int getItemCount() {
        AppMethodBeat.i(39983);
        int size = this.rFD.size();
        AppMethodBeat.o(39983);
        return size;
    }
}
