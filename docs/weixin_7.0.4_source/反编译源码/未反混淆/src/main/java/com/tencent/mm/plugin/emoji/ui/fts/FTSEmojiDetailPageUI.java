package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.emoji.ui.EmojiSendDialogUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;

public class FTSEmojiDetailPageUI extends MMActivity implements f {
    private String cAo;
    private String cHg;
    private int cvp;
    private String cwg;
    private String designerName;
    private EmojiInfo exP;
    private int fjE;
    private j icA;
    private ProgressBar juA;
    private String kVF;
    private a kVx = new a() {
        public final void a(boolean z, EmojiInfo emojiInfo) {
            AppMethodBeat.i(53547);
            if (emojiInfo == null || !z || FTSEmojiDetailPageUI.this.exP == null || !FTSEmojiDetailPageUI.this.exP.Aq().equals(emojiInfo.Aq())) {
                ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
                AppMethodBeat.o(53547);
                return;
            }
            ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", FTSEmojiDetailPageUI.this.exP.Aq());
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(53546);
                    FTSEmojiDetailPageUI.e(FTSEmojiDetailPageUI.this);
                    AppMethodBeat.o(53546);
                }
            });
            AppMethodBeat.o(53547);
        }
    };
    private String lcA;
    private String lcB;
    private String lcC;
    private String lcD;
    private String lcE;
    private String lcF;
    private String lcG;
    private c lcH = new c<cx>() {
        {
            AppMethodBeat.i(53544);
            this.xxI = cx.class.getName().hashCode();
            AppMethodBeat.o(53544);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(53545);
            cx cxVar = (cx) bVar;
            if (FTSEmojiDetailPageUI.this.exP != null && cxVar.cvY.cvZ.equals(FTSEmojiDetailPageUI.this.exP.Aq())) {
                ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiDownloadListener callback %s", FTSEmojiDetailPageUI.this.exP.Aq());
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(53543);
                        FTSEmojiDetailPageUI.e(FTSEmojiDetailPageUI.this);
                        AppMethodBeat.o(53543);
                    }
                });
            }
            AppMethodBeat.o(53545);
            return false;
        }
    };
    private i lcI = new i() {
        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.i(53549);
            ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "imageLoaderListener onImageLoadComplete %s", str);
            if (bitmap != null && objArr != null && objArr.length > 0 && objArr[0] != null && (objArr[0] instanceof String) && str.equals(FTSEmojiDetailPageUI.this.exP.field_encrypturl)) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(objArr[0].toString());
                if (bVar.exists()) {
                    FTSEmojiDetailPageUI.this.exP.field_md5 = e.atg(com.tencent.mm.vfs.j.w(bVar.mUri));
                    FTSEmojiDetailPageUI.this.cHg = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", FTSEmojiDetailPageUI.this.exP.field_md5);
                    e.y(com.tencent.mm.vfs.j.w(bVar.dMD()), FTSEmojiDetailPageUI.this.cHg);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(53548);
                            FTSEmojiDetailPageUI.e(FTSEmojiDetailPageUI.this);
                            AppMethodBeat.o(53548);
                        }
                    });
                }
            }
            AppMethodBeat.o(53549);
        }
    };
    private d lcJ = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(53537);
            switch (menuItem.getItemId()) {
                case 1:
                    FTSEmojiDetailPageUI.i(FTSEmojiDetailPageUI.this);
                    break;
                case 2:
                    FTSEmojiDetailPageUI.h(FTSEmojiDetailPageUI.this);
                    AppMethodBeat.o(53537);
                    return;
            }
            AppMethodBeat.o(53537);
        }
    };
    private MMAnimateView lcs;
    private Button lct;
    private Button lcu;
    private TextView lcv;
    private ImageView lcw;
    private View lcx;
    private boolean lcy;
    private boolean lcz;
    private int scene;
    private int type;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSEmojiDetailPageUI() {
        AppMethodBeat.i(53551);
        AppMethodBeat.o(53551);
    }

    static /* synthetic */ void e(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(53564);
        fTSEmojiDetailPageUI.gs(false);
        AppMethodBeat.o(53564);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53552);
        super.onCreate(bundle);
        this.lct = (Button) findViewById(R.id.byh);
        this.lcu = (Button) findViewById(R.id.byg);
        this.lcs = (MMAnimateView) findViewById(R.id.byf);
        this.juA = (ProgressBar) findViewById(R.id.a1n);
        this.lcv = (TextView) findViewById(R.id.byi);
        this.lcw = (ImageView) findViewById(R.id.byj);
        this.lcx = findViewById(R.id.bi7);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53535);
                FTSEmojiDetailPageUI.this.finish();
                AppMethodBeat.o(53535);
                return false;
            }
        });
        this.lct.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(53539);
                FTSEmojiDetailPageUI.a(FTSEmojiDetailPageUI.this, FTSEmojiDetailPageUI.this.exP.Aq(), FTSEmojiDetailPageUI.this.exP.field_designerID, FTSEmojiDetailPageUI.this.exP.field_thumbUrl, FTSEmojiDetailPageUI.this.exP.field_activityid);
                AppMethodBeat.o(53539);
            }
        });
        this.lcu.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(53540);
                FTSEmojiDetailPageUI.b(FTSEmojiDetailPageUI.this);
                AppMethodBeat.o(53540);
            }
        });
        this.lcx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(53541);
                FTSEmojiDetailPageUI.c(FTSEmojiDetailPageUI.this);
                AppMethodBeat.o(53541);
            }
        });
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53542);
                FTSEmojiDetailPageUI.d(FTSEmojiDetailPageUI.this);
                AppMethodBeat.o(53542);
                return true;
            }
        });
        this.type = getIntent().getIntExtra("extra_type", 0);
        this.scene = getIntent().getIntExtra("extra_scence", 0);
        this.exP = new EmojiInfo();
        this.exP.field_designerID = getIntent().getStringExtra("id");
        this.exP.field_name = getIntent().getStringExtra("extra_emoji_name");
        this.exP.field_aeskey = getIntent().getStringExtra("extra_aeskey");
        this.exP.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
        this.exP.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
        this.exP.field_md5 = getIntent().getStringExtra("extra_md5");
        this.exP.field_groupId = getIntent().getStringExtra("extra_product_id");
        this.cwg = this.exP.field_groupId;
        this.lcC = getIntent().getStringExtra("extra_product_name");
        this.lcB = getIntent().getStringExtra("productUrl");
        this.lcD = getIntent().getStringExtra("extra_article_url");
        this.lcE = getIntent().getStringExtra("extra_article_name");
        this.cAo = this.exP.field_designerID;
        this.designerName = getIntent().getStringExtra("name");
        this.lcF = getIntent().getStringExtra("headurl");
        this.lcG = getIntent().getStringExtra("weapp_user_name");
        this.fjE = getIntent().getIntExtra("weapp_version", 0);
        this.cvp = getIntent().getIntExtra("source_type", 0);
        this.lcA = getIntent().getStringExtra("searchID");
        this.kVF = getIntent().getStringExtra("docID");
        this.lcy = getIntent().getBooleanExtra("disableAddSticker", false);
        this.lcz = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
        String stringExtra = getIntent().getStringExtra("activityId");
        if (!bo.isNullOrNil(stringExtra)) {
            this.exP.field_activityid = stringExtra;
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.lcH);
        com.tencent.mm.plugin.emoji.model.j.bkh().kVj = this.kVx;
        an.F(this.scene, this.lcA, this.kVF);
        gs(true);
        ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", this.cHg);
        an.F(this.scene, this.lcA, this.kVF);
        AppMethodBeat.o(53552);
    }

    public void onResume() {
        AppMethodBeat.i(53553);
        super.onResume();
        gs(false);
        AppMethodBeat.o(53553);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53554);
        if (i == 1001 && i2 == -1) {
            com.tencent.mm.ui.widget.snackbar.b.i(this, this.mController.ylL.getString(R.string.ti));
        }
        AppMethodBeat.o(53554);
    }

    private void gs(boolean z) {
        AppMethodBeat.i(53555);
        if (z) {
            setMMTitle(this.exP.getName());
        }
        switch (this.type) {
            case 2:
                o.ahp().a(this.lcB, this.lcw);
                this.lcv.setText(this.lcC);
                this.cHg = this.exP.dve();
                break;
            case 3:
                o.ahp().a(this.lcF, this.lcw);
                this.lcv.setText(this.designerName);
                this.cHg = this.exP.dve();
                break;
            case 4:
                this.lcw.setVisibility(8);
                if (!bo.isNullOrNil(this.lcE)) {
                    this.lcv.setText(this.lcE);
                    break;
                } else {
                    this.lcv.setText(R.string.e0g);
                    break;
                }
        }
        if (e.ct(this.cHg)) {
            this.juA.setVisibility(8);
            this.lcs.setVisibility(0);
            EmojiInfo aqi = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.aqi(this.exP.Aq());
            if (aqi == null || (aqi.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi) {
                ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
                this.lcs.setImageFilePath(this.cHg);
            } else {
                ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
                this.lcs.f(((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l(aqi), "");
            }
            blW();
            blV();
        } else if (z) {
            if (this.type == 4) {
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(getCacheDir(), com.tencent.mm.a.g.x(this.exP.field_encrypturl.getBytes()));
                if (bVar.exists()) {
                    this.exP.field_md5 = e.atg(com.tencent.mm.vfs.j.w(bVar.mUri));
                    String L = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", this.exP.field_md5);
                    if (!e.ct(L)) {
                        e.y(com.tencent.mm.vfs.j.w(bVar.dMD()), L);
                    }
                    this.cHg = L;
                    gs(false);
                } else {
                    com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
                    aVar.ePH = true;
                    aVar.ePJ = com.tencent.mm.vfs.j.w(bVar.dMD());
                    aVar.eQd = new Object[]{com.tencent.mm.vfs.j.w(bVar.dMD())};
                    com.tencent.mm.plugin.emoji.model.j.bjW().a(this.exP.field_encrypturl, null, aVar.ahG(), this.lcI);
                }
            } else {
                this.lcs.setVisibility(8);
                this.juA.setVisibility(0);
                this.lct.setText(R.string.ba8);
                this.lcu.setText(R.string.dr8);
                this.lct.setEnabled(false);
                this.lcu.setEnabled(false);
                com.tencent.mm.plugin.emoji.model.j.bkh().s(this.exP);
            }
        }
        if (this.lcy) {
            this.lct.setVisibility(8);
        }
        AppMethodBeat.o(53555);
    }

    private void blV() {
        AppMethodBeat.i(53556);
        this.lcu.setEnabled(true);
        AppMethodBeat.o(53556);
    }

    private void blW() {
        AppMethodBeat.i(53557);
        EmojiInfo aqi = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.aqi(this.exP.Aq());
        if (aqi == null) {
            aqi = this.exP;
        }
        if (aqi.field_catalog == EmojiGroupInfo.yat) {
            this.lct.setEnabled(false);
            this.lct.setText(R.string.fv);
            AppMethodBeat.o(53557);
            return;
        }
        this.lct.setText(R.string.ba8);
        if (e.ct(this.cHg)) {
            this.lct.setEnabled(true);
            AppMethodBeat.o(53557);
            return;
        }
        this.lct.setEnabled(false);
        AppMethodBeat.o(53557);
    }

    private boolean blX() {
        AppMethodBeat.i(53558);
        if (bo.isNullOrNil(this.lcG) || this.cvp != 1) {
            AppMethodBeat.o(53558);
            return false;
        }
        AppMethodBeat.o(53558);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.a1e;
    }

    public void onDestroy() {
        AppMethodBeat.i(53559);
        com.tencent.mm.sdk.b.a.xxA.d(this.lcH);
        com.tencent.mm.plugin.emoji.model.j.bkh().kVj = null;
        super.onDestroy();
        AppMethodBeat.o(53559);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
    }

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(53560);
        an.b(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.lcA, fTSEmojiDetailPageUI.kVF, 1, 0);
        EmojiInfo aqi = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.aqi(str);
        String L = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), "", str);
        if (aqi == null && e.ct(L)) {
            int i = r.amo(L) ? EmojiInfo.zYS : EmojiInfo.zYR;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.yau;
            emojiInfo.field_type = i;
            emojiInfo.field_size = (int) e.asZ(L);
            emojiInfo.field_temp = 1;
            emojiInfo.field_designerID = str2;
            emojiInfo.field_thumbUrl = str3;
            emojiInfo.field_activityid = str4;
            com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.E(emojiInfo);
            aqi = emojiInfo;
        }
        if (aqi != null) {
            boolean a = com.tencent.mm.plugin.emoji.model.j.bki().a(fTSEmojiDetailPageUI, aqi, 18, com.tencent.mm.model.r.Yz());
            ab.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "doAddAction %b", Boolean.valueOf(a));
        }
        AppMethodBeat.o(53560);
    }

    static /* synthetic */ void b(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(53561);
        an.b(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.lcA, fTSEmojiDetailPageUI.kVF, 2, 0);
        Intent intent = new Intent(fTSEmojiDetailPageUI, EmojiSendDialogUI.class);
        intent.putExtra("emoji_info", fTSEmojiDetailPageUI.exP);
        fTSEmojiDetailPageUI.startActivityForResult(intent, 1001);
        AppMethodBeat.o(53561);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        int i;
        AppMethodBeat.i(53562);
        int i2 = fTSEmojiDetailPageUI.scene;
        String str = fTSEmojiDetailPageUI.lcA;
        String str2 = fTSEmojiDetailPageUI.kVF;
        switch (fTSEmojiDetailPageUI.type) {
            case 2:
                if (!bo.isNullOrNil(fTSEmojiDetailPageUI.cwg)) {
                    i = 1;
                    break;
                }
            case 3:
                if (!bo.isNullOrNil(fTSEmojiDetailPageUI.cAo)) {
                    i = 2;
                    break;
                }
            case 4:
                if (!bo.isNullOrNil(fTSEmojiDetailPageUI.lcD)) {
                    i = 3;
                    break;
                }
            default:
                i = 0;
                break;
        }
        if (fTSEmojiDetailPageUI.blX()) {
            i = 4;
        }
        an.b(i2, str, str2, 3, i);
        if (fTSEmojiDetailPageUI.blX()) {
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 8);
            bundle.putString("stat_search_id", fTSEmojiDetailPageUI.lcA);
            String str3 = fTSEmojiDetailPageUI.lcA + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + fTSEmojiDetailPageUI.kVF + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + String.valueOf(fTSEmojiDetailPageUI.scene) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + String.valueOf(fTSEmojiDetailPageUI.type);
            Intent intent = new Intent();
            intent.putExtra("key_username", fTSEmojiDetailPageUI.lcG);
            intent.putExtra("key_can_swipe_back", true);
            intent.putExtra("key_from_scene", 6);
            intent.putExtra("key_scene_note", str3);
            intent.putExtra("_stat_obj", bundle);
            com.tencent.mm.bp.d.b(fTSEmojiDetailPageUI.mController.ylL, "appbrand", ".ui.AppBrandProfileUI", intent);
            AppMethodBeat.o(53562);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("preceding_scence", fTSEmojiDetailPageUI.getIntent().getIntExtra("preceding_scence", 0));
        intent2.putExtra("download_entrance_scene", 27);
        intent2.putExtra("searchID", bo.getLong(fTSEmojiDetailPageUI.lcA, 0));
        intent2.putExtra("docID", fTSEmojiDetailPageUI.kVF);
        switch (fTSEmojiDetailPageUI.type) {
            case 2:
                intent2.setClass(fTSEmojiDetailPageUI, EmojiStoreDetailUI.class);
                intent2.setFlags(268435456);
                intent2.putExtra("extra_scence", fTSEmojiDetailPageUI.scene);
                intent2.putExtra("extra_type", fTSEmojiDetailPageUI.type);
                intent2.putExtra("extra_id", fTSEmojiDetailPageUI.cwg);
                break;
            case 3:
                intent2.setClass(fTSEmojiDetailPageUI, EmojiStoreV2DesignerUI.class);
                intent2.putExtra("extra_scence", 27);
                intent2.putExtra("id", fTSEmojiDetailPageUI.cAo);
                intent2.putExtra("name", fTSEmojiDetailPageUI.designerName);
                intent2.putExtra("headurl", fTSEmojiDetailPageUI.lcF);
                break;
            case 4:
                if (!bo.isNullOrNil(fTSEmojiDetailPageUI.lcD)) {
                    intent2.putExtra("rawUrl", fTSEmojiDetailPageUI.lcD);
                    com.tencent.mm.bp.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                }
                AppMethodBeat.o(53562);
                return;
            default:
                AppMethodBeat.o(53562);
                return;
        }
        fTSEmojiDetailPageUI.startActivity(intent2);
        AppMethodBeat.o(53562);
    }

    static /* synthetic */ void d(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(53563);
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (fTSEmojiDetailPageUI.lcz) {
            arrayList.add(Integer.valueOf(1));
            arrayList2.add(fTSEmojiDetailPageUI.getString(R.string.dwz));
        }
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(fTSEmojiDetailPageUI.getString(R.string.bac));
        if (fTSEmojiDetailPageUI.icA == null) {
            fTSEmojiDetailPageUI.icA = new j(fTSEmojiDetailPageUI.mController.ylL);
        }
        fTSEmojiDetailPageUI.icA.rBl = new n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(53550);
                lVar.setHeaderTitle((CharSequence) "");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        lVar.e(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.o(53550);
                        return;
                    }
                }
            }
        };
        fTSEmojiDetailPageUI.icA.rBm = fTSEmojiDetailPageUI.lcJ;
        fTSEmojiDetailPageUI.icA.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(53536);
                FTSEmojiDetailPageUI.this.icA = null;
                AppMethodBeat.o(53536);
            }
        });
        h.a(fTSEmojiDetailPageUI.mController.ylL, fTSEmojiDetailPageUI.icA.cuu());
        AppMethodBeat.o(53563);
    }

    static /* synthetic */ void h(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(53565);
        ab.d("MicroMsg.FTS.FTSEmojiDetailPageUI", "ApplicationLanguage" + aa.dor());
        String str = fTSEmojiDetailPageUI.getString(R.string.c1d) + aa.dor();
        Intent intent = new Intent();
        intent.putExtra("title", fTSEmojiDetailPageUI.getString(R.string.bac));
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.bp.d.b((Context) fTSEmojiDetailPageUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        AppMethodBeat.o(53565);
    }

    static /* synthetic */ void i(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        AppMethodBeat.i(53566);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(53538);
                EmojiInfo aqi = com.tencent.mm.plugin.emoji.model.j.getEmojiStorageMgr().xYn.aqi(FTSEmojiDetailPageUI.this.exP.Aq());
                if (aqi != null) {
                    FTSEmojiDetailPageUI.this.exP = aqi;
                }
                if (com.tencent.mm.plugin.emoji.e.f.bjK().m(FTSEmojiDetailPageUI.this.exP)) {
                    String str = FTSEmojiDetailPageUI.this.exP.dve() + "_decode";
                    if (e.ct(str)) {
                        e.deleteFile(str);
                    }
                    e.atc(str);
                    byte[] l = com.tencent.mm.plugin.emoji.e.f.bjK().l(FTSEmojiDetailPageUI.this.exP);
                    e.b(str, l, l.length);
                    com.tencent.mm.pluginsdk.ui.tools.n.j(str, FTSEmojiDetailPageUI.this);
                    e.deleteFile(str);
                    AppMethodBeat.o(53538);
                    return;
                }
                if (e.ct(FTSEmojiDetailPageUI.this.cHg)) {
                    com.tencent.mm.pluginsdk.ui.tools.n.j(FTSEmojiDetailPageUI.this.cHg, FTSEmojiDetailPageUI.this);
                }
                AppMethodBeat.o(53538);
            }
        });
        AppMethodBeat.o(53566);
    }
}
