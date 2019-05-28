package com.tencent.p177mm.p612ui.bizchat;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p184aj.p185a.C32232a;
import com.tencent.p177mm.p184aj.p185a.C37446b;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p184aj.p185a.C45143j;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.C46692p.C30723a;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.bizchat.b */
public final class C40687b extends C46692p<C32232a> implements C4937b {
    private C25814c elH = null;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23599f jJQ;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();
    private final String jMp;
    private final MMFragmentActivity yDT;
    private float yDU = -1.0f;
    private float yDV = -1.0f;
    private float yDW = -1.0f;
    private ColorStateList[] yDX = new ColorStateList[5];
    HashMap<String, C40686a> yDY;

    /* renamed from: com.tencent.mm.ui.bizchat.b$b */
    public static class C15550b {
        public ImageView ejo;
        public TextView jJV;
        public NoMeasuredTextView yEc;
        public NoMeasuredTextView yEd;
        public NoMeasuredTextView yEe;
        public ImageView yEf;
        public ImageView yEg;
        public View yEh;
    }

    /* renamed from: com.tencent.mm.ui.bizchat.b$a */
    class C40686a {
        String egE;
        public boolean eif;
        String myX;
        public boolean yDZ;
        public C32232a yEa;

        private C40686a() {
            this.egE = null;
            this.myX = null;
        }

        /* synthetic */ C40686a(C40687b c40687b, byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(30054);
        C32232a c32232a = (C32232a) obj;
        if (c32232a == null) {
            c32232a = new C32232a();
        }
        c32232a.mo8995d(cursor);
        AppMethodBeat.m2505o(30054);
        return c32232a;
    }

