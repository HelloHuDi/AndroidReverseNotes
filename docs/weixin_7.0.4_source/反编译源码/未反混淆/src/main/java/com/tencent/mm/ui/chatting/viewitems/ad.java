package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.e;
import com.tencent.mm.at.f;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.c.b.aa;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.s.n;
import java.util.Map;

public final class ad {

    public static class b extends c implements n {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private c zfW;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && (i == 3 || i == 23 || i == 13 || i == 39 || i == 33)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33235);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.ni);
                view.setTag(new d().z(view, false));
            }
            AppMethodBeat.o(33235);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            boolean z;
            int i2;
            View view;
            AppMethodBeat.i(33236);
            this.yJI = aVar2;
            aVar = (d) aVar;
            boolean containsKey = com.tencent.mm.at.n.ahb().fFO.containsKey(Long.valueOf(biVar.field_msgId));
            e w = o.ahl().w(biVar);
            if (w == null || containsKey) {
                z = false;
            } else {
                boolean z2;
                if (com.tencent.mm.at.n.ahb().fL(w.fDy)) {
                    com.tencent.mm.at.n.d fM = com.tencent.mm.at.n.ahb().fM(w.fDy);
                    i2 = (int) fM.cET;
                    z2 = i2 == 0 ? true : ((int) fM.xb) == i2 && i2 != 0;
                } else {
                    z2 = f.b(w);
                }
                z = z2;
            }
            g ahl = o.ahl();
            ImageView imageView = aVar.zdN;
            String str2 = biVar.field_imgPath;
            float density = com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext());
            int i3 = biVar.dJw;
            int i4 = biVar.dJx;
            ImageView imageView2 = aVar.zeh;
            if (z) {
                view = null;
            } else {
                view = aVar.zfZ;
            }
            if (!(ahl.a(imageView, str2, density, i3, i4, imageView2, (int) R.drawable.hj, 0, view) && this.kuU)) {
                aVar.zdN.setImageDrawable(com.tencent.mm.bz.a.g(aVar2.yTx.getContext(), R.drawable.hj));
            }
            if (w != null || containsKey) {
                Object obj = (z || biVar.field_status == 5) ? 1 : null;
                if (containsKey) {
                    aVar.zfY.setText("0%");
                } else {
                    int i5;
                    TextView textView = aVar.zfY;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (w != null) {
                        com.tencent.mm.at.n.d fM2;
                        i5 = w.frO;
                        i2 = w.offset;
                        if (com.tencent.mm.at.n.ahb().fL(w.fDy)) {
                            fM2 = com.tencent.mm.at.n.ahb().fM(w.fDy);
                            i5 = (int) fM2.cET;
                            i2 = (int) fM2.xb;
                        }
                        if (w.agQ()) {
                            e ly = o.ahl().ly(w.fDJ);
                            if (com.tencent.mm.at.n.ahb().fL((long) w.fDJ)) {
                                fM2 = com.tencent.mm.at.n.ahb().fM((long) w.fDJ);
                                i5 = (int) fM2.cET;
                                i2 = (int) fM2.xb;
                            } else {
                                i5 = ly.frO;
                                i2 = ly.offset;
                            }
                        }
                        if (i5 > 0) {
                            i5 = i2 >= i5 ? 100 : (i2 * 100) / i5;
                            textView.setText(stringBuilder.append(i5).append("%").toString());
                        }
                    }
                    i5 = 0;
                    textView.setText(stringBuilder.append(i5).append("%").toString());
                }
                aVar.pyf.setVisibility(obj != null ? 8 : 0);
                aVar.zfY.setVisibility(obj != null ? 8 : 0);
                aVar.zfZ.setVisibility(obj != null ? 8 : 0);
            } else {
                aVar.zfZ.setVisibility(8);
                aVar.pyf.setVisibility(8);
                aVar.zfY.setVisibility(8);
            }
            aVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, biVar.field_talker, 0));
            View view2 = aVar.jPL;
            if (this.zfW == null) {
                this.zfW = new c(this.yJI, this);
            }
            view2.setOnClickListener(this.zfW);
            aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            aVar.jPL.setOnLongClickListener(c(aVar2));
            aVar.zdN.setContentDescription(aVar2.yTx.getMMResources().getString(R.string.al_));
            if (c.dHm()) {
                aVar.pyf.setVisibility(8);
                ab.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", Long.valueOf(biVar.field_msgId), Integer.valueOf(biVar.field_status));
                if (c.dHm()) {
                    if (biVar.field_status == 2) {
                        if (c.a((h) aVar2.aF(h.class), biVar.field_msgId)) {
                            if (aVar.zci != null) {
                                aVar.zci.setVisibility(0);
                            }
                        }
                    }
                    if (aVar.zci != null) {
                        aVar.zci.setVisibility(8);
                    }
                }
            }
            a(i, aVar, biVar, aVar2.dFu(), aVar2.dFx(), aVar2, (n) this);
            ad.a(biVar, aVar2, aVar);
            AppMethodBeat.o(33236);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33237);
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable() && view != null) {
                int i = ((ay) view.getTag()).position;
                e eVar = null;
                if (biVar.field_msgId > 0) {
                    eVar = o.ahl().fJ(biVar.field_msgId);
                }
                if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
                    eVar = o.ahl().fI(biVar.field_msgSvrId);
                }
                if (eVar != null && eVar.agQ() && eVar.frO == 0) {
                    eVar = o.ahl().ly(eVar.fDJ);
                }
                contextMenu.add(i, 110, 0, view.getContext().getString(R.string.dr1));
                if (biVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.string.anv));
                }
                if (com.tencent.mm.aj.f.aey() && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.string.am3));
                }
                if (com.tencent.mm.bp.d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                }
                dq dqVar = new dq();
                dqVar.cxc.cvx = biVar.field_msgId;
                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                if (dqVar.cxd.cwB || com.tencent.mm.pluginsdk.model.app.g.ad(this.yJI.yTx.getContext(), biVar.getType())) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                }
                if (eVar.status != -1) {
                    int width;
                    int height;
                    MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(R.string.al9));
                    int[] iArr = new int[2];
                    if (view != null) {
                        width = view.getWidth();
                        height = view.getHeight();
                        view.getLocationInWindow(iArr);
                    } else {
                        height = 0;
                        width = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    add.setIntent(intent);
                }
                if (!biVar.drC() && biVar.drE() && ((biVar.field_status == 2 || biVar.dJz == 1) && c.a(biVar, this.yJI) && c.arB(biVar.field_talker) && !com.tencent.mm.storage.ad.mg(this.yJI.getTalkerUserName()))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.string.ami));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am6));
                }
            }
            AppMethodBeat.o(33237);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33238);
            if (100 == menuItem.getItemId()) {
                ad.b(biVar, aVar);
            } else if (131 == menuItem.getItemId()) {
                ad.b(aVar, menuItem, biVar);
            } else {
                ((aa) aVar.aF(aa.class)).a(menuItem, biVar);
            }
            AppMethodBeat.o(33238);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public static void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, int i2) {
            AppMethodBeat.i(33239);
            int i3 = i2 > 0 ? i >= i2 ? 100 : (int) ((((long) i) * 100) / ((long) i2)) : 0;
            d dVar = (d) aVar;
            if (i3 < 100 || dVar.zfY.getVisibility() == 0) {
                dVar.zfY.setText(i3 + "%");
                if (c.dHm()) {
                    dVar.pyf.setVisibility(8);
                } else {
                    dVar.pyf.setVisibility(0);
                }
                dVar.zfY.setVisibility(0);
                dVar.zfZ.setVisibility(0);
                AppMethodBeat.o(33239);
                return;
            }
            AppMethodBeat.o(33239);
        }

        public static void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, boolean z) {
            AppMethodBeat.i(33240);
            if (z && (aVar instanceof d)) {
                d dVar = (d) aVar;
                dVar.pyf.setVisibility(4);
                dVar.zfY.setVisibility(4);
                dVar.zfZ.setVisibility(4);
            }
            AppMethodBeat.o(33240);
        }

        public final void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33241);
            biVar.dtJ();
            aw.ZK();
            com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
            ((aa) aVar.aF(aa.class)).bb(biVar);
            AppMethodBeat.o(33241);
        }
    }

    public static class c extends s.e {
        private c zfX;

        public c(com.tencent.mm.ui.chatting.d.a aVar, c cVar) {
            super(aVar);
            this.zfX = cVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            e eVar;
            Map z;
            com.tencent.mm.af.j.b md;
            com.tencent.mm.pluginsdk.model.app.f bT;
            AppMethodBeat.i(33242);
            ay ayVar = (ay) view.getTag();
            com.tencent.mm.modelstat.b.fRa.F(ayVar.cKd);
            bi biVar2 = ayVar.cKd;
            com.tencent.mm.modelstat.a.a(biVar2, com.tencent.mm.modelstat.a.a.Click);
            int[] iArr = new int[2];
            int i = 0;
            int i2 = 0;
            if (view != null) {
                view.getLocationInWindow(iArr);
                i = view.getWidth();
                i2 = view.getHeight();
            }
            if (biVar2.field_isSend == 1) {
                e fJ = o.ahl().fJ(biVar2.field_msgId);
                if (fJ.fDy != 0) {
                    eVar = fJ;
                    z = br.z(biVar2.field_content, "msg");
                    if (z != null) {
                        bo.getLong((String) z.get(".msg.img.$hdlength"), 0);
                    }
                    aw.ZK();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        t.hO(this.yJI.yTx.getContext());
                    } else if (biVar2.field_isSend == 1) {
                        if (com.tencent.mm.vfs.e.ct(o.ahl().q(f.c(eVar), "", ""))) {
                            a(this.yJI, biVar2, eVar.fDH, eVar.cKK, ayVar.userName, ayVar.chatroomName, iArr, i, i2, false);
                        } else {
                            if (com.tencent.mm.vfs.e.ct(o.ahl().q(eVar.fDz, "", ""))) {
                                a(this.yJI, biVar2, eVar.fDH, eVar.cKK, ayVar.userName, ayVar.chatroomName, iArr, i, i2, false);
                            } else {
                                a(biVar2.field_msgId, biVar2.field_msgSvrId, ayVar.userName, ayVar.chatroomName, iArr, i, i2);
                            }
                        }
                    } else {
                        if (eVar.agP()) {
                            String str = eVar.fDz;
                            if (eVar.agQ()) {
                                e a = f.a(eVar);
                                if (a != null && a.fDy > 0 && a.agP() && com.tencent.mm.vfs.e.ct(o.ahl().q(a.fDz, "", ""))) {
                                    str = a.fDz;
                                }
                            }
                            if (com.tencent.mm.vfs.e.ct(o.ahl().q(str, "", ""))) {
                                a(this.yJI, biVar2, eVar.fDH, eVar.cKK, ayVar.userName, ayVar.chatroomName, iArr, i, i2, false);
                            } else {
                                ab.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", Long.valueOf(eVar.fDy));
                                eVar.sb("SERVERID://" + biVar2.field_msgSvrId);
                                eVar.bJt = 16;
                                eVar.lt(0);
                                eVar.bJt = 8;
                                eVar.setStatus(0);
                                eVar.bJt = 256;
                                o.ahl().a(Long.valueOf(eVar.fDy), eVar);
                            }
                        } else if (eVar.status == -1) {
                            ab.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", Long.valueOf(eVar.fDy));
                            eVar.setStatus(0);
                            eVar.bJt = 256;
                            o.ahl().a(Long.valueOf(eVar.fDy), eVar);
                        }
                        a(biVar2.field_msgId, biVar2.field_msgSvrId, ayVar.userName, ayVar.chatroomName, iArr, i, i2);
                    }
                    md = com.tencent.mm.af.j.b.md(biVar.field_content);
                    if (!(md == null || bo.isNullOrNil(md.appId) || this.zfX == null)) {
                        bT = com.tencent.mm.pluginsdk.model.app.g.bT(md.appId, false);
                        if (bT != null) {
                            c.a(aVar, md, this.zfX instanceof a ? c.d(aVar, biVar) : r.Yz(), bT, biVar.field_msgSvrId, aVar.getTalkerUserName());
                        }
                    }
                    AppMethodBeat.o(33242);
                }
            }
            eVar = o.ahl().fI(biVar2.field_msgSvrId);
            z = br.z(biVar2.field_content, "msg");
            if (z != null) {
            }
            aw.ZK();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
            }
            md = com.tencent.mm.af.j.b.md(biVar.field_content);
            bT = com.tencent.mm.pluginsdk.model.app.g.bT(md.appId, false);
            if (bT != null) {
            }
            AppMethodBeat.o(33242);
        }

        private void a(long j, long j2, String str, String str2, int[] iArr, int i, int i2) {
            String str3;
            int i3;
            Bundle bundle;
            AppMethodBeat.i(33243);
            Intent intent = new Intent(this.yJI.yTx.getContext(), ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", j);
            intent.putExtra("show_search_chat_content_result", ((z) this.yJI.aF(z.class)).dES());
            intent.putExtra("img_gallery_msg_svr_id", j2);
            intent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.c.b.d) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm());
            intent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.c.b.d) this.yJI.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDz());
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i);
            intent.putExtra("img_gallery_height", i2);
            intent.putExtra("img_gallery_enter_from_chatting_ui", ((z) this.yJI.aF(z.class)).dEN());
            intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.ad.mg(str));
            String talkerUserName = this.yJI.getTalkerUserName();
            Bundle bundle2 = new Bundle();
            if (this.yJI.dFx()) {
                str3 = "stat_scene";
                i3 = 2;
                bundle = bundle2;
            } else {
                str3 = "stat_scene";
                if (com.tencent.mm.model.t.mZ(talkerUserName)) {
                    i3 = 7;
                    bundle = bundle2;
                } else {
                    i3 = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str3, i3);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
            bundle2.putString("stat_chat_talker_username", talkerUserName);
            bundle2.putString("stat_send_msg_user", str);
            intent.putExtra("_stat_obj", bundle2);
            intent.putExtra("img_gallery_session_id", c(j2, str, talkerUserName));
            this.yJI.startActivity(intent);
            this.yJI.yTx.overridePendingTransition(0, 0);
            AppMethodBeat.o(33243);
        }

        public static void a(com.tencent.mm.ui.chatting.d.a aVar, bi biVar, long j, long j2, String str, String str2, int[] iArr, int i, int i2, boolean z) {
            String str3;
            int i3;
            Bundle bundle;
            AppMethodBeat.i(33244);
            Intent intent = new Intent(aVar.yTx.getContext(), ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", j);
            intent.putExtra("img_gallery_msg_svr_id", j2);
            intent.putExtra("show_search_chat_content_result", ((z) aVar.aF(z.class)).dES());
            intent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDm());
            intent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDz());
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i);
            intent.putExtra("img_gallery_height", i2);
            intent.putExtra("img_gallery_enter_from_chatting_ui", ((z) aVar.aF(z.class)).dEN());
            intent.putExtra("img_gallery_enter_PhotoEditUI", z);
            intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", com.tencent.mm.storage.ad.mg(str));
            String talkerUserName = aVar.getTalkerUserName();
            if (biVar.field_isSend == 1) {
                str = aVar.dFu();
            }
            Bundle bundle2 = new Bundle();
            if (aVar.dFw()) {
                str3 = "stat_scene";
                i3 = 2;
                bundle = bundle2;
            } else {
                str3 = "stat_scene";
                if (com.tencent.mm.model.t.mZ(talkerUserName)) {
                    i3 = 7;
                    bundle = bundle2;
                } else {
                    i3 = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str3, i3);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
            bundle2.putString("stat_chat_talker_username", talkerUserName);
            bundle2.putString("stat_send_msg_user", str);
            intent.putExtra("_stat_obj", bundle2);
            intent.putExtra("img_gallery_session_id", c(j2, str, talkerUserName));
            aVar.yTx.startActivity(intent);
            aVar.yTx.overridePendingTransition(0, 0);
            AppMethodBeat.o(33244);
        }

        private static String c(long j, String str, String str2) {
            AppMethodBeat.i(33245);
            String nW = v.nW(String.valueOf(j));
            com.tencent.mm.model.v.b y = v.Zp().y(nW, true);
            y.j("preUsername", str);
            y.j("preChatName", str2);
            AppMethodBeat.o(33245);
            return nW;
        }
    }

    static class d extends com.tencent.mm.ui.chatting.viewitems.c.a {
        TextView moL;
        ProgressBar pyf;
        ImageView zci;
        ImageView zdN;
        ImageView zeh;
        TextView zfY;
        View zfZ;

        public final com.tencent.mm.ui.chatting.viewitems.c.a z(View view, boolean z) {
            AppMethodBeat.i(33246);
            super.eP(view);
            this.enf = (TextView) view.findViewById(R.id.ag);
            this.zdN = (ImageView) view.findViewById(R.id.aqy);
            this.moo = (CheckBox) view.findViewById(R.id.a_);
            this.iVh = view.findViewById(R.id.af);
            this.zfZ = view.findViewById(R.id.arz);
            if (z) {
                this.qkY = (TextView) view.findViewById(R.id.od);
                this.pyf = (ProgressBar) view.findViewById(R.id.as0);
            } else {
                this.pyf = (ProgressBar) view.findViewById(R.id.at6);
                this.zfY = (TextView) view.findViewById(R.id.atd);
                this.qkY = (TextView) view.findViewById(R.id.od);
                this.zci = (ImageView) view.findViewById(R.id.at7);
            }
            this.zeh = (ImageView) view.findViewById(R.id.aq_);
            this.moL = (TextView) view.findViewById(R.id.aq0);
            AppMethodBeat.o(33246);
            return this;
        }
    }

    public static class a extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private c zfW;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || (i != 39 && i != 3 && i != 23 && i != 13 && i != 33)) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(33229);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.mk);
                view.setTag(new d().z(view, true));
            }
            AppMethodBeat.o(33229);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            AppMethodBeat.i(33230);
            this.yJI = aVar2;
            ((j) aVar2.aF(j.class)).bf(biVar);
            d dVar = (d) aVar;
            boolean a = o.ahl().a(dVar.zdN, biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(aVar2.yTx.getContext()), biVar.dJw, biVar.dJx, dVar.zeh, (int) R.drawable.hj, 1, null);
            dVar.zfZ.setVisibility(0);
            dVar.pyf.setVisibility(8);
            if (!(a || this.kuU)) {
                dVar.zdN.setImageBitmap(BitmapFactory.decodeResource(aVar2.yTx.getMMResources(), R.drawable.hj));
            }
            String str2 = null;
            if (aVar2.dFx()) {
                str2 = biVar.field_talker;
            }
            dVar.jPL.setTag(new ay(biVar, aVar2.dFx(), i, str, str2));
            View view = dVar.jPL;
            if (this.zfW == null) {
                this.zfW = new c(this.yJI, this);
            }
            view.setOnClickListener(this.zfW);
            dVar.jPL.setOnLongClickListener(c(aVar2));
            dVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            ad.a(biVar, aVar2, dVar);
            AppMethodBeat.o(33230);
        }

        /* Access modifiers changed, original: protected|final */
        public final boolean b(com.tencent.mm.ui.chatting.d.a aVar) {
            AppMethodBeat.i(33231);
            boolean dFx = aVar.dFx();
            AppMethodBeat.o(33231);
            return dFx;
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(33232);
            aw.ZK();
            if (!(!com.tencent.mm.model.c.isSDCardAvailable() || view == null || biVar == null)) {
                int i = ((ay) view.getTag()).position;
                e eVar = null;
                if (biVar.field_msgId > 0) {
                    eVar = o.ahl().fJ(biVar.field_msgId);
                }
                if ((eVar == null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
                    eVar = o.ahl().fI(biVar.field_msgSvrId);
                }
                contextMenu.add(i, 110, 0, view.getContext().getString(R.string.dr1));
                if (com.tencent.mm.aj.f.aey() && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.string.am3));
                }
                if (com.tencent.mm.bp.d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.string.dcq));
                }
                dq dqVar = new dq();
                dqVar.cxc.cvx = biVar.field_msgId;
                com.tencent.mm.sdk.b.a.xxA.m(dqVar);
                if (dqVar.cxd.cwB || com.tencent.mm.pluginsdk.model.app.g.ad(this.yJI.yTx.getContext(), biVar.getType())) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(R.string.amc));
                }
                if (!(eVar == null || eVar.status == -1)) {
                    int width;
                    int height;
                    MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(R.string.al9));
                    int[] iArr = new int[2];
                    if (view != null) {
                        width = view.getWidth();
                        height = view.getHeight();
                        view.getLocationInWindow(iArr);
                    } else {
                        height = 0;
                        width = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    add.setIntent(intent);
                }
                if (bh.o(biVar)) {
                    contextMenu.clear();
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.string.am6));
                }
            }
            AppMethodBeat.o(33232);
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(33233);
            if (100 == menuItem.getItemId()) {
                ad.b(biVar, aVar);
            } else if (131 == menuItem.getItemId()) {
                ad.b(aVar, menuItem, biVar);
            } else {
                ((aa) aVar.aF(aa.class)).a(menuItem, biVar);
            }
            AppMethodBeat.o(33233);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            return false;
        }

        public static void a(Context context, com.tencent.mm.ui.chatting.viewitems.c.a aVar, bi biVar, boolean z) {
            AppMethodBeat.i(33234);
            if (true != z) {
                AppMethodBeat.o(33234);
                return;
            }
            if (aVar instanceof d) {
                d dVar = (d) aVar;
                o.ahl().a(dVar.zdN, biVar.field_imgPath, com.tencent.mm.bz.a.getDensity(context), biVar.dJw, biVar.dJx, dVar.zeh, (int) R.drawable.abt, 1, null);
            }
            AppMethodBeat.o(33234);
        }
    }

    static /* synthetic */ void a(bi biVar, com.tencent.mm.ui.chatting.d.a aVar, d dVar) {
        AppMethodBeat.i(33247);
        com.tencent.mm.af.j.b md = com.tencent.mm.af.j.b.md(biVar.field_content);
        if (md == null || bo.isNullOrNil(md.appId)) {
            dVar.moL.setVisibility(8);
            AppMethodBeat.o(33247);
            return;
        }
        String str = md.appId;
        com.tencent.mm.pluginsdk.model.app.f dX = com.tencent.mm.pluginsdk.model.app.g.dX(str, md.axy);
        if (dX != null) {
            c.b(aVar, md, biVar);
        }
        String str2 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? md.appName : dX.field_appName;
        if (c.dg(str2)) {
            dVar.moL.setText(com.tencent.mm.pluginsdk.model.app.g.b(aVar.yTx.getContext(), dX, str2));
            dVar.moL.setVisibility(0);
            if (dX == null || !dX.xy()) {
                c.a(aVar, dVar.moL, str);
            } else {
                c.a(aVar, dVar.moL, biVar, md, dX.field_packageName, biVar.field_msgSvrId);
            }
            c.a(aVar, dVar.moL, str);
            AppMethodBeat.o(33247);
            return;
        }
        dVar.moL.setVisibility(8);
        AppMethodBeat.o(33247);
    }

    static /* synthetic */ void b(bi biVar, com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(33248);
        com.tencent.mm.af.j.b md = com.tencent.mm.af.j.b.md(biVar.field_content);
        if (!(md == null || bo.isNullOrNil(md.appId))) {
            com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(md.appId, false);
            if (bT != null && bT.xy()) {
                com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
                if (bDb != null) {
                    String str;
                    int i = aVar.dFx() ? 2 : 1;
                    String d = c.d(aVar, biVar);
                    Context context = aVar.yTx.getContext();
                    String str2 = md.appId;
                    if (bT == null) {
                        str = null;
                    } else {
                        str = bT.field_packageName;
                    }
                    bDb.a(context, str2, str, d, md.type, md.mediaTagName, i);
                }
            }
        }
        AppMethodBeat.o(33248);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean b(com.tencent.mm.ui.chatting.d.a aVar, MenuItem menuItem, bi biVar) {
        AppMethodBeat.i(33249);
        switch (menuItem.getItemId()) {
            case 131:
                ab.i("MicroMsg.ChattingItemImg", "long click go to photo eidt");
                Intent intent = menuItem.getIntent();
                if (intent == null) {
                    ab.e("MicroMsg.ChattingItemImg", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                    AppMethodBeat.o(33249);
                    return true;
                }
                Object obj;
                e eVar;
                e fI;
                String q;
                int intExtra = intent.getIntExtra("img_gallery_width", 0);
                int intExtra2 = intent.getIntExtra("img_gallery_height", 0);
                int[] iArr = new int[]{intent.getIntExtra("img_gallery_left", 0), intent.getIntExtra("img_gallery_top", 0)};
                String str = null;
                if (!aVar.dFw()) {
                    if (!((com.tencent.mm.ui.chatting.c.b.d) aVar.aF(com.tencent.mm.ui.chatting.c.b.d.class)).dDn()) {
                        obj = null;
                        if (obj != null) {
                            str = biVar.field_talker;
                        }
                        eVar = null;
                        if (biVar.field_msgId > 0) {
                            eVar = o.ahl().fJ(biVar.field_msgId);
                        }
                        if ((eVar != null || eVar.fDy <= 0) && biVar.field_msgSvrId > 0) {
                            fI = o.ahl().fI(biVar.field_msgSvrId);
                        } else {
                            fI = eVar;
                        }
                        q = fI != null ? "" : o.ahl().q(fI.fDz, "", "");
                        if (fI != null || fI.status == -1 || biVar.field_status == 5) {
                            ab.e("MicroMsg.ChattingItemImg", "raw img not get successfully ,msgId:%s", Long.valueOf(biVar.field_msgId));
                        } else {
                            ab.i("MicroMsg.ChattingItemImg", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", Long.valueOf(biVar.field_msgId), q);
                            c.a(aVar, biVar, biVar.field_msgId, biVar.field_msgSvrId, biVar.field_talker, str, iArr, intExtra, intExtra2, true);
                        }
                        AppMethodBeat.o(33249);
                        return true;
                    }
                }
                obj = 1;
                if (obj != null) {
                }
                eVar = null;
                if (biVar.field_msgId > 0) {
                }
                if (eVar != null) {
                    break;
                }
                fI = o.ahl().fI(biVar.field_msgSvrId);
                if (fI != null) {
                }
                if (fI != null) {
                    break;
                }
                ab.e("MicroMsg.ChattingItemImg", "raw img not get successfully ,msgId:%s", Long.valueOf(biVar.field_msgId));
                AppMethodBeat.o(33249);
                return true;
            default:
                AppMethodBeat.o(33249);
                return false;
        }
    }
}
