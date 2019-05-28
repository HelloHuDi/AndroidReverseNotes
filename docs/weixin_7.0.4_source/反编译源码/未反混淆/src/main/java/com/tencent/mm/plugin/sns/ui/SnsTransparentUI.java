package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.pluginsdk.ui.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.view.d;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class SnsTransparentUI extends MMActivity {
    private Map<String, Bitmap> rao = new HashMap();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsTransparentUI() {
        AppMethodBeat.i(39635);
        AppMethodBeat.o(39635);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39636);
        super.onCreate(bundle);
        this.mController.hideTitleView();
        Intent intent = getIntent();
        if (intent != null) {
            switch (intent.getIntExtra("op", -1)) {
                case 2:
                    final String stringExtra = intent.getStringExtra("adlandingXml");
                    final String stringExtra2 = intent.getStringExtra("shareTitle");
                    final String stringExtra3 = intent.getStringExtra("shareThumbUrl");
                    final String stringExtra4 = intent.getStringExtra("shareDesc");
                    final String stringExtra5 = intent.getStringExtra("shareUrl");
                    final String stringExtra6 = intent.getStringExtra("statExtStr");
                    ab.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI");
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", d.MIC_PTU_ZIPAI_MEDSEA);
                    intent2.putExtra("select_is_ret", true);
                    com.tencent.mm.bp.d.a((MMActivity) this, ".ui.transmit.SelectConversationUI", intent2, 0, new MMActivity.a() {
                        public final void c(int i, int i2, Intent intent) {
                            AppMethodBeat.i(39633);
                            if (i2 == -1) {
                                String str;
                                if (intent == null) {
                                    str = null;
                                } else {
                                    str = intent.getStringExtra("Select_Conv_User");
                                }
                                if (str == null || str.length() == 0) {
                                    ab.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
                                    SnsTransparentUI.this.finish();
                                    AppMethodBeat.o(39633);
                                    return;
                                }
                                ab.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
                                final String str2 = stringExtra;
                                final SnsTransparentUI snsTransparentUI = SnsTransparentUI.this;
                                t.a.vlq.a(snsTransparentUI.mController, stringExtra2, stringExtra3, stringExtra4, true, snsTransparentUI.getResources().getString(R.string.tf), new q.a() {
                                    public final void a(boolean z, final String str, int i) {
                                        AppMethodBeat.i(39632);
                                        if (z) {
                                            final WXMediaMessage wXMediaMessage = new WXMediaMessage();
                                            wXMediaMessage.title = stringExtra2;
                                            wXMediaMessage.description = stringExtra4;
                                            WXWebpageObject wXWebpageObject = new WXWebpageObject();
                                            wXWebpageObject.canvasPageXml = str2;
                                            wXWebpageObject.webpageUrl = stringExtra5;
                                            wXMediaMessage.mediaObject = wXWebpageObject;
                                            if (SnsTransparentUI.this.rao.containsKey(stringExtra3)) {
                                                Bitmap bitmap = (Bitmap) SnsTransparentUI.this.rao.get(stringExtra3);
                                                if (!(bitmap == null || bitmap.isRecycled())) {
                                                    ab.i("SnsTransparentUI", "thumb image is not null");
                                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                                }
                                                py pyVar = new py();
                                                pyVar.cMe.cEl = wXMediaMessage;
                                                pyVar.cMe.toUser = str;
                                                pyVar.cMe.cMf = 49;
                                                pyVar.cMe.cMg = "";
                                                pyVar.cMe.cMh = "";
                                                pyVar.cMe.cMn = stringExtra6;
                                                com.tencent.mm.sdk.b.a.xxA.m(pyVar);
                                                if (!TextUtils.isEmpty(str)) {
                                                    qb qbVar = new qb();
                                                    qbVar.cMq.cMr = str;
                                                    qbVar.cMq.content = str;
                                                    qbVar.cMq.type = com.tencent.mm.model.t.nK(str);
                                                    qbVar.cMq.flags = 0;
                                                    com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                                                }
                                                h.bQ(snsTransparentUI, snsTransparentUI.getString(R.string.to));
                                                SnsTransparentUI.this.finish();
                                                AppMethodBeat.o(39632);
                                                return;
                                            }
                                            ag.ck(stringExtra3);
                                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", stringExtra3, false, 1000000001, new f.a() {
                                                public final void cpu() {
                                                }

                                                public final void cmD() {
                                                    AppMethodBeat.i(39630);
                                                    h.bQ(snsTransparentUI, snsTransparentUI.getString(R.string.egu));
                                                    SnsTransparentUI.this.finish();
                                                    AppMethodBeat.o(39630);
                                                }

                                                public final void YJ(String str) {
                                                    AppMethodBeat.i(39631);
                                                    try {
                                                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                                                        SnsTransparentUI.this.rao.put(stringExtra3, decodeFile);
                                                        if (!(decodeFile == null || decodeFile.isRecycled())) {
                                                            ab.i("SnsTransparentUI", "thumb image is not null");
                                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                            decodeFile.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                                            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                                        }
                                                        py pyVar = new py();
                                                        pyVar.cMe.cEl = wXMediaMessage;
                                                        pyVar.cMe.toUser = str;
                                                        pyVar.cMe.cMf = 49;
                                                        pyVar.cMe.cMg = "";
                                                        pyVar.cMe.cMh = "";
                                                        pyVar.cMe.cMn = stringExtra6;
                                                        com.tencent.mm.sdk.b.a.xxA.m(pyVar);
                                                        if (!TextUtils.isEmpty(str)) {
                                                            qb qbVar = new qb();
                                                            qbVar.cMq.cMr = str;
                                                            qbVar.cMq.content = str;
                                                            qbVar.cMq.type = com.tencent.mm.model.t.nK(str);
                                                            qbVar.cMq.flags = 0;
                                                            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                                                        }
                                                        h.bQ(snsTransparentUI, snsTransparentUI.getString(R.string.to));
                                                        SnsTransparentUI.this.finish();
                                                        AppMethodBeat.o(39631);
                                                    } catch (Exception e) {
                                                        ab.e("SnsTransparentUI", "this has a error : " + e.toString());
                                                        SnsTransparentUI.this.finish();
                                                        AppMethodBeat.o(39631);
                                                    }
                                                }
                                            });
                                            AppMethodBeat.o(39632);
                                            return;
                                        }
                                        h.bQ(snsTransparentUI, snsTransparentUI.getString(R.string.egu));
                                        SnsTransparentUI.this.finish();
                                        AppMethodBeat.o(39632);
                                    }
                                });
                                AppMethodBeat.o(39633);
                                return;
                            }
                            SnsTransparentUI.this.finish();
                            AppMethodBeat.o(39633);
                        }
                    });
                    AppMethodBeat.o(39636);
                    return;
                case 4:
                    c.a.vrD.a(this, intent.getStringExtra("phoneNum"), new OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(39634);
                            ad.eQ(SnsTransparentUI.this);
                            SnsTransparentUI.this.finish();
                            AppMethodBeat.o(39634);
                        }
                    }, new Bundle());
                    break;
            }
        }
        AppMethodBeat.o(39636);
    }
}
