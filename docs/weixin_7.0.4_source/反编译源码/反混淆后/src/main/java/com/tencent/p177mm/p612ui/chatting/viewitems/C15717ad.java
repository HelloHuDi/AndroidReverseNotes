package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C42219a;
import com.tencent.p177mm.modelstat.C42219a.C32832a;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32290n;
import com.tencent.p177mm.p190at.C32290n.C32288d;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.chatting.C44318s.C23812e;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.gallery.ImageGalleryUI;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36137j;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44296aa;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.ad */
public final class C15717ad {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ad$b */
    public static class C15714b extends C5378c implements C5365n {
        private C46650a yJI;
        private C15715c zfW;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && (i == 3 || i == 23 || i == 13 || i == 39 || i == 33)) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33235);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969103);
                view.setTag(new C15716d().mo27950z(view, false));
            }
            AppMethodBeat.m2505o(33235);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            boolean z;
            int i2;
            View view;
            AppMethodBeat.m2504i(33236);
            this.yJI = c46650a;
            c5379a = (C15716d) c5379a;
            boolean containsKey = C32290n.ahb().fFO.containsKey(Long.valueOf(c7620bi.field_msgId));
            C25822e w = C32291o.ahl().mo73124w(c7620bi);
            if (w == null || containsKey) {
                z = false;
            } else {
                boolean z2;
                if (C32290n.ahb().mo52999fL(w.fDy)) {
                    C32288d fM = C32290n.ahb().mo53000fM(w.fDy);
                    i2 = (int) fM.cET;
                    z2 = i2 == 0 ? true : ((int) fM.f15015xb) == i2 && i2 != 0;
                } else {
                    z2 = C37478f.m63226b(w);
                }
                z = z2;
            }
            C45160g ahl = C32291o.ahl();
            ImageView imageView = c5379a.zdN;
            String str2 = c7620bi.field_imgPath;
            float density = C1338a.getDensity(c46650a.yTx.getContext());
            int i3 = c7620bi.dJw;
            int i4 = c7620bi.dJx;
            ImageView imageView2 = c5379a.zeh;
            if (z) {
                view = null;
            } else {
                view = c5379a.zfZ;
            }
            if (!(ahl.mo73097a(imageView, str2, density, i3, i4, imageView2, (int) C25738R.drawable.f6539hj, 0, view) && this.kuU)) {
                c5379a.zdN.setImageDrawable(C1338a.m2864g(c46650a.yTx.getContext(), C25738R.drawable.f6539hj));
            }
            if (w != null || containsKey) {
                Object obj = (z || c7620bi.field_status == 5) ? 1 : null;
                if (containsKey) {
                    c5379a.zfY.setText("0%");
                } else {
                    int i5;
                    TextView textView = c5379a.zfY;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (w != null) {
                        C32288d fM2;
                        i5 = w.frO;
                        i2 = w.offset;
                        if (C32290n.ahb().mo52999fL(w.fDy)) {
                            fM2 = C32290n.ahb().mo53000fM(w.fDy);
                            i5 = (int) fM2.cET;
                            i2 = (int) fM2.f15015xb;
                        }
                        if (w.agQ()) {
                            C25822e ly = C32291o.ahl().mo73116ly(w.fDJ);
                            if (C32290n.ahb().mo52999fL((long) w.fDJ)) {
                                fM2 = C32290n.ahb().mo53000fM((long) w.fDJ);
                                i5 = (int) fM2.cET;
                                i2 = (int) fM2.f15015xb;
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
                c5379a.pyf.setVisibility(obj != null ? 8 : 0);
                c5379a.zfY.setVisibility(obj != null ? 8 : 0);
                c5379a.zfZ.setVisibility(obj != null ? 8 : 0);
            } else {
                c5379a.zfZ.setVisibility(8);
                c5379a.pyf.setVisibility(8);
                c5379a.zfY.setVisibility(8);
            }
            c5379a.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, c7620bi.field_talker, 0));
            View view2 = c5379a.jPL;
            if (this.zfW == null) {
                this.zfW = new C15715c(this.yJI, this);
            }
            view2.setOnClickListener(this.zfW);
            c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
            c5379a.zdN.setContentDescription(c46650a.yTx.getMMResources().getString(C25738R.string.al_));
            if (C5378c.dHm()) {
                c5379a.pyf.setVisibility(8);
                C4990ab.m7411d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", Long.valueOf(c7620bi.field_msgId), Integer.valueOf(c7620bi.field_status));
                if (C5378c.dHm()) {
                    if (c7620bi.field_status == 2) {
                        if (C5378c.m8136a((C15612h) c46650a.mo74857aF(C15612h.class), c7620bi.field_msgId)) {
                            if (c5379a.zci != null) {
                                c5379a.zci.setVisibility(0);
                            }
                        }
                    }
                    if (c5379a.zci != null) {
                        c5379a.zci.setVisibility(8);
                    }
                }
            }
            mo11007a(i, c5379a, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            C15717ad.m24019a(c7620bi, c46650a, c5379a);
            AppMethodBeat.m2505o(33236);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33237);
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable() && view != null) {
                int i = ((C40814ay) view.getTag()).position;
                C25822e c25822e = null;
                if (c7620bi.field_msgId > 0) {
                    c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
                }
                if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                    c25822e = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                }
                if (c25822e != null && c25822e.agQ() && c25822e.frO == 0) {
                    c25822e = C32291o.ahl().mo73116ly(c25822e.fDJ);
                }
                contextMenu.add(i, 110, 0, view.getContext().getString(C25738R.string.dr1));
                if (c7620bi.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(C25738R.string.anv));
                }
                if (C17903f.aey() && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(C25738R.string.am3));
                }
                if (C25985d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                }
                C9321dq c9321dq = new C9321dq();
                c9321dq.cxc.cvx = c7620bi.field_msgId;
                C4879a.xxA.mo10055m(c9321dq);
                if (c9321dq.cxd.cwB || C46494g.m87731ad(this.yJI.yTx.getContext(), c7620bi.getType())) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                }
                if (c25822e.status != -1) {
                    int width;
                    int height;
                    MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(C25738R.string.al9));
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
                if (!c7620bi.drC() && c7620bi.drE() && ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker) && !C7616ad.m13549mg(this.yJI.getTalkerUserName()))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am6));
                }
            }
            AppMethodBeat.m2505o(33237);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33238);
            if (100 == menuItem.getItemId()) {
                C15717ad.m24020b(c7620bi, c46650a);
            } else if (131 == menuItem.getItemId()) {
                C15717ad.m24021b(c46650a, menuItem, c7620bi);
            } else {
                ((C44296aa) c46650a.mo74857aF(C44296aa.class)).mo70170a(menuItem, c7620bi);
            }
            AppMethodBeat.m2505o(33238);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public static void m24005a(C5379a c5379a, int i, int i2) {
            AppMethodBeat.m2504i(33239);
            int i3 = i2 > 0 ? i >= i2 ? 100 : (int) ((((long) i) * 100) / ((long) i2)) : 0;
            C15716d c15716d = (C15716d) c5379a;
            if (i3 < 100 || c15716d.zfY.getVisibility() == 0) {
                c15716d.zfY.setText(i3 + "%");
                if (C5378c.dHm()) {
                    c15716d.pyf.setVisibility(8);
                } else {
                    c15716d.pyf.setVisibility(0);
                }
                c15716d.zfY.setVisibility(0);
                c15716d.zfZ.setVisibility(0);
                AppMethodBeat.m2505o(33239);
                return;
            }
            AppMethodBeat.m2505o(33239);
        }

        /* renamed from: a */
        public static void m24006a(C5379a c5379a, boolean z) {
            AppMethodBeat.m2504i(33240);
            if (z && (c5379a instanceof C15716d)) {
                C15716d c15716d = (C15716d) c5379a;
                c15716d.pyf.setVisibility(4);
                c15716d.zfY.setVisibility(4);
                c15716d.zfZ.setVisibility(4);
            }
            AppMethodBeat.m2505o(33240);
        }

        /* renamed from: a */
        public final void mo10991a(C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33241);
            c7620bi.dtJ();
            C9638aw.m17190ZK();
            C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
            ((C44296aa) c46650a.mo74857aF(C44296aa.class)).mo70171bb(c7620bi);
            AppMethodBeat.m2505o(33241);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ad$c */
    public static class C15715c extends C23812e {
        private C5378c zfX;

        public C15715c(C46650a c46650a, C5378c c5378c) {
            super(c46650a);
            this.zfX = c5378c;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0073  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a1  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo10992a(View view, C46650a c46650a, C7620bi c7620bi) {
            C25822e c25822e;
            Map z;
            C8910b md;
            C40439f bT;
            AppMethodBeat.m2504i(33242);
            C40814ay c40814ay = (C40814ay) view.getTag();
            C45457b.fRa.mo73250F(c40814ay.cKd);
            C7620bi c7620bi2 = c40814ay.cKd;
            C42219a.m74510a(c7620bi2, C32832a.Click);
            int[] iArr = new int[2];
            int i = 0;
            int i2 = 0;
            if (view != null) {
                view.getLocationInWindow(iArr);
                i = view.getWidth();
                i2 = view.getHeight();
            }
            if (c7620bi2.field_isSend == 1) {
                C25822e fJ = C32291o.ahl().mo73113fJ(c7620bi2.field_msgId);
                if (fJ.fDy != 0) {
                    c25822e = fJ;
                    z = C5049br.m7595z(c7620bi2.field_content, "msg");
                    if (z != null) {
                        C5046bo.getLong((String) z.get(".msg.img.$hdlength"), 0);
                    }
                    C9638aw.m17190ZK();
                    if (C18628c.isSDCardAvailable()) {
                        C23639t.m36492hO(this.yJI.yTx.getContext());
                    } else if (c7620bi2.field_isSend == 1) {
                        if (C5730e.m8628ct(C32291o.ahl().mo73118q(C37478f.m63227c(c25822e), "", ""))) {
                            C15715c.m24015a(this.yJI, c7620bi2, c25822e.fDH, c25822e.cKK, c40814ay.userName, c40814ay.chatroomName, iArr, i, i2, false);
                        } else {
                            if (C5730e.m8628ct(C32291o.ahl().mo73118q(c25822e.fDz, "", ""))) {
                                C15715c.m24015a(this.yJI, c7620bi2, c25822e.fDH, c25822e.cKK, c40814ay.userName, c40814ay.chatroomName, iArr, i, i2, false);
                            } else {
                                m24014a(c7620bi2.field_msgId, c7620bi2.field_msgSvrId, c40814ay.userName, c40814ay.chatroomName, iArr, i, i2);
                            }
                        }
                    } else {
                        if (c25822e.agP()) {
                            String str = c25822e.fDz;
                            if (c25822e.agQ()) {
                                C25822e a = C37478f.m63225a(c25822e);
                                if (a != null && a.fDy > 0 && a.agP() && C5730e.m8628ct(C32291o.ahl().mo73118q(a.fDz, "", ""))) {
                                    str = a.fDz;
                                }
                            }
                            if (C5730e.m8628ct(C32291o.ahl().mo73118q(str, "", ""))) {
                                C15715c.m24015a(this.yJI, c7620bi2, c25822e.fDH, c25822e.cKK, c40814ay.userName, c40814ay.chatroomName, iArr, i, i2, false);
                            } else {
                                C4990ab.m7417i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", Long.valueOf(c25822e.fDy));
                                c25822e.mo43803sb("SERVERID://" + c7620bi2.field_msgSvrId);
                                c25822e.bJt = 16;
                                c25822e.mo43797lt(0);
                                c25822e.bJt = 8;
                                c25822e.setStatus(0);
                                c25822e.bJt = 256;
                                C32291o.ahl().mo73077a(Long.valueOf(c25822e.fDy), c25822e);
                            }
                        } else if (c25822e.status == -1) {
                            C4990ab.m7417i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", Long.valueOf(c25822e.fDy));
                            c25822e.setStatus(0);
                            c25822e.bJt = 256;
                            C32291o.ahl().mo73077a(Long.valueOf(c25822e.fDy), c25822e);
                        }
                        m24014a(c7620bi2.field_msgId, c7620bi2.field_msgSvrId, c40814ay.userName, c40814ay.chatroomName, iArr, i, i2);
                    }
                    md = C8910b.m16063md(c7620bi.field_content);
                    if (!(md == null || C5046bo.isNullOrNil(md.appId) || this.zfX == null)) {
                        bT = C46494g.m87739bT(md.appId, false);
                        if (bT != null) {
                            C5378c.m8132a(c46650a, md, this.zfX instanceof C15718a ? C5378c.m8141d(c46650a, c7620bi) : C1853r.m3846Yz(), bT, c7620bi.field_msgSvrId, c46650a.getTalkerUserName());
                        }
                    }
                    AppMethodBeat.m2505o(33242);
                }
            }
            c25822e = C32291o.ahl().mo73112fI(c7620bi2.field_msgSvrId);
            z = C5049br.m7595z(c7620bi2.field_content, "msg");
            if (z != null) {
            }
            C9638aw.m17190ZK();
            if (C18628c.isSDCardAvailable()) {
            }
            md = C8910b.m16063md(c7620bi.field_content);
            bT = C46494g.m87739bT(md.appId, false);
            if (bT != null) {
            }
            AppMethodBeat.m2505o(33242);
        }

        /* renamed from: a */
        private void m24014a(long j, long j2, String str, String str2, int[] iArr, int i, int i2) {
            String str3;
            int i3;
            Bundle bundle;
            AppMethodBeat.m2504i(33243);
            Intent intent = new Intent(this.yJI.yTx.getContext(), ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", j);
            intent.putExtra("show_search_chat_content_result", ((C23733z) this.yJI.mo74857aF(C23733z.class)).dES());
            intent.putExtra("img_gallery_msg_svr_id", j2);
            intent.putExtra("key_is_biz_chat", ((C36135d) this.yJI.mo74857aF(C36135d.class)).dDm());
            intent.putExtra("key_biz_chat_id", ((C36135d) this.yJI.mo74857aF(C36135d.class)).dDz());
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i);
            intent.putExtra("img_gallery_height", i2);
            intent.putExtra("img_gallery_enter_from_chatting_ui", ((C23733z) this.yJI.mo74857aF(C23733z.class)).dEN());
            intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", C7616ad.m13549mg(str));
            String talkerUserName = this.yJI.getTalkerUserName();
            Bundle bundle2 = new Bundle();
            if (this.yJI.dFx()) {
                str3 = "stat_scene";
                i3 = 2;
                bundle = bundle2;
            } else {
                str3 = "stat_scene";
                if (C1855t.m3913mZ(talkerUserName)) {
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
            intent.putExtra("img_gallery_session_id", C15715c.m24016c(j2, str, talkerUserName));
            this.yJI.startActivity(intent);
            this.yJI.yTx.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(33243);
        }

        /* renamed from: a */
        public static void m24015a(C46650a c46650a, C7620bi c7620bi, long j, long j2, String str, String str2, int[] iArr, int i, int i2, boolean z) {
            String str3;
            int i3;
            Bundle bundle;
            AppMethodBeat.m2504i(33244);
            Intent intent = new Intent(c46650a.yTx.getContext(), ImageGalleryUI.class);
            intent.putExtra("img_gallery_msg_id", j);
            intent.putExtra("img_gallery_msg_svr_id", j2);
            intent.putExtra("show_search_chat_content_result", ((C23733z) c46650a.mo74857aF(C23733z.class)).dES());
            intent.putExtra("key_is_biz_chat", ((C36135d) c46650a.mo74857aF(C36135d.class)).dDm());
            intent.putExtra("key_biz_chat_id", ((C36135d) c46650a.mo74857aF(C36135d.class)).dDz());
            intent.putExtra("img_gallery_talker", str);
            intent.putExtra("img_gallery_chatroom_name", str2);
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", i);
            intent.putExtra("img_gallery_height", i2);
            intent.putExtra("img_gallery_enter_from_chatting_ui", ((C23733z) c46650a.mo74857aF(C23733z.class)).dEN());
            intent.putExtra("img_gallery_enter_PhotoEditUI", z);
            intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", C7616ad.m13549mg(str));
            String talkerUserName = c46650a.getTalkerUserName();
            if (c7620bi.field_isSend == 1) {
                str = c46650a.dFu();
            }
            Bundle bundle2 = new Bundle();
            if (c46650a.dFw()) {
                str3 = "stat_scene";
                i3 = 2;
                bundle = bundle2;
            } else {
                str3 = "stat_scene";
                if (C1855t.m3913mZ(talkerUserName)) {
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
            intent.putExtra("img_gallery_session_id", C15715c.m24016c(j2, str, talkerUserName));
            c46650a.yTx.startActivity(intent);
            c46650a.yTx.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(33244);
        }

        /* renamed from: c */
        private static String m24016c(long j, String str, String str2) {
            AppMethodBeat.m2504i(33245);
            String nW = C37922v.m64078nW(String.valueOf(j));
            C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
            y.mo53356j("preUsername", str);
            y.mo53356j("preChatName", str2);
            AppMethodBeat.m2505o(33245);
            return nW;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ad$d */
    static class C15716d extends C5379a {
        TextView moL;
        ProgressBar pyf;
        ImageView zci;
        ImageView zdN;
        ImageView zeh;
        TextView zfY;
        View zfZ;

        /* renamed from: z */
        public final C5379a mo27950z(View view, boolean z) {
            AppMethodBeat.m2504i(33246);
            super.mo11031eP(view);
            this.enf = (TextView) view.findViewById(2131820587);
            this.zdN = (ImageView) view.findViewById(2131822578);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.zfZ = view.findViewById(2131822616);
            if (z) {
                this.qkY = (TextView) view.findViewById(2131821102);
                this.pyf = (ProgressBar) view.findViewById(2131822617);
            } else {
                this.pyf = (ProgressBar) view.findViewById(2131822660);
                this.zfY = (TextView) view.findViewById(2131822668);
                this.qkY = (TextView) view.findViewById(2131821102);
                this.zci = (ImageView) view.findViewById(2131822661);
            }
            this.zeh = (ImageView) view.findViewById(2131822553);
            this.moL = (TextView) view.findViewById(2131822543);
            AppMethodBeat.m2505o(33246);
            return this;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.ad$a */
    public static class C15718a extends C5378c {
        private C46650a yJI;
        private C15715c zfW;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || (i != 39 && i != 3 && i != 23 && i != 13 && i != 33)) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(33229);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969067);
                view.setTag(new C15716d().mo27950z(view, true));
            }
            AppMethodBeat.m2505o(33229);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(33230);
            this.yJI = c46650a;
            ((C36137j) c46650a.mo74857aF(C36137j.class)).mo57029bf(c7620bi);
            C15716d c15716d = (C15716d) c5379a;
            boolean a = C32291o.ahl().mo73097a(c15716d.zdN, c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), c7620bi.dJw, c7620bi.dJx, c15716d.zeh, (int) C25738R.drawable.f6539hj, 1, null);
            c15716d.zfZ.setVisibility(0);
            c15716d.pyf.setVisibility(8);
            if (!(a || this.kuU)) {
                c15716d.zdN.setImageBitmap(BitmapFactory.decodeResource(c46650a.yTx.getMMResources(), C25738R.drawable.f6539hj));
            }
            String str2 = null;
            if (c46650a.dFx()) {
                str2 = c7620bi.field_talker;
            }
            c15716d.jPL.setTag(new C40814ay(c7620bi, c46650a.dFx(), i, str, str2));
            View view = c15716d.jPL;
            if (this.zfW == null) {
                this.zfW = new C15715c(this.yJI, this);
            }
            view.setOnClickListener(this.zfW);
            c15716d.jPL.setOnLongClickListener(mo11021c(c46650a));
            c15716d.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            C15717ad.m24019a(c7620bi, c46650a, c15716d);
            AppMethodBeat.m2505o(33230);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: b */
        public final boolean mo11020b(C46650a c46650a) {
            AppMethodBeat.m2504i(33231);
            boolean dFx = c46650a.dFx();
            AppMethodBeat.m2505o(33231);
            return dFx;
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33232);
            C9638aw.m17190ZK();
            if (!(!C18628c.isSDCardAvailable() || view == null || c7620bi == null)) {
                int i = ((C40814ay) view.getTag()).position;
                C25822e c25822e = null;
                if (c7620bi.field_msgId > 0) {
                    c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
                }
                if ((c25822e == null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                    c25822e = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                }
                contextMenu.add(i, 110, 0, view.getContext().getString(C25738R.string.dr1));
                if (C17903f.aey() && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(C25738R.string.am3));
                }
                if (C25985d.afj("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                }
                C9321dq c9321dq = new C9321dq();
                c9321dq.cxc.cvx = c7620bi.field_msgId;
                C4879a.xxA.mo10055m(c9321dq);
                if (c9321dq.cxd.cwB || C46494g.m87731ad(this.yJI.yTx.getContext(), c7620bi.getType())) {
                    contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
                }
                if (!(c25822e == null || c25822e.status == -1)) {
                    int width;
                    int height;
                    MenuItem add = contextMenu.add(i, 131, 0, view.getContext().getString(C25738R.string.al9));
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
                if (C1831bh.m3770o(c7620bi)) {
                    contextMenu.clear();
                }
                if (!this.yJI.dFy()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(C25738R.string.am6));
                }
            }
            AppMethodBeat.m2505o(33232);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(33233);
            if (100 == menuItem.getItemId()) {
                C15717ad.m24020b(c7620bi, c46650a);
            } else if (131 == menuItem.getItemId()) {
                C15717ad.m24021b(c46650a, menuItem, c7620bi);
            } else {
                ((C44296aa) c46650a.mo74857aF(C44296aa.class)).mo70170a(menuItem, c7620bi);
            }
            AppMethodBeat.m2505o(33233);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            return false;
        }

        /* renamed from: a */
        public static void m24022a(Context context, C5379a c5379a, C7620bi c7620bi, boolean z) {
            AppMethodBeat.m2504i(33234);
            if (true != z) {
                AppMethodBeat.m2505o(33234);
                return;
            }
            if (c5379a instanceof C15716d) {
                C15716d c15716d = (C15716d) c5379a;
                C32291o.ahl().mo73097a(c15716d.zdN, c7620bi.field_imgPath, C1338a.getDensity(context), c7620bi.dJw, c7620bi.dJx, c15716d.zeh, (int) C25738R.drawable.abt, 1, null);
            }
            AppMethodBeat.m2505o(33234);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m24019a(C7620bi c7620bi, C46650a c46650a, C15716d c15716d) {
        AppMethodBeat.m2504i(33247);
        C8910b md = C8910b.m16063md(c7620bi.field_content);
        if (md == null || C5046bo.isNullOrNil(md.appId)) {
            c15716d.moL.setVisibility(8);
            AppMethodBeat.m2505o(33247);
            return;
        }
        String str = md.appId;
        C40439f dX = C46494g.m87742dX(str, md.axy);
        if (dX != null) {
            C5378c.m8138b(c46650a, md, c7620bi);
        }
        String str2 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? md.appName : dX.field_appName;
        if (C5378c.m8142dg(str2)) {
            c15716d.moL.setText(C46494g.m87733b(c46650a.yTx.getContext(), dX, str2));
            c15716d.moL.setVisibility(0);
            if (dX == null || !dX.mo63847xy()) {
                C5378c.m8126a(c46650a, c15716d.moL, str);
            } else {
                C5378c.m8124a(c46650a, c15716d.moL, c7620bi, md, dX.field_packageName, c7620bi.field_msgSvrId);
            }
            C5378c.m8130a(c46650a, c15716d.moL, str);
            AppMethodBeat.m2505o(33247);
            return;
        }
        c15716d.moL.setVisibility(8);
        AppMethodBeat.m2505o(33247);
    }

    /* renamed from: b */
    static /* synthetic */ void m24020b(C7620bi c7620bi, C46650a c46650a) {
        AppMethodBeat.m2504i(33248);
        C8910b md = C8910b.m16063md(c7620bi.field_content);
        if (!(md == null || C5046bo.isNullOrNil(md.appId))) {
            C40439f bT = C46494g.m87739bT(md.appId, false);
            if (bT != null && bT.mo63847xy()) {
                C43155a bDb = C20928a.bDb();
                if (bDb != null) {
                    String str;
                    int i = c46650a.dFx() ? 2 : 1;
                    String d = C5378c.m8141d(c46650a, c7620bi);
                    Context context = c46650a.yTx.getContext();
                    String str2 = md.appId;
                    if (bT == null) {
                        str = null;
                    } else {
                        str = bT.field_packageName;
                    }
                    bDb.mo36274a(context, str2, str, d, md.type, md.mediaTagName, i);
                }
            }
        }
        AppMethodBeat.m2505o(33248);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    static /* synthetic */ boolean m24021b(C46650a c46650a, MenuItem menuItem, C7620bi c7620bi) {
        AppMethodBeat.m2504i(33249);
        switch (menuItem.getItemId()) {
            case 131:
                C4990ab.m7416i("MicroMsg.ChattingItemImg", "long click go to photo eidt");
                Intent intent = menuItem.getIntent();
                if (intent == null) {
                    C4990ab.m7412e("MicroMsg.ChattingItemImg", "[LONGCLICK_MENU_PHOTO_EDIT] intent is null!");
                    AppMethodBeat.m2505o(33249);
                    return true;
                }
                Object obj;
                C25822e c25822e;
                C25822e fI;
                String q;
                int intExtra = intent.getIntExtra("img_gallery_width", 0);
                int intExtra2 = intent.getIntExtra("img_gallery_height", 0);
                int[] iArr = new int[]{intent.getIntExtra("img_gallery_left", 0), intent.getIntExtra("img_gallery_top", 0)};
                String str = null;
                if (!c46650a.dFw()) {
                    if (!((C36135d) c46650a.mo74857aF(C36135d.class)).dDn()) {
                        obj = null;
                        if (obj != null) {
                            str = c7620bi.field_talker;
                        }
                        c25822e = null;
                        if (c7620bi.field_msgId > 0) {
                            c25822e = C32291o.ahl().mo73113fJ(c7620bi.field_msgId);
                        }
                        if ((c25822e != null || c25822e.fDy <= 0) && c7620bi.field_msgSvrId > 0) {
                            fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                        } else {
                            fI = c25822e;
                        }
                        q = fI != null ? "" : C32291o.ahl().mo73118q(fI.fDz, "", "");
                        if (fI != null || fI.status == -1 || c7620bi.field_status == 5) {
                            C4990ab.m7413e("MicroMsg.ChattingItemImg", "raw img not get successfully ,msgId:%s", Long.valueOf(c7620bi.field_msgId));
                        } else {
                            C4990ab.m7417i("MicroMsg.ChattingItemImg", "[LONGCLICK_MENU_PHOTO_EDIT] msgId:%s imgFullPath:%s", Long.valueOf(c7620bi.field_msgId), q);
                            C15715c.m24015a(c46650a, c7620bi, c7620bi.field_msgId, c7620bi.field_msgSvrId, c7620bi.field_talker, str, iArr, intExtra, intExtra2, true);
                        }
                        AppMethodBeat.m2505o(33249);
                        return true;
                    }
                }
                obj = 1;
                if (obj != null) {
                }
                c25822e = null;
                if (c7620bi.field_msgId > 0) {
                }
                if (c25822e != null) {
                    break;
                }
                fI = C32291o.ahl().mo73112fI(c7620bi.field_msgSvrId);
                if (fI != null) {
                }
                if (fI != null) {
                    break;
                }
                C4990ab.m7413e("MicroMsg.ChattingItemImg", "raw img not get successfully ,msgId:%s", Long.valueOf(c7620bi.field_msgId));
                AppMethodBeat.m2505o(33249);
                return true;
            default:
                AppMethodBeat.m2505o(33249);
                return false;
        }
    }
}
