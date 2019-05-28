package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.r;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;

public final class b extends p<com.tencent.mm.aj.a.a> implements com.tencent.mm.sdk.e.n.b {
    private c elH = null;
    protected g jJO;
    protected MMSlideDelView.c jJP;
    protected f jJQ;
    protected d jJR = MMSlideDelView.getItemStatusCallBack();
    private final String jMp;
    private final MMFragmentActivity yDT;
    private float yDU = -1.0f;
    private float yDV = -1.0f;
    private float yDW = -1.0f;
    private ColorStateList[] yDX = new ColorStateList[5];
    HashMap<String, a> yDY;

    public static class b {
        public ImageView ejo;
        public TextView jJV;
        public NoMeasuredTextView yEc;
        public NoMeasuredTextView yEd;
        public NoMeasuredTextView yEe;
        public ImageView yEf;
        public ImageView yEg;
        public View yEh;
    }

    class a {
        String egE;
        public boolean eif;
        String myX;
        public boolean yDZ;
        public com.tencent.mm.aj.a.a yEa;

        private a() {
            this.egE = null;
            this.myX = null;
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        AppMethodBeat.i(30054);
        com.tencent.mm.aj.a.a aVar = (com.tencent.mm.aj.a.a) obj;
        if (aVar == null) {
            aVar = new com.tencent.mm.aj.a.a();
        }
        aVar.d(cursor);
        AppMethodBeat.o(30054);
        return aVar;
    }

    public b(Context context, com.tencent.mm.ui.p.a aVar, String str) {
        super(context, new com.tencent.mm.aj.a.a());
        AppMethodBeat.i(30044);
        super.a(aVar);
        this.yDT = (MMFragmentActivity) context;
        this.jMp = str;
        this.yDY = new HashMap();
        this.yDX[0] = com.tencent.mm.bz.a.h(context, (int) R.color.s0);
        this.yDX[1] = com.tencent.mm.bz.a.h(context, (int) R.color.a7y);
        this.yDX[3] = com.tencent.mm.bz.a.h(context, (int) R.color.w4);
        this.yDX[2] = com.tencent.mm.bz.a.h(context, (int) R.color.a7v);
        this.yDX[2] = com.tencent.mm.bz.a.h(context, (int) R.color.a7v);
        this.yDX[4] = com.tencent.mm.bz.a.h(context, (int) R.color.t3);
        this.yDU = (float) com.tencent.mm.bz.a.al(context, R.dimen.m5);
        this.yDV = (float) com.tencent.mm.bz.a.al(context, R.dimen.kr);
        this.yDW = (float) com.tencent.mm.bz.a.al(context, R.dimen.nk);
        com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
        aVar2.ePK = e.cC(this.jMp);
        aVar2.ePH = true;
        aVar2.ePZ = true;
        aVar2.ePT = R.raw.default_avatar;
        this.elH = aVar2.ahG();
        AppMethodBeat.o(30044);
    }

