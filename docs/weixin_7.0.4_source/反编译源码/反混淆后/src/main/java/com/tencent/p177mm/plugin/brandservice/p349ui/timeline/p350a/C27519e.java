package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.p350a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p181af.C32224p;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20022a;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.C38701a;
import com.tencent.p177mm.protocal.protobuf.C15337eu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C46627q;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.e */
public class C27519e {
    public ImageView ejo;
    public TextView enf;
    public View jOR;
    private OnClickListener jPb = new C112281();
    public C38701a jPm;
    public View jPn;
    public View jPo;
    public TextView jPp;
    public Context mContext;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.a.e$1 */
    class C112281 implements OnClickListener {
        C112281() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14249);
            C46627q B = C41747z.aeX().mo64097B(((C20022a) C1720g.m3528K(C20022a.class)).mo35266cY(view), "msgId");
            if (B != null) {
                C27519e.this.jPm.jNy.mo35304d(B, 4);
                AppMethodBeat.m2505o(14249);
                return;
            }
            C4990ab.m7420w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
            AppMethodBeat.m2505o(14249);
        }
    }

    public C27519e() {
        AppMethodBeat.m2504i(14250);
        AppMethodBeat.m2505o(14250);
    }

    /* renamed from: b */
    public final void mo45311b(Context context, C38701a c38701a) {
        this.mContext = context;
        this.jPm = c38701a;
    }

    /* renamed from: a */
    public void mo22941a(View view, C38701a c38701a) {
        AppMethodBeat.m2504i(14251);
        mo45311b(view.getContext(), c38701a);
        AppMethodBeat.m2505o(14251);
    }

    public void aWH() {
        AppMethodBeat.m2504i(14252);
        if (this.jOR == null) {
            AppMethodBeat.m2505o(14252);
            return;
        }
        this.ejo = (ImageView) this.jOR.findViewById(2131821183);
        this.jPp = (TextView) this.jOR.findViewById(2131821809);
        this.enf = (TextView) this.jOR.findViewById(2131820988);
        this.jPo = this.jOR.findViewById(2131821808);
        AppMethodBeat.m2505o(14252);
    }

    /* renamed from: N */
    public static void m43648N(View view, int i) {
        AppMethodBeat.m2504i(14253);
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(14253);
    }

    /* renamed from: a */
    public final boolean mo45309a(C45762c c45762c, C46627q c46627q, C32224p c32224p) {
        AppMethodBeat.m2504i(14254);
        boolean a = mo45308a(c45762c.jOZ, c45762c.jPa, c46627q, c32224p);
        AppMethodBeat.m2505o(14254);
        return a;
    }

    /* renamed from: a */
    public final boolean mo45308a(View view, TextView textView, C46627q c46627q, C32224p c32224p) {
        AppMethodBeat.m2504i(14255);
        if (c32224p == null || C5046bo.isNullOrNil(c32224p.url) || c46627q.field_appMsgStatInfoProto == null || C5046bo.m7548ek(c46627q.field_appMsgStatInfoProto.vGJ)) {
            view.setVisibility(8);
            AppMethodBeat.m2505o(14255);
            return false;
        }
        int i;
        Iterator it = c46627q.field_appMsgStatInfoProto.vGJ.iterator();
        while (it.hasNext()) {
            C15337eu c15337eu = (C15337eu) it.next();
            if (C5046bo.isEqual(c15337eu.url, c32224p.url)) {
                i = c15337eu.vGI;
                break;
            }
        }
        i = 0;
        if (i > 0) {
            view.setVisibility(0);
            if (c32224p.type == 5) {
                textView.setText(this.mContext.getString(C25738R.string.a9w, new Object[]{Integer.valueOf(i)}));
            } else {
                textView.setText(this.mContext.getString(C25738R.string.a9v, new Object[]{Integer.valueOf(i)}));
            }
            AppMethodBeat.m2505o(14255);
            return true;
        }
        view.setVisibility(8);
        AppMethodBeat.m2505o(14255);
        return false;
    }

    /* renamed from: a */
    public void mo45307a(ImageView imageView, C46627q c46627q, int i, String str) {
        AppMethodBeat.m2504i(14256);
        ((C20022a) C1720g.m3528K(C20022a.class)).mo35261a((View) imageView, c46627q.field_msgId, str, c46627q.field_content, i);
        imageView.setOnClickListener(this.jPb);
        AppMethodBeat.m2505o(14256);
    }
}
