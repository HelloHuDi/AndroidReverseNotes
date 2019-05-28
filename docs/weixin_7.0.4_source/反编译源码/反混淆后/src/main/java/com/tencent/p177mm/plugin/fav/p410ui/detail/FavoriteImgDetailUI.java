package com.tencent.p177mm.plugin.fav.p410ui.detail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.MMLoadScrollView;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C45477q;
import com.tencent.p177mm.plugin.fav.p407a.C11855p;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C27968h;
import com.tencent.p177mm.plugin.fav.p407a.C27968h.C27969a;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C41268k;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.fav.p407a.C7604ae;
import com.tencent.p177mm.plugin.fav.p410ui.C11909i;
import com.tencent.p177mm.plugin.fav.p410ui.C3105g;
import com.tencent.p177mm.plugin.fav.p410ui.C45939l;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI */
public class FavoriteImgDetailUI extends BaseFavDetailReportUI implements C11855p {
    private int aUQ = 0;
    private C4884c mip = new C390612();
    private OnClickListener mjE = new C430715();
    private OnLongClickListener mlV = new C118986();
    private LinearLayout mmi;
    private C27966g mmj;
    private HashMap<String, C43072a> mmk = new HashMap();
    private Bitmap mml;
    private boolean mmm = true;

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI$6 */
    class C118986 implements OnLongClickListener {
        C118986() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(74386);
            C43072a c43072a = (C43072a) FavoriteImgDetailUI.this.mmk.get(((aar) view.getTag()).mnd);
            FavoriteImgDetailUI.m76528a(FavoriteImgDetailUI.this, c43072a);
            if (!c43072a.mmv) {
                FavoriteImgDetailUI.m76533b(c43072a);
            }
            AppMethodBeat.m2505o(74386);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI$9 */
    class C119009 implements OnTouchListener {
        C119009() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(74389);
            switch (motionEvent.getAction()) {
                case 0:
                    C32800b y = C37922v.m64076Zp().mo60676y("basescanui@datacenter", true);
                    y.mo53356j("key_basescanui_screen_x", Integer.valueOf((int) motionEvent.getRawX()));
                    y.mo53356j("key_basescanui_screen_y", Integer.valueOf((int) motionEvent.getRawY()));
                    break;
            }
            AppMethodBeat.m2505o(74389);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI$1 */
    class C207231 implements OnMenuItemClickListener {
        C207231() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(74374);
            FavoriteImgDetailUI.this.finish();
            AppMethodBeat.m2505o(74374);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI$2 */
    class C390612 extends C4884c<C18346nr> {
        C390612() {
            AppMethodBeat.m2504i(74375);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(74375);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(74376);
            C18346nr c18346nr = (C18346nr) c4883b;
            String str = c18346nr.cJX.filePath;
            C43072a c43072a = null;
            for (C43072a c43072a2 : FavoriteImgDetailUI.this.mmk.values()) {
                C43072a c43072a22;
                if (!str.equals(C39037b.m66370b(c43072a22.cAv))) {
                    c43072a22 = c43072a;
                }
                c43072a = c43072a22;
            }
            if (c43072a != null) {
                c43072a.mmw = C5046bo.m7532bc(c18346nr.cJX.result, "");
                c43072a.cvn = c18346nr.cJX.cvn;
                c43072a.cvo = c18346nr.cJX.cvo;
                if (!C5046bo.isNullOrNil(c43072a.mmw) && c43072a.hPs.rBk.isShowing()) {
                    FavoriteImgDetailUI.m76528a(FavoriteImgDetailUI.this, c43072a);
                }
            }
            AppMethodBeat.m2505o(74376);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI$5 */
    class C430715 implements OnClickListener {
        C430715() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74385);
            Intent intent = new Intent();
            intent.putExtra("key_detail_info_id", FavoriteImgDetailUI.this.mmj.field_localId);
            intent.putExtra("key_detail_data_id", ((aar) view.getTag()).mnd);
            C39037b.m66371b(FavoriteImgDetailUI.this.mController.ylL, ".ui.FavImgGalleryUI", intent);
            C27969a c27969a = FavoriteImgDetailUI.this.mlz;
            c27969a.meY++;
            AppMethodBeat.m2505o(74385);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI$a */
    class C43072a {
        aar cAv;
        ImageView cAw;
        int cvn;
        int cvo;
        C46696j hPs;
        boolean mmv;
        String mmw;

        private C43072a() {
            AppMethodBeat.m2504i(74391);
            this.hPs = new C46696j(FavoriteImgDetailUI.this.mController.ylL);
            this.mmv = false;
            this.mmw = null;
            this.cvn = 0;
            this.cvo = 0;
            AppMethodBeat.m2505o(74391);
        }

        /* synthetic */ C43072a(FavoriteImgDetailUI favoriteImgDetailUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavoriteImgDetailUI() {
        AppMethodBeat.m2504i(74392);
        AppMethodBeat.m2505o(74392);
    }

    /* Access modifiers changed, original: protected|final */
    public final MMLoadScrollView bwd() {
        AppMethodBeat.m2504i(74393);
        MMLoadScrollView mMLoadScrollView = (MMLoadScrollView) findViewById(2131823999);
        AppMethodBeat.m2505o(74393);
        return mMLoadScrollView;
    }

    public final int getLayoutId() {
        return 2130969537;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74394);
        C30036f.m47544m(this);
        super.onCreate(bundle);
        bwn();
        this.mmi = (LinearLayout) findViewById(2131824000);
        final long longExtra = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mmj = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23693iE(longExtra);
        if (this.mmj == null) {
            finish();
            AppMethodBeat.m2505o(74394);
            return;
        }
        mo54744F(this.mmj);
        Iterator it = this.mmj.field_favProto.wiv.iterator();
        int i = 0;
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            C4990ab.m7411d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", Integer.valueOf(i), aar.mnd);
            C43072a c43072a = new C43072a(this, (byte) 0);
            c43072a.cAv = aar;
            int i2 = i + 1;
            ImageView imageView = new ImageView(this.mController.ylL);
            int dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10011nc);
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = dimensionPixelSize;
            }
            this.mmi.addView(imageView, layoutParams);
            imageView.setTag(aar);
            i = dimensionPixelSize / 2;
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            imageView.setPadding(i, i, i, i);
            imageView.setMinimumWidth(C1338a.fromDPToPix(this.mController.ylL, 50));
            imageView.setMinimumHeight(C1338a.fromDPToPix(this.mController.ylL, 50));
            imageView.setImageResource(C1318a.fav_list_img_default);
            imageView.setOnClickListener(this.mjE);
            imageView.setOnLongClickListener(this.mlV);
            imageView.setOnTouchListener(new C119009());
            c43072a.cAw = imageView;
            this.mmk.put(aar.mnd, c43072a);
            m76527a(c43072a);
            if (aar.whh != 0) {
                this.mmm = false;
            }
            i = i2;
        }
        setMMTitle(getString(C25738R.string.bns));
        C20728a.m31955a(this, this.mmj);
        setBackBtn(new C207231());
        addIconOptionMenu(0, C25738R.string.ewm, C1318a.actionbar_icon_dark_more, new OnMenuItemClickListener() {

            /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI$3$2 */
            class C390622 implements C5279d {

                /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI$3$2$1 */
                class C390631 implements DialogInterface.OnClickListener {
                    C390631() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(74379);
                        final C44275p b = C30379h.m48458b(FavoriteImgDetailUI.this.mController.ylL, FavoriteImgDetailUI.this.getString(C25738R.string.f9089p5), false, null);
                        C39037b.m66365a(FavoriteImgDetailUI.this.mmj.field_localId, new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(74378);
                                FavoriteImgDetailUI.this.mlz.mfd = true;
                                b.dismiss();
                                C4990ab.m7411d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", Long.valueOf(FavoriteImgDetailUI.this.mmj.field_localId));
                                FavoriteImgDetailUI.this.finish();
                                AppMethodBeat.m2505o(74378);
                            }
                        });
                        AppMethodBeat.m2505o(74379);
                    }
                }

