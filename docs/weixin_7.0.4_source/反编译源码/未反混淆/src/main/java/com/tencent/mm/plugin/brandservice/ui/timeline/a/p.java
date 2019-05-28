package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class p extends a {
    public View jOS;
    public ImageView jOY;
    public View jPL;
    public TextView jPY;
    public ImageView jPZ;
    public MMNeat7extView jPi;
    public View jPj;
    public View jPk;
    public ImageView jQa;
    public MMNeat7extView jQb;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.p$3 */
    public class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ q jEl;
        final /* synthetic */ ImageView jQd;

        public AnonymousClass3(q qVar, ImageView imageView) {
            this.jEl = qVar;
            this.jQd = imageView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(14278);
            if (p.this.jPm.jNv.isPlaying() && this.jEl.field_msgId == p.this.jPm.jNv.jON) {
                p.this.jPm.jNv.stopPlay();
                this.jQd.setImageResource(R.drawable.f8if);
                AppMethodBeat.o(14278);
                return;
            }
            g gVar = p.this.jPm.jNv;
            Context context = p.this.mContext;
            String fullPath = com.tencent.mm.modelvoice.q.getFullPath(this.jEl.field_imgPath);
            long j = this.jEl.field_msgId;
            gVar.aWG().a(gVar);
            ab.d("MicroMsg.FavVoiceLogic", "start play, path[%s]", fullPath);
            if (gVar.aWG().startPlay(fullPath, -1)) {
                gVar.jON = j;
            } else {
                Toast.makeText(context, R.string.a_g, 1).show();
                gVar.jON = 0;
            }
            bi jf = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(this.jEl.field_msgId);
            if (jf.field_msgId != 0) {
                if (!com.tencent.mm.modelvoice.q.K(jf)) {
                    com.tencent.mm.modelvoice.q.M(jf);
                }
                AppMethodBeat.o(14278);
                return;
            }
            AppMethodBeat.o(14278);
        }
    }

    public final View a(Context context, a aVar) {
        AppMethodBeat.i(14279);
        super.b(context, aVar);
        View view;
        if (this.jOR != null) {
            view = this.jOR;
            AppMethodBeat.o(14279);
            return view;
        }
        this.jOR = View.inflate(context, R.layout.hh, null);
        aWH();
        this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.qm);
        this.jPY = (TextView) this.jOR.findViewById(R.id.a8w);
        this.jOY = (ImageView) this.jOR.findViewById(R.id.a8z);
        this.jPL = this.jOR.findViewById(R.id.a8y);
        this.jOS = this.jOR.findViewById(R.id.a7y);
        this.jQb = (MMNeat7extView) this.jOR.findViewById(R.id.a80);
        this.jPj = this.jOR.findViewById(R.id.a8x);
        this.jPk = this.jOR.findViewById(R.id.a90);
        this.jPZ = (ImageView) this.jOR.findViewById(R.id.a83);
        this.jQa = (ImageView) this.jOR.findViewById(R.id.a82);
        view = this.jOR;
        AppMethodBeat.o(14279);
        return view;
    }
}
