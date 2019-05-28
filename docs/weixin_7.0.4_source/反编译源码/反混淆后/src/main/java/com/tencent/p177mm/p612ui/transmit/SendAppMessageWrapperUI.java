package com.tencent.p177mm.p612ui.transmit;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.modelsns.C26476a;
import com.tencent.p177mm.modelsns.C26476a.C26477a;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p1210a.C32873b.C32874a;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXDynamicVideoMiniProgramObject;
import com.tencent.p177mm.opensdk.modelmsg.WXEnterpriseCardObject;
import com.tencent.p177mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p181af.C37435f;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.bizui.p1604a.C45756a;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.pluginsdk.model.C30076j.C30077a;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.model.app.ReportUtil;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.C23273a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35898l;
import com.tencent.p177mm.protocal.protobuf.cwl;
import com.tencent.p177mm.protocal.protobuf.cwm;
import com.tencent.p177mm.protocal.protobuf.cwu;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.soter.core.biometric.FaceManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.xweb.util.C6037d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@C5271a(3)
/* renamed from: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI */
public class SendAppMessageWrapperUI extends MMActivity {
    private C7564ap che = new C7564ap(new C159581(), true);
    private int jDs = 0;
    private int mqx = 0;
    private int scene = 0;
    private String source = null;
    private C44275p tipDialog;
    private String toUser = null;
    private WXMediaMessage yKN = null;
    private C40439f zKw = null;
    private boolean zKx = false;
    private boolean zKy = false;
    private boolean zKz = false;

    /* renamed from: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI$8 */
    class C56128 implements C30077a {
        C56128() {
        }

