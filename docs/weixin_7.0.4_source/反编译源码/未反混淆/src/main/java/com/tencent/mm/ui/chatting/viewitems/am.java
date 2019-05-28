package com.tencent.mm.ui.chatting.viewitems;

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
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.ai;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.util.ActUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class am {

    public static class d extends com.tencent.mm.ui.chatting.viewitems.c.a {
        private static Map<String, WeakReference<d>> zdR = new HashMap();
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
            AppMethodBeat.i(33354);
            AppMethodBeat.o(33354);
        }

        public static boolean b(com.tencent.mm.modelvideo.t.a.a aVar) {
            AppMethodBeat.i(33351);
            if (aVar.fXt != com.tencent.mm.modelvideo.t.a.b.UPDATE) {
                AppMethodBeat.o(33351);
                return false;
            }
            final s ut = u.ut(aVar.fileName);
            if (ut == null) {
                ab.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", aVar.fileName);
                AppMethodBeat.o(33351);
                return false;
            } else if (ut.status == 112 || ut.status == 104 || ut.status == 103) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(33350);
                        WeakReference weakReference = (WeakReference) d.zdR.get(ut.getFileName());
                        if (weakReference == null) {
                            ab.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", ut.getFileName());
                            AppMethodBeat.o(33350);
                            return;
                        }
                        d dVar = (d) weakReference.get();
                        if (dVar == null) {
                            ab.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", ut.getFileName());
                            AppMethodBeat.o(33350);
                            return;
                        }
                        dVar.zbR.setVisibility(8);
                        dVar.raP.setVisibility(8);
                        dVar.zhp.setVisibility(0);
                        int i = ut.status;
                        ab.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : ".concat(String.valueOf(i)));
                        if (i == 112 || i == 122 || i == 120) {
                            dVar.zhp.setProgress(u.g(ut));
                            AppMethodBeat.o(33350);
                            return;
                        }
                        dVar.zhp.setProgress(u.h(ut));
                        AppMethodBeat.o(33350);
                    }
                });
                AppMethodBeat.o(33351);
                return true;
            } else {
                AppMethodBeat.o(33351);
                return false;
            }
        }

        public final com.tencent.mm.ui.chatting.viewitems.c.a z(View view, boolean z) {
            ImageView imageView;
            ProgressBar progressBar;
            View view2 = null;
            AppMethodBeat.i(33352);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zdN = (ImageView) view.findViewById(R.id.aqy);
            this.qkY = (TextView) view.findViewById(R.id.od);
            this.pxy = (TextView) view.findViewById(R.id.ar0);
            this.zho = (TextView) view.findViewById(R.id.as5);
            this.raP = (ImageView) view.findViewById(R.id.ar1);
            this.zbR = (ImageView) view.findViewById(R.id.aqc);
            this.zbS = (ImageView) view.findViewById(R.id.aqb);
            this.zhp = (MMPinProgressBtn) view.findViewById(R.id.aqz);
            this.zhq = view.findViewById(R.id.as4);
            this.jPL = view.findViewById(R.id.ap9);
            this.zbU = (TextView) view.findViewById(R.id.anl);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.zeh = (ImageView) view.findViewById(R.id.aq_);
            if (z) {
                imageView = null;
            } else {
                imageView = (ImageView) view.findViewById(R.id.at7);
            }
            this.zci = imageView;
            if (z) {
                progressBar = null;
            } else {
                progressBar = (ProgressBar) view.findViewById(R.id.ate);
            }
            this.zhr = progressBar;
            if (!z) {
                view2 = view.findViewById(R.id.arz);
            }
            this.zhs = view2;
            AppMethodBeat.o(33352);
            return this;
        }

        public static void a(d dVar, bi biVar, boolean z, int i, com.tencent.mm.ui.chatting.d.a aVar, OnClickListener onClickListener, OnLongClickListener onLongClickListener) {
            int fromDPToPix;
            AppMethodBeat.i(33353);
            String str = (String) zht.get(dVar.hashCode());
            if (str != null) {
                zdR.remove(str);
            }
            zht.put(dVar.hashCode(), biVar.field_imgPath);
            zdR.put(biVar.field_imgPath, new WeakReference(dVar));
            s ut = u.ut(biVar.field_imgPath);
            if (ut == null) {
                ut = new s();
            }
            o.all();
            Bitmap a = com.tencent.mm.at.o.ahl().a(t.ui(biVar.field_imgPath), com.tencent.mm.bz.a.getDensity(aVar.yTx.getContext()), aVar.yTx.getContext(), (int) R.drawable.b0p);
            dVar.zeh.setLayoutParams(new LayoutParams(0, 0));
            if (a == null) {
                fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(aVar.yTx.getContext(), 85);
                int al = com.tencent.mm.bz.a.al(aVar.yTx.getContext(), R.dimen.eb);
                Bitmap a2 = com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.au(aVar.yTx.getContext().getResources().getColor(R.color.rn), fromDPToPix, al), (int) R.drawable.b0p, fromDPToPix, al);
                aw.ZK();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    dVar.zdN.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(a2, (int) R.drawable.b0p, fromDPToPix, al));
                } else {
                    dVar.zdN.setImageDrawable(com.tencent.mm.bz.a.g(aVar.yTx.getContext(), R.raw.video_no_sd_icon));
                    dVar.zdN.setBackground(new BitmapDrawable(a2));
                }
                LayoutParams layoutParams = new LayoutParams(fromDPToPix, al);
                dVar.zeh.setLayoutParams(layoutParams);
                if (dVar.zhs != null) {
                    dVar.zhs.setLayoutParams(layoutParams);
                }
            } else {
                dVar.zdN.setImageBitmap(a);
                LayoutParams layoutParams2 = new LayoutParams(a.getWidth(), a.getHeight());
                dVar.zeh.setLayoutParams(layoutParams2);
                if (dVar.zhs != null) {
                    dVar.zhs.setLayoutParams(layoutParams2);
                }
            }
            if (z) {
                dVar.pxy.setText(ah.ga((long) ut.frO));
                dVar.zho.setText(ah.mK(ut.fXd));
                fromDPToPix = ut.status;
                ab.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + fromDPToPix + " info : " + ut.getFileName());
                if (fromDPToPix == 199) {
                    dVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(aVar.yTx.getContext(), R.raw.shortvideo_play_btn));
                } else {
                    dVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(aVar.yTx.getContext(), R.raw.shortvideo_play_btn));
                    dVar.pxy.setVisibility(8);
                }
                if (fromDPToPix == 112 || fromDPToPix == 122 || fromDPToPix == 120) {
                    dVar.zbR.setVisibility(8);
                    dVar.raP.setVisibility(8);
                    dVar.zhp.setVisibility(0);
                    dVar.zhp.setProgress(u.g(ut));
                    ab.v("MicroMsg.VideoItemHoder", "status begin");
                    dVar.zhp.invalidate();
                } else if (fromDPToPix == 113 || fromDPToPix == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX || ut.alx()) {
                    dVar.zbR.setVisibility(0);
                    dVar.zbS.setVisibility(8);
                    dVar.zhp.setVisibility(8);
                    dVar.raP.setVisibility(0);
                    ab.v("MicroMsg.VideoItemHoder", "status pause");
                } else {
                    dVar.zbS.setVisibility(8);
                    dVar.zbR.setVisibility(8);
                    dVar.zhp.setVisibility(8);
                    dVar.raP.setVisibility(0);
                    ab.v("MicroMsg.VideoItemHoder", "status gone");
                }
            } else {
                dVar.pxy.setText(ah.ga((long) ut.frO));
                dVar.zho.setText(ah.mK(ut.fXd));
                fromDPToPix = ut.status;
                dVar.raP.setImageDrawable(com.tencent.mm.bz.a.g(aVar.yTx.getContext(), R.raw.shortvideo_play_btn));
                if (dVar.zhr != null) {
                    dVar.zhr.setVisibility(8);
                }
                if (dVar.zhs != null) {
                    dVar.zhs.setVisibility(8);
                }
                ab.v("MicroMsg.VideoItemHoder", "video status %d", Integer.valueOf(fromDPToPix));
                if (fromDPToPix == 104 || fromDPToPix == 103) {
                    if (com.tencent.mm.plugin.mmsight.c.yM(ut.fXe)) {
                        if (dVar.zhr != null) {
                            dVar.zhr.setVisibility(0);
                        }
                        if (dVar.zhs != null) {
                            dVar.zhs.setVisibility(0);
                        }
                        dVar.zho.setText(null);
                        dVar.pxy.setText(null);
                        dVar.raP.setImageDrawable(null);
                        dVar.zbS.setVisibility(8);
                        dVar.zbR.setVisibility(8);
                        dVar.zhp.setVisibility(8);
                    } else {
                        if (dVar.zhr != null) {
                            dVar.zhr.setVisibility(8);
                        }
                        if (dVar.zhs != null) {
                            dVar.zhs.setVisibility(8);
                        }
                        dVar.zbR.setVisibility(8);
                        dVar.raP.setVisibility(8);
                        dVar.zhp.setVisibility(0);
                        dVar.zhp.setProgress(u.h(ut));
                    }
                    ab.v("MicroMsg.VideoItemHoder", "status begin");
                } else if (fromDPToPix == 105 || fromDPToPix == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX || ut.alx()) {
                    dVar.zbR.setVisibility(0);
                    dVar.zbS.setVisibility(8);
                    dVar.zhp.setVisibility(8);
                    dVar.raP.setVisibility(0);
                    ab.v("MicroMsg.VideoItemHoder", "status pause");
                } else if (fromDPToPix != 106) {
                    dVar.zbS.setVisibility(8);
                    dVar.zbR.setVisibility(8);
                    dVar.zhp.setVisibility(8);
                    dVar.raP.setVisibility(0);
                    ab.v("MicroMsg.VideoItemHoder", "status gone");
                } else if (j.aiB(biVar.field_imgPath)) {
                    if (dVar.zhr != null) {
                        dVar.zhr.setVisibility(0);
                    }
                    if (dVar.zhs != null) {
                        dVar.zhs.setVisibility(0);
                    }
                    dVar.zho.setText(null);
                    dVar.pxy.setText(null);
                    dVar.raP.setImageDrawable(null);
                    dVar.zbS.setVisibility(8);
                    dVar.zbR.setVisibility(8);
                    dVar.zhp.setVisibility(8);
                } else {
                    u.um(biVar.field_imgPath);
                }
            }
            ImageView imageView = dVar.zbS;
            e eVar = new e(biVar, aVar.dFx(), i, biVar.field_talker);
            eVar.klY = 4;
            imageView.setTag(eVar);
            dVar.zbS.setOnClickListener(onClickListener);
            imageView = dVar.zbR;
            eVar = new e(biVar, aVar.dFx(), i, biVar.field_talker);
            eVar.klY = 3;
            imageView.setTag(eVar);
            dVar.zbR.setOnClickListener(onClickListener);
            View view = dVar.jPL;
            eVar = new e(biVar, aVar.dFx(), i, biVar.field_talker);
            eVar.klY = 2;
            view.setTag(eVar);
            dVar.jPL.setOnClickListener(onClickListener);
            dVar.jPL.setOnLongClickListener(onLongClickListener);
            dVar.jPL.setOnTouchListener(((h) aVar.aF(h.class)).dCZ());
            AppMethodBeat.o(33353);
        }
    }

    protected static class e extends ay {
        int klY;

        public e(bi biVar, boolean z, int i, String str) {
            super(biVar, z, i, str, 0);
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private c zhl;

        private c dHr() {
            AppMethodBeat.i(33340);
            if (this.zhl == null) {
                this.zhl = new c(this.yJI);
            }
            c cVar = this.zhl;
            AppMethodBeat.o(33340);
            return cVar;
        }

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 43) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33341);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.nk);
                view.setTag(new d().z(view, false));
            }
            AppMethodBeat.o(33341);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33342);
            this.yJI = aVar2;
            d dVar = (d) aVar;
            d.a(dVar, biVar, false, i, aVar2, dHr(), c(aVar2));
            if (c.dHm()) {
                s ut = u.ut(biVar.field_imgPath);
                if (ut != null && ut.status == 199 && c.a((h) aVar2.aF(h.class), biVar.field_msgId)) {
                    if (dVar.zci != null) {
                        dVar.zci.setVisibility(0);
                        AppMethodBeat.o(33342);
                        return;
                    }
                } else if (dVar.zci != null) {
                    dVar.zci.setVisibility(8);
                }
            }
            AppMethodBeat.o(33342);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33343);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                if (view == null) {
                    AppMethodBeat.o(33343);
                    return false;
                }
                int i = ((ay) view.getTag()).position;
                s uf = o.all().uf(biVar.field_imgPath);
                MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.string.amb));
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
                        contextMenu.add(i, 107, 0, view.getContext().getString(R.string.dr1));
                    }
                }
                if (uf != null && (uf.status == 199 || uf.status == 199)) {
                    if (com.tencent.mm.bp.d.afj("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                    }
                    dq dqVar = new dq();
                    dqVar.cxc.cvx = biVar.field_msgId;
                    com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                    if (dqVar.cxd.cwB) {
                        contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                    }
                    if (!biVar.drC() && ((biVar.bws() || biVar.bwt()) && c.a(biVar, this.yJI) && ((uf.status == 199 || uf.status == 199 || biVar.dJz == 1) && c.arB(biVar.field_talker)))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
                    }
                    if (f.aez() && !this.yJI.dFy()) {
                        contextMenu.add(i, 114, 0, view.getContext().getString(R.string.am3));
                    }
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am8));
                }
            }
            AppMethodBeat.o(33343);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33344);
            ((ai) aVar.aF(ai.class)).a(menuItem, biVar);
            AppMethodBeat.o(33344);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33345);
            dHr().onClick(view);
            AppMethodBeat.o(33345);
            return true;
        }
    }

    public static class c extends com.tencent.mm.ui.chatting.s.e {
        public static boolean yWS = false;

        public c(com.tencent.mm.ui.chatting.d.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33347);
            ay ayVar = (ay) view.getTag();
            com.tencent.mm.modelstat.b.fRa.F(ayVar.cKd);
            e eVar = (e) ayVar;
            com.tencent.mm.modelstat.a.a(eVar.cKd, com.tencent.mm.modelstat.a.a.Click);
            int i;
            if (2 != eVar.klY) {
                bi biVar2 = eVar.cKd;
                if (biVar2.field_isSend == 0) {
                    bi biVar3 = eVar.cKd;
                    s ut = u.ut(biVar3.field_imgPath);
                    ab.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + ut.status + " is sender:" + biVar3.field_isSend);
                    switch (eVar.klY) {
                        case 3:
                            i(ut);
                            break;
                        case 4:
                            aw.ZK();
                            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                com.tencent.mm.ui.base.t.hO(this.yJI.yTx.getContext());
                                break;
                            } else {
                                u.uq(biVar3.field_imgPath);
                                break;
                            }
                    }
                }
                if (biVar2.field_isSend == 1) {
                    biVar2 = eVar.cKd;
                    if (biVar2 == null) {
                        ab.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
                        AppMethodBeat.o(33347);
                        return;
                    }
                    s uf = o.all().uf(biVar2.field_imgPath);
                    if (uf == null) {
                        ab.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", biVar2.field_imgPath);
                        AppMethodBeat.o(33347);
                        return;
                    }
                    i = uf.status;
                    ab.i("MicroMsg.DesignerClickListener", " videoSendEvent status : ".concat(String.valueOf(i)));
                    String string;
                    switch (eVar.klY) {
                        case 3:
                            aw.ZK();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                if (i != 113) {
                                    if (!uf.alx()) {
                                        biVar2.dtJ();
                                        aw.ZK();
                                        com.tencent.mm.model.c.XO().a(biVar2.field_msgId, biVar2);
                                        if (uf.status != com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX) {
                                            u.uo(biVar2.field_imgPath);
                                            break;
                                        }
                                        u.us(biVar2.field_imgPath);
                                        AppMethodBeat.o(33347);
                                        return;
                                    }
                                    ab.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
                                    string = this.yJI.yTx.getContext().getString(R.string.f15);
                                    if (i == ErrorCode.NEEDDOWNLOAD_3) {
                                        string = this.yJI.yTx.getContext().getString(R.string.f15);
                                    } else if (i == 141) {
                                        string = this.yJI.yTx.getContext().getString(R.string.f16);
                                    } else if (i == 140) {
                                        string = this.yJI.yTx.getContext().getString(R.string.f14);
                                    }
                                    com.tencent.mm.ui.base.h.b(this.yJI.yTx.getContext(), string, this.yJI.yTx.getContext().getString(R.string.ewj), true);
                                    AppMethodBeat.o(33347);
                                    return;
                                }
                                ab.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
                                i(uf);
                                AppMethodBeat.o(33347);
                                return;
                            }
                            com.tencent.mm.ui.base.t.hO(this.yJI.yTx.getContext());
                            AppMethodBeat.o(33347);
                            return;
                        case 4:
                            aw.ZK();
                            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                com.tencent.mm.ui.base.t.hO(this.yJI.yTx.getContext());
                                AppMethodBeat.o(33347);
                                return;
                            } else if (i == 112) {
                                ab.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
                                u.uq(biVar2.field_imgPath);
                                AppMethodBeat.o(33347);
                                return;
                            } else {
                                string = biVar2.field_imgPath;
                                uf = u.ut(string);
                                if (uf == null) {
                                    ab.e("MicroMsg.VideoLogic", "ERR:" + g.Mq() + " getinfo failed: " + string);
                                    g.getLine();
                                } else if (uf.status == 104 || uf.status == 103) {
                                    uf.status = 105;
                                    uf.fXb = bo.anT();
                                    uf.bJt = ActUtil.HEIGHT;
                                    if (!u.f(uf)) {
                                        ab.e("MicroMsg.VideoLogic", "ERR:" + g.Mq() + " update failed: " + string);
                                        g.getLine();
                                    }
                                } else {
                                    ab.e("MicroMsg.VideoLogic", "ERR:" + g.Mq() + " get status failed: " + string + " status:" + uf.status);
                                    g.getLine();
                                }
                                ab.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
                                qc qcVar = new qc();
                                qcVar.cMs.csG = biVar2;
                                com.tencent.mm.sdk.b.a.xxA.m(qcVar);
                                AppMethodBeat.o(33347);
                                return;
                            }
                    }
                }
                AppMethodBeat.o(33347);
            } else if (com.tencent.mm.r.a.bJ(this.yJI.yTx.getContext()) || com.tencent.mm.r.a.bH(this.yJI.yTx.getContext())) {
                ab.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
                AppMethodBeat.o(33347);
            } else {
                int height;
                String str;
                Bundle bundle;
                bi biVar4 = eVar.cKd;
                int[] iArr = new int[2];
                i = 0;
                if (view != null) {
                    view.getLocationInWindow(iArr);
                    i = view.getWidth();
                    height = view.getHeight();
                } else {
                    height = 0;
                }
                long j = biVar4.field_msgId;
                long j2 = biVar4.field_msgSvrId;
                String str2 = eVar.userName;
                String str3 = eVar.chatroomName;
                Intent intent = new Intent(this.yJI.yTx.getContext(), ImageGalleryUI.class);
                intent.putExtra("show_search_chat_content_result", ((z) this.yJI.aF(z.class)).dES());
                intent.putExtra("img_gallery_msg_id", j);
                intent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.c.b.d) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm());
                intent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.c.b.d) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDz());
                intent.putExtra("img_gallery_msg_svr_id", j2);
                intent.putExtra("img_gallery_talker", str2);
                intent.putExtra("img_gallery_chatroom_name", str3);
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", i);
                intent.putExtra("img_gallery_height", height);
                intent.putExtra("img_gallery_enter_from_chatting_ui", ((z) this.yJI.aF(z.class)).dEN());
                str3 = this.yJI.getTalkerUserName();
                String dFu = biVar4.field_isSend == 1 ? this.yJI.dFu() : str2;
                Bundle bundle2 = new Bundle();
                if (this.yJI.dFx()) {
                    str = "stat_scene";
                    height = 2;
                    bundle = bundle2;
                } else {
                    str = "stat_scene";
                    if (com.tencent.mm.model.t.mZ(str3)) {
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
                if (biVar4.bwt() && eVar.userName != null) {
                    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.EnterFullScreen, biVar4);
                    if (eVar.userName.toLowerCase().endsWith("@chatroom")) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(11444, Integer.valueOf(2));
                        AppMethodBeat.o(33347);
                        return;
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.e(11444, Integer.valueOf(1));
                }
                AppMethodBeat.o(33347);
            }
        }

        private void i(final s sVar) {
            AppMethodBeat.i(33348);
            aw.ZK();
            if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                com.tencent.mm.ui.base.t.hO(this.yJI.yTx.getContext());
                AppMethodBeat.o(33348);
            } else if (sVar.status == com.tencent.mm.plugin.appbrand.jsapi.k.o.CTRL_INDEX) {
                u.ur(sVar.getFileName());
                AppMethodBeat.o(33348);
            } else if (com.tencent.mm.network.ab.ch(this.yJI.yTx.getContext()) || yWS) {
                u.up(sVar.getFileName());
                AppMethodBeat.o(33348);
            } else {
                yWS = true;
                com.tencent.mm.ui.base.h.a(this.yJI.yTx.getContext(), (int) R.string.f17, (int) R.string.tz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(33346);
                        c.arK(sVar.getFileName());
                        AppMethodBeat.o(33346);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(33348);
            }
        }

        static /* synthetic */ void arK(String str) {
            AppMethodBeat.i(33349);
            u.up(str);
            AppMethodBeat.o(33349);
        }
    }

    public static class a extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private c zhl;

        private c dHr() {
            AppMethodBeat.i(33334);
            if (this.zhl == null) {
                this.zhl = new c(this.yJI);
            }
            c cVar = this.zhl;
            AppMethodBeat.o(33334);
            return cVar;
        }

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 43) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33335);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mm);
                view.setTag(new d().z(view, true));
            }
            AppMethodBeat.o(33335);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33336);
            this.yJI = aVar2;
            d dVar = (d) aVar;
            d.a(dVar, biVar, true, i, aVar2, dHr(), c(aVar2));
            String str2 = biVar.dJv;
            if (str2 == null || str2.length() == 0) {
                dVar.zbU.setVisibility(8);
                AppMethodBeat.o(33336);
                return;
            }
            dVar.zbU.setVisibility(0);
            b(aVar2, (View) dVar.zbU, (Object) ay.arL(str2));
            AppMethodBeat.o(33336);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33337);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                int i = ((ay) view.getTag()).position;
                s uf = o.all().uf(biVar.field_imgPath);
                contextMenu.add(i, 130, 0, view.getContext().getString(R.string.amb));
                contextMenu.add(i, 107, 0, view.getContext().getString(R.string.dr1));
                if (com.tencent.mm.bp.d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                }
                dq dqVar = new dq();
                dqVar.cxc.cvx = biVar.field_msgId;
                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                if (dqVar.cxd.cwB) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                }
                if (uf != null && ((uf.status == 199 || uf.status == 199) && f.aez() && !this.yJI.dFy())) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.string.am3));
                }
                if (bh.o(biVar)) {
                    contextMenu.clear();
                    contextMenu.add(i, 130, 0, view.getContext().getString(R.string.amb));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am8));
                }
            }
            AppMethodBeat.o(33337);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33338);
            ((ai) aVar.aF(ai.class)).a(menuItem, biVar);
            AppMethodBeat.o(33338);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33339);
            dHr().onClick(view);
            AppMethodBeat.o(33339);
            return true;
        }
    }
}
