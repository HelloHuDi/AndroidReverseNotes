package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C46627q;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.d */
public final class C38696d extends C33729a {
    public View jOS;
    public ImageView jPf;
    public ImageView jPg;
    public ImageView jPh;
    public MMNeat7extView jPi;
    public View jPj;
    public View jPk;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.d$3 */
    public class C112273 implements OnClickListener {
        final /* synthetic */ C46627q jEl;

        public C112273(C46627q c46627q) {
            this.jEl = c46627q;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14246);
            C38696d.m65630a(C38696d.this, view, this.jEl);
            AppMethodBeat.m2505o(14246);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.d$1 */
    public class C386951 implements OnClickListener {
        final /* synthetic */ C46627q jEl;

        public C386951(C46627q c46627q) {
            this.jEl = c46627q;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14245);
            C38696d.m65630a(C38696d.this, view, this.jEl);
            AppMethodBeat.m2505o(14245);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.d$2 */
    public class C386972 implements OnLongClickListener {
        final /* synthetic */ C46627q jEl;

        public C386972(C46627q c46627q) {
            this.jEl = c46627q;
        }

        public final boolean onLongClick(View view) {
            C38696d.this.jPm.jNl = this.jEl;
            C38696d.this.jPm.jNn = 1;
            return true;
        }
    }

    /* renamed from: a */
    public final View mo61546a(Context context, C38701a c38701a) {
        AppMethodBeat.m2504i(14247);
        super.mo45311b(context, c38701a);
        View view;
        if (this.jOR != null) {
            view = this.jOR;
            AppMethodBeat.m2505o(14247);
            return view;
        }
        this.jOR = View.inflate(context, 2130968864, null);
        aWH();
        this.jPf = (ImageView) this.jOR.findViewById(2131821827);
        this.jPg = (ImageView) this.jOR.findViewById(2131821828);
        this.jPh = (ImageView) this.jOR.findViewById(2131821842);
        this.jOS = this.jOR.findViewById(2131821838);
        this.jPj = this.jOR.findViewById(2131821826);
        this.jPk = this.jOR.findViewById(2131821825);
        this.jPi = (MMNeat7extView) this.jOR.findViewById(2131821840);
        view = this.jOR;
        AppMethodBeat.m2505o(14247);
        return view;
    }

    /* renamed from: a */
    static /* synthetic */ void m65630a(C38696d c38696d, View view, C46627q c46627q) {
        AppMethodBeat.m2504i(14248);
        Intent intent = new Intent();
        intent.putExtra("key_is_biz_chat", false);
        if (c46627q == null) {
            C4990ab.m7412e("MicroMsg.BizTimeLineItem", "[enterGallery] item == null");
            AppMethodBeat.m2505o(14248);
            return;
        }
        int width;
        int height;
        int i = c38696d.mContext.getResources().getConfiguration().orientation;
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
        intent.putExtra("img_gallery_msg_id", c46627q.field_msgId).putExtra("img_gallery_msg_svr_id", c46627q.field_msgSvrId).putExtra("img_gallery_talker", c46627q.field_talker).putExtra("img_gallery_chatroom_name", c46627q.field_talker).putExtra("img_gallery_orientation", i);
        if (view != null) {
            intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
        } else {
            intent.putExtra("img_gallery_back_from_grid", true);
        }
        C25985d.m41473f(c38696d.mContext, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI", intent);
        ((Activity) c38696d.mContext).overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(14248);
    }
}