    public C40687b(Context context, C30723a c30723a, String str) {
        super(context, new C32232a());
        AppMethodBeat.m2504i(30044);
        super.mo74992a(c30723a);
        this.yDT = (MMFragmentActivity) context;
        this.jMp = str;
        this.yDY = new HashMap();
        this.yDX[0] = C1338a.m2870h(context, (int) C25738R.color.f12092s0);
        this.yDX[1] = C1338a.m2870h(context, (int) C25738R.color.a7y);
        this.yDX[3] = C1338a.m2870h(context, (int) C25738R.color.f12212w4);
        this.yDX[2] = C1338a.m2870h(context, (int) C25738R.color.a7v);
        this.yDX[2] = C1338a.m2870h(context, (int) C25738R.color.a7v);
        this.yDX[4] = C1338a.m2870h(context, (int) C25738R.color.f12120t3);
        this.yDU = (float) C1338a.m2856al(context, C25738R.dimen.f9980m5);
        this.yDV = (float) C1338a.m2856al(context, C25738R.dimen.f9936kr);
        this.yDW = (float) C1338a.m2856al(context, C25738R.dimen.f10018nk);
        C17927a c17927a = new C17927a();
        c17927a.ePK = C25754e.m40894cC(this.jMp);
        c17927a.ePH = true;
        c17927a.ePZ = true;
        c17927a.ePT = C1318a.default_avatar;
        this.elH = c17927a.ahG();
        AppMethodBeat.m2505o(30044);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(30045);
        bIf();
        setCursor(C41747z.aeU().mo60345rn(this.jMp));
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(30045);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    /* renamed from: a */
    public final void mo64185a(C23599f c23599f) {
        this.jJQ = c23599f;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        AppMethodBeat.m2504i(30046);
        if (this.jJR != null) {
            this.jJR.bIp();
        }
        AppMethodBeat.m2505o(30046);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C15550b c15550b;
        C15550b c15550b2;
        int i2;
        AppMethodBeat.m2504i(30047);
        C32232a c32232a = (C32232a) getItem(i);
        if (view != null) {
            c15550b = (C15550b) view.getTag();
        } else {
            c15550b = null;
        }
        if (view == null || c15550b == null) {
            View inflate;
            c15550b2 = new C15550b();
            if (C1338a.m2865ga(this.yDT)) {
                inflate = View.inflate(this.yDT, 2130969242, null);
            } else {
                inflate = View.inflate(this.yDT, 2130969241, null);
            }
            c15550b2.ejo = (ImageView) inflate.findViewById(2131821183);
            c15550b2.yEc = (NoMeasuredTextView) inflate.findViewById(2131823149);
            c15550b2.yEd = (NoMeasuredTextView) inflate.findViewById(2131823150);
            c15550b2.yEe = (NoMeasuredTextView) inflate.findViewById(2131823151);
            c15550b2.jJV = (TextView) inflate.findViewById(2131821067);
            c15550b2.jJV.setBackgroundResource(C44385r.m80243ik(this.yDT));
            c15550b2.yEf = (ImageView) inflate.findViewById(2131823153);
            c15550b2.yEh = inflate.findViewById(2131823148);
            c15550b2.yEg = (ImageView) inflate.findViewById(2131823154);
            inflate.setTag(c15550b2);
            c15550b2.yEe.setTextSize(0, this.yDV);
            c15550b2.yEd.setTextSize(0, this.yDW);
            c15550b2.yEc.setTextSize(0, this.yDU);
            c15550b2.yEe.setTextColor(this.yDX[0]);
            c15550b2.yEd.setTextColor(this.yDX[4]);
            c15550b2.yEc.setTextColor(this.yDX[3]);
            c15550b2.yEe.setShouldEllipsize(true);
            c15550b2.yEd.setShouldEllipsize(false);
            c15550b2.yEc.setShouldEllipsize(true);
            c15550b2.yEd.setGravity(5);
            view = inflate;
        } else {
            c15550b2 = c15550b;
        }
        long j = c32232a.field_bizChatId;
        C40686a c40686a = (C40686a) this.yDY.get(String.valueOf(j));
        if (c40686a == null) {
            c40686a = new C40686a(this, (byte) 0);
            C41747z.aeU();
            c40686a.yDZ = C37446b.m63112c(c32232a);
            C45142c aK = C41747z.aeT().mo60349aK(j);
            if (aK.isGroup()) {
                c40686a.egE = aK.field_chatName;
                c40686a.eif = aK.mo73052lc(1);
                c40686a.myX = aK.field_headImageUrl;
            } else {
                C45143j cH = C41747z.aeV().mo60356cH(aK.field_bizChatServId);
                if (cH != null) {
                    c40686a.egE = cH.field_userName;
                    c40686a.eif = cH.mo73056lc(1);
                    c40686a.myX = cH.field_headImageUrl;
                }
            }
            if (C5046bo.isNullOrNil(c40686a.egE)) {
                c40686a.egE = this.yDT.getString(C25738R.string.dso);
            }
            c40686a.yEa = c32232a;
            this.yDY.put(String.valueOf(j), c40686a);
        }
        c15550b2.yEg.setVisibility(8);
        c15550b2.yEd.setText(c40686a.yEa.field_status == 1 ? this.yDT.getString(C25738R.string.cw8) : C14835h.m23089c(this.yDT, c40686a.yEa.field_lastMsgTime, true));
        C32291o.ahp().mo43766a(c40686a.myX, c15550b2.ejo, this.elH);
        if (c40686a.eif) {
            c15550b2.yEf.setVisibility(0);
        } else {
            c15550b2.yEf.setVisibility(8);
        }
        c15550b2.yEc.setText(C44089j.m79294b(this.yDT, c40686a.egE, (int) c15550b2.yEc.getTextSize()));
        CharSequence a = m70278a(c40686a.yEa, (int) c15550b2.yEe.getTextSize(), c40686a.egE);
        switch (c40686a.yEa.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = C1318a.msg_state_sending;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = C1318a.msg_state_failed;
                break;
            default:
                i2 = -1;
                break;
        }
        c15550b2.yEc.setDrawRightDrawable(false);
        if (i2 != -1) {
            c15550b2.yEe.setCompoundLeftDrawablesWithIntrinsicBounds(i2);
            c15550b2.yEe.setDrawLeftDrawable(true);
        } else {
            c15550b2.yEe.setDrawLeftDrawable(false);
        }
        c15550b2.yEe.setText(a);
        c15550b2.yEe.setTextColor(C1338a.m2870h(this.yDT, (int) C25738R.color.a7x));
        if (C40687b.m70277FB(c40686a.yEa.field_msgType) == 34 && c40686a.yEa.field_isSend == 0 && !C5046bo.isNullOrNil(c40686a.yEa.field_content) && !new C42230n(c40686a.yEa.field_content).fWX) {
            c15550b2.yEe.setTextColor(C1338a.m2870h(this.yDT, (int) C25738R.color.a7y));
        }
        if (c40686a.eif) {
            if (c40686a.yEa.field_unReadCount > 0) {
                c15550b2.yEh.setVisibility(0);
            } else {
                c15550b2.yEh.setVisibility(4);
            }
            c15550b2.jJV.setVisibility(4);
        } else {
            c15550b2.yEh.setVisibility(4);
            if (c40686a.yEa.field_unReadCount > 99) {
                c15550b2.jJV.setText("");
                c15550b2.jJV.setBackgroundResource(C1318a.badge_count_more);
                c15550b2.jJV.setVisibility(0);
                C4990ab.m7418v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            } else if (c40686a.yEa.field_unReadCount > 0) {
                c15550b2.jJV.setText(c40686a.yEa.field_unReadCount);
                c15550b2.jJV.setVisibility(0);
                c15550b2.jJV.setBackgroundResource(C44385r.m80243ik(this.yDT));
                C4990ab.m7418v("MicroMsg.BizChatConversationAdapter", "has unread");
            } else {
                c15550b2.jJV.setVisibility(4);
                C4990ab.m7418v("MicroMsg.BizChatConversationAdapter", "no unread");
            }
        }
        if (c40686a.yDZ) {
            view.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6622k4);
        } else {
            view.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6623k5);
        }
        AppMethodBeat.m2505o(30047);
        return view;
    }

