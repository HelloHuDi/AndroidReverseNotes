package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17881i;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16528a;
import com.tencent.p177mm.p184aj.C16527d.C16529b;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16531d;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16533f;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C37453h.C37454a;
import com.tencent.p177mm.p184aj.C41743i;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C46874g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23634c;
import com.tencent.p177mm.p612ui.base.preference.PreferenceSmallCategory;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C33345i;
import com.tencent.p177mm.plugin.profile.p483ui.BizInfoPayInfoIconPreference;
import com.tencent.p177mm.plugin.profile.p483ui.IconWidgetPreference;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c.C34739c;
import com.tencent.p177mm.plugin.profile.p483ui.p1288b.C46914c;
import com.tencent.p177mm.plugin.profile.p483ui.p738a.C39508a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.cwa;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI */
public class NewBizInfoMoreInofUI extends MMPreference implements C37454a {
    private C15541f ehK;
    private C7616ad ehM;
    private List<C16528a> fuX;
    private C16529b fuY;
    private boolean fvf = false;
    private int gwP;
    private C16527d pkW;
    private String pmE;
    private boolean pmF;
    private Bundle pmH;
    private C7285uy pmz;

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMoreInofUI$1 */
    class C287011 implements OnMenuItemClickListener {
        C287011() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(23896);
            NewBizInfoMoreInofUI.this.finish();
            AppMethodBeat.m2505o(23896);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(23900);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        mo17446xE(C46139a.ppL);
        setMMTitle((int) C25738R.string.auk);
        mo17443ta(WebView.NIGHT_MODE_COLOR);
        dyb();
        mo17426pO(false);
        setBackBtn(new C287011(), C1318a.actionbar_icon_dark_back);
        String nullAsNil = C5046bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
        String nullAsNil2 = C5046bo.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
        int intExtra = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
        int intExtra2 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
        String stringExtra = getIntent().getStringExtra("Contact_KWeibo");
        String stringExtra2 = getIntent().getStringExtra("Contact_KWeiboNick");
        C9638aw.m17190ZK();
        this.ehM = C18628c.m29078XM().aoO(nullAsNil);
        if (this.ehM == null || ((int) this.ehM.ewQ) == 0 || C5046bo.nullAsNil(this.ehM.field_username).length() <= 0) {
            this.ehM = new C7616ad();
            this.ehM.setUsername(nullAsNil);
            this.ehM.mo14728iy(nullAsNil2);
            this.ehM.mo14698hw(intExtra);
            this.ehM.mo14722iU(stringExtra);
            this.ehM.mo14697hv(intExtra2);
            this.ehM.mo14706iE(stringExtra2);
        } else if (intExtra != 0) {
            this.ehM.mo14698hw(intExtra);
        }
        this.pkW = C17903f.m28104qX(this.ehM.field_username);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("Contact_customInfo");
        try {
            this.pmz = byteArrayExtra == null ? null : (C7285uy) new C7285uy().parseFrom(byteArrayExtra);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", e, "", new Object[0]);
        }
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.pmH = getIntent().getBundleExtra("Contact_Ext_Args");
        initView();
        AppMethodBeat.m2505o(23900);
    }

    private void cbE() {
        AppMethodBeat.m2504i(23901);
        C16527d qX = C17903f.m28104qX(this.ehM.field_username);
        this.fuX = null;
        this.fuY = null;
        if ((qX == null || qX.mo30481cJ(false) == null) && this.pmz != null) {
            qX = new C16527d();
            qX.field_username = this.ehM.field_username;
            qX.field_brandFlag = this.pmz.gvb;
            qX.field_brandIconURL = this.pmz.gve;
            qX.field_brandInfo = this.pmz.gvd;
            qX.field_extInfo = this.pmz.gvc;
            qX.field_type = qX.mo30481cJ(false).getServiceType();
        }
        if (qX != null && qX.field_brandInfo == null && qX.field_extInfo == null && this.pmz != null) {
            qX.field_username = this.ehM.field_username;
            qX.field_brandFlag = this.pmz.gvb;
            qX.field_brandIconURL = this.pmz.gve;
            qX.field_brandInfo = this.pmz.gvd;
            qX.field_extInfo = this.pmz.gvc;
            qX.field_type = qX.mo30481cJ(false).getServiceType();
        }
        if (qX != null) {
            this.pkW = qX;
            this.fuX = qX.adY();
            this.fuY = qX.mo30481cJ(false);
            this.fvf = this.fuY.aea();
        }
        AppMethodBeat.m2505o(23901);
    }

