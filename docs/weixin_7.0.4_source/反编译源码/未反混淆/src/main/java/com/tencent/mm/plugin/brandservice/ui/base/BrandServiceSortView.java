package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.contact.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrandServiceSortView extends BaseSortView implements OnCreateContextMenuListener, OnItemLongClickListener, com.tencent.mm.plugin.brandservice.b.c.a, com.tencent.mm.ui.base.sortview.BaseSortView.a {
    private boolean aeV;
    private String igi;
    private boolean jLH;
    private int jLX = 0;
    private int jLY = 0;
    private HashMap<String, SpannableString> jML = new HashMap();
    private c jMM = new c();
    private int jMN = 251658241;
    private com.tencent.mm.ui.widget.b.a jMO;
    private boolean jMP = false;
    private ListView jMQ;
    private a jMR;
    private String jMS;
    private View jMT;
    private TextView jMU;
    private d jMV = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(14060);
            if (bo.isNullOrNil(BrandServiceSortView.this.igi)) {
                ab.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
                AppMethodBeat.o(14060);
                return;
            }
            if (menuItem.getItemId() == 0) {
                ab.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", Integer.valueOf(i));
                ad aoO = ((j) g.K(j.class)).XM().aoO(BrandServiceSortView.this.igi);
                BrandServiceSortView.a(BrandServiceSortView.this, f.qX(BrandServiceSortView.this.igi), BrandServiceSortView.this.getContext(), aoO, menuItem.getGroupId());
            }
            AppMethodBeat.o(14060);
        }
    };

    public interface a {
        boolean aWe();
    }

    public static class b {
        static Bitmap jMX = null;
        public View contentView;
        ImageView ejo;
        TextView ejp;
        public TextView jKK;
        ImageView jMg;
        View jMh;
        String username;
    }

    public BrandServiceSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(14062);
        setShowFooterView(false);
        refresh();
        c cVar = this.jMM;
        if (!cVar.jKu.contains(this)) {
            ab.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
            cVar.jKu.add(this);
        }
        this.jMO = new com.tencent.mm.ui.widget.b.a(getContext());
        setDataSetObserver(this);
        setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(14058);
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof b)) {
                    ab.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
                    AppMethodBeat.o(14058);
                    return;
                }
                b bVar = (b) tag;
                if (bo.isNullOrNil(bVar.username)) {
                    ab.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
                    AppMethodBeat.o(14058);
                    return;
                }
                ai.adO(bVar.username);
                y.q(BrandServiceSortView.this.jMS, 12, 4, i - 1);
                if (BrandServiceSortView.this.jLH) {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Contact", bVar.username);
                    intent.putExtra("Select_Conv_User", bVar.username);
                    if (BrandServiceSortView.this.getContext() instanceof Activity) {
                        Activity activity = (Activity) BrandServiceSortView.this.getContext();
                        activity.setResult(-1, intent);
                        activity.finish();
                        AppMethodBeat.o(14058);
                        return;
                    }
                }
                String str = bVar.username;
                Context context = BrandServiceSortView.this.getContext();
                ab.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                Intent putExtra = new Intent().putExtra("Chat_User", str);
                putExtra.putExtra("finish_direct", true);
                putExtra.putExtra("chat_from_scene", 2);
                putExtra.putExtra("specific_chat_from_scene", 4);
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                com.tencent.mm.plugin.brandservice.b.gkE.d(putExtra, context);
                AppMethodBeat.o(14058);
            }
        });
        setOnItemLongClickListener(this);
        AppMethodBeat.o(14062);
    }

    public void setReturnResult(boolean z) {
        this.jLH = z;
    }

    public final void refresh() {
        AppMethodBeat.i(14063);
        this.jMM.init();
        dJ(aV(this.jMM.rY(this.jMN)));
        super.refresh();
        AppMethodBeat.o(14063);
    }

    private static List<com.tencent.mm.ui.base.sortview.d> aV(List<lk> list) {
        AppMethodBeat.i(14064);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    lk lkVar = (lk) list.get(i2);
                    if (!(lkVar == null || lkVar.ehM == null)) {
                        com.tencent.mm.ui.base.sortview.d dVar = new com.tencent.mm.ui.base.sortview.d();
                        dVar.data = lkVar;
                        i = lkVar.ehM.field_showHead;
                        if (i >= 97 && i <= 122) {
                            i -= 32;
                        }
                        if (i < 65 || i > 90) {
                            dVar.yDG = "#";
                        } else {
                            dVar.yDG = ((char) i);
                        }
                        arrayList.add(dVar);
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(14064);
                    return arrayList;
                }
            }
        }
        AppMethodBeat.o(14064);
        return null;
    }

    public final void release() {
        AppMethodBeat.i(14065);
        if (g.RK()) {
            z.afb().aeL();
        }
        this.jMM.release();
        AppMethodBeat.o(14065);
    }

    public final boolean a(String str, com.tencent.mm.ui.base.sortview.d dVar) {
        AppMethodBeat.i(14066);
        if (!(bo.isNullOrNil(str) || dVar == null)) {
            this.jMS = str;
            lk lkVar = (lk) dVar.data;
            if (lkVar == null || lkVar.ehM == null) {
                ab.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
                AppMethodBeat.o(14066);
                return false;
            }
            ad adVar = lkVar.ehM;
            String Oj = adVar.Oj();
            String Ht = adVar.Ht();
            String Hu = adVar.Hu();
            String toUpperCase = str.toUpperCase();
            if (!(bo.isNullOrNil(Oj) || Oj.toUpperCase().indexOf(toUpperCase) == -1) || (!(bo.isNullOrNil(Ht) || Ht.toUpperCase().indexOf(toUpperCase) == -1) || (!bo.isNullOrNil(Hu) && Hu.toUpperCase().startsWith(toUpperCase)))) {
                AppMethodBeat.o(14066);
                return true;
            }
        }
        AppMethodBeat.o(14066);
        return false;
    }

    public final View inflate() {
        AppMethodBeat.i(14067);
        View inflate = View.inflate(getContext(), R.layout.hp, this);
        AppMethodBeat.o(14067);
        return inflate;
    }

    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(14068);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(R.id.a47);
        AppMethodBeat.o(14068);
        return verticalScrollBar;
    }

    public ListView getListView() {
        AppMethodBeat.i(14069);
        this.jMQ = (ListView) findViewById(R.id.a46);
        if (this.jMT == null) {
            this.jMT = inflate(getContext(), R.layout.rc, null);
            if (!(this.jMQ == null || this.jMT == null)) {
                this.jMU = (TextView) this.jMT.findViewById(R.id.b6n);
                this.jMQ.addFooterView(this.jMT, null, false);
            }
        }
        ListView listView = this.jMQ;
        AppMethodBeat.o(14069);
        return listView;
    }

    public View getNoResultView() {
        AppMethodBeat.i(14070);
        View findViewById = findViewById(R.id.a9r);
        AppMethodBeat.o(14070);
        return findViewById;
    }

    public com.tencent.mm.ui.base.sortview.c.a getItemViewCreator() {
        AppMethodBeat.i(14071);
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.ui.base.sortview.c.a() {
            public final View a(com.tencent.mm.ui.base.sortview.d dVar, View view, int i, boolean z, boolean z2) {
                b bVar;
                AppMethodBeat.i(14059);
                long yz = bo.yz();
                Context context = BrandServiceSortView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.hn, null);
                    bVar = new b();
                    bVar.jKK = (TextView) view.findViewById(R.id.a42);
                    bVar.contentView = view.findViewById(R.id.a43);
                    bVar.ejo = (ImageView) view.findViewById(R.id.a9k);
                    bVar.jMg = (ImageView) view.findViewById(R.id.a9n);
                    bVar.ejp = (TextView) view.findViewById(R.id.a9m);
                    bVar.jMh = view.findViewById(R.id.a9j);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                lk lkVar = (lk) dVar.data;
                if (lkVar == null) {
                    ab.e("MicroMsg.BrandServiceSortView", "should not be empty");
                    AppMethodBeat.o(14059);
                } else {
                    if (BrandServiceSortView.this.yDy && z) {
                        bVar.jKK.setText(dVar.yDG);
                        bVar.jKK.setVisibility(0);
                    } else {
                        bVar.jKK.setVisibility(8);
                    }
                    bVar.username = lkVar.userName;
                    bVar.ejo.setTag(lkVar.userName);
                    com.tencent.mm.pluginsdk.ui.a.b.r(bVar.ejo, bVar.username);
                    BrandServiceSortView.a(BrandServiceSortView.this, bVar.ejp, context, lkVar.ehM.Oj(), (int) bVar.ejp.getTextSize());
                    ab.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", Integer.valueOf(lkVar.pkW.field_status));
                    ImageView imageView = bVar.jMg;
                    int i2 = (BrandServiceSortView.this.jMP && lkVar.pkW.field_status == 1) ? 0 : 8;
                    imageView.setVisibility(i2);
                    if (BrandServiceSortView.this.getMode() == 0 && z2) {
                        bVar.jMh.setBackgroundResource(R.drawable.k7);
                    } else {
                        bVar.jMh.setBackgroundResource(R.drawable.a_q);
                    }
                    if (BrandServiceSortView.this.yDz) {
                        bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) BrandServiceSortView.this.getContext().getResources().getDimension(R.dimen.dm), bVar.contentView.getPaddingBottom());
                    } else {
                        bVar.contentView.setPadding(bVar.contentView.getPaddingLeft(), bVar.contentView.getPaddingTop(), (int) BrandServiceSortView.this.getContext().getResources().getDimension(R.dimen.m4), bVar.contentView.getPaddingBottom());
                    }
                    ab.v("MicroMsg.BrandServiceSortView", "get view use %d ms", Long.valueOf(bo.az(yz)));
                    AppMethodBeat.o(14059);
                }
                return view;
            }
        };
        AppMethodBeat.o(14071);
        return anonymousClass2;
    }

    public final void aVU() {
        AppMethodBeat.i(14072);
        refresh();
        AppMethodBeat.o(14072);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(14073);
        if (motionEvent.getAction() == 0) {
            this.jLX = (int) motionEvent.getRawX();
            this.jLY = (int) motionEvent.getRawY();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(14073);
        return dispatchTouchEvent;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.i(14074);
        this.jMO.zRY = view;
        this.jMO.a(adapterView, i, j, this, this.jMV, this.jLX, this.jLY);
        AppMethodBeat.o(14074);
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(14075);
        if (contextMenuInfo == null) {
            ab.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
            AppMethodBeat.o(14075);
            return;
        }
        ab.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        com.tencent.mm.ui.base.sortview.d dVar = (com.tencent.mm.ui.base.sortview.d) ((AdapterView) view).getItemAtPosition(adapterContextMenuInfo.position);
        if (dVar == null || dVar.data == null) {
            ab.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", dVar);
            AppMethodBeat.o(14075);
            return;
        }
        ad adVar = ((lk) dVar.data).ehM;
        if (adVar == null) {
            ab.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
            AppMethodBeat.o(14075);
            return;
        }
        this.igi = adVar.field_username;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.e.j.b(getContext(), adVar.Oj()));
        com.tencent.mm.aj.d qX = f.qX(adVar.field_username);
        if (!(qX == null || qX.adO())) {
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.string.cvi);
        }
        AppMethodBeat.o(14075);
    }

    public final void aW(List<com.tencent.mm.ui.base.sortview.d> list) {
        AppMethodBeat.i(14076);
        if (!(this.jMU == null || list == null)) {
            this.jMU.setText(getContext().getString(R.string.ab7, new Object[]{Integer.valueOf(list.size())}));
        }
        AppMethodBeat.o(14076);
    }

    public void setShowFooterView(boolean z) {
        AppMethodBeat.i(14077);
        this.aeV = z;
        BaseSortView.x(this.jMU, z);
        AppMethodBeat.o(14077);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(14078);
        if (this.jMR != null) {
            this.jMR.aWe();
        }
        if (super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.o(14078);
            return true;
        }
        AppMethodBeat.o(14078);
        return false;
    }

    public a getITransferToChildOnTouchListener() {
        return this.jMR;
    }

    public void setITransferToChildOnTouchListener(a aVar) {
        this.jMR = aVar;
    }
}
