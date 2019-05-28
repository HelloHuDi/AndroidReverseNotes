package com.tencent.p177mm.plugin.game.p433ui.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.plugin.game.model.C6936aj;
import com.tencent.p177mm.plugin.game.model.GameTabData;
import com.tencent.p177mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.tab.a */
public final class C39239a extends BaseAdapter {
    private Context mContext;
    private GameTabData nng;
    private String nnh;

    /* renamed from: com.tencent.mm.plugin.game.ui.tab.a$a */
    public class C34321a {
        TextView gsf;
        ImageView iNr;

        public C34321a(View view) {
            AppMethodBeat.m2504i(112232);
            this.gsf = (TextView) view.findViewById(2131824649);
            this.iNr = (ImageView) view.findViewById(2131824648);
            AppMethodBeat.m2505o(112232);
        }
    }

    public C39239a(Context context) {
        this.mContext = context;
    }

    /* renamed from: a */
    public final void mo62147a(GameTabData gameTabData, String str) {
        AppMethodBeat.m2504i(112233);
        this.nng = gameTabData;
        this.nnh = str;
        notifyDataSetChanged();
        AppMethodBeat.m2505o(112233);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(112234);
        if (this.nng == null) {
            AppMethodBeat.m2505o(112234);
            return 0;
        }
        int size = this.nng.getItemList().size();
        AppMethodBeat.m2505o(112234);
        return size;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(112235);
        View inflate = LayoutInflater.from(this.mContext).inflate(2130969786, viewGroup, false);
        C34321a c34321a = new C34321a(inflate);
        TabItem tabItem = (TabItem) this.nng.getItemList().get(i);
        if (tabItem != null) {
            c34321a.gsf.setText(tabItem.title);
            String str;
            C17927a c17927a;
            if (C5046bo.nullAsNil(this.nnh).equalsIgnoreCase(tabItem.mYp)) {
                if (!C5046bo.isNullOrNil(tabItem.mYv)) {
                    str = C6936aj.mYz + C1178g.m2591x(tabItem.mYv.getBytes());
                    c17927a = new C17927a();
                    c17927a.ePH = true;
                    c17927a.ePJ = str;
                    C25815a.ahv().mo43766a(tabItem.mYv, c34321a.iNr, c17927a.ahG());
                }
            } else if (!C5046bo.isNullOrNil(tabItem.mYu)) {
                str = C6936aj.mYz + C1178g.m2591x(tabItem.mYu.getBytes());
                c17927a = new C17927a();
                c17927a.ePH = true;
                c17927a.ePJ = str;
                C25815a.ahv().mo43766a(tabItem.mYu, c34321a.iNr, c17927a.ahG());
            }
        }
        inflate.setTag(tabItem);
        AppMethodBeat.m2505o(112235);
        return inflate;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(112236);
        TabItem tabItem = (TabItem) this.nng.getItemList().get(i);
        AppMethodBeat.m2505o(112236);
        return tabItem;
    }
}
