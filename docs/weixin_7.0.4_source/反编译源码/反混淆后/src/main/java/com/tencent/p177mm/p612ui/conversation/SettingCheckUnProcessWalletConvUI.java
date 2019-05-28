package com.tencent.p177mm.p612ui.conversation;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.booter.notification.p841a.C37622h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C42230n;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.NoMeasuredTextView;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI */
public class SettingCheckUnProcessWalletConvUI extends MMActivity {
    private ListView gGW;
    private int[] mtm = new int[2];
    private List<String> zvH;
    private C7973a zvI;

    /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$4 */
    class C79694 implements OnItemLongClickListener {

        /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$4$1 */
        class C79701 implements OnCreateContextMenuListener {
            C79701() {
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(34613);
                contextMenu.add(0, 1, 0, C25738R.string.cvq);
                AppMethodBeat.m2505o(34613);
            }
        }

        C79694() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(34616);
            final C7617ak Py = SettingCheckUnProcessWalletConvUI.this.zvI.mo17791Py(i - SettingCheckUnProcessWalletConvUI.this.gGW.getHeaderViewsCount());
            if (Py == null) {
                AppMethodBeat.m2505o(34616);
                return true;
            }
            final String str = Py.field_username;
            C24088a c24088a = new C24088a(SettingCheckUnProcessWalletConvUI.this);
            c24088a.zRZ = new C79701();
            c24088a.mo39885a(view, i, j, SettingCheckUnProcessWalletConvUI.this, new C5279d() {

                /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$4$2$1 */
                class C79721 implements Runnable {
                    C79721() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(34614);
                        SettingCheckUnProcessWalletConvUI.this.zvH.remove(str);
                        SettingCheckUnProcessWalletConvUI.this.zvI.notifyDataSetChanged();
                        AppMethodBeat.m2505o(34614);
                    }
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(34615);
                    if (menuItem.getItemId() == 1) {
                        C36270c.m59699a(str, SettingCheckUnProcessWalletConvUI.this, Py, new C79721(), false, true);
                    }
                    AppMethodBeat.m2505o(34615);
                }
            }, SettingCheckUnProcessWalletConvUI.this.mtm[0], SettingCheckUnProcessWalletConvUI.this.mtm[1]);
            AppMethodBeat.m2505o(34616);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$a */
    class C7973a extends BaseAdapter {
        private float yDU = -1.0f;
        protected float yDV = -1.0f;
        private float yDW = -1.0f;
        private ColorStateList[] yDX = new ColorStateList[5];
        private HashMap<String, C7974a> yDY;
        private final int zrx;
        private final int zry;

        /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$a$a */
        class C7974a {
            public int klY;
            public boolean mgQ;
            public CharSequence nickName;
            public boolean yDZ;
            public CharSequence zrH;
            public CharSequence zrI;
            public int zrJ;
            public int zrK;
            public int zrL;
            public boolean zrM;
            public boolean zrN;
            public boolean zrO;
            public boolean zrP;
            public boolean zrQ;
            public boolean zrR;
            public boolean zrS;
            public int zrT;

            private C7974a() {
            }

            /* synthetic */ C7974a(C7973a c7973a, byte b) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$a$b */
        class C7975b {
            public ImageView ejo;
            public TextView jJV;
            public NoMeasuredTextView yEc;
            public NoMeasuredTextView yEd;
            public NoMeasuredTextView yEe;
            public ImageView yEf;
            public ImageView yEg;
            public View yEh;
            public NoMeasuredTextView zrV;
            public ImageView zrW;

            private C7975b() {
            }

            /* synthetic */ C7975b(C7973a c7973a, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(34625);
            C7617ak Py = mo17791Py(i);
            AppMethodBeat.m2505o(34625);
            return Py;
        }

