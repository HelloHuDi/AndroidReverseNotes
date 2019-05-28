package com.tencent.p177mm.plugin.account.p275ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p201az.C6332h;
import com.tencent.p177mm.p201az.C6332h.C6333a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.p629f.p630a.C15885b;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c;
import com.tencent.p177mm.p612ui.p629f.p630a.C30704c.C30705a;
import com.tencent.p177mm.p612ui.p629f.p630a.C30706e;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18820h;
import com.tencent.p177mm.plugin.account.friend.p272a.C32956ab;
import com.tencent.p177mm.plugin.account.friend.p272a.C45497g;
import com.tencent.p177mm.plugin.account.friend.p272a.C45499p;
import com.tencent.p177mm.plugin.account.model.C26603h;
import com.tencent.p177mm.plugin.account.model.C9908i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI */
public class InviteFacebookFriendsUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    C38063a gBv;
    private ListView gtT;
    private View gtV;
    String gtX;
    private final int gyc = 5;

    /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$10 */
    class C1887410 implements OnMenuItemClickListener {
        C1887410() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124887);
            C30704c c30704c = new C30704c(InviteFacebookFriendsUI.this.getString(C25738R.string.g7d));
            Bundle bundle = new Bundle();
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, InviteFacebookFriendsUI.this.getString(C25738R.string.bmd));
            final long[] aqS = InviteFacebookFriendsUI.this.gBv.aqS();
            String l = Long.toString(aqS[0]);
            for (int i = 1; i < aqS.length; i++) {
                l = (l + ",") + Long.toString(aqS[i]);
            }
            bundle.putString("to", l);
            c30704c.mo49071a(InviteFacebookFriendsUI.this, "apprequests", bundle, new C30705a() {

                /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$10$1$1 */
                class C188761 implements OnClickListener {
                    C188761() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(124881);
                        InviteFacebookFriendsUI.this.gBv.mo6869KC();
                        AppMethodBeat.m2505o(124881);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$10$1$2 */
                class C188772 implements OnClickListener {
                    C188772() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(124882);
                        InviteFacebookFriendsUI.this.finish();
                        AppMethodBeat.m2505o(124882);
                    }
                }

                /* renamed from: a */
                public final void mo5792a(C30706e c30706e) {
                    AppMethodBeat.m2504i(124883);
                    C4990ab.m7412e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                    AppMethodBeat.m2505o(124883);
                }

                /* renamed from: a */
                public final void mo5791a(C15885b c15885b) {
                    AppMethodBeat.m2504i(124884);
                    C4990ab.m7412e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                    AppMethodBeat.m2505o(124884);
                }

                /* renamed from: p */
                public final void mo5794p(Bundle bundle) {
                    AppMethodBeat.m2504i(124885);
                    C4990ab.m7416i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new C6333a(33, Integer.toString(aqS.length)));
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6332h(arrayList));
                    for (long j : aqS) {
                        C45499p c45499p = new C45499p();
                        c45499p.username = Long.toString(j);
                        c45499p.gvE = 5;
                        c45499p.fvK = (int) C5046bo.anT();
                        C32923a.getInviteFriendOpenStg().mo21239b(c45499p);
                    }
                    C30379h.m48428a(InviteFacebookFriendsUI.this, (int) C25738R.string.bmf, (int) C25738R.string.f9238tz, (int) C25738R.string.f9262up, (int) C25738R.string.f9183s2, new C188761(), new C188772());
                    AppMethodBeat.m2505o(124885);
                }

                public final void onCancel() {
                    AppMethodBeat.m2504i(124886);
                    C4990ab.m7412e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
                    AppMethodBeat.m2505o(124886);
                }
            });
            AppMethodBeat.m2505o(124887);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$5 */
    class C188785 extends C9908i {
        C188785() {
        }

        /* renamed from: p */
        public final void mo21265p(Bundle bundle) {
            AppMethodBeat.m2504i(124875);
            super.mo21265p(bundle);
            AppMethodBeat.m2505o(124875);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(124876);
            super.onError(i, str);
            if (i == 3) {
                InviteFacebookFriendsUI.m64412c(InviteFacebookFriendsUI.this);
            }
            AppMethodBeat.m2505o(124876);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$2 */
    class C266152 implements OnClickListener {
        C266152() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(124872);
            Intent intent = new Intent(InviteFacebookFriendsUI.this.mController.ylL, FacebookAuthUI.class);
            intent.putExtra("is_force_unbind", true);
            InviteFacebookFriendsUI.this.mController.ylL.startActivity(intent);
            InviteFacebookFriendsUI.this.finish();
            AppMethodBeat.m2505o(124872);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$4 */
    class C266164 implements OnItemClickListener {
        C266164() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(124874);
            if (InviteFacebookFriendsUI.this.gBv.aqS().length >= 50) {
                C30379h.m48467g(InviteFacebookFriendsUI.this, C25738R.string.bmg, C25738R.string.f9238tz);
                AppMethodBeat.m2505o(124874);
                return;
            }
            InviteFacebookFriendsUI.this.gBv.mo60809na(i - InviteFacebookFriendsUI.this.gtT.getHeaderViewsCount());
            if (InviteFacebookFriendsUI.this.gBv.aqS().length > 0) {
                InviteFacebookFriendsUI.this.showOptionMenu(true);
                AppMethodBeat.m2505o(124874);
                return;
            }
            InviteFacebookFriendsUI.this.showOptionMenu(false);
            AppMethodBeat.m2505o(124874);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$1 */
    class C380591 implements C5600b {
        C380591() {
        }

        /* renamed from: vN */
        public final boolean mo7459vN(String str) {
            return false;
        }

        /* renamed from: vO */
        public final void mo7460vO(String str) {
            AppMethodBeat.m2504i(124871);
            InviteFacebookFriendsUI.this.gtX = C5046bo.m7586vA(str);
            InviteFacebookFriendsUI inviteFacebookFriendsUI = InviteFacebookFriendsUI.this;
            if (inviteFacebookFriendsUI.gBv != null) {
                C38063a c38063a = inviteFacebookFriendsUI.gBv;
                c38063a.gtz = C5046bo.m7586vA(inviteFacebookFriendsUI.gtX.trim());
                c38063a.bIf();
                c38063a.mo6869KC();
            }
            AppMethodBeat.m2505o(124871);
        }

        public final void apo() {
        }

        public final void app() {
        }

        public final void apq() {
        }

        public final void apr() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$8 */
    class C380618 implements OnMenuItemClickListener {
        C380618() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(124879);
            InviteFacebookFriendsUI.this.aqX();
            InviteFacebookFriendsUI.this.finish();
            AppMethodBeat.m2505o(124879);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$9 */
    class C380629 implements View.OnClickListener {
        C380629() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(124880);
            C4978c.m7375a(InviteFacebookFriendsUI.this.gtT);
            AppMethodBeat.m2505o(124880);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$a */
    public static class C38063a extends C46692p<C45497g> {
        private int[] gty;
        String gtz;
        private boolean[] gxh;

        /* renamed from: com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI$a$a */
        public static class C18879a {
            ImageView eks;
            TextView gtG;
            TextView gxk;
            CheckBox gxl;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(124894);
            C45497g c45497g = (C45497g) obj;
            if (c45497g == null) {
                c45497g = new C45497g();
            }
            c45497g.mo73290d(cursor);
            AppMethodBeat.m2505o(124894);
            return c45497g;
        }

        public C38063a(Context context, C30723a c30723a) {
            super(context, new C45497g());
            AppMethodBeat.m2504i(124888);
            super.mo74992a(c30723a);
            AppMethodBeat.m2505o(124888);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C18879a c18879a;
            AppMethodBeat.m2504i(124889);
            C45497g c45497g = (C45497g) getItem(i);
            if (view == null) {
                C18879a c18879a2 = new C18879a();
                view = View.inflate(this.context, 2130969484, null);
                c18879a2.eks = (ImageView) view.findViewById(2131823840);
                c18879a2.gtG = (TextView) view.findViewById(2131823841);
                c18879a2.gxk = (TextView) view.findViewById(2131823846);
                c18879a2.gxl = (CheckBox) view.findViewById(2131823847);
                view.setTag(c18879a2);
                c18879a = c18879a2;
            } else {
                c18879a = (C18879a) view.getTag();
            }
            c18879a.gtG.setText(C44089j.m79293b(this.context, c45497g.apL(), c18879a.gtG.getTextSize()));
            Bitmap pS = C41730b.m73500pS(c45497g.dtU);
            if (pS == null) {
                c18879a.eks.setImageDrawable(C1338a.m2864g(this.context, C1318a.default_avatar));
            } else {
                c18879a.eks.setImageBitmap(pS);
            }
            c18879a.gxl.setChecked(this.gxh[i]);
            if (C32923a.getInviteFriendOpenStg().mo21240wi(Long.toString(c45497g.dtU))) {
                c18879a.gxk.setVisibility(0);
            } else {
                c18879a.gxk.setVisibility(8);
            }
            AppMethodBeat.m2505o(124889);
            return view;
        }

        public final long[] aqS() {
            int i = 0;
            AppMethodBeat.m2504i(124890);
            int i2 = 0;
            for (boolean z : this.gxh) {
                if (z) {
                    i2++;
                }
            }
            long[] jArr = new long[i2];
            int i3 = 0;
            while (true) {
                int i4 = i;
                if (i4 < getCount()) {
                    if (this.gxh[i4]) {
                        i = i3 + 1;
                        jArr[i3] = ((C45497g) getItem(i4)).dtU;
                        i2 = i;
                    } else {
                        i2 = i3;
                    }
                    i = i4 + 1;
                    i3 = i2;
                } else {
                    AppMethodBeat.m2505o(124890);
                    return jArr;
                }
            }
        }

        /* renamed from: na */
        public final void mo60809na(int i) {
            AppMethodBeat.m2504i(124891);
            if (i < 0 || i >= this.gxh.length) {
                AppMethodBeat.m2505o(124891);
                return;
            }
            boolean[] zArr = this.gxh;
            zArr[i] = !zArr[i];
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(124891);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(124892);
            C18820h facebookFrdStg = C32923a.getFacebookFrdStg();
            String str = this.gtz;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" where facebookfriend.status = 102 ");
            if (str != null && str.length() > 0) {
                stringBuilder.append(" and ( ");
                stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
            }
            setCursor(facebookFrdStg.fni.mo10104a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
            this.gty = new int[getCount()];
            this.gxh = new boolean[getCount()];
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(124892);
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(124893);
            mo6869KC();
            AppMethodBeat.m2505o(124893);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(124895);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.bmh);
        C1720g.m3540Rg().mo14539a(32, (C1202f) this);
        initView();
        AppMethodBeat.m2505o(124895);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(124896);
        C1720g.m3540Rg().mo14546b(32, (C1202f) this);
        this.gBv.bIf();
        super.onDestroy();
        AppMethodBeat.m2505o(124896);
    }

    public final void initView() {
        AppMethodBeat.m2504i(124897);
        this.gtT = (ListView) findViewById(2131824012);
        final TextView textView = (TextView) findViewById(2131821807);
        textView.setText(C25738R.string.bma);
        C5601o c5601o = new C5601o((byte) 0);
        c5601o.zHa = new C380591();
        mo17380a(c5601o);
        this.gBv = new C38063a(this, new C30723a() {
            public final void apt() {
                AppMethodBeat.m2504i(124873);
                if (C1853r.m3847Za()) {
                    if (InviteFacebookFriendsUI.this.gBv.getCount() == 0) {
                        textView.setVisibility(0);
                        AppMethodBeat.m2505o(124873);
                        return;
                    }
                    textView.setVisibility(8);
                }
                AppMethodBeat.m2505o(124873);
            }
        });
        this.gtT.setAdapter(this.gBv);
        this.gtV = findViewById(2131824014);
        this.gtT.setOnItemClickListener(new C266164());
        C4990ab.m7410d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + C1853r.m3847Za());
        if (C1853r.m3847Za()) {
            this.gtT.setVisibility(0);
            this.gtV.setVisibility(8);
            long c = C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(65831, null));
            String nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(65830, null));
            if (C5046bo.m7566gb(c) > 86400000 && nullAsNil.length() > 0) {
                C30704c c30704c = new C30704c(getString(C25738R.string.g7d));
                c30704c.arX(nullAsNil);
                new C26603h(c30704c, new C188785()).apm();
            }
            final C1207m c32956ab = new C32956ab();
            c32956ab.aqg();
            final C7564ap c7564ap = new C7564ap(new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(124877);
                    C1720g.m3536RP().mo5239Ry().set(65829, Integer.valueOf(1));
                    C1720g.m3540Rg().mo14541a(c32956ab, 0);
                    AppMethodBeat.m2505o(124877);
                    return false;
                }
            }, false);
            if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(65829, null)) > 0) {
                C1720g.m3536RP().mo5239Ry().set(65829, Integer.valueOf(1));
                C1720g.m3540Rg().mo14541a(c32956ab, 0);
            } else {
                c7564ap.mo16770ae(5000, 5000);
            }
            Context context = this.mController.ylL;
            getString(C25738R.string.f9238tz);
            this.ehJ = C30379h.m48458b(context, getString(C25738R.string.df7), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(124878);
                    c7564ap.stopTimer();
                    C1720g.m3540Rg().mo14547c(c32956ab);
                    AppMethodBeat.m2505o(124878);
                }
            });
        }
        setBackBtn(new C380618());
        C380629 c380629 = new C380629();
        addTextOptionMenu(0, getString(C25738R.string.bme), new C1887410());
        showOptionMenu(false);
        AppMethodBeat.m2505o(124897);
    }

    /* renamed from: bj */
    private void m64411bj(String str, String str2) {
        AppMethodBeat.m2504i(124898);
        C30379h.m48440a((Context) this, str2, str, new C266152(), null);
        AppMethodBeat.m2505o(124898);
    }

    public final int getLayoutId() {
        return 2130969545;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(124899);
        C4990ab.m7416i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (c1207m.getType() != 32) {
            AppMethodBeat.m2505o(124899);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (i == 4 && i2 == -68) {
            if (C5046bo.isNullOrNil(str)) {
                str = "error";
            }
            m64411bj(getString(C25738R.string.f9238tz), str);
            AppMethodBeat.m2505o(124899);
        } else if (i == 0 && i2 == 0) {
            this.gBv.mo5248a(null, null);
            AppMethodBeat.m2505o(124899);
        } else {
            Toast.makeText(this, C25738R.string.d08, 0).show();
            AppMethodBeat.m2505o(124899);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m64412c(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        AppMethodBeat.m2504i(124900);
        C4990ab.m7412e("MicroMsg.InviteFacebookFriendsUI", "dealWithRefreshTokenFail");
        inviteFacebookFriendsUI.m64411bj(inviteFacebookFriendsUI.getString(C25738R.string.f9238tz), inviteFacebookFriendsUI.getString(C25738R.string.bmb));
        AppMethodBeat.m2505o(124900);
    }
}
