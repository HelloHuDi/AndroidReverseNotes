package com.tencent.p177mm.plugin.favorite.p771ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.opensdk.modelmsg.WXTextObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p410ui.C34157b;
import com.tencent.p177mm.pluginsdk.model.app.ReportUtil;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35898l;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry */
public class FavOpenApiEntry extends MMActivity {
    private String appId;
    private Intent cEp;
    private C7564ap che = new C7564ap(new C77571(), true);
    private Bundle mqu;
    private Req mqv;
    private String mqw;
    private int mqx = 0;
    private String source;

    /* renamed from: com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry$1 */
    class C77571 implements C5015a {
        C77571() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(20540);
            if (FavOpenApiEntry.this.getWindow() != null && FavOpenApiEntry.this.getWindow().getDecorView() != null && FavOpenApiEntry.this.getWindow().getDecorView().getWindowToken() != null) {
                FavOpenApiEntry.m13788a(FavOpenApiEntry.this, FavOpenApiEntry.this.mqv.message);
                AppMethodBeat.m2505o(20540);
                return false;
            } else if (FavOpenApiEntry.this.mqx < 10) {
                FavOpenApiEntry.m13789b(FavOpenApiEntry.this);
                AppMethodBeat.m2505o(20540);
                return true;
            } else {
                AppMethodBeat.m2505o(20540);
                return false;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavOpenApiEntry() {
        AppMethodBeat.m2504i(20542);
        AppMethodBeat.m2505o(20542);
    }

    /* renamed from: b */
    static /* synthetic */ int m13789b(FavOpenApiEntry favOpenApiEntry) {
        int i = favOpenApiEntry.mqx + 1;
        favOpenApiEntry.mqx = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20543);
        super.onCreate(bundle);
        if (this.cEp == null) {
            this.cEp = getIntent();
        }
        this.mqu = this.cEp.getExtras();
        this.appId = this.mqu.getString("SendAppMessageWrapper_AppId");
        if (this.appId == null) {
            this.appId = Uri.parse(this.mqu.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        }
        this.mqv = new Req(this.mqu);
        if (this.mqv.scene != 2) {
            C4990ab.m7412e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
            finish();
            AppMethodBeat.m2505o(20543);
            return;
        }
        this.mqw = getString(C25738R.string.bnl);
        this.source = getString(C25738R.string.atg, new Object[]{C39037b.getAppName(this, this.appId)});
        this.che.mo16770ae(100, 100);
        AppMethodBeat.m2505o(20543);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(20544);
        super.onNewIntent(intent);
        this.cEp = intent;
        AppMethodBeat.m2505o(20544);
    }

    public void onResume() {
        AppMethodBeat.m2504i(20545);
        super.onResume();
        AppMethodBeat.m2505o(20545);
    }

    /* renamed from: a */
    private static void m13786a(WXMediaMessage wXMediaMessage, C27966g c27966g) {
        AppMethodBeat.m2504i(20546);
        c27966g.field_sourceType = 4;
        c27966g.field_favProto.alB(wXMediaMessage.title);
        c27966g.field_favProto.alC(wXMediaMessage.description);
        AppMethodBeat.m2505o(20546);
    }

    /* renamed from: J */
    private void m13782J(C27966g c27966g) {
        AppMethodBeat.m2504i(20547);
        abl abl = new abl();
        abl.alJ(this.appId);
        abl.mo39126LN(4);
        abl.alD(C1853r.m3846Yz());
        abl.alE(C1853r.m3846Yz());
        c27966g.field_fromUser = abl.cEV;
        c27966g.field_toUser = abl.toUser;
        c27966g.field_favProto.mo74737a(abl);
        AppMethodBeat.m2505o(20547);
    }

    /* renamed from: a */
    private static aar m13785a(WXMediaMessage wXMediaMessage, String str, byte[] bArr, int i) {
        AppMethodBeat.m2504i(20548);
        aar aar = new aar();
        aar.akH(wXMediaMessage.title);
        aar.akI(wXMediaMessage.description);
        aar.mo27394LE(i);
        if (str != null) {
            aar.akV(str);
            aar.akR(C5730e.m8630cv(str));
        } else {
            String x = C1178g.m2591x(bArr);
            if (bArr.length >= 256) {
                aar.akT(x);
            } else {
                byte[] bArr2 = new byte[256];
                System.arraycopy(bArr, 0, bArr2, 0, 256);
                aar.akT(C1178g.m2591x(bArr2));
            }
            aar.akS(x);
            aar.mo27431mf((long) bArr.length);
            aar.akU(C39037b.m66382cf(aar.toString(), i));
            C5730e.m8619a(C39037b.m66370b(aar), bArr, bArr.length);
        }
        FavOpenApiEntry.m13787a(wXMediaMessage, aar, i);
        AppMethodBeat.m2505o(20548);
        return aar;
    }

    /* renamed from: a */
    private static void m13787a(WXMediaMessage wXMediaMessage, aar aar, int i) {
        AppMethodBeat.m2504i(20549);
        if (wXMediaMessage.thumbData != null) {
            String x = C1178g.m2591x(wXMediaMessage.thumbData);
            aar.akX(x);
            if (wXMediaMessage.thumbData.length >= 256) {
                aar.akY(x);
            } else {
                byte[] bArr = new byte[256];
                System.arraycopy(wXMediaMessage.thumbData, 0, bArr, 0, 256);
                aar.akY(C1178g.m2591x(bArr));
            }
            if (C5046bo.isNullOrNil(aar.mnd)) {
                aar.akU(C39037b.m66382cf(aar.toString(), i));
            }
            aar.mo27432mg((long) wXMediaMessage.thumbData.length);
            x = C39037b.m66379c(aar);
            byte[] bArr2 = wXMediaMessage.thumbData;
            C5730e.m8619a(x, bArr2, bArr2.length);
            AppMethodBeat.m2505o(20549);
            return;
        }
        aar.mo27435oY(true);
        AppMethodBeat.m2505o(20549);
    }

    /* renamed from: a */
    private C30111a m13784a(final WXMediaMessage wXMediaMessage) {
        AppMethodBeat.m2504i(20550);
        C77582 c77582 = new C30111a() {
            /* renamed from: a */
            public final void mo6399a(boolean z, String str, int i) {
                AppMethodBeat.m2504i(20541);
                if (z) {
                    C35898l.m58845a(C5068w.m7682a(FavOpenApiEntry.this.getIntent(), ConstantsAPI.SDK_VERSION, 0), FavOpenApiEntry.this.appId, wXMediaMessage);
                    FavOpenApiEntry.m13790b(FavOpenApiEntry.this, wXMediaMessage);
                    ReportUtil.m79192a(FavOpenApiEntry.this, ReportUtil.m79195c(FavOpenApiEntry.this.getIntent().getExtras(), 0), false);
                    AppMethodBeat.m2505o(20541);
                    return;
                }
                FavOpenApiEntry.this.finish();
                ReportUtil.m79192a(FavOpenApiEntry.this, ReportUtil.m79195c(FavOpenApiEntry.this.getIntent().getExtras(), 0), true);
                AppMethodBeat.m2505o(20541);
            }
        };
        AppMethodBeat.m2505o(20550);
        return c77582;
    }

    public void onPause() {
        AppMethodBeat.m2504i(20551);
        super.onPause();
        AppMethodBeat.m2505o(20551);
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: b */
    static /* synthetic */ void m13790b(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        AppMethodBeat.m2504i(20553);
        if (wXMediaMessage == null) {
            C4990ab.m7412e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            AppMethodBeat.m2505o(20553);
            return;
        }
        int type = wXMediaMessage.getType();
        C27966g c27966g;
        aar aar;
        switch (type) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (!C5046bo.isNullOrNil(wXTextObject.text)) {
                    c27966g = new C27966g();
                    c27966g.field_type = 1;
                    FavOpenApiEntry.m13786a(wXMediaMessage, c27966g);
                    c27966g.field_favProto.alC(wXTextObject.text);
                    favOpenApiEntry.m13782J(c27966g);
                    C34157b.m56005B(c27966g);
                    break;
                }
                C4990ab.m7412e("MicroMsg.FavOpenApiEntry", "addText null!");
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || C5730e.m8628ct(wXImageObject.imagePath)) {
                    c27966g = new C27966g();
                    c27966g.field_type = 2;
                    FavOpenApiEntry.m13786a(wXMediaMessage, c27966g);
                    favOpenApiEntry.m13782J(c27966g);
                    c27966g.field_favProto.wiv.add(FavOpenApiEntry.m13785a(wXMediaMessage, wXImageObject.imagePath, wXImageObject.imageData, c27966g.field_type));
                    C34157b.m56005B(c27966g);
                    break;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) wXMediaMessage.mediaObject;
                if (!C5046bo.isNullOrNil(wXMusicObject.musicDataUrl) || !C5046bo.isNullOrNil(wXMusicObject.musicUrl) || !C5046bo.isNullOrNil(wXMusicObject.musicLowBandUrl)) {
                    c27966g = new C27966g();
                    c27966g.field_type = 7;
                    FavOpenApiEntry.m13786a(wXMediaMessage, c27966g);
                    aar = new aar();
                    aar.akN(wXMusicObject.musicUrl);
                    aar.akP(wXMusicObject.musicLowBandUrl);
                    aar.akO(wXMusicObject.musicDataUrl);
                    aar.akH(wXMediaMessage.title);
                    aar.akI(wXMediaMessage.description);
                    FavOpenApiEntry.m13787a(wXMediaMessage, aar, c27966g.field_type);
                    aar.mo27434oX(true);
                    aar.mo27394LE(c27966g.field_type);
                    c27966g.field_favProto.wiv.add(aar);
                    favOpenApiEntry.m13782J(c27966g);
                    C34157b.m56005B(c27966g);
                    break;
                }
                C4990ab.m7412e("MicroMsg.FavOpenApiEntry", "addMusic, both url null");
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) wXMediaMessage.mediaObject;
                if (!C5046bo.isNullOrNil(wXVideoObject.videoLowBandUrl) || !C5046bo.isNullOrNil(wXVideoObject.videoUrl)) {
                    c27966g = new C27966g();
                    c27966g.field_type = 4;
                    FavOpenApiEntry.m13786a(wXMediaMessage, c27966g);
                    aar = new aar();
                    aar.akN(wXVideoObject.videoUrl);
                    aar.akP(wXVideoObject.videoLowBandUrl);
                    aar.akH(wXMediaMessage.title);
                    aar.akI(wXMediaMessage.description);
                    FavOpenApiEntry.m13787a(wXMediaMessage, aar, c27966g.field_type);
                    aar.mo27434oX(true);
                    aar.mo27394LE(c27966g.field_type);
                    c27966g.field_favProto.wiv.add(aar);
                    favOpenApiEntry.m13782J(c27966g);
                    C34157b.m56005B(c27966g);
                    break;
                }
                C4990ab.m7412e("MicroMsg.FavOpenApiEntry", "addVideo, both url null");
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                if (!C5046bo.isNullOrNil(wXWebpageObject.webpageUrl)) {
                    c27966g = new C27966g();
                    c27966g.field_sessionId = favOpenApiEntry.getIntent().getStringExtra("reportSessionId");
                    c27966g.field_type = 5;
                    FavOpenApiEntry.m13786a(wXMediaMessage, c27966g);
                    favOpenApiEntry.m13782J(c27966g);
                    c27966g.field_favProto.wit.alK(wXWebpageObject.webpageUrl);
                    if (wXMediaMessage.thumbData != null) {
                        aar aar2 = new aar();
                        aar2.akH(wXMediaMessage.title);
                        aar2.akI(wXMediaMessage.description);
                        FavOpenApiEntry.m13787a(wXMediaMessage, aar2, c27966g.field_type);
                        aar2.mo27434oX(true);
                        aar2.mo27394LE(c27966g.field_type);
                        c27966g.field_favProto.wiv.add(aar2);
                    }
                    C34157b.m56005B(c27966g);
                    break;
                }
                C4990ab.m7412e("MicroMsg.FavOpenApiEntry", "addUrl null!");
                break;
            case 6:
                WXFileObject wXFileObject = (WXFileObject) wXMediaMessage.mediaObject;
                if (wXFileObject.fileData == null && !C5730e.m8628ct(wXFileObject.filePath)) {
                    C4990ab.m7412e("MicroMsg.FavOpenApiEntry", "addFile data null");
                    break;
                }
                c27966g = new C27966g();
                c27966g.field_type = 8;
                FavOpenApiEntry.m13786a(wXMediaMessage, c27966g);
                favOpenApiEntry.m13782J(c27966g);
                c27966g.field_favProto.wiv.add(FavOpenApiEntry.m13785a(wXMediaMessage, wXFileObject.filePath, wXFileObject.fileData, c27966g.field_type));
                C34157b.m56005B(c27966g);
                break;
            default:
                C4990ab.m7412e("MicroMsg.FavOpenApiEntry", "unsupport type = ".concat(String.valueOf(type)));
                break;
        }
        favOpenApiEntry.finish();
        AppMethodBeat.m2505o(20553);
    }
}
