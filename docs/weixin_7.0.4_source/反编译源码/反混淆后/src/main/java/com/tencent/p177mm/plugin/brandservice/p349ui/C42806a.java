package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16531d;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.sortview.C46635a;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C36082b;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C40676a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p349ui.C42811c.C38691b;
import com.tencent.p177mm.plugin.brandservice.p349ui.base.C11208a;
import com.tencent.p177mm.plugin.brandservice.p926b.C11188a;
import com.tencent.p177mm.plugin.brandservice.p926b.C11188a.C11189a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.websearch.api.C35573ai;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.C15361mn;
import com.tencent.p177mm.protocal.protobuf.C23452uz;
import com.tencent.p177mm.protocal.protobuf.C35935mi;
import com.tencent.p177mm.protocal.protobuf.bvo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.io.IOException;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.a */
public final class C42806a extends C11208a {
    private static C11198b jKE;
    protected String iconUrl;
    protected CharSequence jKF;
    protected CharSequence jKG;
    protected CharSequence jKH;
    protected boolean jKI;
    protected boolean jKJ;
    protected CharSequence nickName;
    protected String username;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.a$a */
    public static class C11197a extends C11189a implements C40676a {
        public TextView emg;
        public TextView jKK;
        public View jKL;
        public TextView jKM;
        public TextView jKN;
        public TextView jKO;
        View jKP;
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.a$b */
    public static class C11198b extends C36082b {
        /* renamed from: a */
        public final boolean mo22881a(Context context, C46635a c46635a, Object... objArr) {
            AppMethodBeat.m2504i(13861);
            if (c46635a instanceof C42806a) {
                C42806a c42806a = (C42806a) c46635a;
                if (c46635a.getData() instanceof C15361mn) {
                    C15361mn c15361mn = (C15361mn) c46635a.getData();
                    if (c15361mn.vQv == null || c15361mn.vQv.vQb == null) {
                        C4990ab.m7412e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                        AppMethodBeat.m2505o(13861);
                        return false;
                    }
                    int i;
                    String str;
                    String str2;
                    C42811c c42811c = null;
                    String str3 = "";
                    if (objArr != null) {
                        C42811c c42811c2;
                        if (objArr.length <= 0 || !(objArr[0] instanceof C42811c)) {
                            c42811c2 = null;
                        } else {
                            c42811c2 = (C42811c) objArr[0];
                        }
                        if (objArr.length <= 2 || !(objArr[2] instanceof Integer)) {
                            i = 0;
                        } else {
                            i = ((Integer) objArr[2]).intValue();
                        }
                        if (objArr.length <= 3 || !(objArr[3] instanceof String)) {
                            c42811c = c42811c2;
                        } else {
                            str3 = (String) objArr[3];
                            c42811c = c42811c2;
                        }
                    } else {
                        i = 0;
                    }
                    String str4 = c15361mn.vQv.mZj;
                    bvo bvo = c15361mn.vQv.vQb;
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
                    if (C5046bo.isNullOrNil(str2)) {
                        C4990ab.m7412e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
                        AppMethodBeat.m2505o(13861);
                        return false;
                    }
                    int i2;
                    C35573ai.adO(str2);
                    if (C5046bo.isNullOrNil(str4)) {
                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putString("Contact_Ext_Args_Search_Id", str3);
                        bundle.putInt("Contact_Ext_Args_Index", c42806a.aWn());
                        bundle.putString("Contact_Ext_Args_Query_String", "");
                        bundle.putInt("Contact_Scene", i);
                        intent.putExtra("Contact_Ext_Args", bundle);
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Scene", i);
                        if (!C7486a.m12942jh(aoO.field_type)) {
                            intent.putExtra("Contact_Alias", bvo.guS);
                            intent.putExtra("Contact_Nick", str);
                            intent.putExtra("Contact_Signature", bvo.guQ);
                            intent.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(bvo.guW, bvo.guO, bvo.guP));
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
                                    C4990ab.printErrStackTrace("MicroMsg.BizContactDataItem", e, "", new Object[0]);
                                }
                            }
                        }
                        C33720b.gkE.mo38912c(intent, context);
                        i2 = 1;
                    } else {
                        i2 = 8;
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", str4);
                        intent2.putExtra("useJs", true);
                        intent2.putExtra("vertical_scroll", true);
                        C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent2);
                    }
                    C38691b aWm = c42806a.aWm();
                    if (!(aWm == null || c42811c == null)) {
                        aWm.mo35292a(c42811c, c46635a, i2, str2, c42806a.aWn(), c42806a.getPosition());
                    }
                    AppMethodBeat.m2505o(13861);
                    return true;
                }
                C4990ab.m7412e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
                AppMethodBeat.m2505o(13861);
                return false;
            }
            AppMethodBeat.m2505o(13861);
            return false;
        }

        /* renamed from: c */
        public final View mo22882c(Context context, View view) {
            AppMethodBeat.m2504i(13862);
            if (view == null) {
                view = View.inflate(context, 2130970571, null);
            }
            AppMethodBeat.m2505o(13862);
            return view;
        }

        /* renamed from: a */
        public final void mo22879a(Context context, C40676a c40676a, C46635a c46635a) {
            int i = 8;
            AppMethodBeat.m2504i(13863);
            if (context == null || c40676a == null || c46635a == null || c46635a.getData() == null) {
                C4990ab.m7412e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                AppMethodBeat.m2505o(13863);
            } else if (!(c40676a instanceof C11197a)) {
                C4990ab.m7412e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
                AppMethodBeat.m2505o(13863);
            } else if (c46635a instanceof C42806a) {
                int i2;
                C11197a c11197a = (C11197a) c40676a;
                C42806a c42806a = (C42806a) c46635a;
                c11197a.username = c42806a.username;
                c11197a.iconUrl = c42806a.iconUrl;
                C40460b.m69437r(c11197a.ejo, c42806a.username);
                View view = c11197a.jKL;
                if (c42806a.jKI) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view.setVisibility(i2);
                View view2 = c11197a.jKP;
                if (c42806a.jKJ) {
                    i = 0;
                }
                view2.setVisibility(i);
                C11188a.m18896b(c11197a.emg, c42806a.nickName);
                boolean b = C11188a.m18896b(c11197a.jKO, c42806a.jKH);
                boolean b2 = C11188a.m18896b(c11197a.jKN, c42806a.jKG);
                if (C11188a.m18896b(c11197a.jKM, c42806a.jKF)) {
                    if (b || b2) {
                        c11197a.jKM.setMaxLines(1);
                    } else {
                        c11197a.jKM.setMaxLines(2);
                    }
                }
                C4990ab.m7411d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", c42806a.nickName, c42806a.jKG);
                AppMethodBeat.m2505o(13863);
            } else {
                C4990ab.m7412e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
                AppMethodBeat.m2505o(13863);
            }
        }

        /* renamed from: a */
        public final void mo22880a(View view, C40676a c40676a) {
            AppMethodBeat.m2504i(13864);
            if (!(view == null || c40676a == null || !(c40676a instanceof C11197a))) {
                C11197a c11197a = (C11197a) c40676a;
                c11197a.jKK = (TextView) view.findViewById(2131821069);
                c11197a.jKP = view.findViewById(2131824269);
                c11197a.ejo = (ImageView) view.findViewById(2131823652);
                c11197a.emg = (TextView) view.findViewById(2131824267);
                c11197a.jKL = view.findViewById(2131824270);
                c11197a.jKN = (TextView) view.findViewById(2131824274);
                c11197a.jKM = (TextView) view.findViewById(2131824272);
                c11197a.jKO = (TextView) view.findViewById(2131824271);
            }
            AppMethodBeat.m2505o(13864);
        }
    }

    public C42806a(Object obj) {
        super(5, obj);
    }

    public final C36082b aVY() {
        AppMethodBeat.m2504i(13865);
        if (jKE == null) {
            jKE = new C11198b();
        }
        C11198b c11198b = jKE;
        AppMethodBeat.m2505o(13865);
        return c11198b;
    }

    public final C40676a aVZ() {
        AppMethodBeat.m2504i(13866);
        C11197a c11197a = new C11197a();
        AppMethodBeat.m2505o(13866);
        return c11197a;
    }

    /* renamed from: a */
    public final void mo35282a(Context context, C40676a c40676a, Object... objArr) {
        C16531d c16531d = null;
        AppMethodBeat.m2504i(13867);
        if (this.yDq) {
            AppMethodBeat.m2505o(13867);
        } else if (context == null || c40676a == null || this.data == null) {
            C4990ab.m7412e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.m2505o(13867);
        } else if (!(c40676a instanceof C11197a)) {
            C4990ab.m7412e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            AppMethodBeat.m2505o(13867);
        } else if (this.data instanceof C15361mn) {
            C11197a c11197a = (C11197a) c40676a;
            C15361mn c15361mn = (C15361mn) this.data;
            if (c15361mn.vQv == null || c15361mn.vQv.vQb == null) {
                C4990ab.m7412e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                AppMethodBeat.m2505o(13867);
                return;
            }
            String str;
            C16527d c16527d;
            bvo bvo = c15361mn.vQv.vQb;
            C35935mi c35935mi = c15361mn.vQv.vPY;
            if (objArr != null && objArr.length > 1 && (objArr[1] instanceof List)) {
                this.jMJ = (List) objArr[1];
            }
            this.username = bvo.wcB.wVI;
            this.iconUrl = bvo.vXn;
            this.jKG = c35935mi == null ? "" : c35935mi.vQh;
            if (bvo.wyX == null) {
                str = null;
            } else {
                str = bvo.wyX.wVI;
            }
            try {
                List list = this.jMJ;
                c11197a.emg.getTextSize();
                this.nickName = C11188a.m18895b(context, str, list);
            } catch (Exception e) {
                this.nickName = "";
            }
            String str2 = bvo.wcB.wVI;
            C23452uz c23452uz = bvo.wWC;
            if (c23452uz != null) {
                c16527d = new C16527d();
                c16527d.field_username = str2;
                C11188a.m18893a(c16527d, c23452uz);
            } else {
                c16527d = null;
            }
            if (!(c16527d == null || c16527d.mo30481cJ(false) == null)) {
                c16531d = c16527d.mo30481cJ(false).aek();
            }
            if (c16531d != null) {
                boolean z = c16527d.mo30481cJ(false).aem() && !C5046bo.isNullOrNil(c16531d.fvS);
                this.jKJ = z;
                if (bvo.wBT != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.jKI = z;
            }
            C4990ab.m7419v("MicroMsg.BizContactDataItem", "verifyFlag : %d", Integer.valueOf(bvo.wBT));
            String str3 = bvo.guS;
            if (this.jMJ.size() > 0 && str3 != null && str3.toLowerCase().equals(((String) this.jMJ.get(0)).toLowerCase())) {
                try {
                    List list2 = this.jMJ;
                    c11197a.jKO.getTextSize();
                    this.jKH = C11188a.m18895b(context, str3, list2);
                    this.jKH = TextUtils.concat(new CharSequence[]{context.getResources().getString(C25738R.string.e09), this.jKH});
                } catch (Exception e2) {
                    this.jKH = "";
                }
            }
            if (this.jKH == null || this.jKH.length() == 0 || this.jKG == null || this.jKG.length() == 0) {
                try {
                    str = bvo.guQ;
                    List list3 = this.jMJ;
                    c11197a.jKM.getTextSize();
                    this.jKF = C11188a.m18895b(context, str, list3);
                } catch (Exception e3) {
                    this.jKF = "";
                }
            }
            C4990ab.m7411d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", this.nickName, this.jKG);
            this.yDq = true;
            AppMethodBeat.m2505o(13867);
        } else {
            C4990ab.m7412e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            AppMethodBeat.m2505o(13867);
        }
    }
}
