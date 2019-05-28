package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.emoji.view.BaseEmojiView;
import com.tencent.mm.g.a.da;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.model.i.a;
import com.tencent.mm.plugin.emoji.model.i.b;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.emoji.ui.widget.ScaleRelativeLayout;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.protocal.protobuf.aic;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI extends MMActivity implements OnItemClickListener, f, a, b {
    private final String TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    private String cwg;
    private String ejD;
    private EmojiInfo exP;
    com.tencent.mm.plugin.emoji.a.f kYB;
    private View kYC;
    private ImageView kYD;
    private TextView kYE;
    private TextView kYF;
    private aic kYG;
    private EmotionDetail kYH = new EmotionDetail();
    private String kYI;
    private ScaleRelativeLayout kYJ;
    private TextView kYK;
    private BaseEmojiView kYL;
    private i kYM;
    private aii kYN;
    private long kYO;
    String kYP;
    private String kYQ;
    private boolean kYR = false;
    private Runnable kYS = new Runnable() {
        public final void run() {
            AppMethodBeat.i(53220);
            if (CustomSmileyPreviewUI.this.kYK != null) {
                CustomSmileyPreviewUI.this.kYK.setText(((d) g.M(d.class)).getEmojiMgr().Jh(CustomSmileyPreviewUI.this.exP.Aq()));
            }
            AppMethodBeat.o(53220);
        }
    };
    private Runnable kYT = new Runnable() {
        public final void run() {
            AppMethodBeat.i(53229);
            CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.cwg, CustomSmileyPreviewUI.this.exP);
            AppMethodBeat.o(53229);
        }
    };
    private c kYU = new c<pe>() {
        {
            AppMethodBeat.i(53233);
            this.xxI = pe.class.getName().hashCode();
            AppMethodBeat.o(53233);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(53234);
            pe peVar = (pe) bVar;
            if (CustomSmileyPreviewUI.this.kYO != 0 && peVar.cLt.cLw == CustomSmileyPreviewUI.this.kYO) {
                ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "msg is revoked.");
                h.a(CustomSmileyPreviewUI.this.mController.ylL, peVar.cLt.cLu, "", CustomSmileyPreviewUI.this.getString(R.string.s6), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(53232);
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        CustomSmileyPreviewUI.this.finish();
                        AppMethodBeat.o(53232);
                    }
                });
            }
            AppMethodBeat.o(53234);
            return false;
        }
    };
    private c kYt = new c<da>() {
        {
            AppMethodBeat.i(53230);
            this.xxI = da.class.getName().hashCode();
            AppMethodBeat.o(53230);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(53231);
            da daVar = (da) bVar;
            if (!(daVar == null || bo.isNullOrNil(CustomSmileyPreviewUI.this.cwg) || !CustomSmileyPreviewUI.this.cwg.equals(daVar.cwf.cwg))) {
                CustomSmileyPreviewUI customSmileyPreviewUI = CustomSmileyPreviewUI.this;
                String str = daVar.cwf.cwg;
                int i = daVar.cwf.status;
                int i2 = daVar.cwf.progress;
                ab.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), daVar.cwf.cwh);
                if (i == 6) {
                    al.d(new AnonymousClass6(str, i2));
                } else {
                    ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "product status:%d", Integer.valueOf(i));
                    al.d(new AnonymousClass7(str, i));
                }
                if (customSmileyPreviewUI.kYB != null) {
                    com.tencent.mm.plugin.emoji.a.a.c cVar = customSmileyPreviewUI.kYB.kSP;
                    if (cVar != null) {
                        com.tencent.mm.plugin.emoji.a.a.f IT = cVar.IT(str);
                        if (IT != null) {
                            IT.kTe = r4;
                        }
                    }
                }
            }
            AppMethodBeat.o(53231);
            return false;
        }
    };
    private com.tencent.mm.plugin.emoji.f.g kYu;
    private ListView mListView;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ int gOm;
        final /* synthetic */ String kUJ;

        AnonymousClass6(String str, int i) {
            this.kUJ = str;
            this.gOm = i;
        }

        public final void run() {
            AppMethodBeat.i(138343);
            if (bo.isNullOrNil(this.kUJ)) {
                ab.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                AppMethodBeat.o(138343);
                return;
            }
            if (!(CustomSmileyPreviewUI.this.kYB == null || CustomSmileyPreviewUI.this.kYB.kSP == null)) {
                CustomSmileyPreviewUI.this.kYB.bX(this.kUJ, this.gOm);
                CustomSmileyPreviewUI.this.kYB.refreshView();
            }
            AppMethodBeat.o(138343);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ int fTG;
        final /* synthetic */ String kUJ;

        AnonymousClass7(String str, int i) {
            this.kUJ = str;
            this.fTG = i;
        }

        public final void run() {
            AppMethodBeat.i(53227);
            if (bo.isNullOrNil(this.kUJ)) {
                ab.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                AppMethodBeat.o(53227);
                return;
            }
            if (!(CustomSmileyPreviewUI.this.kYB == null || CustomSmileyPreviewUI.this.kYB.kSP == null)) {
                CustomSmileyPreviewUI.this.kYB.bW(this.kUJ, this.fTG);
            }
            AppMethodBeat.o(53227);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CustomSmileyPreviewUI() {
        AppMethodBeat.i(53240);
        AppMethodBeat.o(53240);
    }

    public final int getLayoutId() {
        return R.layout.ro;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53241);
        super.onCreate(bundle);
        g.RO().eJo.a(412, (f) this);
        g.RO().eJo.a((int) com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX, (f) this);
        g.RO().eJo.a(411, (f) this);
        g.RO().eJo.a((int) com.tencent.view.d.MIC_PTU_SHISHANG2, (f) this);
        g.RO().eJo.a(368, (f) this);
        com.tencent.mm.sdk.b.a.xxA.c(this.kYt);
        com.tencent.mm.sdk.b.a.xxA.c(this.kYU);
        initView();
        String str = "";
        if (!(this.kYG == null || this.kYG.woq == null)) {
            str = p.getString(this.kYG.woq.DesignerUin);
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(12740, Integer.valueOf(4), str, this.exP.field_groupId, "", Integer.valueOf(9), Integer.valueOf(9));
        AppMethodBeat.o(53241);
    }

    public void onResume() {
        AppMethodBeat.i(53242);
        super.onResume();
        AppMethodBeat.o(53242);
    }

    public void onStart() {
        AppMethodBeat.i(53243);
        super.onStart();
        AppMethodBeat.o(53243);
    }

    public void onPause() {
        AppMethodBeat.i(53244);
        super.onPause();
        AppMethodBeat.o(53244);
    }

    public void onDestroy() {
        AppMethodBeat.i(53245);
        g.RO().eJo.b(412, (f) this);
        g.RO().eJo.b((int) com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX, (f) this);
        g.RO().eJo.b(411, (f) this);
        g.RO().eJo.b((int) com.tencent.view.d.MIC_PTU_SHISHANG2, (f) this);
        g.RO().eJo.b(368, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.kYt);
        com.tencent.mm.sdk.b.a.xxA.d(this.kYU);
        super.onDestroy();
        al.af(this.kYS);
        al.af(this.kYT);
        AppMethodBeat.o(53245);
    }

    public final void initView() {
        boolean z;
        AppMethodBeat.i(53246);
        setMMTitle("");
        String stringExtra = getIntent().getStringExtra("custom_smiley_preview_md5");
        this.kYO = getIntent().getLongExtra("msg_id", 0);
        this.kYP = getIntent().getStringExtra("msg_sender");
        this.kYQ = getIntent().getStringExtra("msg_content");
        this.ejD = getIntent().getStringExtra("room_id");
        ab.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", stringExtra);
        String nullAsNil = bo.nullAsNil(stringExtra);
        if (TextUtils.isEmpty(nullAsNil)) {
            ab.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
            finish();
        }
        this.kYJ = (ScaleRelativeLayout) findViewById(R.id.b7e);
        this.kYK = (TextView) findViewById(R.id.b7h);
        this.kYL = (BaseEmojiView) findViewById(R.id.xr);
        View findViewById = findViewById(R.id.b7f);
        ((ImageView) findViewById(R.id.b7g)).setImageDrawable(ah.f(this, R.raw.emoticonstore_capture_icon, -1));
        if (com.tencent.mm.sdk.a.b.dnO() || com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
            this.kYL.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(53235);
                    Toast.makeText(CustomSmileyPreviewUI.this.mController.ylL, "isHevc:" + CustomSmileyPreviewUI.this.kYL.eAi, 0).show();
                    AppMethodBeat.o(53235);
                }
            });
        }
        this.exP = j.getEmojiStorageMgr().xYn.aqi(nullAsNil);
        if (this.exP == null) {
            finish();
        }
        if (this.exP.duP()) {
            this.kYL.setEmojiInfo(this.exP);
        } else {
            com.tencent.mm.emoji.loader.a aVar = com.tencent.mm.emoji.loader.a.exs;
            com.tencent.mm.emoji.loader.a.a(this.exP, this.kYL, null);
        }
        if (com.tencent.mm.plugin.emoji.h.b.y(this.exP)) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(53236);
                ScaleRelativeLayout f = CustomSmileyPreviewUI.this.kYJ;
                f.aJf = Math.min(Math.min(((float) f.getMeasuredWidth()) / ((float) CustomSmileyPreviewUI.this.kYL.getMeasuredWidth()), ((float) f.getMeasuredHeight()) / ((float) CustomSmileyPreviewUI.this.kYL.getMeasuredHeight())), 3.0f);
                f.lgE = f.aJf * 1.5f;
                AppMethodBeat.o(53236);
            }
        });
        stringExtra = ((d) g.M(d.class)).getEmojiMgr().Jh(this.exP.Aq());
        if (!(this.kYK == null || bo.isNullOrNil(stringExtra))) {
            this.kYK.setText(stringExtra);
            this.kYL.setContentDescription(stringExtra);
        }
        String stringExtra2 = getIntent().getStringExtra("custom_smiley_preview_appid");
        String stringExtra3 = getIntent().getStringExtra("custom_smiley_preview_appname");
        TextView textView = (TextView) findViewById(R.id.xu);
        com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(stringExtra2, true);
        if (!(bT == null || bT.field_appName == null || bT.field_appName.trim().length() <= 0)) {
            stringExtra3 = bT.field_appName;
        }
        if (stringExtra2 == null || stringExtra2.length() <= 0 || !dg(stringExtra3)) {
            textView.setVisibility(8);
            this.cwg = this.exP.field_groupId;
            g.RO().eJo.a(new k(this.cwg), 0);
            this.mListView = (ListView) findViewById(16908298);
            this.kYB = new com.tencent.mm.plugin.emoji.a.f(this.mController.ylL);
            this.kYB.kSQ = this;
            this.kYB.kSk = true;
            this.kYB.kSn = false;
            this.mListView.setOnItemClickListener(this);
            this.mListView.setAdapter(this.kYB);
            this.kYB.kSO = this.mListView;
            if (!bo.isNullOrNil(this.cwg)) {
                blj();
            }
            this.kYM = new i();
            this.kYM.jiq = this;
            this.kYM.kVA = this.kYB;
            this.kYM.kVD = 9;
            this.kYM.kVG = this;
            this.kYR = j.getEmojiStorageMgr().xYp.aqg(this.cwg);
            a(this.cwg, this.exP);
        } else {
            textView.setText(getString(R.string.ba6, new Object[]{com.tencent.mm.pluginsdk.model.app.g.b(this.mController.ylL, bT, stringExtra3)}));
            textView.setVisibility(0);
            a(this, (View) textView, stringExtra2);
            a(this, textView, stringExtra2);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(138344);
                CustomSmileyPreviewUI.this.finish();
                AppMethodBeat.o(138344);
                return true;
            }
        });
        if (this.exP.field_catalog == EmojiInfo.yaB || this.exP.duS()) {
            z = false;
        } else {
            z = true;
        }
        if (this.exP.field_catalog == EmojiInfo.yaB || bo.isNullOrNil(this.exP.field_groupId) || (!bo.isNullOrNil(this.exP.field_groupId) && ((d) g.M(d.class)).getEmojiMgr().Ji(this.exP.field_groupId))) {
            z = true;
        }
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53238);
                CustomSmileyPreviewUI.g(CustomSmileyPreviewUI.this);
                AppMethodBeat.o(53238);
                return true;
            }
        });
        showOptionMenu(z);
        blg();
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = this.cwg;
        objArr[2] = nullAsNil;
        objArr[3] = this.exP == null ? "" : this.exP.field_designerID;
        objArr[4] = this.exP == null ? "" : this.exP.field_activityid;
        hVar.e(12067, objArr);
        AppMethodBeat.o(53246);
    }

    private void blg() {
        AppMethodBeat.i(53247);
        this.kYC = findViewById(R.id.bfw);
        this.kYD = (ImageView) this.kYC.findViewById(R.id.bfx);
        this.kYE = (TextView) this.kYC.findViewById(R.id.bfy);
        this.kYF = (TextView) this.kYC.findViewById(R.id.bfz);
        this.kYC.setVisibility(8);
        if (!(this.exP == null || bo.isNullOrNil(this.exP.field_designerID))) {
            JK(this.exP.field_designerID);
            JJ(this.exP.field_designerID);
        }
        if (!(this.exP == null || bo.isNullOrNil(this.exP.field_activityid))) {
            JL(this.exP.field_activityid);
            dM(this.exP.field_activityid, this.exP.field_md5);
        }
        blh();
        this.kYC.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(138345);
                if (CustomSmileyPreviewUI.this.kYG == null || CustomSmileyPreviewUI.this.kYG.woq == null) {
                    ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
                    AppMethodBeat.o(138345);
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(CustomSmileyPreviewUI.this.mController.ylL, EmojiStoreV2DesignerUI.class);
                intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, CustomSmileyPreviewUI.this.kYG.woq.DesignerUin);
                intent.putExtra("name", CustomSmileyPreviewUI.this.kYG.woq.Name);
                intent.putExtra("headurl", CustomSmileyPreviewUI.this.kYG.woq.HeadUrl);
                intent.putExtra("extra_scence", 9);
                CustomSmileyPreviewUI.this.mController.ylL.startActivity(intent);
                AppMethodBeat.o(138345);
            }
        });
        AppMethodBeat.o(53247);
    }

    private static void JJ(String str) {
        AppMethodBeat.i(53248);
        g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.i(str), 0);
        AppMethodBeat.o(53248);
    }

    private void JK(String str) {
        AppMethodBeat.i(53249);
        this.kYG = j.getEmojiStorageMgr().xYt.aqn(str);
        AppMethodBeat.o(53249);
    }

    private void JL(String str) {
        AppMethodBeat.i(53250);
        this.kYN = j.getEmojiStorageMgr().xYq.aqt(str);
        AppMethodBeat.o(53250);
    }

    private void dM(String str, String str2) {
        AppMethodBeat.i(53251);
        if (this.kYN == null || !(this.kYN == null || this.kYN.wou == null || ((long) this.kYN.wou.wdZ) >= System.currentTimeMillis() / 1000)) {
            g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.j(str, str2), 0);
            AppMethodBeat.o(53251);
            return;
        }
        ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
        AppMethodBeat.o(53251);
    }

    private void blh() {
        AppMethodBeat.i(53252);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(138339);
                if (CustomSmileyPreviewUI.this.kYN != null && CustomSmileyPreviewUI.this.kYN.wou != null) {
                    CustomSmileyPreviewUI.this.kYC.setVisibility(0);
                    CustomSmileyPreviewUI.this.kYE.setText(CustomSmileyPreviewUI.this.kYN.wou.Name);
                    if (bo.isNullOrNil(CustomSmileyPreviewUI.this.kYN.wou.IconUrl)) {
                        CustomSmileyPreviewUI.this.kYD.setVisibility(8);
                    } else {
                        CustomSmileyPreviewUI.this.kYD.setVisibility(0);
                        o.ahp().a(CustomSmileyPreviewUI.this.kYN.wou.IconUrl, CustomSmileyPreviewUI.this.kYD, com.tencent.mm.plugin.emoji.e.g.dJ(CustomSmileyPreviewUI.this.exP.field_groupId, CustomSmileyPreviewUI.this.kYN.wou.IconUrl));
                    }
                    CustomSmileyPreviewUI.this.kYF.setText(R.string.b90);
                    CustomSmileyPreviewUI.this.kYC.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(138338);
                            CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.kYN.wou.wdY);
                            AppMethodBeat.o(138338);
                        }
                    });
                    CustomSmileyPreviewUI.this.mListView.setVisibility(8);
                    AppMethodBeat.o(138339);
                } else if (CustomSmileyPreviewUI.this.kYG == null || CustomSmileyPreviewUI.this.kYG.woq == null) {
                    CustomSmileyPreviewUI.this.kYC.setVisibility(8);
                    AppMethodBeat.o(138339);
                } else {
                    CustomSmileyPreviewUI.this.kYC.setVisibility(0);
                    CustomSmileyPreviewUI.this.kYE.setText(CustomSmileyPreviewUI.this.kYG.woq.Name);
                    o.ahp().a(CustomSmileyPreviewUI.this.kYG.woq.HeadUrl, CustomSmileyPreviewUI.this.kYD, com.tencent.mm.plugin.emoji.e.g.dI(CustomSmileyPreviewUI.this.exP.field_groupId, CustomSmileyPreviewUI.this.kYG.woq.HeadUrl));
                    CustomSmileyPreviewUI.this.mListView.setVisibility(8);
                    AppMethodBeat.o(138339);
                }
            }
        });
        AppMethodBeat.o(53252);
    }

    private static boolean dg(String str) {
        AppMethodBeat.i(53253);
        if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
            AppMethodBeat.o(53253);
            return false;
        }
        AppMethodBeat.o(53253);
        return true;
    }

    private void a(CustomSmileyPreviewUI customSmileyPreviewUI, View view, String str) {
        AppMethodBeat.i(53254);
        final String f = com.tencent.mm.pluginsdk.model.app.p.f(customSmileyPreviewUI, str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(138342);
                if (bo.isNullOrNil(f)) {
                    AppMethodBeat.o(138342);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("rawUrl", f);
                com.tencent.mm.bp.d.b(CustomSmileyPreviewUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(138342);
            }
        });
        AppMethodBeat.o(53254);
    }

    private static void a(CustomSmileyPreviewUI customSmileyPreviewUI, TextView textView, String str) {
        AppMethodBeat.i(53255);
        Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str, 2, com.tencent.mm.bz.a.getDensity(customSmileyPreviewUI));
        if (b == null || b.isRecycled()) {
            a(customSmileyPreviewUI, textView, BitmapFactory.decodeResource(customSmileyPreviewUI.getResources(), R.drawable.akc));
            AppMethodBeat.o(53255);
            return;
        }
        a(customSmileyPreviewUI, textView, b);
        AppMethodBeat.o(53255);
    }

    private static void a(CustomSmileyPreviewUI customSmileyPreviewUI, TextView textView, Bitmap bitmap) {
        AppMethodBeat.i(53256);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) customSmileyPreviewUI.getResources().getDimension(R.dimen.kr);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
        AppMethodBeat.o(53256);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53257);
        switch (mVar.getType()) {
            case com.tencent.view.d.MIC_PTU_SHISHANG2 /*239*/:
                this.kYG = ((com.tencent.mm.plugin.emoji.f.i) mVar).bkx();
                blh();
                AppMethodBeat.o(53257);
                return;
            case 368:
                if (i2 != 0) {
                    ab.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
                    break;
                }
                com.tencent.mm.plugin.emoji.f.j jVar = (com.tencent.mm.plugin.emoji.f.j) mVar;
                aii aii = (aii) jVar.ehh.fsH.fsP;
                if (!(aii == null || aii.wou == null)) {
                    aii.wou.wdZ = ((int) (System.currentTimeMillis() / 1000)) + aii.wou.wdZ;
                    ((d) g.M(d.class)).getEmojiStorageMgr().xYq.a(jVar.kWN, aii);
                }
                this.kYN = aii;
                blh();
                AppMethodBeat.o(53257);
                return;
            case 411:
                if (mVar instanceof n) {
                    j.getEmojiStorageMgr().xYq.a(12, ((n) mVar).bkB());
                    AppMethodBeat.o(53257);
                    return;
                }
                break;
            case 412:
                if (mVar instanceof l) {
                    l lVar = (l) mVar;
                    String str2;
                    String str3;
                    Object[] objArr;
                    com.tencent.mm.plugin.emoji.a.a.c bli;
                    if (i == 0) {
                        if (i2 == 0) {
                            this.kYH = lVar.bkz();
                            if (this.kYH == null || TextUtils.isEmpty(this.cwg) || !this.cwg.equals(this.kYH.ProductID)) {
                                str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                                str3 = "[onSceneEnd no same product id] cureent:%s,scene:%s";
                                objArr = new Object[2];
                                objArr[0] = this.cwg;
                                objArr[1] = this.kYH == null ? "" : this.kYH.ProductID;
                                ab.i(str2, str3, objArr);
                                AppMethodBeat.o(53257);
                                return;
                            }
                            bli = bli();
                            if (this.kYB != null) {
                                this.kYB.a(bli);
                            }
                            ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.kYH.ProductID);
                            AppMethodBeat.o(53257);
                            return;
                        } else if (i2 == 1) {
                            AppMethodBeat.o(53257);
                            return;
                        }
                    } else if (i2 == 5) {
                        if (this.kYH == null || lVar.bkz() == null || TextUtils.isEmpty(this.cwg) || !this.cwg.equals(this.kYH.ProductID) || this.kYH.PackFlag == lVar.bkz().PackFlag) {
                            str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                            str3 = "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s";
                            objArr = new Object[2];
                            objArr[0] = this.cwg;
                            objArr[1] = this.kYH == null ? "" : this.kYH.ProductID;
                            ab.i(str2, str3, objArr);
                            AppMethodBeat.o(53257);
                            return;
                        }
                        this.kYH.PackFlag = lVar.bkz().PackFlag;
                        bli = bli();
                        if (this.kYB != null) {
                            this.kYB.a(bli);
                        }
                        ab.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.kYH.ProductID);
                        AppMethodBeat.o(53257);
                        return;
                    }
                }
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.j.c.CTRL_INDEX /*521*/:
                if (i2 == 0) {
                    al.d(this.kYT);
                    al.n(this.kYS, 500);
                    AppMethodBeat.o(53257);
                    return;
                }
                break;
        }
        AppMethodBeat.o(53257);
    }

    private com.tencent.mm.plugin.emoji.a.a.c bli() {
        AppMethodBeat.i(53258);
        List arrayList = new ArrayList();
        EmotionSummary emotionSummary = new EmotionSummary();
        emotionSummary.CoverUrl = this.kYH.CoverUrl;
        emotionSummary.IconUrl = this.kYH.IconUrl;
        emotionSummary.PackName = this.kYH.PackName;
        emotionSummary.PackFlag = this.kYH.PackFlag;
        emotionSummary.PackDesc = this.kYH.PackDesc;
        emotionSummary.PackExpire = this.kYH.PackExpire;
        emotionSummary.PackType = this.kYH.PackType;
        emotionSummary.PackPrice = this.kYH.PackPrice;
        emotionSummary.PriceNum = this.kYH.PriceNum;
        emotionSummary.PriceType = this.kYH.PriceType;
        emotionSummary.ProductID = this.kYH.ProductID;
        arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(emotionSummary));
        com.tencent.mm.plugin.emoji.a.a.c cVar = new com.tencent.mm.plugin.emoji.a.a.c(arrayList);
        AppMethodBeat.o(53258);
        return cVar;
    }

    private void a(String str, EmojiInfo emojiInfo) {
        AppMethodBeat.i(53259);
        if (bo.isNullOrNil(str) || emojiInfo == null) {
            AppMethodBeat.o(53259);
            return;
        }
        if (!bo.isNullOrNil(str) && emojiInfo.field_catalog != EmojiGroupInfo.yas && emojiInfo.field_catalog != EmojiGroupInfo.yar && ((emojiInfo.field_type != EmojiInfo.zYX || emojiInfo.field_type != EmojiInfo.zYY) && j.getEmojiStorageMgr().xYp.aqf(str))) {
            if (this.mListView != null) {
                this.mListView.setVisibility(0);
            }
            if (this.kYB != null) {
                this.kYB.kSl = this.kYR;
                this.kYB.notifyDataSetChanged();
                AppMethodBeat.o(53259);
                return;
            }
        } else if (this.mListView != null) {
            this.mListView.setVisibility(8);
        }
        AppMethodBeat.o(53259);
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        AppMethodBeat.i(53260);
        String str = "MicroMsg.emoji.CustomSmileyPreviewUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.getProductId();
        objArr[1] = TextUtils.isEmpty(aVar.bjo()) ? "" : aVar.bjo();
        objArr[2] = Integer.valueOf(aVar.bjn());
        ab.i(str, str2, objArr);
        this.kYM.a(aVar);
        AppMethodBeat.o(53260);
    }

    public final void bkf() {
    }

    private void blj() {
        AppMethodBeat.i(53262);
        com.tencent.mm.storage.emotion.i aqp = j.getEmojiStorageMgr().xYr.aqp(this.cwg);
        if (!(aqp == null || aqp.field_content == null)) {
            GetEmotionDetailResponse getEmotionDetailResponse = new GetEmotionDetailResponse();
            try {
                getEmotionDetailResponse.parseFrom(aqp.field_content);
                this.kYH = getEmotionDetailResponse.EmotionDetail;
                this.kYI = aqp.field_lan;
            } catch (IOException e) {
                ab.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", bo.l(e));
            }
        }
        if (this.kYH == null || bo.isNullOrNil(this.kYI) || !this.kYI.equalsIgnoreCase(aa.gw(this.mController.ylL))) {
            g.RO().eJo.a(new l(this.cwg, 1), 0);
            AppMethodBeat.o(53262);
            return;
        }
        com.tencent.mm.plugin.emoji.a.a.c bli = bli();
        if (this.kYB != null) {
            this.kYB.a(bli);
        }
        g.RO().eJo.a(new l(this.cwg, 1, this.kYH.Version), 0);
        AppMethodBeat.o(53262);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(53263);
        if (this.kYB == null || i < 0 || i >= this.kYB.getCount()) {
            AppMethodBeat.o(53263);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.e(12789, Integer.valueOf(4), this.exP.Aq(), Integer.valueOf(1), this.exP.field_designerID, this.exP.field_groupId, "", "", "", "", this.exP.field_activityid);
        com.tencent.mm.plugin.emoji.a.a.f tX = this.kYB.getItem(i);
        Intent intent = new Intent();
        intent.setClass(this, EmojiStoreDetailUI.class);
        EmotionSummary emotionSummary = tX.kTb;
        if (emotionSummary == null) {
            intent = null;
        } else {
            intent.putExtra("extra_id", emotionSummary.ProductID);
            intent.putExtra("extra_name", emotionSummary.PackName);
            intent.putExtra("extra_copyright", emotionSummary.PackCopyright);
            intent.putExtra("extra_coverurl", emotionSummary.CoverUrl);
            intent.putExtra("extra_description", emotionSummary.PackDesc);
            intent.putExtra("extra_price", emotionSummary.PackPrice);
            intent.putExtra("extra_type", emotionSummary.PackType);
            intent.putExtra("extra_flag", emotionSummary.PackFlag);
            intent.putExtra("preceding_scence", 4);
            intent.putExtra("call_by", 1);
            intent.putExtra("download_entrance_scene", 9);
            intent.putExtra("check_clickflag", true);
            intent.putExtra("extra_status", tX.mStatus);
            intent.putExtra("extra_progress", tX.EV);
            String stringExtra = getIntent().getStringExtra("to_talker_name");
            if (!bo.isNullOrNil(stringExtra)) {
                intent.putExtra("to_talker_name", stringExtra);
            }
        }
        startActivity(intent);
        AppMethodBeat.o(53263);
    }

    public final void i(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(53261);
        this.kYu = new com.tencent.mm.plugin.emoji.f.g(str, str2, str3);
        g.RO().eJo.a(this.kYu, 0);
        AppMethodBeat.o(53261);
    }

    static /* synthetic */ void g(CustomSmileyPreviewUI customSmileyPreviewUI) {
        AppMethodBeat.i(138346);
        EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(customSmileyPreviewUI.exP.Aq());
        if (aqi != null) {
            customSmileyPreviewUI.exP = aqi;
        }
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(customSmileyPreviewUI, 1, false);
        dVar.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                AppMethodBeat.i(138340);
                if (!(CustomSmileyPreviewUI.this.exP.field_catalog == EmojiInfo.yaB || CustomSmileyPreviewUI.this.exP.duS())) {
                    lVar.hi(0, R.string.d3);
                }
                if (CustomSmileyPreviewUI.this.exP.field_catalog == EmojiInfo.yaB || bo.isNullOrNil(CustomSmileyPreviewUI.this.exP.field_groupId) || (!bo.isNullOrNil(CustomSmileyPreviewUI.this.exP.field_groupId) && ((d) g.M(d.class)).getEmojiMgr().Ji(CustomSmileyPreviewUI.this.exP.field_groupId))) {
                    lVar.hi(1, R.string.dr8);
                }
                com.tencent.mm.pluginsdk.a.d emojiMgr = ((d) g.M(d.class)).getEmojiMgr();
                CustomSmileyPreviewUI.this.exP;
                if (emojiMgr.bjR()) {
                    lVar.hi(2, R.string.b_p);
                }
                lVar.hi(3, R.string.b_6);
                AppMethodBeat.o(138340);
            }
        };
        dVar.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(138341);
                switch (menuItem.getItemId()) {
                    case 0:
                        CustomSmileyPreviewUI customSmileyPreviewUI = CustomSmileyPreviewUI.this;
                        EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5"));
                        if (aqi == null) {
                            ab.w("MicroMsg.emoji.CustomSmileyPreviewUI", "[cpan] save custom emoji failed. emoji is null.");
                            AppMethodBeat.o(138341);
                            return;
                        }
                        if (aqi.field_catalog != EmojiInfo.yax) {
                            if (aqi.field_catalog == EmojiInfo.yaB) {
                                h.bQ(customSmileyPreviewUI, customSmileyPreviewUI.getString(R.string.fv));
                                AppMethodBeat.o(138341);
                                return;
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.e(12789, Integer.valueOf(3), aqi.Aq(), Integer.valueOf(1), aqi.field_designerID, aqi.field_groupId, "", "", "", "", "", aqi.field_activityid);
                            j.bki().a(customSmileyPreviewUI.mController.ylL, aqi, 4, customSmileyPreviewUI.kYP);
                        }
                        AppMethodBeat.o(138341);
                        return;
                    case 1:
                        CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this);
                        AppMethodBeat.o(138341);
                        return;
                    case 2:
                        CustomSmileyPreviewUI.this.setResult(-1);
                        com.tencent.mm.plugin.emojicapture.api.c.an(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.exP.Aq());
                        break;
                    case 3:
                        CustomSmileyPreviewUI.p(CustomSmileyPreviewUI.this);
                        AppMethodBeat.o(138341);
                        return;
                }
                AppMethodBeat.o(138341);
            }
        };
        dVar.cpD();
        AppMethodBeat.o(138346);
    }

    static /* synthetic */ void o(CustomSmileyPreviewUI customSmileyPreviewUI) {
        AppMethodBeat.i(138348);
        String stringExtra = customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5");
        int intExtra = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Compress_Type", intExtra);
        com.tencent.mm.plugin.emoji.b.gkE.k(intent, customSmileyPreviewUI);
        com.tencent.mm.plugin.report.service.h.pYm.e(12789, Integer.valueOf(1), customSmileyPreviewUI.exP.Aq(), Integer.valueOf(1), customSmileyPreviewUI.exP.field_designerID, customSmileyPreviewUI.exP.field_groupId, customSmileyPreviewUI.kYP, "", "", "", customSmileyPreviewUI.exP.field_activityid);
        AppMethodBeat.o(138348);
    }

    static /* synthetic */ void p(CustomSmileyPreviewUI customSmileyPreviewUI) {
        AppMethodBeat.i(138349);
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(customSmileyPreviewUI.kYQ);
        intent.putStringArrayListExtra("k_outside_expose_proof_item_list", arrayList);
        if (bo.isNullOrNil(customSmileyPreviewUI.ejD)) {
            intent.putExtra("k_username", customSmileyPreviewUI.kYP);
        } else {
            intent.putExtra("k_username", customSmileyPreviewUI.ejD);
        }
        intent.putExtra("k_expose_msg_id", customSmileyPreviewUI.kYO);
        intent.putExtra("k_expose_msg_type", 47);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(51)}));
        com.tencent.mm.bp.d.b((Context) customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(138349);
    }
}
