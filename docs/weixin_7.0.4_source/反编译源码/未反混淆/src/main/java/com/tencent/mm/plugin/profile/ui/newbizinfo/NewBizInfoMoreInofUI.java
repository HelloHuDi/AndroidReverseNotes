package com.tencent.mm.plugin.profile.ui.newbizinfo;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.g;
import com.tencent.mm.aj.h.a;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference;
import com.tencent.mm.plugin.profile.ui.IconWidgetPreference;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NewBizInfoMoreInofUI extends MMPreference implements a {
    private f ehK;
    private ad ehM;
    private List<d.a> fuX;
    private b fuY;
    private boolean fvf = false;
    private int gwP;
    private d pkW;
    private String pmE;
    private boolean pmF;
    private Bundle pmH;
    private uy pmz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23900);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        xE(a.ppL);
        setMMTitle((int) R.string.auk);
        ta(WebView.NIGHT_MODE_COLOR);
        dyb();
        pO(false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(23896);
                NewBizInfoMoreInofUI.this.finish();
                AppMethodBeat.o(23896);
                return true;
            }
        }, R.raw.actionbar_icon_dark_back);
        String nullAsNil = bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
        String nullAsNil2 = bo.nullAsNil(getIntent().getStringExtra("Contact_Alias"));
        int intExtra = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
        int intExtra2 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
        String stringExtra = getIntent().getStringExtra("Contact_KWeibo");
        String stringExtra2 = getIntent().getStringExtra("Contact_KWeiboNick");
        aw.ZK();
        this.ehM = c.XM().aoO(nullAsNil);
        if (this.ehM == null || ((int) this.ehM.ewQ) == 0 || bo.nullAsNil(this.ehM.field_username).length() <= 0) {
            this.ehM = new ad();
            this.ehM.setUsername(nullAsNil);
            this.ehM.iy(nullAsNil2);
            this.ehM.hw(intExtra);
            this.ehM.iU(stringExtra);
            this.ehM.hv(intExtra2);
            this.ehM.iE(stringExtra2);
        } else if (intExtra != 0) {
            this.ehM.hw(intExtra);
        }
        this.pkW = com.tencent.mm.aj.f.qX(this.ehM.field_username);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("Contact_customInfo");
        try {
            this.pmz = byteArrayExtra == null ? null : (uy) new uy().parseFrom(byteArrayExtra);
        } catch (IOException e) {
            ab.printErrStackTrace("MicroMsg.NewBizInfoMoreInofUI", e, "", new Object[0]);
        }
        this.gwP = getIntent().getIntExtra("Contact_Scene", 9);
        this.pmH = getIntent().getBundleExtra("Contact_Ext_Args");
        initView();
        AppMethodBeat.o(23900);
    }

    private void cbE() {
        AppMethodBeat.i(23901);
        d qX = com.tencent.mm.aj.f.qX(this.ehM.field_username);
        this.fuX = null;
        this.fuY = null;
        if ((qX == null || qX.cJ(false) == null) && this.pmz != null) {
            qX = new d();
            qX.field_username = this.ehM.field_username;
            qX.field_brandFlag = this.pmz.gvb;
            qX.field_brandIconURL = this.pmz.gve;
            qX.field_brandInfo = this.pmz.gvd;
            qX.field_extInfo = this.pmz.gvc;
            qX.field_type = qX.cJ(false).getServiceType();
        }
        if (qX != null && qX.field_brandInfo == null && qX.field_extInfo == null && this.pmz != null) {
            qX.field_username = this.ehM.field_username;
            qX.field_brandFlag = this.pmz.gvb;
            qX.field_brandIconURL = this.pmz.gve;
            qX.field_brandInfo = this.pmz.gvd;
            qX.field_extInfo = this.pmz.gvc;
            qX.field_type = qX.cJ(false).getServiceType();
        }
        if (qX != null) {
            this.pkW = qX;
            this.fuX = qX.adY();
            this.fuY = qX.cJ(false);
            this.fvf = this.fuY.aea();
        }
        AppMethodBeat.o(23901);
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
        AppMethodBeat.i(23902);
        this.ehK.ce("biz_placed_to_the_top", true);
        cbE();
        if (com.tencent.mm.n.a.jh(this.ehM.field_type) && adV()) {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_wechat_account");
            if (!bo.isNullOrNil(this.ehM.Hq())) {
                this.ehK.ce("contact_info_wechat_account", false);
                keyValuePreference.setSummary((CharSequence) j.b((Context) this, this.ehM.Hq()));
            } else if (ad.aoA(this.ehM.field_username) || t.mX(this.ehM.field_username)) {
                this.ehK.ce("contact_info_wechat_account", true);
            } else {
                this.ehK.ce("contact_info_wechat_account", false);
                keyValuePreference.setSummary((CharSequence) this.mController.ylL.getString(R.string.qf) + bo.nullAsNil(this.ehM.Ok()));
            }
            keyValuePreference.yCY = new Preference.c() {
                public final boolean cbK() {
                    AppMethodBeat.i(23897);
                    try {
                        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setText(keyValuePreference.getSummary());
                    } catch (Exception e) {
                        ab.e("MicroMsg.NewBizInfoMoreInofUI", "clip.setText error ");
                    }
                    h.bQ(NewBizInfoMoreInofUI.this.mController.ylL, NewBizInfoMoreInofUI.this.mController.ylL.getString(R.string.oz));
                    AppMethodBeat.o(23897);
                    return true;
                }
            };
        } else {
            this.ehK.ce("contact_info_wechat_account", true);
        }
        if (this.fuY != null && this.fuY.aek() != null && !bo.isNullOrNil(this.fuY.aek().fvS)) {
            b.d aek = this.fuY.aek();
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser");
            if (keyValuePreference != null) {
                Bitmap i;
                keyValuePreference.dAD();
                keyValuePreference.yCj = false;
                if (bo.isNullOrNil(aek.fvT)) {
                    keyValuePreference.ylA = Bc(aek.fvR);
                } else {
                    keyValuePreference.ylA = aek.fvT;
                }
                if (ao.a.flw != null) {
                    i = BackwardSupportUtil.b.i(ao.a.flw.ky(this.ehM.field_verifyFlag), 2.0f);
                } else {
                    Object i2 = null;
                }
                if (i2 != null) {
                    bitmapDrawable = new BitmapDrawable(getResources(), com.tencent.mm.sdk.platformtools.d.LV(R.raw.new_biz_certified));
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
                ab.i(str, str3, objArr);
                keyValuePreference.yCr = bitmapDrawable;
                if (aek.fvS != null) {
                    str = aek.fvV;
                    CharSequence b = j.b((Context) this, aek.fvS.trim());
                    if (bo.isNullOrNil(str)) {
                        charSequence = b;
                    } else {
                        try {
                            charSequence = new SpannableString(str + " " + b);
                            try {
                                charSequence.setSpan(new ForegroundColorSpan(-36352), 0, str.length(), 17);
                            } catch (IndexOutOfBoundsException e2) {
                                e = e2;
                                ab.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", e.getMessage());
                                keyValuePreference.setSummary(charSequence);
                                if (this.fuY != null) {
                                }
                                ab.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
                                this.ehK.ce("contact_info_trademark", true);
                                if (this.fuY != null) {
                                }
                                this.ehK.ce("contact_info_privilege", true);
                                UR(getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
                                if (this.fuY != null) {
                                }
                                this.ehK.ce("contact_info_service_phone", true);
                                if (this.fuY != null) {
                                }
                                this.ehK.ce("contact_info_reputation", true);
                                this.ehK.ce("contact_info_guarantee_info", true);
                                this.ehK.ce("contact_info_scope_of_business", true);
                                if (t.w(this.ehM)) {
                                }
                                this.ehK.ce("contact_info_verifyuser_weibo", true);
                                if (this.fuY == null) {
                                }
                                this.ehK.ce("near_field_service", true);
                                if (cbJ() != null) {
                                }
                                indexOf = this.ehK.indexOf("contact_info_category2");
                                if (indexOf >= 0) {
                                }
                                ab.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
                                AppMethodBeat.o(23902);
                                return;
                            }
                        } catch (IndexOutOfBoundsException e3) {
                            e = e3;
                            charSequence = b;
                            ab.e("MicroMsg.NewBizInfoMoreInofUI", "verifySummary setSpan error: %s", e.getMessage());
                            keyValuePreference.setSummary(charSequence);
                            if (this.fuY != null) {
                            }
                            ab.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
                            this.ehK.ce("contact_info_trademark", true);
                            if (this.fuY != null) {
                            }
                            this.ehK.ce("contact_info_privilege", true);
                            UR(getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
                            if (this.fuY != null) {
                            }
                            this.ehK.ce("contact_info_service_phone", true);
                            if (this.fuY != null) {
                            }
                            this.ehK.ce("contact_info_reputation", true);
                            this.ehK.ce("contact_info_guarantee_info", true);
                            this.ehK.ce("contact_info_scope_of_business", true);
                            if (t.w(this.ehM)) {
                            }
                            this.ehK.ce("contact_info_verifyuser_weibo", true);
                            if (this.fuY == null) {
                            }
                            this.ehK.ce("near_field_service", true);
                            if (cbJ() != null) {
                            }
                            indexOf = this.ehK.indexOf("contact_info_category2");
                            if (indexOf >= 0) {
                            }
                            ab.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
                            AppMethodBeat.o(23902);
                            return;
                        }
                    }
                    keyValuePreference.setSummary(charSequence);
                } else {
                    ab.e("MicroMsg.NewBizInfoMoreInofUI", "[arthurdan.emojiSpan] Notice!!!! extInfo.verifyInfo.verifySourceDescription is null");
                }
            } else {
                this.ehK.ce("contact_info_verifyuser", true);
            }
        } else if (this.fuY == null || this.fuY.ael() == null || bo.isNullOrNil(this.fuY.ael().fwb)) {
            ab.w("MicroMsg.NewBizInfoMoreInofUI", "has not verify info");
            this.ehK.ce("contact_info_verifyuser", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) this.fuY.ael().fwb);
            }
        }
        if (this.fuY != null || bo.isNullOrNil(this.fuY.aee())) {
            ab.w("MicroMsg.NewBizInfoMoreInofUI", "has not trademark info");
            this.ehK.ce("contact_info_trademark", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_trademark");
            if (keyValuePreference != null) {
                Bitmap LV;
                keyValuePreference.dAD();
                keyValuePreference.yCj = false;
                if (ao.a.flw != null) {
                    LV = com.tencent.mm.sdk.platformtools.d.LV(R.raw.new_biz_trademark_protection);
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
                ab.i(str2, str, objArr2);
                if (LV != null) {
                    bitmapDrawable = new BitmapDrawable(getResources(), LV);
                } else {
                    bitmapDrawable = null;
                }
                keyValuePreference.yCr = bitmapDrawable;
                keyValuePreference.setSummary((CharSequence) this.fuY.aee());
                ab.d("MicroMsg.NewBizInfoMoreInofUI", "trademark name : %s, url : %s.", this.fuY.aee(), this.fuY.aed());
            }
        }
        if (this.fuY != null || this.fuY.aeg() == null || this.fuY.aeg().size() <= 0) {
            this.ehK.ce("contact_info_privilege", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_privilege");
            keyValuePreference.dAD();
            keyValuePreference.qi(false);
            keyValuePreference.dAC();
            for (b.f fVar : this.fuY.aeg()) {
                LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.a9b, null);
                ((ImageView) linearLayout.findViewById(R.id.aga)).setImageDrawable(new com.tencent.mm.plugin.profile.ui.b.c(getResources(), fVar.iconUrl));
                str2 = fVar.description;
                getResources().getIdentifier(fVar.fwa, "string", getPackageName());
                ((TextView) linearLayout.findViewById(R.id.a81)).setText(str2);
                keyValuePreference.eI(linearLayout);
            }
        }
        UR(getIntent().getStringExtra("Contact_BIZ_KF_WORKER_ID"));
        if (this.fuY != null || bo.isNullOrNil(this.fuY.aep())) {
            this.ehK.ce("contact_info_service_phone", true);
        } else {
            this.ehK.ce("contact_info_service_phone", false);
            Preference aqO = this.ehK.aqO("contact_info_service_phone");
            if (aqO != null) {
                aqO.setSummary(this.fuY.aep());
                aqO.ksd = getResources().getColor(R.color.t7);
            }
        }
        if (this.fuY != null || this.fuY.aei() == null) {
            this.ehK.ce("contact_info_reputation", true);
            this.ehK.ce("contact_info_guarantee_info", true);
            this.ehK.ce("contact_info_scope_of_business", true);
        } else {
            BizInfoPayInfoIconPreference bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ehK.aqO("contact_info_reputation");
            if (this.fuY.aei().fvW > 0) {
                bizInfoPayInfoIconPreference.AS(this.fuY.aei().fvW);
            } else {
                this.ehK.ce("contact_info_reputation", true);
            }
            bizInfoPayInfoIconPreference = (BizInfoPayInfoIconPreference) this.ehK.aqO("contact_info_guarantee_info");
            if (this.fuY.aei().fvY == null || this.fuY.aei().fvY.size() <= 0) {
                this.ehK.ce("contact_info_guarantee_info", true);
            } else {
                bizInfoPayInfoIconPreference.cC(this.fuY.aei().fvY);
            }
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_scope_of_business");
            if (bo.isNullOrNil(this.fuY.aei().fvX)) {
                this.ehK.ce("contact_info_scope_of_business", true);
            } else {
                keyValuePreference.setSummary((CharSequence) this.fuY.aei().fvX);
                keyValuePreference.yCp = 4;
                keyValuePreference.qi(false);
            }
        }
        if (t.w(this.ehM) || this.ehM.dug == null || this.ehM.dug.equals("")) {
            this.ehK.ce("contact_info_verifyuser_weibo", true);
        } else {
            keyValuePreference = (KeyValuePreference) this.ehK.aqO("contact_info_verifyuser_weibo");
            if (keyValuePreference != null) {
                keyValuePreference.setSummary((CharSequence) bo.bc(this.ehM.field_weiboNickname, "") + getString(R.string.eai, new Object[]{t.nP(this.ehM.dug)}));
                keyValuePreference.ksd = com.tencent.mm.bz.a.i(this, R.color.t7);
                keyValuePreference.qi(false);
            }
        }
        if (this.fuY == null && this.fuY.adZ()) {
            this.ehK.aqO("near_field_service").setSummary((int) R.string.g0r);
        } else {
            this.ehK.ce("near_field_service", true);
        }
        if (cbJ() != null) {
            this.ehK.ce("contact_info_see_locate", false);
        } else {
            this.ehK.ce("contact_info_see_locate", true);
        }
        indexOf = this.ehK.indexOf("contact_info_category2");
        if (indexOf >= 0 || this.fuX == null || this.fuX.size() <= 0) {
            ab.d("MicroMsg.NewBizInfoMoreInofUI", "pos no more");
            AppMethodBeat.o(23902);
            return;
        }
        int size = this.fuX.size() - 1;
        while (size >= 0) {
            if (this.fuX.get(size) != null && ((!getString(R.string.auy).equals(((d.a) this.fuX.get(size)).title) || this.fvf) && !((bo.isNullOrNil(((d.a) this.fuX.get(size)).title) && bo.isNullOrNil(((d.a) this.fuX.get(size)).fvb)) || ((d.a) this.fuX.get(size)).fvb.equals("__mp_wording__brandinfo_location") || getString(R.string.av0).equals(((d.a) this.fuX.get(size)).title) || ((d.a) this.fuX.get(size)).fvb.equals("__mp_wording__brandinfo_history_massmsg")))) {
                int i3;
                Preference preference = new Preference(this);
                preference.setKey("contact_info_bizinfo_external#".concat(String.valueOf(size)));
                charSequence = ((d.a) this.fuX.get(size)).title;
                int identifier = getResources().getIdentifier(((d.a) this.fuX.get(size)).fvb, "string", getPackageName());
                if (identifier > 0) {
                    charSequence = getString(identifier);
                }
                if (this.pkW.adO() && ("__mp_wording__brandinfo_history_massmsg".equals(((d.a) this.fuX.get(size)).fvb) || r1.equals(getString(R.string.__mp_wording__brandinfo_history_massmsg)))) {
                    charSequence = getString(R.string.bdf);
                }
                preference.setTitle(charSequence);
                if (!bo.isNullOrNil(((d.a) this.fuX.get(size)).description)) {
                    preference.setSummary(((d.a) this.fuX.get(size)).description);
                }
                if (bo.nullAsNil(((d.a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_feedback")) {
                    identifier = this.ehK.indexOf("contact_info_scope_of_business");
                    if (identifier > 0) {
                        i3 = identifier + 1;
                        this.ehK.a(preference, i3);
                        if (!bo.nullAsNil(((d.a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_biz_detail")) {
                            this.ehK.a(new PreferenceSmallCategory(this), i3);
                        }
                    }
                }
                i3 = indexOf;
                this.ehK.a(preference, i3);
                if (!bo.nullAsNil(((d.a) this.fuX.get(size)).fvb).equals("__mp_wording__brandinfo_biz_detail")) {
                }
            }
            size--;
        }
        AppMethodBeat.o(23902);
    }

    private d.a cbJ() {
        AppMethodBeat.i(23903);
        if (this.fuX == null || this.fuX.size() < 0) {
            ab.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
            AppMethodBeat.o(23903);
            return null;
        }
        for (d.a aVar : this.fuX) {
            if (!aVar.fvb.equals("__mp_wording__brandinfo_location")) {
                if (getString(R.string.av0).equals(aVar.title)) {
                }
            }
            AppMethodBeat.o(23903);
            return aVar;
        }
        ab.w("MicroMsg.NewBizInfoMoreInofUI", "brandInfoList is null not show location");
        AppMethodBeat.o(23903);
        return null;
    }

    private void UR(String str) {
        AppMethodBeat.i(23904);
        ab.d("MicroMsg.NewBizInfoMoreInofUI", "updateKF %s, %b", str, Boolean.valueOf(this.pmF));
        if (this.pmF) {
            AppMethodBeat.o(23904);
            return;
        }
        this.pmE = str;
        g rh;
        IconWidgetPreference iconWidgetPreference;
        Bitmap a;
        if (this.fuY == null || !this.fuY.aeq() || this.ehM == null) {
            this.ehK.ce("contact_info_kf_worker", true);
            AppMethodBeat.o(23904);
        } else if (bo.isNullOrNil(str)) {
            rh = z.aeQ().rh(this.ehM.field_username);
            if (rh == null) {
                this.ehK.ce("contact_info_kf_worker", true);
                z.aeS().a(this);
                z.aeS().ax(this.ehM.field_username, r.Yz());
                this.pmF = true;
                AppMethodBeat.o(23904);
                return;
            }
            ab.d("MicroMsg.NewBizInfoMoreInofUI", "has default kf %s", rh.field_openId);
            this.ehK.ce("contact_info_kf_worker", false);
            iconWidgetPreference = (IconWidgetPreference) this.ehK.aqO("contact_info_kf_worker");
            iconWidgetPreference.setSummary((CharSequence) rh.field_nickname);
            a = com.tencent.mm.ah.b.a(rh.field_openId, false, -1);
            if (a == null) {
                c(rh);
                US(rh.field_openId);
                AppMethodBeat.o(23904);
                return;
            }
            iconWidgetPreference.O(a);
            AppMethodBeat.o(23904);
        } else {
            i aeQ = z.aeQ();
            g rg = aeQ.rg(str);
            if (rg == null || i.a(rg)) {
                z.aeS().a(this);
                z.aeS().ay(this.ehM.field_username, str);
                this.pmF = true;
            }
            if (rg == null) {
                ab.d("MicroMsg.NewBizInfoMoreInofUI", "no such kf, get default kf");
                rh = aeQ.rh(this.ehM.field_username);
            } else {
                rh = rg;
            }
            if (rh == null) {
                this.ehK.ce("contact_info_kf_worker", true);
                AppMethodBeat.o(23904);
                return;
            }
            this.ehK.ce("contact_info_kf_worker", false);
            iconWidgetPreference = (IconWidgetPreference) this.ehK.aqO("contact_info_kf_worker");
            iconWidgetPreference.setSummary((CharSequence) rh.field_nickname);
            a = com.tencent.mm.ah.b.a(rh.field_openId, false, -1);
            if (a == null) {
                c(rh);
                US(rh.field_openId);
            } else {
                iconWidgetPreference.O(a);
            }
            ab.d("MicroMsg.NewBizInfoMoreInofUI", "kf worker %s, %s", rh.field_openId, rh.field_nickname);
            AppMethodBeat.o(23904);
        }
    }

    private static void c(g gVar) {
        AppMethodBeat.i(23905);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.ah.i act = o.act();
        if (act.qo(gVar.field_openId) == null) {
            com.tencent.mm.ah.h hVar = new com.tencent.mm.ah.h();
            hVar.username = gVar.field_openId;
            hVar.frV = gVar.field_headImgUrl;
            hVar.cB(false);
            hVar.dtR = 3;
            act.b(hVar);
        }
        o.acv().qa(gVar.field_openId);
        ab.d("MicroMsg.NewBizInfoMoreInofUI", "downloadKFAvatar, %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(23905);
    }

    private void US(final String str) {
        AppMethodBeat.i(23906);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(23898);
                if (NewBizInfoMoreInofUI.this.ehK == null) {
                    ab.w("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar screen is null");
                    AppMethodBeat.o(23898);
                    return;
                }
                IconWidgetPreference iconWidgetPreference = (IconWidgetPreference) NewBizInfoMoreInofUI.this.ehK.aqO("contact_info_kf_worker");
                if (!(iconWidgetPreference == null || NewBizInfoMoreInofUI.this.ehK == null)) {
                    Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
                    if (a != null) {
                        ab.d("MicroMsg.NewBizInfoMoreInofUI", "LazyGetAvatar success %s, update screen", str);
                        iconWidgetPreference.O(a);
                        NewBizInfoMoreInofUI.this.ehK.notifyDataSetChanged();
                    }
                }
                AppMethodBeat.o(23898);
            }
        }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(23906);
    }

    public final String aeI() {
        return "MicroMsg.NewBizInfoMoreInofUI";
    }

    public final void e(LinkedList<cwa> linkedList) {
        AppMethodBeat.i(23907);
        z.aeS().b(this);
        if (this.ehK == null) {
            ab.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, screen is null");
            AppMethodBeat.o(23907);
        } else if (this.ehM == null) {
            ab.e("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, contact is null");
            AppMethodBeat.o(23907);
        } else if (linkedList == null || linkedList.size() <= 0) {
            ab.w("MicroMsg.NewBizInfoMoreInofUI", "onKFSceneEnd, worker is null");
            AppMethodBeat.o(23907);
        } else {
            if (!bo.isNullOrNil(this.pmE)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    cwa cwa = (cwa) it.next();
                    if (cwa.xrU != null && cwa.xrU.equals(this.pmE)) {
                        this.ehK.ce("contact_info_kf_worker", false);
                        this.ehK.aqO("contact_info_kf_worker").setSummary(cwa.wCW);
                        AppMethodBeat.o(23907);
                        return;
                    }
                }
            }
            this.ehK.ce("contact_info_kf_worker", false);
            this.ehK.aqO("contact_info_kf_worker").setSummary(((cwa) linkedList.get(0)).wCW);
            AppMethodBeat.o(23907);
        }
    }

    private String Bc(int i) {
        AppMethodBeat.i(23908);
        String string;
        switch (i) {
            case 0:
                string = getResources().getString(R.string.b24);
                AppMethodBeat.o(23908);
                return string;
            case 1:
                string = getResources().getString(R.string.aur);
                AppMethodBeat.o(23908);
                return string;
            case 2:
                string = getResources().getString(R.string.aus);
                AppMethodBeat.o(23908);
                return string;
            default:
                ab.w("MicroMsg.NewBizInfoMoreInofUI", "getVerifyStr, error type %d", Integer.valueOf(i));
                string = getResources().getString(R.string.aww);
                AppMethodBeat.o(23908);
                return string;
        }
    }

    private boolean adV() {
        AppMethodBeat.i(23909);
        if (this.pkW == null) {
            AppMethodBeat.o(23909);
            return true;
        }
        boolean adV = this.pkW.adV();
        AppMethodBeat.o(23909);
        return adV;
    }

    public final int JC() {
        return R.xml.b6;
    }

    private void aV(int i, String str) {
        AppMethodBeat.i(23911);
        if (this.pmH == null || !(this.gwP == 39 || this.gwP == 56 || this.gwP == 35 || this.gwP == 87 || this.gwP == 88 || this.gwP == 89 || this.gwP == 85)) {
            ab.d("MicroMsg.NewBizInfoMoreInofUI", "mExtArgs is null or the add contact action is not from biz search.");
            AppMethodBeat.o(23911);
        } else if (this.ehM == null) {
            ab.i("MicroMsg.NewBizInfoMoreInofUI", "contact is null.");
            AppMethodBeat.o(23911);
        } else {
            int i2;
            String string = this.pmH.getString("Contact_Ext_Args_Search_Id");
            String nullAsNil = bo.nullAsNil(this.pmH.getString("Contact_Ext_Args_Query_String"));
            int i3 = this.pmH.getInt("Contact_Ext_Args_Index");
            switch (this.gwP) {
                case 35:
                    i2 = 1;
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.l.i.CTRL_INDEX /*85*/:
                    i2 = 5;
                    break;
                case com.tencent.view.d.MIC_COLORPENCIL /*87*/:
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
            String nullAsNil2 = bo.nullAsNil(this.pmH.getString("Contact_Ext_Extra_Params"));
            String str2 = nullAsNil + "," + i + "," + bo.nullAsNil(this.ehM.field_username) + "," + i3 + "," + (System.currentTimeMillis() / 1000) + "," + string + "," + i2;
            if (bo.isNullOrNil(str)) {
                str2 = str2 + ",," + nullAsNil2;
            } else {
                str2 = str2 + "," + str + "," + nullAsNil2;
            }
            ab.v("MicroMsg.NewBizInfoMoreInofUI", "report 10866: %s", str2);
            com.tencent.mm.plugin.report.service.h.pYm.X(10866, str2);
            AppMethodBeat.o(23911);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 6;
        AppMethodBeat.i(23910);
        String str = preference.mKey;
        ab.i("MicroMsg.NewBizInfoMoreInofUI", str + " item has been clicked!");
        String str2;
        Intent intent;
        int i2;
        String str3;
        d dVar;
        Intent intent2;
        if ("contact_info_see_locate".endsWith(str)) {
            d.a cbJ = cbJ();
            if (cbJ == null) {
                ab.e("MicroMsg.NewBizInfoMoreInofUI", "[onPreferenceTreeClick] info is null, err");
                AppMethodBeat.o(23910);
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
                ab.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
                Bundle bundle = new Bundle();
                bundle.putBoolean("KFromBizSearch", true);
                bundle.putBundle("KBizSearchExtArgs", this.pmH);
                intent.putExtra("jsapiargs", bundle);
                i2 = com.tencent.mm.n.a.jh(this.ehM.field_type) ? 7 : 6;
                int identifier = getResources().getIdentifier(cbJ.fvb, "string", getPackageName());
                str3 = cbJ.title;
                if (identifier > 0) {
                    str3 = getString(identifier);
                }
                aV(i2, str3);
            }
            com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(23910);
            return true;
        } else if ("contact_info_verifyuser".endsWith(str)) {
            dVar = this.pkW;
            if (dVar == null) {
                AppMethodBeat.o(23910);
                return true;
            }
            b cJ = dVar.cJ(false);
            if (cJ == null) {
                AppMethodBeat.o(23910);
                return true;
            }
            str2 = null;
            if (cJ.aek() != null && !bo.isNullOrNil(cJ.aek().fvU)) {
                str2 = cJ.aek().fvU;
            } else if (!(cJ.ael() == null || bo.isNullOrNil(cJ.ael().fwc))) {
                str2 = cJ.ael().fwc;
            }
            if (!bo.isNullOrNil(str2)) {
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str2);
                intent2.putExtra("useJs", true);
                intent2.putExtra("vertical_scroll", true);
                intent2.putExtra("geta8key_scene", 3);
                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
            }
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.cP(this.ehM.field_username, TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE);
            AppMethodBeat.o(23910);
            return true;
        } else if ("contact_info_trademark".endsWith(str)) {
            dVar = this.pkW;
            if (dVar == null) {
                AppMethodBeat.o(23910);
                return true;
            }
            if (!(dVar.cJ(false) == null || bo.isNullOrNil(dVar.cJ(false).aed()))) {
                intent2 = new Intent();
                intent2.putExtra("rawUrl", dVar.cJ(false).aed());
                intent2.putExtra("useJs", true);
                intent2.putExtra("vertical_scroll", true);
                intent2.putExtra("geta8key_scene", 3);
                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent2);
            }
            AppMethodBeat.o(23910);
            return true;
        } else {
            if ("contact_info_service_phone".equals(str)) {
                Preference aqO = fVar.aqO("contact_info_service_phone");
                if (!(aqO == null || aqO.getSummary() == null || bo.isNullOrNil(aqO.getSummary().toString()))) {
                    str3 = aqO.getSummary().toString();
                    h.a((Context) this, true, str3, "", getString(R.string.avl), getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(23899);
                            Intent intent = new Intent("android.intent.action.DIAL");
                            intent.setFlags(268435456);
                            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str3).toString()));
                            if (bo.k(NewBizInfoMoreInofUI.this, intent)) {
                                NewBizInfoMoreInofUI.this.startActivity(intent);
                            }
                            AppMethodBeat.o(23899);
                        }
                    }, null);
                }
            }
            if (str.startsWith("contact_info_bizinfo_external#")) {
                i2 = bo.getInt(str.replace("contact_info_bizinfo_external#", ""), -1);
                if (i2 >= 0 && i2 < this.fuX.size()) {
                    d.a aVar = (d.a) this.fuX.get(i2);
                    str3 = aVar.url;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("geta8key_scene", 3);
                    intent.putExtra("KPublisherId", "brand_profile");
                    intent.putExtra("prePublishId", "brand_profile");
                    if ((this.pmH != null && (this.gwP == 39 || this.gwP == 56 || this.gwP == 35)) || this.gwP == 87 || this.gwP == 89 || this.gwP == 85 || this.gwP == 88) {
                        ab.d("MicroMsg.NewBizInfoMoreInofUI", "from biz search.");
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("KFromBizSearch", true);
                        bundle2.putBundle("KBizSearchExtArgs", this.pmH);
                        intent.putExtra("jsapiargs", bundle2);
                        if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
                            i = 7;
                        }
                        int identifier2 = getResources().getIdentifier(aVar.fvb, "string", getPackageName());
                        str2 = aVar.title;
                        if (identifier2 > 0) {
                            str2 = getString(identifier2);
                        }
                        aV(i, str2);
                    }
                    com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.o(23910);
                    return true;
                }
            }
            if (str.equals("contact_info_verifyuser_weibo")) {
                new com.tencent.mm.plugin.profile.ui.a.a(this).fF(this.ehM.dug, this.ehM.field_username);
                AppMethodBeat.o(23910);
                return true;
            }
            Intent intent3;
            if (!(!"contact_info_guarantee_info".equals(str) || this.fuY.aei() == null || bo.isNullOrNil(this.fuY.aei().fvZ))) {
                intent3 = new Intent();
                intent3.putExtra("rawUrl", this.fuY.aei().fvZ);
                intent3.putExtra("useJs", true);
                intent3.putExtra("vertical_scroll", true);
                intent3.putExtra("geta8key_scene", 3);
                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent3);
            }
            if (!(!"contact_info_expose_btn".equals(str) || this.ehM == null || bo.isNullOrNil(this.ehM.field_username))) {
                intent3 = new Intent();
                intent3.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/infringement?username=%s&from=1#wechat_redirect", new Object[]{this.ehM.field_username}));
                intent3.putExtra("showShare", false);
                com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent3);
            }
            AppMethodBeat.o(23910);
            return false;
        }
    }
}