        public C7973a() {
            AppMethodBeat.m2504i(34617);
            this.yDX[0] = C1338a.m2870h((Context) SettingCheckUnProcessWalletConvUI.this, (int) C25738R.color.f12092s0);
            this.yDX[1] = C1338a.m2870h((Context) SettingCheckUnProcessWalletConvUI.this, (int) C25738R.color.a7y);
            this.yDX[3] = C1338a.m2870h((Context) SettingCheckUnProcessWalletConvUI.this, (int) C25738R.color.f12212w4);
            this.yDX[2] = C1338a.m2870h((Context) SettingCheckUnProcessWalletConvUI.this, (int) C25738R.color.a7v);
            this.yDX[2] = C1338a.m2870h((Context) SettingCheckUnProcessWalletConvUI.this, (int) C25738R.color.a7v);
            this.yDX[4] = C1338a.m2870h((Context) SettingCheckUnProcessWalletConvUI.this, (int) C25738R.color.f12120t3);
            if (C1338a.m2865ga(SettingCheckUnProcessWalletConvUI.this)) {
                this.zry = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9771f7);
                this.zrx = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9773f9);
            } else {
                this.zry = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9770f6);
                this.zrx = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(C25738R.dimen.f9774f_);
            }
            this.yDU = (float) C1338a.m2856al(SettingCheckUnProcessWalletConvUI.this, C25738R.dimen.f9980m5);
            this.yDV = (float) C1338a.m2856al(SettingCheckUnProcessWalletConvUI.this, C25738R.dimen.f9936kr);
            this.yDW = (float) C1338a.m2856al(SettingCheckUnProcessWalletConvUI.this, C25738R.dimen.f10018nk);
            this.yDY = new HashMap();
            AppMethodBeat.m2505o(34617);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(34618);
            int size = SettingCheckUnProcessWalletConvUI.this.zvH.size();
            AppMethodBeat.m2505o(34618);
            return size;
        }

