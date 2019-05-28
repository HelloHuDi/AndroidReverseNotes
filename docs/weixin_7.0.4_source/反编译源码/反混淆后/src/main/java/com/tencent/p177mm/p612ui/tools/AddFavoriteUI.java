package com.tencent.p177mm.p612ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.booter.NotifyReceiver;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37946d;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24112c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p275ui.SimpleLoginUI;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.p1082i.C14864e;
import com.tencent.p177mm.protocal.protobuf.C35949rt;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abf;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@C5271a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141010", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI */
public class AddFavoriteUI extends MMActivity implements C1202f {
    private ProgressDialog ehJ = null;
    String filePath = null;
    private C7306ak handler = new C3072512();
    private Intent intent = null;
    Uri uri = null;
    private C45316cl zAt;
    ArrayList<String> zAu = null;
    private C7306ak zAv = new C3072410();
    private C7306ak zAw = new C2402111();

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$1 */
    class C55571 implements Runnable {
        C55571() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34744);
            AddFavoriteUI.this.zAv.sendEmptyMessage(0);
            AppMethodBeat.m2505o(34744);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$2 */
    class C55582 implements C24112c {
        C55582() {
        }

        public final void onShow() {
        }

        public final void onHide() {
            AppMethodBeat.m2504i(34745);
            AddFavoriteUI.this.finish();
            AppMethodBeat.m2505o(34745);
        }

