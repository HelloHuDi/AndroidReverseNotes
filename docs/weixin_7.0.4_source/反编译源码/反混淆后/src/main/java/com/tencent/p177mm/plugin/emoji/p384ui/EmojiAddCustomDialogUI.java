package com.tencent.p177mm.plugin.emoji.p384ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.p227a.C1506c;
import com.tencent.p177mm.emoji.p227a.C1506c.C1507b;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.emoji.p227a.C32498b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p207by.C45274a;
import com.tencent.p177mm.p207by.C45274a.C1336b;
import com.tencent.p177mm.p230g.p231a.C45317cz;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.tools.p632b.C24046b;
import com.tencent.p177mm.p612ui.tools.p632b.C24046b.C24047a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p726f.C33949c;
import com.tencent.p177mm.plugin.emoji.p726f.C42945g;
import com.tencent.p177mm.plugin.emoji.p947e.C20362f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C44121gn;
import com.tencent.p177mm.protocal.protobuf.cab;
import com.tencent.p177mm.protocal.protobuf.cac;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI */
public class EmojiAddCustomDialogUI extends MMBaseActivity implements C1202f {
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
    private C1506c kZf;
    private C5653c kZg;
    private C5653c kZh;
    private Runnable kZi = new C68431();
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI$5 */
    class C68395 implements OnClickListener {
        C68395() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(53274);
            EmojiAddCustomDialogUI.this.setResult(3);
            EmojiAddCustomDialogUI.this.finish();
            AppMethodBeat.m2505o(53274);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI$3 */
    class C68403 implements C1507b {
        C68403() {
        }

