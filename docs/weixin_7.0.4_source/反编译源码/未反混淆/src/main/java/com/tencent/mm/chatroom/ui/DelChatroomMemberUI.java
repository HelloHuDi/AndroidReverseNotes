package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DelChatroomMemberUI extends MMActivity implements f {
    private String chatroomName;
    private u eih;
    private a eje;
    private LinkedList<String> ejf = new LinkedList();
    private ListView mListView;
    private int scene;
    private p tipDialog;

    class b {
        public ImageView ejo;
        public TextView ejp;
        public TextView ejq;

        b() {
        }
    }

    class a extends BaseAdapter {
        List<ad> ejk = new LinkedList();

        a() {
            AppMethodBeat.i(104090);
            AppMethodBeat.o(104090);
        }

        public final void P(List<String> list) {
            AppMethodBeat.i(104091);
            if (list != null) {
                ab.i("MicroMsg.DelChatroomMemberAdapter", "initData members.size %d", Integer.valueOf(list.size()));
                this.ejk.clear();
                for (String str : list) {
                    ad aoO = ((j) g.K(j.class)).XM().aoO(str);
                    if (!(aoO == null || bo.isNullOrNil(aoO.field_username) || !aoO.field_username.equals(str))) {
                        this.ejk.add(aoO);
                    }
                }
            }
            AppMethodBeat.o(104091);
        }

        public final int getCount() {
            AppMethodBeat.i(104092);
            int size = this.ejk.size();
            AppMethodBeat.o(104092);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(104093);
            Object obj = this.ejk.get(i);
            AppMethodBeat.o(104093);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            AppMethodBeat.i(104094);
            if (view == null) {
                view = View.inflate(DelChatroomMemberUI.this, R.layout.ky, null);
                bVar = new b();
                bVar.ejo = (ImageView) view.findViewById(R.id.al5);
                bVar.ejp = (TextView) view.findViewById(R.id.al7);
                bVar.ejq = (TextView) view.findViewById(R.id.al6);
                bVar.ejq.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(104089);
                        final ad adVar = (ad) a.this.getItem(((Integer) view.getTag()).intValue());
                        h.a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.getString(R.string.ds1, new Object[]{a.this.c(adVar)}), null, DelChatroomMemberUI.this.getString(R.string.ds9), DelChatroomMemberUI.this.getString(R.string.or), true, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(104088);
                                DelChatroomMemberUI.a(DelChatroomMemberUI.this, adVar.field_username);
                                AppMethodBeat.o(104088);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(104089);
                    }
                });
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.ejq.setTag(Integer.valueOf(i));
            ad adVar = (ad) getItem(i);
            CharSequence c = c(adVar);
            bVar.ejp.setText(c);
            com.tencent.mm.pluginsdk.ui.e.j.b(DelChatroomMemberUI.this, c, bVar.ejp.getTextSize());
            com.tencent.mm.pluginsdk.ui.a.b.b(bVar.ejo, adVar.field_username);
            AppMethodBeat.o(104094);
            return view;
        }

        public final String c(ad adVar) {
            String b;
            AppMethodBeat.i(104095);
            if (bo.isNullOrNil(adVar.field_conRemark)) {
                b = DelChatroomMemberUI.b(DelChatroomMemberUI.this, adVar.field_username);
            } else {
                b = adVar.field_conRemark;
            }
            if (bo.isNullOrNil(b)) {
                b = adVar.field_conRemark;
            }
            if (bo.isNullOrNil(b)) {
                b = adVar.Oi();
            }
            AppMethodBeat.o(104095);
            return b;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public DelChatroomMemberUI() {
        AppMethodBeat.i(104096);
        AppMethodBeat.o(104096);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(104097);
        super.onCreate(bundle);
        this.chatroomName = getIntent().getStringExtra("RoomInfo_Id");
        this.scene = getIntent().getIntExtra("scene", 0);
        String[] split = getIntent().getStringExtra("members").split(",");
        int length = split.length;
        while (i < length) {
            this.ejf.add(split[i]);
            i++;
        }
        this.eih = ((c) g.K(c.class)).XV().oa(this.chatroomName);
        initView();
        AppMethodBeat.o(104097);
    }

    public void onDestroy() {
        AppMethodBeat.i(104098);
        super.onDestroy();
        AppMethodBeat.o(104098);
    }

    public void onResume() {
        AppMethodBeat.i(104099);
        super.onResume();
        AppMethodBeat.o(104099);
    }

    public final void initView() {
        AppMethodBeat.i(104100);
        setMMTitle((int) R.string.dsb);
        this.mListView = (ListView) findViewById(R.id.al8);
        this.eje = new a();
        this.eje.P(this.ejf);
        this.mListView.setAdapter(this.eje);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(104083);
                DelChatroomMemberUI.this.finish();
                AppMethodBeat.o(104083);
                return true;
            }
        });
        AppMethodBeat.o(104100);
    }

    public final int getLayoutId() {
        return R.layout.kz;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(104101);
        ab.i("MicroMsg.DelChatroomMemberUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(104101);
    }

    static /* synthetic */ void a(DelChatroomMemberUI delChatroomMemberUI, String str) {
        AppMethodBeat.i(104102);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(104102);
            return;
        }
        final List linkedList = new LinkedList();
        linkedList.add(str);
        final com.tencent.mm.roomsdk.a.c.a a = com.tencent.mm.roomsdk.a.b.alY(delChatroomMemberUI.chatroomName).a(delChatroomMemberUI.chatroomName, linkedList, delChatroomMemberUI.scene);
        a.b(new com.tencent.mm.roomsdk.a.b.b() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                Object obj;
                AppMethodBeat.i(104085);
                h.bQ(DelChatroomMemberUI.this, DelChatroomMemberUI.this.getString(R.string.ds_));
                a a = DelChatroomMemberUI.this.eje;
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
                DelChatroomMemberUI.this.mListView.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(104084);
                        if (DelChatroomMemberUI.this.eje.getCount() == 0) {
                            DelChatroomMemberUI.this.finish();
                        }
                        AppMethodBeat.o(104084);
                    }
                });
                AppMethodBeat.o(104085);
            }
        });
        a.c(new com.tencent.mm.roomsdk.a.b.b() {
            public final /* synthetic */ void a(int i, int i2, String str, com.tencent.mm.roomsdk.a.b.a aVar) {
                AppMethodBeat.i(104086);
                if (!(i == 0 && i2 == 0)) {
                    if (i2 == -2024) {
                        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
                        if (jY != null) {
                            jY.a(DelChatroomMemberUI.this, null, null);
                            AppMethodBeat.o(104086);
                            return;
                        }
                        h.a(DelChatroomMemberUI.this.mController.ylL, DelChatroomMemberUI.this.getString(R.string.ds7), null, DelChatroomMemberUI.this.getString(R.string.ds8), false, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        AppMethodBeat.o(104086);
                        return;
                    }
                    h.a(DelChatroomMemberUI.this, DelChatroomMemberUI.this.getString(R.string.dsf), null, DelChatroomMemberUI.this.getString(R.string.s6), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                AppMethodBeat.o(104086);
            }
        });
        delChatroomMemberUI.getString(R.string.tz);
        a.a(delChatroomMemberUI, delChatroomMemberUI.getString(R.string.drx), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(104087);
                a.cancel();
                AppMethodBeat.o(104087);
            }
        });
        AppMethodBeat.o(104102);
    }

    static /* synthetic */ String b(DelChatroomMemberUI delChatroomMemberUI, String str) {
        AppMethodBeat.i(104103);
        if (delChatroomMemberUI.eih == null) {
            AppMethodBeat.o(104103);
            return null;
        }
        String mJ = delChatroomMemberUI.eih.mJ(str);
        AppMethodBeat.o(104103);
        return mJ;
    }
}
