package com.tencent.mm.ui.tools;

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
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141010", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class AddFavoriteUI extends MMActivity implements f {
    private ProgressDialog ehJ = null;
    String filePath = null;
    private ak handler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(34754);
            AddFavoriteUI.d(AddFavoriteUI.this);
            if (bo.isNullOrNil(AddFavoriteUI.this.filePath) || (bo.anx(AddFavoriteUI.this.filePath) && !AddFavoriteUI.asd(AddFavoriteUI.this.filePath))) {
                ab.e("MicroMsg.AddFavoriteUI", "launch : fail, filePath is null or file is not a valid img.");
                AddFavoriteUI.g(AddFavoriteUI.this);
                AddFavoriteUI.this.finish();
                AppMethodBeat.o(34754);
                return;
            }
            AddFavoriteUI.h(AddFavoriteUI.this);
            AppMethodBeat.o(34754);
        }
    };
    private Intent intent = null;
    Uri uri = null;
    private cl zAt;
    ArrayList<String> zAu = null;
    private ak zAv = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(34752);
            AddFavoriteUI.d(AddFavoriteUI.this);
            ab.i("MicroMsg.AddFavoriteUI", "dealWithText: %b", Boolean.valueOf(AddFavoriteUI.e(AddFavoriteUI.this)));
            AppMethodBeat.o(34752);
        }
    };
    private ak zAw = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(34753);
            AddFavoriteUI.d(AddFavoriteUI.this);
            AddFavoriteUI.f(AddFavoriteUI.this);
            AppMethodBeat.o(34753);
        }
    };

    public interface b {
        void dJx();
    }

    class a implements Runnable {
        private Uri mUri;
        private b zAy;

        public a(Uri uri, b bVar) {
            this.mUri = uri;
            this.zAy = bVar;
        }

        public final void run() {
            AppMethodBeat.i(34758);
            AddFavoriteUI.this.filePath = AddFavoriteUI.a(AddFavoriteUI.this, this.mUri);
            if (bo.isNullOrNil(AddFavoriteUI.this.filePath) || !new File(AddFavoriteUI.this.filePath).exists()) {
                if (AddFavoriteUI.ase(AddFavoriteUI.this.getContentResolver().getType(this.mUri)) == 2) {
                    AddFavoriteUI.this.filePath = e.a(AddFavoriteUI.this.getContentResolver(), this.mUri, 1);
                } else {
                    AddFavoriteUI.this.filePath = e.a(AddFavoriteUI.this.getContentResolver(), this.mUri);
                }
            }
            if (this.zAy != null) {
                this.zAy.dJx();
            }
            AppMethodBeat.o(34758);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AddFavoriteUI() {
        AppMethodBeat.i(34759);
        AppMethodBeat.o(34759);
    }

    static /* synthetic */ int ase(String str) {
        AppMethodBeat.i(34784);
        int asc = asc(str);
        AppMethodBeat.o(34784);
        return asc;
    }

    static /* synthetic */ void d(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.i(34777);
        addFavoriteUI.dismissDialog();
        AppMethodBeat.o(34777);
    }

    static /* synthetic */ boolean e(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.i(34778);
        boolean dJv = addFavoriteUI.dJv();
        AppMethodBeat.o(34778);
        return dJv;
    }

    static /* synthetic */ void g(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.i(34781);
        addFavoriteUI.dJw();
        AppMethodBeat.o(34781);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34760);
        ab.i("MicroMsg.AddFavoriteUI", "on create");
        super.onCreate(bundle);
        setTitleVisibility(8);
        int a = w.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.Io();
                initView();
                AppMethodBeat.o(34760);
                return;
            case 1:
                finish();
                AppMethodBeat.o(34760);
                return;
            default:
                ab.e("MicroMsg.AddFavoriteUI", "onCreate, should not reach here, resultCode = ".concat(String.valueOf(a)));
                finish();
                AppMethodBeat.o(34760);
                return;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        AppMethodBeat.i(34761);
        ab.i("MicroMsg.AddFavoriteUI", "on SaveInstanceState");
        super.onSaveInstanceState(bundle);
        AppMethodBeat.o(34761);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(34762);
        ab.i("MicroMsg.AddFavoriteUI", "on NewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(34762);
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        AppMethodBeat.i(34763);
        ab.i("MicroMsg.AddFavoriteUI", "on RestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        AppMethodBeat.o(34763);
    }

    public void onDestroy() {
        AppMethodBeat.i(34764);
        ab.i("MicroMsg.AddFavoriteUI", "on Destroy");
        aw.Rg().b(837, (f) this);
        super.onDestroy();
        AppMethodBeat.o(34764);
    }

    public final int getLayoutId() {
        return -1;
    }

    private void dJu() {
        AppMethodBeat.i(34766);
        Intent intent = new Intent(this, AddFavoriteUI.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", bo.isNullOrNil(this.filePath) ? null : Uri.fromFile(new File(this.filePath)));
        intent.addFlags(268435456).addFlags(32768);
        intent.setType(getIntent().getType());
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        AppMethodBeat.o(34766);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0043 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private ArrayList<String> aB(Bundle bundle) {
        AppMethodBeat.i(34767);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("android.intent.extra.STREAM");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
            ab.e("MicroMsg.AddFavoriteUI", "getParcelableArrayList failed");
            AppMethodBeat.o(34767);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            int i;
            Parcelable parcelable = (Parcelable) it.next();
            if (parcelable == null || !(parcelable instanceof Uri)) {
                ab.e("MicroMsg.AddFavoriteUI", "getMultiSendFilePath failed, error parcelable, %s", parcelable);
            } else {
                Uri uri = (Uri) parcelable;
                if (!bo.v(uri) || uri.getScheme() == null) {
                    ab.e("MicroMsg.AddFavoriteUI", "unaccepted uri: ".concat(String.valueOf(uri)));
                } else {
                    String h = bo.h(this, uri);
                    if (!bo.isNullOrNil(h)) {
                        if (bo.anx(h) && r.amn(h)) {
                            ab.i("MicroMsg.AddFavoriteUI", "multisend file path: ".concat(String.valueOf(h)));
                            arrayList.add(h);
                            i = 1;
                            continue;
                            if (i == 0) {
                                AppMethodBeat.o(34767);
                                return null;
                            }
                        }
                        ab.w("MicroMsg.AddFavoriteUI", "multisend tries to send illegal img: ".concat(String.valueOf(h)));
                    }
                }
            }
            i = 0;
            continue;
            if (i == 0) {
            }
        }
        if (arrayList.size() > 0) {
            AppMethodBeat.o(34767);
            return arrayList;
        }
        AppMethodBeat.o(34767);
        return null;
    }

    private boolean dJv() {
        AppMethodBeat.i(34768);
        this.intent = getIntent();
        if (this.intent == null) {
            ab.e("MicroMsg.AddFavoriteUI", "intent is null");
            AppMethodBeat.o(34768);
            return false;
        }
        String n = w.n(this.intent, "android.intent.extra.TEXT");
        if (n == null || n.length() == 0) {
            ab.i("MicroMsg.AddFavoriteUI", "text is null");
            AppMethodBeat.o(34768);
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
        if (!aw.ZM() || aw.QT()) {
            ab.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
            finish();
        } else {
            cl clVar = new cl();
            String str = com.tencent.mm.vfs.e.atd(this.filePath) + "." + com.tencent.mm.vfs.e.cv(this.filePath);
            if (type == 1) {
                Boolean.valueOf(com.tencent.mm.pluginsdk.model.e.b(clVar, n, 13));
            } else {
                Boolean.valueOf(com.tencent.mm.pluginsdk.model.e.a(clVar, this.filePath, str, ""));
            }
            clVar.cvA.activity = this;
            clVar.cvA.cvI = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(34746);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(34746);
                }
            };
            clVar.cvA.cvJ = new c() {
                public final void onShow() {
                }

                public final void onHide() {
                    AppMethodBeat.i(34747);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(34747);
                }

                public final void cLd() {
                }
            };
            this.zAt = clVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(n);
            m dVar = new d(5, arrayList, dyh());
            aw.Rg().a(837, (f) this);
            g.Rg().a(dVar, 0);
            showDialog();
        }
        AppMethodBeat.o(34768);
        return true;
    }

    private void bO(int i, String str) {
        AppMethodBeat.i(34769);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, filePath is empty");
            AppMethodBeat.o(34769);
            return;
        }
        long asZ = com.tencent.mm.vfs.e.asZ(str);
        ab.i("MicroMsg.AddFavoriteUI", "filelength: [%d]", Long.valueOf(asZ));
        if (asZ == 0) {
            ab.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is 0");
            Toast.makeText(this, R.string.bp1, 1).show();
            finish();
            AppMethodBeat.o(34769);
        } else if (asZ > 26214400) {
            ab.e("MicroMsg.AddFavoriteUI", "dealWithFile fail, fileLength is too large");
            Toast.makeText(this, R.string.bs4, 1).show();
            finish();
            AppMethodBeat.o(34769);
        } else if (!aw.ZM() || aw.QT()) {
            ab.w("MicroMsg.AddFavoriteUI", "not logged in, jump to simple login");
            finish();
            dJu();
            AppMethodBeat.o(34769);
        } else {
            IMediaObject wXImageObject;
            m dVar;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            cl clVar = new cl();
            String str2 = com.tencent.mm.vfs.e.atd(str) + "." + com.tencent.mm.vfs.e.cv(str);
            switch (i) {
                case 2:
                    wXImageObject = new WXImageObject();
                    ((WXImageObject) wXImageObject).setImagePath(str);
                    dVar = new d(1, arrayList, dyh());
                    com.tencent.mm.pluginsdk.model.e.a(clVar, 13, str);
                    break;
                case 4:
                    wXImageObject = new WXVideoFileObject(str);
                    dVar = new d(3, arrayList, dyh());
                    String str3 = "";
                    if (!bo.isNullOrNil(str)) {
                        ab.d("MicroMsg.GetFavDataSource", "do fill event info(fav simple file), title %s, desc %s, path %s, sourceType %d", str2, str3, str, Integer.valueOf(13));
                        if (new com.tencent.mm.vfs.b(str).length() <= ((long) com.tencent.mm.m.b.Nc())) {
                            abf abf = new abf();
                            abl abl = new abl();
                            aar aar = new aar();
                            aar.akV(str);
                            aar.LE(4);
                            aar.akR(com.tencent.mm.vfs.e.cv(str));
                            aar.akW(null);
                            aar.LD(0);
                            aar.akH(str2);
                            aar.akI(str3);
                            abl.alD(com.tencent.mm.model.r.Yz());
                            abl.alE(com.tencent.mm.model.r.Yz());
                            abl.LN(13);
                            abl.ml(bo.anU());
                            abf.a(abl);
                            abf.wiv.add(aar);
                            clVar.cvA.title = aar.title;
                            clVar.cvA.desc = aar.title;
                            clVar.cvA.cvC = abf;
                            clVar.cvA.type = 4;
                            break;
                        }
                        clVar.cvA.cvG = R.string.bs4;
                        break;
                    }
                    ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                    clVar.cvA.cvG = R.string.boh;
                    break;
                default:
                    wXImageObject = new WXFileObject(str);
                    dVar = new d(4, arrayList, dyh());
                    com.tencent.mm.pluginsdk.model.e.a(clVar, str, str2, "");
                    break;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXImageObject);
            wXMediaMessage.title = new File(str).getName();
            if (bo.isNullOrNil(null)) {
                wXMediaMessage.description = bo.ga(asZ);
            } else {
                wXMediaMessage.description = null;
            }
            if (asZ < 30720) {
                wXMediaMessage.thumbData = com.tencent.mm.vfs.e.e(str, 0, -1);
            } else {
                ab.i("MicroMsg.AddFavoriteUI", "thumb data is exceed 30k, ignore");
            }
            Req req = new Req();
            req.transaction = null;
            req.message = wXMediaMessage;
            Bundle bundle = new Bundle();
            req.toBundle(bundle);
            bundle.putInt(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            bundle.putString(ConstantsAPI.APP_PACKAGE, "com.tencent.mm.openapi");
            bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
            clVar.cvA.activity = this;
            clVar.cvA.cvI = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(34748);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(34748);
                }
            };
            clVar.cvA.cvJ = new c() {
                public final void onShow() {
                }

                public final void onHide() {
                    AppMethodBeat.i(34749);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(34749);
                }

                public final void cLd() {
                }
            };
            this.zAt = clVar;
            g.Rg().a(837, (f) this);
            g.Rg().a(dVar, 0);
            showDialog();
            AppMethodBeat.o(34769);
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
    private String a(Uri uri, Cursor cursor) {
        FileNotFoundException e;
        IOException e2;
        Exception e3;
        Throwable th;
        AppMethodBeat.i(34770);
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                str = cursor.getString(columnIndex);
                if (str != null) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                ab.i("MicroMsg.AddFavoriteUI", "vcard file name: ".concat(String.valueOf(str)));
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
                            aw.ZK();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                String str2 = com.tencent.mm.compatible.util.e.eSn + "share";
                                str = com.tencent.mm.compatible.util.e.eSn + "share/" + str;
                                File file = new File(str2);
                                if (!file.exists()) {
                                    file.mkdir();
                                }
                                File file2 = new File(str);
                                if (!file2.exists()) {
                                    file2.createNewFile();
                                }
                                if (com.tencent.mm.vfs.e.b(str, bArr, bArr.length) == 0) {
                                    if (createInputStream != null) {
                                        try {
                                            createInputStream.close();
                                        } catch (Exception e4) {
                                            ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e4, e4.getMessage(), new Object[0]);
                                        }
                                    }
                                    if (openAssetFileDescriptor != null) {
                                        openAssetFileDescriptor.close();
                                    }
                                    AppMethodBeat.o(34770);
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
                                        ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e42, e42.getMessage(), new Object[0]);
                                    }
                                }
                                if (openAssetFileDescriptor != null) {
                                    openAssetFileDescriptor.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                AppMethodBeat.o(34770);
                                return str;
                            } catch (FileNotFoundException e5) {
                                e = e5;
                            } catch (IOException e6) {
                                e2 = e6;
                                ab.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                                if (createInputStream != null) {
                                }
                                if (openAssetFileDescriptor != null) {
                                }
                                if (openFileOutput != null) {
                                }
                                AppMethodBeat.o(34770);
                                return null;
                            } catch (Exception e7) {
                                e3 = e7;
                                ab.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e3.getMessage());
                                if (createInputStream != null) {
                                }
                                if (openAssetFileDescriptor != null) {
                                }
                                if (openFileOutput != null) {
                                }
                                AppMethodBeat.o(34770);
                                return null;
                            }
                        }
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (Exception e32) {
                                ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e32, e32.getMessage(), new Object[0]);
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                    } catch (FileNotFoundException e8) {
                        e = e8;
                        openFileOutput = null;
                        try {
                            ab.e("MicroMsg.AddFavoriteUI", "vcard uri file not found " + e.getMessage());
                            if (createInputStream != null) {
                                try {
                                    createInputStream.close();
                                } catch (Exception e322) {
                                    ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e322, e322.getMessage(), new Object[0]);
                                }
                            }
                            if (openAssetFileDescriptor != null) {
                                openAssetFileDescriptor.close();
                            }
                            if (openFileOutput != null) {
                                openFileOutput.close();
                            }
                            AppMethodBeat.o(34770);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (createInputStream != null) {
                            }
                            if (openAssetFileDescriptor != null) {
                            }
                            if (openFileOutput != null) {
                            }
                            AppMethodBeat.o(34770);
                            throw th;
                        }
                    } catch (IOException e9) {
                        e2 = e9;
                        openFileOutput = null;
                        ab.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                        if (createInputStream != null) {
                        }
                        if (openAssetFileDescriptor != null) {
                        }
                        if (openFileOutput != null) {
                        }
                        AppMethodBeat.o(34770);
                        return null;
                    } catch (Exception e10) {
                        e322 = e10;
                        openFileOutput = null;
                        ab.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e322.getMessage());
                        if (createInputStream != null) {
                        }
                        if (openAssetFileDescriptor != null) {
                        }
                        if (openFileOutput != null) {
                        }
                        AppMethodBeat.o(34770);
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
                        AppMethodBeat.o(34770);
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
                    ab.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                    if (createInputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (openFileOutput != null) {
                    }
                    AppMethodBeat.o(34770);
                    return null;
                } catch (Exception e13) {
                    e322 = e13;
                    openFileOutput = null;
                    createInputStream = null;
                    ab.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e322.getMessage());
                    if (createInputStream != null) {
                    }
                    if (openAssetFileDescriptor != null) {
                    }
                    if (openFileOutput != null) {
                    }
                    AppMethodBeat.o(34770);
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
                    AppMethodBeat.o(34770);
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
                ab.e("MicroMsg.AddFavoriteUI", "vcard uri ioexception" + e2.getMessage());
                if (createInputStream != null) {
                    try {
                        createInputStream.close();
                    } catch (Exception e3222) {
                        ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e3222, e3222.getMessage(), new Object[0]);
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                AppMethodBeat.o(34770);
                return null;
            } catch (Exception e16) {
                e3222 = e16;
                openFileOutput = null;
                createInputStream = null;
                openAssetFileDescriptor = null;
                ab.e("MicroMsg.AddFavoriteUI", "vcard uri exception" + e3222.getMessage());
                if (createInputStream != null) {
                    try {
                        createInputStream.close();
                    } catch (Exception e32222) {
                        ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e32222, e32222.getMessage(), new Object[0]);
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                AppMethodBeat.o(34770);
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
                        ab.printErrStackTrace("MicroMsg.AddFavoriteUI", e422, e422.getMessage(), new Object[0]);
                        AppMethodBeat.o(34770);
                        throw th;
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (openFileOutput != null) {
                    openFileOutput.close();
                }
                AppMethodBeat.o(34770);
                throw th;
            }
        }
        AppMethodBeat.o(34770);
        return null;
    }

    private static int asc(String str) {
        AppMethodBeat.i(34771);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.AddFavoriteUI", "map : mimeType is null");
            AppMethodBeat.o(34771);
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.contains("image") || toLowerCase.equals("application/vnd.google.panorama360+jpg")) {
            AppMethodBeat.o(34771);
            return 2;
        } else if (toLowerCase.contains("video")) {
            AppMethodBeat.o(34771);
            return 4;
        } else {
            ab.d("MicroMsg.AddFavoriteUI", "map : unknown mimetype, send as file");
            AppMethodBeat.o(34771);
            return 8;
        }
    }

    private void dJw() {
        AppMethodBeat.i(34772);
        PI(0);
        Toast.makeText(this, R.string.eh8, 1).show();
        AppMethodBeat.o(34772);
    }

    private void PI(int i) {
        AppMethodBeat.i(34773);
        switch (i) {
            case 1:
                Toast.makeText(this, R.string.eh5, 1).show();
                AppMethodBeat.o(34773);
                return;
            default:
                Toast.makeText(this, R.string.eh8, 1).show();
                AppMethodBeat.o(34773);
                return;
        }
    }

    private void showDialog() {
        AppMethodBeat.i(34774);
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        AppMethodBeat.o(34774);
    }

    private void dismissDialog() {
        AppMethodBeat.i(34775);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        AppMethodBeat.o(34775);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(34776);
        ab.i("MicroMsg.AddFavoriteUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        dismissDialog();
        if (mVar instanceof d) {
            if (i == 0 && i2 == 0) {
                if (this.zAt != null) {
                    com.tencent.mm.sdk.b.a.xxA.m(this.zAt);
                    this.zAt = null;
                    AppMethodBeat.o(34776);
                    return;
                }
            } else if (mVar.ftl != null) {
                rt rtVar = (rt) ((com.tencent.mm.ai.b) mVar.ftl).fsH.fsP;
                if (rtVar != null && !bo.isNullOrNil(rtVar.vZf)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", rtVar.vZf);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    com.tencent.mm.bp.d.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
                    finish();
                    AppMethodBeat.o(34776);
                    return;
                } else if (this.zAt != null) {
                    com.tencent.mm.sdk.b.a.xxA.m(this.zAt);
                    this.zAt = null;
                }
            }
        }
        AppMethodBeat.o(34776);
    }

    public final void initView() {
        AppMethodBeat.i(34765);
        this.intent = getIntent();
        if (this.intent == null) {
            ab.e("MicroMsg.AddFavoriteUI", "launch : fail, intent is null");
            dJw();
            finish();
            AppMethodBeat.o(34765);
            return;
        }
        String action = this.intent.getAction();
        Bundle aM = w.aM(this.intent);
        if (bo.isNullOrNil(action)) {
            ab.e("MicroMsg.AddFavoriteUI", "launch : fail, action is null");
            dJw();
            finish();
            AppMethodBeat.o(34765);
            return;
        }
        if (aM != null) {
            Parcelable parcelable = aM.getParcelable("android.intent.extra.STREAM");
            if (parcelable instanceof Uri) {
                this.uri = (Uri) parcelable;
                if (!bo.v(this.uri)) {
                    ab.e("MicroMsg.AddFavoriteUI", "launch : fail, not accept, %s", this.uri);
                    dJw();
                    finish();
                    AppMethodBeat.o(34765);
                    return;
                }
            } else if (parcelable != null) {
                ab.e("MicroMsg.AddFavoriteUI", "launch : fail, uri check fail, %s", parcelable);
                dJw();
                finish();
                AppMethodBeat.o(34765);
                return;
            }
        }
        if (action.equals("android.intent.action.SEND")) {
            ab.i("MicroMsg.AddFavoriteUI", "send signal: ".concat(String.valueOf(action)));
            if (this.uri == null) {
                showDialog();
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34744);
                        AddFavoriteUI.this.zAv.sendEmptyMessage(0);
                        AppMethodBeat.o(34744);
                    }
                }, "AddFavoriteUI_dealWithTextHandler");
                AppMethodBeat.o(34765);
                return;
            }
            showDialog();
            com.tencent.mm.sdk.g.d.post(new a(this.uri, new b() {
                public final void dJx() {
                    AppMethodBeat.i(34750);
                    AddFavoriteUI.this.handler.sendEmptyMessage(0);
                    AppMethodBeat.o(34750);
                }
            }), "AddFavoriteUI_getFilePath");
            AppMethodBeat.o(34765);
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && aM != null && aM.containsKey("android.intent.extra.STREAM")) {
            ab.i("MicroMsg.AddFavoriteUI", "send multi: %s, mimeType %s", action, getIntent().resolveType(this));
            if (bo.bc(getIntent().resolveType(this), "").contains("image")) {
                this.zAu = aB(aM);
                if (this.zAu == null || this.zAu.size() == 0) {
                    ab.e("MicroMsg.AddFavoriteUI", "launch : fail, filePathList is null");
                    PI(1);
                    finish();
                    AppMethodBeat.o(34765);
                    return;
                }
                showDialog();
                com.tencent.mm.sdk.g.d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34751);
                        AddFavoriteUI.this.zAw.sendEmptyMessage(0);
                        AppMethodBeat.o(34751);
                    }
                }, "AddFavoriteUI_dealWithMultiItemHandler");
                AppMethodBeat.o(34765);
                return;
            }
            ab.e("MicroMsg.AddFavoriteUI", "launch : fail, mimeType not contains image");
            PI(1);
            finish();
            AppMethodBeat.o(34765);
        } else {
            ab.e("MicroMsg.AddFavoriteUI", "launch : fail, uri is null");
            dJw();
            finish();
            AppMethodBeat.o(34765);
        }
    }

    static /* synthetic */ void f(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.i(34779);
        ab.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", addFavoriteUI.filePath);
        int asc = asc(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (asc == -1) {
            ab.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            AppMethodBeat.o(34779);
            return;
        }
        ab.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithMultiItem msgType is %d", addFavoriteUI.filePath, Integer.valueOf(asc));
        ArrayList arrayList;
        if (asc == 8 && !bo.isNullOrNil(addFavoriteUI.filePath)) {
            addFavoriteUI.bO(asc, addFavoriteUI.filePath);
            AppMethodBeat.o(34779);
        } else if (w.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !aw.ZM() || aw.QT()) {
            Intent intent = new Intent(addFavoriteUI, AddFavoriteUI.class);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            if (bo.ek(addFavoriteUI.zAu)) {
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
            MMWizardActivity.b(addFavoriteUI, new Intent(addFavoriteUI, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
            addFavoriteUI.finish();
            AppMethodBeat.o(34779);
        } else {
            cl clVar = new cl();
            ArrayList<String> arrayList3 = addFavoriteUI.zAu;
            if (arrayList3 == null || arrayList3.isEmpty()) {
                ab.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or paths is empty");
                clVar.cvA.cvG = R.string.boh;
            } else if (arrayList3.size() > 9) {
                clVar.cvA.cvG = R.string.boo;
            } else {
                ab.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple images), paths %s sourceType %d", arrayList3, Integer.valueOf(13));
                abf abf = new abf();
                abl abl = new abl();
                for (String str : arrayList3) {
                    if (!bo.isNullOrNil(str)) {
                        aar aar = new aar();
                        aar.LE(2);
                        aar.akV(str);
                        aar.oY(true);
                        abf.wiv.add(aar);
                    }
                }
                abl.alD(com.tencent.mm.model.r.Yz());
                abl.alE(com.tencent.mm.model.r.Yz());
                abl.LN(13);
                abl.ml(bo.anU());
                abf.a(abl);
                clVar.cvA.title = "";
                clVar.cvA.cvC = abf;
                clVar.cvA.type = 2;
            }
            clVar.cvA.activity = addFavoriteUI;
            clVar.cvA.cvI = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(34755);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(34755);
                }
            };
            clVar.cvA.cvJ = new c() {
                public final void onShow() {
                }

                public final void onHide() {
                    AppMethodBeat.i(34756);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(34756);
                }

                public final void cLd() {
                }
            };
            aw.Rg().a(837, (f) addFavoriteUI);
            g.Rg().a(new d(1, addFavoriteUI.zAu, addFavoriteUI.dyh()), 0);
            addFavoriteUI.showDialog();
            addFavoriteUI.zAt = clVar;
            AppMethodBeat.o(34779);
        }
    }

    static /* synthetic */ boolean asd(String str) {
        AppMethodBeat.i(34780);
        boolean amn = r.amn(str);
        AppMethodBeat.o(34780);
        return amn;
    }

    static /* synthetic */ void h(AddFavoriteUI addFavoriteUI) {
        AppMethodBeat.i(34782);
        ab.i("MicroMsg.AddFavoriteUI", "filepath:[%s]", addFavoriteUI.filePath);
        int asc = asc(addFavoriteUI.getIntent().resolveType(addFavoriteUI));
        if (asc == -1) {
            ab.e("MicroMsg.AddFavoriteUI", "launch, msgType is invalid");
            addFavoriteUI.finish();
            AppMethodBeat.o(34782);
            return;
        }
        ab.i("MicroMsg.AddFavoriteUI", "filepath:[%s] dealWithSimpleItem msgType is %d", addFavoriteUI.filePath, Integer.valueOf(asc));
        if (!bo.isNullOrNil(addFavoriteUI.filePath)) {
            addFavoriteUI.bO(asc, addFavoriteUI.filePath);
            AppMethodBeat.o(34782);
        } else if (w.a(addFavoriteUI.getIntent(), "Intro_Switch", false) || !aw.ZM() || aw.QT()) {
            addFavoriteUI.finish();
            addFavoriteUI.dJu();
            AppMethodBeat.o(34782);
        } else {
            cl clVar = new cl();
            com.tencent.mm.pluginsdk.model.e.a(clVar, 13, addFavoriteUI.filePath);
            clVar.cvA.activity = addFavoriteUI;
            clVar.cvA.cvI = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(34757);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(34757);
                }
            };
            clVar.cvA.cvJ = new c() {
                public final void onShow() {
                }

                public final void onHide() {
                    AppMethodBeat.i(34745);
                    AddFavoriteUI.this.finish();
                    AppMethodBeat.o(34745);
                }

                public final void cLd() {
                }
            };
            com.tencent.mm.sdk.b.a.xxA.m(clVar);
            AppMethodBeat.o(34782);
        }
    }
}
