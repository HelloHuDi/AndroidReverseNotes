package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C26217py;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C29064ad;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C23282t.C23281a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30129c.C30130a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.view.C31128d;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.sns.ui.SnsTransparentUI */
public class SnsTransparentUI extends MMActivity {
    private Map<String, Bitmap> rao = new HashMap();

    /* renamed from: com.tencent.mm.plugin.sns.ui.SnsTransparentUI$2 */
    class C291622 implements OnDismissListener {
        C291622() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(39634);
            C29064ad.m46207eQ(SnsTransparentUI.this);
            SnsTransparentUI.this.finish();
            AppMethodBeat.m2505o(39634);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SnsTransparentUI() {
        AppMethodBeat.m2504i(39635);
        AppMethodBeat.m2505o(39635);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(39636);
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
                    C4990ab.m7416i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI");
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", C31128d.MIC_PTU_ZIPAI_MEDSEA);
                    intent2.putExtra("select_is_ret", true);
                    C25985d.m41460a((MMActivity) this, ".ui.transmit.SelectConversationUI", intent2, 0, new C5186a() {
                        /* renamed from: c */
                        public final void mo6069c(int i, int i2, Intent intent) {
                            AppMethodBeat.m2504i(39633);
                            if (i2 == -1) {
                                String str;
                                if (intent == null) {
                                    str = null;
                                } else {
                                    str = intent.getStringExtra("Select_Conv_User");
                                }
                                if (str == null || str.length() == 0) {
                                    C4990ab.m7412e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
                                    SnsTransparentUI.this.finish();
                                    AppMethodBeat.m2505o(39633);
                                    return;
                                }
                                C4990ab.m7416i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
                                final String str2 = stringExtra;
                                final SnsTransparentUI snsTransparentUI = SnsTransparentUI.this;
                                C23281a.vlq.mo30687a(snsTransparentUI.mController, stringExtra2, stringExtra3, stringExtra4, true, snsTransparentUI.getResources().getString(C25738R.string.f9221tf), new C30111a() {
                                    /* renamed from: a */
                                    public final void mo6399a(boolean z, final String str, int i) {
                                        AppMethodBeat.m2504i(39632);
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
                                                    C4990ab.m7416i("SnsTransparentUI", "thumb image is not null");
                                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                                    wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                                }
                                                C26217py c26217py = new C26217py();
                                                c26217py.cMe.cEl = wXMediaMessage;
                                                c26217py.cMe.toUser = str;
                                                c26217py.cMe.cMf = 49;
                                                c26217py.cMe.cMg = "";
                                                c26217py.cMe.cMh = "";
                                                c26217py.cMe.cMn = stringExtra6;
                                                C4879a.xxA.mo10055m(c26217py);
                                                if (!TextUtils.isEmpty(str)) {
                                                    C18372qb c18372qb = new C18372qb();
                                                    c18372qb.cMq.cMr = str;
                                                    c18372qb.cMq.content = str;
                                                    c18372qb.cMq.type = C1855t.m3925nK(str);
                                                    c18372qb.cMq.flags = 0;
                                                    C4879a.xxA.mo10055m(c18372qb);
                                                }
                                                C30379h.m48465bQ(snsTransparentUI, snsTransparentUI.getString(C25738R.string.f9229to));
                                                SnsTransparentUI.this.finish();
                                                AppMethodBeat.m2505o(39632);
                                                return;
                                            }
                                            C4995ag.m7428ck(stringExtra3);
                                            C13473h.m21623c("adId", stringExtra3, false, 1000000001, new C3951a() {
                                                public final void cpu() {
                                                }

                                                public final void cmD() {
                                                    AppMethodBeat.m2504i(39630);
                                                    C30379h.m48465bQ(snsTransparentUI, snsTransparentUI.getString(C25738R.string.egu));
                                                    SnsTransparentUI.this.finish();
                                                    AppMethodBeat.m2505o(39630);
                                                }

                                                /* renamed from: YJ */
                                                public final void mo8627YJ(String str) {
                                                    AppMethodBeat.m2504i(39631);
                                                    try {
                                                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                                                        SnsTransparentUI.this.rao.put(stringExtra3, decodeFile);
                                                        if (!(decodeFile == null || decodeFile.isRecycled())) {
                                                            C4990ab.m7416i("SnsTransparentUI", "thumb image is not null");
                                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                                            decodeFile.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                                            wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                                                        }
                                                        C26217py c26217py = new C26217py();
                                                        c26217py.cMe.cEl = wXMediaMessage;
                                                        c26217py.cMe.toUser = str;
                                                        c26217py.cMe.cMf = 49;
                                                        c26217py.cMe.cMg = "";
                                                        c26217py.cMe.cMh = "";
                                                        c26217py.cMe.cMn = stringExtra6;
                                                        C4879a.xxA.mo10055m(c26217py);
                                                        if (!TextUtils.isEmpty(str)) {
                                                            C18372qb c18372qb = new C18372qb();
                                                            c18372qb.cMq.cMr = str;
                                                            c18372qb.cMq.content = str;
                                                            c18372qb.cMq.type = C1855t.m3925nK(str);
                                                            c18372qb.cMq.flags = 0;
                                                            C4879a.xxA.mo10055m(c18372qb);
                                                        }
                                                        C30379h.m48465bQ(snsTransparentUI, snsTransparentUI.getString(C25738R.string.f9229to));
                                                        SnsTransparentUI.this.finish();
                                                        AppMethodBeat.m2505o(39631);
                                                    } catch (Exception e) {
                                                        C4990ab.m7412e("SnsTransparentUI", "this has a error : " + e.toString());
                                                        SnsTransparentUI.this.finish();
                                                        AppMethodBeat.m2505o(39631);
                                                    }
                                                }
                                            });
                                            AppMethodBeat.m2505o(39632);
                                            return;
                                        }
                                        C30379h.m48465bQ(snsTransparentUI, snsTransparentUI.getString(C25738R.string.egu));
                                        SnsTransparentUI.this.finish();
                                        AppMethodBeat.m2505o(39632);
                                    }
                                });
                                AppMethodBeat.m2505o(39633);
                                return;
                            }
                            SnsTransparentUI.this.finish();
                            AppMethodBeat.m2505o(39633);
                        }
                    });
                    AppMethodBeat.m2505o(39636);
                    return;
                case 4:
                    C30130a.vrD.mo30689a(this, intent.getStringExtra("phoneNum"), new C291622(), new Bundle());
                    break;
            }
        }
        AppMethodBeat.m2505o(39636);
    }
}
