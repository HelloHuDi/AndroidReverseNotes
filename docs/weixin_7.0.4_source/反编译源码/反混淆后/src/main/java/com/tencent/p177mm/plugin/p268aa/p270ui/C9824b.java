package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C46558k;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.ui.b */
public final class C9824b extends BaseAdapter {
    private Context context;
    List<C46558k> dataList = new ArrayList();
    int mode;

    /* renamed from: com.tencent.mm.plugin.aa.ui.b$a */
    class C9823a {
        public ImageView eks;
        public TextView gnd;
        public TextView gne;
        public TextView gnf;
        public TextView gng;
        public TextView gnh;

        public C9823a(View view) {
            AppMethodBeat.m2504i(40714);
            this.eks = (ImageView) view.findViewById(2131820887);
            this.gnd = (TextView) view.findViewById(2131820889);
            this.gne = (TextView) view.findViewById(2131820890);
            this.gnf = (TextView) view.findViewById(2131820891);
            this.gng = (TextView) view.findViewById(2131820892);
            this.gnh = (TextView) view.findViewById(2131820893);
            AppMethodBeat.m2505o(40714);
        }
    }

    public C9824b(Context context, int i) {
        AppMethodBeat.m2504i(40715);
        this.context = context;
        this.mode = i;
        AppMethodBeat.m2505o(40715);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(40716);
        int size = this.dataList.size();
        AppMethodBeat.m2505o(40716);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(40717);
        Object obj = this.dataList.get(i);
        AppMethodBeat.m2505o(40717);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(40718);
        if (view == null) {
            view = C5616v.m8409hu(this.context).inflate(2130968578, viewGroup, false);
            view.setTag(new C9823a(view));
        }
        C9823a c9823a = (C9823a) view.getTag();
        C46558k c46558k = (C46558k) getItem(i);
        c9823a.eks.setImageResource(C1318a.aa_record_default_icon);
        C40460b.m69436f(c9823a.eks, c46558k.vzM, C1318a.aa_record_default_icon);
        c9823a.gne.setText(C44089j.m79293b(this.context, c46558k.title, c9823a.gne.getTextSize()));
        CharSequence mJ = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(c46558k.vzM);
        if (C5046bo.isNullOrNil(mJ) || mJ.endsWith("@chatroom")) {
            mJ = this.context.getString(C25738R.string.f8644ar);
        }
        c9823a.gnd.setText(C44089j.m79293b(this.context, mJ, c9823a.gnd.getTextSize()));
        if (this.mode == 2) {
            c9823a.gnf.setText(c46558k.vzY);
        } else {
            c9823a.gnf.setText(c46558k.vzV);
        }
        c9823a.gng.setText(String.format("%s%s", new Object[]{Float.valueOf(((float) c46558k.cSh) / 100.0f), this.context.getString(C25738R.string.f8685c0)}));
        c9823a.gnh.setVisibility(0);
        if (this.mode != 2) {
            switch (c46558k.state) {
                case 1:
                    c9823a.gnh.setText(C25738R.string.f8659b_);
                    c9823a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f11686dk));
                    break;
                case 2:
                    c9823a.gnh.setText(C25738R.string.f8657b8);
                    c9823a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f11686dk));
                    break;
                case 3:
                    c9823a.gnh.setText(C25738R.string.f8655b6);
                    c9823a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f12266xy));
                    break;
                case 4:
                    c9823a.gnh.setText(C25738R.string.f8656b7);
                    c9823a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f12266xy));
                    break;
                default:
                    c9823a.gnh.setVisibility(4);
                    break;
            }
        }
        switch (c46558k.state) {
            case 1:
                c9823a.gnh.setText(C25738R.string.f8660ba);
                c9823a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f11686dk));
                break;
            case 2:
                c9823a.gnh.setText(C25738R.string.f8658b9);
                c9823a.gnh.setTextColor(this.context.getResources().getColor(C25738R.color.f11686dk));
                break;
            default:
                c9823a.gnh.setVisibility(4);
                break;
        }
        AppMethodBeat.m2505o(40718);
        return view;
    }

    public final void aot() {
        AppMethodBeat.m2504i(40719);
        this.dataList.clear();
        AppMethodBeat.m2505o(40719);
    }
}
