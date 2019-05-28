package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20022a;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C38689c;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C46627q;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.b */
public final class C33730b extends C27519e {
    public View jOR;
    public View jOS;
    public View jOT;
    public MMNeat7extView jOU;
    public TextView jOV;
    public View jOW;
    public ImageView jOX;
    public ImageView jOY;
    public View jOZ;
    public TextView jPa;
    private OnClickListener jPb = new C26942();

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.b$1 */
    class C26931 implements OnClickListener {
        C26931() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14237);
            C33730b.this.jOR.performClick();
            AppMethodBeat.m2505o(14237);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.b$2 */
    class C26942 implements OnClickListener {
        C26942() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14238);
            C46627q B = C41747z.aeX().mo64097B(((C20022a) C1720g.m3528K(C20022a.class)).mo35266cY(view), "msgId");
            if (B != null) {
                C33730b.this.jPm.jNy.mo35304d(B, 4);
                AppMethodBeat.m2505o(14238);
                return;
            }
            C4990ab.m7420w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
            AppMethodBeat.m2505o(14238);
        }
    }

    public C33730b(C38701a c38701a, Context context) {
        AppMethodBeat.m2504i(14239);
        super.mo45311b(context, c38701a);
        AppMethodBeat.m2505o(14239);
    }

    /* renamed from: a */
    public final void mo54268a(C32224p c32224p, C46627q c46627q, int i, boolean z) {
        AppMethodBeat.m2504i(14240);
        if (c32224p.type == 5) {
            this.jOY.setVisibility(0);
            this.jOY.setImageResource(C25738R.drawable.axj);
            this.jOY.setOnClickListener(new C26931());
        } else if (c32224p.type == 6) {
            this.jOY.setVisibility(0);
            if (z) {
                if ((c46627q.field_msgId + "_" + i).equals(C38689c.aYR())) {
                    this.jOY.setImageResource(C25738R.drawable.f6566ic);
                } else {
                    this.jOY.setImageResource(C25738R.drawable.f6567id);
                }
            } else if ((c46627q.field_msgId + "_" + i).equals(C38689c.aYR())) {
                this.jOY.setImageResource(C1318a.chatting_item_biz_music_pause_loading_icon);
            } else {
                this.jOY.setImageResource(C1318a.chatting_item_biz_music_play_loading_icon);
            }
            mo45307a(this.jOY, c46627q, i, c32224p.fjx);
        } else if (c32224p.type == 7) {
            this.jOY.setVisibility(0);
            Drawable drawable = this.jOY.getDrawable();
            if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                ((AnimationDrawable) drawable).stop();
            }
            if ((c46627q.field_msgId + "_" + i).equals(C38689c.aYR())) {
                this.jOY.setImageResource(C25738R.drawable.f6569ig);
                if (this.jOY.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) this.jOY.getDrawable()).start();
                }
            } else {
                this.jOY.setImageResource(C25738R.drawable.f6568if);
            }
            mo45307a(this.jOY, c46627q, i, c32224p.fjx);
        } else {
            this.jOY.setVisibility(8);
        }
        int fromDPToPix = C1338a.fromDPToPix(this.mContext, 28);
        if (c32224p.type == 7) {
            fromDPToPix = C1338a.fromDPToPix(this.mContext, 32);
        }
        C33730b.m55116M(this.jOY, fromDPToPix);
        AppMethodBeat.m2505o(14240);
    }

    /* renamed from: M */
    private static void m55116M(View view, int i) {
        AppMethodBeat.m2504i(14241);
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(14241);
    }

    /* renamed from: a */
    public final void mo45307a(ImageView imageView, C46627q c46627q, int i, String str) {
        AppMethodBeat.m2504i(14242);
        ((C20022a) C1720g.m3528K(C20022a.class)).mo35261a((View) imageView, c46627q.field_msgId, str, c46627q.field_content, i);
        imageView.setOnClickListener(this.jPb);
        AppMethodBeat.m2505o(14242);
    }
}
