package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bbo;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView extends BaseSortView {
    private ListView gGW;
    private String jLN;
    private boolean jLT;
    private int jLU = -1;
    private b jLV;
    private a jLW;
    private int jLX = 0;
    private int jLY = 0;

    public static class c {
        public View contentView;
        ImageView ejo;
        TextView ejp;
        String iconUrl;
        public TextView jKK;
        ImageView jMg;
        View jMh;
        String username;
    }

    class d implements Comparator<com.tencent.mm.ui.base.sortview.d> {
        private d() {
        }

        /* synthetic */ d(EnterpriseBizContactListView enterpriseBizContactListView, byte b) {
            this();
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            int i;
            AppMethodBeat.i(13965);
            com.tencent.mm.ui.base.sortview.d dVar = (com.tencent.mm.ui.base.sortview.d) obj;
            com.tencent.mm.ui.base.sortview.d dVar2 = (com.tencent.mm.ui.base.sortview.d) obj2;
            String str = dVar.yDG;
            String str2 = dVar2.yDG;
            if (str == null || str2 == null) {
                i = 0;
            } else {
                i = str.compareToIgnoreCase(str2);
            }
            if (i != 0) {
                if (str.equalsIgnoreCase("#")) {
                    i = 1;
                }
                if (str2.equalsIgnoreCase("#")) {
                    i = -1;
                }
                AppMethodBeat.o(13965);
                return i;
            }
            int i2;
            lk lkVar = (lk) dVar.data;
            lk lkVar2 = (lk) dVar2.data;
            if (!(str == null || str2 == null || (!str.equalsIgnoreCase("!2") && !str.equalsIgnoreCase("!1")))) {
                Object obj3;
                int Ny = lkVar.ehM.Ny();
                int Ny2 = lkVar2.ehM.Ny();
                if ((Ny < 97 || Ny > 122) && (Ny < 65 || Ny > 90)) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                Object obj4;
                if ((Ny2 < 97 || Ny2 > 122) && (Ny2 < 65 || Ny2 > 90)) {
                    obj4 = 1;
                } else {
                    obj4 = null;
                }
                if (obj3 != null && obj4 == null) {
                    AppMethodBeat.o(13965);
                    return 1;
                } else if (obj3 == null && obj4 != null) {
                    AppMethodBeat.o(13965);
                    return -1;
                }
            }
            if (lkVar.ehM == null || lkVar.ehM.Hu() == null || lkVar.ehM.Hu().length() <= 0 || lkVar2.ehM == null || lkVar2.ehM.Hu() == null || lkVar2.ehM.Hu().length() <= 0) {
                i2 = 0;
            } else {
                i2 = lkVar.ehM.Hu().compareToIgnoreCase(lkVar2.ehM.Hu());
            }
            if (i2 != 0) {
                AppMethodBeat.o(13965);
                return i2;
            }
            if (lkVar.ehM == null || lkVar.ehM.field_nickname == null || lkVar.ehM.field_nickname.length() <= 0 || lkVar2.ehM == null || lkVar2.ehM.field_nickname == null || lkVar2.ehM.field_nickname.length() <= 0) {
                i2 = 0;
            } else {
                i2 = lkVar.ehM.field_nickname.compareToIgnoreCase(lkVar2.ehM.field_nickname);
            }
            if (i2 != 0) {
                AppMethodBeat.o(13965);
                return i2;
            }
            if (lkVar.ehM == null || lkVar.ehM.field_username == null || lkVar.ehM.field_username.length() <= 0 || lkVar2.ehM == null || lkVar2.ehM.field_username == null || lkVar2.ehM.field_username.length() <= 0) {
                i = 0;
            } else {
                i = lkVar.ehM.field_username.compareToIgnoreCase(lkVar2.ehM.field_username);
            }
            if (i != 0) {
                AppMethodBeat.o(13965);
                return i;
            }
            AppMethodBeat.o(13965);
            return 0;
        }
    }

    public interface b {
        boolean aWe();
    }

    static class a implements f {
        public String jMa;
        com.tencent.mm.ui.widget.f jMb;
        WeakReference<EnterpriseBizContactListView> jMc;
        p tipDialog;

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a$3 */
        class AnonymousClass3 implements OnClickListener {
            final /* synthetic */ String ewn;
            final /* synthetic */ Context val$context;

            AnonymousClass3(String str, Context context) {
                this.ewn = str;
                this.val$context = context;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(13961);
                final m dVar = new com.tencent.mm.plugin.profile.b.d(this.ewn, true);
                g.Rg().a(1394, a.this);
                g.Rg().a(dVar, 0);
                a aVar = a.this;
                Context context = this.val$context;
                this.val$context.getString(R.string.tz);
                aVar.tipDialog = h.b(context, this.val$context.getString(R.string.un), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(13960);
                        g.Rg().c(dVar);
                        g.Rg().b(1394, a.this);
                        AppMethodBeat.o(13960);
                    }
                });
                AppMethodBeat.o(13961);
            }
        }

        /* renamed from: com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView$a$1 */
        class AnonymousClass1 implements OnCreateContextMenuListener {
            final /* synthetic */ int sN;

            AnonymousClass1(int i) {
                this.sN = i;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(13958);
                contextMenu.add(this.sN, 1, 0, R.string.bdu);
                AppMethodBeat.o(13958);
            }
        }

        public a(EnterpriseBizContactListView enterpriseBizContactListView) {
            AppMethodBeat.i(13962);
            this.jMc = new WeakReference(enterpriseBizContactListView);
            AppMethodBeat.o(13962);
        }

        /* Access modifiers changed, original: protected|final */
        public final void finalize() {
            AppMethodBeat.i(13963);
            g.Rg().b(1394, (f) this);
            super.finalize();
            AppMethodBeat.o(13963);
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(13964);
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (i == 0 && i2 == 0) {
                if (mVar.getType() == 1394) {
                    cfr caz = ((com.tencent.mm.plugin.profile.b.d) mVar).caz();
                    cfs cay = ((com.tencent.mm.plugin.profile.b.d) mVar).cay();
                    if (cay == null || cay.vNh == null || cay.vNh.ret != 0) {
                        if (cay == null || cay.vNh == null) {
                            ab.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(mVar.getType()));
                            AppMethodBeat.o(13964);
                            return;
                        }
                        ab.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(mVar.getType()), Integer.valueOf(cay.vNh.ret));
                        AppMethodBeat.o(13964);
                        return;
                    } else if (caz.xeS) {
                        com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(caz.vNb);
                        qX.field_brandFlag |= 1;
                        bbo bbo = new bbo();
                        bbo.gvb = qX.field_brandFlag;
                        bbo.jBB = caz.vNb;
                        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(47, bbo));
                        z.aeR().c(qX, new String[0]);
                        ((j) g.K(j.class)).XR().aoX(qX.field_username);
                        if (((j) g.K(j.class)).XR().apl(qX.field_enterpriseFather) <= 0) {
                            ((j) g.K(j.class)).XR().aoX(qX.field_enterpriseFather);
                        } else {
                            ((o) g.K(o.class)).XQ().aoj(qX.field_enterpriseFather);
                        }
                        EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) this.jMc.get();
                        if (enterpriseBizContactListView == null) {
                            AppMethodBeat.o(13964);
                            return;
                        }
                        enterpriseBizContactListView.refresh();
                    } else {
                        AppMethodBeat.o(13964);
                        return;
                    }
                }
                AppMethodBeat.o(13964);
                return;
            }
            AppMethodBeat.o(13964);
        }
    }

    public EnterpriseBizContactListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setFatherBizName(String str) {
        this.jLN = str;
    }

    public void setExcludeBizChat(boolean z) {
        this.jLT = z;
    }

    public final void refresh() {
        AppMethodBeat.i(13966);
        dJ(getSortEntityList());
        super.refresh();
        AppMethodBeat.o(13966);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(13967);
        if (motionEvent.getAction() == 0) {
            this.jLX = (int) motionEvent.getRawX();
            this.jLY = (int) motionEvent.getRawY();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(13967);
        return dispatchTouchEvent;
    }

    public final void aWg() {
        AppMethodBeat.i(13968);
        setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(13955);
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof c)) {
                    AppMethodBeat.o(13955);
                    return;
                }
                c cVar = (c) tag;
                if (bo.isNullOrNil(cVar.username)) {
                    AppMethodBeat.o(13955);
                    return;
                }
                boolean rd = com.tencent.mm.aj.f.rd(cVar.username);
                boolean kq = com.tencent.mm.aj.f.kq(cVar.username);
                com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(cVar.username);
                String adT = qX == null ? null : qX.adT();
                if (adT == null) {
                    adT = "";
                }
                Intent intent;
                if (rd) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", adT);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", cVar.username);
                    intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                    intent2.addFlags(67108864);
                    com.tencent.mm.bp.d.b(EnterpriseBizContactListView.this.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, qX, 2);
                    AppMethodBeat.o(13955);
                } else if (kq) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", cVar.username);
                    intent.addFlags(67108864);
                    intent.putExtra("biz_chat_from_scene", 3);
                    com.tencent.mm.bp.d.f(EnterpriseBizContactListView.this.getContext(), ".ui.bizchat.BizChatConversationUI", intent);
                    AppMethodBeat.o(13955);
                } else {
                    intent = new Intent();
                    intent.addFlags(67108864);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("Chat_User", cVar.username);
                    intent.putExtra("chat_from_scene", 2);
                    Context context = EnterpriseBizContactListView.this.getContext();
                    ab.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                    com.tencent.mm.plugin.brandservice.b.gkE.d(intent, context);
                    EnterpriseBizContactListView.a(EnterpriseBizContactListView.this, qX, 1);
                    AppMethodBeat.o(13955);
                }
            }
        });
        if (getMode() == 0) {
            setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(13956);
                    if (EnterpriseBizContactListView.this.jLW == null) {
                        EnterpriseBizContactListView.this.jLW = new a(EnterpriseBizContactListView.this);
                    }
                    a a = EnterpriseBizContactListView.this.jLW;
                    int b = EnterpriseBizContactListView.this.jLX;
                    int c = EnterpriseBizContactListView.this.jLY;
                    if (a.jMb == null) {
                        EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) a.jMc.get();
                        if (enterpriseBizContactListView == null) {
                            AppMethodBeat.o(13956);
                            return false;
                        }
                        a.jMb = new com.tencent.mm.ui.widget.f(enterpriseBizContactListView.getContext());
                    }
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        AppMethodBeat.o(13956);
                        return false;
                    }
                    a.jMa = ((c) tag).username;
                    if (bo.isNullOrNil(a.jMa) || com.tencent.mm.aj.f.kq(a.jMa)) {
                        AppMethodBeat.o(13956);
                        return false;
                    }
                    a.jMb.zRY = view;
                    a.jMb.a(adapterView, i, j, new AnonymousClass1(i), new com.tencent.mm.ui.base.n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(13959);
                            if (bo.isNullOrNil(a.this.jMa)) {
                                AppMethodBeat.o(13959);
                                return;
                            }
                            if (menuItem.getItemId() == 1) {
                                a aVar = a.this;
                                String str = a.this.jMa;
                                EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) aVar.jMc.get();
                                if (enterpriseBizContactListView != null) {
                                    Context context = enterpriseBizContactListView.getContext();
                                    h.d(context, context.getString(R.string.bdm), "", context.getString(R.string.bdl), context.getString(R.string.or), new AnonymousClass3(str, context), null);
                                }
                            }
                            AppMethodBeat.o(13959);
                        }
                    }, b, c);
                    AppMethodBeat.o(13956);
                    return true;
                }
            });
        }
        AppMethodBeat.o(13968);
    }

    public int getContactCount() {
        return this.jLU;
    }

    private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList() {
        AppMethodBeat.i(13969);
        ArrayList arrayList = new ArrayList();
        z.aeR();
        Cursor F = e.F(this.jLN, this.jLT);
        while (F.moveToNext()) {
            lk lkVar = new lk();
            if (F != null) {
                ad adVar = new ad();
                adVar.d(F);
                com.tencent.mm.aj.d dVar = new com.tencent.mm.aj.d();
                dVar.d(F);
                lkVar.userName = adVar.field_username;
                lkVar.ehM = adVar;
                lkVar.pkW = dVar;
            }
            if (lkVar.ehM != null) {
                com.tencent.mm.ui.base.sortview.d dVar2 = new com.tencent.mm.ui.base.sortview.d();
                dVar2.data = lkVar;
                if (lkVar.pkW.adR()) {
                    dVar2.yDG = "!1";
                } else if (lkVar.ehM.Oe()) {
                    dVar2.yDG = "!2";
                } else {
                    int Ny = lkVar.ehM.Ny();
                    if (Ny >= 97 && Ny <= 122) {
                        Ny -= 32;
                    }
                    if (Ny < 65 || Ny > 90) {
                        dVar2.yDG = "#";
                    } else {
                        dVar2.yDG = ((char) Ny);
                    }
                }
                arrayList.add(dVar2);
            }
        }
        F.close();
        this.jLU = arrayList.size();
        Collections.sort(arrayList, new d(this, (byte) 0));
        AppMethodBeat.o(13969);
        return arrayList;
    }

    public static void release() {
        AppMethodBeat.i(13970);
        z.afb().aeL();
        AppMethodBeat.o(13970);
    }

    public final boolean a(String str, com.tencent.mm.ui.base.sortview.d dVar) {
        AppMethodBeat.i(13971);
        if (!(bo.isNullOrNil(str) || dVar == null)) {
            lk lkVar = (lk) dVar.data;
            if (lkVar == null) {
                AppMethodBeat.o(13971);
                return false;
            }
            String Oj = lkVar.ehM.Oj();
            String Ht = lkVar.ehM.Ht();
            String Hu = lkVar.ehM.Hu();
            String toUpperCase = str.toUpperCase();
            if (!(bo.isNullOrNil(Oj) || Oj.toUpperCase().indexOf(toUpperCase) == -1) || (!(bo.isNullOrNil(Ht) || Ht.toUpperCase().indexOf(toUpperCase) == -1) || (!bo.isNullOrNil(Hu) && Hu.toUpperCase().startsWith(toUpperCase)))) {
                AppMethodBeat.o(13971);
                return true;
            }
        }
        AppMethodBeat.o(13971);
        return false;
    }

    public final View inflate() {
        AppMethodBeat.i(13972);
        View inflate = View.inflate(getContext(), R.layout.vg, this);
        AppMethodBeat.o(13972);
        return inflate;
    }

    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.i(13973);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(R.id.a47);
        AppMethodBeat.o(13973);
        return verticalScrollBar;
    }

    public ListView getListView() {
        AppMethodBeat.i(13974);
        this.gGW = (ListView) findViewById(R.id.a46);
        ListView listView = this.gGW;
        AppMethodBeat.o(13974);
        return listView;
    }

    public View getNoResultView() {
        AppMethodBeat.i(13975);
        TextView textView = (TextView) findViewById(R.id.a9r);
        textView.setText(R.string.bdv);
        AppMethodBeat.o(13975);
        return textView;
    }

    public com.tencent.mm.ui.base.sortview.c.a getItemViewCreator() {
        AppMethodBeat.i(13976);
        AnonymousClass3 anonymousClass3 = new com.tencent.mm.ui.base.sortview.c.a() {
            /* JADX WARNING: Removed duplicated region for block: B:34:0x0182  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x00b7  */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x01ae  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x00fc  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x01bc  */
            /* JADX WARNING: Removed duplicated region for block: B:28:0x0118  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final View a(com.tencent.mm.ui.base.sortview.d dVar, View view, int i, boolean z, boolean z2) {
                c cVar;
                AppMethodBeat.i(13957);
                long yz = bo.yz();
                Context context = EnterpriseBizContactListView.this.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.layout.vd, null);
                    cVar = new c();
                    cVar.jKK = (TextView) view.findViewById(R.id.a42);
                    cVar.contentView = view.findViewById(R.id.a43);
                    cVar.ejo = (ImageView) view.findViewById(R.id.a9k);
                    cVar.jMg = (ImageView) view.findViewById(R.id.a9n);
                    cVar.ejp = (TextView) view.findViewById(R.id.a9m);
                    cVar.jMh = view.findViewById(R.id.a9j);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                lk lkVar = (lk) dVar.data;
                if (lkVar == null) {
                    ab.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
                    AppMethodBeat.o(13957);
                } else {
                    Object obj = null;
                    if (lkVar.pkW.adR()) {
                        obj = 1;
                    }
                    if (EnterpriseBizContactListView.this.yDy && z) {
                        if (dVar.yDG.equals("!2")) {
                            cVar.jKK.setText(EnterpriseBizContactListView.this.getContext().getString(R.string.be1));
                            cVar.jKK.setVisibility(0);
                        } else if (!dVar.yDG.equals("!1")) {
                            cVar.jKK.setText(dVar.yDG);
                            cVar.jKK.setVisibility(0);
                        }
                        if (obj == null) {
                            cVar.username = lkVar.userName;
                            cVar.ejo.setImageResource(R.raw.enterprise_chat_entry_avatar);
                            EnterpriseBizContactListView.a(cVar.ejp, context, EnterpriseBizContactListView.this.getResources().getString(R.string.bdi), (int) cVar.ejp.getTextSize());
                        } else {
                            cVar.username = lkVar.userName;
                            cVar.iconUrl = lkVar.pkW.field_brandIconURL;
                            cVar.ejo.setTag(lkVar.userName);
                            com.tencent.mm.pluginsdk.ui.a.b.b(cVar.ejo, cVar.username);
                            EnterpriseBizContactListView.a(cVar.ejp, context, lkVar.ehM.Oj(), (int) cVar.ejp.getTextSize());
                        }
                        ab.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", Integer.valueOf(lkVar.pkW.field_status));
                        cVar.jMg.setVisibility(lkVar.pkW.field_status != 1 ? 0 : 8);
                        if (EnterpriseBizContactListView.this.getMode() == 0 || !z2) {
                            cVar.jMh.setBackgroundResource(R.drawable.a_q);
                        } else {
                            cVar.jMh.setBackgroundResource(R.drawable.k7);
                        }
                        if (EnterpriseBizContactListView.this.yDz) {
                            cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) EnterpriseBizContactListView.this.getContext().getResources().getDimension(R.dimen.m4), cVar.contentView.getPaddingBottom());
                        } else {
                            cVar.contentView.setPadding(cVar.contentView.getPaddingLeft(), cVar.contentView.getPaddingTop(), (int) EnterpriseBizContactListView.this.getContext().getResources().getDimension(R.dimen.dm), cVar.contentView.getPaddingBottom());
                        }
                        ab.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", Long.valueOf(bo.az(yz)));
                        AppMethodBeat.o(13957);
                    }
                    cVar.jKK.setVisibility(8);
                    if (obj == null) {
                    }
                    ab.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", Integer.valueOf(lkVar.pkW.field_status));
                    if (lkVar.pkW.field_status != 1) {
                    }
                    cVar.jMg.setVisibility(lkVar.pkW.field_status != 1 ? 0 : 8);
                    if (EnterpriseBizContactListView.this.getMode() == 0) {
                    }
                    cVar.jMh.setBackgroundResource(R.drawable.a_q);
                    if (EnterpriseBizContactListView.this.yDz) {
                    }
                    ab.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", Long.valueOf(bo.az(yz)));
                    AppMethodBeat.o(13957);
                }
                return view;
            }
        };
        AppMethodBeat.o(13976);
        return anonymousClass3;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(13977);
        if (this.jLV != null) {
            this.jLV.aWe();
        }
        if (super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.o(13977);
            return true;
        }
        AppMethodBeat.o(13977);
        return false;
    }

    public void setOnTouchListener(b bVar) {
        this.jLV = bVar;
    }

    static /* synthetic */ void a(EnterpriseBizContactListView enterpriseBizContactListView, com.tencent.mm.aj.d dVar, int i) {
        AppMethodBeat.i(13978);
        com.tencent.mm.aj.b qC = z.afa().qC(enterpriseBizContactListView.jLN);
        long j = qC != null ? qC.field_wwCorpId : 0;
        long j2 = qC != null ? qC.field_wwUserVid : 0;
        long adU = dVar.adU();
        com.tencent.mm.plugin.report.service.h.pYm.e(14507, Long.valueOf(j), Long.valueOf(adU), Long.valueOf(j2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i));
        ab.d("MicroMsg.BrandService.EnterpriseBizContactListView", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", Long.valueOf(j), Long.valueOf(adU), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i));
        AppMethodBeat.o(13978);
    }

    static /* synthetic */ void a(TextView textView, Context context, String str, int i) {
        AppMethodBeat.i(13979);
        if (textView == null) {
            AppMethodBeat.o(13979);
            return;
        }
        if (!bo.isNullOrNil(str)) {
            try {
                textView.setText(new SpannableString(com.tencent.mm.pluginsdk.ui.e.j.b(context, (CharSequence) str, i)));
                AppMethodBeat.o(13979);
                return;
            } catch (Exception e) {
                textView.setText("");
            }
        }
        AppMethodBeat.o(13979);
    }
}
