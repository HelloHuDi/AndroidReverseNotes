package com.tencent.p177mm.plugin.shake.p511ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C26151he;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9306cg;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.C46193a;
import com.tencent.p177mm.plugin.shake.p1296e.C21832a;
import com.tencent.p177mm.plugin.shake.p1296e.C21832a.C21833a;
import com.tencent.p177mm.plugin.shake.p1296e.C29004b;
import com.tencent.p177mm.plugin.shake.p1296e.C43525c;
import com.tencent.p177mm.plugin.shake.p1296e.C43525c.C29005a;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C13259b;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3826k;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.protocal.protobuf.abo;
import com.tencent.p177mm.protocal.protobuf.aov;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.shake.ui.TVInfoUI */
public class TVInfoUI extends MMPreference implements C1202f, C18765a {
    private long cvx;
    protected ProgressDialog ehJ = null;
    protected C15541f ehK;
    private TextView gne;
    private ImageView klm;
    private boolean qdh = false;
    private boolean qfD = false;
    private String qwB = "";
    private TextView qwC;
    private C29005a qwD;
    private C29004b qwE;

    /* renamed from: com.tencent.mm.plugin.shake.ui.TVInfoUI$3 */
    class C349113 implements OnMenuItemClickListener {
        C349113() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24912);
            TVInfoUI.m67877a(TVInfoUI.this);
            AppMethodBeat.m2505o(24912);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.TVInfoUI$4 */
    class C349124 implements OnMenuItemClickListener {
        C349124() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24913);
            TVInfoUI.this.finish();
            AppMethodBeat.m2505o(24913);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.TVInfoUI$6 */
    class C368066 implements C30382d {

        /* renamed from: com.tencent.mm.plugin.shake.ui.TVInfoUI$6$1 */
        class C290131 implements C30382d {
            C290131() {
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(24915);
                switch (i2) {
                    case -1:
                        C9306cg c9306cg = new C9306cg();
                        c9306cg.cvt.cvv = TVInfoUI.this.getIntent().getLongExtra("key_favorite_local_id", -1);
                        C4879a.xxA.mo10055m(c9306cg);
                        C4990ab.m7411d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", Long.valueOf(c9306cg.cvt.cvv), Boolean.valueOf(c9306cg.cvu.cvi));
                        if (c9306cg.cvu.cvi) {
                            TVInfoUI.this.finish();
                            AppMethodBeat.m2505o(24915);
                            return;
                        }
                        break;
                    default:
                        C4990ab.m7410d("MicroMsg.TVInfoUI", "do del cancel");
                        break;
                }
                AppMethodBeat.m2505o(24915);
            }
        }

        C368066() {
        }

        /* renamed from: bV */
        public final void mo4975bV(int i, int i2) {
            AppMethodBeat.m2504i(24916);
            switch (i2) {
                case -1:
                    C30379h.m48419a(TVInfoUI.this.mController.ylL, TVInfoUI.this.mController.ylL.getString(C25738R.string.f9089p5), null, null, TVInfoUI.this.mController.ylL.getString(C25738R.string.f9088p4), new C290131());
                    AppMethodBeat.m2505o(24916);
                    return;
                case 0:
                    TVInfoUI.m67880b(TVInfoUI.this);
                    AppMethodBeat.m2505o(24916);
                    return;
                case 1:
                    TVInfoUI.m67882c(TVInfoUI.this);
                    AppMethodBeat.m2505o(24916);
                    return;
                case 2:
                    TVInfoUI.m67883d(TVInfoUI.this);
                    break;
            }
            AppMethodBeat.m2505o(24916);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: g */
    static /* synthetic */ void m67886g(TVInfoUI tVInfoUI) {
        AppMethodBeat.m2504i(24935);
        tVInfoUI.chn();
        AppMethodBeat.m2505o(24935);
    }

    public final int getLayoutId() {
        return 2130970971;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8573cm;
    }

    public final int aWi() {
        return 2130970972;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24918);
        super.onCreate(bundle);
        C18764x.m29328b((C18765a) this);
        initView();
        AppMethodBeat.m2505o(24918);
    }

