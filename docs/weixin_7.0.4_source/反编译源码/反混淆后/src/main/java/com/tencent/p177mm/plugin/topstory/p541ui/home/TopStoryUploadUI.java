package com.tencent.p177mm.plugin.topstory.p541ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p520ui.SnsEditText;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C29430g;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35892i;
import com.tencent.p177mm.protocal.protobuf.BaseResponse;
import com.tencent.p177mm.protocal.protobuf.C44172tj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI */
public class TopStoryUploadUI extends MMActivity implements C1202f {
    public static C25814c sCQ;
    private String appVersion;
    private String businessType;
    private String csB;
    private String desc;
    private String extInfo;
    private TextView nDX;
    private long rCN = 0;
    private String sCR;
    private String sCS;
    private ImageView sCT;
    private TextView sCU;
    private TextView sCV;
    private TextView sCW;
    private SnsEditText sCX;
    private TextView sCY;
    private boolean sCZ = false;
    private String thumbUrl;
    protected C44275p tipDialog = null;
    private String title;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI$3 */
    class C139483 implements TextWatcher {
        C139483() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(1682);
            TopStoryUploadUI.m86875b(TopStoryUploadUI.this);
            TopStoryUploadUI.m86876c(TopStoryUploadUI.this);
            AppMethodBeat.m2505o(1682);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI$5 */
    class C139495 implements OnClickListener {
        C139495() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(1684);
            TopStoryUploadUI.m86882i(TopStoryUploadUI.this);
            AppMethodBeat.m2505o(1684);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI$2 */
    class C294372 implements C9014g {
        C294372() {
        }

        /* renamed from: sH */
        public final void mo7596sH(String str) {
        }

        /* renamed from: a */
        public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
            AppMethodBeat.m2504i(1681);
            if (c37477b == null || c37477b.bitmap == null || c37477b.bitmap.isRecycled()) {
                C4990ab.m7420w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap bitmap is null");
                AppMethodBeat.m2505o(1681);
            } else if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7420w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap url is null");
                AppMethodBeat.m2505o(1681);
            } else if (view instanceof ImageView) {
                if (c37477b.bitmap.getWidth() < c37477b.bitmap.getHeight()) {
                    ((ImageView) view).setScaleType(ScaleType.FIT_CENTER);
                } else {
                    ((ImageView) view).setScaleType(ScaleType.CENTER_CROP);
                }
                AppMethodBeat.m2505o(1681);
            } else {
                C4990ab.m7420w("micromsg.topstory.TopStoryUploadUI", "onProcessBitmap view not ImageView");
                AppMethodBeat.m2505o(1681);
            }
            return null;
        }

