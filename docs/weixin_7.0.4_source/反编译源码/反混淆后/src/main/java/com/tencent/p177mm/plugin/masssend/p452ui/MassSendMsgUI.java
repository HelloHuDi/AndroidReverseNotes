package com.tencent.p177mm.plugin.masssend.p452ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelvideo.C1878c;
import com.tencent.p177mm.modelvideo.C1878c.C1877a;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.masssend.C12490a;
import com.tencent.p177mm.plugin.masssend.p992a.C12488f;
import com.tencent.p177mm.plugin.masssend.p992a.C21270h;
import com.tencent.p177mm.plugin.masssend.p992a.C39356a;
import com.tencent.p177mm.plugin.masssend.p992a.C46069b;
import com.tencent.p177mm.plugin.mmsight.SightCaptureResult;
import com.tencent.p177mm.plugin.mmsight.model.C28508d;
import com.tencent.p177mm.plugin.mmsight.model.C3483l;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C29014b;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.pluginsdk.C23255n;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.p597ui.chat.AppPanel.C14934a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.baa;
import com.tencent.p177mm.protocal.protobuf.baq;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.baseutils.FileUtils;
import java.util.ArrayList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI */
public class MassSendMsgUI extends MMActivity implements C1202f {
    private static String opb = "";
    private String filePath;
    private TextView nDX;
    private ChatFooter oor;
    private String oou;
    private List<String> oov;
    private boolean oow = false;
    private TextView opa;
    private C5653c opc;
    private C28482b opd;
    private C14934a ope = new C125109();
    private C44275p tipDialog = null;

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$3 */
    class C124923 implements OnClickListener {
        C124923() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$5 */
    class C124935 implements C1877a {
        C124935() {
        }

