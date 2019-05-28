package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import java.io.IOException;

public final class b extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static com.tencent.mm.ui.base.sortview.a.b jKQ;
    CharSequence gnx;
    protected String iconUrl;
    protected CharSequence jKF;
    protected boolean jKI;
    protected boolean jKJ;
    protected String jKR;
    protected String username;

    public static class a extends com.tencent.mm.plugin.brandservice.b.a.a implements com.tencent.mm.ui.base.sortview.a.a {
        public TextView ejp;
        public TextView jKK;
        public View jKL;
        public TextView jKM;
        public View jKP;
    }

    public b(Object obj, String str) {
        super(6, obj);
        this.jKR = str;
    }

    public final com.tencent.mm.ui.base.sortview.a.b aVY() {
        AppMethodBeat.i(13872);
        if (jKQ == null) {
            jKQ = new com.tencent.mm.ui.base.sortview.a.b() {
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    AppMethodBeat.i(13868);
                    if (aVar instanceof b) {
                        String str;
                        String str2;
                        b bVar = (b) aVar;
                        bvn bvn = (bvn) aVar.getData();
                        if (bvn.wyX != null) {
                            str = bvn.wyX.wVI;
                        } else {
                            str = null;
                        }
                        if (bvn.wcB != null) {
                            str2 = bvn.wcB.wVI;
                        } else {
                            str2 = null;
                        }
                        if (bo.isNullOrNil(str2)) {
                            ab.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
                            AppMethodBeat.o(13868);
                            return false;
                        }
                        ad aoO = ((j) g.K(j.class)).XM().aoO(str2);
                        Intent intent = new Intent();
                        if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                            intent.putExtra("Contact_User", str2);
                            intent.putExtra("Contact_Scene", 55);
                        } else {
                            intent.putExtra("Contact_User", str2);
                            intent.putExtra("Contact_Alias", bvn.guS);
                            intent.putExtra("Contact_Nick", str);
                            intent.putExtra("Contact_Signature", bvn.guQ);
                            intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(bvn.guW, bvn.guO, bvn.guP));
                            intent.putExtra("Contact_Sex", bvn.guN);
                            intent.putExtra("Contact_VUser_Info", bvn.wBU);
                            intent.putExtra("Contact_VUser_Info_Flag", bvn.wBT);
                            intent.putExtra("Contact_KWeibo_flag", bvn.wBX);
                            intent.putExtra("Contact_KWeibo", bvn.wBV);
                            intent.putExtra("Contact_KWeiboNick", bvn.wBW);
                            intent.putExtra("Contact_Scene", 55);
                            if (bvn.wCa != null) {
                                try {
                                    intent.putExtra("Contact_customInfo", bvn.wCa.toByteArray());
                                } catch (IOException e) {
                                    ab.printErrStackTrace("MicroMsg.BizRecommDataItem", e, "", new Object[0]);
                                }
                            }
                        }
                        com.tencent.mm.plugin.brandservice.b.gkE.c(intent, context);
                        c cVar = null;
                        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof c)) {
                            cVar = (c) objArr[0];
                        }
                        com.tencent.mm.plugin.brandservice.ui.c.b aWm = bVar.aWm();
                        if (!(aWm == null || cVar == null)) {
                            aWm.a(cVar, aVar, 1, str2, bVar.aWn(), bVar.getPosition());
                        }
                        AppMethodBeat.o(13868);
                        return true;
                    }
                    AppMethodBeat.o(13868);
                    return false;
                }

                public final View c(Context context, View view) {
                    AppMethodBeat.i(13869);
                    if (view == null) {
                        view = View.inflate(context, R.layout.aq3, null);
                    }
                    AppMethodBeat.o(13869);
                    return view;
                }

                public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                    int i = 0;
                    AppMethodBeat.i(13870);
                    if (context == null || aVar == null || aVar2 == null || aVar2.getData() == null) {
                        ab.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                        AppMethodBeat.o(13870);
                    } else if (!(aVar instanceof a)) {
                        ab.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
                        AppMethodBeat.o(13870);
                    } else if (aVar2.getData() instanceof bvn) {
                        a aVar3 = (a) aVar;
                        b bVar = (b) aVar2;
                        aVar3.username = bVar.username;
                        aVar3.iconUrl = bVar.iconUrl;
                        com.tencent.mm.pluginsdk.ui.a.b.r(aVar3.ejo, bVar.username);
                        aVar3.ejp.setText(bVar.gnx, BufferType.SPANNABLE);
                        aVar3.jKP.setVisibility(bVar.jKJ ? 0 : 8);
                        View view = aVar3.jKL;
                        if (!bVar.jKI) {
                            i = 8;
                        }
                        view.setVisibility(i);
                        aVar3.jKM.setText(bVar.jKF, BufferType.SPANNABLE);
                        com.tencent.mm.plugin.brandservice.b.a.b(aVar3.jKK, bVar.jKR);
                        AppMethodBeat.o(13870);
                    } else {
                        ab.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
                        AppMethodBeat.o(13870);
                    }
                }

                public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
                    AppMethodBeat.i(13871);
                    if (!(view == null || aVar == null || !(aVar instanceof a))) {
                        a aVar2 = (a) aVar;
                        aVar2.ejo = (ImageView) view.findViewById(R.id.bj0);
                        aVar2.ejp = (TextView) view.findViewById(R.id.bzm);
                        aVar2.jKK = (TextView) view.findViewById(R.id.nh);
                        aVar2.jKP = view.findViewById(R.id.bzo);
                        aVar2.jKL = view.findViewById(R.id.bzp);
                        aVar2.jKM = (TextView) view.findViewById(R.id.bzr);
                    }
                    AppMethodBeat.o(13871);
                }
            };
        }
        com.tencent.mm.ui.base.sortview.a.b bVar = jKQ;
        AppMethodBeat.o(13872);
        return bVar;
    }

    public final com.tencent.mm.ui.base.sortview.a.a aVZ() {
        AppMethodBeat.i(13873);
        a aVar = new a();
        AppMethodBeat.o(13873);
        return aVar;
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
        AppMethodBeat.i(13874);
        if (this.yDq) {
            AppMethodBeat.o(13874);
        } else if (context == null || aVar == null || this.data == null) {
            ab.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(13874);
        } else if (!(aVar instanceof a)) {
            ab.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
            AppMethodBeat.o(13874);
        } else if (this.data instanceof bvn) {
            bvn bvn = (bvn) this.data;
            try {
                this.gnx = com.tencent.mm.pluginsdk.ui.e.j.b(context, bvn.wyX != null ? bvn.wyX.toString() : "", ((a) aVar).ejp.getTextSize());
            } catch (Exception e) {
                this.gnx = "";
            }
            this.iconUrl = bvn.vXn;
            this.username = bvn.wcB.toString();
            AppMethodBeat.o(13874);
        } else {
            ab.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.o(13874);
        }
    }
}
