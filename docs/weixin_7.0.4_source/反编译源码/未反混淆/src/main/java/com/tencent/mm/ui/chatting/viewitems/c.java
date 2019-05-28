package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.aj.g;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.AnonymousClass3;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.c.x;
import com.tencent.mm.ui.chatting.q;
import com.tencent.mm.ui.chatting.s.h;
import com.tencent.mm.ui.chatting.s.k;
import com.tencent.mm.ui.chatting.s.p;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.widget.textview.a.f;
import java.util.LinkedList;
import java.util.List;

public abstract class c {
    private static long yUK = 0;
    private static boolean zbg = false;
    protected boolean kuU;
    public boolean yFW;
    private c zbh;
    private f zbi;
    private d zbj;
    private boolean zbk = false;
    protected com.tencent.mm.ui.chatting.s.b zbl;
    protected com.tencent.mm.ui.chatting.s.d zbm;
    protected com.tencent.mm.ui.chatting.s.c zbn;
    protected p zbo;
    protected h zbp;
    protected k zbq;
    protected com.tencent.mm.ui.chatting.s.e zbr;
    private final long zbs = 120000;

    public static class a {
        public TextView enf;
        public View iVh;
        public View jPL;
        public View mRR;
        public CheckBox moo;
        public ProgressBar pyf;
        public TextView qkY;
        public c zbA;
        public AvatarImageView zbv;
        public ViewStub zbw;
        public View zbx;
        public ImageView zby;
        public String zbz;

        public final void setChattingBG(boolean z) {
            AppMethodBeat.i(32786);
            if (this.zbv != null) {
                this.zbv.setChattingBG(z);
            }
            AppMethodBeat.o(32786);
        }

        public final void eP(View view) {
            AppMethodBeat.i(32787);
            this.mRR = view;
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zbv = (AvatarImageView) view.findViewById(R.id.oc);
            this.zbx = view.findViewById(R.id.ac);
            this.jPL = view.findViewById(R.id.ap9);
            this.zby = (ImageView) view.findViewById(R.id.asb);
            this.zbw = (ViewStub) view.findViewById(R.id.anj);
            AppMethodBeat.o(32787);
        }

        public final void qy(boolean z) {
            AppMethodBeat.i(32788);
            int i = z ? 0 : 8;
            if (!(this.moo == null || this.moo.getVisibility() == i)) {
                this.moo.setVisibility(i);
            }
            if (!(this.iVh == null || this.iVh.getVisibility() == i)) {
                this.iVh.setVisibility(i);
            }
            AppMethodBeat.o(32788);
        }

        public static void an(View view, int i) {
            AppMethodBeat.i(32789);
            if (view != null) {
                LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = (int) (((float) i) / com.tencent.mm.ca.a.dmK());
                view.setLayoutParams(layoutParams);
                view.requestLayout();
            }
            AppMethodBeat.o(32789);
        }
    }

    static class b implements com.tencent.mm.aj.h.a {
        com.tencent.mm.ui.chatting.d.a cgL;
        private String uIG;

        protected b(com.tencent.mm.ui.chatting.d.a aVar, String str) {
            this.uIG = str;
            this.cgL = aVar;
        }

