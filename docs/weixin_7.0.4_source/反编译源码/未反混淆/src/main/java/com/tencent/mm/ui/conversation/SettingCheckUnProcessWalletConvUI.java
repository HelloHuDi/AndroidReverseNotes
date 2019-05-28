package com.tencent.mm.ui.conversation;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.tools.r;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI extends MMActivity {
    private ListView gGW;
    private int[] mtm = new int[2];
    private List<String> zvH;
    private a zvI;

    class a extends BaseAdapter {
        private float yDU = -1.0f;
        protected float yDV = -1.0f;
        private float yDW = -1.0f;
        private ColorStateList[] yDX = new ColorStateList[5];
        private HashMap<String, a> yDY;
        private final int zrx;
        private final int zry;

        class a {
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

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        class b {
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

            private b() {
            }

            /* synthetic */ b(a aVar, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(34625);
            ak Py = Py(i);
            AppMethodBeat.o(34625);
            return Py;
        }

        public a() {
            AppMethodBeat.i(34617);
            this.yDX[0] = com.tencent.mm.bz.a.h((Context) SettingCheckUnProcessWalletConvUI.this, (int) R.color.s0);
            this.yDX[1] = com.tencent.mm.bz.a.h((Context) SettingCheckUnProcessWalletConvUI.this, (int) R.color.a7y);
            this.yDX[3] = com.tencent.mm.bz.a.h((Context) SettingCheckUnProcessWalletConvUI.this, (int) R.color.w4);
            this.yDX[2] = com.tencent.mm.bz.a.h((Context) SettingCheckUnProcessWalletConvUI.this, (int) R.color.a7v);
            this.yDX[2] = com.tencent.mm.bz.a.h((Context) SettingCheckUnProcessWalletConvUI.this, (int) R.color.a7v);
            this.yDX[4] = com.tencent.mm.bz.a.h((Context) SettingCheckUnProcessWalletConvUI.this, (int) R.color.t3);
            if (com.tencent.mm.bz.a.ga(SettingCheckUnProcessWalletConvUI.this)) {
                this.zry = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.dimen.f7);
                this.zrx = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.dimen.f9);
            } else {
                this.zry = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.dimen.f6);
                this.zrx = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.dimen.f_);
            }
            this.yDU = (float) com.tencent.mm.bz.a.al(SettingCheckUnProcessWalletConvUI.this, R.dimen.m5);
            this.yDV = (float) com.tencent.mm.bz.a.al(SettingCheckUnProcessWalletConvUI.this, R.dimen.kr);
            this.yDW = (float) com.tencent.mm.bz.a.al(SettingCheckUnProcessWalletConvUI.this, R.dimen.nk);
            this.yDY = new HashMap();
            AppMethodBeat.o(34617);
        }

        public final int getCount() {
            AppMethodBeat.i(34618);
            int size = SettingCheckUnProcessWalletConvUI.this.zvH.size();
            AppMethodBeat.o(34618);
            return size;
        }

        public final ak Py(int i) {
            AppMethodBeat.i(34619);
            String str = (String) SettingCheckUnProcessWalletConvUI.this.zvH.get(i);
            aw.ZK();
            ak aoZ = c.XR().aoZ(str);
            AppMethodBeat.o(34619);
            return aoZ;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            View inflate;
            AppMethodBeat.i(34620);
            if (view == null) {
                bVar = new b(this, (byte) 0);
                if (com.tencent.mm.bz.a.ga(SettingCheckUnProcessWalletConvUI.this)) {
                    inflate = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.layout.r9, null);
                } else {
                    inflate = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.layout.r8, null);
                }
                bVar.ejo = (ImageView) inflate.findViewById(R.id.qk);
                bVar.yEc = (NoMeasuredTextView) inflate.findViewById(R.id.b6e);
                bVar.zrV = (NoMeasuredTextView) inflate.findViewById(R.id.z5);
                bVar.yEd = (NoMeasuredTextView) inflate.findViewById(R.id.b6f);
                bVar.yEe = (NoMeasuredTextView) inflate.findViewById(R.id.b6g);
                bVar.jJV = (TextView) inflate.findViewById(R.id.nf);
                bVar.jJV.setBackgroundResource(r.ik(SettingCheckUnProcessWalletConvUI.this));
                bVar.yEf = (ImageView) inflate.findViewById(R.id.b6i);
                bVar.yEh = inflate.findViewById(R.id.b6d);
                bVar.yEg = (ImageView) inflate.findViewById(R.id.b6j);
                bVar.zrW = (ImageView) inflate.findViewById(R.id.b6k);
                inflate.setTag(bVar);
                bVar.yEe.setTextSize(0, this.yDV);
                bVar.yEd.setTextSize(0, this.yDW);
                bVar.yEc.setTextSize(0, this.yDU);
                bVar.zrV.setTextSize(0, this.yDV);
                bVar.yEe.setTextColor(this.yDX[0]);
                bVar.yEd.setTextColor(this.yDX[4]);
                bVar.yEc.setTextColor(this.yDX[3]);
                bVar.zrV.setTextColor(this.yDX[0]);
                bVar.yEe.setShouldEllipsize(true);
                bVar.yEd.setShouldEllipsize(false);
                bVar.yEc.setShouldEllipsize(true);
                bVar.zrV.setShouldEllipsize(true);
                bVar.yEd.setGravity(5);
            } else {
                bVar = (b) view.getTag();
                inflate = view;
            }
            ak Py = Py(i);
            if (Py == null) {
                AppMethodBeat.o(34620);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.b(bVar.ejo, Py.field_username);
                bVar.ejo.getDrawable();
                String str = Py.field_username;
                a aVar = (a) this.yDY.get(str);
                if (aVar == null) {
                    String str2;
                    int i2;
                    a aVar2 = new a(this, (byte) 0);
                    aVar2.zrL = -1;
                    aVar2.zrK = -1;
                    aVar2.zrQ = false;
                    aVar2.zrS = false;
                    aVar2.zrR = false;
                    aVar2.mgQ = t.kH(Py.field_username);
                    boolean z = aVar2.mgQ && aVar2.zrR && Py.field_unReadCount > 0;
                    aVar2.zrP = z;
                    aVar2.klY = 0;
                    if (FB(Py.field_msgType) == 34 && Py.field_isSend == 0 && !ah.isNullOrNil(Py.field_content)) {
                        str2 = Py.field_content;
                        if (str.equals("qmessage") || str.equals("floatbottle")) {
                            String[] split = str2.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                            if (split != null && split.length > 3) {
                                str2 = split[1] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[2] + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + split[3];
                            }
                        }
                        if (!new n(str2).fWX) {
                            aVar2.klY = 1;
                        }
                    }
                    str2 = s.mJ(str);
                    if (aVar2.mgQ && str2 == null) {
                        aVar2.nickName = SettingCheckUnProcessWalletConvUI.this.getString(R.string.ao1);
                    } else {
                        aVar2.nickName = j.b(SettingCheckUnProcessWalletConvUI.this, s.mJ(str), bVar.yEc.getTextSize());
                    }
                    aVar2.zrH = h(Py);
                    aVar2.zrI = c(Py, (int) bVar.yEe.getTextSize(), aVar2.zrP);
                    aVar2.zrT = Py.field_attrflag;
                    switch (Py.field_status) {
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
                    aVar2.zrJ = i2;
                    aVar2.zrM = t.a(Py);
                    aw.ZK();
                    aVar2.yDZ = c.XR().g(Py);
                    aVar2.zrN = false;
                    aVar2.zrO = aa.don();
                    this.yDY.put(str, aVar2);
                    aVar = aVar2;
                }
                if (aVar.zrH == null) {
                    aVar.zrH = h(Py);
                }
                if (aVar.zrP || t.ny(Py.field_parentRef)) {
                    bVar.yEe.setTextColor(this.yDX[0]);
                } else {
                    bVar.yEe.setTextColor(this.yDX[aVar.klY]);
                }
                if (str.toLowerCase().endsWith("@t.qq.com")) {
                    bVar.yEc.setCompoundRightDrawablesWithIntrinsicBounds((int) R.drawable.icon_tencent_weibo);
                    bVar.yEc.setDrawRightDrawable(true);
                } else {
                    bVar.yEc.setDrawRightDrawable(false);
                }
                int i3 = aVar.zrJ;
                if (i3 != -1) {
                    bVar.yEe.setCompoundLeftDrawablesWithIntrinsicBounds(i3);
                    bVar.yEe.setDrawLeftDrawable(true);
                } else {
                    bVar.yEe.setDrawLeftDrawable(false);
                }
                bVar.yEc.setText(aVar.nickName);
                bVar.zrV.setVisibility(8);
                LayoutParams layoutParams = bVar.yEd.getLayoutParams();
                if (aVar.zrH.length() > 9) {
                    if (layoutParams.width != this.zry) {
                        layoutParams.width = this.zry;
                        bVar.yEd.setLayoutParams(layoutParams);
                    }
                } else if (layoutParams.width != this.zrx) {
                    layoutParams.width = this.zrx;
                    bVar.yEd.setLayoutParams(layoutParams);
                }
                ab.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", Integer.valueOf(layoutParams.width));
                bVar.yEd.setText(aVar.zrH);
                bVar.yEe.setText(aVar.zrI);
                if (aVar.mgQ && aVar.zrR) {
                    bVar.yEf.setVisibility(0);
                } else if (aVar.zrN) {
                    bVar.yEf.setVisibility(0);
                } else {
                    bVar.yEf.setVisibility(8);
                }
                com.tencent.mm.pluginsdk.ui.a.b.b(bVar.ejo, str);
                if (!aVar.zrM && aVar.yDZ && aw.RK()) {
                    aw.ZK();
                    c.XR().f(Py);
                }
                if (!aVar.yDZ || Py.field_conversationTime == -1) {
                    inflate.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k5);
                } else {
                    inflate.findViewById(R.id.b6c).setBackgroundResource(R.drawable.k4);
                }
                bVar.yEg.setVisibility(8);
                AppMethodBeat.o(34620);
            }
            return inflate;
        }

        private static int FB(String str) {
            int i = 1;
            AppMethodBeat.i(34621);
            if (str != null && str.length() > 0) {
                try {
                    i = Integer.valueOf(str).intValue();
                } catch (NumberFormatException e) {
                }
            }
            AppMethodBeat.o(34621);
            return i;
        }

        private static String aqV(String str) {
            AppMethodBeat.i(34624);
            if (str == null || str.length() != 32) {
                AppMethodBeat.o(34624);
                return null;
            }
            String Jh = ((d) g.M(d.class)).getEmojiMgr().Jh(str);
            AppMethodBeat.o(34624);
            return Jh;
        }

        private CharSequence h(ak akVar) {
            AppMethodBeat.i(34622);
            CharSequence charSequence;
            if (akVar.field_status == 1) {
                String string = SettingCheckUnProcessWalletConvUI.this.getString(R.string.cw8);
                AppMethodBeat.o(34622);
                return string;
            } else if (akVar.field_conversationTime == Long.MAX_VALUE) {
                charSequence = "";
                AppMethodBeat.o(34622);
                return charSequence;
            } else {
                charSequence = h.c(SettingCheckUnProcessWalletConvUI.this, akVar.field_conversationTime, true);
                AppMethodBeat.o(34622);
                return charSequence;
            }
        }

        private CharSequence c(ak akVar, int i, boolean z) {
            AppMethodBeat.i(34623);
            if (ah.isNullOrNil(akVar.field_editingMsg) || (akVar.field_atCount > 0 && akVar.field_unReadCount > 0)) {
                CharSequence charSequence = akVar.field_digest;
                CharSequence string;
                if (charSequence == null || !charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                    int i2;
                    String str;
                    String str2 = akVar.field_username;
                    if (str2.equals("qqmail")) {
                        aw.ZK();
                        if (ah.h((Integer) c.Ry().get(17, null)) == 1) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 == 0) {
                            string = SettingCheckUnProcessWalletConvUI.this.getString(R.string.e_7);
                            AppMethodBeat.o(34623);
                            return string;
                        }
                    }
                    if (str2.equals("tmessage")) {
                        aw.ZK();
                        bq RA = c.XU().RA("@t.qq.com");
                        if (RA == null || !RA.isEnable()) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        if (i2 == 0) {
                            string = SettingCheckUnProcessWalletConvUI.this.getString(R.string.e_7);
                            AppMethodBeat.o(34623);
                            return string;
                        }
                    }
                    if (akVar.field_msgType != null && (akVar.field_msgType.equals("47") || akVar.field_msgType.equals("1048625"))) {
                        str2 = aqV(akVar.field_digest);
                        str = "";
                        if (str2 != null) {
                            string = "[" + str2 + "]";
                            AppMethodBeat.o(34623);
                            return string;
                        }
                        if (akVar.field_digest != null && akVar.field_digest.contains(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)) {
                            str = akVar.field_digest.substring(0, akVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D));
                            str2 = aqV(akVar.field_digest.substring(akVar.field_digest.indexOf(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D) + 1).replace(" ", ""));
                            if (str2 != null) {
                                str2 = "[" + str2 + "]";
                                if (ah.isNullOrNil(str)) {
                                    AppMethodBeat.o(34623);
                                    return str2;
                                }
                                string = str + ": " + str2;
                                AppMethodBeat.o(34623);
                                return string;
                            }
                        }
                        str2 = SettingCheckUnProcessWalletConvUI.this.getString(R.string.ph);
                        if (ah.isNullOrNil(str)) {
                            str = str2;
                        } else {
                            str = str + ": " + str2;
                        }
                        akVar.jh(str);
                    }
                    if (!ah.isNullOrNil(akVar.field_digest)) {
                        if (ah.isNullOrNil(akVar.field_digestUser)) {
                            str = akVar.field_digest;
                        } else {
                            if (akVar.field_isSend == 0 && t.kH(akVar.field_username)) {
                                str = s.getDisplayName(akVar.field_digestUser, akVar.field_username);
                            } else {
                                str = s.mJ(akVar.field_digestUser);
                            }
                            try {
                                str = String.format(akVar.field_digest, new Object[]{str});
                            } catch (Exception e) {
                            }
                        }
                        string = str.replace(10, ' ');
                        if (akVar.field_atCount > 0 || akVar.field_unReadCount <= 0) {
                            if (!z && akVar.field_unReadCount > 1) {
                                string = SettingCheckUnProcessWalletConvUI.this.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), string});
                            } else if (akVar.field_unReadCount > 1 && t.ny(akVar.field_parentRef)) {
                                string = SettingCheckUnProcessWalletConvUI.this.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), string});
                            }
                            string = j.b(SettingCheckUnProcessWalletConvUI.this, string, i);
                            AppMethodBeat.o(34623);
                            return string;
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.string.cvd));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                        spannableStringBuilder.append(" ").append(j.b(SettingCheckUnProcessWalletConvUI.this, string, i));
                        AppMethodBeat.o(34623);
                        return spannableStringBuilder;
                    }
                    str = com.tencent.mm.booter.notification.a.h.a(akVar.field_isSend, akVar.field_username, akVar.field_content, FB(akVar.field_msgType), SettingCheckUnProcessWalletConvUI.this);
                    string = str.replace(10, ' ');
                    if (akVar.field_atCount > 0) {
                    }
                    if (!z) {
                    }
                    string = SettingCheckUnProcessWalletConvUI.this.getString(R.string.cvg, new Object[]{Integer.valueOf(akVar.field_unReadCount), string});
                    string = j.b(SettingCheckUnProcessWalletConvUI.this, string, i);
                    AppMethodBeat.o(34623);
                    return string;
                }
                string = new SpannableString(j.e(SettingCheckUnProcessWalletConvUI.this, charSequence, (float) i));
                AppMethodBeat.o(34623);
                return string;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.string.cvh));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder2.append(" ").append(j.b(SettingCheckUnProcessWalletConvUI.this, akVar.field_editingMsg, i));
            AppMethodBeat.o(34623);
            return spannableStringBuilder2;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingCheckUnProcessWalletConvUI() {
        AppMethodBeat.i(34626);
        AppMethodBeat.o(34626);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34627);
        super.onCreate(bundle);
        setMMTitle((int) R.string.fdp);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(34610);
                SettingCheckUnProcessWalletConvUI.this.finish();
                AppMethodBeat.o(34610);
                return false;
            }
        });
        this.gGW = (ListView) findViewById(R.id.e9g);
        this.zvH = getIntent().getStringArrayListExtra("key_conversation_list");
        if (this.zvH != null && this.zvH.size() > 0) {
            this.zvI = new a();
            this.gGW.setAdapter(this.zvI);
            this.gGW.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(34611);
                    switch (motionEvent.getAction()) {
                        case 0:
                            SettingCheckUnProcessWalletConvUI.this.aqX();
                            SettingCheckUnProcessWalletConvUI.this.mtm[0] = (int) motionEvent.getRawX();
                            SettingCheckUnProcessWalletConvUI.this.mtm[1] = (int) motionEvent.getRawY();
                            break;
                    }
                    AppMethodBeat.o(34611);
                    return false;
                }
            });
            this.gGW.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(34612);
                    ak Py = SettingCheckUnProcessWalletConvUI.this.zvI.Py(i);
                    if (Py == null) {
                        AppMethodBeat.o(34612);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", Py.field_username);
                    intent.putExtra("chat_from_scene", 4);
                    com.tencent.mm.bp.d.f(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", intent);
                    AppMethodBeat.o(34612);
                }
            });
            this.gGW.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(34616);
                    final ak Py = SettingCheckUnProcessWalletConvUI.this.zvI.Py(i - SettingCheckUnProcessWalletConvUI.this.gGW.getHeaderViewsCount());
                    if (Py == null) {
                        AppMethodBeat.o(34616);
                        return true;
                    }
                    final String str = Py.field_username;
                    com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(SettingCheckUnProcessWalletConvUI.this);
                    aVar.zRZ = new OnCreateContextMenuListener() {
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(34613);
                            contextMenu.add(0, 1, 0, R.string.cvq);
                            AppMethodBeat.o(34613);
                        }
                    };
                    aVar.a(view, i, j, SettingCheckUnProcessWalletConvUI.this, new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(34615);
                            if (menuItem.getItemId() == 1) {
                                c.a(str, SettingCheckUnProcessWalletConvUI.this, Py, new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(34614);
                                        SettingCheckUnProcessWalletConvUI.this.zvH.remove(str);
                                        SettingCheckUnProcessWalletConvUI.this.zvI.notifyDataSetChanged();
                                        AppMethodBeat.o(34614);
                                    }
                                }, false, true);
                            }
                            AppMethodBeat.o(34615);
                        }
                    }, SettingCheckUnProcessWalletConvUI.this.mtm[0], SettingCheckUnProcessWalletConvUI.this.mtm[1]);
                    AppMethodBeat.o(34616);
                    return true;
                }
            });
        }
        AppMethodBeat.o(34627);
    }

    public final int getLayoutId() {
        return R.layout.arg;
    }
}