        /* renamed from: b */
        public final void mo5453b(int i, final String str, final String str2, final int i2) {
            AppMethodBeat.m2504i(22829);
            C4990ab.m7411d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", Integer.valueOf(i), str, str2);
            if (i >= 0 || i == -50002) {
                C7305d.post(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$5$1$2 */
                    class C124952 implements Runnable {
                        C124952() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(22827);
                            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.f16), 0).show();
                            if (MassSendMsgUI.this.tipDialog != null) {
                                MassSendMsgUI.this.tipDialog.dismiss();
                                MassSendMsgUI.this.tipDialog = null;
                            }
                            AppMethodBeat.m2505o(22827);
                        }
                    }

                    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$5$1$1 */
                    class C124961 implements Runnable {
                        C124961() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(22826);
                            MassSendMsgUI.m20407a(MassSendMsgUI.this, str, i2);
                            AppMethodBeat.m2505o(22826);
                        }
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(22828);
                        if (MassSendMsgUI.m20408a(MassSendMsgUI.this, str, str2)) {
                            C5004al.m7441d(new C124961());
                            AppMethodBeat.m2505o(22828);
                            return;
                        }
                        C5004al.m7441d(new C124952());
                        AppMethodBeat.m2505o(22828);
                    }
                }, "MassSend_Remux");
            } else {
                Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.f15), 0).show();
                if (MassSendMsgUI.this.tipDialog != null) {
                    MassSendMsgUI.this.tipDialog.dismiss();
                    MassSendMsgUI.this.tipDialog = null;
                    AppMethodBeat.m2505o(22829);
                    return;
                }
            }
            AppMethodBeat.m2505o(22829);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$7 */
    class C125027 implements OnClickListener {
        C125027() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22831);
            MassSendMsgUI.this.finish();
            AppMethodBeat.m2505o(22831);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$8 */
    class C125038 implements TextWatcher {
        C125038() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(22833);
            String valueOf = String.valueOf(charSequence);
            final String substring = valueOf.substring(i, i + i3);
            if ((MassSendMsgUI.this.opc == null || !MassSendMsgUI.this.opc.isShowing()) && C5063r.amn(substring)) {
                Bitmap d = C5056d.m7659d(substring, 300, 300, false);
                if (d == null) {
                    C4990ab.m7412e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
                    AppMethodBeat.m2505o(22833);
                    return;
                }
                View imageView = new ImageView(MassSendMsgUI.this);
                imageView.setImageBitmap(d);
                int dimensionPixelSize = MassSendMsgUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
                imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                MassSendMsgUI.this.opc = C30379h.m48437a(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.aoh), imageView, MassSendMsgUI.this.getString(C25738R.string.f9187s6), MassSendMsgUI.this.getString(C25738R.string.f9076or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(22832);
                        Intent intent = new Intent();
                        intent.putExtra("CropImage_OutputPath", substring);
                        MassSendMsgUI.m20406a(MassSendMsgUI.this, intent);
                        AppMethodBeat.m2505o(22832);
                    }
                }, null);
                String str = valueOf.substring(0, i) + valueOf.substring(i + i3);
                MassSendMsgUI.this.oor.mo63996u(str, -1, false);
                MassSendMsgUI.opb = str;
            }
            AppMethodBeat.m2505o(22833);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$1 */
    class C125091 implements OnMenuItemClickListener {
        C125091() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22824);
            MassSendMsgUI.this.finish();
            AppMethodBeat.m2505o(22824);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$9 */
    class C125109 implements C14934a {
        C125109() {
        }

        public final void bNO() {
            AppMethodBeat.m2504i(22834);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.cz8), 0).show();
            AppMethodBeat.m2505o(22834);
        }

        public final void bNP() {
            AppMethodBeat.m2504i(22835);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.cyq), 0).show();
            AppMethodBeat.m2505o(22835);
        }

        public final void bNQ() {
            AppMethodBeat.m2504i(22836);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.cz6), 0).show();
            AppMethodBeat.m2505o(22836);
        }

        public final void bNR() {
            AppMethodBeat.m2504i(22837);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.cyz), 0).show();
            AppMethodBeat.m2505o(22837);
        }

        public final void bNS() {
            AppMethodBeat.m2504i(22838);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.cyq), 0).show();
            AppMethodBeat.m2505o(22838);
        }

        /* renamed from: ys */
        public final void mo24428ys(int i) {
            AppMethodBeat.m2504i(22839);
            switch (i) {
                case 0:
                    C5728b c5728b = new C5728b(C6457e.euR);
                    if (c5728b.exists() || c5728b.mkdirs()) {
                        C4990ab.m7417i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(MassSendMsgUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")), C5046bo.dpG(), MassSendMsgUI.this.mController.ylL);
                        if (C35805b.m58707a(MassSendMsgUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                            MassSendMsgUI.m20415c(MassSendMsgUI.this);
                            break;
                        } else {
                            AppMethodBeat.m2505o(22839);
                            return;
                        }
                    }
                    Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.aor), 1).show();
                    AppMethodBeat.m2505o(22839);
                    return;
                    break;
                case 1:
                    C14987n.m23295a(MassSendMsgUI.this, 1, 1, 0, 3, null);
                    AppMethodBeat.m2505o(22839);
                    return;
            }
            AppMethodBeat.m2505o(22839);
        }

        /* renamed from: b */
        public final void mo24413b(C40439f c40439f) {
        }

        public final void bNT() {
            AppMethodBeat.m2504i(22840);
            C12490a.gkE.mo38911bj(MassSendMsgUI.this);
            AppMethodBeat.m2505o(22840);
        }

        public final void bNU() {
            AppMethodBeat.m2504i(22841);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.cyq), 0).show();
            AppMethodBeat.m2505o(22841);
        }

        public final void bNV() {
        }

        public final void bNW() {
            AppMethodBeat.m2504i(22842);
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            C25985d.m41467b(MassSendMsgUI.this, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            AppMethodBeat.m2505o(22842);
        }

        /* renamed from: yt */
        public final void mo24429yt(int i) {
            AppMethodBeat.m2504i(22843);
            MassSendMsgUI.m20416d(MassSendMsgUI.this);
            AppMethodBeat.m2505o(22843);
        }

        public final void bNX() {
            AppMethodBeat.m2504i(22844);
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(C25738R.string.cz0), 0).show();
            AppMethodBeat.m2505o(22844);
        }

        public final void bNY() {
        }

        public final void bNZ() {
        }

        public final void bOa() {
        }

        public final void bOb() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$10 */
    class C1251110 implements OnClickListener {
        C1251110() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22845);
            MassSendMsgUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(22845);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MassSendMsgUI() {
        AppMethodBeat.m2504i(22851);
        AppMethodBeat.m2505o(22851);
    }

    /* renamed from: b */
    static /* synthetic */ void m20414b(MassSendMsgUI massSendMsgUI, Intent intent) {
        AppMethodBeat.m2504i(22872);
        massSendMsgUI.m20412aj(intent);
        AppMethodBeat.m2505o(22872);
    }

    /* renamed from: c */
    static /* synthetic */ void m20415c(MassSendMsgUI massSendMsgUI) {
        AppMethodBeat.m2504i(22869);
        massSendMsgUI.bCz();
        AppMethodBeat.m2505o(22869);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22852);
        super.onCreate(bundle);
        C9638aw.m17182Rg().mo14539a((int) JsApiChooseMedia.CTRL_INDEX, (C1202f) this);
        this.oow = getIntent().getBooleanExtra("mass_send_again", false);
        this.oou = getIntent().getStringExtra("mass_send_contact_list");
        String str = this.oou;
        this.oov = new ArrayList();
        if (!(str == null || str.equals(""))) {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                this.oov = C5046bo.m7508P(split);
            }
        }
        initView();
        AppMethodBeat.m2505o(22852);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22853);
        super.onResume();
        if (this.oor != null) {
            this.oor.setLastText(opb);
            this.oor.mo63903a(this.mController.ylL, (Activity) this);
        }
        AppMethodBeat.m2505o(22853);
    }

    /* renamed from: Qy */
    public static void m20402Qy(String str) {
        opb = str;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22854);
        C9638aw.m17182Rg().mo14546b((int) JsApiChooseMedia.CTRL_INDEX, (C1202f) this);
        super.onDestroy();
        if (this.oor != null) {
            this.oor.destroy();
        }
        AppMethodBeat.m2505o(22854);
    }

    public void onPause() {
        AppMethodBeat.m2504i(22855);
        this.oor.bvH();
        this.oor.onPause();
        super.onPause();
        AppMethodBeat.m2505o(22855);
    }

    public final int getLayoutId() {
        return 2130970076;
    }

    public final void initView() {
        CharSequence spannableString;
        boolean z = true;
        AppMethodBeat.m2504i(22856);
        setMMTitle((int) C25738R.string.cz1);
        this.opa = (TextView) findViewById(2131825937);
        this.nDX = (TextView) findViewById(2131825936);
        TextView textView = this.opa;
        int textSize = (int) this.opa.getTextSize();
        if (this.oov == null) {
            spannableString = new SpannableString("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.oov.size(); i++) {
                String mJ = C1854s.m3866mJ((String) this.oov.get(i));
                if (i == this.oov.size() - 1) {
                    stringBuilder.append(mJ);
                } else {
                    stringBuilder.append(mJ + ",  ");
                }
            }
            spannableString = C44089j.m79294b((Context) this, stringBuilder.toString(), textSize);
        }
        textView.setText(spannableString);
        this.nDX.setText(getResources().getQuantityString(C25738R.plurals.f9606s, this.oov.size(), new Object[]{Integer.valueOf(this.oov.size())}));
        this.oor = (ChatFooter) findViewById(2131822391);
        ((MassSendLayout) findViewById(2131825935)).setPanel(this.oor.getPanel());
        this.oor.setCattingRootLayoutId(2131825935);
        this.opd = new C28482b(this, this.oor, this.oou, this.oov, this.oow);
        this.oor.setFooterEventListener(this.opd);
        this.oor.setSmileyPanelCallback(new C43297d(this));
        ChatFooter chatFooter = this.oor;
        C9638aw.m17190ZK();
        int intValue = ((Integer) C18628c.m29072Ry().get(18, Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            intValue = 1;
        }
        chatFooter.setMode(intValue);
        this.oor.setUserName("masssendapp");
        this.oor.vmM.refresh();
        C9638aw.m17190ZK();
        if (((Boolean) C18628c.m29072Ry().get(66832, Boolean.FALSE)).booleanValue()) {
            this.oor.dkt();
            this.oor.dkd();
        }
        this.oor.addTextChangedListener(new C125038());
        this.oor.vmM.djN();
        this.oor.vmM.djK();
        this.oor.vmM.djM();
        this.oor.mo63904ac(true, true);
        this.oor.vmM.djL();
        this.oor.mo63955oH(true);
        this.oor.setAppPanelListener(this.ope);
        ChatFooter chatFooter2 = this.oor;
        C25985d.dlL();
        if (!C17950b.ahK()) {
            z = false;
        }
        chatFooter2.mo63956oI(z);
        this.oor.vmM.djO();
        this.oor.vmM.djP();
        setBackBtn(new C125091());
        AppMethodBeat.m2505o(22856);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(22857);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0 && this.oor.dky()) {
            this.oor.setBottomPanelVisibility(8);
            AppMethodBeat.m2505o(22857);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(22857);
        return onKeyDown;
    }

    private void bCz() {
        AppMethodBeat.m2504i(22858);
        if (!C14987n.m23311c(this, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 2)) {
            Toast.makeText(this, getString(C25738R.string.e29), 1).show();
        }
        AppMethodBeat.m2505o(22858);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(22859);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(22859);
            return;
        }
        C4990ab.m7417i("MicroMsg.MassSendMsgUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C1251110(), null);
                    break;
                }
                bCz();
                AppMethodBeat.m2505o(22859);
                return;
        }
        AppMethodBeat.m2505o(22859);
    }

    /* renamed from: ag */
    private void m20409ag(Intent intent) {
        AppMethodBeat.m2504i(22860);
        String stringExtra = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        C39356a c39356a = new C39356a();
        c39356a.onZ = this.oou;
        c39356a.ooa = this.oov.size();
        c39356a.filename = stringExtra;
        c39356a.oob = intExtra;
        c39356a.msgType = 43;
        final C1207m c12488f = new C12488f(c39356a, this.oow);
        C9638aw.m17182Rg().mo14541a(c12488f, 0);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b(context, getString(C25738R.string.e3p), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(22846);
                C9638aw.m17182Rg().mo14547c(c12488f);
                AppMethodBeat.m2505o(22846);
            }
        });
        AppMethodBeat.m2505o(22860);
    }

    /* renamed from: ah */
    private void m20410ah(Intent intent) {
        AppMethodBeat.m2504i(22861);
        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
        if (stringExtra == null) {
            AppMethodBeat.m2505o(22861);
            return;
        }
        int i;
        if (C1853r.m3854g(stringExtra, null, intent.getBooleanExtra("CropImage_Compress_Img", true))) {
            i = 1;
        } else {
            i = 0;
        }
        C21270h.bNE();
        C39356a i2 = C46069b.m85834i(stringExtra, this.oou, this.oov.size(), i);
        if (i2 == null) {
            AppMethodBeat.m2505o(22861);
            return;
        }
        final C1207m c12488f = new C12488f(i2, this.oow, i);
        C9638aw.m17182Rg().mo14541a(c12488f, 0);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b(context, getString(C25738R.string.e3p), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(22847);
                C9638aw.m17182Rg().mo14547c(c12488f);
                AppMethodBeat.m2505o(22847);
            }
        });
        AppMethodBeat.m2505o(22861);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(22862);
        C4990ab.m7416i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(22862);
            return;
        }
        String stringExtra;
        Context applicationContext;
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.m2505o(22862);
                    return;
                } else if (intent.getBooleanExtra("is_video", false)) {
                    stringExtra = intent.getStringExtra("video_full_path");
                    Intent intent2 = new Intent();
                    intent2.setData(Uri.parse("file://".concat(String.valueOf(stringExtra))));
                    m20411ai(intent2);
                    AppMethodBeat.m2505o(22862);
                    return;
                } else {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 4);
                    intent3.putExtra("CropImage_Filter", true);
                    C23255n c23255n = C12490a.gkE;
                    C9638aw.m17190ZK();
                    c23255n.mo38891a((Activity) this, intent, intent3, C18628c.m29088XW(), 4, null);
                    AppMethodBeat.m2505o(22862);
                    return;
                }
            case 2:
                applicationContext = getApplicationContext();
                C9638aw.m17190ZK();
                this.filePath = C14987n.m23320h(applicationContext, intent, C18628c.m29088XW());
                if (this.filePath == null) {
                    AppMethodBeat.m2505o(22862);
                    return;
                }
                Intent intent4 = new Intent();
                intent4.putExtra("CropImageMode", 4);
                intent4.putExtra("CropImage_Filter", true);
                intent4.putExtra("CropImage_ImgPath", this.filePath);
                C12490a.gkE.mo38890a(this.mController.ylL, intent4, 4);
                AppMethodBeat.m2505o(22862);
                return;
            case 4:
                m20410ah(intent);
                AppMethodBeat.m2505o(22862);
                return;
            case 5:
                m20409ag(intent);
                AppMethodBeat.m2505o(22862);
                return;
            case 6:
                m20411ai(intent);
                AppMethodBeat.m2505o(22862);
                return;
            case 7:
                if (intent == null) {
                    AppMethodBeat.m2505o(22862);
                    return;
                } else if (intent.getBooleanExtra("from_record", false)) {
                    m20409ag(intent);
                    AppMethodBeat.m2505o(22862);
                    return;
                } else {
                    m20411ai(intent);
                    AppMethodBeat.m2505o(22862);
                    return;
                }
            case 8:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    if (sightCaptureResult.osA) {
                        stringExtra = sightCaptureResult.osI;
                        if (!C5046bo.isNullOrNil(stringExtra)) {
                            try {
                                C4990ab.m7417i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", stringExtra);
                                C21270h.bNE();
                                C39356a i3 = C46069b.m85834i(stringExtra, this.oou, this.oov.size(), 0);
                                if (i3 == null) {
                                    AppMethodBeat.m2505o(22862);
                                    return;
                                }
                                final C1207m c12488f = new C12488f(i3, this.oow, 0);
                                C9638aw.m17182Rg().mo14541a(c12488f, 0);
                                applicationContext = this.mController.ylL;
                                getString(C25738R.string.f9238tz);
                                this.tipDialog = C30379h.m48458b(applicationContext, getString(C25738R.string.e3p), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.m2504i(22848);
                                        C9638aw.m17182Rg().mo14547c(c12488f);
                                        AppMethodBeat.m2505o(22848);
                                    }
                                });
                                AppMethodBeat.m2505o(22862);
                                return;
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", e.getMessage());
                            }
                        }
                        AppMethodBeat.m2505o(22862);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", sightCaptureResult.osC, sightCaptureResult.osD);
                    C37961o.all();
                    String uh = C9720t.m17303uh(sightCaptureResult.osE);
                    if (!sightCaptureResult.osC.equals(uh)) {
                        C4990ab.m7417i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", sightCaptureResult.osC, uh);
                        C5730e.m8623aQ(sightCaptureResult.osC, uh);
                    }
                    uh = sightCaptureResult.osE;
                    final int i4 = sightCaptureResult.osG;
                    final C1878c c1878c = new C1878c();
                    getString(C25738R.string.f9238tz);
                    this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            c1878c.fUF = null;
                        }
                    });
                    C7305d.post(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$15$3 */
                        class C125063 implements Runnable {
                            C125063() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(22849);
                                MassSendMsgUI.m20407a(MassSendMsgUI.this, uh, i4);
                                AppMethodBeat.m2505o(22849);
                            }
                        }

                        /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$15$2 */
                        class C125072 implements C28508d {
                            C125072() {
                            }

                            public final boolean bOc() {
                                return false;
                            }
                        }

                        /* renamed from: com.tencent.mm.plugin.masssend.ui.MassSendMsgUI$15$1 */
                        class C125081 implements C28508d {
                            C125081() {
                            }

                            public final boolean bOc() {
                                return false;
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(22850);
                            VideoTransPara afG = C42204d.afF().afG();
                            baa baa = new baa();
                            baa.wDP = true;
                            if (C3483l.m5789a(uh, afG, baa, new C125081())) {
                                C3483l.m5790b(uh, afG, baa, new C125072());
                            }
                            C5004al.m7441d(new C125063());
                            AppMethodBeat.m2505o(22850);
                        }
                    }, "MassSend_Remux");
                }
                AppMethodBeat.m2505o(22862);
                return;
            default:
                C4990ab.m7412e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
                AppMethodBeat.m2505o(22862);
                return;
        }
    }

    /* renamed from: ai */
    private void m20411ai(final Intent intent) {
        AppMethodBeat.m2504i(22863);
        if (C32856ab.m53750ch(this)) {
            m20412aj(intent);
            AppMethodBeat.m2505o(22863);
            return;
        }
        C30379h.m48432a((Context) this, (int) C25738R.string.f17, (int) C25738R.string.f9238tz, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(22825);
                MassSendMsgUI.m20414b(MassSendMsgUI.this, intent);
                AppMethodBeat.m2505o(22825);
            }
        }, new C124923());
        AppMethodBeat.m2505o(22863);
    }

    /* renamed from: aj */
    private void m20412aj(Intent intent) {
        AppMethodBeat.m2504i(22864);
        final C1878c c1878c = new C1878c();
        getString(C25738R.string.f9238tz);
        this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                c1878c.fUF = null;
            }
        });
        c1878c.mo5454a(this, intent, new C124935());
        AppMethodBeat.m2505o(22864);
    }

    /* renamed from: eY */
    private boolean m20418eY(String str, String str2) {
        double d;
        AppMethodBeat.m2504i(22865);
        boolean is2G = C5023at.is2G(this);
        int i = is2G ? 10485760 : 26214400;
        if (is2G) {
            d = 60000.0d;
        } else {
            d = 300000.0d;
        }
        C4990ab.m7417i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", Integer.valueOf(SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, 1000000)));
        switch (SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, 1000000)) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                AppMethodBeat.m2505o(22865);
                return false;
            case 0:
                int i2;
                int i3;
                C37961o.all();
                String uh = C9720t.m17303uh(str);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str2);
                C4990ab.m7417i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", uh);
                int i4 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i5 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                VideoTransPara videoTransPara = new VideoTransPara();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                C21846d.m33389a(str2, pInt, pInt2, pInt3, pInt4, pInt5);
                videoTransPara.duration = pInt.value / 1000;
                videoTransPara.width = pInt2.value;
                videoTransPara.height = pInt3.value;
                videoTransPara.fps = pInt4.value;
                videoTransPara.videoBitrate = pInt5.value;
                VideoTransPara b = C42204d.afF().mo67741b(videoTransPara);
                int i6 = C29014b.qwZ;
                C4990ab.m7411d("MicroMsg.MassSendMsgUI", "check remuxing old para %s, newPara: %s", videoTransPara, b);
                if (b == null) {
                    i2 = 0;
                    i = i5;
                    int i7 = i4;
                    while (i2 < 3) {
                        if (i7 % 2 != 0) {
                            i7--;
                        }
                        if (i % 2 != 0) {
                            i--;
                        }
                        if ((i7 < i || (i7 > 640 && i > 480)) && (i7 > i || (i7 > 480 && i > 640))) {
                            i7 /= 2;
                            i /= 2;
                            i2++;
                        } else {
                            i3 = i7;
                        }
                    }
                    i = i5;
                    i3 = i4;
                } else {
                    i3 = b.width;
                    i = b.height;
                    i6 = b.videoBitrate;
                }
                mediaMetadataRetriever.release();
                if (SightVideoJNI.remuxing(str2, uh, i3, i, i6, C29014b.qwY, 8, 2, 25.0f, C29014b.qxa, null, 0, false) < 0) {
                    C4990ab.m7420w("MicroMsg.MassSendMsgUI", "remuxing video error");
                    AppMethodBeat.m2505o(22865);
                    return false;
                }
                MassSendMsgUI.m20403Qz(uh);
                C37961o.all();
                String ui = C9720t.m17304ui(str);
                if (!C5730e.m8628ct(ui)) {
                    C4990ab.m7417i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", ui);
                    try {
                        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(uh, 1);
                        if (createVideoThumbnail != null) {
                            C5056d.m7625a(createVideoThumbnail, 60, CompressFormat.JPEG, ui, true);
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.MassSendMsgUI", e, "", new Object[0]);
                        C4990ab.m7413e("MicroMsg.MassSendMsgUI", "create thumb error: %s", e.getMessage());
                    }
                }
                C4990ab.m7417i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", uh, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
                AppMethodBeat.m2505o(22865);
                return true;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                C37961o.all();
                MassSendMsgUI.m20403Qz(C9720t.m17303uh(str));
                AppMethodBeat.m2505o(22865);
                return true;
            default:
                AppMethodBeat.m2505o(22865);
                return false;
        }
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22866);
        C4990ab.m7416i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.opd != null) {
            C28482b c28482b = this.opd;
            if (c28482b.tipDialog != null) {
                c28482b.tipDialog.dismiss();
                c28482b.tipDialog = null;
            }
        }
        if (i == 0 && i2 == 0) {
            opb = "";
            Intent intent = new Intent(this, MassSendHistoryUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
            AppMethodBeat.m2505o(22866);
        } else if (i == 4 && i2 == -24) {
            C4990ab.m7412e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
            Toast.makeText(this, C25738R.string.cyw, 0).show();
            AppMethodBeat.m2505o(22866);
        } else {
            if (i == 2 || i == 1 || i == 3) {
                this.oor.setLastText(opb);
            }
            C12490a.gkF.mo38859a(this.mController.ylL, i, i2, str);
            switch (i2) {
                case -71:
                    C30379h.m48438a((Context) this, getString(C25738R.string.cz7, new Object[]{Integer.valueOf(((baq) ((C12488f) c1207m).ehh.fsH.fsP).wEC)}), getString(C25738R.string.f9238tz), new C125027());
                    AppMethodBeat.m2505o(22866);
                    return;
                case -34:
                    Toast.makeText(this, C25738R.string.cyv, 0).show();
                    AppMethodBeat.m2505o(22866);
                    return;
                default:
                    Toast.makeText(this, C25738R.string.e3n, 0).show();
                    AppMethodBeat.m2505o(22866);
                    return;
            }
        }
    }

    /* renamed from: Qz */
    private static void m20403Qz(String str) {
        AppMethodBeat.m2504i(22867);
        long asZ = C5730e.asZ(str);
        int h = C5046bo.m7567h((Integer) C7060h.m11789a((int) (asZ / 1024), new int[]{512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, Utility.DEFAULT_STREAM_BUFFER_SIZE, 10240, 15360, 20480}, 247, 255));
        C7060h.pYm.mo8378a(106, (long) h, 1, false);
        C7060h.pYm.mo8378a(106, 246, 1, false);
        C4990ab.m7410d("MicroMsg.MassSendMsgUI", "report video size res : " + h + " hadCompress : true fileLen : " + (asZ / 1024) + "K");
        AppMethodBeat.m2505o(22867);
    }

    /* renamed from: d */
    static /* synthetic */ void m20416d(MassSendMsgUI massSendMsgUI) {
        AppMethodBeat.m2504i(22870);
        C4990ab.m7417i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")), C5046bo.dpG(), massSendMsgUI);
        if (C35805b.m58707a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")) {
            C4990ab.m7417i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")), C5046bo.dpG(), massSendMsgUI);
            if (C35805b.m58707a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")) {
                C7060h.pYm.mo8381e(13822, Integer.valueOf(1), Integer.valueOf(1));
                C14987n.m23316e(massSendMsgUI, new Intent(), massSendMsgUI.oou);
            }
        }
        AppMethodBeat.m2505o(22870);
    }
}
