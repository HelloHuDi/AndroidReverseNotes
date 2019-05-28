package com.tencent.p177mm.chatroom.p216ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C32794m;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.openim.room.p266a.C42249a;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.contact.C30670y;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44204b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44205c;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7575bv;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI */
public class SeeRoomMemberUI extends MMActivity implements C1202f {
    private static int elW = 5;
    /* renamed from: Lp */
    private int f13664Lp;
    private boolean cEH;
    private boolean ehL;
    private C7577u eih;
    private String ejD;
    private String ejR;
    private int ejS;
    private String ejT;
    private boolean ejU;
    private C44275p ejZ;
    private C26031b elP;
    private String elQ;
    private String elR;
    private C5601o elS;
    private String elT;
    private MMEditText elU;
    private int elV;
    private GridView ely;
    private String mTitle;
    private String talker;
    private String username;

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$4 */
    class C92284 implements C44204b {
        C92284() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(104311);
            C42124a jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(SeeRoomMemberUI.this, null, null);
                AppMethodBeat.m2505o(104311);
                return;
            }
            C30379h.m48461b(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(C25738R.string.cen), SeeRoomMemberUI.this.getString(C25738R.string.f9238tz), true);
            SeeRoomMemberUI.m41574l(SeeRoomMemberUI.this);
            AppMethodBeat.m2505o(104311);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$11 */
    class C1815411 implements OnMenuItemClickListener {
        C1815411() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104317);
            SeeRoomMemberUI.this.setResult(0);
            SeeRoomMemberUI.this.finish();
            AppMethodBeat.m2505o(104317);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$12 */
    class C1815512 implements TextWatcher {
        C1815512() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(104318);
            SeeRoomMemberUI.this.elP.mo43909ko(charSequence.toString());
            AppMethodBeat.m2505o(104318);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$13 */
    class C1815613 implements OnItemClickListener {
        C1815613() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(104319);
            C26027a iG = SeeRoomMemberUI.this.elP.mo43908iG(i);
            if (iG.type == 2) {
                C4990ab.m7416i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
                C7060h.pYm.mo8378a(219, 6, 1, true);
                SeeRoomMemberUI.m41563d(SeeRoomMemberUI.this);
                AppMethodBeat.m2505o(104319);
            } else if (iG.type == 3) {
                C4990ab.m7416i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
                SeeRoomMemberUI.m41565e(SeeRoomMemberUI.this);
                AppMethodBeat.m2505o(104319);
            } else {
                if (iG.type == 1) {
                    C7616ad c7616ad = SeeRoomMemberUI.this.elP.mo43908iG(i).ehM;
                    if (c7616ad == null) {
                        C4990ab.m7412e("MicroMsg.SeeRoomMemberUI", "cont is null");
                        AppMethodBeat.m2505o(104319);
                        return;
                    }
                    SeeRoomMemberUI.this.username = c7616ad.field_username;
                    String str = c7616ad.field_nickname;
                    String a = SeeRoomMemberUI.m41550a(SeeRoomMemberUI.this.eih, SeeRoomMemberUI.this.username);
                    if (C5046bo.isNullOrNil(a)) {
                        SeeRoomMemberUI.this.elT = c7616ad.mo16707Oj();
                    } else {
                        SeeRoomMemberUI.this.elT = a;
                    }
                    C30670y.m48901q(SeeRoomMemberUI.this.elU.getText().toString(), 1, 6, i + 1);
                    SeeRoomMemberUI.m41555a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.username, SeeRoomMemberUI.this.elT, str);
                }
                AppMethodBeat.m2505o(104319);
            }
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$14 */
    class C1815714 implements OnItemLongClickListener {