        /* renamed from: b */
        public final void mo7595b(String str, View view, C37477b c37477b) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI$4 */
    class C352974 implements OnMenuItemClickListener {
        C352974() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(1683);
            if (TopStoryUploadUI.this.isFinishing()) {
                AppMethodBeat.m2505o(1683);
                return false;
            } else if (System.currentTimeMillis() - TopStoryUploadUI.this.rCN < 500) {
                AppMethodBeat.m2505o(1683);
                return false;
            } else {
                C7060h.pYm.mo8381e(17080, Integer.valueOf(4), Integer.valueOf(2), TopStoryUploadUI.this.csB);
                TopStoryUploadUI.this.rCN = System.currentTimeMillis();
                String obj = TopStoryUploadUI.this.sCX.getText().toString();
                if (obj.length() > 200) {
                    C30379h.m48461b(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(C25738R.string.eqg), "", true);
                    AppMethodBeat.m2505o(1683);
                    return true;
                } else if (TopStoryUploadUI.bBL()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String cFJ = TopStoryUploadUI.cFJ();
                    C40439f bT = C46494g.m87739bT(TopStoryUploadUI.this.csB, true);
                    TopStoryUploadUI.this.mo74463a(currentTimeMillis, TopStoryUploadUI.this.extInfo, obj, cFJ, bT, TopStoryUploadUI.this.appVersion);
                    AppMethodBeat.m2505o(1683);
                    return true;
                } else {
                    C30379h.m48461b(TopStoryUploadUI.this, TopStoryUploadUI.this.getString(C25738R.string.bx9), "", true);
                    C7053e.pXa.mo8378a(1032, 1, 1, false);
                    AppMethodBeat.m2505o(1683);
                    return true;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI$1 */
    class C399681 implements OnMenuItemClickListener {
        C399681() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(1680);
            TopStoryUploadUI.m86874a(TopStoryUploadUI.this);
            AppMethodBeat.m2505o(1680);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.home.TopStoryUploadUI$6 */
    class C462986 implements OnClickListener {
        C462986() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m86874a(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.m2504i(1695);
        topStoryUploadUI.exit();
        AppMethodBeat.m2505o(1695);
    }

    /* renamed from: b */
    static /* synthetic */ void m86875b(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.m2504i(1696);
        topStoryUploadUI.cFK();
        AppMethodBeat.m2505o(1696);
    }

    /* renamed from: i */
    static /* synthetic */ void m86882i(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.m2504i(1698);
        topStoryUploadUI.cFI();
        AppMethodBeat.m2505o(1698);
    }

    static {
        AppMethodBeat.m2504i(1699);
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a.ePG = true;
        c17927a.eQf = false;
        c17927a.ePT = C25738R.color.f12081rn;
        sCQ = c17927a.ahG();
        AppMethodBeat.m2505o(1699);
    }

    public final int getLayoutId() {
        return 2130970962;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(1685);
        C4990ab.m7416i("micromsg.topstory.TopStoryUploadUI", "onCreate");
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.gah);
        mo17379a(0, getString(C25738R.string.f9221tf), (OnMenuItemClickListener) new C352974(), C5535b.YELLOW);
        setBackBtn(new C399681());
        C1720g.m3540Rg().mo14539a(2534, (C1202f) this);
        this.businessType = getIntent().getStringExtra("KEY_BIZTYPE");
        this.csB = getIntent().getStringExtra("KEY_APPID");
        this.extInfo = getIntent().getStringExtra("KEY_EXTINFO");
        this.title = getIntent().getStringExtra("KEY_TITLE");
        this.desc = getIntent().getStringExtra("KEY_DESC");
        this.thumbUrl = getIntent().getStringExtra("KEY_THUMBURL");
        this.appVersion = getIntent().getStringExtra("KEY_APPVERSION");
        this.sCR = getIntent().getStringExtra("KEY_MEDIANAME");
        this.sCS = getIntent().getStringExtra("KEY_MEDIAHEADURL");
        this.sCT = (ImageView) findViewById(2131828344);
        this.sCU = (TextView) findViewById(2131828345);
        this.sCV = (TextView) findViewById(2131824506);
        this.sCX = (SnsEditText) findViewById(2131828264);
        this.sCY = (TextView) findViewById(2131828348);
        this.nDX = (TextView) findViewById(2131828347);
        this.sCW = (TextView) findViewById(2131828346);
        this.sCU.setText(this.title);
        this.sCV.setText(this.sCR);
        C32291o.ahp().mo43767a(this.thumbUrl, this.sCT, sCQ, new C294372());
        this.sCY.setText(String.format("<a href='%s'>%s</a>", new Object[]{"https://search.weixin.qq.com/cgi-bin/recweb/clientjump?tag=colikefirstsight#wechat_redirect", getString(C25738R.string.gaf)}));
        C44089j.m79307h(this.sCY, 1);
        cFK();
        this.sCX.addTextChangedListener(new C139483());
        C7060h.pYm.mo8381e(17080, Integer.valueOf(6), Integer.valueOf(1), this.csB);
        AppMethodBeat.m2505o(1685);
    }

    protected static boolean bBL() {
        AppMethodBeat.m2504i(1686);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            int acS = C1720g.m3540Rg().acS();
            if (acS == 4 || acS == 6) {
                AppMethodBeat.m2505o(1686);
                return true;
            }
            AppMethodBeat.m2505o(1686);
            return false;
        }
        Object obj;
        if (C5023at.isConnected(C4996ah.getContext())) {
            obj = 6;
        } else {
            obj = null;
        }
        if (obj == 6) {
            AppMethodBeat.m2505o(1686);
            return true;
        }
        AppMethodBeat.m2505o(1686);
        return false;
    }

    private void exit() {
        AppMethodBeat.m2504i(1687);
        C7060h.pYm.mo8381e(17080, Integer.valueOf(3), Integer.valueOf(2), this.csB);
        if (this.sCX.getText().toString().length() > 0) {
            C30379h.m48430a((Context) this, (int) C25738R.string.gad, 0, (int) C25738R.string.f9262up, (int) C25738R.string.f9183s2, true, new C139495(), new C462986(), (int) C25738R.color.f11795hi);
            AppMethodBeat.m2505o(1687);
            return;
        }
        cFI();
        AppMethodBeat.m2505o(1687);
    }

    private void cFI() {
        AppMethodBeat.m2504i(1688);
        C35892i.m58841c(this.businessType, "", this.csB, 0, "");
        finish();
        this.sCZ = true;
        AppMethodBeat.m2505o(1688);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(1689);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        boolean z = i == 0 && i2 == 0;
        if (z) {
            if (c1207m instanceof C29430g) {
                BaseResponse baseResponse = ((C44172tj) ((C29430g) c1207m).ehh.fsH.fsP).BaseResponse;
                if (baseResponse.Ret == 0) {
                    cFI();
                    AppMethodBeat.m2505o(1689);
                    return;
                } else if (baseResponse.ErrMsg == null || C5046bo.isNullOrNil(baseResponse.ErrMsg.wVI)) {
                    C30379h.m48461b((Context) this, getString(C25738R.string.gag), getString(C25738R.string.gae), true);
                } else {
                    C30379h.m48461b((Context) this, baseResponse.ErrMsg.wVI, getString(C25738R.string.gae), true);
                }
            }
        } else if (C5046bo.isNullOrNil(str)) {
            C30379h.m48461b((Context) this, getString(C25738R.string.ex8), getString(C25738R.string.gae), true);
        } else {
            C30379h.m48461b((Context) this, str, getString(C25738R.string.gae), true);
        }
        C7053e.pXa.mo8378a(1032, 2, 1, false);
        AppMethodBeat.m2505o(1689);
    }

    public static String cFJ() {
        AppMethodBeat.m2504i(1690);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        String stringBuilder2 = stringBuilder.append(C1183p.getString(C1668a.m3383QF())).append("_").append(System.currentTimeMillis()).toString();
        AppMethodBeat.m2505o(1690);
        return stringBuilder2;
    }

    /* renamed from: a */
    public final int mo74463a(long j, String str, String str2, String str3, C40439f c40439f, String str4) {
        AppMethodBeat.m2504i(1691);
        C1720g.m3540Rg().mo14541a(new C29430g(j, str, str2, str3, c40439f, str4), 0);
        getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.gai), false, null);
        AppMethodBeat.m2505o(1691);
        return 0;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(1692);
        C4990ab.m7416i("micromsg.topstory.TopStoryUploadUI", "onDestroy");
        super.onDestroy();
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        C1720g.m3540Rg().mo14546b(2534, (C1202f) this);
        if (!this.sCZ) {
            C7060h.pYm.mo8381e(17080, Integer.valueOf(3), Integer.valueOf(2), this.csB);
        }
        AppMethodBeat.m2505o(1692);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.m2504i(1693);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            exit();
            AppMethodBeat.m2505o(1693);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.m2505o(1693);
        return dispatchKeyEvent;
    }

    private void cFK() {
        AppMethodBeat.m2504i(1694);
        int length = this.sCX.getText().toString().length();
        if (length < 180) {
            this.nDX.setVisibility(8);
            this.sCW.setVisibility(8);
            AppMethodBeat.m2505o(1694);
            return;
        }
        int color;
        this.nDX.setVisibility(0);
        this.sCW.setVisibility(0);
        if (length <= 200) {
            color = getResources().getColor(C25738R.color.a3k);
        } else {
            color = getResources().getColor(C25738R.color.f12266xy);
        }
        this.nDX.setText(String.valueOf(length));
        this.nDX.setTextColor(color);
        AppMethodBeat.m2505o(1694);
    }

    /* renamed from: c */
    static /* synthetic */ void m86876c(TopStoryUploadUI topStoryUploadUI) {
        AppMethodBeat.m2504i(1697);
        if (topStoryUploadUI.sCX.getText().toString().length() <= 200) {
            topStoryUploadUI.enableOptionMenu(0, true);
            AppMethodBeat.m2505o(1697);
            return;
        }
        topStoryUploadUI.enableOptionMenu(0, false);
        AppMethodBeat.m2505o(1697);
    }
}
