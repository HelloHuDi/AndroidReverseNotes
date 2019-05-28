package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class d extends a {
    public View jOS;
    public ImageView jPf;
    public ImageView jPg;
    public ImageView jPh;
    public MMNeat7extView jPi;
    public View jPj;
    public View jPk;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.d$3 */
    public class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ q jEl;

        public AnonymousClass3(q qVar) {
            this.jEl = qVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(14246);
            d.a(d.this, view, this.jEl);
            AppMethodBeat.o(14246);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.d$1 */
    public class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ q jEl;

        public AnonymousClass1(q qVar) {
            this.jEl = qVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(14245);
            d.a(d.this, view, this.jEl);
            AppMethodBeat.o(14245);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.d$2 */
    public class AnonymousClass2 implements OnLongClickListener {
        final /* synthetic */ q jEl;

        public AnonymousClass2(q qVar) {
            this.jEl = qVar;
        }

        public final boolean onLongClick(View view) {
            d.this.jPm.jNl = this.jEl;
            d.this.jPm.jNn = 1;
            return true;
        }
    }

    public final View a(Context context, a aVar) {
        AppMethodBeat.i(14247);
        super.b(context, aVar);
        View view;
        if (this.jOR != null) {
            view = this.jOR;
            AppMethodBeat.o(14247);
            return view;
        }
        this.jOR = View.inflate(context, R.layout.h3, null);
        aWH();
        this.jPf = (ImageView) this.jOR.findViewById(R.id.a7n);
        this.jPg = (ImageView) this.jOR.findViewById(R.id.a7o);
        this.jPh = (ImageView) this.jOR.findViewById(R.id.a82);
        this.jOS = this.jOR.findViewById(R.id.a7y);
        this.jPj = this.jOR.findViewById(R.id.a7m);
        this.jPk = this.jOR.findViewById(R.id.a7l);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(R.id.a80);
        view = this.jOR;
        AppMethodBeat.o(14247);
        return view;
    }

    static /* synthetic */ void a(d dVar, View view, q qVar) {
        AppMethodBeat.i(14248);
        Intent intent = new Intent();
        intent.putExtra("key_is_biz_chat", false);
        if (qVar == null) {
            ab.e("MicroMsg.BizTimeLineItem", "[enterGallery] item == null");
            AppMethodBeat.o(14248);
            return;
        }
        int width;
        int height;
        int i = dVar.mContext.getResources().getConfiguration().orientation;
        int[] iArr = new int[2];
        if (view != null) {
            width = view.getWidth();
            height = view.getHeight();
            view.getLocationInWindow(iArr);
        } else {
            height = 0;
            width = 0;
        }
        intent.addFlags(536870912);
        intent.putExtra("img_gallery_msg_id", qVar.field_msgId).putExtra("img_gallery_msg_svr_id", qVar.field_msgSvrId).putExtra("img_gallery_talker", qVar.field_talker).putExtra("img_gallery_chatroom_name", qVar.field_talker).putExtra("img_gallery_orientation", i);
        if (view != null) {
            intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
        } else {
            intent.putExtra("img_gallery_back_from_grid", true);
        }
        com.tencent.mm.bp.d.f(dVar.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
        ((Activity) dVar.mContext).overridePendingTransition(0, 0);
        AppMethodBeat.o(14248);
    }
}