        public final void e(LinkedList<cwa> linkedList) {
            int i = 0;
            AppMethodBeat.i(32791);
            z.aeS().b(this);
            ab.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
            if (linkedList != null && linkedList.size() > 0) {
                ab.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", Integer.valueOf(linkedList.size()), this.uIG);
                if (this.cgL != null) {
                    if (linkedList != null && linkedList.size() != 0) {
                        for (int i2 = 0; i2 < linkedList.size(); i2++) {
                            cwa cwa = (cwa) linkedList.get(i2);
                            if (!(cwa == null || bo.isNullOrNil(cwa.xrU) || !cwa.xrU.equals(this.uIG))) {
                                ab.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
                                if (!bo.isNullOrNil(cwa.wCW)) {
                                    ab.i("MicroMsg.ChattingItem", "needCallback: true");
                                    i = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (i != 0) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(32790);
                                b.this.cgL.aWv();
                                AppMethodBeat.o(32790);
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(32791);
        }

        public final String aeI() {
            return this.uIG;
        }
    }

    public class c implements OnLongClickListener {
        private OnDismissListener aaN = new OnDismissListener() {
            public final void onDismiss() {
                AppMethodBeat.i(138191);
                if (c.this.zbi != null) {
                    c.this.zbi.dismiss();
                }
                AppMethodBeat.o(138191);
            }
        };
        private int jLX;
        private int jLY;
        private OnCreateContextMenuListener pFC;
        private com.tencent.mm.ui.chatting.d.a yJI;
        com.tencent.mm.ui.widget.b.a yMt;
        private a zbC;
        private View zbD;
        f zbi;

        class a implements com.tencent.mm.ui.base.n.d {
            public bi csG;

            a() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(32794);
                if (this.csG == null) {
                    ab.e("MicroMsg.ChattingItem", "context item select failed, null msg");
                    AppMethodBeat.o(32794);
                    return;
                }
                c.this.a(menuItem, c.this.yJI, this.csG);
                ((v) c.this.yJI.aF(v.class)).a(menuItem, c.this);
                if (c.this.zbi != null) {
                    c.this.zbi.dismiss();
                }
                AppMethodBeat.o(32794);
            }
        }

        public c(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(32795);
            this.yJI = aVar;
            this.pFC = new OnCreateContextMenuListener(c.this) {
                /* JADX WARNING: Removed duplicated region for block: B:40:0x0106  */
                /* JADX WARNING: Removed duplicated region for block: B:43:0x012f  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.i(32792);
                    ay ayVar = (ay) view.getTag();
                    if (ayVar == null) {
                        AppMethodBeat.o(32792);
                        return;
                    }
                    int i = ayVar.position;
                    bi biVar = ayVar.cKd;
                    if (biVar == null) {
                        ab.e("MicroMsg.ChattingItem", "msg is null!");
                        AppMethodBeat.o(32792);
                        return;
                    }
                    boolean a = c.this.a(contextMenu, view, biVar);
                    if (ad.aow(c.this.yJI.getTalkerUserName()) || ad.aou(c.this.yJI.getTalkerUserName())) {
                        ab.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                        contextMenu.removeItem(116);
                    }
                    if (a) {
                        if (c.this.yJI.dFy()) {
                            contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am7));
                        }
                        if ((!bh.o(biVar) && c.this.dHn() && c.this.yJI.dFy()) || c.this.yJI.sRl.dsf()) {
                            contextMenu.add(i, 122, 0, c.this.yJI.yTx.getMMResources().getString(R.string.ama));
                        }
                        if (contextMenu.findItem(123) != null) {
                            contextMenu.removeItem(100);
                        }
                        if (!bh.o(biVar) && c.this.dHl()) {
                            c.a(c.this, contextMenu, biVar, i);
                        }
                        AppMethodBeat.o(32792);
                        return;
                    }
                    if (biVar.drE()) {
                        aw.ZK();
                        if (com.tencent.mm.model.c.isSDCardAvailable()) {
                            ((aa) c.this.yJI.aF(aa.class)).a(contextMenu, i, biVar);
                            if (biVar.field_status == 5) {
                                contextMenu.add(i, 103, 0, c.this.yJI.yTx.getMMResources().getString(R.string.amg));
                                com.tencent.mm.at.f.c(o.ahl().w(biVar));
                            }
                            if (contextMenu.findItem(123) != null) {
                                contextMenu.removeItem(100);
                            }
                            if (!bh.o(biVar) && c.this.dHl()) {
                                c.a(c.this, contextMenu, biVar, i);
                            }
                            AppMethodBeat.o(32792);
                        }
                    }
                    if (biVar.dts()) {
                        contextMenu.add(i, 100, 0, c.this.yJI.yTx.getMMResources().getString(R.string.am7));
                    }
                    if (biVar.field_status == 5) {
                    }
                    if (contextMenu.findItem(123) != null) {
                    }
                    c.a(c.this, contextMenu, biVar, i);
                    AppMethodBeat.o(32792);
                }
            };
            this.zbC = new a();
            AppMethodBeat.o(32795);
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(32796);
            ab.i("MicroMsg.ChattingItem", "onLongClick");
            if (view.getTag(R.id.cy) instanceof int[]) {
                int[] iArr = (int[]) view.getTag(R.id.cy);
                s(view, iArr[0], iArr[1]);
            } else if (!(this.jLX == 0 && this.jLY == 0) && this.zbD.equals(view)) {
                s(view, this.jLX, this.jLY);
            } else {
                view.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(32793);
                        c.this.jLX = (int) motionEvent.getRawX();
                        c.this.jLY = (int) motionEvent.getRawY();
                        c.this.zbD = view;
                        AppMethodBeat.o(32793);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(32796);
            return true;
        }

        /* Access modifiers changed, original: final */
        public final void s(View view, int i, int i2) {
            AppMethodBeat.i(32797);
            ay ayVar = (ay) view.getTag();
            if (ayVar == null) {
                ab.w("MicroMsg.ChattingItem", "open menu but tag is null");
                AppMethodBeat.o(32797);
                return;
            }
            this.zbC.csG = ayVar.cKd;
            if (this.yMt != null) {
                this.yMt.dBX();
                this.yMt = null;
            }
            this.yMt = new com.tencent.mm.ui.widget.b.a(this.yJI.yTx.getContext());
            Object tag = view.getTag(R.id.cr);
            if (tag != null && ((Boolean) tag).booleanValue()) {
                if (com.tencent.mm.ui.a.a.a.yqY.dzj()) {
                    this.yMt.zSb = true;
                    this.yMt.zHM = this.aaN;
                } else {
                    this.yMt.zSb = false;
                    this.yMt.zHM = null;
                }
                this.yMt.zSc = true;
            }
            if ((ayVar instanceof com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a) && 2 == ((com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate.a) ayVar).klY && this.zbi != null) {
                this.zbi.dismiss();
            }
            this.yMt.a(view, this.pFC, this.zbC, i, i2);
            AppMethodBeat.o(32797);
        }

        static /* synthetic */ void a(c cVar, ContextMenu contextMenu, bi biVar, int i) {
            AppMethodBeat.i(32798);
            if (!(ad.aox(cVar.yJI.getTalkerUserName()) || ad.mg(cVar.yJI.getTalkerUserName()) || !(contextMenu instanceof l) || biVar.getType() == 318767153)) {
                Object obj;
                if (biVar.getType() == 49) {
                    com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(biVar.field_content, biVar.field_reserved);
                    if (X == null || X.type == 6 || X.type == 38 || X.type == 39) {
                        AppMethodBeat.o(32798);
                        return;
                    }
                }
                if (contextMenu.findItem(116) != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                l lVar = (l) contextMenu;
                LinkedList linkedList = new LinkedList();
                List<MenuItem> list = lVar.yvT;
                for (MenuItem menuItem : list) {
                    m mVar;
                    if (menuItem.getItemId() == 116) {
                        mVar = new m(cVar.yJI.yTx.getContext(), com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, i);
                        mVar.setTitle(cVar.yJI.yTx.getMMResources().getString(R.string.amr));
                        linkedList.add(menuItem);
                        linkedList.add(mVar);
                    } else if (obj == null && menuItem.getItemId() == 100) {
                        mVar = new m(cVar.yJI.yTx.getContext(), com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX, i);
                        mVar.setTitle(cVar.yJI.yTx.getMMResources().getString(R.string.amr));
                        linkedList.add(mVar);
                        linkedList.add(menuItem);
                    } else {
                        linkedList.add(menuItem);
                    }
                }
                list.clear();
                list.addAll(linkedList);
                linkedList.clear();
            }
            AppMethodBeat.o(32798);
        }
    }

    static class e extends f {
        c zbh;

        e(c cVar) {
            this.zbh = cVar;
        }

        public final void eQ(View view) {
            AppMethodBeat.i(32800);
            this.zbh.s(view, 0, 0);
            AppMethodBeat.o(32800);
        }

        public final void dismiss() {
            AppMethodBeat.i(32801);
            c cVar = this.zbh;
            if (cVar.yMt != null && cVar.yMt.dBX()) {
                cVar.yMt = null;
            }
            AppMethodBeat.o(32801);
        }

        public final void eR(View view) {
            AppMethodBeat.i(32802);
            this.zbh.onLongClick(view);
            AppMethodBeat.o(32802);
        }
    }

    public static class d extends com.tencent.mm.ui.chatting.s.e {
        private c zbA;

        public d(com.tencent.mm.ui.chatting.d.a aVar, c cVar) {
            super(aVar);
            this.zbA = cVar;
        }

        public void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32799);
            view.getTag();
            this.zbA.b(view, aVar, biVar);
            AppMethodBeat.o(32799);
        }
    }

    public abstract View a(LayoutInflater layoutInflater, View view);

    public abstract void a(a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str);

    public abstract boolean a(ContextMenu contextMenu, View view, bi biVar);

    public abstract boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar);

    public abstract boolean aH(int i, boolean z);

    public abstract boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar);

    public abstract boolean dHk();

    public static void v(ImageView imageView, String str) {
        if (bo.isNullOrNil(str)) {
            imageView.setImageResource(R.drawable.ad2);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str);
        }
    }

    public static int hU(Context context) {
        float dm = com.tencent.mm.bz.a.dm(context);
        if (dm == 0.875f) {
            return com.tencent.mm.bz.a.am(context, R.dimen.x8);
        }
        if (dm == 1.125f) {
            return com.tencent.mm.bz.a.am(context, R.dimen.x1);
        }
        if (dm == 1.25f) {
            return com.tencent.mm.bz.a.am(context, R.dimen.x9);
        }
        if (dm == 1.375f) {
            return com.tencent.mm.bz.a.am(context, R.dimen.wr);
        }
        if (dm == 1.625f || dm == 1.875f || dm == 2.025f) {
            return com.tencent.mm.bz.a.am(context, R.dimen.ws);
        }
        return com.tencent.mm.bz.a.am(context, R.dimen.x7);
    }

    public static int hV(Context context) {
        float dm = com.tencent.mm.bz.a.dm(context);
        if (!(dm == 0.875f || dm == 1.125f)) {
            if (dm == 1.25f) {
                return com.tencent.mm.bz.a.am(context, R.dimen.wq);
            }
            if (dm == 1.375f) {
                return com.tencent.mm.bz.a.am(context, R.dimen.wo);
            }
            if (dm == 1.625f || dm == 1.875f || dm == 2.025f) {
                return com.tencent.mm.bz.a.am(context, R.dimen.ws);
            }
        }
        return com.tencent.mm.bz.a.am(context, R.dimen.wp);
    }

    public static void w(ImageView imageView, String str) {
        if (bo.isNullOrNil(str)) {
            imageView.setImageResource(R.drawable.abh);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.r(imageView, str);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean dHj() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void a(a aVar, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
        if (str != null && aVar.qkY != null && biVar != null) {
            CharSequence charSequence;
            if (biVar.field_isSend == 0 && !bo.isNullOrNil(biVar.dJD)) {
                g rg = z.aeQ().rg(biVar.dJD);
                Object obj = 1;
                if (rg == null || bo.isNullOrNil(rg.field_openId) || bo.isNullOrNil(rg.field_nickname)) {
                    ab.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
                    charSequence = null;
                } else {
                    charSequence = rg.field_nickname;
                    obj = null;
                }
                if (obj != null || i.a(rg)) {
                    z.aeS().a(new b(aVar2, biVar.dJD));
                    z.aeS().ay(aVar2.getTalkerUserName(), biVar.dJD);
                }
            } else if (!b(aVar2) || !((com.tencent.mm.ui.chatting.c.b.f) aVar2.aF(com.tencent.mm.ui.chatting.c.b.f.class)).dDE()) {
                charSequence = null;
            } else if (((com.tencent.mm.ui.chatting.c.b.d) aVar2.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDn()) {
                charSequence = j.b(aVar2.yTx.getContext(), ((com.tencent.mm.ui.chatting.c.b.f) aVar2.aF(com.tencent.mm.ui.chatting.c.b.f.class)).arj(biVar.field_bizChatUserId), aVar.qkY.getTextSize());
            } else {
                charSequence = j.b(aVar2.yTx.getContext(), ((com.tencent.mm.ui.chatting.c.b.f) aVar2.aF(com.tencent.mm.ui.chatting.c.b.f.class)).arj(str), aVar.qkY.getTextSize());
            }
            a(aVar, charSequence);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean dHl() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean b(com.tencent.mm.ui.chatting.d.a aVar) {
        if (dHk()) {
            return false;
        }
        return aVar.dFx() || ((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm();
    }

    /* JADX WARNING: Missing block: B:11:0x0029, code skipped:
            if (r0.length() > 0) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public String b(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        if (dHk()) {
            return aVar.dFu();
        }
        String talkerUserName = aVar.getTalkerUserName();
        if (!b(aVar)) {
            return talkerUserName;
        }
        String oy;
        if (aVar.dFx()) {
            oy = bf.oy(biVar.field_content);
            if (talkerUserName != null) {
                if (oy != null) {
                }
            }
            oy = talkerUserName;
        } else {
            if (biVar != null) {
                oy = biVar.field_bizChatUserId;
            }
            oy = talkerUserName;
        }
        return oy;
    }

    public static String a(bi biVar, boolean z, boolean z2) {
        String str = null;
        if (biVar == null) {
            return null;
        }
        if (biVar.field_isSend == 1) {
            return r.Yz();
        }
        if (z) {
            str = bf.oy(biVar.field_content);
        } else if (z2) {
            str = biVar.field_bizChatUserId;
        }
        if (bo.isNullOrNil(str)) {
            return biVar.field_talker;
        }
        return str;
    }

    protected static void a(a aVar, CharSequence charSequence) {
        if (aVar != null && aVar.qkY != null) {
            if (charSequence == null) {
                aVar.qkY.setVisibility(8);
                return;
            }
            aVar.qkY.setText(charSequence);
            aVar.qkY.setVisibility(0);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final c c(com.tencent.mm.ui.chatting.d.a aVar) {
        if (this.zbh == null) {
            this.zbh = new c(aVar);
        }
        return this.zbh;
    }

    /* Access modifiers changed, original: protected|final */
    public final f a(c cVar) {
        if (this.zbi == null) {
            this.zbi = new e(cVar);
        }
        return this.zbi;
    }

    /* Access modifiers changed, original: protected|final */
    public final d d(com.tencent.mm.ui.chatting.d.a aVar) {
        if (this.zbj == null) {
            if (aVar.yTx instanceof AppBrandServiceChattingFmUI) {
                AppBrandServiceChattingFmUI appBrandServiceChattingFmUI = (AppBrandServiceChattingFmUI) aVar.yTx;
                this.zbj = new AnonymousClass3(appBrandServiceChattingFmUI.cgL, this);
            } else {
                this.zbj = new d(aVar, this);
            }
        }
        return this.zbj;
    }

    private void a(a aVar, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar) {
        if (!this.zbk) {
            this.zbk = true;
            if (!(aVar2.yTx instanceof AppBrandServiceChattingFmUI)) {
                if (biVar == null || bo.isNullOrNil(biVar.dJD)) {
                    this.zbl = new com.tencent.mm.ui.chatting.s.b(aVar2);
                    this.zbm = new com.tencent.mm.ui.chatting.s.d(aVar2);
                } else {
                    this.zbl = new com.tencent.mm.ui.chatting.s.a(aVar2);
                }
                aVar.zbv.setOnClickListener(this.zbl);
                aVar.zbv.setOnLongClickListener(this.zbm);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.ui.chatting.s.b e(com.tencent.mm.ui.chatting.d.a aVar) {
        if (this.zbl == null) {
            this.zbl = new com.tencent.mm.ui.chatting.s.b(aVar);
        }
        return this.zbl;
    }

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.ui.chatting.s.d f(com.tencent.mm.ui.chatting.d.a aVar) {
        if (this.zbm == null) {
            this.zbm = new com.tencent.mm.ui.chatting.s.d(aVar);
        }
        return this.zbm;
    }

    private com.tencent.mm.ui.chatting.s.c g(com.tencent.mm.ui.chatting.d.a aVar) {
        if (this.zbn == null) {
            this.zbn = new com.tencent.mm.ui.chatting.s.c(aVar);
        }
        return this.zbn;
    }

    /* Access modifiers changed, original: protected|final */
    public final p h(com.tencent.mm.ui.chatting.d.a aVar) {
        if (this.zbo == null) {
            this.zbo = new p(aVar);
        }
        return this.zbo;
    }

    /* Access modifiers changed, original: protected|final */
    public final k i(com.tencent.mm.ui.chatting.d.a aVar) {
        if (this.zbq == null) {
            this.zbq = new k(aVar);
        }
        return this.zbq;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar, com.tencent.mm.ui.chatting.d.a aVar2, String str, bi biVar) {
        String str2 = null;
        if (aVar.zbv != null) {
            if (!t.nI(str) || str.equals(t.fkY[0])) {
                Object obj;
                ay ayVar;
                ay obj2;
                if (biVar != null && !bo.isNullOrNil(biVar.dJD)) {
                    String talkerUserName;
                    if (aVar2.dFx()) {
                        talkerUserName = aVar2.getTalkerUserName();
                    } else {
                        talkerUserName = null;
                    }
                    ayVar = new ay(str, talkerUserName);
                    ayVar.ziw = biVar.dJD;
                    com.tencent.mm.pluginsdk.ui.a.b.f(aVar.zbv, biVar.dJD, R.drawable.abc);
                    obj2 = ayVar;
                } else if (biVar != null && ((com.tencent.mm.ui.chatting.c.b.d) aVar2.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm()) {
                    ayVar = new ay(biVar.field_bizChatUserId, null);
                    o.ahp().a(((com.tencent.mm.ui.chatting.c.b.d) aVar2.aF(com.tencent.mm.ui.chatting.c.b.d.class)).ru(biVar.field_bizChatUserId), aVar.zbv, ((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dDe());
                    obj2 = ayVar;
                } else if (biVar == null || biVar.field_isSend != 0 || aVar2.aF(com.tencent.mm.ui.chatting.c.b.a.class) == null || bo.isNullOrNil(((com.tencent.mm.ui.chatting.c.b.a) aVar2.aF(com.tencent.mm.ui.chatting.c.b.a.class)).dFr())) {
                    if (aVar2.dFx()) {
                        str2 = aVar2.getTalkerUserName();
                    }
                    obj2 = new ay(str, str2);
                    v(aVar.zbv, str);
                } else {
                    ayVar = new ay(str, null);
                    o.ahp().a(((com.tencent.mm.ui.chatting.c.b.a) aVar2.aF(com.tencent.mm.ui.chatting.c.b.a.class)).dFr(), aVar.zbv, ((com.tencent.mm.ui.chatting.c.b.h) aVar2.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dDe());
                    obj2 = ayVar;
                }
                aVar.zbv.setVisibility(0);
                aVar.zbv.setTag(obj2);
                a(aVar, aVar2, biVar);
                if (!dHk()) {
                    ((x) aVar2.aF(x.class)).a(aVar.zbv);
                    aVar.zbv.setOnDoubleClickListener(g(aVar2));
                }
                q.eJ(aVar.zbv);
                aVar.zbv.setContentDescription(s.mJ(str) + aVar2.yTx.getContext().getString(R.string.x9));
                aVar.zbv.dk(str, 5);
                if (aVar.zbw == null) {
                    return;
                }
                if (biVar == null || biVar.dqJ == null || !biVar.dqJ.contains("watch_msg_source_type")) {
                    aVar.zbw.setVisibility(8);
                    return;
                }
                int intValue;
                try {
                    intValue = Integer.valueOf((String) br.z(biVar.dqJ, "msgsource").get(".msgsource.watch_msg_source_type")).intValue();
                } catch (Exception e) {
                    intValue = 0;
                }
                if (intValue <= 0 || intValue > 4) {
                    aVar.zbw.setVisibility(8);
                    return;
                } else {
                    aVar.zbw.setVisibility(0);
                    return;
                }
            }
            aVar.zbv.setVisibility(8);
        }
    }

    protected static void a(com.tencent.mm.ui.chatting.d.a aVar, View view, String str) {
        if (com.tencent.mm.pluginsdk.model.app.g.aiF(str)) {
            Object bVar = new com.tencent.mm.pluginsdk.ui.chat.l.b();
            bVar.appId = str;
            bVar.cKf = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
            a(aVar, view, bVar);
            return;
        }
        view.setTag(new com.tencent.mm.pluginsdk.ui.chat.l.b());
    }

    protected static void a(com.tencent.mm.ui.chatting.d.a aVar, View view, bi biVar, com.tencent.mm.af.j.b bVar, String str, long j) {
        if (com.tencent.mm.pluginsdk.model.app.g.aiF(bVar.appId)) {
            int i = aVar.dFx() ? 2 : 1;
            Object aVar2 = new com.tencent.mm.pluginsdk.ui.chat.l.a();
            aVar2.appId = bVar.appId;
            aVar2.cKf = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
            aVar2.ceO = str;
            aVar2.cKE = d(aVar, biVar);
            aVar2.voz = bVar.type;
            aVar2.scene = i;
            aVar2.voA = bVar.mediaTagName;
            aVar2.cKK = j;
            aVar2.voB = aVar.getTalkerUserName();
            a(aVar, view, aVar2);
            return;
        }
        view.setTag(new com.tencent.mm.pluginsdk.ui.chat.l.b());
    }

    private static void a(com.tencent.mm.ui.chatting.d.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.h) aVar.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dDb());
    }

    protected static void a(com.tencent.mm.ui.chatting.d.a aVar, ImageView imageView, String str) {
        Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str, 2, com.tencent.mm.bz.a.getDensity(aVar.yTx.getContext()));
        if (b == null || b.isRecycled()) {
            a(aVar, imageView, BitmapFactory.decodeResource(aVar.yTx.getMMResources(), R.drawable.akc));
        } else {
            a(aVar, imageView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.d.a aVar, ImageView imageView, Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.yTx.getMMResources().getDimension(R.dimen.nk);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        imageView.setImageDrawable(bitmapDrawable);
    }

    protected static void a(com.tencent.mm.ui.chatting.d.a aVar, TextView textView, String str) {
        Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str, 2, com.tencent.mm.bz.a.getDensity(aVar.yTx.getContext()));
        if (b == null || b.isRecycled()) {
            a(aVar, textView, BitmapFactory.decodeResource(aVar.yTx.getMMResources(), R.drawable.akc));
        } else {
            a(aVar, textView, b);
        }
    }

    private static void a(com.tencent.mm.ui.chatting.d.a aVar, TextView textView, Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) aVar.yTx.getMMResources().getDimension(R.dimen.nk);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(com.tencent.mm.ui.chatting.d.a aVar, View view, Object obj) {
        view.setTag(obj);
        if (this.zbp == null) {
            this.zbp = new h(aVar);
        }
        view.setOnClickListener(this.zbp);
    }

    protected static void c(com.tencent.mm.ui.chatting.d.a aVar, View view, Object obj) {
        view.setTag(obj);
        view.setOnClickListener(((com.tencent.mm.ui.chatting.c.b.h) aVar.aF(com.tencent.mm.ui.chatting.c.b.h.class)).dDc());
    }

    public final boolean a(com.tencent.mm.ui.chatting.d.a aVar, com.tencent.mm.af.j.b bVar, bi biVar) {
        if (bo.isNullOrNil(bVar.fiG)) {
            return false;
        }
        com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.EnterCompleteVideo, biVar, bVar.fiN, bVar.fiM);
        String str = biVar.field_imgPath;
        Intent intent = new Intent();
        intent.putExtra("IsAd", false);
        intent.putExtra("KStremVideoUrl", bVar.fiG);
        intent.putExtra("KThumUrl", bVar.fiL);
        intent.putExtra("KThumbPath", str);
        intent.putExtra("KSta_StremVideoAduxInfo", bVar.fiM);
        intent.putExtra("KSta_StremVideoPublishId", bVar.fiN);
        intent.putExtra("KSta_SourceType", 2);
        intent.putExtra("KSta_Scene", aVar.dFx() ? com.tencent.mm.ui.chatting.a.b.TalkChat.value : com.tencent.mm.ui.chatting.a.b.Chat.value);
        intent.putExtra("KSta_FromUserName", b(aVar, biVar));
        intent.putExtra("KSta_ChatName", aVar.getTalkerUserName());
        intent.putExtra("KSta_MsgId", biVar.field_msgSvrId);
        intent.putExtra("KSta_SnsStatExtStr", bVar.cMn);
        if (aVar.dFx()) {
            intent.putExtra("KSta_ChatroomMembercount", n.mA(aVar.getTalkerUserName()));
        }
        intent.putExtra("KMediaId", "fakeid_" + biVar.field_msgId);
        intent.putExtra("KMediaVideoTime", bVar.fiH);
        intent.putExtra("StremWebUrl", bVar.fiK);
        intent.putExtra("StreamWording", bVar.fiJ);
        intent.putExtra("KMediaTitle", bVar.title);
        com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "sns", ".ui.VideoAdPlayerUI", intent);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.tencent.mm.ui.chatting.d.a aVar, String str, String str2, String str3, int i, String str4, boolean z, long j, long j2, bi biVar) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            ab.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
            return;
        }
        if (at.isMobile(aVar.yTx.getContext()) ? str2 != null && str2.length() > 0 : str == null || str.length() <= 0) {
            str = str2;
        }
        Intent intent = new Intent();
        intent.putExtra("msg_id", j);
        intent.putExtra("rawUrl", str);
        intent.putExtra("version_name", str3);
        intent.putExtra("version_code", i);
        intent.putExtra("usePlugin", z);
        intent.putExtra("geta8key_username", aVar.getTalkerUserName());
        intent.putExtra("KPublisherId", "msg_" + Long.toString(j2));
        intent.putExtra("KAppId", str4);
        intent.putExtra("pre_username", b(aVar, biVar));
        intent.putExtra("prePublishId", "msg_" + Long.toString(j2));
        if (biVar != null) {
            intent.putExtra("preUsername", b(aVar, biVar));
        }
        intent.putExtra("preChatName", aVar.getTalkerUserName());
        intent.putExtra("preChatTYPE", u.ad(b(aVar, biVar), aVar.getTalkerUserName()));
        intent.putExtra("preMsgIndex", 0);
        com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    protected static boolean dg(String str) {
        return com.tencent.mm.pluginsdk.model.app.g.dg(str);
    }

    protected static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(str, true);
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
            ab.printErrStackTrace("MicroMsg.ChattingItem", e, "", new Object[0]);
            return packageInfo;
        }
    }

    public static void a(com.tencent.mm.ui.chatting.d.a aVar, com.tencent.mm.af.j.b bVar, String str, com.tencent.mm.pluginsdk.model.app.f fVar, long j, int i, String str2) {
        int i2 = aVar.dFx() ? 2 : 1;
        if (i == -1) {
            if (bVar.type != 7) {
                i = 3;
            } else if (fVar == null || !com.tencent.mm.pluginsdk.model.app.p.u(aVar.yTx.getContext(), fVar.field_packageName)) {
                i = 6;
            } else {
                i = 0;
            }
        }
        if (bVar.type == 2) {
            i = 4;
        } else if (bVar.type == 5) {
            i = 1;
        }
        ok okVar = new ok();
        okVar.cKI.context = aVar.yTx.getContext();
        okVar.cKI.scene = i2;
        okVar.cKI.csB = bVar.appId;
        okVar.cKI.packageName = fVar == null ? null : fVar.field_packageName;
        okVar.cKI.msgType = bVar.type;
        okVar.cKI.cEV = str;
        okVar.cKI.cKJ = i;
        okVar.cKI.mediaTagName = bVar.mediaTagName;
        okVar.cKI.cKK = j;
        okVar.cKI.cKL = "";
        okVar.cKI.cst = str2;
        com.tencent.mm.sdk.b.a.xxA.m(okVar);
    }

    public static void a(com.tencent.mm.ui.chatting.d.a aVar, com.tencent.mm.af.j.b bVar, String str, com.tencent.mm.pluginsdk.model.app.f fVar, long j, String str2) {
        a(aVar, bVar, str, fVar, j, -1, str2);
    }

    protected static void b(com.tencent.mm.ui.chatting.d.a aVar, com.tencent.mm.af.j.b bVar, bi biVar) {
        com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
        if (bDb != null) {
            int i = aVar.dFx() ? 2 : 1;
            String d = d(aVar, biVar);
            aVar.yTx.getContext();
            bDb.a(bVar.appId, d, bVar.type, i, bVar.mediaTagName, biVar.field_msgSvrId, aVar.getTalkerUserName());
        }
    }

    protected static boolean a(com.tencent.mm.ui.chatting.d.a aVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
        com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
        if (com.tencent.mm.pluginsdk.model.app.g.a(aVar.yTx.getContext(), fVar) || bDb == null) {
            return false;
        }
        if (!bo.isNullOrNil(fVar.dng)) {
            ab.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", fVar.dng, Boolean.valueOf(com.tencent.mm.pluginsdk.model.app.q.by(aVar.yTx.getContext(), fVar.dng)));
            if (com.tencent.mm.pluginsdk.model.app.q.by(aVar.yTx.getContext(), fVar.dng)) {
                return true;
            }
        }
        int i = aVar.dFx() ? 2 : 1;
        gt gtVar = new gt();
        gtVar.cBv.actionCode = 2;
        gtVar.cBv.scene = i;
        gtVar.cBv.appId = fVar.field_appId;
        gtVar.cBv.context = aVar.yTx.getContext();
        com.tencent.mm.sdk.b.a.xxA.m(gtVar);
        aVar.yTx.getContext();
        bDb.W(fVar.field_appId, i, i);
        return true;
    }

    public static String d(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        String talkerUserName = aVar.getTalkerUserName();
        if (t.kH(talkerUserName)) {
            return bf.oy(biVar.field_content);
        }
        return talkerUserName;
    }

    public static void a(bi biVar, EmojiInfo emojiInfo) {
        String str;
        ct ctVar = new ct();
        ctVar.cvU.cvV = emojiInfo;
        EmojiInfo emojiInfo2 = ctVar.cvU.cvV;
        if (biVar != null) {
            str = biVar.field_talker;
        } else {
            str = null;
        }
        emojiInfo2.talker = str;
        ctVar.cvU.scene = 0;
        com.tencent.mm.sdk.b.a.xxA.m(ctVar);
    }

    protected static boolean a(bi biVar, com.tencent.mm.ui.chatting.d.a aVar) {
        int i;
        if (cb.aaE() - biVar.field_createTime > 120000) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            return false;
        }
        if (aVar != null && aVar.getTalkerUserName().equals(aVar.dFu()) && biVar.field_status == 2) {
            return false;
        }
        ab.d("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", Integer.valueOf(com.tencent.mm.m.g.Nu().getInt("ShowRevokeMsgEntry", 1)));
        if (1 == com.tencent.mm.m.g.Nu().getInt("ShowRevokeMsgEntry", 1)) {
            return true;
        }
        return false;
    }

    protected static boolean arB(String str) {
        return !(t.nl(str) || t.nB(str) || t.mZ(str) || t.nJ(str)) || t.kH(str);
    }

    protected static boolean dHm() {
        String value = com.tencent.mm.m.g.Nu().getValue("ShowSendOK");
        if (1 == (bo.isNullOrNil(value) ? 0 : bo.ank(value))) {
            return true;
        }
        return false;
    }

    protected static boolean a(com.tencent.mm.ui.chatting.c.b.h hVar, long j) {
        return j > 0 && hVar.dDd() == j;
    }

    /* Access modifiers changed, original: protected */
    public boolean dHn() {
        return true;
    }

    public final void a(a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar) {
        long j = yUK + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        yUK = currentTimeMillis;
        if (j < currentTimeMillis) {
            aw.ZK();
            zbg = com.tencent.mm.model.c.isSDCardAvailable();
        }
        this.kuU = zbg;
        String str = null;
        if (dHj()) {
            str = b(aVar2, biVar);
            a(aVar, aVar2, biVar, str);
            a(aVar, aVar2, str, biVar);
        }
        a(aVar, i, aVar2, biVar, str);
    }

    protected static String c(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
        String str = biVar.field_talker;
        com.tencent.mm.ui.chatting.c.b.d dVar = (com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class);
        if (!dVar.dDm() || dVar.dDk() == null) {
            return str;
        }
        return dVar.dDk().field_bizChatServId;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(int i, a aVar, bi biVar, String str, boolean z, com.tencent.mm.ui.chatting.d.a aVar2, final com.tencent.mm.ui.chatting.s.n nVar) {
        if (biVar.field_isSend == 1) {
            int i2;
            aVar.zby.setTag(new ay(biVar, z, i, str, 0));
            ImageView imageView = aVar.zby;
            if (this.zbr == null) {
                this.zbr = new com.tencent.mm.ui.chatting.s.e(aVar2) {
                    public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
                        AppMethodBeat.i(32785);
                        nVar.a(aVar, biVar);
                        AppMethodBeat.o(32785);
                    }
                };
            }
            imageView.setOnClickListener(this.zbr);
            switch (biVar.field_status) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i2 = -1;
                    break;
                case 5:
                    i2 = R.drawable.a1w;
                    break;
                default:
                    ab.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
                    i2 = -1;
                    break;
            }
            if (i2 != -1) {
                aVar.zby.setImageResource(R.drawable.a1w);
                aVar.zby.setVisibility(0);
                aVar.zby.setContentDescription(ah.getContext().getString(R.string.d1l));
                if (aVar.pyf != null) {
                    aVar.pyf.setVisibility(8);
                    return;
                }
                return;
            }
            aVar.zby.setVisibility(8);
        }
    }
}
