package com.tencent.p177mm.plugin.brandservice.p349ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.sortview.C46635a;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C36082b;
import com.tencent.p177mm.p612ui.base.sortview.C46635a.C40676a;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p349ui.C42811c.C38691b;
import com.tencent.p177mm.plugin.brandservice.p349ui.base.C11208a;
import com.tencent.p177mm.plugin.brandservice.p926b.C11188a;
import com.tencent.p177mm.plugin.brandservice.p926b.C11188a.C11189a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.bvn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.b */
public final class C42810b extends C11208a {
    private static C36082b jKQ;
    CharSequence gnx;
    protected String iconUrl;
    protected CharSequence jKF;
    protected boolean jKI;
    protected boolean jKJ;
    protected String jKR;
    protected String username;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.b$a */
    public static class C11201a extends C11189a implements C40676a {
        public TextView ejp;
        public TextView jKK;
        public View jKL;
        public TextView jKM;
        public View jKP;
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.b$1 */
    class C428071 extends C36082b {
        C428071() {
        }

        /* renamed from: a */
        public final boolean mo22881a(Context context, C46635a c46635a, Object... objArr) {
            AppMethodBeat.m2504i(13868);
            if (c46635a instanceof C42810b) {
                String str;
                String str2;
                C42810b c42810b = (C42810b) c46635a;
                bvn bvn = (bvn) c46635a.getData();
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
                if (C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7412e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
                    AppMethodBeat.m2505o(13868);
                    return false;
                }
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str2);
                Intent intent = new Intent();
                if (C7486a.m12942jh(aoO.field_type)) {
                    intent.putExtra("Contact_User", str2);
                    intent.putExtra("Contact_Scene", 55);
                } else {
                    intent.putExtra("Contact_User", str2);
                    intent.putExtra("Contact_Alias", bvn.guS);
                    intent.putExtra("Contact_Nick", str);
                    intent.putExtra("Contact_Signature", bvn.guQ);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(bvn.guW, bvn.guO, bvn.guP));
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
                            C4990ab.printErrStackTrace("MicroMsg.BizRecommDataItem", e, "", new Object[0]);
                        }
                    }
                }
                C33720b.gkE.mo38912c(intent, context);
                C42811c c42811c = null;
                if (objArr != null && objArr.length > 0 && (objArr[0] instanceof C42811c)) {
                    c42811c = (C42811c) objArr[0];
                }
                C38691b aWm = c42810b.aWm();
                if (!(aWm == null || c42811c == null)) {
                    aWm.mo35292a(c42811c, c46635a, 1, str2, c42810b.aWn(), c42810b.getPosition());
                }
                AppMethodBeat.m2505o(13868);
                return true;
            }
            AppMethodBeat.m2505o(13868);
            return false;
        }

        /* renamed from: c */
        public final View mo22882c(Context context, View view) {
            AppMethodBeat.m2504i(13869);
            if (view == null) {
                view = View.inflate(context, 2130970571, null);
            }
            AppMethodBeat.m2505o(13869);
            return view;
        }

        /* renamed from: a */
        public final void mo22879a(Context context, C40676a c40676a, C46635a c46635a) {
            int i = 0;
            AppMethodBeat.m2504i(13870);
            if (context == null || c40676a == null || c46635a == null || c46635a.getData() == null) {
                C4990ab.m7412e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                AppMethodBeat.m2505o(13870);
            } else if (!(c40676a instanceof C11201a)) {
                C4990ab.m7412e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
                AppMethodBeat.m2505o(13870);
            } else if (c46635a.getData() instanceof bvn) {
                C11201a c11201a = (C11201a) c40676a;
                C42810b c42810b = (C42810b) c46635a;
                c11201a.username = c42810b.username;
                c11201a.iconUrl = c42810b.iconUrl;
                C40460b.m69437r(c11201a.ejo, c42810b.username);
                c11201a.ejp.setText(c42810b.gnx, BufferType.SPANNABLE);
                c11201a.jKP.setVisibility(c42810b.jKJ ? 0 : 8);
                View view = c11201a.jKL;
                if (!c42810b.jKI) {
                    i = 8;
                }
                view.setVisibility(i);
                c11201a.jKM.setText(c42810b.jKF, BufferType.SPANNABLE);
                C11188a.m18896b(c11201a.jKK, c42810b.jKR);
                AppMethodBeat.m2505o(13870);
            } else {
                C4990ab.m7412e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
                AppMethodBeat.m2505o(13870);
            }
        }

        /* renamed from: a */
        public final void mo22880a(View view, C40676a c40676a) {
            AppMethodBeat.m2504i(13871);
            if (!(view == null || c40676a == null || !(c40676a instanceof C11201a))) {
                C11201a c11201a = (C11201a) c40676a;
                c11201a.ejo = (ImageView) view.findViewById(2131823652);
                c11201a.ejp = (TextView) view.findViewById(2131824267);
                c11201a.jKK = (TextView) view.findViewById(2131821069);
                c11201a.jKP = view.findViewById(2131824269);
                c11201a.jKL = view.findViewById(2131824270);
                c11201a.jKM = (TextView) view.findViewById(2131824272);
            }
            AppMethodBeat.m2505o(13871);
        }
    }

    public C42810b(Object obj, String str) {
        super(6, obj);
        this.jKR = str;
    }

    public final C36082b aVY() {
        AppMethodBeat.m2504i(13872);
        if (jKQ == null) {
            jKQ = new C428071();
        }
        C36082b c36082b = jKQ;
        AppMethodBeat.m2505o(13872);
        return c36082b;
    }

    public final C40676a aVZ() {
        AppMethodBeat.m2504i(13873);
        C11201a c11201a = new C11201a();
        AppMethodBeat.m2505o(13873);
        return c11201a;
    }

    /* renamed from: a */
    public final void mo35282a(Context context, C40676a c40676a, Object... objArr) {
        AppMethodBeat.m2504i(13874);
        if (this.yDq) {
            AppMethodBeat.m2505o(13874);
        } else if (context == null || c40676a == null || this.data == null) {
            C4990ab.m7412e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.m2505o(13874);
        } else if (!(c40676a instanceof C11201a)) {
            C4990ab.m7412e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
            AppMethodBeat.m2505o(13874);
        } else if (this.data instanceof bvn) {
            bvn bvn = (bvn) this.data;
            try {
                this.gnx = C44089j.m79293b(context, bvn.wyX != null ? bvn.wyX.toString() : "", ((C11201a) c40676a).ejp.getTextSize());
            } catch (Exception e) {
                this.gnx = "";
            }
            this.iconUrl = bvn.vXn;
            this.username = bvn.wcB.toString();
            AppMethodBeat.m2505o(13874);
        } else {
            C4990ab.m7412e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.m2505o(13874);
        }
    }
}
