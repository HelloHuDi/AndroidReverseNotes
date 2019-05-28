package com.tencent.p177mm.p612ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.widget.Toast;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C26475z;
import com.tencent.p177mm.modelsimple.C37946d;
import com.tencent.p177mm.opensdk.constants.Build;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p612ui.transmit.SelectConversationUI;
import com.tencent.p177mm.p612ui.transmit.SelectNoSupportUI;
import com.tencent.p177mm.p612ui.transmit.SendAppMessageWrapperUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p275ui.SimpleLoginUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1082i.C14864e;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity;
import com.tencent.p177mm.pluginsdk.p597ui.AutoLoginActivity.C4737a;
import com.tencent.p177mm.protocal.protobuf.C35949rt;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.rtmp.TXLivePushConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
/* renamed from: com.tencent.mm.ui.tools.ShareImgUI */
public class ShareImgUI extends AutoLoginActivity implements C1202f {
    private ProgressDialog ehJ = null;
    String filePath = null;
    private C7306ak handler = new C159323();
    private Intent intent = null;
    Uri uri = null;
    ArrayList<String> zAu = null;
    Intent zHq = null;

    /* renamed from: com.tencent.mm.ui.tools.ShareImgUI$1 */
    class C159301 implements C15940c {
        C159301() {
        }

