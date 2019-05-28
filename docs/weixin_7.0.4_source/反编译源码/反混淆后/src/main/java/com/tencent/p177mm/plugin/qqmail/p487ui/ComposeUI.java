package com.tencent.p177mm.plugin.qqmail.p487ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.tools.C36338a;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.qqmail.p486b.C12879aa;
import com.tencent.p177mm.plugin.qqmail.p486b.C12884ac;
import com.tencent.p177mm.plugin.qqmail.p486b.C12892z;
import com.tencent.p177mm.plugin.qqmail.p486b.C21519i;
import com.tencent.p177mm.plugin.qqmail.p486b.C21520j;
import com.tencent.p177mm.plugin.qqmail.p486b.C28730ab;
import com.tencent.p177mm.plugin.qqmail.p486b.C28741k;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C21523a;
import com.tencent.p177mm.plugin.qqmail.p486b.C39540v.C28746c;
import com.tencent.p177mm.plugin.qqmail.p486b.C43404o;
import com.tencent.p177mm.plugin.qqmail.p486b.C46149p;
import com.tencent.p177mm.plugin.qqmail.p486b.C46149p.C43405a;
import com.tencent.p177mm.plugin.qqmail.p487ui.C12925c.C12927a;
import com.tencent.p177mm.plugin.qqmail.p487ui.C7027b.C7034b;
import com.tencent.p177mm.plugin.qqmail.p487ui.MailAddrsViewControl.C12919a;
import com.tencent.p177mm.plugin.qqmail.p487ui.MailAddrsViewControl.C3661b;
import com.tencent.p177mm.plugin.qqmail.p487ui.MailAddrsViewControl.C3664c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.pluginsdk.p597ui.tools.FileExplorerUI;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
/* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI */
public class ComposeUI extends MMActivity {
    private static List<C43404o> pwd;
    private C44275p gBk;
    private int mode = 5;
    private int ptH = 1;
    private C28730ab puY = C12884ac.ccD();
    private long pvG;
    private Map<String, String> pvf = new HashMap();
    private C46633o pwA;
    public boolean pwB = true;
    public boolean pwC = true;
    public boolean pwD = false;
    private String pwE = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    private String pwF = "document.getElementById('history').innerHTML";
    private String pwG = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    private String pwH = "</div>";
    private String pwI = null;
    private String pwJ = null;
    private String pwK = "weixin://get_img_info/";
    private String pwL = "weixin://get_mail_content/";
    private String pwM = "weixin://img_onclick/";
    private boolean pwN = false;
    private boolean pwO = false;
    private C7564ap pwP = new C7564ap(new C287531(), true);
    private C7564ap pwQ = new C7564ap(new C2876112(), true);
    C43405a pwR = new C2875117();
    private OnClickListener pwS = new C129037();
    private OnClickListener pwT = new C129058();
    private OnMenuItemClickListener pwU = new C2876010();
    private OnClickListener pwV = new C2875711();
    private OnClickListener pwW = new C365013();
    private C21523a pwX = new C1290115();
    private ScrollView pwe;
    protected MailAddrsViewControl pwf;
    private ImageView pwg;
    private LinearLayout pwh;
    private LinearLayout pwi;
    private MailAddrsViewControl pwj;
    private ImageView pwk;
    private LinearLayout pwl;
    private MailAddrsViewControl pwm;
    private ImageView pwn;
    private EditText pwo;
    private LinearLayout pwp;
    private TextView pwq;
    private ImageView pwr;
    private LinearLayout pws;
    private TextView pwt;
    private EditText pwu;
    private MMWebView pwv;
    private C46149p pww;
    private C7027b pwx;
    public C12925c pwy = new C12925c(this);
    private String pwz;

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$13 */
    class C365013 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$13$1 */
        class C36511 implements OnCancelListener {
            C36511() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(68185);
                ComposeUI.this.pwx.cdb();
                ComposeUI.this.pwx.pxV = null;
                AppMethodBeat.m2505o(68185);
            }
        }

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$13$2 */
        class C36522 implements C7034b {
            C36522() {
            }

            public final void ccU() {
            }

            public final void onComplete() {
                AppMethodBeat.m2504i(68186);
                ComposeUI.this.gBk.dismiss();
                C30152u.m47744a(ComposeUI.this.pwv, ComposeUI.this.pwL, ComposeUI.this.pwF);
                ComposeUI.this.pwO = true;
                AppMethodBeat.m2505o(68186);
            }
        }

        C365013() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68187);
            if (ComposeUI.this.pwx.cdc()) {
                C30152u.m47744a(ComposeUI.this.pwv, ComposeUI.this.pwL, ComposeUI.this.pwF);
                ComposeUI.this.pwO = true;
                AppMethodBeat.m2505o(68187);
                return;
            }
            ComposeUI.this.gBk = C30379h.m48458b(ComposeUI.this, ComposeUI.this.getString(C25738R.string.dcz), true, new C36511());
            ComposeUI.this.pwx.pxV = new C36522();
            AppMethodBeat.m2505o(68187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$5 */
    class C36545 implements OnMenuItemClickListener {
        C36545() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68171);
            ComposeUI.this.pwW.onClick(null);
            AppMethodBeat.m2505o(68171);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$6 */
    class C36556 implements OnTouchListener {
        C36556() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(68172);
            switch (motionEvent.getAction()) {
                case 0:
                case 1:
                    if (!view.hasFocus()) {
                        view.requestFocus();
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(68172);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$14 */
    class C1289914 implements Runnable {
        C1289914() {
        }

        public final void run() {
            AppMethodBeat.m2504i(68188);
            ComposeUI.this.setResult(-1);
            ComposeUI.this.finish();
            AppMethodBeat.m2505o(68188);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$15 */
    class C1290115 extends C21523a {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$15$1 */
        class C129001 implements DialogInterface.OnClickListener {
            C129001() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(68189);
                File file = new File(C12884ac.ccC().puE.ptG.ptQ + C21519i.m32973cR(ComposeUI.this.pwz, ComposeUI.this.ptH));
                if (file.exists()) {
                    file.delete();
                }
                ComposeUI.this.setResult(-1);
                ComposeUI.this.finish();
                AppMethodBeat.m2505o(68189);
            }
        }

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$15$2 */
        class C129022 extends C12927a {
            C129022() {
            }

            public final void ccF() {
                AppMethodBeat.m2504i(68190);
                ComposeUI.m45697H(ComposeUI.this);
                AppMethodBeat.m2505o(68190);
            }

            public final void ccG() {
            }
        }

        C1290115() {
        }

        public final void onSuccess(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(68191);
            C30379h.m48431a(ComposeUI.this, (int) C25738R.string.dd3, (int) C25738R.string.f9238tz, new C129001());
            ComposeUI.this.pww.mo74099cG(ComposeUI.this.pwf.getMailAddrs());
            ComposeUI.this.pww.mo74099cG(ComposeUI.this.pwj.getMailAddrs());
            ComposeUI.this.pww.mo74099cG(ComposeUI.this.pwm.getMailAddrs());
            AppMethodBeat.m2505o(68191);
        }

        public final void onError(int i, String str) {
            AppMethodBeat.m2504i(68192);
            if (i == -5) {
                ComposeUI.this.pwy.mo24951a(new C129022());
                AppMethodBeat.m2505o(68192);
                return;
            }
            C30379h.m48438a(ComposeUI.this, str, ComposeUI.this.getString(C25738R.string.dd1), null);
            AppMethodBeat.m2505o(68192);
        }

        public final void onComplete() {
            AppMethodBeat.m2504i(68193);
            if (ComposeUI.this.gBk != null) {
                ComposeUI.this.gBk.dismiss();
                ComposeUI.this.gBk = null;
            }
            AppMethodBeat.m2505o(68193);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$7 */
    class C129037 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$7$1 */
        class C129041 implements Runnable {
            C129041() {
            }

            public final void run() {
                AppMethodBeat.m2504i(68173);
                ComposeUI.this.pwi.requestFocus();
                ComposeUI.this.pwj.cdj();
                ComposeUI.this.pwm.cdj();
                AppMethodBeat.m2505o(68173);
            }
        }

        C129037() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68174);
            ComposeUI.this.pwh.setVisibility(8);
            ComposeUI.this.pwi.setVisibility(0);
            ComposeUI.this.pwl.setVisibility(0);
            ComposeUI.this.pwh.post(new C129041());
            AppMethodBeat.m2505o(68174);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$8 */
    class C129058 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$8$1 */
        class C129061 implements C30391c {
            C129061() {
            }

            /* renamed from: iE */
            public final void mo7700iE(int i) {
                AppMethodBeat.m2504i(68175);
                switch (i) {
                    case 0:
                        C4990ab.m7417i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(ComposeUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")), C5046bo.dpG(), ComposeUI.this.mController.ylL);
                        if (C35805b.m58707a(ComposeUI.this.mController.ylL, "android.permission.CAMERA", 16, "", "")) {
                            ComposeUI.m45692C(ComposeUI.this);
                            AppMethodBeat.m2505o(68175);
                            return;
                        }
                        AppMethodBeat.m2505o(68175);
                        return;
                    case 1:
                        C14987n.m23301a(ComposeUI.this, 4, null);
                        AppMethodBeat.m2505o(68175);
                        return;
                    case 2:
                        ComposeUI.this.startActivityForResult(new Intent(ComposeUI.this, FileExplorerUI.class), 5);
                        break;
                }
                AppMethodBeat.m2505o(68175);
            }
        }

        C129058() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68176);
            C30379h.m48422a(ComposeUI.this, null, new String[]{ComposeUI.this.getString(C25738R.string.dda), ComposeUI.this.getString(C25738R.string.dd8), ComposeUI.this.getString(C25738R.string.dd9)}, null, new C129061());
            AppMethodBeat.m2505o(68176);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$a */
    class C12907a extends C6031l {
        private C12907a() {
        }

        /* synthetic */ C12907a(ComposeUI composeUI, byte b) {
            this();
        }

        @Deprecated
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.m2504i(68207);
            C4990ab.m7417i("MicroMsg.ComposeUI", "console, consoleMessage: %s", consoleMessage);
            String akn = C30152u.akn(consoleMessage != null ? consoleMessage.message() : null);
            String[] split;
            if (akn.startsWith(ComposeUI.this.pwM)) {
                ComposeUI.this.aqX();
                try {
                    String[] split2 = URLDecoder.decode(akn.substring(ComposeUI.this.pwM.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    String str = split2[0];
                    String str2 = split2[1];
                    C4990ab.m7417i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", split[1], str, str2);
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) Integer.valueOf(str).intValue());
                    Intent intent = new Intent(ComposeUI.this, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", jf.field_msgId);
                    intent.putExtra("img_server_id", jf.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", jf.field_talker);
                    ComposeUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(68207);
                    return true;
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", e.getMessage());
                }
            } else if (akn.startsWith(ComposeUI.this.pwL)) {
                try {
                    ComposeUI.this.pwJ = URLDecoder.decode(akn.substring(ComposeUI.this.pwL.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    C4990ab.m7421w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", e2.getMessage());
                }
                if (ComposeUI.this.pwO) {
                    if (ComposeUI.this.pwJ.indexOf("<img") == -1) {
                        ComposeUI.this.pvf.clear();
                        ComposeUI.m45726r(ComposeUI.this);
                        AppMethodBeat.m2505o(68207);
                        return true;
                    }
                    C30152u.m47744a(ComposeUI.this.pwv, ComposeUI.this.pwK, ComposeUI.this.pwE);
                }
                AppMethodBeat.m2505o(68207);
                return true;
            } else {
                if (akn.startsWith(ComposeUI.this.pwK)) {
                    ComposeUI.this.pvf.clear();
                    try {
                        String[] split3 = URLDecoder.decode(akn.substring(ComposeUI.this.pwK.length()), ProtocolPackage.ServerEncoding).split("&&");
                        for (String akn2 : split3) {
                            split = akn2.split("@@");
                            Object obj = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[1];
                            Object obj2 = split[1];
                            if (obj2.startsWith("file://")) {
                                obj2 = obj2.replaceFirst("file://", "");
                            }
                            C4990ab.m7417i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", obj, obj2);
                            ComposeUI.this.pvf.put(obj, obj2);
                        }
                        if (ComposeUI.this.pwO) {
                            ComposeUI.m45726r(ComposeUI.this);
                        }
                        AppMethodBeat.m2505o(68207);
                        return true;
                    } catch (Exception e22) {
                        C4990ab.m7421w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", e22.getMessage());
                        AppMethodBeat.m2505o(68207);
                        return true;
                    }
                }
                boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                AppMethodBeat.m2505o(68207);
                return onConsoleMessage;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$20 */
    class C2153620 implements OnClickListener {
        C2153620() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68203);
            Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
            intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pwf.mo55347a(false, null));
            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
            ComposeUI.this.startActivityForResult(intent, 0);
            ComposeUI.this.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
            AppMethodBeat.m2505o(68203);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$c */
    class C21537c extends C3664c {
        private ImageView pxl;
        private int tag;

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$c$1 */
        class C215381 implements Runnable {
            C215381() {
            }

            public final void run() {
                AppMethodBeat.m2504i(68211);
                if (!ComposeUI.this.pwj.pyz.isFocused() && !ComposeUI.this.pwm.pyz.isFocused() && ComposeUI.this.pwj.getMailAddrs().size() == 0 && ComposeUI.this.pwm.getMailAddrs().size() == 0 && ComposeUI.this.pwj.cdg() && ComposeUI.this.pwm.cdg()) {
                    ComposeUI.this.pwh.setVisibility(0);
                    ComposeUI.this.pwi.setVisibility(8);
                    ComposeUI.this.pwl.setVisibility(8);
                }
                AppMethodBeat.m2505o(68211);
            }
        }

        public C21537c(ImageView imageView, int i) {
            this.pxl = imageView;
            this.tag = i;
        }

        /* renamed from: jW */
        public final void mo8271jW(boolean z) {
            ImageView imageView;
            int i = 0;
            AppMethodBeat.m2504i(68212);
            ComposeUI.m45733y(ComposeUI.this);
            if (ComposeUI.this.pwD) {
                imageView = this.pxl;
            } else {
                imageView = this.pxl;
                if (!z) {
                    i = 4;
                }
            }
            imageView.setVisibility(i);
            if ((this.tag == 1 || this.tag == 2) && !z) {
                ComposeUI.this.pwh.postDelayed(new C215381(), 10);
            }
            AppMethodBeat.m2505o(68212);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$21 */
    class C2874921 implements OnClickListener {
        C2874921() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68204);
            Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
            intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pwj.mo55347a(false, null));
            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
            ComposeUI.this.startActivityForResult(intent, 1);
            ComposeUI.this.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
            AppMethodBeat.m2505o(68204);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$b */
    class C28750b extends C36592s {
        private boolean pxk;

        private C28750b() {
            this.pxk = false;
        }

        /* synthetic */ C28750b(ComposeUI composeUI, byte b) {
            this();
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(68208);
            C4990ab.m7411d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", str);
            String[] split;
            String str2;
            if (str.startsWith(ComposeUI.this.pwM)) {
                ComposeUI.this.aqX();
                try {
                    split = URLDecoder.decode(str.substring(ComposeUI.this.pwM.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    String str3 = split[0];
                    str2 = split[1];
                    C4990ab.m7417i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", r0[1], str3, str2);
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) Integer.valueOf(str3).intValue());
                    Intent intent = new Intent(ComposeUI.this, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", jf.field_msgId);
                    intent.putExtra("img_server_id", jf.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", jf.field_talker);
                    ComposeUI.this.startActivity(intent);
                    AppMethodBeat.m2505o(68208);
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", e.getMessage());
                }
            } else if (str.startsWith(ComposeUI.this.pwL)) {
                try {
                    ComposeUI.this.pwJ = URLDecoder.decode(str.substring(ComposeUI.this.pwL.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    C4990ab.m7421w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", e2.getMessage());
                }
                if (ComposeUI.this.pwO) {
                    if (ComposeUI.this.pwJ.indexOf("<img") == -1) {
                        ComposeUI.this.pvf.clear();
                        ComposeUI.m45726r(ComposeUI.this);
                        AppMethodBeat.m2505o(68208);
                    } else {
                        C30152u.m47744a(ComposeUI.this.pwv, ComposeUI.this.pwK, ComposeUI.this.pwE);
                    }
                }
                AppMethodBeat.m2505o(68208);
            } else {
                if (str.startsWith(ComposeUI.this.pwK)) {
                    ComposeUI.this.pvf.clear();
                    try {
                        String[] split2 = URLDecoder.decode(str.substring(ComposeUI.this.pwK.length()), ProtocolPackage.ServerEncoding).split("&&");
                        for (String str22 : split2) {
                            split = str22.split("@@");
                            Object obj = split[0].split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[1];
                            Object obj2 = split[1];
                            if (obj2.startsWith("file://")) {
                                obj2 = obj2.replaceFirst("file://", "");
                            }
                            C4990ab.m7417i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", obj, obj2);
                            ComposeUI.this.pvf.put(obj, obj2);
                        }
                        if (ComposeUI.this.pwO) {
                            ComposeUI.m45726r(ComposeUI.this);
                        }
                        AppMethodBeat.m2505o(68208);
                    } catch (Exception e22) {
                        C4990ab.m7421w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", e22.getMessage());
                        AppMethodBeat.m2505o(68208);
                    }
                }
                AppMethodBeat.m2505o(68208);
            }
            return true;
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(68209);
            super.mo7562b(webView, str, bitmap);
            if (!ComposeUI.this.pwN) {
                C30152u.m47748d(ComposeUI.this.pwv);
                ComposeUI.this.pwN = true;
            }
            AppMethodBeat.m2505o(68209);
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(68210);
            C4990ab.m7411d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", str, Boolean.valueOf(this.pxk));
            if (!this.pxk) {
                this.pxk = true;
                C30152u.m47744a(ComposeUI.this.pwv, ComposeUI.this.pwL, ComposeUI.this.pwF);
            }
            super.mo5992b(webView, str);
            AppMethodBeat.m2505o(68210);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$17 */
    class C2875117 extends C43405a {
        C2875117() {
        }

        public final void onComplete() {
            AppMethodBeat.m2504i(68195);
            C3661b c3661b = new C3661b(ComposeUI.this, ComposeUI.this.pww.mo74096Vi(null));
            ComposeUI.this.pwf.setAddrsAdapter(c3661b);
            ComposeUI.this.pwj.setAddrsAdapter(c3661b);
            ComposeUI.this.pwm.setAddrsAdapter(c3661b);
            AppMethodBeat.m2505o(68195);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$18 */
    class C2875218 implements Runnable {
        C2875218() {
        }

        public final void run() {
            AppMethodBeat.m2504i(68196);
            ComposeUI.this.pwe.fullScroll(130);
            AppMethodBeat.m2505o(68196);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$1 */
    class C287531 implements C5015a {
        C287531() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(68167);
            ComposeUI.this.enableOptionMenu(ComposeUI.m45708a(ComposeUI.this, true));
            AppMethodBeat.m2505o(68167);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$4 */
    class C287554 implements OnMenuItemClickListener {
        C287554() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68170);
            ComposeUI.this.pwV.onClick(null);
            AppMethodBeat.m2505o(68170);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$9 */
    class C287569 implements DialogInterface.OnClickListener {
        C287569() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(68177);
            ComposeUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(68177);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$11 */
    class C2875711 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$11$1 */
        class C128971 implements OnCancelListener {
            C128971() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(68180);
                ComposeUI.this.pwx.cdb();
                ComposeUI.this.pwx.pxV = null;
                C12884ac.ccC().cancel(ComposeUI.this.pvG);
                AppMethodBeat.m2505o(68180);
            }
        }

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$11$2 */
        class C128982 implements C7034b {
            C128982() {
            }

            public final void ccU() {
                AppMethodBeat.m2504i(68181);
                ComposeUI.this.gBk.setMessage(ComposeUI.this.getString(C25738R.string.dcz));
                AppMethodBeat.m2505o(68181);
            }

            public final void onComplete() {
                AppMethodBeat.m2504i(68182);
                ComposeUI.this.pvG = ComposeUI.m45697H(ComposeUI.this);
                AppMethodBeat.m2505o(68182);
            }
        }

        C2875711() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68183);
            ComposeUI.this.aqX();
            ComposeUI.this.pwo.getText();
            ComposeUI.m45693D(ComposeUI.this);
            if (ComposeUI.this.ccT()) {
                ComposeUI composeUI = ComposeUI.this;
                Context context = ComposeUI.this;
                ComposeUI.this.getString(C25738R.string.f9238tz);
                composeUI.gBk = C30379h.m48458b(context, ComposeUI.this.getString(C25738R.string.dd2), true, new C128971());
                if (ComposeUI.this.pwx.cdc()) {
                    ComposeUI.this.pvG = ComposeUI.m45697H(ComposeUI.this);
                    AppMethodBeat.m2505o(68183);
                    return;
                }
                ComposeUI.this.gBk.setMessage(ComposeUI.this.getString(C25738R.string.dcz));
                ComposeUI.this.pwx.pxV = new C128982();
                AppMethodBeat.m2505o(68183);
                return;
            }
            AppMethodBeat.m2505o(68183);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$3 */
    class C287583 implements OnClickListener {
        C287583() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68169);
            ComposeUI.this.pwo.getText().clear();
            ComposeUI.this.pwo.requestFocus();
            AppMethodBeat.m2505o(68169);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$22 */
    class C2875922 implements OnClickListener {
        C2875922() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(68205);
            Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
            intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.pwm.mo55347a(false, null));
            intent.putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, C25738R.anim.f8373ce);
            intent.putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, C25738R.anim.f8332b5);
            ComposeUI.this.startActivityForResult(intent, 2);
            ComposeUI.this.overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8333b6);
            AppMethodBeat.m2505o(68205);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$10 */
    class C2876010 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$10$1 */
        class C128961 implements DialogInterface.OnClickListener {
            C128961() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(68178);
                ComposeUI.this.setResult(0);
                ComposeUI.this.finish();
                AppMethodBeat.m2505o(68178);
            }
        }

        C2876010() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(68179);
            if ((ComposeUI.m45708a(ComposeUI.this, false) && ComposeUI.this.mode == 5) || ComposeUI.this.mode == 6) {
                C30379h.m48466d(ComposeUI.this.mController.ylL, ComposeUI.this.getString(C25738R.string.ddh), "", ComposeUI.this.getString(C25738R.string.ddj), ComposeUI.this.getString(C25738R.string.f9076or), new C128961(), null);
            } else {
                ComposeUI.this.setResult(0);
                ComposeUI.this.finish();
            }
            AppMethodBeat.m2505o(68179);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$12 */
    class C2876112 implements C5015a {
        C2876112() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(68184);
            if (ComposeUI.this.pwB && ComposeUI.m45708a(ComposeUI.this, false) && ComposeUI.this.mode == 5) {
                ComposeUI.m45709b(ComposeUI.this);
                if (ComposeUI.this.pwA != null) {
                    ComposeUI.this.pwA.dismiss();
                }
                ComposeUI.this.pwA = C23639t.m36486a(ComposeUI.this, ComposeUI.this.getString(C25738R.string.ddb), (long) FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            }
            AppMethodBeat.m2505o(68184);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$19 */
    class C2876219 implements C12919a {
        C2876219() {
        }

        /* renamed from: b */
        public final void mo24945b(final MailAddrsViewControl mailAddrsViewControl) {
            AppMethodBeat.m2504i(68201);
            C30379h.m48440a(ComposeUI.this.mController.ylL, ComposeUI.this.getString(C25738R.string.dds), "", new DialogInterface.OnClickListener() {

                /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$19$1$1 */
                class C215351 implements Runnable {
                    C215351() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(68197);
                        ComposeUI.m45716h(ComposeUI.this);
                        mailAddrsViewControl.requestFocus();
                        ComposeUI.this.showVKB();
                        AppMethodBeat.m2505o(68197);
                    }
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(68198);
                    mailAddrsViewControl.pyz.setText("");
                    ComposeUI.this.pwQ.postDelayed(new C215351(), 150);
                    AppMethodBeat.m2505o(68198);
                }
            }, new DialogInterface.OnClickListener() {

                /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$19$2$1 */
                class C287481 implements Runnable {
                    C287481() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(68199);
                        ComposeUI.m45716h(ComposeUI.this);
                        mailAddrsViewControl.requestFocus();
                        ComposeUI.this.showVKB();
                        AppMethodBeat.m2505o(68199);
                    }
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(68200);
                    ComposeUI.this.pwQ.postDelayed(new C287481(), 150);
                    AppMethodBeat.m2505o(68200);
                }
            });
            AppMethodBeat.m2505o(68201);
        }

        public final void ccV() {
            AppMethodBeat.m2504i(68202);
            C23639t.m36486a(ComposeUI.this, ComposeUI.this.getString(C25738R.string.dds), 1500);
            AppMethodBeat.m2505o(68202);
        }
    }

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.ComposeUI$23 */
    class C2876323 implements OnFocusChangeListener {
        C2876323() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(68206);
            if (z) {
                ComposeUI.this.pwo.setSelection(ComposeUI.this.pwo.getText().length());
            }
            AppMethodBeat.m2505o(68206);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ComposeUI() {
        AppMethodBeat.m2504i(68213);
        AppMethodBeat.m2505o(68213);
    }

    /* renamed from: C */
    static /* synthetic */ void m45692C(ComposeUI composeUI) {
        AppMethodBeat.m2504i(68235);
        composeUI.bCz();
        AppMethodBeat.m2505o(68235);
    }

    /* renamed from: D */
    static /* synthetic */ String m45693D(ComposeUI composeUI) {
        AppMethodBeat.m2504i(68236);
        String ccS = composeUI.ccS();
        AppMethodBeat.m2505o(68236);
        return ccS;
    }

    /* renamed from: h */
    static /* synthetic */ void m45716h(ComposeUI composeUI) {
        AppMethodBeat.m2504i(68232);
        composeUI.ccQ();
        AppMethodBeat.m2505o(68232);
    }

    public final int getLayoutId() {
        return 2130970426;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(68214);
        super.onCreate(bundle);
        this.pwI = this.pwG + "%s" + this.pwH;
        this.pwN = false;
        this.pwO = false;
        this.ptH = getIntent().getIntExtra("composeType", 1);
        this.pwz = getIntent().getStringExtra("mailid");
        if (this.pwz == null) {
            this.pwz = "";
        }
        this.mode = getIntent().getIntExtra("mail_mode", 5);
        C4990ab.m7411d("MicroMsg.ComposeUI", "onCreate, mode = %d", Integer.valueOf(this.mode));
        initView();
        this.pww = C12884ac.ccC().puD;
        this.pww.mo74097a(this.pwR);
        this.pww.ccq();
        this.pwQ.mo16770ae(180000, 180000);
        AppMethodBeat.m2505o(68214);
    }

    public void onResume() {
        AppMethodBeat.m2504i(68215);
        super.onResume();
        this.pwP.mo16770ae(1500, 1500);
        AppMethodBeat.m2505o(68215);
    }

    public void onPause() {
        AppMethodBeat.m2504i(68216);
        super.onPause();
        aqX();
        this.pwP.stopTimer();
        if (this.pwA != null) {
            this.pwA.dismiss();
        }
        AppMethodBeat.m2505o(68216);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(68217);
        super.onDestroy();
        if (pwd != null) {
            pwd = null;
        }
        this.pwx.cdb();
        C1720g.m3535RO().eJo.mo14546b(484, this.pwx);
        this.pww.mo74098b(this.pwR);
        this.pwy.release();
        this.pwQ.stopTimer();
        AppMethodBeat.m2505o(68217);
    }

    private void ccQ() {
        AppMethodBeat.m2504i(68218);
        this.pwf.clearFocus();
        this.pwj.clearFocus();
        this.pwm.clearFocus();
        AppMethodBeat.m2505o(68218);
    }

    public final void initView() {
        String str;
        AppMethodBeat.m2504i(68219);
        this.pwe = (ScrollView) findViewById(2131826704);
        this.pwf = (MailAddrsViewControl) findViewById(2131826708);
        this.pwg = (ImageView) findViewById(2131826709);
        this.pwh = (LinearLayout) findViewById(2131826710);
        this.pwi = (LinearLayout) findViewById(2131826711);
        this.pwj = (MailAddrsViewControl) findViewById(2131826712);
        this.pwk = (ImageView) findViewById(2131826713);
        this.pwl = (LinearLayout) findViewById(2131826714);
        this.pwm = (MailAddrsViewControl) findViewById(2131826715);
        this.pwn = (ImageView) findViewById(2131826716);
        this.pwo = (EditText) findViewById(2131826718);
        this.pwp = (LinearLayout) findViewById(2131826720);
        this.pwt = (TextView) findViewById(2131826724);
        this.pwu = (EditText) findViewById(2131826725);
        this.pwv = C30798a.m49146n(this, 2131826726);
        this.pwq = (TextView) findViewById(2131826721);
        this.pwr = (ImageView) findViewById(2131826722);
        this.pws = (LinearLayout) findViewById(2131826723);
        this.pwf.setEditable(true);
        this.pwj.setEditable(true);
        this.pwm.setEditable(true);
        String stringExtra = getIntent().getStringExtra("mail_content");
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("mail_attach");
        ArrayList stringArrayListExtra2 = getIntent().getStringArrayListExtra("mail_attach_title");
        C21520j cQ = C12884ac.ccC().puE.mo36996cQ(this.pwz, this.ptH);
        this.pwx = new C7027b(this, this.pwq, this.pwr, this.pws, (byte) 0);
        if (!C5046bo.isNullOrNil(stringExtra)) {
            C4990ab.m7416i("MicroMsg.ComposeUI", "read mail from extra");
            if (this.mode == 6) {
                ccR();
                this.pwf.requestFocus();
                this.pwJ = String.format(this.pwI, new Object[]{stringExtra});
                this.pwv.loadDataWithBaseURL("", this.pwJ, "text/html", ProtocolPackage.ServerEncoding, "");
                this.pwu.setVisibility(8);
                this.pwv.setVisibility(0);
            } else if (this.mode == 5) {
                this.pwu.setVisibility(0);
                this.pwv.setVisibility(8);
                if (stringExtra.indexOf("<div>") != -1) {
                    C4990ab.m7416i("MicroMsg.ComposeUI", "set content in html format");
                    this.pwu.setText(Html.fromHtml(stringExtra));
                } else {
                    this.pwu.setText(stringExtra);
                }
            }
            this.pwx.mode = this.mode;
            if (this.mode == 6) {
                int i = 0;
                for (String str2 : stringArrayListExtra) {
                    File file = new File(str2);
                    if (file.exists()) {
                        if (((int) file.length()) + this.pwx.cde() > DeviceUtils.MIN_STORAGE_SIZE) {
                            C30379h.m48431a((Context) this, (int) C25738R.string.de4, (int) C25738R.string.f9238tz, null);
                            break;
                        }
                        C4990ab.m7417i("MicroMsg.ComposeUI", "in upload file mode = %d", Integer.valueOf(this.mode));
                        int i2 = i + 1;
                        this.pwx.mo15405fG(str2, (String) stringArrayListExtra2.get(i));
                        i = i2;
                    }
                }
            }
        } else if (cQ == null || this.mode != 6) {
            C4990ab.m7416i("MicroMsg.ComposeUI", "no extra or draf mail content");
            if (this.mode == 6) {
                ccR();
                this.pwf.requestFocus();
                this.pwJ = String.format(this.pwI, new Object[]{""});
                this.pwv.loadDataWithBaseURL("", this.pwJ, "text/html", ProtocolPackage.ServerEncoding, "");
                this.pwu.setVisibility(8);
                this.pwv.setVisibility(0);
            } else if (this.mode == 5) {
                this.pwv.setVisibility(8);
                this.pwu.setVisibility(0);
            }
            this.pwx.mode = this.mode;
        } else {
            C4990ab.m7416i("MicroMsg.ComposeUI", "read mail from draftMail");
            this.pwf.mo55349cJ(cQ.ptJ);
            this.pwj.mo55349cJ(cQ.ptK);
            this.pwm.mo55349cJ(cQ.ptL);
            this.pwo.setText(cQ.ptN);
            str2 = cQ.content;
            this.mode = 5;
            if (str2.indexOf("<div>") != -1) {
                C4990ab.m7416i("MicroMsg.ComposeUI", "set content in html format");
                this.pwu.setText(Html.fromHtml(str2));
            } else {
                this.pwu.setText(str2);
            }
            this.pwx.mode = this.mode;
            this.pwx.mo15398cI(cQ.ptM);
            this.pwx.cdd();
            this.pwv.setVisibility(8);
            this.pwu.setVisibility(0);
        }
        String[] stringArrayExtra;
        if (this.ptH != 1) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            String[] stringArrayExtra2 = getIntent().getStringArrayExtra("ccList");
            String[] stringArrayExtra3 = getIntent().getStringArrayExtra("bccList");
            String stringExtra2 = getIntent().getStringExtra("subject");
            this.pwf.mo55348b(stringArrayExtra, false);
            this.pwj.mo55348b(stringArrayExtra2, false);
            this.pwm.mo55348b(stringArrayExtra3, false);
            if (!C5046bo.isNullOrNil(stringExtra2)) {
                EditText editText = this.pwo;
                StringBuilder stringBuilder = new StringBuilder();
                if (this.ptH == 2) {
                    str2 = "Re:";
                } else {
                    str2 = "Fwd:";
                }
                editText.setText(stringBuilder.append(str2).append(stringExtra2).toString());
            }
        } else if (this.ptH == 2 || this.ptH == 3) {
            this.pwt.setVisibility(0);
        } else if (this.ptH == 4) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                this.pwf.mo55348b(stringArrayExtra, false);
            }
        } else if (this.ptH == 1) {
            str2 = getIntent().getStringExtra("subject");
            if (!C5046bo.isNullOrNil(str2)) {
                this.pwo.setText(str2);
            }
        }
        if (this.pwj.getMailAddrs().size() > 0 || this.pwm.getMailAddrs().size() > 0) {
            this.pwh.setVisibility(8);
            this.pwi.setVisibility(0);
            this.pwl.setVisibility(0);
        }
        if (this.ptH == 2 && this.mode != 6 && this.mode == 5) {
            this.pwu.requestFocus();
            this.pwu.setSelection(0);
            this.pwe.postDelayed(new C2875218(), 1000);
        }
        this.pwf.setOnActionListener(new C21537c(this.pwg, 0));
        this.pwj.setOnActionListener(new C21537c(this.pwk, 1));
        this.pwm.setOnActionListener(new C21537c(this.pwn, 2));
        C2876219 c2876219 = new C2876219();
        this.pwf.setInvalidMailAddrListener(c2876219);
        this.pwj.setInvalidMailAddrListener(c2876219);
        this.pwm.setInvalidMailAddrListener(c2876219);
        this.pwg.setOnClickListener(new C2153620());
        this.pwk.setOnClickListener(new C2874921());
        this.pwn.setOnClickListener(new C2875922());
        this.pwh.setOnClickListener(this.pwS);
        final ImageView imageView = (ImageView) findViewById(2131826719);
        if (this.pwC && this.pwo.getText().length() > 0) {
            imageView.setVisibility(0);
        }
        this.pwo.setOnFocusChangeListener(new C2876323());
        this.pwo.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int i4 = 4;
                AppMethodBeat.m2504i(68168);
                if (ComposeUI.this.pwC) {
                    ImageView imageView = imageView;
                    if (ComposeUI.this.pwo.getText().length() > 0) {
                        i4 = 0;
                    }
                    imageView.setVisibility(i4);
                    AppMethodBeat.m2505o(68168);
                    return;
                }
                imageView.setVisibility(4);
                AppMethodBeat.m2505o(68168);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        imageView.setOnClickListener(new C287583());
        this.pwp.setOnClickListener(this.pwT);
        setMMTitle((int) C25738R.string.ddm);
        if (getIntent().getBooleanExtra("show_qqmail", false)) {
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(9, Integer.valueOf(0))).intValue();
            if (intValue == 0) {
                C4990ab.m7420w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
            } else {
                setMMSubTitle(new C1183p(intValue) + "@qq.com");
            }
        }
        setBackBtn(this.pwU);
        if (this.mode == 5) {
            addTextOptionMenu(0, getString(C25738R.string.f9221tf), new C287554());
        } else if (this.mode == 6) {
            C4990ab.m7416i("MicroMsg.ComposeUI", "set onShareModeSendListener");
            addTextOptionMenu(0, getString(C25738R.string.f9221tf), new C36545());
        }
        enableOptionMenu(false);
        ccQ();
        AppMethodBeat.m2505o(68219);
    }

    private void ccR() {
        AppMethodBeat.m2504i(68220);
        if (this.pwv != null) {
            this.pwv.clearFocus();
            this.pwv.getSettings().setJavaScriptEnabled(true);
            this.pwv.setWebViewClient(new C28750b(this, (byte) 0));
            this.pwv.setWebChromeClient(new C12907a(this, (byte) 0));
            this.pwv.setOnTouchListener(new C36556());
        }
        AppMethodBeat.m2505o(68220);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(68221);
        if (i == 4) {
            this.pwU.onMenuItemClick(null);
            AppMethodBeat.m2505o(68221);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(68221);
        return onKeyDown;
    }

    private void bCz() {
        AppMethodBeat.m2504i(68222);
        if (!C14987n.m23311c(this, C6457e.euR, "microMsg." + System.currentTimeMillis() + FileUtils.PIC_POSTFIX_JPEG, 3)) {
            Toast.makeText(this, getString(C25738R.string.e29), 1).show();
        }
        AppMethodBeat.m2505o(68222);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(68223);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.ComposeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(68223);
            return;
        }
        C4990ab.m7417i("MicroMsg.ComposeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dbs), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C287569(), null);
                    break;
                }
                bCz();
                AppMethodBeat.m2505o(68223);
                return;
        }
        AppMethodBeat.m2505o(68223);
    }

    private String ccS() {
        AppMethodBeat.m2504i(68224);
        String str;
        if (this.mode == 6) {
            C30152u.m47744a(this.pwv, this.pwL, this.pwF);
            if (this.pwJ != null) {
                int indexOf = this.pwJ.indexOf(this.pwG);
                int lastIndexOf = this.pwJ.lastIndexOf(this.pwH);
                if (indexOf == -1 || lastIndexOf == -1) {
                    str = this.pwJ;
                    AppMethodBeat.m2505o(68224);
                    return str;
                }
                str = this.pwJ.substring(indexOf + this.pwG.length(), lastIndexOf + this.pwH.length());
                AppMethodBeat.m2505o(68224);
                return str;
            }
        } else if (this.mode == 5) {
            str = this.pwu.getText().toString();
            AppMethodBeat.m2505o(68224);
            return str;
        }
        AppMethodBeat.m2505o(68224);
        return null;
    }

    private String getSubject() {
        int i = 40;
        AppMethodBeat.m2504i(68225);
        String obj = this.pwo.getText().toString();
        if (obj.trim().length() > 0) {
            AppMethodBeat.m2505o(68225);
            return obj;
        }
        String substring;
        obj = ccS();
        if (this.mode == 5) {
            if (obj.length() > 0) {
                if (obj.length() <= 40) {
                    i = obj.length();
                }
                substring = obj.substring(0, i);
                AppMethodBeat.m2505o(68225);
                return substring;
            }
        } else if (this.mode == 6 && !C5046bo.isNullOrNil(obj)) {
            if (obj.length() <= 40) {
                i = obj.length();
            }
            substring = obj.substring(0, i);
            AppMethodBeat.m2505o(68225);
            return substring;
        }
        substring = getString(C25738R.string.ddi);
        AppMethodBeat.m2505o(68225);
        return substring;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean ccT() {
        AppMethodBeat.m2504i(68226);
        if (!this.pwf.cdi()) {
            Toast.makeText(this, C25738R.string.ddo, 1).show();
            AppMethodBeat.m2505o(68226);
            return false;
        } else if (!this.pwj.cdi()) {
            Toast.makeText(this, C25738R.string.ddf, 1).show();
            AppMethodBeat.m2505o(68226);
            return false;
        } else if (!this.pwm.cdi()) {
            Toast.makeText(this, C25738R.string.ddd, 1).show();
            AppMethodBeat.m2505o(68226);
            return false;
        } else if ((this.pwf.getMailAddrs().size() + this.pwj.getMailAddrs().size()) + this.pwm.getMailAddrs().size() > 20) {
            Toast.makeText(this, C25738R.string.ddu, 1).show();
            AppMethodBeat.m2505o(68226);
            return false;
        } else {
            AppMethodBeat.m2505o(68226);
            return true;
        }
    }

    /* renamed from: cH */
    static void m45711cH(List<C43404o> list) {
        pwd = list;
    }

    /* renamed from: a */
    private static void m45707a(MailAddrsViewControl mailAddrsViewControl) {
        AppMethodBeat.m2504i(68227);
        if (pwd == null) {
            AppMethodBeat.m2505o(68227);
            return;
        }
        mailAddrsViewControl.setMailAdds(pwd);
        AppMethodBeat.m2505o(68227);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(68228);
        if (i2 != -1) {
            AppMethodBeat.m2505o(68228);
            return;
        }
        String h;
        switch (i) {
            case 0:
                ComposeUI.m45707a(this.pwf);
                showVKB();
                AppMethodBeat.m2505o(68228);
                return;
            case 1:
                ComposeUI.m45707a(this.pwj);
                showVKB();
                AppMethodBeat.m2505o(68228);
                return;
            case 2:
                ComposeUI.m45707a(this.pwm);
                showVKB();
                AppMethodBeat.m2505o(68228);
                return;
            case 3:
                h = C14987n.m23320h(this, intent, C43217c.m76863XW());
                if (h != null) {
                    m45701Vo(h);
                    ccQ();
                    AppMethodBeat.m2505o(68228);
                    return;
                }
                break;
            case 4:
                if (intent != null) {
                    h = C36338a.m59824i(this, intent, C43217c.m76863XW());
                    if (h != null && h.length() > 0) {
                        m45701Vo(h);
                        ccQ();
                        AppMethodBeat.m2505o(68228);
                        return;
                    }
                }
                break;
            case 5:
                if (intent != null) {
                    m45701Vo(intent.getStringExtra("choosed_file_path"));
                    ccQ();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(68228);
    }

    /* renamed from: Vo */
    private void m45701Vo(final String str) {
        AppMethodBeat.m2504i(68229);
        final File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.m2505o(68229);
        } else if (this.pwx.mo15407wi(str)) {
            C30379h.m48467g(this.mController.ylL, C25738R.string.de2, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(68229);
        } else {
            final int length = (int) file.length();
            if (length > 20971520) {
                C30379h.m48431a((Context) this, (int) C25738R.string.de3, (int) C25738R.string.f9238tz, null);
                AppMethodBeat.m2505o(68229);
                return;
            }
            C30379h.m48440a((Context) this, getString(C25738R.string.de5, new Object[]{C5046bo.m7565ga((long) length)}), getString(C25738R.string.f9238tz), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(68194);
                    if (ComposeUI.this.pwx.cde() + length > DeviceUtils.MIN_STORAGE_SIZE) {
                        C30379h.m48431a(ComposeUI.this, (int) C25738R.string.de4, (int) C25738R.string.f9238tz, null);
                        AppMethodBeat.m2505o(68194);
                        return;
                    }
                    if (ComposeUI.this.pwo.getText().toString().trim().length() == 0) {
                        String trim = file.getName().trim();
                        int lastIndexOf = trim.lastIndexOf(".");
                        EditText j = ComposeUI.this.pwo;
                        if (lastIndexOf <= 0) {
                            lastIndexOf = trim.length();
                        }
                        j.setText(trim.substring(0, lastIndexOf));
                    }
                    C4990ab.m7417i("MicroMsg.ComposeUI", "in upload file mode = %d", Integer.valueOf(ComposeUI.this.mode));
                    ComposeUI.this.pwx.mo15405fG(str, null);
                    AppMethodBeat.m2505o(68194);
                }
            }, null);
            AppMethodBeat.m2505o(68229);
        }
    }

    public void setRequestedOrientation(int i) {
    }

    /* renamed from: b */
    static /* synthetic */ void m45709b(ComposeUI composeUI) {
        AppMethodBeat.m2504i(68231);
        C21520j c21520j = new C21520j();
        c21520j.ptH = composeUI.ptH;
        c21520j.ptI = composeUI.pwz;
        c21520j.ptJ = composeUI.pwf.getMailAddrs();
        c21520j.ptK = composeUI.pwj.getMailAddrs();
        c21520j.ptL = composeUI.pwm.getMailAddrs();
        c21520j.ptN = composeUI.pwo.getText().toString();
        c21520j.ptM = composeUI.pwx.cda();
        if (composeUI.mode != 6 && composeUI.mode == 5) {
            c21520j.content = composeUI.ccS();
            c21520j.ptO = composeUI.mode;
            C4990ab.m7416i("MicroMsg.ComposeUI", "save draft mail as normal mode");
        }
        C21519i c21519i = C12884ac.ccC().puE;
        try {
            c21519i.ptG.cco();
            C28741k.m45674z(c21519i.ptG.ptQ + C21519i.m32973cR(c21520j.ptI, c21520j.ptH), c21520j.toByteArray());
            AppMethodBeat.m2505o(68231);
        } catch (IOException e) {
            C4990ab.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
            AppMethodBeat.m2505o(68231);
        }
    }

    /* renamed from: r */
    static /* synthetic */ void m45726r(ComposeUI composeUI) {
        Map map;
        String str = null;
        AppMethodBeat.m2504i(68233);
        String c1183p = new C1183p(((Integer) C1720g.m3536RP().mo5239Ry().get(9, null)).intValue()).toString();
        if (C5046bo.isNullOrNil(c1183p)) {
            c1183p = null;
        } else {
            c1183p = c1183p + "@qq.com";
        }
        C12879aa c12879aa = new C12879aa();
        c12879aa.cEV = c1183p;
        c12879aa.ptN = composeUI.getSubject();
        if (!C5046bo.isNullOrNil(composeUI.pwf.getAddrsString())) {
            c12879aa.pur = composeUI.pwf.getAddrsString().split(",");
        }
        if (!C5046bo.isNullOrNil(composeUI.pwj.getAddrsString())) {
            c12879aa.pus = composeUI.pwj.getAddrsString().split(",");
        }
        if (!C5046bo.isNullOrNil(composeUI.pwm.getAddrsString())) {
            c12879aa.put = composeUI.pwm.getAddrsString().split(",");
        }
        c1183p = composeUI.ccS();
        if (!C5046bo.isNullOrNil(c1183p)) {
            str = c1183p.replaceAll("src=\"file://", "src=\"cid:").replaceAll("height=\"100\"", "style=\"max-width: 200px; max-width:300px;\"");
        }
        c12879aa.pve = str;
        if (composeUI.pvf.size() > 0) {
            map = composeUI.pvf;
            c12879aa.pvf = new HashMap();
            c12879aa.pvf.putAll(map);
        }
        C4990ab.m7411d("MicroMsg.ComposeUI", "send mail content: \n%s", str);
        C4990ab.m7411d("MicroMsg.ComposeUI", "msgImgInfoMap.size: %d", Integer.valueOf(composeUI.pvf.size()));
        C4990ab.m7411d("MicroMsg.ComposeUI", "uploadedAttachidMap.size: %d", Integer.valueOf(composeUI.pwx.pxT.size()));
        if (composeUI.pwx.pxT.size() > 0 && composeUI.pwx.pxU.size() > 0) {
            map = composeUI.pwx.pxT;
            c12879aa.pvg = new LinkedHashMap();
            c12879aa.pvg.putAll(map);
            map = composeUI.pwx.pxU;
            c12879aa.pvh = new LinkedHashMap();
            c12879aa.pvh.putAll(map);
        }
        C28730ab c28730ab = composeUI.puY;
        if (c28730ab.pvj == null) {
            c28730ab.pvj = new C12892z();
        }
        c28730ab.pvj.mo24918a(c12879aa);
        composeUI.pwO = false;
        C30379h.m48465bQ(composeUI.mController.ylL, composeUI.getString(C25738R.string.bvk));
        C5004al.m7442n(new C1289914(), 800);
        AppMethodBeat.m2505o(68233);
    }

    /* renamed from: y */
    static /* synthetic */ void m45733y(ComposeUI composeUI) {
        AppMethodBeat.m2504i(68234);
        composeUI.pwg.setVisibility(4);
        composeUI.pwk.setVisibility(4);
        composeUI.pwn.setVisibility(4);
        AppMethodBeat.m2505o(68234);
    }

    /* renamed from: H */
    static /* synthetic */ long m45697H(ComposeUI composeUI) {
        AppMethodBeat.m2504i(68237);
        HashMap hashMap = new HashMap();
        hashMap.put("from", "");
        hashMap.put("to", composeUI.pwf.getAddrsString());
        hashMap.put("cc", composeUI.pwj.getAddrsString());
        hashMap.put("bcc", composeUI.pwm.getAddrsString());
        hashMap.put("subject", composeUI.getSubject());
        hashMap.put(C8741b.CONTENT, composeUI.ccS());
        hashMap.put("attachlist", composeUI.pwx.ccZ());
        hashMap.put("sendtype", (composeUI.ptH == 4 ? 1 : composeUI.ptH));
        hashMap.put("oldmailid", composeUI.pwz);
        C28746c c28746c = new C28746c();
        c28746c.puP = false;
        c28746c.puO = true;
        long a = C12884ac.ccC().mo62492a("/cgi-bin/composesendwithattach", hashMap, c28746c, composeUI.pwX);
        AppMethodBeat.m2505o(68237);
        return a;
    }
}
