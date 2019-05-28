package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.e;

@a(7)
public class FavOpenApiEntry extends MMActivity {
    private String appId;
    private Intent cEp;
    private ap che = new ap(new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(20540);
            if (FavOpenApiEntry.this.getWindow() != null && FavOpenApiEntry.this.getWindow().getDecorView() != null && FavOpenApiEntry.this.getWindow().getDecorView().getWindowToken() != null) {
                FavOpenApiEntry.a(FavOpenApiEntry.this, FavOpenApiEntry.this.mqv.message);
                AppMethodBeat.o(20540);
                return false;
            } else if (FavOpenApiEntry.this.mqx < 10) {
                FavOpenApiEntry.b(FavOpenApiEntry.this);
                AppMethodBeat.o(20540);
                return true;
            } else {
                AppMethodBeat.o(20540);
                return false;
            }
        }
    }, true);
    private Bundle mqu;
    private Req mqv;
    private String mqw;
    private int mqx = 0;
    private String source;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavOpenApiEntry() {
        AppMethodBeat.i(20542);
        AppMethodBeat.o(20542);
    }

    static /* synthetic */ int b(FavOpenApiEntry favOpenApiEntry) {
        int i = favOpenApiEntry.mqx + 1;
        favOpenApiEntry.mqx = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20543);
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
            ab.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
            finish();
            AppMethodBeat.o(20543);
            return;
        }
        this.mqw = getString(R.string.bnl);
        this.source = getString(R.string.atg, new Object[]{b.getAppName(this, this.appId)});
        this.che.ae(100, 100);
        AppMethodBeat.o(20543);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(20544);
        super.onNewIntent(intent);
        this.cEp = intent;
        AppMethodBeat.o(20544);
    }

    public void onResume() {
        AppMethodBeat.i(20545);
        super.onResume();
        AppMethodBeat.o(20545);
    }

    private static void a(WXMediaMessage wXMediaMessage, g gVar) {
        AppMethodBeat.i(20546);
        gVar.field_sourceType = 4;
        gVar.field_favProto.alB(wXMediaMessage.title);
        gVar.field_favProto.alC(wXMediaMessage.description);
        AppMethodBeat.o(20546);
    }

    private void J(g gVar) {
        AppMethodBeat.i(20547);
        abl abl = new abl();
        abl.alJ(this.appId);
        abl.LN(4);
        abl.alD(r.Yz());
        abl.alE(r.Yz());
        gVar.field_fromUser = abl.cEV;
        gVar.field_toUser = abl.toUser;
        gVar.field_favProto.a(abl);
        AppMethodBeat.o(20547);
    }

    private static aar a(WXMediaMessage wXMediaMessage, String str, byte[] bArr, int i) {
        AppMethodBeat.i(20548);
        aar aar = new aar();
        aar.akH(wXMediaMessage.title);
        aar.akI(wXMediaMessage.description);
        aar.LE(i);
        if (str != null) {
            aar.akV(str);
            aar.akR(e.cv(str));
        } else {
            String x = com.tencent.mm.a.g.x(bArr);
            if (bArr.length >= 256) {
                aar.akT(x);
            } else {
                byte[] bArr2 = new byte[256];
                System.arraycopy(bArr, 0, bArr2, 0, 256);
                aar.akT(com.tencent.mm.a.g.x(bArr2));
            }
            aar.akS(x);
            aar.mf((long) bArr.length);
            aar.akU(b.cf(aar.toString(), i));
            e.a(b.b(aar), bArr, bArr.length);
        }
        a(wXMediaMessage, aar, i);
        AppMethodBeat.o(20548);
        return aar;
    }

    private static void a(WXMediaMessage wXMediaMessage, aar aar, int i) {
        AppMethodBeat.i(20549);
        if (wXMediaMessage.thumbData != null) {
            String x = com.tencent.mm.a.g.x(wXMediaMessage.thumbData);
            aar.akX(x);
            if (wXMediaMessage.thumbData.length >= 256) {
                aar.akY(x);
            } else {
                byte[] bArr = new byte[256];
                System.arraycopy(wXMediaMessage.thumbData, 0, bArr, 0, 256);
                aar.akY(com.tencent.mm.a.g.x(bArr));
            }
            if (bo.isNullOrNil(aar.mnd)) {
                aar.akU(b.cf(aar.toString(), i));
            }
            aar.mg((long) wXMediaMessage.thumbData.length);
            x = b.c(aar);
            byte[] bArr2 = wXMediaMessage.thumbData;
            e.a(x, bArr2, bArr2.length);
            AppMethodBeat.o(20549);
            return;
        }
        aar.oY(true);
        AppMethodBeat.o(20549);
    }

    private q.a a(final WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(20550);
        AnonymousClass2 anonymousClass2 = new q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(20541);
                if (z) {
                    l.a(w.a(FavOpenApiEntry.this.getIntent(), ConstantsAPI.SDK_VERSION, 0), FavOpenApiEntry.this.appId, wXMediaMessage);
                    FavOpenApiEntry.b(FavOpenApiEntry.this, wXMediaMessage);
                    ReportUtil.a(FavOpenApiEntry.this, ReportUtil.c(FavOpenApiEntry.this.getIntent().getExtras(), 0), false);
                    AppMethodBeat.o(20541);
                    return;
                }
                FavOpenApiEntry.this.finish();
                ReportUtil.a(FavOpenApiEntry.this, ReportUtil.c(FavOpenApiEntry.this.getIntent().getExtras(), 0), true);
                AppMethodBeat.o(20541);
            }
        };
        AppMethodBeat.o(20550);
        return anonymousClass2;
    }

    public void onPause() {
        AppMethodBeat.i(20551);
        super.onPause();
        AppMethodBeat.o(20551);
    }

    public final int getLayoutId() {
        return -1;
    }

    static /* synthetic */ void b(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(20553);
        if (wXMediaMessage == null) {
            ab.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            AppMethodBeat.o(20553);
            return;
        }
        int type = wXMediaMessage.getType();
        g gVar;
        aar aar;
        switch (type) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (!bo.isNullOrNil(wXTextObject.text)) {
                    gVar = new g();
                    gVar.field_type = 1;
                    a(wXMediaMessage, gVar);
                    gVar.field_favProto.alC(wXTextObject.text);
                    favOpenApiEntry.J(gVar);
                    com.tencent.mm.plugin.fav.ui.b.B(gVar);
                    break;
                }
                ab.e("MicroMsg.FavOpenApiEntry", "addText null!");
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || e.ct(wXImageObject.imagePath)) {
                    gVar = new g();
                    gVar.field_type = 2;
                    a(wXMediaMessage, gVar);
                    favOpenApiEntry.J(gVar);
                    gVar.field_favProto.wiv.add(a(wXMediaMessage, wXImageObject.imagePath, wXImageObject.imageData, gVar.field_type));
                    com.tencent.mm.plugin.fav.ui.b.B(gVar);
                    break;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) wXMediaMessage.mediaObject;
                if (!bo.isNullOrNil(wXMusicObject.musicDataUrl) || !bo.isNullOrNil(wXMusicObject.musicUrl) || !bo.isNullOrNil(wXMusicObject.musicLowBandUrl)) {
                    gVar = new g();
                    gVar.field_type = 7;
                    a(wXMediaMessage, gVar);
                    aar = new aar();
                    aar.akN(wXMusicObject.musicUrl);
                    aar.akP(wXMusicObject.musicLowBandUrl);
                    aar.akO(wXMusicObject.musicDataUrl);
                    aar.akH(wXMediaMessage.title);
                    aar.akI(wXMediaMessage.description);
                    a(wXMediaMessage, aar, gVar.field_type);
                    aar.oX(true);
                    aar.LE(gVar.field_type);
                    gVar.field_favProto.wiv.add(aar);
                    favOpenApiEntry.J(gVar);
                    com.tencent.mm.plugin.fav.ui.b.B(gVar);
                    break;
                }
                ab.e("MicroMsg.FavOpenApiEntry", "addMusic, both url null");
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) wXMediaMessage.mediaObject;
                if (!bo.isNullOrNil(wXVideoObject.videoLowBandUrl) || !bo.isNullOrNil(wXVideoObject.videoUrl)) {
                    gVar = new g();
                    gVar.field_type = 4;
                    a(wXMediaMessage, gVar);
                    aar = new aar();
                    aar.akN(wXVideoObject.videoUrl);
                    aar.akP(wXVideoObject.videoLowBandUrl);
                    aar.akH(wXMediaMessage.title);
                    aar.akI(wXMediaMessage.description);
                    a(wXMediaMessage, aar, gVar.field_type);
                    aar.oX(true);
                    aar.LE(gVar.field_type);
                    gVar.field_favProto.wiv.add(aar);
                    favOpenApiEntry.J(gVar);
                    com.tencent.mm.plugin.fav.ui.b.B(gVar);
                    break;
                }
                ab.e("MicroMsg.FavOpenApiEntry", "addVideo, both url null");
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                if (!bo.isNullOrNil(wXWebpageObject.webpageUrl)) {
                    gVar = new g();
                    gVar.field_sessionId = favOpenApiEntry.getIntent().getStringExtra("reportSessionId");
                    gVar.field_type = 5;
                    a(wXMediaMessage, gVar);
                    favOpenApiEntry.J(gVar);
                    gVar.field_favProto.wit.alK(wXWebpageObject.webpageUrl);
                    if (wXMediaMessage.thumbData != null) {
                        aar aar2 = new aar();
                        aar2.akH(wXMediaMessage.title);
                        aar2.akI(wXMediaMessage.description);
                        a(wXMediaMessage, aar2, gVar.field_type);
                        aar2.oX(true);
                        aar2.LE(gVar.field_type);
                        gVar.field_favProto.wiv.add(aar2);
                    }
                    com.tencent.mm.plugin.fav.ui.b.B(gVar);
                    break;
                }
                ab.e("MicroMsg.FavOpenApiEntry", "addUrl null!");
                break;
            case 6:
                WXFileObject wXFileObject = (WXFileObject) wXMediaMessage.mediaObject;
                if (wXFileObject.fileData == null && !e.ct(wXFileObject.filePath)) {
                    ab.e("MicroMsg.FavOpenApiEntry", "addFile data null");
                    break;
                }
                gVar = new g();
                gVar.field_type = 8;
                a(wXMediaMessage, gVar);
                favOpenApiEntry.J(gVar);
                gVar.field_favProto.wiv.add(a(wXMediaMessage, wXFileObject.filePath, wXFileObject.fileData, gVar.field_type));
                com.tencent.mm.plugin.fav.ui.b.B(gVar);
                break;
            default:
                ab.e("MicroMsg.FavOpenApiEntry", "unsupport type = ".concat(String.valueOf(type)));
                break;
        }
        favOpenApiEntry.finish();
        AppMethodBeat.o(20553);
    }
}
