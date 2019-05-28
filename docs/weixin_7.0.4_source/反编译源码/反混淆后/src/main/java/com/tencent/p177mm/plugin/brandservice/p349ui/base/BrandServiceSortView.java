package com.tencent.p177mm.plugin.brandservice.p349ui.base;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.VerticalScrollBar;
import com.tencent.p177mm.p612ui.base.sortview.BaseSortView;
import com.tencent.p177mm.p612ui.base.sortview.BaseSortView.C36081a;
import com.tencent.p177mm.p612ui.base.sortview.C36085c.C15543a;
import com.tencent.p177mm.p612ui.base.sortview.C36087d;
import com.tencent.p177mm.p612ui.contact.C30670y;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p926b.C42792c;
import com.tencent.p177mm.plugin.brandservice.p926b.C42792c.C27511a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.websearch.api.C35573ai;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C30201lk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView */
public class BrandServiceSortView extends BaseSortView implements OnCreateContextMenuListener, OnItemLongClickListener, C27511a, C36081a {
    private boolean aeV;
    private String igi;
    private boolean jLH;
    private int jLX = 0;
    private int jLY = 0;
    private HashMap<String, SpannableString> jML = new HashMap();
    private C42792c jMM = new C42792c();
    private int jMN = 251658241;
    private C24088a jMO;
    private boolean jMP = false;
    private ListView jMQ;
    private C11206a jMR;
    private String jMS;
    private View jMT;
    private TextView jMU;
    private C5279d jMV = new C112043();

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView$1 */
    class C112021 implements OnItemClickListener {
        C112021() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(14058);
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof C11207b)) {
                C4990ab.m7420w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
                AppMethodBeat.m2505o(14058);
                return;
            }
            C11207b c11207b = (C11207b) tag;
            if (C5046bo.isNullOrNil(c11207b.username)) {
                C4990ab.m7420w("MicroMsg.BrandServiceSortView", "username is null or nil.");
                AppMethodBeat.m2505o(14058);
                return;
            }
            C35573ai.adO(c11207b.username);
            C30670y.m48901q(BrandServiceSortView.this.jMS, 12, 4, i - 1);
            if (BrandServiceSortView.this.jLH) {
                Intent intent = new Intent();
                intent.putExtra("Select_Contact", c11207b.username);
                intent.putExtra("Select_Conv_User", c11207b.username);
                if (BrandServiceSortView.this.getContext() instanceof Activity) {
                    Activity activity = (Activity) BrandServiceSortView.this.getContext();
                    activity.setResult(-1, intent);
                    activity.finish();
                    AppMethodBeat.m2505o(14058);
                    return;
                }
            }
            String str = c11207b.username;
            Context context = BrandServiceSortView.this.getContext();
            C4990ab.m7416i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
            Intent putExtra = new Intent().putExtra("Chat_User", str);
            putExtra.putExtra("finish_direct", true);
            putExtra.putExtra("chat_from_scene", 2);
            putExtra.putExtra("specific_chat_from_scene", 4);
            putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
            C33720b.gkE.mo38915d(putExtra, context);
            AppMethodBeat.m2505o(14058);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView$2 */
    class C112032 implements C15543a {
        C112032() {
        }

        /* renamed from: a */
        public final View mo22902a(C36087d c36087d, View view, int i, boolean z, boolean z2) {
            C11207b c11207b;
            AppMethodBeat.m2504i(14059);
            long yz = C5046bo.m7588yz();
            Context context = BrandServiceSortView.this.getContext();
            if (view == null) {
                view = LayoutInflater.from(context).inflate(2130968885, null);
                c11207b = new C11207b();
                c11207b.jKK = (TextView) view.findViewById(2131821694);
                c11207b.contentView = view.findViewById(2131821695);
                c11207b.ejo = (ImageView) view.findViewById(2131821898);
                c11207b.jMg = (ImageView) view.findViewById(2131821901);
                c11207b.ejp = (TextView) view.findViewById(2131821900);
                c11207b.jMh = view.findViewById(2131821897);
                view.setTag(c11207b);
            } else {
                c11207b = (C11207b) view.getTag();
            }
            C30201lk c30201lk = (C30201lk) c36087d.data;
            if (c30201lk == null) {
                C4990ab.m7412e("MicroMsg.BrandServiceSortView", "should not be empty");
                AppMethodBeat.m2505o(14059);
            } else {
                if (BrandServiceSortView.this.yDy && z) {
                    c11207b.jKK.setText(c36087d.yDG);
                    c11207b.jKK.setVisibility(0);
                } else {
                    c11207b.jKK.setVisibility(8);
                }
                c11207b.username = c30201lk.userName;
                c11207b.ejo.setTag(c30201lk.userName);
                C40460b.m69437r(c11207b.ejo, c11207b.username);
                BrandServiceSortView.m18912a(BrandServiceSortView.this, c11207b.ejp, context, c30201lk.ehM.mo16707Oj(), (int) c11207b.ejp.getTextSize());
                C4990ab.m7419v("MicroMsg.BrandServiceSortView", "bizinfo status%d", Integer.valueOf(c30201lk.pkW.field_status));
                ImageView imageView = c11207b.jMg;
                int i2 = (BrandServiceSortView.this.jMP && c30201lk.pkW.field_status == 1) ? 0 : 8;
                imageView.setVisibility(i2);
                if (BrandServiceSortView.this.getMode() == 0 && z2) {
                    c11207b.jMh.setBackgroundResource(C25738R.drawable.f6625k7);
                } else {
                    c11207b.jMh.setBackgroundResource(C25738R.drawable.a_q);
                }
                if (BrandServiceSortView.this.yDz) {
                    c11207b.contentView.setPadding(c11207b.contentView.getPaddingLeft(), c11207b.contentView.getPaddingTop(), (int) BrandServiceSortView.this.getContext().getResources().getDimension(C25738R.dimen.f9721dm), c11207b.contentView.getPaddingBottom());
                } else {
                    c11207b.contentView.setPadding(c11207b.contentView.getPaddingLeft(), c11207b.contentView.getPaddingTop(), (int) BrandServiceSortView.this.getContext().getResources().getDimension(C25738R.dimen.f9979m4), c11207b.contentView.getPaddingBottom());
                }
                C4990ab.m7419v("MicroMsg.BrandServiceSortView", "get view use %d ms", Long.valueOf(C5046bo.m7525az(yz)));
                AppMethodBeat.m2505o(14059);
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView$3 */
    class C112043 implements C5279d {
        C112043() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(14060);
            if (C5046bo.isNullOrNil(BrandServiceSortView.this.igi)) {
                C4990ab.m7416i("MicroMsg.BrandServiceSortView", "username is null or nil.");
                AppMethodBeat.m2505o(14060);
                return;
            }
            if (menuItem.getItemId() == 0) {
                C4990ab.m7417i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", Integer.valueOf(i));
                C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(BrandServiceSortView.this.igi);
                BrandServiceSortView.m18913a(BrandServiceSortView.this, C17903f.m28104qX(BrandServiceSortView.this.igi), BrandServiceSortView.this.getContext(), aoO, menuItem.getGroupId());
            }
            AppMethodBeat.m2505o(14060);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView$a */
    public interface C11206a {
        boolean aWe();
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView$b */
    public static class C11207b {
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
        AppMethodBeat.m2504i(14062);
        setShowFooterView(false);
        refresh();
        C42792c c42792c = this.jMM;
        if (!c42792c.jKu.contains(this)) {
            C4990ab.m7416i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
            c42792c.jKu.add(this);
        }
        this.jMO = new C24088a(getContext());
        setDataSetObserver(this);
        setOnItemClickListener(new C112021());
        setOnItemLongClickListener(this);
        AppMethodBeat.m2505o(14062);
    }

    public void setReturnResult(boolean z) {
        this.jLH = z;
    }

    public final void refresh() {
        AppMethodBeat.m2504i(14063);
        this.jMM.init();
        mo70141dJ(BrandServiceSortView.m18914aV(this.jMM.mo68262rY(this.jMN)));
        super.refresh();
        AppMethodBeat.m2505o(14063);
    }

    /* renamed from: aV */
    private static List<C36087d> m18914aV(List<C30201lk> list) {
        AppMethodBeat.m2504i(14064);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C30201lk c30201lk = (C30201lk) list.get(i2);
                    if (!(c30201lk == null || c30201lk.ehM == null)) {
                        C36087d c36087d = new C36087d();
                        c36087d.data = c30201lk;
                        i = c30201lk.ehM.field_showHead;
                        if (i >= 97 && i <= 122) {
                            i -= 32;
                        }
                        if (i < 65 || i > 90) {
                            c36087d.yDG = "#";
                        } else {
                            c36087d.yDG = ((char) i);
                        }
                        arrayList.add(c36087d);
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(14064);
                    return arrayList;
                }
            }
        }
        AppMethodBeat.m2505o(14064);
        return null;
    }

    public final void release() {
        AppMethodBeat.m2504i(14065);
        if (C1720g.m3531RK()) {
            C41747z.afb().aeL();
        }
        this.jMM.release();
        AppMethodBeat.m2505o(14065);
    }

    /* renamed from: a */
    public final boolean mo22884a(String str, C36087d c36087d) {
        AppMethodBeat.m2504i(14066);
        if (!(C5046bo.isNullOrNil(str) || c36087d == null)) {
            this.jMS = str;
            C30201lk c30201lk = (C30201lk) c36087d.data;
            if (c30201lk == null || c30201lk.ehM == null) {
                C4990ab.m7420w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
                AppMethodBeat.m2505o(14066);
                return false;
            }
            C7616ad c7616ad = c30201lk.ehM;
            String Oj = c7616ad.mo16707Oj();
            String Ht = c7616ad.mo14676Ht();
            String Hu = c7616ad.mo14677Hu();
            String toUpperCase = str.toUpperCase();
            if (!(C5046bo.isNullOrNil(Oj) || Oj.toUpperCase().indexOf(toUpperCase) == -1) || (!(C5046bo.isNullOrNil(Ht) || Ht.toUpperCase().indexOf(toUpperCase) == -1) || (!C5046bo.isNullOrNil(Hu) && Hu.toUpperCase().startsWith(toUpperCase)))) {
                AppMethodBeat.m2505o(14066);
                return true;
            }
        }
        AppMethodBeat.m2505o(14066);
        return false;
    }

    public final View inflate() {
        AppMethodBeat.m2504i(14067);
        View inflate = View.inflate(getContext(), 2130968887, this);
        AppMethodBeat.m2505o(14067);
        return inflate;
    }

    public VerticalScrollBar getScrollBar() {
        AppMethodBeat.m2504i(14068);
        VerticalScrollBar verticalScrollBar = (VerticalScrollBar) findViewById(2131821699);
        AppMethodBeat.m2505o(14068);
        return verticalScrollBar;
    }

    public ListView getListView() {
        AppMethodBeat.m2504i(14069);
        this.jMQ = (ListView) findViewById(2131821698);
        if (this.jMT == null) {
            this.jMT = BrandServiceSortView.inflate(getContext(), 2130969246, null);
            if (!(this.jMQ == null || this.jMT == null)) {
                this.jMU = (TextView) this.jMT.findViewById(2131823158);
                this.jMQ.addFooterView(this.jMT, null, false);
            }
        }
        ListView listView = this.jMQ;
        AppMethodBeat.m2505o(14069);
        return listView;
    }

    public View getNoResultView() {
        AppMethodBeat.m2504i(14070);
        View findViewById = findViewById(2131821905);
        AppMethodBeat.m2505o(14070);
        return findViewById;
    }

    public C15543a getItemViewCreator() {
        AppMethodBeat.m2504i(14071);
        C112032 c112032 = new C112032();
        AppMethodBeat.m2505o(14071);
        return c112032;
    }

    public final void aVU() {
        AppMethodBeat.m2504i(14072);
        refresh();
        AppMethodBeat.m2505o(14072);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(14073);
        if (motionEvent.getAction() == 0) {
            this.jLX = (int) motionEvent.getRawX();
            this.jLY = (int) motionEvent.getRawY();
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(14073);
        return dispatchTouchEvent;
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(14074);
        this.jMO.zRY = view;
        this.jMO.mo39885a(adapterView, i, j, this, this.jMV, this.jLX, this.jLY);
        AppMethodBeat.m2505o(14074);
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(14075);
        if (contextMenuInfo == null) {
            C4990ab.m7416i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
            AppMethodBeat.m2505o(14075);
            return;
        }
        C4990ab.m7416i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        C36087d c36087d = (C36087d) ((AdapterView) view).getItemAtPosition(adapterContextMenuInfo.position);
        if (c36087d == null || c36087d.data == null) {
            C4990ab.m7417i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", c36087d);
            AppMethodBeat.m2505o(14075);
            return;
        }
        C7616ad c7616ad = ((C30201lk) c36087d.data).ehM;
        if (c7616ad == null) {
            C4990ab.m7412e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
            AppMethodBeat.m2505o(14075);
            return;
        }
        this.igi = c7616ad.field_username;
        contextMenu.setHeaderTitle(C44089j.m79292b(getContext(), c7616ad.mo16707Oj()));
        C16527d qX = C17903f.m28104qX(c7616ad.field_username);
        if (!(qX == null || qX.adO())) {
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, C25738R.string.cvi);
        }
        AppMethodBeat.m2505o(14075);
    }

    /* renamed from: aW */
    public final void mo22886aW(List<C36087d> list) {
        AppMethodBeat.m2504i(14076);
        if (!(this.jMU == null || list == null)) {
            this.jMU.setText(getContext().getString(C25738R.string.ab7, new Object[]{Integer.valueOf(list.size())}));
        }
        AppMethodBeat.m2505o(14076);
    }

    public void setShowFooterView(boolean z) {
        AppMethodBeat.m2504i(14077);
        this.aeV = z;
        BaseSortView.m79989x(this.jMU, z);
        AppMethodBeat.m2505o(14077);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(14078);
        if (this.jMR != null) {
            this.jMR.aWe();
        }
        if (super.onInterceptTouchEvent(motionEvent)) {
            AppMethodBeat.m2505o(14078);
            return true;
        }
        AppMethodBeat.m2505o(14078);
        return false;
    }

    public C11206a getITransferToChildOnTouchListener() {
        return this.jMR;
    }

    public void setITransferToChildOnTouchListener(C11206a c11206a) {
        this.jMR = c11206a;
    }
}
