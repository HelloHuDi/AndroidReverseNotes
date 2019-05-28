package com.tencent.mm.ui.tools;

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
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SelectNoSupportUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
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
public class ShareImgUI extends AutoLoginActivity implements f {
    private ProgressDialog ehJ = null;
    String filePath = null;
    private ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(34937);
            if (bo.isNullOrNil(ShareImgUI.this.filePath)) {
                ab.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
                ShareImgUI.d(ShareImgUI.this);
                ShareImgUI.this.finish();
                AppMethodBeat.o(34937);
                return;
            }
            ShareImgUI.c(ShareImgUI.this);
            AppMethodBeat.o(34937);
        }
    };
    private Intent intent = null;
    Uri uri = null;
    ArrayList<String> zAu = null;
    Intent zHq = null;

    class a implements Runnable {
        private Uri mUri;
        private c zHA;

        public a(Uri uri, c cVar) {
            this.mUri = uri;
            this.zHA = cVar;
        }

        public final void run() {
            AppMethodBeat.i(34943);
            ShareImgUI.this.filePath = ShareImgUI.a(ShareImgUI.this, this.mUri);
            if (bo.isNullOrNil(ShareImgUI.this.filePath) || !new com.tencent.mm.vfs.b(ShareImgUI.this.filePath).exists()) {
                if (ShareImgUI.ask(ShareImgUI.this.getContentResolver().getType(this.mUri)) == 3) {
                    ShareImgUI.this.filePath = e.a(ShareImgUI.this.getContentResolver(), this.mUri);
                } else {
                    ShareImgUI.this.filePath = e.a(ShareImgUI.this.getContentResolver(), this.mUri, 1);
                }
            }
            if (this.zHA != null) {
                this.zHA.dJx();
            }
            AppMethodBeat.o(34943);
        }
    }

    interface b {
        void aq(ArrayList<String> arrayList);
    }

    public interface c {
        void dJx();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ShareImgUI() {
        AppMethodBeat.i(34944);
        AppMethodBeat.o(34944);
    }

    static /* synthetic */ int ask(String str) {
        AppMethodBeat.i(34965);
        int asc = asc(str);
        AppMethodBeat.o(34965);
        return asc;
    }

    static /* synthetic */ void b(ShareImgUI shareImgUI) {
        AppMethodBeat.i(34959);
        shareImgUI.PI(1);
        AppMethodBeat.o(34959);
    }

    public final boolean O(Intent intent) {
        return true;
    }

    public final boolean bVD() {
        AppMethodBeat.i(34945);
        if (!aw.ZM() || aw.QT()) {
            ab.w("MicroMsg.ShareImgUI", "not login");
            this.intent = getIntent();
            asS();
            AppMethodBeat.o(34945);
            return true;
        }
        AppMethodBeat.o(34945);
        return false;
    }

    public final void a(com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a aVar, Intent intent) {
        AppMethodBeat.i(34946);
        switch (aVar) {
            case LOGIN_OK:
                this.intent = intent;
                ab.i("MicroMsg.ShareImgUI", "now permission = %d", Integer.valueOf(bo.getInt(g.Nu().getValue("SystemShareControlBitset"), 0)));
                if ((bo.getInt(g.Nu().getValue("SystemShareControlBitset"), 0) & 1) > 0) {
                    ab.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
                    finish();
                    AppMethodBeat.o(34946);
                    return;
                }
                ab.i("MicroMsg.ShareImgUI", "postLogin, text = %s", w.n(intent, "android.intent.extra.TEXT"));
                if (bo.isNullOrNil(w.n(intent, "android.intent.extra.TEXT"))) {
                    asS();
                    AppMethodBeat.o(34946);
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                aw.Rg().a((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (f) this);
                aw.Rg().a(new z(format, 15, null), 0);
                AppMethodBeat.o(34946);
                return;
            default:
                finish();
                com.tencent.mm.ui.base.b.hM(this);
                AppMethodBeat.o(34946);
                return;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(34947);
        aw.Rg().b((int) TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, (f) this);
        aw.Rg().b(837, (f) this);
        dismissDialog();
        super.onDestroy();
        AppMethodBeat.o(34947);
    }

    private void asS() {
        AppMethodBeat.i(34948);
        if (this.intent == null) {
            ab.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
            PI(0);
            finish();
            AppMethodBeat.o(34948);
            return;
        }
        String action = this.intent.getAction();
        Bundle extras = this.intent.getExtras();
        if (bo.isNullOrNil(action)) {
            ab.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
            PI(0);
            finish();
            AppMethodBeat.o(34948);
            return;
        }
        if (extras != null) {
            Parcelable parcelable = extras.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                this.uri = (Uri) parcelable;
                if (!bo.v(this.uri)) {
                    ab.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", this.uri);
                    PI(0);
                    finish();
                    AppMethodBeat.o(34948);
                    return;
                }
            }
        }
        showDialog();
        if (action.equals("android.intent.action.SEND")) {
            ab.i("MicroMsg.ShareImgUI", "send signal: ".concat(String.valueOf(action)));
            if (this.uri == null) {
                ab.i("MicroMsg.ShareImgUI", "dealWithText: %b", Boolean.valueOf(aY(getIntent())));
                if (!aY(getIntent())) {
                    PI(0);
                    finish();
                }
                AppMethodBeat.o(34948);
                return;
            }
            d.post(new a(this.uri, new c() {
                public final void dJx() {
                    AppMethodBeat.i(34935);
                    ShareImgUI.this.handler.sendEmptyMessage(0);
                    AppMethodBeat.o(34935);
                }
            }), "ShareImgUI_getFilePath");
            AppMethodBeat.o(34948);
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && extras != null && extras.containsKey("android.intent.extra.STREAM")) {
            ab.i("MicroMsg.ShareImgUI", "send multi: ".concat(String.valueOf(action)));
            a(extras, new b() {
                public final void aq(ArrayList<String> arrayList) {
                    AppMethodBeat.i(34936);
                    ShareImgUI.this.zAu = arrayList;
                    if (ShareImgUI.this.zAu == null || ShareImgUI.this.zAu.size() == 0) {
                        ab.e("MicroMsg.ShareImgUI", "launch : fail, filePathList is null");
                        ShareImgUI.b(ShareImgUI.this);
                        ShareImgUI.this.finish();
                        AppMethodBeat.o(34936);
                        return;
                    }
                    Iterator it = ShareImgUI.this.zAu.iterator();
                    while (it.hasNext()) {
                        if (r.amo((String) it.next())) {
                            ab.i("MicroMsg.ShareImgUI", "%s is not image", (String) it.next());
                            ShareImgUI.b(ShareImgUI.this);
                            ShareImgUI.this.finish();
                            AppMethodBeat.o(34936);
                            return;
                        }
                    }
                    String resolveType = ShareImgUI.this.getIntent().resolveType(ShareImgUI.this);
                    if (resolveType == null || !resolveType.contains("image")) {
                        ab.i("MicroMsg.ShareImgUI", "mime type is not image, try to set it");
                        ShareImgUI.this.getIntent().setDataAndType(ShareImgUI.this.getIntent().getData(), "image/*");
                    }
                    ShareImgUI.c(ShareImgUI.this);
                    AppMethodBeat.o(34936);
                }
            });
            AppMethodBeat.o(34948);
        } else {
            ab.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
            PI(0);
            finish();
            AppMethodBeat.o(34948);
        }
    }

    private boolean dJU() {
        AppMethodBeat.i(34949);
        Intent intent = new Intent(this, ShareImgUI.class);
        if ("android.intent.action.SEND".equals(getIntent().getAction())) {
            if (bo.isNullOrNil(this.filePath)) {
                AppMethodBeat.o(34949);
                return false;
            }
            intent.putExtra("android.intent.extra.STREAM", com.tencent.mm.vfs.e.asY(this.filePath));
            intent.setAction("android.intent.action.SEND");
            intent.setType(getIntent().getType());
        } else if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction())) {
            AppMethodBeat.o(34949);
            return false;
        } else if (bo.ek(this.zAu)) {
            AppMethodBeat.o(34949);
            return false;
        } else {
            ArrayList arrayList = new ArrayList(this.zAu.size());
            Iterator it = this.zAu.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mm.vfs.e.asY((String) it.next()));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.setType(getIntent().getType());
        }
        intent.addFlags(67108864);
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        AppMethodBeat.o(34949);
        return true;
    }

    private void a(Bundle bundle, b bVar) {
        AppMethodBeat.i(34950);
        final long currentTimeMillis = System.currentTimeMillis();
        final Bundle bundle2 = bundle;
        final b bVar2 = bVar;
        d.post(new Runnable() {
            /* JADX WARNING: Missing block: B:18:0x00aa, code skipped:
            if (r2.size() > 0) goto L_0x006f;
     */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                AppMethodBeat.i(34939);
                ArrayList parcelableArrayList = bundle2.getParcelableArrayList("android.intent.extra.STREAM");
                if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                    ab.e("MicroMsg.ShareImgUI", "getParcelableArrayList failed");
                    ShareImgUI.a(ShareImgUI.this, bVar2, null);
                    AppMethodBeat.o(34939);
                    return;
                }
                ShareImgUI shareImgUI;
                b bVar;
                final ArrayList arrayList = new ArrayList();
                final CountDownLatch countDownLatch = new CountDownLatch(parcelableArrayList.size());
                final boolean[] zArr = new boolean[]{false};
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    final Parcelable parcelable = (Parcelable) it.next();
                    d.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(34938);
                            if (!ShareImgUI.a(ShareImgUI.this, arrayList, parcelable)) {
                                zArr[0] = true;
                            }
                            countDownLatch.countDown();
                            AppMethodBeat.o(34938);
                        }
                    }, "getMultiSendFilePathListItem" + parcelable.toString());
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    ab.printErrStackTrace("MicroMsg.ShareImgUI", e, "hy: timeout when getmulti", new Object[0]);
                    ShareImgUI.a(ShareImgUI.this, bVar2, null);
                }
                if (zArr[0]) {
                    ab.d("MicroMsg.ShareImgUI", "hy: has non path img");
                    shareImgUI = ShareImgUI.this;
                    bVar = bVar2;
                } else {
                    ab.i("MicroMsg.ShareImgUI", "hy: getMultiSendFilePathList done. using: %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    shareImgUI = ShareImgUI.this;
                    bVar = bVar2;
                }
                arrayList = null;
                ShareImgUI.a(shareImgUI, bVar, arrayList);
                AppMethodBeat.o(34939);
            }
        }, "getMultiSendFilePathList");
        AppMethodBeat.o(34950);
    }

    private boolean aY(Intent intent) {
        AppMethodBeat.i(34951);
        if (intent == null) {
            ab.e("MicroMsg.ShareImgUI", "intent is null");
            AppMethodBeat.o(34951);
            return false;
        }
        String n = w.n(intent, "android.intent.extra.TEXT");
        String n2 = w.n(intent, "android.intent.extra.SUBJECT");
        if (n == null || n.length() == 0) {
            ab.i("MicroMsg.ShareImgUI", "text is null");
            AppMethodBeat.o(34951);
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
        if (!aw.ZM() || aw.QT()) {
            ab.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
        } else {
            aw.Rg().a(837, (f) this);
            ArrayList arrayList = new ArrayList();
            arrayList.add(n2 + "|" + n);
            com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.modelsimple.d(5, arrayList, dyh()), 0);
            showDialog();
            this.zHq = intent2;
        }
        AppMethodBeat.o(34951);
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
    private String a(Uri uri, Cursor cursor) {
        AssetFileDescriptor openAssetFileDescriptor;
        FileNotFoundException e;
        OutputStream outputStream;
        InputStream inputStream;
        IOException e2;
        Exception e3;
        Throwable th;
        AppMethodBeat.i(34952);
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                try {
                    str = cursor.getString(columnIndex);
                } catch (Exception e4) {
                    ab.w("MicroMsg.ShareImgUI", "try to get Vcard Name fail: %s", e4.getMessage());
                }
                if (!(str == null || str == null)) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                ab.i("MicroMsg.ShareImgUI", "vcard file name: ".concat(String.valueOf(str)));
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
                ab.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (inputStream != null) {
                }
                if (openAssetFileDescriptor != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.o(34952);
                return null;
            } catch (Exception e7) {
                e3 = e7;
                outputStream = null;
                openAssetFileDescriptor = null;
                inputStream = null;
                ab.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                ab.e("MicroMsg.ShareImgUI", e3.toString());
                if (inputStream != null) {
                }
                if (openAssetFileDescriptor != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.o(34952);
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
                        AppMethodBeat.o(34952);
                        throw th;
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                AppMethodBeat.o(34952);
                throw th;
            }
            try {
                inputStream = openAssetFileDescriptor.createInputStream();
                try {
                    aw.ZK();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        String str2 = com.tencent.mm.compatible.util.e.eSn + "share";
                        str = com.tencent.mm.compatible.util.e.eSn + "share/" + str;
                        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str2);
                        if (!bVar.exists()) {
                            bVar.mkdirs();
                        }
                        com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str);
                        if (!bVar2.exists()) {
                            bVar2.createNewFile();
                        }
                        outputStream = com.tencent.mm.vfs.e.L(str, false);
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
                        ab.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                        if (inputStream != null) {
                        }
                        if (openAssetFileDescriptor != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.o(34952);
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (inputStream != null) {
                        }
                        if (openAssetFileDescriptor != null) {
                        }
                        if (outputStream != null) {
                        }
                        AppMethodBeat.o(34952);
                        throw th;
                    }
                } catch (IOException e10) {
                    e2 = e10;
                    outputStream = null;
                    ab.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (inputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(34952);
                    return null;
                } catch (Exception e11) {
                    e3 = e11;
                    outputStream = null;
                    ab.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    ab.e("MicroMsg.ShareImgUI", e3.toString());
                    if (inputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (outputStream != null) {
                    }
                    AppMethodBeat.o(34952);
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
                    AppMethodBeat.o(34952);
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
                ab.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (inputStream != null) {
                }
                if (openAssetFileDescriptor != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.o(34952);
                return null;
            } catch (Exception e14) {
                e3 = e14;
                outputStream = null;
                inputStream = null;
                ab.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                ab.e("MicroMsg.ShareImgUI", e3.toString());
                if (inputStream != null) {
                }
                if (openAssetFileDescriptor != null) {
                }
                if (outputStream != null) {
                }
                AppMethodBeat.o(34952);
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
                AppMethodBeat.o(34952);
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
                AppMethodBeat.o(34952);
                return str;
            } catch (FileNotFoundException e16) {
                e = e16;
                ab.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
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
                AppMethodBeat.o(34952);
                return null;
            } catch (IOException e18) {
                e2 = e18;
                ab.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
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
                AppMethodBeat.o(34952);
                return null;
            } catch (Exception e20) {
                e3 = e20;
                ab.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                ab.e("MicroMsg.ShareImgUI", e3.toString());
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
                AppMethodBeat.o(34952);
                return null;
            }
        }
        AppMethodBeat.o(34952);
        return null;
    }

    private static int asc(String str) {
        AppMethodBeat.i(34953);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.ShareImgUI", "map : mimeType is null");
            AppMethodBeat.o(34953);
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equalsIgnoreCase("image/gif")) {
            AppMethodBeat.o(34953);
            return 5;
        } else if (toLowerCase.contains("image")) {
            AppMethodBeat.o(34953);
            return 0;
        } else if (toLowerCase.contains("video")) {
            AppMethodBeat.o(34953);
            return 1;
        } else {
            ab.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
            AppMethodBeat.o(34953);
            return 3;
        }
    }

    private void PI(int i) {
        AppMethodBeat.i(34954);
        switch (i) {
            case 1:
                Toast.makeText(this, R.string.eh5, 1).show();
                AppMethodBeat.o(34954);
                return;
            default:
                Toast.makeText(this, R.string.eh8, 1).show();
                AppMethodBeat.o(34954);
                return;
        }
    }

    private void dJV() {
        AppMethodBeat.i(34955);
        Toast.makeText(this, R.string.b9x, 1).show();
        finish();
        AppMethodBeat.o(34955);
    }

    private void showDialog() {
        AppMethodBeat.i(34956);
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(34941);
                ShareImgUI.this.finish();
                AppMethodBeat.o(34941);
            }
        });
        AppMethodBeat.o(34956);
    }

    private void dismissDialog() {
        AppMethodBeat.i(34957);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.o(34957);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(34958);
        ab.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        dismissDialog();
        if (mVar instanceof z) {
            if (i == 0 && i2 == 0) {
                asS();
            } else {
                finish();
            }
        }
        if (mVar instanceof com.tencent.mm.modelsimple.d) {
            if (!(i == 0 && i2 == 0)) {
                if (mVar.ftl != null) {
                    rt rtVar = (rt) ((com.tencent.mm.ai.b) mVar.ftl).fsH.fsP;
                    if (!(rtVar == null || bo.isNullOrNil(rtVar.vZf))) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", rtVar.vZf);
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("needRedirect", false);
                        com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
                finish();
            }
            startActivity(this.zHq);
            finish();
        }
        AppMethodBeat.o(34958);
    }

    static /* synthetic */ void c(ShareImgUI shareImgUI) {
        AppMethodBeat.i(34960);
        Intent intent = shareImgUI.getIntent();
        int asc = asc(intent.resolveType(shareImgUI));
        if (asc == 0 && r.amo(shareImgUI.filePath)) {
            ab.i("MicroMsg.ShareImgUI", "fix msg type to emoji.");
            asc = 5;
        }
        ab.i("MicroMsg.ShareImgUI", "filepath:[%s], msgType:%d", shareImgUI.filePath, Integer.valueOf(asc));
        if (asc == -1) {
            ab.e("MicroMsg.ShareImgUI", "launch, msgType is invalid");
            shareImgUI.finish();
            AppMethodBeat.o(34960);
        } else if (shareImgUI.zAu != null && asc == 0 && shareImgUI.zAu.size() > 9) {
            intent.setClass(shareImgUI, SelectNoSupportUI.class);
            intent.putExtra("sharePictureTo", "friend");
            intent.addFlags(268435456).addFlags(67108864);
            shareImgUI.zHq = intent;
            shareImgUI.startActivity(shareImgUI.zHq);
            shareImgUI.finish();
            AppMethodBeat.o(34960);
        } else if (bo.isNullOrNil(shareImgUI.filePath) || !bo.anx(shareImgUI.filePath) || r.amn(shareImgUI.filePath)) {
            if (asc == 5 && !bo.isNullOrNil(shareImgUI.filePath)) {
                if (com.tencent.mm.vfs.e.asZ(shareImgUI.filePath) > ((long) com.tencent.mm.m.b.Nb())) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(13459, Long.valueOf(r2), Integer.valueOf(1), "", Integer.valueOf(2));
                    shareImgUI.dJV();
                    AppMethodBeat.o(34960);
                    return;
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                if ((com.tencent.mm.sdk.platformtools.d.decodeFile(shareImgUI.filePath, options) != null && options.outHeight > com.tencent.mm.m.b.Na()) || options.outWidth > com.tencent.mm.m.b.Na()) {
                    com.tencent.mm.plugin.report.service.h.pYm.e(13459, Long.valueOf(r2), Integer.valueOf(1), "", Integer.valueOf(2));
                    shareImgUI.dJV();
                    AppMethodBeat.o(34960);
                    return;
                }
            }
            if (!bo.isNullOrNil(shareImgUI.filePath) && asc == 3) {
                String str = shareImgUI.filePath;
                if (str == null || str.length() == 0) {
                    ab.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is empty");
                    Toast.makeText(shareImgUI, R.string.eh6, 1).show();
                    shareImgUI.finish();
                    AppMethodBeat.o(34960);
                } else if (bo.anw(str)) {
                    long asZ = com.tencent.mm.vfs.e.asZ(str);
                    ab.i("MicroMsg.ShareImgUI", "filelength: [%d]", Long.valueOf(asZ));
                    if (asZ == 0) {
                        ab.e("MicroMsg.ShareImgUI", "dealWithFile fail, fileLength is 0");
                        Toast.makeText(shareImgUI, R.string.eh6, 1).show();
                        shareImgUI.finish();
                        AppMethodBeat.o(34960);
                    } else if (asZ > 10485760) {
                        ab.e("MicroMsg.ShareImgUI", "summerbig dealWithFile fail, fileLength is too large fileLength[%d],filePath[%s] ", Long.valueOf(asZ), str);
                        Toast.makeText(shareImgUI, R.string.eh7, 1).show();
                        shareImgUI.finish();
                        AppMethodBeat.o(34960);
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
                        wXMediaMessage.title = new com.tencent.mm.vfs.b(str).getName();
                        wXMediaMessage.description = bo.ga(asZ);
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
                        if (!aw.ZM() || aw.QT()) {
                            ab.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                            MMWizardActivity.b(shareImgUI, new Intent(shareImgUI, SimpleLoginUI.class), shareImgUI.getIntent().addFlags(67108864));
                            AppMethodBeat.o(34960);
                            return;
                        }
                        com.tencent.mm.kernel.g.Rg().a(837, (f) shareImgUI);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str);
                        com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.modelsimple.d(4, arrayList, shareImgUI.dyh()), 0);
                        shareImgUI.showDialog();
                        shareImgUI.zHq = intent;
                        AppMethodBeat.o(34960);
                    }
                } else {
                    ab.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is refer to private file.");
                    Toast.makeText(shareImgUI, R.string.eh6, 1).show();
                    shareImgUI.finish();
                    AppMethodBeat.o(34960);
                }
            } else if (w.a(shareImgUI.getIntent(), "Intro_Switch", false) || !aw.ZM() || aw.QT()) {
                if (!shareImgUI.dJU()) {
                    shareImgUI.PI(0);
                    shareImgUI.finish();
                }
                AppMethodBeat.o(34960);
            } else {
                m dVar;
                intent.setData(shareImgUI.uri);
                intent.setClass(shareImgUI, MsgRetransmitUI.class);
                intent.addFlags(268435456).addFlags(67108864);
                intent.putExtra("Retr_File_Name", shareImgUI.filePath);
                intent.putStringArrayListExtra("Retr_File_Path_List", shareImgUI.zAu);
                intent.putExtra("Retr_Msg_Type", asc);
                intent.putExtra("Retr_Scene", 1);
                intent.putExtra("Retr_start_where_you_are", false);
                aw.Rg().a(837, (f) shareImgUI);
                ArrayList arrayList2 = new ArrayList();
                if (bo.isNullOrNil(shareImgUI.filePath)) {
                    arrayList2.addAll(shareImgUI.zAu);
                } else {
                    arrayList2.add(shareImgUI.filePath);
                }
                if (asc == 1) {
                    dVar = new com.tencent.mm.modelsimple.d(3, arrayList2, shareImgUI.dyh());
                } else {
                    dVar = new com.tencent.mm.modelsimple.d(1, arrayList2, shareImgUI.dyh());
                }
                com.tencent.mm.kernel.g.Rg().a(dVar, 0);
                shareImgUI.showDialog();
                shareImgUI.zHq = intent;
                AppMethodBeat.o(34960);
            }
        } else {
            ab.w("MicroMsg.ShareImgUI", "try to share illegal image.");
            shareImgUI.PI(0);
            shareImgUI.finish();
            AppMethodBeat.o(34960);
        }
    }

    static /* synthetic */ void d(ShareImgUI shareImgUI) {
        AppMethodBeat.i(34961);
        shareImgUI.PI(0);
        AppMethodBeat.o(34961);
    }
}