        public final void cLd() {
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$3 */
    class C55593 implements OnClickListener {
        C55593() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34746);
            AddFavoriteUI.this.finish();
            AppMethodBeat.m2505o(34746);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$8 */
    class C55608 implements C30730b {
        C55608() {
        }

        public final void dJx() {
            AppMethodBeat.m2504i(34750);
            AddFavoriteUI.this.handler.sendEmptyMessage(0);
            AppMethodBeat.m2505o(34750);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$9 */
    class C159169 implements Runnable {
        C159169() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34751);
            AddFavoriteUI.this.zAw.sendEmptyMessage(0);
            AppMethodBeat.m2505o(34751);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$11 */
    class C2402111 extends C7306ak {
        C2402111() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(34753);
            AddFavoriteUI.m48973d(AddFavoriteUI.this);
            AddFavoriteUI.m48975f(AddFavoriteUI.this);
            AppMethodBeat.m2505o(34753);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$13 */
    class C2402213 implements OnClickListener {
        C2402213() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34755);
            AddFavoriteUI.this.finish();
            AppMethodBeat.m2505o(34755);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$10 */
    class C3072410 extends C7306ak {
        C3072410() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(34752);
            AddFavoriteUI.m48973d(AddFavoriteUI.this);
            C4990ab.m7417i("MicroMsg.AddFavoriteUI", "dealWithText: %b", Boolean.valueOf(AddFavoriteUI.m48974e(AddFavoriteUI.this)));
            AppMethodBeat.m2505o(34752);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$12 */
    class C3072512 extends C7306ak {
        C3072512() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(34754);
            AddFavoriteUI.m48973d(AddFavoriteUI.this);
            if (C5046bo.isNullOrNil(AddFavoriteUI.this.filePath) || (C5046bo.anx(AddFavoriteUI.this.filePath) && !AddFavoriteUI.asd(AddFavoriteUI.this.filePath))) {
                C4990ab.m7412e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
                AddFavoriteUI.m48976g(AddFavoriteUI.this);
                AddFavoriteUI.this.finish();
                AppMethodBeat.m2505o(34754);
                return;
            }
            AddFavoriteUI.m48977h(AddFavoriteUI.this);
            AppMethodBeat.m2505o(34754);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$4 */
    class C307264 implements C24112c {
        C307264() {
        }

        public final void onShow() {
        }

        public final void onHide() {
            AppMethodBeat.m2504i(34747);
            AddFavoriteUI.this.finish();
            AppMethodBeat.m2505o(34747);
        }

        public final void cLd() {
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$5 */
    class C307275 implements OnClickListener {
        C307275() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34748);
            AddFavoriteUI.this.finish();
            AppMethodBeat.m2505o(34748);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$6 */
    class C307286 implements C24112c {
        C307286() {
        }

        public final void onShow() {
        }

        public final void onHide() {
            AppMethodBeat.m2504i(34749);
            AddFavoriteUI.this.finish();
            AppMethodBeat.m2505o(34749);
        }

        public final void cLd() {
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$7 */
    class C307297 implements OnCancelListener {
        C307297() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$b */
    public interface C30730b {
        void dJx();
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$14 */
    class C3073114 implements C24112c {
        C3073114() {
        }

        public final void onShow() {
        }

        public final void onHide() {
            AppMethodBeat.m2504i(34756);
            AddFavoriteUI.this.finish();
            AppMethodBeat.m2505o(34756);
        }

        public final void cLd() {
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$15 */
    class C3073215 implements OnClickListener {
        C3073215() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34757);
            AddFavoriteUI.this.finish();
            AppMethodBeat.m2505o(34757);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.AddFavoriteUI$a */
    class C30733a implements Runnable {
        private Uri mUri;
        private C30730b zAy;

        public C30733a(Uri uri, C30730b c30730b) {
            this.mUri = uri;
            this.zAy = c30730b;
        }

        public final void run() {
            AppMethodBeat.m2504i(34758);
            AddFavoriteUI.this.filePath = AddFavoriteUI.m48968a(AddFavoriteUI.this, this.mUri);
            if (C5046bo.isNullOrNil(AddFavoriteUI.this.filePath) || !new File(AddFavoriteUI.this.filePath).exists()) {
                if (AddFavoriteUI.ase(AddFavoriteUI.this.getContentResolver().getType(this.mUri)) == 2) {
                    AddFavoriteUI.this.filePath = C14864e.m23126a(AddFavoriteUI.this.getContentResolver(), this.mUri, 1);
                } else {
                    AddFavoriteUI.this.filePath = C14864e.m23125a(AddFavoriteUI.this.getContentResolver(), this.mUri);
                }
            }
            if (this.zAy != null) {
                this.zAy.dJx();
            }
            AppMethodBeat.m2505o(34758);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AddFavoriteUI() {
        AppMethodBeat.m2504i(34759);
        AppMethodBeat.m2505o(34759);
    }

    static /* synthetic */ int ase(String str) {
        AppMethodBeat.m2504i(34784);
        int asc = AddFavoriteUI.asc(str);
        AppMethodBeat.m2505o(34784);
        return asc;
    }

    /* renamed from: d */
    static /* synthetic */ void m48973d(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.m2504i(34777);
        addFavoriteUI.dismissDialog();
        AppMethodBeat.m2505o(34777);
    }

    /* renamed from: e */
    static /* synthetic */ boolean m48974e(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.m2504i(34778);
        boolean dJv = addFavoriteUI.dJv();
        AppMethodBeat.m2505o(34778);
        return dJv;
    }

    /* renamed from: g */
    static /* synthetic */ void m48976g(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.m2504i(34781);
        addFavoriteUI.dJw();
        AppMethodBeat.m2505o(34781);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34760);
        C4990ab.m7416i("MicroMsg.AddFavoriteUI", "on create");
        super.onCreate(bundle);
        setTitleVisibility(8);
        int a = C5068w.m7682a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.m41396Io();
                initView();
                AppMethodBeat.m2505o(34760);
                return;
            case 1:
                finish();
                AppMethodBeat.m2505o(34760);
                return;
            default:
                C4990ab.m7412e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(a)));
                finish();
                AppMethodBeat.m2505o(34760);
                return;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(34761);
        C4990ab.m7416i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
        super.onSaveInstanceState(bundle);
        AppMethodBeat.m2505o(34761);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(34762);
        C4990ab.m7416i("MicroMsg.AddFavoriteUI", "on NewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(34762);
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.m2504i(34763);
        C4990ab.m7416i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        AppMethodBeat.m2505o(34763);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34764);
        C4990ab.m7416i("MicroMsg.AddFavoriteUI", "on Destroy");
        C9638aw.m17182Rg().mo14546b(837, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(34764);
    }

    public final int getLayoutId() {
        return -1;
    }

    private void dJu() {
        AppMethodBeat.m2504i(34766);
        Intent intent = new Intent(this, AddFavoriteUI.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", C5046bo.isNullOrNil(this.filePath) ? null : Uri.fromFile(new File(this.filePath)));
        intent.addFlags(268435456).addFlags(32768);
        intent.setType(getIntent().getType());
        MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        AppMethodBeat.m2505o(34766);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0043 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aB */
    private ArrayList<String> m48969aB(Bundle bundle) {
        AppMethodBeat.m2504i(34767);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
            AppMethodBeat.m2505o(34767);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            int i;
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable == null || !(parcelable instanceof Uri)) {
                C4990ab.m7413e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", parcelable);
            } else {
                Uri uri = (Uri) parcelable;
                if (!C5046bo.m7585v(uri) || uri.getScheme() == null) {
                    C4990ab.m7412e("MicroMsg.AddFavoriteUI", "unaccepted uri: ".concat(String.valueOf(uri)));
                } else {
                    String h = C5046bo.m7568h(this, uri);
                    if (!C5046bo.isNullOrNil(h)) {
                        if (C5046bo.anx(h) && C5063r.amn(h)) {
                            C4990ab.m7416i("MicroMsg.AddFavoriteUI", "multisend file path: ".concat(String.valueOf(h)));
                            arrayList.add(h);
                            i = 1;
                            continue;
                            if (i == 0) {
                                AppMethodBeat.m2505o(34767);
                                return null;
                            }
                        }
                        C4990ab.m7420w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: ".concat(String.valueOf(h)));
                    }
                }
            }
            i = 0;
            continue;
            if (i == 0) {
            }
        }
        if (arrayList.size() > 0) {
            AppMethodBeat.m2505o(34767);
            return arrayList;
        }
        AppMethodBeat.m2505o(34767);
        return null;
    }

    private boolean dJv() {
        AppMethodBeat.m2504i(34768);
        this.intent = getIntent();
        if (this.intent == null) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "intent is null");
            AppMethodBeat.m2505o(34768);
            return false;
        }
        String n = C5068w.m7689n(this.intent, "android.intent.extra.TEXT");
        if (n == null || n.length() == 0) {
            C4990ab.m7416i("MicroMsg.AddFavoriteUI", "text is null");
            AppMethodBeat.m2505o(34768);
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(n));
        wXMediaMessage.description = n;
        Req req = new Req();
        req.transaction = null;
        req.message = wXMediaMessage;
        int type = req.message.getType();
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        bundle.putInt(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            C4990ab.m7420w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
            finish();
        } else {
            C45316cl c45316cl = new C45316cl();
            String str = C5730e.atd(this.filePath) + "." + C5730e.m8630cv(this.filePath);
            if (type == 1) {
                Boolean.valueOf(C40443e.m69375b(c45316cl, n, 13));
            } else {
                Boolean.valueOf(C40443e.m69373a(c45316cl, this.filePath, str, ""));
            }
            c45316cl.cvA.activity = this;
            c45316cl.cvA.cvI = new C55593();
            c45316cl.cvA.cvJ = new C307264();
            this.zAt = c45316cl;
            ArrayList arrayList = new ArrayList();
            arrayList.add(n);
            C1207m c37946d = new C37946d(5, arrayList, dyh());
            C9638aw.m17182Rg().mo14539a(837, (C1202f) this);
            C1720g.m3540Rg().mo14541a(c37946d, 0);
            showDialog();
        }
        AppMethodBeat.m2505o(34768);
        return true;
    }

    /* renamed from: bO */
    private void m48971bO(int i, String str) {
        AppMethodBeat.m2504i(34769);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
            AppMethodBeat.m2505o(34769);
            return;
        }
        long asZ = C5730e.asZ(str);
        C4990ab.m7417i("MicroMsg.AddFavoriteUI", "filelength: [%d]", Long.valueOf(asZ));
        if (asZ == 0) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
            Toast.makeText(this, C25738R.string.bp1, 1).show();
            finish();
            AppMethodBeat.m2505o(34769);
        } else if (asZ > 26214400) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
            Toast.makeText(this, C25738R.string.bs4, 1).show();
            finish();
            AppMethodBeat.m2505o(34769);
        } else if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            C4990ab.m7420w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            finish();
            dJu();
            AppMethodBeat.m2505o(34769);
        } else {
            IMediaObject wXImageObject;
            C1207m c37946d;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            C45316cl c45316cl = new C45316cl();
            String str2 = C5730e.atd(str) + "." + C5730e.m8630cv(str);
            switch (i) {
                case 2:
                    wXImageObject = new WXImageObject();
                    ((WXImageObject) wXImageObject).setImagePath(str);
                    c37946d = new C37946d(1, arrayList, dyh());
                    C40443e.m69368a(c45316cl, 13, str);
                    break;
                case 4:
                    wXImageObject = new WXVideoFileObject(str);
                    c37946d = new C37946d(3, arrayList, dyh());
                    String str3 = "";
                    if (!C5046bo.isNullOrNil(str)) {
                        C4990ab.m7411d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", str2, str3, str, Integer.valueOf(13));
                        if (new C5728b(str).length() <= ((long) C42164b.m74341Nc())) {
                            abf abf = new abf();
                            abl abl = new abl();
                            aar aar = new aar();
                            aar.akV(str);
                            aar.mo27394LE(4);
                            aar.akR(C5730e.m8630cv(str));
                            aar.akW(null);
                            aar.mo27393LD(0);
                            aar.akH(str2);
                            aar.akI(str3);
                            abl.alD(C1853r.m3846Yz());
                            abl.alE(C1853r.m3846Yz());
                            abl.mo39126LN(13);
                            abl.mo39136ml(C5046bo.anU());
                            abf.mo74737a(abl);
                            abf.wiv.add(aar);
                            c45316cl.cvA.title = aar.title;
                            c45316cl.cvA.desc = aar.title;
                            c45316cl.cvA.cvC = abf;
                            c45316cl.cvA.type = 4;
                            break;
                        }
                        c45316cl.cvA.cvG = C25738R.string.bs4;
                        break;
                    }
                    C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    c45316cl.cvA.cvG = C25738R.string.boh;
                    break;
                default:
                    wXImageObject = new WXFileObject(str);
                    c37946d = new C37946d(4, arrayList, dyh());
                    C40443e.m69373a(c45316cl, str, str2, "");
                    break;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXImageObject);
            wXMediaMessage.title = new File(str).getName();
            if (C5046bo.isNullOrNil(null)) {
                wXMediaMessage.description = C5046bo.m7565ga(asZ);
            } else {
                wXMediaMessage.description = null;
            }
            if (asZ < 30720) {
                wXMediaMessage.thumbData = C5730e.m8632e(str, 0, -1);
            } else {
                C4990ab.m7416i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
            }
            Req req = new Req();
            req.transaction = null;
            req.message = wXMediaMessage;
            Bundle bundle = new Bundle();
            req.toBundle(bundle);
            bundle.putInt(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
            bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
            c45316cl.cvA.activity = this;
            c45316cl.cvA.cvI = new C307275();
            c45316cl.cvA.cvJ = new C307286();
            this.zAt = c45316cl;
            C1720g.m3540Rg().mo14539a(837, (C1202f) this);
            C1720g.m3540Rg().mo14541a(c37946d, 0);
            showDialog();
            AppMethodBeat.m2505o(34769);
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:58:0x0140=Splitter:B:58:0x0140, B:84:0x01b9=Splitter:B:84:0x01b9, B:71:0x017c=Splitter:B:71:0x017c} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0198 A:{SYNTHETIC, Splitter:B:74:0x0198} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019d A:{Catch:{ Exception -> 0x01a6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a2 A:{Catch:{ Exception -> 0x01a6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d5 A:{SYNTHETIC, Splitter:B:87:0x01d5} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01da A:{Catch:{ Exception -> 0x01e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01df A:{Catch:{ Exception -> 0x01e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01f9 A:{SYNTHETIC, Splitter:B:98:0x01f9} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01fe A:{Catch:{ Exception -> 0x020a }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0203 A:{Catch:{ Exception -> 0x020a }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0198 A:{SYNTHETIC, Splitter:B:74:0x0198} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019d A:{Catch:{ Exception -> 0x01a6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a2 A:{Catch:{ Exception -> 0x01a6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d5 A:{SYNTHETIC, Splitter:B:87:0x01d5} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01da A:{Catch:{ Exception -> 0x01e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01df A:{Catch:{ Exception -> 0x01e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0198 A:{SYNTHETIC, Splitter:B:74:0x0198} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019d A:{Catch:{ Exception -> 0x01a6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a2 A:{Catch:{ Exception -> 0x01a6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d5 A:{SYNTHETIC, Splitter:B:87:0x01d5} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01da A:{Catch:{ Exception -> 0x01e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01df A:{Catch:{ Exception -> 0x01e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01f9 A:{SYNTHETIC, Splitter:B:98:0x01f9} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01fe A:{Catch:{ Exception -> 0x020a }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0203 A:{Catch:{ Exception -> 0x020a }} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01f9 A:{SYNTHETIC, Splitter:B:98:0x01f9} */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01fe A:{Catch:{ Exception -> 0x020a }} */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0203 A:{Catch:{ Exception -> 0x020a }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private String m48967a(Uri uri, Cursor cursor) {
        FileNotFoundException e;
        IOException e2;
        Exception e3;
        Throwable th;
        AppMethodBeat.m2504i(34770);
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                str = cursor.getString(columnIndex);
                if (str != null) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                C4990ab.m7416i("MicroMsg.AddFavoriteUI", "vcard file name: ".concat(String.valueOf(str)));
            }
            cursor.close();
            AssetFileDescriptor openAssetFileDescriptor;
            FileInputStream createInputStream;
            FileOutputStream openFileOutput;
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
                try {
                    createInputStream = openAssetFileDescriptor.createInputStream();
                    try {
                        byte[] bArr = new byte[((int) openAssetFileDescriptor.getDeclaredLength())];
                        if (createInputStream.read(bArr) > 0) {
                            C9638aw.m17190ZK();
                            if (C18628c.isSDCardAvailable()) {
                                String str2 = C6457e.eSn + "share";
                                str = C6457e.eSn + "share/" + str;
                                File file = new File(str2);
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                File file2 = new File(str);
                                if (!file2.exists()) {
                                    file2.createNewFile();
                                }
                                if (C5730e.m8624b(str, bArr, bArr.length) == 0) {
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Exception e4) {
                                            C4990ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e4, e4.getMessage(), new Object[0]);
                                        }
                                    }
                                    if (openAssetFileDescriptor != null) {
                                        openAssetFileDescriptor.close();
                                    }
                                    AppMethodBeat.m2505o(34770);
                                    return str;
                                }
                            }
                            deleteFile(str);
                            openFileOutput = openFileOutput(str, 0);
                            try {
                                openFileOutput.write(bArr);
                                openFileOutput.flush();
                                str = getFilesDir().getPath() + "/" + str;
                                if (createInputStream != null) {
                                    try {
                                        createInputStream.close();
                                    } catch (Exception e42) {
                                        C4990ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e42, e42.getMessage(), new Object[0]);
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                AppMethodBeat.m2505o(34770);
                                return str;
                            } catch (FileNotFoundException e5) {
                                e = e5;
                            } catch (IOException e6) {
                                e2 = e6;
                                C4990ab.m7412e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                                if (createInputStream != null) {
                                }
                                if (openAssetFileDescriptor != null) {
                                }
                                if (openFileOutput != null) {
                                }
                                AppMethodBeat.m2505o(34770);
                                return null;
                            } catch (Exception e7) {
                                e3 = e7;
                                C4990ab.m7412e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e3.getMessage());
                                if (createInputStream != null) {
                                }
                                if (openAssetFileDescriptor != null) {
                                }
                                if (openFileOutput != null) {
                                }
                                AppMethodBeat.m2505o(34770);
                                return null;
                            }
                        }
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Exception e32) {
                                C4990ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e32, e32.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                    } catch (FileNotFoundException e8) {
                        e = e8;
                        openFileOutput = null;
                        try {
                            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                            if (createInputStream != null) {
                                try {
                                    createInputStream.close();
                                } catch (Exception e322) {
                                    C4990ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e322, e322.getMessage(), new Object[0]);
                                }
                            }
                            if (openAssetFileDescriptor != null) {
                                openAssetFileDescriptor.close();
                            }
                            if (openFileOutput != null) {
                                openFileOutput.close();
                            }
                            AppMethodBeat.m2505o(34770);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (createInputStream != null) {
                            }
                            if (openAssetFileDescriptor != null) {
                            }
                            if (openFileOutput != null) {
                            }
                            AppMethodBeat.m2505o(34770);
                            throw th;
                        }
                    } catch (IOException e9) {
                        e2 = e9;
                        openFileOutput = null;
                        C4990ab.m7412e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                        if (createInputStream != null) {
                        }
                        if (openAssetFileDescriptor != null) {
                        }
                        if (openFileOutput != null) {
                        }
                        AppMethodBeat.m2505o(34770);
                        return null;
                    } catch (Exception e10) {
                        e322 = e10;
                        openFileOutput = null;
                        C4990ab.m7412e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e322.getMessage());
                        if (createInputStream != null) {
                        }
                        if (openAssetFileDescriptor != null) {
                        }
                        if (openFileOutput != null) {
                        }
                        AppMethodBeat.m2505o(34770);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        openFileOutput = null;
                        if (createInputStream != null) {
                        }
                        if (openAssetFileDescriptor != null) {
                        }
                        if (openFileOutput != null) {
                        }
                        AppMethodBeat.m2505o(34770);
                        throw th;
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    openFileOutput = null;
                    createInputStream = null;
                } catch (IOException e12) {
                    e2 = e12;
                    openFileOutput = null;
                    createInputStream = null;
                    C4990ab.m7412e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                    if (createInputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (openFileOutput != null) {
                    }
                    AppMethodBeat.m2505o(34770);
                    return null;
                } catch (Exception e13) {
                    e322 = e13;
                    openFileOutput = null;
                    createInputStream = null;
                    C4990ab.m7412e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e322.getMessage());
                    if (createInputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (openFileOutput != null) {
                    }
                    AppMethodBeat.m2505o(34770);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    openFileOutput = null;
                    createInputStream = null;
                    if (createInputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (openFileOutput != null) {
                    }
                    AppMethodBeat.m2505o(34770);
                    throw th;
                }
            } catch (FileNotFoundException e14) {
                e = e14;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
            } catch (IOException e15) {
                e2 = e15;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                C4990ab.m7412e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                if (createInputStream != null) {
                    try {
                        createInputStream.close();
                    } catch (Exception e3222) {
                        C4990ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e3222, e3222.getMessage(), new Object[0]);
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                AppMethodBeat.m2505o(34770);
                return null;
            } catch (Exception e16) {
                e3222 = e16;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                C4990ab.m7412e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e3222.getMessage());
                if (createInputStream != null) {
                    try {
                        createInputStream.close();
                    } catch (Exception e32222) {
                        C4990ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e32222, e32222.getMessage(), new Object[0]);
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                AppMethodBeat.m2505o(34770);
                return null;
            } catch (Throwable th5) {
                th = th5;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                if (createInputStream != null) {
                    try {
                        createInputStream.close();
                    } catch (Exception e422) {
                        C4990ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e422, e422.getMessage(), new Object[0]);
                        AppMethodBeat.m2505o(34770);
                        throw th;
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                AppMethodBeat.m2505o(34770);
                throw th;
            }
        }
        AppMethodBeat.m2505o(34770);
        return null;
    }

    private static int asc(String str) {
        AppMethodBeat.m2504i(34771);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
            AppMethodBeat.m2505o(34771);
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.contains("image") || toLowerCase.equals("application/vnd.google.panorama360+jpg")) {
            AppMethodBeat.m2505o(34771);
            return 2;
        } else if (toLowerCase.contains("video")) {
            AppMethodBeat.m2505o(34771);
            return 4;
        } else {
            C4990ab.m7410d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
            AppMethodBeat.m2505o(34771);
            return 8;
        }
    }

    private void dJw() {
        AppMethodBeat.m2504i(34772);
        m48965PI(0);
        Toast.makeText(this, C25738R.string.eh8, 1).show();
        AppMethodBeat.m2505o(34772);
    }

    /* renamed from: PI */
    private void m48965PI(int i) {
        AppMethodBeat.m2504i(34773);
        switch (i) {
            case 1:
                Toast.makeText(this, C25738R.string.eh5, 1).show();
                AppMethodBeat.m2505o(34773);
                return;
            default:
                Toast.makeText(this, C25738R.string.eh8, 1).show();
                AppMethodBeat.m2505o(34773);
                return;
        }
    }

    private void showDialog() {
        AppMethodBeat.m2504i(34774);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C307297());
        AppMethodBeat.m2505o(34774);
    }

    private void dismissDialog() {
        AppMethodBeat.m2504i(34775);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(34775);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(34776);
        C4990ab.m7417i("MicroMsg.AddFavoriteUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        dismissDialog();
        if (c1207m instanceof C37946d) {
            if (i == 0 && i2 == 0) {
                if (this.zAt != null) {
                    C4879a.xxA.mo10055m(this.zAt);
                    this.zAt = null;
                    AppMethodBeat.m2505o(34776);
                    return;
                }
            } else if (c1207m.ftl != null) {
                C35949rt c35949rt = (C35949rt) ((C7472b) c1207m.ftl).fsH.fsP;
                if (c35949rt != null && !C5046bo.isNullOrNil(c35949rt.vZf)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", c35949rt.vZf);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                    finish();
                    AppMethodBeat.m2505o(34776);
                    return;
                } else if (this.zAt != null) {
                    C4879a.xxA.mo10055m(this.zAt);
                    this.zAt = null;
                }
            }
        }
        AppMethodBeat.m2505o(34776);
    }

    public final void initView() {
        AppMethodBeat.m2504i(34765);
        this.intent = getIntent();
        if (this.intent == null) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
            dJw();
            finish();
            AppMethodBeat.m2505o(34765);
            return;
        }
        String action = this.intent.getAction();
        Bundle aM = C5068w.m7684aM(this.intent);
        if (C5046bo.isNullOrNil(action)) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
            dJw();
            finish();
            AppMethodBeat.m2505o(34765);
            return;
        }
        if (aM != null) {
            Parcelable parcelable = aM.getParcelable("android.intent.extra.STREAM");
            if (parcelable instanceof Uri) {
                this.uri = (Uri) parcelable;
                if (!C5046bo.m7585v(this.uri)) {
                    C4990ab.m7413e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", this.uri);
                    dJw();
                    finish();
                    AppMethodBeat.m2505o(34765);
                    return;
                }
            } else if (parcelable != null) {
                C4990ab.m7413e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", parcelable);
                dJw();
                finish();
                AppMethodBeat.m2505o(34765);
                return;
            }
        }
        if (action.equals("android.intent.action.SEND")) {
            C4990ab.m7416i("MicroMsg.AddFavoriteUI", "send signal: ".concat(String.valueOf(action)));
            if (this.uri == null) {
                showDialog();
                C7305d.post(new C55571(), "AddFavoriteUI_dealWithTextHandler");
                AppMethodBeat.m2505o(34765);
                return;
            }
            showDialog();
            C7305d.post(new C30733a(this.uri, new C55608()), "AddFavoriteUI_getFilePath");
            AppMethodBeat.m2505o(34765);
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && aM != null && aM.containsKey("android.intent.extra.STREAM")) {
            C4990ab.m7417i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", action, getIntent().resolveType(this));
            if (C5046bo.m7532bc(getIntent().resolveType(this), "").contains("image")) {
                this.zAu = m48969aB(aM);
                if (this.zAu == null || this.zAu.size() == 0) {
                    C4990ab.m7412e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
                    m48965PI(1);
                    finish();
                    AppMethodBeat.m2505o(34765);
                    return;
                }
                showDialog();
                C7305d.post(new C159169(), "AddFavoriteUI_dealWithMultiItemHandler");
                AppMethodBeat.m2505o(34765);
                return;
            }
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
            m48965PI(1);
            finish();
            AppMethodBeat.m2505o(34765);
        } else {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
            dJw();
            finish();
            AppMethodBeat.m2505o(34765);
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m48975f(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.m2504i(34779);
        C4990ab.m7417i("MicroMsg.AddFavoriteUI", "filepath:[%s]", addFavoriteUI.filePath);
        int asc = AddFavoriteUI.asc(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (asc == -1) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            AppMethodBeat.m2505o(34779);
            return;
        }
        C4990ab.m7417i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithMultiItem msgType is %d", addFavoriteUI.filePath, Integer.valueOf(asc));
        ArrayList arrayList;
        if (asc == 8 && !C5046bo.isNullOrNil(addFavoriteUI.filePath)) {
            addFavoriteUI.m48971bO(asc, addFavoriteUI.filePath);
            AppMethodBeat.m2505o(34779);
        } else if (C5068w.m7683a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            Intent intent = new Intent(addFavoriteUI, AddFavoriteUI.class);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            if (C5046bo.m7548ek(addFavoriteUI.zAu)) {
                arrayList = new ArrayList(0);
            } else {
                ArrayList arrayList2 = new ArrayList(addFavoriteUI.zAu.size());
                Iterator it = addFavoriteUI.zAu.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Uri.fromFile(new File((String) it.next())));
                }
                arrayList = arrayList2;
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.addFlags(268435456).addFlags(32768);
            intent.setType(addFavoriteUI.getIntent().getType());
            MMWizardActivity.m23792b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
            addFavoriteUI.finish();
            AppMethodBeat.m2505o(34779);
        } else {
            C45316cl c45316cl = new C45316cl();
            ArrayList<String> arrayList3 = addFavoriteUI.zAu;
            if (arrayList3 == null || arrayList3.isEmpty()) {
                C4990ab.m7420w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or paths is empty");
                c45316cl.cvA.cvG = C25738R.string.boh;
            } else if (arrayList3.size() > 9) {
                c45316cl.cvA.cvG = C25738R.string.boo;
            } else {
                C4990ab.m7417i("MicroMsg.GetFavDataSource", "do fill event info(fav simple images), paths %s sourceType %d", arrayList3, Integer.valueOf(13));
                abf abf = new abf();
                abl abl = new abl();
                for (String str : arrayList3) {
                    if (!C5046bo.isNullOrNil(str)) {
                        aar aar = new aar();
                        aar.mo27394LE(2);
                        aar.akV(str);
                        aar.mo27435oY(true);
                        abf.wiv.add(aar);
                    }
                }
                abl.alD(C1853r.m3846Yz());
                abl.alE(C1853r.m3846Yz());
                abl.mo39126LN(13);
                abl.mo39136ml(C5046bo.anU());
                abf.mo74737a(abl);
                c45316cl.cvA.title = "";
                c45316cl.cvA.cvC = abf;
                c45316cl.cvA.type = 2;
            }
            c45316cl.cvA.activity = addFavoriteUI;
            c45316cl.cvA.cvI = new C2402213();
            c45316cl.cvA.cvJ = new C3073114();
            C9638aw.m17182Rg().mo14539a(837, (C1202f) addFavoriteUI);
            C1720g.m3540Rg().mo14541a(new C37946d(1, addFavoriteUI.zAu, addFavoriteUI.dyh()), 0);
            addFavoriteUI.showDialog();
            addFavoriteUI.zAt = c45316cl;
            AppMethodBeat.m2505o(34779);
        }
    }

    static /* synthetic */ boolean asd(String str) {
        AppMethodBeat.m2504i(34780);
        boolean amn = C5063r.amn(str);
        AppMethodBeat.m2505o(34780);
        return amn;
    }

    /* renamed from: h */
    static /* synthetic */ void m48977h(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.m2504i(34782);
        C4990ab.m7417i("MicroMsg.AddFavoriteUI", "filepath:[%s]", addFavoriteUI.filePath);
        int asc = AddFavoriteUI.asc(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (asc == -1) {
            C4990ab.m7412e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            AppMethodBeat.m2505o(34782);
            return;
        }
        C4990ab.m7417i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithSimpleItem msgType is %d", addFavoriteUI.filePath, Integer.valueOf(asc));
        if (!C5046bo.isNullOrNil(addFavoriteUI.filePath)) {
            addFavoriteUI.m48971bO(asc, addFavoriteUI.filePath);
            AppMethodBeat.m2505o(34782);
        } else if (C5068w.m7683a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            addFavoriteUI.finish();
            addFavoriteUI.dJu();
            AppMethodBeat.m2505o(34782);
        } else {
            C45316cl c45316cl = new C45316cl();
            C40443e.m69368a(c45316cl, 13, addFavoriteUI.filePath);
            c45316cl.cvA.activity = addFavoriteUI;
            c45316cl.cvA.cvI = new C3073215();
            c45316cl.cvA.cvJ = new C55582();
            C4879a.xxA.mo10055m(c45316cl);
            AppMethodBeat.m2505o(34782);
        }
    }
}
