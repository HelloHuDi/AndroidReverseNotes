package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXEnterpriseCardObject;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.r.n;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.cwm;
import com.tencent.mm.protocal.protobuf.cwu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.e;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.xweb.util.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@a(3)
public class SendAppMessageWrapperUI extends MMActivity {
    private ap che = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(35213);
            if (SendAppMessageWrapperUI.this.getWindow() != null && SendAppMessageWrapperUI.this.getWindow().getDecorView() != null && SendAppMessageWrapperUI.this.getWindow().getDecorView().getWindowToken() != null) {
                SendAppMessageWrapperUI.c(SendAppMessageWrapperUI.this);
                AppMethodBeat.o(35213);
                return false;
            } else if (SendAppMessageWrapperUI.this.mqx < 10) {
                SendAppMessageWrapperUI.b(SendAppMessageWrapperUI.this);
                AppMethodBeat.o(35213);
                return true;
            } else {
                AppMethodBeat.o(35213);
                return false;
            }
        }
    }, true);
    private int jDs = 0;
    private int mqx = 0;
    private int scene = 0;
    private String source = null;
    private p tipDialog;
    private String toUser = null;
    private WXMediaMessage yKN = null;
    private f zKw = null;
    private boolean zKx = false;
    private boolean zKy = false;
    private boolean zKz = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SendAppMessageWrapperUI() {
        AppMethodBeat.i(35222);
        AppMethodBeat.o(35222);
    }

    static /* synthetic */ int b(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        int i = sendAppMessageWrapperUI.mqx + 1;
        sendAppMessageWrapperUI.mqx = i;
        return i;
    }

    static /* synthetic */ boolean g(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        AppMethodBeat.i(35238);
        boolean dKq = sendAppMessageWrapperUI.dKq();
        AppMethodBeat.o(35238);
        return dKq;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0475  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0248 A:{SYNTHETIC, Splitter:B:66:0x0248} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x022a A:{SYNTHETIC, Splitter:B:59:0x022a} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x027e  */
    /* JADX WARNING: Missing block: B:87:0x02e9, code skipped:
            if (r0 != null) goto L_0x02eb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        String queryParameter;
        Exception e;
        Throwable th;
        AppMethodBeat.i(35223);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        SharedPreferences sharedPreferences = getSharedPreferences(ah.doA(), 0);
        if (!sharedPreferences.getBoolean("settings_landscape_mode", false)) {
            ab.d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
            this.zKx = true;
            setRequestedOrientation(-1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", true).commit();
        }
        Bundle extras = getIntent().getExtras();
        Req req = new Req(extras);
        this.toUser = extras.getString("Select_Conv_User");
        this.zKy = extras.getBoolean("SendAppMessageWrapper_TokenValid", false);
        this.zKz = extras.getBoolean("SendAppMessageWrapper_BlockInvalidToken", false);
        this.jDs = w.a(getIntent(), ConstantsAPI.SDK_VERSION, 0);
        this.scene = extras.getInt("SendAppMessageWrapper_Scene", 0);
        String string = extras.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            queryParameter = Uri.parse(extras.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        } else {
            queryParameter = string;
        }
        this.zKw = new f();
        this.zKw.field_appId = queryParameter;
        am.bYJ().b((c) this.zKw, new String[0]);
        if (this.zKw.field_appName == null) {
            string = getString(R.string.ati);
        } else {
            string = g.b(this.mController.ylL, this.zKw, null);
        }
        this.source = getString(R.string.atg, new Object[]{string});
        this.yKN = req.message;
        ab.i("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s", this.yKN.messageAction, this.yKN.messageExt);
        int i;
        if (this.scene != 1) {
            this.che.ae(100, 100);
            AppMethodBeat.o(35223);
        } else if (this.yKN.mediaObject == null) {
            finish();
            AppMethodBeat.o(35223);
        } else if (this.yKN.getType() == 38) {
            WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) this.yKN.mediaObject;
            String str = this.yKN.messageExt;
            String str2 = wXVideoFileObject.filePath;
            if (bo.isNullOrNil(wXVideoFileObject.filePath) || !e.ct(wXVideoFileObject.filePath)) {
                finish();
            } else {
                MediaMetadataRetriever mediaMetadataRetriever;
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(str2);
                        int i2 = bo.getInt(mediaMetadataRetriever.extractMetadata(9), -1);
                        i = 10;
                        if ("wx5dfbe0a95623607b".equals(queryParameter)) {
                            i = com.tencent.mm.m.g.Nu().getInt("WeiShiShareSnsSightTimeLength", 10);
                        }
                        ab.i("MicroMsg.SendAppMessageWrapperUI", "video duration %d, durLimit:%d", Integer.valueOf(i2), Integer.valueOf(i));
                        if (((double) i2) >= (((double) i) + 0.5d) * 1000.0d) {
                            setResult(-5);
                            finish();
                            try {
                                mediaMetadataRetriever.release();
                                AppMethodBeat.o(35223);
                                return;
                            } catch (Exception e2) {
                                ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e2, "%s", e2.getMessage());
                                AppMethodBeat.o(35223);
                                return;
                            }
                        }
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e3) {
                            ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e3, "%s", e3.getMessage());
                        }
                    } catch (Exception e4) {
                        e3 = e4;
                        try {
                            ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e3, "Analysis duration of mediaItem %s error %s", str2, e3.getMessage());
                            if (mediaMetadataRetriever != null) {
                            }
                            if ("wx5dfbe0a95623607b".equals(queryParameter)) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (mediaMetadataRetriever != null) {
                            }
                            AppMethodBeat.o(35223);
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    e3 = e5;
                    mediaMetadataRetriever = null;
                    ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e3, "Analysis duration of mediaItem %s error %s", str2, e3.getMessage());
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e32) {
                            ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e32, "%s", e32.getMessage());
                        }
                    }
                    if ("wx5dfbe0a95623607b".equals(queryParameter)) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    mediaMetadataRetriever = null;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e6) {
                            ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e6, "%s", e6.getMessage());
                        }
                    }
                    AppMethodBeat.o(35223);
                    throw th;
                }
            }
            if ("wx5dfbe0a95623607b".equals(queryParameter)) {
                if (!bo.isNullOrNil(wXVideoFileObject.filePath) && e.ct(wXVideoFileObject.filePath)) {
                    string = wXVideoFileObject.filePath;
                    if (string != null) {
                        File file = new File(string);
                        if (file.exists()) {
                            string = d.w(file);
                            if (bo.isEqual(str, string)) {
                                dKp();
                                AppMethodBeat.o(35223);
                                return;
                            }
                        }
                    }
                    string = null;
                    if (bo.isEqual(str, string)) {
                    }
                }
                setResult(-5);
                finish();
                AppMethodBeat.o(35223);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", str2);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", "");
            com.tencent.mm.bp.d.b((Context) this, "mmsight", ".segment.VideoCompressUI", intent, 2);
            AppMethodBeat.o(35223);
        } else {
            if (this.yKN.getType() == 39) {
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) this.yKN.mediaObject;
                if (!bo.isNullOrNil(wXGameVideoFileObject.filePath) && e.ct(wXGameVideoFileObject.filePath)) {
                    Object obj;
                    queryParameter = wXGameVideoFileObject.filePath;
                    if (e.asZ(queryParameter) > ((long) com.tencent.mm.m.g.Nu().getInt("ShareVideoMaxSize", 4194304))) {
                        ab.e("MicroMsg.ShareSnsImpl", "file len too big ");
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        obj = 1;
                    } else {
                        com.tencent.mm.modelsns.a.a tw = com.tencent.mm.modelsns.a.a.tw(queryParameter);
                        if (tw.videoWidth <= 0 || tw.videoHeight <= 0 || ((float) tw.videoWidth) / ((float) tw.videoHeight) > 3.0f || ((float) tw.videoWidth) / ((float) tw.videoHeight) < 0.5f) {
                            ab.i("MicroMsg.ShareSnsImpl", "check ratio faild width = [%d], height = [%d]", Integer.valueOf(tw.videoWidth), Integer.valueOf(tw.videoHeight));
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            ab.i("MicroMsg.ShareSnsImpl", "check duration %d", Integer.valueOf(tw.fPW));
                            if (tw.fPW <= 1000) {
                                obj = 1;
                            } else if (tw.fPW >= 10500) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                ab.d("MicroMsg.ShareSnsImpl", "checkFormat() called with: item = [%s]", tw);
                                if (!bo.isNullOrNil(tw.fPT)) {
                                    string = tw.fPT;
                                    if (bo.isNullOrNil(string)) {
                                        obj = 1;
                                    } else {
                                        if (com.tencent.mm.modelsns.a.fPS == null) {
                                            HashSet hashSet = new HashSet();
                                            com.tencent.mm.modelsns.a.fPS = hashSet;
                                            hashSet.add(".h264");
                                            com.tencent.mm.modelsns.a.fPS.add(".h26l");
                                            com.tencent.mm.modelsns.a.fPS.add(".264");
                                            com.tencent.mm.modelsns.a.fPS.add(".avc");
                                            com.tencent.mm.modelsns.a.fPS.add(".mov");
                                            com.tencent.mm.modelsns.a.fPS.add(VideoMaterialUtil.MP4_SUFFIX);
                                            com.tencent.mm.modelsns.a.fPS.add(MediaConfig.VIDEO_AAC_FILE_POSTFIX);
                                            com.tencent.mm.modelsns.a.fPS.add(".3gp");
                                            com.tencent.mm.modelsns.a.fPS.add(".3g2");
                                            com.tencent.mm.modelsns.a.fPS.add(".mj2");
                                            com.tencent.mm.modelsns.a.fPS.add(".m4v");
                                        }
                                        string = string.trim();
                                        i = string.lastIndexOf(".");
                                        obj = (i < 0 || i >= string.length()) ? 1 : !com.tencent.mm.modelsns.a.fPS.contains(string.substring(i)) ? 1 : null;
                                    }
                                    if (obj == null && "video/avc".equalsIgnoreCase(tw.fPU) && (bo.isNullOrNil(tw.fPV) || "audio/mp4a-latm".equalsIgnoreCase(tw.fPV))) {
                                        obj = null;
                                        if (obj == null) {
                                            obj = null;
                                        }
                                    }
                                }
                                ab.i("MicroMsg.ShareSnsImpl", "check video format failed, dst format [video/avc], video format [%s]", tw.fPU);
                                ab.i("MicroMsg.ShareSnsImpl", "check video format failed, dst audioTrackMime [%s], video audioTrackMime [%s]", "audio/mp4a-latm", tw.fPV);
                                obj = 1;
                                if (obj == null) {
                                }
                            }
                        }
                        obj = 1;
                    }
                }
                ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), -5), false);
                finish();
                AppMethodBeat.o(35223);
                return;
            }
            dKp();
            AppMethodBeat.o(35223);
        }
    }

    private void dKp() {
        Intent a;
        AppMethodBeat.i(35224);
        if (this.zKy || !dKq()) {
            a = com.tencent.mm.modelsns.a.a(this.jDs, this.yKN, this.zKw.field_appId, this.zKw.field_appName, this.zKw.xy());
        } else {
            a = com.tencent.mm.modelsns.a.a(this.jDs, this.yKN, "", "", this.zKw.xy());
        }
        if (a == null) {
            finish();
            AppMethodBeat.o(35224);
            return;
        }
        String str = null;
        if (this.yKN.getType() == 5 || this.yKN.getType() == 2 || this.yKN.getType() == 38) {
            ab.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", this.zKw.field_appId);
            String nW = v.nW("app_" + this.zKw.field_appId);
            b y = v.Zp().y(nW, true);
            y.j("prePublishId", "app_" + this.zKw.field_appId);
            if (this.yKN.mediaObject instanceof WXWebpageObject) {
                y.j("url", ((WXWebpageObject) this.yKN.mediaObject).webpageUrl);
            }
            str = nW;
        }
        asv(str);
        a.putExtra("reportSessionId", str);
        com.tencent.mm.bp.d.b((Context) this, "sns", ".ui.SnsUploadUI", a, 1);
        AppMethodBeat.o(35224);
    }

    private boolean dKq() {
        AppMethodBeat.i(35225);
        ab.i("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", Boolean.valueOf(this.zKz));
        boolean z = this.zKz;
        AppMethodBeat.o(35225);
        return z;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(35226);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + i + " resultCode " + i2);
        if (i == 1) {
            if (i2 == -1) {
                ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), 0), false);
            } else {
                ReportUtil.a(this, ReportUtil.c(getIntent().getExtras(), 0), true);
            }
            finish();
            AppMethodBeat.o(35226);
            return;
        }
        if (i == 2 && i2 == -1) {
            WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) this.yKN.mediaObject;
            wXVideoFileObject.filePath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
            if (bo.isNullOrNil(wXVideoFileObject.filePath) || !e.ct(wXVideoFileObject.filePath)) {
                setResult(-5);
                finish();
            } else {
                dKp();
                AppMethodBeat.o(35226);
                return;
            }
        }
        AppMethodBeat.o(35226);
    }

    public void onDestroy() {
        AppMethodBeat.i(35227);
        super.onDestroy();
        if (this.zKx) {
            ab.d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
            SharedPreferences sharedPreferences = getSharedPreferences(ah.doA(), 0);
            setRequestedOrientation(1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
        }
        AppMethodBeat.o(35227);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(35228);
        aqX();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(35228);
        return onTouchEvent;
    }

    private q.a a(final WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(35229);
        AnonymousClass3 anonymousClass3 = new q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(35215);
                if (z) {
                    SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, wXMediaMessage, str, i);
                    AppMethodBeat.o(35215);
                    return;
                }
                SendAppMessageWrapperUI.d(SendAppMessageWrapperUI.this);
                AppMethodBeat.o(35215);
            }
        };
        AppMethodBeat.o(35229);
        return anonymousClass3;
    }

    private static void a(j.b bVar, WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(35231);
        if (bVar == null || wXMediaMessage == null || wXMediaMessage.mediaObject == null) {
            AppMethodBeat.o(35231);
            return;
        }
        if (wXMediaMessage.mediaObject instanceof WXDynamicVideoMiniProgramObject) {
            WXDynamicVideoMiniProgramObject wXDynamicVideoMiniProgramObject = (WXDynamicVideoMiniProgramObject) wXMediaMessage.mediaObject;
            com.tencent.mm.af.f aVar = new com.tencent.mm.af.a();
            if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(wXMediaMessage.thumbData, 0, wXMediaMessage.thumbData.length);
                if (decodeByteArray != null) {
                    aVar.ffn = decodeByteArray.getWidth();
                    aVar.ffo = decodeByteArray.getHeight();
                }
            }
            aVar.videoSource = wXDynamicVideoMiniProgramObject.videoSource;
            aVar.appThumbUrl = wXDynamicVideoMiniProgramObject.appThumbUrl;
            aVar.ffp = 1;
            bVar.a(aVar);
            bVar.cMh = null;
        }
        AppMethodBeat.o(35231);
    }

    private void b(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        AppMethodBeat.i(35232);
        ArrayList arrayList = new ArrayList();
        arrayList.add(((WXVideoFileObject) wXMediaMessage.mediaObject).filePath);
        if (arrayList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                ab.i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
                final com.tencent.mm.pluginsdk.model.j jVar = new com.tencent.mm.pluginsdk.model.j(this, arrayList, getIntent(), str, 1, new com.tencent.mm.pluginsdk.model.j.a() {
                    public final void dhi() {
                        AppMethodBeat.i(35220);
                        if (SendAppMessageWrapperUI.this.tipDialog != null) {
                            SendAppMessageWrapperUI.this.tipDialog.dismiss();
                            SendAppMessageWrapperUI.this.tipDialog = null;
                        }
                        AppMethodBeat.o(35220);
                    }
                });
                com.tencent.mm.sdk.g.d.post(jVar, "ChattingUI_importMultiVideo");
                getString(R.string.tz);
                this.tipDialog = h.b((Context) this, getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(35221);
                        jVar.dhb();
                        SendAppMessageWrapperUI.this.setResult(-1);
                        SendAppMessageWrapperUI.this.finish();
                        AppMethodBeat.o(35221);
                    }
                });
            }
        }
        AppMethodBeat.o(35232);
    }

    private void c(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        AppMethodBeat.i(35233);
        WXEnterpriseCardObject wXEnterpriseCardObject = (WXEnterpriseCardObject) wXMediaMessage.mediaObject;
        if (wXEnterpriseCardObject.msgType == 66 || wXEnterpriseCardObject.msgType == 42) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                aw.Rg().a(new com.tencent.mm.modelmulti.h((String) it.next(), wXEnterpriseCardObject.cardInfo, wXEnterpriseCardObject.msgType), 0);
            }
            AppMethodBeat.o(35233);
            return;
        }
        ab.e("MicroMsg.SendAppMessageWrapperUI", "sendCardMsg msgType invalid");
        setResult(0);
        finish();
        AppMethodBeat.o(35233);
    }

    private void asv(String str) {
        AppMethodBeat.i(138663);
        if ("wx5dfbe0a95623607b".equals(this.zKw.field_appId)) {
            if (this.yKN.getType() == 5) {
                ab.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) url, to timeline, appId : %s", this.zKw.field_appId);
                com.tencent.mm.plugin.report.service.h.pYm.e(17256, str, Integer.valueOf(2));
                AppMethodBeat.o(138663);
                return;
            } else if (this.yKN.getType() == 38) {
                ab.i("MicroMsg.SendAppMessageWrapperUI", "report(17256) video file, to timeline, appId : %s", this.zKw.field_appId);
                com.tencent.mm.plugin.report.service.h.pYm.e(17256, str, Integer.valueOf(1));
            }
        }
        AppMethodBeat.o(138663);
    }

    public final void initView() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private void a(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        String str;
        AppMethodBeat.i(35230);
        if (wXMediaMessage == null || !(wXMediaMessage.mediaObject instanceof WXImageObject)) {
            ab.w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
            str = null;
        } else {
            WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
            if (bo.cb(wXImageObject.imageData)) {
                str = wXImageObject.imagePath;
            } else {
                ab.d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + wXImageObject.imageData.length);
                str = l.bH(wXImageObject.imageData);
            }
        }
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
            setResult(0);
            AppMethodBeat.o(35230);
            return;
        }
        String str2;
        int i = bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i <= 0) {
            i = 100;
        }
        i *= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        int i2 = 1;
        long asZ = e.asZ(str);
        if (asZ > 26214400 || asZ <= ((long) i)) {
            i2 = 0;
        }
        if (this.zKy || !dKq()) {
            String str3 = this.zKw.field_appId;
            String str4 = wXMediaMessage.mediaTagName;
            String str5 = wXMediaMessage.messageExt;
            String str6 = wXMediaMessage.messageAction;
            String str7 = null;
            if (!bo.isNullOrNil(str3)) {
                str7 = "<msg>" + com.tencent.mm.at.f.c(str3, str4, str5, str6) + "</msg>";
            }
            str2 = str7;
        } else {
            str2 = null;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            aw.Rg().a(new com.tencent.mm.at.l(6, r.Yz(), (String) it.next(), str, i2, null, 0, str2, "", true, R.drawable.abu), 0);
        }
        AppMethodBeat.o(35230);
    }

    /* JADX WARNING: Missing block: B:16:0x007d, code skipped:
            if (com.tencent.mm.pluginsdk.ui.applet.g.a(r12.mController, r1.description, true, r12.a(r1)) != null) goto L_0x0038;
     */
    /* JADX WARNING: Missing block: B:115:0x03e4, code skipped:
            if (com.tencent.mm.pluginsdk.ui.applet.g.a(r12.mController, r0, true, r12.a(r4)) != null) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(35234);
        if (sendAppMessageWrapperUI.yKN == null) {
            ab.e("MicroMsg.SendAppMessageWrapperUI", "deal fail, WXMediaMessage is null");
            AppMethodBeat.o(35234);
            return;
        }
        int type = sendAppMessageWrapperUI.yKN.getType();
        WXMediaMessage wXMediaMessage;
        com.tencent.mm.ui.widget.a.c b;
        WXMediaMessage wXMediaMessage2;
        WXMediaMessage wXMediaMessage3;
        String a;
        String string;
        WXMediaMessage wXMediaMessage4;
        switch (type) {
            case 1:
                wXMediaMessage = sendAppMessageWrapperUI.yKN;
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (wXTextObject.text != null && wXTextObject.text.length() != 0) {
                    sendAppMessageWrapperUI.zKw.field_appId.equals("wx4310bbd51be7d979");
                    break;
                }
                ab.e("MicroMsg.SendAppMessageWrapperUI", "dealText fail, text is empty");
                z2 = false;
                break;
            case 2:
                wXMediaMessage = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                    if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                        b = com.tencent.mm.pluginsdk.ui.applet.g.b(sendAppMessageWrapperUI.mController, wXImageObject.imagePath, true, sendAppMessageWrapperUI.a(wXMediaMessage));
                    } else {
                        b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, wXImageObject.imageData, true, sendAppMessageWrapperUI.a(wXMediaMessage));
                    }
                } else {
                    b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, wXMediaMessage.thumbData, true, sendAppMessageWrapperUI.a(wXMediaMessage));
                }
                if (b == null) {
                    ab.e("MicroMsg.SendAppMessageWrapperUI", "showDialogItem3 fail, invalid argument");
                } else {
                    z = true;
                }
                z2 = z;
                break;
            case 3:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, (int) R.raw.app_attach_file_icon_music, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2));
                } else {
                    b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 2, sendAppMessageWrapperUI.a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 4:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, (int) R.raw.app_attach_file_icon_video, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2));
                } else {
                    b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 1, sendAppMessageWrapperUI.a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 5:
                wXMediaMessage3 = sendAppMessageWrapperUI.yKN;
                if (com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, wXMediaMessage3.title, wXMediaMessage3.description, true, sendAppMessageWrapperUI.mController.ylL.getResources().getString(R.string.atf), sendAppMessageWrapperUI.a(wXMediaMessage3)) == null) {
                    z2 = false;
                    break;
                }
                break;
            case 6:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, (int) R.raw.app_attach_file_icon_file, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2));
                } else {
                    b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 7:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    Bitmap b2 = g.b(sendAppMessageWrapperUI.zKw.field_appId, 1, com.tencent.mm.bz.a.getDensity(sendAppMessageWrapperUI));
                    if (b2 == null || b2.isRecycled()) {
                        b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, (int) R.raw.app_attach_file_icon_webpage, wXMediaMessage2.title, true, sendAppMessageWrapperUI.a(wXMediaMessage2));
                    } else {
                        b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, b2, wXMediaMessage2.title, wXMediaMessage2.description, sendAppMessageWrapperUI.source, sendAppMessageWrapperUI.a(wXMediaMessage2));
                    }
                } else {
                    b = com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 8:
                wXMediaMessage = sendAppMessageWrapperUI.yKN;
                a = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((Context) sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.zKw.field_appId);
                string = sendAppMessageWrapperUI.mController.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
                if (bo.isNullOrNil(a)) {
                    if (com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, (int) R.raw.app_attach_file_icon_webpage, wXMediaMessage.title, true, sendAppMessageWrapperUI.a(wXMediaMessage)) == null) {
                        z2 = false;
                        break;
                    }
                }
                com.tencent.mm.pluginsdk.ui.applet.g.a aVar = new com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController.ylL);
                aVar.cx(string).ajE(a).h(Boolean.TRUE).KQ(R.string.tf).a(sendAppMessageWrapperUI.a(wXMediaMessage)).gud.show();
                if (aVar.gud == null) {
                    z2 = false;
                    break;
                }
                break;
            case 36:
                wXMediaMessage4 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage4 != null && (wXMediaMessage4.mediaObject instanceof WXMiniProgramObject)) {
                    WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage4.mediaObject;
                    ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zb(wXMiniProgramObject.userName);
                    com.tencent.mm.pluginsdk.ui.applet.g.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController.ylL);
                    aVar2.cx(sendAppMessageWrapperUI.mController.ylL.getIntent().getExtras().getString("Select_Conv_User", null));
                    final View d = ((i) com.tencent.mm.kernel.g.K(i.class)).d((Context) sendAppMessageWrapperUI, null);
                    string = n.bE(sendAppMessageWrapperUI);
                    Bundle bundle = new Bundle();
                    bundle.putByteArray(ImagesContract.IMAGE_DATA, wXMediaMessage4.thumbData);
                    bundle.putString("title", wXMediaMessage4.title);
                    bundle.putString("msg_path", wXMiniProgramObject.path);
                    ((i) com.tencent.mm.kernel.g.K(i.class)).a(string, d, bundle);
                    aVar2.ev(d);
                    aVar2.h(Boolean.TRUE);
                    aVar2.djy();
                    aVar2.jbD = new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(35214);
                            ((i) com.tencent.mm.kernel.g.K(i.class)).a(string, d);
                            AppMethodBeat.o(35214);
                        }
                    };
                    aVar2.KQ(R.string.tf);
                    aVar2.a(sendAppMessageWrapperUI.a(wXMediaMessage4)).gud.show();
                    break;
                }
                z2 = false;
                break;
            case 38:
                wXMediaMessage3 = sendAppMessageWrapperUI.yKN;
                if (com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController, wXMediaMessage3.title, wXMediaMessage3.description, true, sendAppMessageWrapperUI.mController.ylL.getResources().getString(R.string.atf), sendAppMessageWrapperUI.a(wXMediaMessage3), sendAppMessageWrapperUI.getResources().getString(R.string.ud)) == null) {
                    z2 = false;
                    break;
                }
                break;
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                wXMediaMessage4 = sendAppMessageWrapperUI.yKN;
                WXEnterpriseCardObject wXEnterpriseCardObject = (WXEnterpriseCardObject) wXMediaMessage4.mediaObject;
                if (wXEnterpriseCardObject.cardInfo != null && wXEnterpriseCardObject.cardInfo.length() != 0) {
                    Map z3 = br.z(wXEnterpriseCardObject.cardInfo, "msg");
                    if (z3 != null) {
                        String str = (String) z3.get(".msg.$nickname");
                        if (!bo.isNullOrNil(str)) {
                            CharSequence a2;
                            StringBuilder stringBuilder = new StringBuilder();
                            if (wXEnterpriseCardObject.msgType == 66) {
                                a2 = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).a("3552365301", "openim_card_type_name", com.tencent.mm.openim.a.b.a.TYPE_WORDING);
                            } else {
                                a2 = null;
                            }
                            if (TextUtils.isEmpty(a2)) {
                                a = sendAppMessageWrapperUI.getResources().getString(R.string.qy);
                            } else {
                                a = String.format("[%s]", new Object[]{a2});
                            }
                            a = stringBuilder.append(a).append(str).toString();
                            sendAppMessageWrapperUI.zKw.field_appId.equals("wx4310bbd51be7d979");
                            break;
                        }
                        ab.i("MicroMsg.SendAppMessageWrapperUI", "dealBusinessCard error, nickname not in xml");
                    }
                } else {
                    ab.e("MicroMsg.SendAppMessageWrapperUI", "dealCard fail, card info is empty");
                }
                z2 = false;
                break;
            case 46:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                com.tencent.mm.pluginsdk.ui.applet.g.a aVar3 = new com.tencent.mm.pluginsdk.ui.applet.g.a(sendAppMessageWrapperUI.mController.ylL);
                aVar3.cx(sendAppMessageWrapperUI.mController.ylL.getIntent().getExtras().getString("Select_Conv_User", null));
                if (wXMediaMessage2.thumbData != null && wXMediaMessage2.thumbData.length > 0) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(wXMediaMessage2.thumbData, 0, wXMediaMessage2.thumbData.length);
                    if (decodeByteArray != null) {
                        aVar3.b(decodeByteArray, 2);
                    }
                }
                aVar3.h(Boolean.TRUE);
                aVar3.KQ(R.string.tf).a(sendAppMessageWrapperUI.a(wXMediaMessage2)).gud.show();
                break;
            default:
                ab.e("MicroMsg.SendAppMessageWrapperUI", "unknown type = ".concat(String.valueOf(type)));
                z2 = false;
                break;
        }
        if (!z2) {
            ab.e("MicroMsg.SendAppMessageWrapperUI", "deal fail, result is false");
            sendAppMessageWrapperUI.finish();
        }
        AppMethodBeat.o(35234);
    }

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, final WXMediaMessage wXMediaMessage, String str, int i) {
        AppMethodBeat.i(35235);
        ab.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc msg[%s], text[%s], parsterLen[%d], scene[%d]", wXMediaMessage, str, Integer.valueOf(i), Integer.valueOf(sendAppMessageWrapperUI.scene));
        if (sendAppMessageWrapperUI.scene == 0 || sendAppMessageWrapperUI.scene == 3) {
            bv.aaq().c(38, Integer.valueOf(1));
            String str2 = null;
            if (wXMediaMessage.getType() == 8) {
                if (wXMediaMessage.thumbData == null) {
                    ab.e("MicroMsg.SendAppMessageWrapperUI", "summerbig code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                    AppMethodBeat.o(35235);
                    return;
                }
                str2 = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a((Context) sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.zKw.field_appId);
                if (str2 == null) {
                    ab.v("MicroMsg.SendAppMessageWrapperUI", "summerbig sendEmoji Fail cause emojiconmd5 is null");
                    AppMethodBeat.o(35235);
                    return;
                }
                EmojiInfo Jd = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jd(str2);
                if (Jd == null) {
                    ab.i("MicroMsg.SendAppMessageWrapperUI", "emoji is null.");
                    AppMethodBeat.o(35235);
                    return;
                }
                if (Jd.field_size > bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitSendThirdPartyAppMsgEmotionBufSize"), SQLiteGlobal.journalSizeLimit)) {
                    ab.i("MicroMsg.SendAppMessageWrapperUI", "third party shared emoji can't bigger 512 KB");
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(13461, sendAppMessageWrapperUI.zKw.field_appId, sendAppMessageWrapperUI.zKw.field_appName, Integer.valueOf(Jd.field_size));
            }
            String str3 = null;
            if (wXMediaMessage.getType() == 5 || wXMediaMessage.getType() == 2) {
                ab.d("MicroMsg.SendAppMessageWrapperUI", "report(11954), appId : %s", sendAppMessageWrapperUI.zKw.field_appId);
                str3 = v.nW("app_" + sendAppMessageWrapperUI.zKw.field_appId);
                v.Zp().y(str3, true).j("prePublishId", "app_" + sendAppMessageWrapperUI.zKw.field_appId);
            }
            final LinkedList linkedList = new LinkedList(bo.P(sendAppMessageWrapperUI.toUser.split(",")));
            if (wXMediaMessage.getType() == 36 || wXMediaMessage.getType() == 46) {
                final WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage.mediaObject;
                ((com.tencent.mm.plugin.appbrand.service.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.d.class)).zd(wXMiniProgramObject.userName).f(new com.tencent.mm.vending.c.a<Void, WxaAttributes>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(35218);
                        WxaAttributes wxaAttributes = (WxaAttributes) obj;
                        if (wxaAttributes == null) {
                            ab.e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand info failed");
                            SendAppMessageWrapperUI.this.setResult(-1);
                            SendAppMessageWrapperUI.this.finish();
                            ReportUtil.a(SendAppMessageWrapperUI.this, ReportUtil.c(SendAppMessageWrapperUI.this.getIntent().getExtras(), -1), false);
                        } else {
                            SendAppMessageWrapperUI.a(SendAppMessageWrapperUI.this, wxaAttributes, wXMediaMessage, wXMiniProgramObject, linkedList);
                        }
                        Void voidR = zXH;
                        AppMethodBeat.o(35218);
                        return voidR;
                    }
                });
            } else if (wXMediaMessage.getType() == 2) {
                com.tencent.mm.pluginsdk.ui.tools.l.a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.a(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 38) {
                com.tencent.mm.pluginsdk.ui.tools.l.a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.b(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 45) {
                com.tencent.mm.pluginsdk.ui.tools.l.a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.c(wXMediaMessage, linkedList);
            } else {
                com.tencent.mm.pluginsdk.ui.tools.l.a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wXMediaMessage, linkedList);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str4 = (String) it.next();
                    String str5 = sendAppMessageWrapperUI.zKw.field_appId;
                    if (!sendAppMessageWrapperUI.zKy && sendAppMessageWrapperUI.dKq()) {
                        str5 = "";
                    }
                    l.a(wXMediaMessage, str5, sendAppMessageWrapperUI.zKw.field_appName, str4, 2, str2, str3);
                }
            }
            String string = sendAppMessageWrapperUI.zKw.field_appId.equals("wx4310bbd51be7d979") ? null : sendAppMessageWrapperUI.getString(R.string.ata, new Object[]{sendAppMessageWrapperUI.zKw.field_appName});
            String string2 = (sendAppMessageWrapperUI.zKy || !sendAppMessageWrapperUI.dKq()) ? string == null ? sendAppMessageWrapperUI.getString(R.string.at_) : string : sendAppMessageWrapperUI.getString(R.string.at_);
            com.tencent.mm.plugin.bizui.a.a.a(sendAppMessageWrapperUI.mController, sendAppMessageWrapperUI.getString(R.string.ate), string2, sendAppMessageWrapperUI.getString(R.string.ath), new q.a() {
                public final void a(boolean z, String str, int i) {
                    AppMethodBeat.i(35217);
                    SendAppMessageWrapperUI.this.setResult(-1);
                    SendAppMessageWrapperUI.this.finish();
                    ReportUtil.a(SendAppMessageWrapperUI.this, ReportUtil.c(SendAppMessageWrapperUI.this.getIntent().getExtras(), 0), false);
                    AppMethodBeat.o(35217);
                }
            }, new q.a() {
                public final void a(boolean z, String str, int i) {
                    AppMethodBeat.i(35216);
                    SendAppMessageWrapperUI.this.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
                    SendAppMessageWrapperUI.this.finish();
                    AppMethodBeat.o(35216);
                }
            });
            if (str == null || str.length() == 0) {
                ab.i("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc, text is empty");
                AppMethodBeat.o(35235);
                return;
            }
            ab.d("MicroMsg.SendAppMessageWrapperUI", "summerbig dktext , send msg here:".concat(String.valueOf(str)));
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                aw.Rg().a(new com.tencent.mm.modelmulti.h((String) it2.next(), str, t.nK(sendAppMessageWrapperUI.toUser)), 0);
            }
            AppMethodBeat.o(35235);
            return;
        }
        if (com.tencent.mm.plugin.sns.b.n.qFw != null) {
            com.tencent.mm.plugin.sns.b.n.qFw.a(wXMediaMessage, str, sendAppMessageWrapperUI.zKw.field_appId, sendAppMessageWrapperUI.zKw.field_appName, i);
            com.tencent.mm.plugin.sns.b.n.qFw.cmp();
        }
        ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.c(sendAppMessageWrapperUI.getIntent().getExtras(), 0), false);
        sendAppMessageWrapperUI.finish();
        AppMethodBeat.o(35235);
    }

    static /* synthetic */ void d(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        AppMethodBeat.i(35236);
        if (sendAppMessageWrapperUI.scene == 0 || sendAppMessageWrapperUI.scene == 3) {
            Intent intent = new Intent();
            intent.putExtra("Select_Report_Args", ReportUtil.c(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
            sendAppMessageWrapperUI.setResult(0, intent);
        } else {
            ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.c(sendAppMessageWrapperUI.getIntent().getExtras(), -2), false);
        }
        sendAppMessageWrapperUI.finish();
        AppMethodBeat.o(35236);
    }

    static /* synthetic */ void a(SendAppMessageWrapperUI sendAppMessageWrapperUI, WxaAttributes wxaAttributes, WXMediaMessage wXMediaMessage, WXMiniProgramObject wXMiniProgramObject, LinkedList linkedList) {
        Iterator it;
        String str;
        AppMethodBeat.i(35237);
        com.tencent.mm.pluginsdk.ui.tools.l.a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wxaAttributes, wXMediaMessage, wXMiniProgramObject, linkedList);
        StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(sendAppMessageWrapperUI.zKw.field_appId);
        stringBuilder.append("_");
        aw.ZK();
        stringBuilder.append(com.tencent.mm.a.p.getString(com.tencent.mm.model.c.QF()));
        stringBuilder.append("_");
        stringBuilder.append(bo.anT());
        stringBuilder.append("_");
        stringBuilder.append("1");
        final String stringBuilder2 = stringBuilder.toString();
        if (wXMiniProgramObject.withShareTicket) {
            if (wxaAttributes == null) {
                ab.e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand info failed");
                sendAppMessageWrapperUI.setResult(-1);
                sendAppMessageWrapperUI.finish();
                ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.c(sendAppMessageWrapperUI.getIntent().getExtras(), -1), false);
                AppMethodBeat.o(35237);
                return;
            }
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsI = FaceManager.FACE_ACQUIRED_NO_FOCUS;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
            cwl cwl = new cwl();
            cwl.csB = wxaAttributes.field_appId;
            cwl.xse = linkedList;
            aVar.fsJ = cwl;
            aVar.fsK = new cwm();
            final LinkedList linkedList2 = linkedList;
            final WxaAttributes wxaAttributes2 = wxaAttributes;
            final WXMiniProgramObject wXMiniProgramObject2 = wXMiniProgramObject;
            final WXMediaMessage wXMediaMessage2 = wXMediaMessage;
            com.tencent.mm.ai.w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(35219);
                    ab.i("MicroMsg.SendAppMessageWrapperUI", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    cwm cwm = (cwm) bVar.fsH.fsP;
                    String str2;
                    if (i != 0 || i2 != 0 || cwm == null || cwm.xsh == null) {
                        Iterator it = linkedList2.iterator();
                        while (it.hasNext()) {
                            str2 = (String) it.next();
                            String str3 = SendAppMessageWrapperUI.this.zKw.field_appId;
                            if (!SendAppMessageWrapperUI.this.zKy && SendAppMessageWrapperUI.g(SendAppMessageWrapperUI.this)) {
                                str3 = "";
                            }
                            j.b bVar2 = new j.b();
                            bVar2.appId = str3;
                            bVar2.appName = SendAppMessageWrapperUI.this.zKw.field_appName;
                            bVar2.fgr = 2;
                            SendAppMessageWrapperUI.b(bVar2, wXMediaMessage2);
                            l.a(bVar2, wXMediaMessage2, str2);
                        }
                    } else {
                        LinkedList linkedList = cwm.xsh == null ? new LinkedList() : cwm.xsh;
                        ab.i("MicroMsg.SendAppMessageWrapperUI", "get wxaAppShareInfoList size = %d, toUserList size = %d", Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
                        for (int i3 = 0; i3 < linkedList2.size(); i3++) {
                            cwu cwu;
                            if (i3 < linkedList.size()) {
                                cwu = (cwu) linkedList.get(i3);
                            } else {
                                cwu = new cwu();
                            }
                            j.b bVar3 = new j.b();
                            str2 = SendAppMessageWrapperUI.this.zKw.field_appId;
                            if (!SendAppMessageWrapperUI.this.zKy && SendAppMessageWrapperUI.g(SendAppMessageWrapperUI.this)) {
                                str2 = "";
                            }
                            bVar3.appId = str2;
                            bVar3.fiQ = wxaAttributes2.field_appId;
                            bVar3.cMg = wxaAttributes2.field_username;
                            bVar3.cMh = wxaAttributes2.field_nickname;
                            bVar3.fiZ = wXMiniProgramObject2.miniprogramType;
                            bVar3.appName = SendAppMessageWrapperUI.this.zKw.field_appName;
                            bVar3.fgr = 2;
                            bVar3.fiV = cwu.wYs;
                            bVar3.fiU = stringBuilder2;
                            SendAppMessageWrapperUI.b(bVar3, wXMediaMessage2);
                            l.a(bVar3, wXMediaMessage2, (String) linkedList2.get(i3));
                        }
                    }
                    AppMethodBeat.o(35219);
                    return 0;
                }
            });
        } else if (wxaAttributes == null) {
            ab.e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand without share ticket info failed");
            sendAppMessageWrapperUI.setResult(-1);
            sendAppMessageWrapperUI.finish();
            ReportUtil.a(sendAppMessageWrapperUI, ReportUtil.c(sendAppMessageWrapperUI.getIntent().getExtras(), -1), false);
            AppMethodBeat.o(35237);
            return;
        } else {
            it = linkedList.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                j.b bVar = new j.b();
                String str2 = sendAppMessageWrapperUI.zKw.field_appId;
                if (!sendAppMessageWrapperUI.zKy && sendAppMessageWrapperUI.dKq()) {
                    str2 = "";
                }
                bVar.appId = str2;
                bVar.fiQ = wxaAttributes.field_appId;
                bVar.fiZ = wXMiniProgramObject.miniprogramType;
                bVar.appName = sendAppMessageWrapperUI.zKw.field_appName;
                bVar.fgr = 2;
                bVar.cMg = wxaAttributes.field_username;
                bVar.cMh = wxaAttributes.field_nickname;
                a(bVar, wXMediaMessage);
                l.a(bVar, wXMediaMessage, str);
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            int i = ((String) it.next()).endsWith("chatroom") ? 1 : 0;
            String encode = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(wXMiniProgramObject.webpageUrl));
            String encode2 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(wXMediaMessage.title));
            stringBuilder2 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(wXMediaMessage.description));
            String encode3 = com.tencent.mm.compatible.util.q.encode(bo.nullAsNil(wXMiniProgramObject.path));
            com.tencent.mm.plugin.report.service.h.pYm.e(14127, sendAppMessageWrapperUI.zKw.field_appId, wXMiniProgramObject.userName, encode3, encode2, stringBuilder2, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), str);
        }
        AppMethodBeat.o(35237);
    }
}