    private static String aqV(String str) {
        AppMethodBeat.m2504i(30048);
        if (str == null || str.length() != 32) {
            AppMethodBeat.m2505o(30048);
            return null;
        }
        String Jh = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(str);
        AppMethodBeat.m2505o(30048);
        return Jh;
    }

    /* renamed from: a */
    private CharSequence m70278a(C32232a c32232a, int i, String str) {
        AppMethodBeat.m2504i(30049);
        if (C5046bo.isNullOrNil(c32232a.field_editingMsg) || (c32232a.field_atCount > 0 && c32232a.field_unReadCount > 0)) {
            String str2;
            CharSequence charSequence;
            if (c32232a.field_msgType != null && (c32232a.field_msgType.equals("47") || c32232a.field_msgType.equals("1048625"))) {
                String aqV = C40687b.aqV(c32232a.field_digest);
                str2 = "";
                if (aqV != null) {
                    charSequence = "[" + aqV + "]";
                    AppMethodBeat.m2505o(30049);
                    return charSequence;
                }
                if (c32232a.field_digest != null && c32232a.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                    str2 = c32232a.field_digest.substring(0, c32232a.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                    aqV = C40687b.aqV(c32232a.field_digest.substring(c32232a.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                    if (aqV != null) {
                        aqV = "[" + aqV + "]";
                        if (C5046bo.isNullOrNil(str2)) {
                            AppMethodBeat.m2505o(30049);
                            return aqV;
                        }
                        charSequence = str2 + ": " + aqV;
                        AppMethodBeat.m2505o(30049);
                        return charSequence;
                    }
                }
                aqV = this.yDT.getString(C25738R.string.f9100ph);
                c32232a.field_digest = C5046bo.isNullOrNil(str2) ? aqV : str2 + ": " + aqV;
            }
            if (C5046bo.isNullOrNil(c32232a.field_digest)) {
                str2 = "";
            } else if (C5046bo.isNullOrNil(c32232a.field_digestUser)) {
                str2 = c32232a.field_digest;
            } else {
                try {
                    str2 = String.format(c32232a.field_digest, new Object[]{str});
                } catch (Exception e) {
                    str2 = c32232a.field_digest;
                }
            }
            CharSequence replace = str2.replace(10, ' ');
            if (c32232a.field_atCount <= 0 || c32232a.field_unReadCount <= 0) {
                charSequence = C44089j.m79294b(this.yDT, replace, i);
                AppMethodBeat.m2505o(30049);
                return charSequence;
            }
            charSequence = new SpannableStringBuilder(this.yDT.getString(C25738R.string.cvd));
            charSequence.setSpan(new ForegroundColorSpan(-5569532), 0, charSequence.length(), 33);
            charSequence.append(" ").append(C44089j.m79294b(this.yDT, replace, i));
            AppMethodBeat.m2505o(30049);
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.yDT.getString(C25738R.string.cvh));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append(" ").append(C44089j.m79294b(this.yDT, c32232a.field_editingMsg, i));
        AppMethodBeat.m2505o(30049);
        return spannableStringBuilder;
    }

    /* renamed from: FB */
    private static int m70277FB(String str) {
        int i = 1;
        AppMethodBeat.m2504i(30050);
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        AppMethodBeat.m2505o(30050);
        return i;
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(30051);
        mo6869KC();
        AppMethodBeat.m2505o(30051);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(30052);
        super.mo10136a(i, c7298n, obj);
        AppMethodBeat.m2505o(30052);
    }

    /* renamed from: mY */
    public final void mo64189mY(long j) {
        AppMethodBeat.m2504i(30053);
        if (this.yDY != null) {
            this.yDY.remove(String.valueOf(j));
        }
        AppMethodBeat.m2505o(30053);
    }
}
