package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.he;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class TVInfoUI extends MMPreference implements f, a {
    private long cvx;
    protected ProgressDialog ehJ = null;
    protected com.tencent.mm.ui.base.preference.f ehK;
    private TextView gne;
    private ImageView klm;
    private boolean qdh = false;
    private boolean qfD = false;
    private String qwB = "";
    private TextView qwC;
    private c.a qwD;
    private b qwE;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void g(TVInfoUI tVInfoUI) {
        AppMethodBeat.i(24935);
        tVInfoUI.chn();
        AppMethodBeat.o(24935);
    }

    public final int getLayoutId() {
        return R.layout.b0v;
    }

    public final int JC() {
        return R.xml.cm;
    }

    public final int aWi() {
        return R.layout.b0w;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24918);
        super.onCreate(bundle);
        x.b((a) this);
        initView();
        AppMethodBeat.o(24918);
    }

    public void onResume() {
        AppMethodBeat.i(24919);
        super.onResume();
        aw.Rg().a(552, (f) this);
        AppMethodBeat.o(24919);
    }

    public void onPause() {
        AppMethodBeat.i(24920);
        aw.Rg().b(552, (f) this);
        super.onPause();
        AppMethodBeat.o(24920);
    }

    public void onDestroy() {
        AppMethodBeat.i(24921);
        x.c((a) this);
        super.onDestroy();
        AppMethodBeat.o(24921);
    }

    public final void initView() {
        AppMethodBeat.i(24922);
        setMMTitle((int) R.string.dyz);
        this.ehK = this.yCw;
        this.gne = (TextView) findViewById(R.id.ezj);
        this.qwC = (TextView) findViewById(R.id.ezi);
        String stringExtra = getIntent().getStringExtra("key_TV_xml");
        if (bo.isNullOrNil(stringExtra)) {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_TV_xml_bytes");
            if (byteArrayExtra != null) {
                stringExtra = new String(byteArrayExtra);
            }
        }
        ab.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", stringExtra);
        this.qwD = c.WN(stringExtra);
        if (this.qwD == null) {
            ab.e("MicroMsg.TVInfoUI", "initView(), tv == null");
            finish();
            AppMethodBeat.o(24922);
            return;
        }
        a(this.qwD);
        AppMethodBeat.o(24922);
    }

    private void a(final c.a aVar) {
        AppMethodBeat.i(24923);
        if (aVar == null) {
            ab.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
            finish();
            AppMethodBeat.o(24923);
            return;
        }
        this.gne.setText(aVar.field_title);
        if (bo.isNullOrNil(aVar.field_topic)) {
            this.qwC.setVisibility(8);
        } else {
            this.qwC.setText(aVar.field_topic);
        }
        this.klm = (ImageView) findViewById(R.id.ezg);
        if (!bo.isNullOrNil(aVar.field_playurl)) {
            ImageView imageView = (ImageView) findViewById(R.id.ezh);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(24910);
                    h.pYm.e(10987, Integer.valueOf(2), aVar.field_playstatid, "", "");
                    TVInfoUI.a(TVInfoUI.this, aVar.field_playurl);
                    AppMethodBeat.o(24910);
                }
            });
            this.klm.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(24911);
                    h.pYm.e(10987, Integer.valueOf(2), aVar.field_playstatid, "", "");
                    TVInfoUI.a(TVInfoUI.this, aVar.field_playurl);
                    AppMethodBeat.o(24911);
                }
            });
        }
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24912);
                TVInfoUI.a(TVInfoUI.this);
                AppMethodBeat.o(24912);
                return true;
            }
        });
        if (!(bo.isNullOrNil(aVar.field_id) || this.qfD || getIntent().getBooleanExtra("key_TV_come_from_shake", false))) {
            ab.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", aVar.field_id, Integer.valueOf(getIntent().getIntExtra("key_TV_getProductInfoScene", 0)));
            aw.Rg().a(new com.tencent.mm.plugin.shake.d.a.b(aVar.field_id, r0), 0);
            this.qfD = true;
        }
        this.klm.setVisibility(0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24913);
                TVInfoUI.this.finish();
                AppMethodBeat.o(24913);
                return true;
            }
        });
        ab.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(24914);
                TVInfoUI.a(TVInfoUI.this, aVar);
                TVInfoUI.b(TVInfoUI.this, aVar);
                AppMethodBeat.o(24914);
            }
        });
        AppMethodBeat.o(24923);
    }

    private void chn() {
        AppMethodBeat.i(24924);
        this.cvx = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0);
        if (this.cvx > 0 && aw.RK()) {
            aw.ZK();
            bi jf = com.tencent.mm.model.c.XO().jf(this.cvx);
            if (jf.field_msgId > 0) {
                jf.jv(this.qwE.anJ());
                aw.ZK();
                com.tencent.mm.model.c.XO().a(this.cvx, jf);
            }
        }
        AppMethodBeat.o(24924);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(24925);
        ab.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", preference.mKey);
        if (this.qwD == null || this.qwD.qiL == null) {
            ab.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
            AppMethodBeat.o(24925);
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            ab.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2));
            if (i < 0 || i >= this.qwD.qiL.size()) {
                ab.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", Integer.valueOf(i), Integer.valueOf(this.qwD.qiL.size()));
                AppMethodBeat.o(24925);
                return false;
            }
            com.tencent.mm.plugin.shake.e.a aVar = (com.tencent.mm.plugin.shake.e.a) this.qwD.qiL.get(i);
            if (aVar == null) {
                ab.w("MicroMsg.TVInfoUI", "actionList == null");
                AppMethodBeat.o(24925);
                return false;
            }
            if (i2 >= 0) {
                if (i2 < aVar.fPL.size()) {
                    com.tencent.mm.plugin.shake.e.a.a aVar2 = (com.tencent.mm.plugin.shake.e.a.a) aVar.fPL.get(i2);
                    if (aVar2 == null) {
                        ab.w("MicroMsg.TVInfoUI", "action == null");
                        AppMethodBeat.o(24925);
                        return false;
                    }
                    ab.v("MicroMsg.TVInfoUI", "action type:" + aVar2.type + ", target:" + aVar2.qwN + ", targetDesc:" + aVar2.qwP + ", targetDesc2:" + aVar2.qwQ);
                    Intent intent;
                    if (aVar2.type == 3) {
                        intent = new Intent();
                        intent.putExtra("rawUrl", aVar2.qwN);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("geta8key_scene", 10);
                        intent.putExtra("srcUsername", aVar2.qwQ);
                        com.tencent.mm.plugin.shake.a.gkE.i(intent, this);
                    } else if (aVar2.type == 4) {
                        aw.ZK();
                        ad aoO = com.tencent.mm.model.c.XM().aoO(aVar2.qwN);
                        if (aoO != null) {
                            Intent intent2 = new Intent();
                            if (com.tencent.mm.n.a.jh(aoO.field_type) && aoO.dsf()) {
                                z.aeR().qP(aVar2.qwN);
                                if (aVar2.qwP.equals("1")) {
                                    intent2.putExtra("Chat_User", aVar2.qwN);
                                    intent2.putExtra("finish_direct", true);
                                    com.tencent.mm.plugin.shake.a.gkE.d(intent2, (Context) this);
                                }
                            }
                            intent2.putExtra("Contact_User", aVar2.qwN);
                            intent2.putExtra("force_get_contact", true);
                            d.b((Context) this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                        }
                    } else if (aVar2.type == 5) {
                        com.tencent.mm.sdk.b.b heVar = new he();
                        heVar.cBW.actionCode = 11;
                        heVar.cBW.result = aVar2.qwN;
                        heVar.cBW.context = this;
                        heVar.callback = null;
                        com.tencent.mm.sdk.b.a.xxA.a(heVar, Looper.myLooper());
                    } else if (aVar2.type == 6) {
                        intent = new Intent();
                        intent.putExtra("key_product_id", aVar2.qwN);
                        intent.putExtra("key_product_scene", 9);
                        d.b((Context) this, "product", ".ui.MallProductUI", intent);
                    }
                    AppMethodBeat.o(24925);
                    return true;
                }
            }
            ab.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", Integer.valueOf(i2), Integer.valueOf(aVar.fPL.size()));
            AppMethodBeat.o(24925);
            return false;
        } catch (Exception e) {
            ab.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", e.getMessage());
            ab.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
            AppMethodBeat.o(24925);
            return false;
        }
    }

    public final void m(final String str, final Bitmap bitmap) {
        AppMethodBeat.i(24926);
        if (str != null) {
            String str2 = "MicroMsg.TVInfoUI";
            String str3 = "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap == null);
            ab.d(str2, str3, objArr);
            try {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(24917);
                        if (TVInfoUI.this.qwB != null && TVInfoUI.this.qwB.equals(str)) {
                            if (!(TVInfoUI.this.klm == null || bitmap == null)) {
                                TVInfoUI.this.klm.setImageBitmap(bitmap);
                                TVInfoUI.g(TVInfoUI.this);
                            }
                            TVInfoUI.this.qdh = true;
                        }
                        AppMethodBeat.o(24917);
                    }
                });
                AppMethodBeat.o(24926);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", e.getLocalizedMessage());
                ab.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
                AppMethodBeat.o(24926);
                return;
            }
        }
        ab.e("MicroMsg.TVInfoUI", "onUpdate pic, url  is null ");
        AppMethodBeat.o(24926);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(24927);
        if (mVar == null) {
            ab.w("MicroMsg.TVInfoUI", "scene == null");
            AppMethodBeat.o(24927);
            return;
        }
        if (mVar.getType() == 552) {
            if (i != 0 || i2 != 0) {
                ab.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", Integer.valueOf(i), Integer.valueOf(i2));
                Toast.makeText(this, R.string.dz0, 0).show();
                AppMethodBeat.o(24927);
                return;
            } else if (this.qwD == null) {
                ab.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
                AppMethodBeat.o(24927);
                return;
            } else {
                aov aov;
                com.tencent.mm.plugin.shake.d.a.b bVar = (com.tencent.mm.plugin.shake.d.a.b) mVar;
                if (bVar.ehh == null || bVar.ehh.fsH.fsP == null) {
                    aov = null;
                } else {
                    aov = (aov) bVar.ehh.fsH.fsP;
                }
                if (aov == null) {
                    ab.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
                    AppMethodBeat.o(24927);
                    return;
                } else if (aov.vOt != null) {
                    ab.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + aov.vOt);
                    c.a WN = c.WN(aov.vOt);
                    if (!(this.qwD == null || this.qwD.field_xml == null || WN == null || WN.field_xml == null || this.qwD.field_xml.equals(WN.field_xml))) {
                        this.qwD = WN;
                        a(this.qwD);
                    }
                }
            }
        }
        AppMethodBeat.o(24927);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI, c.a aVar) {
        AppMethodBeat.i(24931);
        if (aVar == null || bo.isNullOrNil(aVar.field_thumburl)) {
            AppMethodBeat.o(24931);
            return;
        }
        tVInfoUI.qwE = new b(aVar);
        tVInfoUI.qwB = tVInfoUI.qwE.anL();
        Bitmap a = x.a(tVInfoUI.qwE);
        ab.d("MicroMsg.TVInfoUI", "initHeaderImg photo = %s", a);
        if (a != null) {
            tVInfoUI.klm.setImageBitmap(a);
            tVInfoUI.qdh = true;
            tVInfoUI.chn();
            AppMethodBeat.o(24931);
            return;
        }
        tVInfoUI.klm.setImageDrawable(tVInfoUI.getResources().getDrawable(R.raw.tv_info_thumb_default));
        AppMethodBeat.o(24931);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI) {
        AppMethodBeat.i(24932);
        if (tVInfoUI.qwD == null) {
            ab.w("MicroMsg.TVInfoUI", "shareToFriend, but tv is null");
            AppMethodBeat.o(24932);
            return;
        }
        h.pYm.e(10987, Integer.valueOf(4), "", "", "");
        String a = c.a(tVInfoUI.mController.ylL, tVInfoUI.qwD);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", a);
        intent.putExtra("Retr_Msg_Type", 2);
        if (tVInfoUI.qwE != null && tVInfoUI.qdh) {
            intent.putExtra("Retr_Msg_thumb_path", tVInfoUI.qwE.anJ());
        }
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        com.tencent.mm.plugin.shake.a.gkE.k(intent, tVInfoUI);
        AppMethodBeat.o(24932);
    }

    static /* synthetic */ void c(TVInfoUI tVInfoUI) {
        AppMethodBeat.i(24933);
        if (tVInfoUI.qwD == null) {
            ab.w("MicroMsg.TVInfoUI", "shareToTimeLine, but tv is null");
            AppMethodBeat.o(24933);
            return;
        }
        h.pYm.e(10987, Integer.valueOf(3), "", "", "");
        Intent intent = new Intent();
        if (bo.isNullOrNil(tVInfoUI.qwD.field_topic)) {
            intent.putExtra("KContentObjDesc", tVInfoUI.qwD.field_subtitle);
        } else {
            intent.putExtra("KContentObjDesc", tVInfoUI.qwD.field_topic);
        }
        intent.putExtra("Ksnsupload_title", tVInfoUI.qwD.field_title);
        intent.putExtra("Ksnsupload_link", tVInfoUI.qwD.field_shareurl);
        intent.putExtra("Ksnsupload_appname", tVInfoUI.getString(R.string.dz2));
        if (k.cjQ()) {
            intent.putExtra("Ksnsupload_appid", "wxaf060266bfa9a35c");
        }
        intent.putExtra("Ksnsupload_imgurl", tVInfoUI.qwD.field_thumburl);
        if (tVInfoUI.qwE != null && tVInfoUI.qdh) {
            intent.putExtra("KsnsUpload_imgPath", tVInfoUI.qwE.anJ());
        }
        intent.putExtra("Ksnsupload_type", 5);
        intent.putExtra("KUploadProduct_UserData", c.b(tVInfoUI.qwD));
        String nW = v.nW("shake_tv");
        v.Zp().y(nW, true).j("prePublishId", "shake_tv");
        intent.putExtra("reportSessionId", nW);
        d.b((Context) tVInfoUI, "sns", ".ui.SnsUploadUI", intent);
        AppMethodBeat.o(24933);
    }

    static /* synthetic */ void d(TVInfoUI tVInfoUI) {
        AppMethodBeat.i(24934);
        if (tVInfoUI.qwD == null) {
            ab.w("MicroMsg.TVInfoUI", "do favorite, but tv is null");
            AppMethodBeat.o(24934);
            return;
        }
        h.pYm.e(10987, Integer.valueOf(5), "", "", "");
        cl clVar = new cl();
        abf abf = new abf();
        abl abl = new abl();
        abo abo = new abo();
        abl.alD(r.Yz());
        abl.alE(r.Yz());
        abl.LN(8);
        abl.ml(bo.anU());
        if (k.cjQ()) {
            abl.alJ("wxaf060266bfa9a35c");
        }
        abo.alM(tVInfoUI.qwD.field_title);
        if (bo.isNullOrNil(tVInfoUI.qwD.field_topic)) {
            abo.alN(tVInfoUI.qwD.field_subtitle);
        } else {
            abo.alN(tVInfoUI.qwD.field_topic);
        }
        abo.alP(c.b(tVInfoUI.qwD));
        abo.alO(tVInfoUI.qwD.field_thumburl);
        clVar.cvA.title = tVInfoUI.qwD.field_title;
        clVar.cvA.desc = tVInfoUI.qwD.field_topic;
        clVar.cvA.cvC = abf;
        clVar.cvA.type = 15;
        abf.a(abl);
        abf.b(abo);
        clVar.cvA.cvH = 12;
        clVar.cvA.activity = tVInfoUI;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        AppMethodBeat.o(24934);
    }
}
