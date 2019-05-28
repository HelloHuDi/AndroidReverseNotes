package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C2696g;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.p */
public final class C27521p extends C33729a {
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

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.p$1 */
    public class C26951 implements OnClickListener {
        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.p$2 */
    public class C275222 implements OnClickListener {
        public final void onClick(View view) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.p$3 */
    public class C275233 implements OnClickListener {
        final /* synthetic */ C46627q jEl;
        final /* synthetic */ ImageView jQd;

        public C275233(C46627q c46627q, ImageView imageView) {
            this.jEl = c46627q;
            this.jQd = imageView;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14278);
            if (C27521p.this.jPm.jNv.isPlaying() && this.jEl.field_msgId == C27521p.this.jPm.jNv.jON) {
                C27521p.this.jPm.jNv.stopPlay();
                this.jQd.setImageResource(C25738R.drawable.f6568if);
                AppMethodBeat.m2505o(14278);
                return;
            }
            C2696g c2696g = C27521p.this.jPm.jNv;
            Context context = C27521p.this.mContext;
            String fullPath = C32850q.getFullPath(this.jEl.field_imgPath);
            long j = this.jEl.field_msgId;
            c2696g.aWG().mo58605a(c2696g);
            C4990ab.m7411d("MicroMsg.FavVoiceLogic", "start play, path[%s]", fullPath);
            if (c2696g.aWG().startPlay(fullPath, -1)) {
                c2696g.jON = j;
            } else {
                Toast.makeText(context, C25738R.string.a_g, 1).show();
                c2696g.jON = 0;
            }
            C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.jEl.field_msgId);
            if (jf.field_msgId != 0) {
                if (!C32850q.m53704K(jf)) {
                    C32850q.m53706M(jf);
                }
                AppMethodBeat.m2505o(14278);
                return;
            }
            AppMethodBeat.m2505o(14278);
        }
    }

    /* renamed from: a */
    public final View mo45312a(Context context, C38701a c38701a) {
        AppMethodBeat.m2504i(14279);
        super.mo45311b(context, c38701a);
        View view;
        if (this.jOR != null) {
            view = this.jOR;
            AppMethodBeat.m2505o(14279);
            return view;
        }
        this.jOR = View.inflate(context, 2130968879, null);
        aWH();
        this.jPi = (MMNeat7extView) this.jOR.findViewById(2131821185);
        this.jPY = (TextView) this.jOR.findViewById(2131821873);
        this.jOY = (ImageView) this.jOR.findViewById(2131821876);
        this.jPL = this.jOR.findViewById(2131821875);
        this.jOS = this.jOR.findViewById(2131821838);
        this.jQb = (MMNeat7extView) this.jOR.findViewById(2131821840);
        this.jPj = this.jOR.findViewById(2131821874);
        this.jPk = this.jOR.findViewById(2131821877);
        this.jPZ = (ImageView) this.jOR.findViewById(2131821843);
        this.jQa = (ImageView) this.jOR.findViewById(2131821842);
        view = this.jOR;
        AppMethodBeat.m2505o(14279);
        return view;
    }
}