        /* renamed from: b */
        public final void mo4971b(int i, int i2, String str, boolean z) {
            AppMethodBeat.m2504i(53272);
            if (i == 0 && i2 == 0) {
                EmojiAddCustomDialogUI.this.kYY = str;
                EmojiAddCustomDialogUI.m11303c(EmojiAddCustomDialogUI.this, str);
                AppMethodBeat.m2505o(53272);
            } else if (z) {
                EmojiAddCustomDialogUI.m11305e(EmojiAddCustomDialogUI.this);
                AppMethodBeat.m2505o(53272);
            } else if (i2 == 4) {
                EmojiAddCustomDialogUI.m11306f(EmojiAddCustomDialogUI.this);
                AppMethodBeat.m2505o(53272);
            } else {
                EmojiAddCustomDialogUI.m11307g(EmojiAddCustomDialogUI.this);
                AppMethodBeat.m2505o(53272);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI$4 */
    class C68424 implements OnClickListener {
        C68424() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(53273);
            Intent intent = new Intent();
            C7060h.pYm.mo8381e(11596, Integer.valueOf(3));
            intent.setClass(EmojiAddCustomDialogUI.this.mContext, EmojiCustomUI.class);
            intent.putExtra("key_emoji_panel_type", 0);
            EmojiAddCustomDialogUI.this.startActivity(intent);
            AppMethodBeat.m2505o(53273);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI$1 */
    class C68431 implements Runnable {
        C68431() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53269);
            EmojiAddCustomDialogUI.m11299a(EmojiAddCustomDialogUI.this, EmojiAddCustomDialogUI.this.getString(C25738R.string.bce));
            AppMethodBeat.m2505o(53269);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI$7 */
    class C68447 implements OnClickListener {
        C68447() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(53276);
            EmojiAddCustomDialogUI.this.setResult(2);
            EmojiAddCustomDialogUI.this.finish();
            AppMethodBeat.m2505o(53276);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI$8 */
    class C68458 implements OnCancelListener {
        C68458() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI$9 */
    class C68469 implements OnDismissListener {
        C68469() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53277);
            EmojiAddCustomDialogUI.this.setResult(1);
            EmojiAddCustomDialogUI.this.finish();
            AppMethodBeat.m2505o(53277);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI$6 */
    class C68476 implements OnDismissListener {
        C68476() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(53275);
            EmojiAddCustomDialogUI.this.setResult(3);
            EmojiAddCustomDialogUI.this.finish();
            AppMethodBeat.m2505o(53275);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiAddCustomDialogUI() {
        AppMethodBeat.m2504i(53278);
        AppMethodBeat.m2505o(53278);
    }

    /* renamed from: a */
    static /* synthetic */ void m11298a(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.m2504i(53290);
        emojiAddCustomDialogUI.blm();
        AppMethodBeat.m2505o(53290);
    }

    /* renamed from: c */
    static /* synthetic */ void m11303c(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        AppMethodBeat.m2504i(53294);
        emojiAddCustomDialogUI.m11296JM(str);
        AppMethodBeat.m2505o(53294);
    }

    /* renamed from: g */
    static /* synthetic */ void m11307g(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.m2504i(53296);
        emojiAddCustomDialogUI.blk();
        AppMethodBeat.m2505o(53296);
    }

    /* renamed from: u */
    static /* synthetic */ void m11310u(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(53291);
        EmojiAddCustomDialogUI.m11309t(emojiInfo);
        AppMethodBeat.m2505o(53291);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53279);
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
            this.kYZ = C1853r.m3846Yz();
        }
        this.jOI = getIntent().getBooleanExtra("extra_move_to_top", false);
        this.kZb = getIntent().getBooleanExtra("key_is_selfie", false);
        this.kZc = getIntent().getStringExtra("key_attached_text");
        this.kZd = getIntent().getStringArrayListExtra("key_attached_emoji_md5");
        this.kZe = getIntent().getStringExtra("key_imitate_md5");
        if (C5046bo.isNullOrNil(this.hxH)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
            setResult(1);
            finish();
        }
        this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(this.hxH);
        C1720g.m3535RO().eJo.mo14539a(698, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        C5004al.m7442n(this.kZi, 300);
        Context context = this.mContext;
        final EmojiInfo emojiInfo = this.kZa;
        if (context == null) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
            AppMethodBeat.m2505o(53279);
        } else if (emojiInfo == null) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
            AppMethodBeat.m2505o(53279);
        } else {
            C24046b asm = C24046b.asm(emojiInfo.dve());
            asm.mSize = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35643d(emojiInfo, this.kZb);
            asm.mo39850PL(C42164b.m74339Na()).mo39851a(new C24047a() {
                /* renamed from: a */
                public final void mo15114a(C24046b c24046b) {
                    AppMethodBeat.m2504i(53270);
                    C32498b c32498b = C32498b.eyD;
                    if (C32498b.m53213OE().getBoolean("custom_full", false)) {
                        C4990ab.m7416i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
                        EmojiAddCustomDialogUI.this.blb();
                        EmojiAddCustomDialogUI.m11298a(EmojiAddCustomDialogUI.this);
                        C7060h.pYm.mo8381e(10431, Integer.valueOf(EmojiAddCustomDialogUI.this.gOW), EmojiAddCustomDialogUI.this.kZa.mo20410Aq(), EmojiAddCustomDialogUI.this.kZa.field_designerID, EmojiAddCustomDialogUI.this.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(EmojiAddCustomDialogUI.this.kZa.field_size), EmojiAddCustomDialogUI.this.kYZ, EmojiAddCustomDialogUI.this.kZa.field_activityid);
                        AppMethodBeat.m2505o(53270);
                    } else if (emojiInfo.field_catalog == EmojiInfo.yaB || C5046bo.isNullOrNil(emojiInfo.field_groupId) || C5046bo.isEqual(emojiInfo.field_groupId, "capture") || (!C5046bo.isNullOrNil(emojiInfo.field_groupId) && ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35601Ji(emojiInfo.field_groupId))) {
                        EmojiAddCustomDialogUI.m11310u(emojiInfo);
                        AppMethodBeat.m2505o(53270);
                    } else {
                        EmojiAddCustomDialogUI.m11311v(emojiInfo);
                        AppMethodBeat.m2505o(53270);
                    }
                }

                public final void bln() {
                    AppMethodBeat.m2504i(53271);
                    EmojiAddCustomDialogUI.this.blb();
                    EmojiAddCustomDialogUI.m11305e(EmojiAddCustomDialogUI.this);
                    C7060h.pYm.mo8381e(10431, Integer.valueOf(EmojiAddCustomDialogUI.this.gOW), EmojiAddCustomDialogUI.this.kZa.mo20410Aq(), EmojiAddCustomDialogUI.this.kZa.field_designerID, EmojiAddCustomDialogUI.this.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(EmojiAddCustomDialogUI.this.kZa.field_size), EmojiAddCustomDialogUI.this.kYZ, EmojiAddCustomDialogUI.this.kZa.field_activityid);
                    AppMethodBeat.m2505o(53271);
                }
            });
            AppMethodBeat.m2505o(53279);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53280);
        C1720g.m3535RO().eJo.mo14546b(698, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b((int) v2helper.EMethodSetNgStrength, (C1202f) this);
        C5004al.m7439af(this.kZi);
        super.onDestroy();
        if (this.kZf != null) {
            this.kZf.eyM = null;
        }
        AppMethodBeat.m2505o(53280);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(53281);
        int type = c1207m.getType();
        if (type == 698) {
            C33949c c33949c = (C33949c) c1207m;
            if (i2 == -434) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
                blb();
                blm();
                C7060h.pYm.mo8381e(10431, Integer.valueOf(this.gOW), this.kZa.mo20410Aq(), this.kZa.field_designerID, this.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.kZa.field_size), this.kYZ, this.kZa.field_activityid);
                AppMethodBeat.m2505o(53281);
                return;
            } else if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
                C44121gn c44121gn = (C44121gn) c33949c.ehh.fsH.fsP;
                if (c44121gn == null || c44121gn.vIL == null || c44121gn.vIL.size() <= 0) {
                    m11296JM(null);
                    AppMethodBeat.m2505o(53281);
                    return;
                }
                C4990ab.m7417i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", Integer.valueOf(c44121gn.vIL.size()));
                C4990ab.m7416i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
                if (this.kZf != null) {
                    this.kZf.eyM = null;
                }
                this.kZf = new C1506c(this.kZa, this.kZb, this.jOI, this.kZc, this.kZd, this.kZe);
                this.kZf.eyM = new C68403();
                AppMethodBeat.m2505o(53281);
                return;
            } else {
                blk();
                AppMethodBeat.m2505o(53281);
                return;
            }
        }
        if (type == v2helper.EMethodSetNgStrength) {
            if (c1207m instanceof C42945g) {
                C42945g c42945g = (C42945g) c1207m;
                if (c42945g == null || C5046bo.isNullOrNil(c42945g.kWz) || this.kZa == null || C5046bo.isNullOrNil(this.kZa.field_groupId) || !this.kZa.field_groupId.equalsIgnoreCase(c42945g.kWz)) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
                } else if (i == 0 && i2 == 0) {
                    EmojiAddCustomDialogUI.m11309t(this.kZa);
                    AppMethodBeat.m2505o(53281);
                    return;
                } else if (i2 == 4) {
                    blb();
                    m11297JN(getString(C25738R.string.b94));
                    AppMethodBeat.m2505o(53281);
                    return;
                } else if (i2 == 8) {
                    blb();
                    m11297JN(getString(C25738R.string.b93));
                    AppMethodBeat.m2505o(53281);
                    return;
                } else if (i2 == 9) {
                    blb();
                    m11297JN(getString(C25738R.string.b92));
                    AppMethodBeat.m2505o(53281);
                    return;
                } else if (i2 == -2) {
                    blb();
                    m11297JN(getString(C25738R.string.b95));
                    AppMethodBeat.m2505o(53281);
                    return;
                } else {
                    blb();
                    m11297JN(getString(C25738R.string.b91));
                    AppMethodBeat.m2505o(53281);
                    return;
                }
            }
            AppMethodBeat.m2505o(53281);
            return;
        }
        AppMethodBeat.m2505o(53281);
    }

