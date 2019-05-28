package com.tencent.p177mm.p612ui.chatting.viewitems;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8908d;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5035be;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.g */
public final class C36219g {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.g$b */
    public static class C15743b extends C5378c {
        private C46650a yJI;
        private final int zdx = 1;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || i != 469762097) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32892);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969049);
                view.setTag(new C31503a().mo51428eU(view));
            }
            AppMethodBeat.m2505o(32892);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32893);
            this.yJI = c46650a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            C31503a c31503a = (C31503a) c5379a;
            C8908d c8908d = (C8908d) X.mo20333X(C8908d.class);
            if (c8908d.cRV == 0) {
                c31503a.zdv.setBackgroundResource(C25738R.drawable.b_h);
                c31503a.zdw.setBackgroundResource(C25738R.drawable.b__);
                c31503a.zdu.setVisibility(8);
            } else {
                c31503a.zdv.setBackgroundResource(C25738R.drawable.b_i);
                c31503a.zdw.setBackgroundResource(C25738R.drawable.b_9);
                c31503a.zdu.setVisibility(0);
                if (c8908d.cRV == 1) {
                    c31503a.zdu.setText(C4996ah.getContext().getString(C25738R.string.crs));
                } else if (c8908d.cRV == 2) {
                    c31503a.zdu.setText(C4996ah.getContext().getString(C25738R.string.cru));
                }
            }
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
            c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            c5379a.jPL.setTag(new C40814ay(c7620bi, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.m2505o(32893);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32894);
            contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            AppMethodBeat.m2505o(32894);
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32895);
            menuItem.getItemId();
            AppMethodBeat.m2505o(32895);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32896);
            String str = c7620bi.field_content;
            if (str != null) {
                C8910b X = C8910b.m16058X(str, c7620bi.field_reserved);
                if (!C5046bo.isNullOrNil(X.fhZ)) {
                    C4990ab.m7410d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
                    C8908d c8908d = (C8908d) X.mo20333X(C8908d.class);
                    Intent intent = new Intent();
                    intent.putExtra("key_native_url", X.fhZ);
                    intent.putExtra("key_username", c46650a.getTalkerUserName());
                    intent.putExtra("key_image_id", X.fic);
                    intent.putExtra("key_image_aes_key", X.fid);
                    intent.putExtra("key_image_length", X.fie);
                    intent.putExtra("key_msgid", c7620bi.field_msgId);
                    intent.putExtra("key_msg_newyear_localreceivestatus", c8908d.cRV);
                    if (c8908d.exP != null) {
                        intent.putExtra("key_emoji_md5", c8908d.exP.field_md5);
                    }
                    C25985d.m41467b(c46650a.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                    X.fia = 1;
                    c7620bi.setContent(C8910b.m16061a(X, null, null));
                    if (c7620bi != null && c7620bi.bAA()) {
                        try {
                            str = c7620bi.field_content;
                            int indexOf = str.indexOf("<msg>");
                            if (indexOf > 0 && indexOf < str.length()) {
                                str = str.substring(indexOf).trim();
                            }
                            Map z = C5049br.m7595z(str, "msg");
                            if (z != null && z.size() > 0) {
                                c7620bi.mo14796jw(C5035be.m7492aS(z));
                            }
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", e.getMessage());
                        }
                    }
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15284a(c7620bi.field_msgId, c7620bi);
                }
            }
            AppMethodBeat.m2505o(32896);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.g$c */
    public static class C15744c extends C5378c {
        private C46650a yJI;

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && i == 469762097) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32897);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969087);
                view.setTag(new C31503a().mo51428eU(view));
            }
            AppMethodBeat.m2505o(32897);
            return view;
        }

        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C8910b X;
            AppMethodBeat.m2504i(32898);
            this.yJI = c46650a;
            String str2 = c7620bi.field_content;
            if (str2 != null) {
                X = C8910b.m16058X(str2, c7620bi.field_reserved);
            } else {
                X = null;
            }
            C31503a c31503a = (C31503a) c5379a;
            C8908d c8908d = (C8908d) X.mo20333X(C8908d.class);
            if (c8908d.cRV == 0) {
                c31503a.zdv.setBackgroundResource(C25738R.drawable.b_x);
                c31503a.zdw.setBackgroundResource(C25738R.drawable.b_8);
                c31503a.zdu.setVisibility(8);
            } else {
                c31503a.zdv.setBackgroundResource(C25738R.drawable.b_y);
                c31503a.zdw.setBackgroundResource(C25738R.drawable.b_9);
                c31503a.zdu.setVisibility(0);
                if (c8908d.cRV == 1) {
                    c31503a.zdu.setText(C4996ah.getContext().getString(C25738R.string.crs));
                } else if (c8908d.cRV == 2) {
                    c31503a.zdu.setText(C4996ah.getContext().getString(C25738R.string.crv));
                }
            }
            c5379a.jPL.setOnClickListener(mo11022d(c46650a));
            c5379a.jPL.setOnLongClickListener(mo11021c(c46650a));
            c5379a.jPL.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            c5379a.jPL.setTag(new C40814ay(c7620bi, this.yJI.dFx(), i, null, 0));
            AppMethodBeat.m2505o(32898);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32899);
            contextMenu.add(((C40814ay) view.getTag()).position, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            AppMethodBeat.m2505o(32899);
            return false;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32900);
            menuItem.getItemId();
            AppMethodBeat.m2505o(32900);
            return false;
        }

        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32901);
            String str = c7620bi.field_content;
            if (str != null) {
                C8910b X = C8910b.m16058X(str, c7620bi.field_reserved);
                if (!(X == null || C5046bo.isNullOrNil(X.fhZ))) {
                    C8908d c8908d = (C8908d) X.mo20333X(C8908d.class);
                    Intent intent = new Intent();
                    intent.putExtra("key_native_url", X.fhZ);
                    intent.putExtra("key_image_id", X.fic);
                    intent.putExtra("key_image_aes_key", X.fid);
                    intent.putExtra("key_image_length", X.fie);
                    intent.putExtra("key_username", c46650a.getTalkerUserName());
                    intent.putExtra("key_msgid", c7620bi.field_msgId);
                    intent.putExtra("key_msg_newyear_localreceivestatus", c8908d.cRV);
                    if (c8908d.exP != null) {
                        intent.putExtra("key_emoji_md5", c8908d.exP.field_md5);
                    }
                    C25985d.m41467b(c46650a.yTx.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                }
            }
            AppMethodBeat.m2505o(32901);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.g$a */
    static class C31503a extends C5379a {
        public RelativeLayout zdt;
        public TextView zdu;
        public ImageView zdv;
        public ImageView zdw;

        C31503a() {
        }

        /* renamed from: eU */
        public final C31503a mo51428eU(View view) {
            AppMethodBeat.m2504i(32891);
            super.mo11031eP(view);
            this.enf = (TextView) this.mRR.findViewById(2131820587);
            this.moo = (CheckBox) this.mRR.findViewById(2131820580);
            this.iVh = this.mRR.findViewById(2131820586);
            this.qkY = (TextView) this.mRR.findViewById(2131821102);
            this.jPL = this.mRR.findViewById(2131822571);
            this.zdt = (RelativeLayout) this.mRR.findViewById(2131822567);
            this.zdu = (TextView) this.mRR.findViewById(2131822570);
            this.zdv = (ImageView) this.mRR.findViewById(2131822568);
            this.zdw = (ImageView) this.mRR.findViewById(2131822569);
            AppMethodBeat.m2505o(32891);
            return this;
        }
    }
}