        public final void dJx() {
            AppMethodBeat.m2504i(34935);
            ShareImgUI.this.handler.sendEmptyMessage(0);
            AppMethodBeat.m2505o(34935);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShareImgUI$2 */
    class C159312 implements C15939b {
        C159312() {
        }

        /* renamed from: aq */
        public final void mo28177aq(ArrayList<String> arrayList) {
            AppMethodBeat.m2504i(34936);
            ShareImgUI.this.zAu = arrayList;
            if (ShareImgUI.this.zAu == null || ShareImgUI.this.zAu.size() == 0) {
                C4990ab.m7412e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
                ShareImgUI.m24239b(ShareImgUI.this);
                ShareImgUI.this.finish();
                AppMethodBeat.m2505o(34936);
                return;
            }
            Iterator it = ShareImgUI.this.zAu.iterator();
            while (it.hasNext()) {
                if (C5063r.amo((String) it.next())) {
                    C4990ab.m7417i("MicroMsg.ShareImgUI", "%s is not image", (String) it.next());
                    ShareImgUI.m24239b(ShareImgUI.this);
                    ShareImgUI.this.finish();
                    AppMethodBeat.m2505o(34936);
                    return;
                }
            }
            String resolveType = ShareImgUI.this.getIntent().resolveType(ShareImgUI.this);
            if (resolveType == null || !resolveType.contains("image")) {
                C4990ab.m7416i("MicroMsg.ShareImgUI", "mime type is not image, try to set it");
                ShareImgUI.this.getIntent().setDataAndType(ShareImgUI.this.getIntent().getData(), "image/*");
            }
            ShareImgUI.m24240c(ShareImgUI.this);
            AppMethodBeat.m2505o(34936);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShareImgUI$3 */
    class C159323 extends C7306ak {
        C159323() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(34937);
            if (C5046bo.isNullOrNil(ShareImgUI.this.filePath)) {
                C4990ab.m7412e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
                ShareImgUI.m24241d(ShareImgUI.this);
                ShareImgUI.this.finish();
                AppMethodBeat.m2505o(34937);
                return;
            }
            ShareImgUI.m24240c(ShareImgUI.this);
            AppMethodBeat.m2505o(34937);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShareImgUI$a */
    class C15933a implements Runnable {
        private Uri mUri;
        private C15940c zHA;

        public C15933a(Uri uri, C15940c c15940c) {
            this.mUri = uri;
            this.zHA = c15940c;
        }

        public final void run() {
            AppMethodBeat.m2504i(34943);
            ShareImgUI.this.filePath = ShareImgUI.m24234a(ShareImgUI.this, this.mUri);
            if (C5046bo.isNullOrNil(ShareImgUI.this.filePath) || !new C5728b(ShareImgUI.this.filePath).exists()) {
                if (ShareImgUI.ask(ShareImgUI.this.getContentResolver().getType(this.mUri)) == 3) {
                    ShareImgUI.this.filePath = C14864e.m23125a(ShareImgUI.this.getContentResolver(), this.mUri);
                } else {
                    ShareImgUI.this.filePath = C14864e.m23126a(ShareImgUI.this.getContentResolver(), this.mUri, 1);
                }
            }
            if (this.zHA != null) {
                this.zHA.dJx();
            }
            AppMethodBeat.m2505o(34943);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShareImgUI$6 */
    class C159376 implements OnCancelListener {
        C159376() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(34941);
            ShareImgUI.this.finish();
            AppMethodBeat.m2505o(34941);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShareImgUI$b */
    interface C15939b {
        /* renamed from: aq */
        void mo28177aq(ArrayList<String> arrayList);
    }

    /* renamed from: com.tencent.mm.ui.tools.ShareImgUI$c */
    public interface C15940c {
        void dJx();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ShareImgUI() {
        AppMethodBeat.m2504i(34944);
        AppMethodBeat.m2505o(34944);
    }

    static /* synthetic */ int ask(String str) {
        AppMethodBeat.m2504i(34965);
        int asc = ShareImgUI.asc(str);
        AppMethodBeat.m2505o(34965);
        return asc;
    }

    /* renamed from: b */
    static /* synthetic */ void m24239b(ShareImgUI shareImgUI) {
        AppMethodBeat.m2504i(34959);
        shareImgUI.m24231PI(1);
        AppMethodBeat.m2505o(34959);
    }

    /* renamed from: O */
    public final boolean mo6736O(Intent intent) {
        return true;
    }

    public final boolean bVD() {
        AppMethodBeat.m2504i(34945);
        if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            C4990ab.m7420w("MicroMsg.ShareImgUI", "not login");
            this.intent = getIntent();
            asS();
            AppMethodBeat.m2505o(34945);
            return true;
        }
        AppMethodBeat.m2505o(34945);
        return false;
    }

    /* renamed from: a */
    public final void mo6737a(C4737a c4737a, Intent intent) {
        AppMethodBeat.m2504i(34946);
        switch (c4737a) {
            case LOGIN_OK:
                this.intent = intent;
                C4990ab.m7417i("MicroMsg.ShareImgUI", "now permission = %d", Integer.valueOf(C5046bo.getInt(C26373g.m41964Nu().getValue("SystemShareControlBitset"), 0)));
                if ((C5046bo.getInt(C26373g.m41964Nu().getValue("SystemShareControlBitset"), 0) & 1) > 0) {
                    C4990ab.m7412e("MicroMsg.ShareImgUI", "now allowed to share to friend");
                    finish();
                    AppMethodBeat.m2505o(34946);
                    return;
                }
                C4990ab.m7417i("MicroMsg.ShareImgUI", "postLogin, text = %s", C5068w.m7689n(intent, "android.intent.extra.TEXT"));
                if (C5046bo.isNullOrNil(C5068w.m7689n(intent, "android.intent.extra.TEXT"))) {
                    asS();
                    AppMethodBeat.m2505o(34946);
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                C9638aw.m17182Rg().mo14539a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (C1202f) this);
                C9638aw.m17182Rg().mo14541a(new C26475z(format, 15, null), 0);
                AppMethodBeat.m2505o(34946);
                return;
            default:
                finish();
                C5274b.m8054hM(this);
                AppMethodBeat.m2505o(34946);
                return;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34947);
        C9638aw.m17182Rg().mo14546b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(837, (C1202f) this);
        dismissDialog();
        super.onDestroy();
        AppMethodBeat.m2505o(34947);
    }

    private void asS() {
        AppMethodBeat.m2504i(34948);
        if (this.intent == null) {
            C4990ab.m7412e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
            m24231PI(0);
            finish();
            AppMethodBeat.m2505o(34948);
            return;
        }
        String action = this.intent.getAction();
        Bundle extras = this.intent.getExtras();
        if (C5046bo.isNullOrNil(action)) {
            C4990ab.m7412e("MicroMsg.ShareImgUI", "launch : fail, action is null");
            m24231PI(0);
            finish();
            AppMethodBeat.m2505o(34948);
            return;
        }
        if (extras != null) {
            Parcelable parcelable = extras.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                this.uri = (Uri) parcelable;
                if (!C5046bo.m7585v(this.uri)) {
                    C4990ab.m7413e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", this.uri);
                    m24231PI(0);
                    finish();
                    AppMethodBeat.m2505o(34948);
                    return;
                }
            }
        }
        showDialog();
        if (action.equals("android.intent.action.SEND")) {
            C4990ab.m7416i("MicroMsg.ShareImgUI", "send signal: ".concat(String.valueOf(action)));
            if (this.uri == null) {
                C4990ab.m7417i("MicroMsg.ShareImgUI", "dealWithText: %b", Boolean.valueOf(m24238aY(getIntent())));
                if (!m24238aY(getIntent())) {
                    m24231PI(0);
                    finish();
                }
                AppMethodBeat.m2505o(34948);
                return;
            }
            C7305d.post(new C15933a(this.uri, new C159301()), "ShareImgUI_getFilePath");
            AppMethodBeat.m2505o(34948);
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && extras != null && extras.containsKey("android.intent.extra.STREAM")) {
            C4990ab.m7416i("MicroMsg.ShareImgUI", "send multi: ".concat(String.valueOf(action)));
            m24235a(extras, new C159312());
            AppMethodBeat.m2505o(34948);
        } else {
            C4990ab.m7412e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
            m24231PI(0);
            finish();
            AppMethodBeat.m2505o(34948);
        }
    }

    private boolean dJU() {
        AppMethodBeat.m2504i(34949);
        Intent intent = new Intent(this, ShareImgUI.class);
        if ("android.intent.action.SEND".equals(getIntent().getAction())) {
            if (C5046bo.isNullOrNil(this.filePath)) {
                AppMethodBeat.m2505o(34949);
                return false;
            }
            intent.putExtra("android.intent.extra.STREAM", C5730e.asY(this.filePath));
            intent.setAction("android.intent.action.SEND");
            intent.setType(getIntent().getType());
        } else if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction())) {
            AppMethodBeat.m2505o(34949);
            return false;
        } else if (C5046bo.m7548ek(this.zAu)) {
            AppMethodBeat.m2505o(34949);
            return false;
        } else {
            ArrayList arrayList = new ArrayList(this.zAu.size());
            Iterator it = this.zAu.iterator();
            while (it.hasNext()) {
                arrayList.add(C5730e.asY((String) it.next()));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.setType(getIntent().getType());
        }
        intent.addFlags(67108864);
        MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        AppMethodBeat.m2505o(34949);
        return true;
    }

    /* renamed from: a */
    private void m24235a(Bundle bundle, C15939b c15939b) {
        AppMethodBeat.m2504i(34950);
        final long currentTimeMillis = System.currentTimeMillis();
        final Bundle bundle2 = bundle;
        final C15939b c15939b2 = c15939b;
        C7305d.post(new Runnable() {
            /* JADX WARNING: Missing block: B:18:0x00aa, code skipped:
            if (r2.size() > 0) goto L_0x006f;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.m2504i(34939);
                ArrayList parcelableArrayList = bundle2.getParcelableArrayList("android.intent.extra.STREAM");
                if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                    C4990ab.m7412e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
                    ShareImgUI.m24236a(ShareImgUI.this, c15939b2, null);
                    AppMethodBeat.m2505o(34939);
                    return;
                }
                ShareImgUI shareImgUI;
                C15939b c15939b;
                final ArrayList arrayList = new ArrayList();
                final CountDownLatch countDownLatch = new CountDownLatch(parcelableArrayList.size());
                final boolean[] zArr = new boolean[]{false};
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    final Parcelable parcelable = (Parcelable) it.next();
                    C7305d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(34938);
                            if (!ShareImgUI.m24237a(ShareImgUI.this, arrayList, parcelable)) {
                                zArr[0] = true;
                            }
                            countDownLatch.countDown();
                            AppMethodBeat.m2505o(34938);
                        }
                    }, "getMultiSendFilePathListItem" + parcelable.toString());
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    C4990ab.printErrStackTrace("MicroMsg.ShareImgUI", e, "hy: timeout when getmulti", new Object[0]);
                    ShareImgUI.m24236a(ShareImgUI.this, c15939b2, null);
                }
                if (zArr[0]) {
                    C4990ab.m7410d("MicroMsg.ShareImgUI", "hy: has non path img");
                    shareImgUI = ShareImgUI.this;
                    c15939b = c15939b2;
                } else {
                    C4990ab.m7417i("MicroMsg.ShareImgUI", "hy: getMultiSendFilePathList done. using: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    shareImgUI = ShareImgUI.this;
                    c15939b = c15939b2;
                }
                arrayList = null;
                ShareImgUI.m24236a(shareImgUI, c15939b, arrayList);
                AppMethodBeat.m2505o(34939);
            }
        }, "getMultiSendFilePathList");
        AppMethodBeat.m2505o(34950);
    }

    /* renamed from: aY */
    private boolean m24238aY(Intent intent) {
        AppMethodBeat.m2504i(34951);
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.ShareImgUI", "intent is null");
            AppMethodBeat.m2505o(34951);
            return false;
        }
        String n = C5068w.m7689n(intent, "android.intent.extra.TEXT");
        String n2 = C5068w.m7689n(intent, "android.intent.extra.SUBJECT");
        if (n == null || n.length() == 0) {
            C4990ab.m7416i("MicroMsg.ShareImgUI", "text is null");
            AppMethodBeat.m2505o(34951);
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(n));
        wXMediaMessage.description = n;
        Req req = new Req();
        req.transaction = null;
        req.message = wXMediaMessage;
        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        bundle.putInt(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
        Intent intent2 = new Intent();
        intent2.setClass(this, SelectConversationUI.class);
        intent2.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
        if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
            C4990ab.m7420w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
            MMWizardActivity.m23792b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
        } else {
            C9638aw.m17182Rg().mo14539a(837, (C1202f) this);
            ArrayList arrayList = new ArrayList();
            arrayList.add(n2 + "|" + n);
            C1720g.m3540Rg().mo14541a(new C37946d(5, arrayList, dyh()), 0);
            showDialog();
            this.zHq = intent2;
        }
        AppMethodBeat.m2505o(34951);
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:60:0x0143=Splitter:B:60:0x0143, B:72:0x0175=Splitter:B:72:0x0175, B:33:0x00b9=Splitter:B:33:0x00b9} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f A:{SYNTHETIC, Splitter:B:63:0x015f} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0164 A:{Catch:{ Exception -> 0x016e }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0169 A:{Catch:{ Exception -> 0x016e }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019b A:{SYNTHETIC, Splitter:B:75:0x019b} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a0 A:{Catch:{ Exception -> 0x01aa }} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a5 A:{Catch:{ Exception -> 0x01aa }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f A:{SYNTHETIC, Splitter:B:63:0x015f} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0164 A:{Catch:{ Exception -> 0x016e }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0169 A:{Catch:{ Exception -> 0x016e }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019b A:{SYNTHETIC, Splitter:B:75:0x019b} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a0 A:{Catch:{ Exception -> 0x01aa }} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a5 A:{Catch:{ Exception -> 0x01aa }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b3 A:{SYNTHETIC, Splitter:B:85:0x01b3} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b8 A:{Catch:{ Exception -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01bd A:{Catch:{ Exception -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b3 A:{SYNTHETIC, Splitter:B:85:0x01b3} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b8 A:{Catch:{ Exception -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01bd A:{Catch:{ Exception -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d5 A:{SYNTHETIC, Splitter:B:36:0x00d5} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00da A:{Catch:{ Exception -> 0x01e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00df A:{Catch:{ Exception -> 0x01e4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015f A:{SYNTHETIC, Splitter:B:63:0x015f} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0164 A:{Catch:{ Exception -> 0x016e }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0169 A:{Catch:{ Exception -> 0x016e }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019b A:{SYNTHETIC, Splitter:B:75:0x019b} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a0 A:{Catch:{ Exception -> 0x01aa }} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a5 A:{Catch:{ Exception -> 0x01aa }} */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01b3 A:{SYNTHETIC, Splitter:B:85:0x01b3} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b8 A:{Catch:{ Exception -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01bd A:{Catch:{ Exception -> 0x01c4 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private String m24233a(Uri uri, Cursor cursor) {
        AssetFileDescriptor openAssetFileDescriptor;
        FileNotFoundException e;
        OutputStream outputStream;
        InputStream inputStream;
        IOException e2;
        Exception e3;
        Throwable th;
        AppMethodBeat.m2504i(34952);
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                try {
                    str = cursor.getString(columnIndex);
                } catch (Exception e4) {
                    C4990ab.m7421w("MicroMsg.ShareImgUI", "try to get Vcard Name fail: %s", e4.getMessage());
                }
                if (!(str == null || str == null)) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                C4990ab.m7416i("MicroMsg.ShareImgUI", "vcard file name: ".concat(String.valueOf(str)));
            }
            cursor.close();
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException e5) {
                e = e5;
                outputStream = null;
                openAssetFileDescriptor = null;
                inputStream = null;
            } catch (IOException e6) {
                e2 = e6;
                outputStream = null;
                openAssetFileDescriptor = null;
                inputStream = null;
                C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (inputStream != null) {
                }
                if (openAssetFileDescriptor != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(34952);
                return null;
            } catch (Exception e7) {
                e3 = e7;
                outputStream = null;
                openAssetFileDescriptor = null;
                inputStream = null;
                C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                C4990ab.m7412e("MicroMsg.ShareImgUI", e3.toString());
                if (inputStream != null) {
                }
                if (openAssetFileDescriptor != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(34952);
                return null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                openAssetFileDescriptor = null;
                inputStream = null;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e8) {
                        AppMethodBeat.m2505o(34952);
                        throw th;
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                AppMethodBeat.m2505o(34952);
                throw th;
            }
            try {
                inputStream = openAssetFileDescriptor.createInputStream();
                try {
                    C9638aw.m17190ZK();
                    if (C18628c.isSDCardAvailable()) {
                        String str2 = C6457e.eSn + "share";
                        str = C6457e.eSn + "share/" + str;
                        C5728b c5728b = new C5728b(str2);
                        if (!c5728b.exists()) {
                            c5728b.mkdirs();
                        }
                        C5728b c5728b2 = new C5728b(str);
                        if (!c5728b2.exists()) {
                            c5728b2.createNewFile();
                        }
                        outputStream = C5730e.m8617L(str, false);
                    } else {
                        deleteFile(str);
                        String str3 = getFilesDir().getPath() + "/" + str;
                        outputStream = openFileOutput(str, 0);
                        str = str3;
                    }
                } catch (FileNotFoundException e9) {
                    e = e9;
                    outputStream = null;
                    try {
                        C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                        if (inputStream != null) {
                        }
                        if (openAssetFileDescriptor != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(34952);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                        }
                        if (openAssetFileDescriptor != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.m2505o(34952);
                        throw th;
                    }
                } catch (IOException e10) {
                    e2 = e10;
                    outputStream = null;
                    C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (inputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(34952);
                    return null;
                } catch (Exception e11) {
                    e3 = e11;
                    outputStream = null;
                    C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    C4990ab.m7412e("MicroMsg.ShareImgUI", e3.toString());
                    if (inputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(34952);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = null;
                    if (inputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.m2505o(34952);
                    throw th;
                }
            } catch (FileNotFoundException e12) {
                e = e12;
                outputStream = null;
                inputStream = null;
            } catch (IOException e13) {
                e2 = e13;
                outputStream = null;
                inputStream = null;
                C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (inputStream != null) {
                }
                if (openAssetFileDescriptor != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(34952);
                return null;
            } catch (Exception e14) {
                e3 = e14;
                outputStream = null;
                inputStream = null;
                C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                C4990ab.m7412e("MicroMsg.ShareImgUI", e3.toString());
                if (inputStream != null) {
                }
                if (openAssetFileDescriptor != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(34952);
                return null;
            } catch (Throwable th5) {
                th = th5;
                outputStream = null;
                inputStream = null;
                if (inputStream != null) {
                }
                if (openAssetFileDescriptor != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.m2505o(34952);
                throw th;
            }
            try {
                byte[] bArr = new byte[5120];
                while (true) {
                    int read = inputStream.read(bArr, 0, 5120);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                outputStream.flush();
                outputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e15) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                AppMethodBeat.m2505o(34952);
                return str;
            } catch (FileNotFoundException e16) {
                e = e16;
                C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e17) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                AppMethodBeat.m2505o(34952);
                return null;
            } catch (IOException e18) {
                e2 = e18;
                C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e19) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                AppMethodBeat.m2505o(34952);
                return null;
            } catch (Exception e20) {
                e3 = e20;
                C4990ab.m7412e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                C4990ab.m7412e("MicroMsg.ShareImgUI", e3.toString());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e21) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                AppMethodBeat.m2505o(34952);
                return null;
            }
        }
        AppMethodBeat.m2505o(34952);
        return null;
    }

    private static int asc(String str) {
        AppMethodBeat.m2504i(34953);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.ShareImgUI", "map : mimeType is null");
            AppMethodBeat.m2505o(34953);
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equalsIgnoreCase("image/gif")) {
            AppMethodBeat.m2505o(34953);
            return 5;
        } else if (toLowerCase.contains("image")) {
            AppMethodBeat.m2505o(34953);
            return 0;
        } else if (toLowerCase.contains("video")) {
            AppMethodBeat.m2505o(34953);
            return 1;
        } else {
            C4990ab.m7410d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
            AppMethodBeat.m2505o(34953);
            return 3;
        }
    }

    /* renamed from: PI */
    private void m24231PI(int i) {
        AppMethodBeat.m2504i(34954);
        switch (i) {
            case 1:
                Toast.makeText(this, C25738R.string.eh5, 1).show();
                AppMethodBeat.m2505o(34954);
                return;
            default:
                Toast.makeText(this, C25738R.string.eh8, 1).show();
                AppMethodBeat.m2505o(34954);
                return;
        }
    }

    private void dJV() {
        AppMethodBeat.m2504i(34955);
        Toast.makeText(this, C25738R.string.b9x, 1).show();
        finish();
        AppMethodBeat.m2505o(34955);
    }

    private void showDialog() {
        AppMethodBeat.m2504i(34956);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new C159376());
        AppMethodBeat.m2505o(34956);
    }

    private void dismissDialog() {
        AppMethodBeat.m2504i(34957);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.m2505o(34957);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(34958);
        C4990ab.m7417i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        dismissDialog();
        if (c1207m instanceof C26475z) {
            if (i == 0 && i2 == 0) {
                asS();
            } else {
                finish();
            }
        }
        if (c1207m instanceof C37946d) {
            if (!(i == 0 && i2 == 0)) {
                if (c1207m.ftl != null) {
                    C35949rt c35949rt = (C35949rt) ((C7472b) c1207m.ftl).fsH.fsP;
                    if (!(c35949rt == null || C5046bo.isNullOrNil(c35949rt.vZf))) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", c35949rt.vZf);
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("needRedirect", false);
                        C25985d.m41467b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
                finish();
            }
            startActivity(this.zHq);
            finish();
        }
        AppMethodBeat.m2505o(34958);
    }

    /* renamed from: c */
    static /* synthetic */ void m24240c(ShareImgUI shareImgUI) {
        AppMethodBeat.m2504i(34960);
        Intent intent = shareImgUI.getIntent();
        int asc = ShareImgUI.asc(intent.resolveType(shareImgUI));
        if (asc == 0 && C5063r.amo(shareImgUI.filePath)) {
            C4990ab.m7416i("MicroMsg.ShareImgUI", "fix msg type to emoji.");
            asc = 5;
        }
        C4990ab.m7417i("MicroMsg.ShareImgUI", "filepath:[%s], msgType:%d", shareImgUI.filePath, Integer.valueOf(asc));
        if (asc == -1) {
            C4990ab.m7412e("MicroMsg.ShareImgUI", "launch, msgType is invalid");
            shareImgUI.finish();
            AppMethodBeat.m2505o(34960);
        } else if (shareImgUI.zAu != null && asc == 0 && shareImgUI.zAu.size() > 9) {
            intent.setClass(shareImgUI, SelectNoSupportUI.class);
            intent.putExtra("sharePictureTo", "friend");
            intent.addFlags(268435456).addFlags(67108864);
            shareImgUI.zHq = intent;
            shareImgUI.startActivity(shareImgUI.zHq);
            shareImgUI.finish();
            AppMethodBeat.m2505o(34960);
        } else if (C5046bo.isNullOrNil(shareImgUI.filePath) || !C5046bo.anx(shareImgUI.filePath) || C5063r.amn(shareImgUI.filePath)) {
            if (asc == 5 && !C5046bo.isNullOrNil(shareImgUI.filePath)) {
                if (C5730e.asZ(shareImgUI.filePath) > ((long) C42164b.m74340Nb())) {
                    C7060h.pYm.mo8381e(13459, Long.valueOf(r2), Integer.valueOf(1), "", Integer.valueOf(2));
                    shareImgUI.dJV();
                    AppMethodBeat.m2505o(34960);
                    return;
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                if ((C5056d.decodeFile(shareImgUI.filePath, options) != null && options.outHeight > C42164b.m74339Na()) || options.outWidth > C42164b.m74339Na()) {
                    C7060h.pYm.mo8381e(13459, Long.valueOf(r2), Integer.valueOf(1), "", Integer.valueOf(2));
                    shareImgUI.dJV();
                    AppMethodBeat.m2505o(34960);
                    return;
                }
            }
            if (!C5046bo.isNullOrNil(shareImgUI.filePath) && asc == 3) {
                String str = shareImgUI.filePath;
                if (str == null || str.length() == 0) {
                    C4990ab.m7412e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is empty");
                    Toast.makeText(shareImgUI, C25738R.string.eh6, 1).show();
                    shareImgUI.finish();
                    AppMethodBeat.m2505o(34960);
                } else if (C5046bo.anw(str)) {
                    long asZ = C5730e.asZ(str);
                    C4990ab.m7417i("MicroMsg.ShareImgUI", "filelength: [%d]", Long.valueOf(asZ));
                    if (asZ == 0) {
                        C4990ab.m7412e("MicroMsg.ShareImgUI", "dealWithFile fail, fileLength is 0");
                        Toast.makeText(shareImgUI, C25738R.string.eh6, 1).show();
                        shareImgUI.finish();
                        AppMethodBeat.m2505o(34960);
                    } else if (asZ > 10485760) {
                        C4990ab.m7413e("MicroMsg.ShareImgUI", "summerbig dealWithFile fail, fileLength is too large fileLength[%d],filePath[%s] ", Long.valueOf(asZ), str);
                        Toast.makeText(shareImgUI, C25738R.string.eh7, 1).show();
                        shareImgUI.finish();
                        AppMethodBeat.m2505o(34960);
                    } else {
                        IMediaObject wXImageObject;
                        switch (asc) {
                            case 0:
                                wXImageObject = new WXImageObject();
                                ((WXImageObject) wXImageObject).setImagePath(str);
                                break;
                            default:
                                wXImageObject = new WXFileObject(str);
                                break;
                        }
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXImageObject);
                        wXMediaMessage.title = new C5728b(str).getName();
                        wXMediaMessage.description = C5046bo.m7565ga(asZ);
                        Req req = new Req();
                        req.transaction = null;
                        req.message = wXMediaMessage;
                        Bundle bundle = new Bundle();
                        req.toBundle(bundle);
                        bundle.putInt(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                        bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
                        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                        intent = new Intent();
                        intent.setClass(shareImgUI, SelectConversationUI.class);
                        intent.putExtra("Select_Conv_NextStep", new Intent(shareImgUI, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                        if (!C9638aw.m17192ZM() || C9638aw.m17178QT()) {
                            C4990ab.m7420w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                            MMWizardActivity.m23792b(shareImgUI, new Intent(shareImgUI, SimpleLoginUI.class), shareImgUI.getIntent().addFlags(67108864));
                            AppMethodBeat.m2505o(34960);
                            return;
                        }
                        C1720g.m3540Rg().mo14539a(837, (C1202f) shareImgUI);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str);
                        C1720g.m3540Rg().mo14541a(new C37946d(4, arrayList, shareImgUI.dyh()), 0);
                        shareImgUI.showDialog();
                        shareImgUI.zHq = intent;
                        AppMethodBeat.m2505o(34960);
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is refer to private file.");
                    Toast.makeText(shareImgUI, C25738R.string.eh6, 1).show();
                    shareImgUI.finish();
                    AppMethodBeat.m2505o(34960);
                }
            } else if (C5068w.m7683a(shareImgUI.getIntent(), "Intro_Switch", false) || !C9638aw.m17192ZM() || C9638aw.m17178QT()) {
                if (!shareImgUI.dJU()) {
                    shareImgUI.m24231PI(0);
                    shareImgUI.finish();
                }
                AppMethodBeat.m2505o(34960);
            } else {
                C1207m c37946d;
                intent.setData(shareImgUI.uri);
                intent.setClass(shareImgUI, MsgRetransmitUI.class);
                intent.addFlags(268435456).addFlags(67108864);
                intent.putExtra("Retr_File_Name", shareImgUI.filePath);
                intent.putStringArrayListExtra("Retr_File_Path_List", shareImgUI.zAu);
                intent.putExtra("Retr_Msg_Type", asc);
                intent.putExtra("Retr_Scene", 1);
                intent.putExtra("Retr_start_where_you_are", false);
                C9638aw.m17182Rg().mo14539a(837, (C1202f) shareImgUI);
                ArrayList arrayList2 = new ArrayList();
                if (C5046bo.isNullOrNil(shareImgUI.filePath)) {
                    arrayList2.addAll(shareImgUI.zAu);
                } else {
                    arrayList2.add(shareImgUI.filePath);
                }
                if (asc == 1) {
                    c37946d = new C37946d(3, arrayList2, shareImgUI.dyh());
                } else {
                    c37946d = new C37946d(1, arrayList2, shareImgUI.dyh());
                }
                C1720g.m3540Rg().mo14541a(c37946d, 0);
                shareImgUI.showDialog();
                shareImgUI.zHq = intent;
                AppMethodBeat.m2505o(34960);
            }
        } else {
            C4990ab.m7420w("MicroMsg.ShareImgUI", "try to share illegal image.");
            shareImgUI.m24231PI(0);
            shareImgUI.finish();
            AppMethodBeat.m2505o(34960);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m24241d(ShareImgUI shareImgUI) {
        AppMethodBeat.m2504i(34961);
        shareImgUI.m24231PI(0);
        AppMethodBeat.m2505o(34961);
    }
}