    private void blk() {
        AppMethodBeat.m2504i(53282);
        C4990ab.m7416i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
        blb();
        C30379h.m48465bQ(this.mContext, C4996ah.getContext().getString(C25738R.string.b91));
        C7060h.pYm.mo8381e(10431, Integer.valueOf(this.gOW), this.kZa.mo20410Aq(), this.kZa.field_designerID, this.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(this.kZa.field_size), this.kYZ, this.kZa.field_activityid);
        setResult(1);
        finish();
        AppMethodBeat.m2505o(53282);
    }

    /* renamed from: JM */
    private void m11296JM(String str) {
        AppMethodBeat.m2504i(53283);
        if (!(str == null || str.equals(this.kZa.mo20410Aq()))) {
            this.kZa = C42952j.getEmojiStorageMgr().xYn.aqi(str);
        }
        C4990ab.m7410d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
        if (this.kZa.field_catalog != EmojiInfo.yaB) {
            this.kZa.field_catalog = EmojiInfo.yaB;
            int dvi = C42952j.getEmojiStorageMgr().xYn.dvi();
            if (dvi < C26072e.m41618OM()) {
                dvi = C26072e.m41618OM();
            } else {
                dvi++;
            }
            this.kZa.field_reserved3 = dvi;
            C42952j.getEmojiStorageMgr().xYn.mo48555G(this.kZa);
            C7060h.pYm.mo8381e(10431, Integer.valueOf(this.gOW), this.kZa.mo20410Aq(), this.kZa.field_designerID, this.kZa.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.kZa.field_size), this.kYZ, this.kZa.field_activityid);
            C20362f.bjK().mo35591c(this.kZa, false);
        }
        if (this.jOI) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.kZa.mo20410Aq());
            C42952j.getEmojiStorageMgr().xYn.mo48585l(0, arrayList);
        }
        String str2 = this.kZa.dve() + "_cover";
        if (!(C5046bo.isNullOrNil(this.kZa.field_thumbUrl) || C5730e.m8628ct(str2))) {
            C17927a c17927a = new C17927a();
            c17927a.ePJ = str2;
            c17927a.ePH = true;
            c17927a.ePF = false;
            C32291o.ahp().mo43766a(this.kZa.field_thumbUrl, null, c17927a.ahG());
        }
        EmojiAddCustomDialogUI.bll();
        blb();
        C30379h.m48465bQ(this.mContext, C4996ah.getContext().getString(C25738R.string.f8817fv));
        Intent intent = new Intent();
        intent.putExtra("extra_id", str);
        intent.putExtra("activityId", this.kZa.field_activityid);
        setResult(-1, intent);
        finish();
        AppMethodBeat.m2505o(53283);
    }

    private static void bll() {
        AppMethodBeat.m2504i(53284);
        C45317cz c45317cz = new C45317cz();
        c45317cz.cwc.type = 1;
        C4879a.xxA.mo10055m(c45317cz);
        if (!c45317cz.cwd.cwe) {
            cab bjU = C42952j.getEmojiStorageMgr().xYq.bjU();
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
            C42952j.getEmojiStorageMgr().xYq.mo64091b(bjU);
            C45274a.dmE();
            C1336b c1336b = C45274a.xum;
            C1336b.alW(String.valueOf(EmojiGroupInfo.yas));
        }
        AppMethodBeat.m2505o(53284);
    }

    /* renamed from: t */
    private static void m11309t(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(53285);
        C4990ab.m7416i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate");
        ArrayList arrayList = new ArrayList();
        arrayList.add(emojiInfo.mo20410Aq());
        C1720g.m3535RO().eJo.mo14541a(new C33949c(0, 4, arrayList), 0);
        AppMethodBeat.m2505o(53285);
    }

    private void blm() {
        AppMethodBeat.m2504i(53286);
        if (isFinishing()) {
            AppMethodBeat.m2505o(53286);
            return;
        }
        this.kZg = C30379h.m48428a(this.mContext, (int) C25738R.string.bd2, (int) C25738R.string.f9104pl, (int) C25738R.string.bb0, (int) C25738R.string.f9076or, new C68424(), new C68395());
        if (this.kZg != null) {
            this.kZg.setOnDismissListener(new C68476());
        }
        AppMethodBeat.m2505o(53286);
    }

    /* renamed from: JN */
    private void m11297JN(String str) {
        AppMethodBeat.m2504i(53287);
        if (isFinishing()) {
            AppMethodBeat.m2505o(53287);
            return;
        }
        this.kZh = C30379h.m48461b((Context) this, str, "", true);
        this.kZh.setOnDismissListener(new C68469());
        AppMethodBeat.m2505o(53287);
    }

    /* Access modifiers changed, original: protected|final */
    public final void blb() {
        AppMethodBeat.m2504i(53288);
        C5004al.m7439af(this.kZi);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.m2505o(53288);
    }

    /* renamed from: a */
    static /* synthetic */ void m11299a(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        AppMethodBeat.m2504i(53289);
        if (!emojiAddCustomDialogUI.isFinishing()) {
            emojiAddCustomDialogUI.getString(C25738R.string.f9238tz);
            emojiAddCustomDialogUI.gqo = C30379h.m48458b((Context) emojiAddCustomDialogUI, str, false, new C68458());
        }
        AppMethodBeat.m2505o(53289);
    }

    /* renamed from: v */
    static /* synthetic */ void m11311v(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(53292);
        C1720g.m3535RO().eJo.mo14541a(new C42945g(emojiInfo.field_groupId, (byte) 0), 0);
        AppMethodBeat.m2505o(53292);
    }

    /* renamed from: e */
    static /* synthetic */ void m11305e(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.m2504i(53293);
        if (!emojiAddCustomDialogUI.isFinishing()) {
            emojiAddCustomDialogUI.kZg = C30379h.m48443a(emojiAddCustomDialogUI.mContext, emojiAddCustomDialogUI.mContext.getString(C25738R.string.b9w), "", emojiAddCustomDialogUI.getString(C25738R.string.cd_), new C68447());
        }
        AppMethodBeat.m2505o(53293);
    }

    /* renamed from: f */
    static /* synthetic */ void m11306f(EmojiAddCustomDialogUI emojiAddCustomDialogUI) {
        AppMethodBeat.m2504i(53295);
        emojiAddCustomDialogUI.blb();
        C30379h.m48465bQ(emojiAddCustomDialogUI.mContext, C4996ah.getContext().getString(C25738R.string.b91));
        C7060h.pYm.mo8381e(10431, Integer.valueOf(emojiAddCustomDialogUI.gOW), emojiAddCustomDialogUI.kZa.mo20410Aq(), emojiAddCustomDialogUI.kZa.field_designerID, emojiAddCustomDialogUI.kZa.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(emojiAddCustomDialogUI.kZa.field_size), emojiAddCustomDialogUI.kYZ, emojiAddCustomDialogUI.kZa.field_activityid);
        emojiAddCustomDialogUI.setResult(4);
        emojiAddCustomDialogUI.finish();
        AppMethodBeat.m2505o(53295);
    }
}
