package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class l extends BaseAdapter {
    private List<String> gnO;
    private Context mContext;
    private List<String> vli;

    static class a {
        public ImageView ejo;
        public TextView gxi;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public l(Context context, List<String> list, List<String> list2) {
        this.mContext = context;
        this.gnO = list2;
        this.vli = list;
    }

    public final int getCount() {
        AppMethodBeat.i(27717);
        int size = this.gnO.size();
        AppMethodBeat.o(27717);
        return size;
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(27718);
        Object obj = this.gnO.get(i);
        AppMethodBeat.o(27718);
        return obj;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a ex;
        AppMethodBeat.i(27719);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.kx, null);
            ex = ex(view);
        } else {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                ex = ex(view);
            } else {
                ex = aVar;
            }
        }
        int size = this.gnO.size() % 4;
        if (i >= 0 && i < this.gnO.size() && i < this.vli.size()) {
            ex.ejo.setVisibility(0);
            ex.gxi.setVisibility(0);
            b.b(ex.ejo, (String) this.vli.get(i));
            ex.gxi.setText((CharSequence) this.gnO.get(i));
            ex.gxi.setText(((com.tencent.mm.plugin.emoji.b.a) g.K(com.tencent.mm.plugin.emoji.b.a.class)).a(this.mContext, (CharSequence) this.gnO.get(i), ex.gxi.getTextSize()));
            if (this.gnO.size() <= 12 || i < this.gnO.size() - size) {
                ex.gxi.setPadding(0, 0, 0, 0);
            } else {
                ex.gxi.setPadding(0, 0, 0, com.tencent.mm.bz.a.al(this.mContext, R.dimen.fj));
            }
        }
        AppMethodBeat.o(27719);
        return view;
    }

    private static a ex(View view) {
        AppMethodBeat.i(27720);
        a aVar = new a();
        aVar.ejo = (ImageView) view.findViewById(R.id.al3);
        aVar.gxi = (TextView) view.findViewById(R.id.al4);
        view.setTag(aVar);
        AppMethodBeat.o(27720);
        return aVar;
    }
}