                C390622() {
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(74380);
                    Intent intent;
                    C27969a c27969a;
                    switch (menuItem.getItemId()) {
                        case 0:
                            intent = new Intent();
                            intent.putExtra("key_fav_scene", 2);
                            intent.putExtra("key_fav_item_id", FavoriteImgDetailUI.this.mmj.field_localId);
                            C39037b.m66371b(FavoriteImgDetailUI.this.mController.ylL, ".ui.FavTagEditUI", intent);
                            c27969a = FavoriteImgDetailUI.this.mlz;
                            c27969a.mfc++;
                            AppMethodBeat.m2505o(74380);
                            return;
                        case 1:
                            C30379h.m48440a(FavoriteImgDetailUI.this.mController.ylL, FavoriteImgDetailUI.this.getString(C25738R.string.f9089p5), "", new C390631(), null);
                            AppMethodBeat.m2505o(74380);
                            return;
                        case 2:
                            intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("scene_from", 1);
                            intent.putExtra("mutil_select_is_ret", true);
                            intent.putExtra("select_fav_local_id", FavoriteImgDetailUI.this.mmj.field_localId);
                            C25985d.m41466b(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                            C27968h.m44531j(FavoriteImgDetailUI.this.mmj.field_localId, 1, 0);
                            c27969a = FavoriteImgDetailUI.this.mlz;
                            c27969a.meZ++;
                            AppMethodBeat.m2505o(74380);
                            return;
                        case 3:
                            C3105g.m5347a(FavoriteImgDetailUI.this, longExtra, FavoriteImgDetailUI.this.mlz);
                            break;
                    }
                    AppMethodBeat.m2505o(74380);
                }
            }

