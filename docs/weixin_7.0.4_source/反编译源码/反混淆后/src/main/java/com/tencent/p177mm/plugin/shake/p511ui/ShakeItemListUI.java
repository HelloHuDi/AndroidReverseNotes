package com.tencent.p177mm.plugin.shake.p511ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p198aw.C25847d;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.C36043b;
import com.tencent.p177mm.p612ui.applet.C36043b.C23577b;
import com.tencent.p177mm.p612ui.applet.C36043b.C5234a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.C46193a;
import com.tencent.p177mm.plugin.shake.p1019b.C13247e;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.plugin.shake.p1019b.C34894d;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C34900h;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C3826k;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C39695i;
import com.tencent.p177mm.plugin.shake.p509d.p510a.C39695i.C396961;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI */
public class ShakeItemListUI extends MMActivity {
    private C25815a fGv = null;
    private ListView gxZ;
    /* renamed from: id */
    private int f16181id;
    private C5279d jKa = new C132658();
    private View kmS;
    private boolean quA = false;
    private C39702a quB;
    public long quz = 0;
    private int showType;

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$8 */
    class C132658 implements C5279d {
        C132658() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(24727);
            C28987m.cjS().mo25301Ct(ShakeItemListUI.this.f16181id);
            AppMethodBeat.m2505o(24727);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$1 */
    class C218351 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$1$1 */
        class C218341 implements OnClickListener {
            C218341() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(24719);
                switch (ShakeItemListUI.this.showType) {
                    case -12:
                    case 11:
                        C28987m.cjS().mo25302Cu(11);
                        break;
                    case -6:
                    case 5:
                        C28987m.cjS().mo25302Cu(7);
                        C28987m.cjS().mo25302Cu(6);
                        C28987m.cjS().mo25302Cu(8);
                        C28987m.cjS().mo25302Cu(9);
                        C28987m.cjS().mo25302Cu(10);
                        C28987m.cjS().mo25302Cu(12);
                        break;
                    case -5:
                    case 4:
                        C9638aw.m17180RS().mo10302aa(new C396961());
                        C28987m.cjS().mo25302Cu(4);
                        break;
                    case -1:
                    case 0:
                        C28987m.cjS().mo25302Cu(0);
                        break;
                    case 100:
                        C28987m.cjS().mo25302Cu(0);
                        C28987m.cjS().cjH();
                        break;
                }
                ShakeItemListUI.this.quB.mo6869KC();
                ShakeItemListUI.this.gxZ.setVisibility(8);
                TextView textView = (TextView) ShakeItemListUI.this.findViewById(2131826297);
                textView.setText(ShakeItemListUI.m67842CC(ShakeItemListUI.this.showType));
                textView.setVisibility(0);
                ShakeItemListUI.this.enableOptionMenu(false);
                AppMethodBeat.m2505o(24719);
            }
        }