        public final void dhi() {
            AppMethodBeat.m2504i(35220);
            if (SendAppMessageWrapperUI.this.tipDialog != null) {
                SendAppMessageWrapperUI.this.tipDialog.dismiss();
                SendAppMessageWrapperUI.this.tipDialog = null;
            }
            AppMethodBeat.m2505o(35220);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI$1 */
    class C159581 implements C5015a {
        C159581() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(35213);
            if (SendAppMessageWrapperUI.this.getWindow() != null && SendAppMessageWrapperUI.this.getWindow().getDecorView() != null && SendAppMessageWrapperUI.this.getWindow().getDecorView().getWindowToken() != null) {
                SendAppMessageWrapperUI.m37030c(SendAppMessageWrapperUI.this);
                AppMethodBeat.m2505o(35213);
                return false;
            } else if (SendAppMessageWrapperUI.this.mqx < 10) {
                SendAppMessageWrapperUI.m37026b(SendAppMessageWrapperUI.this);
                AppMethodBeat.m2505o(35213);
                return true;
            } else {
                AppMethodBeat.m2505o(35213);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI$4 */
    class C240704 implements C30111a {
        C240704() {
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(35216);
            SendAppMessageWrapperUI.this.setResult(-1, new Intent().putExtra("Select_stay_in_wx", true));
            SendAppMessageWrapperUI.this.finish();
            AppMethodBeat.m2505o(35216);
        }
    }

    /* renamed from: com.tencent.mm.ui.transmit.SendAppMessageWrapperUI$5 */
    class C240715 implements C30111a {
        C240715() {
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(35217);
            SendAppMessageWrapperUI.this.setResult(-1);
            SendAppMessageWrapperUI.this.finish();
            ReportUtil.m79192a(SendAppMessageWrapperUI.this, ReportUtil.m79195c(SendAppMessageWrapperUI.this.getIntent().getExtras(), 0), false);
            AppMethodBeat.m2505o(35217);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SendAppMessageWrapperUI() {
        AppMethodBeat.m2504i(35222);
        AppMethodBeat.m2505o(35222);
    }

    /* renamed from: b */
    static /* synthetic */ int m37026b(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        int i = sendAppMessageWrapperUI.mqx + 1;
        sendAppMessageWrapperUI.mqx = i;
        return i;
    }

    /* renamed from: g */
    static /* synthetic */ boolean m37034g(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        AppMethodBeat.m2504i(35238);
        boolean dKq = sendAppMessageWrapperUI.dKq();
        AppMethodBeat.m2505o(35238);
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
        AppMethodBeat.m2504i(35223);
        super.onCreate(bundle);
        getSupportActionBar().hide();
        SharedPreferences sharedPreferences = getSharedPreferences(C4996ah.doA(), 0);
        if (!sharedPreferences.getBoolean("settings_landscape_mode", false)) {
            C4990ab.m7410d("MicroMsg.SendAppMessageWrapperUI", "change orientation");
            this.zKx = true;
            setRequestedOrientation(-1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", true).commit();
        }
        Bundle extras = getIntent().getExtras();
        Req req = new Req(extras);
        this.toUser = extras.getString("Select_Conv_User");
        this.zKy = extras.getBoolean("SendAppMessageWrapper_TokenValid", false);
        this.zKz = extras.getBoolean("SendAppMessageWrapper_BlockInvalidToken", false);
        this.jDs = C5068w.m7682a(getIntent(), ConstantsAPI.SDK_VERSION, 0);
        this.scene = extras.getInt("SendAppMessageWrapper_Scene", 0);
        String string = extras.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            queryParameter = Uri.parse(extras.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        } else {
            queryParameter = string;
        }
        this.zKw = new C40439f();
        this.zKw.field_appId = queryParameter;
        C14877am.bYJ().mo10102b((C4925c) this.zKw, new String[0]);
        if (this.zKw.field_appName == null) {
            string = getString(C25738R.string.ati);
        } else {
            string = C46494g.m87733b(this.mController.ylL, this.zKw, null);
        }
        this.source = getString(C25738R.string.atg, new Object[]{string});
        this.yKN = req.message;
        C4990ab.m7417i("MicroMsg.SendAppMessageWrapperUI", "onCreate, messageAction = %s, messageExt = %s", this.yKN.messageAction, this.yKN.messageExt);
        int i;
        if (this.scene != 1) {
            this.che.mo16770ae(100, 100);
            AppMethodBeat.m2505o(35223);
        } else if (this.yKN.mediaObject == null) {
            finish();
            AppMethodBeat.m2505o(35223);
        } else if (this.yKN.getType() == 38) {
            WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) this.yKN.mediaObject;
            String str = this.yKN.messageExt;
            String str2 = wXVideoFileObject.filePath;
            if (C5046bo.isNullOrNil(wXVideoFileObject.filePath) || !C5730e.m8628ct(wXVideoFileObject.filePath)) {
                finish();
            } else {
                MediaMetadataRetriever mediaMetadataRetriever;
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                    try {
                        mediaMetadataRetriever.setDataSource(str2);
                        int i2 = C5046bo.getInt(mediaMetadataRetriever.extractMetadata(9), -1);
                        i = 10;
                        if ("wx5dfbe0a95623607b".equals(queryParameter)) {
                            i = C26373g.m41964Nu().getInt("WeiShiShareSnsSightTimeLength", 10);
                        }
                        C4990ab.m7417i("MicroMsg.SendAppMessageWrapperUI", "video duration %d, durLimit:%d", Integer.valueOf(i2), Integer.valueOf(i));
                        if (((double) i2) >= (((double) i) + 0.5d) * 1000.0d) {
                            setResult(-5);
                            finish();
                            try {
                                mediaMetadataRetriever.release();
                                AppMethodBeat.m2505o(35223);
                                return;
                            } catch (Exception e2) {
                                C4990ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e2, "%s", e2.getMessage());
                                AppMethodBeat.m2505o(35223);
                                return;
                            }
                        }
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e3) {
                            C4990ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e3, "%s", e3.getMessage());
                        }
                    } catch (Exception e4) {
                        e3 = e4;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e3, "Analysis duration of mediaItem %s error %s", str2, e3.getMessage());
                            if (mediaMetadataRetriever != null) {
                            }
                            if ("wx5dfbe0a95623607b".equals(queryParameter)) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (mediaMetadataRetriever != null) {
                            }
                            AppMethodBeat.m2505o(35223);
                            throw th;
                        }
                    }
                } catch (Exception e5) {
                    e3 = e5;
                    mediaMetadataRetriever = null;
                    C4990ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e3, "Analysis duration of mediaItem %s error %s", str2, e3.getMessage());
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e32) {
                            C4990ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e32, "%s", e32.getMessage());
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
                            C4990ab.printErrStackTrace("MicroMsg.SendAppMessageWrapperUI", e6, "%s", e6.getMessage());
                        }
                    }
                    AppMethodBeat.m2505o(35223);
                    throw th;
                }
            }
            if ("wx5dfbe0a95623607b".equals(queryParameter)) {
                if (!C5046bo.isNullOrNil(wXVideoFileObject.filePath) && C5730e.m8628ct(wXVideoFileObject.filePath)) {
                    string = wXVideoFileObject.filePath;
                    if (string != null) {
                        File file = new File(string);
                        if (file.exists()) {
                            string = C6037d.m9505w(file);
                            if (C5046bo.isEqual(str, string)) {
                                dKp();
                                AppMethodBeat.m2505o(35223);
                                return;
                            }
                        }
                    }
                    string = null;
                    if (C5046bo.isEqual(str, string)) {
                    }
                }
                setResult(-5);
                finish();
                AppMethodBeat.m2505o(35223);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", str2);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", "");
            C25985d.m41468b((Context) this, "mmsight", ".segment.VideoCompressUI", intent, 2);
            AppMethodBeat.m2505o(35223);
        } else {
            if (this.yKN.getType() == 39) {
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) this.yKN.mediaObject;
                if (!C5046bo.isNullOrNil(wXGameVideoFileObject.filePath) && C5730e.m8628ct(wXGameVideoFileObject.filePath)) {
                    Object obj;
                    queryParameter = wXGameVideoFileObject.filePath;
                    if (C5730e.asZ(queryParameter) > ((long) C26373g.m41964Nu().getInt("ShareVideoMaxSize", 4194304))) {
                        C4990ab.m7412e("MicroMsg.ShareSnsImpl", "file len too big ");
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        obj = 1;
                    } else {
                        C26477a tw = C26477a.m42193tw(queryParameter);
                        if (tw.videoWidth <= 0 || tw.videoHeight <= 0 || ((float) tw.videoWidth) / ((float) tw.videoHeight) > 3.0f || ((float) tw.videoWidth) / ((float) tw.videoHeight) < 0.5f) {
                            C4990ab.m7417i("MicroMsg.ShareSnsImpl", "check ratio faild width = [%d], height = [%d]", Integer.valueOf(tw.videoWidth), Integer.valueOf(tw.videoHeight));
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            C4990ab.m7417i("MicroMsg.ShareSnsImpl", "check duration %d", Integer.valueOf(tw.fPW));
                            if (tw.fPW <= 1000) {
                                obj = 1;
                            } else if (tw.fPW >= 10500) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                C4990ab.m7411d("MicroMsg.ShareSnsImpl", "checkFormat() called with: item = [%s]", tw);
                                if (!C5046bo.isNullOrNil(tw.fPT)) {
                                    string = tw.fPT;
                                    if (C5046bo.isNullOrNil(string)) {
                                        obj = 1;
                                    } else {
                                        if (C26476a.fPS == null) {
                                            HashSet hashSet = new HashSet();
                                            C26476a.fPS = hashSet;
                                            hashSet.add(".h264");
                                            C26476a.fPS.add(".h26l");
                                            C26476a.fPS.add(".264");
                                            C26476a.fPS.add(".avc");
                                            C26476a.fPS.add(".mov");
                                            C26476a.fPS.add(VideoMaterialUtil.MP4_SUFFIX);
                                            C26476a.fPS.add(MediaConfig.VIDEO_AAC_FILE_POSTFIX);
                                            C26476a.fPS.add(".3gp");
                                            C26476a.fPS.add(".3g2");
                                            C26476a.fPS.add(".mj2");
                                            C26476a.fPS.add(".m4v");
                                        }
                                        string = string.trim();
                                        i = string.lastIndexOf(".");
                                        obj = (i < 0 || i >= string.length()) ? 1 : !C26476a.fPS.contains(string.substring(i)) ? 1 : null;
                                    }
                                    if (obj == null && "video/avc".equalsIgnoreCase(tw.fPU) && (C5046bo.isNullOrNil(tw.fPV) || "audio/mp4a-latm".equalsIgnoreCase(tw.fPV))) {
                                        obj = null;
                                        if (obj == null) {
                                            obj = null;
                                        }
                                    }
                                }
                                C4990ab.m7417i("MicroMsg.ShareSnsImpl", "check video format failed, dst format [video/avc], video format [%s]", tw.fPU);
                                C4990ab.m7417i("MicroMsg.ShareSnsImpl", "check video format failed, dst audioTrackMime [%s], video audioTrackMime [%s]", "audio/mp4a-latm", tw.fPV);
                                obj = 1;
                                if (obj == null) {
                                }
                            }
                        }
                        obj = 1;
                    }
                }
                ReportUtil.m79192a(this, ReportUtil.m79195c(getIntent().getExtras(), -5), false);
                finish();
                AppMethodBeat.m2505o(35223);
                return;
            }
            dKp();
            AppMethodBeat.m2505o(35223);
        }
    }

    private void dKp() {
        Intent a;
        AppMethodBeat.m2504i(35224);
        if (this.zKy || !dKq()) {
            a = C26476a.m42191a(this.jDs, this.yKN, this.zKw.field_appId, this.zKw.field_appName, this.zKw.mo63847xy());
        } else {
            a = C26476a.m42191a(this.jDs, this.yKN, "", "", this.zKw.mo63847xy());
        }
        if (a == null) {
            finish();
            AppMethodBeat.m2505o(35224);
            return;
        }
        String str = null;
        if (this.yKN.getType() == 5 || this.yKN.getType() == 2 || this.yKN.getType() == 38) {
            C4990ab.m7411d("MicroMsg.SendAppMessageWrapperUI", "report(11954), to timeline, appId : %s", this.zKw.field_appId);
            String nW = C37922v.m64078nW("app_" + this.zKw.field_appId);
            C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
            y.mo53356j("prePublishId", "app_" + this.zKw.field_appId);
            if (this.yKN.mediaObject instanceof WXWebpageObject) {
                y.mo53356j("url", ((WXWebpageObject) this.yKN.mediaObject).webpageUrl);
            }
            str = nW;
        }
        asv(str);
        a.putExtra("reportSessionId", str);
        C25985d.m41468b((Context) this, "sns", ".ui.SnsUploadUI", a, 1);
        AppMethodBeat.m2505o(35224);
    }

    private boolean dKq() {
        AppMethodBeat.m2504i(35225);
        C4990ab.m7417i("MicroMsg.SendAppMessageWrapperUI", "blockInvalidToken block %b", Boolean.valueOf(this.zKz));
        boolean z = this.zKz;
        AppMethodBeat.m2505o(35225);
        return z;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(35226);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7416i("MicroMsg.SendAppMessageWrapperUI", "requestCode " + i + " resultCode " + i2);
        if (i == 1) {
            if (i2 == -1) {
                ReportUtil.m79192a(this, ReportUtil.m79195c(getIntent().getExtras(), 0), false);
            } else {
                ReportUtil.m79192a(this, ReportUtil.m79195c(getIntent().getExtras(), 0), true);
            }
            finish();
            AppMethodBeat.m2505o(35226);
            return;
        }
        if (i == 2 && i2 == -1) {
            WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) this.yKN.mediaObject;
            wXVideoFileObject.filePath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
            if (C5046bo.isNullOrNil(wXVideoFileObject.filePath) || !C5730e.m8628ct(wXVideoFileObject.filePath)) {
                setResult(-5);
                finish();
            } else {
                dKp();
                AppMethodBeat.m2505o(35226);
                return;
            }
        }
        AppMethodBeat.m2505o(35226);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(35227);
        super.onDestroy();
        if (this.zKx) {
            C4990ab.m7410d("MicroMsg.SendAppMessageWrapperUI", "restore orientation");
            SharedPreferences sharedPreferences = getSharedPreferences(C4996ah.doA(), 0);
            setRequestedOrientation(1);
            sharedPreferences.edit().putBoolean("settings_landscape_mode", false).commit();
        }
        AppMethodBeat.m2505o(35227);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(35228);
        aqX();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(35228);
        return onTouchEvent;
    }

    /* renamed from: a */
    private C30111a m37021a(final WXMediaMessage wXMediaMessage) {
        AppMethodBeat.m2504i(35229);
        C240693 c240693 = new C30111a() {
            /* renamed from: a */
            public final void mo6399a(boolean z, String str, int i) {
                AppMethodBeat.m2504i(35215);
                if (z) {
                    SendAppMessageWrapperUI.m37024a(SendAppMessageWrapperUI.this, wXMediaMessage, str, i);
                    AppMethodBeat.m2505o(35215);
                    return;
                }
                SendAppMessageWrapperUI.m37031d(SendAppMessageWrapperUI.this);
                AppMethodBeat.m2505o(35215);
            }
        };
        AppMethodBeat.m2505o(35229);
        return c240693;
    }

    /* renamed from: a */
    private static void m37022a(C8910b c8910b, WXMediaMessage wXMediaMessage) {
        AppMethodBeat.m2504i(35231);
        if (c8910b == null || wXMediaMessage == null || wXMediaMessage.mediaObject == null) {
            AppMethodBeat.m2505o(35231);
            return;
        }
        if (wXMediaMessage.mediaObject instanceof WXDynamicVideoMiniProgramObject) {
            WXDynamicVideoMiniProgramObject wXDynamicVideoMiniProgramObject = (WXDynamicVideoMiniProgramObject) wXMediaMessage.mediaObject;
            C37435f c41728a = new C41728a();
            if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(wXMediaMessage.thumbData, 0, wXMediaMessage.thumbData.length);
                if (decodeByteArray != null) {
                    c41728a.ffn = decodeByteArray.getWidth();
                    c41728a.ffo = decodeByteArray.getHeight();
                }
            }
            c41728a.videoSource = wXDynamicVideoMiniProgramObject.videoSource;
            c41728a.appThumbUrl = wXDynamicVideoMiniProgramObject.appThumbUrl;
            c41728a.ffp = 1;
            c8910b.mo20334a(c41728a);
            c8910b.cMh = null;
        }
        AppMethodBeat.m2505o(35231);
    }

    /* renamed from: b */
    private void m37028b(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(35232);
        ArrayList arrayList = new ArrayList();
        arrayList.add(((WXVideoFileObject) wXMediaMessage.mediaObject).filePath);
        if (arrayList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                C4990ab.m7416i("MicroMsg.SendAppMessageWrapperUI", "sendMultiVedeo");
                final C30076j c30076j = new C30076j(this, arrayList, getIntent(), str, 1, new C56128());
                C7305d.post(c30076j, "ChattingUI_importMultiVideo");
                getString(C25738R.string.f9238tz);
                this.tipDialog = C30379h.m48458b((Context) this, getString(C25738R.string.f9260un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(35221);
                        c30076j.dhb();
                        SendAppMessageWrapperUI.this.setResult(-1);
                        SendAppMessageWrapperUI.this.finish();
                        AppMethodBeat.m2505o(35221);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(35232);
    }

    /* renamed from: c */
    private void m37029c(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(35233);
        WXEnterpriseCardObject wXEnterpriseCardObject = (WXEnterpriseCardObject) wXMediaMessage.mediaObject;
        if (wXEnterpriseCardObject.msgType == 66 || wXEnterpriseCardObject.msgType == 42) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C9638aw.m17182Rg().mo14541a(new C26451h((String) it.next(), wXEnterpriseCardObject.cardInfo, wXEnterpriseCardObject.msgType), 0);
            }
            AppMethodBeat.m2505o(35233);
            return;
        }
        C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "sendCardMsg msgType invalid");
        setResult(0);
        finish();
        AppMethodBeat.m2505o(35233);
    }

    private void asv(String str) {
        AppMethodBeat.m2504i(138663);
        if ("wx5dfbe0a95623607b".equals(this.zKw.field_appId)) {
            if (this.yKN.getType() == 5) {
                C4990ab.m7417i("MicroMsg.SendAppMessageWrapperUI", "report(17256) url, to timeline, appId : %s", this.zKw.field_appId);
                C7060h.pYm.mo8381e(17256, str, Integer.valueOf(2));
                AppMethodBeat.m2505o(138663);
                return;
            } else if (this.yKN.getType() == 38) {
                C4990ab.m7417i("MicroMsg.SendAppMessageWrapperUI", "report(17256) video file, to timeline, appId : %s", this.zKw.field_appId);
                C7060h.pYm.mo8381e(17256, str, Integer.valueOf(1));
            }
        }
        AppMethodBeat.m2505o(138663);
    }

    public final void initView() {
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: a */
    private void m37023a(WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        String str;
        AppMethodBeat.m2504i(35230);
        if (wXMediaMessage == null || !(wXMediaMessage.mediaObject instanceof WXImageObject)) {
            C4990ab.m7420w("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg msg not img");
            str = null;
        } else {
            WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
            if (C5046bo.m7540cb(wXImageObject.imageData)) {
                str = wXImageObject.imagePath;
            } else {
                C4990ab.m7410d("MicroMsg.SendAppMessageWrapperUI", "getImagePath fileData:" + wXImageObject.imageData.length);
                str = C4733l.m7099bH(wXImageObject.imageData);
            }
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "sendImgMsg imgPath is null");
            setResult(0);
            AppMethodBeat.m2505o(35230);
            return;
        }
        String str2;
        int i = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i <= 0) {
            i = 100;
        }
        i *= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        int i2 = 1;
        long asZ = C5730e.asZ(str);
        if (asZ > 26214400 || asZ <= ((long) i)) {
            i2 = 0;
        }
        if (this.zKy || !dKq()) {
            String str3 = this.zKw.field_appId;
            String str4 = wXMediaMessage.mediaTagName;
            String str5 = wXMediaMessage.messageExt;
            String str6 = wXMediaMessage.messageAction;
            String str7 = null;
            if (!C5046bo.isNullOrNil(str3)) {
                str7 = "<msg>" + C37478f.m63228c(str3, str4, str5, str6) + "</msg>";
            }
            str2 = str7;
        } else {
            str2 = null;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C9638aw.m17182Rg().mo14541a(new C9022l(6, C1853r.m3846Yz(), (String) it.next(), str, i2, null, 0, str2, "", true, C25738R.drawable.abu), 0);
        }
        AppMethodBeat.m2505o(35230);
    }

    /* JADX WARNING: Missing block: B:16:0x007d, code skipped:
            if (com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.m58770a(r12.mController, r1.description, true, r12.m37021a(r1)) != null) goto L_0x0038;
     */
    /* JADX WARNING: Missing block: B:115:0x03e4, code skipped:
            if (com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.m58770a(r12.mController, r0, true, r12.m37021a(r4)) != null) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    static /* synthetic */ void m37030c(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.m2504i(35234);
        if (sendAppMessageWrapperUI.yKN == null) {
            C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "deal fail, WXMediaMessage is null");
            AppMethodBeat.m2505o(35234);
            return;
        }
        int type = sendAppMessageWrapperUI.yKN.getType();
        WXMediaMessage wXMediaMessage;
        C5653c b;
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
                C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "dealText fail, text is empty");
                z2 = false;
                break;
            case 2:
                wXMediaMessage = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                    WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                    if (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) {
                        b = C35844g.m58788b(sendAppMessageWrapperUI.mController, wXImageObject.imagePath, true, sendAppMessageWrapperUI.m37021a(wXMediaMessage));
                    } else {
                        b = C35844g.m58772a(sendAppMessageWrapperUI.mController, wXImageObject.imageData, true, sendAppMessageWrapperUI.m37021a(wXMediaMessage));
                    }
                } else {
                    b = C35844g.m58772a(sendAppMessageWrapperUI.mController, wXMediaMessage.thumbData, true, sendAppMessageWrapperUI.m37021a(wXMediaMessage));
                }
                if (b == null) {
                    C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "showDialogItem3 fail, invalid argument");
                } else {
                    z = true;
                }
                z2 = z;
                break;
            case 3:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    b = C35844g.m58759a(sendAppMessageWrapperUI.mController, (int) C1318a.app_attach_file_icon_music, wXMediaMessage2.title, true, sendAppMessageWrapperUI.m37021a(wXMediaMessage2));
                } else {
                    b = C35844g.m58768a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 2, sendAppMessageWrapperUI.m37021a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 4:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    b = C35844g.m58759a(sendAppMessageWrapperUI.mController, (int) C1318a.app_attach_file_icon_video, wXMediaMessage2.title, true, sendAppMessageWrapperUI.m37021a(wXMediaMessage2));
                } else {
                    b = C35844g.m58768a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 1, sendAppMessageWrapperUI.m37021a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 5:
                wXMediaMessage3 = sendAppMessageWrapperUI.yKN;
                if (C35844g.m58766a(sendAppMessageWrapperUI.mController, wXMediaMessage3.title, wXMediaMessage3.description, true, sendAppMessageWrapperUI.mController.ylL.getResources().getString(C25738R.string.atf), sendAppMessageWrapperUI.m37021a(wXMediaMessage3)) == null) {
                    z2 = false;
                    break;
                }
                break;
            case 6:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    b = C35844g.m58759a(sendAppMessageWrapperUI.mController, (int) C1318a.app_attach_file_icon_file, wXMediaMessage2.title, true, sendAppMessageWrapperUI.m37021a(wXMediaMessage2));
                } else {
                    b = C35844g.m58768a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.m37021a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 7:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage2.thumbData == null || wXMediaMessage2.thumbData.length <= 0) {
                    Bitmap b2 = C46494g.m87732b(sendAppMessageWrapperUI.zKw.field_appId, 1, C1338a.getDensity(sendAppMessageWrapperUI));
                    if (b2 == null || b2.isRecycled()) {
                        b = C35844g.m58759a(sendAppMessageWrapperUI.mController, (int) C1318a.app_attach_file_icon_webpage, wXMediaMessage2.title, true, sendAppMessageWrapperUI.m37021a(wXMediaMessage2));
                    } else {
                        b = C35844g.m58761a(sendAppMessageWrapperUI.mController, b2, wXMediaMessage2.title, wXMediaMessage2.description, sendAppMessageWrapperUI.source, sendAppMessageWrapperUI.m37021a(wXMediaMessage2));
                    }
                } else {
                    b = C35844g.m58768a(sendAppMessageWrapperUI.mController, wXMediaMessage2.title, true, 0, sendAppMessageWrapperUI.m37021a(wXMediaMessage2));
                }
                if (b == null) {
                    z2 = false;
                    break;
                }
                break;
            case 8:
                wXMediaMessage = sendAppMessageWrapperUI.yKN;
                a = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35616a((Context) sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.zKw.field_appId);
                string = sendAppMessageWrapperUI.mController.ylL.getIntent().getExtras().getString("Select_Conv_User", null);
                if (C5046bo.isNullOrNil(a)) {
                    if (C35844g.m58759a(sendAppMessageWrapperUI.mController, (int) C1318a.app_attach_file_icon_webpage, wXMediaMessage.title, true, sendAppMessageWrapperUI.m37021a(wXMediaMessage)) == null) {
                        z2 = false;
                        break;
                    }
                }
                C23273a c23273a = new C23273a(sendAppMessageWrapperUI.mController.ylL);
                c23273a.mo38972cx(string).ajE(a).mo38977h(Boolean.TRUE).mo38965KQ(C25738R.string.f9221tf).mo38966a(sendAppMessageWrapperUI.m37021a(wXMediaMessage)).gud.show();
                if (c23273a.gud == null) {
                    z2 = false;
                    break;
                }
                break;
            case 36:
                wXMediaMessage4 = sendAppMessageWrapperUI.yKN;
                if (wXMediaMessage4 != null && (wXMediaMessage4.mediaObject instanceof WXMiniProgramObject)) {
                    WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage4.mediaObject;
                    ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(wXMiniProgramObject.userName);
                    C23273a c23273a2 = new C23273a(sendAppMessageWrapperUI.mController.ylL);
                    c23273a2.mo38972cx(sendAppMessageWrapperUI.mController.ylL.getIntent().getExtras().getString("Select_Conv_User", null));
                    final View d = ((C32809i) C1720g.m3528K(C32809i.class)).mo22293d((Context) sendAppMessageWrapperUI, null);
                    string = C38496n.m65148bE(sendAppMessageWrapperUI);
                    Bundle bundle = new Bundle();
                    bundle.putByteArray(ImagesContract.IMAGE_DATA, wXMediaMessage4.thumbData);
                    bundle.putString("title", wXMediaMessage4.title);
                    bundle.putString("msg_path", wXMiniProgramObject.path);
                    ((C32809i) C1720g.m3528K(C32809i.class)).mo22289a(string, d, bundle);
                    c23273a2.mo38976ev(d);
                    c23273a2.mo38977h(Boolean.TRUE);
                    c23273a2.djy();
                    c23273a2.jbD = new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.m2504i(35214);
                            ((C32809i) C1720g.m3528K(C32809i.class)).mo22288a(string, d);
                            AppMethodBeat.m2505o(35214);
                        }
                    };
                    c23273a2.mo38965KQ(C25738R.string.f9221tf);
                    c23273a2.mo38966a(sendAppMessageWrapperUI.m37021a(wXMediaMessage4)).gud.show();
                    break;
                }
                z2 = false;
                break;
            case 38:
                wXMediaMessage3 = sendAppMessageWrapperUI.yKN;
                if (C35844g.m58767a(sendAppMessageWrapperUI.mController, wXMediaMessage3.title, wXMediaMessage3.description, true, sendAppMessageWrapperUI.mController.ylL.getResources().getString(C25738R.string.atf), sendAppMessageWrapperUI.m37021a(wXMediaMessage3), sendAppMessageWrapperUI.getResources().getString(C25738R.string.f9253ud)) == null) {
                    z2 = false;
                    break;
                }
                break;
            case IMediaObject.TYPE_BUSINESS_CARD /*45*/:
                wXMediaMessage4 = sendAppMessageWrapperUI.yKN;
                WXEnterpriseCardObject wXEnterpriseCardObject = (WXEnterpriseCardObject) wXMediaMessage4.mediaObject;
                if (wXEnterpriseCardObject.cardInfo != null && wXEnterpriseCardObject.cardInfo.length() != 0) {
                    Map z3 = C5049br.m7595z(wXEnterpriseCardObject.cardInfo, "msg");
                    if (z3 != null) {
                        String str = (String) z3.get(".msg.$nickname");
                        if (!C5046bo.isNullOrNil(str)) {
                            CharSequence a2;
                            StringBuilder stringBuilder = new StringBuilder();
                            if (wXEnterpriseCardObject.msgType == 66) {
                                a2 = ((C32873b) C1720g.m3528K(C32873b.class)).mo44300a("3552365301", "openim_card_type_name", C32874a.TYPE_WORDING);
                            } else {
                                a2 = null;
                            }
                            if (TextUtils.isEmpty(a2)) {
                                a = sendAppMessageWrapperUI.getResources().getString(C25738R.string.f9147qy);
                            } else {
                                a = String.format("[%s]", new Object[]{a2});
                            }
                            a = stringBuilder.append(a).append(str).toString();
                            sendAppMessageWrapperUI.zKw.field_appId.equals("wx4310bbd51be7d979");
                            break;
                        }
                        C4990ab.m7416i("MicroMsg.SendAppMessageWrapperUI", "dealBusinessCard error, nickname not in xml");
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "dealCard fail, card info is empty");
                }
                z2 = false;
                break;
            case 46:
                wXMediaMessage2 = sendAppMessageWrapperUI.yKN;
                C23273a c23273a3 = new C23273a(sendAppMessageWrapperUI.mController.ylL);
                c23273a3.mo38972cx(sendAppMessageWrapperUI.mController.ylL.getIntent().getExtras().getString("Select_Conv_User", null));
                if (wXMediaMessage2.thumbData != null && wXMediaMessage2.thumbData.length > 0) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(wXMediaMessage2.thumbData, 0, wXMediaMessage2.thumbData.length);
                    if (decodeByteArray != null) {
                        c23273a3.mo38971b(decodeByteArray, 2);
                    }
                }
                c23273a3.mo38977h(Boolean.TRUE);
                c23273a3.mo38965KQ(C25738R.string.f9221tf).mo38966a(sendAppMessageWrapperUI.m37021a(wXMediaMessage2)).gud.show();
                break;
            default:
                C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "unknown type = ".concat(String.valueOf(type)));
                z2 = false;
                break;
        }
        if (!z2) {
            C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "deal fail, result is false");
            sendAppMessageWrapperUI.finish();
        }
        AppMethodBeat.m2505o(35234);
    }

    /* renamed from: a */
    static /* synthetic */ void m37024a(SendAppMessageWrapperUI sendAppMessageWrapperUI, final WXMediaMessage wXMediaMessage, String str, int i) {
        AppMethodBeat.m2504i(35235);
        C4990ab.m7411d("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc msg[%s], text[%s], parsterLen[%d], scene[%d]", wXMediaMessage, str, Integer.valueOf(i), Integer.valueOf(sendAppMessageWrapperUI.scene));
        if (sendAppMessageWrapperUI.scene == 0 || sendAppMessageWrapperUI.scene == 3) {
            C37907bv.aaq().mo60662c(38, Integer.valueOf(1));
            String str2 = null;
            if (wXMediaMessage.getType() == 8) {
                if (wXMediaMessage.thumbData == null) {
                    C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "summerbig code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
                    AppMethodBeat.m2505o(35235);
                    return;
                }
                str2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35616a((Context) sendAppMessageWrapperUI, wXMediaMessage, sendAppMessageWrapperUI.zKw.field_appId);
                if (str2 == null) {
                    C4990ab.m7418v("MicroMsg.SendAppMessageWrapperUI", "summerbig sendEmoji Fail cause emojiconmd5 is null");
                    AppMethodBeat.m2505o(35235);
                    return;
                }
                EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(str2);
                if (Jd == null) {
                    C4990ab.m7416i("MicroMsg.SendAppMessageWrapperUI", "emoji is null.");
                    AppMethodBeat.m2505o(35235);
                    return;
                }
                if (Jd.field_size > C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitSendThirdPartyAppMsgEmotionBufSize"), SQLiteGlobal.journalSizeLimit)) {
                    C4990ab.m7416i("MicroMsg.SendAppMessageWrapperUI", "third party shared emoji can't bigger 512 KB");
                }
                C7060h.pYm.mo8381e(13461, sendAppMessageWrapperUI.zKw.field_appId, sendAppMessageWrapperUI.zKw.field_appName, Integer.valueOf(Jd.field_size));
            }
            String str3 = null;
            if (wXMediaMessage.getType() == 5 || wXMediaMessage.getType() == 2) {
                C4990ab.m7411d("MicroMsg.SendAppMessageWrapperUI", "report(11954), appId : %s", sendAppMessageWrapperUI.zKw.field_appId);
                str3 = C37922v.m64078nW("app_" + sendAppMessageWrapperUI.zKw.field_appId);
                C37922v.m64076Zp().mo60676y(str3, true).mo53356j("prePublishId", "app_" + sendAppMessageWrapperUI.zKw.field_appId);
            }
            final LinkedList linkedList = new LinkedList(C5046bo.m7508P(sendAppMessageWrapperUI.toUser.split(",")));
            if (wXMediaMessage.getType() == 36 || wXMediaMessage.getType() == 46) {
                final WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) wXMediaMessage.mediaObject;
                ((C42686d) C1720g.m3528K(C42686d.class)).mo44620zd(wXMiniProgramObject.userName).mo15896f(new C5681a<Void, WxaAttributes>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.m2504i(35218);
                        WxaAttributes wxaAttributes = (WxaAttributes) obj;
                        if (wxaAttributes == null) {
                            C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand info failed");
                            SendAppMessageWrapperUI.this.setResult(-1);
                            SendAppMessageWrapperUI.this.finish();
                            ReportUtil.m79192a(SendAppMessageWrapperUI.this, ReportUtil.m79195c(SendAppMessageWrapperUI.this.getIntent().getExtras(), -1), false);
                        } else {
                            SendAppMessageWrapperUI.m37025a(SendAppMessageWrapperUI.this, wxaAttributes, wXMediaMessage, wXMiniProgramObject, linkedList);
                        }
                        Void voidR = zXH;
                        AppMethodBeat.m2505o(35218);
                        return voidR;
                    }
                });
            } else if (wXMediaMessage.getType() == 2) {
                C35898l.m58843a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.m37023a(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 38) {
                C35898l.m58843a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.m37028b(wXMediaMessage, linkedList);
            } else if (wXMediaMessage.getType() == 45) {
                C35898l.m58843a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wXMediaMessage, linkedList);
                sendAppMessageWrapperUI.m37029c(wXMediaMessage, linkedList);
            } else {
                C35898l.m58843a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wXMediaMessage, linkedList);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str4 = (String) it.next();
                    String str5 = sendAppMessageWrapperUI.zKw.field_appId;
                    if (!sendAppMessageWrapperUI.zKy && sendAppMessageWrapperUI.dKq()) {
                        str5 = "";
                    }
                    C4733l.m7091a(wXMediaMessage, str5, sendAppMessageWrapperUI.zKw.field_appName, str4, 2, str2, str3);
                }
            }
            String string = sendAppMessageWrapperUI.zKw.field_appId.equals("wx4310bbd51be7d979") ? null : sendAppMessageWrapperUI.getString(C25738R.string.ata, new Object[]{sendAppMessageWrapperUI.zKw.field_appName});
            String string2 = (sendAppMessageWrapperUI.zKy || !sendAppMessageWrapperUI.dKq()) ? string == null ? sendAppMessageWrapperUI.getString(C25738R.string.at_) : string : sendAppMessageWrapperUI.getString(C25738R.string.at_);
            C45756a.m84568a(sendAppMessageWrapperUI.mController, sendAppMessageWrapperUI.getString(C25738R.string.ate), string2, sendAppMessageWrapperUI.getString(C25738R.string.ath), new C240715(), new C240704());
            if (str == null || str.length() == 0) {
                C4990ab.m7416i("MicroMsg.SendAppMessageWrapperUI", "summerbig dealSucc, text is empty");
                AppMethodBeat.m2505o(35235);
                return;
            }
            C4990ab.m7410d("MicroMsg.SendAppMessageWrapperUI", "summerbig dktext , send msg here:".concat(String.valueOf(str)));
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                C9638aw.m17182Rg().mo14541a(new C26451h((String) it2.next(), str, C1855t.m3925nK(sendAppMessageWrapperUI.toUser)), 0);
            }
            AppMethodBeat.m2505o(35235);
            return;
        }
        if (C21877n.qFw != null) {
            C21877n.qFw.mo37361a(wXMediaMessage, str, sendAppMessageWrapperUI.zKw.field_appId, sendAppMessageWrapperUI.zKw.field_appName, i);
            C21877n.qFw.cmp();
        }
        ReportUtil.m79192a(sendAppMessageWrapperUI, ReportUtil.m79195c(sendAppMessageWrapperUI.getIntent().getExtras(), 0), false);
        sendAppMessageWrapperUI.finish();
        AppMethodBeat.m2505o(35235);
    }

    /* renamed from: d */
    static /* synthetic */ void m37031d(SendAppMessageWrapperUI sendAppMessageWrapperUI) {
        AppMethodBeat.m2504i(35236);
        if (sendAppMessageWrapperUI.scene == 0 || sendAppMessageWrapperUI.scene == 3) {
            Intent intent = new Intent();
            intent.putExtra("Select_Report_Args", ReportUtil.m79195c(sendAppMessageWrapperUI.getIntent().getExtras(), -2));
            sendAppMessageWrapperUI.setResult(0, intent);
        } else {
            ReportUtil.m79192a(sendAppMessageWrapperUI, ReportUtil.m79195c(sendAppMessageWrapperUI.getIntent().getExtras(), -2), false);
        }
        sendAppMessageWrapperUI.finish();
        AppMethodBeat.m2505o(35236);
    }

    /* renamed from: a */
    static /* synthetic */ void m37025a(SendAppMessageWrapperUI sendAppMessageWrapperUI, WxaAttributes wxaAttributes, WXMediaMessage wXMediaMessage, WXMiniProgramObject wXMiniProgramObject, LinkedList linkedList) {
        Iterator it;
        String str;
        AppMethodBeat.m2504i(35237);
        C35898l.m58844a(sendAppMessageWrapperUI.jDs, sendAppMessageWrapperUI.zKw, wxaAttributes, wXMediaMessage, wXMiniProgramObject, linkedList);
        StringBuilder stringBuilder = new StringBuilder("1_");
        stringBuilder.append(sendAppMessageWrapperUI.zKw.field_appId);
        stringBuilder.append("_");
        C9638aw.m17190ZK();
        stringBuilder.append(C1183p.getString(C18628c.m29064QF()));
        stringBuilder.append("_");
        stringBuilder.append(C5046bo.anT());
        stringBuilder.append("_");
        stringBuilder.append("1");
        final String stringBuilder2 = stringBuilder.toString();
        if (wXMiniProgramObject.withShareTicket) {
            if (wxaAttributes == null) {
                C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand info failed");
                sendAppMessageWrapperUI.setResult(-1);
                sendAppMessageWrapperUI.finish();
                ReportUtil.m79192a(sendAppMessageWrapperUI, ReportUtil.m79195c(sendAppMessageWrapperUI.getIntent().getExtras(), -1), false);
                AppMethodBeat.m2505o(35237);
                return;
            }
            C1196a c1196a = new C1196a();
            c1196a.fsI = FaceManager.FACE_ACQUIRED_NO_FOCUS;
            c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/getshareinfo";
            cwl cwl = new cwl();
            cwl.csB = wxaAttributes.field_appId;
            cwl.xse = linkedList;
            c1196a.fsJ = cwl;
            c1196a.fsK = new cwm();
            final LinkedList linkedList2 = linkedList;
            final WxaAttributes wxaAttributes2 = wxaAttributes;
            final WXMiniProgramObject wXMiniProgramObject2 = wXMiniProgramObject;
            final WXMediaMessage wXMediaMessage2 = wXMediaMessage;
            C1226w.m2654a(c1196a.acD(), new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(35219);
                    C4990ab.m7417i("MicroMsg.SendAppMessageWrapperUI", "callback, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    cwm cwm = (cwm) c7472b.fsH.fsP;
                    String str2;
                    if (i != 0 || i2 != 0 || cwm == null || cwm.xsh == null) {
                        Iterator it = linkedList2.iterator();
                        while (it.hasNext()) {
                            str2 = (String) it.next();
                            String str3 = SendAppMessageWrapperUI.this.zKw.field_appId;
                            if (!SendAppMessageWrapperUI.this.zKy && SendAppMessageWrapperUI.m37034g(SendAppMessageWrapperUI.this)) {
                                str3 = "";
                            }
                            C8910b c8910b = new C8910b();
                            c8910b.appId = str3;
                            c8910b.appName = SendAppMessageWrapperUI.this.zKw.field_appName;
                            c8910b.fgr = 2;
                            SendAppMessageWrapperUI.m37027b(c8910b, wXMediaMessage2);
                            C4733l.m7085a(c8910b, wXMediaMessage2, str2);
                        }
                    } else {
                        LinkedList linkedList = cwm.xsh == null ? new LinkedList() : cwm.xsh;
                        C4990ab.m7417i("MicroMsg.SendAppMessageWrapperUI", "get wxaAppShareInfoList size = %d, toUserList size = %d", Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
                        for (int i3 = 0; i3 < linkedList2.size(); i3++) {
                            cwu cwu;
                            if (i3 < linkedList.size()) {
                                cwu = (cwu) linkedList.get(i3);
                            } else {
                                cwu = new cwu();
                            }
                            C8910b c8910b2 = new C8910b();
                            str2 = SendAppMessageWrapperUI.this.zKw.field_appId;
                            if (!SendAppMessageWrapperUI.this.zKy && SendAppMessageWrapperUI.m37034g(SendAppMessageWrapperUI.this)) {
                                str2 = "";
                            }
                            c8910b2.appId = str2;
                            c8910b2.fiQ = wxaAttributes2.field_appId;
                            c8910b2.cMg = wxaAttributes2.field_username;
                            c8910b2.cMh = wxaAttributes2.field_nickname;
                            c8910b2.fiZ = wXMiniProgramObject2.miniprogramType;
                            c8910b2.appName = SendAppMessageWrapperUI.this.zKw.field_appName;
                            c8910b2.fgr = 2;
                            c8910b2.fiV = cwu.wYs;
                            c8910b2.fiU = stringBuilder2;
                            SendAppMessageWrapperUI.m37027b(c8910b2, wXMediaMessage2);
                            C4733l.m7085a(c8910b2, wXMediaMessage2, (String) linkedList2.get(i3));
                        }
                    }
                    AppMethodBeat.m2505o(35219);
                    return 0;
                }
            });
        } else if (wxaAttributes == null) {
            C4990ab.m7412e("MicroMsg.SendAppMessageWrapperUI", "get wxaAttributes for appbrand without share ticket info failed");
            sendAppMessageWrapperUI.setResult(-1);
            sendAppMessageWrapperUI.finish();
            ReportUtil.m79192a(sendAppMessageWrapperUI, ReportUtil.m79195c(sendAppMessageWrapperUI.getIntent().getExtras(), -1), false);
            AppMethodBeat.m2505o(35237);
            return;
        } else {
            it = linkedList.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                C8910b c8910b = new C8910b();
                String str2 = sendAppMessageWrapperUI.zKw.field_appId;
                if (!sendAppMessageWrapperUI.zKy && sendAppMessageWrapperUI.dKq()) {
                    str2 = "";
                }
                c8910b.appId = str2;
                c8910b.fiQ = wxaAttributes.field_appId;
                c8910b.fiZ = wXMiniProgramObject.miniprogramType;
                c8910b.appName = sendAppMessageWrapperUI.zKw.field_appName;
                c8910b.fgr = 2;
                c8910b.cMg = wxaAttributes.field_username;
                c8910b.cMh = wxaAttributes.field_nickname;
                SendAppMessageWrapperUI.m37022a(c8910b, wXMediaMessage);
                C4733l.m7085a(c8910b, wXMediaMessage, str);
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            int i = ((String) it.next()).endsWith("chatroom") ? 1 : 0;
            String encode = C18178q.encode(C5046bo.nullAsNil(wXMiniProgramObject.webpageUrl));
            String encode2 = C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.title));
            stringBuilder2 = C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.description));
            String encode3 = C18178q.encode(C5046bo.nullAsNil(wXMiniProgramObject.path));
            C7060h.pYm.mo8381e(14127, sendAppMessageWrapperUI.zKw.field_appId, wXMiniProgramObject.userName, encode3, encode2, stringBuilder2, "", encode, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(i), str);
        }
        AppMethodBeat.m2505o(35237);
    }
}