        /* renamed from: Py */
        public final C7617ak mo17791Py(int i) {
            AppMethodBeat.m2504i(34619);
            String str = (String) SettingCheckUnProcessWalletConvUI.this.zvH.get(i);
            C9638aw.m17190ZK();
            C7617ak aoZ = C18628c.m29083XR().aoZ(str);
            AppMethodBeat.m2505o(34619);
            return aoZ;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C7975b c7975b;
            View inflate;
            AppMethodBeat.m2504i(34620);
            if (view == null) {
                c7975b = new C7975b(this, (byte) 0);
                if (C1338a.m2865ga(SettingCheckUnProcessWalletConvUI.this)) {
                    inflate = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2130969242, null);
                } else {
                    inflate = View.inflate(SettingCheckUnProcessWalletConvUI.this, 2130969241, null);
                }
                c7975b.ejo = (ImageView) inflate.findViewById(2131821183);
                c7975b.yEc = (NoMeasuredTextView) inflate.findViewById(2131823149);
                c7975b.zrV = (NoMeasuredTextView) inflate.findViewById(2131821512);
                c7975b.yEd = (NoMeasuredTextView) inflate.findViewById(2131823150);
                c7975b.yEe = (NoMeasuredTextView) inflate.findViewById(2131823151);
                c7975b.jJV = (TextView) inflate.findViewById(2131821067);
                c7975b.jJV.setBackgroundResource(C44385r.m80243ik(SettingCheckUnProcessWalletConvUI.this));
                c7975b.yEf = (ImageView) inflate.findViewById(2131823153);
                c7975b.yEh = inflate.findViewById(2131823148);
                c7975b.yEg = (ImageView) inflate.findViewById(2131823154);
                c7975b.zrW = (ImageView) inflate.findViewById(2131823155);
                inflate.setTag(c7975b);
                c7975b.yEe.setTextSize(0, this.yDV);
                c7975b.yEd.setTextSize(0, this.yDW);
                c7975b.yEc.setTextSize(0, this.yDU);
                c7975b.zrV.setTextSize(0, this.yDV);
                c7975b.yEe.setTextColor(this.yDX[0]);
                c7975b.yEd.setTextColor(this.yDX[4]);
                c7975b.yEc.setTextColor(this.yDX[3]);
                c7975b.zrV.setTextColor(this.yDX[0]);
                c7975b.yEe.setShouldEllipsize(true);
                c7975b.yEd.setShouldEllipsize(false);
                c7975b.yEc.setShouldEllipsize(true);
                c7975b.zrV.setShouldEllipsize(true);
                c7975b.yEd.setGravity(5);
            } else {
                c7975b = (C7975b) view.getTag();
                inflate = view;
            }
            C7617ak Py = mo17791Py(i);
            if (Py == null) {
                AppMethodBeat.m2505o(34620);
            } else {
                C40460b.m69434b(c7975b.ejo, Py.field_username);
                c7975b.ejo.getDrawable();
                String str = Py.field_username;
                C7974a c7974a = (C7974a) this.yDY.get(str);
                if (c7974a == null) {
                    String str2;
                    int i2;
                    C7974a c7974a2 = new C7974a(this, (byte) 0);
                    c7974a2.zrL = -1;
                    c7974a2.zrK = -1;
                    c7974a2.zrQ = false;
                    c7974a2.zrS = false;
                    c7974a2.zrR = false;
                    c7974a2.mgQ = C1855t.m3896kH(Py.field_username);
                    boolean z = c7974a2.mgQ && c7974a2.zrR && Py.field_unReadCount > 0;
                    c7974a2.zrP = z;
                    c7974a2.klY = 0;
                    if (C7973a.m14164FB(Py.field_msgType) == 34 && Py.field_isSend == 0 && !C42252ah.isNullOrNil(Py.field_content)) {
                        str2 = Py.field_content;
                        if (str.equals("qmessage") || str.equals("floatbottle")) {
                            String[] split = str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                            if (split != null && split.length > 3) {
                                str2 = split[1] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[2] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[3];
                            }
                        }
                        if (!new C42230n(str2).fWX) {
                            c7974a2.klY = 1;
                        }
                    }
                    str2 = C1854s.m3866mJ(str);
                    if (c7974a2.mgQ && str2 == null) {
                        c7974a2.nickName = SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.ao1);
                    } else {
                        c7974a2.nickName = C44089j.m79293b(SettingCheckUnProcessWalletConvUI.this, C1854s.m3866mJ(str), c7975b.yEc.getTextSize());
                    }
                    c7974a2.zrH = m14166h(Py);
                    c7974a2.zrI = m14165c(Py, (int) c7975b.yEe.getTextSize(), c7974a2.zrP);
                    c7974a2.zrT = Py.field_attrflag;
                    switch (Py.field_status) {
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
                    c7974a2.zrJ = i2;
                    c7974a2.zrM = C1855t.m3881a(Py);
                    C9638aw.m17190ZK();
                    c7974a2.yDZ = C18628c.m29083XR().mo15822g(Py);
                    c7974a2.zrN = false;
                    c7974a2.zrO = C4988aa.don();
                    this.yDY.put(str, c7974a2);
                    c7974a = c7974a2;
                }
                if (c7974a.zrH == null) {
                    c7974a.zrH = m14166h(Py);
                }
                if (c7974a.zrP || C1855t.m3956ny(Py.field_parentRef)) {
                    c7975b.yEe.setTextColor(this.yDX[0]);
                } else {
                    c7975b.yEe.setTextColor(this.yDX[c7974a.klY]);
                }
                if (str.toLowerCase().endsWith("@t.qq.com")) {
                    c7975b.yEc.setCompoundRightDrawablesWithIntrinsicBounds((int) C25738R.drawable.icon_tencent_weibo);
                    c7975b.yEc.setDrawRightDrawable(true);
                } else {
                    c7975b.yEc.setDrawRightDrawable(false);
                }
                int i3 = c7974a.zrJ;
                if (i3 != -1) {
                    c7975b.yEe.setCompoundLeftDrawablesWithIntrinsicBounds(i3);
                    c7975b.yEe.setDrawLeftDrawable(true);
                } else {
                    c7975b.yEe.setDrawLeftDrawable(false);
                }
                c7975b.yEc.setText(c7974a.nickName);
                c7975b.zrV.setVisibility(8);
                LayoutParams layoutParams = c7975b.yEd.getLayoutParams();
                if (c7974a.zrH.length() > 9) {
                    if (layoutParams.width != this.zry) {
                        layoutParams.width = this.zry;
                        c7975b.yEd.setLayoutParams(layoutParams);
                    }
                } else if (layoutParams.width != this.zrx) {
                    layoutParams.width = this.zrx;
                    c7975b.yEd.setLayoutParams(layoutParams);
                }
                C4990ab.m7419v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", Integer.valueOf(layoutParams.width));
                c7975b.yEd.setText(c7974a.zrH);
                c7975b.yEe.setText(c7974a.zrI);
                if (c7974a.mgQ && c7974a.zrR) {
                    c7975b.yEf.setVisibility(0);
                } else if (c7974a.zrN) {
                    c7975b.yEf.setVisibility(0);
                } else {
                    c7975b.yEf.setVisibility(8);
                }
                C40460b.m69434b(c7975b.ejo, str);
                if (!c7974a.zrM && c7974a.yDZ && C9638aw.m17179RK()) {
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().mo15821f(Py);
                }
                if (!c7974a.yDZ || Py.field_conversationTime == -1) {
                    inflate.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6623k5);
                } else {
                    inflate.findViewById(2131823147).setBackgroundResource(C25738R.drawable.f6622k4);
                }
                c7975b.yEg.setVisibility(8);
                AppMethodBeat.m2505o(34620);
            }
            return inflate;
        }

        /* renamed from: FB */
        private static int m14164FB(String str) {
            int i = 1;
            AppMethodBeat.m2504i(34621);
            if (str != null && str.length() > 0) {
                try {
                    i = Integer.valueOf(str).intValue();
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.m2505o(34621);
            return i;
        }

        private static String aqV(String str) {
            AppMethodBeat.m2504i(34624);
            if (str == null || str.length() != 32) {
                AppMethodBeat.m2505o(34624);
                return null;
            }
            String Jh = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35600Jh(str);
            AppMethodBeat.m2505o(34624);
            return Jh;
        }

        /* renamed from: h */
        private CharSequence m14166h(C7617ak c7617ak) {
            AppMethodBeat.m2504i(34622);
            CharSequence charSequence;
            if (c7617ak.field_status == 1) {
                String string = SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.cw8);
                AppMethodBeat.m2505o(34622);
                return string;
            } else if (c7617ak.field_conversationTime == Long.MAX_VALUE) {
                charSequence = "";
                AppMethodBeat.m2505o(34622);
                return charSequence;
            } else {
                charSequence = C14835h.m23089c(SettingCheckUnProcessWalletConvUI.this, c7617ak.field_conversationTime, true);
                AppMethodBeat.m2505o(34622);
                return charSequence;
            }
        }

        /* renamed from: c */
        private CharSequence m14165c(C7617ak c7617ak, int i, boolean z) {
            AppMethodBeat.m2504i(34623);
            if (C42252ah.isNullOrNil(c7617ak.field_editingMsg) || (c7617ak.field_atCount > 0 && c7617ak.field_unReadCount > 0)) {
                CharSequence charSequence = c7617ak.field_digest;
                CharSequence string;
                if (charSequence == null || !charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                    int i2;
                    String str;
                    String str2 = c7617ak.field_username;
                    if (str2.equals("qqmail")) {
                        C9638aw.m17190ZK();
                        if (C42252ah.m74624h((Integer) C18628c.m29072Ry().get(17, null)) == 1) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 == 0) {
                            string = SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.e_7);
                            AppMethodBeat.m2505o(34623);
                            return string;
                        }
                    }
                    if (str2.equals("tmessage")) {
                        C9638aw.m17190ZK();
                        C5140bq RA = C18628c.m29086XU().mo15356RA("@t.qq.com");
                        if (RA == null || !RA.isEnable()) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i2 == 0) {
                            string = SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.e_7);
                            AppMethodBeat.m2505o(34623);
                            return string;
                        }
                    }
                    if (c7617ak.field_msgType != null && (c7617ak.field_msgType.equals("47") || c7617ak.field_msgType.equals("1048625"))) {
                        str2 = C7973a.aqV(c7617ak.field_digest);
                        str = "";
                        if (str2 != null) {
                            string = "[" + str2 + "]";
                            AppMethodBeat.m2505o(34623);
                            return string;
                        }
                        if (c7617ak.field_digest != null && c7617ak.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                            str = c7617ak.field_digest.substring(0, c7617ak.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                            str2 = C7973a.aqV(c7617ak.field_digest.substring(c7617ak.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                            if (str2 != null) {
                                str2 = "[" + str2 + "]";
                                if (C42252ah.isNullOrNil(str)) {
                                    AppMethodBeat.m2505o(34623);
                                    return str2;
                                }
                                string = str + ": " + str2;
                                AppMethodBeat.m2505o(34623);
                                return string;
                            }
                        }
                        str2 = SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.f9100ph);
                        if (C42252ah.isNullOrNil(str)) {
                            str = str2;
                        } else {
                            str = str + ": " + str2;
                        }
                        c7617ak.mo14758jh(str);
                    }
                    if (!C42252ah.isNullOrNil(c7617ak.field_digest)) {
                        if (C42252ah.isNullOrNil(c7617ak.field_digestUser)) {
                            str = c7617ak.field_digest;
                        } else {
                            if (c7617ak.field_isSend == 0 && C1855t.m3896kH(c7617ak.field_username)) {
                                str = C1854s.getDisplayName(c7617ak.field_digestUser, c7617ak.field_username);
                            } else {
                                str = C1854s.m3866mJ(c7617ak.field_digestUser);
                            }
                            try {
                                str = String.format(c7617ak.field_digest, new Object[]{str});
                            } catch (Exception e) {
                            }
                        }
                        string = str.replace(10, ' ');
                        if (c7617ak.field_atCount > 0 || c7617ak.field_unReadCount <= 0) {
                            if (!z && c7617ak.field_unReadCount > 1) {
                                string = SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), string});
                            } else if (c7617ak.field_unReadCount > 1 && C1855t.m3956ny(c7617ak.field_parentRef)) {
                                string = SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), string});
                            }
                            string = C44089j.m79294b(SettingCheckUnProcessWalletConvUI.this, string, i);
                            AppMethodBeat.m2505o(34623);
                            return string;
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.cvd));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                        spannableStringBuilder.append(" ").append(C44089j.m79294b(SettingCheckUnProcessWalletConvUI.this, string, i));
                        AppMethodBeat.m2505o(34623);
                        return spannableStringBuilder;
                    }
                    str = C37622h.m63519a(c7617ak.field_isSend, c7617ak.field_username, c7617ak.field_content, C7973a.m14164FB(c7617ak.field_msgType), SettingCheckUnProcessWalletConvUI.this);
                    string = str.replace(10, ' ');
                    if (c7617ak.field_atCount > 0) {
                    }
                    if (!z) {
                    }
                    string = SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.cvg, new Object[]{Integer.valueOf(c7617ak.field_unReadCount), string});
                    string = C44089j.m79294b(SettingCheckUnProcessWalletConvUI.this, string, i);
                    AppMethodBeat.m2505o(34623);
                    return string;
                }
                string = new SpannableString(C44089j.m79303e(SettingCheckUnProcessWalletConvUI.this, charSequence, (float) i));
                AppMethodBeat.m2505o(34623);
                return string;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(C25738R.string.cvh));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.append(" ").append(C44089j.m79294b(SettingCheckUnProcessWalletConvUI.this, c7617ak.field_editingMsg, i));
            AppMethodBeat.m2505o(34623);
            return spannableStringBuilder2;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$1 */
    class C79761 implements OnMenuItemClickListener {
        C79761() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34610);
            SettingCheckUnProcessWalletConvUI.this.finish();
            AppMethodBeat.m2505o(34610);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$3 */
    class C79773 implements OnItemClickListener {
        C79773() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(34612);
            C7617ak Py = SettingCheckUnProcessWalletConvUI.this.zvI.mo17791Py(i);
            if (Py == null) {
                AppMethodBeat.m2505o(34612);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Chat_User", Py.field_username);
            intent.putExtra("chat_from_scene", 4);
            C25985d.m41473f(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.m2505o(34612);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.SettingCheckUnProcessWalletConvUI$2 */
    class C79782 implements OnTouchListener {
        C79782() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(34611);
            switch (motionEvent.getAction()) {
                case 0:
                    SettingCheckUnProcessWalletConvUI.this.aqX();
                    SettingCheckUnProcessWalletConvUI.this.mtm[0] = (int) motionEvent.getRawX();
                    SettingCheckUnProcessWalletConvUI.this.mtm[1] = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(34611);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingCheckUnProcessWalletConvUI() {
        AppMethodBeat.m2504i(34626);
        AppMethodBeat.m2505o(34626);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34627);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.fdp);
        setBackBtn(new C79761());
        this.gGW = (ListView) findViewById(2131827368);
        this.zvH = getIntent().getStringArrayListExtra("key_conversation_list");
        if (this.zvH != null && this.zvH.size() > 0) {
            this.zvI = new C7973a();
            this.gGW.setAdapter(this.zvI);
            this.gGW.setOnTouchListener(new C79782());
            this.gGW.setOnItemClickListener(new C79773());
            this.gGW.setOnItemLongClickListener(new C79694());
        }
        AppMethodBeat.m2505o(34627);
    }

    public final int getLayoutId() {
        return 2130970622;
    }
}
