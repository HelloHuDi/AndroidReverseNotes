package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.aa;
import java.util.ArrayList;

public final class r extends BaseAdapter {
    private Context mContext;
    ArrayList<aa> mData = null;
    aa tKX = null;

    class a {
        TextView gsf;
        ImageView tKY;

        private a() {
        }

        /* synthetic */ a(r rVar, byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(47688);
        aa Hz = Hz(i);
        AppMethodBeat.o(47688);
        return Hz;
    }

    public r(Context context, ArrayList<aa> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
    }

    public final int getCount() {
        AppMethodBeat.i(47685);
        if (this.mData != null) {
            int size = this.mData.size();
            AppMethodBeat.o(47685);
            return size;
        }
        AppMethodBeat.o(47685);
        return 0;
    }

    public final aa Hz(int i) {
        AppMethodBeat.i(47686);
        if (this.mData == null || getCount() <= i) {
            AppMethodBeat.o(47686);
            return null;
        }
        aa aaVar = (aa) this.mData.get(i);
        AppMethodBeat.o(47686);
        return aaVar;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(47687);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.b6d, null);
            a aVar2 = new a(this, (byte) 0);
            aVar2.gsf = (TextView) view.findViewById(R.id.cx);
            aVar2.tKY = (ImageView) view.findViewById(R.id.fh1);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aa Hz = Hz(i);
        if (Hz != null) {
            aVar.gsf.setText(Hz.field_wallet_name);
            if (Hz.field_wallet_selected == 1) {
                this.tKX = Hz;
                aVar.tKY.setImageResource(R.raw.radio_on);
            } else {
                aVar.tKY.setImageResource(R.raw.radio_off);
            }
        }
        AppMethodBeat.o(47687);
        return view;
    }
}
