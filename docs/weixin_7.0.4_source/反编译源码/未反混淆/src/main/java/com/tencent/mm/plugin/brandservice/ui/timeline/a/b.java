package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.a;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class b extends e {
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
    private OnClickListener jPb = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(14238);
            q B = z.aeX().B(((a) g.K(a.class)).cY(view), "msgId");
            if (B != null) {
                b.this.jPm.jNy.d(B, 4);
                AppMethodBeat.o(14238);
                return;
            }
            ab.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
            AppMethodBeat.o(14238);
        }
    };

    public b(com.tencent.mm.plugin.brandservice.ui.timeline.a aVar, Context context) {
        AppMethodBeat.i(14239);
        super.b(context, aVar);
        AppMethodBeat.o(14239);
    }

    public final void a(p pVar, q qVar, int i, boolean z) {
        AppMethodBeat.i(14240);
        if (pVar.type == 5) {
            this.jOY.setVisibility(0);
            this.jOY.setImageResource(R.drawable.axj);
            this.jOY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(14237);
                    b.this.jOR.performClick();
                    AppMethodBeat.o(14237);
                }
            });
        } else if (pVar.type == 6) {
            this.jOY.setVisibility(0);
            if (z) {
                if ((qVar.field_msgId + "_" + i).equals(c.aYR())) {
                    this.jOY.setImageResource(R.drawable.ic);
                } else {
                    this.jOY.setImageResource(R.drawable.id);
                }
            } else if ((qVar.field_msgId + "_" + i).equals(c.aYR())) {
                this.jOY.setImageResource(R.raw.chatting_item_biz_music_pause_loading_icon);
            } else {
                this.jOY.setImageResource(R.raw.chatting_item_biz_music_play_loading_icon);
            }
            a(this.jOY, qVar, i, pVar.fjx);
        } else if (pVar.type == 7) {
            this.jOY.setVisibility(0);
            Drawable drawable = this.jOY.getDrawable();
            if ((drawable instanceof AnimationDrawable) && ((AnimationDrawable) drawable).isRunning()) {
                ((AnimationDrawable) drawable).stop();
            }
            if ((qVar.field_msgId + "_" + i).equals(c.aYR())) {
                this.jOY.setImageResource(R.drawable.ig);
                if (this.jOY.getDrawable() instanceof AnimationDrawable) {
                    ((AnimationDrawable) this.jOY.getDrawable()).start();
                }
            } else {
                this.jOY.setImageResource(R.drawable.f8if);
            }
            a(this.jOY, qVar, i, pVar.fjx);
        } else {
            this.jOY.setVisibility(8);
        }
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 28);
        if (pVar.type == 7) {
            fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 32);
        }
        M(this.jOY, fromDPToPix);
        AppMethodBeat.o(14240);
    }

    private static void M(View view, int i) {
        AppMethodBeat.i(14241);
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(14241);
    }

    public final void a(ImageView imageView, q qVar, int i, String str) {
        AppMethodBeat.i(14242);
        ((a) g.K(a.class)).a((View) imageView, qVar.field_msgId, str, qVar.field_content, i);
        imageView.setOnClickListener(this.jPb);
        AppMethodBeat.o(14242);
    }
}