    public void onResume() {
        AppMethodBeat.m2504i(24919);
        super.onResume();
        C9638aw.m17182Rg().mo14539a(552, (C1202f) this);
        AppMethodBeat.m2505o(24919);
    }

    public void onPause() {
        AppMethodBeat.m2504i(24920);
        C9638aw.m17182Rg().mo14546b(552, (C1202f) this);
        super.onPause();
        AppMethodBeat.m2505o(24920);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24921);
        C18764x.m29330c((C18765a) this);
        super.onDestroy();
        AppMethodBeat.m2505o(24921);
    }

    public final void initView() {
        AppMethodBeat.m2504i(24922);
        setMMTitle((int) C25738R.string.dyz);
        this.ehK = this.yCw;
        this.gne = (TextView) findViewById(2131828370);
        this.qwC = (TextView) findViewById(2131828369);
        String stringExtra = getIntent().getStringExtra("key_TV_xml");
        if (C5046bo.isNullOrNil(stringExtra)) {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_TV_xml_bytes");
            if (byteArrayExtra != null) {
                stringExtra = new String(byteArrayExtra);
            }
        }
        C4990ab.m7411d("MicroMsg.TVInfoUI", "tvinfo xml : %s", stringExtra);
        this.qwD = C43525c.m77779WN(stringExtra);
        if (this.qwD == null) {
            C4990ab.m7412e("MicroMsg.TVInfoUI", "initView(), tv == null");
            finish();
            AppMethodBeat.m2505o(24922);
            return;
        }
        m67876a(this.qwD);
        AppMethodBeat.m2505o(24922);
    }

