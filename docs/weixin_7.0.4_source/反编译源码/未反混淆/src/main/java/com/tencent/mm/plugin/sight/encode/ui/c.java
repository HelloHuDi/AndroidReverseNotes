package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class c extends o {
    public static boolean qAQ = true;
    public static boolean qAR = false;
    List<String> qAO;
    boolean qAP;

    public class a extends e {

        public class a extends com.tencent.mm.ui.contact.a.e.a {
            public View qAT;
            public View qzN;

            public a() {
                super();
            }
        }

        public class b extends com.tencent.mm.ui.contact.a.e.b {
            public b() {
                super();
            }

            public final View a(Context context, ViewGroup viewGroup) {
                AppMethodBeat.i(25060);
                View inflate = LayoutInflater.from(context).inflate(R.layout.atf, viewGroup, false);
                a aVar = (a) a.this.clJ();
                aVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
                aVar.gnB = (TextView) inflate.findViewById(R.id.qm);
                aVar.gnC = (TextView) inflate.findViewById(R.id.ld);
                aVar.contentView = inflate.findViewById(R.id.de9);
                aVar.gnD = (CheckBox) inflate.findViewById(R.id.a1b);
                aVar.qzN = inflate.findViewById(R.id.ee1);
                aVar.qAT = inflate.findViewById(R.id.b63);
                inflate.setTag(aVar);
                aVar.gnB.setTextColor(-1);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.width = -1;
                inflate.setLayoutParams(layoutParams);
                inflate.setBackgroundResource(R.color.h4);
                AppMethodBeat.o(25060);
                return inflate;
            }

            public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
                AppMethodBeat.i(25061);
                ad adVar = aVar2.ehM;
                a aVar3 = (a) aVar;
                aVar3.contentView.setVisibility(0);
                aVar3.qAT.setVisibility(8);
                aVar3.qzN.setVisibility(8);
                ViewGroup.LayoutParams layoutParams;
                LinearLayout.LayoutParams layoutParams2;
                if (c.WV(adVar.field_username)) {
                    aVar3.ejo.setImageResource(R.raw.sight_icon_draft_item);
                    aVar3.gnB.setText(R.string.ei9);
                    aVar3.gnC.setText(R.string.ei7);
                    aVar3.gnC.setVisibility(0);
                    aVar3.gnD.setEnabled(false);
                    if (c.qAR) {
                        aVar3.contentView.setBackgroundResource(R.drawable.aob);
                        aVar3.gnD.setVisibility(0);
                        aVar3.gnD.setBackgroundResource(R.raw.sight_list_checkbox_selected);
                        aVar3.qzN.setVisibility(0);
                    } else {
                        aVar3.contentView.setBackgroundResource(R.drawable.a0c);
                        aVar3.gnD.setVisibility(8);
                        aVar3.gnD.setBackgroundResource(R.raw.sight_list_checkbox_unselected);
                        aVar3.qzN.setVisibility(8);
                    }
                    c.e(context, aVar3.contentView);
                    layoutParams = aVar3.ejo.getLayoutParams();
                    layoutParams.width = com.tencent.mm.bz.a.al(context, R.dimen.a8c);
                    layoutParams.height = com.tencent.mm.bz.a.al(context, R.dimen.a8c);
                    aVar3.ejo.setLayoutParams(layoutParams);
                    layoutParams2 = (LinearLayout.LayoutParams) aVar3.gnD.getLayoutParams();
                    layoutParams2.height = com.tencent.mm.bz.a.al(context, R.dimen.a8i);
                    layoutParams2.width = com.tencent.mm.bz.a.al(context, R.dimen.a8i);
                    layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                    aVar3.gnD.setLayoutParams(layoutParams2);
                    AppMethodBeat.o(25061);
                    return;
                }
                if (c.WT(adVar.field_username)) {
                    aVar3.ejo.setImageResource(R.raw.sight_item_sns_icon);
                    aVar3.gnD.setVisibility(8);
                    aVar3.gnB.setText(context.getString(R.string.eii));
                    aVar3.gnC.setVisibility(8);
                    if (c.qAQ) {
                        aVar3.contentView.setBackgroundResource(R.drawable.a0c);
                        aVar3.qzN.setVisibility(8);
                    } else {
                        aVar3.contentView.setBackgroundResource(R.drawable.aob);
                        aVar3.qzN.setVisibility(0);
                    }
                    c.e(context, aVar3.contentView);
                } else if (c.WU(adVar.field_username)) {
                    aVar3.contentView.setVisibility(8);
                    aVar3.qAT.setVisibility(0);
                    AppMethodBeat.o(25061);
                    return;
                } else {
                    super.a(context, aVar, aVar2, z, z2);
                    aVar3.contentView.setBackgroundResource(R.drawable.a0c);
                    c.e(context, aVar3.contentView);
                }
                layoutParams = aVar3.ejo.getLayoutParams();
                layoutParams.width = com.tencent.mm.bz.a.al(context, R.dimen.a8c);
                layoutParams.height = com.tencent.mm.bz.a.al(context, R.dimen.a8c);
                aVar3.ejo.setLayoutParams(layoutParams);
                layoutParams2 = (LinearLayout.LayoutParams) aVar3.gnD.getLayoutParams();
                layoutParams2.height = com.tencent.mm.bz.a.al(context, R.dimen.a8i);
                layoutParams2.width = com.tencent.mm.bz.a.al(context, R.dimen.a8i);
                layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                aVar3.gnD.setLayoutParams(layoutParams2);
                aVar3.gnD.setBackgroundResource(R.drawable.a09);
                AppMethodBeat.o(25061);
            }
        }

        public a(int i) {
            super(i);
        }

        public final com.tencent.mm.ui.contact.a.a.b aou() {
            AppMethodBeat.i(25062);
            b bVar = new b();
            AppMethodBeat.o(25062);
            return bVar;
        }

        public final com.tencent.mm.ui.contact.a.a.a clJ() {
            AppMethodBeat.i(25063);
            a aVar = new a();
            AppMethodBeat.o(25063);
            return aVar;
        }
    }

    public c(l lVar) {
        super(lVar, new ArrayList(), true, true);
        AppMethodBeat.i(25064);
        this.qAP = true;
        this.qAP = true;
        this.qAO = null;
        AppMethodBeat.o(25064);
    }

    public final int getCount() {
        AppMethodBeat.i(25065);
        if (this.qAO == null) {
            AppMethodBeat.o(25065);
            return 0;
        }
        int size = this.qAO.size();
        AppMethodBeat.o(25065);
        return size;
    }

    public final void aZ(List<String> list) {
        AppMethodBeat.i(25066);
        clearCache();
        this.qAO = list;
        notifyDataSetChanged();
        AppMethodBeat.o(25066);
    }

    public final com.tencent.mm.ui.contact.a.a mP(int i) {
        AppMethodBeat.i(25067);
        if (this.qAO == null) {
            AppMethodBeat.o(25067);
            return null;
        } else if (i < 0 || i >= getCount()) {
            ab.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            AppMethodBeat.o(25067);
            return null;
        } else {
            ad adVar;
            com.tencent.mm.ui.contact.a.a aVar = new a(i);
            String str = (String) this.qAO.get(i);
            if (WT(str)) {
                adVar = new ad("@sns.tencent");
            } else if (WU(str)) {
                adVar = new ad("@search.tencent");
            } else if (WV(str)) {
                adVar = new ad("@draft.tencent");
            } else {
                aw.ZK();
                adVar = com.tencent.mm.model.c.XM().aoO((String) this.qAO.get(i));
            }
            aVar.ehM = adVar;
            aVar.zmW = this.qAP;
            AppMethodBeat.o(25067);
            return aVar;
        }
    }

    public static boolean WT(String str) {
        AppMethodBeat.i(25068);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(25068);
            return false;
        }
        boolean endsWith = str.endsWith("@sns.tencent");
        AppMethodBeat.o(25068);
        return endsWith;
    }

    public static boolean WU(String str) {
        AppMethodBeat.i(25069);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(25069);
            return false;
        }
        boolean endsWith = str.endsWith("@search.tencent");
        AppMethodBeat.o(25069);
        return endsWith;
    }

    public static boolean WV(String str) {
        AppMethodBeat.i(25070);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(25070);
            return false;
        }
        boolean endsWith = str.endsWith("@draft.tencent");
        AppMethodBeat.o(25070);
        return endsWith;
    }

    public final boolean clI() {
        return this.qAP;
    }

    static /* synthetic */ void e(Context context, View view) {
        AppMethodBeat.i(25071);
        if (view == null || context == null) {
            AppMethodBeat.o(25071);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = com.tencent.mm.bz.a.al(context, R.dimen.a8k);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        view.setLayoutParams(layoutParams);
        view.setPadding(com.tencent.mm.bz.a.fromDPToPix(context, 10), view.getPaddingTop(), com.tencent.mm.bz.a.fromDPToPix(context, 10), view.getPaddingTop());
        AppMethodBeat.o(25071);
    }
}