    public final void KC() {
        AppMethodBeat.i(30045);
        bIf();
        setCursor(z.aeU().rn(this.jMp));
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(30045);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public final void a(f fVar) {
        this.jJQ = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
        this.jJP = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        AppMethodBeat.i(30046);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        AppMethodBeat.o(30046);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        b bVar2;
        int i2;
        AppMethodBeat.i(30047);
        com.tencent.mm.aj.a.a aVar = (com.tencent.mm.aj.a.a) getItem(i);
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = null;
        }
        if (view == null || bVar == null) {
            View inflate;
            bVar2 = new b();
            if (com.tencent.mm.bz.a.ga(this.yDT)) {
                inflate = View.inflate(this.yDT, R.layout.r9, null);
            } else {
                inflate = View.inflate(this.yDT, R.layout.r8, null);
            }
            bVar2.ejo = (ImageView) inflate.findViewById(R.id.qk);
            bVar2.yEc = (NoMeasuredTextView) inflate.findViewById(R.id.b6e);
            bVar2.yEd = (NoMeasuredTextView) inflate.findViewById(R.id.b6f);
            bVar2.yEe = (NoMeasuredTextView) inflate.findViewById(R.id.b6g);
            bVar2.jJV = (TextView) inflate.findViewById(R.id.nf);
            bVar2.jJV.setBackgroundResource(r.ik(this.yDT));
            bVar2.yEf = (ImageView) inflate.findViewById(R.id.b6i);
            bVar2.yEh = inflate.findViewById(R.id.b6d);
            bVar2.yEg = (ImageView) inflate.findViewById(R.id.b6j);
            inflate.setTag(bVar2);
            bVar2.yEe.setTextSize(0, this.yDV);
            bVar2.yEd.setTextSize(0, this.yDW);
            bVar2.yEc.setTextSize(0, this.yDU);
            bVar2.yEe.setTextColor(this.yDX[0]);
            bVar2.yEd.setTextColor(this.yDX[4]);
            bVar2.yEc.setTextColor(this.yDX[3]);
            bVar2.yEe.setShouldEllipsize(true);
            bVar2.yEd.setShouldEllipsize(false);
            bVar2.yEc.setShouldEllipsize(true);
            bVar2.yEd.setGravity(5);
            view = inflate;
        } else {
            bVar2 = bVar;
        }
        long j = aVar.field_bizChatId;
        a aVar2 = (a) this.yDY.get(String.valueOf(j));
        if (aVar2 == null) {
            aVar2 = new a(this, (byte) 0);
            z.aeU();
            aVar2.yDZ = com.tencent.mm.aj.a.b.c(aVar);
            com.tencent.mm.aj.a.c aK = z.aeT().aK(j);
            if (aK.isGroup()) {
                aVar2.egE = aK.field_chatName;
                aVar2.eif = aK.lc(1);
                aVar2.myX = aK.field_headImageUrl;
            } else {
                j cH = z.aeV().cH(aK.field_bizChatServId);
                if (cH != null) {
                    aVar2.egE = cH.field_userName;
                    aVar2.eif = cH.lc(1);
                    aVar2.myX = cH.field_headImageUrl;
                }
            }
            if (bo.isNullOrNil(aVar2.egE)) {
                aVar2.egE = this.yDT.getString(R.string.dso);
            }
            aVar2.yEa = aVar;
            this.yDY.put(String.valueOf(j), aVar2);
        }
        bVar2.yEg.setVisibility(8);
        bVar2.yEd.setText(aVar2.yEa.field_status == 1 ? this.yDT.getString(R.string.cw8) : h.c(this.yDT, aVar2.yEa.field_lastMsgTime, true));
        o.ahp().a(aVar2.myX, bVar2.ejo, this.elH);
        if (aVar2.eif) {
            bVar2.yEf.setVisibility(0);
        } else {
            bVar2.yEf.setVisibility(8);
        }
        bVar2.yEc.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.yDT, aVar2.egE, (int) bVar2.yEc.getTextSize()));
        CharSequence a = a(aVar2.yEa, (int) bVar2.yEe.getTextSize(), aVar2.egE);
        switch (aVar2.yEa.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = R.raw.msg_state_sending;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = R.raw.msg_state_failed;
                break;
            default:
                i2 = -1;
                break;
        }
        bVar2.yEc.setDrawRightDrawable(false);
        if (i2 != -1) {
            bVar2.yEe.setCompoundLeftDrawablesWithIntrinsicBounds(i2);
            bVar2.yEe.setDrawLeftDrawable(true);
        } else {
            bVar2.yEe.setDrawLeftDrawable(false);
        }
        bVar2.yEe.setText(a);
        bVar2.yEe.setTextColor(com.tencent.mm.bz.a.h(this.yDT, (int) R.color.a7x));
        if (FB(aVar2.yEa.field_msgType) == 34 && aVar2.yEa.field_isSend == 0 && !bo.isNullOrNil(aVar2.yEa.field_content) && !new n(aVar2.yEa.field_content).fWX) {
            bVar2.yEe.setTextColor(com.tencent.mm.bz.a.h(this.yDT, (int) R.color.a7y));
        }
        if (aVar2.eif) {
            if (aVar2.yEa.field_unReadCount > 0) {
                bVar2.yEh.setVisibility(0);
            } else {
                bVar2.yEh.setVisibility(4);
            }
            bVar2.jJV.setVisibility(4);
        } else {
            bVar2.yEh.setVisibility(4);
            if (aVar2.yEa.field_unReadCount > 99) {
                bVar2.jJV.setText("");
                bVar2.jJV.setBackgroundResource(R.raw.badge_count_more);
                bVar2.jJV.setVisibility(0);
                ab.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            } else if (aVar2.yEa.field_unReadCount > 0) {
                bVar2.jJV.setText(aVar2.yEa.field_unReadCount);
                bVar2.jJV.setVisibility(0);
                bVar2.jJV.setBackgroundResource(r.ik(this.yDT));
                ab.v("MicroMsg.BizChatConversationAdapter", "has unread");
            } else {
                bVar2.jJV.setVisibility(4);
                ab.v("MicroMsg.BizChatConversationAdapter", "no unread");
            }
        }
        if (aVar2.yDZ) {
            view.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k4);
        } else {
            view.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k5);
        }
        AppMethodBeat.o(30047);
        return view;
    }

    private static String aqV(String str) {
        AppMethodBeat.i(30048);
        if (str == null || str.length() != 32) {
            AppMethodBeat.o(30048);
            return null;
        }
        String Jh = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jh(str);
        AppMethodBeat.o(30048);
        return Jh;
    }

    private CharSequence a(com.tencent.mm.aj.a.a aVar, int i, String str) {
        AppMethodBeat.i(30049);
        if (bo.isNullOrNil(aVar.field_editingMsg) || (aVar.field_atCount > 0 && aVar.field_unReadCount > 0)) {
            String str2;
            CharSequence charSequence;
            if (aVar.field_msgType != null && (aVar.field_msgType.equals("47") || aVar.field_msgType.equals("1048625"))) {
                String aqV = aqV(aVar.field_digest);
                str2 = "";
                if (aqV != null) {
                    charSequence = "[" + aqV + "]";
                    AppMethodBeat.o(30049);
                    return charSequence;
                }
                if (aVar.field_digest != null && aVar.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                    str2 = aVar.field_digest.substring(0, aVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                    aqV = aqV(aVar.field_digest.substring(aVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                    if (aqV != null) {
                        aqV = "[" + aqV + "]";
                        if (bo.isNullOrNil(str2)) {
                            AppMethodBeat.o(30049);
                            return aqV;
                        }
                        charSequence = str2 + ": " + aqV;
                        AppMethodBeat.o(30049);
                        return charSequence;
                    }
                }
                aqV = this.yDT.getString(R.string.ph);
                aVar.field_digest = bo.isNullOrNil(str2) ? aqV : str2 + ": " + aqV;
            }
            if (bo.isNullOrNil(aVar.field_digest)) {
                str2 = "";
            } else if (bo.isNullOrNil(aVar.field_digestUser)) {
                str2 = aVar.field_digest;
            } else {
                try {
                    str2 = String.format(aVar.field_digest, new Object[]{str});
                } catch (Exception e) {
                    str2 = aVar.field_digest;
                }
            }
            CharSequence replace = str2.replace(10, ' ');
            if (aVar.field_atCount <= 0 || aVar.field_unReadCount <= 0) {
                charSequence = com.tencent.mm.pluginsdk.ui.e.j.b(this.yDT, replace, i);
                AppMethodBeat.o(30049);
                return charSequence;
            }
            charSequence = new SpannableStringBuilder(this.yDT.getString(R.string.cvd));
            charSequence.setSpan(new ForegroundColorSpan(-5569532), 0, charSequence.length(), 33);
            charSequence.append(" ").append(com.tencent.mm.pluginsdk.ui.e.j.b(this.yDT, replace, i));
            AppMethodBeat.o(30049);
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.yDT.getString(R.string.cvh));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(" ").append(com.tencent.mm.pluginsdk.ui.e.j.b(this.yDT, aVar.field_editingMsg, i));
        AppMethodBeat.o(30049);
        return spannableStringBuilder;
    }

    private static int FB(String str) {
        int i = 1;
        AppMethodBeat.i(30050);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.o(30050);
        return i;
    }

    public final void KD() {
        AppMethodBeat.i(30051);
        KC();
        AppMethodBeat.o(30051);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(30052);
        super.a(i, nVar, obj);
        AppMethodBeat.o(30052);
    }

    public final void mY(long j) {
        AppMethodBeat.i(30053);
        if (this.yDY != null) {
            this.yDY.remove(String.valueOf(j));
        }
        AppMethodBeat.o(30053);
    }
}
