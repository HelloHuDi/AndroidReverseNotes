package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p184aj.C37453h.C37454a;
import com.tencent.p177mm.p184aj.C41743i;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.C46874g;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p210ca.C32432a;
import com.tencent.p177mm.p230g.p231a.C32532ct;
import com.tencent.p177mm.p230g.p231a.C32607ok;
import com.tencent.p177mm.p230g.p231a.C9365gt;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.p612ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.p177mm.p612ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.C155533;
import com.tencent.p177mm.p612ui.chatting.C23811q;
import com.tencent.p177mm.p612ui.chatting.C40707a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40705a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40708b;
import com.tencent.p177mm.p612ui.chatting.C44318s.C15712h;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.C44318s.C36202k;
import com.tencent.p177mm.p612ui.chatting.C44318s.C40801c;
import com.tencent.p177mm.p612ui.chatting.C44318s.C44316b;
import com.tencent.p177mm.p612ui.chatting.C44318s.C44319a;
import com.tencent.p177mm.p612ui.chatting.C44318s.C44320d;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5367p;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.C36158x;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40722a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44296aa;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C7335f;
import com.tencent.p177mm.p612ui.chatting.view.AvatarImageView;
import com.tencent.p177mm.p612ui.chatting.viewitems.ChattingItemTranslate.C5370a;
import com.tencent.p177mm.p612ui.p613a.C5216a.C5215a;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p612ui.widget.textview.C46708a.C5673f;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44083l.C4753a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C44083l.C4754b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.cwa;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.c */
public abstract class C5378c {
    private static long yUK = 0;
    private static boolean zbg = false;
    protected boolean kuU;
    public boolean yFW;
    private C5382c zbh;
    private C5673f zbi;
    private C5387d zbj;
    private boolean zbk = false;
    protected C44316b zbl;
    protected C44320d zbm;
    protected C40801c zbn;
    protected C5367p zbo;
    protected C15712h zbp;
    protected C36202k zbq;
    protected C23812e zbr;
    private final long zbs = 120000;

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$a */
    public static class C5379a {
        public TextView enf;
        public View iVh;
        public View jPL;
        public View mRR;
        public CheckBox moo;
        public ProgressBar pyf;
        public TextView qkY;
        public C5378c zbA;
        public AvatarImageView zbv;
        public ViewStub zbw;
        public View zbx;
        public ImageView zby;
        public String zbz;

        public final void setChattingBG(boolean z) {
            AppMethodBeat.m2504i(32786);
            if (this.zbv != null) {
                this.zbv.setChattingBG(z);
            }
            AppMethodBeat.m2505o(32786);
        }

        /* renamed from: eP */
        public final void mo11031eP(View view) {
            AppMethodBeat.m2504i(32787);
            this.mRR = view;
            this.enf = (TextView) view.findViewById(2131820587);
            this.zbv = (AvatarImageView) view.findViewById(2131821101);
            this.zbx = view.findViewById(2131820583);
            this.jPL = view.findViewById(2131822515);
            this.zby = (ImageView) view.findViewById(2131822629);
            this.zbw = (ViewStub) view.findViewById(2131822452);
            AppMethodBeat.m2505o(32787);
        }

        /* renamed from: qy */
        public final void mo11032qy(boolean z) {
            AppMethodBeat.m2504i(32788);
            int i = z ? 0 : 8;
            if (!(this.moo == null || this.moo.getVisibility() == i)) {
                this.moo.setVisibility(i);
            }
            if (!(this.iVh == null || this.iVh.getVisibility() == i)) {
                this.iVh.setVisibility(i);
            }
            AppMethodBeat.m2505o(32788);
        }

