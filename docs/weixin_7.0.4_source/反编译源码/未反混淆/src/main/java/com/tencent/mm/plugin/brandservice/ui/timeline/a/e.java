package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
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
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.q;
import java.util.Iterator;

public class e {
    public ImageView ejo;
    public TextView enf;
    public View jOR;
    private OnClickListener jPb = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(14249);
            q B = z.aeX().B(((a) g.K(a.class)).cY(view), "msgId");
            if (B != null) {
                e.this.jPm.jNy.d(B, 4);
                AppMethodBeat.o(14249);
                return;
            }
            ab.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
            AppMethodBeat.o(14249);
        }
    };
    public com.tencent.mm.plugin.brandservice.ui.timeline.a jPm;
    public View jPn;
    public View jPo;
    public TextView jPp;
    public Context mContext;

    public e() {
        AppMethodBeat.i(14250);
        AppMethodBeat.o(14250);
    }

    public final void b(Context context, com.tencent.mm.plugin.brandservice.ui.timeline.a aVar) {
        this.mContext = context;
        this.jPm = aVar;
    }

    public void a(View view, com.tencent.mm.plugin.brandservice.ui.timeline.a aVar) {
        AppMethodBeat.i(14251);
        b(view.getContext(), aVar);
        AppMethodBeat.o(14251);
    }

    public void aWH() {
        AppMethodBeat.i(14252);
        if (this.jOR == null) {
            AppMethodBeat.o(14252);
            return;
        }
        this.ejo = (ImageView) this.jOR.findViewById(R.id.qk);
        this.jPp = (TextView) this.jOR.findViewById(R.id.a76);
        this.enf = (TextView) this.jOR.findViewById(R.id.la);
        this.jPo = this.jOR.findViewById(R.id.a75);
        AppMethodBeat.o(14252);
    }

    public static void N(View view, int i) {
        AppMethodBeat.i(14253);
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(14253);
    }

    public final boolean a(c cVar, q qVar, p pVar) {
        AppMethodBeat.i(14254);
        boolean a = a(cVar.jOZ, cVar.jPa, qVar, pVar);
        AppMethodBeat.o(14254);
        return a;
    }

    public final boolean a(View view, TextView textView, q qVar, p pVar) {
        AppMethodBeat.i(14255);
        if (pVar == null || bo.isNullOrNil(pVar.url) || qVar.field_appMsgStatInfoProto == null || bo.ek(qVar.field_appMsgStatInfoProto.vGJ)) {
            view.setVisibility(8);
            AppMethodBeat.o(14255);
            return false;
        }
        int i;
        Iterator it = qVar.field_appMsgStatInfoProto.vGJ.iterator();
        while (it.hasNext()) {
            eu euVar = (eu) it.next();
            if (bo.isEqual(euVar.url, pVar.url)) {
                i = euVar.vGI;
                break;
            }
        }
        i = 0;
        if (i > 0) {
            view.setVisibility(0);
            if (pVar.type == 5) {
                textView.setText(this.mContext.getString(R.string.a9w, new Object[]{Integer.valueOf(i)}));
            } else {
                textView.setText(this.mContext.getString(R.string.a9v, new Object[]{Integer.valueOf(i)}));
            }
            AppMethodBeat.o(14255);
            return true;
        }
        view.setVisibility(8);
        AppMethodBeat.o(14255);
        return false;
    }

    public void a(ImageView imageView, q qVar, int i, String str) {
        AppMethodBeat.i(14256);
        ((a) g.K(a.class)).a((View) imageView, qVar.field_msgId, str, qVar.field_content, i);
        imageView.setOnClickListener(this.jPb);
        AppMethodBeat.o(14256);
    }
}
