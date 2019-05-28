package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import java.io.IOException;
import java.util.List;

public final class a extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static b jKE;
    protected String iconUrl;
    protected CharSequence jKF;
    protected CharSequence jKG;
    protected CharSequence jKH;
    protected boolean jKI;
    protected boolean jKJ;
    protected CharSequence nickName;
    protected String username;

    public static class a extends com.tencent.mm.plugin.brandservice.b.a.a implements com.tencent.mm.ui.base.sortview.a.a {
        public TextView emg;
        public TextView jKK;
        public View jKL;
        public TextView jKM;
        public TextView jKN;
        public TextView jKO;
        View jKP;
    }

    public static class b extends com.tencent.mm.ui.base.sortview.a.b {
        public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
            AppMethodBeat.i(13861);
            if (aVar instanceof a) {
                a aVar2 = (a) aVar;
                if (aVar.getData() instanceof mn) {
                    mn mnVar = (mn) aVar.getData();
                    if (mnVar.vQv == null || mnVar.vQv.vQb == null) {
                        ab.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                        AppMethodBeat.o(13861);
                        return false;
                    }
                    int i;
                    String str;
                    String str2;
                    c cVar = null;
                    String str3 = "";
                    if (objArr != null) {
                        c cVar2;
                        if (objArr.length <= 0 || !(objArr[0] instanceof c)) {
                            cVar2 = null;
                        } else {
                            cVar2 = (c) objArr[0];
                        }
                        if (objArr.length <= 2 || !(objArr[2] instanceof Integer)) {
                            i = 0;
                        } else {
                            i = ((Integer) objArr[2]).intValue();
                        }
                        if (objArr.length <= 3 || !(objArr[3] instanceof String)) {
                            cVar = cVar2;
                        } else {
                            str3 = (String) objArr[3];
                            cVar = cVar2;
                        }
                    } else {
                        i = 0;
                    }
                    String str4 = mnVar.vQv.mZj;
                    bvo bvo = mnVar.vQv.vQb;
                    if (bvo.wyX != null) {
                        str = bvo.wyX.wVI;
                    } else {
                        str = null;
                    }
                    if (bvo.wcB != null) {
                        str2 = bvo.wcB.wVI;
                    } else {
                        str2 = null;
                    }
                    if (bo.isNullOrNil(str2)) {
                        ab.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
                        AppMethodBeat.o(13861);
                        return false;
                    }
                    int i2;
                    ai.adO(str2);
                    if (bo.isNullOrNil(str4)) {
                        ad aoO = ((j) g.K(j.class)).XM().aoO(str2);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("Contact_Ext_Args_Search_Id", str3);
                        bundle.putInt("Contact_Ext_Args_Index", aVar2.aWn());
                        bundle.putString("Contact_Ext_Args_Query_String", "");
                        bundle.putInt("Contact_Scene", i);
                        intent.putExtra("Contact_Ext_Args", bundle);
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Scene", i);
                        if (!com.tencent.mm.n.a.jh(aoO.field_type)) {
                            intent.putExtra("Contact_Alias", bvo.guS);
                            intent.putExtra("Contact_Nick", str);
                            intent.putExtra("Contact_Signature", bvo.guQ);
                            intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(bvo.guW, bvo.guO, bvo.guP));
                            intent.putExtra("Contact_Sex", bvo.guN);
                            intent.putExtra("Contact_VUser_Info", bvo.wBU);
                            intent.putExtra("Contact_VUser_Info_Flag", bvo.wBT);
                            intent.putExtra("Contact_KWeibo_flag", bvo.wBX);
                            intent.putExtra("Contact_KWeibo", bvo.wBV);
                            intent.putExtra("Contact_KWeiboNick", bvo.wBW);
                            if (bvo.wWC != null) {
                                try {
                                    intent.putExtra("Contact_customInfo", bvo.wWC.toByteArray());
                                } catch (IOException e) {
                                    ab.printErrStackTrace("MicroMsg.BizContactDataItem", e, "", new Object[0]);
                                }
                            }
                        }
                        com.tencent.mm.plugin.brandservice.b.gkE.c(intent, context);
                        i2 = 1;
                    } else {
                        i2 = 8;
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", str4);
                        intent2.putExtra("useJs", true);
                        intent2.putExtra("vertical_scroll", true);
                        d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                    }
                    com.tencent.mm.plugin.brandservice.ui.c.b aWm = aVar2.aWm();
                    if (!(aWm == null || cVar == null)) {
                        aWm.a(cVar, aVar, i2, str2, aVar2.aWn(), aVar2.getPosition());
                    }
                    AppMethodBeat.o(13861);
                    return true;
                }
                ab.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
                AppMethodBeat.o(13861);
                return false;
            }
            AppMethodBeat.o(13861);
            return false;
        }

        public final View c(Context context, View view) {
            AppMethodBeat.i(13862);
            if (view == null) {
                view = View.inflate(context, R.layout.aq3, null);
            }
            AppMethodBeat.o(13862);
            return view;
        }

        public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
            int i = 8;
            AppMethodBeat.i(13863);
            if (context == null || aVar == null || aVar2 == null || aVar2.getData() == null) {
                ab.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                AppMethodBeat.o(13863);
            } else if (!(aVar instanceof a)) {
                ab.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
                AppMethodBeat.o(13863);
            } else if (aVar2 instanceof a) {
                int i2;
                a aVar3 = (a) aVar;
                a aVar4 = (a) aVar2;
                aVar3.username = aVar4.username;
                aVar3.iconUrl = aVar4.iconUrl;
                com.tencent.mm.pluginsdk.ui.a.b.r(aVar3.ejo, aVar4.username);
                View view = aVar3.jKL;
                if (aVar4.jKI) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view.setVisibility(i2);
                View view2 = aVar3.jKP;
                if (aVar4.jKJ) {
                    i = 0;
                }
                view2.setVisibility(i);
                com.tencent.mm.plugin.brandservice.b.a.b(aVar3.emg, aVar4.nickName);
                boolean b = com.tencent.mm.plugin.brandservice.b.a.b(aVar3.jKO, aVar4.jKH);
                boolean b2 = com.tencent.mm.plugin.brandservice.b.a.b(aVar3.jKN, aVar4.jKG);
                if (com.tencent.mm.plugin.brandservice.b.a.b(aVar3.jKM, aVar4.jKF)) {
                    if (b || b2) {
                        aVar3.jKM.setMaxLines(1);
                    } else {
                        aVar3.jKM.setMaxLines(2);
                    }
                }
                ab.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", aVar4.nickName, aVar4.jKG);
                AppMethodBeat.o(13863);
            } else {
                ab.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
                AppMethodBeat.o(13863);
            }
        }

        public final void a(View view, com.tencent.mm.ui.base.sortview.a.a aVar) {
            AppMethodBeat.i(13864);
            if (!(view == null || aVar == null || !(aVar instanceof a))) {
                a aVar2 = (a) aVar;
                aVar2.jKK = (TextView) view.findViewById(R.id.nh);
                aVar2.jKP = view.findViewById(R.id.bzo);
                aVar2.ejo = (ImageView) view.findViewById(R.id.bj0);
                aVar2.emg = (TextView) view.findViewById(R.id.bzm);
                aVar2.jKL = view.findViewById(R.id.bzp);
                aVar2.jKN = (TextView) view.findViewById(R.id.bzt);
                aVar2.jKM = (TextView) view.findViewById(R.id.bzr);
                aVar2.jKO = (TextView) view.findViewById(R.id.bzq);
            }
            AppMethodBeat.o(13864);
        }
    }

    public a(Object obj) {
        super(5, obj);
    }

    public final com.tencent.mm.ui.base.sortview.a.b aVY() {
        AppMethodBeat.i(13865);
        if (jKE == null) {
            jKE = new b();
        }
        b bVar = jKE;
        AppMethodBeat.o(13865);
        return bVar;
    }

    public final com.tencent.mm.ui.base.sortview.a.a aVZ() {
        AppMethodBeat.i(13866);
        a aVar = new a();
        AppMethodBeat.o(13866);
        return aVar;
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
        com.tencent.mm.aj.d.b.d dVar = null;
        AppMethodBeat.i(13867);
        if (this.yDq) {
            AppMethodBeat.o(13867);
        } else if (context == null || aVar == null || this.data == null) {
            ab.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(13867);
        } else if (!(aVar instanceof a)) {
            ab.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            AppMethodBeat.o(13867);
        } else if (this.data instanceof mn) {
            a aVar2 = (a) aVar;
            mn mnVar = (mn) this.data;
            if (mnVar.vQv == null || mnVar.vQv.vQb == null) {
                ab.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                AppMethodBeat.o(13867);
                return;
            }
            String str;
            com.tencent.mm.aj.d dVar2;
            bvo bvo = mnVar.vQv.vQb;
            mi miVar = mnVar.vQv.vPY;
            if (objArr != null && objArr.length > 1 && (objArr[1] instanceof List)) {
                this.jMJ = (List) objArr[1];
            }
            this.username = bvo.wcB.wVI;
            this.iconUrl = bvo.vXn;
            this.jKG = miVar == null ? "" : miVar.vQh;
            if (bvo.wyX == null) {
                str = null;
            } else {
                str = bvo.wyX.wVI;
            }
            try {
                List list = this.jMJ;
                aVar2.emg.getTextSize();
                this.nickName = com.tencent.mm.plugin.brandservice.b.a.b(context, str, list);
            } catch (Exception e) {
                this.nickName = "";
            }
            String str2 = bvo.wcB.wVI;
            uz uzVar = bvo.wWC;
            if (uzVar != null) {
                dVar2 = new com.tencent.mm.aj.d();
                dVar2.field_username = str2;
                com.tencent.mm.plugin.brandservice.b.a.a(dVar2, uzVar);
            } else {
                dVar2 = null;
            }
            if (!(dVar2 == null || dVar2.cJ(false) == null)) {
                dVar = dVar2.cJ(false).aek();
            }
            if (dVar != null) {
                boolean z = dVar2.cJ(false).aem() && !bo.isNullOrNil(dVar.fvS);
                this.jKJ = z;
                if (bvo.wBT != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.jKI = z;
            }
            ab.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", Integer.valueOf(bvo.wBT));
            String str3 = bvo.guS;
            if (this.jMJ.size() > 0 && str3 != null && str3.toLowerCase().equals(((String) this.jMJ.get(0)).toLowerCase())) {
                try {
                    List list2 = this.jMJ;
                    aVar2.jKO.getTextSize();
                    this.jKH = com.tencent.mm.plugin.brandservice.b.a.b(context, str3, list2);
                    this.jKH = TextUtils.concat(new CharSequence[]{context.getResources().getString(R.string.e09), this.jKH});
                } catch (Exception e2) {
                    this.jKH = "";
                }
            }
            if (this.jKH == null || this.jKH.length() == 0 || this.jKG == null || this.jKG.length() == 0) {
                try {
                    str = bvo.guQ;
                    List list3 = this.jMJ;
                    aVar2.jKM.getTextSize();
                    this.jKF = com.tencent.mm.plugin.brandservice.b.a.b(context, str, list3);
                } catch (Exception e3) {
                    this.jKF = "";
                }
            }
            ab.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", this.nickName, this.jKG);
            this.yDq = true;
            AppMethodBeat.o(13867);
        } else {
            ab.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            AppMethodBeat.o(13867);
        }
    }
}
