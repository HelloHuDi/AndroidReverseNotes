package com.tencent.mm.plugin.game.ui.tab;

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
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends BaseAdapter {
    private Context mContext;
    private GameTabData nng;
    private String nnh;

    public class a {
        TextView gsf;
        ImageView iNr;

        public a(View view) {
            AppMethodBeat.i(112232);
            this.gsf = (TextView) view.findViewById(R.id.c9y);
            this.iNr = (ImageView) view.findViewById(R.id.c9x);
            AppMethodBeat.o(112232);
        }
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final void a(GameTabData gameTabData, String str) {
        AppMethodBeat.i(112233);
        this.nng = gameTabData;
        this.nnh = str;
        notifyDataSetChanged();
        AppMethodBeat.o(112233);
    }

    public final int getCount() {
        AppMethodBeat.i(112234);
        if (this.nng == null) {
            AppMethodBeat.o(112234);
            return 0;
        }
        int size = this.nng.getItemList().size();
        AppMethodBeat.o(112234);
        return size;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(112235);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.a5w, viewGroup, false);
        a aVar = new a(inflate);
        TabItem tabItem = (TabItem) this.nng.getItemList().get(i);
        if (tabItem != null) {
            aVar.gsf.setText(tabItem.title);
            String str;
            com.tencent.mm.at.a.a.c.a aVar2;
            if (bo.nullAsNil(this.nnh).equalsIgnoreCase(tabItem.mYp)) {
                if (!bo.isNullOrNil(tabItem.mYv)) {
                    str = aj.mYz + g.x(tabItem.mYv.getBytes());
                    aVar2 = new com.tencent.mm.at.a.a.c.a();
                    aVar2.ePH = true;
                    aVar2.ePJ = str;
                    com.tencent.mm.at.a.a.ahv().a(tabItem.mYv, aVar.iNr, aVar2.ahG());
                }
            } else if (!bo.isNullOrNil(tabItem.mYu)) {
                str = aj.mYz + g.x(tabItem.mYu.getBytes());
                aVar2 = new com.tencent.mm.at.a.a.c.a();
                aVar2.ePH = true;
                aVar2.ePJ = str;
                com.tencent.mm.at.a.a.ahv().a(tabItem.mYu, aVar.iNr, aVar2.ahG());
            }
        }
        inflate.setTag(tabItem);
        AppMethodBeat.o(112235);
        return inflate;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(112236);
        TabItem tabItem = (TabItem) this.nng.getItemList().get(i);
        AppMethodBeat.o(112236);
        return tabItem;
    }
}
