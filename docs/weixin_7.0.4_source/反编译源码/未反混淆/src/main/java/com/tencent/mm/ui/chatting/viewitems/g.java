package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import java.util.Map;

public final class g {

    public static class b extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;
        private final int zdx = 1;

        public final boolean dHk() {
            return false;
        }

        public final boolean aH(int i, boolean z) {
            if (z || i != 469762097) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32892);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.m3);
                view.setTag(new a().eU(view));
            }
            AppMethodBeat.o(32892);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32893);
            this.yJI = aVar2;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            a aVar3 = (a) aVar;
            d dVar = (d) X.X(d.class);
            if (dVar.cRV == 0) {
                aVar3.zdv.setBackgroundResource(R.drawable.b_h);
                aVar3.zdw.setBackgroundResource(R.drawable.b__);
                aVar3.zdu.setVisibility(8);
            } else {
                aVar3.zdv.setBackgroundResource(R.drawable.b_i);
                aVar3.zdw.setBackgroundResource(R.drawable.b_9);
                aVar3.zdu.setVisibility(0);
                if (dVar.cRV == 1) {
                    aVar3.zdu.setText(ah.getContext().getString(R.string.crs));
                } else if (dVar.cRV == 2) {
                    aVar3.zdu.setText(ah.getContext().getString(R.string.cru));
                }
            }
            aVar.jPL.setOnClickListener(d(aVar2));
            aVar.jPL.setOnLongClickListener(c(aVar2));
            aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            aVar.jPL.setTag(new ay(biVar, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.o(32893);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32894);
            contextMenu.add(((ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            AppMethodBeat.o(32894);
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32895);
            menuItem.getItemId();
            AppMethodBeat.o(32895);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32896);
            String str = biVar.field_content;
            if (str != null) {
                com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
                if (!bo.isNullOrNil(X.fhZ)) {
                    ab.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
                    d dVar = (d) X.X(d.class);
                    Intent intent = new Intent();
                    intent.putExtra("key_native_url", X.fhZ);
                    intent.putExtra("key_username", aVar.getTalkerUserName());
                    intent.putExtra("key_image_id", X.fic);
                    intent.putExtra("key_image_aes_key", X.fid);
                    intent.putExtra("key_image_length", X.fie);
                    intent.putExtra("key_msgid", biVar.field_msgId);
                    intent.putExtra("key_msg_newyear_localreceivestatus", dVar.cRV);
                    if (dVar.exP != null) {
                        intent.putExtra("key_emoji_md5", dVar.exP.field_md5);
                    }
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                    X.fia = 1;
                    biVar.setContent(com.tencent.mm.af.j.b.a(X, null, null));
                    if (biVar != null && biVar.bAA()) {
                        try {
                            str = biVar.field_content;
                            int indexOf = str.indexOf("<msg>");
                            if (indexOf > 0 && indexOf < str.length()) {
                                str = str.substring(indexOf).trim();
                            }
                            Map z = br.z(str, "msg");
                            if (z != null && z.size() > 0) {
                                biVar.jw(be.aS(z));
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", e.getMessage());
                        }
                    }
                    aw.ZK();
                    com.tencent.mm.model.c.XO().a(biVar.field_msgId, biVar);
                }
            }
            AppMethodBeat.o(32896);
            return true;
        }
    }

    public static class c extends c {
        private com.tencent.mm.ui.chatting.d.a yJI;

        public final boolean dHk() {
            return true;
        }

        public final boolean aH(int i, boolean z) {
            if (z && i == 469762097) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(32897);
            if (view == null || view.getTag() == null) {
                view = new v(layoutInflater, R.layout.n3);
                view.setTag(new a().eU(view));
            }
            AppMethodBeat.o(32897);
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a aVar, int i, com.tencent.mm.ui.chatting.d.a aVar2, bi biVar, String str) {
            com.tencent.mm.af.j.b X;
            AppMethodBeat.i(32898);
            this.yJI = aVar2;
            String str2 = biVar.field_content;
            if (str2 != null) {
                X = com.tencent.mm.af.j.b.X(str2, biVar.field_reserved);
            } else {
                X = null;
            }
            a aVar3 = (a) aVar;
            d dVar = (d) X.X(d.class);
            if (dVar.cRV == 0) {
                aVar3.zdv.setBackgroundResource(R.drawable.b_x);
                aVar3.zdw.setBackgroundResource(R.drawable.b_8);
                aVar3.zdu.setVisibility(8);
            } else {
                aVar3.zdv.setBackgroundResource(R.drawable.b_y);
                aVar3.zdw.setBackgroundResource(R.drawable.b_9);
                aVar3.zdu.setVisibility(0);
                if (dVar.cRV == 1) {
                    aVar3.zdu.setText(ah.getContext().getString(R.string.crs));
                } else if (dVar.cRV == 2) {
                    aVar3.zdu.setText(ah.getContext().getString(R.string.crv));
                }
            }
            aVar.jPL.setOnClickListener(d(aVar2));
            aVar.jPL.setOnLongClickListener(c(aVar2));
            aVar.jPL.setOnTouchListener(((h) aVar2.aF(h.class)).dCZ());
            aVar.jPL.setTag(new ay(biVar, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.o(32898);
        }

        public final boolean a(ContextMenu contextMenu, View view, bi biVar) {
            AppMethodBeat.i(32899);
            contextMenu.add(((ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(R.string.am7));
            AppMethodBeat.o(32899);
            return false;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32900);
            menuItem.getItemId();
            AppMethodBeat.o(32900);
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.d.a aVar, bi biVar) {
            AppMethodBeat.i(32901);
            String str = biVar.field_content;
            if (str != null) {
                com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(str, biVar.field_reserved);
                if (!(X == null || bo.isNullOrNil(X.fhZ))) {
                    d dVar = (d) X.X(d.class);
                    Intent intent = new Intent();
                    intent.putExtra("key_native_url", X.fhZ);
                    intent.putExtra("key_image_id", X.fic);
                    intent.putExtra("key_image_aes_key", X.fid);
                    intent.putExtra("key_image_length", X.fie);
                    intent.putExtra("key_username", aVar.getTalkerUserName());
                    intent.putExtra("key_msgid", biVar.field_msgId);
                    intent.putExtra("key_msg_newyear_localreceivestatus", dVar.cRV);
                    if (dVar.exP != null) {
                        intent.putExtra("key_emoji_md5", dVar.exP.field_md5);
                    }
                    com.tencent.mm.bp.d.b(aVar.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                }
            }
            AppMethodBeat.o(32901);
            return true;
        }
    }

    static class a extends com.tencent.mm.ui.chatting.viewitems.c.a {
        public RelativeLayout zdt;
        public TextView zdu;
        public ImageView zdv;
        public ImageView zdw;

        a() {
        }

        public final a eU(View view) {
            AppMethodBeat.i(32891);
            super.eP(view);
            this.enf = (TextView) this.mRR.findViewById(R.id.ag);
            this.moo = (CheckBox) this.mRR.findViewById(R.id.a_);
            this.iVh = this.mRR.findViewById(R.id.af);
            this.qkY = (TextView) this.mRR.findViewById(R.id.od);
            this.jPL = this.mRR.findViewById(R.id.aqr);
            this.zdt = (RelativeLayout) this.mRR.findViewById(R.id.aqn);
            this.zdu = (TextView) this.mRR.findViewById(R.id.aqq);
            this.zdv = (ImageView) this.mRR.findViewById(R.id.aqo);
            this.zdw = (ImageView) this.mRR.findViewById(R.id.aqp);
            AppMethodBeat.o(32891);
            return this;
        }
    }
}
