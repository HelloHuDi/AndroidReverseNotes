package com.tencent.p177mm.chatroom.p216ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.roomsdk.p1086a.C30262b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C44204b;
import com.tencent.p177mm.roomsdk.p1086a.p1341b.C46609a;
import com.tencent.p177mm.roomsdk.p1086a.p1342c.C46610a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7577u;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI */
public class DelChatroomMemberUI extends MMActivity implements C1202f {
    private String chatroomName;
    private C7577u eih;
    private C32445a eje;
    private LinkedList<String> ejf = new LinkedList();
    private ListView mListView;
    private int scene;
    private C44275p tipDialog;

    /* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI$b */
    class C18137b {
        public ImageView ejo;
        public TextView ejp;
        public TextView ejq;

        C18137b() {
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI$3 */
    class C260173 implements C44204b {

        /* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI$3$1 */
        class C260181 implements OnClickListener {
            C260181() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI$3$2 */
        class C260192 implements OnClickListener {
            C260192() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C260173() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
            AppMethodBeat.m2504i(104086);
            if (!(i == 0 && i2 == 0)) {
                if (i2 == -2024) {
                    C42124a jY = C42124a.m74268jY(str);
                    if (jY != null) {
                        jY.mo67668a(DelChatroomMemberUI.this, null, null);
                        AppMethodBeat.m2505o(104086);
                        return;
                    }
                    C30379h.m48447a(DelChatroomMemberUI.this.mController.ylL, DelChatroomMemberUI.this.getString(C25738R.string.ds7), null, DelChatroomMemberUI.this.getString(C25738R.string.ds8), false, new C260181());
                    AppMethodBeat.m2505o(104086);
                    return;
                }
                C30379h.m48447a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.getString(C25738R.string.dsf), null, DelChatroomMemberUI.this.getString(C25738R.string.f9187s6), false, new C260192());
            }
            AppMethodBeat.m2505o(104086);
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI$a */
    class C32445a extends BaseAdapter {
        List<C7616ad> ejk = new LinkedList();

        /* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI$a$1 */
        class C324461 implements View.OnClickListener {

            /* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI$a$1$2 */
            class C324442 implements OnClickListener {
                C324442() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }

            C324461() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(104089);
                final C7616ad c7616ad = (C7616ad) C32445a.this.getItem(((Integer) view.getTag()).intValue());
                C30379h.m48445a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.getString(C25738R.string.ds1, new Object[]{C32445a.this.mo53080c(c7616ad)}), null, DelChatroomMemberUI.this.getString(C25738R.string.ds9), DelChatroomMemberUI.this.getString(C25738R.string.f9076or), true, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(104088);
                        DelChatroomMemberUI.m83498a(DelChatroomMemberUI.this, c7616ad.field_username);
                        AppMethodBeat.m2505o(104088);
                    }
                }, new C324442());
                AppMethodBeat.m2505o(104089);
            }
        }

        C32445a() {
            AppMethodBeat.m2504i(104090);
            AppMethodBeat.m2505o(104090);
        }

        /* renamed from: P */
        public final void mo53079P(List<String> list) {
            AppMethodBeat.m2504i(104091);
            if (list != null) {
                C4990ab.m7417i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", Integer.valueOf(list.size()));
                this.ejk.clear();
                for (String str : list) {
                    C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                    if (!(aoO == null || C5046bo.isNullOrNil(aoO.field_username) || !aoO.field_username.equals(str))) {
                        this.ejk.add(aoO);
                    }
                }
            }
            AppMethodBeat.m2505o(104091);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(104092);
            int size = this.ejk.size();
            AppMethodBeat.m2505o(104092);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(104093);
            Object obj = this.ejk.get(i);
            AppMethodBeat.m2505o(104093);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C18137b c18137b;
            AppMethodBeat.m2504i(104094);
            if (view == null) {
                view = View.inflate(DelChatroomMemberUI.this, 2130969007, null);
                c18137b = new C18137b();
                c18137b.ejo = (ImageView) view.findViewById(2131822363);
                c18137b.ejp = (TextView) view.findViewById(2131822365);
                c18137b.ejq = (TextView) view.findViewById(2131822364);
                c18137b.ejq.setOnClickListener(new C324461());
                view.setTag(c18137b);
            } else {
                c18137b = (C18137b) view.getTag();
            }
            c18137b.ejq.setTag(Integer.valueOf(i));
            C7616ad c7616ad = (C7616ad) getItem(i);
            CharSequence c = mo53080c(c7616ad);
            c18137b.ejp.setText(c);
            C44089j.m79293b(DelChatroomMemberUI.this, c, c18137b.ejp.getTextSize());
            C40460b.m69434b(c18137b.ejo, c7616ad.field_username);
            AppMethodBeat.m2505o(104094);
            return view;
        }

