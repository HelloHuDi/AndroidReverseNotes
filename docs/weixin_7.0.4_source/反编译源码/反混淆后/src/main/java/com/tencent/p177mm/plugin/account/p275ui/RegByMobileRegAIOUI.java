package com.tencent.p177mm.plugin.account.p275ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p230g.p232b.p233a.C42085ba;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.MMFormInputView;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C32889i;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.model.C18844g;
import com.tencent.p177mm.plugin.account.p275ui.ResizeLayout.C33029a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C30167n.C7244a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bqw;
import com.tencent.p177mm.protocal.protobuf.cgx;
import com.tencent.p177mm.protocal.protobuf.crs;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI */
public class RegByMobileRegAIOUI extends MMActivity implements C1202f {
    private String countryCode = null;
    private ImageView ejo;
    private String fHE = null;
    private C4884c gAY = new C189041();
    private String gBE = null;
    private C42085ba gBm = new C42085ba();
    private ResizeLayout gCa;
    private TextView gDL;
    private Button gDN;
    private boolean gDT = true;
    private String gDV = null;
    private final int gDd = 128;
    private String gDp;
    private String gDq;
    private int gDr = 0;
    private String gDy;
    private int gEu;
    private EditText gFH;
    private TextView gFI;
    private MMFormInputView gFJ;
    private String gFK = null;
    private MMFormInputView gFL;
    private boolean gFM = false;
    private ImageView gFN;
    private MMFormInputView gFO;
    private Bitmap gFP;
    private ScrollView gFQ;
    private String gFR;
    private String gFS;
    private String gFT;
    private String gFU;
    private String gFV;
    private boolean gFW = true;
    private C5653c gFX = null;
    private boolean gFY = false;
    private int gFZ;
    private int gGa;
    private boolean gGb;
    private boolean gGc;
    private LinearLayout grF;
    private TextView grH;
    private String grJ = null;
    private String gsF;
    private C44275p guc;

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$21 */
    class C202821 extends ClickableSpan {
        C202821() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125364);
            C5046bo.m7506M(RegByMobileRegAIOUI.this.mController.ylL, RegByMobileRegAIOUI.this.getString(C25738R.string.ezo));
            AppMethodBeat.m2505o(125364);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(125365);
            textPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(C25738R.color.f12123t7));
            textPaint.setUnderlineText(true);
            AppMethodBeat.m2505o(125365);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$14 */
    class C997814 implements OnClickListener {
        C997814() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125356);
            RegByMobileRegAIOUI.m29507u(RegByMobileRegAIOUI.this);
            RegByMobileRegAIOUI.this.gBm.daR = (long) RegByMobileRegAIOUI.this.gEu;
            RegByMobileRegAIOUI.this.gBm.cVS = 8;
            RegByMobileRegAIOUI.this.gBm.ajK();
            AppMethodBeat.m2505o(125356);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$2 */
    class C99802 implements TextWatcher {
        C99802() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125336);
            RegByMobileRegAIOUI.m29486b(RegByMobileRegAIOUI.this);
            AppMethodBeat.m2505o(125336);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$5 */
    class C99815 implements C5002a {
        String ekv;

        C99815() {
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(125342);
            if (C5046bo.isNullOrNil((RegByMobileRegAIOUI.this.gFH.getText()).trim())) {
                String Ps = C5025av.m7481Ps(this.ekv);
                if (!C5046bo.isNullOrNil(this.ekv) && "+86".equals(Ps)) {
                    RegByMobileRegAIOUI.this.gFH.setText(this.ekv.substring(3));
                }
            }
            AppMethodBeat.m2505o(125342);
            return true;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(125343);
            this.ekv = C32889i.getPhoneNum(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.countryCode);
            AppMethodBeat.m2505o(125343);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(125344);
            String str = super.toString() + "|initView1";
            AppMethodBeat.m2505o(125344);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$20 */
    class C1890220 extends ClickableSpan {
        C1890220() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125362);
            C5046bo.m7506M(RegByMobileRegAIOUI.this.mController.ylL, RegByMobileRegAIOUI.this.getString(C25738R.string.g7o, new Object[]{C4988aa.dor(), C4988aa.doq(), "setting", Integer.valueOf(0), Integer.valueOf(0)}));
            AppMethodBeat.m2505o(125362);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(125363);
            textPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(C25738R.color.f12123t7));
            textPaint.setUnderlineText(true);
            AppMethodBeat.m2505o(125363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$13 */
    class C1890313 implements OnClickListener {
        C1890313() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125355);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(RegByMobileRegAIOUI.this.getClass().getName()).append(",RE200_200,");
            C1720g.m3534RN();
            C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("RE200_200")).append(",2").toString());
            C42756a.m75796wA("RE200_100");
            AppMethodBeat.m2505o(125355);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$1 */
    class C189041 extends C4884c<C37745jk> {
        C189041() {
            AppMethodBeat.m2504i(125334);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(125334);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(125335);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(125335);
                return false;
            }
            C4990ab.m7417i("MicroMsg.RegByMobileRegAIOUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(125335);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$10 */
    class C1890810 implements C5002a {
        C1890810() {
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(125351);
            InputStream inputStream = null;
            try {
                inputStream = new URL(RegByMobileRegAIOUI.this.gFV).openConnection().getInputStream();
                RegByMobileRegAIOUI.this.gFP = C5056d.decodeStream(inputStream);
                if (!(RegByMobileRegAIOUI.this.gFP == null || RegByMobileRegAIOUI.this.gFP.isRecycled())) {
                    C5056d.m7625a(RegByMobileRegAIOUI.this.gFP, 100, CompressFormat.PNG, C6457e.euY + "temp.avatar", false);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", e, "get avatar from http failed!", new Object[0]);
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
                AppMethodBeat.m2505o(125351);
            }
            AppMethodBeat.m2505o(125351);
            return true;
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(125352);
            if (!(RegByMobileRegAIOUI.this.gFM || RegByMobileRegAIOUI.this.gFP == null || RegByMobileRegAIOUI.this.gFP.isRecycled())) {
                RegByMobileRegAIOUI.this.ejo.setImageBitmap(RegByMobileRegAIOUI.this.gFP);
                RegByMobileRegAIOUI.this.gFN.setVisibility(8);
                RegByMobileRegAIOUI.this.gFM = true;
            }
            AppMethodBeat.m2505o(125352);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$11 */
    class C1890911 implements OnClickListener {
        C1890911() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(125353);
            RegByMobileRegAIOUI.m29506t(RegByMobileRegAIOUI.this);
            C42756a.m75796wA("RE200_250");
            AppMethodBeat.m2505o(125353);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$15 */
    class C1891015 implements Runnable {
        C1891015() {
        }

        public final void run() {
            AppMethodBeat.m2504i(125357);
            Intent bh = C24679a.gkE.mo38909bh(RegByMobileRegAIOUI.this);
            bh.addFlags(67108864);
            RegByMobileRegAIOUI.this.startActivity(bh);
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3534RN();
            stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(RegByMobileRegAIOUI.this.getClass().getName()).append(",L14,");
            C1720g.m3534RN();
            C42756a.m75797wB(stringBuilder.append(C1668a.m3407lF("L14")).append(",4").toString());
            RegByMobileRegAIOUI.this.finish();
            AppMethodBeat.m2505o(125357);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$22 */
    class C1891122 extends ClickableSpan {
        C1891122() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125366);
            C5046bo.m7506M(RegByMobileRegAIOUI.this.mController.ylL, RegByMobileRegAIOUI.this.getString(C25738R.string.g7o, new Object[]{C4988aa.dor(), C4988aa.doq(), "reg", Integer.valueOf(1), Integer.valueOf(0)}));
            AppMethodBeat.m2505o(125366);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(125367);
            textPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(C25738R.color.f12123t7));
            textPaint.setUnderlineText(true);
            AppMethodBeat.m2505o(125367);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$25 */
    class C1891425 implements TextWatcher {
        C1891425() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(125372);
            RegByMobileRegAIOUI.m29486b(RegByMobileRegAIOUI.this);
            AppMethodBeat.m2505o(125372);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$12 */
    class C1891512 implements C33029a {
        C1891512() {
        }

        public final void aqZ() {
            AppMethodBeat.m2504i(125354);
            RegByMobileRegAIOUI.m29483a(RegByMobileRegAIOUI.this);
            AppMethodBeat.m2505o(125354);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$19 */
    class C1891719 extends ClickableSpan {
        C1891719() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125360);
            C5046bo.m7506M(RegByMobileRegAIOUI.this.mController.ylL, RegByMobileRegAIOUI.this.getString(C25738R.string.ezj));
            AppMethodBeat.m2505o(125360);
        }

        public final void updateDrawState(TextPaint textPaint) {
            AppMethodBeat.m2504i(125361);
            textPaint.setColor(RegByMobileRegAIOUI.this.getResources().getColor(C25738R.color.f12123t7));
            textPaint.setUnderlineText(true);
            AppMethodBeat.m2505o(125361);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$7 */
    class C189187 implements OnMenuItemClickListener {
        C189187() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(125346);
            RegByMobileRegAIOUI.this.aqX();
            RegByMobileRegAIOUI.m29499m(RegByMobileRegAIOUI.this);
            RegByMobileRegAIOUI.this.finish();
            AppMethodBeat.m2505o(125346);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$9 */
    class C189199 implements C5002a {
        String nickname;

        C189199() {
        }

        public final boolean acg() {
            AppMethodBeat.m2504i(125348);
            if (!C5046bo.isNullOrNil(this.nickname) && C5046bo.isNullOrNil((RegByMobileRegAIOUI.this.gFO.getText()).trim())) {
                RegByMobileRegAIOUI.this.gFO.setText(this.nickname);
            }
            if (C1445f.m3070Mn()) {
                if (!(RegByMobileRegAIOUI.this.gFP == null || RegByMobileRegAIOUI.this.gFP.isRecycled() || RegByMobileRegAIOUI.this.gFM)) {
                    RegByMobileRegAIOUI.this.ejo.setImageBitmap(RegByMobileRegAIOUI.this.gFP);
                    RegByMobileRegAIOUI.this.gFN.setVisibility(8);
                    RegByMobileRegAIOUI.this.gFM = true;
                }
                AppMethodBeat.m2505o(125348);
                return true;
            }
            C4990ab.m7412e("MicroMsg.RegByMobileRegAIOUI", "SDcard is not available");
            AppMethodBeat.m2505o(125348);
            return false;
        }

        public final boolean acf() {
            AppMethodBeat.m2504i(125349);
            this.nickname = C32889i.m53829cj(RegByMobileRegAIOUI.this);
            RegByMobileRegAIOUI.this.gFP = C32889i.m53830ck(RegByMobileRegAIOUI.this);
            if (!(RegByMobileRegAIOUI.this.gFP == null || RegByMobileRegAIOUI.this.gFP.isRecycled())) {
                try {
                    C5056d.m7625a(RegByMobileRegAIOUI.this.gFP, 100, CompressFormat.PNG, C6457e.euY + "temp.avatar", false);
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.RegByMobileRegAIOUI", "save avatar fail." + e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(125349);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(125350);
            String str = super.toString() + "|initView2";
            AppMethodBeat.m2505o(125350);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$17 */
    class C1892017 implements OnCancelListener {
        C1892017() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$6 */
    class C189216 implements View.OnClickListener {
        C189216() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125345);
            Intent intent = new Intent();
            intent.putExtra("country_name", RegByMobileRegAIOUI.this.fHE);
            intent.putExtra("couttry_code", RegByMobileRegAIOUI.this.countryCode);
            C24679a.gkE.mo38903b(intent, RegByMobileRegAIOUI.this);
            AppMethodBeat.m2505o(125345);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$8 */
    class C189228 implements View.OnClickListener {
        C189228() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125347);
            C24679a.gkF.mo38870o(RegByMobileRegAIOUI.this);
            AppMethodBeat.m2505o(125347);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RegByMobileRegAIOUI() {
        AppMethodBeat.m2504i(125373);
        AppMethodBeat.m2505o(125373);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m29486b(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.m2504i(125392);
        boolean arr = regByMobileRegAIOUI.arr();
        AppMethodBeat.m2505o(125392);
        return arr;
    }

    /* renamed from: d */
    static /* synthetic */ void m29490d(RegByMobileRegAIOUI regByMobileRegAIOUI, String str) {
        AppMethodBeat.m2504i(125394);
        regByMobileRegAIOUI.m29510wv(str);
        AppMethodBeat.m2505o(125394);
    }

    /* renamed from: j */
    static /* synthetic */ void m29496j(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.m2504i(125393);
        regByMobileRegAIOUI.aro();
        AppMethodBeat.m2505o(125393);
    }

    /* renamed from: m */
    static /* synthetic */ void m29499m(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.m2504i(125395);
        regByMobileRegAIOUI.aoZ();
        AppMethodBeat.m2505o(125395);
    }

    /* renamed from: t */
    static /* synthetic */ void m29506t(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.m2504i(125396);
        regByMobileRegAIOUI.arp();
        AppMethodBeat.m2505o(125396);
    }

    public final int getLayoutId() {
        return 2130970496;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(125374);
        super.onCreate(bundle);
        this.fHE = C5046bo.m7532bc(getIntent().getStringExtra("country_name"), "");
        this.countryCode = C5025av.amO(C5046bo.m7532bc(getIntent().getStringExtra("couttry_code"), ""));
        this.gBE = C5046bo.nullAsNil(getIntent().getStringExtra("iso_code"));
        this.grJ = C5046bo.m7532bc(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.gFR = getIntent().getStringExtra("register_title");
        this.gFU = getIntent().getStringExtra("register_nick_name");
        this.gFV = getIntent().getStringExtra("register_avatar");
        this.gFS = getIntent().getStringExtra("third_app_token");
        this.gEu = getIntent().getIntExtra("reg_3d_app_type", 0);
        initView();
        AppMethodBeat.m2505o(125374);
    }

    public void onResume() {
        AppMethodBeat.m2504i(125375);
        C4879a.xxA.mo10052c(this.gAY);
        super.onResume();
        C1720g.m3540Rg().mo14539a(701, (C1202f) this);
        C1720g.m3540Rg().mo14539a(252, (C1202f) this);
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        C1720g.m3540Rg().mo14539a(132, (C1202f) this);
        C1720g.m3540Rg().mo14539a(755, (C1202f) this);
        C1720g.m3540Rg().mo14539a(252, (C1202f) this);
        C1720g.m3540Rg().mo14539a(701, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",RE200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("RE200_100")).append(",1").toString());
        this.gDr = 0;
        AppMethodBeat.m2505o(125375);
    }

    public void onPause() {
        AppMethodBeat.m2504i(125376);
        super.onPause();
        if (this.guc != null) {
            this.guc.dismiss();
        }
        C4879a.xxA.mo10053d(this.gAY);
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        C1720g.m3540Rg().mo14546b(132, (C1202f) this);
        C1720g.m3540Rg().mo14546b(755, (C1202f) this);
        C1720g.m3540Rg().mo14546b(252, (C1202f) this);
        C1720g.m3540Rg().mo14546b(701, (C1202f) this);
        C42756a.m75798wz("RE200_100");
        AppMethodBeat.m2505o(125376);
    }

    private void apc() {
        AppMethodBeat.m2504i(125377);
        if (C5046bo.isNullOrNil(this.fHE) || C5046bo.isNullOrNil(this.countryCode)) {
            this.gBE = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            C4990ab.m7416i("MicroMsg.RegByMobileRegAIOUI", "tm.getSimCountryIso()" + this.gBE);
            if (C5046bo.isNullOrNil(this.gBE)) {
                C4990ab.m7412e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
                AppMethodBeat.m2505o(125377);
                return;
            }
            C17951a k = C17950b.m28210k(this, this.gBE, getString(C25738R.string.b3_));
            if (k == null) {
                C4990ab.m7412e("MicroMsg.RegByMobileRegAIOUI", "getDefaultCountryInfo error");
                AppMethodBeat.m2505o(125377);
                return;
            }
            this.fHE = k.fHE;
            this.countryCode = k.fHD;
            AppMethodBeat.m2505o(125377);
            return;
        }
        AppMethodBeat.m2505o(125377);
    }

    public final void initView() {
        AppMethodBeat.m2504i(125378);
        this.grF = (LinearLayout) findViewById(2131821726);
        this.grH = (TextView) findViewById(2131821728);
        this.gFI = (TextView) findViewById(2131826924);
        this.gFJ = (MMFormInputView) findViewById(2131826930);
        this.gFJ.setInputType(3);
        this.gFH = this.gFJ.getContentEditText();
        this.gDL = (TextView) findViewById(2131826124);
        this.gDN = (Button) findViewById(2131826932);
        this.ejo = (ImageView) findViewById(2131826928);
        this.gFN = (ImageView) findViewById(2131826929);
        this.gFL = (MMFormInputView) findViewById(2131826931);
        C7357c.m12555d(this.gFL.getContentEditText()).mo15877PM(16).mo15879a(null);
        this.gFQ = (ScrollView) findViewById(2131820921);
        this.gCa = (ResizeLayout) findViewById(2131825288);
        this.gFO = (MMFormInputView) findViewById(2131826926);
        this.gCa.setOnSizeChanged(new C1891512());
        String string = getString(C25738R.string.cmf);
        String str = "  ";
        String string2;
        String string3;
        String string4;
        Spannable newSpannable;
        if (C4988aa.doo()) {
            string2 = getString(C25738R.string.cmg);
            string3 = getString(C25738R.string.dei);
            string4 = getString(C25738R.string.f8812fq);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new C1891719(), string.length() + str.length(), (string.length() + string2.length()) + str.length(), 33);
            newSpannable.setSpan(new C1890220(), ((string.length() + str.length()) + string2.length()) + string4.length(), (((string.length() + str.length()) + string2.length()) + string4.length()) + string3.length(), 33);
            this.gDL.setText(newSpannable);
        } else {
            string2 = getString(C25738R.string.cmk);
            string3 = getString(C25738R.string.cmi);
            string4 = getString(C25738R.string.f8812fq);
            newSpannable = Factory.getInstance().newSpannable(string + str + string2 + string4 + string3);
            newSpannable.setSpan(new C202821(), string.length() + str.length(), (string.length() + str.length()) + string2.length(), 33);
            newSpannable.setSpan(new C1891122(), ((string.length() + string2.length()) + str.length()) + string4.length(), (((string.length() + string2.length()) + str.length()) + string4.length()) + string3.length(), 33);
            this.gDL.setText(newSpannable);
        }
        this.gDL.setMovementMethod(LinkMovementMethod.getInstance());
        final boolean[] zArr = new boolean[]{true};
        this.gFH.addTextChangedListener(new TextWatcher() {
            private C5025av gGg = new C5025av();

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.m2504i(125369);
                RegByMobileRegAIOUI.m29486b(RegByMobileRegAIOUI.this);
                AppMethodBeat.m2505o(125369);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.m2504i(125370);
                if (zArr[0]) {
                    zArr[0] = false;
                    C6998b.oTO.mo8085TI("ie_reg");
                }
                C6998b.oTO.mo8086TJ("ie_reg");
                AppMethodBeat.m2505o(125370);
            }
        });
        this.gFH.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.m2504i(125371);
                if (z) {
                    zArr[0] = true;
                    AppMethodBeat.m2505o(125371);
                    return;
                }
                C6998b.oTO.mo8087TK("ie_reg");
                AppMethodBeat.m2505o(125371);
            }
        });
        this.gFL.addTextChangedListener(new C1891425());
        this.gFO.addTextChangedListener(new C99802());
        zArr = new boolean[]{false};
        this.gDN.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(125337);
                switch (motionEvent.getAction()) {
                    case 0:
                    case 5:
                        zArr[0] = true;
                        C6998b.oTO.mo8107fu("ce_reg", "<Reg>");
                        break;
                    case 1:
                    case 6:
                        C6998b.oTO.mo8095a("ce_reg", motionEvent);
                        C6998b.oTO.mo8090TN("ce_reg");
                        break;
                }
                AppMethodBeat.m2505o(125337);
                return false;
            }
        });
        this.gDN.setOnClickListener(new View.OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI$4$1 */
            class C189071 implements C5581a {
                C189071() {
                }

                /* renamed from: ki */
                public final void mo11317ki(String str) {
                    AppMethodBeat.m2504i(125338);
                    RegByMobileRegAIOUI.this.gDV = C5025av.amN(RegByMobileRegAIOUI.this.gFH.getText().toString());
                    RegByMobileRegAIOUI.this.gFK = C5025av.amP(RegByMobileRegAIOUI.this.countryCode);
                    String str2 = RegByMobileRegAIOUI.this.gFK + RegByMobileRegAIOUI.this.gDV;
                    RegByMobileRegAIOUI.this.aqX();
                    if (RegByMobileRegAIOUI.this.gFW) {
                        if (C5046bo.isNullOrNil(RegByMobileRegAIOUI.this.gBE)) {
                            RegByMobileRegAIOUI.this.gBE = C17950b.m28212m(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.countryCode, RegByMobileRegAIOUI.this.getString(C25738R.string.b3_));
                        }
                        C32921a.m53856b(RegByMobileRegAIOUI.this, RegByMobileRegAIOUI.this.getString(C25738R.string.g7o, new Object[]{C4988aa.dor(), RegByMobileRegAIOUI.this.gBE, "reg", Integer.valueOf(1), Integer.valueOf(0)}), 30847, false);
                        AppMethodBeat.m2505o(125338);
                    } else if (C5046bo.isNullOrNil(RegByMobileRegAIOUI.this.gFS)) {
                        RegByMobileRegAIOUI.m29490d(RegByMobileRegAIOUI.this, str2);
                        AppMethodBeat.m2505o(125338);
                    } else {
                        RegByMobileRegAIOUI.m29496j(RegByMobileRegAIOUI.this);
                        AppMethodBeat.m2505o(125338);
                    }
                }

                /* renamed from: JW */
                public final void mo11315JW() {
                    AppMethodBeat.m2504i(125339);
                    C30379h.m48467g(RegByMobileRegAIOUI.this, C25738R.string.e8m, C25738R.string.e8p);
                    AppMethodBeat.m2505o(125339);
                }

                /* renamed from: JX */
                public final void mo11316JX() {
                    AppMethodBeat.m2504i(125340);
                    C30379h.m48467g(RegByMobileRegAIOUI.this, C25738R.string.e8n, C25738R.string.e8p);
                    AppMethodBeat.m2505o(125340);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(125341);
                if (zArr[0]) {
                    zArr[0] = false;
                } else {
                    C6998b.oTO.mo8107fu("ce_reg", "<Reg>");
                    C6998b.oTO.mo8095a("ce_reg", MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, CdnLogic.kBizGeneric));
                    C6998b.oTO.mo8090TN("ce_reg");
                }
                C7357c hz = C7357c.m12555d(RegByMobileRegAIOUI.this.gFO.getContentEditText()).mo15880hz(1, 32);
                hz.zIx = true;
                hz.mo15879a(new C189071());
                AppMethodBeat.m2505o(125341);
            }
        });
        this.gDN.setEnabled(false);
        if (C5046bo.isNullOrNil(this.countryCode)) {
            this.fHE = getString(C25738R.string.b3b);
            this.countryCode = C5025av.amO(getString(C25738R.string.b3a));
        } else {
            this.fHE = C17950b.m28211l(this, this.countryCode, getString(C25738R.string.b3_));
        }
        if (!C5046bo.isNullOrNil(this.gFR)) {
            this.gFI.setText(this.gFR);
        }
        apc();
        arf();
        if (this.grJ == null || this.grJ.equals("")) {
            C1720g.m3539RS().mo10300a(new C99815());
        } else {
            this.gFH.setText(this.grJ);
        }
        this.grF.setOnClickListener(new C189216());
        setBackBtn(new C189187(), C1318a.actionbar_icon_close_black);
        this.ejo.setOnClickListener(new C189228());
        if (C5046bo.isNullOrNil(this.gFS)) {
            C1720g.m3539RS().mo10300a(new C189199());
        } else {
            this.gFO.setText(this.gFU);
            C1720g.m3539RS().mo10300a(new C1890810());
        }
        string = "";
        if (C7243d.vxr) {
            string = getString(C25738R.string.f9176ru) + getString(C25738R.string.f8807fk);
        }
        setMMTitle(string);
        mo17446xE(getResources().getColor(C25738R.color.f12206vy));
        dyb();
        if (C1443d.m3068iW(23)) {
            getWindow().setStatusBarColor(getResources().getColor(C25738R.color.f12200vs));
            dxW();
        }
        AppMethodBeat.m2505o(125378);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(125379);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            aoZ();
            AppMethodBeat.m2505o(125379);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(125379);
        return onKeyDown;
    }

    private void aoZ() {
        AppMethodBeat.m2504i(125380);
        C42756a.m75796wA(this.gsF);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",RE200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("RE200_100")).append(",2").toString());
        finish();
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
        AppMethodBeat.m2505o(125380);
    }

    private void aro() {
        AppMethodBeat.m2504i(125381);
        if (!C5046bo.isNullOrNil(this.gFS)) {
            if (this.guc != null) {
                this.guc.dismiss();
            }
            getString(C25738R.string.f9238tz);
            this.guc = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, null);
            C1720g.m3540Rg().mo14541a(new C18844g(this.gFS), 0);
        }
        AppMethodBeat.m2505o(125381);
    }

    /* renamed from: wv */
    private void m29510wv(String str) {
        AppMethodBeat.m2504i(125382);
        if (C32921a.m53854O(this, this.gFL.getText().toString())) {
            int i;
            if (this.guc != null) {
                this.guc.dismiss();
            }
            getString(C25738R.string.f9238tz);
            this.guc = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, null);
            String amN = C5025av.amN(this.gFH.getText().toString().trim());
            if (this.gDp != null && this.gDq != null && !amN.equals(this.gDp) && amN.equals(this.gDq)) {
                i = 1;
            } else if (this.gDp == null || this.gDq == null || this.gDq.equals(this.gDp) || amN.equals(this.gDq)) {
                i = 0;
            } else {
                i = 2;
            }
            C1207m c32815a = new C32815a(str, 12, "", 0, "");
            c32815a.mo53384lo(this.gDr);
            c32815a.mo53385lp(i);
            if (!C5046bo.isNullOrNil(this.gFT)) {
                ((C7244a) c32815a.ftU.acF()).vyq.vLG = this.gFT;
            }
            if (C6998b.oTO.mo8088TL("ie_reg")) {
                C6998b.oTO.mo8087TK("ie_reg");
            }
            bqw bqw = new bqw();
            bqw.jCH = this.gFO.getText().toString();
            if (!(!this.gFM || this.gFP == null || this.gFP.isRecycled())) {
                bqw.wGk = C4995ag.m7429w(C5056d.m7636ai(this.gFP));
            }
            bqw.wTk = str;
            bqw.wTj = C4995ag.m7428ck(this.gFL.getText().toString());
            bqw.luP = C5046bo.dpA();
            bqw.wTl = TimeZone.getDefault().getID();
            C4990ab.m7417i("MicroMsg.RegByMobileRegAIOUI", "%s,%s", bqw.luP, bqw.wTl);
            crs crs = new crs();
            crs.xpk = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.mo8089TM("ie_reg"));
            crs.xpl = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.mo8092TP("ce_reg"));
            crs.xpm = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.mo8082Am(6));
            try {
                crs.xpn = new SKBuiltinBuffer_t().setBuffer(bqw.toByteArray());
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.RegByMobileRegAIOUI", e, "convert to byte error ! %s", e.getMessage());
            }
            c32815a.mo53367a(crs);
            C1720g.m3540Rg().mo14541a(c32815a, 0);
            this.gDp = C5025av.amN(this.gFH.getText().toString().trim());
            this.gDr++;
            AppMethodBeat.m2505o(125382);
            return;
        }
        AppMethodBeat.m2505o(125382);
    }

    private void arf() {
        AppMethodBeat.m2504i(125383);
        if (C5046bo.isNullOrNil(this.fHE) || C5046bo.isNullOrNil(this.countryCode)) {
            this.grH.setText(getString(C25738R.string.d03));
            AppMethodBeat.m2505o(125383);
            return;
        }
        this.grH.setText(C5025av.m7485hS(this.fHE, this.countryCode));
        AppMethodBeat.m2505o(125383);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(125384);
        super.onActivityResult(i, i2, intent);
        if (i != 30846) {
            if (i != 30847) {
                switch (i2) {
                    case 100:
                        this.fHE = C5046bo.m7532bc(intent.getStringExtra("country_name"), "");
                        this.countryCode = C5046bo.m7532bc(intent.getStringExtra("couttry_code"), "");
                        this.gBE = C5046bo.m7532bc(intent.getStringExtra("iso_code"), "");
                        if (!C17950b.m28217sP(this.countryCode)) {
                            arf();
                            AppMethodBeat.m2505o(125384);
                            return;
                        } else if (C5046bo.isNullOrNil(this.gFS) || C5046bo.isNullOrNil(this.gFU) || C5046bo.isNullOrNil(this.gFV)) {
                            Intent intent2 = new Intent(this, MobileInputUI.class);
                            intent2.putExtra("mobile_input_purpose", 2);
                            intent2.putExtra("couttry_code", this.countryCode);
                            intent2.putExtra("country_name", this.fHE);
                            startActivity(intent2);
                            finish();
                            overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8293s);
                            AppMethodBeat.m2505o(125384);
                            return;
                        } else {
                            arf();
                            AppMethodBeat.m2505o(125384);
                            return;
                        }
                    default:
                        this.gFP = C24679a.gkF.mo38851a((Activity) this, i, i2, intent);
                        if (this.gFP != null) {
                            this.ejo.setImageBitmap(this.gFP);
                            this.gFM = true;
                            this.gFN.setVisibility(8);
                            break;
                        }
                        break;
                }
            }
            Bundle bundle = null;
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (bundle == null || !bundle.getString("go_next", "").equals("agree_privacy")) {
                C7060h.pYm.mo8378a(712, 1, 1, false);
                AppMethodBeat.m2505o(125384);
                return;
            }
            C7060h.pYm.mo8378a(712, 2, 1, false);
            this.gFW = false;
            if (C5046bo.isNullOrNil(this.gFS)) {
                m29510wv(this.gFK + this.gDV);
                AppMethodBeat.m2505o(125384);
                return;
            }
            aro();
            AppMethodBeat.m2505o(125384);
            return;
        } else if (i2 == -1 && arr()) {
            arp();
            C42756a.m75796wA("RE200_250");
            AppMethodBeat.m2505o(125384);
            return;
        }
        AppMethodBeat.m2505o(125384);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125385);
        C4990ab.m7416i("MicroMsg.RegByMobileRegAIOUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.guc != null) {
            this.guc.dismiss();
            this.guc = null;
        }
        if (i2 == -75) {
            C30379h.m48467g(this, C25738R.string.f8810fn, C25738R.string.djw);
            AppMethodBeat.m2505o(125385);
            return;
        }
        C42124a jY;
        String agi;
        String str2;
        if (c1207m.getType() == 145) {
            int Ah = ((C32815a) c1207m).mo53366Ah();
            if (Ah == 12) {
                if (i2 == -41 || i2 == -59) {
                    jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this, null, null);
                        AppMethodBeat.m2505o(125385);
                        return;
                    }
                    C30379h.m48467g(this, C25738R.string.dl6, C25738R.string.dl7);
                    AppMethodBeat.m2505o(125385);
                    return;
                }
                this.gDV = C5025av.amN(this.gDV);
                this.gDq = this.gFK + this.gDV;
                this.gDy = ((C32815a) c1207m).agt();
                if (i2 == -36 || i2 == -35 || i2 == -3) {
                    agi = ((C32815a) c1207m).agi();
                    if (!C5046bo.isNullOrNil(agi)) {
                        this.gDV = agi.trim();
                    }
                    C42756a.m75798wz("RE200_100");
                    StringBuilder stringBuilder = new StringBuilder();
                    C1720g.m3534RN();
                    stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",RE200_200,");
                    C1720g.m3534RN();
                    C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("RE200_200")).append(",1").toString());
                    jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(this, new C1890911(), new C1890313());
                        AppMethodBeat.m2505o(125385);
                        return;
                    }
                    arp();
                    C42756a.m75796wA("RE200_250");
                    AppMethodBeat.m2505o(125385);
                    return;
                } else if (i2 == -355) {
                    C42257z.m74635f(this, str, 30846);
                    this.gBm.daR = (long) this.gEu;
                    this.gBm.cVS = 5;
                    this.gBm.ajK();
                    AppMethodBeat.m2505o(125385);
                    return;
                } else if (i2 == -34) {
                    C30379h.m48461b((Context) this, getString(C25738R.string.a6k), "", true);
                    AppMethodBeat.m2505o(125385);
                    return;
                } else if (C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
                    AppMethodBeat.m2505o(125385);
                    return;
                } else {
                    Toast.makeText(this, getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
            if (Ah == 14) {
                if (i2 == 0 || str == null) {
                    if (((C32815a) c1207m).agj() == 1) {
                        str2 = this.gFK + this.gDV;
                        String agl = ((C32815a) c1207m).agl();
                        agi = ((C32815a) c1207m).agk();
                        Intent intent = new Intent(this, RegByMobileSendSmsUI.class);
                        intent.putExtra("regsession_id", this.gDy);
                        intent.putExtra("key_reg_style", 1);
                        intent.putExtra("from_mobile", str2);
                        intent.putExtra("to_mobile", agl);
                        intent.putExtra("verify_code", agi);
                        intent.putExtra("kintent_nickname", this.gFO.getText().toString());
                        intent.putExtra("kintent_password", this.gFL.getText().toString());
                        intent.putExtra("kintent_hasavatar", this.gFM);
                        intent.putExtra("reg_3d_app_type", this.gEu);
                        intent.putExtra("reg_3d_app_ticket", this.gFT);
                        startActivity(intent);
                    } else {
                        this.gFZ = ((C32815a) c1207m).agn();
                        this.gGa = ((C32815a) c1207m).ago();
                        this.gGb = ((C32815a) c1207m).agp();
                        this.gGc = ((C32815a) c1207m).agq();
                        arq();
                    }
                } else if (i2 == -41) {
                    C30379h.m48467g(this, C25738R.string.dl6, C25738R.string.dl7);
                    AppMethodBeat.m2505o(125385);
                    return;
                } else if (i2 == -34) {
                    C30379h.m48461b((Context) this, getString(C25738R.string.a6k), "", true);
                    AppMethodBeat.m2505o(125385);
                    return;
                } else if (C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
                    AppMethodBeat.m2505o(125385);
                    return;
                } else {
                    Toast.makeText(this, getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    AppMethodBeat.m2505o(125385);
                    return;
                }
            }
        } else if (c1207m.getType() == 755) {
            if (i == 0 && i2 == 0) {
                C18844g c18844g = (C18844g) c1207m;
                str2 = "";
                if (c18844g.ehh.fsH.fsP != null) {
                    agi = ((cgx) c18844g.ehh.fsH.fsP).wIg;
                } else {
                    agi = str2;
                }
                this.gFT = agi;
                m29510wv(this.gFK + this.gDV);
            } else if (i2 == -7) {
                this.gBm.daR = (long) this.gEu;
                this.gBm.cVS = 7;
                this.gBm.ajK();
                C30379h.m48445a((Context) this, getString(C25738R.string.bml), getString(C25738R.string.f9238tz), getString(C25738R.string.c9x), getString(C25738R.string.f9076or), true, new C997814(), null);
            }
        } else if ((c1207m.getType() == 701 || c1207m.getType() == 252) && i == 0 && i2 == 0) {
            this.gBm.daR = (long) this.gEu;
            this.gBm.cVS = 12;
            this.gBm.ajK();
            C38033l.apX();
            C42257z.m74637vx(C1853r.m3846Yz());
            C26529w.m42356cm(this);
            C42257z.showAddrBookUploadConfirm(this, new C1891015(), false, 2);
            AppMethodBeat.m2505o(125385);
            return;
        }
        if (C24679a.gkF.mo38859a((Context) this, i, i2, str)) {
            AppMethodBeat.m2505o(125385);
            return;
        }
        if (c1207m.getType() == 252 || c1207m.getType() == 701) {
            jY = C42124a.m74268jY(str);
            if (jY != null && jY.mo67668a(this, null, null)) {
                AppMethodBeat.m2505o(125385);
                return;
            }
        }
        AppMethodBeat.m2505o(125385);
    }

    private void arp() {
        AppMethodBeat.m2504i(125386);
        getString(C25738R.string.f9238tz);
        this.guc = C30379h.m48458b((Context) this, getString(C25738R.string.dku), true, new C1892017());
        C1207m c32815a = new C32815a(this.gFK + this.gDV, 14, "", 0, "");
        c32815a.mo53386rV(this.gDy);
        C1720g.m3540Rg().mo14541a(c32815a, 0);
        AppMethodBeat.m2505o(125386);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(125387);
        C6998b.oTO.mo8087TK("ie_reg");
        if (this.gFX != null) {
            this.gFX.dismiss();
        }
        this.gBm.ajK();
        super.onDestroy();
        AppMethodBeat.m2505o(125387);
    }

    private synchronized void arq() {
        AppMethodBeat.m2504i(125388);
        if (!this.gFY) {
            this.gFY = true;
            finish();
            Intent intent = new Intent();
            intent.putExtra("bindmcontact_mobile", this.gFK + " " + this.gFH.getText().toString());
            intent.putExtra("bindmcontact_shortmobile", this.gDV);
            intent.putExtra("country_name", this.fHE);
            intent.putExtra("couttry_code", this.countryCode);
            intent.putExtra("mobileverify_countdownsec", this.gFZ);
            intent.putExtra("mobileverify_countdownstyle", this.gGa);
            intent.putExtra("mobileverify_fb", this.gGb);
            intent.putExtra("mobileverify_reg_qq", this.gGc);
            intent.putExtra("kintent_nickname", this.gFO.getText().toString());
            intent.putExtra("kintent_password", this.gFL.getText().toString());
            intent.putExtra("kintent_hasavatar", this.gFM);
            intent.putExtra("key_reg_style", 1);
            intent.putExtra("regsession_id", this.gDy);
            intent.putExtra("reg_3d_app_ticket", this.gFT);
            intent.putExtra("reg_3d_app_type", this.gEu);
            intent.putExtra("mobile_verify_purpose", 2);
            mo17381a(MobileVerifyUI.class, intent);
        }
        AppMethodBeat.m2505o(125388);
    }

    private boolean arr() {
        int i;
        AppMethodBeat.m2504i(125389);
        if (C5046bo.isNullOrNil(this.countryCode)) {
            i = 0;
        } else {
            i = 1;
        }
        i &= m29484a(this.gFH.getText(), this.gFL.getText(), this.gFO.getText());
        if (i != 0) {
            this.gDN.setEnabled(true);
        } else {
            this.gDN.setEnabled(false);
        }
        AppMethodBeat.m2505o(125389);
        return i;
    }

    /* renamed from: a */
    private boolean m29484a(Editable... editableArr) {
        boolean z;
        AppMethodBeat.m2504i(125390);
        for (int i = 0; i < 3; i++) {
            Object obj = editableArr[i];
            if (obj == null || obj.toString().length() == 0) {
                z = false;
                break;
            }
        }
        z = true;
        if (z && this.gDT) {
            AppMethodBeat.m2505o(125390);
            return true;
        }
        AppMethodBeat.m2505o(125390);
        return false;
    }

    /* renamed from: u */
    static /* synthetic */ void m29507u(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        AppMethodBeat.m2504i(125397);
        regByMobileRegAIOUI.getString(C25738R.string.f9238tz);
        String string = regByMobileRegAIOUI.getString(C25738R.string.cou);
        final C1207m c6686q = new C6686q("facebook@wechat_auth", regByMobileRegAIOUI.gFS, 0, "", "", "", 0, "", true, false);
        regByMobileRegAIOUI.guc = C30379h.m48458b((Context) regByMobileRegAIOUI, string, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(125358);
                C1720g.m3540Rg().mo14547c(c6686q);
                AppMethodBeat.m2505o(125358);
            }
        });
        C1720g.m3540Rg().mo14541a(c6686q, 0);
        AppMethodBeat.m2505o(125397);
    }
}