        C218351() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24720);
            C30379h.m48453a(ShakeItemListUI.this, true, ShakeItemListUI.this.getString(C25738R.string.dx3), "", ShakeItemListUI.this.getString(C25738R.string.f9078ou), ShakeItemListUI.this.getString(C25738R.string.f9076or), new C218341(), null);
            AppMethodBeat.m2505o(24720);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$2 */
    class C218362 implements View.OnClickListener {
        C218362() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24721);
            ShakeItemListUI.this.showType = ShakeItemListUI.this.showType ^ -1;
            ShakeItemListUI.this.mo62656CB(ShakeItemListUI.this.showType);
            AppMethodBeat.m2505o(24721);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$6 */
    class C396976 implements View.OnClickListener {
        C396976() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24725);
            C4978c.m7375a(ShakeItemListUI.this.gxZ);
            AppMethodBeat.m2505o(24725);
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$5 */
    class C397005 implements OnMenuItemClickListener {
        C397005() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(24724);
            ShakeItemListUI.this.aqX();
            ShakeItemListUI.this.finish();
            AppMethodBeat.m2505o(24724);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$7 */
    class C397017 implements OnTouchListener {
        C397017() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(24726);
            if (ShakeItemListUI.this.quB != null) {
                C39702a b = ShakeItemListUI.this.quB;
                if (b.gvm != null) {
                    b.gvm.onTouchEvent(motionEvent);
                }
            }
            AppMethodBeat.m2505o(24726);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$a */
    class C39702a extends C46692p<C34894d> {
        C36043b gvm = new C36043b(new C397031());
        private C23577b gvn = null;
        private int showType = 0;

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$a$a */
        class C3838a {
            TextView gtG;
            ImageView gvq;
            TextView gvr;
            TextView oQA;
            ImageView oQB;
            TextView oQz;
            View quG;
            ImageView quH;
            TextView quI;
            LinearLayout quJ;
            TextView quK;

            C3838a() {
            }

            public final void clear() {
                AppMethodBeat.m2504i(24731);
                if (this.gvq != null) {
                    this.gvq.setImageDrawable(null);
                    this.gvq.setVisibility(8);
                }
                if (this.gtG != null) {
                    this.gtG.setText("");
                    this.gtG.setVisibility(8);
                }
                if (this.gvr != null) {
                    this.gvr.setVisibility(8);
                }
                if (this.quH != null) {
                    this.quH.setVisibility(8);
                }
                if (this.oQz != null) {
                    this.oQz.setText("");
                    this.oQz.setVisibility(8);
                }
                if (this.oQA != null) {
                    this.oQA.setVisibility(8);
                    this.quG.setVisibility(8);
                }
                if (this.oQB != null) {
                    this.oQB.setVisibility(8);
                }
                if (this.quI != null) {
                    this.quI.setText("");
                    this.quI.setVisibility(8);
                }
                AppMethodBeat.m2505o(24731);
            }
        }

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$a$2 */
        class C396982 implements C23577b {
            C396982() {
            }

            /* renamed from: mW */
            public final String mo11090mW(int i) {
                AppMethodBeat.m2504i(24729);
                if (i < 0 || i >= C39702a.this.getCount()) {
                    C4990ab.m7412e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
                    AppMethodBeat.m2505o(24729);
                    return null;
                }
                C34894d c34894d = (C34894d) C39702a.this.getItem(i);
                if (c34894d == null) {
                    AppMethodBeat.m2505o(24729);
                    return null;
                }
                String str = c34894d.field_username;
                AppMethodBeat.m2505o(24729);
                return str;
            }

            public final int apO() {
                AppMethodBeat.m2504i(24730);
                int count = C39702a.this.getCount();
                AppMethodBeat.m2505o(24730);
                return count;
            }
        }

        /* renamed from: com.tencent.mm.plugin.shake.ui.ShakeItemListUI$a$1 */
        class C397031 implements C5234a {
            C397031() {
            }

            /* renamed from: wd */
            public final Bitmap mo10738wd(String str) {
                AppMethodBeat.m2504i(24728);
                Bitmap a = C41730b.m73490a(str, false, -1);
                AppMethodBeat.m2505o(24728);
                return a;
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
            AppMethodBeat.m2504i(24737);
            C34894d c34894d = (C34894d) obj;
            if (c34894d == null) {
                c34894d = new C34894d();
            }
            if (cursor != null) {
                c34894d.mo8995d(cursor);
            }
            AppMethodBeat.m2505o(24737);
            return c34894d;
        }

        public C39702a(ShakeItemListUI shakeItemListUI) {
            super(shakeItemListUI, new C34894d());
            AppMethodBeat.m2504i(24732);
            mo6870KD();
            AppMethodBeat.m2505o(24732);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C3838a c3838a;
            AppMethodBeat.m2504i(24733);
            if (this.gvn == null) {
                this.gvn = new C396982();
            }
            if (this.gvm != null) {
                this.gvm.mo56803a(i, this.gvn);
            }
            if (view == null) {
                c3838a = new C3838a();
                view = View.inflate(this.context, 2130970652, null);
                c3838a.gvq = (ImageView) view.findViewById(2131823615);
                c3838a.gtG = (TextView) view.findViewById(2131823616);
                c3838a.gvr = (TextView) view.findViewById(2131826300);
                c3838a.quH = (ImageView) view.findViewById(2131826301);
                c3838a.oQz = (TextView) view.findViewById(2131826303);
                c3838a.oQA = (TextView) view.findViewById(2131826309);
                c3838a.oQB = (ImageView) view.findViewById(2131826302);
                c3838a.quI = (TextView) view.findViewById(2131827476);
                c3838a.quG = view.findViewById(2131826308);
                c3838a.quJ = (LinearLayout) view.findViewById(2131827478);
                c3838a.quK = (TextView) view.findViewById(2131827477);
                view.setTag(c3838a);
            } else {
                c3838a = (C3838a) view.getTag();
            }
            C34894d c34894d = (C34894d) getItem(i);
            if (c34894d != null) {
                c3838a.clear();
                if (4 == c34894d.field_type || (C3826k.m6119Cz(c34894d.field_type) && 6 != c34894d.field_type)) {
                    if (4 != c34894d.field_type) {
                        c3838a.gvq.setScaleType(ScaleType.CENTER_CROP);
                    }
                    C43527e.m77787a(c3838a.gvq, c34894d.field_sns_bgurl, C1318a.app_attach_file_icon_webpage, false);
                } else if (11 == c34894d.field_type) {
                    ShakeItemListUI.this.fGv.mo43765a(c34894d.getProvince(), c3838a.gvq);
                } else {
                    C40460b.m69434b(c3838a.gvq, c34894d.field_username);
                }
                c3838a.gvq.setVisibility(0);
                if (7 != c34894d.field_type && 10 != c34894d.field_type && 12 != c34894d.field_type && 13 != c34894d.field_type && (8 != c34894d.field_type || !C5046bo.isNullOrNil(c34894d.field_nickname) || !C5046bo.isNullOrNil(c34894d.field_username))) {
                    c3838a.quK.setVisibility(8);
                    c3838a.quJ.setVisibility(0);
                    if (8 == c34894d.field_type && C5046bo.isNullOrNil(c34894d.field_nickname)) {
                        c34894d.field_nickname = c34894d.field_distance;
                        c34894d.field_distance = c34894d.field_username;
                    }
                    c3838a.gtG.setText(C44089j.m79293b(this.context, C5046bo.nullAsNil(c34894d.field_nickname), c3838a.gtG.getTextSize()));
                    c3838a.gtG.setVisibility(0);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingTop = view.getPaddingTop();
                    int paddingRight = view.getPaddingRight();
                    int paddingLeft = view.getPaddingLeft();
                    if (c34894d.field_insertBatch == 2) {
                        view.setBackgroundDrawable(C1338a.m2864g(this.context, C25738R.drawable.f6622k4));
                    } else {
                        view.setBackgroundDrawable(C1338a.m2864g(this.context, C25738R.drawable.f6623k5));
                    }
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    switch (c34894d.field_type) {
                        case 1:
                        case 2:
                        case 3:
                            c3838a.quI.setText(c34894d.field_nickname);
                            c3838a.quI.setVisibility(0);
                            AppMethodBeat.m2505o(24733);
                            break;
                        default:
                            c3838a.quG.setVisibility(0);
                            c3838a.oQz.setText(c34894d.field_distance);
                            c3838a.oQz.setVisibility(0);
                            if (c34894d.field_signature == null || c34894d.field_signature.trim().equals("")) {
                                c3838a.oQA.setVisibility(8);
                            } else {
                                c3838a.oQA.setVisibility(0);
                                c3838a.oQA.setText(C44089j.m79293b(this.context, c34894d.field_signature, c3838a.gtG.getTextSize()));
                            }
                            if (c34894d.field_sex == 1) {
                                c3838a.quH.setVisibility(0);
                                c3838a.quH.setImageDrawable(C1338a.m2864g(this.context, C1318a.ic_sex_male));
                                c3838a.quH.setContentDescription(this.context.getString(C25738R.string.cwa));
                            } else if (c34894d.field_sex == 2) {
                                c3838a.quH.setVisibility(0);
                                c3838a.quH.setImageDrawable(C1338a.m2864g(this.context, C1318a.ic_sex_female));
                                c3838a.quH.setContentDescription(this.context.getString(C25738R.string.bsl));
                            } else {
                                c3838a.quH.setVisibility(8);
                            }
                            C9638aw.m17190ZK();
                            C7616ad aoO = C18628c.m29078XM().aoO(c34894d.field_username);
                            if (aoO == null || !C7486a.m12942jh(aoO.field_type)) {
                                c3838a.gvr.setVisibility(8);
                            } else {
                                c3838a.gvr.setVisibility(0);
                                if (C7616ad.m13547Mn(c34894d.field_reserved1)) {
                                    c3838a.gvr.setText(this.context.getString(C25738R.string.d4p));
                                } else {
                                    c3838a.gvr.setText(this.context.getString(C25738R.string.d4u));
                                }
                            }
                            if (6 == c34894d.field_type) {
                                c3838a.oQz.setText(this.context.getString(C25738R.string.eel));
                                c3838a.gvr.setVisibility(8);
                            }
                            if (c34894d.field_reserved1 != 0) {
                                c3838a.oQB.setVisibility(0);
                                c3838a.oQB.setImageBitmap(C4977b.m7374i(C26417a.flw.mo37872ky(c34894d.field_reserved1), 2.0f));
                                c3838a.quH.setVisibility(8);
                            } else {
                                c3838a.oQB.setVisibility(8);
                            }
                            AppMethodBeat.m2505o(24733);
                            break;
                    }
                }
                if (8 == c34894d.field_type) {
                    c3838a.quK.setText(c34894d.field_distance);
                } else {
                    c3838a.quK.setText(c34894d.field_nickname);
                }
                c3838a.quK.setVisibility(0);
                c3838a.quJ.setVisibility(8);
                AppMethodBeat.m2505o(24733);
            } else {
                c3838a.clear();
                AppMethodBeat.m2505o(24733);
            }
            return view;
        }

        /* renamed from: KD */
        public final void mo6870KD() {
            AppMethodBeat.m2504i(24734);
            bIf();
            mo6869KC();
            AppMethodBeat.m2505o(24734);
        }

        /* renamed from: KC */
        public final void mo6869KC() {
            AppMethodBeat.m2504i(24735);
            if (C9638aw.m17179RK()) {
                switch (this.showType) {
                    case -12:
                        setCursor(C28987m.cjS().mo25300Cs(ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
                        break;
                    case -6:
                        setCursor(C28987m.cjS().cjE());
                        break;
                    case -5:
                        setCursor(C28987m.cjS().cjC());
                        break;
                    case -1:
                        setCursor(C28987m.cjS().cjz());
                        break;
                    case 0:
                        setCursor(C28987m.cjS().cjA());
                        break;
                    case 4:
                        setCursor(C28987m.cjS().cjB());
                        break;
                    case 5:
                        setCursor(C28987m.cjS().cjD());
                        break;
                    case 11:
                        setCursor(C28987m.cjS().cjF());
                        break;
                    case 100:
                        setCursor(C28987m.cjS().cjy());
                        break;
                }
                super.notifyDataSetChanged();
                AppMethodBeat.m2505o(24735);
                return;
            }
            AppMethodBeat.m2505o(24735);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: CB */
        public final void mo62661CB(int i) {
            AppMethodBeat.m2504i(24736);
            this.showType = i;
            mo6870KD();
            AppMethodBeat.m2505o(24736);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ShakeItemListUI() {
        AppMethodBeat.m2504i(24738);
        AppMethodBeat.m2505o(24738);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(24739);
        super.onCreate(bundle);
        initView();
        C28987m.cjS().mo10116c(this.quB);
        this.quB.mo6870KD();
        C4990ab.m7416i("MicroMsg.ShakeItemListUI", "onResume");
        AppMethodBeat.m2505o(24739);
    }

    public final void initView() {
        AppMethodBeat.m2504i(24740);
        this.fGv = new C25815a((Context) this);
        C9638aw.m17190ZK();
        final int a = C5046bo.m7512a((Integer) C18628c.m29072Ry().get(12290, null), 0);
        this.showType = getIntent().getIntExtra("_key_show_type_", 0);
        String stringExtra = getIntent().getStringExtra("_key_title_");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.quA = getIntent().getBooleanExtra("_key_show_from_shake_", false);
        addTextOptionMenu(0, getString(C25738R.string.f9078ou), new C218351());
        this.gxZ = (ListView) findViewById(2131826296);
        this.kmS = getLayoutInflater().inflate(2130970653, null);
        this.kmS.findViewById(2131827479).setOnClickListener(new C218362());
        this.gxZ.addFooterView(this.kmS);
        if (this.showType == -1) {
            this.kmS.findViewById(2131827479).setVisibility(0);
        } else {
            this.kmS.findViewById(2131827479).setVisibility(8);
        }
        this.quB = new C39702a(this);
        this.quB.mo62661CB(this.showType);
        if (this.quB.getCount() <= 0) {
            this.gxZ.setVisibility(8);
            TextView textView = (TextView) findViewById(2131826297);
            textView.setText(ShakeItemListUI.m67842CC(this.showType));
            textView.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.gxZ.setAdapter(this.quB);
            this.gxZ.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.m2504i(24722);
                    C34894d c34894d = (C34894d) ShakeItemListUI.this.quB.getItem(i);
                    if (c34894d == null) {
                        AppMethodBeat.m2505o(24722);
                        return;
                    }
                    C13247e cjS = C28987m.cjS();
                    if (c34894d == null) {
                        C4990ab.m7420w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
                    } else {
                        c34894d.field_insertBatch = 1;
                        c34894d.bJt = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        if (-1 != cjS.bSd.update("shakeitem1", c34894d.mo10098Hl(), "shakeItemID=? and insertBatch=?", new String[]{c34894d.field_shakeItemID, "2"})) {
                            cjS.doNotify();
                        }
                    }
                    int i2 = c34894d.field_type;
                    Intent intent;
                    if (i2 == 4) {
                        intent = new Intent();
                        if (C25847d.aio()) {
                            C37494a.m63280b(C39695i.m67840d(c34894d.field_lvbuffer, 0));
                        } else {
                            C37494a.aic();
                            intent.putExtra("key_mode", 1);
                            intent.putExtra("KGlobalShakeMusic", true);
                            C37494a.m63281c(C39695i.m67840d(c34894d.field_lvbuffer, 0));
                        }
                        intent.putExtra("key_scene", 3);
                        C25985d.m41467b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", intent);
                        AppMethodBeat.m2505o(24722);
                    } else if (i2 == 11) {
                        if (System.currentTimeMillis() - ShakeItemListUI.this.quz > FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                            ShakeItemListUI.this.quz = System.currentTimeMillis();
                            if (c34894d.field_reserved3 == null || c34894d.field_reserved3.split(",").length != 3 || c34894d.field_reserved3.split(",")[0] == null || c34894d.field_reserved3.split(",")[0].equals("")) {
                                intent = new Intent();
                                intent.putExtra("rawUrl", c34894d.getCity());
                                intent.putExtra("scene", 27);
                                intent.putExtra("stastic_scene", 5);
                                C25985d.m41467b(C4996ah.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            } else {
                                String[] split = c34894d.field_reserved3.split(",");
                                C32628se c32628se = new C32628se();
                                c32628se.cOf.userName = split[0];
                                c32628se.cOf.cOh = C5046bo.m7532bc(split[1], "");
                                c32628se.cOf.cOi = Integer.parseInt(split[2]);
                                c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_HEICHA;
                                C4879a.xxA.mo10055m(c32628se);
                            }
                            if (ShakeItemListUI.this.quA) {
                                C34900h.m57313a(c34894d);
                                C34900h.m57316b(c34894d);
                            }
                        }
                        AppMethodBeat.m2505o(24722);
                    } else if (C3826k.m6119Cz(i2)) {
                        C3826k.m6121a(c34894d, ShakeItemListUI.this, true);
                        AppMethodBeat.m2505o(24722);
                    } else {
                        String str = c34894d.field_username;
                        C9638aw.m17190ZK();
                        C7616ad aoO = C18628c.m29078XM().aoO(str);
                        C4990ab.m7410d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + c34894d.field_nickname + " position:" + i + " contactName" + aoO.field_username);
                        C4990ab.m7410d("MicroMsg.ShakeItemListUI", "isContact:" + C7486a.m12942jh(aoO.field_type) + "  contact:" + aoO);
                        if (C7486a.m12942jh(aoO.field_type)) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("Contact_User", str);
                            intent2.putExtra("Contact_Scene", a == c34894d.field_sex ? 23 : 24);
                            intent2.putExtra("Sns_from_Scene", 22);
                            if (str != null && str.length() > 0) {
                                if (aoO.dsf()) {
                                    C7060h.pYm.mo8374X(10298, c34894d.field_username + "," + intent2.getIntExtra("Contact_Scene", 23));
                                    intent2.putExtra("Contact_Scene", 23);
                                }
                                C46193a.gkE.mo38912c(intent2, ShakeItemListUI.this);
                            }
                            AppMethodBeat.m2505o(24722);
                            return;
                        }
                        C4990ab.m7410d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + c34894d.field_nickname + " position:" + i + " contactName" + aoO.field_username);
                        Intent intent3 = new Intent();
                        intent3.putExtra("Contact_User", c34894d.field_username);
                        intent3.putExtra("Contact_Nick", c34894d.field_nickname);
                        intent3.putExtra("Contact_Distance", c34894d.field_distance);
                        intent3.putExtra("Contact_Signature", c34894d.field_signature);
                        intent3.putExtra("Contact_Province", c34894d.getProvince());
                        intent3.putExtra("Contact_City", c34894d.getCity());
                        intent3.putExtra("Contact_Sex", c34894d.field_sex);
                        intent3.putExtra("Contact_IsLBSFriend", true);
                        intent3.putExtra("Contact_VUser_Info", c34894d.field_reserved3);
                        intent3.putExtra("Contact_VUser_Info_Flag", c34894d.field_reserved1);
                        intent3.putExtra("Contact_Scene", a == c34894d.field_sex ? 23 : 24);
                        intent3.putExtra("Sns_from_Scene", 22);
                        intent3.putExtra("Contact_KSnsIFlag", c34894d.field_snsFlag);
                        intent3.putExtra("Contact_KSnsBgUrl", c34894d.field_sns_bgurl);
                        if ((c34894d.field_reserved1 & 8) > 0) {
                            C7060h.pYm.mo8374X(10298, c34894d.field_username + "," + intent3.getIntExtra("Contact_Scene", 23));
                        }
                        C46193a.gkE.mo38912c(intent3, ShakeItemListUI.this);
                        AppMethodBeat.m2505o(24722);
                    }
                }
            });
            final C46696j c46696j = new C46696j(this);
            this.gxZ.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.m2504i(24723);
                    if (i < ShakeItemListUI.this.gxZ.getHeaderViewsCount()) {
                        C4990ab.m7420w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
                        AppMethodBeat.m2505o(24723);
                    } else {
                        c46696j.mo75004a(view, i, j, ShakeItemListUI.this, ShakeItemListUI.this.jKa);
                        AppMethodBeat.m2505o(24723);
                    }
                    return true;
                }
            });
        }
        setBackBtn(new C397005());
        C396976 c396976 = new C396976();
        this.gxZ.setOnTouchListener(new C397017());
        AppMethodBeat.m2505o(24740);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(24741);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.f16181id = ((C34894d) this.quB.getItem(adapterContextMenuInfo.position)).field_shakeItemID;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, C25738R.string.f9088p4);
        AppMethodBeat.m2505o(24741);
    }

    public void onPause() {
        AppMethodBeat.m2504i(24742);
        super.onPause();
        AppMethodBeat.m2505o(24742);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(24743);
        this.quB.bIf();
        C39702a c39702a = this.quB;
        if (c39702a.gvm != null) {
            c39702a.gvm.detach();
            c39702a.gvm = null;
        }
        C28987m.cjS().mo10117d(this.quB);
        C4990ab.m7416i("MicroMsg.ShakeItemListUI", "onPause");
        if (this.fGv != null) {
            this.fGv.detach();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(24743);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: CB */
    public final void mo62656CB(int i) {
        AppMethodBeat.m2504i(24744);
        this.quB.mo62661CB(i);
        switch (i) {
            case -12:
            case -1:
                if (this.kmS != null) {
                    this.kmS.findViewById(2131827479).setVisibility(0);
                    break;
                }
                break;
            case 0:
            case 11:
                if (this.kmS != null) {
                    this.kmS.findViewById(2131827479).setVisibility(8);
                    AppMethodBeat.m2505o(24744);
                    return;
                }
                break;
        }
        AppMethodBeat.m2505o(24744);
    }

    public final int getLayoutId() {
        return 2130970651;
    }

    /* renamed from: CC */
    public static int m67842CC(int i) {
        switch (i) {
            case -12:
            case 11:
                return C25738R.string.eep;
            case -6:
            case 5:
                return C25738R.string.egi;
            case -5:
            case 4:
                return C25738R.string.eff;
            case 100:
                return C25738R.string.eem;
            default:
                return C25738R.string.eei;
        }
    }
}
