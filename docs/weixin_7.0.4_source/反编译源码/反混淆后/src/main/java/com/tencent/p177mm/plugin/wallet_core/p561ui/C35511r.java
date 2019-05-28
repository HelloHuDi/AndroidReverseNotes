package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.wallet_core.model.C22582aa;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.r */
public final class C35511r extends BaseAdapter {
    private Context mContext;
    ArrayList<C22582aa> mData = null;
    C22582aa tKX = null;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.r$a */
    class C29683a {
        TextView gsf;
        ImageView tKY;

        private C29683a() {
        }

        /* synthetic */ C29683a(C35511r c35511r, byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(47688);
        C22582aa Hz = mo56252Hz(i);
        AppMethodBeat.m2505o(47688);
        return Hz;
    }

    public C35511r(Context context, ArrayList<C22582aa> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(47685);
        if (this.mData != null) {
            int size = this.mData.size();
            AppMethodBeat.m2505o(47685);
            return size;
        }
        AppMethodBeat.m2505o(47685);
        return 0;
    }

    /* renamed from: Hz */
    public final C22582aa mo56252Hz(int i) {
        AppMethodBeat.m2504i(47686);
        if (this.mData == null || getCount() <= i) {
            AppMethodBeat.m2505o(47686);
            return null;
        }
        C22582aa c22582aa = (C22582aa) this.mData.get(i);
        AppMethodBeat.m2505o(47686);
        return c22582aa;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C29683a c29683a;
        AppMethodBeat.m2504i(47687);
        if (view == null) {
            view = View.inflate(this.mContext, 2130971177, null);
            C29683a c29683a2 = new C29683a(this, (byte) 0);
            c29683a2.gsf = (TextView) view.findViewById(2131820678);
            c29683a2.tKY = (ImageView) view.findViewById(2131829054);
            view.setTag(c29683a2);
            c29683a = c29683a2;
        } else {
            c29683a = (C29683a) view.getTag();
        }
        C22582aa Hz = mo56252Hz(i);
        if (Hz != null) {
            c29683a.gsf.setText(Hz.field_wallet_name);
            if (Hz.field_wallet_selected == 1) {
                this.tKX = Hz;
                c29683a.tKY.setImageResource(C1318a.radio_on);
            } else {
                c29683a.tKY.setImageResource(C1318a.radio_off);
            }
        }
        AppMethodBeat.m2505o(47687);
        return view;
    }
}
