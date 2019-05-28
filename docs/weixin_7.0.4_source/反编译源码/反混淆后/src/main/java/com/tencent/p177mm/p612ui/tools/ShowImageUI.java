package com.tencent.p177mm.p612ui.tools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.MultiTouchImageView;
import com.tencent.p177mm.p612ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.gif.C3276f;
import com.tencent.p177mm.plugin.gif.C39243k;
import com.tencent.p177mm.plugin.gif.MMAnimateView;
import com.tencent.p177mm.pluginsdk.model.C40443e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.tools.ShowImageUI */
public class ShowImageUI extends MMActivity {
    private MMGestureGallery kkn;
    private boolean zHE;
    private C15941a zHF;
    private boolean zHG;

    /* renamed from: com.tencent.mm.ui.tools.ShowImageUI$a */
    class C15941a extends BaseAdapter {
        String imagePath;

        private C15941a() {
        }

        /* synthetic */ C15941a(ShowImageUI showImageUI, byte b) {
            this();
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(34995);
            if (C5063r.amo(this.imagePath)) {
                Context context = viewGroup.getContext();
                String str = this.imagePath;
                C3276f c3276f = new C3276f(str);
                if (view == null || !(view instanceof MMAnimateView)) {
                    view = new MMAnimateView(context);
                } else {
                    MMAnimateView mMAnimateView = (MMAnimateView) view;
                }
                view.mo46176eE(str, str);
                view.mo46173a(str, new C39243k() {
                    public final void invalidate() {
                        AppMethodBeat.m2504i(34994);
                        view.invalidate();
                        AppMethodBeat.m2505o(34994);
                    }
                });
                view.stop();
                view.start();
                AppMethodBeat.m2505o(34995);
            } else {
                Bitmap vv = C18764x.m29333vv(this.imagePath);
                if (vv == null) {
                    C4990ab.m7420w("MicroMsg.ShowImageUI", "get image fail");
                    if (view == null || (view instanceof MultiTouchImageView)) {
                        view = View.inflate(viewGroup.getContext(), 2130970678, null);
                    }
                    ((ImageView) view.findViewById(2131822184)).setImageResource(C1318a.download_image_icon);
                    view.setLayoutParams(new LayoutParams(-1, -1));
                    AppMethodBeat.m2505o(34995);
                } else {
                    Context context2 = viewGroup.getContext();
                    if (view == null || !(view instanceof MultiTouchImageView)) {
                        view = new MultiTouchImageView(context2, vv.getWidth(), vv.getHeight());
                    } else {
                        MultiTouchImageView view2 = (MultiTouchImageView) view2;
                        view2.mo71980bW(vv.getWidth(), vv.getHeight());
                    }
                    view2.setLayoutParams(new LayoutParams(-1, -1));
                    view2.setImageBitmap(vv);
                    view2.setMaxZoomDoubleTab(true);
                    AppMethodBeat.m2505o(34995);
                }
            }
            return view2;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShowImageUI$1 */
    class C240421 implements OnMenuItemClickListener {
        C240421() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34991);
            ShowImageUI.this.finish();
            AppMethodBeat.m2505o(34991);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.ShowImageUI$2 */
    class C240432 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.ui.tools.ShowImageUI$2$1 */
        class C240441 implements C30382d {
            C240441() {
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(34992);
                switch (i2) {
                    case 0:
                        ShowImageUI.m37004b(ShowImageUI.this);
                        AppMethodBeat.m2505o(34992);
                        return;
                    case 1:
                        ShowImageUI showImageUI = ShowImageUI.this;
                        C45316cl c45316cl = new C45316cl();
                        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
                        if (-1 == longExtra) {
                            C4990ab.m7420w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                            C40443e.m69368a(c45316cl, showImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), showImageUI.getIntent().getStringExtra("key_image_path"));
                        } else {
                            C40443e.m69369a(c45316cl, longExtra);
                        }
                        c45316cl.cvA.activity = showImageUI;
                        C4879a.xxA.mo10055m(c45316cl);
                        AppMethodBeat.m2505o(34992);
                        return;
                    case 2:
                        ShowImageUI.m37005c(ShowImageUI.this);
                        AppMethodBeat.m2505o(34992);
                        return;
                    case 3:
                        ShowImageUI.m37006d(ShowImageUI.this);
                        break;
                }
                AppMethodBeat.m2505o(34992);
            }
        }

