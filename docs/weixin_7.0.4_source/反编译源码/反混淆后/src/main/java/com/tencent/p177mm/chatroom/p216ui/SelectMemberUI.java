package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p184aj.C8935m;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.EllipsizeTextView;
import com.tencent.p177mm.p612ui.base.MaskLayout;
import com.tencent.p177mm.p612ui.base.MaskLayout.C23622a;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar.C30374a;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI */
public class SelectMemberUI extends MMActivity {
    protected C7577u eih;
    protected String ejD;
    private MMEditText elU;
    private SelectMemberScrollBar emA;
    protected C7659b emB;
    protected int emC;
    protected HashSet<String> emD;
    private boolean emE;
    private boolean emF;
    private View emy;
    private View emz;
    private ListView mListView;
    protected String mTitle;

    /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$a */
    public class C7658a {
        public C7616ad ehM;
        public int type = 1;

        public C7658a(C7616ad c7616ad) {
            this.ehM = c7616ad;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$b */
    public class C7659b extends BaseAdapter {
        private List<C7658a> cFX = new ArrayList();
        private C7577u eih;
        private String ejD;
        public final String emJ = new String(Character.toChars(91));
        HashMap<String, Integer> emK = new HashMap();
        public String ema;
        private String emc = null;
        private List<C7658a> emd = new ArrayList(0);
        volatile boolean isLoading = false;
        private Context mContext;

        /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$b$5 */
        class C76605 implements OnClickListener {
            C76605() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(104417);
                SelectMemberUI.this.mo17467a(view, ((C7666c) view.getTag()).position, (long) view.getId());
                AppMethodBeat.m2505o(104417);
            }
        }

        /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$b$6 */
        class C76616 implements Comparator<C7658a> {
            C76616() {
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.m2504i(104418);
                int compareToIgnoreCase = C9790g.m17432vo(C7659b.m13692a(C7659b.this, ((C7658a) obj).ehM)).compareToIgnoreCase(C9790g.m17432vo(C7659b.m13692a(C7659b.this, ((C7658a) obj2).ehM)));
                AppMethodBeat.m2505o(104418);
                return compareToIgnoreCase;
            }
        }

        /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$b$2 */
        class C76622 implements Runnable {
            C76622() {
            }

            public final void run() {
                AppMethodBeat.m2504i(104414);
                C7659b.this.notifyDataSetChanged();
                if (C7659b.this.cFX == null || C7659b.this.cFX.size() != 0) {
                    SelectMemberUI.this.mListView.setVisibility(0);
                    SelectMemberUI.this.emy.setVisibility(8);
                    AppMethodBeat.m2505o(104414);
                    return;
                }
                SelectMemberUI.this.mListView.setVisibility(8);
                SelectMemberUI.this.emy.setVisibility(0);
                AppMethodBeat.m2505o(104414);
            }
        }

        /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$b$1 */
        class C76651 implements Runnable {

            /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$b$1$1 */
            class C13861 implements Runnable {
                C13861() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(104412);
                    C7659b.this.isLoading = false;
                    SelectMemberUI.this.emz.setVisibility(8);
                    C7659b.this.notifyDataSetChanged();
                    AppMethodBeat.m2505o(104412);
                }
            }

            C76651() {
            }

            public final void run() {
                AppMethodBeat.m2504i(104413);
                C7659b.this.isLoading = true;
                long currentTimeMillis = System.currentTimeMillis();
                C7659b.this.mo17469Q(SelectMemberUI.this.mo17465Kx());
                C7659b.m13693a(C7659b.this);
                C4990ab.m7417i("MicroMsg.SelectMemberAdapter", "[load data] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                C5004al.m7441d(new C13861());
                AppMethodBeat.m2505o(104413);
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(104426);
            C7658a iH = mo17474iH(i);
            AppMethodBeat.m2505o(104426);
            return iH;
        }

        public C7659b(Context context, C7577u c7577u, String str, String str2) {
            AppMethodBeat.m2504i(104419);
            this.eih = c7577u;
            this.ejD = str;
            this.emc = str2;
            this.mContext = context;
            AppMethodBeat.m2505o(104419);
        }

        /* renamed from: kn */
        public final void mo17475kn(String str) {
            AppMethodBeat.m2504i(104420);
            C4990ab.m7416i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
            ArrayList arrayList = new ArrayList();
            if (C5046bo.isNullOrNil(str)) {
                this.cFX = this.emd;
                AppMethodBeat.m2505o(104420);
                return;
            }
            for (C7658a c7658a : this.emd) {
                if (!(c7658a == null || c7658a.ehM == null || c7658a.type != 1)) {
                    C7616ad c7616ad = c7658a.ehM;
                    if (c7616ad.field_conRemark != null && c7616ad.field_conRemark.contains(str)) {
                        arrayList.add(c7658a);
                    } else if (!C5046bo.isNullOrNil(SeeRoomMemberUI.m41550a(this.eih, c7616ad.field_username)) && SeeRoomMemberUI.m41550a(this.eih, c7616ad.field_username).contains(str)) {
                        arrayList.add(c7658a);
                    } else if (c7616ad.mo16706Oi() != null && c7616ad.mo16706Oi().contains(str)) {
                        arrayList.add(c7658a);
                    } else if (c7616ad.mo14676Ht() != null && c7616ad.mo14676Ht().contains(str)) {
                        arrayList.add(c7658a);
                    } else if (c7616ad.mo14673Hq() != null && c7616ad.mo14673Hq().contains(str)) {
                        arrayList.add(c7658a);
                    } else if (c7616ad.field_username != null && c7616ad.field_username.contains(str)) {
                        arrayList.add(c7658a);
                    } else if (!C7486a.m12942jh(c7616ad.field_type)) {
                        C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(c7616ad.field_username);
                        if (!(RB == null || RB.field_conRemark == null || !RB.field_conRemark.contains(str))) {
                            arrayList.add(c7658a);
                        }
                    }
                }
            }
            this.cFX = arrayList;
            AppMethodBeat.m2505o(104420);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(104421);
            if (this.cFX == null || this.isLoading) {
                AppMethodBeat.m2505o(104421);
                return 0;
            }
            int size = this.cFX.size();
            AppMethodBeat.m2505o(104421);
            return size;
        }

        /* renamed from: iH */
        public final C7658a mo17474iH(int i) {
            AppMethodBeat.m2504i(104422);
            if (this.cFX.size() > i) {
                C7658a c7658a = (C7658a) this.cFX.get(i);
                AppMethodBeat.m2505o(104422);
                return c7658a;
            }
            AppMethodBeat.m2505o(104422);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C7666c c7666c;
            AppMethodBeat.m2504i(104423);
            if (view == null) {
                view = View.inflate(this.mContext, 2130970597, null);
                final C7666c c7666c2 = new C7666c();
                c7666c2.emP = (MaskLayout) view.findViewById(2131827320);
                c7666c2.emg = (EllipsizeTextView) view.findViewById(2131827321);
                c7666c2.emg = (TextView) view.findViewById(2131827321);
                c7666c2.emR = (ImageButton) view.findViewById(2131822735);
                c7666c2.emS = (LinearLayout) view.findViewById(2131827323);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                c7666c2.emg.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                c7666c2.emQ = (TextView) view.findViewById(2131827322);
                c7666c2.emQ.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(c7666c2);
                c7666c2.emR.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(104415);
                        c7666c2.emS.performClick();
                        AppMethodBeat.m2505o(104415);
                    }
                });
                c7666c2.emS.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(104416);
                        int intValue = ((Integer) view.getTag()).intValue();
                        C7658a iH = C7659b.this.mo17474iH(intValue);
                        if (SelectMemberUI.this.mo17461Ks().contains(iH.ehM.field_username)) {
                            AppMethodBeat.m2505o(104416);
                        } else if (SelectMemberUI.this.emD.contains(iH.ehM.field_username)) {
                            SelectMemberUI.this.emD.remove(iH.ehM.field_username);
                            c7666c2.emR.setImageResource(C1318a.checkbox_unselected);
                            SelectMemberUI.this.mo17468w(intValue, false);
                            AppMethodBeat.m2505o(104416);
                        } else {
                            SelectMemberUI.this.emD.add(iH.ehM.field_username);
                            c7666c2.emR.setImageResource(C1318a.checkbox_selected);
                            SelectMemberUI.this.mo17468w(intValue, true);
                            AppMethodBeat.m2505o(104416);
                        }
                    }
                });
                view.setOnClickListener(new C76605());
                c7666c = c7666c2;
            } else {
                c7666c = (C7666c) view.getTag();
            }
            C7658a iH = mo17474iH(i);
            c7666c.emS.setTag(Integer.valueOf(i));
            if (iH == null) {
                C4990ab.m7413e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", Integer.valueOf(i), Integer.valueOf(getCount()));
                AppMethodBeat.m2505o(104423);
            } else {
                C7616ad c7616ad = iH.ehM;
                C40460b.m69434b((ImageView) c7666c.emP.getContentView(), c7616ad.field_username);
                if (c7616ad.field_verifyFlag == 0) {
                    c7666c.emP.setMaskDrawable(null);
                } else if (C26417a.flw != null) {
                    String kz = C26417a.flw.mo37873kz(c7616ad.field_verifyFlag);
                    if (kz != null) {
                        c7666c.emP.mo48741a(C8935m.m16106rk(kz), C23622a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                    } else {
                        c7666c.emP.setMaskDrawable(null);
                    }
                } else {
                    c7666c.emP.setMaskDrawable(null);
                }
                CharSequence c = m13696c(c7616ad);
                CharSequence charSequence = "";
                if (C7486a.m12942jh(c7616ad.field_type)) {
                    charSequence = c7616ad.dul;
                }
                if (C5046bo.isNullOrNil(charSequence)) {
                    c7666c.emQ.setVisibility(8);
                    c7666c.emQ.setText("");
                } else {
                    c7666c.emQ.setVisibility(0);
                    c7666c.emQ.setText(C44089j.m79293b(this.mContext, charSequence, c7666c.emQ.getTextSize()));
                }
                if (C7616ad.aox(c7616ad.field_username)) {
                    ((C32873b) C1720g.m3528K(C32873b.class)).mo44302a(this.mContext, c7666c.emg, c, c7616ad.field_openImAppid, c7616ad.field_descWordingId, (int) c7666c.emg.getTextSize());
                } else {
                    c7666c.emg.setText(C44089j.m79293b(this.mContext, c, c7666c.emg.getTextSize()));
                }
                if (SelectMemberUI.this.mo17460Kr()) {
                    c7666c.emR.setVisibility(0);
                    c7666c.emS.setVisibility(0);
                    if (SelectMemberUI.this.mo17461Ks().contains(c7616ad.field_username)) {
                        c7666c.emS.setEnabled(false);
                        c7666c.emR.setEnabled(false);
                        c7666c.emR.setImageResource(C1318a.checkbox_selected_grey);
                    } else {
                        c7666c.emS.setEnabled(true);
                        c7666c.emR.setEnabled(true);
                        if (SelectMemberUI.this.emD.contains(iH.ehM.field_username)) {
                            c7666c.emR.setImageResource(C1318a.checkbox_selected);
                        } else {
                            c7666c.emR.setImageResource(C1318a.checkbox_unselected);
                        }
                    }
                } else {
                    c7666c.emR.setVisibility(8);
                    c7666c.emS.setVisibility(8);
                }
                c7666c.emO = iH;
                c7666c.position = i;
                AppMethodBeat.m2505o(104423);
            }
            return view;
        }

        /* renamed from: Q */
        public final void mo17469Q(List<String> list) {
            AppMethodBeat.m2504i(104425);
            if (list == null) {
                AppMethodBeat.m2505o(104425);
                return;
            }
            this.cFX.clear();
            for (int i = 0; i < list.size(); i++) {
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO((String) list.get(i));
                if (SelectMemberUI.this.mo17458Kl() || !C1853r.m3858mG(aoO.field_username)) {
                    boolean equals = aoO.field_username.equals(this.emc);
                    if ((!equals || SelectMemberUI.this.emE) && !SelectMemberUI.this.mo17462Ku().contains(aoO.field_username)) {
                        if (equals && SelectMemberUI.this.emE) {
                            this.cFX.add(0, new C7658a(aoO));
                        } else {
                            this.cFX.add(new C7658a(aoO));
                        }
                    }
                }
            }
            Collections.sort(this.cFX, new C76616());
            this.emd = this.cFX;
            AppMethodBeat.m2505o(104425);
        }

        /* renamed from: c */
        private String m13696c(C7616ad c7616ad) {
            String a;
            String Oi;
            AppMethodBeat.m2504i(104424);
            if (C5046bo.isNullOrNil(c7616ad.field_conRemark)) {
                a = SelectMemberUI.m13676a(this.eih, c7616ad.field_username);
            } else {
                a = c7616ad.field_conRemark;
            }
            if (C5046bo.isNullOrNil(a)) {
                Oi = c7616ad.mo16706Oi();
            } else {
                Oi = a;
            }
            if (!C7486a.m12942jh(c7616ad.field_type)) {
                C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(c7616ad.field_username);
                if (!(RB == null || C5046bo.isNullOrNil(RB.field_conRemark))) {
                    Oi = RB.field_conRemark;
                }
            }
            AppMethodBeat.m2505o(104424);
            return Oi;
        }

        /* renamed from: a */
        static /* synthetic */ void m13693a(C7659b c7659b) {
            AppMethodBeat.m2504i(104427);
            if (c7659b.cFX != null) {
                Object obj = null;
                int i = 0;
                for (C7658a c7658a : c7659b.cFX) {
                    Object obj2;
                    if (c7658a.ehM != null) {
                        String vo = C9790g.m17432vo(c7659b.m13696c(c7658a.ehM));
                        if (C5046bo.isNullOrNil(vo)) {
                            obj2 = "";
                        } else if (vo.startsWith(c7659b.emJ)) {
                            obj2 = "#";
                        } else {
                            obj2 = vo.toUpperCase().substring(0, 1);
                        }
                        if (i == 0) {
                            c7659b.emK.put(obj2, Integer.valueOf(i));
                        } else if (!(obj == null || obj2.equals(obj))) {
                            c7659b.emK.put(obj2, Integer.valueOf(i));
                        }
                    } else {
                        obj2 = null;
                    }
                    i++;
                    obj = obj2;
                }
            }
            AppMethodBeat.m2505o(104427);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$c */
    protected static class C7666c {
        public C7658a emO;
        public MaskLayout emP;
        public TextView emQ;
        public ImageButton emR;
        public LinearLayout emS;
        public TextView emg;
        public int position;

        protected C7666c() {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$1 */
    class C76671 implements C30374a {
        C76671() {
        }

        /* renamed from: kp */
        public final void mo17482kp(String str) {
            AppMethodBeat.m2504i(104407);
            if ("↑".equals(str)) {
                SelectMemberUI.this.mListView.setSelection(0);
                AppMethodBeat.m2505o(104407);
                return;
            }
            int intValue;
            C7659b c7659b = SelectMemberUI.this.emB;
            if (c7659b.emK.containsKey(str)) {
                intValue = ((Integer) c7659b.emK.get(str)).intValue();
            } else {
                intValue = -1;
            }
            if (intValue != -1) {
                SelectMemberUI.this.mListView.setSelection(intValue);
            }
            AppMethodBeat.m2505o(104407);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$2 */
    class C76682 implements TextWatcher {
        private C7564ap emH = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C76691(), false);

        /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$2$1 */
        class C76691 implements C5015a {
            C76691() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(104408);
                C4990ab.m7410d("MicroMsg.SelectMemberUI", "searchEvent onTimerExpired");
                C7659b c7659b = SelectMemberUI.this.emB;
                String obj = SelectMemberUI.this.elU.getText().toString();
                C4990ab.m7417i("MicroMsg.SelectMemberAdapter", "search:%s isLoading:%s", C5046bo.anv(obj), Boolean.valueOf(c7659b.isLoading));
                if (!c7659b.isLoading) {
                    c7659b.ema = obj;
                    c7659b.mo17475kn(obj);
                    C5004al.m7441d(new C76622());
                }
                AppMethodBeat.m2505o(104408);
                return false;
            }
        }

        C76682() {
            AppMethodBeat.m2504i(104409);
            AppMethodBeat.m2505o(104409);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(104410);
            this.emH.stopTimer();
            this.emH.mo16770ae(500, 500);
            AppMethodBeat.m2505o(104410);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SelectMemberUI$3 */
    class C76703 implements OnMenuItemClickListener {
        C76703() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104411);
            SelectMemberUI.this.setResult(0, new Intent());
            SelectMemberUI.this.finish();
            AppMethodBeat.m2505o(104411);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104429);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.SelectMemberUI", "[onCreate]");
        mo17459Kq();
        initView();
        AppMethodBeat.m2505o(104429);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Kq */
    public void mo17459Kq() {
        AppMethodBeat.m2504i(104430);
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        C4990ab.m7417i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", this.ejD);
        this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14886ob(this.ejD);
        this.emC = getIntent().getIntExtra("from_scene", 0);
        this.mTitle = getIntent().getStringExtra("title");
        this.emE = getIntent().getBooleanExtra("is_show_owner", true);
        this.emF = getIntent().getBooleanExtra("is_mulit_select_mode", false);
        this.emD = new HashSet();
        AppMethodBeat.m2505o(104430);
    }

    /* renamed from: Kz */
    public final C7577u mo17466Kz() {
        return this.eih;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Kw */
    public BaseAdapter mo17464Kw() {
        return this.emB;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Kv */
    public boolean mo17463Kv() {
        return true;
    }

    public void initView() {
        AppMethodBeat.m2504i(104431);
        setMMTitle(C5046bo.nullAsNil(this.mTitle));
        this.mListView = (ListView) findViewById(2131827317);
        this.emy = findViewById(2131827318);
        this.emz = findViewById(2131827328);
        this.emB = new C7659b(this, this.eih, this.ejD, this.eih.field_roomowner);
        this.mListView.setAdapter(mo17464Kw());
        this.emA = (SelectMemberScrollBar) findViewById(2131827327);
        this.emA.setOnScrollBarTouchListener(new C76671());
        if (mo17463Kv()) {
            this.emA.setVisibility(0);
        } else {
            this.emA.setVisibility(8);
        }
        this.elU = (MMEditText) findViewById(2131827326);
        this.elU.addTextChangedListener(new C76682());
        C7659b c7659b = this.emB;
        SelectMemberUI.this.emz.setVisibility(0);
        C1720g.m3539RS().mo10302aa(new C76651());
        setBackBtn(new C76703());
        AppMethodBeat.m2505o(104431);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Ku */
    public HashSet<String> mo17462Ku() {
        AppMethodBeat.m2504i(104432);
        HashSet hashSet = new HashSet();
        AppMethodBeat.m2505o(104432);
        return hashSet;
    }

    /* renamed from: Kr */
    public boolean mo17460Kr() {
        return this.emF;
    }

    /* renamed from: Kl */
    public boolean mo17458Kl() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Ks */
    public HashSet<String> mo17461Ks() {
        AppMethodBeat.m2504i(104433);
        HashSet hashSet = new HashSet();
        AppMethodBeat.m2505o(104433);
        return hashSet;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo17467a(View view, int i, long j) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: w */
    public void mo17468w(int i, boolean z) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: Kx */
    public List<String> mo17465Kx() {
        AppMethodBeat.m2504i(104434);
        List afg = this.eih.afg();
        AppMethodBeat.m2505o(104434);
        return afg;
    }

    /* renamed from: a */
    protected static String m13676a(C7577u c7577u, String str) {
        AppMethodBeat.m2504i(104435);
        if (c7577u == null) {
            AppMethodBeat.m2505o(104435);
            return null;
        }
        String mJ = c7577u.mo16807mJ(str);
        AppMethodBeat.m2505o(104435);
        return mJ;
    }

    public final int getLayoutId() {
        return 2130970598;
    }
}