    /* JADX WARNING: Removed duplicated region for block: B:201:0x05de A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x05d4  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0639  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0639  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0470  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initView() {
        final KeyValuePreference keyValuePreference;
        Drawable bitmapDrawable;
        String str;
        boolean z;
        CharSequence charSequence;
        IndexOutOfBoundsException e;
        int indexOf;
        String str2;
        AppMethodBeat.m2504i(23902);
        this.ehK.mo27715ce("biz_placed_to_the_top", true);
        cbE();
        if (C7486a.m12942jh(this.ehM.field_type) && adV()) {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_wechat_account");
            if (!C5046bo.isNullOrNil(this.ehM.mo14673Hq())) {
                this.ehK.mo27715ce("contact_info_wechat_account", false);
                keyValuePreference.setSummary((CharSequence) C44089j.m79292b((Context) this, this.ehM.mo14673Hq()));
            } else if (C7616ad.aoA(this.ehM.field_username) || C1855t.m3911mX(this.ehM.field_username)) {
                this.ehK.mo27715ce("contact_info_wechat_account", true);
            } else {
                this.ehK.mo27715ce("contact_info_wechat_account", false);
                keyValuePreference.setSummary((CharSequence) this.mController.ylL.getString(C25738R.string.f9131qf) + C5046bo.nullAsNil(this.ehM.mo16708Ok()));
            }
            keyValuePreference.yCY = new C23634c() {
                public final boolean cbK() {
                    AppMethodBeat.m2504i(23897);
                    try {
                        ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setText(keyValuePreference.getSummary());
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.NewBizInfoMoreInofUI", "clip.setText error ");
                    }
                    C30379h.m48465bQ(NewBizInfoMoreInofUI.this.mController.ylL, NewBizInfoMoreInofUI.this.mController.ylL.getString(C25738R.string.f9083oz));
                    AppMethodBeat.m2505o(23897);
                    return true;
                }
            };
        } else {
            this.ehK.mo27715ce("contact_info_wechat_account", true);
        }
        if (this.fuY != null && this.fuY.aek() != null && !C5046bo.isNullOrNil(this.fuY.aek().fvS)) {
            C16531d aek = this.fuY.aek();
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser");
            if (keyValuePreference != null) {
                Bitmap i;
                keyValuePreference.dAD();
                keyValuePreference.yCj = false;
                if (C5046bo.isNullOrNil(aek.fvT)) {
                    keyValuePreference.ylA = m45593Bc(aek.fvR);
                } else {
                    keyValuePreference.ylA = aek.fvT;
                }
                if (C26417a.flw != null) {
                    i = C4977b.m7374i(C26417a.flw.mo37872ky(this.ehM.field_verifyFlag), 2.0f);
                } else {
                    Object i2 = null;
                }
                if (i2 != null) {
                    bitmapDrawable = new BitmapDrawable(getResources(), C5056d.m7610LV(C1318a.new_biz_certified));
                } else {
                    bitmapDrawable = null;
                }
                str = "MicroMsg.NewBizInfoMoreInofUI";
                String str3 = "verify bmp is null ? %B";
                Object[] objArr = new Object[1];
                if (i2 == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                C4990ab.m7417i(str, str3, objArr);
                keyValuePreference.yCr = bitmapDrawable;
                if (aek.fvS != null) {
                    str = aek.fvV;
                    CharSequence b = C44089j.m79292b((Context) this, aek.fvS.trim());
                    if (C5046bo.isNullOrNil(str)) {
                        charSequence = b;
                    } else {
                        try {
                            charSequence = new SpannableString(str + " " + b);
                            try {
                                charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str.length(), 17);
                            } catch (IndexOutOfBoundsException e2) {
                                e = e2;
                                C4990ab.m7413e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", e.getMessage());
                                keyValuePreference.setSummary(charSequence);
                                if (this.fuY != null) {
                                }
                                C4990ab.m7420w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
                                this.ehK.mo27715ce("contact_info_trademark", true);
                                if (this.fuY != null) {
                                }
                                this.ehK.mo27715ce("contact_info_privilege", true);
                                m45594UR(getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
                                if (this.fuY != null) {
                                }
                                this.ehK.mo27715ce("contact_info_service_phone", true);
                                if (this.fuY != null) {
                                }
                                this.ehK.mo27715ce("contact_info_reputation", true);
                                this.ehK.mo27715ce("contact_info_guarantee_info", true);
                                this.ehK.mo27715ce("contact_info_scope_of_business", true);
                                if (C1855t.m3968w(this.ehM)) {
                                }
                                this.ehK.mo27715ce("contact_info_verifyuser_weibo", true);
                                if (this.fuY == null) {
                                }
                                this.ehK.mo27715ce("near_field_service", true);
                                if (cbJ() != null) {
                                }
                                indexOf = this.ehK.indexOf("contact_info_category2");
                                if (indexOf >= 0) {
                                }
                                C4990ab.m7410d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
                                AppMethodBeat.m2505o(23902);
                                return;
                            }
                        } catch (IndexOutOfBoundsException e3) {
                            e = e3;
                            charSequence = b;
                            C4990ab.m7413e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", e.getMessage());
                            keyValuePreference.setSummary(charSequence);
                            if (this.fuY != null) {
                            }
                            C4990ab.m7420w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
                            this.ehK.mo27715ce("contact_info_trademark", true);
                            if (this.fuY != null) {
                            }
                            this.ehK.mo27715ce("contact_info_privilege", true);
                            m45594UR(getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
                            if (this.fuY != null) {
                            }
                            this.ehK.mo27715ce("contact_info_service_phone", true);
                            if (this.fuY != null) {
                            }
                            this.ehK.mo27715ce("contact_info_reputation", true);
                            this.ehK.mo27715ce("contact_info_guarantee_info", true);
                            this.ehK.mo27715ce("contact_info_scope_of_business", true);
                            if (C1855t.m3968w(this.ehM)) {
                            }
                            this.ehK.mo27715ce("contact_info_verifyuser_weibo", true);
                            if (this.fuY == null) {
                            }
                            this.ehK.mo27715ce("near_field_service", true);
                            if (cbJ() != null) {
                            }
                            indexOf = this.ehK.indexOf("contact_info_category2");
                            if (indexOf >= 0) {
                            }
                            C4990ab.m7410d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
                            AppMethodBeat.m2505o(23902);
                            return;
                        }
                    }
                    keyValuePreference.setSummary(charSequence);
                } else {
                    C4990ab.m7412e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                }
            } else {
                this.ehK.mo27715ce("contact_info_verifyuser", true);
            }
        } else if (this.fuY == null || this.fuY.ael() == null || C5046bo.isNullOrNil(this.fuY.ael().fwb)) {
            C4990ab.m7420w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
            this.ehK.mo27715ce("contact_info_verifyuser", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.fuY.ael().fwb);
            }
        }
        if (this.fuY != null || C5046bo.isNullOrNil(this.fuY.aee())) {
            C4990ab.m7420w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
            this.ehK.mo27715ce("contact_info_trademark", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_trademark");
            if (keyValuePreference != null) {
                Bitmap LV;
                keyValuePreference.dAD();
                keyValuePreference.yCj = false;
                if (C26417a.flw != null) {
                    LV = C5056d.m7610LV(C1318a.new_biz_trademark_protection);
                } else {
                    LV = null;
                }
                str2 = "MicroMsg.NewBizInfoMoreInofUI";
                str = "trademark bmp is null ? %B";
                Object[] objArr2 = new Object[1];
                if (LV == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr2[0] = Boolean.valueOf(z);
                C4990ab.m7417i(str2, str, objArr2);
                if (LV != null) {
                    bitmapDrawable = new BitmapDrawable(getResources(), LV);
                } else {
                    bitmapDrawable = null;
                }
                keyValuePreference.yCr = bitmapDrawable;
                keyValuePreference.setSummary((CharSequence) this.fuY.aee());
                C4990ab.m7411d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", this.fuY.aee(), this.fuY.aed());
            }
        }
        if (this.fuY != null || this.fuY.aeg() == null || this.fuY.aeg().size() <= 0) {
            this.ehK.mo27715ce("contact_info_privilege", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_privilege");
            keyValuePreference.dAD();
            keyValuePreference.mo41844qi(false);
            keyValuePreference.dAC();
            for (C16533f c16533f : this.fuY.aeg()) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this, 2130969913, null);
                ((ImageView) linearLayout.findViewById(2131822184)).setImageDrawable(new C46914c(getResources(), c16533f.iconUrl));
                str2 = c16533f.description;
                getResources().getIdentifier(c16533f.fwa, "string", getPackageName());
                ((TextView) linearLayout.findViewById(2131821841)).setText(str2);
                keyValuePreference.mo41843eI(linearLayout);
            }
        }
        m45594UR(getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
        if (this.fuY != null || C5046bo.isNullOrNil(this.fuY.aep())) {
            this.ehK.mo27715ce("contact_info_service_phone", true);
        } else {
            this.ehK.mo27715ce("contact_info_service_phone", false);
            Preference aqO = this.ehK.aqO("contact_info_service_phone");
            if (aqO != null) {
                aqO.setSummary(this.fuY.aep());
                aqO.ksd = getResources().getColor(C25738R.color.f12123t7);
            }
        }
        if (this.fuY != null || this.fuY.aei() == null) {
            this.ehK.mo27715ce("contact_info_reputation", true);
            this.ehK.mo27715ce("contact_info_guarantee_info", true);
            this.ehK.mo27715ce("contact_info_scope_of_business", true);
        } else {
            BizInfoPayInfoIconPreference bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ehK.aqO("contact_info_reputation");
            if (this.fuY.aei().fvW > 0) {
                bizInfoPayInfoIconPreference.mo46830AS(this.fuY.aei().fvW);
            } else {
                this.ehK.mo27715ce("contact_info_reputation", true);
            }
            bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ehK.aqO("contact_info_guarantee_info");
            if (this.fuY.aei().fvY == null || this.fuY.aei().fvY.size() <= 0) {
                this.ehK.mo27715ce("contact_info_guarantee_info", true);
            } else {
                bizInfoPayInfoIconPreference.mo46831cC(this.fuY.aei().fvY);
            }
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_scope_of_business");
            if (C5046bo.isNullOrNil(this.fuY.aei().fvX)) {
                this.ehK.mo27715ce("contact_info_scope_of_business", true);
            } else {
                keyValuePreference.setSummary((CharSequence) this.fuY.aei().fvX);
                keyValuePreference.yCp = 4;
                keyValuePreference.mo41844qi(false);
            }
        }
        if (C1855t.m3968w(this.ehM) || this.ehM.dug == null || this.ehM.dug.equals("")) {
            this.ehK.mo27715ce("contact_info_verifyuser_weibo", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser_weibo");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) C5046bo.m7532bc(this.ehM.field_weiboNickname, "") + getString(C25738R.string.eai, new Object[]{C1855t.m3930nP(this.ehM.dug)}));
                keyValuePreference.ksd = C1338a.m2872i(this, C25738R.color.f12123t7);
                keyValuePreference.mo41844qi(false);
            }
        }
        if (this.fuY == null && this.fuY.adZ()) {
            this.ehK.aqO("near_field_service").setSummary((int) C25738R.string.g0r);
        } else {
            this.ehK.mo27715ce("near_field_service", true);
        }
        if (cbJ() != null) {
            this.ehK.mo27715ce("contact_info_see_locate", false);
        } else {
            this.ehK.mo27715ce("contact_info_see_locate", true);
        }
        indexOf = this.ehK.indexOf("contact_info_category2");
        if (indexOf >= 0 || this.fuX == null || this.fuX.size() <= 0) {
            C4990ab.m7410d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
            AppMethodBeat.m2505o(23902);
            return;
        }
        int size = this.fuX.size() - 1;
        while (size >= 0) {
            if (this.fuX.get(size) != null && ((!getString(C25738R.string.auy).equals(((C16528a) this.fuX.get(size)).title) || this.fvf) && !((C5046bo.isNullOrNil(((C16528a) this.fuX.get(size)).title) && C5046bo.isNullOrNil(((C16528a) this.fuX.get(size)).fvb)) || ((C16528a) this.fuX.get(size)).fvb.equals("__mp_wording__brandinfo_location") || getString(C25738R.string.av0).equals(((C16528a) this.fuX.get(size)).title) || ((C16528a) this.fuX.get(size)).fvb.equals("__mp_wording__brandinfo_history_massmsg")))) {
                int i3;
                Preference preference = new Preference(this);
                preference.setKey("contact_info_bizinfo_external#".concat(String.valueOf(size)));
                charSequence = ((C16528a) this.fuX.get(size)).title;
                int identifier = getResources().getIdentifier(((C16528a) this.fuX.get(size)).fvb, "string", getPackageName());
                if (identifier > 0) {
                    charSequence = getString(identifier);
                }
                if (this.pkW.adO() && ("__mp_wording__brandinfo_history_massmsg".equals(((C16528a) this.fuX.get(size)).fvb) || r1.equals(getString(C25738R.string.__mp_wording__brandinfo_history_massmsg)))) {
                    charSequence = getString(C25738R.string.bdf);
                }
                preference.setTitle(charSequence);
                if (!C5046bo.isNullOrNil(((C16528a) this.fuX.get(size)).description)) {
                    preference.setSummary(((C16528a) this.fuX.get(size)).description);
                }
                if (C5046bo.nullAsNil(((C16528a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_feedback")) {
                    identifier = this.ehK.indexOf("contact_info_scope_of_business");
                    if (identifier > 0) {
                        i3 = identifier + 1;
                        this.ehK.mo27708a(preference, i3);
                        if (!C5046bo.nullAsNil(((C16528a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_biz_detail")) {
                            this.ehK.mo27708a(new PreferenceSmallCategory(this), i3);
                        }
                    }
                }
                i3 = indexOf;
                this.ehK.mo27708a(preference, i3);
                if (!C5046bo.nullAsNil(((C16528a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_biz_detail")) {
                }
            }
            size--;
        }
        AppMethodBeat.m2505o(23902);
    }

    private C16528a cbJ() {
        AppMethodBeat.m2504i(23903);
        if (this.fuX == null || this.fuX.size() < 0) {
            C4990ab.m7420w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
            AppMethodBeat.m2505o(23903);
            return null;
        }
        for (C16528a c16528a : this.fuX) {
            if (!c16528a.fvb.equals("__mp_wording__brandinfo_location")) {
                if (getString(C25738R.string.av0).equals(c16528a.title)) {
                }
            }
            AppMethodBeat.m2505o(23903);
            return c16528a;
        }
        C4990ab.m7420w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
        AppMethodBeat.m2505o(23903);
        return null;
    }

    /* renamed from: UR */
    private void m45594UR(String str) {
        AppMethodBeat.m2504i(23904);
        C4990ab.m7411d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", str, Boolean.valueOf(this.pmF));
        if (this.pmF) {
            AppMethodBeat.m2505o(23904);
            return;
        }
        this.pmE = str;
        C46874g rh;
        IconWidgetPreference iconWidgetPreference;
        Bitmap a;
        if (this.fuY == null || !this.fuY.aeq() || this.ehM == null) {
            this.ehK.mo27715ce("contact_info_kf_worker", true);
            AppMethodBeat.m2505o(23904);
        } else if (C5046bo.isNullOrNil(str)) {
            rh = C41747z.aeQ().mo67511rh(this.ehM.field_username);
            if (rh == null) {
                this.ehK.mo27715ce("contact_info_kf_worker", true);
                C41747z.aeS().mo60362a(this);
                C41747z.aeS().mo60363ax(this.ehM.field_username, C1853r.m3846Yz());
                this.pmF = true;
                AppMethodBeat.m2505o(23904);
                return;
            }
            C4990ab.m7411d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", rh.field_openId);
            this.ehK.mo27715ce("contact_info_kf_worker", false);
            iconWidgetPreference = (IconWidgetPreference) this.ehK.aqO("contact_info_kf_worker");
            iconWidgetPreference.setSummary((CharSequence) rh.field_nickname);
            a = C41730b.m73490a(rh.field_openId, false, -1);
            if (a == null) {
                NewBizInfoMoreInofUI.m45598c(rh);
                m45595US(rh.field_openId);
                AppMethodBeat.m2505o(23904);
                return;
            }
            iconWidgetPreference.mo24866O(a);
            AppMethodBeat.m2505o(23904);
        } else {
            C41743i aeQ = C41747z.aeQ();
            C46874g rg = aeQ.mo67510rg(str);
            if (rg == null || C41743i.m73577a(rg)) {
                C41747z.aeS().mo60362a(this);
                C41747z.aeS().mo60364ay(this.ehM.field_username, str);
                this.pmF = true;
            }
            if (rg == null) {
                C4990ab.m7410d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
                rh = aeQ.mo67511rh(this.ehM.field_username);
            } else {
                rh = rg;
            }
            if (rh == null) {
                this.ehK.mo27715ce("contact_info_kf_worker", true);
                AppMethodBeat.m2505o(23904);
                return;
            }
            this.ehK.mo27715ce("contact_info_kf_worker", false);
            iconWidgetPreference = (IconWidgetPreference) this.ehK.aqO("contact_info_kf_worker");
            iconWidgetPreference.setSummary((CharSequence) rh.field_nickname);
            a = C41730b.m73490a(rh.field_openId, false, -1);
            if (a == null) {
                NewBizInfoMoreInofUI.m45598c(rh);
                m45595US(rh.field_openId);
            } else {
                iconWidgetPreference.mo24866O(a);
            }
            C4990ab.m7411d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", rh.field_openId, rh.field_nickname);
            AppMethodBeat.m2505o(23904);
        }
    }