        /* renamed from: c */
        public final String mo53080c(C7616ad c7616ad) {
            String b;
            AppMethodBeat.m2504i(104095);
            if (C5046bo.isNullOrNil(c7616ad.field_conRemark)) {
                b = DelChatroomMemberUI.m83500b(DelChatroomMemberUI.this, c7616ad.field_username);
            } else {
                b = c7616ad.field_conRemark;
            }
            if (C5046bo.isNullOrNil(b)) {
                b = c7616ad.field_conRemark;
            }
            if (C5046bo.isNullOrNil(b)) {
                b = c7616ad.mo16706Oi();
            }
            AppMethodBeat.m2505o(104095);
            return b;
        }
    }

    /* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI$1 */
    class C452861 implements OnMenuItemClickListener {
        C452861() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(104083);
            DelChatroomMemberUI.this.finish();
            AppMethodBeat.m2505o(104083);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public DelChatroomMemberUI() {
        AppMethodBeat.m2504i(104096);
        AppMethodBeat.m2505o(104096);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(104097);
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        this.scene = getIntent().getIntExtra("scene", 0);
        String[] split = getIntent().getStringExtra("members").split(",");
        int length = split.length;
        while (i < length) {
            this.ejf.add(split[i]);
            i++;
        }
        this.eih = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(this.chatroomName);
        initView();
        AppMethodBeat.m2505o(104097);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(104098);
        super.onDestroy();
        AppMethodBeat.m2505o(104098);
    }

    public void onResume() {
        AppMethodBeat.m2504i(104099);
        super.onResume();
        AppMethodBeat.m2505o(104099);
    }

    public final void initView() {
        AppMethodBeat.m2504i(104100);
        setMMTitle((int) C25738R.string.dsb);
        this.mListView = (ListView) findViewById(2131822366);
        this.eje = new C32445a();
        this.eje.mo53079P(this.ejf);
        this.mListView.setAdapter(this.eje);
        setBackBtn(new C452861());
        AppMethodBeat.m2505o(104100);
    }

    public final int getLayoutId() {
        return 2130969008;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(104101);
        C4990ab.m7416i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.m2505o(104101);
    }

    /* renamed from: a */
    static /* synthetic */ void m83498a(DelChatroomMemberUI delChatroomMemberUI, String str) {
        AppMethodBeat.m2504i(104102);
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(104102);
            return;
        }
        final List linkedList = new LinkedList();
        linkedList.add(str);
        final C46610a a = C30262b.alY(delChatroomMemberUI.chatroomName).mo20632a(delChatroomMemberUI.chatroomName, linkedList, delChatroomMemberUI.scene);
        a.mo74753b(new C44204b() {

            /* renamed from: com.tencent.mm.chatroom.ui.DelChatroomMemberUI$2$1 */
            class C376401 implements Runnable {
                C376401() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(104084);
                    if (DelChatroomMemberUI.this.eje.getCount() == 0) {
                        DelChatroomMemberUI.this.finish();
                    }
                    AppMethodBeat.m2505o(104084);
                }
            }

            /* renamed from: a */
            public final /* synthetic */ void mo11081a(int i, int i2, String str, C46609a c46609a) {
                Object obj;
                AppMethodBeat.m2504i(104085);
                C30379h.m48465bQ(DelChatroomMemberUI.this, DelChatroomMemberUI.this.getString(C25738R.string.ds_));
                C32445a a = DelChatroomMemberUI.this.eje;
                Object obj2 = null;
                Iterator it = linkedList.iterator();
                while (true) {
                    obj = obj2;
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = (String) it.next();
                    for (Object obj3 : a.ejk) {
                        if (obj3.field_username.equals(str2)) {
                            break;
                        }
                    }
                    Object obj32 = null;
                    if (obj32 != null) {
                        obj2 = 1;
                        a.ejk.remove(obj32);
                    } else {
                        obj2 = obj;
                    }
                }
                if (obj != null) {
                    a.notifyDataSetChanged();
                }
                DelChatroomMemberUI.this.mListView.post(new C376401());
                AppMethodBeat.m2505o(104085);
            }
        });
        a.mo74754c(new C260173());
        delChatroomMemberUI.getString(C25738R.string.f9238tz);
        a.mo48450a(delChatroomMemberUI, delChatroomMemberUI.getString(C25738R.string.drx), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(104087);
                a.cancel();
                AppMethodBeat.m2505o(104087);
            }
        });
        AppMethodBeat.m2505o(104102);
    }

    /* renamed from: b */
    static /* synthetic */ String m83500b(DelChatroomMemberUI delChatroomMemberUI, String str) {
        AppMethodBeat.m2504i(104103);
        if (delChatroomMemberUI.eih == null) {
            AppMethodBeat.m2505o(104103);
            return null;
        }
        String mJ = delChatroomMemberUI.eih.mo16807mJ(str);
        AppMethodBeat.m2505o(104103);
        return mJ;
    }
}