            /* renamed from: com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI$3$1 */
            class C430701 implements C36073c {
                C430701() {
                }

                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(74377);
                    if (FavoriteImgDetailUI.this.mmm) {
                        c44273l.mo70068e(2, FavoriteImgDetailUI.this.getString(C25738R.string.bri));
                    }
                    c44273l.mo70068e(3, FavoriteImgDetailUI.this.getString(C25738R.string.br7));
                    c44273l.mo70068e(0, FavoriteImgDetailUI.this.getString(C25738R.string.bo8));
                    c44273l.mo70068e(1, FavoriteImgDetailUI.this.mController.ylL.getString(C25738R.string.f9088p4));
                    AppMethodBeat.m2505o(74377);
                }
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.m2504i(74381);
                C36356d c36356d = new C36356d(FavoriteImgDetailUI.this.mController.ylL, 1, false);
                c36356d.rBl = new C430701();
                c36356d.rBm = new C390622();
                c36356d.cpD();
                AppMethodBeat.m2505o(74381);
                return true;
            }
        });
        C30036f.m47545n(this);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15157a(this);
        C4879a.xxA.mo10052c(this.mip);
        AppMethodBeat.m2505o(74394);
    }

    public void onResume() {
        AppMethodBeat.m2504i(74395);
        super.onResume();
        for (Entry value : this.mmk.entrySet()) {
            m76527a((C43072a) value.getValue());
        }
        AppMethodBeat.m2505o(74395);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74396);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15159b(this);
        C4879a.xxA.mo10053d(this.mip);
        super.onDestroy();
        AppMethodBeat.m2505o(74396);
    }

    private void bwn() {
        DisplayMetrics displayMetrics;
        AppMethodBeat.m2504i(74397);
        if (C4996ah.getResources() != null) {
            displayMetrics = C4996ah.getResources().getDisplayMetrics();
        } else {
            displayMetrics = getResources().getDisplayMetrics();
        }
        this.aUQ = displayMetrics.widthPixels - (getResources().getDimensionPixelOffset(C25738R.dimen.f9848hs) * 2);
        this.aUQ = Math.max(this.aUQ, 0);
        C4990ab.m7411d("MicroMsg.FavoriteImgDetailUI", "update display width %d", Integer.valueOf(this.aUQ));
        AppMethodBeat.m2505o(74397);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(74398);
        super.onConfigurationChanged(configuration);
        bwn();
        for (Entry value : this.mmk.entrySet()) {
            m76527a((C43072a) value.getValue());
        }
        AppMethodBeat.m2505o(74398);
    }

    /* renamed from: a */
    private void m76527a(final C43072a c43072a) {
        AppMethodBeat.m2504i(74399);
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74384);
                Bitmap a = C45939l.m85276a(c43072a.cAv, FavoriteImgDetailUI.this.mmj, false);
                if (a == null) {
                    C4990ab.m7410d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
                    a = FavoriteImgDetailUI.m76526a(FavoriteImgDetailUI.this, c43072a.cAv);
                }
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(74382);
                        FavoriteImgDetailUI.m76529a(FavoriteImgDetailUI.this, c43072a, a);
                        AppMethodBeat.m2505o(74382);
                    }

                    public final String toString() {
                        AppMethodBeat.m2504i(74383);
                        String str = super.toString() + "|renderView";
                        AppMethodBeat.m2505o(74383);
                        return str;
                    }
                });
                AppMethodBeat.m2505o(74384);
            }
        });
        AppMethodBeat.m2505o(74399);
    }

    /* renamed from: a */
    public static void m76530a(String str, String str2, Context context) {
        AppMethodBeat.m2504i(74400);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.FavoriteImgDetailUI", "save image fail, path is null");
            AppMethodBeat.m2505o(74400);
            return;
        }
        if (!C45477q.m83806a(str, context, C25738R.string.b3r)) {
            Toast.makeText(context, str2, 1).show();
        }
        AppMethodBeat.m2505o(74400);
    }

    /* renamed from: l */
    private Bitmap m76535l(aar aar) {
        boolean z = true;
        AppMethodBeat.m2504i(74401);
        Bitmap a = C45939l.m85275a(aar, this.mmj);
        String str = "MicroMsg.FavoriteImgDetailUI";
        String str2 = "get thumb ok ? %B";
        Object[] objArr = new Object[1];
        if (a == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7411d(str, str2, objArr);
        if (a != null) {
            AppMethodBeat.m2505o(74401);
            return a;
        }
        if (this.mml == null) {
            this.mml = C1434a.decodeResource(getResources(), C1318a.fav_list_img_default);
        }
        Bitmap bitmap = this.mml;
        AppMethodBeat.m2505o(74401);
        return bitmap;
    }

    /* renamed from: d */
    public final void mo23673d(C45925c c45925c) {
        AppMethodBeat.m2504i(74402);
        if (c45925c == null || !c45925c.isFinished()) {
            AppMethodBeat.m2505o(74402);
            return;
        }
        C4990ab.m7411d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", c45925c.field_dataId);
        C43072a c43072a = (C43072a) this.mmk.get(c45925c.field_dataId);
        if (c43072a != null) {
            m76527a(c43072a);
        }
        AppMethodBeat.m2505o(74402);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(74403);
        if (1 == i) {
            if (-1 != i2) {
                AppMethodBeat.m2505o(74403);
                return;
            }
            C41268k c41268k = new C41268k();
            if (C41268k.m71869u(this.mmj)) {
                C30379h.m48465bQ(this.mController.ylL, getString(C25738R.string.f8634ah));
                AppMethodBeat.m2505o(74403);
                return;
            }
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            C4990ab.m7411d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", stringExtra);
            final C44275p b = C30379h.m48458b(this.mController.ylL, getString(C25738R.string.bp2), false, null);
            C11909i.m19791a(this.mController.ylL, stringExtra, stringExtra2, this.mmj, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74390);
                    b.dismiss();
                    C5670b.m8523i(FavoriteImgDetailUI.this, FavoriteImgDetailUI.this.getString(C25738R.string.bnf));
                    AppMethodBeat.m2505o(74390);
                }
            });
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(74403);
    }
}