        /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$14$2 */
        class C92272 implements OnClickListener {
            C92272() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C1815714() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
            AppMethodBeat.m2504i(104321);
            if (SeeRoomMemberUI.this.ejU) {
                C7616ad c7616ad = SeeRoomMemberUI.this.elP.mo43908iG(i).ehM;
                if (c7616ad == null) {
                    AppMethodBeat.m2505o(104321);
                } else {
                    if (SeeRoomMemberUI.this.eih.field_roomowner.equals(c7616ad.field_username)) {
                        AppMethodBeat.m2505o(104321);
                    } else {
                        C30379h.m48440a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(C25738R.string.drz), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.m2504i(104320);
                                SeeRoomMemberUI.m41551a(SeeRoomMemberUI.this, i);
                                AppMethodBeat.m2505o(104320);
                            }
                        }, new C92272());
                        AppMethodBeat.m2505o(104321);
                    }
                }
            } else {
                C4990ab.m7416i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
                AppMethodBeat.m2505o(104321);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$2 */
    class C181592 extends C44205c {
        C181592() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(104309);
            C44205c c44205c = (C44205c) c46609a;
            C42124a jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(SeeRoomMemberUI.this, null, null);
                AppMethodBeat.m2505o(104309);
            } else if (i == 0 && i2 == 0) {
                if (i == 0 && i2 == 0) {
                    SeeRoomMemberUI.m41552a(SeeRoomMemberUI.this, i2, c44205c);
                    SeeRoomMemberUI.m41571k(SeeRoomMemberUI.this);
                }
                SeeRoomMemberUI.m41574l(SeeRoomMemberUI.this);
                AppMethodBeat.m2505o(104309);
            } else {
                SeeRoomMemberUI.m41552a(SeeRoomMemberUI.this, i2, c44205c);
                SeeRoomMemberUI.m41571k(SeeRoomMemberUI.this);
                AppMethodBeat.m2505o(104309);
            }
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$5 */
    class C181605 implements C44204b {
        C181605() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(104312);
            SeeRoomMemberUI.m41571k(SeeRoomMemberUI.this);
            SeeRoomMemberUI.m41574l(SeeRoomMemberUI.this);
            AppMethodBeat.m2505o(104312);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$a */
    static class C26027a {
        C7616ad ehM;
        int order;
        int type;

        public C26027a(C7616ad c7616ad, int i) {
            this.order = 0;
            this.type = 1;
            this.ehM = c7616ad;
            this.order = i;
        }

        public C26027a(int i) {
            this.order = 0;
            this.type = i;
            this.ehM = null;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$15 */
    class C2602815 implements C44204b {
        C2602815() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(104322);
            SeeRoomMemberUI.m41571k(SeeRoomMemberUI.this);
            SeeRoomMemberUI.m41574l(SeeRoomMemberUI.this);
            AppMethodBeat.m2505o(104322);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$9 */
    class C260309 implements OnClickListener {
        C260309() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(104315);
            SeeRoomMemberUI seeRoomMemberUI = SeeRoomMemberUI.this;
            Context context = SeeRoomMemberUI.this;
            SeeRoomMemberUI.this.ejD;
            SeeRoomMemberUI.m41553a(seeRoomMemberUI, context);
            AppMethodBeat.m2505o(104315);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$b */
    class C26031b extends BaseAdapter {
        private List<C26027a> cFX = new ArrayList();
        private String ehq;
        private C7577u eih;
        private List<String> elZ;
        public String ema;
        private boolean emb = false;
        private String emc = null;
        private List<C26027a> emd;
        private C6982j eme;
        private Context mContext;

        /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$b$1 */
        class C181611 implements Comparator<C26027a> {
            C181611() {
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((C26027a) obj2).order - ((C26027a) obj).order;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(104333);
            C26027a iG = mo43908iG(i);
            AppMethodBeat.m2505o(104333);
            return iG;
        }

        public C26031b(Context context, C7577u c7577u, String str, List<String> list, String str2) {
            AppMethodBeat.m2504i(104326);
            this.eih = c7577u;
            this.ehq = str;
            this.elZ = list;
            this.emc = str2;
            this.mContext = context;
            this.eme = (C6982j) C1720g.m3528K(C6982j.class);
            mo43903Q(C37921n.m64074my(str));
            AppMethodBeat.m2505o(104326);
        }

        /* renamed from: Q */
        public final void mo43903Q(List<String> list) {
            AppMethodBeat.m2504i(104327);
            if (list == null) {
                AppMethodBeat.m2505o(104327);
                return;
            }
            this.cFX.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                C7616ad aoO = this.eme.mo15369XM().aoO((String) list.get(i2));
                if (this.eih.aos(aoO.field_username)) {
                    this.cFX.add(new C26027a(aoO, 3));
                } else if (this.eih.aoo(aoO.field_username)) {
                    this.cFX.add(new C26027a(aoO, 2));
                } else {
                    this.cFX.add(new C26027a(aoO, 1));
                }
                i = i2 + 1;
            }
            Collections.sort(this.cFX, new C181611());
            this.cFX.add(new C26027a(2));
            if (this.eih.mo16786JR()) {
                this.cFX.add(new C26027a(3));
            }
            this.emd = this.cFX;
            notifyDataSetChanged();
            AppMethodBeat.m2505o(104327);
        }

        /* renamed from: kn */
        private void m41577kn(String str) {
            AppMethodBeat.m2504i(104328);
            ArrayList arrayList = new ArrayList();
            if (C5046bo.isNullOrNil(str)) {
                this.cFX = this.emd;
            } else {
                for (C26027a c26027a : this.emd) {
                    if (!(c26027a == null || c26027a.ehM == null || c26027a.type != 1)) {
                        C7616ad c7616ad = c26027a.ehM;
                        if (c7616ad.field_conRemark != null && c7616ad.field_conRemark.toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(c26027a);
                        } else if (!C5046bo.isNullOrNil(SeeRoomMemberUI.m41550a(this.eih, c7616ad.field_username)) && SeeRoomMemberUI.m41550a(this.eih, c7616ad.field_username).contains(str)) {
                            arrayList.add(c26027a);
                        } else if (c7616ad.mo16706Oi() != null && c7616ad.mo16706Oi().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(c26027a);
                        } else if (c7616ad.mo14676Ht() != null && c7616ad.mo14676Ht().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(c26027a);
                        } else if (c7616ad.mo14673Hq() != null && c7616ad.mo14673Hq().contains(str)) {
                            arrayList.add(c26027a);
                        } else if (c7616ad.field_username != null && c7616ad.field_username.contains(str)) {
                            arrayList.add(c26027a);
                        } else if (!C7486a.m12942jh(c7616ad.field_type)) {
                            C7575bv RB = ((C6982j) C1720g.m3528K(C6982j.class)).mo15370XN().mo15364RB(c7616ad.field_username);
                            if (!(RB == null || RB.field_conRemark == null || !RB.field_conRemark.toUpperCase().contains(str.toUpperCase()))) {
                                arrayList.add(c26027a);
                            }
                        }
                    }
                }
                C4990ab.m7416i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
                this.cFX = arrayList;
            }
            notifyDataSetChanged();
            AppMethodBeat.m2505o(104328);
        }

        /* renamed from: iG */
        public final C26027a mo43908iG(int i) {
            AppMethodBeat.m2504i(104329);
            C26027a c26027a = (C26027a) this.cFX.get(i);
            AppMethodBeat.m2505o(104329);
            return c26027a;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C26038c c26038c;
            AppMethodBeat.m2504i(104330);
            if (view == null) {
                view = View.inflate(this.mContext, 2130970582, null);
                c26038c = new C26038c();
                c26038c.ejo = (ImageView) view.findViewById(2131822731);
                c26038c.emg = (TextView) view.findViewById(2131822733);
                c26038c.emg.setMaxWidth((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 2) / 3);
                c26038c.emh = (TextView) view.findViewById(2131827306);
                view.setTag(c26038c);
            } else {
                c26038c = (C26038c) view.getTag();
            }
            if (c26038c.emh != null) {
                c26038c.emh.setVisibility(8);
            }
            C26027a c26027a = (C26027a) this.cFX.get(i);
            if (c26027a != null && c26027a.type == 1) {
                CharSequence charSequence;
                C7616ad c7616ad = c26027a.ehM;
                C40460b.m69434b(c26038c.ejo, c7616ad.field_username);
                String a = SeeRoomMemberUI.m41550a(this.eih, c7616ad.field_username);
                if (C5046bo.isNullOrNil(c7616ad.field_conRemark)) {
                    Object charSequence2 = a;
                } else {
                    charSequence2 = c7616ad.field_conRemark;
                }
                if (C5046bo.isNullOrNil(charSequence2)) {
                    charSequence2 = c7616ad.mo16706Oi();
                }
                if (!(a == null || a.equals("") || charSequence2.equals(a))) {
                    charSequence2 = a + "( " + charSequence2 + " )";
                }
                c26038c.emg.setVisibility(0);
                c26038c.emg.setText(C44089j.m79293b(this.mContext, charSequence2, c26038c.emg.getTextSize()));
                if (c26038c.emh != null) {
                    String A = C42249a.m74595A(c7616ad);
                    if (TextUtils.isEmpty(A)) {
                        c26038c.emh.setVisibility(8);
                    } else {
                        c26038c.emh.setVisibility(0);
                        c26038c.emh.setText(A);
                    }
                }
            } else if (c26027a != null && c26027a.type == 2) {
                c26038c.emg.setVisibility(4);
                c26038c.ejo.setImageResource(C25738R.drawable.f6436e4);
            } else if (c26027a != null && c26027a.type == 3) {
                c26038c.emg.setVisibility(4);
                c26038c.ejo.setImageResource(C25738R.drawable.f6437e5);
            }
            AppMethodBeat.m2505o(104330);
            return view;
        }

        /* renamed from: ko */
        public final void mo43909ko(String str) {
            AppMethodBeat.m2504i(104331);
            this.emb = true;
            this.ema = str;
            m41577kn(str);
            AppMethodBeat.m2505o(104331);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(104332);
            int size = this.cFX.size();
            AppMethodBeat.m2505o(104332);
            return size;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$10 */
    class C2603210 implements OnClickListener {
        C2603210() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(104316);
            SeeRoomMemberUI.m41571k(SeeRoomMemberUI.this);
            AppMethodBeat.m2505o(104316);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$1 */
    class C260331 implements Runnable {
        C260331() {
        }

        public final void run() {
            AppMethodBeat.m2504i(104308);
            if (VERSION.SDK_INT >= 19) {
                SeeRoomMemberUI.this.ely.scrollListBy(SeeRoomMemberUI.this.f13664Lp);
                AppMethodBeat.m2505o(104308);
                return;
            }
            SeeRoomMemberUI.m41548a(SeeRoomMemberUI.this.ely, "trackMotionScroll", new Object[]{Integer.valueOf(-SeeRoomMemberUI.this.f13664Lp), Integer.valueOf(-SeeRoomMemberUI.this.f13664Lp)}, new Class[]{Integer.TYPE, Integer.TYPE});
            AppMethodBeat.m2505o(104308);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$16 */
    class C2603516 implements C44204b {
        C2603516() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(104323);
            C42124a jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(SeeRoomMemberUI.this, null, null);
                AppMethodBeat.m2505o(104323);
                return;
            }
            if (i2 == -66) {
                C30379h.m48461b(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(C25738R.string.b50), SeeRoomMemberUI.this.getString(C25738R.string.f9238tz), true);
                SeeRoomMemberUI.m41571k(SeeRoomMemberUI.this);
                SeeRoomMemberUI.m41574l(SeeRoomMemberUI.this);
            }
            AppMethodBeat.m2505o(104323);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$8 */
    class C260378 implements OnClickListener {
        C260378() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.SeeRoomMemberUI$c */
    static class C26038c {
        public ImageView ejo;
        public TextView emg;
        public TextView emh;

        private C26038c() {
        }

        /* synthetic */ C26038c(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: k */
    static /* synthetic */ void m41571k(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.m2504i(104358);
        seeRoomMemberUI.m41544Kn();
        AppMethodBeat.m2505o(104358);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(104334);
        super.onCreate(bundle);
        C7060h.pYm.mo8378a(219, 2, 1, true);
        C1720g.m3535RO().eJo.mo14539a(990, (C1202f) this);
        this.ejD = getIntent().getStringExtra("RoomInfo_Id");
        this.talker = getIntent().getStringExtra("Chat_User");
        this.elR = getIntent().getStringExtra("Chatroom_member_list");
        this.cEH = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ehL = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.ejU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.ejT = getIntent().getStringExtra("room_owner_name");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.talker == null ? this.ejD : this.talker);
        this.ejS = getIntent().getIntExtra("room_member_count", 0);
        this.ejR = getIntent().getStringExtra("room_name");
        this.f13664Lp = getIntent().getIntExtra("offset", 0);
        this.elV = getIntent().getIntExtra("first_pos", 0);
        initView();
        if (this.elP != null) {
            m41544Kn();
            this.ely.setSelection(this.elV * elW < this.elP.getCount() ? this.elV * elW : this.elP.getCount() - 1);
            this.ely.postDelayed(new C260331(), 100);
        }
        AppMethodBeat.m2505o(104334);
    }

    public void onResume() {
        AppMethodBeat.m2504i(104335);
        super.onResume();
        if (this.elP != null) {
            this.elP.mo43909ko(this.elU.getText().toString());
        }
        AppMethodBeat.m2505o(104335);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(104336);
        super.onConfigurationChanged(configuration);
        this.ely.setNumColumns(SeeRoomMemberUI.m41561bz(this));
        AppMethodBeat.m2505o(104336);
    }

    /* renamed from: bz */
    private static int m41561bz(Context context) {
        AppMethodBeat.m2504i(104337);
        int width = (int) ((((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth()) - (context.getResources().getDimension(C25738R.dimen.f9957ld) * 1.0f)) / ((float) ((int) ((context.getResources().getDimension(C25738R.dimen.f9966lo) * 2.0f) + context.getResources().getDimension(C25738R.dimen.f9972lw)))));
        C4990ab.m7417i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", Integer.valueOf(width));
        elW = width;
        AppMethodBeat.m2505o(104337);
        return width;
    }

    public final void initView() {
        AppMethodBeat.m2504i(104338);
        setMMTitle(this.mTitle + "(" + this.ejS + ")");
        setBackBtn(new C1815411());
        this.elU = (MMEditText) findViewById(2131823253);
        this.ely = (GridView) findViewById(2131827307);
        this.ely.setNumColumns(SeeRoomMemberUI.m41561bz(this));
        this.ely.setColumnWidth(getResources().getDimensionPixelSize(C25738R.dimen.f9957ld));
        this.elP = new C26031b(this, this.eih, this.ejD, m41545Ko(), this.ejT);
        this.elU.addTextChangedListener(new C1815512());
        this.ely.setOnItemClickListener(new C1815613());
        this.ely.setOnItemLongClickListener(new C1815714());
        this.ely.setAdapter(this.elP);
        AppMethodBeat.m2505o(104338);
    }

    /* renamed from: Kn */
    private void m41544Kn() {
        AppMethodBeat.m2504i(104339);
        this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.talker == null ? this.ejD : this.talker);
        List my = C37921n.m64074my(this.ejD);
        if (this.elP != null) {
            this.elP.mo43903Q(my);
        }
        AppMethodBeat.m2505o(104339);
    }

    public void onPause() {
        AppMethodBeat.m2504i(104340);
        super.onPause();
        if (this.elS != null) {
            this.elS.dJS();
        }
        AppMethodBeat.m2505o(104340);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104341);
        C1720g.m3535RO().eJo.mo14546b(990, (C1202f) this);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(104341);
    }

    /* renamed from: Ko */
    private List<String> m41545Ko() {
        List P;
        AppMethodBeat.m2504i(104342);
        LinkedList linkedList = new LinkedList();
        if (C5046bo.isNullOrNil(this.elQ)) {
            Object P2 = linkedList;
        } else {
            P2 = C5046bo.m7508P(this.elQ.split(","));
        }
        C5140bq RA = ((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().mo15356RA("@t.qq.com");
        if (RA != null) {
            P2.add(RA.name);
        }
        AppMethodBeat.m2505o(104342);
        return P2;
    }

    public final int getLayoutId() {
        return 2130970583;
    }

    /* renamed from: km */
    private void m41573km(String str) {
        AppMethodBeat.m2504i(104343);
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(104343);
            return;
        }
        List linkedList = new LinkedList();
        linkedList.add(str);
        final C46610a a = C30262b.alY(this.ejD).mo20632a(this.ejD, linkedList, 0);
        a.mo74753b(new C2602815());
        a.mo74754c(new C2603516());
        getString(C25738R.string.f9238tz);
        a.mo48450a(this, getString(C25738R.string.drx), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(104324);
                a.cancel();
                AppMethodBeat.m2505o(104324);
            }
        });
        AppMethodBeat.m2505o(104343);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(104344);
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
        }
        C42124a jY = C42124a.m74268jY(str);
        if (jY != null) {
            jY.mo67668a(this, null, null);
            AppMethodBeat.m2505o(104344);
            return;
        }
        AppMethodBeat.m2505o(104344);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(104345);
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.m2505o(104345);
                    return;
                }
                String stringExtra = intent.getStringExtra("Select_Contact");
                if (!C32794m.m53575mo(stringExtra)) {
                    C30379h.m48461b((Context) this, getString(C25738R.string.dt9), getString(C25738R.string.f9238tz), true);
                    AppMethodBeat.m2505o(104345);
                    return;
                } else if (m41572kh(stringExtra)) {
                    C30379h.m48461b((Context) this, getString(C25738R.string.f8716cy), getString(C25738R.string.f9238tz), true);
                    AppMethodBeat.m2505o(104345);
                    return;
                } else if (C5046bo.m7508P(stringExtra.split(",")) == null) {
                    AppMethodBeat.m2505o(104345);
                    return;
                } else {
                    final String stringExtra2 = intent.getStringExtra("Select_Contact");
                    C7577u oa = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.ejD);
                    if (oa != null) {
                        if (oa.drV() == 2) {
                            C5659a asL = new C5659a(this).asL(getString(C25738R.string.dqy));
                            asL.zQJ = getString(C25738R.string.f9221tf);
                            asL = asL.mo11526re(true).mo11525m(Boolean.TRUE);
                            asL.zQK = getString(C25738R.string.f9076or);
                            asL.asN(getString(C25738R.string.dip)).mo11523c(new C5662c() {
                                /* renamed from: d */
                                public final void mo5699d(boolean z, String str) {
                                    AppMethodBeat.m2504i(104325);
                                    if (z) {
                                        SeeRoomMemberUI.m41554a(SeeRoomMemberUI.this, stringExtra2, str);
                                    }
                                    AppMethodBeat.m2505o(104325);
                                }
                            }).show();
                            AppMethodBeat.m2505o(104345);
                            return;
                        }
                        m41560b(stringExtra, null, C25738R.string.f8728db);
                        AppMethodBeat.m2505o(104345);
                        return;
                    }
                }
                break;
            case 2:
                if (intent != null) {
                    m41573km(intent.getStringExtra("Select_Contact"));
                    break;
                } else {
                    AppMethodBeat.m2505o(104345);
                    return;
                }
        }
        AppMethodBeat.m2505o(104345);
    }

    /* renamed from: b */
    private void m41560b(String str, String str2, int i) {
        AppMethodBeat.m2504i(104346);
        if (!C32794m.m53575mo(str)) {
            C30379h.m48461b((Context) this, getString(C25738R.string.dt9), getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(104346);
        } else if (m41572kh(str)) {
            C30379h.m48461b((Context) this, getString(C25738R.string.f8716cy), getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(104346);
        } else {
            List P = C5046bo.m7508P(str.split(","));
            if (P == null) {
                AppMethodBeat.m2505o(104346);
                return;
            }
            final C46610a a = C30262b.alY(this.ejD).mo20633a(this.ejD, P, str2);
            a.mo74755d(new C181592());
            getString(C25738R.string.f9238tz);
            a.mo48450a(this, getString(i), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(104310);
                    a.cancel();
                    AppMethodBeat.m2505o(104310);
                }
            });
            AppMethodBeat.m2505o(104346);
        }
    }

    /* renamed from: d */
    private void m41564d(String str, List<String> list) {
        AppMethodBeat.m2504i(104347);
        if (list != null && list.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            C32794m.m53572a(str, linkedList, getString(C25738R.string.ajv), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
        AppMethodBeat.m2505o(104347);
    }

    /* renamed from: JI */
    private static boolean m41543JI() {
        AppMethodBeat.m2504i(104348);
        if (C5046bo.getInt(C26373g.m41964Nu().getValue("ChatroomGlobalSwitch"), 1) == 1) {
            AppMethodBeat.m2505o(104348);
            return true;
        }
        AppMethodBeat.m2505o(104348);
        return false;
    }

    /* renamed from: O */
    private static List<String> m41546O(List<String> list) {
        AppMethodBeat.m2504i(104349);
        LinkedList linkedList = new LinkedList();
        if (!C1720g.m3531RK()) {
            AppMethodBeat.m2505o(104349);
            return linkedList;
        } else if (list == null) {
            AppMethodBeat.m2505o(104349);
            return linkedList;
        } else {
            for (Object obj : list) {
                Object obj2;
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(obj2);
                if (!(aoO == null || ((int) aoO.ewQ) == 0)) {
                    obj2 = aoO.mo16707Oj();
                }
                linkedList.add(obj2);
            }
            AppMethodBeat.m2505o(104349);
            return linkedList;
        }
    }

    /* renamed from: kh */
    private boolean m41572kh(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(104350);
        if (C5046bo.nullAsNil(C1853r.m3846Yz()).equals(str)) {
            AppMethodBeat.m2505o(104350);
            return true;
        }
        List my = C37921n.m64074my(this.ejD);
        if (my == null) {
            AppMethodBeat.m2505o(104350);
            return false;
        }
        Iterator it = my.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                AppMethodBeat.m2505o(104350);
                return z2;
            } else if (((String) it.next()).equals(str)) {
                z = true;
            } else {
                z = z2;
            }
        }
    }

    /* renamed from: a */
    protected static String m41550a(C7577u c7577u, String str) {
        AppMethodBeat.m2504i(104351);
        String str2;
        if (c7577u == null) {
            str2 = "";
            AppMethodBeat.m2505o(104351);
            return str2;
        }
        str2 = c7577u.mo16807mJ(str);
        AppMethodBeat.m2505o(104351);
        return str2;
    }

    private static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        Class cls;
        AppMethodBeat.m2504i(104352);
        if (obj == null) {
            AppMethodBeat.m2505o(104352);
            return null;
        }
        Method declaredMethod;
        Object invoke;
        cls = obj.getClass();
        while (cls != Object.class) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                break;
            } catch (NoSuchMethodException e) {
                C4990ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e, "", new Object[0]);
            } catch (SecurityException e2) {
                C4990ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e2, "", new Object[0]);
            }
        }
        declaredMethod = null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            try {
                invoke = declaredMethod.invoke(obj, objArr);
            } catch (IllegalAccessException e3) {
                C4990ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e3, "", new Object[0]);
                invoke = null;
            } catch (IllegalArgumentException e4) {
                C4990ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e4, "", new Object[0]);
                invoke = null;
            } catch (InvocationTargetException e5) {
                C4990ab.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e5, "", new Object[0]);
            }
            AppMethodBeat.m2505o(104352);
            return invoke;
        }
        invoke = null;
        AppMethodBeat.m2505o(104352);
        return invoke;
        cls = cls.getSuperclass();
    }

    /* renamed from: d */
    static /* synthetic */ void m41563d(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.m2504i(104354);
        String c = C5046bo.m7536c(C37921n.m64074my(seeRoomMemberUI.ejD), ",");
        Intent intent = new Intent();
        intent.putExtra("titile", seeRoomMemberUI.getString(C25738R.string.f8782eu));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", C15830s.znF);
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 4);
        intent.putExtra("KBlockOpenImFav", C1855t.m3902mO(seeRoomMemberUI.ejD));
        C25985d.m41466b((Context) seeRoomMemberUI, ".ui.contact.SelectContactUI", intent, 1);
        AppMethodBeat.m2505o(104354);
    }

    /* renamed from: e */
    static /* synthetic */ void m41565e(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.m2504i(104355);
        C7060h.pYm.mo8378a(219, 8, 1, true);
        List my = C37921n.m64074my(seeRoomMemberUI.ejD);
        String c = C5046bo.m7536c(my, ",");
        int size = my.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", seeRoomMemberUI.ejD);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", c);
        intent.putExtra("room_member_count", size);
        intent.putExtra("Is_RoomOwner", seeRoomMemberUI.ejU);
        intent.putExtra("list_attr", C15830s.znF);
        intent.putExtra("room_name", seeRoomMemberUI.ejD);
        intent.putExtra("room_owner_name", seeRoomMemberUI.eih.field_roomowner);
        intent.setClass(seeRoomMemberUI, SelectDelMemberUI.class);
        seeRoomMemberUI.startActivityForResult(intent, 2);
        AppMethodBeat.m2505o(104355);
    }

    /* renamed from: l */
    static /* synthetic */ void m41574l(SeeRoomMemberUI seeRoomMemberUI) {
        AppMethodBeat.m2504i(104359);
        if (seeRoomMemberUI.eih != null) {
            seeRoomMemberUI.setMMTitle(seeRoomMemberUI.mTitle + "(" + seeRoomMemberUI.eih.afg().size() + ")");
        }
        AppMethodBeat.m2505o(104359);
    }
}
