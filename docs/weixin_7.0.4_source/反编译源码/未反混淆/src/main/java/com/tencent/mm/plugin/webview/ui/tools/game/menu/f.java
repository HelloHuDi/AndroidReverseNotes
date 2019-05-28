package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;

public final class f extends BaseAdapter {
    private static final String mVL = (b.eSn + "Game/HvMenu/");
    private Context mContext;
    l rBn;

    public class a {
        TextView gsf;
        ImageView iNr;

        public a(View view) {
            AppMethodBeat.i(8844);
            this.gsf = (TextView) view.findViewById(R.id.cx);
            this.iNr = (ImageView) view.findViewById(R.id.jb);
            AppMethodBeat.o(8844);
        }
    }

    static {
        AppMethodBeat.i(8849);
        AppMethodBeat.o(8849);
    }

    public f(Context context) {
        this.mContext = context;
    }

    public final void b(l lVar) {
        AppMethodBeat.i(8845);
        this.rBn = lVar;
        notifyDataSetChanged();
        AppMethodBeat.o(8845);
    }

    public final int getCount() {
        AppMethodBeat.i(8846);
        if (this.rBn == null) {
            AppMethodBeat.o(8846);
            return 0;
        }
        int size = this.rBn.size();
        AppMethodBeat.o(8846);
        return size;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(8847);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.a4v, viewGroup, false);
        a aVar = new a(inflate);
        m mVar = (m) this.rBn.yvT.get(i);
        if (!(mVar == null || mVar.getItemId() == -1)) {
            String charSequence = mVar.getTitle().toString();
            if (!bo.isNullOrNil(charSequence)) {
                String[] split = charSequence.split("__", 2);
                if (split.length == 1) {
                    aVar.gsf.setText(split[0]);
                } else {
                    aVar.gsf.setText(split[0]);
                    charSequence = split[1];
                    if (charSequence.startsWith("http")) {
                        String str = mVL + g.x(charSequence.getBytes());
                        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                        aVar2.ePH = true;
                        aVar2.ePJ = str;
                        com.tencent.mm.at.a.a.ahv().a(charSequence, aVar.iNr, aVar2.ahG());
                    } else {
                        aVar.iNr.setImageResource(ah.getResources().getIdentifier(charSequence, "drawable", ah.getPackageName()));
                    }
                }
                inflate.setTag(mVar);
                AppMethodBeat.o(8847);
                return inflate;
            }
        }
        inflate.setTag(null);
        AppMethodBeat.o(8847);
        return inflate;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(8848);
        m mVar = (m) this.rBn.yvT.get(i);
        AppMethodBeat.o(8848);
        return mVar;
    }
}
