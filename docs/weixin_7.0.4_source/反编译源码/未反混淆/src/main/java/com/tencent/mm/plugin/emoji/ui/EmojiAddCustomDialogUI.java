package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.emoji.a.c;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.tools.b.b;
import com.tencent.mm.ui.tools.b.b.a;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiAddCustomDialogUI extends MMBaseActivity implements f {
    private int gOW;
    private ProgressDialog gqo;
    private String hxH;
    private boolean jOI;
    private String kYY;
    private String kYZ;
    private EmojiInfo kZa;
    private boolean kZb;
    private String kZc;
    private List<String> kZd;
    private String kZe;
    private c kZf;
    private com.tencent.mm.ui.widget.a.c kZg;
    private com.tencent.mm.ui.widget.a.c kZh;
    private Runnable kZi = new Runnable() {
        public final void run() {
            AppMethodBeat.i(53269);
            EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(R.string.bce));
            AppMethodBeat.o(53269);
        }
    };
    private Context mContext;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiAddCustomDialogUI() {
        AppMethodBeat.i(53278);
        AppMethodBeat.o(53278);
    }

    static /* synthetic */ void a(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.i(53290);
        emojiAddCustomDialogUI.blm();
        AppMethodBeat.o(53290);
    }

    static /* synthetic */ void c(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        AppMethodBeat.i(53294);
        emojiAddCustomDialogUI.JM(str);
        AppMethodBeat.o(53294);
    }

    static /* synthetic */ void g(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.i(53296);
        emojiAddCustomDialogUI.blk();
        AppMethodBeat.o(53296);
    }

    static /* synthetic */ void u(EmojiInfo emojiInfo) {
        AppMethodBeat.i(53291);
        t(emojiInfo);
        AppMethodBeat.o(53291);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53279);
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
            getWindow().setNavigationBarColor(0);
        }
        this.mContext = this;
        this.hxH = getIntent().getStringExtra("extra_id");
        this.gOW = getIntent().getIntExtra("extra_scence", -1);
        this.kYZ = getIntent().getStringExtra("extra_username");
        if (getIntent().getBooleanExtra("extra_current", false) && this.kYZ == null) {
            this.kYZ = r.Yz();
        }
        this.jOI = getIntent().getBooleanExtra("extra_move_to_top", false);
        this.kZb = getIntent().getBooleanExtra("key_is_selfie", false);
        this.kZc = getIntent().getStringExtra("key_attached_text");
        this.kZd = getIntent().getStringArrayListExtra("key_attached_emoji_md5");
        this.kZe = getIntent().getStringExtra("key_imitate_md5");
        if (bo.isNullOrNil(this.hxH)) {
            ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
            setResult(1);
            finish();
        }
        this.kZa = j.getEmojiStorageMgr().xYn.aqi(this.hxH);
        g.RO().eJo.a(698, (f) this);
        g.RO().eJo.a((int) v2helper.EMethodSetNgStrength, (f) this);
        al.n(this.kZi, 300);
        Context context = this.mContext;
        final EmojiInfo emojiInfo = this.kZa;
        if (context == null) {
            ab.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
            AppMethodBeat.o(53279);
        } else if (emojiInfo == null) {
            ab.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
            AppMethodBeat.o(53279);
        } else {
            b asm = b.asm(emojiInfo.dve());
            asm.mSize = ((d) g.M(d.class)).getEmojiMgr().d(emojiInfo, this.kZb);
            asm.PL(com.tencent.mm.m.b.Na()).a(new a() {
                public final void a(b bVar) {
                    AppMethodBeat.i(53270);
                    com.tencent.mm.emoji.a.b bVar2 = com.tencent.mm.emoji.a.b.eyD;
                    if (com.tencent.mm.emoji.a.b.OE().getBoolean("custom_full", false)) {
                        ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
                        EmojiAddCustomDialogUI.this.blb();
                        EmojiAddCustomDialogUI.a(EmojiAddCustomDialogUI.this);
                        h.pYm.e(10431, Integer.valueOf(EmojiAddCustomDialogUI.this.gOW), EmojiAddCustomDialogUI.this.kZa.Aq(), EmojiAddCustomDialogUI.this.kZa.field_designerID, EmojiAddCustomDialogUI.this.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.this.kZa.field_size), EmojiAddCustomDialogUI.this.kYZ, EmojiAddCustomDialogUI.this.kZa.field_activityid);
                        AppMethodBeat.o(53270);
                    } else if (emojiInfo.field_catalog == EmojiInfo.yaB || bo.isNullOrNil(emojiInfo.field_groupId) || bo.isEqual(emojiInfo.field_groupId, "capture") || (!bo.isNullOrNil(emojiInfo.field_groupId) && ((d) g.M(d.class)).getEmojiMgr().Ji(emojiInfo.field_groupId))) {
                        EmojiAddCustomDialogUI.u(emojiInfo);
                        AppMethodBeat.o(53270);
                    } else {
                        EmojiAddCustomDialogUI.v(emojiInfo);
                        AppMethodBeat.o(53270);
                    }
                }

                public final void bln() {
                    AppMethodBeat.i(53271);
                    EmojiAddCustomDialogUI.this.blb();
                    EmojiAddCustomDialogUI.e(EmojiAddCustomDialogUI.this);
                    h.pYm.e(10431, Integer.valueOf(EmojiAddCustomDialogUI.this.gOW), EmojiAddCustomDialogUI.this.kZa.Aq(), EmojiAddCustomDialogUI.this.kZa.field_designerID, EmojiAddCustomDialogUI.this.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(EmojiAddCustomDialogUI.this.kZa.field_size), EmojiAddCustomDialogUI.this.kYZ, EmojiAddCustomDialogUI.this.kZa.field_activityid);
                    AppMethodBeat.o(53271);
                }
            });
            AppMethodBeat.o(53279);
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(53280);
        g.RO().eJo.b(698, (f) this);
        g.RO().eJo.b((int) v2helper.EMethodSetNgStrength, (f) this);
        al.af(this.kZi);
        super.onDestroy();
        if (this.kZf != null) {
            this.kZf.eyM = null;
        }
        AppMethodBeat.o(53280);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(53281);
        int type = mVar.getType();
        if (type == 698) {
            com.tencent.mm.plugin.emoji.f.c cVar = (com.tencent.mm.plugin.emoji.f.c) mVar;
            if (i2 == -434) {
                ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
                blb();
                blm();
                h.pYm.e(10431, Integer.valueOf(this.gOW), this.kZa.Aq(), this.kZa.field_designerID, this.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.kZa.field_size), this.kYZ, this.kZa.field_activityid);
                AppMethodBeat.o(53281);
                return;
            } else if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
                gn gnVar = (gn) cVar.ehh.fsH.fsP;
                if (gnVar == null || gnVar.vIL == null || gnVar.vIL.size() <= 0) {
                    JM(null);
                    AppMethodBeat.o(53281);
                    return;
                }
                ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", Integer.valueOf(gnVar.vIL.size()));
                ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
                if (this.kZf != null) {
                    this.kZf.eyM = null;
                }
                this.kZf = new c(this.kZa, this.kZb, this.jOI, this.kZc, this.kZd, this.kZe);
                this.kZf.eyM = new c.b() {
                    public final void b(int i, int i2, String str, boolean z) {
                        AppMethodBeat.i(53272);
                        if (i == 0 && i2 == 0) {
                            EmojiAddCustomDialogUI.this.kYY = str;
                            EmojiAddCustomDialogUI.c(EmojiAddCustomDialogUI.this, str);
                            AppMethodBeat.o(53272);
                        } else if (z) {
                            EmojiAddCustomDialogUI.e(EmojiAddCustomDialogUI.this);
                            AppMethodBeat.o(53272);
                        } else if (i2 == 4) {
                            EmojiAddCustomDialogUI.f(EmojiAddCustomDialogUI.this);
                            AppMethodBeat.o(53272);
                        } else {
                            EmojiAddCustomDialogUI.g(EmojiAddCustomDialogUI.this);
                            AppMethodBeat.o(53272);
                        }
                    }
                };
                AppMethodBeat.o(53281);
                return;
            } else {
                blk();
                AppMethodBeat.o(53281);
                return;
            }
        }
        if (type == v2helper.EMethodSetNgStrength) {
            if (mVar instanceof com.tencent.mm.plugin.emoji.f.g) {
                com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) mVar;
                if (gVar == null || bo.isNullOrNil(gVar.kWz) || this.kZa == null || bo.isNullOrNil(this.kZa.field_groupId) || !this.kZa.field_groupId.equalsIgnoreCase(gVar.kWz)) {
                    ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
                } else if (i == 0 && i2 == 0) {
                    t(this.kZa);
                    AppMethodBeat.o(53281);
                    return;
                } else if (i2 == 4) {
                    blb();
                    JN(getString(R.string.b94));
                    AppMethodBeat.o(53281);
                    return;
                } else if (i2 == 8) {
                    blb();
                    JN(getString(R.string.b93));
                    AppMethodBeat.o(53281);
                    return;
                } else if (i2 == 9) {
                    blb();
                    JN(getString(R.string.b92));
                    AppMethodBeat.o(53281);
                    return;
                } else if (i2 == -2) {
                    blb();
                    JN(getString(R.string.b95));
                    AppMethodBeat.o(53281);
                    return;
                } else {
                    blb();
                    JN(getString(R.string.b91));
                    AppMethodBeat.o(53281);
                    return;
                }
            }
            AppMethodBeat.o(53281);
            return;
        }
        AppMethodBeat.o(53281);
    }

    private void blk() {
        AppMethodBeat.i(53282);
        ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
        blb();
        com.tencent.mm.ui.base.h.bQ(this.mContext, ah.getContext().getString(R.string.b91));
        h.pYm.e(10431, Integer.valueOf(this.gOW), this.kZa.Aq(), this.kZa.field_designerID, this.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(this.kZa.field_size), this.kYZ, this.kZa.field_activityid);
        setResult(1);
        finish();
        AppMethodBeat.o(53282);
    }

    private void JM(String str) {
        AppMethodBeat.i(53283);
        if (!(str == null || str.equals(this.kZa.Aq()))) {
            this.kZa = j.getEmojiStorageMgr().xYn.aqi(str);
        }
        ab.d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
        if (this.kZa.field_catalog != EmojiInfo.yaB) {
            this.kZa.field_catalog = EmojiInfo.yaB;
            int dvi = j.getEmojiStorageMgr().xYn.dvi();
            if (dvi < e.OM()) {
                dvi = e.OM();
            } else {
                dvi++;
            }
            this.kZa.field_reserved3 = dvi;
            j.getEmojiStorageMgr().xYn.G(this.kZa);
            h.pYm.e(10431, Integer.valueOf(this.gOW), this.kZa.Aq(), this.kZa.field_designerID, this.kZa.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.kZa.field_size), this.kYZ, this.kZa.field_activityid);
            com.tencent.mm.plugin.emoji.e.f.bjK().c(this.kZa, false);
        }
        if (this.jOI) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.kZa.Aq());
            j.getEmojiStorageMgr().xYn.l(0, arrayList);
        }
        String str2 = this.kZa.dve() + "_cover";
        if (!(bo.isNullOrNil(this.kZa.field_thumbUrl) || com.tencent.mm.vfs.e.ct(str2))) {
            com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
            aVar.ePJ = str2;
            aVar.ePH = true;
            aVar.ePF = false;
            o.ahp().a(this.kZa.field_thumbUrl, null, aVar.ahG());
        }
        bll();
        blb();
        com.tencent.mm.ui.base.h.bQ(this.mContext, ah.getContext().getString(R.string.fv));
        Intent intent = new Intent();
        intent.putExtra("extra_id", str);
        intent.putExtra("activityId", this.kZa.field_activityid);
        setResult(-1, intent);
        finish();
        AppMethodBeat.o(53283);
    }

    private static void bll() {
        AppMethodBeat.i(53284);
        cz czVar = new cz();
        czVar.cwc.type = 1;
        com.tencent.mm.sdk.b.a.xxA.m(czVar);
        if (!czVar.cwd.cwe) {
            cab bjU = j.getEmojiStorageMgr().xYq.bjU();
            if (bjU != null) {
                Iterator it = bjU.wZl.iterator();
                while (it.hasNext()) {
                    cac cac = (cac) it.next();
                    if (cac.ProductID.equals(String.valueOf(EmojiGroupInfo.yas))) {
                        cac.vKj = 0;
                        break;
                    }
                }
            }
            j.getEmojiStorageMgr().xYq.b(bjU);
            com.tencent.mm.by.a.dmE();
            com.tencent.mm.by.a.b bVar = com.tencent.mm.by.a.xum;
            com.tencent.mm.by.a.b.alW(String.valueOf(EmojiGroupInfo.yas));
        }
        AppMethodBeat.o(53284);
    }

    private static void t(EmojiInfo emojiInfo) {
        AppMethodBeat.i(53285);
        ab.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate");
        ArrayList arrayList = new ArrayList();
        arrayList.add(emojiInfo.Aq());
        g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.c(0, 4, arrayList), 0);
        AppMethodBeat.o(53285);
    }

    private void blm() {
        AppMethodBeat.i(53286);
        if (isFinishing()) {
            AppMethodBeat.o(53286);
            return;
        }
        this.kZg = com.tencent.mm.ui.base.h.a(this.mContext, (int) R.string.bd2, (int) R.string.pl, (int) R.string.bb0, (int) R.string.or, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(53273);
                Intent intent = new Intent();
                h.pYm.e(11596, Integer.valueOf(3));
                intent.setClass(EmojiAddCustomDialogUI.this.mContext, EmojiCustomUI.class);
                intent.putExtra("key_emoji_panel_type", 0);
                EmojiAddCustomDialogUI.this.startActivity(intent);
                AppMethodBeat.o(53273);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(53274);
                EmojiAddCustomDialogUI.this.setResult(3);
                EmojiAddCustomDialogUI.this.finish();
                AppMethodBeat.o(53274);
            }
        });
        if (this.kZg != null) {
            this.kZg.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    AppMethodBeat.i(53275);
                    EmojiAddCustomDialogUI.this.setResult(3);
                    EmojiAddCustomDialogUI.this.finish();
                    AppMethodBeat.o(53275);
                }
            });
        }
        AppMethodBeat.o(53286);
    }

    private void JN(String str) {
        AppMethodBeat.i(53287);
        if (isFinishing()) {
            AppMethodBeat.o(53287);
            return;
        }
        this.kZh = com.tencent.mm.ui.base.h.b((Context) this, str, "", true);
        this.kZh.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(53277);
                EmojiAddCustomDialogUI.this.setResult(1);
                EmojiAddCustomDialogUI.this.finish();
                AppMethodBeat.o(53277);
            }
        });
        AppMethodBeat.o(53287);
    }

    /* Access modifiers changed, original: protected|final */
    public final void blb() {
        AppMethodBeat.i(53288);
        al.af(this.kZi);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.o(53288);
    }

    static /* synthetic */ void a(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        AppMethodBeat.i(53289);
        if (!emojiAddCustomDialogUI.isFinishing()) {
            emojiAddCustomDialogUI.getString(R.string.tz);
            emojiAddCustomDialogUI.gqo = com.tencent.mm.ui.base.h.b((Context) emojiAddCustomDialogUI, str, false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        }
        AppMethodBeat.o(53289);
    }

    static /* synthetic */ void v(EmojiInfo emojiInfo) {
        AppMethodBeat.i(53292);
        g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.g(emojiInfo.field_groupId, (byte) 0), 0);
        AppMethodBeat.o(53292);
    }

    static /* synthetic */ void e(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.i(53293);
        if (!emojiAddCustomDialogUI.isFinishing()) {
            emojiAddCustomDialogUI.kZg = com.tencent.mm.ui.base.h.a(emojiAddCustomDialogUI.mContext, emojiAddCustomDialogUI.mContext.getString(R.string.b9w), "", emojiAddCustomDialogUI.getString(R.string.cd_), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(53276);
                    EmojiAddCustomDialogUI.this.setResult(2);
                    EmojiAddCustomDialogUI.this.finish();
                    AppMethodBeat.o(53276);
                }
            });
        }
        AppMethodBeat.o(53293);
    }

    static /* synthetic */ void f(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.i(53295);
        emojiAddCustomDialogUI.blb();
        com.tencent.mm.ui.base.h.bQ(emojiAddCustomDialogUI.mContext, ah.getContext().getString(R.string.b91));
        h.pYm.e(10431, Integer.valueOf(emojiAddCustomDialogUI.gOW), emojiAddCustomDialogUI.kZa.Aq(), emojiAddCustomDialogUI.kZa.field_designerID, emojiAddCustomDialogUI.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(emojiAddCustomDialogUI.kZa.field_size), emojiAddCustomDialogUI.kYZ, emojiAddCustomDialogUI.kZa.field_activityid);
        emojiAddCustomDialogUI.setResult(4);
        emojiAddCustomDialogUI.finish();
        AppMethodBeat.o(53295);
    }
}