    /* renamed from: c */
    private static void m45598c(C46874g c46874g) {
        AppMethodBeat.m2504i(23905);
        long currentTimeMillis = System.currentTimeMillis();
        C17881i act = C17884o.act();
        if (act.mo33392qo(c46874g.field_openId) == null) {
            C17880h c17880h = new C17880h();
            c17880h.username = c46874g.field_openId;
            c17880h.frV = c46874g.field_headImgUrl;
            c17880h.mo33385cB(false);
            c17880h.dtR = 3;
            act.mo33391b(c17880h);
        }
        C17884o.acv().mo67496qa(c46874g.field_openId);
        C4990ab.m7411d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(23905);
    }

    /* renamed from: US */
    private void m45595US(final String str) {
        AppMethodBeat.m2504i(23906);
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(23898);
                if (NewBizInfoMoreInofUI.this.ehK == null) {
                    C4990ab.m7420w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
                    AppMethodBeat.m2505o(23898);
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) NewBizInfoMoreInofUI.this.ehK.aqO("contact_info_kf_worker");
                if (!(iconWidgetPreference == null || NewBizInfoMoreInofUI.this.ehK == null)) {
                    Bitmap a = C41730b.m73490a(str, false, -1);
                    if (a != null) {
                        C4990ab.m7411d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", str);
                        iconWidgetPreference.mo24866O(a);
                        NewBizInfoMoreInofUI.this.ehK.notifyDataSetChanged();
                    }
                }
                AppMethodBeat.m2505o(23898);
            }
        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(23906);
    }

    public final String aeI() {
        return "MicroMsg.NewBizInfoMoreInofUI";
    }

    /* renamed from: e */
    public final void mo11035e(LinkedList<cwa> linkedList) {
        AppMethodBeat.m2504i(23907);
        C41747z.aeS().mo60365b(this);
        if (this.ehK == null) {
            C4990ab.m7412e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
            AppMethodBeat.m2505o(23907);
        } else if (this.ehM == null) {
            C4990ab.m7412e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
            AppMethodBeat.m2505o(23907);
        } else if (linkedList == null || linkedList.size() <= 0) {
            C4990ab.m7420w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
            AppMethodBeat.m2505o(23907);
        } else {
            if (!C5046bo.isNullOrNil(this.pmE)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    cwa cwa = (cwa) it.next();
                    if (cwa.xrU != null && cwa.xrU.equals(this.pmE)) {
                        this.ehK.mo27715ce("contact_info_kf_worker", false);
                        this.ehK.aqO("contact_info_kf_worker").setSummary(cwa.wCW);
                        AppMethodBeat.m2505o(23907);
                        return;
                    }
                }
            }
            this.ehK.mo27715ce("contact_info_kf_worker", false);
            this.ehK.aqO("contact_info_kf_worker").setSummary(((cwa) linkedList.get(0)).wCW);
            AppMethodBeat.m2505o(23907);
        }
    }

    /* renamed from: Bc */
    private String m45593Bc(int i) {
        AppMethodBeat.m2504i(23908);
        String string;
        switch (i) {
            case 0:
                string = getResources().getString(C25738R.string.b24);
                AppMethodBeat.m2505o(23908);
                return string;
            case 1:
                string = getResources().getString(C25738R.string.aur);
                AppMethodBeat.m2505o(23908);
                return string;
            case 2:
                string = getResources().getString(C25738R.string.aus);
                AppMethodBeat.m2505o(23908);
                return string;
            default:
                C4990ab.m7421w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", Integer.valueOf(i));
                string = getResources().getString(C25738R.string.aww);
                AppMethodBeat.m2505o(23908);
                return string;
        }
    }

    private boolean adV() {
        AppMethodBeat.m2504i(23909);
        if (this.pkW == null) {
            AppMethodBeat.m2505o(23909);
            return true;
        }
        boolean adV = this.pkW.adV();
        AppMethodBeat.m2505o(23909);
        return adV;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8521b6;
    }

    /* renamed from: aV */
    private void m45597aV(int i, String str) {
        AppMethodBeat.m2504i(23911);
        if (this.pmH == null || !(this.gwP == 39 || this.gwP == 56 || this.gwP == 35 || this.gwP == 87 || this.gwP == 88 || this.gwP == 89 || this.gwP == 85)) {
            C4990ab.m7410d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
            AppMethodBeat.m2505o(23911);
        } else if (this.ehM == null) {
            C4990ab.m7416i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
            AppMethodBeat.m2505o(23911);
        } else {
            int i2;
            String string = this.pmH.getString("Contact_Ext_Args_Search_Id");
            String nullAsNil = C5046bo.nullAsNil(this.pmH.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.pmH.getInt("Contact_Ext_Args_Index");
            switch (this.gwP) {
                case 35:
                    i2 = 1;
                    break;
                case C33345i.CTRL_INDEX /*85*/:
                    i2 = 5;
                    break;
                case C31128d.MIC_COLORPENCIL /*87*/:
                    i2 = 2;
                    break;
                case 88:
                    i2 = 3;
                    break;
                case PlayerException.EXCEPTION_IN_CHECK_STATE /*89*/:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String nullAsNil2 = C5046bo.nullAsNil(this.pmH.getString("Contact_Ext_Extra_Params"));
            String str2 = nullAsNil + "," + i + "," + C5046bo.nullAsNil(this.ehM.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (C5046bo.isNullOrNil(str)) {
                str2 = str2 + ",," + nullAsNil2;
            } else {
                str2 = str2 + "," + str + "," + nullAsNil2;
            }
            C4990ab.m7419v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", str2);
            C7060h.pYm.mo8374X(10866, str2);
            AppMethodBeat.m2505o(23911);
        }
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        int i = 6;
        AppMethodBeat.m2504i(23910);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.NewBizInfoMoreInofUI", str + " item has been clicked!");
        String str2;
        Intent intent;
        int i2;
        String str3;
        C16527d c16527d;
        Intent intent2;
        if ("contact_info_see_locate".endsWith(str)) {
            C16528a cbJ = cbJ();
            if (cbJ == null) {
                C4990ab.m7412e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
                AppMethodBeat.m2505o(23910);
                return false;
            }
            str2 = cbJ.url;
            intent = new Intent();
            intent.putExtra("rawUrl", str2);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("geta8key_scene", 3);
            intent.putExtra("KPublisherId", "brand_profile");
            intent.putExtra("prePublishId", "brand_profile");
            if ((this.pmH != null && (this.gwP == 39 || this.gwP == 56 || this.gwP == 35)) || this.gwP == 87 || this.gwP == 89 || this.gwP == 85 || this.gwP == 88) {
                C4990ab.m7410d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
                Bundle bundle = new Bundle();
                bundle.putBoolean("KFromBizSearch", true);
                bundle.putBundle("KBizSearchExtArgs", this.pmH);
                intent.putExtra("jsapiargs", bundle);
                i2 = C7486a.m12942jh(this.ehM.field_type) ? 7 : 6;
                int identifier = getResources().getIdentifier(cbJ.fvb, "string", getPackageName());
                str3 = cbJ.title;
                if (identifier > 0) {
                    str3 = getString(identifier);
                }
                m45597aV(i2, str3);
            }
            C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(23910);
            return true;
        } else if ("contact_info_verifyuser".endsWith(str)) {
            c16527d = this.pkW;
            if (c16527d == null) {
                AppMethodBeat.m2505o(23910);
                return true;
            }
            C16529b cJ = c16527d.mo30481cJ(false);
            if (cJ == null) {
                AppMethodBeat.m2505o(23910);
                return true;
            }
            str2 = null;
            if (cJ.aek() != null && !C5046bo.isNullOrNil(cJ.aek().fvU)) {
                str2 = cJ.aek().fvU;
            } else if (!(cJ.ael() == null || C5046bo.isNullOrNil(cJ.ael().fwc))) {
                str2 = cJ.ael().fwc;
            }
            if (!C5046bo.isNullOrNil(str2)) {
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str2);
                intent2.putExtra("useJs", true);
                intent2.putExtra("vertical_scroll", true);
                intent2.putExtra("geta8key_scene", 3);
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
            }
            C34739c.m57055cP(this.ehM.field_username, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
            AppMethodBeat.m2505o(23910);
            return true;
        } else if ("contact_info_trademark".endsWith(str)) {
            c16527d = this.pkW;
            if (c16527d == null) {
                AppMethodBeat.m2505o(23910);
                return true;
            }
            if (!(c16527d.mo30481cJ(false) == null || C5046bo.isNullOrNil(c16527d.mo30481cJ(false).aed()))) {
                intent2 = new Intent();
                intent2.putExtra("rawUrl", c16527d.mo30481cJ(false).aed());
                intent2.putExtra("useJs", true);
                intent2.putExtra("vertical_scroll", true);
                intent2.putExtra("geta8key_scene", 3);
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
            }
            AppMethodBeat.m2505o(23910);
            return true;
        } else {
            if ("contact_info_service_phone".equals(str)) {
                Preference aqO = c15541f.aqO("contact_info_service_phone");
                if (!(aqO == null || aqO.getSummary() == null || C5046bo.isNullOrNil(aqO.getSummary().toString()))) {
                    str3 = aqO.getSummary().toString();
                    C30379h.m48453a((Context) this, true, str3, "", getString(C25738R.string.avl), getString(C25738R.string.f9076or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(23899);
                            Intent intent = new Intent("android.intent.action.DIAL");
                            intent.setFlags(268435456);
                            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str3).toString()));
                            if (C5046bo.m7572k(NewBizInfoMoreInofUI.this, intent)) {
                                NewBizInfoMoreInofUI.this.startActivity(intent);
                            }
                            AppMethodBeat.m2505o(23899);
                        }
                    }, null);
                }
            }
            if (str.startsWith("contact_info_bizinfo_external#")) {
                i2 = C5046bo.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                if (i2 >= 0 && i2 < this.fuX.size()) {
                    C16528a c16528a = (C16528a) this.fuX.get(i2);
                    str3 = c16528a.url;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("geta8key_scene", 3);
                    intent.putExtra("KPublisherId", "brand_profile");
                    intent.putExtra("prePublishId", "brand_profile");
                    if ((this.pmH != null && (this.gwP == 39 || this.gwP == 56 || this.gwP == 35)) || this.gwP == 87 || this.gwP == 89 || this.gwP == 85 || this.gwP == 88) {
                        C4990ab.m7410d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("KFromBizSearch", true);
                        bundle2.putBundle("KBizSearchExtArgs", this.pmH);
                        intent.putExtra("jsapiargs", bundle2);
                        if (C7486a.m12942jh(this.ehM.field_type)) {
                            i = 7;
                        }
                        int identifier2 = getResources().getIdentifier(c16528a.fvb, "string", getPackageName());
                        str2 = c16528a.title;
                        if (identifier2 > 0) {
                            str2 = getString(identifier2);
                        }
                        m45597aV(i, str2);
                    }
                    C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(23910);
                    return true;
                }
            }
            if (str.equals("contact_info_verifyuser_weibo")) {
                new C39508a(this).mo62470fF(this.ehM.dug, this.ehM.field_username);
                AppMethodBeat.m2505o(23910);
                return true;
            }
            Intent intent3;
            if (!(!"contact_info_guarantee_info".equals(str) || this.fuY.aei() == null || C5046bo.isNullOrNil(this.fuY.aei().fvZ))) {
                intent3 = new Intent();
                intent3.putExtra("rawUrl", this.fuY.aei().fvZ);
                intent3.putExtra("useJs", true);
                intent3.putExtra("vertical_scroll", true);
                intent3.putExtra("geta8key_scene", 3);
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent3);
            }
            if (!(!"contact_info_expose_btn".equals(str) || this.ehM == null || C5046bo.isNullOrNil(this.ehM.field_username))) {
                intent3 = new Intent();
                intent3.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.ehM.field_username}));
                intent3.putExtra("showShare", false);
                C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent3);
            }
            AppMethodBeat.m2505o(23910);
            return false;
        }
    }
}