        C240432() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(34993);
            List linkedList = new LinkedList();
            List linkedList2 = new LinkedList();
            if (ShowImageUI.this.zHE && C25985d.afj("favorite")) {
                linkedList2.add(Integer.valueOf(0));
                linkedList.add(ShowImageUI.this.getString(C25738R.string.dr8));
                linkedList2.add(Integer.valueOf(1));
                linkedList.add(ShowImageUI.this.getString(C25738R.string.dcq));
                linkedList2.add(Integer.valueOf(2));
                linkedList.add(ShowImageUI.this.getString(C25738R.string.dwz));
            } else {
                linkedList2.add(Integer.valueOf(0));
                linkedList.add(ShowImageUI.this.getString(C25738R.string.dr8));
                linkedList2.add(Integer.valueOf(2));
                linkedList.add(ShowImageUI.this.getString(C25738R.string.dwz));
            }
            C9321dq c9321dq = new C9321dq();
            c9321dq.cxc.cvx = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1);
            C4879a.xxA.mo10055m(c9321dq);
            if (c9321dq.cxd.cwB) {
                linkedList2.add(Integer.valueOf(3));
                linkedList.add(ShowImageUI.this.getString(C25738R.string.amc));
            }
            C30379h.m48420a(ShowImageUI.this, "", linkedList, linkedList2, "", false, new C240441());
            AppMethodBeat.m2505o(34993);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130970677;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34996);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.zHE = getIntent().getBooleanExtra("key_favorite", false);
        this.zHG = getIntent().getBooleanExtra("show_menu", true);
        this.kkn = (MMGestureGallery) findViewById(2131822081);
        this.kkn.setVerticalFadingEdgeEnabled(false);
        this.kkn.setHorizontalFadingEdgeEnabled(false);
        this.zHF = new C15941a(this, (byte) 0);
        this.zHF.imagePath = getIntent().getStringExtra("key_image_path");
        this.kkn.setAdapter(this.zHF);
        setBackBtn(new C240421());
        if (this.zHG) {
            addIconOptionMenu(0, C1318a.ofm_send_icon, new C240432());
        }
        AppMethodBeat.m2505o(34996);
    }

    /* renamed from: b */
    static /* synthetic */ void m37004b(ShowImageUI showImageUI) {
        AppMethodBeat.m2504i(34997);
        String stringExtra = showImageUI.getIntent().getStringExtra("key_image_path");
        int intExtra = showImageUI.getIntent().getIntExtra("key_compress_type", 0);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", longExtra);
        C9638aw.m17190ZK();
        C7620bi jf = C18628c.m29080XO().mo15340jf(longExtra);
        C8910b me = C8910b.m16064me(jf.field_content);
        if (C5063r.amo(stringExtra) || (jf.bAA() && me != null && me.type == 2)) {
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Msg_content", jf.field_content);
            if (me != null && me.type == 2) {
                stringExtra = C37922v.m64078nW("msg_" + jf.field_msgSvrId);
                C37922v.m64076Zp().mo60676y(stringExtra, true).mo53356j("prePublishId", "msg_" + jf.field_msgSvrId);
                intent.putExtra("reportSessionId", stringExtra);
            }
        } else {
            intent.putExtra("Retr_Msg_Type", 0);
        }
        intent.putExtra("Retr_Compress_Type", intExtra);
        showImageUI.startActivity(intent);
        AppMethodBeat.m2505o(34997);
    }

    /* renamed from: c */
    static /* synthetic */ void m37005c(ShowImageUI showImageUI) {
        AppMethodBeat.m2504i(34998);
        C14987n.m23321j(showImageUI.getIntent().getStringExtra("key_image_path"), showImageUI);
        AppMethodBeat.m2505o(34998);
    }

    /* renamed from: d */
    static /* synthetic */ void m37006d(ShowImageUI showImageUI) {
        AppMethodBeat.m2504i(34999);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", longExtra);
        showImageUI.startActivity(intent);
        AppMethodBeat.m2505o(34999);
    }
}