    /* renamed from: a */
    private void m67876a(final C29005a c29005a) {
        AppMethodBeat.m2504i(24923);
        if (c29005a == null) {
            C4990ab.m7412e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
            finish();
            AppMethodBeat.m2505o(24923);
            return;
        }
        this.gne.setText(c29005a.field_title);
        if (C5046bo.isNullOrNil(c29005a.field_topic)) {
            this.qwC.setVisibility(8);
        } else {
            this.qwC.setText(c29005a.field_topic);
        }
        this.klm = (ImageView) findViewById(2131828367);
        if (!C5046bo.isNullOrNil(c29005a.field_playurl)) {
            ImageView imageView = (ImageView) findViewById(2131828368);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(24910);
                    C7060h.pYm.mo8381e(10987, Integer.valueOf(2), c29005a.field_playstatid, "", "");
                    TVInfoUI.m67879a(TVInfoUI.this, c29005a.field_playurl);
                    AppMethodBeat.m2505o(24910);
                }
            });
            this.klm.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(24911);
                    C7060h.pYm.mo8381e(10987, Integer.valueOf(2), c29005a.field_playstatid, "", "");
                    TVInfoUI.m67879a(TVInfoUI.this, c29005a.field_playurl);
                    AppMethodBeat.m2505o(24911);
                }
            });
        }
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C349113());
        if (!(C5046bo.isNullOrNil(c29005a.field_id) || this.qfD || getIntent().getBooleanExtra("key_TV_come_from_shake", false))) {
            C4990ab.m7411d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", c29005a.field_id, Integer.valueOf(getIntent().getIntExtra("key_TV_getProductInfoScene", 0)));
            C9638aw.m17182Rg().mo14541a(new C13259b(c29005a.field_id, r0), 0);
            this.qfD = true;
        }
        this.klm.setVisibility(0);
        setBackBtn(new C349124());
        C4990ab.m7418v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(24914);
                TVInfoUI.m67878a(TVInfoUI.this, c29005a);
                TVInfoUI.m67881b(TVInfoUI.this, c29005a);
                AppMethodBeat.m2505o(24914);
            }
        });
        AppMethodBeat.m2505o(24923);
    }

    private void chn() {
        AppMethodBeat.m2504i(24924);
        this.cvx = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0);
        if (this.cvx > 0 && C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            C7620bi jf = C18628c.m29080XO().mo15340jf(this.cvx);
            if (jf.field_msgId > 0) {
                jf.mo14795jv(this.qwE.anJ());
                C9638aw.m17190ZK();
                C18628c.m29080XO().mo15284a(this.cvx, jf);
            }
        }
        AppMethodBeat.m2505o(24924);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(24925);
        C4990ab.m7411d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", preference.mKey);
        if (this.qwD == null || this.qwD.qiL == null) {
            C4990ab.m7412e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
            AppMethodBeat.m2505o(24925);
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            C4990ab.m7419v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2));
            if (i < 0 || i >= this.qwD.qiL.size()) {
                C4990ab.m7421w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", Integer.valueOf(i), Integer.valueOf(this.qwD.qiL.size()));
                AppMethodBeat.m2505o(24925);
                return false;
            }
            C21832a c21832a = (C21832a) this.qwD.qiL.get(i);
            if (c21832a == null) {
                C4990ab.m7420w("MicroMsg.TVInfoUI", "actionList == null");
                AppMethodBeat.m2505o(24925);
                return false;
            }
            if (i2 >= 0) {
                if (i2 < c21832a.fPL.size()) {
                    C21833a c21833a = (C21833a) c21832a.fPL.get(i2);
                    if (c21833a == null) {
                        C4990ab.m7420w("MicroMsg.TVInfoUI", "action == null");
                        AppMethodBeat.m2505o(24925);
                        return false;
                    }
                    C4990ab.m7418v("MicroMsg.TVInfoUI", "action type:" + c21833a.type + ", target:" + c21833a.qwN + ", targetDesc:" + c21833a.qwP + ", targetDesc2:" + c21833a.qwQ);
                    Intent intent;
                    if (c21833a.type == 3) {
                        intent = new Intent();
                        intent.putExtra("rawUrl", c21833a.qwN);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("geta8key_scene", 10);
                        intent.putExtra("srcUsername", c21833a.qwQ);
                        C46193a.gkE.mo38924i(intent, this);
                    } else if (c21833a.type == 4) {
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(c21833a.qwN);
                        if (aoO != null) {
                            Intent intent2 = new Intent();
                            if (C7486a.m12942jh(aoO.field_type) && aoO.dsf()) {
                                C41747z.aeR().mo43729qP(c21833a.qwN);
                                if (c21833a.qwP.equals("1")) {
                                    intent2.putExtra("Chat_User", c21833a.qwN);
                                    intent2.putExtra("finish_direct", true);
                                    C46193a.gkE.mo38915d(intent2, (Context) this);
                                }
                            }
                            intent2.putExtra("Contact_User", c21833a.qwN);
                            intent2.putExtra("force_get_contact", true);
                            C25985d.m41467b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                        }
                    } else if (c21833a.type == 5) {
                        C4883b c26151he = new C26151he();
                        c26151he.cBW.actionCode = 11;
                        c26151he.cBW.result = c21833a.qwN;
                        c26151he.cBW.context = this;
                        c26151he.callback = null;
                        C4879a.xxA.mo10048a(c26151he, Looper.myLooper());
                    } else if (c21833a.type == 6) {
                        intent = new Intent();
                        intent.putExtra("key_product_id", c21833a.qwN);
                        intent.putExtra("key_product_scene", 9);
                        C25985d.m41467b((Context) this, "product", ".ui.MallProductUI", intent);
                    }
                    AppMethodBeat.m2505o(24925);
                    return true;
                }
            }
            C4990ab.m7421w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", Integer.valueOf(i2), Integer.valueOf(c21832a.fPL.size()));
            AppMethodBeat.m2505o(24925);
            return false;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(24925);
            return false;
        }
    }

    /* renamed from: m */
    public final void mo8136m(final String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(24926);
        if (str != null) {
            String str2 = "MicroMsg.TVInfoUI";
            String str3 = "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap == null);
            C4990ab.m7411d(str2, str3, objArr);
            try {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(24917);
                        if (TVInfoUI.this.qwB != null && TVInfoUI.this.qwB.equals(str)) {
                            if (!(TVInfoUI.this.klm == null || bitmap == null)) {
                                TVInfoUI.this.klm.setImageBitmap(bitmap);
                                TVInfoUI.m67886g(TVInfoUI.this);
                            }
                            TVInfoUI.this.qdh = true;
                        }
                        AppMethodBeat.m2505o(24917);
                    }
                });
                AppMethodBeat.m2505o(24926);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", e.getLocalizedMessage());
                C4990ab.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
                AppMethodBeat.m2505o(24926);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.TVInfoUI", "onUpdate pic, url  is null ");
        AppMethodBeat.m2505o(24926);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(24927);
        if (c1207m == null) {
            C4990ab.m7420w("MicroMsg.TVInfoUI", "scene == null");
            AppMethodBeat.m2505o(24927);
            return;
        }
        if (c1207m.getType() == 552) {
            if (i != 0 || i2 != 0) {
                C4990ab.m7413e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                Toast.makeText(this, C25738R.string.dz0, 0).show();
                AppMethodBeat.m2505o(24927);
                return;
            } else if (this.qwD == null) {
                C4990ab.m7420w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
                AppMethodBeat.m2505o(24927);
                return;
            } else {
                aov aov;
                C13259b c13259b = (C13259b) c1207m;
                if (c13259b.ehh == null || c13259b.ehh.fsH.fsP == null) {
                    aov = null;
                } else {
                    aov = (aov) c13259b.ehh.fsH.fsP;
                }
                if (aov == null) {
                    C4990ab.m7420w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
                    AppMethodBeat.m2505o(24927);
                    return;
                } else if (aov.vOt != null) {
                    C4990ab.m7410d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + aov.vOt);
                    C29005a WN = C43525c.m77779WN(aov.vOt);
                    if (!(this.qwD == null || this.qwD.field_xml == null || WN == null || WN.field_xml == null || this.qwD.field_xml.equals(WN.field_xml))) {
                        this.qwD = WN;
                        m67876a(this.qwD);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(24927);
    }

    /* renamed from: b */
    static /* synthetic */ void m67881b(TVInfoUI tVInfoUI, C29005a c29005a) {
        AppMethodBeat.m2504i(24931);
        if (c29005a == null || C5046bo.isNullOrNil(c29005a.field_thumburl)) {
            AppMethodBeat.m2505o(24931);
            return;
        }
        tVInfoUI.qwE = new C29004b(c29005a);
        tVInfoUI.qwB = tVInfoUI.qwE.anL();
        Bitmap a = C18764x.m29325a(tVInfoUI.qwE);
        C4990ab.m7411d("MicroMsg.TVInfoUI", "initHeaderImg photo = %s", a);
        if (a != null) {
            tVInfoUI.klm.setImageBitmap(a);
            tVInfoUI.qdh = true;
            tVInfoUI.chn();
            AppMethodBeat.m2505o(24931);
            return;
        }
        tVInfoUI.klm.setImageDrawable(tVInfoUI.getResources().getDrawable(C1318a.tv_info_thumb_default));
        AppMethodBeat.m2505o(24931);
    }

    /* renamed from: b */
    static /* synthetic */ void m67880b(TVInfoUI tVInfoUI) {
        AppMethodBeat.m2504i(24932);
        if (tVInfoUI.qwD == null) {
            C4990ab.m7420w("MicroMsg.TVInfoUI", "shareToFriend, but tv is null");
            AppMethodBeat.m2505o(24932);
            return;
        }
        C7060h.pYm.mo8381e(10987, Integer.valueOf(4), "", "", "");
        String a = C43525c.m77780a(tVInfoUI.mController.ylL, tVInfoUI.qwD);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", a);
        intent.putExtra("Retr_Msg_Type", 2);
        if (tVInfoUI.qwE != null && tVInfoUI.qdh) {
            intent.putExtra("Retr_Msg_thumb_path", tVInfoUI.qwE.anJ());
        }
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        C46193a.gkE.mo38926k(intent, tVInfoUI);
        AppMethodBeat.m2505o(24932);
    }

    /* renamed from: c */
    static /* synthetic */ void m67882c(TVInfoUI tVInfoUI) {
        AppMethodBeat.m2504i(24933);
        if (tVInfoUI.qwD == null) {
            C4990ab.m7420w("MicroMsg.TVInfoUI", "shareToTimeLine, but tv is null");
            AppMethodBeat.m2505o(24933);
            return;
        }
        C7060h.pYm.mo8381e(10987, Integer.valueOf(3), "", "", "");
        Intent intent = new Intent();
        if (C5046bo.isNullOrNil(tVInfoUI.qwD.field_topic)) {
            intent.putExtra("KContentObjDesc", tVInfoUI.qwD.field_subtitle);
        } else {
            intent.putExtra("KContentObjDesc", tVInfoUI.qwD.field_topic);
        }
        intent.putExtra("Ksnsupload_title", tVInfoUI.qwD.field_title);
        intent.putExtra("Ksnsupload_link", tVInfoUI.qwD.field_shareurl);
        intent.putExtra("Ksnsupload_appname", tVInfoUI.getString(C25738R.string.dz2));
        if (C3826k.cjQ()) {
            intent.putExtra("Ksnsupload_appid", "wxaf060266bfa9a35c");
        }
        intent.putExtra("Ksnsupload_imgurl", tVInfoUI.qwD.field_thumburl);
        if (tVInfoUI.qwE != null && tVInfoUI.qdh) {
            intent.putExtra("KsnsUpload_imgPath", tVInfoUI.qwE.anJ());
        }
        intent.putExtra("Ksnsupload_type", 5);
        intent.putExtra("KUploadProduct_UserData", C43525c.m77781b(tVInfoUI.qwD));
        String nW = C37922v.m64078nW("shake_tv");
        C37922v.m64076Zp().mo60676y(nW, true).mo53356j("prePublishId", "shake_tv");
        intent.putExtra("reportSessionId", nW);
        C25985d.m41467b((Context) tVInfoUI, "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.m2505o(24933);
    }

    /* renamed from: d */
    static /* synthetic */ void m67883d(TVInfoUI tVInfoUI) {
        AppMethodBeat.m2504i(24934);
        if (tVInfoUI.qwD == null) {
            C4990ab.m7420w("MicroMsg.TVInfoUI", "do favorite, but tv is null");
            AppMethodBeat.m2505o(24934);
            return;
        }
        C7060h.pYm.mo8381e(10987, Integer.valueOf(5), "", "", "");
        C45316cl c45316cl = new C45316cl();
        abf abf = new abf();
        abl abl = new abl();
        abo abo = new abo();
        abl.alD(C1853r.m3846Yz());
        abl.alE(C1853r.m3846Yz());
        abl.mo39126LN(8);
        abl.mo39136ml(C5046bo.anU());
        if (C3826k.cjQ()) {
            abl.alJ("wxaf060266bfa9a35c");
        }
        abo.alM(tVInfoUI.qwD.field_title);
        if (C5046bo.isNullOrNil(tVInfoUI.qwD.field_topic)) {
            abo.alN(tVInfoUI.qwD.field_subtitle);
        } else {
            abo.alN(tVInfoUI.qwD.field_topic);
        }
        abo.alP(C43525c.m77781b(tVInfoUI.qwD));
        abo.alO(tVInfoUI.qwD.field_thumburl);
        c45316cl.cvA.title = tVInfoUI.qwD.field_title;
        c45316cl.cvA.desc = tVInfoUI.qwD.field_topic;
        c45316cl.cvA.cvC = abf;
        c45316cl.cvA.type = 15;
        abf.mo74737a(abl);
        abf.mo74745b(abo);
        c45316cl.cvA.cvH = 12;
        c45316cl.cvA.activity = tVInfoUI;
        C4879a.xxA.mo10055m(c45316cl);
        AppMethodBeat.m2505o(24934);
    }
}
