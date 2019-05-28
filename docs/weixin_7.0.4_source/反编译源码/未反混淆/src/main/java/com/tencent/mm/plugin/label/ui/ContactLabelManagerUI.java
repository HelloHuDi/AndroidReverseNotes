package com.tencent.mm.plugin.label.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.label.b.c;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.s;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI extends ContactLabelBaseUI implements OnCreateContextMenuListener, OnItemClickListener, f, d {
    private int alc;
    private int jLX = 0;
    private int jLY = 0;
    private com.tencent.mm.ui.widget.b.a jMO;
    private View laJ;
    private ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(22584);
            ab.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", Integer.valueOf(message.what));
            switch (message.what) {
                case ReaderCallback.HIDDEN_BAR /*5001*/:
                    ContactLabelManagerUI.a(ContactLabelManagerUI.this);
                    AppMethodBeat.o(22584);
                    return;
                case ReaderCallback.SHOW_BAR /*5002*/:
                    ContactLabelManagerUI.this.PI(ContactLabelManagerUI.this.getString(R.string.un));
                    AppMethodBeat.o(22584);
                    return;
                case ReaderCallback.COPY_SELECT_TEXT /*5003*/:
                    ContactLabelManagerUI.this.bJc();
                    break;
            }
            AppMethodBeat.o(22584);
        }
    };
    private ListView mListView;
    private b nHX = b.Normal;
    private View nHY;
    private View nHZ;
    private a nIa;
    private ArrayList<af> nIb = new ArrayList();
    private HashMap<Integer, Integer> nIc = new HashMap();
    private boolean nId = true;
    private OnClickListener nIe = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(22591);
            ContactLabelManagerUI.b(ContactLabelManagerUI.this);
            AppMethodBeat.o(22591);
        }
    };
    private com.tencent.mm.sdk.e.k.a nIf = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(22592);
            if (!bo.isNullOrNil(str)) {
                ContactLabelManagerUI.a(ContactLabelManagerUI.this);
            }
            AppMethodBeat.o(22592);
        }
    };
    private com.tencent.mm.sdk.e.n.b nIg = new com.tencent.mm.sdk.e.n.b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(22593);
            ab.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", Integer.valueOf(i), obj);
            if (ContactLabelManagerUI.this.mHandler != null) {
                ContactLabelManagerUI.this.mHandler.removeMessages(ReaderCallback.HIDDEN_BAR);
                ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(ReaderCallback.HIDDEN_BAR, 400);
            }
            AppMethodBeat.o(22593);
        }
    };

    class a extends BaseAdapter {
        ArrayList<af> mData;

        a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(22602);
            af xA = xA(i);
            AppMethodBeat.o(22602);
            return xA;
        }

        public final int getCount() {
            AppMethodBeat.i(22599);
            if (this.mData == null) {
                AppMethodBeat.o(22599);
                return 0;
            }
            int size = this.mData.size();
            AppMethodBeat.o(22599);
            return size;
        }

        public final af xA(int i) {
            AppMethodBeat.i(22600);
            if (this.mData == null || i > this.mData.size()) {
                AppMethodBeat.o(22600);
                return null;
            }
            af afVar = (af) this.mData.get(i);
            AppMethodBeat.o(22600);
            return afVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(22601);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(ContactLabelManagerUI.this).inflate(R.layout.qs, viewGroup, false);
                cVar = new c(view);
                LayoutParams layoutParams = cVar.nJd.getLayoutParams();
                layoutParams.height = (int) (((float) com.tencent.mm.bz.a.am(ContactLabelManagerUI.this, R.dimen.nb)) * com.tencent.mm.bz.a.fZ(ContactLabelManagerUI.this));
                cVar.nJd.setLayoutParams(layoutParams);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            af xA = xA(i);
            cVar.nJb.setText(j.b(ContactLabelManagerUI.this.mController.ylL, xA.field_labelName, ContactLabelManagerUI.this.alc));
            if (ContactLabelManagerUI.this.nIc == null || !ContactLabelManagerUI.this.nIc.containsKey(Integer.valueOf(xA.field_labelID))) {
                cVar.nJc.setVisibility(0);
                cVar.nJc.setText("(0)");
            } else {
                cVar.nJc.setVisibility(0);
                cVar.nJc.setText("(" + ContactLabelManagerUI.this.nIc.get(Integer.valueOf(xA.field_labelID)) + ")");
            }
            AppMethodBeat.o(22601);
            return view;
        }
    }

    public enum b {
        Normal,
        Empty;

        static {
            AppMethodBeat.o(22605);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactLabelManagerUI() {
        AppMethodBeat.i(22606);
        AppMethodBeat.o(22606);
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI) {
        AppMethodBeat.i(22621);
        contactLabelManagerUI.iz(false);
        AppMethodBeat.o(22621);
    }

    public final int getLayoutId() {
        return R.layout.qu;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22608);
        super.onCreate(bundle);
        initView();
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(22598);
                aw.Rg().a(new c(), 0);
                AppMethodBeat.o(22598);
            }
        });
        e.bIZ().c(this.nIf);
        h.pYm.e(16097, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(2));
        AppMethodBeat.o(22608);
    }

    public void onResume() {
        AppMethodBeat.i(22609);
        aw.Rg().a(636, (f) this);
        aw.ZK();
        com.tencent.mm.model.c.XM().a(this.nIg);
        iz(true);
        super.onResume();
        AppMethodBeat.o(22609);
    }

    public void onPause() {
        AppMethodBeat.i(22610);
        aw.Rg().b(636, (f) this);
        aw.ZK();
        com.tencent.mm.model.c.XM().b(this.nIg);
        super.onPause();
        AppMethodBeat.o(22610);
    }

    public void onDestroy() {
        AppMethodBeat.i(22611);
        e.bIZ().d(this.nIf);
        super.onDestroy();
        AppMethodBeat.o(22611);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(22612);
        if (this.nIa != null && i >= 0) {
            af xA = this.nIa.xA(i);
            if (xA != null) {
                String str = xA.field_labelID;
                String str2 = xA.field_labelName;
                Intent intent = new Intent();
                intent.putExtra("label_id", str);
                intent.putExtra("label_name", str2);
                intent.putExtra("label_source", "label_source_Address");
                intent.setClass(this, ContactLabelEditUI.class);
                startActivity(intent);
                if (bo.isNullOrNil(str)) {
                    if (this.nIb == null || this.nIb.isEmpty()) {
                        h.pYm.e(11347, Integer.valueOf(1), Integer.valueOf(0));
                        AppMethodBeat.o(22612);
                        return;
                    }
                    h.pYm.e(11347, Integer.valueOf(1), Integer.valueOf(1));
                }
            }
        }
        AppMethodBeat.o(22612);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(22613);
        int i = ((AdapterContextMenuInfo) contextMenuInfo).position;
        if (this.nIa != null && i >= 0) {
            af xA = this.nIa.xA(i);
            if (xA != null) {
                contextMenu.setHeaderTitle(j.b(view.getContext(), xA.field_labelName));
                contextMenu.add(0, 0, 0, getString(R.string.p4));
                contextMenu.add(0, 1, 1, getString(R.string.pg));
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AppMethodBeat.o(22613);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.i(22614);
        int i2 = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (this.nIa != null && i2 >= 0) {
            final af xA = this.nIa.xA(i2);
            switch (i) {
                case 0:
                    com.tencent.mm.ui.base.h.d(this, getString(R.string.ckx), "", getString(R.string.p4), getString(R.string.or), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(22585);
                            if (xA != null) {
                                if (xA.field_isTemporary) {
                                    ContactLabelManagerUI.a(ContactLabelManagerUI.this, xA.field_labelID);
                                    AppMethodBeat.o(22585);
                                    return;
                                }
                                ContactLabelManagerUI.a(ContactLabelManagerUI.this, xA);
                            }
                            AppMethodBeat.o(22585);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(22614);
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
        AppMethodBeat.o(22614);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(22615);
        ab.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (mVar.getType()) {
            case 636:
                if (i == 0 && i2 == 0) {
                    PM(((com.tencent.mm.plugin.label.b.b) mVar).nHx);
                    AppMethodBeat.o(22615);
                    return;
                }
                ab.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
                bJh();
                AppMethodBeat.o(22615);
                return;
            default:
                ab.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
                AppMethodBeat.o(22615);
                return;
        }
    }

    private synchronized void iz(final boolean z) {
        AppMethodBeat.i(22616);
        ab.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", String.valueOf(z));
        if (z && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(ReaderCallback.SHOW_BAR, 400);
        }
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(22588);
                ContactLabelManagerUI.this.nIb = e.bIZ().dsn();
                if (ContactLabelManagerUI.this.nIb == null || ContactLabelManagerUI.this.nIb.size() <= 0) {
                    ab.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
                    if (ContactLabelManagerUI.this.nId) {
                        h.pYm.e(11346, Integer.valueOf(1), Integer.valueOf(0));
                        ContactLabelManagerUI.this.nId = false;
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(22586);
                            ContactLabelManagerUI.a(ContactLabelManagerUI.this, b.Empty);
                            if (z && ContactLabelManagerUI.this.mHandler != null) {
                                ContactLabelManagerUI.this.mHandler.removeMessages(ReaderCallback.SHOW_BAR);
                                ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(ReaderCallback.COPY_SELECT_TEXT, 0);
                            }
                            AppMethodBeat.o(22586);
                        }
                    });
                    AppMethodBeat.o(22588);
                    return;
                }
                ab.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
                if (ContactLabelManagerUI.this.nId) {
                    h.pYm.e(11346, Integer.valueOf(1), Integer.valueOf(1));
                    ContactLabelManagerUI.this.nId = false;
                }
                if (ContactLabelManagerUI.this.nIb != null && ContactLabelManagerUI.this.nIb.size() > 0) {
                    int size = ContactLabelManagerUI.this.nIb.size();
                    e.bIZ().ahw();
                    for (int i = 0; i < size; i++) {
                        int i2 = ((af) ContactLabelManagerUI.this.nIb.get(i)).field_labelID;
                        ArrayList aoD = e.bIZ().aoD(String.valueOf(i2));
                        if (aoD == null || aoD.size() <= 0) {
                            ContactLabelManagerUI.this.nIc.put(Integer.valueOf(i2), Integer.valueOf(0));
                        } else {
                            ContactLabelManagerUI.this.nIc.put(Integer.valueOf(i2), Integer.valueOf(aoD.size()));
                        }
                    }
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(22587);
                        ContactLabelManagerUI.a(ContactLabelManagerUI.this, b.Normal);
                        a k = ContactLabelManagerUI.this.nIa;
                        k.mData = ContactLabelManagerUI.this.nIb;
                        k.notifyDataSetChanged();
                        ContactLabelManagerUI.this.nIa.notifyDataSetInvalidated();
                        if (z && ContactLabelManagerUI.this.mHandler != null) {
                            ContactLabelManagerUI.this.mHandler.removeMessages(ReaderCallback.SHOW_BAR);
                            ContactLabelManagerUI.this.mHandler.sendEmptyMessageDelayed(ReaderCallback.COPY_SELECT_TEXT, 400);
                        }
                        AppMethodBeat.o(22587);
                    }
                });
                AppMethodBeat.o(22588);
            }

            public final String toString() {
                AppMethodBeat.i(22589);
                String str = super.toString() + "|updateData";
                AppMethodBeat.o(22589);
                return str;
            }
        });
        AppMethodBeat.o(22616);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(22617);
        ab.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 != -1) {
            AppMethodBeat.o(22617);
            return;
        }
        switch (i) {
            case 7001:
                String stringExtra = intent.getStringExtra("Select_Contact");
                ab.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", String.valueOf(stringExtra));
                if (!bo.isNullOrNil(stringExtra)) {
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
        AppMethodBeat.o(22617);
    }

    private void PM(String str) {
        AppMethodBeat.i(22618);
        if (e.bIZ().pI(str)) {
            bJi();
            AppMethodBeat.o(22618);
            return;
        }
        ab.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
        bJh();
        AppMethodBeat.o(22618);
    }

    private void bJh() {
        AppMethodBeat.i(22619);
        bJc();
        JN(getString(R.string.b4x));
        AppMethodBeat.o(22619);
    }

    private void bJi() {
        AppMethodBeat.i(22620);
        bJc();
        iz(false);
        AppMethodBeat.o(22620);
    }

    public final void initView() {
        AppMethodBeat.i(22607);
        this.alc = com.tencent.mm.bz.a.al(this.mController.ylL, R.dimen.m5);
        setMMTitle(getString(R.string.ckv));
        addTextOptionMenu(0, getString(R.string.cl4), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22594);
                ContactLabelManagerUI.b(ContactLabelManagerUI.this);
                AppMethodBeat.o(22594);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22595);
                ContactLabelManagerUI.this.finish();
                AppMethodBeat.o(22595);
                return false;
            }
        });
        this.nIa = new a();
        this.laJ = findViewById(R.id.b45);
        this.nHY = findViewById(R.id.b47);
        this.nHZ = findViewById(R.id.b48);
        this.nHZ.setOnClickListener(this.nIe);
        this.mListView = (ListView) findViewById(R.id.b46);
        this.jMO = new com.tencent.mm.ui.widget.b.a(this);
        this.mListView.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(22596);
                if (motionEvent.getAction() == 0) {
                    ContactLabelManagerUI.this.jLX = (int) motionEvent.getRawX();
                    ContactLabelManagerUI.this.jLY = (int) motionEvent.getRawY();
                }
                AppMethodBeat.o(22596);
                return false;
            }
        });
        this.mListView.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(22597);
                ContactLabelManagerUI.this.jMO.a(view, i, j, ContactLabelManagerUI.this, ContactLabelManagerUI.this, ContactLabelManagerUI.this.jLX, ContactLabelManagerUI.this.jLY);
                AppMethodBeat.o(22597);
                return true;
            }
        });
        this.mListView.setAdapter(this.nIa);
        this.mListView.setOnItemClickListener(this);
        AppMethodBeat.o(22607);
    }

    static /* synthetic */ void b(ContactLabelManagerUI contactLabelManagerUI) {
        AppMethodBeat.i(22622);
        if (contactLabelManagerUI.nIb == null || contactLabelManagerUI.nIb.isEmpty()) {
            h.pYm.e(11347, Integer.valueOf(1), Integer.valueOf(0));
        } else {
            h.pYm.e(11347, Integer.valueOf(1), Integer.valueOf(1));
        }
        ab.i("MicroMsg.Label.ContactLabelManagerUI", "dz[dealAddLabel]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.C(s.znE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelManagerUI.getString(R.string.cku));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 5);
        intent.putExtra("label_source", "label_source_Address");
        com.tencent.mm.bp.d.b((Context) contactLabelManagerUI, ".ui.contact.SelectContactUI", intent, 7001);
        AppMethodBeat.o(22622);
    }
}
