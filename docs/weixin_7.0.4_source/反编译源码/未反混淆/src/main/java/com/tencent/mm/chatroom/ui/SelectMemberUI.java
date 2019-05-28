package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.aj.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SelectMemberUI extends MMActivity {
    protected u eih;
    protected String ejD;
    private MMEditText elU;
    private SelectMemberScrollBar emA;
    protected b emB;
    protected int emC;
    protected HashSet<String> emD;
    private boolean emE;
    private boolean emF;
    private View emy;
    private View emz;
    private ListView mListView;
    protected String mTitle;

    public class a {
        public ad ehM;
        public int type = 1;

        public a(ad adVar) {
            this.ehM = adVar;
        }
    }

    public class b extends BaseAdapter {
        private List<a> cFX = new ArrayList();
        private u eih;
        private String ejD;
        public final String emJ = new String(Character.toChars(91));
        HashMap<String, Integer> emK = new HashMap();
        public String ema;
        private String emc = null;
        private List<a> emd = new ArrayList(0);
        volatile boolean isLoading = false;
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(104426);
            a iH = iH(i);
            AppMethodBeat.o(104426);
            return iH;
        }

        public b(Context context, u uVar, String str, String str2) {
            AppMethodBeat.i(104419);
            this.eih = uVar;
            this.ejD = str;
            this.emc = str2;
            this.mContext = context;
            AppMethodBeat.o(104419);
        }

        public final void kn(String str) {
            AppMethodBeat.i(104420);
            ab.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
            ArrayList arrayList = new ArrayList();
            if (bo.isNullOrNil(str)) {
                this.cFX = this.emd;
                AppMethodBeat.o(104420);
                return;
            }
            for (a aVar : this.emd) {
                if (!(aVar == null || aVar.ehM == null || aVar.type != 1)) {
                    ad adVar = aVar.ehM;
                    if (adVar.field_conRemark != null && adVar.field_conRemark.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!bo.isNullOrNil(SeeRoomMemberUI.a(this.eih, adVar.field_username)) && SeeRoomMemberUI.a(this.eih, adVar.field_username).contains(str)) {
                        arrayList.add(aVar);
                    } else if (adVar.Oi() != null && adVar.Oi().contains(str)) {
                        arrayList.add(aVar);
                    } else if (adVar.Ht() != null && adVar.Ht().contains(str)) {
                        arrayList.add(aVar);
                    } else if (adVar.Hq() != null && adVar.Hq().contains(str)) {
                        arrayList.add(aVar);
                    } else if (adVar.field_username != null && adVar.field_username.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!com.tencent.mm.n.a.jh(adVar.field_type)) {
                        bv RB = ((j) g.K(j.class)).XN().RB(adVar.field_username);
                        if (!(RB == null || RB.field_conRemark == null || !RB.field_conRemark.contains(str))) {
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            this.cFX = arrayList;
            AppMethodBeat.o(104420);
        }

        public final int getCount() {
            AppMethodBeat.i(104421);
            if (this.cFX == null || this.isLoading) {
                AppMethodBeat.o(104421);
                return 0;
            }
            int size = this.cFX.size();
            AppMethodBeat.o(104421);
            return size;
        }

        public final a iH(int i) {
            AppMethodBeat.i(104422);
            if (this.cFX.size() > i) {
                a aVar = (a) this.cFX.get(i);
                AppMethodBeat.o(104422);
                return aVar;
            }
            AppMethodBeat.o(104422);
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(104423);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.aqs, null);
                final c cVar2 = new c();
                cVar2.emP = (MaskLayout) view.findViewById(R.id.e86);
                cVar2.emg = (EllipsizeTextView) view.findViewById(R.id.e87);
                cVar2.emg = (TextView) view.findViewById(R.id.e87);
                cVar2.emR = (ImageButton) view.findViewById(R.id.av8);
                cVar2.emS = (LinearLayout) view.findViewById(R.id.e89);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                cVar2.emg.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                cVar2.emQ = (TextView) view.findViewById(R.id.e88);
                cVar2.emQ.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(cVar2);
                cVar2.emR.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(104415);
                        cVar2.emS.performClick();
                        AppMethodBeat.o(104415);
                    }
                });
                cVar2.emS.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(104416);
                        int intValue = ((Integer) view.getTag()).intValue();
                        a iH = b.this.iH(intValue);
                        if (SelectMemberUI.this.Ks().contains(iH.ehM.field_username)) {
                            AppMethodBeat.o(104416);
                        } else if (SelectMemberUI.this.emD.contains(iH.ehM.field_username)) {
                            SelectMemberUI.this.emD.remove(iH.ehM.field_username);
                            cVar2.emR.setImageResource(R.raw.checkbox_unselected);
                            SelectMemberUI.this.w(intValue, false);
                            AppMethodBeat.o(104416);
                        } else {
                            SelectMemberUI.this.emD.add(iH.ehM.field_username);
                            cVar2.emR.setImageResource(R.raw.checkbox_selected);
                            SelectMemberUI.this.w(intValue, true);
                            AppMethodBeat.o(104416);
                        }
                    }
                });
                view.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(104417);
                        SelectMemberUI.this.a(view, ((c) view.getTag()).position, (long) view.getId());
                        AppMethodBeat.o(104417);
                    }
                });
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            a iH = iH(i);
            cVar.emS.setTag(Integer.valueOf(i));
            if (iH == null) {
                ab.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", Integer.valueOf(i), Integer.valueOf(getCount()));
                AppMethodBeat.o(104423);
            } else {
                ad adVar = iH.ehM;
                com.tencent.mm.pluginsdk.ui.a.b.b((ImageView) cVar.emP.getContentView(), adVar.field_username);
                if (adVar.field_verifyFlag == 0) {
                    cVar.emP.setMaskDrawable(null);
                } else if (com.tencent.mm.model.ao.a.flw != null) {
                    String kz = com.tencent.mm.model.ao.a.flw.kz(adVar.field_verifyFlag);
                    if (kz != null) {
                        cVar.emP.a(m.rk(kz), com.tencent.mm.ui.base.MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                    } else {
                        cVar.emP.setMaskDrawable(null);
                    }
                } else {
                    cVar.emP.setMaskDrawable(null);
                }
                CharSequence c = c(adVar);
                CharSequence charSequence = "";
                if (com.tencent.mm.n.a.jh(adVar.field_type)) {
                    charSequence = adVar.dul;
                }
                if (bo.isNullOrNil(charSequence)) {
                    cVar.emQ.setVisibility(8);
                    cVar.emQ.setText("");
                } else {
                    cVar.emQ.setVisibility(0);
                    cVar.emQ.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, charSequence, cVar.emQ.getTextSize()));
                }
                if (ad.aox(adVar.field_username)) {
                    ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).a(this.mContext, cVar.emg, c, adVar.field_openImAppid, adVar.field_descWordingId, (int) cVar.emg.getTextSize());
                } else {
                    cVar.emg.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.mContext, c, cVar.emg.getTextSize()));
                }
                if (SelectMemberUI.this.Kr()) {
                    cVar.emR.setVisibility(0);
                    cVar.emS.setVisibility(0);
                    if (SelectMemberUI.this.Ks().contains(adVar.field_username)) {
                        cVar.emS.setEnabled(false);
                        cVar.emR.setEnabled(false);
                        cVar.emR.setImageResource(R.raw.checkbox_selected_grey);
                    } else {
                        cVar.emS.setEnabled(true);
                        cVar.emR.setEnabled(true);
                        if (SelectMemberUI.this.emD.contains(iH.ehM.field_username)) {
                            cVar.emR.setImageResource(R.raw.checkbox_selected);
                        } else {
                            cVar.emR.setImageResource(R.raw.checkbox_unselected);
                        }
                    }
                } else {
                    cVar.emR.setVisibility(8);
                    cVar.emS.setVisibility(8);
                }
                cVar.emO = iH;
                cVar.position = i;
                AppMethodBeat.o(104423);
            }
            return view;
        }

        public final void Q(List<String> list) {
            AppMethodBeat.i(104425);
            if (list == null) {
                AppMethodBeat.o(104425);
                return;
            }
            this.cFX.clear();
            for (int i = 0; i < list.size(); i++) {
                ad aoO = ((j) g.K(j.class)).XM().aoO((String) list.get(i));
                if (SelectMemberUI.this.Kl() || !r.mG(aoO.field_username)) {
                    boolean equals = aoO.field_username.equals(this.emc);
                    if ((!equals || SelectMemberUI.this.emE) && !SelectMemberUI.this.Ku().contains(aoO.field_username)) {
                        if (equals && SelectMemberUI.this.emE) {
                            this.cFX.add(0, new a(aoO));
                        } else {
                            this.cFX.add(new a(aoO));
                        }
                    }
                }
            }
            Collections.sort(this.cFX, new Comparator<a>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(104418);
                    int compareToIgnoreCase = com.tencent.mm.platformtools.g.vo(b.a(b.this, ((a) obj).ehM)).compareToIgnoreCase(com.tencent.mm.platformtools.g.vo(b.a(b.this, ((a) obj2).ehM)));
                    AppMethodBeat.o(104418);
                    return compareToIgnoreCase;
                }
            });
            this.emd = this.cFX;
            AppMethodBeat.o(104425);
        }

        private String c(ad adVar) {
            String a;
            String Oi;
            AppMethodBeat.i(104424);
            if (bo.isNullOrNil(adVar.field_conRemark)) {
                a = SelectMemberUI.a(this.eih, adVar.field_username);
            } else {
                a = adVar.field_conRemark;
            }
            if (bo.isNullOrNil(a)) {
                Oi = adVar.Oi();
            } else {
                Oi = a;
            }
            if (!com.tencent.mm.n.a.jh(adVar.field_type)) {
                bv RB = ((j) g.K(j.class)).XN().RB(adVar.field_username);
                if (!(RB == null || bo.isNullOrNil(RB.field_conRemark))) {
                    Oi = RB.field_conRemark;
                }
            }
            AppMethodBeat.o(104424);
            return Oi;
        }

        static /* synthetic */ void a(b bVar) {
            AppMethodBeat.i(104427);
            if (bVar.cFX != null) {
                Object obj = null;
                int i = 0;
                for (a aVar : bVar.cFX) {
                    Object obj2;
                    if (aVar.ehM != null) {
                        String vo = com.tencent.mm.platformtools.g.vo(bVar.c(aVar.ehM));
                        if (bo.isNullOrNil(vo)) {
                            obj2 = "";
                        } else if (vo.startsWith(bVar.emJ)) {
                            obj2 = "#";
                        } else {
                            obj2 = vo.toUpperCase().substring(0, 1);
                        }
                        if (i == 0) {
                            bVar.emK.put(obj2, Integer.valueOf(i));
                        } else if (!(obj == null || obj2.equals(obj))) {
                            bVar.emK.put(obj2, Integer.valueOf(i));
                        }
                    } else {
                        obj2 = null;
                    }
                    i++;
                    obj = obj2;
                }
            }
            AppMethodBeat.o(104427);
        }
    }

    protected static class c {
        public a emO;
        public MaskLayout emP;
        public TextView emQ;
        public ImageButton emR;
        public LinearLayout emS;
        public TextView emg;
        public int position;

        protected c() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(104429);
        super.onCreate(bundle);
        ab.i("MicroMsg.SelectMemberUI", "[onCreate]");
        Kq();
        initView();
        AppMethodBeat.o(104429);
    }

    /* Access modifiers changed, original: protected */
    public void Kq() {
        AppMethodBeat.i(104430);
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        ab.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", this.ejD);
        this.eih = ((com.tencent.mm.plugin.chatroom.a.c) g.K(com.tencent.mm.plugin.chatroom.a.c.class)).XV().ob(this.ejD);
        this.emC = getIntent().getIntExtra("from_scene", 0);
        this.mTitle = getIntent().getStringExtra("title");
        this.emE = getIntent().getBooleanExtra("is_show_owner", true);
        this.emF = getIntent().getBooleanExtra("is_mulit_select_mode", false);
        this.emD = new HashSet();
        AppMethodBeat.o(104430);
    }

    public final u Kz() {
        return this.eih;
    }

    /* Access modifiers changed, original: protected */
    public BaseAdapter Kw() {
        return this.emB;
    }

    /* Access modifiers changed, original: protected */
    public boolean Kv() {
        return true;
    }

    public void initView() {
        AppMethodBeat.i(104431);
        setMMTitle(bo.nullAsNil(this.mTitle));
        this.mListView = (ListView) findViewById(R.id.e83);
        this.emy = findViewById(R.id.e84);
        this.emz = findViewById(R.id.e8d);
        this.emB = new b(this, this.eih, this.ejD, this.eih.field_roomowner);
        this.mListView.setAdapter(Kw());
        this.emA = (SelectMemberScrollBar) findViewById(R.id.e8c);
        this.emA.setOnScrollBarTouchListener(new com.tencent.mm.ui.base.VerticalScrollBar.a() {
            public final void kp(String str) {
                AppMethodBeat.i(104407);
                if ("↑".equals(str)) {
                    SelectMemberUI.this.mListView.setSelection(0);
                    AppMethodBeat.o(104407);
                    return;
                }
                int intValue;
                b bVar = SelectMemberUI.this.emB;
                if (bVar.emK.containsKey(str)) {
                    intValue = ((Integer) bVar.emK.get(str)).intValue();
                } else {
                    intValue = -1;
                }
                if (intValue != -1) {
                    SelectMemberUI.this.mListView.setSelection(intValue);
                }
                AppMethodBeat.o(104407);
            }
        });
        if (Kv()) {
            this.emA.setVisibility(0);
        } else {
            this.emA.setVisibility(8);
        }
        this.elU = (MMEditText) findViewById(R.id.e8b);
        this.elU.addTextChangedListener(new TextWatcher() {
            private ap emH = new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(104408);
                    ab.d("MicroMsg.SelectMemberUI", "searchEvent onTimerExpired");
                    b bVar = SelectMemberUI.this.emB;
                    String obj = SelectMemberUI.this.elU.getText().toString();
                    ab.i("MicroMsg.SelectMemberAdapter", "search:%s isLoading:%s", bo.anv(obj), Boolean.valueOf(bVar.isLoading));
                    if (!bVar.isLoading) {
                        bVar.ema = obj;
                        bVar.kn(obj);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(104414);
                                b.this.notifyDataSetChanged();
                                if (b.this.cFX == null || b.this.cFX.size() != 0) {
                                    SelectMemberUI.this.mListView.setVisibility(0);
                                    SelectMemberUI.this.emy.setVisibility(8);
                                    AppMethodBeat.o(104414);
                                    return;
                                }
                                SelectMemberUI.this.mListView.setVisibility(8);
                                SelectMemberUI.this.emy.setVisibility(0);
                                AppMethodBeat.o(104414);
                            }
                        });
                    }
                    AppMethodBeat.o(104408);
                    return false;
                }
            }, false);

            {
                AppMethodBeat.i(104409);
                AppMethodBeat.o(104409);
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(104410);
                this.emH.stopTimer();
                this.emH.ae(500, 500);
                AppMethodBeat.o(104410);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        b bVar = this.emB;
        SelectMemberUI.this.emz.setVisibility(0);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(104413);
                b.this.isLoading = true;
                long currentTimeMillis = System.currentTimeMillis();
                b.this.Q(SelectMemberUI.this.Kx());
                b.a(b.this);
                ab.i("MicroMsg.SelectMemberAdapter", "[load data] cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(104412);
                        b.this.isLoading = false;
                        SelectMemberUI.this.emz.setVisibility(8);
                        b.this.notifyDataSetChanged();
                        AppMethodBeat.o(104412);
                    }
                });
                AppMethodBeat.o(104413);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104411);
                SelectMemberUI.this.setResult(0, new Intent());
                SelectMemberUI.this.finish();
                AppMethodBeat.o(104411);
                return true;
            }
        });
        AppMethodBeat.o(104431);
    }

    /* Access modifiers changed, original: protected */
    public HashSet<String> Ku() {
        AppMethodBeat.i(104432);
        HashSet hashSet = new HashSet();
        AppMethodBeat.o(104432);
        return hashSet;
    }

    public boolean Kr() {
        return this.emF;
    }

    public boolean Kl() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public HashSet<String> Ks() {
        AppMethodBeat.i(104433);
        HashSet hashSet = new HashSet();
        AppMethodBeat.o(104433);
        return hashSet;
    }

    /* Access modifiers changed, original: protected */
    public void a(View view, int i, long j) {
    }

    /* Access modifiers changed, original: protected */
    public void w(int i, boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public List<String> Kx() {
        AppMethodBeat.i(104434);
        List afg = this.eih.afg();
        AppMethodBeat.o(104434);
        return afg;
    }

    protected static String a(u uVar, String str) {
        AppMethodBeat.i(104435);
        if (uVar == null) {
            AppMethodBeat.o(104435);
            return null;
        }
        String mJ = uVar.mJ(str);
        AppMethodBeat.o(104435);
        return mJ;
    }

    public final int getLayoutId() {
        return R.layout.aqt;
    }
}
