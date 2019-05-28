package com.tencent.p177mm.plugin.sns.p520ui.album;

import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.p612ui.widget.QDisFadeImageView;
import com.tencent.p177mm.p612ui.widget.QImageView.C15991a;
import com.tencent.p177mm.plugin.sns.p520ui.album.C35095a.C35100d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.ui.album.c */
public final class C35101c extends C41523a<C35102b> {
    List<C35100d> rFD = new ArrayList();
    C35103a rFE = null;

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.c$c */
    class C22061c {
        public String cHr;
        public int cNE;

        C22061c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.c$b */
    class C35102b extends C41531v {
        public ImageView iNr = null;
        public QDisFadeImageView rFF = null;

        public C35102b(View view) {
            super(view);
            AppMethodBeat.m2504i(39981);
            this.rFF = (QDisFadeImageView) view.findViewById(2131827668);
            this.iNr = (ImageView) view.findViewById(2131827669);
            this.iNr.setImageDrawable(C5225ah.m7961e(this.iNr.getContext().getResources().getDrawable(C1318a.icons_filled_play), -1));
            this.rFF.setScaleType(C15991a.CENTER_CROP);
            this.rFF.setOnClickListener(new OnClickListener(C35101c.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(39980);
                    if (!(view.getTag() == null || !(view.getTag() instanceof C22061c) || C35101c.this.rFE == null)) {
                        C35101c.this.rFE.mo55729bi(((C22061c) view.getTag()).cNE, ((C22061c) view.getTag()).cHr);
                    }
                    AppMethodBeat.m2505o(39980);
                }
            });
            AppMethodBeat.m2505o(39981);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.album.c$a */
    public interface C35103a {
        /* renamed from: bi */
        void mo55729bi(int i, String str);
    }

    public C35101c() {
        AppMethodBeat.m2504i(39982);
        AppMethodBeat.m2505o(39982);
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(39983);
        int size = this.rFD.size();
        AppMethodBeat.m2505o(39983);
        return size;
    }
}
