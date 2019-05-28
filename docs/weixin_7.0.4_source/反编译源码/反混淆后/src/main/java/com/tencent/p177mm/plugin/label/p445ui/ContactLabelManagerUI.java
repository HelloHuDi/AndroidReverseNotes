package com.tencent.p177mm.plugin.label.p445ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.contact.C15830s;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.label.C21160e;
import com.tencent.p177mm.plugin.label.p1277b.C43235b;
import com.tencent.p177mm.plugin.label.p1277b.C43236c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C46619af;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI */
public class ContactLabelManagerUI extends ContactLabelBaseUI implements OnCreateContextMenuListener, OnItemClickListener, C1202f, C5279d {
    private int alc;
    private int jLX = 0;
    private int jLY = 0;
    private C24088a jMO;
    private View laJ;
    private C7306ak mHandler = new C123481();
    private ListView mListView;
    private C3336b nHX = C3336b.Normal;
    private View nHY;
    private View nHZ;
    private C3335a nIa;
    private ArrayList<C46619af> nIb = new ArrayList();
    private HashMap<Integer, Integer> nIc = new HashMap();
    private boolean nId = true;
    private OnClickListener nIe = new C123416();
    private C4931a nIf = new C123427();
    private C4937b nIg = new C69578();

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$a */
    class C3335a extends BaseAdapter {
        ArrayList<C46619af> mData;

        C3335a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(22602);
            C46619af xA = mo7723xA(i);
            AppMethodBeat.m2505o(22602);
            return xA;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(22599);
            if (this.mData == null) {
                AppMethodBeat.m2505o(22599);
                return 0;
            }
            int size = this.mData.size();
            AppMethodBeat.m2505o(22599);
            return size;
        }

        /* renamed from: xA */
        public final C46619af mo7723xA(int i) {
            AppMethodBeat.m2504i(22600);
            if (this.mData == null || i > this.mData.size()) {
                AppMethodBeat.m2505o(22600);
                return null;
            }
            C46619af c46619af = (C46619af) this.mData.get(i);
            AppMethodBeat.m2505o(22600);
            return c46619af;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C39282c c39282c;
            AppMethodBeat.m2504i(22601);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(ContactLabelManagerUI.this).inflate(2130969225, viewGroup, false);
                c39282c = new C39282c(view);
                LayoutParams layoutParams = c39282c.nJd.getLayoutParams();
                layoutParams.height = (int) (((float) C1338a.m2857am(ContactLabelManagerUI.this, C25738R.dimen.f10010nb)) * C1338a.m2863fZ(ContactLabelManagerUI.this));
                c39282c.nJd.setLayoutParams(layoutParams);
                view.setTag(c39282c);
            } else {
                c39282c = (C39282c) view.getTag();
            }
            C46619af xA = mo7723xA(i);
            c39282c.nJb.setText(C44089j.m79294b(ContactLabelManagerUI.this.mController.ylL, xA.field_labelName, ContactLabelManagerUI.this.alc));
            if (ContactLabelManagerUI.this.nIc == null || !ContactLabelManagerUI.this.nIc.containsKey(Integer.valueOf(xA.field_labelID))) {
                c39282c.nJc.setVisibility(0);
                c39282c.nJc.setText("(0)");
            } else {
                c39282c.nJc.setVisibility(0);
                c39282c.nJc.setText("(" + ContactLabelManagerUI.this.nIc.get(Integer.valueOf(xA.field_labelID)) + ")");
            }
            AppMethodBeat.m2505o(22601);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$b */
    public enum C3336b {
        Normal,
        Empty;

