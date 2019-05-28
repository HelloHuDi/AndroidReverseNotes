package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C42219a;
import com.tencent.p177mm.modelstat.C42219a.C32832a;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9722b;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6541qc;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.C40707a;
import com.tencent.p177mm.p612ui.chatting.C40707a.C40705a;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C46641ai;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.mmsight.C21290c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.C30076j;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.ActUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.am */
public final class C23821am {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.am$d */
    public static class C15733d extends C5379a {
        private static Map<String, WeakReference<C15733d>> zdR = new HashMap();
        private static SparseArray<String> zht = new SparseArray();
        TextView pxy;
        ImageView raP;
        ImageView zbR;
        ImageView zbS;
        TextView zbU;
        ImageView zci;
        ImageView zdN;
        ImageView zeh;
        TextView zho;
        MMPinProgressBtn zhp;
        View zhq;
        ProgressBar zhr;
        View zhs;

        static {
            AppMethodBeat.m2504i(33354);
            AppMethodBeat.m2505o(33354);
        }

        /* renamed from: b */
        public static boolean m24041b(C9718a c9718a) {
            AppMethodBeat.m2504i(33351);
            if (c9718a.fXt != C9722b.UPDATE) {
                AppMethodBeat.m2505o(33351);
                return false;
            }
            final C26493s ut = C26494u.m42268ut(c9718a.fileName);
            if (ut == null) {
                C4990ab.m7421w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", c9718a.fileName);
                AppMethodBeat.m2505o(33351);
                return false;
            } else if (ut.status == 112 || ut.status == 104 || ut.status == 103) {
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(33350);
                        WeakReference weakReference = (WeakReference) C15733d.zdR.get(ut.getFileName());
                        if (weakReference == null) {
                            C4990ab.m7421w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", ut.getFileName());
                            AppMethodBeat.m2505o(33350);
                            return;
                        }
                        C15733d c15733d = (C15733d) weakReference.get();
                        if (c15733d == null) {
                            C4990ab.m7421w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", ut.getFileName());
                            AppMethodBeat.m2505o(33350);
                            return;
                        }
                        c15733d.zbR.setVisibility(8);
                        c15733d.raP.setVisibility(8);
                        c15733d.zhp.setVisibility(0);
                        int i = ut.status;
                        C4990ab.m7416i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
                        if (i == 112 || i == 122 || i == 120) {
                            c15733d.zhp.setProgress(C26494u.m42255g(ut));
                            AppMethodBeat.m2505o(33350);
                            return;
                        }
                        c15733d.zhp.setProgress(C26494u.m42256h(ut));
                        AppMethodBeat.m2505o(33350);
                    }
                });
                AppMethodBeat.m2505o(33351);
                return true;
            } else {
                AppMethodBeat.m2505o(33351);
                return false;
            }
        }

        /* renamed from: z */
        public final C5379a mo27956z(View view, boolean z) {
            ImageView imageView;
            ProgressBar progressBar;
            View view2 = null;
            AppMethodBeat.m2504i(33352);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.zdN = (ImageView) view.findViewById(2131822578);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.pxy = (TextView) view.findViewById(2131822580);
            this.zho = (TextView) view.findViewById(2131822622);
            this.raP = (ImageView) view.findViewById(2131822581);
            this.zbR = (ImageView) view.findViewById(2131822556);
            this.zbS = (ImageView) view.findViewById(2131822555);
            this.zhp = (MMPinProgressBtn) view.findViewById(2131822579);
            this.zhq = view.findViewById(2131822621);
            this.jPL = view.findViewById(2131822515);
            this.zbU = (TextView) view.findViewById(2131822454);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.zeh = (ImageView) view.findViewById(2131822553);
            if (z) {
                imageView = null;
            } else {
                imageView = (ImageView) view.findViewById(2131822661);
            }
            this.zci = imageView;
            if (z) {
                progressBar = null;
            } else {
                progressBar = (ProgressBar) view.findViewById(2131822669);
            }
            this.zhr = progressBar;
            if (!z) {
                view2 = view.findViewById(2131822616);
            }
            this.zhs = view2;
            AppMethodBeat.m2505o(33352);
            return this;
        }

        /* renamed from: a */
        public static void m24040a(C15733d c15733d, C7620bi c7620bi, boolean z, int i, C46650a c46650a, OnClickListener onClickListener, OnLongClickListener onLongClickListener) {
            int fromDPToPix;
            AppMethodBeat.m2504i(33353);
            String str = (String) zht.get(c15733d.hashCode());
            if (str != null) {
                zdR.remove(str);
            }
            zht.put(c15733d.hashCode(), c7620bi.field_imgPath);
            zdR.put(c7620bi.field_imgPath, new WeakReference(c15733d));
            C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
            if (ut == null) {
                ut = new C26493s();
            }
            C37961o.all();
            Bitmap a = C32291o.ahl().mo73086a(C9720t.m17304ui(c7620bi.field_imgPath), C1338a.getDensity(c46650a.yTx.getContext()), c46650a.yTx.getContext(), (int) C25738R.drawable.b0p);
            c15733d.zeh.setLayoutParams(new LayoutParams(0, 0));
            if (a == null) {
                fromDPToPix = C1338a.fromDPToPix(c46650a.yTx.getContext(), 85);
                int al = C1338a.m2856al(c46650a.yTx.getContext(), C25738R.dimen.f9745eb);
                Bitmap a2 = C5056d.m7614a(C5056d.m7644au(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12081rn), fromDPToPix, al), (int) C25738R.drawable.b0p, fromDPToPix, al);
                C9638aw.m17190ZK();
                if (C18628c.isSDCardAvailable()) {
                    c15733d.zdN.setImageBitmap(C5056d.m7614a(a2, (int) C25738R.drawable.b0p, fromDPToPix, al));
                } else {
                    c15733d.zdN.setImageDrawable(C1338a.m2864g(c46650a.yTx.getContext(), C1318a.video_no_sd_icon));
                    c15733d.zdN.setBackground(new BitmapDrawable(a2));
                }
                LayoutParams layoutParams = new LayoutParams(fromDPToPix, al);
                c15733d.zeh.setLayoutParams(layoutParams);
                if (c15733d.zhs != null) {
                    c15733d.zhs.setLayoutParams(layoutParams);
                }
            } else {
                c15733d.zdN.setImageBitmap(a);
                LayoutParams layoutParams2 = new LayoutParams(a.getWidth(), a.getHeight());
                c15733d.zeh.setLayoutParams(layoutParams2);
                if (c15733d.zhs != null) {
                    c15733d.zhs.setLayoutParams(layoutParams2);
                }
            }
            if (z) {
                c15733d.pxy.setText(C42252ah.m74622ga((long) ut.frO));
                c15733d.zho.setText(C42252ah.m74629mK(ut.fXd));
                fromDPToPix = ut.status;
                C4990ab.m7416i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + fromDPToPix + " info : " + ut.getFileName());
                if (fromDPToPix == 199) {
                    c15733d.raP.setImageDrawable(C1338a.m2864g(c46650a.yTx.getContext(), C1318a.shortvideo_play_btn));
                } else {
                    c15733d.raP.setImageDrawable(C1338a.m2864g(c46650a.yTx.getContext(), C1318a.shortvideo_play_btn));
                    c15733d.pxy.setVisibility(8);
                }
                if (fromDPToPix == 112 || fromDPToPix == 122 || fromDPToPix == 120) {
                    c15733d.zbR.setVisibility(8);
                    c15733d.raP.setVisibility(8);
                    c15733d.zhp.setVisibility(0);
                    c15733d.zhp.setProgress(C26494u.m42255g(ut));
                    C4990ab.m7418v("MicroMsg.VideoItemHoder", "status begin");
                    c15733d.zhp.invalidate();
                } else if (fromDPToPix == 113 || fromDPToPix == C27011o.CTRL_INDEX || ut.alx()) {
                    c15733d.zbR.setVisibility(0);
                    c15733d.zbS.setVisibility(8);
                    c15733d.zhp.setVisibility(8);
                    c15733d.raP.setVisibility(0);
                    C4990ab.m7418v("MicroMsg.VideoItemHoder", "status pause");
                } else {
                    c15733d.zbS.setVisibility(8);
                    c15733d.zbR.setVisibility(8);
                    c15733d.zhp.setVisibility(8);
                    c15733d.raP.setVisibility(0);
                    C4990ab.m7418v("MicroMsg.VideoItemHoder", "status gone");
                }
            } else {
                c15733d.pxy.setText(C42252ah.m74622ga((long) ut.frO));
                c15733d.zho.setText(C42252ah.m74629mK(ut.fXd));
                fromDPToPix = ut.status;
                c15733d.raP.setImageDrawable(C1338a.m2864g(c46650a.yTx.getContext(), C1318a.shortvideo_play_btn));
                if (c15733d.zhr != null) {
                    c15733d.zhr.setVisibility(8);
                }
                if (c15733d.zhs != null) {
                    c15733d.zhs.setVisibility(8);
                }
                C4990ab.m7419v("MicroMsg.VideoItemHoder", "video status %d", Integer.valueOf(fromDPToPix));
                if (fromDPToPix == 104 || fromDPToPix == 103) {
                    if (C21290c.m32670yM(ut.fXe)) {
                        if (c15733d.zhr != null) {
                            c15733d.zhr.setVisibility(0);
                        }
                        if (c15733d.zhs != null) {
                            c15733d.zhs.setVisibility(0);
                        }
                        c15733d.zho.setText(null);
                        c15733d.pxy.setText(null);
                        c15733d.raP.setImageDrawable(null);
                        c15733d.zbS.setVisibility(8);
                        c15733d.zbR.setVisibility(8);
                        c15733d.zhp.setVisibility(8);
                    } else {
                        if (c15733d.zhr != null) {
                            c15733d.zhr.setVisibility(8);
                        }
                        if (c15733d.zhs != null) {
                            c15733d.zhs.setVisibility(8);
                        }
                        c15733d.zbR.setVisibility(8);
                        c15733d.raP.setVisibility(8);
                        c15733d.zhp.setVisibility(0);
                        c15733d.zhp.setProgress(C26494u.m42256h(ut));
                    }
                    C4990ab.m7418v("MicroMsg.VideoItemHoder", "status begin");
                } else if (fromDPToPix == 105 || fromDPToPix == C27011o.CTRL_INDEX || ut.alx()) {
                    c15733d.zbR.setVisibility(0);
                    c15733d.zbS.setVisibility(8);
                    c15733d.zhp.setVisibility(8);
                    c15733d.raP.setVisibility(0);
                    C4990ab.m7418v("MicroMsg.VideoItemHoder", "status pause");
                } else if (fromDPToPix != 106) {
                    c15733d.zbS.setVisibility(8);
                    c15733d.zbR.setVisibility(8);
                    c15733d.zhp.setVisibility(8);
                    c15733d.raP.setVisibility(0);
                    C4990ab.m7418v("MicroMsg.VideoItemHoder", "status gone");
                } else if (C30076j.aiB(c7620bi.field_imgPath)) {
                    if (c15733d.zhr != null) {
                        c15733d.zhr.setVisibility(0);
                    }
                    if (c15733d.zhs != null) {
                        c15733d.zhs.setVisibility(0);
                    }
                    c15733d.zho.setText(null);
                    c15733d.pxy.setText(null);
                    c15733d.raP.setImageDrawable(null);
                    c15733d.zbS.setVisibility(8);
                    c15733d.zbR.setVisibility(8);
                    c15733d.zhp.setVisibility(8);
                } else {
                    C26494u.m42261um(c7620bi.field_imgPath);
                }
            }
            ImageView imageView = c15733d.zbS;
            C15735e c15735e = new C15735e(c7620bi, c46650a.dFx(), i, c7620bi.field_talker);
            c15735e.klY = 4;
            imageView.setTag(c15735e);
            c15733d.zbS.setOnClickListener(onClickListener);
            imageView = c15733d.zbR;
            c15735e = new C15735e(c7620bi, c46650a.dFx(), i, c7620bi.field_talker);
            c15735e.klY = 3;
            imageView.setTag(c15735e);
            c15733d.zbR.setOnClickListener(onClickListener);
            View view = c15733d.jPL;
            c15735e = new C15735e(c7620bi, c46650a.dFx(), i, c7620bi.field_talker);
            c15735e.klY = 2;
            view.setTag(c15735e);
            c15733d.jPL.setOnClickListener(onClickListener);
            c15733d.jPL.setOnLongClickListener(onLongClickListener);
            c15733d.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            AppMethodBeat.m2505o(33353);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.am$e */
    protected static class C15735e extends C40814ay {
        int klY;

        public C15735e(C7620bi c7620bi, boolean z, int i, String str) {
            super(c7620bi, z, i, str, 0);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.am$b */
    public static class C23820b extends C5378c {
        private C46650a yJI;
        private C23822c zhl;

        private C23822c dHr() {
            AppMethodBeat.m2504i(33340);
            if (this.zhl == null) {
                this.zhl = new C23822c(this.yJI);
            }
            C23822c c23822c = this.zhl;
            AppMethodBeat.m2505o(33340);
            return c23822c;
        }

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 43) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33341);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969106);
                view.setTag(new C15733d().mo27956z(view, false));
            }
            AppMethodBeat.m2505o(33341);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33342);
            this.yJI = c46650a;
            C15733d c15733d = (C15733d) c5379a;
            C15733d.m24040a(c15733d, c7620bi, false, i, c46650a, dHr(), mo11021c(c46650a));
            if (C5378c.dHm()) {
                C26493s ut = C26494u.m42268ut(c7620bi.field_imgPath);
                if (ut != null && ut.status == 199 && C5378c.m8136a((C15612h) c46650a.mo74857aF(C15612h.class), c7620bi.field_msgId)) {
                    if (c15733d.zci != null) {
                        c15733d.zci.setVisibility(0);
                        AppMethodBeat.m2505o(33342);
                        return;
                    }
                } else if (c15733d.zci != null) {
                    c15733d.zci.setVisibility(8);
                }
            }
            AppMethodBeat.m2505o(33342);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33343);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                if (view == null) {
                    AppMethodBeat.m2505o(33343);
                    return false;
                }
                int i = ((C40814ay) view.getTag()).position;
                C26493s uf = C37961o.all().mo21063uf(c7620bi.field_imgPath);
                MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(C25738R.string.amb));
                int width = view.getWidth();
                int height = view.getHeight();
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
                if (uf != null) {
                    int i2 = uf.status;
                    if (!(104 == i2 || 103 == i2 || 105 == i2 || 106 == i2)) {
                        contextMenu.add(i, 107, 0, view.getContext().getString(C25738R.string.dr1));
                    }
                }
                if (uf != null && (uf.status == 199 || uf.status == 199)) {
                    if (C25985d.afj("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                    }
                    C9321dq c9321dq = new C9321dq();
                    c9321dq.cxc.cvx = c7620bi.field_msgId;
                    C4879a.xxA.mo10055m(c9321dq);
                    if (c9321dq.cxd.cwB) {
                        contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                    }
                    if (!c7620bi.drC() && ((c7620bi.bws() || c7620bi.bwt()) && C5378c.m8135a(c7620bi, this.yJI) && ((uf.status == 199 || uf.status == 199 || c7620bi.dJz == 1) && C5378c.arB(c7620bi.field_talker)))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
                    }
                    if (C17903f.aez() && !this.yJI.dFy()) {
                        contextMenu.add(i, 114, 0, view.getContext().getString(C25738R.string.am3));
                    }
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am8));
                }
            }
            AppMethodBeat.m2505o(33343);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33344);
            ((C46641ai) c46650a.mo74857aF(C46641ai.class)).mo72005a(menuItem, c7620bi);
            AppMethodBeat.m2505o(33344);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33345);
            dHr().onClick(view);
            AppMethodBeat.m2505o(33345);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.am$c */
    public static class C23822c extends C23812e {
        public static boolean yWS = false;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.am$c$2 */
        class C238242 implements DialogInterface.OnClickListener {
            C238242() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public C23822c(C46650a c46650a) {
            super(c46650a);
        }

        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33347);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C45457b.fRa.mo73250F(c40814ay.cKd);
            C15735e c15735e = (C15735e) c40814ay;
            C42219a.m74510a(c15735e.cKd, C32832a.Click);
            int i;
            if (2 != c15735e.klY) {
                C7620bi c7620bi2 = c15735e.cKd;
                if (c7620bi2.field_isSend == 0) {
                    C7620bi c7620bi3 = c15735e.cKd;
                    C26493s ut = C26494u.m42268ut(c7620bi3.field_imgPath);
                    C4990ab.m7416i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + ut.status + " is sender:" + c7620bi3.field_isSend);
                    switch (c15735e.klY) {
                        case 3:
                            m36653i(ut);
                            break;
                        case 4:
                            C9638aw.m17190ZK();
                            if (!C18628c.isSDCardAvailable()) {
                                C23639t.m36492hO(this.yJI.yTx.getContext());
                                break;
                            } else {
                                C26494u.m42265uq(c7620bi3.field_imgPath);
                                break;
                            }
                    }
                }
                if (c7620bi2.field_isSend == 1) {
                    c7620bi2 = c15735e.cKd;
                    if (c7620bi2 == null) {
                        C4990ab.m7420w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
                        AppMethodBeat.m2505o(33347);
                        return;
                    }
                    C26493s uf = C37961o.all().mo21063uf(c7620bi2.field_imgPath);
                    if (uf == null) {
                        C4990ab.m7421w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", c7620bi2.field_imgPath);
                        AppMethodBeat.m2505o(33347);
                        return;
                    }
                    i = uf.status;
                    C4990ab.m7416i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
                    String string;
                    switch (c15735e.klY) {
                        case 3:
                            C9638aw.m17190ZK();
                            if (C18628c.isSDCardAvailable()) {
                                if (i != 113) {
                                    if (!uf.alx()) {
                                        c7620bi2.dtJ();
                                        C9638aw.m17190ZK();
                                        C18628c.m29080XO().mo15284a(c7620bi2.field_msgId, c7620bi2);
                                        if (uf.status != C27011o.CTRL_INDEX) {
                                            C26494u.m42263uo(c7620bi2.field_imgPath);
                                            break;
                                        }
                                        C26494u.m42267us(c7620bi2.field_imgPath);
                                        AppMethodBeat.m2505o(33347);
                                        return;
                                    }
                                    C4990ab.m7412e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
                                    string = this.yJI.yTx.getContext().getString(C25738R.string.f15);
                                    if (i == ErrorCode.NEEDDOWNLOAD_3) {
                                        string = this.yJI.yTx.getContext().getString(C25738R.string.f15);
                                    } else if (i == 141) {
                                        string = this.yJI.yTx.getContext().getString(C25738R.string.f16);
                                    } else if (i == 140) {
                                        string = this.yJI.yTx.getContext().getString(C25738R.string.f14);
                                    }
                                    C30379h.m48461b(this.yJI.yTx.getContext(), string, this.yJI.yTx.getContext().getString(C25738R.string.ewj), true);
                                    AppMethodBeat.m2505o(33347);
                                    return;
                                }
                                C4990ab.m7416i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
                                m36653i(uf);
                                AppMethodBeat.m2505o(33347);
                                return;
                            }
                            C23639t.m36492hO(this.yJI.yTx.getContext());
                            AppMethodBeat.m2505o(33347);
                            return;
                        case 4:
                            C9638aw.m17190ZK();
                            if (!C18628c.isSDCardAvailable()) {
                                C23639t.m36492hO(this.yJI.yTx.getContext());
                                AppMethodBeat.m2505o(33347);
                                return;
                            } else if (i == 112) {
                                C4990ab.m7416i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
                                C26494u.m42265uq(c7620bi2.field_imgPath);
                                AppMethodBeat.m2505o(33347);
                                return;
                            } else {
                                string = c7620bi2.field_imgPath;
                                uf = C26494u.m42268ut(string);
                                if (uf == null) {
                                    C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + string);
                                    C1447g.getLine();
                                } else if (uf.status == 104 || uf.status == 103) {
                                    uf.status = 105;
                                    uf.fXb = C5046bo.anT();
                                    uf.bJt = ActUtil.HEIGHT;
                                    if (!C26494u.m42253f(uf)) {
                                        C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " update failed: " + string);
                                        C1447g.getLine();
                                    }
                                } else {
                                    C4990ab.m7412e("MicroMsg.VideoLogic", "ERR:" + C1447g.m3075Mq() + " get status failed: " + string + " status:" + uf.status);
                                    C1447g.getLine();
                                }
                                C4990ab.m7410d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
                                C6541qc c6541qc = new C6541qc();
                                c6541qc.cMs.csG = c7620bi2;
                                C4879a.xxA.mo10055m(c6541qc);
                                AppMethodBeat.m2505o(33347);
                                return;
                            }
                    }
                }
                AppMethodBeat.m2505o(33347);
            } else if (C35973a.m59179bJ(this.yJI.yTx.getContext()) || C35973a.m59177bH(this.yJI.yTx.getContext())) {
                C4990ab.m7416i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
                AppMethodBeat.m2505o(33347);
            } else {
                int height;
                String str;
                Bundle bundle;
                C7620bi c7620bi4 = c15735e.cKd;
                int[] iArr = new int[2];
                i = 0;
                if (view != null) {
                    view.getLocationInWindow(iArr);
                    i = view.getWidth();
                    height = view.getHeight();
                } else {
                    height = 0;
                }
                long j = c7620bi4.field_msgId;
                long j2 = c7620bi4.field_msgSvrId;
                String str2 = c15735e.userName;
                String str3 = c15735e.chatroomName;
                Intent intent = new Intent(this.yJI.yTx.getContext(), ImageGalleryUI.class);
                intent.putExtra("show_search_chat_content_result", ((C23733z) this.yJI.mo74857aF(C23733z.class)).dES());
                intent.putExtra("img_gallery_msg_id", j);
                intent.putExtra("key_is_biz_chat", ((C36135d) this.yJI.mo74857aF(C36135d.class)).dDm());
                intent.putExtra("key_biz_chat_id", ((C36135d) this.yJI.mo74857aF(C36135d.class)).dDz());
                intent.putExtra("img_gallery_msg_svr_id", j2);
                intent.putExtra("img_gallery_talker", str2);
                intent.putExtra("img_gallery_chatroom_name", str3);
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", i);
                intent.putExtra("img_gallery_height", height);
                intent.putExtra("img_gallery_enter_from_chatting_ui", ((C23733z) this.yJI.mo74857aF(C23733z.class)).dEN());
                str3 = this.yJI.getTalkerUserName();
                String dFu = c7620bi4.field_isSend == 1 ? this.yJI.dFu() : str2;
                Bundle bundle2 = new Bundle();
                if (this.yJI.dFx()) {
                    str = "stat_scene";
                    height = 2;
                    bundle = bundle2;
                } else {
                    str = "stat_scene";
                    if (C1855t.m3913mZ(str3)) {
                        height = 7;
                        bundle = bundle2;
                    } else {
                        height = 1;
                        bundle = bundle2;
                    }
                }
                bundle.putInt(str, height);
                bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                bundle2.putString("stat_chat_talker_username", str3);
                bundle2.putString("stat_send_msg_user", dFu);
                intent.putExtra("_stat_obj", bundle2);
                this.yJI.startActivity(intent);
                this.yJI.yTx.overridePendingTransition(0, 0);
                if (c7620bi4.bwt() && c15735e.userName != null) {
                    C40707a.m70378a(C40705a.EnterFullScreen, c7620bi4);
                    if (c15735e.userName.toLowerCase().endsWith("@chatroom")) {
                        C7060h.pYm.mo8381e(11444, Integer.valueOf(2));
                        AppMethodBeat.m2505o(33347);
                        return;
                    }
                    C7060h.pYm.mo8381e(11444, Integer.valueOf(1));
                }
                AppMethodBeat.m2505o(33347);
            }
        }

        /* renamed from: i */
        private void m36653i(final C26493s c26493s) {
            AppMethodBeat.m2504i(33348);
            C9638aw.m17190ZK();
            if (!C18628c.isSDCardAvailable()) {
                C23639t.m36492hO(this.yJI.yTx.getContext());
                AppMethodBeat.m2505o(33348);
            } else if (c26493s.status == C27011o.CTRL_INDEX) {
                C26494u.m42266ur(c26493s.getFileName());
                AppMethodBeat.m2505o(33348);
            } else if (C32856ab.m53750ch(this.yJI.yTx.getContext()) || yWS) {
                C26494u.m42264up(c26493s.getFileName());
                AppMethodBeat.m2505o(33348);
            } else {
                yWS = true;
                C30379h.m48432a(this.yJI.yTx.getContext(), (int) C25738R.string.f17, (int) C25738R.string.f9238tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(33346);
                        C23822c.arK(c26493s.getFileName());
                        AppMethodBeat.m2505o(33346);
                    }
                }, new C238242());
                AppMethodBeat.m2505o(33348);
            }
        }

        static /* synthetic */ void arK(String str) {
            AppMethodBeat.m2504i(33349);
            C26494u.m42264up(str);
            AppMethodBeat.m2505o(33349);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.am$a */
    public static class C23825a extends C5378c {
        private C46650a yJI;
        private C23822c zhl;

        private C23822c dHr() {
            AppMethodBeat.m2504i(33334);
            if (this.zhl == null) {
                this.zhl = new C23822c(this.yJI);
            }
            C23822c c23822c = this.zhl;
            AppMethodBeat.m2505o(33334);
            return c23822c;
        }

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 43) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33335);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969070);
                view.setTag(new C15733d().mo27956z(view, true));
            }
            AppMethodBeat.m2505o(33335);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33336);
            this.yJI = c46650a;
            C15733d c15733d = (C15733d) c5379a;
            C15733d.m24040a(c15733d, c7620bi, true, i, c46650a, dHr(), mo11021c(c46650a));
            String str2 = c7620bi.dJv;
            if (str2 == null || str2.length() == 0) {
                c15733d.zbU.setVisibility(8);
                AppMethodBeat.m2505o(33336);
                return;
            }
            c15733d.zbU.setVisibility(0);
            mo11018b(c46650a, (View) c15733d.zbU, (Object) C40814ay.arL(str2));
            AppMethodBeat.m2505o(33336);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33337);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
                int i = ((C40814ay) view.getTag()).position;
                C26493s uf = C37961o.all().mo21063uf(c7620bi.field_imgPath);
                contextMenu.add(i, 130, 0, view.getContext().getString(C25738R.string.amb));
                contextMenu.add(i, 107, 0, view.getContext().getString(C25738R.string.dr1));
                if (C25985d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                }
                C9321dq c9321dq = new C9321dq();
                c9321dq.cxc.cvx = c7620bi.field_msgId;
                C4879a.xxA.mo10055m(c9321dq);
                if (c9321dq.cxd.cwB) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                }
                if (uf != null && ((uf.status == 199 || uf.status == 199) && C17903f.aez() && !this.yJI.dFy())) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(C25738R.string.am3));
                }
                if (C1831bh.m3770o(c7620bi)) {
                    contextMenu.clear();
                    contextMenu.add(i, 130, 0, view.getContext().getString(C25738R.string.amb));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am8));
                }
            }
            AppMethodBeat.m2505o(33337);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33338);
            ((C46641ai) c46650a.mo74857aF(C46641ai.class)).mo72005a(menuItem, c7620bi);
            AppMethodBeat.m2505o(33338);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33339);
            dHr().onClick(view);
            AppMethodBeat.m2505o(33339);
            return true;
        }
    }
}