        /* renamed from: an */
        public static void m8170an(View view, int i) {
            AppMethodBeat.m2504i(32789);
            if (view != null) {
                LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = (int) (((float) i) / C32432a.dmK());
                view.setLayoutParams(layoutParams);
                view.requestLayout();
            }
            AppMethodBeat.m2505o(32789);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$b */
    static class C5380b implements C37454a {
        C46650a cgL;
        private String uIG;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$b$1 */
        class C53811 implements Runnable {
            C53811() {
            }

            public final void run() {
                AppMethodBeat.m2504i(32790);
                C5380b.this.cgL.aWv();
                AppMethodBeat.m2505o(32790);
            }
        }

        protected C5380b(C46650a c46650a, String str) {
            this.uIG = str;
            this.cgL = c46650a;
        }

        /* renamed from: e */
        public final void mo11035e(LinkedList<cwa> linkedList) {
            int i = 0;
            AppMethodBeat.m2504i(32791);
            C41747z.aeS().mo60365b(this);
            C4990ab.m7410d("MicroMsg.ChattingItem", "onKFSceneEnd.");
            if (linkedList != null && linkedList.size() > 0) {
                C4990ab.m7417i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", Integer.valueOf(linkedList.size()), this.uIG);
                if (this.cgL != null) {
                    if (linkedList != null && linkedList.size() != 0) {
                        for (int i2 = 0; i2 < linkedList.size(); i2++) {
                            cwa cwa = (cwa) linkedList.get(i2);
                            if (!(cwa == null || C5046bo.isNullOrNil(cwa.xrU) || !cwa.xrU.equals(this.uIG))) {
                                C4990ab.m7416i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
                                if (!C5046bo.isNullOrNil(cwa.wCW)) {
                                    C4990ab.m7416i("MicroMsg.ChattingItem", "needCallback: true");
                                    i = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (i != 0) {
                        C5004al.m7441d(new C53811());
                    }
                }
            }
            AppMethodBeat.m2505o(32791);
        }

        public final String aeI() {
            return this.uIG;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$c */
    public class C5382c implements OnLongClickListener {
        private OnDismissListener aaN = new C53833();
        private int jLX;
        private int jLY;
        private OnCreateContextMenuListener pFC;
        private C46650a yJI;
        C24088a yMt;
        private C5384a zbC;
        private View zbD;
        C5673f zbi;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$c$2 */
        class C53772 implements OnTouchListener {
            C53772() {
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.m2504i(32793);
                C5382c.this.jLX = (int) motionEvent.getRawX();
                C5382c.this.jLY = (int) motionEvent.getRawY();
                C5382c.this.zbD = view;
                AppMethodBeat.m2505o(32793);
                return false;
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$c$3 */
        class C53833 implements OnDismissListener {
            C53833() {
            }

            public final void onDismiss() {
                AppMethodBeat.m2504i(138191);
                if (C5382c.this.zbi != null) {
                    C5382c.this.zbi.dismiss();
                }
                AppMethodBeat.m2505o(138191);
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$c$a */
        class C5384a implements C5279d {
            public C7620bi csG;

            C5384a() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(32794);
                if (this.csG == null) {
                    C4990ab.m7412e("MicroMsg.ChattingItem", "context item select failed, null msg");
                    AppMethodBeat.m2505o(32794);
                    return;
                }
                C5378c.this.mo11014a(menuItem, C5382c.this.yJI, this.csG);
                ((C40726v) C5382c.this.yJI.mo74857aF(C40726v.class)).mo64243a(menuItem, C5378c.this);
                if (C5382c.this.zbi != null) {
                    C5382c.this.zbi.dismiss();
                }
                AppMethodBeat.m2505o(32794);
            }
        }

        public C5382c(C46650a c46650a) {
            AppMethodBeat.m2504i(32795);
            this.yJI = c46650a;
            this.pFC = new OnCreateContextMenuListener(C5378c.this) {
                /* JADX WARNING: Removed duplicated region for block: B:40:0x0106  */
                /* JADX WARNING: Removed duplicated region for block: B:43:0x012f  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.m2504i(32792);
                    C40814ay c40814ay = (C40814ay) view.getTag();
                    if (c40814ay == null) {
                        AppMethodBeat.m2505o(32792);
                        return;
                    }
                    int i = c40814ay.position;
                    C7620bi c7620bi = c40814ay.cKd;
                    if (c7620bi == null) {
                        C4990ab.m7412e("MicroMsg.ChattingItem", "msg is null!");
                        AppMethodBeat.m2505o(32792);
                        return;
                    }
                    boolean a = C5378c.this.mo11013a(contextMenu, view, c7620bi);
                    if (C7616ad.aow(C5382c.this.yJI.getTalkerUserName()) || C7616ad.aou(C5382c.this.yJI.getTalkerUserName())) {
                        C4990ab.m7416i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                        contextMenu.removeItem(116);
                    }
                    if (a) {
                        if (C5382c.this.yJI.dFy()) {
                            contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am7));
                        }
                        if ((!C1831bh.m3770o(c7620bi) && C5378c.this.dHn() && C5382c.this.yJI.dFy()) || C5382c.this.yJI.sRl.dsf()) {
                            contextMenu.add(i, 122, 0, C5382c.this.yJI.yTx.getMMResources().getString(C25738R.string.ama));
                        }
                        if (contextMenu.findItem(123) != null) {
                            contextMenu.removeItem(100);
                        }
                        if (!C1831bh.m3770o(c7620bi) && C5378c.this.dHl()) {
                            C5382c.m8176a(C5382c.this, contextMenu, c7620bi, i);
                        }
                        AppMethodBeat.m2505o(32792);
                        return;
                    }
                    if (c7620bi.drE()) {
                        C9638aw.m17190ZK();
                        if (C18628c.isSDCardAvailable()) {
                            ((C44296aa) C5382c.this.yJI.mo74857aF(C44296aa.class)).mo70168a(contextMenu, i, c7620bi);
                            if (c7620bi.field_status == 5) {
                                contextMenu.add(i, 103, 0, C5382c.this.yJI.yTx.getMMResources().getString(C25738R.string.amg));
                                C37478f.m63227c(C32291o.ahl().mo73124w(c7620bi));
                            }
                            if (contextMenu.findItem(123) != null) {
                                contextMenu.removeItem(100);
                            }
                            if (!C1831bh.m3770o(c7620bi) && C5378c.this.dHl()) {
                                C5382c.m8176a(C5382c.this, contextMenu, c7620bi, i);
                            }
                            AppMethodBeat.m2505o(32792);
                        }
                    }
                    if (c7620bi.dts()) {
                        contextMenu.add(i, 100, 0, C5382c.this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                    }
                    if (c7620bi.field_status == 5) {
                    }
                    if (contextMenu.findItem(123) != null) {
                    }
                    C5382c.m8176a(C5382c.this, contextMenu, c7620bi, i);
                    AppMethodBeat.m2505o(32792);
                }
            };
            this.zbC = new C5384a();
            AppMethodBeat.m2505o(32795);
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(32796);
            C4990ab.m7416i("MicroMsg.ChattingItem", "onLongClick");
            if (view.getTag(2131820679) instanceof int[]) {
                int[] iArr = (int[]) view.getTag(2131820679);
                mo11038s(view, iArr[0], iArr[1]);
            } else if (!(this.jLX == 0 && this.jLY == 0) && this.zbD.equals(view)) {
                mo11038s(view, this.jLX, this.jLY);
            } else {
                view.setOnTouchListener(new C53772());
            }
            AppMethodBeat.m2505o(32796);
            return true;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: s */
        public final void mo11038s(View view, int i, int i2) {
            AppMethodBeat.m2504i(32797);
            C40814ay c40814ay = (C40814ay) view.getTag();
            if (c40814ay == null) {
                C4990ab.m7420w("MicroMsg.ChattingItem", "open menu but tag is null");
                AppMethodBeat.m2505o(32797);
                return;
            }
            this.zbC.csG = c40814ay.cKd;
            if (this.yMt != null) {
                this.yMt.dBX();
                this.yMt = null;
            }
            this.yMt = new C24088a(this.yJI.yTx.getContext());
            Object tag = view.getTag(2131820672);
            if (tag != null && ((Boolean) tag).booleanValue()) {
                if (C5215a.yqY.dzj()) {
                    this.yMt.zSb = true;
                    this.yMt.zHM = this.aaN;
                } else {
                    this.yMt.zSb = false;
                    this.yMt.zHM = null;
                }
                this.yMt.zSc = true;
            }
            if ((c40814ay instanceof C5370a) && 2 == ((C5370a) c40814ay).klY && this.zbi != null) {
                this.zbi.dismiss();
            }
            this.yMt.mo39886a(view, this.pFC, this.zbC, i, i2);
            AppMethodBeat.m2505o(32797);
        }

        /* renamed from: a */
        static /* synthetic */ void m8176a(C5382c c5382c, ContextMenu contextMenu, C7620bi c7620bi, int i) {
            AppMethodBeat.m2504i(32798);
            if (!(C7616ad.aox(c5382c.yJI.getTalkerUserName()) || C7616ad.m13549mg(c5382c.yJI.getTalkerUserName()) || !(contextMenu instanceof C44273l) || c7620bi.getType() == 318767153)) {
                Object obj;
                if (c7620bi.getType() == 49) {
                    C8910b X = C8910b.m16058X(c7620bi.field_content, c7620bi.field_reserved);
                    if (X == null || X.type == 6 || X.type == 38 || X.type == 39) {
                        AppMethodBeat.m2505o(32798);
                        return;
                    }
                }
                if (contextMenu.findItem(116) != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                C44273l c44273l = (C44273l) contextMenu;
                LinkedList linkedList = new LinkedList();
                List<MenuItem> list = c44273l.yvT;
                for (MenuItem menuItem : list) {
                    C44274m c44274m;
                    if (menuItem.getItemId() == 116) {
                        c44274m = new C44274m(c5382c.yJI.yTx.getContext(), C19392d.CTRL_INDEX, i);
                        c44274m.setTitle(c5382c.yJI.yTx.getMMResources().getString(C25738R.string.amr));
                        linkedList.add(menuItem);
                        linkedList.add(c44274m);
                    } else if (obj == null && menuItem.getItemId() == 100) {
                        c44274m = new C44274m(c5382c.yJI.yTx.getContext(), C19392d.CTRL_INDEX, i);
                        c44274m.setTitle(c5382c.yJI.yTx.getMMResources().getString(C25738R.string.amr));
                        linkedList.add(c44274m);
                        linkedList.add(menuItem);
                    } else {
                        linkedList.add(menuItem);
                    }
                }
                list.clear();
                list.addAll(linkedList);
                linkedList.clear();
            }
            AppMethodBeat.m2505o(32798);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$e */
    static class C5385e extends C5673f {
        C5382c zbh;

        C5385e(C5382c c5382c) {
            this.zbh = c5382c;
        }

        /* renamed from: eQ */
        public final void mo11041eQ(View view) {
            AppMethodBeat.m2504i(32800);
            this.zbh.mo11038s(view, 0, 0);
            AppMethodBeat.m2505o(32800);
        }

        public final void dismiss() {
            AppMethodBeat.m2504i(32801);
            C5382c c5382c = this.zbh;
            if (c5382c.yMt != null && c5382c.yMt.dBX()) {
                c5382c.yMt = null;
            }
            AppMethodBeat.m2505o(32801);
        }

        /* renamed from: eR */
        public final void mo11042eR(View view) {
            AppMethodBeat.m2504i(32802);
            this.zbh.onLongClick(view);
            AppMethodBeat.m2505o(32802);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$d */
    public static class C5387d extends C23812e {
        private C5378c zbA;

        public C5387d(C46650a c46650a, C5378c c5378c) {
            super(c46650a);
            this.zbA = c5378c;
        }

        /* renamed from: a */
        public void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32799);
            view.getTag();
            this.zbA.mo11019b(view, c46650a, c7620bi);
            AppMethodBeat.m2505o(32799);
        }
    }

    /* renamed from: a */
    public abstract View mo11005a(LayoutInflater layoutInflater, View view);

    /* renamed from: a */
    public abstract void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str);

    /* renamed from: a */
    public abstract boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi);

    /* renamed from: a */
    public abstract boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi);

    /* renamed from: aH */
    public abstract boolean mo11016aH(int i, boolean z);

    /* renamed from: b */
    public abstract boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi);

    public abstract boolean dHk();

    /* renamed from: v */
    public static void m8146v(ImageView imageView, String str) {
        if (C5046bo.isNullOrNil(str)) {
            imageView.setImageResource(C25738R.drawable.ad2);
        } else {
            C40460b.m69434b(imageView, str);
        }
    }

    /* renamed from: hU */
    public static int m8144hU(Context context) {
        float dm = C1338a.m2860dm(context);
        if (dm == 0.875f) {
            return C1338a.m2857am(context, C25738R.dimen.f10299x8);
        }
        if (dm == 1.125f) {
            return C1338a.m2857am(context, C25738R.dimen.f10293x1);
        }
        if (dm == 1.25f) {
            return C1338a.m2857am(context, C25738R.dimen.f10300x9);
        }
        if (dm == 1.375f) {
            return C1338a.m2857am(context, C25738R.dimen.f10283wr);
        }
        if (dm == 1.625f || dm == 1.875f || dm == 2.025f) {
            return C1338a.m2857am(context, C25738R.dimen.f10284ws);
        }
        return C1338a.m2857am(context, C25738R.dimen.f10298x7);
    }

    /* renamed from: hV */
    public static int m8145hV(Context context) {
        float dm = C1338a.m2860dm(context);
        if (!(dm == 0.875f || dm == 1.125f)) {
            if (dm == 1.25f) {
                return C1338a.m2857am(context, C25738R.dimen.f10282wq);
            }
            if (dm == 1.375f) {
                return C1338a.m2857am(context, C25738R.dimen.f10280wo);
            }
            if (dm == 1.625f || dm == 1.875f || dm == 2.025f) {
                return C1338a.m2857am(context, C25738R.dimen.f10284ws);
            }
        }
        return C1338a.m2857am(context, C25738R.dimen.f10281wp);
    }

    /* renamed from: w */
    public static void m8147w(ImageView imageView, String str) {
        if (C5046bo.isNullOrNil(str)) {
            imageView.setImageResource(C25738R.drawable.abh);
        } else {
            C40460b.m69437r(imageView, str);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean dHj() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo11011a(C5379a c5379a, C46650a c46650a, C7620bi c7620bi, String str) {
        if (str != null && c5379a.qkY != null && c7620bi != null) {
            CharSequence charSequence;
            if (c7620bi.field_isSend == 0 && !C5046bo.isNullOrNil(c7620bi.dJD)) {
                C46874g rg = C41747z.aeQ().mo67510rg(c7620bi.dJD);
                Object obj = 1;
                if (rg == null || C5046bo.isNullOrNil(rg.field_openId) || C5046bo.isNullOrNil(rg.field_nickname)) {
                    C4990ab.m7416i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
                    charSequence = null;
                } else {
                    charSequence = rg.field_nickname;
                    obj = null;
                }
                if (obj != null || C41743i.m73577a(rg)) {
                    C41747z.aeS().mo60362a(new C5380b(c46650a, c7620bi.dJD));
                    C41747z.aeS().mo60364ay(c46650a.getTalkerUserName(), c7620bi.dJD);
                }
            } else if (!mo11020b(c46650a) || !((C7335f) c46650a.mo74857aF(C7335f.class)).dDE()) {
                charSequence = null;
            } else if (((C36135d) c46650a.mo74857aF(C36135d.class)).dDn()) {
                charSequence = C44089j.m79293b(c46650a.yTx.getContext(), ((C7335f) c46650a.mo74857aF(C7335f.class)).arj(c7620bi.field_bizChatUserId), c5379a.qkY.getTextSize());
            } else {
                charSequence = C44089j.m79293b(c46650a.yTx.getContext(), ((C7335f) c46650a.mo74857aF(C7335f.class)).arj(str), c5379a.qkY.getTextSize());
            }
            C5378c.m8134a(c5379a, charSequence);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean dHl() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public boolean mo11020b(C46650a c46650a) {
        if (dHk()) {
            return false;
        }
        return c46650a.dFx() || ((C36135d) c46650a.mo74857aF(C36135d.class)).dDm();
    }

    /* JADX WARNING: Missing block: B:11:0x0029, code skipped:
            if (r0.length() > 0) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public String mo11017b(C46650a c46650a, C7620bi c7620bi) {
        if (dHk()) {
            return c46650a.dFu();
        }
        String talkerUserName = c46650a.getTalkerUserName();
        if (!mo11020b(c46650a)) {
            return talkerUserName;
        }
        String oy;
        if (c46650a.dFx()) {
            oy = C1829bf.m3762oy(c7620bi.field_content);
            if (talkerUserName != null) {
                if (oy != null) {
                }
            }
            oy = talkerUserName;
        } else {
            if (c7620bi != null) {
                oy = c7620bi.field_bizChatUserId;
            }
            oy = talkerUserName;
        }
        return oy;
    }

    /* renamed from: a */
    public static String m8122a(C7620bi c7620bi, boolean z, boolean z2) {
        String str = null;
        if (c7620bi == null) {
            return null;
        }
        if (c7620bi.field_isSend == 1) {
            return C1853r.m3846Yz();
        }
        if (z) {
            str = C1829bf.m3762oy(c7620bi.field_content);
        } else if (z2) {
            str = c7620bi.field_bizChatUserId;
        }
        if (C5046bo.isNullOrNil(str)) {
            return c7620bi.field_talker;
        }
        return str;
    }

    /* renamed from: a */
    protected static void m8134a(C5379a c5379a, CharSequence charSequence) {
        if (c5379a != null && c5379a.qkY != null) {
            if (charSequence == null) {
                c5379a.qkY.setVisibility(8);
                return;
            }
            c5379a.qkY.setText(charSequence);
            c5379a.qkY.setVisibility(0);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: c */
    public final C5382c mo11021c(C46650a c46650a) {
        if (this.zbh == null) {
            this.zbh = new C5382c(c46650a);
        }
        return this.zbh;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C5673f mo11006a(C5382c c5382c) {
        if (this.zbi == null) {
            this.zbi = new C5385e(c5382c);
        }
        return this.zbi;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final C5387d mo11022d(C46650a c46650a) {
        if (this.zbj == null) {
            if (c46650a.yTx instanceof AppBrandServiceChattingFmUI) {
                AppBrandServiceChattingFmUI appBrandServiceChattingFmUI = (AppBrandServiceChattingFmUI) c46650a.yTx;
                this.zbj = new C155533(appBrandServiceChattingFmUI.cgL, this);
            } else {
                this.zbj = new C5387d(c46650a, this);
            }
        }
        return this.zbj;
    }

    /* renamed from: a */
    private void m8133a(C5379a c5379a, C46650a c46650a, C7620bi c7620bi) {
        if (!this.zbk) {
            this.zbk = true;
            if (!(c46650a.yTx instanceof AppBrandServiceChattingFmUI)) {
                if (c7620bi == null || C5046bo.isNullOrNil(c7620bi.dJD)) {
                    this.zbl = new C44316b(c46650a);
                    this.zbm = new C44320d(c46650a);
                } else {
                    this.zbl = new C44319a(c46650a);
                }
                c5379a.zbv.setOnClickListener(this.zbl);
                c5379a.zbv.setOnLongClickListener(this.zbm);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final C44316b mo11027e(C46650a c46650a) {
        if (this.zbl == null) {
            this.zbl = new C44316b(c46650a);
        }
        return this.zbl;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: f */
    public final C44320d mo11028f(C46650a c46650a) {
        if (this.zbm == null) {
            this.zbm = new C44320d(c46650a);
        }
        return this.zbm;
    }

    /* renamed from: g */
    private C40801c m8143g(C46650a c46650a) {
        if (this.zbn == null) {
            this.zbn = new C40801c(c46650a);
        }
        return this.zbn;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: h */
    public final C5367p mo11029h(C46650a c46650a) {
        if (this.zbo == null) {
            this.zbo = new C5367p(c46650a);
        }
        return this.zbo;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: i */
    public final C36202k mo11030i(C46650a c46650a) {
        if (this.zbq == null) {
            this.zbq = new C36202k(c46650a);
        }
        return this.zbq;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo11012a(C5379a c5379a, C46650a c46650a, String str, C7620bi c7620bi) {
        String str2 = null;
        if (c5379a.zbv != null) {
            if (!C1855t.m3923nI(str) || str.equals(C1855t.fkY[0])) {
                Object obj;
                C40814ay c40814ay;
                C40814ay obj2;
                if (c7620bi != null && !C5046bo.isNullOrNil(c7620bi.dJD)) {
                    String talkerUserName;
                    if (c46650a.dFx()) {
                        talkerUserName = c46650a.getTalkerUserName();
                    } else {
                        talkerUserName = null;
                    }
                    c40814ay = new C40814ay(str, talkerUserName);
                    c40814ay.ziw = c7620bi.dJD;
                    C40460b.m69436f(c5379a.zbv, c7620bi.dJD, C25738R.drawable.abc);
                    obj2 = c40814ay;
                } else if (c7620bi != null && ((C36135d) c46650a.mo74857aF(C36135d.class)).dDm()) {
                    c40814ay = new C40814ay(c7620bi.field_bizChatUserId, null);
                    C32291o.ahp().mo43766a(((C36135d) c46650a.mo74857aF(C36135d.class)).mo57024ru(c7620bi.field_bizChatUserId), c5379a.zbv, ((C15612h) c46650a.mo74857aF(C15612h.class)).dDe());
                    obj2 = c40814ay;
                } else if (c7620bi == null || c7620bi.field_isSend != 0 || c46650a.mo74857aF(C40722a.class) == null || C5046bo.isNullOrNil(((C40722a) c46650a.mo74857aF(C40722a.class)).dFr())) {
                    if (c46650a.dFx()) {
                        str2 = c46650a.getTalkerUserName();
                    }
                    obj2 = new C40814ay(str, str2);
                    C5378c.m8146v(c5379a.zbv, str);
                } else {
                    c40814ay = new C40814ay(str, null);
                    C32291o.ahp().mo43766a(((C40722a) c46650a.mo74857aF(C40722a.class)).dFr(), c5379a.zbv, ((C15612h) c46650a.mo74857aF(C15612h.class)).dDe());
                    obj2 = c40814ay;
                }
                c5379a.zbv.setVisibility(0);
                c5379a.zbv.setTag(obj2);
                m8133a(c5379a, c46650a, c7620bi);
                if (!dHk()) {
                    ((C36158x) c46650a.mo74857aF(C36158x.class)).mo57049a(c5379a.zbv);
                    c5379a.zbv.setOnDoubleClickListener(m8143g(c46650a));
                }
                C23811q.m36642eJ(c5379a.zbv);
                c5379a.zbv.setContentDescription(C1854s.m3866mJ(str) + c46650a.yTx.getContext().getString(C25738R.string.f9342x9));
                c5379a.zbv.mo70201dk(str, 5);
                if (c5379a.zbw == null) {
                    return;
                }
                if (c7620bi == null || c7620bi.dqJ == null || !c7620bi.dqJ.contains("watch_msg_source_type")) {
                    c5379a.zbw.setVisibility(8);
                    return;
                }
                int intValue;
                try {
                    intValue = Integer.valueOf((String) C5049br.m7595z(c7620bi.dqJ, "msgsource").get(".msgsource.watch_msg_source_type")).intValue();
                } catch (Exception e) {
                    intValue = 0;
                }
                if (intValue <= 0 || intValue > 4) {
                    c5379a.zbw.setVisibility(8);
                    return;
                } else {
                    c5379a.zbw.setVisibility(0);
                    return;
                }
            }
            c5379a.zbv.setVisibility(8);
        }
    }

    /* renamed from: a */
    protected static void m8126a(C46650a c46650a, View view, String str) {
        if (C46494g.aiF(str)) {
            Object c4754b = new C4754b();
            c4754b.appId = str;
            c4754b.cKf = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
            C5378c.m8125a(c46650a, view, c4754b);
            return;
        }
        view.setTag(new C4754b());
    }

    /* renamed from: a */
    protected static void m8124a(C46650a c46650a, View view, C7620bi c7620bi, C8910b c8910b, String str, long j) {
        if (C46494g.aiF(c8910b.appId)) {
            int i = c46650a.dFx() ? 2 : 1;
            Object c4753a = new C4753a();
            c4753a.appId = c8910b.appId;
            c4753a.cKf = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
            c4753a.ceO = str;
            c4753a.cKE = C5378c.m8141d(c46650a, c7620bi);
            c4753a.voz = c8910b.type;
            c4753a.scene = i;
            c4753a.voA = c8910b.mediaTagName;
            c4753a.cKK = j;
            c4753a.voB = c46650a.getTalkerUserName();
            C5378c.m8125a(c46650a, view, c4753a);
            return;
        }
        view.setTag(new C4754b());
    }

    /* renamed from: a */
    private static void m8125a(C46650a c46650a, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dDb());
    }

    /* renamed from: a */
    protected static void m8128a(C46650a c46650a, ImageView imageView, String str) {
        Bitmap b = C46494g.m87732b(str, 2, C1338a.getDensity(c46650a.yTx.getContext()));
        if (b == null || b.isRecycled()) {
            C5378c.m8127a(c46650a, imageView, BitmapFactory.decodeResource(c46650a.yTx.getMMResources(), C25738R.drawable.akc));
        } else {
            C5378c.m8127a(c46650a, imageView, b);
        }
    }

    /* renamed from: a */
    private static void m8127a(C46650a c46650a, ImageView imageView, Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) c46650a.yTx.getMMResources().getDimension(C25738R.dimen.f10018nk);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        imageView.setImageDrawable(bitmapDrawable);
    }

    /* renamed from: a */
    protected static void m8130a(C46650a c46650a, TextView textView, String str) {
        Bitmap b = C46494g.m87732b(str, 2, C1338a.getDensity(c46650a.yTx.getContext()));
        if (b == null || b.isRecycled()) {
            C5378c.m8129a(c46650a, textView, BitmapFactory.decodeResource(c46650a.yTx.getMMResources(), C25738R.drawable.akc));
        } else {
            C5378c.m8129a(c46650a, textView, b);
        }
    }

    /* renamed from: a */
    private static void m8129a(C46650a c46650a, TextView textView, Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) c46650a.yTx.getMMResources().getDimension(C25738R.dimen.f10018nk);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo11018b(C46650a c46650a, View view, Object obj) {
        view.setTag(obj);
        if (this.zbp == null) {
            this.zbp = new C15712h(c46650a);
        }
        view.setOnClickListener(this.zbp);
    }

    /* renamed from: c */
    protected static void m8140c(C46650a c46650a, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dDc());
    }

    /* renamed from: a */
    public final boolean mo11015a(C46650a c46650a, C8910b c8910b, C7620bi c7620bi) {
        if (C5046bo.isNullOrNil(c8910b.fiG)) {
            return false;
        }
        C40707a.m70379a(C40705a.EnterCompleteVideo, c7620bi, c8910b.fiN, c8910b.fiM);
        String str = c7620bi.field_imgPath;
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", c8910b.fiG);
        intent.putExtra("KThumUrl", c8910b.fiL);
        intent.putExtra("KThumbPath", str);
        intent.putExtra("KSta_StremVideoAduxInfo", c8910b.fiM);
        intent.putExtra("KSta_StremVideoPublishId", c8910b.fiN);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", c46650a.dFx() ? C40708b.TalkChat.value : C40708b.Chat.value);
        intent.putExtra("KSta_FromUserName", mo11017b(c46650a, c7620bi));
        intent.putExtra("KSta_ChatName", c46650a.getTalkerUserName());
        intent.putExtra("KSta_MsgId", c7620bi.field_msgSvrId);
        intent.putExtra("KSta_SnsStatExtStr", c8910b.cMn);
        if (c46650a.dFx()) {
            intent.putExtra("KSta_ChatroomMembercount", C37921n.m64060mA(c46650a.getTalkerUserName()));
        }
        intent.putExtra("KMediaId", "fakeid_" + c7620bi.field_msgId);
        intent.putExtra("KMediaVideoTime", c8910b.fiH);
        intent.putExtra("StremWebUrl", c8910b.fiK);
        intent.putExtra("StreamWording", c8910b.fiJ);
        intent.putExtra("KMediaTitle", c8910b.title);
        C25985d.m41467b(c46650a.yTx.getContext(), "sns", ".ui.VideoAdPlayerUI", intent);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo11008a(C46650a c46650a, String str, String str2, String str3, int i, String str4, boolean z, long j, long j2, C7620bi c7620bi) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            C4990ab.m7412e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
            return;
        }
        if (C5023at.isMobile(c46650a.yTx.getContext()) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", z);
        intent.putExtra("geta8key_username", c46650a.getTalkerUserName());
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        intent.putExtra("pre_username", mo11017b(c46650a, c7620bi));
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (c7620bi != null) {
            intent.putExtra("preUsername", mo11017b(c46650a, c7620bi));
        }
        intent.putExtra("preChatName", c46650a.getTalkerUserName());
        intent.putExtra("preChatTYPE", C32798u.m53583ad(mo11017b(c46650a, c7620bi), c46650a.getTalkerUserName()));
        intent.putExtra("preMsgIndex", 0);
        C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    /* renamed from: dg */
    protected static boolean m8142dg(String str) {
        return C46494g.m87743dg(str);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            C40439f bT = C46494g.m87739bT(str, true);
            if (bT == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bT.field_packageName;
            }
        }
        if (str22 == null) {
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str22, 0);
        } catch (NameNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.ChattingItem", e, "", new Object[0]);
            return packageInfo;
        }
    }

    /* renamed from: a */
    public static void m8131a(C46650a c46650a, C8910b c8910b, String str, C40439f c40439f, long j, int i, String str2) {
        int i2 = c46650a.dFx() ? 2 : 1;
        if (i == -1) {
            if (c8910b.type != 7) {
                i = 3;
            } else if (c40439f == null || !C35799p.m58695u(c46650a.yTx.getContext(), c40439f.field_packageName)) {
                i = 6;
            } else {
                i = 0;
            }
        }
        if (c8910b.type == 2) {
            i = 4;
        } else if (c8910b.type == 5) {
            i = 1;
        }
        C32607ok c32607ok = new C32607ok();
        c32607ok.cKI.context = c46650a.yTx.getContext();
        c32607ok.cKI.scene = i2;
        c32607ok.cKI.csB = c8910b.appId;
        c32607ok.cKI.packageName = c40439f == null ? null : c40439f.field_packageName;
        c32607ok.cKI.msgType = c8910b.type;
        c32607ok.cKI.cEV = str;
        c32607ok.cKI.cKJ = i;
        c32607ok.cKI.mediaTagName = c8910b.mediaTagName;
        c32607ok.cKI.cKK = j;
        c32607ok.cKI.cKL = "";
        c32607ok.cKI.cst = str2;
        C4879a.xxA.mo10055m(c32607ok);
    }

    /* renamed from: a */
    public static void m8132a(C46650a c46650a, C8910b c8910b, String str, C40439f c40439f, long j, String str2) {
        C5378c.m8131a(c46650a, c8910b, str, c40439f, j, -1, str2);
    }

    /* renamed from: b */
    protected static void m8138b(C46650a c46650a, C8910b c8910b, C7620bi c7620bi) {
        C43155a bDb = C20928a.bDb();
        if (bDb != null) {
            int i = c46650a.dFx() ? 2 : 1;
            String d = C5378c.m8141d(c46650a, c7620bi);
            c46650a.yTx.getContext();
            bDb.mo36276a(c8910b.appId, d, c8910b.type, i, c8910b.mediaTagName, c7620bi.field_msgSvrId, c46650a.getTalkerUserName());
        }
    }

    /* renamed from: a */
    protected static boolean m8137a(C46650a c46650a, C40439f c40439f) {
        C43155a bDb = C20928a.bDb();
        if (C46494g.m87726a(c46650a.yTx.getContext(), c40439f) || bDb == null) {
            return false;
        }
        if (!C5046bo.isNullOrNil(c40439f.dng)) {
            C4990ab.m7417i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", c40439f.dng, Boolean.valueOf(C35800q.m58699by(c46650a.yTx.getContext(), c40439f.dng)));
            if (C35800q.m58699by(c46650a.yTx.getContext(), c40439f.dng)) {
                return true;
            }
        }
        int i = c46650a.dFx() ? 2 : 1;
        C9365gt c9365gt = new C9365gt();
        c9365gt.cBv.actionCode = 2;
        c9365gt.cBv.scene = i;
        c9365gt.cBv.appId = c40439f.field_appId;
        c9365gt.cBv.context = c46650a.yTx.getContext();
        C4879a.xxA.mo10055m(c9365gt);
        c46650a.yTx.getContext();
        bDb.mo36272W(c40439f.field_appId, i, i);
        return true;
    }

    /* renamed from: d */
    public static String m8141d(C46650a c46650a, C7620bi c7620bi) {
        String talkerUserName = c46650a.getTalkerUserName();
        if (C1855t.m3896kH(talkerUserName)) {
            return C1829bf.m3762oy(c7620bi.field_content);
        }
        return talkerUserName;
    }

    /* renamed from: a */
    public static void m8123a(C7620bi c7620bi, EmojiInfo emojiInfo) {
        String str;
        C32532ct c32532ct = new C32532ct();
        c32532ct.cvU.cvV = emojiInfo;
        EmojiInfo emojiInfo2 = c32532ct.cvU.cvV;
        if (c7620bi != null) {
            str = c7620bi.field_talker;
        } else {
            str = null;
        }
        emojiInfo2.talker = str;
        c32532ct.cvU.scene = 0;
        C4879a.xxA.mo10055m(c32532ct);
    }

    /* renamed from: a */
    protected static boolean m8135a(C7620bi c7620bi, C46650a c46650a) {
        int i;
        if (C1839cb.aaE() - c7620bi.field_createTime > 120000) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            return false;
        }
        if (c46650a != null && c46650a.getTalkerUserName().equals(c46650a.dFu()) && c7620bi.field_status == 2) {
            return false;
        }
        C4990ab.m7411d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", Integer.valueOf(C26373g.m41964Nu().getInt("ShowRevokeMsgEntry", 1)));
        if (1 == C26373g.m41964Nu().getInt("ShowRevokeMsgEntry", 1)) {
            return true;
        }
        return false;
    }

    protected static boolean arB(String str) {
        return !(C1855t.m3943nl(str) || C1855t.m3916nB(str) || C1855t.m3913mZ(str) || C1855t.m3924nJ(str)) || C1855t.m3896kH(str);
    }

    protected static boolean dHm() {
        String value = C26373g.m41964Nu().getValue("ShowSendOK");
        if (1 == (C5046bo.isNullOrNil(value) ? 0 : C5046bo.ank(value))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    protected static boolean m8136a(C15612h c15612h, long j) {
        return j > 0 && c15612h.dDd() == j;
    }

    /* Access modifiers changed, original: protected */
    public boolean dHn() {
        return true;
    }

    /* renamed from: a */
    public final void mo11009a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi) {
        long j = yUK + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        yUK = currentTimeMillis;
        if (j < currentTimeMillis) {
            C9638aw.m17190ZK();
            zbg = C18628c.isSDCardAvailable();
        }
        this.kuU = zbg;
        String str = null;
        if (dHj()) {
            str = mo11017b(c46650a, c7620bi);
            mo11011a(c5379a, c46650a, c7620bi, str);
            mo11012a(c5379a, c46650a, str, c7620bi);
        }
        mo11010a(c5379a, i, c46650a, c7620bi, str);
    }

    /* renamed from: c */
    protected static String m8139c(C46650a c46650a, C7620bi c7620bi) {
        String str = c7620bi.field_talker;
        C36135d c36135d = (C36135d) c46650a.mo74857aF(C36135d.class);
        if (!c36135d.dDm() || c36135d.dDk() == null) {
            return str;
        }
        return c36135d.dDk().field_bizChatServId;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo11007a(int i, C5379a c5379a, C7620bi c7620bi, String str, boolean z, C46650a c46650a, final C5365n c5365n) {
        if (c7620bi.field_isSend == 1) {
            int i2;
            c5379a.zby.setTag(new C40814ay(c7620bi, z, i, str, 0));
            ImageView imageView = c5379a.zby;
            if (this.zbr == null) {
                this.zbr = new C23812e(c46650a) {
                    /* renamed from: a */
                    public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
                        AppMethodBeat.m2504i(32785);
                        c5365n.mo10991a(c46650a, c7620bi);
                        AppMethodBeat.m2505o(32785);
                    }
                };
            }
            imageView.setOnClickListener(this.zbr);
            switch (c7620bi.field_status) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = -1;
                    break;
                case 5:
                    i2 = C25738R.drawable.a1w;
                    break;
                default:
                    C4990ab.m7412e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
                    i2 = -1;
                    break;
            }
            if (i2 != -1) {
                c5379a.zby.setImageResource(C25738R.drawable.a1w);
                c5379a.zby.setVisibility(0);
                c5379a.zby.setContentDescription(C4996ah.getContext().getString(C25738R.string.d1l));
                if (c5379a.pyf != null) {
                    c5379a.pyf.setVisibility(8);
                    return;
                }
                return;
            }
            c5379a.zby.setVisibility(8);
        }
    }
}