        static {
            AppMethodBeat.m2505o(22605);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$8 */
    class C69578 implements C4937b {
        C69578() {
        }

        /* renamed from: a */
        public final void mo10136a(int i, C7298n c7298n, Object obj) {
            AppMethodBeat.m2504i(22593);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", Integer.valueOf(i), obj);
            if (ContactLabelManagerUI.this.mHandler != null) {
                ContactLabelManagerUI.this.mHandler.removeMessages(ReaderCallback.HIDDEN_BAR);
                ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(ReaderCallback.HIDDEN_BAR, 400);
            }
            AppMethodBeat.m2505o(22593);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$6 */
    class C123416 implements OnClickListener {
        C123416() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22591);
            ContactLabelManagerUI.m20267b(ContactLabelManagerUI.this);
            AppMethodBeat.m2505o(22591);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$7 */
    class C123427 implements C4931a {
        C123427() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(22592);
            if (!C5046bo.isNullOrNil(str)) {
                ContactLabelManagerUI.m20262a(ContactLabelManagerUI.this);
            }
            AppMethodBeat.m2505o(22592);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$11 */
    class C1234311 implements OnTouchListener {
        C1234311() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(22596);
            if (motionEvent.getAction() == 0) {
                ContactLabelManagerUI.this.jLX = (int) motionEvent.getRawX();
                ContactLabelManagerUI.this.jLY = (int) motionEvent.getRawY();
            }
            AppMethodBeat.m2505o(22596);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$12 */
    class C1234412 implements OnItemLongClickListener {
        C1234412() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(22597);
            ContactLabelManagerUI.this.jMO.mo39885a(view, i, j, ContactLabelManagerUI.this, ContactLabelManagerUI.this, ContactLabelManagerUI.this.jLX, ContactLabelManagerUI.this.jLY);
            AppMethodBeat.m2505o(22597);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$13 */
    class C1234513 implements Runnable {
        C1234513() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22598);
            C9638aw.m17182Rg().mo14541a(new C43236c(), 0);
            AppMethodBeat.m2505o(22598);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$9 */
    class C123469 implements OnMenuItemClickListener {
        C123469() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22594);
            ContactLabelManagerUI.m20267b(ContactLabelManagerUI.this);
            AppMethodBeat.m2505o(22594);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$10 */
    class C1234710 implements OnMenuItemClickListener {
        C1234710() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(22595);
            ContactLabelManagerUI.this.finish();
            AppMethodBeat.m2505o(22595);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$1 */
    class C123481 extends C7306ak {
        C123481() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(22584);
            C4990ab.m7411d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", Integer.valueOf(message.what));
            switch (message.what) {
                case ReaderCallback.HIDDEN_BAR /*5001*/:
                    ContactLabelManagerUI.m20262a(ContactLabelManagerUI.this);
                    AppMethodBeat.m2505o(22584);
                    return;
                case ReaderCallback.SHOW_BAR /*5002*/:
                    ContactLabelManagerUI.this.mo36484PI(ContactLabelManagerUI.this.getString(C25738R.string.f9260un));
                    AppMethodBeat.m2505o(22584);
                    return;
                case ReaderCallback.COPY_SELECT_TEXT /*5003*/:
                    ContactLabelManagerUI.this.bJc();
                    break;
            }
            AppMethodBeat.m2505o(22584);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$3 */
    class C123493 implements DialogInterface.OnClickListener {
        C123493() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ContactLabelManagerUI() {
        AppMethodBeat.m2504i(22606);
        AppMethodBeat.m2505o(22606);
    }

    /* renamed from: a */
    static /* synthetic */ void m20262a(ContactLabelManagerUI contactLabelManagerUI) {
        AppMethodBeat.m2504i(22621);
        contactLabelManagerUI.m20275iz(false);
        AppMethodBeat.m2505o(22621);
    }

    public final int getLayoutId() {
        return 2130969227;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22608);
        super.onCreate(bundle);
        initView();
        C9638aw.m17180RS().mo10302aa(new C1234513());
        C21160e.bIZ().mo10116c(this.nIf);
        C7060h.pYm.mo8381e(16097, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2));
        AppMethodBeat.m2505o(22608);
    }

    public void onResume() {
        AppMethodBeat.m2504i(22609);
        C9638aw.m17182Rg().mo14539a(636, (C1202f) this);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.nIg);
        m20275iz(true);
        super.onResume();
        AppMethodBeat.m2505o(22609);
    }

    public void onPause() {
        AppMethodBeat.m2504i(22610);
        C9638aw.m17182Rg().mo14546b(636, (C1202f) this);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(this.nIg);
        super.onPause();
        AppMethodBeat.m2505o(22610);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22611);
        C21160e.bIZ().mo10117d(this.nIf);
        super.onDestroy();
        AppMethodBeat.m2505o(22611);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(22612);
        if (this.nIa != null && i >= 0) {
            C46619af xA = this.nIa.mo7723xA(i);
            if (xA != null) {
                String str = xA.field_labelID;
                String str2 = xA.field_labelName;
                Intent intent = new Intent();
                intent.putExtra("label_id", str);
                intent.putExtra("label_name", str2);
                intent.putExtra("label_source", "label_source_Address");
                intent.setClass(this, ContactLabelEditUI.class);
                startActivity(intent);
                if (C5046bo.isNullOrNil(str)) {
                    if (this.nIb == null || this.nIb.isEmpty()) {
                        C7060h.pYm.mo8381e(11347, Integer.valueOf(1), Integer.valueOf(0));
                        AppMethodBeat.m2505o(22612);
                        return;
                    }
                    C7060h.pYm.mo8381e(11347, Integer.valueOf(1), Integer.valueOf(1));
                }
            }
        }
        AppMethodBeat.m2505o(22612);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(22613);
        int i = ((AdapterContextMenuInfo) contextMenuInfo).position;
        if (this.nIa != null && i >= 0) {
            C46619af xA = this.nIa.mo7723xA(i);
            if (xA != null) {
                contextMenu.setHeaderTitle(C44089j.m79292b(view.getContext(), xA.field_labelName));
                contextMenu.add(0, 0, 0, getString(C25738R.string.f9088p4));
                contextMenu.add(0, 1, 1, getString(C25738R.string.f9099pg));
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AppMethodBeat.m2505o(22613);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.m2504i(22614);
        int i2 = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (this.nIa != null && i2 >= 0) {
            final C46619af xA = this.nIa.mo7723xA(i2);
            switch (i) {
                case 0:
                    C30379h.m48466d(this, getString(C25738R.string.ckx), "", getString(C25738R.string.f9088p4), getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(22585);
                            if (xA != null) {
                                if (xA.field_isTemporary) {
                                    ContactLabelManagerUI.m20265a(ContactLabelManagerUI.this, xA.field_labelID);
                                    AppMethodBeat.m2505o(22585);
                                    return;
                                }
                                ContactLabelManagerUI.m20264a(ContactLabelManagerUI.this, xA);
                            }
                            AppMethodBeat.m2505o(22585);
                        }
                    }, new C123493());
                    AppMethodBeat.m2505o(22614);
                    return;
                case 1:
                    Intent intent = new Intent();
                    intent.setClass(this, ContactLabelEditUI.class);
                    intent.putExtra("label_id", xA.field_labelID);
                    intent.putExtra("label_name", xA.field_labelName);
                    intent.putExtra("label_source", "label_source_Address");
                    startActivity(intent);
                    break;
            }
        }
        AppMethodBeat.m2505o(22614);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(22615);
        C4990ab.m7417i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (c1207m.getType()) {
            case 636:
                if (i == 0 && i2 == 0) {
                    m20259PM(((C43235b) c1207m).nHx);
                    AppMethodBeat.m2505o(22615);
                    return;
                }
                C4990ab.m7420w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
                bJh();
                AppMethodBeat.m2505o(22615);
                return;
            default:
                C4990ab.m7420w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
                AppMethodBeat.m2505o(22615);
                return;
        }
    }

    /* renamed from: iz */
    private synchronized void m20275iz(final boolean z) {
        AppMethodBeat.m2504i(22616);
        C4990ab.m7411d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", String.valueOf(z));
        if (z && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(ReaderCallback.SHOW_BAR, 400);
        }
        C9638aw.m17180RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$4$1 */
            class C123521 implements Runnable {
                C123521() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(22586);
                    ContactLabelManagerUI.m20263a(ContactLabelManagerUI.this, C3336b.Empty);
                    if (z && ContactLabelManagerUI.this.mHandler != null) {
                        ContactLabelManagerUI.this.mHandler.removeMessages(ReaderCallback.SHOW_BAR);
                        ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(ReaderCallback.COPY_SELECT_TEXT, 0);
                    }
                    AppMethodBeat.m2505o(22586);
                }
            }

            /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelManagerUI$4$2 */
            class C123532 implements Runnable {
                C123532() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(22587);
                    ContactLabelManagerUI.m20263a(ContactLabelManagerUI.this, C3336b.Normal);
                    C3335a k = ContactLabelManagerUI.this.nIa;
                    k.mData = ContactLabelManagerUI.this.nIb;
                    k.notifyDataSetChanged();
                    ContactLabelManagerUI.this.nIa.notifyDataSetInvalidated();
                    if (z && ContactLabelManagerUI.this.mHandler != null) {
                        ContactLabelManagerUI.this.mHandler.removeMessages(ReaderCallback.SHOW_BAR);
                        ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(ReaderCallback.COPY_SELECT_TEXT, 400);
                    }
                    AppMethodBeat.m2505o(22587);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(22588);
                ContactLabelManagerUI.this.nIb = C21160e.bIZ().dsn();
                if (ContactLabelManagerUI.this.nIb == null || ContactLabelManagerUI.this.nIb.size() <= 0) {
                    C4990ab.m7416i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
                    if (ContactLabelManagerUI.this.nId) {
                        C7060h.pYm.mo8381e(11346, Integer.valueOf(1), Integer.valueOf(0));
                        ContactLabelManagerUI.this.nId = false;
                    }
                    C5004al.m7441d(new C123521());
                    AppMethodBeat.m2505o(22588);
                    return;
                }
                C4990ab.m7416i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
                if (ContactLabelManagerUI.this.nId) {
                    C7060h.pYm.mo8381e(11346, Integer.valueOf(1), Integer.valueOf(1));
                    ContactLabelManagerUI.this.nId = false;
                }
                if (ContactLabelManagerUI.this.nIb != null && ContactLabelManagerUI.this.nIb.size() > 0) {
                    int size = ContactLabelManagerUI.this.nIb.size();
                    C21160e.bIZ().ahw();
                    for (int i = 0; i < size; i++) {
                        int i2 = ((C46619af) ContactLabelManagerUI.this.nIb.get(i)).field_labelID;
                        ArrayList aoD = C21160e.bIZ().aoD(String.valueOf(i2));
                        if (aoD == null || aoD.size() <= 0) {
                            ContactLabelManagerUI.this.nIc.put(Integer.valueOf(i2), Integer.valueOf(0));
                        } else {
                            ContactLabelManagerUI.this.nIc.put(Integer.valueOf(i2), Integer.valueOf(aoD.size()));
                        }
                    }
                }
                C5004al.m7441d(new C123532());
                AppMethodBeat.m2505o(22588);
            }

            public final String toString() {
                AppMethodBeat.m2504i(22589);
                String str = super.toString() + "|updateData";
                AppMethodBeat.m2505o(22589);
                return str;
            }
        });
        AppMethodBeat.m2505o(22616);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(22617);
        C4990ab.m7417i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            AppMethodBeat.m2505o(22617);
            return;
        }
        switch (i) {
            case 7001:
                String stringExtra = intent.getStringExtra("Select_Contact");
                C4990ab.m7417i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", String.valueOf(stringExtra));
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    Intent intent2 = new Intent(intent);
                    intent2.putExtra("label_source", "label_source_Address");
                    intent2.setClass(this, ContactLabelEditUI.class);
                    intent2.putExtra("Select_Contact", stringExtra);
                    startActivity(intent2);
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(22617);
    }

    /* renamed from: PM */
    private void m20259PM(String str) {
        AppMethodBeat.m2504i(22618);
        if (C21160e.bIZ().mo64083pI(str)) {
            bJi();
            AppMethodBeat.m2505o(22618);
            return;
        }
        C4990ab.m7420w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
        bJh();
        AppMethodBeat.m2505o(22618);
    }

    private void bJh() {
        AppMethodBeat.m2504i(22619);
        bJc();
        mo36483JN(getString(C25738R.string.b4x));
        AppMethodBeat.m2505o(22619);
    }

    private void bJi() {
        AppMethodBeat.m2504i(22620);
        bJc();
        m20275iz(false);
        AppMethodBeat.m2505o(22620);
    }

    public final void initView() {
        AppMethodBeat.m2504i(22607);
        this.alc = C1338a.m2856al(this.mController.ylL, C25738R.dimen.f9980m5);
        setMMTitle(getString(C25738R.string.ckv));
        addTextOptionMenu(0, getString(C25738R.string.cl4), new C123469());
        setBackBtn(new C1234710());
        this.nIa = new C3335a();
        this.laJ = findViewById(2131823065);
        this.nHY = findViewById(2131823067);
        this.nHZ = findViewById(2131823068);
        this.nHZ.setOnClickListener(this.nIe);
        this.mListView = (ListView) findViewById(2131823066);
        this.jMO = new C24088a(this);
        this.mListView.setOnTouchListener(new C1234311());
        this.mListView.setOnItemLongClickListener(new C1234412());
        this.mListView.setAdapter(this.nIa);
        this.mListView.setOnItemClickListener(this);
        AppMethodBeat.m2505o(22607);
    }

    /* renamed from: b */
    static /* synthetic */ void m20267b(ContactLabelManagerUI contactLabelManagerUI) {
        AppMethodBeat.m2504i(22622);
        if (contactLabelManagerUI.nIb == null || contactLabelManagerUI.nIb.isEmpty()) {
            C7060h.pYm.mo8381e(11347, Integer.valueOf(1), Integer.valueOf(0));
        } else {
            C7060h.pYm.mo8381e(11347, Integer.valueOf(1), Integer.valueOf(1));
        }
        C4990ab.m7416i("MicroMsg.Label.ContactLabelManagerUI", "dz[dealAddLabel]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", C15830s.m24190C(C15830s.znE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelManagerUI.getString(C25738R.string.cku));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 5);
        intent.putExtra("label_source", "label_source_Address");
        C25985d.m41466b((Context) contactLabelManagerUI, ".ui.contact.SelectContactUI", intent, 7001);
        AppMethodBeat.m2505o(22622);
    }
}
